package com.tencent.biz.qqstory.channel;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import anni;
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
import wla;
import wlf;
import wlg;
import wlh;
import wli;
import wlj;
import wll;
import wlm;
import wln;
import yqp;
import yqu;
import zky;

public class QQStoryCmdHandler
{
  public Handler a;
  public List<wln> a;
  private Map<Integer, wlf> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public Set<Integer> a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(100);
  
  public QQStoryCmdHandler()
  {
    this.jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    Bosses.get().postJob(new wlh(this, "Q.qqstory.net:QQStoryCmdHandler"));
  }
  
  private void a(wlf paramwlf, int paramInt, String paramString, long paramLong)
  {
    yqu.b("story_net", paramwlf.a(), 0, paramInt, new String[] { paramString, String.valueOf(paramLong), yqu.a(BaseApplication.getContext()) });
  }
  
  private void a(wlf paramwlf, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    long l = paramBundle.getLong("start_time");
    l = System.currentTimeMillis() - l;
    int i = paramBundle.getInt("data_error_code");
    if (i != 0)
    {
      paramArrayOfByte = paramBundle.getString("data_error_msg");
      if (((i == 2901) || (i == 1002) || (i == 1003)) && (a(paramwlf)))
      {
        yqp.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramwlf.a() + " channel error:%d, msg:%s, take time:%d ,retry time:%d , retry now", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l), Integer.valueOf(paramwlf.b) });
        paramwlf.b += 1;
        paramArrayOfByte = Bosses.get();
        paramwlf = new wlm(this, "Q.qqstory.net:QQStoryCmdHandler", paramwlf);
        if (i == 2901) {}
        for (i = 500;; i = 2000)
        {
          paramArrayOfByte.scheduleJobDelayed(paramwlf, i);
          return;
        }
      }
      paramwlf.a().a(i, anni.a(2131709581), null);
      yqp.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramwlf.a() + " channel error:%d, msg:%s, take time:%d", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l) });
      a(paramwlf, i, paramArrayOfByte, l);
      return;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      paramwlf.a().a(-1, "channel error null data", null);
      yqp.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramwlf.a() + " channel error null data, take time:%d", new Object[] { Long.valueOf(l) });
      a(paramwlf, 940002, "rsp data error", l);
      return;
    }
    paramBundle = null;
    try
    {
      wla localwla = paramwlf.a(paramArrayOfByte);
      paramBundle = localwla;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        yqp.c("Q.qqstory.net:QQStoryCmdHandler", "decode pb fail", localException);
      }
    }
    if (paramBundle == null)
    {
      yqp.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error. response is null", new Object[] { paramwlf.a() });
      a(paramwlf, 940002, "response is null", l);
      return;
    }
    if (paramBundle.a == 0) {
      yqp.a("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s success take time:%d data length=%d respond:%s", paramwlf.a(), Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length), paramBundle);
    }
    for (;;)
    {
      paramwlf.a().a(paramBundle.a, paramBundle.b, paramBundle);
      a(paramwlf, paramBundle.a, paramBundle.b, l);
      return;
      yqp.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { paramwlf.a(), Integer.valueOf(paramBundle.a), paramBundle.b, Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length) });
      if (paramBundle.a == 10001) {
        yqp.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%s", new Object[] { paramwlf.a(), paramwlf });
      }
    }
  }
  
  private boolean a(wlf paramwlf)
  {
    return (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramwlf.b()))) && (paramwlf.b < paramwlf.a);
  }
  
  public void a(Bundle paramBundle, byte[] paramArrayOfByte)
  {
    Bosses.get().postJob(new wll(this, "Q.qqstory.net:QQStoryCmdHandler", paramBundle, paramArrayOfByte));
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
      yqp.d("Q.qqstory.net:QQStoryCmdHandler", "update retry proto complete :%s", new Object[] { this.jdField_a_of_type_JavaUtilSet });
      return;
    }
    catch (Exception paramString)
    {
      yqp.e("Q.qqstory.net:QQStoryCmdHandler", "update retry proto list error :%s", new Object[] { paramString.getMessage() });
    }
  }
  
  public void a(wlf paramwlf)
  {
    try
    {
      if (!zky.a(QQStoryContext.a().a()))
      {
        Bosses.get().scheduleJobDelayed(new wli(this, "Q.qqstory.net:QQStoryCmdHandler", paramwlf), 100);
        return;
      }
      Bosses.get().postJob(new wlj(this, "Q.qqstory.net:QQStoryCmdHandler", paramwlf));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      yqp.e("Q.qqstory.net:QQStoryCmdHandler", "send cmd:" + paramwlf.a() + " error:" + localIllegalArgumentException.getMessage());
      paramwlf.a().a(940001, localIllegalArgumentException.getMessage(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.QQStoryCmdHandler
 * JD-Core Version:    0.7.0.1
 */