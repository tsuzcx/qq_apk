package com.tencent.biz.qqcircle.richframework.part.list.base;

import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class BaseListBlock$1
  implements Runnable
{
  BaseListBlock$1(BaseListBlock paramBaseListBlock, List paramList, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    List localList = this.a;
    if ((localList != null) && (localList.size() > 0))
    {
      if (this.b) {
        this.this$0.addAll(this.a);
      } else {
        this.this$0.setDatas(new ArrayList(this.a));
      }
      BaseListBlock.access$000(this.this$0);
      this.this$0.getLoadInfo().a(this.c);
    }
    else
    {
      QLog.e(this.this$0.getLogTag(), 1, "handleListDataRsp() return empty data");
      if (this.b)
      {
        if (this.this$0.getItemCount() > 0) {
          this.this$0.getLoadInfo().a(this.c);
        } else {
          QLog.d(this.this$0.getLogTag(), 1, "error state empty data,but execute load more");
        }
      }
      else
      {
        this.this$0.showEmptyView();
        this.this$0.clearData();
        this.this$0.notifyDataSetChanged();
      }
    }
    this.this$0.notifyLoadingComplete(true, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock.1
 * JD-Core Version:    0.7.0.1
 */