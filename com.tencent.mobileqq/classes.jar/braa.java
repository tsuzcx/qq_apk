import android.os.Build;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.LockedCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class braa
{
  public brab a;
  String jdField_a_of_type_JavaLangString;
  public HashMap<String, LockedCategory> a;
  CopyOnWriteArrayList<FilterCategory> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  public brab b = new brab();
  public brab c = new brab();
  
  public braa(String paramString)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Brab = new brab();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = a(paramString);
    this.jdField_a_of_type_Brab = bqzz.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, true, false);
    this.b = bqzz.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, false, true);
    this.c = bqzz.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, false, false);
  }
  
  private TransitionCategoryItem a(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    TransitionCategoryItem localTransitionCategoryItem = new TransitionCategoryItem();
    localTransitionCategoryItem.jdField_a_of_type_JavaLangString = (paramInt1 + "");
    localTransitionCategoryItem.b = paramString1;
    localTransitionCategoryItem.d = paramString4;
    localTransitionCategoryItem.j = paramString3;
    localTransitionCategoryItem.jdField_a_of_type_Int = paramInt2;
    localTransitionCategoryItem.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
    localTransitionCategoryItem.jdField_a_of_type_JavaUtilArrayList.add(paramString2);
    localTransitionCategoryItem.k = paramString5;
    localTransitionCategoryItem.l = paramString7;
    localTransitionCategoryItem.m = paramString8;
    localTransitionCategoryItem.n = paramString6;
    return localTransitionCategoryItem;
  }
  
  private void a(brab parambrab1, brab parambrab2)
  {
    int j = 0;
    Object localObject1 = (bocw)bplq.a(13);
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < parambrab1.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (!((bocw)localObject1).a(((FilterCategory)parambrab1.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_b_of_type_Int)) {
        localArrayList1.add(parambrab1.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      i += 1;
    }
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = (ArrayList)parambrab1.c.clone();
    i = j;
    Object localObject2;
    if (i < parambrab1.jdField_b_of_type_JavaUtilArrayList.size())
    {
      if (!((bocw)localObject1).a(((FilterCategory)parambrab1.jdField_b_of_type_JavaUtilArrayList.get(i)).jdField_b_of_type_Int)) {
        localArrayList2.add(parambrab1.jdField_b_of_type_JavaUtilArrayList.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2 = ((FilterCategory)parambrab1.jdField_b_of_type_JavaUtilArrayList.get(i)).a.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject2).next();
          if (!localQIMFilterCategoryItem.equals(parambrab1.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem)) {
            localArrayList3.remove(localQIMFilterCategoryItem);
          }
        }
      }
    }
    localArrayList2 = (ArrayList)localArrayList2.clone();
    localArrayList3 = (ArrayList)localArrayList3.clone();
    if (((bocw)localObject1).b())
    {
      localObject1 = localArrayList2.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FilterCategory)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((FilterCategory)localObject2).c != 1)) {
          ((Iterator)localObject1).remove();
        }
      }
      localObject1 = localArrayList3.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (QIMFilterCategoryItem)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((QIMFilterCategoryItem)localObject2).jdField_b_of_type_Int != 1)) {
          ((Iterator)localObject1).remove();
        }
      }
    }
    parambrab2.jdField_a_of_type_JavaUtilArrayList = localArrayList1;
    parambrab2.jdField_b_of_type_JavaUtilArrayList = localArrayList2;
    parambrab2.c = localArrayList3;
    parambrab2.d = parambrab1.d;
    parambrab2.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = parambrab1.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem;
    parambrab2.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = parambrab1.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem;
  }
  
  public brab a(int paramInt)
  {
    brab localbrab2 = new brab();
    brab localbrab1 = this.jdField_a_of_type_Brab;
    switch (paramInt)
    {
    }
    for (;;)
    {
      a(localbrab1, localbrab2);
      return localbrab2;
      localbrab1 = this.b;
      continue;
      localbrab1 = this.c;
      continue;
      localbrab1 = this.jdField_a_of_type_Brab;
    }
  }
  
  public TransitionCategoryItem a()
  {
    if (bqzz.b()) {
      return a(5, anzj.a(2131715035), 103, "tran_fade", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor_static.png", "fadecolor", "1", "9", "Basic");
    }
    return a(4, anzj.a(2131715046), 103, "tran_default", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default_static.png", "LinearBlur", "1", "1", "Basic");
  }
  
  public ArrayList<FilterCategory> a()
  {
    boolean bool = bqzz.b();
    ArrayList localArrayList1 = new ArrayList(2);
    FilterCategory localFilterCategory = new FilterCategory(1001, anzj.a(2131715032), false, false, 0, 0);
    ArrayList localArrayList2 = new ArrayList(15);
    if (!bool) {
      localArrayList2.add(a(4, anzj.a(2131715051), 103, "tran_default", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default_static.png", "LinearBlur", "1", "1", "Basic"));
    }
    localArrayList2.add(a(-1, anzj.a(2131715047), 103, "tran_no", null, "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_no_static.png", "NoEffect", "1", "2", "Basic"));
    if (!bool)
    {
      localArrayList2.add(a(12, anzj.a(2131715050), 103, "tran_reverse", "https://dl.url.cn/myapp/qq_desk/shortvideo/transition/trans_turn.png", "https://dl.url.cn/myapp/qq_desk/shortvideo/transition/trans_turn_static.png", "Flipping", "1", "12", "Basic"));
      localArrayList2.add(a(13, anzj.a(2131715037), 103, "tran_recombine", "https://dl.url.cn/myapp/qq_desk/shortvideo/transition/trans_remix.png", "https://dl.url.cn/myapp/qq_desk/shortvideo/transition/trans_remix_static.png", "Recombination", "1", "13", "Basic"));
      localArrayList2.add(a(1, anzj.a(2131715043), 103, "tran_move", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move_static.png", "speedWipe", "1", "3", "Basic"));
      localArrayList2.add(a(10, anzj.a(2131715054), 103, "tran_speedout", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speedOut.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speedOut_static.png", "speedOut", "1", "4", "Basic"));
      localArrayList2.add(a(11, anzj.a(2131715041), 103, "tran_filterCut", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_filterCut.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_filterCut_static.png", "filterCut", "1", "5", "Basic"));
      String str = Build.MODEL;
      if ((str != null) && (!str.equals("MI NOTE LTE")) && (!str.equals("R7Plusm")) && (!str.equals("vivo X5M")) && (!str.equals("SLA-AL00")) && (!str.equals("vivo Y71A")) && (!str.equals("vivo Y66i A")) && (!str.equals("Redmi 4A")) && (!str.equals("vivo X6Plus A")) && (!str.equals("vivo Y31")) && (!str.equals("SCL-AL00")) && (!str.equals("2014813")) && (!str.equals("Redmi Note 5A")) && (!str.equals("A31"))) {
        localArrayList2.add(a(3, anzj.a(2131715036), 103, "tran_speed", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speed.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speed_static.png", "speedLine", "1", "6", "Basic"));
      }
    }
    localArrayList2.add(a(9, anzj.a(2131715038), 103, "tran_slip", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_sideSlip.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_sideSlip_static.png", "sideSlip", "1", "7", "Basic"));
    localArrayList2.add(a(8, anzj.a(2131715052), 103, "tran_light", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_flashOut.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_flashOut_static.png", "flashOut", "1", "8", "Basic"));
    localArrayList2.add(a(5, anzj.a(2131715055), 103, "tran_fade", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor_static.png", "fadecolor", "1", "9", "Basic"));
    localArrayList2.add(a(6, anzj.a(2131715048), 103, "tran_zoom", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_zoom.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_zoom_static.png", "simpleZoom", "1", "10", "Basic"));
    localArrayList2.add(a(7, anzj.a(2131715034), 103, "tran_wipe", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_wipe.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_wipe_static.png", "directionalwipe", "1", "11", "Basic"));
    localFilterCategory.a = localArrayList2;
    localArrayList1.add(localFilterCategory);
    return localArrayList1;
  }
  
  public CopyOnWriteArrayList<FilterCategory> a(String paramString)
  {
    int j = 0;
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    paramString = new JSONObject(paramString);
    Object localObject1 = FilterDesc.parse(paramString.getJSONArray("filters")).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FilterDesc)((Iterator)localObject1).next();
      bqzz.jdField_a_of_type_JavaUtilHashMap.put(((FilterDesc)localObject2).name, localObject2);
    }
    localObject1 = paramString.getJSONArray("categorys");
    Object localObject2 = new ArrayList(((JSONArray)localObject1).length());
    int i = 0;
    while (i < ((JSONArray)localObject1).length())
    {
      ((ArrayList)localObject2).add(new FilterCategory(((JSONArray)localObject1).getJSONObject(i), null));
      i += 1;
    }
    localCopyOnWriteArrayList.clear();
    localCopyOnWriteArrayList.addAll((Collection)localObject2);
    ((bpmw)bplq.a(5)).a((List)localObject2);
    paramString = paramString.optJSONArray("locked_categorys");
    if (paramString != null)
    {
      i = j;
      while (i < paramString.length())
      {
        localObject2 = paramString.optJSONObject(i);
        if (localObject2 != null)
        {
          localObject1 = ((JSONObject)localObject2).optString("comboId");
          localObject2 = new LockedCategory((JSONObject)localObject2);
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, localObject2);
        }
        i += 1;
      }
    }
    return localCopyOnWriteArrayList;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
    this.jdField_a_of_type_Brab = bqzz.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, true, false);
    this.b = bqzz.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, false, true);
    this.c = bqzz.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, false, false);
  }
  
  public void a(CopyOnWriteArrayList<FilterCategory> paramCopyOnWriteArrayList)
  {
    bpni localbpni = ((bpmw)bplq.a(5)).a();
    paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    while (paramCopyOnWriteArrayList.hasNext())
    {
      FilterCategory localFilterCategory = (FilterCategory)paramCopyOnWriteArrayList.next();
      if (localFilterCategory.jdField_b_of_type_Boolean)
      {
        QIMFilterCategoryItem localQIMFilterCategoryItem1 = (QIMFilterCategoryItem)localFilterCategory.a.remove(0);
        Object localObject1 = new LinkedList();
        Object localObject2 = new LinkedList();
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = localFilterCategory.a.iterator();
        while (localIterator.hasNext())
        {
          QIMFilterCategoryItem localQIMFilterCategoryItem2 = (QIMFilterCategoryItem)localIterator.next();
          if (localbpni.a(localQIMFilterCategoryItem2.jdField_a_of_type_JavaLangString))
          {
            ((List)localObject1).add(localQIMFilterCategoryItem2);
          }
          else
          {
            bqzz.a();
            if (bqzz.a(3, localQIMFilterCategoryItem2.jdField_a_of_type_Int, localQIMFilterCategoryItem2.jdField_a_of_type_JavaLangString)) {
              ((List)localObject2).add(localQIMFilterCategoryItem2);
            } else {
              localLinkedList.add(localQIMFilterCategoryItem2);
            }
          }
        }
        Collections.shuffle(localLinkedList);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          localLinkedList.add(0, (QIMFilterCategoryItem)((Iterator)localObject2).next());
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localLinkedList.add(0, (QIMFilterCategoryItem)((Iterator)localObject1).next());
        }
        localLinkedList.add(0, localQIMFilterCategoryItem1);
        localFilterCategory.a = localLinkedList;
      }
    }
  }
  
  public ArrayList<QIMFilterCategoryItem> b()
  {
    ArrayList localArrayList = new ArrayList(10);
    if (!bqzz.b())
    {
      localArrayList.add(a(1, anzj.a(2131715033), 103, "tran_move", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move_static.png", "speedWipe", "0", "3", "Basic"));
      localArrayList.add(a(10, anzj.a(2131715049), 103, "tran_speedout", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speedOut.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speedOut_static.png", "speedOut", "0", "4", "Basic"));
      localArrayList.add(a(11, anzj.a(2131715053), 103, "tran_filterCut", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_filterCut.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_filterCut_static.png", "filterCut", "0", "5", "Basic"));
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     braa
 * JD-Core Version:    0.7.0.1
 */