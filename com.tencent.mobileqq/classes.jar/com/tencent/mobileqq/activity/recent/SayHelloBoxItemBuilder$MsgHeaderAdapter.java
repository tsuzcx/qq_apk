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
  private Context b;
  private List<MessageRecord> c;
  private int d;
  private int e;
  
  public SayHelloBoxItemBuilder$MsgHeaderAdapter(SayHelloBoxItemBuilder paramSayHelloBoxItemBuilder, Context paramContext, int paramInt1, int paramInt2)
  {
    this.b = paramContext;
    this.d = paramInt1;
    this.e = paramInt2;
    this.c = new ArrayList();
  }
  
  private void a(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      this.c.clear();
      this.c.addAll(paramList);
    }
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.c;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    int j = this.d;
    if (i > j) {
      return j;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.c;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    if ((paramInt > 0) && (paramInt < i)) {
      return this.c.get(paramInt);
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
      localView = LayoutInflater.from(this.b).inflate(2131627381, null);
      int i = this.e;
      localView.setLayoutParams(new AbsListView.LayoutParams(i, i));
    }
    paramView = (CustomImgView)localView;
    MessageRecord localMessageRecord = (MessageRecord)this.c.get(paramInt);
    if ((localMessageRecord != null) && (!TextUtils.isEmpty(localMessageRecord.senderuin)))
    {
      paramView.setImageDrawable(this.a.a.a(localMessageRecord.istroop, localMessageRecord.senderuin));
      localView.setTag(-1, localMessageRecord.senderuin);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.SayHelloBoxItemBuilder.MsgHeaderAdapter
 * JD-Core Version:    0.7.0.1
 */