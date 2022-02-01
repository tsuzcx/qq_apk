package com.tencent.av.opengl.multiplevideos;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.av.opengl.multiplevideos.renderbase.ImageSource;
import java.util.LinkedList;
import java.util.List;

public class MultipleTextureSource
  extends ImageSource
{
  private final String a;
  private List<Frame> b;
  
  public MultipleTextureSource()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MultipleTextureSource-");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.a = localStringBuilder.toString();
    this.b = new LinkedList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.multiplevideos.MultipleTextureSource
 * JD-Core Version:    0.7.0.1
 */