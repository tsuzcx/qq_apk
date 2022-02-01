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

public class badm
  extends bade
{
  private aerm jdField_a_of_type_Aerm;
  private bafl jdField_a_of_type_Bafl;
  private baft jdField_a_of_type_Baft;
  private bjaz jdField_a_of_type_Bjaz;
  private PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private boolean jdField_a_of_type_Boolean;
  
  public badm(baei parambaei, azxr paramazxr)
  {
    super(parambaei, paramazxr);
  }
  
  private void a(int paramInt)
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A88A", "0X800A88A", paramInt, 0, "", "", "", "");
  }
  
  private void a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.b);
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a == 0) {}
    for (int i = ((azxr)this.b).jdField_a_of_type_ComTencentMobileqqDataCard.defaultCardId;; i = 0)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, CardPicGalleryActivity.class);
      localIntent.putExtra("extra_mode", 2);
      localIntent.putExtra("is_from_mine_profile", paramBoolean);
      localIntent.putStringArrayListExtra("business_card_pics", localArrayList);
      localIntent.putExtra("default_card_id", i);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.b)) {
        localIntent.putExtra("extra_default", 2130845745);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130772311, 0);
      return;
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Aerm == null) {
      this.jdField_a_of_type_Aerm = new aerm(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, new badn(this));
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Aerm != null)
    {
      this.jdField_a_of_type_Aerm.a();
      this.jdField_a_of_type_Aerm = null;
    }
  }
  
  private void k()
  {
    if ((!ProfileActivity.AllInOne.g(((azxr)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (((azxr)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
    {
      l();
      if (((azxr)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != 0) {
        break label98;
      }
    }
    label98:
    for (int i = 1;; i = 2)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A889", "0X800A889", i, 0, "", "", "", "");
      return;
      a(false);
      break;
    }
  }
  
  private void l()
  {
    blir localblir = (blir)blji.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.b)) {
      localArrayList.add(new bado(this, 2131692989));
    }
    localArrayList.add(new badp(this, 2131692987));
    localArrayList.add(new badq(this, 2131692985));
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      localblir.b(((bhtp)localIterator.next()).a);
    }
    localblir.c(2131690580);
    localblir.a(new badr(this, localArrayList, localblir));
    try
    {
      localblir.show();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ProfileHeaderBaseComponent", 2, "showProfileCoverActionSheet fail.", localException);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Bafl == null)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.findViewById(2131374204);
      this.jdField_a_of_type_Bafl = ((bafl)baeg.a(1024, this.jdField_a_of_type_Baei, (azxr)this.b));
      this.jdField_a_of_type_Bafl.a(this.jdField_a_of_type_Badl, this.jdField_a_of_type_Bjaz, null);
      this.jdField_a_of_type_Bafl.a(localView);
      this.jdField_a_of_type_Bafl.g();
      a(this.jdField_a_of_type_Bafl);
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_Bafl != null)
    {
      b(this.jdField_a_of_type_Bafl);
      this.jdField_a_of_type_Bafl.h();
      this.jdField_a_of_type_Bafl = null;
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Baft == null)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.findViewById(2131374206);
      this.jdField_a_of_type_Baft = ((baft)baeg.a(1022, this.jdField_a_of_type_Baei, (azxr)this.b));
      this.jdField_a_of_type_Baft.a(this.jdField_a_of_type_Badl, this.jdField_a_of_type_Bjaz, null);
      this.jdField_a_of_type_Baft.a(localView);
      this.jdField_a_of_type_Baft.g();
      a(this.jdField_a_of_type_Baft);
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Baft != null)
    {
      b(this.jdField_a_of_type_Baft);
      this.jdField_a_of_type_Baft.h();
      this.jdField_a_of_type_Baft = null;
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
      ProfileBaseView localProfileBaseView = new ProfileBaseView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (azxr)this.b);
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
    } while (this.jdField_a_of_type_Aerm == null);
    this.jdField_a_of_type_Aerm.a(paramInt2, paramIntent);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0) && (this.jdField_a_of_type_Aerm != null)) {
      this.jdField_a_of_type_Aerm.a(paramIntent, localArrayList);
    }
  }
  
  public void a(bjaz parambjaz, PullToZoomHeaderListView paramPullToZoomHeaderListView)
  {
    this.jdField_a_of_type_Bjaz = parambjaz;
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
    if (((paramView.getTag() instanceof azvr)) && (((azvr)paramView.getTag()).a == 17)) {
      k();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badm
 * JD-Core Version:    0.7.0.1
 */