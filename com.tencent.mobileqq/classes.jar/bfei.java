import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.troop.utils.VideoAnimationUtils.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class bfei
{
  private static final String a = AppConstants.SDCARD_PATH + ".troop/anim_video/";
  
  public static void a(bgog parambgog, String paramString1, String paramString2, SpriteVideoView paramSpriteVideoView, bcrz parambcrz)
  {
    if (parambgog == null) {}
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
        b(paramSpriteVideoView, paramString1.getAbsolutePath(), parambcrz);
        return;
      }
      parambgog = parambgog.a(1);
      localObject = new File(a);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramString2 = new bgoe(paramString2, paramString1);
      paramString2.b = 2;
      localObject = new Bundle();
    } while (parambgog == null);
    parambgog.a(paramString2, new bfej(paramSpriteVideoView, paramString1, parambcrz), (Bundle)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramString1, paramString2, null, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, SpriteVideoView paramSpriteVideoView, bcrz parambcrz)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    a((bgog)paramQQAppInterface.getManager(47), paramString1, paramString2, paramSpriteVideoView, parambcrz);
  }
  
  private static void b(WeakReference<SpriteVideoView> paramWeakReference, String paramString, bcrz parambcrz)
  {
    if (paramWeakReference != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoAnimationUtils", 2, "playVideoAnim");
      }
      if ((SpriteVideoView)paramWeakReference.get() != null) {
        ThreadManager.getUIHandler().post(new VideoAnimationUtils.2(paramWeakReference, paramString, parambcrz));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfei
 * JD-Core Version:    0.7.0.1
 */