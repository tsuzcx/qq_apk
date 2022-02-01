import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class anvn
{
  public static Set<String> a = new HashSet();
  
  public static int a(String paramString)
  {
    String str2 = "0";
    String str1 = str2;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      i = paramString.lastIndexOf("qto_");
      str1 = str2;
      if (i >= 0) {
        str1 = paramString.substring("qto_".length() + i, paramString.length());
      }
    }
    try
    {
      i = Integer.parseInt(str1);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FunyPicHelper", 2, paramString.getMessage());
      }
    }
    return 0;
  }
  
  public static String a(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf("qto_");
      str1 = str2;
      if (i >= 0) {
        str1 = paramString.substring(i, paramString.length());
      }
    }
    return str1;
  }
  
  public static void a(Context paramContext, List<CustomEmotionData> paramList, AppInterface paramAppInterface, IPicDownloadListener paramIPicDownloadListener) {}
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      Object localObject1 = FileUtils.readFileContent(new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), bhln.f.a));
      Object localObject2 = "";
      String str = "";
      j = 1;
      i = j;
      localObject5 = str;
      localObject6 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = str;
        localObject4 = localObject2;
      }
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        i = j;
        localObject5 = str;
        localObject6 = localObject2;
        localObject3 = str;
        localObject4 = localObject2;
        if (((JSONObject)localObject1).has("data"))
        {
          localObject3 = str;
          localObject4 = localObject2;
          localObject1 = ((JSONObject)localObject1).getJSONObject("data");
          i = j;
          localObject5 = str;
          localObject6 = localObject2;
          localObject3 = str;
          localObject4 = localObject2;
          if (((JSONObject)localObject1).has("releaseZipInfo"))
          {
            localObject3 = str;
            localObject4 = localObject2;
            localObject1 = ((JSONObject)localObject1).getJSONArray("releaseZipInfo");
            i = j;
            localObject5 = str;
            localObject6 = localObject2;
            localObject3 = str;
            localObject4 = localObject2;
            if (((JSONArray)localObject1).length() > 0)
            {
              localObject3 = str;
              localObject4 = localObject2;
              JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(0);
              localObject1 = localObject2;
              localObject3 = str;
              localObject4 = localObject2;
              if (localJSONObject.has("zipID"))
              {
                localObject3 = str;
                localObject4 = localObject2;
                localObject1 = localJSONObject.getString("zipID");
              }
              localObject2 = str;
              localObject3 = str;
              localObject4 = localObject1;
              if (localJSONObject.has("img"))
              {
                localObject3 = str;
                localObject4 = localObject1;
                localObject2 = localJSONObject.getString("img");
              }
              i = j;
              localObject5 = localObject2;
              localObject6 = localObject1;
              localObject3 = localObject2;
              localObject4 = localObject1;
              if (localJSONObject.has("type"))
              {
                localObject3 = localObject2;
                localObject4 = localObject1;
                i = localJSONObject.getInt("type");
                localObject6 = localObject1;
                localObject5 = localObject2;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          i = j;
          localObject5 = localObject3;
          localObject6 = localObject4;
          if (QLog.isColorLevel())
          {
            QLog.d("FunyPicHelper", 2, localException.getMessage());
            i = j;
            localObject5 = localObject3;
            localObject6 = localObject4;
          }
        }
      }
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("funny_pic_info", 0);
      if (!TextUtils.isEmpty(localObject6)) {
        paramQQAppInterface.edit().putString("funnypic_count_sp_key", localObject6).commit();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject5)) {
        paramQQAppInterface.edit().putString("funnypic_name_sp_key", (String)localObject5).commit();
      }
      paramQQAppInterface.edit().putInt("funnypic_type_sp_key", i).commit();
    } while (!QLog.isColorLevel());
    QLog.d("FunyPicHelper", 2, "funnypic zipID->" + localObject6 + ";imgName -> " + (String)localObject5 + ";type -> " + i);
  }
  
  private static void a(boolean paramBoolean, Context paramContext, IPicDownloadListener paramIPicDownloadListener, bhyt parambhyt, asfk paramasfk, asgo paramasgo, List<CustomEmotionData> paramList1, List<CustomEmotionData> paramList2, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, CustomEmotionData paramCustomEmotionData)
  {
    if (!TextUtils.isEmpty(paramCustomEmotionData.url)) {
      if (parambhyt.a(paramCustomEmotionData.url) != null) {
        paramAtomicInteger1.decrementAndGet();
      }
    }
    for (;;)
    {
      return;
      Object localObject = new anvp(paramasgo, paramCustomEmotionData).a();
      paramasgo = ((anvp)localObject).a();
      boolean bool = ((anvp)localObject).a();
      File localFile = new File(paramasgo);
      if (localFile.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("FunyPicHelper", 2, "download path is exsit->" + paramasgo);
        }
        paramAtomicInteger1.decrementAndGet();
        paramCustomEmotionData.emoPath = localFile.getAbsolutePath();
        if ("needDownload".equals(paramCustomEmotionData.RomaingType)) {
          paramCustomEmotionData.RomaingType = "isUpdate";
        }
        if (bool) {
          paramCustomEmotionData.eId = "";
        }
        if ((TextUtils.isEmpty(paramCustomEmotionData.md5)) && (!TextUtils.isEmpty(paramCustomEmotionData.emoPath))) {
          paramCustomEmotionData.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramCustomEmotionData.emoPath));
        }
        if (paramBoolean) {
          paramasfk.b(paramCustomEmotionData);
        }
        if (paramIPicDownloadListener != null) {
          paramIPicDownloadListener.onFileDone(paramCustomEmotionData, true);
        }
        paramList1.add(paramCustomEmotionData);
        if (QLog.isColorLevel()) {
          QLog.d("FunyPicHelper", 2, "update funnyPic eId->" + paramCustomEmotionData.eId + " emoPath->" + paramCustomEmotionData.emoPath + " download->sucess");
        }
      }
      while ((paramAtomicInteger1.get() == 0) && (paramIPicDownloadListener != null))
      {
        paramIPicDownloadListener.onDone(paramList1, paramList2);
        return;
        bhyo localbhyo = new bhyo(paramCustomEmotionData.url, localFile);
        localbhyo.p = false;
        localbhyo.f = "emotion_pic";
        localbhyo.b = 1;
        paramasgo = "";
        if (paramCustomEmotionData.url.contains("qto_"))
        {
          localObject = a(paramCustomEmotionData.url);
          paramasgo = (asgo)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramasgo = (asgo)localObject;
            if (((String)localObject).length() > "qto_".length() + 8)
            {
              paramasgo = ((String)localObject).substring(0, "qto_".length() + 8);
              a.add(paramasgo);
            }
          }
        }
        parambhyt.a(localbhyo, new anvo(paramasgo, localFile, paramCustomEmotionData, bool, paramBoolean, paramasfk, paramIPicDownloadListener, paramList1, paramList2, paramContext, paramAtomicInteger2, paramAtomicInteger1), null);
      }
      continue;
      if (paramIPicDownloadListener != null) {
        paramIPicDownloadListener.onFileDone(paramCustomEmotionData, false);
      }
      if (TextUtils.isEmpty(paramCustomEmotionData.RomaingType)) {}
      for (paramContext = "null"; QLog.isColorLevel(); paramContext = paramCustomEmotionData.RomaingType)
      {
        QLog.d("FunyPicHelper", 2, "checkLoadEmotionPic, url is null : " + paramCustomEmotionData.resid + ", romaingType:" + paramContext);
        return;
      }
    }
  }
  
  public static void a(boolean paramBoolean, Context paramContext, List<CustomEmotionData> paramList, AppInterface paramAppInterface, IPicDownloadListener paramIPicDownloadListener)
  {
    if ((paramContext == null) || (paramAppInterface == null) || (paramList == null) || (paramList.isEmpty())) {}
    do
    {
      for (;;)
      {
        return;
        if (!NetworkUtil.isNetworkAvailable(paramContext)) {
          break;
        }
        bhyt localbhyt = ((bhyq)paramAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
        if (localbhyt != null)
        {
          asfk localasfk = (asfk)paramAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
          paramAppInterface = (asgo)paramAppInterface.getManager(QQManagerFactory.MQQ_COMIC_MANAGER);
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          AtomicInteger localAtomicInteger1 = new AtomicInteger(paramList.size());
          AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
          paramList = paramList.iterator();
          while (paramList.hasNext()) {
            a(paramBoolean, paramContext, paramIPicDownloadListener, localbhyt, localasfk, paramAppInterface, localArrayList1, localArrayList2, localAtomicInteger1, localAtomicInteger2, (CustomEmotionData)paramList.next());
          }
        }
      }
    } while (paramIPicDownloadListener == null);
    paramIPicDownloadListener.onDone(new ArrayList(), paramList);
  }
  
  private static void b(bhyo parambhyo, String paramString, File paramFile, CustomEmotionData paramCustomEmotionData, boolean paramBoolean1, boolean paramBoolean2, asfk paramasfk, IPicDownloadListener paramIPicDownloadListener, List<CustomEmotionData> paramList1, List<CustomEmotionData> paramList2, Context paramContext, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2)
  {
    a.remove(paramString);
    if ((3 == parambhyo.a()) && (paramFile.exists()))
    {
      paramCustomEmotionData.emoPath = paramFile.getAbsolutePath();
      if ("needDownload".equals(paramCustomEmotionData.RomaingType)) {
        paramCustomEmotionData.RomaingType = "isUpdate";
      }
      if (paramBoolean1) {
        paramCustomEmotionData.eId = "";
      }
      if ((TextUtils.isEmpty(paramCustomEmotionData.md5)) && (!TextUtils.isEmpty(paramCustomEmotionData.emoPath))) {
        paramCustomEmotionData.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramCustomEmotionData.emoPath));
      }
      if (paramBoolean2) {
        paramasfk.b(paramCustomEmotionData);
      }
      if (paramIPicDownloadListener != null) {
        paramIPicDownloadListener.onFileDone(paramCustomEmotionData, true);
      }
      paramList1.add(paramCustomEmotionData);
      if (QLog.isColorLevel()) {
        QLog.d("FunyPicHelper", 2, "update funnyPic eId->" + paramCustomEmotionData.eId + " emoPath->" + paramCustomEmotionData.emoPath + " download->sucess");
      }
    }
    for (;;)
    {
      paramAtomicInteger1.getAndIncrement();
      if ((paramAtomicInteger1.get() == paramAtomicInteger2.get()) && (paramIPicDownloadListener != null)) {
        paramIPicDownloadListener.onDone(paramList1, paramList2);
      }
      return;
      paramList2.add(paramCustomEmotionData);
      if (paramIPicDownloadListener != null) {
        paramIPicDownloadListener.onFileDone(paramCustomEmotionData, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("FunyPicHelper", 2, "update funnyPic eId->" + paramCustomEmotionData.eId + " emoPath->" + paramCustomEmotionData.emoPath + " download->faile");
      }
      bhpl.a("emotionType", "emotionActionFav", "3", "", "", NetworkUtil.getNetworkType(paramContext) + "", parambhyo.a + "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anvn
 * JD-Core Version:    0.7.0.1
 */