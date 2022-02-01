import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent.2;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.ConcurrentHashMap;

public class aywp
  extends ayrs
  implements View.OnClickListener
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private ayln jdField_a_of_type_Ayln = new aywq(this);
  
  public aywp(aysx paramaysx, aymg paramaymg)
  {
    super(paramaysx, paramaymg);
  }
  
  private void a(ProfileCardFavorShowView paramProfileCardFavorShowView, PersonalityLabelBoard paramPersonalityLabelBoard)
  {
    a(paramProfileCardFavorShowView.jdField_a_of_type_AndroidWidgetTextView, null, paramProfileCardFavorShowView.jdField_a_of_type_AndroidWidgetImageView);
    int i = -16777216;
    for (;;)
    {
      try
      {
        localObject = ((aymg)this.b).jdField_a_of_type_Aymn;
        if ((localObject != null) && (((aymn)localObject).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (((aymn)localObject).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0))
        {
          localObject = ((aymn)localObject).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("commonItemContentColor");
          if (localObject == null) {
            break label379;
          }
          if ((localObject instanceof ColorStateList)) {
            localObject = (ColorStateList)localObject;
          }
        }
      }
      catch (Exception localException1)
      {
        boolean bool2;
        localObject = null;
        QLog.e("ProfilePersonalityLabelComponent", 1, "updatePersonalityLabelTheme fail.", localException1);
        continue;
        int j = 0;
        continue;
        int k = 0;
        continue;
        boolean bool1 = false;
        continue;
        paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setBackgroundResource(2130839477);
        continue;
        paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setTextColor(i);
        continue;
        paramPersonalityLabelBoard.setTextColors(ColorStateList.valueOf(i));
        return;
      }
      try
      {
        if (paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView == null) {
          break label373;
        }
        j = paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.a();
        i = j;
      }
      catch (Exception localException2)
      {
        continue;
        label373:
        i = -16777216;
        continue;
      }
      if (((aymg)this.b).jdField_a_of_type_Long != aymn.jdField_a_of_type_Long)
      {
        j = 1;
        if (j != 0) {
          paramProfileCardFavorShowView.setClickable(true);
        }
        bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (((aymg)this.b).jdField_a_of_type_Aymn == null) {
          continue;
        }
        k = 1;
        if ((bool2) || (k != 0)) {
          continue;
        }
        bool1 = true;
        paramPersonalityLabelBoard.setIsNormalTheme(bool1);
        if (paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView != null)
        {
          if (j == 0) {
            continue;
          }
          paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setBackgroundDrawable(null);
          if (localObject == null) {
            continue;
          }
          paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setTextColor((ColorStateList)localObject);
        }
        if ((bool2) && (j != 0)) {
          a(paramPersonalityLabelBoard.jdField_a_of_type_AndroidWidgetTextView, paramPersonalityLabelBoard.jdField_a_of_type_AndroidWidgetButton, null);
        }
        if (localObject == null) {
          continue;
        }
        paramPersonalityLabelBoard.setTextColors((ColorStateList)localObject);
        return;
        if (!(localObject instanceof String)) {
          break label379;
        }
        localObject = (String)localObject;
        if (!((String)localObject).startsWith("#")) {
          break label379;
        }
        Color.parseColor((String)localObject);
        localObject = null;
        continue;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColorStateList(2131167012);
      }
      label379:
      Object localObject = null;
    }
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    boolean bool7 = ProfileActivity.AllInOne.i(((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool8 = bftf.b(((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    boolean bool2;
    label67:
    boolean bool3;
    label101:
    boolean bool4;
    label151:
    boolean bool5;
    if ((this.jdField_a_of_type_Bhha != null) && (!this.jdField_a_of_type_Bhha.a(3)))
    {
      bool1 = true;
      if ((paramCard == null) || (paramCard.personalityLabel != null)) {
        break label328;
      }
      bool2 = true;
      if ((paramCard == null) || (paramCard.personalityLabel == null) || (paramCard.personalityLabel.getSize() != 0) || (paramCard.personalityLabel.remainCount > 0)) {
        break label334;
      }
      bool3 = true;
      if ((paramCard == null) || (paramCard.personalityLabel == null) || (paramCard.personalityLabel.getSize() != 0) || (bftf.a(((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        break label340;
      }
      bool4 = true;
      if ((paramCard == null) || (paramCard.personalityLabel == null) || (paramCard.personalityLabel.isCloseByUser != 1)) {
        break label346;
      }
      bool5 = true;
      label176:
      if ((!bool7) && (!bool8) && (!bool1) && (!bool2) && (!bool3) && (!bool4) && (!bool5)) {
        break label352;
      }
    }
    label328:
    label334:
    label340:
    label346:
    label352:
    for (boolean bool6 = true;; bool6 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfilePersonalityLabelComponent", 2, String.format("makeOrRefreshPersonalityLabel shouldNotShow=%s isStrangerInContact=%s isBabyQ=%s configDisable=%s dataIsNull=%s dataIsEmpty=%s dataIsEmptyForGuest=%s closeByUser=%s", new Object[] { Boolean.valueOf(bool6), Boolean.valueOf(bool7), Boolean.valueOf(bool8), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5) }));
      }
      if ((paramCard != null) && (!bool6)) {
        break label358;
      }
      if (this.jdField_a_of_type_JavaLangObject == null) {
        break label567;
      }
      this.jdField_a_of_type_JavaLangObject = null;
      return true;
      bool1 = false;
      break;
      bool2 = false;
      break label67;
      bool3 = false;
      break label101;
      bool4 = false;
      break label151;
      bool5 = false;
      break label176;
    }
    label358:
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_JavaLangObject == null)
    {
      localObject2 = (ProfileCardFavorShowView)this.jdField_a_of_type_Ayyp.a(a_());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = new PersonalityLabelBoard(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        localObject1 = new ProfileCardFavorShowView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        ((ProfileCardFavorShowView)localObject1).setTitle(amtj.a(2131707539));
        ((ProfileCardFavorShowView)localObject1).setVisibility(8);
        ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
      }
      this.jdField_a_of_type_JavaLangObject = localObject1;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = (ProfileCardFavorShowView)this.jdField_a_of_type_JavaLangObject;
      localObject2 = (PersonalityLabelBoard)((ProfileCardFavorShowView)localObject1).a(0);
      ((PersonalityLabelBoard)localObject2).setNick(ProfileCardMoreInfoView.a((aymg)this.b));
      ((PersonalityLabelBoard)localObject2).a(paramCard.personalityLabel, paramBoolean, false);
      ((PersonalityLabelBoard)localObject2).setPersonalityLabelComponent(this);
      paramCard = new aykg(86, ((ProfileCardFavorShowView)localObject1).a(0));
      ((ProfileCardFavorShowView)localObject1).b.setTag(paramCard);
      ((ProfileCardFavorShowView)localObject1).b.setOnClickListener(this);
      a((ProfileCardFavorShowView)localObject1, (PersonalityLabelBoard)localObject2);
      return bool1;
    }
    label567:
    return false;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aywr(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.card.modify_personality_label");
      localIntentFilter.setPriority(2147483647);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  public int a()
  {
    return 1010;
  }
  
  public String a()
  {
    return "ProfilePersonalityLabelComponent";
  }
  
  public void a()
  {
    ThreadManager.postImmediately(new ProfilePersonalityLabelComponent.2(this), null, true);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1029)
    {
      if ((((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) && (((aymg)this.b).jdField_a_of_type_ComTencentMobileqqDataCard != null) && (((aymg)this.b).jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel != null) && (((aymg)this.b).jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel.unreadCount > 0))
      {
        ((aymg)this.b).jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel.unreadCount = 0;
        if (this.jdField_a_of_type_JavaLangObject != null) {
          ((PersonalityLabelBoard)((ProfileCardFavorShowView)this.jdField_a_of_type_JavaLangObject).a(0)).a(((aymg)this.b).jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel, false, false);
        }
        a();
      }
      if (paramInt2 == -1) {
        ((ayll)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(112)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      }
    }
  }
  
  public void a(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ayln);
    i();
  }
  
  public boolean a(aymg paramaymg)
  {
    boolean bool = super.a(paramaymg);
    return a(((aymg)this.b).jdField_a_of_type_ComTencentMobileqqDataCard, ((aymg)this.b).d) | bool;
  }
  
  public String a_()
  {
    return "map_key_personality_label";
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_JavaLangObject != null) {
      ((PersonalityLabelBoard)((ProfileCardFavorShowView)this.jdField_a_of_type_JavaLangObject).a(0)).a();
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ayln);
    j();
    super.f();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof aykg))
    {
      aykg localaykg = (aykg)paramView.getTag();
      if ((localaykg.jdField_a_of_type_Int == 86) && ((localaykg.jdField_a_of_type_JavaLangObject instanceof PersonalityLabelBoard))) {
        ((PersonalityLabelBoard)localaykg.jdField_a_of_type_JavaLangObject).a(false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywp
 * JD-Core Version:    0.7.0.1
 */