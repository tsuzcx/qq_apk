import android.view.View;
import android.view.View.OnClickListener;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class bnsl
  implements View.OnClickListener
{
  bnsl(bnsi parambnsi) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    bnsi.a(this.a, true);
    Set localSet = bnsi.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, selectedItems = " + localSet);
    Object localObject = bnyl.a();
    ((bnyl)localObject).j();
    int i = 0;
    while (i < bnsi.a(this.a).size()) {
      if (!localSet.contains(Integer.valueOf(i)))
      {
        i += 1;
      }
      else
      {
        if (((bnri)bnsi.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null)
        {
          ((bnyl)localObject).k(((bnri)bnsi.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
          ((bnyl)localObject).i("none");
          ((bnyl)localObject).j("none");
        }
        for (;;)
        {
          bnyh.a().af();
          break;
          if (!((bnri)bnsi.a(this.a).get(i)).jdField_a_of_type_JavaLangString.equals(""))
          {
            ((bnyl)localObject).k("none");
            ((bnyl)localObject).i(((bnrl)bnrk.jdField_a_of_type_JavaUtilList.get(bnrk.jdField_a_of_type_ArrayOfInt[(i % bnrk.jdField_a_of_type_ArrayOfInt.length)])).jdField_a_of_type_JavaLangString);
            ((bnyl)localObject).j(((bnri)bnsi.a(this.a).get(i)).jdField_a_of_type_JavaLangString);
          }
          else
          {
            ((bnyl)localObject).k("none");
            ((bnyl)localObject).i("none");
            ((bnyl)localObject).j("none");
          }
        }
      }
    }
    bnsi.a(this.a).a(false);
    bnua localbnua = bnsi.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, pngDirs = " + localbnua.a + ", texts = " + localbnua.b);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    i = j;
    if (i < localbnua.a.size())
    {
      Integer localInteger = (Integer)localbnua.d.get(i);
      if (localSet.contains(localInteger))
      {
        if ((i != 0) || (bnsi.a(this.a) == null)) {
          break label599;
        }
        localArrayList1.add(bnsi.a(this.a).jdField_a_of_type_JavaLangString);
        localArrayList2.add(bnsi.a(this.a).b);
        localArrayList3.add(bnsi.a(this.a).c);
      }
      for (;;)
      {
        String str = bnsi.a(this.a, localInteger.intValue());
        StringBuilder localStringBuilder = new StringBuilder().append("gif^");
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localObject = (String)localObject;
        localArrayList4.add(localObject);
        bnzb.b("AEGIFChunkPreviewFragment", "save gif, index=" + i + ", widgetInfo=" + (String)localObject + ", originIndex=" + localInteger);
        i += 1;
        break;
        label599:
        localArrayList1.add(localbnua.a.get(i));
        localArrayList2.add(localbnua.b.get(i));
        localArrayList3.add(localbnua.c.get(i));
      }
    }
    bnsi.a(this.a, localArrayList1, localArrayList2, localArrayList3, localArrayList4);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsl
 * JD-Core Version:    0.7.0.1
 */