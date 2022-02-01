package com.tencent.ad.tangram.views.feedback;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

@Keep
public class AdFeedbackDialogFragment
  extends ReportDialogFragment
{
  private static final int DARK_BUTTON_BG_COLOR = Color.parseColor("#3F3F3F");
  private static final int DARK_DIALOG_BG_COLOR = Color.parseColor("#282828");
  public static final String HIDE_TOAST_STR = "感谢反馈，将减少此类广告推荐";
  private static final String JUMP_ICON_URL = "https://amsweb-cdn-gz-1258344696.file.myqcloud.com/web%E5%BC%80%E5%8F%91%E7%BB%84/%E8%B5%84%E6%BA%90%E6%96%87%E4%BB%B6/%E7%AE%AD%E5%A4%B4-%E6%A8%AA%E7%89%88@2x.png";
  private static final int LIGHT_BUTTON_BG_COLOR = Color.parseColor("#F6F6F6");
  private static final int LIGHT_DIALOG_BG_COLOR = Color.parseColor("#FFFFFF");
  private static final String MACRO_REPORT_URL = "__ACT_TYPE__";
  private static final String TAG = "AdFeedbackDialogFragment";
  private WeakReference<Activity> mActivity;
  private Ad mAd;
  private View mDialogView;
  private List<?> mFeedbackItemModels;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private boolean mIsDarkMode = false;
  private boolean mIsLandscape = false;
  private View.OnClickListener mItemClickListener;
  private WeakReference<AdFeedbackDialogFragment.Listener> mOnResultListener;
  
  private View createView()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getActivity());
    localRelativeLayout.setBackgroundColor(Color.parseColor("#33000000"));
    if (this.mIsLandscape) {
      i = 17;
    } else {
      i = 80;
    }
    localRelativeLayout.setGravity(i);
    localRelativeLayout.setOnClickListener(new AdFeedbackDialogFragment.2(this));
    LinearLayout localLinearLayout = new LinearLayout(getActivity());
    boolean bool = this.mIsLandscape;
    float f2 = 15.0F;
    float f1;
    if (bool) {
      f1 = 15.0F;
    } else {
      f1 = 6.0F;
    }
    int i = AdUIUtils.dp2px(f1, getResources());
    if (this.mIsLandscape) {
      f1 = f2;
    } else {
      f1 = 30.0F;
    }
    int j = AdUIUtils.dp2px(f1, getResources());
    int k = 0;
    localLinearLayout.setPadding(0, i, 0, j);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(1);
    if (this.mIsLandscape) {
      i = -2;
    } else {
      i = -1;
    }
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(i, -2));
    localLinearLayout.setOnClickListener(null);
    this.mDialogView = localLinearLayout;
    int m = AdUIUtils.dp2px(14.0F, getResources());
    if (this.mIsLandscape) {
      i = m;
    } else {
      i = 0;
    }
    if (this.mIsDarkMode) {
      j = DARK_DIALOG_BG_COLOR;
    } else {
      j = LIGHT_DIALOG_BG_COLOR;
    }
    setRoundedCornerBackground(localLinearLayout, m, i, j);
    if (!this.mIsLandscape)
    {
      localObject1 = new View(getActivity());
      i = AdUIUtils.dp2px(10.0F, getResources());
      setRoundedCornerBackground((View)localObject1, i, i, Color.parseColor("#FFCFCFCF"));
      localObject2 = new LinearLayout.LayoutParams(AdUIUtils.dp2px(40.0F, getResources()), AdUIUtils.dp2px(4.0F, getResources()));
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = AdUIUtils.dp2px(6.0F, getResources());
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localLinearLayout.addView((View)localObject1);
    }
    Object localObject1 = this.mFeedbackItemModels.iterator();
    i = k;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (AdFeedbackDialogFragment.AdFeedbackItemModel)((Iterator)localObject1).next();
      localObject2 = new a.a();
      ((a.a)localObject2).isDarkMode = this.mIsDarkMode;
      ((a.a)localObject2).isLandscape = this.mIsLandscape;
      ((a.a)localObject2).listener = new WeakReference(this.mItemClickListener);
      ((a.a)localObject2).iconUrl = ((AdFeedbackDialogFragment.AdFeedbackItemModel)localObject3).mIconUrl;
      ((a.a)localObject2).text = ((AdFeedbackDialogFragment.AdFeedbackItemModel)localObject3).mText;
      ((a.a)localObject2).index = i;
      if (!TextUtils.isEmpty(((AdFeedbackDialogFragment.AdFeedbackItemModel)localObject3).mJumpUrl)) {
        ((a.a)localObject2).jumpIconUrl = "https://amsweb-cdn-gz-1258344696.file.myqcloud.com/web%E5%BC%80%E5%8F%91%E7%BB%84/%E8%B5%84%E6%BA%90%E6%96%87%E4%BB%B6/%E7%AE%AD%E5%A4%B4-%E6%A8%AA%E7%89%88@2x.png";
      }
      if (i != 0)
      {
        localObject3 = new View(getActivity());
        ((View)localObject3).setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
        ((View)localObject3).setBackgroundColor(Color.parseColor("#66979797"));
        localLinearLayout.addView((View)localObject3);
      }
      localLinearLayout.addView(new a(getActivity(), (a.a)localObject2));
      i += 1;
    }
    localLinearLayout.addView(initCancelButton());
    localObject1 = new AnimationSet(true);
    if (!this.mIsLandscape)
    {
      localObject2 = new TranslateAnimation(0.0F, 0.0F, AdUIUtils.dp2px(20.0F, getResources()), 0.0F);
      ((TranslateAnimation)localObject2).setDuration(200L);
      ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    }
    Object localObject2 = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject2).setDuration(200L);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    localLinearLayout.startAnimation((Animation)localObject1);
    localRelativeLayout.addView(localLinearLayout);
    return localRelativeLayout;
  }
  
  private void handlerClick(int paramInt, @Nullable String paramString)
  {
    this.mHandler.post(new AdFeedbackDialogFragment.5(this, paramInt, paramString));
  }
  
  private AdError init(AdFeedbackParams paramAdFeedbackParams)
  {
    if (paramAdFeedbackParams == null) {
      return new AdError(4);
    }
    this.mActivity = paramAdFeedbackParams.activity;
    this.mOnResultListener = paramAdFeedbackParams.listener;
    boolean bool;
    if (paramAdFeedbackParams.orientation != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.mIsLandscape = bool;
    this.mIsDarkMode = paramAdFeedbackParams.isDarkMode;
    paramAdFeedbackParams = setData(paramAdFeedbackParams.gdtAd);
    this.mItemClickListener = new AdFeedbackDialogFragment.4(this);
    return paramAdFeedbackParams;
  }
  
  private TextView initCancelButton()
  {
    TextView localTextView = new TextView(getActivity());
    int j = AdUIUtils.dp2px(34.0F, getResources());
    if (this.mIsDarkMode) {
      i = DARK_BUTTON_BG_COLOR;
    } else {
      i = LIGHT_BUTTON_BG_COLOR;
    }
    setRoundedCornerBackground(localTextView, j, j, i);
    int i = -1;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    Resources localResources = getResources();
    float f = 15.0F;
    localLayoutParams.leftMargin = AdUIUtils.dp2px(15.0F, localResources);
    localLayoutParams.rightMargin = AdUIUtils.dp2px(15.0F, getResources());
    localLayoutParams.topMargin = AdUIUtils.dp2px(10.0F, getResources());
    localTextView.setGravity(17);
    localTextView.setLayoutParams(localLayoutParams);
    j = AdUIUtils.dp2px(7.0F, getResources());
    localTextView.setPadding(0, j, 0, j);
    localTextView.setText("取消");
    if (this.mIsLandscape) {
      f = 14.0F;
    }
    localTextView.setTextSize(1, f);
    if (!this.mIsDarkMode) {
      i = -16777216;
    }
    localTextView.setTextColor(i);
    localTextView.setOnClickListener(new AdFeedbackDialogFragment.3(this));
    return localTextView;
  }
  
  private void initWindowStyle(Window paramWindow)
  {
    Object localObject = (ViewGroup)paramWindow.getDecorView();
    ((ViewGroup)localObject).setPadding(0, 0, 0, 0);
    ((ViewGroup)localObject).setBackgroundColor(0);
    ((ViewGroup)localObject).addView(createView());
    paramWindow.setDimAmount(0.0F);
    localObject = paramWindow.getAttributes();
    int i;
    if (this.mIsLandscape) {
      i = 17;
    } else {
      i = 80;
    }
    ((WindowManager.LayoutParams)localObject).gravity = i;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).height = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 0;
    paramWindow.setAttributes((WindowManager.LayoutParams)localObject);
  }
  
  private void onResult(AdFeedbackDialogFragment.ResultParams paramResultParams)
  {
    WeakReference localWeakReference = this.mOnResultListener;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((AdFeedbackDialogFragment.Listener)this.mOnResultListener.get()).onResult(paramResultParams);
    }
  }
  
  private void reportItemClicked(int paramInt)
  {
    try
    {
      String str = this.mAd.getUrlForFeedBack().replace("__ACT_TYPE__", String.valueOf(paramInt));
      AdThreadManager.INSTANCE.post(new AdFeedbackDialogFragment.6(this, str), 4);
      return;
    }
    catch (Exception localException) {}
  }
  
  private AdError setData(Ad paramAd)
  {
    if ((paramAd != null) && (paramAd.isValid()))
    {
      this.mAd = paramAd;
      this.mFeedbackItemModels = this.mAd.getFeedbackItems();
      paramAd = this.mFeedbackItemModels;
      if ((paramAd != null) && (!paramAd.isEmpty()) && ((this.mFeedbackItemModels.get(0) instanceof AdFeedbackDialogFragment.AdFeedbackItemModel))) {
        return new AdError(0);
      }
      return new AdError(4);
    }
    return new AdError(4);
  }
  
  private static void setRoundedCornerBackground(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramView == null) {
      return;
    }
    float f1 = paramInt1;
    float f2 = paramInt2;
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { f1, f1, f1, f1, f2, f2, f2, f2 }, null, null));
    localShapeDrawable.getPaint().setColor(paramInt3);
    paramView.setBackgroundDrawable(localShapeDrawable);
  }
  
  private void show(AdFeedbackParams paramAdFeedbackParams)
  {
    paramAdFeedbackParams = init(paramAdFeedbackParams);
    if (!paramAdFeedbackParams.isSuccess())
    {
      AdFeedbackDialogFragment.ResultParams localResultParams = new AdFeedbackDialogFragment.ResultParams();
      localResultParams.result = paramAdFeedbackParams;
      localResultParams.action = 0;
      onResult(localResultParams);
      return;
    }
    show(((Activity)this.mActivity.get()).getFragmentManager(), null);
  }
  
  public static void start(AdFeedbackParams paramAdFeedbackParams)
  {
    new AdFeedbackDialogFragment().show(paramAdFeedbackParams);
  }
  
  public void dismiss()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    if (!this.mIsLandscape)
    {
      localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, AdUIUtils.dp2px(20.0F, getResources()));
      ((TranslateAnimation)localObject).setDuration(200L);
      localAnimationSet.addAnimation((Animation)localObject);
    }
    Object localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(200L);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setAnimationListener(new AdFeedbackDialogFragment.1(this));
    this.mDialogView.startAnimation(localAnimationSet);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new ReportDialog(getActivity());
    if (paramBundle.getWindow() != null) {
      initWindowStyle(paramBundle.getWindow());
    }
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment
 * JD-Core Version:    0.7.0.1
 */