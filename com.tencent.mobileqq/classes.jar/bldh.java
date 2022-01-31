import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

class bldh
  implements bmeo<blaj>
{
  bldh(bldg parambldg, blbt paramblbt) {}
  
  public void a(@Nullable blaj paramblaj)
  {
    QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material download state");
    if ((paramblaj == null) || (blda.a(this.jdField_a_of_type_Bldg.a) == null)) {}
    label360:
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_Blbt.jdField_a_of_type_Int + 1;
      for (;;)
      {
        if (i >= blda.a(this.jdField_a_of_type_Bldg.a).size()) {
          break label360;
        }
        blca localblca = (blca)blda.a(this.jdField_a_of_type_Bldg.a).get(i);
        if ((localblca != null) && (localblca.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null) && (localblca.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id.equals(paramblaj.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id)))
        {
          if (localblca.jdField_b_of_type_Int != paramblaj.jdField_a_of_type_Int) {
            localblca.jdField_b_of_type_Int = paramblaj.jdField_a_of_type_Int;
          }
          if (localblca.jdField_b_of_type_Int != 2) {
            break;
          }
          localblca.jdField_b_of_type_JavaLangString = blac.a().a(localblca.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
          QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Downloaded material", "path===" + localblca.jdField_b_of_type_JavaLangString });
          paramblaj = new bler();
          paramblaj.jdField_a_of_type_Int = i;
          paramblaj.jdField_a_of_type_JavaLangString = localblca.jdField_b_of_type_JavaLangString;
          if ((localblca.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null) && ((localblca.jdField_a_of_type_JavaLangString == null) || (localblca.jdField_a_of_type_JavaLangString.equals("")))) {
            if (localblca.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename") != null)
            {
              paramblaj.jdField_b_of_type_JavaLangString = "";
              paramblaj.c = ((String)localblca.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename"));
            }
          }
          for (;;)
          {
            blda.a(this.jdField_a_of_type_Bldg.a).a(paramblaj);
            localblca.jdField_a_of_type_Int = 12;
            blda.a(this.jdField_a_of_type_Bldg.a).notifyItemChanged(i);
            return;
            paramblaj.jdField_b_of_type_JavaLangString = "";
            paramblaj.c = "";
            continue;
            if (localblca.jdField_a_of_type_JavaLangString == null) {
              paramblaj.jdField_b_of_type_JavaLangString = "";
            } else {
              paramblaj.jdField_b_of_type_JavaLangString = localblca.jdField_a_of_type_JavaLangString;
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldh
 * JD-Core Version:    0.7.0.1
 */