package com.tencent.mobileqq.bless.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.HongbaoParams;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ThumbInfo;
import com.tencent.mobileqq.activity.shortvideo.SendTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bless.api.IBlessApi;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.shortvideo.ResultListener;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.video.AioVideoTransFileController;
import java.util.ArrayList;
import java.util.List;

public class BlessApiImpl
  implements IBlessApi
{
  public void clearEditingWordings(AppInterface paramAppInterface)
  {
    ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).c();
  }
  
  public void clearUinListToSend(AppInterface paramAppInterface)
  {
    ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).b();
  }
  
  public Object createShortVideoUploadInfo(Object paramObject1, Object paramObject2)
  {
    return ShortVideoBusiManager.a(paramObject1, (ShortVideoReq)paramObject2);
  }
  
  public int getAvailableSendCount(AppInterface paramAppInterface)
  {
    return ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).f();
  }
  
  public int getAvailableUinCount(AppInterface paramAppInterface)
  {
    return ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).d();
  }
  
  public String getBlessJsApiPlugin_ACTION_StringValue()
  {
    return "com.tencent.mobileqq.BlessJsApiPlugin";
  }
  
  public String getBlessJsApiPlugin_PARAM_BLESS_NUM_StringValue()
  {
    return "bless_num";
  }
  
  public String getBlessJsApiPlugin_PARAM_BLESS_TYPE_StringValue()
  {
    return "bless_type";
  }
  
  public String getBlessJsApiPlugin_PARAM_CALLBACK_StringValue()
  {
    return "callback";
  }
  
  public String getBlessJsApiPlugin_PARAM_PTV_FILE_PATH_StringValue()
  {
    return "ptv_file_path";
  }
  
  public String getBlessJsApiPlugin_PARAM_PTV_MD5_StringValue()
  {
    return "bless_ptv_md5";
  }
  
  public String getBlessJsApiPlugin_PARAM_PTV_NICK_StringValue()
  {
    return "bless_ptv_nick";
  }
  
  public String getBlessJsApiPlugin_PARAM_PTV_THUMB_PATH_StringValue()
  {
    return "ptv_thumb_path";
  }
  
  public String getBlessJsApiPlugin_PARAM_PTV_URL_StringValue()
  {
    return "bless_ptv_url";
  }
  
  public String getBlessJsApiPlugin_PARAM_PTV_UUID_StringValue()
  {
    return "bless_ptv_uuid";
  }
  
  public int getBlessManager_TYPE_PIC_Value()
  {
    return 3;
  }
  
  public int getBlessManager_TYPE_PTV_Value()
  {
    return 2;
  }
  
  public int getBlessManager_TYPE_TEXT_Value()
  {
    return 1;
  }
  
  public int getBlessManager_TYPE_UNKNOW_Value()
  {
    return 0;
  }
  
  public int getBlessManager_UPDATE_MSGTAB_NUM_Value()
  {
    return 10;
  }
  
  public Object getBlessReportParams(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    return ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).a(paramInt1, paramInt2);
  }
  
  public void getEncodeQualityParamForSendTask(Intent paramIntent)
  {
    SendTask.a(paramIntent);
  }
  
  public Object getPtvMessage(AppInterface paramAppInterface)
  {
    return ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).a();
  }
  
  public String getPtvUrlByUuid(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    return ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).a(paramString1, paramString2);
  }
  
  public int getSVBusiUtil_BUSI_TYPE_SHORTVIDEO_PTV_Value()
  {
    return 3;
  }
  
  public int getTotalSendLimit(AppInterface paramAppInterface)
  {
    return ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).e();
  }
  
  public int getTotalUinLimit(AppInterface paramAppInterface)
  {
    return ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).c();
  }
  
  public ArrayList<String> getUinListToSend(AppInterface paramAppInterface)
  {
    return ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).a();
  }
  
  public int getWebAvailableSendCount(AppInterface paramAppInterface)
  {
    return ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).k();
  }
  
  public int getWebAvailableUinCount(AppInterface paramAppInterface)
  {
    return ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).j();
  }
  
  public int getWebTotalSendLimit(AppInterface paramAppInterface)
  {
    return ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).h();
  }
  
  public int getWebTotalUinLimit(AppInterface paramAppInterface)
  {
    return ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).i();
  }
  
  public void gotoSplashActivity(Activity paramActivity, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, SplashActivity.class);
    localIntent.putExtra("tab_index", FrameControllerUtil.a);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra(MessageConstants.h, paramBoolean);
    localIntent.setFlags(67108864);
    paramActivity.startActivity(localIntent);
  }
  
  public boolean isSearchable(AppInterface paramAppInterface)
  {
    return ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).b();
  }
  
  public boolean isUinBlessed(AppInterface paramAppInterface, String paramString)
  {
    return ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).a(paramString);
  }
  
  public boolean isUinListToSendChangedOnMem(AppInterface paramAppInterface)
  {
    return ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).g();
  }
  
  public boolean isVideoSoLibLoaded()
  {
    return ShortVideoUtils.isVideoSoLibLoaded();
  }
  
  public boolean isWebUinSended(AppInterface paramAppInterface, String paramString)
  {
    return ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).b(paramString);
  }
  
  public void launchForShortVideoBusiManager(Object paramObject, AppInterface paramAppInterface)
  {
    ShortVideoBusiManager.a((ShortVideoReq)paramObject, (QQAppInterface)paramAppInterface);
  }
  
  public void loadShortVideoSo(AppInterface paramAppInterface)
  {
    ShortVideoUtils.loadShortVideoSo(paramAppInterface);
  }
  
  public void openWebBlessActivity(AppInterface paramAppInterface, Context paramContext)
  {
    ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).a(paramContext);
  }
  
  public void preConnect(AppInterface paramAppInterface)
  {
    paramAppInterface.getHwEngine().preConnect();
  }
  
  public void realStartEncode(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, Object paramObject)
  {
    paramContext = new EncodeVideoTask(paramContext, paramString3, paramBoolean, new EncodeVideoTask.ThumbInfo(paramString1, paramString2, null, 0, 0));
    paramContext.a((ResultListener)paramObject);
    paramContext.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[] { (Void)null });
  }
  
  public void reportSendResult(AppInterface paramAppInterface, ArrayList<String> paramArrayList, int paramInt)
  {
    ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).a(paramArrayList, paramInt);
  }
  
  public void saveSendWording(AppInterface paramAppInterface, String paramString)
  {
    ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).a(paramString);
  }
  
  public void saveUinListToSend(AppInterface paramAppInterface, List<String> paramList)
  {
    ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).a(paramList);
  }
  
  public void sendBlessMsg(AppInterface paramAppInterface, Object paramObject1, ArrayList<String> paramArrayList, Object paramObject2)
  {
    paramAppInterface = (QQAppInterface)paramAppInterface;
    paramAppInterface.getMessageFacade().a(paramAppInterface, (MessageRecord)paramObject1, paramArrayList, (ChatActivityFacade.HongbaoParams)paramObject2);
  }
  
  public void sendBlessTextMsg(AppInterface paramAppInterface, String paramString, ArrayList<String> paramArrayList, Object paramObject)
  {
    ChatActivityFacade.a((QQAppInterface)paramAppInterface, paramString, paramArrayList, (ChatActivityFacade.HongbaoParams)paramObject);
  }
  
  public void setCodecParam(int paramInt1, int paramInt2)
  {
    com.tencent.mobileqq.editor.composite.CodecParam.mRecordFrames = paramInt1;
    com.tencent.mobileqq.editor.composite.CodecParam.mRecordTime = paramInt2;
  }
  
  public void setPtvMessage(AppInterface paramAppInterface, Object paramObject)
  {
    ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).a((MessageForShortVideo)paramObject);
  }
  
  public void setUinListToSendChangedOnMen(AppInterface paramAppInterface, boolean paramBoolean)
  {
    ((BlessManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).a(paramBoolean);
  }
  
  public boolean stopSendingShortVideo(AppInterface paramAppInterface, String paramString, long paramLong)
  {
    return AioVideoTransFileController.d((QQAppInterface)paramAppInterface, paramString, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bless.api.impl.BlessApiImpl
 * JD-Core Version:    0.7.0.1
 */