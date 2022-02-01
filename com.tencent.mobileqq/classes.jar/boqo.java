import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.data.AEGifMaterialManager.3;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class boqo
  implements beuq
{
  public boqo(AEGifMaterialManager.3 param3, String paramString) {}
  
  public void onResp(bevm parambevm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AEGifMaterialManager", 2, "onResp url: " + this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.a.packageUrl + " resultcode: " + parambevm.c);
    }
    if (boqm.a(this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.this$0, this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.a)) {}
    try
    {
      nof.a(new File(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.a.id), boev.e + File.separator);
      boqm.a(this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.this$0, this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.a);
      boqm.a(this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.this$0).remove(this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.a.id);
      return;
    }
    catch (IOException parambevm)
    {
      while (!QLog.isColorLevel()) {}
      parambevm.printStackTrace();
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    boqm.a(this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.this$0, this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.a, (int)(paramLong1 / paramLong2 * 100L));
    if (!boqm.a(this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.this$0).containsKey(this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.a.id)) {
      boqm.a(this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.this$0).put(this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.a.id, this.jdField_a_of_type_DovComQqImAeDataAEGifMaterialManager$3.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boqo
 * JD-Core Version:    0.7.0.1
 */