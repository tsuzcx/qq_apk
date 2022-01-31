package com.tencent.biz.qqstory.channel;

import alpo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
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
import unf;
import unk;
import unl;
import unm;
import unn;
import uno;
import unq;
import unr;
import uns;
import wsv;
import wta;
import xne;

public class QQStoryCmdHandler
{
  public Handler a;
  public List<uns> a;
  private Map<Integer, unk> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public Set<Integer> a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(100);
  
  public QQStoryCmdHandler()
  {
    this.jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    Bosses.get().postJob(new unm(this, "Q.qqstory.net:QQStoryCmdHandler"));
  }
  
  private void a(unk paramunk, int paramInt, String paramString, long paramLong)
  {
    wta.b("story_net", paramunk.a(), 0, paramInt, new String[] { paramString, String.valueOf(paramLong), wta.a(BaseApplication.getContext()) });
  }
  
  private void a(unk paramunk, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    long l = paramBundle.getLong("start_time");
    l = System.currentTimeMillis() - l;
    int i = paramBundle.getInt("data_error_code");
    if (i != 0)
    {
      paramArrayOfByte = paramBundle.getString("data_error_msg");
      if (((i == 2901) || (i == 1002) || (i == 1003)) && (a(paramunk)))
      {
        wsv.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramunk.a() + " channel error:%d, msg:%s, take time:%d ,retry time:%d , retry now", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l), Integer.valueOf(paramunk.b) });
        paramunk.b += 1;
        paramArrayOfByte = Bosses.get();
        paramunk = new unr(this, "Q.qqstory.net:QQStoryCmdHandler", paramunk);
        if (i == 2901) {}
        for (i = 500;; i = 2000)
        {
          paramArrayOfByte.scheduleJobDelayed(paramunk, i);
          return;
        }
      }
      paramunk.a().a(i, alpo.a(2131711193), null);
      wsv.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramunk.a() + " channel error:%d, msg:%s, take time:%d", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l) });
      a(paramunk, i, paramArrayOfByte, l);
      return;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      paramunk.a().a(-1, "channel error null data", null);
      wsv.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramunk.a() + " channel error null data, take time:%d", new Object[] { Long.valueOf(l) });
      a(paramunk, 940002, "rsp data error", l);
      return;
    }
    paramBundle = null;
    try
    {
      unf localunf = paramunk.a(paramArrayOfByte);
      paramBundle = localunf;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        wsv.c("Q.qqstory.net:QQStoryCmdHandler", "decode pb fail", localException);
      }
    }
    if (paramBundle == null)
    {
      wsv.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error. response is null", new Object[] { paramunk.a() });
      a(paramunk, 940002, "response is null", l);
      return;
    }
    if (paramBundle.a == 0) {
      wsv.a("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s success take time:%d data length=%d respond:%s", paramunk.a(), Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length), paramBundle);
    }
    for (;;)
    {
      paramunk.a().a(paramBundle.a, paramBundle.b, paramBundle);
      a(paramunk, paramBundle.a, paramBundle.b, l);
      return;
      wsv.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { paramunk.a(), Integer.valueOf(paramBundle.a), paramBundle.b, Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length) });
      if (paramBundle.a == 10001) {
        wsv.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%s", new Object[] { paramunk.a(), paramunk });
      }
    }
  }
  
  private boolean a(unk paramunk)
  {
    return (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramunk.b()))) && (paramunk.b < paramunk.a);
  }
  
  public void a(Bundle paramBundle, byte[] paramArrayOfByte)
  {
    Bosses.get().postJob(new unq(this, "Q.qqstory.net:QQStoryCmdHandler", paramBundle, paramArrayOfByte));
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
      wsv.d("Q.qqstory.net:QQStoryCmdHandler", "update retry proto complete :%s", new Object[] { this.jdField_a_of_type_JavaUtilSet });
      return;
    }
    catch (Exception paramString)
    {
      wsv.e("Q.qqstory.net:QQStoryCmdHandler", "update retry proto list error :%s", new Object[] { paramString.getMessage() });
    }
  }
  
  public void a(unk paramunk)
  {
    try
    {
      if (!xne.a(QQStoryContext.a().a()))
      {
        Bosses.get().scheduleJobDelayed(new unn(this, "Q.qqstory.net:QQStoryCmdHandler", paramunk), 100);
        return;
      }
      Bosses.get().postJob(new uno(this, "Q.qqstory.net:QQStoryCmdHandler", paramunk));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      wsv.e("Q.qqstory.net:QQStoryCmdHandler", "send cmd:" + paramunk.a() + " error:" + localIllegalArgumentException.getMessage());
      paramunk.a().a(940001, localIllegalArgumentException.getMessage(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.QQStoryCmdHandler
 * JD-Core Version:    0.7.0.1
 */