package com.tencent.avgame.gameroom.seat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo.PKDrawRes;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadUtil;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
import com.tencent.avgame.gameroom.overlay.IOverlayPresenter;
import com.tencent.avgame.gameroom.seat.background.ISurvivalSeatBgPresenter;
import com.tencent.avgame.gameroom.seat.background.SurvivalSeatBgView;
import com.tencent.avgame.ui.RoundEmptyRectRelativeLayout;
import com.tencent.avgame.ui.RoundEmptyRectRelativeLayout.ClipRoundRect;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheet.OnDismissListener;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PkSeatView
  extends RoundEmptyRectRelativeLayout
  implements View.OnClickListener, ISeatView, ActionSheet.OnButtonClickListener, ActionSheet.OnDismissListener
{
  private Handler A = new Handler(new PkSeatView.4(this));
  protected ISeatPresenter a;
  protected UserInfoHandler b;
  protected ActionSheet c;
  protected Player d;
  protected boolean e = false;
  protected boolean f = false;
  private PkMemberItemView g;
  private PkMemberItemView h;
  private ImageView i;
  private SurvivalSeatBgView j;
  private ISurvivalSeatBgPresenter k;
  private SeatMemberInfo l;
  private SeatMemberInfo m;
  private ImageView n;
  private ImageView o;
  private ImageView p;
  private ImageView q;
  private Vibrator r;
  private int s = -1;
  private IGameRoomPresenter t;
  private ViewTreeObserver.OnGlobalLayoutListener u = new PkSeatView.1(this);
  private ViewTreeObserver.OnGlobalLayoutListener v = new PkSeatView.2(this);
  private RoundEmptyRectRelativeLayout.ClipRoundRect w;
  private RoundEmptyRectRelativeLayout.ClipRoundRect x;
  private View y;
  private View z;
  
  public PkSeatView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public PkSeatView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public PkSeatView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file:///");
    localStringBuilder.append(AvGameResDownloadUtil.c());
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    this.b = ((UserInfoHandler)GameEngine.a().f().getBusinessHandler(HandlerFactory.b));
    this.a = new SeatPresenterImp(this);
    Object localObject = View.inflate(getContext(), 2131624320, null);
    this.z = View.inflate(getContext(), 2131624319, null);
    addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
    this.y = View.inflate(getContext(), 2131624322, null);
    this.g = ((PkMemberItemView)this.y.findViewById(2131438050));
    this.h = ((PkMemberItemView)this.y.findViewById(2131438058));
    this.g.a();
    this.h.a();
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.g.getViewTreeObserver().addOnGlobalLayoutListener(this.u);
    this.h.getViewTreeObserver().addOnGlobalLayoutListener(this.v);
    ((ImageView)((View)localObject).findViewById(2131429175)).setImageBitmap(AVGameUtil.c("avgame_pk_member_blue@2x.png"));
    ((ImageView)((View)localObject).findViewById(2131429176)).setImageBitmap(AVGameUtil.c("avgame_pk_member_red@2x.png"));
    this.i = ((ImageView)((View)localObject).findViewById(2131429174));
    this.i.setImageBitmap(AVGameUtil.c("avgame_pk_logo_static@2x.png"));
    this.n = ((ImageView)this.z.findViewById(2131429167));
    this.o = ((ImageView)this.z.findViewById(2131429177));
    this.n.setVisibility(8);
    this.o.setVisibility(8);
    this.p = ((ImageView)((View)localObject).findViewById(2131429186));
    this.q = ((ImageView)((View)localObject).findViewById(2131429189));
    this.p.setImageBitmap(AVGameUtil.c("avgame_pk_member_bg_blue@2x.png"));
    this.q.setImageBitmap(AVGameUtil.c("avgame_pk_member_bg_red@2x.png"));
    this.j = ((SurvivalSeatBgView)((View)localObject).findViewById(2131429187));
    this.j.setHorizontalSpacing(GameRoomViewLayoutParamsDef.M);
    this.j.setVerticalSpacing(GameRoomViewLayoutParamsDef.M);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SurvivalSeatBgView seatBgItemWidth= ");
      ((StringBuilder)localObject).append(GameRoomViewLayoutParamsDef.K);
      ((StringBuilder)localObject).append(" seatBgItemGapH=");
      ((StringBuilder)localObject).append(GameRoomViewLayoutParamsDef.M);
      ((StringBuilder)localObject).append(" seatBgItemMaxNum=");
      ((StringBuilder)localObject).append(GameRoomViewLayoutParamsDef.N);
      ((StringBuilder)localObject).append(" seatBgViewHeight=");
      ((StringBuilder)localObject).append(GameRoomViewLayoutParamsDef.O);
      ((StringBuilder)localObject).append("seatBgViewHeight:");
      ((StringBuilder)localObject).append(GameRoomViewLayoutParamsDef.P);
      QLog.d("PkSeatView", 2, ((StringBuilder)localObject).toString());
    }
    this.k = this.j.getPresenter();
    post(new PkSeatView.3(this));
  }
  
  private void a(int paramInt)
  {
    if (this.r == null) {
      this.r = ((Vibrator)getContext().getSystemService("vibrator"));
    }
    if (!this.r.hasVibrator()) {
      return;
    }
    this.r.cancel();
    if (Build.VERSION.SDK_INT > 25)
    {
      VibrationEffect localVibrationEffect = VibrationEffect.createOneShot(paramInt, -1);
      this.r.vibrate(localVibrationEffect);
      return;
    }
    this.r.vibrate(paramInt);
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    ApngImage.resumeAll();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramImageView.getHeight();
    localURLDrawableOptions.mUseApngImage = true;
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_loop", 1);
    localURLDrawableOptions.mExtraInfo = localBundle;
    paramImageView.setImageDrawable(URLDrawable.getDrawable(a(paramString), localURLDrawableOptions));
    paramImageView.setVisibility(0);
  }
  
  private void b()
  {
    Object localObject2 = this.a.a();
    this.l = null;
    this.m = null;
    if (localObject2 != null)
    {
      Object localObject1;
      if (((List)localObject2).isEmpty())
      {
        this.l = new SeatMemberInfo();
        localObject1 = new Player();
        ((Player)localObject1).uin = GameEngine.a().f().getCurrentAccountUin();
        if ((((Player)localObject1).uin.equals(((Player)localObject1).nick)) || (TextUtils.isEmpty(((Player)localObject1).nick)))
        {
          localObject2 = new ArrayList(1);
          ((ArrayList)localObject2).add(((Player)localObject1).uin);
          localObject2 = (String)this.b.a((List)localObject2).get(((Player)localObject1).uin);
          if (localObject2 != null) {
            ((Player)localObject1).nick = ((String)localObject2);
          }
        }
        this.l.a = ((Player)localObject1);
        return;
      }
      if (((List)localObject2).size() == 1)
      {
        this.l = ((SeatMemberInfo)((List)localObject2).get(0));
        return;
      }
      if (((List)localObject2).size() > 1)
      {
        localObject1 = (SeatMemberInfo)((List)localObject2).get(0);
        localObject2 = (SeatMemberInfo)((List)localObject2).get(1);
        if (GameEngine.a().f().getCurrentAccountUin().equals(((SeatMemberInfo)localObject1).a.uin))
        {
          this.l = ((SeatMemberInfo)localObject1);
          this.m = ((SeatMemberInfo)localObject2);
          return;
        }
        this.l = ((SeatMemberInfo)localObject2);
        this.m = ((SeatMemberInfo)localObject1);
      }
    }
  }
  
  private void c()
  {
    this.h.c();
    this.t.e().a(getResources().getString(2131887394), this.h.getPlayerHeadViewRect(), 60);
    this.A.sendEmptyMessageDelayed(1, 3000L);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.h.c();
    } else {
      this.g.c();
    }
    d(paramBoolean);
    e(paramBoolean);
    this.A.removeCallbacksAndMessages(Integer.valueOf(1));
    this.A.sendEmptyMessageDelayed(1, 3000L);
  }
  
  private void d()
  {
    a(100);
    a(this.i, "avgame_pk_logo_apng@2x.png");
    this.A.removeCallbacksAndMessages(Integer.valueOf(0));
    this.A.sendEmptyMessageDelayed(0, 1000L);
  }
  
  private void d(boolean paramBoolean)
  {
    ImageView localImageView;
    if (paramBoolean) {
      localImageView = this.n;
    } else {
      localImageView = this.o;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(ViewUtils.dpToPx(150.0F), ViewUtils.dpToPx(150.0F));
    PkMemberItemView localPkMemberItemView;
    if (paramBoolean) {
      localPkMemberItemView = this.g;
    } else {
      localPkMemberItemView = this.h;
    }
    if (GameRoomViewLayoutParamsDef.H < localPkMemberItemView.getWidth())
    {
      GameRoomViewLayoutParamsDef.H = localPkMemberItemView.getWidth();
      GameRoomViewLayoutParamsDef.I = localPkMemberItemView.getHeight();
    }
    int i1 = GameRoomViewLayoutParamsDef.H / 2 + ViewUtils.dip2px(58.0F) - ViewUtils.dpToPx(75.0F);
    if (paramBoolean) {
      localLayoutParams.leftMargin = i1;
    } else {
      localLayoutParams.rightMargin = i1;
    }
    if (paramBoolean) {
      i1 = 3;
    } else {
      i1 = 5;
    }
    localLayoutParams.gravity = (i1 | 0x10);
    if (GameEngine.a().D()) {
      localLayoutParams.bottomMargin = (GameRoomViewLayoutParamsDef.I / 2 - GameRoomViewLayoutParamsDef.H / 2);
    } else {
      localLayoutParams.bottomMargin = ((GameRoomViewLayoutParamsDef.I / 2 - GameRoomViewLayoutParamsDef.H / 2) / 3 * 2);
    }
    localImageView.setLayoutParams(localLayoutParams);
    a(localImageView, "avgame_pk_member_win@2x.png");
  }
  
  private void e(boolean paramBoolean)
  {
    ImageView localImageView;
    if (paramBoolean) {
      localImageView = this.o;
    } else {
      localImageView = this.n;
    }
    PkMemberItemView localPkMemberItemView;
    if (paramBoolean) {
      localPkMemberItemView = this.h;
    } else {
      localPkMemberItemView = this.g;
    }
    int i1 = localPkMemberItemView.e.getWidth() + ViewUtils.dpToPx(3.0F);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i1, localPkMemberItemView.e.getHeight() + ViewUtils.dpToPx(3.0F));
    if (paramBoolean) {
      localLayoutParams.rightMargin = (localPkMemberItemView.getWidth() / 2 + ViewUtils.dip2px(58.0F) - ViewUtils.dpToPx((int)(i1 * 1.0F / ViewUtils.dpToPx(74.0F) * 29.0F)));
    } else {
      localLayoutParams.leftMargin = (localPkMemberItemView.getWidth() / 2 + ViewUtils.dip2px(58.0F) - ViewUtils.dpToPx((int)(i1 * 1.0F / ViewUtils.dpToPx(74.0F) * 45.0F)));
    }
    if (paramBoolean) {
      i1 = 5;
    } else {
      i1 = 3;
    }
    localLayoutParams.gravity = (i1 | 0x10);
    localLayoutParams.bottomMargin = (localPkMemberItemView.getHeight() / 2 - localPkMemberItemView.getWidth() / 2);
    localImageView.setLayoutParams(localLayoutParams);
    a(localImageView, "avgame_pk_member_fail@2x.png");
  }
  
  private SeatMemberInfo getEmptyMemberInfo()
  {
    SeatMemberInfo localSeatMemberInfo = new SeatMemberInfo();
    localSeatMemberInfo.a = new Player();
    localSeatMemberInfo.a.uin = "0";
    localSeatMemberInfo.a.nick = "loser";
    return localSeatMemberInfo;
  }
  
  public RectF a(long paramLong)
  {
    if (this.g.b(String.valueOf(paramLong))) {
      return this.g.getPlayerHeadViewRect();
    }
    if (this.h.b(String.valueOf(paramLong))) {
      return this.h.getPlayerHeadViewRect();
    }
    return null;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdatePlayerSpeakingStatus playerUin:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" isSpeaking:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("PkSeatView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = String.valueOf(paramLong);
    if (this.g.b((String)localObject))
    {
      this.g.a(paramBoolean);
      return;
    }
    if (this.h.b((String)localObject)) {
      this.h.a(paramBoolean);
    }
  }
  
  public void a(EngineData paramEngineData)
  {
    int i1 = paramEngineData.X();
    if (4 > i1) {
      b();
    }
    Object localObject2;
    switch (i1)
    {
    case 6: 
    case 7: 
    default: 
      break;
    case 9: 
      if (this.s != i1)
      {
        QLog.d("PkSeatView", 1, "aUser leave to show.");
        c();
      }
      break;
    case 8: 
      PkMemberItemView localPkMemberItemView = this.h;
      UserInfoHandler localUserInfoHandler = this.b;
      localObject2 = this.m;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = getEmptyMemberInfo();
      }
      localPkMemberItemView.a(localUserInfoHandler, (SeatMemberInfo)localObject1, this.a, false);
      if (this.s != i1) {
        c();
      }
      break;
    case 5: 
      if ((this.s == 3) && (!paramEngineData.Z().isBothClose))
      {
        if ((paramEngineData.M()) && (!paramEngineData.O())) {
          a(false);
        }
        c(false);
        localObject1 = paramEngineData.Z().pkDrawRes;
        if ((localObject1 != null) && (((SurvivalPkResultInfo.PKDrawRes)localObject1).isDraw))
        {
          this.g.b(((SurvivalPkResultInfo.PKDrawRes)localObject1).selfCost, false);
          this.h.b(((SurvivalPkResultInfo.PKDrawRes)localObject1).peerCost, true);
        }
      }
      break;
    case 4: 
    case 10: 
      if (this.s == 3)
      {
        if ((paramEngineData.M()) && (!paramEngineData.O())) {
          a(false);
        }
        c(true);
        localObject1 = paramEngineData.Z().pkDrawRes;
        if ((localObject1 != null) && (((SurvivalPkResultInfo.PKDrawRes)localObject1).isDraw))
        {
          this.g.b(((SurvivalPkResultInfo.PKDrawRes)localObject1).selfCost, true);
          this.h.b(((SurvivalPkResultInfo.PKDrawRes)localObject1).peerCost, false);
        }
      }
      break;
    case 3: 
      localObject1 = this.i;
      if ((localObject1 != null) && (((ImageView)localObject1).getVisibility() == 8))
      {
        this.i.setVisibility(0);
        this.i.setImageBitmap(AVGameUtil.c("avgame_pk_logo_static@2x.png"));
      }
      if (this.g.b()) {
        this.g.a(this.b, this.l, this.a, true);
      }
      if (this.h.b()) {
        this.h.a(this.b, this.m, this.a, false);
      }
      this.g.a(this.l);
      this.h.a(this.m);
      this.g.b(this.b, this.l, this.a, true);
      this.h.b(this.b, this.m, this.a, false);
      break;
    case 2: 
      this.h.a(this.b, this.m, this.a, false);
      int i2 = this.s;
      if ((i2 == 1) || (i2 == 0))
      {
        this.k.a();
        this.k.a(this.j);
        this.h.a(this.g);
        d();
      }
      break;
    case 1: 
      if (i1 != this.s)
      {
        if (this.g.b()) {
          this.g.a(this.b, this.l, this.a, true);
        }
        this.i.setVisibility(8);
        this.h.d();
        this.g.d();
        if (this.s >= 4)
        {
          this.g.f();
          this.h.f();
          b(false);
          if (this.s == 8) {
            this.h.a(this.a, false);
          }
        }
        else
        {
          this.h.a(this.a, false);
        }
      }
      break;
    case 0: 
      this.g.a(this.b, this.l, this.a, true);
      this.h.a(this.b, this.a, false);
      if (this.s >= 4)
      {
        this.j.setAlpha(1.0F);
        this.k.b();
        this.g.f();
        this.h.f();
        b(false);
      }
      if (this.s != i1)
      {
        this.i.setVisibility(8);
        ReportController.b(null, "dc00898", "", "", "0X800B8C1", "0X800B8C1", 0, 0, "", "", "", "");
      }
      break;
    }
    this.s = i1;
    Object localObject1 = paramEngineData.U();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject2 = this.k;
      if (localObject2 != null)
      {
        ((ISurvivalSeatBgPresenter)localObject2).a((List)localObject1);
        ((List)localObject1).clear();
      }
    }
    paramEngineData = paramEngineData.V();
    if ((paramEngineData != null) && (paramEngineData.size() > 0))
    {
      localObject1 = this.k;
      if (localObject1 != null)
      {
        ((ISurvivalSeatBgPresenter)localObject1).b(paramEngineData);
        paramEngineData.clear();
      }
    }
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.t = paramIGameRoomPresenter;
    this.a.a(paramIGameRoomPresenter);
    paramIGameRoomPresenter = new ArrayList(1);
    paramIGameRoomPresenter.add(GameEngine.a().f().getCurrentAccountUin());
    this.b.a(paramIGameRoomPresenter);
    if (GameEngine.a().D())
    {
      this.g.a("avgame_pk_head_left@2x.png");
      this.h.a("avgame_pk_head_right@2x.png");
    }
  }
  
  public void a(SeatMemberInfo paramSeatMemberInfo)
  {
    if (paramSeatMemberInfo != null)
    {
      if (paramSeatMemberInfo.a == null) {
        return;
      }
      this.d = paramSeatMemberInfo.a;
      this.e = GameEngine.a().d();
      this.f = false;
      if (GameEngine.a().f() != null)
      {
        paramSeatMemberInfo = GameEngine.a().f().getAccount();
        if (TextUtils.equals(this.d.uin, paramSeatMemberInfo)) {
          this.f = true;
        }
      }
      this.c = ((ActionSheet)ActionSheetHelper.b(getContext(), null));
      this.c.addButton(2131887201);
      if (!this.f) {
        this.c.addButton(2131887197);
      }
      this.c.addCancelButton(2131887648);
      this.c.setOnButtonClickListener(this);
      this.c.setOnDismissListener(this);
      try
      {
        this.c.show();
      }
      catch (Exception paramSeatMemberInfo)
      {
        QLog.e("PkSeatView", 1, "onMemberItemClick error:", paramSeatMemberInfo);
      }
      paramSeatMemberInfo = new StringBuilder();
      paramSeatMemberInfo.append("");
      paramSeatMemberInfo.append(GameEngine.a().s().i());
      ReportController.b(null, "dc00898", "", "", "0X800B02A", "0X800B02A", 0, 0, "", paramSeatMemberInfo.toString(), "", "");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enableClipRectForPk enable:");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(" left:");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.i("PkSeatView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean2) {
      localObject = this.w;
    } else {
      localObject = this.x;
    }
    if (paramBoolean1) {
      paramBoolean1 = a((RoundEmptyRectRelativeLayout.ClipRoundRect)localObject);
    } else {
      paramBoolean1 = b((RoundEmptyRectRelativeLayout.ClipRoundRect)localObject);
    }
    if (paramBoolean1) {
      invalidate();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.n.setVisibility(8);
    this.o.setVisibility(8);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideGameResult isDisplayWord:");
      localStringBuilder.append(paramBoolean);
      QLog.i("PkSeatView", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      this.g.a(1, true);
      this.h.a(1, false);
      return;
    }
    this.g.a(4, true);
    this.h.a(4, false);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    c(paramBoolean1, paramBoolean2);
  }
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    PkMemberItemView localPkMemberItemView;
    if (paramBoolean1) {
      localPkMemberItemView = this.g;
    } else {
      localPkMemberItemView = this.h;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showGameResult isSelf:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" isCorrect: ");
      localStringBuilder.append(paramBoolean2);
      QLog.i("PkSeatView", 2, localStringBuilder.toString());
    }
    if (paramBoolean2)
    {
      d(paramBoolean1);
      localPkMemberItemView.a(2, paramBoolean1);
      return;
    }
    localPkMemberItemView.a(3, paramBoolean1);
  }
  
  public RectF getAddMemberViewRect()
  {
    return null;
  }
  
  public RectF getAddMemberViewRectInRootView()
  {
    return null;
  }
  
  public View getCheerRootTop()
  {
    return this.z;
  }
  
  public List<MemberVideoDisplayInfo> getMemberHeadViewDisplayInfoList()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = GameEngine.a().s().e();
    MemberVideoDisplayInfo localMemberVideoDisplayInfo = this.g.a(this.a);
    if ((localMemberVideoDisplayInfo != null) && (((RoomInfo)localObject).getPlayer(String.valueOf(localMemberVideoDisplayInfo.a)) != null)) {
      localArrayList.add(localMemberVideoDisplayInfo);
    }
    localMemberVideoDisplayInfo = this.h.a(this.a);
    if ((localMemberVideoDisplayInfo != null) && (((RoomInfo)localObject).getPlayer(String.valueOf(localMemberVideoDisplayInfo.a)) != null)) {
      localArrayList.add(localMemberVideoDisplayInfo);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMemberHeadViewDisplayInfoList infoList:");
      ((StringBuilder)localObject).append(localArrayList);
      QLog.i("PkSeatView", 2, ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
  
  public View getMemberItemRootTop()
  {
    return this.y;
  }
  
  public ISeatPresenter getPresenter()
  {
    return this.a;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131438050)
    {
      if (i1 == 2131438058) {
        a(this.m);
      }
    }
    else {
      a(this.l);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onClick(View paramView, int paramInt)
  {
    if (this.c != null)
    {
      paramView = this.d;
      if (paramView == null) {
        return;
      }
      if (paramInt != 0)
      {
        if (paramInt == 1) {
          this.a.c(paramView);
        }
      }
      else {
        this.a.b(paramView);
      }
      try
      {
        this.c.setOnButtonClickListener(null);
        this.c.dismiss();
        this.c = null;
        this.d = null;
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
  
  public void onDismiss()
  {
    this.d = null;
    ActionSheet localActionSheet = this.c;
    if (localActionSheet == null) {
      return;
    }
    localActionSheet.setOnButtonClickListener(null);
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.PkSeatView
 * JD-Core Version:    0.7.0.1
 */