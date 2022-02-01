package com.tencent.biz.qqcircle.polylike;

import aadv;
import android.content.Context;
import android.content.res.Resources;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import bhlq;
import bhpc;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.mobileqq.pb.PBUInt32Field;
import qqcircle.QQCircleFeedBase.StPolyLike;
import uzg;
import vrx;
import vry;
import vsb;
import vsc;
import vsj;
import vtn;
import vtr;
import zuc;

public class QCirclePolyLikePayView
  extends QCirclePolyBaseLikeView
{
  private bhpc a;
  
  public QCirclePolyLikePayView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a(float paramFloat)
  {
    int j = 0;
    this.jdField_a_of_type_Bhpc = bhlq.a(getContext(), 230);
    SpannableString localSpannableString = new SpannableString(String.format(getContext().getResources().getString(2131697265), new Object[] { Float.valueOf(paramFloat) }));
    int i;
    if ((paramFloat >= 10.0F) && (paramFloat < 100.0F)) {
      i = 1;
    }
    for (;;)
    {
      localSpannableString.setSpan(new zuc(getContext(), 2130844049), i + 11, i + 12, 33);
      this.jdField_a_of_type_Bhpc.setMessage(localSpannableString);
      this.jdField_a_of_type_Bhpc.setNegativeButton(2131690580, new vsb(this));
      this.jdField_a_of_type_Bhpc.setPositiveButton(2131692389, new vsc(this));
      if (!this.jdField_a_of_type_Bhpc.isShowing())
      {
        this.jdField_a_of_type_Bhpc.show();
        vtr.a(95, 1, a(), a().getPageId());
        vtn.a(String.valueOf(uzg.a()), 95, 1, this.c, a(), null, a().getPageId());
      }
      return;
      i = j;
      if (paramFloat >= 100.0F)
      {
        i = j;
        if (paramFloat < 1000.0F) {
          i = 2;
        }
      }
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
      return 2131560778;
    }
    return 2131560777;
  }
  
  public String a()
  {
    return "QCirclePayPolyLikeView";
  }
  
  protected void a()
  {
    float f = vry.a().a();
    Context localContext = getContext();
    getContext();
    ((Vibrator)localContext.getSystemService("vibrator")).vibrate(50L);
    if (this.jdField_a_of_type_Vrx != null) {
      this.jdField_a_of_type_Vrx.b();
    }
    if (f < this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.price.get()) {
      a(f);
    }
    while (this.jdField_a_of_type_Vsj == null) {
      return;
    }
    this.jdField_a_of_type_Vsj.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike, 21);
    this.jdField_a_of_type_Vsj.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike);
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
    aadv.a(this.jdField_a_of_type_AndroidWidgetTextView, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikePayView
 * JD-Core Version:    0.7.0.1
 */