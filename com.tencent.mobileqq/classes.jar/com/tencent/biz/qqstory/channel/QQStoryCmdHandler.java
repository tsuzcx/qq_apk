package com.tencent.biz.qqstory.channel;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import anvx;
import com.tencent.biz.qqstory.app.QQStoryContext;
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
import wfh;
import wfm;
import wfn;
import wfo;
import wfp;
import wfq;
import wfs;
import wft;
import wfu;
import ykq;
import ykv;
import zei;

public class QQStoryCmdHandler
{
  public Handler a;
  public List<wfu> a;
  private Map<Integer, wfm> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public Set<Integer> a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(100);
  
  public QQStoryCmdHandler()
  {
    this.jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    Bosses.get().postJob(new wfo(this, "Q.qqstory.net:QQStoryCmdHandler"));
  }
  
  private void a(wfm paramwfm, int paramInt, String paramString, long paramLong)
  {
    ykv.b("story_net", paramwfm.a(), 0, paramInt, new String[] { paramString, String.valueOf(paramLong), ykv.a(BaseApplication.getContext()) });
  }
  
  private void a(wfm paramwfm, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    long l = paramBundle.getLong("start_time");
    l = System.currentTimeMillis() - l;
    int i = paramBundle.getInt("data_error_code");
    if (i != 0)
    {
      paramArrayOfByte = paramBundle.getString("data_error_msg");
      if (((i == 2901) || (i == 1002) || (i == 1003)) && (a(paramwfm)))
      {
        ykq.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramwfm.a() + " channel error:%d, msg:%s, take time:%d ,retry time:%d , retry now", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l), Integer.valueOf(paramwfm.b) });
        paramwfm.b += 1;
        paramArrayOfByte = Bosses.get();
        paramwfm = new wft(this, "Q.qqstory.net:QQStoryCmdHandler", paramwfm);
        if (i == 2901) {}
        for (i = 500;; i = 2000)
        {
          paramArrayOfByte.scheduleJobDelayed(paramwfm, i);
          return;
        }
      }
      paramwfm.a().a(i, anvx.a(2131710269), null);
      ykq.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramwfm.a() + " channel error:%d, msg:%s, take time:%d", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l) });
      a(paramwfm, i, paramArrayOfByte, l);
      return;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      paramwfm.a().a(-1, "channel error null data", null);
      ykq.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramwfm.a() + " channel error null data, take time:%d", new Object[] { Long.valueOf(l) });
      a(paramwfm, 940002, "rsp data error", l);
      return;
    }
    paramBundle = null;
    try
    {
      wfh localwfh = paramwfm.a(paramArrayOfByte);
      paramBundle = localwfh;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ykq.c("Q.qqstory.net:QQStoryCmdHandler", "decode pb fail", localException);
      }
    }
    if (paramBundle == null)
    {
      ykq.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error. response is null", new Object[] { paramwfm.a() });
      a(paramwfm, 940002, "response is null", l);
      return;
    }
    if (paramBundle.a == 0) {
      ykq.a("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s success take time:%d data length=%d respond:%s", paramwfm.a(), Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length), paramBundle);
    }
    for (;;)
    {
      paramwfm.a().a(paramBundle.a, paramBundle.b, paramBundle);
      a(paramwfm, paramBundle.a, paramBundle.b, l);
      return;
      ykq.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { paramwfm.a(), Integer.valueOf(paramBundle.a), paramBundle.b, Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length) });
      if (paramBundle.a == 10001) {
        ykq.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%s", new Object[] { paramwfm.a(), paramwfm });
      }
    }
  }
  
  private boolean a(wfm paramwfm)
  {
    return (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramwfm.b()))) && (paramwfm.b < paramwfm.a);
  }
  
  public void a(Bundle paramBundle, byte[] paramArrayOfByte)
  {
    Bosses.get().postJob(new wfs(this, "Q.qqstory.net:QQStoryCmdHandler", paramBundle, paramArrayOfByte));
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
      ykq.d("Q.qqstory.net:QQStoryCmdHandler", "update retry proto complete :%s", new Object[] { this.jdField_a_of_type_JavaUtilSet });
      return;
    }
    catch (Exception paramString)
    {
      ykq.e("Q.qqstory.net:QQStoryCmdHandler", "update retry proto list error :%s", new Object[] { paramString.getMessage() });
    }
  }
  
  public void a(wfm paramwfm)
  {
    try
    {
      if (!zei.a(QQStoryContext.a().a()))
      {
        Bosses.get().scheduleJobDelayed(new wfp(this, "Q.qqstory.net:QQStoryCmdHandler", paramwfm), 100);
        return;
      }
      Bosses.get().postJob(new wfq(this, "Q.qqstory.net:QQStoryCmdHandler", paramwfm));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ykq.e("Q.qqstory.net:QQStoryCmdHandler", "send cmd:" + paramwfm.a() + " error:" + localIllegalArgumentException.getMessage());
      paramwfm.a().a(940001, localIllegalArgumentException.getMessage(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.QQStoryCmdHandler
 * JD-Core Version:    0.7.0.1
 */