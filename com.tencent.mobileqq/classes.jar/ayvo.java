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

class ayvo
  implements ITransactionCallback
{
  ayvo(ayvn paramayvn, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = vyr.a((String)paramHashMap.get("upFlow_WiFi"), -1L);
    long l3 = vyr.a((String)paramHashMap.get("dwFlow_WiFi"), -1L);
    long l4 = vyr.a((String)paramHashMap.get("upFlow_Xg"), -1L);
    long l5 = vyr.a((String)paramHashMap.get("dwFlow_Xg"), -1L);
    paramArrayOfByte = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    veg.c(ayvn.jdField_a_of_type_JavaLangString, "Transaction End : Failed. take time:" + (l1 - this.jdField_a_of_type_Long) + "ms");
    this.jdField_a_of_type_Ayvn.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", paramArrayOfByte);
    this.jdField_a_of_type_Ayvn.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str1);
    this.jdField_a_of_type_Ayvn.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str2);
    this.jdField_a_of_type_Ayvn.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str3);
    this.jdField_a_of_type_Ayvn.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str4);
    this.jdField_a_of_type_Ayvn.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", paramHashMap);
    this.jdField_a_of_type_Ayvn.a(l2, l3, l4, l5);
    this.jdField_a_of_type_Ayvn.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Ayvn.jdField_b_of_type_Aypb);
    this.jdField_a_of_type_Ayvn.d();
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
    veg.c(ayvn.jdField_a_of_type_JavaLangString, "Transaction End : Success. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms ,fileSize:" + this.jdField_a_of_type_Ayvn.jdField_a_of_type_Ayqm.jdField_a_of_type_Long + " transInfo:" + str2);
    this.jdField_a_of_type_Ayvn.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", str1);
    this.jdField_a_of_type_Ayvn.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str2);
    this.jdField_a_of_type_Ayvn.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str3);
    this.jdField_a_of_type_Ayvn.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str4);
    this.jdField_a_of_type_Ayvn.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str5);
    this.jdField_a_of_type_Ayvn.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", paramHashMap);
    this.jdField_a_of_type_Ayvn.jdField_b_of_type_Aypb.b();
    this.jdField_a_of_type_Ayvn.jdField_b_of_type_Aypb.a = 1;
    this.jdField_a_of_type_Ayvn.s = this.jdField_a_of_type_Ayvn.q;
    veg.c(ayvn.jdField_a_of_type_JavaLangString, "ITransactionCallback.onSuccess()");
    if (paramArrayOfByte == null) {
      this.jdField_a_of_type_Ayvn.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_Ayvn.a(l2, l3, l4, l5);
      this.jdField_a_of_type_Ayvn.jdField_a_of_type_Ayqm.a();
      return;
      int i;
      if (this.jdField_a_of_type_Ayvn.jdField_a_of_type_Ayqm.b == 196610)
      {
        paramHashMap = new qqstory_bhd_upload_pic.RspStoryPic();
        try
        {
          paramHashMap.mergeFrom(paramArrayOfByte);
          i = paramHashMap.retcode.get();
          if (i != 0) {
            break label567;
          }
          this.jdField_a_of_type_Ayvn.jdField_b_of_type_JavaLangString = paramHashMap.url.get().toStringUtf8();
          veg.a(ayvn.jdField_a_of_type_JavaLangString, "upload file %s return url %s", this.jdField_a_of_type_Ayvn.d, this.jdField_a_of_type_Ayvn.jdField_b_of_type_JavaLangString);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_Ayvn.jdField_b_of_type_JavaLangString)) {
            break label557;
          }
          this.jdField_a_of_type_Ayvn.jdField_j_of_type_Int = 940010;
          this.jdField_a_of_type_Ayvn.jdField_j_of_type_JavaLangString = String.format("return illegal arg url:%s", new Object[] { this.jdField_a_of_type_Ayvn.jdField_b_of_type_JavaLangString });
          this.jdField_a_of_type_Ayvn.d();
          paramHashMap = bbdm.a(paramArrayOfByte);
          str1 = ayvn.jdField_a_of_type_JavaLangString;
          paramArrayOfByte = paramHashMap;
          if (paramHashMap == null) {
            paramArrayOfByte = "";
          }
          veg.e(str1, "url not return %s", new Object[] { paramArrayOfByte });
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          veg.d(ayvn.jdField_a_of_type_JavaLangString, "parser buffer exception");
          this.jdField_a_of_type_Ayvn.d();
        }
        continue;
        label557:
        this.jdField_a_of_type_Ayvn.e();
        continue;
        label567:
        this.jdField_a_of_type_Ayvn.jdField_j_of_type_Int = i;
        this.jdField_a_of_type_Ayvn.jdField_j_of_type_JavaLangString = paramHashMap.msg.get().toStringUtf8();
        this.jdField_a_of_type_Ayvn.d();
      }
      else if ((this.jdField_a_of_type_Ayvn.jdField_a_of_type_Ayqm.b == 196609) || (this.jdField_a_of_type_Ayvn.jdField_a_of_type_Ayqm.b == 327681))
      {
        paramHashMap = new qqstory_bhd_upload_pic.RspStoryVideo();
        try
        {
          paramHashMap.mergeFrom(paramArrayOfByte);
          i = paramHashMap.retcode.get();
          if (i != 0) {
            break label872;
          }
          this.jdField_a_of_type_Ayvn.jdField_o_of_type_JavaLangString = paramHashMap.cdn_url.get().toStringUtf8();
          if (this.jdField_a_of_type_Ayvn.jdField_a_of_type_Ayqm.b == 196609) {
            this.jdField_a_of_type_Ayvn.jdField_o_of_type_JavaLangString = vzo.a(this.jdField_a_of_type_Ayvn.jdField_o_of_type_JavaLangString, "authkey");
          }
          this.jdField_a_of_type_Ayvn.n = paramHashMap.file_key.get().toStringUtf8();
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_Ayvn.jdField_o_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Ayvn.n))) {
            break label862;
          }
          this.jdField_a_of_type_Ayvn.jdField_j_of_type_Int = 940010;
          this.jdField_a_of_type_Ayvn.jdField_j_of_type_JavaLangString = String.format("return illegal arg vid:%s, url:%s", new Object[] { this.jdField_a_of_type_Ayvn.n, this.jdField_a_of_type_Ayvn.jdField_o_of_type_JavaLangString });
          this.jdField_a_of_type_Ayvn.d();
          paramHashMap = bbdm.a(paramArrayOfByte);
          str1 = ayvn.jdField_a_of_type_JavaLangString;
          paramArrayOfByte = paramHashMap;
          if (paramHashMap == null) {
            paramArrayOfByte = "";
          }
          veg.e(str1, "url not return %s", new Object[] { paramArrayOfByte });
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          veg.d(ayvn.jdField_a_of_type_JavaLangString, "parser buffer exception");
          this.jdField_a_of_type_Ayvn.d();
        }
        continue;
        label862:
        this.jdField_a_of_type_Ayvn.e();
        continue;
        label872:
        this.jdField_a_of_type_Ayvn.jdField_j_of_type_Int = i;
        this.jdField_a_of_type_Ayvn.jdField_j_of_type_JavaLangString = paramHashMap.msg.get().toStringUtf8();
        this.jdField_a_of_type_Ayvn.d();
      }
      else
      {
        this.jdField_a_of_type_Ayvn.d(1005);
        this.jdField_a_of_type_Ayvn.d();
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    veg.a(ayvn.jdField_a_of_type_JavaLangString, "onTransStart %s", this.jdField_a_of_type_Ayvn.jdField_a_of_type_Aywa.i);
    long l1 = System.currentTimeMillis();
    long l2 = ayvn.a(this.jdField_a_of_type_Ayvn);
    String str2 = vel.a(BaseApplication.getContext());
    if (this.jdField_a_of_type_Ayvn.jdField_a_of_type_Ayqm.b == 196610) {}
    for (String str1 = "pic";; str1 = "video")
    {
      vel.b("publish_story", "publish_bdh", 0, 0, new String[] { "", String.valueOf(l1 - l2), str2, str1 });
      this.jdField_a_of_type_Ayvn.jdField_b_of_type_Aypb.a();
      ayvn.a(this.jdField_a_of_type_Ayvn, System.currentTimeMillis());
      return;
    }
  }
  
  public void onUpdateProgress(int paramInt)
  {
    ayvn localayvn = this.jdField_a_of_type_Ayvn;
    ayqm localayqm = this.jdField_a_of_type_Ayvn.jdField_a_of_type_Ayqm;
    long l = paramInt;
    localayqm.e = l;
    localayvn.s = l;
    if ((paramInt <= this.jdField_a_of_type_Ayvn.q) && (!this.jdField_a_of_type_Ayvn.jdField_o_of_type_Boolean) && (!this.jdField_a_of_type_Ayvn.k)) {
      this.jdField_a_of_type_Ayvn.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayvo
 * JD-Core Version:    0.7.0.1
 */