package com.tencent.autotemplate;

import com.tencent.autotemplate.model.rhythm.TAVEffectPoint;
import java.util.Comparator;

class TAVRhythmAutomaticTemplate$1
  implements Comparator<TAVEffectPoint>
{
  TAVRhythmAutomaticTemplate$1(TAVRhythmAutomaticTemplate paramTAVRhythmAutomaticTemplate) {}
  
  public int compare(TAVEffectPoint paramTAVEffectPoint1, TAVEffectPoint paramTAVEffectPoint2)
  {
    return (int)(paramTAVEffectPoint1.getTime() - paramTAVEffectPoint2.getTime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.TAVRhythmAutomaticTemplate.1
 * JD-Core Version:    0.7.0.1
 */