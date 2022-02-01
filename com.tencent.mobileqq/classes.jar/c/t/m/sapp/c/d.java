package c.t.m.sapp.c;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;

public class d
{
  public static d a;
  public Context b = null;
  public Map<String, FileChannel> c = null;
  
  public d(Context paramContext)
  {
    this.b = paramContext;
    this.c = new HashMap(5);
  }
  
  public static d a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new d(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public File a(String paramString)
  {
    try
    {
      try
      {
        File localFile = this.b.getFilesDir();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("TencentLocationCoverSDK_sapp_");
        localStringBuilder.append(paramString);
        localStringBuilder.append(".lock");
        localFile = new File(localFile, localStringBuilder.toString());
        paramString = localFile;
        if (localFile.exists()) {
          break label77;
        }
        localFile.createNewFile();
        paramString = localFile;
      }
      finally {}
    }
    catch (IOException paramString)
    {
      label75:
      label77:
      break label75;
    }
    paramString = null;
    return paramString;
  }
  
  public boolean b(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (paramString.trim().length() > 0)
        {
          File localFile = a(paramString);
          if (localFile == null) {
            return true;
          }
          try
          {
            FileChannel localFileChannel2 = (FileChannel)this.c.get(paramString);
            FileChannel localFileChannel1;
            if (localFileChannel2 != null)
            {
              localFileChannel1 = localFileChannel2;
              if (localFileChannel2.isOpen()) {}
            }
            else
            {
              localFileChannel1 = new FileOutputStream(localFile).getChannel();
              this.c.put(paramString, localFileChannel1);
            }
            paramString = localFileChannel1.lock();
            if (paramString != null)
            {
              boolean bool = paramString.isValid();
              if (bool) {
                return true;
              }
            }
          }
          catch (Throwable paramString)
          {
            paramString.printStackTrace();
            return false;
          }
        }
      }
      finally {}
    }
    return false;
  }
  
  public void c(String paramString)
  {
    if (paramString != null) {
      try
      {
        int i = paramString.trim().length();
        if (i > 0)
        {
          try
          {
            paramString = (FileChannel)this.c.get(paramString);
            if (paramString != null) {
              paramString.close();
            }
          }
          catch (Throwable paramString)
          {
            paramString.printStackTrace();
          }
          return;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.sapp.c.d
 * JD-Core Version:    0.7.0.1
 */