package com.tencent.mobileqq.armap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.avatar.utils.AvatarUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class NonMainProcAvatarLoader$3
  extends Handler
{
  NonMainProcAvatarLoader$3(NonMainProcAvatarLoader paramNonMainProcAvatarLoader, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1001) {
      for (;;)
      {
        try
        {
          paramMessage = (ArrayList)paramMessage.obj;
          if ((paramMessage == null) || (paramMessage.size() <= 0)) {
            continue;
          }
          Iterator localIterator = paramMessage.iterator();
          if (!localIterator.hasNext()) {
            continue;
          }
          str1 = (String)localIterator.next();
          str2 = (String)this.a.b.get(str1);
          paramMessage = BitmapFactory.decodeFile(str2);
          if (paramMessage == null) {
            continue;
          }
          if (NonMainProcAvatarLoader.a(this.a) != 1) {
            continue;
          }
          localObject1 = AvatarUtil.a(paramMessage, BaseImageUtil.a(paramMessage.getWidth()), 50, 50);
          paramMessage = (Message)localObject1;
          if (ThemeUtil.a(null, false, null))
          {
            paramMessage = new Paint();
            paramMessage.setAntiAlias(true);
            paramMessage.setColor(ThemeUtil.a);
            localObject2 = new Canvas((Bitmap)localObject1);
            ((Canvas)localObject2).drawRoundRect(new RectF(0.0F, 0.0F, ((Canvas)localObject2).getWidth(), ((Canvas)localObject2).getHeight()), 10.0F, 10.0F, paramMessage);
            paramMessage = (Message)localObject1;
          }
        }
        catch (OutOfMemoryError paramMessage)
        {
          String str1;
          String str2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("NonMainAppHeadLoader", 2, "decodeFile, OutOfMemoryError");
          return;
          Object localObject1 = this.a.a(paramMessage);
          paramMessage = (Message)localObject1;
          if (!ThemeUtil.a(null, false, null)) {
            continue;
          }
          paramMessage = new Paint();
          paramMessage.setAntiAlias(true);
          paramMessage.setColor(ThemeUtil.a);
          Object localObject2 = new Canvas((Bitmap)localObject1);
          ((Canvas)localObject2).drawCircle(((Canvas)localObject2).getWidth() / 2, ((Canvas)localObject2).getHeight() / 2, ((Canvas)localObject2).getWidth() / 2, paramMessage);
          paramMessage = (Message)localObject1;
          continue;
        }
        catch (Exception paramMessage)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("NonMainAppHeadLoader", 2, "decodeFile, exception:" + paramMessage.toString());
        }
        if (paramMessage != null)
        {
          localObject1 = Message.obtain();
          localObject2 = new Bundle();
          ((Bundle)localObject2).putParcelable("bmp", paramMessage);
          ((Bundle)localObject2).putString("uin", str1);
          ((Bundle)localObject2).putString("path", str2);
          ((Message)localObject1).obj = localObject2;
          ((Message)localObject1).what = 1002;
          this.a.a.sendMessage((Message)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("NonMainAppHeadLoader", 2, "decodeFile, uin:" + str1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.NonMainProcAvatarLoader.3
 * JD-Core Version:    0.7.0.1
 */