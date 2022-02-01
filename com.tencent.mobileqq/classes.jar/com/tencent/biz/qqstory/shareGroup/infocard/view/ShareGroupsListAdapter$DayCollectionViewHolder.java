package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.storyHome.memory.view.adapter.MemoriesInnerListAdapter;
import com.tencent.biz.qqstory.storyHome.memory.view.adapter.MemoriesInnerListAdapter.PublishVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ShareGroupsListAdapter$DayCollectionViewHolder
  extends BaseStoryTimeLineAdapter.BaseViewHolder
  implements View.OnClickListener
{
  public final ShareGroupsListAdapter b;
  public RelativeLayout c;
  public TextView d;
  public TextView e;
  public TextView f;
  public ImageView g;
  public ShareGroupInnerListView h;
  public View i;
  public View j;
  public ImageView k;
  public TextView l;
  public VideoCollectionItem m;
  public Context n;
  
  public ShareGroupsListAdapter$DayCollectionViewHolder(View paramView, ShareGroupsListAdapter paramShareGroupsListAdapter)
  {
    this.n = paramShareGroupsListAdapter.b;
    this.a = 1;
    this.c = ((RelativeLayout)paramView.findViewById(2131447345));
    this.d = ((TextView)paramView.findViewById(2131430927));
    this.e = ((TextView)paramView.findViewById(2131430929));
    this.f = ((TextView)paramView.findViewById(2131430930));
    this.g = ((ImageView)paramView.findViewById(2131438085));
    this.h = ((ShareGroupInnerListView)paramView.findViewById(2131435804));
    this.h.setSelection(0);
    AccessibilityUtil.a(this.h, false);
    this.h.setFocusable(false);
    this.b = paramShareGroupsListAdapter;
    this.h.setLoadMoreDataListener(this.b.h);
    paramShareGroupsListAdapter = (MemoriesInnerListAdapter)this.h.getAdapter();
    paramShareGroupsListAdapter.a(this.b.g.shareGroupId);
    paramShareGroupsListAdapter.a(this.b.h);
    this.i = paramView.findViewById(2131437206);
    this.j = paramView.findViewById(2131437207);
    this.k = ((ImageView)paramView.findViewById(2131440482));
    this.l = ((TextView)paramView.findViewById(2131427835));
    a();
  }
  
  protected void a()
  {
    QQStoryContext.a();
    if (!ThemeUtil.isNowThemeIsNight(QQStoryContext.k(), false, null)) {
      return;
    }
    this.g.setImageResource(2130848402);
    this.i.setBackgroundColor(Color.parseColor("#0c284e"));
    this.j.setBackgroundColor(Color.parseColor("#0c284e"));
    this.k.setBackgroundResource(2130848398);
    this.f.setTextColor(Color.parseColor("#44608a"));
    this.d.setTextColor(Color.parseColor("#6991b8"));
    this.e.setTextColor(Color.parseColor("#6991b8"));
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    this.m = paramVideoCollectionItem;
    if (TextUtils.equals(paramVideoCollectionItem.key, "local_empty_item"))
    {
      this.c.setVisibility(8);
      this.h.setVisibility(8);
      this.i.setVisibility(8);
      paramView = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
      paramView.height = Integer.valueOf(paramVideoCollectionItem.collectionId).intValue();
      this.j.setLayoutParams(paramView);
      this.j.setVisibility(0);
      return;
    }
    if (TextUtils.equals(paramVideoCollectionItem.key, "local_desc_item"))
    {
      this.c.setVisibility(8);
      this.h.setVisibility(8);
      this.i.setVisibility(8);
      this.j.setVisibility(8);
      return;
    }
    this.c.setVisibility(0);
    this.h.setVisibility(0);
    this.b.f.put(paramVideoCollectionItem.collectionId, new WeakReference(this));
    paramView = DateUtils.a(paramVideoCollectionItem.collectionTime);
    this.d.setText(paramView[1]);
    if (!TextUtils.isEmpty(paramView[0]))
    {
      this.e.setText(paramView[0]);
      this.e.setVisibility(0);
      this.d.setTextSize(1, 32.0F);
      localObject = (LinearLayout.LayoutParams)this.d.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).setMargins(0, UIUtils.a(this.n, -8.0F), 0, 0);
      this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else
    {
      this.e.setVisibility(8);
      this.d.setTextSize(1, 20.0F);
      localObject = (LinearLayout.LayoutParams)this.d.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
      this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      if ((paramInt == 3) && (TextUtils.equals(paramView[1], HardCodeUtil.a(2131911331)))) {
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, UIUtils.a(this.n, 10.0F), 0, UIUtils.a(this.n, 7.0F));
      } else {
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, UIUtils.a(this.n, 7.0F));
      }
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.h.setSelection(0);
    this.h.resetCurrentX(0);
    this.h.setData(paramVideoCollectionItem);
    Object localObject = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).leftMargin = UIUtils.a(this.n, 80.0F);
    this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if ((paramVideoCollectionItem.collectionCount <= 0) && (paramInt == 2)) {
      this.f.setText(HardCodeUtil.a(2131911338));
    } else {
      this.f.setText(this.n.getString(2131897379, new Object[] { Integer.valueOf(paramVideoCollectionItem.collectionCount) }));
    }
    localObject = this.b.g;
    if ((((ShareGroupItem)localObject).type == 2) && (((ShareGroupItem)localObject).isPublic()) && (paramVideoCollectionItem.collectionCount > 0))
    {
      this.g.setOnClickListener(this);
      this.f.setOnClickListener(this);
      this.g.setVisibility(0);
    }
    else
    {
      this.g.setVisibility(8);
    }
    if (TextUtils.isEmpty(paramVideoCollectionItem.address))
    {
      this.l.setVisibility(4);
    }
    else
    {
      paramVideoCollectionItem.address = paramVideoCollectionItem.address.replace(65292, '‧');
      this.l.setText(paramVideoCollectionItem.address);
      this.l.setVisibility(0);
    }
    this.i.setVisibility(8);
    this.j.setVisibility(0);
    paramVideoCollectionItem = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
    if (paramInt == 2) {
      paramVideoCollectionItem.height = UIUtils.a(this.n, 150.0F);
    } else if (TextUtils.equals(paramView[1], HardCodeUtil.a(2131911335))) {
      paramVideoCollectionItem.height = UIUtils.a(this.n, 172.0F);
    } else {
      paramVideoCollectionItem.height = UIUtils.a(this.n, 176.0F);
    }
    this.j.setLayoutParams(paramVideoCollectionItem);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((i1 == 2131430930) || (i1 == 2131438085)) {
      if (this.m.collectionVideoUIItemList.size() == 0)
      {
        SLog.b("Q.qqstory.shareGroup.ShareGroupsListAdapter", "no data to share");
      }
      else
      {
        Object localObject2 = null;
        DateUtils.g(this.m.collectionTime);
        i1 = this.m.collectionCount;
        Iterator localIterator = this.m.collectionVideoUIItemList.iterator();
        Object localObject1;
        do
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (VideoCollectionItem.FakeVideoUIItem)localIterator.next();
        } while ((localObject1 == null) || (MemoriesInnerListAdapter.PublishVideoItem.a((VideoCollectionItem.FakeVideoUIItem)localObject1)));
        if (localObject1 != null) {
          this.b.h.a(this.m.collectionId, this.m.collectionTime, ((VideoCollectionItem.FakeVideoUIItem)localObject1).b, i1, this.m.feedId, null);
        } else {
          SLog.b("Q.qqstory.shareGroup.ShareGroupsListAdapter", "cannot found first data to share to qq");
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter.DayCollectionViewHolder
 * JD-Core Version:    0.7.0.1
 */