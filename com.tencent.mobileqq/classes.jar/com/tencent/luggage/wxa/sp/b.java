package com.tencent.luggage.wxa.sp;

import android.opengl.GLES20;
import com.tencent.luggage.wxa.f.f;
import com.tencent.luggage.wxa.sq.a;
import com.tencent.luggage.wxa.sq.a.a;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/wmpf/samelayer/recordview/proc/GLTextureRenderProcYuvToRgb;", "Lcom/tencent/wmpf/samelayer/recordview/proc/LuggageCameraGLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributeYUVPosition", "attributeYUVTextureCoord", "frame", "", "uniformUVTexture", "uniformYTexture", "uniformYUVRotateMatrix", "uvBuffer", "Ljava/nio/ByteBuffer;", "uvTextureObj", "Lcom/tencent/wmpf/samelayer/recordview/globject/LuggageGLTextureObject;", "yBuffer", "yTextureObj", "yuvProgramId", "getFrame", "release", "", "renderImpl", "setFrame", "Companion", "luggage-camera_release"}, k=1, mv={1, 1, 16})
public class b
  extends c
{
  public static final b.a a = new b.a(null);
  @NotNull
  private static final String n = "MicroMsg.GLTextureRenderProcYuvToRgb";
  private com.tencent.luggage.wxa.so.c c;
  private com.tencent.luggage.wxa.so.c d;
  private int e = a.d.a("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D uv_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           u = texture2D(uv_texture, v_texCoord).a;\n           v = texture2D(uv_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private ByteBuffer k;
  private ByteBuffer l;
  private byte[] m = new byte[0];
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    if (this.e == 0) {
      f.d(n, "checkInit, load program failed!");
    }
    this.g = GLES20.glGetAttribLocation(this.e, "a_position");
    this.f = GLES20.glGetAttribLocation(this.e, "a_texCoord");
    this.h = GLES20.glGetUniformLocation(this.e, "y_texture");
    this.i = GLES20.glGetUniformLocation(this.e, "uv_texture");
    this.j = GLES20.glGetUniformLocation(this.e, "uMatrix");
    this.c = com.tencent.luggage.wxa.so.b.a(true, 5L);
    this.d = com.tencent.luggage.wxa.so.b.a(true, 5L);
  }
  
  protected void a()
  {
    if ((this.e != 0) && (m() > 0) && (n() > 0))
    {
      int i1;
      if (this.m.length == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((i1 ^ 0x1) != 0)
      {
        ByteBuffer localByteBuffer = this.k;
        if ((localByteBuffer != null) && (this.l != null))
        {
          if (localByteBuffer == null) {
            Intrinsics.throwNpe();
          }
          if (localByteBuffer.capacity() == k() * l())
          {
            localByteBuffer = this.l;
            if (localByteBuffer == null) {
              Intrinsics.throwNpe();
            }
            if (localByteBuffer.capacity() == k() * l() / 2) {
              break label185;
            }
          }
        }
        this.k = ByteBuffer.allocateDirect(k() * l());
        this.l = ByteBuffer.allocateDirect(k() * l() / 2);
        localByteBuffer = this.k;
        if (localByteBuffer == null) {
          Intrinsics.throwNpe();
        }
        localByteBuffer.order(ByteOrder.nativeOrder());
        localByteBuffer = this.l;
        if (localByteBuffer == null) {
          Intrinsics.throwNpe();
        }
        localByteBuffer.order(ByteOrder.nativeOrder());
        label185:
        localByteBuffer = this.k;
        if (localByteBuffer == null) {
          Intrinsics.throwNpe();
        }
        localByteBuffer.put(this.m, 0, k() * l());
        localByteBuffer = this.k;
        if (localByteBuffer == null) {
          Intrinsics.throwNpe();
        }
        localByteBuffer.position(0);
        localByteBuffer = this.l;
        if (localByteBuffer == null) {
          Intrinsics.throwNpe();
        }
        localByteBuffer.put(this.m, k() * l(), k() * l() / 2);
        localByteBuffer = this.l;
        if (localByteBuffer == null) {
          Intrinsics.throwNpe();
        }
        localByteBuffer.position(0);
        GLES20.glUseProgram(this.e);
        GLES20.glActiveTexture(33984);
        com.tencent.luggage.wxa.so.c.a(this.c, k(), l(), 6409, (Buffer)this.k, 0, 0, 48, null);
        GLES20.glUniform1i(this.h, 0);
        GLES20.glActiveTexture(33985);
        com.tencent.luggage.wxa.so.c.a(this.d, k() / 2, l() / 2, 6410, (Buffer)this.l, 0, 0, 48, null);
        GLES20.glUniform1i(this.i, 1);
        GLES20.glUniformMatrix4fv(this.j, 1, false, e(), 0);
        d().position(0);
        GLES20.glVertexAttribPointer(this.g, 2, 5126, false, 0, (Buffer)d());
        GLES20.glEnableVertexAttribArray(this.g);
        c().position(0);
        GLES20.glVertexAttribPointer(this.f, 2, 5126, false, 0, (Buffer)c());
        GLES20.glEnableVertexAttribArray(this.f);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.g);
        GLES20.glDisableVertexAttribArray(this.f);
        GLES20.glBindTexture(3553, 0);
        GLES20.glFinish();
      }
    }
  }
  
  public void a(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "frame");
    this.m = paramArrayOfByte;
  }
  
  public void b()
  {
    super.b();
    this.c.close();
    this.d.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sp.b
 * JD-Core Version:    0.7.0.1
 */