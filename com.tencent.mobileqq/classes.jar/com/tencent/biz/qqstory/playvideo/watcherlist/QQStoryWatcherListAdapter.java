package com.tencent.biz.qqstory.playvideo.watcherlist;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class QQStoryWatcherListAdapter
  extends BaseAdapter
{
  View.OnTouchListener a;
  protected Context b;
  protected QQStoryContext c = null;
  protected List<QQUserUIItem> d;
  protected int e = -1;
  protected ChildViewClickListener f = null;
  
  public QQStoryWatcherListAdapter(Context paramContext, View.OnTouchListener paramOnTouchListener)
  {
    this.b = paramContext;
    this.c = QQStoryContext.a();
    this.d = new ArrayList();
    this.a = paramOnTouchListener;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(ChildViewClickListener paramChildViewClickListener)
  {
    this.f = paramChildViewClickListener;
  }
  
  public void a(List<QQUserUIItem> paramList)
  {
    this.d = paramList;
    super.notifyDataSetChanged();
  }
  
  public void b(List<QQUserUIItem> paramList)
  {
    this.d.addAll(paramList);
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.d.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.d.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      localObject1 = LayoutInflater.from(this.b);
      int j = this.e;
      int i = j;
      if (j == -1) {
        i = 2131628213;
      }
      localObject1 = new BaseViewHolder(((LayoutInflater)localObject1).inflate(i, null));
    }
    else
    {
      localObject1 = (BaseViewHolder)paramView.getTag();
    }
    Object localObject2 = (QQUserUIItem)this.d.get(paramInt);
    Object localObject3 = (TextView)((BaseViewHolder)localObject1).a(2131439320);
    String str = ((QQUserUIItem)localObject2).getUserIconUrl();
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fillFriendsData userIconUrl = ");
        localStringBuilder.append(str);
        QLog.w("zivonchen", 2, localStringBuilder.toString());
      }
      PlayModeUtils.a(this.b.getResources(), (TextView)localObject3, str, 13.0F, 2.0F);
    }
    else
    {
      ((TextView)localObject3).setCompoundDrawablePadding(0);
      ((TextView)localObject3).setCompoundDrawables(null, null, null, null);
    }
    ((TextView)localObject3).setText(PlayModeUtils.a((QQUserUIItem)localObject2));
    localObject3 = (ImageView)((BaseViewHolder)localObject1).a(2131434940);
    if ((((QQUserUIItem)localObject2).isVip) && (HttpUtil.isValidUrl(((QQUserUIItem)localObject2).headUrl))) {
      UIUtils.a((ImageView)localObject3, ((QQUserUIItem)localObject2).headUrl, 38, 38, 1);
    } else if (!TextUtils.isEmpty(((QQUserUIItem)localObject2).qq)) {
      PlayModeUtils.a((ImageView)localObject3, ((QQUserUIItem)localObject2).qq);
    } else {
      ((ImageView)localObject3).setImageDrawable(ImageUtil.m());
    }
    ((BaseViewHolder)localObject1).h = localObject2;
    if (this.a != null) {
      ((BaseViewHolder)localObject1).a().setOnTouchListener(this.a);
    }
    ((BaseViewHolder)localObject1).a().setOnClickListener((View.OnClickListener)localObject1);
    localObject2 = this.f;
    if (localObject2 != null) {
      ((BaseViewHolder)localObject1).a((ChildViewClickListener)localObject2);
    }
    Object localObject1 = ((BaseViewHolder)localObject1).a();
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.watcherlist.QQStoryWatcherListAdapter
 * JD-Core Version:    0.7.0.1
 */