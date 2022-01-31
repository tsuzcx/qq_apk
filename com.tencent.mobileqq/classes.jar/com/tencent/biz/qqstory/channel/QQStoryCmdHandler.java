package com.tencent.biz.qqstory.channel;

import ajya;
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
import syn;
import sys;
import syt;
import syu;
import syv;
import syw;
import syy;
import syz;
import sza;
import ved;
import vei;
import vym;

public class QQStoryCmdHandler
{
  public Handler a;
  public List<sza> a;
  private Map<Integer, sys> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public Set<Integer> a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(100);
  
  public QQStoryCmdHandler()
  {
    this.jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    Bosses.get().postJob(new syu(this, "Q.qqstory.net:QQStoryCmdHandler"));
  }
  
  private void a(sys paramsys, int paramInt, String paramString, long paramLong)
  {
    vei.b("story_net", paramsys.a(), 0, paramInt, new String[] { paramString, String.valueOf(paramLong), vei.a(BaseApplication.getContext()) });
  }
  
  private void a(sys paramsys, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    long l = paramBundle.getLong("start_time");
    l = System.currentTimeMillis() - l;
    int i = paramBundle.getInt("data_error_code");
    if (i != 0)
    {
      paramArrayOfByte = paramBundle.getString("data_error_msg");
      if (((i == 2901) || (i == 1002) || (i == 1003)) && (a(paramsys)))
      {
        ved.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramsys.a() + " channel error:%d, msg:%s, take time:%d ,retry time:%d , retry now", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l), Integer.valueOf(paramsys.b) });
        paramsys.b += 1;
        paramArrayOfByte = Bosses.get();
        paramsys = new syz(this, "Q.qqstory.net:QQStoryCmdHandler", paramsys);
        if (i == 2901) {}
        for (i = 500;; i = 2000)
        {
          paramArrayOfByte.scheduleJobDelayed(paramsys, i);
          return;
        }
      }
      paramsys.a().a(i, ajya.a(2131710821), null);
      ved.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramsys.a() + " channel error:%d, msg:%s, take time:%d", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l) });
      a(paramsys, i, paramArrayOfByte, l);
      return;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      paramsys.a().a(-1, "channel error null data", null);
      ved.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramsys.a() + " channel error null data, take time:%d", new Object[] { Long.valueOf(l) });
      a(paramsys, 940002, "rsp data error", l);
      return;
    }
    paramBundle = null;
    try
    {
      syn localsyn = paramsys.a(paramArrayOfByte);
      paramBundle = localsyn;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ved.c("Q.qqstory.net:QQStoryCmdHandler", "decode pb fail", localException);
      }
    }
    if (paramBundle == null)
    {
      ved.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error. response is null", new Object[] { paramsys.a() });
      a(paramsys, 940002, "response is null", l);
      return;
    }
    if (paramBundle.a == 0) {
      ved.a("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s success take time:%d data length=%d respond:%s", paramsys.a(), Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length), paramBundle);
    }
    for (;;)
    {
      paramsys.a().a(paramBundle.a, paramBundle.b, paramBundle);
      a(paramsys, paramBundle.a, paramBundle.b, l);
      return;
      ved.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { paramsys.a(), Integer.valueOf(paramBundle.a), paramBundle.b, Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length) });
      if (paramBundle.a == 10001) {
        ved.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%s", new Object[] { paramsys.a(), paramsys });
      }
    }
  }
  
  private boolean a(sys paramsys)
  {
    return (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramsys.b()))) && (paramsys.b < paramsys.a);
  }
  
  public void a(Bundle paramBundle, byte[] paramArrayOfByte)
  {
    Bosses.get().postJob(new syy(this, "Q.qqstory.net:QQStoryCmdHandler", paramBundle, paramArrayOfByte));
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
      ved.d("Q.qqstory.net:QQStoryCmdHandler", "update retry proto complete :%s", new Object[] { this.jdField_a_of_type_JavaUtilSet });
      return;
    }
    catch (Exception paramString)
    {
      ved.e("Q.qqstory.net:QQStoryCmdHandler", "update retry proto list error :%s", new Object[] { paramString.getMessage() });
    }
  }
  
  public void a(sys paramsys)
  {
    try
    {
      if (!vym.a(QQStoryContext.a().a()))
      {
        Bosses.get().scheduleJobDelayed(new syv(this, "Q.qqstory.net:QQStoryCmdHandler", paramsys), 100);
        return;
      }
      Bosses.get().postJob(new syw(this, "Q.qqstory.net:QQStoryCmdHandler", paramsys));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ved.e("Q.qqstory.net:QQStoryCmdHandler", "send cmd:" + paramsys.a() + " error:" + localIllegalArgumentException.getMessage());
      paramsys.a().a(940001, localIllegalArgumentException.getMessage(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.QQStoryCmdHandler
 * JD-Core Version:    0.7.0.1
 */