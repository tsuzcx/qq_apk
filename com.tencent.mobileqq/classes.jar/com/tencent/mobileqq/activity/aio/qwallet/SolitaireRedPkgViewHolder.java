package com.tencent.mobileqq.activity.aio.qwallet;

import android.text.TextUtils.TruncateAt;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.utils.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class SolitaireRedPkgViewHolder
  extends BaseViewHolder
{
  PasswdRedBagManager a;
  
  public SolitaireRedPkgViewHolder(QQAppInterface paramQQAppInterface, QWalletMsgHolder paramQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, CustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager = ((PasswdRedBagManager)paramQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER));
    if (a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.i = 0;; this.i = paramQQWalletBaseMsgElem.effectsId)
    {
      this.j = 2130847603;
      return;
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setTextColor(-8947849);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setText(IFBaseViewHolder.k);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setSingleLine(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setSelected(true);
    return false;
  }
  
  public void h()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId);
    if (localObject2 == null) {
      localObject2 = new JSONObject();
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject2).put("key_sub_channel", localQQWalletRedPacketMsg.body.subChannel);
        PasswdRedBagInfo.a((JSONObject)localObject2, localQQWalletRedPacketMsg.body.poemRule);
        if (localQQWalletRedPacketMsg.body.subChannel == 2)
        {
          String str1 = localQQWalletRedPacketMsg.elem.lastPinyin;
          localObject2 = new PasswdRedBagInfo(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, false, false, false, 4, str1, ((JSONObject)localObject2).toString());
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 4);
          if ((StringUtil.a(((PasswdRedBagInfo)localObject2).e)) || (StringUtil.a(((PasswdRedBagInfo)localObject2).e.trim()))) {
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.elem.title, localQQWalletRedPacketMsg.elem.lastPinyin, 0, localQQWalletRedPacketMsg.body.poemRule);
          }
          if (a((PasswdRedBagInfo)localObject2)) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.d.setVisibility(8);
          if (StringUtil.a(((PasswdRedBagInfo)localObject2).e)) {
            continue;
          }
          if (!((PasswdRedBagInfo)localObject2).b) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setText(IFBaseViewHolder.k);
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
        Object localObject1 = "";
        continue;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.d.setVisibility(0);
        continue;
        localObject1 = ((PasswdRedBagInfo)localObject2).e;
        String str2 = PasswdRedBagManager.a((String)localObject1);
        String str3 = PasswdRedBagManager.b((String)localObject1);
        if (!StringUtil.a(str2))
        {
          switch (localQQWalletRedPacketMsg.body.subChannel)
          {
          default: 
            localObject1 = HardCodeUtil.a(2131714163) + str2.trim() + " ";
            this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setText((CharSequence)localObject1);
            if (((PasswdRedBagInfo)localObject2).a() != 3) {
              continue;
            }
            localObject1 = str3;
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject1, ((PasswdRedBagInfo)localObject2).a);
            return;
          case 2: 
            localObject1 = HardCodeUtil.a(2131714162) + str2.trim() + " ";
            break;
          }
          localObject1 = "接龙红包：" + str3;
          continue;
          localObject1 = str2;
          continue;
          if (((PasswdRedBagInfo)localObject2).b)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setText(IFBaseViewHolder.k);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.SolitaireRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */