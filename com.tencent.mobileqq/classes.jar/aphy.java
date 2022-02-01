import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.OverScrollCallbackHorizontalListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aphy
  extends afsn
{
  private long jdField_a_of_type_Long;
  private apic jdField_a_of_type_Apic;
  private apid jdField_a_of_type_Apid = new aphz(this);
  private apii jdField_a_of_type_Apii;
  apim jdField_a_of_type_Apim = new apia(this);
  private OverScrollCallbackHorizontalListView jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView;
  private List<aphw> b;
  private boolean c;
  
  public aphy(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(aphw paramaphw, int paramInt)
  {
    if (paramaphw == null) {}
    while (this.jdField_b_of_type_JavaUtilList.contains(paramaphw)) {
      return;
    }
    bcef.b(null, "dc00898", "", "", "0X800B329", "0X800B329", apil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a(String.valueOf(this.jdField_a_of_type_Long)), 0, paramaphw.a, String.valueOf(paramInt), "", "");
    this.jdField_b_of_type_JavaUtilList.add(paramaphw);
  }
  
  private void i()
  {
    if (!apin.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, String.valueOf(this.jdField_a_of_type_Long), d())) {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList return for switch limit");
      }
    }
    do
    {
      return;
      if (apil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a(Long.valueOf(this.jdField_a_of_type_Long))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList return for ts limit");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList ");
    }
    apil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a().a(this.jdField_a_of_type_Long, d(), false, 0, "");
  }
  
  protected int a()
  {
    return ViewUtils.dip2px(14.0F);
  }
  
  protected View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      if (QLog.isColorLevel()) {
        QLog.e("C2CShortcutBarAIOHelper", 2, "init mChatPie is null");
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("C2CShortcutBarAIOHelper", 2, "init mChatPie.app is null");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("C2CShortcutBarAIOHelper", 2, "init mChatPie.mAIORootView is null");
    return;
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
      Object localObject = apil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a(Long.valueOf(this.jdField_a_of_type_Long));
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "init friendUin = " + this.jdField_a_of_type_Long + ",appListSize = " + ((List)localObject).size() + ",mChatPie = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      }
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getContent().findViewById(2131376868);
      if (localView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("C2CShortcutBarAIOHelper", 2, "init remove shortcutContainer");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getContent().removeView(localView);
      }
      this.jdField_a_of_type_Apic = new apic(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, (List)localObject, this.jdField_a_of_type_Apid);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView = new OverScrollCallbackHorizontalListView(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setId(2131376868);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setAdapter(this.jdField_a_of_type_Apic);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOnItemClickListener(new apib(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOverScrollMode(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setDividerWidth(ViewUtils.dip2px(8.0F));
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setPadding(ViewUtils.dip2px(14.0F), ViewUtils.dip2px(10.0F), 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setClipToPadding(false);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.getParent() == null)
      {
        localObject = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(39.0F));
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131368751);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getContent().addView(this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView, (ViewGroup.LayoutParams)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.addObserver(this.jdField_a_of_type_Apim);
      i();
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("C2CShortcutBarAIOHelper", 2, "init Exception", localNumberFormatException);
        }
      }
    }
  }
  
  protected int b()
  {
    return ViewUtils.dip2px(14.0F);
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarAIOHelper", 2, "onChatPieResume");
    }
    super.b();
    g();
  }
  
  public boolean b()
  {
    if (!apin.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, String.valueOf(this.jdField_a_of_type_Long), d())) {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "isShortcutBarVisibleOrGoingToBeVisible return false for switch off");
      }
    }
    int i;
    do
    {
      do
      {
        do
        {
          return false;
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("C2CShortcutBarAIOHelper", 2, "isShortcutBarVisibleOrGoingToBeVisible return false for mIsInputJump");
        return false;
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("C2CShortcutBarAIOHelper", 2, "isShortcutBarVisibleOrGoingToBeVisible return false for AIOIceBreakViewShowing");
      return false;
      i = this.jdField_a_of_type_Apic.getCount();
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "isShortcutBarVisibleOrGoingToBeVisible dataSize = " + i);
      }
    } while (i <= 0);
    return true;
  }
  
  protected int c()
  {
    return ViewUtils.dip2px(10.0F);
  }
  
  public int d()
  {
    int i = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahhp)) {
      i = 2;
    }
    return i;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarAIOHelper", 2, "onChatPieDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.removeObserver(this.jdField_a_of_type_Apim);
    this.c = false;
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Apii != null) {
      this.jdField_a_of_type_Apii.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.getParent() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "onChatPieDestroy remove shortcutContainer");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getContent().removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView);
    }
    super.d();
  }
  
  public void e()
  {
    if (!apin.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, String.valueOf(this.jdField_a_of_type_Long), d())) {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "setAppShortcutBarVisible return for switch off");
      }
    }
    do
    {
      do
      {
        return;
        if ((d() != 1) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.isOneWayFriend())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("C2CShortcutBarAIOHelper", 2, "setAppShortcutBarVisible return for one way friend");
      return;
      super.e();
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "setAppShortcutBarVisible hasReportBarExposure = " + this.c);
      }
    } while (this.c);
    this.c = true;
    bcef.b(null, "dc00898", "", "", "0X800B334", "0X800B334", apil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a(String.valueOf(this.jdField_a_of_type_Long)), 0, "", "", "", "");
  }
  
  public void f()
  {
    super.f();
    a().setPadding(a(), c(), b(), 0);
  }
  
  public void g()
  {
    if (!apin.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, String.valueOf(this.jdField_a_of_type_Long), d())) {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "resumeAppShorcutBar return for switch off");
      }
    }
    do
    {
      return;
      if ((d() != 1) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.isOneWayFriend())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("C2CShortcutBarAIOHelper", 2, "resumeAppShorcutBar return for one way friend");
    return;
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aphy
 * JD-Core Version:    0.7.0.1
 */