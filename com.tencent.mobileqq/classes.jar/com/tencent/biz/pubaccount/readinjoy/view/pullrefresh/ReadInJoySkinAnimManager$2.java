package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import java.util.ArrayList;
import sgt;

class ReadInJoySkinAnimManager$2
  implements Runnable
{
  int a = 0;
  
  ReadInJoySkinAnimManager$2(ReadInJoySkinAnimManager paramReadInJoySkinAnimManager) {}
  
  public void run()
  {
    if ((ReadInJoySkinAnimManager.a(this.this$0) != null) && (ReadInJoySkinAnimManager.a(this.this$0).size() > 0))
    {
      if (this.a >= ReadInJoySkinAnimManager.a(this.this$0).size()) {
        this.a = 0;
      }
      ReadInJoySkinAnimManager localReadInJoySkinAnimManager = this.this$0;
      ArrayList localArrayList = ReadInJoySkinAnimManager.a(this.this$0);
      int i = this.a;
      this.a = (i + 1);
      ReadInJoySkinAnimManager.a(localReadInJoySkinAnimManager, ((sgt)localArrayList.get(i)).a);
      ((SkinPullRefreshHeader)this.this$0.a).requestLayout();
      ((SkinPullRefreshHeader)this.this$0.a).postDelayed(this, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager.2
 * JD-Core Version:    0.7.0.1
 */