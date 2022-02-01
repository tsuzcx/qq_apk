package com.tencent.biz.pubaccount.readinjoy.common;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import mqq.util.WeakReference;
import nnw;
import ocd;
import org.json.JSONException;
import org.json.JSONObject;
import paj;
import pak;
import zyx;

public class WxShareHelperFromReadInjoy
  extends BroadcastReceiver
  implements IWXAPIEventHandler
{
  private static WxShareHelperFromReadInjoy jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private IWXAPI jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI = WXAPIFactory.createWXAPI(BaseApplicationImpl.getApplication(), "wxeaef4303c20f3dea", true);
  private Long jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<pak> jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
  private WeakReference<Activity> jdField_a_of_type_MqqUtilWeakReference;
  
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
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("WxShareHelperFromReadInjoy", 2, "handleWXStartReport error, url is empty ");
    }
    Object localObject;
    do
    {
      return;
      localObject = Uri.parse(paramString);
      paramString = ((Uri)localObject).getQueryParameter("from_source");
      localObject = ((Uri)localObject).getQueryParameter("from_rowkey");
      if (QLog.isColorLevel()) {
        QLog.i("WxShareHelperFromReadInjoy", 2, "handleWXStartReport fromSource = " + paramString + " fromRowkey = " + (String)localObject);
      }
    } while (TextUtils.isEmpty(paramString));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("from_source", paramString);
      localJSONObject.put("from_rowkey", localObject);
      ocd.a(null, "CliOper", "", "", "0X800A7BF", "0X800A7BF", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private boolean a(SendMessageToWX.Req paramReq)
  {
    paj localpaj = new paj(this);
    WXShareHelper.a().a(localpaj);
    return this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramReq);
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
      localObject1 = nnw.a(localBitmap);
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
      localObject1 = nnw.a((Bitmap)localObject2);
    }
  }
  
  private static byte[] b(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      QLog.e("WxShareHelperFromReadInjoy", 1, "[bitmap2Bytes] bitmap is null.");
      return null;
    }
    int i = 100;
    Object localObject = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
    for (localObject = ((ByteArrayOutputStream)localObject).toByteArray(); (localObject.length >= 131072) && (i > 0); localObject = ((ByteArrayOutputStream)localObject).toByteArray())
    {
      i -= 10;
      localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, i, (OutputStream)localObject);
    }
    QLog.i("WxShareHelperFromReadInjoy", 1, "[bitmap2Bytes] length = " + localObject.length + ", quality = " + i);
    return localObject;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.registerApp("wxeaef4303c20f3dea");
  }
  
  public void a(Activity paramActivity, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WxShareHelperFromReadInjoy", 2, "handleWXEntryActivityIntent");
    }
    if (this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WxShareHelperFromReadInjoy", 2, "handleWXEntryActivityIntent api != null");
      }
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
      this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.handleIntent(paramIntent, this);
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      zyx.a(1, 2131695816);
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
    a(paramBitmap);
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
    boolean bool = a(paramBitmap);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder().append("shareWebPage.transaction: ").append(paramString1).append(" title:").append(paramString2).append(" description:").append(paramString3).append(" webPageUrl:").append(paramString4).append(" scene:");
      if (paramInt != 0) {
        break label166;
      }
    }
    label166:
    for (paramString1 = "Friend";; paramString1 = "FriendCircle")
    {
      QLog.i("WxShareHelperFromReadInjoy", 2, paramString1 + " reqResult:" + bool);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, String paramString5)
  {
    c(paramString1, paramString2, paramBitmap, paramString3, paramString4, "/pages/index/index?share=1&share_type=2&channel_id=10&rowkey=" + paramString5 + "&title=" + URLEncoder.encode(paramString2) + "&timeTips=" + new SimpleDateFormat("MM-dd").format(new Date()));
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ThreadManagerV2.excute(new WxShareHelperFromReadInjoy.1(this, paramString4, paramString6, paramString5, paramString2, paramString3, paramBitmap, paramString1), 16, null, true);
    if (QLog.isColorLevel()) {
      QLog.d("WxShareHelperFromReadInjoy", 2, "shareToMiniProgramWithPathAndId, title = " + paramString2 + ", description = " + paramString3 + ", path = " + paramString5 + ", webPageUrl = " + paramString4 + ", id = " + paramString6);
    }
  }
  
  public void a(pak parampak)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(parampak)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(parampak);
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
    boolean bool = a(paramBitmap);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder().append("shareVideo.transaction: ").append(paramString1).append(" title:").append(paramString2).append(" description:").append(paramString3).append(" webPageUrl:").append(paramString4).append(" scene:");
      if (paramInt != 0) {
        break label182;
      }
    }
    label182:
    for (paramString1 = "Friend";; paramString1 = "FriendCircle")
    {
      QLog.i("WxShareHelperFromReadInjoy", 2, paramString1 + " reqResult:" + bool);
      return;
    }
  }
  
  public void b(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, String paramString5)
  {
    c(paramString1, paramString2, paramBitmap, paramString3, paramString4, "/pages/index/index?share=1&share_type=1&channel_id=10&rowkey=" + paramString5);
  }
  
  public void b(pak parampak)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(parampak);
      return;
    }
  }
  
  public void c(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, String paramString5)
  {
    a(paramString1, paramString2, paramBitmap, paramString3, paramString4, paramString5, "gh_eaa1f0b1626b");
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.handleIntent(paramIntent, this);
  }
  
  public void onReq(BaseReq paramBaseReq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WxShareHelperFromReadInjoy", 2, "WXShareHelper.onReq:" + paramBaseReq.getType());
    }
    Activity localActivity;
    if (this.jdField_a_of_type_MqqUtilWeakReference != null)
    {
      localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localActivity != null) {
        break label98;
      }
      QLog.e("WxShareHelperFromReadInjoy", 2, "WXShareHelper.onReq:" + paramBaseReq.getType() + " activity == null.");
    }
    label98:
    Long localLong;
    do
    {
      do
      {
        return;
        localActivity = null;
        break;
        switch (paramBaseReq.getType())
        {
        default: 
          return;
        }
      } while (!(paramBaseReq instanceof ShowMessageFromWX.Req));
      paramBaseReq = ((ShowMessageFromWX.Req)paramBaseReq).message.messageExt;
      if (QLog.isColorLevel()) {
        QLog.i("WxShareHelperFromReadInjoy", 2, "WXShareHelper.onReq: url = " + paramBaseReq);
      }
      localLong = Long.valueOf(System.currentTimeMillis());
    } while ((TextUtils.isEmpty(paramBaseReq)) || ((paramBaseReq.equals(this.jdField_a_of_type_JavaLangString)) && (localLong.longValue() - this.jdField_a_of_type_JavaLangLong.longValue() < 300L)));
    Intent localIntent = new Intent(localActivity, JumpActivity.class);
    localIntent.setData(Uri.parse(paramBaseReq));
    localActivity.startActivity(localIntent);
    a(paramBaseReq);
    this.jdField_a_of_type_JavaLangString = paramBaseReq;
    this.jdField_a_of_type_JavaLangLong = localLong;
  }
  
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
          ((pak)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramBaseResp);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy
 * JD-Core Version:    0.7.0.1
 */