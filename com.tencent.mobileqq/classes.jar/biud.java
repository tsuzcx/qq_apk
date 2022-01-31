import android.view.View;
import android.view.View.OnClickListener;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class biud
  implements View.OnClickListener
{
  biud(biua parambiua) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    biua.a(this.a, true);
    paramView = biua.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, selectedItems = " + paramView);
    Object localObject = bizx.a();
    ((bizx)localObject).k();
    int i = 0;
    while (i < biua.a(this.a).size()) {
      if (!paramView.contains(Integer.valueOf(i)))
      {
        i += 1;
      }
      else
      {
        if (((bita)biua.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null)
        {
          ((bizx)localObject).k(((bita)biua.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
          ((bizx)localObject).i("none");
          ((bizx)localObject).j("none");
        }
        for (;;)
        {
          bizt.a().J();
          break;
          if (!((bita)biua.a(this.a).get(i)).jdField_a_of_type_JavaLangString.equals(""))
          {
            ((bizx)localObject).k("none");
            ((bizx)localObject).i(((bitd)bitc.jdField_a_of_type_JavaUtilList.get(bitc.jdField_a_of_type_ArrayOfInt[(i % bitc.jdField_a_of_type_ArrayOfInt.length)])).jdField_a_of_type_JavaLangString);
            ((bizx)localObject).j(((bita)biua.a(this.a).get(i)).jdField_a_of_type_JavaLangString);
          }
          else
          {
            ((bizx)localObject).k("none");
            ((bizx)localObject).i("none");
            ((bizx)localObject).j("none");
          }
        }
      }
    }
    biua.a(this.a).a(false);
    localObject = biua.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, pngDirs = " + ((bivr)localObject).a + ", texts = " + ((bivr)localObject).b);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    i = j;
    if (i < ((bivr)localObject).a.size())
    {
      if (paramView.contains(((bivr)localObject).d.get(i)))
      {
        if ((i != 0) || (biua.a(this.a) == null)) {
          break label474;
        }
        localArrayList1.add(biua.a(this.a).jdField_a_of_type_JavaLangString);
        localArrayList2.add(biua.a(this.a).b);
        localArrayList3.add(biua.a(this.a).c);
      }
      for (;;)
      {
        i += 1;
        break;
        label474:
        localArrayList1.add(((bivr)localObject).a.get(i));
        localArrayList2.add(((bivr)localObject).b.get(i));
        localArrayList3.add(((bivr)localObject).c.get(i));
      }
    }
    biua.a(this.a, localArrayList1, localArrayList2, localArrayList3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biud
 * JD-Core Version:    0.7.0.1
 */