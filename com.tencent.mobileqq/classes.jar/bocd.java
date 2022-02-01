import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import com.tencent.common.app.AppInterface;
import java.util.ArrayList;

class bocd
  implements bodc
{
  bocd(bocc parambocc, AppInterface paramAppInterface, boce paramboce, bocz parambocz) {}
  
  public void a(int paramInt)
  {
    bnzb.b(bocc.a(), "proxy onProcessFailed: errCode=" + paramInt);
    if (this.jdField_a_of_type_Boce != null) {
      this.jdField_a_of_type_Boce.a(paramInt, this.jdField_a_of_type_Bocz.a());
    }
  }
  
  public void a(ArrayList<SmartFilterReqItem> paramArrayList)
  {
    bnzb.b(bocc.a(), "proxy onDataReadyForRequest");
    bocc.a(this.jdField_a_of_type_Bocc, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bocd
 * JD-Core Version:    0.7.0.1
 */