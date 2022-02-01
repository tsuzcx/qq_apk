package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchHistoryAdapter
  extends BaseAdapter
{
  private static final String jdField_a_of_type_JavaLangString = "SearchHistoryAdapter";
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  private List<HistoryItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public SearchHistoryAdapter(Context paramContext, MqqWeakReferenceHandler paramMqqWeakReferenceHandler, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = paramMqqWeakReferenceHandler;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadHistory, keyword = ");
      localStringBuilder.append(paramString);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramString == null) {
      return;
    }
    Object localObject = HistoryChatMsgSearchKeyUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_JavaUtilList.clear();
    if (localObject != null)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder = localObject[i];
        if (a(localStringBuilder, paramString)) {
          this.jdField_a_of_type_JavaUtilList.add(new HistoryItem(localStringBuilder));
        }
        i += 1;
      }
    }
    notifyDataSetChanged();
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadHistory, keyword = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", histories = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.toString());
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(3);
  }
  
  boolean a(String paramString1, String paramString2)
  {
    return paramString1.toLowerCase(Locale.US).contains(paramString2.toLowerCase(Locale.US));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    HistoryItem localHistoryItem = (HistoryItem)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559334, null);
      paramView = new SearchHistoryAdapter.HistoryHolder(null);
      paramView.a = ((TextView)localView.findViewById(2131378460));
      localView.setTag(paramView);
    }
    else
    {
      SearchHistoryAdapter.HistoryHolder localHistoryHolder = (SearchHistoryAdapter.HistoryHolder)paramView.getTag();
      localView = paramView;
      paramView = localHistoryHolder;
    }
    paramView.a.setText(localHistoryItem.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.SearchHistoryAdapter
 * JD-Core Version:    0.7.0.1
 */