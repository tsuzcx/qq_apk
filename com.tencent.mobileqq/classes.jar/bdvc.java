import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor.2.1;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor.2.2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class bdvc
  implements ITransactionCallback
{
  bdvc(bdvb parambdvb) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - bdvb.a(this.a)) + "ms");
    }
    this.a.b(paramHashMap);
    ThreadManager.post(new GroupPicUploadProcessor.2.2(this, l2, l3, l4, l5), 5, null, false);
    this.a.a(paramInt, "OnFailed.", "", this.a.jdField_b_of_type_Bdsz);
    this.a.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l1 - bdvb.a(this.a)) + "ms ,fileSize:" + this.a.jdField_a_of_type_Bduk.a + " transInfo:" + (String)paramHashMap.get("rep_bdhTrans"));
    }
    this.a.b(paramHashMap);
    this.a.jdField_b_of_type_Bdsz.b();
    this.a.jdField_b_of_type_Bdsz.a = 1;
    this.a.s = this.a.jdField_q_of_type_Long;
    this.a.jdField_b_of_type_Boolean = true;
    this.a.s();
    ThreadManager.post(new GroupPicUploadProcessor.2.1(this, l2, l3, l4, l5), 5, null, false);
    this.a.jdField_a_of_type_Bduk.a();
    paramArrayOfByte = (String)paramHashMap.get("ip");
    paramHashMap = (String)paramHashMap.get("port");
    this.a.a(true, 0, paramArrayOfByte, paramHashMap);
  }
  
  public void onSwitch2BackupChannel()
  {
    long l = SystemClock.uptimeMillis();
    this.a.d("<BDH_LOG> onSwitch2BackupChannel() switch to HTTP channel");
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_switchChannel", String.valueOf(l - bdvb.a(this.a)));
  }
  
  public void onTransStart()
  {
    this.a.jdField_b_of_type_Bdsz.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    bdvb localbdvb = this.a;
    bduk localbduk = this.a.jdField_a_of_type_Bduk;
    long l = paramInt;
    localbduk.e = l;
    localbdvb.s = l;
    if ((paramInt < this.a.jdField_q_of_type_Long) && (!this.a.jdField_q_of_type_Boolean) && (!this.a.m))
    {
      this.a.j();
      if (bdvb.a(this.a)) {
        bovt.a(bdvb.a(this.a), 1002, this.a.f());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvc
 * JD-Core Version:    0.7.0.1
 */