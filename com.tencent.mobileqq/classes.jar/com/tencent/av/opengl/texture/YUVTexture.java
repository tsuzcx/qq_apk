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
  public static float[] a;
  static boolean jdField_b_of_type_Boolean = false;
  public float a;
  private long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  private GLRenderListener jdField_a_of_type_ComTencentAvcoreJniRenderGLRenderListener;
  private final RenderTextureJni jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni;
  private final String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  public float b;
  private long jdField_b_of_type_Long;
  protected float[] b;
  private long jdField_c_of_type_Long;
  boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  volatile boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  protected int k;
  protected int l;
  protected int m;
  public int n;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 1.0F, 1.0F, 0.0F, 0.00093F, -0.3437F, 1.77216F, 0.0F, 1.401687F, -0.71417F, 0.00099F, 0.0F, -0.7011F, 0.525F, -0.8828F, 1.0F };
  }
  
  /* Error */
  public YUVTexture(Context paramContext, String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: iconst_0
    //   3: invokespecial 53	com/tencent/av/opengl/texture/BasicTexture:<init>	(Lcom/tencent/av/opengl/glrenderer/GLCanvas;I)V
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield 55	com/tencent/av/opengl/texture/YUVTexture:jdField_a_of_type_Boolean	Z
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
    //   34: ldc 29
    //   36: fastore
    //   37: dup
    //   38: iconst_5
    //   39: ldc 30
    //   41: fastore
    //   42: dup
    //   43: bipush 6
    //   45: ldc 31
    //   47: fastore
    //   48: dup
    //   49: bipush 7
    //   51: fconst_0
    //   52: fastore
    //   53: dup
    //   54: bipush 8
    //   56: ldc 32
    //   58: fastore
    //   59: dup
    //   60: bipush 9
    //   62: ldc 33
    //   64: fastore
    //   65: dup
    //   66: bipush 10
    //   68: ldc 34
    //   70: fastore
    //   71: dup
    //   72: bipush 11
    //   74: fconst_0
    //   75: fastore
    //   76: dup
    //   77: bipush 12
    //   79: ldc 35
    //   81: fastore
    //   82: dup
    //   83: bipush 13
    //   85: ldc 36
    //   87: fastore
    //   88: dup
    //   89: bipush 14
    //   91: ldc 37
    //   93: fastore
    //   94: dup
    //   95: bipush 15
    //   97: fconst_1
    //   98: fastore
    //   99: putfield 57	com/tencent/av/opengl/texture/YUVTexture:jdField_b_of_type_ArrayOfFloat	[F
    //   102: aload_0
    //   103: ldc 58
    //   105: putfield 60	com/tencent/av/opengl/texture/YUVTexture:jdField_a_of_type_Float	F
    //   108: aload_0
    //   109: ldc 61
    //   111: putfield 63	com/tencent/av/opengl/texture/YUVTexture:jdField_b_of_type_Float	F
    //   114: aload_0
    //   115: iconst_1
    //   116: putfield 65	com/tencent/av/opengl/texture/YUVTexture:jdField_c_of_type_Boolean	Z
    //   119: aload_0
    //   120: iconst_1
    //   121: putfield 67	com/tencent/av/opengl/texture/YUVTexture:jdField_d_of_type_Boolean	Z
    //   124: aload_0
    //   125: iconst_m1
    //   126: putfield 69	com/tencent/av/opengl/texture/YUVTexture:k	I
    //   129: aload_0
    //   130: iconst_0
    //   131: putfield 71	com/tencent/av/opengl/texture/YUVTexture:l	I
    //   134: aload_0
    //   135: iconst_0
    //   136: putfield 73	com/tencent/av/opengl/texture/YUVTexture:m	I
    //   139: aload_0
    //   140: iconst_1
    //   141: putfield 75	com/tencent/av/opengl/texture/YUVTexture:jdField_e_of_type_Boolean	Z
    //   144: aload_0
    //   145: lconst_0
    //   146: putfield 77	com/tencent/av/opengl/texture/YUVTexture:jdField_a_of_type_Long	J
    //   149: aload_0
    //   150: lconst_0
    //   151: putfield 79	com/tencent/av/opengl/texture/YUVTexture:jdField_b_of_type_Long	J
    //   154: aload_0
    //   155: lconst_0
    //   156: putfield 81	com/tencent/av/opengl/texture/YUVTexture:jdField_c_of_type_Long	J
    //   159: aload_0
    //   160: lconst_0
    //   161: putfield 83	com/tencent/av/opengl/texture/YUVTexture:jdField_d_of_type_Long	J
    //   164: aload_0
    //   165: lconst_0
    //   166: putfield 85	com/tencent/av/opengl/texture/YUVTexture:jdField_e_of_type_Long	J
    //   169: aload_0
    //   170: iconst_m1
    //   171: putfield 87	com/tencent/av/opengl/texture/YUVTexture:n	I
    //   174: aload_0
    //   175: aload_1
    //   176: putfield 89	com/tencent/av/opengl/texture/YUVTexture:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   179: aload_0
    //   180: invokestatic 95	com/tencent/av/utils/QAVConfigUtils:h	()Z
    //   183: putfield 65	com/tencent/av/opengl/texture/YUVTexture:jdField_c_of_type_Boolean	Z
    //   186: new 97	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   193: astore 5
    //   195: aload 5
    //   197: ldc 101
    //   199: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 5
    //   205: aload_0
    //   206: getfield 65	com/tencent/av/opengl/texture/YUVTexture:jdField_c_of_type_Boolean	Z
    //   209: invokevirtual 108	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: ldc 110
    //   215: iconst_1
    //   216: aload 5
    //   218: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: bipush 22
    //   226: invokestatic 124	com/tencent/av/utils/AudioHelper:a	(I)I
    //   229: iconst_1
    //   230: if_icmpne +11 -> 241
    //   233: aload_0
    //   234: iconst_1
    //   235: putfield 65	com/tencent/av/opengl/texture/YUVTexture:jdField_c_of_type_Boolean	Z
    //   238: goto +16 -> 254
    //   241: bipush 22
    //   243: invokestatic 124	com/tencent/av/utils/AudioHelper:a	(I)I
    //   246: ifne +8 -> 254
    //   249: aload_0
    //   250: iconst_0
    //   251: putfield 65	com/tencent/av/opengl/texture/YUVTexture:jdField_c_of_type_Boolean	Z
    //   254: new 97	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   261: astore 5
    //   263: aload 5
    //   265: ldc 126
    //   267: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 5
    //   273: aload_0
    //   274: getfield 65	com/tencent/av/opengl/texture/YUVTexture:jdField_c_of_type_Boolean	Z
    //   277: invokevirtual 108	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: ldc 110
    //   283: iconst_1
    //   284: aload 5
    //   286: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: aload_0
    //   293: iconst_1
    //   294: putfield 128	com/tencent/av/opengl/texture/YUVTexture:jdField_a_of_type_Int	I
    //   297: getstatic 41	com/tencent/av/opengl/texture/YUVTexture:jdField_b_of_type_Boolean	Z
    //   300: ifne +26 -> 326
    //   303: aload_1
    //   304: ldc 130
    //   306: iconst_0
    //   307: iconst_0
    //   308: invokestatic 135	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;IZ)Z
    //   311: pop
    //   312: iconst_1
    //   313: putstatic 41	com/tencent/av/opengl/texture/YUVTexture:jdField_b_of_type_Boolean	Z
    //   316: goto +10 -> 326
    //   319: astore 5
    //   321: aload 5
    //   323: invokevirtual 138	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   326: aload_0
    //   327: new 140	com/tencent/avcore/jni/render/RenderTextureJni
    //   330: dup
    //   331: aload_0
    //   332: invokespecial 143	com/tencent/avcore/jni/render/RenderTextureJni:<init>	(Lcom/tencent/avcore/jni/render/IGLRenderTexture;)V
    //   335: putfield 145	com/tencent/av/opengl/texture/YUVTexture:jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni	Lcom/tencent/avcore/jni/render/RenderTextureJni;
    //   338: getstatic 41	com/tencent/av/opengl/texture/YUVTexture:jdField_b_of_type_Boolean	Z
    //   341: ifeq +30 -> 371
    //   344: new 147	java/lang/ref/WeakReference
    //   347: dup
    //   348: aload_0
    //   349: getfield 145	com/tencent/av/opengl/texture/YUVTexture:jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni	Lcom/tencent/avcore/jni/render/RenderTextureJni;
    //   352: invokespecial 150	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   355: astore 5
    //   357: aload_0
    //   358: getfield 145	com/tencent/av/opengl/texture/YUVTexture:jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni	Lcom/tencent/avcore/jni/render/RenderTextureJni;
    //   361: aload_1
    //   362: invokestatic 155	com/tencent/av/opengl/utils/Utils:a	(Landroid/content/Context;)I
    //   365: aload 5
    //   367: lload_3
    //   368: invokevirtual 159	com/tencent/avcore/jni/render/RenderTextureJni:init	(ILjava/lang/Object;J)V
    //   371: new 97	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   378: astore_1
    //   379: aload_1
    //   380: aload_0
    //   381: invokevirtual 165	java/lang/Object:getClass	()Ljava/lang/Class;
    //   384: invokevirtual 170	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   387: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload_1
    //   392: ldc 172
    //   394: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload_1
    //   399: aload_2
    //   400: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload_1
    //   405: ldc 174
    //   407: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload_1
    //   412: aload_0
    //   413: getfield 145	com/tencent/av/opengl/texture/YUVTexture:jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni	Lcom/tencent/avcore/jni/render/RenderTextureJni;
    //   416: invokevirtual 178	com/tencent/avcore/jni/render/RenderTextureJni:getNativeContext	()J
    //   419: invokestatic 184	java/lang/Long:toHexString	(J)Ljava/lang/String;
    //   422: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload_0
    //   427: aload_1
    //   428: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: putfield 186	com/tencent/av/opengl/texture/YUVTexture:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   434: return
    //   435: astore_1
    //   436: goto +35 -> 471
    //   439: astore_1
    //   440: aload_1
    //   441: invokevirtual 187	java/lang/Error:printStackTrace	()V
    //   444: new 97	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   451: astore_1
    //   452: goto -73 -> 379
    //   455: astore_1
    //   456: aload_1
    //   457: invokevirtual 188	java/lang/Exception:printStackTrace	()V
    //   460: new 97	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   467: astore_1
    //   468: goto -89 -> 379
    //   471: new 97	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   478: astore 5
    //   480: aload 5
    //   482: aload_0
    //   483: invokevirtual 165	java/lang/Object:getClass	()Ljava/lang/Class;
    //   486: invokevirtual 170	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   489: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload 5
    //   495: ldc 172
    //   497: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload 5
    //   503: aload_2
    //   504: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload 5
    //   510: ldc 174
    //   512: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload 5
    //   518: aload_0
    //   519: getfield 145	com/tencent/av/opengl/texture/YUVTexture:jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni	Lcom/tencent/avcore/jni/render/RenderTextureJni;
    //   522: invokevirtual 178	com/tencent/avcore/jni/render/RenderTextureJni:getNativeContext	()J
    //   525: invokestatic 184	java/lang/Long:toHexString	(J)Ljava/lang/String;
    //   528: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload_0
    //   533: aload 5
    //   535: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: putfield 186	com/tencent/av/opengl/texture/YUVTexture:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
  
  /* Error */
  public int a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: sipush 3553
    //   3: iload_2
    //   4: invokestatic 199	android/opengl/GLES20:glBindTexture	(II)V
    //   7: sipush 3553
    //   10: sipush 10241
    //   13: ldc 200
    //   15: invokestatic 204	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   18: sipush 3553
    //   21: sipush 10240
    //   24: ldc 205
    //   26: invokestatic 204	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   29: sipush 3553
    //   32: sipush 10242
    //   35: ldc 206
    //   37: invokestatic 204	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   40: sipush 3553
    //   43: sipush 10243
    //   46: ldc 206
    //   48: invokestatic 204	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   51: aload_0
    //   52: getfield 89	com/tencent/av/opengl/texture/YUVTexture:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   55: invokevirtual 212	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   58: iload_1
    //   59: invokevirtual 218	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   62: astore_3
    //   63: aload_3
    //   64: invokestatic 224	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   67: astore 4
    //   69: aload_3
    //   70: invokevirtual 229	java/io/InputStream:close	()V
    //   73: goto +8 -> 81
    //   76: astore_3
    //   77: aload_3
    //   78: invokevirtual 230	java/io/IOException:printStackTrace	()V
    //   81: aload 4
    //   83: ifnull +20 -> 103
    //   86: sipush 3553
    //   89: iconst_0
    //   90: aload 4
    //   92: iconst_0
    //   93: invokestatic 236	android/opengl/GLUtils:texImage2D	(IILandroid/graphics/Bitmap;I)V
    //   96: aload 4
    //   98: invokevirtual 241	android/graphics/Bitmap:recycle	()V
    //   101: iload_2
    //   102: ireturn
    //   103: iconst_m1
    //   104: ireturn
    //   105: astore 4
    //   107: aload_3
    //   108: invokevirtual 229	java/io/InputStream:close	()V
    //   111: goto +8 -> 119
    //   114: astore_3
    //   115: aload_3
    //   116: invokevirtual 230	java/io/IOException:printStackTrace	()V
    //   119: aload 4
    //   121: athrow
    //   122: aload_3
    //   123: invokevirtual 229	java/io/InputStream:close	()V
    //   126: iconst_m1
    //   127: ireturn
    //   128: astore_3
    //   129: aload_3
    //   130: invokevirtual 230	java/io/IOException:printStackTrace	()V
    //   133: iconst_m1
    //   134: ireturn
    //   135: astore 4
    //   137: goto -15 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	YUVTexture
    //   0	140	1	paramInt1	int
    //   0	140	2	paramInt2	int
    //   62	8	3	localInputStream	java.io.InputStream
    //   76	32	3	localIOException1	java.io.IOException
    //   114	9	3	localIOException2	java.io.IOException
    //   128	2	3	localIOException3	java.io.IOException
    //   67	30	4	localBitmap	android.graphics.Bitmap
    //   105	15	4	localObject	Object
    //   135	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   69	73	76	java/io/IOException
    //   63	69	105	finally
    //   107	111	114	java/io/IOException
    //   122	126	128	java/io/IOException
    //   63	69	135	java/lang/OutOfMemoryError
  }
  
  public RenderTextureJni a()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni;
  }
  
  public String a()
  {
    long l5 = System.currentTimeMillis();
    long l1 = this.jdField_a_of_type_Long;
    if (l1 != 0L) {
      l1 = l5 - l1;
    } else {
      l1 = -1L;
    }
    long l2 = this.jdField_b_of_type_Long;
    if (l2 != 0L) {
      l2 = l5 - l2;
    } else {
      l2 = -1L;
    }
    long l3 = this.jdField_c_of_type_Long;
    if (l3 != 0L) {
      l3 = l5 - l3;
    } else {
      l3 = -1L;
    }
    long l4 = this.jdField_d_of_type_Long;
    if (l4 != 0L) {
      l4 = l5 - l4;
    } else {
      l4 = -1L;
    }
    long l6 = this.jdField_e_of_type_Long;
    if (l6 != 0L) {
      l5 -= l6;
    } else {
      l5 = -1L;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAG[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
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
    localStringBuilder.append(e());
    localStringBuilder.append("], Source[");
    localStringBuilder.append(c());
    localStringBuilder.append(", ");
    localStringBuilder.append(d());
    localStringBuilder.append("], ImgAngle[");
    localStringBuilder.append(j());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void a(GLRenderListener paramGLRenderListener)
  {
    this.jdField_a_of_type_ComTencentAvcoreJniRenderGLRenderListener = paramGLRenderListener;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "setIsBind, old[%s], new[%s]", Boolean.valueOf(this.jdField_e_of_type_Boolean), Boolean.valueOf(paramBoolean) });
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(GLCanvas paramGLCanvas)
  {
    if (AudioHelper.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    boolean bool2 = c();
    boolean bool1 = false;
    if (!bool2)
    {
      if (this.jdField_a_of_type_ArrayOfInt == null) {
        this.jdField_a_of_type_ArrayOfInt = new int[3];
      }
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        this.jdField_a_of_type_ArrayOfInt[i] = paramGLCanvas.a().a();
        i += 1;
      }
      i = 1;
    }
    else
    {
      i = 0;
    }
    TextureProgram localTextureProgram = a();
    if (this.jdField_e_of_type_Boolean)
    {
      if (this.jdField_c_of_type_Boolean) {
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_d_of_type_Boolean = false;
        }
        else
        {
          j = 0;
          break label125;
        }
      }
      int j = 1;
      label125:
      if ((j != 0) || (i != 0))
      {
        e();
        i = uploadContent(this.jdField_a_of_type_ArrayOfInt);
        break label151;
      }
    }
    int i = -1;
    label151:
    if (i != -1) {
      this.k = i;
    }
    if (this.k != -1) {
      GLES20.glUniform1i(localTextureProgram.a()[10].jdField_a_of_type_Int, this.k);
    }
    this.jdField_b_of_type_Int = 1;
    if ((this.jdField_a_of_type_Boolean) && (this.n == -1))
    {
      this.n = paramGLCanvas.a().a();
      this.n = a(2130840317, this.n);
    }
    if (this.k != -1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public byte[] a()
  {
    return getCaptureFrameTexture();
  }
  
  public ShaderParameter[] a(GLCanvas paramGLCanvas)
  {
    TextureProgram localTextureProgram = a();
    paramGLCanvas = super.a(paramGLCanvas);
    try
    {
      GLES20.glUniform1f(localTextureProgram.a()[7].jdField_a_of_type_Int, getImgWidth());
      GLES20.glUniform1f(localTextureProgram.a()[8].jdField_a_of_type_Int, getImgHeight());
      GLES20.glUniformMatrix4fv(localTextureProgram.a()[9].jdField_a_of_type_Int, 1, false, this.jdField_b_of_type_ArrayOfFloat, 0);
      if ((this.jdField_a_of_type_Boolean) && (this.n != -1))
      {
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glActiveTexture(33987);
        Utils.a();
        GLES20.glBindTexture(g(), this.n);
        Utils.a();
        GLES20.glUniform1i(localTextureProgram.a()[11].jdField_a_of_type_Int, 3);
        Utils.a();
        GLES20.glUniform1i(localTextureProgram.a()[12].jdField_a_of_type_Int, 1);
        Utils.a();
      }
      return paramGLCanvas;
    }
    catch (Exception localException) {}
    return paramGLCanvas;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean canRender()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.canRender();
  }
  
  public void e()
  {
    onFaceFeatureUpdate(getFaceFeature());
  }
  
  public boolean e()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public void flush(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.flush(paramBoolean);
  }
  
  public int g()
  {
    return 3553;
  }
  
  public int getCaptureFrameHeight()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.getCaptureFrameHeight();
  }
  
  public byte[] getCaptureFrameTexture()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.getCaptureFrameTexture();
  }
  
  public int getCaptureFrameWidth()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.getCaptureFrameWidth();
  }
  
  public byte[] getFaceFeature()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.getFaceFeature();
  }
  
  public byte[] getFrameTexture()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.getFrameTexture();
  }
  
  public int getImgAngle()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.getImgAngle();
  }
  
  public int getImgHeight()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.getImgHeight();
  }
  
  public int getImgWidth()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.getImgWidth();
  }
  
  public int h()
  {
    return getCaptureFrameWidth();
  }
  
  public int i()
  {
    return getCaptureFrameHeight();
  }
  
  public int j()
  {
    if (this.jdField_e_of_type_Boolean) {
      try
      {
        this.l = getImgAngle();
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    return this.l;
  }
  
  public int k()
  {
    return this.k;
  }
  
  public void markForPerf(int paramInt)
  {
    if (paramInt == 0)
    {
      if (AudioHelper.jdField_b_of_type_Boolean) {
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
    }
    else if (paramInt == 2)
    {
      if (AudioHelper.jdField_b_of_type_Boolean) {
        this.jdField_d_of_type_Long = System.currentTimeMillis();
      }
    }
    else if (paramInt == 1)
    {
      if (AudioHelper.jdField_b_of_type_Boolean) {
        this.jdField_e_of_type_Long = System.currentTimeMillis();
      }
    }
    else if ((paramInt == 3) && (AudioHelper.jdField_b_of_type_Boolean)) {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void nativeFrameDataUpdate()
  {
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void onFaceFeatureUpdate(byte[] paramArrayOfByte)
  {
    GLRenderListener localGLRenderListener = this.jdField_a_of_type_ComTencentAvcoreJniRenderGLRenderListener;
    if ((localGLRenderListener != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      localGLRenderListener.onFaceFeatureUpdate(paramArrayOfByte);
    }
  }
  
  public void onPause()
  {
    this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.onPause();
  }
  
  public void onRenderFlush()
  {
    GLRenderListener localGLRenderListener = this.jdField_a_of_type_ComTencentAvcoreJniRenderGLRenderListener;
    if (localGLRenderListener != null) {
      localGLRenderListener.onRenderFlush();
    }
  }
  
  public void onRenderFrame()
  {
    GLRenderListener localGLRenderListener = this.jdField_a_of_type_ComTencentAvcoreJniRenderGLRenderListener;
    if (localGLRenderListener != null) {
      localGLRenderListener.onRenderFrame();
    }
  }
  
  public void onRenderInfoNotify(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GLRenderListener localGLRenderListener = this.jdField_a_of_type_ComTencentAvcoreJniRenderGLRenderListener;
    if (localGLRenderListener != null) {
      localGLRenderListener.onRenderInfoNotify(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onRenderReset()
  {
    GLRenderListener localGLRenderListener = this.jdField_a_of_type_ComTencentAvcoreJniRenderGLRenderListener;
    if (localGLRenderListener != null) {
      localGLRenderListener.onRenderReset();
    }
  }
  
  public void onResume()
  {
    this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.onResume();
  }
  
  public boolean updateCurFrame()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.updateCurFrame();
  }
  
  public int uploadContent(int[] paramArrayOfInt)
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.uploadContent(paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.texture.YUVTexture
 * JD-Core Version:    0.7.0.1
 */