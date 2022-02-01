package com.tencent.livesdk.accountengine;

import android.content.Context;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.log.LogSdkServiceInterface;
import com.tencent.falco.base.libapi.login.LoginRequest;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.web.WebInterface;
import com.tencent.ilivesdk.avmediaservice_interface.AVMediaServiceInterface;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface;
import com.tencent.ilivesdk.coverservice_interface.CoverServiceInterface;
import com.tencent.ilivesdk.faceverifyservice_interface.FaceVerifyServiceInterface;
import com.tencent.ilivesdk.livestartcustomerconfigservice_interface.LiveStartCusConfServiceInterface;
import com.tencent.ilivesdk.startliveservice_interface.StartLiveServiceInterface;
import com.tencent.ilivesdk.userinfoservice_interface.UserInfoServiceInterface;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.livesdk.servicefactory.BaseEngine;
import com.tencent.livesdk.servicefactory.EnginServiceConfig;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.ServiceAccessorMgr;
import com.tencent.livesdk.servicefactory.ServiceEnginScope;
import com.tencent.livesdk.servicefactory.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UserEngine
  extends BaseEngine
  implements EnginServiceConfig
{
  private static final String TAG = "UserEngine";
  private Context context;
  private UserEngineLogic mUserEngineLogic;
  
  public UserEngine(Context paramContext, ServiceAccessor paramServiceAccessor)
  {
    this.context = paramContext;
    initServiceConfig();
    this.serviceManager = new ServiceManager(paramContext, paramServiceAccessor, this);
    this.mUserEngineLogic = new UserEngineLogic(paramContext, this.serviceManager);
    ServiceAccessorMgr.getInstance().setUserAccessor(this.serviceManager);
    preloadCoreComponents();
  }
  
  private void initServiceConfig()
  {
    if (this.scopeServices.size() > 0) {
      this.scopeServices.clear();
    }
    this.scopeServices.add(LoginServiceInterface.class);
    this.scopeServices.add(StartLiveServiceInterface.class);
    this.scopeServices.add(AVMediaServiceInterface.class);
    this.scopeServices.add(UserInfoServiceInterface.class);
    this.scopeServices.add(LogInterface.class);
    this.scopeServices.add(LogSdkServiceInterface.class);
    this.scopeServices.add(CoverServiceInterface.class);
    this.scopeServices.add(LiveStartCusConfServiceInterface.class);
    this.scopeServices.add(FaceVerifyServiceInterface.class);
    this.scopeServices.add(AVPreloadServiceInterface.class);
    initNewServiceScope(ServiceEnginScope.User);
  }
  
  private void preloadCoreComponents()
  {
    getService(ChannelInterface.class);
    getService(WebInterface.class);
  }
  
  public void addUserInitCallback(UserInitStateCallback paramUserInitStateCallback)
  {
    this.mUserEngineLogic.addUserInitCallback(paramUserInitStateCallback);
  }
  
  public boolean avInitFail()
  {
    return this.mUserEngineLogic.avInitFail();
  }
  
  public boolean avInitSuccess()
  {
    return this.mUserEngineLogic.avInitSuccess();
  }
  
  public RoomEngine createRoomEngine()
  {
    return new RoomEngine(this.context, this.serviceManager);
  }
  
  public void destroyRoomEngine()
  {
    this.mUserEngineLogic.destroyRoomEngine();
  }
  
  public RoomEngine getCurrentRoomEngine()
  {
    return this.mUserEngineLogic.getCurrentRoomEngine();
  }
  
  public UserEngineLogic getEnginLogic()
  {
    return this.mUserEngineLogic;
  }
  
  public LoginRequest getLoginRequest()
  {
    return this.mUserEngineLogic.getLoginRequest();
  }
  
  public String getOwnerEngine()
  {
    return "UserEngine";
  }
  
  public Set<Class> getScopeServices()
  {
    return this.scopeServices;
  }
  
  public <T extends ServiceBaseInterface> T getService(Class<? extends T> paramClass)
  {
    return this.serviceManager.getService(paramClass);
  }
  
  public void initLoginRequestData(LoginRequest paramLoginRequest)
  {
    this.mUserEngineLogic.initLoginRequestData(paramLoginRequest);
  }
  
  public boolean isLoginBusy()
  {
    return this.mUserEngineLogic.isLoginBusy();
  }
  
  public boolean loginFail()
  {
    return this.mUserEngineLogic.loginFail();
  }
  
  public boolean loginSuccess()
  {
    return this.mUserEngineLogic.loginSuccess();
  }
  
  public void removeUserInitCallback(UserInitStateCallback paramUserInitStateCallback)
  {
    this.mUserEngineLogic.removeUserInitCallback(paramUserInitStateCallback);
  }
  
  public void setCurrentRoomEngine(RoomEngine paramRoomEngine)
  {
    this.mUserEngineLogic.setCurrentRoomEngine(paramRoomEngine);
  }
  
  public void uninit()
  {
    destroyRoomEngine();
    if (this.serviceManager.getAllAvailableService().size() > 0)
    {
      Iterator localIterator = this.serviceManager.getAllAvailableService().values().iterator();
      while (localIterator.hasNext()) {
        ((ServiceBaseInterface)localIterator.next()).onDestroy();
      }
    }
    this.serviceManager.getAllAvailableService().clear();
    this.mUserEngineLogic.unInit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.accountengine.UserEngine
 * JD-Core Version:    0.7.0.1
 */