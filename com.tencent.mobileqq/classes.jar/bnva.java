import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import com.tencent.common.app.AppInterface;
import java.util.ArrayList;

class bnva
  implements bnwb
{
  bnva(bnuz parambnuz, AppInterface paramAppInterface, bnvy parambnvy, bnvc parambnvc) {}
  
  public void a(int paramInt)
  {
    bnrh.b(bnuz.a(), "proxy onProcessFailed: errCode=" + paramInt);
    if (this.jdField_a_of_type_Bnvc != null) {
      this.jdField_a_of_type_Bnvc.a(paramInt, this.jdField_a_of_type_Bnvy.a());
    }
  }
  
  public void a(ArrayList<SmartFilterReqItem> paramArrayList)
  {
    bnrh.b(bnuz.a(), "proxy onDataReadyForRequest");
    bnuz.a(this.jdField_a_of_type_Bnuz, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramArrayList, new bnvb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnva
 * JD-Core Version:    0.7.0.1
 */