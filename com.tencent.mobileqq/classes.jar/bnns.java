import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

class bnns
  implements Observer<bnkn>
{
  bnns(bnnr parambnnr, bnme parambnme) {}
  
  public void a(@Nullable bnkn parambnkn)
  {
    QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material download state");
    if ((parambnkn == null) || (bnnl.a(this.jdField_a_of_type_Bnnr.a) == null)) {}
    label360:
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_Bnme.jdField_a_of_type_Int + 1;
      for (;;)
      {
        if (i >= bnnl.a(this.jdField_a_of_type_Bnnr.a).size()) {
          break label360;
        }
        bnml localbnml = (bnml)bnnl.a(this.jdField_a_of_type_Bnnr.a).get(i);
        if ((localbnml != null) && (localbnml.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null) && (localbnml.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id.equals(parambnkn.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id)))
        {
          if (localbnml.jdField_b_of_type_Int != parambnkn.jdField_a_of_type_Int) {
            localbnml.jdField_b_of_type_Int = parambnkn.jdField_a_of_type_Int;
          }
          if (localbnml.jdField_b_of_type_Int != 2) {
            break;
          }
          localbnml.jdField_b_of_type_JavaLangString = bnjw.a().a(localbnml.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
          QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Downloaded material", "path===" + localbnml.jdField_b_of_type_JavaLangString });
          parambnkn = new bnpa();
          parambnkn.jdField_a_of_type_Int = i;
          parambnkn.jdField_a_of_type_JavaLangString = localbnml.jdField_b_of_type_JavaLangString;
          if ((localbnml.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null) && ((localbnml.jdField_a_of_type_JavaLangString == null) || (localbnml.jdField_a_of_type_JavaLangString.equals("")))) {
            if (localbnml.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename") != null)
            {
              parambnkn.jdField_b_of_type_JavaLangString = "";
              parambnkn.c = ((String)localbnml.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename"));
            }
          }
          for (;;)
          {
            bnnl.a(this.jdField_a_of_type_Bnnr.a).a(parambnkn);
            localbnml.jdField_a_of_type_Int = 12;
            bnnl.a(this.jdField_a_of_type_Bnnr.a).notifyItemChanged(i);
            return;
            parambnkn.jdField_b_of_type_JavaLangString = "";
            parambnkn.c = "";
            continue;
            if (localbnml.jdField_a_of_type_JavaLangString == null) {
              parambnkn.jdField_b_of_type_JavaLangString = "";
            } else {
              parambnkn.jdField_b_of_type_JavaLangString = localbnml.jdField_a_of_type_JavaLangString;
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnns
 * JD-Core Version:    0.7.0.1
 */