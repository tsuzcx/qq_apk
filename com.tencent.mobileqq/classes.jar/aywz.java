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
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.widget.PhotoWallView;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aywz
  extends ayrs
  implements View.OnClickListener, bhgh
{
  private CardObserver a;
  
  public aywz(aysx paramaysx, aymg paramaymg)
  {
    super(paramaysx, paramaymg);
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ayxa(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((amov)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(2)).a(((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      aytq.a(2, 2131698453);
    }
    for (;;)
    {
      a();
      return;
      aytq.a(1, 2131698454);
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp, String paramString2)
  {
    if (((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramString2))
    {
      if (this.jdField_a_of_type_JavaLangObject != null) {
        ((PhotoWallView)((ProfileCardFavorShowView)this.jdField_a_of_type_JavaLangObject).a(0)).a(paramBoolean, paramString1, parammobile_sub_get_photo_wall_rsp);
      }
      paramString1 = (ayrt)this.jdField_a_of_type_Aysx.a(1002);
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
    paramCard = (ayrt)this.jdField_a_of_type_Aysx.a(1002);
    if ((paramCard instanceof ayyb)) {}
    for (paramBoolean = ((ayyb)paramCard).b();; paramBoolean = false)
    {
      boolean bool3 = ProfileActivity.AllInOne.i(((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      boolean bool4 = bftf.b(((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_Bhha != null) && (!this.jdField_a_of_type_Bhha.a(2))) {}
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
        localObject = (ProfileCardFavorShowView)this.jdField_a_of_type_Ayyp.a(a_());
        paramCard = (Card)localObject;
        if (localObject == null)
        {
          localObject = new PhotoWallView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          paramCard = new ProfileCardFavorShowView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          paramCard.setTitle(amtj.a(2131707574));
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
        aykg localaykg = new aykg(85, localObject);
        paramCard.b.setTag(localaykg);
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
      if (((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
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
      bcef.b(localQQAppInterface, "dc00898", "", "", "0X8007EBC", "0X8007EBC", paramInt, 0, "", "", "", "");
      return;
      i = 0;
      break;
    }
    label126:
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EBD", "0X8007EBD", 0, 0, "", "", "", "");
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public boolean a(aymg paramaymg)
  {
    boolean bool = super.a(paramaymg);
    return a(((aymg)this.b).jdField_a_of_type_ComTencentMobileqqDataCard, ((aymg)this.b).d) | bool;
  }
  
  public String a_()
  {
    return "map_key_photo_wall";
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    super.f();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof aykg))
    {
      aykg localaykg = (aykg)paramView.getTag();
      if ((localaykg.jdField_a_of_type_Int == 85) && ((localaykg.jdField_a_of_type_JavaLangObject instanceof PhotoWallView))) {
        ((PhotoWallView)localaykg.jdField_a_of_type_JavaLangObject).a();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywz
 * JD-Core Version:    0.7.0.1
 */