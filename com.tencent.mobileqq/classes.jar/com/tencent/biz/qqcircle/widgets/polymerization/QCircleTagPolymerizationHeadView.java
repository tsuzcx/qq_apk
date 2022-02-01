package com.tencent.biz.qqcircle.widgets.polymerization;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StTagInfo;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;
import qqcircle.QQCircleDitto.StSinglePicBanner;
import qqcircle.QQCircleFeedBase.StTagPageData;

public class QCircleTagPolymerizationHeadView
  extends QCircleBasePolymerizationHeadView
{
  private QQCircleFeedBase.StTagPageData a;
  private TextView b;
  private TextView c;
  private TextView d;
  private QCirclePolymerizationFuelListView e;
  private URLImageView f;
  private View g;
  private QCirclePolymerizationBean h;
  
  public QCircleTagPolymerizationHeadView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    if (this.a == null)
    {
      QLog.i("QCirclePatSamePolymerizationHeadView", 1, "updateBannerView  mTagPageData == null");
      return;
    }
    this.f.setVisibility(8);
    this.g.setVisibility(0);
    if (this.a.dittoFeed.dittoId.get() != 8)
    {
      QLog.i("QCirclePatSamePolymerizationHeadView", 1, "updateBannerView  dittoFeed.dittoId.get() != 8");
      return;
    }
    Object localObject = new QQCircleDitto.StCircleDittoDataNew();
    try
    {
      ((QQCircleDitto.StCircleDittoDataNew)localObject).mergeFrom(this.a.dittoFeed.dittoDataNew.get().toByteArray());
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      localInvalidProtocolBufferMicroException.printStackTrace();
    }
    if (TextUtils.isEmpty(((QQCircleDitto.StCircleDittoDataNew)localObject).singlePicBanner.image.picUrl.get()))
    {
      QLog.i("QCirclePatSamePolymerizationHeadView", 1, "updateBannerView  dittoDataNew.singlePicBanner.image.picUrl.get() == null");
      return;
    }
    this.f.setVisibility(0);
    this.g.setVisibility(8);
    localObject = new Option().setUrl(((QQCircleDitto.StCircleDittoDataNew)localObject).singlePicBanner.image.picUrl.get()).setTargetView(this.f);
    QCircleFeedPicLoader.setViewWidthHeight((Option)localObject, this.f);
    QCircleFeedPicLoader.g().loadImage((Option)localObject, null);
    QCircleLpReportDc05504.DataBuilder localDataBuilder = new QCircleLpReportDc05504.DataBuilder().setActionType(46).setSubActionType(10).setThrActionType(1);
    localObject = this.h;
    if (localObject != null) {
      localObject = ((QCirclePolymerizationBean)localObject).getPolymerizationName();
    } else {
      localObject = "";
    }
    QCircleLpReportDc05504.report(localDataBuilder.setExt6((String)localObject).setPageId(getPageId()));
  }
  
  protected void bindData(Object paramObject, int paramInt)
  {
    if (!(paramObject instanceof QQCircleFeedBase.StTagPageData)) {
      return;
    }
    this.a = ((QQCircleFeedBase.StTagPageData)paramObject);
    this.b.setText(this.a.tagInfo.tagName.get());
    if (!TextUtils.isEmpty(this.a.activityCopywritingDesc.get()))
    {
      this.d.setVisibility(0);
      this.d.setText(this.a.activityCopywritingDesc.get());
    }
    else
    {
      this.d.setVisibility(8);
    }
    this.c.setText(a(this.a.subsidiaryFieldDesc.get()));
    this.e.a(getReportBean());
    this.e.a(this.h);
    this.e.a(this.a);
    a();
  }
  
  public int getLayoutId()
  {
    return 2131626975;
  }
  
  protected String getLogTag()
  {
    return "QCirclePatSamePolymerizationHeadView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    super.onInitView(paramContext, paramView);
    this.b = ((TextView)paramView.findViewById(2131448814));
    paramContext = (QCirclePolymerizationBean)((Activity)getContext()).getIntent().getSerializableExtra("key_bundle_common_init_bean");
    TextView localTextView = this.b;
    if (paramContext != null) {
      paramContext = paramContext.getPolymerizationName();
    } else {
      paramContext = "";
    }
    localTextView.setText(paramContext);
    this.c = ((TextView)paramView.findViewById(2131448631));
    this.d = ((TextView)paramView.findViewById(2131448374));
    this.e = new QCirclePolymerizationFuelListView();
    this.e.a(paramView);
    this.g = paramView.findViewById(2131449815);
    this.f = ((URLImageView)paramView.findViewById(2131449067));
    this.f.setOnClickListener(new QCircleTagPolymerizationHeadView.1(this));
  }
  
  public void setInitBean(QCirclePolymerizationBean paramQCirclePolymerizationBean)
  {
    this.h = paramQCirclePolymerizationBean;
  }
  
  public void setReportBean(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.polymerization.QCircleTagPolymerizationHeadView
 * JD-Core Version:    0.7.0.1
 */