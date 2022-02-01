package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.troopmemberlist.IFacePreloadBaseAdapter;
import com.tencent.mobileqq.troop.api.troopmemberlist.IFacePreloadBaseAdapterProxy;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.memberlist.AddFrdHelper;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.widget.TroopMemberListSlideItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class TroopMemberListActivity$SearchResultAdapter
  extends BaseAdapter
  implements IFacePreloadBaseAdapter
{
  public List<TroopMemberListActivity.ATroopMember> a;
  private IFacePreloadBaseAdapterProxy c;
  
  public TroopMemberListActivity$SearchResultAdapter(List<TroopMemberListActivity.ATroopMember> paramList)
  {
    this.c = ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).getFacePreloadBaseAdapterProxy(this, paramList, paramList.app, paramList.searchList, 1, true);
    Object localObject;
    this.a = localObject;
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    return this.c.a(paramInt, paramString);
  }
  
  public void a()
  {
    this.c.c();
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
    if (TroopMemberListActivity.access$2500(this.b))
    {
      TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)this.a.get(paramInt);
      if ((TextUtils.isEmpty(localATroopMember.n)) && (!TextUtils.isEmpty(localATroopMember.q)) && (!TextUtils.isEmpty(localATroopMember.h)) && (!localATroopMember.h.equals(localATroopMember.q))) {
        return 1;
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    TroopMemberListActivity.TmViewHolder localTmViewHolder;
    if (paramView == null)
    {
      if (i == 0)
      {
        paramView = this.b.mLayoutInflater.inflate(2131629583, paramViewGroup, false);
        localTmViewHolder = new TroopMemberListActivity.TmViewHolder(paramView, false);
      }
      else
      {
        paramView = this.b.mLayoutInflater.inflate(2131629587, paramViewGroup, false);
        localTmViewHolder = new TroopMemberListActivity.TmViewHolder(paramView, true);
      }
      paramView.setTag(localTmViewHolder);
    }
    else
    {
      localTmViewHolder = (TroopMemberListActivity.TmViewHolder)paramView.getTag();
    }
    TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)this.a.get(paramInt);
    localTmViewHolder.o.setTag(localATroopMember.a);
    localTmViewHolder.f.setTag(localATroopMember.a);
    localTmViewHolder.d.setTag(localATroopMember.a);
    localTmViewHolder.c.setTag(Integer.valueOf(paramInt));
    TroopMemberListActivity localTroopMemberListActivity = this.b;
    Bitmap localBitmap = a(1, localATroopMember.a);
    boolean bool;
    if (i == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localTroopMemberListActivity.setItemViewValue(localTmViewHolder, localATroopMember, localBitmap, true, bool);
    if (this.b.mFrom == 12) {
      if (this.b.mAdapter.d.contains(localATroopMember)) {
        localTmViewHolder.t.setVisibility(0);
      } else {
        localTmViewHolder.t.setVisibility(8);
      }
    }
    if (this.b.mAddFrdHelper != null)
    {
      this.b.mAddFrdHelper.a(localTmViewHolder, localATroopMember);
      if (localTmViewHolder.w.getVisibility() == 0)
      {
        i = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getMaxWidthForNameInTroopMemberListActivity(2);
        localTmViewHolder.l.setMaxWidth(i);
        TroopMemberListActivity.access$2600(this.b.app, localTmViewHolder.l, localTmViewHolder.n, localATroopMember.a, i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */