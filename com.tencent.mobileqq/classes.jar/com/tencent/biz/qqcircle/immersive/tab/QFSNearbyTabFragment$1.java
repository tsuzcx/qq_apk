package com.tencent.biz.qqcircle.immersive.tab;

import android.os.Build.VERSION;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class QFSNearbyTabFragment$1
  implements QQPermissionCallback
{
  QFSNearbyTabFragment$1(QFSNearbyTabFragment paramQFSNearbyTabFragment) {}
  
  public boolean a()
  {
    if (QCircleHostGlobalInfo.isCurrentTabActive()) {
      return HostUIHelper.getInstance().isDenyNotAsk();
    }
    return (Build.VERSION.SDK_INT >= 23) && (this.a.getActivity() != null) && (!this.a.getActivity().shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION"));
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d(QFSNearbyTabFragment.x, 1, "requestGetGpsPermission result deny");
    if (a())
    {
      paramArrayOfString = QFSNearbyTabFragment.x;
      paramArrayOfInt = new StringBuilder();
      paramArrayOfInt.append("requestGetGpsPermission result denyNotAsk,is origin denied");
      paramArrayOfInt.append(QFSNearbyTabFragment.b(this.a));
      QLog.d(paramArrayOfString, 1, paramArrayOfInt.toString());
      if (QFSNearbyTabFragment.b(this.a)) {
        QFSNearbyTabFragment.c(this.a);
      }
    }
    QFSNearbyTabFragment.d(this.a);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d(QFSNearbyTabFragment.x, 1, "requestGetGpsPermission result grant");
    QFSNearbyTabFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.tab.QFSNearbyTabFragment.1
 * JD-Core Version:    0.7.0.1
 */