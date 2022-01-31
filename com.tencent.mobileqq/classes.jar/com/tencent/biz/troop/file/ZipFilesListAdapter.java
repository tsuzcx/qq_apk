package com.tencent.biz.troop.file;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.FileData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import java.util.List;
import owu;

public class ZipFilesListAdapter
  extends BaseAdapter
{
  public long a;
  public Activity a;
  LayoutInflater a;
  public String a;
  public List a;
  public long b;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public ZipFilesListAdapter(List paramList, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramActivity);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
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
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970038, null);
      paramView = new ZipFilesListAdapter.FilesViewHolder();
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131368724));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131368725));
      paramView.b = ((TextView)paramViewGroup.findViewById(2131368824));
      paramView.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131368825);
      paramViewGroup.setTag(paramView);
      paramViewGroup.setOnClickListener(new owu(this));
    }
    paramView = (ZipFilesListAdapter.FilesViewHolder)paramViewGroup.getTag();
    ZipFilePresenter.FileData localFileData = (ZipFilePresenter.FileData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localFileData.jdField_a_of_type_Boolean)
    {
      paramView.b.setText("文件夹");
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(localFileData.jdField_a_of_type_JavaLangString));
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130841569);
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterZipFilePresenter$FileData = localFileData;
      return paramViewGroup;
      paramView.b.setText(FileUtil.a(localFileData.jdField_a_of_type_Long));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(localFileData.jdField_a_of_type_JavaLangString));
      FileManagerUtil.a(paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileData.jdField_a_of_type_JavaLangString);
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (FileManagerUtil.a(localFileData.jdField_a_of_type_JavaLangString) == 0)
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        FileManagerEntity localFileManagerEntity = localQQAppInterface.a().b(localFileData.b);
        FileManagerUtil.b(paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
        localQQAppInterface.a().c(localFileManagerEntity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.file.ZipFilesListAdapter
 * JD-Core Version:    0.7.0.1
 */