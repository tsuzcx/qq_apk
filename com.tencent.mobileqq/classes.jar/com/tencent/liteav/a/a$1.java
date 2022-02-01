package com.tencent.liteav.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.h;
import java.io.File;

class a$1
  extends Handler
{
  a$1(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (a.a(this.a) != null)
    {
      int i = paramMessage.what;
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("record complete. errcode = ");
        ((StringBuilder)localObject).append(paramMessage.arg1);
        ((StringBuilder)localObject).append(", errmsg = ");
        ((StringBuilder)localObject).append((String)paramMessage.obj);
        ((StringBuilder)localObject).append(", outputPath = ");
        ((StringBuilder)localObject).append(a.b(this.a).f);
        ((StringBuilder)localObject).append(", coverImage = ");
        ((StringBuilder)localObject).append(a.b(this.a).g);
        TXCLog.d("TXCStreamRecord", ((StringBuilder)localObject).toString());
        if ((paramMessage.arg1 == 0) && (a.b(this.a).g != null) && (!a.b(this.a).g.isEmpty()) && (!h.a(a.b(this.a).f, a.b(this.a).g)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("saveVideoThumb error. sourcePath = ");
          ((StringBuilder)localObject).append(a.b(this.a).f);
          ((StringBuilder)localObject).append(", coverImagePath = ");
          ((StringBuilder)localObject).append(a.b(this.a).g);
          TXCLog.e("TXCStreamRecord", ((StringBuilder)localObject).toString());
        }
        if (paramMessage.arg1 != 0) {
          try
          {
            localObject = new File(a.b(this.a).f);
            if (((File)localObject).exists()) {
              ((File)localObject).delete();
            }
          }
          catch (Exception localException)
          {
            TXCLog.e("TXCStreamRecord", "delete file failed.", localException);
          }
        }
        a.a(this.a).a(paramMessage.arg1, (String)paramMessage.obj, a.b(this.a).f, a.b(this.a).g);
        return;
      }
      a.a(this.a).a(((Long)paramMessage.obj).longValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.a.a.1
 * JD-Core Version:    0.7.0.1
 */