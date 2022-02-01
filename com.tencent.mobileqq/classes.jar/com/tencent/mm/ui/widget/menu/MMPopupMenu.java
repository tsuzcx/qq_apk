package com.tencent.mm.ui.widget.menu;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i.c;
import com.tencent.mm.ui.base.i.e;
import com.tencent.mm.ui.base.j;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public class MMPopupMenu
  implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private static int a = 0;
  private static int b = 0;
  private static boolean c = false;
  private long A = 0L;
  private MMPopupMenu.ICreateMenuViewListener B;
  private boolean C = true;
  private boolean D = false;
  private Context d = null;
  private LayoutInflater e;
  private View f = null;
  private MMPopupMenu.SubmenuAdapter g = null;
  private com.tencent.mm.ui.base.f h;
  private j i;
  private j j;
  private int k;
  private DisplayMetrics l;
  private boolean m = false;
  private View n;
  private View.OnCreateContextMenuListener o;
  private i.e p;
  private i.c q;
  private com.tencent.mm.ui.base.g r;
  private View s;
  private boolean t = false;
  private boolean u = false;
  private PopupWindow.OnDismissListener v;
  private boolean w = false;
  private boolean x = false;
  private boolean y = true;
  private boolean z = true;
  
  public MMPopupMenu(Context paramContext)
  {
    this.d = paramContext;
    this.e = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    e();
  }
  
  public MMPopupMenu(Context paramContext, View paramView)
  {
    this.d = paramContext;
    this.f = paramView;
    this.e = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    e();
    f();
  }
  
  private int a(ListAdapter paramListAdapter)
  {
    int i1 = 0;
    int i6 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i7 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i8 = paramListAdapter.getCount();
    View localView = null;
    int i2 = 0;
    int i3;
    for (int i4 = 0; i1 < i8; i4 = i3)
    {
      int i5 = paramListAdapter.getItemViewType(i1);
      i3 = i4;
      if (i5 != i4)
      {
        localView = null;
        i3 = i5;
      }
      localView = paramListAdapter.getView(i1, localView, new FrameLayout(this.d));
      i4 = i2;
      if (localView != null)
      {
        localView.measure(i6, i7);
        i4 = Math.max(i2, localView.getMeasuredWidth());
      }
      i1 += 1;
      i2 = i4;
    }
    return i2;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if ((!isShowing()) && (!isHorizontalMenuShowing()))
    {
      if (isGridMenuShowing()) {
        return false;
      }
      if (c())
      {
        com.tencent.mm.ui.f.d("MicroMsg.MMPopupMenu", "is swiping, PASS tryShow", new Object[0]);
        return false;
      }
      if (this.u)
      {
        localObject = this.q;
        if (localObject != null)
        {
          ((i.c)localObject).a(this.r, this.f, null);
          break label107;
        }
      }
      Object localObject = this.o;
      if (localObject != null) {
        ((View.OnCreateContextMenuListener)localObject).onCreateContextMenu(this.r, this.f, null);
      }
      label107:
      int i4 = this.g.getCount() * this.d.getResources().getDimensionPixelSize(2131296403);
      if ((i4 == 0) && (!this.t) && (!this.u)) {
        return false;
      }
      int i5 = this.d.getResources().getDimensionPixelSize(2131297338);
      int i2 = a(this.g);
      int i3 = com.tencent.mm.ui.g.b(this.d, 2131297816);
      int i1 = i2;
      if (i2 < i3) {
        i1 = i3;
      }
      boolean bool;
      if (this.r.size() >= 3) {
        bool = false;
      } else {
        bool = true;
      }
      d();
      if (this.t)
      {
        b(paramInt1, paramInt2);
        return true;
      }
      if (this.u)
      {
        c(paramInt1, paramInt2);
        return true;
      }
      localObject = SubMenuLogic.calculateLocation(this.d, i1, paramInt1, paramInt2, i4, i5, bool);
      this.k = (paramInt2 - this.d.getResources().getDimensionPixelSize(2131297338));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showPointY=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("verticalOffset=");
      localStringBuilder.append(this.k);
      com.tencent.mm.ui.f.b("MicroMsg.MMPopupMenu", localStringBuilder.toString(), new Object[0]);
      this.h = new com.tencent.mm.ui.base.f(this.d, null, 0);
      this.h.a(this);
      this.h.a(new MMPopupMenu.5(this));
      this.h.a(this.g);
      this.h.a(this.C);
      this.h.b(this.D);
      this.h.a(this.d.getResources().getDrawable(2130852695));
      this.h.a(((SubMenuLogic.SubmnuLocation)localObject).animationStyle);
      this.h.b(((SubMenuLogic.SubmnuLocation)localObject).marginRight);
      this.h.c(((SubMenuLogic.SubmnuLocation)localObject).marginTop);
      this.h.a(this.f);
      this.h.e(i1);
      this.h.f(2);
      localObject = this.d;
      if (((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing()))
      {
        this.h.b();
        this.h.g().setOnKeyListener(this);
        this.h.g().setDivider(new ColorDrawable(this.d.getResources().getColor(2131168227)));
        this.h.g().setSelector(this.d.getResources().getDrawable(2130842529));
        this.h.g().setDividerHeight(0);
        this.h.g().setVerticalScrollBarEnabled(false);
        this.h.g().setHorizontalScrollBarEnabled(false);
        return true;
      }
    }
    return false;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int i2 = this.d.getResources().getDimensionPixelOffset(2131296389);
    int i3 = this.d.getResources().getDimensionPixelOffset(2131296368);
    this.i = new j(this.d);
    this.i.setOnDismissListener(this);
    this.i.setWidth(-2);
    this.i.setHeight(-2);
    this.i.setBackgroundDrawable(this.d.getResources().getDrawable(2130852695));
    this.i.setFocusable(this.w);
    this.i.setOutsideTouchable(this.x);
    Object localObject = new LinearLayout(this.d);
    ((LinearLayout)localObject).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((LinearLayout)localObject).setOrientation(0);
    ((LinearLayout)localObject).setBackgroundColor(this.d.getResources().getColor(2131165193));
    int i1 = 0;
    while (i1 < this.r.size())
    {
      TextView localTextView = (TextView)this.e.inflate(2131625141, null, false);
      localTextView.setBackgroundResource(2130842529);
      if (i1 == 0) {
        localTextView.setPadding(i3, 0, i2, 0);
      } else if (i1 == this.r.size() - 1) {
        localTextView.setPadding(i2, 0, i3, 0);
      }
      localTextView.setText(((MenuItem)this.r.getItemList().get(i1)).getTitle());
      localTextView.setOnClickListener(new MMPopupMenu.6(this, i1));
      ((LinearLayout)localObject).addView(localTextView);
      i1 += 1;
    }
    ((LinearLayout)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    i1 = ((LinearLayout)localObject).getMeasuredHeight();
    this.i.setWidth(((LinearLayout)localObject).getMeasuredWidth() + com.tencent.mm.ui.g.a(this.d, 24));
    this.i.setContentView((View)localObject);
    localObject = this.d;
    if (((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing())) {
      this.i.showAtLocation(this.f, 0, paramInt1, paramInt2 - i1);
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    this.j = new j(this.d);
    this.j.setOnDismissListener(this);
    this.j.setWidth(-2);
    this.j.setHeight(-2);
    this.j.setFocusable(this.y);
    this.j.setOutsideTouchable(true);
    this.j.setAnimationStyle(2131952225);
    this.j.setInputMethodMode(2);
    View localView = View.inflate(this.d, 2131624963, null);
    localView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    LinearLayout localLinearLayout1 = (LinearLayout)localView.findViewById(2131438125);
    LinearLayout localLinearLayout2 = (LinearLayout)localView.findViewById(2131438126);
    Object localObject1 = localView.findViewById(2131438114);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131431535);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131431536);
    localLinearLayout1.setVisibility(0);
    localLinearLayout1.removeAllViews();
    if (this.r.size() > 5)
    {
      localLinearLayout2.setVisibility(0);
      localLinearLayout2.removeAllViews();
      ((View)localObject1).setVisibility(0);
    }
    int i1 = 0;
    while (i1 < this.r.size())
    {
      localObject1 = this.B;
      if (localObject1 != null) {
        localObject1 = ((MMPopupMenu.ICreateMenuViewListener)localObject1).create(this.d, (MenuItem)this.r.getItemList().get(i1));
      } else {
        localObject1 = null;
      }
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = View.inflate(this.d, 2131625593, null);
        localObject1 = (WeImageView)((View)localObject2).findViewById(2131435219);
        TextView localTextView = (TextView)((View)localObject2).findViewById(2131447463);
        ((WeImageView)localObject1).setImageDrawable(((MenuItem)this.r.getItemList().get(i1)).getIcon());
        localTextView.setText(((MenuItem)this.r.getItemList().get(i1)).getTitle());
      }
      ((View)localObject2).setOnClickListener(new MMPopupMenu.7(this, i1));
      if (i1 < 5) {
        localLinearLayout1.addView((View)localObject2);
      } else if ((i1 >= 5) && (i1 < 10)) {
        localLinearLayout2.addView((View)localObject2);
      }
      i1 += 1;
    }
    this.j.setContentView(localView);
    localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    int i3 = localView.getMeasuredHeight();
    int i4 = localView.getMeasuredWidth();
    i1 = com.tencent.mm.ui.g.a(this.d, 12);
    int i2 = paramInt1 - (int)(i4 / 2.0F);
    if (i2 + i4 > this.l.widthPixels - i1) {
      i1 = this.l.widthPixels - i1 - i4;
    } else if (i2 >= i1) {
      i1 = i2;
    }
    i2 = paramInt2 - i3 - com.tencent.mm.ui.g.b(this.d, 2131296317);
    if (i2 < 0)
    {
      i2 = this.f.getHeight();
      paramInt2 = com.tencent.mm.ui.g.b(this.d, 2131296317) + (paramInt2 + i2);
      localImageView2.setVisibility(0);
      localImageView1.setVisibility(8);
      localObject1 = (LinearLayout.LayoutParams)localImageView2.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).leftMargin = (paramInt1 - i1 - com.tencent.mm.ui.g.a(this.d, 7));
      localImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramInt1 = paramInt2;
    }
    else
    {
      localImageView2.setVisibility(8);
      localImageView1.setVisibility(0);
      localObject1 = (LinearLayout.LayoutParams)localImageView1.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).leftMargin = (paramInt1 - i1 - com.tencent.mm.ui.g.a(this.d, 7));
      localImageView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramInt1 = i2;
    }
    if (this.r.size() == 0)
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(8);
    }
    localObject1 = this.d;
    if (((localObject1 instanceof Activity)) && (!((Activity)localObject1).isFinishing()))
    {
      this.j.showAtLocation(this.f, 0, i1, paramInt1);
      this.A = System.currentTimeMillis();
    }
  }
  
  private boolean c()
  {
    Object localObject = this.d;
    if ((localObject instanceof Activity))
    {
      localObject = ((ViewGroup)((Activity)localObject).getWindow().getDecorView()).findViewById(16908290);
      if (localObject != null)
      {
        Rect localRect = new Rect();
        ((View)localObject).getGlobalVisibleRect(localRect);
        if (localRect.left > 0) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void d()
  {
    if (!this.m)
    {
      View localView = this.n;
      if (localView != null)
      {
        localView.setSelected(true);
        return;
      }
      this.f.setSelected(true);
    }
  }
  
  private void e()
  {
    dismiss();
    this.r = new com.tencent.mm.ui.base.g(this.d);
    this.g = new MMPopupMenu.SubmenuAdapter(this, null);
    this.l = this.d.getResources().getDisplayMetrics();
  }
  
  private void f()
  {
    this.f.setOnTouchListener(new MMPopupMenu.8(this));
  }
  
  public void disableSelectedstatus(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean dismiss()
  {
    Object localObject;
    if (isShowing())
    {
      localObject = this.h;
      if (localObject != null) {
        ((com.tencent.mm.ui.base.f)localObject).c();
      }
      return true;
    }
    if (isHorizontalMenuShowing())
    {
      localObject = this.i;
      if (localObject != null) {
        ((j)localObject).dismiss();
      }
      return true;
    }
    if (isGridMenuShowing())
    {
      localObject = this.j;
      if (localObject != null) {
        ((j)localObject).dismiss();
      }
      return true;
    }
    return false;
  }
  
  public long getMenuStartShowTime()
  {
    return this.A;
  }
  
  public boolean isGridMenuShowing()
  {
    j localj = this.j;
    return (localj != null) && (localj.isShowing());
  }
  
  public boolean isHorizontalMenuShowing()
  {
    j localj = this.i;
    return (localj != null) && (localj.isShowing());
  }
  
  public boolean isShowing()
  {
    com.tencent.mm.ui.base.f localf = this.h;
    return (localf != null) && (localf.e());
  }
  
  public void onDismiss()
  {
    if (!this.m)
    {
      localObject = this.n;
      if (localObject != null) {
        ((View)localObject).setSelected(false);
      } else {
        this.f.setSelected(false);
      }
    }
    Object localObject = this.v;
    if (localObject != null) {
      ((PopupWindow.OnDismissListener)localObject).onDismiss();
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void openGridPopupMenu(View paramView, i.c paramc, i.e parame, int paramInt1, int paramInt2)
  {
    this.p = parame;
    this.f = paramView;
    if ((!(paramView instanceof TextView)) && ((paramInt1 == 0) || (paramInt2 == 0))) {
      f();
    }
    this.r.clear();
    paramc.a(this.r, paramView, null);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      show();
      return;
    }
    show(paramInt1, paramInt2);
  }
  
  public void openPopupMenu(View paramView, int paramInt1, long paramLong, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, i.e parame, int paramInt2, int paramInt3)
  {
    this.p = parame;
    this.f = paramView;
    f();
    this.r.clear();
    parame = new AdapterView.AdapterContextMenuInfo(paramView, paramInt1, paramLong);
    paramOnCreateContextMenuListener.onCreateContextMenu(this.r, paramView, parame);
    paramView = this.r.getItemList().iterator();
    while (paramView.hasNext()) {
      ((h)paramView.next()).a(parame);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      show();
      return;
    }
    show(paramInt2, paramInt3);
  }
  
  public void openPopupMenu(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, i.e parame, int paramInt1, int paramInt2)
  {
    this.p = parame;
    this.f = paramView;
    if ((!(paramView instanceof TextView)) && ((paramInt1 == 0) || (paramInt2 == 0))) {
      f();
    }
    this.r.clear();
    paramOnCreateContextMenuListener.onCreateContextMenu(this.r, paramView, null);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      show();
      return;
    }
    show(paramInt1, paramInt2);
  }
  
  public void registerGridPopupMenu(View paramView, i.c paramc, i.e parame)
  {
    this.f = paramView;
    f();
    this.p = parame;
    if ((paramView instanceof AbsListView))
    {
      com.tencent.mm.ui.f.a("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView", new Object[0]);
      ((AbsListView)paramView).setOnItemLongClickListener(new MMPopupMenu.3(this, paramc));
      return;
    }
    com.tencent.mm.ui.f.a("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view", new Object[0]);
    paramView.setOnLongClickListener(new MMPopupMenu.4(this, paramc, paramView));
  }
  
  public void registerPopupMenu(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, i.e parame)
  {
    this.f = paramView;
    f();
    this.p = parame;
    if ((paramView instanceof AbsListView))
    {
      com.tencent.mm.ui.f.a("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView", new Object[0]);
      ((AbsListView)paramView).setOnItemLongClickListener(new MMPopupMenu.1(this, paramOnCreateContextMenuListener));
      return;
    }
    com.tencent.mm.ui.f.a("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view", new Object[0]);
    paramView.setOnLongClickListener(new MMPopupMenu.2(this, paramOnCreateContextMenuListener));
  }
  
  public void setCreateMenuViewListener(MMPopupMenu.ICreateMenuViewListener paramICreateMenuViewListener)
  {
    this.B = paramICreateMenuViewListener;
  }
  
  public void setGridPop(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void setHorizontal(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void setListPopupMenuForceIgnoreOutsideTouch(boolean paramBoolean)
  {
    this.D = paramBoolean;
  }
  
  public void setListPopupMenuMode(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  public void setOnCreateMMMenuListener(i.c paramc)
  {
    this.q = paramc;
  }
  
  public void setOnCreateMenuListener(View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    this.o = paramOnCreateContextMenuListener;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.v = paramOnDismissListener;
  }
  
  public void setOnMenuSelectedListener(i.e parame)
  {
    this.p = parame;
  }
  
  public void setPressView(View paramView)
  {
    this.n = paramView;
  }
  
  public void setmGridFocusable(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public void setmHorizontalFocusable(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public void setmHorizontalOutsideTouchable(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public boolean show()
  {
    return show(0, 0);
  }
  
  public boolean show(int paramInt1, int paramInt2)
  {
    View localView = this.f;
    if (((localView != null) && (!localView.equals(this.s))) || ((!c) && ((paramInt1 != 0) || (paramInt2 != 0))))
    {
      a = paramInt1;
      b = paramInt2;
    }
    this.s = null;
    int i2 = a;
    int i6 = b;
    c = false;
    if (this.l == null) {
      this.l = this.d.getResources().getDisplayMetrics();
    }
    localView = this.f;
    int i4 = i2;
    int i5 = i6;
    if (localView != null)
    {
      int[] arrayOfInt = new int[2];
      localView.getLocationOnScreen(arrayOfInt);
      int i1 = i2;
      if (i2 == 0) {
        i1 = arrayOfInt[0] + this.f.getWidth() / 2;
      }
      int i3 = arrayOfInt[1];
      i4 = arrayOfInt[1] + this.f.getHeight();
      i2 = i3;
      if (i3 < 0) {
        i2 = 0;
      }
      i3 = i4;
      if (i4 > this.l.heightPixels) {
        i3 = this.l.heightPixels;
      }
      i4 = i1;
      i5 = i6;
      if (i6 == 0)
      {
        i5 = (i2 + i3) / 2;
        i4 = i1;
      }
    }
    com.tencent.mm.ui.f.c("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i4), Integer.valueOf(i5) });
    if ((isShowing()) && (isHorizontalMenuShowing()) && (isGridMenuShowing())) {
      return dismiss() & a(i4, i5);
    }
    return a(i4, i5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.menu.MMPopupMenu
 * JD-Core Version:    0.7.0.1
 */