import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

class biuh
  implements bjos<birm>
{
  biuh(biug parambiug, bist parambist) {}
  
  public void a(@Nullable birm parambirm)
  {
    QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material download state");
    if ((parambirm == null) || (biua.a(this.jdField_a_of_type_Biug.a) == null)) {}
    label360:
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_Bist.jdField_a_of_type_Int + 1;
      for (;;)
      {
        if (i >= biua.a(this.jdField_a_of_type_Biug.a).size()) {
          break label360;
        }
        bita localbita = (bita)biua.a(this.jdField_a_of_type_Biug.a).get(i);
        if ((localbita != null) && (localbita.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null) && (localbita.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id.equals(parambirm.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id)))
        {
          if (localbita.jdField_b_of_type_Int != parambirm.jdField_a_of_type_Int) {
            localbita.jdField_b_of_type_Int = parambirm.jdField_a_of_type_Int;
          }
          if (localbita.jdField_b_of_type_Int != 2) {
            break;
          }
          localbita.jdField_b_of_type_JavaLangString = birf.a().a(localbita.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
          QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Downloaded material", "path===" + localbita.jdField_b_of_type_JavaLangString });
          parambirm = new bivq();
          parambirm.jdField_a_of_type_Int = i;
          parambirm.jdField_a_of_type_JavaLangString = localbita.jdField_b_of_type_JavaLangString;
          if ((localbita.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null) && ((localbita.jdField_a_of_type_JavaLangString == null) || (localbita.jdField_a_of_type_JavaLangString.equals("")))) {
            if (localbita.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename") != null)
            {
              parambirm.jdField_b_of_type_JavaLangString = "";
              parambirm.c = ((String)localbita.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename"));
            }
          }
          for (;;)
          {
            biua.a(this.jdField_a_of_type_Biug.a).a(parambirm);
            localbita.jdField_a_of_type_Int = 12;
            biua.a(this.jdField_a_of_type_Biug.a).notifyItemChanged(i);
            return;
            parambirm.jdField_b_of_type_JavaLangString = "";
            parambirm.c = "";
            continue;
            if (localbita.jdField_a_of_type_JavaLangString == null) {
              parambirm.jdField_b_of_type_JavaLangString = "";
            } else {
              parambirm.jdField_b_of_type_JavaLangString = localbita.jdField_a_of_type_JavaLangString;
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biuh
 * JD-Core Version:    0.7.0.1
 */