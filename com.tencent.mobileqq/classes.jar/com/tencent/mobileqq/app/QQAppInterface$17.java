package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class QQAppInterface$17
  extends BroadcastReceiver
{
  QQAppInterface$17(QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.this$0.isReleased)
    {
      QLog.i("QQAppInterface", 1, "qzoneBrocastReceiver release() has been called  ,return ", null);
      return;
    }
    paramContext = paramIntent.getAction();
    if ("com.tencent.qzone.cleanunreadcount".equals(paramContext))
    {
      int i = paramIntent.getIntExtra("clean_unread_feed_type", -1);
      paramContext = (QZoneManagerImp)this.this$0.getManager(QQManagerFactory.QZONE_MANAGER);
      if ((paramContext != null) && (i != -1)) {
        paramContext.a(i, 0L, new ArrayList(), null, false, false, "");
      }
    }
    else if ("com.tecent.qzone.clearAlbumRedTouch".equals(paramContext))
    {
      ((QzoneAlbumRedTouchManager)this.this$0.getManager(QQManagerFactory.QZONE_ALBUM_RED_TOUCH)).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.17
 * JD-Core Version:    0.7.0.1
 */