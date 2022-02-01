package com.tencent.mobileqq.activity.recent.guidebanner;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_8410;

public class NewerGuideBannerObserver
  implements BusinessObserver
{
  private final WeakReference<AppInterface> a;
  
  NewerGuideBannerObserver(AppInterface paramAppInterface)
  {
    this.a = new WeakReference(paramAppInterface);
  }
  
  private void a(oidb_0x59f.Guidelines_8410 paramGuidelines_8410)
  {
    int i;
    if (paramGuidelines_8410.uint32_banner_status.has()) {
      i = paramGuidelines_8410.uint32_banner_status.get();
    } else {
      i = -1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetNewerGuideBanner status: ");
    ((StringBuilder)localObject).append(i);
    QLog.d("InnerNewerGuideBannerObserver", 1, ((StringBuilder)localObject).toString());
    localObject = (AppInterface)this.a.get();
    if (localObject != null)
    {
      NewerGuideBannerManager localNewerGuideBannerManager = ((INewerGuideHelper)QRoute.api(INewerGuideHelper.class)).getNewerGuideManager((AppRuntime)localObject);
      localNewerGuideBannerManager.a(paramGuidelines_8410);
      ((AppInterface)localObject).removeObserver(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerObserver
 * JD-Core Version:    0.7.0.1
 */