package com.tencent.aelight.camera.aeeditor.module.filter;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/aeeditor/module/filter/EffectType;", "", "(Ljava/lang/String;I)V", "NON", "AI", "CLIENT", "NETWORK", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public enum EffectType
{
  static
  {
    EffectType localEffectType1 = new EffectType("NON", 0);
    NON = localEffectType1;
    EffectType localEffectType2 = new EffectType("AI", 1);
    AI = localEffectType2;
    EffectType localEffectType3 = new EffectType("CLIENT", 2);
    CLIENT = localEffectType3;
    EffectType localEffectType4 = new EffectType("NETWORK", 3);
    NETWORK = localEffectType4;
    $VALUES = new EffectType[] { localEffectType1, localEffectType2, localEffectType3, localEffectType4 };
  }
  
  private EffectType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.filter.EffectType
 * JD-Core Version:    0.7.0.1
 */