package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stFeed;
import UserGrowth.stSplitBlock;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.widget.pull2refresh.BaseViewHolder;

public class WSFollowSeparateHolder1
  extends BaseViewHolder<stFeed>
{
  private TextView a;
  private TextView b;
  
  private WSFollowSeparateHolder1(ViewGroup paramViewGroup, WSFollowAdapter paramWSFollowAdapter)
  {
    super(paramViewGroup, 2131560412);
    b();
  }
  
  public static WSFollowSeparateHolder1 a(ViewGroup paramViewGroup, WSFollowAdapter paramWSFollowAdapter)
  {
    return new WSFollowSeparateHolder1(paramViewGroup, paramWSFollowAdapter);
  }
  
  private void b()
  {
    this.a = ((TextView)getView(2131381243));
    this.b = ((TextView)getView(2131381244));
  }
  
  public void a()
  {
    WSFollowBeaconReport.a(1);
  }
  
  public void a(stFeed paramstFeed)
  {
    if (paramstFeed == null) {
      return;
    }
    paramstFeed = paramstFeed.recommend_splitter;
    if (paramstFeed != null)
    {
      if (TextUtils.isEmpty(paramstFeed.text))
      {
        this.a.setVisibility(8);
      }
      else
      {
        this.a.setVisibility(0);
        this.a.setText(paramstFeed.text);
      }
      if (TextUtils.isEmpty(paramstFeed.tips))
      {
        this.b.setVisibility(8);
        return;
      }
      this.b.setVisibility(0);
      this.b.setText(paramstFeed.tips);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowSeparateHolder1
 * JD-Core Version:    0.7.0.1
 */