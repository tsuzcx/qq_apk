import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ImageUploadStep.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class bduv
  extends bduq
{
  private int a;
  
  bduv(bdup parambdup)
  {
    super(parambdup);
    this.jdField_a_of_type_JavaLangString = "ImageUploadStep";
  }
  
  private Pair<Integer, Boolean> a(long paramLong)
  {
    String str = this.jdField_b_of_type_Bdup.a.c();
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("Connection", "keep-alive");
    localHashMap2.put("Referer", "http://www.qq.com");
    localHashMap2.put("Host", "cgi.connect.qq.com");
    Object localObject1 = ((TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2)).getPskey(str, "cgi.connect.qq.com");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localHashMap2.put("Cookie", "p_uin=" + str + ";p_skey=" + (String)localObject1);
    }
    HashMap localHashMap3 = new HashMap();
    localHashMap3.put("share_image", bdup.b(this.jdField_b_of_type_Bdup));
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("report_type", "102");
    ((Bundle)localObject1).putString("act_type", "51");
    ((Bundle)localObject1).putString("intext_3", "0");
    ((Bundle)localObject1).putString("stringext_1", bdup.e(this.jdField_b_of_type_Bdup));
    bipi.a().a((Bundle)localObject1, "", str, false);
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("param_is_ip_direct", "1");
    aukw.a("upload_local_thumb_image");
    Object localObject2 = nlw.a(nmd.a("https://cgi.connect.qq.com/qqconnectopen/upload_share_image", 1007), "cgi.connect.qq.com", str, bdup.f(this.jdField_b_of_type_Bdup), null, localHashMap3, localHashMap2, false);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      aukw.a("upload_local_thumb_image", str, localHashMap1, false);
      aukw.a("upload_local_thumb_image");
      localObject1 = nlw.a("https://cgi.connect.qq.com/qqconnectopen/upload_share_image", "cgi.connect.qq.com", str, bdup.f(this.jdField_b_of_type_Bdup), null, localHashMap3, localHashMap2, true);
      localHashMap1.put("param_is_ip_direct", "0");
    }
    int k = 0;
    i = 0;
    bool2 = false;
    bool1 = bool2;
    if (localObject1 != null) {
      j = k;
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      j = k;
      k = ((JSONObject)localObject1).getInt("retcode");
      bool1 = bool2;
      i = k;
      if (k == 0)
      {
        bool1 = bool2;
        i = k;
        j = k;
        if (((JSONObject)localObject1).has("result"))
        {
          j = k;
          localObject1 = ((JSONObject)localObject1).getJSONObject("result");
          j = k;
          bdup.c(this.jdField_b_of_type_Bdup, ((JSONObject)localObject1).getString("url"));
          j = k;
          bdup.a(this.jdField_b_of_type_Bdup).set(true);
          bool1 = true;
          i = k;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        bool1 = bool2;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.share.ForwardSdkShareProcessor", 2, localJSONException.getMessage());
          bool1 = bool2;
          i = j;
          continue;
          QLog.d("Q.share.ForwardSdkShareProcessor", 2, localJSONException);
          continue;
          j = 1;
        }
      }
    }
    localHashMap1.put("param_ret_code", Integer.toString(i));
    aukw.a("upload_local_thumb_image", str, bool1);
    paramLong = System.currentTimeMillis() - paramLong;
    if (QLog.isColorLevel())
    {
      localObject1 = "ImageUploadStep|uploadImage|suc=" + bool1 + ",cost=" + paramLong + ",localImgUrl=" + bdup.b(this.jdField_b_of_type_Bdup) + ",targetUrl=" + bdup.e(this.jdField_b_of_type_Bdup);
      if ((!bool1) || (paramLong > 5000L)) {
        QLog.e("Q.share.ForwardSdkShareProcessor", 2, (String)localObject1);
      }
    }
    else
    {
      if (!bool1) {
        QLog.e("Q.share.ForwardSdkShareProcessor", 1, "ImageUploadStep|uploadImage|ret=" + i + ",retry=" + this.jdField_a_of_type_Int);
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("report_type", "102");
      ((Bundle)localObject1).putString("act_type", "11");
      localObject2 = new StringBuilder().append("");
      if (!bool1) {
        break label862;
      }
      j = 0;
      ((Bundle)localObject1).putString("intext_1", j);
      ((Bundle)localObject1).putString("intext_2", "" + i);
      ((Bundle)localObject1).putString("intext_3", "0");
      ((Bundle)localObject1).putString("intext_5", "" + paramLong);
      if (!bool1)
      {
        ((Bundle)localObject1).putString("stringext_2", bdup.b(this.jdField_b_of_type_Bdup));
        ((Bundle)localObject1).putString("stringext_1", bdup.e(this.jdField_b_of_type_Bdup));
      }
      bipi.a().a((Bundle)localObject1, "", str, false);
      return new Pair(Integer.valueOf(i), Boolean.valueOf(bool1));
    }
  }
  
  private Pair<Integer, String> a(String paramString, long paramLong)
  {
    String str = this.jdField_b_of_type_Bdup.a.c();
    paramString = new CompressInfo(paramString, 0);
    paramString.f = 0;
    aukw.a("compress_local_image");
    aukw.a("compress_local_image", str, ayyz.b(paramString));
    if (!TextUtils.isEmpty(paramString.e)) {
      bdup.e(this.jdField_b_of_type_Bdup, paramString.e);
    }
    paramString = new File(bdup.b(this.jdField_b_of_type_Bdup));
    long l;
    Object localObject2;
    if (paramString.exists())
    {
      l = paramString.length();
      paramString = bgmg.c(bdup.b(this.jdField_b_of_type_Bdup));
      if ((l <= 0L) || (TextUtils.isEmpty(paramString))) {
        break label553;
      }
      paramString = String.format("https://cgi.connect.qq.com/qqconnectopen/query_share_image?key=%s&size=%d&short_url=0", new Object[] { paramString, Long.valueOf(l) });
      aukw.a("query_image");
      paramString = nlw.a(nmd.a(paramString, 1007), str, bdup.f(this.jdField_b_of_type_Bdup));
      localObject2 = new HashMap();
      if (paramString != null) {
        break label448;
      }
      ((HashMap)localObject2).put("param_ret_code", "-1");
      ((HashMap)localObject2).put("param_need_upload", "0");
      aukw.a("query_image", str, (HashMap)localObject2, false);
    }
    for (;;)
    {
      paramLong = System.currentTimeMillis() - paramLong;
      if (paramString == null) {
        paramString = new Pair(Integer.valueOf(-1), "");
      }
      for (;;)
      {
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, "ImageUploadStep|queryImage|ret=" + paramString.first + ",cost=" + paramLong + ",url=" + (String)paramString.second);
        Object localObject1 = new Bundle();
        ((Bundle)localObject1).putString("report_type", "102");
        ((Bundle)localObject1).putString("act_type", "16");
        ((Bundle)localObject1).putString("intext_1", "" + paramString.first);
        localObject2 = new StringBuilder().append("");
        if (((Integer)paramString.first).intValue() == -1) {}
        for (int i = 0;; i = ((Integer)paramString.first).intValue())
        {
          ((Bundle)localObject1).putString("intext_2", i);
          ((Bundle)localObject1).putString("intext_5", "" + paramLong);
          bipi.a().a((Bundle)localObject1, "", str, false);
          return paramString;
          l = 0L;
          break;
          label448:
          ((HashMap)localObject2).put("param_ret_code", String.valueOf(paramString.first));
          if (TextUtils.isEmpty((CharSequence)paramString.second))
          {
            localObject1 = "0";
            label480:
            ((HashMap)localObject2).put("param_need_upload", localObject1);
            if (TextUtils.isEmpty((CharSequence)paramString.second)) {
              break label529;
            }
          }
          label529:
          for (boolean bool = true;; bool = false)
          {
            aukw.a("query_image", str, (HashMap)localObject2, bool);
            break;
            localObject1 = "1";
            break label480;
          }
        }
      }
      label553:
      paramString = null;
    }
  }
  
  protected boolean a()
  {
    return bdup.b(this.jdField_b_of_type_Bdup).get();
  }
  
  protected void d()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "ImageUploadStep|process|ready=" + bdup.b(this.jdField_b_of_type_Bdup) + ",remoteUrl=" + bdup.a(this.jdField_b_of_type_Bdup) + " ,localUrl=" + bdup.b(this.jdField_b_of_type_Bdup));
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if (bdup.b(this.jdField_b_of_type_Bdup).get())
    {
      b();
      return;
    }
    ThreadManager.excute(new ForwardSdkShareProcessor.ImageUploadStep.1(this), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bduv
 * JD-Core Version:    0.7.0.1
 */