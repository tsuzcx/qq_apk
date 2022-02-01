package com.tencent.biz.qqcircle.widgets;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.fragments.chat.item.QCircleChatGiftRecordView;
import com.tencent.biz.qqcircle.polylike.flowlayout.QCircleFlowLayout;
import com.tencent.biz.qqcircle.polylike.flowlayout.QCircleFlowLayoutAdapter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.List;
import qqcircle.QQCircleFeedBase.StPolyLike;

class QCircleLightInteractPolyLikeWidget$PolyTagAdapter
  extends QCircleFlowLayoutAdapter<QQCircleFeedBase.StPolyLike>
{
  public QCircleLightInteractPolyLikeWidget$PolyTagAdapter(List<QQCircleFeedBase.StPolyLike> paramList)
  {
    super(localList);
  }
  
  public View a(QCircleFlowLayout paramQCircleFlowLayout, int paramInt, QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    paramQCircleFlowLayout = LayoutInflater.from(this.a.getContext()).inflate(2131626905, paramQCircleFlowLayout, false);
    ImageView localImageView = (ImageView)paramQCircleFlowLayout.findViewById(2131441604);
    Object localObject = (QCircleChatGiftRecordView)paramQCircleFlowLayout.findViewById(2131441863);
    if (paramStPolyLike.articleType.get() == 0)
    {
      ((QCircleChatGiftRecordView)localObject).setVisibility(8);
      localImageView.setVisibility(0);
      localObject = new Option();
      ((Option)localObject).setTargetView(localImageView).setUrl(paramStPolyLike.polyIconUrl.get());
      QCircleFeedPicLoader.g().loadImage((Option)localObject, null);
      return paramQCircleFlowLayout;
    }
    localImageView.setVisibility(8);
    ((QCircleChatGiftRecordView)localObject).setVisibility(0);
    ((QCircleChatGiftRecordView)localObject).setIconUrl(paramStPolyLike.polyIconUrl.get());
    ((QCircleChatGiftRecordView)localObject).setGiftCount(paramStPolyLike.count.get(), true);
    ((QCircleChatGiftRecordView)localObject).setUIStyle(paramStPolyLike.polyTxtColor.get(), paramStPolyLike.polyUnderColor.get());
    return paramQCircleFlowLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleLightInteractPolyLikeWidget.PolyTagAdapter
 * JD-Core Version:    0.7.0.1
 */