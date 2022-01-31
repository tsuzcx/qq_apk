package com.tencent.biz.qqstory.takevideo.slideshow;

import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.concurrent.ConcurrentHashMap;

public class TransitionHandler
  extends BusinessHandler
{
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public TransitionHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public MediaFormat a()
  {
    return this.jdField_a_of_type_AndroidMediaMediaFormat;
  }
  
  public LocalMediaInfo a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (LocalMediaInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramLocalMediaInfo);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidMediaMediaFormat = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.TransitionHandler
 * JD-Core Version:    0.7.0.1
 */