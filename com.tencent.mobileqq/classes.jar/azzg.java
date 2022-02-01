import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.lifeachivement.LifeAchivementPanelView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class azzg
  extends azwo
{
  private CardObserver a;
  
  public azzg(azxt paramazxt, azrb paramazrb)
  {
    super(paramazxt, paramazrb);
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new azzh(this);
  }
  
  private void a(Card paramCard, boolean paramBoolean, LifeAchivementPanelView paramLifeAchivementPanelView)
  {
    a(paramLifeAchivementPanelView, true);
    if (paramBoolean)
    {
      i = paramCard.lifeAchievementTotalCount;
      String str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698602), new Object[] { Integer.valueOf(i) });
      TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localTextView.setText(str);
      paramLifeAchivementPanelView.d.removeAllViews();
      paramLifeAchivementPanelView.d.addView(localTextView);
      paramLifeAchivementPanelView.d.setVisibility(0);
      paramLifeAchivementPanelView.a(paramCard.lifeAchivementList, paramCard.lifeAchievementTotalCount);
      a(null, localTextView);
      return;
    }
    paramLifeAchivementPanelView.d.removeAllViews();
    paramLifeAchivementPanelView.d.setVisibility(8);
    paramLifeAchivementPanelView.b();
    paramBoolean = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (((azrb)this.b).jdField_a_of_type_Azri != null) {}
    for (int i = 1;; i = 0)
    {
      if ((paramBoolean) || (i != 0)) {
        ((URLImageView)paramLifeAchivementPanelView.findViewById(2131369755)).setVisibility(4);
      }
      paramCard = (TextView)paramLifeAchivementPanelView.findViewById(2131379725);
      paramLifeAchivementPanelView = (TextView)paramLifeAchivementPanelView.findViewById(2131379726);
      a(paramCard, null);
      a(paramLifeAchivementPanelView, null);
      return;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject;
    azsx localazsx;
    if (!paramBoolean) {
      if ((((azrb)this.b).jdField_a_of_type_ComTencentMobileqqDataCard != null) && (((azrb)this.b).jdField_a_of_type_ComTencentMobileqqDataCard.lifeAchivementList != null))
      {
        localObject = ((azrb)this.b).jdField_a_of_type_ComTencentMobileqqDataCard.lifeAchivementList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localazsx = (azsx)((Iterator)localObject).next();
          if (localazsx.b == paramInt2)
          {
            if (paramInt1 != 1) {
              break label151;
            }
            localazsx.c -= 1;
            localazsx.a = false;
          }
        }
      }
    }
    for (;;)
    {
      localObject = BaseApplicationImpl.getApplication();
      QQToast.a((Context)localObject, ((Context)localObject).getString(2131694476), 0).a();
      if (this.jdField_a_of_type_JavaLangObject != null) {
        a(((azrb)this.b).jdField_a_of_type_ComTencentMobileqqDataCard, false);
      }
      return;
      label151:
      if (paramInt1 == 2)
      {
        localazsx.c += 1;
        localazsx.a = true;
      }
    }
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    int i = 2;
    if (((azrb)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
    {
      paramBoolean = true;
      if ((paramCard == null) || (paramCard.lifeAchivementList == null) || (paramCard.lifeAchivementList.size() <= 0)) {
        break label125;
      }
    }
    label125:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = azsy.a(paramCard, this.jdField_a_of_type_Birs, paramBoolean, bool1);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileAchievementComponent", 2, String.format("makeOrRefreshLifeAchievement isSelf=%s hasLifeAchievement=%s showLifeAchievement=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      if (bool2) {
        break label131;
      }
      if (this.jdField_a_of_type_JavaLangObject == null) {
        break label265;
      }
      this.jdField_a_of_type_JavaLangObject = null;
      return true;
      paramBoolean = false;
      break;
    }
    label131:
    LifeAchivementPanelView localLifeAchivementPanelView;
    if (this.jdField_a_of_type_JavaLangObject == null)
    {
      localLifeAchivementPanelView = new LifeAchivementPanelView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localLifeAchivementPanelView.setCardHandler((anri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
      localLifeAchivementPanelView.setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691157));
      this.jdField_a_of_type_JavaLangObject = localLifeAchivementPanelView;
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      localLifeAchivementPanelView = (LifeAchivementPanelView)this.jdField_a_of_type_JavaLangObject;
      localLifeAchivementPanelView.a(paramCard, (azrb)this.b);
      a(paramCard, bool1, localLifeAchivementPanelView);
      if (paramBoolean) {
        i = 1;
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", "", "0X800AE53", "0X800AE53", i, 0, "", "", "", "");
      return bool2;
    }
    label265:
    return false;
  }
  
  public int a()
  {
    return 1007;
  }
  
  public String a()
  {
    return "ProfileAchievementComponent";
  }
  
  public void a(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public boolean a(azrb paramazrb)
  {
    boolean bool = super.a(paramazrb);
    return a(((azrb)this.b).jdField_a_of_type_ComTencentMobileqqDataCard, ((azrb)this.b).d) | bool;
  }
  
  public String a_()
  {
    return "map_key_life_achievement";
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azzg
 * JD-Core Version:    0.7.0.1
 */