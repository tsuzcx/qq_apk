import SummaryCardTaf.SSummaryCardRsp;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.1;
import com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.6;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class ayyb
  extends ayrt
{
  private int jdField_a_of_type_Int;
  private DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new ayyc(this);
  private bhht jdField_a_of_type_Bhht;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ayye(this);
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AbsVasProfileHeaderComponent.1(this);
  private String jdField_a_of_type_JavaLangString;
  private DialogInterface.OnClickListener b;
  
  public ayyb(aysx paramaysx, aymg paramaymg)
  {
    super(paramaysx, paramaymg);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new ayyd(this);
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    l();
    k();
    bfrj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong1, paramLong2, null, paramLong3, paramString);
    this.jdField_a_of_type_Bjng.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
  }
  
  private void a(SSummaryCardRsp paramSSummaryCardRsp)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
    {
      if (TextUtils.isEmpty(paramSSummaryCardRsp.strActiveCardUrl)) {
        break label142;
      }
      if (!QLog.isColorLevel()) {
        break label94;
      }
      QLog.e("QVipProfileCard.AbsVasProfileHeaderComponent", 1, "set friend profile card failed code=" + paramSSummaryCardRsp.res + " bgid=" + paramSSummaryCardRsp.bgid + " and jump to " + paramSSummaryCardRsp.strActiveCardUrl);
    }
    for (;;)
    {
      bfrj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramSSummaryCardRsp.bgid, paramSSummaryCardRsp.strActiveCardUrl);
      return;
      label94:
      QLog.e("QVipProfileCard.AbsVasProfileHeaderComponent", 1, "set friend profile card failed code=" + paramSSummaryCardRsp.res + " bgid=" + paramSSummaryCardRsp.bgid + " and jump to url");
    }
    label142:
    i();
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698101);
    String str2 = paramSSummaryCardRsp.emsg;
    int i = paramSSummaryCardRsp.payType;
    String str3 = paramSSummaryCardRsp.aid;
    if ((TextUtils.isEmpty(str3)) || (i <= 0) || (i == 3) || (i > 7))
    {
      QLog.e("QVipProfileCard.AbsVasProfileHeaderComponent", 1, "set friend profile card failed code=" + paramSSummaryCardRsp.res + " and aid=" + str3 + " pay type=" + i);
      Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131694699, 0).show();
      return;
    }
    QLog.e("QVipProfileCard.AbsVasProfileHeaderComponent", 1, "set friend profile card show:" + str2 + " and aid=" + str3 + " pay type=" + i);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, str1, str2, 2131694639, 2131694640, new ayyg(this, str3, i), this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void a(String paramString)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView instanceof ProfileBaseView)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(str))
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "card_mall", "0X8004435", 0, 0, Long.toString(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), "", "", VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str));
      b(str);
      return;
    }
    a(paramString, str);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "card_mall", "0X80047F0", 0, 0, Integer.toString(ProfileActivity.a(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Long.toString(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), "", VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str));
    str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131716238);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "", "0X800A4C0", 0, 0, "", "", "", "");
    bjnw localbjnw = bjnw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localbjnw.a(2131716375, 1);
    localbjnw.a(str, 1);
    localbjnw.a(2131690620, 1);
    localbjnw.a(new ayyf(this, localbjnw, paramString));
    try
    {
      localbjnw.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ("CLICK_HEADER_BG".equals(paramString1))
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "card_mall", "0X80047F1", 0, 0, "1", "", "", VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2));
      if ((((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == aymn.j) || (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == aymn.i)) {
        VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clkbkgd_visitor", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), String.valueOf(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId));
      }
    }
    while (!"CLICK_BANNER".equals(paramString1)) {
      return;
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "card_mall", "0X80047F1", 0, 0, "2", "", "", VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2));
  }
  
  private boolean a(long paramLong1, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, long paramLong2)
  {
    amsw localamsw = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Card localCard = localamsw.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin());
    if ((localCard != null) && (paramLong1 >= 0L))
    {
      localCard.lCurrentStyleId = paramLong1;
      localCard.lCurrentBgId = paramInt1;
      localCard.strCurrentBgUrl = paramString1;
      localCard.backgroundColor = paramInt2;
      localCard.templateRet = paramInt3;
      localCard.cardId = paramLong2;
      if (TextUtils.isEmpty(localCard.diyComplicatedInfo)) {
        localCard.diyComplicatedInfo = paramString2;
      }
      if (!localamsw.a(localCard))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AbsVasProfileHeaderComponent", 4, "save card in db failed ");
        }
        return false;
      }
      return true;
    }
    return false;
  }
  
  private String b()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return this.jdField_a_of_type_JavaLangString;
    }
    ThreadManager.post(new AbsVasProfileHeaderComponent.6(this), 8, null, true);
    return "-1";
  }
  
  private void b(String paramString)
  {
    if ((((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == aymn.j) || (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == aymn.i)) {
      VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clkbkgd_owner", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), String.valueOf(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId));
    }
    String str;
    StringBuilder localStringBuilder;
    if (((aymg)this.jdField_b_of_type_JavaLangObject).b)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localStringBuilder = new StringBuilder().append("");
      if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label203;
      }
    }
    label203:
    for (int i = 1;; i = 2)
    {
      VasWebviewUtil.reportCommercialDrainage(str, "group_card", "click_cover", "", 0, 0, 0, "", "", i, "", "", "", "", 0, 0, 0, 0);
      bfrj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString, "inside.myCardBackground", 1, 0, 1, "", true);
      return;
    }
  }
  
  private void j()
  {
    bfrj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId, ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.strActiveUrl);
    if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "card_mall", "0X8007A48", 0, 0, "0", "", "", "");
      return;
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "card_mall", "0X8007A48", 0, 0, "1", "", "", "");
  }
  
  private void k()
  {
    try
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
      {
        this.jdField_a_of_type_Bhht = new bhht(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        this.jdField_a_of_type_Bhht.setCancelable(false);
        this.jdField_a_of_type_Bhht.c(2131694701);
        this.jdField_a_of_type_Bhht.show();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bhht.dismiss();
      label24:
      this.jdField_a_of_type_Bhht = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  private void m()
  {
    String str1;
    String str2;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
    {
      i();
      if (this.jdField_a_of_type_Int != 1) {
        break label74;
      }
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694648);
      str2 = amtj.a(2131704049);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, str1, str2, 2131694639, 2131694640, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      label74:
      if (this.jdField_a_of_type_Int == 2)
      {
        str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694641);
        str2 = amtj.a(2131704055);
      }
      else if (this.jdField_a_of_type_Int == 3)
      {
        str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698101);
        str2 = amtj.a(2131704027);
      }
      else if (this.jdField_a_of_type_Int == 4)
      {
        str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718952);
        str2 = "开通QQ大会员即可使用该名片";
      }
      else
      {
        str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694641);
        str2 = amtj.a(2131704059);
      }
    }
  }
  
  public final int a()
  {
    return 1002;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      return;
    }
    paramIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, FriendProfileCardActivity.class);
    paramIntent.putExtra("AllInOne", new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0));
    paramIntent.putExtra("diyTextEditResult", true);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  protected void a(Message paramMessage)
  {
    super.a(paramMessage);
    if (paramMessage.what == 13)
    {
      if (!((Boolean)paramMessage.obj).booleanValue()) {
        break label106;
      }
      paramMessage = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      paramMessage.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
      paramMessage.g = 1;
      paramMessage.jdField_h_of_type_Int = 5;
      if ((this.jdField_b_of_type_JavaLangObject != null) && (!((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramMessage);
      }
    }
    return;
    label106:
    Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), 2131694702, 0).show();
  }
  
  public void a(FrameLayout paramFrameLayout)
  {
    super.a(paramFrameLayout);
    paramFrameLayout.setTag(new aykg(29, null));
    paramFrameLayout.setOnClickListener(this);
  }
  
  protected void b(Message paramMessage)
  {
    super.b(paramMessage);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_JavaLangObject != null) {
      ((FrameLayout)this.jdField_a_of_type_JavaLangObject).setOnClickListener(null);
    }
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if ((paramView.getTag() instanceof aykg)) {
      localObject = (aykg)paramView.getTag();
    }
    switch (((aykg)localObject).jdField_a_of_type_Int)
    {
    default: 
    case 34: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        j();
      }
    }
    if ((((aykg)localObject).jdField_a_of_type_JavaLangObject instanceof String)) {}
    for (Object localObject = (String)((aykg)localObject).jdField_a_of_type_JavaLangObject;; localObject = "CLICK_HEADER_BG")
    {
      a((String)localObject);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayyb
 * JD-Core Version:    0.7.0.1
 */