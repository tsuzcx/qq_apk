import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

class blyi
  implements Observer<blvg>
{
  blyi(blyh paramblyh, blwu paramblwu) {}
  
  public void a(@Nullable blvg paramblvg)
  {
    QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material download state");
    if ((paramblvg == null) || (blyb.a(this.jdField_a_of_type_Blyh.a) == null)) {}
    label360:
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_Blwu.jdField_a_of_type_Int + 1;
      for (;;)
      {
        if (i >= blyb.a(this.jdField_a_of_type_Blyh.a).size()) {
          break label360;
        }
        blxb localblxb = (blxb)blyb.a(this.jdField_a_of_type_Blyh.a).get(i);
        if ((localblxb != null) && (localblxb.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null) && (localblxb.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id.equals(paramblvg.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id)))
        {
          if (localblxb.jdField_b_of_type_Int != paramblvg.jdField_a_of_type_Int) {
            localblxb.jdField_b_of_type_Int = paramblvg.jdField_a_of_type_Int;
          }
          if (localblxb.jdField_b_of_type_Int != 2) {
            break;
          }
          localblxb.jdField_b_of_type_JavaLangString = blut.a().a(localblxb.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
          QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Downloaded material", "path===" + localblxb.jdField_b_of_type_JavaLangString });
          paramblvg = new blzq();
          paramblvg.jdField_a_of_type_Int = i;
          paramblvg.jdField_a_of_type_JavaLangString = localblxb.jdField_b_of_type_JavaLangString;
          if ((localblxb.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null) && ((localblxb.jdField_a_of_type_JavaLangString == null) || (localblxb.jdField_a_of_type_JavaLangString.equals("")))) {
            if (localblxb.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename") != null)
            {
              paramblvg.jdField_b_of_type_JavaLangString = "";
              paramblvg.c = ((String)localblxb.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename"));
            }
          }
          for (;;)
          {
            blyb.a(this.jdField_a_of_type_Blyh.a).a(paramblvg);
            localblxb.jdField_a_of_type_Int = 12;
            blyb.a(this.jdField_a_of_type_Blyh.a).notifyItemChanged(i);
            return;
            paramblvg.jdField_b_of_type_JavaLangString = "";
            paramblvg.c = "";
            continue;
            if (localblxb.jdField_a_of_type_JavaLangString == null) {
              paramblvg.jdField_b_of_type_JavaLangString = "";
            } else {
              paramblvg.jdField_b_of_type_JavaLangString = localblxb.jdField_a_of_type_JavaLangString;
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blyi
 * JD-Core Version:    0.7.0.1
 */