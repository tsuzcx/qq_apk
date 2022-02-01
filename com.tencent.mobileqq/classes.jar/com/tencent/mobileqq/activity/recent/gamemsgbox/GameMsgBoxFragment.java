package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.RecentGameMsgBoxItem;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.RecentGameTabData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.sso.GameCenterUnissoObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.jetbrains.annotations.NotNull;

public class GameMsgBoxFragment
  extends IphoneTitleBarFragment
  implements GestureDetector.OnGestureListener, View.OnTouchListener, OnRecentUserOpsListener, DragFrameLayout.OnDragModeChangedListener, Observer
{
  protected BaseActivity a;
  private int b;
  private boolean c = true;
  private QQAppInterface d;
  private float e;
  private GestureDetector f;
  private XListView g;
  private SimpleSlidingIndicator h;
  private RecentAdapter i;
  private DragFrameLayout j;
  private TextView k;
  private String l;
  private GameMsgBoxOpenSyncView m;
  private GameSwitchConfig n;
  private GameMsgBoxBannerManager o;
  private GameCenterUnissoObserver p = new GameMsgBoxFragment.1(this, hashCode());
  
  @NotNull
  private RecentGameTabData a(int paramInt, IGameMsgBoxManager paramIGameMsgBoxManager, List<RecentGameTabData> paramList, List<RecentUser> paramList1)
  {
    paramList = (RecentGameTabData)paramList.get(paramInt - 1);
    this.l = paramList.a.k;
    if ((paramList.b != null) && (paramList.b.mSyncSwitch == 1))
    {
      ArrayList localArrayList = new ArrayList();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        Object localObject = (RecentUser)paramList1.next();
        GameDetailInfo localGameDetailInfo = paramIGameMsgBoxManager.findGameDetailInfoByConvertUin(((RecentUser)localObject).uin);
        if ((localGameDetailInfo != null) && (!TextUtils.isEmpty(localGameDetailInfo.c)) && (localGameDetailInfo.c.equals(paramList.a.c)))
        {
          localObject = new RecentGameMsgBoxItem((RecentUser)localObject);
          ((RecentGameMsgBoxItem)localObject).update(this.d, this.a);
          localArrayList.add(localObject);
        }
      }
      this.a.runOnUiThread(new GameMsgBoxFragment.10(this, localArrayList));
      return paramList;
    }
    paramIGameMsgBoxManager.updateRedPointShowState(false, paramList.a.c);
    this.h.e(paramInt);
    a(paramList.a.c);
    return paramList;
  }
  
  private void a(RecentBaseData paramRecentBaseData)
  {
    int i1;
    if ((paramRecentBaseData instanceof RecentGameMsgBoxItem))
    {
      RecentGameMsgBoxItem localRecentGameMsgBoxItem = (RecentGameMsgBoxItem)paramRecentBaseData;
      paramRecentBaseData = localRecentGameMsgBoxItem.e();
      i1 = localRecentGameMsgBoxItem.mPosition;
    }
    else
    {
      paramRecentBaseData = null;
      i1 = -1;
    }
    if (paramRecentBaseData != null) {
      RecentUtil.a(this.d, paramRecentBaseData, i1);
    }
  }
  
  private void a(String paramString)
  {
    ThreadManagerV2.excute(new GameMsgBoxFragment.4(this, paramString), 16, null, true);
  }
  
  private boolean a(int paramInt, List<RecentGameTabData> paramList, List<RecentUser> paramList1)
  {
    if (paramInt == 0)
    {
      if (paramList1.isEmpty())
      {
        a(((RecentGameTabData)paramList.get(0)).a.c);
      }
      else
      {
        paramList = new ArrayList();
        paramList1 = paramList1.iterator();
        while (paramList1.hasNext())
        {
          RecentGameMsgBoxItem localRecentGameMsgBoxItem = new RecentGameMsgBoxItem((RecentUser)paramList1.next());
          localRecentGameMsgBoxItem.update(this.d, this.a);
          paramList.add(localRecentGameMsgBoxItem);
        }
        this.a.runOnUiThread(new GameMsgBoxFragment.11(this, paramList));
      }
      this.l = this.a.getString(2131896918);
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", "145", "920", "92004", "209203", "", "", "7", "");
      return true;
    }
    return false;
  }
  
  private boolean a(List<RecentGameTabData> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      return false;
    }
    this.a.runOnUiThread(new GameMsgBoxFragment.12(this));
    return true;
  }
  
  private void c()
  {
    Object localObject = this.m;
    if (localObject != null) {
      ((GameMsgBoxOpenSyncView)localObject).setVisibility(8);
    }
    localObject = this.g;
    if (localObject != null) {
      ((XListView)localObject).setVisibility(0);
    }
  }
  
  private void d()
  {
    IGameMsgBoxManager localIGameMsgBoxManager = (IGameMsgBoxManager)this.d.getRuntimeService(IGameMsgBoxManager.class);
    if ((localIGameMsgBoxManager.isShowGameBoxTips()) && (!localIGameMsgBoxManager.isShowGameMsgUpgradingToast()))
    {
      TipsBar localTipsBar = new TipsBar(this.a);
      localTipsBar.setTipsIcon(this.a.getResources().getDrawable(2130839451));
      localTipsBar.setTipsText(HardCodeUtil.a(2131896920));
      localTipsBar.setBarType(2);
      localTipsBar.b(true);
      localTipsBar.setCloseListener(new GameMsgBoxFragment.3(this, localTipsBar));
      localTipsBar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      ((ViewGroup)this.mContentView).addView(localTipsBar, 0);
      localIGameMsgBoxManager.updateShowGameBoxTips(false);
    }
    if (localIGameMsgBoxManager.isShowGameMsgUpgradingToast())
    {
      QQToast.makeText(getContext(), 2131896925, 1).show();
      localIGameMsgBoxManager.updateShowGameMsgUpgradingToast(false);
    }
  }
  
  private void e()
  {
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this.mContentView, "pg_gb_message");
  }
  
  private void f()
  {
    ((IGameMsgBoxManager)this.d.getRuntimeService(IGameMsgBoxManager.class, "")).updateGameMsgBoxRecentUsers();
    h();
  }
  
  private void g()
  {
    this.h = ((SimpleSlidingIndicator)this.mContentView.findViewById(2131433999));
    this.h.setItemContentPaddingLR(Utils.a(14.0F, this.a.getResources()));
    m();
    View localView = this.mContentView.findViewById(2131433997);
    this.k = ((TextView)this.mContentView.findViewById(2131433995));
    if (ThemeUtil.isNowThemeIsNight(this.d, false, null))
    {
      localView.setBackgroundResource(2130846698);
      this.k.setTextColor(getResources().getColor(2131168122));
    }
    else
    {
      localView.setBackgroundResource(2130846697);
      this.k.setTextColor(getResources().getColor(2131167237));
    }
    this.h.setOnTabListener(new GameMsgBoxFragment.5(this, localView));
    this.h.setInterceptListener(new GameMsgBoxFragment.6(this, localView));
    this.h.setOnAddTabListener(new GameMsgBoxFragment.7(this));
    this.k.setOnClickListener(new GameMsgBoxFragment.8(this));
  }
  
  private void h()
  {
    Object localObject1 = (IGameMsgBoxManager)this.d.getRuntimeService(IGameMsgBoxManager.class);
    List localList = ((IGameMsgBoxManager)localObject1).getTitles();
    Object localObject2 = (IGameMsgManagerService)this.d.getRuntimeService(IGameMsgManagerService.class, "");
    if ((localList.size() == 0) && (((IGameMsgManagerService)localObject2).isGameMsgBlocked(getString(2131889881)))) {
      a(getString(2131889881));
    }
    localObject2 = new String[localList.size() + 1];
    Object localObject3 = this.a.getString(2131896918);
    int i1 = 0;
    localObject2[0] = localObject3;
    localObject3 = new boolean[localList.size()];
    while (i1 < localList.size())
    {
      Object localObject4 = (RecentGameTabData)localList.get(i1);
      GameDetailInfo localGameDetailInfo = ((RecentGameTabData)localObject4).a;
      localObject4 = ((RecentGameTabData)localObject4).b;
      int i2 = i1 + 1;
      localObject2[i2] = localGameDetailInfo.k;
      localObject3[i1] = ((IGameMsgBoxManager)localObject1).shouldShowRedPoint((GameSwitchConfig)localObject4);
      i1 = i2;
    }
    localObject1 = new int[localObject2.length];
    this.a.runOnUiThread(new GameMsgBoxFragment.9(this, (String[])localObject2, (int[])localObject1, (boolean[])localObject3, localList));
  }
  
  private void i()
  {
    if (ThemeUtil.isNowThemeIsNight(this.d, false, null))
    {
      this.mContentView.setBackgroundResource(2130838958);
      return;
    }
    this.mContentView.setBackgroundColor(-1);
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.e("GameMsgBoxFragment", 2, "initListView");
    }
    this.g = ((XListView)this.mContentView.findViewById(2131433998));
    this.g.setVisibility(0);
    View localView = this.o.a();
    if (localView != null) {
      this.g.addHeaderView(localView);
    }
    localView = View.inflate(this.a, 2131624518, null);
    this.g.addFooterView(localView);
    this.i = new RecentAdapter(this.a, this.d, this.g, this, 17);
    this.g.setAdapter(this.i);
    VideoReport.setElementId(this.g, "em_gb_message_list");
    if (this.j == null)
    {
      this.j = DragFrameLayout.a(this.a);
      this.j.a(this, false);
    }
    this.i.a(this.j);
  }
  
  private void k()
  {
    int i1 = this.h.getCurrentPosition();
    int i3 = 0;
    int i2 = 0;
    if (i1 == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Object localObject;
    if (ThemeUtil.isNowThemeIsNight(this.d, false, null))
    {
      this.k.setTextColor(-1);
      localObject = this.k;
      if (i1 != 0) {
        i2 = 2130846692;
      }
      ((TextView)localObject).setBackgroundResource(i2);
    }
    else
    {
      localObject = this.k;
      i2 = i3;
      if (i1 != 0) {
        i2 = 2130846693;
      }
      ((TextView)localObject).setBackgroundResource(i2);
      if (i1 != 0) {
        localObject = "#00CAFC";
      } else {
        localObject = "#878B99";
      }
      this.k.setTextColor(Color.parseColor((String)localObject));
    }
    this.k.setTypeface(Typeface.defaultFromStyle(i1));
  }
  
  private void l()
  {
    setTitle(this.a.getString(2131896924));
    this.vg.setRightButton2(2131896921);
    VideoReport.setPageId(this.vg, "pg_gb_message");
    VideoReport.setElementId(this.vg.getRightViewText2(), "em_gb_set");
    VideoReport.setElementExposePolicy(this.vg.getRightViewText2(), ExposurePolicy.REPORT_ALL);
    this.vg.getRightViewText2().setOnClickListener(new GameMsgBoxFragment.13(this));
    boolean bool = ((Boolean)BaseSharedPreUtil.a(this.d.getApp(), this.d.getCurrentAccountUin(), "key_game_msg_box_setting_red_dot", Boolean.valueOf(true))).booleanValue();
    this.vg.updateRedDot(3, bool);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initTitleBar showRedDot = ");
    localStringBuilder.append(bool);
    QLog.d("GameMsgBoxFragment", 1, localStringBuilder.toString());
  }
  
  private void m()
  {
    boolean bool1 = ThemeUtil.isNowThemeIsNight(this.d, false, null);
    boolean bool2 = QQTheme.isNowSimpleUI();
    int i2 = 2131168002;
    int i4 = 2131168122;
    int i3 = 25;
    int i1;
    if (bool2)
    {
      i2 = 2131168001;
      if (bool1) {
        i1 = 2131167341;
      } else {
        i1 = 2131167340;
      }
      i3 = 255;
    }
    else if (bool1)
    {
      i3 = 76;
      i1 = 2131166125;
      i2 = 2131168464;
      i4 = 2131168464;
    }
    else if (!ThemeUtil.isNowThemeIsDefaultCache(this.d, true))
    {
      i1 = 2131168002;
    }
    else
    {
      i1 = 2131165916;
      i2 = 2131165916;
    }
    this.h.c(i3);
    this.h.a(i2, i4, i1);
  }
  
  public boolean a()
  {
    return this.b == 0;
  }
  
  public boolean a(int paramInt)
  {
    return (!b()) && ((this.b & paramInt) == paramInt);
  }
  
  public void b(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != -1))
    {
      this.b = (paramInt | this.b & (paramInt ^ 0xFFFFFFFF));
      return;
    }
    this.b = paramInt;
  }
  
  public boolean b()
  {
    return this.b == -1;
  }
  
  protected void c(int paramInt)
  {
    Object localObject = (IGameMsgBoxManager)this.d.getRuntimeService(IGameMsgBoxManager.class);
    List localList1 = ((IGameMsgBoxManager)localObject).getTitles();
    if (a(localList1)) {
      return;
    }
    List localList2 = ((IGameMsgBoxManager)localObject).getAllOpenSyncRecentUserList();
    if (a(paramInt, localList1, localList2)) {
      return;
    }
    localObject = a(paramInt, (IGameMsgBoxManager)localObject, localList1, localList2);
    if ((localObject != null) && (((RecentGameTabData)localObject).a != null)) {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(((RecentGameTabData)localObject).a.c, "1", "145", "920", "92004", "209203", "", "", "7", "");
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    GestureDetector localGestureDetector = this.f;
    if ((localGestureDetector != null) && (localGestureDetector.onTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @android.support.annotation.Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.e = (ViewConfiguration.get(getBaseActivity()).getScaledDoubleTapSlop() * 2);
    this.f = new GestureDetector(this.a, this);
    e();
    i();
    j();
    g();
    l();
    d();
    this.d.getMessageFacade().addObserver(this);
    this.d.addObserver(this.p);
    ((IGameMsgManagerService)this.d.getRuntimeService(IGameMsgManagerService.class)).addUserInfoChangedObserver(this.p);
    paramLayoutInflater = (IGameMsgBoxManager)this.d.getRuntimeService(IGameMsgBoxManager.class);
    paramLayoutInflater.tryUpdateGameMsgInfoFromRecentUser();
    paramLayoutInflater.fetchRecentGameContacts(false, new GameMsgBoxFragment.2(this));
    this.o.a(this.mContentView);
    this.o.b();
  }
  
  protected int getContentLayoutId()
  {
    return 2131624889;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needDispatchTouchEvent()
  {
    return true;
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout) {}
  
  public void onClick(View paramView, Object paramObject) {}
  
  public void onCreate(@androidx.annotation.Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = getBaseActivity();
    this.d = getBaseActivity().app;
    this.l = this.a.getString(2131896918);
    this.o = new GameMsgBoxBannerManager(this.d, this.a);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.d.getMessageFacade() != null) {
      this.d.getMessageFacade().deleteObserver(this);
    }
    ((IGameMsgManagerService)this.d.getRuntimeService(IGameMsgManagerService.class)).removeUserInfoChangedObserver(this.p);
    this.d.removeObserver(this.p);
    Object localObject = this.i;
    if (localObject != null)
    {
      ((RecentAdapter)localObject).h();
      this.i = null;
    }
    localObject = this.g;
    if (localObject != null) {
      ((XListView)localObject).setAdapter(null);
    }
    localObject = this.j;
    if (localObject != null) {
      ((DragFrameLayout)localObject).a(this);
    }
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    b(0);
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!a())
    {
      if (b()) {
        return false;
      }
      if (paramMotionEvent1 != null)
      {
        if (paramMotionEvent2 == null) {
          return false;
        }
        paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
        paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
        if (a(1))
        {
          if ((paramFloat1 < 0.0F) && (paramFloat2 < 0.5F))
          {
            b(-1);
            if (this.c)
            {
              getBaseActivity().finish();
              return true;
            }
            this.c = true;
            return false;
          }
        }
        else if ((a(2)) && (paramFloat1 > 0.0F) && (paramFloat2 < 0.5F))
        {
          b(-1);
          this.c = false;
        }
      }
    }
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public void onMenuItemClick(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append(" data ");
      paramString2.append(paramRecentBaseData);
      QLog.d("GameMsgBoxFragment", 2, new Object[] { "menuItem clicked ", paramString1, paramString2.toString(), " uin ", paramRecentBaseData.getRecentUserUin(), " type ", Integer.valueOf(paramRecentBaseData.getRecentUserType()) });
    }
    paramString2 = (IGameMsgBoxManager)this.d.getRuntimeService(IGameMsgBoxManager.class, "");
    if (Utils.a(paramString1, getResources().getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.c[3]))) {
      paramString2.updateIsTop(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType(), true);
    } else if (Utils.a(paramString1, getResources().getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.c[2]))) {
      paramString2.updateIsTop(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType(), false);
    }
    f();
  }
  
  public void onPause()
  {
    super.onPause();
    ((IGameMsgBoxRuntimeService)this.d.getRuntimeService(IGameMsgBoxRuntimeService.class, "")).setBoxRead(true);
  }
  
  public void onRecentBaseDataClick(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    if ((paramRecentBaseData instanceof RecentGameMsgBoxItem))
    {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).enterGameMsgChatPie(this.d, this.a, paramRecentBaseData.getRecentUserUin(), 5);
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportClickItemInGameMsgBox883(this.d, paramRecentBaseData.getRecentUserUin());
    }
  }
  
  public void onRecentBaseDataDelete(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    a(paramRecentBaseData);
    f();
    if (((IGameMsgBoxManager)this.d.getRuntimeService(IGameMsgBoxManager.class, "")).getTitles().isEmpty())
    {
      paramRecentBaseData = this.d.getRecentUserProxy().b(AppConstants.GAME_MSG_BOX_UIN, 10015);
      this.d.getRecentUserProxy().a(paramRecentBaseData, false);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    f();
    ((IGameMsgBoxRuntimeService)this.d.getRuntimeService(IGameMsgBoxRuntimeService.class, "")).setBoxRead(true);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (b()) {
      return false;
    }
    if (paramMotionEvent1 != null)
    {
      if (paramMotionEvent2 == null) {
        return false;
      }
      paramFloat2 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      float f1 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat2);
      if (a())
      {
        if (Math.abs(paramFloat2) > this.e)
        {
          if ((paramFloat1 < 0.0F) && (f1 < 0.5F))
          {
            b(1);
            return true;
          }
          if ((paramFloat1 > 0.0F) && (f1 < 0.5F))
          {
            b(2);
            return true;
          }
        }
      }
      else if (a(1))
      {
        if ((paramFloat1 > 0.0F) || (f1 >= 0.5F))
        {
          b(-1);
          return false;
        }
      }
      else if ((a(2)) && ((paramFloat1 < 0.0F) || (f1 >= 0.5F))) {
        b(-1);
      }
    }
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    b(-1);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.f;
    return (paramView != null) && (paramView.onTouchEvent(paramMotionEvent));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameMsgBoxFragment", 2, new Object[] { "updateMsg called ", paramObject });
    }
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment
 * JD-Core Version:    0.7.0.1
 */