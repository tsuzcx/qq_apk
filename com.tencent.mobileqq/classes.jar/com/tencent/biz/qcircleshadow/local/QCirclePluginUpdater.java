package com.tencent.biz.qcircleshadow.local;

import com.tencent.biz.qcircleshadow.local.util.ThreadManagerExecutor;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class QCirclePluginUpdater
  implements PluginManagerUpdater
{
  private QCircleSampleInfo jdField_a_of_type_ComTencentBizQcircleshadowLocalQCircleSampleInfo;
  private File jdField_a_of_type_JavaIoFile;
  
  public QCirclePluginUpdater(QCircleSampleInfo paramQCircleSampleInfo)
  {
    if (paramQCircleSampleInfo != null)
    {
      this.jdField_a_of_type_ComTencentBizQcircleshadowLocalQCircleSampleInfo = paramQCircleSampleInfo;
      this.jdField_a_of_type_JavaIoFile = new File(this.jdField_a_of_type_ComTencentBizQcircleshadowLocalQCircleSampleInfo.b());
    }
  }
  
  public QCircleSampleInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizQcircleshadowLocalQCircleSampleInfo;
  }
  
  public File getLatest()
  {
    return this.jdField_a_of_type_JavaIoFile;
  }
  
  public Future<Boolean> isAvailable(File paramFile)
  {
    return ThreadManagerExecutor.a(16).submit(new QCirclePluginUpdater.2(this, paramFile));
  }
  
  public Future<File> update()
  {
    return ThreadManagerExecutor.a(16).submit(new QCirclePluginUpdater.1(this));
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCirclePluginUpdater
 * JD-Core Version:    0.7.0.1
 */