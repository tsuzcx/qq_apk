package com.tencent.ad.tangram.views.button;

import android.support.annotation.Keep;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.downloader.AdDownloaderV2;
import com.tencent.ad.tangram.downloader.AdDownloaderV2.Listener;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.ad.tangram.util.AdClickUtil.Params;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Keep
public final class AdButtonController
{
  private static final String TAG = "AdButtonController";
  private AdClickUtil.Params clickParams;
  private a fragment;
  private boolean layerDisplayed = false;
  private AdDownloaderV2.Listener onDownloadListener = new AdButtonController.7(this);
  private int progress = 0;
  private int status = -2147483648;
  private int statusOfView = -2147483648;
  private String url;
  private List<WeakReference<IAdButtonView>> viewList = new CopyOnWriteArrayList();
  private IAdButtonView.a viewListenerInPlacement;
  private IAdButtonView.a viewListenerNotInPlacement;
  
  public AdButtonController(AdClickUtil.Params paramParams)
  {
    this.clickParams = paramParams;
    if (!isValid())
    {
      AdLog.e("AdButtonController", "constructor error");
      return;
    }
    boolean bool;
    if ((paramParams.enableAutoDownload) && (!paramParams.ad.disableAutoDownload())) {
      bool = true;
    } else {
      bool = false;
    }
    paramParams.enableAutoDownload = bool;
    if (paramParams.ad.isAppProductType())
    {
      this.status = 2;
      this.statusOfView = 2;
    }
    AdDownloaderV2.INSTANCE.init();
    AdDownloaderV2.INSTANCE.registerListener(new WeakReference(this.onDownloadListener));
    this.viewListenerInPlacement = createButtonViewListener(true);
    this.viewListenerNotInPlacement = createButtonViewListener(false);
  }
  
  private IAdButtonView.a createButtonViewListener(boolean paramBoolean)
  {
    return new AdButtonController.5(this, paramBoolean);
  }
  
  private View.OnClickListener createOnClickListener(boolean paramBoolean)
  {
    return new AdButtonController.6(this, paramBoolean);
  }
  
  private void installDownload()
  {
    AdDownloaderV2.INSTANCE.installDownload(this.url);
  }
  
  private boolean isValid()
  {
    AdClickUtil.Params localParams = this.clickParams;
    return (localParams != null) && (localParams.isValid());
  }
  
  private void loadInfo(boolean paramBoolean1, boolean paramBoolean2)
  {
    AdThreadManager.INSTANCE.post(new AdButtonController.4(this, paramBoolean2, paramBoolean1), 4);
  }
  
  private void pauseDownload()
  {
    AdDownloaderV2.INSTANCE.pauseDownload(this.url);
  }
  
  private void refresh()
  {
    if (!isValid())
    {
      AdLog.e("AdButtonController", "refresh error");
      return;
    }
    int i;
    if (AdClickUtil.isValidForApp(this.clickParams))
    {
      i = this.status;
      if ((i != 2) && (i != 8) && (i != 9))
      {
        updateViews(this.statusOfView, this.progress);
        return;
      }
      i = AdClickUtil.getActionAboutApp(this.clickParams, -2147483648);
      if ((i != 4) && (i != 5))
      {
        if (!TextUtils.isEmpty(this.url))
        {
          AdThreadManager.INSTANCE.post(new AdButtonController.1(this), 5);
          return;
        }
        updateValueAndViews(2, 0);
        return;
      }
      updateValueAndViews(9, 100);
      return;
    }
    if (!TextUtils.isEmpty(this.clickParams.ad.getAppDeeplink()))
    {
      i = AdClickUtil.getActionAboutApp(this.clickParams, -2147483648);
      if ((i != 4) && (i != 5))
      {
        updateValueAndViews(-2147483648, 0);
        return;
      }
      updateValueAndViews(9, 100);
      return;
    }
    updateViews(this.statusOfView, this.progress);
  }
  
  private void startDownload()
  {
    updateViews(5, this.progress);
    AdDownloaderV2.INSTANCE.startDownload(this.url, this.clickParams.ad, this.clickParams.extrasForIntent);
  }
  
  private void updateValue(int paramInt1, int paramInt2)
  {
    AdThreadManager.INSTANCE.post(new AdButtonController.2(this, paramInt1, paramInt2), 0);
  }
  
  private void updateValueAndViews(int paramInt1, int paramInt2)
  {
    updateValue(paramInt1, paramInt2);
    updateViews(paramInt1, paramInt2);
  }
  
  private void updateViews(int paramInt1, int paramInt2)
  {
    AdThreadManager.INSTANCE.post(new AdButtonController.3(this, paramInt1, paramInt2), 0);
  }
  
  public void onActivityDestoryed()
  {
    AdDownloaderV2.INSTANCE.unregisterListener(new WeakReference(this.onDownloadListener));
  }
  
  public void onActivityPaused() {}
  
  public void onActivityResume()
  {
    refresh();
  }
  
  public void registerView(WeakReference<IAdButtonView> paramWeakReference, boolean paramBoolean)
  {
    if ((paramWeakReference != null) && (paramWeakReference.get() != null))
    {
      Object localObject = this.viewList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == paramWeakReference.get()))
        {
          AdLog.e("AdButtonController", "registerView again");
          return;
        }
      }
      localObject = (IAdButtonView)paramWeakReference.get();
      if (paramBoolean) {
        paramWeakReference = this.viewListenerInPlacement;
      } else {
        paramWeakReference = this.viewListenerNotInPlacement;
      }
      ((IAdButtonView)localObject).registerListener(new WeakReference(paramWeakReference));
      return;
    }
    AdLog.e("AdButtonController", "registerView error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.button.AdButtonController
 * JD-Core Version:    0.7.0.1
 */