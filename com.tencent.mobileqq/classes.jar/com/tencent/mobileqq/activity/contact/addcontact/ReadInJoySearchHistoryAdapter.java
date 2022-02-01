package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.List;

public class ReadInJoySearchHistoryAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  public ReadInJoySearchHistoryAdapter.OnItemClickObserver a;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  List<ReadInJoySearchHistoryEntity> jdField_a_of_type_JavaUtilList;
  
  public ReadInJoySearchHistoryAdapter(Context paramContext, List<ReadInJoySearchHistoryEntity> paramList, ReadInJoySearchHistoryAdapter.OnItemClickObserver paramOnItemClickObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactReadInJoySearchHistoryAdapter$OnItemClickObserver = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    b(paramList);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactReadInJoySearchHistoryAdapter$OnItemClickObserver = paramOnItemClickObserver;
  }
  
  private void b(List<ReadInJoySearchHistoryEntity> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (paramList.size() < 6)
      {
        this.jdField_a_of_type_JavaUtilList = paramList;
        return;
      }
      this.jdField_a_of_type_JavaUtilList = paramList.subList(0, 5);
      return;
    }
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  public void a(List<ReadInJoySearchHistoryEntity> paramList)
  {
    b(paramList);
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() != 0)) {
      return this.jdField_a_of_type_JavaUtilList.size() + 1;
    }
    return 0;
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
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null)
    {
      Object localObject2 = null;
      localObject1 = paramView;
      paramView = localObject2;
    }
    else
    {
      if (paramView == null)
      {
        paramView = LayoutInflater.from((Context)localObject1).inflate(2131559799, null);
        localObject1 = new ReadInJoySearchHistoryAdapter.ViewHolder(this);
        ((ReadInJoySearchHistoryAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368195));
        ((ReadInJoySearchHistoryAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369675));
        ((ReadInJoySearchHistoryAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131364671));
        paramView.setTag(localObject1);
        paramView.setOnClickListener(this);
      }
      else
      {
        localObject1 = (ReadInJoySearchHistoryAdapter.ViewHolder)paramView.getTag();
      }
      ((ReadInJoySearchHistoryAdapter.ViewHolder)localObject1).jdField_a_of_type_Int = paramInt;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
      {
        ((ReadInJoySearchHistoryAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        ((ReadInJoySearchHistoryAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        ((ReadInJoySearchHistoryAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((ReadInJoySearchHistoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).keyWord);
      }
      else if (paramInt == this.jdField_a_of_type_JavaUtilList.size())
      {
        ((ReadInJoySearchHistoryAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        ((ReadInJoySearchHistoryAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      localObject1 = paramView;
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof ReadInJoySearchHistoryAdapter.ViewHolder))
    {
      Object localObject = (ReadInJoySearchHistoryAdapter.ViewHolder)paramView.getTag();
      if (((ReadInJoySearchHistoryAdapter.ViewHolder)localObject).jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactReadInJoySearchHistoryAdapter$OnItemClickObserver != null)
        {
          localObject = (ReadInJoySearchHistoryEntity)this.jdField_a_of_type_JavaUtilList.get(((ReadInJoySearchHistoryAdapter.ViewHolder)localObject).jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactReadInJoySearchHistoryAdapter$OnItemClickObserver.a((ReadInJoySearchHistoryEntity)localObject);
        }
      }
      else if (((ReadInJoySearchHistoryAdapter.ViewHolder)localObject).jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactReadInJoySearchHistoryAdapter$OnItemClickObserver;
        if (localObject != null) {
          ((ReadInJoySearchHistoryAdapter.OnItemClickObserver)localObject).a();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ReadInJoySearchHistoryAdapter
 * JD-Core Version:    0.7.0.1
 */