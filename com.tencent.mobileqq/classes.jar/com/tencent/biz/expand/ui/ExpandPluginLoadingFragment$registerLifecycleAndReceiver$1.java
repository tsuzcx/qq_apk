package com.tencent.biz.expand.ui;

import android.os.Build.VERSION;
import android.support.v4.app.QFragmentActivity;
import com.tencent.biz.expand.utils.OnApplicationBackgroundListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/expand/ui/ExpandPluginLoadingFragment$registerLifecycleAndReceiver$1", "Lcom/tencent/biz/expand/utils/OnApplicationBackgroundListener;", "onBackground", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandPluginLoadingFragment$registerLifecycleAndReceiver$1
  implements OnApplicationBackgroundListener
{
  public void a()
  {
    QLog.d("ExpandPluginLoadingFragment", 2, "onBackground");
    this.a.d(4);
    if (Build.VERSION.SDK_INT > 28)
    {
      QLog.e("ExpandPluginLoadingFragment", 1, "sdk api above 28, dismiss");
      QFragmentActivity localQFragmentActivity = this.a.getActivity();
      if (localQFragmentActivity != null) {
        localQFragmentActivity.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandPluginLoadingFragment.registerLifecycleAndReceiver.1
 * JD-Core Version:    0.7.0.1
 */