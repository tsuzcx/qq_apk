package com.dataline.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.util.file.DLFileInfo;
import com.dataline.util.file.FileUtil;
import com.dataline.util.widget.AsyncImageView;
import com.dataline.util.widget.WaitTextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatalineFilesAdapter
  extends BaseAdapter
{
  private final int jdField_a_of_type_Int = 2;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public View.OnClickListener a;
  private DLFilesViewerActivity jdField_a_of_type_ComDatalineActivitiesDLFilesViewerActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DataLineMsgSet jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
  private View.OnClickListener b = new DatalineFilesAdapter.1(this);
  
  public DatalineFilesAdapter(Context paramContext, DataLineMsgSet paramDataLineMsgSet, DLFilesViewerActivity paramDLFilesViewerActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new DatalineFilesAdapter.2(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = paramDataLineMsgSet;
    this.jdField_a_of_type_ComDatalineActivitiesDLFilesViewerActivity = paramDLFilesViewerActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public static DLFileInfo a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    DLFileInfo localDLFileInfo = new DLFileInfo();
    localDLFileInfo.jdField_b_of_type_JavaLangString = paramDataLineMsgRecord.filename;
    localDLFileInfo.jdField_b_of_type_Long = paramDataLineMsgRecord.filesize;
    localDLFileInfo.jdField_a_of_type_JavaLangString = paramDataLineMsgRecord.path;
    localDLFileInfo.jdField_a_of_type_Long = paramDataLineMsgRecord.sessionid;
    if (paramDataLineMsgRecord.fileMsgStatus == 0L)
    {
      if (!paramDataLineMsgRecord.issuc)
      {
        if (paramDataLineMsgRecord.isSendFromLocal())
        {
          localDLFileInfo.jdField_a_of_type_Int = 1;
          return localDLFileInfo;
        }
        localDLFileInfo.jdField_a_of_type_Int = 4;
        return localDLFileInfo;
      }
      if (paramDataLineMsgRecord.progress != 1.0F)
      {
        if (paramDataLineMsgRecord.isSendFromLocal())
        {
          localDLFileInfo.jdField_a_of_type_Int = 0;
          return localDLFileInfo;
        }
        localDLFileInfo.jdField_a_of_type_Int = 3;
        return localDLFileInfo;
      }
      localDLFileInfo.jdField_a_of_type_Int = 5;
      return localDLFileInfo;
    }
    if (paramDataLineMsgRecord.fileMsgStatus == 2L)
    {
      if (paramDataLineMsgRecord.isSendFromLocal())
      {
        localDLFileInfo.jdField_a_of_type_Int = 1;
        return localDLFileInfo;
      }
      localDLFileInfo.jdField_a_of_type_Int = 4;
      return localDLFileInfo;
    }
    localDLFileInfo.jdField_a_of_type_Int = 2;
    return localDLFileInfo;
  }
  
  private void a(DatalineFilesAdapter.ItemHolder paramItemHolder, DataLineMsgRecord paramDataLineMsgRecord)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (paramDataLineMsgRecord.strMoloKey != null) {
      localDataLineHandler.b(111);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramDataLineMsgRecord.sessionid));
    if (localDataLineHandler.a(localArrayList))
    {
      paramItemHolder.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_Int = 3;
      paramDataLineMsgRecord.fileMsgStatus = 0L;
      int i = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).d(paramDataLineMsgRecord.msgId);
      paramDataLineMsgRecord.issuc = true;
      return;
    }
    FMToastUtil.a(2131693760);
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord.strMoloKey != null)
    {
      DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      if ((paramDataLineMsgRecord.bIsApkFile) && (paramDataLineMsgRecord.nAppStatus != 1))
      {
        localDataLineHandler.b(paramDataLineMsgRecord.strMoloKey);
        return;
      }
      int i = localDataLineHandler.a(paramDataLineMsgRecord.strMoloKey);
      if (i == 2)
      {
        FMToastUtil.a(2131692717);
        return;
      }
      if (i != 0) {
        FMToastUtil.a(2131693702);
      }
    }
    else
    {
      paramDataLineMsgRecord = paramDataLineMsgRecord.path;
      FileManagerUtil.a(this.jdField_a_of_type_ComDatalineActivitiesDLFilesViewerActivity, paramDataLineMsgRecord);
    }
  }
  
  private void b(DatalineFilesAdapter.ItemHolder paramItemHolder, DataLineMsgRecord paramDataLineMsgRecord)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (paramItemHolder.jdField_a_of_type_Int == 0) {
      localDataLineHandler.a(paramDataLineMsgRecord.path, paramDataLineMsgRecord.thumbPath, 1, paramDataLineMsgRecord.sessionid, paramDataLineMsgRecord.groupId, paramDataLineMsgRecord.groupSize, paramDataLineMsgRecord.groupIndex, true);
    } else {
      localDataLineHandler.a(paramDataLineMsgRecord.path, paramDataLineMsgRecord.thumbPath, 0, paramDataLineMsgRecord.sessionid, paramDataLineMsgRecord.groupId, paramDataLineMsgRecord.groupSize, paramDataLineMsgRecord.groupIndex, true);
    }
    paramItemHolder.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_Int = 0;
  }
  
  public void a(long paramLong, ListView paramListView, float paramFloat)
  {
    if (paramListView != null)
    {
      if (paramLong == 0L) {
        return;
      }
      int i = 0;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
        if ((localDataLineMsgRecord != null) && (localDataLineMsgRecord.sessionid == paramLong)) {
          break;
        }
        i += 1;
      }
      paramListView = paramListView.getChildAt(i - paramListView.getFirstVisiblePosition());
      if (paramListView != null)
      {
        if (i >= this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount()) {
          return;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getItemBySessionId(paramLong);
        if (localObject == null) {
          return;
        }
        float f = paramFloat;
        if (paramFloat < ((DataLineMsgRecord)localObject).progress) {
          f = ((DataLineMsgRecord)localObject).progress;
        }
        localObject = (ProgressBar)paramListView.findViewById(2131366793);
        if (localObject != null) {
          ((ProgressBar)localObject).setProgress((int)(f * 100.0F));
        }
        paramListView = (TextView)paramListView.findViewById(2131366824);
        if (paramListView != null)
        {
          i = (int)(f * 100.0F);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(String.valueOf(i));
          ((StringBuilder)localObject).append("%");
          paramListView.setText(((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getComeCount() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int j = getCount();
    int i = 1;
    if (paramInt != j - 1) {
      i = 0;
    }
    if (i != 0) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getCount() - 1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0) {
      return 1;
    }
    return 0;
  }
  
  @TargetApi(8)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i;
    if (paramInt == getCount() - 1) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject1;
    if (i == 0) {
      localObject1 = (DataLineMsgRecord)getItem(paramInt);
    } else {
      localObject1 = null;
    }
    Object localObject2;
    View localView;
    if (paramView == null)
    {
      localObject2 = new DatalineFilesAdapter.ItemHolder(this);
      if (i != 0)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559010, null);
        ((DatalineFilesAdapter.ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366284));
        ((DatalineFilesAdapter.ItemHolder)localObject2).jdField_a_of_type_ComDatalineUtilWidgetWaitTextView = ((WaitTextView)paramView.findViewById(2131366286));
      }
      else
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559009, null);
        ((DatalineFilesAdapter.ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366809));
        ((DatalineFilesAdapter.ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.b);
        ((DatalineFilesAdapter.ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject2);
        ((DatalineFilesAdapter.ItemHolder)localObject2).jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366782));
        ((DatalineFilesAdapter.ItemHolder)localObject2).jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130844274);
        ((DatalineFilesAdapter.ItemHolder)localObject2).jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        ((DatalineFilesAdapter.ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366819));
        ((DatalineFilesAdapter.ItemHolder)localObject2).b = ((TextView)paramView.findViewById(2131366823));
        ((DatalineFilesAdapter.ItemHolder)localObject2).c = ((TextView)paramView.findViewById(2131366824));
        ((DatalineFilesAdapter.ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366793));
        ((DatalineFilesAdapter.ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131361945));
        ((DatalineFilesAdapter.ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetButton.setTag(localObject2);
        ((DatalineFilesAdapter.ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      paramView.setTag(localObject2);
      localView = paramView;
      paramView = (View)localObject2;
    }
    else
    {
      localObject2 = (DatalineFilesAdapter.ItemHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject2;
    }
    if (i != 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getComeCount() == this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount())
      {
        localView.setVisibility(4);
        paramView.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.b();
      }
      else
      {
        int j;
        if (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isTimeOut())
        {
          paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setVisibility(0);
          i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getComeCount();
          j = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount();
          localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693751), new Object[] { Integer.valueOf(j - i) });
          paramView.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setWaitText((String)localObject1);
          paramView.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.a();
        }
        else
        {
          paramView.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.b();
          paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setVisibility(0);
          i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getComeCount();
          j = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount();
          localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693749), new Object[] { Integer.valueOf(i), Integer.valueOf(j - i) });
          paramView.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setWaitText((String)localObject1);
        }
      }
    }
    else if (localObject1 == null)
    {
      paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    }
    else
    {
      paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramView.jdField_a_of_type_ComDatalineUtilFileDLFileInfo = a((DataLineMsgRecord)localObject1);
      paramView.jdField_a_of_type_Int = ((DataLineMsgRecord)localObject1).msgtype;
      if ((((DataLineMsgRecord)localObject1).strMoloKey != null) && (((DataLineMsgRecord)localObject1).bIsApkFile))
      {
        paramView.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130844274);
        paramView.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(((DataLineMsgRecord)localObject1).strMoloIconUrl);
      }
      else
      {
        FileManagerUtil.a(paramView.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView, (DataLineMsgRecord)localObject1);
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((DataLineMsgRecord)localObject1).filename);
      paramView.b.setText(FileUtil.a(((DataLineMsgRecord)localObject1).filesize));
      if ((((DataLineMsgRecord)localObject1).progress != 1.0F) && (((DataLineMsgRecord)localObject1).issuc) && (((DataLineMsgRecord)localObject1).fileMsgStatus != 1L) && (((DataLineMsgRecord)localObject1).fileMsgStatus != 2L))
      {
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramView.c.setVisibility(0);
        i = (int)(((DataLineMsgRecord)localObject1).progress * 100.0F);
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
        localObject1 = paramView.c;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(String.valueOf(i));
        ((StringBuilder)localObject2).append("%");
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        paramView.jdField_a_of_type_AndroidWidgetButton.setText(2131693752);
      }
      else
      {
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramView.c.setVisibility(4);
        if ((((DataLineMsgRecord)localObject1).issuc) && (((DataLineMsgRecord)localObject1).fileMsgStatus != 1L) && (((DataLineMsgRecord)localObject1).fileMsgStatus != 2L))
        {
          if (((DataLineMsgRecord)localObject1).progress == 1.0F) {
            if ((((DataLineMsgRecord)localObject1).strMoloKey != null) && (((DataLineMsgRecord)localObject1).bIsApkFile) && (((DataLineMsgRecord)localObject1).nAppStatus != 1)) {
              paramView.jdField_a_of_type_AndroidWidgetButton.setText(2131693730);
            } else {
              paramView.jdField_a_of_type_AndroidWidgetButton.setText(2131693748);
            }
          }
        }
        else {
          paramView.jdField_a_of_type_AndroidWidgetButton.setText(2131693761);
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.DatalineFilesAdapter
 * JD-Core Version:    0.7.0.1
 */