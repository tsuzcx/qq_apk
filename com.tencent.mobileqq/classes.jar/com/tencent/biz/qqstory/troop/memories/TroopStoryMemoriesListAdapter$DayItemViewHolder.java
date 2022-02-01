package com.tencent.biz.qqstory.troop.memories;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;

class TroopStoryMemoriesListAdapter$DayItemViewHolder
{
  public TextView a;
  public TextView b;
  public TextView c;
  public TextView d;
  public View e;
  public View f;
  public View g;
  public View h;
  
  public TroopStoryMemoriesListAdapter$DayItemViewHolder(TroopStoryMemoriesListAdapter paramTroopStoryMemoriesListAdapter, View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131447674));
    this.b = ((TextView)paramView.findViewById(2131431631));
    this.c = ((TextView)paramView.findViewById(2131438820));
    this.d = ((TextView)paramView.findViewById(2131449518));
    this.e = paramView.findViewById(2131437217);
    this.f = paramView.findViewById(2131437219);
    this.h = paramView.findViewById(2131437220);
    this.g = paramView.findViewById(2131437218);
  }
  
  public void a(TroopStoryItemInfo paramTroopStoryItemInfo, int paramInt)
  {
    Object localObject = DateUtils.a(paramTroopStoryItemInfo.publishTime);
    if (TextUtils.isEmpty(localObject[0]))
    {
      this.a.setText(localObject[1]);
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      this.a.setVisibility(0);
      this.h.setVisibility(8);
      this.g.setVisibility(8);
      if ((paramInt > 0) && (((TroopStoryItemInfo)this.i.a.get(paramInt - 1)).itemType == 0))
      {
        this.f.setVisibility(8);
        this.e.setVisibility(0);
      }
      else
      {
        this.f.setVisibility(0);
        this.e.setVisibility(8);
      }
    }
    else
    {
      this.b.setText(localObject[1]);
      this.c.setText(localObject[0]);
      this.b.setVisibility(0);
      this.c.setVisibility(0);
      this.a.setVisibility(8);
      if ((paramInt > 0) && (((TroopStoryItemInfo)this.i.a.get(paramInt - 1)).itemType == 0))
      {
        this.h.setVisibility(8);
        this.g.setVisibility(0);
      }
      else
      {
        this.h.setVisibility(0);
        this.g.setVisibility(8);
      }
      this.f.setVisibility(8);
      this.e.setVisibility(8);
    }
    if (paramTroopStoryItemInfo.publishCount == 0)
    {
      this.d.setText(HardCodeUtil.a(2131913042));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramTroopStoryItemInfo.publishCount);
    ((StringBuilder)localObject).append("个小视频");
    if (paramTroopStoryItemInfo.dayCommentCount > 0)
    {
      ((StringBuilder)localObject).append(" 评论");
      ((StringBuilder)localObject).append(paramTroopStoryItemInfo.dayCommentCount);
      if (paramTroopStoryItemInfo.dayLikeCount > 0) {
        ((StringBuilder)localObject).append("·");
      }
    }
    if (paramTroopStoryItemInfo.dayLikeCount > 0)
    {
      if (paramTroopStoryItemInfo.dayCommentCount <= 0) {
        ((StringBuilder)localObject).append(" ");
      }
      ((StringBuilder)localObject).append("赞");
      ((StringBuilder)localObject).append(paramTroopStoryItemInfo.dayLikeCount);
    }
    this.d.setText(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.DayItemViewHolder
 * JD-Core Version:    0.7.0.1
 */