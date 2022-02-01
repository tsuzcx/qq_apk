import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.troop.utils.VideoAnimationUtils.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class bgmo
{
  private static final String a = AppConstants.SDCARD_PATH + ".troop/anim_video/";
  
  public static void a(bhyq parambhyq, String paramString1, String paramString2, SpriteVideoView paramSpriteVideoView, bdyy parambdyy)
  {
    if (parambhyq == null) {}
    Object localObject;
    do
    {
      return;
      paramSpriteVideoView = new WeakReference(paramSpriteVideoView);
      paramString1 = new File(a + paramString1);
      if (paramString1.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoAnimationUtils", 2, "res exists, return:" + paramString1.getAbsolutePath());
        }
        b(paramSpriteVideoView, paramString1.getAbsolutePath(), parambdyy);
        return;
      }
      parambhyq = parambhyq.a(1);
      localObject = new File(a);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramString2 = new bhyo(paramString2, paramString1);
      paramString2.b = 2;
      localObject = new Bundle();
    } while (parambhyq == null);
    parambhyq.a(paramString2, new bgmp(paramSpriteVideoView, paramString1, parambdyy), (Bundle)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramString1, paramString2, null, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, SpriteVideoView paramSpriteVideoView, bdyy parambdyy)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    a((bhyq)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY), paramString1, paramString2, paramSpriteVideoView, parambdyy);
  }
  
  private static void b(WeakReference<SpriteVideoView> paramWeakReference, String paramString, bdyy parambdyy)
  {
    if (paramWeakReference != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoAnimationUtils", 2, "playVideoAnim");
      }
      if ((SpriteVideoView)paramWeakReference.get() != null) {
        ThreadManager.getUIHandler().post(new VideoAnimationUtils.2(paramWeakReference, paramString, parambdyy));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgmo
 * JD-Core Version:    0.7.0.1
 */