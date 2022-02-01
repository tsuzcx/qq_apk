package com.tencent.common.galleryactivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public abstract class AbstractImageListScene
  extends ImageScene
  implements AnimationLister
{
  protected AbstractImageListModel a;
  protected Activity b;
  int c;
  protected TextView d;
  protected TextView e;
  protected TextView f;
  protected ImageView g;
  protected ImageView h;
  protected ImageView i;
  protected View j;
  protected GestureSelectGridView k;
  protected Dialog l;
  protected QQCustomDialog m;
  protected RelativeLayout n;
  protected boolean o;
  protected TextView p;
  public AbstractImageAdapter q;
  protected AbstractAnimationManager r;
  protected boolean s;
  AnimationLister t = new AbstractImageListScene.6(this);
  private int u;
  private int v;
  private int w;
  
  public AbstractImageListScene(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    this.b = paramActivity;
    this.a = paramAbstractImageListModel;
  }
  
  private void c(ViewGroup paramViewGroup)
  {
    this.n = ((RelativeLayout)LayoutInflater.from(this.b).inflate(2131627283, null));
    if (paramViewGroup == null) {
      this.b.addContentView(this.n, new ViewGroup.LayoutParams(-1, -1));
    } else {
      paramViewGroup.addView(this.n, 0);
    }
    b(this.n);
    this.d = ((TextView)this.b.findViewById(2131447463));
    this.e = ((TextView)this.b.findViewById(2131429427));
    this.f = ((TextView)this.b.findViewById(2131445515));
    this.g = ((ImageView)this.b.findViewById(2131433639));
    this.h = ((ImageView)this.b.findViewById(2131445230));
    this.i = ((ImageView)this.b.findViewById(2131450118));
    this.j = this.b.findViewById(2131428150);
    this.p = ((TextView)this.b.findViewById(2131430550));
    this.k = ((GestureSelectGridView)this.b.findViewById(2131428041));
    this.k.setScrollBarStyle(0);
    this.k.setNumColumns(4);
    this.k.setColumnWidth(this.c);
    this.k.setHorizontalSpacing(this.u);
    this.k.setVerticalSpacing(this.v);
    paramViewGroup = this.k;
    paramViewGroup.setPadding(this.w, paramViewGroup.getPaddingTop(), this.w, this.k.getPaddingBottom());
    this.k.setOnItemClickListener(o());
    this.k.setOnIndexChangedListener(p());
    this.q = a(this.b, this.c);
    this.k.setAdapter(this.q);
    this.d.setText(2131916794);
    s();
    v();
    this.n.setVisibility(4);
  }
  
  private void r()
  {
    ((WindowManager)this.b.getSystemService("window")).getDefaultDisplay();
    this.w = this.b.getResources().getDimensionPixelSize(2131298139);
    this.u = this.b.getResources().getDimensionPixelSize(2131298140);
    this.v = this.b.getResources().getDimensionPixelSize(2131298141);
    this.c = ((ViewUtils.getScreenWidth() - this.w * 2 - this.u * 3) / 4);
  }
  
  private void s()
  {
    if (this.e != null) {
      if ((this.C != null) && (this.C.g))
      {
        this.p.setVisibility(0);
        this.p.setText("");
        ((ViewGroup.MarginLayoutParams)this.p.getLayoutParams()).setMargins(AIOUtils.b(16.0F, this.b.getResources()), 0, 0, 0);
        this.e.setVisibility(8);
        this.p.setOnClickListener(new AbstractImageListScene.1(this));
      }
      else
      {
        this.e.setVisibility(0);
        this.p.setVisibility(8);
        this.e.setText(2131886475);
        this.e.setOnClickListener(new AbstractImageListScene.2(this));
      }
    }
    TextView localTextView = this.f;
    if (localTextView != null)
    {
      localTextView.setVisibility(0);
      this.f.setText(2131886578);
      this.f.setOnClickListener(q());
    }
  }
  
  private void v()
  {
    if (this.s) {
      this.j.setVisibility(0);
    } else {
      this.j.setVisibility(8);
    }
    this.g.setOnClickListener(new AbstractImageListScene.3(this));
    this.h.setOnClickListener(new AbstractImageListScene.4(this));
    ImageView localImageView = this.i;
    if (localImageView != null) {
      localImageView.setOnClickListener(new AbstractImageListScene.5(this));
    }
  }
  
  public Rect a()
  {
    int i1 = this.k.getFirstVisiblePosition();
    int i2 = this.a.b();
    View localView = this.k.getChildAt(i2 - i1);
    if (localView != null) {
      return AnimationUtils.a(localView);
    }
    return null;
  }
  
  protected abstract AbstractImageAdapter a(Activity paramActivity, int paramInt);
  
  public void a(ViewGroup paramViewGroup)
  {
    this.r = this.C.a();
    r();
    c(paramViewGroup);
  }
  
  public void b()
  {
    this.C.a().a(this.t);
  }
  
  public void e() {}
  
  protected abstract void f();
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void j() {}
  
  public void k()
  {
    super.k();
    this.s = false;
    this.q = null;
    this.a = null;
  }
  
  protected abstract void m();
  
  protected abstract void n();
  
  protected abstract AdapterView.OnItemClickListener o();
  
  protected abstract GestureSelectGridView.OnSelectListener p();
  
  protected abstract View.OnClickListener q();
  
  public void t()
  {
    if ((this.b instanceof AIOGalleryActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImmerseTest", 2, "imagelist setColor blue");
      }
      int i1;
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        localObject = this.n;
        if (localObject != null)
        {
          localObject = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
          i1 = ImmersiveUtils.getStatusBarHeight(this.b);
          if (localObject != null) {
            ((RelativeLayout.LayoutParams)localObject).setMargins(0, i1, 0, 0);
          }
          if ((this.C != null) && (this.C.h != null) && (Build.VERSION.SDK_INT >= 16)) {
            this.C.h.setSystemUiVisibility(0);
          }
        }
      }
      if (((AIOGalleryActivity)this.b).A != null)
      {
        i1 = this.b.getResources().getColor(2131168092);
        ((AIOGalleryActivity)this.b).A.setStatusColor(i1);
        ((AIOGalleryActivity)this.b).A.setStatusBarColor(i1);
      }
    }
    this.d.setText(2131916794);
    Object localObject = this.n;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "imagelist onstart");
    }
  }
  
  public void u()
  {
    super.u();
    this.B.setVisibility(4);
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "imagelist onStop");
    }
  }
  
  public boolean x()
  {
    e();
    this.b.finish();
    if (this.o) {
      this.b.overridePendingTransition(2130772113, 2130772105);
    } else {
      this.b.overridePendingTransition(2130771994, 2130771995);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractImageListScene
 * JD-Core Version:    0.7.0.1
 */