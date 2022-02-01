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
    if (QLog.isColorLevel()) {
      QLog.d("ViewPluginLoader", 2, "downloadUpdate loaded json = " + paramDownloadTask.c + " code = " + paramDownloadTask.jdField_a_of_type_Int);
    }
    boolean bool = this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b);
    if (QLog.isColorLevel()) {
      QLog.d("ViewPluginLoader", 2, "downloadUpdate unCompressOffline" + bool);
    }
    this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.a();
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    int i = (int)(paramDownloadTask.jdField_a_of_type_Float * 100.0F);
    if (((i % 10 == 0) || (i > 90)) && (QLog.isColorLevel())) {
      QLog.d("ViewPluginLoader", 2, "downding progress = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginLoader.4
 * JD-Core Version:    0.7.0.1
 */