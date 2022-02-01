package com.tencent.livesdk.accountengine;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginRequest;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilivesdk.avmediaservice_interface.AVMediaServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.userinfoservice_interface.UserInfoServiceInterface;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.livesdk.servicefactory.BaseEnginLogic;
import com.tencent.livesdk.servicefactory.ServiceManager;
import java.util.ArrayList;
import java.util.List;

public class UserEngineLogic
  extends BaseEnginLogic
{
  private static final int AV_INIT_COMPLETED = 5;
  private static final int AV_INIT_FAIL = 4;
  private static final int LOGIN_STATE_BUSY = 1;
  private static final int LOGIN_STATE_FAIL = 2;
  private static final int LOGIN_STATE_SUCCESS = 3;
  private static final int STATE_INIT = -1;
  private static final String TAG = "UserEngineLogic";
  private RoomEngine currentRoomEngine;
  private EnterRoomInfo enterRoomInfo;
  private Context mContext;
  private LoginRequest mLoginRequest;
  private ServiceManager mServiceManager;
  private List<UserInitStateCallback> userInitCallbackList = new ArrayList();
  private int userInitState = -1;
  
  public UserEngineLogic(Context paramContext, ServiceManager paramServiceManager)
  {
    this.mContext = paramContext;
    this.mServiceManager = paramServiceManager;
  }
  
  private LogInterface log()
  {
    return (LogInterface)this.mServiceManager.getService(LogInterface.class);
  }
  
  private void reLogin(LoginRequest paramLoginRequest, SdkLoginCallback paramSdkLoginCallback)
  {
    auth(paramLoginRequest, new UserEngineLogic.4(this, paramSdkLoginCallback));
  }
  
  public void addUserInitCallback(UserInitStateCallback paramUserInitStateCallback)
  {
    this.userInitCallbackList.add(paramUserInitStateCallback);
  }
  
  public void auth(LoginRequest paramLoginRequest, SdkLoginCallback paramSdkLoginCallback)
  {
    ((UserInfoServiceInterface)this.mServiceManager.getService(UserInfoServiceInterface.class)).setSelfInfo(null);
    this.userInitState = 1;
    log().i("UserEngineLogic", "start login auth...", new Object[0]);
    ((LoginServiceInterface)this.mServiceManager.getService(LoginServiceInterface.class)).loginAuth(paramLoginRequest, new UserEngineLogic.1(this, paramLoginRequest, paramSdkLoginCallback));
  }
  
  public boolean avInitFail()
  {
    return this.userInitState == 4;
  }
  
  public boolean avInitSuccess()
  {
    return this.userInitState >= 5;
  }
  
  public void destroyRoomEngine()
  {
    RoomEngine localRoomEngine = this.currentRoomEngine;
    if (localRoomEngine != null) {
      localRoomEngine.unint();
    }
  }
  
  public RoomEngine getCurrentRoomEngine()
  {
    return this.currentRoomEngine;
  }
  
  public LoginRequest getLoginRequest()
  {
    return this.mLoginRequest;
  }
  
  public void initLoginRequestData(LoginRequest paramLoginRequest)
  {
    this.mLoginRequest = paramLoginRequest;
    ((LoginServiceInterface)this.mServiceManager.getService(LoginServiceInterface.class)).setBusinessUid(this.mLoginRequest.id);
  }
  
  public void initOpensdkAv()
  {
    ((AVMediaServiceInterface)this.mServiceManager.getService(AVMediaServiceInterface.class)).avInit(new UserEngineLogic.5(this));
  }
  
  public boolean isLoginBusy()
  {
    return this.userInitState == 1;
  }
  
  public void login(LoginRequest paramLoginRequest, SdkLoginCallback paramSdkLoginCallback)
  {
    if (this.userInitState == 1)
    {
      paramSdkLoginCallback.onFail(-1, "login busy");
      return;
    }
    RoomEngine localRoomEngine = this.currentRoomEngine;
    if ((localRoomEngine != null) && (localRoomEngine.isInRoom()))
    {
      this.enterRoomInfo = ((RoomServiceInterface)this.currentRoomEngine.getService(RoomServiceInterface.class)).getEnterRoomInfo();
      ((RoomServiceInterface)this.currentRoomEngine.getService(RoomServiceInterface.class)).exitRoom(new UserEngineLogic.2(this));
    }
    if (this.userInitState == 3)
    {
      ((LoginServiceInterface)this.mServiceManager.getService(LoginServiceInterface.class)).logout(new UserEngineLogic.3(this, paramLoginRequest, paramSdkLoginCallback));
      return;
    }
    auth(paramLoginRequest, paramSdkLoginCallback);
  }
  
  public boolean loginFail()
  {
    return this.userInitState == 2;
  }
  
  public boolean loginSuccess()
  {
    return (this.userInitState >= 3) && (((LoginServiceInterface)this.mServiceManager.getService(LoginServiceInterface.class)).getLoginInfo() != null);
  }
  
  public void removeUserInitCallback(UserInitStateCallback paramUserInitStateCallback)
  {
    this.userInitCallbackList.remove(paramUserInitStateCallback);
  }
  
  public void resetLoginState()
  {
    this.userInitState = -1;
  }
  
  public void setCurrentRoomEngine(RoomEngine paramRoomEngine)
  {
    this.currentRoomEngine = paramRoomEngine;
  }
  
  public void tryToRefreshLogin()
  {
    ((LoginServiceInterface)this.mServiceManager.getService(LoginServiceInterface.class)).tryToRefreshLogin(new UserEngineLogic.6(this));
  }
  
  public void unInit()
  {
    this.userInitState = -1;
    this.userInitCallbackList.clear();
  }
  
  public void updateAuthTicket(String paramString1, String paramString2)
  {
    Object localObject1 = log();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("updateAuthTicket-> id=");
    ((StringBuilder)localObject2).append(paramString1);
    ((LogInterface)localObject1).i("UserEngineLogic", ((StringBuilder)localObject2).toString(), new Object[0]);
    localObject1 = LoginRequest.getFromSp(this.mContext);
    if ((localObject1 != null) && (!TextUtils.isEmpty(((LoginRequest)localObject1).id)) && (!TextUtils.isEmpty(((LoginRequest)localObject1).token)))
    {
      if (!TextUtils.equals(paramString1, ((LoginRequest)localObject1).id))
      {
        localObject2 = log();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateAuthTicket-> Id has changed, oldId=");
        localStringBuilder.append(((LoginRequest)localObject1).id);
        localStringBuilder.append(", newId=");
        localStringBuilder.append(paramString1);
        ((LogInterface)localObject2).e("UserEngineLogic", localStringBuilder.toString(), new Object[0]);
      }
      if (TextUtils.equals(paramString2, ((LoginRequest)localObject1).token))
      {
        log().e("UserEngineLogic", "updateAuthTicket-> the token haven't change", new Object[0]);
        return;
      }
      ((LoginRequest)localObject1).id = paramString1;
      ((LoginRequest)localObject1).token = paramString2;
      ((LoginRequest)localObject1).flushToSp(this.mContext);
      ((ChannelInterface)this.mServiceManager.getService(ChannelInterface.class)).setAuthTicket(paramString1, paramString2);
      ((LoginServiceInterface)this.mServiceManager.getService(LoginServiceInterface.class)).setAuthTicket(paramString1, paramString2);
      return;
    }
    log().e("UserEngineLogic", "updateAuthTicket-> there haven't login", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.accountengine.UserEngineLogic
 * JD-Core Version:    0.7.0.1
 */