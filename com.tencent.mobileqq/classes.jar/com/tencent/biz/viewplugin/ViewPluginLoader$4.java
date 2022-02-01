package com.tencent.biz.viewplugin;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class ViewPluginLoader$4
  extends DownloadListener
{
  ViewPluginLoader$4(ViewPluginLoader paramViewPluginLoader, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadUpdate loaded json = ");
      localStringBuilder.append(paramDownloadTask.c);
      localStringBuilder.append(" code = ");
      localStringBuilder.append(paramDownloadTask.jdField_a_of_type_Int);
      QLog.d("ViewPluginLoader", 2, localStringBuilder.toString());
    }
    boolean bool = this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b);
    if (QLog.isColorLevel())
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("downloadUpdate unCompressOffline");
      paramDownloadTask.append(bool);
      QLog.d("ViewPluginLoader", 2, paramDownloadTask.toString());
    }
    this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.a();
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    int i = (int)(paramDownloadTask.jdField_a_of_type_Float * 100.0F);
    if (((i % 10 == 0) || (i > 90)) && (QLog.isColorLevel()))
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("downding progress = ");
      paramDownloadTask.append(i);
      QLog.d("ViewPluginLoader", 2, paramDownloadTask.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginLoader.4
 * JD-Core Version:    0.7.0.1
 */