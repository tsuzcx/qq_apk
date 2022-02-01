package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalFeedInfo;
import com.tencent.biz.qqcircle.immersive.utils.QFSCommonUtil;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StVisitor;

public class QFSPersonalFeedItemView
  extends QCircleBaseWidgetView<QFSPersonalFeedInfo>
{
  private ImageView a;
  private ImageView b;
  private ImageView c;
  private TextView d;
  private String e;
  
  public QFSPersonalFeedItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    if (TextUtils.equals(this.e, ((QFSPersonalFeedInfo)getData()).c())) {
      return;
    }
    this.a.setImageDrawable(null);
    this.e = ((QFSPersonalFeedInfo)getData()).c();
    Option localOption1 = new Option().setUrl(this.e).setTargetView(this.a);
    localOption1.setLoadingDrawable(new ColorDrawable(getResources().getColor(2131166091)));
    QCircleFeedPicLoader.g().loadImage(localOption1, null);
    boolean bool = QFSCommonUtil.a(((QFSPersonalFeedInfo)getData()).e());
    if ((bool) && (((QFSPersonalFeedInfo)getData()).g() == 20101)) {
      this.b.setImageResource(2130845825);
    } else {
      this.b.setImageResource(2130845796);
    }
    if (bool)
    {
      if (TextUtils.isEmpty(((QFSPersonalFeedInfo)getData()).d())) {
        return;
      }
      Option localOption2 = new Option().setUrl(((QFSPersonalFeedInfo)getData()).d()).setTargetView(this.c);
      localOption1.setLoadingDrawable(new ColorDrawable(getResources().getColor(2131166091)));
      QCircleFeedPicLoader.g().loadImage(localOption2, null);
    }
  }
  
  private void b()
  {
    String str;
    if ((QFSCommonUtil.a(((QFSPersonalFeedInfo)getData()).e())) && (((QFSPersonalFeedInfo)getData()).g() == 20101)) {
      str = QCirclePluginUtil.d(((QFSPersonalFeedInfo)getData()).a().visitorInfo.viewCount.get());
    } else {
      str = QCirclePluginUtil.d(((QFSPersonalFeedInfo)getData()).a().likeInfo.count.get());
    }
    this.d.setText(str);
  }
  
  protected void a(QFSPersonalFeedInfo paramQFSPersonalFeedInfo, int paramInt)
  {
    if (paramQFSPersonalFeedInfo != null)
    {
      if (paramQFSPersonalFeedInfo.a() == null) {
        return;
      }
      a();
      b();
    }
  }
  
  public int getLayoutId()
  {
    return 2131627160;
  }
  
  protected String getLogTag()
  {
    return "QFSPersonalFeedItemView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((ImageView)paramView.findViewById(2131436371));
    this.b = ((ImageView)paramView.findViewById(2131436434));
    this.c = ((ImageView)paramView.findViewById(2131436554));
    this.d = ((TextView)paramView.findViewById(2131448619));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1) * 4 / 3, 1073741824));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalFeedItemView
 * JD-Core Version:    0.7.0.1
 */