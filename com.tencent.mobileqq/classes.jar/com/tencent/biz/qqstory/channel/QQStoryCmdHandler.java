package com.tencent.biz.qqstory.channel;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import anzj;
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
import wov;
import wpa;
import wpb;
import wpc;
import wpd;
import wpe;
import wpg;
import wph;
import wpi;
import yuk;
import yup;
import zot;

public class QQStoryCmdHandler
{
  public Handler a;
  public List<wpi> a;
  private Map<Integer, wpa> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public Set<Integer> a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(100);
  
  public QQStoryCmdHandler()
  {
    this.jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    Bosses.get().postJob(new wpc(this, "Q.qqstory.net:QQStoryCmdHandler"));
  }
  
  private void a(wpa paramwpa, int paramInt, String paramString, long paramLong)
  {
    yup.b("story_net", paramwpa.a(), 0, paramInt, new String[] { paramString, String.valueOf(paramLong), yup.a(BaseApplication.getContext()) });
  }
  
  private void a(wpa paramwpa, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    long l = paramBundle.getLong("start_time");
    l = System.currentTimeMillis() - l;
    int i = paramBundle.getInt("data_error_code");
    if (i != 0)
    {
      paramArrayOfByte = paramBundle.getString("data_error_msg");
      if (((i == 2901) || (i == 1002) || (i == 1003)) && (a(paramwpa)))
      {
        yuk.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramwpa.a() + " channel error:%d, msg:%s, take time:%d ,retry time:%d , retry now", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l), Integer.valueOf(paramwpa.b) });
        paramwpa.b += 1;
        paramArrayOfByte = Bosses.get();
        paramwpa = new wph(this, "Q.qqstory.net:QQStoryCmdHandler", paramwpa);
        if (i == 2901) {}
        for (i = 500;; i = 2000)
        {
          paramArrayOfByte.scheduleJobDelayed(paramwpa, i);
          return;
        }
      }
      paramwpa.a().a(i, anzj.a(2131709690), null);
      yuk.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramwpa.a() + " channel error:%d, msg:%s, take time:%d", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l) });
      a(paramwpa, i, paramArrayOfByte, l);
      return;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      paramwpa.a().a(-1, "channel error null data", null);
      yuk.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramwpa.a() + " channel error null data, take time:%d", new Object[] { Long.valueOf(l) });
      a(paramwpa, 940002, "rsp data error", l);
      return;
    }
    paramBundle = null;
    try
    {
      wov localwov = paramwpa.a(paramArrayOfByte);
      paramBundle = localwov;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        yuk.c("Q.qqstory.net:QQStoryCmdHandler", "decode pb fail", localException);
      }
    }
    if (paramBundle == null)
    {
      yuk.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error. response is null", new Object[] { paramwpa.a() });
      a(paramwpa, 940002, "response is null", l);
      return;
    }
    if (paramBundle.a == 0) {
      yuk.a("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s success take time:%d data length=%d respond:%s", paramwpa.a(), Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length), paramBundle);
    }
    for (;;)
    {
      paramwpa.a().a(paramBundle.a, paramBundle.b, paramBundle);
      a(paramwpa, paramBundle.a, paramBundle.b, l);
      return;
      yuk.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { paramwpa.a(), Integer.valueOf(paramBundle.a), paramBundle.b, Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length) });
      if (paramBundle.a == 10001) {
        yuk.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%s", new Object[] { paramwpa.a(), paramwpa });
      }
    }
  }
  
  private boolean a(wpa paramwpa)
  {
    return (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramwpa.b()))) && (paramwpa.b < paramwpa.a);
  }
  
  public void a(Bundle paramBundle, byte[] paramArrayOfByte)
  {
    Bosses.get().postJob(new wpg(this, "Q.qqstory.net:QQStoryCmdHandler", paramBundle, paramArrayOfByte));
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
      yuk.d("Q.qqstory.net:QQStoryCmdHandler", "update retry proto complete :%s", new Object[] { this.jdField_a_of_type_JavaUtilSet });
      return;
    }
    catch (Exception paramString)
    {
      yuk.e("Q.qqstory.net:QQStoryCmdHandler", "update retry proto list error :%s", new Object[] { paramString.getMessage() });
    }
  }
  
  public void a(wpa paramwpa)
  {
    try
    {
      if (!zot.a(QQStoryContext.a().a()))
      {
        Bosses.get().scheduleJobDelayed(new wpd(this, "Q.qqstory.net:QQStoryCmdHandler", paramwpa), 100);
        return;
      }
      Bosses.get().postJob(new wpe(this, "Q.qqstory.net:QQStoryCmdHandler", paramwpa));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      yuk.e("Q.qqstory.net:QQStoryCmdHandler", "send cmd:" + paramwpa.a() + " error:" + localIllegalArgumentException.getMessage());
      paramwpa.a().a(940001, localIllegalArgumentException.getMessage(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.QQStoryCmdHandler
 * JD-Core Version:    0.7.0.1
 */