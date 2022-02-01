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
  public View.OnClickListener a = new DatalineFilesAdapter.2(this);
  private DataLineMsgSet b;
  private LayoutInflater c;
  private Context d;
  private DLFilesViewerActivity e;
  private QQAppInterface f;
  private final int g = 2;
  private View.OnClickListener h = new DatalineFilesAdapter.1(this);
  
  public DatalineFilesAdapter(Context paramContext, DataLineMsgSet paramDataLineMsgSet, DLFilesViewerActivity paramDLFilesViewerActivity, QQAppInterface paramQQAppInterface)
  {
    this.d = paramContext;
    this.b = paramDataLineMsgSet;
    this.e = paramDLFilesViewerActivity;
    this.f = paramQQAppInterface;
    this.c = LayoutInflater.from(this.d);
  }
  
  public static DLFileInfo a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    DLFileInfo localDLFileInfo = new DLFileInfo();
    localDLFileInfo.d = paramDataLineMsgRecord.filename;
    localDLFileInfo.e = paramDataLineMsgRecord.filesize;
    localDLFileInfo.c = paramDataLineMsgRecord.path;
    localDLFileInfo.a = paramDataLineMsgRecord.sessionid;
    if (paramDataLineMsgRecord.fileMsgStatus == 0L)
    {
      if (!paramDataLineMsgRecord.issuc)
      {
        if (paramDataLineMsgRecord.isSendFromLocal())
        {
          localDLFileInfo.b = 1;
          return localDLFileInfo;
        }
        localDLFileInfo.b = 4;
        return localDLFileInfo;
      }
      if (paramDataLineMsgRecord.progress != 1.0F)
      {
        if (paramDataLineMsgRecord.isSendFromLocal())
        {
          localDLFileInfo.b = 0;
          return localDLFileInfo;
        }
        localDLFileInfo.b = 3;
        return localDLFileInfo;
      }
      localDLFileInfo.b = 5;
      return localDLFileInfo;
    }
    if (paramDataLineMsgRecord.fileMsgStatus == 2L)
    {
      if (paramDataLineMsgRecord.isSendFromLocal())
      {
        localDLFileInfo.b = 1;
        return localDLFileInfo;
      }
      localDLFileInfo.b = 4;
      return localDLFileInfo;
    }
    localDLFileInfo.b = 2;
    return localDLFileInfo;
  }
  
  private void a(DatalineFilesAdapter.ItemHolder paramItemHolder, DataLineMsgRecord paramDataLineMsgRecord)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.f.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (paramDataLineMsgRecord.strMoloKey != null) {
      localDataLineHandler.e(111);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramDataLineMsgRecord.sessionid));
    if (localDataLineHandler.b(localArrayList))
    {
      paramItemHolder.a.b = 3;
      paramDataLineMsgRecord.fileMsgStatus = 0L;
      int i = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
      this.f.getMessageFacade().d(i).f(paramDataLineMsgRecord.msgId);
      paramDataLineMsgRecord.issuc = true;
      return;
    }
    FMToastUtil.a(2131891335);
  }
  
  private void b(DatalineFilesAdapter.ItemHolder paramItemHolder, DataLineMsgRecord paramDataLineMsgRecord)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.f.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (paramItemHolder.b == 0) {
      localDataLineHandler.a(paramDataLineMsgRecord.path, paramDataLineMsgRecord.thumbPath, 1, paramDataLineMsgRecord.sessionid, paramDataLineMsgRecord.groupId, paramDataLineMsgRecord.groupSize, paramDataLineMsgRecord.groupIndex, true);
    } else {
      localDataLineHandler.a(paramDataLineMsgRecord.path, paramDataLineMsgRecord.thumbPath, 0, paramDataLineMsgRecord.sessionid, paramDataLineMsgRecord.groupId, paramDataLineMsgRecord.groupSize, paramDataLineMsgRecord.groupIndex, true);
    }
    paramItemHolder.a.b = 0;
  }
  
  private void b(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord.strMoloKey != null)
    {
      DataLineHandler localDataLineHandler = (DataLineHandler)this.f.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      if ((paramDataLineMsgRecord.bIsApkFile) && (paramDataLineMsgRecord.nAppStatus != 1))
      {
        localDataLineHandler.b(paramDataLineMsgRecord.strMoloKey);
        return;
      }
      int i = localDataLineHandler.c(paramDataLineMsgRecord.strMoloKey);
      if (i == 2)
      {
        FMToastUtil.a(2131889788);
        return;
      }
      if (i != 0) {
        FMToastUtil.a(2131891277);
      }
    }
    else
    {
      paramDataLineMsgRecord = paramDataLineMsgRecord.path;
      FileManagerUtil.a(this.e, paramDataLineMsgRecord);
    }
  }
  
  public void a(long paramLong, ListView paramListView, float paramFloat)
  {
    if (paramListView != null)
    {
      if (paramLong == 0L) {
        return;
      }
      int i = 0;
      Object localObject = this.b.values().iterator();
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
        if (i >= this.b.getTotalCount()) {
          return;
        }
        localObject = this.b.getItemBySessionId(paramLong);
        if (localObject == null) {
          return;
        }
        float f1 = paramFloat;
        if (paramFloat < ((DataLineMsgRecord)localObject).progress) {
          f1 = ((DataLineMsgRecord)localObject).progress;
        }
        localObject = (ProgressBar)paramListView.findViewById(2131433115);
        if (localObject != null) {
          ((ProgressBar)localObject).setProgress((int)(f1 * 100.0F));
        }
        paramListView = (TextView)paramListView.findViewById(2131433146);
        if (paramListView != null)
        {
          i = (int)(f1 * 100.0F);
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
    return this.b.getComeCount() + 1;
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
    return this.b.values().get(paramInt);
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
        paramView = this.c.inflate(2131624644, null);
        ((DatalineFilesAdapter.ItemHolder)localObject2).c = ((ImageView)paramView.findViewById(2131432586));
        ((DatalineFilesAdapter.ItemHolder)localObject2).d = ((WaitTextView)paramView.findViewById(2131432588));
      }
      else
      {
        paramView = this.c.inflate(2131624643, null);
        ((DatalineFilesAdapter.ItemHolder)localObject2).j = ((RelativeLayout)paramView.findViewById(2131433131));
        ((DatalineFilesAdapter.ItemHolder)localObject2).j.setOnClickListener(this.h);
        ((DatalineFilesAdapter.ItemHolder)localObject2).j.setTag(localObject2);
        ((DatalineFilesAdapter.ItemHolder)localObject2).e = ((AsyncImageView)paramView.findViewById(2131433104));
        ((DatalineFilesAdapter.ItemHolder)localObject2).e.setDefaultImage(2130845591);
        ((DatalineFilesAdapter.ItemHolder)localObject2).e.setIsDrawRound(false);
        ((DatalineFilesAdapter.ItemHolder)localObject2).f = ((TextView)paramView.findViewById(2131433141));
        ((DatalineFilesAdapter.ItemHolder)localObject2).g = ((TextView)paramView.findViewById(2131433145));
        ((DatalineFilesAdapter.ItemHolder)localObject2).h = ((TextView)paramView.findViewById(2131433146));
        ((DatalineFilesAdapter.ItemHolder)localObject2).i = ((ProgressBar)paramView.findViewById(2131433115));
        ((DatalineFilesAdapter.ItemHolder)localObject2).k = ((Button)paramView.findViewById(2131427499));
        ((DatalineFilesAdapter.ItemHolder)localObject2).k.setTag(localObject2);
        ((DatalineFilesAdapter.ItemHolder)localObject2).k.setOnClickListener(this.a);
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
      if (this.b.getComeCount() == this.b.getTotalCount())
      {
        localView.setVisibility(4);
        paramView.d.b();
      }
      else
      {
        int j;
        if (!this.b.isTimeOut())
        {
          paramView.c.setVisibility(8);
          paramView.d.setVisibility(0);
          i = this.b.getComeCount();
          j = this.b.getTotalCount();
          localObject1 = String.format(this.f.getApp().getString(2131891326), new Object[] { Integer.valueOf(j - i) });
          paramView.d.setWaitText((String)localObject1);
          paramView.d.a();
        }
        else
        {
          paramView.d.b();
          paramView.c.setVisibility(0);
          paramView.d.setVisibility(0);
          i = this.b.getComeCount();
          j = this.b.getTotalCount();
          localObject1 = String.format(this.f.getApp().getString(2131891324), new Object[] { Integer.valueOf(i), Integer.valueOf(j - i) });
          paramView.d.setWaitText((String)localObject1);
        }
      }
    }
    else if (localObject1 == null)
    {
      paramView.i.setVisibility(4);
      paramView.k.setVisibility(4);
    }
    else
    {
      paramView.i.setVisibility(0);
      paramView.k.setVisibility(0);
      paramView.a = a((DataLineMsgRecord)localObject1);
      paramView.b = ((DataLineMsgRecord)localObject1).msgtype;
      if ((((DataLineMsgRecord)localObject1).strMoloKey != null) && (((DataLineMsgRecord)localObject1).bIsApkFile))
      {
        paramView.e.setDefaultImage(2130845591);
        paramView.e.setAsyncImage(((DataLineMsgRecord)localObject1).strMoloIconUrl);
      }
      else
      {
        FileManagerUtil.a(paramView.e, (DataLineMsgRecord)localObject1);
      }
      paramView.f.setText(((DataLineMsgRecord)localObject1).filename);
      paramView.g.setText(FileUtil.a(((DataLineMsgRecord)localObject1).filesize));
      if ((((DataLineMsgRecord)localObject1).progress != 1.0F) && (((DataLineMsgRecord)localObject1).issuc) && (((DataLineMsgRecord)localObject1).fileMsgStatus != 1L) && (((DataLineMsgRecord)localObject1).fileMsgStatus != 2L))
      {
        paramView.i.setVisibility(0);
        paramView.h.setVisibility(0);
        i = (int)(((DataLineMsgRecord)localObject1).progress * 100.0F);
        paramView.i.setProgress(i);
        localObject1 = paramView.h;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(String.valueOf(i));
        ((StringBuilder)localObject2).append("%");
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        paramView.k.setText(2131891327);
      }
      else
      {
        paramView.i.setVisibility(4);
        paramView.h.setVisibility(4);
        if ((((DataLineMsgRecord)localObject1).issuc) && (((DataLineMsgRecord)localObject1).fileMsgStatus != 1L) && (((DataLineMsgRecord)localObject1).fileMsgStatus != 2L))
        {
          if (((DataLineMsgRecord)localObject1).progress == 1.0F) {
            if ((((DataLineMsgRecord)localObject1).strMoloKey != null) && (((DataLineMsgRecord)localObject1).bIsApkFile) && (((DataLineMsgRecord)localObject1).nAppStatus != 1)) {
              paramView.k.setText(2131891305);
            } else {
              paramView.k.setText(2131891323);
            }
          }
        }
        else {
          paramView.k.setText(2131891336);
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