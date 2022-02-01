package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class FunnyPicHelper
{
  public static int a(String paramString)
  {
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      i = paramString.lastIndexOf("qto_");
      if (i >= 0)
      {
        paramString = paramString.substring(i + 4, paramString.length());
        break label36;
      }
    }
    paramString = "0";
    try
    {
      label36:
      i = Integer.parseInt(paramString);
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
  
  public static void a(Context paramContext, List<CustomEmotionData> paramList, AppInterface paramAppInterface, IPicDownloadListener paramIPicDownloadListener) {}
  
  public static void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return;
    }
    Object localObject2 = FileUtils.readFileContent(new File(paramAppInterface.getApplication().getApplicationContext().getFilesDir(), ClubContentJsonTask.f.a));
    int j = 1;
    int i = 1;
    boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
    Object localObject1 = "";
    if (!bool)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        if (!((JSONObject)localObject2).has("data")) {
          break label251;
        }
        localObject2 = ((JSONObject)localObject2).getJSONObject("data");
        if (!((JSONObject)localObject2).has("releaseZipInfo")) {
          break label251;
        }
        localObject2 = ((JSONObject)localObject2).getJSONArray("releaseZipInfo");
        if (((JSONArray)localObject2).length() <= 0) {
          break label251;
        }
        JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(0);
        if (localJSONObject.has("zipID")) {
          localObject2 = localJSONObject.getString("zipID");
        } else {
          localObject2 = "";
        }
        Object localObject3 = localObject1;
        Object localObject4 = localObject1;
        try
        {
          if (localJSONObject.has("img"))
          {
            localObject4 = localObject1;
            localObject3 = localJSONObject.getString("img");
          }
          localObject4 = localObject3;
          if (localJSONObject.has("type"))
          {
            localObject4 = localObject3;
            i = localJSONObject.getInt("type");
          }
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
        catch (Exception localException1)
        {
          localObject1 = localObject2;
          localObject2 = localObject4;
        }
        if (!QLog.isColorLevel()) {
          break label246;
        }
      }
      catch (Exception localException2)
      {
        localObject2 = "";
      }
      QLog.d("FunyPicHelper", 2, localException2.getMessage());
      label246:
      i = j;
    }
    else
    {
      label251:
      localObject2 = "";
      i = j;
    }
    paramAppInterface = paramAppInterface.getApp().getSharedPreferences("funny_pic_info", 0);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramAppInterface.edit().putString("funnypic_count_sp_key", (String)localObject1).commit();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      paramAppInterface.edit().putString("funnypic_name_sp_key", (String)localObject2).commit();
    }
    paramAppInterface.edit().putInt("funnypic_type_sp_key", i).commit();
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("funnypic zipID->");
      paramAppInterface.append((String)localObject1);
      paramAppInterface.append(";imgName -> ");
      paramAppInterface.append((String)localObject2);
      paramAppInterface.append(";type -> ");
      paramAppInterface.append(i);
      QLog.d("FunyPicHelper", 2, paramAppInterface.toString());
    }
  }
  
  private static void a(boolean paramBoolean, Context paramContext, IPicDownloadListener paramIPicDownloadListener, DownloaderInterface paramDownloaderInterface, IFavroamingDBManagerService paramIFavroamingDBManagerService, IVipComicMqqManagerService paramIVipComicMqqManagerService, List<CustomEmotionData> paramList1, List<CustomEmotionData> paramList2, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, CustomEmotionData paramCustomEmotionData)
  {
    if (!TextUtils.isEmpty(paramCustomEmotionData.url))
    {
      if (paramDownloaderInterface.getTask(paramCustomEmotionData.url) != null)
      {
        paramAtomicInteger1.decrementAndGet();
        return;
      }
      Object localObject = new FunnyPicHelper.CalcPath(paramIVipComicMqqManagerService, paramCustomEmotionData).a();
      paramIVipComicMqqManagerService = ((FunnyPicHelper.CalcPath)localObject).a();
      boolean bool = ((FunnyPicHelper.CalcPath)localObject).a();
      File localFile = new File(paramIVipComicMqqManagerService);
      if (localFile.exists())
      {
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("download path is exsit->");
          paramContext.append(paramIVipComicMqqManagerService);
          QLog.d("FunyPicHelper", 2, paramContext.toString());
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
          paramIFavroamingDBManagerService.updateCustomEmotion(paramCustomEmotionData);
        }
        if (paramIPicDownloadListener != null) {
          paramIPicDownloadListener.onFileDone(paramCustomEmotionData, true);
        }
        paramList1.add(paramCustomEmotionData);
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("update funnyPic eId->");
          paramContext.append(paramCustomEmotionData.eId);
          paramContext.append(" emoPath->");
          paramContext.append(paramCustomEmotionData.emoPath);
          paramContext.append(" download->sucess");
          QLog.d("FunyPicHelper", 2, paramContext.toString());
        }
      }
      else
      {
        DownloadTask localDownloadTask = new DownloadTask(paramCustomEmotionData.url, localFile);
        localDownloadTask.p = false;
        localDownloadTask.f = "emotion_pic";
        localDownloadTask.b = 1;
        if (paramCustomEmotionData.url.contains("qto_"))
        {
          localObject = FunnyPicHelperConstant.a(paramCustomEmotionData.url);
          paramIVipComicMqqManagerService = (IVipComicMqqManagerService)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramIVipComicMqqManagerService = (IVipComicMqqManagerService)localObject;
            if (((String)localObject).length() > 12)
            {
              paramIVipComicMqqManagerService = ((String)localObject).substring(0, 12);
              FunnyPicHelperConstant.a.add(paramIVipComicMqqManagerService);
            }
          }
        }
        else
        {
          paramIVipComicMqqManagerService = "";
        }
        paramDownloaderInterface.startDownload(localDownloadTask, new FunnyPicHelper.1(paramIVipComicMqqManagerService, localFile, paramCustomEmotionData, bool, paramBoolean, paramIFavroamingDBManagerService, paramIPicDownloadListener, paramList1, paramList2, paramContext, paramAtomicInteger2, paramAtomicInteger1), null);
      }
      if ((paramAtomicInteger1.get() == 0) && (paramIPicDownloadListener != null)) {
        paramIPicDownloadListener.onDone(paramList1, paramList2);
      }
    }
    else
    {
      if (paramIPicDownloadListener != null) {
        paramIPicDownloadListener.onFileDone(paramCustomEmotionData, false);
      }
      if (TextUtils.isEmpty(paramCustomEmotionData.RomaingType)) {
        paramContext = "null";
      } else {
        paramContext = paramCustomEmotionData.RomaingType;
      }
      if (QLog.isColorLevel())
      {
        paramIPicDownloadListener = new StringBuilder();
        paramIPicDownloadListener.append("checkLoadEmotionPic, url is null : ");
        paramIPicDownloadListener.append(paramCustomEmotionData.resid);
        paramIPicDownloadListener.append(", romaingType:");
        paramIPicDownloadListener.append(paramContext);
        QLog.d("FunyPicHelper", 2, paramIPicDownloadListener.toString());
      }
    }
  }
  
  public static void a(boolean paramBoolean, Context paramContext, List<CustomEmotionData> paramList, AppInterface paramAppInterface, IPicDownloadListener paramIPicDownloadListener)
  {
    if ((paramContext != null) && (paramAppInterface != null) && (paramList != null))
    {
      if (paramList.isEmpty()) {
        return;
      }
      if (NetworkUtil.isNetworkAvailable(paramContext))
      {
        DownloaderInterface localDownloaderInterface = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(1);
        if (localDownloaderInterface == null) {
          return;
        }
        IFavroamingDBManagerService localIFavroamingDBManagerService = (IFavroamingDBManagerService)paramAppInterface.getRuntimeService(IFavroamingDBManagerService.class, "");
        IVipComicMqqManagerService localIVipComicMqqManagerService = (IVipComicMqqManagerService)paramAppInterface.getRuntimeService(IVipComicMqqManagerService.class, "");
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        paramAppInterface = new AtomicInteger(paramList.size());
        AtomicInteger localAtomicInteger = new AtomicInteger(0);
        Iterator localIterator = paramList.iterator();
        paramList = paramAppInterface;
        while (localIterator.hasNext()) {
          a(paramBoolean, paramContext, paramIPicDownloadListener, localDownloaderInterface, localIFavroamingDBManagerService, localIVipComicMqqManagerService, localArrayList1, localArrayList2, paramList, localAtomicInteger, (CustomEmotionData)localIterator.next());
        }
      }
      if (paramIPicDownloadListener != null) {
        paramIPicDownloadListener.onDone(new ArrayList(), paramList);
      }
    }
  }
  
  private static void b(DownloadTask paramDownloadTask, String paramString, File paramFile, CustomEmotionData paramCustomEmotionData, boolean paramBoolean1, boolean paramBoolean2, IFavroamingDBManagerService paramIFavroamingDBManagerService, IPicDownloadListener paramIPicDownloadListener, List<CustomEmotionData> paramList1, List<CustomEmotionData> paramList2, Context paramContext, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2)
  {
    FunnyPicHelperConstant.a.remove(paramString);
    if ((3 == paramDownloadTask.a()) && (paramFile.exists()))
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
        paramIFavroamingDBManagerService.updateCustomEmotion(paramCustomEmotionData);
      }
      if (paramIPicDownloadListener != null) {
        paramIPicDownloadListener.onFileDone(paramCustomEmotionData, true);
      }
      paramList1.add(paramCustomEmotionData);
      if (QLog.isColorLevel())
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append("update funnyPic eId->");
        paramDownloadTask.append(paramCustomEmotionData.eId);
        paramDownloadTask.append(" emoPath->");
        paramDownloadTask.append(paramCustomEmotionData.emoPath);
        paramDownloadTask.append(" download->sucess");
        QLog.d("FunyPicHelper", 2, paramDownloadTask.toString());
      }
    }
    else
    {
      paramList2.add(paramCustomEmotionData);
      if (paramIPicDownloadListener != null) {
        paramIPicDownloadListener.onFileDone(paramCustomEmotionData, false);
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("update funnyPic eId->");
        paramString.append(paramCustomEmotionData.eId);
        paramString.append(" emoPath->");
        paramString.append(paramCustomEmotionData.emoPath);
        paramString.append(" download->faile");
        QLog.d("FunyPicHelper", 2, paramString.toString());
      }
      paramString = new StringBuilder();
      paramString.append(NetworkUtil.getNetworkType(paramContext));
      paramString.append("");
      paramString = paramString.toString();
      paramFile = new StringBuilder();
      paramFile.append(paramDownloadTask.a);
      paramFile.append("");
      VasReportUtils.a("emotionType", "emotionActionFav", "3", "", "", paramString, paramFile.toString(), "", "", "");
    }
    paramAtomicInteger1.getAndIncrement();
    if ((paramAtomicInteger1.get() == paramAtomicInteger2.get()) && (paramIPicDownloadListener != null)) {
      paramIPicDownloadListener.onDone(paramList1, paramList2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.FunnyPicHelper
 * JD-Core Version:    0.7.0.1
 */