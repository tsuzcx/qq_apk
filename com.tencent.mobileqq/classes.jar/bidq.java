import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.callback.IVasUpdateFactory;
import com.tencent.vas.update.callback.VasBusinessManager;
import mqq.manager.Manager;

public class bidq
  extends VasBusinessManager
  implements Manager
{
  private bied a;
  
  public bidq(QQAppInterface paramQQAppInterface)
  {
    QLog.e("VasUpdate_QQVasUpdateManager", 1, "QQVasUpdateManager onCreate");
  }
  
  public static boolean a()
  {
    return true;
  }
  
  public bied a()
  {
    return this.a;
  }
  
  public IVasUpdateFactory createVasUpdateFactory()
  {
    this.a = new bied();
    return this.a;
  }
  
  public void onDestroy()
  {
    QLog.e("VasUpdate_QQVasUpdateManager", 1, "onDestroy");
    super.onDestory();
  }
  
  public BaseUpdateBusiness[] registerBusinessCallback()
  {
    return new BaseUpdateBusiness[] { new bidu() };
  }
  
  public BaseUpdateBusiness registerCommonBusinessCallback()
  {
    return new bidt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bidq
 * JD-Core Version:    0.7.0.1
 */