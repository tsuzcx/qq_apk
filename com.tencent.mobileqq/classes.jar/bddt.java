import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class bddt
{
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent;
    if (paramContext != null)
    {
      localIntent = paramContext.getPackageManager().getLaunchIntentForPackage("com.tencent.qqpimsecure");
      if (localIntent != null)
      {
        Bundle localBundle = new Bundle();
        if ((paramString != null) && (paramString.length() > 0)) {
          localBundle.putString("platform_Id", paramString);
        }
        if (paramInt > 0) {
          localBundle.putInt("dest_view", paramInt);
        }
        localIntent.putExtras(localBundle);
        if (paramInt != 9502721) {
          break label93;
        }
        localIntent.putExtra("big_brother_source_key", "biz_src_tmm");
      }
    }
    for (;;)
    {
      localIntent.setFlags(402653184);
      paramContext.startActivity(localIntent);
      return;
      label93:
      localIntent.putExtra("big_brother_source_key", "biz_src_safe");
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool1 = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 64).signatures;
      Object localObject = MessageDigest.getInstance("MD5");
      if ((paramContext != null) && (paramContext.length > 0)) {
        ((MessageDigest)localObject).update(paramContext[0].toByteArray());
      }
      paramContext = ((MessageDigest)localObject).digest();
      localObject = new char[16];
      Object tmp58_56 = localObject;
      tmp58_56[0] = 48;
      Object tmp63_58 = tmp58_56;
      tmp63_58[1] = 49;
      Object tmp68_63 = tmp63_58;
      tmp68_63[2] = 50;
      Object tmp73_68 = tmp68_63;
      tmp73_68[3] = 51;
      Object tmp78_73 = tmp73_68;
      tmp78_73[4] = 52;
      Object tmp83_78 = tmp78_73;
      tmp83_78[5] = 53;
      Object tmp88_83 = tmp83_78;
      tmp88_83[6] = 54;
      Object tmp94_88 = tmp88_83;
      tmp94_88[7] = 55;
      Object tmp100_94 = tmp94_88;
      tmp100_94[8] = 56;
      Object tmp106_100 = tmp100_94;
      tmp106_100[9] = 57;
      Object tmp112_106 = tmp106_100;
      tmp112_106[10] = 65;
      Object tmp118_112 = tmp112_106;
      tmp118_112[11] = 66;
      Object tmp124_118 = tmp118_112;
      tmp124_118[12] = 67;
      Object tmp130_124 = tmp124_118;
      tmp130_124[13] = 68;
      Object tmp136_130 = tmp130_124;
      tmp136_130[14] = 69;
      Object tmp142_136 = tmp136_130;
      tmp142_136[15] = 70;
      tmp142_136;
      StringBuilder localStringBuilder = new StringBuilder(paramContext.length * 2);
      int i = 0;
      while (i < paramContext.length)
      {
        localStringBuilder.append(localObject[((paramContext[i] & 0xF0) >>> 4)]);
        localStringBuilder.append(localObject[(paramContext[i] & 0xF)]);
        i += 1;
      }
      if (!"00B1208638DE0FCD3E920886D658DAF6".equalsIgnoreCase(localStringBuilder.toString()))
      {
        boolean bool2 = "7CC749CFC0FB5677E6ABA342EDBDBA5A".equalsIgnoreCase(localStringBuilder.toString());
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    Object localObject1;
    if (paramContext != null)
    {
      localObject1 = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
        } while (!"com.tencent.qqpimsecure".equalsIgnoreCase(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next()).processName));
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((!bool1) && (Build.VERSION.SDK_INT >= 21)) {}
      boolean bool2;
      for (;;)
      {
        try
        {
          localObject1 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[] { "ps" }).getInputStream()));
          Object localObject2 = ((BufferedReader)localObject1).readLine();
          bool2 = bool1;
          if (localObject2 != null)
          {
            if (((String)localObject2).indexOf("com.tencent.qqpimsecure") == -1) {
              continue;
            }
            localObject2 = new StringTokenizer((String)localObject2, " ");
            ((StringTokenizer)localObject2).nextToken();
            ((StringTokenizer)localObject2).nextToken();
            ((StringTokenizer)localObject2).nextToken();
            ((StringTokenizer)localObject2).nextToken();
            ((StringTokenizer)localObject2).nextToken();
            ((StringTokenizer)localObject2).nextToken();
            ((StringTokenizer)localObject2).nextToken();
            ((StringTokenizer)localObject2).nextToken();
            bool2 = TextUtils.equals(((StringTokenizer)localObject2).nextToken().trim(), "com.tencent.qqpimsecure");
            if (!bool2) {
              continue;
            }
            bool2 = true;
          }
          if ((bool2) || (Build.VERSION.SDK_INT <= 23) || (paramContext == null)) {
            break;
          }
          paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647);
          if (paramContext == null) {
            break;
          }
          paramContext = paramContext.iterator();
          if (!paramContext.hasNext()) {
            break;
          }
          localObject1 = (ActivityManager.RunningServiceInfo)paramContext.next();
          if ((localObject1 == null) || (((ActivityManager.RunningServiceInfo)localObject1).service == null) || (((ActivityManager.RunningServiceInfo)localObject1).process == null) || (!((ActivityManager.RunningServiceInfo)localObject1).process.contains("com.tencent.qqpimsecure"))) {
            continue;
          }
          return true;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 0);
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        paramContext = paramContext.versionName;
        bool1 = bool2;
        if (paramContext != null)
        {
          boolean bool3 = paramContext.contains("mini");
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean d(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 0);
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        paramContext = paramContext.versionName;
        bool1 = bool2;
        if (paramContext != null)
        {
          boolean bool3 = paramContext.contains("minipay");
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean e(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 0);
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        int i = paramContext.versionCode;
        bool1 = bool2;
        if (i >= 198) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean f(Context paramContext)
  {
    return ((a(paramContext)) && (e(paramContext)) && (!c(paramContext))) || (d(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddt
 * JD-Core Version:    0.7.0.1
 */