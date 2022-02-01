package com.tencent.biz.qqcircle.immersive.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.richframework.part.utils.RFWViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.base.UIStateData.ModifyListRecord;
import com.tencent.richframework.data.base.UIStateData.ModifyListRecordUser;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.ArrayList;
import java.util.List;

public abstract class QFSBaseListViewAdapter<E>
  extends BaseListViewAdapter<E>
  implements UIStateData.ModifyListRecordUser<E>
{
  protected UIStateData.ModifyListRecord a;
  
  private Object b()
  {
    if (this.mRecyclerView == null) {
      return null;
    }
    return RFWViewUtils.a(BasePartFragment.E, this.mRecyclerView);
  }
  
  private void b(List<E> paramList, UIStateData.ModifyListRecord paramModifyListRecord)
  {
    this.mDataList.clear();
    this.mDataList.addAll(paramList);
    int i = paramModifyListRecord.b();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            QLog.e("QFSBaseListViewAdapter", 1, "unSupportModifyRecord");
            return;
          }
          notifyItemRangeRemoved(paramModifyListRecord.d(), paramModifyListRecord.c());
          QLog.d("QFSBaseListViewAdapter", 1, new Object[] { "notifyWithModifyRecord notifyItemRangeRemoved start:", Integer.valueOf(paramModifyListRecord.d()), ",count:", Integer.valueOf(paramModifyListRecord.c()) });
          return;
        }
        notifyItemRangeInserted(paramModifyListRecord.d(), paramModifyListRecord.c());
        QLog.d("QFSBaseListViewAdapter", 1, new Object[] { "notifyWithModifyRecord notifyItemRangeInserted start:", Integer.valueOf(paramModifyListRecord.d()), ",count:", Integer.valueOf(paramModifyListRecord.c()) });
        return;
      }
      notifyItemRangeChanged(paramModifyListRecord.d(), paramModifyListRecord.c());
      QLog.d("QFSBaseListViewAdapter", 1, new Object[] { "notifyWithModifyRecord notifyItemRangeChanged start:", Integer.valueOf(paramModifyListRecord.d()), ",count:", Integer.valueOf(paramModifyListRecord.c()) });
      return;
    }
    notifyDataSetChanged();
    QLog.d("QFSBaseListViewAdapter", 1, "notifyWithModifyRecord notifyDataSetChanged");
  }
  
  public QCircleReportBean a()
  {
    Object localObject = b();
    if (!(localObject instanceof QCircleReportBean))
    {
      if (!RFApplication.isDebug())
      {
        QLog.e("QFSBaseListViewAdapter", 1, "getReportBean but FSReportBean is null");
        return new QCircleReportBean();
      }
      QLog.e("QFSBaseListViewAdapter", 1, "getReportBean but FSReportBean is null , debug");
      throw new RuntimeException("getReportBean but FSReportBean is null");
    }
    return (QCircleReportBean)localObject;
  }
  
  public void a(UIStateData<List<E>> paramUIStateData)
  {
    if (paramUIStateData == null) {
      return;
    }
    a((List)paramUIStateData.e(), paramUIStateData.n());
  }
  
  public void a(List<E> paramList, UIStateData.ModifyListRecord paramModifyListRecord)
  {
    if (paramModifyListRecord == null)
    {
      QLog.d("QFSBaseListViewAdapter", 1, "no record direct set data");
      setDatas(paramList);
      return;
    }
    if (paramModifyListRecord == this.a)
    {
      paramList = new StringBuilder();
      paramList.append("allReady apply record ");
      paramList.append(this.a.hashCode());
      QLog.d("QFSBaseListViewAdapter", 1, paramList.toString());
      return;
    }
    this.a = paramModifyListRecord;
    b(paramList, paramModifyListRecord);
  }
  
  public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if (!(paramViewHolder.itemView instanceof QCircleBaseWidgetView)) {
      return;
    }
    ((QCircleBaseWidgetView)paramViewHolder.itemView).setCacheReportBean(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.adapter.QFSBaseListViewAdapter
 * JD-Core Version:    0.7.0.1
 */