package com.tencent.mobileqq.activity.selectmember;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import tencent.im.nearfield_discuss.nearfield_discuss.UserProfile;

class CreateFaceToFaceDiscussionActivity$GridViewAdapter
  extends BaseAdapter
{
  LayoutInflater a;
  CreateFaceToFaceDiscussionActivity.ViewHolder b;
  
  public CreateFaceToFaceDiscussionActivity$GridViewAdapter(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity)
  {
    this.a = LayoutInflater.from(paramCreateFaceToFaceDiscussionActivity.mContext);
  }
  
  public int getCount()
  {
    if (this.c.mMemberList == null) {
      return 0;
    }
    if (this.c.mMemberList.size() < 50) {
      return this.c.mMemberList.size() + 1;
    }
    return this.c.mMemberList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.c.mMemberList == null) {
      return null;
    }
    return this.c.mMemberList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.a.inflate(2131627455, null);
      this.b = new CreateFaceToFaceDiscussionActivity.ViewHolder(this.c);
      this.b.b = ((ImageView)paramView.findViewById(2131435219));
      this.b.c = ((TextView)paramView.findViewById(2131439121));
      paramView.setTag(this.b);
    }
    else
    {
      this.b = ((CreateFaceToFaceDiscussionActivity.ViewHolder)paramView.getTag());
      if (this.b.d)
      {
        paramView = this.a.inflate(2131627455, null);
        this.b = new CreateFaceToFaceDiscussionActivity.ViewHolder(this.c);
        this.b.b = ((ImageView)paramView.findViewById(2131435219));
        this.b.c = ((TextView)paramView.findViewById(2131439121));
        paramView.setTag(this.b);
        this.b.d = false;
      }
    }
    if ((paramInt == getCount() - 1) && (getCount() < 50))
    {
      CreateFaceToFaceDiscussionActivity.access$500(this.c, paramView);
    }
    else
    {
      CreateFaceToFaceDiscussionActivity localCreateFaceToFaceDiscussionActivity = this.c;
      CreateFaceToFaceDiscussionActivity.access$600(localCreateFaceToFaceDiscussionActivity, paramView, (nearfield_discuss.UserProfile)localCreateFaceToFaceDiscussionActivity.mMemberList.get(paramInt));
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity.GridViewAdapter
 * JD-Core Version:    0.7.0.1
 */