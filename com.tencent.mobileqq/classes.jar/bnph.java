import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.data.AEMaterialMgr.1;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class bnph
  implements bdvw
{
  public bnph(AEMaterialMgr.1 param1, String paramString) {}
  
  public void onResp(bdwt parambdwt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(bnpg.a(), 2, "onResp url: " + this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.packageUrl + " resultcode: " + parambdwt.c);
    }
    if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a)) {}
    try
    {
      nmk.a(new File(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.id), bndm.e + File.separator);
      bnpg.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a);
      bnpg.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0).remove(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.id);
      return;
    }
    catch (IOException parambdwt)
    {
      while (!QLog.isColorLevel()) {}
      parambdwt.printStackTrace();
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    bnpg.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a, (int)(paramLong1 / paramLong2 * 100L));
    if (!bnpg.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0).containsKey(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.id)) {
      bnpg.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0).put(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.id, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnph
 * JD-Core Version:    0.7.0.1
 */