import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;

public class apox
  extends akgd
{
  public apox(NearbyHybridFragment paramNearbyHybridFragment, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, boolean paramBoolean3, boolean paramBoolean4, String paramString, long paramLong2)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong1, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    StringBuilder localStringBuilder = new StringBuilder().append("onLocationFinish, errCode=").append(paramInt).append(", timeCost=").append(l).append(", info==null?");
    if (paramSosoLbsInfo == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("nearby.NearbyHybridFragment.webloading", 1, bool + ", isTimeOut=" + this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.l);
      if ((paramInt == 0) && (paramSosoLbsInfo != null)) {
        break label188;
      }
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.a(false, paramInt, l);
      if (!this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.l) {
        break;
      }
      return;
    }
    if (badq.g(BaseApplicationImpl.getContext())) {
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 1, ajjy.a(2131641401), 1).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.d = 1;
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    return;
    label188:
    NearbyHybridFragment.jdField_a_of_type_Long = System.currentTimeMillis();
    NearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = paramSosoLbsInfo;
    asfc.a(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), paramSosoLbsInfo);
    if (!this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.l) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.e();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.a(true, paramInt, l);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.a(paramSosoLbsInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apox
 * JD-Core Version:    0.7.0.1
 */