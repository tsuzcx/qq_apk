import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.data.AEMaterialMgr.1;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class bkvw
  implements bapx
{
  public bkvw(AEMaterialMgr.1 param1, String paramString) {}
  
  public void onResp(baqw parambaqw)
  {
    if (QLog.isColorLevel()) {
      QLog.i(bkvv.a(), 2, "onResp url: " + this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.packageUrl + " resultcode: " + parambaqw.c);
    }
    if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a)) {}
    try
    {
      ndr.a(new File(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.id), bkks.e + File.separator);
      bkvv.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a);
      bkvv.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0).remove(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.id);
      return;
    }
    catch (IOException parambaqw)
    {
      while (!QLog.isColorLevel()) {}
      parambaqw.printStackTrace();
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    bkvv.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a, (int)(paramLong1 / paramLong2 * 100L));
    if (!bkvv.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0).containsKey(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.id)) {
      bkvv.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.this$0).put(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a.id, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMgr$1.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkvw
 * JD-Core Version:    0.7.0.1
 */