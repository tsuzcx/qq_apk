package com.tencent.biz.pubaccount;

import com.tencent.common.app.AppInterface;
import java.util.ArrayList;
import java.util.List;

class EncryptUinHandler$3
  implements Runnable
{
  EncryptUinHandler$3(EncryptUinHandler paramEncryptUinHandler) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(EncryptUinHandler.a(this.this$0).getLongAccountUin()));
    EncryptUinHandler.a(this.this$0, localArrayList, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.EncryptUinHandler.3
 * JD-Core Version:    0.7.0.1
 */