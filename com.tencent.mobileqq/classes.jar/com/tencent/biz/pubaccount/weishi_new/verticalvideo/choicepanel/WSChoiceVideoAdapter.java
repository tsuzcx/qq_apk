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
  private long b;
  private int c = -1;
  private long d;
  private int e = -1;
  
  public WSChoiceVideoAdapter(Context paramContext, RecyclerView paramRecyclerView)
  {
    super(paramContext, paramRecyclerView);
  }
  
  private void b(int paramInt)
  {
    if (paramInt >= this.c)
    {
      this.c = paramInt;
      this.b = System.currentTimeMillis();
    }
    int i = this.e;
    if ((paramInt <= i) || (i == -1))
    {
      this.e = paramInt;
      this.d = System.currentTimeMillis();
    }
  }
  
  private String c(int paramInt)
  {
    if (paramInt < getDataList().size()) {
      return ((WSVerticalItemData)getDataList().get(paramInt)).b().id;
    }
    return "";
  }
  
  public WSChoiceVideoHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new WSChoiceVideoHolder(paramViewGroup, this);
  }
  
  public void a(WSChoiceVideoHolder paramWSChoiceVideoHolder, int paramInt)
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)getDataList().get(paramInt);
    if (localWSVerticalItemData.a()) {
      this.a = paramInt;
    }
    paramWSChoiceVideoHolder.a(localWSVerticalItemData);
    b(paramInt);
  }
  
  public void a(WSXRecyclerView paramWSXRecyclerView)
  {
    paramWSXRecyclerView = (LinearLayoutManager)paramWSXRecyclerView.getRecyclerView().getLayoutManager();
    this.d = System.currentTimeMillis();
    this.e = paramWSXRecyclerView.findFirstVisibleItemPosition();
    this.b = System.currentTimeMillis();
    this.c = paramWSXRecyclerView.findLastVisibleItemPosition();
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
    this.a += i;
    this.c += i;
    this.e += i;
  }
  
  public Map<String, String> c()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("max_feedid", c(this.c));
    localHashMap.put("max_times", String.valueOf(this.b));
    localHashMap.put("min_feedid", c(this.e));
    localHashMap.put("min_times", String.valueOf(this.d));
    localHashMap.put("num", String.valueOf(this.c - this.e));
    return localHashMap;
  }
  
  public int getCustomItemViewType(int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.WSChoiceVideoAdapter
 * JD-Core Version:    0.7.0.1
 */