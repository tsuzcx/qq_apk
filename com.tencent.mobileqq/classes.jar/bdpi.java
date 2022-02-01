import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler.1;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler.3;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler.4;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler.5;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import java.net.URL;
import java.util.List;
import tencent.im.babyq.babyq_cookie.BabyQCookie;

public class bdpi
  extends bdos
{
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  StructMsgForGeneralShare jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public bdpi(QQAppInterface paramQQAppInterface, View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    super(paramQQAppInterface, paramView);
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare = paramStructMsgForGeneralShare;
    paramQQAppInterface = paramView.getTag();
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof ahtm)))
    {
      paramQQAppInterface = (ahtm)paramQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    }
    do
    {
      return;
      if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof amnq)))
      {
        paramQQAppInterface = (amnq)paramQQAppInterface;
        this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatMessage)paramQQAppInterface.jdField_a_of_type_JavaLangObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramQQAppInterface.jdField_a_of_type_JavaLangString;
        return;
      }
    } while (!(paramQQAppInterface instanceof MessageForStructing));
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((MessageForStructing)paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop;
  }
  
  private void a(Bundle paramBundle)
  {
    ThreadManager.post(new StructMsgForGeneralShare.GeneralClickHandler.1(this, paramBundle), 5, null, false);
  }
  
  private boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(StructMsgForGeneralShare.access$000(), 2, "the share url is" + paramString);
      }
      if (!paramString.contains("ciphertext"))
      {
        this.jdField_a_of_type_JavaLangString = null;
        this.b = null;
        if ((paramString.startsWith("http://mobile.qzone.qq.com")) || (paramString.startsWith("https://mobile.qzone.qq.com"))) {
          try
          {
            paramString = Uri.parse(paramString);
            String str = paramString.getQueryParameter("a");
            if ("311".equals(str)) {
              return true;
            }
            if ("2".equals(str)) {
              return true;
            }
            if ("4".equals(str))
            {
              this.jdField_a_of_type_JavaLangString = paramString.getQueryParameter("albumid");
              this.b = paramString.getQueryParameter("res_uin");
              return true;
            }
          }
          catch (Exception paramString)
          {
            QLog.e(StructMsgForGeneralShare.access$000(), 1, "isNotPermissionUGC catch an exception", paramString);
          }
        }
      }
    }
    return false;
  }
  
  private boolean d(String paramString)
  {
    this.c = null;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("is_famous_space=1")) && (paramString.contains("qzone"))) {
      try
      {
        this.c = Uri.parse(paramString).getQueryParameter("hostuin");
        return true;
      }
      catch (Exception paramString)
      {
        QLog.e(StructMsgForGeneralShare.access$000(), 1, "isForwardToNativeUserHome catch an exception", paramString);
        return false;
      }
    }
    return false;
  }
  
  public boolean a(View paramView, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare == null) || (TextUtils.isEmpty(paramString))) {}
    label44:
    Object localObject;
    label111:
    label113:
    do
    {
      return false;
      paramView = paramView.findViewById(2131371683);
      if (paramView == null)
      {
        int i;
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mStructMsgItemLists.size() > 0)
        {
          i = 1;
          if (!QLog.isColorLevel()) {
            break label111;
          }
          paramString = StructMsgForGeneralShare.access$000();
          localObject = new StringBuilder().append("clickViewFlower error item:");
          if (i == 0) {
            break label113;
          }
        }
        for (paramView = ((bdol)this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mStructMsgItemLists.get(0)).h;; paramView = "")
        {
          QLog.i(paramString, 2, paramView);
          return false;
          i = 0;
          break label44;
          break;
        }
      }
      paramView = (bdra)paramView.getTag();
    } while (paramView == null);
    paramView = paramView.a;
    boolean bool2;
    if ((paramView != null) && (paramView.size() > 0))
    {
      localObject = paramView.getString("groupCode");
      boolean bool1 = paramView.getBoolean("isSend");
      bool2 = paramView.getBoolean("isReceive");
      if ((!bool1) && (!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(paramString)) && (!bool2))
      {
        paramView = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
        if (paramView != null) {}
        for (paramView = paramView.a(paramString);; paramView = null)
        {
          if (paramView != null) {
            axug.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, 1);
          }
          return true;
        }
      }
      if (!bool1) {
        break label284;
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label272;
      }
      aocz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8006390");
    }
    for (;;)
    {
      return true;
      label272:
      aocz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80060B3");
      continue;
      label284:
      if (bool2) {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          aocz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8006391");
        } else {
          aocz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80060B4");
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(StructMsgForGeneralShare.access$000(), 2, "GeneralClickHandler clickWebMsg url = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localContext = this.jdField_a_of_type_AndroidContentContext;
    localStructMsgForGeneralShare = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare;
    for (;;)
    {
      try
      {
        localObject3 = localStructMsgForGeneralShare.uin;
        if (localStructMsgForGeneralShare.uinType != 1) {
          continue;
        }
        i = 2;
        str1 = Long.toString(localStructMsgForGeneralShare.mSourceAppid);
        localObject4 = Integer.toString(localStructMsgForGeneralShare.mMsgServiceID);
        if ((paramString == null) || (paramString.length() <= 150)) {
          continue;
        }
        localObject1 = paramString.substring(0, 150);
      }
      catch (Exception localException1)
      {
        String str1;
        Object localObject1;
        boolean bool;
        localException1.printStackTrace();
        continue;
        Object localObject3 = new BaseBusinessAlbumInfo();
        ((BaseBusinessAlbumInfo)localObject3).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        try
        {
          if (TextUtils.isEmpty(this.b)) {
            continue;
          }
          l = Long.parseLong(this.b);
          ((BaseBusinessAlbumInfo)localObject3).jdField_a_of_type_Long = l;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(StructMsgForGeneralShare.access$000(), 2, "Parsing the albumOwnUin catch a NumberFormatException : " + localNumberFormatException.getMessage());
          continue;
        }
        ((BaseBusinessAlbumInfo)localObject3).c = 0;
        ((BaseBusinessAlbumInfo)localObject3).jdField_a_of_type_Boolean = true;
        bmtd.a((Activity)localContext, localException1, (BaseBusinessAlbumInfo)localObject3, -1, paramString);
        continue;
        long l = 0L;
        continue;
        if ((!d(paramString)) || (TextUtils.isEmpty(this.c))) {
          continue;
        }
        paramString = bmtk.a();
        paramString.jdField_a_of_type_JavaLangString = str1;
        paramString.b = localNumberFormatException.getCurrentNickname();
        bmtd.a((Activity)localContext, paramString, this.c, 0, 0, 0);
        continue;
        if (!bmtd.a((Activity)localContext, localException1, "biz_src_jc_aio")) {
          continue;
        }
        return true;
        if (!MiniAppLauncher.isMiniAppScheme(paramString)) {
          continue;
        }
        MiniAppLauncher.launchMiniAppByScheme(localContext, paramString, 1210);
        return true;
        if ((!becb.a(paramString)) && (localStructMsgForGeneralShare.mSourceAppid != becb.jdField_a_of_type_Long)) {
          continue;
        }
        Object localObject2 = new Bundle();
        ((Bundle)localObject2).putString("url", paramString);
        ((Bundle)localObject2).putBoolean("doc_from_aio", true);
        ((Bundle)localObject2).putString("tdsourcetag", "s_qq_aiomsg");
        TeamWorkDocEditBrowserActivity.a(localContext, (Bundle)localObject2, false);
        return true;
        if ((!(localContext instanceof BaseActivity)) || (!axev.a((BaseActivity)localContext, (String)localObject2, localStructMsgForGeneralShare.message))) {
          continue;
        }
        return true;
        if (!StructMsgForGeneralShare.HandleMiniAppJump(localContext, (String)localObject2)) {
          continue;
        }
        return true;
        Object localObject4 = new Intent(localContext, QQBrowserDelegationActivity.class);
        ((Intent)localObject4).putExtra("param_force_internal_browser", true);
        if (!bool) {
          continue;
        }
        paramString = nmj.a(paramString, "platformId=qq_m");
        String str2 = paramString.trim();
        ((Intent)localObject4).putExtra("injectrecommend", false);
        ((Intent)localObject4).putExtra("key_isReadModeEnabled", true);
        ((Intent)localObject4).putExtra("url", str2);
        ((Intent)localObject4).putExtra("friendUin", localStructMsgForGeneralShare.uin);
        ((Intent)localObject4).putExtra("isAppShare", true);
        ((Intent)localObject4).putExtra("appShareID", l);
        ((Intent)localObject4).putExtra("uin_type", localStructMsgForGeneralShare.uinType);
        ((Intent)localObject4).putExtra("msg_id", Long.toString(localStructMsgForGeneralShare.msgId));
        ((Intent)localObject4).putExtra("puin", localStructMsgForGeneralShare.uin);
        ((Intent)localObject4).putExtra("self_uin", str1);
        if (localStructMsgForGeneralShare.message == null) {
          continue;
        }
        ((Intent)localObject4).putExtra("friend_uin", localStructMsgForGeneralShare.message.frienduin);
        ((Intent)localObject4).putExtra("fromOneCLickCLose", true);
        if ((localStructMsgForGeneralShare.message != null) && (localStructMsgForGeneralShare.message.istroop == 1008)) {
          continue;
        }
        ((Intent)localObject4).putExtra("big_brother_source_key", "biz_src_jc_aio");
        if ((TextUtils.isEmpty(str2)) || (!bhjx.b(localStructMsgForGeneralShare.uin))) {
          continue;
        }
        paramString = str2.split("&");
        if (paramString == null) {
          continue;
        }
        int i = 0;
        if (i >= paramString.length) {
          continue;
        }
        if (!paramString[i].contains("from_type")) {
          continue;
        }
        localObject3 = paramString[i].split("=");
        if ((localObject3 == null) || (localObject3.length != 2)) {
          continue;
        }
        localObject3 = localObject3[1];
        Object localObject5 = localStructMsgForGeneralShare.mMsg_I_ActionData.split(":");
        if ((localObject5 == null) || (localObject5.length != 2)) {
          continue;
        }
        localObject5 = localObject5[1];
        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject5))) {
          continue;
        }
        paramString = new Bundle();
        paramString.putString("src_type", "internal");
        paramString.putString("version", "1");
        paramString.putString("callback_type", "scheme");
        paramString.putString("callback_name", "open_card");
        paramString.putString("uin", (String)localObject5);
        paramString.putString("card_type", "group");
        paramString.putString("authKey", null);
        paramString.putString("from", "qrcode");
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          continue;
        }
        paramString.putString("from_type", (String)localObject3);
        paramString.putString("jump_from", "QRJumpActivity");
        paramString = bhni.a(localNumberFormatException, localContext, Uri.parse("mqqapi://card/show_pslcard?" + nnr.a(paramString)).toString());
        if (paramString == null) {
          continue;
        }
        paramString.a();
        return true;
        i += 1;
        continue;
        if (Aladdin.getConfig(261).getIntegerFromString("enable_floating_layer_style", 0) != 1) {
          continue;
        }
        QLog.d(StructMsgForGeneralShare.access$000(), 1, "enable_floating_layer_style = 1");
        if (!bnrm.a(this.jdField_a_of_type_AndroidContentContext, str2)) {
          continue;
        }
        return true;
        if ((TextUtils.isEmpty(str2)) || (!tzq.c(str2)) || (!tbz.b(str2))) {
          continue;
        }
        tbz.a(localContext, null, tbz.b(str2), null);
        return true;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) || (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop != 0) || (!bhjx.b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("guide_msg_cookie")))) {
          continue;
        }
        paramString = bhjx.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("guide_msg_cookie"));
        if (paramString == null) {
          continue;
        }
        localObject3 = new babyq_cookie.BabyQCookie();
        try
        {
          ((babyq_cookie.BabyQCookie)localObject3).mergeFrom(paramString);
          if (((babyq_cookie.BabyQCookie)localObject3).uint32_type.get() == 206) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b("babyq_game_tribe");
          }
          ((Intent)localObject4).putExtra("source_puin", localStructMsgForGeneralShare.source_puin);
          if (localStructMsgForGeneralShare.uinType == 0)
          {
            ((Intent)localObject4).putExtra("articalChannelId", 2);
            agdz.a((Intent)localObject4, localNumberFormatException, localStructMsgForGeneralShare.message);
            if ((tzq.a(localNumberFormatException, localStructMsgForGeneralShare.uin) != -1) || (str2.startsWith("http://browserApp.p.qq.com/")))
            {
              ((Intent)localObject4).setClass(localContext, PublicAccountBrowser.class);
              paramString = new Bundle();
              paramString.putString("uin", localStructMsgForGeneralShare.uin);
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
              {
                paramString.putInt("uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                paramString.putString("uin_name", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
              }
              paramString.putBoolean("switch_msg_btn", tzq.a());
              ((Intent)localObject4).putExtras(paramString);
            }
            if (localStructMsgForGeneralShare.mMsgServiceID != 123) {
              continue;
            }
            if (localStructMsgForGeneralShare.uinType != 1) {
              continue;
            }
            bool = aqzo.a(localNumberFormatException, localStructMsgForGeneralShare.uin);
            paramString = ((Intent)localObject4).getStringExtra("url");
            if ((bool) && (!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(localStructMsgForGeneralShare.uin)))
            {
              paramString = "https://ti.qq.com/honest-say/group.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&gc=$GCODE$&src_type=share&from=appstore_aio&adtag=qq_to_qq".replace("$GCODE$", axwz.a(localStructMsgForGeneralShare.uin));
              ((Intent)localObject4).removeExtra("url");
              ((Intent)localObject4).putExtra("url", paramString);
              if (QLog.isColorLevel()) {
                QLog.i(StructMsgForGeneralShare.access$000(), 2, "GeneralClickHandler clickWebMsg confess groupUin:" + localStructMsgForGeneralShare.uin + ",paramUrl=" + paramString);
              }
              if ((localContext instanceof FragmentActivity))
              {
                localObject2 = ((FragmentActivity)localContext).getChatFragment();
                if (localObject2 != null)
                {
                  localObject3 = ((ChatFragment)localObject2).getActivity().getIntent();
                  ((Intent)localObject3).putExtra("url", paramString);
                  ((Intent)localObject3).putExtra("confess_half_screen_web", true);
                  paramString = ((ChatFragment)localObject2).a();
                  if ((paramString != null) && ((paramString instanceof TroopChatPie))) {
                    aqzo.a((TroopChatPie)paramString);
                  }
                }
              }
            }
            if (bool) {
              continue;
            }
            QQToast.a(BaseApplicationImpl.getContext(), aqzo.jdField_a_of_type_JavaLangString, 0).a();
            return false;
          }
        }
        catch (InvalidProtocolBufferMicroException paramString)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(StructMsgForGeneralShare.access$000(), 2, "babbyq -> sendSpecialMessage:" + paramString.getStackTrace());
          continue;
          if (localStructMsgForGeneralShare.uinType == 1)
          {
            ((Intent)localObject4).putExtra("articalChannelId", 3);
            continue;
          }
          if (localStructMsgForGeneralShare.uinType == 3000)
          {
            ((Intent)localObject4).putExtra("articalChannelId", 4);
            continue;
          }
          if (localStructMsgForGeneralShare.uinType != 1008) {
            continue;
          }
          ((Intent)localObject4).putExtra("articalChannelId", 1);
          ((Intent)localObject4).putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
          ((Intent)localObject4).putExtra("big_brother_source_key", tzq.b(localStructMsgForGeneralShare.source_puin));
          continue;
          ThreadManager.post(new StructMsgForGeneralShare.GeneralClickHandler.3(this, localNumberFormatException), 5, null, true);
          return true;
        }
        ThreadManager.post(new StructMsgForGeneralShare.GeneralClickHandler.4(this, localNumberFormatException), 5, null, true);
        if ((localStructMsgForGeneralShare.mMsgServiceID != 14) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {
          continue;
        }
        paramString = bgpy.a(localStructMsgForGeneralShare, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        ((Intent)localObject4).removeExtra("url");
        ((Intent)localObject4).putExtra("url", paramString);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(StructMsgForGeneralShare.access$000(), 2, "robot card, use new url:" + localStructMsgForGeneralShare.uin + ",paramUrl=" + paramString);
        ThreadManager.excute(new StructMsgForGeneralShare.GeneralClickHandler.5(this, paramString, localNumberFormatException), 16, null, true);
        if ((localStructMsgForGeneralShare.mMsgServiceID != 83) && (localStructMsgForGeneralShare.mMsgServiceID != 108) && (localStructMsgForGeneralShare.mMsgServiceID != 114) && (localStructMsgForGeneralShare.mMsgServiceID != 116)) {
          continue;
        }
        paramString = "";
        localObject3 = Uri.parse((String)localObject2);
        try
        {
          localObject3 = ((Uri)localObject3).getQueryParameter("article_id");
          paramString = (String)localObject3;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
          bdmc.a(BaseApplication.getContext()).a(localNumberFormatException, "sha_click", 1, "", "", String.valueOf(localStructMsgForGeneralShare.mSourceAppid));
        }
        if (TextUtils.isEmpty(localStructMsgForGeneralShare.mMsgActionData)) {
          continue;
        }
        i = 1;
        ocd.a(null, "", "0X8007555", "0X8007555", 0, 0, paramString, "", "" + i, "");
        ocd.a("0X8007555", "", paramString, "", "" + i, "");
        if (localStructMsgForGeneralShare.mSourceAppid != 1101244924L) {
          continue;
        }
        ((Intent)localObject4).putExtra("BUDNLE_KEY_IS_MY_PROFILE", str2.contains("gene/index.html?uin=" + localStructMsgForGeneralShare.currentAccountUin));
        ((Intent)localObject4).setClass(localContext, MusicGeneQQBrowserActivity.class);
        tzq.a(localStructMsgForGeneralShare.message, (Intent)localObject4, str2);
        if ((TextUtils.isEmpty(localStructMsgForGeneralShare.mContentTitle)) || (TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).startsWith("https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128"))) {
          continue;
        }
        ((Intent)localObject4).putExtra("title", localStructMsgForGeneralShare.mContentTitle);
        agbh.a(localContext, (Intent)localObject4, str2);
        bdll.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, str2, "", "", "");
        if (!bool) {
          continue;
        }
        bdmc.a(BaseApplication.getContext()).a(localNumberFormatException, str1, "Game_center", "Clk_game_in", 0, 1, null, String.valueOf(localStructMsgForGeneralShare.mSourceAppid), null, null, null);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(StructMsgForGeneralShare.access$000(), 2, "robot card, use old url:" + localStructMsgForGeneralShare.uin + ",paramUrl=" + ((Intent)localObject4).getStringExtra("url"));
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) {
          continue;
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin;
        if (52 != localStructMsgForGeneralShare.mMsgServiceID) {
          continue;
        }
        if (!paramString.equals(str1)) {
          continue;
        }
        bdll.b(localNumberFormatException, "CliOper", "", "", "0X80052BB", "0X80052BB", 0, 0, "", "", "", "");
        continue;
        bdll.b(localNumberFormatException, "CliOper", "", "", "0X80052BC", "0X80052BC", 0, 0, "", "", "", "");
        continue;
        i = 2;
        continue;
        continue;
        localObject2 = paramString;
        continue;
      }
      str2 = new URL(paramString).getHost();
      bdll.b(null, "CliOper", "", (String)localObject3, "0X80061B0", "0X80061B0", i, 0, str1, (String)localObject4, (String)localObject1, str2);
      if (QLog.isDebugVersion()) {
        QLog.d(StructMsgForGeneralShare.access$000(), 4, String.format("the report params:%s,%s,%s,%s", new Object[] { str1, localObject4, localObject1, str2 }));
      }
      localObject1 = paramString;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mMsgServiceID == 107)
      {
        paramString = paramString + "&msgSeq=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uniseq + "&resId=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mResid + "&uin=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin + "&sessionType=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uinType;
        localObject1 = paramString;
        if (StructMsgForGeneralShare.receiptServer == null)
        {
          StructMsgForGeneralShare.receiptServer = new bdpj(this, "receipt_msg");
          QIPCServerHelper.getInstance().register(StructMsgForGeneralShare.receiptServer);
          localObject1 = paramString;
        }
      }
      paramString = ((String)localObject1).trim();
      bool = paramString.startsWith("https://gamecenter.qq.com");
      l = bhki.a(localStructMsgForGeneralShare.mSourceAppid);
      str1 = localQQAppInterface.getCurrentAccountUin();
      if ((localContext instanceof FragmentActivity))
      {
        localObject3 = ((FragmentActivity)localContext).getChatFragment();
        if (localObject3 != null)
        {
          localObject3 = ((ChatFragment)localObject3).a();
          if ((localObject3 instanceof ainh))
          {
            localObject4 = (ainh)localObject3;
            ((ainh)localObject4).z += 1;
            localObject3 = (ainh)localObject3;
            ((ainh)localObject3).x += 1;
          }
        }
      }
      if (!c(paramString)) {
        continue;
      }
      localObject1 = bmtk.a();
      ((bmtk)localObject1).jdField_a_of_type_JavaLangString = str1;
      ((bmtk)localObject1).b = localQQAppInterface.getCurrentNickname();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        continue;
      }
      bmtd.a((Activity)localContext, (bmtk)localObject1, paramString, "mqqChat", -1);
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.istroop == 1008)) {
        obj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin);
      }
      return false;
      i = 1;
    }
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(StructMsgForGeneralShare.access$000(), 2, "GeneralClickHandler clickPluginMsg actionData = " + paramString1 + ", actionDataA = " + paramString2);
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      paramString1 = bhni.a(localQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString1);
      if (paramString1 == null) {
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message != null) && (bhjx.b(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.senderuin))) {
        paramString1.a("msg_uniseq", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.senderuin);
      }
      paramString1.a();
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.istroop == 1008)) {
        obj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin);
      }
      return true;
      paramString1 = paramString2;
    }
    if (QLog.isColorLevel()) {
      QLog.d(StructMsgForGeneralShare.access$000(), 2, "GeneralShareMsg _ACTION_PLUGIN_ mContentOnClickListener: JumpAction is null.");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdpi
 * JD-Core Version:    0.7.0.1
 */