import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

class bnsp
  implements Observer<bnpn>
{
  bnsp(bnso parambnso, bnrb parambnrb) {}
  
  public void a(@Nullable bnpn parambnpn)
  {
    QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material download state");
    if ((parambnpn == null) || (bnsi.a(this.jdField_a_of_type_Bnso.a) == null)) {}
    label360:
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_Bnrb.jdField_a_of_type_Int + 1;
      for (;;)
      {
        if (i >= bnsi.a(this.jdField_a_of_type_Bnso.a).size()) {
          break label360;
        }
        bnri localbnri = (bnri)bnsi.a(this.jdField_a_of_type_Bnso.a).get(i);
        if ((localbnri != null) && (localbnri.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null) && (localbnri.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id.equals(parambnpn.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id)))
        {
          if (localbnri.jdField_b_of_type_Int != parambnpn.jdField_a_of_type_Int) {
            localbnri.jdField_b_of_type_Int = parambnpn.jdField_a_of_type_Int;
          }
          if (localbnri.jdField_b_of_type_Int != 2) {
            break;
          }
          localbnri.jdField_b_of_type_JavaLangString = bnpg.a().a(localbnri.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
          QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Downloaded material", "path===" + localbnri.jdField_b_of_type_JavaLangString });
          parambnpn = new bntz();
          parambnpn.jdField_a_of_type_Int = i;
          parambnpn.jdField_a_of_type_JavaLangString = localbnri.jdField_b_of_type_JavaLangString;
          if ((localbnri.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null) && ((localbnri.jdField_a_of_type_JavaLangString == null) || (localbnri.jdField_a_of_type_JavaLangString.equals("")))) {
            if (localbnri.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename") != null)
            {
              parambnpn.jdField_b_of_type_JavaLangString = "";
              parambnpn.c = ((String)localbnri.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename"));
            }
          }
          for (;;)
          {
            bnsi.a(this.jdField_a_of_type_Bnso.a).a(parambnpn);
            localbnri.jdField_a_of_type_Int = 12;
            bnsi.a(this.jdField_a_of_type_Bnso.a).notifyItemChanged(i);
            return;
            parambnpn.jdField_b_of_type_JavaLangString = "";
            parambnpn.c = "";
            continue;
            if (localbnri.jdField_a_of_type_JavaLangString == null) {
              parambnpn.jdField_b_of_type_JavaLangString = "";
            } else {
              parambnpn.jdField_b_of_type_JavaLangString = localbnri.jdField_a_of_type_JavaLangString;
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsp
 * JD-Core Version:    0.7.0.1
 */