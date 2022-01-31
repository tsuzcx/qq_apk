import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.troop.utils.VideoAnimationUtils.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class bamu
{
  private static final String a = ajsf.aW + ".troop/anim_video/";
  
  public static void a(bbwi parambbwi, String paramString1, String paramString2, SpriteVideoView paramSpriteVideoView, aycb paramaycb)
  {
    if (parambbwi == null) {}
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
        b(paramSpriteVideoView, paramString1.getAbsolutePath(), paramaycb);
        return;
      }
      parambbwi = parambbwi.a(1);
      localObject = new File(a);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramString2 = new bbwg(paramString2, paramString1);
      paramString2.b = 2;
      localObject = new Bundle();
    } while (parambbwi == null);
    parambbwi.a(paramString2, new bamv(paramSpriteVideoView, paramString1, paramaycb), (Bundle)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramString1, paramString2, null, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, SpriteVideoView paramSpriteVideoView, aycb paramaycb)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    a((bbwi)paramQQAppInterface.getManager(47), paramString1, paramString2, paramSpriteVideoView, paramaycb);
  }
  
  private static void b(WeakReference<SpriteVideoView> paramWeakReference, String paramString, aycb paramaycb)
  {
    if (paramWeakReference != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoAnimationUtils", 2, "playVideoAnim");
      }
      if ((SpriteVideoView)paramWeakReference.get() != null) {
        ThreadManager.getUIHandler().post(new VideoAnimationUtils.2(paramWeakReference, paramString, paramaycb));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bamu
 * JD-Core Version:    0.7.0.1
 */