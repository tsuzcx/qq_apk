package com.tencent.ad.tangram.canvas.views.form;

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
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormCommitListener;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormErrorListener;
import com.tencent.ad.tangram.canvas.views.form.framework.c;
import com.tencent.ad.tangram.canvas.views.form.framework.d;
import com.tencent.ad.tangram.canvas.views.xijing.AdButtonView;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import com.tencent.ad.tangram.dialog.AdProgressDialog;
import com.tencent.ad.tangram.dialog.AdProgressDialog.Params;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.ad.tangram.util.AdUIUtils;
import java.lang.ref.WeakReference;

@Keep
public final class AdFormView
  extends LinearLayout
  implements AdFormCommitListener, AdFormErrorListener
{
  private static final String TAG = "GdtFormView";
  private Ad ad;
  private View.OnClickListener buttonListener = new AdFormView.1(this);
  private AdFormData data;
  private int errorIndex = -1;
  private WeakReference<AdFormViewListener> listener;
  private c tableView;
  
  public AdFormView(Context paramContext, Ad paramAd, AdFormData paramAdFormData)
  {
    super(paramContext);
    init(paramContext, paramAd, paramAdFormData);
  }
  
  private void commit()
  {
    com.tencent.ad.tangram.canvas.views.form.framework.a.commitAsync(getContext(), getAd(), getData(), new WeakReference(this));
  }
  
  private void init(Context paramContext, Ad paramAd, AdFormData paramAdFormData)
  {
    if ((paramAd == null) || (!paramAd.isValid()) || (paramAd.getActionSetId() == -2147483648L) || (paramAdFormData == null) || (!paramAdFormData.isValid()))
    {
      AdLog.e("GdtFormView", "init error");
      return;
    }
    this.ad = paramAd;
    this.data = paramAdFormData;
    d.updateAsync(new WeakReference(getData()));
    initViews(paramContext);
  }
  
  private void initViews(Context paramContext)
  {
    if ((this.data == null) || (!this.data.isValid()))
    {
      AdLog.e("GdtFormView", "initViews error");
      return;
    }
    setFocusable(true);
    setFocusableInTouchMode(true);
    setBackgroundColor(getData().backgroundColor);
    setOrientation(1);
    if (getData().title != null) {}
    for (int i = 1;; i = 0)
    {
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
      this.tableView = new c(paramContext, getData().table, new WeakReference(this));
      Object localObject = new LinearLayout.LayoutParams(-1, -2);
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
  }
  
  private void notifyCommitted(boolean paramBoolean, AdFormError paramAdFormError)
  {
    if ((this.listener != null) && (this.listener.get() != null)) {
      ((AdFormViewListener)this.listener.get()).onCommitted(paramBoolean, paramAdFormError);
    }
  }
  
  private void reset()
  {
    if (this.tableView == null)
    {
      AdLog.e("GdtFormView", "reset error");
      return;
    }
    this.tableView.reset();
  }
  
  private void showLoading(boolean paramBoolean)
  {
    if ((getData() == null) || (!getData().isValid())) {
      AdLog.e("GdtFormView", "showLoading error");
    }
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
    } while (AdProgressDialog.INSTANCE.isShowing(getContext()));
    AdProgressDialog.Params localParams = new AdProgressDialog.Params();
    localParams.yOffset = AdUIUtils.dp2px(44.0F, getResources());
    localParams.cancelable = false;
    localParams.message = ("正在" + getData().button.text.text);
    return;
    AdProgressDialog.INSTANCE.dismiss();
  }
  
  private boolean validate()
  {
    if ((getData() == null) || (!getData().isValid()))
    {
      AdLog.e("GdtFormView", "validate error");
      return false;
    }
    AdFormError localAdFormError = getData().validate();
    if (localAdFormError == null)
    {
      AdLog.e("GdtFormView", "validate error");
      return false;
    }
    if (localAdFormError.type == 2) {
      return true;
    }
    onError(localAdFormError);
    return false;
  }
  
  public void afterCommit(AdFormError paramAdFormError)
  {
    boolean bool = true;
    showLoading(false);
    onError(paramAdFormError);
    if ((paramAdFormError != null) && (paramAdFormError.type == 1)) {}
    for (;;)
    {
      if (bool) {
        reset();
      }
      notifyCommitted(bool, paramAdFormError);
      return;
      bool = false;
    }
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
    if ((paramAdFormError == null) || (getData() == null) || (!getData().isValid())) {
      AdLog.e("GdtFormView", "onError error");
    }
    do
    {
      return;
      if (paramAdFormError.type == 1)
      {
        this.errorIndex = -1;
        this.tableView.showError(-1);
        AdToast.show(getContext(), 2, getData().button.text.text + "成功", 0);
        return;
      }
      if (paramAdFormError.type == 4)
      {
        this.errorIndex = -1;
        this.tableView.showError(-1);
        AdToast.show(getContext(), 1, getData().button.text.text + "失败", 0);
        return;
      }
      if (paramAdFormError.type == 7)
      {
        this.errorIndex = -1;
        this.tableView.showError(-1);
        AdToast.show(getContext(), 1, "你已提交成功，请勿重复提交", 0);
        return;
      }
      if (paramAdFormError.type != 2) {
        break;
      }
    } while ((paramAdFormError.index != -1) && (paramAdFormError.index != this.errorIndex));
    this.errorIndex = -1;
    this.tableView.showError(-1);
    return;
    if ((paramAdFormError.index != -1) && (!TextUtils.isEmpty(paramAdFormError.toString())))
    {
      this.errorIndex = paramAdFormError.index;
      this.tableView.showError(this.errorIndex);
      AdToast.show(getContext(), 1, paramAdFormError.toString(), 0);
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
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.form.AdFormView
 * JD-Core Version:    0.7.0.1
 */