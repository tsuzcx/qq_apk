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
  private LayoutInflater b;
  
  private LiteMutiPicViewerActivity$GridAdapter(LiteMutiPicViewerActivity paramLiteMutiPicViewerActivity)
  {
    this.b = LayoutInflater.from(paramLiteMutiPicViewerActivity);
  }
  
  public int getCount()
  {
    int j = LiteMutiPicViewerActivity.a(this.a).getTotalCount();
    int k = j % 3;
    int i = j;
    if (k != 0) {
      i = j + (3 - k);
    }
    return i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt > LiteMutiPicViewerActivity.a(this.a).getTotalCount() - 1) {
      return null;
    }
    return LiteMutiPicViewerActivity.a(this.a).getAt(paramInt);
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
    if (paramInt > LiteMutiPicViewerActivity.a(this.a).getTotalCount() - 1) {
      return 1;
    }
    return 2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramInt == getCount() - 1)
    {
      if ((LiteMutiPicViewerActivity.a(this.a).getComeCount() != LiteMutiPicViewerActivity.a(this.a).getTotalCount()) && (!LiteMutiPicViewerActivity.a(this.a).isSendFromLocal()) && (!LiteMutiPicViewerActivity.a(this.a).hasSendingOrRecving()))
      {
        int i;
        int j;
        if (!LiteMutiPicViewerActivity.a(this.a).isTimeOut())
        {
          i = LiteMutiPicViewerActivity.a(this.a).getComeCount();
          j = LiteMutiPicViewerActivity.a(this.a).getTotalCount();
          localObject1 = String.format(this.a.app.getApp().getString(2131891314), new Object[] { Integer.valueOf(j), Integer.valueOf(j - i) });
          LiteMutiPicViewerActivity.c(this.a).setWaitText((String)localObject1);
          LiteMutiPicViewerActivity.c(this.a).a();
        }
        else
        {
          LiteMutiPicViewerActivity.c(this.a).b();
          i = LiteMutiPicViewerActivity.a(this.a).getComeCount();
          j = LiteMutiPicViewerActivity.a(this.a).getTotalCount();
          localObject1 = String.format(this.a.app.getApp().getString(2131891312), new Object[] { Integer.valueOf(j), Integer.valueOf(j - i) });
          LiteMutiPicViewerActivity.c(this.a).setWaitText((String)localObject1);
        }
      }
      else
      {
        LiteMutiPicViewerActivity.c(this.a).setWaitText(String.format(this.a.getString(2131891317), new Object[] { Integer.valueOf(LiteMutiPicViewerActivity.a(this.a).getTotalCount()) }));
        LiteMutiPicViewerActivity.c(this.a).b();
      }
      localObject1 = LiteMutiPicViewerActivity.c(this.a);
    }
    else
    {
      if (paramInt > LiteMutiPicViewerActivity.a(this.a).getTotalCount() - 1)
      {
        localObject1 = paramView;
        if (paramView == null)
        {
          localObject1 = new View(this.a);
          ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(LiteMutiPicViewerActivity.d(this.a), LiteMutiPicViewerActivity.e(this.a)));
          ((View)localObject1).setPadding(LiteMutiPicViewerActivity.f(this.a), LiteMutiPicViewerActivity.f(this.a), LiteMutiPicViewerActivity.f(this.a), LiteMutiPicViewerActivity.f(this.a));
        }
      }
      for (;;)
      {
        paramView = (View)localObject1;
        break;
        if (paramView == null)
        {
          localObject1 = new LiteMutiPicViewerActivity.ItemHolder(this.a);
          paramView = this.b.inflate(2131627029, null);
          ((LiteMutiPicViewerActivity.ItemHolder)localObject1).a = ((RelativeLayout)paramView.findViewById(2131434381));
          ((LiteMutiPicViewerActivity.ItemHolder)localObject1).c = paramView.findViewById(2131435380);
          ((LiteMutiPicViewerActivity.ItemHolder)localObject1).d = ((ImageView)paramView.findViewById(2131427336));
          ((LiteMutiPicViewerActivity.ItemHolder)localObject1).b = ((AsyncImageView)paramView.findViewById(2131435357));
          ((LiteMutiPicViewerActivity.ItemHolder)localObject1).b.setLayoutParams(new RelativeLayout.LayoutParams(LiteMutiPicViewerActivity.d(this.a), LiteMutiPicViewerActivity.e(this.a)));
          ((LiteMutiPicViewerActivity.ItemHolder)localObject1).b.setAdjustViewBounds(false);
          ((LiteMutiPicViewerActivity.ItemHolder)localObject1).b.setScaleType(ImageView.ScaleType.CENTER_CROP);
          ((LiteMutiPicViewerActivity.ItemHolder)localObject1).b.setDefaultColorDrawable(Color.parseColor("#C8C8C8"));
          ((LiteMutiPicViewerActivity.ItemHolder)localObject1).b.setIsDrawRound(false);
          ((LiteMutiPicViewerActivity.ItemHolder)localObject1).b.setAsyncClipSize(LiteMutiPicViewerActivity.d(this.a), LiteMutiPicViewerActivity.e(this.a));
          ((LiteMutiPicViewerActivity.ItemHolder)localObject1).a.setOnClickListener(this);
          ((LiteMutiPicViewerActivity.ItemHolder)localObject1).a.setTag(localObject1);
          paramView.setTag(localObject1);
        }
        else
        {
          localObject1 = (LiteMutiPicViewerActivity.ItemHolder)paramView.getTag();
        }
        Object localObject2 = LiteMutiPicViewerActivity.a(this.a).getAt(paramInt);
        ((LiteMutiPicViewerActivity.ItemHolder)localObject1).e = ((DataLineMsgRecord)localObject2);
        if ((localObject2 == null) || (((DataLineMsgRecord)localObject2).fileMsgStatus == 1L))
        {
          localObject2 = new ColorDrawable(Color.parseColor("#C8C8C8"));
          ((LiteMutiPicViewerActivity.ItemHolder)localObject1).b.setImageDrawable((Drawable)localObject2);
          ((LiteMutiPicViewerActivity.ItemHolder)localObject1).c.setVisibility(8);
          ((LiteMutiPicViewerActivity.ItemHolder)localObject1).d.setVisibility(8);
        }
        else
        {
          if ((((DataLineMsgRecord)localObject2).path != null) && (new VFSFile(((DataLineMsgRecord)localObject2).path).exists())) {
            ((LiteMutiPicViewerActivity.ItemHolder)localObject1).b.setAsyncImage(((DataLineMsgRecord)localObject2).path);
          } else if (((DataLineMsgRecord)localObject2).thumbPath != null) {
            ((LiteMutiPicViewerActivity.ItemHolder)localObject1).b.setAsyncImage(((DataLineMsgRecord)localObject2).thumbPath);
          }
          if ((!LiteMutiPicViewerActivity.a(this.a).hasSendingOrRecving()) && ((!((DataLineMsgRecord)localObject2).issuc) || (((DataLineMsgRecord)localObject2).fileMsgStatus != 0L)))
          {
            ((LiteMutiPicViewerActivity.ItemHolder)localObject1).c.setVisibility(0);
            ((LiteMutiPicViewerActivity.ItemHolder)localObject1).d.setVisibility(0);
          }
          else
          {
            ((LiteMutiPicViewerActivity.ItemHolder)localObject1).c.setVisibility(8);
            ((LiteMutiPicViewerActivity.ItemHolder)localObject1).d.setVisibility(8);
          }
        }
        localObject1 = paramView;
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void onClick(View paramView)
  {
    DataLineMsgRecord localDataLineMsgRecord1 = ((LiteMutiPicViewerActivity.ItemHolder)paramView.getTag()).e;
    if (localDataLineMsgRecord1 != null)
    {
      FileManagerEntity localFileManagerEntity = FileManagerUtil.a(localDataLineMsgRecord1);
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(10009);
      localForwardFileInfo.d(6);
      localForwardFileInfo.b(localFileManagerEntity.nSessionId);
      localForwardFileInfo.d(localDataLineMsgRecord1.filename);
      localForwardFileInfo.c(localDataLineMsgRecord1.sessionid);
      localForwardFileInfo.d(localDataLineMsgRecord1.filesize);
      localForwardFileInfo.a(localDataLineMsgRecord1.path);
      Intent localIntent = new Intent(this.a, FileBrowserActivity.class);
      if (localFileManagerEntity.nFileType == 0)
      {
        int i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord1.sessionid);
        Object localObject = this.a.app.getDataLineMsgProxy(i).c(localDataLineMsgRecord1.sessionid);
        if (localObject != null)
        {
          ArrayList localArrayList = new ArrayList();
          localObject = ((DataLineMsgSet)localObject).values().iterator();
          while (((Iterator)localObject).hasNext())
          {
            DataLineMsgRecord localDataLineMsgRecord2 = (DataLineMsgRecord)((Iterator)localObject).next();
            if ((localDataLineMsgRecord2.msgtype == -2000) || ((localDataLineMsgRecord2.msgtype == -2005) && (FileManagerUtil.c(localDataLineMsgRecord2.filename) == 0)) || ((localDataLineMsgRecord2.msgtype == -2335) && (localDataLineMsgRecord2.bIsMoloImage))) {
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
        this.a.startActivity(localIntent);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteMutiPicViewerActivity.GridAdapter
 * JD-Core Version:    0.7.0.1
 */