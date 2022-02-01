package com.tencent.avgame.gameresult;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.adapter.GamePKResultRankAdapter;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.floatwindow.FloatWindowController;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo.Pair;
import com.tencent.avgame.ui.AVGamePKPosterView;
import com.tencent.avgame.ui.AVGameSplitNumberView;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.avgame.ui.GameBaseFragment;
import com.tencent.avgame.ui.IAVGameRootContainer;
import com.tencent.avgame.ui.IGamePosterView;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GamePKResultFragment
  extends GameBaseFragment
  implements View.OnClickListener, View.OnTouchListener, IGameResultView, IGamePosterView
{
  protected RecyclerView a;
  private View jdField_a_of_type_AndroidViewView;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  private GamePKResultRankAdapter jdField_a_of_type_ComTencentAvgameAdapterGamePKResultRankAdapter = null;
  private UserInfoHandler jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler;
  protected AutoResizeAsyncImageView a;
  private SurvivalPkResultInfo jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo = null;
  protected IGameResultPresenter a;
  private AVGamePKPosterView jdField_a_of_type_ComTencentAvgameUiAVGamePKPosterView;
  protected AVGameSplitNumberView a;
  protected AutoBgImageView a;
  private boolean jdField_a_of_type_Boolean = true;
  protected Button b;
  protected ImageView b;
  protected LinearLayout b;
  protected TextView b;
  protected AutoResizeAsyncImageView b;
  protected AutoBgImageView b;
  protected ImageView c;
  protected TextView c;
  protected AutoResizeAsyncImageView c;
  protected TextView d;
  protected TextView e;
  
  public static GamePKResultFragment a()
  {
    GamePKResultFragment localGamePKResultFragment = new GamePKResultFragment();
    localGamePKResultFragment.setArguments(new Bundle());
    localGamePKResultFragment.jdField_a_of_type_ComTencentAvgameGameresultIGameResultPresenter = new GameResultPKPresenterImp(localGamePKResultFragment);
    return localGamePKResultFragment;
  }
  
  private HashMap<String, String> a(UserInfoHandler paramUserInfoHandler, ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add((String)paramArrayList.next());
    }
    return paramUserInfoHandler.a(localArrayList);
  }
  
  private HashMap<String, String> a(UserInfoHandler paramUserInfoHandler, List<SurvivalPkResultInfo.Pair<Integer, Long>> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(String.valueOf(((SurvivalPkResultInfo.Pair)paramList.next()).second));
    }
    return paramUserInfoHandler.a(localArrayList);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.d.setVisibility(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setVisibility(8);
    this.jdField_b_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setVisibility(0);
    Object localObject = AVGameUtil.a("avgame_pk_result_fail_spider@2x.png");
    if (localObject != null)
    {
      this.jdField_c_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setFailedDrawable(new BitmapDrawable((Bitmap)localObject));
      this.jdField_c_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setLoadingDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    this.jdField_c_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setLoopOne();
    this.jdField_c_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.a("https://static-res.qq.com/static-res/avgames/survival/avgame_pk_result_spider.png");
    localObject = AVGameUtil.a("avgame_pk_result_fail2@2x.png");
    if (localObject != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    localObject = AVGameUtil.a("avgame_pk_result_fail1@2x.png");
    if (localObject != null)
    {
      this.jdField_b_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setFailedDrawable(new BitmapDrawable((Bitmap)localObject));
      this.jdField_b_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setLoadingDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    this.jdField_b_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setLoopOne();
    this.jdField_b_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.a("https://static-res.qq.com/static-res/avgames/survival/avgame_pk_result_fail.png");
    localObject = AVGameUtil.a("avgame_pk_result_footing2@2x.png");
    if (localObject != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).leftMargin = ViewUtils.a(37.0F);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ViewUtils.a(37.0F);
    this.jdField_b_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130838682));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.setDimension(ViewUtils.b(49.0F), ViewUtils.b(67.0F));
    localObject = this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView;
    ((AVGameSplitNumberView)localObject).setNumDrawable(((AVGameSplitNumberView)localObject).a("avgame_pk_result_num%d@2x.png"));
    c(paramInt1);
    localObject = this.jdField_c_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/");
    localStringBuilder.append(paramInt2);
    ((TextView)localObject).setText(localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePKPosterView.a(paramInt1, paramInt2);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mSurvivalPkResultInfo.total is : ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.total);
      ((StringBuilder)localObject).append(" mSurvivalPkResultInfo.rank: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.rank);
      QLog.i("GamePKResultFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getQBaseActivity(), 230);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setNegativeButton(paramString3, paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(paramString4, paramOnClickListener2);
    localQQCustomDialog.show();
  }
  
  private boolean a(boolean paramBoolean, int paramInt)
  {
    SurvivalPkResultInfo localSurvivalPkResultInfo = this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo;
    if ((localSurvivalPkResultInfo != null) && (localSurvivalPkResultInfo.delayAward) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.delayAwardTip != null))
    {
      a(null, this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.delayAwardTip, getString(2131690499), new GamePKResultFragment.3(this, paramBoolean, paramInt), null, null);
      return true;
    }
    return false;
  }
  
  private void b(int paramInt)
  {
    this.jdField_c_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setVisibility(0);
    this.jdField_b_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setVisibility(8);
    Object localObject = AVGameUtil.a("avgame_pk_result_win2@2x.png");
    if (localObject != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    localObject = AVGameUtil.a("avgame_pk_result_win1@2x.png");
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setFailedDrawable(new BitmapDrawable((Bitmap)localObject));
      this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setLoadingDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setLoopOne();
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.a("https://static-res.qq.com/static-res/avgames/survival/avgame_pk_result_suc2.png");
    localObject = AVGameUtil.a("avgame_pk_result_footing@2x.png");
    if (localObject != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).leftMargin = ViewUtils.a(58.0F);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ViewUtils.a(58.0F);
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePKPosterView.a(paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mSurvivalPkResultInfo.total is : ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.total);
      QLog.i("GamePKResultFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void b(boolean paramBoolean)
  {
    d(2);
  }
  
  private void c()
  {
    int i = ImmersiveUtils.getStatusBarHeight(getQBaseActivity());
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i += ViewUtils.b(4.0F);
    } else {
      i = ViewUtils.b(8.0F);
    }
    Object localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).topMargin = i;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(AVGameText.a());
    this.jdField_b_of_type_AndroidWidgetTextView.setTypeface(AVGameText.a());
    this.d.setTypeface(AVGameText.a());
    this.jdField_a_of_type_AndroidWidgetButton.setTypeface(AVGameText.a());
    this.jdField_b_of_type_AndroidWidgetButton.setTypeface(AVGameText.a());
    localObject1 = AVGameUtil.a("avgame_room_bg@2x.png");
    if (localObject1 != null) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
    }
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePKPosterView.setPresenter(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultPresenter.b();
    FloatWindowController.a().c();
    this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler = ((UserInfoHandler)GameEngine.a().a().getBusinessHandler(HandlerFactory.b));
    localObject1 = this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler;
    if (localObject1 != null)
    {
      localObject1 = ((UserInfoHandler)localObject1).a(((UserInfoHandler)localObject1).getCurrentAccountUin(), (byte)1);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
      Object localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler.getCurrentAccountUin());
      localObject2 = (String)a(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler, (ArrayList)localObject2).get(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler.getCurrentAccountUin());
      if (localObject2 != null) {
        this.e.setText((CharSequence)localObject2);
      }
      this.jdField_a_of_type_ComTencentAvgameUiAVGamePKPosterView.a(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler, (String)localObject2, (Bitmap)localObject1);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnTouchListener(this);
    a();
  }
  
  private void c(int paramInt)
  {
    AVGameSplitNumberView localAVGameSplitNumberView = this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView;
    if ((localAVGameSplitNumberView != null) && (localAVGameSplitNumberView.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.a(paramInt);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo;
    if (localObject != null)
    {
      if (((SurvivalPkResultInfo)localObject).awardUrl == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mSurvivalPkResultInfo.awardUrl is : ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.awardUrl);
        ((StringBuilder)localObject).append("");
        QLog.i("GamePKResultFragment", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new Intent(getQBaseActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.awardUrl);
      getQBaseActivity().startActivity((Intent)localObject);
    }
  }
  
  private void d(int paramInt)
  {
    if (a(true, paramInt)) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      e(paramInt);
      return;
    }
    a(null, getString(2131690419), getString(2131690420), new GamePKResultFragment.1(this, paramInt), getString(2131690421), new GamePKResultFragment.2(this));
  }
  
  private void e(int paramInt)
  {
    
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultPresenter.d();
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultPresenter.f();
  }
  
  public Activity a()
  {
    return getQBaseActivity();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo != null)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("GamePKResultFragment", 2, "refreshPageData");
      }
      ApngImage.resumeAll();
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.gameSur)
      {
        b(this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.total);
        a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.rankingUins);
        this.jdField_a_of_type_Boolean = false;
      }
      else
      {
        a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.rank, this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.total);
        if (!this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.hasAward)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        else
        {
          this.jdField_a_of_type_Boolean = false;
        }
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.awardUrl)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.awardText)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.awardUrlStr)))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.awardText);
        TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<u>");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.awardUrlStr);
        localStringBuilder.append("</u> >");
        localTextView.setText(Html.fromHtml(localStringBuilder.toString()));
        int i;
        if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.gameSur) {
          i = 1;
        } else {
          i = 2;
        }
        ReportController.b(null, "dc00898", "", "", "0X800B695", "0X800B695", i, 0, "", "", "", "");
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (paramInt == 3)
    {
      this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultPresenter.b();
      FloatWindowController.a().c();
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGameResultResourcesInfo ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString2);
    QLog.d("GamePKResultFragment", 2, localStringBuilder.toString());
  }
  
  public void a(EngineData paramEngineData) {}
  
  public void a(SurvivalPkResultInfo paramSurvivalPkResultInfo)
  {
    if (paramSurvivalPkResultInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo = paramSurvivalPkResultInfo;
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo != null))
    {
      paramSurvivalPkResultInfo = new StringBuilder();
      paramSurvivalPkResultInfo.append("mSurvivalPkResultInfo:");
      paramSurvivalPkResultInfo.append(this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.toString());
      QLog.i("GamePKResultFragment", 2, paramSurvivalPkResultInfo.toString());
    }
    a();
  }
  
  public void a(BaseAVGameAppInterface paramBaseAVGameAppInterface, long paramLong, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AVGameShareUtil.a().a(paramBaseAVGameAppInterface, paramLong, Long.valueOf(paramString1).longValue(), paramString2, 4, paramString3, paramInt, new GamePKResultFragment.4(this));
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString1, String paramString2, String paramString3) {}
  
  public void a(List<SurvivalPkResultInfo.Pair<Integer, Long>> paramList)
  {
    if (paramList != null)
    {
      if (this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SurvivalPkResultInfo.Pair localPair = (SurvivalPkResultInfo.Pair)paramList.next();
        if (!String.valueOf(localPair.second).equals(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler.getCurrentAccountUin())) {
          localArrayList.add(localPair);
        }
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("uins.size: ");
        paramList.append(localArrayList.size());
        QLog.i("GamePKResultFragment", 2, paramList.toString());
      }
      this.jdField_a_of_type_ComTencentAvgameAdapterGamePKResultRankAdapter = new GamePKResultRankAdapter(getQBaseActivity(), localArrayList, 10, a(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler, localArrayList), this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(getQBaseActivity()));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAvgameAdapterGamePKResultRankAdapter);
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("userInfoHandler is null?: ");
        boolean bool;
        if (this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler == null) {
          bool = true;
        } else {
          bool = false;
        }
        paramList.append(bool);
        paramList.append("");
        QLog.i("GamePKResultFragment", 2, paramList.toString());
      }
    }
  }
  
  public boolean a()
  {
    b(true);
    return true;
  }
  
  public void b()
  {
    GamePKResultRankAdapter localGamePKResultRankAdapter = this.jdField_a_of_type_ComTencentAvgameAdapterGamePKResultRankAdapter;
    if (localGamePKResultRankAdapter != null)
    {
      localGamePKResultRankAdapter.a(a(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler, localGamePKResultRankAdapter.a()));
      this.jdField_a_of_type_ComTencentAvgameUiAVGamePKPosterView.b();
    }
  }
  
  public void b(EngineData paramEngineData)
  {
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
        QLog.e("GamePKResultFragment", 1, localStringBuilder.toString());
      }
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3) {}
  
  public View getView()
  {
    return super.getView();
  }
  
  public void onClick(View paramView)
  {
    SurvivalPkResultInfo localSurvivalPkResultInfo;
    int i;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131363287: 
      localSurvivalPkResultInfo = this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo;
      if (localSurvivalPkResultInfo != null)
      {
        if (localSurvivalPkResultInfo.gameSur) {
          i = 1;
        } else {
          i = 2;
        }
        ReportController.b(null, "dc00898", "", "", "0X800B696", "0X800B696", i, 0, "", "", "", "");
      }
      this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultPresenter.g();
      break;
    case 2131363280: 
      localSurvivalPkResultInfo = this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo;
      if (localSurvivalPkResultInfo != null)
      {
        if (localSurvivalPkResultInfo.gameSur) {
          i = 1;
        } else {
          i = 2;
        }
        ReportController.b(null, "dc00898", "", "", "0X800B697", "0X800B697", i, 0, "", "", "", "");
      }
      b(false);
      break;
    case 2131363276: 
      localSurvivalPkResultInfo = this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo;
      if (localSurvivalPkResultInfo != null)
      {
        if (localSurvivalPkResultInfo.gameSur) {
          i = 1;
        } else {
          i = 2;
        }
        ReportController.b(null, "dc00898", "", "", "0X800B698", "0X800B698", i, 0, "", "", "", "");
      }
      if (!a(false, 0)) {
        d();
      }
      break;
    case 2131363255: 
      ReportController.b(null, "dc00898", "", "", "0X800B035", "0X800B035", FloatWindowController.a().a(null) + 1, 0, "2", "", "", "");
      this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultPresenter.e();
      break;
    case 2131363254: 
      d(1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558661, null);
    if (QLog.isColorLevel()) {
      QLog.i("GamePKResultFragment", 2, "onCreateView");
    }
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
    this.jdField_a_of_type_ComTencentAvgameGameresultIGameResultPresenter.c();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        paramView.setAlpha(1.0F);
      }
    }
    else {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramView.findViewById(2131363255));
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramView.findViewById(2131363254));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363323));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363287));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363280));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363256);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131363283));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363279));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363277));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363276));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363275));
    this.d = ((TextView)paramView.findViewById(2131363274));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView = ((AutoResizeAsyncImageView)paramView.findViewById(2131363263));
    this.jdField_b_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView = ((AutoResizeAsyncImageView)paramView.findViewById(2131363261));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363260));
    this.e = ((TextView)paramView.findViewById(2131363267));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363273));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView = ((AVGameSplitNumberView)paramView.findViewById(2131363285));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363282));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363259));
    this.jdField_c_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView = ((AutoResizeAsyncImageView)paramView.findViewById(2131363288));
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePKPosterView = ((AVGamePKPosterView)paramView.findViewById(2131363247));
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GamePKResultFragment
 * JD-Core Version:    0.7.0.1
 */