import android.view.View;
import android.view.View.OnClickListener;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class blye
  implements View.OnClickListener
{
  blye(blyb paramblyb) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    blyb.a(this.a, true);
    Set localSet = blyb.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, selectedItems = " + localSet);
    Object localObject2 = bmbg.a();
    ((bmbg)localObject2).j();
    Object localObject1 = new LinkedList();
    int i = 0;
    while (i < blyb.a(this.a).size()) {
      if (!localSet.contains(Integer.valueOf(i)))
      {
        i += 1;
      }
      else
      {
        if (((blxb)blyb.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null)
        {
          ((bmbg)localObject2).k(((blxb)blyb.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
          ((bmbg)localObject2).i("none");
          ((bmbg)localObject2).j("none");
          ((List)localObject1).add(((blxb)blyb.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
        }
        for (;;)
        {
          bmbc.a().ao();
          break;
          if (!((blxb)blyb.a(this.a).get(i)).jdField_a_of_type_JavaLangString.equals(""))
          {
            ((bmbg)localObject2).k("none");
            ((bmbg)localObject2).i(((blxe)blxd.jdField_a_of_type_JavaUtilList.get(blxd.jdField_a_of_type_ArrayOfInt[(i % blxd.jdField_a_of_type_ArrayOfInt.length)])).jdField_a_of_type_JavaLangString);
            ((bmbg)localObject2).j(((blxb)blyb.a(this.a).get(i)).jdField_a_of_type_JavaLangString);
            ((List)localObject1).add("none");
          }
          else
          {
            ((bmbg)localObject2).k("none");
            ((bmbg)localObject2).i("none");
            ((bmbg)localObject2).j("none");
            ((List)localObject1).add("none");
          }
        }
      }
    }
    localObject2 = new StringBuilder();
    i = 0;
    while (i < ((List)localObject1).size())
    {
      ((StringBuilder)localObject2).append((String)((List)localObject1).get(i));
      if (i != ((List)localObject1).size() - 1) {
        ((StringBuilder)localObject2).append(",");
      }
      i += 1;
    }
    bmbc.a().a(localSet.size(), ((StringBuilder)localObject2).toString());
    blyb.a(this.a).a(false);
    blzr localblzr = blyb.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, pngDirs = " + localblzr.a + ", texts = " + localblzr.b);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    i = j;
    if (i < localblzr.a.size())
    {
      Integer localInteger = (Integer)localblzr.d.get(i);
      if (localSet.contains(localInteger))
      {
        if ((i != 0) || (blyb.a(this.a) == null)) {
          break label743;
        }
        localArrayList1.add(blyb.a(this.a).jdField_a_of_type_JavaLangString);
        localArrayList2.add(blyb.a(this.a).b);
        localArrayList3.add(blyb.a(this.a).c);
      }
      for (;;)
      {
        localObject2 = blyb.a(this.a, localInteger.intValue());
        StringBuilder localStringBuilder = new StringBuilder().append("gif^");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject1 = (String)localObject1;
        localArrayList4.add(localObject1);
        bmbx.b("AEGIFChunkPreviewFragment", "save gif, index=" + i + ", widgetInfo=" + (String)localObject1 + ", originIndex=" + localInteger);
        i += 1;
        break;
        label743:
        localArrayList1.add(localblzr.a.get(i));
        localArrayList2.add(localblzr.b.get(i));
        localArrayList3.add(localblzr.c.get(i));
      }
    }
    blyb.a(this.a, localArrayList1, localArrayList2, localArrayList3, localArrayList4);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blye
 * JD-Core Version:    0.7.0.1
 */