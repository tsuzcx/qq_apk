package com.tencent.av.wtogether.view;

import android.os.Handler;
import com.tencent.av.wtogether.observer.WatchTogetherObserver;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData;
import java.util.ArrayList;
import java.util.List;

class GroupFileSearchDialog$7
  extends WatchTogetherObserver
{
  GroupFileSearchDialog$7(GroupFileSearchDialog paramGroupFileSearchDialog) {}
  
  public void a(int paramInt, String paramString)
  {
    paramString = this.a;
    paramString.x -= 1;
    if (this.a.t) {
      paramString = this.a.n.obtainMessage(3);
    } else {
      paramString = this.a.n.obtainMessage(5);
    }
    this.a.n.sendMessage(paramString);
  }
  
  public void a(String arg1, String paramString2, int paramInt1, int paramInt2, List<TroopFileSearchItemData> paramList)
  {
    paramString2 = this.a;
    int i = paramString2.x;
    boolean bool = true;
    paramString2.x = (i - 1);
    paramString2 = this.a;
    paramString2.y = ???;
    paramString2.A = paramInt2;
    paramInt2 = 0;
    if (paramInt1 != 1) {
      bool = false;
    }
    paramString2.z = bool;
    synchronized (this.a.r)
    {
      if (this.a.D != null) {
        this.a.D.clear();
      } else {
        this.a.D = new ArrayList();
      }
      paramInt1 = paramInt2;
      while (paramInt1 < paramList.size()) {
        synchronized (this.a.r)
        {
          this.a.D.add(paramList.get(paramInt1));
          paramInt1 += 1;
        }
      }
      ??? = this.a.n.obtainMessage(5);
      this.a.n.sendMessage(???);
      return;
    }
    for (;;)
    {
      throw paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.GroupFileSearchDialog.7
 * JD-Core Version:    0.7.0.1
 */