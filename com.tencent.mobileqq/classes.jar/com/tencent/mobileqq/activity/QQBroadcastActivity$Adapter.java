package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.config.ADParser;
import com.tencent.mobileqq.config.struct.ADMsg;

class QQBroadcastActivity$Adapter
  extends CursorAdapter
{
  QQBroadcastActivity.ViewHolder jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder;
  
  public QQBroadcastActivity$Adapter(QQBroadcastActivity paramQQBroadcastActivity, Context paramContext, Cursor paramCursor)
  {
    super(paramContext, paramCursor);
    paramQQBroadcastActivity.a(paramCursor);
  }
  
  protected void a(String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity, SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    String str;
    if (paramString2 != null)
    {
      str = paramString2;
      if (paramString2.trim().length() != 0) {}
    }
    else
    {
      str = paramString1;
    }
    localIntent.putExtra("uinname", str);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity.startActivity(localIntent);
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    int i = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
    Object localObject = paramCursor.getString(paramCursor.getColumnIndex("msg"));
    long l1 = paramCursor.getLong(paramCursor.getColumnIndex("time"));
    long l2 = paramCursor.getLong(paramCursor.getColumnIndex("uniseq"));
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder = ((QQBroadcastActivity.ViewHolder)paramView.getTag());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder = new QQBroadcastActivity.ViewHolder(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380174));
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131378810));
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380144));
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.c = ((TextView)paramView.findViewById(2131380177));
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.d = ((TextView)paramView.findViewById(2131380173));
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372199));
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363876);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363780));
      paramView.setTag(this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity.a(l2) != -1L)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.d.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.d.setText(BaseSystemActivity.a(1000L * l1, false));
      label274:
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(new QQBroadcastActivity.Adapter.1(this, l2));
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity.getSharedPreferences(String.valueOf(AppConstants.QQBROADCAST_MSG_UIN), 0);
      paramCursor = "QQBROADCAST_MSG_UIN" + l2 + l1;
      if (!paramView.contains(paramCursor)) {
        break label450;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.d.setVisibility(8);
        break label274;
        label450:
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramContext.getResources().getString(2131719682));
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 12);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new QQBroadcastActivity.Adapter.2(this, paramView, paramCursor));
    return;
    localObject = ADParser.b((String)localObject);
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.c.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    if ((localObject != null) && (((ADMsg)localObject).b.length() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((ADMsg)localObject).b);
      if ((localObject == null) || (((ADMsg)localObject).a.length() <= 0)) {
        break label870;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((ADMsg)localObject).a);
      label732:
      if ((localObject == null) || (((ADMsg)localObject).f.length() <= 0)) {
        break label910;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.c.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if ((localObject == null) || (((ADMsg)localObject).d.length() <= 0)) {
        break label885;
      }
      paramContext = ((ADMsg)localObject).d;
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.c.setText(paramContext);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new QQBroadcastActivity.Adapter.3(this, (ADMsg)localObject, paramView, paramCursor));
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramContext.getResources().getString(2131719682));
      break;
      label870:
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label732;
      label885:
      paramContext = paramContext.getResources().getString(2131719689);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.c.setText(paramContext);
    }
    label910:
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$ViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void changeCursor(Cursor paramCursor)
  {
    super.changeCursor(paramCursor);
    notifyDataSetChanged();
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity.getLayoutInflater().inflate(2131558964, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBroadcastActivity.Adapter
 * JD-Core Version:    0.7.0.1
 */