import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARPromotion.ARPromotionSoundPlayer.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class apfm
  implements SoundPool.OnLoadCompleteListener
{
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(10, 3, 0);
  private Map<String, apfn> jdField_a_of_type_JavaUtilMap = new HashMap(10);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public apfm()
  {
    this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(this);
  }
  
  private void b()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        apfn localapfn = (apfn)((Map.Entry)localIterator.next()).getValue();
        if ((localapfn != null) && (localapfn.c()))
        {
          this.jdField_a_of_type_AndroidMediaSoundPool.pause(localapfn.a);
          localapfn.c = 2;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("ARPromotionSoundPlayer", 2, "stopSound exception", localException);
      }
    }
  }
  
  public void a()
  {
    ThreadManager.post(new ARPromotionSoundPlayer.1(this), 8, null, true);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    int i = -1;
    if (QLog.isColorLevel()) {
      QLog.d("ARPromotionSoundPlayer", 2, "playSound resPath: " + paramString);
    }
    this.b = false;
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("ARPromotionSoundPlayer", 2, "playSound resPath is empty!");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (new File(paramString).exists()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ARPromotionSoundPlayer", 2, "playSound file not exist");
        return;
      } while (this.b);
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        break;
      }
      b();
      paramString = (apfn)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    } while (paramString == null);
    if (QLog.isColorLevel()) {
      QLog.d("ARPromotionSoundPlayer", 2, "playSound contains resPath, state: " + paramString.c);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (paramString.b())
      {
        localSoundPool = this.jdField_a_of_type_AndroidMediaSoundPool;
        j = paramString.b;
        if (paramBoolean) {
          paramString.a = localSoundPool.play(j, 1.0F, 1.0F, 0, i, 1.0F);
        }
      }
      while (!paramString.c()) {
        for (;;)
        {
          paramString.c = 3;
          return;
          i = 0;
        }
      }
      SoundPool localSoundPool = this.jdField_a_of_type_AndroidMediaSoundPool;
      int j = paramString.b;
      if (paramBoolean) {}
      for (;;)
      {
        paramString.a = localSoundPool.play(j, 1.0F, 1.0F, 0, i, 1.0F);
        break;
        i = 0;
      }
    }
    paramString.c = 4;
    return;
    if (QLog.isColorLevel()) {
      QLog.d("ARPromotionSoundPlayer", 2, "playSound not contains resPath, load");
    }
    i = this.jdField_a_of_type_AndroidMediaSoundPool.load(paramString, 1);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, new apfn(this, i, 3));
  }
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARPromotionSoundPlayer", 2, "onLoadComplete sampleId:" + paramInt1 + ", status:" + paramInt2);
    }
    if (paramInt2 == 0) {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localapfn = (apfn)((Map.Entry)localIterator.next()).getValue();
            if ((localapfn != null) && (localapfn.b == paramInt1))
            {
              if (localapfn.a())
              {
                localapfn.c = 2;
                return;
              }
              if (localapfn.c()) {
                if (!this.jdField_a_of_type_Boolean)
                {
                  localapfn.a = paramSoundPool.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F);
                  return;
                }
              }
            }
          }
        }
      }
      catch (Exception paramSoundPool)
      {
        apfn localapfn;
        paramSoundPool.printStackTrace();
        if (QLog.isColorLevel())
        {
          QLog.e("ARPromotionSoundPlayer", 2, "onLoadComplete exception", paramSoundPool);
          return;
          localapfn.c = 4;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apfm
 * JD-Core Version:    0.7.0.1
 */