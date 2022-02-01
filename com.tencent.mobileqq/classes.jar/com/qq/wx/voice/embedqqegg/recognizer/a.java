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
    paramString2 = new StringBuilder(String.valueOf(paramString2));
    paramString2.append(paramString1);
    paramString1 = new File(paramString2.toString());
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
    if (paramFile.isFile())
    {
      paramFile.delete();
      return;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length != 0))
      {
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
      paramFile.delete();
    }
  }
  
  public final int a(Context paramContext)
  {
    if (this.a) {
      return 0;
    }
    int i;
    if (InfoRecognizer.c == null)
    {
      Object localObject1 = new StringBuilder(String.valueOf(paramContext.getFilesDir().getAbsolutePath()));
      ((StringBuilder)localObject1).append("/wxvoiceembed/");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdir();
      }
      localObject1 = new StringBuilder(String.valueOf(localObject1));
      ((StringBuilder)localObject1).append("grammar/");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdir();
      }
      localObject2 = new StringBuilder(String.valueOf(localObject1));
      ((StringBuilder)localObject2).append(SDKVersion.Ver);
      Object localObject3 = ((StringBuilder)localObject2).toString();
      File localFile = new File((String)localObject3);
      localObject2 = paramContext.getAssets();
      if (!localFile.exists())
      {
        paramContext = new File((String)localObject1).listFiles();
        if (paramContext != null)
        {
          int j = paramContext.length;
          i = 0;
          while (i < j)
          {
            a(paramContext[i]);
            i += 1;
          }
        }
        localFile.mkdir();
        paramContext = new StringBuilder(String.valueOf(localObject3));
        paramContext.append("/");
        paramContext = paramContext.toString();
        try
        {
          a((AssetManager)localObject2, this.c, paramContext);
        }
        catch (IOException paramContext)
        {
          paramContext.printStackTrace();
          return -1;
        }
      }
      else
      {
        paramContext = new StringBuilder(String.valueOf(localObject3));
        paramContext.append("/");
        localObject1 = paramContext.toString();
      }
      try
      {
        paramContext = this.c;
        localObject3 = new StringBuilder(String.valueOf(localObject1));
        ((StringBuilder)localObject3).append(paramContext);
        paramContext = (Context)localObject1;
        if (!new File(((StringBuilder)localObject3).toString()).exists())
        {
          a((AssetManager)localObject2, this.c, (String)localObject1);
          paramContext = (Context)localObject1;
        }
        this.b = paramContext;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        return -1;
      }
    }
    else
    {
      if (!new File(InfoRecognizer.c).exists())
      {
        paramContext = new StringBuilder("no found ");
        paramContext.append(InfoRecognizer.c);
        LogTool.d(paramContext.toString());
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
      paramContext = new StringBuilder("init by binWXVoiceEmbedPath: ");
      paramContext.append(InfoRecognizer.c);
      LogTool.d(paramContext.toString());
      paramContext = new StringBuilder("mPath = ");
      paramContext.append(this.b);
      LogTool.d(paramContext.toString());
      paramContext = new StringBuilder("mData = ");
      paramContext.append(this.c);
      LogTool.d(paramContext.toString());
    }
    this.a = true;
    return 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.embedqqegg.recognizer.a
 * JD-Core Version:    0.7.0.1
 */