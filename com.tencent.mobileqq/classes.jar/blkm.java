import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import com.tencent.common.app.AppInterface;
import java.util.ArrayList;

class blkm
  implements bllh
{
  blkm(blkl paramblkl, AppInterface paramAppInterface, blkn paramblkn, blle paramblle) {}
  
  public void a(int paramInt)
  {
    bljn.b(blkl.a(), "proxy onProcessFailed: errCode=" + paramInt);
    if (this.jdField_a_of_type_Blkn != null) {
      this.jdField_a_of_type_Blkn.a(paramInt, this.jdField_a_of_type_Blle.a());
    }
  }
  
  public void a(ArrayList<SmartFilterReqItem> paramArrayList)
  {
    bljn.b(blkl.a(), "proxy onDataReadyForRequest");
    blkl.a(this.jdField_a_of_type_Blkl, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blkm
 * JD-Core Version:    0.7.0.1
 */