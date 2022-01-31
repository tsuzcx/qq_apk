import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.mini.out.CommonObserver;
import com.tencent.mobileqq.mini.out.CommonServlet;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.proto.lbsshare.LBSShare.LocationReq;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;

public class arbm
{
  private final int jdField_a_of_type_Int;
  private arbo jdField_a_of_type_Arbo;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private CommonObserver jdField_a_of_type_ComTencentMobileqqMiniOutCommonObserver = new arbn(this);
  private final String jdField_a_of_type_JavaLangString;
  private final List<LocationRoom.Venue> jdField_a_of_type_JavaUtilList = new ArrayList(20);
  private boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  arbm(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    paramBaseActivity = paramString;
    if (paramString == null) {
      paramBaseActivity = "";
    }
    this.jdField_a_of_type_JavaLangString = paramBaseActivity;
  }
  
  void a(arbo paramarbo)
  {
    this.jdField_a_of_type_Arbo = paramarbo;
  }
  
  public boolean a()
  {
    if ((this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Boolean)) {
      return false;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LocationPoiDataHelper", 4, "[venue][poi-data] fetch next: lat = " + this.jdField_a_of_type_Int + ", lon = " + this.jdField_b_of_type_Int + ", page = " + this.c + ", isSearching = " + this.jdField_b_of_type_Boolean + ", hasMore = " + this.jdField_a_of_type_Boolean);
    }
    this.jdField_b_of_type_Boolean = true;
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "LbsShareSvr.location");
    LBSShare.LocationReq localLocationReq = new LBSShare.LocationReq();
    localLocationReq.lat.set(this.jdField_a_of_type_Int);
    localLocationReq.lng.set(this.jdField_b_of_type_Int);
    localLocationReq.coordinate.set(1);
    localLocationReq.keyword.set(this.jdField_a_of_type_JavaLangString);
    localLocationReq.page.set(this.c);
    localLocationReq.count.set(20);
    localLocationReq.requireMyLbs.set(1);
    String str = babp.a();
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localLocationReq.imei.set((String)localObject);
    localToServiceMsg.putWupBuffer(localLocationReq.toByteArray());
    localToServiceMsg.addAttribute("is_pb_packet", Boolean.valueOf(true));
    localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getApplication(), CommonServlet.class);
    ((NewIntent)localObject).putExtra(ToServiceMsg.class.getSimpleName(), localToServiceMsg);
    ((NewIntent)localObject).setObserver(this.jdField_a_of_type_ComTencentMobileqqMiniOutCommonObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.startServlet((NewIntent)localObject);
    return true;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arbm
 * JD-Core Version:    0.7.0.1
 */