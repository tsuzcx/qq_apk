package com.qq.wx.voice.embedqqegg.recognizer;

import android.content.Context;
import android.content.res.AssetManager;
import com.qq.wx.voice.embedqqegg.util.LogTool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

final class a
{
  private boolean a = false;
  private String b = null;
  private String c = "libwxvoiceembedqqegg.bin";
  
  private static void a(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    paramAssetManager = paramAssetManager.open(paramString1);
    byte[] arrayOfByte = new byte[2048];
    paramString1 = new File(paramString2 + paramString1);
    paramString1.createNewFile();
    paramString1 = new FileOutputStream(paramString1);
    for (;;)
    {
      int i = paramAssetManager.read(arrayOfByte);
      if (i == -1)
      {
        paramString1.close();
        paramAssetManager.close();
        return;
      }
      paramString1.write(arrayOfByte, 0, i);
    }
  }
  
  private void a(File paramFile)
  {
    if (paramFile.isFile()) {
      paramFile.delete();
    }
    while (!paramFile.isDirectory()) {
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      paramFile.delete();
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        paramFile.delete();
        return;
      }
      a(arrayOfFile[i]);
      i += 1;
    }
  }
  
  public final int a(Context paramContext)
  {
    if (this.a) {
      return 0;
    }
    String str1;
    Object localObject;
    String str2;
    int i;
    if (InfoRecognizer.c == null)
    {
      str1 = paramContext.getFilesDir().getAbsolutePath() + "/wxvoiceembed/";
      localObject = new File(str1);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      str1 = str1 + "grammar/";
      localObject = new File(str1);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      str2 = str1 + SDKVersion.Ver;
      File localFile = new File(str2);
      localObject = paramContext.getAssets();
      if (!localFile.exists())
      {
        paramContext = new File(str1).listFiles();
        if (paramContext != null)
        {
          int j = paramContext.length;
          i = 0;
          if (i < j) {}
        }
        else
        {
          localFile.mkdir();
          paramContext = str2 + "/";
        }
      }
    }
    for (;;)
    {
      try
      {
        a((AssetManager)localObject, this.c, paramContext);
        this.b = paramContext;
        this.a = true;
        return 0;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        return -1;
      }
      a(paramContext[i]);
      i += 1;
      break;
      str1 = str2 + "/";
      try
      {
        str2 = this.c;
        paramContext = str1;
        if (new File(str1 + str2).exists()) {
          continue;
        }
        a((AssetManager)localObject, this.c, str1);
        paramContext = str1;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        return -1;
      }
      if (!new File(InfoRecognizer.c).exists())
      {
        LogTool.d("no found " + InfoRecognizer.c);
        return -1;
      }
      this.b = "";
      this.c = "";
      i = InfoRecognizer.c.lastIndexOf("/");
      if (i != -1)
      {
        this.b = InfoRecognizer.c.substring(0, i);
        this.c = InfoRecognizer.c.substring(i + 1);
      }
      LogTool.d("init by binWXVoiceEmbedPath: " + InfoRecognizer.c);
      LogTool.d("mPath = " + this.b);
      LogTool.d("mData = " + this.c);
    }
  }
  
  public final String a()
  {
    return this.b;
  }
  
  public final String b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.qq.wx.voice.embedqqegg.recognizer.a
 * JD-Core Version:    0.7.0.1
 */