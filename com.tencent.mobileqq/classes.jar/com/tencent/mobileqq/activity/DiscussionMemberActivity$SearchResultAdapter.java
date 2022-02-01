package com.tencent.mobileqq.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class DiscussionMemberActivity$SearchResultAdapter
  extends FacePreloadBaseAdapter
{
  private List<DiscussionMemberActivity.DiscussionMember> b;
  
  public DiscussionMemberActivity$SearchResultAdapter(List<DiscussionMemberActivity.DiscussionMember> paramList)
  {
    super(paramList, paramList.app, paramList.f, 1, true);
    Object localObject;
    this.b = localObject;
  }
  
  public int getCount()
  {
    List localList = this.b;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return this.b.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.a.getLayoutInflater().inflate(2131624729, paramViewGroup, false);
      paramView = new DiscussionMemberActivity.SearchViewHolder(null);
      paramView.A = ((ImageView)localView.findViewById(2131436404));
      paramView.a = ((TextView)localView.findViewById(2131448598));
      localView.setTag(paramView);
    }
    else
    {
      localObject = (DiscussionMemberActivity.SearchViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = (DiscussionMemberActivity.DiscussionMember)getItem(paramInt);
    if (localObject != null)
    {
      if ((((DiscussionMemberActivity.DiscussionMember)localObject).b != null) && (!"".equals(((DiscussionMemberActivity.DiscussionMember)localObject).b.trim()))) {
        paramView.a.setText(((DiscussionMemberActivity.DiscussionMember)localObject).b);
      } else {
        paramView.a.setText(((DiscussionMemberActivity.DiscussionMember)localObject).a);
      }
      paramView.y = ((DiscussionMemberActivity.DiscussionMember)localObject).a;
      paramView.A.setImageBitmap(a(1, ((DiscussionMemberActivity.DiscussionMember)localObject).a));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */