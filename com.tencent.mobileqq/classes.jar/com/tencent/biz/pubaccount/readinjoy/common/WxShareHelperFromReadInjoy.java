package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class WxShareHelperFromReadInjoy
  extends BroadcastReceiver
  implements IWXAPIEventHandler
{
  private static WxShareHelperFromReadInjoy jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private IWXAPI jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI = WXAPIFactory.createWXAPI(BaseApplicationImpl.getApplication(), "wxeaef4303c20f3dea", true);
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
  
  private WxShareHelperFromReadInjoy()
  {
    BaseApplication.getContext().registerReceiver(this, new IntentFilter("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE"), "com.tencent.msg.permission.pushnotify", null);
    a();
  }
  
  public static WxShareHelperFromReadInjoy a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy = new WxShareHelperFromReadInjoy();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy;
    }
  }
  
  public static byte[] a(Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBitmap == null)
    {
      localObject2 = null;
      return localObject2;
    }
    float f = Math.max(100.0F / paramBitmap.getWidth(), 100.0F / paramBitmap.getHeight());
    Object localObject1 = new Matrix();
    ((Matrix)localObject1).postScale(f, f);
    Object localObject2 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject1, true);
    if (paramBoolean2)
    {
      Bitmap localBitmap = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, 100, 100);
      localObject1 = ImageUtil.a(localBitmap);
      localBitmap.recycle();
    }
    for (;;)
    {
      ((Bitmap)localObject2).recycle();
      localObject2 = localObject1;
      if (!paramBoolean1) {
        break;
      }
      paramBitmap.recycle();
      return localObject1;
      localObject1 = ImageUtil.a((Bitmap)localObject2);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.registerApp("wxeaef4303c20f3dea");
  }
  
  public void a(WxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener paramWXShareHelperFromReadInjoyListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramWXShareHelperFromReadInjoyListener)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramWXShareHelperFromReadInjoyListener);
      }
      return;
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QRUtils.a(1, 2131429987);
      return;
    }
    WXImageObject localWXImageObject = new WXImageObject();
    localWXImageObject.imagePath = paramString;
    paramString = new WXMediaMessage();
    paramString.mediaObject = localWXImageObject;
    paramString.thumbData = a(paramBitmap, false, paramBoolean);
    if (((paramString.thumbData == null) || ((paramString.thumbData != null) && (paramString.thumbData.length > 32768))) && (QLog.isColorLevel())) {
      QLog.i("WxShareHelperFromReadInjoy", 2, "wxmsg.thumbData is invalid");
    }
    paramBitmap = new SendMessageToWX.Req();
    paramBitmap.message = paramString;
    paramBitmap.scene = paramInt;
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramBitmap);
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, int paramInt)
  {
    WXMediaMessage localWXMediaMessage = new WXMediaMessage(new WXWebpageObject(paramString4));
    localWXMediaMessage.description = paramString3;
    localWXMediaMessage.title = paramString2;
    localWXMediaMessage.setThumbImage(paramBitmap);
    paramBitmap = new SendMessageToWX.Req();
    paramBitmap.transaction = paramString1;
    paramBitmap.message = localWXMediaMessage;
    paramBitmap.scene = paramInt;
    boolean bool = this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramBitmap);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder().append("shareWebPage.transaction: ").append(paramString1).append(" title:").append(paramString2).append(" description:").append(paramString3).append(" webPageUrl:").append(paramString4).append(" scene:");
      if (paramInt != 0) {
        break label164;
      }
    }
    label164:
    for (paramString1 = "Friend";; paramString1 = "FriendCircle")
    {
      QLog.i("WxShareHelperFromReadInjoy", 2, paramString1 + " reqResult:" + bool);
      return;
    }
  }
  
  public void b(WxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener paramWXShareHelperFromReadInjoyListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramWXShareHelperFromReadInjoyListener)) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramWXShareHelperFromReadInjoyListener);
      }
      return;
    }
  }
  
  public void b(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, int paramInt)
  {
    Object localObject = new WXVideoObject();
    ((WXVideoObject)localObject).videoUrl = paramString4;
    ((WXVideoObject)localObject).videoLowBandUrl = paramString4;
    localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
    ((WXMediaMessage)localObject).description = paramString3;
    ((WXMediaMessage)localObject).title = paramString2;
    ((WXMediaMessage)localObject).setThumbImage(paramBitmap);
    paramBitmap = new SendMessageToWX.Req();
    paramBitmap.transaction = paramString1;
    paramBitmap.message = ((WXMediaMessage)localObject);
    paramBitmap.scene = paramInt;
    boolean bool = this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramBitmap);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder().append("shareVideo.transaction: ").append(paramString1).append(" title:").append(paramString2).append(" description:").append(paramString3).append(" webPageUrl:").append(paramString4).append(" scene:");
      if (paramInt != 0) {
        break label180;
      }
    }
    label180:
    for (paramString1 = "Friend";; paramString1 = "FriendCircle")
    {
      QLog.i("WxShareHelperFromReadInjoy", 2, paramString1 + " reqResult:" + bool);
      return;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.handleIntent(paramIntent, this);
  }
  
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WxShareHelperFromReadInjoy", 2, "WXShareHelper.onResp:" + paramBaseResp.errCode + " ,errStr:" + paramBaseResp.errStr);
    }
    try
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        while (i >= 0)
        {
          ((WxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramBaseResp);
          i -= 1;
        }
        return;
      }
      return;
    }
    catch (Exception paramBaseResp)
    {
      QLog.e("WxShareHelperFromReadInjoy", 1, "WXShareHelper.onResp error, ", paramBaseResp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy
 * JD-Core Version:    0.7.0.1
 */