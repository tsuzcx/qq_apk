package com.tencent.biz.pubaccount.util.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.net.URL;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IPublicAccountHttpDownloader
  extends QRouteApi
{
  public static final String BUSI_TYPE_PARAM_KEY = "busiType";
  public static final String PROTOCOL_PUB_ACCOUNT = "pubaccountimage";
  public static final int PUB_ACCOUNT_IMAGE_FROM_AIO = 0;
  public static final int PUB_ACCOUNT_IMAGE_FROM_BIGIMAGE = 2;
  public static final int PUB_ACCOUNT_IMAGE_FROM_KANDIAN = 3;
  public static final int PUB_ACCOUNT_IMAGE_FROM_NATIVE_WEB = 4;
  public static final int PUB_ACCOUNT_IMAGE_FROM_SUBSCRIPT = 1;
  
  public abstract Object getHttpDownloader();
  
  public abstract URL makeURL(String paramString, int paramInt);
  
  public abstract URL makeURL(String paramString, int paramInt, Object paramObject);
  
  public abstract URL makeURL(String paramString, int paramInt, Object paramObject, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader
 * JD-Core Version:    0.7.0.1
 */