package com.tencent.mobileqq.activity.aio.core;

import amrg;
import avsq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

class BaseChatPie$62
  implements Runnable
{
  BaseChatPie$62(BaseChatPie paramBaseChatPie, String paramString1, String paramString2) {}
  
  public void run()
  {
    int i = 9;
    int m = 0;
    int j = BaseChatPie.access$1500(this.this$0).b(this.val$keyword);
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.tag, 2, this.val$text + "is hotword, totalnum = " + j);
    }
    if (j == 0) {
      return;
    }
    Object localObject3 = BaseChatPie.access$1500(this.this$0).a(this.val$keyword);
    Object localObject2 = BaseChatPie.access$1500(this.this$0).b(this.val$keyword);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    if (j > 9) {}
    for (;;)
    {
      long l = BaseChatPie.access$1500(this.this$0).a(this.val$keyword);
      boolean bool;
      if (BaseChatPie.access$1500(this.this$0).a()) {
        if (System.currentTimeMillis() - l > 86400000L) {
          bool = true;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.tag, 2, "afterTextChanged isNeedReq = " + bool);
        }
        if (bool)
        {
          ((List)localObject1).clear();
          localObject2 = new ArrayList();
          j = i;
          int k = m;
          if (localObject3 != null)
          {
            ((List)localObject2).add(((Emoticon)localObject3).eId);
            ((List)localObject1).add(localObject3);
            j = i - 1;
            k = m;
          }
          for (;;)
          {
            if (k < j)
            {
              localObject3 = new Emoticon();
              ((Emoticon)localObject3).epId = "NONE";
              ((Emoticon)localObject3).eId = ("_" + k);
              ((List)localObject1).add(localObject3);
              k += 1;
              continue;
              if (((List)localObject1).size() >= i) {
                break label411;
              }
              bool = true;
              break;
            }
          }
          localObject3 = BaseChatPie.access$1500(this.this$0).c(this.val$keyword);
          ((amrg)this.this$0.app.getBusinessHandler(12)).a(this.val$text, (List)localObject2, (List)localObject3);
        }
        this.this$0.uiHandler.post(new BaseChatPie.62.1(this, (List)localObject1));
        return;
        label411:
        bool = false;
      }
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.62
 * JD-Core Version:    0.7.0.1
 */