import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class aqor
  extends aqpd
{
  aqor(aqop paramaqop) {}
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (aqop.a(this.a) != paramLong) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarObserver", 2, "onRecieveNewC2CShortcutAppListPush");
      }
    } while (!paramBoolean);
    aqop.a(this.a);
  }
  
  protected void a(boolean paramBoolean, long paramLong, List<aqon> paramList)
  {
    if (aqop.a(this.a) != paramLong) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarObserver", 2, "C2CShortcutBarAIOHelper onRequestC2cShortcutAppList");
      }
    } while (!paramBoolean);
    paramList = aqpc.a(aqop.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(Long.valueOf(paramLong));
    aqop.a(this.a).a(paramList);
    this.a.g();
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((aqop.b(this.a) == null) || (aqop.c(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(aqop.d(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))) {}
    while ((!paramBoolean1) || (!aqop.e(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramString))) {
      return;
    }
    if (paramBoolean2)
    {
      this.a.g();
      aqop.a(this.a);
      return;
    }
    this.a.h();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarObserver", 2, "onSetGlobalSwitcherStatus isSuccess = " + paramBoolean1 + ",isGlobalOpen = " + paramBoolean2);
    }
    if ((paramBoolean1) && (!paramBoolean2)) {
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqor
 * JD-Core Version:    0.7.0.1
 */