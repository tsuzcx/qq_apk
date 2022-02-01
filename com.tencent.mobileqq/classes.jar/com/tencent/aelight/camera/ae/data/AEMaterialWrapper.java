package com.tencent.aelight.camera.ae.data;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;

public class AEMaterialWrapper
{
  public String a;
  public MetaMaterial b;
  public String c;
  public String d;
  public boolean e;
  public int f;
  public int g;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AEMaterialWrapper{id='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", material=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", state=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEMaterialWrapper
 * JD-Core Version:    0.7.0.1
 */