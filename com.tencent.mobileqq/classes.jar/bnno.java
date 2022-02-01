import android.view.View;
import android.view.View.OnClickListener;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class bnno
  implements View.OnClickListener
{
  bnno(bnnl parambnnl) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    bnnl.a(this.a, true);
    Set localSet = bnnl.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, selectedItems = " + localSet);
    Object localObject2 = bnqq.a();
    ((bnqq)localObject2).j();
    Object localObject1 = new LinkedList();
    int i = 0;
    while (i < bnnl.a(this.a).size()) {
      if (!localSet.contains(Integer.valueOf(i)))
      {
        i += 1;
      }
      else
      {
        if (((bnml)bnnl.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null)
        {
          ((bnqq)localObject2).k(((bnml)bnnl.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
          ((bnqq)localObject2).i("none");
          ((bnqq)localObject2).j("none");
          ((List)localObject1).add(((bnml)bnnl.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
        }
        for (;;)
        {
          bnqm.a().ao();
          break;
          if (!((bnml)bnnl.a(this.a).get(i)).jdField_a_of_type_JavaLangString.equals(""))
          {
            ((bnqq)localObject2).k("none");
            ((bnqq)localObject2).i(((bnmo)bnmn.jdField_a_of_type_JavaUtilList.get(bnmn.jdField_a_of_type_ArrayOfInt[(i % bnmn.jdField_a_of_type_ArrayOfInt.length)])).jdField_a_of_type_JavaLangString);
            ((bnqq)localObject2).j(((bnml)bnnl.a(this.a).get(i)).jdField_a_of_type_JavaLangString);
            ((List)localObject1).add("none");
          }
          else
          {
            ((bnqq)localObject2).k("none");
            ((bnqq)localObject2).i("none");
            ((bnqq)localObject2).j("none");
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
    bnqm.a().a(localSet.size(), ((StringBuilder)localObject2).toString());
    bnnl.a(this.a).a(false);
    bnpb localbnpb = bnnl.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, pngDirs = " + localbnpb.a + ", texts = " + localbnpb.b);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    i = j;
    if (i < localbnpb.a.size())
    {
      Integer localInteger = (Integer)localbnpb.d.get(i);
      if (localSet.contains(localInteger))
      {
        if ((i != 0) || (bnnl.a(this.a) == null)) {
          break label743;
        }
        localArrayList1.add(bnnl.a(this.a).jdField_a_of_type_JavaLangString);
        localArrayList2.add(bnnl.a(this.a).b);
        localArrayList3.add(bnnl.a(this.a).c);
      }
      for (;;)
      {
        localObject2 = bnnl.a(this.a, localInteger.intValue());
        StringBuilder localStringBuilder = new StringBuilder().append("gif^");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject1 = (String)localObject1;
        localArrayList4.add(localObject1);
        bnrh.b("AEGIFChunkPreviewFragment", "save gif, index=" + i + ", widgetInfo=" + (String)localObject1 + ", originIndex=" + localInteger);
        i += 1;
        break;
        label743:
        localArrayList1.add(localbnpb.a.get(i));
        localArrayList2.add(localbnpb.b.get(i));
        localArrayList3.add(localbnpb.c.get(i));
      }
    }
    bnnl.a(this.a, localArrayList1, localArrayList2, localArrayList3, localArrayList4);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnno
 * JD-Core Version:    0.7.0.1
 */