package com.tencent.biz;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.lang.ref.WeakReference;
import kjw;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public abstract class ProtoUtils$TroopProtocolObserver
  implements BusinessObserver
{
  public boolean a;
  public int b;
  public WeakReference b;
  
  public ProtoUtils$TroopProtocolObserver()
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(null);
    this.a = true;
  }
  
  public ProtoUtils$TroopProtocolObserver(boolean paramBoolean)
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(null);
    this.a = paramBoolean;
  }
  
  private void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {
      a(-1, null, paramBundle);
    }
    do
    {
      return;
      Object localObject = paramBundle.getByteArray("data");
      if (this.jdField_b_of_type_Int == 1)
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        try
        {
          localObject = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom((byte[])localObject);
          if ((localObject == null) || (!((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) || (!((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() == null))
          {
            a(-1, null, paramBundle);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          a(-1, null, paramBundle);
          return;
        }
        a(localInvalidProtocolBufferMicroException.uint32_result.get(), localInvalidProtocolBufferMicroException.bytes_bodybuffer.get().toByteArray(), paramBundle);
        return;
      }
    } while (this.jdField_b_of_type_Int != 2);
    a(0, localInvalidProtocolBufferMicroException, paramBundle);
  }
  
  public abstract void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle);
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a)
    {
      a(paramInt, paramBoolean, paramBundle);
      return;
    }
    ThreadManager.post(new kjw(this, paramInt, paramBoolean, paramBundle), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.ProtoUtils.TroopProtocolObserver
 * JD-Core Version:    0.7.0.1
 */