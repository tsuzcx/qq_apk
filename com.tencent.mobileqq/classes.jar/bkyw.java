import android.view.View;
import android.view.View.OnClickListener;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class bkyw
  implements View.OnClickListener
{
  bkyw(bkyt parambkyt) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    bkyt.a(this.a, true);
    Set localSet = bkyt.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, selectedItems = " + localSet);
    paramView = bler.a();
    paramView.j();
    int i = 0;
    while (i < bkyt.a(this.a).size()) {
      if (!localSet.contains(Integer.valueOf(i)))
      {
        i += 1;
      }
      else
      {
        if (((bkxt)bkyt.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null)
        {
          paramView.k(((bkxt)bkyt.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
          paramView.i("none");
          paramView.j("none");
        }
        for (;;)
        {
          blen.a().S();
          break;
          if (!((bkxt)bkyt.a(this.a).get(i)).jdField_a_of_type_JavaLangString.equals(""))
          {
            paramView.k("none");
            paramView.i(((bkxw)bkxv.jdField_a_of_type_JavaUtilList.get(bkxv.jdField_a_of_type_ArrayOfInt[(i % bkxv.jdField_a_of_type_ArrayOfInt.length)])).jdField_a_of_type_JavaLangString);
            paramView.j(((bkxt)bkyt.a(this.a).get(i)).jdField_a_of_type_JavaLangString);
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
    bkyt.a(this.a).a(false);
    blal localblal = bkyt.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, pngDirs = " + localblal.a + ", texts = " + localblal.b);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    i = j;
    if (i < localblal.a.size())
    {
      Integer localInteger = (Integer)localblal.d.get(i);
      if (localSet.contains(localInteger))
      {
        if ((i != 0) || (bkyt.a(this.a) == null)) {
          break label582;
        }
        localArrayList1.add(bkyt.a(this.a).jdField_a_of_type_JavaLangString);
        localArrayList2.add(bkyt.a(this.a).b);
        localArrayList3.add(bkyt.a(this.a).c);
      }
      for (;;)
      {
        String str = bkyt.a(this.a, localInteger.intValue());
        StringBuilder localStringBuilder = new StringBuilder().append("gif^");
        paramView = str;
        if (str == null) {
          paramView = "";
        }
        paramView = paramView;
        localArrayList4.add(paramView);
        blfg.b("AEGIFChunkPreviewFragment", "save gif, index=" + i + ", widgetInfo=" + paramView + ", originIndex=" + localInteger);
        i += 1;
        break;
        label582:
        localArrayList1.add(localblal.a.get(i));
        localArrayList2.add(localblal.b.get(i));
        localArrayList3.add(localblal.c.get(i));
      }
    }
    bkyt.a(this.a, localArrayList1, localArrayList2, localArrayList3, localArrayList4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyw
 * JD-Core Version:    0.7.0.1
 */