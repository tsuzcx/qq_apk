package com.tencent.aelight.camera.aioeditor.activity.richmedia.view;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public class GLVideoClipUtil
{
  public static String a = "precision mediump float;varying vec2 texturecoordinateOut;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerUV;\nuniform float blackField;\nuniform float whiteField;\nuniform float nightMode;\nvoid main()\n{\nvec3 yuv;\nvec3 rgb;\nvec4 rgba;\nfloat fieldWidth;\nyuv.x = texture2D(SamplerY, texturecoordinateOut).r;\nyuv.zy= texture2D(SamplerUV,texturecoordinateOut).ra-vec2(0.5, 0.5);\nrgb = mat3(      1,       1,      1,\n0,         -.34414, 1.772,\n1.402,     -.71414, 0) * yuv;\nfieldWidth = whiteField - blackField;\nif (nightMode > 0.0) {\nrgb.r *= 255.0;\nrgb.r -= blackField;\nrgb.r /= fieldWidth;\nrgb.g *= 255.0;\nrgb.g -= blackField;\nrgb.g /= fieldWidth;\nrgb.b *= 255.0;\nrgb.b -= blackField;\nrgb.b /= fieldWidth;\nrgb.r = min(1.0, max(0.0, rgb.r));\nrgb.g = min(1.0, max(0.0, rgb.g));\nrgb.b = min(1.0, max(0.0, rgb.b));\n}\nrgba = vec4(rgb, 1);\ngl_FragColor = rgba;\n}\n";
  private static final float[] d = { -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F };
  private static float[] e = { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F };
  private static final int f = d.length * 4 + e.length * 4;
  private static final FloatBuffer g = ByteBuffer.allocateDirect(f).order(ByteOrder.nativeOrder()).asFloatBuffer();
  private static int n = -1;
  public int b = 0;
  public int c = 0;
  private int[] h = new int[1];
  private int[] i = new int[2];
  private float[] j = new float[16];
  private int k = 125;
  private final int l = 256;
  private final int[] m = new int[256];
  private GLVideoClipUtil.DataSizeErr o = new GLVideoClipUtil.DataSizeErr(this, null);
  private ByteBuffer[] p = new ByteBuffer[2];
  private AtomicBoolean q = new AtomicBoolean(false);
  
  public static boolean a()
  {
    return n > 0;
  }
  
  private native int allocNativeMemory(int paramInt1, int paramInt2, int paramInt3, ByteBuffer[] paramArrayOfByteBuffer);
  
  private native int getNativeSize();
  
  private native int initClipSpec(int paramInt1, int paramInt2);
  
  public native int memoryCopy(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.view.GLVideoClipUtil
 * JD-Core Version:    0.7.0.1
 */