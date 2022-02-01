package com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.WSAbsSingleCheckAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.view.WSXRecyclerView;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WSChoiceVideoAdapter
  extends WSAbsSingleCheckAdapter<WSVerticalItemData, WSChoiceVideoHolder>
{
  private long a;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long;
  private int c = -1;
  
  public WSChoiceVideoAdapter(Context paramContext, RecyclerView paramRecyclerView)
  {
    super(paramContext, paramRecyclerView);
  }
  
  private String a(int paramInt)
  {
    if (paramInt < getDataList().size()) {
      return ((WSVerticalItemData)getDataList().get(paramInt)).a().id;
    }
    return "";
  }
  
  private void b(int paramInt)
  {
    if (paramInt >= this.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    int i = this.c;
    if ((paramInt <= i) || (i == -1))
    {
      this.c = paramInt;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public WSChoiceVideoHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new WSChoiceVideoHolder(paramViewGroup, this);
  }
  
  public Map<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("max_feedid", a(this.jdField_b_of_type_Int));
    localHashMap.put("max_times", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("min_feedid", a(this.c));
    localHashMap.put("min_times", String.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("num", String.valueOf(this.jdField_b_of_type_Int - this.c));
    return localHashMap;
  }
  
  public void a(WSChoiceVideoHolder paramWSChoiceVideoHolder, int paramInt)
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)getDataList().get(paramInt);
    if (localWSVerticalItemData.a()) {
      this.jdField_a_of_type_Int = paramInt;
    }
    paramWSChoiceVideoHolder.a(localWSVerticalItemData);
    b(paramInt);
  }
  
  public void a(WSXRecyclerView paramWSXRecyclerView)
  {
    paramWSXRecyclerView = (LinearLayoutManager)paramWSXRecyclerView.getRecyclerView().getLayoutManager();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.c = paramWSXRecyclerView.findFirstVisibleItemPosition();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Int = paramWSXRecyclerView.findLastVisibleItemPosition();
  }
  
  public void a(List<WSVerticalItemData> paramList)
  {
    List localList = getDataList();
    if ((localList != null) && (localList.addAll(paramList))) {
      notifyItemRangeChanged(localList.size() - paramList.size(), paramList.size());
    }
  }
  
  public void b(List<WSVerticalItemData> paramList)
  {
    List localList = getDataList();
    if (localList == null) {
      return;
    }
    if (localList.addAll(0, paramList)) {
      notifyItemRangeInserted(0, paramList.size());
    }
    int i = paramList.size();
    this.jdField_a_of_type_Int += i;
    this.jdField_b_of_type_Int += i;
    this.c += i;
  }
  
  public int getCustomItemViewType(int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.WSChoiceVideoAdapter
 * JD-Core Version:    0.7.0.1
 */