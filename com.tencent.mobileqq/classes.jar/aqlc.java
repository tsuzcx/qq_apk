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

public class aqlc
  extends agkb
{
  private long jdField_a_of_type_Long;
  private aqlg jdField_a_of_type_Aqlg;
  private aqlh jdField_a_of_type_Aqlh = new aqld(this);
  private aqlm jdField_a_of_type_Aqlm;
  aqlq jdField_a_of_type_Aqlq = new aqle(this);
  private OverScrollCallbackHorizontalListView jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView;
  private List<aqla> b;
  private boolean c;
  
  public aqlc(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(aqla paramaqla, int paramInt)
  {
    if (paramaqla == null) {}
    while (this.jdField_b_of_type_JavaUtilList.contains(paramaqla)) {
      return;
    }
    bdla.b(null, "dc00898", "", "", "0X800B329", "0X800B329", aqlp.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a(String.valueOf(this.jdField_a_of_type_Long)), 0, paramaqla.a, String.valueOf(paramInt), "", "");
    this.jdField_b_of_type_JavaUtilList.add(paramaqla);
  }
  
  private void j()
  {
    if (!aqlr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, String.valueOf(this.jdField_a_of_type_Long), d())) {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList return for switch limit");
      }
    }
    do
    {
      return;
      if (aqlp.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a(Long.valueOf(this.jdField_a_of_type_Long))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList return for ts limit");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList ");
    }
    aqlp.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a().a(this.jdField_a_of_type_Long, d(), false, 0, "");
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
      Object localObject = aqlp.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a(Long.valueOf(this.jdField_a_of_type_Long));
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "init friendUin = " + this.jdField_a_of_type_Long + ",appListSize = " + ((List)localObject).size() + ",mChatPie = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      }
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getContent().findViewById(2131377140);
      if (localView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("C2CShortcutBarAIOHelper", 2, "init remove shortcutContainer");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getContent().removeView(localView);
      }
      this.jdField_a_of_type_Aqlg = new aqlg(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, (List)localObject, this.jdField_a_of_type_Aqlh);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView = new OverScrollCallbackHorizontalListView(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setId(2131377140);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setAdapter(this.jdField_a_of_type_Aqlg);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOnItemClickListener(new aqlf(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOverScrollMode(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setDividerWidth(ViewUtils.dip2px(8.0F));
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setPadding(ViewUtils.dip2px(14.0F), ViewUtils.dip2px(10.0F), 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setClipToPadding(false);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.getParent() == null)
      {
        localObject = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(39.0F));
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131368910);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getContent().addView(this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView, (ViewGroup.LayoutParams)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.addObserver(this.jdField_a_of_type_Aqlq);
      j();
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
  
  public boolean b()
  {
    if (!aqlr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, String.valueOf(this.jdField_a_of_type_Long), d())) {
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
      i = this.jdField_a_of_type_Aqlg.getCount();
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
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarAIOHelper", 2, "onChatPieResume");
    }
    super.c();
    h();
  }
  
  public int d()
  {
    int i = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof aici)) {
      i = 2;
    }
    return i;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarAIOHelper", 2, "onChatPieDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.removeObserver(this.jdField_a_of_type_Aqlq);
    this.c = false;
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Aqlm != null) {
      this.jdField_a_of_type_Aqlm.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.getParent() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "onChatPieDestroy remove shortcutContainer");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getContent().removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView);
    }
    super.e();
  }
  
  public void f()
  {
    if (!aqlr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, String.valueOf(this.jdField_a_of_type_Long), d())) {
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
      super.f();
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "setAppShortcutBarVisible hasReportBarExposure = " + this.c);
      }
    } while (this.c);
    this.c = true;
    bdla.b(null, "dc00898", "", "", "0X800B334", "0X800B334", aqlp.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a(String.valueOf(this.jdField_a_of_type_Long)), 0, "", "", "", "");
  }
  
  public void g()
  {
    super.g();
    a().setPadding(a(), c(), b(), 0);
  }
  
  public void h()
  {
    if (!aqlr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, String.valueOf(this.jdField_a_of_type_Long), d())) {
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
    super.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqlc
 * JD-Core Version:    0.7.0.1
 */