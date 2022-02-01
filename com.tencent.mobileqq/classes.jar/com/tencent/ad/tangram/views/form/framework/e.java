package com.tencent.ad.tangram.views.form.framework;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.form.AdFormError;
import com.tencent.ad.tangram.views.xijing.AdTextData;
import java.lang.ref.WeakReference;

public abstract class e
  extends TableRow
{
  private static final String TAG = "AdFormItemView";
  private d data;
  private WeakReference<c> listener;
  
  public e(Context paramContext, d paramd, WeakReference<c> paramWeakReference)
  {
    super(paramContext);
    this.listener = paramWeakReference;
    init(paramContext, paramd);
  }
  
  private View createTitleView(Context paramContext)
  {
    if ((getData() != null) && (getData().isValid()))
    {
      Object localObject;
      if (getData().required)
      {
        localObject = getData().title.text;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(getData().title.text);
        ((StringBuilder)localObject).append("(选填)");
        localObject = ((StringBuilder)localObject).toString();
      }
      paramContext = new TextView(paramContext);
      paramContext.setGravity(16);
      paramContext.setText((CharSequence)localObject);
      paramContext.setTextColor(getData().title.color);
      paramContext.setTextSize(0, getData().title.size);
      return paramContext;
    }
    AdLog.e("AdFormItemView", "createTitleView error");
    return null;
  }
  
  private void init(Context paramContext, d paramd)
  {
    if ((paramd != null) && (paramd.isValid()))
    {
      this.data = paramd;
      initViews(paramContext);
      return;
    }
    AdLog.e("AdFormItemView", "init error");
  }
  
  private void initViews(Context paramContext)
  {
    if ((getData() != null) && (getData().isValid()))
    {
      TableRow.LayoutParams localLayoutParams = new TableRow.LayoutParams(-2, -2);
      View localView = createTitleView(paramContext);
      Object localObject = localView;
      if (localView == null)
      {
        AdLog.e("AdFormItemView", "initViews error");
        localObject = new FrameLayout(paramContext);
      }
      addView((View)localObject, localLayoutParams);
      ((View)localObject).setPadding(getData().titlePaddingLeft, getData().paddingTop, getData().titlePaddingRight, getData().paddingBottom);
      localLayoutParams = new TableRow.LayoutParams(-1, -2);
      localView = createContentView(paramContext);
      localObject = localView;
      if (localView == null)
      {
        AdLog.e("AdFormItemView", "initViews error");
        localObject = new FrameLayout(paramContext);
      }
      addView((View)localObject, localLayoutParams);
      ((View)localObject).setPadding(getData().contentPaddingLeft, getData().paddingTop, getData().contentPaddingRight, getData().paddingBottom);
      return;
    }
    AdLog.e("AdFormItemView", "initViews error");
  }
  
  protected abstract View createContentView(Context paramContext);
  
  protected d getData()
  {
    return this.data;
  }
  
  protected int getIndex()
  {
    if (!(getParent() instanceof TableLayout))
    {
      AdLog.e("AdFormItemView", "getIndex error");
      return -1;
    }
    return ((TableLayout)getParent()).indexOfChild(this);
  }
  
  public abstract void reset();
  
  protected void showError(AdFormError paramAdFormError)
  {
    WeakReference localWeakReference = this.listener;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((c)this.listener.get()).onError(paramAdFormError);
    }
  }
  
  protected boolean validate()
  {
    if ((getData() != null) && (getData().isValid()))
    {
      AdFormError localAdFormError = getData().validate();
      if (localAdFormError == null)
      {
        AdLog.e("AdFormItemView", "validate error");
        return false;
      }
      localAdFormError.index = getIndex();
      if (localAdFormError.type == 2) {
        return true;
      }
      if (localAdFormError.type == 5) {
        return false;
      }
      showError(localAdFormError);
      return false;
    }
    AdLog.e("AdFormItemView", "validate error");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.form.framework.e
 * JD-Core Version:    0.7.0.1
 */