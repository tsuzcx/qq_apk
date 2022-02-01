package com.tencent.mobileqq.activity.history;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.history.link.LinkAdapter;
import com.tencent.mobileqq.activity.history.tendoc.TencentDocItem;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class ChatHistoryBaseTenDocAdapter
  extends BaseAdapter
{
  private Context a;
  private LayoutInflater b;
  private View.OnClickListener c;
  private ChatHistoryBaseTenDocAdapter.SelectCheckCallback d;
  private List<Object> e = new ArrayList();
  private boolean f = false;
  
  public ChatHistoryBaseTenDocAdapter(Context paramContext)
  {
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.c = paramOnClickListener;
  }
  
  public void a(ChatHistoryBaseTenDocAdapter.SelectCheckCallback paramSelectCheckCallback)
  {
    this.d = paramSelectCheckCallback;
  }
  
  public void a(List<Object> paramList)
  {
    if (paramList != null) {
      this.e = paramList;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    notifyDataSetChanged();
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
    Object localObject2 = getItem(paramInt);
    boolean bool1 = localObject2 instanceof String;
    boolean bool2 = false;
    Object localObject1;
    if (bool1)
    {
      if ((paramView != null) && ((paramView.getTag() instanceof TextView)))
      {
        localObject1 = (TextView)paramView.getTag();
      }
      else
      {
        paramView = this.b.inflate(2131627060, paramViewGroup, false);
        localObject1 = (TextView)paramView.findViewById(2131447089);
        paramView.setTag(localObject1);
      }
      ((TextView)localObject1).setText((String)localObject2);
      localObject1 = paramView;
    }
    else
    {
      localObject1 = paramView;
      if ((localObject2 instanceof TencentDocItem))
      {
        localObject1 = paramView;
        try
        {
          TencentDocItem localTencentDocItem = (TencentDocItem)localObject2;
          if (paramView != null)
          {
            localObject1 = paramView;
            if ((paramView.getTag() instanceof ChatHistoryBaseTenDocAdapter.HistoryTenDocItemHolder))
            {
              localObject1 = paramView;
              localObject2 = (ChatHistoryBaseTenDocAdapter.HistoryTenDocItemHolder)paramView.getTag();
              break label308;
            }
          }
          localObject1 = paramView;
          localObject2 = new ChatHistoryBaseTenDocAdapter.HistoryTenDocItemHolder();
          localObject1 = paramView;
          paramView = this.b.inflate(2131627036, paramViewGroup, false);
          localObject1 = paramView;
          ((ChatHistoryBaseTenDocAdapter.HistoryTenDocItemHolder)localObject2).a = ((CheckBox)paramView.findViewById(2131433116));
          localObject1 = paramView;
          ((ChatHistoryBaseTenDocAdapter.HistoryTenDocItemHolder)localObject2).b = ((AsyncImageView)paramView.findViewById(2131433103));
          localObject1 = paramView;
          ((ChatHistoryBaseTenDocAdapter.HistoryTenDocItemHolder)localObject2).c = ((TextView)paramView.findViewById(2131433114));
          localObject1 = paramView;
          ((ChatHistoryBaseTenDocAdapter.HistoryTenDocItemHolder)localObject2).d = ((TextView)paramView.findViewById(2131433101));
          localObject1 = paramView;
          ((ChatHistoryBaseTenDocAdapter.HistoryTenDocItemHolder)localObject2).c.setMaxLines(2);
          localObject1 = paramView;
          ((ChatHistoryBaseTenDocAdapter.HistoryTenDocItemHolder)localObject2).b.setAsyncClipSize(AIOUtils.b(70.0F, this.a.getResources()), AIOUtils.b(70.0F, this.a.getResources()));
          localObject1 = paramView;
          paramView.setOnClickListener(this.c);
          localObject1 = paramView;
          paramView.setTag(localObject2);
          label308:
          localObject1 = paramView;
          paramView.setVisibility(0);
          localObject1 = paramView;
          ((ChatHistoryBaseTenDocAdapter.HistoryTenDocItemHolder)localObject2).e = localTencentDocItem;
          localObject1 = paramView;
          ((ChatHistoryBaseTenDocAdapter.HistoryTenDocItemHolder)localObject2).c.setText(localTencentDocItem.mTitle);
          localObject1 = paramView;
          LinkAdapter.a(((ChatHistoryBaseTenDocAdapter.HistoryTenDocItemHolder)localObject2).b, localTencentDocItem.mIcon);
          localObject1 = paramView;
          if (this.f)
          {
            localObject1 = paramView;
            ((ChatHistoryBaseTenDocAdapter.HistoryTenDocItemHolder)localObject2).a.setVisibility(0);
            bool1 = bool2;
            localObject1 = paramView;
            if (this.d != null)
            {
              bool1 = bool2;
              localObject1 = paramView;
              if (this.d.a(localTencentDocItem)) {
                bool1 = true;
              }
            }
            localObject1 = paramView;
            ((ChatHistoryBaseTenDocAdapter.HistoryTenDocItemHolder)localObject2).a.setChecked(bool1);
          }
          else
          {
            localObject1 = paramView;
            ((ChatHistoryBaseTenDocAdapter.HistoryTenDocItemHolder)localObject2).a.setVisibility(8);
          }
          localObject1 = paramView;
          ((ChatHistoryBaseTenDocAdapter.HistoryTenDocItemHolder)localObject2).d.setText(localTencentDocItem.mDescription);
          localObject1 = paramView;
        }
        catch (Exception paramView)
        {
          QLog.e("ChatHistoryBaseTenDocAdapter", 4, "getView failed", paramView);
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocAdapter
 * JD-Core Version:    0.7.0.1
 */