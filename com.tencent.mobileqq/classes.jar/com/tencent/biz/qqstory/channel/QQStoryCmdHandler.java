package com.tencent.biz.qqstory.channel;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;

public class QQStoryCmdHandler
{
  public Handler a;
  public List<QQStoryCmdHandler.CmdDumpInfo> a;
  private Map<Integer, NetworkRequest> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public Set<Integer> a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(100);
  
  public QQStoryCmdHandler()
  {
    this.jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    Bosses.get().postJob(new QQStoryCmdHandler.1(this, "Q.qqstory.net:QQStoryCmdHandler"));
  }
  
  private void a(NetworkRequest paramNetworkRequest, int paramInt, String paramString, long paramLong)
  {
    StoryReportor.b("story_net", paramNetworkRequest.a(), 0, paramInt, new String[] { paramString, String.valueOf(paramLong), StoryReportor.a(BaseApplication.getContext()) });
  }
  
  private void a(NetworkRequest paramNetworkRequest, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    long l = paramBundle.getLong("start_time");
    l = System.currentTimeMillis() - l;
    int i = paramBundle.getInt("data_error_code");
    if (i != 0)
    {
      paramArrayOfByte = paramBundle.getString("data_error_msg");
      if (((i == 2901) || (i == 1002) || (i == 1003)) && (a(paramNetworkRequest)))
      {
        SLog.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramNetworkRequest.a() + " channel error:%d, msg:%s, take time:%d ,retry time:%d , retry now", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l), Integer.valueOf(paramNetworkRequest.b) });
        paramNetworkRequest.b += 1;
        paramArrayOfByte = Bosses.get();
        paramNetworkRequest = new QQStoryCmdHandler.6(this, "Q.qqstory.net:QQStoryCmdHandler", paramNetworkRequest);
        if (i == 2901) {}
        for (i = 500;; i = 2000)
        {
          paramArrayOfByte.scheduleJobDelayed(paramNetworkRequest, i);
          return;
        }
      }
      paramNetworkRequest.a().a(i, HardCodeUtil.a(2131710785), null);
      SLog.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramNetworkRequest.a() + " channel error:%d, msg:%s, take time:%d", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l) });
      a(paramNetworkRequest, i, paramArrayOfByte, l);
      return;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      paramNetworkRequest.a().a(-1, "channel error null data", null);
      SLog.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramNetworkRequest.a() + " channel error null data, take time:%d", new Object[] { Long.valueOf(l) });
      a(paramNetworkRequest, 940002, "rsp data error", l);
      return;
    }
    paramBundle = null;
    try
    {
      BaseResponse localBaseResponse = paramNetworkRequest.a(paramArrayOfByte);
      paramBundle = localBaseResponse;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        SLog.c("Q.qqstory.net:QQStoryCmdHandler", "decode pb fail", localException);
      }
    }
    if (paramBundle == null)
    {
      SLog.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error. response is null", new Object[] { paramNetworkRequest.a() });
      a(paramNetworkRequest, 940002, "response is null", l);
      return;
    }
    if (paramBundle.a == 0) {
      SLog.a("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s success take time:%d data length=%d respond:%s", paramNetworkRequest.a(), Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length), paramBundle);
    }
    for (;;)
    {
      paramNetworkRequest.a().a(paramBundle.a, paramBundle.b, paramBundle);
      a(paramNetworkRequest, paramBundle.a, paramBundle.b, l);
      return;
      SLog.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { paramNetworkRequest.a(), Integer.valueOf(paramBundle.a), paramBundle.b, Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length) });
      if (paramBundle.a == 10001) {
        SLog.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%s", new Object[] { paramNetworkRequest.a(), paramNetworkRequest });
      }
    }
  }
  
  private boolean a(NetworkRequest paramNetworkRequest)
  {
    return (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramNetworkRequest.b()))) && (paramNetworkRequest.b < paramNetworkRequest.a);
  }
  
  public void a(Bundle paramBundle, byte[] paramArrayOfByte)
  {
    Bosses.get().postJob(new QQStoryCmdHandler.5(this, "Q.qqstory.net:QQStoryCmdHandler", paramBundle, paramArrayOfByte));
  }
  
  public void a(NetworkRequest paramNetworkRequest)
  {
    try
    {
      if (!NetworkUtils.a(QQStoryContext.a().a()))
      {
        Bosses.get().scheduleJobDelayed(new QQStoryCmdHandler.3(this, "Q.qqstory.net:QQStoryCmdHandler", paramNetworkRequest), 100);
        return;
      }
      Bosses.get().postJob(new QQStoryCmdHandler.4(this, "Q.qqstory.net:QQStoryCmdHandler", paramNetworkRequest));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      SLog.e("Q.qqstory.net:QQStoryCmdHandler", "send cmd:" + paramNetworkRequest.a() + " error:" + localIllegalArgumentException.getMessage());
      paramNetworkRequest.a().a(940001, localIllegalArgumentException.getMessage(), null);
    }
  }
  
  public void a(@NonNull String paramString)
  {
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        int j = paramString.getInt(i);
        this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(j));
        i += 1;
      }
      SLog.d("Q.qqstory.net:QQStoryCmdHandler", "update retry proto complete :%s", new Object[] { this.jdField_a_of_type_JavaUtilSet });
      return;
    }
    catch (Exception paramString)
    {
      SLog.e("Q.qqstory.net:QQStoryCmdHandler", "update retry proto list error :%s", new Object[] { paramString.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.QQStoryCmdHandler
 * JD-Core Version:    0.7.0.1
 */