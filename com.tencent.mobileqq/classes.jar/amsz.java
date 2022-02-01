import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
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

public class amsz
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
      Object localObject1 = FileUtils.readFileContent(new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), bgcw.f.a));
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
  
  private static void a(boolean paramBoolean, Context paramContext, IPicDownloadListener paramIPicDownloadListener, bgoj parambgoj, arba paramarba, arce paramarce, List<CustomEmotionData> paramList1, List<CustomEmotionData> paramList2, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, CustomEmotionData paramCustomEmotionData)
  {
    if (!TextUtils.isEmpty(paramCustomEmotionData.url)) {
      if (parambgoj.a(paramCustomEmotionData.url) != null) {
        paramAtomicInteger1.decrementAndGet();
      }
    }
    for (;;)
    {
      return;
      Object localObject = new amtb(paramarce, paramCustomEmotionData).a();
      paramarce = ((amtb)localObject).a();
      boolean bool = ((amtb)localObject).a();
      File localFile = new File(paramarce);
      if (localFile.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("FunyPicHelper", 2, "download path is exsit->" + paramarce);
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
          paramarba.b(paramCustomEmotionData);
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
        bgoe localbgoe = new bgoe(paramCustomEmotionData.url, localFile);
        localbgoe.p = false;
        localbgoe.f = "emotion_pic";
        localbgoe.b = 1;
        paramarce = "";
        if (paramCustomEmotionData.url.contains("qto_"))
        {
          localObject = a(paramCustomEmotionData.url);
          paramarce = (arce)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramarce = (arce)localObject;
            if (((String)localObject).length() > "qto_".length() + 8)
            {
              paramarce = ((String)localObject).substring(0, "qto_".length() + 8);
              a.add(paramarce);
            }
          }
        }
        parambgoj.a(localbgoe, new amta(paramarce, localFile, paramCustomEmotionData, bool, paramBoolean, paramarba, paramIPicDownloadListener, paramList1, paramList2, paramContext, paramAtomicInteger2, paramAtomicInteger1), null);
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
        bgoj localbgoj = ((bgog)paramAppInterface.getManager(47)).a(1);
        if (localbgoj != null)
        {
          arba localarba = (arba)paramAppInterface.getManager(149);
          paramAppInterface = (arce)paramAppInterface.getManager(141);
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          AtomicInteger localAtomicInteger1 = new AtomicInteger(paramList.size());
          AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
          paramList = paramList.iterator();
          while (paramList.hasNext()) {
            a(paramBoolean, paramContext, paramIPicDownloadListener, localbgoj, localarba, paramAppInterface, localArrayList1, localArrayList2, localAtomicInteger1, localAtomicInteger2, (CustomEmotionData)paramList.next());
          }
        }
      }
    } while (paramIPicDownloadListener == null);
    paramIPicDownloadListener.onDone(new ArrayList(), paramList);
  }
  
  private static void b(bgoe parambgoe, String paramString, File paramFile, CustomEmotionData paramCustomEmotionData, boolean paramBoolean1, boolean paramBoolean2, arba paramarba, IPicDownloadListener paramIPicDownloadListener, List<CustomEmotionData> paramList1, List<CustomEmotionData> paramList2, Context paramContext, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2)
  {
    a.remove(paramString);
    if ((3 == parambgoe.a()) && (paramFile.exists()))
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
        paramarba.b(paramCustomEmotionData);
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
      bggr.a("emotionType", "emotionActionFav", "3", "", "", NetworkUtil.getNetworkType(paramContext) + "", parambgoe.a + "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsz
 * JD-Core Version:    0.7.0.1
 */