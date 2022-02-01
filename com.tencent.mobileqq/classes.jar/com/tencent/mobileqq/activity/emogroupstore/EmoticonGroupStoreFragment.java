package com.tencent.mobileqq.activity.emogroupstore;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emosm.api.IEmoticonFromGroupDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class EmoticonGroupStoreFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private AlphaAnimation A;
  private View B;
  private View C;
  private TranslateAnimation D;
  private TranslateAnimation E;
  private volatile boolean F = false;
  private volatile boolean G = false;
  private Map<String, List<EmoticonFromGroupEntity>> H;
  private List<FilterAdapter.FilterItemContent> I;
  private ListView J;
  private FilterAdapter K;
  private TextView L;
  private Button M;
  private Button N;
  private List<String> O = new ArrayList();
  private View P;
  private List<String> Q = new ArrayList();
  private Map<String, FilterAdapter.FilterItemContent> R;
  private Button S;
  private IEmoticonFromGroupManager T;
  private View.OnClickListener U = new EmoticonGroupStoreFragment.10(this);
  public List<EmoticonFromGroupEntity> a = new ArrayList();
  SVIPObserver b = new EmoticonGroupStoreFragment.1(this);
  TopGestureLayout c;
  private BaseActivity d;
  private QQAppInterface e;
  private TextView f;
  private RecyclerView g;
  private PicSelectAdapter h;
  private StringBuilder i = new StringBuilder("    ");
  private SpannableString j;
  private Button k;
  private RelativeLayout l;
  private Button m;
  private List<EmoticonFromGroupEntity> n = new CopyOnWriteArrayList();
  private List<EmoticonFromGroupEntity> o = new CopyOnWriteArrayList();
  private View p;
  private View q;
  private View r;
  private ViewPager s;
  private View t;
  private View u;
  private Button v;
  private Button w;
  private TextView x;
  private View y;
  private AlphaAnimation z;
  
  private void a(List<EmoticonFromGroupEntity> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)paramList.next();
      if (localEmoticonFromGroupEntity != null) {
        if (localEmoticonFromGroupEntity.msg == null)
        {
          MessageForPic localMessageForPic = (MessageForPic)this.T.f(localEmoticonFromGroupEntity);
          if (localMessageForPic != null)
          {
            localEmoticonFromGroupEntity.msg = localMessageForPic;
            this.n.add(localEmoticonFromGroupEntity);
          }
          else
          {
            this.T.b(localEmoticonFromGroupEntity);
            this.T.a(localEmoticonFromGroupEntity);
          }
        }
        else
        {
          this.n.add(localEmoticonFromGroupEntity);
        }
      }
    }
  }
  
  private void b(List<EmoticonFromGroupEntity> paramList)
  {
    Object localObject1 = (IFavroamingDBManagerService)this.e.getRuntimeService(IFavroamingDBManagerService.class);
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Fragment", 2, "call getEmoticonDataList from EmoticonGroupStoreFragment.filterFavEmo");
    }
    Object localObject2 = ((IFavroamingDBManagerService)localObject1).getEmoticonDataList();
    localObject1 = new ArrayList();
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      int i1 = 0;
      while (i1 < ((List)localObject2).size())
      {
        if ((TextUtils.isEmpty(((CustomEmotionData)((List)localObject2).get(i1)).RomaingType)) || (!"needDel".equals(((CustomEmotionData)((List)localObject2).get(i1)).RomaingType))) {
          ((List)localObject1).add(((List)localObject2).get(i1));
        }
        i1 += 1;
      }
    }
    localObject2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)paramList.next();
      if (this.T.a((List)localObject1, localEmoticonFromGroupEntity.bigURL))
      {
        localEmoticonFromGroupEntity.status = 0;
        ((List)localObject2).add(localEmoticonFromGroupEntity);
      }
    }
    this.o.addAll((Collection)localObject2);
  }
  
  private void c()
  {
    this.f = ((TextView)this.mContentView.findViewById(2131448939));
    this.g = ((RecyclerView)this.mContentView.findViewById(2131440282));
    this.k = ((Button)this.mContentView.findViewById(2131429879));
    this.l = ((RelativeLayout)this.mContentView.findViewById(2131434418));
    this.m = ((Button)this.mContentView.findViewById(2131429904));
    this.k.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.p = LayoutInflater.from(this.titleRoot.getContext()).inflate(2131628324, this.titleRoot, false);
    this.q = this.p.findViewById(2131432417);
    this.r = this.p.findViewById(2131432418);
    this.s = ((ViewPager)this.p.findViewById(2131432419));
    this.t = this.p.findViewById(2131429877);
    this.u = this.p.findViewById(2131429878);
    this.v = ((Button)this.p.findViewById(2131429906));
    this.w = ((Button)this.p.findViewById(2131429905));
    this.q.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.w.setOnClickListener(this);
    Object localObject = new LinearLayoutManager(this.d, 1, false);
    ((LinearLayoutManager)localObject).setRecycleChildrenOnDetach(true);
    this.g.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.x = ((TextView)this.mContentView.findViewById(2131448929));
    this.y = new View(this.titleRoot.getContext());
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.y.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.y.setBackgroundColor(Color.parseColor(getString(2131165580)));
    try
    {
      this.B = LayoutInflater.from(this.titleRoot.getContext()).inflate(2131628319, this.titleRoot, false);
      this.C = this.B.findViewById(2131433171);
      this.C.setOnClickListener(this);
      this.J = ((ListView)this.B.findViewById(2131437780));
      this.J.setOnItemClickListener(new EmoticonGroupStoreFragment.2(this));
      this.K = new FilterAdapter(this.d);
      this.J.setAdapter(this.K);
      this.L = ((TextView)this.B.findViewById(2131448936));
      this.M = ((Button)this.B.findViewById(2131429890));
      this.N = ((Button)this.B.findViewById(2131429889));
      this.M.setOnClickListener(this);
      this.N.setOnClickListener(this);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label552:
      break label552;
    }
    QLog.e("EmoticonFromGroup_Fragment", 2, "oom error occur!");
    this.P = this.mContentView.findViewById(2131434419);
    ((URLImageView)this.P.findViewById(2131435565)).setImageDrawable(URLDrawable.getDrawable("https://imgcache.gtimg.cn/ACT/svip_act/act_img/public/201802/m1517913373_empty_img_1.png"));
    this.S = new Button(this.d);
    this.S.setId(2131446656);
    localObject = new RelativeLayout.LayoutParams(ScreenUtil.dip2px(21.0F), ScreenUtil.dip2px(20.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = 8;
    this.S.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.vg.addView(this.S);
  }
  
  private void c(List<EmoticonFromGroupEntity> paramList)
  {
    int i2;
    if (paramList == null) {
      i2 = 0;
    } else {
      i2 = paramList.size();
    }
    if ((getBaseActivity() != null) && (i2 != 0))
    {
      ArrayList localArrayList = new ArrayList();
      String str = String.format(getString(2131890176), new Object[] { Integer.valueOf(i2) });
      int i1 = 3;
      if (i2 < 3) {
        i1 = paramList.size();
      }
      i2 = 0;
      while (i2 < i1)
      {
        URLDrawable localURLDrawable = (URLDrawable)this.T.a((EmoticonFromGroupEntity)paramList.get(i2), 65537, ScreenUtil.dip2px(11.0F), null);
        int i3 = i2 + 1;
        i2 = i3;
        if (localURLDrawable != null)
        {
          localArrayList.add(localURLDrawable);
          this.i.append(" ");
          i2 = i3;
          if (1 != localURLDrawable.getStatus())
          {
            localURLDrawable.startDownload();
            localURLDrawable.setURLDrawableListener(new EmoticonGroupStoreFragment.9(this));
            i2 = i3;
          }
        }
      }
      paramList = new StringBuilder();
      paramList.append(this.i);
      paramList.append(str);
      this.j = new SpannableString(paramList.toString());
      paramList = new OverlapDrawable(this.e);
      paramList.a(localArrayList, ScreenUtil.dip2px(11.0F));
      paramList.setBounds(0, 0, ScreenUtil.dip2px(33.0F), ScreenUtil.dip2px(22.0F));
      this.j.setSpan(new ImageSpan(paramList, 0), 0, this.i.length() - 4, 17);
      this.f.setTextSize(14.0F);
      this.f.setTextColor(Color.parseColor("#FF777777"));
      this.f.setText(this.j);
    }
  }
  
  private void d()
  {
    this.leftView.setVisibility(0);
    this.leftView.setText(2131890177);
    this.leftView.setTextColor(getResources().getColor(2131165564));
    this.leftView.setBackgroundDrawable(getResources().getDrawable(2130841082));
    this.centerView.setTextColor(getResources().getColor(2131165564));
    this.S.setBackgroundResource(2130840621);
    this.S.setOnClickListener(this);
    this.z = new AlphaAnimation(0.0F, 1.0F);
    this.z.setFillAfter(true);
    this.z.setDuration(500L);
    this.A = new AlphaAnimation(1.0F, 0.0F);
    this.A.setFillAfter(true);
    this.A.setDuration(500L);
    this.D = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
    this.D.setFillAfter(true);
    this.D.setDuration(500L);
    this.E = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.E.setAnimationListener(new EmoticonGroupStoreFragment.3(this));
    this.E.setFillAfter(true);
    this.E.setDuration(500L);
    e();
    this.l.setVisibility(8);
    this.P.setVisibility(8);
  }
  
  private void e()
  {
    this.h = new PicSelectAdapter(this.e, this, this.T.a(), this.p, this.s, this.m);
    this.g.setAdapter(this.h);
    this.g.setOnScrollListener(new EmoticonGroupStoreFragment.4(this));
  }
  
  private void f()
  {
    ThreadManager.post(new EmoticonGroupStoreFragment.5(this), 5, null, true);
  }
  
  private void g()
  {
    ThreadManager.getUIHandler().post(new EmoticonGroupStoreFragment.6(this));
  }
  
  private void h()
  {
    ThreadManager.getUIHandler().post(new EmoticonGroupStoreFragment.7(this));
  }
  
  private void i()
  {
    ThreadManager.getUIHandler().post(new EmoticonGroupStoreFragment.8(this));
  }
  
  private void j()
  {
    ConcurrentHashMap localConcurrentHashMap1 = new ConcurrentHashMap();
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    ConcurrentHashMap localConcurrentHashMap2 = new ConcurrentHashMap();
    Object localObject1 = this.n.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EmoticonFromGroupEntity)((Iterator)localObject1).next();
      if (localConcurrentHashMap1.containsKey(((EmoticonFromGroupEntity)localObject2).troopUin))
      {
        ((List)localConcurrentHashMap1.get(((EmoticonFromGroupEntity)localObject2).troopUin)).add(localObject2);
      }
      else
      {
        localObject3 = new ArrayList();
        ((List)localObject3).add(localObject2);
        localConcurrentHashMap1.put(((EmoticonFromGroupEntity)localObject2).troopUin, localObject3);
      }
    }
    Object localObject3 = localConcurrentHashMap1.entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
      FilterAdapter.FilterItemContent localFilterItemContent = new FilterAdapter.FilterItemContent();
      EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)((List)localEntry.getValue()).get(0);
      int i1 = localEmoticonFromGroupEntity.fromType;
      localObject2 = null;
      if (1 == i1)
      {
        localObject2 = this.e.getFaceBitmap(4, localEmoticonFromGroupEntity.troopUin, (byte)2, false, (byte)1, 0);
        localObject1 = ContactUtils.a(this.e, localEmoticonFromGroupEntity.troopUin, true);
      }
      else if (3000 == localEmoticonFromGroupEntity.fromType)
      {
        localObject2 = this.e.getFaceBitmap(101, localEmoticonFromGroupEntity.troopUin, (byte)3, false, (byte)1, 0);
        localObject1 = ContactUtils.a(this.e, this.d, localEmoticonFromGroupEntity.troopUin);
      }
      else
      {
        localObject1 = null;
      }
      localFilterItemContent.a = localEmoticonFromGroupEntity.troopUin;
      localFilterItemContent.b = ((Bitmap)localObject2);
      localFilterItemContent.e = false;
      localFilterItemContent.c = ((String)localObject1);
      localFilterItemContent.d = ((List)localEntry.getValue()).size();
      localCopyOnWriteArrayList.add(localFilterItemContent);
      localConcurrentHashMap2.put(localFilterItemContent.a, localFilterItemContent);
    }
    this.H = localConcurrentHashMap1;
    this.I = localCopyOnWriteArrayList;
    this.R = localConcurrentHashMap2;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(new EmoticonGroupStoreFragment.11(this));
      return;
    }
    this.K.a(this.I);
    this.K.notifyDataSetChanged();
    localObject1 = this.L;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131902093));
    ((StringBuilder)localObject2).append(this.n.size());
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131902105));
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
  }
  
  private void k()
  {
    if ((this.B != null) && (this.titleRoot == this.B.getParent()) && (this.titleRoot == this.B.getParent()))
    {
      this.y.startAnimation(this.A);
      this.B.startAnimation(this.E);
    }
  }
  
  private void l()
  {
    Iterator localIterator = this.I.iterator();
    while (localIterator.hasNext()) {
      ((FilterAdapter.FilterItemContent)localIterator.next()).e = false;
    }
    if (!this.O.isEmpty()) {
      this.O.clear();
    }
  }
  
  private void m()
  {
    this.S.setBackgroundResource(2130840621);
    this.S.setEnabled(true);
  }
  
  private void n()
  {
    this.S.setBackgroundResource(2130840622);
    this.S.setEnabled(false);
  }
  
  void a()
  {
    if (getTitleBarView() != null)
    {
      getTitleBarView().setBackgroundResource(0);
      getTitleBarView().setBackgroundColor(-1);
    }
    Object localObject = this.d;
    if ((localObject != null) && ((localObject instanceof PublicFragmentActivity)))
    {
      localObject = ((PublicFragmentActivity)localObject).mSystemBarComp;
      if ((localObject != null) && (needImmersive()) && (needStatusTrans()) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        if (ThemeUtil.isInNightMode(this.d.getAppRuntime()))
        {
          if ((!SystemUtil.d()) && (!SystemUtil.g()))
          {
            ((SystemBarCompact)localObject).setStatusBarColor(-7829368);
            return;
          }
          ((SystemBarCompact)localObject).setStatusBarColor(-7829368);
          ((SystemBarCompact)localObject).setStatusBarDarkMode(true);
          return;
        }
        if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
        {
          this.d.getWindow().getDecorView().setSystemUiVisibility(9216);
          ((SystemBarCompact)localObject).setStatusBarColor(-1);
          return;
        }
        if (!SystemUtil.g())
        {
          ((SystemBarCompact)localObject).setStatusBarColor(-2368549);
          return;
        }
        ((SystemBarCompact)localObject).setStatusBarColor(-1);
        ((SystemBarCompact)localObject).setStatusBarDarkMode(true);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.c == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getBaseActivity().getWindow().getDecorView();
      localObject = null;
      int i1 = 0;
      while (i1 < localViewGroup.getChildCount())
      {
        View localView = localViewGroup.getChildAt(i1);
        localObject = localView;
        if ((localView instanceof DragFrameLayout)) {
          localObject = ((DragFrameLayout)localView).getChildAt(0);
        }
        if ((localObject instanceof TopGestureLayout)) {
          break;
        }
        i1 += 1;
      }
      if ((localObject != null) && ((localObject instanceof TopGestureLayout))) {
        this.c = ((TopGestureLayout)localObject);
      }
    }
    Object localObject = this.c;
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
    }
  }
  
  protected void b()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity != null) {
      localBaseActivity.finish();
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131628322;
  }
  
  protected void init(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonFromGroup_Fragment", 2, "emoticonFromGroupFragment init start.");
    }
    super.init(paramBundle);
    super.setTitle(HardCodeUtil.a(2131902094));
    paramBundle = getBaseActivity();
    if (paramBundle != null)
    {
      this.d = paramBundle;
    }
    else
    {
      QLog.e("EmoticonFromGroup_Fragment", 1, "activity is null");
      b();
    }
    paramBundle = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((paramBundle instanceof QQAppInterface))
    {
      this.e = ((QQAppInterface)paramBundle);
    }
    else
    {
      QLog.e("EmoticonFromGroup_Fragment", 1, "app is null");
      b();
    }
    this.T = ((VasExtensionManager)paramBundle.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).d;
    paramBundle = (IFavroamingManagerService)paramBundle.getRuntimeService(IFavroamingManagerService.class, "");
    if (paramBundle != null) {
      paramBundle.syncRoaming();
    }
    this.e.addObserver(this.b);
    c();
    d();
    f();
    VasWebviewUtil.a("", "QLbq", "PageView", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonFromGroup_Fragment", 2, "emoticonFromGroupFragment init end.");
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 0))
    {
      Intent localIntent = AIOUtils.a(new Intent(this.d, SplashActivity.class), null);
      paramIntent = new Bundle(paramIntent.getExtras());
      paramIntent.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
      paramIntent.putBoolean("PhotoConst.IS_FORWARD", true);
      paramIntent.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
      paramIntent.putBoolean("PicContants.NEED_COMPRESS", false);
      localIntent.putExtras(paramIntent);
      String str = paramIntent.getString("GALLERY.FORWORD_LOCAL_PATH");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(str);
      paramInt1 = paramIntent.getInt("PhotoConst.SEND_SIZE_SPEC", 0);
      PhotoUtils.sendPhoto(this.d, localIntent, localArrayList, paramInt1, true);
    }
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.h;
    if ((localObject != null) && (((PicSelectAdapter)localObject).a))
    {
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EmoticonFromGroupEntity)((Iterator)localObject).next()).status = -1;
      }
      this.a.clear();
      this.l.setVisibility(8);
      this.k.setVisibility(0);
      localObject = this.h;
      ((PicSelectAdapter)localObject).a = false;
      ((PicSelectAdapter)localObject).a(false);
      this.h.notifyDataSetChanged();
      m();
      a(true);
      resetLeftButton();
      return true;
    }
    if (this.titleRoot == this.p.getParent())
    {
      this.titleRoot.removeView(this.p);
      a(true);
      return true;
    }
    if (this.F)
    {
      l();
      k();
      VasWebviewUtil.a("", "QLbq", "ClickFilterReturn", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return true;
    }
    b();
    return false;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131446656: 
      if (this.B == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("EmoticonFromGroup_Fragment", 2, "click right img useless, filterView is null.");
        }
      }
      else
      {
        a(false);
        this.F = true;
        if (this.titleRoot != this.y.getParent()) {
          this.titleRoot.addView(this.y);
        }
        if (this.titleRoot != this.B.getParent()) {
          this.titleRoot.addView(this.B);
        }
        this.y.startAnimation(this.z);
        this.B.startAnimation(this.D);
        localObject1 = this.Q.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          this.O.add(localObject2);
          ((FilterAdapter.FilterItemContent)this.R.get(localObject2)).e = true;
        }
        if (!this.G)
        {
          this.G = true;
          j();
        }
        VasWebviewUtil.a("", "QLbq", "ClickFilter", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      }
      break;
    case 2131433171: 
      l();
      k();
      VasWebviewUtil.a("", "QLbq", "ClickFilterReturn", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      break;
    case 2131432417: 
      if (this.titleRoot == this.p.getParent())
      {
        AbstractGifImage.pauseAll();
        this.titleRoot.removeView(this.p);
        a(true);
      }
      break;
    case 2131429906: 
      localObject1 = ((ImgPreviewAdapter)this.s.getAdapter()).a(this.s.getCurrentItem());
      if ((localObject1 != null) && (((EmoticonFromGroupEntity)localObject1).msg != null)) {
        AIOGalleryScene.b(new AIORichMediaInfo(AIOGalleryUtils.a(((EmoticonFromGroupEntity)localObject1).msg)), this.d, 0);
      } else {
        QLog.e("EmoticonFromGroup_Fragment.msgnull", 1, "preview send msg is null.");
      }
      VasWebviewUtil.a("", "QLbq", "SendFriend", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      break;
    case 2131429905: 
      localObject1 = ((ImgPreviewAdapter)this.s.getAdapter()).a(this.s.getCurrentItem());
      if (this.T.d((EmoticonFromGroupEntity)localObject1))
      {
        this.o.add(localObject1);
        this.w.setText(HardCodeUtil.a(2131902085));
        this.w.setTextColor(Color.parseColor("#FFBBBBBB"));
        this.w.setBackgroundDrawable(getResources().getDrawable(2130845843));
        this.w.setEnabled(false);
        this.h.notifyDataSetChanged();
      }
      if (localObject1 != null) {
        EmoticonOperateReport.reportFavAddEmotionEvent(this.e, 4, ((EmoticonFromGroupEntity)localObject1).md5, null);
      }
      VasWebviewUtil.a("", "QLbq", "Addbq", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
      break;
    case 2131429904: 
      this.k.setVisibility(0);
      this.l.setVisibility(8);
      this.h.a(false);
      this.h.a = false;
      this.o.addAll(this.a);
      this.T.e(new ArrayList(this.a));
      localObject1 = this.a.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((EmoticonFromGroupEntity)((Iterator)localObject1).next()).status = 0;
      }
      localObject1 = (IEmoticonFromGroupDBManagerService)this.e.getRuntimeService(IEmoticonFromGroupDBManagerService.class);
      ((IEmoticonFromGroupDBManagerService)localObject1).setCountOfSpare(((IEmoticonFromGroupDBManagerService)localObject1).getCountOfSpare() - this.a.size());
      this.a.clear();
      this.h.notifyDataSetChanged();
      m();
      a(true);
      resetLeftButton();
      VasWebviewUtil.a("", "QLbq", "AddMutibq", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      break;
    case 2131429890: 
      l();
      this.K.notifyDataSetChanged();
      VasWebviewUtil.a("", "QLbq", "ClickFilterReset", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      break;
    case 2131429889: 
      if (!this.Q.isEmpty()) {
        this.Q.clear();
      }
      int i1 = this.O.size();
      if (i1 == 0)
      {
        localObject1 = new ArrayList(this.n);
        localObject2 = this.T.b((List)localObject1);
        if (localObject2 != null)
        {
          c((List)localObject1);
          this.h.a((Map)localObject2, (List)localObject1);
        }
      }
      else
      {
        localObject1 = new ArrayList();
        localObject2 = this.O.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          this.Q.add(str);
          ((List)localObject1).addAll((Collection)this.H.get(str));
        }
        Collections.sort((List)localObject1);
        localObject2 = this.T.b((List)localObject1);
        if (localObject2 != null)
        {
          c((List)localObject1);
          this.h.a((Map)localObject2, (List)localObject1);
        }
      }
      l();
      k();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(i1);
      VasWebviewUtil.a("", "QLbq", "ClickFilterConfirm", "0", 1, 0, 0, "", "", ((StringBuilder)localObject1).toString(), "", "", "", "", 0, 0, 0, 0);
      break;
    case 2131429879: 
      if (this.x.getVisibility() == 0) {
        this.x.setVisibility(8);
      }
      n();
      a(false);
      setLeftButton(HardCodeUtil.a(2131898212), this.U);
      this.leftViewNotBack.setTextColor(getResources().getColor(2131165564));
      this.k.setVisibility(8);
      this.m.setTextColor(Color.parseColor("#FFBFBFBF"));
      this.m.setBackgroundDrawable(getResources().getDrawable(2130845843));
      this.m.setEnabled(false);
      this.l.setVisibility(0);
      this.h.a(true);
      localObject1 = this.h;
      ((PicSelectAdapter)localObject1).a = true;
      ((PicSelectAdapter)localObject1).notifyDataSetChanged();
      VasWebviewUtil.a("", "QLbq", "ClickMutiSel", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      break;
    case 2131429878: 
      this.s.arrowScroll(66);
      VasWebviewUtil.a("", "QLbq", "SwitchPreview", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      break;
    case 2131429877: 
      this.s.arrowScroll(17);
      VasWebviewUtil.a("", "QLbq", "SwitchPreview", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.a.clear();
    this.T.c(this.o);
    this.T.d(this.o);
    MqqHandler localMqqHandler = this.e.getHandler(ChatActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10).sendToTarget();
    }
    this.e.removeObserver(this.b);
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    a();
    AbstractGifImage.resumeAll();
    Object localObject = this.h;
    if (localObject != null) {
      ((PicSelectAdapter)localObject).notifyDataSetChanged();
    }
    if (this.w != null)
    {
      localObject = this.s;
      if (localObject != null)
      {
        localObject = ((ImgPreviewAdapter)((ViewPager)localObject).getAdapter()).a(this.s.getCurrentItem());
        if (localObject != null)
        {
          if (((EmoticonFromGroupEntity)localObject).status == 0)
          {
            this.w.setText(HardCodeUtil.a(2131902126));
            this.w.setTextColor(Color.parseColor("#FFBBBBBB"));
            this.w.setBackgroundDrawable(getResources().getDrawable(2130845843));
            this.w.setEnabled(false);
            return;
          }
          this.w.setText(HardCodeUtil.a(2131902089));
          this.w.setTextColor(Color.parseColor("#FFFFFFFF"));
          this.w.setBackgroundDrawable(getResources().getDrawable(2130845842));
          this.w.setEnabled(true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment
 * JD-Core Version:    0.7.0.1
 */