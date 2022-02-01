package com.tencent.autotemplate.model.rhythm;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.tencent.autotemplate.model.TAVEffectAutomaticEffect;
import com.tencent.autotemplate.model.TAVTransitionAutomaticEffect;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TAVRhythmEffects
{
  @SerializedName("highlightEffects")
  private List<TAVEffectAutomaticEffect> highlightEffects = new ArrayList();
  @SerializedName("rhythmEffectID")
  private String rhythmEffectID;
  @SerializedName("secondEffects")
  private List<List<TAVEffectAutomaticEffect>> secondEffects = new ArrayList();
  @SerializedName("transitions")
  private List<TAVTransitionAutomaticEffect> transitions = new ArrayList();
  
  public List<TAVEffectAutomaticEffect> getHighlightEffects()
  {
    return this.highlightEffects;
  }
  
  public String getRhythmEffectID()
  {
    return this.rhythmEffectID;
  }
  
  public List<List<TAVEffectAutomaticEffect>> getSecondEffects()
  {
    return this.secondEffects;
  }
  
  public List<TAVTransitionAutomaticEffect> getTransitions()
  {
    return this.transitions;
  }
  
  public void setFileDir(String paramString)
  {
    Iterator localIterator1;
    if (!CollectionUtil.isEmptyList(this.highlightEffects))
    {
      localIterator1 = this.highlightEffects.iterator();
      while (localIterator1.hasNext()) {
        ((TAVEffectAutomaticEffect)localIterator1.next()).setFileDir(paramString);
      }
    }
    if (!CollectionUtil.isEmptyList(this.secondEffects))
    {
      localIterator1 = this.secondEffects.iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((List)localIterator1.next()).iterator();
        while (localIterator2.hasNext()) {
          ((TAVEffectAutomaticEffect)localIterator2.next()).setFileDir(paramString);
        }
      }
    }
    if (!CollectionUtil.isEmptyList(this.transitions))
    {
      localIterator1 = this.transitions.iterator();
      while (localIterator1.hasNext()) {
        ((TAVTransitionAutomaticEffect)localIterator1.next()).setFileDir(paramString);
      }
    }
  }
  
  public void setHighlightEffects(List<TAVEffectAutomaticEffect> paramList)
  {
    this.highlightEffects = paramList;
  }
  
  public void setSecondEffects(List<List<TAVEffectAutomaticEffect>> paramList)
  {
    this.secondEffects = paramList;
  }
  
  public void setTransitions(@NonNull List<TAVTransitionAutomaticEffect> paramList)
  {
    this.transitions = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.model.rhythm.TAVRhythmEffects
 * JD-Core Version:    0.7.0.1
 */