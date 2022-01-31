package com.tencent.biz.pubaccount.ecshopassit.view;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;

public class EcshopWebview
  extends TouchWebView
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static int b;
  private static EcshopWebview b;
  public int a;
  private EcshopWebview jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview;
  private int c;
  
  public EcshopWebview(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
  }
  
  public static EcshopWebview a(Context paramContext)
  {
    EcshopWebview localEcshopWebview = null;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      QLog.i("EcshopWebview", 1, "sPool acquire:" + jdField_b_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview);
      if (jdField_b_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview != null)
      {
        localEcshopWebview = jdField_b_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview;
        jdField_b_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview = localEcshopWebview.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview;
        localEcshopWebview.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview = null;
        jdField_b_of_type_Int -= 1;
      }
      if (localEcshopWebview == null) {
        return new EcshopWebview(new MutableContextWrapper(paramContext));
      }
    }
    localEcshopWebview.clearHistory();
    localEcshopWebview.jdField_a_of_type_Int = 1;
    localEcshopWebview.c += 1;
    localEcshopWebview.onResume();
    ((MutableContextWrapper)localEcshopWebview.getContext()).setBaseContext(paramContext);
    return localEcshopWebview;
  }
  
  public void a(boolean paramBoolean)
  {
    for (int i = 1;; i = 0)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_b_of_type_Int >= 1) {
          continue;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview = jdField_b_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview;
        jdField_b_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview = this;
        jdField_b_of_type_Int += 1;
        if (i != 0)
        {
          ((MutableContextWrapper)getContext()).setBaseContext(BaseApplicationImpl.sApplication);
          if (!paramBoolean)
          {
            resetForReuse();
            onPause();
          }
          return;
        }
      }
      super.destroy();
      return;
    }
  }
  
  public boolean canGoBack()
  {
    if (1 == this.jdField_a_of_type_Int)
    {
      Object localObject = copyBackForwardList();
      if ((localObject != null) && (((WebBackForwardList)localObject).getSize() > 0))
      {
        localObject = ((WebBackForwardList)localObject).getItemAtIndex(0);
        if ((localObject != null) && ("about:blank".equals(((WebHistoryItem)localObject).getUrl()))) {
          return super.canGoBackOrForward(-2);
        }
      }
      return super.canGoBack();
    }
    return super.canGoBack();
  }
  
  public void destroy()
  {
    if (this.c > 1)
    {
      super.destroy();
      return;
    }
    if (!"about:blank".equals(getUrl())) {}
    try
    {
      stopLoading();
      loadUrlOriginal("about:blank");
      clearHistory();
      clearView();
      new Handler(Looper.getMainLooper()).postDelayed(new EcshopWebview.1(this), 1000L);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("EcshopWebview", 1, "destroy error:" + localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.EcshopWebview
 * JD-Core Version:    0.7.0.1
 */