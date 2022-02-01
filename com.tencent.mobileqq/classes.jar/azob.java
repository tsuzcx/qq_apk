import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.widget.ProfileCardFavorItemDetailView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class azob
  extends azkr
  implements View.OnClickListener
{
  private boolean a;
  private boolean b;
  
  public azob(azlw paramazlw, azfe paramazfe)
  {
    super(paramazlw, paramazfe);
  }
  
  private int a(LinearLayout paramLinearLayout, Card paramCard)
  {
    paramCard = paramCard.getBigOrderEntrys();
    int k;
    if (paramCard != null)
    {
      paramLinearLayout.removeAllViews();
      int j = 0;
      int i = 0;
      k = i;
      if (j < paramCard.size())
      {
        azft localazft = (azft)paramCard.get(j);
        k = i;
        if (!TextUtils.isEmpty(localazft.jdField_a_of_type_JavaLangString))
        {
          k = i;
          if (localazft.jdField_a_of_type_JavaUtilArrayList != null)
          {
            if (localazft.jdField_a_of_type_Int != 5) {
              break label94;
            }
            k = i;
          }
        }
        for (;;)
        {
          j += 1;
          i = k;
          break;
          label94:
          if ((localazft.jdField_a_of_type_Int == 4) && (this.jdField_a_of_type_Biab != null))
          {
            k = i;
            if (!this.jdField_a_of_type_Biab.a(5)) {}
          }
          else if ((localazft.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Biab != null))
          {
            k = i;
            if (!this.jdField_a_of_type_Biab.a(4)) {}
          }
          else
          {
            a(localazft, paramLinearLayout, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
            k = i + 1;
          }
        }
      }
    }
    else
    {
      k = 0;
    }
    return k;
  }
  
  private void a(int paramInt)
  {
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80093BF", "0X80093BF", paramInt, 0, "", "", "", "");
  }
  
  private void a(azde paramazde)
  {
    Intent localIntent;
    if ((paramazde.jdField_a_of_type_JavaLangObject instanceof azft))
    {
      paramazde = (azft)paramazde.jdField_a_of_type_JavaLangObject;
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramazde.b);
      if (paramazde.jdField_a_of_type_Int != 2) {
        break label77;
      }
      localIntent.putExtra("big_brother_source_key", "biz_src_qqmusic");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
      a(paramazde.jdField_a_of_type_Int);
      return;
      label77:
      if (paramazde.jdField_a_of_type_Int == 4) {
        localIntent.putExtra("big_brother_source_key", "biz_src_feeds_buluo");
      }
    }
  }
  
  private void a(azft paramazft, LinearLayout paramLinearLayout, Resources paramResources)
  {
    ProfileContentTitleView localProfileContentTitleView = new ProfileContentTitleView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localProfileContentTitleView.setTitle(paramazft.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileFavorComponent", 0, String.format("addFavorItem title=%s", new Object[] { paramazft.jdField_a_of_type_JavaLangString }));
    }
    int i = 0;
    if (i < paramazft.jdField_a_of_type_JavaUtilArrayList.size())
    {
      azfu localazfu = (azfu)paramazft.jdField_a_of_type_JavaUtilArrayList.get(i);
      ProfileCardFavorItemDetailView localProfileCardFavorItemDetailView = new ProfileCardFavorItemDetailView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localProfileCardFavorItemDetailView.setTitle(localazfu.jdField_a_of_type_JavaLangString);
      localProfileCardFavorItemDetailView.setContent(localazfu.d);
      localProfileCardFavorItemDetailView.setDesc(localazfu.e);
      Drawable localDrawable = paramResources.getDrawable(2131166346);
      Object localObject = localDrawable;
      if (!TextUtils.isEmpty(localazfu.b))
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = afur.a(70.0F, paramResources);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = afur.a(70.0F, paramResources);
        localObject = URLDrawable.getDrawable(localazfu.b, (URLDrawable.URLDrawableOptions)localObject);
      }
      localProfileCardFavorItemDetailView.setIcon((Drawable)localObject);
      if (!TextUtils.isEmpty(localazfu.f)) {
        localProfileCardFavorItemDetailView.a(localazfu.f, 2);
      }
      if ((localazfu.jdField_a_of_type_JavaUtilArrayList != null) && (localazfu.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        int j = 0;
        while (j < localazfu.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject = (azfs)localazfu.jdField_a_of_type_JavaUtilArrayList.get(j);
          int k = Color.rgb((int)((azfs)localObject).b.a, (int)((azfs)localObject).b.b, (int)((azfs)localObject).b.c);
          localProfileCardFavorItemDetailView.a(null, ((azfs)localObject).jdField_a_of_type_JavaLangString, k, 3);
          j += 1;
        }
      }
      localProfileCardFavorItemDetailView.setBackgroundResource(2130839434);
      localProfileContentTitleView.a(localProfileCardFavorItemDetailView);
      localProfileCardFavorItemDetailView.setTag(new azde(62, localazfu));
      localProfileCardFavorItemDetailView.setOnClickListener(this);
      if (i != 0) {}
      for (boolean bool = true;; bool = false)
      {
        localProfileCardFavorItemDetailView.setNeedTopMargin(bool);
        a(localazfu);
        a(localProfileCardFavorItemDetailView.a, localProfileCardFavorItemDetailView.b);
        a(null, localProfileCardFavorItemDetailView.c);
        i += 1;
        break;
      }
    }
    paramazft = new azde(61, paramazft);
    localProfileContentTitleView.b.setTag(paramazft);
    localProfileContentTitleView.b.setOnClickListener(this);
    paramLinearLayout.addView(localProfileContentTitleView);
    a(localProfileContentTitleView, true);
  }
  
  private void a(azfu paramazfu)
  {
    switch (paramazfu.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_Boolean);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070A9", "0X80070A9", 0, 0, "", "", "", "");
      this.jdField_b_of_type_Boolean = true;
      return;
    } while (this.jdField_a_of_type_Boolean);
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070AD", "0X80070AD", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Boolean = true;
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    boolean bool1 = false;
    paramBoolean = false;
    boolean bool2 = ProfileActivity.AllInOne.i(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if ((paramCard == null) || (bool2))
    {
      paramBoolean = bool1;
      if (this.jdField_a_of_type_JavaLangObject != null) {
        this.jdField_a_of_type_JavaLangObject = null;
      }
    }
    else
    {
      for (;;)
      {
        return true;
        LinearLayout localLinearLayout;
        if (this.jdField_a_of_type_JavaLangObject == null)
        {
          localLinearLayout = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561374, null, false);
          localLinearLayout.setTag(2131367214, Boolean.TRUE);
          this.jdField_a_of_type_JavaLangObject = localLinearLayout;
          paramBoolean = true;
        }
        while (a(localLinearLayout, paramCard) <= 0)
        {
          if (this.jdField_a_of_type_JavaLangObject == null) {
            return paramBoolean;
          }
          this.jdField_a_of_type_JavaLangObject = null;
          return true;
          localLinearLayout = (LinearLayout)this.jdField_a_of_type_JavaLangObject;
        }
      }
    }
    return paramBoolean;
  }
  
  private void b(azde paramazde)
  {
    Intent localIntent;
    if ((paramazde.jdField_a_of_type_JavaLangObject instanceof azfu))
    {
      paramazde = (azfu)paramazde.jdField_a_of_type_JavaLangObject;
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramazde.c);
      if (paramazde.jdField_a_of_type_Int != 2) {
        break label74;
      }
      localIntent.putExtra("big_brother_source_key", "biz_src_qqmusic");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
      b(paramazde);
      return;
      label74:
      if (paramazde.jdField_a_of_type_Int == 4) {
        localIntent.putExtra("big_brother_source_key", "biz_src_feeds_buluo");
      }
    }
  }
  
  private void b(azfu paramazfu)
  {
    switch (paramazfu.jdField_a_of_type_Int)
    {
    case 3: 
    default: 
      return;
    case 2: 
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070AA", "0X80070AA", 0, 0, "", "", "", "");
      return;
    }
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070AE", "0X80070AE", 0, 0, "", "", "", "");
  }
  
  public int a()
  {
    return 1006;
  }
  
  public String a()
  {
    return "ProfileFavorComponent";
  }
  
  public boolean a(azfe paramazfe)
  {
    boolean bool = super.a(paramazfe);
    return a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard, ((azfe)this.jdField_b_of_type_JavaLangObject).d) | bool;
  }
  
  public String a_()
  {
    return "map_key_favor";
  }
  
  public void onClick(View paramView)
  {
    azde localazde;
    if ((paramView.getTag() instanceof azde))
    {
      localazde = (azde)paramView.getTag();
      switch (localazde.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(localazde);
      continue;
      b(localazde);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azob
 * JD-Core Version:    0.7.0.1
 */