package com.tencent.av.opengl.multiplevideos.renderbase;

import android.util.Pair;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public abstract class Filter
  extends RenderObject
{
  private String a;
  private List<Pair<Filter, Integer>> b;
  private Vector<RefFrame> c;
  private boolean d;
  
  public Filter(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("-");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.a = localStringBuilder.toString();
    this.b = new LinkedList();
    this.d = false;
    this.c = new Vector(paramInt);
    this.c.setSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.multiplevideos.renderbase.Filter
 * JD-Core Version:    0.7.0.1
 */