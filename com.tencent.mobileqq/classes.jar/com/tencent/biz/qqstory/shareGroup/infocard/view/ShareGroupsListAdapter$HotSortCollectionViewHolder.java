package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.List;

public class ShareGroupsListAdapter$HotSortCollectionViewHolder
  extends BaseStoryTimeLineAdapter.BaseViewHolder
{
  public ShareGroupsListAdapter.HotSortCardHolder b;
  public ShareGroupsListAdapter.HotSortCardHolder c;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  public TextView h;
  public TextView i;
  
  public ShareGroupsListAdapter$HotSortCollectionViewHolder(View paramView, ShareGroupsListAdapter paramShareGroupsListAdapter)
  {
    View localView = paramView.findViewById(2131442717);
    paramView = paramView.findViewById(2131442760);
    this.b = new ShareGroupsListAdapter.HotSortCardHolder(localView, paramShareGroupsListAdapter.b);
    this.c = new ShareGroupsListAdapter.HotSortCardHolder(paramView, paramShareGroupsListAdapter.b);
    this.d = ((TextView)localView.findViewById(2131430376));
    this.e = ((TextView)paramView.findViewById(2131430376));
    this.f = ((TextView)localView.findViewById(2131430355));
    this.g = ((TextView)paramView.findViewById(2131430355));
    this.h = ((TextView)localView.findViewById(2131430371));
    this.i = ((TextView)paramView.findViewById(2131430371));
    QQStoryContext.a();
    if (ThemeUtil.isInNightMode(QQStoryContext.k()))
    {
      this.d.setTextColor(Color.parseColor("#6991b8"));
      this.e.setTextColor(Color.parseColor("#6991b8"));
      this.f.setTextColor(Color.parseColor("#6991b8"));
      this.g.setTextColor(Color.parseColor("#6991b8"));
      this.h.setTextColor(Color.parseColor("#6991b8"));
      this.i.setTextColor(Color.parseColor("#6991b8"));
    }
    if (paramShareGroupsListAdapter.e != null)
    {
      this.b.a(paramShareGroupsListAdapter.e);
      this.c.a(paramShareGroupsListAdapter.e);
    }
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    if ((paramVideoCollectionItem != null) && (paramView != null))
    {
      paramView = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(0);
      paramVideoCollectionItem = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(1);
      this.b.a(paramView);
      if (paramVideoCollectionItem == null)
      {
        this.c.a();
        return;
      }
      this.c.a(paramVideoCollectionItem);
      return;
    }
    SLog.e("Q.qqstory.shareGroup.ShareGroupsListAdapter", "qqstory sharegroup hotsort erro. view  or data is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter.HotSortCollectionViewHolder
 * JD-Core Version:    0.7.0.1
 */