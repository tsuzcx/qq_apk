package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

@Deprecated
public class ParallelStepExecutor
  extends SimpleStepExector
  implements Handler.Callback
{
  public volatile int a;
  protected Handler a;
  protected ErrorMessage a;
  private String a;
  protected LinkedHashMap<String, Step> a;
  protected Vector<Step> a;
  protected boolean a;
  private Handler b = new Handler(paramLooper, this);
  private Handler c;
  
  public ParallelStepExecutor(Looper paramLooper)
  {
    this.jdField_a_of_type_JavaLangString = "ParallelStepExecutor";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Int = 0;
  }
  
  private void b(String paramString)
  {
    if (paramString == null)
    {
      SLog.e("Q.qqstory.home.ParallelStepExecutor", "occur error ! step key is null!!");
      return;
    }
    SLog.e("Q.qqstory.home.ParallelStepExecutor", "%s have been finish", new Object[] { paramString });
    this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramString);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() == 0)
    {
      SLog.b("Q.qqstory.home.ParallelStepExecutor", "all step have finish");
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$CompletedHandler != null)
      {
        this.jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$ErrorHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
        } else {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$CompletedHandler.a();
        }
      }
      d();
    }
  }
  
  public ParallelStepExecutor a(SimpleStepExector.CompletedHandler paramCompletedHandler)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$CompletedHandler = paramCompletedHandler;
    return this;
  }
  
  public ParallelStepExecutor a(SimpleStepExector.ErrorHandler paramErrorHandler)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$ErrorHandler = paramErrorHandler;
    return this;
  }
  
  public ParallelStepExecutor a(Step paramStep)
  {
    SLog.a("Q.qqstory.home.ParallelStepExecutor", "add Step:%s", paramStep.a());
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramStep.a(), paramStep);
    this.jdField_a_of_type_Int = 0;
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    try
    {
      SLog.d("Q.qqstory.home.ParallelStepExecutor", "startAsyncStep count=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashMap.size()) });
      if (this.jdField_a_of_type_Int == 2)
      {
        SLog.e("Q.qqstory.home.ParallelStepExecutor", "startAsyncStep but state is done ,so ingore this start operate");
        return;
      }
      this.jdField_a_of_type_Int = 1;
      if (this.c == null) {
        this.c = new Handler(Looper.myLooper(), this);
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Step localStep = (Step)((Map.Entry)localIterator.next()).getValue();
        localStep.a(this);
        localStep.a(this);
        this.b.obtainMessage(2, localStep).sendToTarget();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(ErrorMessage paramErrorMessage)
  {
    SLog.e("Q.qqstory.home.ParallelStepExecutor", "occur error:%s", new Object[] { paramErrorMessage.getErrorMessage() });
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    a(paramErrorMessage.extraMsg);
  }
  
  public void a(String paramString)
  {
    try
    {
      int i = this.jdField_a_of_type_Int;
      if (i == 3) {
        return;
      }
      if (this.c != null)
      {
        this.c.obtainMessage(1, paramString).sendToTarget();
      }
      else
      {
        SLog.e("Q.qqstory.home.ParallelStepExecutor", "there is no mCompletedHandler !!!!");
        b(paramString);
      }
      return;
    }
    finally {}
  }
  
  public void b() {}
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      if (this.c != null) {
        this.c.removeMessages(1);
      }
      if (this.b != null) {
        this.b.removeMessages(2);
      }
      SLog.b("Q.qqstory.home.ParallelStepExecutor", "reset!");
      if (this.jdField_a_of_type_JavaUtilVector.size() > 0)
      {
        SLog.b("Q.qqstory.home.ParallelStepExecutor", "reset premissSteps");
        ((Step)this.jdField_a_of_type_JavaUtilVector.get(0)).c();
        this.jdField_a_of_type_JavaUtilVector.clear();
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Step localStep = (Step)((Map.Entry)localIterator.next()).getValue();
        if (localStep != null) {
          localStep.c();
        }
      }
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return true;
      }
      ((Step)paramMessage.obj).a();
      return true;
    }
    b((String)paramMessage.obj);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.ParallelStepExecutor
 * JD-Core Version:    0.7.0.1
 */