package com.tencent.mobileqq.activity.history.helper;

import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ChatHistoryItemSelectHelper
{
  ArrayList<Object> a = new ArrayList();
  
  private boolean a()
  {
    ArrayList localArrayList = this.a;
    boolean bool = false;
    int i;
    if (localArrayList != null) {
      i = localArrayList.size() + 0;
    } else {
      i = 0;
    }
    if (i >= 20) {
      bool = true;
    }
    if ((bool) && (QLog.isColorLevel())) {
      QLog.d("Q.history.", 2, "isOverLimit");
    }
    return bool;
  }
  
  public List<Object> a()
  {
    return this.a;
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(Object paramObject)
  {
    if (a(paramObject))
    {
      this.a.remove(paramObject);
      return;
    }
    if (a())
    {
      FMToastUtil.a(2131692438);
      return;
    }
    this.a.add(paramObject);
  }
  
  public boolean a(Object paramObject)
  {
    return this.a.contains(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.helper.ChatHistoryItemSelectHelper
 * JD-Core Version:    0.7.0.1
 */