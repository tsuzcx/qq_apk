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

public class azwx
  extends azwp
{
  private aebq jdField_a_of_type_Aebq;
  private azyw jdField_a_of_type_Azyw;
  private azze jdField_a_of_type_Azze;
  private birs jdField_a_of_type_Birs;
  private PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private boolean jdField_a_of_type_Boolean;
  
  public azwx(azxt paramazxt, azrb paramazrb)
  {
    super(paramazxt, paramazrb);
  }
  
  private void a(int paramInt)
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A88A", "0X800A88A", paramInt, 0, "", "", "", "");
  }
  
  private void a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.b);
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a == 0) {}
    for (int i = ((azrb)this.b).jdField_a_of_type_ComTencentMobileqqDataCard.defaultCardId;; i = 0)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, CardPicGalleryActivity.class);
      localIntent.putExtra("extra_mode", 2);
      localIntent.putExtra("is_from_mine_profile", paramBoolean);
      localIntent.putStringArrayListExtra("business_card_pics", localArrayList);
      localIntent.putExtra("default_card_id", i);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.b)) {
        localIntent.putExtra("extra_default", 2130845730);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130772308, 0);
      return;
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Aebq == null) {
      this.jdField_a_of_type_Aebq = new aebq(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, new azwy(this));
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Aebq != null)
    {
      this.jdField_a_of_type_Aebq.a();
      this.jdField_a_of_type_Aebq = null;
    }
  }
  
  private void k()
  {
    if ((!ProfileActivity.AllInOne.g(((azrb)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (((azrb)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
    {
      l();
      if (((azrb)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != 0) {
        break label98;
      }
    }
    label98:
    for (int i = 1;; i = 2)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A889", "0X800A889", i, 0, "", "", "", "");
      return;
      a(false);
      break;
    }
  }
  
  private void l()
  {
    bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.b)) {
      localArrayList.add(new azwz(this, 2131693180));
    }
    localArrayList.add(new azxa(this, 2131693178));
    localArrayList.add(new azxb(this, 2131693176));
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      localbkzi.b(((bhix)localIterator.next()).a);
    }
    localbkzi.c(2131690697);
    localbkzi.a(new azxc(this, localArrayList, localbkzi));
    try
    {
      localbkzi.show();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ProfileHeaderBaseComponent", 2, "showProfileCoverActionSheet fail.", localException);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Azyw == null)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.findViewById(2131374178);
      this.jdField_a_of_type_Azyw = ((azyw)azxr.a(1024, this.jdField_a_of_type_Azxt, (azrb)this.b));
      this.jdField_a_of_type_Azyw.a(this.jdField_a_of_type_Azww, this.jdField_a_of_type_Birs, null);
      this.jdField_a_of_type_Azyw.a(localView);
      this.jdField_a_of_type_Azyw.g();
      a(this.jdField_a_of_type_Azyw);
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_Azyw != null)
    {
      b(this.jdField_a_of_type_Azyw);
      this.jdField_a_of_type_Azyw.h();
      this.jdField_a_of_type_Azyw = null;
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Azze == null)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.findViewById(2131374180);
      this.jdField_a_of_type_Azze = ((azze)azxr.a(1022, this.jdField_a_of_type_Azxt, (azrb)this.b));
      this.jdField_a_of_type_Azze.a(this.jdField_a_of_type_Azww, this.jdField_a_of_type_Birs, null);
      this.jdField_a_of_type_Azze.a(localView);
      this.jdField_a_of_type_Azze.g();
      a(this.jdField_a_of_type_Azze);
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Azze != null)
    {
      b(this.jdField_a_of_type_Azze);
      this.jdField_a_of_type_Azze.h();
      this.jdField_a_of_type_Azze = null;
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
      ProfileBaseView localProfileBaseView = new ProfileBaseView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (azrb)this.b);
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
    } while (this.jdField_a_of_type_Aebq == null);
    this.jdField_a_of_type_Aebq.a(paramInt2, paramIntent);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0) && (this.jdField_a_of_type_Aebq != null)) {
      this.jdField_a_of_type_Aebq.a(paramIntent, localArrayList);
    }
  }
  
  public void a(birs parambirs, PullToZoomHeaderListView paramPullToZoomHeaderListView)
  {
    this.jdField_a_of_type_Birs = parambirs;
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
    azpb localazpb;
    if ((paramView.getTag() instanceof azpb))
    {
      localazpb = (azpb)paramView.getTag();
      if (localazpb.a != 17) {
        break label44;
      }
      k();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label44:
      if (localazpb.a == 105) {
        bhqa.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (azrb)this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azwx
 * JD-Core Version:    0.7.0.1
 */