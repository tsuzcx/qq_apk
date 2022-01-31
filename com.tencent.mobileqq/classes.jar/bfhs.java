import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.QQProtectCommon.QQProtectQueryHead;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.io.File;
import mqq.app.MobileQQ;

public class bfhs
{
  public static volatile int a = -1;
  
  public static int a()
  {
    Object localObject = bbdh.a(MobileQQ.sMobileQQ);
    try
    {
      localObject = ((String)localObject).split("\\.");
      int i = Integer.parseInt(localObject[0]);
      int j = Integer.parseInt(localObject[1]);
      int k = Integer.parseInt(localObject[2]);
      return k << 8 | i << 24 | 0x0 | j << 16;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public static QQProtectCommon.QQProtectQueryHead a(int paramInt)
  {
    for (;;)
    {
      try
      {
        localQQProtectQueryHead = new QQProtectCommon.QQProtectQueryHead();
        localQQProtectQueryHead.uint32_sec_cmd.set(paramInt);
        localObject3 = bfnn.a("641d5d");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localQQProtectQueryHead.bytes_imei.set(ByteStringMicro.copyFromUtf8((String)localObject1));
        localQQProtectQueryHead.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
        localObject1 = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localObject1 == null) {
          break label243;
        }
        localObject1 = ((QQAppInterface)localObject1).getCurrentAccountUin();
      }
      catch (Throwable localThrowable)
      {
        QQProtectCommon.QQProtectQueryHead localQQProtectQueryHead;
        Object localObject1;
        StringBuilder localStringBuilder;
        localThrowable.printStackTrace();
        return null;
      }
      localQQProtectQueryHead.string_uin.set((String)localObject3);
      localQQProtectQueryHead.os_version.set(Build.VERSION.SDK_INT);
      paramInt = a();
      localQQProtectQueryHead.qq_version.set(paramInt);
      Object localObject3 = localQQProtectQueryHead.cpu_arch;
      localStringBuilder = new StringBuilder().append(Build.CPU_ABI).append("#");
      if (b())
      {
        localObject1 = "1";
        ((PBStringField)localObject3).set((String)localObject1);
        localQQProtectQueryHead.rom_info.set(Build.MODEL);
        localObject1 = localQQProtectQueryHead.root;
        if (a())
        {
          paramInt = 1;
          ((PBUInt32Field)localObject1).set(paramInt);
          localQQProtectQueryHead.brand_info.set(Build.BRAND);
          localQQProtectQueryHead.manufacturer.set(Build.MANUFACTURER);
          localQQProtectQueryHead.package_name.set(c());
          localQQProtectQueryHead.app_id.set(AppSetting.a());
          return localQQProtectQueryHead;
        }
      }
      else
      {
        localObject1 = "0";
        continue;
      }
      paramInt = 0;
      continue;
      label243:
      Object localObject2 = null;
      localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = "";
      }
    }
  }
  
  public static String a()
  {
    return a(33751040);
  }
  
  public static String a(int paramInt)
  {
    return String.format("%d.%d.%d", new Object[] { Integer.valueOf(paramInt >> 24), Integer.valueOf((0xFF0000 & paramInt) >> 16), Integer.valueOf((0xFF00 & paramInt) >> 8) });
  }
  
  public static boolean a()
  {
    boolean bool3 = true;
    int i = 0;
    boolean bool1 = zyy.a();
    boolean bool2 = bool1;
    String[] arrayOfString;
    if (!bool1)
    {
      arrayOfString = new String[3];
      arrayOfString[0] = "/system/sbin/";
      arrayOfString[1] = "/sbin/";
      arrayOfString[2] = "/vendor/bin/";
    }
    try
    {
      int j = arrayOfString.length;
      if (i < j)
      {
        String str = arrayOfString[i];
        bool2 = new File(str + "su").exists();
        if (bool2) {
          bool1 = bool3;
        }
      }
      for (;;)
      {
        bool2 = bool1;
        return bool2;
        i += 1;
        break;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return bool1;
    }
  }
  
  public static String b()
  {
    return a(a);
  }
  
  public static String b(int paramInt)
  {
    if (paramInt == 1) {}
    try
    {
      return bfnn.a("641d5d");
    }
    catch (Exception localException) {}
    if (paramInt == 2) {
      return bfnn.c("641d5d");
    }
    if (paramInt == 3)
    {
      String str = bfnn.b("641d5d");
      return str;
    }
    return null;
  }
  
  public static boolean b()
  {
    String str = System.getProperty("os.arch");
    return (str != null) && (str.contains("64"));
  }
  
  public static String c()
  {
    String str2 = MobileQQ.sMobileQQ.getPackageName();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "com.tencent.mobileqq";
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfhs
 * JD-Core Version:    0.7.0.1
 */