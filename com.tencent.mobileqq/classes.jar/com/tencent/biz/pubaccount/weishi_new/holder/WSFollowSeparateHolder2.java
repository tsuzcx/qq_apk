package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stFeed;
import UserGrowth.stSplitBlock;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.widget.pull2refresh.BaseViewHolder;

public class WSFollowSeparateHolder2
  extends BaseViewHolder<stFeed>
{
  private TextView a;
  
  private WSFollowSeparateHolder2(ViewGroup paramViewGroup, WSFollowAdapter paramWSFollowAdapter)
  {
    super(paramViewGroup, 2131626477);
    b();
  }
  
  public static WSFollowSeparateHolder2 a(ViewGroup paramViewGroup, WSFollowAdapter paramWSFollowAdapter)
  {
    return new WSFollowSeparateHolder2(paramViewGroup, paramWSFollowAdapter);
  }
  
  private void b()
  {
    this.a = ((TextView)getView(2131450298));
  }
  
  public void a()
  {
    WSFollowBeaconReport.a(2);
  }
  
  public void a(stFeed paramstFeed)
  {
    if (paramstFeed == null) {
      return;
    }
    paramstFeed = paramstFeed.recommend_splitter;
    if (paramstFeed != null) {
      this.a.setText(paramstFeed.tips);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowSeparateHolder2
 * JD-Core Version:    0.7.0.1
 */