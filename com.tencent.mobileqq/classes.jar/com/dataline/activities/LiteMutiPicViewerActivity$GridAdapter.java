package com.dataline.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.dataline.util.widget.AsyncImageView;
import com.dataline.util.widget.WaitTextView;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

class LiteMutiPicViewerActivity$GridAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  private LiteMutiPicViewerActivity$GridAdapter(LiteMutiPicViewerActivity paramLiteMutiPicViewerActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramLiteMutiPicViewerActivity);
  }
  
  public int getCount()
  {
    int j = LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getTotalCount();
    int k = j % 3;
    int i = j;
    if (k != 0) {
      i = j + (3 - k);
    }
    return i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt > LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getTotalCount() - 1) {
      return null;
    }
    return LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getAt(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getCount() - 1) {
      return 0;
    }
    if (paramInt > LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getTotalCount() - 1) {
      return 1;
    }
    return 2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2;
    Object localObject1;
    if (paramInt == getCount() - 1) {
      if ((LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getComeCount() == LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getTotalCount()) || (LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).isSendFromLocal()) || (LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).hasSendingOrRecving()))
      {
        LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).setWaitText(String.format(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.getString(2131693789), new Object[] { Integer.valueOf(LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getTotalCount()) }));
        LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).b();
        localObject2 = LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity);
        localObject1 = paramView;
      }
    }
    for (paramView = (View)localObject2;; paramView = (View)localObject2)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
      if (!LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).isTimeOut())
      {
        i = LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getComeCount();
        j = LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getTotalCount();
        localObject1 = String.format(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.app.getApp().getString(2131693786), new Object[] { Integer.valueOf(j), Integer.valueOf(j - i) });
        LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).setWaitText((String)localObject1);
        LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).a();
        break;
      }
      LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).b();
      int i = LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getComeCount();
      int j = LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getTotalCount();
      localObject1 = String.format(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.app.getApp().getString(2131693784), new Object[] { Integer.valueOf(j), Integer.valueOf(j - i) });
      LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).setWaitText((String)localObject1);
      break;
      if (paramInt <= LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getTotalCount() - 1) {
        break label445;
      }
      localObject2 = paramView;
      if (paramView == null)
      {
        localObject2 = new View(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity);
        ((View)localObject2).setLayoutParams(new AbsListView.LayoutParams(LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity), LiteMutiPicViewerActivity.b(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity)));
        ((View)localObject2).setPadding(LiteMutiPicViewerActivity.c(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity), LiteMutiPicViewerActivity.c(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity), LiteMutiPicViewerActivity.c(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity), LiteMutiPicViewerActivity.c(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity));
      }
      localObject1 = localObject2;
    }
    label445:
    if (paramView == null)
    {
      localObject1 = new LiteMutiPicViewerActivity.ItemHolder(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560897, null);
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131368054));
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368746);
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131368729));
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setLayoutParams(new RelativeLayout.LayoutParams(LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity), LiteMutiPicViewerActivity.b(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity)));
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAdjustViewBounds(false);
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultColorDrawable(Color.parseColor("#C8C8C8"));
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity), LiteMutiPicViewerActivity.b(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity));
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject1);
      paramView.setTag(localObject1);
      localObject2 = LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getAt(paramInt);
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord = ((DataLineMsgRecord)localObject2);
      if (localObject2 != null) {
        break label731;
      }
    }
    label644:
    label731:
    while (((DataLineMsgRecord)localObject2).fileMsgStatus == 1L)
    {
      localObject2 = new ColorDrawable(Color.parseColor("#C8C8C8"));
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageDrawable((Drawable)localObject2);
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject1 = paramView;
      break;
      localObject1 = (LiteMutiPicViewerActivity.ItemHolder)paramView.getTag();
      break label644;
    }
    if ((((DataLineMsgRecord)localObject2).path != null) && (new VFSFile(((DataLineMsgRecord)localObject2).path).exists()))
    {
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(((DataLineMsgRecord)localObject2).path);
      label780:
      if ((LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).hasSendingOrRecving()) || ((((DataLineMsgRecord)localObject2).issuc) && (((DataLineMsgRecord)localObject2).fileMsgStatus == 0L))) {
        break label859;
      }
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      localObject1 = paramView;
      break;
      if (((DataLineMsgRecord)localObject2).thumbPath == null) {
        break label780;
      }
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(((DataLineMsgRecord)localObject2).thumbPath);
      break label780;
      label859:
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((LiteMutiPicViewerActivity.ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void onClick(View paramView)
  {
    DataLineMsgRecord localDataLineMsgRecord1 = ((LiteMutiPicViewerActivity.ItemHolder)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
    if (localDataLineMsgRecord1 == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      FileManagerEntity localFileManagerEntity = FileManagerUtil.a(localDataLineMsgRecord1);
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(10009);
      localForwardFileInfo.d(6);
      localForwardFileInfo.b(localFileManagerEntity.nSessionId);
      localForwardFileInfo.d(localDataLineMsgRecord1.filename);
      localForwardFileInfo.c(localDataLineMsgRecord1.sessionid);
      localForwardFileInfo.d(localDataLineMsgRecord1.filesize);
      localForwardFileInfo.a(localDataLineMsgRecord1.path);
      Intent localIntent = new Intent(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity, FileBrowserActivity.class);
      if (localFileManagerEntity.nFileType == 0)
      {
        int i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord1.sessionid);
        Object localObject = this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.app.getDataLineMsgProxy(i).a(localDataLineMsgRecord1.sessionid);
        if (localObject != null)
        {
          ArrayList localArrayList = new ArrayList();
          localObject = ((DataLineMsgSet)localObject).values().iterator();
          while (((Iterator)localObject).hasNext())
          {
            DataLineMsgRecord localDataLineMsgRecord2 = (DataLineMsgRecord)((Iterator)localObject).next();
            if ((localDataLineMsgRecord2.msgtype == -2000) || ((localDataLineMsgRecord2.msgtype == -2005) && (FileManagerUtil.a(localDataLineMsgRecord2.filename) == 0)) || ((localDataLineMsgRecord2.msgtype == -2335) && (localDataLineMsgRecord2.bIsMoloImage))) {
              if (localDataLineMsgRecord2 == localDataLineMsgRecord1) {
                localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
              } else {
                localArrayList.add(String.valueOf(FileManagerUtil.a(localDataLineMsgRecord2).nSessionId));
              }
            }
          }
          localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
        }
      }
      else
      {
        localIntent.putExtra("fileinfo", localForwardFileInfo);
        this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.startActivity(localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteMutiPicViewerActivity.GridAdapter
 * JD-Core Version:    0.7.0.1
 */