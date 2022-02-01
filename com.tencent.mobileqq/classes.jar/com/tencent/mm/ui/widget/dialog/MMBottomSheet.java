package com.tencent.mm.ui.widget.dialog;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.i.a;
import com.tencent.mm.ui.base.i.b;
import com.tencent.mm.ui.base.i.d;
import com.tencent.mm.ui.base.i.e;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;

public class MMBottomSheet
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public static final int BOTTOM_SHEET_STYLE_GRID = 0;
  public static final int BOTTOM_SHEET_STYLE_LIST = 1;
  public static final int BOTTOM_SHEET_STYLE_LIST_CHECKBOX = 2;
  private View A;
  private TextView B;
  private MMBottomSheet.RecycleViewAdapter C;
  private MMBottomSheet.RecycleViewAdapter D;
  private boolean E = false;
  private boolean F = false;
  private boolean G = false;
  private boolean H = false;
  private RecyclerView I;
  private RecyclerView J;
  private int K;
  private BottomSheetBehavior L;
  private boolean M = false;
  private int N;
  private View O;
  private ViewTreeObserver P;
  private ImageView Q;
  private ImageView R;
  private int S = 4;
  private int T = this.S * 3;
  private int U = 6;
  private int V;
  private boolean W;
  private boolean X;
  private boolean Y;
  private boolean Z = false;
  MMBottomSheet.IDismissCallBack a;
  private boolean aa = false;
  private boolean ab = false;
  private boolean ac = false;
  private boolean ad = false;
  private boolean ae = false;
  private int af = 0;
  private boolean ag = false;
  private int ah = 0;
  private int ai = 0;
  private boolean aj = false;
  private boolean ak = false;
  private Dialog b;
  private Context c;
  private i.d d;
  private i.d e;
  private i.d f;
  private i.e g;
  private i.e h;
  private i.e i;
  private i.e j;
  private MMBottomSheet.MoreShareCallBack k;
  private MMBottomSheet.CancelBtnCallBack l;
  private i.a m;
  private i.a n;
  private i.b o;
  private com.tencent.mm.ui.base.g p;
  private com.tencent.mm.ui.base.g q;
  private com.tencent.mm.ui.base.g r;
  private com.tencent.mm.ui.base.g s;
  private View t;
  private Boolean u = Boolean.valueOf(false);
  private LinearLayout v;
  private LinearLayout w;
  private LinearLayout x;
  private CustomScrollView y;
  private View z;
  
  public MMBottomSheet(Context paramContext, int paramInt, boolean paramBoolean)
  {
    this.V = paramInt;
    this.c = paramContext;
    this.W = paramBoolean;
    this.ae = false;
    paramContext = this.c;
    if ((paramContext instanceof Activity)) {
      this.O = ((ViewGroup)((Activity)paramContext).getWindow().getDecorView()).findViewById(16908290);
    }
    a(this.c);
  }
  
  public MMBottomSheet(Context paramContext, boolean paramBoolean, int paramInt)
  {
    this.V = paramInt;
    this.c = paramContext;
    this.ag = paramBoolean;
    paramContext = this.c;
    if ((paramContext instanceof Activity)) {
      this.O = ((ViewGroup)((Activity)paramContext).getWindow().getDecorView()).findViewById(16908290);
    }
    a(this.c);
  }
  
  @SuppressLint({"WrongConstant"})
  private int a()
  {
    Context localContext = this.c;
    if ((localContext instanceof Activity)) {
      return ((Activity)localContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    return 0;
  }
  
  private void a(Context paramContext)
  {
    this.p = new com.tencent.mm.ui.base.g(paramContext);
    this.q = new com.tencent.mm.ui.base.g(paramContext);
    this.r = new com.tencent.mm.ui.base.g(paramContext);
    this.s = new com.tencent.mm.ui.base.g(paramContext);
    if (this.ag) {
      this.b = new CustomSheetDialog(paramContext);
    } else {
      this.b = new NewBottomSheetDialog(paramContext, 2131951988);
    }
    this.t = View.inflate(paramContext, 2131625436, null);
    this.v = ((LinearLayout)this.t.findViewById(2131429694));
    this.w = ((LinearLayout)this.t.findViewById(2131429690));
    this.x = ((LinearLayout)this.t.findViewById(2131429688));
    this.A = this.t.findViewById(2131430290);
    this.B = ((TextView)this.t.findViewById(2131430291));
    this.y = ((CustomScrollView)this.t.findViewById(2131431359));
    this.z = this.t.findViewById(2131434340);
    this.Q = ((ImageView)this.t.findViewById(2131431826));
    this.R = ((ImageView)this.t.findViewById(2131438124));
    this.x.setOnClickListener(new MMBottomSheet.1(this));
    this.I = ((RecyclerView)this.t.findViewById(2131429692));
    this.I.setHasFixedSize(true);
    this.J = ((RecyclerView)this.t.findViewById(2131429693));
    this.J.setHasFixedSize(true);
    this.M = e();
    int i1 = this.V;
    if (i1 == 0)
    {
      this.H = true;
      if (this.M)
      {
        this.S = 7;
        this.T = (this.S * 2);
        this.K = (com.tencent.mm.ui.g.b(this.c, 2131296270) + com.tencent.mm.ui.g.b(this.c, 2131297561));
      }
      else
      {
        this.K = (com.tencent.mm.ui.g.b(this.c, 2131296269) + com.tencent.mm.ui.g.b(this.c, 2131297561));
      }
      if (this.W) {
        this.K += com.tencent.mm.ui.g.b(this.c, 2131297561);
      }
      this.x.setVisibility(0);
      if (this.t != null) {
        if ((this.ag) && (e())) {
          this.t.setBackgroundColor(this.c.getResources().getColor(2131165189));
        } else {
          this.t.setBackgroundResource(2130853410);
        }
      }
      this.y.setOnScrollChangeListener(new MMBottomSheet.2(this));
    }
    else
    {
      double d1;
      if (i1 == 2)
      {
        this.F = true;
        i1 = com.tencent.mm.ui.g.b(this.c, 2131296959);
        if (this.M)
        {
          this.U = 2;
          d1 = i1;
          Double.isNaN(d1);
          this.K = ((int)(d1 * 2.5D) + com.tencent.mm.ui.g.b(this.c, 2131296955));
        }
        else
        {
          this.U = 3;
          d1 = i1;
          Double.isNaN(d1);
          this.K = ((int)(d1 * 3.5D) + com.tencent.mm.ui.g.b(this.c, 2131296955));
        }
        if (this.W) {
          this.K += com.tencent.mm.ui.g.a(this.c, 88);
        }
      }
      else
      {
        this.G = true;
        i1 = com.tencent.mm.ui.g.b(this.c, 2131296962);
        if (this.M)
        {
          this.U = 4;
          d1 = i1;
          Double.isNaN(d1);
          this.K = ((int)(d1 * 4.5D) + com.tencent.mm.ui.g.b(this.c, 2131296955));
        }
        else
        {
          this.U = 6;
          d1 = i1;
          Double.isNaN(d1);
          this.K = ((int)(d1 * 6.5D) + com.tencent.mm.ui.g.b(this.c, 2131296955));
        }
        if (this.W) {
          this.K += com.tencent.mm.ui.g.b(this.c, 2131297561);
        }
        paramContext = this.x;
        if (paramContext != null) {
          paramContext.setVisibility(0);
        }
      }
    }
    if (this.W)
    {
      paramContext = this.Q;
      if ((paramContext != null) && (this.ae)) {
        paramContext.setVisibility(0);
      }
    }
    if (this.V == 0)
    {
      paramContext = new LinearLayoutManager(this.c);
      paramContext.setOrientation(0);
      this.I.setLayoutManager(paramContext);
      paramContext = new LinearLayoutManager(this.c);
      paramContext.setOrientation(0);
      this.J.setLayoutManager(paramContext);
    }
    else
    {
      this.I.setLayoutManager(new LinearLayoutManager(this.c));
    }
    this.I.setFocusable(false);
    this.I.setItemViewCacheSize(20);
    this.C = new MMBottomSheet.RecycleViewAdapter(this);
    this.C.setMenu(this.p);
    this.C.setOnItemClickListener(new MMBottomSheet.3(this));
    this.I.setAdapter(this.C);
    this.I.setOverScrollMode(1);
    this.D = new MMBottomSheet.RecycleViewAdapter(this);
    this.D.setMenu(this.r);
    this.D.setOnItemClickListener(new MMBottomSheet.4(this));
    this.J.setAdapter(this.D);
    this.J.setOverScrollMode(1);
    paramContext = this.b;
    if (paramContext != null) {
      paramContext.setContentView(this.t);
    }
    paramContext = this.b;
    if (paramContext != null) {
      paramContext.setOnDismissListener(new MMBottomSheet.5(this));
    }
  }
  
  @TargetApi(23)
  private void b()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      Dialog localDialog = this.b;
      if (localDialog != null)
      {
        localDialog.getWindow().getDecorView().setSystemUiVisibility(9216);
        this.b.getWindow().setStatusBarColor(0);
      }
    }
  }
  
  private void c()
  {
    this.k.onClick();
  }
  
  private void d()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.t.getLayoutParams();
    this.p.size();
    if ((!this.E) && (this.q.size() > 0)) {
      this.q.size();
    }
    boolean bool = this.ag;
    int i1 = this.V;
    if ((this.M) && (this.O != null))
    {
      Rect localRect = new Rect();
      this.O.getWindowVisibleDisplayFrame(localRect);
      if (this.ag)
      {
        localLayoutParams.width = ((int)(localRect.right * 1.0F / 2.0F));
        i1 = this.ai;
        if (i1 != 0) {
          localLayoutParams.width = i1;
        }
        if (com.tencent.mm.ui.h.f(this.c)) {
          localLayoutParams.height = (localRect.bottom - com.tencent.mm.ui.h.b(this.c));
        } else {
          localLayoutParams.height = localRect.bottom;
        }
      }
      else
      {
        localLayoutParams.width = Math.min(localRect.right, localRect.bottom);
        i1 = this.ai;
        if (i1 != 0) {
          localLayoutParams.width = i1;
        }
      }
    }
    this.t.setLayoutParams(localLayoutParams);
  }
  
  private boolean e()
  {
    return this.c.getResources().getConfiguration().orientation == 2;
  }
  
  public void addItem(com.tencent.mm.ui.base.g paramg, i.e parame)
  {
    this.q = paramg;
    this.h = parame;
  }
  
  public void dismissDestroy(boolean paramBoolean)
  {
    this.aa = paramBoolean;
  }
  
  public void hideCancelBtn(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = this.x;
    if (localLinearLayout == null) {
      return;
    }
    if (paramBoolean)
    {
      localLinearLayout.setVisibility(8);
      return;
    }
    localLinearLayout.setVisibility(0);
  }
  
  public void hideNavigationFullScreen(boolean paramBoolean)
  {
    this.ac = paramBoolean;
  }
  
  public void hideStatusBar(boolean paramBoolean)
  {
    this.Y = paramBoolean;
  }
  
  public void initSelectedItem(int paramInt)
  {
    this.af = paramInt;
  }
  
  public boolean isDarkBg()
  {
    return this.u.booleanValue();
  }
  
  public boolean isShowing()
  {
    Dialog localDialog = this.b;
    return (localDialog != null) && (localDialog.isShowing());
  }
  
  public void moreIconShow(boolean paramBoolean, MMBottomSheet.MoreShareCallBack paramMoreShareCallBack)
  {
    this.E = paramBoolean;
    this.k = paramMoreShareCallBack;
  }
  
  public void notifyChange()
  {
    if (this.b != null)
    {
      if (this.q != null)
      {
        localRecycleViewAdapter = this.C;
        if (localRecycleViewAdapter != null) {
          localRecycleViewAdapter.notifyDataSetChanged();
        }
      }
      MMBottomSheet.RecycleViewAdapter localRecycleViewAdapter = this.D;
      if (localRecycleViewAdapter != null) {
        localRecycleViewAdapter.notifyDataSetChanged();
      }
      this.b.show();
    }
  }
  
  public void onGlobalLayout()
  {
    if (isShowing())
    {
      View localView = this.O;
      if ((localView != null) && ((localView.isShown()) || (localView.getVisibility() == 0)))
      {
        if ((isShowing()) && ((this.M != e()) || (this.N != a()))) {
          tryHide();
        }
      }
      else {
        tryHide();
      }
    }
  }
  
  public void setBackgroundColor(@ColorInt int paramInt)
  {
    Object localObject = this.t;
    if (localObject != null) {
      ((View)localObject).setBackgroundColor(paramInt);
    }
    this.u = Boolean.valueOf(e.a(paramInt));
    if (this.u.booleanValue())
    {
      localObject = this.Q;
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(this.c.getResources().getDrawable(2131165927));
      }
    }
  }
  
  public void setCancelBtnClickListener(MMBottomSheet.CancelBtnCallBack paramCancelBtnCallBack)
  {
    this.l = paramCancelBtnCallBack;
  }
  
  public void setFooterView(View paramView)
  {
    LinearLayout localLinearLayout = this.w;
    if (localLinearLayout != null)
    {
      if (paramView == null)
      {
        localLinearLayout.setVisibility(8);
        return;
      }
      localLinearLayout.setVisibility(0);
      this.w.removeAllViews();
      this.w.setGravity(17);
      this.w.addView(paramView, -1, -2);
    }
  }
  
  public void setHeaderMenuIconCreator(i.a parama)
  {
    this.n = parama;
  }
  
  public void setIconCreator(i.a parama)
  {
    this.m = parama;
  }
  
  @TargetApi(23)
  public void setLightStatusBar(boolean paramBoolean)
  {
    this.X = paramBoolean;
  }
  
  public void setNewLandscapeMaxWidth(int paramInt)
  {
    this.ai = paramInt;
  }
  
  public void setNewLandscapeTitleHeight(int paramInt)
  {
    this.ah = paramInt;
  }
  
  public void setOnBottomSheetDismissListener(MMBottomSheet.IDismissCallBack paramIDismissCallBack)
  {
    this.a = paramIDismissCallBack;
  }
  
  public void setOnCreateHeaderMenuListener(i.d paramd)
  {
    this.f = paramd;
  }
  
  public void setOnCreateMenuListener(i.d paramd)
  {
    this.d = paramd;
  }
  
  public void setOnCreateSecondMenuListener(i.d paramd)
  {
    this.e = paramd;
  }
  
  public void setOnHeaderMenuSelectedListener(i.e parame)
  {
    this.j = parame;
  }
  
  public void setOnMenuSelectedListener(i.e parame)
  {
    this.g = parame;
  }
  
  public void setOnSecondMenuSelectedListener(i.e parame)
  {
    this.i = parame;
  }
  
  public void setTextTitleView(CharSequence paramCharSequence, int paramInt)
  {
    Object localObject = this.v;
    if ((localObject != null) && (this.W))
    {
      ((LinearLayout)localObject).setVisibility(0);
      this.v.removeAllViews();
      this.v.setGravity(paramInt);
      localObject = LayoutInflater.from(this.c).inflate(2131625440, null);
      TextView localTextView = (TextView)((View)localObject).findViewById(2131447576);
      localTextView.setText(paramCharSequence);
      localTextView.setGravity(paramInt | 0x50);
      if (this.ak) {
        localTextView.setTextColor(this.c.getResources().getColor(2131165214));
      }
      this.v.addView((View)localObject, -1, -2);
    }
  }
  
  public void setTextTitleView(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    Object localObject = this.v;
    if ((localObject != null) && (this.W))
    {
      ((LinearLayout)localObject).setVisibility(0);
      this.v.removeAllViews();
      this.v.setGravity(paramInt1);
      localObject = LayoutInflater.from(this.c).inflate(2131625440, null);
      TextView localTextView = (TextView)((View)localObject).findViewById(2131447576);
      localTextView.setText(paramCharSequence);
      localTextView.setTextSize(0, paramInt2);
      localTextView.setGravity(paramInt1 | 0x50);
      if (this.ak) {
        localTextView.setTextColor(this.c.getResources().getColor(2131165214));
      }
      this.v.addView((View)localObject, -1, -2);
    }
  }
  
  public void setTitleCreator(i.b paramb)
  {
    this.o = paramb;
  }
  
  public void setTitleView(View paramView)
  {
    setTitleView(paramView, false);
  }
  
  public void setTitleView(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    this.W = true;
    Object localObject = this.Q;
    if (localObject != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 4;
      } else {
        i1 = 0;
      }
      ((ImageView)localObject).setVisibility(i1);
    }
    localObject = this.v;
    if (localObject != null)
    {
      ((LinearLayout)localObject).setVisibility(0);
      this.v.removeAllViews();
      this.v.setGravity(17);
      this.v.addView(paramView, -1, -2);
    }
  }
  
  public MMBottomSheet showAlwaysDark(boolean paramBoolean)
  {
    this.ak = paramBoolean;
    View localView = this.t;
    if (localView != null)
    {
      if (this.ak)
      {
        if (this.V == 0) {
          localView.setBackgroundResource(2130853411);
        } else {
          localView.setBackgroundResource(2130853409);
        }
        this.A.setBackgroundColor(this.c.getResources().getColor(2131165260));
        this.B.setTextColor(this.c.getResources().getColor(2131165214));
        this.B.setBackgroundResource(2130839747);
        return this;
      }
      localView.setBackgroundResource(2130853412);
    }
    return this;
  }
  
  public void showBottomSheetAlways(boolean paramBoolean)
  {
    this.Z = paramBoolean;
  }
  
  public void showIconAlways(boolean paramBoolean)
  {
    this.ad = paramBoolean;
  }
  
  public MMBottomSheet showIconInListStyle(boolean paramBoolean)
  {
    this.aj = paramBoolean;
    return this;
  }
  
  public void showTitleDividerAlways(boolean paramBoolean)
  {
    this.ae = paramBoolean;
  }
  
  public void tryHide()
  {
    if (this.b != null)
    {
      Object localObject = this.L;
      if (localObject != null) {
        ((BottomSheetBehavior)localObject).b(true);
      }
      localObject = this.c;
      if ((localObject instanceof Activity))
      {
        if ((localObject != null) && (!((Activity)localObject).isFinishing()) && (!((Activity)this.c).isDestroyed())) {
          this.b.dismiss();
        }
      }
      else {
        this.b.dismiss();
      }
    }
  }
  
  public void tryShow()
  {
    int i2 = 0;
    this.ab = false;
    this.M = e();
    this.N = a();
    Object localObject = this.d;
    if (localObject != null) {
      ((i.d)localObject).a(this.p);
    }
    localObject = this.e;
    if (localObject != null) {
      ((i.d)localObject).a(this.r);
    }
    localObject = this.f;
    if (localObject != null) {
      ((i.d)localObject).a(this.s);
    }
    if (this.b != null)
    {
      d();
      int i1;
      if (this.H)
      {
        if (this.r.size() > 0)
        {
          this.R.setVisibility(0);
          this.J.setVisibility(0);
          localObject = this.A;
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
        }
        if (this.s.size() > 0)
        {
          localObject = this.v;
          if (localObject != null)
          {
            ((LinearLayout)localObject).setVisibility(0);
            this.v.removeAllViews();
            this.v.setGravity(17);
          }
          View localView = View.inflate(this.c, 2131624338, null);
          LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131438123);
          i1 = 0;
          while (i1 < this.s.size())
          {
            com.tencent.mm.ui.base.h localh = (com.tencent.mm.ui.base.h)this.s.getItemList().get(i1);
            if (localh.d())
            {
              localObject = View.inflate(this.c, 2131624336, null);
            }
            else
            {
              localObject = View.inflate(this.c, 2131624337, null);
              WeImageView localWeImageView = (WeImageView)((View)localObject).findViewById(2131438160);
              TextView localTextView1 = (TextView)((View)localObject).findViewById(2131438139);
              TextView localTextView2 = (TextView)((View)localObject).findViewById(2131438113);
              i.a locala = this.n;
              if (locala != null) {
                locala.a(localWeImageView, localh);
              } else {
                localWeImageView.setImageDrawable(localh.getIcon());
              }
              localWeImageView.setIconColor(localh.g());
              localTextView1.setText(localh.getTitle());
              if (localh.b() != null)
              {
                localTextView2.setVisibility(0);
                localTextView2.setText(localh.b());
              }
              ((View)localObject).setOnClickListener(new MMBottomSheet.6(this, i1));
            }
            localLinearLayout.addView((View)localObject);
            i1 += 1;
          }
          this.v.addView(localView);
        }
        int i3 = com.tencent.mm.ui.g.b(this.c, 2131297561);
        int i4 = com.tencent.mm.ui.g.b(this.c, 2131296336);
        i1 = i3;
        if (this.W)
        {
          i1 = i3;
          if (this.v.getVisibility() == 0) {
            i1 = com.tencent.mm.ui.g.a(this.c, 0);
          }
        }
        localObject = this.I;
        ((RecyclerView)localObject).setPadding(0, i1, ((RecyclerView)localObject).getPaddingRight(), this.I.getPaddingBottom());
        if (e())
        {
          localObject = this.J;
          ((RecyclerView)localObject).setPadding(0, ((RecyclerView)localObject).getPaddingTop(), this.J.getPaddingRight(), i4);
        }
        else
        {
          localObject = this.J;
          ((RecyclerView)localObject).setPadding(0, ((RecyclerView)localObject).getPaddingTop(), this.J.getPaddingRight(), this.J.getPaddingBottom());
        }
        this.y.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (this.y.getChildAt(0) != null)
        {
          localObject = new Rect();
          this.O.getWindowVisibleDisplayFrame((Rect)localObject);
          if (this.y.getChildAt(0).getMeasuredHeight() + com.tencent.mm.ui.g.b(this.c, 2131296349) > ((Rect)localObject).bottom) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (i1 != 0) {
            this.z.setVisibility(0);
          }
        }
      }
      else
      {
        this.I.setPadding(0, 0, 0, 0);
      }
      if (this.q != null)
      {
        localObject = this.C;
        if (localObject != null) {
          ((MMBottomSheet.RecycleViewAdapter)localObject).notifyDataSetChanged();
        }
      }
      localObject = this.D;
      if (localObject != null) {
        ((MMBottomSheet.RecycleViewAdapter)localObject).notifyDataSetChanged();
      }
      if (Build.VERSION.SDK_INT >= 21) {
        this.b.getWindow().addFlags(-2147483648);
      }
      if (this.X) {
        b();
      }
      if (this.Y) {
        this.b.getWindow().addFlags(1024);
      }
      if (this.ac)
      {
        this.b.getWindow().setFlags(8, 8);
        this.b.getWindow().addFlags(131200);
        this.b.getWindow().getDecorView().setSystemUiVisibility(4102);
      }
      else
      {
        this.b.getWindow().clearFlags(8);
        this.b.getWindow().clearFlags(131072);
        this.b.getWindow().clearFlags(128);
        this.b.getWindow().getDecorView().setSystemUiVisibility(0);
      }
      localObject = this.L;
      if (localObject != null) {
        ((BottomSheetBehavior)localObject).b(false);
      }
      if (this.a != null) {
        this.b.setOnDismissListener(new MMBottomSheet.7(this));
      }
      if (this.O != null)
      {
        i1 = i2;
        if (this.P == null) {
          i1 = 1;
        }
        this.P = this.O.getViewTreeObserver();
        if (i1 != 0) {
          this.P.addOnGlobalLayoutListener(this);
        }
      }
      localObject = this.c;
      if (((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing())) {
        this.b.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMBottomSheet
 * JD-Core Version:    0.7.0.1
 */