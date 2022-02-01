package com.tencent.acstat.a.a;

import android.content.Context;
import android.os.Environment;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

class b
  extends g
{
  b(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a(String paramString)
  {
    try
    {
      i.a("write mid to InternalStorage");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory());
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(c());
      a.a(((StringBuilder)localObject).toString());
      localObject = new File(Environment.getExternalStorageDirectory(), d());
      try
      {
        localObject = new BufferedWriter(new FileWriter((File)localObject));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(f());
        localStringBuilder.append(",");
        localStringBuilder.append(paramString);
        ((BufferedWriter)localObject).write(localStringBuilder.toString());
        ((BufferedWriter)localObject).write("\n");
        ((BufferedWriter)localObject).close();
      }
      catch (IOException paramString)
      {
        i.a(paramString);
      }
      return;
    }
    finally {}
  }
  
  protected boolean a()
  {
    return (i.a(this.a, "android.permission.WRITE_EXTERNAL_STORAGE")) && (Environment.getExternalStorageState().equals("mounted"));
  }
  
  protected String b()
  {
    try
    {
      i.a("read mid from InternalStorage");
      Object localObject1 = new File(Environment.getExternalStorageDirectory(), d());
      try
      {
        Object localObject4 = a.a((File)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject1 = ((String)((Iterator)localObject4).next()).split(",");
        } while ((localObject1.length != 2) || (!localObject1[0].equals(f())));
        localObject4 = new StringBuilder("read mid from InternalStorage:");
        ((StringBuilder)localObject4).append(localObject1[1]);
        i.a(((StringBuilder)localObject4).toString());
        localObject1 = localObject1[1];
      }
      catch (IOException localIOException)
      {
        i.a(localIOException);
        break label129;
      }
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          throw localObject2;
        }
        label129:
        Object localObject3 = null;
      }
    }
    return localIOException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.a.a.b
 * JD-Core Version:    0.7.0.1
 */