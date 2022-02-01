package com.tencent.biz.qqcircle.fragments.content;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.ResponseBean;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.extendpb.QCircleTransFormHelper;
import com.tencent.biz.qqcircle.widgets.QCircleLayerStatusView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class QCircleContentPart$7
  implements Observer<ResponseBean>
{
  QCircleContentPart$7(QCircleContentPart paramQCircleContentPart) {}
  
  public void a(@Nullable ResponseBean paramResponseBean)
  {
    QCircleContentPart.j(this.a);
    if (paramResponseBean != null) {
      if ((!paramResponseBean.d) && (paramResponseBean.a != 0L) && ((!QCircleContentPart.k(this.a)) || (QCircleContentPart.a(paramResponseBean.a))))
      {
        if (QCircleContentPart.h(this.a) != null)
        {
          if (QCircleContentPart.a(paramResponseBean.a)) {
            QCircleContentPart.h(this.a).a(false);
          } else {
            QCircleContentPart.h(this.a).b(paramResponseBean.b);
          }
          QCircleContentPart.l(this.a);
          QLog.w("QCircleContentPart", 1, String.format("retCode:%s; msg:%s", new Object[] { String.valueOf(paramResponseBean.a), paramResponseBean.b }));
          if (QCircleContentPart.a(this.a) != null)
          {
            QCircleContentPart.a(this.a).clearData();
            QCircleContentPart.a(this.a).notifyDataSetChanged();
          }
        }
      }
      else
      {
        if (QCircleContentPart.h(this.a) != null) {
          QCircleContentPart.h(this.a).c();
        }
        if ((QCircleContentPart.a(this.a) != null) && (paramResponseBean.c != null))
        {
          if ((paramResponseBean.c instanceof FeedCloudRead.StGetFeedListRsp))
          {
            localObject = (ArrayList)((FeedCloudRead.StGetFeedListRsp)paramResponseBean.c).vecFeed.get();
            ArrayList localArrayList = QCircleTransFormHelper.a((List)localObject);
            if (paramResponseBean.d)
            {
              QCircleContentPart.a(this.a).addAll(localArrayList);
              QCircleContentPart.i(this.a);
            }
            else
            {
              QCircleContentPart.a(this.a).setDatas(localArrayList);
            }
            QCircleContentPart.a(this.a, paramResponseBean);
            QLog.i("QCircleContentPart", 2, String.format("get feedListData size :%d attachinfo:%s", new Object[] { Integer.valueOf(((ArrayList)localObject).size()), ((FeedCloudRead.StGetFeedListRsp)paramResponseBean.c).feedAttchInfo.get() }));
          }
          else if ((paramResponseBean.c instanceof FeedCloudRead.StGetFeedDetailRsp))
          {
            localObject = ((FeedCloudRead.StGetFeedDetailRsp)paramResponseBean.c).feed;
            QCircleContentPart.a(this.a).setDatas(new ArrayList(Arrays.asList(new FeedBlockData[] { new FeedBlockData((FeedCloudMeta.StFeed)localObject).c() })));
          }
          if ((QCircleContentPart.a(this.a).getItemCount() == 0) && (QCircleContentPart.m(this.a) != null) && (QCircleContentPart.m(this.a).getExtraTypeInfo() != null) && (QCircleContentPart.m(this.a).getExtraTypeInfo().pageType == 10)) {
            this.a.a(0.0F, 0.0F);
          }
        }
        Object localObject = this.a;
        QCircleContentPart.a((QCircleContentPart)localObject, QCircleContentPart.n((QCircleContentPart)localObject), paramResponseBean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentPart.7
 * JD-Core Version:    0.7.0.1
 */