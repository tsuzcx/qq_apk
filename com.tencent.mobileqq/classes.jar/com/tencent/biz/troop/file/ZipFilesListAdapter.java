package com.tencent.biz.troop.file;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.FileData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ZipFilesListAdapter
  extends BaseAdapter
{
  Activity a;
  List<ZipFilePresenter.FileData> b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public long h;
  public long i;
  private boolean j = false;
  private String k;
  private short l = 0;
  
  public ZipFilesListAdapter(List<ZipFilePresenter.FileData> paramList, Activity paramActivity)
  {
    this.b = paramList;
    this.a = paramActivity;
  }
  
  public void a(List<ZipFilePresenter.FileData> paramList)
  {
    this.b = paramList;
  }
  
  public void a(boolean paramBoolean, String paramString, short paramShort)
  {
    this.j = paramBoolean;
    this.k = paramString;
    this.l = paramShort;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a).inflate(2131627102, null);
      paramView = new ZipFilesListAdapter.FilesViewHolder();
      paramView.a = ((AsyncImageView)localView.findViewById(2131433129));
      paramView.b = ((TextView)localView.findViewById(2131433133));
      paramView.c = ((TextView)localView.findViewById(2131433136));
      paramView.d = localView.findViewById(2131444797);
      localView.setTag(paramView);
      localView.setOnClickListener(new ZipFilesListAdapter.1(this));
    }
    paramView = (ZipFilesListAdapter.FilesViewHolder)localView.getTag();
    ZipFilePresenter.FileData localFileData = (ZipFilePresenter.FileData)this.b.get(paramInt);
    if (localFileData.a)
    {
      paramView.c.setText(HardCodeUtil.a(2131913949));
      paramView.b.setText(FileManagerUtil.j(localFileData.c));
      paramView.a.setImageResource(2130845656);
      paramView.d.setVisibility(0);
    }
    else
    {
      paramView.c.setText(FileUtil.a(localFileData.b));
      paramView.b.setText(FileManagerUtil.j(localFileData.c));
      FileManagerUtil.a(paramView.a, localFileData.c);
      paramView.d.setVisibility(8);
      if (FileManagerUtil.c(localFileData.c) == 0)
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        FileManagerEntity localFileManagerEntity = localQQAppInterface.getFileManagerDataCenter().b(localFileData.d);
        localFileManagerEntity.isZipInnerFile = true;
        FileManagerUtil.b(paramView.a, localFileManagerEntity);
        localQQAppInterface.getFileManagerEngine().d(localFileManagerEntity);
      }
    }
    paramView.e = localFileData;
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.file.ZipFilesListAdapter
 * JD-Core Version:    0.7.0.1
 */