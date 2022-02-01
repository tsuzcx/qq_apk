package com.tencent.comic.api;

import android.app.Application;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={"", "tool"})
public abstract interface IQQComicService
  extends IRuntimeService
{
  public abstract void beforeLaunchPlugin();
  
  public abstract AppRuntime createComicRuntime(Application paramApplication, String paramString);
  
  public abstract void startUp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.comic.api.IQQComicService
 * JD-Core Version:    0.7.0.1
 */