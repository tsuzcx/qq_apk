package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import android.text.TextUtils;
import baip;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.URLUtil;

class SpringHbFullScreenVideoFragment$2
  implements Runnable
{
  SpringHbFullScreenVideoFragment$2(SpringHbFullScreenVideoFragment paramSpringHbFullScreenVideoFragment, String paramString) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject == null) || (!(localObject instanceof QQAppInterface))) {}
    }
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject == null) {}
      while (TextUtils.isEmpty(this.a)) {
        return;
      }
      if (URLUtil.isNetworkUrl(this.a))
      {
        localObject = PreloadManager.e(this.a);
        if (baip.a((String)localObject))
        {
          SpringHbFullScreenVideoFragment.a(this.this$0, 0);
          if (!baip.a((String)localObject)) {
            break label187;
          }
          localObject = this.a;
        }
      }
      label187:
      for (;;)
      {
        QLog.i("QQFudaiVideoFragment", 1, "finalPlayUrl video play url :" + (String)localObject + " isDownloaded: " + SpringHbFullScreenVideoFragment.a(this.this$0));
        if (URLUtil.isNetworkUrl((String)localObject))
        {
          SpringHbFullScreenVideoFragment.a(this.this$0).setDataByOnLineUrl((String)localObject, false, false, 0L, 0L);
          return;
          SpringHbFullScreenVideoFragment.a(this.this$0, 1);
          break;
          localObject = this.a;
          break;
        }
        SpringHbFullScreenVideoFragment.a(this.this$0).setDataByLocalPath((String)localObject, false, false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbFullScreenVideoFragment.2
 * JD-Core Version:    0.7.0.1
 */