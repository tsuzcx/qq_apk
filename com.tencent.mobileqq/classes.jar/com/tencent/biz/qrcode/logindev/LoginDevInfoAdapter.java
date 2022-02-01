package com.tencent.biz.qrcode.logindev;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class LoginDevInfoAdapter
  extends BaseAdapter
{
  private List<LoginDevItem> a = new ArrayList();
  private LoginDevInfoAdapter.OnDeviceItemClickListener b;
  
  public List<LoginDevItem> a()
  {
    return this.a;
  }
  
  public void a(LoginDevInfoAdapter.OnDeviceItemClickListener paramOnDeviceItemClickListener)
  {
    this.b = paramOnDeviceItemClickListener;
  }
  
  public void a(List<LoginDevItem> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.a.size()) {
      return this.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    LoginDevItem localLoginDevItem = (LoginDevItem)getItem(paramInt);
    Object localObject;
    if (localLoginDevItem == null)
    {
      localObject = paramView;
    }
    else
    {
      LoginDevInfoAdapter.ViewHolder localViewHolder;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626485, null);
        localViewHolder = new LoginDevInfoAdapter.ViewHolder(paramView);
        paramView.setTag(localViewHolder);
        localObject = new GradientDrawable();
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
          ((GradientDrawable)localObject).setColor(-16777216);
        } else {
          ((GradientDrawable)localObject).setColor(paramView.getResources().getColor(2131168213));
        }
        if (SimpleUIUtil.e()) {
          ((GradientDrawable)localObject).setCornerRadius(ViewUtils.dpToPx(16.0F));
        } else {
          ((GradientDrawable)localObject).setCornerRadius(ViewUtils.dpToPx(40.0F));
        }
        paramView.setBackgroundDrawable((Drawable)localObject);
      }
      else
      {
        localViewHolder = (LoginDevInfoAdapter.ViewHolder)paramView.getTag();
      }
      paramView.setOnTouchListener(new LoginDevInfoAdapter.1(this, paramView.getBackground(), localLoginDevItem));
      localViewHolder.c.setOnClickListener(new LoginDevInfoAdapter.2(this, localLoginDevItem));
      localViewHolder.b.setOnClickListener(new LoginDevInfoAdapter.3(this, localLoginDevItem));
      localObject = paramView.getContext().getString(2131914148, new Object[] { localLoginDevItem.e, localLoginDevItem.f });
      localViewHolder.d.setText((CharSequence)localObject);
      if (TextUtils.isEmpty(localLoginDevItem.g))
      {
        localViewHolder.e.setVisibility(8);
      }
      else
      {
        localObject = paramView.getContext().getString(2131914149, new Object[] { localLoginDevItem.g });
        localViewHolder.e.setText((CharSequence)localObject);
      }
      if (localLoginDevItem.c == 1)
      {
        localViewHolder.a.setImageResource(2130848816);
        localViewHolder.b.setVisibility(0);
        localObject = paramView;
      }
      else if (localLoginDevItem.c == 2)
      {
        localViewHolder.a.setImageResource(2130848815);
        localViewHolder.b.setVisibility(0);
        localObject = paramView;
      }
      else
      {
        localObject = paramView;
        if (localLoginDevItem.c == 3)
        {
          localViewHolder.a.setImageResource(2130848817);
          localViewHolder.b.setVisibility(8);
          localObject = paramView;
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.logindev.LoginDevInfoAdapter
 * JD-Core Version:    0.7.0.1
 */