import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.qphone.base.util.QLog;

class apbq
  implements SoundPool.OnLoadCompleteListener
{
  apbq(apbp paramapbp) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0) {}
    try
    {
      QLog.e("ARMusicController", 2, "load fire music failed. " + apbp.a(this.a));
      return;
    }
    catch (Exception paramSoundPool)
    {
      paramSoundPool.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMusicController", 2, "load fire music success. : " + apbp.a(this.a));
    }
    apbp.a(this.a, true);
    if (apbp.a(this.a))
    {
      paramSoundPool.play(paramInt1, 1.0F, 1.0F, 1, 0, 1.0F);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbq
 * JD-Core Version:    0.7.0.1
 */