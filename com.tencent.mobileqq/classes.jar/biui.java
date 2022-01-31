import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

class biui
  implements bjos<List<birj>>
{
  biui(biug parambiug, bist parambist) {}
  
  public void a(@Nullable List<birj> paramList)
  {
    biua.a(this.jdField_a_of_type_Biug.a).a().a(biua.a(this.jdField_a_of_type_Biug.a));
    QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material list state");
    int j;
    int i;
    if (paramList == null)
    {
      QLog.e("AEGIFChunkPreviewFragment", 4, "aeMaterialWrappers == null");
      if ((paramList != null) && (biua.a(this.jdField_a_of_type_Biug.a) != null))
      {
        QLog.e("AEGIFChunkPreviewFragment", 4, "Find materials num = " + paramList.size());
        j = Math.min(paramList.size(), this.jdField_a_of_type_Bist.b);
        Collections.shuffle(paramList);
        i = 0;
      }
    }
    for (;;)
    {
      bita localbita;
      if (i < j)
      {
        birj localbirj = (birj)paramList.get(i);
        localbita = new bita();
        localbita.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = localbirj.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial;
        QLog.d("AEGIFChunkPreviewFragment", 4, "Assigning material to item index = " + i + "material id = " + localbirj.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
        localbita.b = 0;
        localbita.jdField_a_of_type_Int = 10;
        localbita.jdField_a_of_type_JavaLangString = "";
        bizt.a().g(localbirj.jdField_a_of_type_JavaLangString);
        if (biua.a(this.jdField_a_of_type_Biug.a).size() < biua.a(this.jdField_a_of_type_Biug.a)) {}
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
      biua.a(this.jdField_a_of_type_Biug.a).add(localbita);
      biua.a(this.jdField_a_of_type_Biug.a).notifyItemInserted(biua.a(this.jdField_a_of_type_Biug.a).size() - 1);
      biua.a(this.jdField_a_of_type_Biug.a).a(bjal.a(), localbita);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biui
 * JD-Core Version:    0.7.0.1
 */