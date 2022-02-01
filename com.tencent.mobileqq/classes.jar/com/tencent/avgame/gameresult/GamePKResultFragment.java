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
  private boolean A = true;
  protected IGameResultPresenter a;
  protected AutoBgImageView b;
  protected AutoBgImageView c;
  protected RelativeLayout d;
  protected Button e;
  protected Button f;
  protected RecyclerView g;
  protected ImageView h;
  protected TextView i;
  protected TextView j;
  protected LinearLayout k;
  protected AVGameSplitNumberView l;
  protected TextView m;
  protected LinearLayout n;
  protected TextView o;
  protected AutoResizeAsyncImageView p;
  protected AutoResizeAsyncImageView q;
  protected ImageView r;
  protected ImageView s;
  protected TextView t;
  protected AutoResizeAsyncImageView u;
  private UserInfoHandler v;
  private AVGamePKPosterView w;
  private View x;
  private GamePKResultRankAdapter y = null;
  private SurvivalPkResultInfo z = null;
  
  public static GamePKResultFragment a()
  {
    GamePKResultFragment localGamePKResultFragment = new GamePKResultFragment();
    localGamePKResultFragment.setArguments(new Bundle());
    localGamePKResultFragment.a = new GameResultPKPresenterImp(localGamePKResultFragment);
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
    this.u.setVisibility(0);
    this.k.setVisibility(0);
    this.o.setVisibility(0);
    this.g.setVisibility(8);
    this.p.setVisibility(8);
    this.q.setVisibility(0);
    Object localObject = AVGameUtil.c("avgame_pk_result_fail_spider@2x.png");
    if (localObject != null)
    {
      this.u.setFailedDrawable(new BitmapDrawable((Bitmap)localObject));
      this.u.setLoadingDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    this.u.setLoopOne();
    this.u.a("https://static-res.qq.com/static-res/avgames/survival/avgame_pk_result_spider.png");
    localObject = AVGameUtil.c("avgame_pk_result_fail2@2x.png");
    if (localObject != null) {
      this.h.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    localObject = AVGameUtil.c("avgame_pk_result_fail1@2x.png");
    if (localObject != null)
    {
      this.q.setFailedDrawable(new BitmapDrawable((Bitmap)localObject));
      this.q.setLoadingDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    this.q.setLoopOne();
    this.q.a("https://static-res.qq.com/static-res/avgames/survival/avgame_pk_result_fail.png");
    localObject = AVGameUtil.c("avgame_pk_result_footing2@2x.png");
    if (localObject != null) {
      this.r.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    localObject = (RelativeLayout.LayoutParams)this.n.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).leftMargin = ViewUtils.dip2px(37.0F);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ViewUtils.dip2px(37.0F);
    this.f.setBackgroundDrawable(getResources().getDrawable(2130838896));
    this.l.setDimension(ViewUtils.dpToPx(49.0F), ViewUtils.dpToPx(67.0F));
    localObject = this.l;
    ((AVGameSplitNumberView)localObject).setNumDrawable(((AVGameSplitNumberView)localObject).a("avgame_pk_result_num%d@2x.png"));
    c(paramInt1);
    localObject = this.m;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/");
    localStringBuilder.append(paramInt2);
    ((TextView)localObject).setText(localStringBuilder.toString());
    this.w.a(paramInt1, paramInt2);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mSurvivalPkResultInfo.total is : ");
      ((StringBuilder)localObject).append(this.z.total);
      ((StringBuilder)localObject).append(" mSurvivalPkResultInfo.rank: ");
      ((StringBuilder)localObject).append(this.z.rank);
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
    SurvivalPkResultInfo localSurvivalPkResultInfo = this.z;
    if ((localSurvivalPkResultInfo != null) && (localSurvivalPkResultInfo.delayAward) && (this.z.delayAwardTip != null))
    {
      a(null, this.z.delayAwardTip, getString(2131887410), new GamePKResultFragment.3(this, paramBoolean, paramInt), null, null);
      return true;
    }
    return false;
  }
  
  private void b(int paramInt)
  {
    this.u.setVisibility(8);
    this.o.setVisibility(8);
    this.k.setVisibility(8);
    this.g.setVisibility(0);
    this.p.setVisibility(0);
    this.q.setVisibility(8);
    Object localObject = AVGameUtil.c("avgame_pk_result_win2@2x.png");
    if (localObject != null) {
      this.h.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    localObject = AVGameUtil.c("avgame_pk_result_win1@2x.png");
    if (localObject != null)
    {
      this.p.setFailedDrawable(new BitmapDrawable((Bitmap)localObject));
      this.p.setLoadingDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    this.p.setLoopOne();
    this.p.a("https://static-res.qq.com/static-res/avgames/survival/avgame_pk_result_suc2.png");
    localObject = AVGameUtil.c("avgame_pk_result_footing@2x.png");
    if (localObject != null) {
      this.r.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    localObject = (RelativeLayout.LayoutParams)this.n.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).leftMargin = ViewUtils.dip2px(58.0F);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ViewUtils.dip2px(58.0F);
    this.w.a(paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mSurvivalPkResultInfo.total is : ");
      ((StringBuilder)localObject).append(this.z.total);
      QLog.i("GamePKResultFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void b(boolean paramBoolean)
  {
    d(2);
  }
  
  private void c(int paramInt)
  {
    AVGameSplitNumberView localAVGameSplitNumberView = this.l;
    if ((localAVGameSplitNumberView != null) && (localAVGameSplitNumberView.getVisibility() == 0)) {
      this.l.a(paramInt);
    }
  }
  
  private void d(int paramInt)
  {
    if (a(true, paramInt)) {
      return;
    }
    if (this.A)
    {
      e(paramInt);
      return;
    }
    a(null, getString(2131887330), getString(2131887331), new GamePKResultFragment.1(this, paramInt), getString(2131887332), new GamePKResultFragment.2(this));
  }
  
  private void e(int paramInt)
  {
    
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      this.a.d();
      return;
    }
    this.a.h();
  }
  
  private void f()
  {
    int i1 = ImmersiveUtils.getStatusBarHeight(getQBaseActivity());
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i1 += ViewUtils.dpToPx(4.0F);
    } else {
      i1 = ViewUtils.dpToPx(8.0F);
    }
    Object localObject1 = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).topMargin = i1;
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.i.setTypeface(AVGameText.getTypeface());
    this.j.setTypeface(AVGameText.getTypeface());
    this.o.setTypeface(AVGameText.getTypeface());
    this.e.setTypeface(AVGameText.getTypeface());
    this.f.setTypeface(AVGameText.getTypeface());
    localObject1 = AVGameUtil.c("avgame_room_bg@2x.png");
    if (localObject1 != null) {
      this.x.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
    }
    this.w.setPresenter(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.a.b();
    FloatWindowController.c().d();
    this.v = ((UserInfoHandler)GameEngine.a().f().getBusinessHandler(HandlerFactory.b));
    localObject1 = this.v;
    if (localObject1 != null)
    {
      localObject1 = ((UserInfoHandler)localObject1).a(((UserInfoHandler)localObject1).getCurrentAccountUin(), (byte)1);
      this.s.setImageBitmap((Bitmap)localObject1);
      Object localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(this.v.getCurrentAccountUin());
      localObject2 = (String)a(this.v, (ArrayList)localObject2).get(this.v.getCurrentAccountUin());
      if (localObject2 != null) {
        this.t.setText((CharSequence)localObject2);
      }
      this.w.a(this.v, (String)localObject2, (Bitmap)localObject1);
    }
    this.j.setOnTouchListener(this);
    this.e.setOnTouchListener(this);
    this.f.setOnTouchListener(this);
    b();
  }
  
  private void g()
  {
    this.A = true;
    Object localObject = this.z;
    if (localObject != null)
    {
      if (((SurvivalPkResultInfo)localObject).awardUrl == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mSurvivalPkResultInfo.awardUrl is : ");
        ((StringBuilder)localObject).append(this.z.awardUrl);
        ((StringBuilder)localObject).append("");
        QLog.i("GamePKResultFragment", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new Intent(getQBaseActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.z.awardUrl);
      getQBaseActivity().startActivity((Intent)localObject);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (paramInt == 3)
    {
      this.a.b();
      FloatWindowController.c().d();
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
    this.z = paramSurvivalPkResultInfo;
    if ((QLog.isColorLevel()) && (this.z != null))
    {
      paramSurvivalPkResultInfo = new StringBuilder();
      paramSurvivalPkResultInfo.append("mSurvivalPkResultInfo:");
      paramSurvivalPkResultInfo.append(this.z.toString());
      QLog.i("GamePKResultFragment", 2, paramSurvivalPkResultInfo.toString());
    }
    b();
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
      if (this.v == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SurvivalPkResultInfo.Pair localPair = (SurvivalPkResultInfo.Pair)paramList.next();
        if (!String.valueOf(localPair.second).equals(this.v.getCurrentAccountUin())) {
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
      this.y = new GamePKResultRankAdapter(getQBaseActivity(), localArrayList, 10, a(this.v, localArrayList), this.v);
      this.g.setLayoutManager(new LinearLayoutManager(getQBaseActivity()));
      this.g.setAdapter(this.y);
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("userInfoHandler is null?: ");
        boolean bool;
        if (this.v == null) {
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
  
  public void aD_()
  {
    GamePKResultRankAdapter localGamePKResultRankAdapter = this.y;
    if (localGamePKResultRankAdapter != null)
    {
      localGamePKResultRankAdapter.a(a(this.v, localGamePKResultRankAdapter.a()));
      this.w.b();
    }
  }
  
  public void b()
  {
    if (this.z != null)
    {
      if (this.j == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("GamePKResultFragment", 2, "refreshPageData");
      }
      ApngImage.resumeAll();
      this.j.setVisibility(0);
      this.i.setVisibility(0);
      if (this.z.gameSur)
      {
        b(this.z.total);
        a(this.z.rankingUins);
        this.A = false;
      }
      else
      {
        a(this.z.rank, this.z.total);
        if (!this.z.hasAward)
        {
          this.j.setVisibility(8);
          this.i.setVisibility(8);
        }
        else
        {
          this.A = false;
        }
      }
      if ((!TextUtils.isEmpty(this.z.awardUrl)) && (!TextUtils.isEmpty(this.z.awardText)) && (!TextUtils.isEmpty(this.z.awardUrlStr)))
      {
        this.j.setOnClickListener(this);
        this.i.setText(this.z.awardText);
        TextView localTextView = this.j;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<u>");
        localStringBuilder.append(this.z.awardUrlStr);
        localStringBuilder.append("</u> >");
        localTextView.setText(Html.fromHtml(localStringBuilder.toString()));
        int i1;
        if (this.z.gameSur) {
          i1 = 1;
        } else {
          i1 = 2;
        }
        ReportController.b(null, "dc00898", "", "", "0X800B695", "0X800B695", i1, 0, "", "", "", "");
        return;
      }
      this.A = true;
      this.j.setVisibility(8);
      this.i.setVisibility(8);
    }
  }
  
  public void b(EngineData paramEngineData)
  {
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
        QLog.e("GamePKResultFragment", 1, localStringBuilder.toString());
      }
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3) {}
  
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
    SurvivalPkResultInfo localSurvivalPkResultInfo;
    int i1;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131429161: 
      localSurvivalPkResultInfo = this.z;
      if (localSurvivalPkResultInfo != null)
      {
        if (localSurvivalPkResultInfo.gameSur) {
          i1 = 1;
        } else {
          i1 = 2;
        }
        ReportController.b(null, "dc00898", "", "", "0X800B696", "0X800B696", i1, 0, "", "", "", "");
      }
      this.a.i();
      break;
    case 2131429154: 
      localSurvivalPkResultInfo = this.z;
      if (localSurvivalPkResultInfo != null)
      {
        if (localSurvivalPkResultInfo.gameSur) {
          i1 = 1;
        } else {
          i1 = 2;
        }
        ReportController.b(null, "dc00898", "", "", "0X800B697", "0X800B697", i1, 0, "", "", "", "");
      }
      b(false);
      break;
    case 2131429150: 
      localSurvivalPkResultInfo = this.z;
      if (localSurvivalPkResultInfo != null)
      {
        if (localSurvivalPkResultInfo.gameSur) {
          i1 = 1;
        } else {
          i1 = 2;
        }
        ReportController.b(null, "dc00898", "", "", "0X800B698", "0X800B698", i1, 0, "", "", "", "");
      }
      if (!a(false, 0)) {
        g();
      }
      break;
    case 2131429129: 
      ReportController.b(null, "dc00898", "", "", "0X800B035", "0X800B035", FloatWindowController.c().a(null) + 1, 0, "2", "", "", "");
      this.a.g();
      break;
    case 2131429128: 
      d(1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131624278, null);
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
    this.a.c();
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
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 != 0)
    {
      if ((i1 == 1) || (i1 == 3)) {
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
    this.b = ((AutoBgImageView)paramView.findViewById(2131429129));
    this.c = ((AutoBgImageView)paramView.findViewById(2131429128));
    this.d = ((RelativeLayout)paramView.findViewById(2131429197));
    this.e = ((Button)paramView.findViewById(2131429161));
    this.f = ((Button)paramView.findViewById(2131429154));
    this.x = paramView.findViewById(2131429130);
    this.g = ((RecyclerView)paramView.findViewById(2131429157));
    this.h = ((ImageView)paramView.findViewById(2131429153));
    this.i = ((TextView)paramView.findViewById(2131429151));
    this.j = ((TextView)paramView.findViewById(2131429150));
    this.k = ((LinearLayout)paramView.findViewById(2131429149));
    this.o = ((TextView)paramView.findViewById(2131429148));
    this.p = ((AutoResizeAsyncImageView)paramView.findViewById(2131429137));
    this.q = ((AutoResizeAsyncImageView)paramView.findViewById(2131429135));
    this.s = ((ImageView)paramView.findViewById(2131429134));
    this.t = ((TextView)paramView.findViewById(2131429141));
    this.n = ((LinearLayout)paramView.findViewById(2131429147));
    this.l = ((AVGameSplitNumberView)paramView.findViewById(2131429159));
    this.m = ((TextView)paramView.findViewById(2131429156));
    this.r = ((ImageView)paramView.findViewById(2131429133));
    this.u = ((AutoResizeAsyncImageView)paramView.findViewById(2131429162));
    this.w = ((AVGamePKPosterView)paramView.findViewById(2131429121));
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GamePKResultFragment
 * JD-Core Version:    0.7.0.1
 */