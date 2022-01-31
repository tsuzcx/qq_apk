package com.tencent.biz.qqstory.comment.lego;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class LegoBase
{
  public Context a;
  private LegoBase jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoBase;
  protected LegoDataProvider a;
  public LegoEvenHandler a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  public View b;
  
  public LegoBase(Context paramContext, int paramInt)
  {
    this.b = LayoutInflater.from(paramContext).inflate(paramInt, null, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public LegoBase(Context paramContext, View paramView)
  {
    this.b = paramView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public LegoBase a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoBase;
  }
  
  public LegoBase a(String paramString)
  {
    return (LegoBase)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public abstract LegoDataProvider a();
  
  public abstract LegoEvenHandler a();
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((LegoBase)this.jdField_a_of_type_JavaUtilHashMap.get(str)).a();
    }
  }
  
  public abstract void a(Context paramContext, View paramView);
  
  public void a(LegoEvenHandler paramLegoEvenHandler)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoEvenHandler = paramLegoEvenHandler;
  }
  
  public void a(String paramString, LegoBase paramLegoBase)
  {
    paramLegoBase.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoBase = this;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramLegoBase);
  }
  
  public abstract void a(List paramList);
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public abstract void b();
  
  public void b(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void c(List paramList)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.b != null) {
      this.b.setVisibility(0);
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    a(paramList);
  }
  
  public void k()
  {
    if (this.b != null) {
      this.b.setVisibility(8);
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.b != null) {
      this.b.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoEvenHandler == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoEvenHandler = a();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoDataProvider == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoDataProvider = a();
    }
    a(this.jdField_a_of_type_AndroidContentContext, this.b);
    b();
    if (this.jdField_a_of_type_JavaUtilList != null) {
      a(this.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((LegoBase)this.jdField_a_of_type_JavaUtilHashMap.get(str)).l();
      }
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoDataProvider != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoDataProvider.a();
      } else {
        a(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.lego.LegoBase
 * JD-Core Version:    0.7.0.1
 */