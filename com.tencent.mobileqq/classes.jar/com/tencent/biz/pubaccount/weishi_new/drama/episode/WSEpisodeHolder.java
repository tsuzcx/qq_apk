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
  private TextView a;
  
  public WSEpisodeHolder(ViewGroup paramViewGroup, OnCheckedListener<WSEpisodeItemData> paramOnCheckedListener)
  {
    super(paramViewGroup, 2131559998, paramOnCheckedListener);
    b();
  }
  
  private void b()
  {
    this.a = ((TextView)this.itemView.findViewById(2131366282));
    this.itemView.setOnClickListener(new WSEpisodeHolder.1(this));
  }
  
  public void a(WSEpisodeItemData paramWSEpisodeItemData)
  {
    super.a(paramWSEpisodeItemData);
    this.a.setText(getContext().getString(1929707522, new Object[] { Integer.valueOf(paramWSEpisodeItemData.a()) }));
    a(paramWSEpisodeItemData.a());
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.setBackgroundResource(2130841880);
      this.a.setTextColor(-16777216);
      return;
    }
    this.a.setBackgroundResource(2130841879);
    this.a.setTextColor(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.episode.WSEpisodeHolder
 * JD-Core Version:    0.7.0.1
 */