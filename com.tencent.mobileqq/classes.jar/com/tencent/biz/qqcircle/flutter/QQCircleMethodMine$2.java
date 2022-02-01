package com.tencent.biz.qqcircle.flutter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.flutter.layer.QCircleFlutterDanmakuLayer;
import com.tencent.biz.qqcircle.manager.QCircleSwitchConfigManager;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.Map;

final class QQCircleMethodMine$2
  implements Runnable
{
  QQCircleMethodMine$2(FeedCloudMeta.StFeed paramStFeed, Map paramMap, View paramView) {}
  
  public void run()
  {
    if (QQCircleMethodMine.access$000() == null) {
      QQCircleMethodMine.access$002(new QCircleFlutterDanmakuLayer(QCircleSkinHelper.getInstance().getContext()));
    } else {
      QQCircleMethodMine.access$000().i();
    }
    if (QQCircleMethodMine.access$000().s().getParent() != null) {
      QQCircleMethodMine.access$002(new QCircleFlutterDanmakuLayer(QCircleSkinHelper.getInstance().getContext()));
    }
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = new QCircleExtraTypeInfo();
    localQCircleExtraTypeInfo.mFeed = this.a;
    localQCircleExtraTypeInfo.mDataPosition = ((Integer)this.b.get("current_index")).intValue();
    localQCircleExtraTypeInfo.sourceType = ((Integer)this.b.get("source_type")).intValue();
    localQCircleExtraTypeInfo.mPlayScene = 2;
    localQCircleExtraTypeInfo.title = this.a.title.get();
    QQCircleMethodMine.access$000().a(localQCircleExtraTypeInfo);
    QQCircleMethodMine.access$000().s().setTag("danmu");
    ((ViewGroup)this.c).addView(QQCircleMethodMine.access$000().s());
    if ((this.c instanceof FrameLayout)) {
      ((FrameLayout.LayoutParams)QQCircleMethodMine.access$000().s().getLayoutParams()).topMargin = ViewUtils.a(50.0F);
    }
    if (QCircleSwitchConfigManager.a().b()) {
      QQCircleMethodMine.access$000().t();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QQCircleMethodMine.2
 * JD-Core Version:    0.7.0.1
 */