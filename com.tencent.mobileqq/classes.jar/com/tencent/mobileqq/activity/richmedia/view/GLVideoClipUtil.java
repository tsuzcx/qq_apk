package com.tencent.mobileqq.activity.richmedia.view;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public class GLVideoClipUtil
{
  public static String a = "precision mediump float;varying vec2 texturecoordinateOut;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerUV;\nuniform float blackField;\nuniform float whiteField;\nuniform float nightMode;\nvoid main()\n{\nvec3 yuv;\nvec3 rgb;\nvec4 rgba;\nfloat fieldWidth;\nyuv.x = texture2D(SamplerY, texturecoordinateOut).r;\nyuv.zy= texture2D(SamplerUV,texturecoordinateOut).ra-vec2(0.5, 0.5);\nrgb = mat3(      1,       1,      1,\n0,         -.34414, 1.772,\n1.402,     -.71414, 0) * yuv;\nfieldWidth = whiteField - blackField;\nif (nightMode > 0.0) {\nrgb.r *= 255.0;\nrgb.r -= blackField;\nrgb.r /= fieldWidth;\nrgb.g *= 255.0;\nrgb.g -= blackField;\nrgb.g /= fieldWidth;\nrgb.b *= 255.0;\nrgb.b -= blackField;\nrgb.b /= fieldWidth;\nrgb.r = min(1.0, max(0.0, rgb.r));\nrgb.g = min(1.0, max(0.0, rgb.g));\nrgb.b = min(1.0, max(0.0, rgb.b));\n}\nrgba = vec4(rgb, 1);\ngl_FragColor = rgba;\n}\n";
  private static final FloatBuffer jdField_a_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(jdField_c_of_type_Int).order(ByteOrder.nativeOrder()).asFloatBuffer();
  private static final float[] jdField_a_of_type_ArrayOfFloat = { -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F };
  private static float[] jdField_b_of_type_ArrayOfFloat = { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F };
  private static final int jdField_c_of_type_Int = jdField_a_of_type_ArrayOfFloat.length * 4 + jdField_b_of_type_ArrayOfFloat.length * 4;
  private static int f = -1;
  public int a;
  private GLVideoClipUtil.DataSizeErr jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLVideoClipUtil$DataSizeErr = new GLVideoClipUtil.DataSizeErr(this, null);
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer = new ByteBuffer[2];
  public int b;
  private int[] jdField_b_of_type_ArrayOfInt = new int[2];
  private float[] jdField_c_of_type_ArrayOfFloat = new float[16];
  private final int[] jdField_c_of_type_ArrayOfInt = new int[256];
  private int d = 125;
  private final int e = 256;
  
  public GLVideoClipUtil()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
  }
  
  private native int allocNativeMemory(int paramInt1, int paramInt2, int paramInt3, ByteBuffer[] paramArrayOfByteBuffer);
  
  private native int getNativeSize();
  
  private native int initClipSpec(int paramInt1, int paramInt2);
  
  public native int memoryCopy(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil
 * JD-Core Version:    0.7.0.1
 */