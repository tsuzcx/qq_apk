import android.view.View;
import android.view.View.OnClickListener;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class bldd
  implements View.OnClickListener
{
  bldd(blda paramblda) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    blda.a(this.a, true);
    Set localSet = blda.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, selectedItems = " + localSet);
    paramView = bliy.a();
    paramView.j();
    int i = 0;
    while (i < blda.a(this.a).size()) {
      if (!localSet.contains(Integer.valueOf(i)))
      {
        i += 1;
      }
      else
      {
        if (((blca)blda.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null)
        {
          paramView.k(((blca)blda.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
          paramView.i("none");
          paramView.j("none");
        }
        for (;;)
        {
          bliu.a().S();
          break;
          if (!((blca)blda.a(this.a).get(i)).jdField_a_of_type_JavaLangString.equals(""))
          {
            paramView.k("none");
            paramView.i(((blcd)blcc.jdField_a_of_type_JavaUtilList.get(blcc.jdField_a_of_type_ArrayOfInt[(i % blcc.jdField_a_of_type_ArrayOfInt.length)])).jdField_a_of_type_JavaLangString);
            paramView.j(((blca)blda.a(this.a).get(i)).jdField_a_of_type_JavaLangString);
          }
          else
          {
            paramView.k("none");
            paramView.i("none");
            paramView.j("none");
          }
        }
      }
    }
    blda.a(this.a).a(false);
    bles localbles = blda.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, pngDirs = " + localbles.a + ", texts = " + localbles.b);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    i = j;
    if (i < localbles.a.size())
    {
      Integer localInteger = (Integer)localbles.d.get(i);
      if (localSet.contains(localInteger))
      {
        if ((i != 0) || (blda.a(this.a) == null)) {
          break label582;
        }
        localArrayList1.add(blda.a(this.a).jdField_a_of_type_JavaLangString);
        localArrayList2.add(blda.a(this.a).b);
        localArrayList3.add(blda.a(this.a).c);
      }
      for (;;)
      {
        String str = blda.a(this.a, localInteger.intValue());
        StringBuilder localStringBuilder = new StringBuilder().append("gif^");
        paramView = str;
        if (str == null) {
          paramView = "";
        }
        paramView = paramView;
        localArrayList4.add(paramView);
        bljn.b("AEGIFChunkPreviewFragment", "save gif, index=" + i + ", widgetInfo=" + paramView + ", originIndex=" + localInteger);
        i += 1;
        break;
        label582:
        localArrayList1.add(localbles.a.get(i));
        localArrayList2.add(localbles.b.get(i));
        localArrayList3.add(localbles.c.get(i));
      }
    }
    blda.a(this.a, localArrayList1, localArrayList2, localArrayList3, localArrayList4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldd
 * JD-Core Version:    0.7.0.1
 */