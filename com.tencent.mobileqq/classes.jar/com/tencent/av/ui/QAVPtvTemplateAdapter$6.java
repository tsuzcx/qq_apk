package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

class QAVPtvTemplateAdapter$6
  implements Runnable
{
  QAVPtvTemplateAdapter$6(QAVPtvTemplateAdapter paramQAVPtvTemplateAdapter, String paramString, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    int k = this.this$0.g.getFirstVisiblePosition();
    int m = this.this$0.g.getLastVisiblePosition();
    int i = 0;
    Object localObject1;
    while (i < this.this$0.a.size())
    {
      localObject1 = (QavListItemBase.ItemInfo)this.this$0.a.get(i);
      if ((localObject1 != null) && (((QavListItemBase.ItemInfo)localObject1).a.equals(this.a)))
      {
        ((QavListItemBase.ItemInfo)localObject1).e = false;
        ((QavListItemBase.ItemInfo)localObject1).d = this.b;
        j = i;
        if (i < k) {
          break label195;
        }
        j = i;
        if (i > m) {
          break label195;
        }
        localObject1 = this.this$0.g.getChildAt(i - k);
        j = i;
        if (!(localObject1 instanceof QavListItemBase)) {
          break label195;
        }
        j = i;
        if (!this.this$0.g.getAdapter().equals(this.this$0)) {
          break label195;
        }
        localObject1 = (QavListItemBase)localObject1;
        if (this.b) {
          j = 1000;
        } else {
          j = -1;
        }
        ((QavListItemBase)localObject1).a(j);
        j = i;
        break label195;
      }
      i += 1;
    }
    int j = -1;
    label195:
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onDownloadFinish, seq[");
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append("], id[");
      ((StringBuilder)localObject1).append(this.a);
      ((StringBuilder)localObject1).append("], suc[");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append("], sel[");
      ((StringBuilder)localObject1).append(this.this$0.j);
      ((StringBuilder)localObject1).append("]");
      QLog.i("QAVPtvTemplateAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.b)
    {
      Object localObject2 = null;
      localObject1 = localObject2;
      if (this.this$0.j == j)
      {
        localObject1 = localObject2;
        if (j != -1) {
          localObject1 = (QavListItemBase.ItemInfo)this.this$0.a.get(j);
        }
      }
      if (localObject1 != null) {
        this.this$0.a(this.c, (QavListItemBase.ItemInfo)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QAVPtvTemplateAdapter.6
 * JD-Core Version:    0.7.0.1
 */