import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.troop.utils.VideoAnimationUtils.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class bcqe
{
  private static final String a = alof.aX + ".troop/anim_video/";
  
  public static void a(beag parambeag, String paramString1, String paramString2, SpriteVideoView paramSpriteVideoView, baej parambaej)
  {
    if (parambeag == null) {}
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
        b(paramSpriteVideoView, paramString1.getAbsolutePath(), parambaej);
        return;
      }
      parambeag = parambeag.a(1);
      localObject = new File(a);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramString2 = new beae(paramString2, paramString1);
      paramString2.b = 2;
      localObject = new Bundle();
    } while (parambeag == null);
    parambeag.a(paramString2, new bcqf(paramSpriteVideoView, paramString1, parambaej), (Bundle)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramString1, paramString2, null, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, SpriteVideoView paramSpriteVideoView, baej parambaej)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    a((beag)paramQQAppInterface.getManager(47), paramString1, paramString2, paramSpriteVideoView, parambaej);
  }
  
  private static void b(WeakReference<SpriteVideoView> paramWeakReference, String paramString, baej parambaej)
  {
    if (paramWeakReference != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoAnimationUtils", 2, "playVideoAnim");
      }
      if ((SpriteVideoView)paramWeakReference.get() != null) {
        ThreadManager.getUIHandler().post(new VideoAnimationUtils.2(paramWeakReference, paramString, parambaej));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcqe
 * JD-Core Version:    0.7.0.1
 */