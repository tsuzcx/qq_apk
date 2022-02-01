package com.dataline.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import com.dataline.activities.LiteActivity;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.util.FilePathUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DatalineSessionAdapter$GridAdapter
  extends BaseAdapter
{
  public DataLineMsgSet a;
  public ItemHolder b;
  private int d;
  private int e;
  private AsyncImageView[] f = new AsyncImageView[3];
  
  private DatalineSessionAdapter$GridAdapter(DatalineSessionAdapter paramDatalineSessionAdapter, ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet, int paramInt)
  {
    this.b = paramItemHolder;
    this.a = paramDataLineMsgSet;
    this.d = paramInt;
    this.e = paramInt;
    b();
  }
  
  private void b()
  {
    int i = 0;
    while (i < 3)
    {
      this.f[i] = new AsyncImageView(this.c.c);
      this.f[i].setLayoutParams(new AbsListView.LayoutParams(this.d, this.e));
      this.f[i].setAdjustViewBounds(false);
      this.f[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.f[i].setDefaultImage(2130853415);
      this.f[i].setIsDrawRound(false);
      this.f[i].setAsyncClipSize(this.d, this.e);
      this.f[i].setTag(this.b);
      this.f[i].setClickable(true);
      this.f[i].setLongClickable(true);
      this.f[i].setOnClickListener(this.c.e);
      this.f[i].setOnLongClickListener(this.c.c.R);
      this.f[i].setOnTouchListener(this.c.c.S);
      this.f[i].setContentDescription(HardCodeUtil.a(2131900892));
      i += 1;
    }
  }
  
  public void a()
  {
    int i = 0;
    while (i < 3)
    {
      AsyncImageView localAsyncImageView = this.f[i];
      localAsyncImageView.setTag(this.b);
      DataLineMsgRecord localDataLineMsgRecord = this.a.getAt(i);
      if (localDataLineMsgRecord == null)
      {
        localAsyncImageView.setImageResource(2130853415);
      }
      else
      {
        String str = FilePathUtil.b(localDataLineMsgRecord.path);
        if ((str != null) && (new VFSFile(str).exists())) {
          localAsyncImageView.setAsyncImage(str);
        } else if (localDataLineMsgRecord.thumbPath != null) {
          localAsyncImageView.setAsyncImage(localDataLineMsgRecord.thumbPath);
        }
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    return 3;
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.getAt(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramInt >= 3)
    {
      localObject = null;
    }
    else
    {
      AsyncImageView localAsyncImageView = this.f[paramInt];
      localAsyncImageView.setTag(this.b);
      DataLineMsgRecord localDataLineMsgRecord = this.a.getAt(paramInt);
      if (localDataLineMsgRecord == null)
      {
        localAsyncImageView.setImageResource(2130853415);
        localObject = localAsyncImageView;
      }
      else
      {
        localObject = FilePathUtil.b(localDataLineMsgRecord.path);
        if ((localObject != null) && (new VFSFile((String)localObject).exists()))
        {
          localAsyncImageView.setAsyncImage((String)localObject);
          localObject = localAsyncImageView;
        }
        else
        {
          localObject = localAsyncImageView;
          if (localDataLineMsgRecord.thumbPath != null)
          {
            localAsyncImageView.setAsyncImage(localDataLineMsgRecord.thumbPath);
            localObject = localAsyncImageView;
          }
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.DatalineSessionAdapter.GridAdapter
 * JD-Core Version:    0.7.0.1
 */