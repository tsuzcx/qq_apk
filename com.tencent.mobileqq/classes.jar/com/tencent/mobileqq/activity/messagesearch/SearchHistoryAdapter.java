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
  private static final String a = "SearchHistoryAdapter";
  private Context b;
  private MqqWeakReferenceHandler c;
  private QQAppInterface d;
  private List<HistoryItem> e = new ArrayList();
  
  public SearchHistoryAdapter(Context paramContext, MqqWeakReferenceHandler paramMqqWeakReferenceHandler, QQAppInterface paramQQAppInterface)
  {
    this.b = paramContext;
    this.c = paramMqqWeakReferenceHandler;
    this.d = paramQQAppInterface;
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadHistory, keyword = ");
      localStringBuilder.append(paramString);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramString == null) {
      return;
    }
    Object localObject = HistoryChatMsgSearchKeyUtil.a(this.d.getCurrentAccountUin());
    this.e.clear();
    if (localObject != null)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder = localObject[i];
        if (a(localStringBuilder, paramString)) {
          this.e.add(new HistoryItem(localStringBuilder));
        }
        i += 1;
      }
    }
    notifyDataSetChanged();
    if (QLog.isColorLevel())
    {
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadHistory, keyword = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", histories = ");
      localStringBuilder.append(this.e.toString());
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    this.c.sendEmptyMessage(3);
  }
  
  boolean a(String paramString1, String paramString2)
  {
    return paramString1.toLowerCase(Locale.US).contains(paramString2.toLowerCase(Locale.US));
  }
  
  public int getCount()
  {
    return this.e.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.e.get(paramInt);
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
      localView = View.inflate(this.b, 2131625300, null);
      paramView = new SearchHistoryAdapter.HistoryHolder(null);
      paramView.a = ((TextView)localView.findViewById(2131447062));
      localView.setTag(paramView);
    }
    else
    {
      SearchHistoryAdapter.HistoryHolder localHistoryHolder = (SearchHistoryAdapter.HistoryHolder)paramView.getTag();
      localView = paramView;
      paramView = localHistoryHolder;
    }
    paramView.a.setText(localHistoryItem.a);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.SearchHistoryAdapter
 * JD-Core Version:    0.7.0.1
 */