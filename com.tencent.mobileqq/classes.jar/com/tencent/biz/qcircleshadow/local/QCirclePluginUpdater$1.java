package com.tencent.biz.qcircleshadow.local;

import java.io.File;
import java.util.concurrent.Callable;

class QCirclePluginUpdater$1
  implements Callable<File>
{
  QCirclePluginUpdater$1(QCirclePluginUpdater paramQCirclePluginUpdater) {}
  
  public File a()
  {
    if ((QCirclePluginUpdater.a(this.a) != null) && (QCirclePluginUpdater.a(this.a).exists())) {
      return QCirclePluginUpdater.a(this.a);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCirclePluginUpdater.1
 * JD-Core Version:    0.7.0.1
 */