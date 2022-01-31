package com.tencent.biz.pubaccount;

import com.tencent.common.app.AppInterface;
import java.util.ArrayList;
import java.util.List;
import nkw;

public class EncryptUinHandler$3
  implements Runnable
{
  public EncryptUinHandler$3(nkw paramnkw) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(this.this$0.mApp.getLongAccountUin()));
    nkw.a(this.this$0, localArrayList, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.EncryptUinHandler.3
 * JD-Core Version:    0.7.0.1
 */