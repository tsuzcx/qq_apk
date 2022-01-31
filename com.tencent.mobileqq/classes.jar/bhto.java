import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

class bhto
  implements bhwg<wqg>
{
  bhto(bhtn parambhtn, bhso parambhso) {}
  
  public void a(@Nullable wqg paramwqg)
  {
    QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material download state");
    if ((paramwqg == null) || (bhtg.b(this.jdField_a_of_type_Bhtn.a) == null)) {
      return;
    }
    int i = this.jdField_a_of_type_Bhso.jdField_a_of_type_Int + 1;
    for (;;)
    {
      bhsf localbhsf;
      if (i < bhtg.b(this.jdField_a_of_type_Bhtn.a).size())
      {
        localbhsf = (bhsf)bhtg.b(this.jdField_a_of_type_Bhtn.a).get(i);
        if ((localbhsf == null) || (localbhsf.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial == null) || (!localbhsf.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id.equals(paramwqg.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id))) {
          break label406;
        }
        if (localbhsf.jdField_b_of_type_Int != paramwqg.jdField_a_of_type_Int) {
          localbhsf.jdField_b_of_type_Int = paramwqg.jdField_a_of_type_Int;
        }
        if (localbhsf.jdField_b_of_type_Int != 2) {
          break label376;
        }
        localbhsf.jdField_b_of_type_JavaLangString = wqh.a().a(localbhsf.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
        QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Downloaded material", "path===" + localbhsf.jdField_b_of_type_JavaLangString });
        paramwqg = new biaj();
        paramwqg.jdField_a_of_type_Int = i;
        paramwqg.jdField_a_of_type_JavaLangString = localbhsf.jdField_b_of_type_JavaLangString;
        if ((localbhsf.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial == null) || ((localbhsf.jdField_a_of_type_JavaLangString != null) && (!localbhsf.jdField_a_of_type_JavaLangString.equals("")))) {
          break label349;
        }
        if (localbhsf.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename") == null) {
          break label334;
        }
        paramwqg.jdField_b_of_type_JavaLangString = "";
        paramwqg.c = ((String)localbhsf.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename"));
        bhtg.b(this.jdField_a_of_type_Bhtn.a).a(paramwqg);
        localbhsf.jdField_a_of_type_Int = 12;
        bhtg.c(this.jdField_a_of_type_Bhtn.a).add(paramwqg);
      }
      for (;;)
      {
        bhtg.b(this.jdField_a_of_type_Bhtn.a, this.jdField_a_of_type_Bhso.a());
        return;
        label334:
        paramwqg.jdField_b_of_type_JavaLangString = "";
        paramwqg.c = "";
        break;
        label349:
        if (localbhsf.jdField_a_of_type_JavaLangString == null)
        {
          paramwqg.jdField_b_of_type_JavaLangString = "";
          break;
        }
        paramwqg.jdField_b_of_type_JavaLangString = localbhsf.jdField_a_of_type_JavaLangString;
        break;
        label376:
        if (localbhsf.jdField_b_of_type_Int == 0) {
          bhtg.d(this.jdField_a_of_type_Bhtn.a).add(Integer.valueOf(i));
        }
      }
      label406:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhto
 * JD-Core Version:    0.7.0.1
 */