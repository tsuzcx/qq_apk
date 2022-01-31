import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

class bhtp
  implements bhwg<List<wqk>>
{
  bhtp(bhtn parambhtn, bhso parambhso) {}
  
  public void a(@Nullable List<wqk> paramList)
  {
    bhtg.a(this.jdField_a_of_type_Bhtn.a).a().a(bhtg.a(this.jdField_a_of_type_Bhtn.a));
    QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material list state");
    int j;
    int i;
    if (paramList == null)
    {
      QLog.e("AEGIFChunkPreviewFragment", 4, "aeMaterialWrappers == null");
      if ((paramList != null) && (bhtg.b(this.jdField_a_of_type_Bhtn.a) != null))
      {
        QLog.e("AEGIFChunkPreviewFragment", 4, "Find materials num = " + paramList.size());
        j = Math.min(paramList.size(), this.jdField_a_of_type_Bhso.b);
        Collections.shuffle(paramList);
        i = 0;
      }
    }
    for (;;)
    {
      bhsf localbhsf;
      if (i < j)
      {
        wqk localwqk = (wqk)paramList.get(i);
        localbhsf = new bhsf();
        localbhsf.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = localwqk.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial;
        QLog.d("AEGIFChunkPreviewFragment", 4, "Assigning material to item index = " + i + "material id = " + localwqk.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
        localbhsf.b = 0;
        localbhsf.jdField_a_of_type_Int = 10;
        localbhsf.jdField_a_of_type_JavaLangString = "";
        bhci.a().g(localwqk.jdField_a_of_type_JavaLangString);
        if (bhtg.b(this.jdField_a_of_type_Bhtn.a).size() < bhtg.b(this.jdField_a_of_type_Bhtn.a)) {}
      }
      else
      {
        return;
        if (!paramList.isEmpty()) {
          break;
        }
        QLog.e("AEGIFChunkPreviewFragment", 4, "aeMaterialWrappers is empty");
        break;
      }
      bhtg.b(this.jdField_a_of_type_Bhtn.a).add(localbhsf);
      bhtg.a(this.jdField_a_of_type_Bhtn.a).notifyItemInserted(bhtg.b(this.jdField_a_of_type_Bhtn.a).size() - 1);
      bhtg.a(this.jdField_a_of_type_Bhtn.a).a(bhfc.a(), localbhsf);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhtp
 * JD-Core Version:    0.7.0.1
 */