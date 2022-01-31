import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.data.AEMaterialMgr.1;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class birg
  implements aysc
{
  public birg(AEMaterialMgr.1 param1, String paramString) {}
  
  public void onResp(aysz paramaysz)
  {
    if (QLog.isColorLevel()) {
      QLog.i(birf.a(), 2, "onResp url: " + this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.packageUrl + " resultcode: " + paramaysz.c);
    }
    if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a)) {}
    try
    {
      nav.a(new File(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.id), biiu.e + File.separator);
      birf.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a);
      birf.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0).remove(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.id);
      return;
    }
    catch (IOException paramaysz)
    {
      while (!QLog.isColorLevel()) {}
      paramaysz.printStackTrace();
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    birf.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a, (int)(paramLong1 / paramLong2 * 100L));
    if (!birf.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0).containsKey(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.id)) {
      birf.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0).put(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.id, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     birg
 * JD-Core Version:    0.7.0.1
 */