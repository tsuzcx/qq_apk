package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.VideoConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.ims.bankcode_info.BankcodeElem;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.ApprovalGrayTips;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.AuthorizeFailed;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.BatProcessFile;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.C2CChatFreqCallTip;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.C2CKeywordCallTip;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.DeviceClosegroupchat;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.DeviceDismissbind;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.DeviceOpengroupchat;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.DiscCreateCallTip;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.DiscPttFreqCallTip;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.DiscussPush;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.DiscussUpgradeToGroupTips;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.FileReceipt;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.GamePartyGrayTips;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.HandleMsgType;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.HongbaoKeywordsTips;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.HotChatToSeeTip;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.IncompatibleGrayTips;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.LocalUrl;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.MasterUinNavigation;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.MeetingNotify;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.NearbyFlowerTip;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.NearbyMarket;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.NewFriendTips;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.NewFriendTipsGameAddee;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.NewFriendTipsGameAdder;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.OperateTips;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.PAPhoneMsgTips;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.QQwalletTips;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.QlinkFileTips;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.QlinkSendFileTips;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.RecommandTips;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.RenewalTailTip;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.RevokeGrayTips;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.SensitiveMsgMaskTips;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.ShareHotChat;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.ShareLbsPush;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.ShieldMsg;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.SingleWayFriendAddAllowAllMsg;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.SingleWayFriendMsg;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.SougouInputTips;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.SpecialcareTips;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.TeamWorkFileImportSuccessTips;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.TextGroupCreated;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.TextSafe;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.TextVideo;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.TimGuide;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.TroopDeliverGift;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.UncommonlyUsedContacts;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.UncommonlyUsedContactsCancelSet;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.VipAioSendTips;
import com.tencent.mobileqq.activity.aio.item.graytipsitem.VipKeyword;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipItemBuilder;
import com.tencent.mobileqq.hotchat.api.IShareHotChatGrayTips;
import com.tencent.mobileqq.nearby.api.IFaceScoreUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vip.AioVipDonateHelper;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.mobileqq.widget.ClickLinkMovementMethod;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class GrayTipsItemBuilder
  extends AbstractChatItemBuilder
{
  private long jdField_a_of_type_Long = 0L;
  String jdField_a_of_type_JavaLangString = BaseApplication.getContext().getString(2131718647);
  private Map<Integer, HandleMsgType> jdField_a_of_type_JavaUtilMap;
  protected boolean a;
  
  public GrayTipsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Boolean = false;
    b();
  }
  
  private int a(int paramInt, bankcode_info.BankcodeCtrlInfo paramBankcodeCtrlInfo)
  {
    if (paramBankcodeCtrlInfo.msgtail_id.has()) {
      paramInt = paramBankcodeCtrlInfo.msgtail_id.get();
    }
    return paramInt;
  }
  
  private int a(int paramInt, bankcode_info.BankcodeCtrlInfo paramBankcodeCtrlInfo, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        i = Integer.parseInt(paramString);
        return i;
      }
      catch (Exception paramBankcodeCtrlInfo)
      {
        paramBankcodeCtrlInfo.printStackTrace();
        return paramInt;
      }
    }
    int i = paramInt;
    if (paramBankcodeCtrlInfo.bankcode_elems.has())
    {
      paramBankcodeCtrlInfo = paramBankcodeCtrlInfo.bankcode_elems.get().iterator();
      for (;;)
      {
        i = paramInt;
        if (!paramBankcodeCtrlInfo.hasNext()) {
          break;
        }
        paramString = (bankcode_info.BankcodeElem)paramBankcodeCtrlInfo.next();
        if (paramString.bankcode_attr.has()) {
          i = paramString.bankcode_attr.get();
        } else {
          i = 0;
        }
        if (i > paramInt) {
          paramInt = i;
        }
      }
    }
    return i;
  }
  
  private int a(JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject.has("sens_msg_sessiontype")) {
      paramInt = paramJSONObject.getInt("sens_msg_sessiontype");
    }
    return paramInt;
  }
  
  private long a(JSONObject paramJSONObject, long paramLong)
  {
    if (paramJSONObject.has("sens_msg_uniseq")) {
      paramLong = paramJSONObject.getLong("sens_msg_uniseq");
    }
    return paramLong;
  }
  
  @NotNull
  private ClickableSpan a(int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString1, int paramInt4, String paramString2, String paramString3, String paramString4, String paramString5, Bundle paramBundle, String paramString6)
  {
    return new GrayTipsItemBuilder.24(this, paramString6, paramString1, paramInt1, paramInt2, paramString4, paramBundle, paramString2, paramInt3, paramLong, paramString3, paramInt4, paramString5);
  }
  
  private CharSequence a(CharSequence paramCharSequence)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
    Pattern localPattern = Pattern.compile("<a.*?/a>");
    paramCharSequence = localPattern.matcher(localSpannableStringBuilder);
    int i = 0;
    while (paramCharSequence.find(i))
    {
      Matcher localMatcher = Pattern.compile(">.*?</a>").matcher(paramCharSequence.group());
      Object localObject2 = null;
      Object localObject1 = null;
      String str;
      while (localMatcher.find())
      {
        str = localMatcher.group().replaceAll(">|</a>", "");
        localObject1 = str;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("标题：");
          ((StringBuilder)localObject1).append(str);
          QLog.d("GrayTipsItemBuilder", 2, ((StringBuilder)localObject1).toString());
          localObject1 = str;
        }
      }
      localMatcher = Pattern.compile("href=.*?>").matcher(paramCharSequence.group());
      while (localMatcher.find())
      {
        str = localMatcher.group().replaceAll("href=|>", "");
        localObject2 = str;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("网址：");
          ((StringBuilder)localObject2).append(str);
          QLog.d("GrayTipsItemBuilder", 2, ((StringBuilder)localObject2).toString());
          localObject2 = str;
        }
      }
      if ((localObject1 != null) && (localObject2 != null))
      {
        localSpannableStringBuilder.replace(paramCharSequence.start(), paramCharSequence.end(), (CharSequence)localObject1);
        localSpannableStringBuilder.setSpan(new URLSpan((String)localObject2), paramCharSequence.start(), paramCharSequence.start() + ((String)localObject1).length(), 33);
        i = paramCharSequence.start();
        int j = ((String)localObject1).length();
        paramCharSequence = localPattern.matcher(localSpannableStringBuilder);
        paramCharSequence.reset();
        i += j;
      }
    }
    return localSpannableStringBuilder;
  }
  
  private CharSequence a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramBoolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131705419));
      ((StringBuilder)localObject).append(paramString);
      i = 2131705420;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131705430));
      ((StringBuilder)localObject).append(paramString);
      i = 2131705427;
    }
    ((StringBuilder)localObject).append(HardCodeUtil.a(i));
    Object localObject = ((StringBuilder)localObject).toString();
    if (paramBoolean) {
      i = 2131705424;
    } else {
      i = 2131705423;
    }
    int i = HardCodeUtil.a(i).length();
    int j = paramString.length();
    paramString = new SpannableString((CharSequence)localObject);
    paramString.setSpan(new GrayTipsItemBuilder.16(this), i, j + i, 33);
    return paramString;
  }
  
  private String a(int paramInt1, int paramInt2, String paramString1, long paramLong, String paramString2, String paramString3)
  {
    if (paramInt1 == 2)
    {
      if ((!TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString2))) {
        paramString2 = paramString3;
      }
      ThreadManager.post(new GrayTipsItemBuilder.25(this, paramString1, paramInt2, paramLong, paramString2), 5, null, false);
      return paramString2;
    }
    return paramString3;
  }
  
  public static String a(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString;
  }
  
  private String a(String paramString, bankcode_info.BankcodeCtrlInfo paramBankcodeCtrlInfo)
  {
    if (paramBankcodeCtrlInfo.msgtail_conf_file_md5.has()) {
      paramString = paramBankcodeCtrlInfo.msgtail_conf_file_md5.get();
    }
    return paramString;
  }
  
  private String a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has("sens_msg_default_wording")) {
      paramString = paramJSONObject.getString("sens_msg_default_wording");
    }
    return paramString;
  }
  
  private void a(int paramInt)
  {
    int i = 1;
    if (paramInt == 3000) {
      i = 2;
    } else if (paramInt == 1) {
      i = 3;
    }
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("recv_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject1).put("recv_nick", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      ((JSONObject)localObject1).put("recv_type", i);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("click HongBao:params=");
      ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
      QLog.d("PlusPanel", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("come_from", 2);
    ((Intent)localObject2).putExtra("app_info", "appid#1344242394|bargainor_id#1000030201|channel#graytips");
    ((Intent)localObject2).putExtra("extra_data", ((JSONObject)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("groupType=");
    ((StringBuilder)localObject1).append(i);
    ((Intent)localObject2).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", ((StringBuilder)localObject1).toString(), 0, null));
    RouteUtils.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, "/qwallet/redpacket/sendhb");
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, String paramString3, String paramString4, int paramInt4, String paramString5, long paramLong, Bundle paramBundle, String paramString6, SpannableString paramSpannableString)
  {
    if (paramBundle != null)
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = paramBundle.getBundle((String)localIterator.next());
        String str2 = ((Bundle)localObject).getString("Type");
        String str1 = ((Bundle)localObject).getString("Name");
        if ((paramString6.indexOf(str1) >= 0) && ((!str2.equalsIgnoreCase("makePhoneCall")) || (!TextUtils.isEmpty(paramString1))))
        {
          localObject = a(paramInt1, paramInt2, paramInt4, paramLong, paramString2, paramInt3, paramString3, paramString4, paramString1, paramString5, (Bundle)localObject, str2);
          int j = paramString6.indexOf(str1);
          int i = j;
          if (j < 0) {
            i = 0;
          }
          paramSpannableString.setSpan(localObject, i, str1.length() + i, 33);
        }
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("Action");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramBundle = (Bundle)localObject;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (!((String)localObject).startsWith("http://"))
        {
          paramBundle = new StringBuilder();
          paramBundle.append("http://");
          paramBundle.append((String)localObject);
          paramBundle = paramBundle.toString();
        }
        else
        {
          paramBundle = (Bundle)localObject;
          if (!((String)localObject).startsWith("https://"))
          {
            paramBundle = new StringBuilder();
            paramBundle.append("https://");
            paramBundle.append((String)localObject);
            paramBundle = paramBundle.toString();
          }
        }
        paramBundle.contains("?");
      }
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramBundle);
      ((Intent)localObject).putExtra("hide_left_button", true);
      ((Intent)localObject).putExtra("show_right_close_button", true);
      ((Intent)localObject).putExtra("finish_animation_up_down", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    }
  }
  
  private void a(TextView paramTextView, MessageRecord paramMessageRecord, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sens_msg_id", paramInt1);
      localJSONObject.put("sens_msg_attr", paramInt2);
      localJSONObject.put("sens_msg_status", paramString2);
      localJSONObject.put("sens_msg_phoe", paramString1);
      localJSONObject.put("sens_msg_senderuin", paramMessageRecord.senderuin);
      localJSONObject.put("sens_msg_sessiontype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      localJSONObject.put("sens_msg_peeruin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localJSONObject.put("sens_msg_nickname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      localJSONObject.put("sens_msg_troopuin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      localJSONObject.put("sens_msg_istroop", paramMessageRecord.istroop);
      localJSONObject.put("sens_msg_uniseq", paramMessageRecord.uniseq);
      a(localJSONObject.toString(), paramTextView);
      return;
    }
    catch (Exception paramTextView)
    {
      paramTextView.printStackTrace();
    }
  }
  
  private void a(TextView paramTextView, String paramString1, String paramString2, int paramInt)
  {
    if ((paramString2 != null) && (paramString2.trim().length() != 0) && (paramInt >= 0))
    {
      paramString1 = new SpannableString(paramString1);
      paramString1.setSpan(new GrayTipsItemBuilder.19(this), paramInt, paramString2.length() + paramInt, 33);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText(paramString1);
      return;
    }
    paramTextView.setText(paramString1);
  }
  
  private void a(TextView paramTextView, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (paramString1.length() < paramInt)
    {
      paramTextView.setText(new SpannableString(paramString1));
      return;
    }
    paramString1 = new StringBuilder(paramString1);
    paramString1.insert(paramInt, paramString2);
    paramString1 = new SpannableString(paramString1.toString());
    paramString1.setSpan(new GrayTipsItemBuilder.22(this, paramString3, paramString4), paramInt, paramString2.length() + paramInt, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(paramString1);
  }
  
  private void a(ChatMessage paramChatMessage, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView)
  {
    UniteGrayTipItemBuilder.a(paramChatMessage, paramViewHolder, paramView);
  }
  
  private void a(ActionSheet paramActionSheet)
  {
    paramActionSheet.setOnButtonClickListener(new GrayTipsItemBuilder.20(this, paramActionSheet));
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("isShowAd", false);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
    }
    QLog.e("GrayTipsItemBuilder", 1, "MSG_TYPE_RENEWAL_TAIL_TIP, onClick, url null");
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if ((paramInt == 1) || (paramInt == 3000)) {
      paramString1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, paramString2);
    }
    paramString2 = new Intent();
    paramString2.putExtra("come_from", 2);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("targetUin", paramString3);
      localJSONObject.put("targetNickname", paramString1);
      localJSONObject.put("sign", "");
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    paramString2.putExtra("extra_data", localJSONObject.toString());
    paramString2.putExtra("app_info", "appid#20000001|bargainor_id#1000026901|channel#graytips");
    RouteUtils.a(this.jdField_a_of_type_AndroidContentContext, paramString2, "/qwallet/transaction");
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      int i;
      if ((paramInt != 1) && (paramInt != 3000))
      {
        i = paramInt;
      }
      else
      {
        paramString1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, paramString2);
        i = 0;
      }
      if ((i == 1006) && (paramString3 != null))
      {
        paramString2 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3);
        if (paramString2 != null)
        {
          paramString4 = null;
          break label84;
        }
      }
      paramString2 = paramString3;
      label84:
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
      if (paramInt != 1006) {
        paramString3 = null;
      }
      boolean bool;
      if (paramString5.compareToIgnoreCase("QQCall") == 0) {
        bool = true;
      } else {
        bool = false;
      }
      ChatActivityUtils.a(localQQAppInterface, localActivity, i, paramString2, paramString1, paramString3, bool, paramString4, true, true, null, "from_internal");
    }
  }
  
  private void a(String paramString, TextView paramTextView)
  {
    try
    {
      paramString = new JSONObject(paramString);
      int i = d(paramString, 0);
      if (i <= 0) {
        return;
      }
      int j = c(paramString, 0);
      Object localObject1 = null;
      String str7 = b(g(paramString, null));
      String str1 = f(paramString, null);
      String str2 = e(paramString, null);
      String str3 = d(paramString, null);
      String str4 = c(paramString, null);
      int k = b(paramString, 0);
      String str5 = b(paramString, null);
      long l = a(paramString, 0L);
      int m = a(paramString, 0);
      String str6 = a(paramString, null);
      paramString = (Bundle)AntiFraudConfigFileUtil.a().a("SensMsgTipsCfg", "TailWording", i, j);
      if (paramString != null)
      {
        localObject1 = paramString.getString("0");
        paramString = paramString.getString("1");
      }
      else
      {
        paramString = null;
      }
      Bundle localBundle = (Bundle)AntiFraudConfigFileUtil.a().a("SensMsgTipsCfg", "Action", i, j);
      Object localObject2 = paramString;
      Object localObject3 = localObject1;
      Object localObject4 = localBundle;
      if (localBundle != null)
      {
        Iterator localIterator = localBundle.keySet().iterator();
        for (;;)
        {
          localObject2 = paramString;
          localObject3 = localObject1;
          localObject4 = localBundle;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = (String)localIterator.next();
          localObject3 = localBundle.getBundle((String)localObject2).getString("Name");
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("$");
          ((StringBuilder)localObject4).append((String)localObject2);
          localObject4 = ((StringBuilder)localObject4).toString();
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((String)localObject1).contains((CharSequence)localObject4)) {
              localObject2 = ((String)localObject1).replace((CharSequence)localObject4, (CharSequence)localObject3);
            }
          }
          localObject1 = paramString;
          if (paramString != null)
          {
            localObject1 = paramString;
            if (paramString.contains((CharSequence)localObject4)) {
              localObject1 = paramString.replace((CharSequence)localObject4, (CharSequence)localObject3);
            }
          }
          paramString = (String)localObject1;
          localObject1 = localObject2;
        }
      }
      if (str7.equalsIgnoreCase("0")) {
        localObject2 = localObject3;
      }
      paramString = a(i, k, str5, l, str6, (String)localObject2);
      localObject1 = new SpannableString(paramString);
      a(i, j, str1, str2, m, str3, str4, k, str5, l, (Bundle)localObject4, paramString, (SpannableString)localObject1);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)localObject1);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private boolean a(TextView paramTextView, boolean paramBoolean)
  {
    paramTextView = paramTextView.getTag(2131377252);
    if (paramTextView != null) {
      paramBoolean = ((Boolean)paramTextView).booleanValue();
    }
    return paramBoolean;
  }
  
  private boolean a(boolean paramBoolean, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramBoolean = Boolean.parseBoolean(paramString);
    }
    return paramBoolean;
  }
  
  private int b(JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject.has("sens_msg_istroop")) {
      paramInt = paramJSONObject.getInt("sens_msg_istroop");
    }
    return paramInt;
  }
  
  private String b(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    return str;
  }
  
  private String b(String paramString, bankcode_info.BankcodeCtrlInfo paramBankcodeCtrlInfo)
  {
    if (paramBankcodeCtrlInfo.msgtail_conf_file_url.has()) {
      paramString = paramBankcodeCtrlInfo.msgtail_conf_file_url.get();
    }
    return paramString;
  }
  
  private String b(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has("sens_msg_troopuin")) {
      paramString = paramJSONObject.getString("sens_msg_troopuin");
    }
    return paramString;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1002), new TextSafe());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1001), new TextVideo());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1004), new DiscussPush());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2030), new NewFriendTips());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1013), new NewFriendTips());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1018), new NewFriendTipsGameAdder());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1019), new NewFriendTipsGameAddee());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1012), new TextGroupCreated());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1047), new TextGroupCreated());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2012), new ShieldMsg());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4001), new LocalUrl());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-3008), new FileReceipt());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4005), new AuthorizeFailed());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4020), new RenewalTailTip());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2019), new SingleWayFriendMsg());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-7006), new SingleWayFriendAddAllowAllMsg());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1026), new UncommonlyUsedContacts());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1027), new UncommonlyUsedContactsCancelSet());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1014), new C2CChatFreqCallTip());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1015), new C2CKeywordCallTip());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-3009), new QlinkFileTips());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-3010), new QlinkSendFileTips());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-3013), new BatProcessFile());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-3014), new TimGuide());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1016), new DiscCreateCallTip());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2041), new ApprovalGrayTips());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1050), new DiscussUpgradeToGroupTips());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1018), new HotChatToSeeTip());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1017), new DiscPttFreqCallTip());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1041), new OperateTips());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1043), new SougouInputTips());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1045), new HongbaoKeywordsTips());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-5007), new RecommandTips());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-5000), new NearbyFlowerTip());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-5001), new NearbyFlowerTip());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2037), new NearbyFlowerTip());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4010), new ShareLbsPush());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-5002), new IncompatibleGrayTips());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2024), new MasterUinNavigation());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2042), new MasterUinNavigation());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2043), new MasterUinNavigation());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2064), new MasterUinNavigation());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-5005), new SpecialcareTips());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-5006), new MeetingNotify());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1046), new SensitiveMsgMaskTips());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2027), new NearbyMarket());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4505), new DeviceOpengroupchat());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4506), new DeviceClosegroupchat());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4507), new DeviceDismissbind());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2029), new QQwalletTips());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2031), new RevokeGrayTips());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2034), new GamePartyGrayTips());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2049), new GamePartyGrayTips());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2033), new ShareHotChat());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2035), new TroopDeliverGift());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1048), new PAPhoneMsgTips());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4021), new VipKeyword());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4022), new VipAioSendTips());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2063), new TeamWorkFileImportSuccessTips());
  }
  
  private boolean b(TextView paramTextView, boolean paramBoolean)
  {
    paramTextView = paramTextView.getTag(2131377253);
    if (paramTextView != null) {
      paramBoolean = ((Boolean)paramTextView).booleanValue();
    }
    return paramBoolean;
  }
  
  private boolean b(boolean paramBoolean, String paramString)
  {
    boolean bool = paramBoolean;
    if (!TextUtils.isEmpty(paramString))
    {
      bool = paramBoolean;
      if (paramString.equalsIgnoreCase("1")) {
        bool = true;
      }
    }
    return bool;
  }
  
  private int c(JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject.has("sens_msg_attr")) {
      paramInt = paramJSONObject.getInt("sens_msg_attr");
    }
    return paramInt;
  }
  
  private String c(String paramString, bankcode_info.BankcodeCtrlInfo paramBankcodeCtrlInfo)
  {
    if (paramBankcodeCtrlInfo.fromuin_phonenum.has()) {
      paramString = paramBankcodeCtrlInfo.fromuin_phonenum.get();
    }
    return paramString;
  }
  
  private String c(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has("sens_msg_nickname")) {
      paramString = paramJSONObject.getString("sens_msg_nickname");
    }
    return paramString;
  }
  
  private void c()
  {
    Intent localIntent;
    if (!((IFontManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IFontManagerService.class, "")).getChatFontAbility())
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatTextSizeSettingActivity.class);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    else
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("hide_left_button", false);
      localIntent.putExtra("show_right_close_button", false);
      localIntent.putExtra("individuation_url_type", 40100);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      VasWebviewUtil.b(this.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_AndroidContentContext, "font", ""), 4096L, localIntent, false, -1);
    }
    VasWebviewUtil.a("", "aio_pay", "aio_font", "", 1, 0, 0, "", "", "");
  }
  
  private int d(JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject.has("sens_msg_id")) {
      paramInt = paramJSONObject.getInt("sens_msg_id");
    }
    return paramInt;
  }
  
  private String d(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has("sens_msg_peeruin")) {
      paramString = paramJSONObject.getString("sens_msg_peeruin");
    }
    return paramString;
  }
  
  private void d()
  {
    if (!Utils.a())
    {
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_AndroidContentContext.getString(2131718574), 0).show();
    }
    else
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("individuation_url_type", 40100);
      localIntent.putExtra("vasUsePreWebview", true);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("hide_left_button", false);
      localIntent.putExtra("show_right_close_button", false);
      localIntent.putExtra("url", IndividuationUrlHelper.a(this.jdField_a_of_type_AndroidContentContext, "pendant", ""));
      localIntent.putExtra("business", 512L);
      VasWebviewUtil.a(512L, localIntent);
      localIntent.putExtra("isShowAd", false);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    VasWebviewUtil.a("", "aio_pay", "aio_widget", "", 1, 0, 0, "", "", "");
  }
  
  private String e(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has("sens_msg_senderuin")) {
      paramString = paramJSONObject.getString("sens_msg_senderuin");
    }
    return paramString;
  }
  
  private void e()
  {
    if (!BaseApplicationImpl.IS_SUPPORT_THEME)
    {
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_AndroidContentContext.getString(2131719620), 0).show();
    }
    else if (Utils.a())
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("individuation_url_type", 40306);
      VasWebviewUtil.b(this.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_AndroidContentContext, "theme", "mvip.gongneng.android.theme.index_dynamic_tab"), 32L, localIntent, true, -1);
    }
    else
    {
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_AndroidContentContext.getString(2131718574), 0).show();
    }
    VasWebviewUtil.a("", "aio_pay", "aio_theme", "", 1, 0, 0, "", "", "");
  }
  
  private void e(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString);
  }
  
  private void e(MessageRecord paramMessageRecord, GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    if (paramString != null)
    {
      boolean bool1 = paramString.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131695709));
      boolean bool2 = paramString.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131720238));
      boolean bool3 = QLog.isColorLevel();
      int i = 2;
      if (bool3)
      {
        paramString = new StringBuilder();
        paramString.append("MessageRecord.MSG_TYPE_TEXT_VIDEO isEqualNotAccept:=");
        paramString.append(bool1);
        paramString.append(",isEqualNetWorkBroken:=");
        paramString.append(bool2);
        QLog.d("GrayTipsItemBuilder", 2, paramString.toString());
      }
      if ((bool1) || (bool2))
      {
        if (bool1) {
          i = 1;
        }
        paramString = new SpannableStringBuilder(paramHolder.b.getText().toString());
        ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-12541697);
        int j;
        if (bool1) {
          j = 8;
        } else {
          j = 9;
        }
        int k;
        if (bool1) {
          k = 14;
        } else {
          k = 15;
        }
        paramString.setSpan(localForegroundColorSpan, j, k, 33);
        paramHolder.b.setText(paramString);
        paramMessageRecord = new GrayTipsItemBuilder.14(this, paramMessageRecord, i);
        paramHolder.b.setClickable(true);
        paramHolder.b.setOnClickListener(paramMessageRecord);
      }
    }
  }
  
  private String f(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has("sens_msg_phoe")) {
      paramString = paramJSONObject.getString("sens_msg_phoe");
    }
    return paramString;
  }
  
  private void f()
  {
    EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 10, false, "");
    VasWebviewUtil.a("", "aio_pay", "aio_emoji", "", 1, 0, 0, "", "", "");
  }
  
  private void f(MessageRecord paramMessageRecord, GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131695840))))
    {
      paramString = SharedPreUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      if (!paramString.getBoolean(VideoConstants.l, false))
      {
        Object localObject = new SpannableStringBuilder(paramHolder.b.getText().toString());
        ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(-12541697), 0, 8, 33);
        paramHolder.b.setText((CharSequence)localObject);
        localObject = new GrayTipsItemBuilder.15(this, paramMessageRecord.uniseq);
        paramHolder.b.setClickable(true);
        paramHolder.b.setOnClickListener((View.OnClickListener)localObject);
        paramString.edit().putLong("qav_score_msg_uniseq", paramMessageRecord.uniseq).commit();
      }
    }
  }
  
  private String g(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has("sens_msg_status")) {
      paramString = paramJSONObject.getString("sens_msg_status");
    }
    return paramString;
  }
  
  private void g()
  {
    VasWebviewUtil.a(this.jdField_a_of_type_AndroidContentContext);
    VasWebviewUtil.a("", "aio_pay", "aio_personality", "", 1, 0, 0, "", "", "");
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    GrayTipsItemBuilder.Holder localHolder = (GrayTipsItemBuilder.Holder)paramViewHolder;
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558861, null);
      localHolder.b = ((TextView)paramView.findViewById(2131367798));
      localObject = localHolder.b.getLayoutParams();
      localView = paramView;
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        localView = paramView;
        if (((ViewGroup.MarginLayoutParams)localObject).rightMargin != BaseChatItemLayout.y)
        {
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = BaseChatItemLayout.y;
          localView = paramView;
        }
      }
    }
    localHolder.b.setMovementMethod(null);
    localHolder.b.setTextColor(localView.getResources().getColorStateList(2131167362));
    String str = paramMessageRecord.msg;
    Object localObject = (HandleMsgType)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramMessageRecord.msgtype));
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = new AuthorizeFailed();
    }
    paramView.a(this, paramMessageRecord, localHolder, paramOnLongClickAndTouchListener, str, paramLinearLayout, this.jdField_a_of_type_AndroidContentContext);
    if ((paramMessageRecord instanceof MessageForGrayTips))
    {
      int i = ((MessageForGrayTips)paramMessageRecord).getTextGravity();
      localHolder.b.setGravity(i);
    }
    else
    {
      localHolder.b.setGravity(19);
    }
    a((ChatMessage)paramMessageRecord, paramViewHolder, localView);
    localHolder.b.setOnTouchListener(paramOnLongClickAndTouchListener);
    localHolder.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
    localHolder.b.setMovementMethod(ClickLinkMovementMethod.a());
    return localView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new GrayTipsItemBuilder.Holder(this);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    if (paramInt == 890)
    {
      if (paramChatMessage != null)
      {
        if (!(paramChatMessage instanceof MessageForQQWalletTips)) {
          return;
        }
        paramView = paramView.getTag();
        if ((paramView != null) && ((paramView instanceof GrayTipsItemBuilder.Holder)))
        {
          paramView = (GrayTipsItemBuilder.Holder)paramView;
          paramChatMessage = (MessageForQQWalletTips)paramChatMessage;
          if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_AndroidContentContext != null) && (paramView.b != null)) {
            paramChatMessage.buildQQWalletTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView.b);
          }
        }
      }
      return;
    }
    super.a(paramView, paramChatMessage, paramInt);
  }
  
  public void a(TextView paramTextView)
  {
    paramTextView.setText(BaseApplicationImpl.getContext().getString(2131719161));
    paramTextView.setContentDescription(BaseApplicationImpl.getContext().getString(2131719161));
  }
  
  /* Error */
  public void a(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 1112	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   4: sipush -1046
    //   7: if_icmpeq +4 -> 11
    //   10: return
    //   11: ldc2_w 1164
    //   14: lstore 5
    //   16: aload_2
    //   17: ldc 122
    //   19: invokevirtual 1168	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   22: invokestatic 1173	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   25: lstore 7
    //   27: lload 7
    //   29: lstore 5
    //   31: goto +10 -> 41
    //   34: astore 12
    //   36: aload 12
    //   38: invokevirtual 71	java/lang/Exception:printStackTrace	()V
    //   41: aload_0
    //   42: getfield 582	com/tencent/mobileqq/activity/aio/item/GrayTipsItemBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: invokevirtual 1177	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   48: aload_2
    //   49: getfield 1180	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   52: aload_2
    //   53: getfield 491	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   56: lload 5
    //   58: invokevirtual 1185	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   61: astore 16
    //   63: aload 16
    //   65: ifnonnull +4 -> 69
    //   68: return
    //   69: aload 16
    //   71: ldc_w 1187
    //   74: invokevirtual 1168	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore_2
    //   78: iconst_0
    //   79: istore 10
    //   81: aload_0
    //   82: iconst_0
    //   83: aload_2
    //   84: invokespecial 1189	com/tencent/mobileqq/activity/aio/item/GrayTipsItemBuilder:b	(ZLjava/lang/String;)Z
    //   87: istore 9
    //   89: iconst_m1
    //   90: istore_3
    //   91: aload 16
    //   93: ldc_w 1191
    //   96: invokevirtual 1168	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   99: astore_2
    //   100: aload_2
    //   101: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   104: ifeq +4 -> 108
    //   107: return
    //   108: iload_3
    //   109: istore 4
    //   111: new 39	com/tencent/ims/bankcode_info$BankcodeCtrlInfo
    //   114: dup
    //   115: invokespecial 1192	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:<init>	()V
    //   118: astore 12
    //   120: iload_3
    //   121: istore 4
    //   123: aload 12
    //   125: aload_2
    //   126: invokestatic 1198	com/tencent/mobileqq/utils/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   129: invokevirtual 1202	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   132: pop
    //   133: iload_3
    //   134: istore 4
    //   136: aload_0
    //   137: iconst_m1
    //   138: aload 12
    //   140: invokespecial 1204	com/tencent/mobileqq/activity/aio/item/GrayTipsItemBuilder:a	(ILcom/tencent/ims/bankcode_info$BankcodeCtrlInfo;)I
    //   143: istore_3
    //   144: iload_3
    //   145: istore 4
    //   147: aload_0
    //   148: aconst_null
    //   149: aload 12
    //   151: invokespecial 1206	com/tencent/mobileqq/activity/aio/item/GrayTipsItemBuilder:c	(Ljava/lang/String;Lcom/tencent/ims/bankcode_info$BankcodeCtrlInfo;)Ljava/lang/String;
    //   154: astore_2
    //   155: aload_0
    //   156: aconst_null
    //   157: aload 12
    //   159: invokespecial 1208	com/tencent/mobileqq/activity/aio/item/GrayTipsItemBuilder:b	(Ljava/lang/String;Lcom/tencent/ims/bankcode_info$BankcodeCtrlInfo;)Ljava/lang/String;
    //   162: astore 13
    //   164: aload_0
    //   165: aconst_null
    //   166: aload 12
    //   168: invokespecial 1210	com/tencent/mobileqq/activity/aio/item/GrayTipsItemBuilder:a	(Ljava/lang/String;Lcom/tencent/ims/bankcode_info$BankcodeCtrlInfo;)Ljava/lang/String;
    //   171: astore 15
    //   173: aload_0
    //   174: iconst_0
    //   175: aload 12
    //   177: aload 16
    //   179: ldc_w 464
    //   182: invokevirtual 1168	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   185: invokespecial 1212	com/tencent/mobileqq/activity/aio/item/GrayTipsItemBuilder:a	(ILcom/tencent/ims/bankcode_info$BankcodeCtrlInfo;Ljava/lang/String;)I
    //   188: istore 4
    //   190: aload 15
    //   192: astore 14
    //   194: goto +63 -> 257
    //   197: astore 14
    //   199: aload_2
    //   200: astore 12
    //   202: aload 15
    //   204: astore_2
    //   205: goto +38 -> 243
    //   208: astore 14
    //   210: aconst_null
    //   211: astore 15
    //   213: aload_2
    //   214: astore 12
    //   216: aload 15
    //   218: astore_2
    //   219: goto +24 -> 243
    //   222: astore 14
    //   224: aload_2
    //   225: astore 12
    //   227: goto +11 -> 238
    //   230: astore 14
    //   232: aconst_null
    //   233: astore 12
    //   235: iload 4
    //   237: istore_3
    //   238: aconst_null
    //   239: astore 13
    //   241: aconst_null
    //   242: astore_2
    //   243: aload 14
    //   245: invokevirtual 71	java/lang/Exception:printStackTrace	()V
    //   248: iconst_0
    //   249: istore 4
    //   251: aload_2
    //   252: astore 14
    //   254: aload 12
    //   256: astore_2
    //   257: iload 4
    //   259: bipush 20
    //   261: if_icmpne +36 -> 297
    //   264: aload_0
    //   265: iconst_1
    //   266: aload 16
    //   268: ldc_w 1214
    //   271: invokevirtual 1168	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   274: invokespecial 1216	com/tencent/mobileqq/activity/aio/item/GrayTipsItemBuilder:a	(ZLjava/lang/String;)Z
    //   277: istore 11
    //   279: iload 9
    //   281: ifne +8 -> 289
    //   284: iload 11
    //   286: ifne +11 -> 297
    //   289: ldc_w 659
    //   292: astore 12
    //   294: goto +8 -> 302
    //   297: ldc_w 657
    //   300: astore 12
    //   302: aload_0
    //   303: aload_1
    //   304: iconst_0
    //   305: invokespecial 1218	com/tencent/mobileqq/activity/aio/item/GrayTipsItemBuilder:b	(Landroid/widget/TextView;Z)Z
    //   308: istore 9
    //   310: aload_0
    //   311: aload_1
    //   312: iconst_0
    //   313: invokespecial 1220	com/tencent/mobileqq/activity/aio/item/GrayTipsItemBuilder:a	(Landroid/widget/TextView;Z)Z
    //   316: istore 11
    //   318: iload 11
    //   320: istore 10
    //   322: goto +18 -> 340
    //   325: astore 15
    //   327: goto +8 -> 335
    //   330: astore 15
    //   332: iconst_0
    //   333: istore 9
    //   335: aload 15
    //   337: invokevirtual 71	java/lang/Exception:printStackTrace	()V
    //   340: iload 9
    //   342: ifne +75 -> 417
    //   345: aload 12
    //   347: ldc_w 657
    //   350: invokevirtual 420	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   353: ifeq +64 -> 417
    //   356: aload_0
    //   357: getfield 582	com/tencent/mobileqq/activity/aio/item/GrayTipsItemBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   360: ldc_w 1222
    //   363: ldc_w 1224
    //   366: aload 16
    //   368: getfield 475	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   371: ldc_w 1226
    //   374: ldc_w 1228
    //   377: iload_3
    //   378: iload 4
    //   380: aload 16
    //   382: getfield 1231	com/tencent/mobileqq/data/MessageRecord:msgUid	J
    //   385: invokestatic 1234	java/lang/Long:toString	(J)Ljava/lang/String;
    //   388: aload 16
    //   390: getfield 494	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   393: invokestatic 1234	java/lang/Long:toString	(J)Ljava/lang/String;
    //   396: ldc 170
    //   398: ldc 170
    //   400: invokestatic 1239	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   403: aload_1
    //   404: ldc_w 856
    //   407: iconst_1
    //   408: invokestatic 1242	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   411: invokevirtual 1246	android/widget/TextView:setTag	(ILjava/lang/Object;)V
    //   414: goto +3 -> 417
    //   417: iload 10
    //   419: ifne +72 -> 491
    //   422: aload 12
    //   424: ldc_w 659
    //   427: invokevirtual 420	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   430: ifeq +61 -> 491
    //   433: aload_0
    //   434: getfield 582	com/tencent/mobileqq/activity/aio/item/GrayTipsItemBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   437: ldc_w 1222
    //   440: ldc_w 1224
    //   443: aload 16
    //   445: getfield 475	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   448: ldc_w 1226
    //   451: ldc_w 1248
    //   454: iload_3
    //   455: iload 4
    //   457: aload 16
    //   459: getfield 1231	com/tencent/mobileqq/data/MessageRecord:msgUid	J
    //   462: invokestatic 1234	java/lang/Long:toString	(J)Ljava/lang/String;
    //   465: aload 16
    //   467: getfield 494	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   470: invokestatic 1234	java/lang/Long:toString	(J)Ljava/lang/String;
    //   473: ldc 170
    //   475: ldc 170
    //   477: invokestatic 1239	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   480: aload_1
    //   481: ldc_w 670
    //   484: iconst_1
    //   485: invokestatic 1242	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   488: invokevirtual 1246	android/widget/TextView:setTag	(ILjava/lang/Object;)V
    //   491: invokestatic 648	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:a	()Lcom/tencent/mobileqq/utils/AntiFraudConfigFileUtil;
    //   494: aconst_null
    //   495: ldc_w 650
    //   498: aload 13
    //   500: aload 14
    //   502: invokevirtual 1251	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   505: aload_0
    //   506: aload_1
    //   507: aload 16
    //   509: iload_3
    //   510: iload 4
    //   512: aload_2
    //   513: aload 12
    //   515: invokespecial 1253	com/tencent/mobileqq/activity/aio/item/GrayTipsItemBuilder:a	(Landroid/widget/TextView;Lcom/tencent/mobileqq/data/MessageRecord;IILjava/lang/String;Ljava/lang/String;)V
    //   518: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	519	0	this	GrayTipsItemBuilder
    //   0	519	1	paramTextView	TextView
    //   0	519	2	paramMessageRecord	MessageRecord
    //   90	420	3	i	int
    //   109	402	4	j	int
    //   14	43	5	l1	long
    //   25	3	7	l2	long
    //   87	254	9	bool1	boolean
    //   79	339	10	k	int
    //   277	42	11	bool2	boolean
    //   34	3	12	localException1	Exception
    //   118	396	12	localObject	Object
    //   162	337	13	str1	String
    //   192	1	14	str2	String
    //   197	1	14	localException2	Exception
    //   208	1	14	localException3	Exception
    //   222	1	14	localException4	Exception
    //   230	14	14	localException5	Exception
    //   252	249	14	localMessageRecord1	MessageRecord
    //   171	46	15	str3	String
    //   325	1	15	localException6	Exception
    //   330	6	15	localException7	Exception
    //   61	447	16	localMessageRecord2	MessageRecord
    // Exception table:
    //   from	to	target	type
    //   16	27	34	java/lang/Exception
    //   173	190	197	java/lang/Exception
    //   164	173	208	java/lang/Exception
    //   155	164	222	java/lang/Exception
    //   111	120	230	java/lang/Exception
    //   123	133	230	java/lang/Exception
    //   136	144	230	java/lang/Exception
    //   147	155	230	java/lang/Exception
    //   310	318	325	java/lang/Exception
    //   302	310	330	java/lang/Exception
  }
  
  public void a(TextView paramTextView, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      Object localObject = paramString.split("\\$");
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("splitResult is:");
        paramString.append(Arrays.toString((Object[])localObject));
        QLog.d("VoiceTipMsg", 2, paramString.toString());
      }
      int i = localObject.length;
      String str3 = "";
      String str2;
      if (i >= 1)
      {
        if (localObject[0].startsWith("ver=")) {
          str2 = localObject[0].split("\\=")[1];
        } else {
          str2 = "1";
        }
      }
      else {
        str2 = "";
      }
      boolean bool = str2.equals("1");
      String str1 = null;
      if (bool)
      {
        paramString = localObject[0];
        str1 = paramTextView.getResources().getString(2131719732);
      }
      else if (str2.equals("2"))
      {
        if (localObject.length >= 3)
        {
          paramString = localObject[1];
          str1 = localObject[2];
        }
        else
        {
          paramString = localObject[1];
        }
      }
      else
      {
        paramString = null;
      }
      localObject = paramString;
      if (paramString == null) {
        localObject = "";
      }
      if (str1 == null) {
        str1 = str3;
      }
      int j = ((String)localObject).indexOf(str1);
      i = j;
      if (str2.equals("1"))
      {
        i = j;
        if (j < 0) {
          i = ((String)localObject).indexOf(paramTextView.getResources().getString(2131719732));
        }
      }
      a(paramTextView, (String)localObject, str1, i);
    }
  }
  
  public void a(OnLongClickAndTouchListener paramOnLongClickAndTouchListener, GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    b(paramHolder, paramString);
    paramHolder.b.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramHolder.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
  }
  
  public void a(GrayTipsItemBuilder.Holder paramHolder)
  {
    SpannableString localSpannableString = FileManagerUtil.a(BaseApplicationImpl.getContext().getString(2131698382), BaseApplicationImpl.getContext().getString(2131698381), new GrayTipsItemBuilder.10(this));
    paramHolder.b.setText(localSpannableString);
    paramHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramHolder.b.setHighlightColor(17170445);
  }
  
  public void a(GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    paramString = paramString.split("\\|");
    if (paramString.length != 5) {
      return;
    }
    a(paramHolder.b, paramString[0], paramString[1], Integer.parseInt(paramString[2]), paramString[3], paramString[4]);
  }
  
  public void a(MessageForGrayTips paramMessageForGrayTips, GrayTipsItemBuilder.Holder paramHolder)
  {
    paramMessageForGrayTips = paramMessageForGrayTips.getExtInfoFromExtStr("approval_subtype");
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131690112);
    SpannableString localSpannableString = new SpannableString(str);
    localSpannableString.setSpan(new GrayTipsItemBuilder.6(this, paramMessageForGrayTips), 0, str.length(), 33);
    paramHolder.b.setHighlightColor(17170445);
    paramHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramHolder.b.setText(localSpannableString);
  }
  
  public void a(MessageForSafeGrayTips paramMessageForSafeGrayTips, TextView paramTextView)
  {
    AntiFraudConfigFileUtil.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SensMsgTipsCfg");
    if (paramMessageForSafeGrayTips != null)
    {
      if (paramMessageForSafeGrayTips.safeInfo == null) {
        return;
      }
      int j = 0;
      String str1;
      if (paramMessageForSafeGrayTips.safeInfo.strFromMobile.has()) {
        str1 = paramMessageForSafeGrayTips.safeInfo.strFromMobile.get();
      } else {
        str1 = null;
      }
      String str2;
      if (paramMessageForSafeGrayTips.safeInfo.strFromName.has()) {
        str2 = paramMessageForSafeGrayTips.safeInfo.strFromName.get();
      } else {
        str2 = null;
      }
      int i = j;
      if (paramMessageForSafeGrayTips.safeInfo.strMsgTxt.has()) {
        try
        {
          i = Integer.parseInt(paramMessageForSafeGrayTips.safeInfo.strMsgTxt.get());
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          i = j;
        }
      }
      AntiFraudConfigFileUtil.a().a(null, "SensMsgTipsCfg", null, null);
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("sens_msg_id", 2);
        localJSONObject.put("sens_msg_attr", i);
        localJSONObject.put("sens_msg_status", "0");
        localJSONObject.put("sens_msg_phoe", str1);
        localJSONObject.put("sens_msg_fromname", str2);
        localJSONObject.put("sens_msg_senderuin", paramMessageForSafeGrayTips.senderuin);
        localJSONObject.put("sens_msg_sessiontype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        localJSONObject.put("sens_msg_peeruin", paramMessageForSafeGrayTips.senderuin);
        localJSONObject.put("sens_msg_nickname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        localJSONObject.put("sens_msg_troopuin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localJSONObject.put("sens_msg_istroop", paramMessageForSafeGrayTips.istroop);
        localJSONObject.put("sens_msg_uniseq", paramMessageForSafeGrayTips.uniseq);
        localJSONObject.put("sens_msg_default_wording", this.jdField_a_of_type_JavaLangString);
        a(localJSONObject.toString(), paramTextView);
        return;
      }
      catch (Exception paramMessageForSafeGrayTips)
      {
        paramMessageForSafeGrayTips.printStackTrace();
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    if (paramMessageRecord.istroop == 0)
    {
      e(paramHolder.b, paramString);
      return;
    }
    b(paramMessageRecord, paramLinearLayout, paramOnLongClickAndTouchListener, paramHolder, paramString);
  }
  
  public void a(MessageRecord paramMessageRecord, LinearLayout paramLinearLayout, GrayTipsItemBuilder.Holder paramHolder)
  {
    if ((paramMessageRecord instanceof MessageForNearbyMarketGrayTips))
    {
      paramLinearLayout = ((MessageForNearbyMarketGrayTips)paramMessageRecord).getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext());
      paramHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
      paramHolder.b.setText(paramLinearLayout);
      paramLinearLayout = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
      paramHolder = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
      if (paramLinearLayout.getFaceScoreFlag(paramMessageRecord, "isFaceScoreGrayTips"))
      {
        paramLinearLayout = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
        paramHolder = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
        boolean bool = paramLinearLayout.getFaceScoreFlag(paramMessageRecord, "isFaceScoreSecondMember");
        paramHolder = "2";
        if (bool) {
          paramLinearLayout = "2";
        } else {
          paramLinearLayout = "1";
        }
        IFaceScoreUtils localIFaceScoreUtils1 = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
        IFaceScoreUtils localIFaceScoreUtils2 = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
        if (!localIFaceScoreUtils1.getFaceScoreFlag(paramMessageRecord, "isFaceScoreSpecialLike")) {
          paramHolder = "1";
        }
        ((IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class)).report("exp_grey", paramMessageRecord.frienduin, new String[] { paramLinearLayout, "", "", paramHolder });
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("GrayTipsItemBuilder", 2, "nearby market gray tips msg is not validate");
    }
  }
  
  public void a(MessageRecord paramMessageRecord, LinearLayout paramLinearLayout, GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    if ((paramMessageRecord instanceof MessageForGrayTips))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "getItemView MSG_TYPE_CONFIGURABLE_GRAY_TIPS");
      }
      paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
    }
    else
    {
      paramMessageRecord = null;
    }
    if (paramMessageRecord != null)
    {
      paramHolder.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), false, paramHolder.b));
      paramHolder.b.setClickable(true);
      paramHolder.b.setFocusable(true);
      paramHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
      return;
    }
    b(paramHolder, paramString);
  }
  
  public void a(MessageRecord paramMessageRecord, TextView paramTextView)
  {
    try
    {
      paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, false, paramTextView));
      paramTextView.setGravity(3);
      return;
    }
    catch (Exception paramMessageRecord) {}
  }
  
  public void a(MessageRecord paramMessageRecord, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    String[] arrayOfString;
    if ((paramString != null) && (paramString.length() > 0) && (paramString.charAt(0) == '\026')) {
      arrayOfString = paramString.split("\\|");
    } else {
      arrayOfString = null;
    }
    String str = paramString;
    if (arrayOfString != null)
    {
      str = paramString;
      if (arrayOfString.length > 0) {
        str = arrayOfString[0].trim();
      }
    }
    a(paramOnLongClickAndTouchListener, paramHolder, str);
    f(paramMessageRecord, paramHolder, str);
    e(paramMessageRecord, paramHolder, str);
  }
  
  public void a(MessageRecord paramMessageRecord, GrayTipsItemBuilder.Holder paramHolder)
  {
    if (!(paramMessageRecord instanceof MessageForQQWalletTips)) {
      return;
    }
    ((MessageForQQWalletTips)paramMessageRecord).buildQQWalletTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.b);
  }
  
  public void a(MessageRecord paramMessageRecord, GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getItemView msgtype:-5000 istroop:");
      localStringBuilder.append(paramMessageRecord.istroop);
      localStringBuilder.append(" msg:");
      localStringBuilder.append(MessageRecordUtil.a(paramString));
      QLog.d("GrayTipsItemBuilder", 2, localStringBuilder.toString());
    }
    if ((paramMessageRecord instanceof MessageForNewGrayTips))
    {
      paramMessageRecord = (MessageForNewGrayTips)paramMessageRecord;
      if ((paramMessageRecord != null) && (paramMessageRecord.msg.length() > 0)) {
        paramMessageRecord.buildTextView(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramHolder.b);
      }
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenu().a();
  }
  
  public void b(TextView paramTextView)
  {
    SpannableString localSpannableString = FileManagerUtil.a(BaseApplicationImpl.getContext().getString(2131719159), BaseApplicationImpl.getContext().getString(2131719160), new GrayTipsItemBuilder.17(this));
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
    paramTextView.setContentDescription(localSpannableString);
    if (QLog.isColorLevel())
    {
      paramTextView = new StringBuilder();
      paramTextView.append("handleSingleWayFriendAddAllowTipsItem hasReportAddAllowShow：");
      paramTextView.append(this.jdField_a_of_type_Boolean);
      paramTextView.append("  this:");
      paramTextView.append(this);
      QLog.d("GrayTipsItemBuilder", 2, paramTextView.toString());
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X800994B", "0X800994B", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void b(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if (TextUtils.isEmpty(paramMessageRecord.extStr)) {
      return;
    }
    paramMessageRecord = paramMessageRecord.extStr.split(":");
    if (paramMessageRecord.length < 2) {
      return;
    }
    paramMessageRecord = String.format("你当前所在WiFi：%s，%s人正在热聊，", new Object[] { paramMessageRecord[0], paramMessageRecord[1] });
    String str = HardCodeUtil.a(2131705429);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramMessageRecord);
    ((StringBuilder)localObject).append(str);
    localObject = new SpannableString(((StringBuilder)localObject).toString());
    GrayTipsItemBuilder.HotChatToSeeTipClickableSpan localHotChatToSeeTipClickableSpan = new GrayTipsItemBuilder.HotChatToSeeTipClickableSpan(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
    int i = paramMessageRecord.length();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageRecord);
    localStringBuilder.append(str);
    ((SpannableString)localObject).setSpan(localHotChatToSeeTipClickableSpan, i, localStringBuilder.toString().length(), 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  public void b(TextView paramTextView, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = HardCodeUtil.a(2131705421);
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131705418));
      paramString = ((StringBuilder)localObject1).toString();
    }
    Object localObject1 = HardCodeUtil.a(2131705409);
    Object localObject2 = HardCodeUtil.a(2131705408);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append((String)localObject2);
    localObject2 = new SpannableString(((StringBuilder)localObject3).toString());
    localObject3 = new GrayTipsItemBuilder.23(this);
    int i = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append((String)localObject1);
    ((SpannableString)localObject2).setSpan(localObject3, i, localStringBuilder.toString().length(), 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject2);
  }
  
  public void b(OnLongClickAndTouchListener paramOnLongClickAndTouchListener, GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    paramHolder.b.setText(a(paramString));
    paramHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramHolder.b.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramHolder.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
  }
  
  public void b(GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    paramHolder.b.setText(paramString);
  }
  
  public void b(MessageRecord paramMessageRecord, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    if ((paramMessageRecord instanceof MessageForGrayTips))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
      }
      paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
    }
    else
    {
      paramMessageRecord = null;
    }
    if (paramMessageRecord != null)
    {
      paramHolder.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), false, paramHolder.b));
      paramHolder.b.setClickable(true);
      paramHolder.b.setFocusable(true);
      paramHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
      return;
    }
    a(paramOnLongClickAndTouchListener, paramHolder, paramString);
  }
  
  public void b(MessageRecord paramMessageRecord, LinearLayout paramLinearLayout, GrayTipsItemBuilder.Holder paramHolder)
  {
    if ((paramMessageRecord instanceof IShareHotChatGrayTips))
    {
      paramMessageRecord = ((IShareHotChatGrayTips)paramMessageRecord).getHighlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext());
      paramHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
      paramHolder.b.setText(paramMessageRecord);
    }
  }
  
  public void b(MessageRecord paramMessageRecord, GrayTipsItemBuilder.Holder paramHolder)
  {
    if ((paramMessageRecord instanceof MessageForGrayTips))
    {
      paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
      if ((paramMessageRecord != null) && (paramMessageRecord.msg.length() > 0))
      {
        String str = HardCodeUtil.a(2131705417);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMessageRecord.msg);
        localStringBuilder.append(str);
        localStringBuilder.append(HardCodeUtil.a(2131705407));
        paramMessageRecord = FileManagerUtil.a(localStringBuilder.toString(), str, new GrayTipsItemBuilder.1(this));
        paramHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
        paramHolder.b.setText(paramMessageRecord);
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord, GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    int i = paramMessageRecord.extraflag;
    int j = paramString.indexOf(paramMessageRecord.extStr);
    paramString = new SpannableString(paramString);
    paramString.setSpan(new GrayTipsItemBuilder.5(this, i), j, paramMessageRecord.extStr.length() + j, 33);
    paramHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramHolder.b.setText(paramString);
  }
  
  public void c(TextView paramTextView)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131698598);
    String str = paramTextView.getResources().getString(2131719732);
    int i = ((String)localObject).indexOf(str);
    if (i < 0)
    {
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new GrayTipsItemBuilder.18(this), i, str.length() + i, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  public void c(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramMessageRecord.msg)))
    {
      if (paramTextView == null) {
        return;
      }
      int j = paramMessageRecord.msg.indexOf(HardCodeUtil.a(2131705426));
      int i = j;
      if (j < 0) {
        i = paramMessageRecord.msg.indexOf(HardCodeUtil.a(2131705410));
      }
      if (i < 0) {
        return;
      }
      SpannableString localSpannableString = new SpannableString(new SpannableString(paramMessageRecord.msg));
      localSpannableString.setSpan(new GrayTipsItemBuilder.TeamWorkFileImportTipsClickableSpan(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageRecord), i, i + 4, 33);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText(localSpannableString);
    }
  }
  
  public void c(TextView paramTextView, String paramString)
  {
    int j = paramString.indexOf(HardCodeUtil.a(2131705413)) - 1;
    int k = paramString.indexOf(HardCodeUtil.a(2131705428)) + 1;
    int i = j;
    if (j < 0) {
      i = 10;
    }
    paramString = new SpannableString(paramString);
    paramString.setSpan(new GrayTipsItemBuilder.RecommandInputClickableSpan(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), i, k, 33);
    paramString.setSpan(new ForegroundColorSpan(-12541697), i, k, 17);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(paramString);
  }
  
  public void c(OnLongClickAndTouchListener paramOnLongClickAndTouchListener, GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    a(paramOnLongClickAndTouchListener, paramHolder, String.format(paramString, new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d }));
  }
  
  public void c(GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    SpannableString localSpannableString = FileManagerUtil.a(paramString, this.jdField_a_of_type_AndroidContentContext.getString(2131692596), new GrayTipsItemBuilder.7(this));
    paramHolder.b.setText(localSpannableString);
    paramString = paramString.replace("TIM", "t i m");
    paramHolder.b.setContentDescription(paramString);
    paramHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramHolder.b.setHighlightColor(17170445);
  }
  
  public void c(MessageRecord paramMessageRecord, LinearLayout paramLinearLayout, GrayTipsItemBuilder.Holder paramHolder)
  {
    if ((paramMessageRecord instanceof MessageForGrayTips))
    {
      paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
      paramHolder.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), false, paramHolder.b));
      paramHolder.b.setClickable(true);
      paramHolder.b.setFocusable(true);
      paramHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
    }
  }
  
  public void c(MessageRecord paramMessageRecord, GrayTipsItemBuilder.Holder paramHolder)
  {
    if ((paramMessageRecord instanceof MessageForGrayTips))
    {
      paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
      if ((paramMessageRecord != null) && (paramMessageRecord.msg.length() > 0))
      {
        String str = HardCodeUtil.a(2131705414);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMessageRecord.msg);
        localStringBuilder.append(str);
        paramMessageRecord = FileManagerUtil.a(localStringBuilder.toString(), str, new GrayTipsItemBuilder.2(this));
        paramHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
        paramHolder.b.setText(paramMessageRecord);
      }
    }
  }
  
  public void c(MessageRecord paramMessageRecord, GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    paramMessageRecord = FileManagerUtil.a(paramString, this.jdField_a_of_type_AndroidContentContext.getString(2131690790), new GrayTipsItemBuilder.8(this, paramMessageRecord.getExtInfoFromExtStr("bat_process_tips_last_file_type")));
    paramHolder.b.setText(paramMessageRecord);
    paramHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramHolder.b.setHighlightColor(17170445);
  }
  
  public void d(TextView paramTextView)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131691768);
    int i = ((String)localObject).indexOf(paramTextView.getResources().getString(2131719732));
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new GrayTipsItemBuilder.21(this), i, i + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  public void d(TextView paramTextView, String paramString)
  {
    paramTextView.setClickable(true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append("");
    localStringBuilder.append(paramString);
    paramTextView.setText(localStringBuilder.toString());
  }
  
  public void d(OnLongClickAndTouchListener paramOnLongClickAndTouchListener, GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    paramHolder.b.setText(a(paramString, false));
    paramHolder.b.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramHolder.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
  }
  
  public void d(GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131698427);
    String str1 = str2;
    if (!paramString.contains(str2)) {
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131698390);
    }
    paramString = FileManagerUtil.a(paramString, str1, new GrayTipsItemBuilder.9(this));
    paramHolder.b.setText(paramString);
    paramHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramHolder.b.setHighlightColor(17170445);
  }
  
  public void d(MessageRecord paramMessageRecord, GrayTipsItemBuilder.Holder paramHolder)
  {
    if ((paramMessageRecord instanceof MessageForGrayTips))
    {
      paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
      if ((paramMessageRecord != null) && (paramMessageRecord.msg.length() > 0))
      {
        String str = HardCodeUtil.a(2131705406);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMessageRecord.msg);
        localStringBuilder.append(str);
        paramMessageRecord = FileManagerUtil.a(localStringBuilder.toString(), str, new GrayTipsItemBuilder.3(this));
        paramHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
        paramHolder.b.setText(paramMessageRecord);
      }
    }
  }
  
  public void d(MessageRecord paramMessageRecord, GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    AioVipKeywordHelper localAioVipKeywordHelper = AioVipKeywordHelper.a();
    String str2 = localAioVipKeywordHelper.a(paramMessageRecord.isSend(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    String str3 = paramMessageRecord.getExtInfoFromExtStr("aio_vip_tips_open_url");
    String str4 = paramMessageRecord.getExtInfoFromExtStr("aio_vip_keyword");
    String str1 = paramMessageRecord.getExtInfoFromExtStr("aio_vip_tips_highlight");
    int i = paramString.indexOf(str1);
    str1.length();
    if (i == -1) {
      str1 = "";
    }
    paramMessageRecord = FileManagerUtil.a(paramString, str1, new GrayTipsItemBuilder.12(this, str3, str2, paramMessageRecord, str4, localAioVipKeywordHelper));
    paramHolder.b.setText(paramMessageRecord);
    if (e) {
      paramHolder.b.setContentDescription(paramMessageRecord);
    }
    paramHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramHolder.b.setHighlightColor(17170445);
  }
  
  public void e(TextView paramTextView)
  {
    Object localObject = HardCodeUtil.a(2131705425);
    int j = ((String)localObject).indexOf(HardCodeUtil.a(2131705416));
    int i = j;
    if (j < 0) {
      i = 10;
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new GrayTipsItemBuilder.SougouInputTipClickableSpan(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext), i, j + 5, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  public void e(OnLongClickAndTouchListener paramOnLongClickAndTouchListener, GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    paramHolder.b.setText(a(paramString, true));
    paramHolder.b.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramHolder.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
  }
  
  public void e(GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    String str1 = ((SharedPreferences)localObject).getString("renewal_tail_click_text", null);
    int i = ((SharedPreferences)localObject).getInt("renewal_tail_action", -1);
    int j = ((SharedPreferences)localObject).getInt("renewal_tail_tip_exit", -1);
    String str2 = ((SharedPreferences)localObject).getString("renewal_tail_activity_url", null);
    int k = ((SharedPreferences)localObject).getInt("renewal_tail_item_id", -1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MSG_TYPE_RENEWAL_TAIL_TIP, action=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", msg=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", clickText=");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(", expireFlag=");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", activityUrl=");
      ((StringBuilder)localObject).append(str2);
      QLog.d("GrayTipsItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str1)))
    {
      paramString = FileManagerUtil.a(paramString, str1, new GrayTipsItemBuilder.11(this, i, k, str2, j));
      paramHolder.b.setText(paramString);
    }
    else
    {
      QLog.e("GrayTipsItemBuilder", 1, "MSG_TYPE_RENEWAL_TAIL_TIP msg or clickText empty");
    }
    paramHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramHolder.b.setHighlightColor(17170445);
  }
  
  public void e(MessageRecord paramMessageRecord, GrayTipsItemBuilder.Holder paramHolder)
  {
    if ((paramMessageRecord instanceof MessageForIncompatibleGrayTips))
    {
      paramMessageRecord = (MessageForIncompatibleGrayTips)paramMessageRecord;
      Object localObject = paramMessageRecord.url;
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForIncompatibleGrayTips");
      }
      SpannableString localSpannableString = new SpannableString(paramMessageRecord.msg);
      localObject = new GrayTipsItemBuilder.4(this, (String)localObject);
      localSpannableString.setSpan(new ForegroundColorSpan(2131167280), paramMessageRecord.linkStart, paramMessageRecord.linkEnd, 33);
      localSpannableString.setSpan(localObject, paramMessageRecord.linkStart, paramMessageRecord.linkEnd, 33);
      paramHolder.b.setText(localSpannableString);
      paramHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
      paramHolder.b.setHighlightColor(17170445);
    }
  }
  
  public void f(TextView paramTextView)
  {
    Object localObject1 = HardCodeUtil.a(2131705415);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("为TA设置特别消息提示音,");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject2 = ((StringBuilder)localObject2).toString();
    int i = ((String)localObject1).length() + 13;
    localObject1 = new SpannableString((CharSequence)localObject2);
    ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-15036176), 13, i, 33);
    ((SpannableString)localObject1).setSpan(new GrayTipsItemBuilder.SpecialCareTipClickableSpan(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext), 0, i, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject1);
  }
  
  public void f(OnLongClickAndTouchListener paramOnLongClickAndTouchListener, GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    paramString = new QQText(paramString, 1);
    paramHolder.b.setText(paramString);
    paramHolder.b.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramHolder.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
  }
  
  public void f(GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    String str = AioVipDonateHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramString.indexOf(str);
    str.length();
    paramString = FileManagerUtil.a(paramString, str, new GrayTipsItemBuilder.13(this));
    paramHolder.b.setText(paramString);
    if (e) {
      paramHolder.b.setContentDescription(paramString);
    }
    paramHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramHolder.b.setHighlightColor(17170445);
    VasWebviewUtil.a("", "2", "", "", "", "", "", "", "", "");
  }
  
  public void f(MessageRecord paramMessageRecord, GrayTipsItemBuilder.Holder paramHolder)
  {
    paramMessageRecord = paramMessageRecord.msg;
    if (paramMessageRecord != null) {
      c(paramHolder.b, paramMessageRecord);
    }
  }
  
  public void g(TextView paramTextView)
  {
    Object localObject = BaseApplicationImpl.getContext().getString(2131720104);
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131720105);
    int j = ((String)localObject).length() + str.indexOf(HardCodeUtil.a(2131705411));
    int i = j;
    if (j < 0) {
      i = 20;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(str);
    localObject = new SpannableString(new SpannableString(localStringBuilder.toString()));
    ((SpannableString)localObject).setSpan(new GrayTipsItemBuilder.26(this), i, i + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  public void g(GrayTipsItemBuilder.Holder paramHolder, String paramString)
  {
    paramString = FileManagerUtil.c(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131692301));
    localStringBuilder.append("\"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\"");
    b(paramHolder, localStringBuilder.toString());
  }
  
  public void g(MessageRecord paramMessageRecord, GrayTipsItemBuilder.Holder paramHolder)
  {
    if (!(paramMessageRecord instanceof MessageForDeliverGiftTips)) {
      return;
    }
    ((MessageForDeliverGiftTips)paramMessageRecord).buildDeliverGiftTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.b);
  }
  
  public void h(TextView paramTextView) {}
  
  public void i(TextView paramTextView)
  {
    Object localObject = HardCodeUtil.a(2131705412);
    int j = ((String)localObject).indexOf("Q");
    int i = j;
    if (j < 0) {
      i = 11;
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new GrayTipsItemBuilder.27(this), i, j + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder
 * JD-Core Version:    0.7.0.1
 */