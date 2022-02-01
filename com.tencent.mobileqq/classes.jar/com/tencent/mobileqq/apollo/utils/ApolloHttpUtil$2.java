package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.cmshow.brickengine.apollo.utils.ApolloHttpResponseCallback;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;

final class ApolloHttpUtil$2
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloHttpUtil$2(String paramString, String[] paramArrayOfString, ApolloHttpResponseCallback paramApolloHttpResponseCallback, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("fakeResource3DUrlRequest onDownLoadFinish:");
      paramString.append(paramInt1);
      paramString.append(" sucess:");
      paramString.append(paramBoolean);
      QLog.d("[cmshow]ApolloHttpUtil", 2, paramString.toString());
    }
    if (paramBoolean)
    {
      paramArrayOfInt = new File(this.a);
      if (paramArrayOfInt.exists()) {
        try
        {
          paramString = ApolloHttpUtil.a(this.b);
          if (ApolloHttpUtil.a(this.a))
          {
            paramArrayOfInt = ApolloHttpUtil.a(paramArrayOfInt, paramString);
            this.c.a(0, paramString, paramArrayOfInt);
          }
          else
          {
            this.c.a(0, paramString, ApolloHttpUtil.a(new FileInputStream(paramArrayOfInt)));
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          paramArrayOfInt = new StringBuilder();
          paramArrayOfInt.append(paramString);
          paramArrayOfInt.append(" id:");
          paramArrayOfInt.append(this.d);
          QLog.d("[cmshow]ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest onDownLoadFinish retHeader:", paramArrayOfInt.toString() });
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("[cmshow]ApolloHttpUtil", 1, paramString, new Object[0]);
          return;
        }
      } else {
        this.c.a(-1, null, null);
      }
    }
    else
    {
      this.c.a(-1, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloHttpUtil.2
 * JD-Core Version:    0.7.0.1
 */