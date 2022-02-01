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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
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
    Object localObject1;
    if (localLoginDevItem == null)
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    Object localObject2;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560550, null);
      localObject1 = new LoginDevInfoAdapter.ViewHolder(paramView);
      paramView.setTag(localObject1);
      localObject2 = new GradientDrawable();
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        ((GradientDrawable)localObject2).setColor(-16777216);
        label97:
        if (!SimpleUIUtil.a()) {
          break label287;
        }
        ((GradientDrawable)localObject2).setCornerRadius(ViewUtils.b(16.0F));
        label114:
        paramView.setBackgroundDrawable((Drawable)localObject2);
        label120:
        paramView.setOnTouchListener(new LoginDevInfoAdapter.1(this, paramView.getBackground(), localLoginDevItem));
        ((LoginDevInfoAdapter.ViewHolder)localObject1).c.setOnClickListener(new LoginDevInfoAdapter.2(this, localLoginDevItem));
        ((LoginDevInfoAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new LoginDevInfoAdapter.3(this, localLoginDevItem));
        localObject2 = paramView.getContext().getString(2131717031, new Object[] { localLoginDevItem.a, localLoginDevItem.jdField_b_of_type_JavaLangString });
        ((LoginDevInfoAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if (!TextUtils.isEmpty(localLoginDevItem.c)) {
          break label313;
        }
        ((LoginDevInfoAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        label236:
        if (localLoginDevItem.jdField_b_of_type_Int != 1) {
          break label349;
        }
        ((LoginDevInfoAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847362);
        ((LoginDevInfoAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      localObject1 = paramView;
      break;
      ((GradientDrawable)localObject2).setColor(paramView.getResources().getColor(2131167198));
      break label97;
      label287:
      ((GradientDrawable)localObject2).setCornerRadius(ViewUtils.b(40.0F));
      break label114;
      localObject1 = (LoginDevInfoAdapter.ViewHolder)paramView.getTag();
      break label120;
      label313:
      localObject2 = paramView.getContext().getString(2131717032, new Object[] { localLoginDevItem.c });
      ((LoginDevInfoAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      break label236;
      label349:
      if (localLoginDevItem.jdField_b_of_type_Int == 2)
      {
        ((LoginDevInfoAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847361);
        ((LoginDevInfoAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      else if (localLoginDevItem.jdField_b_of_type_Int == 3)
      {
        ((LoginDevInfoAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847363);
        ((LoginDevInfoAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.logindev.LoginDevInfoAdapter
 * JD-Core Version:    0.7.0.1
 */