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
  protected final float a;
  View.OnClickListener a;
  
  public DeviceSingleStructBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new DeviceSingleStructBuilder.1(this);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    paramQQAppInterface = new Intent();
    paramQQAppInterface.setAction("SmartDevice_clickOnDeviceList");
    BaseApplicationImpl.getApplication().sendBroadcast(paramQQAppInterface);
  }
  
  private void a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    if ((!FileUtils.fileExistsAndNotEmpty(paramMessageForDeviceSingleStruct.strMediaPath)) && (NetworkUtil.isMobileNetWork(CommonDataAdapter.a().a())))
    {
      String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692561);
      String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692563);
      FMDialogUtil.a(this.jdField_a_of_type_AndroidContentContext, str1, str2, new DeviceSingleStructBuilder.2(this, paramMessageForDeviceSingleStruct));
      return;
    }
    b(paramMessageForDeviceSingleStruct);
  }
  
  private void a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct, DeviceInfo paramDeviceInfo, String paramString)
  {
    Object localObject;
    if ((!paramMessageForDeviceSingleStruct.url.startsWith("http://")) && (!paramMessageForDeviceSingleStruct.url.startsWith("https://")))
    {
      paramMessageForDeviceSingleStruct = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForDeviceSingleStruct.url);
      if ((paramMessageForDeviceSingleStruct != null) && ("openLightApp".equals(paramMessageForDeviceSingleStruct.b)) && ("url".equals(paramMessageForDeviceSingleStruct.c)))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("param_meta_data", paramString);
        SmartDeviceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramDeviceInfo, paramMessageForDeviceSingleStruct.b("url_prefix"), (Bundle)localObject);
      }
    }
    else
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("url", paramMessageForDeviceSingleStruct.url);
      ((Intent)localObject).putExtra("device_info", paramDeviceInfo);
      ((Intent)localObject).putExtra("param_meta_data", paramString);
      SmartDevicePluginLoader.a().a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject, "com.tencent.device.lightapp.DeviceWebViewActivity", -1, null, SmartDevicePluginProxyActivity.class);
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
    int i = FileManagerUtil.a(FileUtil.a(paramMessageForDeviceSingleStruct.strMediaFileName));
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
    paramMessageForDeviceSingleStruct = new Intent(this.jdField_a_of_type_AndroidContentContext, FileBrowserActivity.class);
    paramMessageForDeviceSingleStruct.putExtra("fileinfo", (Parcelable)localObject1);
    localObject1 = new ArrayList();
    if (i == 0)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(((FileManagerEntity)localObject2).peerUin, ((FileManagerEntity)localObject2).peerType);
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
            if (FileManagerUtil.a(FileUtil.a(((MessageForDeviceSingleStruct)localObject3).strMediaFileName)) == 0) {
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
    ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramMessageForDeviceSingleStruct, 102);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout.setPadding(0, AIOUtils.b(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    DeviceSingleStructBuilder.Holder localHolder = (DeviceSingleStructBuilder.Holder)paramViewHolder;
    paramLinearLayout = null;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558802, null);
      localHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131377636));
      localHolder.c = ((TextView)paramViewHolder.findViewById(2131377635));
      localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewHolder.findViewById(2131377626));
      localHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewHolder.findViewById(2131380648));
      localHolder.d = ((TextView)paramViewHolder.findViewById(2131377621));
      localHolder.e = ((TextView)paramViewHolder.findViewById(2131377623));
    }
    paramView = paramLinearLayout;
    if ((localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForDeviceSingleStruct)) {
      paramView = (MessageForDeviceSingleStruct)paramMessageRecord;
    }
    if (paramView == null) {
      return paramViewHolder;
    }
    if ((paramView.strTitle != null) && (!TextUtils.isEmpty(paramView.strTitle)))
    {
      localHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramView.strTitle);
      localHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      localHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    long l;
    if (paramView.nAppearTime != 0L) {
      l = paramView.nAppearTime;
    } else {
      l = paramView.time;
    }
    if (l != 0L)
    {
      localHolder.c.setText(TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, l * 1000L));
      localHolder.c.setVisibility(0);
    }
    else
    {
      localHolder.c.setVisibility(8);
    }
    if ((paramView.strDigest != null) && (!TextUtils.isEmpty(paramView.strDigest)))
    {
      localHolder.d.setText(paramView.strDigest);
      localHolder.d.setVisibility(0);
    }
    else
    {
      localHolder.d.setVisibility(8);
    }
    if ((paramView.strGuideWords != null) && (!TextUtils.isEmpty(paramView.strGuideWords)))
    {
      localHolder.e.setText(paramView.strGuideWords);
      localHolder.e.setVisibility(0);
    }
    else
    {
      localHolder.e.setVisibility(8);
    }
    if (paramView.nDataType == 2) {
      localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    } else {
      localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    a(paramView, localHolder);
    if (!FileUtils.fileExistsAndNotEmpty(paramView.strCoverPath))
    {
      ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramView, paramViewHolder, this);
    }
    else if ((!TextUtils.isEmpty(paramView.faceRect)) && (!FileUtils.fileExistsAndNotEmpty(paramView.strMediaPath)))
    {
      paramMessageRecord = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      if (((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(paramView.senderuin)).isAdmin == 1) {
        paramMessageRecord.a().a(paramView);
      }
    }
    if ((!FileUtils.fileExistsAndNotEmpty(paramView.strMediaPath)) && (NetworkUtil.isWifiConnected(CommonDataAdapter.a().a())))
    {
      paramMessageRecord = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(paramView.senderuin));
      paramMessageRecord.a().a(paramView);
    }
    paramViewHolder.setTag(localHolder);
    paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
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
    if (paramInt != 2131365480)
    {
      if (paramInt != 2131371603) {
        return;
      }
      paramContext = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      paramContext.c(paramChatMessage);
      paramInt = 1;
      paramContext.f(true);
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
      paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("");
      paramChatMessage.append(paramInt);
      ReportController.b(paramContext, "CliOper", "", "", "0X800465F", "0X800465F", 0, 0, paramChatMessage.toString(), "", "", "");
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(View paramView, MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    DeviceSingleStructBuilder.Holder localHolder = (DeviceSingleStructBuilder.Holder)AIOUtils.a(paramView);
    if (localHolder == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceSingleStructBuilder", 2, "error get holder in updateview");
      }
      return;
    }
    paramView = null;
    if ((localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForDeviceSingleStruct)) {
      paramView = (MessageForDeviceSingleStruct)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
      k = ((WindowManager)CommonDataAdapter.a().a().getSystemService("window")).getDefaultDisplay().getWidth() - 156;
      j = (int)(this.jdField_a_of_type_Float * 150.0F);
      i = k;
      if (k <= 0) {
        i = j;
      }
      paramMessageForDeviceSingleStruct = DeviceMsgThumbDownloader.getUrl(paramMessageForDeviceSingleStruct.strMediaPath, i, j, paramMessageForDeviceSingleStruct.strCoverMD5);
      if (paramMessageForDeviceSingleStruct == null) {
        break label228;
      }
      paramMessageForDeviceSingleStruct = URLDrawable.getDrawable(paramMessageForDeviceSingleStruct);
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForDeviceSingleStruct);
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
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838021);
    return;
    if (FileUtils.fileExistsAndNotEmpty(paramMessageForDeviceSingleStruct.strCoverPath)) {}
    try
    {
      k = ((WindowManager)CommonDataAdapter.a().a().getSystemService("window")).getDefaultDisplay().getWidth() - 156;
      j = (int)(this.jdField_a_of_type_Float * 150.0F);
      i = k;
      if (k <= 0) {
        i = j;
      }
      paramMessageForDeviceSingleStruct = DeviceMsgThumbDownloader.getUrl(paramMessageForDeviceSingleStruct.strCoverPath, i, j, paramMessageForDeviceSingleStruct.strCoverMD5);
      if (paramMessageForDeviceSingleStruct == null) {
        break label228;
      }
      paramMessageForDeviceSingleStruct = URLDrawable.getDrawable(paramMessageForDeviceSingleStruct);
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForDeviceSingleStruct);
      return;
    }
    catch (Exception paramMessageForDeviceSingleStruct)
    {
      label207:
      break label207;
    }
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838021);
    return;
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838021);
    label228:
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131365480, this.jdField_a_of_type_AndroidContentContext.getString(2131690788), 2130838907);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    int j = 1;
    if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000))
    {
      i = 0;
    }
    else
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        i = j;
        if (localHotChatManager != null)
        {
          localHotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          i = j;
        }
      }
    }
    if ((i != 0) && (MultiMsgManager.a().a())) {
      paramView.a(2131371603, this.jdField_a_of_type_AndroidContentContext.getString(2131694356), 2130838922);
    }
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DeviceSingleStructBuilder
 * JD-Core Version:    0.7.0.1
 */