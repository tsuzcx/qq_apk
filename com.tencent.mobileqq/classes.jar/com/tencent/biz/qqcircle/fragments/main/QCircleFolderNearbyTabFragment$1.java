package com.tencent.biz.qqcircle.fragments.main;

import android.os.Build.VERSION;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class QCircleFolderNearbyTabFragment$1
  implements QQPermissionCallback
{
  QCircleFolderNearbyTabFragment$1(QCircleFolderNearbyTabFragment paramQCircleFolderNearbyTabFragment) {}
  
  public boolean a()
  {
    if (QCircleHostGlobalInfo.isCurrentTabActive()) {
      return HostUIHelper.getInstance().isDenyNotAsk();
    }
    return (Build.VERSION.SDK_INT >= 23) && (this.a.getActivity() != null) && (!this.a.getActivity().shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION"));
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d(QCircleFolderNearbyTabFragment.B, 1, "requestGetGpsPermission result deny");
    if (a())
    {
      paramArrayOfString = QCircleFolderNearbyTabFragment.B;
      paramArrayOfInt = new StringBuilder();
      paramArrayOfInt.append("requestGetGpsPermission result denyNotAsk,is origin denied");
      paramArrayOfInt.append(QCircleFolderNearbyTabFragment.b(this.a));
      QLog.d(paramArrayOfString, 1, paramArrayOfInt.toString());
      if (QCircleFolderNearbyTabFragment.b(this.a)) {
        QCircleFolderNearbyTabFragment.c(this.a);
      }
    }
    QCircleFolderNearbyTabFragment.d(this.a);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d(QCircleFolderNearbyTabFragment.B, 1, "requestGetGpsPermission result grant");
    QCircleFolderNearbyTabFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleFolderNearbyTabFragment.1
 * JD-Core Version:    0.7.0.1
 */