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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file:///");
    localStringBuilder.append(AvGameResDownloadUtil.c());
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler = ((UserInfoHandler)GameEngine.a().a().getBusinessHandler(HandlerFactory.b));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter = new SeatPresenterImp(this);
    Object localObject = View.inflate(getContext(), 2131558703, null);
    this.jdField_b_of_type_AndroidViewView = View.inflate(getContext(), 2131558702, null);
    addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidViewView = View.inflate(getContext(), 2131558705, null);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView = ((PkMemberItemView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370749));
    this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView = ((PkMemberItemView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370753));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a();
    this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a();
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    ((ImageView)((View)localObject).findViewById(2131363301)).setImageBitmap(AVGameUtil.a("avgame_pk_member_blue@2x.png"));
    ((ImageView)((View)localObject).findViewById(2131363302)).setImageBitmap(AVGameUtil.a("avgame_pk_member_red@2x.png"));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131363300));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(AVGameUtil.a("avgame_pk_logo_static@2x.png"));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131363293));
    this.c = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131363303));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.c.setVisibility(8);
    this.d = ((ImageView)((View)localObject).findViewById(2131363312));
    this.e = ((ImageView)((View)localObject).findViewById(2131363315));
    this.d.setImageBitmap(AVGameUtil.a("avgame_pk_member_bg_blue@2x.png"));
    this.e.setImageBitmap(AVGameUtil.a("avgame_pk_member_bg_red@2x.png"));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgView = ((SurvivalSeatBgView)((View)localObject).findViewById(2131363313));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgView.setHorizontalSpacing(GameRoomViewLayoutParamsDef.M);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgView.setVerticalSpacing(GameRoomViewLayoutParamsDef.M);
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
      Object localObject1;
      if (((List)localObject2).isEmpty())
      {
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
        return;
      }
      if (((List)localObject2).size() == 1)
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo = ((SeatMemberInfo)((List)localObject2).get(0));
        return;
      }
      if (((List)localObject2).size() > 1)
      {
        localObject1 = (SeatMemberInfo)((List)localObject2).get(0);
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
    }
  }
  
  private void c()
  {
    this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.b();
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a(getResources().getString(2131690483), this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(), 60);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.b();
    } else {
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.b();
    }
    d(paramBoolean);
    e(paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(Integer.valueOf(1));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
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
    if (paramBoolean) {
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    } else {
      localImageView = this.c;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(ViewUtils.b(150.0F), ViewUtils.b(150.0F));
    PkMemberItemView localPkMemberItemView;
    if (paramBoolean) {
      localPkMemberItemView = this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView;
    } else {
      localPkMemberItemView = this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView;
    }
    if (GameRoomViewLayoutParamsDef.H < localPkMemberItemView.getWidth())
    {
      GameRoomViewLayoutParamsDef.H = localPkMemberItemView.getWidth();
      GameRoomViewLayoutParamsDef.I = localPkMemberItemView.getHeight();
    }
    int i = GameRoomViewLayoutParamsDef.H / 2 + ViewUtils.a(58.0F) - ViewUtils.b(75.0F);
    if (paramBoolean) {
      localLayoutParams.leftMargin = i;
    } else {
      localLayoutParams.rightMargin = i;
    }
    if (paramBoolean) {
      i = 3;
    } else {
      i = 5;
    }
    localLayoutParams.gravity = (i | 0x10);
    if (GameEngine.a().i()) {
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
      localImageView = this.c;
    } else {
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    }
    PkMemberItemView localPkMemberItemView;
    if (paramBoolean) {
      localPkMemberItemView = this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView;
    } else {
      localPkMemberItemView = this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView;
    }
    int i = localPkMemberItemView.jdField_b_of_type_AndroidWidgetImageView.getWidth() + ViewUtils.b(3.0F);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, localPkMemberItemView.jdField_b_of_type_AndroidWidgetImageView.getHeight() + ViewUtils.b(3.0F));
    if (paramBoolean) {
      localLayoutParams.rightMargin = (localPkMemberItemView.getWidth() / 2 + ViewUtils.a(58.0F) - ViewUtils.b((int)(i * 1.0F / ViewUtils.b(74.0F) * 29.0F)));
    } else {
      localLayoutParams.leftMargin = (localPkMemberItemView.getWidth() / 2 + ViewUtils.a(58.0F) - ViewUtils.b((int)(i * 1.0F / ViewUtils.b(74.0F) * 45.0F)));
    }
    if (paramBoolean) {
      i = 5;
    } else {
      i = 3;
    }
    localLayoutParams.gravity = (i | 0x10);
    localLayoutParams.bottomMargin = (localPkMemberItemView.getHeight() / 2 - localPkMemberItemView.getWidth() / 2);
    localImageView.setLayoutParams(localLayoutParams);
    a(localImageView, "avgame_pk_member_fail@2x.png");
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      paramView = this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
      if (paramView == null) {
        return;
      }
      if (paramInt != 0)
      {
        if (paramInt == 1) {
          this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.c(paramView);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.b(paramView);
      }
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
      }
    }
  }
  
  public RectF a()
  {
    return null;
  }
  
  public RectF a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(String.valueOf(paramLong))) {
      return this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a();
    }
    if (this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(String.valueOf(paramLong))) {
      return this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a();
    }
    return null;
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
    Object localObject = GameEngine.a().a().a();
    MemberVideoDisplayInfo localMemberVideoDisplayInfo = this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter);
    if ((localMemberVideoDisplayInfo != null) && (((RoomInfo)localObject).getPlayer(String.valueOf(localMemberVideoDisplayInfo.a)) != null)) {
      localArrayList.add(localMemberVideoDisplayInfo);
    }
    localMemberVideoDisplayInfo = this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter);
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
    if (this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a((String)localObject))
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(paramBoolean);
      return;
    }
    if (this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a((String)localObject)) {
      this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(paramBoolean);
    }
  }
  
  public void a(EngineData paramEngineData)
  {
    int i = paramEngineData.o();
    if (4 > i) {
      b();
    }
    Object localObject2;
    switch (i)
    {
    case 6: 
    case 7: 
    default: 
      break;
    case 9: 
      if (this.jdField_a_of_type_Int != i)
      {
        QLog.d("PkSeatView", 1, "aUser leave to show.");
        c();
      }
      break;
    case 8: 
      PkMemberItemView localPkMemberItemView = this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView;
      UserInfoHandler localUserInfoHandler = this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler;
      localObject2 = this.jdField_b_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = a();
      }
      localPkMemberItemView.a(localUserInfoHandler, (SeatMemberInfo)localObject1, this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter, false);
      if (this.jdField_a_of_type_Int != i) {
        c();
      }
      break;
    case 5: 
      if ((this.jdField_a_of_type_Int == 3) && (!paramEngineData.a().isBothClose))
      {
        if ((paramEngineData.f()) && (!paramEngineData.h())) {
          a(false);
        }
        c(false);
        localObject1 = paramEngineData.a().pkDrawRes;
        if ((localObject1 != null) && (((SurvivalPkResultInfo.PKDrawRes)localObject1).isDraw))
        {
          this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.b(((SurvivalPkResultInfo.PKDrawRes)localObject1).selfCost, false);
          this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.b(((SurvivalPkResultInfo.PKDrawRes)localObject1).peerCost, true);
        }
      }
      break;
    case 4: 
    case 10: 
      if (this.jdField_a_of_type_Int == 3)
      {
        if ((paramEngineData.f()) && (!paramEngineData.h())) {
          a(false);
        }
        c(true);
        localObject1 = paramEngineData.a().pkDrawRes;
        if ((localObject1 != null) && (((SurvivalPkResultInfo.PKDrawRes)localObject1).isDraw))
        {
          this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.b(((SurvivalPkResultInfo.PKDrawRes)localObject1).selfCost, true);
          this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.b(((SurvivalPkResultInfo.PKDrawRes)localObject1).peerCost, false);
        }
      }
      break;
    case 3: 
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      if ((localObject1 != null) && (((ImageView)localObject1).getVisibility() == 8))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(AVGameUtil.a("avgame_pk_logo_static@2x.png"));
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
      break;
    case 2: 
      this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler, this.jdField_b_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo, this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter, false);
      int j = this.jdField_a_of_type_Int;
      if ((j == 1) || (j == 0))
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter.a();
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgView);
        this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView);
        d();
      }
      break;
    case 1: 
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
        }
      }
      break;
    case 0: 
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
      }
      break;
    }
    this.jdField_a_of_type_Int = i;
    Object localObject1 = paramEngineData.c();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject2 = this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter;
      if (localObject2 != null)
      {
        ((ISurvivalSeatBgPresenter)localObject2).a((List)localObject1);
        ((List)localObject1).clear();
      }
    }
    paramEngineData = paramEngineData.d();
    if ((paramEngineData != null) && (paramEngineData.size() > 0))
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter;
      if (localObject1 != null)
      {
        ((ISurvivalSeatBgPresenter)localObject1).b(paramEngineData);
        paramEngineData.clear();
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
    if (paramSeatMemberInfo != null)
    {
      if (paramSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null) {
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
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131690290);
      if (!this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131690286);
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(this);
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      }
      catch (Exception paramSeatMemberInfo)
      {
        QLog.e("PkSeatView", 1, "onMemberItemClick error:", paramSeatMemberInfo);
      }
      paramSeatMemberInfo = new StringBuilder();
      paramSeatMemberInfo.append("");
      paramSeatMemberInfo.append(GameEngine.a().a().a());
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
      localObject = this.jdField_a_of_type_ComTencentAvgameUiRoundEmptyRectRelativeLayout$ClipRoundRect;
    } else {
      localObject = this.jdField_b_of_type_ComTencentAvgameUiRoundEmptyRectRelativeLayout$ClipRoundRect;
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
  
  public View b()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.c.setVisibility(8);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideGameResult isDisplayWord:");
      localStringBuilder.append(paramBoolean);
      QLog.i("PkSeatView", 2, localStringBuilder.toString());
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
    PkMemberItemView localPkMemberItemView;
    if (paramBoolean1) {
      localPkMemberItemView = this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView;
    } else {
      localPkMemberItemView = this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView;
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
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131370749)
    {
      if (i == 2131370753) {
        a(this.jdField_b_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo);
      }
    }
    else {
      a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismiss()
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = null;
    ActionSheet localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (localActionSheet == null) {
      return;
    }
    localActionSheet.setOnButtonClickListener(null);
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.PkSeatView
 * JD-Core Version:    0.7.0.1
 */