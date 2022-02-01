package com.tencent.mobileqq.apollo.store;

import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;
import mqq.os.MqqHandler;

class ApolloStoreActivity$4
  implements Runnable
{
  ApolloStoreActivity$4(ApolloStoreActivity paramApolloStoreActivity, Bitmap paramBitmap, long paramLong, String paramString) {}
  
  public void run()
  {
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloStoreActivity", 2, "[saveImage] failed bitmap null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[saveImage] consume time ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - this.b);
      ((StringBuilder)localObject1).append(" ms");
      QLog.d("[cmshow]ApolloStoreActivity", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = Message.obtain();
    ((Message)localObject1).what = 256;
    for (;;)
    {
      try
      {
        localObject2 = Environment.getExternalStorageDirectory().toString();
        localObject3 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(Long.valueOf(System.currentTimeMillis()));
        if (ApolloStoreActivity.a(this.this$0) == null) {
          break label469;
        }
        i = ApolloStoreActivity.a(this.this$0).h();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("/cmshow/");
        localStringBuilder.append(i);
        localStringBuilder.append("_");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(".png");
        localObject2 = localStringBuilder.toString();
        localObject3 = new File((String)localObject2);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return;
        }
      }
      catch (Throwable localThrowable2)
      {
        Object localObject2;
        Object localObject3;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[saveImage] failed create path");
          ((StringBuilder)localObject2).append(localThrowable2.getMessage());
          QLog.d("[cmshow]ApolloStoreActivity", 2, ((StringBuilder)localObject2).toString());
        }
        return;
      }
      try
      {
        ImageUtil.a(this.a, (File)localObject3);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          boolean bool = FileUtils.d((String)localObject2);
          if (bool) {
            try
            {
              MediaScannerConnection.scanFile(this.this$0.getApplicationContext(), new String[] { localObject2 }, new String[] { "image/png" }, null);
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("[saveImage] to media db ");
                ((StringBuilder)localObject3).append((String)localObject2);
                QLog.d("[cmshow]ApolloStoreActivity", 2, ((StringBuilder)localObject3).toString());
              }
              ((Message)localObject1).obj = this.c;
              ((Message)localObject1).arg1 = 0;
              this.this$0.a.sendMessage((Message)localObject1);
              return;
            }
            catch (Throwable localThrowable1)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("[saveImage] failed exception ");
              ((StringBuilder)localObject2).append(localThrowable1.getMessage());
              QLog.e("[cmshow]ApolloStoreActivity", 2, ((StringBuilder)localObject2).toString());
              return;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloStoreActivity", 2, "[saveImage] failed invalid path");
        }
        return;
      }
      catch (Throwable localThrowable3)
      {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloStoreActivity", 2, "[saveImage] failed save to disk");
      }
      return;
      label469:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreActivity.4
 * JD-Core Version:    0.7.0.1
 */