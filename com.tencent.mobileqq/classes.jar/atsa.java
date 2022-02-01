import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;

public class atsa
  implements zvk
{
  public atsa(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment", 2, "onRefresh");
    }
    this.a.g();
    SosoInterface.SosoLbsInfo localSosoLbsInfo = NearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo;
    if (localSosoLbsInfo == null) {
      localSosoLbsInfo = SosoInterface.getSosoInfo();
    }
    for (;;)
    {
      if (localSosoLbsInfo != null) {
        ((amxd)this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3)).a((float)localSosoLbsInfo.mLocation.mLon02, (float)localSosoLbsInfo.mLocation.mLat02, 5);
      }
      this.a.jdField_a_of_type_ComTencentBizUiRefreshView.b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atsa
 * JD-Core Version:    0.7.0.1
 */