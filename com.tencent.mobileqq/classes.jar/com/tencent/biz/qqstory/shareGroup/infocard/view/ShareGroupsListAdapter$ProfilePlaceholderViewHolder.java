package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.shareGroup.ShareGroupUtil;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class ShareGroupsListAdapter$ProfilePlaceholderViewHolder
  extends BaseStoryTimeLineAdapter.BaseViewHolder
  implements View.OnClickListener
{
  final TextView b;
  final Button c;
  final ImageView d;
  final TextView e;
  final ImageView f;
  final LinearLayout g;
  final ShareGroupsListAdapter h;
  List<QQUserUIItem> i = new ArrayList();
  
  public ShareGroupsListAdapter$ProfilePlaceholderViewHolder(View paramView, ShareGroupsListAdapter paramShareGroupsListAdapter)
  {
    this.a = 2;
    this.h = paramShareGroupsListAdapter;
    this.e = ((TextView)paramView.findViewById(2131447188));
    this.b = ((TextView)paramView.findViewById(2131447218));
    this.d = ((ImageView)paramView.findViewById(2131440657));
    this.c = ((Button)paramView.findViewById(2131446570));
    this.g = ((LinearLayout)paramView.findViewById(2131438063));
    this.f = ((ImageView)paramView.findViewById(2131435406));
    this.c.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void a(List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.i.clear();
      Object localObject1 = (UserManager)SuperManager.a(2);
      Object localObject2 = new ArrayList();
      int k = Math.min(paramList.size(), 6);
      int j = 0;
      while (j < k)
      {
        String str = (String)paramList.get(j);
        QQUserUIItem localQQUserUIItem = ((UserManager)localObject1).b(str);
        if ((localQQUserUIItem != null) && (!TextUtils.isEmpty(localQQUserUIItem.headUrl))) {
          this.i.add(localQQUserUIItem);
        } else {
          ((List)localObject2).add(new QQUserUIItem.UserID("", str));
        }
        j += 1;
      }
      if (!((List)localObject2).isEmpty()) {
        new GetUserInfoHandler(1, (List)localObject2).a();
      }
      this.g.removeAllViews();
      int m = this.i.size();
      k = 0;
      while (k < m)
      {
        if (k == 0) {
          j = -1;
        } else if (k == m - 1) {
          j = 1;
        } else {
          j = 0;
        }
        paramList = this.h.b;
        localObject1 = this.g;
        localObject2 = (QQUserUIItem)this.i.get(k);
        int n = this.h.g.memberCount;
        boolean bool;
        if (this.h.g.memberCount > 6) {
          bool = true;
        } else {
          bool = false;
        }
        ShareGroupUtil.a(paramList, (LinearLayout)localObject1, 34, (QQUserUIItem)localObject2, j, n, bool);
        k += 1;
      }
    }
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    if (this.h.g == null) {
      return;
    }
    paramView = this.h.g;
    this.e.setText(paramView.name);
    if (paramView.type == 1)
    {
      paramVideoCollectionItem = HardCodeUtil.a(2131911340);
      this.d.setImageResource(2130848590);
      this.c.setVisibility(8);
    }
    else
    {
      paramVideoCollectionItem = null;
    }
    if (!TextUtils.isEmpty(paramView.backgroundUrl)) {
      UIUtils.a(this.f, paramView.backgroundUrl, 0, 0, null);
    }
    if (paramView.headerUnionIdList != null) {
      paramView.memberCount = Math.max(paramView.headerUnionIdList.size(), paramView.memberCount);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramVideoCollectionItem);
    localStringBuilder.append(" · ");
    localStringBuilder.append(paramView.memberCount);
    localStringBuilder.append(HardCodeUtil.a(2131911342));
    paramVideoCollectionItem = localStringBuilder.toString();
    this.b.setText(paramVideoCollectionItem);
    a(paramView.headerUnionIdList);
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j != 2131438063)
    {
      if (j != 2131446570)
      {
        if (j == 2131447188) {
          this.h.h.b(this.g);
        }
      }
      else {
        this.h.h.a(this.c);
      }
    }
    else {
      this.h.h.b(this.g);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter.ProfilePlaceholderViewHolder
 * JD-Core Version:    0.7.0.1
 */