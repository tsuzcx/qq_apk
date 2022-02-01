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
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560844, null);
      paramView = new ZipFilesListAdapter.FilesViewHolder();
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localView.findViewById(2131366807));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131366811));
      paramView.b = ((TextView)localView.findViewById(2131366814));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131376547);
      localView.setTag(paramView);
      localView.setOnClickListener(new ZipFilesListAdapter.1(this));
    }
    paramView = (ZipFilesListAdapter.FilesViewHolder)localView.getTag();
    ZipFilePresenter.FileData localFileData = (ZipFilePresenter.FileData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localFileData.jdField_a_of_type_Boolean)
    {
      paramView.b.setText(HardCodeUtil.a(2131716516));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.c(localFileData.jdField_a_of_type_JavaLangString));
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130844339);
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    else
    {
      paramView.b.setText(FileUtil.a(localFileData.jdField_a_of_type_Long));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.c(localFileData.jdField_a_of_type_JavaLangString));
      FileManagerUtil.a(paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileData.jdField_a_of_type_JavaLangString);
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (FileManagerUtil.a(localFileData.jdField_a_of_type_JavaLangString) == 0)
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        FileManagerEntity localFileManagerEntity = localQQAppInterface.getFileManagerDataCenter().b(localFileData.b);
        localFileManagerEntity.isZipInnerFile = true;
        FileManagerUtil.b(paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
        localQQAppInterface.getFileManagerEngine().c(localFileManagerEntity);
      }
    }
    paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterZipFilePresenter$FileData = localFileData;
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.file.ZipFilesListAdapter
 * JD-Core Version:    0.7.0.1
 */