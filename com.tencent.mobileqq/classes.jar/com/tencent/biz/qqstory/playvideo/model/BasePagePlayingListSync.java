package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.List;
import nng;

public abstract class BasePagePlayingListSync
  extends DefaultPlayerVideoListSynchronizer
{
  public int a;
  public String a;
  public List a;
  public nng a;
  protected int b;
  public String b;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  
  public BasePagePlayingListSync(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(20);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = a();
  }
  
  protected abstract int a();
  
  public void a()
  {
    super.a();
    this.e = true;
    this.jdField_a_of_type_Nng = new nng(this);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_Nng);
  }
  
  protected boolean a(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean) {
      SLog.b("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "not preload for end");
    }
    do
    {
      return false;
      if (this.c)
      {
        SLog.b("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "can't preload for loading");
        return false;
      }
      paramInt = this.jdField_a_of_type_Int - paramInt;
    } while (paramInt >= 2);
    SLog.a("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "can preload for left size:%d, preload size:%d", Integer.valueOf(paramInt), Integer.valueOf(2));
    return true;
  }
  
  public void b()
  {
    super.b();
    this.e = false;
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_Nng);
  }
  
  protected void b(int paramInt)
  {
    if ((paramInt == -1) && (!this.jdField_a_of_type_Boolean)) {
      c();
    }
    if (a(paramInt)) {
      d();
    }
  }
  
  protected abstract void c();
  
  protected abstract void d();
  
  public boolean isValidate()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.BasePagePlayingListSync
 * JD-Core Version:    0.7.0.1
 */