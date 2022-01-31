package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.business.manager.zimu.ARZimuTask;
import com.tencent.av.business.manager.zimu.ARZimuUtil;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gameplay.GPNativeSoLoader;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.opengl.ui.GLView.OnTouchListener;
import com.tencent.av.opengl.ui.animation.GLAnimation;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.funchat.zimu.ZimuViewProxy;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.UITools;
import com.tencent.av.widget.RotateLayout;
import com.tencent.av.widget.RotateLayout.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import kea;
import keb;
import kec;
import ked;
import kee;
import kef;
import keg;
import keh;
import kei;

public class VideoLayerUI
  extends VideoLayerUIBase
{
  public int a;
  private long jdField_a_of_type_Long;
  public GestureDetector a;
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MoveGestureDetector jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector;
  private GLView.OnTouchListener jdField_a_of_type_ComTencentAvOpenglUiGLView$OnTouchListener;
  private QQLogo jdField_a_of_type_ComTencentAvUiQQLogo;
  protected VideoLayerUI.MultiVideoOpenAnimation a;
  ZimuViewProxy jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy;
  private TipsManager jdField_a_of_type_ComTencentAvUtilsTipsManager;
  private RotateLayout jdField_a_of_type_ComTencentAvWidgetRotateLayout;
  private List jdField_a_of_type_JavaUtilList = new LinkedList();
  private keh jdField_a_of_type_Keh;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = true;
  private Runnable jdField_c_of_type_JavaLangRunnable = new kei(this, null);
  private boolean jdField_c_of_type_Boolean;
  private Runnable d;
  private int j = -1;
  private int k = -1;
  private int l;
  private int m;
  private int n;
  
  public VideoLayerUI(VideoAppInterface paramVideoAppInterface, Context paramContext, View paramView, TipsManager paramTipsManager)
  {
    super(paramVideoAppInterface, paramContext, paramView);
    this.jdField_d_of_type_JavaLangRunnable = new kee(this, null);
    this.jdField_a_of_type_ComTencentAvUiScreenLayout = ScreenLayout.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1, false);
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = paramTipsManager;
    b();
    q();
    c();
    r();
    n();
    y();
    s();
    j();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "VideoLayerUI");
  }
  
  private Boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  private static final String a(CharSequence paramCharSequence)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramCharSequence);
    int i = paramCharSequence.length();
    QQText.EmoticonSpan[] arrayOfEmoticonSpan = (QQText.EmoticonSpan[])((QQText)paramCharSequence).getSpans(0, i, QQText.EmoticonSpan.class);
    i = 0;
    int i2;
    for (int i1 = 0; i < arrayOfEmoticonSpan.length; i1 = i2)
    {
      Object localObject = arrayOfEmoticonSpan[i];
      i2 = i1;
      if ((localObject instanceof QQText.EmoticonSpan))
      {
        int i3 = ((QQText)paramCharSequence).getSpanStart(localObject);
        int i4 = ((QQText)paramCharSequence).getSpanEnd(localObject);
        i2 = i1;
        if (((QQText.EmoticonSpan)localObject).jdField_c_of_type_Int == 2)
        {
          localObject = ((QQText.EmoticonSpan)localObject).a();
          localStringBuffer.replace(i3 + i1, i4 + i1, (String)localObject);
          i2 = i1 + (((String)localObject).length() - (i4 - i3));
        }
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramString + "_" + paramInt;
  }
  
  private void a(GLVideoView paramGLVideoView, float paramFloat, long paramLong)
  {
    paramLong /= 10L;
    a(new ked(this, paramLong, paramGLVideoView, (float)Math.pow(paramFloat, 1.0D / paramLong)));
  }
  
  private void a(GLVideoView paramGLVideoView, boolean paramBoolean)
  {
    GLAnimation localGLAnimation = new GLAnimation();
    localGLAnimation.b(200);
    localGLAnimation.b(0.0F, 0.0F, 0.0F, 90.0F, 0.0F, 0.0F);
    localGLAnimation.a(new kea(this, paramGLVideoView, paramBoolean));
    localGLAnimation.a(1);
    paramGLVideoView.a(localGLAnimation);
    paramGLVideoView.v();
  }
  
  private boolean a(CharSequence paramCharSequence)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if ((paramCharSequence instanceof QQText))
    {
      paramCharSequence = (QQText.EmoticonSpan[])((QQText)paramCharSequence).getSpans(0, paramCharSequence.length(), QQText.EmoticonSpan.class);
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramCharSequence.length)
      {
        if (paramCharSequence[i].jdField_c_of_type_Int == 2) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void b(RecvMsg paramRecvMsg)
  {
    if (a().booleanValue()) {
      return;
    }
    String str2 = paramRecvMsg.c();
    String str3 = paramRecvMsg.a();
    String str1 = paramRecvMsg.b();
    Object localObject = str1;
    if (TextUtils.isEmpty(str1))
    {
      localObject = str1;
      if (this.jdField_a_of_type_ComTencentAvVideoController.e)
      {
        localObject = str1;
        if (str3 != null) {
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.a(str3, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().f), this.jdField_a_of_type_ComTencentAvVideoController.a().F);
        }
      }
    }
    paramRecvMsg = paramRecvMsg.d();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showRecvMsg friendUin: " + str2 + ", senderUin: " + str3 + ", senderName: " + (String)localObject + ", msg: " + paramRecvMsg);
    }
    m(this.i);
    boolean bool2 = i();
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      g(bool1);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      if ((paramRecvMsg == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null)) {
        break;
      }
      localObject = new QQText(paramRecvMsg, 11);
      paramRecvMsg = (RecvMsg)localObject;
      if (a((CharSequence)localObject)) {
        paramRecvMsg = a((CharSequence)localObject);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramRecvMsg);
      if (!bool2) {
        break;
      }
      localObject = paramRecvMsg;
      if (paramRecvMsg.equals("。")) {
        localObject = "。 ";
      }
      a(Integer.valueOf(6008), new SentenceInfo(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().c, (CharSequence)localObject, (CharSequence)localObject, 2));
      return;
    }
  }
  
  private void b(GLVideoView paramGLVideoView, boolean paramBoolean)
  {
    GLAnimation localGLAnimation = new GLAnimation();
    localGLAnimation.b(200);
    localGLAnimation.b(0.0F, 0.0F, -90.0F, 0.0F, 0.0F, 0.0F);
    localGLAnimation.a(2);
    paramGLVideoView.a(localGLAnimation);
    paramGLVideoView.v();
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Long != 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "bigWindowToSmallWindowAnim, 大小窗正在切换中[" + this.jdField_a_of_type_Long + "]");
      return false;
    }
    GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2];
    localGLVideoView.a(Boolean.valueOf(false));
    localGLVideoView.a(0, 0, 0, 0);
    int i = localGLVideoView.i();
    localGLVideoView.h(1);
    float f1 = localGLVideoView.b().left;
    float f2 = localGLVideoView.b().top;
    Rect localRect = super.a();
    GLAnimation localGLAnimation = new GLAnimation();
    localGLAnimation.b(300);
    localGLAnimation.a(f1, f2, 0.0F, -localRect.left, -localRect.top, 0.0F);
    localGLAnimation.a(localGLVideoView.b().width(), localGLVideoView.b().height(), super.g() + localRect.left + localRect.right, super.h() + localRect.top + localRect.bottom);
    localGLAnimation.a(new kec(this, paramInt2, i, paramInt1));
    localGLAnimation.a(2);
    localGLVideoView.a(localGLAnimation);
    localGLVideoView.v();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    return true;
  }
  
  private void c(String paramString, int paramInt)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "closeVideoView[" + paramString + "], index[" + paramInt + "]");
    int i1 = 0;
    float f1 = 0.0F;
    int i = 0;
    boolean bool1 = false;
    Object localObject = ImageView.ScaleType.CENTER_INSIDE;
    int i4 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    paramString = (String)localObject;
    int i3;
    if (paramInt == 0)
    {
      i2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b();
      float f2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].d();
      i3 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].c();
      boolean bool2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].e();
      paramString = (String)localObject;
      bool1 = bool2;
      i = i3;
      f1 = f2;
      i1 = i2;
      if (i4 == 4)
      {
        paramString = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a();
        i1 = i2;
        f1 = f2;
        i = i3;
        bool1 = bool2;
      }
    }
    int i2 = paramInt;
    while (i2 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length) {
      if ((i2 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length - 1) && (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(i2 + 1)].f() == 0))
      {
        i3 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i2].i();
        int i5 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(i2 + 1)].i();
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i2].h(i5);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(i2 + 1)].h(i3);
        localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i2];
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i2] = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(i2 + 1)];
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(i2 + 1)] = localObject;
        i2 += 1;
      }
      else
      {
        localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i2];
        ((GLVideoView)localObject).g(1);
        ((GLVideoView)localObject).b(null);
        ((GLVideoView)localObject).i(true);
        ((GLVideoView)localObject).g(false);
        ((GLVideoView)localObject).c(false);
        ((GLVideoView)localObject).h(true);
        ((GLVideoView)localObject).a(null, 0);
        ((GLVideoView)localObject).a("");
      }
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].e(false);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].c(i1);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(f1);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b(i);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].f(bool1);
      if (i4 == 4) {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(paramString);
      }
    }
    a(false);
  }
  
  private int d()
  {
    int i = 0;
    int i2;
    for (int i1 = 0; i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length; i1 = i2)
    {
      GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      String str = localGLVideoView.a();
      i2 = i1;
      if (localGLVideoView.f() == 0)
      {
        i2 = i1;
        if (!TextUtils.isEmpty(str)) {
          i2 = i1 + 1;
        }
      }
      i += 1;
    }
    return i1;
  }
  
  private void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showMsgbox: show = " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {}
    do
    {
      return;
      localObject = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources();
      int i = (int)(((Resources)localObject).getDimension(2131558601) + ((Resources)localObject).getDimension(2131558608));
      int i1 = (int)(((Resources)localObject).getDimension(2131558599) + ((Resources)localObject).getDimension(2131558606));
      int i2 = (int)(((Resources)localObject).getDimension(2131558602) + ((Resources)localObject).getDimension(2131558609));
      f = ((Resources)localObject).getDimension(2131558600);
      int i3 = (int)(((Resources)localObject).getDimension(2131558607) + f);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i, i1, i2, i3);
      this.jdField_b_of_type_AndroidWidgetTextView.getBackground().setAlpha(128);
      if ((this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.isShown()) && (!paramBoolean))
      {
        localObject = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject).setDuration(1000L);
        ((AlphaAnimation)localObject).setFillAfter(true);
        ((AlphaAnimation)localObject).setAnimationListener(new keg(this, null));
        this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.startAnimation((Animation)localObject);
        return;
      }
    } while (!paramBoolean);
    Object localObject = new Transformation();
    ((Transformation)localObject).setAlpha(0.0F);
    AlphaAnimation localAlphaAnimation = (AlphaAnimation)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getAnimation();
    if (localAlphaAnimation != null)
    {
      localAlphaAnimation.setAnimationListener(null);
      localAlphaAnimation.getTransformation(System.currentTimeMillis(), (Transformation)localObject);
    }
    float f = ((Transformation)localObject).getAlpha();
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.clearAnimation();
    localObject = new AlphaAnimation(f, 1.0F);
    ((AlphaAnimation)localObject).setDuration(1000L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setFillBefore(true);
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.startAnimation((Animation)localObject);
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setTag(Long.valueOf(System.currentTimeMillis()));
  }
  
  private void h(boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0))
    {
      k();
      localObject = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a();
      if (localObject != null)
      {
        localObject = ((ZimuItem)localObject).getId();
        if (!paramBoolean) {
          break label50;
        }
      }
    }
    label50:
    for (int i = 6005;; i = 6011)
    {
      a(Integer.valueOf(i), localObject);
      return;
    }
  }
  
  private boolean i()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)) {
      bool = ((AVActivity)this.jdField_a_of_type_AndroidContentContext).e();
    }
    return bool;
  }
  
  private void m(int paramInt)
  {
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null)) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b();
    Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getLayoutParams();
    int i3 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131559748);
    int i1 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131559749);
    int i4 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131559752);
    int i = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131559753);
    int i5 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131559754);
    if ((this.jdField_c_of_type_Int == 0) || (this.jdField_b_of_type_Int == 0))
    {
      i = i4;
      i1 = i3;
    }
    int i6 = d();
    if (i6 <= 0)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(11, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(9, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = i4;
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (i + this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = (RotateLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((RotateLayout.LayoutParams)localObject1).a = 0;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      i = this.jdField_a_of_type_AndroidViewView.getWidth() - i4 * 2;
      paramInt = i;
      if (i > this.m) {
        paramInt = this.m;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(paramInt);
      return;
    }
    int i2 = paramInt;
    if (this.jdField_c_of_type_Int != 0)
    {
      i2 = paramInt;
      if (this.jdField_b_of_type_Int != 0) {
        i2 = 0;
      }
    }
    paramInt = c();
    if (i2 == 0)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(11, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(9, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
      if (i6 == 1)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = i4;
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (i + this.jdField_c_of_type_Int);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin += this.n;
        this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (QLog.isDevelopLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 4, "setLayoutParams, [" + ((RelativeLayout.LayoutParams)localObject2).leftMargin + ", " + ((RelativeLayout.LayoutParams)localObject2).topMargin + ", " + ((RelativeLayout.LayoutParams)localObject2).rightMargin + ", " + ((RelativeLayout.LayoutParams)localObject2).bottomMargin + "]");
        }
        localObject2 = (RotateLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((RotateLayout.LayoutParams)localObject2).a = i2;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = super.b();
        if (i6 != 1) {
          break label1039;
        }
      }
    }
    label1039:
    for (paramInt = ((Rect)localObject2).width() - i4 * 2;; paramInt = ((Rect)localObject2).width() - ((Rect)localObject1).width() - i3 - i4 - i5)
    {
      i = paramInt;
      if (paramInt > this.m) {
        i = this.m;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(i);
      return;
      if (i6 == 2)
      {
        if (paramInt == 4) {}
        for (((RelativeLayout.LayoutParams)localObject2).leftMargin = (((Rect)localObject1).width() + i3 + i5);; ((RelativeLayout.LayoutParams)localObject2).leftMargin = i4)
        {
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (i + this.jdField_c_of_type_Int);
          break;
        }
      }
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = i4;
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (i + this.jdField_c_of_type_Int + ((Rect)localObject1).height());
      break;
      if (i2 == 90)
      {
        ((RelativeLayout.LayoutParams)localObject2).addRule(10, 0);
        ((RelativeLayout.LayoutParams)localObject2).addRule(9, 0);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
        if (i6 == 1)
        {
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = i4;
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (i + this.jdField_c_of_type_Int);
          break;
        }
        if (i6 < 2) {
          break;
        }
        if (paramInt == 3) {}
        for (((RelativeLayout.LayoutParams)localObject2).bottomMargin = (((Rect)localObject1).height() + i1 + i5 + this.jdField_c_of_type_Int);; ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (i + this.jdField_c_of_type_Int))
        {
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = i4;
          break;
        }
      }
      if (i2 == 180)
      {
        ((RelativeLayout.LayoutParams)localObject2).addRule(9, 0);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12, 0);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
        ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
        if (i6 == 1)
        {
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = i4;
          ((RelativeLayout.LayoutParams)localObject2).topMargin = (i + this.jdField_b_of_type_Int);
          break;
        }
        if (i6 == 2)
        {
          if (paramInt == 2) {}
          for (((RelativeLayout.LayoutParams)localObject2).rightMargin = (((Rect)localObject1).width() + i3 + i5);; ((RelativeLayout.LayoutParams)localObject2).rightMargin = i4)
          {
            ((RelativeLayout.LayoutParams)localObject2).topMargin = (i + this.jdField_b_of_type_Int);
            break;
          }
        }
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = i4;
        if (paramInt == 2)
        {
          ((RelativeLayout.LayoutParams)localObject2).topMargin = (i + this.jdField_b_of_type_Int + ((Rect)localObject1).height());
          break;
        }
        ((RelativeLayout.LayoutParams)localObject2).topMargin = (i + this.jdField_b_of_type_Int);
        break;
      }
      if (i2 != 270) {
        break;
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(11, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(9, -1);
      if (i6 == 1)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = i4;
        ((RelativeLayout.LayoutParams)localObject2).topMargin = (i + this.jdField_b_of_type_Int);
        break;
      }
      if (i6 < 2) {
        break;
      }
      if (paramInt == 1) {}
      for (((RelativeLayout.LayoutParams)localObject2).topMargin = (((Rect)localObject1).height() + i1 + i5 + this.jdField_b_of_type_Int);; ((RelativeLayout.LayoutParams)localObject2).topMargin = (i + this.jdField_b_of_type_Int))
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = i4;
        break;
      }
    }
  }
  
  private void n(int paramInt)
  {
    if ((paramInt > 0) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null))
    {
      if (paramInt != 2) {
        break label93;
      }
      paramInt = 2131429586;
    }
    for (;;)
    {
      int i = paramInt;
      if (i())
      {
        i = paramInt;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().y)
        {
          ((AVActivity)this.jdField_a_of_type_AndroidContentContext).a.c();
          i = 2131429684;
        }
      }
      if (i > 0)
      {
        String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(i);
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(2000, str, 4000L, 0);
      }
      return;
      label93:
      if (paramInt == 3) {
        paramInt = 2131429588;
      } else if (paramInt == 1) {
        paramInt = 2131429587;
      } else {
        paramInt = 0;
      }
    }
  }
  
  private void q()
  {
    this.h = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("qav_SP", 0).getInt("video_position", 3);
  }
  
  private void r()
  {
    int i1 = 2130840115;
    int i = i1;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      i = i1;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1008) {
        i = 2130840224;
      }
    }
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b(UITools.a(this.jdField_a_of_type_AndroidContentContext, i));
    super.b(UITools.a(this.jdField_a_of_type_AndroidContentContext, i));
  }
  
  private void s()
  {
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(this.jdField_a_of_type_AndroidContentContext, new VideoLayerUI.ScaleGestureListener(this));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new VideoLayerUI.GestureListener(this));
    this.jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector = new MoveGestureDetector(this.jdField_a_of_type_AndroidContentContext, new kef(this, null));
    this.jdField_a_of_type_ComTencentAvOpenglUiGLView$OnTouchListener = new VideoLayerUI.TouchListener(this);
    a(this.jdField_a_of_type_ComTencentAvOpenglUiGLView$OnTouchListener);
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null)
    {
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout = ((RotateLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366308));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366309));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366084));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366086));
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources();
      this.l = ((int)localResources.getDimension(2131559913));
      this.m = ((int)localResources.getDimension(2131559914));
      int i = (int)(localResources.getDimension(2131558601) + localResources.getDimension(2131558608));
      int i1 = (int)(localResources.getDimension(2131558599) + localResources.getDimension(2131558606));
      int i2 = (int)(localResources.getDimension(2131558602) + localResources.getDimension(2131558609));
      float f = localResources.getDimension(2131558600);
      int i3 = (int)(localResources.getDimension(2131558607) + f);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i, i1, i2, i3);
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(Long.valueOf(0L));
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.l);
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(this.m);
      this.jdField_b_of_type_AndroidWidgetTextView.getBackground().setAlpha(128);
    }
  }
  
  private void y()
  {
    this.jdField_a_of_type_Keh = new keh(this, this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView);
    ViewCompat.setAccessibilityDelegate(this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView, this.jdField_a_of_type_Keh);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentAvUiScreenLayout.a();
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setOffset topOffset: " + paramInt1 + ", bottomOffset: " + paramInt2);
    }
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    a(true);
    m(this.i);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().G)
      {
        int i = 0;
        if (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
        {
          GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
          if (i == 0) {
            if ((paramInt1 != 0) && (paramInt2 != 0)) {
              localGLVideoView.f(false);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            localGLVideoView.f(true);
            continue;
            localGLVideoView.f(true);
          }
        }
      }
      else
      {
        paramInt1 = 0;
        while (paramInt1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
        {
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].f(false);
          paramInt1 += 1;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy != null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a(this, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    }
  }
  
  @TargetApi(11)
  public void a(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    if ((!this.jdField_a_of_type_Boolean) && (!f())) {
      this.g = paramInt;
    }
    label356:
    for (;;)
    {
      return;
      if ((paramInt != this.f) || (paramInt == this.g))
      {
        if (paramInt % 90 != this.f % 90) {
          this.jdField_d_of_type_Int = 0;
        }
        this.f = paramInt;
        this.g = paramInt;
        int i;
        if (paramBoolean)
        {
          i = this.jdField_a_of_type_AndroidViewDisplay.getRotation();
          CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(true);
          i = (i * 90 + paramInt) % 360;
          switch (paramInt)
          {
          }
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().D != 2) {
            break label356;
          }
          if (this.i != 0)
          {
            paramBoolean = bool;
            if (this.i != 180) {}
          }
          else
          {
            paramBoolean = true;
          }
          a(paramBoolean);
          return;
          CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(false);
          i = paramInt;
          break;
          paramInt = 0;
          while (paramInt < super.j())
          {
            super.a(paramInt).a(i);
            paramInt += 1;
          }
          m(i);
          this.i = i;
          continue;
          paramInt = 0;
          while (paramInt < super.j())
          {
            super.a(paramInt).a(i);
            paramInt += 1;
          }
          m(i);
          this.i = i;
          continue;
          paramInt = 0;
          while (paramInt < super.j())
          {
            super.a(paramInt).a(i);
            paramInt += 1;
          }
          m(i);
          this.i = i;
          continue;
          paramInt = 0;
          while (paramInt < super.j())
          {
            super.a(paramInt).a(i);
            paramInt += 1;
          }
          m(i);
          this.i = i;
        }
      }
    }
  }
  
  void a(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      t();
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(RecvMsg paramRecvMsg)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1011) {}
    String str2;
    do
    {
      return;
      String str1 = paramRecvMsg.c();
      str2 = paramRecvMsg.a();
      String str3 = paramRecvMsg.b();
      String str4 = paramRecvMsg.d();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onReceiveMsg friendUin: " + str1 + ", senderUin: " + str2 + ", senderName: " + str3 + ", msg: " + str4);
      }
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout != null))
      {
        this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setVisibility(4);
        return;
      }
      if ((i()) && (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout != null)) {
        this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setVisibility(4);
      }
    } while (str2.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()));
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      t();
    }
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.isShown())
    {
      if (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getTag()).longValue() >= 3000L)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
        b(paramRecvMsg);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 3000L);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 3000L);
        return;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramRecvMsg);
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    b(paramRecvMsg);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 3000L);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 3000L);
  }
  
  void a(GLVideoView paramGLVideoView, String paramString, int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramGLVideoView != null)
    {
      str = a(paramString, paramInt);
      paramGLVideoView.a(paramString, paramInt);
      paramGLVideoView.g(0);
      paramGLVideoView.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    }
    try
    {
      GraphicRenderMgr.getInstance().setAccountUin(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      GraphicRenderMgr.getInstance().setGlRender(str, paramGLVideoView.a());
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[initGLVideoViewBasePara], key[" + str + "], " + paramGLVideoView.b());
      this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int, false, paramBoolean);
      return;
    }
    catch (UnsatisfiedLinkError paramGLVideoView)
    {
      paramGLVideoView.printStackTrace();
    }
  }
  
  void a(Boolean paramBoolean)
  {
    Object localObject1 = null;
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
    Object localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i = a("openSelfVideo", (String)localObject2, 1);
    if (i < 0)
    {
      int i1 = a(0);
      if (i1 >= 0)
      {
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
        a((GLVideoView)localObject1, (String)localObject2, 1, false);
      }
      i = i1;
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        i = i1;
        localObject2 = localObject1;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4) {}
      }
    }
    for (;;)
    {
      if (localObject2 != null)
      {
        if (CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).c()) {
          ((GLVideoView)localObject2).d(CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a());
        }
        ((GLVideoView)localObject2).c(false);
        ((GLVideoView)localObject2).g(false);
        ((GLVideoView)localObject2).i(true);
        ((GLVideoView)localObject2).g(0);
        ((GLVideoView)localObject2).a(ImageView.ScaleType.CENTER_CROP);
      }
      if ((paramBoolean.booleanValue()) && (i > 0) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().e))) {
        a(0, i);
      }
      return;
      localObject1 = a((String)localObject2, 1);
      localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      GraphicRenderMgr.getInstance().setGlRender((String)localObject1, ((GLVideoView)localObject2).a());
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[openSelfVideo], key[" + (String)localObject1 + "], index[" + i + "], forceToBigView[" + paramBoolean + "], " + ((GLVideoView)localObject2).b());
    }
  }
  
  public void a(Integer paramInteger, Object paramObject)
  {
    AVLog.c(this.jdField_a_of_type_JavaLangString, "notifyEvent :" + paramInteger + "|" + paramObject);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject });
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvUiScreenLayout.a() != 2)
    {
      String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      a("switchLocalView_" + paramString, str);
    }
  }
  
  void a(String paramString, int paramInt)
  {
    int i = a("closePeerVideo", paramString, paramInt);
    if (i >= 0)
    {
      paramString = a(paramString, paramInt);
      GraphicRenderMgr localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      localGraphicRenderMgr.flushGlRender(paramString);
      localGraphicRenderMgr.setGlRender(paramString, null);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[closePeerVideo], key[" + paramString + "], index[" + i + "]");
      this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int, true, true);
      c("closePeerVideo", i);
    }
  }
  
  public void a(String paramString, int paramInt, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 1;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i = a("setBackground", paramString, paramInt);
    int i1 = i;
    boolean bool;
    if (i < 0)
    {
      i = a(0);
      if (i >= 0)
      {
        if (!paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
        {
          bool = true;
          label60:
          a(this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i], paramString, paramInt, bool);
        }
      }
      else
      {
        if ((!paramBoolean2) || (i <= 0)) {
          break label245;
        }
        a(0, i);
        i = 0;
      }
    }
    label245:
    for (;;)
    {
      i1 = i;
      if (i > 0) {}
      for (i1 = i2;; i1 = i2)
      {
        if (i >= 0)
        {
          GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
          localGLVideoView.b(paramBitmap);
          localGLVideoView.i(paramBoolean1);
          if (!paramBoolean1) {
            localGLVideoView.g(false);
          }
        }
        if (i1 != 0) {
          f(i);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setBackground uin: " + paramString + ", videoSrcType: " + paramInt + ", index: " + i + ", needRenderVideo: " + paramBoolean1);
        return;
        bool = false;
        break label60;
        i2 = 0;
        i = i1;
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, float paramFloat, int paramInt2)
  {
    boolean bool = false;
    int i = a("setText", paramString1, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setText uin: " + paramString1 + ", videoSrcType: " + paramInt1 + ", text: " + paramString2 + ", textSize: " + paramFloat + ", textColor: " + paramInt2 + ", index: " + i);
    }
    if (i >= 0)
    {
      paramString1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      paramString1.g(0);
      paramString1.b(paramString2);
      paramString1.a(paramFloat);
      paramString1.c(paramInt2);
      if (i != 0) {
        bool = true;
      }
      paramString1.e(bool);
      if (i != 0) {
        break label184;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2) {
        paramString1.b("");
      }
    }
    else
    {
      return;
    }
    paramString1.b(12);
    return;
    label184:
    paramString1.b(2147483647);
  }
  
  void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = true;
    Object localObject = null;
    int i = a("openPeerVideo", paramString, paramInt);
    if (a(this.jdField_a_of_type_ComTencentAvVideoController.a())) {
      if ((paramBoolean1) || (e())) {
        break label461;
      }
    }
    label186:
    label461:
    for (boolean bool1 = true;; bool1 = paramBoolean1)
    {
      if (i > 1)
      {
        SmallScreenUtils.a();
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "SetGlRender index break!!!!!! index=" + i + ", remotehasvideo=" + this.jdField_a_of_type_ComTencentAvVideoController.a().g);
        return;
        bool1 = paramBoolean1;
      }
      String str = a(paramString, paramInt);
      int i1;
      if (i < 0)
      {
        i = a(0);
        if (i >= 0)
        {
          localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
          a((GLVideoView)localObject, paramString, paramInt, true);
        }
        paramInt = i;
        paramString = (String)localObject;
        if (i <= 1) {
          break label411;
        }
        paramInt = i;
        paramString = (String)localObject;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4) {
          break label411;
        }
        i1 = 1;
        paramInt = i;
        if (localObject != null)
        {
          ((GLVideoView)localObject).c(paramBoolean2);
          ((GLVideoView)localObject).d(this.jdField_a_of_type_ComTencentAvUiScreenLayout.b());
          if (paramBoolean1) {
            break label420;
          }
          paramBoolean1 = bool2;
          label217:
          ((GLVideoView)localObject).g(paramBoolean1);
          ((GLVideoView)localObject).g(0);
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4) {
            break label436;
          }
          if (paramInt != 0) {
            break label425;
          }
          ((GLVideoView)localObject).a(ImageView.ScaleType.CENTER_INSIDE);
        }
      }
      for (;;)
      {
        if ((bool1) && (paramInt > 0) && (!b()) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().e))) {
          a(0, paramInt);
        }
        if (i1 == 0) {
          break;
        }
        f(paramInt);
        return;
        paramString = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
        GraphicRenderMgr.getInstance().setGlRender(str, paramString.a());
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[openPeerVideo], key[" + str + "], index[" + i + "], " + paramString.b());
        this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int, false, true);
        paramInt = i;
        i1 = 0;
        localObject = paramString;
        break label186;
        paramBoolean1 = false;
        break label217;
        ((GLVideoView)localObject).a(ImageView.ScaleType.CENTER_CROP);
        continue;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) {
          ((GLVideoView)localObject).a(ImageView.ScaleType.CENTER_INSIDE);
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setRemoteHasVideo uin: " + paramString + ", videoSrcType: " + paramInt + ", isRemoteHasVideo: " + paramBoolean1 + ", forceToBigView: " + paramBoolean2 + ", mIsLocalHasVideo: " + this.jdField_a_of_type_Boolean + ", isPC: " + paramBoolean3);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) || (!a())) {}
    for (;;)
    {
      return;
      h();
      if (paramBoolean1) {
        a(paramString, paramInt, paramBoolean2, paramBoolean3);
      }
      while ((this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy != null) && (!c()))
      {
        h(paramBoolean1);
        return;
        a(paramString, paramInt);
      }
    }
  }
  
  protected void a(Observable paramObservable, Object paramObject)
  {
    boolean bool = true;
    paramObservable = (Object[])paramObject;
    int i = ((Integer)paramObservable[0]).intValue();
    switch (i)
    {
    default: 
      return;
    case 6005: 
      k();
      paramObservable = (String)paramObservable[1];
      if (ARZimuUtil.a(paramObservable))
      {
        bool = GPNativeSoLoader.a();
        if (!bool) {
          break label449;
        }
        bool = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.b(paramObservable, (ViewGroup)this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      }
      break;
    }
    label449:
    while ((bool) && ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)))
    {
      ((AVActivity)this.jdField_a_of_type_AndroidContentContext).m();
      return;
      if ((!this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a(paramObservable, (ViewGroup)this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int)) || (!(this.jdField_a_of_type_AndroidContentContext instanceof AVActivity))) {
        break;
      }
      ((AVActivity)this.jdField_a_of_type_AndroidContentContext).m();
      return;
      if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0)) {
        break;
      }
      k();
      if (i == 6006) {}
      while ((this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a((ViewGroup)this.jdField_a_of_type_AndroidViewView, bool)) && ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)))
      {
        ((AVActivity)this.jdField_a_of_type_AndroidContentContext).m();
        return;
        bool = false;
      }
      k();
      paramObservable = (SentenceInfo)paramObservable[1];
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a(paramObservable);
      return;
      k();
      n(((Integer)paramObservable[1]).intValue());
      return;
      if ((this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy == null) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0))) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a((ViewGroup)this.jdField_a_of_type_AndroidViewView);
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)) {
        break;
      }
      ((AVActivity)this.jdField_a_of_type_AndroidContentContext).m();
      return;
      if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy != null)
      {
        this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.b();
        return;
      }
      ARZimuUtil.a(false);
      return;
      if ((this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0)))
      {
        this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a(true);
        return;
      }
      ARZimuUtil.a(true);
      return;
      a(true);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = super.g();
    int i1 = super.h();
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (a(localSessionInfo))
    {
      if ((i()) && (this.h == 4)) {
        this.h = 3;
      }
      ScreenLayout localScreenLayout = this.jdField_a_of_type_ComTencentAvUiScreenLayout;
      GLVideoView[] arrayOfGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
      int i2 = this.h;
      int i3 = this.jdField_b_of_type_Int;
      int i4 = this.jdField_c_of_type_Int;
      if (!localSessionInfo.jdField_a_of_type_Boolean)
      {
        paramBoolean = true;
        localScreenLayout.a(arrayOfGLVideoView, i, i1, i2, i3, i4, paramBoolean);
        ARZimuTask.c(i1, i);
      }
    }
    for (;;)
    {
      super.v();
      return;
      paramBoolean = false;
      break;
      if (b(localSessionInfo))
      {
        this.jdField_a_of_type_ComTencentAvUiScreenLayout.a(localSessionInfo, this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView, i, i1, paramBoolean, this.i, this.jdField_c_of_type_Int);
        a(Integer.valueOf(6502), null);
      }
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  boolean a()
  {
    return (VcSystemInfo.b()) && (Utils.a(this.jdField_a_of_type_AndroidContentContext) == 2);
  }
  
  protected boolean a(int paramInt1, int paramInt2)
  {
    String str1;
    if (QLog.isColorLevel())
    {
      str1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a();
      String str2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a();
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "switchVideo, begin, [" + paramInt1 + "]=[" + str1 + "], [" + paramInt2 + "]=[" + str2 + "]");
    }
    if ((paramInt1 == paramInt2) || (paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length) || (paramInt2 < 0) || (paramInt2 >= this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "switchVideo index invalid!");
      }
      return false;
    }
    if (paramInt2 == 0)
    {
      a(paramInt1, paramInt2);
      return true;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
    {
      if (paramInt1 != 0) {
        break label237;
      }
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_INSIDE);
    }
    for (;;)
    {
      str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a();
      if (str1.equals(this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a())) {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      }
      return b(paramInt1, paramInt2);
      label237:
      if (paramInt2 == 0) {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      }
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return a("hasVideoView", paramString, paramInt) >= 0;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool = false;
    int i = a("setVideoToBigView", paramString2, 1);
    if (i > 0) {
      bool = a(0, i);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "setVideoToBigView[" + paramString1 + "], uin[" + paramString2 + "], index[" + i + "], bRet[" + bool + "]");
    }
    return bool;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!a()) {
      return false;
    }
    if (paramBoolean1) {
      a(Boolean.valueOf(paramBoolean2));
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = paramBoolean1;
      if ((this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy != null) && (!f())) {
        h(paramBoolean1);
      }
      return true;
      h();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAvUiQQLogo = ((QQLogo)this.jdField_a_of_type_AndroidViewView.findViewById(2131366261));
    this.jdField_a_of_type_ComTencentAvUiQQLogo.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvUiQQLogo.setImageBitmap(null);
  }
  
  public void b(int paramInt)
  {
    int i = 0;
    super.b(paramInt);
    if (this.jdField_a_of_type_ComTencentAvUiScreenLayout.a() != paramInt)
    {
      this.jdField_a_of_type_ComTencentAvUiScreenLayout = ScreenLayout.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, false);
      if (d())
      {
        super.b(null);
        super.i(-14737890);
        a(Integer.valueOf(6502), null);
      }
      for (;;)
      {
        a(true);
        paramInt = i;
        while (paramInt < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
        {
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt].b(this.jdField_a_of_type_ComTencentAvUiScreenLayout.b());
          a(this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt]);
          paramInt += 1;
        }
        r();
        a(Integer.valueOf(6501), null);
      }
      if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)) {
        ((AVActivity)this.jdField_a_of_type_AndroidContentContext).m();
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366262);
    if (paramBoolean)
    {
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  boolean b()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity))
    {
      boolean bool3 = ((AVActivity)this.jdField_a_of_type_AndroidContentContext).a();
      boolean bool1;
      if (!e())
      {
        bool1 = true;
        if ((!bool3) || (!bool1)) {
          break label84;
        }
      }
      label84:
      for (boolean bool2 = true;; bool2 = false)
      {
        AVLog.c(this.jdField_a_of_type_JavaLangString, "SwitchLocalToBigView:" + bool3 + "|" + bool1);
        return bool2;
        bool1 = false;
        break;
      }
    }
    return false;
  }
  
  protected void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiScreenLayout.a(this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView, paramInt, g(), h(), this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onCameraSwitched isFrontCamera: " + paramBoolean);
    }
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i = a("onCameraSwitched", str, 1);
    if (i >= 0)
    {
      str = str + "_" + 1;
      GraphicRenderMgr localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      localGraphicRenderMgr.clearCameraFrames();
      localGraphicRenderMgr.flushGlRender(str);
      this.jdField_a_of_type_ComTencentAvVideoController.a(true);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].k(false);
      this.jdField_a_of_type_ComTencentAvVideoController.a(new keb(this, i, paramBoolean));
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().i != 3000) {
        break label285;
      }
      if (!paramBoolean) {
        break label249;
      }
      ReportController.b(null, "CliOper", "", "", "0X80041B5", "0X80041B5", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().G)
      {
        if (!paramBoolean) {
          break;
        }
        ReportController.b(null, "CliOper", "", "", "0X8005211", "0X8005211", 0, 0, "", "", "", "");
      }
      return;
      label249:
      ReportController.b(null, "CliOper", "", "", "0X80041B4", "0X80041B4", 0, 0, "", "", "", "");
      continue;
      label285:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1) {
        if (paramBoolean)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10) {
            ReportController.b(null, "CliOper", "", "", "0X800593B", "0X800593B", 0, 0, "", "", "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", "0X80046E2", "0X80046E2", 0, 0, "", "", "", "");
          }
        }
        else if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10) {
          ReportController.b(null, "CliOper", "", "", "0X800593A", "0X800593A", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80046E1", "0X80046E1", 0, 0, "", "", "", "");
        }
      }
    }
    ReportController.b(null, "CliOper", "", "", "0X8005210", "0X8005210", 0, 0, "", "", "", "");
  }
  
  boolean c()
  {
    boolean bool2 = false;
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
        if ((localGLVideoView.f() == 0) && (str.equals(localGLVideoView.a()))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    return (this.jdField_a_of_type_Keh != null) && (this.jdField_a_of_type_Keh.dispatchHoverEvent(paramMotionEvent));
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      t();
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(paramInt);
      if (paramInt == 1) {
        this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      t();
    }
    TextView localTextView;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void e(int paramInt)
  {
    this.n = paramInt;
  }
  
  void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      t();
    }
    if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null)) {}
    while (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845702);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#5f656f"));
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845703);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.onResume();
    }
  }
  
  void f(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation = null;
      a(false);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation = new VideoLayerUI.MultiVideoOpenAnimation(this, paramInt);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation);
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation);
    super.g();
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_d_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentAvOpenglUiGLView$OnTouchListener = null;
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
    this.jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector = null;
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = null;
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation = null;
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy != null)
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity))
      {
        AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_AndroidContentContext;
        this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.b(localAVActivity.e);
      }
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy = null;
    }
  }
  
  void h()
  {
    ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 8, null, false);
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i = a("closeSelfVideo", str, 1);
    if (i >= 0)
    {
      str = a(str, 1);
      GraphicRenderMgr localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      localGraphicRenderMgr.flushGlRender(str);
      localGraphicRenderMgr.clearCameraFrames();
      localGraphicRenderMgr.setGlRender(str, null);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[closeSelfVideo], key[" + str + "], index[" + i + "]");
      this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int, true, false);
      c("closeSelfVideo", i);
    }
  }
  
  protected void i()
  {
    this.jdField_c_of_type_Boolean = false;
    m(this.i);
  }
  
  void j()
  {
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0)) && (i == 2))
    {
      k();
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a();
    }
  }
  
  void k()
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy == null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy = new ZimuViewProxy(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  public void q_()
  {
    super.q_();
    m(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI
 * JD-Core Version:    0.7.0.1
 */