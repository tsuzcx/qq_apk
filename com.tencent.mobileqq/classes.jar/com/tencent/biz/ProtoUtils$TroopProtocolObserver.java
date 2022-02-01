package com.tencent.biz;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public abstract class ProtoUtils$TroopProtocolObserver
  implements BusinessObserver
{
  public static final int ERROR_GENERAL = -1;
  public static final int PB_OBSERVER = 2;
  public static final int SSO_OBSERVER = 1;
  public WeakReference<AppRuntime> mApp = new WeakReference(null);
  public boolean mIsOnUIThread;
  public int mType = 1;
  
  public ProtoUtils$TroopProtocolObserver()
  {
    this.mIsOnUIThread = true;
  }
  
  public ProtoUtils$TroopProtocolObserver(boolean paramBoolean)
  {
    this.mIsOnUIThread = paramBoolean;
  }
  
  private void onReceiveReal(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean)
    {
      onResult(-1, null, paramBundle);
      return;
    }
    Object localObject = paramBundle.getByteArray("data");
    paramInt = this.mType;
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg;
    if (paramInt == 1) {
      localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      localObject = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom((byte[])localObject);
      if ((((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get() != 0) && (onError(((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get(), ((oidb_sso.OIDBSSOPkg)localObject).str_error_msg.get(), paramBundle))) {
        return;
      }
      if ((((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() != null))
      {
        onResult(((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get(), ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray(), paramBundle);
        return;
      }
      onResult(-1, null, paramBundle);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      label159:
      break label159;
    }
    onResult(-1, null, paramBundle);
    return;
    if (paramInt == 2) {
      onResult(0, (byte[])localObject, paramBundle);
    }
  }
  
  public boolean onError(int paramInt, String paramString, Bundle paramBundle)
  {
    return false;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.mIsOnUIThread)
    {
      onReceiveReal(paramInt, paramBoolean, paramBundle);
      return;
    }
    ThreadManager.post(new ProtoUtils.TroopProtocolObserver.1(this, paramInt, paramBoolean, paramBundle), 5, null, false);
  }
  
  public abstract void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.ProtoUtils.TroopProtocolObserver
 * JD-Core Version:    0.7.0.1
 */