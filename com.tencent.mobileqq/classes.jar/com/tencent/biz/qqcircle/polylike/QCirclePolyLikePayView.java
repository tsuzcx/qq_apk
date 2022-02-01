package com.tencent.biz.qqcircle.polylike;

import android.content.Context;
import android.content.res.Resources;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import bglp;
import bgpa;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.mobileqq.pb.PBUInt32Field;
import qqcircle.QQCircleFeedBase.StPolyLike;
import uxx;
import vpo;
import vpp;
import vps;
import vpt;
import vqa;
import vrc;
import vrg;
import zzr;

public class QCirclePolyLikePayView
  extends QCirclePolyBaseLikeView
{
  private bgpa a;
  
  public QCirclePolyLikePayView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Bgpa == null)
    {
      this.jdField_a_of_type_Bgpa = bglp.a(getContext(), 230);
      this.jdField_a_of_type_Bgpa.setMessage(String.format(getContext().getResources().getString(2131697197), new Object[] { Float.valueOf(paramFloat) }));
      this.jdField_a_of_type_Bgpa.setNegativeButton(2131690582, new vps(this));
      this.jdField_a_of_type_Bgpa.setPositiveButton(2131692384, new vpt(this));
    }
    if (!this.jdField_a_of_type_Bgpa.isShowing())
    {
      this.jdField_a_of_type_Bgpa.show();
      vrg.a(95, 1, a(), a().getPageId());
      vrc.a(String.valueOf(uxx.a()), 95, 1, this.c, a(), null, a().getPageId());
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    }
    if (this.b != null) {
      this.b.setVisibility(4);
    }
  }
  
  public int a()
  {
    if (b() == 256) {
      return 2131560753;
    }
    return 2131560752;
  }
  
  public String a()
  {
    return "QCirclePayPolyLikeView";
  }
  
  protected void a()
  {
    float f = vpp.a().a();
    Context localContext = getContext();
    getContext();
    ((Vibrator)localContext.getSystemService("vibrator")).vibrate(50L);
    if (this.jdField_a_of_type_Vpo != null) {
      this.jdField_a_of_type_Vpo.b();
    }
    if (f < this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.price.get()) {
      a(f);
    }
    while (this.jdField_a_of_type_Vqa == null) {
      return;
    }
    this.jdField_a_of_type_Vqa.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike, 21);
    this.jdField_a_of_type_Vqa.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike);
  }
  
  public void a(Context paramContext, View paramView)
  {
    super.a(paramContext, paramView);
    c();
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt)
  {
    super.a(paramObject, paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.price.get()));
    zzr.a(this.jdField_a_of_type_AndroidWidgetTextView, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikePayView
 * JD-Core Version:    0.7.0.1
 */