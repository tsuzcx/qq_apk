import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.OverScrollCallbackHorizontalListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aqop
  extends agwg
{
  private long jdField_a_of_type_Long;
  private aqot jdField_a_of_type_Aqot;
  private aqou jdField_a_of_type_Aqou = new aqoq(this);
  private aqoz jdField_a_of_type_Aqoz;
  aqpd jdField_a_of_type_Aqpd = new aqor(this);
  private OverScrollCallbackHorizontalListView jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView;
  private List<aqon> b;
  private boolean c;
  
  public aqop(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(aqon paramaqon, int paramInt)
  {
    if (paramaqon == null) {}
    while (this.jdField_b_of_type_JavaUtilList.contains(paramaqon)) {
      return;
    }
    bdll.b(null, "dc00898", "", "", "0X800B329", "0X800B329", aqpc.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(String.valueOf(this.jdField_a_of_type_Long)), 0, paramaqon.a, String.valueOf(paramInt), "", "");
    this.jdField_b_of_type_JavaUtilList.add(paramaqon);
  }
  
  private void i()
  {
    if (!aqpe.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_Long), d())) {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList return for switch limit");
      }
    }
    do
    {
      return;
      if (aqpc.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(Long.valueOf(this.jdField_a_of_type_Long))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList return for ts limit");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList ");
    }
    aqpc.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a().a(this.jdField_a_of_type_Long, d(), false, 0, "");
  }
  
  protected int a()
  {
    return bhtq.a(14.0F);
  }
  
  protected View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      if (QLog.isColorLevel()) {
        QLog.e("C2CShortcutBarAIOHelper", 2, "init mChatPie is null");
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("C2CShortcutBarAIOHelper", 2, "init mChatPie.app is null");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("C2CShortcutBarAIOHelper", 2, "init mChatPie.mAIORootView is null");
    return;
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      Object localObject = aqpc.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(Long.valueOf(this.jdField_a_of_type_Long));
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "init friendUin = " + this.jdField_a_of_type_Long + ",appListSize = " + ((List)localObject).size() + ",mChatPie = " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().findViewById(2131377116);
      if (localView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("C2CShortcutBarAIOHelper", 2, "init remove shortcutContainer");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().removeView(localView);
      }
      this.jdField_a_of_type_Aqot = new aqot(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, (List)localObject, this.jdField_a_of_type_Aqou);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView = new OverScrollCallbackHorizontalListView(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setId(2131377116);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setAdapter(this.jdField_a_of_type_Aqot);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOnItemClickListener(new aqos(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOverScrollMode(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setDividerWidth(bhtq.a(8.0F));
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setPadding(bhtq.a(14.0F), bhtq.a(10.0F), 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setClipToPadding(false);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.getParent() == null)
      {
        localObject = new RelativeLayout.LayoutParams(-1, bhtq.a(39.0F));
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131368726);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView, (ViewGroup.LayoutParams)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aqpd);
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
    return bhtq.a(14.0F);
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
    if (!aqpe.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_Long), d())) {
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
      i = this.jdField_a_of_type_Aqot.getCount();
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "isShortcutBarVisibleOrGoingToBeVisible dataSize = " + i);
      }
    } while (i <= 0);
    return true;
  }
  
  protected int c()
  {
    return bhtq.a(10.0F);
  }
  
  public int d()
  {
    int i = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aimd)) {
      i = 2;
    }
    return i;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarAIOHelper", 2, "onChatPieDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aqpd);
    this.c = false;
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Aqoz != null) {
      this.jdField_a_of_type_Aqoz.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.getParent() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "onChatPieDestroy remove shortcutContainer");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView);
    }
    super.d();
  }
  
  public void e()
  {
    if (!aqpe.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_Long), d())) {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "setAppShortcutBarVisible return for switch off");
      }
    }
    do
    {
      do
      {
        return;
        if ((d() != 1) || (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.D())) {
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
    bdll.b(null, "dc00898", "", "", "0X800B334", "0X800B334", aqpc.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(String.valueOf(this.jdField_a_of_type_Long)), 0, "", "", "", "");
  }
  
  public void f()
  {
    super.f();
    a().setPadding(a(), c(), b(), 0);
  }
  
  public void g()
  {
    if (!aqpe.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_Long), d())) {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "resumeAppShorcutBar return for switch off");
      }
    }
    do
    {
      return;
      if ((d() != 1) || (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.D())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("C2CShortcutBarAIOHelper", 2, "resumeAppShorcutBar return for one way friend");
    return;
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqop
 * JD-Core Version:    0.7.0.1
 */