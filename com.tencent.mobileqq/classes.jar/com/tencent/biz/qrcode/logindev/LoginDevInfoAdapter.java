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
  private LoginDevInfoAdapter.OnDeviceItemClickListener jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevInfoAdapter$OnDeviceItemClickListener;
  private List<LoginDevItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public List<LoginDevItem> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(LoginDevInfoAdapter.OnDeviceItemClickListener paramOnDeviceItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevInfoAdapter$OnDeviceItemClickListener = paramOnDeviceItemClickListener;
  }
  
  public void a(List<LoginDevItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560440, null);
        localViewHolder = new LoginDevInfoAdapter.ViewHolder(paramView);
        paramView.setTag(localViewHolder);
        localObject = new GradientDrawable();
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
          ((GradientDrawable)localObject).setColor(-16777216);
        } else {
          ((GradientDrawable)localObject).setColor(paramView.getResources().getColor(2131167223));
        }
        if (SimpleUIUtil.a()) {
          ((GradientDrawable)localObject).setCornerRadius(ViewUtils.b(16.0F));
        } else {
          ((GradientDrawable)localObject).setCornerRadius(ViewUtils.b(40.0F));
        }
        paramView.setBackgroundDrawable((Drawable)localObject);
      }
      else
      {
        localViewHolder = (LoginDevInfoAdapter.ViewHolder)paramView.getTag();
      }
      paramView.setOnTouchListener(new LoginDevInfoAdapter.1(this, paramView.getBackground(), localLoginDevItem));
      localViewHolder.c.setOnClickListener(new LoginDevInfoAdapter.2(this, localLoginDevItem));
      localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new LoginDevInfoAdapter.3(this, localLoginDevItem));
      localObject = paramView.getContext().getString(2131716684, new Object[] { localLoginDevItem.a, localLoginDevItem.jdField_b_of_type_JavaLangString });
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (TextUtils.isEmpty(localLoginDevItem.c))
      {
        localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else
      {
        localObject = paramView.getContext().getString(2131716685, new Object[] { localLoginDevItem.c });
        localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      if (localLoginDevItem.jdField_b_of_type_Int == 1)
      {
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847231);
        localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = paramView;
      }
      else if (localLoginDevItem.jdField_b_of_type_Int == 2)
      {
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847230);
        localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = paramView;
      }
      else
      {
        localObject = paramView;
        if (localLoginDevItem.jdField_b_of_type_Int == 3)
        {
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847232);
          localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
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