import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

class bldi
  implements bmeo<List<blag>>
{
  bldi(bldg parambldg, blbt paramblbt) {}
  
  public void a(@Nullable List<blag> paramList)
  {
    blda.a(this.jdField_a_of_type_Bldg.a).a().a(blda.a(this.jdField_a_of_type_Bldg.a));
    QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material list state");
    int j;
    int i;
    if (paramList == null)
    {
      QLog.e("AEGIFChunkPreviewFragment", 4, "aeMaterialWrappers == null");
      if ((paramList != null) && (blda.a(this.jdField_a_of_type_Bldg.a) != null))
      {
        QLog.e("AEGIFChunkPreviewFragment", 4, "Find materials num = " + paramList.size());
        j = Math.min(paramList.size(), this.jdField_a_of_type_Blbt.b);
        Collections.shuffle(paramList);
        i = 0;
      }
    }
    for (;;)
    {
      blca localblca;
      if (i < j)
      {
        blag localblag = (blag)paramList.get(i);
        localblca = new blca();
        localblca.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = localblag.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial;
        QLog.d("AEGIFChunkPreviewFragment", 4, "Assigning material to item index = " + i + "material id = " + localblag.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
        localblca.b = 0;
        localblca.jdField_a_of_type_Int = 10;
        localblca.jdField_a_of_type_JavaLangString = "";
        bliu.a().h(localblag.jdField_a_of_type_JavaLangString);
        if (blda.a(this.jdField_a_of_type_Bldg.a).size() < blda.a(this.jdField_a_of_type_Bldg.a)) {}
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
      blda.a(this.jdField_a_of_type_Bldg.a).add(localblca);
      blda.a(this.jdField_a_of_type_Bldg.a).notifyItemInserted(blda.a(this.jdField_a_of_type_Bldg.a).size() - 1);
      blda.a(this.jdField_a_of_type_Bldg.a).a(blqh.a(), localblca);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldi
 * JD-Core Version:    0.7.0.1
 */