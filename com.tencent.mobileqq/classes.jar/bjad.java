import android.os.Build;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import dov.com.qq.im.capture.data.ComboLockManager;
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

public class bjad
{
  public bjae a;
  String jdField_a_of_type_JavaLangString;
  public HashMap<String, LockedCategory> a;
  CopyOnWriteArrayList<FilterCategory> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  public bjae b = new bjae();
  public bjae c = new bjae();
  
  public bjad(String paramString)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Bjae = new bjae();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = a(paramString);
    this.jdField_a_of_type_Bjae = bjac.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, true, false);
    this.b = bjac.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, false, true);
    this.c = bjac.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, false, false);
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
  
  private void a(bjae parambjae1, bjae parambjae2)
  {
    int j = 0;
    Object localObject1 = (bhdr)bhfm.a(13);
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < parambjae1.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (!((bhdr)localObject1).a(((FilterCategory)parambjae1.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_b_of_type_Int)) {
        localArrayList1.add(parambjae1.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      i += 1;
    }
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = (ArrayList)parambjae1.c.clone();
    i = j;
    Object localObject2;
    if (i < parambjae1.jdField_b_of_type_JavaUtilArrayList.size())
    {
      if (!((bhdr)localObject1).a(((FilterCategory)parambjae1.jdField_b_of_type_JavaUtilArrayList.get(i)).jdField_b_of_type_Int)) {
        localArrayList2.add(parambjae1.jdField_b_of_type_JavaUtilArrayList.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2 = ((FilterCategory)parambjae1.jdField_b_of_type_JavaUtilArrayList.get(i)).a.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject2).next();
          if (!localQIMFilterCategoryItem.equals(parambjae1.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem)) {
            localArrayList3.remove(localQIMFilterCategoryItem);
          }
        }
      }
    }
    localArrayList2 = (ArrayList)localArrayList2.clone();
    localArrayList3 = (ArrayList)localArrayList3.clone();
    if (((bhdr)localObject1).b())
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
    parambjae2.jdField_a_of_type_JavaUtilArrayList = localArrayList1;
    parambjae2.jdField_b_of_type_JavaUtilArrayList = localArrayList2;
    parambjae2.c = localArrayList3;
    parambjae2.d = parambjae1.d;
    parambjae2.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = parambjae1.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem;
    parambjae2.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = parambjae1.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem;
  }
  
  public bjae a(int paramInt)
  {
    bjae localbjae2 = new bjae();
    bjae localbjae1 = this.jdField_a_of_type_Bjae;
    switch (paramInt)
    {
    }
    for (;;)
    {
      a(localbjae1, localbjae2);
      return localbjae2;
      localbjae1 = this.b;
      continue;
      localbjae1 = this.c;
      continue;
      localbjae1 = this.jdField_a_of_type_Bjae;
    }
  }
  
  public TransitionCategoryItem a()
  {
    if (bjac.b()) {
      return a(5, ajjy.a(2131650463), 103, "tran_fade", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor_static.png", "fadecolor", "1", "9", "Basic");
    }
    return a(4, ajjy.a(2131650474), 103, "tran_default", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default_static.png", "LinearBlur", "1", "1", "Basic");
  }
  
  public ArrayList<FilterCategory> a()
  {
    boolean bool = bjac.b();
    ArrayList localArrayList1 = new ArrayList(2);
    FilterCategory localFilterCategory = new FilterCategory(1001, ajjy.a(2131650460), false, false, 0, 0);
    ArrayList localArrayList2 = new ArrayList(15);
    if (!bool) {
      localArrayList2.add(a(4, ajjy.a(2131650479), 103, "tran_default", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default_static.png", "LinearBlur", "1", "1", "Basic"));
    }
    localArrayList2.add(a(-1, ajjy.a(2131650475), 103, "tran_no", null, "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_no_static.png", "NoEffect", "1", "2", "Basic"));
    if (!bool)
    {
      localArrayList2.add(a(12, ajjy.a(2131650478), 103, "tran_reverse", "http://dl.url.cn/myapp/qq_desk/shortvideo/transition/trans_turn.png", "http://dl.url.cn/myapp/qq_desk/shortvideo/transition/trans_turn_static.png", "Flipping", "1", "12", "Basic"));
      localArrayList2.add(a(13, ajjy.a(2131650465), 103, "tran_recombine", "http://dl.url.cn/myapp/qq_desk/shortvideo/transition/trans_remix.png", "http://dl.url.cn/myapp/qq_desk/shortvideo/transition/trans_remix_static.png", "Recombination", "1", "13", "Basic"));
      localArrayList2.add(a(1, ajjy.a(2131650471), 103, "tran_move", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move_static.png", "speedWipe", "1", "3", "Basic"));
      localArrayList2.add(a(10, ajjy.a(2131650482), 103, "tran_speedout", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speedOut.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speedOut_static.png", "speedOut", "1", "4", "Basic"));
      localArrayList2.add(a(11, ajjy.a(2131650469), 103, "tran_filterCut", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_filterCut.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_filterCut_static.png", "filterCut", "1", "5", "Basic"));
      String str = Build.MODEL;
      if ((str != null) && (!str.equals("MI NOTE LTE")) && (!str.equals("R7Plusm")) && (!str.equals("vivo X5M")) && (!str.equals("SLA-AL00")) && (!str.equals("vivo Y71A")) && (!str.equals("vivo Y66i A")) && (!str.equals("Redmi 4A")) && (!str.equals("vivo X6Plus A")) && (!str.equals("vivo Y31")) && (!str.equals("SCL-AL00")) && (!str.equals("2014813")) && (!str.equals("Redmi Note 5A")) && (!str.equals("A31"))) {
        localArrayList2.add(a(3, ajjy.a(2131650464), 103, "tran_speed", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speed.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speed_static.png", "speedLine", "1", "6", "Basic"));
      }
    }
    localArrayList2.add(a(9, ajjy.a(2131650466), 103, "tran_slip", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_sideSlip.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_sideSlip_static.png", "sideSlip", "1", "7", "Basic"));
    localArrayList2.add(a(8, ajjy.a(2131650480), 103, "tran_light", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_flashOut.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_flashOut_static.png", "flashOut", "1", "8", "Basic"));
    localArrayList2.add(a(5, ajjy.a(2131650483), 103, "tran_fade", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor_static.png", "fadecolor", "1", "9", "Basic"));
    localArrayList2.add(a(6, ajjy.a(2131650476), 103, "tran_zoom", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_zoom.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_zoom_static.png", "simpleZoom", "1", "10", "Basic"));
    localArrayList2.add(a(7, ajjy.a(2131650462), 103, "tran_wipe", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_wipe.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_wipe_static.png", "directionalwipe", "1", "11", "Basic"));
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
      bjac.jdField_a_of_type_JavaUtilHashMap.put(((FilterDesc)localObject2).name, localObject2);
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
    ((bhgs)bhfm.a(5)).a((List)localObject2);
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
    this.jdField_a_of_type_Bjae = bjac.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, true, false);
    this.b = bjac.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, false, true);
    this.c = bjac.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, false, false);
  }
  
  public void a(CopyOnWriteArrayList<FilterCategory> paramCopyOnWriteArrayList)
  {
    ComboLockManager localComboLockManager = ((bhgs)bhfm.a(5)).a();
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
          if (localComboLockManager.a(localQIMFilterCategoryItem2.jdField_a_of_type_JavaLangString))
          {
            ((List)localObject1).add(localQIMFilterCategoryItem2);
          }
          else
          {
            bjac.a();
            if (bjac.a(3, localQIMFilterCategoryItem2.jdField_a_of_type_Int, localQIMFilterCategoryItem2.jdField_a_of_type_JavaLangString)) {
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
    if (!bjac.b())
    {
      localArrayList.add(a(1, ajjy.a(2131650461), 103, "tran_move", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move_static.png", "speedWipe", "0", "3", "Basic"));
      localArrayList.add(a(10, ajjy.a(2131650477), 103, "tran_speedout", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speedOut.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speedOut_static.png", "speedOut", "0", "4", "Basic"));
      localArrayList.add(a(11, ajjy.a(2131650481), 103, "tran_filterCut", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_filterCut.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_filterCut_static.png", "filterCut", "0", "5", "Basic"));
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjad
 * JD-Core Version:    0.7.0.1
 */