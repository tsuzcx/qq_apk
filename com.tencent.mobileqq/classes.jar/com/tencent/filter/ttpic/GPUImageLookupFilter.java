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
  public static String jarPath = null;
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
    for (;;)
    {
      try
      {
        localObject = new FileInputStream(new File(paramString));
        if (localObject == null) {
          LogUtils.e("BitmapUtils", "decodeBitmap  getStream " + paramString + " not exist");
        }
        paramString = FileEncryptUtils.decryptFile((InputStream)localObject);
      }
      catch (Exception localException1)
      {
        Object localObject;
        paramString = null;
      }
      try
      {
        IOUtils.closeQuietly((InputStream)localObject);
        if (paramString != null) {
          break;
        }
        return null;
      }
      catch (Exception localException2)
      {
        BitmapFactory.Options localOptions;
        break label82;
      }
      localObject = BitmapUtils.getInputStreamByName(FileUtils.getRealPath(paramString));
      continue;
      label82:
      LogUtils.e("BitmapUtils", "decodeBitmap  getStream", localException1, new Object[0]);
    }
    localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    try
    {
      paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length, localOptions);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      LogUtils.e("BitmapUtils", "decodeByteArray", paramString, new Object[0]);
      return null;
    }
  }
  
  /* Error */
  private Bitmap decodeJarBitmap(String paramString)
  {
    // Byte code:
    //   0: new 119	java/util/jar/JarFile
    //   3: dup
    //   4: getstatic 14	com/tencent/filter/ttpic/GPUImageLookupFilter:jarPath	Ljava/lang/String;
    //   7: invokespecial 120	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +265 -> 277
    //   15: aload_2
    //   16: new 45	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   23: ldc 122
    //   25: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_1
    //   29: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokevirtual 126	java/util/jar/JarFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +237 -> 277
    //   43: aload_2
    //   44: aload_1
    //   45: invokevirtual 130	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   48: astore_1
    //   49: aload_1
    //   50: astore 4
    //   52: aload_2
    //   53: astore_3
    //   54: aload_1
    //   55: invokestatic 71	com/tencent/ttpic/baseutils/encrypt/FileEncryptUtils:decryptFile	(Ljava/io/InputStream;)[B
    //   58: astore 5
    //   60: aload 5
    //   62: astore_3
    //   63: aload_1
    //   64: astore 4
    //   66: aload_3
    //   67: astore_1
    //   68: aload 4
    //   70: ifnull +8 -> 78
    //   73: aload 4
    //   75: invokevirtual 135	java/io/InputStream:close	()V
    //   78: aload_1
    //   79: astore_3
    //   80: aload_2
    //   81: ifnull +9 -> 90
    //   84: aload_2
    //   85: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   88: aload_1
    //   89: astore_3
    //   90: aload_3
    //   91: ifnonnull +120 -> 211
    //   94: aconst_null
    //   95: areturn
    //   96: astore_3
    //   97: aload_3
    //   98: invokestatic 139	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   101: goto -23 -> 78
    //   104: astore_2
    //   105: aload_2
    //   106: invokestatic 139	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   109: aload_1
    //   110: astore_3
    //   111: goto -21 -> 90
    //   114: astore 5
    //   116: aconst_null
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_2
    //   120: aload_1
    //   121: astore 4
    //   123: aload_2
    //   124: astore_3
    //   125: aload 5
    //   127: invokestatic 139	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   130: aload_1
    //   131: ifnull +7 -> 138
    //   134: aload_1
    //   135: invokevirtual 135	java/io/InputStream:close	()V
    //   138: aload_2
    //   139: ifnull +7 -> 146
    //   142: aload_2
    //   143: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   146: aconst_null
    //   147: astore_3
    //   148: goto -58 -> 90
    //   151: astore_1
    //   152: aload_1
    //   153: invokestatic 139	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   156: goto -18 -> 138
    //   159: astore_1
    //   160: aload_1
    //   161: invokestatic 139	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   164: aconst_null
    //   165: astore_3
    //   166: goto -76 -> 90
    //   169: astore_1
    //   170: aconst_null
    //   171: astore 4
    //   173: aconst_null
    //   174: astore_2
    //   175: aload 4
    //   177: ifnull +8 -> 185
    //   180: aload 4
    //   182: invokevirtual 135	java/io/InputStream:close	()V
    //   185: aload_2
    //   186: ifnull +7 -> 193
    //   189: aload_2
    //   190: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   193: aload_1
    //   194: athrow
    //   195: astore_3
    //   196: aload_3
    //   197: invokestatic 139	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   200: goto -15 -> 185
    //   203: astore_2
    //   204: aload_2
    //   205: invokestatic 139	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   208: goto -15 -> 193
    //   211: new 98	android/graphics/BitmapFactory$Options
    //   214: dup
    //   215: invokespecial 99	android/graphics/BitmapFactory$Options:<init>	()V
    //   218: astore_1
    //   219: aload_1
    //   220: getstatic 105	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   223: putfield 108	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   226: aload_3
    //   227: iconst_0
    //   228: aload_3
    //   229: arraylength
    //   230: aload_1
    //   231: invokestatic 114	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   234: astore_1
    //   235: aload_1
    //   236: areturn
    //   237: astore_1
    //   238: ldc 141
    //   240: ldc 115
    //   242: aload_1
    //   243: iconst_0
    //   244: anewarray 93	java/lang/Object
    //   247: invokestatic 96	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   250: aconst_null
    //   251: areturn
    //   252: astore_1
    //   253: aconst_null
    //   254: astore 4
    //   256: goto -81 -> 175
    //   259: astore_1
    //   260: aload_3
    //   261: astore_2
    //   262: goto -87 -> 175
    //   265: astore 5
    //   267: aconst_null
    //   268: astore_1
    //   269: goto -149 -> 120
    //   272: astore 5
    //   274: goto -154 -> 120
    //   277: aconst_null
    //   278: astore 4
    //   280: aconst_null
    //   281: astore_1
    //   282: goto -214 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	this	GPUImageLookupFilter
    //   0	285	1	paramString	String
    //   10	75	2	localJarFile	java.util.jar.JarFile
    //   104	2	2	localException1	Exception
    //   119	71	2	localObject1	Object
    //   203	2	2	localException2	Exception
    //   261	1	2	localObject2	Object
    //   53	38	3	localObject3	Object
    //   96	2	3	localException3	Exception
    //   110	56	3	localObject4	Object
    //   195	66	3	localException4	Exception
    //   50	229	4	str	String
    //   58	3	5	arrayOfByte	byte[]
    //   114	12	5	localException5	Exception
    //   265	1	5	localException6	Exception
    //   272	1	5	localException7	Exception
    // Exception table:
    //   from	to	target	type
    //   73	78	96	java/lang/Exception
    //   84	88	104	java/lang/Exception
    //   0	11	114	java/lang/Exception
    //   134	138	151	java/lang/Exception
    //   142	146	159	java/lang/Exception
    //   0	11	169	finally
    //   180	185	195	java/lang/Exception
    //   189	193	203	java/lang/Exception
    //   226	235	237	java/lang/OutOfMemoryError
    //   15	39	252	finally
    //   43	49	252	finally
    //   54	60	259	finally
    //   125	130	259	finally
    //   15	39	265	java/lang/Exception
    //   43	49	265	java/lang/Exception
    //   54	60	272	java/lang/Exception
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
    if (this.thisPath.equals(paramString)) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
      this.thisPath = "";
      paramString = getAndRemoveParam("inputImageTexture2");
    } while (paramString == null);
    paramString.clear();
    return;
    this.thisPath = paramString;
    UniformParam localUniformParam = getAndRemoveParam("inputImageTexture2");
    if (localUniformParam != null) {
      localUniformParam.clear();
    }
    if (jarPath != null) {
      paramString = decodeJarBitmap(paramString);
    }
    for (;;)
    {
      paramString = new UniformParam.TextureBitmapParam("inputImageTexture2", paramString, 33986, true);
      addParam(paramString);
      paramString.initialParams(getProgramIds());
      return;
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("assets://"))) {
        paramString = decodeBitmap(paramString, true);
      } else {
        paramString = decodeBitmap(paramString, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.filter.ttpic.GPUImageLookupFilter
 * JD-Core Version:    0.7.0.1
 */