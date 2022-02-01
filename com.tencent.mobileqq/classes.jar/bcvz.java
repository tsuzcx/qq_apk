import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.im.babyq.babyq_cookie.BabyQCookie;

public class bcvz
{
  private static bkho jdField_a_of_type_Bkho;
  Context jdField_a_of_type_AndroidContentContext;
  public QQAppInterface a;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  
  public bcvz(QQAppInterface paramQQAppInterface, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    if ((paramQQAppInterface == null) && (FragmentActivity.class.isInstance(this.jdField_a_of_type_AndroidContentContext)))
    {
      paramQQAppInterface = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (paramQQAppInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface.a().a();
      }
    }
  }
  
  public bcvz(QQAppInterface paramQQAppInterface, View paramView, MessageRecord paramMessageRecord)
  {
    this(paramQQAppInterface, paramView);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  private static void a(Context paramContext, String paramString)
  {
    if ((jdField_a_of_type_Bkho == null) || (!jdField_a_of_type_Bkho.getContext().equals(paramContext)))
    {
      jdField_a_of_type_Bkho = bkho.a(paramContext);
      jdField_a_of_type_Bkho.a(2131691437, 1);
      jdField_a_of_type_Bkho.a(2131691140, 1);
      jdField_a_of_type_Bkho.c(2131690582);
      jdField_a_of_type_Bkho.a(String.format(paramContext.getString(2131694051), new Object[] { paramString }));
      jdField_a_of_type_Bkho.a(new bcwa(paramString, paramContext));
    }
    if (!jdField_a_of_type_Bkho.isShowing()) {
      jdField_a_of_type_Bkho.show();
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
      bool1 = false;
    }
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
                do
                {
                  return bool1;
                  localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class);
                  ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
                  ((Intent)localObject).putExtra("url", paramString);
                  ((Intent)localObject).putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
                  ((Intent)localObject).putExtra("articalChannelId", 1);
                  tzo.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, (Intent)localObject, paramString);
                  this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
                  bool1 = bool2;
                } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null);
                bool1 = bool2;
              } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
              bool1 = bool2;
            } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop != 0);
            bool1 = bool2;
          } while (!bgjw.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin));
          bool1 = bool2;
        } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("guide_msg_cookie")));
        paramString = bgjw.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"));
        bool1 = bool2;
      } while (paramString == null);
      Object localObject = new babyq_cookie.BabyQCookie();
      try
      {
        ((babyq_cookie.BabyQCookie)localObject).mergeFrom(paramString);
        switch (((babyq_cookie.BabyQCookie)localObject).uint32_type.get())
        {
        case 204: 
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b("babyq_game_strategy");
          return true;
        }
      }
      catch (InvalidProtocolBufferMicroException paramString)
      {
        bool1 = bool2;
      }
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, "babbyq -> sendSpecialMessage:" + paramString.getStackTrace());
    return true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b("babyq_game_gift");
    return true;
    return true;
  }
  
  public boolean a(String paramString, long paramLong, Object... paramVarArgs)
  {
    if (com.tencent.mobileqq.microapp.sdk.MiniAppLauncher.isMiniAppScheme(paramString))
    {
      com.tencent.mobileqq.microapp.sdk.MiniAppLauncher.launchMiniAppByScheme(this.jdField_a_of_type_AndroidContentContext, paramString, 1211);
      return true;
    }
    if (com.tencent.mobileqq.mini.sdk.MiniAppLauncher.isMiniAppUrl(paramString))
    {
      com.tencent.mobileqq.mini.sdk.MiniAppLauncher.startMiniApp(this.jdField_a_of_type_AndroidContentContext, paramString, 1043, null);
      return true;
    }
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
      return false;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("url", paramString);
    Object localObject;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject != null)
      {
        int i = ((ChatFragment)localObject).a().b();
        if (i == 1008)
        {
          String str = ((ChatFragment)localObject).a().a();
          localIntent.putExtra("puin", str);
          localIntent.putExtra("uin_type", i);
          localIntent.putExtra("msg_id", String.valueOf(paramLong));
          localIntent.putExtra("switch_msg_btn", tzo.a());
          localIntent.putExtra("articalChannelId", 1);
          localIntent.putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
          localIntent.putExtra("fromOneCLickCLose", true);
          localObject = tzo.b(str);
          if ((!"3046055438".equals(str)) || (paramVarArgs == null) || (paramVarArgs.length <= 0) || (!(paramVarArgs[0] instanceof Boolean)) || (!((Boolean)paramVarArgs[0]).booleanValue())) {
            break label321;
          }
        }
      }
    }
    label321:
    for (paramVarArgs = "biz_src_ads";; paramVarArgs = (Object[])localObject)
    {
      localIntent.putExtra("big_brother_source_key", paramVarArgs);
      tzo.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localIntent, paramString);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      localObject = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
      if (((FragmentActivity)localObject).getChatFragment() != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("StructMsg", 2, "chatfragment is null");
      }
      return true;
      paramString1 = paramString2;
    }
    int i = ((FragmentActivity)localObject).getChatFragment().a().b();
    paramString2 = ((FragmentActivity)localObject).getChatFragment().a().b();
    Object localObject = ((FragmentActivity)localObject).getChatFragment().a().a();
    Intent localIntent = afur.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), null);
    localIntent.putExtra("uin", (String)localObject);
    localIntent.putExtra("uintype", i);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("forward_type", -1);
    localIntent.putExtra("forward_text", paramString1);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      paramString2 = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
      if (paramString2.getChatFragment() != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("StructMsg", 2, "chatfragment is null");
      }
      return true;
      paramString1 = paramString2;
    }
    paramString2 = paramString2.getChatFragment().a().a();
    nzz.a().a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1, false, 0.0D, 0.0D, null, paramInt, paramLong, 2);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3)) {}
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        int i = paramString2.indexOf("://");
        Object localObject = "";
        if (i == -1)
        {
          paramString3 = paramString2;
          paramString2 = (String)localObject;
          label39:
          localObject = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
        }
        try
        {
          if (((PackageManager)localObject).getPackageInfo(paramString3, 1) != null)
          {
            localObject = ((PackageManager)localObject).getLaunchIntentForPackage(paramString3);
            if (localObject != null)
            {
              if (!TextUtils.isEmpty(paramString2)) {
                ((Intent)localObject).setData(Uri.parse(paramString2));
              }
              anvf.a("structmsg", "", paramString3, "1", "structmsgClick", this.jdField_a_of_type_AndroidContentContext.getClass().getName());
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
              return true;
              paramString2 = paramString3;
              continue;
              paramString3 = paramString2.substring(0, i);
              paramString2 = paramString2.substring(i + 3);
              break label39;
            }
            return false;
          }
        }
        catch (Exception paramString2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, paramString2.getMessage());
          }
        }
      }
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramString2.putExtra("key_isReadModeEnabled", true);
      paramString2.putExtra("url", paramString1);
      paramString2.putExtra("fromAio", true);
      tzo.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramString2, paramString1);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramString2);
      bcst.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString1, "", "", "");
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return a(paramString1, paramString2, paramString3, paramString4, 0L, new Object[0]);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, Object... paramVarArgs)
  {
    Object localObject2;
    Object localObject1;
    MessageForStructing localMessageForStructing;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("StructMsgClickHandler doAction action = ").append(paramString1).append(", url = ").append(paramString2).append(", actionData = ").append(paramString3).append(", actionDataA = ").append(paramString4);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        localObject1 = ", args = " + paramVarArgs[0];
        QLog.d("StructMsg", 2, (String)localObject1);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
      {
        localObject1 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (localObject1 != null)
        {
          localObject2 = ((ChatFragment)localObject1).a().a();
          int i = ((ChatFragment)localObject1).a().b();
          if ((paramString1 != null) && (!paramString1.equals("")) && (i == 1008)) {
            nzz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2);
          }
          if (((((ChatFragment)localObject1).a() instanceof aidp)) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForStructing)))
          {
            localMessageForStructing = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
            localObject1 = "";
            if (localMessageForStructing.mExJsonObject != null) {
              localObject1 = localMessageForStructing.mExJsonObject.optString("report_key_bytes_oac_msg_extend");
            }
            if (!(localMessageForStructing.structingMsg instanceof StructMsgForHypertext)) {
              break label338;
            }
            aoqq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, 0, 2, paramLong, (String)localObject1);
          }
        }
      }
      label268:
      if (!"web".equals(paramString1)) {
        break label417;
      }
      if (paramLong <= 0L) {
        break label407;
      }
    }
    label407:
    for (boolean bool1 = a(paramString2, paramLong, paramVarArgs);; bool1 = a(paramString2))
    {
      boolean bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (paramLong > 0L) {
          bool2 = a(paramString2, null, 2, paramLong);
        }
      }
      return bool2;
      localObject1 = "";
      break;
      label338:
      if ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)) {
        break label268;
      }
      if ((localMessageForStructing.structingMsg instanceof StructMsgForImageShare))
      {
        aoqq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, 0, 1, paramLong, (String)localObject1);
        break label268;
      }
      if (!(localMessageForStructing.structingMsg instanceof StructMsgForAudioShare)) {
        break label268;
      }
      aoqq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, 0, 5, paramLong, (String)localObject1);
      break label268;
    }
    label417:
    if ("app".equals(paramString1)) {
      return a(paramString2, paramString3, paramString4);
    }
    if ("plugin".equals(paramString1))
    {
      if ((TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString2))) {
        return c(paramString2, null);
      }
      return c(paramString3, paramString4);
    }
    if ("auto".equals(paramString1)) {
      return b(paramString2);
    }
    if ("replyMsg".equals(paramString1)) {
      return a(paramString3, paramString4);
    }
    if ("replyCmd".equals(paramString1))
    {
      if (paramLong == 0L) {
        return b(paramString3, paramString4);
      }
      return a(paramString3, null, 1, paramLong);
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    if (paramString.startsWith("tel:"))
    {
      paramString = paramString.substring("tel:".length());
      a(this.jdField_a_of_type_AndroidContentContext, paramString);
    }
    for (;;)
    {
      return true;
      try
      {
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        paramString.putExtra("com.android.browser.application_id", this.jdField_a_of_type_AndroidContentContext.getPackageName());
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramString);
      }
      catch (Exception paramString) {}
      if (QLog.isColorLevel()) {
        QLog.d("HyperTextMsg", 2, paramString.getMessage());
      }
    }
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      paramString2 = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
      if (paramString2.getChatFragment() != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("StructMsg", 2, "chatfragment is null");
      }
      return true;
      paramString1 = paramString2;
    }
    paramString2 = paramString2.getChatFragment().a().a();
    nzz.a().a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1, false, 0.0D, 0.0D, null, 1, 0L, 2);
    return true;
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "StructMsgClickHandler clickPluginMsg  actionData = " + paramString1 + ", actionDataA = " + paramString2);
    }
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.equals(paramString1, "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent")) {
        break label66;
      }
    }
    label66:
    do
    {
      for (;;)
      {
        return true;
        paramString1 = paramString2;
        break;
        try
        {
          paramString1 = bgng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString1);
          if (paramString1 != null)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
              paramString1.a("msg_uniseq", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq));
            }
            paramString1.a();
            if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 0) && (bgjw.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"))))
            {
              paramString1 = bgjw.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"));
              if (paramString1 != null)
              {
                paramString2 = new babyq_cookie.BabyQCookie();
                paramString2.mergeFrom(paramString1);
                if (paramString2.uint32_type.get() == 207)
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b("baqyq_mayknow_people");
                  return true;
                }
              }
            }
          }
        }
        catch (Exception paramString1) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, paramString1.getMessage(), paramString1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcvz
 * JD-Core Version:    0.7.0.1
 */