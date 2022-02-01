import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

class bnsq
  implements Observer<List<bnpk>>
{
  bnsq(bnso parambnso, bnrb parambnrb) {}
  
  public void a(@Nullable List<bnpk> paramList)
  {
    bnsi.a(this.jdField_a_of_type_Bnso.a).a().removeObservers(bnsi.a(this.jdField_a_of_type_Bnso.a));
    QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material list state");
    int j;
    int i;
    if (paramList == null)
    {
      QLog.e("AEGIFChunkPreviewFragment", 4, "aeMaterialWrappers == null");
      if ((paramList != null) && (bnsi.a(this.jdField_a_of_type_Bnso.a) != null))
      {
        QLog.e("AEGIFChunkPreviewFragment", 4, "Find materials num = " + paramList.size());
        j = Math.min(paramList.size(), this.jdField_a_of_type_Bnrb.b);
        Collections.shuffle(paramList);
        i = 0;
      }
    }
    for (;;)
    {
      bnri localbnri;
      if (i < j)
      {
        bnpk localbnpk = (bnpk)paramList.get(i);
        localbnri = new bnri();
        localbnri.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = localbnpk.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial;
        QLog.d("AEGIFChunkPreviewFragment", 4, "Assigning material to item index = " + i + "material id = " + localbnpk.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
        localbnri.b = 0;
        localbnri.jdField_a_of_type_Int = 10;
        localbnri.jdField_a_of_type_JavaLangString = "";
        bnyh.a().i(localbnpk.jdField_a_of_type_JavaLangString);
        if (bnsi.a(this.jdField_a_of_type_Bnso.a).size() < bnsi.a(this.jdField_a_of_type_Bnso.a)) {}
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
      bnsi.a(this.jdField_a_of_type_Bnso.a).add(localbnri);
      bnsi.a(this.jdField_a_of_type_Bnso.a).notifyItemInserted(bnsi.a(this.jdField_a_of_type_Bnso.a).size() - 1);
      bnsi.a(this.jdField_a_of_type_Bnso.a).a(bojl.a(), localbnri);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsq
 * JD-Core Version:    0.7.0.1
 */