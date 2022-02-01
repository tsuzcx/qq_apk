package com.tencent.mobileqq.apollo.process.chanel;

import anbz;
import anca;
import anmc;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVRoomMulti;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class CmGameAvHandler$11
  implements Runnable
{
  public CmGameAvHandler$11(anbz paramanbz, Boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a.booleanValue()) {
      if (anbz.a(this.this$0).size() > 0)
      {
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject == null) || (!(localObject instanceof QQAppInterface))) {
          break label115;
        }
      }
    }
    label115:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject == null) {
        return;
      }
      localObject = ((QQAppInterface)localObject).c();
      anbz.a(this.this$0, (String[])anbz.a(this.this$0).toArray(new String[anbz.a(this.this$0).size()]), (String)localObject);
      return;
      anmc.a(BaseApplicationImpl.getContext()).a().getRoom().cancelAllView(new anca(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.11
 * JD-Core Version:    0.7.0.1
 */