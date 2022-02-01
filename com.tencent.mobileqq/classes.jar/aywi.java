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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.widget.ProfileCardFavorItemDetailView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class aywi
  extends ayrs
  implements View.OnClickListener
{
  private boolean a;
  private boolean b;
  
  public aywi(aysx paramaysx, aymg paramaymg)
  {
    super(paramaysx, paramaymg);
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
        aymu localaymu = (aymu)paramCard.get(j);
        k = i;
        if (!TextUtils.isEmpty(localaymu.jdField_a_of_type_JavaLangString))
        {
          k = i;
          if (localaymu.jdField_a_of_type_JavaUtilArrayList != null)
          {
            if (localaymu.jdField_a_of_type_Int != 5) {
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
          if ((localaymu.jdField_a_of_type_Int == 4) && (this.jdField_a_of_type_Bhha != null))
          {
            k = i;
            if (!this.jdField_a_of_type_Bhha.a(5)) {}
          }
          else if ((localaymu.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Bhha != null))
          {
            k = i;
            if (!this.jdField_a_of_type_Bhha.a(4)) {}
          }
          else
          {
            a(localaymu, paramLinearLayout, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
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
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80093BF", "0X80093BF", paramInt, 0, "", "", "", "");
  }
  
  private void a(aykg paramaykg)
  {
    Intent localIntent;
    if ((paramaykg.jdField_a_of_type_JavaLangObject instanceof aymu))
    {
      paramaykg = (aymu)paramaykg.jdField_a_of_type_JavaLangObject;
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramaykg.b);
      if (paramaykg.jdField_a_of_type_Int != 2) {
        break label77;
      }
      localIntent.putExtra("big_brother_source_key", "biz_src_qqmusic");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
      a(paramaykg.jdField_a_of_type_Int);
      return;
      label77:
      if (paramaykg.jdField_a_of_type_Int == 4) {
        localIntent.putExtra("big_brother_source_key", "biz_src_feeds_buluo");
      }
    }
  }
  
  private void a(aymu paramaymu, LinearLayout paramLinearLayout, Resources paramResources)
  {
    ProfileContentTitleView localProfileContentTitleView = new ProfileContentTitleView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localProfileContentTitleView.setTitle(paramaymu.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileFavorComponent", 0, String.format("addFavorItem title=%s", new Object[] { paramaymu.jdField_a_of_type_JavaLangString }));
    }
    int i = 0;
    if (i < paramaymu.jdField_a_of_type_JavaUtilArrayList.size())
    {
      aymv localaymv = (aymv)paramaymu.jdField_a_of_type_JavaUtilArrayList.get(i);
      ProfileCardFavorItemDetailView localProfileCardFavorItemDetailView = new ProfileCardFavorItemDetailView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localProfileCardFavorItemDetailView.setTitle(localaymv.jdField_a_of_type_JavaLangString);
      localProfileCardFavorItemDetailView.setContent(localaymv.d);
      localProfileCardFavorItemDetailView.setDesc(localaymv.e);
      Drawable localDrawable = paramResources.getDrawable(2131166369);
      Object localObject = localDrawable;
      if (!TextUtils.isEmpty(localaymv.b))
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.dp2px(70.0F, paramResources);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.dp2px(70.0F, paramResources);
        localObject = URLDrawable.getDrawable(localaymv.b, (URLDrawable.URLDrawableOptions)localObject);
      }
      localProfileCardFavorItemDetailView.setIcon((Drawable)localObject);
      if (!TextUtils.isEmpty(localaymv.f)) {
        localProfileCardFavorItemDetailView.a(localaymv.f, 2);
      }
      if ((localaymv.jdField_a_of_type_JavaUtilArrayList != null) && (localaymv.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        int j = 0;
        while (j < localaymv.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject = (aymt)localaymv.jdField_a_of_type_JavaUtilArrayList.get(j);
          int k = Color.rgb((int)((aymt)localObject).b.a, (int)((aymt)localObject).b.b, (int)((aymt)localObject).b.c);
          localProfileCardFavorItemDetailView.a(null, ((aymt)localObject).jdField_a_of_type_JavaLangString, k, 3);
          j += 1;
        }
      }
      localProfileCardFavorItemDetailView.setBackgroundResource(2130839477);
      localProfileContentTitleView.a(localProfileCardFavorItemDetailView);
      localProfileCardFavorItemDetailView.setTag(new aykg(62, localaymv));
      localProfileCardFavorItemDetailView.setOnClickListener(this);
      if (i != 0) {}
      for (boolean bool = true;; bool = false)
      {
        localProfileCardFavorItemDetailView.setNeedTopMargin(bool);
        a(localaymv);
        a(localProfileCardFavorItemDetailView.a, localProfileCardFavorItemDetailView.b);
        a(null, localProfileCardFavorItemDetailView.c);
        i += 1;
        break;
      }
    }
    paramaymu = new aykg(61, paramaymu);
    localProfileContentTitleView.b.setTag(paramaymu);
    localProfileContentTitleView.b.setOnClickListener(this);
    paramLinearLayout.addView(localProfileContentTitleView);
    a(localProfileContentTitleView, true);
  }
  
  private void a(aymv paramaymv)
  {
    switch (paramaymv.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_Boolean);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070A9", "0X80070A9", 0, 0, "", "", "", "");
      this.jdField_b_of_type_Boolean = true;
      return;
    } while (this.jdField_a_of_type_Boolean);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070AD", "0X80070AD", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Boolean = true;
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    boolean bool1 = false;
    paramBoolean = false;
    boolean bool2 = ProfileActivity.AllInOne.i(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
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
          localLinearLayout = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561299, null, false);
          localLinearLayout.setTag(2131367288, Boolean.TRUE);
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
  
  private void b(aykg paramaykg)
  {
    Intent localIntent;
    if ((paramaykg.jdField_a_of_type_JavaLangObject instanceof aymv))
    {
      paramaykg = (aymv)paramaykg.jdField_a_of_type_JavaLangObject;
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramaykg.c);
      if (paramaykg.jdField_a_of_type_Int != 2) {
        break label74;
      }
      localIntent.putExtra("big_brother_source_key", "biz_src_qqmusic");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
      b(paramaykg);
      return;
      label74:
      if (paramaykg.jdField_a_of_type_Int == 4) {
        localIntent.putExtra("big_brother_source_key", "biz_src_feeds_buluo");
      }
    }
  }
  
  private void b(aymv paramaymv)
  {
    switch (paramaymv.jdField_a_of_type_Int)
    {
    case 3: 
    default: 
      return;
    case 2: 
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070AA", "0X80070AA", 0, 0, "", "", "", "");
      return;
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070AE", "0X80070AE", 0, 0, "", "", "", "");
  }
  
  public int a()
  {
    return 1006;
  }
  
  public String a()
  {
    return "ProfileFavorComponent";
  }
  
  public boolean a(aymg paramaymg)
  {
    boolean bool = super.a(paramaymg);
    return a(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard, ((aymg)this.jdField_b_of_type_JavaLangObject).d) | bool;
  }
  
  public String a_()
  {
    return "map_key_favor";
  }
  
  public void onClick(View paramView)
  {
    aykg localaykg;
    if ((paramView.getTag() instanceof aykg))
    {
      localaykg = (aykg)paramView.getTag();
      switch (localaykg.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(localaykg);
      continue;
      b(localaykg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywi
 * JD-Core Version:    0.7.0.1
 */