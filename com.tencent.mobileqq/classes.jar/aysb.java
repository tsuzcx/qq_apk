import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PullToZoomHeaderListView;
import java.util.ArrayList;
import java.util.Iterator;

public class aysb
  extends ayrt
{
  private adkk jdField_a_of_type_Adkk;
  private ayua jdField_a_of_type_Ayua;
  private ayui jdField_a_of_type_Ayui;
  private bhha jdField_a_of_type_Bhha;
  private PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private boolean jdField_a_of_type_Boolean;
  
  public aysb(aysx paramaysx, aymg paramaymg)
  {
    super(paramaysx, paramaymg);
  }
  
  private void a(int paramInt)
  {
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A88A", "0X800A88A", paramInt, 0, "", "", "", "");
  }
  
  private void a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.b);
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a == 0) {}
    for (int i = ((aymg)this.b).jdField_a_of_type_ComTencentMobileqqDataCard.defaultCardId;; i = 0)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, CardPicGalleryActivity.class);
      localIntent.putExtra("extra_mode", 2);
      localIntent.putExtra("is_from_mine_profile", paramBoolean);
      localIntent.putStringArrayListExtra("business_card_pics", localArrayList);
      localIntent.putExtra("default_card_id", i);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.b)) {
        localIntent.putExtra("extra_default", 2130845645);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130772309, 0);
      return;
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Adkk == null) {
      this.jdField_a_of_type_Adkk = new adkk(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, new aysc(this));
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Adkk != null)
    {
      this.jdField_a_of_type_Adkk.a();
      this.jdField_a_of_type_Adkk = null;
    }
  }
  
  private void k()
  {
    if ((!ProfileActivity.AllInOne.g(((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
    {
      l();
      if (((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != 0) {
        break label98;
      }
    }
    label98:
    for (int i = 1;; i = 2)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A889", "0X800A889", i, 0, "", "", "", "");
      return;
      a(false);
      break;
    }
  }
  
  private void l()
  {
    bjnw localbjnw = (bjnw)bjon.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.b)) {
      localArrayList.add(new aysd(this, 2131693044));
    }
    localArrayList.add(new ayse(this, 2131693042));
    localArrayList.add(new aysf(this, 2131693040));
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      localbjnw.b(((bgaf)localIterator.next()).a);
    }
    localbjnw.c(2131690620);
    localbjnw.a(new aysg(this, localArrayList, localbjnw));
    try
    {
      localbjnw.show();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ProfileHeaderBaseComponent", 2, "showProfileCoverActionSheet fail.", localException);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Ayua == null)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.findViewById(2131373949);
      this.jdField_a_of_type_Ayua = ((ayua)aysv.a(1024, this.jdField_a_of_type_Aysx, (aymg)this.b));
      this.jdField_a_of_type_Ayua.a(this.jdField_a_of_type_Aysa, this.jdField_a_of_type_Bhha, null);
      this.jdField_a_of_type_Ayua.a(localView);
      this.jdField_a_of_type_Ayua.g();
      a(this.jdField_a_of_type_Ayua);
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_Ayua != null)
    {
      b(this.jdField_a_of_type_Ayua);
      this.jdField_a_of_type_Ayua.h();
      this.jdField_a_of_type_Ayua = null;
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Ayui == null)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.findViewById(2131373951);
      this.jdField_a_of_type_Ayui = ((ayui)aysv.a(1022, this.jdField_a_of_type_Aysx, (aymg)this.b));
      this.jdField_a_of_type_Ayui.a(this.jdField_a_of_type_Aysa, this.jdField_a_of_type_Bhha, null);
      this.jdField_a_of_type_Ayui.a(localView);
      this.jdField_a_of_type_Ayui.g();
      a(this.jdField_a_of_type_Ayui);
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Ayui != null)
    {
      b(this.jdField_a_of_type_Ayui);
      this.jdField_a_of_type_Ayui.h();
      this.jdField_a_of_type_Ayui = null;
    }
  }
  
  public int a()
  {
    return 1002;
  }
  
  public String a()
  {
    return "ProfileHeaderBaseComponent";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView == null)
    {
      ProfileBaseView localProfileBaseView = new ProfileBaseView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (aymg)this.b);
      localProfileBaseView.setProfileArgs(this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView, this.jdField_a_of_type_Boolean);
      localProfileBaseView.setClickListener(this);
      localProfileBaseView.a();
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView = localProfileBaseView;
      ((FrameLayout)this.jdField_a_of_type_JavaLangObject).removeAllViews();
      ((FrameLayout)this.jdField_a_of_type_JavaLangObject).addView(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_Adkk == null);
    this.jdField_a_of_type_Adkk.a(paramInt2, paramIntent);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0) && (this.jdField_a_of_type_Adkk != null)) {
      this.jdField_a_of_type_Adkk.a(paramIntent, localArrayList);
    }
  }
  
  public void a(bhha parambhha, PullToZoomHeaderListView paramPullToZoomHeaderListView)
  {
    this.jdField_a_of_type_Bhha = parambhha;
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = paramPullToZoomHeaderListView;
  }
  
  public void a(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    Intent localIntent = paramBaseActivity.getIntent();
    if (localIntent != null) {
      this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("key_from_ark_babyq", false);
    }
    super.a(paramBaseActivity, paramBundle);
    i();
    m();
    o();
  }
  
  public void f()
  {
    j();
    n();
    p();
    super.f();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (((paramView.getTag() instanceof aykg)) && (((aykg)paramView.getTag()).a == 17)) {
      k();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysb
 * JD-Core Version:    0.7.0.1
 */