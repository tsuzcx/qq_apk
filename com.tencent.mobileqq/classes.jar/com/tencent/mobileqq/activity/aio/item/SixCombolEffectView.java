package com.tencent.mobileqq.activity.aio.item;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class SixCombolEffectView
  extends View
  implements Handler.Callback
{
  public static int a = 0;
  public static boolean a = false;
  float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long = 0L;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  BitmapFactory.Options jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = null;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ChatAdapter1 jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
  private SixCombolEffectView.ISixAnimationListener jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$ISixAnimationListener;
  private SixCombolEffectView.OneHeartTracker jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$OneHeartTracker;
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  private MessageForPoke jdField_a_of_type_ComTencentMobileqqDataMessageForPoke;
  private String jdField_a_of_type_JavaLangString = "chat_item_for_qq666";
  private ArrayList<SixCombolEffectView.OneHeartTracker> jdField_a_of_type_JavaUtilArrayList;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int = ScreenUtil.dip2px(30.0F);
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private boolean jdField_b_of_type_Boolean;
  float jdField_c_of_type_Float = ScreenUtil.dip2px(120.0F);
  int jdField_c_of_type_Int = ScreenUtil.dip2px(30.0F);
  private ValueAnimator jdField_c_of_type_AndroidAnimationValueAnimator;
  Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private boolean jdField_c_of_type_Boolean = false;
  float jdField_d_of_type_Float = ScreenUtil.dip2px(120.0F);
  int jdField_d_of_type_Int = ScreenUtil.dip2px(13.0F);
  private boolean jdField_d_of_type_Boolean = false;
  float jdField_e_of_type_Float;
  int jdField_e_of_type_Int = ScreenUtil.dip2px(50.0F);
  float jdField_f_of_type_Float = ScreenUtil.dip2px(100.0F);
  private int jdField_f_of_type_Int = 0;
  private int g = 0;
  private int h;
  private int i;
  private int j = ScreenUtil.dip2px(60.0F);
  
  public SixCombolEffectView(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public SixCombolEffectView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public SixCombolEffectView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private GivingHeartItemBuilder.Holder a()
  {
    ChatXListView localChatXListView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localChatXListView != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null)
      {
        int k = AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.uniseq, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
        localObject1 = AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, k + 1);
        if (localObject1 == null) {
          return null;
        }
        localObject1 = (GivingHeartItemBuilder.Holder)AIOUtils.a((View)localObject1);
      }
    }
    return localObject1;
  }
  
  @TargetApi(11)
  private SixCombolEffectView.OneHeartTracker a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    SixCombolEffectView.OneHeartTracker localOneHeartTracker = new SixCombolEffectView.OneHeartTracker(this);
    localOneHeartTracker.jdField_a_of_type_Int = paramInt1;
    localOneHeartTracker.jdField_a_of_type_Boolean = false;
    localOneHeartTracker.jdField_b_of_type_Int = paramInt2;
    localOneHeartTracker.jdField_d_of_type_Int = paramInt3;
    localOneHeartTracker.jdField_f_of_type_Int = paramInt4;
    localOneHeartTracker.g = paramInt5;
    localOneHeartTracker.jdField_b_of_type_Boolean = false;
    localOneHeartTracker.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$BezierEvaluator = new SixCombolEffectView.BezierEvaluator(this);
    localOneHeartTracker.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.2F, this.jdField_e_of_type_Float - 0.15F });
    ValueAnimator localValueAnimator = localOneHeartTracker.jdField_a_of_type_AndroidAnimationValueAnimator;
    double d1 = paramInt5;
    Double.isNaN(d1);
    localValueAnimator.setDuration((int)(d1 * 1.2D));
    localOneHeartTracker.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new SixCombolEffectView.9(this, localOneHeartTracker));
    localOneHeartTracker.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new SixCombolEffectView.10(this, localOneHeartTracker));
    float f1 = this.jdField_e_of_type_Float;
    localOneHeartTracker.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { f1 - 0.15F, f1 });
    localOneHeartTracker.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(paramInt6);
    localOneHeartTracker.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new SixCombolEffectView.11(this, localOneHeartTracker));
    localOneHeartTracker.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 2.5F });
    localValueAnimator = localOneHeartTracker.jdField_c_of_type_AndroidAnimationValueAnimator;
    paramInt1 = paramInt6 - paramInt5;
    d1 = paramInt1;
    Double.isNaN(d1);
    localValueAnimator.setDuration((d1 * 2.1D));
    localOneHeartTracker.jdField_c_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
    localOneHeartTracker.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new SixCombolEffectView.12(this));
    localOneHeartTracker.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new SixCombolEffectView.13(this, localOneHeartTracker));
    localOneHeartTracker.jdField_d_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 2.2F });
    localOneHeartTracker.jdField_d_of_type_AndroidAnimationValueAnimator.setDuration(paramInt1);
    localOneHeartTracker.jdField_d_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    localOneHeartTracker.jdField_d_of_type_AndroidAnimationValueAnimator.addUpdateListener(new SixCombolEffectView.14(this, localOneHeartTracker));
    return localOneHeartTracker;
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    paramCanvas.save();
    Matrix localMatrix = new Matrix();
    float f1 = this.jdField_d_of_type_Float / paramBitmap.getHeight();
    localMatrix.postScale(f1, f1);
    localMatrix.postTranslate(paramFloat1, paramFloat2);
    paramCanvas.drawBitmap(paramBitmap, localMatrix, paramPaint);
    paramCanvas.restore();
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramCanvas.save();
    Matrix localMatrix = new Matrix();
    float f1 = this.jdField_d_of_type_Float / paramBitmap.getHeight();
    localMatrix.postScale(f1, f1);
    localMatrix.postTranslate(-this.jdField_c_of_type_Float / 2.0F, -this.jdField_d_of_type_Float / 2.0F);
    localMatrix.postRotate(paramFloat1);
    localMatrix.postTranslate(paramFloat2, paramFloat3);
    paramCanvas.drawBitmap(paramBitmap, localMatrix, paramPaint);
    paramCanvas.restore();
  }
  
  private void a(SixCombolEffectView.OneHeartTracker paramOneHeartTracker, int paramInt1, int paramInt2, int paramInt3)
  {
    paramOneHeartTracker.jdField_c_of_type_Int = paramInt1;
    paramOneHeartTracker.jdField_e_of_type_Int = paramInt2;
    paramOneHeartTracker.jdField_b_of_type_Boolean = false;
    SixCombolEffectView.BezierEvaluator localBezierEvaluator = paramOneHeartTracker.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$BezierEvaluator;
    PointF localPointF = new PointF(paramInt1, paramOneHeartTracker.jdField_d_of_type_Int);
    float f1 = paramInt2;
    localBezierEvaluator.a(new PointF[] { localPointF, new PointF(f1, paramOneHeartTracker.jdField_d_of_type_Int - paramInt3), new PointF(f1, paramOneHeartTracker.jdField_f_of_type_Int) });
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = this.jdField_a_of_type_AndroidContentContext;
    if ((paramContext instanceof BaseActivity))
    {
      paramContext = ((BaseActivity)paramContext).getChatFragment().a();
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = paramContext.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = paramContext.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
    }
    setOnTouchListener(new SixCombolEffectView.1(this));
    paramContext = this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options;
    paramContext.inSampleSize = 1;
    paramContext.inMutable = true;
    if (PokeBigResHandler.jdField_a_of_type_Boolean)
    {
      try
      {
        paramContext = new StringBuilder();
        paramContext.append(PokeBigResHandler.b);
        paramContext.append("/666_caidan/666send_caidan_hand.png");
        this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a(paramContext.toString(), this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
      }
      catch (OutOfMemoryError paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Six Hand", 2, paramContext.toString());
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      try
      {
        paramContext = new StringBuilder();
        paramContext.append(PokeBigResHandler.b);
        paramContext.append("/666_caidan/666send_caidan_hand6.png");
        this.jdField_c_of_type_AndroidGraphicsBitmap = ImageUtil.a(paramContext.toString(), this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
      }
      catch (OutOfMemoryError paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Six Six", 2, paramContext.toString());
        }
        this.jdField_c_of_type_AndroidGraphicsBitmap = null;
      }
      this.jdField_b_of_type_AndroidGraphicsBitmap = a(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { -0.2F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new SixCombolEffectView.2(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new SixCombolEffectView.3(this));
    this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F, 0.0F }).setDuration(300L);
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setRepeatCount(7);
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new SixCombolEffectView.4(this));
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new SixCombolEffectView.5(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, -0.2F });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(300L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new SixCombolEffectView.6(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new SixCombolEffectView.7(this));
    a(getContext());
  }
  
  private void d()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_c_of_type_AndroidAnimationValueAnimator.end();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.end();
    this.jdField_b_of_type_AndroidAnimationValueAnimator.end();
    this.jdField_c_of_type_Boolean = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      SixCombolEffectView.OneHeartTracker localOneHeartTracker = (SixCombolEffectView.OneHeartTracker)localIterator.next();
      localOneHeartTracker.jdField_d_of_type_AndroidAnimationValueAnimator.end();
      localOneHeartTracker.jdField_a_of_type_AndroidAnimationValueAnimator.end();
      localOneHeartTracker.jdField_c_of_type_AndroidAnimationValueAnimator.end();
      localOneHeartTracker.jdField_b_of_type_AndroidAnimationValueAnimator.end();
      localOneHeartTracker.jdField_a_of_type_Float = 0.0F;
      localOneHeartTracker.jdField_b_of_type_Float = 0.0F;
      localOneHeartTracker.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_d_of_type_Boolean) {
      HapticManager.a().c(this.h);
    }
    this.h = 0;
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      int k = paramBitmap.getWidth();
      int m = paramBitmap.getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(-1.0F, 1.0F);
      try
      {
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, k, m, localMatrix, true);
        return paramBitmap;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        paramBitmap.printStackTrace();
      }
    }
    return null;
  }
  
  public MessageForPoke a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke;
  }
  
  public void a()
  {
    int k;
    SixCombolEffectView.OneHeartTracker localOneHeartTracker;
    if (this.jdField_b_of_type_Boolean)
    {
      k = (int)(this.jdField_f_of_type_Int - ScreenUtil.dip2px(50.0F) - this.jdField_c_of_type_Float / 2.0F);
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localOneHeartTracker = (SixCombolEffectView.OneHeartTracker)localIterator.next();
        if (localOneHeartTracker.jdField_a_of_type_Int == 0) {
          a(localOneHeartTracker, k, k / 3 * 2, 0);
        } else if (localOneHeartTracker.jdField_a_of_type_Int == 1) {
          a(localOneHeartTracker, k, k / 3, 0);
        } else {
          a(localOneHeartTracker, k, ScreenUtil.dip2px(10.0F), 50);
        }
      }
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      localOneHeartTracker = (SixCombolEffectView.OneHeartTracker)localIterator.next();
      k = (int)(ScreenUtil.dip2px(50.0F) + this.jdField_c_of_type_Float / 2.0F);
      int m = (int)(this.jdField_f_of_type_Int - ScreenUtil.dip2px(50.0F) - this.jdField_c_of_type_Float / 2.0F);
      if (localOneHeartTracker.jdField_a_of_type_Int == 0) {
        a(localOneHeartTracker, k, k, 0);
      } else if (localOneHeartTracker.jdField_a_of_type_Int == 1) {
        a(localOneHeartTracker, k, m / 3 + k, 0);
      } else {
        a(localOneHeartTracker, k, (int)(this.jdField_f_of_type_Int - this.jdField_f_of_type_Float - ScreenUtil.dip2px(10.0F)), 50);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    int m = UIUtils.a(paramContext);
    int k = getResources().getDisplayMetrics().heightPixels;
    this.jdField_f_of_type_Int = m;
    this.g = k;
    this.jdField_e_of_type_Float = (this.jdField_f_of_type_Float / this.jdField_c_of_type_AndroidGraphicsBitmap.getWidth());
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramContext = this.jdField_a_of_type_JavaUtilArrayList;
    m = ScreenUtil.dip2px(70.0F);
    int n = (int)(k * 0.6F);
    paramContext.add(a(0, 800, k - m, n, 700, 2000));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(0, 1600, k - ScreenUtil.dip2px(70.0F), n, 600, 1400));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(0, 1800, k - ScreenUtil.dip2px(70.0F), n, 600, 1800));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(1, 0, k - ScreenUtil.dip2px(70.0F), n, 500, 1500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(1, 600, k - ScreenUtil.dip2px(70.0F), n, 500, 1400));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(1, 1200, k - ScreenUtil.dip2px(70.0F), n, 500, 1500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(1, 2000, k - ScreenUtil.dip2px(70.0F), n, 500, 1800));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(2, 300, k - ScreenUtil.dip2px(70.0F), n, 500, 1500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(2, 1000, k - ScreenUtil.dip2px(70.0F), n, 500, 1500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(2, 1400, k - ScreenUtil.dip2px(70.0F), n, 500, 1900));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$OneHeartTracker = ((SixCombolEffectView.OneHeartTracker)this.jdField_a_of_type_JavaUtilArrayList.get(6));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$OneHeartTracker.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new SixCombolEffectView.8(this));
  }
  
  public void a(GivingHeartItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_d_of_type_Boolean = paramBoolean;
    d();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke = ((MessageForPoke)paramHolder.a);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.mFrameState.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.isSend();
    jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    if (this.jdField_d_of_type_Boolean) {
      this.h = HapticManager.a().a(this.jdField_a_of_type_JavaLangString, 2);
    }
  }
  
  public void b()
  {
    setVisibility(8);
    Object localObject = a();
    SixCombolEffectView.ISixAnimationListener localISixAnimationListener = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$ISixAnimationListener;
    if ((localISixAnimationListener != null) && (localObject != null))
    {
      localISixAnimationListener.a((GivingHeartItemBuilder.Holder)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$ISixAnimationListener = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke;
    if (localObject != null) {
      ((MessageForPoke)localObject).mFrameState.jdField_a_of_type_Boolean = false;
    }
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_Int = 0;
    d();
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = null;
    b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int k = paramMessage.what;
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3) {
          return false;
        }
        setVisibility(0);
        requestLayout();
        jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
        return false;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      k = 0;
      while (k < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramMessage = (SixCombolEffectView.OneHeartTracker)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        if ((l1 - l2 >= paramMessage.jdField_b_of_type_Int) && (!paramMessage.jdField_a_of_type_Boolean))
        {
          paramMessage.jdField_a_of_type_Boolean = true;
          paramMessage.jdField_a_of_type_AndroidAnimationValueAnimator.start();
          paramMessage.jdField_c_of_type_AndroidAnimationValueAnimator.start();
        }
        k += 1;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$OneHeartTracker.jdField_a_of_type_Boolean)
      {
        paramMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramMessage.what = 2;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 25L);
        return false;
      }
    }
    else
    {
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      paramMessage = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramMessage.hasNext()) {
        ((SixCombolEffectView.OneHeartTracker)paramMessage.next()).jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke == null) {
      return;
    }
    Object localObject1 = a();
    if (localObject1 == null)
    {
      b();
      return;
    }
    Object localObject2 = new int[2];
    ((GivingHeartItemBuilder.Holder)localObject1).c.getLocationOnScreen((int[])localObject2);
    int k = localObject2[0];
    this.i = ((int)(localObject2[1] + this.jdField_d_of_type_Float - this.jdField_e_of_type_Int));
    if (this.jdField_c_of_type_AndroidGraphicsBitmap != null)
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        return;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      float f1;
      double d1;
      double d2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SixCombolEffectView.OneHeartTracker)((Iterator)localObject1).next();
        if (((SixCombolEffectView.OneHeartTracker)localObject2).jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
          PointF localPointF;
          if (((SixCombolEffectView.OneHeartTracker)localObject2).jdField_b_of_type_Float <= 1.0F)
          {
            localPointF = ((SixCombolEffectView.OneHeartTracker)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$BezierEvaluator.a(((SixCombolEffectView.OneHeartTracker)localObject2).jdField_b_of_type_Float, null, null);
            this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localPointF.x, localPointF.y - (this.g - this.i) + this.jdField_d_of_type_Int);
          }
          else
          {
            f1 = ((SixCombolEffectView.OneHeartTracker)localObject2).jdField_b_of_type_Float;
            d1 = this.g;
            Double.isNaN(d1);
            d2 = 1.0F - (f1 - 1.0F);
            Double.isNaN(d2);
            k = (int)(d1 * 0.6D * d2);
            localPointF = ((SixCombolEffectView.OneHeartTracker)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$BezierEvaluator.a(((SixCombolEffectView.OneHeartTracker)localObject2).jdField_b_of_type_Float, null, null);
            this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localPointF.x, k - (this.g - this.i) + this.jdField_d_of_type_Int);
          }
          this.jdField_a_of_type_AndroidGraphicsMatrix.preScale(((SixCombolEffectView.OneHeartTracker)localObject2).jdField_a_of_type_Float, ((SixCombolEffectView.OneHeartTracker)localObject2).jdField_a_of_type_Float);
          paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$OneHeartTracker.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$OneHeartTracker.jdField_b_of_type_Float <= 1.0F)
        {
          k = (int)(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$OneHeartTracker.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$BezierEvaluator.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$OneHeartTracker.jdField_b_of_type_Float, null, null).y - (this.g - this.i) + this.jdField_d_of_type_Int);
        }
        else
        {
          f1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$OneHeartTracker.jdField_b_of_type_Float;
          k = this.g;
          d1 = k;
          Double.isNaN(d1);
          d2 = 1.0F - (f1 - 1.0F);
          Double.isNaN(d2);
          k = (int)(d1 * 0.6D * d2) - (k - this.i) + this.jdField_d_of_type_Int;
        }
        if (k + this.jdField_c_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$OneHeartTracker.jdField_a_of_type_Float < 0.0F) {
          b();
        }
      }
      k = jdField_a_of_type_Int;
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3) {
            return;
          }
          if (this.jdField_b_of_type_Boolean)
          {
            localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
            f1 = this.jdField_a_of_type_Float;
            f2 = getWidth();
            f3 = this.jdField_c_of_type_Float / 2.0F;
            float f4 = this.j;
            k = this.jdField_d_of_type_Int;
            a(paramCanvas, null, (Bitmap)localObject1, 90.0F - f1 * 90.0F, f2 - f3 - f4 - k, this.i - this.jdField_d_of_type_Float / 2.0F + k);
            return;
          }
          localObject1 = this.jdField_b_of_type_AndroidGraphicsBitmap;
          f1 = this.jdField_a_of_type_Float;
          float f2 = this.jdField_c_of_type_Float / 2.0F;
          float f3 = this.j;
          k = this.jdField_d_of_type_Int;
          a(paramCanvas, null, (Bitmap)localObject1, f1 * 90.0F - 90.0F, f2 + f3 + k, this.i - this.jdField_d_of_type_Float / 2.0F + k);
          return;
        }
        if (this.jdField_b_of_type_Boolean)
        {
          a(paramCanvas, null, this.jdField_a_of_type_AndroidGraphicsBitmap, getWidth() - this.jdField_c_of_type_Float + (this.jdField_b_of_type_Float - 0.5F) * 100.0F - this.j, this.i - this.jdField_d_of_type_Float);
          return;
        }
        a(paramCanvas, null, this.jdField_b_of_type_AndroidGraphicsBitmap, -(this.jdField_b_of_type_Float - 0.5F) * 100.0F + this.j, this.i - this.jdField_d_of_type_Float);
        return;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        a(paramCanvas, null, this.jdField_a_of_type_AndroidGraphicsBitmap, 90.0F - this.jdField_a_of_type_Float * 90.0F, getWidth() - this.jdField_c_of_type_Float / 2.0F - this.j, this.i - this.jdField_d_of_type_Float / 2.0F);
        return;
      }
      a(paramCanvas, null, this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Float * 90.0F - 90.0F, this.jdField_c_of_type_Float / 2.0F + this.j, this.i - this.jdField_d_of_type_Float / 2.0F);
    }
  }
  
  public void setListener(SixCombolEffectView.ISixAnimationListener paramISixAnimationListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$ISixAnimationListener = paramISixAnimationListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SixCombolEffectView
 * JD-Core Version:    0.7.0.1
 */