package com.tencent.biz.qcircleshadow.lib;

import com.tencent.biz.qcircleshadow.lib.delegate.IApplicationDelegate;
import com.tencent.biz.qcircleshadow.lib.delegate.IDaTongReportDelegate;
import com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate;
import com.tencent.biz.qcircleshadow.lib.delegate.ILogDelegate;
import com.tencent.biz.qcircleshadow.lib.delegate.IPluginInfoDelegate;
import com.tencent.biz.qcircleshadow.lib.delegate.IToastDelegate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class QCircleInitInject
{
  private static QCircleInitInject mInstance;
  private IApplicationDelegate mApp;
  private IDaTongReportDelegate mIDaTongReportDelegate;
  private IToastDelegate mIToastDelegate;
  private ILogDelegate mLogDelegate;
  private List<WeakReference<ILoadPluginDelegate>> mPluginCallbacks = new ArrayList();
  private IPluginInfoDelegate mPluginInfoDelegate;
  
  public static QCircleInitInject g()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new QCircleInitInject();
      }
      QCircleInitInject localQCircleInitInject = mInstance;
      return localQCircleInitInject;
    }
    finally {}
  }
  
  public IApplicationDelegate getApp()
  {
    return this.mApp;
  }
  
  public IDaTongReportDelegate getDaTongReportDelegate()
  {
    return this.mIDaTongReportDelegate;
  }
  
  public ILogDelegate getLogDelegate()
  {
    return this.mLogDelegate;
  }
  
  public List<WeakReference<ILoadPluginDelegate>> getPluginCallbacks()
  {
    return this.mPluginCallbacks;
  }
  
  public IPluginInfoDelegate getPluginInfo()
  {
    return this.mPluginInfoDelegate;
  }
  
  public IToastDelegate getToastDelegate()
  {
    return this.mIToastDelegate;
  }
  
  public QCircleInitInject injectApp(IApplicationDelegate paramIApplicationDelegate)
  {
    this.mApp = paramIApplicationDelegate;
    return this;
  }
  
  public QCircleInitInject injectDaTongReportDelegate(IDaTongReportDelegate paramIDaTongReportDelegate)
  {
    this.mIDaTongReportDelegate = paramIDaTongReportDelegate;
    return this;
  }
  
  public QCircleInitInject injectLogDelegate(ILogDelegate paramILogDelegate)
  {
    this.mLogDelegate = paramILogDelegate;
    return this;
  }
  
  public QCircleInitInject injectPluginCallback(ILoadPluginDelegate paramILoadPluginDelegate)
  {
    if (paramILoadPluginDelegate != null) {
      this.mPluginCallbacks.add(new WeakReference(paramILoadPluginDelegate));
    }
    return this;
  }
  
  public QCircleInitInject injectPluginInfoDelegate(IPluginInfoDelegate paramIPluginInfoDelegate)
  {
    this.mPluginInfoDelegate = paramIPluginInfoDelegate;
    return this;
  }
  
  public QCircleInitInject injectToastDelegate(IToastDelegate paramIToastDelegate)
  {
    this.mIToastDelegate = paramIToastDelegate;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleInitInject
 * JD-Core Version:    0.7.0.1
 */