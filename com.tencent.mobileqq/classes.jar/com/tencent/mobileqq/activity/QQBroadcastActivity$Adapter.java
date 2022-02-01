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
  QQBroadcastActivity.ViewHolder a;
  
  public QQBroadcastActivity$Adapter(QQBroadcastActivity paramQQBroadcastActivity, Context paramContext, Cursor paramCursor)
  {
    super(paramContext, paramCursor);
    paramQQBroadcastActivity.a(paramCursor);
  }
  
  protected void a(String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = AIOUtils.a(new Intent(this.b, SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    String str = paramString1;
    if (paramString2 != null) {
      if (paramString2.trim().length() == 0) {
        str = paramString1;
      } else {
        str = paramString2;
      }
    }
    localIntent.putExtra("uinname", str);
    this.b.startActivity(localIntent);
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    int i = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
    Object localObject = paramCursor.getString(paramCursor.getColumnIndex("msg"));
    long l1 = paramCursor.getLong(paramCursor.getColumnIndex("time"));
    long l2 = paramCursor.getLong(paramCursor.getColumnIndex("uniseq"));
    this.a = ((QQBroadcastActivity.ViewHolder)paramView.getTag());
    if (this.a == null)
    {
      this.a = new QQBroadcastActivity.ViewHolder(null);
      this.a.a = ((TextView)paramView.findViewById(2131448241));
      this.a.b = ((RelativeLayout)paramView.findViewById(2131446716));
      this.a.c = ((TextView)paramView.findViewById(2131448215));
      this.a.d = ((TextView)paramView.findViewById(2131448244));
      this.a.e = ((TextView)paramView.findViewById(2131448240));
      this.a.f = ((ImageView)paramView.findViewById(2131439218));
      this.a.g = paramView.findViewById(2131429737);
      this.a.h = ((RelativeLayout)paramView.findViewById(2131429631));
      paramView.setTag(this.a);
    }
    if (this.b.a(l2) != -1L)
    {
      this.a.e.setVisibility(0);
      this.a.e.setText(BaseSystemActivity.a(1000L * l1, false));
    }
    else
    {
      this.a.e.setVisibility(8);
    }
    this.a.b.setOnLongClickListener(new QQBroadcastActivity.Adapter.1(this, l2));
    paramView = this.b.getSharedPreferences(String.valueOf(AppConstants.QQBROADCAST_MSG_UIN), 0);
    paramCursor = new StringBuilder();
    paramCursor.append("QQBROADCAST_MSG_UIN");
    paramCursor.append(l2);
    paramCursor.append(l1);
    paramCursor = paramCursor.toString();
    if (paramView.contains(paramCursor)) {
      this.a.f.setVisibility(8);
    } else {
      this.a.f.setVisibility(0);
    }
    if (i != -2004) {
      if ((i != -2003) && (i != 9))
      {
        if (i != 513)
        {
          this.a.b.setClickable(false);
          this.a.b.setOnClickListener(null);
          this.a.b.setVisibility(8);
        }
      }
      else
      {
        this.a.d.setVisibility(8);
        this.a.g.setVisibility(8);
        this.a.h.setVisibility(8);
        this.a.a.setText(paramContext.getResources().getString(2131916962));
        this.a.c.setVisibility(0);
        this.a.c.setText((CharSequence)localObject);
        this.a.c.setPadding(0, 0, 0, 12);
        this.a.b.setClickable(true);
        this.a.b.setOnClickListener(new QQBroadcastActivity.Adapter.2(this, paramView, paramCursor));
        return;
      }
    }
    localObject = ADParser.d((String)localObject);
    if (localObject == null)
    {
      this.a.b.setClickable(false);
      this.a.b.setOnClickListener(null);
      this.a.d.setVisibility(8);
      this.a.g.setVisibility(8);
      this.a.h.setVisibility(8);
    }
    if ((localObject != null) && (((ADMsg)localObject).b.length() > 0)) {
      this.a.a.setText(((ADMsg)localObject).b);
    } else {
      this.a.a.setText(paramContext.getResources().getString(2131916962));
    }
    if ((localObject != null) && (((ADMsg)localObject).a.length() > 0))
    {
      this.a.c.setVisibility(0);
      this.a.c.setText(((ADMsg)localObject).a);
    }
    else
    {
      this.a.c.setVisibility(8);
    }
    if ((localObject != null) && (((ADMsg)localObject).f.length() > 0))
    {
      this.a.d.setVisibility(0);
      this.a.g.setVisibility(0);
      this.a.h.setVisibility(0);
      if ((localObject != null) && (((ADMsg)localObject).d.length() > 0))
      {
        paramContext = ((ADMsg)localObject).d;
        this.a.d.setText(paramContext);
      }
      else
      {
        paramContext = paramContext.getResources().getString(2131916969);
        this.a.d.setText(paramContext);
      }
      this.a.b.setClickable(true);
      this.a.b.setOnClickListener(new QQBroadcastActivity.Adapter.3(this, (ADMsg)localObject, paramView, paramCursor));
      return;
    }
    this.a.b.setClickable(false);
    this.a.b.setOnClickListener(null);
    this.a.d.setVisibility(8);
    this.a.g.setVisibility(8);
    this.a.h.setVisibility(8);
  }
  
  public void changeCursor(Cursor paramCursor)
  {
    super.changeCursor(paramCursor);
    notifyDataSetChanged();
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.b.getLayoutInflater().inflate(2131624482, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBroadcastActivity.Adapter
 * JD-Core Version:    0.7.0.1
 */