package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DevSingleStructMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct.DeviceSingleStructItemCallback;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.DeviceMsgThumbDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class DeviceSingleStructBuilder
  extends AbstractChatItemBuilder
  implements MessageForDeviceSingleStruct.DeviceSingleStructItemCallback
{
  protected final float e;
  View.OnClickListener f = new DeviceSingleStructBuilder.1(this);
  
  public DeviceSingleStructBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.e = paramContext.getResources().getDisplayMetrics().density;
    paramQQAppInterface = new Intent();
    paramQQAppInterface.setAction("SmartDevice_clickOnDeviceList");
    BaseApplicationImpl.getApplication().sendBroadcast(paramQQAppInterface);
  }
  
  private void a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    if ((!FileUtils.fileExistsAndNotEmpty(paramMessageForDeviceSingleStruct.strMediaPath)) && (NetworkUtil.isMobileNetWork(CommonDataAdapter.a().b())))
    {
      String str1 = this.c.getString(2131889584);
      String str2 = this.c.getString(2131889586);
      FMDialogUtil.a(this.c, str1, str2, new DeviceSingleStructBuilder.2(this, paramMessageForDeviceSingleStruct));
      return;
    }
    b(paramMessageForDeviceSingleStruct);
  }
  
  private void a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct, DeviceInfo paramDeviceInfo, String paramString)
  {
    Object localObject;
    if ((!paramMessageForDeviceSingleStruct.url.startsWith("http://")) && (!paramMessageForDeviceSingleStruct.url.startsWith("https://")))
    {
      paramMessageForDeviceSingleStruct = JumpParser.a(this.a, this.c, paramMessageForDeviceSingleStruct.url);
      if ((paramMessageForDeviceSingleStruct != null) && ("openLightApp".equals(paramMessageForDeviceSingleStruct.d)) && ("url".equals(paramMessageForDeviceSingleStruct.e)))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("param_meta_data", paramString);
        SmartDeviceUtil.a(this.a, this.c, paramDeviceInfo, paramMessageForDeviceSingleStruct.b("url_prefix"), (Bundle)localObject);
      }
    }
    else
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("url", paramMessageForDeviceSingleStruct.url);
      ((Intent)localObject).putExtra("device_info", paramDeviceInfo);
      ((Intent)localObject).putExtra("param_meta_data", paramString);
      SmartDevicePluginLoader.a().a((Activity)this.c, this.a, this.a.getAccount(), (Intent)localObject, "com.tencent.device.lightapp.DeviceWebViewActivity", -1, null, SmartDevicePluginProxyActivity.class);
    }
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      int i = new JSONObject(paramString).optInt("reg");
      return i == 1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private void b(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    int i = FileManagerUtil.c(FileUtil.a(paramMessageForDeviceSingleStruct.strMediaFileName));
    Object localObject2 = FileManagerUtil.a(paramMessageForDeviceSingleStruct);
    Object localObject1 = new ForwardFileInfo();
    ((ForwardFileInfo)localObject1).b(10009);
    ((ForwardFileInfo)localObject1).d(8);
    ((ForwardFileInfo)localObject1).b(((FileManagerEntity)localObject2).nSessionId);
    ((ForwardFileInfo)localObject1).d(((FileManagerEntity)localObject2).fileName);
    ((ForwardFileInfo)localObject1).c(((FileManagerEntity)localObject2).uniseq);
    ((ForwardFileInfo)localObject1).d(((FileManagerEntity)localObject2).fileSize);
    ((ForwardFileInfo)localObject1).f(((FileManagerEntity)localObject2).strThumbPath);
    ((ForwardFileInfo)localObject1).a(((FileManagerEntity)localObject2).getFilePath());
    paramMessageForDeviceSingleStruct = new Intent(this.c, FileBrowserActivity.class);
    paramMessageForDeviceSingleStruct.putExtra("fileinfo", (Parcelable)localObject1);
    localObject1 = new ArrayList();
    if (i == 0)
    {
      localObject2 = this.a.getMessageFacade().o(((FileManagerEntity)localObject2).peerUin, ((FileManagerEntity)localObject2).peerType);
      if (localObject2 != null)
      {
        if (((List)localObject2).size() == 0) {
          return;
        }
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (ChatMessage)((Iterator)localObject2).next();
          if ((localObject3 instanceof MessageForDeviceSingleStruct))
          {
            localObject3 = (MessageForDeviceSingleStruct)localObject3;
            if (FileManagerUtil.c(FileUtil.a(((MessageForDeviceSingleStruct)localObject3).strMediaFileName)) == 0) {
              ((ArrayList)localObject1).add(String.valueOf(FileManagerUtil.a((MessageForDeviceSingleStruct)localObject3).nSessionId));
            }
          }
        }
        paramMessageForDeviceSingleStruct.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject1);
      }
    }
    else if (i == 1)
    {
      ((ArrayList)localObject1).add(String.valueOf(((FileManagerEntity)localObject2).nSessionId));
      paramMessageForDeviceSingleStruct.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject1);
    }
    ((Activity)this.c).startActivityForResult(paramMessageForDeviceSingleStruct, 102);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout.setPadding(0, AIOUtils.b(11.0F, this.c.getResources()), 0, 0);
    DeviceSingleStructBuilder.Holder localHolder = (DeviceSingleStructBuilder.Holder)paramViewHolder;
    paramLinearLayout = null;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.c).inflate(2131624422, null);
      localHolder.d = ((TextView)paramViewHolder.findViewById(2131446045));
      localHolder.e = ((TextView)paramViewHolder.findViewById(2131446044));
      localHolder.f = ((ImageView)paramViewHolder.findViewById(2131446035));
      localHolder.g = ((ImageView)paramViewHolder.findViewById(2131449607));
      localHolder.h = ((TextView)paramViewHolder.findViewById(2131446030));
      localHolder.i = ((TextView)paramViewHolder.findViewById(2131446032));
    }
    paramView = paramLinearLayout;
    if ((localHolder.q instanceof MessageForDeviceSingleStruct)) {
      paramView = (MessageForDeviceSingleStruct)paramMessageRecord;
    }
    if (paramView == null) {
      return paramViewHolder;
    }
    if ((paramView.strTitle != null) && (!TextUtils.isEmpty(paramView.strTitle)))
    {
      localHolder.d.setText(paramView.strTitle);
      localHolder.d.setVisibility(0);
    }
    else
    {
      localHolder.d.setVisibility(8);
    }
    long l;
    if (paramView.nAppearTime != 0L) {
      l = paramView.nAppearTime;
    } else {
      l = paramView.time;
    }
    if (l != 0L)
    {
      localHolder.e.setText(TimeFormatterUtils.a(this.c, l * 1000L));
      localHolder.e.setVisibility(0);
    }
    else
    {
      localHolder.e.setVisibility(8);
    }
    if ((paramView.strDigest != null) && (!TextUtils.isEmpty(paramView.strDigest)))
    {
      localHolder.h.setText(paramView.strDigest);
      localHolder.h.setVisibility(0);
    }
    else
    {
      localHolder.h.setVisibility(8);
    }
    if ((paramView.strGuideWords != null) && (!TextUtils.isEmpty(paramView.strGuideWords)))
    {
      localHolder.i.setText(paramView.strGuideWords);
      localHolder.i.setVisibility(0);
    }
    else
    {
      localHolder.i.setVisibility(8);
    }
    if (paramView.nDataType == 2) {
      localHolder.g.setVisibility(0);
    } else {
      localHolder.g.setVisibility(8);
    }
    a(paramView, localHolder);
    if (!FileUtils.fileExistsAndNotEmpty(paramView.strCoverPath))
    {
      ((DeviceMsgHandle)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).c().a(paramView, paramViewHolder, this);
    }
    else if ((!TextUtils.isEmpty(paramView.faceRect)) && (!FileUtils.fileExistsAndNotEmpty(paramView.strMediaPath)))
    {
      paramMessageRecord = (DeviceMsgHandle)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      if (((SmartDeviceProxyMgr)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).g(Long.parseLong(paramView.senderuin)).isAdmin == 1) {
        paramMessageRecord.c().b(paramView);
      }
    }
    if ((!FileUtils.fileExistsAndNotEmpty(paramView.strMediaPath)) && (NetworkUtil.isWifiConnected(CommonDataAdapter.a().b())))
    {
      paramMessageRecord = (DeviceMsgHandle)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      ((SmartDeviceProxyMgr)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).g(Long.parseLong(paramView.senderuin));
      paramMessageRecord.c().b(paramView);
    }
    paramViewHolder.setTag(localHolder);
    paramViewHolder.setOnClickListener(this.f);
    paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
    return paramViewHolder;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new DeviceSingleStructBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131431695)
    {
      if (paramInt != 2131439015) {
        return;
      }
      paramContext = ((BaseActivity)this.c).getChatFragment().k();
      paramContext.c(paramChatMessage);
      paramInt = 1;
      paramContext.i(true);
      if (paramChatMessage == null) {
        return;
      }
      if (paramChatMessage.istroop != 0) {
        if (paramChatMessage.istroop == 3000) {
          paramInt = 2;
        } else if (paramChatMessage.istroop == 1) {
          paramInt = 3;
        } else {
          paramInt = 4;
        }
      }
      paramContext = this.a;
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("");
      paramChatMessage.append(paramInt);
      ReportController.b(paramContext, "CliOper", "", "", "0X800465F", "0X800465F", 0, 0, paramChatMessage.toString(), "", "", "");
      return;
    }
    ChatActivityFacade.b(this.c, this.a, paramChatMessage);
  }
  
  public void a(View paramView, MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    DeviceSingleStructBuilder.Holder localHolder = (DeviceSingleStructBuilder.Holder)AIOUtils.b(paramView);
    if (localHolder == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceSingleStructBuilder", 2, "error get holder in updateview");
      }
      return;
    }
    paramView = null;
    if ((localHolder.q instanceof MessageForDeviceSingleStruct)) {
      paramView = (MessageForDeviceSingleStruct)localHolder.q;
    }
    if (paramView == null) {
      return;
    }
    if ((paramView.uniseq == paramMessageForDeviceSingleStruct.uniseq) && (paramView.nCoverSessionID == paramMessageForDeviceSingleStruct.nCoverSessionID))
    {
      paramView.strCoverPath = paramMessageForDeviceSingleStruct.strCoverPath;
      a(paramView, localHolder);
    }
    if ((paramView.uniseq == paramMessageForDeviceSingleStruct.uniseq) && (paramView.nMediaSessionID == paramMessageForDeviceSingleStruct.nMediaSessionID)) {
      paramView.strMediaPath = paramMessageForDeviceSingleStruct.strMediaPath;
    }
  }
  
  protected void a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct, DeviceSingleStructBuilder.Holder paramHolder)
  {
    if ((paramMessageForDeviceSingleStruct.nDataType == 1) && (FileUtils.fileExistsAndNotEmpty(paramMessageForDeviceSingleStruct.strMediaPath))) {}
    try
    {
      k = ((WindowManager)CommonDataAdapter.a().b().getSystemService("window")).getDefaultDisplay().getWidth() - 156;
      j = (int)(this.e * 150.0F);
      i = k;
      if (k <= 0) {
        i = j;
      }
      paramMessageForDeviceSingleStruct = DeviceMsgThumbDownloader.getUrl(paramMessageForDeviceSingleStruct.strMediaPath, i, j, paramMessageForDeviceSingleStruct.strCoverMD5);
      if (paramMessageForDeviceSingleStruct == null) {
        break label228;
      }
      paramMessageForDeviceSingleStruct = URLDrawable.getDrawable(paramMessageForDeviceSingleStruct);
      paramHolder.f.setImageDrawable(paramMessageForDeviceSingleStruct);
      return;
    }
    catch (Exception paramMessageForDeviceSingleStruct)
    {
      int k;
      int j;
      int i;
      label102:
      break label102;
    }
    paramHolder.f.setImageResource(2130838063);
    return;
    if (FileUtils.fileExistsAndNotEmpty(paramMessageForDeviceSingleStruct.strCoverPath)) {}
    try
    {
      k = ((WindowManager)CommonDataAdapter.a().b().getSystemService("window")).getDefaultDisplay().getWidth() - 156;
      j = (int)(this.e * 150.0F);
      i = k;
      if (k <= 0) {
        i = j;
      }
      paramMessageForDeviceSingleStruct = DeviceMsgThumbDownloader.getUrl(paramMessageForDeviceSingleStruct.strCoverPath, i, j, paramMessageForDeviceSingleStruct.strCoverMD5);
      if (paramMessageForDeviceSingleStruct == null) {
        break label228;
      }
      paramMessageForDeviceSingleStruct = URLDrawable.getDrawable(paramMessageForDeviceSingleStruct);
      paramHolder.f.setImageDrawable(paramMessageForDeviceSingleStruct);
      return;
    }
    catch (Exception paramMessageForDeviceSingleStruct)
    {
      label207:
      break label207;
    }
    paramHolder.f.setImageResource(2130838063);
    return;
    paramHolder.f.setImageResource(2130838063);
    label228:
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131431695, this.c.getString(2131887718), 2130839061);
    int i = this.d.a;
    int j = 1;
    if ((i != 0) && (this.d.a != 1) && (this.d.a != 3000))
    {
      i = 0;
    }
    else
    {
      i = j;
      if (this.d.a == 1)
      {
        HotChatManager localHotChatManager = (HotChatManager)this.a.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        i = j;
        if (localHotChatManager != null)
        {
          localHotChatManager.b(this.d.b);
          i = j;
        }
      }
    }
    if ((i != 0) && (MultiMsgManager.a().b())) {
      paramView.a(2131439015, this.c.getString(2131892030), 2130839076);
    }
    return paramView.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DeviceSingleStructBuilder
 * JD-Core Version:    0.7.0.1
 */