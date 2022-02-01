package com.tencent.avgame.gameresult;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import aojq;
import bdla;
import bhdj;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo.Pair;
import com.tencent.avgame.ui.AVGamePKPosterView;
import com.tencent.avgame.ui.AVGameSplitNumberView;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.avgame.ui.GameBaseFragment;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import ncu;
import ndl;
import ndx;
import nfc;
import nfv;
import nhe;
import nhf;
import nhg;
import nhh;
import nhk;
import nhs;
import nht;
import npy;
import npz;
import nqf;

public class GamePKResultFragment
  extends GameBaseFragment
  implements View.OnClickListener, View.OnTouchListener, nht, npz
{
  protected RecyclerView a;
  private View jdField_a_of_type_AndroidViewView;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected AutoResizeAsyncImageView a;
  private SurvivalPkResultInfo jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo;
  private AVGamePKPosterView jdField_a_of_type_ComTencentAvgameUiAVGamePKPosterView;
  protected AVGameSplitNumberView a;
  protected AutoBgImageView a;
  private ncu jdField_a_of_type_Ncu;
  private ndl jdField_a_of_type_Ndl;
  protected nhs a;
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
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("should_restore_from_kill", false);
    localGamePKResultFragment.setArguments(localBundle);
    localGamePKResultFragment.jdField_a_of_type_Nhs = new nhk(localGamePKResultFragment);
    return localGamePKResultFragment;
  }
  
  private HashMap<String, String> a(ndl paramndl, ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add((String)paramArrayList.next());
    }
    return paramndl.a(localArrayList);
  }
  
  private HashMap<String, String> a(ndl paramndl, List<SurvivalPkResultInfo.Pair<Integer, Long>> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(String.valueOf(((SurvivalPkResultInfo.Pair)paramList.next()).second));
    }
    return paramndl.a(localArrayList);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.d.setVisibility(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setVisibility(8);
    this.jdField_b_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setVisibility(0);
    Object localObject = nqf.a("avgame_pk_result_fail_spider@2x.png");
    if (localObject != null)
    {
      this.jdField_c_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setFailedDrawable(new BitmapDrawable((Bitmap)localObject));
      this.jdField_c_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setLoadingDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    this.jdField_c_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setLoopOne();
    this.jdField_c_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.a("https://static-res.qq.com/static-res/avgames/survival/avgame_pk_result_spider.png");
    localObject = nqf.a("avgame_pk_result_fail2@2x.png");
    if (localObject != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    localObject = nqf.a("avgame_pk_result_fail1@2x.png");
    if (localObject != null)
    {
      this.jdField_b_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setFailedDrawable(new BitmapDrawable((Bitmap)localObject));
      this.jdField_b_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setLoadingDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    this.jdField_b_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setLoopOne();
    this.jdField_b_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.a("https://static-res.qq.com/static-res/avgames/survival/avgame_pk_result_fail.png");
    localObject = nqf.a("avgame_pk_result_footing2@2x.png");
    if (localObject != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(37.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.dp2px(37.0F, getResources());
    this.jdField_b_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130838768));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.setDimension(ViewUtils.dpToPx(49.0F), ViewUtils.dpToPx(67.0F));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.setNumDrawable(this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.a("avgame_pk_result_num%d@2x.png"));
    c(paramInt1);
    this.jdField_c_of_type_AndroidWidgetTextView.setText("/" + paramInt2);
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePKPosterView.a(paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.i("GamePKResultFragment", 2, "mSurvivalPkResultInfo.total is : " + this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.total + " mSurvivalPkResultInfo.rank: " + this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.rank);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    QQCustomDialog localQQCustomDialog = bhdj.a(getActivity(), 230);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setNegativeButton(paramString3, paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(paramString4, paramOnClickListener2);
    localQQCustomDialog.show();
  }
  
  private void a(boolean paramBoolean)
  {
    d(2);
  }
  
  private boolean a(boolean paramBoolean, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo == null) || (!this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.delayAward) || (this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.delayAwardTip == null)) {
      return false;
    }
    a(null, this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.delayAwardTip, getString(2131690469), new nhg(this, paramBoolean, paramInt), null, null);
    return true;
  }
  
  private void b(int paramInt)
  {
    this.jdField_c_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setVisibility(0);
    this.jdField_b_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setVisibility(8);
    Object localObject = nqf.a("avgame_pk_result_win2@2x.png");
    if (localObject != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    localObject = nqf.a("avgame_pk_result_win1@2x.png");
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setFailedDrawable(new BitmapDrawable((Bitmap)localObject));
      this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setLoadingDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setLoopOne();
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.a("https://static-res.qq.com/static-res/avgames/survival/avgame_pk_result_suc2.png");
    localObject = nqf.a("avgame_pk_result_footing@2x.png");
    if (localObject != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(58.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.dp2px(58.0F, getResources());
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePKPosterView.a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("GamePKResultFragment", 2, "mSurvivalPkResultInfo.total is : " + this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.total);
    }
  }
  
  private void c()
  {
    int i = ImmersiveUtils.getStatusBarHeight(getActivity());
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i += ViewUtils.dpToPx(4.0F);
    }
    for (;;)
    {
      Object localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).topMargin = i;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(AVGameText.a());
      this.jdField_b_of_type_AndroidWidgetTextView.setTypeface(AVGameText.a());
      this.d.setTypeface(AVGameText.a());
      this.jdField_a_of_type_AndroidWidgetButton.setTypeface(AVGameText.a());
      this.jdField_b_of_type_AndroidWidgetButton.setTypeface(AVGameText.a());
      localObject1 = nqf.a("avgame_room_bg@2x.png");
      if (localObject1 != null) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
      }
      this.jdField_a_of_type_ComTencentAvgameUiAVGamePKPosterView.setPresenter(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_Nhs.a();
      ndx.a().c();
      this.jdField_a_of_type_Ndl = ((ndl)nfc.a().a().a(2));
      if (this.jdField_a_of_type_Ndl != null)
      {
        localObject1 = this.jdField_a_of_type_Ndl.a(this.jdField_a_of_type_Ndl.getCurrentAccountUin(), (byte)1);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
        Object localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(this.jdField_a_of_type_Ndl.getCurrentAccountUin());
        localObject2 = (String)a(this.jdField_a_of_type_Ndl, (ArrayList)localObject2).get(this.jdField_a_of_type_Ndl.getCurrentAccountUin());
        if (localObject2 != null) {
          this.e.setText((CharSequence)localObject2);
        }
        this.jdField_a_of_type_ComTencentAvgameUiAVGamePKPosterView.a(this.jdField_a_of_type_Ndl, (String)localObject2, (Bitmap)localObject1);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnTouchListener(this);
      a();
      return;
      i = ViewUtils.dpToPx(8.0F);
    }
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView != null) && (this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.a(paramInt);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = true;
    if ((this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo == null) || (this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.awardUrl == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("GamePKResultFragment", 2, "mSurvivalPkResultInfo.awardUrl is : " + this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.awardUrl + "");
    }
    Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.awardUrl);
    getActivity().startActivity(localIntent);
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
    a(null, getString(2131690402), getString(2131690403), new nhe(this, paramInt), getString(2131690404), new nhf(this));
  }
  
  private void e(int paramInt)
  {
    
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_Nhs.c();
      return;
    }
    this.jdField_a_of_type_Nhs.e();
  }
  
  public Activity a()
  {
    return getActivity();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null)) {
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
    while ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.awardUrl)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.awardText)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.awardUrlStr)))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
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
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.awardText);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(Html.fromHtml("<u>" + this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.awardUrlStr + "</u> >"));
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (paramInt == 3)
    {
      this.jdField_a_of_type_Nhs.a();
      ndx.a().c();
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    QLog.d("GamePKResultFragment", 2, "onGameResultResourcesInfo " + paramInt + " " + paramString1 + " " + paramString2);
  }
  
  public void a(AVGameAppInterface paramAVGameAppInterface, long paramLong, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    aojq.a().a(paramAVGameAppInterface, paramLong, Long.valueOf(paramString1).longValue(), paramString2, 4, paramString3, paramInt, new nhh(this));
  }
  
  public void a(SurvivalPkResultInfo paramSurvivalPkResultInfo)
  {
    if (paramSurvivalPkResultInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo = paramSurvivalPkResultInfo;
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo != null)) {
      QLog.i("GamePKResultFragment", 2, "mSurvivalPkResultInfo:" + this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.toString());
    }
    a();
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(String paramString1, String paramString2, String paramString3) {}
  
  public void a(List<SurvivalPkResultInfo.Pair<Integer, Long>> paramList)
  {
    boolean bool = true;
    if ((paramList == null) || (this.jdField_a_of_type_Ndl == null)) {}
    int i;
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SurvivalPkResultInfo.Pair localPair = (SurvivalPkResultInfo.Pair)paramList.next();
        if (!String.valueOf(localPair.second).equals(this.jdField_a_of_type_Ndl.getCurrentAccountUin())) {
          localArrayList.add(localPair);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("GamePKResultFragment", 2, "uins.size: " + localArrayList.size());
      }
      this.jdField_a_of_type_Ncu = new ncu(getActivity(), localArrayList, 10, a(this.jdField_a_of_type_Ndl, localArrayList), this.jdField_a_of_type_Ndl);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Ncu);
      if (!this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.gameSur) {
        break;
      }
      i = 1;
      bdla.b(null, "dc00898", "", "", "0X800B695", "0X800B695", i, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    paramList = new StringBuilder().append("userInfoHandler is null?: ");
    if (this.jdField_a_of_type_Ndl == null) {}
    for (;;)
    {
      QLog.i("GamePKResultFragment", 2, bool + "");
      return;
      i = 2;
      break;
      bool = false;
    }
  }
  
  public void a(nfv paramnfv) {}
  
  public boolean a()
  {
    a(true);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ncu != null)
    {
      this.jdField_a_of_type_Ncu.a(a(this.jdField_a_of_type_Ndl, this.jdField_a_of_type_Ncu.a()));
      this.jdField_a_of_type_ComTencentAvgameUiAVGamePKPosterView.b();
    }
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
      QLog.e("GamePKResultFragment", 1, "onSavePosterSuc error: " + paramString.getMessage());
    }
  }
  
  public void b(nfv paramnfv)
  {
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
    int j = 1;
    int k = 1;
    int i = 1;
    switch (paramView.getId())
    {
    default: 
    case 2131363244: 
    case 2131363243: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        bdla.b(null, "dc00898", "", "", "0X800B035", "0X800B035", ndx.a().a(null) + 1, 0, "2", "", "", "");
        this.jdField_a_of_type_Nhs.b();
        continue;
        d(1);
      }
    case 2131363276: 
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo != null) {
        if (!this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.gameSur) {
          break label191;
        }
      }
      for (;;)
      {
        bdla.b(null, "dc00898", "", "", "0X800B696", "0X800B696", i, 0, "", "", "", "");
        this.jdField_a_of_type_Nhs.d();
        break;
        i = 2;
      }
    case 2131363269: 
      label191:
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo != null) {
        if (!this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.gameSur) {
          break label256;
        }
      }
      label256:
      for (i = j;; i = 2)
      {
        bdla.b(null, "dc00898", "", "", "0X800B697", "0X800B697", i, 0, "", "", "", "");
        a(false);
        break;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo != null) {
      if (!this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.gameSur) {
        break label330;
      }
    }
    label330:
    for (i = k;; i = 2)
    {
      bdla.b(null, "dc00898", "", "", "0X800B698", "0X800B698", i, 0, "", "", "", "");
      if (a(false, 0)) {
        break;
      }
      d();
      break;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558731, null);
    if (QLog.isColorLevel()) {
      QLog.i("GamePKResultFragment", 2, "onCreateView");
    }
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
    this.jdField_a_of_type_Nhs.f();
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
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return false;
      paramView.setAlpha(0.5F);
      continue;
      paramView.setAlpha(1.0F);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramView.findViewById(2131363244));
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramView.findViewById(2131363243));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363312));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363276));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363269));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363245);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131363272));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363268));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363266));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363265));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363264));
    this.d = ((TextView)paramView.findViewById(2131363263));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView = ((AutoResizeAsyncImageView)paramView.findViewById(2131363252));
    this.jdField_b_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView = ((AutoResizeAsyncImageView)paramView.findViewById(2131363250));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363249));
    this.e = ((TextView)paramView.findViewById(2131363256));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363262));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView = ((AVGameSplitNumberView)paramView.findViewById(2131363274));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363271));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363248));
    this.jdField_c_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView = ((AutoResizeAsyncImageView)paramView.findViewById(2131363277));
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePKPosterView = ((AVGamePKPosterView)paramView.findViewById(2131363237));
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GamePKResultFragment
 * JD-Core Version:    0.7.0.1
 */