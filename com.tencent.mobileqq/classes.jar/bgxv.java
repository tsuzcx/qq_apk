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

public class bgxv
{
  long jdField_a_of_type_Long;
  anom jdField_a_of_type_Anom;
  public bgxx a;
  public bgya a;
  public QQLruCache<String, bgyb> a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new bgxw(this);
  public String a;
  ArrayList<bgxz> jdField_a_of_type_JavaUtilArrayList;
  public Map<String, List<String>> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  public bgxx b;
  public String b;
  public AtomicBoolean b;
  public boolean b;
  public String c;
  
  public bgxv(QQAppInterface paramQQAppInterface, anom paramanom)
  {
    this.jdField_a_of_type_Bgxx = new bgxx();
    this.jdField_b_of_type_Bgxx = new bgxx();
    this.jdField_a_of_type_Bgya = new bgya();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_Bgxx.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Anom = paramanom;
    this.jdField_b_of_type_Boolean = paramanom.b().getBoolean("mall_entrance_switch", false);
    this.jdField_a_of_type_Boolean = paramanom.b().getBoolean("redpacket_is_show_switch", false);
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(1009, 100, 300);
    this.jdField_a_of_type_Bgya.f = 8;
    this.jdField_b_of_type_Bgxx.f = 26;
    ((VasQuickUpdateManager)paramQQAppInterface.getManager(184)).addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, JSONArray paramJSONArray, ArrayList<bgxz> paramArrayList)
  {
    int j = 0;
    int i = paramInt2;
    paramInt2 = j;
    boolean bool1;
    String str;
    label69:
    bgyb localbgyb;
    if (paramInt2 < paramJSONArray.length())
    {
      if ((paramInt2 < paramInt1) && (i < paramInt3)) {}
      for (bool1 = true;; bool1 = false)
      {
        str = paramJSONArray.optString(paramInt2);
        if (!TextUtils.isEmpty(str)) {
          break label69;
        }
        j = i;
        paramInt2 += 1;
        i = j;
        break;
      }
      localbgyb = (bgyb)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(str);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        if (!this.jdField_a_of_type_JavaUtilMap.containsKey(str)) {
          break label190;
        }
        bool2 = a(false, str, localbgyb);
        boolean bool3 = bool1;
        if (bool1)
        {
          bool3 = bool1;
          if (!bool2) {
            bool3 = a(str);
          }
        }
        j = i;
        if (!bool3) {
          break;
        }
        j = i;
        if (bool2) {
          break;
        }
        j = a(i, paramArrayList, str);
      }
      return i;
      label190:
      boolean bool2 = false;
    }
  }
  
  private int a(int paramInt, ArrayList<bgxz> paramArrayList, String paramString)
  {
    bgxz localbgxz = new bgxz();
    localbgxz.jdField_a_of_type_Long = 16L;
    localbgxz.jdField_a_of_type_JavaLangString = ("luckyMoney.item." + paramString);
    localbgxz.jdField_b_of_type_JavaLangString = anom.a(paramString, null, 0, 0, 0);
    paramArrayList.add(localbgxz);
    return paramInt + 1;
  }
  
  private JSONObject a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IndividualRedPacketResDownloader", 2, "updateResVersion null == resJson waiting download");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    String str = bgwh.g.jdField_a_of_type_JavaLangString;
    localObject = new File(((Context)localObject).getFilesDir(), str);
    localObject = new bhhf(bgwh.g.jdField_b_of_type_JavaLangString, (File)localObject);
    ((bhhf)localObject).n = true;
    if (bhhh.a((bhhf)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) {
      return bgwh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bgwh.g, false);
    }
    QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion download Err : " + bgwh.g.jdField_b_of_type_JavaLangString);
    return paramJSONObject;
  }
  
  private void a(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null) {
      b(paramJSONArray);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse urllist == null");
  }
  
  private void a(boolean paramBoolean, ArrayList<bgxz> paramArrayList, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    }
    while ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && ((1 == paramInt) || (paramBoolean)) && (this.jdField_a_of_type_Anom.b()))
    {
      a();
      return;
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  public static boolean a(bgya parambgya)
  {
    if ((parambgya == null) || (parambgya.f == 0)) {}
    for (;;)
    {
      return false;
      parambgya = anom.a(parambgya.jdField_d_of_type_JavaLangString, parambgya.c, parambgya.f, parambgya.jdField_d_of_type_Int, 0);
      if (TextUtils.isEmpty(parambgya)) {}
      for (parambgya = null; (parambgya != null) && (parambgya.exists()) && (parambgya.isFile()); parambgya = new File(parambgya)) {
        return true;
      }
    }
  }
  
  private boolean a(File paramFile1, File paramFile2, File paramFile3, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("data");
    if (paramJSONObject == null)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion data fail Err, return");
      return true;
    }
    JSONArray localJSONArray = paramJSONObject.optJSONArray("templateList");
    if (localJSONArray == null)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion templateList fail Err, return");
      return true;
    }
    int i = 0;
    if (i < localJSONArray.length())
    {
      Object localObject2 = a(localJSONArray.optJSONObject(i), false);
      if ((localObject2 == null) || (((bgyb)localObject2).jdField_a_of_type_Bgxy == null) || (((bgyb)localObject2).jdField_b_of_type_Bgxy == null) || (((bgyb)localObject2).jdField_c_of_type_Bgxy == null)) {}
      label532:
      for (;;)
      {
        i += 1;
        break;
        if (!new File(anom.a(((bgyb)localObject2).jdField_a_of_type_JavaLangString, null, 0, 0, 0)).exists())
        {
          Object localObject3 = ((bgyb)localObject2).jdField_a_of_type_JavaLangString + "_" + ((bgyb)localObject2).jdField_d_of_type_Int;
          Object localObject1 = paramFile1.getAbsolutePath() + File.separator + (String)localObject3;
          bgxy localbgxy = ((bgyb)localObject2).jdField_a_of_type_Bgxy;
          paramJSONObject = (JSONObject)localObject1;
          if (localbgxy.f == 19) {
            paramJSONObject = (String)localObject1 + "_zip";
          }
          if (new File(paramJSONObject).exists())
          {
            localObject1 = new String[3];
            localObject1[0] = paramJSONObject;
            localObject1[1] = (paramFile2.getAbsolutePath() + File.separator + (String)localObject3);
            localObject1[2] = (paramFile3.getAbsolutePath() + File.separator + (String)localObject3);
            paramJSONObject = ((bgyb)localObject2).jdField_b_of_type_Bgxy;
            localObject2 = ((bgyb)localObject2).jdField_c_of_type_Bgxy;
            localObject3 = new String[3];
            localObject3[0] = anom.a(localbgxy.jdField_d_of_type_JavaLangString, localbgxy.c, localbgxy.f, localbgxy.jdField_d_of_type_Int, 0);
            localObject3[1] = anom.a(paramJSONObject.jdField_d_of_type_JavaLangString, paramJSONObject.c, paramJSONObject.f, paramJSONObject.jdField_d_of_type_Int, 0);
            localObject3[2] = anom.a(((bgxy)localObject2).jdField_d_of_type_JavaLangString, ((bgxy)localObject2).c, ((bgxy)localObject2).f, ((bgxy)localObject2).jdField_d_of_type_Int, 0);
            int j = 0;
            for (;;)
            {
              if (j >= localObject1.length) {
                break label532;
              }
              if (!bgmg.d(localObject1[j], localObject3[j]))
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion copyFile aio file Err:" + localObject1[j] + ", newPath:" + localObject3[j]);
                break;
              }
              j += 1;
            }
          }
        }
      }
    }
    return false;
  }
  
  private boolean a(File paramFile1, File paramFile2, File paramFile3, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramFile1.exists())
    {
      bool = paramBoolean;
      if (paramFile1.isDirectory())
      {
        bool = paramBoolean;
        if (paramFile2.exists())
        {
          bool = paramBoolean;
          if (paramFile2.isDirectory())
          {
            bool = paramBoolean;
            if (paramFile3.exists())
            {
              bool = paramBoolean;
              if (paramFile3.isDirectory())
              {
                paramFile1 = paramFile1.list();
                paramFile2 = paramFile2.list();
                paramFile3 = paramFile3.list();
                bool = paramBoolean;
                if (paramFile1.length > 0)
                {
                  bool = paramBoolean;
                  if (paramFile2.length > 0)
                  {
                    bool = paramBoolean;
                    if (paramFile3.length > 0) {
                      bool = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool;
  }
  
  private boolean a(String paramString)
  {
    if (new File(anom.a(paramString, null, 0, 0, 0)).exists()) {}
    while (new File(anom.a(paramString, null, 3, 0, 0)).exists()) {
      return false;
    }
    return true;
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
        bgmg.a(paramString1, paramString2, false);
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
              bool1 = bhhh.a(localFile1, paramString2, false);
              bool2 = bool1;
              j = i;
              if (i == 0)
              {
                bool2 = bool1;
                j = i;
                if (!bool1)
                {
                  bgmg.d(paramString1);
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
  
  private boolean a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    boolean bool2 = true;
    Object localObject = paramJSONObject.optString("time");
    SharedPreferences.Editor localEditor;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String)localObject).getTime() - NetConnInfoCenter.getServerTimeMillis() < 172800000L) {
        paramBoolean = true;
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_Anom.b();
      localEditor = ((SharedPreferences)localObject).edit();
      if (paramJSONObject.has("androidShowSwitch"))
      {
        if (paramJSONObject.getInt("androidShowSwitch") != 1) {
          break label203;
        }
        bool1 = true;
        label92:
        this.jdField_a_of_type_Boolean = bool1;
      }
      if (paramJSONObject.has("androidEntrySwitch")) {
        if (paramJSONObject.getInt("androidEntrySwitch") != 1) {
          break label208;
        }
      }
    }
    label203:
    label208:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      if ((this.jdField_a_of_type_Boolean != ((SharedPreferences)localObject).getBoolean("redpacket_is_show_switch", false)) || (this.jdField_b_of_type_Boolean != ((SharedPreferences)localObject).getBoolean("mall_entrance_switch", false)))
      {
        localEditor.putBoolean("redpacket_is_show_switch", this.jdField_a_of_type_Boolean);
        localEditor.putBoolean("mall_entrance_switch", this.jdField_b_of_type_Boolean);
        localEditor.commit();
      }
      return paramBoolean;
      paramBoolean = false;
      break;
      bool1 = false;
      break label92;
    }
  }
  
  private boolean a(boolean paramBoolean, String paramString, bgyb parambgyb)
  {
    bgyb localbgyb;
    if ((parambgyb != null) && (!a(parambgyb.jdField_a_of_type_Bgxy)) && (!a(parambgyb.jdField_b_of_type_Bgxy)))
    {
      localbgyb = parambgyb;
      if (!a(parambgyb.jdField_c_of_type_Bgxy)) {}
    }
    else
    {
      localbgyb = a(paramString);
    }
    if ((localbgyb != null) && (a(localbgyb.jdField_a_of_type_Bgxy)) && (a(localbgyb.jdField_b_of_type_Bgxy)) && (a(localbgyb.jdField_c_of_type_Bgxy)))
    {
      parambgyb = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      int i = 0;
      if (i < parambgyb.size())
      {
        String str = (String)parambgyb.get(i);
        if (TextUtils.isEmpty(str)) {}
        for (;;)
        {
          i += 1;
          break;
          this.jdField_a_of_type_Anom.a(str, localbgyb.jdField_a_of_type_Bgxy.f);
          this.jdField_a_of_type_Anom.a(str + "_tp", localbgyb.jdField_b_of_type_Bgxy.f);
          this.jdField_a_of_type_Anom.a(str + "_send", localbgyb.jdField_c_of_type_Bgxy.f);
        }
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      return paramBoolean;
    }
    a(16L, paramString, null);
    return true;
  }
  
  private void b(JSONArray paramJSONArray)
  {
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      String str = ((JSONObject)localObject).optString("name");
      localObject = ((JSONObject)localObject).optString("url", null);
      if ("aioTail".equals(str)) {
        this.jdField_b_of_type_JavaLangString = ((String)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if ("personalityMall".equals(str)) {
          this.jdField_a_of_type_JavaLangString = ((String)localObject);
        } else if ("tencentPay".equals(str)) {
          this.c = ((String)localObject);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse mAioTailURL:" + this.jdField_b_of_type_JavaLangString + ", mTencentPayURL:" + this.c + ", mPersonalityMallURL:" + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public bgyb a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = new File(anom.a(paramString, null, 0, 0, 0));
    } while (!paramString.exists());
    try
    {
      bgyb localbgyb = a(new JSONObject(bgmg.a(paramString)), true);
      if (localbgyb != null) {
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(localbgyb.jdField_a_of_type_JavaLangString, localbgyb);
      }
      return localbgyb;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "loadPacketJson ,filePath:" + paramString.getAbsolutePath(), localThrowable);
    }
    return null;
  }
  
  public bgyb a(String paramString, boolean paramBoolean)
  {
    bgyb localbgyb = (bgyb)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
    if (!paramBoolean) {}
    while ((localbgyb != null) && (localbgyb.jdField_a_of_type_Bgxy != null) && (localbgyb.jdField_b_of_type_Bgxy != null) && (localbgyb.jdField_c_of_type_Bgxy != null)) {
      return localbgyb;
    }
    return a(paramString);
  }
  
  bgyb a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject == null) {
      return null;
    }
    label1043:
    for (;;)
    {
      Object localObject1;
      bgyb localbgyb;
      Object localObject2;
      try
      {
        localObject1 = paramJSONObject.optString("id");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localbgyb = new bgyb();
        localbgyb.jdField_a_of_type_Bgxy = new bgxy();
        localbgyb.jdField_a_of_type_Bgxy.f = 2;
        localbgyb.jdField_b_of_type_Bgxy = new bgxy();
        localbgyb.jdField_b_of_type_Bgxy.f = 3;
        localbgyb.jdField_c_of_type_Bgxy = new bgxy();
        localbgyb.jdField_c_of_type_Bgxy.f = 14;
        localbgyb.jdField_a_of_type_JavaLangString = ((String)localObject1);
        localbgyb.jdField_a_of_type_Bgxy.jdField_d_of_type_JavaLangString = ((String)localObject1);
        localbgyb.jdField_b_of_type_Bgxy.jdField_d_of_type_JavaLangString = ((String)localObject1);
        localbgyb.jdField_c_of_type_Bgxy.jdField_d_of_type_JavaLangString = ((String)localObject1);
        localbgyb.jdField_a_of_type_Bgxy.c = paramJSONObject.optString("name");
        localbgyb.jdField_b_of_type_Bgxy.c = localbgyb.jdField_a_of_type_Bgxy.c;
        localbgyb.jdField_c_of_type_Bgxy.c = localbgyb.jdField_a_of_type_Bgxy.c;
        localbgyb.jdField_a_of_type_Int = paramJSONObject.optInt("customWord", bgyb.jdField_c_of_type_Int);
        localbgyb.e = paramJSONObject.optInt("fontTypeId", 1);
        localbgyb.jdField_d_of_type_Int = paramJSONObject.optInt("version", 0);
        localbgyb.jdField_a_of_type_Bgxy.jdField_d_of_type_Int = localbgyb.jdField_d_of_type_Int;
        localbgyb.jdField_b_of_type_Bgxy.jdField_d_of_type_Int = localbgyb.jdField_d_of_type_Int;
        localbgyb.jdField_c_of_type_Bgxy.jdField_d_of_type_Int = localbgyb.jdField_d_of_type_Int;
        if (localbgyb.jdField_a_of_type_Int != bgyb.jdField_b_of_type_Int) {
          break label876;
        }
        localObject1 = paramJSONObject.optJSONArray("aioChar");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() >= 4))
        {
          localbgyb.jdField_a_of_type_Bgxy.jdField_a_of_type_AndroidGraphicsRect = new Rect(((JSONArray)localObject1).optInt(0), ((JSONArray)localObject1).optInt(1), ((JSONArray)localObject1).optInt(0) + ((JSONArray)localObject1).optInt(2), ((JSONArray)localObject1).optInt(1) + ((JSONArray)localObject1).optInt(3));
          localbgyb.jdField_a_of_type_Bgxy.jdField_a_of_type_Int = ((JSONArray)localObject1).optInt(2);
          localObject1 = paramJSONObject.optJSONArray("packetChar");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() >= 4))
          {
            localbgyb.jdField_b_of_type_Bgxy.jdField_a_of_type_AndroidGraphicsRect = new Rect(((JSONArray)localObject1).optInt(0), ((JSONArray)localObject1).optInt(1), ((JSONArray)localObject1).optInt(0) + ((JSONArray)localObject1).optInt(2), ((JSONArray)localObject1).optInt(1) + ((JSONArray)localObject1).optInt(3));
            localbgyb.jdField_b_of_type_Bgxy.jdField_a_of_type_Int = ((JSONArray)localObject1).optInt(2);
            localObject1 = paramJSONObject.optJSONArray("sendChar");
            if ((localObject1 == null) || (((JSONArray)localObject1).length() < 4)) {
              break label810;
            }
            localbgyb.jdField_c_of_type_Bgxy.jdField_a_of_type_AndroidGraphicsRect = new Rect(((JSONArray)localObject1).optInt(0), ((JSONArray)localObject1).optInt(1), ((JSONArray)localObject1).optInt(0) + ((JSONArray)localObject1).optInt(2), ((JSONArray)localObject1).optInt(1) + ((JSONArray)localObject1).optInt(3));
            localbgyb.jdField_c_of_type_Bgxy.jdField_a_of_type_Int = ((JSONArray)localObject1).optInt(2);
            localObject2 = localbgyb.jdField_a_of_type_Bgxy;
            if (localbgyb.jdField_a_of_type_Bgxy.jdField_a_of_type_Afxn != null) {
              break label1043;
            }
            localObject1 = paramJSONObject.optString("aioImgUrl", "");
            ((bgxy)localObject2).e = ((String)localObject1);
            localbgyb.jdField_b_of_type_Bgxy.e = paramJSONObject.optString("redEnvelopeImgUrl", "");
            localbgyb.jdField_c_of_type_Bgxy.e = paramJSONObject.optString("sendImgUrl", "");
            return localbgyb;
          }
        }
        else
        {
          QLog.e("IndividualRedPacketResDownloader", 2, "getTemplateByJson aioChar error,name:" + localbgyb.jdField_a_of_type_Bgxy.c + ", id:" + localbgyb.jdField_a_of_type_JavaLangString + ", isV710:" + paramBoolean);
          localbgyb.jdField_a_of_type_Bgxy.jdField_a_of_type_AndroidGraphicsRect = new Rect(1, 1, 1, 1);
          localbgyb.jdField_a_of_type_Bgxy.jdField_a_of_type_Int = 1;
          localbgyb.jdField_a_of_type_Int = bgyb.jdField_c_of_type_Int;
          continue;
        }
        QLog.e("IndividualRedPacketResDownloader", 2, "getTemplateByJson packetChar error,name:" + localbgyb.jdField_a_of_type_Bgxy.c + ", id:" + localbgyb.jdField_a_of_type_JavaLangString + ", isV710:" + paramBoolean);
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "getTemplateByJson Err:" + paramJSONObject.toString() + ", isV710:" + paramBoolean);
        return null;
      }
      localbgyb.jdField_b_of_type_Bgxy.jdField_a_of_type_AndroidGraphicsRect = new Rect(1, 1, 1, 1);
      localbgyb.jdField_b_of_type_Bgxy.jdField_a_of_type_Int = 1;
      localbgyb.jdField_a_of_type_Int = bgyb.jdField_c_of_type_Int;
      continue;
      label810:
      if (QLog.isColorLevel())
      {
        QLog.d("IndividualRedPacketResDownloader", 2, "getTemplateByJson sendChar error,name:" + localbgyb.jdField_a_of_type_Bgxy.c + ", id:" + localbgyb.jdField_a_of_type_JavaLangString + ", isV710:" + paramBoolean);
        continue;
        label876:
        localObject1 = paramJSONObject.optString("aioPngZip", null);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).indexOf("http") >= 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("IndividualRedPacketResDownloader", 2, "getTemplateByJson aioPngZip ,name=" + localbgyb.jdField_a_of_type_Bgxy.c + ", id:" + localbgyb.jdField_a_of_type_JavaLangString + ", url:" + (String)localObject1 + ", isV710:" + paramBoolean);
          }
          localObject2 = new afxn();
          ((afxn)localObject2).jdField_b_of_type_Int = paramJSONObject.optInt("interval", 100);
          ((afxn)localObject2).jdField_a_of_type_Int = paramJSONObject.optInt("flameCount", 0);
          localbgyb.jdField_a_of_type_Bgxy.jdField_a_of_type_Afxn = ((afxn)localObject2);
          localbgyb.jdField_a_of_type_Bgxy.jdField_a_of_type_JavaLangString = ((String)localObject1);
          localbgyb.jdField_a_of_type_Bgxy.f = 19;
          continue;
          localObject1 = localbgyb.jdField_a_of_type_Bgxy.jdField_a_of_type_JavaLangString;
        }
      }
    }
  }
  
  public JSONObject a(File paramFile, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramFile != null)
    {
      localJSONObject = paramJSONObject;
      if (!paramFile.exists()) {}
    }
    try
    {
      localJSONObject = new JSONObject(bgmg.a(paramFile));
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "initJsonBySCID ,filePath:" + paramFile.getAbsolutePath(), localThrowable);
    }
    return paramJSONObject;
  }
  
  void a()
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_Anom != null) && (this.jdField_a_of_type_JavaUtilArrayList != null))
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
          bgxz localbgxz = (bgxz)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
          if (localbgxz != null) {
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
          paramString2 = anom.a(null, null, 11, 0, 0);
          VasQuickUpdateManager.getFileFromLocal(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, paramString1, paramString2, true, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
          continue;
        }
        paramString2 = new File(anom.a(paramString1, null, 24, 0, 0));
      }
      finally {}
      boolean bool = paramString2.exists();
      if (QLog.isColorLevel()) {
        QLog.d("IndividualRedPacketResDownloader", 1, "downloadResIfNotExsit, id: " + paramString1 + " exists: " + bool);
      }
      if (bool) {
        VasQuickUpdateEngine.safeDeleteFile(paramString2);
      }
      paramString2 = anom.a(paramString1, null, 0, 0, 0);
      paramString1 = "luckyMoney.item." + paramString1;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    int k = 0;
    Object localObject4;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          localObject1 = this.jdField_a_of_type_Anom;
          if (localObject1 != null) {}
        }
        else
        {
          return;
        }
        Object localObject1 = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + "iRedPacket_v3.json";
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!paramBoolean1)
        {
          localObject1 = a(VasQuickUpdateManager.getFileFromLocal((AppRuntime)localObject4, 16L, "iRedPacket_v3.json", (String)localObject1, bool, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker), null);
          if (localObject1 != null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.e("IndividualRedPacketResDownloader", 2, "initAllConfigJson null == resJson,isAfterDownload:" + paramBoolean1 + ", isInit" + paramBoolean2);
          }
        }
        else
        {
          bool = false;
        }
      }
      finally {}
    }
    for (;;)
    {
      JSONArray localJSONArray;
      try
      {
        long l = localObject2.optLong("timestamp", 1L);
        if (QLog.isColorLevel()) {
          QLog.d("IndividualRedPacketResDownloader", 2, "initAllConfigJson timestamp=" + l + ", mJsonTimestamp:" + this.jdField_a_of_type_Long);
        }
        if (l <= this.jdField_a_of_type_Long) {
          break;
        }
        this.jdField_a_of_type_Long = l;
        localObject4 = localObject2.optJSONObject("data");
        if (localObject4 == null) {
          QLog.e("IndividualRedPacketResDownloader", 2, "initAllConfigJson, null == data, timestamp=" + l + ", mJsonTimestamp:" + this.jdField_a_of_type_Long);
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse parse Json config JSONException: ", localJSONException);
        bgzu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_redpacket_json_err", "decode_json_err", localJSONException.getMessage(), null, 0.0F);
        break;
        Object localObject3 = ((JSONObject)localObject4).optJSONArray("activityInfo");
        if ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0)) {
          break label656;
        }
        localObject3 = ((JSONArray)localObject3).optJSONObject(0);
        if (localObject3 == null) {
          break label662;
        }
        paramBoolean1 = a((JSONObject)localObject3, false);
        localObject3 = ((JSONObject)localObject4).optJSONArray("isPreload");
        m = 50;
        int n = 5;
        int j = m;
        int i = n;
        if (localObject3 != null)
        {
          j = m;
          i = n;
          if (((JSONArray)localObject3).length() > 0)
          {
            localObject3 = ((JSONArray)localObject3).optJSONObject(0);
            i = ((JSONObject)localObject3).optInt("isPreload", 5);
            j = ((JSONObject)localObject3).optInt("preloadTotal", 50);
          }
        }
        localJSONArray = ((JSONObject)localObject4).optJSONArray("templateIdList");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("checkAndDownloadBeforeUse ,emergencyDownload:").append(paramBoolean1).append(", templateIdList:");
          if (localJSONArray != null) {
            break label676;
          }
          localObject3 = "null";
          QLog.d("IndividualRedPacketResDownloader", 2, localObject3);
        }
        localObject3 = new ArrayList();
        if (localJSONArray != null) {
          k = a(j, 0, i, localJSONArray, (ArrayList)localObject3);
        }
        if (QLog.isColorLevel()) {
          QLog.d("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse finish! size = " + this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.size() + ", preloadSize=" + k + ", totalCanPreload=" + i);
        }
        a(((JSONObject)localObject4).optJSONArray("vipRedPacketURL"));
        a(paramBoolean1, (ArrayList)localObject3, bgnt.a(null));
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
      catch (Exception localException)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse parse Json config error: ", localException);
      }
      break;
      label656:
      Integer localInteger = null;
      continue;
      label662:
      QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse ,activityInfoObj0 == null");
      paramBoolean1 = false;
      continue;
      label676:
      int m = localJSONArray.length();
      localInteger = Integer.valueOf(m);
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, File paramFile)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_Anom == null)) {
      return;
    }
    if ((paramFile != null) && (paramFile.exists())) {}
    File localFile;
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(bgmg.a(paramFile));
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
            this.jdField_a_of_type_Bgxx.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
            this.jdField_a_of_type_Bgxx.e = 2;
          }
        }
        if ("iRedPacket_v3.font.zip".equals(paramString))
        {
          this.jdField_a_of_type_Bgya.jdField_d_of_type_JavaLangString = localFile.optString("id", "");
          this.jdField_a_of_type_Bgya.c = localFile.optString("name", "");
          this.jdField_a_of_type_Bgya.jdField_d_of_type_Int = localFile.optInt("version");
          this.jdField_a_of_type_Bgya.e = 2;
          this.jdField_a_of_type_Anom.a(this.jdField_a_of_type_Bgya.jdField_d_of_type_JavaLangString);
        }
        if ("iRedPacket_v3.specialChar.zip".equals(paramString))
        {
          this.jdField_b_of_type_Bgxx.jdField_d_of_type_JavaLangString = localFile.optString("id", "0");
          this.jdField_b_of_type_Bgxx.jdField_d_of_type_Int = localFile.optInt("version");
          this.jdField_b_of_type_Bgxx.e = 2;
          this.jdField_b_of_type_Bgxx.jdField_b_of_type_JavaLangString = localFile.optString("char", "");
          this.jdField_b_of_type_Bgxx.jdField_a_of_type_JavaLangString = ("" + this.jdField_b_of_type_Bgxx.jdField_b_of_type_JavaLangString);
          paramString = this.jdField_b_of_type_Bgxx.jdField_d_of_type_JavaLangString + this.jdField_b_of_type_Bgxx.jdField_d_of_type_Int;
          if ((!TextUtils.isEmpty(this.jdField_b_of_type_Bgxx.jdField_b_of_type_JavaLangString)) && (!paramString.equals(this.jdField_a_of_type_Anom.b().getString("special_unzip_version_key", ""))))
          {
            localFile = new File(anom.a(null, null, 26, 0, 0));
            localObject2 = anom.a(2) + "images";
            if (!a(localFile.getAbsolutePath(), (String)localObject2)) {
              break label683;
            }
            this.jdField_a_of_type_Anom.b().edit().putString("special_unzip_version_key", paramString).commit();
          }
        }
        if ((this.jdField_a_of_type_Bgxx.e != 2) || (this.jdField_a_of_type_Bgya.e != 2) || (!this.jdField_a_of_type_Anom.b())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse goto preCreatePersonalFontImg");
        }
        this.jdField_a_of_type_Anom.a(this.jdField_a_of_type_Bgxx);
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "initJsonBySCID parse Json config JSONException: ", paramString);
        bgzu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_redpacket_json_err", "decode_json_err", paramString.getMessage(), null, 0.0F);
        return;
      }
      label683:
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
    this.jdField_a_of_type_Anom = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    a(false, true);
    String str = anom.a(null, null, 8, 0, 0);
    if (VasQuickUpdateManager.getFileFromLocal(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 16L, "iRedPacket_v3.font.zip", str, true, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker) != null) {
      a(false, true, "iRedPacket_v3.font.zip", new File(anom.a(null, null, 21, 0, 0)));
    }
    str = anom.a(null, null, 25, 0, 0);
    a(false, true, "iRedPacket_v3.specialChar.zip", VasQuickUpdateManager.getFileFromLocal(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 16L, "iRedPacket_v3.specialChar.zip", str, true, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker));
    str = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + "iRedPacket_v3.char300.json";
    a(false, true, "iRedPacket_v3.char300.json", VasQuickUpdateManager.getFileFromLocal(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 16L, "iRedPacket_v3.char300.json", str, true, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker));
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_Anom == null)) {}
    File localFile2;
    File localFile3;
    File localFile4;
    do
    {
      for (;;)
      {
        return;
        if (!this.jdField_a_of_type_Anom.c.get()) {
          try
          {
            if (!this.jdField_a_of_type_Anom.b().getBoolean("res_version_has_updated", false))
            {
              File localFile1 = new File(anom.a(3) + "10029_0");
              localObject2 = new File(anom.a(null, null, 8, 0, 0));
              if ((localFile1.exists()) && (!((File)localObject2).exists())) {
                localFile1.renameTo((File)localObject2);
              }
              localFile2 = new File(bhgg.a(anhk.ba + "RedPacket/templateAIO"));
              localFile3 = new File(bhgg.a(anhk.ba + "RedPacket/templateTENPAY"));
              localFile4 = new File(bhgg.a(anhk.ba + "RedPacket/templateSEND"));
              if (!a(localFile2, localFile3, localFile4, false))
              {
                this.jdField_a_of_type_Anom.b().edit().putBoolean("res_version_has_updated", true).commit();
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
      Object localObject2 = bgwh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bgwh.g, false);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = a((JSONObject)localObject2);
      }
      if (localObject1 == null)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion fail Err, return");
        return;
      }
    } while (a(localFile2, localFile3, localFile4, (JSONObject)localObject1));
    Object localObject1 = this.jdField_a_of_type_Anom.b().edit();
    ((SharedPreferences.Editor)localObject1).putBoolean("res_version_has_updated", true);
    ((SharedPreferences.Editor)localObject1).commit();
    VasQuickUpdateEngine.safeDeleteFile(localFile2);
    VasQuickUpdateEngine.safeDeleteFile(localFile3);
    VasQuickUpdateEngine.safeDeleteFile(localFile4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgxv
 * JD-Core Version:    0.7.0.1
 */