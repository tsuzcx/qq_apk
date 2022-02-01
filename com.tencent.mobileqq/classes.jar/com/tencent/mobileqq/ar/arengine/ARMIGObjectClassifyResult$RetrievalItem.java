package com.tencent.mobileqq.ar.arengine;

public class ARMIGObjectClassifyResult$RetrievalItem
{
  public int a;
  public String b;
  public double c;
  public String d;
  public ARMIGObjectClassifyResult.LabelSource e;
  public int f;
  public String g;
  public String h;
  public String i;
  public String j;
  public byte[] k;
  public boolean l = false;
  public boolean m = false;
  public int n = 0;
  public String o = "";
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result:{sclass:");
    Object localObject = this.b;
    String str = "";
    if (localObject == null) {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(",");
    localStringBuilder.append("sItemId:");
    localObject = this.e;
    if (localObject != null) {
      localObject = ((ARMIGObjectClassifyResult.LabelSource)localObject).a;
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(",");
    localStringBuilder.append("dProb:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append("sTitle:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(",");
    localStringBuilder.append("sWiki:");
    localStringBuilder.append(this.i);
    localStringBuilder.append(",");
    localStringBuilder.append("sJumpUrl:");
    localStringBuilder.append(this.j);
    localStringBuilder.append(",");
    localStringBuilder.append("sCdbRes:");
    byte[] arrayOfByte = this.k;
    localObject = str;
    if (arrayOfByte != null) {
      localObject = new String(arrayOfByte);
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(",");
    localStringBuilder.append("isAutoJump:");
    localStringBuilder.append(this.l);
    localStringBuilder.append(",");
    localStringBuilder.append("iNeedCheckLBS:");
    localStringBuilder.append(this.n);
    localStringBuilder.append(",");
    localStringBuilder.append("imageId:");
    localStringBuilder.append(this.o);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.RetrievalItem
 * JD-Core Version:    0.7.0.1
 */