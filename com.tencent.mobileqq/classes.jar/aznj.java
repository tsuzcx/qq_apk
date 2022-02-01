import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.lifeachivement.LifeAchivementPanelView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class aznj
  extends azkr
{
  private aniz a;
  
  public aznj(azlw paramazlw, azfe paramazfe)
  {
    super(paramazlw, paramazfe);
    this.jdField_a_of_type_Aniz = new aznk(this);
  }
  
  private void a(Card paramCard, boolean paramBoolean, LifeAchivementPanelView paramLifeAchivementPanelView)
  {
    a(paramLifeAchivementPanelView, true);
    if (paramBoolean)
    {
      i = paramCard.lifeAchievementTotalCount;
      String str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698040), new Object[] { Integer.valueOf(i) });
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
    if (((azfe)this.b).jdField_a_of_type_Azfl != null) {}
    for (int i = 1;; i = 0)
    {
      if ((paramBoolean) || (i != 0)) {
        ((URLImageView)paramLifeAchivementPanelView.findViewById(2131369502)).setVisibility(4);
      }
      paramCard = (TextView)paramLifeAchivementPanelView.findViewById(2131379471);
      paramLifeAchivementPanelView = (TextView)paramLifeAchivementPanelView.findViewById(2131379472);
      a(paramCard, null);
      a(paramLifeAchivementPanelView, null);
      return;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject;
    azhb localazhb;
    if (!paramBoolean) {
      if ((((azfe)this.b).jdField_a_of_type_ComTencentMobileqqDataCard != null) && (((azfe)this.b).jdField_a_of_type_ComTencentMobileqqDataCard.lifeAchivementList != null))
      {
        localObject = ((azfe)this.b).jdField_a_of_type_ComTencentMobileqqDataCard.lifeAchivementList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localazhb = (azhb)((Iterator)localObject).next();
          if (localazhb.b == paramInt2)
          {
            if (paramInt1 != 1) {
              break label151;
            }
            localazhb.c -= 1;
            localazhb.a = false;
          }
        }
      }
    }
    for (;;)
    {
      localObject = BaseApplicationImpl.getApplication();
      QQToast.a((Context)localObject, ((Context)localObject).getString(2131694157), 0).a();
      if (this.jdField_a_of_type_JavaLangObject != null) {
        a(((azfe)this.b).jdField_a_of_type_ComTencentMobileqqDataCard, false);
      }
      return;
      label151:
      if (paramInt1 == 2)
      {
        localazhb.c += 1;
        localazhb.a = true;
      }
    }
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    int i = 2;
    if (((azfe)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
    {
      paramBoolean = true;
      if ((paramCard == null) || (paramCard.lifeAchivementList == null) || (paramCard.lifeAchivementList.size() <= 0)) {
        break label125;
      }
    }
    label125:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = azhc.a(paramCard, this.jdField_a_of_type_Biab, paramBoolean, bool1);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileAchievementComponent", 2, String.format("makeOrRefreshLifeAchievement isSelf=%s hasLifeAchievement=%s showLifeAchievement=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      if (bool2) {
        break label131;
      }
      if (this.jdField_a_of_type_JavaLangObject == null) {
        break label263;
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
      localLifeAchivementPanelView.setCardHandler((anip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2));
      localLifeAchivementPanelView.setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691032));
      this.jdField_a_of_type_JavaLangObject = localLifeAchivementPanelView;
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      localLifeAchivementPanelView = (LifeAchivementPanelView)this.jdField_a_of_type_JavaLangObject;
      localLifeAchivementPanelView.a(paramCard, (azfe)this.b);
      a(paramCard, bool1, localLifeAchivementPanelView);
      if (paramBoolean) {
        i = 1;
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", "", "0X800AE53", "0X800AE53", i, 0, "", "", "", "");
      return bool2;
    }
    label263:
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aniz);
  }
  
  public boolean a(azfe paramazfe)
  {
    boolean bool = super.a(paramazfe);
    return a(((azfe)this.b).jdField_a_of_type_ComTencentMobileqqDataCard, ((azfe)this.b).d) | bool;
  }
  
  public String a_()
  {
    return "map_key_life_achievement";
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aniz);
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aznj
 * JD-Core Version:    0.7.0.1
 */