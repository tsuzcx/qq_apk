package com.tencent.mobileqq.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.fragment.AppletsSettingFragment.OnChangeSwitchListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.List;

public class AppletsListAdapter
  extends BaseAdapter
{
  protected QQAppInterface a;
  protected List<Object> b;
  private LayoutInflater c;
  private Activity d;
  private Drawable e;
  private AppletsSettingFragment.OnChangeSwitchListener f;
  private CompoundButton.OnCheckedChangeListener g = new AppletsListAdapter.1(this);
  
  public AppletsListAdapter(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, AppletsSettingFragment.OnChangeSwitchListener paramOnChangeSwitchListener)
  {
    this.a = paramQQAppInterface;
    this.c = ((LayoutInflater)paramBaseActivity.getSystemService("layout_inflater"));
    this.b = new ArrayList();
    this.d = paramBaseActivity;
    this.e = paramBaseActivity.getResources().getDrawable(2130846957);
    this.f = paramOnChangeSwitchListener;
  }
  
  public void a(List<AppletItem> paramList)
  {
    this.b.clear();
    if (paramList != null) {
      this.b.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.b.size();
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
    Object localObject1 = (AppletItem)getItem(paramInt);
    if (localObject1 != null)
    {
      boolean bool = false;
      AppletsListAdapter.ViewHolder localViewHolder;
      if (paramView == null)
      {
        localViewHolder = new AppletsListAdapter.ViewHolder();
        paramView = this.c.inflate(2131627789, paramViewGroup, false);
        localViewHolder.b = ((RelativeLayout)paramView.findViewById(2131428668));
        localViewHolder.c = ((URLImageView)paramView.findViewById(2131428667));
        localViewHolder.d = ((TextView)paramView.findViewById(2131428669));
        localViewHolder.e = ((Switch)paramView.findViewById(2131428670));
        paramView.setTag(localViewHolder);
      }
      else
      {
        localViewHolder = (AppletsListAdapter.ViewHolder)paramView.getTag();
      }
      localViewHolder.b.setBackgroundResource(2130839622);
      Object localObject2 = localViewHolder.e;
      if (((AppletItem)localObject1).e() == 1) {
        bool = true;
      }
      ((Switch)localObject2).setChecked(bool);
      localViewHolder.e.setOnCheckedChangeListener(this.g);
      localViewHolder.e.setTag(Integer.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("AppletsListAdapter", 2, ((AppletItem)localObject1).toString());
      }
      localViewHolder.d.setText(((AppletItem)localObject1).b());
      localViewHolder.a = ((AppletItem)localObject1);
      if (!TextUtils.isEmpty(((AppletItem)localObject1).c()))
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = AIOUtils.b(localViewHolder.c.getMeasuredWidth(), this.d.getResources());
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth;
        Drawable localDrawable = this.e;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
        localObject1 = URLDrawable.getDrawable(((AppletItem)localObject1).c(), (URLDrawable.URLDrawableOptions)localObject2);
        localViewHolder.c.setImageDrawable((Drawable)localObject1);
      }
      else
      {
        localViewHolder.c.setImageDrawable(this.e);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AppletsListAdapter
 * JD-Core Version:    0.7.0.1
 */