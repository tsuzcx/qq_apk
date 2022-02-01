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
    super(paramViewGroup, 2131560525);
    b();
  }
  
  public static WSFollowSeparateHolder1 a(ViewGroup paramViewGroup, WSFollowAdapter paramWSFollowAdapter)
  {
    return new WSFollowSeparateHolder1(paramViewGroup, paramWSFollowAdapter);
  }
  
  private void b()
  {
    this.a = ((TextView)a(2131382040));
    this.b = ((TextView)a(2131382041));
  }
  
  public void a()
  {
    WSFollowBeaconReport.a(1);
  }
  
  public void a(stFeed paramstFeed)
  {
    if (paramstFeed == null) {}
    do
    {
      return;
      paramstFeed = paramstFeed.recommend_splitter;
    } while (paramstFeed == null);
    if (TextUtils.isEmpty(paramstFeed.text)) {
      this.a.setVisibility(8);
    }
    while (TextUtils.isEmpty(paramstFeed.tips))
    {
      this.b.setVisibility(8);
      return;
      this.a.setVisibility(0);
      this.a.setText(paramstFeed.text);
    }
    this.b.setVisibility(0);
    this.b.setText(paramstFeed.tips);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowSeparateHolder1
 * JD-Core Version:    0.7.0.1
 */