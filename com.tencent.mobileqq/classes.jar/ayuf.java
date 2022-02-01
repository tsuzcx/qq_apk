import QQService.EVIPSPEC;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qvip.QQLevelIconConfig;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.view.ProfileQQLevelView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ayuf
  extends ayrs
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ayug(this);
  protected boolean a;
  private boolean b;
  
  public ayuf(aysx paramaysx, aymg paramaymg)
  {
    super(paramaysx, paramaymg);
  }
  
  private void a(int paramInt)
  {
    Object localObject2;
    Object localObject1;
    String str1;
    if ((((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 40) || (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58))
    {
      localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromfujinderen";
      localObject1 = "qita";
      if ((((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label564;
      }
      str1 = bgev.a("vipPersonalCardMaster");
      label111:
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        break label591;
      }
    }
    label181:
    label585:
    label591:
    for (String str2 = ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;; str2 = "0")
    {
      StringBuilder localStringBuilder = new StringBuilder(str1);
      if (str1.contains("?"))
      {
        localStringBuilder.append("&platform=1");
        localStringBuilder.append("&qq=").append(str2);
        localStringBuilder.append("&adtag=").append((String)localObject1);
        localStringBuilder.append("&aid=").append((String)localObject2);
        if (paramInt == 1) {
          localStringBuilder.append("&jumplevelset=1");
        }
        localObject1 = localStringBuilder.toString();
        long l = System.currentTimeMillis();
        if (ProfileActivity.a(this.jdField_a_of_type_Long, l))
        {
          this.jdField_a_of_type_Long = l;
          if (QLog.isColorLevel()) {
            QLog.d("ProfileAccountLevelComponent", 2, String.format("gotoQQVipWeb url=%s", new Object[] { localObject1 }));
          }
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          ((Intent)localObject2).putExtra("hide_more_button", true);
          ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break label585;
          }
        }
      }
      for (paramInt = 23;; paramInt = 24)
      {
        bcef.b((QQAppInterface)localObject1, "CliOper", "", "", "vip", "logo_in", paramInt, 0, "", "", "", "");
        return;
        if ((((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 1) || (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
        {
          localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromqita";
          localObject1 = "geren";
          break;
        }
        if ((((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20) || (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21))
        {
          localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun";
          localObject1 = "qun";
          break;
        }
        if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46)
        {
          localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromtaolunzu";
          localObject1 = "taolunzu";
          break;
        }
        if (ProfileActivity.AllInOne.h(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromlinshihuihua";
          localObject1 = "qita";
          break;
        }
        localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromqita";
        localObject1 = "qita";
        break;
        str1 = bgev.a("vipPersonalCardCustom");
        break label111;
        localStringBuilder.append("?platform=1");
        break label181;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((aqgm.c().mIsNotifyPayment) && (paramBoolean) && (amvi.a()))
    {
      Object localObject = (bgga)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235);
      int i = ((bgga)localObject).a();
      if (QLog.isColorLevel()) {
        QLog.d("ProfileAccountLevelComponent", 2, String.format("updateNoticeView noticeValue=%s", new Object[] { Integer.valueOf(i) }));
      }
      if ((i != 0) && (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
      {
        String str = bgga.a(i);
        if (!TextUtils.isEmpty(str))
        {
          ((bgga)localObject).a(0);
          localObject = (TextView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131374150);
          ((TextView)localObject).setText(str);
          ((TextView)localObject).setVisibility(0);
          ((TextView)localObject).setOnClickListener(new ayuh(this, (TextView)localObject, i));
        }
      }
    }
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    boolean bool1 = a(paramCard);
    boolean bool2 = this.jdField_a_of_type_Bhha.a(12);
    boolean bool3 = aytq.a((aymg)this.jdField_b_of_type_JavaLangObject);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileAccountLevelComponent", 2, String.format("makeOrRefreshAccountLevel showAccountInfo=%s baseInfoABTestEnable=%s isDefaultProfile=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) }));
    }
    if ((!bool1) || ((bool2) && (bool3)))
    {
      if (this.jdField_a_of_type_JavaLangObject != null)
      {
        this.jdField_a_of_type_JavaLangObject = null;
        return true;
      }
    }
    else
    {
      if (this.jdField_a_of_type_JavaLangObject == null)
      {
        View localView = this.jdField_a_of_type_Ayyp.a(a_());
        paramCard = localView;
        if (localView == null)
        {
          paramCard = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131561362, null);
          int i = aneg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false);
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C6", "0X800A8C6", i, 0, String.valueOf(i), "", "", "");
          if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C7", "0X800A8C7", i, 0, String.valueOf(i), "", "", "");
          }
        }
        this.jdField_a_of_type_JavaLangObject = paramCard;
      }
      for (bool1 = true;; bool1 = false)
      {
        paramCard = (ProfileQQLevelView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131374151);
        paramCard.a((aymg)this.jdField_b_of_type_JavaLangObject, this.jdField_a_of_type_Boolean);
        paramCard.setClickable(false);
        a();
        a(paramBoolean);
        ((View)this.jdField_a_of_type_JavaLangObject).setTag(new aykg(69, null));
        ((View)this.jdField_a_of_type_JavaLangObject).setOnClickListener(this);
        paramCard = (ImageView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131362968);
        a((View)this.jdField_a_of_type_JavaLangObject, null, null, paramCard);
        return bool1;
      }
    }
    return false;
  }
  
  private void k()
  {
    amov localamov = (amov)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(2);
    if (localamov != null) {
      localamov.c(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
  }
  
  public int a()
  {
    return 1021;
  }
  
  public String a()
  {
    return "ProfileAccountLevelComponent";
  }
  
  protected void a()
  {
    FrameLayout localFrameLayout;
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      localFrameLayout = (FrameLayout)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131365289);
      if (localFrameLayout != null)
      {
        localFrameLayout.setOnClickListener(this);
        localFrameLayout.setTag(new aykg(100, null));
        if (!this.jdField_b_of_type_Boolean) {
          break label60;
        }
        localFrameLayout.setVisibility(0);
      }
    }
    return;
    label60:
    localFrameLayout.setVisibility(8);
  }
  
  public void a(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    paramBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    if (paramBaseActivity != null) {
      this.jdField_a_of_type_Boolean = paramBaseActivity.getBooleanExtra("key_from_ark_babyq", false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      k();
    }
  }
  
  public boolean a(aymg paramaymg)
  {
    boolean bool = super.a(paramaymg);
    return a(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard, ((aymg)this.jdField_b_of_type_JavaLangObject).d) | bool;
  }
  
  protected boolean a(Card paramCard)
  {
    boolean bool5;
    boolean bool4;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    if (this.jdField_a_of_type_Boolean)
    {
      bool5 = false;
      bool4 = false;
      bool1 = false;
      bool2 = false;
      bool3 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileAccountLevelComponent", 2, String.format("makeOrRefreshAccountLevelInfoView showAccountInfo=%s vipOpen=%s superVipOpen=%s enterprise=%s prettyNumber=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool4), Boolean.valueOf(bool5) }));
      }
      return bool3;
      if (paramCard != null)
      {
        bool1 = paramCard.isVipOpen(EVIPSPEC.E_SP_QQVIP);
        bool2 = paramCard.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
        if ((paramCard.lUserFlag & 1L) == 1L)
        {
          bool4 = true;
          label117:
          if ((paramCard.lUserFlag & 0x400) != 1024L) {
            break label175;
          }
        }
        boolean bool6;
        label175:
        for (bool5 = true;; bool5 = false)
        {
          if (!ProfileActivity.AllInOne.a(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            break label181;
          }
          bool3 = bool2;
          bool2 = bool1;
          bool6 = true;
          bool1 = bool3;
          bool3 = bool6;
          break;
          bool4 = false;
          break label117;
        }
        label181:
        if ((bool2) || (bool1) || (paramCard.iQQLevel >= 0))
        {
          bool3 = bool2;
          bool2 = bool1;
          bool6 = true;
          bool1 = bool3;
          bool3 = bool6;
        }
        else
        {
          bool3 = bool2;
          bool2 = bool1;
          bool6 = false;
          bool1 = bool3;
          bool3 = bool6;
        }
      }
      else
      {
        bool5 = false;
        bool4 = false;
        bool1 = false;
        bool2 = false;
        bool3 = false;
      }
    }
  }
  
  public String a_()
  {
    return "map_key_account_level_info";
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    super.f();
  }
  
  protected void i()
  {
    a(0);
    int j = aneg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false);
    int i;
    if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard != null) {
      if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType == 0) {
        i = 99999;
      }
    }
    for (;;)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C1", "0X800A8C1", j, 0, String.valueOf(j), "", "", "");
      if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break;
      }
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A7A", "0X8006A7A", 0, 0, "", "", "", "");
      bcef.b(null, "dc00898", "", "", "qq_vip", "0X800A775", i, 0, "", "", "", "");
      return;
      i = ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType;
      continue;
      i = 99999;
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A8E", "0X8006A8E", 0, 0, "", "", "", "");
    bcef.b(null, "dc00898", "", "", "qq_vip", "0X800A774", i, 0, "", "", "", "");
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C2", "0X800A8C2", j, 0, String.valueOf(j), "", "", "");
  }
  
  protected void j()
  {
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A9C2", "0X800A9C2", 0, 0, "", "", "", "");
    if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      a(0);
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("url", "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=card");
    localIntent.putExtra("hide_more_button", true);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
  }
  
  public void onClick(View paramView)
  {
    int j = 2;
    int i = 1;
    Object localObject = paramView.getTag();
    if ((localObject instanceof aykg)) {
      switch (((aykg)localObject).jdField_a_of_type_Int)
      {
      }
    }
    label95:
    label121:
    do
    {
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        j();
      } while (!aytq.a((aymg)this.jdField_b_of_type_JavaLangObject));
      if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        i = 1;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (i == 0) {
          break label121;
        }
      }
      for (i = 2;; i = 4)
      {
        ayuj.b((QQAppInterface)localObject, i);
        break;
        i = 0;
        break label95;
      }
      i();
    } while (!aytq.a((aymg)this.jdField_b_of_type_JavaLangObject));
    if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      label159:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (i == 0) {
        break label185;
      }
    }
    label185:
    for (i = j;; i = 4)
    {
      ayuj.a((QQAppInterface)localObject, i);
      break;
      i = 0;
      break label159;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayuf
 * JD-Core Version:    0.7.0.1
 */