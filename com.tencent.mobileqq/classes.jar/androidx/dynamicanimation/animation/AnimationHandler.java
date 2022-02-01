package androidx.dynamicanimation.animation;

import android.os.Build.VERSION;
import android.os.SystemClock;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

class AnimationHandler
{
  public static final ThreadLocal<AnimationHandler> a;
  long jdField_a_of_type_Long = 0L;
  private final SimpleArrayMap<AnimationHandler.AnimationFrameCallback, Long> jdField_a_of_type_AndroidxCollectionSimpleArrayMap = new SimpleArrayMap();
  private final AnimationHandler.AnimationCallbackDispatcher jdField_a_of_type_AndroidxDynamicanimationAnimationAnimationHandler$AnimationCallbackDispatcher = new AnimationHandler.AnimationCallbackDispatcher(this);
  private AnimationHandler.AnimationFrameCallbackProvider jdField_a_of_type_AndroidxDynamicanimationAnimationAnimationHandler$AnimationFrameCallbackProvider;
  final ArrayList<AnimationHandler.AnimationFrameCallback> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangThreadLocal = new ThreadLocal();
  }
  
  public static AnimationHandler a()
  {
    if (jdField_a_of_type_JavaLangThreadLocal.get() == null) {
      jdField_a_of_type_JavaLangThreadLocal.set(new AnimationHandler());
    }
    return (AnimationHandler)jdField_a_of_type_JavaLangThreadLocal.get();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      while (i >= 0)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.get(i) == null) {
          this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        }
        i -= 1;
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private boolean a(AnimationHandler.AnimationFrameCallback paramAnimationFrameCallback, long paramLong)
  {
    Long localLong = (Long)this.jdField_a_of_type_AndroidxCollectionSimpleArrayMap.get(paramAnimationFrameCallback);
    if (localLong == null) {
      return true;
    }
    if (localLong.longValue() < paramLong)
    {
      this.jdField_a_of_type_AndroidxCollectionSimpleArrayMap.remove(paramAnimationFrameCallback);
      return true;
    }
    return false;
  }
  
  AnimationHandler.AnimationFrameCallbackProvider a()
  {
    if (this.jdField_a_of_type_AndroidxDynamicanimationAnimationAnimationHandler$AnimationFrameCallbackProvider == null) {
      if (Build.VERSION.SDK_INT < 16) {
        break label35;
      }
    }
    label35:
    for (this.jdField_a_of_type_AndroidxDynamicanimationAnimationAnimationHandler$AnimationFrameCallbackProvider = new AnimationHandler.FrameCallbackProvider16(this.jdField_a_of_type_AndroidxDynamicanimationAnimationAnimationHandler$AnimationCallbackDispatcher);; this.jdField_a_of_type_AndroidxDynamicanimationAnimationAnimationHandler$AnimationFrameCallbackProvider = new AnimationHandler.FrameCallbackProvider14(this.jdField_a_of_type_AndroidxDynamicanimationAnimationAnimationHandler$AnimationCallbackDispatcher)) {
      return this.jdField_a_of_type_AndroidxDynamicanimationAnimationAnimationHandler$AnimationFrameCallbackProvider;
    }
  }
  
  void a(long paramLong)
  {
    long l = SystemClock.uptimeMillis();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      AnimationHandler.AnimationFrameCallback localAnimationFrameCallback = (AnimationHandler.AnimationFrameCallback)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localAnimationFrameCallback == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (a(localAnimationFrameCallback, l)) {
          localAnimationFrameCallback.a(paramLong);
        }
      }
    }
    a();
  }
  
  public void a(AnimationHandler.AnimationFrameCallback paramAnimationFrameCallback)
  {
    this.jdField_a_of_type_AndroidxCollectionSimpleArrayMap.remove(paramAnimationFrameCallback);
    int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramAnimationFrameCallback);
    if (i >= 0)
    {
      this.jdField_a_of_type_JavaUtilArrayList.set(i, null);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(AnimationHandler.AnimationFrameCallback paramAnimationFrameCallback, long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      a().a();
    }
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramAnimationFrameCallback)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramAnimationFrameCallback);
    }
    if (paramLong > 0L) {
      this.jdField_a_of_type_AndroidxCollectionSimpleArrayMap.put(paramAnimationFrameCallback, Long.valueOf(SystemClock.uptimeMillis() + paramLong));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.dynamicanimation.animation.AnimationHandler
 * JD-Core Version:    0.7.0.1
 */