package com.tencent.ilink.interfaces;

import android.util.Log;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.luggage.wxa.ar.a.a;
import com.tencent.luggage.wxa.ar.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public class ILinkAppImInterfaceService
{
  public static final int CONTACT_OPCODE_ADD = ILinkCallbackInterface.EnContactOpCode.CONTACT_ADD.toValue();
  public static final int CONTACT_OPCODE_DELETE = ILinkCallbackInterface.EnContactOpCode.CONTACT_DELETE.toValue();
  public static final int CONTACT_OPCODE_UPDATE = ILinkCallbackInterface.EnContactOpCode.CONTACT_UPDATE.toValue();
  private static final String TAG = "ILinkImInterfaceService";
  private static ILinkAppImInterfaceService instance;
  public IILinkCallback iILinkCallback;
  private TimerTask task;
  private Timer timer;
  
  public static ILinkAppImInterfaceService getInstance()
  {
    if (instance == null) {
      instance = new ILinkAppImInterfaceService();
    }
    return instance;
  }
  
  public static void setVoipAppid(String paramString)
  {
    ILinkAppImInterface.setVoipAppid(paramString);
  }
  
  public void cancelInterfaceTimer()
  {
    if (this.timer != null)
    {
      this.task.cancel();
      this.timer.cancel();
    }
  }
  
  public void cancelLogin() {}
  
  public void closeSdkAccount() {}
  
  public void deleteContactByIlinkId(String paramString)
  {
    ILinkAppImInterface.deleteContactByIlinkimId(paramString);
  }
  
  public ArrayList<a.a> getAllContacts()
  {
    Object localObject1 = ILinkAppImInterface.getAllContacts();
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAllContacts size:");
      ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
      Log.d("ILinkImInterfaceService", ((StringBuilder)localObject2).toString());
      try
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (byte[])((Iterator)localObject1).next();
          if (a.a.a((byte[])localObject2) != null)
          {
            localArrayList.add(a.a.a((byte[])localObject2));
            continue;
            Log.e("ILinkImInterfaceService", "contacts is null");
          }
        }
      }
      catch (InvalidProtocolBufferException localInvalidProtocolBufferException)
      {
        localInvalidProtocolBufferException.printStackTrace();
        return localArrayList;
      }
    }
    return localArrayList;
  }
  
  public ArrayList<a.c> getAllUnVerifyRequests()
  {
    Object localObject = ILinkAppImInterface.getAllUnVerifyRequests();
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      byte[] arrayOfByte = (byte[])((Iterator)localObject).next();
      try
      {
        localArrayList.add(a.c.a(arrayOfByte));
      }
      catch (InvalidProtocolBufferException localInvalidProtocolBufferException)
      {
        localInvalidProtocolBufferException.printStackTrace();
      }
    }
    return localArrayList;
  }
  
  public a.a getContactByIlinkimId(String paramString)
  {
    try
    {
      paramString = a.a.a(ILinkAppImInterface.getContactByIlinkimId(paramString));
      return paramString;
    }
    catch (InvalidProtocolBufferException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public int getDeviceShadow()
  {
    return ILinkAppImInterface.getDeviceShadow();
  }
  
  protected IILinkCallback getILinkCallback()
  {
    return this.iILinkCallback;
  }
  
  public void getImTicket(int paramInt)
  {
    ILinkAppImInterface.getImTicket(paramInt);
  }
  
  public Profile getProfile()
  {
    return Profile.pb2Profile(ILinkAppImInterface.getProfile());
  }
  
  public void getPublicAccountQrCode(int paramInt)
  {
    ILinkAppImInterface.getPublicAccountQrCode(paramInt);
  }
  
  public long getUin()
  {
    return ILinkAppImInterface.getUin();
  }
  
  public void handleContactVerifyRequest(String paramString, boolean paramBoolean)
  {
    ILinkAppImInterface.handleContactVerifyRequest(paramString, paramBoolean);
  }
  
  public void init(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    ILinkAppImInterface.init(paramString1, paramString2, paramBoolean2);
  }
  
  public void initContacts() {}
  
  public void login(int paramInt)
  {
    Log.v("ILinkImInterfaceService", "login");
    if (this.timer != null)
    {
      this.task.cancel();
      this.timer.cancel();
      this.timer = null;
    }
    this.timer = new Timer();
    this.task = new ILinkAppImInterfaceService.1(this);
    this.timer.schedule(this.task, paramInt * 1000);
    ILinkAppImInterface.login();
  }
  
  public void logout(boolean paramBoolean)
  {
    ILinkAppImInterface.logout(paramBoolean);
  }
  
  public void reportDataWithCacheKey(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    ILinkAppImInterface.reportDataWithCacheKey(paramString, paramArrayOfByte, paramInt);
  }
  
  public String sendImageMessage(String paramString, byte[] paramArrayOfByte)
  {
    return ILinkAppImInterface.sendImageMessage(paramString, paramArrayOfByte);
  }
  
  public String sendIotMessage(String paramString1, String paramString2, String paramString3)
  {
    return ILinkAppImInterface.sendIotMessage(paramString1, paramString2, paramString3);
  }
  
  public String sendTextMessage(String paramString1, String paramString2)
  {
    return ILinkAppImInterface.sendTextMessage(paramString1, paramString2);
  }
  
  public String sendVideoMessage(String paramString, byte[] paramArrayOfByte)
  {
    return ILinkAppImInterface.sendVideoMessage(paramString, paramArrayOfByte);
  }
  
  public void setILinkCallback(IILinkCallback paramIILinkCallback)
  {
    this.iILinkCallback = paramIILinkCallback;
  }
  
  public void startAutoSync(int paramInt)
  {
    ILinkAppImInterface.startAutoSync(paramInt);
  }
  
  public void uninit() {}
  
  public void updateAvatar(String paramString)
  {
    ILinkAppImInterface.updateAvatar(paramString);
  }
  
  public void updateContactAlias(String paramString1, String paramString2)
  {
    ILinkAppImInterface.updateContactAlias(paramString1, paramString2);
  }
  
  public int updateDeviceShadow(byte[] paramArrayOfByte)
  {
    return ILinkAppImInterface.updateDeviceShadow(paramArrayOfByte);
  }
  
  public void updateNickname(String paramString)
  {
    ILinkAppImInterface.updateNickname(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.interfaces.ILinkAppImInterfaceService
 * JD-Core Version:    0.7.0.1
 */