import SecurityAccountServer.AddressBookItem;
import SecurityAccountServer.CompressedPackage;
import SecurityAccountServer.LastLoginInfo;
import SecurityAccountServer.RecommendedContactInfo;
import SecurityAccountServer.RequestBindMobileV2;
import SecurityAccountServer.RequestCancelBindMobile;
import SecurityAccountServer.RequestDisableMobileBind;
import SecurityAccountServer.RequestHeader;
import SecurityAccountServer.RequestHideContact;
import SecurityAccountServer.RequestQueryLastLoginState;
import SecurityAccountServer.RequestQueryNewUserRecommendedList;
import SecurityAccountServer.RequestQueryNewUserRecommendedListNotBind;
import SecurityAccountServer.RequestQueryQQBindingStat;
import SecurityAccountServer.RequestQueryQQMobileContactsV2;
import SecurityAccountServer.RequestQueryQQMobileContactsV3;
import SecurityAccountServer.RequestReBindMblWTLogin;
import SecurityAccountServer.RequestReBindMobile;
import SecurityAccountServer.RequestResendSmscode;
import SecurityAccountServer.RequestUpdateAddressBook;
import SecurityAccountServer.RequestUpdateAddressBookNotBind;
import SecurityAccountServer.RequestUploadAddressBook;
import SecurityAccountServer.RequestUploadAddressBookNotBind;
import SecurityAccountServer.RequestUploadAddressBookV2;
import SecurityAccountServer.RequestVerifySmscode;
import SecurityAccountServer.RequestVerifyWTLogin;
import SecurityAccountServer.RespondHeader;
import SecurityAccountServer.RespondQueryQQBindingStat;
import SecurityAccountServer.ResponeBindMobileV2;
import SecurityAccountServer.ResponeQueryLastLoginState;
import SecurityAccountServer.ResponeQueryNewUserRecommendedList;
import SecurityAccountServer.ResponeQueryNewUserRecommendedListNotBind;
import SecurityAccountServer.ResponeQueryQQMobileContactsV3;
import SecurityAccountServer.ResponeReBindMobile;
import SecurityAccountServer.ResponeUpdateAddressBook;
import SecurityAccountServer.ResponeUpdateAddressBookNotBind;
import SecurityAccountServer.ResponeUploadAddressBook;
import SecurityAccountServer.ResponeUploadAddressBookNotBind;
import SecurityAccountServer.ResponeUploadAddressBookV2;
import SecurityAccountServer.ResponseReBindMblWTLogin;
import SecurityAccountServer.ResponseVerifyWTLogin;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.phonecontact.ContactBindServlet.1;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.InflaterInputStream;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

public class azox
  extends MSFServlet
{
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  
  public static RequestHeader a(int paramInt1, int paramInt2, int paramInt3)
  {
    RequestHeader localRequestHeader = new RequestHeader();
    localRequestHeader.ver = 100;
    localRequestHeader.cmd = paramInt1;
    localRequestHeader.requestID = paramInt2;
    localRequestHeader.svrSeqNo = paramInt3;
    localRequestHeader.account = "";
    localRequestHeader.appid = 0;
    localRequestHeader.sbid = "";
    localRequestHeader.channel_id = "";
    localRequestHeader.ksid = "";
    localRequestHeader.uin = 0L;
    return localRequestHeader;
  }
  
  private ResponeQueryQQMobileContactsV3 a(UniPacket paramUniPacket)
  {
    CompressedPackage localCompressedPackage = (CompressedPackage)paramUniPacket.getByClass("CompressedPackage", new CompressedPackage());
    if (localCompressedPackage != null)
    {
      ResponeQueryQQMobileContactsV3 localResponeQueryQQMobileContactsV3 = new ResponeQueryQQMobileContactsV3();
      if (localCompressedPackage.compressed) {}
      for (paramUniPacket = a(localCompressedPackage.buffer);; paramUniPacket = localCompressedPackage.buffer)
      {
        paramUniPacket = new JceInputStream(paramUniPacket);
        paramUniPacket.setServerEncoding("utf-8");
        localResponeQueryQQMobileContactsV3.readFrom(paramUniPacket);
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, "getRspQueryContacts_v3 | compress != null | read from JceInputStream");
        }
        return localResponeQueryQQMobileContactsV3;
      }
    }
    return (ResponeQueryQQMobileContactsV3)paramUniPacket.getByClass("ResponeQueryQQMobileContactsV3", new ResponeQueryQQMobileContactsV3());
  }
  
  private UniPacket a(FromServiceMsg paramFromServiceMsg)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    localUniPacket.decode(paramFromServiceMsg.getWupBuffer());
    return localUniPacket;
  }
  
  private PhoneContactManagerImp a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)getAppRuntime().getManager(11));
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  }
  
  private void a(ResponeQueryQQMobileContactsV3 paramResponeQueryQQMobileContactsV3)
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = new RespondQueryQQBindingStat();
    localRespondQueryQQBindingStat.nationCode = paramResponeQueryQQMobileContactsV3.nationCode;
    localRespondQueryQQBindingStat.mobileNo = paramResponeQueryQQMobileContactsV3.mobileNo;
    localRespondQueryQQBindingStat.MobileUniqueNo = paramResponeQueryQQMobileContactsV3.MobileUniqueNo;
    localRespondQueryQQBindingStat.isRecommend = paramResponeQueryQQMobileContactsV3.isRecommend;
    localRespondQueryQQBindingStat.originBinder = paramResponeQueryQQMobileContactsV3.originBinder;
    localRespondQueryQQBindingStat.bindingTime = paramResponeQueryQQMobileContactsV3.bindingTime;
    localRespondQueryQQBindingStat.lastUsedFlag = paramResponeQueryQQMobileContactsV3.lastUsedFlag;
    localRespondQueryQQBindingStat.type = paramResponeQueryQQMobileContactsV3.type;
    localRespondQueryQQBindingStat.isStopFindMatch = paramResponeQueryQQMobileContactsV3.isInactive;
    localRespondQueryQQBindingStat.isPhoneSwitched = paramResponeQueryQQMobileContactsV3.isChangeDev;
    localRespondQueryQQBindingStat.noBindUploadContacts = paramResponeQueryQQMobileContactsV3.noBindUploadContacts;
    a().a(localRespondQueryQQBindingStat, "saveBindStatAndBindStrategy");
    a().a(paramResponeQueryQQMobileContactsV3.nextQueryTimeInterval * 1000L, paramResponeQueryQQMobileContactsV3.nextReLoginTimeInterval * 1000L, paramResponeQueryQQMobileContactsV3.nextReconnectionTimeInterval * 1000L);
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = false;
    Bundle localBundle = new Bundle();
    if (paramFromServiceMsg.isSuccess())
    {
      UniPacket localUniPacket = a(paramFromServiceMsg);
      RespondHeader localRespondHeader = (RespondHeader)localUniPacket.getByClass("RespondHeader", new RespondHeader());
      if (localRespondHeader == null)
      {
        notifyObserver(paramIntent, 26, false, localBundle, azov.class);
        return;
      }
      paramFromServiceMsg = null;
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Servlet", 2, "handleGetBindUinWithPhone respHeader.result =" + localRespondHeader.result);
      }
      boolean bool1;
      if (localRespondHeader.result == 107)
      {
        paramFromServiceMsg = String.valueOf(((ResponseVerifyWTLogin)localUniPacket.getByClass("ResponseVerifyWTLogin", new ResponseVerifyWTLogin())).preBindUin);
        bool1 = true;
      }
      for (;;)
      {
        localBundle.putBoolean("bindOK", bool2);
        localBundle.putBoolean("hadBind", bool1);
        localBundle.putString("bindUin", paramFromServiceMsg);
        notifyObserver(paramIntent, 26, true, localBundle, azov.class);
        return;
        if (localRespondHeader.result == 0)
        {
          bool1 = false;
          bool2 = true;
        }
        else
        {
          bool1 = false;
        }
      }
    }
    notifyObserver(paramIntent, 26, false, localBundle, azov.class);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), azox.class);
    localNewIntent.putExtra("req_type", 26);
    localNewIntent.putExtra("cmd_param_phone_bind_sign", paramArrayOfByte);
    localNewIntent.putExtra("cmd_param_phone_uin", paramString);
    localNewIntent.setWithouLogin(true);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      InflaterInputStream localInflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte2 = new byte[256];
      for (;;)
      {
        int i = localInflaterInputStream.read(arrayOfByte2);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte2, 0, i);
      }
      arrayOfByte1 = localThrowable.toByteArray();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return paramArrayOfByte;
    }
    byte[] arrayOfByte1;
    return arrayOfByte1;
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = false;
    Bundle localBundle = new Bundle();
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = a(paramFromServiceMsg);
      RespondHeader localRespondHeader = (RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader());
      if (localRespondHeader == null)
      {
        localBundle.putBoolean("bind_state", false);
        notifyObserver(paramIntent, 27, false, localBundle, azov.class);
        return;
      }
      if (localRespondHeader.result == 0)
      {
        paramFromServiceMsg = (ResponseReBindMblWTLogin)paramFromServiceMsg.getByClass("ResponseReBindMblWTLogin", new ResponseReBindMblWTLogin());
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Servlet", 2, "handlerReBindMblWTLogin resp = " + paramFromServiceMsg.result);
        }
        bool = true;
      }
      localBundle.putBoolean("bind_state", bool);
      notifyObserver(paramIntent, 27, true, localBundle, azov.class);
      return;
    }
    localBundle.putBoolean("bind_state", false);
    notifyObserver(paramIntent, 27, false, localBundle, azov.class);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), azox.class);
    localNewIntent.putExtra("req_type", 27);
    localNewIntent.putExtra("cmd_param_phone_bind_sign", paramArrayOfByte);
    localNewIntent.putExtra("cmd_param_phone_uin", paramString);
    localNewIntent.setWithouLogin(true);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = a(paramFromServiceMsg);
      if (((RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader())).result == 105)
      {
        localBundle.putBoolean("bind_state", false);
        paramFromServiceMsg = null;
      }
      for (;;)
      {
        a().a(paramFromServiceMsg, "handleQueryBindState");
        notifyObserver(paramIntent, 12, true, localBundle, azov.class);
        return;
        paramFromServiceMsg = (RespondQueryQQBindingStat)paramFromServiceMsg.getByClass("RespondQueryQQBindingStat", new RespondQueryQQBindingStat());
        localBundle.putBoolean("bind_state", true);
      }
    }
    notifyObserver(paramIntent, 12, false, null, azov.class);
  }
  
  private void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      Object localObject = a(paramFromServiceMsg);
      paramFromServiceMsg = (RespondHeader)((UniPacket)localObject).getByClass("RespondHeader", new RespondHeader());
      localObject = (ResponeBindMobileV2)((UniPacket)localObject).getByClass("ResponeBindMobileV2", new ResponeBindMobileV2());
      a().a(((ResponeBindMobileV2)localObject).sessionSid);
      Bundle localBundle = new Bundle();
      localBundle.putInt("k_result", paramFromServiceMsg.result);
      localBundle.putBoolean("k_buto_bind", ((ResponeBindMobileV2)localObject).bindSuccess);
      if (paramFromServiceMsg.result == 107) {
        localBundle.putString("k_uin", ((ResponeBindMobileV2)localObject).alreadyBindedUin);
      }
      for (;;)
      {
        notifyObserver(paramIntent, 35, true, localBundle, azov.class);
        return;
        if (paramFromServiceMsg.result == 106) {
          localBundle.putString("k_uin", "");
        }
      }
    }
    notifyObserver(paramIntent, 35, false, null, azov.class);
  }
  
  private void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (a().g()) {
      return;
    }
    if (paramFromServiceMsg.isSuccess())
    {
      Object localObject = a(paramFromServiceMsg);
      paramFromServiceMsg = (RespondHeader)((UniPacket)localObject).getByClass("RespondHeader", new RespondHeader());
      localObject = (ResponeReBindMobile)((UniPacket)localObject).getByClass("ResponeReBindMobile", new ResponeReBindMobile());
      a().a(((ResponeReBindMobile)localObject).sessionSid);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("k_result", paramFromServiceMsg.result);
      if ((paramFromServiceMsg.result == 0) || (paramFromServiceMsg.result == 104))
      {
        notifyObserver(paramIntent, 19, true, (Bundle)localObject, azov.class);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Servlet", 2, "BindNumberBusiness  rebind failed ,返回码不正确");
      }
      notifyObserver(paramIntent, 19, false, (Bundle)localObject, azov.class);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Servlet", 2, "BindNumberBusiness  rebind failed ,response isSuccess = false");
    }
    notifyObserver(paramIntent, 19, false, null, azov.class);
  }
  
  private void f(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RespondHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespondHeader", new RespondHeader());
      if ((paramFromServiceMsg.result == 0) || (paramFromServiceMsg.result == 105))
      {
        a().a(null, "handleCancelBind");
        notifyObserver(paramIntent, 20, true, null, azov.class);
        return;
      }
      notifyObserver(paramIntent, 20, false, null, azov.class);
      return;
    }
    notifyObserver(paramIntent, 20, false, null, azov.class);
  }
  
  private void g(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Servlet", 2, "handleDisableMobileBind");
    }
    if (paramFromServiceMsg.isSuccess())
    {
      if (((RespondHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespondHeader", new RespondHeader())).result == 0)
      {
        a().i();
        notifyObserver(paramIntent, 33, true, null, azov.class);
        return;
      }
      notifyObserver(paramIntent, 33, false, null, azov.class);
      return;
    }
    notifyObserver(paramIntent, 33, false, null, azov.class);
  }
  
  private void h(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RespondHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespondHeader", new RespondHeader());
      Bundle localBundle = new Bundle();
      localBundle.putInt("k_result", paramFromServiceMsg.result);
      notifyObserver(paramIntent, 16, true, localBundle, azov.class);
      return;
    }
    notifyObserver(paramIntent, 16, false, null, azov.class);
  }
  
  private void i(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i = 2;
    Bundle localBundle = paramIntent.getExtras();
    int k = localBundle.getInt("upload_package_no");
    Object localObject = localBundle.getString("unique_phone_no");
    NewIntent localNewIntent = new NewIntent(getAppRuntime().getApplication(), azox.class);
    localNewIntent.putExtra("req_type", 14);
    localNewIntent.putExtra("unique_phone_no", (String)localObject);
    if (a().g()) {
      return;
    }
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = a(paramFromServiceMsg);
      localObject = (RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader());
      paramFromServiceMsg = (ResponeUploadAddressBook)paramFromServiceMsg.getByClass("ResponeUploadAddressBook", new ResponeUploadAddressBook());
      if (((RespondHeader)localObject).result == 0)
      {
        localObject = (ArrayList)localBundle.getSerializable("contact_list");
        int m = k * 50;
        int j = m + 50;
        i = j;
        if (j > ((ArrayList)localObject).size()) {
          i = ((ArrayList)localObject).size();
        }
        localObject = ((ArrayList)localObject).subList(m, i);
        a().b((List)localObject);
        if (paramFromServiceMsg.nextFlag != 4294967295L)
        {
          localNewIntent.putExtra("next_flag", paramFromServiceMsg.nextFlag);
          localNewIntent.putExtra("upload_package_no", k + 1);
          localNewIntent.putExtra("contact_list", (ArrayList)localBundle.getSerializable("contact_list"));
          localNewIntent.putExtra("session_id", paramFromServiceMsg.sessionSid);
          localNewIntent.putExtra("is_resend", false);
          localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
          getAppRuntime().startServlet(localNewIntent);
          return;
        }
        notifyObserver(paramIntent, 14, true, null, azov.class);
        return;
      }
      if ((((RespondHeader)localObject).result == 105) || (((RespondHeader)localObject).result == 107))
      {
        a().a(null, "handleUploadContact");
        paramFromServiceMsg = new Bundle();
        paramFromServiceMsg.putInt("param_fail_reason", 1);
        notifyObserver(paramIntent, 14, false, paramFromServiceMsg, azov.class);
        return;
      }
      if (localBundle.getBoolean("is_resend"))
      {
        paramFromServiceMsg = new Bundle();
        if (k == 0) {}
        for (i = 2;; i = 3)
        {
          paramFromServiceMsg.putInt("param_fail_reason", i);
          notifyObserver(paramIntent, 14, false, paramFromServiceMsg, azov.class);
          return;
        }
      }
      localNewIntent.putExtra("is_resend", true);
      localNewIntent.putExtra("next_flag", localBundle.getLong("next_flag"));
      localNewIntent.putExtra("upload_package_no", k);
      localNewIntent.putExtra("contact_list", (ArrayList)localBundle.getSerializable("contact_list"));
      localNewIntent.putExtra("session_id", localBundle.getByteArray("session_id"));
      localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
      getAppRuntime().startServlet(localNewIntent);
      return;
    }
    if (localBundle.getBoolean("is_resend"))
    {
      paramFromServiceMsg = new Bundle();
      if (k == 0) {}
      for (;;)
      {
        paramFromServiceMsg.putInt("param_fail_reason", i);
        notifyObserver(paramIntent, 14, false, paramFromServiceMsg, azov.class);
        return;
        i = 3;
      }
    }
    localNewIntent.putExtra("is_resend", true);
    localNewIntent.putExtra("next_flag", localBundle.getLong("next_flag"));
    localNewIntent.putExtra("upload_package_no", k);
    localNewIntent.putExtra("contact_list", (ArrayList)localBundle.getSerializable("contact_list"));
    localNewIntent.putExtra("session_id", localBundle.getByteArray("session_id"));
    localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
    getAppRuntime().startServlet(localNewIntent);
  }
  
  private void j(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    try
    {
      Thread.sleep(1000L);
      Bundle localBundle = paramIntent.getExtras();
      k = localBundle.getInt("upload_package_no");
      localObject1 = localBundle.getString("unique_phone_no");
      localNewIntent = new NewIntent(getAppRuntime().getApplication(), azox.class);
      localNewIntent.putExtra("req_type", 31);
      localNewIntent.putExtra("unique_phone_no", (String)localObject1);
      boolean bool = a().g();
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Servlet", 2, "handleUploadContactV2, " + paramFromServiceMsg.isSuccess() + ", packageNo = " + k + " isMgrDestroyed = " + bool);
      }
      if (bool) {
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      int k;
      Object localObject1;
      NewIntent localNewIntent;
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
      int i;
      if (paramFromServiceMsg.isSuccess())
      {
        paramFromServiceMsg = a(paramFromServiceMsg);
        localObject1 = (RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader());
        paramFromServiceMsg = (ResponeUploadAddressBookV2)paramFromServiceMsg.getByClass("ResponeUploadAddressBookV2", new ResponeUploadAddressBookV2());
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Servlet", 2, "handleUploadContactV2, result = " + ((RespondHeader)localObject1).result);
        }
        if (((RespondHeader)localObject1).result == 0)
        {
          localObject1 = (ArrayList)localInterruptedException.getSerializable("contact_list");
          i = k * 50;
          int j = i + 50;
          Object localObject2;
          if (j > ((ArrayList)localObject1).size())
          {
            j = ((ArrayList)localObject1).size();
            localObject2 = ((ArrayList)localObject1).subList(i, j);
            a().b((List)localObject2);
            a().a(true, k, paramFromServiceMsg.nextFlag, true, paramFromServiceMsg.timeStamp, paramFromServiceMsg.MaxsignTimeStamp, paramFromServiceMsg.BindFriendContacts, paramFromServiceMsg.BindNotFriendContacts);
            localObject2 = new Bundle();
            if (((ArrayList)localObject1).size() == 0) {
              break label537;
            }
            i = i * 100 / ((ArrayList)localObject1).size();
            label368:
            if (((ArrayList)localObject1).size() == 0) {
              break label543;
            }
          }
          label537:
          label543:
          for (j = (j + 50) * 100 / ((ArrayList)localObject1).size();; j = 100)
          {
            j = Math.min(j, 100);
            ((Bundle)localObject2).putInt("current_percentage", i);
            ((Bundle)localObject2).putInt("expected_percentage", j);
            notifyObserver(paramIntent, 100, true, (Bundle)localObject2, azov.class);
            if (paramFromServiceMsg.nextFlag == 4294967295L) {
              break label550;
            }
            localNewIntent.putExtra("next_flag", paramFromServiceMsg.nextFlag);
            localNewIntent.putExtra("upload_package_no", k + 1);
            localNewIntent.putExtra("contact_list", (ArrayList)localInterruptedException.getSerializable("contact_list"));
            localNewIntent.putExtra("session_id", paramFromServiceMsg.sessionSid);
            localNewIntent.putExtra("is_resend", false);
            localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
            getAppRuntime().startServlet(localNewIntent);
            return;
            break;
            i = 100;
            break label368;
          }
          label550:
          notifyObserver(paramIntent, 31, true, null, azov.class);
          return;
        }
        if ((((RespondHeader)localObject1).result == 105) || (((RespondHeader)localObject1).result == 107))
        {
          a().a(null, "handleUploadContactV2_temp");
          paramFromServiceMsg = new Bundle();
          paramFromServiceMsg.putInt("param_fail_reason", 1);
          notifyObserver(paramIntent, 31, false, paramFromServiceMsg, azov.class);
          return;
        }
        if (localInterruptedException.getBoolean("is_resend"))
        {
          paramFromServiceMsg = new Bundle();
          if (k == 0) {}
          for (i = 2;; i = 3)
          {
            paramFromServiceMsg.putInt("param_fail_reason", i);
            notifyObserver(paramIntent, 31, false, paramFromServiceMsg, azov.class);
            return;
          }
        }
        localNewIntent.putExtra("is_resend", true);
        localNewIntent.putExtra("next_flag", localInterruptedException.getLong("next_flag"));
        localNewIntent.putExtra("upload_package_no", k);
        localNewIntent.putExtra("contact_list", (ArrayList)localInterruptedException.getSerializable("contact_list"));
        localNewIntent.putExtra("session_id", localInterruptedException.getByteArray("session_id"));
        localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
        getAppRuntime().startServlet(localNewIntent);
        return;
      }
      if (localInterruptedException.getBoolean("is_resend"))
      {
        paramFromServiceMsg = new Bundle();
        if (k == 0) {}
        for (i = 2;; i = 3)
        {
          paramFromServiceMsg.putInt("param_fail_reason", i);
          notifyObserver(paramIntent, 31, false, paramFromServiceMsg, azov.class);
          return;
        }
      }
      localNewIntent.putExtra("is_resend", true);
      localNewIntent.putExtra("next_flag", localInterruptedException.getLong("next_flag"));
      localNewIntent.putExtra("upload_package_no", k);
      localNewIntent.putExtra("contact_list", (ArrayList)localInterruptedException.getSerializable("contact_list"));
      localNewIntent.putExtra("session_id", localInterruptedException.getByteArray("session_id"));
      localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
      getAppRuntime().startServlet(localNewIntent);
    }
  }
  
  private void k(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = paramIntent.getExtras();
    int k = localBundle.getInt("upload_package_no");
    Object localObject1 = localBundle.getString("unique_phone_no");
    NewIntent localNewIntent = new NewIntent(getAppRuntime().getApplication(), azox.class);
    localNewIntent.putExtra("req_type", 37);
    localNewIntent.putExtra("unique_phone_no", (String)localObject1);
    boolean bool = a().g();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Servlet", 2, "handleUploadContactNotBind, " + paramFromServiceMsg.isSuccess() + ", packageNo = " + k + " isMgrDestroyed = " + bool);
    }
    if (bool) {
      return;
    }
    for (;;)
    {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          break label757;
        }
        paramFromServiceMsg = a(paramFromServiceMsg);
        localObject1 = (RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader());
        paramFromServiceMsg = (ResponeUploadAddressBookNotBind)paramFromServiceMsg.getByClass("ResponeUploadAddressBookNotBind", new ResponeUploadAddressBookNotBind());
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Servlet", 2, "handleUploadContactNotBind, result = " + ((RespondHeader)localObject1).result);
        }
        if (((RespondHeader)localObject1).result != 0) {
          break label554;
        }
        localObject1 = (ArrayList)localBundle.getSerializable("contact_list");
        i = k * 50;
        j = i + 50;
        if (j > ((ArrayList)localObject1).size())
        {
          j = ((ArrayList)localObject1).size();
          Object localObject2 = ((ArrayList)localObject1).subList(i, j);
          a().d((List)localObject2);
          a().a(true, k, paramFromServiceMsg.nextFlag, paramFromServiceMsg.timeStamp, paramFromServiceMsg.BindFriendContacts, paramFromServiceMsg.BindNotFriendContacts);
          localObject2 = new Bundle();
          if (((ArrayList)localObject1).size() == 0) {
            break label529;
          }
          i = i * 100 / ((ArrayList)localObject1).size();
          if (((ArrayList)localObject1).size() == 0) {
            break label535;
          }
          j = (j + 50) * 100 / ((ArrayList)localObject1).size();
          j = Math.min(j, 100);
          ((Bundle)localObject2).putInt("current_percentage", i);
          ((Bundle)localObject2).putInt("expected_percentage", j);
          notifyObserver(paramIntent, 100, true, (Bundle)localObject2, azov.class);
          if (paramFromServiceMsg.nextFlag == 4294967295L) {
            break;
          }
          localNewIntent.putExtra("next_flag", paramFromServiceMsg.nextFlag);
          localNewIntent.putExtra("upload_package_no", k + 1);
          localNewIntent.putExtra("contact_list", (ArrayList)localBundle.getSerializable("contact_list"));
          localNewIntent.putExtra("session_id", paramFromServiceMsg.sessionSid);
          localNewIntent.putExtra("is_resend", false);
          localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
          getAppRuntime().startServlet(localNewIntent);
          return;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        notifyObserver(paramIntent, 37, false, null, azov.class);
        return;
      }
      continue;
      label529:
      i = 100;
      continue;
      label535:
      int j = 100;
    }
    notifyObserver(paramIntent, 37, true, null, azov.class);
    return;
    label554:
    if ((((RespondHeader)localObject1).result == 109) || (((RespondHeader)localObject1).result == 108))
    {
      paramFromServiceMsg = new Bundle();
      if (((RespondHeader)localObject1).result == 109)
      {
        i = 4;
        paramFromServiceMsg.putInt("param_fail_reason", i);
        notifyObserver(paramIntent, 37, false, paramFromServiceMsg, azov.class);
      }
    }
    else
    {
      if (localBundle.getBoolean("is_resend"))
      {
        paramFromServiceMsg = new Bundle();
        if (k != 0) {
          break label905;
        }
        i = 2;
        paramFromServiceMsg.putInt("param_fail_reason", i);
        notifyObserver(paramIntent, 37, false, paramFromServiceMsg, azov.class);
        return;
      }
      localNewIntent.putExtra("is_resend", true);
      localNewIntent.putExtra("next_flag", localBundle.getLong("next_flag"));
      localNewIntent.putExtra("upload_package_no", k);
      localNewIntent.putExtra("contact_list", (ArrayList)localBundle.getSerializable("contact_list"));
      localNewIntent.putExtra("session_id", localBundle.getByteArray("session_id"));
      localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
      getAppRuntime().startServlet(localNewIntent);
      return;
      label757:
      if (localBundle.getBoolean("is_resend"))
      {
        paramFromServiceMsg = new Bundle();
        if (k != 0) {
          break label910;
        }
      }
    }
    label640:
    label905:
    label910:
    for (int i = 2;; i = 3)
    {
      paramFromServiceMsg.putInt("param_fail_reason", i);
      notifyObserver(paramIntent, 37, false, paramFromServiceMsg, azov.class);
      return;
      localNewIntent.putExtra("is_resend", true);
      localNewIntent.putExtra("next_flag", localBundle.getLong("next_flag"));
      localNewIntent.putExtra("upload_package_no", k);
      localNewIntent.putExtra("contact_list", (ArrayList)localBundle.getSerializable("contact_list"));
      localNewIntent.putExtra("session_id", localBundle.getByteArray("session_id"));
      localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
      getAppRuntime().startServlet(localNewIntent);
      return;
      i = 5;
      break;
      i = 3;
      break label640;
    }
  }
  
  private void l(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (a().g()) {
      return;
    }
    if (paramFromServiceMsg.isSuccess())
    {
      Bundle localBundle = paramIntent.getExtras();
      Object localObject = a(paramFromServiceMsg);
      paramFromServiceMsg = (RespondHeader)((UniPacket)localObject).getByClass("RespondHeader", new RespondHeader());
      ResponeQueryLastLoginState localResponeQueryLastLoginState = (ResponeQueryLastLoginState)((UniPacket)localObject).getByClass("ResponeQueryLastLoginState", new ResponeQueryLastLoginState());
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder(100);
        ((StringBuilder)localObject).append("handleLastLogin, nextflag = ").append(localResponeQueryLastLoginState.nextFlag);
        ((StringBuilder)localObject).append(", result = ").append(paramFromServiceMsg.result);
        ((StringBuilder)localObject).append(", lastUsedFlag = ").append(localResponeQueryLastLoginState.lastUsedFlag);
        localStringBuilder = ((StringBuilder)localObject).append(", mobile = ");
        if ((TextUtils.isEmpty(localResponeQueryLastLoginState.mobileNo)) || (TextUtils.isEmpty(localResponeQueryLastLoginState.nationCode))) {
          break label322;
        }
      }
      label322:
      for (boolean bool = true;; bool = false)
      {
        localStringBuilder.append(bool);
        QLog.d("PhoneContact.Servlet", 2, ((StringBuilder)localObject).toString());
        if ((paramFromServiceMsg.result != 0) || (TextUtils.isEmpty(localResponeQueryLastLoginState.mobileNo)) || (TextUtils.isEmpty(localResponeQueryLastLoginState.nationCode)) || (localResponeQueryLastLoginState.lastUsedFlag != 1L)) {
          break label456;
        }
        localObject = localBundle.getStringArrayList("param_last_login_list");
        paramFromServiceMsg = (FromServiceMsg)localObject;
        if (localObject == null) {
          paramFromServiceMsg = new ArrayList();
        }
        if (localResponeQueryLastLoginState.lastLoginList.size() <= 0) {
          break;
        }
        paramFromServiceMsg.ensureCapacity(paramFromServiceMsg.size() + localResponeQueryLastLoginState.lastLoginList.size());
        localObject = localResponeQueryLastLoginState.lastLoginList.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramFromServiceMsg.add(((LastLoginInfo)((Iterator)localObject).next()).contactsInfoEncrypt);
        }
      }
      if (localResponeQueryLastLoginState.nextFlag != 4294967295L)
      {
        paramIntent = new NewIntent(getAppRuntime().getApplication(), azox.class);
        paramIntent.putExtra("req_type", 32);
        paramIntent.putExtra("next_flag", localResponeQueryLastLoginState.nextFlag);
        paramIntent.putExtra("time_stamp", localResponeQueryLastLoginState.timeStamp);
        paramIntent.putExtra("unique_phone_no", localBundle.getString("unique_phone_no"));
        paramIntent.putExtra("param_last_login_list", paramFromServiceMsg);
        getAppRuntime().startServlet(paramIntent);
        return;
      }
      a().a(paramFromServiceMsg, localResponeQueryLastLoginState.timeStamp, localResponeQueryLastLoginState.interval);
      notifyObserver(paramIntent, 32, true, null, azov.class);
      return;
      label456:
      notifyObserver(paramIntent, 32, false, null, azov.class);
      return;
    }
    notifyObserver(paramIntent, 32, false, null, azov.class);
  }
  
  private void m(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i = 2;
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle == null) {}
    NewIntent localNewIntent;
    int k;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localNewIntent = new NewIntent(getAppRuntime().getApplication(), azox.class);
          localNewIntent.putExtra("req_type", 15);
          localNewIntent.putExtra("unique_phone_no", localBundle.getString("unique_phone_no"));
          k = localBundle.getInt("upload_package_no");
        } while (a().g());
        if (!paramFromServiceMsg.isSuccess()) {
          break label622;
        }
        paramFromServiceMsg = a(paramFromServiceMsg);
        localObject = (RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader());
        paramFromServiceMsg = (ResponeUpdateAddressBook)paramFromServiceMsg.getByClass("ResponeUpdateAddressBook", new ResponeUpdateAddressBook());
        if (((RespondHeader)localObject).result != 0) {
          break;
        }
        localObject = (ArrayList)localBundle.getSerializable("add_contact_list");
        int m = k * 50;
        if (m < ((List)localObject).size())
        {
          int j = m + 50;
          i = j;
          if (j > ((List)localObject).size()) {
            i = ((List)localObject).size();
          }
          localObject = ((List)localObject).subList(m, i);
          a().b((List)localObject);
        }
        if (paramFromServiceMsg.nextFlag != 4294967295L)
        {
          localNewIntent.putExtra("next_flag", paramFromServiceMsg.nextFlag);
          localNewIntent.putExtra("upload_package_no", k + 1);
          localNewIntent.putExtra("add_contact_list", (ArrayList)localBundle.getSerializable("add_contact_list"));
          localNewIntent.putExtra("del_contact_list", (ArrayList)localBundle.getSerializable("del_contact_list"));
          localNewIntent.putExtra("rename_contact_list", (ArrayList)localBundle.getSerializable("rename_contact_list"));
          localNewIntent.putExtra("session_id", paramFromServiceMsg.sessionSid);
          localNewIntent.putExtra("is_resend", false);
          localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
          getAppRuntime().startServlet(localNewIntent);
          return;
        }
        notifyObserver(paramIntent, 15, true, null, azov.class);
      } while (!localBundle.containsKey("add_contact_list"));
      paramIntent = (ArrayList)localBundle.getSerializable("rename_contact_list");
    } while (paramIntent.size() == 0);
    a().a(paramIntent);
    return;
    if (((RespondHeader)localObject).result == 105)
    {
      a().a(null, "handleUpdateContact");
      paramFromServiceMsg = new Bundle();
      paramFromServiceMsg.putInt("param_fail_reason", 1);
      notifyObserver(paramIntent, 15, false, paramFromServiceMsg, azov.class);
      return;
    }
    if (localBundle.getBoolean("is_resend"))
    {
      paramFromServiceMsg = new Bundle();
      if (k == 0) {}
      for (i = 2;; i = 3)
      {
        paramFromServiceMsg.putInt("param_fail_reason", i);
        notifyObserver(paramIntent, 15, false, paramFromServiceMsg, azov.class);
        return;
      }
    }
    localNewIntent.putExtra("next_flag", paramFromServiceMsg.nextFlag);
    localNewIntent.putExtra("upload_package_no", k);
    localNewIntent.putExtra("add_contact_list", (ArrayList)localBundle.getSerializable("add_contact_list"));
    localNewIntent.putExtra("del_contact_list", (ArrayList)localBundle.getSerializable("del_contact_list"));
    localNewIntent.putExtra("session_id", paramFromServiceMsg.sessionSid);
    localNewIntent.putExtra("is_resend", true);
    localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
    getAppRuntime().startServlet(localNewIntent);
    return;
    label622:
    if (localBundle.getBoolean("is_resend"))
    {
      paramFromServiceMsg = new Bundle();
      if (k == 0) {}
      for (;;)
      {
        paramFromServiceMsg.putInt("param_fail_reason", i);
        notifyObserver(paramIntent, 15, false, paramFromServiceMsg, azov.class);
        return;
        i = 3;
      }
    }
    localNewIntent.putExtra("next_flag", localBundle.getLong("next_flag"));
    localNewIntent.putExtra("upload_package_no", k);
    localNewIntent.putExtra("add_contact_list", (ArrayList)localBundle.getSerializable("add_contact_list"));
    localNewIntent.putExtra("del_contact_list", (ArrayList)localBundle.getSerializable("del_contact_list"));
    localNewIntent.putExtra("session_id", localBundle.getByteArray("session_id"));
    localNewIntent.putExtra("is_resend", true);
    localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
    getAppRuntime().startServlet(localNewIntent);
  }
  
  private void n(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i = 2;
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle == null) {}
    NewIntent localNewIntent;
    int k;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localNewIntent = new NewIntent(getAppRuntime().getApplication(), azox.class);
          localNewIntent.putExtra("req_type", 38);
          localNewIntent.putExtra("unique_phone_no", localBundle.getString("unique_phone_no"));
          k = localBundle.getInt("upload_package_no");
        } while (a().g());
        if (!paramFromServiceMsg.isSuccess()) {
          break label634;
        }
        localObject = a(paramFromServiceMsg);
        paramFromServiceMsg = (RespondHeader)((UniPacket)localObject).getByClass("RespondHeader", new RespondHeader());
        localObject = (ResponeUpdateAddressBookNotBind)((UniPacket)localObject).getByClass("ResponeUpdateAddressBookNotBind", new ResponeUpdateAddressBookNotBind());
        if (paramFromServiceMsg.result != 0) {
          break;
        }
        paramFromServiceMsg = (ArrayList)localBundle.getSerializable("add_contact_list");
        int m = k * 50;
        if (m < paramFromServiceMsg.size())
        {
          int j = m + 50;
          i = j;
          if (j > paramFromServiceMsg.size()) {
            i = paramFromServiceMsg.size();
          }
          paramFromServiceMsg = paramFromServiceMsg.subList(m, i);
          a().d(paramFromServiceMsg);
        }
        if (((ResponeUpdateAddressBookNotBind)localObject).nextFlag != 4294967295L)
        {
          localNewIntent.putExtra("next_flag", ((ResponeUpdateAddressBookNotBind)localObject).nextFlag);
          localNewIntent.putExtra("upload_package_no", k + 1);
          localNewIntent.putExtra("add_contact_list", localBundle.getSerializable("add_contact_list"));
          localNewIntent.putExtra("del_contact_list", localBundle.getSerializable("del_contact_list"));
          localNewIntent.putExtra("rename_contact_list", localBundle.getSerializable("rename_contact_list"));
          localNewIntent.putExtra("session_id", ((ResponeUpdateAddressBookNotBind)localObject).sessionSid);
          localNewIntent.putExtra("is_resend", false);
          localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
          getAppRuntime().startServlet(localNewIntent);
          return;
        }
        notifyObserver(paramIntent, 38, true, null, azov.class);
      } while (!localBundle.containsKey("add_contact_list"));
      paramIntent = (ArrayList)localBundle.getSerializable("rename_contact_list");
    } while (paramIntent.size() == 0);
    a().a(paramIntent);
    return;
    if ((paramFromServiceMsg.result == 109) || (paramFromServiceMsg.result == 108))
    {
      a().a(null, "handleUpdateContactNotBind");
      localBundle = new Bundle();
      if (paramFromServiceMsg.result == 109) {}
      for (i = 4;; i = 5)
      {
        localBundle.putInt("param_fail_reason", i);
        notifyObserver(paramIntent, 38, false, localBundle, azov.class);
        return;
      }
    }
    if (localBundle.getBoolean("is_resend"))
    {
      paramFromServiceMsg = new Bundle();
      if (k == 0) {}
      for (i = 2;; i = 3)
      {
        paramFromServiceMsg.putInt("param_fail_reason", i);
        notifyObserver(paramIntent, 38, false, paramFromServiceMsg, azov.class);
        return;
      }
    }
    localNewIntent.putExtra("next_flag", ((ResponeUpdateAddressBookNotBind)localObject).nextFlag);
    localNewIntent.putExtra("upload_package_no", k);
    localNewIntent.putExtra("add_contact_list", localBundle.getSerializable("add_contact_list"));
    localNewIntent.putExtra("del_contact_list", localBundle.getSerializable("del_contact_list"));
    localNewIntent.putExtra("session_id", ((ResponeUpdateAddressBookNotBind)localObject).sessionSid);
    localNewIntent.putExtra("is_resend", true);
    localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
    getAppRuntime().startServlet(localNewIntent);
    return;
    label634:
    if (localBundle.getBoolean("is_resend"))
    {
      paramFromServiceMsg = new Bundle();
      if (k == 0) {}
      for (;;)
      {
        paramFromServiceMsg.putInt("param_fail_reason", i);
        notifyObserver(paramIntent, 38, false, paramFromServiceMsg, azov.class);
        return;
        i = 3;
      }
    }
    localNewIntent.putExtra("next_flag", localBundle.getLong("next_flag"));
    localNewIntent.putExtra("upload_package_no", k);
    localNewIntent.putExtra("add_contact_list", localBundle.getSerializable("add_contact_list"));
    localNewIntent.putExtra("del_contact_list", localBundle.getSerializable("del_contact_list"));
    localNewIntent.putExtra("session_id", localBundle.getByteArray("session_id"));
    localNewIntent.putExtra("is_resend", true);
    localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
    getAppRuntime().startServlet(localNewIntent);
  }
  
  private void o(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      if (((RespondHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespondHeader", new RespondHeader())).result == 0)
      {
        notifyObserver(paramIntent, 17, true, null, azov.class);
        return;
      }
      notifyObserver(paramIntent, 17, false, null, azov.class);
      return;
    }
    notifyObserver(paramIntent, 17, false, null, azov.class);
  }
  
  private void p(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = a().g();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "Query contact v3 resp, " + paramFromServiceMsg.isSuccess() + " isMgrDestroyed = " + bool);
    }
    if (bool) {}
    label768:
    for (;;)
    {
      return;
      Object localObject;
      int j;
      if (paramFromServiceMsg.isSuccess())
      {
        paramFromServiceMsg = a(paramFromServiceMsg);
        localObject = (RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader());
        paramFromServiceMsg = a(paramFromServiceMsg);
        if ((localObject != null) && (paramFromServiceMsg != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContact.Manager", 2, "after get respHeader | result = " + ((RespondHeader)localObject).result);
          }
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContact.Manager", 2, "handleQueryContactV3 isInactive " + paramFromServiceMsg.isInactive + ", " + paramFromServiceMsg.isChangeDev);
          }
          i = paramIntent.getExtras().getInt("query_package_no", 0);
          j = paramIntent.getExtras().getInt("param_update_flag", 0);
          long l1 = paramIntent.getExtras().getLong("param_query_from");
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContact.Manager", 2, String.format("handleQueryContactV3 pno:%s, flag:%s, from:%s, state: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l1), Integer.valueOf(paramIntent.getExtras().getInt("param_bind_state")) }));
          }
          if (((RespondHeader)localObject).result == 0)
          {
            a(paramFromServiceMsg);
            localObject = a();
            long l2 = paramFromServiceMsg.nextFlag;
            if (paramFromServiceMsg.queryFlag == 1)
            {
              bool = true;
              label325:
              j |= ((PhoneContactManagerImp)localObject).a(false, i, l2, bool, paramFromServiceMsg.timeStamp, paramFromServiceMsg.MaxsignTimeStamp, paramFromServiceMsg.BindFriendContacts, paramFromServiceMsg.BindNotFriendContacts);
              if (paramFromServiceMsg.nextFlag == 4294967295L) {
                break label614;
              }
              int k = a().c();
              localObject = new NewIntent(getAppRuntime().getApplication(), azox.class);
              ((NewIntent)localObject).putExtra("req_type", 30);
              ((NewIntent)localObject).putExtra("query_package_no", i + 1);
              ((NewIntent)localObject).putExtra("next_flag", paramFromServiceMsg.nextFlag);
              ((NewIntent)localObject).putExtra("time_stamp", paramFromServiceMsg.timeStamp);
              ((NewIntent)localObject).putExtra("richinfo_time_stamp", paramFromServiceMsg.MaxsignTimeStamp);
              ((NewIntent)localObject).putExtra("session_id", paramFromServiceMsg.sessionSid);
              ((NewIntent)localObject).putExtra("force_query_list", paramFromServiceMsg.queryFlag);
              ((NewIntent)localObject).putExtra("param_update_flag", j);
              ((NewIntent)localObject).putExtra("unique_phone_no", paramIntent.getExtras().getString("unique_phone_no"));
              ((NewIntent)localObject).putExtra("param_query_from", l1);
              ((NewIntent)localObject).putExtra("param_bind_state", k);
              ((NewIntent)localObject).setObserver(((NewIntent)paramIntent).getObserver());
              getAppRuntime().startServlet((NewIntent)localObject);
              label556:
              a().a(paramFromServiceMsg.UIBits);
            }
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label768;
        }
        notifyObserver(paramIntent, 12, false, null, azov.class);
        if (a().d() != 9) {
          break;
        }
        notifyObserver(paramIntent, 30, false, null, azov.class);
        return;
        bool = false;
        break label325;
        label614:
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, "Query contact finish.");
        }
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("bind_state", true);
        notifyObserver(paramIntent, 12, true, (Bundle)localObject, azov.class);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("param_update_flag", j);
        notifyObserver(paramIntent, 30, true, (Bundle)localObject, azov.class);
        break label556;
        if ((((RespondHeader)localObject).result == 105) || (((RespondHeader)localObject).result == 107))
        {
          a(paramFromServiceMsg);
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("bind_state", false);
          notifyObserver(paramIntent, 12, true, (Bundle)localObject, azov.class);
          break label556;
        }
        notifyObserver(paramIntent, 12, false, null, azov.class);
        break label556;
      }
    }
  }
  
  private void q(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RespondHeader)a(paramFromServiceMsg).getByClass("RespondHeader", new RespondHeader());
      if (paramFromServiceMsg == null)
      {
        notifyObserver(paramIntent, 34, false, localBundle, azov.class);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Servlet", 2, "handleHideContact respHeader.result =" + paramFromServiceMsg.result);
      }
      if (paramFromServiceMsg.result == 0)
      {
        boolean bool = paramIntent.getBooleanExtra("param_hiden_flag", false);
        a().b(paramIntent.getStringExtra("unique_phone_no"), bool);
        notifyObserver(paramIntent, 34, true, localBundle, azov.class);
        return;
      }
      notifyObserver(paramIntent, 34, false, localBundle, azov.class);
      return;
    }
    notifyObserver(paramIntent, 34, false, localBundle, azov.class);
  }
  
  private void r(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    paramIntent = null;
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = a(paramFromServiceMsg);
      Object localObject = (RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader());
      if ((localObject != null) && (((RespondHeader)localObject).result == 0))
      {
        paramFromServiceMsg = ((ResponeQueryNewUserRecommendedList)paramFromServiceMsg.getByClass("ResponeQueryNewUserRecommendedList", new ResponeQueryNewUserRecommendedList())).RecommendedContacts;
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0) && ((getAppRuntime() instanceof QQAppInterface)))
        {
          paramIntent = new LinkedList();
          localObject = a();
          Iterator localIterator = paramFromServiceMsg.iterator();
          while (localIterator.hasNext())
          {
            RecommendedContactInfo localRecommendedContactInfo = (RecommendedContactInfo)localIterator.next();
            if (((PhoneContactManagerImp)localObject).a(localRecommendedContactInfo)) {
              paramIntent.add(localRecommendedContactInfo);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "handleGetNewer origin: " + paramFromServiceMsg.size() + ", handled: " + paramIntent.size());
          }
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "handleGetNewerGuideRecommended " + bool);
      }
      LoginWelcomeManager.a((QQAppInterface)getAppRuntime()).a(paramIntent);
      return;
    }
  }
  
  private void s(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    paramIntent = null;
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = a(paramFromServiceMsg);
      Object localObject = (RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader());
      if ((localObject != null) && (((RespondHeader)localObject).result == 0))
      {
        paramFromServiceMsg = ((ResponeQueryNewUserRecommendedListNotBind)paramFromServiceMsg.getByClass("ResponeQueryNewUserRecommendedListNotBind", new ResponeQueryNewUserRecommendedListNotBind())).RecommendedContacts;
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0) && ((getAppRuntime() instanceof QQAppInterface)))
        {
          paramIntent = new LinkedList();
          localObject = a();
          Iterator localIterator = paramFromServiceMsg.iterator();
          while (localIterator.hasNext())
          {
            RecommendedContactInfo localRecommendedContactInfo = (RecommendedContactInfo)localIterator.next();
            if (((PhoneContactManagerImp)localObject).a(localRecommendedContactInfo)) {
              paramIntent.add(localRecommendedContactInfo);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "handleGetNewerGuideRecommendedNotBind origin: " + paramFromServiceMsg.size() + ", handled: " + paramIntent.size());
          }
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "handleGetNewerGuideRecommendedNotBind " + bool);
      }
      LoginWelcomeManager.a((QQAppInterface)getAppRuntime()).a(paramIntent);
      return;
    }
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "account.ResponseNotifyForRecommendUpdate" };
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (str == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (str.equals("account.RequestQueryQQBindingStat"))
          {
            c(paramIntent, paramFromServiceMsg);
            return;
          }
          if (str.equals("account.RequestBindMobileV2"))
          {
            d(paramIntent, paramFromServiceMsg);
            return;
          }
          if (str.equals("account.RequestReBindMobile"))
          {
            e(paramIntent, paramFromServiceMsg);
            return;
          }
          if (str.equals("account.RequestCancelBindMobile"))
          {
            f(paramIntent, paramFromServiceMsg);
            return;
          }
          if (str.equals("account.RequestDisableMobileBind"))
          {
            g(paramIntent, paramFromServiceMsg);
            return;
          }
          if (str.equals("account.RequestVerifyBindingSmscode"))
          {
            h(paramIntent, paramFromServiceMsg);
            return;
          }
          if (str.equals("account.RequestResendBindingSmscode"))
          {
            o(paramIntent, paramFromServiceMsg);
            return;
          }
        } while (str.equals("account.RequestQueryQQMobileContactsV2"));
        if (str.equals("account.RequestQueryQQMobileContactsV3"))
        {
          ThreadManager.excute(new ContactBindServlet.1(this, paramIntent, paramFromServiceMsg), 16, null, false);
          return;
        }
        if (str.equals("account.RequestUploadAddressBook"))
        {
          i(paramIntent, paramFromServiceMsg);
          return;
        }
        if (str.equals("account.RequestUpdateAddressBook"))
        {
          m(paramIntent, paramFromServiceMsg);
          return;
        }
      } while ((str.equals("account.RequestGetRecommendedListV2")) || (str.equals("account.ResponseNotifyForRecommendUpdate")));
      if (str.equals("account.RequestVerifyWTLogin_emp"))
      {
        a(paramIntent, paramFromServiceMsg);
        return;
      }
      if (str.equals("account.RequestReBindMblWTLogin_emp"))
      {
        b(paramIntent, paramFromServiceMsg);
        return;
      }
      if (str.equals("account.RequestUploadAddressBookV2"))
      {
        j(paramIntent, paramFromServiceMsg);
        return;
      }
      if (str.equals("account.RequestQueryLastLoginState"))
      {
        l(paramIntent, paramFromServiceMsg);
        return;
      }
      if (str.equals("account.RequestHideContact"))
      {
        q(paramIntent, paramFromServiceMsg);
        return;
      }
      if (str.equals("account.RequestQueryNewUserRecommendedList"))
      {
        r(paramIntent, paramFromServiceMsg);
        return;
      }
      if (str.equals("account.RequestQueryNewUserRecommendedListNotBind"))
      {
        s(paramIntent, paramFromServiceMsg);
        return;
      }
      if (str.equals("account.RequestUploadAddressBookNotBind"))
      {
        k(paramIntent, paramFromServiceMsg);
        return;
      }
    } while (!str.equals("account.RequestUpdateAddressBookNotBind"));
    n(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getExtras();
    if (localObject1 == null) {
      return;
    }
    paramPacket.setServantName("AccountServer");
    paramPacket.setFuncName("AccountServerFunc");
    Object localObject2 = a(0, 0, 0);
    int i;
    switch (((Bundle)localObject1).getInt("req_type", 0))
    {
    case 13: 
    case 18: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 29: 
    case 39: 
    default: 
      return;
    case 12: 
      paramPacket.setSSOCommand("account.RequestQueryQQBindingStat");
      ((RequestHeader)localObject2).cmd = 12;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramPacket.addRequestPacket("RequestQueryQQBindingStat", new RequestQueryQQBindingStat(a().a()));
      return;
    case 26: 
      paramPacket.setAccount("0");
      paramPacket.setSSOCommand("account.RequestVerifyWTLogin_emp");
      ((RequestHeader)localObject2).cmd = 26;
      try
      {
        ((RequestHeader)localObject2).uin = Long.parseLong(((Bundle)localObject1).getString("cmd_param_phone_uin"));
        paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
        paramIntent = new RequestVerifyWTLogin();
        paramIntent.encryptBuffer = ((Bundle)localObject1).getByteArray("cmd_param_phone_bind_sign");
        paramPacket.addRequestPacket("RequestVerifyWTLogin", paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          paramIntent.printStackTrace();
        }
      }
    case 27: 
      paramPacket.setAccount("0");
      paramPacket.setSSOCommand("account.RequestReBindMblWTLogin_emp");
      ((RequestHeader)localObject2).cmd = 27;
      try
      {
        ((RequestHeader)localObject2).uin = Long.parseLong(((Bundle)localObject1).getString("cmd_param_phone_uin"));
        paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
        paramIntent = new RequestReBindMblWTLogin();
        paramIntent.encryptBuffer = ((Bundle)localObject1).getByteArray("cmd_param_phone_bind_sign");
        paramPacket.addRequestPacket("RequestReBindMblWTLogin", paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          paramIntent.printStackTrace();
        }
      }
    case 35: 
      paramPacket.setSSOCommand("account.RequestBindMobileV2");
      ((RequestHeader)localObject2).cmd = 35;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestBindMobileV2();
      paramIntent.nationCode = ((Bundle)localObject1).getString("country_code");
      if (((Bundle)localObject1).getBoolean("cmd_param_is_encrypt", false))
      {
        paramIntent.isSecNewReq = true;
        paramIntent.encrptBindMobileInfo = ((Bundle)localObject1).getByteArray("cmd_param_encrypt_mobile");
      }
      for (;;)
      {
        paramIntent.type = ((Bundle)localObject1).getInt("cmd_param_bind_type");
        paramIntent.isFromUni = ((Bundle)localObject1).getBoolean("cmd_param_is_from_uni", false);
        paramIntent.isFromChangeBind = ((Bundle)localObject1).getBoolean("cmd_param_is_from_change_bind", false);
        paramPacket.addRequestPacket("RequestBindMobileV2", paramIntent);
        return;
        paramIntent.mobileNo = ((Bundle)localObject1).getString("phone_number");
      }
    case 19: 
      paramPacket.setSSOCommand("account.RequestReBindMobile");
      ((RequestHeader)localObject2).cmd = 19;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestReBindMobile();
      paramIntent.nationCode = ((Bundle)localObject1).getString("country_code");
      if (((Bundle)localObject1).getBoolean("cmd_param_is_encrypt", false))
      {
        paramIntent.isSecNewReq = true;
        paramIntent.encrptBindMobileInfo = ((Bundle)localObject1).getByteArray("cmd_param_encrypt_mobile");
      }
      for (;;)
      {
        paramIntent.type = ((Bundle)localObject1).getInt("cmd_param_bind_type");
        paramIntent.isFromUni = ((Bundle)localObject1).getBoolean("cmd_param_is_from_uni", false);
        paramIntent.isFromChangeBind = ((Bundle)localObject1).getBoolean("cmd_param_is_from_change_bind", false);
        paramPacket.addRequestPacket("RequestReBindMobile", paramIntent);
        return;
        paramIntent.mobileNo = ((Bundle)localObject1).getString("phone_number");
      }
    case 20: 
      paramPacket.setSSOCommand("account.RequestCancelBindMobile");
      ((RequestHeader)localObject2).cmd = 20;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestCancelBindMobile();
      paramIntent.nationCode = ((Bundle)localObject1).getString("country_code");
      if (((Bundle)localObject1).getBoolean("cmd_param_is_encrypt", false))
      {
        paramIntent.isSecNewReq = true;
        paramIntent.encrptCancelMobileInfo = ((Bundle)localObject1).getByteArray("cmd_param_encrypt_mobile");
      }
      for (;;)
      {
        paramIntent.isFromUni = ((Bundle)localObject1).getBoolean("cmd_param_is_from_uni", false);
        paramIntent.isFromChangeBind = ((Bundle)localObject1).getBoolean("cmd_param_is_from_change_bind", false);
        paramPacket.addRequestPacket("RequestCancelBindMobile", paramIntent);
        return;
        paramIntent.mobileNo = ((Bundle)localObject1).getString("phone_number");
      }
    case 33: 
      paramPacket.setSSOCommand("account.RequestDisableMobileBind");
      ((RequestHeader)localObject2).cmd = 33;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      localObject1 = paramIntent.getStringExtra("country_code");
      paramIntent = paramIntent.getStringExtra("phone_number");
      localObject2 = new RequestDisableMobileBind((String)localObject1, paramIntent);
      ((RequestDisableMobileBind)localObject2).nationCode = ((String)localObject1);
      ((RequestDisableMobileBind)localObject2).mobileNo = paramIntent;
      paramPacket.addRequestPacket("RequestDisableMobileBind", (JceStruct)localObject2);
      return;
    case 16: 
      paramPacket.setSSOCommand("account.RequestVerifyBindingSmscode");
      ((RequestHeader)localObject2).cmd = 16;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestVerifySmscode();
      paramIntent.smsCode = ((Bundle)localObject1).getString("verify_smscode");
      paramIntent.sessionSid = ((Bundle)localObject1).getByteArray("session_id");
      paramIntent.type = ((Bundle)localObject1).getInt("cmd_param_bind_type");
      paramIntent.isFromUni = ((Bundle)localObject1).getBoolean("cmd_param_is_from_uni", false);
      paramIntent.isFromChangeBind = ((Bundle)localObject1).getBoolean("cmd_param_is_from_change_bind", false);
      paramPacket.addRequestPacket("RequestVerifySmscode", paramIntent);
      return;
    case 17: 
      paramPacket.setSSOCommand("account.RequestResendBindingSmscode");
      ((RequestHeader)localObject2).cmd = 17;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestResendSmscode();
      paramIntent.sessionSid = ((Bundle)localObject1).getByteArray("session_id");
      paramPacket.addRequestPacket("RequestResendSmscode", paramIntent);
      return;
    case 28: 
      paramPacket.setSSOCommand("account.RequestQueryQQMobileContactsV2");
      ((RequestHeader)localObject2).cmd = 28;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestQueryQQMobileContactsV2();
      paramIntent.Compressd = true;
      paramIntent.nextFlag = ((Bundle)localObject1).getLong("next_flag");
      paramIntent.timeStamp = ((Bundle)localObject1).getLong("time_stamp");
      paramIntent.sessionSid = ((Bundle)localObject1).getByteArray("session_id");
      paramPacket.addRequestPacket("RequestQueryQQMobileContactsV2", paramIntent);
      return;
    case 30: 
      paramPacket.setSSOCommand("account.RequestQueryQQMobileContactsV3");
      ((RequestHeader)localObject2).cmd = 30;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestQueryQQMobileContactsV3();
      paramIntent.Compressd = true;
      paramIntent.nextFlag = ((Bundle)localObject1).getLong("next_flag");
      paramIntent.timeStamp = ((Bundle)localObject1).getLong("time_stamp");
      paramIntent.sessionSid = ((Bundle)localObject1).getByteArray("session_id");
      paramIntent.MaxsignTimeStamp = ((Bundle)localObject1).getLong("richinfo_time_stamp");
      paramIntent.MobileUniqueNo = ((Bundle)localObject1).getString("unique_phone_no");
      paramIntent.queryFlag = ((Bundle)localObject1).getInt("force_query_list");
      paramIntent.queryFrom = ((Bundle)localObject1).getLong("param_query_from");
      paramIntent.OmitOffline = true;
      paramIntent.bindState = ((Bundle)localObject1).getInt("param_bind_state");
      paramPacket.addRequestPacket("RequestQueryQQMobileContactsV3", paramIntent);
      return;
    case 14: 
      paramPacket.setSSOCommand("account.RequestUploadAddressBook");
      ((RequestHeader)localObject2).cmd = 14;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      j = ((Bundle)localObject1).getInt("upload_package_no");
      paramIntent = (ArrayList)((Bundle)localObject1).getSerializable("contact_list");
      if (paramIntent.size() > j * 50 + 50 - 1)
      {
        i = j * 50 + 50;
        localObject2 = paramIntent.subList(j * 50, i);
        localObject3 = new RequestUploadAddressBook();
        ((RequestUploadAddressBook)localObject3).MobileUniqueNo = ((Bundle)localObject1).getString("unique_phone_no");
        ((RequestUploadAddressBook)localObject3).sessionSid = ((Bundle)localObject1).getByteArray("session_id");
        if ((j + 1) * 50 < paramIntent.size()) {
          break label1402;
        }
      }
      for (((RequestUploadAddressBook)localObject3).nextFlag = 4294967295L;; ((RequestUploadAddressBook)localObject3).nextFlag = ((Bundle)localObject1).getLong("next_flag"))
      {
        ((RequestUploadAddressBook)localObject3).AddressBookList = new ArrayList((Collection)localObject2);
        paramPacket.addRequestPacket("RequestUploadAddressBook", (JceStruct)localObject3);
        return;
        i = paramIntent.size();
        break;
      }
    case 31: 
      paramPacket.setSSOCommand("account.RequestUploadAddressBookV2");
      ((RequestHeader)localObject2).cmd = 31;
      ((RequestHeader)localObject2).cmd = 31;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      j = ((Bundle)localObject1).getInt("upload_package_no");
      paramIntent = (ArrayList)((Bundle)localObject1).getSerializable("contact_list");
      if (paramIntent.size() > j * 50 + 50 - 1)
      {
        i = j * 50 + 50;
        localObject2 = paramIntent.subList(j * 50, i);
        localObject3 = new RequestUploadAddressBookV2();
        ((RequestUploadAddressBookV2)localObject3).MobileUniqueNo = ((Bundle)localObject1).getString("unique_phone_no");
        ((RequestUploadAddressBookV2)localObject3).sessionSid = ((Bundle)localObject1).getByteArray("session_id");
        if ((j + 1) * 50 < paramIntent.size()) {
          break label1597;
        }
      }
      for (((RequestUploadAddressBookV2)localObject3).nextFlag = 4294967295L;; ((RequestUploadAddressBookV2)localObject3).nextFlag = ((Bundle)localObject1).getLong("next_flag"))
      {
        ((RequestUploadAddressBookV2)localObject3).AddressBookList = new ArrayList((Collection)localObject2);
        paramPacket.addRequestPacket("RequestUploadAddressBookV2", (JceStruct)localObject3);
        return;
        i = paramIntent.size();
        break;
      }
    case 15: 
      paramPacket.setSSOCommand("account.RequestUpdateAddressBook");
      ((RequestHeader)localObject2).cmd = 15;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = (ArrayList)((Bundle)localObject1).getSerializable("add_contact_list");
      localObject2 = (ArrayList)((Bundle)localObject1).getSerializable("del_contact_list");
      localObject3 = new RequestUpdateAddressBook();
      ((RequestUpdateAddressBook)localObject3).MobileUniqueNo = ((Bundle)localObject1).getString("unique_phone_no");
      ((RequestUpdateAddressBook)localObject3).sessionSid = ((Bundle)localObject1).getByteArray("session_id");
      k = ((Bundle)localObject1).getInt("upload_package_no") * 50;
      j = k + 50;
      if (((paramIntent == null) || (j >= paramIntent.size())) && ((localObject2 == null) || (j >= ((ArrayList)localObject2).size())))
      {
        ((RequestUpdateAddressBook)localObject3).nextFlag = 4294967295L;
        if ((paramIntent == null) || (k >= paramIntent.size())) {
          break label1882;
        }
        i = j;
        if (j > paramIntent.size()) {
          i = paramIntent.size();
        }
        ((RequestUpdateAddressBook)localObject3).AddressBookAddList = new ArrayList(paramIntent.subList(k, i));
        if ((localObject2 == null) || (k >= ((ArrayList)localObject2).size())) {
          break label1894;
        }
        j = i;
        if (i > ((ArrayList)localObject2).size()) {
          j = ((ArrayList)localObject2).size();
        }
      }
      for (((RequestUpdateAddressBook)localObject3).AddressBookDelList = new ArrayList(((ArrayList)localObject2).subList(k, j));; ((RequestUpdateAddressBook)localObject3).AddressBookDelList = null)
      {
        paramPacket.addRequestPacket("RequestUpdateAddressBook", (JceStruct)localObject3);
        return;
        ((RequestUpdateAddressBook)localObject3).nextFlag = ((Bundle)localObject1).getLong("next_flag");
        break;
        ((RequestUpdateAddressBook)localObject3).AddressBookAddList = null;
        i = j;
        break label1801;
      }
    case 32: 
      paramPacket.setSSOCommand("account.RequestQueryLastLoginState");
      ((RequestHeader)localObject2).cmd = 32;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestQueryLastLoginState();
      paramIntent.nextFlag = ((Bundle)localObject1).getLong("next_flag");
      paramIntent.timeStamp = ((Bundle)localObject1).getLong("time_stamp");
      paramIntent.MobileUniqueNo = ((Bundle)localObject1).getString("unique_phone_no");
      paramPacket.addRequestPacket("RequestQueryLastLoginState", paramIntent);
      return;
    case 34: 
      paramPacket.setSSOCommand("account.RequestHideContact");
      ((RequestHeader)localObject2).cmd = 34;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestHideContact();
      paramIntent.contact = ((AddressBookItem)((Bundle)localObject1).getSerializable("param_hiden_mobile"));
      paramIntent.isHide = ((Bundle)localObject1).getBoolean("param_hiden_flag");
      paramPacket.addRequestPacket("RequestHideContact", paramIntent);
      return;
    case 36: 
      paramPacket.setSSOCommand("account.RequestQueryNewUserRecommendedList");
      ((RequestHeader)localObject2).cmd = 36;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestQueryNewUserRecommendedList();
      paramIntent.MobileUniqueNo = ((Bundle)localObject1).getString("unique_phone_no");
      paramIntent.WantNum = ((Bundle)localObject1).getInt("wantCount");
      paramPacket.addRequestPacket("RequestQueryNewUserRecommendedList", paramIntent);
      return;
    case 40: 
      paramPacket.setSSOCommand("account.RequestQueryNewUserRecommendedListNotBind");
      ((RequestHeader)localObject2).cmd = 40;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      paramIntent = new RequestQueryNewUserRecommendedListNotBind();
      paramIntent.MobileUniqueNo = ((Bundle)localObject1).getString("unique_phone_no");
      paramIntent.WantNum = ((Bundle)localObject1).getInt("wantCount");
      paramPacket.addRequestPacket("RequestQueryNewUserRecommendedListNotBind", paramIntent);
      return;
    case 37: 
      label1402:
      paramPacket.setSSOCommand("account.RequestUploadAddressBookNotBind");
      label1597:
      label1882:
      label1894:
      ((RequestHeader)localObject2).cmd = 37;
      label1801:
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
      j = ((Bundle)localObject1).getInt("upload_package_no");
      paramIntent = (ArrayList)((Bundle)localObject1).getSerializable("contact_list");
      if (paramIntent.size() > j * 50 + 50 - 1)
      {
        i = j * 50 + 50;
        localObject2 = paramIntent.subList(j * 50, i);
        localObject3 = new RequestUploadAddressBookNotBind();
        ((RequestUploadAddressBookNotBind)localObject3).MobileUniqueNo = ((Bundle)localObject1).getString("unique_phone_no");
        ((RequestUploadAddressBookNotBind)localObject3).sessionSid = ((Bundle)localObject1).getByteArray("session_id");
        if ((j + 1) * 50 < paramIntent.size()) {
          break label2348;
        }
      }
      label2348:
      for (((RequestUploadAddressBookNotBind)localObject3).nextFlag = 4294967295L;; ((RequestUploadAddressBookNotBind)localObject3).nextFlag = ((Bundle)localObject1).getLong("next_flag"))
      {
        ((RequestUploadAddressBookNotBind)localObject3).AddressBookList = new ArrayList((Collection)localObject2);
        paramPacket.addRequestPacket("RequestUploadAddressBookNotBind", (JceStruct)localObject3);
        return;
        i = paramIntent.size();
        break;
      }
    }
    paramPacket.setSSOCommand("account.RequestUpdateAddressBookNotBind");
    ((RequestHeader)localObject2).cmd = 38;
    paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject2);
    paramIntent = (ArrayList)((Bundle)localObject1).getSerializable("add_contact_list");
    localObject2 = (ArrayList)((Bundle)localObject1).getSerializable("del_contact_list");
    Object localObject3 = new RequestUpdateAddressBookNotBind();
    ((RequestUpdateAddressBookNotBind)localObject3).MobileUniqueNo = ((Bundle)localObject1).getString("unique_phone_no");
    ((RequestUpdateAddressBookNotBind)localObject3).sessionSid = ((Bundle)localObject1).getByteArray("session_id");
    int k = ((Bundle)localObject1).getInt("upload_package_no") * 50;
    int j = k + 50;
    if (((paramIntent == null) || (j >= paramIntent.size())) && ((localObject2 == null) || (j >= ((ArrayList)localObject2).size())))
    {
      ((RequestUpdateAddressBookNotBind)localObject3).nextFlag = 4294967295L;
      if ((paramIntent == null) || (k >= paramIntent.size())) {
        break label2633;
      }
      i = j;
      if (j > paramIntent.size()) {
        i = paramIntent.size();
      }
      ((RequestUpdateAddressBookNotBind)localObject3).AddressBookAddList = new ArrayList(paramIntent.subList(k, i));
      label2552:
      if ((localObject2 == null) || (k >= ((ArrayList)localObject2).size())) {
        break label2645;
      }
      j = i;
      if (i > ((ArrayList)localObject2).size()) {
        j = ((ArrayList)localObject2).size();
      }
    }
    label2633:
    label2645:
    for (((RequestUpdateAddressBookNotBind)localObject3).AddressBookDelList = new ArrayList(((ArrayList)localObject2).subList(k, j));; ((RequestUpdateAddressBookNotBind)localObject3).AddressBookDelList = null)
    {
      paramPacket.addRequestPacket("RequestUpdateAddressBookNotBind", (JceStruct)localObject3);
      return;
      ((RequestUpdateAddressBookNotBind)localObject3).nextFlag = ((Bundle)localObject1).getLong("next_flag");
      break;
      ((RequestUpdateAddressBookNotBind)localObject3).AddressBookAddList = null;
      i = j;
      break label2552;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azox
 * JD-Core Version:    0.7.0.1
 */