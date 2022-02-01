package com.tencent.mobileqq.activity.history;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.helper.TroopMemberAddFrdHelper;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.widget.TroopMemberListSlideItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ChatHistoryTroopMemberFragment$SearchResultAdapter
  extends FacePreloadBaseAdapter
{
  public List<ChatHistoryTroopMemberFragment.ATroopMember> a;
  
  public ChatHistoryTroopMemberFragment$SearchResultAdapter(List<ChatHistoryTroopMemberFragment.ATroopMember> paramList)
  {
    super(paramList.getBaseActivity(), paramList.bc, paramList.ab, 1, true);
    Object localObject;
    this.a = localObject;
  }
  
  public int getCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return this.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (ChatHistoryTroopMemberFragment.r(this.b))
    {
      ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)this.a.get(paramInt);
      if ((TextUtils.isEmpty(localATroopMember.n)) && (!TextUtils.isEmpty(localATroopMember.r)) && (!TextUtils.isEmpty(localATroopMember.h)) && (!localATroopMember.h.equals(localATroopMember.r))) {
        return 1;
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    ChatHistoryTroopMemberFragment.TmViewHolder localTmViewHolder;
    if (paramView == null)
    {
      if (i == 0)
      {
        paramView = this.b.al.inflate(2131629583, paramViewGroup, false);
        localTmViewHolder = new ChatHistoryTroopMemberFragment.TmViewHolder(paramView, false);
      }
      else
      {
        paramView = this.b.al.inflate(2131629587, paramViewGroup, false);
        localTmViewHolder = new ChatHistoryTroopMemberFragment.TmViewHolder(paramView, true);
      }
      paramView.setTag(localTmViewHolder);
    }
    else
    {
      localTmViewHolder = (ChatHistoryTroopMemberFragment.TmViewHolder)paramView.getTag();
    }
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)this.a.get(paramInt);
    localTmViewHolder.m.setTag(localATroopMember.a);
    localTmViewHolder.f.setTag(localATroopMember.a);
    localTmViewHolder.d.setTag(localATroopMember.a);
    localTmViewHolder.c.setTag(Integer.valueOf(paramInt));
    ChatHistoryTroopMemberFragment localChatHistoryTroopMemberFragment = this.b;
    Bitmap localBitmap = a(1, localATroopMember.a);
    boolean bool;
    if (i == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localChatHistoryTroopMemberFragment.a(localTmViewHolder, localATroopMember, localBitmap, true, bool);
    if (this.b.az == 12) {
      if (this.b.K.d.contains(localATroopMember)) {
        localTmViewHolder.r.setVisibility(0);
      } else {
        localTmViewHolder.r.setVisibility(8);
      }
    }
    if (this.b.ba != null)
    {
      this.b.ba.a(localTmViewHolder, localATroopMember);
      if (localTmViewHolder.u.getVisibility() == 0)
      {
        i = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getMaxWidthForNameInTroopMemberListActivity(2);
        localTmViewHolder.j.setMaxWidth(i);
        ChatHistoryTroopMemberFragment.a(this.b.bc, localTmViewHolder.j, localTmViewHolder.l, localATroopMember.a, i);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */