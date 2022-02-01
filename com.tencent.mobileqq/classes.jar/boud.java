import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

class boud
  implements Observer<boqz>
{
  boud(bouc parambouc, bosp parambosp) {}
  
  public void a(@Nullable boqz paramboqz)
  {
    QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material download state");
    if ((paramboqz == null) || (botw.a(this.jdField_a_of_type_Bouc.a) == null)) {}
    label360:
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_Bosp.jdField_a_of_type_Int + 1;
      for (;;)
      {
        if (i >= botw.a(this.jdField_a_of_type_Bouc.a).size()) {
          break label360;
        }
        bosw localbosw = (bosw)botw.a(this.jdField_a_of_type_Bouc.a).get(i);
        if ((localbosw != null) && (localbosw.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null) && (localbosw.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id.equals(paramboqz.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id)))
        {
          if (localbosw.jdField_b_of_type_Int != paramboqz.jdField_a_of_type_Int) {
            localbosw.jdField_b_of_type_Int = paramboqz.jdField_a_of_type_Int;
          }
          if (localbosw.jdField_b_of_type_Int != 2) {
            break;
          }
          localbosw.jdField_b_of_type_JavaLangString = boqm.a().a(localbosw.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
          QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Downloaded material", "path===" + localbosw.jdField_b_of_type_JavaLangString });
          paramboqz = new bovl();
          paramboqz.jdField_a_of_type_Int = i;
          paramboqz.jdField_a_of_type_JavaLangString = localbosw.jdField_b_of_type_JavaLangString;
          if ((localbosw.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null) && ((localbosw.jdField_a_of_type_JavaLangString == null) || (localbosw.jdField_a_of_type_JavaLangString.equals("")))) {
            if (localbosw.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename") != null)
            {
              paramboqz.jdField_b_of_type_JavaLangString = "";
              paramboqz.c = ((String)localbosw.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename"));
            }
          }
          for (;;)
          {
            botw.a(this.jdField_a_of_type_Bouc.a).a(paramboqz);
            localbosw.jdField_a_of_type_Int = 12;
            botw.a(this.jdField_a_of_type_Bouc.a).notifyItemChanged(i);
            return;
            paramboqz.jdField_b_of_type_JavaLangString = "";
            paramboqz.c = "";
            continue;
            if (localbosw.jdField_a_of_type_JavaLangString == null) {
              paramboqz.jdField_b_of_type_JavaLangString = "";
            } else {
              paramboqz.jdField_b_of_type_JavaLangString = localbosw.jdField_a_of_type_JavaLangString;
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boud
 * JD-Core Version:    0.7.0.1
 */