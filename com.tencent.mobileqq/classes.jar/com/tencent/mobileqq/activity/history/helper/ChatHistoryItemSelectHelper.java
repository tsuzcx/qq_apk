package com.tencent.mobileqq.activity.history.helper;

import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ChatHistoryItemSelectHelper
{
  ArrayList<Object> a = new ArrayList();
  
  private boolean c()
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
  
  public void a()
  {
    this.a.clear();
  }
  
  public boolean a(Object paramObject)
  {
    return this.a.contains(paramObject);
  }
  
  public List<Object> b()
  {
    return this.a;
  }
  
  public void b(Object paramObject)
  {
    if (a(paramObject))
    {
      this.a.remove(paramObject);
      return;
    }
    if (c())
    {
      FMToastUtil.a(2131889426);
      return;
    }
    this.a.add(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.helper.ChatHistoryItemSelectHelper
 * JD-Core Version:    0.7.0.1
 */