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
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new AppletsListAdapter.1(this);
  protected QQAppInterface a;
  private AppletsSettingFragment.OnChangeSwitchListener jdField_a_of_type_ComTencentMobileqqFragmentAppletsSettingFragment$OnChangeSwitchListener;
  protected List<Object> a;
  
  public AppletsListAdapter(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, AppletsSettingFragment.OnChangeSwitchListener paramOnChangeSwitchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramBaseActivity.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidAppActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramBaseActivity.getResources().getDrawable(2130845494);
    this.jdField_a_of_type_ComTencentMobileqqFragmentAppletsSettingFragment$OnChangeSwitchListener = paramOnChangeSwitchListener;
  }
  
  public void a(List<AppletItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561433, paramViewGroup, false);
        localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362870));
        localViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131362869));
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362871));
        localViewHolder.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)paramView.findViewById(2131362872));
        paramView.setTag(localViewHolder);
      }
      else
      {
        localViewHolder = (AppletsListAdapter.ViewHolder)paramView.getTag();
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839433);
      Object localObject2 = localViewHolder.jdField_a_of_type_ComTencentWidgetSwitch;
      if (((AppletItem)localObject1).b() == 1) {
        bool = true;
      }
      ((Switch)localObject2).setChecked(bool);
      localViewHolder.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      localViewHolder.jdField_a_of_type_ComTencentWidgetSwitch.setTag(Integer.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("AppletsListAdapter", 2, ((AppletItem)localObject1).toString());
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((AppletItem)localObject1).a());
      localViewHolder.jdField_a_of_type_ComTencentMobileqqAppletsDataAppletItem = ((AppletItem)localObject1);
      if (!TextUtils.isEmpty(((AppletItem)localObject1).b()))
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = AIOUtils.b(localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.getMeasuredWidth(), this.jdField_a_of_type_AndroidAppActivity.getResources());
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth;
        Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
        localObject1 = URLDrawable.getDrawable(((AppletItem)localObject1).b(), (URLDrawable.URLDrawableOptions)localObject2);
        localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      }
      else
      {
        localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AppletsListAdapter
 * JD-Core Version:    0.7.0.1
 */