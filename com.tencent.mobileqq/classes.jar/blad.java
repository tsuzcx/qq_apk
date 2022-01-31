import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.data.AEMaterialMgr.1;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class blad
  implements baug
{
  public blad(AEMaterialMgr.1 param1, String paramString) {}
  
  public void onResp(bavf parambavf)
  {
    if (QLog.isColorLevel()) {
      QLog.i(blac.a(), 2, "onResp url: " + this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.packageUrl + " resultcode: " + parambavf.c);
    }
    if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a)) {}
    try
    {
      ndr.a(new File(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.id), bkoz.e + File.separator);
      blac.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a);
      blac.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0).remove(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.id);
      return;
    }
    catch (IOException parambavf)
    {
      while (!QLog.isColorLevel()) {}
      parambavf.printStackTrace();
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2)
  {
    blac.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a, (int)(paramLong1 / paramLong2 * 100L));
    if (!blac.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0).containsKey(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.id)) {
      blac.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0).put(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.id, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blad
 * JD-Core Version:    0.7.0.1
 */