package com.tencent.mobileqq.activity.richmedia.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.mobileqq.portal.HongbaoFilter;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;

@TargetApi(9)
public class GLSurfaceUtil
{
  public static final float[] a = { -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F };
  public static final float[] b = { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F };
  public static boolean g = false;
  public static boolean h = false;
  private static final int m = a.length * 4 + b.length * 4;
  private static final FloatBuffer n = ByteBuffer.allocateDirect(m * 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
  public int c = 0;
  public boolean d;
  public HongbaoFilter e;
  int f;
  public ByteBuffer i = null;
  public ByteBuffer j = null;
  public ByteBuffer k = null;
  public boolean l = false;
  private int[] o = new int[3];
  private int[] p = new int[1];
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private Context v;
  
  static
  {
    int i1 = n.capacity();
    n.limit(i1);
    n.position(0);
    n.put(a);
    n.put(b);
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1285)
      {
        if (paramInt != 1286)
        {
          switch (paramInt)
          {
          default: 
            return "Unknow error";
          case 1282: 
            return "GL_INVALID_OPERATION";
          case 1281: 
            return "GL_INVALID_VALUE";
          }
          return "GL_INVALID_ENUM";
        }
        return "GL_INVALID_FRAMEBUFFER_OPERATION";
      }
      return "GL_OUT_OF_MEMORY";
    }
    return "GL_NO_ERROR";
  }
  
  private void a()
  {
    GLES20.glUseProgram(this.c);
    this.q = GLES20.glGetUniformLocation(this.c, "SamplerY");
    this.r = GLES20.glGetUniformLocation(this.c, "SamplerU");
    this.s = GLES20.glGetUniformLocation(this.c, "SamplerV");
    this.t = GLES20.glGetAttribLocation(this.c, "position");
    this.u = GLES20.glGetAttribLocation(this.c, "textureCoordinateIn");
    Object localObject1;
    if (this.d)
    {
      this.e.g.put("percent1", Integer.valueOf(GLES20.glGetUniformLocation(this.c, "percent1")));
      this.e.g.put("percent2", Integer.valueOf(GLES20.glGetUniformLocation(this.c, "percent2")));
      this.e.g.put("percent3", Integer.valueOf(GLES20.glGetUniformLocation(this.c, "percent3")));
      this.e.g.put("percent4", Integer.valueOf(GLES20.glGetUniformLocation(this.c, "percent4")));
      this.e.g.put("percent5", Integer.valueOf(GLES20.glGetUniformLocation(this.c, "percent5")));
      this.e.g.put("percent6", Integer.valueOf(GLES20.glGetUniformLocation(this.c, "percent6")));
      this.e.g.put("percent7", Integer.valueOf(GLES20.glGetUniformLocation(this.c, "percent7")));
      this.e.g.put("quality", Integer.valueOf(GLES20.glGetUniformLocation(this.c, "quality")));
      this.e.g.put("add_red", Integer.valueOf(GLES20.glGetUniformLocation(this.c, "add_red")));
      this.e.g.put("red_m", Integer.valueOf(GLES20.glGetUniformLocation(this.c, "red_m")));
      this.e.g.put("green_m", Integer.valueOf(GLES20.glGetUniformLocation(this.c, "green_m")));
      this.e.g.put("blue_m", Integer.valueOf(GLES20.glGetUniformLocation(this.c, "blue_m")));
      this.e.g.put("inputImageTexture2", Integer.valueOf(GLES20.glGetUniformLocation(this.c, "inputImageTexture2")));
      localObject1 = null;
    }
    try
    {
      localObject2 = BitmapFactory.decodeResource(this.v.getResources(), 2130846744);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject2;
      label424:
      break label424;
    }
    QLog.i("GLSurfaceUtil", 2, "decode hongbao filter mask oom!");
    if (localObject1 != null)
    {
      localObject2 = new int[1];
      GLES20.glGenTextures(1, (int[])localObject2, 0);
      GLES20.glBindTexture(3553, localObject2[0]);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      GLES20.glTexParameteri(3553, 10241, 9729);
      GLES20.glTexParameteri(3553, 10240, 9729);
      GLUtils.texImage2D(3553, 0, localObject1, 0);
      this.f = localObject2[0];
      GLES20.glBindTexture(3553, 0);
    }
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLSurfaceUtil", 2, paramString);
    }
  }
  
  public static void a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    n.position(0);
    GLES20.glGenBuffers(1, paramArrayOfInt, 0);
    GLES20.glBindBuffer(34962, paramArrayOfInt[0]);
    GLES20.glBufferData(34962, m, n, 35044);
    GLES20.glVertexAttribPointer(paramInt1, 2, 5126, false, 0, 0);
    GLES20.glEnableVertexAttribArray(paramInt1);
    GLES20.glVertexAttribPointer(paramInt2, 2, 5126, false, 0, a.length * 4);
    GLES20.glEnableVertexAttribArray(paramInt2);
  }
  
  private void b()
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.o[0]);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glPixelStorei(3317, 1);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.o[1]);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glPixelStorei(3317, 1);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(3553, this.o[2]);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glPixelStorei(3317, 1);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = ImageFormat.getBitsPerPixel(paramInt1);
    float f1 = paramInt1 * 1.0F / 8.0F;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMessage:byteBufferProcessFrame:[getBufferSize]bitpixel=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" byteNum=");
    localStringBuilder.append(f1);
    a(localStringBuilder.toString());
    return (int)(paramInt2 * paramInt3 * f1);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte)
  {
    try
    {
      i1 = a(paramInt1, paramInt4, paramInt5);
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= i1)) {
        break label403;
      }
      bool1 = true;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      label403:
      for (;;)
      {
        int i1;
        boolean bool2;
        StringBuilder localStringBuilder;
        label253:
        continue;
        label317:
        boolean bool1 = false;
      }
    }
    bool2 = bool1;
    if (bool1)
    {
      bool2 = bool1;
      if (paramArrayOfByte.length == b(paramInt4, paramInt5)) {
        bool2 = false;
      }
    }
    if (bool2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMessage:byteBufferProcessFrame:[data length error]dataLenErr=");
      localStringBuilder.append(bool2);
      localStringBuilder.append(" mPreviewWidth=");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append(" mPreviewWidth");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append(" mVideoFormat=");
      localStringBuilder.append(paramInt1);
      a(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMessage:byteBufferProcessFrame:[data length error]dataLenErr=");
      localStringBuilder.append(bool2);
      localStringBuilder.append(" totalSize=");
      localStringBuilder.append(i1);
      localStringBuilder.append(" data.length=");
      localStringBuilder.append(paramArrayOfByte.length);
      a(localStringBuilder.toString());
      return -1;
    }
    if ((this.i == null) || (!this.l)) {
      h = false;
    }
    try
    {
      CameraGLSurfaceView.initTotalBufferSize(paramInt4, paramInt5, paramInt1);
      h = true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      break label253;
    }
    h = false;
    this.i = null;
    this.j = null;
    this.k = null;
    a(paramInt2, paramInt3);
    this.l = true;
    paramInt1 = CameraGLSurfaceView.processVideoFrame(paramArrayOfByte, paramInt4, paramInt5, paramInt1, paramInt6, false, this.i, this.j, this.k, g);
    break label317;
    paramInt1 = 0;
    paramArrayOfByte = this.i;
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte.position(0);
      this.j.position(0);
      this.k.position(0);
      return paramInt1;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("handleMessage:byteBufferProcessFrame:panelY=");
    paramArrayOfByte.append(this.i);
    a(paramArrayOfByte.toString());
    return paramInt1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i1 = paramInt1 * paramInt2;
    ByteBuffer localByteBuffer = this.i;
    if ((localByteBuffer == null) || (localByteBuffer.capacity() < i1)) {
      this.i = GLSurfaceUtil.GLDirectAllocate.a(0, i1);
    }
    i1 = 0 + i1;
    paramInt1 = paramInt1 / 2 * (paramInt2 / 2);
    localByteBuffer = this.j;
    if ((localByteBuffer == null) || (localByteBuffer.capacity() < paramInt1)) {
      this.j = GLSurfaceUtil.GLDirectAllocate.a(i1, paramInt1);
    }
    localByteBuffer = this.k;
    if ((localByteBuffer == null) || (localByteBuffer.capacity() < paramInt1)) {
      this.k = GLSurfaceUtil.GLDirectAllocate.a(i1 + paramInt1, paramInt1);
    }
  }
  
  public boolean a(Context paramContext)
  {
    this.v = paramContext;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    if (this.d)
    {
      this.e = new HongbaoFilter();
      this.c = GLSurfaceUtil.GLVideoHelper.a("precision highp float;\nattribute vec4 position;\nattribute vec2 textureCoordinateIn;\nvarying   vec2 texturecoordinateOut;\nvoid main()\n{\ntexturecoordinateOut = textureCoordinateIn;\ngl_Position = position;\n}\n", "precision mediump float;\nvarying   vec2 texturecoordinateOut;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerU;\nuniform sampler2D SamplerV;\nuniform float percent1;\nuniform float percent2;\nuniform float percent3;\nuniform float percent4;\nuniform float percent5;\nuniform float percent6;\nuniform float percent7;\nuniform sampler2D inputImageTexture2;\nuniform float quality;\nuniform float add_red;\nuniform float red_m;\nuniform float green_m;\nuniform float blue_m;\nfloat percent_value(float min_percent, float percent)\n{\nfloat result_percent = 0.0;\nif(percent > 0.0)\nresult_percent = min(min_percent, percent);\nelse\nresult_percent = max(min_percent - 1.0, percent);\nreturn result_percent;\n}\nvoid main()\n{\nvec3 yuv;\nvec3 rgb;\nvec4 rgba;\nyuv.x = texture2D(SamplerY, texturecoordinateOut).r;\nyuv.y = texture2D(SamplerU, texturecoordinateOut).r-0.5;\nyuv.z = texture2D(SamplerV, texturecoordinateOut).r-0.5;\nrgb = mat3(      1,       1,      1,\n0,         -.34414, 1.772,\n1.402,     -.71414, 0) * yuv;\nfloat r = rgb.r;\nfloat g = rgb.g;\nfloat b = rgb.b;\nfloat max_c = max(r, max(g, b));\nfloat min_c = min(r, min(g, b));\nfloat median = r + g + b - max_c - min_c;\nfloat amount = max_c - median;\nfloat amount2 = median - min_c;\nfloat min_percent_r = 1.0 - r;\nfloat min_percent_g = 1.0 - g;\nfloat min_percent_b = 1.0 - b;\nfloat p;\nfloat gray = dot(rgb, vec3(0.299, 0.587, 0.114));\nfloat tmp_r = r;\nfloat tmp_g = g;\nfloat tmp_b = b;\nif(tmp_r == max_c) //red\n{\nfloat tmp_percent7 = percent7 * (1.0 - gray);\np = percent_value(min_percent_r, percent1 + tmp_percent7);\nr = r + amount * p;\np = percent_value(min_percent_g, percent4 + tmp_percent7);\ng = g + amount * p;\np = percent_value(min_percent_b, percent6 + tmp_percent7);\nb = b + amount * p;\n}\nif(tmp_b == max_c) //blue\n{\np = percent_value(min_percent_r, percent3);\nr = r + amount * p;\n}\nif(tmp_b == min_c) //yellow\n{\np = percent_value(min_percent_b, percent2);\nb = b + amount2 * p;\np = percent_value(min_percent_g, percent5);\ng = g + amount2 * p;\n}\nlowp vec4 color;\ncolor = vec4(r, g, b, 1.0);\ncolor *= quality;\nlowp vec4 newColor;\nnewColor = color;\nif(newColor.r > newColor.g && newColor.r > newColor.b)\n{\nnewColor.r *= 1.0 - red_m * add_red;\nnewColor.g *= 1.0 - green_m * add_red;\nnewColor.b *= 1.0 - blue_m * add_red;\n}\nnewColor.r = texture2D(inputImageTexture2, vec2(newColor.r,0.5)).r;\nnewColor.g = texture2D(inputImageTexture2, vec2(newColor.g,0.5)).g;\nnewColor.b = texture2D(inputImageTexture2, vec2(newColor.b,0.5)).b;\nnewColor.a = 1.0;\ngl_FragColor = newColor;\n}\n");
    }
    else
    {
      this.c = GLSurfaceUtil.GLVideoHelper.a();
    }
    if (this.c == 0)
    {
      paramContext = new StringBuilder();
      paramContext.append("GLVideoHelper.createShaderProgram: mGLProgram=");
      paramContext.append(this.c);
      CameraGLSurfaceView.a(paramContext.toString());
      return false;
    }
    a();
    a(this.p, this.t, this.u);
    paramContext = this.o;
    GLES20.glGenTextures(paramContext.length, paramContext, 0);
    b();
    return true;
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3)
  {
    GLES20.glActiveTexture(33984);
    if (!paramBoolean) {
      GLES20.glTexImage2D(3553, 0, 6409, paramInt1, paramInt2, 0, 6409, 5121, null);
    }
    GLES20.glTexSubImage2D(3553, 0, 0, 0, paramInt1, paramInt2, 6409, 5121, paramByteBuffer1);
    GLES20.glUniform1i(this.q, 0);
    GLES20.glActiveTexture(33985);
    if (!paramBoolean) {
      GLES20.glTexImage2D(3553, 0, 6409, paramInt1 / 2, paramInt2 / 2, 0, 6409, 5121, null);
    }
    paramInt1 /= 2;
    paramInt2 /= 2;
    GLES20.glTexSubImage2D(3553, 0, 0, 0, paramInt1, paramInt2, 6409, 5121, paramByteBuffer2);
    int i1 = this.r;
    boolean bool = true;
    GLES20.glUniform1i(i1, 1);
    GLES20.glActiveTexture(33986);
    if (!paramBoolean)
    {
      GLES20.glTexImage2D(3553, 0, 6409, paramInt1, paramInt2, 0, 6409, 5121, null);
      paramBoolean = bool;
    }
    GLES20.glTexSubImage2D(3553, 0, 0, 0, paramInt1, paramInt2, 6409, 5121, paramByteBuffer3);
    GLES20.glUniform1i(this.s, 2);
    if (this.d)
    {
      this.e.a(HongbaoFilter.f);
      GLES20.glActiveTexture(33987);
      GLES20.glBindTexture(3553, this.f);
      GLES20.glUniform1i(GLES20.glGetUniformLocation(this.c, "inputImageTexture2"), 3);
    }
    GLES20.glDrawArrays(6, 0, 4);
    paramInt1 = GLES20.glGetError();
    if (paramInt1 != 0)
    {
      paramByteBuffer1 = new StringBuilder();
      paramByteBuffer1.append("glDrawFrame:err=");
      paramByteBuffer1.append(paramInt1);
      paramByteBuffer1.append(" errname=");
      paramByteBuffer1.append(a(paramInt1));
      a(paramByteBuffer1.toString());
    }
    return paramBoolean;
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    return paramInt1 * paramInt2 * 3 / 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.GLSurfaceUtil
 * JD-Core Version:    0.7.0.1
 */