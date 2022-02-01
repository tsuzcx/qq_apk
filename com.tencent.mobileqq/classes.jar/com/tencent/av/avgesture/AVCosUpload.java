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
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
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
  private static AVCosUpload s_instance;
  static final ExecutorService singleThreadPool = ;
  public boolean IsUploading = false;
  public boolean ShouldUpload = false;
  private Timer mUploadTimer;
  
  /* Error */
  private static String ReadFile(String paramString)
  {
    // Byte code:
    //   0: new 56	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: ldc 8
    //   11: astore_2
    //   12: aconst_null
    //   13: astore_3
    //   14: aconst_null
    //   15: astore_0
    //   16: new 61	java/io/BufferedReader
    //   19: dup
    //   20: new 63	java/io/FileReader
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 66	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   28: invokespecial 69	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: aload_2
    //   33: astore_0
    //   34: aload_1
    //   35: invokevirtual 73	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +33 -> 73
    //   43: new 75	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   50: astore_3
    //   51: aload_3
    //   52: aload_0
    //   53: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_3
    //   58: aload_2
    //   59: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_3
    //   64: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore_2
    //   68: aload_2
    //   69: astore_0
    //   70: goto -36 -> 34
    //   73: aload_1
    //   74: invokevirtual 86	java/io/BufferedReader:close	()V
    //   77: aload_0
    //   78: astore_3
    //   79: aload_1
    //   80: invokevirtual 86	java/io/BufferedReader:close	()V
    //   83: aload_0
    //   84: areturn
    //   85: astore_0
    //   86: goto +40 -> 126
    //   89: astore_3
    //   90: aload_0
    //   91: astore_2
    //   92: goto +16 -> 108
    //   95: astore_2
    //   96: aload_0
    //   97: astore_1
    //   98: aload_2
    //   99: astore_0
    //   100: goto +26 -> 126
    //   103: astore_0
    //   104: aload_3
    //   105: astore_1
    //   106: aload_0
    //   107: astore_3
    //   108: aload_1
    //   109: astore_0
    //   110: aload_3
    //   111: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   114: aload_1
    //   115: ifnull +9 -> 124
    //   118: aload_2
    //   119: astore_3
    //   120: aload_1
    //   121: invokevirtual 86	java/io/BufferedReader:close	()V
    //   124: aload_2
    //   125: areturn
    //   126: aload_1
    //   127: ifnull +7 -> 134
    //   130: aload_1
    //   131: invokevirtual 86	java/io/BufferedReader:close	()V
    //   134: goto +5 -> 139
    //   137: aload_0
    //   138: athrow
    //   139: goto -2 -> 137
    //   142: astore_0
    //   143: aload_3
    //   144: areturn
    //   145: astore_1
    //   146: goto -12 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramString	String
    //   8	123	1	localObject1	Object
    //   145	1	1	localIOException1	java.io.IOException
    //   11	81	2	str1	String
    //   95	30	2	str2	String
    //   13	66	3	localObject2	Object
    //   89	16	3	localIOException2	java.io.IOException
    //   107	37	3	str3	String
    // Exception table:
    //   from	to	target	type
    //   34	39	85	finally
    //   43	68	85	finally
    //   73	77	85	finally
    //   34	39	89	java/io/IOException
    //   43	68	89	java/io/IOException
    //   73	77	89	java/io/IOException
    //   16	32	95	finally
    //   110	114	95	finally
    //   16	32	103	java/io/IOException
    //   79	83	142	java/io/IOException
    //   120	124	142	java/io/IOException
    //   130	134	145	java/io/IOException
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
    catch (Exception paramString)
    {
      label58:
      break label58;
    }
    return false;
  }
  
  public static AVCosUpload createInstance()
  {
    if (s_instance == null) {
      try
      {
        if (s_instance == null) {
          s_instance = new AVCosUpload();
        }
      }
      finally {}
    }
    return s_instance;
  }
  
  private String getParamString(Map<String, String> paramMap, String paramString)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      for (paramMap = (Map<String, String>)localObject2;; paramMap = ((StringBuilder)localObject2).toString())
      {
        localObject1 = paramMap;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (Map.Entry)localIterator.next();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramMap);
        ((StringBuilder)localObject2).append("--");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("\r\n");
        paramMap = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramMap);
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=\"");
        ((StringBuilder)localObject2).append((String)((Map.Entry)localObject1).getKey());
        ((StringBuilder)localObject2).append("\"\r\n\r\n");
        paramMap = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramMap);
        ((StringBuilder)localObject2).append((String)((Map.Entry)localObject1).getValue());
        ((StringBuilder)localObject2).append("\r\n");
      }
    }
    return localObject1;
  }
  
  private File openFile(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      Object localObject = new File(paramString);
      if (!((File)localObject).exists())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkFile| filePath is not exist. path=");
        ((StringBuilder)localObject).append(paramString);
        Log.e("", ((StringBuilder)localObject).toString());
        return null;
      }
      return localObject;
    }
    Log.e("", "checkFile| filePath == null.");
    return null;
  }
  
  private boolean shouldUpload(String paramString1, String paramString2)
  {
    if (this.ShouldUpload)
    {
      if (this.IsUploading) {
        return false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("/av_cos_uploaded_count.json");
      paramString1 = ((StringBuilder)localObject).toString();
      localObject = new File(paramString1);
      if (((File)localObject).exists()) {}
    }
    try
    {
      ((File)localObject).createNewFile();
      localObject = new JSONObject();
      ((JSONObject)localObject).put(paramString2, 1);
      WriteFile(paramString1, ((JSONObject)localObject).toString());
      return true;
    }
    catch (Exception paramString1)
    {
      return false;
    }
    Object localObject = ReadFile(paramString1);
    int i;
    if (!((String)localObject).equals(""))
    {
      localObject = new JSONObject((String)localObject);
      if (!((JSONObject)localObject).has(paramString2)) {
        break label175;
      }
      i = ((JSONObject)localObject).getInt(paramString2) + 1;
    }
    for (;;)
    {
      if (i < 5)
      {
        ((JSONObject)localObject).put(paramString2, i);
        WriteFile(paramString1, ((JSONObject)localObject).toString());
        return true;
      }
      return false;
      label175:
      i = 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.avgesture.AVCosUpload
 * JD-Core Version:    0.7.0.1
 */