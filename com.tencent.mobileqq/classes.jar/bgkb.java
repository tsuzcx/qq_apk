import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.callback.IVasUpdateFactory;
import com.tencent.vas.update.callback.VasBusinessManager;
import mqq.manager.Manager;

public class bgkb
  extends VasBusinessManager
  implements Manager
{
  private bgko a;
  
  public bgkb(QQAppInterface paramQQAppInterface)
  {
    QLog.e("VasUpdate_QQVasUpdateManager", 1, "QQVasUpdateManager onCreate");
  }
  
  public static boolean a()
  {
    return true;
  }
  
  public bgko a()
  {
    return this.a;
  }
  
  public IVasUpdateFactory createVasUpdateFactory()
  {
    this.a = new bgko();
    return this.a;
  }
  
  public void onDestroy()
  {
    QLog.e("VasUpdate_QQVasUpdateManager", 1, "onDestroy");
    super.onDestory();
  }
  
  public BaseUpdateBusiness[] registerBusinessCallback()
  {
    return new BaseUpdateBusiness[] { new bgkf() };
  }
  
  public BaseUpdateBusiness registerCommonBusinessCallback()
  {
    return new bgke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgkb
 * JD-Core Version:    0.7.0.1
 */