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

public class babd
  extends azwo
  implements View.OnClickListener
{
  private boolean a;
  private boolean b;
  
  public babd(azxt paramazxt, azrb paramazrb)
  {
    super(paramazxt, paramazrb);
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
        azrp localazrp = (azrp)paramCard.get(j);
        k = i;
        if (!TextUtils.isEmpty(localazrp.jdField_a_of_type_JavaLangString))
        {
          k = i;
          if (localazrp.jdField_a_of_type_JavaUtilArrayList != null)
          {
            if (localazrp.jdField_a_of_type_Int != 5) {
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
          if ((localazrp.jdField_a_of_type_Int == 4) && (this.jdField_a_of_type_Birs != null))
          {
            k = i;
            if (!this.jdField_a_of_type_Birs.a(5)) {}
          }
          else if ((localazrp.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Birs != null))
          {
            k = i;
            if (!this.jdField_a_of_type_Birs.a(4)) {}
          }
          else
          {
            a(localazrp, paramLinearLayout, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
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
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80093BF", "0X80093BF", paramInt, 0, "", "", "", "");
  }
  
  private void a(azpb paramazpb)
  {
    Intent localIntent;
    if ((paramazpb.jdField_a_of_type_JavaLangObject instanceof azrp))
    {
      paramazpb = (azrp)paramazpb.jdField_a_of_type_JavaLangObject;
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramazpb.b);
      if (paramazpb.jdField_a_of_type_Int != 2) {
        break label77;
      }
      localIntent.putExtra("big_brother_source_key", "biz_src_qqmusic");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
      a(paramazpb.jdField_a_of_type_Int);
      return;
      label77:
      if (paramazpb.jdField_a_of_type_Int == 4) {
        localIntent.putExtra("big_brother_source_key", "biz_src_feeds_buluo");
      }
    }
  }
  
  private void a(azrp paramazrp, LinearLayout paramLinearLayout, Resources paramResources)
  {
    ProfileContentTitleView localProfileContentTitleView = new ProfileContentTitleView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localProfileContentTitleView.setTitle(paramazrp.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileFavorComponent", 0, String.format("addFavorItem title=%s", new Object[] { paramazrp.jdField_a_of_type_JavaLangString }));
    }
    int i = 0;
    if (i < paramazrp.jdField_a_of_type_JavaUtilArrayList.size())
    {
      azrq localazrq = (azrq)paramazrp.jdField_a_of_type_JavaUtilArrayList.get(i);
      ProfileCardFavorItemDetailView localProfileCardFavorItemDetailView = new ProfileCardFavorItemDetailView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localProfileCardFavorItemDetailView.setTitle(localazrq.jdField_a_of_type_JavaLangString);
      localProfileCardFavorItemDetailView.setContent(localazrq.d);
      localProfileCardFavorItemDetailView.setDesc(localazrq.e);
      Drawable localDrawable = paramResources.getDrawable(2131166378);
      Object localObject = localDrawable;
      if (!TextUtils.isEmpty(localazrq.b))
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.dp2px(70.0F, paramResources);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.dp2px(70.0F, paramResources);
        localObject = URLDrawable.getDrawable(localazrq.b, (URLDrawable.URLDrawableOptions)localObject);
      }
      localProfileCardFavorItemDetailView.setIcon((Drawable)localObject);
      if (!TextUtils.isEmpty(localazrq.f)) {
        localProfileCardFavorItemDetailView.a(localazrq.f, 2);
      }
      if ((localazrq.jdField_a_of_type_JavaUtilArrayList != null) && (localazrq.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        int j = 0;
        while (j < localazrq.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject = (azro)localazrq.jdField_a_of_type_JavaUtilArrayList.get(j);
          int k = Color.rgb((int)((azro)localObject).b.a, (int)((azro)localObject).b.b, (int)((azro)localObject).b.c);
          localProfileCardFavorItemDetailView.a(null, ((azro)localObject).jdField_a_of_type_JavaLangString, k, 3);
          j += 1;
        }
      }
      localProfileCardFavorItemDetailView.setBackgroundResource(2130839498);
      localProfileContentTitleView.a(localProfileCardFavorItemDetailView);
      localProfileCardFavorItemDetailView.setTag(new azpb(62, localazrq));
      localProfileCardFavorItemDetailView.setOnClickListener(this);
      if (i != 0) {}
      for (boolean bool = true;; bool = false)
      {
        localProfileCardFavorItemDetailView.setNeedTopMargin(bool);
        a(localazrq);
        a(localProfileCardFavorItemDetailView.a, localProfileCardFavorItemDetailView.b);
        a(null, localProfileCardFavorItemDetailView.c);
        i += 1;
        break;
      }
    }
    paramazrp = new azpb(61, paramazrp);
    localProfileContentTitleView.b.setTag(paramazrp);
    localProfileContentTitleView.b.setOnClickListener(this);
    paramLinearLayout.addView(localProfileContentTitleView);
    a(localProfileContentTitleView, true);
  }
  
  private void a(azrq paramazrq)
  {
    switch (paramazrq.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_Boolean);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070A9", "0X80070A9", 0, 0, "", "", "", "");
      this.jdField_b_of_type_Boolean = true;
      return;
    } while (this.jdField_a_of_type_Boolean);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070AD", "0X80070AD", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Boolean = true;
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    boolean bool1 = false;
    paramBoolean = false;
    boolean bool2 = ProfileActivity.AllInOne.i(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
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
          localLinearLayout = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561360, null, false);
          localLinearLayout.setTag(2131367412, Boolean.TRUE);
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
  
  private void b(azpb paramazpb)
  {
    Intent localIntent;
    if ((paramazpb.jdField_a_of_type_JavaLangObject instanceof azrq))
    {
      paramazpb = (azrq)paramazpb.jdField_a_of_type_JavaLangObject;
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramazpb.c);
      if (paramazpb.jdField_a_of_type_Int != 2) {
        break label74;
      }
      localIntent.putExtra("big_brother_source_key", "biz_src_qqmusic");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
      b(paramazpb);
      return;
      label74:
      if (paramazpb.jdField_a_of_type_Int == 4) {
        localIntent.putExtra("big_brother_source_key", "biz_src_feeds_buluo");
      }
    }
  }
  
  private void b(azrq paramazrq)
  {
    switch (paramazrq.jdField_a_of_type_Int)
    {
    case 3: 
    default: 
      return;
    case 2: 
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070AA", "0X80070AA", 0, 0, "", "", "", "");
      return;
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80070AE", "0X80070AE", 0, 0, "", "", "", "");
  }
  
  public int a()
  {
    return 1006;
  }
  
  public String a()
  {
    return "ProfileFavorComponent";
  }
  
  public boolean a(azrb paramazrb)
  {
    boolean bool = super.a(paramazrb);
    return a(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard, ((azrb)this.jdField_b_of_type_JavaLangObject).d) | bool;
  }
  
  public String a_()
  {
    return "map_key_favor";
  }
  
  public void onClick(View paramView)
  {
    azpb localazpb;
    if ((paramView.getTag() instanceof azpb))
    {
      localazpb = (azpb)paramView.getTag();
      switch (localazpb.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(localazpb);
      continue;
      b(localazpb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babd
 * JD-Core Version:    0.7.0.1
 */