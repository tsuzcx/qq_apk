package com.tencent.biz.qqstory.takevideo.slideshow;

import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class TransitionHandler
  extends BusinessHandler
{
  private ConcurrentHashMap<String, LocalMediaInfo> a = new ConcurrentHashMap();
  private MediaFormat b;
  
  public TransitionHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public MediaFormat a()
  {
    return this.b;
  }
  
  public LocalMediaInfo a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (LocalMediaInfo)this.a.get(paramString);
    }
    return null;
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    this.b = paramMediaFormat;
  }
  
  public void a(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCatcheMediaInfo path : ");
      localStringBuilder.append(paramString);
      QLog.d("SlideShowProcessor", 2, localStringBuilder.toString());
    }
    this.a.put(paramString, paramLocalMediaInfo);
  }
  
  public void b()
  {
    this.b = null;
    this.a.clear();
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowProcessor", 2, "clearCatcheMediaInfo");
    }
  }
  
  public boolean b(String paramString)
  {
    return this.a.containsKey(paramString);
  }
  
  public void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.remove(paramString);
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.TransitionHandler
 * JD-Core Version:    0.7.0.1
 */