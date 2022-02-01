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

public class bagr
  extends badd
  implements View.OnClickListener
{
  private boolean a;
  private boolean b;
  
  public bagr(baei parambaei, azxr paramazxr)
  {
    super(parambaei, paramazxr);
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
        azyf localazyf = (azyf)paramCard.get(j);
        k = i;
        if (!TextUtils.isEmpty(localazyf.jdField_a_of_type_JavaLangString))
        {
          k = i;
          if (localazyf.jdField_a_of_type_JavaUtilArrayList != null)
          {
            if (localazyf.jdField_a_of_type_Int != 5) {
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
          if ((localazyf.jdField_a_of_type_Int == 4) && (this.jdField_a_of_type_Bjaz != null))
          {
            k = i;
            if (!this.jdField_a_of_type_Bjaz.a(5)) {}
          }
          else if ((localazyf.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Bjaz != null))
          {
            k = i;
            if (!this.jdField_a_of_type_Bjaz.a(4)) {}
          }
          else
          {
            a(localazyf, paramLinearLayout, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
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
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80093BF", "0X80093BF", paramInt, 0, "", "", "", "");
  }
  
  private void a(azvr paramazvr)
  {
    Intent localIntent;
    if ((paramazvr.jdField_a_of_type_JavaLangObject instanceof azyf))
    {
      paramazvr = (azyf)paramazvr.jdField_a_of_type_JavaLangObject;
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramazvr.b);
      if (paramazvr.jdField_a_of_type_Int != 2) {
        break label77;
      }
      localIntent.putExtra("big_brother_source_key", "biz_src_qqmusic");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
      a(paramazvr.jdField_a_of_type_Int);
      return;
      label77:
      if (paramazvr.jdField_a_of_type_Int == 4) {
        localIntent.putExtra("big_brother_source_key", "biz_src_feeds_buluo");
      }
    }
  }
  
  private void a(azyf paramazyf, LinearLayout paramLinearLayout, Resources paramResources)
  {
    ProfileContentTitleView localProfileContentTitleView = new ProfileContentTitleView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localProfileContentTitleView.setTitle(paramazyf.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileFavorComponent", 0, String.format("addFavorItem title=%s", new Object[] { paramazyf.jdField_a_of_type_JavaLangString }));
    }
    int i = 0;
    if (i < paramazyf.jdField_a_of_type_JavaUtilArrayList.size())
    {
      azyg localazyg = (azyg)paramazyf.jdField_a_of_type_JavaUtilArrayList.get(i);
      ProfileCardFavorItemDetailView localProfileCardFavorItemDetailView = new ProfileCardFavorItemDetailView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localProfileCardFavorItemDetailView.setTitle(localazyg.jdField_a_of_type_JavaLangString);
      localProfileCardFavorItemDetailView.setContent(localazyg.d);
      localProfileCardFavorItemDetailView.setDesc(localazyg.e);
      Drawable localDrawable = paramResources.getDrawable(2131166350);
      Object localObject = localDrawable;
      if (!TextUtils.isEmpty(localazyg.b))
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = agej.a(70.0F, paramResources);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = agej.a(70.0F, paramResources);
        localObject = URLDrawable.getDrawable(localazyg.b, (URLDrawable.URLDrawableOptions)localObject);
      }
      localProfileCardFavorItemDetailView.setIcon((Drawable)localObject);
      if (!TextUtils.isEmpty(localazyg.f)) {
        localProfileCardFavorItemDetailView.a(localazyg.f, 2);
      }
      if ((localazyg.jdField_a_of_type_JavaUtilArrayList != null) && (localazyg.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        int j = 0;
        while (j < localazyg.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject = (azye)localazyg.jdField_a_of_type_JavaUtilArrayList.get(j);
          int k = Color.rgb((int)((azye)localObject).b.a, (int)((azye)localObject).b.b, (int)((azye)localObject).b.c);
          localProfileCardFavorItemDetailView.a(null, ((azye)localObject).jdField_a_of_type_JavaLangString, k, 3);
          j += 1;
        }
      }
      localProfileCardFavorItemDetailView.setBackgroundResource(2130839442);
      localProfileContentTitleView.a(localProfileCardFavorItemDetailView);
      localProfileCardFavorItemDetailView.setTag(new azvr(62, localazyg));
      localProfileCardFavorItemDetailView.setOnClickListener(this);
      if (i != 0) {}
      for (boolean bool = true;; bool = false)
      {
        localProfileCardFavorItemDetailView.setNeedTopMargin(bool);
        a(localazyg);
        a(localProfileCardFavorItemDetailView.a, localProfileCardFavorItemDetailView.b);
        a(null, localProfileCardFavorItemDetailView.c);
        i += 1;
        break;
      }
    }
    paramazyf = new azvr(61, paramazyf);
    localProfileContentTitleView.b.setTag(paramazyf);
    localProfileContentTitleView.b.setOnClickListener(this);
    paramLinearLayout.addView(localProfileContentTitleView);
    a(localProfileContentTitleView, true);
  }
  
  private void a(azyg paramazyg)
  {
    switch (paramazyg.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_Boolean);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070A9", "0X80070A9", 0, 0, "", "", "", "");
      this.jdField_b_of_type_Boolean = true;
      return;
    } while (this.jdField_a_of_type_Boolean);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070AD", "0X80070AD", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Boolean = true;
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    boolean bool1 = false;
    paramBoolean = false;
    boolean bool2 = ProfileActivity.AllInOne.i(((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
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
          localLinearLayout = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561415, null, false);
          localLinearLayout.setTag(2131367265, Boolean.TRUE);
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
  
  private void b(azvr paramazvr)
  {
    Intent localIntent;
    if ((paramazvr.jdField_a_of_type_JavaLangObject instanceof azyg))
    {
      paramazvr = (azyg)paramazvr.jdField_a_of_type_JavaLangObject;
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramazvr.c);
      if (paramazvr.jdField_a_of_type_Int != 2) {
        break label74;
      }
      localIntent.putExtra("big_brother_source_key", "biz_src_qqmusic");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
      b(paramazvr);
      return;
      label74:
      if (paramazvr.jdField_a_of_type_Int == 4) {
        localIntent.putExtra("big_brother_source_key", "biz_src_feeds_buluo");
      }
    }
  }
  
  private void b(azyg paramazyg)
  {
    switch (paramazyg.jdField_a_of_type_Int)
    {
    case 3: 
    default: 
      return;
    case 2: 
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070AA", "0X80070AA", 0, 0, "", "", "", "");
      return;
    }
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070AE", "0X80070AE", 0, 0, "", "", "", "");
  }
  
  public int a()
  {
    return 1006;
  }
  
  public String a()
  {
    return "ProfileFavorComponent";
  }
  
  public boolean a(azxr paramazxr)
  {
    boolean bool = super.a(paramazxr);
    return a(((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard, ((azxr)this.jdField_b_of_type_JavaLangObject).d) | bool;
  }
  
  public String a_()
  {
    return "map_key_favor";
  }
  
  public void onClick(View paramView)
  {
    azvr localazvr;
    if ((paramView.getTag() instanceof azvr))
    {
      localazvr = (azvr)paramView.getTag();
      switch (localazvr.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(localazvr);
      continue;
      b(localazvr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagr
 * JD-Core Version:    0.7.0.1
 */