package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CustomImgView;
import java.util.ArrayList;
import java.util.List;

public class SayHelloBoxItemBuilder$MsgHeaderAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private List<MessageRecord> jdField_a_of_type_JavaUtilList;
  private int b;
  
  public SayHelloBoxItemBuilder$MsgHeaderAdapter(SayHelloBoxItemBuilder paramSayHelloBoxItemBuilder, Context paramContext, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    int j = this.jdField_a_of_type_Int;
    if (i > j) {
      return j;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    if ((paramInt > 0) && (paramInt < i)) {
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
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561040, null);
      int i = this.b;
      localView.setLayoutParams(new AbsListView.LayoutParams(i, i));
    }
    paramView = (CustomImgView)localView;
    MessageRecord localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if ((localMessageRecord != null) && (!TextUtils.isEmpty(localMessageRecord.senderuin)))
    {
      paramView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityRecentSayHelloBoxItemBuilder.a.a(localMessageRecord.istroop, localMessageRecord.senderuin));
      localView.setTag(-1, localMessageRecord.senderuin);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.SayHelloBoxItemBuilder.MsgHeaderAdapter
 * JD-Core Version:    0.7.0.1
 */