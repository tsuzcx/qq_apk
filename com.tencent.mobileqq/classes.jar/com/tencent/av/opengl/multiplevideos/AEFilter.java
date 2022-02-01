package com.tencent.av.opengl.multiplevideos;

import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIAttrProvider;
import com.tencent.av.opengl.multiplevideos.renderbase.Filter;

public class AEFilter
  extends Filter
{
  private final String a;
  private AIAttr b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public AEFilter()
  {
    super(1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AEFilter-");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.a = localStringBuilder.toString();
    this.b = new AIAttr(new AIAttrProvider(null));
    this.c = false;
    this.d = false;
    this.e = false;
    this.f = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.multiplevideos.AEFilter
 * JD-Core Version:    0.7.0.1
 */