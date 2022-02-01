package com.dataline.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.activities.PrinterActivity;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.chatbg.ChatBackgroundDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;

public class PrinterSessionAdapter
  extends TimeAdapter
{
  public static String a = "dataline.PrinterSessionAdapter";
  LayoutInflater b = null;
  public PrinterActivity c = null;
  DataLineHandler d = null;
  public View.OnLongClickListener e = new PrinterSessionAdapter.2(this);
  BubblePopupWindow f = null;
  private View.OnClickListener h = new PrinterSessionAdapter.1(this);
  
  public PrinterSessionAdapter(PrinterActivity paramPrinterActivity, DataLineHandler paramDataLineHandler)
  {
    this.d = paramDataLineHandler;
    this.c = paramPrinterActivity;
    this.b = LayoutInflater.from(paramPrinterActivity);
    this.d.e.c();
    d();
  }
  
  protected boolean a(View paramView)
  {
    Object localObject1 = this.f;
    if ((localObject1 != null) && (((BubblePopupWindow)localObject1).isShowing())) {
      return true;
    }
    localObject1 = new QQCustomMenu();
    paramView = (ItemHolder)paramView.getTag();
    Object localObject2 = (PrinterItemMsgRecord)paramView.b();
    if (localObject2 != null)
    {
      Object localObject3 = paramView.c().m;
      if (localObject3 == null) {
        return false;
      }
      localObject3 = ((RelativeLayout)localObject3).getContext();
      ((QQCustomMenu)localObject1).a(2131431703, ((Context)localObject3).getString(2131891284));
      localObject2 = new PrinterSessionAdapter.3(this, (PrinterItemMsgRecord)localObject2, (Context)localObject3);
      this.f = BubbleContextMenu.a(paramView.b, (QQCustomMenu)localObject1, (View.OnClickListener)localObject2);
      this.f.setOnDismissListener(new PrinterSessionAdapter.1DissmissListener(this));
      return true;
    }
    return false;
  }
  
  public long b(int paramInt)
  {
    return ((PrinterItemMsgRecord)this.d.e.e.get(paramInt)).time;
  }
  
  public int c()
  {
    return this.d.e.e.size();
  }
  
  public long c(int paramInt)
  {
    return ((PrinterItemMsgRecord)this.d.e.e.get(paramInt)).uniseq;
  }
  
  public int getCount()
  {
    return this.d.e.e.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.d.e.e.size() > paramInt) {
      this.d.e.e.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (this.d.e.e.size() > paramInt) {
      localObject1 = (PrinterItemMsgRecord)this.d.e.e.get(paramInt);
    } else {
      localObject1 = null;
    }
    ItemHolder localItemHolder;
    if (localObject1 == null)
    {
      localItemHolder = null;
      localObject1 = paramView;
      paramView = localItemHolder;
    }
    else
    {
      if (paramView == null)
      {
        paramView = this.b.inflate(2131624655, null);
        localItemHolder = new ItemHolder();
        localItemHolder.b = ((RelativeLayout)paramView.findViewById(2131438925));
        localItemHolder.b.setTag(localItemHolder);
        localItemHolder.b.setClickable(true);
        localItemHolder.b.setLongClickable(true);
        localItemHolder.b.setOnClickListener(this.h);
        localItemHolder.b.setOnLongClickListener(this.e);
        localItemHolder.b.setAddStatesFromChildren(true);
        localItemHolder.b((TextView)paramView.findViewById(2131446326));
        localObject2 = (RelativeLayout)paramView.findViewById(2131433128);
        localItemHolder.c().m = ((RelativeLayout)localObject2);
        localItemHolder.c().a = ((AsyncImageView)paramView.findViewById(2131433104));
        localItemHolder.c().e = ((TextView)paramView.findViewById(2131433141));
        localItemHolder.c().l = ((ProgressBar)paramView.findViewById(2131433115));
        localItemHolder.c().a.setDefaultImage(2130853415);
        localItemHolder.c().a.setIsDrawRound(false);
        localItemHolder.a((TextView)paramView.findViewById(2131431625));
        paramView.setTag(localItemHolder);
      }
      else
      {
        localItemHolder = (ItemHolder)paramView.getTag();
      }
      localItemHolder.a(localObject1);
      localItemHolder.c().a.setIsDrawRound(false);
      Object localObject2 = FileUtil.a(((PrinterItemMsgRecord)localObject1).filename);
      if (localObject2 == null)
      {
        localItemHolder.c().a.setImageResource(2130845755);
      }
      else
      {
        localItemHolder.c().a.setDefaultImage(FileManagerUtil.i((String)localObject2));
        if (FileManagerUtil.c((String)localObject2) != 0)
        {
          i = FileManagerUtil.i((String)localObject2);
          if (i != 0) {
            localItemHolder.c().a.setImageResource(i);
          }
        }
        else
        {
          localItemHolder.c().a.setAsyncClipSize(128, 128);
          localItemHolder.c().a.setAsyncImage(((PrinterItemMsgRecord)localObject1).filename);
        }
      }
      localObject2 = ((PrinterItemMsgRecord)localObject1).filename;
      int i = ((PrinterItemMsgRecord)localObject1).filename.lastIndexOf("/");
      if (i >= 0) {
        localObject2 = FileManagerUtil.j(((PrinterItemMsgRecord)localObject1).filename.substring(i + 1));
      }
      localItemHolder.c().e.setText((CharSequence)localObject2);
      i = ((PrinterItemMsgRecord)localObject1).status;
      if (i != 1)
      {
        if (i != 2)
        {
          switch (i)
          {
          default: 
            break;
          case 12: 
            localItemHolder.c().l.setVisibility(4);
            localItemHolder.k().setText(2131888322);
            break;
          case 11: 
            localItemHolder.c().l.setVisibility(4);
            localItemHolder.k().setText(2131888320);
            break;
          case 10: 
            localItemHolder.c().l.setVisibility(4);
            localItemHolder.k().setText(2131888321);
            break;
          }
        }
        else
        {
          localItemHolder.c().l.setVisibility(0);
          localItemHolder.c().l.setProgress((int)(((PrinterItemMsgRecord)localObject1).progress * 100.0D));
          localItemHolder.k().setText(2131888319);
        }
      }
      else
      {
        localItemHolder.c().l.setVisibility(0);
        localItemHolder.k().setText(2131888318);
      }
      if (ThemeUtil.isInNightMode(this.c.app))
      {
        localObject2 = (ChatBackgroundDrawable)this.c.b.getTag(2131427358);
        if (localObject2 != null)
        {
          i = ChatBackground.a(((ChatBackgroundDrawable)localObject2).getBitmap());
          localItemHolder.j().setTextColor(ColorStateList.valueOf(i));
        }
      }
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("time[");
        ((StringBuilder)localObject2).append(((PrinterItemMsgRecord)localObject1).time);
        ((StringBuilder)localObject2).append("], uniseq[");
        ((StringBuilder)localObject2).append(((PrinterItemMsgRecord)localObject1).uniseq);
        ((StringBuilder)localObject2).append("], lastShowTime[");
        ((StringBuilder)localObject2).append(this.g);
        ((StringBuilder)localObject2).append("], filename[");
        ((StringBuilder)localObject2).append(((PrinterItemMsgRecord)localObject1).filename);
        ((StringBuilder)localObject2).append("], position[");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append("], mapShowTime[");
        ((StringBuilder)localObject2).append(a(((PrinterItemMsgRecord)localObject1).uniseq));
        QLog.d("dataline.time", 4, ((StringBuilder)localObject2).toString());
      }
      if (a(((PrinterItemMsgRecord)localObject1).uniseq))
      {
        localObject1 = TimeFormatterUtils.a(this.c, 3, ((PrinterItemMsgRecord)localObject1).time * 1000L);
        localItemHolder.j().setVisibility(0);
        localItemHolder.j().setText((CharSequence)localObject1);
      }
      else
      {
        localItemHolder.j().setVisibility(8);
      }
      localObject1 = paramView;
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.PrinterSessionAdapter
 * JD-Core Version:    0.7.0.1
 */