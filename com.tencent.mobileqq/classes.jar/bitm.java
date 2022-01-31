import android.view.View;
import android.view.View.OnClickListener;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class bitm
  implements View.OnClickListener
{
  bitm(bitj parambitj) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    bitj.a(this.a, true);
    paramView = bitj.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, selectedItems = " + paramView);
    Object localObject = bizg.a();
    ((bizg)localObject).k();
    int i = 0;
    while (i < bitj.a(this.a).size()) {
      if (!paramView.contains(Integer.valueOf(i)))
      {
        i += 1;
      }
      else
      {
        if (((bisj)bitj.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null)
        {
          ((bizg)localObject).k(((bisj)bitj.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
          ((bizg)localObject).i("none");
          ((bizg)localObject).j("none");
        }
        for (;;)
        {
          bizc.a().J();
          break;
          if (!((bisj)bitj.a(this.a).get(i)).jdField_a_of_type_JavaLangString.equals(""))
          {
            ((bizg)localObject).k("none");
            ((bizg)localObject).i(((bism)bisl.jdField_a_of_type_JavaUtilList.get(bisl.jdField_a_of_type_ArrayOfInt[(i % bisl.jdField_a_of_type_ArrayOfInt.length)])).jdField_a_of_type_JavaLangString);
            ((bizg)localObject).j(((bisj)bitj.a(this.a).get(i)).jdField_a_of_type_JavaLangString);
          }
          else
          {
            ((bizg)localObject).k("none");
            ((bizg)localObject).i("none");
            ((bizg)localObject).j("none");
          }
        }
      }
    }
    bitj.a(this.a).a(false);
    localObject = bitj.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, pngDirs = " + ((biva)localObject).a + ", texts = " + ((biva)localObject).b);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    i = j;
    if (i < ((biva)localObject).a.size())
    {
      if (paramView.contains(((biva)localObject).d.get(i)))
      {
        if ((i != 0) || (bitj.a(this.a) == null)) {
          break label474;
        }
        localArrayList1.add(bitj.a(this.a).jdField_a_of_type_JavaLangString);
        localArrayList2.add(bitj.a(this.a).b);
        localArrayList3.add(bitj.a(this.a).c);
      }
      for (;;)
      {
        i += 1;
        break;
        label474:
        localArrayList1.add(((biva)localObject).a.get(i));
        localArrayList2.add(((biva)localObject).b.get(i));
        localArrayList3.add(((biva)localObject).c.get(i));
      }
    }
    bitj.a(this.a, localArrayList1, localArrayList2, localArrayList3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bitm
 * JD-Core Version:    0.7.0.1
 */