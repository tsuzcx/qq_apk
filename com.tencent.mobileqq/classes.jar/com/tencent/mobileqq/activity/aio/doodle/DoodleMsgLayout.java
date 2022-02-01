package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.doodle.IDoodleMsgLayout;
import com.tencent.mobileqq.scribble.ResCallback;
import com.tencent.mobileqq.scribble.ResInfo;
import com.tencent.mobileqq.transfile.BaseURLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class DoodleMsgLayout
  extends BaseDoodleMsgLayout
  implements GifDrawable.OnGIFPlayOnceListener, DoodleMsgViewListener, IDoodleMsgLayout, ResCallback
{
  private int a = 0;
  private DoodleMsgView b;
  private URLImageView c;
  private URLImageView d;
  private URLImageView e;
  private URLDrawableDownListener f;
  private ImageView g;
  private ImageView h;
  private RelativeLayout i;
  private boolean j;
  private int k = 0;
  private int l;
  private String m;
  private int n = 0;
  private int o = 0;
  private boolean p;
  private WeakReference<DoodleMsgLayoutListener> q;
  private boolean r;
  private boolean s = false;
  private boolean t = false;
  private DoodleMsgLayout.PendingData u = new DoodleMsgLayout.PendingData(this);
  
  public DoodleMsgLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    j();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 4)
    {
      a(1, paramBoolean);
      a(2, paramBoolean);
      a(3, paramBoolean);
      return;
    }
    URLImageView localURLImageView = null;
    if (paramInt == 1) {
      localURLImageView = this.c;
    } else if (paramInt == 2) {
      localURLImageView = this.d;
    } else if (paramInt == 3) {
      localURLImageView = this.e;
    }
    if (localURLImageView != null)
    {
      if (!paramBoolean)
      {
        localURLImageView.setVisibility(8);
        return;
      }
      if (this.k > 0)
      {
        localURLImageView.setVisibility(0);
        return;
      }
      localURLImageView.setVisibility(4);
    }
  }
  
  private void b(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changeStateUI:");
      ((StringBuilder)localObject).append(this.m);
      ((StringBuilder)localObject).append(" state:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("DoodleMsgLayout", 2, ((StringBuilder)localObject).toString());
    }
    this.a = paramInt;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          a(1, false);
          localObject = this.b;
          if (localObject != null) {
            ((DoodleMsgView)localObject).setVisibility(0);
          }
          if (this.p)
          {
            a(3, false);
            a(2, true);
          }
        }
        else
        {
          a(1, false);
          localObject = this.b;
          if (localObject != null)
          {
            ((DoodleMsgView)localObject).setVisibility(0);
            this.b.c();
          }
          a(3, true);
          a(2, false);
        }
      }
      else
      {
        a(1, true);
        localObject = this.b;
        if (localObject != null) {
          ((DoodleMsgView)localObject).setVisibility(4);
        }
        a(2, false);
        a(3, false);
      }
    }
    else
    {
      a(4, false);
      localObject = this.b;
      if (localObject != null) {
        ((DoodleMsgView)localObject).setVisibility(4);
      }
    }
  }
  
  private Bitmap getCommonProgressBitmap()
  {
    Bitmap localBitmap;
    if (GlobalImageCache.a != null) {
      localBitmap = (Bitmap)GlobalImageCache.a.get("aio_doodle_progress");
    } else {
      localBitmap = null;
    }
    if ((localBitmap == null) && (!this.s))
    {
      this.s = true;
      ThreadManager.post(new DoodleMsgLayout.2(this), 5, null, true);
    }
    return localBitmap;
  }
  
  private Drawable getFailedBitmap()
  {
    return BaseURLDrawableHelper.getFailedDrawable();
  }
  
  private void j()
  {
    QLog.d("DoodleMsgLayout", 2, "init begin");
    if (QQTheme.isNowThemeSimpleNight()) {
      setBackgroundResource(2130851810);
    }
    this.f = new DoodleMsgLayout.1(this);
    Object localObject = getResources().getDisplayMetrics();
    int i1 = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    int i3 = getResources().getDimensionPixelSize(2131296626);
    int i4 = getResources().getDimensionPixelSize(2131296628);
    int i5 = getResources().getDimensionPixelSize(2131296627);
    int i6 = getResources().getDimensionPixelSize(2131296625);
    this.n = ((int)(i1 * 0.544F));
    i1 = this.n;
    this.o = ((int)(i1 * 1.0F / 1.133333F));
    i1 = i1 - i3 - i5;
    int i2 = this.o - i6 - i4;
    float f1 = i1;
    float f2 = i2;
    if (1.0F * f1 / f2 > 1.133333F) {
      i1 = (int)(f2 * 1.133333F);
    } else {
      i2 = (int)(f1 / 1.133333F);
    }
    if (this.e == null)
    {
      this.e = new URLImageView(getContext());
      localObject = new RelativeLayout.LayoutParams(i1, i2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      ((RelativeLayout.LayoutParams)localObject).setMargins(i3, i4, i5, i6);
      addView(this.e, (ViewGroup.LayoutParams)localObject);
      a(3, false);
    }
    if (this.c == null)
    {
      this.c = new URLImageView(getContext());
      localObject = new RelativeLayout.LayoutParams(i1, i2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      ((RelativeLayout.LayoutParams)localObject).setMargins(i3, i4, i5, i6);
      addView(this.c, (ViewGroup.LayoutParams)localObject);
      this.c.setURLDrawableDownListener(this.f);
      a(1, false);
    }
    if (this.d == null)
    {
      this.d = new URLImageView(getContext());
      localObject = new RelativeLayout.LayoutParams(i1, i2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      ((RelativeLayout.LayoutParams)localObject).setMargins(i3, i4, i5, i6);
      addView(this.d, (ViewGroup.LayoutParams)localObject);
      this.d.setURLDrawableDownListener(this.f);
      a(2, false);
    }
    QLog.d("DoodleMsgLayout", 2, "brefor crate DoodleMsgView ");
    if (this.b == null)
    {
      this.b = new DoodleMsgView(getContext(), null);
      localObject = new RelativeLayout.LayoutParams(i1, i2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      ((RelativeLayout.LayoutParams)localObject).setMargins(i3, i4, i5, i6);
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.b.setBackgroundColor(getResources().getColor(2131168376));
      addView(this.b);
      this.b.a(this, i1, i2);
    }
    setLayoutParams(new RelativeLayout.LayoutParams(this.n, this.o));
  }
  
  private void k()
  {
    b(this.a);
  }
  
  private void l()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.h == null)
    {
      this.h = new ImageView(getContext());
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      this.h.setLayoutParams(localLayoutParams);
      this.h.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.h.setClickable(false);
      addView(this.h);
    }
    if (this.g == null)
    {
      this.g = new ImageView(getContext());
      localLayoutParams = new RelativeLayout.LayoutParams(Utils.a(19.0F, getResources()), Utils.a(19.0F, getResources()));
      localLayoutParams.addRule(13);
      this.g.setLayoutParams(localLayoutParams);
      this.g.setClickable(false);
      addView(this.g);
    }
  }
  
  private void m()
  {
    DoodleMsgView localDoodleMsgView = this.b;
    if (localDoodleMsgView != null)
    {
      localDoodleMsgView.a();
      this.b = null;
    }
    this.c = null;
    this.e = null;
    this.d = null;
    this.f = null;
  }
  
  private void setTemplateID(int paramInt)
  {
    Object localObject;
    if (paramInt > 0)
    {
      this.p = false;
      localObject = DoodleResHelper.a().a(1, paramInt, true);
      if (localObject != null)
      {
        localURLImageView = this.c;
        if (localURLImageView != null)
        {
          localURLImageView.setImageDrawable((Drawable)localObject);
          ((URLDrawable)localObject).setIndividualPause(true);
        }
      }
      localObject = DoodleResHelper.a().a(2, paramInt, false);
      URLImageView localURLImageView = this.e;
      if ((localURLImageView != null) && (localObject != null))
      {
        localURLImageView.setImageDrawable((Drawable)localObject);
        ((URLDrawable)localObject).startDownload();
      }
      localObject = DoodleResHelper.a().a(2, paramInt, true);
      localURLImageView = this.d;
      if ((localURLImageView != null) && (localObject != null))
      {
        localURLImageView.setImageDrawable((Drawable)localObject);
        ((URLDrawable)localObject).startDownload();
      }
    }
    else
    {
      localObject = this.c;
      if (localObject != null) {
        ((URLImageView)localObject).setImageDrawable(null);
      }
      localObject = this.e;
      if (localObject != null) {
        ((URLImageView)localObject).setImageDrawable(null);
      }
      localObject = this.d;
      if (localObject != null) {
        ((URLImageView)localObject).setImageDrawable(null);
      }
      this.p = true;
    }
  }
  
  public void a()
  {
    QLog.d("DoodleMsgLayout", 2, "showLoadingStatus begin");
    l();
    QLog.d("DoodleMsgLayout", 2, "showLoadingStatus begin 1");
    Object localObject = this.g;
    if (localObject != null)
    {
      if (((ImageView)localObject).getDrawable() == null)
      {
        localObject = getCommonProgressBitmap();
        if (localObject != null)
        {
          localObject = new PhotoProgressDrawable((Bitmap)localObject, 0, false);
          ((PhotoProgressDrawable)localObject).setBounds(new Rect(0, 0, Utils.a(19.0F, getResources()), Utils.a(19.0F, getResources())));
          this.g.setImageDrawable((Drawable)localObject);
        }
        else
        {
          QLog.d("DoodleMsgLayout", 2, "showLoadingStatus wait callback");
        }
      }
      this.g.setVisibility(0);
    }
    localObject = this.h;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.i;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(4);
    }
    QLog.d("DoodleMsgLayout", 2, "showLoadingStatus end");
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onInitState:");
      ((StringBuilder)localObject).append(this.m);
      ((StringBuilder)localObject).append(" state:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("DoodleMsgLayout", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    WeakReference localWeakReference = this.q;
    if (localWeakReference != null) {
      localObject = (DoodleMsgLayoutListener)localWeakReference.get();
    }
    if ((paramInt != -1) && (paramInt != 4))
    {
      int i1 = this.l;
      if (i1 != 2)
      {
        if ((paramInt == 0) && (i1 == 0))
        {
          if (this.j) {
            b(3);
          } else {
            b(0);
          }
          if (localObject != null) {
            ((DoodleMsgLayoutListener)localObject).a(this, 0);
          }
          if (this.r) {
            d();
          }
          return;
        }
        if (localObject != null) {
          ((DoodleMsgLayoutListener)localObject).a(this, 1);
        }
        QLog.i("DoodleMsgLayout", 2, "onLoadData end");
        return;
      }
    }
    b(0);
    this.r = false;
    if ((paramInt != -1) && (localObject != null)) {
      ((DoodleMsgLayoutListener)localObject).a(this, 2);
    }
  }
  
  public void a(View paramView, int paramInt1, ResInfo paramResInfo, int paramInt2)
  {
    if ((paramResInfo != null) && (paramView != null) && (paramInt1 == 2))
    {
      if (paramResInfo.b != this.k) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("handleMessage begin:");
        paramView.append(paramInt2);
        QLog.i("DoodleMsgLayout", 2, paramView.toString());
      }
      if (1 == paramInt2)
      {
        this.l = 0;
        setTemplateID(this.k);
      }
      else if (4 == paramInt2)
      {
        this.l = 1;
      }
      else
      {
        this.l = 2;
      }
      paramInt1 = getDataState();
      if (paramInt1 == 0)
      {
        if (this.j) {
          b(3);
        } else {
          b(0);
        }
      }
      else if ((paramInt1 == 2) || (paramInt1 == -1)) {
        b(0);
      }
      paramView = null;
      paramResInfo = this.q;
      if (paramResInfo != null) {
        paramView = (DoodleMsgLayoutListener)paramResInfo.get();
      }
      if (paramView != null)
      {
        paramView.a(this, paramInt1);
        paramView = new StringBuilder();
        paramView.append("handleMessage end:");
        paramView.append(paramInt1);
        QLog.i("DoodleMsgLayout", 2, paramView.toString());
      }
      if ((paramInt1 == 0) && (this.r)) {
        d();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("DoodleMsgLayout", 2, "showFailedStatus begin");
    l();
    Object localObject = this.g;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    if (paramBoolean)
    {
      localObject = this.h;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = this.i;
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(4);
      }
    }
    else
    {
      localObject = this.i;
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(4);
      }
      localObject = this.h;
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        if (this.h.getDrawable() == null)
        {
          localObject = getFailedBitmap();
          this.h.setImageDrawable((Drawable)localObject);
        }
      }
    }
    QLog.d("DoodleMsgLayout", 2, "showFailedStatus end");
  }
  
  public boolean a(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    return (paramView == this.d) || (paramView == this.c) || (paramView == this.e) || (paramView == this.b);
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setDoodleContent :");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" GifID:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" prepare:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("DoodleMsgLayout", 2, ((StringBuilder)localObject).toString());
    }
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = 0;
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.u.b = false;
      this.m = null;
      this.k = 0;
      this.l = 0;
      b(0);
      paramString = this.b;
      if (paramString != null)
      {
        paramString.c();
        this.b.setContent(null, false);
      }
      return false;
    }
    if (this.k == i1)
    {
      localObject = this.m;
      if ((localObject != null) && (((String)localObject).equals(paramString)))
      {
        this.u.b = false;
        if (e())
        {
          if (QLog.isColorLevel()) {
            QLog.d("DoodleMsgLayout", 2, "setDoodleContent isplaying, return:");
          }
          return false;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setDoodleContent same data, prepare old:");
          ((StringBuilder)localObject).append(this.j);
          QLog.d("DoodleMsgLayout", 2, ((StringBuilder)localObject).toString());
        }
        if ((this.k > 0) && (this.l == 2))
        {
          DoodleResHelper.a().b(1, this.k, this, this);
          this.l = 1;
        }
        this.j = paramBoolean;
        b(0);
        localObject = this.b;
        if (localObject != null) {
          ((DoodleMsgView)localObject).setContent(paramString, paramBoolean);
        }
        return true;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setDoodleContent old data:");
      ((StringBuilder)localObject).append(this.m);
      ((StringBuilder)localObject).append(" GifID:");
      ((StringBuilder)localObject).append(this.k);
      ((StringBuilder)localObject).append(" prepare:");
      ((StringBuilder)localObject).append(this.j);
      QLog.d("DoodleMsgLayout", 2, ((StringBuilder)localObject).toString());
    }
    if (this.u.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleMsgLayout", 2, "pending data, return");
      }
      localObject = this.u;
      ((DoodleMsgLayout.PendingData)localObject).c = paramString;
      ((DoodleMsgLayout.PendingData)localObject).d = i1;
      ((DoodleMsgLayout.PendingData)localObject).e = paramBoolean;
      ((DoodleMsgLayout.PendingData)localObject).b = true;
      b(0);
      paramString = this.b;
      if (paramString != null) {
        paramString.a(true);
      }
      return true;
    }
    this.u.b = false;
    Object localObject = this.b;
    if (localObject != null) {
      ((DoodleMsgView)localObject).a(false);
    }
    this.m = paramString;
    this.j = paramBoolean;
    if (i1 > 0)
    {
      if (i1 == this.k)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setDoodleContent use same template:");
          ((StringBuilder)localObject).append(this.k);
          ((StringBuilder)localObject).append(" status:");
          ((StringBuilder)localObject).append(this.l);
          ((StringBuilder)localObject).append("loopOK:");
          ((StringBuilder)localObject).append(this.p);
          QLog.d("DoodleMsgLayout", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        this.k = i1;
        this.l = 1;
        this.p = false;
        ThreadManager.post(new DoodleMsgLayout.3(this, this.k), 5, null, true);
      }
    }
    else
    {
      this.k = 0;
      this.l = 0;
      setTemplateID(i1);
    }
    b(0);
    localObject = this.b;
    if (localObject != null) {
      ((DoodleMsgView)localObject).setContent(paramString, paramBoolean);
    }
    return true;
  }
  
  public void b()
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.h;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.i;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(4);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.u.a = paramBoolean;
    Object localObject = this.b;
    if (localObject != null) {
      ((DoodleMsgView)localObject).a(paramBoolean);
    }
    if (!paramBoolean)
    {
      if (this.u.b)
      {
        if (!a(this.u.c, this.u.d, this.u.e))
        {
          localObject = this.b;
          if (localObject != null) {
            a(((DoodleMsgView)localObject).getDataState());
          }
        }
        this.u.b = false;
      }
    }
    else
    {
      localObject = this.u;
      ((DoodleMsgLayout.PendingData)localObject).d = this.k;
      ((DoodleMsgLayout.PendingData)localObject).e = this.j;
      ((DoodleMsgLayout.PendingData)localObject).c = this.m;
      ((DoodleMsgLayout.PendingData)localObject).b = true;
    }
  }
  
  public boolean c()
  {
    return TextUtils.isEmpty(this.m) ^ true;
  }
  
  public void d()
  {
    if (getDataState() != 0)
    {
      this.r = true;
      return;
    }
    int i1 = this.a;
    if ((i1 != 0) || (i1 != 3)) {
      f();
    }
    this.r = false;
    Object localObject;
    if (this.k > 0)
    {
      localObject = this.c;
      if (localObject != null)
      {
        localObject = ((URLImageView)localObject).getDrawable();
        if ((localObject != null) && ((localObject instanceof URLDrawable)))
        {
          localObject = (URLDrawable)localObject;
          Drawable localDrawable = ((URLDrawable)localObject).getCurrDrawable();
          if ((localDrawable instanceof GifDrawable)) {
            ((GifDrawable)localDrawable).getImage().reset();
          }
          ((URLDrawable)localObject).setIndividualPause(false);
          b(1);
          return;
        }
        b(0);
        ThreadManager.post(new DoodleMsgLayout.4(this), 5, null, true);
      }
    }
    else
    {
      b(2);
      localObject = this.b;
      if (localObject != null) {
        ((DoodleMsgView)localObject).a(0L);
      }
    }
  }
  
  public boolean e()
  {
    int i1 = this.a;
    return (i1 != 0) && (i1 != 3);
  }
  
  public void f()
  {
    this.r = false;
    b(3);
    Object localObject = this.b;
    if (localObject != null) {
      ((DoodleMsgView)localObject).d();
    }
    localObject = this.c;
    if (localObject != null) {
      ((URLImageView)localObject).setImageDrawable(null);
    }
    localObject = this.e;
    if (localObject != null) {
      ((URLImageView)localObject).setImageDrawable(null);
    }
  }
  
  public void g()
  {
    if ((this.k > 0) && (this.l != 0))
    {
      DoodleResHelper.a().b(1, this.k, this, this);
      this.l = 1;
    }
    DoodleMsgView localDoodleMsgView = this.b;
    if (localDoodleMsgView != null) {
      localDoodleMsgView.b();
    }
  }
  
  public int getDataState()
  {
    DoodleMsgView localDoodleMsgView = this.b;
    int i2 = 2;
    int i1 = i2;
    if (localDoodleMsgView != null)
    {
      i1 = localDoodleMsgView.getDataState();
      if (i1 != -1)
      {
        if (i1 != 0)
        {
          if ((i1 != 1) && (i1 != 2) && (i1 != 3)) {
            return 2;
          }
          int i3 = this.l;
          if (i3 == 0) {}
          for (;;)
          {
            return 1;
            if (i3 == 2) {
              return 2;
            }
            i1 = i2;
            if (i3 != 1) {
              break;
            }
          }
        }
        return this.l;
      }
      i1 = -1;
    }
    return i1;
  }
  
  public void h() {}
  
  public void i()
  {
    b(3);
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((URLImageView)localObject).getDrawable();
      if ((localObject instanceof URLDrawable))
      {
        localObject = (URLDrawable)localObject;
        ((URLDrawable)localObject).setIndividualPause(false);
        localObject = ((URLDrawable)localObject).getCurrDrawable();
        if ((localObject instanceof GifDrawable)) {
          ((GifDrawable)localObject).getImage().reset();
        }
      }
    }
    localObject = this.c;
    if (localObject != null)
    {
      localObject = ((URLImageView)localObject).getDrawable();
      if ((localObject instanceof URLDrawable)) {
        ((URLDrawable)localObject).setIndividualPause(false);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    m();
    super.onDetachedFromWindow();
    QLog.i("DoodleMsgLayout", 2, "onDetachedFromWindow");
  }
  
  public void onPlayOnce()
  {
    b(2);
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((URLImageView)localObject).getDrawable();
      if ((localObject != null) && ((localObject instanceof URLDrawable)))
      {
        localObject = (URLDrawable)localObject;
        ((URLDrawable)localObject).setIndividualPause(true);
        localObject = ((URLDrawable)localObject).getCurrDrawable();
        if ((localObject instanceof GifDrawable)) {
          ((GifDrawable)localObject).getImage().reset();
        }
      }
    }
    localObject = this.b;
    if (localObject != null) {
      ((DoodleMsgView)localObject).a(100L);
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0) {
      return;
    }
    f();
  }
  
  public void setOperateListener(View.OnClickListener paramOnClickListener, View.OnTouchListener paramOnTouchListener, View.OnLongClickListener paramOnLongClickListener, DoodleMsgLayoutListener paramDoodleMsgLayoutListener)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (paramOnClickListener != null) {
        ((DoodleMsgView)localObject).setOnClickListener(paramOnClickListener);
      }
      if (paramOnTouchListener != null) {
        this.b.setOnTouchListener(paramOnTouchListener);
      }
      if (paramOnLongClickListener != null) {
        this.b.setOnLongClickListener(paramOnLongClickListener);
      }
    }
    localObject = this.c;
    if (localObject != null)
    {
      if (paramOnClickListener != null) {
        ((URLImageView)localObject).setOnClickListener(paramOnClickListener);
      }
      if (paramOnTouchListener != null) {
        this.c.setOnTouchListener(paramOnTouchListener);
      }
      if (paramOnLongClickListener != null) {
        this.c.setOnLongClickListener(paramOnLongClickListener);
      }
    }
    localObject = this.e;
    if (localObject != null)
    {
      if (paramOnClickListener != null) {
        ((URLImageView)localObject).setOnClickListener(paramOnClickListener);
      }
      if (paramOnTouchListener != null) {
        this.e.setOnTouchListener(paramOnTouchListener);
      }
      if (paramOnLongClickListener != null) {
        this.e.setOnLongClickListener(paramOnLongClickListener);
      }
    }
    this.q = new WeakReference(paramDoodleMsgLayoutListener);
  }
  
  public void setTalkBack(String paramString)
  {
    DoodleMsgView localDoodleMsgView = this.b;
    if (localDoodleMsgView != null) {
      localDoodleMsgView.setContentDescription(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout
 * JD-Core Version:    0.7.0.1
 */