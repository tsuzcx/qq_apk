import android.graphics.BitmapFactory.Options;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class apkd
{
  public static blnc a = new blnc();
  
  public static String a(String paramString)
  {
    CompressInfo localCompressInfo = new CompressInfo(paramString, 0, -1);
    localCompressInfo.g = true;
    boolean bool = awga.a(localCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("FavEmoSendControl", 2, new Object[] { "compressBeforeUpload, success: ", Boolean.valueOf(bool) });
    }
    if (bool) {
      paramString = localCompressInfo.e;
    }
    return paramString;
  }
  
  public static void a(List<String> paramList)
  {
    QLog.i("FavEmoSendControl", 1, "uploadCameraEmoList");
    Object localObject1 = (QQAppInterface)bllv.a();
    apke localapke = (apke)((QQAppInterface)localObject1).getManager(149);
    alnm localalnm = (alnm)((QQAppInterface)localObject1).a(72);
    String str1 = ((QQAppInterface)localObject1).c();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    int j = 0;
    int k = 0;
    String str2;
    List localList;
    int i;
    label109:
    Object localObject2;
    if (localIterator.hasNext())
    {
      str2 = (String)localIterator.next();
      localList = localapke.a();
      localObject1 = localList.iterator();
      i = 1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CustomEmotionData)((Iterator)localObject1).next();
        if (i >= ((CustomEmotionData)localObject2).emoId) {
          break label731;
        }
        i = ((CustomEmotionData)localObject2).emoId;
      }
    }
    label423:
    label728:
    label731:
    for (;;)
    {
      break label109;
      CustomEmotionData localCustomEmotionData1 = new CustomEmotionData();
      localCustomEmotionData1.uin = str1;
      localCustomEmotionData1.emoId = (i + 1);
      localCustomEmotionData1.emoOriginalPath = str2;
      localCustomEmotionData1.RomaingType = "needUpload";
      if (!a(localCustomEmotionData1.emoOriginalPath))
      {
        QLog.e("FavEmoSendControl", 1, new Object[] { "doStep, checkPicFavEnable false, path ", localCustomEmotionData1.emoOriginalPath });
        localCustomEmotionData1.emoPath = str2;
        localCustomEmotionData1.RomaingType = "failed";
        localapke.c(localCustomEmotionData1);
        localalnm.notifyUI(2, true, null);
        a(false, 1, 0);
        i = k + 1;
        k = i;
        break;
      }
      localObject1 = localCustomEmotionData1.emoOriginalPath;
      if (a()) {
        localObject1 = a(localCustomEmotionData1.emoOriginalPath);
      }
      String str3 = SecUtil.getFileMd5((String)localObject1);
      localObject2 = ".jpg";
      i = ((String)localObject1).lastIndexOf(".");
      if (i > 0) {
        localObject2 = ((String)localObject1).substring(i);
      }
      localObject2 = aljq.bi + ammj.a(str1) + str3 + (String)localObject2;
      boolean bool = bdcs.d((String)localObject1, (String)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("FavEmoSendControl", 2, new Object[] { "doStep, copyFile completed, result:", Boolean.valueOf(bool) });
      }
      if (!((String)localObject1).equals(localCustomEmotionData1.emoOriginalPath)) {
        bdcs.d((String)localObject1);
      }
      localObject1 = localList.iterator();
      i = 0;
      int m = j;
      int n = i;
      CustomEmotionData localCustomEmotionData2;
      if (((Iterator)localObject1).hasNext())
      {
        localCustomEmotionData2 = (CustomEmotionData)((Iterator)localObject1).next();
        if ((!((String)localObject2).equals(localCustomEmotionData2.emoPath)) && (!str3.equals(localCustomEmotionData2.md5))) {
          break label728;
        }
        QLog.e("FavEmoSendControl", 1, new Object[] { "doStep fail, duplicate path, path:", localCustomEmotionData2.emoPath });
        a(false, 2, 0);
        if ("needDel".equals(localCustomEmotionData2.RomaingType))
        {
          localapke.a(localCustomEmotionData2, localList.indexOf(localCustomEmotionData2));
          i = 1;
        }
      }
      for (;;)
      {
        break label423;
        if ("failed".equals(localCustomEmotionData2.RomaingType))
        {
          localapke.a(localCustomEmotionData2);
        }
        else
        {
          n = 1;
          m = j + 1;
          if (n == 0)
          {
            localCustomEmotionData1.md5 = str3;
            localCustomEmotionData1.emoPath = ((String)localObject2);
            localapke.c(localCustomEmotionData1);
            localArrayList.add(localCustomEmotionData1);
            if (paramList.indexOf(str2) % 4 == 3) {
              localalnm.notifyUI(2, true, null);
            }
          }
          j = m;
          i = k;
          break;
          if (!localArrayList.isEmpty())
          {
            localalnm.notifyUI(2, true, null);
            QLog.d("FavEmoSendControl", 1, "doStep, insert completed");
            i = paramList.size();
            a.a(String.valueOf(1011), new Object[] { localArrayList, Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
            return;
          }
          CameraEmoAllSend.a(paramList.size(), 0, 0, k, j);
          return;
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean)
    {
      str = "1";
      localHashMap.put("sucFlag", str);
      localHashMap.put("retCode", String.valueOf(paramInt1));
      localHashMap.put("serverRetCode", String.valueOf(paramInt2));
      azmz.a(BaseApplication.getContext()).a(null, "FavEmoUploadLocal", false, 0L, 0L, localHashMap, null);
      if (!paramBoolean) {
        break label91;
      }
    }
    label91:
    for (String str = "0";; str = String.valueOf(paramInt1))
    {
      aube.c(str, 1);
      return;
      str = "0";
      break;
    }
  }
  
  public static boolean a()
  {
    return true;
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      aojd localaojd = (aojd)aogj.a().a(561);
      if (new File(paramString).length() >= localaojd.a) {
        return false;
      }
      if (!awgi.a(paramString))
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile(paramString, localOptions);
        if (localOptions.outWidth < localaojd.b)
        {
          int i = localOptions.outHeight;
          int j = localaojd.b;
          if (i < j) {}
        }
        else
        {
          return false;
        }
      }
    }
    catch (Exception paramString)
    {
      QLog.e("FavEmoSendControl", 1, "checkPicFavEnable exception, ", paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apkd
 * JD-Core Version:    0.7.0.1
 */