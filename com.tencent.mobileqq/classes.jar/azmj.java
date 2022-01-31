import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class azmj
{
  public int a;
  public azmk a;
  public String a;
  public azmk b = new azmk();
  public azmk c = new azmk();
  public azmk d = new azmk();
  public azmk e = new azmk();
  public azmk f = new azmk();
  public azmk g = new azmk();
  public azmk h = new azmk();
  public azmk i = new azmk();
  public azmk j = new azmk();
  public azmk k = new azmk();
  public azmk l = new azmk();
  public azmk m = new azmk();
  public azmk n = new azmk();
  public azmk o = new azmk();
  public azmk p = new azmk();
  public azmk q = new azmk();
  public azmk r = new azmk();
  public azmk s = new azmk();
  public azmk t = new azmk();
  public azmk u = new azmk();
  public azmk v = new azmk();
  public azmk w = new azmk();
  public azmk x = new azmk();
  
  public azmj()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Azmk = new azmk();
    a();
  }
  
  public azmj(azmj paramazmj)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Azmk = new azmk();
    if (paramazmj != null)
    {
      this.f.a(paramazmj.f);
      this.jdField_a_of_type_Azmk.a(paramazmj.jdField_a_of_type_Azmk);
      this.b.a(paramazmj.b);
      this.c.a(paramazmj.c);
      this.e.a(paramazmj.e);
      this.d.a(paramazmj.d);
      this.g.a(paramazmj.g);
      this.h.a(paramazmj.h);
      this.i.a(paramazmj.i);
      this.j.a(paramazmj.j);
      this.k.a(paramazmj.k);
      this.l.a(paramazmj.l);
      this.m.a(paramazmj.m);
      this.n.a(paramazmj.n);
      this.o.a(paramazmj.o);
      this.p.a(paramazmj.p);
      this.q.a(paramazmj.q);
      this.r.a(paramazmj.r);
      this.s.a(paramazmj.s);
      this.t.a(paramazmj.t);
      this.u.a(paramazmj.u);
      this.v.a(paramazmj.v);
      this.w.a(paramazmj.w);
      this.x.a(paramazmj.x);
      return;
    }
    a();
  }
  
  public static Object a(QQAppInterface paramQQAppInterface, String paramString, azmj paramazmj, Object paramObject, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    askq localaskq = (askq)paramQQAppInterface.getManager(37);
    if (paramBoolean) {
      switch (paramazmj.a(paramQQAppInterface, paramBoolean, paramString))
      {
      case 15: 
      case 25: 
      case 26: 
      case 28: 
      default: 
        paramQQAppInterface = null;
      case 17: 
      case 16: 
      case 10: 
      case 11: 
      case 24: 
      case 14: 
      case 27: 
      case 13: 
      case 9: 
      case 5: 
      case 7: 
      case 8: 
      case 18: 
      case 22: 
      case 3: 
      case 2: 
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return paramQQAppInterface;
                    if ((paramObject instanceof ahqr))
                    {
                      paramQQAppInterface = (ahqr)paramObject;
                      paramQQAppInterface.jdField_a_of_type_Azmk.a(paramazmj.c);
                      localaskq.a(paramString, 17, paramazmj.c.a, "", 0, null);
                      return paramQQAppInterface;
                    }
                    paramQQAppInterface = new ahqr(BaseApplication.getContext());
                    paramQQAppInterface.a(paramMessageRecord.senderuin);
                    paramQQAppInterface.jdField_a_of_type_Azmk = new azmk(paramazmj.c);
                    localaskq.a(paramString, 17, paramazmj.c.a, "", 0, null);
                    return paramQQAppInterface;
                    if ((paramObject instanceof ahqj))
                    {
                      paramObject = (ahqj)paramObject;
                      paramQQAppInterface = paramObject;
                    }
                    for (;;)
                    {
                      paramObject.jdField_a_of_type_Azmk.a(paramazmj.b);
                      localaskq.a(paramString, 100, paramazmj.b.a, "", 0, null);
                      return paramQQAppInterface;
                      paramQQAppInterface = new ahqj(BaseApplication.getContext());
                      if ((paramObject instanceof ahqr))
                      {
                        paramMessageRecord = paramQQAppInterface;
                        paramQQAppInterface = paramObject;
                        paramObject = paramMessageRecord;
                      }
                      else
                      {
                        paramObject = paramQQAppInterface;
                      }
                    }
                    if ((paramObject instanceof ahqd))
                    {
                      paramQQAppInterface = (ahqd)paramObject;
                      paramQQAppInterface.jdField_a_of_type_Azmk.a(paramazmj.d);
                      localaskq.a(paramString, 11, paramazmj.d.a, "", 0, null);
                      return paramQQAppInterface;
                    }
                    paramQQAppInterface = new ahqd(BaseApplication.getContext());
                    paramQQAppInterface.jdField_a_of_type_Azmk = new azmk(paramazmj.d);
                    localaskq.a(paramString, 11, paramazmj.d.a, "", 0, null);
                    return paramQQAppInterface;
                    localaskq.a(paramString, 102, paramazmj.q.b, "", 0, paramMessageRecord);
                    if ((paramObject instanceof ahql))
                    {
                      paramQQAppInterface = (ahql)paramObject;
                      paramQQAppInterface.jdField_a_of_type_Azmk.a(paramazmj.q);
                      return paramQQAppInterface;
                    }
                    paramQQAppInterface = new ahql(BaseApplication.getContext(), false);
                    paramQQAppInterface.jdField_a_of_type_Azmk = new azmk(paramazmj.q);
                    return paramQQAppInterface;
                    if (!(paramObject instanceof ahqa)) {
                      break;
                    }
                    paramObject = (ahqa)paramObject;
                    paramQQAppInterface = paramObject;
                  } while (!paramObject.jdField_a_of_type_Azmk.a(paramazmj.jdField_a_of_type_Azmk));
                  localaskq.a(paramString, 23, paramazmj.jdField_a_of_type_Azmk.b, "", 0, null);
                  return paramObject;
                  paramQQAppInterface = new ahqa(BaseApplication.getContext());
                  paramQQAppInterface.a(paramMessageRecord.senderuin);
                  paramQQAppInterface.jdField_a_of_type_Azmk = new azmk(paramazmj.jdField_a_of_type_Azmk);
                  localaskq.a(paramString, 23, paramazmj.jdField_a_of_type_Azmk.b, "", 0, null);
                  return paramQQAppInterface;
                  if (paramMessageRecord == null) {
                    return null;
                  }
                  paramBoolean = aszn.a(paramMessageRecord);
                  if ((paramMessageRecord.msgtype != -2035) && (paramMessageRecord.msgtype != -2038) && (!paramBoolean)) {
                    return null;
                  }
                  int i1;
                  if (paramBoolean)
                  {
                    i1 = aszn.a((MessageForStructing)paramMessageRecord);
                    if ((paramObject instanceof ahqo))
                    {
                      paramQQAppInterface = (ahqo)paramObject;
                      paramQQAppInterface.jdField_a_of_type_Azmk.a(paramazmj.h);
                      localaskq.a(paramString, 26, paramazmj.h.b, "", i1, null);
                      return paramQQAppInterface;
                    }
                    paramQQAppInterface = new ahqo(BaseApplication.getContext());
                    paramQQAppInterface.jdField_a_of_type_Azmk = new azmk(paramazmj.h);
                    localaskq.a(paramString, 26, paramazmj.h.b, "", i1, null);
                    return paramQQAppInterface;
                  }
                  if ((paramMessageRecord instanceof MessageForDeliverGiftTips))
                  {
                    paramMessageRecord = (MessageForDeliverGiftTips)paramMessageRecord;
                    i1 = 1;
                    i2 = 1;
                    if (!(paramObject instanceof ahqo)) {
                      break label968;
                    }
                    paramQQAppInterface = (ahqo)paramObject;
                    i1 = i2;
                    if (paramQQAppInterface.jdField_a_of_type_Boolean)
                    {
                      i1 = i2;
                      if (!paramMessageRecord.isToAll()) {
                        i1 = 0;
                      }
                    }
                    i2 = i1;
                    paramObject = paramQQAppInterface;
                    if (!paramQQAppInterface.jdField_a_of_type_Boolean)
                    {
                      paramQQAppInterface.jdField_a_of_type_Azmk.a(paramazmj.h);
                      localaskq.a(paramString, 26, paramazmj.h.b, "", paramMessageRecord.giftCount, null);
                      paramObject = paramQQAppInterface;
                    }
                  }
                  for (int i2 = i1;; i2 = i1)
                  {
                    paramQQAppInterface = paramObject;
                    if (i2 == 0) {
                      break;
                    }
                    paramQQAppInterface = paramObject;
                    if (TextUtils.isEmpty(paramMessageRecord.remindBrief)) {
                      break;
                    }
                    paramQQAppInterface = paramMessageRecord.remindBrief.split("#");
                    paramObject.jdField_a_of_type_JavaLangString = ("[" + paramQQAppInterface[0] + "]");
                    return paramObject;
                    axqw.b(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "Troop_gift", "MsgBizType.TYPE_TROOP_RECEIVED_FLOWSER_MSG, MessageRecord cast to GiftTips", 0, -1, paramMessageRecord.getClass().getName(), "", "", "");
                    return null;
                    paramObject = new ahqo(BaseApplication.getContext(), paramMessageRecord.isToAll());
                    paramObject.jdField_a_of_type_Azmk = new azmk(paramazmj.h);
                    localaskq.a(paramString, 26, paramazmj.h.b, "", paramMessageRecord.giftCount, null);
                  }
                  if ((paramObject instanceof ahpz))
                  {
                    paramQQAppInterface = (ahpz)paramObject;
                    paramObject = paramQQAppInterface;
                    if (paramQQAppInterface.jdField_a_of_type_Azmk.a(paramazmj.f))
                    {
                      localaskq.a(paramString, 14, paramazmj.f.b, "", 0, null);
                      paramObject = paramQQAppInterface;
                    }
                  }
                  for (;;)
                  {
                    paramQQAppInterface = paramObject;
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.d(azmj.class.getSimpleName() + ".troop.special_msg.at_all_msg", 2, "updateMsgInfo");
                    return paramObject;
                    paramObject = new ahpz(BaseApplication.getContext());
                    paramObject.a(paramMessageRecord.senderuin);
                    paramObject.jdField_a_of_type_Azmk = new azmk(paramazmj.f);
                    localaskq.a(paramString, 14, paramazmj.f.b, "", 0, null);
                  }
                  return null;
                  if (!(paramObject instanceof bhxj)) {
                    break;
                  }
                  paramObject = (bhxj)paramObject;
                  paramQQAppInterface = paramObject;
                } while (!paramObject.jdField_a_of_type_Azmk.a(paramazmj.g));
                localaskq.a(paramString, 6, paramazmj.g.b, "", 0, null);
                return paramObject;
                paramQQAppInterface = new bhxj(BaseApplication.getContext());
                paramQQAppInterface.jdField_a_of_type_Azmk = new azmk(paramazmj.g);
                localaskq.a(paramString, 6, paramazmj.g.b, "", 0, null);
                return paramQQAppInterface;
                if (paramMessageRecord == null) {
                  return null;
                }
                paramBoolean = aszn.a(paramMessageRecord);
                if ((paramMessageRecord.msgtype != -2035) && (paramMessageRecord.msgtype != -2038) && (!paramBoolean)) {
                  return null;
                }
                if (paramBoolean)
                {
                  if ((paramObject instanceof ahqh))
                  {
                    paramQQAppInterface = (ahqh)paramObject;
                    paramQQAppInterface.jdField_a_of_type_Azmk.a(paramazmj.i);
                    return paramQQAppInterface;
                  }
                  paramQQAppInterface = new ahqh(BaseApplication.getContext());
                  paramQQAppInterface.jdField_a_of_type_Azmk = new azmk(paramazmj.i);
                  return paramQQAppInterface;
                }
                if ((paramMessageRecord instanceof MessageForDeliverGiftTips))
                {
                  paramMessageRecord = (MessageForDeliverGiftTips)paramMessageRecord;
                  if (!(paramObject instanceof ahqh)) {
                    break label1525;
                  }
                  paramString = (ahqh)paramObject;
                  paramString.jdField_a_of_type_Azmk.a(paramazmj.i);
                }
                for (;;)
                {
                  if (!TextUtils.isEmpty(paramMessageRecord.remindBrief))
                  {
                    paramazmj = paramMessageRecord.remindBrief.split("#");
                    if (paramazmj.length > 1) {
                      paramString.jdField_a_of_type_JavaLangString = ("[" + paramazmj[1] + "]");
                    }
                  }
                  paramQQAppInterface = (bagr)paramQQAppInterface.getManager(223);
                  if (!paramQQAppInterface.a(false)) {
                    break;
                  }
                  return null;
                  axqw.b(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "Troop_gift", "MsgBizType.TYPE_TROOP_HAS_GIFT_IN_TROOP, MessageRecord cast to GiftTips error", 0, -1, paramMessageRecord.getClass().getName(), "", "", "");
                  return null;
                  paramString = new ahqh(BaseApplication.getContext());
                  paramString.jdField_a_of_type_Azmk = new azmk(paramazmj.i);
                }
                paramQQAppInterface.jdField_a_of_type_Int = 1;
                return paramString;
                if ((paramObject instanceof ahqm))
                {
                  paramQQAppInterface = (ahqm)paramObject;
                  paramQQAppInterface.jdField_a_of_type_Azmk.a(paramazmj.j);
                  return paramQQAppInterface;
                }
                paramQQAppInterface = new ahqm(BaseApplication.getContext());
                paramQQAppInterface.jdField_a_of_type_Azmk = new azmk(paramazmj.j);
                return paramQQAppInterface;
                if (!(paramObject instanceof ahqe)) {
                  break;
                }
                paramObject = (ahqe)paramObject;
                paramQQAppInterface = paramObject;
              } while (!paramObject.jdField_a_of_type_Azmk.a(paramazmj.k));
              localaskq.a(paramString, 18, paramazmj.k.b, "", 0, null);
              return paramObject;
              paramQQAppInterface = new ahqe(BaseApplication.getContext());
              paramQQAppInterface.jdField_a_of_type_Azmk = new azmk(paramazmj.k);
              localaskq.a(paramString, 18, paramazmj.k.b, "", 0, null);
              return paramQQAppInterface;
              if (!(paramObject instanceof ahqp)) {
                break;
              }
              paramObject = (ahqp)paramObject;
              paramQQAppInterface = paramObject;
            } while (!paramObject.jdField_a_of_type_Azmk.a(paramazmj.l));
            localaskq.a(paramString, 22, paramazmj.l.b, "", 0, null);
            return paramObject;
            paramQQAppInterface = new ahqp(BaseApplication.getContext());
            paramQQAppInterface.jdField_a_of_type_Azmk = new azmk(paramazmj.l);
            localaskq.a(paramString, 22, paramazmj.l.b, "", 0, null);
            return paramQQAppInterface;
            if ((!(paramObject instanceof ahqk)) || (((ahqk)paramObject).c != 1)) {
              break;
            }
            paramObject = (ahqk)paramObject;
            paramQQAppInterface = paramObject;
          } while (!paramObject.jdField_a_of_type_Azmk.a(paramazmj.n));
          localaskq.a(paramString, 4, paramazmj.n.b, "", 0, null);
          return paramObject;
          paramQQAppInterface = new ahqk(BaseApplication.getContext(), 1);
          paramQQAppInterface.jdField_a_of_type_Azmk = new azmk(paramazmj.n);
          localaskq.a(paramString, 4, paramazmj.n.b, "", 0, null);
          return paramQQAppInterface;
          if ((!(paramObject instanceof ahqk)) || (((ahqk)paramObject).c != 0)) {
            break;
          }
          paramObject = (ahqk)paramObject;
          paramQQAppInterface = paramObject;
        } while (!paramObject.jdField_a_of_type_Azmk.a(paramazmj.o));
        localaskq.a(paramString, 3, paramazmj.o.b, "", 0, null);
        return paramObject;
        paramQQAppInterface = new ahqk(BaseApplication.getContext(), 0);
        paramQQAppInterface.jdField_a_of_type_Azmk = new azmk(paramazmj.o);
        localaskq.a(paramString, 3, paramazmj.o.b, "", 0, null);
        return paramQQAppInterface;
      case 21: 
        label968:
        label1525:
        if ((StructMsgForGeneralShare)axuy.a(paramMessageRecord.msgData) == null)
        {
          if (!QLog.isColorLevel()) {
            break label3660;
          }
          QLog.d("MessageInfo", 2, "updateMsgInfo():calendarMsg getStructMsg is null");
          paramMessageRecord = "";
        }
        break;
      }
    }
    for (;;)
    {
      label2052:
      if ((paramObject instanceof ahqc))
      {
        paramQQAppInterface = (ahqc)paramObject;
        paramObject = paramQQAppInterface;
        if (paramQQAppInterface.jdField_a_of_type_Azmk.a(paramazmj.m))
        {
          localaskq.a(paramString, 21, paramazmj.m.b, "", 0, null);
          paramObject = paramQQAppInterface;
        }
      }
      for (;;)
      {
        paramQQAppInterface = paramObject;
        if (TextUtils.isEmpty(paramMessageRecord)) {
          break;
        }
        paramObject.jdField_a_of_type_JavaLangString = ("[" + paramMessageRecord + "]");
        return paramObject;
        paramMessageRecord = StructMsgForGeneralShare.remindBrief;
        break label2052;
        paramObject = new ahqc(BaseApplication.getContext());
        paramObject.jdField_a_of_type_Azmk = new azmk(paramazmj.m);
        localaskq.a(paramString, 21, paramazmj.m.b, "", 0, null);
      }
      paramQQAppInterface = new ahql(BaseApplication.getContext(), false);
      paramQQAppInterface.c = 1;
      return paramQQAppInterface;
      if ((paramObject instanceof ahqi))
      {
        paramObject = (ahqi)paramObject;
        paramQQAppInterface = paramObject;
        if (!paramObject.jdField_a_of_type_Azmk.a(paramazmj.r)) {
          break;
        }
        localaskq.a(paramString, 5, paramazmj.r.b, "", 0, null);
        return paramObject;
      }
      paramQQAppInterface = new ahqi(BaseApplication.getContext());
      paramQQAppInterface.jdField_a_of_type_Azmk = new azmk(paramazmj.r);
      localaskq.a(paramString, 5, paramazmj.r.b, "", 0, null);
      return paramQQAppInterface;
      if ((paramObject instanceof ahqg))
      {
        paramObject = (ahqg)paramObject;
        paramQQAppInterface = paramObject;
        if (!paramObject.jdField_a_of_type_Azmk.a(paramazmj.s)) {
          break;
        }
        localaskq.a(paramString, 19, paramazmj.s.b, "", 0, null);
        return paramObject;
      }
      paramQQAppInterface = new ahqg(BaseApplication.getContext());
      paramQQAppInterface.jdField_a_of_type_Azmk = new azmk(paramazmj.s);
      localaskq.a(paramString, 19, paramazmj.s.b, "", 0, null);
      return paramQQAppInterface;
      if ((paramObject instanceof ahqn))
      {
        paramObject = (ahqn)paramObject;
        paramQQAppInterface = paramObject;
        if (!paramObject.jdField_a_of_type_Azmk.a(paramazmj.u)) {
          break;
        }
        localaskq.a(paramString, 13, paramazmj.u.b, "", 0, null);
        return paramObject;
      }
      paramQQAppInterface = new ahqn(BaseApplication.getContext());
      paramQQAppInterface.jdField_a_of_type_Azmk = new azmk(paramazmj.u);
      localaskq.a(paramString, 13, paramazmj.u.b, "", 0, null);
      return paramQQAppInterface;
      return new ahqf(BaseApplication.getContext());
      paramQQAppInterface = null;
      if ((paramMessageRecord instanceof MessageForArkApp)) {
        paramQQAppInterface = aluc.a((MessageForArkApp)paramMessageRecord);
      }
      long l1;
      long l2;
      if ((paramObject instanceof ahpw))
      {
        paramObject = (ahpw)paramObject;
        if (paramQQAppInterface != null) {
          paramObject.a(paramQQAppInterface);
        }
        if (paramObject.jdField_a_of_type_Azmk.a(paramazmj.w))
        {
          localaskq.a(paramString, 20, paramazmj.w.b, "", 0, null);
          return paramObject;
        }
        paramQQAppInterface = paramObject;
        if (paramazmj.w == null) {
          break;
        }
        l1 = paramazmj.w.a;
        l2 = paramazmj.w.b;
        if (l1 != -1L)
        {
          paramObject.jdField_a_of_type_Azmk.a = l1;
          paramObject.jdField_a_of_type_Azmk.b = l2;
        }
        localaskq.a(paramString, 20, paramazmj.w.b, "", 0, null);
        return paramObject;
      }
      paramObject = BaseApplication.getContext();
      if (paramQQAppInterface != null) {}
      for (;;)
      {
        paramQQAppInterface = new ahpw(paramObject, paramQQAppInterface);
        paramQQAppInterface.jdField_a_of_type_Azmk = new azmk(paramazmj.w);
        localaskq.a(paramString, 20, paramazmj.w.b, "", 0, null);
        return paramQQAppInterface;
        paramQQAppInterface = "";
      }
      if ((paramObject instanceof ahqq))
      {
        paramObject = (ahqq)paramObject;
        paramQQAppInterface = paramObject;
        if (!paramObject.jdField_a_of_type_Azmk.a(paramazmj.x)) {
          break;
        }
        localaskq.a(paramString, 101, paramazmj.x.b, "", 0, null);
        return paramObject;
      }
      paramQQAppInterface = new ahqq(BaseApplication.getContext());
      paramQQAppInterface.jdField_a_of_type_Azmk = new azmk(paramazmj.x);
      localaskq.a(paramString, 101, paramazmj.x.b, "", 0, null);
      return paramQQAppInterface;
      String str2 = paramString + "&" + 3000;
      String str1 = "0";
      switch (paramazmj.a())
      {
      default: 
        paramString = null;
        paramObject = str1;
      }
      for (;;)
      {
        paramQQAppInterface = paramString;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MessageInfo_At_Me_DISC", 2, "MessageInfo update:" + paramObject);
        return paramString;
        if ((paramObject instanceof ahpz))
        {
          paramQQAppInterface = (ahpz)paramObject;
          paramObject = str1;
          paramString = paramQQAppInterface;
          if (paramQQAppInterface.jdField_a_of_type_Azmk.a(paramazmj.f))
          {
            localaskq.a(str2, 14, paramazmj.f.b, "", 0, null);
            paramObject = "AT_ALL_update";
            paramString = paramQQAppInterface;
          }
        }
        else
        {
          paramString = new ahpz(BaseApplication.getContext());
          paramString.a(paramMessageRecord.senderuin);
          paramString.jdField_a_of_type_Azmk = new azmk(paramazmj.f);
          localaskq.a(str2, 14, paramazmj.f.b, "", 0, null);
          paramObject = "AT_ALL_add";
          continue;
          if ((paramObject instanceof ahqa))
          {
            paramQQAppInterface = (ahqa)paramObject;
            paramObject = str1;
            paramString = paramQQAppInterface;
            if (paramQQAppInterface.jdField_a_of_type_Azmk.a(paramazmj.jdField_a_of_type_Azmk))
            {
              localaskq.a(str2, 23, paramazmj.jdField_a_of_type_Azmk.b, "", 0, null);
              paramObject = "AT_ME_update";
              paramString = paramQQAppInterface;
            }
          }
          else
          {
            paramString = new ahqa(BaseApplication.getContext());
            paramString.a(paramMessageRecord.senderuin);
            paramString.jdField_a_of_type_Azmk = new azmk(paramazmj.jdField_a_of_type_Azmk);
            localaskq.a(str2, 23, paramazmj.jdField_a_of_type_Azmk.b, "", 0, null);
            paramObject = "AT_ME_ADD";
            continue;
            if ((paramObject instanceof ahqn))
            {
              paramQQAppInterface = (ahqn)paramObject;
              paramObject = str1;
              paramString = paramQQAppInterface;
              if (paramQQAppInterface.jdField_a_of_type_Azmk.a(paramazmj.u))
              {
                localaskq.a(str2, 13, paramazmj.u.b, "", 0, null);
                paramObject = "receipt_update";
                paramString = paramQQAppInterface;
              }
            }
            else
            {
              paramString = new ahqn(BaseApplication.getContext());
              paramString.jdField_a_of_type_Azmk = new azmk(paramazmj.u);
              localaskq.a(str2, 13, paramazmj.u.b, "", 0, null);
              paramObject = "receipt_add";
              continue;
              paramQQAppInterface = null;
              if ((paramMessageRecord instanceof MessageForArkApp)) {
                paramQQAppInterface = aluc.a((MessageForArkApp)paramMessageRecord);
              }
              if ((paramObject instanceof ahpw))
              {
                paramMessageRecord = (ahpw)paramObject;
                if (paramQQAppInterface != null) {
                  paramMessageRecord.a(paramQQAppInterface);
                }
                if (paramMessageRecord.jdField_a_of_type_Azmk.a(paramazmj.w))
                {
                  localaskq.a(str2, 20, paramazmj.w.b, "", 0, null);
                  paramObject = str1;
                  paramString = paramMessageRecord;
                }
                else
                {
                  paramObject = str1;
                  paramString = paramMessageRecord;
                  if (paramazmj.w != null)
                  {
                    l1 = paramazmj.w.a;
                    l2 = paramazmj.w.b;
                    if (l1 != -1L)
                    {
                      paramMessageRecord.jdField_a_of_type_Azmk.a = l1;
                      paramMessageRecord.jdField_a_of_type_Azmk.b = l2;
                    }
                    localaskq.a(str2, 20, paramazmj.w.b, "", 0, null);
                    paramObject = str1;
                    paramString = paramMessageRecord;
                  }
                }
              }
              else
              {
                paramString = BaseApplication.getContext();
                if (paramQQAppInterface != null) {}
                for (;;)
                {
                  paramString = new ahpw(paramString, paramQQAppInterface);
                  paramString.jdField_a_of_type_Azmk = new azmk(paramazmj.w);
                  localaskq.a(str2, 20, paramazmj.w.b, "", 0, null);
                  paramObject = str1;
                  break;
                  paramQQAppInterface = "";
                }
                if ((paramObject instanceof ahqp))
                {
                  paramQQAppInterface = (ahqp)paramObject;
                  paramObject = str1;
                  paramString = paramQQAppInterface;
                  if (paramQQAppInterface.jdField_a_of_type_Azmk.a(paramazmj.l))
                  {
                    localaskq.a(str2, 22, paramazmj.l.b, "", 0, null);
                    paramObject = str1;
                    paramString = paramQQAppInterface;
                  }
                }
                else
                {
                  paramString = new ahqp(BaseApplication.getContext());
                  paramString.jdField_a_of_type_Azmk = new azmk(paramazmj.l);
                  localaskq.a(str2, 22, paramazmj.l.b, "", 0, null);
                  paramObject = str1;
                }
              }
            }
          }
        }
      }
      label3660:
      paramMessageRecord = "";
    }
  }
  
  public static final boolean a(int paramInt1, int paramInt2)
  {
    int i1 = paramInt1;
    if (paramInt1 == 11) {
      i1 = 31;
    }
    paramInt1 = paramInt2;
    if (paramInt2 == 11) {
      paramInt1 = 31;
    }
    if ((i1 == 2) || (i1 == 16)) {
      if (i1 + 1 < paramInt1) {}
    }
    while (i1 >= paramInt1)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Azmk.a()) {
      return 24;
    }
    if (this.l.a()) {
      return 22;
    }
    if (this.f.a()) {
      return 13;
    }
    if (this.u.a()) {
      return 12;
    }
    if (this.w.a()) {
      return 20;
    }
    return 0;
  }
  
  public int a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    int i1 = 0;
    if ((paramQQAppInterface != null) && (paramBoolean))
    {
      paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString);
      if (paramQQAppInterface == null) {}
    }
    for (paramBoolean = paramQQAppInterface.hasOrgs();; paramBoolean = false)
    {
      if (this.q.a()) {
        i1 = 11;
      }
      do
      {
        return i1;
        if (this.h.a())
        {
          if (paramBoolean) {
            return 14;
          }
          return 27;
        }
        if (this.jdField_a_of_type_Azmk.a()) {
          return 24;
        }
        if (this.x.a()) {
          return 23;
        }
        if (this.k.a()) {
          return 18;
        }
        if (this.l.a()) {
          return 22;
        }
        if (this.m.a()) {
          return 21;
        }
        if (this.c.a()) {
          return 17;
        }
        if (this.b.a()) {
          return 16;
        }
        if (this.d.a()) {
          return 10;
        }
        if (this.f.a()) {
          return 13;
        }
        if (this.j.a()) {
          return 8;
        }
        if (this.n.a()) {
          return 3;
        }
        if (this.o.a()) {
          return 2;
        }
        if (this.g.a()) {
          return 5;
        }
        if (this.i.a()) {
          return 7;
        }
        if (this.p.a()) {
          return 29;
        }
        if (this.r.a()) {
          return 4;
        }
        if (this.s.a()) {
          return 19;
        }
        if (this.t.a()) {
          return 9;
        }
        if (this.u.a()) {
          return 12;
        }
        if (this.v.a()) {
          return 6;
        }
      } while (!this.w.a());
      return 20;
    }
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Azmk.a()) {
      return this.jdField_a_of_type_Azmk.a;
    }
    if (this.f.a()) {
      return this.f.a;
    }
    if (this.u.a()) {
      return this.u.a;
    }
    if (this.w.a()) {
      return this.w.a;
    }
    if (this.l.a()) {
      return this.l.a;
    }
    return -1L;
  }
  
  public azmj a(azmj paramazmj)
  {
    if (paramazmj != null)
    {
      this.f.a(paramazmj.f);
      this.jdField_a_of_type_Azmk.a(paramazmj.jdField_a_of_type_Azmk);
      this.b.a(paramazmj.b);
      this.c.a(paramazmj.c);
      this.e.a(paramazmj.e);
      this.d.a(paramazmj.d);
      this.g.a(paramazmj.g);
      this.h.a(paramazmj.h);
      this.i.a(paramazmj.i);
      this.j.a(paramazmj.j);
      this.k.a(paramazmj.k);
      this.l.a(paramazmj.l);
      this.m.a(paramazmj.m);
      this.n.a(paramazmj.n);
      this.o.a(paramazmj.o);
      this.p.a(paramazmj.p);
      this.q.a(paramazmj.q);
      this.r.a(paramazmj.r);
      this.s.a(paramazmj.s);
      this.t.a(paramazmj.t);
      this.u.a(paramazmj.u);
      this.v.a(paramazmj.v);
      this.w.a(paramazmj.w);
      this.x.a(paramazmj.x);
    }
    return this;
  }
  
  public void a()
  {
    this.f.a();
    this.jdField_a_of_type_Azmk.a();
    this.b.a();
    this.c.a();
    this.e.a();
    this.d.a();
    this.g.a();
    this.h.a();
    this.i.a();
    this.j.a();
    this.k.a();
    this.l.a();
    this.m.a();
    this.n.a();
    this.o.a();
    this.p.a();
    this.q.a();
    this.r.a();
    this.s.a();
    this.t.a();
    this.u.a();
    this.v.a();
    this.w.a();
    this.x.a();
  }
  
  public boolean a()
  {
    return (this.f.a()) || (this.jdField_a_of_type_Azmk.a()) || (this.c.a()) || (this.e.a()) || (this.d.a()) || (this.g.a()) || (this.h.a()) || (this.b.a()) || (this.i.a()) || (this.k.a()) || (this.j.a()) || (this.l.a()) || (this.o.a()) || (this.n.a()) || (this.m.a()) || (this.p.a()) || (this.q.a()) || (this.r.a()) || (this.s.a()) || (this.t.a()) || (this.v.a()) || (this.u.a()) || (this.w.a()) || (this.x.a());
  }
  
  public long b()
  {
    if (this.h.a()) {
      return this.h.a;
    }
    if (this.jdField_a_of_type_Azmk.a()) {
      return this.jdField_a_of_type_Azmk.a;
    }
    if (this.x.a()) {
      return this.x.a;
    }
    if (this.k.a()) {
      return this.k.a;
    }
    if (this.c.a()) {
      return this.c.a;
    }
    if (this.b.a()) {
      return this.b.a;
    }
    if (this.e.a()) {
      return this.e.a;
    }
    if (this.d.a()) {
      return this.d.a;
    }
    if (this.f.a()) {
      return this.f.a;
    }
    if (this.j.a()) {
      return this.j.a;
    }
    if (this.g.a()) {
      return this.g.a;
    }
    if (this.i.a()) {
      return this.i.a;
    }
    if (this.l.a()) {
      return this.l.a;
    }
    if (this.m.a()) {
      return this.m.a;
    }
    if (this.n.a()) {
      return this.n.a;
    }
    if (this.o.a()) {
      return this.o.a;
    }
    if (this.p.a()) {
      return this.p.a;
    }
    if (this.q.a()) {
      return this.q.a;
    }
    if (this.r.a()) {
      return this.r.a;
    }
    if (this.s.a()) {
      return this.s.a;
    }
    if (this.t.a()) {
      return this.t.a;
    }
    if (this.u.a()) {
      return this.u.a;
    }
    if (this.v.a()) {
      return this.v.a;
    }
    if (this.w.a()) {
      return this.w.a;
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azmj
 * JD-Core Version:    0.7.0.1
 */