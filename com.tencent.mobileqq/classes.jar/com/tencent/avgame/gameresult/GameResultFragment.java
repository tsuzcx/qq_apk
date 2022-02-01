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
  protected long a;
  private View jdField_a_of_type_AndroidViewView;
  protected Button a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  protected LinearLayout a;
  protected ProgressBar a;
  protected RelativeLayout a;
  protected ScrollView a;
  protected TextView a;
  private UserInfoHandler jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler;
  protected IGameResultPresenter a;
  private AVGamePosterView jdField_a_of_type_ComTencentAvgameUiAVGamePosterView;
  protected AsyncImageView a;
  protected BaseVideoView a;
  protected AutoBgImageView a;
  protected QQProgressDialog a;
  private String jdField_a_of_type_JavaLangString;
  private CopyOnWriteArrayList<UserScore> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  protected boolean a;
  protected Button b;
  protected AutoBgImageView b;
  private String b;
  protected AutoBgImageView c;
  protected AutoBgImageView d;
  
  public GameResultFragment()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static GameResultFragment a()
  {
    GameResultFragment localGameResultFragment = new GameResultFragment();
    localGameResultFragment.setArguments(new Bundle());
    localGameResultFragment.jdField_a_of_type_ComTencentAvgameGameresultIGameResultPresenter = new GameResultPresenterImp(localGameResultFragment);
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
  
  private void a(UserInfoHandler paramUserInfoHandler, CopyOnWriteArrayList<UserScore> paramCopyOnWriteArrayList)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler = paramUserInfoHandler;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = paramCopyOnWriteArrayList;
    HashMap localHashMap = a(paramUserInfoHandler, paramCopyOnWriteArrayList);
    int i = 0;
    while (i < paramCopyOnWriteArrayList.size())
    {
      Object localObject3 = (UserScore)paramCopyOnWriteArrayList.get(i);
      try
      {
        Object localObject2 = LayoutInflater.from(getQBaseActivity()).inflate(2131558694, null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        Object localObject1 = paramUserInfoHandler.a(String.valueOf(((UserScore)localObject3).uin), (byte)3);
        ((ImageView)((View)localObject2).findViewById(2131363290)).setImageBitmap((Bitmap)localObject1);
        ((TextView)((View)localObject2).findViewById(2131363289)).setText((String)localHashMap.get(String.valueOf(((UserScore)localObject3).uin)));
        localObject1 = (TextView)((View)localObject2).findViewById(2131363286);
        ((TextView)localObject1).setText(String.valueOf(((UserScore)localObject3).score));
        localObject3 = (TextView)((View)localObject2).findViewById(2131363269);
        ((TextView)localObject3).setText(String.valueOf(i + 1));
        localObject2 = (ImageView)((View)localObject2).findViewById(2131363270);
        if (i == 0)
        {
          ((TextView)localObject3).setVisibility(8);
          localObject3 = AVGameUtil.a("avgame_ranking1@2x.png");
          if (localObject3 != null) {
            ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
          }
          ((ImageView)localObject2).setVisibility(0);
          ((TextView)localObject1).setTextColor(-13312);
        }
        else if (i == 1)
        {
          ((TextView)localObject3).setVisibility(8);
          localObject3 = AVGameUtil.a("avgame_ranking2@2x.png");
          if (localObject3 != null) {
            ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
          }
          ((ImageView)localObject2).setVisibility(0);
          ((TextView)localObject1).setTextColor(-8293377);
        }
        else if (i == 2)
        {
          ((TextView)localObject3).setVisibility(8);
          localObject3 = AVGameUtil.a("avgame_ranking3@2x.png");
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
      i += 1;
    }
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView.a(paramUserInfoHandler, paramCopyOnWriteArrayList);
  }
  
  private void a(String paramString1, String paramString2)
  {
    boolean bool = TextUtils.isEmpty(paramString2);
    int i = ViewUtils.a(30.0F);
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
    paramString1.leftMargin = i;
    paramString1.rightMargin = i;
    localLinearLayout.addView((View)localObject, paramString1);
    if ((bool ^ true))
    {
      paramString1 = new ImageView(getQBaseActivity());
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = true;
      paramString1.setImageDrawable(URLDrawable.getDrawable(paramString2, (URLDrawable.URLDrawableOptions)localObject));
      paramString1.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      paramString2 = new LinearLayout.LayoutParams(-1, ViewUtils.a(108.0F));
      paramString2.topMargin = ViewUtils.a(10.0F);
      paramString2.leftMargin = i;
      paramString2.rightMargin = i;
      paramString2.gravity = 1;
      localLinearLayout.addView(paramString1, paramString2);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localLinearLayout, localLayoutParams);
  }
  
  private void b()
  {
    c();
    if (!this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultPresenter.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameResultFragment", 2, "getRankingList failed.");
      }
      c(false);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L) {
      return;
    }
    b(2131690439);
    this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultPresenter.d();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690442));
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(8);
    if (!paramBoolean)
    {
      QQToast.a(getQBaseActivity(), 1, getString(2131690443), 0).a();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690443));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    SpannableString localSpannableString = new SpannableString(getString(2131690441));
    localSpannableString.setSpan(new GameResultFragment.5(this), 8, 14, 33);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableString);
    this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(0);
  }
  
  public Activity a()
  {
    return getQBaseActivity();
  }
  
  public void a()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameResultFragment", 2, localException.toString());
      }
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (paramInt == 1)
    {
      a();
      return;
    }
    if ((paramInt == 2) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null))
    {
      FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
      if ((localFrameLayout != null) && (localFrameLayout.getVisibility() == 0)) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultPresenter.b();
      b();
      FloatWindowController.a().c();
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
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
    if (localObject1 != null) {
      if (paramString2 != null)
      {
        ((BaseVideoView)localObject1).setVisibility(0);
        localObject1 = new VideoPlayParam();
        ((VideoPlayParam)localObject1).mIsLocal = true;
        ((VideoPlayParam)localObject1).mSceneId = 107;
        ((VideoPlayParam)localObject1).mIsMute = true;
        ((VideoPlayParam)localObject1).mSceneName = SceneID.a(107);
        ((VideoPlayParam)localObject1).mVideoPath = paramString2;
        ((VideoPlayParam)localObject1).mIsLoop = true;
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVideoParam((VideoPlayParam)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.play();
      }
      else
      {
        ((BaseVideoView)localObject1).setVisibility(4);
        if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying()) {
          this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
        }
      }
    }
    if (FileUtil.b(paramString2))
    {
      int i = GameEngine.a().a().d();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(GameEngine.a().a().a());
      ReportController.b(null, "dc00898", "", "", "0X800B05C", "0X800B05C", i, 0, ((StringBuilder)localObject1).toString(), "", "", "");
    }
    else
    {
      ReportController.b(null, "dc00898", "", "", "0X800B05D", "0X800B05D", GameEngine.a().a().d(), 0, "", "", "", "");
    }
    this.c.setSelected(false);
    localObject1 = AVGameUtil.a("avgame_voice_off@2x.png");
    if (localObject1 != null) {
      this.c.setImageBitmap((Bitmap)localObject1);
    }
    localObject1 = "avgame_actfallback@2x.png";
    Object localObject2;
    if (paramString1 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.post(new GameResultFragment.2(this, paramString1));
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
      Bitmap localBitmap = AVGameUtil.a((String)localObject1);
      localObject2 = localObject1;
      if (localBitmap != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageBitmap(localBitmap);
        localObject2 = localObject1;
      }
    }
    if (TextUtils.isEmpty(paramString2))
    {
      this.c.setVisibility(8);
      this.d.setVisibility(8);
    }
    else
    {
      this.c.setVisibility(0);
      this.d.setVisibility(0);
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView.a(this.jdField_a_of_type_JavaLangString, (String)localObject2);
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView.setContentAndTitleView(paramInt);
  }
  
  public void a(EngineData paramEngineData)
  {
    if (getQBaseActivity() == null) {
      return;
    }
    UserInfoHandler localUserInfoHandler = (UserInfoHandler)GameEngine.a().a().getBusinessHandler(HandlerFactory.jdField_b_of_type_JavaLangString);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramEngineData != null)
    {
      localObject1 = localObject2;
      if (paramEngineData.a() != null) {
        localObject1 = paramEngineData.a().a();
      }
    }
    if ((localUserInfoHandler != null) && (paramEngineData != null) && (paramEngineData.a()) && (localObject1 != null) && (((CopyOnWriteArrayList)localObject1).size() > 0))
    {
      a(localUserInfoHandler, (CopyOnWriteArrayList)localObject1);
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
    a();
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((getQBaseActivity() != null) && (!getQBaseActivity().isFinishing()))
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = getString(2131690438);
      }
      QQToast.a(getQBaseActivity(), 1, str, 1).a();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (getQBaseActivity() == null) {
      return;
    }
    AVGameHandler.a().b().post(new GameResultFragment.1(this, paramString2, paramString3));
  }
  
  public boolean a()
  {
    b(true);
    return true;
  }
  
  public void b(int paramInt)
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getQBaseActivity(), ViewUtils.b(40.0F));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
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
    a();
    if (a() != null) {
      a().showRoom();
    }
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int i = GameEngine.a().a().d();
        AVGameShareUtil.a().a(a(), paramString, i);
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
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageDrawable(new ColorDrawable(-10044417));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      a(paramString1, paramString2);
      paramString1 = AVGameUtil.a("avgame_knowledgefallback@2x.png");
      if (paramString1 != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(new BitmapDrawable(paramString1));
      } else {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-10044417);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.postDelayed(new GameResultFragment.4(this), 800L);
    }
  }
  
  public View getView()
  {
    return super.getView();
  }
  
  public void onClick(View paramView)
  {
    int i;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131363287: 
      this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultPresenter.g();
      ReportController.b(null, "dc00898", "", "", "0X800B061", "0X800B061", GameEngine.a().a().d(), 0, "", "", "", "");
      break;
    case 2131363280: 
      b(false);
      i = GameEngine.a().a().d();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(GameEngine.a().a().a());
      ReportController.b(null, "dc00898", "", "", "0X800B060", "0X800B060", i, 0, ((StringBuilder)localObject).toString(), "", "", "");
      break;
    case 2131363255: 
      localObject = GameEngine.a().a().a();
      ReportController.b(null, "dc00898", "", "", "0X800B035", "0X800B035", FloatWindowController.a().a((Player)localObject) + 1, 0, "2", "", "", "");
      this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultPresenter.e();
      break;
    case 2131363254: 
      this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultPresenter.f();
      if (GameEngine.a().a()) {
        i = 1;
      } else {
        i = 2;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(GameEngine.a().a().a());
      ReportController.b(null, "dc00898", "", "", "0X800B02F", "0X800B02F", i, 0, "", ((StringBuilder)localObject).toString(), "", "");
      break;
    case 2131363181: 
      boolean bool = this.c.isSelected();
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setMute(bool);
      this.c.setSelected(bool ^ true);
      ReportController.b(null, "dc00898", "", "", "0X800B05F", "0X800B05F", GameEngine.a().a().d(), 0, "", "", "", "");
      if (bool)
      {
        localObject = AVGameUtil.a("avgame_voice_off@2x.png");
        if (localObject != null) {
          this.c.setImageBitmap((Bitmap)localObject);
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
      break label633;
    }
    Object localObject = AVGameUtil.a("avgame_voice_on@2x.png");
    if (localObject != null) {
      this.c.setImageBitmap((Bitmap)localObject);
    }
    AVGameBusinessCtrl.b().c(false);
    break label633;
    ReportController.b(null, "dc00898", "", "", "0X800B05E", "0X800B05E", GameEngine.a().a().d(), 0, "", "", "", "");
    localObject = getQBaseActivity();
    if (!CheckPermission.isHasStoragePermission((Context)localObject)) {
      CheckPermission.requestStorePermission((Activity)localObject, null);
    } else if (!FileUtils.fileExistsAndNotEmpty(this.jdField_b_of_type_JavaLangString)) {
      QLog.e("GameResultFragment", 1, "saveToAlum file not exsited");
    } else if (QFileUtils.a(getQBaseActivity(), this.jdField_b_of_type_JavaLangString)) {
      QQToast.a((Context)localObject, 2, 2131690459, 1).a();
    } else {
      QQToast.a((Context)localObject, 1, 2131690458, 1).a();
    }
    label633:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558663, null);
    if (QLog.isColorLevel()) {
      QLog.i("GameResultFragment", 2, "onCreateView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramLayoutInflater.findViewById(2131363258));
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((BaseVideoView)QQVideoViewFactory.c(getQBaseActivity(), 0L, null, null));
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
    BaseVideoView localBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
    if (localBaseVideoView != null)
    {
      localBaseVideoView.releasePlayer(false);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = null;
    }
    a();
    this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultPresenter.c();
  }
  
  public void onPause()
  {
    super.onPause();
    BaseVideoView localBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
    if ((localBaseVideoView != null) && (localBaseVideoView.isPlaying())) {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_b_of_type_JavaLangString != null)
    {
      BaseVideoView localBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
      if ((localBaseVideoView != null) && (!localBaseVideoView.isPlaying())) {
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.resume();
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
    a();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramView.findViewById(2131363255));
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramView.findViewById(2131363254));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363287));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363280));
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)paramView.findViewById(2131362292));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131362291));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363281));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131363264));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363265));
    this.c = ((AutoBgImageView)paramView.findViewById(2131363181));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363256);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131363271));
    paramBundle = AVGameUtil.a("avgame_result_bg@2x.png");
    if (paramBundle != null) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new BitmapDrawable(paramBundle));
    }
    paramBundle = AVGameUtil.a("avgame_voice_off@2x.png");
    if (paramBundle != null) {
      this.c.setImageBitmap(paramBundle);
    }
    this.c.setSelected(false);
    this.d = ((AutoBgImageView)paramView.findViewById(2131363179));
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView = ((AVGamePosterView)paramView.findViewById(2131363247));
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView.setPresenter(this);
    GameEngine.a().a().a();
    paramView = (RoundCorneredRelativeLayout)paramView.findViewById(2131363291);
    float f = ViewUtils.a(17.0F);
    paramView.setRadius(f, f, f, f);
    paramBundle = new RelativeLayout.LayoutParams(-1, -1);
    paramView.addView(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    paramView = AVGameUtil.a("avgame_download_normal@2x.png");
    if (paramView != null) {
      this.d.setImageBitmap(paramView);
    }
    this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultPresenter.b();
    b();
    FloatWindowController.a().c();
    AVGameNodeReportUtil.e();
    int i = GameEngine.a().a().d();
    paramView = new StringBuilder();
    paramView.append("");
    paramView.append(GameEngine.a().a().a());
    paramView = paramView.toString();
    paramBundle = new StringBuilder();
    paramBundle.append("");
    paramBundle.append(GameEngine.a().a().h());
    ReportController.b(null, "dc00898", "", "", "0X800B05B", "0X800B05B", i, 0, paramView, paramBundle.toString(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultFragment
 * JD-Core Version:    0.7.0.1
 */