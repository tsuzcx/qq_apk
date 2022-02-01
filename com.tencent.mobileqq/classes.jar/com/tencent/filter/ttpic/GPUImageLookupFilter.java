package com.tencent.filter.ttpic;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.encrypt.FileEncryptUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class GPUImageLookupFilter
  extends BaseFilter
{
  public static final String LOOKUP_FRAGMENT_SHADER1 = "varying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform lowp float alpha;\nvoid main() {\nhighp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\nhighp float blueColor = textureColor.b * 63.0;\nhighp vec2 quad1; quad1.y = floor(floor(blueColor) / 8.0);\nquad1.x = floor(blueColor) - (quad1.y * 8.0);\nhighp vec2 quad2;\nquad2.y = floor(ceil(blueColor) / 8.0);\nquad2.x = ceil(blueColor) - (quad2.y * 8.0);\nhighp vec2 texPos1;\ntexPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\ntexPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\nhighp vec2 texPos2;\ntexPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\ntexPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\nlowp vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\nlowp vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\nlowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\nnewColor = mix(newColor, textureColor, alpha);\ngl_FragColor = vec4(newColor.rgb, textureColor.w);\n}\n";
  public static String jarPath;
  private String thisPath = "";
  
  public GPUImageLookupFilter()
  {
    this(null);
  }
  
  public GPUImageLookupFilter(String paramString)
  {
    super("varying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform lowp float alpha;\nvoid main() {\nhighp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\nhighp float blueColor = textureColor.b * 63.0;\nhighp vec2 quad1; quad1.y = floor(floor(blueColor) / 8.0);\nquad1.x = floor(blueColor) - (quad1.y * 8.0);\nhighp vec2 quad2;\nquad2.y = floor(ceil(blueColor) / 8.0);\nquad2.x = ceil(blueColor) - (quad2.y * 8.0);\nhighp vec2 texPos1;\ntexPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\ntexPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\nhighp vec2 texPos2;\ntexPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\ntexPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\nlowp vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\nlowp vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\nlowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\nnewColor = mix(newColor, textureColor, alpha);\ngl_FragColor = vec4(newColor.rgb, textureColor.w);\n}\n");
    initParams(paramString);
  }
  
  private Bitmap decodeBitmap(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      Object localObject = new FileInputStream(new File(paramString));
      break label31;
      localObject = BitmapUtils.getInputStreamByName(FileUtils.getRealPath(paramString));
      label31:
      if (localObject == null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodeBitmap  getStream ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" not exist");
        LogUtils.e("BitmapUtils", localStringBuilder.toString());
      }
      paramString = FileEncryptUtils.decryptFile((InputStream)localObject);
      try
      {
        IOUtils.closeQuietly((InputStream)localObject);
      }
      catch (Exception localException1) {}
      LogUtils.e("BitmapUtils", "decodeBitmap  getStream", localException2, new Object[0]);
    }
    catch (Exception localException2)
    {
      paramString = null;
    }
    if (paramString == null) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    try
    {
      paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length, localOptions);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      LogUtils.e("BitmapUtils", "decodeByteArray", paramString, new Object[0]);
    }
    return null;
  }
  
  /* Error */
  private Bitmap decodeJarBitmap(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 117	java/util/jar/JarFile
    //   5: dup
    //   6: getstatic 119	com/tencent/filter/ttpic/GPUImageLookupFilter:jarPath	Ljava/lang/String;
    //   9: invokespecial 120	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   12: astore_2
    //   13: new 53	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   20: astore 4
    //   22: aload 4
    //   24: ldc 122
    //   26: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 4
    //   32: aload_1
    //   33: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_2
    //   38: aload 4
    //   40: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokevirtual 126	java/util/jar/JarFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +31 -> 79
    //   51: aload_2
    //   52: aload_1
    //   53: invokevirtual 130	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   56: astore_1
    //   57: aload_2
    //   58: astore_3
    //   59: aload_1
    //   60: astore 4
    //   62: aload_1
    //   63: invokestatic 81	com/tencent/ttpic/baseutils/encrypt/FileEncryptUtils:decryptFile	(Ljava/io/InputStream;)[B
    //   66: astore 5
    //   68: aload 5
    //   70: astore_3
    //   71: goto +12 -> 83
    //   74: astore 5
    //   76: goto +61 -> 137
    //   79: aconst_null
    //   80: astore_1
    //   81: aload_1
    //   82: astore_3
    //   83: aload_1
    //   84: ifnull +15 -> 99
    //   87: aload_1
    //   88: invokevirtual 135	java/io/InputStream:close	()V
    //   91: goto +8 -> 99
    //   94: astore_1
    //   95: aload_1
    //   96: invokestatic 138	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   99: aload_2
    //   100: invokevirtual 139	java/util/jar/JarFile:close	()V
    //   103: goto +78 -> 181
    //   106: astore_1
    //   107: aload_1
    //   108: invokestatic 138	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   111: goto +70 -> 181
    //   114: astore_1
    //   115: goto +119 -> 234
    //   118: astore 5
    //   120: aconst_null
    //   121: astore_1
    //   122: goto +15 -> 137
    //   125: astore_1
    //   126: aconst_null
    //   127: astore_2
    //   128: goto +106 -> 234
    //   131: astore 5
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_1
    //   136: astore_2
    //   137: aload_2
    //   138: astore_3
    //   139: aload_1
    //   140: astore 4
    //   142: aload 5
    //   144: invokestatic 138	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   147: aload_1
    //   148: ifnull +15 -> 163
    //   151: aload_1
    //   152: invokevirtual 135	java/io/InputStream:close	()V
    //   155: goto +8 -> 163
    //   158: astore_1
    //   159: aload_1
    //   160: invokestatic 138	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   163: aload_2
    //   164: ifnull +15 -> 179
    //   167: aload_2
    //   168: invokevirtual 139	java/util/jar/JarFile:close	()V
    //   171: goto +8 -> 179
    //   174: astore_1
    //   175: aload_1
    //   176: invokestatic 138	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   179: aconst_null
    //   180: astore_3
    //   181: aload_3
    //   182: ifnonnull +5 -> 187
    //   185: aconst_null
    //   186: areturn
    //   187: new 96	android/graphics/BitmapFactory$Options
    //   190: dup
    //   191: invokespecial 97	android/graphics/BitmapFactory$Options:<init>	()V
    //   194: astore_1
    //   195: aload_1
    //   196: getstatic 103	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   199: putfield 106	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   202: aload_3
    //   203: iconst_0
    //   204: aload_3
    //   205: arraylength
    //   206: aload_1
    //   207: invokestatic 112	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   210: astore_1
    //   211: aload_1
    //   212: areturn
    //   213: astore_1
    //   214: ldc 141
    //   216: ldc 113
    //   218: aload_1
    //   219: iconst_0
    //   220: anewarray 91	java/lang/Object
    //   223: invokestatic 94	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   226: aconst_null
    //   227: areturn
    //   228: astore_1
    //   229: aload_3
    //   230: astore_2
    //   231: aload 4
    //   233: astore_3
    //   234: aload_3
    //   235: ifnull +15 -> 250
    //   238: aload_3
    //   239: invokevirtual 135	java/io/InputStream:close	()V
    //   242: goto +8 -> 250
    //   245: astore_3
    //   246: aload_3
    //   247: invokestatic 138	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   250: aload_2
    //   251: ifnull +15 -> 266
    //   254: aload_2
    //   255: invokevirtual 139	java/util/jar/JarFile:close	()V
    //   258: goto +8 -> 266
    //   261: astore_2
    //   262: aload_2
    //   263: invokestatic 138	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   266: aload_1
    //   267: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	GPUImageLookupFilter
    //   0	268	1	paramString	String
    //   12	243	2	localObject1	Object
    //   261	2	2	localException1	Exception
    //   1	238	3	localObject2	Object
    //   245	2	3	localException2	Exception
    //   20	212	4	localObject3	Object
    //   66	3	5	arrayOfByte	byte[]
    //   74	1	5	localException3	Exception
    //   118	1	5	localException4	Exception
    //   131	12	5	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   62	68	74	java/lang/Exception
    //   87	91	94	java/lang/Exception
    //   99	103	106	java/lang/Exception
    //   13	47	114	finally
    //   51	57	114	finally
    //   13	47	118	java/lang/Exception
    //   51	57	118	java/lang/Exception
    //   2	13	125	finally
    //   2	13	131	java/lang/Exception
    //   151	155	158	java/lang/Exception
    //   167	171	174	java/lang/Exception
    //   202	211	213	java/lang/OutOfMemoryError
    //   62	68	228	finally
    //   142	147	228	finally
    //   238	242	245	java/lang/Exception
    //   254	258	261	java/lang/Exception
  }
  
  private void initParams(String paramString)
  {
    addParam(new UniformParam.FloatParam("alpha", 0.0F));
    if (TextUtils.isEmpty(paramString))
    {
      addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
      return;
    }
    addParam(new TextureResParam("inputImageTexture2", paramString, 33986));
  }
  
  public void setAdjustParam(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("alpha", paramFloat));
  }
  
  public void updateLut(String paramString)
  {
    if (this.thisPath.equals(paramString)) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.thisPath = "";
      paramString = getAndRemoveParam("inputImageTexture2");
      if (paramString != null) {
        paramString.clear();
      }
      return;
    }
    this.thisPath = paramString;
    UniformParam localUniformParam = getAndRemoveParam("inputImageTexture2");
    if (localUniformParam != null) {
      localUniformParam.clear();
    }
    if (jarPath != null) {
      paramString = decodeJarBitmap(paramString);
    } else if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("assets://"))) {
      paramString = decodeBitmap(paramString, true);
    } else {
      paramString = decodeBitmap(paramString, false);
    }
    paramString = new UniformParam.TextureBitmapParam("inputImageTexture2", paramString, 33986, true);
    addParam(paramString);
    paramString.initialParams(getProgramIds());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.GPUImageLookupFilter
 * JD-Core Version:    0.7.0.1
 */