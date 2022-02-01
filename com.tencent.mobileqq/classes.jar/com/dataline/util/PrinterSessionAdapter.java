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
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;

public class PrinterSessionAdapter
  extends TimeAdapter
{
  public static String a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new PrinterSessionAdapter.1(this);
  public View.OnLongClickListener a;
  public PrinterActivity a;
  DataLineHandler jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = null;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = "dataline.PrinterSessionAdapter";
  }
  
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
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      return true;
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ItemHolder)paramView.getTag();
    Object localObject1 = (PrinterItemMsgRecord)paramView.a();
    if (localObject1 != null)
    {
      localObject2 = paramView.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (localObject2 == null) {
        return false;
      }
    }
    else
    {
      return false;
    }
    Object localObject2 = ((RelativeLayout)localObject2).getContext();
    localQQCustomMenu.a(2131365645, ((Context)localObject2).getString(2131693756));
    localObject1 = new PrinterSessionAdapter.3(this, (PrinterItemMsgRecord)localObject1, (Context)localObject2);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView.jdField_a_of_type_AndroidWidgetRelativeLayout, localQQCustomMenu, (View.OnClickListener)localObject1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new PrinterSessionAdapter.1DissmissListener(this));
    return true;
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a.size() > paramInt) {}
    for (Object localObject1 = (PrinterItemMsgRecord)this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a.get(paramInt);; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 == null)
      {
        localObject2 = null;
        localObject1 = paramView;
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return localObject2;
      }
      Object localObject3;
      label295:
      int i;
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559127, null);
        localObject2 = new ItemHolder();
        ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131371935));
        ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject2);
        ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
        ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
        ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
        ((ItemHolder)localObject2).b((TextView)paramView.findViewById(2131378436));
        localObject3 = (RelativeLayout)paramView.findViewById(2131366944);
        ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
        ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366920));
        ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366957));
        ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366931));
        ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130851250);
        ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        ((ItemHolder)localObject2).a((TextView)paramView.findViewById(2131365578));
        paramView.setTag(localObject2);
        ((ItemHolder)localObject2).a(localObject1);
        ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        localObject3 = FileUtil.a(((PrinterItemMsgRecord)localObject1).filename);
        if (localObject3 != null) {
          break label688;
        }
        ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130844531);
        localObject3 = ((PrinterItemMsgRecord)localObject1).filename;
        i = ((PrinterItemMsgRecord)localObject1).filename.lastIndexOf("/");
        if (i >= 0) {
          localObject3 = FileManagerUtil.d(((PrinterItemMsgRecord)localObject1).filename.substring(i + 1));
        }
        ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
        switch (((PrinterItemMsgRecord)localObject1).status)
        {
        default: 
          label452:
          if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity.app))
          {
            localObject3 = (ChatBackgroundDrawable)this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity.a.getTag(2131361806);
            if (localObject3 != null)
            {
              i = ChatBackground.a(((ChatBackgroundDrawable)localObject3).getBitmap());
              ((ItemHolder)localObject2).a().setTextColor(ColorStateList.valueOf(i));
            }
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("dataline.time", 4, "time[" + ((PrinterItemMsgRecord)localObject1).time + "], uniseq[" + ((PrinterItemMsgRecord)localObject1).uniseq + "], lastShowTime[" + this.jdField_a_of_type_Long + "], filename[" + ((PrinterItemMsgRecord)localObject1).filename + "], position[" + paramInt + "], mapShowTime[" + a(((PrinterItemMsgRecord)localObject1).uniseq));
          }
          if (a(((PrinterItemMsgRecord)localObject1).uniseq))
          {
            localObject1 = TimeFormatterUtils.a(this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity, 3, ((PrinterItemMsgRecord)localObject1).time * 1000L);
            ((ItemHolder)localObject2).a().setVisibility(0);
            ((ItemHolder)localObject2).a().setText((CharSequence)localObject1);
          }
          break;
        }
      }
      for (;;)
      {
        localObject1 = paramView;
        localObject2 = paramView;
        break;
        localObject2 = (ItemHolder)paramView.getTag();
        break label295;
        label688:
        ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(FileManagerUtil.b((String)localObject3));
        switch (FileManagerUtil.a((String)localObject3))
        {
        default: 
          i = FileManagerUtil.b((String)localObject3);
          if (i == 0) {
            break;
          }
          ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(i);
          break;
        case 0: 
          ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(128, 128);
          ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(((PrinterItemMsgRecord)localObject1).filename);
          break;
          ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((ItemHolder)localObject2).b().setText(2131691441);
          break label452;
          ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(((PrinterItemMsgRecord)localObject1).progress * 100.0D));
          ((ItemHolder)localObject2).b().setText(2131691442);
          break label452;
          ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          ((ItemHolder)localObject2).b().setText(2131691444);
          break label452;
          ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          ((ItemHolder)localObject2).b().setText(2131691443);
          break label452;
          ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          ((ItemHolder)localObject2).b().setText(2131691445);
          break label452;
          ((ItemHolder)localObject2).a().setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.util.PrinterSessionAdapter
 * JD-Core Version:    0.7.0.1
 */