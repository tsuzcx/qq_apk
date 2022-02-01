package com.tencent.luggage.wxa.ia;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import com.tencent.luggage.wxa.f.f;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/media/render/config/RenderConfigChooser;", "Landroid/opengl/GLSurfaceView$EGLConfigChooser;", "mRedSize", "", "mGreenSize", "mBlueSize", "mAlphaSize", "mDepthSize", "mStencilSize", "(IIIIII)V", "EGL_OPENGL_ES2_BIT", "TAG", "", "TAG$1", "getMAlphaSize", "()I", "setMAlphaSize", "(I)V", "getMBlueSize", "setMBlueSize", "getMDepthSize", "setMDepthSize", "getMGreenSize", "setMGreenSize", "getMRedSize", "setMRedSize", "getMStencilSize", "setMStencilSize", "mValue", "", "s_configAttribs2", "chooseConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "egl", "Ljavax/microedition/khronos/egl/EGL10;", "display", "Ljavax/microedition/khronos/egl/EGLDisplay;", "configs", "", "(Ljavax/microedition/khronos/egl/EGL10;Ljavax/microedition/khronos/egl/EGLDisplay;[Ljavax/microedition/khronos/egl/EGLConfig;)Ljavax/microedition/khronos/egl/EGLConfig;", "findConfigAttrib", "config", "attribute", "defaultValue", "printConfig", "", "printConfigs", "(Ljavax/microedition/khronos/egl/EGL10;Ljavax/microedition/khronos/egl/EGLDisplay;[Ljavax/microedition/khronos/egl/EGLConfig;)V", "Companion", "luggage-camera_release"}, k=1, mv={1, 1, 16})
public final class a
  implements GLSurfaceView.EGLConfigChooser
{
  public static final a.a a = new a.a(null);
  private static final String l = "GLConfigChooser";
  private final String b;
  private final int c;
  private final int[] d;
  private final int[] e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    this.i = paramInt4;
    this.j = paramInt5;
    this.k = paramInt6;
    this.b = "MicroMsg.RenderConfigChooser";
    this.c = 4;
    this.d = new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, this.c, 12344 };
    this.e = new int[1];
  }
  
  private final int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
  {
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.e)) {
      paramInt2 = this.e[0];
    }
    return paramInt2;
  }
  
  private final void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int[] arrayOfInt1 = new int[33];
    int[] tmp8_6 = arrayOfInt1;
    tmp8_6[0] = 12320;
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 12321;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 12322;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 12323;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 12324;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 12325;
    int[] tmp44_38 = tmp38_32;
    tmp44_38[6] = 12326;
    int[] tmp51_44 = tmp44_38;
    tmp51_44[7] = 12327;
    int[] tmp58_51 = tmp51_44;
    tmp58_51[8] = 12328;
    int[] tmp65_58 = tmp58_51;
    tmp65_58[9] = 12329;
    int[] tmp72_65 = tmp65_58;
    tmp72_65[10] = 12330;
    int[] tmp79_72 = tmp72_65;
    tmp79_72[11] = 12331;
    int[] tmp86_79 = tmp79_72;
    tmp86_79[12] = 12332;
    int[] tmp93_86 = tmp86_79;
    tmp93_86[13] = 12333;
    int[] tmp100_93 = tmp93_86;
    tmp100_93[14] = 12334;
    int[] tmp107_100 = tmp100_93;
    tmp107_100[15] = 12335;
    int[] tmp114_107 = tmp107_100;
    tmp114_107[16] = 12336;
    int[] tmp121_114 = tmp114_107;
    tmp121_114[17] = 12337;
    int[] tmp128_121 = tmp121_114;
    tmp128_121[18] = 12338;
    int[] tmp135_128 = tmp128_121;
    tmp135_128[19] = 12339;
    int[] tmp142_135 = tmp135_128;
    tmp142_135[20] = 12340;
    int[] tmp149_142 = tmp142_135;
    tmp149_142[21] = 12343;
    int[] tmp156_149 = tmp149_142;
    tmp156_149[22] = 12342;
    int[] tmp163_156 = tmp156_149;
    tmp163_156[23] = 12341;
    int[] tmp170_163 = tmp163_156;
    tmp170_163[24] = 12345;
    int[] tmp177_170 = tmp170_163;
    tmp177_170[25] = 12346;
    int[] tmp184_177 = tmp177_170;
    tmp184_177[26] = 12347;
    int[] tmp191_184 = tmp184_177;
    tmp191_184[27] = 12348;
    int[] tmp198_191 = tmp191_184;
    tmp198_191[28] = 12349;
    int[] tmp205_198 = tmp198_191;
    tmp205_198[29] = 12350;
    int[] tmp212_205 = tmp205_198;
    tmp212_205[30] = 12351;
    int[] tmp219_212 = tmp212_205;
    tmp219_212[31] = 12352;
    int[] tmp226_219 = tmp219_212;
    tmp226_219[32] = 12354;
    tmp226_219;
    int m = 0;
    int[] arrayOfInt2 = new int[1];
    int n = arrayOfInt1.length;
    while (m < n)
    {
      int i1 = arrayOfInt1[m];
      String str = new String[] { "EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT" }[m];
      paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, i1, arrayOfInt2);
      m += 1;
    }
  }
  
  private final void b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    int n = paramArrayOfEGLConfig.length;
    Object localObject1 = this.b;
    Object localObject2 = StringCompanionObject.INSTANCE;
    localObject2 = new Object[1];
    localObject2[0] = Integer.valueOf(n);
    localObject2 = String.format("%d configurations", Arrays.copyOf((Object[])localObject2, localObject2.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "java.lang.String.format(format, *args)");
    f.b((String)localObject1, (String)localObject2);
    int m = 0;
    while (m < n)
    {
      localObject1 = this.b;
      localObject2 = StringCompanionObject.INSTANCE;
      localObject2 = new Object[1];
      localObject2[0] = Integer.valueOf(m);
      localObject2 = String.format("Configuration %d:\n", Arrays.copyOf((Object[])localObject2, localObject2.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "java.lang.String.format(format, *args)");
      f.b((String)localObject1, (String)localObject2);
      localObject1 = paramArrayOfEGLConfig[m];
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      a(paramEGL10, paramEGLDisplay, (EGLConfig)localObject1);
      m += 1;
    }
  }
  
  @Nullable
  public final EGLConfig a(@NotNull EGL10 paramEGL10, @NotNull EGLDisplay paramEGLDisplay, @NotNull EGLConfig[] paramArrayOfEGLConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramEGL10, "egl");
    Intrinsics.checkParameterIsNotNull(paramEGLDisplay, "display");
    Intrinsics.checkParameterIsNotNull(paramArrayOfEGLConfig, "configs");
    int n = paramArrayOfEGLConfig.length;
    int m = 0;
    while (m < n)
    {
      EGLConfig localEGLConfig = paramArrayOfEGLConfig[m];
      if (localEGLConfig == null) {
        Intrinsics.throwNpe();
      }
      int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
      int i2 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
      if ((i1 >= this.j) && (i2 >= this.k))
      {
        i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
        i2 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
        int i3 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
        int i4 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321, 0);
        if ((i1 == this.f) && (i2 == this.g) && (i3 == this.h) && (i4 == this.i)) {
          return localEGLConfig;
        }
      }
      m += 1;
    }
    return null;
  }
  
  @Nullable
  public EGLConfig chooseConfig(@NotNull EGL10 paramEGL10, @NotNull EGLDisplay paramEGLDisplay)
  {
    Intrinsics.checkParameterIsNotNull(paramEGL10, "egl");
    Intrinsics.checkParameterIsNotNull(paramEGLDisplay, "display");
    int[] arrayOfInt = new int[1];
    paramEGL10.eglChooseConfig(paramEGLDisplay, this.d, null, 0, arrayOfInt);
    int m = arrayOfInt[0];
    if (m > 0)
    {
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[m];
      paramEGL10.eglChooseConfig(paramEGLDisplay, this.d, arrayOfEGLConfig, m, arrayOfInt);
      b(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
      return a(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    }
    throw ((Throwable)new IllegalArgumentException("No configs match configSpec"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ia.a
 * JD-Core Version:    0.7.0.1
 */