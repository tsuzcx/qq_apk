package com.tencent.biz.pubaccount.api.impl;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class PublicAccountDataManagerImpl$2
  implements Runnable
{
  public void run()
  {
    try
    {
      synchronized ()
      {
        int i = PublicAccountDataManagerImpl.access$000().size();
        if (i <= 0) {
          return;
        }
        ArrayList localArrayList = new ArrayList(i);
        localArrayList.addAll(PublicAccountDataManagerImpl.access$000());
        PublicAccountDataManagerImpl.access$000().clear();
        ??? = localArrayList.iterator();
        if (((Iterator)???).hasNext()) {
          ((PublicAccountDataManagerImpl.OnAfterMsgSyncListener)((Iterator)???).next()).a();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("Q.contacttab.pub", 2, "notifyOnAfterMsgSync", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountDataManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */