import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppInfo.AppDesc;
import com.tencent.ark.open.ArkAppInfo.AppDownloadInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCGI.10;
import com.tencent.mobileqq.ark.ArkAppCGI.8;
import com.tencent.mobileqq.ark.ArkAppCGI.9;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class annc
  implements baug
{
  static int jdField_a_of_type_Int;
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern;
  private baue jdField_a_of_type_Baue;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private final ArrayList<anno> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  static
  {
    if (!annc.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("Last-Modified[ ]*=[ ]*\\[([^\\[\\]]+)\\]");
      return;
    }
  }
  
  public annc(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    if (this.jdField_a_of_type_Baue == null) {
      this.jdField_a_of_type_Baue = ((bavd)paramQQAppInterface.getManager(21)).a(paramQQAppInterface, 0);
    }
  }
  
  private int a(String paramString)
  {
    int j = 5381;
    int i = 0;
    while (i < paramString.length())
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  private annm a(String paramString)
  {
    annm localannm = new annm();
    localannm.jdField_a_of_type_Int = 0;
    if (paramString == null) {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parserReply_queryAppInfoByAppNameBatch, data is empty");
    }
    for (;;)
    {
      return localannm;
      try
      {
        paramString = new JSONObject(paramString).optJSONObject("data");
        if (paramString == null)
        {
          ArkAppCenter.c("ArkApp.ArkAppCGI", "parserReply_queryAppInfoByAppNameBatch, 'data' not found");
          return localannm;
        }
      }
      catch (JSONException paramString)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, exception: %s", new Object[] { paramString.getMessage() }));
        return localannm;
      }
      localannm.jdField_a_of_type_Int = paramString.optInt("updateInterval", 300);
      localannm.jdField_a_of_type_Int = Math.max(60, localannm.jdField_a_of_type_Int);
      paramString = paramString.optJSONArray("apps");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          Object localObject1 = paramString.optJSONObject(i);
          if (localObject1 != null)
          {
            String str1 = ((JSONObject)localObject1).optString("app");
            if (TextUtils.isEmpty(str1))
            {
              ArkAppCenter.c("ArkApp.ArkAppCGI", "parserReply_queryAppInfoByAppNameBatch, 'app' not found");
            }
            else
            {
              int j = ((JSONObject)localObject1).optInt("ret", -1);
              Object localObject2 = ((JSONObject)localObject1).optString("msg", "");
              annn localannn;
              if (j != 0)
              {
                localannn = new annn();
                localannn.jdField_a_of_type_Int = j;
                localannn.jdField_a_of_type_JavaLangString = ((String)localObject2);
                localannn.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo = null;
                localannm.jdField_a_of_type_JavaUtilHashMap.put(str1, localannn);
              }
              else
              {
                localannn = new annn();
                localannn.jdField_a_of_type_Int = 0;
                localannn.jdField_a_of_type_JavaLangString = ((String)localObject2);
                localannn.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo = new ArkAppInfo.AppDownloadInfo();
                localannn.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.desc = new ArkAppInfo.AppDesc();
                localObject2 = ((JSONObject)localObject1).optJSONObject("config");
                if (localObject2 != null)
                {
                  localannn.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.config = ArkAppConfigMgr.convertJsonToConfig((JSONObject)localObject2);
                  localannn.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.desc.isTempApp = ArkAppConfigMgr.isTemplateApp(localannn.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.config);
                }
                localannn.b = ((JSONObject)localObject1).optInt("state", 0);
                if (localannn.b == 0)
                {
                  ArkAppCenter.c("ArkApp.ArkAppCGI", "ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid 'state'");
                  localannn.jdField_a_of_type_Int = -1;
                  localannm.jdField_a_of_type_JavaUtilHashMap.put(str1, localannn);
                }
                else if (localannn.b == 1)
                {
                  localObject2 = ((JSONObject)localObject1).optString("ver", null);
                  String str2 = ((JSONObject)localObject1).optString("url", null);
                  String str3 = ((JSONObject)localObject1).optString("sign", null);
                  j = ((JSONObject)localObject1).optInt("updatePeriod", 0);
                  if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)))
                  {
                    ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid app info, app=%s", new Object[] { str1 }));
                  }
                  else
                  {
                    localObject1 = Base64.decode(str3, 0);
                    if ((localObject1 == null) || (localObject1.length == 0))
                    {
                      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid sign, app=%s", new Object[] { str1 }));
                    }
                    else
                    {
                      localannn.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.downloadUrl = str2;
                      localannn.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.sign = ((byte[])localObject1);
                      localannn.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.updatePeriodByMinutes = j;
                      localannn.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.desc.name = str1;
                      localannn.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.desc.version = ((String)localObject2);
                    }
                  }
                }
                else
                {
                  localannm.jdField_a_of_type_JavaUtilHashMap.put(str1, localannn);
                }
              }
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID: replyBuf is empty");
      return null;
    }
    Object localObject;
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "UTF-8"));
      str = paramArrayOfByte.getString("retcode");
      if (!str.equalsIgnoreCase("0"))
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID, reply fail, ret=" + str);
        return null;
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID, Json Exception:" + paramArrayOfByte.getMessage());
      return null;
      localObject = paramArrayOfByte.getJSONObject("result");
      paramArrayOfByte = ((JSONObject)localObject).getString("retcode");
      String str = ((JSONObject)localObject).getString("msg");
      localObject = ((JSONObject)localObject).getString("apk_name");
      if ((localObject == null) || (((String)localObject).length() <= 0))
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID, packageName is empty, retcode=" + paramArrayOfByte + str);
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID, Exception:" + paramArrayOfByte.getMessage());
      return null;
    }
    return localObject;
  }
  
  private void a(anno paramanno, annl arg2)
  {
    paramanno.jdField_a_of_type_Annl = ???;
    paramanno.jdField_a_of_type_JavaIoByteArrayOutputStream = new ByteArrayOutputStream();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramanno);
      ??? = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (??? == null)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, app is null, return");
        return;
      }
    }
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_JavaLangString = paramanno.jdField_a_of_type_JavaLangString;
    localbaub.e = 1;
    if (paramanno.jdField_a_of_type_ArrayOfByte == null) {
      localbaub.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      localbaub.a(paramanno);
      localbaub.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      localbaub.jdField_a_of_type_Baug = this;
      localbaub.c = 30L;
      localbaub.jdField_a_of_type_JavaIoOutputStream = paramanno.jdField_a_of_type_JavaIoByteArrayOutputStream;
      if (paramanno.jdField_b_of_type_JavaLangString != null) {
        localbaub.jdField_a_of_type_JavaUtilHashMap.put("Cookie", paramanno.jdField_b_of_type_JavaLangString);
      }
      if (paramanno.jdField_a_of_type_Long >= 0L)
      {
        Object localObject = new SimpleDateFormat("E, d MMM y HH:mm:ss 'GMT'", Locale.US);
        ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT"));
        localObject = ((SimpleDateFormat)localObject).format(new Date(paramanno.jdField_a_of_type_Long));
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localbaub.jdField_a_of_type_JavaUtilHashMap.put("If-Modified-Since", localObject);
        }
      }
      ThreadManager.post(new ArkAppCGI.8(this, ???, paramanno, localbaub), 5, null, true);
      return;
      localbaub.jdField_a_of_type_Int = 1;
      localbaub.jdField_a_of_type_ArrayOfByte = paramanno.jdField_a_of_type_ArrayOfByte;
    }
  }
  
  private void a(anno paramanno, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    new Handler(Looper.getMainLooper()).post(new ArkAppCGI.10(this, paramanno, paramBoolean, paramArrayOfByte));
  }
  
  private void a(annq paramannq, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i;
    label31:
    Object localObject;
    annk localannk;
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("onQueryPackageNameByAppID: fail, url=%s", new Object[] { paramannq.jdField_a_of_type_JavaLangString }));
      paramArrayOfByte = null;
      i = 0;
      if (i >= paramannq.jdField_b_of_type_JavaUtilArrayList.size()) {
        return;
      }
      localObject = paramannq.jdField_a_of_type_JavaUtilArrayList.get(i);
      localannk = (annk)paramannq.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localannk != null) {
        if (paramArrayOfByte == null) {
          break label136;
        }
      }
    }
    label136:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localannk.a(paramBoolean, paramArrayOfByte, paramannq.d, localObject);
      i += 1;
      break label31;
      paramArrayOfByte = a(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("onQueryPackageNameByAppID: parseReply fail, url=%s", new Object[] { paramannq.jdField_a_of_type_JavaLangString }));
      }
      break;
    }
  }
  
  private boolean a(String paramString, long paramLong, Object paramObject, annk paramannk)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        anno localanno = (anno)localIterator.next();
        if ((localanno.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) && (localanno.jdField_a_of_type_Long == paramLong))
        {
          localanno.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
          localanno.jdField_b_of_type_JavaUtilArrayList.add(paramannk);
          return true;
        }
      }
      return false;
    }
  }
  
  private static String b()
  {
    try
    {
      String str = ArkEnvironmentManager.getInstance().getCacheDirectory() + "/tmp";
      new File(str).mkdirs();
      long l = System.currentTimeMillis();
      int i = jdField_a_of_type_Int + 1;
      jdField_a_of_type_Int = i;
      str = String.format("%s/%s", new Object[] { str, String.format("cgi_%d_%d", new Object[] { Long.valueOf(l), Integer.valueOf(i) }) });
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void b(anno paramanno, annl arg2)
  {
    paramanno.jdField_a_of_type_Annl = ???;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramanno);
      ThreadManager.post(new ArkAppCGI.9(this, paramanno), 5, null, true);
      return;
    }
  }
  
  protected void a(annp paramannp, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramannp.jdField_b_of_type_JavaUtilArrayList.size())
    {
      annk localannk = (annk)paramannp.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localannk != null) {
        localannk.a(paramBoolean, paramannp.jdField_a_of_type_Long, paramArrayOfByte);
      }
      i += 1;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "ArkSafe,doReport=null");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while (localObject == null);
        localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(121);
      } while (localObject == null);
      localObject = ((ArkAppCenter)localObject).a();
    } while (localObject == null);
    ArkAppCenter.c("ArkApp.ArkAppCGI", "ArkSafe,doReport=" + paramString);
    ((anoo)localObject).a("ArkAppReport.URLCheck", paramString, 10000, 0, new anng(this));
  }
  
  public void a(String paramString, long paramLong, annk paramannk)
  {
    if (a(paramString, paramLong, null, paramannk)) {
      return;
    }
    annp localannp = new annp(null);
    localannp.jdField_a_of_type_JavaLangString = paramString;
    localannp.jdField_a_of_type_Long = paramLong;
    localannp.jdField_b_of_type_JavaUtilArrayList.add(paramannk);
    a(localannp, new anni(this));
  }
  
  public void a(String paramString, Object paramObject, annk paramannk)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      if (paramannk != null) {
        paramannk.a(false, null, paramString, paramObject);
      }
    }
    Object localObject2;
    String str1;
    String str2;
    do
    {
      do
      {
        return;
        localObject1 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject1 == null)
        {
          ArkAppCenter.c("ArkApp.ArkAppCGI", "queryPackageNameByAppID, app is null, return");
          return;
        }
        localObject2 = (TicketManager)((QQAppInterface)localObject1).getManager(2);
        str1 = ((TicketManager)localObject2).getPskey(((QQAppInterface)localObject1).getCurrentAccountUin(), "connect.qq.com");
        if ((str1 != null) && (str1.length() > 0)) {
          break;
        }
        ArkAppCenter.c("ArkApp.ArkAppCGI", "queryPackageNameByAppID, pskey is null, return");
      } while (paramannk == null);
      paramannk.a(false, null, paramString, paramObject);
      return;
      localObject2 = ((TicketManager)localObject2).getSkey(((QQAppInterface)localObject1).getCurrentAccountUin());
      str2 = String.format("https://cgi.connect.qq.com/qqconnectwebsite/v2/appinfo/apkname/get?appid=%s&token=%d", new Object[] { paramString, Integer.valueOf(a(str1)) });
    } while (a(str2, -1L, paramObject, paramannk));
    annq localannq = new annq(null);
    for (Object localObject1 = ((QQAppInterface)localObject1).getCurrentAccountUin(); ((String)localObject1).length() < 10; localObject1 = "0" + (String)localObject1) {}
    localObject1 = "o" + (String)localObject1;
    localannq.jdField_b_of_type_JavaLangString = ("p_uin=" + (String)localObject1 + "; p_skey=" + str1 + "; uin=" + (String)localObject1 + "; skey=" + (String)localObject2);
    localannq.jdField_a_of_type_JavaLangString = str2;
    localannq.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
    localannq.jdField_b_of_type_JavaUtilArrayList.add(paramannk);
    localannq.d = paramString;
    localannq.c = "https://connect.qq.com";
    b(localannq, new anne(this));
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "doVipReport()=null");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while (localObject == null);
        localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(121);
      } while (localObject == null);
      localObject = ((ArkAppCenter)localObject).a();
    } while (localObject == null);
    ArkAppCenter.c("ArkApp.ArkAppCGI", "doVipReport()=" + paramString);
    ((anoo)localObject).a("ArkAppReport.VIPReport", paramString, 10000, 0, new annh(this));
  }
  
  public void b(String paramString, long paramLong, annk paramannk)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramannk == null) || (a(paramString, paramLong, null, paramannk))) {
      return;
    }
    annp localannp = new annp(null);
    localannp.jdField_a_of_type_JavaLangString = paramString;
    localannp.jdField_a_of_type_Long = paramLong;
    localannp.jdField_b_of_type_JavaUtilArrayList.add(paramannk);
    a(localannp, new annf(this));
  }
  
  public void onResp(bavf parambavf)
  {
    anno localanno = (anno)parambavf.jdField_a_of_type_Bave.a();
    boolean bool;
    if (parambavf.jdField_a_of_type_Int == 0)
    {
      bool = true;
      if (!bool) {
        break label202;
      }
    }
    for (;;)
    {
      try
      {
        arrayOfByte = localanno.jdField_a_of_type_JavaIoByteArrayOutputStream.toByteArray();
        if (parambavf.c == 304)
        {
          bool = true;
          parambavf = (String)parambavf.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader");
          if (!TextUtils.isEmpty(parambavf))
          {
            parambavf = jdField_a_of_type_JavaUtilRegexPattern.matcher(parambavf);
            if (!parambavf.find()) {}
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        try
        {
          byte[] arrayOfByte;
          parambavf = parambavf.group(1);
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("E,d MMM y HH:mm:ss 'GMT'", Locale.US);
          localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
          localanno.jdField_a_of_type_Long = localSimpleDateFormat.parse(parambavf).getTime();
          a(localanno, bool, arrayOfByte);
          return;
          bool = false;
          break;
          localOutOfMemoryError = localOutOfMemoryError;
          ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("ArkAppCGI.onResp, out of memory, msg=%s", new Object[] { localOutOfMemoryError.getMessage() }));
          localObject = null;
          bool = false;
        }
        catch (ParseException parambavf)
        {
          ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("lastModified time parse fail, url=%s", new Object[] { localanno.jdField_a_of_type_JavaLangString }));
          continue;
        }
        continue;
      }
      label202:
      Object localObject = null;
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     annc
 * JD-Core Version:    0.7.0.1
 */