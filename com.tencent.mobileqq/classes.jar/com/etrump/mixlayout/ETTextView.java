package com.etrump.mixlayout;

import aciy;
import adnv;
import adrh;
import ajia;
import almt;
import alok;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import axku;
import b;
import bape;
import bapf;
import bbgb;
import c;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import f;
import fh;
import fn;
import fo;
import fp;
import fq;
import fr;
import fs;
import ft;
import fv;
import fz;
import g;
import gc;
import ge;
import gh;
import j;
import java.util.concurrent.atomic.AtomicBoolean;
import k;
import l;
import s;

public class ETTextView
  extends AnimationTextView
{
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public static Handler a;
  private static Handler jdField_b_of_type_AndroidOsHandler;
  public static boolean f;
  private static boolean jdField_i_of_type_Boolean;
  public int a;
  public long a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private ETDecoration jdField_a_of_type_ComEtrumpMixlayoutETDecoration;
  public ETFont a;
  public SessionInfo a;
  public ChatMessage a;
  public fh a;
  private fn jdField_a_of_type_Fn;
  private final fo jdField_a_of_type_Fo = new fo(this, null);
  private fr jdField_a_of_type_Fr;
  public fs a;
  private ge jdField_a_of_type_Ge;
  public j a;
  Runnable jdField_a_of_type_JavaLangRunnable = new ETTextView.1(this);
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[4];
  public int b;
  private MotionEvent jdField_b_of_type_AndroidViewMotionEvent;
  public boolean b;
  private float c;
  public int c;
  public boolean c;
  private float jdField_d_of_type_Float;
  int jdField_d_of_type_Int = -1;
  public boolean d;
  private float jdField_e_of_type_Float;
  int jdField_e_of_type_Int = -1;
  public boolean e;
  private int f;
  private int g;
  private int h;
  private int jdField_i_of_type_Int;
  private boolean j = true;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  
  static
  {
    jdField_f_of_type_Boolean = true;
  }
  
  public ETTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 2147483647;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    i();
    a();
  }
  
  public ETTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 2147483647;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    i();
    a();
  }
  
  public ETTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 2147483647;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    i();
    a();
  }
  
  private void a(ETFont paramETFont, long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Long != paramLong) {
      this.k = false;
    }
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(paramETFont.mFontId, paramETFont.mFontPath, getTextSize(), paramETFont.mFontType, paramETFont.mTypeface);
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.copy(paramETFont);
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setSize(getTextSize());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_comboIndex = paramInt;
      if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontType != 1) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mTypeface != null)) {
        setTypeface(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mTypeface);
      }
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId == 0) {
        setTypeface(null);
      }
      this.jdField_a_of_type_Long = paramLong;
      if (this.jdField_a_of_type_Fh == null) {
        this.jdField_a_of_type_Fh = new fh();
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setColor(getCurrentTextColor());
      if (this.jdField_a_of_type_Fr != null) {
        this.jdField_a_of_type_Fr.a(this);
      }
      return;
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.copy(paramETFont);
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId = paramLong;
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mText = paramETFont.mText;
      if (paramETFont.mFontType != 1) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mTypeface = paramETFont.mTypeface;
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_diyHandle = paramETFont.m_diyHandle;
    }
  }
  
  private void a(Class<? extends j> paramClass)
  {
    if ((this.jdField_a_of_type_J == null) || (this.jdField_a_of_type_J.getClass() != paramClass))
    {
      if (paramClass == l.class) {
        this.jdField_a_of_type_J = new l(this, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
      }
    }
    else {
      return;
    }
    if (paramClass == s.class)
    {
      this.jdField_a_of_type_J = new s(this, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
      return;
    }
    if (paramClass == b.class)
    {
      this.jdField_a_of_type_J = new b(this, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
      return;
    }
    if (paramClass == c.class)
    {
      this.jdField_a_of_type_J = new c(this, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
      return;
    }
    throw new RuntimeException("Unkown class: " + paramClass.getName());
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    almt localalmt;
    Object localObject;
    Resources localResources;
    boolean bool;
    if (this.jdField_a_of_type_Fh.a(paramInt1, paramInt2) != null)
    {
      localalmt = (almt)getTag(2131298155);
      localObject = (ChatMessage)getTag(2131298595);
      localResources = getResources();
      bool = false;
      if (localObject != null) {
        bool = ((ChatMessage)localObject).isSend();
      }
      localObject = getBackground();
      if ((localObject == null) || (!(localObject instanceof alok))) {
        break label82;
      }
      ((alok)localObject).jdField_a_of_type_Boolean = true;
    }
    label82:
    while ((localObject == null) || (localalmt == null)) {
      return;
    }
    if (bool) {}
    for (paramInt1 = 2130848702;; paramInt1 = 2130848509)
    {
      localalmt.a(this, localResources.getDrawable(paramInt1));
      return;
    }
  }
  
  public static void e()
  {
    if (jdField_b_of_type_AndroidOsHandler != null) {
      jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (jdField_a_of_type_AndroidOsHandler != null)
    {
      jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
  }
  
  private static void i()
  {
    Object localObject;
    if (jdField_a_of_type_AndroidOsHandler == null)
    {
      jdField_b_of_type_AndroidOsHandler = new ft(null);
      if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
        break label76;
      }
      localObject = (fv)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(42);
      if ((localObject != null) && (((fv)localObject).a != null)) {
        jdField_a_of_type_AndroidOsHandler = new fp(((fv)localObject).a.getLooper());
      }
    }
    label76:
    do
    {
      do
      {
        return;
      } while (!(BaseApplicationImpl.getApplication().getRuntime() instanceof ToolAppRuntime));
      localObject = fz.a();
    } while (localObject == null);
    jdField_a_of_type_AndroidOsHandler = new fp(((fz)localObject).a.getLooper());
  }
  
  private boolean i()
  {
    if (this.jdField_a_of_type_Fh == null) {}
    while ((this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration == null) || (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.getFrameNum() <= 0)) {
      return false;
    }
    return true;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i1 = -1;
    if (f()) {
      if ((this.jdField_a_of_type_J instanceof k))
      {
        paramInt1 = ((k)this.jdField_a_of_type_J).a(paramInt1, paramInt2);
        i1 = a().b(paramInt1);
      }
    }
    do
    {
      return i1;
      if (!d()) {
        break;
      }
    } while (this.jdField_a_of_type_Fn == null);
    paramInt1 = this.jdField_a_of_type_Fn.a(paramInt1, paramInt2);
    return a().b(paramInt1);
    return super.a(paramInt1, paramInt2);
  }
  
  public fh a()
  {
    return this.jdField_a_of_type_Fh;
  }
  
  public ge a()
  {
    if (this.jdField_a_of_type_Ge == null) {
      this.jdField_a_of_type_Ge = new ge(getText());
    }
    return this.jdField_a_of_type_Ge;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  }
  
  public void a(int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    if (f()) {
      if ((this.jdField_a_of_type_J instanceof k))
      {
        paramInt = a().a(paramInt);
        ((k)this.jdField_a_of_type_J).a(paramInt, paramArrayOfInt, paramBoolean);
      }
    }
    do
    {
      return;
      if (!d()) {
        break;
      }
    } while (this.jdField_a_of_type_Fn == null);
    paramInt = a().a(paramInt);
    this.jdField_a_of_type_Fn.a(paramInt, paramArrayOfInt, paramBoolean);
    return;
    super.a(paramInt, paramArrayOfInt, paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (d()) {
      b(paramBoolean1, paramBoolean2);
    }
    while (!c()) {
      return;
    }
    c(paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId == 9999) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath)) && (gh.jdField_a_of_type_Int == 4);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_J != null) {
      this.jdField_a_of_type_J.b();
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.m = false;
    if ((!i()) || (!g()) || (this.jdField_c_of_type_Boolean)) {
      return;
    }
    if ((jdField_f_of_type_Boolean) && (!this.m)) {}
    for (boolean bool = true;; bool = false)
    {
      this.n = bool;
      if ((!this.n) || (this.o) || ((paramBoolean2) && (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.isLastFrame()))) {
        break;
      }
      this.o = true;
      this.jdField_d_of_type_Boolean = false;
      jdField_b_of_type_AndroidOsHandler.obtainMessage(0, fq.a(this)).sendToTarget();
      if ((paramBoolean2) || (this.jdField_a_of_type_Fs == null)) {
        break;
      }
      this.jdField_a_of_type_Fs.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramBoolean1, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId);
      return;
    }
  }
  
  public boolean b()
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (((this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId != 0) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontType == 1)) || (a())) {
      if (ETEngine.getInstance().native_containComplexScript(getText().toString())) {
        break label61;
      }
    }
    label61:
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_J != null) {
      this.jdField_a_of_type_J.f();
    }
  }
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.m = false;
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) || (!g())) {}
    int i1;
    int i2;
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
                    break;
                  }
                  localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                  if (localObject == null) {
                    break;
                  }
                  localObject = (fv)((QQAppInterface)localObject).getManager(42);
                } while ((localObject != null) && (!((fv)localObject).b()));
                if ((!jdField_f_of_type_Boolean) || (this.m)) {
                  break;
                }
              } while ((this.jdField_a_of_type_J == null) || ((!this.jdField_d_of_type_Boolean) && (!paramBoolean1) && (!paramBoolean2)));
              i1 = this.jdField_a_of_type_J.jdField_e_of_type_Int;
              localObject = this.jdField_a_of_type_J.i;
            } while (localObject == null);
            i2 = localObject[0];
          } while ((paramBoolean2) && (i1 == 0));
          if (i1 == 0) {
            b();
          }
          for (this.jdField_e_of_type_Boolean = true;; this.jdField_e_of_type_Boolean = true)
          {
            do
            {
              this.jdField_d_of_type_Boolean = false;
              if ((paramBoolean2) || (this.jdField_a_of_type_Fs == null)) {
                break;
              }
              this.jdField_a_of_type_Fs.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramBoolean1, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId);
              return;
            } while ((i1 <= 0) || (i1 >= i2));
            d();
          }
        } while (this.jdField_a_of_type_J == null);
        i1 = this.jdField_a_of_type_J.jdField_e_of_type_Int;
        localObject = this.jdField_a_of_type_J.i;
      } while (localObject == null);
      i2 = localObject[0];
    } while ((i1 <= 0) || (i1 >= i2));
    c();
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId != 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontType == 4)
        {
          int i1 = f.b(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId);
          if ((i1 != 3) && (i1 != 7))
          {
            bool1 = bool2;
            if (i1 != 8) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_J != null) {
      this.jdField_a_of_type_J.g();
    }
  }
  
  public boolean d()
  {
    return (b()) && (this.jdField_a_of_type_Fh != null) && (this.jdField_a_of_type_Fh.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
  }
  
  public boolean e()
  {
    return this.j;
  }
  
  public void f()
  {
    if (f()) {
      if ((this.jdField_a_of_type_J instanceof k))
      {
        i1 = a().a(c());
        i2 = a().a(d());
        ((k)this.jdField_a_of_type_J).a(i1, i2);
      }
    }
    do
    {
      return;
      if (!d()) {
        break;
      }
    } while (this.jdField_a_of_type_Fn == null);
    int i1 = a().a(c());
    int i2 = a().a(d() - 1);
    this.jdField_a_of_type_Fn.a(i1, i2);
    return;
    super.f();
  }
  
  public boolean f()
  {
    if (!this.k)
    {
      this.l = axku.b(getText().toString());
      this.k = true;
    }
    return (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId != 0) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontType == 4) && (!this.l);
  }
  
  public void g()
  {
    if (f()) {
      if ((this.jdField_a_of_type_J instanceof k)) {
        ((k)this.jdField_a_of_type_J).d();
      }
    }
    do
    {
      return;
      if (!d()) {
        break;
      }
    } while (this.jdField_a_of_type_Fn == null);
    this.jdField_a_of_type_Fn.a();
    return;
    super.g();
  }
  
  public boolean g()
  {
    if ((getContext() instanceof FragmentActivity))
    {
      Object localObject1 = ((FragmentActivity)getContext()).getChatFragment();
      if ((localObject1 != null) && (((ChatFragment)localObject1).a() != null) && (((ChatFragment)localObject1).a().a != null))
      {
        localObject1 = ((ChatFragment)localObject1).a().a;
        localObject1 = aciy.a((ListView)localObject1, aciy.a(this.jdField_a_of_type_Long, ((XListView)localObject1).getAdapter()));
        Object localObject2;
        if ((localObject1 != null) && ((((View)localObject1).getTag() instanceof adrh)))
        {
          localObject2 = (adrh)((View)localObject1).getTag();
          if ((((adrh)localObject2).d == null) || (((adrh)localObject2).d.getTop() + ((View)localObject1).getBottom() < getContext().getResources().getDimensionPixelSize(2131167766))) {}
        }
        else
        {
          do
          {
            return true;
            if ((localObject1 == null) || (!(aciy.a((View)localObject1) instanceof adnv))) {
              break;
            }
            localObject2 = (adnv)aciy.a((View)localObject1);
          } while (((View)localObject1).getTop() + ((View)localObject1).getBottom() >= getContext().getResources().getDimensionPixelSize(2131167766));
        }
      }
    }
    if (((getContext() instanceof QQBrowserActivity)) || ((getContext() instanceof PublicFragmentActivity))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void h()
  {
    this.m = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_J != null) {
      this.jdField_a_of_type_J.e();
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (TextUtils.isEmpty(getText()))
    {
      super.onDraw(paramCanvas);
      return;
    }
    if ((!d()) && (!f()))
    {
      if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId != 0))
      {
        if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontType != 1) || (!ETEngine.getInstance().native_isColorVariantFont(this.jdField_a_of_type_ComEtrumpMixlayoutETFont))) {
          break label124;
        }
        setTextColor(ETEngine.getInstance().native_getTextColor(this.jdField_a_of_type_ComEtrumpMixlayoutETFont));
      }
      for (;;)
      {
        try
        {
          super.onDraw(paramCanvas);
          return;
        }
        catch (Exception paramCanvas)
        {
          QLog.e("ETTextView", 1, "onDraw failed of:" + getText(), paramCanvas);
          return;
        }
        label124:
        if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontType == 4)
        {
          ??? = this.jdField_a_of_type_ArrayOfInt;
          if (g.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_comboIndex, (int[])???) == 1) {
            setTextColor(Color.argb(???[3], ???[0], ???[1], ???[2]));
          }
        }
      }
    }
    long l1;
    int i2;
    int i1;
    if (d())
    {
      l1 = System.currentTimeMillis();
      if (this.jdField_d_of_type_Boolean) {
        b(false, false);
      }
      if (this.jdField_a_of_type_Fn != null)
      {
        ??? = this.jdField_a_of_type_Fn.a();
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(b());
        if (??? != null)
        {
          i2 = ((SparseArray)???).size();
          i1 = 0;
          while (i1 < i2)
          {
            paramCanvas.drawRect((Rect)((SparseArray)???).valueAt(i1), this.jdField_a_of_type_AndroidGraphicsPaint);
            i1 += 1;
          }
        }
      }
      this.jdField_a_of_type_Fh.jdField_a_of_type_ComEtrumpMixlayoutETFont.setColor(getCurrentTextColor());
    }
    for (;;)
    {
      long l2;
      synchronized (this.jdField_a_of_type_Fo)
      {
        Object localObject2 = this.jdField_a_of_type_Fo.a();
        int i4;
        int i3;
        if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
        {
          i4 = getPaddingLeft();
          i3 = getPaddingTop();
          if ((this.o) && (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration != null))
          {
            paramCanvas.drawBitmap((Bitmap)localObject2, i4, i3, null);
            i2 = i3;
            i1 = i4;
            if (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.getDecorationType() == 1)
            {
              this.jdField_a_of_type_Fh.a(paramCanvas, i4, i3);
              i1 = i4;
              i2 = i3;
            }
            this.jdField_a_of_type_Fh.b(paramCanvas, i1, i2);
          }
        }
        else
        {
          l2 = System.currentTimeMillis();
          gc.a("action_draw", this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontType, getText().length(), l2 - l1);
          return;
        }
        ETEngine localETEngine = ETEngine.getInstance();
        if ((this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration == null) || (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.isLastFrame())) {
          break label678;
        }
        bool = true;
        ((Bitmap)localObject2).eraseColor(0);
        this.jdField_a_of_type_Fh.a(localETEngine, (Bitmap)localObject2, this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration, bool);
        this.jdField_a_of_type_Fh.a(paramCanvas, i4, i3, (Bitmap)localObject2);
        i2 = i3;
        i1 = i4;
        if (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration != null)
        {
          localObject2 = this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.mMargins;
          i2 = i3;
          i1 = i4;
          if (localObject2 != null)
          {
            i1 = i4 + ((Rect)localObject2).left;
            i2 = i3 + ((Rect)localObject2).top;
          }
        }
        this.jdField_a_of_type_Fh.a(paramCanvas, i1, i2);
      }
      if (!f()) {
        break;
      }
      l1 = System.currentTimeMillis();
      if ((this.jdField_a_of_type_J != null) && (!this.jdField_a_of_type_J.a(paramCanvas))) {
        super.onDraw(paramCanvas);
      }
      while (c())
      {
        c(false, false);
        return;
        l2 = System.currentTimeMillis();
        gc.a("action_draw", this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, 4, getText().length(), l2 - l1);
      }
      break;
      label678:
      boolean bool = false;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(getText()))
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i1;
    int i2;
    for (;;)
    {
      try
      {
        if (!f()) {
          break label368;
        }
        i1 = f.b(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId);
        i2 = f.c(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId);
        if (i1 != 8) {
          break label336;
        }
        if ((i2 == 1) || (i2 == 2))
        {
          a(s.class);
          if (QLog.isColorLevel()) {
            QLog.d("ETTextView", 2, "createFounderLayout: " + this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId + "," + i1 + "," + i2 + "," + this.jdField_a_of_type_J);
          }
          int[] arrayOfInt = this.jdField_a_of_type_J.a(paramInt1, paramInt2, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
          if ((arrayOfInt == null) || (arrayOfInt[0] <= 0) || (arrayOfInt[1] <= 0)) {
            break;
          }
          setMeasuredDimension(arrayOfInt[0], arrayOfInt[1]);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ETTextView", 1, "measure fail ", localThrowable);
        localThrowable.printStackTrace();
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId = 0;
        this.jdField_a_of_type_Fh.jdField_a_of_type_Long = -1L;
        if ((!jdField_i_of_type_Boolean) && (localThrowable.getMessage().contains("textlayout")))
        {
          bapf.a(null, "individual_v2_font_measure_error", "font_measure_error", localThrowable.getMessage(), localThrowable.getMessage(), 0.0F);
          bape.a("individual_v2_font_measure_error", "font_measure_error");
          jdField_i_of_type_Boolean = true;
        }
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
      if ((i2 == 3) || (i2 == 4) || (i2 == 5))
      {
        a(c.class);
      }
      else
      {
        a(l.class);
        continue;
        label336:
        if (i1 == 7) {
          a(b.class);
        } else {
          a(l.class);
        }
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    return;
    label368:
    if (!b())
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i6 = View.MeasureSpec.getMode(paramInt1);
    int i5 = View.MeasureSpec.getMode(paramInt2);
    int i4 = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    boolean bool1;
    Object localObject1;
    if ((this.jdField_a_of_type_Fh == null) || (this.jdField_a_of_type_Fh.jdField_a_of_type_Long != this.jdField_a_of_type_Long) || ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (!this.jdField_a_of_type_ComEtrumpMixlayoutETFont.equals(this.jdField_a_of_type_Fh.jdField_a_of_type_ComEtrumpMixlayoutETFont))) || (!this.j) || (this.jdField_a_of_type_Fh.jdField_b_of_type_Boolean != this.jdField_a_of_type_Boolean))
    {
      this.o = false;
      this.jdField_a_of_type_Fh = new fh();
      this.jdField_a_of_type_Fn = new fn(this, this.jdField_a_of_type_Fh);
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration != null)
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.deleteDescriptor();
        this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration = null;
      }
      int i7 = getLinkTextColors().getDefaultColor();
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null)
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setColor(getCurrentTextColor());
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setSize(getTextSize());
        if ((getPaint().getFlags() & 0x20) <= 0) {
          break label1399;
        }
        bool1 = true;
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setBold(bool1);
        if (this.jdField_c_of_type_Float <= 0.0F) {
          break label1007;
        }
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setShadow(true, this.jdField_i_of_type_Int, (int)this.jdField_d_of_type_Float, (int)this.jdField_e_of_type_Float, (int)this.jdField_c_of_type_Float);
      }
      for (;;)
      {
        localObject1 = ETEngine.getInstance();
        Object localObject2 = getPaint().getFontMetrics();
        float f1 = ((Paint.FontMetrics)localObject2).descent;
        float f2 = ((Paint.FontMetrics)localObject2).ascent;
        float f3 = ((Paint.FontMetrics)localObject2).leading;
        this.jdField_a_of_type_Fh.jdField_a_of_type_Int = ((int)(f3 + (f1 - f2)));
        this.jdField_a_of_type_Fh.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
        this.jdField_a_of_type_Fh.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Fh.a(this.jdField_h_of_type_Int);
        localObject2 = new ETFont(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath, getTextSize());
        ((ETFont)localObject2).copy(this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
        boolean bool2 = false;
        i1 = this.jdField_a_of_type_Int;
        if ((i6 == -2147483648) || (i6 == 1073741824)) {
          i1 = Math.min(this.jdField_a_of_type_Int, i4);
        }
        i2 = i1 - (getPaddingLeft() + getPaddingRight());
        i1 = i2;
        if (i6 == -2147483648) {
          i1 = Math.min(i4, i2);
        }
        if (this.jdField_a_of_type_Fh.jdField_b_of_type_Boolean)
        {
          f1 = fv.jdField_c_of_type_Float;
          if (ajia.a() == 18.0F) {
            f1 = fv.jdField_e_of_type_Float;
          }
          ((ETFont)localObject2).setSize(f1 * getTextSize());
        }
        i2 = ((ETEngine)localObject1).native_getHorizontalMarginThreshold((ETFont)localObject2, i1);
        ((ETFont)localObject2).setSize(getTextSize());
        bool1 = bool2;
        if (i2 > 0)
        {
          bool1 = bool2;
          if (i2 < i1)
          {
            bool1 = this.jdField_a_of_type_Fh.a((ETEngine)localObject1, i1 - i2, getText(), (ETFont)localObject2, i7, true, i1);
            this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration = this.jdField_a_of_type_Fh.a((ETEngine)localObject1, true);
          }
        }
        if (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration == null)
        {
          bool1 = this.jdField_a_of_type_Fh.a((ETEngine)localObject1, i1, getText(), (ETFont)localObject2, i7, false, i1);
          this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration = this.jdField_a_of_type_Fh.a((ETEngine)localObject1, true);
        }
        if (bool1) {
          break;
        }
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId = 0;
        this.jdField_a_of_type_Fh.jdField_a_of_type_Long = -1L;
        super.onMeasure(paramInt1, paramInt2);
        return;
        label1007:
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setShadow(false, 0, 0, 0, 0);
      }
      if ((this.jdField_a_of_type_Fh.jdField_b_of_type_Int >= 2048) || (this.jdField_a_of_type_Fh.jdField_c_of_type_Int >= 2048)) {
        throw new Exception("large bitmap width=" + 0 + ", height=" + 0);
      }
      if (this.jdField_a_of_type_Fh.jdField_a_of_type_Boolean) {
        throw new Exception("no text use system measure2");
      }
      i1 = this.jdField_a_of_type_Fh.jdField_b_of_type_Int;
      i2 = this.jdField_a_of_type_Fh.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration != null)
      {
        localObject1 = this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.mMargins;
        int i9 = ((Rect)localObject1).left;
        int i10 = ((Rect)localObject1).right;
        i7 = ((Rect)localObject1).top;
        int i8 = ((Rect)localObject1).bottom;
        i1 += i9 + i10;
        i2 += i7 + i8;
        label1189:
        fo.a(this.jdField_a_of_type_Fo, i1, i2);
        label1200:
        if (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration != null)
        {
          localObject1 = this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.mMargins;
          break label1405;
        }
      }
    }
    for (;;)
    {
      label1219:
      i4 = Math.min(i1, this.jdField_a_of_type_Int);
      if (i5 == 1073741824)
      {
        i2 = i3;
        label1242:
        setMeasuredDimension(Math.max(i4, this.jdField_f_of_type_Int), Math.max(i2, this.jdField_g_of_type_Int));
        return;
      }
      label1399:
      label1405:
      do
      {
        i2 = this.jdField_a_of_type_Fh.jdField_b_of_type_Int + getPaddingLeft() + getPaddingRight();
        i1 = i2;
        if (localObject1 == null) {
          break label1219;
        }
        i1 = i2 + (((Rect)localObject1).left + ((Rect)localObject1).right);
        break label1219;
        i2 = this.jdField_a_of_type_Fh.jdField_c_of_type_Int + getPaddingTop() + getPaddingBottom();
        i1 = i2;
        if (localObject1 != null)
        {
          i1 = ((Rect)localObject1).top;
          i1 = i2 + (((Rect)localObject1).bottom + i1);
        }
        i2 = i1;
        if (i5 != -2147483648) {
          break label1242;
        }
        i2 = Math.min(i1, i3);
        break label1242;
        continue;
        localObject1 = null;
        break label1189;
        localObject1 = null;
        break label1200;
        bool1 = false;
        break;
      } while (i6 != 1073741824);
      i1 = i4;
    }
  }
  
  public boolean onPreDraw()
  {
    if ((!d()) && (!f()))
    {
      getViewTreeObserver().removeOnPreDrawListener(this);
      return super.onPreDraw();
    }
    getViewTreeObserver().removeOnPreDrawListener(this);
    return true;
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    this.jdField_a_of_type_Ge = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!d()) && (!f())) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.jdField_a_of_type_Bbgb != null)
    {
      int i5;
      int i6;
      if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) && (paramMotionEvent.getAction() == 0))
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        this.jdField_b_of_type_Float = paramMotionEvent.getY();
        i1 = (int)paramMotionEvent.getX();
        i2 = (int)paramMotionEvent.getY();
        i3 = getPaddingLeft();
        i4 = getPaddingTop();
        i5 = getScrollX();
        i6 = getScrollY();
        this.jdField_b_of_type_Int = -1;
        this.jdField_c_of_type_Int = -1;
        if (d()) {
          b(i1 - i3 + i5, i2 - i4 + i6);
        }
        this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) && (this.jdField_a_of_type_AndroidViewMotionEvent != null) && (a(this.jdField_a_of_type_AndroidViewMotionEvent, this.jdField_b_of_type_AndroidViewMotionEvent, paramMotionEvent)))
        {
          this.jdField_g_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidViewMotionEvent = null;
          this.jdField_b_of_type_AndroidViewMotionEvent = null;
          if (this.jdField_a_of_type_Bbgb != null)
          {
            this.jdField_h_of_type_Boolean = true;
            this.jdField_a_of_type_Bbgb.a(this);
            return true;
          }
        }
      }
      else
      {
        if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) || (paramMotionEvent.getAction() != 0)) {
          break label332;
        }
        this.jdField_g_of_type_Boolean = true;
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        this.jdField_b_of_type_Float = paramMotionEvent.getY();
        i1 = (int)paramMotionEvent.getX();
        i2 = (int)paramMotionEvent.getY();
        i3 = getPaddingLeft();
        i4 = getPaddingTop();
        i5 = getScrollX();
        i6 = getScrollY();
        this.jdField_b_of_type_Int = -1;
        this.jdField_c_of_type_Int = -1;
        if (d()) {
          b(i1 - i3 + i5, i2 - i4 + i6);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ETTextView", 2, "reserve to initial status");
        }
      }
    }
    label332:
    while (paramMotionEvent.getAction() != 1) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ETTextView", 2, "action up");
    }
    int i3 = (int)paramMotionEvent.getX();
    int i1 = (int)paramMotionEvent.getY();
    int i4 = getPaddingLeft();
    int i2 = getPaddingTop();
    i3 = i3 - i4 + getScrollX();
    i1 = i1 - i2 + getScrollY();
    this.jdField_d_of_type_Int = i3;
    this.jdField_e_of_type_Int = i1;
    if (d()) {
      i1 = this.jdField_a_of_type_Fh.b(i3, i1) + 1;
    }
    for (;;)
    {
      ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])((Spannable)getText()).getSpans(i1, i1, ClickableSpan.class);
      if (arrayOfClickableSpan.length != 0)
      {
        arrayOfClickableSpan[0].onClick(this);
        return true;
        if (f()) {
          i1 = this.jdField_a_of_type_J.a(i3, i1, a());
        }
      }
      else
      {
        this.jdField_b_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if ((d()) && (!this.o) && (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration != null)) {
          this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.gotoLastFrame();
        }
        if (this.jdField_h_of_type_Boolean)
        {
          this.jdField_h_of_type_Boolean = false;
          this.jdField_b_of_type_AndroidViewMotionEvent = null;
        }
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, 200L);
        break;
      }
      i1 = 0;
    }
  }
  
  public void setCacheMeasureResult(boolean paramBoolean)
  {
    if (this.j != paramBoolean)
    {
      this.j = paramBoolean;
      requestLayout();
    }
  }
  
  public void setDefaultFont(Typeface paramTypeface, long paramLong)
  {
    setTypeface(paramTypeface);
    if (gh.jdField_a_of_type_Int == 4) {
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null)
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(9999, gh.a(), getTextSize());
        this.jdField_a_of_type_Long = paramLong;
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontType = -1;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Fr != null) {
        this.jdField_a_of_type_Fr.a(this);
      }
      return;
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId = 9999;
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setPath(gh.a());
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setSize(getTextSize());
      break;
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont = null;
    }
  }
  
  public void setFont(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(paramInt, "", getTextSize());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId == 0) {
        setTypeface(null);
      }
      if (this.jdField_a_of_type_Long != paramLong) {
        this.k = false;
      }
      this.jdField_a_of_type_Long = paramLong;
      return;
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId = paramInt;
    }
  }
  
  public void setFont(ETFont paramETFont, long paramLong)
  {
    a(paramETFont, paramLong, 0);
  }
  
  public void setFont(ETFont paramETFont, ChatMessage paramChatMessage, SessionInfo paramSessionInfo)
  {
    Object localObject;
    if ((paramETFont.mText == null) && ((paramChatMessage instanceof MessageForText)))
    {
      localObject = (MessageForText)paramChatMessage;
      if (TextUtils.isEmpty(((MessageForText)localObject).sb)) {
        break label114;
      }
      if (TextUtils.isEmpty(((MessageForText)localObject).sb2)) {
        break label104;
      }
      localObject = ((MessageForText)localObject).sb2;
    }
    for (;;)
    {
      paramETFont.mText = ((CharSequence)localObject);
      localObject = paramChatMessage.getExtInfoFromExtStr("vip_sub_font_id");
      int i1 = 0;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        i1 = Integer.parseInt((String)localObject);
      }
      a(paramETFont, paramChatMessage.uniseq, i1);
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
      return;
      label104:
      localObject = ((MessageForText)localObject).sb;
      continue;
      label114:
      localObject = null;
    }
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    super.setMaxWidth(paramInt);
  }
  
  public void setMinHeight(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
    super.setMinHeight(paramInt);
  }
  
  public void setMinWidth(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    super.setMinWidth(paramInt);
  }
  
  public void setOnTextOrFontChangeListener(fr paramfr)
  {
    this.jdField_a_of_type_Fr = paramfr;
  }
  
  public void setShadowLayer(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    super.setShadowLayer(paramFloat1, paramFloat2, paramFloat3, paramInt);
    this.jdField_c_of_type_Float = paramFloat1;
    this.jdField_d_of_type_Float = paramFloat2;
    this.jdField_e_of_type_Float = paramFloat3;
    this.jdField_i_of_type_Int = paramInt;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (this.jdField_a_of_type_Fr != null) {
      this.jdField_a_of_type_Fr.a(this, paramCharSequence);
    }
    super.setText(paramCharSequence, paramBufferType);
  }
  
  public void setTextAnimationListener(fs paramfs)
  {
    this.jdField_a_of_type_Fs = paramfs;
  }
  
  public final void setTextMsg(CharSequence paramCharSequence)
  {
    if ((paramCharSequence != null) && (!paramCharSequence.equals(getText())))
    {
      setText(paramCharSequence);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    try
    {
      super.setTypeface(paramTypeface);
      return;
    }
    catch (Exception paramTypeface)
    {
      QLog.e("ETTextView", 1, "fail to setTypeface", paramTypeface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextView
 * JD-Core Version:    0.7.0.1
 */