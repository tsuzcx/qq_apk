import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class baww
  implements ITransactionCallback
{
  baww(bawv parambawv, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    paramArrayOfByte = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_Bawv.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", paramArrayOfByte);
    this.jdField_a_of_type_Bawv.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str1);
    this.jdField_a_of_type_Bawv.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str2);
    this.jdField_a_of_type_Bawv.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str3);
    this.jdField_a_of_type_Bawv.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str4);
    this.jdField_a_of_type_Bawv.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", paramHashMap);
    this.jdField_a_of_type_Bawv.a(l2, l3, l4, l5);
    this.jdField_a_of_type_Bawv.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Bawv.b);
    this.jdField_a_of_type_Bawv.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    String str1 = (String)paramHashMap.get("tc_p:");
    String str2 = (String)paramHashMap.get("rep_bdhTrans");
    String str3 = (String)paramHashMap.get("segspercnt");
    String str4 = (String)paramHashMap.get("param_conf_segSize");
    String str5 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms ,fileSize:" + this.jdField_a_of_type_Bawv.jdField_a_of_type_Bass.jdField_a_of_type_Long + " transInfo:" + str2);
    }
    this.jdField_a_of_type_Bawv.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", str1);
    this.jdField_a_of_type_Bawv.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str2);
    this.jdField_a_of_type_Bawv.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str3);
    this.jdField_a_of_type_Bawv.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str4);
    this.jdField_a_of_type_Bawv.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str5);
    this.jdField_a_of_type_Bawv.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", paramHashMap);
    this.jdField_a_of_type_Bawv.b.b();
    this.jdField_a_of_type_Bawv.b.a = 1;
    this.jdField_a_of_type_Bawv.s = this.jdField_a_of_type_Bawv.q;
    paramHashMap = new Bdh_extinfo.UploadPicExtInfo();
    try
    {
      paramHashMap.mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
      bawv.a(this.jdField_a_of_type_Bawv, paramHashMap.bytes_download_url.get().toStringUtf8());
      if (bawv.a(this.jdField_a_of_type_Bawv) == null)
      {
        this.jdField_a_of_type_Bawv.a(-1, "URL IS NULL", "", this.jdField_a_of_type_Bawv.b);
        this.jdField_a_of_type_Bawv.d();
        this.jdField_a_of_type_Bawv.a(l2, l3, l4, l5);
        this.jdField_a_of_type_Bawv.jdField_a_of_type_Bass.a();
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        continue;
        bawv.a(this.jdField_a_of_type_Bawv);
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    this.jdField_a_of_type_Bawv.d("<BDH_LOG> onTransStart()");
    this.jdField_a_of_type_Bawv.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    bawv localbawv = this.jdField_a_of_type_Bawv;
    bass localbass = this.jdField_a_of_type_Bawv.jdField_a_of_type_Bass;
    long l = paramInt;
    localbass.e = l;
    localbawv.s = l;
    if ((paramInt <= this.jdField_a_of_type_Bawv.q) && (!this.jdField_a_of_type_Bawv.o) && (!this.jdField_a_of_type_Bawv.k)) {
      this.jdField_a_of_type_Bawv.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baww
 * JD-Core Version:    0.7.0.1
 */