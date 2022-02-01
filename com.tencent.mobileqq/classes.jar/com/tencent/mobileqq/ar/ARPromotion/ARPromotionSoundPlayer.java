package com.tencent.mobileqq.ar.ARPromotion;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ARPromotionSoundPlayer
  implements SoundPool.OnLoadCompleteListener
{
  private SoundPool a = new SoundPool(10, 3, 0);
  private boolean b = false;
  private boolean c = false;
  private Map<String, ARPromotionSoundPlayer.ARSoundModel> d = new HashMap(10);
  
  public ARPromotionSoundPlayer()
  {
    this.a.setOnLoadCompleteListener(this);
  }
  
  private void b()
  {
    try
    {
      Iterator localIterator = this.d.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ARPromotionSoundPlayer.ARSoundModel localARSoundModel = (ARPromotionSoundPlayer.ARSoundModel)((Map.Entry)localIterator.next()).getValue();
        if ((localARSoundModel != null) && (localARSoundModel.c()))
        {
          this.a.pause(localARSoundModel.a);
          localARSoundModel.c = 2;
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playSound resPath: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ARPromotionSoundPlayer", 2, ((StringBuilder)localObject).toString());
    }
    this.c = false;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ARPromotionSoundPlayer", 2, "playSound resPath is empty!");
      }
      return;
    }
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("ARPromotionSoundPlayer", 2, "playSound file not exist");
      }
      return;
    }
    if (this.c) {
      return;
    }
    int i;
    if (this.d.containsKey(paramString))
    {
      b();
      paramString = (ARPromotionSoundPlayer.ARSoundModel)this.d.get(paramString);
      if (paramString != null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("playSound contains resPath, state: ");
          ((StringBuilder)localObject).append(paramString.c);
          QLog.d("ARPromotionSoundPlayer", 2, ((StringBuilder)localObject).toString());
        }
        if (!this.b)
        {
          int j;
          if (paramString.b())
          {
            localObject = this.a;
            j = paramString.b;
            if (paramBoolean) {
              i = -1;
            } else {
              i = 0;
            }
            paramString.a = ((SoundPool)localObject).play(j, 1.0F, 1.0F, 0, i, 1.0F);
          }
          else if (paramString.c())
          {
            localObject = this.a;
            j = paramString.b;
            if (paramBoolean) {
              i = -1;
            } else {
              i = 0;
            }
            paramString.a = ((SoundPool)localObject).play(j, 1.0F, 1.0F, 0, i, 1.0F);
          }
          paramString.c = 3;
          return;
        }
        paramString.c = 4;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARPromotionSoundPlayer", 2, "playSound not contains resPath, load");
      }
      i = this.a.load(paramString, 1);
      this.d.put(paramString, new ARPromotionSoundPlayer.ARSoundModel(this, i, 3));
    }
  }
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLoadComplete sampleId:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", status:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("ARPromotionSoundPlayer", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt2 == 0) {
      try
      {
        localObject = this.d.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          ARPromotionSoundPlayer.ARSoundModel localARSoundModel = (ARPromotionSoundPlayer.ARSoundModel)((Map.Entry)((Iterator)localObject).next()).getValue();
          if ((localARSoundModel != null) && (localARSoundModel.b == paramInt1))
          {
            if (localARSoundModel.a())
            {
              localARSoundModel.c = 2;
              return;
            }
            if (localARSoundModel.c())
            {
              if (!this.b)
              {
                localARSoundModel.a = paramSoundPool.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F);
                return;
              }
              localARSoundModel.c = 4;
              return;
            }
          }
        }
      }
      catch (Exception paramSoundPool)
      {
        paramSoundPool.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("ARPromotionSoundPlayer", 2, "onLoadComplete exception", paramSoundPool);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionSoundPlayer
 * JD-Core Version:    0.7.0.1
 */