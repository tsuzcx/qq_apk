import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.callback.IVasUpdateFactory;
import com.tencent.vas.update.callback.VasBusinessManager;
import mqq.manager.Manager;

public class bhuk
  extends VasBusinessManager
  implements Manager
{
  private bhuy a;
  
  public bhuk(QQAppInterface paramQQAppInterface)
  {
    QLog.e("VasUpdate_QQVasUpdateManager", 1, "QQVasUpdateManager onCreate");
  }
  
  public static boolean a()
  {
    return true;
  }
  
  public bhuy a()
  {
    return this.a;
  }
  
  public IVasUpdateFactory createVasUpdateFactory()
  {
    this.a = new bhuy();
    return this.a;
  }
  
  public void onDestroy()
  {
    QLog.e("VasUpdate_QQVasUpdateManager", 1, "onDestroy");
    super.onDestory();
  }
  
  public BaseUpdateBusiness[] registerBusinessCallback()
  {
    return new BaseUpdateBusiness[] { TroopNickNameBusiness.a, bibf.a, new bhup() };
  }
  
  public BaseUpdateBusiness registerCommonBusinessCallback()
  {
    return new bhun();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhuk
 * JD-Core Version:    0.7.0.1
 */