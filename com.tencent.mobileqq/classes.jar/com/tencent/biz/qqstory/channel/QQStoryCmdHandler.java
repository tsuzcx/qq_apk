package com.tencent.biz.qqstory.channel;

import amtj;
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
import vqm;
import vqr;
import vqs;
import vqt;
import vqu;
import vqv;
import vqx;
import vqy;
import vqz;
import xvv;
import xwa;
import ypp;

public class QQStoryCmdHandler
{
  public Handler a;
  public List<vqz> a;
  private Map<Integer, vqr> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public Set<Integer> a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(100);
  
  public QQStoryCmdHandler()
  {
    this.jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    Bosses.get().postJob(new vqt(this, "Q.qqstory.net:QQStoryCmdHandler"));
  }
  
  private void a(vqr paramvqr, int paramInt, String paramString, long paramLong)
  {
    xwa.b("story_net", paramvqr.a(), 0, paramInt, new String[] { paramString, String.valueOf(paramLong), xwa.a(BaseApplication.getContext()) });
  }
  
  private void a(vqr paramvqr, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    long l = paramBundle.getLong("start_time");
    l = System.currentTimeMillis() - l;
    int i = paramBundle.getInt("data_error_code");
    if (i != 0)
    {
      paramArrayOfByte = paramBundle.getString("data_error_msg");
      if (((i == 2901) || (i == 1002) || (i == 1003)) && (a(paramvqr)))
      {
        xvv.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramvqr.a() + " channel error:%d, msg:%s, take time:%d ,retry time:%d , retry now", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l), Integer.valueOf(paramvqr.b) });
        paramvqr.b += 1;
        paramArrayOfByte = Bosses.get();
        paramvqr = new vqy(this, "Q.qqstory.net:QQStoryCmdHandler", paramvqr);
        if (i == 2901) {}
        for (i = 500;; i = 2000)
        {
          paramArrayOfByte.scheduleJobDelayed(paramvqr, i);
          return;
        }
      }
      paramvqr.a().a(i, amtj.a(2131709922), null);
      xvv.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramvqr.a() + " channel error:%d, msg:%s, take time:%d", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l) });
      a(paramvqr, i, paramArrayOfByte, l);
      return;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      paramvqr.a().a(-1, "channel error null data", null);
      xvv.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramvqr.a() + " channel error null data, take time:%d", new Object[] { Long.valueOf(l) });
      a(paramvqr, 940002, "rsp data error", l);
      return;
    }
    paramBundle = null;
    try
    {
      vqm localvqm = paramvqr.a(paramArrayOfByte);
      paramBundle = localvqm;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        xvv.c("Q.qqstory.net:QQStoryCmdHandler", "decode pb fail", localException);
      }
    }
    if (paramBundle == null)
    {
      xvv.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error. response is null", new Object[] { paramvqr.a() });
      a(paramvqr, 940002, "response is null", l);
      return;
    }
    if (paramBundle.a == 0) {
      xvv.a("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s success take time:%d data length=%d respond:%s", paramvqr.a(), Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length), paramBundle);
    }
    for (;;)
    {
      paramvqr.a().a(paramBundle.a, paramBundle.b, paramBundle);
      a(paramvqr, paramBundle.a, paramBundle.b, l);
      return;
      xvv.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { paramvqr.a(), Integer.valueOf(paramBundle.a), paramBundle.b, Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length) });
      if (paramBundle.a == 10001) {
        xvv.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%s", new Object[] { paramvqr.a(), paramvqr });
      }
    }
  }
  
  private boolean a(vqr paramvqr)
  {
    return (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramvqr.b()))) && (paramvqr.b < paramvqr.a);
  }
  
  public void a(Bundle paramBundle, byte[] paramArrayOfByte)
  {
    Bosses.get().postJob(new vqx(this, "Q.qqstory.net:QQStoryCmdHandler", paramBundle, paramArrayOfByte));
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
      xvv.d("Q.qqstory.net:QQStoryCmdHandler", "update retry proto complete :%s", new Object[] { this.jdField_a_of_type_JavaUtilSet });
      return;
    }
    catch (Exception paramString)
    {
      xvv.e("Q.qqstory.net:QQStoryCmdHandler", "update retry proto list error :%s", new Object[] { paramString.getMessage() });
    }
  }
  
  public void a(vqr paramvqr)
  {
    try
    {
      if (!ypp.a(QQStoryContext.a().a()))
      {
        Bosses.get().scheduleJobDelayed(new vqu(this, "Q.qqstory.net:QQStoryCmdHandler", paramvqr), 100);
        return;
      }
      Bosses.get().postJob(new vqv(this, "Q.qqstory.net:QQStoryCmdHandler", paramvqr));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      xvv.e("Q.qqstory.net:QQStoryCmdHandler", "send cmd:" + paramvqr.a() + " error:" + localIllegalArgumentException.getMessage());
      paramvqr.a().a(940001, localIllegalArgumentException.getMessage(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.QQStoryCmdHandler
 * JD-Core Version:    0.7.0.1
 */