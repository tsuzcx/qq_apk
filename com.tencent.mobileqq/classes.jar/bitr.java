import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

class bitr
  implements bjob<List<biqs>>
{
  bitr(bitp parambitp, bisc parambisc) {}
  
  public void a(@Nullable List<biqs> paramList)
  {
    bitj.a(this.jdField_a_of_type_Bitp.a).a().a(bitj.a(this.jdField_a_of_type_Bitp.a));
    QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material list state");
    int j;
    int i;
    if (paramList == null)
    {
      QLog.e("AEGIFChunkPreviewFragment", 4, "aeMaterialWrappers == null");
      if ((paramList != null) && (bitj.a(this.jdField_a_of_type_Bitp.a) != null))
      {
        QLog.e("AEGIFChunkPreviewFragment", 4, "Find materials num = " + paramList.size());
        j = Math.min(paramList.size(), this.jdField_a_of_type_Bisc.b);
        Collections.shuffle(paramList);
        i = 0;
      }
    }
    for (;;)
    {
      bisj localbisj;
      if (i < j)
      {
        biqs localbiqs = (biqs)paramList.get(i);
        localbisj = new bisj();
        localbisj.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = localbiqs.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial;
        QLog.d("AEGIFChunkPreviewFragment", 4, "Assigning material to item index = " + i + "material id = " + localbiqs.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
        localbisj.b = 0;
        localbisj.jdField_a_of_type_Int = 10;
        localbisj.jdField_a_of_type_JavaLangString = "";
        bizc.a().g(localbiqs.jdField_a_of_type_JavaLangString);
        if (bitj.a(this.jdField_a_of_type_Bitp.a).size() < bitj.a(this.jdField_a_of_type_Bitp.a)) {}
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
      bitj.a(this.jdField_a_of_type_Bitp.a).add(localbisj);
      bitj.a(this.jdField_a_of_type_Bitp.a).notifyItemInserted(bitj.a(this.jdField_a_of_type_Bitp.a).size() - 1);
      bitj.a(this.jdField_a_of_type_Bitp.a).a(bizu.a(), localbisj);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bitr
 * JD-Core Version:    0.7.0.1
 */