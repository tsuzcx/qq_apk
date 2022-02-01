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

public class azla
  extends azks
{
  private aeij jdField_a_of_type_Aeij;
  private azmz jdField_a_of_type_Azmz;
  private aznh jdField_a_of_type_Aznh;
  private biab jdField_a_of_type_Biab;
  private PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private boolean jdField_a_of_type_Boolean;
  
  public azla(azlw paramazlw, azfe paramazfe)
  {
    super(paramazlw, paramazfe);
  }
  
  private void a(int paramInt)
  {
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A88A", "0X800A88A", paramInt, 0, "", "", "", "");
  }
  
  private void a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.b);
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a == 0) {}
    for (int i = ((azfe)this.b).jdField_a_of_type_ComTencentMobileqqDataCard.defaultCardId;; i = 0)
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
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130772311, 0);
      return;
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Aeij == null) {
      this.jdField_a_of_type_Aeij = new aeij(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, new azlb(this));
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Aeij != null)
    {
      this.jdField_a_of_type_Aeij.a();
      this.jdField_a_of_type_Aeij = null;
    }
  }
  
  private void k()
  {
    if ((!ProfileActivity.AllInOne.g(((azfe)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (((azfe)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
    {
      l();
      if (((azfe)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != 0) {
        break label98;
      }
    }
    label98:
    for (int i = 1;; i = 2)
    {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A889", "0X800A889", i, 0, "", "", "", "");
      return;
      a(false);
      break;
    }
  }
  
  private void l()
  {
    bkho localbkho = (bkho)bkif.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.b)) {
      localArrayList.add(new azlc(this, 2131692980));
    }
    localArrayList.add(new azld(this, 2131692978));
    localArrayList.add(new azle(this, 2131692976));
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      localbkho.b(((bgtm)localIterator.next()).a);
    }
    localbkho.c(2131690582);
    localbkho.a(new azlf(this, localArrayList, localbkho));
    try
    {
      localbkho.show();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ProfileHeaderBaseComponent", 2, "showProfileCoverActionSheet fail.", localException);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Azmz == null)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.findViewById(2131374065);
      this.jdField_a_of_type_Azmz = ((azmz)azlu.a(1024, this.jdField_a_of_type_Azlw, (azfe)this.b));
      this.jdField_a_of_type_Azmz.a(this.jdField_a_of_type_Azkz, this.jdField_a_of_type_Biab, null);
      this.jdField_a_of_type_Azmz.a(localView);
      this.jdField_a_of_type_Azmz.g();
      a(this.jdField_a_of_type_Azmz);
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_Azmz != null)
    {
      b(this.jdField_a_of_type_Azmz);
      this.jdField_a_of_type_Azmz.h();
      this.jdField_a_of_type_Azmz = null;
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Aznh == null)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.findViewById(2131374067);
      this.jdField_a_of_type_Aznh = ((aznh)azlu.a(1022, this.jdField_a_of_type_Azlw, (azfe)this.b));
      this.jdField_a_of_type_Aznh.a(this.jdField_a_of_type_Azkz, this.jdField_a_of_type_Biab, null);
      this.jdField_a_of_type_Aznh.a(localView);
      this.jdField_a_of_type_Aznh.g();
      a(this.jdField_a_of_type_Aznh);
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Aznh != null)
    {
      b(this.jdField_a_of_type_Aznh);
      this.jdField_a_of_type_Aznh.h();
      this.jdField_a_of_type_Aznh = null;
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
      ProfileBaseView localProfileBaseView = new ProfileBaseView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (azfe)this.b);
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
    } while (this.jdField_a_of_type_Aeij == null);
    this.jdField_a_of_type_Aeij.a(paramInt2, paramIntent);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0) && (this.jdField_a_of_type_Aeij != null)) {
      this.jdField_a_of_type_Aeij.a(paramIntent, localArrayList);
    }
  }
  
  public void a(biab parambiab, PullToZoomHeaderListView paramPullToZoomHeaderListView)
  {
    this.jdField_a_of_type_Biab = parambiab;
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
    if (((paramView.getTag() instanceof azde)) && (((azde)paramView.getTag()).a == 17)) {
      k();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azla
 * JD-Core Version:    0.7.0.1
 */