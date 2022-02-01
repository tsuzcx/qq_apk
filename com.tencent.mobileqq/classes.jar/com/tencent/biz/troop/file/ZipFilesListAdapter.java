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
  public long a;
  Activity jdField_a_of_type_AndroidAppActivity;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public String a;
  List<ZipFilePresenter.FileData> jdField_a_of_type_JavaUtilList;
  private short jdField_a_of_type_Short = 0;
  private boolean jdField_a_of_type_Boolean = false;
  public long b;
  public String b;
  public String c;
  public String d;
  public String e;
  private String f;
  
  public ZipFilesListAdapter(List<ZipFilePresenter.FileData> paramList, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramActivity);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(List<ZipFilePresenter.FileData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean, String paramString, short paramShort)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.f = paramString;
    this.jdField_a_of_type_Short = paramShort;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
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
    ZipFilesListAdapter.FilesViewHolder localFilesViewHolder;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560969, null);
      localFilesViewHolder = new ZipFilesListAdapter.FilesViewHolder();
      localFilesViewHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366945));
      localFilesViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366949));
      localFilesViewHolder.b = ((TextView)paramView.findViewById(2131366952));
      localFilesViewHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131377069);
      paramView.setTag(localFilesViewHolder);
      paramView.setOnClickListener(new ZipFilesListAdapter.1(this));
    }
    for (;;)
    {
      localFilesViewHolder = (ZipFilesListAdapter.FilesViewHolder)paramView.getTag();
      ZipFilePresenter.FileData localFileData = (ZipFilePresenter.FileData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localFileData.jdField_a_of_type_Boolean)
      {
        localFilesViewHolder.b.setText(HardCodeUtil.a(2131716866));
        localFilesViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(localFileData.jdField_a_of_type_JavaLangString));
        localFilesViewHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130844434);
        localFilesViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      for (;;)
      {
        localFilesViewHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterZipFilePresenter$FileData = localFileData;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localFilesViewHolder.b.setText(FileUtil.a(localFileData.jdField_a_of_type_Long));
        localFilesViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(localFileData.jdField_a_of_type_JavaLangString));
        FileManagerUtil.a(localFilesViewHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileData.jdField_a_of_type_JavaLangString);
        localFilesViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        if (FileManagerUtil.a(localFileData.jdField_a_of_type_JavaLangString) == 0)
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          FileManagerEntity localFileManagerEntity = localQQAppInterface.getFileManagerDataCenter().b(localFileData.b);
          localFileManagerEntity.isZipInnerFile = true;
          FileManagerUtil.b(localFilesViewHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
          localQQAppInterface.getFileManagerEngine().c(localFileManagerEntity);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.file.ZipFilesListAdapter
 * JD-Core Version:    0.7.0.1
 */