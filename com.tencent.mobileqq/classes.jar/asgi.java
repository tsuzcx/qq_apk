import android.text.TextUtils;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import com.tencent.protobuf.nearbyPeopleRecommend.nearbyPeopleRecommend.QueryRspItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class asgi
  extends alxq
{
  public asgi(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void a(List<nearbyPeopleRecommend.QueryRspItem> paramList)
  {
    if ((this.a.b.getVisibility() == 0) && (paramList != null))
    {
      paramList = (nearbyPeopleRecommend.QueryRspItem)paramList.get(0);
      avso.a(paramList.msg_id.get(), paramList.rd_people.get());
      NearbyHybridFragment.a(this.a);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment", 2, "onSetFilterList");
    }
    auuh localauuh = new auuh();
    localauuh.jdField_a_of_type_Int = paramInt1;
    localauuh.jdField_b_of_type_Int = paramInt2;
    localauuh.jdField_c_of_type_Int = paramInt3;
    localauuh.jdField_d_of_type_Int = paramInt4;
    localauuh.e = paramInt9;
    localauuh.f = paramInt5;
    localauuh.jdField_d_of_type_ArrayOfJavaLangString[0] = String.valueOf(paramInt6);
    localauuh.jdField_d_of_type_ArrayOfJavaLangString[1] = String.valueOf(paramInt7);
    localauuh.jdField_d_of_type_ArrayOfJavaLangString[2] = String.valueOf(paramInt8);
    localauuh.jdField_b_of_type_JavaLangString = paramString1;
    localauuh.jdField_c_of_type_JavaLangString = paramString2;
    localauuh.jdField_d_of_type_JavaLangString = paramString3;
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1)) {
      localStringBuilder.append(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localStringBuilder.append("-").append(paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localStringBuilder.append("-").append(paramString3);
    }
    paramString2 = localStringBuilder.toString();
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "不限";
    }
    localauuh.jdField_a_of_type_JavaLangString = paramString1;
    if (!localauuh.equals(this.a.jdField_a_of_type_Auuh)) {
      localauuh.jdField_a_of_type_Boolean = true;
    }
    this.a.jdField_a_of_type_Auuh = localauuh;
    if ((((aokk)this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(210)).a() == 0) && (this.a.jdField_a_of_type_Auuh != null) && (this.a.jdField_a_of_type_Auuh.jdField_a_of_type_Boolean)) {
      auuh.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), this.a.jdField_a_of_type_Auuh);
    }
  }
  
  protected void a(boolean paramBoolean, List<ilive_feeds_near_anchor.NearAnchorInfo> paramList)
  {
    QLog.e("nearby.NearbyHybridFragment", 2, "onNearbyLiveFeedAnchor isSucc:" + paramBoolean);
    if ((paramBoolean) && (paramList.size() > 0))
    {
      this.a.jdField_a_of_type_Auuw.b(paramList);
      return;
    }
    this.a.jdField_a_of_type_Auuw.b(null);
  }
  
  public void b()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
    this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgi
 * JD-Core Version:    0.7.0.1
 */