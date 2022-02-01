package com.tencent.avgame.gameresult;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.floatwindow.FloatWindowController;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.UserScore;
import com.tencent.avgame.gameroom.stage.guesstext.GuessAutoLineTextView;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.report.AVGameNodeReportUtil;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.avgame.ui.AVGamePosterView;
import com.tencent.avgame.ui.GameBaseFragment;
import com.tencent.avgame.ui.IAVGameRootContainer;
import com.tencent.avgame.ui.IGamePosterView;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameResultFragment
  extends GameBaseFragment
  implements View.OnClickListener, IGameResultView, IGamePosterView
{
  protected IGameResultPresenter a;
  protected AutoBgImageView b;
  protected AutoBgImageView c;
  protected Button d;
  protected Button e;
  protected ScrollView f;
  protected LinearLayout g;
  protected RelativeLayout h;
  protected ProgressBar i;
  protected TextView j;
  protected BaseVideoView k;
  protected AutoBgImageView l;
  protected AutoBgImageView m;
  protected AsyncImageView n;
  protected long o = 0L;
  protected boolean p = false;
  protected QQProgressDialog q;
  private String r;
  private String s;
  private CopyOnWriteArrayList<UserScore> t;
  private UserInfoHandler u;
  private AVGamePosterView v;
  private View w;
  private FrameLayout x;
  
  public static GameResultFragment a()
  {
    GameResultFragment localGameResultFragment = new GameResultFragment();
    localGameResultFragment.setArguments(new Bundle());
    localGameResultFragment.a = new GameResultPresenterImp(localGameResultFragment);
    return localGameResultFragment;
  }
  
  private HashMap<String, String> a(UserInfoHandler paramUserInfoHandler, CopyOnWriteArrayList<UserScore> paramCopyOnWriteArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    while (paramCopyOnWriteArrayList.hasNext()) {
      localArrayList.add(String.valueOf(((UserScore)paramCopyOnWriteArrayList.next()).uin));
    }
    return paramUserInfoHandler.a(localArrayList);
  }
  
  private void a(String paramString1, String paramString2)
  {
    boolean bool = TextUtils.isEmpty(paramString2);
    int i1 = ViewUtils.dip2px(30.0F);
    LinearLayout localLinearLayout = new LinearLayout(getQBaseActivity());
    localLinearLayout.setOrientation(1);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 16);
    Object localObject = new GuessAutoLineTextView(getQBaseActivity());
    ((TextView)localObject).setTextColor(-1);
    ((TextView)localObject).setTextSize(20.0F);
    ((TextView)localObject).setTypeface(null, 1);
    ((TextView)localObject).setGravity(3);
    if (paramString1 != null) {
      ((TextView)localObject).setText(paramString1);
    }
    paramString1 = new LinearLayout.LayoutParams(-1, -2);
    paramString1.leftMargin = i1;
    paramString1.rightMargin = i1;
    localLinearLayout.addView((View)localObject, paramString1);
    if ((bool ^ true))
    {
      paramString1 = new ImageView(getQBaseActivity());
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = true;
      paramString1.setImageDrawable(URLDrawable.getDrawable(paramString2, (URLDrawable.URLDrawableOptions)localObject));
      paramString1.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      paramString2 = new LinearLayout.LayoutParams(-1, ViewUtils.dip2px(108.0F));
      paramString2.topMargin = ViewUtils.dip2px(10.0F);
      paramString2.leftMargin = i1;
      paramString2.rightMargin = i1;
      paramString2.gravity = 1;
      localLinearLayout.addView(paramString1, paramString2);
    }
    this.x.addView(localLinearLayout, localLayoutParams);
  }
  
  private void b(UserInfoHandler paramUserInfoHandler, CopyOnWriteArrayList<UserScore> paramCopyOnWriteArrayList)
  {
    this.h.setVisibility(8);
    this.f.setVisibility(0);
    this.g.removeAllViews();
    this.u = paramUserInfoHandler;
    this.t = paramCopyOnWriteArrayList;
    HashMap localHashMap = a(paramUserInfoHandler, paramCopyOnWriteArrayList);
    int i1 = 0;
    while (i1 < paramCopyOnWriteArrayList.size())
    {
      Object localObject3 = (UserScore)paramCopyOnWriteArrayList.get(i1);
      try
      {
        Object localObject2 = LayoutInflater.from(getQBaseActivity()).inflate(2131624311, null);
        this.g.addView((View)localObject2);
        Object localObject1 = paramUserInfoHandler.a(String.valueOf(((UserScore)localObject3).uin), (byte)3);
        ((ImageView)((View)localObject2).findViewById(2131429164)).setImageBitmap((Bitmap)localObject1);
        ((TextView)((View)localObject2).findViewById(2131429163)).setText((String)localHashMap.get(String.valueOf(((UserScore)localObject3).uin)));
        localObject1 = (TextView)((View)localObject2).findViewById(2131429160);
        ((TextView)localObject1).setText(String.valueOf(((UserScore)localObject3).score));
        localObject3 = (TextView)((View)localObject2).findViewById(2131429143);
        ((TextView)localObject3).setText(String.valueOf(i1 + 1));
        localObject2 = (ImageView)((View)localObject2).findViewById(2131429144);
        if (i1 == 0)
        {
          ((TextView)localObject3).setVisibility(8);
          localObject3 = AVGameUtil.c("avgame_ranking1@2x.png");
          if (localObject3 != null) {
            ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
          }
          ((ImageView)localObject2).setVisibility(0);
          ((TextView)localObject1).setTextColor(-13312);
        }
        else if (i1 == 1)
        {
          ((TextView)localObject3).setVisibility(8);
          localObject3 = AVGameUtil.c("avgame_ranking2@2x.png");
          if (localObject3 != null) {
            ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
          }
          ((ImageView)localObject2).setVisibility(0);
          ((TextView)localObject1).setTextColor(-8293377);
        }
        else if (i1 == 2)
        {
          ((TextView)localObject3).setVisibility(8);
          localObject3 = AVGameUtil.c("avgame_ranking3@2x.png");
          if (localObject3 != null) {
            ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
          }
          ((ImageView)localObject2).setVisibility(0);
          ((TextView)localObject1).setTextColor(-32564);
        }
      }
      catch (Exception localException)
      {
        QLog.e("GameResultFragment", 2, "onGetGameRankingListSuc exception!");
        localException.printStackTrace();
      }
      i1 += 1;
    }
    this.v.a(paramUserInfoHandler, paramCopyOnWriteArrayList);
  }
  
  private void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
    this.k.pause();
    if (System.currentTimeMillis() - this.o < 1000L) {
      return;
    }
    b(2131887350);
    this.a.d();
    this.o = System.currentTimeMillis();
    this.s = null;
    this.r = null;
  }
  
  private void c(boolean paramBoolean)
  {
    this.f.setVisibility(8);
    if (!paramBoolean)
    {
      QQToast.makeText(getQBaseActivity(), 1, getString(2131887354), 0).show();
      this.h.setVisibility(0);
      this.i.setVisibility(0);
      this.j.setText(getString(2131887354));
      return;
    }
    this.h.setVisibility(0);
    this.i.setVisibility(8);
    SpannableString localSpannableString = new SpannableString(getString(2131887352));
    localSpannableString.setSpan(new GameResultFragment.5(this), 8, 14, 33);
    this.j.setText(localSpannableString);
    this.j.setMovementMethod(LinkMovementMethod.getInstance());
    this.j.setHighlightColor(0);
  }
  
  private void f()
  {
    g();
    if (!this.a.f())
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameResultFragment", 2, "getRankingList failed.");
      }
      c(false);
    }
  }
  
  private void g()
  {
    this.h.setVisibility(0);
    this.i.setVisibility(0);
    this.j.setText(getString(2131887353));
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (paramInt == 1)
    {
      b();
      return;
    }
    if ((paramInt == 2) && (this.k != null))
    {
      FrameLayout localFrameLayout = this.x;
      if ((localFrameLayout != null) && (localFrameLayout.getVisibility() == 0)) {
        this.x.setVisibility(8);
      }
      this.a.b();
      f();
      FloatWindowController.c().d();
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onGameResultResourcesInfo ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(paramString2);
    QLog.d("GameResultFragment", 2, ((StringBuilder)localObject1).toString());
    localObject1 = this.k;
    if (localObject1 != null) {
      if (paramString2 != null)
      {
        ((BaseVideoView)localObject1).setVisibility(0);
        localObject1 = new VideoPlayParam();
        ((VideoPlayParam)localObject1).mIsLocal = true;
        ((VideoPlayParam)localObject1).mSceneId = 107;
        ((VideoPlayParam)localObject1).mIsMute = true;
        ((VideoPlayParam)localObject1).mSceneName = SceneID.getSceneStr(107);
        ((VideoPlayParam)localObject1).mVideoPath = paramString2;
        ((VideoPlayParam)localObject1).mIsLoop = true;
        this.k.setVideoParam((VideoPlayParam)localObject1);
        this.k.play();
      }
      else
      {
        ((BaseVideoView)localObject1).setVisibility(4);
        if (this.k.isPlaying()) {
          this.k.pause();
        }
      }
    }
    if (FileUtil.d(paramString2))
    {
      int i1 = GameEngine.a().s().p();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(GameEngine.a().s().i());
      ReportController.b(null, "dc00898", "", "", "0X800B05C", "0X800B05C", i1, 0, ((StringBuilder)localObject1).toString(), "", "", "");
    }
    else
    {
      ReportController.b(null, "dc00898", "", "", "0X800B05D", "0X800B05D", GameEngine.a().s().p(), 0, "", "", "", "");
    }
    this.l.setSelected(false);
    localObject1 = AVGameUtil.c("avgame_voice_off@2x.png");
    if (localObject1 != null) {
      this.l.setImageBitmap((Bitmap)localObject1);
    }
    localObject1 = "avgame_actfallback@2x.png";
    Object localObject2;
    if (paramString1 != null)
    {
      this.n.post(new GameResultFragment.2(this, paramString1));
      localObject2 = localObject1;
    }
    else
    {
      if (paramInt != 1) {
        if (paramInt == 2) {
          localObject1 = "avgame_poster_mosaic_fallback@2x.png";
        } else if (paramInt != 3) {
          if (paramInt == 4)
          {
            localObject1 = "avgame_songfallback@2x.png";
          }
          else if (paramInt == 5)
          {
            localObject1 = "avgame_knowledgefallback@2x.png";
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("error game Type:");
            ((StringBuilder)localObject2).append(paramInt);
            QLog.e("GameResultFragment", 1, ((StringBuilder)localObject2).toString());
          }
        }
      }
      Bitmap localBitmap = AVGameUtil.c((String)localObject1);
      localObject2 = localObject1;
      if (localBitmap != null)
      {
        this.n.setImageBitmap(localBitmap);
        localObject2 = localObject1;
      }
    }
    if (TextUtils.isEmpty(paramString2))
    {
      this.l.setVisibility(8);
      this.m.setVisibility(8);
    }
    else
    {
      this.l.setVisibility(0);
      this.m.setVisibility(0);
    }
    this.r = paramString1;
    this.s = paramString2;
    this.v.a(this.r, (String)localObject2);
    this.v.setContentAndTitleView(paramInt);
  }
  
  public void a(EngineData paramEngineData)
  {
    if (getQBaseActivity() == null) {
      return;
    }
    UserInfoHandler localUserInfoHandler = (UserInfoHandler)GameEngine.a().f().getBusinessHandler(HandlerFactory.b);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramEngineData != null)
    {
      localObject1 = localObject2;
      if (paramEngineData.h() != null) {
        localObject1 = paramEngineData.h().i();
      }
    }
    if ((localUserInfoHandler != null) && (paramEngineData != null) && (paramEngineData.d()) && (localObject1 != null) && (((CopyOnWriteArrayList)localObject1).size() > 0))
    {
      b(localUserInfoHandler, (CopyOnWriteArrayList)localObject1);
      return;
    }
    if ((localUserInfoHandler != null) && (paramEngineData != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameResultFragment", 2, "onGetGameRankingListSuc fail. userScores is empty!");
      }
      c(true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("GameResultFragment", 2, "onGetGameRankingListSuc fail. userInfoHandler or engineData is null");
    }
    c(false);
  }
  
  public void a(BaseAVGameAppInterface paramBaseAVGameAppInterface, long paramLong, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AVGameShareUtil.a().a(paramBaseAVGameAppInterface, paramLong, Long.valueOf(paramString1).longValue(), paramString2, 2, paramString3, paramInt, new GameResultFragment.3(this));
  }
  
  public void a(String paramString)
  {
    b();
    if (this.p) {
      return;
    }
    if ((getQBaseActivity() != null) && (!getQBaseActivity().isFinishing()))
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = getString(2131887349);
      }
      QQToast.makeText(getQBaseActivity(), 1, str, 1).show();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (getQBaseActivity() == null) {
      return;
    }
    AVGameHandler.a().c().post(new GameResultFragment.1(this, paramString2, paramString3));
  }
  
  public void b()
  {
    try
    {
      if ((this.q != null) && (this.q.isShowing())) {
        this.q.dismiss();
      }
      this.q = null;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameResultFragment", 2, localException.toString());
      }
    }
  }
  
  public void b(int paramInt)
  {
    QQProgressDialog localQQProgressDialog = this.q;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      return;
    }
    try
    {
      if (this.q == null) {
        this.q = new QQProgressDialog(getQBaseActivity(), ViewUtils.dpToPx(40.0F));
      }
      this.q.c(paramInt);
      this.q.c(false);
      this.q.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameResultFragment", 2, localException.toString());
      }
    }
  }
  
  public void b(EngineData paramEngineData)
  {
    b();
    if (m() != null) {
      m().showRoom();
    }
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int i1 = GameEngine.a().s().p();
        AVGameShareUtil.a().a(d(), paramString, i1);
        return;
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSavePosterSuc error: ");
        localStringBuilder.append(paramString.getMessage());
        QLog.e("GameResultFragment", 1, localStringBuilder.toString());
      }
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    paramString3 = new StringBuilder();
    paramString3.append("initViewForGameKnowledge ");
    paramString3.append(paramString1);
    QLog.d("GameResultFragment", 2, paramString3.toString());
    if (this.x != null)
    {
      this.k.setVisibility(4);
      this.n.setImageDrawable(new ColorDrawable(-10044417));
      this.x.setVisibility(0);
      this.x.removeAllViews();
      a(paramString1, paramString2);
      paramString1 = AVGameUtil.c("avgame_knowledgefallback@2x.png");
      if (paramString1 != null) {
        this.x.setBackgroundDrawable(new BitmapDrawable(paramString1));
      } else {
        this.x.setBackgroundColor(-10044417);
      }
      this.x.postDelayed(new GameResultFragment.4(this), 800L);
    }
  }
  
  public Activity d()
  {
    return getQBaseActivity();
  }
  
  public boolean e()
  {
    b(true);
    return true;
  }
  
  public View getView()
  {
    return super.getView();
  }
  
  public void onClick(View paramView)
  {
    int i1;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131429161: 
      this.a.i();
      ReportController.b(null, "dc00898", "", "", "0X800B061", "0X800B061", GameEngine.a().s().p(), 0, "", "", "", "");
      break;
    case 2131429154: 
      b(false);
      i1 = GameEngine.a().s().p();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(GameEngine.a().s().i());
      ReportController.b(null, "dc00898", "", "", "0X800B060", "0X800B060", i1, 0, ((StringBuilder)localObject).toString(), "", "", "");
      break;
    case 2131429129: 
      localObject = GameEngine.a().s().q();
      ReportController.b(null, "dc00898", "", "", "0X800B035", "0X800B035", FloatWindowController.c().a((Player)localObject) + 1, 0, "2", "", "", "");
      this.a.g();
      break;
    case 2131429128: 
      this.a.h();
      if (GameEngine.a().d()) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(GameEngine.a().s().i());
      ReportController.b(null, "dc00898", "", "", "0X800B02F", "0X800B02F", i1, 0, "", ((StringBuilder)localObject).toString(), "", "");
      break;
    case 2131429055: 
      boolean bool = this.l.isSelected();
      this.k.setMute(bool);
      this.l.setSelected(bool ^ true);
      ReportController.b(null, "dc00898", "", "", "0X800B05F", "0X800B05F", GameEngine.a().s().p(), 0, "", "", "", "");
      if (bool)
      {
        localObject = AVGameUtil.c("avgame_voice_off@2x.png");
        if (localObject != null) {
          this.l.setImageBitmap((Bitmap)localObject);
        }
      }
      break;
    }
    try
    {
      AVGameBusinessCtrl.b().c(true);
    }
    catch (Exception localException)
    {
      break label634;
    }
    Object localObject = AVGameUtil.c("avgame_voice_on@2x.png");
    if (localObject != null) {
      this.l.setImageBitmap((Bitmap)localObject);
    }
    AVGameBusinessCtrl.b().c(false);
    break label634;
    ReportController.b(null, "dc00898", "", "", "0X800B05E", "0X800B05E", GameEngine.a().s().p(), 0, "", "", "", "");
    localObject = getQBaseActivity();
    if (!CheckPermission.isHasStoragePermission((Context)localObject)) {
      CheckPermission.requestStorePermission((Activity)localObject, null);
    } else if (!FileUtils.fileExistsAndNotEmpty(this.s)) {
      QLog.e("GameResultFragment", 1, "saveToAlum file not exsited");
    } else if (QFileUtils.a(getQBaseActivity(), this.s)) {
      QQToast.makeText((Context)localObject, 2, 2131887370, 1).show();
    } else {
      QQToast.makeText((Context)localObject, 1, 2131887369, 1).show();
    }
    label634:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131624280, null);
    if (QLog.isColorLevel()) {
      QLog.i("GameResultFragment", 2, "onCreateView");
    }
    this.n = ((AsyncImageView)paramLayoutInflater.findViewById(2131429132));
    this.k = ((BaseVideoView)QQVideoViewFactory.createBaseVideoViewFS(getQBaseActivity(), 0L, null, null));
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    BaseVideoView localBaseVideoView = this.k;
    if (localBaseVideoView != null)
    {
      localBaseVideoView.releasePlayer(false);
      this.k = null;
    }
    b();
    this.a.c();
  }
  
  public void onPause()
  {
    super.onPause();
    BaseVideoView localBaseVideoView = this.k;
    if ((localBaseVideoView != null) && (localBaseVideoView.isPlaying())) {
      this.k.pause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.s != null)
    {
      BaseVideoView localBaseVideoView = this.k;
      if ((localBaseVideoView != null) && (!localBaseVideoView.isPlaying())) {
        this.k.resume();
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    b();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.b = ((AutoBgImageView)paramView.findViewById(2131429129));
    this.c = ((AutoBgImageView)paramView.findViewById(2131429128));
    this.d = ((Button)paramView.findViewById(2131429161));
    this.e = ((Button)paramView.findViewById(2131429154));
    this.f = ((ScrollView)paramView.findViewById(2131427891));
    this.g = ((LinearLayout)paramView.findViewById(2131427890));
    this.h = ((RelativeLayout)paramView.findViewById(2131429155));
    this.i = ((ProgressBar)paramView.findViewById(2131429138));
    this.j = ((TextView)paramView.findViewById(2131429139));
    this.l = ((AutoBgImageView)paramView.findViewById(2131429055));
    this.w = paramView.findViewById(2131429130);
    this.x = ((FrameLayout)paramView.findViewById(2131429145));
    paramBundle = AVGameUtil.c("avgame_result_bg@2x.png");
    if (paramBundle != null) {
      this.w.setBackgroundDrawable(new BitmapDrawable(paramBundle));
    }
    paramBundle = AVGameUtil.c("avgame_voice_off@2x.png");
    if (paramBundle != null) {
      this.l.setImageBitmap(paramBundle);
    }
    this.l.setSelected(false);
    this.m = ((AutoBgImageView)paramView.findViewById(2131429053));
    this.v = ((AVGamePosterView)paramView.findViewById(2131429121));
    this.v.setPresenter(this);
    GameEngine.a().s().v();
    paramView = (RoundCorneredRelativeLayout)paramView.findViewById(2131429165);
    float f1 = ViewUtils.dip2px(17.0F);
    paramView.setRadius(f1, f1, f1, f1);
    paramBundle = new RelativeLayout.LayoutParams(-1, -1);
    paramView.addView(this.k, paramBundle);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    paramView = AVGameUtil.c("avgame_download_normal@2x.png");
    if (paramView != null) {
      this.m.setImageBitmap(paramView);
    }
    this.a.b();
    f();
    FloatWindowController.c().d();
    AVGameNodeReportUtil.e();
    int i1 = GameEngine.a().s().p();
    paramView = new StringBuilder();
    paramView.append("");
    paramView.append(GameEngine.a().s().i());
    paramView = paramView.toString();
    paramBundle = new StringBuilder();
    paramBundle.append("");
    paramBundle.append(GameEngine.a().s().I());
    ReportController.b(null, "dc00898", "", "", "0X800B05B", "0X800B05B", i1, 0, paramView, paramBundle.toString(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultFragment
 * JD-Core Version:    0.7.0.1
 */