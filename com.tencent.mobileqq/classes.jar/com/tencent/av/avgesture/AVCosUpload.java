package com.tencent.av.avgesture;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

class AVCosUpload
{
  static final String Appid = "";
  public static final String Bucket = "";
  private static final int MaxUploadCount = 5;
  private static final int MinUploadInterval = 3;
  static final String SecretID = "";
  static final String SecretKey = "";
  public static final String TAG = "";
  public static final int UPLOAD_FILE_ACCESSERROR = 8193;
  public static final int UPLOAD_NETWORK_FAIL = 8195;
  public static final int UPLOAD_SUCCESS = 0;
  private static AVCosUpload s_instance = null;
  static final ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
  public boolean IsUploading = false;
  public boolean ShouldUpload = false;
  private Timer mUploadTimer;
  
  /* Error */
  private static String ReadFile(String paramString)
  {
    // Byte code:
    //   0: new 58	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 63	java/io/BufferedReader
    //   12: dup
    //   13: new 65	java/io/FileReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 68	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   21: invokespecial 71	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_2
    //   25: ldc 8
    //   27: astore_1
    //   28: aload_2
    //   29: astore_0
    //   30: aload_2
    //   31: invokevirtual 75	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: astore_3
    //   35: aload_3
    //   36: ifnull +29 -> 65
    //   39: aload_2
    //   40: astore_0
    //   41: new 77	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   48: aload_1
    //   49: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_3
    //   53: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore_3
    //   60: aload_3
    //   61: astore_1
    //   62: goto -34 -> 28
    //   65: aload_2
    //   66: astore_0
    //   67: aload_2
    //   68: invokevirtual 88	java/io/BufferedReader:close	()V
    //   71: aload_1
    //   72: astore_0
    //   73: aload_2
    //   74: ifnull +9 -> 83
    //   77: aload_2
    //   78: invokevirtual 88	java/io/BufferedReader:close	()V
    //   81: aload_1
    //   82: astore_0
    //   83: aload_0
    //   84: areturn
    //   85: astore_3
    //   86: aconst_null
    //   87: astore_2
    //   88: ldc 8
    //   90: astore_1
    //   91: aload_2
    //   92: astore_0
    //   93: aload_3
    //   94: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   97: aload_1
    //   98: astore_0
    //   99: aload_2
    //   100: ifnull -17 -> 83
    //   103: aload_2
    //   104: invokevirtual 88	java/io/BufferedReader:close	()V
    //   107: aload_1
    //   108: areturn
    //   109: astore_0
    //   110: aload_1
    //   111: areturn
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 88	java/io/BufferedReader:close	()V
    //   123: aload_1
    //   124: athrow
    //   125: astore_0
    //   126: aload_1
    //   127: areturn
    //   128: astore_0
    //   129: goto -6 -> 123
    //   132: astore_1
    //   133: goto -18 -> 115
    //   136: astore_3
    //   137: goto -46 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramString	String
    //   27	84	1	localObject1	Object
    //   112	15	1	str1	String
    //   132	1	1	localObject2	Object
    //   24	80	2	localBufferedReader	java.io.BufferedReader
    //   34	27	3	str2	String
    //   85	9	3	localIOException1	java.io.IOException
    //   136	1	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   9	25	85	java/io/IOException
    //   103	107	109	java/io/IOException
    //   9	25	112	finally
    //   77	81	125	java/io/IOException
    //   119	123	128	java/io/IOException
    //   30	35	132	finally
    //   41	60	132	finally
    //   67	71	132	finally
    //   93	97	132	finally
    //   30	35	136	java/io/IOException
    //   41	60	136	java/io/IOException
    //   67	71	136	java/io/IOException
  }
  
  private static void WriteFile(String paramString1, String paramString2)
  {
    paramString1 = new FileWriter(paramString1);
    PrintWriter localPrintWriter = new PrintWriter(paramString1);
    localPrintWriter.write(paramString2);
    localPrintWriter.println();
    paramString1.close();
    localPrintWriter.close();
  }
  
  private boolean cacheInputImageTo(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(paramArrayOfByte));
      paramString = new FileOutputStream(new File(paramString));
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 80, paramString);
      paramString.flush();
      paramString.close();
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static AVCosUpload createInstance()
  {
    if (s_instance == null) {}
    try
    {
      if (s_instance == null) {
        s_instance = new AVCosUpload();
      }
      return s_instance;
    }
    finally {}
  }
  
  private String getParamString(Map<String, String> paramMap, String paramString)
  {
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      for (paramMap = "";; paramMap = paramMap + (String)((Map.Entry)localObject).getValue() + "\r\n")
      {
        localObject = paramMap;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        paramMap = paramMap + "--" + paramString + "\r\n";
        paramMap = paramMap + "Content-Disposition: form-data; name=\"" + (String)((Map.Entry)localObject).getKey() + "\"\r\n\r\n";
      }
    }
    Object localObject = "";
    return localObject;
  }
  
  private File openFile(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      Log.e("", "checkFile| filePath == null.");
      return null;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      Log.e("", "checkFile| filePath is not exist. path=" + paramString);
      return null;
    }
    return localFile;
  }
  
  private boolean shouldUpload(String paramString1, String paramString2)
  {
    if ((!this.ShouldUpload) || (this.IsUploading)) {
      return false;
    }
    paramString1 = paramString1 + "/av_cos_uploaded_count.json";
    Object localObject = new File(paramString1);
    if (!((File)localObject).exists()) {
      try
      {
        ((File)localObject).createNewFile();
        localObject = new JSONObject();
        ((JSONObject)localObject).put(paramString2, 1);
        WriteFile(paramString1, ((JSONObject)localObject).toString());
        return true;
      }
      catch (Exception paramString1) {}
    }
    do
    {
      return false;
      localObject = ReadFile(paramString1);
    } while (((String)localObject).equals(""));
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        if (!((JSONObject)localObject).has(paramString2)) {
          break label164;
        }
        i = ((JSONObject)localObject).getInt(paramString2) + 1;
        if (i >= 5) {
          break;
        }
        ((JSONObject)localObject).put(paramString2, i);
        WriteFile(paramString1, ((JSONObject)localObject).toString());
        return true;
      }
      catch (Exception paramString1) {}
      break;
      label164:
      int i = 1;
    }
  }
  
  private void uploadFileImpl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, AVCosUpload.UploadFileListener paramUploadFileListener) {}
  
  public void startUploadTimer(int paramInt)
  {
    this.IsUploading = true;
    this.mUploadTimer = new Timer();
    this.mUploadTimer.schedule(new AVCosUpload.UploadTimerTask(this), paramInt * 1000);
  }
  
  public void uploadFile(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, AVCosUpload.UploadFileListener paramUploadFileListener)
  {
    if (!shouldUpload(paramString1, paramString2)) {
      return;
    }
    singleThreadPool.execute(new AVCosUpload.1(this, paramString2, paramString1, paramArrayOfByte, paramInt1, paramInt2, paramUploadFileListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.avgesture.AVCosUpload
 * JD-Core Version:    0.7.0.1
 */