import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profile.ProfileCardManager.1;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0x703.cmd0x703.PhotoInfo;
import tencent.im.oidb.cmd0x703.cmd0x703.UinPhotoListInfo;

public class azff
{
  public static String a;
  public static Map<Long, Boolean> a;
  public static Map<Long, Boolean> b;
  protected Context a;
  public Handler a;
  protected AppInterface a;
  public Vector<Integer> a;
  Map<Long, Integer> c = new ConcurrentHashMap();
  Map<String, Boolean> d = new ConcurrentHashMap();
  private Map<Integer, azfg> e = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    b = new ConcurrentHashMap();
    jdField_a_of_type_JavaLangString = "https://gxh.vip.qq.com/xydata";
  }
  
  public azff(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramAppInterface.getApp().getApplicationContext();
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    return bghy.c(paramContext) + paramLong + File.separator;
  }
  
  public static String a(Context paramContext, long paramLong1, long paramLong2)
  {
    if (paramLong1 == azfl.j) {
      return a(paramContext, paramLong2) + "wzBgImage.png";
    }
    if (paramLong1 == azfl.i) {
      return a(paramContext, paramLong2) + "wzJoinImage.png";
    }
    return a(paramContext, paramLong2) + "cardPreview.jpg";
  }
  
  public static String a(String paramString)
  {
    return anhk.cq + "defaultCard" + File.separator + paramString + ".json";
  }
  
  public static boolean a(Context paramContext, long paramLong)
  {
    paramContext = a(paramContext, paramLong);
    if (TextUtils.isEmpty(paramContext)) {}
    for (paramContext = null; (paramContext != null) && (paramContext.exists()) && (paramContext.isDirectory()) && (paramContext.list().length > 1); paramContext = new File(paramContext)) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext, long paramLong, String paramString)
  {
    paramContext = new File(a(paramContext, paramLong), paramString);
    return (paramContext.exists()) && ((!paramContext.isDirectory()) || (paramContext.list().length > 1));
  }
  
  public static byte[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    cmd0x703.UinPhotoListInfo localUinPhotoListInfo = new cmd0x703.UinPhotoListInfo();
    cmd0x703.PhotoInfo localPhotoInfo = new cmd0x703.PhotoInfo();
    localPhotoInfo.str_url.set(paramString);
    localPhotoInfo.uint32_id.set(-1);
    localPhotoInfo.uint32_timestamp.set(0);
    localUinPhotoListInfo.rpt_msg_photo_info.add(localPhotoInfo);
    return localUinPhotoListInfo.toByteArray();
  }
  
  public static String b(Context paramContext, long paramLong)
  {
    return bghy.c(paramContext) + paramLong + ".zip";
  }
  
  public static String b(Context paramContext, long paramLong1, long paramLong2)
  {
    if (paramLong1 == azfl.j) {
      return a(paramContext, paramLong2) + "wzDynamicDrawerImage.png";
    }
    if (paramLong1 == azfl.i) {
      return a(paramContext, paramLong2) + "wzJoinImage.png";
    }
    return a(paramContext, paramLong2) + "cardPreview.jpg";
  }
  
  public int a(long paramLong)
  {
    int i = 0;
    if (this.c.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.c.get(Long.valueOf(paramLong))).intValue();
    }
    return i;
  }
  
  public azfg a(int paramInt, boolean paramBoolean)
  {
    try
    {
      azfg localazfg = (azfg)this.e.get(Integer.valueOf(paramInt));
      if (localazfg == null)
      {
        localazfg = new azfg(this, paramInt);
        this.e.put(Integer.valueOf(paramInt), localazfg);
      }
      for (;;)
      {
        Object localObject2;
        if (!localazfg.a)
        {
          localObject2 = new File(a(Integer.toString(paramInt)));
          if (!((File)localObject2).exists()) {
            break label101;
          }
          ThreadManager.excute(new ProfileCardManager.1(this, (File)localObject2, paramInt), 64, null, true);
        }
        for (;;)
        {
          return localazfg;
          label101:
          if ((paramBoolean) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (!this.jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt))))
          {
            localObject2 = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(184);
            this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(paramInt));
            ((VasQuickUpdateManager)localObject2).downloadItem(33L, "profileitem." + paramInt, "ProfileCardRes");
          }
        }
      }
    }
    finally {}
  }
  
  public void a(long paramLong)
  {
    ((VasQuickUpdateManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(184)).cancelDwonloadItem(15L, "card." + paramLong);
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.c.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardManager", 2, "downloadProfileCardRes scid=" + paramString);
    }
    if ((this.d.containsKey(paramString)) && (((Boolean)this.d.get(paramString)).booleanValue())) {
      return;
    }
    this.d.put(paramString, Boolean.valueOf(true));
    ((VasQuickUpdateManager)paramQQAppInterface.getManager(184)).downloadItem(15L, paramString, "ProfileCardRes");
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    this.d.put(paramString1, Boolean.valueOf(false));
    if (paramInt == 0)
    {
      l = Long.parseLong(paramString1.substring("card.".length(), paramString1.length()));
      jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), Boolean.valueOf(true));
      b.put(Long.valueOf(l), Boolean.valueOf(true));
      paramString1 = a(paramQQAppInterface.getApp(), l);
      paramQQAppInterface = new File(b(paramQQAppInterface.getApp(), l));
      if (!paramQQAppInterface.exists()) {
        QLog.e("ProfileCardManager", 1, "unzip file is missing " + paramQQAppInterface.getAbsolutePath());
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        long l;
        return;
        try
        {
          bgmg.a(paramQQAppInterface.getAbsolutePath(), paramString1, false);
          VasQuickUpdateEngine.safeDeleteFile(paramQQAppInterface);
          paramString2 = new File(paramString1, "dynamic.zip");
          if (paramString2.exists())
          {
            String str = paramString1 + ".dynamic";
            bgmg.a(paramString2.getAbsolutePath(), str, false);
            VasQuickUpdateEngine.safeDeleteFile(paramString2);
          }
          if (QLog.isColorLevel())
          {
            QLog.d("ProfileCardManager", 2, "onDownloadComplete, resDir= " + paramString1);
            return;
          }
        }
        catch (OutOfMemoryError paramString2)
        {
          for (;;)
          {
            QLog.e("ProfileCardManager", 1, "failed to unzip " + paramQQAppInterface.getAbsolutePath(), paramString2);
          }
        }
        catch (Throwable paramString2)
        {
          for (;;)
          {
            QLog.e("ProfileCardManager", 1, "failed to unzip " + paramQQAppInterface.getAbsolutePath(), paramString2);
          }
        }
      }
    }
    QLog.d("ProfileCardManager", 2, "onDownloadComplete failed, errorCode = " + paramInt);
  }
  
  public boolean b(Context paramContext, long paramLong)
  {
    return VasQuickUpdateEngine.safeDeleteFile(new File(a(paramContext, paramLong)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azff
 * JD-Core Version:    0.7.0.1
 */