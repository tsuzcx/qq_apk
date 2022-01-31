package com.tencent.av.avgesture;

import android.graphics.PointF;
import android.graphics.RectF;
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
  public static final int sImgFmtRGBA = 0;
  private long mGestureRecognizor;
  
  public AVGestureWrapper(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mGestureRecognizor = createRecognizor(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
  }
  
  private static native long createRecognizor(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  private static native void destroyRecognizor(long paramLong);
  
  private static native boolean doCalc(long paramLong);
  
  public static native int getFcnInputHeight();
  
  public static native int getFcnInputWidth();
  
  private static native String getGestureType(long paramLong);
  
  private static native float[] getHotRegion(long paramLong);
  
  private static native float[] getHotRegionInOriginImg(long paramLong);
  
  public static native byte[] getInputRGBA(long paramLong);
  
  private static native float[] getKeyPoints(long paramLong);
  
  public static native String getMultiSign(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public static native String getParamTips();
  
  public static native String getVersionInfo();
  
  /* Error */
  private static String readFile(String paramString)
  {
    // Byte code:
    //   0: new 81	java/io/BufferedReader
    //   3: dup
    //   4: new 83	java/io/InputStreamReader
    //   7: dup
    //   8: new 85	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 88	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: ldc 90
    //   18: invokespecial 93	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   21: invokespecial 96	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_2
    //   25: ldc 98
    //   27: astore_1
    //   28: aload_2
    //   29: astore_0
    //   30: aload_2
    //   31: invokevirtual 101	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: astore_3
    //   35: aload_3
    //   36: ifnull +29 -> 65
    //   39: aload_2
    //   40: astore_0
    //   41: new 103	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   48: aload_1
    //   49: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_3
    //   53: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore_3
    //   60: aload_3
    //   61: astore_1
    //   62: goto -34 -> 28
    //   65: aload_2
    //   66: astore_0
    //   67: aload_2
    //   68: invokevirtual 114	java/io/BufferedReader:close	()V
    //   71: aload_1
    //   72: astore_0
    //   73: aload_2
    //   74: ifnull +9 -> 83
    //   77: aload_2
    //   78: invokevirtual 114	java/io/BufferedReader:close	()V
    //   81: aload_1
    //   82: astore_0
    //   83: aload_0
    //   84: areturn
    //   85: astore_0
    //   86: aload_0
    //   87: invokevirtual 117	java/io/IOException:printStackTrace	()V
    //   90: aload_1
    //   91: areturn
    //   92: astore_3
    //   93: aconst_null
    //   94: astore_2
    //   95: ldc 98
    //   97: astore_1
    //   98: aload_2
    //   99: astore_0
    //   100: aload_3
    //   101: invokevirtual 117	java/io/IOException:printStackTrace	()V
    //   104: aload_1
    //   105: astore_0
    //   106: aload_2
    //   107: ifnull -24 -> 83
    //   110: aload_2
    //   111: invokevirtual 114	java/io/BufferedReader:close	()V
    //   114: aload_1
    //   115: areturn
    //   116: astore_0
    //   117: aload_0
    //   118: invokevirtual 117	java/io/IOException:printStackTrace	()V
    //   121: aload_1
    //   122: areturn
    //   123: astore_1
    //   124: aconst_null
    //   125: astore_0
    //   126: aload_0
    //   127: ifnull +7 -> 134
    //   130: aload_0
    //   131: invokevirtual 114	java/io/BufferedReader:close	()V
    //   134: aload_1
    //   135: athrow
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 117	java/io/IOException:printStackTrace	()V
    //   141: goto -7 -> 134
    //   144: astore_1
    //   145: goto -19 -> 126
    //   148: astore_3
    //   149: goto -51 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramString	String
    //   27	95	1	localObject1	Object
    //   123	12	1	localObject2	Object
    //   144	1	1	localObject3	Object
    //   24	87	2	localBufferedReader	java.io.BufferedReader
    //   34	27	3	str	String
    //   92	9	3	localIOException1	java.io.IOException
    //   148	1	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   77	81	85	java/io/IOException
    //   0	25	92	java/io/IOException
    //   110	114	116	java/io/IOException
    //   0	25	123	finally
    //   130	134	136	java/io/IOException
    //   30	35	144	finally
    //   41	60	144	finally
    //   67	71	144	finally
    //   100	104	144	finally
    //   30	35	148	java/io/IOException
    //   41	60	148	java/io/IOException
    //   67	71	148	java/io/IOException
  }
  
  public static void setAVGestureReport(AVUploadReport paramAVUploadReport)
  {
    mReport = paramAVUploadReport;
  }
  
  public static native boolean setCnnModelPath(String paramString);
  
  private static native void setCnnThresHold(float paramFloat);
  
  private static native void setDilateKernelSize(int paramInt);
  
  private static native void setDilateKernelSizeAfterCrop(int paramInt);
  
  private static native void setErodeKernelSize(int paramInt);
  
  public static native boolean setFcnModelPath(String paramString);
  
  private static native void setFcnThresHold(int paramInt, float paramFloat);
  
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
  
  public void destroy()
  {
    destroyRecognizor(this.mGestureRecognizor);
  }
  
  public boolean doCalc()
  {
    boolean bool = doCalc(this.mGestureRecognizor);
    String str = getGestureType(this.mGestureRecognizor);
    byte[] arrayOfByte = getInputRGBA(this.mGestureRecognizor);
    int i = getFcnInputWidth();
    int j = getFcnInputHeight();
    if (bool) {
      AVCosUpload.createInstance().uploadFile(mFilePath, str, arrayOfByte, i, j, new AVCosUpload.UploadFileListener()
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
    return bool;
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
    float f1 = arrayOfFloat[0];
    float f2 = arrayOfFloat[1];
    float f3 = arrayOfFloat[0];
    float f4 = arrayOfFloat[2];
    float f5 = arrayOfFloat[1];
    return new RectF(f1, f2, f3 + f4, arrayOfFloat[3] + f5);
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