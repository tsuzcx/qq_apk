import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

class bitq
  implements bjob<biqv>
{
  bitq(bitp parambitp, bisc parambisc) {}
  
  public void a(@Nullable biqv parambiqv)
  {
    QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material download state");
    if ((parambiqv == null) || (bitj.a(this.jdField_a_of_type_Bitp.a) == null)) {}
    label360:
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_Bisc.jdField_a_of_type_Int + 1;
      for (;;)
      {
        if (i >= bitj.a(this.jdField_a_of_type_Bitp.a).size()) {
          break label360;
        }
        bisj localbisj = (bisj)bitj.a(this.jdField_a_of_type_Bitp.a).get(i);
        if ((localbisj != null) && (localbisj.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null) && (localbisj.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id.equals(parambiqv.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id)))
        {
          if (localbisj.jdField_b_of_type_Int != parambiqv.jdField_a_of_type_Int) {
            localbisj.jdField_b_of_type_Int = parambiqv.jdField_a_of_type_Int;
          }
          if (localbisj.jdField_b_of_type_Int != 2) {
            break;
          }
          localbisj.jdField_b_of_type_JavaLangString = biqo.a().a(localbisj.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
          QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Downloaded material", "path===" + localbisj.jdField_b_of_type_JavaLangString });
          parambiqv = new biuz();
          parambiqv.jdField_a_of_type_Int = i;
          parambiqv.jdField_a_of_type_JavaLangString = localbisj.jdField_b_of_type_JavaLangString;
          if ((localbisj.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null) && ((localbisj.jdField_a_of_type_JavaLangString == null) || (localbisj.jdField_a_of_type_JavaLangString.equals("")))) {
            if (localbisj.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename") != null)
            {
              parambiqv.jdField_b_of_type_JavaLangString = "";
              parambiqv.c = ((String)localbisj.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename"));
            }
          }
          for (;;)
          {
            bitj.a(this.jdField_a_of_type_Bitp.a).a(parambiqv);
            localbisj.jdField_a_of_type_Int = 12;
            bitj.a(this.jdField_a_of_type_Bitp.a).notifyItemChanged(i);
            return;
            parambiqv.jdField_b_of_type_JavaLangString = "";
            parambiqv.c = "";
            continue;
            if (localbisj.jdField_a_of_type_JavaLangString == null) {
              parambiqv.jdField_b_of_type_JavaLangString = "";
            } else {
              parambiqv.jdField_b_of_type_JavaLangString = localbisj.jdField_a_of_type_JavaLangString;
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bitq
 * JD-Core Version:    0.7.0.1
 */