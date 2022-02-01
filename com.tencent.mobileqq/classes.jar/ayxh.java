import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PullToZoomHeaderListView;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.stickynote.QzoneStickyNoteManager;

public class ayxh
  extends ayrs
{
  private PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private QzoneStickyNoteManager jdField_a_of_type_CooperationQzoneStickynoteQzoneStickyNoteManager;
  private boolean jdField_a_of_type_Boolean;
  
  public ayxh(aysx paramaysx, aymg paramaymg)
  {
    super(paramaysx, paramaymg);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_CooperationQzoneStickynoteQzoneStickyNoteManager != null)
    {
      if (this.jdField_a_of_type_Aysa != null) {
        this.jdField_a_of_type_Aysa.b(this.jdField_a_of_type_CooperationQzoneStickynoteQzoneStickyNoteManager);
      }
      this.jdField_a_of_type_CooperationQzoneStickynoteQzoneStickyNoteManager.destroy();
      this.jdField_a_of_type_CooperationQzoneStickynoteQzoneStickyNoteManager = null;
    }
  }
  
  private void a(Card paramCard, View paramView)
  {
    if (this.jdField_a_of_type_CooperationQzoneStickynoteQzoneStickyNoteManager == null)
    {
      this.jdField_a_of_type_CooperationQzoneStickynoteQzoneStickyNoteManager = new QzoneStickyNoteManager();
      this.jdField_a_of_type_CooperationQzoneStickynoteQzoneStickyNoteManager.init(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramCard, this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView, paramView, this);
      if (this.jdField_a_of_type_Aysa != null) {
        this.jdField_a_of_type_Aysa.a(this.jdField_a_of_type_CooperationQzoneStickynoteQzoneStickyNoteManager);
      }
    }
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    boolean bool4 = true;
    boolean bool1;
    boolean bool2;
    label50:
    boolean bool5;
    if ((this.jdField_a_of_type_Bhha == null) || (this.jdField_a_of_type_Bhha.a(8)))
    {
      bool1 = true;
      if (((!this.jdField_a_of_type_Boolean) && (!paramBoolean)) || (paramCard == null) || (paramCard.switch_sticky_note == 1)) {
        break label192;
      }
      bool2 = true;
      bool5 = ProfileActivity.AllInOne.b(((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      bool3 = QZoneApiProxy.isRightAndroidVersionForStickyNote();
      if ((!bool1) || (!bool2) || (!bool5) || (!bool3)) {
        break label198;
      }
    }
    label192:
    label198:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileStickyNoteComponent", 2, String.format("makeOrRefreshStickyNote showStickyNote=%s configEnable=%s switchEnable=%s isFriend=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool5) }));
      }
      if ((!this.jdField_a_of_type_Boolean) && (paramBoolean)) {
        this.jdField_a_of_type_Boolean = true;
      }
      if ((paramCard != null) && (bool3)) {
        break label204;
      }
      a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        break label292;
      }
      this.jdField_a_of_type_JavaLangObject = null;
      return true;
      bool1 = false;
      break;
      bool2 = false;
      break label50;
    }
    label204:
    if (this.jdField_a_of_type_JavaLangObject == null)
    {
      ProfileContentTitleView localProfileContentTitleView = new ProfileContentTitleView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localProfileContentTitleView.setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691080));
      localProfileContentTitleView.setArrowEnable(false);
      localProfileContentTitleView.setMarginBottomEnable(false);
      localProfileContentTitleView.setVisibility(8);
      a(paramCard, localProfileContentTitleView);
      this.jdField_a_of_type_JavaLangObject = localProfileContentTitleView;
    }
    for (paramBoolean = bool4;; paramBoolean = false)
    {
      a((ProfileContentTitleView)this.jdField_a_of_type_JavaLangObject, false);
      return paramBoolean;
    }
    label292:
    return false;
  }
  
  public int a()
  {
    return 1005;
  }
  
  public String a()
  {
    return "ProfileStickyNoteComponent";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (((paramInt1 == 20121207) || (paramInt1 == 20121208) || (paramInt1 == 201209)) && (this.jdField_a_of_type_CooperationQzoneStickynoteQzoneStickyNoteManager != null)) {
      this.jdField_a_of_type_CooperationQzoneStickynoteQzoneStickyNoteManager.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(View paramView, TextView paramTextView, Button paramButton)
  {
    if (paramView != null)
    {
      if (aytq.a((aymg)this.b)) {
        paramView.setBackgroundResource(0);
      }
    }
    else if (paramButton != null)
    {
      if (!aytq.a((aymg)this.b)) {
        break label80;
      }
      paramButton.setTextColor(paramButton.getResources().getColor(2131167045));
    }
    for (;;)
    {
      super.a(paramTextView, null);
      return;
      aymn.a(paramView, "background", ((aymg)this.b).jdField_a_of_type_Aymn, "commonMaskBackground");
      break;
      label80:
      super.a(paramButton, null);
    }
  }
  
  public void a(PullToZoomHeaderListView paramPullToZoomHeaderListView)
  {
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = paramPullToZoomHeaderListView;
  }
  
  public boolean a(aymg paramaymg)
  {
    boolean bool = super.a(paramaymg);
    return a(((aymg)this.b).jdField_a_of_type_ComTencentMobileqqDataCard, ((aymg)this.b).d) | bool;
  }
  
  public String a_()
  {
    return "map_key_sticky_note";
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_CooperationQzoneStickynoteQzoneStickyNoteManager != null) {
      this.jdField_a_of_type_CooperationQzoneStickynoteQzoneStickyNoteManager.onResume();
    }
  }
  
  public void f()
  {
    a();
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxh
 * JD-Core Version:    0.7.0.1
 */