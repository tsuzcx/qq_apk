package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Face2FaceAddContactFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, IFace2FaceAddContact
{
  private TextView A;
  private TextView B;
  private LinearLayout C;
  private LinearLayout D;
  private Button E;
  private TextView F;
  private Drawable G;
  private String[] H = { "1234", "0000", "1111", "2222", "3333" };
  private StringBuffer I;
  private long J;
  private boolean K;
  private View.OnClickListener L = new Face2FaceAddContactFragment.2(this);
  Handler a = new Face2FaceAddContactFragment.1(this);
  private Face2FaceAddContactPresenter b;
  private Face2FaceAddContactAdapter c;
  private LinearLayout d;
  private ImageView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private ImageView j;
  private ImageView k;
  private ImageView l;
  private ImageView m;
  private TextView n;
  private TextView o;
  private RecyclerView p;
  private TableLayout q;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private TextView v;
  private TextView w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    PublicFragmentActivity.a(paramContext, paramIntent, Face2FaceAddContactFragment.class);
  }
  
  private void a(View paramView, int paramInt)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131432393: 
    case 2131433223: 
    case 2131433665: 
    case 2131439334: 
    case 2131439559: 
    case 2131445735: 
    case 2131446050: 
    case 2131447313: 
    case 2131448888: 
    case 2131450391: 
      this.I.append(((TextView)paramView).getText());
      return;
    }
    if ((paramInt > 0) && (paramInt < 4)) {
      this.I.deleteCharAt(paramInt - 1);
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          this.m.setVisibility(0);
          this.i.setVisibility(4);
          this.i.setText("");
          return;
        }
        this.l.setVisibility(0);
        this.h.setVisibility(4);
        this.h.setText("");
        return;
      }
      this.k.setVisibility(0);
      this.g.setVisibility(4);
      this.g.setText("");
      return;
    }
    this.j.setVisibility(0);
    this.f.setVisibility(4);
    this.f.setText("");
  }
  
  private void a(boolean paramBoolean)
  {
    this.r.setEnabled(paramBoolean);
    this.s.setEnabled(paramBoolean);
    this.t.setEnabled(paramBoolean);
    this.u.setEnabled(paramBoolean);
    this.v.setEnabled(paramBoolean);
    this.w.setEnabled(paramBoolean);
    this.x.setEnabled(paramBoolean);
    this.y.setEnabled(paramBoolean);
    this.z.setEnabled(paramBoolean);
    this.A.setEnabled(paramBoolean);
    this.B.setEnabled(paramBoolean);
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 4)
    {
      a(false);
      if (!NetworkUtil.isNetSupport(getBaseActivity()))
      {
        QQToast.makeText(getBaseActivity(), 2131892157, 0).show();
        this.a.sendEmptyMessageDelayed(500, 500L);
        return;
      }
      if (c(this.I.toString()))
      {
        QQToast.makeText(getBaseActivity(), getString(2131917322), 0).show();
        Face2FaceAddContactUtils.a("0X800AB5F", "", "", this.I.toString());
        this.a.sendEmptyMessageDelayed(500, 500L);
        return;
      }
      this.F.setVisibility(0);
      this.F.setBackgroundDrawable(this.G);
      ((Animatable)this.G).start();
      this.b.a(getBaseActivity(), this.I.toString(), null);
    }
  }
  
  private boolean c(String paramString)
  {
    return Arrays.asList(this.H).contains(paramString);
  }
  
  private void d(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          this.m.setVisibility(4);
          this.i.setVisibility(0);
          this.i.setText(String.valueOf(this.I.charAt(paramInt - 1)));
          return;
        }
        this.l.setVisibility(4);
        this.h.setVisibility(0);
        this.h.setText(String.valueOf(this.I.charAt(paramInt - 1)));
        return;
      }
      this.k.setVisibility(4);
      this.g.setVisibility(0);
      this.g.setText(String.valueOf(this.I.charAt(paramInt - 1)));
      return;
    }
    this.j.setVisibility(4);
    this.f.setVisibility(0);
    this.f.setText(String.valueOf(this.I.charAt(paramInt - 1)));
  }
  
  private void e(int paramInt)
  {
    if (this.o != null)
    {
      if (isDetached()) {
        return;
      }
      if (this.o.getVisibility() != 0)
      {
        this.e.setVisibility(8);
        this.n.setVisibility(8);
        this.o.setVisibility(0);
        this.f.setTextSize(AIOUtils.b(8.0F, getResources()));
        this.g.setTextSize(AIOUtils.b(8.0F, getResources()));
        this.h.setTextSize(AIOUtils.b(8.0F, getResources()));
        this.i.setTextSize(AIOUtils.b(8.0F, getResources()));
      }
      if (paramInt > 0)
      {
        String str = getString(2131889146, new Object[] { Integer.valueOf(paramInt) });
        int i1 = str.indexOf(String.valueOf(paramInt));
        if (i1 < 0)
        {
          this.o.setText(str);
          return;
        }
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        localSpannableStringBuilder.append(str);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#00CAFC")), i1, String.valueOf(paramInt).length() + i1, 33);
        this.o.setText(localSpannableStringBuilder);
        return;
      }
      this.o.setText(getString(2131889145));
    }
  }
  
  private void k()
  {
    this.b = new Face2FaceAddContactPresenter(this);
    this.I = new StringBuffer();
    this.G = getResources().getDrawable(2130839590);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void l()
  {
    setTitle(getString(2131889139), getString(2131889139));
    this.leftView.setVisibility(8);
    setRightButtonText(getString(2131917019), this);
    this.rightViewText.setContentDescription(getString(2131917019));
    this.d = ((LinearLayout)this.mContentView.findViewById(2131431340));
    this.e = ((ImageView)this.mContentView.findViewById(2131436367));
    this.F = ((TextView)this.mContentView.findViewById(2131440769));
    this.j = ((ImageView)this.mContentView.findViewById(2131436346));
    this.k = ((ImageView)this.mContentView.findViewById(2131436348));
    this.l = ((ImageView)this.mContentView.findViewById(2131436347));
    this.m = ((ImageView)this.mContentView.findViewById(2131436345));
    this.f = ((TextView)this.mContentView.findViewById(2131448389));
    this.g = ((TextView)this.mContentView.findViewById(2131448391));
    this.h = ((TextView)this.mContentView.findViewById(2131448390));
    this.i = ((TextView)this.mContentView.findViewById(2131448388));
    this.n = ((TextView)this.mContentView.findViewById(2131447280));
    this.o = ((TextView)this.mContentView.findViewById(2131447282));
    this.p = ((RecyclerView)this.mContentView.findViewById(2131434389));
    this.c = new Face2FaceAddContactAdapter(getBaseActivity(), getBaseActivity().app, this.p);
    this.p.setLayoutManager(new GridLayoutManager(getBaseActivity(), 5));
    this.p.setAdapter(this.c);
    this.C = ((LinearLayout)this.mContentView.findViewById(2131437399));
    this.D = ((LinearLayout)this.mContentView.findViewById(2131437492));
    this.E = ((Button)this.mContentView.findViewById(2131429886));
    this.E.setOnClickListener(this);
    this.q = ((TableLayout)this.mContentView.findViewById(2131431921));
    this.r = ((TextView)this.mContentView.findViewById(2131439559));
    this.s = ((TextView)this.mContentView.findViewById(2131448888));
    this.t = ((TextView)this.mContentView.findViewById(2131447313));
    this.u = ((TextView)this.mContentView.findViewById(2131433665));
    this.v = ((TextView)this.mContentView.findViewById(2131433223));
    this.w = ((TextView)this.mContentView.findViewById(2131446050));
    this.x = ((TextView)this.mContentView.findViewById(2131445735));
    this.y = ((TextView)this.mContentView.findViewById(2131432393));
    this.z = ((TextView)this.mContentView.findViewById(2131439334));
    this.A = ((TextView)this.mContentView.findViewById(2131450391));
    this.B = ((TextView)this.mContentView.findViewById(2131431708));
    this.r.setOnClickListener(this.L);
    this.r.setOnTouchListener(UITools.a);
    this.s.setOnClickListener(this.L);
    this.s.setOnTouchListener(UITools.a);
    this.t.setOnClickListener(this.L);
    this.t.setOnTouchListener(UITools.a);
    this.u.setOnClickListener(this.L);
    this.u.setOnTouchListener(UITools.a);
    this.v.setOnClickListener(this.L);
    this.v.setOnTouchListener(UITools.a);
    this.w.setOnClickListener(this.L);
    this.w.setOnTouchListener(UITools.a);
    this.x.setOnClickListener(this.L);
    this.x.setOnTouchListener(UITools.a);
    this.y.setOnClickListener(this.L);
    this.y.setOnTouchListener(UITools.a);
    this.z.setOnClickListener(this.L);
    this.z.setOnTouchListener(UITools.a);
    this.A.setOnClickListener(this.L);
    this.A.setOnTouchListener(UITools.a);
    this.B.setOnClickListener(this.L);
    this.B.setOnTouchListener(UITools.a);
  }
  
  private void m()
  {
    if (!isDetached())
    {
      if (getBaseActivity() == null) {
        return;
      }
      if (getBaseActivity().isResume())
      {
        p();
        QQToast.makeText(getBaseActivity(), getString(2131889150), 0).show();
        return;
      }
      this.K = true;
    }
  }
  
  private void n()
  {
    if (!isDetached())
    {
      if (getBaseActivity() == null) {
        return;
      }
      Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.fromParts("package", getBaseActivity().getPackageName(), null));
      getBaseActivity().startActivityForResult(localIntent, 1002);
    }
  }
  
  private void o()
  {
    ((Animatable)this.G).stop();
    this.F.setVisibility(8);
    this.F.setBackgroundDrawable(null);
    e(0);
    this.q.setVisibility(8);
    this.c.notifyDataSetChanged();
    this.p.setVisibility(0);
  }
  
  private void p()
  {
    if (isDetached()) {
      return;
    }
    ((Animatable)this.G).stop();
    this.F.setVisibility(8);
    this.F.setBackgroundDrawable(null);
    this.c.a();
    this.e.setVisibility(0);
    this.n.setVisibility(0);
    this.o.setVisibility(8);
    q();
    this.p.setVisibility(8);
    this.q.setVisibility(0);
    this.C.setVisibility(8);
    Handler localHandler = this.a;
    if (localHandler != null)
    {
      localHandler.removeMessages(301);
      this.a.removeMessages(401);
    }
  }
  
  private void q()
  {
    StringBuffer localStringBuffer = this.I;
    localStringBuffer.delete(0, localStringBuffer.length());
    this.f.setText("");
    this.j.setVisibility(0);
    this.g.setText("");
    this.k.setVisibility(0);
    this.h.setText("");
    this.l.setVisibility(0);
    this.i.setText("");
    this.m.setVisibility(0);
    a(true);
  }
  
  private void r()
  {
    this.D.setVisibility(8);
    this.d.setVisibility(0);
    p();
  }
  
  private void s()
  {
    if ((this.b != null) && (this.c != null) && (getBaseActivity() != null) && (!getBaseActivity().isFinishing()))
    {
      Object localObject1;
      if (QLog.isDebugVersion())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sendFace2FaceHeartBeat isNetworkAvailable:");
        ((StringBuilder)localObject1).append(NetworkUtil.isNetworkAvailable());
        QLog.d("Face2FaceAddContactFragment", 2, ((StringBuilder)localObject1).toString());
      }
      if (NetworkUtil.isNetworkAvailable())
      {
        Object localObject2 = this.c.c();
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Face2FaceFriendInfo localFace2FaceFriendInfo = (Face2FaceFriendInfo)((Iterator)localObject2).next();
          if (localFace2FaceFriendInfo != null) {
            ((List)localObject1).add(localFace2FaceFriendInfo.a);
          }
        }
        this.b.a((List)localObject1);
        return;
      }
      b(20000);
    }
  }
  
  public void a()
  {
    if (!isDetached())
    {
      if (getBaseActivity() == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Face2FaceAddContactFragment", 2, "onExitFace2FaceAddContact()");
      }
      p();
    }
  }
  
  public void a(int paramInt)
  {
    if (!isDetached())
    {
      if (getBaseActivity() == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEnterFace2FaceAddContactSuccess() expireTimeMs:");
        localStringBuilder.append(paramInt);
        QLog.d("Face2FaceAddContactFragment", 2, localStringBuilder.toString());
      }
      this.J = SystemClock.elapsedRealtime();
      o();
      if ((this.a != null) && (getBaseActivity() != null) && (!getBaseActivity().isFinishing()))
      {
        this.a.removeMessages(401);
        this.a.sendEmptyMessageDelayed(401, paramInt);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteFriend delFriendUin:");
      localStringBuilder.append(paramString);
      QLog.d("Face2FaceAddContactFragment", 2, localStringBuilder.toString());
    }
    if ((!isDetached()) && (getBaseActivity() != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      int i1 = 0;
      while (i1 < this.c.c().size())
      {
        if (paramString.equals(((Face2FaceFriendInfo)this.c.c().get(i1)).a)) {
          break label117;
        }
        i1 += 1;
      }
      i1 = -1;
      label117:
      if (QLog.isDebugVersion())
      {
        paramString = new StringBuilder();
        paramString.append("deleteFriend delIndex:");
        paramString.append(i1);
        QLog.d("Face2FaceAddContactFragment", 2, paramString.toString());
      }
      if (i1 != -1)
      {
        this.c.c().remove(i1);
        this.c.notifyItemRemoved(i1);
        e(this.c.c().size());
      }
    }
  }
  
  public void a(String paramString, List<Face2FaceFriendInfo> paramList)
  {
    if ((!isDetached()) && (getBaseActivity() != null) && (paramList != null) && (paramList.size() > 0))
    {
      if (this.c.c() == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append(" onFace2FaceAddContactPush() faceFriends.size() = ");
        paramString.append(paramList.size());
        QLog.d("Face2FaceAddContactFragment", 2, paramString.toString());
      }
      if (this.p.getVisibility() != 0)
      {
        this.p.setVisibility(0);
        this.C.setVisibility(8);
      }
      int i1 = this.c.c().size();
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (Face2FaceFriendInfo)paramString.next();
        if (!this.c.c().contains(paramList)) {
          this.c.c().add(i1, paramList);
        }
      }
      int i2 = this.c.c().size();
      if (i1 != i2) {
        this.c.notifyItemRangeInserted(i1, i2 - i1);
      }
      e(i2);
    }
  }
  
  public void a(List<String> paramList)
  {
    if ((!isDetached()) && (getBaseActivity() != null) && (paramList != null))
    {
      if (getBaseActivity().app == null) {
        return;
      }
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" onFace2FaceAddContactHeartBeat() missingList.size() = ");
        ((StringBuilder)localObject1).append(paramList.size());
        QLog.d("Face2FaceAddContactFragment", 2, ((StringBuilder)localObject1).toString());
      }
      if (paramList.size() > 0)
      {
        localObject1 = (FriendsManager)getBaseActivity().app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (localObject1 != null)
        {
          ArrayList localArrayList = new ArrayList();
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            Object localObject2 = (String)paramList.next();
            Face2FaceFriendInfo localFace2FaceFriendInfo = new Face2FaceFriendInfo();
            localFace2FaceFriendInfo.a = ((String)localObject2);
            localFace2FaceFriendInfo.c = 1;
            if (!this.c.c().contains(localFace2FaceFriendInfo))
            {
              localObject2 = ((FriendsManager)localObject1).b((String)localObject2);
              if ((localObject2 != null) && (((Friends)localObject2).isFriend()))
              {
                localFace2FaceFriendInfo.b = ((Friends)localObject2).getFriendNick();
                localArrayList.add(localFace2FaceFriendInfo);
              }
            }
          }
          if (localArrayList.size() > 0) {
            a(getBaseActivity().app.getCurrentUin(), localArrayList);
          }
        }
      }
    }
  }
  
  public void b()
  {
    if (!isDetached())
    {
      if (getBaseActivity() == null) {
        return;
      }
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.sendEmptyMessage(6);
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startFace2FaceAddContactHeartBeat delayTimeMs:");
      localStringBuilder.append(paramInt);
      QLog.d("Face2FaceAddContactFragment", 2, localStringBuilder.toString());
    }
    if ((this.a != null) && (getBaseActivity() != null) && (!getBaseActivity().isFinishing())) {
      this.a.sendEmptyMessageDelayed(301, paramInt);
    }
  }
  
  public void b(String paramString)
  {
    Intent localIntent;
    if (!isDetached())
    {
      if (getBaseActivity() == null) {
        return;
      }
      localIntent = new Intent(getBaseActivity(), QQBrowserActivity.class);
      localIntent.putExtra("uin", getBaseActivity().app.getCurrentUin());
      localIntent.putExtra("url", paramString);
    }
    try
    {
      getBaseActivity().startActivityForResult(localIntent, 1001);
      Face2FaceAddContactUtils.a("0X800AB65", "", "", "");
      return;
    }
    catch (SecurityException paramString) {}
  }
  
  public void c()
  {
    m();
  }
  
  public void d()
  {
    m();
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    k();
    l();
    this.b.a(getBaseActivity());
    j();
  }
  
  public void e()
  {
    if (!isDetached())
    {
      if (getBaseActivity() == null) {
        return;
      }
      p();
      QQToast.makeText(getBaseActivity(), getString(2131916700), 0).show();
    }
  }
  
  public void f()
  {
    if (!isDetached())
    {
      if (getBaseActivity() == null) {
        return;
      }
      p();
      QQToast.makeText(getBaseActivity(), getString(2131889151), 0).show();
      Face2FaceAddContactUtils.a("0X800AB64", "", "", "");
    }
  }
  
  public void g()
  {
    if (!isDetached())
    {
      if (getBaseActivity() == null) {
        return;
      }
      p();
      QQToast.makeText(getBaseActivity(), getString(2131917322), 0).show();
      StringBuffer localStringBuffer = this.I;
      if (localStringBuffer != null) {
        Face2FaceAddContactUtils.a("0X800AB5F", "", "", localStringBuffer.toString());
      }
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131624770;
  }
  
  public void h()
  {
    if (!isDetached())
    {
      if (getBaseActivity() == null) {
        return;
      }
      Handler localHandler = this.a;
      if (localHandler != null) {
        localHandler.sendEmptyMessage(5);
      }
    }
  }
  
  public void i()
  {
    this.D.setVisibility(0);
    this.d.setVisibility(8);
    this.q.setVisibility(8);
    Face2FaceAddContactUtils.a("0X800AB60", "", "", "");
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(2130771996, 2130771997);
  }
  
  protected boolean isTransparent()
  {
    return true;
  }
  
  public void j()
  {
    if (!Face2FaceAddContactUtils.c(getBaseActivity().app)) {
      return;
    }
    Face2FaceAddContactUtils.d(getBaseActivity().app);
    ReportDialog localReportDialog = new ReportDialog(getBaseActivity(), 2131953338);
    localReportDialog.setContentView(2131624051);
    Button localButton1 = (Button)localReportDialog.findViewById(2131431836);
    Button localButton2 = (Button)localReportDialog.findViewById(2131431840);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2130847912);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.b(170.0F, getResources());
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20200114/bd76e3d896aa49cd91e73aa332b1ff22.png", (URLDrawable.URLDrawableOptions)localObject);
    localReportDialog.findViewById(2131431905).setBackgroundDrawable((Drawable)localObject);
    localButton1.setOnClickListener(new Face2FaceAddContactFragment.3(this, localReportDialog));
    localButton2.setOnClickListener(new Face2FaceAddContactFragment.4(this, localReportDialog));
    localReportDialog.show();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder;
    if (QLog.isDebugVersion())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityResult resultCode:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" requestCode:");
      localStringBuilder.append(paramInt1);
      QLog.d("Face2FaceAddContactFragment", 2, localStringBuilder.toString());
    }
    if (paramInt1 != 1001)
    {
      if (paramInt1 != 1002) {
        return;
      }
      if (getBaseActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
        r();
      }
    }
    else
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        paramIntent = paramIntent.getStringExtra("ticket");
        if ((!TextUtils.isEmpty(this.I.toString())) && (this.I.length() == 4)) {
          this.b.a(getBaseActivity(), this.I.toString(), paramIntent);
        }
        if (QLog.isDebugVersion())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onActivityResult VERIFY_REQUEST_CODE, verifySig:");
          localStringBuilder.append(paramIntent);
          QLog.d("Face2FaceAddContactFragment", 2, localStringBuilder.toString());
        }
        Face2FaceAddContactUtils.a("0X800AB66", "", "", "");
        return;
      }
      if (paramInt2 == 0)
      {
        p();
        QQToast.makeText(getBaseActivity(), getString(2131889153), 0).show();
      }
    }
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((Face2FaceAddContactPresenter)localObject).b();
    }
    localObject = this.c;
    if (localObject != null) {
      Face2FaceAddContactUtils.a(this.J, ((Face2FaceAddContactAdapter)localObject).c());
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131429886)
    {
      if (i1 == 2131436211) {
        onBackEvent();
      }
    }
    else {
      n();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.b;
    if (localObject != null) {
      ((Face2FaceAddContactPresenter)localObject).a();
    }
    localObject = this.c;
    if (localObject != null) {
      ((Face2FaceAddContactAdapter)localObject).b();
    }
    localObject = this.a;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (getBaseActivity() != null) {
      getBaseActivity().overridePendingTransition(0, 2130771995);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((getBaseActivity() != null) && (this.K))
    {
      this.K = false;
      p();
      QQToast.makeText(getBaseActivity(), getString(2131889150), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment
 * JD-Core Version:    0.7.0.1
 */