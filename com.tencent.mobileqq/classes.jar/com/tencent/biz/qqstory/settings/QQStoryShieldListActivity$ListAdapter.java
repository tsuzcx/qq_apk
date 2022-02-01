package com.tencent.biz.qqstory.settings;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class QQStoryShieldListActivity$ListAdapter
  extends BaseAdapter
{
  List<QQStoryUserInfo> a = new ArrayList();
  
  public QQStoryShieldListActivity$ListAdapter(List<QQStoryUserInfo> paramList)
  {
    Collection localCollection;
    if (localCollection != null)
    {
      this.a = new ArrayList(localCollection);
      Collections.sort(this.a);
    }
  }
  
  public void a(List<QQStoryUserInfo> paramList)
  {
    this.a = new ArrayList(paramList);
    paramList = this.a;
    if (paramList != null) {
      Collections.sort(paramList);
    }
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
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
      localView = LayoutInflater.from(this.b).inflate(2131628151, null);
      paramView = new QQStoryShieldListActivity.ListAdapter.ViewHolder(this);
      paramView.b = ((ImageView)localView.findViewById(2131432714));
      paramView.c = ((TextView)localView.findViewById(2131439121));
      paramView.c.setMaxWidth(this.b.l.widthPixels - AIOUtils.b(175.0F, this.b.getResources()));
      paramView.d = ((Button)localView.findViewById(2131431715));
      paramView.d.setOnClickListener(this.b);
      localView.setTag(paramView);
    }
    else
    {
      localObject = (QQStoryShieldListActivity.ListAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = (QQStoryUserInfo)this.a.get(paramInt);
    paramView.a = ((QQStoryUserInfo)localObject).uin;
    paramView.c.setText(((QQStoryUserInfo)localObject).nick);
    paramView.d.setTag(localObject);
    if (this.a.size() > 2)
    {
      if (paramInt == 0) {
        localView.setBackgroundResource(2130839638);
      } else if (paramInt == this.a.size() - 1) {
        localView.setBackgroundResource(2130839629);
      } else {
        localView.setBackgroundResource(2130839632);
      }
    }
    else if (this.a.size() == 2)
    {
      if (paramInt == 0) {
        localView.setBackgroundResource(2130839638);
      } else {
        localView.setBackgroundResource(2130839629);
      }
    }
    else if (this.a.size() == 1) {
      localView.setBackgroundResource(2130839629);
    }
    localObject = this.b.app.getFaceBitmap(((QQStoryUserInfo)localObject).uin, true);
    if (localObject != null) {
      paramView.b.setImageBitmap((Bitmap)localObject);
    } else {
      paramView.b.setImageBitmap(ImageUtil.k());
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity.ListAdapter
 * JD-Core Version:    0.7.0.1
 */