package com.tencent.ad.tangram.views.button;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.image.AdImageViewAdapter.Callback;
import com.tencent.ad.tangram.image.AdImageViewAdapter.Params;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment;
import java.lang.ref.WeakReference;

public final class a
  extends ReportDialogFragment
  implements AdImageViewAdapter.Callback, IAdButtonView
{
  private static final String CLOSE_ICON = "iVBORw0KGgoAAAANSUhEUgAAADIAAAAyBAMAAADsEZWCAAAAMFBMVEUAAADGx8fPz8/HycnHyMjHyMjHx8fFyMjDx8e/v7/Gx8fHyMjGxsbGyMjGycnHyMjDlXnoAAAAD3RSTlMAgBDPn98gX0AQ77+Pb1ATznxzAAAAm0lEQVQ4y+3QsQkCQRSE4T1YjAzsQBEr2AYs4cAK7EBLsAljS7AEyzC3g0OMRw9+hL152XHZTfIeDF8yac6YLF7/91k31/eGL+tSNTcVvnbQNAJldanOWgWy6o8jiCOII0iEII52EEd3iCOIZ69DXGQxhKXVQyUmXeOIxRjCCUNEJIGcgAICchKiU09A56pZ/gjoc+SzbNOcafIFUxpMBYjKjmsAAAAASUVORK5CYII=";
  private AdButtonView buttonView;
  private TextView company;
  private WeakReference<IAdButtonView.a> listener;
  private volatile a.a params;
  private TextView version;
  
  private View createView(int paramInt1, int paramInt2)
  {
    RelativeLayout localRelativeLayout1 = new RelativeLayout(getActivity());
    Object localObject1 = new FrameLayout(getActivity());
    Object localObject2 = new RelativeLayout.LayoutParams(paramInt1, paramInt2 * 2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
    RelativeLayout localRelativeLayout2 = new RelativeLayout(getActivity());
    localRelativeLayout2.setGravity(1);
    localRelativeLayout2.setBackgroundColor(Color.parseColor("#FFFFFF"));
    setBackground(localRelativeLayout2);
    localRelativeLayout1.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localRelativeLayout1.addView(localRelativeLayout2);
    localObject2 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12, ((FrameLayout)localObject1).getId());
    localRelativeLayout2.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = new AdImageViewAdapter.Params();
    ((AdImageViewAdapter.Params)localObject1).context = new WeakReference(getActivity().getApplicationContext());
    ((AdImageViewAdapter.Params)localObject1).url = this.params.logoUrl;
    ((AdImageViewAdapter.Params)localObject1).callback = new WeakReference(this);
    localObject1 = AdImageViewBuilder.buildImageView((AdImageViewAdapter.Params)localObject1);
    ((View)localObject1).setId(273);
    localObject2 = new RelativeLayout.LayoutParams(AdUIUtils.getValueDependsOnScreenWidth(getActivity(), 750, 166), AdUIUtils.getValueDependsOnScreenWidth(getActivity(), 750, 166));
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    ((View)localObject1).setPadding(13, 13, 13, 13);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = 37;
    localRelativeLayout2.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ImageView(getActivity());
    ((ImageView)localObject2).setImageBitmap(AdUIUtils.getBitmapFromString("iVBORw0KGgoAAAANSUhEUgAAADIAAAAyBAMAAADsEZWCAAAAMFBMVEUAAADGx8fPz8/HycnHyMjHyMjHx8fFyMjDx8e/v7/Gx8fHyMjGxsbGyMjGycnHyMjDlXnoAAAAD3RSTlMAgBDPn98gX0AQ77+Pb1ATznxzAAAAm0lEQVQ4y+3QsQkCQRSE4T1YjAzsQBEr2AYs4cAK7EBLsAljS7AEyzC3g0OMRw9+hL152XHZTfIeDF8yac6YLF7/91k31/eGL+tSNTcVvnbQNAJldanOWgWy6o8jiCOII0iEII52EEd3iCOIZ69DXGQxhKXVQyUmXeOIxRjCCUNEJIGcgAICchKiU09A56pZ/gjoc+SzbNOcafIFUxpMBYjKjmsAAAAASUVORK5CYII="));
    Object localObject3 = new RelativeLayout.LayoutParams(AdUIUtils.dp2px(32.0F, getResources()), AdUIUtils.dp2px(32.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject3).addRule(11);
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = 37;
    ((RelativeLayout.LayoutParams)localObject3).topMargin = 37;
    ((ImageView)localObject2).setOnClickListener(new a.3(this));
    localRelativeLayout2.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new TextView(getActivity());
    ((TextView)localObject2).setId(546);
    ((TextView)localObject2).setText(this.params.appName);
    ((TextView)localObject2).setTextColor(Color.parseColor("#222222"));
    ((TextView)localObject2).setMaxLines(1);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setTextSize(2, 17.0F);
    localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, ((View)localObject1).getId());
    ((RelativeLayout.LayoutParams)localObject3).topMargin = 7;
    localRelativeLayout2.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    this.version = new TextView(getActivity());
    this.version.setId(819);
    this.version.setTextColor(Color.parseColor("#878B99"));
    this.version.setGravity(17);
    this.version.setTextSize(2, 15.0F);
    localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, ((TextView)localObject2).getId());
    ((RelativeLayout.LayoutParams)localObject1).topMargin = 40;
    this.version.setVisibility(8);
    localRelativeLayout2.addView(this.version, (ViewGroup.LayoutParams)localObject1);
    this.company = new TextView(getActivity());
    this.company.setId(1092);
    this.company.setTextColor(Color.parseColor("#878B99"));
    this.company.setMaxLines(1);
    this.company.setEllipsize(TextUtils.TruncateAt.END);
    this.company.setGravity(17);
    this.company.setTextSize(2, 15.0F);
    localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.version.getId());
    ((RelativeLayout.LayoutParams)localObject1).topMargin = 12;
    this.company.setVisibility(8);
    localRelativeLayout2.addView(this.company, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new LinearLayout(getActivity());
    ((LinearLayout)localObject1).setOrientation(0);
    localObject2 = new TextView(getActivity());
    ((TextView)localObject2).setText("权限列表");
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setTextSize(2, 14.0F);
    ((TextView)localObject2).setTextColor(Color.parseColor("#579AD8"));
    localObject3 = new TextView(getActivity());
    ((TextView)localObject3).setText("|");
    ((TextView)localObject3).setGravity(17);
    ((TextView)localObject3).setTextSize(2, 14.0F);
    ((TextView)localObject3).setTextColor(Color.parseColor("#878B99"));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = 20;
    localLayoutParams.rightMargin = 20;
    TextView localTextView = new TextView(getActivity());
    localTextView.setText("隐私政策");
    localTextView.setGravity(17);
    localTextView.setTextSize(2, 14.0F);
    localTextView.setTextColor(Color.parseColor("#579AD8"));
    ((LinearLayout)localObject1).addView((View)localObject2);
    ((LinearLayout)localObject1).addView((View)localObject3, localLayoutParams);
    ((LinearLayout)localObject1).addView(localTextView);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, this.company.getId());
    ((RelativeLayout.LayoutParams)localObject2).topMargin = 20;
    ((LinearLayout)localObject1).setOnClickListener(new a.4(this));
    localRelativeLayout2.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    paramInt1 = AdUIUtils.getValueDependsOnScreenWidth(getActivity(), 750, 584);
    paramInt2 = AdUIUtils.getValueDependsOnScreenWidth(getActivity(), 750, 80);
    this.buttonView = new AdButtonView(getActivity(), paramInt1, paramInt2);
    localObject1 = new RelativeLayout.LayoutParams(-1, paramInt2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = 70;
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = 83;
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = 83;
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 89;
    localRelativeLayout2.addView(this.buttonView.getButtonView(), (ViewGroup.LayoutParams)localObject1);
    return localRelativeLayout1;
  }
  
  private void hideStatusBar(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {
      return;
    }
    paramViewGroup.setSystemUiVisibility(4);
  }
  
  private void notifyListener()
  {
    AdThreadManager.INSTANCE.post(new a.5(this), 0);
  }
  
  private void setBackground(View paramView)
  {
    if (paramView == null) {
      return;
    }
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { 80.0F, 80.0F, 80.0F, 80.0F, 0.0F, 0.0F, 0.0F, 0.0F }, null, null));
    localShapeDrawable.getPaint().setColor(-1);
    paramView.setBackgroundDrawable(localShapeDrawable);
  }
  
  public View getButtonView()
  {
    return this.buttonView.getButtonView();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (getDialog() != null) {
      getDialog().getWindow().setLayout(-1, -1);
    }
  }
  
  @RequiresApi(api=17)
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new AlertDialog.Builder(getActivity()).create();
    paramBundle.setCanceledOnTouchOutside(false);
    if (this.params == null) {
      return paramBundle;
    }
    try
    {
      Window localWindow = paramBundle.getWindow();
      ViewGroup localViewGroup = (ViewGroup)localWindow.getDecorView();
      if (localViewGroup == null) {
        return paramBundle;
      }
      hideStatusBar(localViewGroup);
      localWindow.setDimAmount(0.0F);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localLayoutParams.gravity = 80;
      localLayoutParams.windowAnimations = 0;
      localWindow.setAttributes(localLayoutParams);
      localViewGroup.setPadding(0, 0, 0, 0);
      localViewGroup.setBackgroundColor(Color.parseColor("#33000000"));
      localViewGroup.addView(createView(AdUIUtils.getScreenWidth(getActivity()), AdUIUtils.getScreenHeight(getActivity()) / 2));
      return paramBundle;
    }
    catch (Throwable localThrowable) {}
    return paramBundle;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (getDialog() != null) {
      getDialog().requestWindowFeature(1);
    }
    notifyListener();
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    if (getDialog() != null)
    {
      Window localWindow = getDialog().getWindow();
      if (localWindow == null) {
        return;
      }
      hideStatusBar((ViewGroup)localWindow.getDecorView());
    }
  }
  
  public void onStopLoad(boolean paramBoolean) {}
  
  public void registerListener(WeakReference<IAdButtonView.a> paramWeakReference)
  {
    this.listener = paramWeakReference;
  }
  
  public void setParams(a.a parama)
  {
    if (parama != null)
    {
      if (this.params == null) {
        this.params = new a.a();
      }
      if (!TextUtils.isEmpty(parama.logoUrl)) {
        this.params.logoUrl = parama.logoUrl;
      }
      if (!TextUtils.isEmpty(parama.appName)) {
        this.params.appName = parama.appName;
      }
      if (!TextUtils.isEmpty(parama.version))
      {
        this.params.version = parama.version;
        if (this.version != null) {
          AdThreadManager.INSTANCE.post(new a.1(this, parama), 0);
        }
      }
      if (!TextUtils.isEmpty(parama.developer))
      {
        this.params.developer = parama.developer;
        AdThreadManager.INSTANCE.post(new a.2(this, parama), 0);
      }
      if (!TextUtils.isEmpty(parama.rightInfoUrl)) {
        this.params.rightInfoUrl = parama.rightInfoUrl;
      }
    }
  }
  
  public int show(FragmentTransaction paramFragmentTransaction, String paramString)
  {
    if (this.params == null) {
      return -1;
    }
    return super.show(paramFragmentTransaction, paramString);
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString)
  {
    if (this.params == null) {
      return;
    }
    super.show(paramFragmentManager, paramString);
  }
  
  public void update(int paramInt1, int paramInt2)
  {
    AdButtonView localAdButtonView = this.buttonView;
    if (localAdButtonView != null) {
      localAdButtonView.update(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.button.a
 * JD-Core Version:    0.7.0.1
 */