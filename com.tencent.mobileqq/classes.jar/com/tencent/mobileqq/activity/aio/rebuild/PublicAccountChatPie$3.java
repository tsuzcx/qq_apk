package com.tencent.mobileqq.activity.aio.rebuild;

import aegy;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import awul;
import awyc;
import awye;
import awzo;
import baip;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nfp;
import nfw;
import nfz;
import ngh;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import yof;

public class PublicAccountChatPie$3
  implements Runnable
{
  public PublicAccountChatPie$3(aegy paramaegy) {}
  
  public void run()
  {
    if (this.this$0.ad) {}
    ngh localngh;
    do
    {
      return;
      this.this$0.ad = true;
      localngh = (ngh)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    } while ((localObject1 == null) || (((List)localObject1).isEmpty()) || (localngh == null));
    Object localObject1 = (ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1);
    Object localObject2 = ((ChatMessage)localObject1).getExtInfoFromExtStr("public_account_msg_id");
    if ("1".equals(((ChatMessage)localObject1).getExtInfoFromExtStr("is_AdArrive_Msg")))
    {
      localObject2 = new nfz();
      ((nfz)localObject2).jdField_a_of_type_Int = 2;
      localObject2 = nfw.a((nfz)localObject2, (MessageRecord)localObject1);
      ((nfw)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(139)).a((nfz)localObject2, null);
      if ((localObject1 instanceof MessageForStructing))
      {
        localObject1 = ((MessageForStructing)localObject1).structingMsg;
        if ((localObject1 instanceof StructMsgForGeneralShare))
        {
          localObject1 = ((StructMsgForGeneralShare)localObject1).mStructMsgItemLists;
          if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            localObject1 = ((List)localObject1).iterator();
            for (;;)
            {
              if (((Iterator)localObject1).hasNext())
              {
                localObject2 = (awul)((Iterator)localObject1).next();
                if ((localObject2 instanceof awyc))
                {
                  localObject2 = ((awyc)localObject2).a;
                  if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
                    continue;
                  }
                  localObject2 = ((ArrayList)localObject2).iterator();
                  if (!((Iterator)localObject2).hasNext()) {
                    continue;
                  }
                  awul localawul = (awul)((Iterator)localObject2).next();
                  if (!(localawul instanceof awzo)) {
                    break;
                  }
                  yof.a(1, 2, nfp.a(localawul));
                  continue;
                }
                if ((localObject2 instanceof awye)) {
                  yof.a(1, 2, nfp.a((awye)localObject2));
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      int i = this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("jump_from", 4);
      if (i != 2) {
        break;
      }
      localngh.a(134243865, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, null, null, i, false);
      return;
      if ((localObject1 instanceof MessageForArkApp))
      {
        try
        {
          localObject1 = ((MessageForArkApp)localObject1).ark_app_message;
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((ArkAppMessage)localObject1).metaList;
          if (baip.a((String)localObject1)) {
            continue;
          }
          localObject2 = new JSONObject((String)localObject1).optJSONObject("gdt");
          localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo();
          ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info.aid.set(Long.parseLong(((JSONObject)localObject2).optString("aid")));
          localObject2 = ((JSONObject)localObject2).optJSONObject("thirdparty_monitor_urls");
          if (localObject2 == null) {
            continue;
          }
          ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.thirdparty_monitor_urls.api_click_monitor_url.set(ngh.a(((JSONObject)localObject2).optJSONArray("api_click_monitor_url")));
          ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.thirdparty_monitor_urls.api_exposure_monitor_url.set(ngh.a(((JSONObject)localObject2).optJSONArray("api_exposure_monitor_url")));
          yof.a(1, 2, (qq_ad_get.QQAdGetRsp.AdInfo)localObject1);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        continue;
        if ((localException instanceof MessageForArkApp)) {
          localngh.a(134243863, localException.senderuin, (String)localObject2, null, null, 0L, false);
        } else {
          localngh.a(134243857, localException.senderuin, (String)localObject2, null, null, 0L, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.3
 * JD-Core Version:    0.7.0.1
 */