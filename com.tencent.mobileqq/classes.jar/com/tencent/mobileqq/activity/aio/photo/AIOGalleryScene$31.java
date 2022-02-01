package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.util.Iterator;
import java.util.List;

class AIOGalleryScene$31
  implements Runnable
{
  AIOGalleryScene$31(AIOGalleryScene paramAIOGalleryScene, long paramLong, AIORichMediaInfo paramAIORichMediaInfo, boolean paramBoolean) {}
  
  public void run()
  {
    long l1 = this.a;
    long l2 = this.b.a.L;
    boolean bool = true;
    int j = 0;
    Object localObject;
    int i;
    if ((l1 != l2) && (!this.c))
    {
      if (this.this$0.c.a(this.a) == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onRevokeMsg seq:");
          ((StringBuilder)localObject).append(this.a);
          ((StringBuilder)localObject).append(", selectItem seq:");
          ((StringBuilder)localObject).append(this.b.a.L);
          QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      localObject = this.this$0.c.i();
      Iterator localIterator = ((List)localObject).iterator();
      AIORichMediaInfo localAIORichMediaInfo;
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        localAIORichMediaInfo = (AIORichMediaInfo)localIterator.next();
      } while (localAIORichMediaInfo.a.L != this.b.a.L);
      i = ((List)localObject).indexOf(localAIORichMediaInfo);
      if (i >= 0)
      {
        this.this$0.a.a(true);
        AIOGalleryScene.S(this.this$0).setSelection(i);
      }
    }
    else
    {
      i = this.this$0.V.a(this.b.a.L, this.b.a.M);
      if ((i < 0) || (i >= 100)) {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onRevokeMsg isSaving:");
        ((StringBuilder)localObject).append(bool);
        QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
      }
      AIOGalleryScene.a(this.this$0, this.b, bool);
      AIOGalleryMsgRevokeMgr.a(AIOGalleryScene.Q(this.this$0), AIOGalleryScene.R(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.31
 * JD-Core Version:    0.7.0.1
 */