import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardMobileInfo;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.businessCard.data.CardUinInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.CardInfo;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.MobileInfo;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.OCRInfo;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.RequestAdd;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.RequestCardDetail;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.RequestCardList;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.RequestDel;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.RequestModify;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.ResponseAdd;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.ResponseCardDetail;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.ResponseCardList;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.UinInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aqjo
  extends MSFServlet
{
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    Bundle localBundle = new Bundle();
    if (bool2) {}
    for (;;)
    {
      try
      {
        Object localObject1 = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject1).getInt() - 4];
        ((ByteBuffer)localObject1).get(paramFromServiceMsg);
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom(paramFromServiceMsg);
        int i = ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.get();
        localBundle.putInt("resp_result", i);
        if (QLog.isColorLevel()) {
          QLog.d("BusinessCard_Servlet", 2, "respAddCard | is success, and result=" + i);
        }
        if ((i != 0) || (!((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.get() == null)) {
          continue;
        }
        paramFromServiceMsg = (QQAppInterface)getAppRuntime();
        localObject1 = ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.get().toByteArray();
        Object localObject2 = new Oidb_0x43c.ResponseAdd();
        ((Oidb_0x43c.ResponseAdd)localObject2).mergeFrom((byte[])localObject1);
        if (((Oidb_0x43c.ResponseAdd)localObject2).card_id.has())
        {
          localObject1 = ((Oidb_0x43c.ResponseAdd)localObject2).card_id.get().toStringUtf8();
          localObject2 = (BusinessCard)paramIntent.getExtras().getParcelable("key_card_info");
          bool1 = paramIntent.getBooleanExtra("key_is_mine", false);
          if (localObject2 != null)
          {
            ((BusinessCard)localObject2).cardId = ((String)localObject1);
            localBundle.putString("key_card_id", (String)localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("BusinessCard_Servlet", 2, "respAddCard | is success cardId=" + (String)localObject1);
            }
            a(paramFromServiceMsg, (String)localObject1, bool1, 1);
          }
        }
        bool1 = bool2;
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        QLog.w("BusinessCard_Servlet", 2, paramFromServiceMsg.getMessage());
        bool1 = false;
        continue;
      }
      notifyObserver(paramIntent, 1, bool1, localBundle, aqjn.class);
      return;
      boolean bool1 = false;
      continue;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("BusinessCard_Servlet", 2, "$$respAddCard | is not success");
        bool1 = bool2;
      }
    }
  }
  
  private void a(Intent paramIntent, Packet paramPacket)
  {
    BusinessCard localBusinessCard = (BusinessCard)paramIntent.getExtras().getParcelable("key_card_info");
    Oidb_0x43c.CardInfo localCardInfo = new Oidb_0x43c.CardInfo();
    if (!TextUtils.isEmpty(localBusinessCard.picUrl)) {
      localCardInfo.pic_url.set(localBusinessCard.picUrl);
    }
    if (!TextUtils.isEmpty(localBusinessCard.cardName)) {
      localCardInfo.name.set(localBusinessCard.cardName);
    }
    if (!TextUtils.isEmpty(localBusinessCard.company)) {
      localCardInfo.company.set(localBusinessCard.company);
    }
    Object localObject1 = localBusinessCard.qqNum.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localCardInfo.uins.add(Long.valueOf(Long.parseLong((String)localObject2)));
    }
    localObject1 = localBusinessCard.mobilesNum.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localCardInfo.mobiles.add(localObject2);
    }
    localObject1 = localBusinessCard.descs.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localCardInfo.descs.add(localObject2);
    }
    if (!TextUtils.isEmpty(localBusinessCard.bindUin)) {}
    try
    {
      localCardInfo.bind_uin.set(Long.parseLong(localBusinessCard.bindUin));
      label269:
      if (!TextUtils.isEmpty(localBusinessCard.bindMobile)) {
        localCardInfo.bind_mbl.set(localBusinessCard.bindMobile);
      }
      localCardInfo.card_src.set(localBusinessCard.cardSrc);
      if (localBusinessCard.OCRInfo != null)
      {
        localObject1 = new Oidb_0x43c.OCRInfo();
        ((Oidb_0x43c.OCRInfo)localObject1).name.set(localBusinessCard.OCRInfo.jdField_a_of_type_JavaLangString);
        localObject2 = localBusinessCard.OCRInfo.jdField_a_of_type_JavaUtilList.iterator();
        String str;
        while (((Iterator)localObject2).hasNext())
        {
          str = (String)((Iterator)localObject2).next();
          if ((str != null) && (str.length() > 0)) {
            ((Oidb_0x43c.OCRInfo)localObject1).uins.add(Long.valueOf(Long.parseLong(str)));
          }
        }
        localObject2 = localBusinessCard.OCRInfo.jdField_b_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str = (String)((Iterator)localObject2).next();
          if (str.length() > 0) {
            ((Oidb_0x43c.OCRInfo)localObject1).mobiles.add(str);
          }
        }
        ((Oidb_0x43c.OCRInfo)localObject1).name_dependLevel.set(localBusinessCard.OCRInfo.jdField_a_of_type_Float);
        ((Oidb_0x43c.OCRInfo)localObject1).uins_dependLevel.set(localBusinessCard.OCRInfo.jdField_b_of_type_Float);
        ((Oidb_0x43c.OCRInfo)localObject1).mobiles_dependLevel.set(localBusinessCard.OCRInfo.c);
        localCardInfo.ocr_info.set((MessageMicro)localObject1);
      }
      localObject1 = new Oidb_0x43c.RequestAdd();
      ((Oidb_0x43c.RequestAdd)localObject1).card_info.set(localCardInfo);
      boolean bool = paramIntent.getBooleanExtra("key_is_mine", false);
      if (bool)
      {
        ((Oidb_0x43c.RequestAdd)localObject1).isMine.set(bool);
        localBusinessCard.cardType = 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard_Servlet", 2, "reqAddCard: card=" + localBusinessCard);
      }
      a(((Oidb_0x43c.RequestAdd)localObject1).toByteArray(), 1, "OidbSvc.0x43c_1", paramPacket);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label269;
    }
  }
  
  private void a(aqjm paramaqjm, ArrayList<BusinessCard> paramArrayList, Oidb_0x43c.ResponseCardList paramResponseCardList)
  {
    paramResponseCardList = paramResponseCardList.others.get().iterator();
    while (paramResponseCardList.hasNext())
    {
      Oidb_0x43c.CardInfo localCardInfo = (Oidb_0x43c.CardInfo)paramResponseCardList.next();
      BusinessCard localBusinessCard = new BusinessCard();
      a(localBusinessCard, localCardInfo);
      if (localBusinessCard.cardId != null)
      {
        paramArrayList.add(localBusinessCard);
        paramaqjm.a(localBusinessCard);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), aqjo.class);
    localNewIntent.putExtra("key_cmd_type", 4);
    localNewIntent.putExtra("req_get_list_seq", paramInt1);
    localNewIntent.putExtra("req_get_list_nextFlag", paramInt2);
    localNewIntent.putExtra("req_get_list_first", paramBoolean);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BusinessCard paramBusinessCard, boolean paramBoolean)
  {
    if (paramBusinessCard == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), aqjo.class);
    localNewIntent.putExtra("key_cmd_type", 1);
    localNewIntent.putExtra("key_card_info", paramBusinessCard);
    localNewIntent.putExtra("key_is_mine", paramBoolean);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), aqjo.class);
    localNewIntent.putExtra("key_cmd_type", 5);
    localNewIntent.putExtra("key_card_id", paramString);
    localNewIntent.putExtra("key_is_mine", paramBoolean);
    localNewIntent.putExtra("key_get_detail_type", paramInt);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(BusinessCard paramBusinessCard, Oidb_0x43c.CardInfo paramCardInfo)
  {
    Object localObject2 = null;
    if (paramCardInfo == null) {}
    for (;;)
    {
      return;
      paramBusinessCard.cardId = paramCardInfo.card_id.get().toStringUtf8();
      if (paramCardInfo.name.has())
      {
        localObject1 = paramCardInfo.name.get();
        paramBusinessCard.cardName = ((String)localObject1);
        if (!paramCardInfo.company.has()) {
          break label228;
        }
        localObject1 = paramCardInfo.company.get();
        label66:
        paramBusinessCard.company = ((String)localObject1);
        if (!paramCardInfo.pic_url.has()) {
          break label234;
        }
        localObject1 = paramCardInfo.pic_url.get();
        label91:
        paramBusinessCard.picUrl = ((String)localObject1);
        if (!paramCardInfo.bind_uin.has()) {
          break label240;
        }
      }
      long l;
      label228:
      label234:
      label240:
      for (Object localObject1 = String.valueOf(paramCardInfo.bind_uin.get());; localObject1 = null)
      {
        paramBusinessCard.bindUin = ((String)localObject1);
        paramBusinessCard.lastUpdateTime = paramCardInfo.last_update_time.get();
        paramBusinessCard.cardSrc = paramCardInfo.card_src.get();
        if ((!paramCardInfo.uins.has()) || (paramCardInfo.uins.get() == null)) {
          break label246;
        }
        localObject1 = paramCardInfo.uins.get().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          l = ((Long)((Iterator)localObject1).next()).longValue();
          paramBusinessCard.qqNum.add(String.valueOf(l));
        }
        localObject1 = null;
        break;
        localObject1 = null;
        break label66;
        localObject1 = null;
        break label91;
      }
      label246:
      Object localObject3;
      Object localObject4;
      boolean bool;
      if ((paramCardInfo.uin_info.has()) && (paramCardInfo.uin_info.get() != null))
      {
        localObject1 = paramCardInfo.uin_info.get().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Oidb_0x43c.UinInfo)((Iterator)localObject1).next();
          localObject4 = new CardUinInfo();
          ((CardUinInfo)localObject4).jdField_a_of_type_JavaLangString = String.valueOf(((Oidb_0x43c.UinInfo)localObject3).uin.get());
          if ((((Oidb_0x43c.UinInfo)localObject3).isFriend.has()) && (((Oidb_0x43c.UinInfo)localObject3).isFriend.get()))
          {
            bool = true;
            label352:
            ((CardUinInfo)localObject4).jdField_a_of_type_Boolean = bool;
            if ((!((Oidb_0x43c.UinInfo)localObject3).isSearchable.has()) || (!((Oidb_0x43c.UinInfo)localObject3).isSearchable.get())) {
              break label412;
            }
          }
          label412:
          for (bool = true;; bool = false)
          {
            ((CardUinInfo)localObject4).b = bool;
            paramBusinessCard.uinInfos.add(localObject4);
            break;
            bool = false;
            break label352;
          }
        }
      }
      if ((paramCardInfo.mobiles.has()) && (paramCardInfo.mobiles.get() != null))
      {
        localObject1 = paramCardInfo.mobiles.get().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          paramBusinessCard.mobilesNum.add(localObject3);
        }
      }
      if ((paramCardInfo.descs.has()) && (paramCardInfo.descs.get() != null))
      {
        localObject1 = paramCardInfo.descs.get().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          paramBusinessCard.descs.add(localObject3);
        }
      }
      if ((paramCardInfo.mobile_info.has()) && (paramCardInfo.mobile_info.get() != null))
      {
        localObject3 = paramCardInfo.mobile_info.get().iterator();
        if (((Iterator)localObject3).hasNext())
        {
          Oidb_0x43c.MobileInfo localMobileInfo = (Oidb_0x43c.MobileInfo)((Iterator)localObject3).next();
          localObject4 = new CardMobileInfo();
          if (localMobileInfo.mobile.has())
          {
            localObject1 = localMobileInfo.mobile.get();
            label646:
            ((CardMobileInfo)localObject4).jdField_a_of_type_JavaLangString = ((String)localObject1);
            if ((!localMobileInfo.isFriend.has()) || (!localMobileInfo.isFriend.get())) {
              break label788;
            }
            bool = true;
            label678:
            ((CardMobileInfo)localObject4).jdField_a_of_type_Boolean = bool;
            if (!((CardMobileInfo)localObject4).jdField_a_of_type_Boolean) {
              break label794;
            }
            ((CardMobileInfo)localObject4).jdField_b_of_type_JavaLangString = String.valueOf(localMobileInfo.bind_uin.get());
            label709:
            if (!localMobileInfo.nick_name.has()) {
              break label805;
            }
            localObject1 = localMobileInfo.nick_name.get();
            label730:
            ((CardMobileInfo)localObject4).c = ((String)localObject1);
            if (!localMobileInfo.format_mobile.has()) {
              break label813;
            }
          }
          label788:
          label794:
          label805:
          label813:
          for (localObject1 = localMobileInfo.format_mobile.get();; localObject1 = "")
          {
            ((CardMobileInfo)localObject4).d = ((String)localObject1);
            paramBusinessCard.mobileInfos.add(localObject4);
            break;
            localObject1 = "";
            break label646;
            bool = false;
            break label678;
            ((CardMobileInfo)localObject4).jdField_b_of_type_JavaLangString = "";
            break label709;
            localObject1 = "";
            break label730;
          }
        }
      }
      if (paramCardInfo.ocr_info.has())
      {
        localObject3 = (Oidb_0x43c.OCRInfo)paramCardInfo.ocr_info.get();
        localObject4 = new CardOCRInfo();
        if (((Oidb_0x43c.OCRInfo)localObject3).name.has()) {}
        for (localObject1 = ((Oidb_0x43c.OCRInfo)localObject3).name.get();; localObject1 = "")
        {
          ((CardOCRInfo)localObject4).jdField_a_of_type_JavaLangString = ((String)localObject1);
          localObject1 = localObject2;
          if (paramCardInfo.pic_url.has()) {
            localObject1 = paramCardInfo.pic_url.get();
          }
          ((CardOCRInfo)localObject4).jdField_b_of_type_JavaLangString = ((String)localObject1);
          paramCardInfo = ((Oidb_0x43c.OCRInfo)localObject3).uins.get().iterator();
          while (paramCardInfo.hasNext())
          {
            l = ((Long)paramCardInfo.next()).longValue();
            ((CardOCRInfo)localObject4).jdField_a_of_type_JavaUtilList.add(String.valueOf(l));
          }
        }
        paramCardInfo = ((Oidb_0x43c.OCRInfo)localObject3).mobiles.get().iterator();
        while (paramCardInfo.hasNext())
        {
          localObject1 = (String)paramCardInfo.next();
          ((CardOCRInfo)localObject4).jdField_b_of_type_JavaUtilList.add(localObject1);
        }
        ((CardOCRInfo)localObject4).jdField_a_of_type_Float = ((Oidb_0x43c.OCRInfo)localObject3).name_dependLevel.get();
        ((CardOCRInfo)localObject4).jdField_b_of_type_Float = ((Oidb_0x43c.OCRInfo)localObject3).uins_dependLevel.get();
        ((CardOCRInfo)localObject4).c = ((Oidb_0x43c.OCRInfo)localObject3).mobiles_dependLevel.get();
      }
      for (paramBusinessCard.OCRInfo = ((CardOCRInfo)localObject4); QLog.isColorLevel(); paramBusinessCard.OCRInfo = null)
      {
        QLog.d("BusinessCard_Servlet", 2, "decodeBuinessCard card=" + paramBusinessCard);
        return;
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt, String paramString, Packet paramPacket)
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1084);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(paramInt);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramArrayOfByte = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localObject = ByteBuffer.allocate(paramArrayOfByte.length + 4);
    ((ByteBuffer)localObject).putInt(paramArrayOfByte.length + 4).put(paramArrayOfByte);
    paramPacket.setSSOCommand(paramString);
    paramPacket.putSendData(((ByteBuffer)localObject).array());
    paramPacket.setTimeout(30000L);
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = false;
    boolean bool1 = paramFromServiceMsg.isSuccess();
    Bundle localBundle = new Bundle();
    String str = paramIntent.getStringExtra("key_card_id");
    localBundle.putString("key_card_id", str);
    if (bool1) {}
    for (;;)
    {
      try
      {
        Object localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        localObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramFromServiceMsg);
        int i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("BusinessCard_Servlet", 2, "respDelCard | del cardId = " + str + ",result=" + i);
        }
        if (((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get() != 0) {
          continue;
        }
        paramFromServiceMsg = (aqjm)((QQAppInterface)getAppRuntime()).getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
        localObject = paramFromServiceMsg.a(str);
        if ((localObject != null) && (!TextUtils.isEmpty(((BusinessCard)localObject).bindUin))) {
          paramFromServiceMsg.b(((BusinessCard)localObject).bindUin);
        }
        paramFromServiceMsg.a(str);
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        QLog.w("BusinessCard_Servlet", 2, paramFromServiceMsg.getMessage());
        bool1 = bool2;
        continue;
      }
      notifyObserver(paramIntent, 2, bool1, localBundle, aqjn.class);
      return;
      bool1 = false;
    }
  }
  
  private void b(Intent paramIntent, Packet paramPacket)
  {
    Oidb_0x43c.RequestDel localRequestDel = new Oidb_0x43c.RequestDel();
    paramIntent = paramIntent.getStringExtra("key_card_id");
    localRequestDel.card_id.set(ByteStringMicro.copyFromUtf8(paramIntent));
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_Servlet", 2, "reqDelCard: id=" + paramIntent);
    }
    a(localRequestDel.toByteArray(), 2, "OidbSvc.0x43c_2", paramPacket);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, BusinessCard paramBusinessCard, boolean paramBoolean)
  {
    if (paramBusinessCard == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), aqjo.class);
    localNewIntent.putExtra("key_cmd_type", 3);
    localNewIntent.putExtra("key_card_info", paramBusinessCard);
    localNewIntent.putExtra("key_is_mine", paramBoolean);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = false;
    boolean bool1 = paramFromServiceMsg.isSuccess();
    Bundle localBundle = new Bundle();
    BusinessCard localBusinessCard = (BusinessCard)paramIntent.getParcelableExtra("key_card_info");
    localBundle.putString("key_card_id", localBusinessCard.cardId);
    if (bool1) {}
    for (;;)
    {
      try
      {
        Object localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        localObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramFromServiceMsg);
        int i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("BusinessCard_Servlet", 2, "RespModifyCard | is success and result = " + i);
        }
        if (i != 0) {
          continue;
        }
        paramFromServiceMsg = (QQAppInterface)getAppRuntime();
        boolean bool3 = paramIntent.getBooleanExtra("key_is_mine", false);
        a(paramFromServiceMsg, localBusinessCard.cardId, bool3, 2);
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        QLog.w("BusinessCard_Servlet", 2, paramFromServiceMsg.getMessage());
        bool1 = bool2;
        continue;
      }
      notifyObserver(paramIntent, 3, bool1, localBundle, aqjn.class);
      return;
      bool1 = false;
    }
  }
  
  private void c(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = (BusinessCard)paramIntent.getExtras().getParcelable("key_card_info");
    Oidb_0x43c.CardInfo localCardInfo = new Oidb_0x43c.CardInfo();
    localCardInfo.card_id.set(ByteStringMicro.copyFromUtf8(paramIntent.cardId));
    if (!TextUtils.isEmpty(paramIntent.picUrl)) {
      localCardInfo.pic_url.set(paramIntent.picUrl);
    }
    if (!TextUtils.isEmpty(paramIntent.cardName)) {
      localCardInfo.name.set(paramIntent.cardName);
    }
    if (!TextUtils.isEmpty(paramIntent.company)) {
      localCardInfo.company.set(paramIntent.company);
    }
    Object localObject1 = paramIntent.qqNum.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localCardInfo.uins.add(Long.valueOf(Long.parseLong((String)localObject2)));
    }
    localObject1 = paramIntent.mobilesNum.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localCardInfo.mobiles.add(localObject2);
    }
    localObject1 = paramIntent.descs.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localCardInfo.descs.add(localObject2);
    }
    if (!TextUtils.isEmpty(paramIntent.bindUin)) {}
    try
    {
      localCardInfo.bind_uin.set(Long.parseLong(paramIntent.bindUin));
      label263:
      if (!TextUtils.isEmpty(paramIntent.bindMobile)) {
        localCardInfo.bind_mbl.set(paramIntent.bindMobile);
      }
      if (paramIntent.OCRInfo != null)
      {
        localObject1 = new Oidb_0x43c.OCRInfo();
        ((Oidb_0x43c.OCRInfo)localObject1).name.set(paramIntent.OCRInfo.jdField_a_of_type_JavaLangString);
        localObject2 = paramIntent.OCRInfo.jdField_a_of_type_JavaUtilList.iterator();
        String str;
        while (((Iterator)localObject2).hasNext())
        {
          str = (String)((Iterator)localObject2).next();
          if (str.length() > 0) {
            ((Oidb_0x43c.OCRInfo)localObject1).uins.add(Long.valueOf(Long.parseLong(str)));
          }
        }
        localObject2 = paramIntent.OCRInfo.jdField_b_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str = (String)((Iterator)localObject2).next();
          if (str.length() > 0) {
            ((Oidb_0x43c.OCRInfo)localObject1).mobiles.add(str);
          }
        }
        ((Oidb_0x43c.OCRInfo)localObject1).name_dependLevel.set(paramIntent.OCRInfo.jdField_a_of_type_Float);
        ((Oidb_0x43c.OCRInfo)localObject1).uins_dependLevel.set(paramIntent.OCRInfo.jdField_b_of_type_Float);
        ((Oidb_0x43c.OCRInfo)localObject1).mobiles_dependLevel.set(paramIntent.OCRInfo.c);
        localCardInfo.ocr_info.set((MessageMicro)localObject1);
      }
      localObject1 = new Oidb_0x43c.RequestModify();
      ((Oidb_0x43c.RequestModify)localObject1).card_info.set(localCardInfo);
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard_Servlet", 2, "reqModifyCard:" + paramIntent);
      }
      a(((Oidb_0x43c.RequestModify)localObject1).toByteArray(), 3, "OidbSvc.0x43c_3", paramPacket);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label263;
    }
  }
  
  private void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    Bundle localBundle = new Bundle();
    String str = paramIntent.getStringExtra("key_card_id");
    localBundle.putString("key_card_id", str);
    localBundle.putInt("key_get_detail_type", paramIntent.getIntExtra("key_get_detail_type", 3));
    label368:
    boolean bool1;
    if (bool2)
    {
      try
      {
        localObject1 = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject1).getInt() - 4];
        ((ByteBuffer)localObject1).get(paramFromServiceMsg);
        Object localObject2 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject2).mergeFrom(paramFromServiceMsg);
        int i = ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("BusinessCard_Servlet", 2, "respGetDetailCardInfo | is success, and result=" + i);
        }
        if ((i != 0) || (!((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.get() == null)) {
          break label461;
        }
        paramFromServiceMsg = (QQAppInterface)getAppRuntime();
        localObject1 = (aqjm)paramFromServiceMsg.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
        localObject3 = ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.get().toByteArray();
        localObject2 = new Oidb_0x43c.ResponseCardDetail();
        ((Oidb_0x43c.ResponseCardDetail)localObject2).mergeFrom((byte[])localObject3);
        if ((!((Oidb_0x43c.ResponseCardDetail)localObject2).card_id.has()) || (!((Oidb_0x43c.ResponseCardDetail)localObject2).card_id.get().toStringUtf8().equals(str))) {
          break label401;
        }
        localObject3 = new BusinessCard();
        localObject2 = (Oidb_0x43c.CardInfo)((Oidb_0x43c.ResponseCardDetail)localObject2).card_info.get();
        a((BusinessCard)localObject3, (Oidb_0x43c.CardInfo)localObject2);
        if (!paramIntent.getBooleanExtra("key_is_mine", false)) {
          break label418;
        }
        ((BusinessCard)localObject3).cardType = 1;
        if (((Oidb_0x43c.CardInfo)localObject2).ocr_info.has()) {
          ((aqjm)localObject1).b((BusinessCard)localObject3);
        }
        if (TextUtils.isEmpty(((BusinessCard)localObject3).bindUin)) {
          break label368;
        }
        if (!((anvk)paramFromServiceMsg.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(((BusinessCard)localObject3).bindUin)) {
          break label448;
        }
        ((aqjm)localObject1).a(((BusinessCard)localObject3).bindUin, (BusinessCard)localObject3);
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject3;
          label401:
          paramFromServiceMsg.printStackTrace();
          QLog.w("BusinessCard_Servlet", 2, paramFromServiceMsg.getMessage());
          bool1 = false;
          continue;
          ((aqjm)localObject1).b(((BusinessCard)localObject3).bindUin);
          continue;
          bool1 = false;
        }
      }
      if (paramIntent.getIntExtra("key_get_detail_type", 3) == 1) {
        ((aqjm)localObject1).a(1, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard_Servlet", 2, "respGetDetailCardInfo | is success, and cardId=" + str);
      }
      bool1 = bool2;
    }
    for (;;)
    {
      notifyObserver(paramIntent, 5, bool1, localBundle, aqjn.class);
      return;
      label418:
      ((BusinessCard)localObject3).cardType = 0;
      break;
      label448:
      label461:
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("BusinessCard_Servlet", 2, "respGetDetailCardInfo | is not success");
        bool1 = bool2;
      }
    }
  }
  
  private void d(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("req_get_list_seq", -1);
    int j = paramIntent.getIntExtra("req_get_list_nextFlag", 0);
    paramIntent = new Oidb_0x43c.RequestCardList();
    paramIntent.req_num.set(i);
    paramIntent.next_flag.set(j);
    paramIntent.req_num.set(10);
    a(paramIntent.toByteArray(), 4, "OidbSvc.0x43c_4", paramPacket);
  }
  
  private void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    int i = paramIntent.getIntExtra("req_get_list_seq", -1);
    int k;
    if (bool)
    {
      try
      {
        Object localObject1 = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject1).getInt() - 4];
        ((ByteBuffer)localObject1).get(paramFromServiceMsg);
        Object localObject2 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject2).mergeFrom(paramFromServiceMsg);
        int j = ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("BusinessCard_Servlet", 2, "respGetCardList | is success, and result=" + j);
        }
        if ((j == 0) && (((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.get() != null))
        {
          paramFromServiceMsg = (QQAppInterface)getAppRuntime();
          localObject1 = (aqjm)paramFromServiceMsg.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
          Object localObject3 = ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.get().toByteArray();
          localObject2 = new Oidb_0x43c.ResponseCardList();
          ((Oidb_0x43c.ResponseCardList)localObject2).mergeFrom((byte[])localObject3);
          j = ((Oidb_0x43c.ResponseCardList)localObject2).seq.get();
          if (j == i)
          {
            if (QLog.isColorLevel()) {
              QLog.d("BusinessCard_Servlet", 2, "respGetCardList | seq equal " + j);
            }
            notifyObserver(paramIntent, 4, false, null, aqjn.class);
            return;
          }
          bool = paramIntent.getBooleanExtra("req_get_list_first", false);
          localObject3 = new ArrayList();
          if (bool)
          {
            ((aqjm)localObject1).b();
            if (((Oidb_0x43c.ResponseCardList)localObject2).mine.has())
            {
              BusinessCard localBusinessCard = new BusinessCard();
              a(localBusinessCard, (Oidb_0x43c.CardInfo)((Oidb_0x43c.ResponseCardList)localObject2).mine.get());
              localBusinessCard.cardType = 1;
              ((aqjm)localObject1).a(localBusinessCard);
              ((ArrayList)localObject3).add(localBusinessCard);
            }
          }
          a((aqjm)localObject1, (ArrayList)localObject3, (Oidb_0x43c.ResponseCardList)localObject2);
          ((aqjm)localObject1).a((List)localObject3, false);
          k = ((Oidb_0x43c.ResponseCardList)localObject2).next_flag.get();
          if (QLog.isColorLevel()) {
            QLog.d("BusinessCard_Servlet", 2, "respGetCardList | nextFlag=" + k);
          }
          if (k != -1) {
            break label439;
          }
          ((aqjm)localObject1).a(j);
          notifyObserver(paramIntent, 4, true, null, aqjn.class);
          return;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        QLog.w("BusinessCard_Servlet", 2, paramFromServiceMsg.getMessage());
      }
    }
    else
    {
      notifyObserver(paramIntent, 4, false, null, aqjn.class);
      return;
    }
    label439:
    a(paramFromServiceMsg, i, k, false);
  }
  
  private void e(Intent paramIntent, Packet paramPacket)
  {
    Oidb_0x43c.RequestCardDetail localRequestCardDetail = new Oidb_0x43c.RequestCardDetail();
    paramIntent = paramIntent.getStringExtra("key_card_id");
    localRequestCardDetail.card_id.set(ByteStringMicro.copyFromUtf8(paramIntent));
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_Servlet", 2, "reqGetDetailCardInfo|cardId=" + paramIntent);
    }
    a(localRequestCardDetail.toByteArray(), 5, "OidbSvc.0x43c_5", paramPacket);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    if (str2 == null) {}
    label98:
    do
    {
      return;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        boolean bool = paramFromServiceMsg.isSuccess();
        localStringBuilder = new StringBuilder().append("resp:").append(str2).append(" is ");
        if (!bool) {
          break label98;
        }
      }
      for (String str1 = "";; str1 = "not")
      {
        QLog.d("BusinessCard_Servlet", 2, str1 + " success");
        if (!str2.equals("OidbSvc.0x43c_1")) {
          break;
        }
        a(paramIntent, paramFromServiceMsg);
        return;
      }
      if (str2.equals("OidbSvc.0x43c_2"))
      {
        b(paramIntent, paramFromServiceMsg);
        return;
      }
      if (str2.equals("OidbSvc.0x43c_3"))
      {
        c(paramIntent, paramFromServiceMsg);
        return;
      }
      if (str2.equals("OidbSvc.0x43c_4"))
      {
        e(paramIntent, paramFromServiceMsg);
        return;
      }
    } while (!str2.equals("OidbSvc.0x43c_5"));
    d(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    switch (paramIntent.getExtras().getInt("key_cmd_type"))
    {
    default: 
      return;
    case 1: 
      a(paramIntent, paramPacket);
      return;
    case 2: 
      b(paramIntent, paramPacket);
      return;
    case 3: 
      c(paramIntent, paramPacket);
      return;
    case 4: 
      d(paramIntent, paramPacket);
      return;
    }
    e(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqjo
 * JD-Core Version:    0.7.0.1
 */