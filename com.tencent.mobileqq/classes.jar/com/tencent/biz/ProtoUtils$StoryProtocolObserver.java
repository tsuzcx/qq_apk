package com.tencent.biz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.lang.ref.WeakReference;
import kkk;
import mqq.observer.BusinessObserver;

public abstract class ProtoUtils$StoryProtocolObserver
  implements BusinessObserver
{
  public final long a;
  public WeakReference a;
  public boolean a;
  
  public ProtoUtils$StoryProtocolObserver()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  private void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    String str = paramBundle.getString("cmd");
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
          }
          for (;;)
          {
            StoryReportor.b("story_net", str, 0, paramInt, new String[] { paramBundle, String.valueOf(l), StoryReportor.a(BaseApplication.getContext()) });
            return;
            SLog.d("Q.qqstory.net:StoryProtocolObserver", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { str, Integer.valueOf(paramInt), paramBundle, Long.valueOf(l), Integer.valueOf(localObject.length) });
          }
        }
        SLog.d("Q.qqstory.net:StoryProtocolObserver", "get cmd:%s error. response is null", new Object[] { str });
        StoryReportor.b("story_net", str, 0, 940002, new String[] { "response is null", String.valueOf(l), StoryReportor.a(BaseApplication.getContext()) });
        return;
      }
      a(-1, null, paramBundle);
      SLog.d("Q.qqstory.net:StoryProtocolObserver", "get cmd:" + str + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
      StoryReportor.b("story_net", str, 0, 940002, new String[] { "rsp data error", String.valueOf(l), StoryReportor.a(BaseApplication.getContext()) });
      return;
    }
    paramInt = paramBundle.getInt("data_error_code");
    Object localObject = paramBundle.getString("data_error_msg");
    a(paramInt, null, paramBundle);
    SLog.d("Q.qqstory.net:StoryProtocolObserver", "get cmd:" + str + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
    StoryReportor.b("story_net", str, 0, paramInt, new String[] { localObject, String.valueOf(l), StoryReportor.a(BaseApplication.getContext()) });
  }
  
  public abstract qqstory_struct.ErrorInfo a(int paramInt, @Nullable byte[] paramArrayOfByte, Bundle paramBundle);
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      a(paramInt, paramBoolean, paramBundle);
      return;
    }
    ThreadManager.post(new kkk(this, paramInt, paramBoolean, paramBundle), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.ProtoUtils.StoryProtocolObserver
 * JD-Core Version:    0.7.0.1
 */