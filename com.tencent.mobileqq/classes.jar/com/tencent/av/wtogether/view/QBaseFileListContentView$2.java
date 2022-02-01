package com.tencent.av.wtogether.view;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class QBaseFileListContentView$2
  implements Runnable
{
  QBaseFileListContentView$2(QBaseFileListContentView paramQBaseFileListContentView) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.size() > 0))
    {
      Iterator localIterator = this.this$0.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = ((List)this.this$0.a.get(localObject)).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((FileManagerEntity)((Iterator)localObject).next()).sendCloudUnsuccessful()) {
            ((Iterator)localObject).remove();
          }
        }
      }
    }
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.view.QBaseFileListContentView.2
 * JD-Core Version:    0.7.0.1
 */