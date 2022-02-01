package com.tencent.aelight.camera.aioeditor.activity.richmedia.view;

import android.annotation.TargetApi;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@TargetApi(9)
public class GLSurfaceUtil
{
  private static final FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  public static boolean a;
  public static final float[] a;
  private static final int jdField_b_of_type_Int;
  public static final float[] b;
  public int a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private int[] jdField_b_of_type_ArrayOfInt = new int[1];
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F };
    jdField_b_of_type_ArrayOfFloat = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F };
    jdField_b_of_type_Int = jdField_a_of_type_ArrayOfFloat.length * 4 + jdField_b_of_type_ArrayOfFloat.length * 4;
    jdField_a_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(jdField_b_of_type_Int * 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
    int i = jdField_a_of_type_JavaNioFloatBuffer.capacity();
    jdField_a_of_type_JavaNioFloatBuffer.limit(i);
    jdField_a_of_type_JavaNioFloatBuffer.position(0);
    jdField_a_of_type_JavaNioFloatBuffer.put(jdField_a_of_type_ArrayOfFloat);
    jdField_a_of_type_JavaNioFloatBuffer.put(jdField_b_of_type_ArrayOfFloat);
    jdField_a_of_type_Boolean = false;
  }
  
  public GLSurfaceUtil()
  {
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.view.GLSurfaceUtil
 * JD-Core Version:    0.7.0.1
 */