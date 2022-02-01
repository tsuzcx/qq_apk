package com.tencent.biz.troop.file;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserParam;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.FileData;
import com.tencent.mobileqq.filemanager.openbrowser.FileBrowserParam;
import com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
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
    Object localObject3 = (ZipFilesListAdapter.FilesViewHolder)paramView.getTag();
    Object localObject1;
    Object localObject2;
    if (((ZipFilesListAdapter.FilesViewHolder)localObject3).a.jdField_a_of_type_Boolean)
    {
      localObject1 = new Intent(this.a.jdField_a_of_type_AndroidAppActivity, TroopFileZipPreviewActivity.class);
      ((Intent)localObject1).putExtra("str_download_dns", this.a.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("int32_server_port", this.a.jdField_b_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("string_download_url", this.a.c);
      ((Intent)localObject1).putExtra("str_cookie_val", this.a.d);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a.e);
      ((StringBuilder)localObject2).append(((ZipFilesListAdapter.FilesViewHolder)localObject3).a.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("filepath", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(((ZipFilesListAdapter.FilesViewHolder)localObject3).a.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("filename", ((StringBuilder)localObject2).toString());
      ((Intent)localObject1).putExtra("nSessionId", this.a.jdField_b_of_type_Long);
      ((Intent)localObject1).putExtra("isHttps", ZipFilesListAdapter.a(this.a));
      if (!TextUtils.isEmpty(ZipFilesListAdapter.a(this.a))) {
        ((Intent)localObject1).putExtra("httpsDomain", ZipFilesListAdapter.a(this.a));
      }
      ((Intent)localObject1).putExtra("httpsPort", ZipFilesListAdapter.a(this.a));
      ((Intent)localObject1).putExtra("troop_uin", this.a.jdField_a_of_type_Long);
      this.a.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject1, 10099);
    }
    else
    {
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(((ZipFilesListAdapter.FilesViewHolder)localObject3).a.jdField_b_of_type_Long);
      localForwardFileInfo.d(((ZipFilesListAdapter.FilesViewHolder)localObject3).a.jdField_a_of_type_JavaLangString);
      localForwardFileInfo.d(((ZipFilesListAdapter.FilesViewHolder)localObject3).a.jdField_a_of_type_Long);
      localForwardFileInfo.b("");
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      Object localObject4;
      if (this.a.jdField_a_of_type_Long == 0L)
      {
        localObject4 = localQQAppInterface.getFileManagerDataCenter().b(((ZipFilesListAdapter.FilesViewHolder)localObject3).a.jdField_b_of_type_Long);
        localObject2 = localQQAppInterface.getFileManagerDataCenter().e(((FileManagerEntity)localObject4).zipInnerPath);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = localQQAppInterface.getFileManagerRSCenter().a((String)((FileManagerEntity)localObject4).mContext, ((FileManagerEntity)localObject4).zipInnerPath);
        }
        if (localObject1 != null)
        {
          ((ZipFilesListAdapter.FilesViewHolder)localObject3).a.jdField_b_of_type_Long = ((FileManagerEntity)localObject1).nSessionId;
          ((FileManagerEntity)localObject1).isZipInnerFile = true;
        }
        localForwardFileInfo.b(((ZipFilesListAdapter.FilesViewHolder)localObject3).a.jdField_b_of_type_Long);
        if (localForwardFileInfo.d() == 0L)
        {
          FMToastUtil.a(HardCodeUtil.a(2131716515));
        }
        else if ((localObject1 != null) && (((FileManagerEntity)localObject1).nFileType != 0) && (((FileManagerEntity)localObject1).nFileType != 2))
        {
          localObject1 = new FileModelAdapter(localQQAppInterface, (FileManagerEntity)localObject1);
          localObject2 = new FileBrowserParam().a(7);
          ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(this.a.jdField_a_of_type_AndroidAppActivity, (IFileBrowserModel)localObject1, (IFileBrowserParam)localObject2);
        }
        else
        {
          localObject3 = new ArrayList();
          localObject4 = this.a.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            ZipFilePresenter.FileData localFileData = (ZipFilePresenter.FileData)((Iterator)localObject4).next();
            if ((FileManagerUtil.a(localFileData.jdField_a_of_type_JavaLangString) == 0) && (localFileData.jdField_a_of_type_Long != 0L))
            {
              FileManagerEntity localFileManagerEntity = localQQAppInterface.getFileManagerDataCenter().b(localFileData.jdField_b_of_type_Long);
              localObject2 = localQQAppInterface.getFileManagerDataCenter().e(localFileManagerEntity.zipInnerPath);
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = localQQAppInterface.getFileManagerRSCenter().a((String)localFileManagerEntity.mContext, localFileManagerEntity.zipInnerPath);
              }
              if (localObject1 != null)
              {
                ((FileManagerEntity)localObject1).mContext = localFileManagerEntity.mContext;
                localFileData.jdField_b_of_type_Long = ((FileManagerEntity)localObject1).nSessionId;
              }
              ((ArrayList)localObject3).add(Long.valueOf(localFileData.jdField_b_of_type_Long));
            }
          }
          localForwardFileInfo.a((ArrayList)localObject3);
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
          localObject4 = (ZipFilePresenter.FileData)((Iterator)localObject2).next();
          if (FileManagerUtil.a(((ZipFilePresenter.FileData)localObject4).jdField_a_of_type_JavaLangString) == 0) {
            ((ArrayList)localObject1).add(Long.valueOf(((ZipFilePresenter.FileData)localObject4).jdField_b_of_type_Long));
          }
        }
        localForwardFileInfo.a((ArrayList)localObject1);
        localObject1 = localQQAppInterface.getFileManagerDataCenter().a(((ZipFilesListAdapter.FilesViewHolder)localObject3).a.jdField_b_of_type_Long);
        if ((localObject1 != null) && (((FileManagerEntity)localObject1).nFileType != 0) && (((FileManagerEntity)localObject1).nFileType != 2))
        {
          localObject1 = new FileModelAdapter(localQQAppInterface, (FileManagerEntity)localObject1, 2);
          localObject2 = new FileBrowserParam().a(7);
          ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(this.a.jdField_a_of_type_AndroidAppActivity, (IFileBrowserModel)localObject1, (IFileBrowserParam)localObject2);
        }
        else
        {
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
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.file.ZipFilesListAdapter.1
 * JD-Core Version:    0.7.0.1
 */