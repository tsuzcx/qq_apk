package com.tencent.mobileqq.activity.aio.audiopanel;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.widget.ImageView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.dinifly.Cancellable;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class AudioTransitionAnimManager
{
  public static final String a;
  public static final String b;
  private static Map<Integer, String> e;
  private Map<String, LottieDrawable> c = new HashMap(20);
  private Set<AudioTransitionAnimManager.TransitionAnimListener> d;
  private Set<Integer> f;
  private Cancellable g;
  private boolean h = false;
  private HandlerThread i;
  private Handler j;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/Tencent/MobileQQ/pttPanelAnimations/");
    a = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/Tencent/MobileQQ/pttPanelAnimations/qq_android_ptt_transition_anim_res/");
    b = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  private AudioTransitionAnimManager()
  {
    e = new HashMap(20);
    this.d = new HashSet();
    this.f = new CopyOnWriteArraySet();
    e.put(Integer.valueOf(1), "ptt_voicechange_to_press_anim/");
    e.put(Integer.valueOf(2), "ptt_press_to_voicechange_anim/");
    e.put(Integer.valueOf(3), "ptt_press_to_record_anim/");
    e.put(Integer.valueOf(4), "ptt_record_to_press_anim/");
    e.put(Integer.valueOf(5), "ptt_record_to_stop_record_anim/");
    e.put(Integer.valueOf(201), "ptt_recordstop_to_play_anim/");
    e.put(Integer.valueOf(202), "ptt_play_to_stop_anim/");
    e.put(Integer.valueOf(203), "ptt_stop_to_play_anim/");
    e.put(Integer.valueOf(6), "ptt_record_to_voicechange_anim/");
    e.put(Integer.valueOf(7), "ptt_voicechange_to_record_anim/");
    e.put(Integer.valueOf(101), "ptt_voicechange_to_press_anim_night/");
    e.put(Integer.valueOf(102), "ptt_press_to_voicechange_anim_night/");
    e.put(Integer.valueOf(103), "ptt_press_to_record_anim_night/");
    e.put(Integer.valueOf(104), "ptt_record_to_press_anim_night/");
    e.put(Integer.valueOf(105), "ptt_record_to_stop_record_anim_night/");
    e.put(Integer.valueOf(301), "ptt_recordstop_to_play_anim_night/");
    e.put(Integer.valueOf(302), "ptt_play_to_stop_anim_night/");
    e.put(Integer.valueOf(303), "ptt_stop_to_play_anim_night/");
    e.put(Integer.valueOf(106), "ptt_record_to_voicechange_anim_night/");
    e.put(Integer.valueOf(107), "ptt_voicechange_to_record_anim_night/");
  }
  
  public static AudioTransitionAnimManager a()
  {
    return AudioTransitionAnimManager.Inner.a();
  }
  
  private void a(int paramInt, String paramString, Context paramContext)
  {
    this.j.post(new AudioTransitionAnimManager.1(this, paramString, paramContext, paramInt));
  }
  
  private void a(Animator paramAnimator, int paramInt)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      AudioTransitionAnimManager.TransitionAnimListener localTransitionAnimListener = (AudioTransitionAnimManager.TransitionAnimListener)localIterator.next();
      if (localTransitionAnimListener != null) {
        localTransitionAnimListener.a(paramAnimator, paramInt);
      }
    }
  }
  
  private void a(LottieComposition paramLottieComposition, int paramInt, String paramString, Context paramContext)
  {
    if (paramLottieComposition == null)
    {
      QLog.e("AudioTransitionAnimManager", 2, "getDrawable onCompositionLoaded lottieComposition is null or mIsDestroyed:");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AIOAudioPanel getDrawable finish type");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AudioTransitionAnimManager", 2, ((StringBuilder)localObject).toString());
    }
    this.f.remove(Integer.valueOf(paramInt));
    Object localObject = new LottieDrawable();
    paramContext = new AuidoTransitionAssetDelegate(paramContext, paramString);
    ((LottieDrawable)localObject).setComposition(paramLottieComposition);
    ((LottieDrawable)localObject).setImageAssetDelegate(paramContext);
    this.c.put(paramString, localObject);
    a((LottieDrawable)localObject, paramInt);
  }
  
  private void a(LottieDrawable paramLottieDrawable, int paramInt)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      AudioTransitionAnimManager.TransitionAnimListener localTransitionAnimListener = (AudioTransitionAnimManager.TransitionAnimListener)localIterator.next();
      if (localTransitionAnimListener != null) {
        localTransitionAnimListener.a(paramLottieDrawable, paramInt);
      }
    }
  }
  
  private void e()
  {
    if (this.i == null)
    {
      this.i = new HandlerThread("AudioTransitionAnimManager");
      this.i.start();
      this.j = new Handler(this.i.getLooper());
    }
  }
  
  private void f()
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacks(null);
      this.j = null;
    }
    localObject = this.i;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quit();
      this.i = null;
    }
  }
  
  private void g()
  {
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      LottieDrawable localLottieDrawable = (LottieDrawable)this.c.get(str);
      localLottieDrawable.cancelAnimation();
      localLottieDrawable.removeAllAnimatorListeners();
      localLottieDrawable.recycleBitmaps();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("data.json");
      localLottieDrawable.clearCompositionAndCache(localStringBuilder.toString());
      localLottieDrawable.setImageAssetDelegate(null);
    }
    this.c.clear();
  }
  
  public LottieDrawable a(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AIOAudioPanel getDrawable type");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AudioTransitionAnimManager", 2, ((StringBuilder)localObject).toString());
    }
    e();
    Object localObject = e;
    if ((localObject != null) && (((Map)localObject).containsKey(Integer.valueOf(paramInt))))
    {
      localObject = (String)e.get(Integer.valueOf(paramInt));
      if ((this.c.containsKey(localObject)) && (this.c.get(localObject) != null)) {
        return (LottieDrawable)this.c.get(localObject);
      }
      if (this.f.contains(Integer.valueOf(paramInt)))
      {
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("AIOAudioPanel getDrawable loading type");
          paramContext.append(paramInt);
          QLog.d("AudioTransitionAnimManager", 2, paramContext.toString());
        }
        return null;
      }
      this.f.add(Integer.valueOf(paramInt));
      a(paramInt, (String)localObject, paramContext);
      return null;
    }
    QLog.e("AudioTransitionAnimManager", 1, "getDrawable mResPathMap error.");
    return null;
  }
  
  public void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel preLoadRes");
    }
    if (paramContext != null)
    {
      a(paramContext, 1);
      a(paramContext, 2);
      a(paramContext, 3);
      a(paramContext, 5);
      a(paramContext, 202);
      a(paramContext, 203);
      a(paramContext, 201);
    }
  }
  
  public void a(AudioTransitionAnimManager.TransitionAnimListener paramTransitionAnimListener)
  {
    this.d.add(paramTransitionAnimListener);
  }
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AIOAudioPanel cancelAnimation drawable=");
      localStringBuilder.append(paramLottieDrawable);
      QLog.d("AudioTransitionAnimManager", 2, localStringBuilder.toString());
    }
    paramLottieDrawable.cancelAnimation();
  }
  
  public void a(LottieDrawable paramLottieDrawable, float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    if (paramFloat <= 1.0F)
    {
      if (paramFloat < 0.0F) {
        return;
      }
      float f1 = paramFloat;
      if (AudioTransitionAnimUtils.a(paramInt)) {
        f1 = 1.0F - paramFloat;
      }
      paramLottieDrawable.setProgress(f1);
    }
  }
  
  public void a(LottieDrawable paramLottieDrawable, int paramInt, ImageView paramImageView, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AIOAudioPanel playTransitionAnim   type");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" drawable=");
      localStringBuilder.append(paramLottieDrawable);
      localStringBuilder.append(" needDoPlay= ");
      localStringBuilder.append(paramBoolean);
      QLog.d("AudioTransitionAnimManager", 2, localStringBuilder.toString());
    }
    if (paramLottieDrawable != null)
    {
      if (paramImageView == null) {
        return;
      }
      paramImageView.setImageDrawable(paramLottieDrawable);
      paramLottieDrawable.removeAllAnimatorListeners();
      paramLottieDrawable.addAnimatorListener(new AudioTransitionAnimManager.2(this, paramLottieDrawable, paramInt, paramImageView));
      if (paramBoolean) {
        paramLottieDrawable.playAnimation();
      }
    }
  }
  
  public void b()
  {
    this.d.clear();
    this.f.clear();
    Cancellable localCancellable = this.g;
    if (localCancellable != null)
    {
      localCancellable.cancel();
      this.g = null;
    }
    if (this.c != null) {
      g();
    }
    f();
  }
  
  public boolean b(LottieDrawable paramLottieDrawable)
  {
    return paramLottieDrawable.isAnimating();
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public boolean d()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isFileExsit fileExsit = ");
      ((StringBuilder)localObject).append(this.h);
      QLog.d("AudioTransitionAnimManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.h) {
      return true;
    }
    Object localObject = new File(b);
    if ((((File)localObject).exists()) && (e != null) && (((File)localObject).listFiles() != null) && (((File)localObject).listFiles().length == e.size()))
    {
      this.h = true;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager
 * JD-Core Version:    0.7.0.1
 */