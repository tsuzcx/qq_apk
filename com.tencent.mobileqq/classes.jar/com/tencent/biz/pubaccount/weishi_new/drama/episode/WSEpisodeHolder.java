package com.tencent.biz.pubaccount.weishi_new.drama.episode;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.OnCheckedListener;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.WSAbsCheckableHolder;

public class WSEpisodeHolder
  extends WSAbsCheckableHolder<WSEpisodeItemData>
{
  private TextView b;
  
  public WSEpisodeHolder(ViewGroup paramViewGroup, OnCheckedListener<WSEpisodeItemData> paramOnCheckedListener)
  {
    super(paramViewGroup, 2131626041, paramOnCheckedListener);
    c();
  }
  
  private void c()
  {
    this.b = ((TextView)this.itemView.findViewById(2131432584));
    this.itemView.setOnClickListener(new WSEpisodeHolder.1(this));
  }
  
  public void a(WSEpisodeItemData paramWSEpisodeItemData)
  {
    super.a(paramWSEpisodeItemData);
    this.b.setText(getContext().getString(1929838604, new Object[] { Integer.valueOf(paramWSEpisodeItemData.c()) }));
    a(paramWSEpisodeItemData.a());
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setBackgroundResource(2130842797);
      this.b.setTextColor(-16777216);
      return;
    }
    this.b.setBackgroundResource(2130842796);
    this.b.setTextColor(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.episode.WSEpisodeHolder
 * JD-Core Version:    0.7.0.1
 */