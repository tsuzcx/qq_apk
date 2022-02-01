package com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl;

import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptReport;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageTypeOptHelper;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.biz.pubaccount.util.FluencyOptUtils;
import com.tencent.tkd.comment.publisher.qq.bridge.QQUrlImageBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQUrlImageBridge.Callback;
import java.net.MalformedURLException;
import java.net.URL;

public class QQUrlImageBridgeImpl
  implements QQUrlImageBridge
{
  public void loadUrlImage(String paramString, int paramInt1, int paramInt2, QQUrlImageBridge.Callback paramCallback)
  {
    try
    {
      URL localURL2 = FluencyOptUtils.a.a(paramString);
      URL localURL1 = localURL2;
      if (localURL2 == null)
      {
        localURL1 = new URL(paramString);
        FluencyOptUtils.a.a(localURL1);
      }
      paramString = new ImageRequest();
      RIJImageTypeOptHelper.a.a(paramString, localURL1.toString());
      paramString.a = paramInt1;
      paramString.b = paramInt2;
      RIJImageOptReport.a(1, paramString);
      ImageManager.a().a(paramString, new QQUrlImageBridgeImpl.1(this, paramCallback));
      return;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl.QQUrlImageBridgeImpl
 * JD-Core Version:    0.7.0.1
 */