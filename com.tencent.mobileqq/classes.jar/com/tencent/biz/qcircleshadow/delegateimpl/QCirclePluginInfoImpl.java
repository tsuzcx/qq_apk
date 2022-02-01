package com.tencent.biz.qcircleshadow.delegateimpl;

import com.tencent.biz.qcircleshadow.lib.delegate.IPluginInfoDelegate;
import com.tencent.biz.qcircleshadow.local.QCirclePluginEnterManger;
import com.tencent.biz.qcircleshadow.local.QCirclePluginSelector;
import com.tencent.biz.qcircleshadow.local.QCircleSampleInfo;
import com.tencent.biz.qcircleshadow.local.QCircleShadow;
import java.util.List;

public class QCirclePluginInfoImpl
  implements IPluginInfoDelegate
{
  public List<String> getAllPluginInitInfo()
  {
    return QCirclePluginSelector.a().a();
  }
  
  public String getCurrentPluginInfo()
  {
    if ((QCircleShadow.a().a() != null) && (QCircleShadow.a().a().getPluginInfo() != null)) {
      return QCircleShadow.a().a().getPluginInfo().toString();
    }
    return "";
  }
  
  public int getCurrentPluginVersion()
  {
    if ((QCircleShadow.a().a() != null) && (QCircleShadow.a().a().getPluginInfo() != null)) {
      return QCircleShadow.a().a().getPluginInfo().b();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.delegateimpl.QCirclePluginInfoImpl
 * JD-Core Version:    0.7.0.1
 */