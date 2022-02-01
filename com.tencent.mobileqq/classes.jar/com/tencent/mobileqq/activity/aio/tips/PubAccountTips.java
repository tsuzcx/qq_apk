package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xc3.submsgtype0xc3.MsgBody;

public class PubAccountTips
  implements View.OnClickListener, TipsBarTask
{
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private PubAccountTips.PubAccountTipsMsg jdField_a_of_type_ComTencentMobileqqActivityAioTipsPubAccountTips$PubAccountTipsMsg;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public PubAccountTips(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, TipsManager paramTipsManager, Context paramContext, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public static PubAccountTips.PubAccountTipsMsg a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject;
    try
    {
      SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("push_campus_tips", 0);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PubAccountTips", 2, "getLastPATipsMsg getSharedPreferences error: ", localException);
      }
      localObject = null;
    }
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("selfuin_");
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_puin_");
      localStringBuilder.append(paramString);
      localStringBuilder.append("_msgdata");
      paramQQAppInterface = localObject.getString(localStringBuilder.toString(), null);
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        try
        {
          paramQQAppInterface = new PubAccountTips.PubAccountTipsMsg(new JSONObject(paramQQAppInterface));
          return paramQQAppInterface;
        }
        catch (JSONException paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PubAccountTips", 2, "getLastPATipsMsg JSONException:", paramQQAppInterface);
          }
        }
      }
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, PubAccountTips.PubAccountTipsMsg paramPubAccountTipsMsg, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshLocalTips. puin:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" ,pushData:");
      ((StringBuilder)localObject).append(paramString2);
      QLog.i("PubAccountTips", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramQQAppInterface.getApp().getSharedPreferences("push_campus_tips", 0);
    if (paramPubAccountTipsMsg != null)
    {
      paramQQAppInterface.getMessageFacade().b(paramString1, 1008, paramPubAccountTipsMsg.jdField_d_of_type_Long, true);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeMsgByUniseq. uniqSeqno:");
        localStringBuilder.append(paramPubAccountTipsMsg.jdField_d_of_type_Long);
        QLog.i("PubAccountTips", 2, localStringBuilder.toString());
      }
    }
    paramPubAccountTipsMsg = ((SharedPreferences)localObject).edit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("selfuin_");
    ((StringBuilder)localObject).append(paramQQAppInterface.getCurrentAccountUin());
    ((StringBuilder)localObject).append("_puin_");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("_msgdata");
    paramQQAppInterface = ((StringBuilder)localObject).toString();
    if (paramString2 != null) {
      paramPubAccountTipsMsg.putString(paramQQAppInterface, paramString2);
    } else {
      paramPubAccountTipsMsg.remove(paramQQAppInterface);
    }
    paramPubAccountTipsMsg.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject1 = new submsgtype0xc3.MsgBody();
    try
    {
      paramArrayOfByte = (submsgtype0xc3.MsgBody)((submsgtype0xc3.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
      boolean bool = QLog.isColorLevel();
      if (bool)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Parsing Msg0x210Sub0xc3 data. type:");
        ((StringBuilder)localObject1).append(paramArrayOfByte.uint32_type.get());
        ((StringBuilder)localObject1).append(", push_data:");
        ((StringBuilder)localObject1).append(paramArrayOfByte.bytes_push_data.get());
        ((StringBuilder)localObject1).append(", timestamp:");
        ((StringBuilder)localObject1).append(paramArrayOfByte.uint64_timestamp.get());
        QLog.d("PubAccountTips", 2, ((StringBuilder)localObject1).toString());
      }
      if ((paramArrayOfByte.uint32_type.has()) && (paramArrayOfByte.bytes_push_data.has()))
      {
        int i = paramArrayOfByte.uint32_type.get();
        if (i == 1) {
          try
          {
            paramArrayOfByte = new JSONObject(new String(paramArrayOfByte.bytes_push_data.get().toByteArray(), "UTF-8"));
            localObject1 = new PubAccountTips.PubAccountTipsMsg(paramArrayOfByte);
            if (((PubAccountTips.PubAccountTipsMsg)localObject1).a())
            {
              i = ((PubAccountTips.PubAccountTipsMsg)localObject1).jdField_b_of_type_Int;
              Object localObject2;
              Object localObject3;
              if (i == 1)
              {
                localObject2 = (MessageForStructing)MessageRecordFactory.a(-2011);
                localObject3 = paramQQAppInterface.getCurrentAccountUin();
                Object localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("");
                ((StringBuilder)localObject4).append(((PubAccountTips.PubAccountTipsMsg)localObject1).jdField_a_of_type_Long);
                Object localObject5 = ((StringBuilder)localObject4).toString();
                localObject4 = ((PubAccountTips.PubAccountTipsMsg)localObject1).jdField_a_of_type_JavaLangString;
                ((MessageForStructing)localObject2).init((String)localObject3, (String)localObject5, (String)localObject5, (String)localObject4, 0L, -2011, 1008, 0L);
                localObject5 = StructMsgFactory.a();
                ((AbsStructMsg)localObject5).mMsgBrief = ((String)localObject4);
                ((AbsStructMsg)localObject5).mMsgUrl = ((PubAccountTips.PubAccountTipsMsg)localObject1).jdField_c_of_type_JavaLangString;
                ((AbsStructMsg)localObject5).mMsgServiceID = 85;
                ((MessageForStructing)localObject2).structingMsg = ((AbsStructMsg)localObject5);
                ((MessageForStructing)localObject2).saveExtInfoToExtStr("public_account_msg_extra_info_type", "1");
                paramQQAppInterface.getMessageFacade().a((MessageRecord)localObject2, (String)localObject3, true, true, true, false);
                paramArrayOfByte.put("msg_seqno", ((MessageForStructing)localObject2).uniseq);
              }
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("Msg0x210Sub0xc3 .type:");
                ((StringBuilder)localObject2).append(((PubAccountTips.PubAccountTipsMsg)localObject1).jdField_a_of_type_Int);
                ((StringBuilder)localObject2).append(", push_data:");
                ((StringBuilder)localObject2).append(paramArrayOfByte.toString());
                QLog.d("PubAccountTips", 2, ((StringBuilder)localObject2).toString());
              }
              if (paramQQAppInterface.getApp().getSharedPreferences("push_campus_tips", 0) != null)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("");
                ((StringBuilder)localObject2).append(((PubAccountTips.PubAccountTipsMsg)localObject1).jdField_a_of_type_Long);
                localObject2 = a(paramQQAppInterface, ((StringBuilder)localObject2).toString());
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("");
                ((StringBuilder)localObject3).append(((PubAccountTips.PubAccountTipsMsg)localObject1).jdField_a_of_type_Long);
                a(paramQQAppInterface, ((StringBuilder)localObject3).toString(), (PubAccountTips.PubAccountTipsMsg)localObject2, paramArrayOfByte.toString());
                paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
                if (paramQQAppInterface != null)
                {
                  paramQQAppInterface.sendEmptyMessage(38);
                  return;
                }
              }
            }
          }
          catch (JSONException paramQQAppInterface)
          {
            paramQQAppInterface.printStackTrace();
            return;
          }
          catch (UnsupportedEncodingException paramQQAppInterface)
          {
            paramQQAppInterface.printStackTrace();
            return;
          }
        }
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public int a()
  {
    return 10;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559974, null);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsPubAccountTips$PubAccountTipsMsg;
    if (localObject != null)
    {
      if (((PubAccountTips.PubAccountTipsMsg)localObject).jdField_a_of_type_Int == 1) {
        paramVarArgs.setBackgroundResource(2131165911);
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsPubAccountTips$PubAccountTipsMsg.jdField_a_of_type_Int == 2) {
        paramVarArgs.setBackgroundResource(2131165912);
      }
      ((TextView)paramVarArgs.findViewById(2131362532)).setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsPubAccountTips$PubAccountTipsMsg.jdField_a_of_type_JavaLangString);
      localObject = (ImageView)paramVarArgs.findViewById(2131362528);
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsPubAccountTips$PubAccountTipsMsg.jdField_b_of_type_JavaLangString;
      if (!TextUtils.isEmpty(str)) {
        ((ImageView)localObject).setImageDrawable(URLDrawableHelper.getDrawable(str, null, null));
      } else {
        ((ImageView)localObject).setVisibility(8);
      }
    }
    paramVarArgs.setOnClickListener(this);
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    paramVarArgs = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    if ((paramVarArgs != null) && (paramVarArgs.a())) {
      if ((paramVarArgs.e >= 0) && (paramVarArgs.e < paramVarArgs.jdField_c_of_type_Int) && (!paramVarArgs.b()))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsPubAccountTips$PubAccountTipsMsg = paramVarArgs;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]))
        {
          QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(paramVarArgs.jdField_d_of_type_Int);
          ReportController.b(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "school", "school.aio.tips.show", 0, 0, localStringBuilder.toString(), "", "", "");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.w("PubAccountTips", 2, "onAIOEvent():ON_SHOW tips expired!");
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, paramVarArgs, null);
      }
    }
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 7;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1008)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsPubAccountTips$PubAccountTipsMsg;
      if ((localObject1 != null) && (!TextUtils.isEmpty(((PubAccountTips.PubAccountTipsMsg)localObject1).jdField_c_of_type_JavaLangString)))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("push_campus_tips", 0);
        if (localObject1 != null)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("selfuin_");
          ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          ((StringBuilder)localObject3).append("_puin_");
          ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject3).append("_msgdata");
          localObject3 = ((StringBuilder)localObject3).toString();
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("clickedTimes:");
            ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsPubAccountTips$PubAccountTipsMsg.e + 1);
            QLog.d("PubAccountTips", 2, ((StringBuilder)localObject4).toString());
          }
          Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsPubAccountTips$PubAccountTipsMsg;
          int i = ((PubAccountTips.PubAccountTipsMsg)localObject4).e + 1;
          ((PubAccountTips.PubAccountTipsMsg)localObject4).e = i;
          if (i >= this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsPubAccountTips$PubAccountTipsMsg.jdField_c_of_type_Int)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsPubAccountTips$PubAccountTipsMsg.jdField_a_of_type_Long);
            a((QQAppInterface)localObject1, ((StringBuilder)localObject3).toString(), this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsPubAccountTips$PubAccountTipsMsg, null);
            this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(28, 2000L);
          }
          else
          {
            localObject1 = ((SharedPreferences)localObject1).edit();
            try
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsPubAccountTips$PubAccountTipsMsg.jdField_a_of_type_OrgJsonJSONObject.put("clicked", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsPubAccountTips$PubAccountTipsMsg.e);
              ((SharedPreferences.Editor)localObject1).putString((String)localObject3, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsPubAccountTips$PubAccountTipsMsg.jdField_a_of_type_OrgJsonJSONObject.toString()).commit();
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
            }
          }
        }
        Object localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsPubAccountTips$PubAccountTipsMsg.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsPubAccountTips$PubAccountTipsMsg.jdField_d_of_type_Int);
        ReportController.b((AppRuntime)localObject2, "P_CliOper", "Vip_pay_mywallet", "", "school", "school.aio.tips.click", 0, 0, ((StringBuilder)localObject3).toString(), "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.PubAccountTips
 * JD-Core Version:    0.7.0.1
 */