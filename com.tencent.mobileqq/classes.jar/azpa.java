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

public class azpa
  extends azkr
{
  private bmht jdField_a_of_type_Bmht;
  private PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private boolean jdField_a_of_type_Boolean;
  
  public azpa(azlw paramazlw, azfe paramazfe)
  {
    super(paramazlw, paramazfe);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Bmht != null)
    {
      if (this.jdField_a_of_type_Azkz != null) {
        this.jdField_a_of_type_Azkz.b(this.jdField_a_of_type_Bmht);
      }
      this.jdField_a_of_type_Bmht.a();
      this.jdField_a_of_type_Bmht = null;
    }
  }
  
  private void a(Card paramCard, View paramView)
  {
    if (this.jdField_a_of_type_Bmht == null)
    {
      this.jdField_a_of_type_Bmht = new bmht();
      this.jdField_a_of_type_Bmht.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramCard, this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView, paramView, this);
      if (this.jdField_a_of_type_Azkz != null) {
        this.jdField_a_of_type_Azkz.a(this.jdField_a_of_type_Bmht);
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
    if ((this.jdField_a_of_type_Biab == null) || (this.jdField_a_of_type_Biab.a(8)))
    {
      bool1 = true;
      if (((!this.jdField_a_of_type_Boolean) && (!paramBoolean)) || (paramCard == null) || (paramCard.switch_sticky_note == 1)) {
        break label192;
      }
      bool2 = true;
      bool5 = ProfileActivity.AllInOne.b(((azfe)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      bool3 = blvu.b();
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
      localProfileContentTitleView.setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691040));
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
    if (((paramInt1 == 20121207) || (paramInt1 == 20121208) || (paramInt1 == 201209)) && (this.jdField_a_of_type_Bmht != null)) {
      this.jdField_a_of_type_Bmht.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(View paramView, TextView paramTextView, Button paramButton)
  {
    if (paramView != null)
    {
      if (azmp.a((azfe)this.b)) {
        paramView.setBackgroundResource(0);
      }
    }
    else if (paramButton != null)
    {
      if (!azmp.a((azfe)this.b)) {
        break label80;
      }
      paramButton.setTextColor(paramButton.getResources().getColor(2131167017));
    }
    for (;;)
    {
      super.a(paramTextView, null);
      return;
      azfl.a(paramView, "background", ((azfe)this.b).jdField_a_of_type_Azfl, "commonMaskBackground");
      break;
      label80:
      super.a(paramButton, null);
    }
  }
  
  public void a(PullToZoomHeaderListView paramPullToZoomHeaderListView)
  {
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = paramPullToZoomHeaderListView;
  }
  
  public boolean a(azfe paramazfe)
  {
    boolean bool = super.a(paramazfe);
    return a(((azfe)this.b).jdField_a_of_type_ComTencentMobileqqDataCard, ((azfe)this.b).d) | bool;
  }
  
  public String a_()
  {
    return "map_key_sticky_note";
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Bmht != null) {
      this.jdField_a_of_type_Bmht.b();
    }
  }
  
  public void f()
  {
    a();
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpa
 * JD-Core Version:    0.7.0.1
 */