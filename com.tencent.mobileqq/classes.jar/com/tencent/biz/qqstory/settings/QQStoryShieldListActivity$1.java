package com.tencent.biz.qqstory.settings;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

class QQStoryShieldListActivity$1
  extends QQStoryObserver
{
  private List<QQStoryUserInfo> b = new ArrayList();
  
  QQStoryShieldListActivity$1(QQStoryShieldListActivity paramQQStoryShieldListActivity) {}
  
  private void a(List<QQStoryUserInfo> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new QQStoryShieldListActivity.1.1(this, paramList));
  }
  
  public void a(boolean paramBoolean1, List<QQStoryUserInfo> paramList, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString)
  {
    if (!TextUtils.equals(QQStoryShieldListActivity.a(this.a), paramString)) {
      return;
    }
    if (paramBoolean1)
    {
      if (!paramBoolean2)
      {
        this.b.addAll(paramList);
        paramList = this.a.g;
        if (this.a.a == 2) {
          paramBoolean1 = true;
        } else {
          paramBoolean1 = false;
        }
        paramList.a(paramArrayOfByte, 10, paramBoolean1, QQStoryShieldListActivity.a(this.a));
        return;
      }
      this.b.addAll(paramList);
      this.a.a(this.b);
      paramList = new ArrayList(this.b);
      if (this.a.a == 2) {
        this.a.f.z = paramList;
      } else {
        this.a.f.y = paramList;
      }
      this.a.f.A.clear();
      paramArrayOfByte = paramList.iterator();
      while (paramArrayOfByte.hasNext())
      {
        paramString = (QQStoryUserInfo)paramArrayOfByte.next();
        this.a.f.A.put(paramString.uin, paramString);
      }
      a(paramList);
      QQStoryShieldListActivity.b(this.a);
      this.b.clear();
      return;
    }
    QQStoryShieldListActivity.c(this.a);
    this.b.clear();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a.i.b();
    if (paramBoolean1)
    {
      List localList = this.a.f.j(paramBoolean3);
      this.a.a(localList);
      return;
    }
    QQToast.makeText(this.a, 2131892409, 0).show(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity.1
 * JD-Core Version:    0.7.0.1
 */