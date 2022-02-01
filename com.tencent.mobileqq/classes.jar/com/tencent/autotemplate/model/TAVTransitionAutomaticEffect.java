package com.tencent.autotemplate.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TAVTransitionAutomaticEffect
  extends TAVBaseAutomaticEffect
{
  @SerializedName("subTransitions")
  public List<TAVTransitionAutomaticEffect> subTransitions;
  
  public TAVTransitionAutomaticEffect(@NonNull String paramString)
  {
    super(paramString);
  }
  
  public List<TAVTransitionAutomaticEffect> getSubTransitions()
  {
    return this.subTransitions;
  }
  
  public boolean isFaceTransition()
  {
    return TextUtils.equals(this.parameter.type, "GradientFace");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.model.TAVTransitionAutomaticEffect
 * JD-Core Version:    0.7.0.1
 */