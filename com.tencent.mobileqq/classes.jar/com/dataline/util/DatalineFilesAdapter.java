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
    FMToastUtil.a(2131693807);
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord.strMoloKey != null)
    {
      DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      if ((!paramDataLineMsgRecord.bIsApkFile) || (paramDataLineMsgRecord.nAppStatus == 1))
      {
        int i = localDataLineHandler.a(paramDataLineMsgRecord.strMoloKey);
        if (i == 2) {
          FMToastUtil.a(2131692760);
        }
        while (i == 0) {
          return;
        }
        FMToastUtil.a(2131693749);
        return;
      }
      localDataLineHandler.b(paramDataLineMsgRecord.strMoloKey);
      return;
    }
    paramDataLineMsgRecord = paramDataLineMsgRecord.path;
    FileManagerUtil.a(this.jdField_a_of_type_ComDatalineActivitiesDLFilesViewerActivity, paramDataLineMsgRecord);
  }
  
  private void b(DatalineFilesAdapter.ItemHolder paramItemHolder, DataLineMsgRecord paramDataLineMsgRecord)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (paramItemHolder.jdField_a_of_type_Int == 0) {
      localDataLineHandler.a(paramDataLineMsgRecord.path, paramDataLineMsgRecord.thumbPath, 1, paramDataLineMsgRecord.sessionid, paramDataLineMsgRecord.groupId, paramDataLineMsgRecord.groupSize, paramDataLineMsgRecord.groupIndex, true);
    }
    for (;;)
    {
      paramItemHolder.jdField_a_of_type_ComDatalineUtilFileDLFileInfo.jdField_a_of_type_Int = 0;
      return;
      localDataLineHandler.a(paramDataLineMsgRecord.path, paramDataLineMsgRecord.thumbPath, 0, paramDataLineMsgRecord.sessionid, paramDataLineMsgRecord.groupId, paramDataLineMsgRecord.groupSize, paramDataLineMsgRecord.groupIndex, true);
    }
  }
  
  public void a(long paramLong, ListView paramListView, float paramFloat)
  {
    if ((paramListView == null) || (paramLong == 0L)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
    int i = 0;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
        if ((localDataLineMsgRecord == null) || (localDataLineMsgRecord.sessionid != paramLong)) {}
      }
      else
      {
        paramListView = paramListView.getChildAt(i - paramListView.getFirstVisiblePosition());
        if ((paramListView == null) || (i >= this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount())) {
          break;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getItemBySessionId(paramLong);
        if (localObject == null) {
          break;
        }
        float f = paramFloat;
        if (paramFloat < ((DataLineMsgRecord)localObject).progress) {
          f = ((DataLineMsgRecord)localObject).progress;
        }
        localObject = (ProgressBar)paramListView.findViewById(2131366931);
        if (localObject != null) {
          ((ProgressBar)localObject).setProgress((int)(f * 100.0F));
        }
        paramListView = (TextView)paramListView.findViewById(2131366962);
        if (paramListView == null) {
          break;
        }
        i = (int)(f * 100.0F);
        paramListView.setText(String.valueOf(i) + "%");
        return;
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getComeCount() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt == getCount() - 1) {}
    for (int i = 1; i != 0; i = 0) {
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
    if (paramInt == getCount() - 1) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0) {
      return 1;
    }
    return 0;
  }
  
  @TargetApi(8)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i;
    if (paramInt == getCount() - 1)
    {
      i = 1;
      if (i != 0) {
        break label928;
      }
    }
    label648:
    label786:
    label928:
    for (Object localObject = (DataLineMsgRecord)getItem(paramInt);; localObject = null)
    {
      DatalineFilesAdapter.ItemHolder localItemHolder;
      label89:
      View localView;
      if (paramView == null)
      {
        localItemHolder = new DatalineFilesAdapter.ItemHolder(this);
        if (i != 0)
        {
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559116, null);
          localItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366403));
          localItemHolder.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView = ((WaitTextView)paramView.findViewById(2131366405));
          paramView.setTag(localItemHolder);
          localView = paramView;
          paramView = localItemHolder;
          label101:
          if (i == 0) {
            break label552;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getComeCount() != this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount()) {
            break label361;
          }
          localView.setVisibility(4);
          paramView.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.b();
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        i = 0;
        break;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559115, null);
        localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366947));
        localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.b);
        localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localItemHolder);
        localItemHolder.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366920));
        localItemHolder.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130844368);
        localItemHolder.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        localItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366957));
        localItemHolder.b = ((TextView)paramView.findViewById(2131366961));
        localItemHolder.c = ((TextView)paramView.findViewById(2131366962));
        localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366931));
        localItemHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131361939));
        localItemHolder.jdField_a_of_type_AndroidWidgetButton.setTag(localItemHolder);
        localItemHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        break label89;
        localItemHolder = (DatalineFilesAdapter.ItemHolder)paramView.getTag();
        localView = paramView;
        paramView = localItemHolder;
        break label101;
        label361:
        int j;
        if (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isTimeOut())
        {
          paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setVisibility(0);
          i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getComeCount();
          j = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount();
          localObject = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693798), new Object[] { Integer.valueOf(j - i) });
          paramView.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setWaitText((String)localObject);
          paramView.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.a();
        }
        else
        {
          paramView.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.b();
          paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setVisibility(0);
          i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getComeCount();
          j = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount();
          localObject = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693796), new Object[] { Integer.valueOf(i), Integer.valueOf(j - i) });
          paramView.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setWaitText((String)localObject);
          continue;
          label552:
          if (localObject != null) {
            break label576;
          }
          paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
        }
      }
      label576:
      paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramView.jdField_a_of_type_ComDatalineUtilFileDLFileInfo = a((DataLineMsgRecord)localObject);
      paramView.jdField_a_of_type_Int = ((DataLineMsgRecord)localObject).msgtype;
      if ((((DataLineMsgRecord)localObject).strMoloKey != null) && (((DataLineMsgRecord)localObject).bIsApkFile))
      {
        paramView.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130844368);
        paramView.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(((DataLineMsgRecord)localObject).strMoloIconUrl);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((DataLineMsgRecord)localObject).filename);
        paramView.b.setText(FileUtil.a(((DataLineMsgRecord)localObject).filesize));
        if ((((DataLineMsgRecord)localObject).progress != 1.0F) && (((DataLineMsgRecord)localObject).issuc) && (((DataLineMsgRecord)localObject).fileMsgStatus != 1L) && (((DataLineMsgRecord)localObject).fileMsgStatus != 2L)) {
          break label847;
        }
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramView.c.setVisibility(4);
        if ((((DataLineMsgRecord)localObject).issuc) && (((DataLineMsgRecord)localObject).fileMsgStatus != 1L) && (((DataLineMsgRecord)localObject).fileMsgStatus != 2L)) {
          break label786;
        }
        paramView.jdField_a_of_type_AndroidWidgetButton.setText(2131693808);
      }
      for (;;)
      {
        break;
        FileManagerUtil.a(paramView.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView, (DataLineMsgRecord)localObject);
        break label648;
        if (((DataLineMsgRecord)localObject).progress == 1.0F) {
          if ((((DataLineMsgRecord)localObject).strMoloKey == null) || (!((DataLineMsgRecord)localObject).bIsApkFile) || (((DataLineMsgRecord)localObject).nAppStatus == 1))
          {
            paramView.jdField_a_of_type_AndroidWidgetButton.setText(2131693795);
          }
          else
          {
            paramView.jdField_a_of_type_AndroidWidgetButton.setText(2131693777);
            continue;
            label847:
            paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            paramView.c.setVisibility(0);
            i = (int)(((DataLineMsgRecord)localObject).progress * 100.0F);
            paramView.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
            paramView.c.setText(String.valueOf(i) + "%");
            paramView.jdField_a_of_type_AndroidWidgetButton.setText(2131693799);
          }
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.util.DatalineFilesAdapter
 * JD-Core Version:    0.7.0.1
 */