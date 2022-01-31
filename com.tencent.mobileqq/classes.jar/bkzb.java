import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

class bkzb
  implements bmac<List<bkvz>>
{
  bkzb(bkyz parambkyz, bkxm parambkxm) {}
  
  public void a(@Nullable List<bkvz> paramList)
  {
    bkyt.a(this.jdField_a_of_type_Bkyz.a).a().a(bkyt.a(this.jdField_a_of_type_Bkyz.a));
    QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material list state");
    int j;
    int i;
    if (paramList == null)
    {
      QLog.e("AEGIFChunkPreviewFragment", 4, "aeMaterialWrappers == null");
      if ((paramList != null) && (bkyt.a(this.jdField_a_of_type_Bkyz.a) != null))
      {
        QLog.e("AEGIFChunkPreviewFragment", 4, "Find materials num = " + paramList.size());
        j = Math.min(paramList.size(), this.jdField_a_of_type_Bkxm.b);
        Collections.shuffle(paramList);
        i = 0;
      }
    }
    for (;;)
    {
      bkxt localbkxt;
      if (i < j)
      {
        bkvz localbkvz = (bkvz)paramList.get(i);
        localbkxt = new bkxt();
        localbkxt.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = localbkvz.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial;
        QLog.d("AEGIFChunkPreviewFragment", 4, "Assigning material to item index = " + i + "material id = " + localbkvz.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
        localbkxt.b = 0;
        localbkxt.jdField_a_of_type_Int = 10;
        localbkxt.jdField_a_of_type_JavaLangString = "";
        blen.a().h(localbkvz.jdField_a_of_type_JavaLangString);
        if (bkyt.a(this.jdField_a_of_type_Bkyz.a).size() < bkyt.a(this.jdField_a_of_type_Bkyz.a)) {}
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
      bkyt.a(this.jdField_a_of_type_Bkyz.a).add(localbkxt);
      bkyt.a(this.jdField_a_of_type_Bkyz.a).notifyItemInserted(bkyt.a(this.jdField_a_of_type_Bkyz.a).size() - 1);
      bkyt.a(this.jdField_a_of_type_Bkyz.a).a(bllv.a(), localbkxt);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzb
 * JD-Core Version:    0.7.0.1
 */