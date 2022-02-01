package com.tencent.aelight.camera.aioeditor.activity.richmedia.view;

import android.annotation.TargetApi;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@TargetApi(9)
public class GLSurfaceUtil
{
  public static final float[] a = { -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F };
  public static final float[] b = { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F };
  public static boolean d = false;
  private static final int e = a.length * 4 + b.length * 4;
  private static final FloatBuffer f = ByteBuffer.allocateDirect(e * 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
  public int c = 0;
  private int[] g = new int[3];
  private int[] h = new int[1];
  
  static
  {
    int i = f.capacity();
    f.limit(i);
    f.position(0);
    f.put(a);
    f.put(b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.view.GLSurfaceUtil
 * JD-Core Version:    0.7.0.1
 */