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
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo.PKDrawRes;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
import com.tencent.avgame.gameroom.overlay.IOverlayPresenter;
import com.tencent.avgame.gameroom.seat.background.ISurvivalSeatBgPresenter;
import com.tencent.avgame.gameroom.seat.background.SurvivalSeatBgView;
import com.tencent.avgame.ui.RoundEmptyRectRelativeLayout;
import com.tencent.avgame.ui.RoundEmptyRectRelativeLayout.ClipRoundRect;
import com.tencent.avgame.util.AVGameUtils;
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
  private int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new PkSeatView.4(this));
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  private View jdField_a_of_type_AndroidViewView;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new PkSeatView.1(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected UserInfoHandler a;
  protected Player a;
  private IGameRoomPresenter jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter;
  protected ISeatPresenter a;
  private PkMemberItemView jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView;
  private SeatMemberInfo jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo;
  private ISurvivalSeatBgPresenter jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter;
  private SurvivalSeatBgView jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgView;
  private RoundEmptyRectRelativeLayout.ClipRoundRect jdField_a_of_type_ComTencentAvgameUiRoundEmptyRectRelativeLayout$ClipRoundRect;
  protected ActionSheet a;
  protected boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new PkSeatView.2(this);
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private PkMemberItemView jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView;
  private SeatMemberInfo jdField_b_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo;
  private RoundEmptyRectRelativeLayout.ClipRoundRect jdField_b_of_type_ComTencentAvgameUiRoundEmptyRectRelativeLayout$ClipRoundRect;
  protected boolean b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  
  public PkSeatView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    a();
  }
  
  public PkSeatView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    a();
  }
  
  public PkSeatView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    a();
  }
  
  private SeatMemberInfo a()
  {
    SeatMemberInfo localSeatMemberInfo = new SeatMemberInfo();
    localSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = new Player();
    localSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin = "0";
    localSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.nick = "loser";
    return localSeatMemberInfo;
  }
  
  private String a(String paramString)
  {
    return "file:///" + AvGameResDownloadManager.c() + paramString;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler = ((UserInfoHandler)GameEngine.a().a().getBusinessHandler(HandlerFactory.b));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter = new SeatPresenterImp(this);
    View localView = View.inflate(getContext(), 2131558803, null);
    this.jdField_b_of_type_AndroidViewView = View.inflate(getContext(), 2131558802, null);
    addView(localView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidViewView = View.inflate(getContext(), 2131558805, null);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView = ((PkMemberItemView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371125));
    this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView = ((PkMemberItemView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371129));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a();
    this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a();
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    ((ImageView)localView.findViewById(2131363369)).setImageBitmap(AVGameUtils.a("avgame_pk_member_blue@2x.png"));
    ((ImageView)localView.findViewById(2131363370)).setImageBitmap(AVGameUtils.a("avgame_pk_member_red@2x.png"));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363368));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(AVGameUtils.a("avgame_pk_logo_static@2x.png"));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131363361));
    this.c = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131363371));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.c.setVisibility(8);
    this.d = ((ImageView)localView.findViewById(2131363380));
    this.e = ((ImageView)localView.findViewById(2131363383));
    this.d.setImageBitmap(AVGameUtils.a("avgame_pk_member_bg_blue@2x.png"));
    this.e.setImageBitmap(AVGameUtils.a("avgame_pk_member_bg_red@2x.png"));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgView = ((SurvivalSeatBgView)localView.findViewById(2131363381));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgView.setHorizontalSpacing(GameRoomViewLayoutParamsDef.B);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgView.setVerticalSpacing(GameRoomViewLayoutParamsDef.B);
    if (QLog.isColorLevel()) {
      QLog.d("PkSeatView", 2, "SurvivalSeatBgView seatBgItemWidth= " + GameRoomViewLayoutParamsDef.z + " seatBgItemGapH=" + GameRoomViewLayoutParamsDef.B + " seatBgItemMaxNum=" + GameRoomViewLayoutParamsDef.C + " seatBgViewHeight=" + GameRoomViewLayoutParamsDef.D + "seatBgViewHeight:" + GameRoomViewLayoutParamsDef.E);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter = this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgView.a();
    post(new PkSeatView.3(this));
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsVibrator == null) {
      this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)getContext().getSystemService("vibrator"));
    }
    if (!this.jdField_a_of_type_AndroidOsVibrator.hasVibrator()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsVibrator.cancel();
    if (Build.VERSION.SDK_INT > 25)
    {
      VibrationEffect localVibrationEffect = VibrationEffect.createOneShot(paramInt, -1);
      this.jdField_a_of_type_AndroidOsVibrator.vibrate(localVibrationEffect);
      return;
    }
    this.jdField_a_of_type_AndroidOsVibrator.vibrate(paramInt);
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
    Object localObject2 = this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a();
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo = null;
    this.jdField_b_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo = null;
    if (localObject2 != null)
    {
      if (!((List)localObject2).isEmpty()) {
        break label144;
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo = new SeatMemberInfo();
      localObject1 = new Player();
      ((Player)localObject1).uin = GameEngine.a().a().getCurrentAccountUin();
      if ((((Player)localObject1).uin.equals(((Player)localObject1).nick)) || (TextUtils.isEmpty(((Player)localObject1).nick)))
      {
        localObject2 = new ArrayList(1);
        ((ArrayList)localObject2).add(((Player)localObject1).uin);
        localObject2 = (String)this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler.a((List)localObject2).get(((Player)localObject1).uin);
        if (localObject2 != null) {
          ((Player)localObject1).nick = ((String)localObject2);
        }
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localObject1);
    }
    label144:
    do
    {
      return;
      if (((List)localObject2).size() == 1)
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo = ((SeatMemberInfo)((List)localObject2).get(0));
        return;
      }
    } while (((List)localObject2).size() <= 1);
    Object localObject1 = (SeatMemberInfo)((List)localObject2).get(0);
    localObject2 = (SeatMemberInfo)((List)localObject2).get(1);
    if (GameEngine.a().a().getCurrentAccountUin().equals(((SeatMemberInfo)localObject1).jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin))
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo = ((SeatMemberInfo)localObject1);
      this.jdField_b_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo = ((SeatMemberInfo)localObject2);
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo = ((SeatMemberInfo)localObject2);
    this.jdField_b_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo = ((SeatMemberInfo)localObject1);
  }
  
  private void c()
  {
    this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.b();
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a(getResources().getString(2131690556), this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(), 60);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.b();
    }
    for (;;)
    {
      d(paramBoolean);
      e(paramBoolean);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(Integer.valueOf(1));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
      return;
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.b();
    }
  }
  
  private void d()
  {
    a(100);
    a(this.jdField_a_of_type_AndroidWidgetImageView, "avgame_pk_logo_apng@2x.png");
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(Integer.valueOf(0));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1000L);
  }
  
  private void d(boolean paramBoolean)
  {
    ImageView localImageView;
    FrameLayout.LayoutParams localLayoutParams;
    PkMemberItemView localPkMemberItemView;
    label40:
    int i;
    if (paramBoolean)
    {
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      localLayoutParams = new FrameLayout.LayoutParams(ViewUtils.b(150.0F), ViewUtils.b(150.0F));
      if (!paramBoolean) {
        break label160;
      }
      localPkMemberItemView = this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView;
      if (GameRoomViewLayoutParamsDef.w < localPkMemberItemView.getWidth())
      {
        GameRoomViewLayoutParamsDef.w = localPkMemberItemView.getWidth();
        GameRoomViewLayoutParamsDef.x = localPkMemberItemView.getHeight();
      }
      i = GameRoomViewLayoutParamsDef.w / 2 + ViewUtils.a(58.0F) - ViewUtils.b(75.0F);
      if (!paramBoolean) {
        break label169;
      }
      localLayoutParams.leftMargin = i;
      label97:
      if (!paramBoolean) {
        break label178;
      }
      i = 3;
      label103:
      localLayoutParams.gravity = (i | 0x10);
      if (!GameEngine.a().i()) {
        break label183;
      }
    }
    label160:
    label169:
    label178:
    label183:
    for (localLayoutParams.bottomMargin = (GameRoomViewLayoutParamsDef.x / 2 - GameRoomViewLayoutParamsDef.w / 2);; localLayoutParams.bottomMargin = ((GameRoomViewLayoutParamsDef.x / 2 - GameRoomViewLayoutParamsDef.w / 2) / 3 * 2))
    {
      localImageView.setLayoutParams(localLayoutParams);
      a(localImageView, "avgame_pk_member_win@2x.png");
      return;
      localImageView = this.c;
      break;
      localPkMemberItemView = this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView;
      break label40;
      localLayoutParams.rightMargin = i;
      break label97;
      i = 5;
      break label103;
    }
  }
  
  private void e(boolean paramBoolean)
  {
    ImageView localImageView;
    PkMemberItemView localPkMemberItemView;
    label19:
    FrameLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      localImageView = this.c;
      if (!paramBoolean) {
        break label163;
      }
      localPkMemberItemView = this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView;
      i = localPkMemberItemView.jdField_b_of_type_AndroidWidgetImageView.getWidth() + ViewUtils.b(3.0F);
      localLayoutParams = new FrameLayout.LayoutParams(i, localPkMemberItemView.jdField_b_of_type_AndroidWidgetImageView.getHeight() + ViewUtils.b(3.0F));
      if (!paramBoolean) {
        break label172;
      }
      localLayoutParams.rightMargin = (localPkMemberItemView.getWidth() / 2 + ViewUtils.a(58.0F) - ViewUtils.b((int)(i * 1.0F / ViewUtils.b(74.0F) * 29.0F)));
      label105:
      if (!paramBoolean) {
        break label216;
      }
    }
    label163:
    label172:
    label216:
    for (int i = 5;; i = 3)
    {
      localLayoutParams.gravity = (i | 0x10);
      localLayoutParams.bottomMargin = (localPkMemberItemView.getHeight() / 2 - localPkMemberItemView.getWidth() / 2);
      localImageView.setLayoutParams(localLayoutParams);
      a(localImageView, "avgame_pk_member_fail@2x.png");
      return;
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      break;
      localPkMemberItemView = this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView;
      break label19;
      localLayoutParams.leftMargin = (localPkMemberItemView.getWidth() / 2 + ViewUtils.a(58.0F) - ViewUtils.b((int)(i * 1.0F / ViewUtils.b(74.0F) * 45.0F)));
      break label105;
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet == null) || (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(null);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = null;
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.b(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
      continue;
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.c(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
    }
  }
  
  public RectF a()
  {
    return null;
  }
  
  public RectF a(long paramLong)
  {
    RectF localRectF = null;
    if (this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(String.valueOf(paramLong))) {
      localRectF = this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a();
    }
    while (!this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(String.valueOf(paramLong))) {
      return localRectF;
    }
    return this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a();
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public ISeatPresenter a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter;
  }
  
  public List<MemberVideoDisplayInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    RoomInfo localRoomInfo = GameEngine.a().a().a();
    MemberVideoDisplayInfo localMemberVideoDisplayInfo = this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter);
    if ((localMemberVideoDisplayInfo != null) && (localRoomInfo.getPlayer(String.valueOf(localMemberVideoDisplayInfo.a)) != null)) {
      localArrayList.add(localMemberVideoDisplayInfo);
    }
    localMemberVideoDisplayInfo = this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter);
    if ((localMemberVideoDisplayInfo != null) && (localRoomInfo.getPlayer(String.valueOf(localMemberVideoDisplayInfo.a)) != null)) {
      localArrayList.add(localMemberVideoDisplayInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PkSeatView", 2, "getMemberHeadViewDisplayInfoList infoList:" + localArrayList);
    }
    return localArrayList;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PkSeatView", 2, "onUpdatePlayerSpeakingStatus playerUin:" + paramLong + " isSpeaking:" + paramBoolean);
    }
    String str = String.valueOf(paramLong);
    if (this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(str)) {
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(paramBoolean);
    }
    while (!this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(str)) {
      return;
    }
    this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(paramBoolean);
  }
  
  public void a(EngineData paramEngineData)
  {
    int i = paramEngineData.o();
    if (4 > i) {
      b();
    }
    switch (i)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      Object localObject = paramEngineData.c();
      if ((localObject != null) && (((List)localObject).size() > 0) && (this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter != null))
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter.a((List)localObject);
        ((List)localObject).clear();
      }
      paramEngineData = paramEngineData.d();
      if ((paramEngineData != null) && (paramEngineData.size() > 0) && (this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter != null))
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter.b(paramEngineData);
        paramEngineData.clear();
      }
      return;
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler, this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo, this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter, true);
      this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler, this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter, false);
      if (this.jdField_a_of_type_Int >= 4)
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgView.setAlpha(1.0F);
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter.b();
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.e();
        this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.e();
        b(false);
      }
      if (this.jdField_a_of_type_Int != i)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        ReportController.b(null, "dc00898", "", "", "0X800B8C1", "0X800B8C1", 0, 0, "", "", "", "");
        continue;
        if (i != this.jdField_a_of_type_Int)
        {
          if (this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a()) {
            this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler, this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo, this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter, true);
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.c();
          this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.c();
          if (this.jdField_a_of_type_Int >= 4)
          {
            this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.e();
            this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.e();
            b(false);
            if (this.jdField_a_of_type_Int == 8) {
              this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter, false);
            }
          }
          else
          {
            this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter, false);
            continue;
            if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 8))
            {
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(AVGameUtils.a("avgame_pk_logo_static@2x.png"));
            }
            if (this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a()) {
              this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler, this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo, this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter, true);
            }
            if (this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a()) {
              this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler, this.jdField_b_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo, this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter, false);
            }
            this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo);
            this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_b_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo);
            this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler, this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo, this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter, true);
            this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler, this.jdField_b_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo, this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter, false);
            continue;
            this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler, this.jdField_b_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo, this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter, false);
            if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 0))
            {
              this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter.a();
              this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgView);
              this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView);
              d();
              continue;
              PkMemberItemView localPkMemberItemView = this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView;
              UserInfoHandler localUserInfoHandler = this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler;
              if (this.jdField_b_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo == null) {}
              for (localObject = a();; localObject = this.jdField_b_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo)
              {
                localPkMemberItemView.a(localUserInfoHandler, (SeatMemberInfo)localObject, this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter, false);
                if (this.jdField_a_of_type_Int == i) {
                  break;
                }
                c();
                break;
              }
              if (this.jdField_a_of_type_Int != i)
              {
                QLog.d("PkSeatView", 1, "aUser leave to show.");
                c();
                continue;
                if (this.jdField_a_of_type_Int == 3)
                {
                  if ((paramEngineData.f()) && (!paramEngineData.h())) {
                    a(false);
                  }
                  c(true);
                  localObject = paramEngineData.a().pkDrawRes;
                  if ((localObject != null) && (((SurvivalPkResultInfo.PKDrawRes)localObject).isDraw))
                  {
                    this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.b(((SurvivalPkResultInfo.PKDrawRes)localObject).selfCost, true);
                    this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.b(((SurvivalPkResultInfo.PKDrawRes)localObject).peerCost, false);
                    continue;
                    if ((this.jdField_a_of_type_Int == 3) && (!paramEngineData.a().isBothClose))
                    {
                      if ((paramEngineData.f()) && (!paramEngineData.h())) {
                        a(false);
                      }
                      c(false);
                      localObject = paramEngineData.a().pkDrawRes;
                      if ((localObject != null) && (((SurvivalPkResultInfo.PKDrawRes)localObject).isDraw))
                      {
                        this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.b(((SurvivalPkResultInfo.PKDrawRes)localObject).selfCost, false);
                        this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.b(((SurvivalPkResultInfo.PKDrawRes)localObject).peerCost, true);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter = paramIGameRoomPresenter;
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(paramIGameRoomPresenter);
    paramIGameRoomPresenter = new ArrayList(1);
    paramIGameRoomPresenter.add(GameEngine.a().a().getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler.a(paramIGameRoomPresenter);
    if (GameEngine.a().i())
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a("avgame_pk_head_left@2x.png");
      this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a("avgame_pk_head_right@2x.png");
    }
  }
  
  public void a(SeatMemberInfo paramSeatMemberInfo)
  {
    if ((paramSeatMemberInfo == null) || (paramSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = paramSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
    this.jdField_a_of_type_Boolean = GameEngine.a().a();
    this.jdField_b_of_type_Boolean = false;
    if (GameEngine.a().a() != null)
    {
      paramSeatMemberInfo = GameEngine.a().a().getAccount();
      if (TextUtils.equals(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin, paramSeatMemberInfo)) {
        this.jdField_b_of_type_Boolean = true;
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(getContext(), null));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131690367);
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131690363);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(this);
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      ReportController.b(null, "dc00898", "", "", "0X800B02A", "0X800B02A", 0, 0, "", "" + GameEngine.a().a().a(), "", "");
      return;
    }
    catch (Exception paramSeatMemberInfo)
    {
      for (;;)
      {
        QLog.e("PkSeatView", 1, "onMemberItemClick error:", paramSeatMemberInfo);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PkSeatView", 2, "enableClipRectForPk enable:" + paramBoolean1 + " left:" + paramBoolean2);
    }
    RoundEmptyRectRelativeLayout.ClipRoundRect localClipRoundRect;
    if (paramBoolean2)
    {
      localClipRoundRect = this.jdField_a_of_type_ComTencentAvgameUiRoundEmptyRectRelativeLayout$ClipRoundRect;
      if (!paramBoolean1) {
        break label79;
      }
    }
    label79:
    for (paramBoolean1 = a(localClipRoundRect);; paramBoolean1 = b(localClipRoundRect))
    {
      if (paramBoolean1) {
        invalidate();
      }
      return;
      localClipRoundRect = this.jdField_b_of_type_ComTencentAvgameUiRoundEmptyRectRelativeLayout$ClipRoundRect;
      break;
    }
  }
  
  public View b()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.c.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.i("PkSeatView", 2, "hideGameResult isDisplayWord:" + paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(1, true);
      this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(1, false);
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(4, true);
    this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(4, false);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    c(paramBoolean1, paramBoolean2);
  }
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (PkMemberItemView localPkMemberItemView = this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView;; localPkMemberItemView = this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PkSeatView", 2, "showGameResult isSelf:" + paramBoolean1 + " isCorrect: " + paramBoolean2);
      }
      if (!paramBoolean2) {
        break;
      }
      d(paramBoolean1);
      localPkMemberItemView.a(2, paramBoolean1);
      return;
    }
    localPkMemberItemView.a(3, paramBoolean1);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(this.jdField_b_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo);
      continue;
      a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo);
    }
  }
  
  public void onDismiss()
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = null;
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(null);
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.PkSeatView
 * JD-Core Version:    0.7.0.1
 */