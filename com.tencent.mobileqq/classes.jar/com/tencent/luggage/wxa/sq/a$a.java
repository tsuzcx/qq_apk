package com.tencent.luggage.wxa.sq;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.view.Surface;
import com.tencent.luggage.wxa.f.e;
import com.tencent.luggage.wxa.f.f;
import com.tencent.luggage.wxa.so.c;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/wmpf/samelayer/recordview/util/LuggageGLEnvironmentUtil$Companion;", "", "()V", "CUBE_PROTRAIT", "", "EGL_RECORDABLE_ANDROID", "", "TAG", "", "TEXTURE_COORD", "TEXTURE_COORD_VERTICAL_FLIP", "commonEGLAttributeList", "", "commonEGLAttributeListWithMSAA", "commonEGLAttributeListWithoutRecordable", "bindContextAndSurface", "Lcom/tencent/wmpf/samelayer/recordview/util/LuggageGLEnvironmentUtil$EGLEnvironment;", "eglContext", "Landroid/opengl/EGLContext;", "surface", "width", "height", "bindFrameBuffer", "", "fbo", "Lcom/tencent/wmpf/samelayer/recordview/globject/LuggageGLFrameBufferObject;", "texture", "Lcom/tencent/wmpf/samelayer/recordview/globject/LuggageGLTextureObject;", "bindRenderBuffer", "buffer", "checkEglError", "", "msg", "tag", "checkGLError", "chooseConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eGL", "Ljavax/microedition/khronos/egl/EGL10;", "eGLDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "redSize", "greenSize", "blueSize", "alphaSize", "withSample", "chooseConfigEGL14", "Landroid/opengl/EGLConfig;", "Landroid/opengl/EGLDisplay;", "clearGL", "deleteFrameBuffer", "deleteTexture", "deleteTextures", "textures", "drawBitmapToTexture", "bitmap", "Landroid/graphics/Bitmap;", "eglBindSurface", "mEGLContext", "mEGLDisplay", "mSurface", "Landroid/view/Surface;", "eglSetupBySurface", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "eglUnbindSurface", "eglEnvironment", "backupSurface", "Landroid/opengl/EGLSurface;", "genFrameBuffer", "genRenderBuffer", "genTexture", "genTextureExternal", "loadShader", "shaderSource", "type", "loadShaderProgram", "vertexShaderSource", "fragmentShaderSource", "release", "eglSurface", "eglDisplay", "saveGLPixels", "saveTexture", "setupDeviceSupportGLVersion", "context", "Landroid/content/Context;", "swapBuffers", "uploadBitmapTexture", "texName", "luggage-camera_release"}, k=1, mv={1, 1, 16})
public final class a$a
{
  private final void a(String paramString)
  {
    int i = GLES30.glGetError();
    if (i != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": GL error: 0x");
      localStringBuilder.append(Integer.toHexString(i));
      f.b("WMPF.LuggageGLEnvironmentUtil", localStringBuilder.toString());
    }
  }
  
  @Deprecated(message="使用GLTextureObject，便于检测泄露")
  @JvmStatic
  public final int a()
  {
    int[] arrayOfInt = new int[1];
    GLES30.glGenTextures(1, arrayOfInt, 0);
    GLES30.glBindTexture(3553, arrayOfInt[0]);
    GLES30.glTexParameteri(3553, 10241, 9729);
    GLES30.glTexParameteri(3553, 10240, 9728);
    GLES30.glTexParameteri(3553, 10242, 33071);
    GLES30.glTexParameteri(3553, 10243, 33071);
    GLES30.glBindTexture(3553, 0);
    ((a)this).a("genTexture");
    return arrayOfInt[0];
  }
  
  public final int a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "shaderSource");
    int[] arrayOfInt = new int[1];
    paramInt = GLES30.glCreateShader(paramInt);
    GLES30.glShaderSource(paramInt, paramString);
    GLES30.glCompileShader(paramInt);
    GLES30.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      f.b("WMPF.LuggageGLEnvironmentUtil", "loadShader error, infoLog: %s", new Object[] { GLES30.glGetShaderInfoLog(paramInt) });
      return 0;
    }
    return paramInt;
  }
  
  @JvmStatic
  public final int a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "vertexShaderSource");
    Intrinsics.checkParameterIsNotNull(paramString2, "fragmentShaderSource");
    int[] arrayOfInt = new int[1];
    a locala = (a)this;
    int i = locala.a(paramString1, 35633);
    if (i == 0)
    {
      f.d("WMPF.LuggageGLEnvironmentUtil", "load vertex shader failed");
      return 0;
    }
    int j = locala.a(paramString2, 35632);
    if (j == 0)
    {
      f.d("WMPF.LuggageGLEnvironmentUtil", "load fragment shader failed");
      return 0;
    }
    int k = GLES30.glCreateProgram();
    GLES30.glAttachShader(k, i);
    GLES30.glAttachShader(k, j);
    GLES30.glLinkProgram(k);
    GLES30.glGetProgramiv(k, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] <= 0)
    {
      f.d("WMPF.LuggageGLEnvironmentUtil", "link program failed");
      return 0;
    }
    GLES30.glDeleteShader(i);
    GLES30.glDeleteShader(j);
    return k;
  }
  
  @JvmStatic
  @NotNull
  public final a.b a(@Nullable Surface paramSurface, @Nullable SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("eglSetupBySurface, surface:");
    ((StringBuilder)localObject1).append(paramSurface);
    ((StringBuilder)localObject1).append(", surfaceTexture:");
    ((StringBuilder)localObject1).append(paramSurfaceTexture);
    ((StringBuilder)localObject1).append(", width:");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(", height:");
    ((StringBuilder)localObject1).append(paramInt2);
    f.b("WMPF.LuggageGLEnvironmentUtil", ((StringBuilder)localObject1).toString());
    EGLDisplay localEGLDisplay = EGL14.eglGetDisplay(0);
    if (localEGLDisplay != EGL14.EGL_NO_DISPLAY)
    {
      localObject1 = new int[2];
      if (EGL14.eglInitialize(localEGLDisplay, (int[])localObject1, 0, (int[])localObject1, 1))
      {
        localObject1 = new EGLConfig[1];
        Object localObject3 = new int[1];
        if ((paramSurface == null) && (paramSurfaceTexture == null))
        {
          EGL14.eglChooseConfig(localEGLDisplay, a.b(), 0, (EGLConfig[])localObject1, 0, localObject1.length, (int[])localObject3, 0);
        }
        else
        {
          localObject2 = localObject1;
          EGL14.eglChooseConfig(localEGLDisplay, a.a(), 0, localObject2, 0, localObject2.length, (int[])localObject3, 0);
        }
        Object localObject2 = localObject1;
        localObject3 = (a)this;
        a((a)localObject3, "eglCreateContext RGB888+recordable ES2", null, 2, null);
        int i = e.a().d();
        EGLContext localEGLContext = EGL14.eglCreateContext(localEGLDisplay, localObject2[0], EGL14.EGL_NO_CONTEXT, new int[] { 12440, i, 12344 }, 0);
        a((a)localObject3, "eglCreateContext", null, 2, null);
        if ((paramInt1 > 0) && (paramInt2 > 0))
        {
          localObject1 = new int[5];
          localObject1[0] = 12375;
          localObject1[1] = paramInt1;
          localObject1[2] = 12374;
          localObject1[3] = paramInt2;
          localObject1[4] = 12344;
        }
        else
        {
          localObject1 = new int[1];
          localObject1[0] = 12344;
        }
        if (paramSurface != null) {
          paramSurfaceTexture = EGL14.eglCreateWindowSurface(localEGLDisplay, localObject2[0], paramSurface, (int[])localObject1, 0);
        } else if (paramSurfaceTexture != null) {
          paramSurfaceTexture = EGL14.eglCreateWindowSurface(localEGLDisplay, localObject2[0], paramSurfaceTexture, (int[])localObject1, 0);
        } else {
          paramSurfaceTexture = EGL14.eglCreatePbufferSurface(localEGLDisplay, localObject2[0], (int[])localObject1, 0);
        }
        if (paramSurface != null) {
          a((a)localObject3, "eglCreateWindowSurface", null, 2, null);
        } else {
          a((a)localObject3, "eglCreatePbufferSurface", null, 2, null);
        }
        EGL14.eglMakeCurrent(localEGLDisplay, paramSurfaceTexture, paramSurfaceTexture, localEGLContext);
        a((a)localObject3, "eglMakeCurrent", null, 2, null);
        Intrinsics.checkExpressionValueIsNotNull(localEGLDisplay, "mEGLDisplay");
        Intrinsics.checkExpressionValueIsNotNull(paramSurfaceTexture, "mEGLSurface");
        Intrinsics.checkExpressionValueIsNotNull(localEGLContext, "mEGLContext");
        return new a.b(localEGLDisplay, paramSurfaceTexture, localEGLContext);
      }
      throw ((Throwable)new RuntimeException("unable to initialize EGL14"));
    }
    throw ((Throwable)new RuntimeException("unable to get EGL14 display"));
  }
  
  public final void a(int paramInt)
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = paramInt;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public final void a(@Nullable com.tencent.luggage.wxa.so.a parama, @Nullable c paramc, int paramInt1, int paramInt2)
  {
    if (parama == null)
    {
      f.d("WMPF.LuggageGLEnvironmentUtil", "fbo is null !");
      return;
    }
    if (paramc == null)
    {
      f.d("WMPF.LuggageGLEnvironmentUtil", "texture is null");
      return;
    }
    GLES30.glBindFramebuffer(36160, parama.b());
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      c.a(paramc, paramInt1, paramInt2, 0, null, 0, 0, 60, null);
    }
    GLES30.glFramebufferTexture2D(36160, 36064, 3553, paramc.c(), 0);
    GLES30.glBindTexture(3553, 0);
  }
  
  @Deprecated(message="使用GLTextureObject，便于检测泄露")
  public final int b()
  {
    int[] arrayOfInt = new int[1];
    GLES30.glGenTextures(1, arrayOfInt, 0);
    GLES30.glBindTexture(36197, arrayOfInt[0]);
    GLES30.glTexParameteri(36197, 10241, 9729);
    GLES30.glTexParameteri(36197, 10240, 9729);
    GLES30.glTexParameteri(36197, 10242, 33071);
    GLES30.glTexParameteri(36197, 10243, 33071);
    GLES30.glBindTexture(36197, 0);
    ((a)this).a("glGenTextures");
    return arrayOfInt[0];
  }
  
  public final void b(int paramInt)
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = paramInt;
    GLES20.glDeleteFramebuffers(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public final boolean b(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "msg");
    Intrinsics.checkParameterIsNotNull(paramString2, "tag");
    int i = EGL14.eglGetError();
    if (i != 12288)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(": EGL error: 0x");
      localStringBuilder.append(Integer.toHexString(i));
      f.b(paramString2, localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  @Deprecated(message="使用GLFrameBufferObject，便于检测泄露")
  public final int c()
  {
    int[] arrayOfInt = new int[1];
    GLES30.glGenFramebuffers(1, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      f.d("WMPF.LuggageGLEnvironmentUtil", "gen frame buffer error");
      return 0;
    }
    return arrayOfInt[0];
  }
  
  @JvmStatic
  public final void d()
  {
    GLES30.glClear(16640);
    GLES30.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES30.glBindFramebuffer(36160, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sq.a.a
 * JD-Core Version:    0.7.0.1
 */