import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilesetting.ReqSetSettingItem;
import com.tencent.mobileqq.troop.org.pb.oidb_0x587.ReqBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/CardSettingHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "handleGetCardDisplaySetting", "", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "resp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "handleSetCardDisplaySetting", "msgCmdFilter", "", "cmd", "", "observerClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "onReceive", "res", "parseUdcUinBaseDataToCard", "udcData", "Ltencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData;", "card", "Lcom/tencent/mobileqq/data/Card;", "parseUdcUinOtherDataToCard", "reqGetCardDisplaySetting", "fieldIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "reqSetCardDisplaySetting", "items", "Lcom/tencent/mobileqq/profilesetting/ReqSetSettingItem;", "setReqGetDisplaySettingTag", "fieldID", "body", "Ltencent/im/oidb/cmd0x5eb/oidb_0x5eb$ReqBody;", "setReqSetDisplaySettingTag", "state", "Lcom/tencent/mobileqq/troop/org/pb/oidb_0x587$ReqBody;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bajx
  extends anud
{
  public static final bajy a = new bajy(null);
  
  public bajx(@NotNull QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private final void a(int paramInt1, int paramInt2, oidb_0x587.ReqBody paramReqBody)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 41611: 
      paramReqBody.uint32_profile_sex_visible.set(paramInt2);
      return;
    case 41610: 
      paramReqBody.uint32_profile_age_visible.set(paramInt2);
      return;
    case 41607: 
      paramReqBody.uint32_profile_birthday_visible.set(paramInt2);
      return;
    case 41609: 
      paramReqBody.uint32_profile_constellation_visible.set(paramInt2);
      return;
    case 41618: 
      paramReqBody.uint32_profile_profession_visible.set(paramInt2);
      return;
    case 41619: 
      paramReqBody.uint32_profile_college_visible.set(paramInt2);
      return;
    case 41614: 
      paramReqBody.uint32_profile_location_visible.set(paramInt2);
      return;
    case 41613: 
      paramReqBody.uint32_profile_hometown_visible.set(paramInt2);
      return;
    case 41622: 
      paramReqBody.uint32_profile_email_visible.set(paramInt2);
      return;
    case 41623: 
      paramReqBody.uint32_profile_personal_note_visible.set(paramInt2);
      return;
    case 40272: 
      paramReqBody.uint32_profile_company_visible.set(paramInt2);
      return;
    case 42075: 
      paramReqBody.uint32_req_medalwall_flag.set(paramInt2);
      return;
    case 42128: 
      paramReqBody.uint32_profile_personality_label_switch.set(paramInt2);
      return;
    case 42367: 
      paramReqBody.uint32_flag_profile_life_achievement_switch.set(paramInt2);
      return;
    case 40313: 
      paramReqBody.uint32_profile_interest_switch.set(paramInt2);
      return;
    case 40314: 
      paramReqBody.uint32_profile_music_switch.set(paramInt2);
      return;
    case 42289: 
      paramReqBody.uint32_profile_present_switch.set(paramInt2);
      return;
    case 42323: 
      paramReqBody.uint32_profile_miniapp_switch.set(paramInt2);
      return;
    case 42340: 
      paramReqBody.uint32_profile_musicbox_switch.set(paramInt2);
      return;
    case 42356: 
      paramReqBody.uint32_profile_sticky_note_switch.set(paramInt2);
      return;
    case 42361: 
      paramReqBody.uint32_profile_qqcircle_switch.set(paramInt2);
      return;
    case 42377: 
      paramReqBody.uint32_flag_profile_weishi_switch.set(paramInt2);
      return;
    }
    paramReqBody.uint32_extend_friend_card_shown.set(paramInt2);
  }
  
  private final void a(int paramInt, oidb_0x5eb.ReqBody paramReqBody)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 41611: 
      paramReqBody.uint32_profile_sex_visible.set(1);
      return;
    case 41610: 
      paramReqBody.uint32_profile_age_visible.set(1);
      return;
    case 41607: 
      paramReqBody.uint32_profile_birthday_visible.set(1);
      return;
    case 41609: 
      paramReqBody.uint32_profile_constellation_visible.set(1);
      return;
    case 41618: 
      paramReqBody.uint32_profile_profession_visible.set(1);
      return;
    case 41619: 
      paramReqBody.uint32_profile_college_visible.set(1);
      return;
    case 41614: 
      paramReqBody.uint32_profile_location_visible.set(1);
      return;
    case 41613: 
      paramReqBody.uint32_profile_hometown_visible.set(1);
      return;
    case 41622: 
      paramReqBody.uint32_profile_email_visible.set(1);
      return;
    case 41623: 
      paramReqBody.uint32_profile_personal_note_visible.set(1);
      return;
    case 40272: 
      paramReqBody.uint32_profile_company_visible.set(1);
      return;
    case 42075: 
      paramReqBody.uint32_req_medalwall_flag.set(1);
      return;
    case 42128: 
      paramReqBody.uint32_profile_personality_label_switch.set(1);
      return;
    case 42367: 
      paramReqBody.uint32_flag_profile_life_achievement_switch.set(1);
      return;
    case 40313: 
      paramReqBody.uint32_profile_interest_switch.set(1);
      return;
    case 40314: 
      paramReqBody.uint32_profile_music_switch.set(1);
      return;
    case 42289: 
      paramReqBody.uint32_profile_present_switch.set(1);
      return;
    case 42323: 
      paramReqBody.uint32_profile_miniapp_switch.set(1);
      return;
    case 42340: 
      paramReqBody.uint32_profile_musicbox_switch.set(1);
      return;
    case 42356: 
      paramReqBody.uint32_profile_sticky_note_switch.set(1);
      return;
    case 42361: 
      paramReqBody.uint32_profile_qqcircle_switch.set(1);
      return;
    case 42377: 
      paramReqBody.uint32_flag_profile_weishi_switch.set(1);
      return;
    }
    paramReqBody.uint32_extend_friend_card_shown.set(1);
  }
  
  private final void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null) {
      Intrinsics.throwNpe();
    }
    if ((Intrinsics.areEqual(paramToServiceMsg.getAttribute("req_get_card_display_setting_tag"), Boolean.valueOf(true)) ^ true)) {}
    boolean bool1;
    do
    {
      do
      {
        return;
        if (paramFromServiceMsg == null) {
          Intrinsics.throwNpe();
        }
        if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
        for (bool1 = true;; bool1 = false)
        {
          paramToServiceMsg = paramToServiceMsg.getAttribute("uin");
          if (paramToServiceMsg != null) {
            break;
          }
          throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        paramToServiceMsg = (String)paramToServiceMsg;
      } while (TextUtils.isEmpty((CharSequence)paramToServiceMsg));
      localObject1 = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "app");
    } while (!TextUtils.equals((CharSequence)((QQAppInterface)localObject1).getCurrentAccountUin(), (CharSequence)paramToServiceMsg));
    int k = paramFromServiceMsg.getResultCode();
    paramFromServiceMsg = this.app.getManager(51);
    if (paramFromServiceMsg == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
    }
    Object localObject1 = (anyw)paramFromServiceMsg;
    paramFromServiceMsg = ((anyw)localObject1).c(paramToServiceMsg);
    boolean bool3 = bool1;
    int j = k;
    boolean bool2;
    int i;
    Object localObject2;
    if (bool1)
    {
      bool2 = bool1;
      i = k;
      try
      {
        localObject2 = new oidb_sso.OIDBSSOPkg();
        if (paramObject == null)
        {
          bool2 = bool1;
          i = k;
          throw new TypeCastException("null cannot be cast to non-null type kotlin.ByteArray");
        }
      }
      catch (Exception paramObject)
      {
        QLog.d("CardSettingHandler", 1, "handleGetCardDisplaySetting ex", (Throwable)paramObject);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardSettingHandler", 2, "handleGetCardDisplaySetting success=" + bool1 + ", uin=" + paramToServiceMsg + ", resultCode=" + i);
      }
      notifyUI(1, bool1, new Object[] { paramToServiceMsg, paramFromServiceMsg });
      return;
      bool2 = bool1;
      i = k;
      paramObject = ((oidb_sso.OIDBSSOPkg)localObject2).mergeFrom((byte[])paramObject);
      bool2 = bool1;
      i = k;
      Intrinsics.checkExpressionValueIsNotNull(paramObject, "pkg.mergeFrom(data as ByteArray)");
      bool2 = bool1;
      i = k;
      paramObject = (oidb_sso.OIDBSSOPkg)paramObject;
      bool2 = bool1;
      i = k;
      k = paramObject.uint32_result.get();
      bool2 = bool1;
      i = k;
      if (paramObject.uint32_result.get() == 0) {}
      for (bool1 = true;; bool1 = false)
      {
        bool3 = bool1;
        j = k;
        if (!bool1) {
          break label748;
        }
        bool2 = bool1;
        i = k;
        bool3 = bool1;
        j = k;
        if (!paramObject.bytes_bodybuffer.has()) {
          break label748;
        }
        bool2 = bool1;
        i = k;
        bool3 = bool1;
        j = k;
        if (paramObject.bytes_bodybuffer.get() == null) {
          break label748;
        }
        bool2 = bool1;
        i = k;
        localObject2 = new oidb_0x5eb.RspBody();
        bool2 = bool1;
        i = k;
        ((oidb_0x5eb.RspBody)localObject2).mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        bool2 = bool1;
        i = k;
        bool3 = bool1;
        j = k;
        if (!((oidb_0x5eb.RspBody)localObject2).rpt_msg_uin_data.has()) {
          break label748;
        }
        bool2 = bool1;
        i = k;
        bool3 = bool1;
        j = k;
        if (((oidb_0x5eb.RspBody)localObject2).rpt_msg_uin_data.get().size() <= 0) {
          break label748;
        }
        bool2 = bool1;
        i = k;
        paramObject = (oidb_0x5eb.UdcUinData)((oidb_0x5eb.RspBody)localObject2).rpt_msg_uin_data.get().get(0);
        bool2 = bool1;
        i = k;
        Intrinsics.checkExpressionValueIsNotNull(paramObject, "udcData");
        bool2 = bool1;
        i = k;
        Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "card");
        bool2 = bool1;
        i = k;
        a(paramObject, paramFromServiceMsg);
        bool2 = bool1;
        i = k;
        b(paramObject, paramFromServiceMsg);
        bool2 = bool1;
        i = k;
        ((anyw)localObject1).a(paramFromServiceMsg);
        bool2 = bool1;
        i = k;
        bool3 = bool1;
        j = k;
        if (!QLog.isColorLevel()) {
          break label748;
        }
        bool2 = bool1;
        i = k;
        QLog.d("CardSettingHandler", 2, "handleGetCardDisplaySetting size=" + paramFromServiceMsg.profileDisplaySettingStates.size() + " settingStates=" + paramFromServiceMsg.profileDisplaySettingStates);
        i = k;
        break;
      }
      label748:
      i = j;
      bool1 = bool3;
    }
  }
  
  private final void a(oidb_0x5eb.UdcUinData paramUdcUinData, Card paramCard)
  {
    bald localbald;
    int i;
    QQAppInterface localQQAppInterface;
    if (paramUdcUinData.uint32_profile_sex_visible.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_sex_visible.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(41611, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_age_visible.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_age_visible.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(41610, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_birthday_visible.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_birthday_visible.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(41607, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_constellation_visible.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_constellation_visible.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(41609, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_profession_visible.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_profession_visible.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(41618, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_college_visible.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_college_visible.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(41619, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_location_visible.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_location_visible.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(41614, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_hometown_visible.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_hometown_visible.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(41613, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_email_visible.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_email_visible.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(41622, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_personal_note_visible.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_personal_note_visible.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(41623, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_company_visible.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_company_visible.get();
      paramUdcUinData = this.app;
      Intrinsics.checkExpressionValueIsNotNull(paramUdcUinData, "app");
      localbald.a(40272, i, paramCard, paramUdcUinData);
    }
  }
  
  private final void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null) {
      Intrinsics.throwNpe();
    }
    if ((Intrinsics.areEqual(paramToServiceMsg.getAttribute("req_set_card_display_setting_tag"), Boolean.valueOf(true)) ^ true)) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        if (paramFromServiceMsg == null) {
          Intrinsics.throwNpe();
        }
        if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
        for (bool1 = true;; bool1 = false)
        {
          localObject1 = paramToServiceMsg.getAttribute("uin");
          if (localObject1 != null) {
            break;
          }
          throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        localObject1 = (String)localObject1;
      } while (TextUtils.isEmpty((CharSequence)localObject1));
      localObject2 = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "app");
    } while (!TextUtils.equals((CharSequence)((QQAppInterface)localObject2).getCurrentAccountUin(), (CharSequence)localObject1));
    int j = paramFromServiceMsg.getResultCode();
    paramFromServiceMsg = this.app.getManager(51);
    if (paramFromServiceMsg == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
    }
    Object localObject2 = (anyw)paramFromServiceMsg;
    paramFromServiceMsg = ((anyw)localObject2).c((String)localObject1);
    paramToServiceMsg = paramToServiceMsg.getAttribute("req_items");
    if (paramToServiceMsg == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.tencent.mobileqq.profilesetting.ReqSetSettingItem> /* = java.util.ArrayList<com.tencent.mobileqq.profilesetting.ReqSetSettingItem> */");
    }
    paramToServiceMsg = (ArrayList)paramToServiceMsg;
    boolean bool2 = bool1;
    int i = j;
    Object localObject3;
    if (bool1)
    {
      bool2 = bool1;
      i = j;
      try
      {
        localObject3 = new oidb_sso.OIDBSSOPkg();
        if (paramObject != null) {
          break label376;
        }
        bool2 = bool1;
        i = j;
        throw new TypeCastException("null cannot be cast to non-null type kotlin.ByteArray");
      }
      catch (Exception paramObject)
      {
        QLog.d("CardSettingHandler", 1, "handleSetCardDisplaySetting ex", (Throwable)paramObject);
        bool1 = bool2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CardSettingHandler", 2, "handleSetCardDisplaySetting success=" + bool1 + ", uin=" + (String)localObject1 + ", resultCode=" + i + " reqItems=" + paramToServiceMsg + " settingStates=" + paramFromServiceMsg.profileDisplaySettingStates);
      }
      notifyUI(2, bool1, new Object[] { localObject1, paramFromServiceMsg, paramToServiceMsg });
      return;
      label376:
      bool2 = bool1;
      i = j;
      paramObject = ((oidb_sso.OIDBSSOPkg)localObject3).mergeFrom((byte[])paramObject);
      bool2 = bool1;
      i = j;
      Intrinsics.checkExpressionValueIsNotNull(paramObject, "pkg.mergeFrom(data as ByteArray)");
      bool2 = bool1;
      i = j;
      paramObject = (oidb_sso.OIDBSSOPkg)paramObject;
      bool2 = bool1;
      i = j;
      j = paramObject.uint32_result.get();
      bool2 = bool1;
      i = j;
      if (paramObject.uint32_result.get() != 0) {
        break label661;
      }
    }
    label661:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      i = j;
      if (bool1)
      {
        bool2 = bool1;
        i = j;
        paramObject = paramToServiceMsg.iterator();
        for (;;)
        {
          bool2 = bool1;
          i = j;
          if (!paramObject.hasNext()) {
            break;
          }
          bool2 = bool1;
          i = j;
          Object localObject4 = (ReqSetSettingItem)paramObject.next();
          bool2 = bool1;
          i = j;
          localObject3 = balc.a;
          bool2 = bool1;
          i = j;
          int k = ((ReqSetSettingItem)localObject4).a();
          bool2 = bool1;
          i = j;
          int m = ((ReqSetSettingItem)localObject4).c();
          bool2 = bool1;
          i = j;
          Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "card");
          bool2 = bool1;
          i = j;
          localObject4 = this.app;
          bool2 = bool1;
          i = j;
          Intrinsics.checkExpressionValueIsNotNull(localObject4, "app");
          bool2 = bool1;
          i = j;
          ((bald)localObject3).a(k, m, paramFromServiceMsg, (QQAppInterface)localObject4);
        }
        bool2 = bool1;
        i = j;
        ((anyw)localObject2).a(paramFromServiceMsg);
        i = j;
        break;
      }
      bool1 = bool2;
      break;
    }
  }
  
  private final void b(oidb_0x5eb.UdcUinData paramUdcUinData, Card paramCard)
  {
    bald localbald;
    int i;
    QQAppInterface localQQAppInterface;
    if (paramUdcUinData.uint32_req_medalwall_flag.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_req_medalwall_flag.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(42075, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_personality_label_switch.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_personality_label_switch.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(42128, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_life_achievement_switch.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_life_achievement_switch.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(42367, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_interest_switch.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_interest_switch.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(40313, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_music_switch.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_music_switch.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(40314, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_present_switch.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_present_switch.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(42289, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_miniapp_switch.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_miniapp_switch.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(42323, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_musicbox_switch.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_musicbox_switch.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(42340, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_sticky_note_switch.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_sticky_note_switch.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(42356, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_qqcircle_switch.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_qqcircle_switch.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(42361, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_weishi_switch.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_profile_weishi_switch.get();
      localQQAppInterface = this.app;
      Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "app");
      localbald.a(42377, i, paramCard, localQQAppInterface);
    }
    if (paramUdcUinData.uint32_extend_friend_card_shown.has())
    {
      localbald = balc.a;
      i = paramUdcUinData.uint32_extend_friend_card_shown.get();
      paramUdcUinData = this.app;
      Intrinsics.checkExpressionValueIsNotNull(paramUdcUinData, "app");
      localbald.a(42172, i, paramCard, paramUdcUinData);
    }
  }
  
  public final void a(@NotNull ArrayList<Integer> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "fieldIds");
    Object localObject = this.app;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "app");
    localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
    if (QLog.isColorLevel()) {
      QLog.i("CardSettingHandler", 2, "reqGetCardDisplaySetting uin=" + (String)localObject + ", size=" + paramArrayList.size() + ", fieldIds=" + paramArrayList);
    }
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    try
    {
      long l = Long.parseLong((String)localObject);
      localReqBody.rpt_uint64_uins.add(Long.valueOf(l));
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Integer localInteger = (Integer)paramArrayList.next();
        Intrinsics.checkExpressionValueIsNotNull(localInteger, "fieldId");
        a(localInteger.intValue(), localReqBody);
      }
      paramArrayList = makeOIDBPkg("OidbSvc.0x5eb_22", 1515, 22, localReqBody.toByteArray());
    }
    catch (Exception paramArrayList)
    {
      QLog.e("CardSettingHandler", 1, "reqGetCardDisplaySetting error:", (Throwable)paramArrayList);
      return;
    }
    paramArrayList.addAttribute("uin", localObject);
    paramArrayList.addAttribute("req_get_card_display_setting_tag", Boolean.valueOf(true));
    sendPbReq(paramArrayList);
  }
  
  public final void b(@NotNull ArrayList<ReqSetSettingItem> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "items");
    Object localObject1 = this.app;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "app");
    localObject1 = ((QQAppInterface)localObject1).getCurrentAccountUin();
    if (QLog.isColorLevel()) {
      QLog.i("CardSettingHandler", 2, "reqSetCardDisplaySetting uin=" + (String)localObject1 + ", size=" + paramArrayList.size() + ", fieldIds=" + paramArrayList);
    }
    Object localObject2 = new oidb_0x587.ReqBody();
    try
    {
      long l = Long.parseLong((String)localObject1);
      ((oidb_0x587.ReqBody)localObject2).rpt_uint64_uins.add(Long.valueOf(l));
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        ReqSetSettingItem localReqSetSettingItem = (ReqSetSettingItem)localIterator.next();
        a(localReqSetSettingItem.a(), localReqSetSettingItem.c(), (oidb_0x587.ReqBody)localObject2);
      }
      localObject2 = makeOIDBPkg("OidbSvc.0x587_74", 1415, 74, ((oidb_0x587.ReqBody)localObject2).toByteArray());
    }
    catch (Exception paramArrayList)
    {
      QLog.e("CardSettingHandler", 1, "reqSetCardDisplaySetting error:", (Throwable)paramArrayList);
      return;
    }
    ((ToServiceMsg)localObject2).addAttribute("uin", localObject1);
    ((ToServiceMsg)localObject2).addAttribute("req_set_card_display_setting_tag", Boolean.valueOf(true));
    ((ToServiceMsg)localObject2).addAttribute("req_items", paramArrayList);
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  protected boolean msgCmdFilter(@Nullable String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = ((Set)new HashSet());
      this.allowCmdSet.add("OidbSvc.0x5eb_22");
      this.allowCmdSet.add("OidbSvc.0x587_74");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  @NotNull
  protected Class<? extends anui> observerClass()
  {
    return bajz.class;
  }
  
  public void onReceive(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    String str;
    if (paramFromServiceMsg != null)
    {
      str = paramFromServiceMsg.getServiceCmd();
      if (!msgCmdFilter(str)) {
        break label26;
      }
    }
    label26:
    do
    {
      do
      {
        do
        {
          return;
          str = null;
          break;
        } while (str == null);
        switch (str.hashCode())
        {
        default: 
          return;
        }
      } while (!str.equals("OidbSvc.0x587_74"));
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    } while (!str.equals("OidbSvc.0x5eb_22"));
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajx
 * JD-Core Version:    0.7.0.1
 */