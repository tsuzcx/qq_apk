import android.view.View;
import android.view.View.OnClickListener;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class botz
  implements View.OnClickListener
{
  botz(botw parambotw) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    botw.a(this.a, true);
    Set localSet = botw.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, selectedItems = " + localSet);
    Object localObject2 = bozv.a();
    ((bozv)localObject2).j();
    Object localObject1 = new LinkedList();
    int i = 0;
    while (i < botw.a(this.a).size()) {
      if (!localSet.contains(Integer.valueOf(i)))
      {
        i += 1;
      }
      else
      {
        if (((bosw)botw.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null)
        {
          ((bozv)localObject2).k(((bosw)botw.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
          ((bozv)localObject2).i("none");
          ((bozv)localObject2).j("none");
          ((List)localObject1).add(((bosw)botw.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
        }
        for (;;)
        {
          bozr.a().aj();
          break;
          if (!((bosw)botw.a(this.a).get(i)).jdField_a_of_type_JavaLangString.equals(""))
          {
            ((bozv)localObject2).k("none");
            ((bozv)localObject2).i(((bosz)bosy.jdField_a_of_type_JavaUtilList.get(bosy.jdField_a_of_type_ArrayOfInt[(i % bosy.jdField_a_of_type_ArrayOfInt.length)])).jdField_a_of_type_JavaLangString);
            ((bozv)localObject2).j(((bosw)botw.a(this.a).get(i)).jdField_a_of_type_JavaLangString);
            ((List)localObject1).add("none");
          }
          else
          {
            ((bozv)localObject2).k("none");
            ((bozv)localObject2).i("none");
            ((bozv)localObject2).j("none");
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
    bozr.a().a(localSet.size(), ((StringBuilder)localObject2).toString());
    botw.a(this.a).a(false);
    bovm localbovm = botw.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, pngDirs = " + localbovm.a + ", texts = " + localbovm.b);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    i = j;
    if (i < localbovm.a.size())
    {
      Integer localInteger = (Integer)localbovm.d.get(i);
      if (localSet.contains(localInteger))
      {
        if ((i != 0) || (botw.a(this.a) == null)) {
          break label743;
        }
        localArrayList1.add(botw.a(this.a).jdField_a_of_type_JavaLangString);
        localArrayList2.add(botw.a(this.a).b);
        localArrayList3.add(botw.a(this.a).c);
      }
      for (;;)
      {
        localObject2 = botw.a(this.a, localInteger.intValue());
        StringBuilder localStringBuilder = new StringBuilder().append("gif^");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject1 = (String)localObject1;
        localArrayList4.add(localObject1);
        bpam.b("AEGIFChunkPreviewFragment", "save gif, index=" + i + ", widgetInfo=" + (String)localObject1 + ", originIndex=" + localInteger);
        i += 1;
        break;
        label743:
        localArrayList1.add(localbovm.a.get(i));
        localArrayList2.add(localbovm.b.get(i));
        localArrayList3.add(localbovm.c.get(i));
      }
    }
    botw.a(this.a, localArrayList1, localArrayList2, localArrayList3, localArrayList4);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     botz
 * JD-Core Version:    0.7.0.1
 */