package com.tencent.mobileqq.activity.recent.guidebanner;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_8410;

public class NewerGuideBannerObserver
  implements BusinessObserver
{
  private final WeakReference<QQAppInterface> a;
  
  NewerGuideBannerObserver(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
  
  private void a(oidb_0x59f.Guidelines_8410 paramGuidelines_8410)
  {
    int i = -1;
    if (paramGuidelines_8410.uint32_banner_status.has()) {
      i = paramGuidelines_8410.uint32_banner_status.get();
    }
    QLog.d("InnerNewerGuideBannerObserver", 1, "onGetNewerGuideBanner status: " + i);
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface != null)
    {
      NewerGuideBannerManager localNewerGuideBannerManager = (NewerGuideBannerManager)localQQAppInterface.getManager(QQManagerFactory.NEWER_GUIDE_BANNER_MANAGER);
      localNewerGuideBannerManager.a(paramGuidelines_8410);
      localQQAppInterface.removeObserver(this);
      localNewerGuideBannerManager.a = null;
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt == 0) && (paramBoolean) && ((paramObject instanceof oidb_0x59f.Guidelines_8410))) {
      a((oidb_0x59f.Guidelines_8410)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerObserver
 * JD-Core Version:    0.7.0.1
 */