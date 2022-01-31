import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity;
import com.tencent.mobileqq.activity.aio.confess.ConfessPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.confess.TroopConfessUtil.1;
import com.tencent.mobileqq.confess.data.TroopConfessMsg;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype21;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class aojt
{
  public static final String a = alud.a(2131715669);
  
  public static String a(String paramString1, String paramString2)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        Object localObject2 = paramString1.split("&");
        localObject1 = paramString1;
        if (i < localObject2.length)
        {
          String[] arrayOfString = bdib.a(localObject2[i], "=");
          if ((arrayOfString.length != 2) || (!"url_prefix".equals(arrayOfString[0])) || (TextUtils.isEmpty(arrayOfString[1]))) {
            continue;
          }
          String str = arrayOfString[0] + "=" + arrayOfString[1];
          localObject2 = new String(bdfr.decode(arrayOfString[1], 0));
          localObject1 = localObject2;
          if (!((String)localObject2).contains("&gc=")) {
            localObject1 = String.format("%s&gc=%s", new Object[] { localObject2, auwx.a(paramString2) });
          }
          paramString2 = bdfr.encodeToString(((String)localObject1).getBytes(), 2);
          localObject1 = paramString1.replace(str, arrayOfString[0] + "=" + paramString2);
        }
      }
      catch (Exception paramString2)
      {
        Object localObject1 = paramString1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.msg.TroopConfess", 2, paramString2.getMessage(), paramString2);
      }
      return localObject1;
      i += 1;
    }
    return paramString1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    for (;;)
    {
      try
      {
        localObject = ((aoiu)paramQQAppInterface.getManager(269)).b();
        if (localObject != null) {
          continue;
        }
        localObject = "https://ti.qq.com/honest-say/group-received.html?_bid=3104&_wv=9191&_qStyle=1";
      }
      catch (Exception paramContext)
      {
        Object localObject;
        StringBuilder localStringBuilder;
        continue;
        if (paramInt1 != 1) {
          continue;
        }
        String str = "aio_card_say";
        continue;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject).append("&").append("adtag").append("=").append(str);
      localStringBuilder.append("&").append("quin").append("=").append(auwx.a(paramString1));
      localStringBuilder.append("&").append("topicId").append("=").append(paramInt2);
      localStringBuilder.append("&").append("sUin").append("=").append(auwx.a(paramString2));
      localStringBuilder.append("&").append("rUin").append("=").append(auwx.a(paramString3));
      paramString1 = localStringBuilder.toString();
      paramString2 = new Intent(paramContext, QQBrowserActivity.class);
      paramString2.putExtra("url", paramString1);
      paramContext.startActivity(paramString2);
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.TroopConfess", 2, "onGroupAioConfessClick " + paramString1);
      }
      ThreadManager.post(new TroopConfessUtil.1(paramQQAppInterface, paramString3, paramInt1), 5, null, true);
      return;
      localObject = ((aoiq)localObject).o;
      continue;
      str = "aio_card_insert";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a(paramBoolean);
  }
  
  public static void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    if ((paramList1 == null) || (paramList == null) || (paramList.size() == 0)) {}
    label258:
    label267:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.TroopConfess", 2, "decodeTroopConfessMsgElem");
      }
      paramMsg = paramList.iterator();
      for (;;)
      {
        label39:
        if (!paramMsg.hasNext()) {
          break label267;
        }
        paramStringBuilder = (im_msg_body.Elem)paramMsg.next();
        if ((paramStringBuilder.common_elem.has()) && (paramStringBuilder.common_elem.uint32_service_type.get() == 21) && (paramStringBuilder.common_elem.uint32_business_type.get() == 3) && (paramStringBuilder.common_elem.bytes_pb_elem.has()))
        {
          for (;;)
          {
            try
            {
              paramList = new hummer_commelem.MsgElemInfo_servtype21();
            }
            catch (InvalidProtocolBufferMicroException paramStringBuilder)
            {
              try
              {
                paramList.mergeFrom(paramStringBuilder.common_elem.bytes_pb_elem.get().toByteArray());
                if (paramList == null) {
                  break;
                }
                paramStringBuilder = new TroopConfessMsg();
                paramStringBuilder.convertFrom(paramList);
                if (QLog.isColorLevel()) {
                  QLog.i("Q.msg.TroopConfess", 2, String.format("decodeTroopConfessMsgElem %s", new Object[] { paramStringBuilder.toString() }));
                }
                paramList = (MessageForTroopConfess)azaf.a(-2067);
                paramList.msgtype = -2067;
                paramList.msg = paramStringBuilder.getSimpleMsg();
                paramList.msgData = paramStringBuilder.getBytes();
                paramList.isToSelf = paramStringBuilder.isToSelf();
                if (paramList.msgData != null) {
                  break label258;
                }
                if (!QLog.isColorLevel()) {
                  break label39;
                }
                QLog.i("Q.msg.TroopConfess", 2, "decode msgData null");
              }
              catch (InvalidProtocolBufferMicroException paramStringBuilder)
              {
                break label251;
              }
              paramStringBuilder = paramStringBuilder;
              paramList = null;
            }
            label251:
            paramStringBuilder.printStackTrace();
          }
          paramList1.add(paramList);
        }
      }
    }
  }
  
  public static boolean a(BaseChatPie paramBaseChatPie)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.a() == null)) {
      return false;
    }
    int i = ConfessPanel.a(paramBaseChatPie.a().getResources().getDisplayMetrics().widthPixels);
    int j = ConfessPanel.a(paramBaseChatPie);
    i = ConfessPanel.a(paramBaseChatPie.a().getResources(), i, j);
    if (QLog.isColorLevel()) {
      QLog.i("TroopConfessUtil", 2, String.format("showConfessPanel dstHeight=%d", new Object[] { Integer.valueOf(i) }));
    }
    String str = paramBaseChatPie.a().getIntent().getStringExtra("url");
    Intent localIntent = new Intent(paramBaseChatPie.a(), ConfessHalfScreenActivity.class);
    localIntent.putExtra("finish_animation_up_down", true);
    localIntent.putExtra("url", str);
    localIntent.putExtra("isTransparentTitle", true);
    localIntent.putExtra("confessDstHeight", i);
    localIntent.addFlags(603979776);
    paramBaseChatPie.a().startActivityForResult(localIntent, 15002);
    paramBaseChatPie.a().overridePendingTransition(2130771979, 0);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.e();
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.isOpenTroopMessage) {
      return true;
    }
    if (paramMessageRecord.istroop == 1)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.d())) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((amdu)paramQQAppInterface.a(20)).b(paramString, false);
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString);
    return (paramQQAppInterface != null) && ((paramQQAppInterface.dwGroupFlagExt3 & 0x2000) == 0L);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.msgtype == -2067;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString2 = paramString2.split("\\|");
      bool1 = bool2;
      if (paramString2 != null)
      {
        j = paramString2.length;
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (paramString2[i].equalsIgnoreCase(paramString1)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static Object[] a(String paramString)
  {
    ArrayList localArrayList = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.TroopConfess", 2, "TroopConfessUtil.getTroopMembers " + paramString);
    }
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localObject1 = null)
    {
      if (localObject1 == null) {}
      String str;
      do
      {
        return null;
        str = ((QQAppInterface)localObject1).getCurrentAccountUin();
      } while (TextUtils.isEmpty(str));
      Object localObject2 = (TroopManager)((QQAppInterface)localObject1).getManager(52);
      int i;
      boolean bool1;
      if (localObject2 != null)
      {
        localObject2 = ((TroopManager)localObject2).b(paramString);
        if (localObject2 != null) {
          if (bdeu.a(str, ((TroopInfo)localObject2).troopowneruin))
          {
            i = 2;
            if ((((TroopInfo)localObject2).dwGroupFlagExt & 0x80) != 0L) {
              break label248;
            }
            bool1 = true;
          }
        }
      }
      for (;;)
      {
        label141:
        if ((i > 0) || (bool1))
        {
          bool2 = true;
          label152:
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.TroopConfess", 2, String.format("TroopConfessUtil.getTroopMembers canInvite=%s memLevel:%d", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i) }));
          }
          if (bool2) {
            break label265;
          }
          if (i <= 0) {
            break label259;
          }
        }
        label259:
        for (boolean bool2 = true;; bool2 = false)
        {
          return new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), null };
          if (a(str, ((TroopInfo)localObject2).Administrator))
          {
            i = 1;
            break;
          }
          i = 0;
          break;
          label248:
          bool1 = false;
          break label141;
          bool2 = false;
          break label152;
        }
        label265:
        localObject1 = ((QQAppInterface)localObject1).getEntityManagerFactory().createEntityManager();
        if (localObject1 != null)
        {
          paramString = ((awgf)localObject1).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
          ((awgf)localObject1).a();
        }
        for (;;)
        {
          localObject1 = localArrayList;
          if (paramString != null)
          {
            localArrayList = new ArrayList(paramString.size());
            paramString = paramString.iterator();
            for (;;)
            {
              localObject1 = localArrayList;
              if (!paramString.hasNext()) {
                break;
              }
              localObject1 = (TroopMemberInfo)paramString.next();
              if (bdeu.d(((TroopMemberInfo)localObject1).memberuin)) {
                localArrayList.add(((TroopMemberInfo)localObject1).memberuin);
              }
            }
          }
          int j;
          if (QLog.isColorLevel())
          {
            if (localObject1 == null)
            {
              j = 0;
              QLog.i("Q.msg.TroopConfess", 2, String.format("TroopConfessUtil.getTroopMembers findUins:%d", new Object[] { Integer.valueOf(j) }));
            }
          }
          else {
            if (i <= 0) {
              break label466;
            }
          }
          label466:
          for (bool2 = true;; bool2 = false)
          {
            return new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), localObject1 };
            j = ((ArrayList)localObject1).size();
            break;
          }
          paramString = null;
        }
        bool1 = false;
        i = 0;
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(paramBoolean);
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    paramMessageRecord = bcmm.a(paramMessageRecord);
    boolean bool1 = bool2;
    if (paramMessageRecord != null)
    {
      bool1 = bool2;
      if (paramMessageRecord.a == 3) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean c(MessageRecord paramMessageRecord)
  {
    return (a(paramMessageRecord)) && (b(paramMessageRecord));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aojt
 * JD-Core Version:    0.7.0.1
 */