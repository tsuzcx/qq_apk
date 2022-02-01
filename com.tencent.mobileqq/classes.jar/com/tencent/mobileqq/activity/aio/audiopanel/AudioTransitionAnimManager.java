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
  private static Map<Integer, String> jdField_b_of_type_JavaUtilMap;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private Cancellable jdField_a_of_type_ComTencentMobileqqDiniflyCancellable;
  private Map<String, LottieDrawable> jdField_a_of_type_JavaUtilMap = new HashMap(20);
  private Set<AudioTransitionAnimManager.TransitionAnimListener> jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean = false;
  private Set<Integer> jdField_b_of_type_JavaUtilSet;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/Tencent/MobileQQ/pttPanelAnimations/");
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/Tencent/MobileQQ/pttPanelAnimations/qq_android_ptt_transition_anim_res/");
    jdField_b_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  private AudioTransitionAnimManager()
  {
    jdField_b_of_type_JavaUtilMap = new HashMap(20);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new CopyOnWriteArraySet();
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(1), "ptt_voicechange_to_press_anim/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(2), "ptt_press_to_voicechange_anim/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(3), "ptt_press_to_record_anim/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(4), "ptt_record_to_press_anim/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(5), "ptt_record_to_stop_record_anim/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(201), "ptt_recordstop_to_play_anim/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(202), "ptt_play_to_stop_anim/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(203), "ptt_stop_to_play_anim/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(6), "ptt_record_to_voicechange_anim/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(7), "ptt_voicechange_to_record_anim/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(101), "ptt_voicechange_to_press_anim_night/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(102), "ptt_press_to_voicechange_anim_night/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(103), "ptt_press_to_record_anim_night/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(104), "ptt_record_to_press_anim_night/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(105), "ptt_record_to_stop_record_anim_night/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(301), "ptt_recordstop_to_play_anim_night/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(302), "ptt_play_to_stop_anim_night/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(303), "ptt_stop_to_play_anim_night/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(106), "ptt_record_to_voicechange_anim_night/");
    jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(107), "ptt_voicechange_to_record_anim_night/");
  }
  
  public static AudioTransitionAnimManager a()
  {
    return AudioTransitionAnimManager.Inner.a();
  }
  
  private void a(int paramInt, String paramString, Context paramContext)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AudioTransitionAnimManager.1(this, paramString, paramContext, paramInt));
  }
  
  private void a(Animator paramAnimator, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
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
    this.jdField_b_of_type_JavaUtilSet.remove(Integer.valueOf(paramInt));
    Object localObject = new LottieDrawable();
    paramContext = new AuidoTransitionAssetDelegate(paramContext, paramString);
    ((LottieDrawable)localObject).setComposition(paramLottieComposition);
    ((LottieDrawable)localObject).setImageAssetDelegate(paramContext);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
    a((LottieDrawable)localObject, paramInt);
  }
  
  private void a(LottieDrawable paramLottieDrawable, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      AudioTransitionAnimManager.TransitionAnimListener localTransitionAnimListener = (AudioTransitionAnimManager.TransitionAnimListener)localIterator.next();
      if (localTransitionAnimListener != null) {
        localTransitionAnimListener.a(paramLottieDrawable, paramInt);
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("AudioTransitionAnimManager");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    }
  }
  
  private void c()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacks(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    localObject = this.jdField_a_of_type_AndroidOsHandlerThread;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      LottieDrawable localLottieDrawable = (LottieDrawable)this.jdField_a_of_type_JavaUtilMap.get(str);
      localLottieDrawable.cancelAnimation();
      localLottieDrawable.removeAllAnimatorListeners();
      localLottieDrawable.recycleBitmaps();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("data.json");
      localLottieDrawable.clearCompositionAndCache(localStringBuilder.toString());
      localLottieDrawable.setImageAssetDelegate(null);
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
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
    b();
    Object localObject = jdField_b_of_type_JavaUtilMap;
    if ((localObject != null) && (((Map)localObject).containsKey(Integer.valueOf(paramInt))))
    {
      localObject = (String)jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if ((this.jdField_a_of_type_JavaUtilMap.containsKey(localObject)) && (this.jdField_a_of_type_JavaUtilMap.get(localObject) != null)) {
        return (LottieDrawable)this.jdField_a_of_type_JavaUtilMap.get(localObject);
      }
      if (this.jdField_b_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt)))
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
      this.jdField_b_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
      a(paramInt, (String)localObject, paramContext);
      return null;
    }
    QLog.e("AudioTransitionAnimManager", 1, "getDrawable mResPathMap error.");
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet.clear();
    Cancellable localCancellable = this.jdField_a_of_type_ComTencentMobileqqDiniflyCancellable;
    if (localCancellable != null)
    {
      localCancellable.cancel();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyCancellable = null;
    }
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      d();
    }
    c();
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
    this.jdField_a_of_type_JavaUtilSet.add(paramTransitionAnimListener);
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
      float f = paramFloat;
      if (AudioTransitionAnimUtils.a(paramInt)) {
        f = 1.0F - paramFloat;
      }
      paramLottieDrawable.setProgress(f);
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
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(LottieDrawable paramLottieDrawable)
  {
    return paramLottieDrawable.isAnimating();
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isFileExsit fileExsit = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.d("AudioTransitionAnimManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    Object localObject = new File(jdField_b_of_type_JavaLangString);
    if ((((File)localObject).exists()) && (jdField_b_of_type_JavaUtilMap != null) && (((File)localObject).listFiles() != null) && (((File)localObject).listFiles().length == jdField_b_of_type_JavaUtilMap.size()))
    {
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager
 * JD-Core Version:    0.7.0.1
 */