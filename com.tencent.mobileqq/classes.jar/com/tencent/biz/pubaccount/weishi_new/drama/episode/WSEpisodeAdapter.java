package com.tencent.biz.pubaccount.weishi_new.drama.episode;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.WSAbsSingleCheckAdapter;
import java.util.List;

public class WSEpisodeAdapter
  extends WSAbsSingleCheckAdapter<WSEpisodeItemData, WSEpisodeHolder>
{
  private long a;
  private int b;
  
  public WSEpisodeAdapter(Context paramContext, RecyclerView paramRecyclerView)
  {
    super(paramContext, paramRecyclerView);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public WSEpisodeHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new WSEpisodeHolder(paramViewGroup, this);
  }
  
  public void a(WSEpisodeHolder paramWSEpisodeHolder, int paramInt)
  {
    WSEpisodeItemData localWSEpisodeItemData = (WSEpisodeItemData)getDataList().get(paramInt);
    if (localWSEpisodeItemData.a()) {
      this.jdField_a_of_type_Int = paramInt;
    }
    localWSEpisodeItemData.a(paramInt + 1);
    paramWSEpisodeHolder.a(localWSEpisodeItemData);
    if (paramInt >= this.b)
    {
      this.b = paramInt;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  public boolean fillList(List<WSEpisodeItemData> paramList)
  {
    this.jdField_a_of_type_Long = 0L;
    this.b = 0;
    return super.fillList(paramList);
  }
  
  public int getCustomItemViewType(int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.episode.WSEpisodeAdapter
 * JD-Core Version:    0.7.0.1
 */