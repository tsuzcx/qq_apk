package com.tencent.biz.richframework.part.list.base;

import aabu;
import aacr;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class BaseListBlock$1
  implements Runnable
{
  public BaseListBlock$1(aacr paramaacr, List paramList, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      if (this.jdField_a_of_type_Boolean)
      {
        this.this$0.addAll(this.jdField_a_of_type_JavaUtilList);
        aacr.access$000(this.this$0);
        this.this$0.getLoadInfo().a(this.b);
      }
    }
    for (;;)
    {
      this.this$0.notifyLoadingComplete(true, this.b);
      return;
      this.this$0.setDatas(new ArrayList(this.jdField_a_of_type_JavaUtilList));
      break;
      QLog.e(this.this$0.getLogTag(), 1, "handleListDataRsp() return empty data");
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.this$0.getItemCount() > 0) {
          this.this$0.getLoadInfo().a(this.b);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.list.base.BaseListBlock.1
 * JD-Core Version:    0.7.0.1
 */