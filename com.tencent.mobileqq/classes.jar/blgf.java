import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import com.tencent.common.app.AppInterface;
import java.util.ArrayList;

class blgf
  implements blgz
{
  blgf(blge paramblge, AppInterface paramAppInterface, blgg paramblgg, blgw paramblgw) {}
  
  public void a(int paramInt)
  {
    blfg.b(blge.a(), "proxy onProcessFailed: errCode=" + paramInt);
    if (this.jdField_a_of_type_Blgg != null) {
      this.jdField_a_of_type_Blgg.a(paramInt, this.jdField_a_of_type_Blgw.a());
    }
  }
  
  public void a(ArrayList<SmartFilterReqItem> paramArrayList)
  {
    blfg.b(blge.a(), "proxy onDataReadyForRequest");
    blge.a(this.jdField_a_of_type_Blge, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blgf
 * JD-Core Version:    0.7.0.1
 */