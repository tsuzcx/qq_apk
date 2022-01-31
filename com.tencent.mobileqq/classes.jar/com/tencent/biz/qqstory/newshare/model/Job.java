package com.tencent.biz.qqstory.newshare.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FeedUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Job
{
  public Job.JobExecutorCallback a;
  public ConcurrentHashMap a;
  public boolean a;
  public final String b;
  public boolean b;
  
  public Job()
  {
    this.jdField_b_of_type_JavaLangString = ("Q.qqstory.share" + getClass().getSimpleName());
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public final Job a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    return this;
  }
  
  public Object a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      SLog.a(this.jdField_b_of_type_JavaLangString, "getResult key %s, result %s, stack = %s", String.valueOf(paramString), String.valueOf(localObject), FeedUtils.a(7));
      return localObject;
    }
    SLog.a(this.jdField_b_of_type_JavaLangString, "getResult key %s, result null, stack = %s", String.valueOf(paramString), FeedUtils.a(7));
    return null;
  }
  
  public abstract void a();
  
  public void a(String paramString, Object paramObject)
  {
    SLog.a(this.jdField_b_of_type_JavaLangString, "putResult key %s, value %s, stack = %s", String.valueOf(paramString), String.valueOf(paramObject), FeedUtils.a(7));
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramObject);
    }
  }
  
  public abstract void a(Map paramMap);
  
  public final void a(boolean paramBoolean)
  {
    SLog.a(this.jdField_b_of_type_JavaLangString, "onJobFinish %b, stack = %s", Boolean.valueOf(paramBoolean), FeedUtils.a(7));
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJob$JobExecutorCallback != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJob$JobExecutorCallback.b(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public final void b(boolean paramBoolean)
  {
    SLog.a(this.jdField_b_of_type_JavaLangString, "onRunFinish %b, stack = %s", Boolean.valueOf(paramBoolean), FeedUtils.a(7));
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJob$JobExecutorCallback != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJob$JobExecutorCallback.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.model.Job
 * JD-Core Version:    0.7.0.1
 */