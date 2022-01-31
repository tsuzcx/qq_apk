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

public class bbku
{
  public int a;
  public bbkv a;
  public String a;
  public bbkv b = new bbkv();
  public bbkv c = new bbkv();
  public bbkv d = new bbkv();
  public bbkv e = new bbkv();
  public bbkv f = new bbkv();
  public bbkv g = new bbkv();
  public bbkv h = new bbkv();
  public bbkv i = new bbkv();
  public bbkv j = new bbkv();
  public bbkv k = new bbkv();
  public bbkv l = new bbkv();
  public bbkv m = new bbkv();
  public bbkv n = new bbkv();
  public bbkv o = new bbkv();
  public bbkv p = new bbkv();
  public bbkv q = new bbkv();
  public bbkv r = new bbkv();
  public bbkv s = new bbkv();
  public bbkv t = new bbkv();
  public bbkv u = new bbkv();
  public bbkv v = new bbkv();
  public bbkv w = new bbkv();
  public bbkv x = new bbkv();
  
  public bbku()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Bbkv = new bbkv();
    a();
  }
  
  public bbku(bbku parambbku)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Bbkv = new bbkv();
    if (parambbku != null)
    {
      this.f.a(parambbku.f);
      this.jdField_a_of_type_Bbkv.a(parambbku.jdField_a_of_type_Bbkv);
      this.b.a(parambbku.b);
      this.c.a(parambbku.c);
      this.e.a(parambbku.e);
      this.d.a(parambbku.d);
      this.g.a(parambbku.g);
      this.h.a(parambbku.h);
      this.i.a(parambbku.i);
      this.j.a(parambbku.j);
      this.k.a(parambbku.k);
      this.l.a(parambbku.l);
      this.m.a(parambbku.m);
      this.n.a(parambbku.n);
      this.o.a(parambbku.o);
      this.p.a(parambbku.p);
      this.q.a(parambbku.q);
      this.r.a(parambbku.r);
      this.s.a(parambbku.s);
      this.t.a(parambbku.t);
      this.u.a(parambbku.u);
      this.v.a(parambbku.v);
      this.w.a(parambbku.w);
      this.x.a(parambbku.x);
      return;
    }
    a();
  }
  
  public static Object a(QQAppInterface paramQQAppInterface, String paramString, bbku parambbku, Object paramObject, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    aubr localaubr = (aubr)paramQQAppInterface.getManager(37);
    if (paramBoolean) {
      switch (parambbku.a(paramQQAppInterface, paramBoolean, paramString))
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
                    if ((paramObject instanceof ajhy))
                    {
                      paramQQAppInterface = (ajhy)paramObject;
                      paramQQAppInterface.jdField_a_of_type_Bbkv.a(parambbku.c);
                      localaubr.a(paramString, 17, parambbku.c.a, "", 0, null);
                      return paramQQAppInterface;
                    }
                    paramQQAppInterface = new ajhy(BaseApplication.getContext());
                    paramQQAppInterface.a(paramMessageRecord.senderuin);
                    paramQQAppInterface.jdField_a_of_type_Bbkv = new bbkv(parambbku.c);
                    localaubr.a(paramString, 17, parambbku.c.a, "", 0, null);
                    return paramQQAppInterface;
                    if ((paramObject instanceof ajhq))
                    {
                      paramObject = (ajhq)paramObject;
                      paramQQAppInterface = paramObject;
                    }
                    for (;;)
                    {
                      paramObject.jdField_a_of_type_Bbkv.a(parambbku.b);
                      localaubr.a(paramString, 100, parambbku.b.a, "", 0, null);
                      return paramQQAppInterface;
                      paramQQAppInterface = new ajhq(BaseApplication.getContext());
                      if ((paramObject instanceof ajhy))
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
                    if ((paramObject instanceof ajhk))
                    {
                      paramQQAppInterface = (ajhk)paramObject;
                      paramQQAppInterface.jdField_a_of_type_Bbkv.a(parambbku.d);
                      localaubr.a(paramString, 11, parambbku.d.a, "", 0, null);
                      return paramQQAppInterface;
                    }
                    paramQQAppInterface = new ajhk(BaseApplication.getContext());
                    paramQQAppInterface.jdField_a_of_type_Bbkv = new bbkv(parambbku.d);
                    localaubr.a(paramString, 11, parambbku.d.a, "", 0, null);
                    return paramQQAppInterface;
                    localaubr.a(paramString, 102, parambbku.q.b, "", 0, paramMessageRecord);
                    if ((paramObject instanceof ajhs))
                    {
                      paramQQAppInterface = (ajhs)paramObject;
                      paramQQAppInterface.jdField_a_of_type_Bbkv.a(parambbku.q);
                      return paramQQAppInterface;
                    }
                    paramQQAppInterface = new ajhs(BaseApplication.getContext(), false);
                    paramQQAppInterface.jdField_a_of_type_Bbkv = new bbkv(parambbku.q);
                    return paramQQAppInterface;
                    if (!(paramObject instanceof ajhh)) {
                      break;
                    }
                    paramObject = (ajhh)paramObject;
                    paramQQAppInterface = paramObject;
                  } while (!paramObject.jdField_a_of_type_Bbkv.a(parambbku.jdField_a_of_type_Bbkv));
                  localaubr.a(paramString, 23, parambbku.jdField_a_of_type_Bbkv.b, "", 0, null);
                  return paramObject;
                  paramQQAppInterface = new ajhh(BaseApplication.getContext());
                  paramQQAppInterface.a(paramMessageRecord.senderuin);
                  paramQQAppInterface.jdField_a_of_type_Bbkv = new bbkv(parambbku.jdField_a_of_type_Bbkv);
                  localaubr.a(paramString, 23, parambbku.jdField_a_of_type_Bbkv.b, "", 0, null);
                  return paramQQAppInterface;
                  if (paramMessageRecord == null) {
                    return null;
                  }
                  paramBoolean = auqm.a(paramMessageRecord);
                  if ((paramMessageRecord.msgtype != -2035) && (paramMessageRecord.msgtype != -2038) && (!paramBoolean)) {
                    return null;
                  }
                  int i1;
                  if (paramBoolean)
                  {
                    i1 = auqm.a((MessageForStructing)paramMessageRecord);
                    if ((paramObject instanceof ajhv))
                    {
                      paramQQAppInterface = (ajhv)paramObject;
                      paramQQAppInterface.jdField_a_of_type_Bbkv.a(parambbku.h);
                      localaubr.a(paramString, 26, parambbku.h.b, "", i1, null);
                      return paramQQAppInterface;
                    }
                    paramQQAppInterface = new ajhv(BaseApplication.getContext());
                    paramQQAppInterface.jdField_a_of_type_Bbkv = new bbkv(parambbku.h);
                    localaubr.a(paramString, 26, parambbku.h.b, "", i1, null);
                    return paramQQAppInterface;
                  }
                  if ((paramMessageRecord instanceof MessageForDeliverGiftTips))
                  {
                    paramMessageRecord = (MessageForDeliverGiftTips)paramMessageRecord;
                    i1 = 1;
                    i2 = 1;
                    if (!(paramObject instanceof ajhv)) {
                      break label968;
                    }
                    paramQQAppInterface = (ajhv)paramObject;
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
                      paramQQAppInterface.jdField_a_of_type_Bbkv.a(parambbku.h);
                      localaubr.a(paramString, 26, parambbku.h.b, "", paramMessageRecord.giftCount, null);
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
                    azmj.b(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "Troop_gift", "MsgBizType.TYPE_TROOP_RECEIVED_FLOWSER_MSG, MessageRecord cast to GiftTips", 0, -1, paramMessageRecord.getClass().getName(), "", "", "");
                    return null;
                    paramObject = new ajhv(BaseApplication.getContext(), paramMessageRecord.isToAll());
                    paramObject.jdField_a_of_type_Bbkv = new bbkv(parambbku.h);
                    localaubr.a(paramString, 26, parambbku.h.b, "", paramMessageRecord.giftCount, null);
                  }
                  if ((paramObject instanceof ajhg))
                  {
                    paramQQAppInterface = (ajhg)paramObject;
                    paramObject = paramQQAppInterface;
                    if (paramQQAppInterface.jdField_a_of_type_Bbkv.a(parambbku.f))
                    {
                      localaubr.a(paramString, 14, parambbku.f.b, "", 0, null);
                      paramObject = paramQQAppInterface;
                    }
                  }
                  for (;;)
                  {
                    paramQQAppInterface = paramObject;
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.d(bbku.class.getSimpleName() + ".troop.special_msg.at_all_msg", 2, "updateMsgInfo");
                    return paramObject;
                    paramObject = new ajhg(BaseApplication.getContext());
                    paramObject.a(paramMessageRecord.senderuin);
                    paramObject.jdField_a_of_type_Bbkv = new bbkv(parambbku.f);
                    localaubr.a(paramString, 14, parambbku.f.b, "", 0, null);
                  }
                  return null;
                  if (!(paramObject instanceof bjzl)) {
                    break;
                  }
                  paramObject = (bjzl)paramObject;
                  paramQQAppInterface = paramObject;
                } while (!paramObject.jdField_a_of_type_Bbkv.a(parambbku.g));
                localaubr.a(paramString, 6, parambbku.g.b, "", 0, null);
                return paramObject;
                paramQQAppInterface = new bjzl(BaseApplication.getContext());
                paramQQAppInterface.jdField_a_of_type_Bbkv = new bbkv(parambbku.g);
                localaubr.a(paramString, 6, parambbku.g.b, "", 0, null);
                return paramQQAppInterface;
                if (paramMessageRecord == null) {
                  return null;
                }
                paramBoolean = auqm.a(paramMessageRecord);
                if ((paramMessageRecord.msgtype != -2035) && (paramMessageRecord.msgtype != -2038) && (!paramBoolean)) {
                  return null;
                }
                if (paramBoolean)
                {
                  if ((paramObject instanceof ajho))
                  {
                    paramQQAppInterface = (ajho)paramObject;
                    paramQQAppInterface.jdField_a_of_type_Bbkv.a(parambbku.i);
                    return paramQQAppInterface;
                  }
                  paramQQAppInterface = new ajho(BaseApplication.getContext());
                  paramQQAppInterface.jdField_a_of_type_Bbkv = new bbkv(parambbku.i);
                  return paramQQAppInterface;
                }
                if ((paramMessageRecord instanceof MessageForDeliverGiftTips))
                {
                  paramMessageRecord = (MessageForDeliverGiftTips)paramMessageRecord;
                  if (!(paramObject instanceof ajho)) {
                    break label1525;
                  }
                  paramString = (ajho)paramObject;
                  paramString.jdField_a_of_type_Bbkv.a(parambbku.i);
                }
                for (;;)
                {
                  if (!TextUtils.isEmpty(paramMessageRecord.remindBrief))
                  {
                    parambbku = paramMessageRecord.remindBrief.split("#");
                    if (parambbku.length > 1) {
                      paramString.jdField_a_of_type_JavaLangString = ("[" + parambbku[1] + "]");
                    }
                  }
                  paramQQAppInterface = (bcfr)paramQQAppInterface.getManager(223);
                  if (!paramQQAppInterface.a(false)) {
                    break;
                  }
                  return null;
                  azmj.b(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "Troop_gift", "MsgBizType.TYPE_TROOP_HAS_GIFT_IN_TROOP, MessageRecord cast to GiftTips error", 0, -1, paramMessageRecord.getClass().getName(), "", "", "");
                  return null;
                  paramString = new ajho(BaseApplication.getContext());
                  paramString.jdField_a_of_type_Bbkv = new bbkv(parambbku.i);
                }
                paramQQAppInterface.jdField_a_of_type_Int = 1;
                return paramString;
                if ((paramObject instanceof ajht))
                {
                  paramQQAppInterface = (ajht)paramObject;
                  paramQQAppInterface.jdField_a_of_type_Bbkv.a(parambbku.j);
                  return paramQQAppInterface;
                }
                paramQQAppInterface = new ajht(BaseApplication.getContext());
                paramQQAppInterface.jdField_a_of_type_Bbkv = new bbkv(parambbku.j);
                return paramQQAppInterface;
                if (!(paramObject instanceof ajhl)) {
                  break;
                }
                paramObject = (ajhl)paramObject;
                paramQQAppInterface = paramObject;
              } while (!paramObject.jdField_a_of_type_Bbkv.a(parambbku.k));
              localaubr.a(paramString, 18, parambbku.k.b, "", 0, null);
              return paramObject;
              paramQQAppInterface = new ajhl(BaseApplication.getContext());
              paramQQAppInterface.jdField_a_of_type_Bbkv = new bbkv(parambbku.k);
              localaubr.a(paramString, 18, parambbku.k.b, "", 0, null);
              return paramQQAppInterface;
              if (!(paramObject instanceof ajhw)) {
                break;
              }
              paramObject = (ajhw)paramObject;
              paramQQAppInterface = paramObject;
            } while (!paramObject.jdField_a_of_type_Bbkv.a(parambbku.l));
            localaubr.a(paramString, 22, parambbku.l.b, "", 0, null);
            return paramObject;
            paramQQAppInterface = new ajhw(BaseApplication.getContext());
            paramQQAppInterface.jdField_a_of_type_Bbkv = new bbkv(parambbku.l);
            localaubr.a(paramString, 22, parambbku.l.b, "", 0, null);
            return paramQQAppInterface;
            if ((!(paramObject instanceof ajhr)) || (((ajhr)paramObject).c != 1)) {
              break;
            }
            paramObject = (ajhr)paramObject;
            paramQQAppInterface = paramObject;
          } while (!paramObject.jdField_a_of_type_Bbkv.a(parambbku.n));
          localaubr.a(paramString, 4, parambbku.n.b, "", 0, null);
          return paramObject;
          paramQQAppInterface = new ajhr(BaseApplication.getContext(), 1);
          paramQQAppInterface.jdField_a_of_type_Bbkv = new bbkv(parambbku.n);
          localaubr.a(paramString, 4, parambbku.n.b, "", 0, null);
          return paramQQAppInterface;
          if ((!(paramObject instanceof ajhr)) || (((ajhr)paramObject).c != 0)) {
            break;
          }
          paramObject = (ajhr)paramObject;
          paramQQAppInterface = paramObject;
        } while (!paramObject.jdField_a_of_type_Bbkv.a(parambbku.o));
        localaubr.a(paramString, 3, parambbku.o.b, "", 0, null);
        return paramObject;
        paramQQAppInterface = new ajhr(BaseApplication.getContext(), 0);
        paramQQAppInterface.jdField_a_of_type_Bbkv = new bbkv(parambbku.o);
        localaubr.a(paramString, 3, parambbku.o.b, "", 0, null);
        return paramQQAppInterface;
      case 21: 
        label968:
        label1525:
        if ((StructMsgForGeneralShare)azqu.a(paramMessageRecord.msgData) == null)
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
      if ((paramObject instanceof ajhj))
      {
        paramQQAppInterface = (ajhj)paramObject;
        paramObject = paramQQAppInterface;
        if (paramQQAppInterface.jdField_a_of_type_Bbkv.a(parambbku.m))
        {
          localaubr.a(paramString, 21, parambbku.m.b, "", 0, null);
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
        paramObject = new ajhj(BaseApplication.getContext());
        paramObject.jdField_a_of_type_Bbkv = new bbkv(parambbku.m);
        localaubr.a(paramString, 21, parambbku.m.b, "", 0, null);
      }
      paramQQAppInterface = new ajhs(BaseApplication.getContext(), false);
      paramQQAppInterface.c = 1;
      return paramQQAppInterface;
      if ((paramObject instanceof ajhp))
      {
        paramObject = (ajhp)paramObject;
        paramQQAppInterface = paramObject;
        if (!paramObject.jdField_a_of_type_Bbkv.a(parambbku.r)) {
          break;
        }
        localaubr.a(paramString, 5, parambbku.r.b, "", 0, null);
        return paramObject;
      }
      paramQQAppInterface = new ajhp(BaseApplication.getContext());
      paramQQAppInterface.jdField_a_of_type_Bbkv = new bbkv(parambbku.r);
      localaubr.a(paramString, 5, parambbku.r.b, "", 0, null);
      return paramQQAppInterface;
      if ((paramObject instanceof ajhn))
      {
        paramObject = (ajhn)paramObject;
        paramQQAppInterface = paramObject;
        if (!paramObject.jdField_a_of_type_Bbkv.a(parambbku.s)) {
          break;
        }
        localaubr.a(paramString, 19, parambbku.s.b, "", 0, null);
        return paramObject;
      }
      paramQQAppInterface = new ajhn(BaseApplication.getContext());
      paramQQAppInterface.jdField_a_of_type_Bbkv = new bbkv(parambbku.s);
      localaubr.a(paramString, 19, parambbku.s.b, "", 0, null);
      return paramQQAppInterface;
      if ((paramObject instanceof ajhu))
      {
        paramObject = (ajhu)paramObject;
        paramQQAppInterface = paramObject;
        if (!paramObject.jdField_a_of_type_Bbkv.a(parambbku.u)) {
          break;
        }
        localaubr.a(paramString, 13, parambbku.u.b, "", 0, null);
        return paramObject;
      }
      paramQQAppInterface = new ajhu(BaseApplication.getContext());
      paramQQAppInterface.jdField_a_of_type_Bbkv = new bbkv(parambbku.u);
      localaubr.a(paramString, 13, parambbku.u.b, "", 0, null);
      return paramQQAppInterface;
      return new ajhm(BaseApplication.getContext());
      paramQQAppInterface = null;
      if ((paramMessageRecord instanceof MessageForArkApp)) {
        paramQQAppInterface = anku.a((MessageForArkApp)paramMessageRecord);
      }
      long l1;
      long l2;
      if ((paramObject instanceof ajhd))
      {
        paramObject = (ajhd)paramObject;
        if (paramQQAppInterface != null) {
          paramObject.a(paramQQAppInterface);
        }
        if (paramObject.jdField_a_of_type_Bbkv.a(parambbku.w))
        {
          localaubr.a(paramString, 20, parambbku.w.b, "", 0, null);
          return paramObject;
        }
        paramQQAppInterface = paramObject;
        if (parambbku.w == null) {
          break;
        }
        l1 = parambbku.w.a;
        l2 = parambbku.w.b;
        if (l1 != -1L)
        {
          paramObject.jdField_a_of_type_Bbkv.a = l1;
          paramObject.jdField_a_of_type_Bbkv.b = l2;
        }
        localaubr.a(paramString, 20, parambbku.w.b, "", 0, null);
        return paramObject;
      }
      paramObject = BaseApplication.getContext();
      if (paramQQAppInterface != null) {}
      for (;;)
      {
        paramQQAppInterface = new ajhd(paramObject, paramQQAppInterface);
        paramQQAppInterface.jdField_a_of_type_Bbkv = new bbkv(parambbku.w);
        localaubr.a(paramString, 20, parambbku.w.b, "", 0, null);
        return paramQQAppInterface;
        paramQQAppInterface = "";
      }
      if ((paramObject instanceof ajhx))
      {
        paramObject = (ajhx)paramObject;
        paramQQAppInterface = paramObject;
        if (!paramObject.jdField_a_of_type_Bbkv.a(parambbku.x)) {
          break;
        }
        localaubr.a(paramString, 101, parambbku.x.b, "", 0, null);
        return paramObject;
      }
      paramQQAppInterface = new ajhx(BaseApplication.getContext());
      paramQQAppInterface.jdField_a_of_type_Bbkv = new bbkv(parambbku.x);
      localaubr.a(paramString, 101, parambbku.x.b, "", 0, null);
      return paramQQAppInterface;
      String str2 = paramString + "&" + 3000;
      String str1 = "0";
      switch (parambbku.a())
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
        if ((paramObject instanceof ajhg))
        {
          paramQQAppInterface = (ajhg)paramObject;
          paramObject = str1;
          paramString = paramQQAppInterface;
          if (paramQQAppInterface.jdField_a_of_type_Bbkv.a(parambbku.f))
          {
            localaubr.a(str2, 14, parambbku.f.b, "", 0, null);
            paramObject = "AT_ALL_update";
            paramString = paramQQAppInterface;
          }
        }
        else
        {
          paramString = new ajhg(BaseApplication.getContext());
          paramString.a(paramMessageRecord.senderuin);
          paramString.jdField_a_of_type_Bbkv = new bbkv(parambbku.f);
          localaubr.a(str2, 14, parambbku.f.b, "", 0, null);
          paramObject = "AT_ALL_add";
          continue;
          if ((paramObject instanceof ajhh))
          {
            paramQQAppInterface = (ajhh)paramObject;
            paramObject = str1;
            paramString = paramQQAppInterface;
            if (paramQQAppInterface.jdField_a_of_type_Bbkv.a(parambbku.jdField_a_of_type_Bbkv))
            {
              localaubr.a(str2, 23, parambbku.jdField_a_of_type_Bbkv.b, "", 0, null);
              paramObject = "AT_ME_update";
              paramString = paramQQAppInterface;
            }
          }
          else
          {
            paramString = new ajhh(BaseApplication.getContext());
            paramString.a(paramMessageRecord.senderuin);
            paramString.jdField_a_of_type_Bbkv = new bbkv(parambbku.jdField_a_of_type_Bbkv);
            localaubr.a(str2, 23, parambbku.jdField_a_of_type_Bbkv.b, "", 0, null);
            paramObject = "AT_ME_ADD";
            continue;
            if ((paramObject instanceof ajhu))
            {
              paramQQAppInterface = (ajhu)paramObject;
              paramObject = str1;
              paramString = paramQQAppInterface;
              if (paramQQAppInterface.jdField_a_of_type_Bbkv.a(parambbku.u))
              {
                localaubr.a(str2, 13, parambbku.u.b, "", 0, null);
                paramObject = "receipt_update";
                paramString = paramQQAppInterface;
              }
            }
            else
            {
              paramString = new ajhu(BaseApplication.getContext());
              paramString.jdField_a_of_type_Bbkv = new bbkv(parambbku.u);
              localaubr.a(str2, 13, parambbku.u.b, "", 0, null);
              paramObject = "receipt_add";
              continue;
              paramQQAppInterface = null;
              if ((paramMessageRecord instanceof MessageForArkApp)) {
                paramQQAppInterface = anku.a((MessageForArkApp)paramMessageRecord);
              }
              if ((paramObject instanceof ajhd))
              {
                paramMessageRecord = (ajhd)paramObject;
                if (paramQQAppInterface != null) {
                  paramMessageRecord.a(paramQQAppInterface);
                }
                if (paramMessageRecord.jdField_a_of_type_Bbkv.a(parambbku.w))
                {
                  localaubr.a(str2, 20, parambbku.w.b, "", 0, null);
                  paramObject = str1;
                  paramString = paramMessageRecord;
                }
                else
                {
                  paramObject = str1;
                  paramString = paramMessageRecord;
                  if (parambbku.w != null)
                  {
                    l1 = parambbku.w.a;
                    l2 = parambbku.w.b;
                    if (l1 != -1L)
                    {
                      paramMessageRecord.jdField_a_of_type_Bbkv.a = l1;
                      paramMessageRecord.jdField_a_of_type_Bbkv.b = l2;
                    }
                    localaubr.a(str2, 20, parambbku.w.b, "", 0, null);
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
                  paramString = new ajhd(paramString, paramQQAppInterface);
                  paramString.jdField_a_of_type_Bbkv = new bbkv(parambbku.w);
                  localaubr.a(str2, 20, parambbku.w.b, "", 0, null);
                  paramObject = str1;
                  break;
                  paramQQAppInterface = "";
                }
                if ((paramObject instanceof ajhw))
                {
                  paramQQAppInterface = (ajhw)paramObject;
                  paramObject = str1;
                  paramString = paramQQAppInterface;
                  if (paramQQAppInterface.jdField_a_of_type_Bbkv.a(parambbku.l))
                  {
                    localaubr.a(str2, 22, parambbku.l.b, "", 0, null);
                    paramObject = str1;
                    paramString = paramQQAppInterface;
                  }
                }
                else
                {
                  paramString = new ajhw(BaseApplication.getContext());
                  paramString.jdField_a_of_type_Bbkv = new bbkv(parambbku.l);
                  localaubr.a(str2, 22, parambbku.l.b, "", 0, null);
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
    if (this.jdField_a_of_type_Bbkv.a()) {
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
        if (this.jdField_a_of_type_Bbkv.a()) {
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
    if (this.jdField_a_of_type_Bbkv.a()) {
      return this.jdField_a_of_type_Bbkv.a;
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
  
  public bbku a(bbku parambbku)
  {
    if (parambbku != null)
    {
      this.f.a(parambbku.f);
      this.jdField_a_of_type_Bbkv.a(parambbku.jdField_a_of_type_Bbkv);
      this.b.a(parambbku.b);
      this.c.a(parambbku.c);
      this.e.a(parambbku.e);
      this.d.a(parambbku.d);
      this.g.a(parambbku.g);
      this.h.a(parambbku.h);
      this.i.a(parambbku.i);
      this.j.a(parambbku.j);
      this.k.a(parambbku.k);
      this.l.a(parambbku.l);
      this.m.a(parambbku.m);
      this.n.a(parambbku.n);
      this.o.a(parambbku.o);
      this.p.a(parambbku.p);
      this.q.a(parambbku.q);
      this.r.a(parambbku.r);
      this.s.a(parambbku.s);
      this.t.a(parambbku.t);
      this.u.a(parambbku.u);
      this.v.a(parambbku.v);
      this.w.a(parambbku.w);
      this.x.a(parambbku.x);
    }
    return this;
  }
  
  public void a()
  {
    this.f.a();
    this.jdField_a_of_type_Bbkv.a();
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
    return (this.f.a()) || (this.jdField_a_of_type_Bbkv.a()) || (this.c.a()) || (this.e.a()) || (this.d.a()) || (this.g.a()) || (this.h.a()) || (this.b.a()) || (this.i.a()) || (this.k.a()) || (this.j.a()) || (this.l.a()) || (this.o.a()) || (this.n.a()) || (this.m.a()) || (this.p.a()) || (this.q.a()) || (this.r.a()) || (this.s.a()) || (this.t.a()) || (this.v.a()) || (this.u.a()) || (this.w.a()) || (this.x.a());
  }
  
  public long b()
  {
    if (this.h.a()) {
      return this.h.a;
    }
    if (this.jdField_a_of_type_Bbkv.a()) {
      return this.jdField_a_of_type_Bbkv.a;
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
 * Qualified Name:     bbku
 * JD-Core Version:    0.7.0.1
 */