package com.tencent.biz.webviewplugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class Share$8
  extends Handler
{
  boolean a;
  
  Share$8(Share paramShare) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    Object localObject;
    if (i != 1001)
    {
      if (i != 1002) {
        return;
      }
      if (((paramMessage.obj instanceof Bitmap)) && (!this.a) && (this.b.F != null) && (this.b.F.androidInfo != null) && (!TextUtils.isEmpty(this.b.F.androidInfo.packName.get())))
      {
        localObject = this.b.F.androidInfo;
        if (PackageUtil.a(this.b.R, ((GetAppInfoProto.AndroidInfo)localObject).packName.get())) {
          this.b.Q.setText(this.b.R.getResources().getString(2131886909));
        } else {
          this.b.Q.setText(this.b.R.getResources().getString(2131886908));
        }
        this.b.P.setText(String.format(this.b.R.getResources().getString(2131886910), new Object[] { ((GetAppInfoProto.AndroidInfo)localObject).messagetail.get() }));
        paramMessage = (Bitmap)paramMessage.obj;
        if (paramMessage.isRecycled()) {
          return;
        }
        paramMessage = ImageUtil.a(paramMessage, (int)(this.b.K * 30.0F));
        this.b.L.setVisibility(0);
        this.b.O.setImageBitmap(paramMessage);
        OpenSdkStatic.a().a(this.b.H, String.valueOf(AppShareIDUtil.d(this.b.E)), "ANDROIDQQ.SHAREBAR", "100", false);
        if (QLog.isColorLevel()) {
          QLog.d(Share.a, 2, "QQBrowserActivity APP_FLOATING_BAR VISIBLE -----------------------");
        }
      }
    }
    else if (((paramMessage.obj instanceof Bitmap)) && (!this.a))
    {
      paramMessage = (Bitmap)paramMessage.obj;
      if (paramMessage.isRecycled()) {
        return;
      }
      paramMessage = ImageUtil.a(paramMessage, (int)(this.b.K * 34.0F));
      if (this.b.af != null)
      {
        localObject = (WebUiBaseInterface)this.b.af.get();
        this.b.C.setVisibility(0);
        this.b.D.setImageBitmap(paramMessage);
        if ((this.b.y instanceof SwiftWebViewFragmentSupporter))
        {
          paramMessage = ((SwiftWebViewFragmentSupporter)this.b.y).getCurrentWebViewFragment();
          if ((paramMessage != null) && (paramMessage.getUIStyleHandler().s != null))
          {
            paramMessage.getUIStyleHandler().s.findViewById(2131432808).setVisibility(8);
            paramMessage.getUIStyleHandler().s.findViewById(2131432809).setVisibility(0);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(Share.a, 2, "QQBrowserActivity VISIBLE -----------------------");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.8
 * JD-Core Version:    0.7.0.1
 */