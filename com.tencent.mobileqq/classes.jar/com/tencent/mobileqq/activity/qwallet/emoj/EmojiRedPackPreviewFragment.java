package com.tencent.mobileqq.activity.qwallet.emoj;

import aevv;
import aevw;
import akww;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anni;
import bcst;
import bgfz;
import bggq;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import mqq.os.MqqHandler;

public class EmojiRedPackPreviewFragment
  extends PublicBaseFragment
  implements aevw, View.OnClickListener
{
  public static final String TAG = "EmojiRedPackPreviewFragment";
  public ImageView imgLottie;
  public int internalProgress = 100;
  private CameraCaptureView.VideoCaptureResult mCaptureResult;
  private LocalMediaInfo mLocalMediaInfo;
  public int mPercent;
  public NumberProgressBar numberProbar;
  private Runnable percentRun = new EmojiRedPackPreviewFragment.2(this);
  public ImageView previewImg;
  public Button reCaptureBtn;
  public View sendBtn;
  public int tag;
  public TextView tips;
  public View viewOpenAnim;
  
  public static String getMoneyLottieJson()
  {
    return "{\"v\":\"5.5.0\",\"fr\":30,\"ip\":0,\"op\":90,\"w\":250,\"h\":250,\"nm\":\"预合成 4\",\"ddd\":0,\"assets\":[],\"layers\":[{\"ddd\":0,\"ind\":3,\"ty\":4,\"nm\":\"“图层 16”轮廓 2\",\"sr\":1,\"ks\":{\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":15,\"s\":[100]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":42,\"s\":[100]},{\"t\":59,\"s\":[0]}],\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[125,125,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[101.5,101.25,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833,0.833],\"y\":[0.833,0.833,0.833]},\"o\":{\"x\":[0.167,0.167,0.167],\"y\":[0.167,0.167,0.167]},\"t\":15,\"s\":[91,91,100]},{\"t\":59,\"s\":[128,128,100]}],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,-53.296],[-53.296,0],[0,53.296],[53.296,0]],\"o\":[[0,53.296],[53.296,0],[0,-53.296],[-53.296,0]],\"v\":[[-96,265.5],[0.5,362],[97,265.5],[0.5,169]],\"c\":true},\"ix\":2},\"nm\":\"路径 2\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.866666734219,0.698039233685,1],\"ix\":4},\"o\":{\"a\":0,\"k\":20,\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[101.456,101.196],\"ix\":2},\"a\":{\"a\":0,\"k\":[0.456,265.196],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":15,\"op\":60,\"st\":15,\"bm\":0},{\"ddd\":0,\"ind\":4,\"ty\":4,\"nm\":\"“图层 16”轮廓\",\"sr\":1,\"ks\":{\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":0,\"s\":[100]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":27,\"s\":[100]},{\"t\":44,\"s\":[0]}],\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[125,125,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[101.5,101.25,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833,0.833],\"y\":[0.833,0.833,0.833]},\"o\":{\"x\":[0.167,0.167,0.167],\"y\":[0.167,0.167,0.167]},\"t\":0,\"s\":[91,91,100]},{\"t\":44,\"s\":[128,128,100]}],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,-53.296],[-53.296,0],[0,53.296],[53.296,0]],\"o\":[[0,53.296],[53.296,0],[0,-53.296],[-53.296,0]],\"v\":[[-96,265.5],[0.5,362],[97,265.5],[0.5,169]],\"c\":true},\"ix\":2},\"nm\":\"路径 2\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.866666734219,0.698039233685,1],\"ix\":4},\"o\":{\"a\":0,\"k\":20,\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[101.456,101.196],\"ix\":2},\"a\":{\"a\":0,\"k\":[0.456,265.196],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":45,\"st\":0,\"bm\":0}],\"markers\":[]}";
  }
  
  private void initParams()
  {
    this.mCaptureResult = ((CameraCaptureView.VideoCaptureResult)getArguments().getSerializable("emoji_capture_result"));
    this.mLocalMediaInfo = ((LocalMediaInfo)getArguments().getSerializable("emoji_capture_media_info"));
    this.tag = getArguments().getInt("emoji_capture_tag", 0);
    initThumb();
    akww.a(this.reCaptureBtn, 0.3F);
    akww.a(this.sendBtn, 0.3F);
    bgfz.a(this.reCaptureBtn, anni.a(2131702810));
    bgfz.a(this.sendBtn, anni.a(2131702813));
    this.reCaptureBtn.setOnClickListener(this);
    this.sendBtn.setOnClickListener(this);
    this.tips.setText(anni.a(2131702812));
    LottieComposition.Factory.fromJsonString(getMoneyLottieJson(), new EmojiRedPackPreviewFragment.1(this));
    this.internalProgress = ((int)(this.mLocalMediaInfo.mDuration * 0.33D) / 100);
    ThreadManager.getUIHandler().post(this.percentRun);
    int i = bggq.a(getActivity(), 75.0F);
    int j = bggq.a(getActivity(), 75.0F);
    this.viewOpenAnim.setPivotX(i / 2);
    this.viewOpenAnim.setPivotY(j / 2 + bggq.a(getActivity(), 15.0F));
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.viewOpenAnim, "rotation", new float[] { -5.0F, 20.0F });
    localObjectAnimator.setDuration(200L);
    localObjectAnimator.setRepeatMode(2);
    localObjectAnimator.setRepeatCount(-1);
    localObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localObjectAnimator.start();
    doConvert();
  }
  
  private void initThumb()
  {
    ThreadManager.post(new EmojiRedPackPreviewFragment.3(this), 5, null, true);
  }
  
  private void initUI()
  {
    this.previewImg = ((ImageView)getActivity().findViewById(2131368474));
    this.reCaptureBtn = ((Button)getActivity().findViewById(2131363881));
    this.sendBtn = getActivity().findViewById(2131363828);
    this.viewOpenAnim = getActivity().findViewById(2131368465);
    this.tips = ((TextView)getActivity().findViewById(2131380100));
    this.numberProbar = ((NumberProgressBar)getActivity().findViewById(2131372880));
    this.imgLottie = ((ImageView)getActivity().findViewById(2131368460));
  }
  
  public static void start(Activity paramActivity, int paramInt1, int paramInt2, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("emoji_capture_tag", paramInt2);
    localIntent.putExtra("emoji_capture_result", paramVideoCaptureResult);
    localIntent.putExtra("emoji_capture_media_info", paramLocalMediaInfo);
    aevv.a(paramActivity, localIntent, PublicFragmentActivityForPeak.class, EmojiRedPackPreviewFragment.class, paramInt1);
  }
  
  public void doConvert()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmojiRedPackPreviewFragment", 2, "do convert gif begin");
    }
    EmojiGifHelper.ConvertParam localConvertParam = new EmojiGifHelper.ConvertParam();
    localConvertParam.inPath = this.mCaptureResult.videoMp4FilePath;
    localConvertParam.videoWidth = this.mLocalMediaInfo.mediaWidth;
    localConvertParam.videoHeight = this.mLocalMediaInfo.mediaHeight;
    localConvertParam.videoDuration = this.mLocalMediaInfo.mDuration;
    localConvertParam.tag = this.tag;
    EmojiGifHelper.compositeAndTransToGif(localConvertParam, new EmojiRedPackPreviewFragment.4(this));
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    this.reCaptureBtn.performClick();
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
      getActivity().finish();
      continue;
      Intent localIntent = new Intent();
      localIntent.putExtra("return_action", 1);
      getActivity().setResult(-1, localIntent);
      getActivity().finish();
      bcst.b(null, "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.video.finish", 0, 0, "", "", "", "");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131562038, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.imgLottie != null)
    {
      Drawable localDrawable = this.imgLottie.getDrawable();
      if ((localDrawable instanceof LottieDrawable)) {
        ((LottieDrawable)localDrawable).recycleBitmaps();
      }
    }
  }
  
  public void onTransResult(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmojiRedPackPreviewFragment", 2, "onTransResult isSucc=" + paramBoolean + "，gifPath=" + paramString);
    }
    ThreadManager.getUIHandler().post(new EmojiRedPackPreviewFragment.5(this, paramBoolean, paramString));
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    getActivity().getWindow().setFlags(1024, 1024);
    super.onViewCreated(paramView, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("EmojiRedPackPreviewFragment", 2, "EmojiRedPackPreviewFragment onViewCreated");
    }
    initUI();
    initParams();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiRedPackPreviewFragment
 * JD-Core Version:    0.7.0.1
 */