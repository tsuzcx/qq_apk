import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import com.tencent.common.app.AppInterface;
import java.util.ArrayList;

class bmfi
  implements bmgj
{
  bmfi(bmfh parambmfh, AppInterface paramAppInterface, bmgg parambmgg, bmfk parambmfk) {}
  
  public void a(int paramInt)
  {
    bmbx.b(bmfh.a(), "proxy onProcessFailed: errCode=" + paramInt);
    if (this.jdField_a_of_type_Bmfk != null) {
      this.jdField_a_of_type_Bmfk.a(paramInt, this.jdField_a_of_type_Bmgg.a());
    }
  }
  
  public void a(ArrayList<SmartFilterReqItem> paramArrayList)
  {
    bmbx.b(bmfh.a(), "proxy onDataReadyForRequest");
    bmfh.a(this.jdField_a_of_type_Bmfh, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramArrayList, new bmfj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfi
 * JD-Core Version:    0.7.0.1
 */