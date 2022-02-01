import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.widget.PhotoWallView;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bahi
  extends badd
  implements View.OnClickListener, bjag
{
  private anuw a;
  
  public bahi(baei parambaei, azxr paramazxr)
  {
    super(parambaei, paramazxr);
    this.jdField_a_of_type_Anuw = new bahj(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((anum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(((azxr)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      bafb.a(2, 2131698284);
    }
    for (;;)
    {
      a();
      return;
      bafb.a(1, 2131698285);
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp, String paramString2)
  {
    if (((azxr)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramString2))
    {
      if (this.jdField_a_of_type_JavaLangObject != null) {
        ((PhotoWallView)((ProfileCardFavorShowView)this.jdField_a_of_type_JavaLangObject).a(0)).a(paramBoolean, paramString1, parammobile_sub_get_photo_wall_rsp);
      }
      paramString1 = (bade)this.jdField_a_of_type_Baei.a(1002);
      if (paramString1 != null)
      {
        paramString1 = paramString1.a();
        if (paramString1 != null) {
          paramString1.a(paramBoolean, paramString2, parammobile_sub_get_photo_wall_rsp);
        }
      }
    }
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    boolean bool2 = true;
    paramCard = (bade)this.jdField_a_of_type_Baei.a(1002);
    if ((paramCard instanceof baik)) {}
    for (paramBoolean = ((baik)paramCard).b();; paramBoolean = false)
    {
      boolean bool3 = ProfileActivity.AllInOne.i(((azxr)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      boolean bool4 = bhjx.b(((azxr)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_Bjaz != null) && (!this.jdField_a_of_type_Bjaz.a(2))) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfilePhotoWallComponent", 2, String.format("makeOrRefreshPhotoWall photoWallInHeader=%s strangerInContact=%s isBabyQ=%s configDisable=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1) }));
        }
        if ((!paramBoolean) && (!bool3) && (!bool4) && (!bool1)) {
          break;
        }
        if (this.jdField_a_of_type_JavaLangObject == null) {
          break label369;
        }
        this.jdField_a_of_type_JavaLangObject = null;
        return true;
      }
      Object localObject;
      if (this.jdField_a_of_type_JavaLangObject == null)
      {
        localObject = (ProfileCardFavorShowView)this.jdField_a_of_type_Baiy.a(a_());
        paramCard = (Card)localObject;
        if (localObject == null)
        {
          localObject = new PhotoWallView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((azxr)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          paramCard = new ProfileCardFavorShowView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          paramCard.setTitle(anzj.a(2131707342));
          paramCard.setVisibility(8);
          paramCard.addView((View)localObject);
        }
        this.jdField_a_of_type_JavaLangObject = paramCard;
      }
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramCard = (ProfileCardFavorShowView)this.jdField_a_of_type_JavaLangObject;
        localObject = (PhotoWallView)paramCard.a(0);
        ((PhotoWallView)localObject).setPhotoWallUpdaterListener(this);
        azvr localazvr = new azvr(85, localObject);
        paramCard.b.setTag(localazvr);
        paramCard.b.setOnClickListener(this);
        a(paramCard.jdField_a_of_type_AndroidWidgetTextView, null, paramCard.jdField_a_of_type_AndroidWidgetImageView);
        a(((PhotoWallView)localObject).b, ((PhotoWallView)localObject).c, null);
        return paramBoolean;
      }
      label369:
      return false;
    }
  }
  
  public int a()
  {
    return 1009;
  }
  
  public String a()
  {
    return "ProfilePhotoWallComponent";
  }
  
  public void a(int paramInt)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ProfilePhotoWallComponent", 2, String.format("onUpdatePhotoWall size=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    int i;
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      if (((azxr)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label116;
      }
      i = 1;
      if ((i != 0) || (paramInt > 0))
      {
        ((View)this.jdField_a_of_type_JavaLangObject).setVisibility(0);
        if (i == 0) {
          break label126;
        }
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramInt <= 0) {
          break label121;
        }
      }
    }
    label116:
    label121:
    for (paramInt = j;; paramInt = 2)
    {
      bdll.b(localQQAppInterface, "dc00898", "", "", "0X8007EBC", "0X8007EBC", paramInt, 0, "", "", "", "");
      return;
      i = 0;
      break;
    }
    label126:
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EBD", "0X8007EBD", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 100) {
      a();
    }
  }
  
  public void a(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anuw);
  }
  
  public boolean a(azxr paramazxr)
  {
    boolean bool = super.a(paramazxr);
    return a(((azxr)this.b).jdField_a_of_type_ComTencentMobileqqDataCard, ((azxr)this.b).d) | bool;
  }
  
  public String a_()
  {
    return "map_key_photo_wall";
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anuw);
    super.f();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof azvr))
    {
      azvr localazvr = (azvr)paramView.getTag();
      if ((localazvr.jdField_a_of_type_Int == 85) && ((localazvr.jdField_a_of_type_JavaLangObject instanceof PhotoWallView))) {
        ((PhotoWallView)localazvr.jdField_a_of_type_JavaLangObject).a();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahi
 * JD-Core Version:    0.7.0.1
 */