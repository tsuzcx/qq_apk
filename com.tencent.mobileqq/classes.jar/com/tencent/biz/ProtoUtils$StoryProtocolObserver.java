package com.tencent.biz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

public abstract class ProtoUtils$StoryProtocolObserver
  implements BusinessObserver
{
  public boolean a = true;
  public final long b = System.currentTimeMillis();
  public WeakReference<AppRuntime> c = new WeakReference(null);
  
  private void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l = System.currentTimeMillis() - this.b;
    String str = paramBundle.getString("cmd");
    Integer localInteger = Integer.valueOf(-1);
    if (paramBoolean)
    {
      localObject = paramBundle.getByteArray("data");
      if ((localObject != null) && (localObject.length > 0))
      {
        paramBundle = a(0, (byte[])localObject, paramBundle);
        if (paramBundle != null)
        {
          paramInt = paramBundle.error_code.get();
          paramBundle = paramBundle.error_desc.get().toStringUtf8();
          if (paramInt == 0) {
            SLog.a("Q.qqstory.net:StoryProtocolObserver", "get cmd:%s success take time:%d data length=%d", str, Long.valueOf(l), Integer.valueOf(localObject.length));
          } else {
            SLog.d("Q.qqstory.net:StoryProtocolObserver", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { str, Integer.valueOf(paramInt), paramBundle, Long.valueOf(l), Integer.valueOf(localObject.length) });
          }
          a(str, 0, paramInt, new String[] { paramBundle, String.valueOf(l) });
          return;
        }
        SLog.d("Q.qqstory.net:StoryProtocolObserver", "get cmd:%s error. response is null", new Object[] { str });
        a(str, 0, 940002, new String[] { "response is null", String.valueOf(l) });
        return;
      }
      a(-1, null, paramBundle);
      paramBundle = new StringBuilder();
      paramBundle.append("get cmd:");
      paramBundle.append(str);
      paramBundle.append(" channel error:%d, take time:%d");
      SLog.d("Q.qqstory.net:StoryProtocolObserver", paramBundle.toString(), new Object[] { localInteger, Long.valueOf(l) });
      a(str, 0, 940002, new String[] { "rsp data error", String.valueOf(l) });
      return;
    }
    paramInt = paramBundle.getInt("data_error_code");
    Object localObject = paramBundle.getString("data_error_msg");
    a(paramInt, null, paramBundle);
    paramBundle = new StringBuilder();
    paramBundle.append("get cmd:");
    paramBundle.append(str);
    paramBundle.append(" channel error:%d, take time:%d");
    SLog.d("Q.qqstory.net:StoryProtocolObserver", paramBundle.toString(), new Object[] { localInteger, Long.valueOf(l) });
    a(str, 0, paramInt, new String[] { localObject, String.valueOf(l) });
  }
  
  public abstract qqstory_struct.ErrorInfo a(int paramInt, @Nullable byte[] paramArrayOfByte, Bundle paramBundle);
  
  public void a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    try
    {
      ((IProtoUtils)((Class)ProtoUtils.a.get(0)).newInstance()).a(paramString, paramInt1, paramInt2, paramVarArgs);
      return;
    }
    catch (InstantiationException paramString)
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("reportDevEvent error:");
      paramVarArgs.append(paramString);
      QLog.e("Q.qqstory.net:StoryProtocolObserver", 1, paramVarArgs.toString());
      return;
    }
    catch (IllegalAccessException paramString)
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("reportDevEvent error:");
      paramVarArgs.append(paramString);
      QLog.e("Q.qqstory.net:StoryProtocolObserver", 1, paramVarArgs.toString());
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a)
    {
      a(paramInt, paramBoolean, paramBundle);
      return;
    }
    ThreadManager.post(new ProtoUtils.StoryProtocolObserver.1(this, paramInt, paramBoolean, paramBundle), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.ProtoUtils.StoryProtocolObserver
 * JD-Core Version:    0.7.0.1
 */