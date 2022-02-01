import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class ayte
  extends aytf
{
  private ArrayList<aypi> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = true;
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem b;
  
  public ayte(@NonNull BaseActivity paramBaseActivity, ayos paramayos)
  {
    super(paramBaseActivity, paramayos);
  }
  
  private void a(ArrayList<aypi> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(0);
    localArrayList.addAll(paramArrayList);
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
  }
  
  private boolean c()
  {
    if (this.b == null) {}
    do
    {
      do
      {
        return false;
      } while (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null);
      if (this.b.isAllHasPermission() != this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.isAllHasPermission()) {
        return true;
      }
      if (this.b.getPermissionUins().size() != this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size())
      {
        if (QLog.isColorLevel()) {
          QLog.d("AutoStatusAccountView", 2, new Object[] { " hasPermissionChange entity.size=", Integer.valueOf(this.b.getPermissionUins().size()), " item.size=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size()) });
        }
        return true;
      }
    } while (this.b.getPermissionUins().containsAll(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins()));
    return true;
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() != this.jdField_a_of_type_Aypw.a().size()) {
      return true;
    }
    Iterator localIterator1 = this.jdField_a_of_type_Aypw.a().iterator();
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        aypi localaypi1 = (aypi)localIterator1.next();
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        aypi localaypi2;
        do
        {
          if (!localIterator2.hasNext()) {
            break;
          }
          localaypi2 = (aypi)localIterator2.next();
        } while (localaypi1.a != localaypi2.a);
      }
      for (int i = 1; i == 0; i = 0)
      {
        return true;
        return false;
      }
    }
  }
  
  protected void a() {}
  
  public void a(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    if (paramOnlineStatusPermissionItem != null) {}
    for (;;)
    {
      this.b = paramOnlineStatusPermissionItem;
      super.a(this.b);
      return;
      paramOnlineStatusPermissionItem = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusAccountView", 2, new Object[] { "hasChange =", Boolean.valueOf(paramBoolean1), " isSmartListEmpty=", Boolean.valueOf(paramBoolean2) });
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131694081);
    if (paramBoolean2)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  protected boolean a(boolean paramBoolean)
  {
    aypo localaypo = (aypo)((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getManager(370);
    if ((this.b == null) && (localaypo.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem, this))) {
      return true;
    }
    if ((this.b != null) && (c())) {
      return true;
    }
    if (paramBoolean) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return localaypo.a(this.jdField_a_of_type_Aypw.a());
    }
    return d();
  }
  
  public ArrayList<aypi> b()
  {
    ArrayList localArrayList = super.b();
    a(localArrayList);
    return localArrayList;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691182);
    if (this.jdField_a_of_type_Aypw == null)
    {
      this.jdField_a_of_type_Aypw = new aypw(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewViewGroup, this, 3, 3, this, true);
      this.jdField_a_of_type_Aypw.a();
      return;
    }
    this.jdField_a_of_type_Aypw.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (boolean bool1 = b();; bool1 = this.jdField_a_of_type_Aypw.a().isEmpty())
    {
      boolean bool2 = a();
      boolean bool3 = a(paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusAccountView", 2, new Object[] { "isSmartListEmpty =", Boolean.valueOf(bool1), " hasPartVisible=", Boolean.valueOf(bool2), " hasDataChange=", Boolean.valueOf(bool3), " fromShow=", Boolean.valueOf(paramBoolean) });
      }
      a(bool3, bool1);
      b(bool2, bool1);
      return;
    }
  }
  
  public ArrayList<Integer> c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
      return localArrayList;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(Integer.valueOf((int)((aypi)((Iterator)localObject).next()).a));
    }
    return localArrayList;
  }
  
  public void c()
  {
    this.b = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
    a(this.jdField_a_of_type_Aypw.a());
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131376796)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = this.b;
      dismiss();
      aypy.a("0X800AF94");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayte
 * JD-Core Version:    0.7.0.1
 */