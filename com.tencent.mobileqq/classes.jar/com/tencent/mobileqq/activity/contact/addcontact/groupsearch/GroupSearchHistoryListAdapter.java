package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.ui.dialog.DisplayHelper;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class GroupSearchHistoryListAdapter
  extends BaseAdapter
{
  protected Context a;
  protected View a;
  private GroupSearchHistoryListAdapter.OnItemClickListener jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchHistoryListAdapter$OnItemClickListener;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList;
  
  public GroupSearchHistoryListAdapter(Context paramContext, View paramView, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = GroupSearchHistoryManager.a().a(paramString);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private boolean a(List<String> paramList1, List<String> paramList2)
  {
    if ((paramList1 == null) && (paramList2 == null)) {
      return true;
    }
    if ((paramList1 == null) || (paramList2 == null) || (paramList1.size() != paramList2.size())) {
      return false;
    }
    return paramList1.equals(paramList2);
  }
  
  public String a(int paramInt)
  {
    return (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    ArrayList localArrayList = GroupSearchHistoryManager.a().a(this.jdField_a_of_type_JavaLangString);
    if (a(this.jdField_a_of_type_JavaUtilList, localArrayList)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = localArrayList;
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void a(GroupSearchHistoryListAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchHistoryListAdapter$OnItemClickListener = paramOnItemClickListener;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559938, paramViewGroup, false);
      paramView = new GroupSearchHistoryListAdapter.ViewHolder(this);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368443));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368444));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView = ((PressEffectImageView)localView.findViewById(2131377211));
      paramView.b = localView.findViewById(2131365939);
      paramView.jdField_a_of_type_AndroidViewView = localView;
      localObject = (LinearLayout.LayoutParams)paramView.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayHelper.dp2px(this.jdField_a_of_type_AndroidContentContext, 16);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localView.setTag(paramView);
      paramView.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_JavaUtilList != null) {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      }
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label273;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846550);
      paramView.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839529);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView.setImageResource(2130846549);
    }
    for (;;)
    {
      paramView.b.setVisibility(8);
      localView.setOnClickListener(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView.setOnClickListener(paramView);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (GroupSearchHistoryListAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label273:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4D4D4D"));
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846341);
      paramView.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839528);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView.setImageResource(2130846339);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchHistoryListAdapter
 * JD-Core Version:    0.7.0.1
 */