package com.tencent.av.ui.effect.adapter;

import androidx.recyclerview.widget.GridLayoutManager;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.effect.view.MaterialRecyclerView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class MaterialAdapter$3
  implements Runnable
{
  MaterialAdapter$3(MaterialAdapter paramMaterialAdapter, String paramString, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    int k = ((GridLayoutManager)MaterialAdapter.b(this.this$0).getLayoutManager()).findFirstVisibleItemPosition();
    int m = ((GridLayoutManager)MaterialAdapter.b(this.this$0).getLayoutManager()).findLastVisibleItemPosition();
    int i = 0;
    Object localObject1;
    while (i < MaterialAdapter.a(this.this$0).size())
    {
      localObject1 = (QavListItemBase.ItemInfo)MaterialAdapter.a(this.this$0).get(i);
      if ((localObject1 != null) && (((QavListItemBase.ItemInfo)localObject1).a.equals(this.a)))
      {
        ((QavListItemBase.ItemInfo)localObject1).e = false;
        ((QavListItemBase.ItemInfo)localObject1).d = this.b;
        j = i;
        if (i < k) {
          break label213;
        }
        j = i;
        if (i > m) {
          break label213;
        }
        localObject1 = MaterialAdapter.b(this.this$0).getChildAt(i - k);
        j = i;
        if (!(localObject1 instanceof QavListItemBase)) {
          break label213;
        }
        j = i;
        if (!MaterialAdapter.b(this.this$0).getAdapter().equals(this.this$0)) {
          break label213;
        }
        localObject1 = (QavListItemBase)localObject1;
        if (this.b) {
          j = 1000;
        } else {
          j = -1;
        }
        ((QavListItemBase)localObject1).a(j);
        j = i;
        break label213;
      }
      i += 1;
    }
    int j = -1;
    label213:
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
      ((StringBuilder)localObject1).append(this.this$0.a);
      ((StringBuilder)localObject1).append("]");
      QLog.i("MaterialAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.b)
    {
      Object localObject2 = null;
      localObject1 = localObject2;
      if (this.this$0.a == j)
      {
        localObject1 = localObject2;
        if (j != -1) {
          localObject1 = (QavListItemBase.ItemInfo)MaterialAdapter.a(this.this$0).get(j);
        }
      }
      if (localObject1 != null) {
        this.this$0.a(this.c, (QavListItemBase.ItemInfo)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.adapter.MaterialAdapter.3
 * JD-Core Version:    0.7.0.1
 */