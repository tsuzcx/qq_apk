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
  public static AVGestureWrapper.AVUploadReport mReport;
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
    int i;
    if (paramContext != null) {
      i = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion;
    } else {
      i = 0;
    }
    paramContext = new StringBuilder();
    paramContext.append("");
    paramContext.append(Build.VERSION.SDK_INT);
    paramContext = paramContext.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append(":");
    localStringBuilder.append(Build.MODEL);
    setDeviceInfo(paramContext, localStringBuilder.toString(), i);
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
    //   0: ldc 76
    //   2: astore_3
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_1
    //   8: new 137	java/io/BufferedReader
    //   11: dup
    //   12: new 139	java/io/InputStreamReader
    //   15: dup
    //   16: new 141	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 144	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   24: ldc 146
    //   26: invokespecial 149	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   29: invokespecial 152	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   32: astore_2
    //   33: aload_3
    //   34: astore_0
    //   35: aload_2
    //   36: invokevirtual 155	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +33 -> 74
    //   44: new 73	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   51: astore_3
    //   52: aload_3
    //   53: aload_0
    //   54: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_3
    //   59: aload_1
    //   60: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_3
    //   65: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore_1
    //   69: aload_1
    //   70: astore_0
    //   71: goto -36 -> 35
    //   74: aload_2
    //   75: invokevirtual 158	java/io/BufferedReader:close	()V
    //   78: aload_0
    //   79: astore_1
    //   80: aload_2
    //   81: invokevirtual 158	java/io/BufferedReader:close	()V
    //   84: aload_0
    //   85: areturn
    //   86: astore_0
    //   87: aload_0
    //   88: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   91: aload_1
    //   92: areturn
    //   93: astore_0
    //   94: aload_2
    //   95: astore_1
    //   96: goto +38 -> 134
    //   99: astore 4
    //   101: goto +14 -> 115
    //   104: astore_0
    //   105: goto +29 -> 134
    //   108: astore 4
    //   110: aload 5
    //   112: astore_2
    //   113: aload_3
    //   114: astore_0
    //   115: aload_2
    //   116: astore_1
    //   117: aload 4
    //   119: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   122: aload_2
    //   123: ifnull +9 -> 132
    //   126: aload_0
    //   127: astore_1
    //   128: aload_2
    //   129: invokevirtual 158	java/io/BufferedReader:close	()V
    //   132: aload_0
    //   133: areturn
    //   134: aload_1
    //   135: ifnull +15 -> 150
    //   138: aload_1
    //   139: invokevirtual 158	java/io/BufferedReader:close	()V
    //   142: goto +8 -> 150
    //   145: astore_1
    //   146: aload_1
    //   147: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   150: goto +5 -> 155
    //   153: aload_0
    //   154: athrow
    //   155: goto -2 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramString	String
    //   7	132	1	localObject1	Object
    //   145	2	1	localIOException1	java.io.IOException
    //   32	97	2	localObject2	Object
    //   2	112	3	localObject3	Object
    //   99	1	4	localIOException2	java.io.IOException
    //   108	10	4	localIOException3	java.io.IOException
    //   4	107	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   80	84	86	java/io/IOException
    //   128	132	86	java/io/IOException
    //   35	40	93	finally
    //   44	69	93	finally
    //   74	78	93	finally
    //   35	40	99	java/io/IOException
    //   44	69	99	java/io/IOException
    //   74	78	99	java/io/IOException
    //   8	33	104	finally
    //   117	122	104	finally
    //   8	33	108	java/io/IOException
    //   138	142	145	java/io/IOException
  }
  
  public static void setAVGestureReport(AVGestureWrapper.AVUploadReport paramAVUploadReport)
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("/global.config");
    paramString = readFile(((StringBuilder)localObject).toString());
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("cnnThresHold")) {
        setCnnThresHold((float)paramString.getDouble("cnnThresHold"));
      }
      if (paramString.has("fcnThresHold"))
      {
        localObject = paramString.getJSONArray("fcnThresHold");
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          setFcnThresHold(i, (float)((JSONArray)localObject).getDouble(i));
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
    long l = this.mGestureRecognizor;
    if (l != 0L)
    {
      destroyRecognizor(l);
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
      AVCosUpload.createInstance().uploadFile(mFilePath, paramArrayOfByte, arrayOfByte, paramInt1, paramInt2, new AVGestureWrapper.1(this));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.avgesture.AVGestureWrapper
 * JD-Core Version:    0.7.0.1
 */