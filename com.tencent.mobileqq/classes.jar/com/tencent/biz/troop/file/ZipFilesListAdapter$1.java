package com.tencent.biz.troop.file;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.FileData;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ZipFilesListAdapter$1
  implements View.OnClickListener
{
  ZipFilesListAdapter$1(ZipFilesListAdapter paramZipFilesListAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject4 = (ZipFilesListAdapter.FilesViewHolder)paramView.getTag();
    Object localObject1;
    if (((ZipFilesListAdapter.FilesViewHolder)localObject4).a.jdField_a_of_type_Boolean)
    {
      localObject1 = new Intent(this.a.jdField_a_of_type_AndroidAppActivity, TroopFileZipPreviewActivity.class);
      ((Intent)localObject1).putExtra("str_download_dns", this.a.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("int32_server_port", this.a.jdField_b_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("string_download_url", this.a.c);
      ((Intent)localObject1).putExtra("str_cookie_val", this.a.d);
      ((Intent)localObject1).putExtra("filepath", this.a.e + ((ZipFilesListAdapter.FilesViewHolder)localObject4).a.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("filename", "" + ((ZipFilesListAdapter.FilesViewHolder)localObject4).a.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("nSessionId", this.a.jdField_b_of_type_Long);
      ((Intent)localObject1).putExtra("isHttps", ZipFilesListAdapter.a(this.a));
      if (!TextUtils.isEmpty(ZipFilesListAdapter.a(this.a))) {
        ((Intent)localObject1).putExtra("httpsDomain", ZipFilesListAdapter.a(this.a));
      }
      ((Intent)localObject1).putExtra("httpsPort", ZipFilesListAdapter.a(this.a));
      ((Intent)localObject1).putExtra("troop_uin", this.a.jdField_a_of_type_Long);
      this.a.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject1, 10099);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(((ZipFilesListAdapter.FilesViewHolder)localObject4).a.jdField_b_of_type_Long);
      localForwardFileInfo.d(((ZipFilesListAdapter.FilesViewHolder)localObject4).a.jdField_a_of_type_JavaLangString);
      localForwardFileInfo.d(((ZipFilesListAdapter.FilesViewHolder)localObject4).a.jdField_a_of_type_Long);
      localForwardFileInfo.b("");
      Object localObject3;
      Object localObject2;
      if (this.a.jdField_a_of_type_Long == 0L)
      {
        localObject3 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        Object localObject5 = ((QQAppInterface)localObject3).getFileManagerDataCenter().b(((ZipFilesListAdapter.FilesViewHolder)localObject4).a.jdField_b_of_type_Long);
        localObject2 = ((QQAppInterface)localObject3).getFileManagerDataCenter().e(((FileManagerEntity)localObject5).zipInnerPath);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = ((QQAppInterface)localObject3).getFileManagerRSCenter().a((String)((FileManagerEntity)localObject5).mContext, ((FileManagerEntity)localObject5).zipInnerPath);
        }
        if (localObject1 != null)
        {
          ((ZipFilesListAdapter.FilesViewHolder)localObject4).a.jdField_b_of_type_Long = ((FileManagerEntity)localObject1).nSessionId;
          ((FileManagerEntity)localObject1).isZipInnerFile = true;
        }
        localForwardFileInfo.b(((ZipFilesListAdapter.FilesViewHolder)localObject4).a.jdField_b_of_type_Long);
        if (localForwardFileInfo.d() == 0L)
        {
          FMToastUtil.a(HardCodeUtil.a(2131716865));
        }
        else
        {
          localObject4 = new ArrayList();
          localObject5 = this.a.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject5).hasNext())
          {
            ZipFilePresenter.FileData localFileData = (ZipFilePresenter.FileData)((Iterator)localObject5).next();
            if ((FileManagerUtil.a(localFileData.jdField_a_of_type_JavaLangString) == 0) && (localFileData.jdField_a_of_type_Long != 0L))
            {
              FileManagerEntity localFileManagerEntity = ((QQAppInterface)localObject3).getFileManagerDataCenter().b(localFileData.jdField_b_of_type_Long);
              localObject2 = ((QQAppInterface)localObject3).getFileManagerDataCenter().e(localFileManagerEntity.zipInnerPath);
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = ((QQAppInterface)localObject3).getFileManagerRSCenter().a((String)localFileManagerEntity.mContext, localFileManagerEntity.zipInnerPath);
              }
              if (localObject1 != null)
              {
                ((FileManagerEntity)localObject1).mContext = localFileManagerEntity.mContext;
                localFileData.jdField_b_of_type_Long = ((FileManagerEntity)localObject1).nSessionId;
              }
              ((ArrayList)localObject4).add(Long.valueOf(localFileData.jdField_b_of_type_Long));
            }
          }
          localForwardFileInfo.a((ArrayList)localObject4);
          localForwardFileInfo.d(1);
          localForwardFileInfo.b(10001);
          localObject1 = new Intent(this.a.jdField_a_of_type_AndroidAppActivity, FileBrowserActivity.class);
          ((Intent)localObject1).putExtra("fileinfo", localForwardFileInfo);
          ((Intent)localObject1).putExtra("last_time", 0);
          ((Intent)localObject1).putExtra("is_in_zip", true);
          this.a.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
        }
      }
      else
      {
        localObject1 = new ArrayList();
        localObject2 = this.a.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ZipFilePresenter.FileData)((Iterator)localObject2).next();
          if (FileManagerUtil.a(((ZipFilePresenter.FileData)localObject3).jdField_a_of_type_JavaLangString) == 0) {
            ((ArrayList)localObject1).add(Long.valueOf(((ZipFilePresenter.FileData)localObject3).jdField_b_of_type_Long));
          }
        }
        localForwardFileInfo.a((ArrayList)localObject1);
        localForwardFileInfo.d(4);
        localForwardFileInfo.b(10000);
        localObject1 = new Intent(this.a.jdField_a_of_type_AndroidAppActivity, TroopFileDetailBrowserActivity.class);
        ((Intent)localObject1).putExtra("fileinfo", localForwardFileInfo);
        ((Intent)localObject1).putExtra("forward_from_troop_file", true);
        ((Intent)localObject1).putExtra("not_forward", true);
        ((Intent)localObject1).putExtra("last_time", 0);
        ((Intent)localObject1).putExtra("is_in_zip", true);
        this.a.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.file.ZipFilesListAdapter.1
 * JD-Core Version:    0.7.0.1
 */