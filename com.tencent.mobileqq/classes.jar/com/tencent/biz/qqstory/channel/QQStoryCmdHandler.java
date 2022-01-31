package com.tencent.biz.qqstory.channel;

import alud;
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
import uro;
import urt;
import uru;
import urv;
import urw;
import urx;
import urz;
import usa;
import usb;
import wxe;
import wxj;
import xrn;

public class QQStoryCmdHandler
{
  public Handler a;
  public List<usb> a;
  private Map<Integer, urt> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public Set<Integer> a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(100);
  
  public QQStoryCmdHandler()
  {
    this.jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    Bosses.get().postJob(new urv(this, "Q.qqstory.net:QQStoryCmdHandler"));
  }
  
  private void a(urt paramurt, int paramInt, String paramString, long paramLong)
  {
    wxj.b("story_net", paramurt.a(), 0, paramInt, new String[] { paramString, String.valueOf(paramLong), wxj.a(BaseApplication.getContext()) });
  }
  
  private void a(urt paramurt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    long l = paramBundle.getLong("start_time");
    l = System.currentTimeMillis() - l;
    int i = paramBundle.getInt("data_error_code");
    if (i != 0)
    {
      paramArrayOfByte = paramBundle.getString("data_error_msg");
      if (((i == 2901) || (i == 1002) || (i == 1003)) && (a(paramurt)))
      {
        wxe.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramurt.a() + " channel error:%d, msg:%s, take time:%d ,retry time:%d , retry now", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l), Integer.valueOf(paramurt.b) });
        paramurt.b += 1;
        paramArrayOfByte = Bosses.get();
        paramurt = new usa(this, "Q.qqstory.net:QQStoryCmdHandler", paramurt);
        if (i == 2901) {}
        for (i = 500;; i = 2000)
        {
          paramArrayOfByte.scheduleJobDelayed(paramurt, i);
          return;
        }
      }
      paramurt.a().a(i, alud.a(2131711205), null);
      wxe.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramurt.a() + " channel error:%d, msg:%s, take time:%d", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l) });
      a(paramurt, i, paramArrayOfByte, l);
      return;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      paramurt.a().a(-1, "channel error null data", null);
      wxe.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramurt.a() + " channel error null data, take time:%d", new Object[] { Long.valueOf(l) });
      a(paramurt, 940002, "rsp data error", l);
      return;
    }
    paramBundle = null;
    try
    {
      uro localuro = paramurt.a(paramArrayOfByte);
      paramBundle = localuro;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        wxe.c("Q.qqstory.net:QQStoryCmdHandler", "decode pb fail", localException);
      }
    }
    if (paramBundle == null)
    {
      wxe.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error. response is null", new Object[] { paramurt.a() });
      a(paramurt, 940002, "response is null", l);
      return;
    }
    if (paramBundle.a == 0) {
      wxe.a("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s success take time:%d data length=%d respond:%s", paramurt.a(), Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length), paramBundle);
    }
    for (;;)
    {
      paramurt.a().a(paramBundle.a, paramBundle.b, paramBundle);
      a(paramurt, paramBundle.a, paramBundle.b, l);
      return;
      wxe.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { paramurt.a(), Integer.valueOf(paramBundle.a), paramBundle.b, Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length) });
      if (paramBundle.a == 10001) {
        wxe.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%s", new Object[] { paramurt.a(), paramurt });
      }
    }
  }
  
  private boolean a(urt paramurt)
  {
    return (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramurt.b()))) && (paramurt.b < paramurt.a);
  }
  
  public void a(Bundle paramBundle, byte[] paramArrayOfByte)
  {
    Bosses.get().postJob(new urz(this, "Q.qqstory.net:QQStoryCmdHandler", paramBundle, paramArrayOfByte));
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
      wxe.d("Q.qqstory.net:QQStoryCmdHandler", "update retry proto complete :%s", new Object[] { this.jdField_a_of_type_JavaUtilSet });
      return;
    }
    catch (Exception paramString)
    {
      wxe.e("Q.qqstory.net:QQStoryCmdHandler", "update retry proto list error :%s", new Object[] { paramString.getMessage() });
    }
  }
  
  public void a(urt paramurt)
  {
    try
    {
      if (!xrn.a(QQStoryContext.a().a()))
      {
        Bosses.get().scheduleJobDelayed(new urw(this, "Q.qqstory.net:QQStoryCmdHandler", paramurt), 100);
        return;
      }
      Bosses.get().postJob(new urx(this, "Q.qqstory.net:QQStoryCmdHandler", paramurt));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      wxe.e("Q.qqstory.net:QQStoryCmdHandler", "send cmd:" + paramurt.a() + " error:" + localIllegalArgumentException.getMessage());
      paramurt.a().a(940001, localIllegalArgumentException.getMessage(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.QQStoryCmdHandler
 * JD-Core Version:    0.7.0.1
 */