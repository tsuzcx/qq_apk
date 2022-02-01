package com.tencent.biz.pubaccount.ecshopassit.view;

import android.content.Context;
import android.content.MutableContextWrapper;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;

public class EcshopWebview
  extends TouchWebView
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static EcshopWebview b;
  public static int c;
  private EcshopWebview jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview;
  public int b;
  private int d;
  
  public EcshopWebview(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.i("parasons333", 2, "---EcshopWebview---");
    }
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
        c -= 1;
      }
      if (localEcshopWebview == null) {
        return new EcshopWebview(new MutableContextWrapper(paramContext));
      }
    }
    localEcshopWebview.clearHistory();
    localEcshopWebview.jdField_b_of_type_Int = 1;
    localEcshopWebview.d += 1;
    localEcshopWebview.onResume();
    ((MutableContextWrapper)localEcshopWebview.getContext()).setBaseContext(paramContext);
    return localEcshopWebview;
  }
  
  public boolean canGoBack()
  {
    if (1 == this.jdField_b_of_type_Int)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.EcshopWebview
 * JD-Core Version:    0.7.0.1
 */