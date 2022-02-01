package com.tencent.ilive.base.component;

import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.imageloader.ImageLoaderInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.uicomponent.UIBaseAdapter;
import com.tencent.livesdk.liveengine.LiveEngine;

final class ComponentFactory$ComponentsBuilder$1
  implements UIBaseAdapter
{
  public HttpInterface getHttp()
  {
    return (HttpInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HttpInterface.class);
  }
  
  public ImageLoaderInterface getImageLoader()
  {
    return (ImageLoaderInterface)BizEngineMgr.getInstance().getLiveEngine().getService(ImageLoaderInterface.class);
  }
  
  public LogInterface getLog()
  {
    return (LogInterface)BizEngineMgr.getInstance().getLiveEngine().getService(LogInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.base.component.ComponentFactory.ComponentsBuilder.1
 * JD-Core Version:    0.7.0.1
 */