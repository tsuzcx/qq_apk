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
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new PrinterSessionAdapter.1(this);
  public View.OnLongClickListener a;
  public PrinterActivity a;
  DataLineHandler jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = null;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  
  public PrinterSessionAdapter(PrinterActivity paramPrinterActivity, DataLineHandler paramDataLineHandler)
  {
    this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity = null;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new PrinterSessionAdapter.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = paramDataLineHandler;
    this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity = paramPrinterActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramPrinterActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.b();
    b();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a.size();
  }
  
  public long a(int paramInt)
  {
    return ((PrinterItemMsgRecord)this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a.get(paramInt)).time;
  }
  
  protected boolean a(View paramView)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if ((localObject1 != null) && (((BubblePopupWindow)localObject1).isShowing())) {
      return true;
    }
    localObject1 = new QQCustomMenu();
    paramView = (ItemHolder)paramView.getTag();
    Object localObject2 = (PrinterItemMsgRecord)paramView.a();
    if (localObject2 != null)
    {
      Object localObject3 = paramView.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (localObject3 == null) {
        return false;
      }
      localObject3 = ((RelativeLayout)localObject3).getContext();
      ((QQCustomMenu)localObject1).a(2131365489, ((Context)localObject3).getString(2131693709));
      localObject2 = new PrinterSessionAdapter.3(this, (PrinterItemMsgRecord)localObject2, (Context)localObject3);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView.jdField_a_of_type_AndroidWidgetRelativeLayout, (QQCustomMenu)localObject1, (View.OnClickListener)localObject2);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setOnDismissListener(new PrinterSessionAdapter.1DissmissListener(this));
      return true;
    }
    return false;
  }
  
  public long b(int paramInt)
  {
    return ((PrinterItemMsgRecord)this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a.get(paramInt)).uniseq;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a.size() > paramInt) {
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a.get(paramInt);
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a.size() > paramInt) {
      localObject1 = (PrinterItemMsgRecord)this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a.get(paramInt);
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
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559021, null);
        localItemHolder = new ItemHolder();
        localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131371546));
        localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localItemHolder);
        localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
        localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
        localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
        localItemHolder.b((TextView)paramView.findViewById(2131377850));
        localObject2 = (RelativeLayout)paramView.findViewById(2131366806);
        localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
        localItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366782));
        localItemHolder.a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366819));
        localItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366793));
        localItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130851161);
        localItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        localItemHolder.a((TextView)paramView.findViewById(2131365421));
        paramView.setTag(localItemHolder);
      }
      else
      {
        localItemHolder = (ItemHolder)paramView.getTag();
      }
      localItemHolder.a(localObject1);
      localItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
      Object localObject2 = FileUtil.a(((PrinterItemMsgRecord)localObject1).filename);
      if (localObject2 == null)
      {
        localItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130844437);
      }
      else
      {
        localItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(FileManagerUtil.b((String)localObject2));
        if (FileManagerUtil.a((String)localObject2) != 0)
        {
          i = FileManagerUtil.b((String)localObject2);
          if (i != 0) {
            localItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(i);
          }
        }
        else
        {
          localItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(128, 128);
          localItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(((PrinterItemMsgRecord)localObject1).filename);
        }
      }
      localObject2 = ((PrinterItemMsgRecord)localObject1).filename;
      int i = ((PrinterItemMsgRecord)localObject1).filename.lastIndexOf("/");
      if (i >= 0) {
        localObject2 = FileManagerUtil.c(((PrinterItemMsgRecord)localObject1).filename.substring(i + 1));
      }
      localItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
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
            localItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
            localItemHolder.b().setText(2131691367);
            break;
          case 11: 
            localItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
            localItemHolder.b().setText(2131691365);
            break;
          case 10: 
            localItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
            localItemHolder.b().setText(2131691366);
            break;
          }
        }
        else
        {
          localItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          localItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(((PrinterItemMsgRecord)localObject1).progress * 100.0D));
          localItemHolder.b().setText(2131691364);
        }
      }
      else
      {
        localItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        localItemHolder.b().setText(2131691363);
      }
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity.app))
      {
        localObject2 = (ChatBackgroundDrawable)this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity.a.getTag(2131361812);
        if (localObject2 != null)
        {
          i = ChatBackground.a(((ChatBackgroundDrawable)localObject2).getBitmap());
          localItemHolder.a().setTextColor(ColorStateList.valueOf(i));
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
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
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
        localObject1 = TimeFormatterUtils.a(this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity, 3, ((PrinterItemMsgRecord)localObject1).time * 1000L);
        localItemHolder.a().setVisibility(0);
        localItemHolder.a().setText((CharSequence)localObject1);
      }
      else
      {
        localItemHolder.a().setVisibility(8);
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