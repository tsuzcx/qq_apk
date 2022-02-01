package com.tencent.mobileqq.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Typeface;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoCell;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.soso.location.data.SosoWifi;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.hotchat.LBS.Attribute;
import tencent.im.oidb.hotchat.LBS.Cell;
import tencent.im.oidb.hotchat.LBS.GPS;
import tencent.im.oidb.hotchat.LBS.LBSInfo;
import tencent.im.oidb.hotchat.LBS.Wifi;

public class HotChatHelper
{
  public static Dialog a(Activity paramActivity, View.OnClickListener paramOnClickListener)
  {
    paramActivity = new ReportDialog(paramActivity, 2131953338);
    paramActivity.setContentView(2131627471);
    Button localButton1 = (Button)paramActivity.findViewById(2131429764);
    Button localButton2 = (Button)paramActivity.findViewById(2131429782);
    localButton1.setOnClickListener(new HotChatHelper.1(paramActivity));
    paramActivity.setCanceledOnTouchOutside(true);
    localButton2.setOnClickListener(paramOnClickListener);
    paramActivity.show();
    return paramActivity;
  }
  
  public static Bitmap a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = new File(paramString);
      if (!paramString.exists()) {
        return null;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapManager.a(paramString.getAbsolutePath(), localOptions);
      int i = localOptions.outWidth;
      if (i > 150) {
        localOptions.inSampleSize = (i / 150);
      }
      localOptions.inJustDecodeBounds = false;
      paramString = BitmapManager.a(paramString.getAbsolutePath(), localOptions);
      return paramString;
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("HotChatHelper", 2, "makeShareBitmap", paramString);
        return null;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatHelper", 2, "makeShareBitmap", paramString);
      }
    }
    return null;
  }
  
  public static QQCustomDialog a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    int i = paramActivity.getRequestedOrientation();
    paramActivity.setRequestedOrientation(1);
    paramQQAppInterface = DialogUtil.a(paramActivity, 0, 2131625972, paramActivity.getString(2131890737), null, paramActivity.getString(2131891134), paramActivity.getString(2131890047), new HotChatHelper.2(paramActivity, paramQQAppInterface), new HotChatHelper.3(paramQQAppInterface));
    paramQQAppInterface.setOnDismissListener(new HotChatHelper.4(paramActivity, i));
    paramQQAppInterface.getBtnight().setTypeface(Typeface.DEFAULT_BOLD);
    paramQQAppInterface.setMessageCount(paramActivity.getString(2131890736));
    paramQQAppInterface.setPreviewImage(paramActivity.getResources().getDrawable(2130843603), true, 1);
    paramQQAppInterface.show();
    return paramQQAppInterface;
  }
  
  public static QQCustomDialog a(HotChatInfo paramHotChatInfo, DialogInterface.OnClickListener paramOnClickListener)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((paramHotChatInfo != null) && (localBaseActivity != null) && (!localBaseActivity.isFinishing()))
    {
      int i = localBaseActivity.getRequestedOrientation();
      localBaseActivity.setRequestedOrientation(1);
      paramHotChatInfo = DialogUtil.a(localBaseActivity, 230, localBaseActivity.getString(2131890733), localBaseActivity.getString(2131890732), 2131887648, 2131889053, paramOnClickListener, new HotChatHelper.5());
      paramOnClickListener = (TextView)paramHotChatInfo.findViewById(2131431876);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      paramOnClickListener.setLayoutParams(localLayoutParams);
      paramHotChatInfo.setOnDismissListener(new HotChatHelper.6(localBaseActivity, i));
      paramHotChatInfo.show();
      return paramHotChatInfo;
    }
    return null;
  }
  
  public static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://play.mobile.qq.com/play/mqqplay/hotchat/hotchat_share.html?_wv=1027&adtag=android&hotnamecode=");
    localStringBuilder.append(paramString);
    localStringBuilder.append("&newly_created=");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static LBS.LBSInfo a(boolean paramBoolean)
  {
    LBS.LBSInfo localLBSInfo = new LBS.LBSInfo();
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).reqRawLbsData(3600000L, ((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassSimpleName());
    Object localObject1 = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getRawSosoInfo();
    if ((localObject1 != null) && (((SosoLbsInfo)localObject1).mLocation != null))
    {
      Object localObject2 = new LBS.GPS();
      ((LBS.GPS)localObject2).latitude.set((int)(((SosoLbsInfo)localObject1).mLocation.mLat84 * 1000000.0D));
      ((LBS.GPS)localObject2).longitude.set((int)(((SosoLbsInfo)localObject1).mLocation.mLon84 * 1000000.0D));
      ((LBS.GPS)localObject2).altitude.set(-1);
      ((LBS.GPS)localObject2).coordinate.set(0);
      localLBSInfo.gps.set((MessageMicro)localObject2);
      Object localObject3;
      if (((SosoLbsInfo)localObject1).mWifis != null)
      {
        localObject2 = ((SosoLbsInfo)localObject1).mWifis.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SosoWifi)((Iterator)localObject2).next();
          LBS.Wifi localWifi = new LBS.Wifi();
          localWifi.mac.set(((SosoWifi)localObject3).mMac);
          localWifi.rssi.set(((SosoWifi)localObject3).mRssi);
          localLBSInfo.rpt_wifi.add(localWifi);
        }
      }
      if (((SosoLbsInfo)localObject1).mCells != null)
      {
        localObject1 = ((SosoLbsInfo)localObject1).mCells.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SosoCell)((Iterator)localObject1).next();
          localObject3 = new LBS.Cell();
          ((LBS.Cell)localObject3).mcc.set(((SosoCell)localObject2).mMcc);
          ((LBS.Cell)localObject3).mnc.set(((SosoCell)localObject2).mMnc);
          ((LBS.Cell)localObject3).lac.set(((SosoCell)localObject2).mLac);
          ((LBS.Cell)localObject3).cellid.set(((SosoCell)localObject2).mCellId);
          ((LBS.Cell)localObject3).rssi.set(((SosoCell)localObject2).mRss);
          localLBSInfo.rpt_cell.add((MessageMicro)localObject3);
        }
      }
      localObject1 = new LBS.Attribute();
      localObject2 = DeviceInfoUtil.b();
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((LBS.Attribute)localObject1).imei.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
      }
      localObject2 = DeviceInfoUtil.c();
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((LBS.Attribute)localObject1).imsi.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
      }
      localLBSInfo.attribute.set((MessageMicro)localObject1);
      return localLBSInfo;
    }
    return null;
  }
  
  public static LBS.Wifi a()
  {
    Object localObject1 = (WifiManager)BaseApplication.getContext().getApplicationContext().getSystemService("wifi");
    if (!((WifiManager)localObject1).isWifiEnabled()) {
      return null;
    }
    Object localObject2 = NetworkMonitor.getConnectionInfo((WifiManager)localObject1);
    localObject1 = HotChatManager.a((WifiInfo)localObject2);
    long l = SosoWifi.macToLong(((WifiInfo)localObject2).getBSSID());
    int i = ((WifiInfo)localObject2).getRssi();
    localObject2 = new LBS.Wifi();
    ((LBS.Wifi)localObject2).rssi.set(i);
    ((LBS.Wifi)localObject2).essid.set(ByteStringMicro.copyFrom(((String)localObject1).getBytes()));
    ((LBS.Wifi)localObject2).mac.set(l);
    return localObject2;
  }
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    paramString5 = new ShareActionSheetBuilder(paramBaseActivity);
    paramString5.setActionSheetTitle(paramBaseActivity.getString(2131916565));
    paramString5.setActionSheetItems(a(paramBaseActivity));
    paramString5.setItemClickListener(new HotChatHelper.7(paramString5, paramInt, paramQQAppInterface, paramBaseActivity, paramString1, paramString6, paramString3, paramString4, paramString7, paramString2, paramString8));
    try
    {
      paramString5.show();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel())
      {
        paramBaseActivity = new StringBuilder();
        paramBaseActivity.append("actionSheet.show exception=");
        paramBaseActivity.append(paramQQAppInterface);
        QLog.d("ShareActionSheet", 2, paramBaseActivity.toString());
      }
    }
  }
  
  static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    long l = System.currentTimeMillis();
    if (!TextUtils.isEmpty(paramString6)) {
      paramBaseActivity = a(paramString6);
    } else {
      paramBaseActivity = null;
    }
    paramString1 = paramBaseActivity;
    if (paramBaseActivity == null) {
      paramString1 = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130846923);
    }
    WXShareHelper.a().b(String.valueOf(l), paramString2, paramString1, paramString3, paramString5);
  }
  
  static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 69;
    } else {
      i = 65;
    }
    paramString4 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(i).a(paramString2).a("web", paramString4, paramString5, null, null).a(HardCodeUtil.a(2131903530), null).a();
    paramString5 = StructMsgElementFactory.a(2);
    paramString1 = paramString6;
    if (TextUtils.isEmpty(paramString6)) {
      paramString1 = "https://sqimg.qq.com/qq_product_operations/playqq/anonymous/image/reliao0714.png";
    }
    paramString5.a(paramString1, paramString2, paramString3, 0);
    paramString4.addItem(paramString5);
    paramString1 = new Intent();
    paramString1.putExtra("forward_type", -3);
    paramString1.putExtra("stuctmsg_bytes", paramString4.getBytes());
    ForwardBaseOption.a(paramBaseActivity, paramString1, 3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, HotChatInfo paramHotChatInfo)
  {
    if (paramHotChatInfo == null) {
      return;
    }
    if (paramHotChatInfo.state == 1)
    {
      a(paramQQAppInterface, paramHotChatInfo, paramQQAppInterface.getApp().getString(2131890730), true);
      return;
    }
    a(paramQQAppInterface, paramHotChatInfo, paramQQAppInterface.getApp().getString(2131890735), true);
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().g();
    RecentUser localRecentUser = localRecentUserProxy.b(paramHotChatInfo.troopUin, 1);
    if (localRecentUser != null) {
      localRecentUserProxy.a(localRecentUser);
    }
    if (paramHotChatInfo.state == 0)
    {
      paramHotChatInfo.state = 4;
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramQQAppInterface.update(paramHotChatInfo);
      paramQQAppInterface.close();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, HotChatInfo paramHotChatInfo, String paramString, boolean paramBoolean)
  {
    if (paramHotChatInfo != null)
    {
      if (paramHotChatInfo.isGameRoom) {
        return;
      }
      AddMessageHelper.a(paramQQAppInterface, paramHotChatInfo.troopUin, paramString, 1, paramBoolean, false);
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (paramMessageRecord.msgtype == -2000)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("");
      paramMessageRecord.saveExtInfoToExtStr("hotchat_flash_pic", localStringBuilder.toString());
    }
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFlashPicFlag,troopUin:");
      localStringBuilder.append(paramMessageRecord.frienduin);
      localStringBuilder.append(",isReaded:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",msgType:");
      localStringBuilder.append(paramMessageRecord.msgtype);
      QLog.d("Q.hotchat", 4, localStringBuilder.toString());
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && ((paramMessageRecord.msgtype == -2000) || (paramMessageRecord.msgtype == -2006)) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("hotchat_flash_pic")));
  }
  
  public static List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894171);
    localActionSheetItem.icon = 2130839221;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894185);
    localActionSheetItem.icon = 2130839222;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894192);
    localActionSheetItem.icon = 2130839225;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894174);
    localActionSheetItem.icon = 2130839219;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private static void b(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)paramBaseActivity.getAppRuntime();
    ArrayList localArrayList = new ArrayList();
    String str = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      str = "https://sqimg.qq.com/qq_product_operations/playqq/anonymous/image/reliao0714.png";
    }
    localArrayList.add(str);
    paramString5 = new Bundle();
    paramString5.putString("title", paramString1);
    paramString5.putString("desc", paramString3);
    paramString5.putLong("req_share_id", 0L);
    paramString5.putString("detail_url", paramString4);
    paramString5.putString("url", paramString4);
    paramString5.putStringArrayList("image_url", localArrayList);
    paramString1 = paramString2;
    if (paramString2.startsWith("邀请加入QQ热聊："))
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append(HardCodeUtil.a(2131903531));
      paramString1 = paramString1.toString();
    }
    paramString5.putString("troop_wording", paramString1);
    paramString5.putString("bizname", "JoinTroopLink");
    QZoneShareManager.jumpToQzoneShare(localQQAppInterface, paramBaseActivity, paramString5, null);
  }
  
  static void b(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    long l = System.currentTimeMillis();
    if (!TextUtils.isEmpty(paramString6)) {
      paramBaseActivity = a(paramString6);
    } else {
      paramBaseActivity = null;
    }
    paramString1 = paramBaseActivity;
    if (paramBaseActivity == null) {
      paramString1 = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130846923);
    }
    paramBaseActivity = paramString2;
    if (paramString2.startsWith("邀请加入QQ热聊："))
    {
      paramBaseActivity = new StringBuilder();
      paramBaseActivity.append(paramString2);
      paramBaseActivity.append(HardCodeUtil.a(2131903533));
      paramBaseActivity = paramBaseActivity.toString();
    }
    WXShareHelper.a().a(String.valueOf(l), paramBaseActivity, paramString1, paramString3, paramString5);
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    try
    {
      boolean bool = Boolean.valueOf(paramMessageRecord.getExtInfoFromExtStr("hotchat_flash_pic")).booleanValue();
      return bool;
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
    return false;
  }
  
  public static void c(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null) {
      paramMessageRecord.saveExtInfoToExtStr("hotchat_flash_pic", "true");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatHelper
 * JD-Core Version:    0.7.0.1
 */