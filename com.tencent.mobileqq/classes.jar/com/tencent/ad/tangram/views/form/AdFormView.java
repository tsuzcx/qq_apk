package com.tencent.ad.tangram.views.form;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.dialog.AdProgressDialog;
import com.tencent.ad.tangram.dialog.AdProgressDialog.Params;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.form.framework.b;
import com.tencent.ad.tangram.views.form.framework.c;
import com.tencent.ad.tangram.views.form.framework.h;
import com.tencent.ad.tangram.views.form.framework.i;
import com.tencent.ad.tangram.views.xijing.AdButtonView;
import com.tencent.ad.tangram.views.xijing.AdTextData;
import java.lang.ref.WeakReference;

@Keep
public final class AdFormView
  extends LinearLayout
  implements com.tencent.ad.tangram.views.form.framework.a, c
{
  private static final String TAG = "GdtFormView";
  private Ad ad;
  private View.OnClickListener buttonListener = new AdFormView.1(this);
  private AdFormData data;
  private int errorIndex = -1;
  private WeakReference<AdFormViewListener> listener;
  private h tableView;
  
  public AdFormView(Context paramContext, Ad paramAd, AdFormData paramAdFormData)
  {
    super(paramContext);
    init(paramContext, paramAd, paramAdFormData);
  }
  
  private void commit()
  {
    b.commitAsync(getContext(), getAd(), getData(), new WeakReference(this));
  }
  
  private void init(Context paramContext, Ad paramAd, AdFormData paramAdFormData)
  {
    if ((paramAd != null) && (paramAd.isValid()) && (paramAd.getActionSetId() != -2147483648L) && (paramAdFormData != null) && (paramAdFormData.isValid()))
    {
      this.ad = paramAd;
      this.data = paramAdFormData;
      i.updateAsync(new WeakReference(getData()));
      initViews(paramContext);
      return;
    }
    AdLog.e("GdtFormView", "init error");
  }
  
  private void initViews(Context paramContext)
  {
    Object localObject = this.data;
    if ((localObject != null) && (((AdFormData)localObject).isValid()))
    {
      setFocusable(true);
      setFocusableInTouchMode(true);
      setBackgroundColor(getData().backgroundColor);
      setOrientation(1);
      int i;
      if (getData().title != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject = new TextView(paramContext);
        ((TextView)localObject).setText(getData().title.text);
        ((TextView)localObject).setTextColor(getData().title.color);
        ((TextView)localObject).setTextSize(0, getData().title.size);
        ((TextView)localObject).setTypeface(null, 1);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 1;
        addView((View)localObject, localLayoutParams);
      }
      this.tableView = new h(paramContext, getData().table, new WeakReference(this));
      localObject = new LinearLayout.LayoutParams(-1, -2);
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject).setMargins(0, getData().padding, 0, 0);
      }
      addView(this.tableView, (ViewGroup.LayoutParams)localObject);
      paramContext = new AdButtonView(paramContext, getData().button);
      localObject = new LinearLayout.LayoutParams(-1, getData().buttonHeight);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, getData().padding, 0, 0);
      addView(paramContext, (ViewGroup.LayoutParams)localObject);
      paramContext.setOnClickListener(this.buttonListener);
      return;
    }
    AdLog.e("GdtFormView", "initViews error");
  }
  
  private void notifyCommitted(boolean paramBoolean, AdFormError paramAdFormError)
  {
    WeakReference localWeakReference = this.listener;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((AdFormViewListener)this.listener.get()).onCommitted(paramBoolean, paramAdFormError);
    }
  }
  
  private void reset()
  {
    h localh = this.tableView;
    if (localh == null)
    {
      AdLog.e("GdtFormView", "reset error");
      return;
    }
    localh.reset();
  }
  
  private void showLoading(boolean paramBoolean)
  {
    if ((getData() != null) && (getData().isValid()))
    {
      if (paramBoolean)
      {
        if (AdProgressDialog.INSTANCE.isShowing(getContext())) {
          return;
        }
        AdProgressDialog.Params localParams = new AdProgressDialog.Params();
        localParams.yOffset = AdUIUtils.dp2px(44.0F, getResources());
        localParams.cancelable = false;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("正在");
        localStringBuilder.append(getData().button.text.text);
        localParams.message = localStringBuilder.toString();
        return;
      }
      AdProgressDialog.INSTANCE.dismiss();
      return;
    }
    AdLog.e("GdtFormView", "showLoading error");
  }
  
  private boolean validate()
  {
    if ((getData() != null) && (getData().isValid()))
    {
      AdFormError localAdFormError = getData().validate();
      if (localAdFormError == null)
      {
        AdLog.e("GdtFormView", "validate error");
      }
      else
      {
        if (localAdFormError.type == 2) {
          return true;
        }
        onError(localAdFormError);
      }
    }
    else
    {
      AdLog.e("GdtFormView", "validate error");
    }
    return false;
  }
  
  public void afterCommit(AdFormError paramAdFormError)
  {
    boolean bool2 = false;
    showLoading(false);
    onError(paramAdFormError);
    boolean bool1 = bool2;
    if (paramAdFormError != null)
    {
      bool1 = bool2;
      if (paramAdFormError.type == 1) {
        bool1 = true;
      }
    }
    if (bool1) {
      reset();
    }
    notifyCommitted(bool1, paramAdFormError);
  }
  
  public void beforeCommit()
  {
    showLoading(true);
  }
  
  protected Ad getAd()
  {
    return this.ad;
  }
  
  protected AdFormData getData()
  {
    return this.data;
  }
  
  public void onError(AdFormError paramAdFormError)
  {
    if ((paramAdFormError != null) && (getData() != null) && (getData().isValid()))
    {
      StringBuilder localStringBuilder;
      if (paramAdFormError.type == 1)
      {
        this.errorIndex = -1;
        this.tableView.showError(-1);
        paramAdFormError = getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(getData().button.text.text);
        localStringBuilder.append("成功");
        AdToast.show(paramAdFormError, 2, localStringBuilder.toString(), 0);
        return;
      }
      if (paramAdFormError.type == 4)
      {
        this.errorIndex = -1;
        this.tableView.showError(-1);
        paramAdFormError = getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(getData().button.text.text);
        localStringBuilder.append("失败");
        AdToast.show(paramAdFormError, 1, localStringBuilder.toString(), 0);
        return;
      }
      if (paramAdFormError.type == 7)
      {
        this.errorIndex = -1;
        this.tableView.showError(-1);
        AdToast.show(getContext(), 1, "你已提交成功，请勿重复提交", 0);
        return;
      }
      if (paramAdFormError.type == 2)
      {
        if ((paramAdFormError.index == -1) || (paramAdFormError.index == this.errorIndex))
        {
          this.errorIndex = -1;
          this.tableView.showError(-1);
        }
      }
      else
      {
        if ((paramAdFormError.index != -1) && (!TextUtils.isEmpty(paramAdFormError.toString())))
        {
          this.errorIndex = paramAdFormError.index;
          this.tableView.showError(this.errorIndex);
          AdToast.show(getContext(), 1, paramAdFormError.toString(), 0);
          return;
        }
        AdLog.e("GdtFormView", "onError error");
      }
      return;
    }
    AdLog.e("GdtFormView", "onError error");
  }
  
  public void setListener(WeakReference<AdFormViewListener> paramWeakReference)
  {
    this.listener = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.form.AdFormView
 * JD-Core Version:    0.7.0.1
 */