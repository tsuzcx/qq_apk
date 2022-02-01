package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import androidx.annotation.NonNull;

public abstract interface Animatable2Compat
  extends Animatable
{
  public abstract void clearAnimationCallbacks();
  
  public abstract void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback paramAnimationCallback);
  
  public abstract boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback paramAnimationCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.vectordrawable.graphics.drawable.Animatable2Compat
 * JD-Core Version:    0.7.0.1
 */