package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SearchWordHistoryManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class SearchWordHistoryAdapter
  extends BaseAdapter
{
  protected int a;
  protected Context a;
  protected View a;
  protected QQAppInterface a;
  protected SearchWordHistoryManager a;
  public List<String> a;
  
  public SearchWordHistoryAdapter(Context paramContext, QQAppInterface paramQQAppInterface, View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppSearchWordHistoryManager = ((SearchWordHistoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SEARCH_WORD_HISTORY_MANAGER));
  }
  
  public String a(int paramInt)
  {
    return (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppSearchWordHistoryManager.a();
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    } else {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
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
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559808, paramViewGroup, false);
      paramView = new SearchWordHistoryAdapter.ViewHolder(this);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368193));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368194));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView = ((PressEffectImageView)localView.findViewById(2131376671));
      paramView.b = localView.findViewById(2131365776);
      paramView.jdField_a_of_type_AndroidViewView = localView;
      localView.setTag(paramView);
    }
    else
    {
      SearchWordHistoryAdapter.ViewHolder localViewHolder = (SearchWordHistoryAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localViewHolder;
    }
    paramView.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#6991B8"));
      paramView.b.setBackgroundColor(Color.parseColor("#040E1C"));
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846215);
      paramView.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839385);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView.setImageResource(2130846213);
    }
    else
    {
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4D4D4D"));
      paramView.b.setBackgroundColor(Color.parseColor("#E6E6E6"));
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846214);
      paramView.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839384);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView.setImageResource(2130846212);
    }
    localView.setOnClickListener(paramView);
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView.setOnClickListener(paramView);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SearchWordHistoryAdapter
 * JD-Core Version:    0.7.0.1
 */