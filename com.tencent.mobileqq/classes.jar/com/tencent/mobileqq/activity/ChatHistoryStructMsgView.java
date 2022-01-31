package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import ryt;
import ryu;

public class ChatHistoryStructMsgView
  extends ChatHistoryViewBase
  implements Handler.Callback, AbsListView.OnScrollListener
{
  private static int c;
  public int a;
  public long a;
  public Context a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public ChatHistoryStructAdapter a;
  public QQAppInterface a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  final String jdField_a_of_type_JavaLangString = "ChatHistory_Struct";
  public ArrayList a;
  public final MqqHandler a;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  public long b;
  View.OnClickListener b;
  public String b;
  public boolean b;
  public long c;
  public String c;
  
  static
  {
    jdField_c_of_type_Int = 30;
  }
  
  public ChatHistoryStructMsgView()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 9223372036854775807L;
    this.jdField_b_of_type_Long = 9223372036854775807L;
    this.jdField_c_of_type_Long = 9223372036854775807L;
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ryt(this);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryStructAdapter.notifyDataSetChanged();
  }
  
  public void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", 0);
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("uinname");
    f();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130971551, null));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368764));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374993));
    this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130971550, null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
    a(true);
    this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryStructAdapter = new ChatHistoryStructAdapter(this.jdField_a_of_type_AndroidContentContext, (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone(), this.jdField_b_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnClickListener, this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryStructAdapter);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      a(false);
      this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryStructAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(List paramList)
  {
    Iterator localIterator;
    int i;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilArrayList.removeAll(paramList);
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      paramList = null;
      i = 0;
    }
    for (;;)
    {
      Object localObject1 = paramList;
      if (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if ((localObject2 instanceof String))
        {
          localObject1 = paramList;
          if (i == 0) {
            localObject1 = localObject2;
          }
          int j = i + 1;
          paramList = (List)localObject1;
          i = j;
          if (j != 2) {
            continue;
          }
        }
      }
      else
      {
        if (localObject1 != null) {
          this.jdField_a_of_type_JavaUtilArrayList.remove(localObject1);
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
        return;
      }
      paramList = null;
      i = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.post(new ryu(this, paramBoolean), 10, null, true);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryStructAdapter.notifyDataSetChanged();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryStructAdapter.notifyDataSetChanged();
      return false;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryStructAdapter.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryStructMsgView
 * JD-Core Version:    0.7.0.1
 */