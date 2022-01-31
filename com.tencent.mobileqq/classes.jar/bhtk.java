import android.view.View;
import android.view.View.OnClickListener;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class bhtk
  implements View.OnClickListener
{
  bhtk(bhtg parambhtg) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    if (bhtg.a(this.a)) {
      return;
    }
    bhtg.a(this.a, true);
    paramView = bhtg.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, selectedItems = " + paramView);
    Object localObject = bhcm.a();
    ((bhcm)localObject).k();
    int i = 0;
    while (i < bhtg.b(this.a).size()) {
      if (!paramView.contains(Integer.valueOf(i)))
      {
        i += 1;
      }
      else
      {
        if (((bhsf)bhtg.b(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null)
        {
          ((bhcm)localObject).j(((bhsf)bhtg.b(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
          ((bhcm)localObject).h("none");
          ((bhcm)localObject).i("none");
        }
        for (;;)
        {
          bhci.a().H();
          break;
          if (!((bhsf)bhtg.b(this.a).get(i)).jdField_a_of_type_JavaLangString.equals(""))
          {
            ((bhcm)localObject).j("none");
            ((bhcm)localObject).h(((bhsi)bhsh.jdField_a_of_type_JavaUtilList.get(bhsh.jdField_a_of_type_ArrayOfInt[(i % bhsh.jdField_a_of_type_ArrayOfInt.length)])).jdField_a_of_type_JavaLangString);
            ((bhcm)localObject).i(((bhsf)bhtg.b(this.a).get(i)).jdField_a_of_type_JavaLangString);
          }
          else
          {
            ((bhcm)localObject).j("none");
            ((bhcm)localObject).h("none");
            ((bhcm)localObject).i("none");
          }
        }
      }
    }
    bhtg.b(this.a).a(true);
    bhtg.a(this.a).a(false);
    localObject = bhtg.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, pngDirs = " + ((biak)localObject).a + ", texts = " + ((biak)localObject).b);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    i = j;
    if (i < ((biak)localObject).a.size())
    {
      if (paramView.contains(((biak)localObject).d.get(i)))
      {
        if ((i != 0) || (bhtg.a(this.a) == null)) {
          break label496;
        }
        localArrayList1.add(bhtg.a(this.a).jdField_a_of_type_JavaLangString);
        localArrayList2.add(bhtg.a(this.a).b);
        localArrayList3.add(bhtg.a(this.a).c);
      }
      for (;;)
      {
        i += 1;
        break;
        label496:
        localArrayList1.add(((biak)localObject).a.get(i));
        localArrayList2.add(((biak)localObject).b.get(i));
        localArrayList3.add(((biak)localObject).c.get(i));
      }
    }
    bhtg.a(this.a, localArrayList1, localArrayList2, localArrayList3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhtk
 * JD-Core Version:    0.7.0.1
 */