package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stFeed;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter;
import com.tencent.biz.pubaccount.weishi_new.WSItemDecoration;
import com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSRecommendFollowAdapter;
import com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSRecommendFollowHolder;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.List;

public class WSFollowPersonHolder
  extends BaseViewHolder<stFeed>
{
  private WSFollowAdapter a;
  private RecyclerView b;
  private WSRecommendFollowAdapter c;
  private LinearLayout d;
  private LinearLayoutManager e;
  
  private WSFollowPersonHolder(ViewGroup paramViewGroup, WSFollowAdapter paramWSFollowAdapter)
  {
    super(paramViewGroup, 2131626458);
    this.a = paramWSFollowAdapter;
    c();
  }
  
  public static WSFollowPersonHolder a(ViewGroup paramViewGroup, WSFollowAdapter paramWSFollowAdapter)
  {
    return new WSFollowPersonHolder(paramViewGroup, paramWSFollowAdapter);
  }
  
  private void c()
  {
    this.d = ((LinearLayout)getView(2131434378));
    this.b = ((RecyclerView)getView(2131444434));
    TextView localTextView1 = (TextView)getView(2131450295);
    TextView localTextView2 = (TextView)getView(2131450294);
    ImageView localImageView = (ImageView)getView(2131450267);
    localTextView2.setVisibility(8);
    localImageView.setVisibility(8);
    localTextView1.setText(2131918108);
    this.e = new LinearLayoutManager(getContext(), 0, false);
    this.b.setLayoutManager(this.e);
    this.b.setHasFixedSize(true);
    this.c = new WSRecommendFollowAdapter(getContext(), this.a);
    this.b.setAdapter(this.c);
    this.b.addItemDecoration(new WSItemDecoration());
  }
  
  public RecyclerView a()
  {
    return this.b;
  }
  
  public void a(stFeed paramstFeed)
  {
    if (paramstFeed == null)
    {
      this.d.setVisibility(8);
      return;
    }
    this.d.setVisibility(0);
    this.c.a(paramstFeed);
    this.c.fillList(paramstFeed.person_meta);
  }
  
  public void b()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      if (this.c == null) {
        return;
      }
      int i = ((LinearLayoutManager)localObject).findFirstVisibleItemPosition();
      int j = this.e.findLastVisibleItemPosition();
      if (i >= 0)
      {
        if (j >= this.c.getDataList().size()) {
          return;
        }
        while (i <= j)
        {
          localObject = this.b.findViewHolderForAdapterPosition(i);
          if ((localObject instanceof WSRecommendFollowHolder)) {
            ((WSRecommendFollowHolder)localObject).c();
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowPersonHolder
 * JD-Core Version:    0.7.0.1
 */