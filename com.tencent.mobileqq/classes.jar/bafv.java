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

public class bafv
  extends badd
{
  private anuw a;
  
  public bafv(baei parambaei, azxr paramazxr)
  {
    super(parambaei, paramazxr);
    this.jdField_a_of_type_Anuw = new bafw(this);
  }
  
  private void a(Card paramCard, boolean paramBoolean, LifeAchivementPanelView paramLifeAchivementPanelView)
  {
    a(paramLifeAchivementPanelView, true);
    if (paramBoolean)
    {
      i = paramCard.lifeAchievementTotalCount;
      String str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698141), new Object[] { Integer.valueOf(i) });
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
    if (((azxr)this.b).jdField_a_of_type_Azxy != null) {}
    for (int i = 1;; i = 0)
    {
      if ((paramBoolean) || (i != 0)) {
        ((URLImageView)paramLifeAchivementPanelView.findViewById(2131369595)).setVisibility(4);
      }
      paramCard = (TextView)paramLifeAchivementPanelView.findViewById(2131379638);
      paramLifeAchivementPanelView = (TextView)paramLifeAchivementPanelView.findViewById(2131379639);
      a(paramCard, null);
      a(paramLifeAchivementPanelView, null);
      return;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject;
    azzn localazzn;
    if (!paramBoolean) {
      if ((((azxr)this.b).jdField_a_of_type_ComTencentMobileqqDataCard != null) && (((azxr)this.b).jdField_a_of_type_ComTencentMobileqqDataCard.lifeAchivementList != null))
      {
        localObject = ((azxr)this.b).jdField_a_of_type_ComTencentMobileqqDataCard.lifeAchivementList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localazzn = (azzn)((Iterator)localObject).next();
          if (localazzn.b == paramInt2)
          {
            if (paramInt1 != 1) {
              break label151;
            }
            localazzn.c -= 1;
            localazzn.a = false;
          }
        }
      }
    }
    for (;;)
    {
      localObject = BaseApplicationImpl.getApplication();
      QQToast.a((Context)localObject, ((Context)localObject).getString(2131694175), 0).a();
      if (this.jdField_a_of_type_JavaLangObject != null) {
        a(((azxr)this.b).jdField_a_of_type_ComTencentMobileqqDataCard, false);
      }
      return;
      label151:
      if (paramInt1 == 2)
      {
        localazzn.c += 1;
        localazzn.a = true;
      }
    }
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    int i = 2;
    if (((azxr)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
    {
      paramBoolean = true;
      if ((paramCard == null) || (paramCard.lifeAchivementList == null) || (paramCard.lifeAchivementList.size() <= 0)) {
        break label125;
      }
    }
    label125:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = azzo.a(paramCard, this.jdField_a_of_type_Bjaz, paramBoolean, bool1);
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
      localLifeAchivementPanelView.setCardHandler((anum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2));
      localLifeAchivementPanelView.setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691032));
      this.jdField_a_of_type_JavaLangObject = localLifeAchivementPanelView;
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      localLifeAchivementPanelView = (LifeAchivementPanelView)this.jdField_a_of_type_JavaLangObject;
      localLifeAchivementPanelView.a(paramCard, (azxr)this.b);
      a(paramCard, bool1, localLifeAchivementPanelView);
      if (paramBoolean) {
        i = 1;
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", "", "0X800AE53", "0X800AE53", i, 0, "", "", "", "");
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anuw);
  }
  
  public boolean a(azxr paramazxr)
  {
    boolean bool = super.a(paramazxr);
    return a(((azxr)this.b).jdField_a_of_type_ComTencentMobileqqDataCard, ((azxr)this.b).d) | bool;
  }
  
  public String a_()
  {
    return "map_key_life_achievement";
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anuw);
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafv
 * JD-Core Version:    0.7.0.1
 */