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
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ListView;
import cx;
import cy;
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
  private View.OnClickListener b = new cx(this);
  
  public DatalineFilesAdapter(Context paramContext, DataLineMsgSet paramDataLineMsgSet, DLFilesViewerActivity paramDLFilesViewerActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new cy(this);
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
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i).c(paramDataLineMsgRecord.msgId);
      paramDataLineMsgRecord.issuc = true;
      return;
    }
    FMToastUtil.a(2131427558);
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord.strMoloKey != null)
    {
      DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
      if ((!paramDataLineMsgRecord.bIsApkFile) || (paramDataLineMsgRecord.nAppStatus == 1))
      {
        int i = localDataLineHandler.a(paramDataLineMsgRecord.strMoloKey);
        if (i == 2) {
          FMToastUtil.a(2131428188);
        }
        while (i == 0) {
          return;
        }
        FMToastUtil.a(2131427527);
        return;
      }
      localDataLineHandler.c(paramDataLineMsgRecord.strMoloKey);
      return;
    }
    paramDataLineMsgRecord = paramDataLineMsgRecord.path;
    FileManagerUtil.b(this.jdField_a_of_type_ComDatalineActivitiesDLFilesViewerActivity, paramDataLineMsgRecord);
  }
  
  private void b(DatalineFilesAdapter.ItemHolder paramItemHolder, DataLineMsgRecord paramDataLineMsgRecord)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
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
        localObject = (ProgressBar)paramListView.findViewById(2131364117);
        if (localObject != null) {
          ((ProgressBar)localObject).setProgress((int)(f * 100.0F));
        }
        paramListView = (TextView)paramListView.findViewById(2131364116);
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
        break label886;
      }
    }
    label88:
    label94:
    label886:
    for (paramViewGroup = (DataLineMsgRecord)getItem(paramInt);; paramViewGroup = null)
    {
      DatalineFilesAdapter.ItemHolder localItemHolder;
      if (paramView == null)
      {
        localItemHolder = new DatalineFilesAdapter.ItemHolder(this);
        if (i != 0)
        {
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968877, null);
          localItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364131));
          localItemHolder.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView = ((WaitTextView)paramView.findViewById(2131364132));
          paramView.setTag(localItemHolder);
          if (i == 0) {
            break label519;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getComeCount() != this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount()) {
            break label331;
          }
          paramView.setVisibility(4);
          localItemHolder.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.b();
        }
      }
      do
      {
        return paramView;
        i = 0;
        break;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968876, null);
        localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131364111));
        localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.b);
        localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localItemHolder);
        localItemHolder.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131364112));
        localItemHolder.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130841584);
        localItemHolder.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        localItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364113));
        localItemHolder.b = ((TextView)paramView.findViewById(2131364115));
        localItemHolder.c = ((TextView)paramView.findViewById(2131364116));
        localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131364117));
        localItemHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131364130));
        localItemHolder.jdField_a_of_type_AndroidWidgetButton.setTag(localItemHolder);
        localItemHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        break label88;
        localItemHolder = (DatalineFilesAdapter.ItemHolder)paramView.getTag();
        break label94;
        if (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isTimeOut())
        {
          localItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          localItemHolder.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setVisibility(0);
          paramInt = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getComeCount();
          i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount();
          paramViewGroup = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131427588), new Object[] { Integer.valueOf(i - paramInt) });
          localItemHolder.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setWaitText(paramViewGroup);
          localItemHolder.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.a();
          return paramView;
        }
        localItemHolder.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.b();
        localItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localItemHolder.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setVisibility(0);
        paramInt = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getComeCount();
        i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount();
        paramViewGroup = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131427587), new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i - paramInt) });
        localItemHolder.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setWaitText(paramViewGroup);
        return paramView;
        if (paramViewGroup == null)
        {
          localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          localItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
          return paramView;
        }
        localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        localItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        localItemHolder.jdField_a_of_type_ComDatalineUtilFileDLFileInfo = a(paramViewGroup);
        localItemHolder.jdField_a_of_type_Int = paramViewGroup.msgtype;
        if ((paramViewGroup.strMoloKey != null) && (paramViewGroup.bIsApkFile))
        {
          localItemHolder.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130841584);
          localItemHolder.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramViewGroup.strMoloIconUrl);
        }
        for (;;)
        {
          localItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.filename);
          localItemHolder.b.setText(FileUtil.a(paramViewGroup.filesize));
          if ((paramViewGroup.progress != 1.0F) && (paramViewGroup.issuc) && (paramViewGroup.fileMsgStatus != 1L) && (paramViewGroup.fileMsgStatus != 2L)) {
            break label806;
          }
          localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          localItemHolder.c.setVisibility(4);
          if ((paramViewGroup.issuc) && (paramViewGroup.fileMsgStatus != 1L) && (paramViewGroup.fileMsgStatus != 2L)) {
            break;
          }
          localItemHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131427490);
          return paramView;
          FileManagerUtil.a(localItemHolder.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView, paramViewGroup);
        }
      } while (paramViewGroup.progress != 1.0F);
      if ((paramViewGroup.strMoloKey == null) || (!paramViewGroup.bIsApkFile) || (paramViewGroup.nAppStatus == 1))
      {
        localItemHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131427489);
        return paramView;
      }
      localItemHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131427581);
      return paramView;
      localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      localItemHolder.c.setVisibility(0);
      paramInt = (int)(paramViewGroup.progress * 100.0F);
      localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
      localItemHolder.c.setText(String.valueOf(paramInt) + "%");
      localItemHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131427491);
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.dataline.util.DatalineFilesAdapter
 * JD-Core Version:    0.7.0.1
 */