package com.tencent.biz.qcircleshadow.local.pluginselector;

import com.tencent.biz.qcircleshadow.local.QCirclePluginUpdater;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QCirclePluginSelectorChain
{
  private List<IPluginSelectorProcess> a = new ArrayList();
  
  public QCirclePluginUpdater a()
  {
    Object localObject = null;
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      QCirclePluginUpdater localQCirclePluginUpdater = ((IPluginSelectorProcess)localIterator.next()).a();
      localObject = localQCirclePluginUpdater;
      if (localQCirclePluginUpdater != null) {
        localObject = localQCirclePluginUpdater;
      }
    }
    return localObject;
  }
  
  public QCirclePluginSelectorChain a(IPluginSelectorProcess paramIPluginSelectorProcess)
  {
    this.a.add(paramIPluginSelectorProcess);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.pluginselector.QCirclePluginSelectorChain
 * JD-Core Version:    0.7.0.1
 */