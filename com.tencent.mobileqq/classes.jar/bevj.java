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

class bevj
  implements ITransactionCallback
{
  bevj(bevi parambevi, long paramLong) {}
  
  private void a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    byte b = paramArrayOfByte.get();
    if (b == 0)
    {
      i = paramArrayOfByte.get();
      paramArrayOfByte = new byte[i];
      this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaLangString = new String(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPeoplePhotoUploadProcessor", 2, String.format("handleTransFileFriendAvatarOnSuccess success, result=%s length=%s mPhotoUrl=%s", new Object[] { Byte.valueOf(b), Integer.valueOf(i), this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaLangString }));
      }
      this.jdField_a_of_type_Bevi.e();
      return;
    }
    int i = paramArrayOfByte.getInt();
    short s = paramArrayOfByte.getShort();
    byte[] arrayOfByte = new byte[s];
    paramArrayOfByte.get(arrayOfByte);
    paramArrayOfByte = new String(arrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeoplePhotoUploadProcessor", 2, String.format("handleTransFileFriendAvatarOnSuccess fail, result=%s errorCode=%s errorMsgLength=%s errorMsg=%s", new Object[] { Byte.valueOf(b), Integer.valueOf(i), Short.valueOf(s), paramArrayOfByte }));
    }
    this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.g = i;
    this.jdField_a_of_type_Bevi.k = i;
    this.jdField_a_of_type_Bevi.j = paramArrayOfByte;
    this.jdField_a_of_type_Bevi.d();
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    byte b = localByteBuffer.get();
    if (b == 0)
    {
      i = localByteBuffer.get() & 0xFF;
      this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaLangString = new String(paramArrayOfByte, 2, i);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPeoplePhotoUploadProcessor", 2, String.format("handleTransFileBaseStaticAvatarOnSuccess success, result=%s length=%s mPhotoUrl=%s", new Object[] { Byte.valueOf(b), Integer.valueOf(i), this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaLangString }));
      }
      this.jdField_a_of_type_Bevi.e();
      return;
    }
    int i = localByteBuffer.getInt();
    short s = localByteBuffer.getShort();
    paramArrayOfByte = new byte[s];
    localByteBuffer.get(paramArrayOfByte);
    paramArrayOfByte = new String(paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeoplePhotoUploadProcessor", 2, String.format("handleTransFileBaseStaticAvatarOnSuccess fail, result=%s errorCode=%s errorMsgLength=%s errorMsg=%s", new Object[] { Byte.valueOf(b), Integer.valueOf(i), Short.valueOf(s), paramArrayOfByte }));
    }
    this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.g = i;
    this.jdField_a_of_type_Bevi.k = i;
    this.jdField_a_of_type_Bevi.j = paramArrayOfByte;
    this.jdField_a_of_type_Bevi.d();
  }
  
  private void c(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    byte b = localByteBuffer.get();
    if (b == 0)
    {
      this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPeoplePhotoUploadProcessor", 2, String.format("handleTransFileProfileCoverOnSuccess success, result=%s", new Object[] { Byte.valueOf(b) }));
      }
      this.jdField_a_of_type_Bevi.e();
      return;
    }
    int i = localByteBuffer.getInt();
    short s = localByteBuffer.getShort();
    paramArrayOfByte = new byte[s];
    localByteBuffer.get(paramArrayOfByte);
    paramArrayOfByte = new String(paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeoplePhotoUploadProcessor", 2, String.format("handleTransFileProfileCoverOnSuccess fail, result=%s errorCode=%s errorMsgLength=%s errorMsg=%s", new Object[] { Byte.valueOf(b), Integer.valueOf(i), Short.valueOf(s), paramArrayOfByte }));
    }
    this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.g = i;
    this.jdField_a_of_type_Bevi.k = i;
    this.jdField_a_of_type_Bevi.j = paramArrayOfByte;
    this.jdField_a_of_type_Bevi.d();
  }
  
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
    this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", paramArrayOfByte);
    this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str1);
    this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str2);
    this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str3);
    this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str4);
    this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", paramHashMap);
    this.jdField_a_of_type_Bevi.a(l2, l3, l4, l5);
    this.jdField_a_of_type_Bevi.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Bevi.jdField_b_of_type_Berr);
    this.jdField_a_of_type_Bevi.d();
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
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l5 - this.jdField_a_of_type_Long) + "ms ,fileSize:" + this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.jdField_a_of_type_Long + " transInfo:" + str1);
    }
    this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", localObject);
    this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str1);
    this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str2);
    this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str3);
    this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str4);
    this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", paramHashMap);
    this.jdField_a_of_type_Bevi.jdField_b_of_type_Berr.b();
    this.jdField_a_of_type_Bevi.jdField_b_of_type_Berr.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Bevi.s = this.jdField_a_of_type_Bevi.jdField_q_of_type_Long;
    if ((this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.b == 50) || (this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.b == 51)) {
      paramHashMap = new Bdh_extinfo.UploadPicExtInfo();
    }
    for (;;)
    {
      try
      {
        paramHashMap.mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
        this.jdField_a_of_type_Bevi.n = paramHashMap.bytes_file_resid.get().toStringUtf8();
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Bevi.n))
        {
          this.jdField_a_of_type_Bevi.e();
          this.jdField_a_of_type_Bevi.a(l1, l2, l3, l4);
          this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.a();
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        continue;
        this.jdField_a_of_type_Bevi.d();
        continue;
      }
      int i;
      if (this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.b == 23)
      {
        paramHashMap = new Bdh_extinfo.CommFileExtRsp();
        try
        {
          paramHashMap.mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
          localObject = this.jdField_a_of_type_Bevi;
          if (paramHashMap.bytes_download_url.has())
          {
            paramArrayOfByte = paramHashMap.bytes_download_url.get().toStringUtf8();
            ((bevi)localObject).o = paramArrayOfByte;
            if (!paramHashMap.int32_retcode.has()) {
              break label614;
            }
            i = paramHashMap.int32_retcode.get();
            if (QLog.isColorLevel()) {
              QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(), business result code = " + i + " url : " + this.jdField_a_of_type_Bevi.o);
            }
            if (i != 0) {
              break label619;
            }
            this.jdField_a_of_type_Bevi.e();
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
            label614:
            i = -1;
          }
          label619:
          this.jdField_a_of_type_Bevi.d();
        }
      }
      else if (this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.b == 22)
      {
        a(paramArrayOfByte);
      }
      else if (this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.b == 48)
      {
        b(paramArrayOfByte);
      }
      else if (this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.b == 35)
      {
        c(paramArrayOfByte);
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
          if ((this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.b == 8) || (this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.b == 64)) {
            bevi.jdField_a_of_type_Int = Integer.parseInt(new String(paramArrayOfByte, 2, paramHashMap.get() & 0xFF));
          }
          for (;;)
          {
            this.jdField_a_of_type_Bevi.e();
            break;
            if (this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.b == 21)
            {
              i = paramHashMap.get();
              this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaLangString = new String(paramArrayOfByte, 2, i & 0xFF);
            }
            else if ((this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.b == 36) || (this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.b == 37) || (this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.b == 38) || (this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.b == 39) || (this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.b == 40) || (this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.b == 41))
            {
              i = paramHashMap.get();
              int j = paramHashMap.get();
              int k = paramHashMap.get();
              int m = paramHashMap.get();
              this.jdField_a_of_type_Bevi.jdField_b_of_type_JavaLangString = new String(paramArrayOfByte, 5, (m & 0xFF) << 24 | 0x0 | i | (j & 0xFF) << 8 | (k & 0xFF) << 16);
            }
            else if (this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.b == 56)
            {
              try
              {
                paramHashMap.getInt();
                l5 = paramHashMap.getLong();
                i = paramHashMap.getInt();
                this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaLangString = new String(paramArrayOfByte, paramHashMap.position(), i);
                if (QLog.isColorLevel()) {
                  QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(). personalityLabel uuid:" + l5 + " url:" + this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaLangString);
                }
                this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Bevi.jdField_a_of_type_Beyg.j;
                this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.jdField_d_of_type_Long = l5;
                this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.i = this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaLangString;
                if (TextUtils.isEmpty(this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.i)) {
                  this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.i = this.jdField_a_of_type_Bevi.jdField_a_of_type_Beyg.i;
                }
              }
              catch (Exception paramArrayOfByte) {}
            }
          }
        }
        if (this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete.b == 34)
        {
          paramArrayOfByte = new String(paramArrayOfByte);
          this.jdField_a_of_type_Bevi.jdField_a_of_type_JavaLangString = paramArrayOfByte;
          this.jdField_a_of_type_Bevi.e();
        }
        else
        {
          this.jdField_a_of_type_Bevi.d(1005);
          this.jdField_a_of_type_Bevi.d();
        }
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    this.jdField_a_of_type_Bevi.d("<BDH_LOG> onTransStart()");
    this.jdField_a_of_type_Bevi.jdField_b_of_type_Berr.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    bevi localbevi = this.jdField_a_of_type_Bevi;
    bete localbete = this.jdField_a_of_type_Bevi.jdField_a_of_type_Bete;
    long l = paramInt;
    localbete.e = l;
    localbevi.s = l;
    if ((paramInt <= this.jdField_a_of_type_Bevi.jdField_q_of_type_Long) && (!this.jdField_a_of_type_Bevi.jdField_q_of_type_Boolean) && (!this.jdField_a_of_type_Bevi.m)) {
      this.jdField_a_of_type_Bevi.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bevj
 * JD-Core Version:    0.7.0.1
 */