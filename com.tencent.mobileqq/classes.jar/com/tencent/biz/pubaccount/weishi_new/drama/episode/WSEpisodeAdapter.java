package com.tencent.biz.pubaccount.weishi_new.drama.episode;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.WSAbsSingleCheckAdapter;
import java.util.List;

public class WSEpisodeAdapter
  extends WSAbsSingleCheckAdapter<WSEpisodeItemData, WSEpisodeHolder>
{
  private long b;
  private int c;
  
  public WSEpisodeAdapter(Context paramContext, RecyclerView paramRecyclerView)
  {
    super(paramContext, paramRecyclerView);
  }
  
  public WSEpisodeHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new WSEpisodeHolder(paramViewGroup, this);
  }
  
  public void a(WSEpisodeHolder paramWSEpisodeHolder, int paramInt)
  {
    WSEpisodeItemData localWSEpisodeItemData = (WSEpisodeItemData)getDataList().get(paramInt);
    if (localWSEpisodeItemData.a()) {
      this.a = paramInt;
    }
    localWSEpisodeItemData.a(paramInt + 1);
    paramWSEpisodeHolder.a(localWSEpisodeItemData);
    if (paramInt >= this.c)
    {
      this.c = paramInt;
      this.b = System.currentTimeMillis();
    }
  }
  
  public int c()
  {
    return this.c;
  }
  
  public long d()
  {
    return this.b;
  }
  
  public boolean fillList(List<WSEpisodeItemData> paramList)
  {
    this.b = 0L;
    this.c = 0;
    return super.fillList(paramList);
  }
  
  public int getCustomItemViewType(int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.episode.WSEpisodeAdapter
 * JD-Core Version:    0.7.0.1
 */