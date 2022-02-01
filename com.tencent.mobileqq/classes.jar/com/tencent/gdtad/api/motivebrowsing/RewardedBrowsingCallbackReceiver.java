package com.tencent.gdtad.api.motivebrowsing;

import acdk;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import bkqx;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import kotlin.Metadata;
import mqq.util.WeakReference;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/RewardedBrowsingCallbackReceiver;", "Landroid/content/BroadcastReceiver;", "plugin", "Lcom/tencent/qqmini/proxyimpl/RewardedVideoAdPlugin;", "proxy", "Lcom/tencent/qqmini/proxyimpl/AdProxyImpl;", "(Lcom/tencent/qqmini/proxyimpl/RewardedVideoAdPlugin;Lcom/tencent/qqmini/proxyimpl/AdProxyImpl;)V", "mPlugin", "Lmqq/util/WeakReference;", "mProxy", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RewardedBrowsingCallbackReceiver
  extends BroadcastReceiver
{
  public static final acdk a;
  private final WeakReference<bkqx> a;
  private final WeakReference<AdProxyImpl> b;
  
  static
  {
    jdField_a_of_type_Acdk = new acdk(null);
  }
  
  public RewardedBrowsingCallbackReceiver()
  {
    this(null, null, 3, null);
  }
  
  public RewardedBrowsingCallbackReceiver(@Nullable bkqx parambkqx, @Nullable AdProxyImpl paramAdProxyImpl)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(parambkqx);
    this.b = new WeakReference(paramAdProxyImpl);
  }
  
  public void onReceive(@Nullable Context paramContext, @Nullable Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RewardedBrowsingCallbackReceiver", 2, "RewardedBrowsingCallbackReceiver onReceive");
    }
    if ((paramIntent != null) && (TextUtils.equals((CharSequence)paramIntent.getAction(), (CharSequence)"AD_PROXY_ACTION_MOTIVE_BROWSING_END")))
    {
      paramContext = (AdProxyImpl)this.b.get();
      if (paramContext != null) {
        paramContext.a(paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivebrowsing.RewardedBrowsingCallbackReceiver
 * JD-Core Version:    0.7.0.1
 */