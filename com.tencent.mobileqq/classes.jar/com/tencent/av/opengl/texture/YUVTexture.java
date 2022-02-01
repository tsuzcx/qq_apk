package com.tencent.av.opengl.texture;

import android.content.Context;
import android.opengl.GLES20;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLId;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.utils.AudioHelper;
import com.tencent.avcore.jni.render.GLRenderListener;
import com.tencent.avcore.jni.render.IGLRenderTexture;
import com.tencent.avcore.jni.render.IRenderTextureProxy;
import com.tencent.avcore.jni.render.RenderTextureJni;
import com.tencent.qphone.base.util.QLog;

public abstract class YUVTexture
  extends BasicTexture
  implements IGLRenderTexture, IRenderTextureProxy
{
  public static float[] q = { 1.0F, 1.0F, 1.0F, 0.0F, 0.00093F, -0.3437F, 1.77216F, 0.0F, 1.401687F, -0.71417F, 0.00099F, 0.0F, -0.7011F, 0.525F, -0.8828F, 1.0F };
  static boolean u = false;
  public int A;
  private final String B;
  private GLRenderListener C;
  private final RenderTextureJni D;
  private boolean E;
  private long F;
  private long G;
  private long H;
  private long I;
  private long J;
  Context o;
  boolean p;
  protected float[] r;
  public float s;
  public float t;
  boolean v;
  volatile boolean w;
  protected int x;
  protected int y;
  protected int z;
  
  /* Error */
  public YUVTexture(Context paramContext, String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: iconst_0
    //   3: invokespecial 63	com/tencent/av/opengl/texture/BasicTexture:<init>	(Lcom/tencent/av/opengl/glrenderer/GLCanvas;I)V
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield 65	com/tencent/av/opengl/texture/YUVTexture:p	Z
    //   11: aload_0
    //   12: bipush 16
    //   14: newarray float
    //   16: dup
    //   17: iconst_0
    //   18: fconst_1
    //   19: fastore
    //   20: dup
    //   21: iconst_1
    //   22: fconst_1
    //   23: fastore
    //   24: dup
    //   25: iconst_2
    //   26: fconst_1
    //   27: fastore
    //   28: dup
    //   29: iconst_3
    //   30: fconst_0
    //   31: fastore
    //   32: dup
    //   33: iconst_4
    //   34: ldc 39
    //   36: fastore
    //   37: dup
    //   38: iconst_5
    //   39: ldc 40
    //   41: fastore
    //   42: dup
    //   43: bipush 6
    //   45: ldc 41
    //   47: fastore
    //   48: dup
    //   49: bipush 7
    //   51: fconst_0
    //   52: fastore
    //   53: dup
    //   54: bipush 8
    //   56: ldc 42
    //   58: fastore
    //   59: dup
    //   60: bipush 9
    //   62: ldc 43
    //   64: fastore
    //   65: dup
    //   66: bipush 10
    //   68: ldc 44
    //   70: fastore
    //   71: dup
    //   72: bipush 11
    //   74: fconst_0
    //   75: fastore
    //   76: dup
    //   77: bipush 12
    //   79: ldc 45
    //   81: fastore
    //   82: dup
    //   83: bipush 13
    //   85: ldc 46
    //   87: fastore
    //   88: dup
    //   89: bipush 14
    //   91: ldc 47
    //   93: fastore
    //   94: dup
    //   95: bipush 15
    //   97: fconst_1
    //   98: fastore
    //   99: putfield 67	com/tencent/av/opengl/texture/YUVTexture:r	[F
    //   102: aload_0
    //   103: ldc 68
    //   105: putfield 70	com/tencent/av/opengl/texture/YUVTexture:s	F
    //   108: aload_0
    //   109: ldc 71
    //   111: putfield 73	com/tencent/av/opengl/texture/YUVTexture:t	F
    //   114: aload_0
    //   115: iconst_1
    //   116: putfield 75	com/tencent/av/opengl/texture/YUVTexture:v	Z
    //   119: aload_0
    //   120: iconst_1
    //   121: putfield 77	com/tencent/av/opengl/texture/YUVTexture:w	Z
    //   124: aload_0
    //   125: iconst_m1
    //   126: putfield 79	com/tencent/av/opengl/texture/YUVTexture:x	I
    //   129: aload_0
    //   130: iconst_0
    //   131: putfield 81	com/tencent/av/opengl/texture/YUVTexture:y	I
    //   134: aload_0
    //   135: iconst_0
    //   136: putfield 83	com/tencent/av/opengl/texture/YUVTexture:z	I
    //   139: aload_0
    //   140: iconst_1
    //   141: putfield 85	com/tencent/av/opengl/texture/YUVTexture:E	Z
    //   144: aload_0
    //   145: lconst_0
    //   146: putfield 87	com/tencent/av/opengl/texture/YUVTexture:F	J
    //   149: aload_0
    //   150: lconst_0
    //   151: putfield 89	com/tencent/av/opengl/texture/YUVTexture:G	J
    //   154: aload_0
    //   155: lconst_0
    //   156: putfield 91	com/tencent/av/opengl/texture/YUVTexture:H	J
    //   159: aload_0
    //   160: lconst_0
    //   161: putfield 93	com/tencent/av/opengl/texture/YUVTexture:I	J
    //   164: aload_0
    //   165: lconst_0
    //   166: putfield 95	com/tencent/av/opengl/texture/YUVTexture:J	J
    //   169: aload_0
    //   170: iconst_m1
    //   171: putfield 97	com/tencent/av/opengl/texture/YUVTexture:A	I
    //   174: aload_0
    //   175: aload_1
    //   176: putfield 99	com/tencent/av/opengl/texture/YUVTexture:o	Landroid/content/Context;
    //   179: aload_0
    //   180: invokestatic 104	com/tencent/av/utils/QAVConfigUtils:p	()Z
    //   183: putfield 75	com/tencent/av/opengl/texture/YUVTexture:v	Z
    //   186: new 106	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   193: astore 5
    //   195: aload 5
    //   197: ldc 110
    //   199: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 5
    //   205: aload_0
    //   206: getfield 75	com/tencent/av/opengl/texture/YUVTexture:v	Z
    //   209: invokevirtual 117	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: ldc 119
    //   215: iconst_1
    //   216: aload 5
    //   218: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: bipush 22
    //   226: invokestatic 135	com/tencent/av/utils/AudioHelper:a	(I)I
    //   229: iconst_1
    //   230: if_icmpne +11 -> 241
    //   233: aload_0
    //   234: iconst_1
    //   235: putfield 75	com/tencent/av/opengl/texture/YUVTexture:v	Z
    //   238: goto +16 -> 254
    //   241: bipush 22
    //   243: invokestatic 135	com/tencent/av/utils/AudioHelper:a	(I)I
    //   246: ifne +8 -> 254
    //   249: aload_0
    //   250: iconst_0
    //   251: putfield 75	com/tencent/av/opengl/texture/YUVTexture:v	Z
    //   254: new 106	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   261: astore 5
    //   263: aload 5
    //   265: ldc 137
    //   267: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 5
    //   273: aload_0
    //   274: getfield 75	com/tencent/av/opengl/texture/YUVTexture:v	Z
    //   277: invokevirtual 117	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: ldc 119
    //   283: iconst_1
    //   284: aload 5
    //   286: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: aload_0
    //   293: iconst_1
    //   294: putfield 140	com/tencent/av/opengl/texture/YUVTexture:c	I
    //   297: getstatic 51	com/tencent/av/opengl/texture/YUVTexture:u	Z
    //   300: ifne +26 -> 326
    //   303: aload_1
    //   304: ldc 142
    //   306: iconst_0
    //   307: iconst_0
    //   308: invokestatic 147	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;IZ)Z
    //   311: pop
    //   312: iconst_1
    //   313: putstatic 51	com/tencent/av/opengl/texture/YUVTexture:u	Z
    //   316: goto +10 -> 326
    //   319: astore 5
    //   321: aload 5
    //   323: invokevirtual 150	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   326: aload_0
    //   327: new 152	com/tencent/avcore/jni/render/RenderTextureJni
    //   330: dup
    //   331: aload_0
    //   332: invokespecial 155	com/tencent/avcore/jni/render/RenderTextureJni:<init>	(Lcom/tencent/avcore/jni/render/IGLRenderTexture;)V
    //   335: putfield 157	com/tencent/av/opengl/texture/YUVTexture:D	Lcom/tencent/avcore/jni/render/RenderTextureJni;
    //   338: getstatic 51	com/tencent/av/opengl/texture/YUVTexture:u	Z
    //   341: ifeq +30 -> 371
    //   344: new 159	java/lang/ref/WeakReference
    //   347: dup
    //   348: aload_0
    //   349: getfield 157	com/tencent/av/opengl/texture/YUVTexture:D	Lcom/tencent/avcore/jni/render/RenderTextureJni;
    //   352: invokespecial 162	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   355: astore 5
    //   357: aload_0
    //   358: getfield 157	com/tencent/av/opengl/texture/YUVTexture:D	Lcom/tencent/avcore/jni/render/RenderTextureJni;
    //   361: aload_1
    //   362: invokestatic 167	com/tencent/av/opengl/utils/Utils:a	(Landroid/content/Context;)I
    //   365: aload 5
    //   367: lload_3
    //   368: invokevirtual 171	com/tencent/avcore/jni/render/RenderTextureJni:init	(ILjava/lang/Object;J)V
    //   371: new 106	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   378: astore_1
    //   379: aload_1
    //   380: aload_0
    //   381: invokevirtual 177	java/lang/Object:getClass	()Ljava/lang/Class;
    //   384: invokevirtual 182	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   387: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload_1
    //   392: ldc 184
    //   394: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload_1
    //   399: aload_2
    //   400: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload_1
    //   405: ldc 186
    //   407: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload_1
    //   412: aload_0
    //   413: getfield 157	com/tencent/av/opengl/texture/YUVTexture:D	Lcom/tencent/avcore/jni/render/RenderTextureJni;
    //   416: invokevirtual 190	com/tencent/avcore/jni/render/RenderTextureJni:getNativeContext	()J
    //   419: invokestatic 196	java/lang/Long:toHexString	(J)Ljava/lang/String;
    //   422: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload_0
    //   427: aload_1
    //   428: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: putfield 198	com/tencent/av/opengl/texture/YUVTexture:B	Ljava/lang/String;
    //   434: return
    //   435: astore_1
    //   436: goto +35 -> 471
    //   439: astore_1
    //   440: aload_1
    //   441: invokevirtual 199	java/lang/Error:printStackTrace	()V
    //   444: new 106	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   451: astore_1
    //   452: goto -73 -> 379
    //   455: astore_1
    //   456: aload_1
    //   457: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   460: new 106	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   467: astore_1
    //   468: goto -89 -> 379
    //   471: new 106	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   478: astore 5
    //   480: aload 5
    //   482: aload_0
    //   483: invokevirtual 177	java/lang/Object:getClass	()Ljava/lang/Class;
    //   486: invokevirtual 182	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   489: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload 5
    //   495: ldc 184
    //   497: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload 5
    //   503: aload_2
    //   504: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload 5
    //   510: ldc 186
    //   512: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload 5
    //   518: aload_0
    //   519: getfield 157	com/tencent/av/opengl/texture/YUVTexture:D	Lcom/tencent/avcore/jni/render/RenderTextureJni;
    //   522: invokevirtual 190	com/tencent/avcore/jni/render/RenderTextureJni:getNativeContext	()J
    //   525: invokestatic 196	java/lang/Long:toHexString	(J)Ljava/lang/String;
    //   528: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload_0
    //   533: aload 5
    //   535: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: putfield 198	com/tencent/av/opengl/texture/YUVTexture:B	Ljava/lang/String;
    //   541: goto +5 -> 546
    //   544: aload_1
    //   545: athrow
    //   546: goto -2 -> 544
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	549	0	this	YUVTexture
    //   0	549	1	paramContext	Context
    //   0	549	2	paramString	String
    //   0	549	3	paramLong	long
    //   193	92	5	localStringBuilder	StringBuilder
    //   319	3	5	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   355	179	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   303	316	319	java/lang/UnsatisfiedLinkError
    //   338	371	435	finally
    //   440	444	435	finally
    //   456	460	435	finally
    //   338	371	439	java/lang/Error
    //   338	371	455	java/lang/Exception
  }
  
  private void B()
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.b[0]);
  }
  
  public int A()
  {
    return this.x;
  }
  
  public void a(GLRenderListener paramGLRenderListener)
  {
    this.C = paramGLRenderListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
    if (paramBoolean)
    {
      this.c = 7;
      return;
    }
    this.c = 1;
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.B, 2, new Object[] { "setIsBind, old[%s], new[%s]", Boolean.valueOf(this.E), Boolean.valueOf(paramBoolean) });
    }
    this.E = paramBoolean;
  }
  
  public boolean b(GLCanvas paramGLCanvas)
  {
    if (AudioHelper.d) {
      this.F = System.currentTimeMillis();
    }
    if (!m())
    {
      if (this.a == null) {
        this.a = new int[3];
      }
      i = 0;
      while (i < this.a.length)
      {
        this.a[i] = paramGLCanvas.a().a();
        i += 1;
      }
      i = 1;
    }
    else
    {
      i = 0;
    }
    TextureProgram localTextureProgram = c();
    if (this.E)
    {
      if (this.v) {
        if (this.w)
        {
          this.w = false;
        }
        else
        {
          j = 0;
          break label118;
        }
      }
      int j = 1;
      label118:
      if ((j != 0) || (i != 0))
      {
        if (!this.m)
        {
          w();
          i = uploadContent(this.a);
          break label191;
        }
        if (this.b == null)
        {
          this.b = new int[1];
          this.b[0] = paramGLCanvas.a().a();
        }
        B();
        this.x = 0;
      }
    }
    int i = -1;
    label191:
    if (i != -1) {
      this.x = i;
    }
    if ((this.x != -1) && (!this.m)) {
      GLES20.glUniform1i(localTextureProgram.b()[10].a, this.x);
    }
    this.d = 1;
    if ((this.p) && (this.A == -1))
    {
      this.A = paramGLCanvas.a().a();
      this.A = c(2130841056, this.A);
    }
    return this.x != -1;
  }
  
  /* Error */
  public int c(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: sipush 3553
    //   3: iload_2
    //   4: invokestatic 215	android/opengl/GLES20:glBindTexture	(II)V
    //   7: sipush 3553
    //   10: sipush 10241
    //   13: ldc_w 292
    //   16: invokestatic 296	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   19: sipush 3553
    //   22: sipush 10240
    //   25: ldc_w 297
    //   28: invokestatic 296	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   31: sipush 3553
    //   34: sipush 10242
    //   37: ldc_w 298
    //   40: invokestatic 296	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   43: sipush 3553
    //   46: sipush 10243
    //   49: ldc_w 298
    //   52: invokestatic 296	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   55: aload_0
    //   56: getfield 99	com/tencent/av/opengl/texture/YUVTexture:o	Landroid/content/Context;
    //   59: invokevirtual 304	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   62: iload_1
    //   63: invokevirtual 310	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   66: astore_3
    //   67: aload_3
    //   68: invokestatic 316	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   71: astore 4
    //   73: aload_3
    //   74: invokevirtual 321	java/io/InputStream:close	()V
    //   77: goto +8 -> 85
    //   80: astore_3
    //   81: aload_3
    //   82: invokevirtual 322	java/io/IOException:printStackTrace	()V
    //   85: aload 4
    //   87: ifnull +20 -> 107
    //   90: sipush 3553
    //   93: iconst_0
    //   94: aload 4
    //   96: iconst_0
    //   97: invokestatic 328	android/opengl/GLUtils:texImage2D	(IILandroid/graphics/Bitmap;I)V
    //   100: aload 4
    //   102: invokevirtual 333	android/graphics/Bitmap:recycle	()V
    //   105: iload_2
    //   106: ireturn
    //   107: iconst_m1
    //   108: ireturn
    //   109: astore 4
    //   111: aload_3
    //   112: invokevirtual 321	java/io/InputStream:close	()V
    //   115: goto +8 -> 123
    //   118: astore_3
    //   119: aload_3
    //   120: invokevirtual 322	java/io/IOException:printStackTrace	()V
    //   123: aload 4
    //   125: athrow
    //   126: aload_3
    //   127: invokevirtual 321	java/io/InputStream:close	()V
    //   130: iconst_m1
    //   131: ireturn
    //   132: astore_3
    //   133: aload_3
    //   134: invokevirtual 322	java/io/IOException:printStackTrace	()V
    //   137: iconst_m1
    //   138: ireturn
    //   139: astore 4
    //   141: goto -15 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	YUVTexture
    //   0	144	1	paramInt1	int
    //   0	144	2	paramInt2	int
    //   66	8	3	localInputStream	java.io.InputStream
    //   80	32	3	localIOException1	java.io.IOException
    //   118	9	3	localIOException2	java.io.IOException
    //   132	2	3	localIOException3	java.io.IOException
    //   71	30	4	localBitmap	android.graphics.Bitmap
    //   109	15	4	localObject	Object
    //   139	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   73	77	80	java/io/IOException
    //   67	73	109	finally
    //   111	115	118	java/io/IOException
    //   126	130	132	java/io/IOException
    //   67	73	139	java/lang/OutOfMemoryError
  }
  
  public void c(int paramInt)
  {
    if (this.b == null) {
      this.b = new int[1];
    }
    this.b[0] = paramInt;
  }
  
  public ShaderParameter[] c(GLCanvas paramGLCanvas)
  {
    TextureProgram localTextureProgram = c();
    paramGLCanvas = super.c(paramGLCanvas);
    if (!this.m) {
      try
      {
        GLES20.glUniform1f(localTextureProgram.b()[7].a, getImgWidth());
        GLES20.glUniform1f(localTextureProgram.b()[8].a, getImgHeight());
        GLES20.glUniformMatrix4fv(localTextureProgram.b()[9].a, 1, false, this.r, 0);
        if ((this.p) && (this.A != -1))
        {
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          GLES20.glActiveTexture(33987);
          Utils.a();
          GLES20.glBindTexture(l(), this.A);
          Utils.a();
          GLES20.glUniform1i(localTextureProgram.b()[11].a, 3);
          Utils.a();
          GLES20.glUniform1i(localTextureProgram.b()[12].a, 1);
          Utils.a();
          return paramGLCanvas;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return paramGLCanvas;
  }
  
  public boolean canRender()
  {
    return this.D.canRender();
  }
  
  public void flush(boolean paramBoolean)
  {
    this.D.flush(paramBoolean);
  }
  
  public int getCaptureFrameHeight()
  {
    return this.D.getCaptureFrameHeight();
  }
  
  public byte[] getCaptureFrameTexture()
  {
    return this.D.getCaptureFrameTexture();
  }
  
  public int getCaptureFrameWidth()
  {
    return this.D.getCaptureFrameWidth();
  }
  
  public byte[] getFaceFeature()
  {
    return this.D.getFaceFeature();
  }
  
  public byte[] getFrameTexture()
  {
    return this.D.getFrameTexture();
  }
  
  public int getImgAngle()
  {
    return this.D.getImgAngle();
  }
  
  public int getImgHeight()
  {
    return this.D.getImgHeight();
  }
  
  public int getImgWidth()
  {
    return this.D.getImgWidth();
  }
  
  public boolean k()
  {
    return true;
  }
  
  public int l()
  {
    return 3553;
  }
  
  public void markForPerf(int paramInt)
  {
    if (paramInt == 0)
    {
      if (AudioHelper.d) {
        this.H = System.currentTimeMillis();
      }
    }
    else if (paramInt == 2)
    {
      if (AudioHelper.d) {
        this.I = System.currentTimeMillis();
      }
    }
    else if (paramInt == 1)
    {
      if (AudioHelper.d) {
        this.J = System.currentTimeMillis();
      }
    }
    else if ((paramInt == 3) && (AudioHelper.d)) {
      this.G = System.currentTimeMillis();
    }
  }
  
  public void nativeFrameDataUpdate()
  {
    this.w = true;
  }
  
  public void onFaceFeatureUpdate(byte[] paramArrayOfByte)
  {
    GLRenderListener localGLRenderListener = this.C;
    if ((localGLRenderListener != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      localGLRenderListener.onFaceFeatureUpdate(paramArrayOfByte);
    }
  }
  
  public void onPause()
  {
    this.D.onPause();
  }
  
  public void onRenderFlush()
  {
    GLRenderListener localGLRenderListener = this.C;
    if (localGLRenderListener != null) {
      localGLRenderListener.onRenderFlush();
    }
  }
  
  public void onRenderFrame()
  {
    GLRenderListener localGLRenderListener = this.C;
    if (localGLRenderListener != null) {
      localGLRenderListener.onRenderFrame();
    }
  }
  
  public void onRenderInfoNotify(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GLRenderListener localGLRenderListener = this.C;
    if (localGLRenderListener != null) {
      localGLRenderListener.onRenderInfoNotify(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onRenderReset()
  {
    GLRenderListener localGLRenderListener = this.C;
    if (localGLRenderListener != null) {
      localGLRenderListener.onRenderReset();
    }
  }
  
  public void onResume()
  {
    this.D.onResume();
  }
  
  public byte[] s()
  {
    return getCaptureFrameTexture();
  }
  
  public int t()
  {
    return getCaptureFrameWidth();
  }
  
  public int u()
  {
    return getCaptureFrameHeight();
  }
  
  public boolean updateCurFrame()
  {
    return this.D.updateCurFrame();
  }
  
  public int uploadContent(int[] paramArrayOfInt)
  {
    return this.D.uploadContent(paramArrayOfInt);
  }
  
  public RenderTextureJni v()
  {
    return this.D;
  }
  
  public void w()
  {
    onFaceFeatureUpdate(getFaceFeature());
  }
  
  public boolean x()
  {
    return this.E;
  }
  
  public String y()
  {
    long l5 = System.currentTimeMillis();
    long l1 = this.F;
    if (l1 != 0L) {
      l1 = l5 - l1;
    } else {
      l1 = -1L;
    }
    long l2 = this.G;
    if (l2 != 0L) {
      l2 = l5 - l2;
    } else {
      l2 = -1L;
    }
    long l3 = this.H;
    if (l3 != 0L) {
      l3 = l5 - l3;
    } else {
      l3 = -1L;
    }
    long l4 = this.I;
    if (l4 != 0L) {
      l4 = l5 - l4;
    } else {
      l4 = -1L;
    }
    long l6 = this.J;
    if (l6 != 0L) {
      l5 -= l6;
    } else {
      l5 = -1L;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAG[");
    localStringBuilder.append(this.B);
    localStringBuilder.append("], onBindTime[");
    localStringBuilder.append(l1);
    localStringBuilder.append("], MSG_SHOW[");
    localStringBuilder.append(l2);
    localStringBuilder.append("], MSG_RENDER[");
    localStringBuilder.append(l4);
    localStringBuilder.append("], MSG_RESET[");
    localStringBuilder.append(l3);
    localStringBuilder.append("], MSG_FLUSH[");
    localStringBuilder.append(l5);
    localStringBuilder.append("], isBind[");
    localStringBuilder.append(x());
    localStringBuilder.append("], Source[");
    localStringBuilder.append(f());
    localStringBuilder.append(", ");
    localStringBuilder.append(g());
    localStringBuilder.append("], ImgAngle[");
    localStringBuilder.append(z());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public int z()
  {
    if (this.E) {
      try
      {
        this.y = getImgAngle();
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    return this.y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.texture.YUVTexture
 * JD-Core Version:    0.7.0.1
 */