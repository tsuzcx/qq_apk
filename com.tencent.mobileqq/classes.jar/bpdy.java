import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import com.tencent.common.app.AppInterface;
import java.util.ArrayList;

class bpdy
  implements bpex
{
  bpdy(bpdx parambpdx, AppInterface paramAppInterface, bpdz parambpdz, bpeu parambpeu) {}
  
  public void a(int paramInt)
  {
    bpam.b(bpdx.a(), "proxy onProcessFailed: errCode=" + paramInt);
    if (this.jdField_a_of_type_Bpdz != null) {
      this.jdField_a_of_type_Bpdz.a(paramInt, this.jdField_a_of_type_Bpeu.a());
    }
  }
  
  public void a(ArrayList<SmartFilterReqItem> paramArrayList)
  {
    bpam.b(bpdx.a(), "proxy onDataReadyForRequest");
    bpdx.a(this.jdField_a_of_type_Bpdx, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpdy
 * JD-Core Version:    0.7.0.1
 */