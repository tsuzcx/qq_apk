package com.tencent.mobileqq.apollo.view;

import com.tencent.aekit.api.standard.filter.AEFilterManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class CmShowAESurfaceView$6
  implements Runnable
{
  CmShowAESurfaceView$6(CmShowAESurfaceView paramCmShowAESurfaceView) {}
  
  public void run()
  {
    CmShowAESurfaceView.a(this.this$0).setParam("SET_INIT_STICKERS", null);
    Iterator localIterator = CmShowAESurfaceView.a(this.this$0).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      CmShowAESurfaceView.a(this.this$0).setParam((String)localEntry.getKey(), localEntry.getValue());
    }
    CmShowAESurfaceView.a(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.CmShowAESurfaceView.6
 * JD-Core Version:    0.7.0.1
 */