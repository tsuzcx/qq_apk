import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public abstract class aubd
{
  protected final QQAppInterface a;
  
  public aubd(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  protected abstract String a(boolean paramBoolean);
  
  protected abstract HashMap<String, String> a();
  
  public abstract void a();
  
  public void a(aube paramaube, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete, HashMap<String, String> paramHashMap)
  {
    paramaube = paramaube.a();
    if (paramExcitingTransferOneSlotComplete != null) {
      paramaube.putAll(paramExcitingTransferOneSlotComplete.getReportData());
    }
    if (paramHashMap != null) {
      paramaube.putAll(paramHashMap);
    }
    paramHashMap = bdmc.a(BaseApplication.getContext());
    String str = this.a.getCurrentAccountUin();
    if (paramExcitingTransferOneSlotComplete.m_SubReason == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramHashMap.a(str, "actPDSlot", bool, 0L, 0L, paramaube, "");
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
    bdmc.a(BaseApplication.getContext()).a(this.a.getCurrentAccountUin(), a(false), paramBoolean, 0L, 0L, localHashMap, "");
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
      bdmc.a(BaseApplication.getContext()).a(this.a.getCurrentAccountUin(), a(true), paramBoolean, 0L, 0L, localHashMap, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubd
 * JD-Core Version:    0.7.0.1
 */