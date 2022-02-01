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
import aojq;
import aufd;
import bapu;
import bapv;
import bdla;
import bisl;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.UserScore;
import com.tencent.avgame.ui.AVGamePosterView;
import com.tencent.avgame.ui.GameBaseFragment;
import com.tencent.avgame.util.AVGameNodeReportUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
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
import ndl;
import ndx;
import nfc;
import nfv;
import nfw;
import nhi;
import nhj;
import nhn;
import nhs;
import nht;
import nnm;
import nom;
import npy;
import npz;
import nqf;

public class GameResultFragment
  extends GameBaseFragment
  implements View.OnClickListener, nht, npz
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
  protected bisl a;
  private AVGamePosterView jdField_a_of_type_ComTencentAvgameUiAVGamePosterView;
  protected AsyncImageView a;
  protected BaseVideoView a;
  protected AutoBgImageView a;
  private String jdField_a_of_type_JavaLangString;
  private CopyOnWriteArrayList<UserScore> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private ndl jdField_a_of_type_Ndl;
  protected nhs a;
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
    localGameResultFragment.jdField_a_of_type_Nhs = new nhn(localGameResultFragment);
    return localGameResultFragment;
  }
  
  private HashMap<String, String> a(ndl paramndl, CopyOnWriteArrayList<UserScore> paramCopyOnWriteArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    while (paramCopyOnWriteArrayList.hasNext()) {
      localArrayList.add(String.valueOf(((UserScore)paramCopyOnWriteArrayList.next()).uin));
    }
    return paramndl.a(localArrayList);
  }
  
  private void a(ndl paramndl, CopyOnWriteArrayList<UserScore> paramCopyOnWriteArrayList)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_Ndl = paramndl;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = paramCopyOnWriteArrayList;
    HashMap localHashMap = a(paramndl, paramCopyOnWriteArrayList);
    int i = 0;
    for (;;)
    {
      if (i < paramCopyOnWriteArrayList.size())
      {
        Object localObject3 = (UserScore)paramCopyOnWriteArrayList.get(i);
        Object localObject2;
        try
        {
          localObject2 = LayoutInflater.from(getActivity()).inflate(2131558753, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
          Object localObject1 = paramndl.a(String.valueOf(((UserScore)localObject3).uin), (byte)3);
          ((ImageView)((View)localObject2).findViewById(2131363279)).setImageBitmap((Bitmap)localObject1);
          ((TextView)((View)localObject2).findViewById(2131363278)).setText((String)localHashMap.get(String.valueOf(((UserScore)localObject3).uin)));
          localObject1 = (TextView)((View)localObject2).findViewById(2131363275);
          ((TextView)localObject1).setText(String.valueOf(((UserScore)localObject3).score));
          localObject3 = (TextView)((View)localObject2).findViewById(2131363258);
          ((TextView)localObject3).setText(String.valueOf(i + 1));
          localObject2 = (ImageView)((View)localObject2).findViewById(2131363259);
          if (i == 0)
          {
            ((TextView)localObject3).setVisibility(8);
            localObject3 = nqf.a("avgame_ranking1@2x.png");
            if (localObject3 != null) {
              ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
            }
            ((ImageView)localObject2).setVisibility(0);
            ((TextView)localObject1).setTextColor(-13312);
          }
          else if (i == 1)
          {
            ((TextView)localObject3).setVisibility(8);
            localObject3 = nqf.a("avgame_ranking2@2x.png");
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
          localObject3 = nqf.a("avgame_ranking3@2x.png");
          if (localObject3 != null) {
            ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
          }
          ((ImageView)localObject2).setVisibility(0);
          localException.setTextColor(-32564);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView.a(paramndl, paramCopyOnWriteArrayList);
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
    b(2131690421);
    this.jdField_a_of_type_Nhs.e();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void b()
  {
    c();
    if (!this.jdField_a_of_type_Nhs.a())
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
      QQToast.a(getActivity(), 1, getString(2131690425), 0).a();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690425));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    SpannableString localSpannableString = new SpannableString(getString(2131690423));
    localSpannableString.setSpan(new nhj(this), 8, 14, 33);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableString);
    this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(0);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690424));
  }
  
  public Activity a()
  {
    return getActivity();
  }
  
  public void a()
  {
    try
    {
      if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
        this.jdField_a_of_type_Bisl.dismiss();
      }
      this.jdField_a_of_type_Bisl = null;
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
    this.jdField_a_of_type_Nhs.a();
    b();
    ndx.a().c();
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    QLog.d("GameResultFragment", 2, "onGameResultResourcesInfo " + paramInt + " " + paramString1 + " " + paramString2);
    Object localObject1;
    label204:
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null)
    {
      if (paramString2 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVisibility(0);
        localObject1 = new VideoPlayParam();
        ((VideoPlayParam)localObject1).mIsLocal = true;
        ((VideoPlayParam)localObject1).mSceneId = 107;
        ((VideoPlayParam)localObject1).mIsMute = true;
        ((VideoPlayParam)localObject1).mSceneName = bapv.a(107);
        ((VideoPlayParam)localObject1).mVideoPath = paramString2;
        ((VideoPlayParam)localObject1).mIsLoop = true;
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVideoParam((VideoPlayParam)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.play();
      }
    }
    else
    {
      if (!FileUtil.isFileExists(paramString2)) {
        break label345;
      }
      bdla.b(null, "dc00898", "", "", "0X800B05C", "0X800B05C", nfc.a().a().d(), 0, "" + nfc.a().a().a(), "", "", "");
      this.c.setSelected(false);
      localObject1 = nqf.a("avgame_voice_off@2x.png");
      if (localObject1 != null) {
        this.c.setImageBitmap((Bitmap)localObject1);
      }
      localObject2 = "avgame_actfallback@2x.png";
      if (paramString1 == null) {
        break label389;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.post(new GameResultFragment.2(this, paramString1));
      if (!TextUtils.isEmpty(paramString2)) {
        break label526;
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
      label345:
      bdla.b(null, "dc00898", "", "", "0X800B05D", "0X800B05D", nfc.a().a().d(), 0, "", "", "", "");
      break label204;
      label389:
      if (paramInt == 1) {
        localObject1 = "avgame_actfallback@2x.png";
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          break;
        }
        Bitmap localBitmap = nqf.a((String)localObject1);
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
      label526:
      this.c.setVisibility(0);
      this.d.setVisibility(0);
    }
  }
  
  public void a(AVGameAppInterface paramAVGameAppInterface, long paramLong, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    aojq.a().a(paramAVGameAppInterface, paramLong, Long.valueOf(paramString1).longValue(), paramString2, 2, paramString3, paramInt, new nhi(this));
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
      str = getString(2131690420);
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
      int i = ViewUtils.dip2px(30.0F);
      paramString1.rightMargin = i;
      paramString1.leftMargin = i;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramString2, paramString1);
      paramString1 = nqf.a("avgame_knowledgefallback@2x.png");
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
    nom.a().b().post(new GameResultFragment.1(this, paramString2, paramString3));
  }
  
  public void a(nfv paramnfv)
  {
    if (getActivity() == null) {
      return;
    }
    ndl localndl = (ndl)nfc.a().a().a(2);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramnfv != null)
    {
      localObject1 = localObject2;
      if (paramnfv.a() != null) {
        localObject1 = paramnfv.a().a();
      }
    }
    if ((localndl != null) && (paramnfv != null) && (paramnfv.a()) && (localObject1 != null) && (((CopyOnWriteArrayList)localObject1).size() > 0))
    {
      a(localndl, (CopyOnWriteArrayList)localObject1);
      return;
    }
    if ((localndl == null) || (paramnfv == null))
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
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {}
    do
    {
      return;
      try
      {
        if (this.jdField_a_of_type_Bisl == null) {
          this.jdField_a_of_type_Bisl = new bisl(getActivity(), ViewUtils.dpToPx(40.0F));
        }
        this.jdField_a_of_type_Bisl.c(paramInt);
        this.jdField_a_of_type_Bisl.c(false);
        this.jdField_a_of_type_Bisl.show();
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
      int i = nfc.a().a().d();
      aojq.a().a(a(), paramString, i);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("GameResultFragment", 1, "onSavePosterSuc error: " + paramString.getMessage());
    }
  }
  
  public void b(nfv paramnfv)
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
      Object localObject = nfc.a().a().a();
      bdla.b(null, "dc00898", "", "", "0X800B035", "0X800B035", ndx.a().a((Player)localObject) + 1, 0, "2", "", "", "");
      this.jdField_a_of_type_Nhs.b();
      continue;
      this.jdField_a_of_type_Nhs.c();
      if (nfc.a().a()) {}
      for (int i = 1;; i = 2)
      {
        bdla.b(null, "dc00898", "", "", "0X800B02F", "0X800B02F", i, 0, "", "" + nfc.a().a().a(), "", "");
        break;
      }
      this.jdField_a_of_type_Nhs.d();
      bdla.b(null, "dc00898", "", "", "0X800B061", "0X800B061", nfc.a().a().d(), 0, "", "", "", "");
      continue;
      a(false);
      bdla.b(null, "dc00898", "", "", "0X800B060", "0X800B060", nfc.a().a().d(), 0, "" + nfc.a().a().a(), "", "", "");
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
          bdla.b(null, "dc00898", "", "", "0X800B05F", "0X800B05F", nfc.a().a().d(), 0, "", "", "", "");
          if (!bool2) {
            break label473;
          }
          localObject = nqf.a("avgame_voice_off@2x.png");
          if (localObject != null) {
            this.c.setImageBitmap((Bitmap)localObject);
          }
          try
          {
            nnm.b().b(true);
          }
          catch (Exception localException1) {}
        }
        break;
        bool1 = false;
      }
      label473:
      Bitmap localBitmap = nqf.a("avgame_voice_on@2x.png");
      if (localBitmap != null) {
        this.c.setImageBitmap(localBitmap);
      }
      try
      {
        nnm.b().b(false);
      }
      catch (Exception localException2) {}
      continue;
      bdla.b(null, "dc00898", "", "", "0X800B05E", "0X800B05E", nfc.a().a().d(), 0, "", "", "", "");
      FragmentActivity localFragmentActivity = getActivity();
      if (!CheckPermission.isHasStoragePermission(localFragmentActivity)) {
        CheckPermission.requestStorePermission(localFragmentActivity, null);
      } else if (!FileUtils.fileExistsAndNotEmpty(this.jdField_b_of_type_JavaLangString)) {
        QLog.e("GameResultFragment", 1, "saveToAlum file not exsited");
      } else if (aufd.a(getActivity(), this.jdField_b_of_type_JavaLangString)) {
        QQToast.a(localFragmentActivity, 2, 2131690441, 1).a();
      } else {
        QQToast.a(localFragmentActivity, 1, 2131690440, 1).a();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558733, null);
    if (QLog.isColorLevel()) {
      QLog.i("GameResultFragment", 2, "onCreateView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramLayoutInflater.findViewById(2131363247));
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((BaseVideoView)bapu.c(getActivity(), 0L, null, null));
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
    this.jdField_a_of_type_Nhs.f();
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramView.findViewById(2131363244));
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramView.findViewById(2131363243));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363276));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363269));
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)paramView.findViewById(2131362303));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131362302));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363270));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131363253));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363254));
    this.c = ((AutoBgImageView)paramView.findViewById(2131363194));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363245);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131363260));
    paramBundle = nqf.a("avgame_result_bg@2x.png");
    if (paramBundle != null) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new BitmapDrawable(paramBundle));
    }
    paramBundle = nqf.a("avgame_voice_off@2x.png");
    if (paramBundle != null) {
      this.c.setImageBitmap(paramBundle);
    }
    this.c.setSelected(false);
    this.d = ((AutoBgImageView)paramView.findViewById(2131363192));
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView = ((AVGamePosterView)paramView.findViewById(2131363237));
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView.setPresenter(this);
    nfc.a().a().a();
    paramView = (RoundCorneredRelativeLayout)paramView.findViewById(2131363280);
    int i = ViewUtils.dip2px(17.0F);
    paramView.setRadius(i, i, i, i);
    paramBundle = new RelativeLayout.LayoutParams(-1, -1);
    paramView.addView(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    paramView = nqf.a("avgame_download_normal@2x.png");
    if (paramView != null) {
      this.d.setImageBitmap(paramView);
    }
    this.jdField_a_of_type_Nhs.a();
    b();
    ndx.a().c();
    AVGameNodeReportUtil.e();
    bdla.b(null, "dc00898", "", "", "0X800B05B", "0X800B05B", nfc.a().a().d(), 0, "" + nfc.a().a().a(), "" + nfc.a().a().h(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultFragment
 * JD-Core Version:    0.7.0.1
 */