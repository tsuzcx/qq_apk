import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class atgl
{
  private static zhw a = new zhw(BaseApplicationImpl.sApplication);
  
  public static void a()
  {
    try
    {
      JavaHookBridge.findAndHookMethod(Bitmap.class, "createBitmap", new Object[] { DisplayMetrics.class, Integer.TYPE, Integer.TYPE, Bitmap.Config.class, Boolean.TYPE, new atgm(90001) });
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      try
      {
        JavaHookBridge.findAndHookMethod(Bitmap.class, "createBitmap", new Object[] { DisplayMetrics.class, [I.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Bitmap.Config.class, new atgm(90002) });
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        try
        {
          for (;;)
          {
            JavaHookBridge.findAndHookMethod(BitmapFactory.class, "decodeResource", new Object[] { Resources.class, Integer.TYPE, BitmapFactory.Options.class, new atgm(90003) });
            try
            {
              JavaHookBridge.findAndHookMethod(BitmapFactory.class, "decodeFile", new Object[] { String.class, BitmapFactory.Options.class, new atgm(90004) });
              return;
            }
            catch (NoSuchMethodException localNoSuchMethodException4)
            {
              bdeu.a(localNoSuchMethodException4);
            }
            localNoSuchMethodException1 = localNoSuchMethodException1;
            bdeu.a(localNoSuchMethodException1);
            continue;
            localNoSuchMethodException2 = localNoSuchMethodException2;
            bdeu.a(localNoSuchMethodException2);
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException3)
        {
          for (;;)
          {
            bdeu.a(localNoSuchMethodException3);
          }
        }
      }
    }
  }
  
  private static void b(boolean paramBoolean, int paramInt)
  {
    String str = null;
    Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null) {
      str = ((QQAppInterface)localObject).getCurrentAccountUin();
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("param_FailCode", Integer.toString(paramInt));
    azri.a(BaseApplicationImpl.getApplication()).a(str, "BitmapOOMHooker", paramBoolean, 0L, 0L, (HashMap)localObject, "", true);
  }
  
  private static void c()
  {
    if (BaseApplicationImpl.sImageCache != null) {
      BaseApplicationImpl.sImageCache.evictAll();
    }
    System.gc();
    Thread.yield();
    System.gc();
    if (ThreadManager.getUIHandler().getLooper() != Looper.myLooper()) {}
    try
    {
      Thread.sleep(1000L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atgl
 * JD-Core Version:    0.7.0.1
 */