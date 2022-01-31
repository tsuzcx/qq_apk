package com.tencent.mobileqq.activity.aio.item;

import aekt;
import aelz;
import afiv;
import afwu;
import afwv;
import afww;
import afwx;
import afwy;
import afwz;
import afxa;
import afxb;
import afxc;
import afxd;
import afxe;
import afxf;
import afxg;
import afxh;
import afxi;
import afxj;
import afxk;
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
import azgq;
import bdda;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import xee;

public class SixCombolEffectView
  extends View
  implements Handler.Callback
{
  public static int a;
  public static boolean a;
  public float a;
  private long jdField_a_of_type_Long;
  private aelz jdField_a_of_type_Aelz;
  private afxj jdField_a_of_type_Afxj;
  private afxk jdField_a_of_type_Afxk;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  BitmapFactory.Options jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  private MessageForPoke jdField_a_of_type_ComTencentMobileqqDataMessageForPoke;
  private String jdField_a_of_type_JavaLangString = "chat_item_for_qq666";
  private ArrayList<afxk> jdField_a_of_type_JavaUtilArrayList;
  public float b;
  int jdField_b_of_type_Int = azgq.a(30.0F);
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private boolean jdField_b_of_type_Boolean;
  float jdField_c_of_type_Float = azgq.a(120.0F);
  int jdField_c_of_type_Int = azgq.a(30.0F);
  private ValueAnimator jdField_c_of_type_AndroidAnimationValueAnimator;
  Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private boolean jdField_c_of_type_Boolean;
  float jdField_d_of_type_Float = azgq.a(120.0F);
  int jdField_d_of_type_Int = azgq.a(13.0F);
  private boolean jdField_d_of_type_Boolean;
  float jdField_e_of_type_Float;
  int jdField_e_of_type_Int = azgq.a(50.0F);
  float jdField_f_of_type_Float = azgq.a(100.0F);
  private int jdField_f_of_type_Int;
  private int g;
  private int h;
  private int i;
  private int j = azgq.a(60.0F);
  
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
  
  private afiv a()
  {
    View localView;
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) && (this.jdField_a_of_type_Aelz != null))
    {
      int k = aekt.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.uniseq, this.jdField_a_of_type_Aelz);
      localView = aekt.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, k + 1);
      if (localView != null) {}
    }
    else
    {
      return null;
    }
    return (afiv)aekt.a(localView);
  }
  
  @TargetApi(11)
  private afxk a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    afxk localafxk = new afxk(this);
    localafxk.jdField_a_of_type_Int = paramInt1;
    localafxk.jdField_a_of_type_Boolean = false;
    localafxk.jdField_b_of_type_Int = paramInt2;
    localafxk.jdField_d_of_type_Int = paramInt3;
    localafxk.jdField_f_of_type_Int = paramInt4;
    localafxk.g = paramInt5;
    localafxk.jdField_b_of_type_Boolean = false;
    localafxk.jdField_a_of_type_Afxi = new afxi(this);
    localafxk.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.2F, this.jdField_e_of_type_Float - 0.15F });
    localafxk.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration((int)(paramInt5 * 1.2D));
    localafxk.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new afxh(this, localafxk));
    localafxk.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new afwv(this, localafxk));
    localafxk.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { this.jdField_e_of_type_Float - 0.15F, this.jdField_e_of_type_Float });
    localafxk.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(paramInt6);
    localafxk.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new afww(this, localafxk));
    localafxk.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 2.5F });
    localafxk.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration(((paramInt6 - paramInt5) * 2.1D));
    localafxk.jdField_c_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
    localafxk.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new afwx(this));
    localafxk.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new afwy(this, localafxk));
    localafxk.jdField_d_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 2.2F });
    localafxk.jdField_d_of_type_AndroidAnimationValueAnimator.setDuration(paramInt6 - paramInt5);
    localafxk.jdField_d_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    localafxk.jdField_d_of_type_AndroidAnimationValueAnimator.addUpdateListener(new afwz(this, localafxk));
    return localafxk;
  }
  
  private void a(afxk paramafxk, int paramInt1, int paramInt2, int paramInt3)
  {
    paramafxk.jdField_c_of_type_Int = paramInt1;
    paramafxk.jdField_e_of_type_Int = paramInt2;
    paramafxk.jdField_b_of_type_Boolean = false;
    paramafxk.jdField_a_of_type_Afxi.a(new PointF[] { new PointF(paramInt1, paramafxk.jdField_d_of_type_Int), new PointF(paramInt2, paramafxk.jdField_d_of_type_Int - paramInt3), new PointF(paramInt2, paramafxk.jdField_f_of_type_Int) });
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
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = paramContext.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      this.jdField_a_of_type_Aelz = paramContext.jdField_a_of_type_Aelz;
    }
    setOnTouchListener(new afwu(this));
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inSampleSize = 1;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inMutable = true;
    if (PokeBigResHandler.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = bdda.a(PokeBigResHandler.b + "/666_caidan/666send_caidan_hand.png", this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
    }
    catch (OutOfMemoryError paramContext)
    {
      try
      {
        for (;;)
        {
          this.jdField_c_of_type_AndroidGraphicsBitmap = bdda.a(PokeBigResHandler.b + "/666_caidan/666send_caidan_hand6.png", this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
          this.jdField_b_of_type_AndroidGraphicsBitmap = a(this.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { -0.2F, 1.0F });
          this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
          this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new afxa(this));
          this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new afxb(this));
          this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F, 0.0F }).setDuration(300L);
          this.jdField_c_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
          this.jdField_c_of_type_AndroidAnimationValueAnimator.setRepeatCount(7);
          this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new afxc(this));
          this.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new afxd(this));
          this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, -0.2F });
          this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(300L);
          this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new afxe(this));
          this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new afxf(this));
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
      afxk localafxk = (afxk)localIterator.next();
      localafxk.jdField_d_of_type_AndroidAnimationValueAnimator.end();
      localafxk.jdField_a_of_type_AndroidAnimationValueAnimator.end();
      localafxk.jdField_c_of_type_AndroidAnimationValueAnimator.end();
      localafxk.jdField_b_of_type_AndroidAnimationValueAnimator.end();
      localafxk.jdField_a_of_type_Float = 0.0F;
      localafxk.jdField_b_of_type_Float = 0.0F;
      localafxk.jdField_a_of_type_Boolean = false;
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
    afxk localafxk;
    if (this.jdField_b_of_type_Boolean)
    {
      k = (int)(this.jdField_f_of_type_Int - azgq.a(50.0F) - this.jdField_c_of_type_Float / 2.0F);
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localafxk = (afxk)localIterator.next();
        if (localafxk.jdField_a_of_type_Int == 0) {
          a(localafxk, k, k / 3 * 2, 0);
        } else if (localafxk.jdField_a_of_type_Int == 1) {
          a(localafxk, k, k / 3, 0);
        } else {
          a(localafxk, k, azgq.a(10.0F), 50);
        }
      }
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      localafxk = (afxk)localIterator.next();
      k = (int)(azgq.a(50.0F) + this.jdField_c_of_type_Float / 2.0F);
      int m = (int)(this.jdField_f_of_type_Int - azgq.a(50.0F) - this.jdField_c_of_type_Float / 2.0F);
      if (localafxk.jdField_a_of_type_Int == 0) {
        a(localafxk, k, k, 0);
      } else if (localafxk.jdField_a_of_type_Int == 1) {
        a(localafxk, k, m / 3 + k, 0);
      } else {
        a(localafxk, k, (int)(this.jdField_f_of_type_Int - this.jdField_f_of_type_Float - azgq.a(10.0F)), 50);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void a(afiv paramafiv, boolean paramBoolean)
  {
    if (jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_d_of_type_Boolean = paramBoolean;
      d();
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke = ((MessageForPoke)paramafiv.a);
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
    int k = xee.a(paramContext);
    int m = getResources().getDisplayMetrics().heightPixels;
    this.jdField_f_of_type_Int = k;
    this.g = m;
    this.jdField_e_of_type_Float = (this.jdField_f_of_type_Float / this.jdField_c_of_type_AndroidGraphicsBitmap.getWidth());
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList.add(a(0, 800, m - azgq.a(70.0F), (int)(m * 0.6F), 700, 2000));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(0, 1600, m - azgq.a(70.0F), (int)(m * 0.6F), 600, 1400));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(0, 1800, m - azgq.a(70.0F), (int)(m * 0.6F), 600, 1800));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(1, 0, m - azgq.a(70.0F), (int)(m * 0.6F), 500, 1500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(1, 600, m - azgq.a(70.0F), (int)(m * 0.6F), 500, 1400));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(1, 1200, m - azgq.a(70.0F), (int)(m * 0.6F), 500, 1500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(1, 2000, m - azgq.a(70.0F), (int)(m * 0.6F), 500, 1800));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(2, 300, m - azgq.a(70.0F), (int)(m * 0.6F), 500, 1500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(2, 1000, m - azgq.a(70.0F), (int)(m * 0.6F), 500, 1500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(2, 1400, m - azgq.a(70.0F), (int)(m * 0.6F), 500, 1900));
    this.jdField_a_of_type_Afxk = ((afxk)this.jdField_a_of_type_JavaUtilArrayList.get(6));
    this.jdField_a_of_type_Afxk.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new afxg(this));
  }
  
  public void b()
  {
    setVisibility(8);
    afiv localafiv = a();
    if ((this.jdField_a_of_type_Afxj != null) && (localafiv != null))
    {
      this.jdField_a_of_type_Afxj.a(localafiv);
      this.jdField_a_of_type_Afxj = null;
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
    this.jdField_a_of_type_Aelz = null;
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
        ((afxk)paramMessage.next()).jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      return false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      int k = 0;
      while (k < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramMessage = (afxk)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        if ((l1 - l2 >= paramMessage.jdField_b_of_type_Int) && (!paramMessage.jdField_a_of_type_Boolean))
        {
          paramMessage.jdField_a_of_type_Boolean = true;
          paramMessage.jdField_a_of_type_AndroidAnimationValueAnimator.start();
          paramMessage.jdField_c_of_type_AndroidAnimationValueAnimator.start();
        }
        k += 1;
      }
    } while (this.jdField_a_of_type_Afxk.jdField_a_of_type_Boolean);
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
      ((afiv)localObject1).c.getLocationOnScreen((int[])localObject2);
      k = localObject2[0];
      this.i = ((int)(localObject2[1] + this.jdField_d_of_type_Float - this.jdField_e_of_type_Int));
    } while ((this.jdField_c_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap == null));
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    float f1;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (afxk)((Iterator)localObject1).next();
      if (((afxk)localObject2).jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        PointF localPointF;
        if (((afxk)localObject2).jdField_b_of_type_Float <= 1.0F)
        {
          localPointF = ((afxk)localObject2).jdField_a_of_type_Afxi.a(((afxk)localObject2).jdField_b_of_type_Float, null, null);
          this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localPointF.x, localPointF.y - (this.g - this.i) + this.jdField_d_of_type_Int);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidGraphicsMatrix.preScale(((afxk)localObject2).jdField_a_of_type_Float, ((afxk)localObject2).jdField_a_of_type_Float);
          paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
          break;
          f1 = ((afxk)localObject2).jdField_b_of_type_Float;
          k = (int)(this.g * 0.6D * (1.0F - (f1 - 1.0F)));
          localPointF = ((afxk)localObject2).jdField_a_of_type_Afxi.a(((afxk)localObject2).jdField_b_of_type_Float, null, null);
          this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localPointF.x, k - (this.g - this.i) + this.jdField_d_of_type_Int);
        }
      }
    }
    if (this.jdField_a_of_type_Afxk.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Afxk.jdField_b_of_type_Float > 1.0F) {
        break label489;
      }
    }
    label489:
    double d1;
    for (int k = (int)(this.jdField_a_of_type_Afxk.jdField_a_of_type_Afxi.a(this.jdField_a_of_type_Afxk.jdField_b_of_type_Float, null, null).y - (this.g - this.i) + this.jdField_d_of_type_Int);; k = (int)((1.0F - (f1 - 1.0F)) * (d1 * 0.6D)) - (this.g - this.i) + this.jdField_d_of_type_Int)
    {
      if (k + this.jdField_c_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_a_of_type_Afxk.jdField_a_of_type_Float < 0.0F) {
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
        f1 = this.jdField_a_of_type_Afxk.jdField_b_of_type_Float;
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
  
  public void setListener(afxj paramafxj)
  {
    this.jdField_a_of_type_Afxj = paramafxj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SixCombolEffectView
 * JD-Core Version:    0.7.0.1
 */