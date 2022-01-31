import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bbps
{
  long jdField_a_of_type_Long;
  ajzd jdField_a_of_type_Ajzd;
  public bbpu a;
  public bbpx a;
  public QQLruCache<String, bbpy> a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new bbpt(this);
  public String a;
  ArrayList<bbpw> jdField_a_of_type_JavaUtilArrayList;
  public Map<String, List<String>> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  public bbpu b;
  public String b;
  public AtomicBoolean b;
  public boolean b;
  public String c;
  
  public bbps(QQAppInterface paramQQAppInterface, ajzd paramajzd)
  {
    this.jdField_a_of_type_Bbpu = new bbpu();
    this.jdField_b_of_type_Bbpu = new bbpu();
    this.jdField_a_of_type_Bbpx = new bbpx();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_Bbpu.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Ajzd = paramajzd;
    this.jdField_b_of_type_Boolean = paramajzd.b().getBoolean("mall_entrance_switch", false);
    this.jdField_a_of_type_Boolean = paramajzd.b().getBoolean("redpacket_is_show_switch", false);
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(1009, 100, 300);
    this.jdField_a_of_type_Bbpx.f = 8;
    this.jdField_b_of_type_Bbpu.f = 26;
    ((VasQuickUpdateManager)paramQQAppInterface.getManager(184)).addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
  }
  
  public static boolean a(bbpx parambbpx)
  {
    if ((parambbpx == null) || (parambbpx.f == 0)) {}
    for (;;)
    {
      return false;
      parambbpx = ajzd.a(parambbpx.jdField_d_of_type_JavaLangString, parambbpx.c, parambbpx.f, parambbpx.jdField_d_of_type_Int, 0);
      if (TextUtils.isEmpty(parambbpx)) {}
      for (parambbpx = null; (parambbpx != null) && (parambbpx.exists()) && (parambbpx.isFile()); parambbpx = new File(parambbpx)) {
        return true;
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool3 = false;
    File localFile1 = new File(paramString1);
    if ((localFile1 != null) && (localFile1.exists()) && (localFile1.isFile())) {
      if (QLog.isColorLevel()) {
        QLog.d("IndividualRedPacketResDownloader", 2, "uncompressZip zipFile.exists(), zipFile.length()=" + localFile1.length());
      }
    }
    for (;;)
    {
      try
      {
        bbdx.a(paramString1, paramString2, false);
        File localFile2 = new File(paramString2);
        if (localFile2.exists())
        {
          i = ThemeUtil.getFileNumInFile(localFile2);
          if (i > 0)
          {
            i = 1;
            if (i == 0)
            {
              paramString2 = new File(paramString2);
              QLog.d("IndividualRedPacketResDownloader", 1, "uncompressZip DownloaderFactory.unzipResource, themeZipPath:" + paramString1);
              bool1 = bbww.a(localFile1, paramString2, false);
              bool2 = bool1;
              j = i;
              if (i == 0)
              {
                bool2 = bool1;
                j = i;
                if (!bool1)
                {
                  bbdx.d(paramString1);
                  QLog.e("IndividualRedPacketResDownloader", 1, "uncompressZip result false");
                  j = i;
                  bool2 = bool1;
                }
              }
              if (j == 0)
              {
                bool1 = bool3;
                if (!bool2) {}
              }
              else
              {
                bool1 = true;
              }
              return bool1;
            }
          }
          else
          {
            QLog.e("IndividualRedPacketResDownloader", 1, "uncompressZip fileNum == 0");
            i = 0;
            continue;
          }
        }
      }
      catch (IOException localIOException)
      {
        QLog.e("IndividualRedPacketResDownloader", 1, "uncompressZip FileUtils.uncompressZip IOException:" + localIOException.getMessage());
        int i = 0;
        continue;
        boolean bool1 = false;
        continue;
        i = 0;
        continue;
      }
      boolean bool2 = false;
      int j = 0;
    }
  }
  
  public bbpy a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = new File(ajzd.a(paramString, null, 0, 0, 0));
    } while (!paramString.exists());
    try
    {
      bbpy localbbpy = a(new JSONObject(bbdx.a(paramString)), true);
      if (localbbpy != null) {
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(localbbpy.jdField_a_of_type_JavaLangString, localbbpy);
      }
      return localbbpy;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "loadPacketJson ,filePath:" + paramString.getAbsolutePath(), localThrowable);
    }
    return null;
  }
  
  public bbpy a(String paramString, boolean paramBoolean)
  {
    bbpy localbbpy = (bbpy)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
    if (!paramBoolean) {}
    while ((localbbpy != null) && (localbbpy.jdField_a_of_type_Bbpv != null) && (localbbpy.jdField_b_of_type_Bbpv != null) && (localbbpy.jdField_c_of_type_Bbpv != null)) {
      return localbbpy;
    }
    return a(paramString);
  }
  
  bbpy a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject == null) {
      return null;
    }
    label1042:
    for (;;)
    {
      Object localObject1;
      bbpy localbbpy;
      Object localObject2;
      try
      {
        localObject1 = paramJSONObject.optString("id");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localbbpy = new bbpy();
        localbbpy.jdField_a_of_type_Bbpv = new bbpv();
        localbbpy.jdField_a_of_type_Bbpv.f = 2;
        localbbpy.jdField_b_of_type_Bbpv = new bbpv();
        localbbpy.jdField_b_of_type_Bbpv.f = 3;
        localbbpy.jdField_c_of_type_Bbpv = new bbpv();
        localbbpy.jdField_c_of_type_Bbpv.f = 14;
        localbbpy.jdField_a_of_type_JavaLangString = ((String)localObject1);
        localbbpy.jdField_a_of_type_Bbpv.jdField_d_of_type_JavaLangString = ((String)localObject1);
        localbbpy.jdField_b_of_type_Bbpv.jdField_d_of_type_JavaLangString = ((String)localObject1);
        localbbpy.jdField_c_of_type_Bbpv.jdField_d_of_type_JavaLangString = ((String)localObject1);
        localbbpy.jdField_a_of_type_Bbpv.c = paramJSONObject.optString("name");
        localbbpy.jdField_b_of_type_Bbpv.c = localbbpy.jdField_a_of_type_Bbpv.c;
        localbbpy.jdField_c_of_type_Bbpv.c = localbbpy.jdField_a_of_type_Bbpv.c;
        localbbpy.jdField_a_of_type_Int = paramJSONObject.optInt("customWord", bbpy.jdField_c_of_type_Int);
        localbbpy.e = paramJSONObject.optInt("fontTypeId", 1);
        localbbpy.jdField_d_of_type_Int = paramJSONObject.optInt("version", 0);
        localbbpy.jdField_a_of_type_Bbpv.jdField_d_of_type_Int = localbbpy.jdField_d_of_type_Int;
        localbbpy.jdField_b_of_type_Bbpv.jdField_d_of_type_Int = localbbpy.jdField_d_of_type_Int;
        localbbpy.jdField_c_of_type_Bbpv.jdField_d_of_type_Int = localbbpy.jdField_d_of_type_Int;
        if (localbbpy.jdField_a_of_type_Int != bbpy.jdField_b_of_type_Int) {
          break label875;
        }
        localObject1 = paramJSONObject.optJSONArray("aioChar");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() >= 4))
        {
          localbbpy.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidGraphicsRect = new Rect(((JSONArray)localObject1).optInt(0), ((JSONArray)localObject1).optInt(1), ((JSONArray)localObject1).optInt(0) + ((JSONArray)localObject1).optInt(2), ((JSONArray)localObject1).optInt(1) + ((JSONArray)localObject1).optInt(3));
          localbbpy.jdField_a_of_type_Bbpv.jdField_a_of_type_Int = ((JSONArray)localObject1).optInt(2);
          localObject1 = paramJSONObject.optJSONArray("packetChar");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() >= 4))
          {
            localbbpy.jdField_b_of_type_Bbpv.jdField_a_of_type_AndroidGraphicsRect = new Rect(((JSONArray)localObject1).optInt(0), ((JSONArray)localObject1).optInt(1), ((JSONArray)localObject1).optInt(0) + ((JSONArray)localObject1).optInt(2), ((JSONArray)localObject1).optInt(1) + ((JSONArray)localObject1).optInt(3));
            localbbpy.jdField_b_of_type_Bbpv.jdField_a_of_type_Int = ((JSONArray)localObject1).optInt(2);
            localObject1 = paramJSONObject.optJSONArray("sendChar");
            if ((localObject1 == null) || (((JSONArray)localObject1).length() < 4)) {
              break label809;
            }
            localbbpy.jdField_c_of_type_Bbpv.jdField_a_of_type_AndroidGraphicsRect = new Rect(((JSONArray)localObject1).optInt(0), ((JSONArray)localObject1).optInt(1), ((JSONArray)localObject1).optInt(0) + ((JSONArray)localObject1).optInt(2), ((JSONArray)localObject1).optInt(1) + ((JSONArray)localObject1).optInt(3));
            localbbpy.jdField_c_of_type_Bbpv.jdField_a_of_type_Int = ((JSONArray)localObject1).optInt(2);
            localObject2 = localbbpy.jdField_a_of_type_Bbpv;
            if (localbbpy.jdField_a_of_type_Bbpv.jdField_a_of_type_Acvd != null) {
              break label1042;
            }
            localObject1 = paramJSONObject.optString("aioImgUrl", "");
            ((bbpv)localObject2).e = ((String)localObject1);
            localbbpy.jdField_b_of_type_Bbpv.e = paramJSONObject.optString("redEnvelopeImgUrl", "");
            localbbpy.jdField_c_of_type_Bbpv.e = paramJSONObject.optString("sendImgUrl", "");
            return localbbpy;
          }
        }
        else
        {
          QLog.e("IndividualRedPacketResDownloader", 2, "getTemplateByJson aioChar error,name:" + localbbpy.jdField_a_of_type_Bbpv.c + ", id:" + localbbpy.jdField_a_of_type_JavaLangString + ", isV710:" + paramBoolean);
          localbbpy.jdField_a_of_type_Bbpv.jdField_a_of_type_AndroidGraphicsRect = new Rect(1, 1, 1, 1);
          localbbpy.jdField_a_of_type_Bbpv.jdField_a_of_type_Int = 1;
          localbbpy.jdField_a_of_type_Int = bbpy.jdField_c_of_type_Int;
          continue;
        }
        QLog.e("IndividualRedPacketResDownloader", 2, "getTemplateByJson packetChar error,name:" + localbbpy.jdField_a_of_type_Bbpv.c + ", id:" + localbbpy.jdField_a_of_type_JavaLangString + ", isV710:" + paramBoolean);
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "getTemplateByJson Err:" + paramJSONObject.toString() + ", isV710:" + paramBoolean);
        return null;
      }
      localbbpy.jdField_b_of_type_Bbpv.jdField_a_of_type_AndroidGraphicsRect = new Rect(1, 1, 1, 1);
      localbbpy.jdField_b_of_type_Bbpv.jdField_a_of_type_Int = 1;
      localbbpy.jdField_a_of_type_Int = bbpy.jdField_c_of_type_Int;
      continue;
      label809:
      if (QLog.isColorLevel())
      {
        QLog.d("IndividualRedPacketResDownloader", 2, "getTemplateByJson sendChar error,name:" + localbbpy.jdField_a_of_type_Bbpv.c + ", id:" + localbbpy.jdField_a_of_type_JavaLangString + ", isV710:" + paramBoolean);
        continue;
        label875:
        localObject1 = paramJSONObject.optString("aioPngZip", null);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).indexOf("http") >= 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("IndividualRedPacketResDownloader", 2, "getTemplateByJson aioPngZip ,name=" + localbbpy.jdField_a_of_type_Bbpv.c + ", id:" + localbbpy.jdField_a_of_type_JavaLangString + ", url:" + (String)localObject1 + ", isV710:" + paramBoolean);
          }
          localObject2 = new acvd();
          ((acvd)localObject2).jdField_b_of_type_Int = paramJSONObject.optInt("interval", 100);
          ((acvd)localObject2).jdField_a_of_type_Int = paramJSONObject.optInt("flameCount", 0);
          localbbpy.jdField_a_of_type_Bbpv.jdField_a_of_type_Acvd = ((acvd)localObject2);
          localbbpy.jdField_a_of_type_Bbpv.jdField_a_of_type_JavaLangString = ((String)localObject1);
          localbbpy.jdField_a_of_type_Bbpv.f = 19;
          continue;
          localObject1 = localbbpy.jdField_a_of_type_Bbpv.jdField_a_of_type_JavaLangString;
        }
      }
    }
  }
  
  void a()
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_Ajzd != null) && (this.jdField_a_of_type_JavaUtilArrayList != null))
        {
          int i = this.jdField_a_of_type_JavaUtilArrayList.size();
          if (i > 0) {}
        }
        else
        {
          return;
        }
        try
        {
          bbpw localbbpw = (bbpw)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
          if (localbbpw != null) {
            break label99;
          }
          a();
        }
        catch (Exception localException)
        {
          QLog.d("IndividualRedPacketResDownloader", 2, "preDownload, err=" + localException.getMessage());
        }
        continue;
        if (!new File(localObject.jdField_b_of_type_JavaLangString).exists()) {
          break label123;
        }
      }
      finally {}
      label99:
      a();
      continue;
      label123:
      VasQuickUpdateManager localVasQuickUpdateManager = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184);
      localVasQuickUpdateManager.addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
      localVasQuickUpdateManager.downloadItem(localObject.jdField_a_of_type_Long, localObject.jdField_a_of_type_JavaLangString, "silent_download.redbag");
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (0L == paramLong) || (TextUtils.isEmpty(paramString1)))
        {
          QLog.e("IndividualRedPacketResDownloader", 1, "downloadResIfNotExsit err filePath, bid=" + paramLong + ",id:" + paramString1);
          return;
        }
        if ("iRedPacket_v3.specialChar.zip".equals(paramString1))
        {
          paramString2 = ajzd.a(null, null, 11, 0, 0);
          VasQuickUpdateManager.getFileFromLocal(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, paramString1, paramString2, true, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
          continue;
        }
        paramString2 = new File(ajzd.a(paramString1, null, 24, 0, 0));
      }
      finally {}
      boolean bool = paramString2.exists();
      if (QLog.isColorLevel()) {
        QLog.d("IndividualRedPacketResDownloader", 1, "downloadResIfNotExsit, id: " + paramString1 + " exists: " + bool);
      }
      if (bool) {
        VasQuickUpdateEngine.safeDeleteFile(paramString2);
      }
      paramString2 = ajzd.a(paramString1, null, 0, 0, 0);
      paramString1 = "luckyMoney.item." + paramString1;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject7;
    label230:
    Object localObject8;
    label428:
    label484:
    Object localObject9;
    label527:
    label557:
    label635:
    int j;
    int i;
    int m;
    int n;
    label694:
    int i1;
    label778:
    label807:
    String str1;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          localObject1 = this.jdField_a_of_type_Ajzd;
          if (localObject1 != null) {
            continue;
          }
        }
      }
      finally
      {
        try
        {
          Object localObject1 = new JSONObject(bbdx.a((File)localObject7));
          if (localObject1 != null) {
            break label230;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("IndividualRedPacketResDownloader", 2, "initAllConfigJson null == resJson,isAfterDownload:" + paramBoolean1 + ", isInit" + paramBoolean2);
        }
        catch (Throwable localThrowable)
        {
          boolean bool;
          QLog.e("IndividualRedPacketResDownloader", 2, "initJsonBySCID ,filePath:" + ((File)localObject7).getAbsolutePath(), localThrowable);
        }
        localObject2 = finally;
      }
      return;
      localObject1 = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + "iRedPacket_v3.json";
      localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!paramBoolean1)
      {
        bool = true;
        localObject7 = VasQuickUpdateManager.getFileFromLocal((AppRuntime)localObject7, 16L, "iRedPacket_v3.json", (String)localObject1, bool, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
        if (localObject7 != null)
        {
          bool = ((File)localObject7).exists();
          if (!bool) {}
        }
      }
      else
      {
        bool = false;
        continue;
      }
      Object localObject3 = null;
      continue;
      try
      {
        long l = localObject3.optLong("timestamp", 1L);
        if (QLog.isColorLevel()) {
          QLog.d("IndividualRedPacketResDownloader", 2, "initAllConfigJson timestamp=" + l + ", mJsonTimestamp:" + this.jdField_a_of_type_Long);
        }
        if (l > this.jdField_a_of_type_Long)
        {
          this.jdField_a_of_type_Long = l;
          localObject7 = localObject3.optJSONObject("data");
          if (localObject7 == null) {
            QLog.e("IndividualRedPacketResDownloader", 2, "initAllConfigJson, null == data, timestamp=" + l + ", mJsonTimestamp:" + this.jdField_a_of_type_Long);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse parse Json config JSONException: ", localJSONException);
        bbrq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_redpacket_json_err", "decode_json_err", localJSONException.getMessage(), null, 0.0F);
        continue;
        Object localObject4 = ((JSONObject)localObject7).optJSONArray("activityInfo");
        if ((localObject4 == null) || (((JSONArray)localObject4).length() <= 0)) {
          break label1700;
        }
        localObject4 = ((JSONArray)localObject4).optJSONObject(0);
        paramBoolean1 = false;
        if (localObject4 != null)
        {
          localObject8 = ((JSONObject)localObject4).optString("time");
          if (!TextUtils.isEmpty((CharSequence)localObject8))
          {
            if (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String)localObject8).getTime() - NetConnInfoCenter.getServerTimeMillis() >= 172800000L) {
              break label1706;
            }
            paramBoolean1 = true;
          }
          localObject8 = this.jdField_a_of_type_Ajzd.b();
          localObject9 = ((SharedPreferences)localObject8).edit();
          if (((JSONObject)localObject4).has("androidShowSwitch"))
          {
            if (((JSONObject)localObject4).getInt("androidShowSwitch") != 1) {
              break label1711;
            }
            paramBoolean2 = true;
            this.jdField_a_of_type_Boolean = paramBoolean2;
          }
          if (((JSONObject)localObject4).has("androidEntrySwitch"))
          {
            if (((JSONObject)localObject4).getInt("androidEntrySwitch") != 1) {
              break label1716;
            }
            paramBoolean2 = true;
            this.jdField_b_of_type_Boolean = paramBoolean2;
          }
          if ((this.jdField_a_of_type_Boolean == ((SharedPreferences)localObject8).getBoolean("redpacket_is_show_switch", false)) && (this.jdField_b_of_type_Boolean == ((SharedPreferences)localObject8).getBoolean("mall_entrance_switch", false))) {
            break label1688;
          }
          ((SharedPreferences.Editor)localObject9).putBoolean("redpacket_is_show_switch", this.jdField_a_of_type_Boolean);
          ((SharedPreferences.Editor)localObject9).putBoolean("mall_entrance_switch", this.jdField_b_of_type_Boolean);
          ((SharedPreferences.Editor)localObject9).commit();
          break label1688;
          localObject4 = ((JSONObject)localObject7).optJSONArray("isPreload");
          j = 0;
          i = 0;
          if ((localObject4 == null) || (((JSONArray)localObject4).length() <= 0)) {
            break label1678;
          }
          localObject4 = ((JSONArray)localObject4).optJSONObject(0);
          m = ((JSONObject)localObject4).optInt("isPreload", 5);
          n = ((JSONObject)localObject4).optInt("preloadTotal", 50);
          localObject8 = ((JSONObject)localObject7).optJSONArray("templateIdList");
          if (QLog.isColorLevel())
          {
            localObject9 = new StringBuilder().append("checkAndDownloadBeforeUse ,emergencyDownload:").append(paramBoolean1).append(", templateIdList:");
            if (localObject8 != null) {
              break label841;
            }
          }
        }
        for (localObject4 = "null";; localObject4 = Integer.valueOf(((JSONArray)localObject8).length()))
        {
          QLog.d("IndividualRedPacketResDownloader", 2, localObject4);
          localObject9 = new ArrayList();
          if (localObject8 == null) {
            break label1326;
          }
          i1 = 0;
          j = i;
          if (i1 >= ((JSONArray)localObject8).length()) {
            break label1326;
          }
          if ((i1 >= n) || (i >= m)) {
            break label1721;
          }
          j = 1;
          str1 = ((JSONArray)localObject8).optString(i1);
          if (!TextUtils.isEmpty(str1)) {
            break label854;
          }
          break label1691;
          QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse ,activityInfoObj0 == null");
          paramBoolean1 = false;
          break;
        }
        localObject4 = (bbpy)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(str1);
        synchronized (this.jdField_a_of_type_JavaUtilMap)
        {
          if (!this.jdField_a_of_type_JavaUtilMap.containsKey(str1)) {
            break label1672;
          }
          if ((localObject4 != null) && (!a(((bbpy)localObject4).jdField_a_of_type_Bbpv)) && (!a(((bbpy)localObject4).jdField_b_of_type_Bbpv)) && (!a(((bbpy)localObject4).jdField_c_of_type_Bbpv))) {
            break label1669;
          }
          localObject4 = a(str1);
          label937:
          if ((localObject4 == null) || (!a(((bbpy)localObject4).jdField_a_of_type_Bbpv)) || (!a(((bbpy)localObject4).jdField_b_of_type_Bbpv)) || (!a(((bbpy)localObject4).jdField_c_of_type_Bbpv))) {
            break label1282;
          }
          List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(str1);
          k = 0;
          if (k >= localList.size()) {
            break;
          }
          String str2 = (String)localList.get(k);
          if (TextUtils.isEmpty(str2)) {
            break label1727;
          }
          this.jdField_a_of_type_Ajzd.a(str2, ((bbpy)localObject4).jdField_a_of_type_Bbpv.f);
          this.jdField_a_of_type_Ajzd.a(str2 + "_tp", ((bbpy)localObject4).jdField_b_of_type_Bbpv.f);
          this.jdField_a_of_type_Ajzd.a(str2 + "_send", ((bbpy)localObject4).jdField_c_of_type_Bbpv.f);
        }
      }
      catch (Exception localException)
      {
        label841:
        label854:
        label994:
        QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse parse Json config error: ", localException);
      }
    }
    this.jdField_a_of_type_JavaUtilMap.remove(str1);
    int k = 0;
    label1162:
    label1200:
    Object localObject6;
    if ((j != 0) && (k == 0))
    {
      if (new File(ajzd.a(str1, null, 0, 0, 0)).exists()) {
        j = 0;
      }
      for (;;)
      {
        if ((j != 0) && (k == 0))
        {
          i += 1;
          localObject6 = new bbpw();
          ((bbpw)localObject6).jdField_a_of_type_Long = 16L;
          ((bbpw)localObject6).jdField_a_of_type_JavaLangString = ("luckyMoney.item." + str1);
          ((bbpw)localObject6).jdField_b_of_type_JavaLangString = ajzd.a(str1, null, 0, 0, 0);
          ((ArrayList)localObject9).add(localObject6);
          break label1691;
          label1282:
          a(16L, str1, null);
          k = 1;
          break;
          if (new File(ajzd.a(str1, null, 3, 0, 0)).exists()) {
            break label1736;
          }
          j = 1;
          continue;
          label1326:
          if (QLog.isColorLevel()) {
            QLog.d("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse finish! size = " + this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.size() + ", preloadSize=" + j + ", totalCanPreload=" + m);
          }
          localObject6 = ((JSONObject)localObject7).optJSONArray("vipRedPacketURL");
          if (localObject6 != null) {
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject6).length())
      {
        localObject8 = ((JSONArray)localObject6).optJSONObject(i);
        localObject7 = ((JSONObject)localObject8).optString("name");
        localObject8 = ((JSONObject)localObject8).optString("url", null);
        if ("aioTail".equals(localObject7)) {
          this.jdField_b_of_type_JavaLangString = ((String)localObject8);
        } else if ("personalityMall".equals(localObject7)) {
          this.jdField_a_of_type_JavaLangString = ((String)localObject8);
        } else if ("tencentPay".equals(localObject7)) {
          this.c = ((String)localObject8);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse mAioTailURL:" + this.jdField_b_of_type_JavaLangString + ", mTencentPayURL:" + this.c + ", mPersonalityMallURL:" + this.jdField_a_of_type_JavaLangString);
        }
        label1562:
        i = bbfj.a(null);
        if (this.jdField_a_of_type_JavaUtilArrayList == null)
        {
          this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject9);
          label1580:
          if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || ((1 != i) && (!paramBoolean1)) || (!this.jdField_a_of_type_Ajzd.b())) {
            break label1655;
          }
          a();
        }
        for (;;)
        {
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          break;
          if (!QLog.isColorLevel()) {
            break label1562;
          }
          QLog.d("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse urllist == null");
          break label1562;
          this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject9);
          break label1580;
          label1655:
          this.jdField_a_of_type_JavaUtilArrayList = null;
        }
        break label1691;
        break label1200;
        label1669:
        break label937;
        label1672:
        k = 0;
        break label1162;
        label1678:
        m = 5;
        n = 50;
        break label694;
        label1688:
        break label635;
        label1691:
        i1 += 1;
        break label778;
        label1700:
        localObject6 = null;
        break label428;
        label1706:
        paramBoolean1 = false;
        break label484;
        label1711:
        paramBoolean2 = false;
        break label527;
        label1716:
        paramBoolean2 = false;
        break label557;
        label1721:
        j = 0;
        break label807;
        label1727:
        k += 1;
        break label994;
        label1736:
        j = 0;
        break label1200;
      }
      i += 1;
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, File paramFile)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_Ajzd == null)) {
      return;
    }
    if ((paramFile != null) && (paramFile.exists())) {}
    File localFile;
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(bbdx.a(paramFile));
        if (localObject1 != null) {
          break label172;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        localObject1 = new StringBuilder().append("initJsonBySCID null == resJson, scid=").append(paramString).append(", isAfterDownload:").append(paramBoolean1).append(", isInit").append(paramBoolean2).append(", file=");
        if (paramFile == null) {
          break label165;
        }
        paramString = paramFile.getAbsolutePath();
        QLog.e("IndividualRedPacketResDownloader", 2, paramString);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "initJsonBySCID ,filePath:" + paramFile.getAbsolutePath(), localThrowable);
      }
      localFile = null;
      continue;
      label165:
      paramString = "null";
    }
    for (;;)
    {
      try
      {
        label172:
        Object localObject2;
        if ("iRedPacket_v3.char300.json".equals(paramString))
        {
          localObject2 = localFile.optJSONArray("data");
          if (localObject2 != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            int i = 0;
            if (i < ((JSONArray)localObject2).length())
            {
              localStringBuilder.append(((JSONArray)localObject2).getString(i));
              i += 1;
              continue;
            }
            this.jdField_a_of_type_Bbpu.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
            this.jdField_a_of_type_Bbpu.e = 2;
          }
        }
        if ("iRedPacket_v3.font.zip".equals(paramString))
        {
          this.jdField_a_of_type_Bbpx.jdField_d_of_type_JavaLangString = localFile.optString("id", "");
          this.jdField_a_of_type_Bbpx.c = localFile.optString("name", "");
          this.jdField_a_of_type_Bbpx.jdField_d_of_type_Int = localFile.optInt("version");
          this.jdField_a_of_type_Bbpx.e = 2;
          this.jdField_a_of_type_Ajzd.a(this.jdField_a_of_type_Bbpx.jdField_d_of_type_JavaLangString);
        }
        if ("iRedPacket_v3.specialChar.zip".equals(paramString))
        {
          this.jdField_b_of_type_Bbpu.jdField_d_of_type_JavaLangString = localFile.optString("id", "0");
          this.jdField_b_of_type_Bbpu.jdField_d_of_type_Int = localFile.optInt("version");
          this.jdField_b_of_type_Bbpu.e = 2;
          this.jdField_b_of_type_Bbpu.jdField_b_of_type_JavaLangString = localFile.optString("char", "");
          this.jdField_b_of_type_Bbpu.jdField_a_of_type_JavaLangString = ("" + this.jdField_b_of_type_Bbpu.jdField_b_of_type_JavaLangString);
          paramString = this.jdField_b_of_type_Bbpu.jdField_d_of_type_JavaLangString + this.jdField_b_of_type_Bbpu.jdField_d_of_type_Int;
          if ((!TextUtils.isEmpty(this.jdField_b_of_type_Bbpu.jdField_b_of_type_JavaLangString)) && (!paramString.equals(this.jdField_a_of_type_Ajzd.b().getString("special_unzip_version_key", ""))))
          {
            localFile = new File(ajzd.a(null, null, 26, 0, 0));
            localObject2 = ajzd.a(2) + "images";
            if (!a(localFile.getAbsolutePath(), (String)localObject2)) {
              break label681;
            }
            this.jdField_a_of_type_Ajzd.b().edit().putString("special_unzip_version_key", paramString).commit();
          }
        }
        if ((this.jdField_a_of_type_Bbpu.e != 2) || (this.jdField_a_of_type_Bbpx.e != 2) || (!this.jdField_a_of_type_Ajzd.b())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse goto preCreatePersonalFontImg");
        }
        this.jdField_a_of_type_Ajzd.a(this.jdField_a_of_type_Bbpu);
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "initJsonBySCID parse Json config JSONException: ", paramString);
        bbrq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_redpacket_json_err", "decode_json_err", paramString.getMessage(), null, 0.0F);
        return;
      }
      label681:
      if ((!localFile.exists()) && (paramFile != null)) {
        paramFile.delete();
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184)).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.evictAll();
    this.jdField_a_of_type_Ajzd = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    a(false, true);
    String str = ajzd.a(null, null, 8, 0, 0);
    if (VasQuickUpdateManager.getFileFromLocal(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 16L, "iRedPacket_v3.font.zip", str, true, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker) != null) {
      a(false, true, "iRedPacket_v3.font.zip", new File(ajzd.a(null, null, 21, 0, 0)));
    }
    str = ajzd.a(null, null, 25, 0, 0);
    a(false, true, "iRedPacket_v3.specialChar.zip", VasQuickUpdateManager.getFileFromLocal(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 16L, "iRedPacket_v3.specialChar.zip", str, true, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker));
    str = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + "iRedPacket_v3.char300.json";
    a(false, true, "iRedPacket_v3.char300.json", VasQuickUpdateManager.getFileFromLocal(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 16L, "iRedPacket_v3.char300.json", str, true, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker));
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_Ajzd == null)) {}
    File localFile1;
    File localFile2;
    File localFile3;
    int j;
    int i;
    for (;;)
    {
      return;
      if (!this.jdField_a_of_type_Ajzd.c.get()) {
        try
        {
          if (!this.jdField_a_of_type_Ajzd.b().getBoolean("res_version_has_updated", false))
          {
            Object localObject1 = new File(ajzd.a(3) + "10029_0");
            localObject3 = new File(ajzd.a(null, null, 8, 0, 0));
            if ((((File)localObject1).exists()) && (!((File)localObject3).exists())) {
              ((File)localObject1).renameTo((File)localObject3);
            }
            localFile1 = new File(bbvj.a(ajsd.aW + "RedPacket/templateAIO"));
            localFile2 = new File(bbvj.a(ajsd.aW + "RedPacket/templateTENPAY"));
            localFile3 = new File(bbvj.a(ajsd.aW + "RedPacket/templateSEND"));
            j = 0;
            i = j;
            if (localFile1.exists())
            {
              i = j;
              if (localFile1.isDirectory())
              {
                i = j;
                if (localFile2.exists())
                {
                  i = j;
                  if (localFile2.isDirectory())
                  {
                    i = j;
                    if (localFile3.exists())
                    {
                      i = j;
                      if (localFile3.isDirectory())
                      {
                        localObject1 = localFile1.list();
                        localObject3 = localFile2.list();
                        localObject4 = localFile3.list();
                        i = j;
                        if (localObject1.length > 0)
                        {
                          i = j;
                          if (localObject3.length > 0)
                          {
                            i = j;
                            if (localObject4.length > 0) {
                              i = 1;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            if (i == 0)
            {
              this.jdField_a_of_type_Ajzd.b().edit().putBoolean("res_version_has_updated", true).commit();
              return;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion TODO v7.10 updateErr:" + localThrowable.toString());
          return;
        }
      }
    }
    Object localObject3 = bboe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bboe.g, false);
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IndividualRedPacketResDownloader", 2, "updateResVersion null == resJson waiting download");
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
      localObject4 = bboe.g.jdField_a_of_type_JavaLangString;
      localObject2 = new File(((Context)localObject2).getFilesDir(), (String)localObject4);
      localObject2 = new bbwu(bboe.g.jdField_b_of_type_JavaLangString, (File)localObject2);
      ((bbwu)localObject2).n = true;
      if (bbww.a((bbwu)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) {
        break label516;
      }
    }
    for (localObject2 = bboe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bboe.g, false); localObject2 == null; localObject2 = localObject3)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion fail Err, return");
      return;
      label516:
      QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion download Err : " + bboe.g.jdField_b_of_type_JavaLangString);
    }
    localObject2 = ((JSONObject)localObject2).optJSONObject("data");
    if (localObject2 == null)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion data fail Err, return");
      return;
    }
    Object localObject4 = ((JSONObject)localObject2).optJSONArray("templateList");
    Object localObject6;
    if (localObject4 == null)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion templateList fail Err, return");
      return;
      if (i < ((JSONArray)localObject4).length())
      {
        Object localObject5 = a(((JSONArray)localObject4).optJSONObject(i), false);
        if ((localObject5 == null) || (((bbpy)localObject5).jdField_a_of_type_Bbpv == null) || (((bbpy)localObject5).jdField_b_of_type_Bbpv == null) || (((bbpy)localObject5).jdField_c_of_type_Bbpv == null) || (new File(ajzd.a(((bbpy)localObject5).jdField_a_of_type_JavaLangString, null, 0, 0, 0)).exists())) {
          break label1104;
        }
        localObject6 = ((bbpy)localObject5).jdField_a_of_type_JavaLangString + "_" + ((bbpy)localObject5).jdField_d_of_type_Int;
        localObject3 = localFile1.getAbsolutePath() + File.separator + (String)localObject6;
        bbpv localbbpv = ((bbpy)localObject5).jdField_a_of_type_Bbpv;
        localObject2 = localObject3;
        if (localbbpv.f == 19) {
          localObject2 = (String)localObject3 + "_zip";
        }
        if (!new File((String)localObject2).exists()) {
          break label1104;
        }
        localObject3 = new String[3];
        localObject3[0] = localObject2;
        localObject3[1] = (localFile2.getAbsolutePath() + File.separator + (String)localObject6);
        localObject3[2] = (localFile3.getAbsolutePath() + File.separator + (String)localObject6);
        localObject2 = ((bbpy)localObject5).jdField_b_of_type_Bbpv;
        localObject5 = ((bbpy)localObject5).jdField_c_of_type_Bbpv;
        localObject6 = new String[3];
        localObject6[0] = ajzd.a(localbbpv.jdField_d_of_type_JavaLangString, localbbpv.c, localbbpv.f, localbbpv.jdField_d_of_type_Int, 0);
        localObject6[1] = ajzd.a(((bbpv)localObject2).jdField_d_of_type_JavaLangString, ((bbpv)localObject2).c, ((bbpv)localObject2).f, ((bbpv)localObject2).jdField_d_of_type_Int, 0);
        localObject6[2] = ajzd.a(((bbpv)localObject5).jdField_d_of_type_JavaLangString, ((bbpv)localObject5).c, ((bbpv)localObject5).f, ((bbpv)localObject5).jdField_d_of_type_Int, 0);
        j = 0;
      }
    }
    for (;;)
    {
      if (j < localObject3.length)
      {
        if (bbdx.d(localObject3[j], localObject6[j])) {
          break label1111;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion copyFile aio file Err:" + localObject3[j] + ", newPath:" + localObject6[j]);
          break label1104;
          localObject2 = this.jdField_a_of_type_Ajzd.b().edit();
          ((SharedPreferences.Editor)localObject2).putBoolean("res_version_has_updated", true);
          ((SharedPreferences.Editor)localObject2).commit();
          VasQuickUpdateEngine.safeDeleteFile(localFile1);
          VasQuickUpdateEngine.safeDeleteFile(localFile2);
          VasQuickUpdateEngine.safeDeleteFile(localFile3);
          return;
          i = 0;
          break;
        }
      }
      label1104:
      i += 1;
      break;
      label1111:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbps
 * JD-Core Version:    0.7.0.1
 */