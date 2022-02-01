package com.tencent.mobileqq.apollo.store;

import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import anji;
import bhmq;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;
import mqq.os.MqqHandler;
import zom;

class ApolloStoreActivity$3
  implements Runnable
{
  ApolloStoreActivity$3(ApolloStoreActivity paramApolloStoreActivity, Bitmap paramBitmap, long paramLong, String paramString) {}
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "[saveImage] failed bitmap null");
      }
    }
    String str;
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloStoreActivity", 2, "[saveImage] consume time " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + " ms");
        }
        Message localMessage = Message.obtain();
        localMessage.what = 256;
        try
        {
          str = Environment.getExternalStorageDirectory().toString();
          Object localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(Long.valueOf(System.currentTimeMillis()));
          if (ApolloStoreActivity.a(this.this$0) != null) {
            i = ApolloStoreActivity.a(this.this$0).a();
          }
          str = str + "/cmshow/" + i + "_" + (String)localObject + ".png";
          localObject = new File(str);
          if (!TextUtils.isEmpty(str))
          {
            try
            {
              bhmq.a(this.jdField_a_of_type_AndroidGraphicsBitmap, (File)localObject);
              if ((!TextUtils.isEmpty(str)) && (zom.c(str))) {
                break label275;
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("ApolloStoreActivity", 2, "[saveImage] failed invalid path");
              return;
            }
            catch (Throwable localThrowable1) {}
            if (QLog.isColorLevel())
            {
              QLog.d("ApolloStoreActivity", 2, "[saveImage] failed save to disk");
              return;
            }
          }
        }
        catch (Throwable localThrowable2) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloStoreActivity", 2, "[saveImage] failed create path" + localThrowable2.getMessage());
    return;
    try
    {
      label275:
      MediaScannerConnection.scanFile(this.this$0.getApplicationContext(), new String[] { str }, new String[] { "image/png" }, null);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "[saveImage] to media db " + str);
      }
      localThrowable2.obj = this.jdField_a_of_type_JavaLangString;
      localThrowable2.arg1 = 0;
      this.this$0.a.sendMessage(localThrowable2);
      return;
    }
    catch (Throwable localThrowable3)
    {
      QLog.e("ApolloStoreActivity", 2, "[saveImage] failed exception " + localThrowable3.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreActivity.3
 * JD-Core Version:    0.7.0.1
 */