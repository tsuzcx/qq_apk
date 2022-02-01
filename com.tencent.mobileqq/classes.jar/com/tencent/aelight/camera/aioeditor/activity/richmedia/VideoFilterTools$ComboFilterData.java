package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.os.Build;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.aioeditor.QIMCaptureVarManager;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboLockManager;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterCategory;
import com.tencent.aelight.camera.aioeditor.capture.data.LockedCategory;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.data.TransitionCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMFileUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
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

public class VideoFilterTools$ComboFilterData
{
  String a;
  CopyOnWriteArrayList<FilterCategory> b;
  public HashMap<String, LockedCategory> c = new HashMap();
  public VideoFilterTools.DataSet d = new VideoFilterTools.DataSet();
  public VideoFilterTools.DataSet e = new VideoFilterTools.DataSet();
  public VideoFilterTools.DataSet f = new VideoFilterTools.DataSet();
  public VideoFilterTools.DataSet g = new VideoFilterTools.DataSet();
  public VideoFilterTools.DataSet h = new VideoFilterTools.DataSet();
  public VideoFilterTools.DataSet i = new VideoFilterTools.DataSet();
  
  public VideoFilterTools$ComboFilterData(String paramString)
  {
    this.a = paramString;
    this.b = a(paramString);
    this.d = VideoFilterTools.a(this.b, true, false, false);
    this.f = VideoFilterTools.a(this.b, false, true, false);
    this.g = VideoFilterTools.a(this.b, false, false, false);
    this.e = VideoFilterTools.a(this.b, true, false, true);
    this.h = VideoFilterTools.a(this.b, false, true, true);
    this.i = VideoFilterTools.a(this.b, false, false, true);
    if (!a(this.e))
    {
      this.e = a();
      this.h = a();
      this.i = a();
    }
  }
  
  private TransitionCategoryItem a(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    TransitionCategoryItem localTransitionCategoryItem = new TransitionCategoryItem();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("");
    localTransitionCategoryItem.a = localStringBuilder.toString();
    localTransitionCategoryItem.b = paramString1;
    localTransitionCategoryItem.d = paramString4;
    localTransitionCategoryItem.s = paramString3;
    localTransitionCategoryItem.e = paramInt2;
    localTransitionCategoryItem.j = new ArrayList(1);
    localTransitionCategoryItem.j.add(paramString2);
    localTransitionCategoryItem.t = paramString5;
    localTransitionCategoryItem.u = paramString7;
    localTransitionCategoryItem.v = paramString8;
    localTransitionCategoryItem.w = paramString6;
    return localTransitionCategoryItem;
  }
  
  public static List<QIMFilterCategoryItem> a(List<QIMFilterCategoryItem> paramList)
  {
    try
    {
      if (!AEDashboardUtil.d()) {
        break label93;
      }
      j = 104;
    }
    finally
    {
      for (;;)
      {
        ArrayList localArrayList;
        for (;;)
        {
          throw paramList;
        }
        label93:
        int j = 103;
      }
    }
    localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)paramList.next();
        if ((localQIMFilterCategoryItem != null) && (localQIMFilterCategoryItem.e == j)) {
          localArrayList.add(localQIMFilterCategoryItem);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(VideoFilterTools.DataSet paramDataSet1, VideoFilterTools.DataSet paramDataSet2)
  {
    Object localObject1 = (QIMCaptureVarManager)QIMManager.a(13);
    ArrayList localArrayList1 = new ArrayList();
    int k = 0;
    int j = 0;
    while (j < paramDataSet1.a.size())
    {
      if (!((QIMCaptureVarManager)localObject1).c(((FilterCategory)paramDataSet1.a.get(j)).f)) {
        localArrayList1.add(paramDataSet1.a.get(j));
      }
      j += 1;
    }
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = (ArrayList)paramDataSet1.c.clone();
    j = k;
    Object localObject2;
    while (j < paramDataSet1.b.size())
    {
      if (!((QIMCaptureVarManager)localObject1).c(((FilterCategory)paramDataSet1.b.get(j)).f))
      {
        localArrayList2.add(paramDataSet1.b.get(j));
      }
      else
      {
        localObject2 = ((FilterCategory)paramDataSet1.b.get(j)).c.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject2).next();
          if (!localQIMFilterCategoryItem.equals(paramDataSet1.f)) {
            localArrayList3.remove(localQIMFilterCategoryItem);
          }
        }
      }
      j += 1;
    }
    localArrayList2 = (ArrayList)localArrayList2.clone();
    localArrayList3 = (ArrayList)localArrayList3.clone();
    if (AEDashboardUtil.d()) {
      j = 2;
    } else {
      j = 1;
    }
    if (((QIMCaptureVarManager)localObject1).b())
    {
      localObject1 = localArrayList2.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FilterCategory)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((FilterCategory)localObject2).g != j)) {
          ((Iterator)localObject1).remove();
        }
      }
      localObject1 = localArrayList3.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (QIMFilterCategoryItem)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((QIMFilterCategoryItem)localObject2).g != j)) {
          ((Iterator)localObject1).remove();
        }
      }
    }
    paramDataSet2.a = localArrayList1;
    paramDataSet2.b = localArrayList2;
    paramDataSet2.c = localArrayList3;
    paramDataSet2.d = paramDataSet1.d;
    paramDataSet2.e = paramDataSet1.e;
    paramDataSet2.f = paramDataSet1.f;
  }
  
  private boolean a(VideoFilterTools.DataSet paramDataSet)
  {
    if (paramDataSet == null) {
      return false;
    }
    paramDataSet = paramDataSet.b.iterator();
    while (paramDataSet.hasNext()) {
      if (((FilterCategory)paramDataSet.next()).a == 104) {
        return true;
      }
    }
    AEQLog.b("VideoFilterTools", "has no V8 config");
    return false;
  }
  
  public VideoFilterTools.DataSet a()
  {
    Object localObject2 = new VideoFilterTools.DataSet();
    Object localObject1 = QIMFileUtils.a("filter_template.cfg");
    try
    {
      localObject1 = VideoFilterTools.a(a((String)localObject1), false, false, true);
    }
    catch (Exception localException)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("v8 initFromAsset ");
        ((StringBuilder)localObject1).append(false);
        QLog.i("VideoFilterTools", 2, ((StringBuilder)localObject1).toString(), localException);
        localObject1 = localObject2;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initFromAsset ");
      ((StringBuilder)localObject2).append(false);
      ((StringBuilder)localObject2).append(" size: ");
      ((StringBuilder)localObject2).append(((VideoFilterTools.DataSet)localObject1).c.size());
      QLog.i("VideoFilterTools", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public VideoFilterTools.DataSet a(int paramInt)
  {
    VideoFilterTools.DataSet localDataSet2 = new VideoFilterTools.DataSet();
    VideoFilterTools.DataSet localDataSet1 = this.d;
    boolean bool = AEDashboardUtil.d();
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            if (paramInt != 4) {
              break label102;
            }
          }
        }
        else
        {
          if (bool)
          {
            localDataSet1 = this.i;
            break label102;
          }
          localDataSet1 = this.g;
          break label102;
        }
      }
      if (bool) {
        localDataSet1 = this.h;
      } else {
        localDataSet1 = this.f;
      }
    }
    else if (bool)
    {
      localDataSet1 = this.e;
    }
    else
    {
      localDataSet1 = this.d;
    }
    label102:
    a(localDataSet1, localDataSet2);
    return localDataSet2;
  }
  
  public CopyOnWriteArrayList<FilterCategory> a(String paramString)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    paramString = new JSONObject(paramString);
    Object localObject1 = FilterDesc.parse(paramString.getJSONArray("filters")).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FilterDesc)((Iterator)localObject1).next();
      VideoFilterTools.c.put(((FilterDesc)localObject2).name, localObject2);
    }
    localObject1 = paramString.getJSONArray("categorys");
    Object localObject2 = new ArrayList(((JSONArray)localObject1).length());
    int k = 0;
    int j = 0;
    while (j < ((JSONArray)localObject1).length())
    {
      ((ArrayList)localObject2).add(new FilterCategory(((JSONArray)localObject1).getJSONObject(j), null));
      j += 1;
    }
    localCopyOnWriteArrayList.clear();
    localCopyOnWriteArrayList.addAll((Collection)localObject2);
    ((CaptureComboManager)QIMManager.a(5)).a((List)localObject2);
    paramString = paramString.optJSONArray("locked_categorys");
    if (paramString != null)
    {
      j = k;
      while (j < paramString.length())
      {
        localObject2 = paramString.optJSONObject(j);
        if (localObject2 != null)
        {
          localObject1 = ((JSONObject)localObject2).optString("comboId");
          localObject2 = new LockedCategory((JSONObject)localObject2);
          this.c.put(localObject1, localObject2);
        }
        j += 1;
      }
    }
    return localCopyOnWriteArrayList;
  }
  
  public void a(CopyOnWriteArrayList<FilterCategory> paramCopyOnWriteArrayList)
  {
    ComboLockManager localComboLockManager = ((CaptureComboManager)QIMManager.a(5)).i();
    paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    while (paramCopyOnWriteArrayList.hasNext())
    {
      FilterCategory localFilterCategory = (FilterCategory)paramCopyOnWriteArrayList.next();
      if (localFilterCategory.e)
      {
        QIMFilterCategoryItem localQIMFilterCategoryItem1 = (QIMFilterCategoryItem)localFilterCategory.c.remove(0);
        Object localObject1 = new LinkedList();
        Object localObject2 = new LinkedList();
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = localFilterCategory.c.iterator();
        while (localIterator.hasNext())
        {
          QIMFilterCategoryItem localQIMFilterCategoryItem2 = (QIMFilterCategoryItem)localIterator.next();
          if (localComboLockManager.c(localQIMFilterCategoryItem2.a))
          {
            ((List)localObject1).add(localQIMFilterCategoryItem2);
          }
          else
          {
            VideoFilterTools.a();
            if (VideoFilterTools.a(3, localQIMFilterCategoryItem2.e, localQIMFilterCategoryItem2.a)) {
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
        localFilterCategory.c = localLinkedList;
      }
    }
  }
  
  public void b()
  {
    a(this.b);
    this.d = VideoFilterTools.a(this.b, true, false, false);
    this.f = VideoFilterTools.a(this.b, false, true, false);
    this.g = VideoFilterTools.a(this.b, false, false, false);
  }
  
  public ArrayList<FilterCategory> c()
  {
    boolean bool = VideoFilterTools.d();
    ArrayList localArrayList1 = new ArrayList(2);
    FilterCategory localFilterCategory = new FilterCategory(1001, HardCodeUtil.a(2131913455), false, false, 0, 0);
    ArrayList localArrayList2 = new ArrayList(15);
    if (!bool) {
      localArrayList2.add(a(4, HardCodeUtil.a(2131913473), 103, "tran_default", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default_static.png", "LinearBlur", "1", "1", "Basic"));
    }
    localArrayList2.add(a(-1, HardCodeUtil.a(2131913469), 103, "tran_no", null, "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_no_static.png", "NoEffect", "1", "2", "Basic"));
    if (!bool)
    {
      localArrayList2.add(a(12, HardCodeUtil.a(2131913472), 103, "tran_reverse", "https://dl.url.cn/myapp/qq_desk/shortvideo/transition/trans_turn.png", "https://dl.url.cn/myapp/qq_desk/shortvideo/transition/trans_turn_static.png", "Flipping", "1", "12", "Basic"));
      localArrayList2.add(a(13, HardCodeUtil.a(2131913460), 103, "tran_recombine", "https://dl.url.cn/myapp/qq_desk/shortvideo/transition/trans_remix.png", "https://dl.url.cn/myapp/qq_desk/shortvideo/transition/trans_remix_static.png", "Recombination", "1", "13", "Basic"));
      localArrayList2.add(a(1, HardCodeUtil.a(2131913465), 103, "tran_move", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move_static.png", "speedWipe", "1", "3", "Basic"));
      localArrayList2.add(a(10, HardCodeUtil.a(2131913476), 103, "tran_speedout", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speedOut.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speedOut_static.png", "speedOut", "1", "4", "Basic"));
      localArrayList2.add(a(11, HardCodeUtil.a(2131913463), 103, "tran_filterCut", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_filterCut.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_filterCut_static.png", "filterCut", "1", "5", "Basic"));
      String str = Build.MODEL;
      if ((str != null) && (!str.equals("MI NOTE LTE")) && (!str.equals("R7Plusm")) && (!str.equals("vivo X5M")) && (!str.equals("SLA-AL00")) && (!str.equals("vivo Y71A")) && (!str.equals("vivo Y66i A")) && (!str.equals("Redmi 4A")) && (!str.equals("vivo X6Plus A")) && (!str.equals("vivo Y31")) && (!str.equals("SCL-AL00")) && (!str.equals("2014813")) && (!str.equals("Redmi Note 5A")) && (!str.equals("A31"))) {
        localArrayList2.add(a(3, HardCodeUtil.a(2131913459), 103, "tran_speed", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speed.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speed_static.png", "speedLine", "1", "6", "Basic"));
      }
    }
    localArrayList2.add(a(9, HardCodeUtil.a(2131913461), 103, "tran_slip", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_sideSlip.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_sideSlip_static.png", "sideSlip", "1", "7", "Basic"));
    localArrayList2.add(a(8, HardCodeUtil.a(2131913474), 103, "tran_light", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_flashOut.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_flashOut_static.png", "flashOut", "1", "8", "Basic"));
    localArrayList2.add(a(5, HardCodeUtil.a(2131913477), 103, "tran_fade", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor_static.png", "fadecolor", "1", "9", "Basic"));
    localArrayList2.add(a(6, HardCodeUtil.a(2131913470), 103, "tran_zoom", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_zoom.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_zoom_static.png", "simpleZoom", "1", "10", "Basic"));
    localArrayList2.add(a(7, HardCodeUtil.a(2131913457), 103, "tran_wipe", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_wipe.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_wipe_static.png", "directionalwipe", "1", "11", "Basic"));
    localFilterCategory.c = localArrayList2;
    localArrayList1.add(localFilterCategory);
    return localArrayList1;
  }
  
  public ArrayList<QIMFilterCategoryItem> d()
  {
    ArrayList localArrayList = new ArrayList(10);
    if (!VideoFilterTools.d())
    {
      localArrayList.add(a(1, HardCodeUtil.a(2131913456), 103, "tran_move", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move_static.png", "speedWipe", "0", "3", "Basic"));
      localArrayList.add(a(10, HardCodeUtil.a(2131913471), 103, "tran_speedout", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speedOut.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speedOut_static.png", "speedOut", "0", "4", "Basic"));
      localArrayList.add(a(11, HardCodeUtil.a(2131913475), 103, "tran_filterCut", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_filterCut.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_filterCut_static.png", "filterCut", "0", "5", "Basic"));
    }
    return localArrayList;
  }
  
  public TransitionCategoryItem e()
  {
    if (VideoFilterTools.d()) {
      return a(5, HardCodeUtil.a(2131913458), 103, "tran_fade", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor_static.png", "fadecolor", "1", "9", "Basic");
    }
    return a(4, HardCodeUtil.a(2131913468), 103, "tran_default", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default_static.png", "LinearBlur", "1", "1", "Basic");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.ComboFilterData
 * JD-Core Version:    0.7.0.1
 */