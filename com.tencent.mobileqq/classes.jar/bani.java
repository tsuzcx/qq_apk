import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.troop.utils.VideoAnimationUtils.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class bani
{
  private static final String a = ajsd.aW + ".troop/anim_video/";
  
  public static void a(bbww parambbww, String paramString1, String paramString2, SpriteVideoView paramSpriteVideoView, aycd paramaycd)
  {
    if (parambbww == null) {}
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
        b(paramSpriteVideoView, paramString1.getAbsolutePath(), paramaycd);
        return;
      }
      parambbww = parambbww.a(1);
      localObject = new File(a);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramString2 = new bbwu(paramString2, paramString1);
      paramString2.b = 2;
      localObject = new Bundle();
    } while (parambbww == null);
    parambbww.a(paramString2, new banj(paramSpriteVideoView, paramString1, paramaycd), (Bundle)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramString1, paramString2, null, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, SpriteVideoView paramSpriteVideoView, aycd paramaycd)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    a((bbww)paramQQAppInterface.getManager(47), paramString1, paramString2, paramSpriteVideoView, paramaycd);
  }
  
  private static void b(WeakReference<SpriteVideoView> paramWeakReference, String paramString, aycd paramaycd)
  {
    if (paramWeakReference != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoAnimationUtils", 2, "playVideoAnim");
      }
      if ((SpriteVideoView)paramWeakReference.get() != null) {
        ThreadManager.getUIHandler().post(new VideoAnimationUtils.2(paramWeakReference, paramString, paramaycd));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bani
 * JD-Core Version:    0.7.0.1
 */