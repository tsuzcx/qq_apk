package com.tencent.biz.qqstory.channel;

import ajyc;
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
import syq;
import syv;
import syw;
import syx;
import syy;
import syz;
import szb;
import szc;
import szd;
import veg;
import vel;
import vyp;

public class QQStoryCmdHandler
{
  public Handler a;
  public List<szd> a;
  private Map<Integer, syv> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public Set<Integer> a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(100);
  
  public QQStoryCmdHandler()
  {
    this.jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    Bosses.get().postJob(new syx(this, "Q.qqstory.net:QQStoryCmdHandler"));
  }
  
  private void a(syv paramsyv, int paramInt, String paramString, long paramLong)
  {
    vel.b("story_net", paramsyv.a(), 0, paramInt, new String[] { paramString, String.valueOf(paramLong), vel.a(BaseApplication.getContext()) });
  }
  
  private void a(syv paramsyv, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    long l = paramBundle.getLong("start_time");
    l = System.currentTimeMillis() - l;
    int i = paramBundle.getInt("data_error_code");
    if (i != 0)
    {
      paramArrayOfByte = paramBundle.getString("data_error_msg");
      if (((i == 2901) || (i == 1002) || (i == 1003)) && (a(paramsyv)))
      {
        veg.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramsyv.a() + " channel error:%d, msg:%s, take time:%d ,retry time:%d , retry now", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l), Integer.valueOf(paramsyv.b) });
        paramsyv.b += 1;
        paramArrayOfByte = Bosses.get();
        paramsyv = new szc(this, "Q.qqstory.net:QQStoryCmdHandler", paramsyv);
        if (i == 2901) {}
        for (i = 500;; i = 2000)
        {
          paramArrayOfByte.scheduleJobDelayed(paramsyv, i);
          return;
        }
      }
      paramsyv.a().a(i, ajyc.a(2131710810), null);
      veg.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramsyv.a() + " channel error:%d, msg:%s, take time:%d", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l) });
      a(paramsyv, i, paramArrayOfByte, l);
      return;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      paramsyv.a().a(-1, "channel error null data", null);
      veg.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramsyv.a() + " channel error null data, take time:%d", new Object[] { Long.valueOf(l) });
      a(paramsyv, 940002, "rsp data error", l);
      return;
    }
    paramBundle = null;
    try
    {
      syq localsyq = paramsyv.a(paramArrayOfByte);
      paramBundle = localsyq;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        veg.c("Q.qqstory.net:QQStoryCmdHandler", "decode pb fail", localException);
      }
    }
    if (paramBundle == null)
    {
      veg.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error. response is null", new Object[] { paramsyv.a() });
      a(paramsyv, 940002, "response is null", l);
      return;
    }
    if (paramBundle.a == 0) {
      veg.a("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s success take time:%d data length=%d respond:%s", paramsyv.a(), Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length), paramBundle);
    }
    for (;;)
    {
      paramsyv.a().a(paramBundle.a, paramBundle.b, paramBundle);
      a(paramsyv, paramBundle.a, paramBundle.b, l);
      return;
      veg.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { paramsyv.a(), Integer.valueOf(paramBundle.a), paramBundle.b, Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length) });
      if (paramBundle.a == 10001) {
        veg.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%s", new Object[] { paramsyv.a(), paramsyv });
      }
    }
  }
  
  private boolean a(syv paramsyv)
  {
    return (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramsyv.b()))) && (paramsyv.b < paramsyv.a);
  }
  
  public void a(Bundle paramBundle, byte[] paramArrayOfByte)
  {
    Bosses.get().postJob(new szb(this, "Q.qqstory.net:QQStoryCmdHandler", paramBundle, paramArrayOfByte));
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
      veg.d("Q.qqstory.net:QQStoryCmdHandler", "update retry proto complete :%s", new Object[] { this.jdField_a_of_type_JavaUtilSet });
      return;
    }
    catch (Exception paramString)
    {
      veg.e("Q.qqstory.net:QQStoryCmdHandler", "update retry proto list error :%s", new Object[] { paramString.getMessage() });
    }
  }
  
  public void a(syv paramsyv)
  {
    try
    {
      if (!vyp.a(QQStoryContext.a().a()))
      {
        Bosses.get().scheduleJobDelayed(new syy(this, "Q.qqstory.net:QQStoryCmdHandler", paramsyv), 100);
        return;
      }
      Bosses.get().postJob(new syz(this, "Q.qqstory.net:QQStoryCmdHandler", paramsyv));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      veg.e("Q.qqstory.net:QQStoryCmdHandler", "send cmd:" + paramsyv.a() + " error:" + localIllegalArgumentException.getMessage());
      paramsyv.a().a(940001, localIllegalArgumentException.getMessage(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.QQStoryCmdHandler
 * JD-Core Version:    0.7.0.1
 */