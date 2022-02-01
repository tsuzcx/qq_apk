package com.bumptech.glide;

import android.support.annotation.NonNull;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.Preconditions;

public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType>
  implements Cloneable
{
  private TransitionFactory<? super TranscodeType> a = NoTransition.a();
  
  private CHILD c()
  {
    return this;
  }
  
  public final CHILD a()
  {
    try
    {
      TransitionOptions localTransitionOptions = (TransitionOptions)super.clone();
      return localTransitionOptions;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }
  
  @NonNull
  public final CHILD a(@NonNull TransitionFactory<? super TranscodeType> paramTransitionFactory)
  {
    this.a = ((TransitionFactory)Preconditions.a(paramTransitionFactory));
    return c();
  }
  
  final TransitionFactory<? super TranscodeType> b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.TransitionOptions
 * JD-Core Version:    0.7.0.1
 */