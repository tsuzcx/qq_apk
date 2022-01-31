import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic.RspStoryPic;
import com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic.RspStoryVideo;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.HashMap;

class batp
  implements ITransactionCallback
{
  batp(bato parambato, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = xng.a((String)paramHashMap.get("upFlow_WiFi"), -1L);
    long l3 = xng.a((String)paramHashMap.get("dwFlow_WiFi"), -1L);
    long l4 = xng.a((String)paramHashMap.get("upFlow_Xg"), -1L);
    long l5 = xng.a((String)paramHashMap.get("dwFlow_Xg"), -1L);
    paramArrayOfByte = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    wsv.c(bato.jdField_a_of_type_JavaLangString, "Transaction End : Failed. take time:" + (l1 - this.jdField_a_of_type_Long) + "ms");
    this.jdField_a_of_type_Bato.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", paramArrayOfByte);
    this.jdField_a_of_type_Bato.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str1);
    this.jdField_a_of_type_Bato.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str2);
    this.jdField_a_of_type_Bato.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str3);
    this.jdField_a_of_type_Bato.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str4);
    this.jdField_a_of_type_Bato.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", paramHashMap);
    this.jdField_a_of_type_Bato.a(l2, l3, l4, l5);
    this.jdField_a_of_type_Bato.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Bato.jdField_b_of_type_Bamy);
    this.jdField_a_of_type_Bato.d();
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
    wsv.c(bato.jdField_a_of_type_JavaLangString, "Transaction End : Success. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms ,fileSize:" + this.jdField_a_of_type_Bato.jdField_a_of_type_Baoj.jdField_a_of_type_Long + " transInfo:" + str2);
    this.jdField_a_of_type_Bato.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", str1);
    this.jdField_a_of_type_Bato.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str2);
    this.jdField_a_of_type_Bato.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str3);
    this.jdField_a_of_type_Bato.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str4);
    this.jdField_a_of_type_Bato.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str5);
    this.jdField_a_of_type_Bato.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", paramHashMap);
    this.jdField_a_of_type_Bato.jdField_b_of_type_Bamy.b();
    this.jdField_a_of_type_Bato.jdField_b_of_type_Bamy.a = 1;
    this.jdField_a_of_type_Bato.s = this.jdField_a_of_type_Bato.q;
    wsv.c(bato.jdField_a_of_type_JavaLangString, "ITransactionCallback.onSuccess()");
    if (paramArrayOfByte == null) {
      this.jdField_a_of_type_Bato.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bato.a(l2, l3, l4, l5);
      this.jdField_a_of_type_Bato.jdField_a_of_type_Baoj.a();
      return;
      int i;
      if (this.jdField_a_of_type_Bato.jdField_a_of_type_Baoj.b == 196610)
      {
        paramHashMap = new qqstory_bhd_upload_pic.RspStoryPic();
        try
        {
          paramHashMap.mergeFrom(paramArrayOfByte);
          i = paramHashMap.retcode.get();
          if (i != 0) {
            break label567;
          }
          this.jdField_a_of_type_Bato.jdField_b_of_type_JavaLangString = paramHashMap.url.get().toStringUtf8();
          wsv.a(bato.jdField_a_of_type_JavaLangString, "upload file %s return url %s", this.jdField_a_of_type_Bato.d, this.jdField_a_of_type_Bato.jdField_b_of_type_JavaLangString);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_Bato.jdField_b_of_type_JavaLangString)) {
            break label557;
          }
          this.jdField_a_of_type_Bato.jdField_j_of_type_Int = 940010;
          this.jdField_a_of_type_Bato.jdField_j_of_type_JavaLangString = String.format("return illegal arg url:%s", new Object[] { this.jdField_a_of_type_Bato.jdField_b_of_type_JavaLangString });
          this.jdField_a_of_type_Bato.d();
          paramHashMap = bdcv.a(paramArrayOfByte);
          str1 = bato.jdField_a_of_type_JavaLangString;
          paramArrayOfByte = paramHashMap;
          if (paramHashMap == null) {
            paramArrayOfByte = "";
          }
          wsv.e(str1, "url not return %s", new Object[] { paramArrayOfByte });
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          wsv.d(bato.jdField_a_of_type_JavaLangString, "parser buffer exception");
          this.jdField_a_of_type_Bato.d();
        }
        continue;
        label557:
        this.jdField_a_of_type_Bato.e();
        continue;
        label567:
        this.jdField_a_of_type_Bato.jdField_j_of_type_Int = i;
        this.jdField_a_of_type_Bato.jdField_j_of_type_JavaLangString = paramHashMap.msg.get().toStringUtf8();
        this.jdField_a_of_type_Bato.d();
      }
      else if ((this.jdField_a_of_type_Bato.jdField_a_of_type_Baoj.b == 196609) || (this.jdField_a_of_type_Bato.jdField_a_of_type_Baoj.b == 327681))
      {
        paramHashMap = new qqstory_bhd_upload_pic.RspStoryVideo();
        try
        {
          paramHashMap.mergeFrom(paramArrayOfByte);
          i = paramHashMap.retcode.get();
          if (i != 0) {
            break label872;
          }
          this.jdField_a_of_type_Bato.jdField_o_of_type_JavaLangString = paramHashMap.cdn_url.get().toStringUtf8();
          if (this.jdField_a_of_type_Bato.jdField_a_of_type_Baoj.b == 196609) {
            this.jdField_a_of_type_Bato.jdField_o_of_type_JavaLangString = xod.a(this.jdField_a_of_type_Bato.jdField_o_of_type_JavaLangString, "authkey");
          }
          this.jdField_a_of_type_Bato.n = paramHashMap.file_key.get().toStringUtf8();
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_Bato.jdField_o_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bato.n))) {
            break label862;
          }
          this.jdField_a_of_type_Bato.jdField_j_of_type_Int = 940010;
          this.jdField_a_of_type_Bato.jdField_j_of_type_JavaLangString = String.format("return illegal arg vid:%s, url:%s", new Object[] { this.jdField_a_of_type_Bato.n, this.jdField_a_of_type_Bato.jdField_o_of_type_JavaLangString });
          this.jdField_a_of_type_Bato.d();
          paramHashMap = bdcv.a(paramArrayOfByte);
          str1 = bato.jdField_a_of_type_JavaLangString;
          paramArrayOfByte = paramHashMap;
          if (paramHashMap == null) {
            paramArrayOfByte = "";
          }
          wsv.e(str1, "url not return %s", new Object[] { paramArrayOfByte });
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          wsv.d(bato.jdField_a_of_type_JavaLangString, "parser buffer exception");
          this.jdField_a_of_type_Bato.d();
        }
        continue;
        label862:
        this.jdField_a_of_type_Bato.e();
        continue;
        label872:
        this.jdField_a_of_type_Bato.jdField_j_of_type_Int = i;
        this.jdField_a_of_type_Bato.jdField_j_of_type_JavaLangString = paramHashMap.msg.get().toStringUtf8();
        this.jdField_a_of_type_Bato.d();
      }
      else
      {
        this.jdField_a_of_type_Bato.d(1005);
        this.jdField_a_of_type_Bato.d();
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    wsv.a(bato.jdField_a_of_type_JavaLangString, "onTransStart %s", this.jdField_a_of_type_Bato.jdField_a_of_type_Baub.i);
    long l1 = System.currentTimeMillis();
    long l2 = bato.a(this.jdField_a_of_type_Bato);
    String str2 = wta.a(BaseApplication.getContext());
    if (this.jdField_a_of_type_Bato.jdField_a_of_type_Baoj.b == 196610) {}
    for (String str1 = "pic";; str1 = "video")
    {
      wta.b("publish_story", "publish_bdh", 0, 0, new String[] { "", String.valueOf(l1 - l2), str2, str1 });
      this.jdField_a_of_type_Bato.jdField_b_of_type_Bamy.a();
      bato.a(this.jdField_a_of_type_Bato, System.currentTimeMillis());
      return;
    }
  }
  
  public void onUpdateProgress(int paramInt)
  {
    bato localbato = this.jdField_a_of_type_Bato;
    baoj localbaoj = this.jdField_a_of_type_Bato.jdField_a_of_type_Baoj;
    long l = paramInt;
    localbaoj.e = l;
    localbato.s = l;
    if ((paramInt <= this.jdField_a_of_type_Bato.q) && (!this.jdField_a_of_type_Bato.jdField_o_of_type_Boolean) && (!this.jdField_a_of_type_Bato.k)) {
      this.jdField_a_of_type_Bato.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batp
 * JD-Core Version:    0.7.0.1
 */