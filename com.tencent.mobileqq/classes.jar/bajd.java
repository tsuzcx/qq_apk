import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.ContactsContract.Contacts;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class bajd
{
  public static int a(Context paramContext)
  {
    paramContext = paramContext.getPackageManager().getInstalledApplications(0).iterator();
    int i = 0;
    if (paramContext.hasNext())
    {
      if ((((ApplicationInfo)paramContext.next()).flags & 0x1) > 0) {
        break label51;
      }
      i += 1;
    }
    label51:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public static long a()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l2;
    if (Build.VERSION.SDK_INT >= 18) {
      l2 = localStatFs.getBlockSizeLong();
    }
    for (long l1 = localStatFs.getAvailableBlocksLong();; l1 = localStatFs.getAvailableBlocks())
    {
      return l1 * l2 / 1048576L;
      l2 = localStatFs.getBlockSize();
    }
  }
  
  public static boolean a()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  @TargetApi(19)
  public static boolean a(Context paramContext, int paramInt)
  {
    boolean bool1 = true;
    Object localObject = paramContext.getSystemService("appops");
    for (;;)
    {
      try
      {
        paramContext = Class.forName("android.app.AppOpsManager").getMethod("checkOp", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localObject, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramContext.getApplicationInfo().uid), paramContext.getPackageName() });
        if (paramContext == null) {
          break label223;
        }
        paramInt = ((Integer)paramContext).intValue();
        if (QLog.isColorLevel()) {
          QLog.e("TroopDeviceUtil", 2, "checkOp mode = " + paramInt);
        }
        if ((paramInt != 0) && (3 != paramInt))
        {
          boolean bool2 = Build.MANUFACTURER.equals("vivo");
          if (!bool2) {
            continue;
          }
        }
        bool1 = true;
      }
      catch (InvocationTargetException paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TroopDeviceUtil", 2, "checkOp InvocationTargetException e.getCause() = " + paramContext.getCause());
        return false;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TroopDeviceUtil", 2, "checkOp e = " + paramContext);
        return true;
      }
      return bool1;
      bool1 = false;
      continue;
      label223:
      paramInt = 0;
    }
  }
  
  public static int b(Context paramContext)
  {
    paramContext = paramContext.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
    if (paramContext != null)
    {
      int i = paramContext.getCount();
      paramContext.close();
      return i;
    }
    return 0;
  }
  
  public static long b()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l2;
    if (Build.VERSION.SDK_INT >= 18) {
      l2 = localStatFs.getBlockSizeLong();
    }
    for (long l1 = localStatFs.getBlockCountLong();; l1 = localStatFs.getBlockCount())
    {
      return l1 * l2 / 1048576L;
      l2 = localStatFs.getBlockSize();
    }
  }
  
  public static int c(Context paramContext)
  {
    int j = 0;
    Cursor localCursor = paramContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id" }, null, null, null);
    int i;
    if (localCursor != null)
    {
      i = localCursor.getCount();
      localCursor.close();
    }
    for (;;)
    {
      paramContext = paramContext.getContentResolver().query(MediaStore.Images.Media.INTERNAL_CONTENT_URI, new String[] { "_id" }, null, null, null);
      if (paramContext != null)
      {
        j = paramContext.getCount();
        paramContext.close();
      }
      return i + j;
      i = 0;
    }
  }
  
  public static long c()
  {
    if (a())
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l2;
      if (Build.VERSION.SDK_INT >= 18) {
        l2 = localStatFs.getBlockSizeLong();
      }
      for (long l1 = localStatFs.getAvailableBlocksLong();; l1 = localStatFs.getAvailableBlocks())
      {
        return l1 * l2 / 1048576L;
        l2 = localStatFs.getBlockSize();
      }
    }
    return 0L;
  }
  
  public static int d(Context paramContext)
  {
    int j = 0;
    Cursor localCursor = paramContext.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[] { "_id" }, null, null, null);
    int i;
    if (localCursor != null)
    {
      i = localCursor.getCount();
      localCursor.close();
    }
    for (;;)
    {
      paramContext = paramContext.getContentResolver().query(MediaStore.Video.Media.INTERNAL_CONTENT_URI, new String[] { "_id" }, null, null, null);
      if (paramContext != null)
      {
        j = paramContext.getCount();
        paramContext.close();
      }
      return i + j;
      i = 0;
    }
  }
  
  public static long d()
  {
    if (a())
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l2;
      if (Build.VERSION.SDK_INT >= 18) {
        l2 = localStatFs.getBlockSizeLong();
      }
      for (long l1 = localStatFs.getBlockCountLong();; l1 = localStatFs.getBlockCount())
      {
        return l1 * l2 / 1048576L;
        l2 = localStatFs.getBlockSize();
      }
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bajd
 * JD-Core Version:    0.7.0.1
 */