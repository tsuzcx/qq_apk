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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onWXShareResp, mWXTransaction[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("], transaction[");
    ((StringBuilder)localObject).append(paramBaseResp.transaction);
    ((StringBuilder)localObject).append("], errCode[");
    ((StringBuilder)localObject).append(paramBaseResp.errCode);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append("]");
    QLog.w("ShareChat", 1, ((StringBuilder)localObject).toString());
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramBaseResp.transaction)) {
      return;
    }
    localObject = (ShareChat.SharePanel)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Context localContext = (Context)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (localObject != null)
    {
      if (localContext == null) {
        return;
      }
      int j = paramBaseResp.errCode;
      int i = 2;
      if (j != -2) {
        if (j != 0) {
          QQToast.a(localContext, 1, localContext.getString(2131719009), 0).a();
        } else {
          QQToast.a(localContext, 2, localContext.getString(2131719027), 0).a();
        }
      }
      WXShareHelper.a().b(this);
      j = this.jdField_a_of_type_Int;
      int k = this.jdField_b_of_type_Int;
      if (paramBaseResp.errCode != 0) {
        i = 3;
      }
      ((ShareChat.SharePanel)localObject).a(j, k, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.MyWXShareListener
 * JD-Core Version:    0.7.0.1
 */