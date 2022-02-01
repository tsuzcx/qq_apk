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
  WeakReference<ShareChat.SharePanel> a;
  long b;
  WeakReference<Context> c;
  String d;
  int e;
  int f;
  
  ShareChat$SharePanel$MyWXShareListener(ShareChat.SharePanel paramSharePanel, long paramLong, Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    this.a = new WeakReference(paramSharePanel);
    this.b = paramLong;
    this.c = new WeakReference(paramContext);
    this.d = paramString;
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onWXShareResp, mWXTransaction[");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("], transaction[");
    ((StringBuilder)localObject).append(paramBaseResp.transaction);
    ((StringBuilder)localObject).append("], errCode[");
    ((StringBuilder)localObject).append(paramBaseResp.errCode);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("]");
    QLog.w("ShareChat", 1, ((StringBuilder)localObject).toString());
    if (!TextUtils.equals(this.d, paramBaseResp.transaction)) {
      return;
    }
    localObject = (ShareChat.SharePanel)this.a.get();
    Context localContext = (Context)this.c.get();
    if (localObject != null)
    {
      if (localContext == null) {
        return;
      }
      int j = paramBaseResp.errCode;
      int i = 2;
      if (j != -2) {
        if (j != 0) {
          QQToast.makeText(localContext, 1, localContext.getString(2131916544), 0).show();
        } else {
          QQToast.makeText(localContext, 2, localContext.getString(2131916563), 0).show();
        }
      }
      WXShareHelper.a().b(this);
      j = this.e;
      int k = this.f;
      if (paramBaseResp.errCode != 0) {
        i = 3;
      }
      ((ShareChat.SharePanel)localObject).a(j, k, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.MyWXShareListener
 * JD-Core Version:    0.7.0.1
 */