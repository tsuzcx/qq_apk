import android.text.TextUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class apou
  extends ajne
{
  public apou(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment", 2, "onSetFilterList");
    }
    ascv localascv = new ascv();
    localascv.jdField_a_of_type_Int = paramInt1;
    localascv.jdField_b_of_type_Int = paramInt2;
    localascv.jdField_c_of_type_Int = paramInt3;
    localascv.jdField_d_of_type_Int = paramInt4;
    localascv.e = paramInt9;
    localascv.f = paramInt5;
    localascv.jdField_d_of_type_ArrayOfJavaLangString[0] = String.valueOf(paramInt6);
    localascv.jdField_d_of_type_ArrayOfJavaLangString[1] = String.valueOf(paramInt7);
    localascv.jdField_d_of_type_ArrayOfJavaLangString[2] = String.valueOf(paramInt8);
    localascv.jdField_b_of_type_JavaLangString = paramString1;
    localascv.jdField_c_of_type_JavaLangString = paramString2;
    localascv.jdField_d_of_type_JavaLangString = paramString3;
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
    localascv.jdField_a_of_type_JavaLangString = paramString1;
    if (!localascv.equals(this.a.jdField_a_of_type_Ascv)) {
      localascv.jdField_a_of_type_Boolean = true;
    }
    this.a.jdField_a_of_type_Ascv = localascv;
    if ((((alzo)this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(210)).a() == 0) && (this.a.jdField_a_of_type_Ascv != null) && (this.a.jdField_a_of_type_Ascv.jdField_a_of_type_Boolean)) {
      ascv.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), this.a.jdField_a_of_type_Ascv);
    }
  }
  
  protected void a(boolean paramBoolean, List<ilive_feeds_near_anchor.NearAnchorInfo> paramList)
  {
    QLog.e("nearby.NearbyHybridFragment", 2, "onNearbyLiveFeedAnchor isSucc:" + paramBoolean);
    if ((paramBoolean) && (paramList.size() > 0))
    {
      this.a.jdField_a_of_type_Asdk.b(paramList);
      return;
    }
    this.a.jdField_a_of_type_Asdk.b(null);
  }
  
  public void b()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
    this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apou
 * JD-Core Version:    0.7.0.1
 */