import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

class bkza
  implements bmac<bkwc>
{
  bkza(bkyz parambkyz, bkxm parambkxm) {}
  
  public void a(@Nullable bkwc parambkwc)
  {
    QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material download state");
    if ((parambkwc == null) || (bkyt.a(this.jdField_a_of_type_Bkyz.a) == null)) {}
    label360:
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_Bkxm.jdField_a_of_type_Int + 1;
      for (;;)
      {
        if (i >= bkyt.a(this.jdField_a_of_type_Bkyz.a).size()) {
          break label360;
        }
        bkxt localbkxt = (bkxt)bkyt.a(this.jdField_a_of_type_Bkyz.a).get(i);
        if ((localbkxt != null) && (localbkxt.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null) && (localbkxt.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id.equals(parambkwc.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id)))
        {
          if (localbkxt.jdField_b_of_type_Int != parambkwc.jdField_a_of_type_Int) {
            localbkxt.jdField_b_of_type_Int = parambkwc.jdField_a_of_type_Int;
          }
          if (localbkxt.jdField_b_of_type_Int != 2) {
            break;
          }
          localbkxt.jdField_b_of_type_JavaLangString = bkvv.a().a(localbkxt.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
          QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Downloaded material", "path===" + localbkxt.jdField_b_of_type_JavaLangString });
          parambkwc = new blak();
          parambkwc.jdField_a_of_type_Int = i;
          parambkwc.jdField_a_of_type_JavaLangString = localbkxt.jdField_b_of_type_JavaLangString;
          if ((localbkxt.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null) && ((localbkxt.jdField_a_of_type_JavaLangString == null) || (localbkxt.jdField_a_of_type_JavaLangString.equals("")))) {
            if (localbkxt.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename") != null)
            {
              parambkwc.jdField_b_of_type_JavaLangString = "";
              parambkwc.c = ((String)localbkxt.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename"));
            }
          }
          for (;;)
          {
            bkyt.a(this.jdField_a_of_type_Bkyz.a).a(parambkwc);
            localbkxt.jdField_a_of_type_Int = 12;
            bkyt.a(this.jdField_a_of_type_Bkyz.a).notifyItemChanged(i);
            return;
            parambkwc.jdField_b_of_type_JavaLangString = "";
            parambkwc.c = "";
            continue;
            if (localbkxt.jdField_a_of_type_JavaLangString == null) {
              parambkwc.jdField_b_of_type_JavaLangString = "";
            } else {
              parambkwc.jdField_b_of_type_JavaLangString = localbkxt.jdField_a_of_type_JavaLangString;
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkza
 * JD-Core Version:    0.7.0.1
 */