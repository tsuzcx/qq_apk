package com.tencent.avgame.gameresult;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import aono;
import auog;
import auoo;
import baph;
import bapi;
import bdll;
import bhmi;
import bhtq;
import bjbs;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.UserScore;
import com.tencent.avgame.ui.AVGamePosterView;
import com.tencent.avgame.ui.GameBaseFragment;
import com.tencent.avgame.util.AVGameNodeReportUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mxo;
import mya;
import myk;
import mze;
import mzf;
import nan;
import nao;
import nap;
import nau;
import nav;
import nfm;
import ngk;
import nhm;
import nhn;
import nhs;

public class GameResultFragment
  extends GameBaseFragment
  implements View.OnClickListener, nav, nhn
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
  protected bjbs a;
  private AVGamePosterView jdField_a_of_type_ComTencentAvgameUiAVGamePosterView;
  protected AsyncImageView a;
  protected BaseVideoView a;
  protected AutoBgImageView a;
  private String jdField_a_of_type_JavaLangString;
  private CopyOnWriteArrayList<UserScore> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private mxo jdField_a_of_type_Mxo;
  protected nau a;
  protected boolean a;
  protected Button b;
  protected AutoBgImageView b;
  private String b;
  protected AutoBgImageView c;
  protected AutoBgImageView d;
  
  public static GameResultFragment a()
  {
    GameResultFragment localGameResultFragment = new GameResultFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("should_restore_from_kill", false);
    localGameResultFragment.setArguments(localBundle);
    localGameResultFragment.jdField_a_of_type_Nau = new nap(localGameResultFragment);
    return localGameResultFragment;
  }
  
  private HashMap<String, String> a(mxo parammxo, CopyOnWriteArrayList<UserScore> paramCopyOnWriteArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    while (paramCopyOnWriteArrayList.hasNext()) {
      localArrayList.add(String.valueOf(((UserScore)paramCopyOnWriteArrayList.next()).uin));
    }
    return parammxo.a(localArrayList);
  }
  
  private void a(mxo parammxo, CopyOnWriteArrayList<UserScore> paramCopyOnWriteArrayList)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_Mxo = parammxo;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = paramCopyOnWriteArrayList;
    HashMap localHashMap = a(parammxo, paramCopyOnWriteArrayList);
    int i = 0;
    for (;;)
    {
      if (i < paramCopyOnWriteArrayList.size())
      {
        Object localObject3 = (UserScore)paramCopyOnWriteArrayList.get(i);
        Object localObject2;
        try
        {
          localObject2 = LayoutInflater.from(getActivity()).inflate(2131558728, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
          Object localObject1 = parammxo.a(String.valueOf(((UserScore)localObject3).uin), (byte)3);
          ((ImageView)((View)localObject2).findViewById(2131363194)).setImageBitmap((Bitmap)localObject1);
          ((TextView)((View)localObject2).findViewById(2131363193)).setText((String)localHashMap.get(String.valueOf(((UserScore)localObject3).uin)));
          localObject1 = (TextView)((View)localObject2).findViewById(2131363191);
          ((TextView)localObject1).setText(String.valueOf(((UserScore)localObject3).score));
          localObject3 = (TextView)((View)localObject2).findViewById(2131363185);
          ((TextView)localObject3).setText(String.valueOf(i + 1));
          localObject2 = (ImageView)((View)localObject2).findViewById(2131363186);
          if (i == 0)
          {
            ((TextView)localObject3).setVisibility(8);
            localObject3 = nhs.a("avgame_ranking1@2x.png");
            if (localObject3 != null) {
              ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
            }
            ((ImageView)localObject2).setVisibility(0);
            ((TextView)localObject1).setTextColor(-13312);
          }
          else if (i == 1)
          {
            ((TextView)localObject3).setVisibility(8);
            localObject3 = nhs.a("avgame_ranking2@2x.png");
            if (localObject3 != null) {
              ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
            }
            ((ImageView)localObject2).setVisibility(0);
            ((TextView)localObject1).setTextColor(-8293377);
          }
        }
        catch (Exception localException)
        {
          QLog.e("GameResultFragment", 2, "onGetGameRankingListSuc exception!");
          localException.printStackTrace();
        }
        if (i == 2)
        {
          ((TextView)localObject3).setVisibility(8);
          localObject3 = nhs.a("avgame_ranking3@2x.png");
          if (localObject3 != null) {
            ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
          }
          ((ImageView)localObject2).setVisibility(0);
          localException.setTextColor(-32564);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView.a(parammxo, paramCopyOnWriteArrayList);
        return;
      }
      i += 1;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L) {
      return;
    }
    b(2131690330);
    this.jdField_a_of_type_Nau.e();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void b()
  {
    c();
    if (!this.jdField_a_of_type_Nau.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameResultFragment", 2, "getRankingList failed.");
      }
      b(false);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(8);
    if (!paramBoolean)
    {
      QQToast.a(getActivity(), 1, getString(2131690334), 0).a();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690334));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    SpannableString localSpannableString = new SpannableString(getString(2131690332));
    localSpannableString.setSpan(new nao(this), 8, 14, 33);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableString);
    this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(0);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690333));
  }
  
  public Activity a()
  {
    return getActivity();
  }
  
  public void a()
  {
    try
    {
      if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
        this.jdField_a_of_type_Bjbs.dismiss();
      }
      this.jdField_a_of_type_Bjbs = null;
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("GameResultFragment", 2, localException.toString());
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (paramInt == 1) {
      a();
    }
    while ((paramInt != 2) || (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null)) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    this.jdField_a_of_type_Nau.a();
    b();
    mya.a().c();
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    QLog.d("GameResultFragment", 2, "onGameResultResourcesInfo " + paramInt + " " + paramString1 + " " + paramString2);
    Object localObject1;
    label197:
    Object localObject2;
    if (paramString2 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVisibility(0);
      localObject1 = new VideoPlayParam();
      ((VideoPlayParam)localObject1).mIsLocal = true;
      ((VideoPlayParam)localObject1).mSceneId = 107;
      ((VideoPlayParam)localObject1).mIsMute = true;
      ((VideoPlayParam)localObject1).mSceneName = bapi.a(107);
      ((VideoPlayParam)localObject1).mVideoPath = paramString2;
      ((VideoPlayParam)localObject1).mIsLoop = true;
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVideoParam((VideoPlayParam)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.play();
      if (!auog.a(paramString2)) {
        break label316;
      }
      bdll.b(null, "dc00898", "", "", "0X800B05C", "0X800B05C", myk.a().a().d(), 0, "" + myk.a().a().a(), "", "", "");
      this.c.setSelected(false);
      localObject2 = "avgame_actfallback@2x.png";
      if (paramString1 == null) {
        break label360;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.post(new GameResultFragment.2(this, paramString1));
      if (!TextUtils.isEmpty(paramString2)) {
        break label497;
      }
      this.c.setVisibility(8);
      this.d.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView.a(this.jdField_a_of_type_JavaLangString, (String)localObject2);
      this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView.setContentAndTitleView(paramInt);
      return;
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVisibility(4);
      if (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
      break;
      label316:
      bdll.b(null, "dc00898", "", "", "0X800B05D", "0X800B05D", myk.a().a().d(), 0, "", "", "", "");
      break label197;
      label360:
      if (paramInt == 1) {
        localObject1 = "avgame_actfallback@2x.png";
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          break;
        }
        Bitmap localBitmap = nhs.a((String)localObject1);
        localObject2 = localObject1;
        if (localBitmap == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageBitmap(localBitmap);
        localObject2 = localObject1;
        break;
        if (paramInt == 2)
        {
          localObject1 = "avgame_poster_mosaic_fallback@2x.png";
        }
        else if (paramInt == 3)
        {
          localObject1 = "avgame_actfallback@2x.png";
        }
        else if (paramInt == 4)
        {
          localObject1 = "avgame_songfallback@2x.png";
        }
        else if (paramInt == 5)
        {
          localObject1 = "avgame_knowledgefallback@2x.png";
        }
        else
        {
          localObject1 = "avgame_actfallback@2x.png";
          QLog.e("GameResultFragment", 1, "error game Type:" + paramInt);
        }
      }
      label497:
      this.c.setVisibility(0);
      this.d.setVisibility(0);
    }
  }
  
  public void a(AVGameAppInterface paramAVGameAppInterface, long paramLong, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    aono.a().a(paramAVGameAppInterface, paramLong, Long.valueOf(paramString1).longValue(), paramString2, 2, paramString3, paramInt, new nan(this));
  }
  
  public void a(String paramString)
  {
    a();
    if (this.jdField_a_of_type_Boolean) {}
    while ((getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131690329);
    }
    QQToast.a(getActivity(), 1, str, 1).a();
  }
  
  public void a(String paramString1, String paramString2)
  {
    QLog.d("GameResultFragment", 2, "initViewForGameKnowledge " + paramString1);
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageDrawable(new ColorDrawable(-10044417));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      paramString2 = new TextView(getActivity());
      if (paramString1 != null) {
        paramString2.setText(paramString1);
      }
      paramString2.setTextColor(-1);
      paramString2.setTextSize(20.0F);
      paramString2.setTypeface(null, 1);
      paramString2.setGravity(3);
      paramString1 = new FrameLayout.LayoutParams(-1, -2, 17);
      int i = bhtq.a(30.0F);
      paramString1.rightMargin = i;
      paramString1.leftMargin = i;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramString2, paramString1);
      paramString1 = nhs.a("avgame_knowledgefallback@2x.png");
      if (paramString1 == null) {
        break label202;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(new BitmapDrawable(paramString1));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.postDelayed(new GameResultFragment.4(this), 800L);
      return;
      label202:
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-10044417);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (getActivity() == null) {
      return;
    }
    ngk.a().b().post(new GameResultFragment.1(this, paramString2, paramString3));
  }
  
  public void a(mze parammze)
  {
    if (getActivity() == null) {
      return;
    }
    mxo localmxo = (mxo)myk.a().a().a(2);
    CopyOnWriteArrayList localCopyOnWriteArrayList = parammze.a().a();
    if ((localmxo != null) && (parammze != null) && (parammze.a()) && (localCopyOnWriteArrayList != null) && (localCopyOnWriteArrayList.size() > 0))
    {
      a(localmxo, localCopyOnWriteArrayList);
      return;
    }
    if ((localmxo == null) || (parammze == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameResultFragment", 2, "onGetGameRankingListSuc fail. userInfoHandler or engineData is null");
      }
      b(false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("GameResultFragment", 2, "onGetGameRankingListSuc fail. userScores is empty!");
    }
    b(true);
  }
  
  public boolean a()
  {
    a(true);
    return true;
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {}
    do
    {
      return;
      try
      {
        if (this.jdField_a_of_type_Bjbs == null) {
          this.jdField_a_of_type_Bjbs = new bjbs(getActivity(), bhtq.b(40.0F));
        }
        this.jdField_a_of_type_Bjbs.c(paramInt);
        this.jdField_a_of_type_Bjbs.c(false);
        this.jdField_a_of_type_Bjbs.show();
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.i("GameResultFragment", 2, localException.toString());
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      int i = myk.a().a().d();
      aono.a().a(a(), paramString, i);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("GameResultFragment", 1, "onSavePosterSuc error: " + paramString.getMessage());
    }
  }
  
  public void b(mze parammze)
  {
    a();
    if (a() != null) {
      a().b();
    }
  }
  
  public View getView()
  {
    return super.getView();
  }
  
  public void onClick(View paramView)
  {
    boolean bool1 = true;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = myk.a().a().a();
      bdll.b(null, "dc00898", "", "", "0X800B035", "0X800B035", mya.a().a((Player)localObject) + 1, 0, "2", "", "", "");
      this.jdField_a_of_type_Nau.b();
      continue;
      this.jdField_a_of_type_Nau.c();
      if (myk.a().a()) {}
      for (int i = 1;; i = 2)
      {
        bdll.b(null, "dc00898", "", "", "0X800B02F", "0X800B02F", i, 0, "", "" + myk.a().a().a(), "", "");
        break;
      }
      this.jdField_a_of_type_Nau.d();
      bdll.b(null, "dc00898", "", "", "0X800B061", "0X800B061", myk.a().a().d(), 0, "", "", "", "");
      continue;
      a(false);
      bdll.b(null, "dc00898", "", "", "0X800B060", "0X800B060", myk.a().a().d(), 0, "" + myk.a().a().a(), "", "", "");
      continue;
      boolean bool2 = this.c.isSelected();
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setMute(bool2);
      localObject = this.c;
      if (!bool2) {}
      for (;;)
      {
        for (;;)
        {
          ((AutoBgImageView)localObject).setSelected(bool1);
          bdll.b(null, "dc00898", "", "", "0X800B05F", "0X800B05F", myk.a().a().d(), 0, "", "", "", "");
          if (!bool2) {
            break label473;
          }
          localObject = nhs.a("avgame_voice_off@2x.png");
          if (localObject != null) {
            this.c.setImageBitmap((Bitmap)localObject);
          }
          try
          {
            nfm.b().b(true);
          }
          catch (Exception localException1) {}
        }
        break;
        bool1 = false;
      }
      label473:
      Bitmap localBitmap = nhs.a("avgame_voice_on@2x.png");
      if (localBitmap != null) {
        this.c.setImageBitmap(localBitmap);
      }
      try
      {
        nfm.b().b(false);
      }
      catch (Exception localException2) {}
      continue;
      bdll.b(null, "dc00898", "", "", "0X800B05E", "0X800B05E", myk.a().a().d(), 0, "", "", "", "");
      FragmentActivity localFragmentActivity = getActivity();
      if (!CheckPermission.isHasStoragePermission(localFragmentActivity)) {
        CheckPermission.requestStorePermission(localFragmentActivity, null);
      } else if (!bhmi.b(this.jdField_b_of_type_JavaLangString)) {
        QLog.e("GameResultFragment", 1, "saveToAlum file not exsited");
      } else if (auoo.a(getActivity(), this.jdField_b_of_type_JavaLangString)) {
        QQToast.a(localFragmentActivity, 2, 2131690345, 1).a();
      } else {
        QQToast.a(localFragmentActivity, 1, 2131690344, 1).a();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558713, null);
    if (QLog.isColorLevel()) {
      QLog.i("GameResultFragment", 2, "onCreateView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramLayoutInflater.findViewById(2131363182));
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((BaseVideoView)baph.c(getActivity(), 0L, null, null));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.releasePlayer(false);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = null;
    }
    a();
    this.jdField_a_of_type_Nau.f();
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying())) {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying())) {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.resume();
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramView.findViewById(2131363180));
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramView.findViewById(2131363179));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363192));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363188));
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)paramView.findViewById(2131362295));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131362294));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363189));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131363183));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363184));
    this.c = ((AutoBgImageView)paramView.findViewById(2131363159));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363181);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131363187));
    paramBundle = nhs.a("avgame_result_bg@2x.png");
    if (paramBundle != null) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new BitmapDrawable(paramBundle));
    }
    paramBundle = nhs.a("avgame_voice_off@2x.png");
    if (paramBundle != null) {
      this.c.setImageBitmap(paramBundle);
    }
    this.c.setSelected(false);
    this.d = ((AutoBgImageView)paramView.findViewById(2131363157));
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView = ((AVGamePosterView)paramView.findViewById(2131363174));
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView.setPresenter(this);
    myk.a().a().a();
    paramView = (RoundCorneredRelativeLayout)paramView.findViewById(2131363195);
    int i = bhtq.a(17.0F);
    paramView.setRadius(i, i, i, i);
    paramBundle = new RelativeLayout.LayoutParams(-1, -1);
    paramView.addView(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    paramView = nhs.a("avgame_download_normal@2x.png");
    if (paramView != null) {
      this.d.setImageBitmap(paramView);
    }
    this.jdField_a_of_type_Nau.a();
    b();
    mya.a().c();
    AVGameNodeReportUtil.e();
    bdll.b(null, "dc00898", "", "", "0X800B05B", "0X800B05B", myk.a().a().d(), 0, "" + myk.a().a().a(), "" + myk.a().a().h(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultFragment
 * JD-Core Version:    0.7.0.1
 */