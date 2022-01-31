package com.tencent.biz.qqstory.channel;

import ajjy;
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
import slu;
import slz;
import sma;
import smb;
import smc;
import smd;
import smf;
import smg;
import smh;
import urk;
import urp;
import vlt;

public class QQStoryCmdHandler
{
  public Handler a;
  public List<smh> a;
  private Map<Integer, slz> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public Set<Integer> a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(100);
  
  public QQStoryCmdHandler()
  {
    this.jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    Bosses.get().postJob(new smb(this, "Q.qqstory.net:QQStoryCmdHandler"));
  }
  
  private void a(slz paramslz, int paramInt, String paramString, long paramLong)
  {
    urp.b("story_net", paramslz.a(), 0, paramInt, new String[] { paramString, String.valueOf(paramLong), urp.a(BaseApplication.getContext()) });
  }
  
  private void a(slz paramslz, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    long l = paramBundle.getLong("start_time");
    l = System.currentTimeMillis() - l;
    int i = paramBundle.getInt("data_error_code");
    if (i != 0)
    {
      paramArrayOfByte = paramBundle.getString("data_error_msg");
      if (((i == 2901) || (i == 1002) || (i == 1003)) && (a(paramslz)))
      {
        urk.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramslz.a() + " channel error:%d, msg:%s, take time:%d ,retry time:%d , retry now", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l), Integer.valueOf(paramslz.b) });
        paramslz.b += 1;
        paramArrayOfByte = Bosses.get();
        paramslz = new smg(this, "Q.qqstory.net:QQStoryCmdHandler", paramslz);
        if (i == 2901) {}
        for (i = 500;; i = 2000)
        {
          paramArrayOfByte.scheduleJobDelayed(paramslz, i);
          return;
        }
      }
      paramslz.a().a(i, ajjy.a(2131645022), null);
      urk.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramslz.a() + " channel error:%d, msg:%s, take time:%d", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l) });
      a(paramslz, i, paramArrayOfByte, l);
      return;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      paramslz.a().a(-1, "channel error null data", null);
      urk.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramslz.a() + " channel error null data, take time:%d", new Object[] { Long.valueOf(l) });
      a(paramslz, 940002, "rsp data error", l);
      return;
    }
    paramBundle = null;
    try
    {
      slu localslu = paramslz.a(paramArrayOfByte);
      paramBundle = localslu;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        urk.c("Q.qqstory.net:QQStoryCmdHandler", "decode pb fail", localException);
      }
    }
    if (paramBundle == null)
    {
      urk.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error. response is null", new Object[] { paramslz.a() });
      a(paramslz, 940002, "response is null", l);
      return;
    }
    if (paramBundle.a == 0) {
      urk.a("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s success take time:%d data length=%d respond:%s", paramslz.a(), Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length), paramBundle);
    }
    for (;;)
    {
      paramslz.a().a(paramBundle.a, paramBundle.b, paramBundle);
      a(paramslz, paramBundle.a, paramBundle.b, l);
      return;
      urk.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { paramslz.a(), Integer.valueOf(paramBundle.a), paramBundle.b, Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length) });
      if (paramBundle.a == 10001) {
        urk.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%s", new Object[] { paramslz.a(), paramslz });
      }
    }
  }
  
  private boolean a(slz paramslz)
  {
    return (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramslz.b()))) && (paramslz.b < paramslz.a);
  }
  
  public void a(Bundle paramBundle, byte[] paramArrayOfByte)
  {
    Bosses.get().postJob(new smf(this, "Q.qqstory.net:QQStoryCmdHandler", paramBundle, paramArrayOfByte));
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
      urk.d("Q.qqstory.net:QQStoryCmdHandler", "update retry proto complete :%s", new Object[] { this.jdField_a_of_type_JavaUtilSet });
      return;
    }
    catch (Exception paramString)
    {
      urk.e("Q.qqstory.net:QQStoryCmdHandler", "update retry proto list error :%s", new Object[] { paramString.getMessage() });
    }
  }
  
  public void a(slz paramslz)
  {
    try
    {
      if (!vlt.a(QQStoryContext.a().a()))
      {
        Bosses.get().scheduleJobDelayed(new smc(this, "Q.qqstory.net:QQStoryCmdHandler", paramslz), 100);
        return;
      }
      Bosses.get().postJob(new smd(this, "Q.qqstory.net:QQStoryCmdHandler", paramslz));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      urk.e("Q.qqstory.net:QQStoryCmdHandler", "send cmd:" + paramslz.a() + " error:" + localIllegalArgumentException.getMessage());
      paramslz.a().a(940001, localIllegalArgumentException.getMessage(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.QQStoryCmdHandler
 * JD-Core Version:    0.7.0.1
 */