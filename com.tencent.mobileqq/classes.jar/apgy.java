import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public abstract class apgy
{
  protected final QQAppInterface a;
  
  public apgy(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  protected abstract String a(boolean paramBoolean);
  
  protected abstract HashMap<String, String> a();
  
  public abstract void a();
  
  public void a(apgz paramapgz, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    paramapgz = paramapgz.a();
    paramapgz.putAll(paramExcitingTransferOneSlotComplete.getReportData());
    axrn localaxrn = axrn.a(BaseApplication.getContext());
    String str = this.a.getCurrentAccountUin();
    if (paramExcitingTransferOneSlotComplete.m_SubReason == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localaxrn.a(str, "actPDSlot", bool, 0L, 0L, paramapgz, "");
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (a()) {
      b(paramBoolean);
    }
    HashMap localHashMap = a();
    if (localHashMap != null) {
      QLog.i("DataReport", 1, ">>> report: act=" + a(false) + localHashMap.toString());
    }
    axrn.a(BaseApplication.getContext()).a(this.a.getCurrentAccountUin(), a(false), paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  protected abstract boolean a();
  
  protected abstract HashMap<String, String> b();
  
  public abstract void b();
  
  public void b(boolean paramBoolean)
  {
    HashMap localHashMap = b();
    if (localHashMap != null)
    {
      QLog.i("OldDataReport", 1, ">>> reportOld: act=" + a(true) + localHashMap.toString());
      axrn.a(BaseApplication.getContext()).a(this.a.getCurrentAccountUin(), a(true), paramBoolean, 0L, 0L, localHashMap, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apgy
 * JD-Core Version:    0.7.0.1
 */