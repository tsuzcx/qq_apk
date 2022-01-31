import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.data.AEMaterialMgr.1;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class biqp
  implements aysa
{
  public biqp(AEMaterialMgr.1 param1, String paramString) {}
  
  public void onResp(aysx paramaysx)
  {
    if (QLog.isColorLevel()) {
      QLog.i(biqo.a(), 2, "onResp url: " + this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.packageUrl + " resultcode: " + paramaysx.c);
    }
    if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a)) {}
    try
    {
      nay.a(new File(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.id), biid.e + File.separator);
      biqo.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a);
      biqo.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0).remove(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.id);
      return;
    }
    catch (IOException paramaysx)
    {
      while (!QLog.isColorLevel()) {}
      paramaysx.printStackTrace();
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2)
  {
    biqo.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a, (int)(paramLong1 / paramLong2 * 100L));
    if (!biqo.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0).containsKey(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.id)) {
      biqo.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0).put(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.id, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biqp
 * JD-Core Version:    0.7.0.1
 */