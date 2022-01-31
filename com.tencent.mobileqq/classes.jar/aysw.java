import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;

class aysw
  implements ITransactionCallback
{
  aysw(aysv paramaysv, long paramLong) {}
  
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
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_Aysv.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", paramArrayOfByte);
    this.jdField_a_of_type_Aysv.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str1);
    this.jdField_a_of_type_Aysv.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str2);
    this.jdField_a_of_type_Aysv.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str3);
    this.jdField_a_of_type_Aysv.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str4);
    this.jdField_a_of_type_Aysv.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", paramHashMap);
    this.jdField_a_of_type_Aysv.a(l2, l3, l4, l5);
    this.jdField_a_of_type_Aysv.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Aysv.jdField_b_of_type_Aypd);
    this.jdField_a_of_type_Aysv.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l5 = SystemClock.uptimeMillis();
    long l1 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l2 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    Object localObject = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l5 - this.jdField_a_of_type_Long) + "ms ,fileSize:" + this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.jdField_a_of_type_Long + " transInfo:" + str1);
    }
    this.jdField_a_of_type_Aysv.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", localObject);
    this.jdField_a_of_type_Aysv.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str1);
    this.jdField_a_of_type_Aysv.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str2);
    this.jdField_a_of_type_Aysv.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str3);
    this.jdField_a_of_type_Aysv.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str4);
    this.jdField_a_of_type_Aysv.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", paramHashMap);
    this.jdField_a_of_type_Aysv.jdField_b_of_type_Aypd.b();
    this.jdField_a_of_type_Aysv.jdField_b_of_type_Aypd.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Aysv.s = this.jdField_a_of_type_Aysv.q;
    if ((this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.b == 50) || (this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.b == 51)) {
      paramHashMap = new Bdh_extinfo.UploadPicExtInfo();
    }
    for (;;)
    {
      try
      {
        paramHashMap.mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
        this.jdField_a_of_type_Aysv.n = paramHashMap.bytes_file_resid.get().toStringUtf8();
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Aysv.n))
        {
          this.jdField_a_of_type_Aysv.e();
          this.jdField_a_of_type_Aysv.a(l1, l2, l3, l4);
          this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.a();
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        continue;
        this.jdField_a_of_type_Aysv.d();
        continue;
      }
      int i;
      if (this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.b == 23)
      {
        paramHashMap = new Bdh_extinfo.CommFileExtRsp();
        try
        {
          paramHashMap.mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
          localObject = this.jdField_a_of_type_Aysv;
          if (paramHashMap.bytes_download_url.has())
          {
            paramArrayOfByte = paramHashMap.bytes_download_url.get().toStringUtf8();
            ((aysv)localObject).jdField_o_of_type_JavaLangString = paramArrayOfByte;
            if (!paramHashMap.int32_retcode.has()) {
              break label612;
            }
            i = paramHashMap.int32_retcode.get();
            if (QLog.isColorLevel()) {
              QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(), business result code = " + i + " url : " + this.jdField_a_of_type_Aysv.jdField_o_of_type_JavaLangString);
            }
            if (i != 0) {
              break label617;
            }
            this.jdField_a_of_type_Aysv.e();
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          for (;;)
          {
            paramArrayOfByte.printStackTrace();
            continue;
            paramArrayOfByte = "";
            continue;
            label612:
            i = -1;
          }
          label617:
          this.jdField_a_of_type_Aysv.d();
        }
      }
      else
      {
        paramHashMap = ByteBuffer.wrap(paramArrayOfByte);
        i = paramHashMap.get();
        if (QLog.isColorLevel()) {
          QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(), business result code = " + i);
        }
        if (i == 0)
        {
          if ((this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.b == 8) || (this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.b == 64)) {
            aysv.jdField_a_of_type_Int = Integer.parseInt(new String(paramArrayOfByte, 2, paramHashMap.get() & 0xFF));
          }
          for (;;)
          {
            this.jdField_a_of_type_Aysv.e();
            break;
            if (this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.b == 21)
            {
              i = paramHashMap.get();
              this.jdField_a_of_type_Aysv.jdField_a_of_type_JavaLangString = new String(paramArrayOfByte, 2, i & 0xFF);
            }
            else if (this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.b == 22)
            {
              i = paramHashMap.get();
              this.jdField_a_of_type_Aysv.jdField_a_of_type_JavaLangString = new String(paramArrayOfByte, 2, i & 0xFF);
            }
            else if (this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.b == 35)
            {
              this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
            }
            else if ((this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.b == 36) || (this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.b == 37) || (this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.b == 38) || (this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.b == 39) || (this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.b == 40) || (this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.b == 41))
            {
              i = paramHashMap.get();
              int j = paramHashMap.get();
              int k = paramHashMap.get();
              int m = paramHashMap.get();
              this.jdField_a_of_type_Aysv.jdField_b_of_type_JavaLangString = new String(paramArrayOfByte, 5, (m & 0xFF) << 24 | 0x0 | i | (j & 0xFF) << 8 | (k & 0xFF) << 16);
            }
            else if (this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.b == 48)
            {
              i = paramHashMap.get();
              this.jdField_a_of_type_Aysv.jdField_a_of_type_JavaLangString = new String(paramArrayOfByte, 2, i & 0xFF);
            }
            else if (this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.b == 56)
            {
              try
              {
                paramHashMap.getInt();
                l5 = paramHashMap.getLong();
                i = paramHashMap.getInt();
                this.jdField_a_of_type_Aysv.jdField_a_of_type_JavaLangString = new String(paramArrayOfByte, paramHashMap.position(), i);
                if (QLog.isColorLevel()) {
                  QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(). personalityLabel uuid:" + l5 + " url:" + this.jdField_a_of_type_Aysv.jdField_a_of_type_JavaLangString);
                }
                this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Aysv.jdField_a_of_type_Aywc.j;
                this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.jdField_d_of_type_Long = l5;
                this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.i = this.jdField_a_of_type_Aysv.jdField_a_of_type_JavaLangString;
                if (TextUtils.isEmpty(this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.i)) {
                  this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.i = this.jdField_a_of_type_Aysv.jdField_a_of_type_Aywc.i;
                }
              }
              catch (Exception paramArrayOfByte) {}
            }
          }
        }
        if (this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo.b == 34)
        {
          paramArrayOfByte = new String(paramArrayOfByte);
          this.jdField_a_of_type_Aysv.jdField_a_of_type_JavaLangString = paramArrayOfByte;
          this.jdField_a_of_type_Aysv.e();
        }
        else
        {
          this.jdField_a_of_type_Aysv.d(1005);
          this.jdField_a_of_type_Aysv.d();
        }
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    this.jdField_a_of_type_Aysv.d("<BDH_LOG> onTransStart()");
    this.jdField_a_of_type_Aysv.jdField_b_of_type_Aypd.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    aysv localaysv = this.jdField_a_of_type_Aysv;
    ayqo localayqo = this.jdField_a_of_type_Aysv.jdField_a_of_type_Ayqo;
    long l = paramInt;
    localayqo.e = l;
    localaysv.s = l;
    if ((paramInt <= this.jdField_a_of_type_Aysv.q) && (!this.jdField_a_of_type_Aysv.jdField_o_of_type_Boolean) && (!this.jdField_a_of_type_Aysv.k)) {
      this.jdField_a_of_type_Aysv.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aysw
 * JD-Core Version:    0.7.0.1
 */