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

public class bbpd
{
  public int a;
  public bbpe a;
  public String a;
  public bbpe b = new bbpe();
  public bbpe c = new bbpe();
  public bbpe d = new bbpe();
  public bbpe e = new bbpe();
  public bbpe f = new bbpe();
  public bbpe g = new bbpe();
  public bbpe h = new bbpe();
  public bbpe i = new bbpe();
  public bbpe j = new bbpe();
  public bbpe k = new bbpe();
  public bbpe l = new bbpe();
  public bbpe m = new bbpe();
  public bbpe n = new bbpe();
  public bbpe o = new bbpe();
  public bbpe p = new bbpe();
  public bbpe q = new bbpe();
  public bbpe r = new bbpe();
  public bbpe s = new bbpe();
  public bbpe t = new bbpe();
  public bbpe u = new bbpe();
  public bbpe v = new bbpe();
  public bbpe w = new bbpe();
  public bbpe x = new bbpe();
  
  public bbpd()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Bbpe = new bbpe();
    a();
  }
  
  public bbpd(bbpd parambbpd)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Bbpe = new bbpe();
    if (parambbpd != null)
    {
      this.f.a(parambbpd.f);
      this.jdField_a_of_type_Bbpe.a(parambbpd.jdField_a_of_type_Bbpe);
      this.b.a(parambbpd.b);
      this.c.a(parambbpd.c);
      this.e.a(parambbpd.e);
      this.d.a(parambbpd.d);
      this.g.a(parambbpd.g);
      this.h.a(parambbpd.h);
      this.i.a(parambbpd.i);
      this.j.a(parambbpd.j);
      this.k.a(parambbpd.k);
      this.l.a(parambbpd.l);
      this.m.a(parambbpd.m);
      this.n.a(parambbpd.n);
      this.o.a(parambbpd.o);
      this.p.a(parambbpd.p);
      this.q.a(parambbpd.q);
      this.r.a(parambbpd.r);
      this.s.a(parambbpd.s);
      this.t.a(parambbpd.t);
      this.u.a(parambbpd.u);
      this.v.a(parambbpd.v);
      this.w.a(parambbpd.w);
      this.x.a(parambbpd.x);
      return;
    }
    a();
  }
  
  public static Object a(QQAppInterface paramQQAppInterface, String paramString, bbpd parambbpd, Object paramObject, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    auga localauga = (auga)paramQQAppInterface.getManager(37);
    if (paramBoolean) {
      switch (parambbpd.a(paramQQAppInterface, paramBoolean, paramString))
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
                    if ((paramObject instanceof ajmn))
                    {
                      paramQQAppInterface = (ajmn)paramObject;
                      paramQQAppInterface.jdField_a_of_type_Bbpe.a(parambbpd.c);
                      localauga.a(paramString, 17, parambbpd.c.a, "", 0, null);
                      return paramQQAppInterface;
                    }
                    paramQQAppInterface = new ajmn(BaseApplication.getContext());
                    paramQQAppInterface.a(paramMessageRecord.senderuin);
                    paramQQAppInterface.jdField_a_of_type_Bbpe = new bbpe(parambbpd.c);
                    localauga.a(paramString, 17, parambbpd.c.a, "", 0, null);
                    return paramQQAppInterface;
                    if ((paramObject instanceof ajmf))
                    {
                      paramObject = (ajmf)paramObject;
                      paramQQAppInterface = paramObject;
                    }
                    for (;;)
                    {
                      paramObject.jdField_a_of_type_Bbpe.a(parambbpd.b);
                      localauga.a(paramString, 100, parambbpd.b.a, "", 0, null);
                      return paramQQAppInterface;
                      paramQQAppInterface = new ajmf(BaseApplication.getContext());
                      if ((paramObject instanceof ajmn))
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
                    if ((paramObject instanceof ajlz))
                    {
                      paramQQAppInterface = (ajlz)paramObject;
                      paramQQAppInterface.jdField_a_of_type_Bbpe.a(parambbpd.d);
                      localauga.a(paramString, 11, parambbpd.d.a, "", 0, null);
                      return paramQQAppInterface;
                    }
                    paramQQAppInterface = new ajlz(BaseApplication.getContext());
                    paramQQAppInterface.jdField_a_of_type_Bbpe = new bbpe(parambbpd.d);
                    localauga.a(paramString, 11, parambbpd.d.a, "", 0, null);
                    return paramQQAppInterface;
                    localauga.a(paramString, 102, parambbpd.q.b, "", 0, paramMessageRecord);
                    if ((paramObject instanceof ajmh))
                    {
                      paramQQAppInterface = (ajmh)paramObject;
                      paramQQAppInterface.jdField_a_of_type_Bbpe.a(parambbpd.q);
                      return paramQQAppInterface;
                    }
                    paramQQAppInterface = new ajmh(BaseApplication.getContext(), false);
                    paramQQAppInterface.jdField_a_of_type_Bbpe = new bbpe(parambbpd.q);
                    return paramQQAppInterface;
                    if (!(paramObject instanceof ajlw)) {
                      break;
                    }
                    paramObject = (ajlw)paramObject;
                    paramQQAppInterface = paramObject;
                  } while (!paramObject.jdField_a_of_type_Bbpe.a(parambbpd.jdField_a_of_type_Bbpe));
                  localauga.a(paramString, 23, parambbpd.jdField_a_of_type_Bbpe.b, "", 0, null);
                  return paramObject;
                  paramQQAppInterface = new ajlw(BaseApplication.getContext());
                  paramQQAppInterface.a(paramMessageRecord.senderuin);
                  paramQQAppInterface.jdField_a_of_type_Bbpe = new bbpe(parambbpd.jdField_a_of_type_Bbpe);
                  localauga.a(paramString, 23, parambbpd.jdField_a_of_type_Bbpe.b, "", 0, null);
                  return paramQQAppInterface;
                  if (paramMessageRecord == null) {
                    return null;
                  }
                  paramBoolean = auuv.a(paramMessageRecord);
                  if ((paramMessageRecord.msgtype != -2035) && (paramMessageRecord.msgtype != -2038) && (!paramBoolean)) {
                    return null;
                  }
                  int i1;
                  if (paramBoolean)
                  {
                    i1 = auuv.a((MessageForStructing)paramMessageRecord);
                    if ((paramObject instanceof ajmk))
                    {
                      paramQQAppInterface = (ajmk)paramObject;
                      paramQQAppInterface.jdField_a_of_type_Bbpe.a(parambbpd.h);
                      localauga.a(paramString, 26, parambbpd.h.b, "", i1, null);
                      return paramQQAppInterface;
                    }
                    paramQQAppInterface = new ajmk(BaseApplication.getContext());
                    paramQQAppInterface.jdField_a_of_type_Bbpe = new bbpe(parambbpd.h);
                    localauga.a(paramString, 26, parambbpd.h.b, "", i1, null);
                    return paramQQAppInterface;
                  }
                  if ((paramMessageRecord instanceof MessageForDeliverGiftTips))
                  {
                    paramMessageRecord = (MessageForDeliverGiftTips)paramMessageRecord;
                    i1 = 1;
                    i2 = 1;
                    if (!(paramObject instanceof ajmk)) {
                      break label968;
                    }
                    paramQQAppInterface = (ajmk)paramObject;
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
                      paramQQAppInterface.jdField_a_of_type_Bbpe.a(parambbpd.h);
                      localauga.a(paramString, 26, parambbpd.h.b, "", paramMessageRecord.giftCount, null);
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
                    azqs.b(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "Troop_gift", "MsgBizType.TYPE_TROOP_RECEIVED_FLOWSER_MSG, MessageRecord cast to GiftTips", 0, -1, paramMessageRecord.getClass().getName(), "", "", "");
                    return null;
                    paramObject = new ajmk(BaseApplication.getContext(), paramMessageRecord.isToAll());
                    paramObject.jdField_a_of_type_Bbpe = new bbpe(parambbpd.h);
                    localauga.a(paramString, 26, parambbpd.h.b, "", paramMessageRecord.giftCount, null);
                  }
                  if ((paramObject instanceof ajlv))
                  {
                    paramQQAppInterface = (ajlv)paramObject;
                    paramObject = paramQQAppInterface;
                    if (paramQQAppInterface.jdField_a_of_type_Bbpe.a(parambbpd.f))
                    {
                      localauga.a(paramString, 14, parambbpd.f.b, "", 0, null);
                      paramObject = paramQQAppInterface;
                    }
                  }
                  for (;;)
                  {
                    paramQQAppInterface = paramObject;
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.d(bbpd.class.getSimpleName() + ".troop.special_msg.at_all_msg", 2, "updateMsgInfo");
                    return paramObject;
                    paramObject = new ajlv(BaseApplication.getContext());
                    paramObject.a(paramMessageRecord.senderuin);
                    paramObject.jdField_a_of_type_Bbpe = new bbpe(parambbpd.f);
                    localauga.a(paramString, 14, parambbpd.f.b, "", 0, null);
                  }
                  return null;
                  if (!(paramObject instanceof bkds)) {
                    break;
                  }
                  paramObject = (bkds)paramObject;
                  paramQQAppInterface = paramObject;
                } while (!paramObject.jdField_a_of_type_Bbpe.a(parambbpd.g));
                localauga.a(paramString, 6, parambbpd.g.b, "", 0, null);
                return paramObject;
                paramQQAppInterface = new bkds(BaseApplication.getContext());
                paramQQAppInterface.jdField_a_of_type_Bbpe = new bbpe(parambbpd.g);
                localauga.a(paramString, 6, parambbpd.g.b, "", 0, null);
                return paramQQAppInterface;
                if (paramMessageRecord == null) {
                  return null;
                }
                paramBoolean = auuv.a(paramMessageRecord);
                if ((paramMessageRecord.msgtype != -2035) && (paramMessageRecord.msgtype != -2038) && (!paramBoolean)) {
                  return null;
                }
                if (paramBoolean)
                {
                  if ((paramObject instanceof ajmd))
                  {
                    paramQQAppInterface = (ajmd)paramObject;
                    paramQQAppInterface.jdField_a_of_type_Bbpe.a(parambbpd.i);
                    return paramQQAppInterface;
                  }
                  paramQQAppInterface = new ajmd(BaseApplication.getContext());
                  paramQQAppInterface.jdField_a_of_type_Bbpe = new bbpe(parambbpd.i);
                  return paramQQAppInterface;
                }
                if ((paramMessageRecord instanceof MessageForDeliverGiftTips))
                {
                  paramMessageRecord = (MessageForDeliverGiftTips)paramMessageRecord;
                  if (!(paramObject instanceof ajmd)) {
                    break label1525;
                  }
                  paramString = (ajmd)paramObject;
                  paramString.jdField_a_of_type_Bbpe.a(parambbpd.i);
                }
                for (;;)
                {
                  if (!TextUtils.isEmpty(paramMessageRecord.remindBrief))
                  {
                    parambbpd = paramMessageRecord.remindBrief.split("#");
                    if (parambbpd.length > 1) {
                      paramString.jdField_a_of_type_JavaLangString = ("[" + parambbpd[1] + "]");
                    }
                  }
                  paramQQAppInterface = (bcka)paramQQAppInterface.getManager(223);
                  if (!paramQQAppInterface.a(false)) {
                    break;
                  }
                  return null;
                  azqs.b(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "Troop_gift", "MsgBizType.TYPE_TROOP_HAS_GIFT_IN_TROOP, MessageRecord cast to GiftTips error", 0, -1, paramMessageRecord.getClass().getName(), "", "", "");
                  return null;
                  paramString = new ajmd(BaseApplication.getContext());
                  paramString.jdField_a_of_type_Bbpe = new bbpe(parambbpd.i);
                }
                paramQQAppInterface.jdField_a_of_type_Int = 1;
                return paramString;
                if ((paramObject instanceof ajmi))
                {
                  paramQQAppInterface = (ajmi)paramObject;
                  paramQQAppInterface.jdField_a_of_type_Bbpe.a(parambbpd.j);
                  return paramQQAppInterface;
                }
                paramQQAppInterface = new ajmi(BaseApplication.getContext());
                paramQQAppInterface.jdField_a_of_type_Bbpe = new bbpe(parambbpd.j);
                return paramQQAppInterface;
                if (!(paramObject instanceof ajma)) {
                  break;
                }
                paramObject = (ajma)paramObject;
                paramQQAppInterface = paramObject;
              } while (!paramObject.jdField_a_of_type_Bbpe.a(parambbpd.k));
              localauga.a(paramString, 18, parambbpd.k.b, "", 0, null);
              return paramObject;
              paramQQAppInterface = new ajma(BaseApplication.getContext());
              paramQQAppInterface.jdField_a_of_type_Bbpe = new bbpe(parambbpd.k);
              localauga.a(paramString, 18, parambbpd.k.b, "", 0, null);
              return paramQQAppInterface;
              if (!(paramObject instanceof ajml)) {
                break;
              }
              paramObject = (ajml)paramObject;
              paramQQAppInterface = paramObject;
            } while (!paramObject.jdField_a_of_type_Bbpe.a(parambbpd.l));
            localauga.a(paramString, 22, parambbpd.l.b, "", 0, null);
            return paramObject;
            paramQQAppInterface = new ajml(BaseApplication.getContext());
            paramQQAppInterface.jdField_a_of_type_Bbpe = new bbpe(parambbpd.l);
            localauga.a(paramString, 22, parambbpd.l.b, "", 0, null);
            return paramQQAppInterface;
            if ((!(paramObject instanceof ajmg)) || (((ajmg)paramObject).c != 1)) {
              break;
            }
            paramObject = (ajmg)paramObject;
            paramQQAppInterface = paramObject;
          } while (!paramObject.jdField_a_of_type_Bbpe.a(parambbpd.n));
          localauga.a(paramString, 4, parambbpd.n.b, "", 0, null);
          return paramObject;
          paramQQAppInterface = new ajmg(BaseApplication.getContext(), 1);
          paramQQAppInterface.jdField_a_of_type_Bbpe = new bbpe(parambbpd.n);
          localauga.a(paramString, 4, parambbpd.n.b, "", 0, null);
          return paramQQAppInterface;
          if ((!(paramObject instanceof ajmg)) || (((ajmg)paramObject).c != 0)) {
            break;
          }
          paramObject = (ajmg)paramObject;
          paramQQAppInterface = paramObject;
        } while (!paramObject.jdField_a_of_type_Bbpe.a(parambbpd.o));
        localauga.a(paramString, 3, parambbpd.o.b, "", 0, null);
        return paramObject;
        paramQQAppInterface = new ajmg(BaseApplication.getContext(), 0);
        paramQQAppInterface.jdField_a_of_type_Bbpe = new bbpe(parambbpd.o);
        localauga.a(paramString, 3, parambbpd.o.b, "", 0, null);
        return paramQQAppInterface;
      case 21: 
        label968:
        label1525:
        if ((StructMsgForGeneralShare)azvd.a(paramMessageRecord.msgData) == null)
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
      if ((paramObject instanceof ajly))
      {
        paramQQAppInterface = (ajly)paramObject;
        paramObject = paramQQAppInterface;
        if (paramQQAppInterface.jdField_a_of_type_Bbpe.a(parambbpd.m))
        {
          localauga.a(paramString, 21, parambbpd.m.b, "", 0, null);
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
        paramObject = new ajly(BaseApplication.getContext());
        paramObject.jdField_a_of_type_Bbpe = new bbpe(parambbpd.m);
        localauga.a(paramString, 21, parambbpd.m.b, "", 0, null);
      }
      paramQQAppInterface = new ajmh(BaseApplication.getContext(), false);
      paramQQAppInterface.c = 1;
      return paramQQAppInterface;
      if ((paramObject instanceof ajme))
      {
        paramObject = (ajme)paramObject;
        paramQQAppInterface = paramObject;
        if (!paramObject.jdField_a_of_type_Bbpe.a(parambbpd.r)) {
          break;
        }
        localauga.a(paramString, 5, parambbpd.r.b, "", 0, null);
        return paramObject;
      }
      paramQQAppInterface = new ajme(BaseApplication.getContext());
      paramQQAppInterface.jdField_a_of_type_Bbpe = new bbpe(parambbpd.r);
      localauga.a(paramString, 5, parambbpd.r.b, "", 0, null);
      return paramQQAppInterface;
      if ((paramObject instanceof ajmc))
      {
        paramObject = (ajmc)paramObject;
        paramQQAppInterface = paramObject;
        if (!paramObject.jdField_a_of_type_Bbpe.a(parambbpd.s)) {
          break;
        }
        localauga.a(paramString, 19, parambbpd.s.b, "", 0, null);
        return paramObject;
      }
      paramQQAppInterface = new ajmc(BaseApplication.getContext());
      paramQQAppInterface.jdField_a_of_type_Bbpe = new bbpe(parambbpd.s);
      localauga.a(paramString, 19, parambbpd.s.b, "", 0, null);
      return paramQQAppInterface;
      if ((paramObject instanceof ajmj))
      {
        paramObject = (ajmj)paramObject;
        paramQQAppInterface = paramObject;
        if (!paramObject.jdField_a_of_type_Bbpe.a(parambbpd.u)) {
          break;
        }
        localauga.a(paramString, 13, parambbpd.u.b, "", 0, null);
        return paramObject;
      }
      paramQQAppInterface = new ajmj(BaseApplication.getContext());
      paramQQAppInterface.jdField_a_of_type_Bbpe = new bbpe(parambbpd.u);
      localauga.a(paramString, 13, parambbpd.u.b, "", 0, null);
      return paramQQAppInterface;
      return new ajmb(BaseApplication.getContext());
      paramQQAppInterface = null;
      if ((paramMessageRecord instanceof MessageForArkApp)) {
        paramQQAppInterface = anpd.a((MessageForArkApp)paramMessageRecord);
      }
      long l1;
      long l2;
      if ((paramObject instanceof ajls))
      {
        paramObject = (ajls)paramObject;
        if (paramQQAppInterface != null) {
          paramObject.a(paramQQAppInterface);
        }
        if (paramObject.jdField_a_of_type_Bbpe.a(parambbpd.w))
        {
          localauga.a(paramString, 20, parambbpd.w.b, "", 0, null);
          return paramObject;
        }
        paramQQAppInterface = paramObject;
        if (parambbpd.w == null) {
          break;
        }
        l1 = parambbpd.w.a;
        l2 = parambbpd.w.b;
        if (l1 != -1L)
        {
          paramObject.jdField_a_of_type_Bbpe.a = l1;
          paramObject.jdField_a_of_type_Bbpe.b = l2;
        }
        localauga.a(paramString, 20, parambbpd.w.b, "", 0, null);
        return paramObject;
      }
      paramObject = BaseApplication.getContext();
      if (paramQQAppInterface != null) {}
      for (;;)
      {
        paramQQAppInterface = new ajls(paramObject, paramQQAppInterface);
        paramQQAppInterface.jdField_a_of_type_Bbpe = new bbpe(parambbpd.w);
        localauga.a(paramString, 20, parambbpd.w.b, "", 0, null);
        return paramQQAppInterface;
        paramQQAppInterface = "";
      }
      if ((paramObject instanceof ajmm))
      {
        paramObject = (ajmm)paramObject;
        paramQQAppInterface = paramObject;
        if (!paramObject.jdField_a_of_type_Bbpe.a(parambbpd.x)) {
          break;
        }
        localauga.a(paramString, 101, parambbpd.x.b, "", 0, null);
        return paramObject;
      }
      paramQQAppInterface = new ajmm(BaseApplication.getContext());
      paramQQAppInterface.jdField_a_of_type_Bbpe = new bbpe(parambbpd.x);
      localauga.a(paramString, 101, parambbpd.x.b, "", 0, null);
      return paramQQAppInterface;
      String str2 = paramString + "&" + 3000;
      String str1 = "0";
      switch (parambbpd.a())
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
        if ((paramObject instanceof ajlv))
        {
          paramQQAppInterface = (ajlv)paramObject;
          paramObject = str1;
          paramString = paramQQAppInterface;
          if (paramQQAppInterface.jdField_a_of_type_Bbpe.a(parambbpd.f))
          {
            localauga.a(str2, 14, parambbpd.f.b, "", 0, null);
            paramObject = "AT_ALL_update";
            paramString = paramQQAppInterface;
          }
        }
        else
        {
          paramString = new ajlv(BaseApplication.getContext());
          paramString.a(paramMessageRecord.senderuin);
          paramString.jdField_a_of_type_Bbpe = new bbpe(parambbpd.f);
          localauga.a(str2, 14, parambbpd.f.b, "", 0, null);
          paramObject = "AT_ALL_add";
          continue;
          if ((paramObject instanceof ajlw))
          {
            paramQQAppInterface = (ajlw)paramObject;
            paramObject = str1;
            paramString = paramQQAppInterface;
            if (paramQQAppInterface.jdField_a_of_type_Bbpe.a(parambbpd.jdField_a_of_type_Bbpe))
            {
              localauga.a(str2, 23, parambbpd.jdField_a_of_type_Bbpe.b, "", 0, null);
              paramObject = "AT_ME_update";
              paramString = paramQQAppInterface;
            }
          }
          else
          {
            paramString = new ajlw(BaseApplication.getContext());
            paramString.a(paramMessageRecord.senderuin);
            paramString.jdField_a_of_type_Bbpe = new bbpe(parambbpd.jdField_a_of_type_Bbpe);
            localauga.a(str2, 23, parambbpd.jdField_a_of_type_Bbpe.b, "", 0, null);
            paramObject = "AT_ME_ADD";
            continue;
            if ((paramObject instanceof ajmj))
            {
              paramQQAppInterface = (ajmj)paramObject;
              paramObject = str1;
              paramString = paramQQAppInterface;
              if (paramQQAppInterface.jdField_a_of_type_Bbpe.a(parambbpd.u))
              {
                localauga.a(str2, 13, parambbpd.u.b, "", 0, null);
                paramObject = "receipt_update";
                paramString = paramQQAppInterface;
              }
            }
            else
            {
              paramString = new ajmj(BaseApplication.getContext());
              paramString.jdField_a_of_type_Bbpe = new bbpe(parambbpd.u);
              localauga.a(str2, 13, parambbpd.u.b, "", 0, null);
              paramObject = "receipt_add";
              continue;
              paramQQAppInterface = null;
              if ((paramMessageRecord instanceof MessageForArkApp)) {
                paramQQAppInterface = anpd.a((MessageForArkApp)paramMessageRecord);
              }
              if ((paramObject instanceof ajls))
              {
                paramMessageRecord = (ajls)paramObject;
                if (paramQQAppInterface != null) {
                  paramMessageRecord.a(paramQQAppInterface);
                }
                if (paramMessageRecord.jdField_a_of_type_Bbpe.a(parambbpd.w))
                {
                  localauga.a(str2, 20, parambbpd.w.b, "", 0, null);
                  paramObject = str1;
                  paramString = paramMessageRecord;
                }
                else
                {
                  paramObject = str1;
                  paramString = paramMessageRecord;
                  if (parambbpd.w != null)
                  {
                    l1 = parambbpd.w.a;
                    l2 = parambbpd.w.b;
                    if (l1 != -1L)
                    {
                      paramMessageRecord.jdField_a_of_type_Bbpe.a = l1;
                      paramMessageRecord.jdField_a_of_type_Bbpe.b = l2;
                    }
                    localauga.a(str2, 20, parambbpd.w.b, "", 0, null);
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
                  paramString = new ajls(paramString, paramQQAppInterface);
                  paramString.jdField_a_of_type_Bbpe = new bbpe(parambbpd.w);
                  localauga.a(str2, 20, parambbpd.w.b, "", 0, null);
                  paramObject = str1;
                  break;
                  paramQQAppInterface = "";
                }
                if ((paramObject instanceof ajml))
                {
                  paramQQAppInterface = (ajml)paramObject;
                  paramObject = str1;
                  paramString = paramQQAppInterface;
                  if (paramQQAppInterface.jdField_a_of_type_Bbpe.a(parambbpd.l))
                  {
                    localauga.a(str2, 22, parambbpd.l.b, "", 0, null);
                    paramObject = str1;
                    paramString = paramQQAppInterface;
                  }
                }
                else
                {
                  paramString = new ajml(BaseApplication.getContext());
                  paramString.jdField_a_of_type_Bbpe = new bbpe(parambbpd.l);
                  localauga.a(str2, 22, parambbpd.l.b, "", 0, null);
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
    if (this.jdField_a_of_type_Bbpe.a()) {
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
        if (this.jdField_a_of_type_Bbpe.a()) {
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
    if (this.jdField_a_of_type_Bbpe.a()) {
      return this.jdField_a_of_type_Bbpe.a;
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
  
  public bbpd a(bbpd parambbpd)
  {
    if (parambbpd != null)
    {
      this.f.a(parambbpd.f);
      this.jdField_a_of_type_Bbpe.a(parambbpd.jdField_a_of_type_Bbpe);
      this.b.a(parambbpd.b);
      this.c.a(parambbpd.c);
      this.e.a(parambbpd.e);
      this.d.a(parambbpd.d);
      this.g.a(parambbpd.g);
      this.h.a(parambbpd.h);
      this.i.a(parambbpd.i);
      this.j.a(parambbpd.j);
      this.k.a(parambbpd.k);
      this.l.a(parambbpd.l);
      this.m.a(parambbpd.m);
      this.n.a(parambbpd.n);
      this.o.a(parambbpd.o);
      this.p.a(parambbpd.p);
      this.q.a(parambbpd.q);
      this.r.a(parambbpd.r);
      this.s.a(parambbpd.s);
      this.t.a(parambbpd.t);
      this.u.a(parambbpd.u);
      this.v.a(parambbpd.v);
      this.w.a(parambbpd.w);
      this.x.a(parambbpd.x);
    }
    return this;
  }
  
  public void a()
  {
    this.f.a();
    this.jdField_a_of_type_Bbpe.a();
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
    return (this.f.a()) || (this.jdField_a_of_type_Bbpe.a()) || (this.c.a()) || (this.e.a()) || (this.d.a()) || (this.g.a()) || (this.h.a()) || (this.b.a()) || (this.i.a()) || (this.k.a()) || (this.j.a()) || (this.l.a()) || (this.o.a()) || (this.n.a()) || (this.m.a()) || (this.p.a()) || (this.q.a()) || (this.r.a()) || (this.s.a()) || (this.t.a()) || (this.v.a()) || (this.u.a()) || (this.w.a()) || (this.x.a());
  }
  
  public long b()
  {
    if (this.h.a()) {
      return this.h.a;
    }
    if (this.jdField_a_of_type_Bbpe.a()) {
      return this.jdField_a_of_type_Bbpe.a;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpd
 * JD-Core Version:    0.7.0.1
 */