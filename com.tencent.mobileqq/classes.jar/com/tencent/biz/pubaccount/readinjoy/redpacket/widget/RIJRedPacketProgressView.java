package com.tencent.biz.pubaccount.readinjoy.redpacket.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bggq;
import bgnt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.presseffect.PressEffectRelativeLayout;
import oat;
import pha;
import phi;
import raf;
import ram;
import rao;
import raq;
import ras;

public class RIJRedPacketProgressView
  extends PressEffectRelativeLayout
  implements raf
{
  private int jdField_a_of_type_Int = 5;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RIJRedPacketProgressBar jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar;
  private raq jdField_a_of_type_Raq;
  private int jdField_b_of_type_Int = 1;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private int jdField_c_of_type_Int = 0;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private int d = 2;
  
  public RIJRedPacketProgressView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  @SuppressLint({"SetTextI18n"})
  public RIJRedPacketProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849432);
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleX(0.0F);
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleY(0.0F);
    paramAttributeSet = new RelativeLayout.LayoutParams(bggq.a(paramContext, 27.0F), bggq.a(paramContext, 27.0F));
    paramAttributeSet.addRule(14);
    addView(this.jdField_b_of_type_AndroidWidgetImageView, paramAttributeSet);
    this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849431);
    this.jdField_c_of_type_AndroidWidgetImageView.setScaleX(0.0F);
    this.jdField_c_of_type_AndroidWidgetImageView.setScaleY(0.0F);
    paramAttributeSet = new RelativeLayout.LayoutParams(bggq.a(paramContext, 27.0F), bggq.a(paramContext, 27.0F));
    paramAttributeSet.addRule(13);
    paramAttributeSet.bottomMargin = 1;
    addView(this.jdField_c_of_type_AndroidWidgetImageView, paramAttributeSet);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar = new RIJRedPacketProgressBar(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar.setScaleX(0.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar.setScaleY(0.0F);
    paramAttributeSet = new RelativeLayout.LayoutParams(-2, -2);
    paramAttributeSet.addRule(13);
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar, paramAttributeSet);
    startViewTransition(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849435);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramAttributeSet = new RelativeLayout.LayoutParams(-2, -2);
    paramAttributeSet.addRule(13);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, paramAttributeSet);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setScaleX(0.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setScaleY(0.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_Int + "/" + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130849434);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 9.0F);
    paramContext = new RelativeLayout.LayoutParams(bggq.a(paramContext, 21.0F), bggq.a(paramContext, 21.0F));
    paramContext.addRule(13);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, paramContext);
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_Raq = new raq(new ram());
      return;
    }
    this.jdField_a_of_type_Raq = new raq(new rao());
  }
  
  private void a(View paramView)
  {
    a(paramView, new float[] { paramView.getScaleX(), 1.0F });
  }
  
  private void a(View paramView, float... paramVarArgs)
  {
    paramView.setPivotX(paramView.getWidth() / 2);
    paramView.setPivotY(paramView.getHeight() / 2);
    paramVarArgs = ValueAnimator.ofFloat(paramVarArgs);
    paramVarArgs.setDuration(200L);
    paramVarArgs.addUpdateListener(new ras(this, paramView));
    paramVarArgs.start();
  }
  
  private void a(String paramString1, int paramInt, boolean paramBoolean, @Nullable String paramString2)
  {
    int j = 2;
    int i;
    phi localphi1;
    phi localphi2;
    if (paramBoolean)
    {
      i = 3;
      localphi1 = new phi();
      localphi2 = localphi1.a("icon_position", Integer.valueOf(paramInt)).a("icon_status", Integer.valueOf(i));
      if (!bgnt.h(BaseApplicationImpl.getContext())) {
        break label136;
      }
    }
    label136:
    for (paramInt = j;; paramInt = 1)
    {
      localphi2.a("network_type", Integer.valueOf(paramInt)).a("os", Integer.valueOf(1)).a("imei", pha.h());
      if (!TextUtils.isEmpty(paramString2)) {
        localphi1.a("rowkey", paramString2);
      }
      oat.a(paramString1, localphi1.a());
      return;
      if (a() == 1)
      {
        i = 2;
        break;
      }
      i = 1;
      break;
    }
  }
  
  private void b(View paramView)
  {
    a(paramView, new float[] { paramView.getScaleX(), 0.0F });
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Raq.d();
  }
  
  public void a(int paramInt, boolean paramBoolean, @Nullable String paramString)
  {
    a("0X800ABBB", paramInt, paramBoolean, paramString);
  }
  
  public void a(@NonNull String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.d == 1) {
      return;
    }
    this.d = 1;
    this.jdField_a_of_type_Raq.a(paramString, paramInt1, paramInt2);
    if (paramInt3 == 1)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849432);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849433);
  }
  
  public void b()
  {
    if (this.d == 2) {
      return;
    }
    this.d = 2;
    this.jdField_a_of_type_Raq.b();
  }
  
  public void b(int paramInt, boolean paramBoolean, @Nullable String paramString)
  {
    a("0X800ABBC", paramInt, paramBoolean, paramString);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Raq.c();
    b();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.saveLayer(new RectF(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight()), this.jdField_a_of_type_AndroidGraphicsPaint, 31);
    super.dispatchDraw(paramCanvas);
    new Path().addCircle(paramCanvas.getWidth() / 2, paramCanvas.getWidth() / 2, paramCanvas.getWidth() / 2, Path.Direction.CCW);
    paramCanvas.restore();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_Raq.a(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Raq.a();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(bggq.a(getContext(), 27.0F), bggq.a(getContext(), 27.0F));
  }
  
  @SuppressLint({"SetTextI18n"})
  public void setFinishRound(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + "/" + paramInt);
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar);
    a(this.jdField_b_of_type_AndroidWidgetImageView);
    b(this.jdField_c_of_type_AndroidWidgetImageView);
    b(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RIJRedPacketProgressView.2(this), 2000L);
  }
  
  public void setProgress(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar.setProgress(paramFloat);
  }
  
  @SuppressLint({"SetTextI18n"})
  public void setRound(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt1 + "/" + this.jdField_a_of_type_Int);
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar);
    a(this.jdField_b_of_type_AndroidWidgetImageView);
    b(this.jdField_c_of_type_AndroidWidgetImageView);
    b(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RIJRedPacketProgressView.1(this), 2000L);
  }
  
  public void setState(int paramInt)
  {
    if (this.jdField_c_of_type_Int != paramInt)
    {
      this.jdField_c_of_type_Int = paramInt;
      if (paramInt != 0) {
        break label58;
      }
      a(this.jdField_a_of_type_AndroidWidgetImageView);
      b(this.jdField_c_of_type_AndroidWidgetImageView);
      b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar);
      b(this.jdField_a_of_type_AndroidWidgetTextView);
      b(this.jdField_b_of_type_AndroidWidgetImageView);
    }
    label58:
    while (paramInt != 1) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressBar);
    a(this.jdField_c_of_type_AndroidWidgetImageView);
    a(this.jdField_b_of_type_AndroidWidgetImageView);
    b(this.jdField_a_of_type_AndroidWidgetImageView);
    b(this.jdField_a_of_type_AndroidWidgetTextView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView
 * JD-Core Version:    0.7.0.1
 */