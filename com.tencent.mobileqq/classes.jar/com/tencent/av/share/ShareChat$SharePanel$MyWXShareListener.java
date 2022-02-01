package com.tencent.av.share;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ShareChat$SharePanel$MyWXShareListener
  implements WXShareHelper.WXShareListener
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  WeakReference<ShareChat.SharePanel> jdField_a_of_type_JavaLangRefWeakReference;
  int jdField_b_of_type_Int;
  WeakReference<Context> jdField_b_of_type_JavaLangRefWeakReference;
  
  ShareChat$SharePanel$MyWXShareListener(ShareChat.SharePanel paramSharePanel, long paramLong, Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramSharePanel);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    QLog.w("ShareChat", 1, "onWXShareResp, mWXTransaction[" + this.jdField_a_of_type_JavaLangString + "], transaction[" + paramBaseResp.transaction + "], errCode[" + paramBaseResp.errCode + "], seq[" + this.jdField_a_of_type_Long + "]");
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramBaseResp.transaction)) {}
    ShareChat.SharePanel localSharePanel;
    Context localContext;
    do
    {
      return;
      localSharePanel = (ShareChat.SharePanel)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      localContext = (Context)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    } while ((localSharePanel == null) || (localContext == null));
    int j;
    int k;
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QQToast.a(localContext, 1, localContext.getString(2131719291), 0).a();
    case -2: 
      WXShareHelper.a().b(this);
      j = this.jdField_a_of_type_Int;
      k = this.jdField_b_of_type_Int;
      if (paramBaseResp.errCode != 0) {
        break;
      }
    }
    for (int i = 2;; i = 3)
    {
      localSharePanel.a(j, k, i);
      return;
      QQToast.a(localContext, 2, localContext.getString(2131719309), 0).a();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.MyWXShareListener
 * JD-Core Version:    0.7.0.1
 */