package com.tencent.autotemplate.model;

import android.support.annotation.NonNull;
import com.tencent.tavmovie.sticker.TAVMovieSticker;

public class TAVTransitionAutomaticEffect
  extends TAVBaseAutomaticEffect
{
  public TAVTransitionAutomaticEffect(@NonNull String paramString)
  {
    super(paramString);
  }
  
  public TAVMovieSticker convertToMovieSticker()
  {
    return new TAVMovieSticker(getFullPath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.model.TAVTransitionAutomaticEffect
 * JD-Core Version:    0.7.0.1
 */