package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct.DeviceSingleStructItemCallback;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.DeviceMsgThumbDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import usw;
import usy;

public class DeviceSingleStructBuilder
  extends AbstractChatItemBuilder
  implements MessageForDeviceSingleStruct.DeviceSingleStructItemCallback
{
  protected final float a;
  View.OnClickListener a;
  
  public DeviceSingleStructBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new usw(this);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    paramQQAppInterface = new Intent();
    paramQQAppInterface.setAction("SmartDevice_clickOnDeviceList");
    BaseApplicationImpl.getApplication().sendBroadcast(paramQQAppInterface);
  }
  
  private void a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
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
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((FileManagerEntity)localObject2).peerUin, ((FileManagerEntity)localObject2).peerType);
      if ((localObject2 == null) || (((List)localObject2).size() == 0)) {
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
    for (;;)
    {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramMessageForDeviceSingleStruct, 102);
      return;
      if (i == 1)
      {
        ((ArrayList)localObject1).add(String.valueOf(((FileManagerEntity)localObject2).nSessionId));
        paramMessageForDeviceSingleStruct.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject1);
      }
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      int i = new JSONObject(paramString).optInt("reg");
      if (i == 1) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
      return false;
    }
    catch (Exception paramString) {}
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout.setPadding(0, AIOUtils.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    paramLinearLayout = (usy)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968745, null);
      paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131363522));
      paramLinearLayout.c = ((TextView)paramViewHolder.findViewById(2131363523));
      paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewHolder.findViewById(2131363525));
      paramLinearLayout.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewHolder.findViewById(2131363526));
      paramLinearLayout.d = ((TextView)paramViewHolder.findViewById(2131363527));
      paramLinearLayout.e = ((TextView)paramViewHolder.findViewById(2131363529));
    }
    if ((paramLinearLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForDeviceSingleStruct)) {}
    for (paramMessageRecord = (MessageForDeviceSingleStruct)paramMessageRecord;; paramMessageRecord = null)
    {
      if (paramMessageRecord == null) {
        return paramViewHolder;
      }
      long l;
      if ((paramMessageRecord.strTitle != null) && (!TextUtils.isEmpty(paramMessageRecord.strTitle)))
      {
        paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord.strTitle);
        paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (paramMessageRecord.nAppearTime == 0L) {
          break label489;
        }
        l = paramMessageRecord.nAppearTime;
        label212:
        if (l == 0L) {
          break label498;
        }
        paramLinearLayout.c.setText(TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, l * 1000L));
        paramLinearLayout.c.setVisibility(0);
        label249:
        if ((paramMessageRecord.strDigest == null) || (TextUtils.isEmpty(paramMessageRecord.strDigest))) {
          break label511;
        }
        paramLinearLayout.d.setText(paramMessageRecord.strDigest);
        paramLinearLayout.d.setVisibility(0);
        label287:
        if ((paramMessageRecord.strGuideWords == null) || (TextUtils.isEmpty(paramMessageRecord.strGuideWords))) {
          break label524;
        }
        paramLinearLayout.e.setText(paramMessageRecord.strGuideWords);
        paramLinearLayout.e.setVisibility(0);
        label325:
        if (paramMessageRecord.nDataType != 2) {
          break label537;
        }
        paramLinearLayout.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        label342:
        a(paramMessageRecord, paramLinearLayout);
        if (FileUtils.b(paramMessageRecord.strCoverPath)) {
          break label550;
        }
        ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramMessageRecord, paramViewHolder, this);
      }
      for (;;)
      {
        if ((!FileUtils.b(paramMessageRecord.strMediaPath)) && (NetworkUtil.h(CommonDataAdapter.a().a())))
        {
          paramView = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
          ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(paramMessageRecord.senderuin));
          paramView.a().a(paramMessageRecord);
        }
        paramViewHolder.setTag(paramLinearLayout);
        paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
        return paramViewHolder;
        paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        label489:
        l = paramMessageRecord.time;
        break label212;
        label498:
        paramLinearLayout.c.setVisibility(8);
        break label249;
        label511:
        paramLinearLayout.d.setVisibility(8);
        break label287;
        label524:
        paramLinearLayout.e.setVisibility(8);
        break label325;
        label537:
        paramLinearLayout.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label342;
        label550:
        if ((!TextUtils.isEmpty(paramMessageRecord.faceRect)) && (!FileUtils.b(paramMessageRecord.strMediaPath)))
        {
          paramView = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
          if (((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(paramMessageRecord.senderuin)).isAdmin == 1) {
            paramView.a().a(paramMessageRecord);
          }
        }
      }
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new usy(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      paramContext = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      paramContext.g(paramChatMessage);
      paramContext.g(true);
    } while (paramChatMessage == null);
    if (paramChatMessage.istroop == 0) {
      paramInt = 1;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800465F", "0X800465F", 0, 0, "" + paramInt, "", "", "");
      return;
      if (paramChatMessage.istroop == 3000) {
        paramInt = 2;
      } else if (paramChatMessage.istroop == 1) {
        paramInt = 3;
      } else {
        paramInt = 4;
      }
    }
  }
  
  public void a(View paramView, MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    usy localusy = (usy)AIOUtils.a(paramView);
    if (localusy == null) {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceSingleStructBuilder", 2, "error get holder in updateview");
      }
    }
    do
    {
      do
      {
        return;
        paramView = null;
        if ((localusy.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForDeviceSingleStruct)) {
          paramView = (MessageForDeviceSingleStruct)localusy.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        }
      } while (paramView == null);
      if ((paramView.uniseq == paramMessageForDeviceSingleStruct.uniseq) && (paramView.nCoverSessionID == paramMessageForDeviceSingleStruct.nCoverSessionID))
      {
        paramView.strCoverPath = paramMessageForDeviceSingleStruct.strCoverPath;
        a(paramView, localusy);
      }
    } while ((paramView.uniseq != paramMessageForDeviceSingleStruct.uniseq) || (paramView.nMediaSessionID != paramMessageForDeviceSingleStruct.nMediaSessionID));
    paramView.strMediaPath = paramMessageForDeviceSingleStruct.strMediaPath;
  }
  
  protected void a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct, usy paramusy)
  {
    if ((paramMessageForDeviceSingleStruct.nDataType == 1) && (FileUtils.b(paramMessageForDeviceSingleStruct.strMediaPath))) {}
    for (;;)
    {
      int k;
      int j;
      int i;
      try
      {
        k = ((WindowManager)CommonDataAdapter.a().a().getSystemService("window")).getDefaultDisplay().getWidth() - 156;
        j = (int)(this.jdField_a_of_type_Float * 150.0F);
        i = k;
        if (k <= 0) {
          i = j;
        }
        paramMessageForDeviceSingleStruct = DeviceMsgThumbDownloader.a(paramMessageForDeviceSingleStruct.strMediaPath, i, j, paramMessageForDeviceSingleStruct.strCoverMD5);
        if (paramMessageForDeviceSingleStruct != null)
        {
          paramMessageForDeviceSingleStruct = URLDrawable.getDrawable(paramMessageForDeviceSingleStruct);
          paramusy.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForDeviceSingleStruct);
        }
        return;
      }
      catch (Exception paramMessageForDeviceSingleStruct)
      {
        paramusy.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837613);
        return;
      }
      if (FileUtils.b(paramMessageForDeviceSingleStruct.strCoverPath)) {
        try
        {
          k = ((WindowManager)CommonDataAdapter.a().a().getSystemService("window")).getDefaultDisplay().getWidth() - 156;
          j = (int)(this.jdField_a_of_type_Float * 150.0F);
          i = k;
          if (k <= 0) {
            i = j;
          }
          paramMessageForDeviceSingleStruct = DeviceMsgThumbDownloader.a(paramMessageForDeviceSingleStruct.strCoverPath, i, j, paramMessageForDeviceSingleStruct.strCoverMD5);
          if (paramMessageForDeviceSingleStruct != null)
          {
            paramMessageForDeviceSingleStruct = URLDrawable.getDrawable(paramMessageForDeviceSingleStruct);
            paramusy.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForDeviceSingleStruct);
            return;
          }
        }
        catch (Exception paramMessageForDeviceSingleStruct)
        {
          paramusy.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837613);
          return;
        }
      }
    }
    paramusy.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837613);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131375336, this.jdField_a_of_type_AndroidContentContext.getString(2131433621), 2130838305);
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
        if ((localHotChatManager == null) || (!localHotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
      }
      i = 1;
    }
    if ((i != 0) && (MultiMsgManager.a().a())) {
      paramView.a(2131375346, this.jdField_a_of_type_AndroidContentContext.getString(2131433744), 2130838316);
    }
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DeviceSingleStructBuilder
 * JD-Core Version:    0.7.0.1
 */