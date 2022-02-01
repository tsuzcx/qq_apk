package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.FunBtnUI;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.miniaio.MiniChatMsgProxy;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.jubao.JubaoApiPlugin;
import com.tencent.mobileqq.jubao.JubaoIPCServer;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseChatpieHelper
{
  private int jdField_a_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public BaseChatpieHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
  }
  
  public static List<ChatMessage> a(List<ChatMessage> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null)
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("filterTargetUinMsgList size list == null, targetUin=");
        paramList.append(paramString);
        QLog.d("BaseChatpieHelper", 2, paramList.toString());
      }
      return localArrayList;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("filterTargetUinMsgList size ");
      ((StringBuilder)localObject).append(paramList.size());
      ((StringBuilder)localObject).append(", targetUin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("BaseChatpieHelper", 2, ((StringBuilder)localObject).toString());
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (ChatMessage)paramList.next();
      if (paramString.equals(((ChatMessage)localObject).senderuin)) {
        localArrayList.add(localObject);
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("filterTargetUinMsgList targetList ");
      paramList.append(localArrayList.size());
      paramList.append(", targetUin=");
      paramList.append(paramString);
      QLog.w("BaseChatpieHelper", 2, paramList.toString());
    }
    return localArrayList;
  }
  
  public static void a(BaseSessionInfo paramBaseSessionInfo, EditTextUI paramEditTextUI, FunBtnUI paramFunBtnUI, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w("BaseChatpieHelper", 2, "exitMsgFilterMode ");
    }
    paramBaseSessionInfo.l = false;
    paramBaseSessionInfo.i = null;
    if (paramBoolean) {
      paramEditTextUI.a("");
    }
    paramFunBtnUI.a(HardCodeUtil.a(2131701175));
  }
  
  public static void a(SessionInfo paramSessionInfo, EditText paramEditText, Button paramButton, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w("BaseChatpieHelper", 2, "exitMsgFilterMode ");
    }
    paramSessionInfo.l = false;
    paramSessionInfo.i = null;
    if (paramBoolean) {
      paramEditText.setText("");
    }
    paramButton.setText(HardCodeUtil.a(2131701175));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, XEditTextEx paramXEditTextEx, boolean paramBoolean)
  {
    int i = VasUtil.a(paramQQAppInterface).getVipStatus().getPrivilegeFlags(null);
    if ((i & 0x4) != 0) {
      i = PttItemBuilder.a(paramQQAppInterface, "SVIP_MaxPtt");
    } else if ((i & 0x2) != 0) {
      i = PttItemBuilder.a(paramQQAppInterface, "VIP_MaxPtt");
    } else {
      i = 120;
    }
    if (paramXEditTextEx.getInputExtras(true).getInt("Channels") != 1)
    {
      paramQQAppInterface = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).getRecorderParam();
      paramXEditTextEx.getInputExtras(true).putBoolean("DoesSupportDirectlyAudio", paramBoolean ^ true);
      paramXEditTextEx.getInputExtras(true).putInt("Channels", 1);
      paramXEditTextEx.getInputExtras(true).putInt("SampleRate", paramQQAppInterface.jdField_a_of_type_Int);
      paramXEditTextEx.getInputExtras(true).putInt("TimeLength", i);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sougouptt params : support = ");
        localStringBuilder.append(paramBoolean ^ true);
        localStringBuilder.append("sample = ");
        localStringBuilder.append(paramQQAppInterface.jdField_a_of_type_Int);
        localStringBuilder.append(" max = ");
        localStringBuilder.append(i);
        QLog.d("BaseChatpieHelper", 2, localStringBuilder.toString());
      }
      paramXEditTextEx.a = paramQQAppInterface;
    }
  }
  
  public static boolean a(SessionInfo paramSessionInfo)
  {
    return false;
  }
  
  public static boolean a(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt)
  {
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (ShortVideoUtils.isVideoSoLibLoaded()) {
      return true;
    }
    ShortVideoUtils.loadShortVideoSo(paramQQAppInterface);
    return ShortVideoUtils.isVideoSoLibLoaded();
  }
  
  public void a()
  {
    MiniChatMsgProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    ThreadManager.post(new BaseChatpieHelper.1(this, paramInt2, paramInt1, paramString), 2, null, false);
  }
  
  public void a(Activity paramActivity, Intent paramIntent)
  {
    ArrayList localArrayList = (ArrayList)MultiMsgManager.a().a();
    JubaoIPCServer.a().a(localArrayList);
    String str = JubaoApiPlugin.a(localArrayList);
    paramIntent.putExtra("chatuin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    paramIntent.putExtra("chattype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    paramIntent.putExtra("msgs", str);
    paramActivity.setResult(-1, paramIntent);
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("select msg size = ");
      paramActivity.append(localArrayList.size());
      QLog.d("jubaoApiPlugin", 2, paramActivity.toString());
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public void b()
  {
    MiniChatMsgProxy.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) && (!MiniChatMsgProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatpieHelper", 2, "uploadPreviewPhoto");
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ChatActivity.uploadPreviewPhoto:request=");
    ((StringBuilder)localObject).append(paramIntent.getIntExtra(AlbumConstants.h, -1));
    ImageUtil.a(-1L, i, true, "image_send_prepare", ((StringBuilder)localObject).toString());
    localObject = paramIntent.getExtras();
    if (localObject != null)
    {
      if (((Bundle)localObject).getBoolean("deleteImage", false))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(true, false);
        return;
      }
      i = paramIntent.getIntExtra(AlbumConstants.h, -1);
      if ((i == 2) || (i == 1))
      {
        paramIntent = paramIntent.getParcelableArrayListExtra("imageInfos");
        if ((paramIntent != null) && (!paramIntent.isEmpty()))
        {
          if (paramIntent.size() == 1)
          {
            if (i == 1)
            {
              a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c, 1, "");
              return;
            }
            a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c, 2, "");
            return;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(paramIntent.size());
          a(i, 4, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper
 * JD-Core Version:    0.7.0.1
 */