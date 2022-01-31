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

public class bani
{
  long jdField_a_of_type_Long;
  ajkz jdField_a_of_type_Ajkz;
  public bank a;
  public bann a;
  public QQLruCache<String, bano> a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new banj(this);
  public String a;
  ArrayList<banm> jdField_a_of_type_JavaUtilArrayList;
  public Map<String, List<String>> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  public bank b;
  public String b;
  public AtomicBoolean b;
  public boolean b;
  public String c;
  
  public bani(QQAppInterface paramQQAppInterface, ajkz paramajkz)
  {
    this.jdField_a_of_type_Bank = new bank();
    this.jdField_b_of_type_Bank = new bank();
    this.jdField_a_of_type_Bann = new bann();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_Bank.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Ajkz = paramajkz;
    this.jdField_b_of_type_Boolean = paramajkz.b().getBoolean("mall_entrance_switch", false);
    this.jdField_a_of_type_Boolean = paramajkz.b().getBoolean("redpacket_is_show_switch", false);
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(1009, 100, 300);
    this.jdField_a_of_type_Bann.f = 8;
    this.jdField_b_of_type_Bank.f = 26;
    ((VasQuickUpdateManager)paramQQAppInterface.getManager(184)).addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
  }
  
  public static boolean a(bann parambann)
  {
    if ((parambann == null) || (parambann.f == 0)) {}
    for (;;)
    {
      return false;
      parambann = ajkz.a(parambann.jdField_d_of_type_JavaLangString, parambann.c, parambann.f, parambann.jdField_d_of_type_Int, 0);
      if (TextUtils.isEmpty(parambann)) {}
      for (parambann = null; (parambann != null) && (parambann.exists()) && (parambann.isFile()); parambann = new File(parambann)) {
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
        bace.a(paramString1, paramString2, false);
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
              bool1 = bato.a(localFile1, paramString2, false);
              bool2 = bool1;
              j = i;
              if (i == 0)
              {
                bool2 = bool1;
                j = i;
                if (!bool1)
                {
                  bace.d(paramString1);
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
  
  public bano a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = new File(ajkz.a(paramString, null, 0, 0, 0));
    } while (!paramString.exists());
    try
    {
      bano localbano = a(new JSONObject(bace.a(paramString)), true);
      if (localbano != null) {
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(localbano.jdField_a_of_type_JavaLangString, localbano);
      }
      return localbano;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "loadPacketJson ,filePath:" + paramString.getAbsolutePath(), localThrowable);
    }
    return null;
  }
  
  public bano a(String paramString, boolean paramBoolean)
  {
    bano localbano = (bano)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
    if (!paramBoolean) {}
    while ((localbano != null) && (localbano.jdField_a_of_type_Banl != null) && (localbano.jdField_b_of_type_Banl != null) && (localbano.jdField_c_of_type_Banl != null)) {
      return localbano;
    }
    return a(paramString);
  }
  
  bano a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject == null) {
      return null;
    }
    label1042:
    for (;;)
    {
      Object localObject1;
      bano localbano;
      Object localObject2;
      try
      {
        localObject1 = paramJSONObject.optString("id");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localbano = new bano();
        localbano.jdField_a_of_type_Banl = new banl();
        localbano.jdField_a_of_type_Banl.f = 2;
        localbano.jdField_b_of_type_Banl = new banl();
        localbano.jdField_b_of_type_Banl.f = 3;
        localbano.jdField_c_of_type_Banl = new banl();
        localbano.jdField_c_of_type_Banl.f = 14;
        localbano.jdField_a_of_type_JavaLangString = ((String)localObject1);
        localbano.jdField_a_of_type_Banl.jdField_d_of_type_JavaLangString = ((String)localObject1);
        localbano.jdField_b_of_type_Banl.jdField_d_of_type_JavaLangString = ((String)localObject1);
        localbano.jdField_c_of_type_Banl.jdField_d_of_type_JavaLangString = ((String)localObject1);
        localbano.jdField_a_of_type_Banl.c = paramJSONObject.optString("name");
        localbano.jdField_b_of_type_Banl.c = localbano.jdField_a_of_type_Banl.c;
        localbano.jdField_c_of_type_Banl.c = localbano.jdField_a_of_type_Banl.c;
        localbano.jdField_a_of_type_Int = paramJSONObject.optInt("customWord", bano.jdField_c_of_type_Int);
        localbano.e = paramJSONObject.optInt("fontTypeId", 1);
        localbano.jdField_d_of_type_Int = paramJSONObject.optInt("version", 0);
        localbano.jdField_a_of_type_Banl.jdField_d_of_type_Int = localbano.jdField_d_of_type_Int;
        localbano.jdField_b_of_type_Banl.jdField_d_of_type_Int = localbano.jdField_d_of_type_Int;
        localbano.jdField_c_of_type_Banl.jdField_d_of_type_Int = localbano.jdField_d_of_type_Int;
        if (localbano.jdField_a_of_type_Int != bano.jdField_b_of_type_Int) {
          break label875;
        }
        localObject1 = paramJSONObject.optJSONArray("aioChar");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() >= 4))
        {
          localbano.jdField_a_of_type_Banl.jdField_a_of_type_AndroidGraphicsRect = new Rect(((JSONArray)localObject1).optInt(0), ((JSONArray)localObject1).optInt(1), ((JSONArray)localObject1).optInt(0) + ((JSONArray)localObject1).optInt(2), ((JSONArray)localObject1).optInt(1) + ((JSONArray)localObject1).optInt(3));
          localbano.jdField_a_of_type_Banl.jdField_a_of_type_Int = ((JSONArray)localObject1).optInt(2);
          localObject1 = paramJSONObject.optJSONArray("packetChar");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() >= 4))
          {
            localbano.jdField_b_of_type_Banl.jdField_a_of_type_AndroidGraphicsRect = new Rect(((JSONArray)localObject1).optInt(0), ((JSONArray)localObject1).optInt(1), ((JSONArray)localObject1).optInt(0) + ((JSONArray)localObject1).optInt(2), ((JSONArray)localObject1).optInt(1) + ((JSONArray)localObject1).optInt(3));
            localbano.jdField_b_of_type_Banl.jdField_a_of_type_Int = ((JSONArray)localObject1).optInt(2);
            localObject1 = paramJSONObject.optJSONArray("sendChar");
            if ((localObject1 == null) || (((JSONArray)localObject1).length() < 4)) {
              break label809;
            }
            localbano.jdField_c_of_type_Banl.jdField_a_of_type_AndroidGraphicsRect = new Rect(((JSONArray)localObject1).optInt(0), ((JSONArray)localObject1).optInt(1), ((JSONArray)localObject1).optInt(0) + ((JSONArray)localObject1).optInt(2), ((JSONArray)localObject1).optInt(1) + ((JSONArray)localObject1).optInt(3));
            localbano.jdField_c_of_type_Banl.jdField_a_of_type_Int = ((JSONArray)localObject1).optInt(2);
            localObject2 = localbano.jdField_a_of_type_Banl;
            if (localbano.jdField_a_of_type_Banl.jdField_a_of_type_Acko != null) {
              break label1042;
            }
            localObject1 = paramJSONObject.optString("aioImgUrl", "");
            ((banl)localObject2).e = ((String)localObject1);
            localbano.jdField_b_of_type_Banl.e = paramJSONObject.optString("redEnvelopeImgUrl", "");
            localbano.jdField_c_of_type_Banl.e = paramJSONObject.optString("sendImgUrl", "");
            return localbano;
          }
        }
        else
        {
          QLog.e("IndividualRedPacketResDownloader", 2, "getTemplateByJson aioChar error,name:" + localbano.jdField_a_of_type_Banl.c + ", id:" + localbano.jdField_a_of_type_JavaLangString + ", isV710:" + paramBoolean);
          localbano.jdField_a_of_type_Banl.jdField_a_of_type_AndroidGraphicsRect = new Rect(1, 1, 1, 1);
          localbano.jdField_a_of_type_Banl.jdField_a_of_type_Int = 1;
          localbano.jdField_a_of_type_Int = bano.jdField_c_of_type_Int;
          continue;
        }
        QLog.e("IndividualRedPacketResDownloader", 2, "getTemplateByJson packetChar error,name:" + localbano.jdField_a_of_type_Banl.c + ", id:" + localbano.jdField_a_of_type_JavaLangString + ", isV710:" + paramBoolean);
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "getTemplateByJson Err:" + paramJSONObject.toString() + ", isV710:" + paramBoolean);
        return null;
      }
      localbano.jdField_b_of_type_Banl.jdField_a_of_type_AndroidGraphicsRect = new Rect(1, 1, 1, 1);
      localbano.jdField_b_of_type_Banl.jdField_a_of_type_Int = 1;
      localbano.jdField_a_of_type_Int = bano.jdField_c_of_type_Int;
      continue;
      label809:
      if (QLog.isColorLevel())
      {
        QLog.d("IndividualRedPacketResDownloader", 2, "getTemplateByJson sendChar error,name:" + localbano.jdField_a_of_type_Banl.c + ", id:" + localbano.jdField_a_of_type_JavaLangString + ", isV710:" + paramBoolean);
        continue;
        label875:
        localObject1 = paramJSONObject.optString("aioPngZip", null);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).indexOf("http") >= 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("IndividualRedPacketResDownloader", 2, "getTemplateByJson aioPngZip ,name=" + localbano.jdField_a_of_type_Banl.c + ", id:" + localbano.jdField_a_of_type_JavaLangString + ", url:" + (String)localObject1 + ", isV710:" + paramBoolean);
          }
          localObject2 = new acko();
          ((acko)localObject2).jdField_b_of_type_Int = paramJSONObject.optInt("interval", 100);
          ((acko)localObject2).jdField_a_of_type_Int = paramJSONObject.optInt("flameCount", 0);
          localbano.jdField_a_of_type_Banl.jdField_a_of_type_Acko = ((acko)localObject2);
          localbano.jdField_a_of_type_Banl.jdField_a_of_type_JavaLangString = ((String)localObject1);
          localbano.jdField_a_of_type_Banl.f = 19;
          continue;
          localObject1 = localbano.jdField_a_of_type_Banl.jdField_a_of_type_JavaLangString;
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
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_Ajkz != null) && (this.jdField_a_of_type_JavaUtilArrayList != null))
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
          banm localbanm = (banm)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
          if (localbanm != null) {
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
          paramString2 = ajkz.a(null, null, 11, 0, 0);
          VasQuickUpdateManager.getFileFromLocal(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, paramString1, paramString2, true, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
          continue;
        }
        paramString2 = new File(ajkz.a(paramString1, null, 24, 0, 0));
      }
      finally {}
      boolean bool = paramString2.exists();
      if (QLog.isColorLevel()) {
        QLog.d("IndividualRedPacketResDownloader", 1, "downloadResIfNotExsit, id: " + paramString1 + " exists: " + bool);
      }
      if (bool) {
        VasQuickUpdateEngine.safeDeleteFile(paramString2);
      }
      paramString2 = ajkz.a(paramString1, null, 0, 0, 0);
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
          localObject1 = this.jdField_a_of_type_Ajkz;
          if (localObject1 != null) {
            continue;
          }
        }
      }
      finally
      {
        try
        {
          Object localObject1 = new JSONObject(bace.a((File)localObject7));
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
        bapf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_redpacket_json_err", "decode_json_err", localJSONException.getMessage(), null, 0.0F);
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
          localObject8 = this.jdField_a_of_type_Ajkz.b();
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
        localObject4 = (bano)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(str1);
        synchronized (this.jdField_a_of_type_JavaUtilMap)
        {
          if (!this.jdField_a_of_type_JavaUtilMap.containsKey(str1)) {
            break label1672;
          }
          if ((localObject4 != null) && (!a(((bano)localObject4).jdField_a_of_type_Banl)) && (!a(((bano)localObject4).jdField_b_of_type_Banl)) && (!a(((bano)localObject4).jdField_c_of_type_Banl))) {
            break label1669;
          }
          localObject4 = a(str1);
          label937:
          if ((localObject4 == null) || (!a(((bano)localObject4).jdField_a_of_type_Banl)) || (!a(((bano)localObject4).jdField_b_of_type_Banl)) || (!a(((bano)localObject4).jdField_c_of_type_Banl))) {
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
          this.jdField_a_of_type_Ajkz.a(str2, ((bano)localObject4).jdField_a_of_type_Banl.f);
          this.jdField_a_of_type_Ajkz.a(str2 + "_tp", ((bano)localObject4).jdField_b_of_type_Banl.f);
          this.jdField_a_of_type_Ajkz.a(str2 + "_send", ((bano)localObject4).jdField_c_of_type_Banl.f);
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
      if (new File(ajkz.a(str1, null, 0, 0, 0)).exists()) {
        j = 0;
      }
      for (;;)
      {
        if ((j != 0) && (k == 0))
        {
          i += 1;
          localObject6 = new banm();
          ((banm)localObject6).jdField_a_of_type_Long = 16L;
          ((banm)localObject6).jdField_a_of_type_JavaLangString = ("luckyMoney.item." + str1);
          ((banm)localObject6).jdField_b_of_type_JavaLangString = ajkz.a(str1, null, 0, 0, 0);
          ((ArrayList)localObject9).add(localObject6);
          break label1691;
          label1282:
          a(16L, str1, null);
          k = 1;
          break;
          if (new File(ajkz.a(str1, null, 3, 0, 0)).exists()) {
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
        i = badq.a(null);
        if (this.jdField_a_of_type_JavaUtilArrayList == null)
        {
          this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject9);
          label1580:
          if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || ((1 != i) && (!paramBoolean1)) || (!this.jdField_a_of_type_Ajkz.b())) {
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
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_Ajkz == null)) {
      return;
    }
    if ((paramFile != null) && (paramFile.exists())) {}
    File localFile;
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(bace.a(paramFile));
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
            this.jdField_a_of_type_Bank.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
            this.jdField_a_of_type_Bank.e = 2;
          }
        }
        if ("iRedPacket_v3.font.zip".equals(paramString))
        {
          this.jdField_a_of_type_Bann.jdField_d_of_type_JavaLangString = localFile.optString("id", "");
          this.jdField_a_of_type_Bann.c = localFile.optString("name", "");
          this.jdField_a_of_type_Bann.jdField_d_of_type_Int = localFile.optInt("version");
          this.jdField_a_of_type_Bann.e = 2;
          this.jdField_a_of_type_Ajkz.a(this.jdField_a_of_type_Bann.jdField_d_of_type_JavaLangString);
        }
        if ("iRedPacket_v3.specialChar.zip".equals(paramString))
        {
          this.jdField_b_of_type_Bank.jdField_d_of_type_JavaLangString = localFile.optString("id", "0");
          this.jdField_b_of_type_Bank.jdField_d_of_type_Int = localFile.optInt("version");
          this.jdField_b_of_type_Bank.e = 2;
          this.jdField_b_of_type_Bank.jdField_b_of_type_JavaLangString = localFile.optString("char", "");
          this.jdField_b_of_type_Bank.jdField_a_of_type_JavaLangString = ("" + this.jdField_b_of_type_Bank.jdField_b_of_type_JavaLangString);
          paramString = this.jdField_b_of_type_Bank.jdField_d_of_type_JavaLangString + this.jdField_b_of_type_Bank.jdField_d_of_type_Int;
          if ((!TextUtils.isEmpty(this.jdField_b_of_type_Bank.jdField_b_of_type_JavaLangString)) && (!paramString.equals(this.jdField_a_of_type_Ajkz.b().getString("special_unzip_version_key", ""))))
          {
            localFile = new File(ajkz.a(null, null, 26, 0, 0));
            localObject2 = ajkz.a(2) + "images";
            if (!a(localFile.getAbsolutePath(), (String)localObject2)) {
              break label681;
            }
            this.jdField_a_of_type_Ajkz.b().edit().putString("special_unzip_version_key", paramString).commit();
          }
        }
        if ((this.jdField_a_of_type_Bank.e != 2) || (this.jdField_a_of_type_Bann.e != 2) || (!this.jdField_a_of_type_Ajkz.b())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse goto preCreatePersonalFontImg");
        }
        this.jdField_a_of_type_Ajkz.a(this.jdField_a_of_type_Bank);
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "initJsonBySCID parse Json config JSONException: ", paramString);
        bapf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_redpacket_json_err", "decode_json_err", paramString.getMessage(), null, 0.0F);
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
    this.jdField_a_of_type_Ajkz = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    a(false, true);
    String str = ajkz.a(null, null, 8, 0, 0);
    if (VasQuickUpdateManager.getFileFromLocal(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 16L, "iRedPacket_v3.font.zip", str, true, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker) != null) {
      a(false, true, "iRedPacket_v3.font.zip", new File(ajkz.a(null, null, 21, 0, 0)));
    }
    str = ajkz.a(null, null, 25, 0, 0);
    a(false, true, "iRedPacket_v3.specialChar.zip", VasQuickUpdateManager.getFileFromLocal(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 16L, "iRedPacket_v3.specialChar.zip", str, true, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker));
    str = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + "iRedPacket_v3.char300.json";
    a(false, true, "iRedPacket_v3.char300.json", VasQuickUpdateManager.getFileFromLocal(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 16L, "iRedPacket_v3.char300.json", str, true, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker));
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_Ajkz == null)) {}
    File localFile1;
    File localFile2;
    File localFile3;
    int j;
    int i;
    for (;;)
    {
      return;
      if (!this.jdField_a_of_type_Ajkz.c.get()) {
        try
        {
          if (!this.jdField_a_of_type_Ajkz.b().getBoolean("res_version_has_updated", false))
          {
            Object localObject1 = new File(ajkz.a(3) + "10029_0");
            localObject3 = new File(ajkz.a(null, null, 8, 0, 0));
            if ((((File)localObject1).exists()) && (!((File)localObject3).exists())) {
              ((File)localObject1).renameTo((File)localObject3);
            }
            localFile1 = new File(ajed.aU + "RedPacket/templateAIO");
            localFile2 = new File(ajed.aU + "RedPacket/templateTENPAY");
            localFile3 = new File(ajed.aU + "RedPacket/templateSEND");
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
              this.jdField_a_of_type_Ajkz.b().edit().putBoolean("res_version_has_updated", true).commit();
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
    Object localObject3 = balu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, balu.g, false);
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IndividualRedPacketResDownloader", 2, "updateResVersion null == resJson waiting download");
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
      localObject4 = balu.g.jdField_a_of_type_JavaLangString;
      localObject2 = new File(((Context)localObject2).getFilesDir(), (String)localObject4);
      localObject2 = new batm(balu.g.jdField_b_of_type_JavaLangString, (File)localObject2);
      ((batm)localObject2).n = true;
      if (bato.a((batm)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) {
        break label507;
      }
    }
    for (localObject2 = balu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, balu.g, false); localObject2 == null; localObject2 = localObject3)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion fail Err, return");
      return;
      label507:
      QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion download Err : " + balu.g.jdField_b_of_type_JavaLangString);
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
        if ((localObject5 == null) || (((bano)localObject5).jdField_a_of_type_Banl == null) || (((bano)localObject5).jdField_b_of_type_Banl == null) || (((bano)localObject5).jdField_c_of_type_Banl == null) || (new File(ajkz.a(((bano)localObject5).jdField_a_of_type_JavaLangString, null, 0, 0, 0)).exists())) {
          break label1095;
        }
        localObject6 = ((bano)localObject5).jdField_a_of_type_JavaLangString + "_" + ((bano)localObject5).jdField_d_of_type_Int;
        localObject3 = localFile1.getAbsolutePath() + File.separator + (String)localObject6;
        banl localbanl = ((bano)localObject5).jdField_a_of_type_Banl;
        localObject2 = localObject3;
        if (localbanl.f == 19) {
          localObject2 = (String)localObject3 + "_zip";
        }
        if (!new File((String)localObject2).exists()) {
          break label1095;
        }
        localObject3 = new String[3];
        localObject3[0] = localObject2;
        localObject3[1] = (localFile2.getAbsolutePath() + File.separator + (String)localObject6);
        localObject3[2] = (localFile3.getAbsolutePath() + File.separator + (String)localObject6);
        localObject2 = ((bano)localObject5).jdField_b_of_type_Banl;
        localObject5 = ((bano)localObject5).jdField_c_of_type_Banl;
        localObject6 = new String[3];
        localObject6[0] = ajkz.a(localbanl.jdField_d_of_type_JavaLangString, localbanl.c, localbanl.f, localbanl.jdField_d_of_type_Int, 0);
        localObject6[1] = ajkz.a(((banl)localObject2).jdField_d_of_type_JavaLangString, ((banl)localObject2).c, ((banl)localObject2).f, ((banl)localObject2).jdField_d_of_type_Int, 0);
        localObject6[2] = ajkz.a(((banl)localObject5).jdField_d_of_type_JavaLangString, ((banl)localObject5).c, ((banl)localObject5).f, ((banl)localObject5).jdField_d_of_type_Int, 0);
        j = 0;
      }
    }
    for (;;)
    {
      if (j < localObject3.length)
      {
        if (bace.d(localObject3[j], localObject6[j])) {
          break label1102;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion copyFile aio file Err:" + localObject3[j] + ", newPath:" + localObject6[j]);
          break label1095;
          localObject2 = this.jdField_a_of_type_Ajkz.b().edit();
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
      label1095:
      i += 1;
      break;
      label1102:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bani
 * JD-Core Version:    0.7.0.1
 */