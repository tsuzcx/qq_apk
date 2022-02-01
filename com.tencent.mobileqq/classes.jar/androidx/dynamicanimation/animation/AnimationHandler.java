package androidx.dynamicanimation.animation;

import android.os.Build.VERSION;
import android.os.SystemClock;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

class AnimationHandler
{
  private static final long FRAME_DELAY_MS = 10L;
  public static final ThreadLocal<AnimationHandler> sAnimatorHandler = new ThreadLocal();
  final ArrayList<AnimationHandler.AnimationFrameCallback> mAnimationCallbacks = new ArrayList();
  private final AnimationHandler.AnimationCallbackDispatcher mCallbackDispatcher = new AnimationHandler.AnimationCallbackDispatcher(this);
  long mCurrentFrameTime = 0L;
  private final SimpleArrayMap<AnimationHandler.AnimationFrameCallback, Long> mDelayedCallbackStartTime = new SimpleArrayMap();
  private boolean mListDirty = false;
  private AnimationHandler.AnimationFrameCallbackProvider mProvider;
  
  private void cleanUpList()
  {
    if (this.mListDirty)
    {
      int i = this.mAnimationCallbacks.size() - 1;
      while (i >= 0)
      {
        if (this.mAnimationCallbacks.get(i) == null) {
          this.mAnimationCallbacks.remove(i);
        }
        i -= 1;
      }
      this.mListDirty = false;
    }
  }
  
  public static long getFrameTime()
  {
    if (sAnimatorHandler.get() == null) {
      return 0L;
    }
    return ((AnimationHandler)sAnimatorHandler.get()).mCurrentFrameTime;
  }
  
  public static AnimationHandler getInstance()
  {
    if (sAnimatorHandler.get() == null) {
      sAnimatorHandler.set(new AnimationHandler());
    }
    return (AnimationHandler)sAnimatorHandler.get();
  }
  
  private boolean isCallbackDue(AnimationHandler.AnimationFrameCallback paramAnimationFrameCallback, long paramLong)
  {
    Long localLong = (Long)this.mDelayedCallbackStartTime.get(paramAnimationFrameCallback);
    if (localLong == null) {
      return true;
    }
    if (localLong.longValue() < paramLong)
    {
      this.mDelayedCallbackStartTime.remove(paramAnimationFrameCallback);
      return true;
    }
    return false;
  }
  
  public void addAnimationFrameCallback(AnimationHandler.AnimationFrameCallback paramAnimationFrameCallback, long paramLong)
  {
    if (this.mAnimationCallbacks.size() == 0) {
      getProvider().postFrameCallback();
    }
    if (!this.mAnimationCallbacks.contains(paramAnimationFrameCallback)) {
      this.mAnimationCallbacks.add(paramAnimationFrameCallback);
    }
    if (paramLong > 0L) {
      this.mDelayedCallbackStartTime.put(paramAnimationFrameCallback, Long.valueOf(SystemClock.uptimeMillis() + paramLong));
    }
  }
  
  void doAnimationFrame(long paramLong)
  {
    long l = SystemClock.uptimeMillis();
    int i = 0;
    while (i < this.mAnimationCallbacks.size())
    {
      AnimationHandler.AnimationFrameCallback localAnimationFrameCallback = (AnimationHandler.AnimationFrameCallback)this.mAnimationCallbacks.get(i);
      if ((localAnimationFrameCallback != null) && (isCallbackDue(localAnimationFrameCallback, l))) {
        localAnimationFrameCallback.doAnimationFrame(paramLong);
      }
      i += 1;
    }
    cleanUpList();
  }
  
  AnimationHandler.AnimationFrameCallbackProvider getProvider()
  {
    if (this.mProvider == null) {
      if (Build.VERSION.SDK_INT >= 16) {
        this.mProvider = new AnimationHandler.FrameCallbackProvider16(this.mCallbackDispatcher);
      } else {
        this.mProvider = new AnimationHandler.FrameCallbackProvider14(this.mCallbackDispatcher);
      }
    }
    return this.mProvider;
  }
  
  public void removeCallback(AnimationHandler.AnimationFrameCallback paramAnimationFrameCallback)
  {
    this.mDelayedCallbackStartTime.remove(paramAnimationFrameCallback);
    int i = this.mAnimationCallbacks.indexOf(paramAnimationFrameCallback);
    if (i >= 0)
    {
      this.mAnimationCallbacks.set(i, null);
      this.mListDirty = true;
    }
  }
  
  public void setProvider(AnimationHandler.AnimationFrameCallbackProvider paramAnimationFrameCallbackProvider)
  {
    this.mProvider = paramAnimationFrameCallbackProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.AnimationHandler
 * JD-Core Version:    0.7.0.1
 */