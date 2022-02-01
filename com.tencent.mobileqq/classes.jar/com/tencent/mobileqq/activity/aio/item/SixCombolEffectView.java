package com.tencent.mobileqq.activity.aio.item;

import afqz;
import agsz;
import ahhb;
import ahhc;
import ahhd;
import ahhe;
import ahhf;
import ahhg;
import ahhh;
import ahhi;
import ahhj;
import ahhk;
import ahhl;
import ahhm;
import ahhn;
import ahho;
import ahhp;
import ahhq;
import ahhr;
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
import bheg;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class SixCombolEffectView
  extends View
  implements Handler.Callback
{
  public static int a;
  public static boolean a;
  public float a;
  private long jdField_a_of_type_Long;
  private afqz jdField_a_of_type_Afqz;
  private ahhq jdField_a_of_type_Ahhq;
  private ahhr jdField_a_of_type_Ahhr;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  BitmapFactory.Options jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  private MessageForPoke jdField_a_of_type_ComTencentMobileqqDataMessageForPoke;
  private String jdField_a_of_type_JavaLangString = "chat_item_for_qq666";
  private ArrayList<ahhr> jdField_a_of_type_JavaUtilArrayList;
  public float b;
  int jdField_b_of_type_Int = ScreenUtil.dip2px(30.0F);
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private boolean jdField_b_of_type_Boolean;
  float jdField_c_of_type_Float = ScreenUtil.dip2px(120.0F);
  int jdField_c_of_type_Int = ScreenUtil.dip2px(30.0F);
  private ValueAnimator jdField_c_of_type_AndroidAnimationValueAnimator;
  Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private boolean jdField_c_of_type_Boolean;
  float jdField_d_of_type_Float = ScreenUtil.dip2px(120.0F);
  int jdField_d_of_type_Int = ScreenUtil.dip2px(13.0F);
  private boolean jdField_d_of_type_Boolean;
  float jdField_e_of_type_Float;
  int jdField_e_of_type_Int = ScreenUtil.dip2px(50.0F);
  float jdField_f_of_type_Float = ScreenUtil.dip2px(100.0F);
  private int jdField_f_of_type_Int;
  private int g;
  private int h;
  private int i;
  private int j = ScreenUtil.dip2px(60.0F);
  
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
  
  private agsz a()
  {
    View localView;
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) && (this.jdField_a_of_type_Afqz != null))
    {
      int k = AIOUtils.findMessagePosition(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.uniseq, this.jdField_a_of_type_Afqz);
      localView = AIOUtils.getViewByPostion(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, k + 1);
      if (localView != null) {}
    }
    else
    {
      return null;
    }
    return (agsz)AIOUtils.getHolder(localView);
  }
  
  @TargetApi(11)
  private ahhr a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    ahhr localahhr = new ahhr(this);
    localahhr.jdField_a_of_type_Int = paramInt1;
    localahhr.jdField_a_of_type_Boolean = false;
    localahhr.jdField_b_of_type_Int = paramInt2;
    localahhr.jdField_d_of_type_Int = paramInt3;
    localahhr.jdField_f_of_type_Int = paramInt4;
    localahhr.g = paramInt5;
    localahhr.jdField_b_of_type_Boolean = false;
    localahhr.jdField_a_of_type_Ahhp = new ahhp(this);
    localahhr.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.2F, this.jdField_e_of_type_Float - 0.15F });
    localahhr.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration((int)(paramInt5 * 1.2D));
    localahhr.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new ahho(this, localahhr));
    localahhr.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ahhc(this, localahhr));
    localahhr.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { this.jdField_e_of_type_Float - 0.15F, this.jdField_e_of_type_Float });
    localahhr.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(paramInt6);
    localahhr.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ahhd(this, localahhr));
    localahhr.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 2.5F });
    localahhr.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration(((paramInt6 - paramInt5) * 2.1D));
    localahhr.jdField_c_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
    localahhr.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new ahhe(this));
    localahhr.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ahhf(this, localahhr));
    localahhr.jdField_d_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 2.2F });
    localahhr.jdField_d_of_type_AndroidAnimationValueAnimator.setDuration(paramInt6 - paramInt5);
    localahhr.jdField_d_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    localahhr.jdField_d_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ahhg(this, localahhr));
    return localahhr;
  }
  
  private void a(ahhr paramahhr, int paramInt1, int paramInt2, int paramInt3)
  {
    paramahhr.jdField_c_of_type_Int = paramInt1;
    paramahhr.jdField_e_of_type_Int = paramInt2;
    paramahhr.jdField_b_of_type_Boolean = false;
    paramahhr.jdField_a_of_type_Ahhp.a(new PointF[] { new PointF(paramInt1, paramahhr.jdField_d_of_type_Int), new PointF(paramInt2, paramahhr.jdField_d_of_type_Int - paramInt3), new PointF(paramInt2, paramahhr.jdField_f_of_type_Int) });
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
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      paramContext = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = paramContext.listView;
      this.jdField_a_of_type_Afqz = paramContext.listAdapter;
    }
    setOnTouchListener(new ahhb(this));
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inSampleSize = 1;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inMutable = true;
    if (PokeBigResHandler.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = bheg.a(PokeBigResHandler.b + "/666_caidan/666send_caidan_hand.png", this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
    }
    catch (OutOfMemoryError paramContext)
    {
      try
      {
        for (;;)
        {
          this.jdField_c_of_type_AndroidGraphicsBitmap = bheg.a(PokeBigResHandler.b + "/666_caidan/666send_caidan_hand6.png", this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
          this.jdField_b_of_type_AndroidGraphicsBitmap = a(this.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { -0.2F, 1.0F });
          this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
          this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ahhh(this));
          this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new ahhi(this));
          this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F, 0.0F }).setDuration(300L);
          this.jdField_c_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
          this.jdField_c_of_type_AndroidAnimationValueAnimator.setRepeatCount(7);
          this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ahhj(this));
          this.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new ahhk(this));
          this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, -0.2F });
          this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(300L);
          this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ahhl(this));
          this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new ahhm(this));
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
      ahhr localahhr = (ahhr)localIterator.next();
      localahhr.jdField_d_of_type_AndroidAnimationValueAnimator.end();
      localahhr.jdField_a_of_type_AndroidAnimationValueAnimator.end();
      localahhr.jdField_c_of_type_AndroidAnimationValueAnimator.end();
      localahhr.jdField_b_of_type_AndroidAnimationValueAnimator.end();
      localahhr.jdField_a_of_type_Float = 0.0F;
      localahhr.jdField_b_of_type_Float = 0.0F;
      localahhr.jdField_a_of_type_Boolean = false;
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
    int k;
    ahhr localahhr;
    if (this.jdField_b_of_type_Boolean)
    {
      k = (int)(this.jdField_f_of_type_Int - ScreenUtil.dip2px(50.0F) - this.jdField_c_of_type_Float / 2.0F);
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localahhr = (ahhr)localIterator.next();
        if (localahhr.jdField_a_of_type_Int == 0) {
          a(localahhr, k, k / 3 * 2, 0);
        } else if (localahhr.jdField_a_of_type_Int == 1) {
          a(localahhr, k, k / 3, 0);
        } else {
          a(localahhr, k, ScreenUtil.dip2px(10.0F), 50);
        }
      }
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      localahhr = (ahhr)localIterator.next();
      k = (int)(ScreenUtil.dip2px(50.0F) + this.jdField_c_of_type_Float / 2.0F);
      int m = (int)(this.jdField_f_of_type_Int - ScreenUtil.dip2px(50.0F) - this.jdField_c_of_type_Float / 2.0F);
      if (localahhr.jdField_a_of_type_Int == 0) {
        a(localahhr, k, k, 0);
      } else if (localahhr.jdField_a_of_type_Int == 1) {
        a(localahhr, k, m / 3 + k, 0);
      } else {
        a(localahhr, k, (int)(this.jdField_f_of_type_Int - this.jdField_f_of_type_Float - ScreenUtil.dip2px(10.0F)), 50);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void a(agsz paramagsz, boolean paramBoolean)
  {
    if (jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_d_of_type_Boolean = paramBoolean;
      d();
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke = ((MessageForPoke)paramagsz.a);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.mFrameState.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.isSend();
      jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    } while (!this.jdField_d_of_type_Boolean);
    this.h = HapticManager.a().a(this.jdField_a_of_type_JavaLangString, 2);
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    int k = DisplayUtil.getWindowScreenWidth(paramContext);
    int m = getResources().getDisplayMetrics().heightPixels;
    this.jdField_f_of_type_Int = k;
    this.g = m;
    this.jdField_e_of_type_Float = (this.jdField_f_of_type_Float / this.jdField_c_of_type_AndroidGraphicsBitmap.getWidth());
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList.add(a(0, 800, m - ScreenUtil.dip2px(70.0F), (int)(m * 0.6F), 700, 2000));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(0, 1600, m - ScreenUtil.dip2px(70.0F), (int)(m * 0.6F), 600, 1400));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(0, 1800, m - ScreenUtil.dip2px(70.0F), (int)(m * 0.6F), 600, 1800));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(1, 0, m - ScreenUtil.dip2px(70.0F), (int)(m * 0.6F), 500, 1500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(1, 600, m - ScreenUtil.dip2px(70.0F), (int)(m * 0.6F), 500, 1400));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(1, 1200, m - ScreenUtil.dip2px(70.0F), (int)(m * 0.6F), 500, 1500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(1, 2000, m - ScreenUtil.dip2px(70.0F), (int)(m * 0.6F), 500, 1800));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(2, 300, m - ScreenUtil.dip2px(70.0F), (int)(m * 0.6F), 500, 1500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(2, 1000, m - ScreenUtil.dip2px(70.0F), (int)(m * 0.6F), 500, 1500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(2, 1400, m - ScreenUtil.dip2px(70.0F), (int)(m * 0.6F), 500, 1900));
    this.jdField_a_of_type_Ahhr = ((ahhr)this.jdField_a_of_type_JavaUtilArrayList.get(6));
    this.jdField_a_of_type_Ahhr.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new ahhn(this));
  }
  
  public void b()
  {
    setVisibility(8);
    agsz localagsz = a();
    if ((this.jdField_a_of_type_Ahhq != null) && (localagsz != null))
    {
      this.jdField_a_of_type_Ahhq.a(localagsz);
      this.jdField_a_of_type_Ahhq = null;
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
    this.jdField_a_of_type_Afqz = null;
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
        ((ahhr)paramMessage.next()).jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      return false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      int k = 0;
      while (k < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramMessage = (ahhr)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        if ((l1 - l2 >= paramMessage.jdField_b_of_type_Int) && (!paramMessage.jdField_a_of_type_Boolean))
        {
          paramMessage.jdField_a_of_type_Boolean = true;
          paramMessage.jdField_a_of_type_AndroidAnimationValueAnimator.start();
          paramMessage.jdField_c_of_type_AndroidAnimationValueAnimator.start();
        }
        k += 1;
      }
    } while (this.jdField_a_of_type_Ahhr.jdField_a_of_type_Boolean);
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
      ((agsz)localObject1).c.getLocationOnScreen((int[])localObject2);
      k = localObject2[0];
      this.i = ((int)(localObject2[1] + this.jdField_d_of_type_Float - this.jdField_e_of_type_Int));
    } while ((this.jdField_c_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap == null));
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    float f1;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ahhr)((Iterator)localObject1).next();
      if (((ahhr)localObject2).jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        PointF localPointF;
        if (((ahhr)localObject2).jdField_b_of_type_Float <= 1.0F)
        {
          localPointF = ((ahhr)localObject2).jdField_a_of_type_Ahhp.a(((ahhr)localObject2).jdField_b_of_type_Float, null, null);
          this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localPointF.x, localPointF.y - (this.g - this.i) + this.jdField_d_of_type_Int);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidGraphicsMatrix.preScale(((ahhr)localObject2).jdField_a_of_type_Float, ((ahhr)localObject2).jdField_a_of_type_Float);
          paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
          break;
          f1 = ((ahhr)localObject2).jdField_b_of_type_Float;
          k = (int)(this.g * 0.6D * (1.0F - (f1 - 1.0F)));
          localPointF = ((ahhr)localObject2).jdField_a_of_type_Ahhp.a(((ahhr)localObject2).jdField_b_of_type_Float, null, null);
          this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localPointF.x, k - (this.g - this.i) + this.jdField_d_of_type_Int);
        }
      }
    }
    if (this.jdField_a_of_type_Ahhr.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Ahhr.jdField_b_of_type_Float > 1.0F) {
        break label489;
      }
    }
    label489:
    double d1;
    for (int k = (int)(this.jdField_a_of_type_Ahhr.jdField_a_of_type_Ahhp.a(this.jdField_a_of_type_Ahhr.jdField_b_of_type_Float, null, null).y - (this.g - this.i) + this.jdField_d_of_type_Int);; k = (int)((1.0F - (f1 - 1.0F)) * (d1 * 0.6D)) - (this.g - this.i) + this.jdField_d_of_type_Int)
    {
      if (k + this.jdField_c_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_a_of_type_Ahhr.jdField_a_of_type_Float < 0.0F) {
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
        a(paramCanvas, null, this.jdField_a_of_type_AndroidGraphicsBitmap, 90.0F - this.jdField_a_of_type_Float * 90.0F, getWidth() - this.jdField_c_of_type_Float / 2.0F - this.j, this.i - this.jdField_d_of_type_Float / 2.0F);
        return;
        f1 = this.jdField_a_of_type_Ahhr.jdField_b_of_type_Float;
        d1 = this.g;
      }
    }
    label538:
    a(paramCanvas, null, this.jdField_b_of_type_AndroidGraphicsBitmap, -90.0F + this.jdField_a_of_type_Float * 90.0F, this.jdField_c_of_type_Float / 2.0F + this.j, this.i - this.jdField_d_of_type_Float / 2.0F);
    return;
    if (this.jdField_b_of_type_Boolean)
    {
      a(paramCanvas, null, this.jdField_a_of_type_AndroidGraphicsBitmap, getWidth() - this.jdField_c_of_type_Float + (this.jdField_b_of_type_Float - 0.5F) * 100.0F - this.j, this.i - this.jdField_d_of_type_Float);
      return;
    }
    a(paramCanvas, null, this.jdField_b_of_type_AndroidGraphicsBitmap, -(this.jdField_b_of_type_Float - 0.5F) * 100.0F + this.j, this.i - this.jdField_d_of_type_Float);
    return;
    if (this.jdField_b_of_type_Boolean)
    {
      a(paramCanvas, null, this.jdField_a_of_type_AndroidGraphicsBitmap, 90.0F - this.jdField_a_of_type_Float * 90.0F, getWidth() - this.jdField_c_of_type_Float / 2.0F - this.j - this.jdField_d_of_type_Int, this.i - this.jdField_d_of_type_Float / 2.0F + this.jdField_d_of_type_Int);
      return;
    }
    a(paramCanvas, null, this.jdField_b_of_type_AndroidGraphicsBitmap, -90.0F + this.jdField_a_of_type_Float * 90.0F, this.jdField_c_of_type_Float / 2.0F + this.j + this.jdField_d_of_type_Int, this.i - this.jdField_d_of_type_Float / 2.0F + this.jdField_d_of_type_Int);
  }
  
  public void setListener(ahhq paramahhq)
  {
    this.jdField_a_of_type_Ahhq = paramahhq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SixCombolEffectView
 * JD-Core Version:    0.7.0.1
 */