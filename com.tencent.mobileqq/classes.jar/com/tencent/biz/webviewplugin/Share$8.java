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
  boolean jdField_a_of_type_Boolean;
  
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
      if (((paramMessage.obj instanceof Bitmap)) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) && (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo.packName.get())))
      {
        localObject = this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
        if (PackageUtil.a(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidContentContext, ((GetAppInfoProto.AndroidInfo)localObject).packName.get())) {
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare.b.setText(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690090));
        } else {
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare.b.setText(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690089));
        }
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690091), new Object[] { ((GetAppInfoProto.AndroidInfo)localObject).messagetail.get() }));
        paramMessage = (Bitmap)paramMessage.obj;
        if (paramMessage.isRecycled()) {
          return;
        }
        paramMessage = ImageUtil.a(paramMessage, (int)(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_Float * 30.0F));
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.c.setImageBitmap(paramMessage);
        OpenSdkStatic.a().a(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.n, String.valueOf(AppShareIDUtil.b(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_Long)), "ANDROIDQQ.SHAREBAR", "100", false);
        if (QLog.isColorLevel()) {
          QLog.d(Share.jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity APP_FLOATING_BAR VISIBLE -----------------------");
        }
      }
    }
    else if (((paramMessage.obj instanceof Bitmap)) && (!this.jdField_a_of_type_Boolean))
    {
      paramMessage = (Bitmap)paramMessage.obj;
      if (paramMessage.isRecycled()) {
        return;
      }
      paramMessage = ImageUtil.a(paramMessage, (int)(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_Float * 34.0F));
      if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject = (WebUiBaseInterface)this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_JavaLangRefWeakReference.get();
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramMessage);
        if ((this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidAppActivity instanceof SwiftWebViewFragmentSupporter))
        {
          paramMessage = ((SwiftWebViewFragmentSupporter)this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidAppActivity).getCurrentWebViewFragment();
          if ((paramMessage != null) && (paramMessage.getUIStyleHandler().b != null))
          {
            paramMessage.getUIStyleHandler().b.findViewById(2131366489).setVisibility(8);
            paramMessage.getUIStyleHandler().b.findViewById(2131366490).setVisibility(0);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(Share.jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity VISIBLE -----------------------");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.8
 * JD-Core Version:    0.7.0.1
 */