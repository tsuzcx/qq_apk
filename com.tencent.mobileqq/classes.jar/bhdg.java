import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.callback.IVasUpdateFactory;
import com.tencent.vas.update.callback.VasBusinessManager;
import mqq.manager.Manager;

public class bhdg
  extends VasBusinessManager
  implements Manager
{
  private bhdt a;
  
  public bhdg(QQAppInterface paramQQAppInterface)
  {
    QLog.e("VasUpdate_QQVasUpdateManager", 1, "QQVasUpdateManager onCreate");
  }
  
  public static boolean a()
  {
    return true;
  }
  
  public bhdt a()
  {
    return this.a;
  }
  
  public IVasUpdateFactory createVasUpdateFactory()
  {
    this.a = new bhdt();
    return this.a;
  }
  
  public void onDestroy()
  {
    QLog.e("VasUpdate_QQVasUpdateManager", 1, "onDestroy");
    super.onDestory();
  }
  
  public BaseUpdateBusiness[] registerBusinessCallback()
  {
    return new BaseUpdateBusiness[] { new bhdk() };
  }
  
  public BaseUpdateBusiness registerCommonBusinessCallback()
  {
    return new bhdj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdg
 * JD-Core Version:    0.7.0.1
 */