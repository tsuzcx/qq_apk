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
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import vdq;
import vdr;
import vds;
import vdt;
import vdu;
import vdv;
import vdw;
import vdx;
import vdy;
import vdz;
import vea;
import veb;
import vec;
import ved;
import vee;

public class SixCombolEffectView
  extends View
  implements Handler.Callback
{
  public static int a;
  public static boolean a;
  public float a;
  private long jdField_a_of_type_Long;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  BitmapFactory.Options jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ChatAdapter1 jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
  private SixCombolEffectView.ISixAnimationListener jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$ISixAnimationListener;
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  private MessageForPoke jdField_a_of_type_ComTencentMobileqqDataMessageForPoke;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private vee jdField_a_of_type_Vee;
  public float b;
  int jdField_b_of_type_Int = ScreenUtil.a(30.0F);
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private boolean jdField_b_of_type_Boolean;
  float jdField_c_of_type_Float = ScreenUtil.a(120.0F);
  int jdField_c_of_type_Int = ScreenUtil.a(30.0F);
  private ValueAnimator jdField_c_of_type_AndroidAnimationValueAnimator;
  Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private boolean jdField_c_of_type_Boolean;
  float jdField_d_of_type_Float = ScreenUtil.a(120.0F);
  int jdField_d_of_type_Int = ScreenUtil.a(13.0F);
  float jdField_e_of_type_Float;
  int jdField_e_of_type_Int = ScreenUtil.a(50.0F);
  float jdField_f_of_type_Float = ScreenUtil.a(100.0F);
  private int jdField_f_of_type_Int;
  private int g;
  private int h;
  private int i = ScreenUtil.a(60.0F);
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
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
    View localView;
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null))
    {
      int j = AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.uniseq, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      localView = AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, j + 1);
      if (localView != null) {}
    }
    else
    {
      return null;
    }
    return (GivingHeartItemBuilder.Holder)AIOUtils.a(localView);
  }
  
  @TargetApi(11)
  private vee a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    vee localvee = new vee(this);
    localvee.jdField_a_of_type_Int = paramInt1;
    localvee.jdField_a_of_type_Boolean = false;
    localvee.jdField_b_of_type_Int = paramInt2;
    localvee.jdField_d_of_type_Int = paramInt3;
    localvee.jdField_f_of_type_Int = paramInt4;
    localvee.g = paramInt5;
    localvee.jdField_b_of_type_Boolean = false;
    localvee.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$BezierEvaluator = new SixCombolEffectView.BezierEvaluator(this);
    localvee.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.2F, this.jdField_e_of_type_Float - 0.15F });
    localvee.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration((int)(paramInt5 * 1.2D));
    localvee.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new ved(this, localvee));
    localvee.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new vdr(this, localvee));
    localvee.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { this.jdField_e_of_type_Float - 0.15F, this.jdField_e_of_type_Float });
    localvee.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(paramInt6);
    localvee.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new vds(this, localvee));
    localvee.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 2.5F });
    localvee.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration(((paramInt6 - paramInt5) * 2.1D));
    localvee.jdField_c_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
    localvee.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new vdt(this));
    localvee.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new vdu(this, localvee));
    localvee.jdField_d_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 2.2F });
    localvee.jdField_d_of_type_AndroidAnimationValueAnimator.setDuration(paramInt6 - paramInt5);
    localvee.jdField_d_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    localvee.jdField_d_of_type_AndroidAnimationValueAnimator.addUpdateListener(new vdv(this, localvee));
    return localvee;
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
  
  private void a(vee paramvee, int paramInt1, int paramInt2, int paramInt3)
  {
    paramvee.jdField_c_of_type_Int = paramInt1;
    paramvee.jdField_e_of_type_Int = paramInt2;
    paramvee.jdField_b_of_type_Boolean = false;
    paramvee.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$BezierEvaluator.a(new PointF[] { new PointF(paramInt1, paramvee.jdField_d_of_type_Int), new PointF(paramInt2, paramvee.jdField_d_of_type_Int - paramInt3), new PointF(paramInt2, paramvee.jdField_f_of_type_Int) });
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      paramContext = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = paramContext.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = paramContext.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
    }
    setOnTouchListener(new vdq(this));
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inSampleSize = 1;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inMutable = true;
    if (PokeBigResHandler.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a(PokeBigResHandler.b + "/666_caidan/666send_caidan_hand.png", this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
    }
    catch (OutOfMemoryError paramContext)
    {
      try
      {
        for (;;)
        {
          this.jdField_c_of_type_AndroidGraphicsBitmap = ImageUtil.a(PokeBigResHandler.b + "/666_caidan/666send_caidan_hand6.png", this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
          this.jdField_b_of_type_AndroidGraphicsBitmap = a(this.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { -0.2F, 1.0F });
          this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
          this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new vdw(this));
          this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new vdx(this));
          this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F, 0.0F }).setDuration(300L);
          this.jdField_c_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
          this.jdField_c_of_type_AndroidAnimationValueAnimator.setRepeatCount(7);
          this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new vdy(this));
          this.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new vdz(this));
          this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, -0.2F });
          this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(300L);
          this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new vea(this));
          this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new veb(this));
          a(getContext());
          return;
          paramContext = paramContext;
          if (QLog.isColorLevel()) {
            QLog.d("Six Hand", 2, paramContext.toString());
          }
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
      }
      catch (OutOfMemoryError paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Six Six", 2, paramContext.toString());
          }
          this.jdField_c_of_type_AndroidGraphicsBitmap = null;
        }
      }
    }
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
      vee localvee = (vee)localIterator.next();
      localvee.jdField_d_of_type_AndroidAnimationValueAnimator.end();
      localvee.jdField_a_of_type_AndroidAnimationValueAnimator.end();
      localvee.jdField_c_of_type_AndroidAnimationValueAnimator.end();
      localvee.jdField_b_of_type_AndroidAnimationValueAnimator.end();
      localvee.jdField_a_of_type_Float = 0.0F;
      localvee.jdField_b_of_type_Float = 0.0F;
      localvee.jdField_a_of_type_Boolean = false;
    }
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      int j = paramBitmap.getWidth();
      int k = paramBitmap.getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(-1.0F, 1.0F);
      try
      {
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, j, k, localMatrix, true);
        return paramBitmap;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        paramBitmap.printStackTrace();
        return null;
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
    int j;
    vee localvee;
    if (this.jdField_b_of_type_Boolean)
    {
      j = (int)(this.jdField_f_of_type_Int - ScreenUtil.a(50.0F) - this.jdField_c_of_type_Float / 2.0F);
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localvee = (vee)localIterator.next();
        if (localvee.jdField_a_of_type_Int == 0) {
          a(localvee, j, j / 3 * 2, 0);
        } else if (localvee.jdField_a_of_type_Int == 1) {
          a(localvee, j, j / 3, 0);
        } else {
          a(localvee, j, ScreenUtil.a(10.0F), 50);
        }
      }
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      localvee = (vee)localIterator.next();
      j = (int)(ScreenUtil.a(50.0F) + this.jdField_c_of_type_Float / 2.0F);
      int k = (int)(this.jdField_f_of_type_Int - ScreenUtil.a(50.0F) - this.jdField_c_of_type_Float / 2.0F);
      if (localvee.jdField_a_of_type_Int == 0) {
        a(localvee, j, j, 0);
      } else if (localvee.jdField_a_of_type_Int == 1) {
        a(localvee, j, k / 3 + j, 0);
      } else {
        a(localvee, j, (int)(this.jdField_f_of_type_Int - this.jdField_f_of_type_Float - ScreenUtil.a(10.0F)), 50);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    int j = DisplayUtil.a(paramContext);
    int k = getResources().getDisplayMetrics().heightPixels;
    this.jdField_f_of_type_Int = j;
    this.g = k;
    this.jdField_e_of_type_Float = (this.jdField_f_of_type_Float / this.jdField_c_of_type_AndroidGraphicsBitmap.getWidth());
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList.add(a(0, 800, k - ScreenUtil.a(70.0F), (int)(k * 0.6F), 700, 2000));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(0, 1600, k - ScreenUtil.a(70.0F), (int)(k * 0.6F), 600, 1400));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(0, 1800, k - ScreenUtil.a(70.0F), (int)(k * 0.6F), 600, 1800));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(1, 0, k - ScreenUtil.a(70.0F), (int)(k * 0.6F), 500, 1500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(1, 600, k - ScreenUtil.a(70.0F), (int)(k * 0.6F), 500, 1400));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(1, 1200, k - ScreenUtil.a(70.0F), (int)(k * 0.6F), 500, 1500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(1, 2000, k - ScreenUtil.a(70.0F), (int)(k * 0.6F), 500, 1800));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(2, 300, k - ScreenUtil.a(70.0F), (int)(k * 0.6F), 500, 1500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(2, 1000, k - ScreenUtil.a(70.0F), (int)(k * 0.6F), 500, 1500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(2, 1400, k - ScreenUtil.a(70.0F), (int)(k * 0.6F), 500, 1900));
    this.jdField_a_of_type_Vee = ((vee)this.jdField_a_of_type_JavaUtilArrayList.get(6));
    this.jdField_a_of_type_Vee.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new vec(this));
  }
  
  public void a(GivingHeartItemBuilder.Holder paramHolder)
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    d();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke = ((MessageForPoke)paramHolder.a);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.mFrameState.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.isSend();
    jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  public void b()
  {
    setVisibility(8);
    GivingHeartItemBuilder.Holder localHolder = a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$ISixAnimationListener != null) && (localHolder != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$ISixAnimationListener.a(localHolder);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$ISixAnimationListener = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.mFrameState.jdField_a_of_type_Boolean = false;
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
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      setVisibility(0);
      requestLayout();
      jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return false;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      paramMessage = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramMessage.hasNext()) {
        ((vee)paramMessage.next()).jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      return false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      int j = 0;
      while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramMessage = (vee)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if ((l1 - l2 >= paramMessage.jdField_b_of_type_Int) && (!paramMessage.jdField_a_of_type_Boolean))
        {
          paramMessage.jdField_a_of_type_Boolean = true;
          paramMessage.jdField_a_of_type_AndroidAnimationValueAnimator.start();
          paramMessage.jdField_c_of_type_AndroidAnimationValueAnimator.start();
        }
        j += 1;
      }
    } while (this.jdField_a_of_type_Vee.jdField_a_of_type_Boolean);
    paramMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    paramMessage.what = 2;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 25L);
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke == null) {}
    Object localObject2;
    do
    {
      return;
      localObject1 = a();
      if (localObject1 == null)
      {
        b();
        return;
      }
      localObject2 = new int[2];
      ((GivingHeartItemBuilder.Holder)localObject1).b.getLocationOnScreen((int[])localObject2);
      j = localObject2[0];
      this.h = ((int)(localObject2[1] + this.jdField_d_of_type_Float - this.jdField_e_of_type_Int));
    } while ((this.jdField_c_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap == null));
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    float f1;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (vee)((Iterator)localObject1).next();
      if (((vee)localObject2).jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        PointF localPointF;
        if (((vee)localObject2).jdField_b_of_type_Float <= 1.0F)
        {
          localPointF = ((vee)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$BezierEvaluator.a(((vee)localObject2).jdField_b_of_type_Float, null, null);
          this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localPointF.x, localPointF.y - (this.g - this.h) + this.jdField_d_of_type_Int);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidGraphicsMatrix.preScale(((vee)localObject2).jdField_a_of_type_Float, ((vee)localObject2).jdField_a_of_type_Float);
          paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
          break;
          f1 = ((vee)localObject2).jdField_b_of_type_Float;
          j = (int)(this.g * 0.6D * (1.0F - (f1 - 1.0F)));
          localPointF = ((vee)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$BezierEvaluator.a(((vee)localObject2).jdField_b_of_type_Float, null, null);
          this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localPointF.x, j - (this.g - this.h) + this.jdField_d_of_type_Int);
        }
      }
    }
    if (this.jdField_a_of_type_Vee.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Vee.jdField_b_of_type_Float > 1.0F) {
        break label489;
      }
    }
    label489:
    double d1;
    for (int j = (int)(this.jdField_a_of_type_Vee.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$BezierEvaluator.a(this.jdField_a_of_type_Vee.jdField_b_of_type_Float, null, null).y - (this.g - this.h) + this.jdField_d_of_type_Int);; j = (int)((1.0F - (f1 - 1.0F)) * (d1 * 0.6D)) - (this.g - this.h) + this.jdField_d_of_type_Int)
    {
      if (j + this.jdField_c_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_a_of_type_Vee.jdField_a_of_type_Float < 0.0F) {
        b();
      }
      switch (jdField_a_of_type_Int)
      {
      default: 
        return;
      case 1: 
        if (!this.jdField_b_of_type_Boolean) {
          break label538;
        }
        a(paramCanvas, null, this.jdField_a_of_type_AndroidGraphicsBitmap, 90.0F - this.jdField_a_of_type_Float * 90.0F, getWidth() - this.jdField_c_of_type_Float / 2.0F - this.i, this.h - this.jdField_d_of_type_Float / 2.0F);
        return;
        f1 = this.jdField_a_of_type_Vee.jdField_b_of_type_Float;
        d1 = this.g;
      }
    }
    label538:
    a(paramCanvas, null, this.jdField_b_of_type_AndroidGraphicsBitmap, -90.0F + this.jdField_a_of_type_Float * 90.0F, this.jdField_c_of_type_Float / 2.0F + this.i, this.h - this.jdField_d_of_type_Float / 2.0F);
    return;
    if (this.jdField_b_of_type_Boolean)
    {
      a(paramCanvas, null, this.jdField_a_of_type_AndroidGraphicsBitmap, getWidth() - this.jdField_c_of_type_Float + (this.jdField_b_of_type_Float - 0.5F) * 100.0F - this.i, this.h - this.jdField_d_of_type_Float);
      return;
    }
    a(paramCanvas, null, this.jdField_b_of_type_AndroidGraphicsBitmap, -(this.jdField_b_of_type_Float - 0.5F) * 100.0F + this.i, this.h - this.jdField_d_of_type_Float);
    return;
    if (this.jdField_b_of_type_Boolean)
    {
      a(paramCanvas, null, this.jdField_a_of_type_AndroidGraphicsBitmap, 90.0F - this.jdField_a_of_type_Float * 90.0F, getWidth() - this.jdField_c_of_type_Float / 2.0F - this.i - this.jdField_d_of_type_Int, this.h - this.jdField_d_of_type_Float / 2.0F + this.jdField_d_of_type_Int);
      return;
    }
    a(paramCanvas, null, this.jdField_b_of_type_AndroidGraphicsBitmap, -90.0F + this.jdField_a_of_type_Float * 90.0F, this.jdField_c_of_type_Float / 2.0F + this.i + this.jdField_d_of_type_Int, this.h - this.jdField_d_of_type_Float / 2.0F + this.jdField_d_of_type_Int);
  }
  
  public void setListener(SixCombolEffectView.ISixAnimationListener paramISixAnimationListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$ISixAnimationListener = paramISixAnimationListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SixCombolEffectView
 * JD-Core Version:    0.7.0.1
 */