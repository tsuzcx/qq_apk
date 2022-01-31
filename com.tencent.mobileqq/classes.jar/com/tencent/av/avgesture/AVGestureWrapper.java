package com.tencent.av.avgesture;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.os.Build.VERSION;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AVGestureWrapper
{
  public static final String AppVersion = "7.2.0";
  public static final String UPLOAD_REPORT_DETAILED = "0X80083AD";
  public static final String UPLOAD_REPORT_OK = "0X800839C";
  public static final String UPLOAD_REPORT_START = "0X800839B";
  private static final AVCosUpload cos = ;
  static String mFilePath;
  public static AVUploadReport mReport;
  public static final int sImgFmtBGRA = 1;
  public static final int sImgFmtI420 = 3;
  public static final int sImgFmtNV21 = 2;
  public static final int sImgFmtRGBA = 0;
  private long mGestureRecognizor = 0L;
  
  public AVGestureWrapper()
  {
    this(null);
  }
  
  public AVGestureWrapper(Context paramContext)
  {
    int i = 0;
    if (paramContext != null) {
      i = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion;
    }
    setDeviceInfo("" + Build.VERSION.SDK_INT, Build.MANUFACTURER + ":" + Build.MODEL, i);
  }
  
  public static native void clearCache();
  
  private static native long createRecognizor(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native void destroyRecognizor(long paramLong);
  
  private static native boolean doCalc(long paramLong);
  
  private static native boolean doCalc(long paramLong, boolean paramBoolean);
  
  public static native int getFcnInputHeight();
  
  public static native int getFcnInputWidth();
  
  private static native String getGestureType(long paramLong);
  
  private static native float[] getHotRegion(long paramLong);
  
  private static native float[] getHotRegionInOriginImg(long paramLong);
  
  public static native byte[] getInputRGBA(long paramLong);
  
  private static native float[] getKeyPoints(long paramLong);
  
  private static native float[] getKeyPointsByName(long paramLong, String paramString);
  
  public static native String getMultiSign(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public static native String getParamTips();
  
  public static native String getVersionInfo();
  
  /* Error */
  private static String readFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore 4
    //   5: ldc 81
    //   7: astore_3
    //   8: new 142	java/io/BufferedReader
    //   11: dup
    //   12: new 144	java/io/InputStreamReader
    //   15: dup
    //   16: new 146	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 149	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   24: ldc 151
    //   26: invokespecial 154	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   29: invokespecial 157	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   32: astore_2
    //   33: aload_3
    //   34: astore_0
    //   35: aload_2
    //   36: invokevirtual 160	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +27 -> 68
    //   44: new 78	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   51: aload_0
    //   52: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore_1
    //   63: aload_1
    //   64: astore_0
    //   65: goto -30 -> 35
    //   68: aload_2
    //   69: invokevirtual 163	java/io/BufferedReader:close	()V
    //   72: aload_2
    //   73: ifnull +80 -> 153
    //   76: aload_2
    //   77: invokevirtual 163	java/io/BufferedReader:close	()V
    //   80: aload_0
    //   81: astore_1
    //   82: aload_1
    //   83: areturn
    //   84: astore_1
    //   85: aload_1
    //   86: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   89: aload_0
    //   90: areturn
    //   91: astore_1
    //   92: aload 4
    //   94: astore_2
    //   95: aload_3
    //   96: astore_0
    //   97: aload_1
    //   98: astore_3
    //   99: aload_2
    //   100: astore_1
    //   101: aload_3
    //   102: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   105: aload_0
    //   106: astore_1
    //   107: aload_2
    //   108: ifnull -26 -> 82
    //   111: aload_2
    //   112: invokevirtual 163	java/io/BufferedReader:close	()V
    //   115: aload_0
    //   116: areturn
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   122: aload_0
    //   123: areturn
    //   124: astore_0
    //   125: aload_1
    //   126: ifnull +7 -> 133
    //   129: aload_1
    //   130: invokevirtual 163	java/io/BufferedReader:close	()V
    //   133: aload_0
    //   134: athrow
    //   135: astore_1
    //   136: aload_1
    //   137: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   140: goto -7 -> 133
    //   143: astore_0
    //   144: aload_2
    //   145: astore_1
    //   146: goto -21 -> 125
    //   149: astore_3
    //   150: goto -51 -> 99
    //   153: aload_0
    //   154: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramString	String
    //   1	82	1	str	String
    //   84	2	1	localIOException1	java.io.IOException
    //   91	7	1	localIOException2	java.io.IOException
    //   100	7	1	localObject1	Object
    //   117	13	1	localIOException3	java.io.IOException
    //   135	2	1	localIOException4	java.io.IOException
    //   145	1	1	localObject2	Object
    //   32	113	2	localObject3	Object
    //   7	95	3	localObject4	Object
    //   149	1	3	localIOException5	java.io.IOException
    //   3	90	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   76	80	84	java/io/IOException
    //   8	33	91	java/io/IOException
    //   111	115	117	java/io/IOException
    //   8	33	124	finally
    //   101	105	124	finally
    //   129	133	135	java/io/IOException
    //   35	40	143	finally
    //   44	63	143	finally
    //   68	72	143	finally
    //   35	40	149	java/io/IOException
    //   44	63	149	java/io/IOException
    //   68	72	149	java/io/IOException
  }
  
  public static void setAVGestureReport(AVUploadReport paramAVUploadReport)
  {
    mReport = paramAVUploadReport;
  }
  
  private static native void setCnnThresHold(float paramFloat);
  
  private static native void setDeviceInfo(String paramString1, String paramString2, int paramInt);
  
  private static native void setDilateKernelSize(int paramInt);
  
  private static native void setDilateKernelSizeAfterCrop(int paramInt);
  
  private static native void setErodeKernelSize(int paramInt);
  
  private static native void setFcnMinSize(int paramInt);
  
  private static native void setFcnThresHold(int paramInt, float paramFloat);
  
  public static native boolean setFilePath(String paramString1, String paramString2, String paramString3);
  
  public static boolean setGlobalConfigFile(String paramString)
  {
    mFilePath = paramString;
    paramString = readFile(paramString + "/global.config");
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("cnnThresHold")) {
        setCnnThresHold((float)paramString.getDouble("cnnThresHold"));
      }
      if (paramString.has("fcnThresHold"))
      {
        JSONArray localJSONArray = paramString.getJSONArray("fcnThresHold");
        int i = 0;
        while (i < localJSONArray.length())
        {
          setFcnThresHold(i, (float)localJSONArray.getDouble(i));
          i += 1;
        }
      }
      if (paramString.has("dilate")) {
        setDilateKernelSize(paramString.getInt("dilate"));
      }
      if (paramString.has("erode")) {
        setErodeKernelSize(paramString.getInt("erode"));
      }
      if (paramString.has("fcnMinSize")) {
        setFcnMinSize(paramString.getInt("fcnMinSize"));
      }
      if (paramString.has("dilateAfterCrop")) {
        setDilateKernelSizeAfterCrop(paramString.getInt("dilateAfterCrop"));
      }
      if (paramString.has("hotPointRate")) {
        setHotPointRate((float)paramString.getDouble("hotPointRate"));
      }
      if (paramString.has("skinColorRate")) {
        setSkinColorRate((float)paramString.getDouble("skinColorRate"));
      }
      return true;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private static native void setHotPointRate(float paramFloat);
  
  public static void setShouldUpload(boolean paramBoolean)
  {
    cos.ShouldUpload = paramBoolean;
  }
  
  private static native void setSkinColorRate(float paramFloat);
  
  public void destroyRecognizor()
  {
    if (this.mGestureRecognizor != 0L)
    {
      destroyRecognizor(this.mGestureRecognizor);
      this.mGestureRecognizor = 0L;
    }
  }
  
  public boolean doCalc(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return doCalc(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, true);
  }
  
  public boolean doCalc(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    destroyRecognizor();
    this.mGestureRecognizor = createRecognizor(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
    paramBoolean = doCalc(this.mGestureRecognizor, paramBoolean);
    if ((paramBoolean) && (cos.ShouldUpload))
    {
      paramArrayOfByte = getGestureType(this.mGestureRecognizor);
      byte[] arrayOfByte = getInputRGBA(this.mGestureRecognizor);
      paramInt1 = getFcnInputWidth();
      paramInt2 = getFcnInputHeight();
      AVCosUpload.createInstance().uploadFile(mFilePath, paramArrayOfByte, arrayOfByte, paramInt1, paramInt2, new AVCosUpload.UploadFileListener()
      {
        public void onCompleted(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          if (AVGestureWrapper.mReport != null)
          {
            AVGestureWrapper.mReport.avGestureUploadReport("0X80083AD", String.valueOf(paramAnonymousInt));
            if (paramAnonymousInt == 0) {
              AVGestureWrapper.mReport.avGestureUploadReport("0X800839C", "0");
            }
          }
        }
      });
    }
    return paramBoolean;
  }
  
  public String getGestureType()
  {
    return getGestureType(this.mGestureRecognizor);
  }
  
  public RectF getHotRegion()
  {
    float[] arrayOfFloat = getHotRegion(this.mGestureRecognizor);
    return new RectF(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
  }
  
  public RectF getHotRegionInOriginImg()
  {
    float[] arrayOfFloat = getHotRegionInOriginImg(this.mGestureRecognizor);
    return new RectF(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[0] + arrayOfFloat[2], arrayOfFloat[1] + arrayOfFloat[3]);
  }
  
  public PointF getKeyPointByName(String paramString)
  {
    paramString = getKeyPointsByName(this.mGestureRecognizor, paramString);
    PointF localPointF = new PointF();
    localPointF.x = paramString[1];
    localPointF.y = paramString[0];
    return localPointF;
  }
  
  public PointF[] getKeyPoints()
  {
    float[] arrayOfFloat = getKeyPoints(this.mGestureRecognizor);
    PointF[] arrayOfPointF = new PointF[arrayOfFloat.length / 2];
    int i = 0;
    while (i < arrayOfFloat.length)
    {
      arrayOfPointF[i] = new PointF(arrayOfFloat[(i + 1)], arrayOfFloat[i]);
      i += 2;
    }
    return arrayOfPointF;
  }
  
  public static abstract interface AVUploadReport
  {
    public abstract void avGestureUploadReport(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.avgesture.AVGestureWrapper
 * JD-Core Version:    0.7.0.1
 */