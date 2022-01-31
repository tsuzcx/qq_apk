import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.1.1;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicJumpActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class awuh
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  
  public awuh(AbsShareMsg paramAbsShareMsg) {}
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long < 1000L) {}
    AbsShareMsg localAbsShareMsg;
    Context localContext;
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
          localObject1 = paramView.getTag();
        } while ((localObject1 == null) || (!AbsShareMsg.class.isInstance(localObject1)));
        localAbsShareMsg = (AbsShareMsg)localObject1;
        localContext = paramView.getContext();
      } while ((!SplashActivity.class.isInstance(localContext)) && (!ChatActivity.class.isInstance(localContext)));
      if (localContext == null)
      {
        QLog.e("StructMsg", 1, "context is null, never do click, return");
        return;
      }
      localObject1 = ((FragmentActivity)localContext).getChatFragment();
      if (localObject1 == null)
      {
        QLog.e("StructMsg", 1, "context.getChatFragment is null, never do click, return");
        return;
      }
      localQQAppInterface = ((ChatFragment)localObject1).a();
    } while (localQQAppInterface == null);
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData.startsWith("mqqapi://qsubscribe")))
    {
      QLog.i("StructMsg", 2, "scheme jump to subscribe hybird");
      try
      {
        paramView = new Intent(localContext, JumpActivity.class);
        paramView.setData(Uri.parse(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData));
        paramView.putExtra("from", "from_aio");
        localContext.startActivity(paramView);
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
    }
    Object localObject3 = new awuj(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, localQQAppInterface, paramView);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAction;
    paramView = (View)localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAction.equals("web"))
    {
      paramView = (View)localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl.contains("webcard.mp.qq.com"))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
        paramView = "plugin";
        ((AbsShareMsg)localObject1).mSourceAction = "plugin";
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.source_puin });
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "mSourceOnClickListener sourceAction = " + paramView);
    }
    if ("app".equals(paramView)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData.startsWith("comic_plugin.apk")))
      {
        paramView = new Intent(localContext, VipComicJumpActivity.class);
        paramView.putExtra("options", "{\"from\":28}");
        localContext.startActivity(paramView);
        localObject1 = adww.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData);
        if ((localObject1 != null) && (localObject1.length >= 8))
        {
          if (!localObject1[7].equals("link")) {
            break label1080;
          }
          paramView = localObject1[4];
        }
      }
    }
    for (;;)
    {
      bezp.a(null, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.uin, localContext, "3009", "2", "40059", localObject1[0], new String[] { localObject1[2], localObject1[4], paramView });
      paramView = "";
      label495:
      bcad.a().a(localQQAppInterface.getAccount(), "", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid), "1000", "80", "0", false);
      label525:
      mpw.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.uin, "sourceclick", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID, paramView);
      awqx.b(localQQAppInterface, "CliOper", "", "", "0X800567C", "0X800567C", 0, 0, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID + "", "", "", "");
      awqx.b(localQQAppInterface, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID + "", "", "", "");
      awqx.b(localQQAppInterface, "dc00898", "", "", "0X8007C39", "0X8007C39", 0, 0, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID + "", "", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, "");
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.adverSign == 1) {
        awqx.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.uin, "0X800631F", "0X800631F", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.msgId, "", "", "");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 114) {
        ThreadManager.post(new AbsShareMsg.1.1(this, localQQAppInterface), 0, null, false);
      }
      label1080:
      label2113:
      if (((localAbsShareMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)localAbsShareMsg).mIsPAVideoStructMsg))
      {
        localObject1 = (StructMsgForGeneralShare)localAbsShareMsg;
        localObject3 = ((StructMsgForGeneralShare)localObject1).iterator();
        label842:
        while (((Iterator)localObject3).hasNext())
        {
          paramView = (awul)((Iterator)localObject3).next();
          if ((paramView instanceof awyc))
          {
            Iterator localIterator = ((awyc)paramView).a.iterator();
            label882:
            awzo localawzo;
            String str1;
            label991:
            String str2;
            while (localIterator.hasNext())
            {
              paramView = (awul)localIterator.next();
              if ((paramView instanceof awzo))
              {
                localawzo = (awzo)paramView;
                if (localawzo.a())
                {
                  paramView = new qmv(null, ((StructMsgForGeneralShare)localObject1).source_puin, localawzo.U, localawzo.Z);
                  paramView.a("aio_app_id", Long.valueOf(((StructMsgForGeneralShare)localObject1).mSourceAppid));
                  str1 = paramView.a().a();
                  paramView = "";
                  if (((StructMsgForGeneralShare)localObject1).uinType != 1008) {
                    break label2065;
                  }
                  paramView = "1";
                  ndn.a(null, "CliOper", "", "", "0X80065FE", "0X80065FE", 0, 0, paramView, Integer.toString(new.a(localawzo.p, ((StructMsgForGeneralShare)localObject1).mSourceName)), "", str1, false);
                  str2 = ((StructMsgForGeneralShare)localObject1).source_puin;
                  if (localawzo.Z == null) {
                    break label2113;
                  }
                }
              }
            }
            for (paramView = localawzo.Z;; paramView = "0")
            {
              ndn.a(localQQAppInterface, str2, "0x8007410", "0x8007410", 0, 0, "1", "", paramView, str1, false);
              break label882;
              break label842;
              if ((!localObject1[7].equals("scrawl_link")) || (localObject1.length < 9)) {
                break label2232;
              }
              paramView = localObject1[8];
              break;
              if (((awuj)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData))
              {
                localObject1 = "run";
                if (localAbsShareMsg.mSourceAppid == -1L) {}
                for (paramView = "";; paramView = String.valueOf(localAbsShareMsg.mSourceAppid))
                {
                  awqx.b(null, "dc00898", "", "", "0X800A86D", "0X800A86D", 0, 0, paramView, "", "", "");
                  paramView = (View)localObject1;
                  break;
                }
              }
              if (((awuj)localObject3).a(((FragmentActivity)localContext).getActivity(), this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid, localAbsShareMsg.mSourceName, localAbsShareMsg.mSourceActionData, localAbsShareMsg.mSource_A_ActionData))
              {
                localObject1 = "setup";
                if (localAbsShareMsg.mSourceAppid == -1L) {}
                for (paramView = "";; paramView = String.valueOf(localAbsShareMsg.mSourceAppid))
                {
                  awqx.b(null, "dc00898", "", "", "0X800A86E", "0X800A86E", 0, 0, paramView, "", "", "");
                  paramView = (View)localObject1;
                  break;
                }
              }
              ((awuj)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl);
              paramView = "setup";
              break label495;
              if ("web".equals(paramView))
              {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl;
                if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 114)
                {
                  paramView = ((MedalWallMng)localQQAppInterface.getManager(250)).a(true, localQQAppInterface.getCurrentAccountUin(), MedalWallMng.g);
                  label1380:
                  if ((TextUtils.isEmpty(paramView)) || (!paramView.equals("mqqapi://readinjoy/open?src_type=internal&version=1&target=1"))) {
                    break label1591;
                  }
                  localObject1 = bade.a(localQQAppInterface, localContext, paramView);
                  if (localObject1 == null) {
                    break label1565;
                  }
                  ((bacn)localObject1).c();
                  awqx.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramView, "", "", "");
                }
                for (;;)
                {
                  paramView = "setup";
                  break;
                  paramView = (View)localObject1;
                  if (localAbsShareMsg.uinType != 1) {
                    break label1380;
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 116)
                  {
                    paramView = (View)localObject1;
                    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 123) {
                      break label1380;
                    }
                  }
                  localObject1 = String.format("%s&gc=%s", new Object[] { localObject1, asfj.a(localAbsShareMsg.uin) });
                  paramView = (View)localObject1;
                  if (!QLog.isColorLevel()) {
                    break label1380;
                  }
                  QLog.i("StructMsg", 2, "GeneralClickHandler clickWebMsg source confess groupUin:" + localAbsShareMsg.uin);
                  paramView = (View)localObject1;
                  break label1380;
                  localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse(paramView)));
                  break label1418;
                  ((awuj)localObject3).a(paramView);
                }
              }
              if ("plugin".equals(paramView))
              {
                if ((localAbsShareMsg.uinType == 1) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 123))
                {
                  this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData = alyx.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData, localAbsShareMsg.uin);
                  boolean bool = alyx.a(localQQAppInterface, localAbsShareMsg.uin);
                  paramView = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl;
                  if ((bool) && (!TextUtils.isEmpty(paramView)) && ((localContext instanceof FragmentActivity)))
                  {
                    localObject3 = ((FragmentActivity)localContext).getChatFragment();
                    if (localObject3 != null)
                    {
                      paramView = ((ChatFragment)localObject3).a();
                      if ((paramView != null) && ((paramView instanceof aejb)))
                      {
                        localObject1 = "https://ti.qq.com/honest-say/group.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&gc=$GCODE$&src_type=share&from=appstore_aio&adtag=qq_to_qq".replace("$GCODE$", asfj.a(localAbsShareMsg.uin));
                        if (QLog.isColorLevel()) {
                          QLog.i("StructMsg", 2, "AbsShareMsg clickWebMsg confess groupUin:" + localAbsShareMsg.uin + ",paramUrl=" + (String)localObject1);
                        }
                        localObject3 = ((ChatFragment)localObject3).getActivity().getIntent();
                        ((Intent)localObject3).putExtra("url", (String)localObject1);
                        ((Intent)localObject3).putExtra("confess_half_screen_web", true);
                        alyx.a((aejb)paramView);
                      }
                    }
                  }
                  if (!bool) {
                    bbmy.a(BaseApplicationImpl.getContext(), alyx.a, 0).a();
                  }
                  if (QLog.isColorLevel()) {
                    QLog.i("StructMsg", 2, "GeneralClickHandler clickWebMsg source confess url:" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData);
                  }
                }
                for (;;)
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName.equals(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.readInjoy)) {
                    paramView = null;
                  }
                  try
                  {
                    localObject1 = Uri.parse(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl).getQueryParameter("article_id");
                    paramView = (View)localObject1;
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      localException.printStackTrace();
                      continue;
                      ndn.a(null, "", "0X8007756", "0X8007756", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl, "", "", false);
                    }
                  }
                  if (TextUtils.isEmpty(paramView)) {
                    break label2003;
                  }
                  ndn.a(null, "", "0X8007756", "0X8007756", 0, 0, paramView, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl, "", "", false);
                  paramView = "plugin";
                  break;
                  ((awuj)localObject3).c(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData);
                }
              }
              label2003:
              ((awuj)localObject3).a(paramView, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData);
              break label525;
              if (localException.uinType == 0)
              {
                paramView = "2";
                break label991;
              }
              if (localException.uinType == 1)
              {
                paramView = "3";
                break label991;
              }
              if (localException.uinType != 3000) {
                break label991;
              }
              paramView = "4";
              break label991;
            }
          }
        }
      }
      label1418:
      label1565:
      label1591:
      if ((localAbsShareMsg.mMsgServiceID != 81) || (localAbsShareMsg == null) || (TextUtils.isEmpty(localAbsShareMsg.mMsg_A_ActionData))) {
        break;
      }
      label2065:
      Object localObject2 = bade.a(localQQAppInterface, localContext, localAbsShareMsg.mMsg_A_ActionData);
      if (localObject2 == null) {
        break;
      }
      paramView = ((bacn)localObject2).b("usertype");
      localObject2 = ((bacn)localObject2).b("unionid");
      if ((TextUtils.isEmpty(paramView)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        break;
      }
      int i = 0;
      try
      {
        int j = Integer.parseInt(paramView);
        i = j;
      }
      catch (NumberFormatException paramView)
      {
        label2207:
        break label2207;
      }
      urp.a("share_uin_obj", "clk_tail", 0, i, new String[] { localObject2 });
      return;
      label2232:
      paramView = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awuh
 * JD-Core Version:    0.7.0.1
 */