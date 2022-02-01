package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.boundaries.StoryDepends.QimUtil;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.utils.ImageUtil;

public class ShareGroupsListAdapter$HotSortCardHolder
  extends RecyclerView.ViewHolder
{
  public Context a;
  public ImageView b;
  public TextView c;
  public TextView d;
  public ImageView e;
  public TextView f;
  public TextView g;
  public TextView h;
  public ImageView i;
  public ImageView j;
  public MyMemoriesListView.OnUIClickListener k;
  
  public ShareGroupsListAdapter$HotSortCardHolder(View paramView, Context paramContext)
  {
    super(paramView);
    this.a = paramContext;
    this.b = ((ImageView)paramView.findViewById(2131430332));
    this.c = ((TextView)paramView.findViewById(2131430354));
    this.d = ((TextView)paramView.findViewById(2131430378));
    this.e = ((ImageView)paramView.findViewById(2131430370));
    this.f = ((TextView)paramView.findViewById(2131430376));
    this.g = ((TextView)paramView.findViewById(2131430355));
    this.h = ((TextView)paramView.findViewById(2131430371));
    this.i = ((ImageView)paramView.findViewById(2131442658));
    this.j = ((ImageView)paramView.findViewById(2131442066));
  }
  
  public void a()
  {
    this.itemView.setVisibility(8);
  }
  
  public void a(HotSortVideoEntry paramHotSortVideoEntry)
  {
    if (paramHotSortVideoEntry == null)
    {
      this.itemView.setVisibility(8);
      return;
    }
    this.itemView.setVisibility(0);
    this.c.setVisibility(8);
    int m = (UIUtils.b(this.a) - UIUtils.a(this.a, 25.0F)) / 2;
    double d1 = m;
    Double.isNaN(d1);
    int n = (int)(d1 * 1.61D);
    this.itemView.getLayoutParams().width = m;
    this.b.getLayoutParams().width = m;
    this.b.getLayoutParams().height = n;
    if (paramHotSortVideoEntry.coverURL == null)
    {
      this.b.setImageDrawable(this.a.getResources().getDrawable(2130848395));
    }
    else
    {
      localObject = ThumbnailUrlHelper.c(paramHotSortVideoEntry.coverURL);
      if (!((String)localObject).equals(this.b.getTag()))
      {
        this.b.setTag(localObject);
        UIUtils.a(this.b, (String)localObject, m, n, m / 30, UIUtils.h, "QQStoryMemory");
      }
    }
    Object localObject = paramHotSortVideoEntry.storyId;
    this.itemView.setOnClickListener(new ShareGroupsListAdapter.HotSortCardHolder.1(this, (String)localObject));
    this.d.setVisibility(8);
    localObject = ((UserManager)SuperManager.a(2)).c(paramHotSortVideoEntry.unionId);
    if (localObject == null)
    {
      if (!"NullImage".equals(this.e.getTag()))
      {
        this.e.setTag("NullImage");
        this.e.setImageBitmap(ImageUtil.k());
      }
      this.f.setText(StoryApi.b(2131897957));
    }
    else
    {
      if (!((QQUserUIItem)localObject).headUrl.equals(this.e.getTag()))
      {
        this.e.setTag(((QQUserUIItem)localObject).headUrl);
        ShareGroupsListAdapter.a(this.e, 0, ((QQUserUIItem)localObject).headUrl);
      }
      this.f.setText(((QQUserUIItem)localObject).getDisplayName());
      if (((QQUserUIItem)localObject).isVipButNoFriend())
      {
        if (StoryDepends.QimUtil.a())
        {
          this.i.setVisibility(0);
          this.j.setVisibility(8);
          n = UIUtils.a(this.a, 72.0F);
          this.f.setMaxWidth(m - n);
        }
        else
        {
          this.i.setVisibility(8);
          this.j.setVisibility(0);
          PlayModeUtils.a(this.j, (QQUserUIItem)localObject);
          localObject = PlayModeUtils.b((QQUserUIItem)localObject);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            this.j.setTag(localObject);
          }
        }
      }
      else
      {
        this.i.setVisibility(8);
        this.j.setVisibility(8);
      }
    }
    if ((paramHotSortVideoEntry.likeCount == 0) && (paramHotSortVideoEntry.viewCount == 0))
    {
      this.g.setVisibility(8);
      this.h.setVisibility(8);
    }
    else
    {
      localObject = this.a.getResources().getDrawable(2130848657);
      ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.a, 12.0F), UIUtils.a(this.a, 12.0F));
      this.g.setText(UIUtils.a(paramHotSortVideoEntry.viewCount));
      this.g.setCompoundDrawables((Drawable)localObject, null, null, null);
      localObject = this.a.getResources().getDrawable(2130848264);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
      this.h.setText(UIUtils.a(paramHotSortVideoEntry.likeCount));
      this.h.setCompoundDrawables((Drawable)localObject, null, null, null);
      this.g.setVisibility(0);
      this.h.setVisibility(0);
    }
    StoryReportor.a("share_story", "exp_video_card", 0, 0, new String[] { paramHotSortVideoEntry.groupId, paramHotSortVideoEntry.storyId });
  }
  
  public void a(MyMemoriesListView.OnUIClickListener paramOnUIClickListener)
  {
    this.k = paramOnUIClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter.HotSortCardHolder
 * JD-Core Version:    0.7.0.1
 */