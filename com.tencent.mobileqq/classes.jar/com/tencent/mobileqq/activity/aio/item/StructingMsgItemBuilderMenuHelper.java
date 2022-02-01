package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.ClipboardManager;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilderMenuHelper;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.MultiFavoriteHelper;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout4;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAVideo;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class StructingMsgItemBuilderMenuHelper
{
  private StructingMsgItemBuilder a;
  
  StructingMsgItemBuilderMenuHelper(StructingMsgItemBuilder paramStructingMsgItemBuilder)
  {
    this.a = paramStructingMsgItemBuilder;
  }
  
  private AbsStructMsgElement a(AbsShareMsg paramAbsShareMsg, AbsStructMsgElement paramAbsStructMsgElement)
  {
    int i = 0;
    while (i < paramAbsShareMsg.getItemCount())
    {
      AbsStructMsgElement localAbsStructMsgElement = paramAbsShareMsg.getItemByIndex(i);
      if ((!TextUtils.isEmpty(localAbsStructMsgElement.aa)) && (Integer.valueOf(localAbsStructMsgElement.aa).intValue() == StructingMsgItemBuilder.jdField_a_of_type_Int) && (((localAbsStructMsgElement instanceof StructMsgItemLayout4)) || ((localAbsStructMsgElement instanceof StructMsgItemLayout5)))) {
        return localAbsStructMsgElement;
      }
      i += 1;
    }
    return paramAbsStructMsgElement;
  }
  
  private String a(@NonNull AbsStructMsgItem paramAbsStructMsgItem, Class paramClass)
  {
    ArrayList localArrayList = paramAbsStructMsgItem.a;
    AbsStructMsgItem localAbsStructMsgItem = null;
    int i = 0;
    while (i < localArrayList.size())
    {
      AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)localArrayList.get(i);
      paramAbsStructMsgItem = localAbsStructMsgItem;
      if (localAbsStructMsgElement != null) {
        if (!localAbsStructMsgElement.getClass().equals(paramClass))
        {
          paramAbsStructMsgItem = localAbsStructMsgItem;
        }
        else if (StructMsgItemTitle.class.equals(paramClass))
        {
          paramAbsStructMsgItem = ((StructMsgItemTitle)localAbsStructMsgElement).b();
        }
        else if (StructMsgItemSummary.class.equals(paramClass))
        {
          paramAbsStructMsgItem = ((StructMsgItemSummary)localAbsStructMsgElement).b();
        }
        else if (StructMsgItemCover.class.equals(paramClass))
        {
          paramAbsStructMsgItem = ((StructMsgItemCover)localAbsStructMsgElement).ac;
        }
        else if (StructMsgItemPAVideo.class.equals(paramClass))
        {
          paramAbsStructMsgItem = ((StructMsgItemPAVideo)localAbsStructMsgElement).ac;
        }
        else
        {
          paramAbsStructMsgItem = localAbsStructMsgItem;
          if (StructMsgItemPAAudio.class.equals(paramClass)) {
            paramAbsStructMsgItem = ((StructMsgItemPAAudio)localAbsStructMsgElement).ac;
          }
        }
      }
      i += 1;
      localAbsStructMsgItem = paramAbsStructMsgItem;
    }
    return localAbsStructMsgItem;
  }
  
  private String a(StructMsgForGeneralShare paramStructMsgForGeneralShare, String paramString)
  {
    Object localObject1 = paramString;
    if (paramStructMsgForGeneralShare.mIsPAVideoStructMsg)
    {
      int i = 0;
      for (;;)
      {
        localObject1 = paramString;
        if (i >= paramStructMsgForGeneralShare.getItemCount()) {
          break;
        }
        localObject1 = paramStructMsgForGeneralShare.getItemByIndex(i);
        if ((localObject1 instanceof StructMsgItemLayout5))
        {
          Object localObject2 = ((StructMsgItemLayout5)localObject1).a.iterator();
          do
          {
            localObject1 = paramString;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject1 = (AbsStructMsgElement)((Iterator)localObject2).next();
          } while (!(localObject1 instanceof StructMsgItemVideo));
          localObject2 = (StructMsgItemVideo)localObject1;
          paramString = ((StructMsgItemVideo)localObject2).ac;
          localObject1 = paramString;
          if (!((StructMsgItemVideo)localObject2).a()) {
            break;
          }
          ((IVideoReporter)QRoute.api(IVideoReporter.class)).reportClickEvent("0X8006601", paramStructMsgForGeneralShare.uinType, ((IVideoReporter)QRoute.api(IVideoReporter.class)).getReportVideoType(((StructMsgItemVideo)localObject2).v, paramStructMsgForGeneralShare.mSourceName), ((StructMsgItemVideo)localObject2).ae, "");
          return paramString;
        }
        i += 1;
      }
    }
    return localObject1;
  }
  
  private String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString2 != null)
    {
      str = paramString1;
      if (!"".equals(paramString2)) {
        if (paramString1 != null)
        {
          str = paramString1;
          if (!"".equals(paramString1)) {}
        }
        else
        {
          str = paramString2;
        }
      }
    }
    return str;
  }
  
  private void a(Context paramContext, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    ThreadManager.post(new StructingMsgItemBuilderMenuHelper.1(this, paramMessageForStructing, paramSessionInfo, paramActivity, paramQQAppInterface, paramContext), 8, null, false);
  }
  
  private void a(Context paramContext1, String paramString, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface, Context paramContext2)
  {
    if (a(paramContext1, paramString, paramMessageForStructing, paramQQAppInterface, paramContext2)) {
      return;
    }
    if (paramMessageForStructing.structingMsg.mMsgServiceID == 81) {
      StoryReportor.a(paramQQAppInterface, paramContext2, paramMessageForStructing, "forward");
    }
    Object localObject = new Bundle();
    if ((paramMessageForStructing.structingMsg.source_puin != null) && (!"".equals(paramMessageForStructing.structingMsg.source_puin))) {
      ((Bundle)localObject).putString("source_puin", paramMessageForStructing.structingMsg.source_puin);
    }
    ((Bundle)localObject).putInt("forward_type", -3);
    paramMessageForStructing.structingMsg.mCommentText = null;
    ((Bundle)localObject).putInt("structmsg_service_id", paramMessageForStructing.structingMsg.mMsgServiceID);
    ((Bundle)localObject).putByteArray("stuctmsg_bytes", paramMessageForStructing.structingMsg.getBytes());
    ((Bundle)localObject).putLong("structmsg_uniseq", paramMessageForStructing.uniseq);
    ((Bundle)localObject).putInt("accostType", paramMessageForStructing.structingMsg.sourceAccoutType);
    ((Bundle)localObject).putInt("selection_mode", this.a.b());
    paramContext1 = new Intent();
    paramContext1.putExtras((Bundle)localObject);
    if ((paramMessageForStructing.structingMsg instanceof StructMsgForImageShare))
    {
      localObject = (StructMsgForImageShare)paramMessageForStructing.structingMsg;
      StructMsgItemImage localStructMsgItemImage = ((StructMsgForImageShare)localObject).getFirstImageElement();
      if ((localStructMsgItemImage != null) && (localStructMsgItemImage.a()))
      {
        paramContext1.putExtra("key_forward_image_share", true);
        paramContext1.putExtra("key_forward_image_share_appid", Long.toString(((StructMsgForImageShare)localObject).mSourceAppid));
        paramContext1.putExtra("key_forward_image_share_uin_type", ((StructMsgForImageShare)localObject).uinType);
      }
    }
    else if (((paramMessageForStructing.structingMsg instanceof StructMsgForAudioShare)) || ((paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)))
    {
      paramContext1.putExtra("key_forward_share", true);
      paramContext1.putExtra("key_forward_share_title", ((AbsShareMsg)paramMessageForStructing.structingMsg).mContentTitle);
      paramContext1.putExtra("key_forward_image_share_uin_type", paramMessageForStructing.structingMsg.uinType);
    }
    ForwardBaseOption.a((Activity)paramContext2, paramContext1, 21);
    paramContext1 = paramMessageForStructing.structingMsg.mMsgUrl;
    ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005455", "0X8005455", 0, 0, paramMessageForStructing.senderuin, paramContext1, Long.toString(paramMessageForStructing.structingMsg.msgId), "");
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
    if (paramMessageForStructing.structingMsg.mMsgServiceID == 84) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8007166", "0X8007166", 0, 0, "", "", "", "");
    }
    if (AIOGallerySceneWithBusiness.a(paramString)) {
      ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(paramQQAppInterface, "3009", "2", "40053", AIOGallerySceneWithBusiness.b(paramString), new String[] { "2", "", AIOGallerySceneWithBusiness.a(paramString) });
    }
    if (paramMessageForStructing.isMultiMsg) {
      a("0X8009D66", paramMessageForStructing, paramQQAppInterface);
    }
  }
  
  private void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, Activity paramActivity, AbsShareMsg paramAbsShareMsg)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("bFriendCard", true);
      ((JSONObject)localObject).put("jumpUrl", paramAbsShareMsg.mContentCover);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    localObject = ((JSONObject)localObject).toString().getBytes();
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    localArrayList.add(paramAbsShareMsg.getXml().getBytes());
    QfavBuilder.a(null, false, paramAbsShareMsg.mContentTitle, paramAbsShareMsg.mContentSummary, false, 0L, "").b("sBizDataList", localArrayList).b(paramQQAppInterface, paramChatMessage).a(paramActivity, paramQQAppInterface.getAccount());
    QfavReport.a(paramQQAppInterface, 10, 0, paramAbsShareMsg.uinType);
  }
  
  private void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, Activity paramActivity, AbsShareMsg paramAbsShareMsg, byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    String str2 = ContactUtils.a(paramQQAppInterface, paramQQAppInterface.getAccount(), true);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramAbsShareMsg.mContentSrc;
    }
    QfavBuilder.a(paramInt, paramAbsShareMsg.mContentTitle, paramAbsShareMsg.mMsgUrl, paramAbsShareMsg.mSourceName, paramAbsShareMsg.mContentSummary, paramString, str1, paramArrayOfByte, false, 0L).b(paramQQAppInterface, paramChatMessage).a("lCategory", 10L).b("sUin", paramAbsShareMsg.mSourceName).a(paramActivity, paramQQAppInterface.getAccount());
    QfavReport.a(paramQQAppInterface, 8, 0, paramAbsShareMsg.uinType);
  }
  
  private void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, Context paramContext, AbsShareMsg paramAbsShareMsg, byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = paramAbsShareMsg.mContentSummary;
    if (this.a.a(paramAbsShareMsg))
    {
      localArrayList.add(QfavHelper.a(true));
      if ((!TextUtils.isEmpty(paramAbsShareMsg.mMsgUrl)) && (paramAbsShareMsg.mMsgUrl.indexOf("action=accountCard") > -1))
      {
        localArrayList.add(paramAbsShareMsg.getXml().getBytes());
        paramInt = 7;
      }
    }
    else if ((!TextUtils.isEmpty(paramAbsShareMsg.mMsgUrl)) && (paramAbsShareMsg.mMsgUrl.indexOf("jq.qq.com") > -1))
    {
      localArrayList.add(paramAbsShareMsg.getXml().getBytes());
      String str2 = this.a.a(paramAbsShareMsg.mContentCover);
      if (!TextUtils.isEmpty(str2))
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append(paramContext.getString(2131698110));
        paramArrayOfByte.append(str2);
        str1 = paramArrayOfByte.toString();
        paramArrayOfByte = null;
      }
      paramInt = 6;
    }
    if ((paramInt != 6) && (paramInt != 7))
    {
      if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsUrl(paramAbsShareMsg.mMsgUrl)) {
        QfavReport.a(paramQQAppInterface, 12, 0, paramAbsShareMsg.uinType);
      } else {
        QfavReport.a(paramQQAppInterface, 8, 0, paramAbsShareMsg.uinType);
      }
    }
    else {
      QfavReport.a(paramQQAppInterface, 10, 0, paramAbsShareMsg.uinType);
    }
    QfavBuilder.a(paramInt, paramAbsShareMsg.mContentTitle, paramAbsShareMsg.mMsgUrl, paramAbsShareMsg.mSourceName, str1, paramString, paramAbsShareMsg.mContentSrc, paramArrayOfByte, false, 0L).b("sBizDataList", localArrayList).b(paramQQAppInterface, paramChatMessage).a((Activity)paramContext, paramQQAppInterface.getAccount());
  }
  
  private void a(ChatMessage paramChatMessage, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface, Activity paramActivity, AbsShareMsg paramAbsShareMsg)
  {
    int i;
    if (((paramAbsShareMsg instanceof StructMsgForImageShare)) && (!paramMessageForStructing.isSendFromLocal()))
    {
      int j = 1;
      paramMessageForStructing = ((StructMsgForImageShare)paramAbsShareMsg).getFirstImageElement();
      int k = paramAbsShareMsg.uinType;
      i = j;
      if (paramMessageForStructing != null)
      {
        i = j;
        if (paramMessageForStructing.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
        {
          ((IPicPreDownload)paramQQAppInterface.getRuntimeService(IPicPreDownload.class, "")).productFromAIO(paramMessageForStructing.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 2);
          ThreadManager.getFileThreadHandler().post(new StructingMsgItemBuilderMenuHelper.2(this, paramMessageForStructing, k, paramQQAppInterface, paramChatMessage, paramActivity));
          i = j;
        }
      }
    }
    else
    {
      i = 0;
    }
    if (i == 0)
    {
      paramMessageForStructing = QfavUtil.a((StructMsgForImageShare)paramAbsShareMsg);
      if (paramMessageForStructing != null)
      {
        QfavBuilder.a(paramMessageForStructing.ae, paramAbsShareMsg.uinType, paramMessageForStructing.ad, paramMessageForStructing.c, paramMessageForStructing.ac, paramMessageForStructing.d).b(paramQQAppInterface, paramChatMessage).a(paramActivity, paramQQAppInterface.getAccount());
        QfavReport.a(paramQQAppInterface, 2, 0, paramAbsShareMsg.uinType);
        QfavReport.a(paramQQAppInterface, 6, 3);
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, String paramString, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.a.b(2131371562, paramContext, paramChatMessage);
    if (AIOGallerySceneWithBusiness.a(paramString)) {
      ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(paramQQAppInterface, "3009", "2", "40053", AIOGallerySceneWithBusiness.b(paramString), new String[] { "4", "", AIOGallerySceneWithBusiness.a(paramString) });
    }
    if (paramMessageForStructing.structingMsg.mMsgServiceID == 81) {
      StoryReportor.a(paramQQAppInterface, paramContext, paramMessageForStructing, "withdraw");
    }
  }
  
  private void a(MessageForStructing paramMessageForStructing, Context paramContext)
  {
    if (("web".equals(paramMessageForStructing.structingMsg.mMsgAction)) && (paramMessageForStructing.structingMsg.mMsgUrl != null)) {
      ((ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramMessageForStructing.structingMsg.mMsgUrl);
    }
  }
  
  private void a(AbsShareMsg paramAbsShareMsg, SessionInfo paramSessionInfo, Activity paramActivity)
  {
    paramAbsShareMsg = (StructMsgForGeneralShare)StructMsgFactory.a(paramAbsShareMsg.getBytes());
    PAVideoStructMsgUtil.a(paramAbsShareMsg);
    paramAbsShareMsg.mSourceAction = "web";
    String str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    paramAbsShareMsg.mSourceUrl = PAVideoStructMsgUtil.a(str);
    paramAbsShareMsg.mSourceName = paramSessionInfo.d;
    paramAbsShareMsg.source_puin = str;
    paramAbsShareMsg.mSourceIcon = "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png";
    paramAbsShareMsg.setFlag(0);
    paramSessionInfo = new Bundle();
    paramSessionInfo.putInt("forward_type", -3);
    paramSessionInfo.putInt("structmsg_service_id", paramAbsShareMsg.mMsgServiceID);
    paramSessionInfo.putByteArray("stuctmsg_bytes", paramAbsShareMsg.getBytes());
    paramAbsShareMsg = new Intent();
    paramAbsShareMsg.putExtras(paramSessionInfo);
    ForwardBaseOption.a(paramActivity, paramAbsShareMsg, 21);
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    if (paramAbsStructMsg.hasFlag(8)) {
      BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.jdField_a_of_type_Int, paramQQCustomMenu);
    }
    if (paramMessageForStructing.istroop == 1008)
    {
      if (!paramAbsStructMsg.hasFlag(32)) {
        BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.p, paramQQCustomMenu);
      } else if (!paramAbsStructMsg.hasFlag(1)) {
        BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.b, paramQQCustomMenu);
      }
    }
    else if (paramAbsStructMsg.mMsgServiceID != 14) {
      if (!paramAbsStructMsg.hasFlag(1))
      {
        BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.b, paramQQCustomMenu);
      }
      else if (paramAbsStructMsg.mMsgServiceID == 35)
      {
        BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.b, paramQQCustomMenu);
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006625", "0X8006625", 0, 1, 0, "", "", "", "");
      }
    }
    BaseBubbleBuilderMenuHelper.b(paramMessageForStructing, paramQQCustomMenu);
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg, QQAppInterface paramQQAppInterface)
  {
    if ((paramMessageForStructing.extraflag != 32768) && (!paramQQAppInterface.getMsgCache().b(paramMessageForStructing)) && (a(paramMessageForStructing, paramAbsStructMsg))) {
      BaseBubbleBuilderMenuHelper.a(paramMessageForStructing, paramQQCustomMenu);
    }
  }
  
  private void a(String paramString, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface)
  {
    paramMessageForStructing = paramMessageForStructing.structingMsg;
    if (paramMessageForStructing != null)
    {
      i = paramMessageForStructing.mMsgServiceID;
      if (i != 35)
      {
        if (i == 95)
        {
          i = 7;
          break label49;
        }
      }
      else
      {
        i = 2;
        break label49;
      }
    }
    int i = 10;
    label49:
    paramMessageForStructing = new StringBuilder();
    paramMessageForStructing.append("");
    paramMessageForStructing.append(i);
    ReportController.b(paramQQAppInterface, "dc00898", "", "", paramString, paramString, i, 0, paramMessageForStructing.toString(), "", "", "");
  }
  
  private void a(String paramString, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramMessageForStructing.structingMsg instanceof StructMsgForImageShare))
    {
      paramMessageForStructing = (StructMsgForImageShare)paramMessageForStructing.structingMsg;
      Object localObject1 = paramMessageForStructing.getFirstImageElement();
      if (localObject1 != null)
      {
        localObject1 = ((StructMsgItemImage)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        Object localObject2 = URLDrawableHelper.getURL((PicUiInterface)localObject1, 1);
        if (localObject2 == null) {
          return;
        }
        localObject2 = URLDrawable.getDrawable((URL)localObject2, -1, -1, null, null, false);
        ((URLDrawable)localObject2).setTag(localObject1);
        AIOGalleryUtils.a(paramContext, paramQQAppInterface, (URLDrawable)localObject2, ((MessageForPic)localObject1).frienduin, paramContext.getResources().getDimensionPixelSize(2131299168), paramMessageForStructing, null);
      }
    }
    if (AIOGallerySceneWithBusiness.a(paramString)) {
      ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(paramQQAppInterface, "3009", "2", "40053", AIOGallerySceneWithBusiness.b(paramString), new String[] { "1", "", AIOGallerySceneWithBusiness.a(paramString) });
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 86) || (paramInt == 61) || (paramInt == 91) || (paramInt == 97) || (paramInt == 98);
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 == paramInt2) || (paramInt1 == paramInt3);
  }
  
  private boolean a(Context paramContext1, String paramString, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface, Context paramContext2)
  {
    if ((paramMessageForStructing.structingMsg instanceof StructMsgForImageShare))
    {
      if (!((StructMsgForImageShare)paramMessageForStructing.structingMsg).checkImageSharePic(paramQQAppInterface.getApp())) {
        return true;
      }
    }
    else if (paramMessageForStructing.structingMsg.mMsgServiceID == 35)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006624", "0X8006624", 0, 1, 0, "", "", "", "");
      if (!MultiMsgManager.a().a(paramQQAppInterface, paramMessageForStructing.uniseq))
      {
        int i = paramContext1.getResources().getDimensionPixelSize(2131299168);
        QQToast.a(paramContext1, HardCodeUtil.a(2131714385), 0).b(i);
        return true;
      }
      if (MultiMsgManager.a().b(paramQQAppInterface, paramMessageForStructing.uniseq))
      {
        DialogUtil.a(paramContext1, 230, null, "选择的消息中，部分图片\\表情等内容可能无法正常转发，是否继续转发？", HardCodeUtil.a(2131714377), HardCodeUtil.a(2131714387), new StructingMsgItemBuilderMenuHelper.3(this, paramMessageForStructing, paramContext2), new StructingMsgItemBuilderMenuHelper.4(this)).show();
        return true;
      }
    }
    return false;
  }
  
  private boolean a(ChatMessage paramChatMessage, AbsStructMsg paramAbsStructMsg, QQAppInterface paramQQAppInterface, QQCustomMenu paramQQCustomMenu)
  {
    if ((paramChatMessage.isSendFromLocal()) && ((paramAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)paramAbsStructMsg).isSdkShareMsg()) && ((paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768)))
    {
      if (((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq) != null) {
        BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.n, paramQQCustomMenu);
      } else {
        BaseBubbleBuilderMenuHelper.a(paramChatMessage, paramQQCustomMenu);
      }
      BaseBubbleBuilderMenuHelper.a(paramChatMessage, paramQQCustomMenu);
      BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.l, paramQQCustomMenu);
      return true;
    }
    return false;
  }
  
  private boolean a(@NonNull MessageForStructing paramMessageForStructing, @NonNull AbsStructMsg paramAbsStructMsg, boolean paramBoolean)
  {
    boolean bool;
    if (((1008 != paramMessageForStructing.istroop) || (!AppConstants.REMINDER_UIN.equals(paramMessageForStructing.frienduin))) && ((paramAbsStructMsg.mMsgUrl == null) || (!paramAbsStructMsg.mMsgUrl.startsWith("https://ti.qq.com/remind/view.html"))))
    {
      bool = paramBoolean;
      if (paramAbsStructMsg.mMsgUrl != null)
      {
        bool = paramBoolean;
        if (!paramAbsStructMsg.mMsgUrl.startsWith("https://mqq.tenpay.com")) {}
      }
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  private boolean a(AbsStructMsg paramAbsStructMsg, MessageForStructing paramMessageForStructing, Context paramContext)
  {
    StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)paramAbsStructMsg;
    StructMsgItemImage localStructMsgItemImage = localStructMsgForImageShare.getFirstImageElement();
    paramAbsStructMsg = null;
    if (localStructMsgItemImage != null)
    {
      paramAbsStructMsg = localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      if (paramAbsStructMsg == null)
      {
        if (localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null)
        {
          localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = localStructMsgForImageShare;
          localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.message = paramMessageForStructing;
        }
        localStructMsgItemImage.a(paramContext, null, null);
        paramAbsStructMsg = localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      }
    }
    boolean bool = URLDrawableHelper.hasDiskCache(paramContext, paramAbsStructMsg, 65537);
    int i;
    if (paramAbsStructMsg.imageType == 2000) {
      i = 1;
    } else {
      i = 0;
    }
    return (!bool) && (i == 0);
  }
  
  private boolean a(QQCustomMenu paramQQCustomMenu, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg, QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = paramAbsStructMsg instanceof AbsShareMsg;
    boolean bool1 = false;
    if ((bool2) && (((AbsShareMsg)paramAbsStructMsg).mMsgException))
    {
      BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.e, paramQQCustomMenu);
      if (paramMessageForStructing.istroop == 1008) {
        BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.d, paramQQCustomMenu);
      }
      BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.l, paramQQCustomMenu);
    }
    else if (a(paramAbsStructMsg.mMsgServiceID))
    {
      BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.e, paramQQCustomMenu);
      BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.l, paramQQCustomMenu);
    }
    else if (paramAbsStructMsg.mMsgServiceID == 128)
    {
      BaseBubbleBuilderMenuHelper.b(paramMessageForStructing, paramQQCustomMenu);
      BaseBubbleBuilderMenuHelper.a(paramMessageForStructing, paramQQCustomMenu);
      BaseBubbleBuilderMenuHelper.c(paramMessageForStructing, paramQQCustomMenu);
      TroopReportor.a("Grp_AIO", "invite", "send_in", 0, 0, new String[0]);
    }
    else if ((paramAbsStructMsg instanceof StructMsgForHypertext))
    {
      BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.e, paramQQCustomMenu);
      BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.d, paramQQCustomMenu);
      BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.l, paramQQCustomMenu);
    }
    else
    {
      if (!a(paramMessageForStructing, paramAbsStructMsg, paramQQAppInterface, paramQQCustomMenu)) {
        break label178;
      }
    }
    bool1 = true;
    label178:
    return bool1;
  }
  
  private boolean a(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity, AbsShareMsg paramAbsShareMsg, boolean paramBoolean)
  {
    paramString = AIOGallerySceneWithBusiness.b(paramString);
    boolean bool = paramBoolean;
    if (paramString != null)
    {
      bool = paramBoolean;
      if (paramString.length > 2)
      {
        String str = paramString[1];
        paramString = paramString[2];
        paramString = (StructMsgForImageShare)paramAbsShareMsg;
        Object localObject = paramString.getFirstImageElement();
        if (localObject != null)
        {
          if (((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
            ((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = paramString;
          }
          AIOImageData localAIOImageData = AIOGalleryUtils.a(((StructMsgItemImage)localObject).a());
          localObject = localAIOImageData.a(4);
          paramString = (String)localObject;
          if (localObject == null) {
            paramString = localAIOImageData.a(2);
          }
          if (paramString != null) {
            paramString.getAbsolutePath();
          }
        }
        paramString = paramQQAppInterface.getAccount();
        QfavBuilder.a(str).c(paramString).a(paramActivity, paramString);
        QfavReport.a(paramQQAppInterface, 7, 0, paramAbsShareMsg.uinType);
        QfavReport.a(paramQQAppInterface, 6, 2);
        bool = true;
      }
    }
    return bool;
  }
  
  private void b(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, Activity paramActivity, AbsShareMsg paramAbsShareMsg)
  {
    if (!TextUtils.isEmpty(paramAbsShareMsg.mMsgActionData))
    {
      String[] arrayOfString1 = paramAbsShareMsg.mMsgActionData.split("&");
      int j = arrayOfString1.length;
      Object localObject4 = null;
      Object localObject1 = localObject4;
      Object localObject2 = localObject1;
      Object localObject3 = localObject2;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString2 = arrayOfString1[i].split("=");
        Object localObject5 = localObject4;
        Object localObject6 = localObject1;
        Object localObject7 = localObject2;
        Object localObject8 = localObject3;
        if (arrayOfString2.length > 1) {
          if (arrayOfString2[0].trim().equals("lat"))
          {
            localObject5 = arrayOfString2[1];
            localObject6 = localObject1;
            localObject7 = localObject2;
            localObject8 = localObject3;
          }
          else if (arrayOfString2[0].trim().equals("lon"))
          {
            localObject6 = arrayOfString2[1];
            localObject5 = localObject4;
            localObject7 = localObject2;
            localObject8 = localObject3;
          }
          else if (arrayOfString2[0].trim().equals("loc"))
          {
            localObject7 = arrayOfString2[1];
            localObject5 = localObject4;
            localObject6 = localObject1;
            localObject8 = localObject3;
          }
          else
          {
            localObject5 = localObject4;
            localObject6 = localObject1;
            localObject7 = localObject2;
            localObject8 = localObject3;
            if (arrayOfString2[0].trim().equals("title"))
            {
              localObject8 = arrayOfString2[1];
              localObject7 = localObject2;
              localObject6 = localObject1;
              localObject5 = localObject4;
            }
          }
        }
        i += 1;
        localObject4 = localObject5;
        localObject1 = localObject6;
        localObject2 = localObject7;
        localObject3 = localObject8;
      }
      if ((paramAbsShareMsg.mMsgServiceID == 32) && (!TextUtils.isEmpty(localObject4)) && (!TextUtils.isEmpty(localObject1)) && (!TextUtils.isEmpty(localObject2)))
      {
        QfavBuilder.a(Float.valueOf(localObject4).floatValue(), Float.valueOf(localObject1).floatValue(), localObject3, localObject2, null).b(paramQQAppInterface, paramChatMessage).a(paramActivity, paramQQAppInterface.getAccount());
        QfavReport.a(paramQQAppInterface, 11, 0, paramAbsShareMsg.uinType);
        QfavReport.a(paramQQAppInterface, 6, 7);
      }
    }
  }
  
  private void b(ChatMessage paramChatMessage, String paramString, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    AbsShareMsg localAbsShareMsg = (AbsShareMsg)paramMessageForStructing.structingMsg;
    boolean bool1;
    if ((localAbsShareMsg instanceof StructMsgForImageShare))
    {
      boolean bool3 = false;
      boolean bool2 = false;
      if (AIOGallerySceneWithBusiness.a(paramString))
      {
        bool1 = b(paramString, paramQQAppInterface, (Activity)paramContext, localAbsShareMsg, false);
      }
      else
      {
        bool1 = bool3;
        if (AIOGallerySceneWithBusiness.b(paramString))
        {
          bool2 = a(paramString, paramQQAppInterface, (Activity)paramContext, localAbsShareMsg, false);
          bool1 = bool3;
        }
      }
      if ((!bool1) && (!bool2)) {
        a(paramChatMessage, paramMessageForStructing, paramQQAppInterface, (Activity)paramContext, localAbsShareMsg);
      }
    }
    else
    {
      bool1 = localAbsShareMsg instanceof StructMsgForGeneralShare;
      if ((bool1) && (localAbsShareMsg.mMsgServiceID == 35))
      {
        paramString = ((BaseActivity)paramContext).getChatFragment();
        if (paramString != null)
        {
          paramString = paramString.a();
          ((MultiFavoriteHelper)paramString.a(11)).a(paramString, null, (MessageForStructing)paramChatMessage);
        }
      }
      else if (localAbsShareMsg.mMsgServiceID == 32)
      {
        b(paramChatMessage, paramQQAppInterface, (Activity)paramContext, localAbsShareMsg);
      }
      else
      {
        byte[] arrayOfByte = QfavUtil.a(localAbsShareMsg.getXmlBytes());
        paramString = localAbsShareMsg.mContentCover;
        int j;
        int i;
        if ((localAbsShareMsg instanceof StructMsgForAudioShare))
        {
          j = 10;
          i = 2;
        }
        else
        {
          if (bool1) {
            paramString = a((StructMsgForGeneralShare)localAbsShareMsg, paramString);
          }
          j = 2;
          i = 0;
        }
        if (a(localAbsShareMsg.mMsgServiceID, 14, 84)) {
          a(paramChatMessage, paramQQAppInterface, (Activity)paramContext, localAbsShareMsg);
        } else if (localAbsShareMsg.uinType == 1008) {
          a(paramChatMessage, paramQQAppInterface, (Activity)paramContext, localAbsShareMsg, arrayOfByte, i, paramString);
        } else {
          a(paramChatMessage, paramQQAppInterface, paramContext, localAbsShareMsg, arrayOfByte, i, paramString);
        }
        QfavReport.a(paramQQAppInterface, 6, j);
      }
    }
    if (paramMessageForStructing.isMultiMsg) {
      a("0X8009D67", paramMessageForStructing, paramQQAppInterface);
    }
  }
  
  private boolean b(MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    boolean bool2 = paramAbsStructMsg.hasFlag(2);
    boolean bool1 = false;
    if (!bool2)
    {
      if (((paramMessageForStructing.istroop != 1008) || (!TextUtils.isEmpty(paramAbsStructMsg.mMsgUrl))) && (paramAbsStructMsg.mMsgServiceID != 81) && (paramAbsStructMsg.mMsgServiceID != 14)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((paramAbsStructMsg.mMsgServiceID == 21) && (paramAbsStructMsg.mMsgActionData != null) && (paramAbsStructMsg.mMsgActionData.startsWith("mqqwpa://im/chat"))) {
        return false;
      }
    }
    return bool1;
  }
  
  private boolean b(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity, AbsShareMsg paramAbsShareMsg, boolean paramBoolean)
  {
    Object localObject3 = paramAbsShareMsg.mMsgActionData.substring(paramAbsShareMsg.mMsgActionData.indexOf("|") + 1).split("\\|");
    int i = localObject3.length;
    String str = null;
    Object localObject2;
    if ((i >= 8) && ((localObject3[7].equals("link")) || (localObject3[7].equals("scrawl_link"))))
    {
      if ((localObject3[7].equals("scrawl_link")) && (localObject3.length > 8)) {
        localObject1 = localObject3[8];
      } else {
        localObject1 = null;
      }
      paramBoolean = true;
      localObject2 = localObject1;
    }
    else
    {
      localObject2 = null;
    }
    Object localObject1 = localObject3;
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      localObject1 = localObject3;
      bool = paramBoolean;
      if (!TextUtils.isEmpty(paramAbsShareMsg.mMsg_A_ActionData))
      {
        localObject1 = paramAbsShareMsg.mMsg_A_ActionData.split("\\|");
        if ((localObject1.length >= 8) && (localObject1[7].equals("link"))) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
    if (bool)
    {
      Object localObject4 = (StructMsgForImageShare)paramAbsShareMsg;
      Object localObject5 = ((StructMsgForImageShare)localObject4).getFirstImageElement();
      localObject3 = str;
      if (localObject5 != null)
      {
        if (((StructMsgItemImage)localObject5).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
          ((StructMsgItemImage)localObject5).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)localObject4);
        }
        localObject5 = AIOGalleryUtils.a(((StructMsgItemImage)localObject5).a());
        localObject3 = ((AIOImageData)localObject5).a(4);
        localObject4 = localObject3;
        if (localObject3 == null) {
          localObject4 = ((AIOImageData)localObject5).a(2);
        }
        localObject3 = str;
        if (localObject4 != null) {
          localObject3 = ((File)localObject4).getAbsolutePath();
        }
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(localObject1[3]);
      ((StringBuilder)localObject4).append(HardCodeUtil.a(2131714376));
      ((StringBuilder)localObject4).append(localObject1[5]);
      ((StringBuilder)localObject4).append(HardCodeUtil.a(2131714382));
      localObject5 = ((StringBuilder)localObject4).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("ADTAG=comic.plugin.read&id=");
      ((StringBuilder)localObject4).append(localObject1[0]);
      ((StringBuilder)localObject4).append("&name=");
      ((StringBuilder)localObject4).append(URLEncoder.encode(localObject1[1]));
      ((StringBuilder)localObject4).append("&sectionID=");
      ((StringBuilder)localObject4).append(localObject1[2]);
      ((StringBuilder)localObject4).append("&sectionName=");
      ((StringBuilder)localObject4).append(URLEncoder.encode(localObject1[3]));
      ((StringBuilder)localObject4).append("&pageID=");
      ((StringBuilder)localObject4).append(localObject1[4]);
      ((StringBuilder)localObject4).append("&page=");
      ((StringBuilder)localObject4).append(localObject1[5]);
      ((StringBuilder)localObject4).append("&type=");
      ((StringBuilder)localObject4).append(localObject1[6]);
      str = ((StringBuilder)localObject4).toString();
      localObject4 = str;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(str);
        ((StringBuilder)localObject4).append("&scrawl_link=");
        ((StringBuilder)localObject4).append(URLEncoder.encode((String)localObject2));
        localObject4 = ((StringBuilder)localObject4).toString();
      }
      localObject2 = ((IQQComicUtil)QRoute.api(IQQComicUtil.class)).getUrl("comicReadShare", "5123", null, null, "354", null, (String)localObject4);
      new QfavBuilder(6).a("nLinkType", 0).b("sTitle", localObject1[1]).b("sUrl", (String)localObject2).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", paramAbsShareMsg.mSourceName).b("sBrief", (String)localObject5).b("sPath", (String)localObject3).b("sResUrl", paramAbsShareMsg.mSourceUrl).a("lCategory", 1L).a(paramActivity, paramQQAppInterface.getAccount());
      QfavReport.a(paramQQAppInterface, 6, 2);
      QfavReport.a(paramQQAppInterface, 8, 0, paramAbsShareMsg.uinType);
      ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(paramQQAppInterface, "3009", "2", "40053", AIOGallerySceneWithBusiness.b(paramString), new String[] { "3", "", AIOGallerySceneWithBusiness.a(paramString) });
    }
    return bool;
  }
  
  private void c(ChatMessage paramChatMessage, String paramString, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.a.b(2131371603, paramContext, paramChatMessage);
    boolean bool = AIOGallerySceneWithBusiness.a(paramString);
    int j = 0;
    if (bool) {
      ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(paramQQAppInterface, "3009", "2", "40053", AIOGallerySceneWithBusiness.b(paramString), new String[] { "6", "", AIOGallerySceneWithBusiness.a(paramString) });
    }
    if (paramChatMessage.istroop == 1008)
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      long l1 = 0L;
      int i = j;
      if ((paramMessageForStructing.structingMsg instanceof AbsShareMsg))
      {
        Object localObject = (AbsShareMsg)paramMessageForStructing.structingMsg;
        long l2 = ((AbsShareMsg)localObject).msgId;
        i = j;
        l1 = l2;
        if ((localObject instanceof StructMsgForGeneralShare))
        {
          localObject = (StructMsgForGeneralShare)localObject;
          i = StructMsgForGeneralShare.clickedItemIndex;
          l1 = l2;
        }
      }
      ReportController.b(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", paramChatMessage.frienduin, "0X80064F7", "0X80064F7", 0, 0, paramString, String.valueOf(l1), String.valueOf(i), "");
    }
    if (paramMessageForStructing.structingMsg.mMsgServiceID == 81) {
      StoryReportor.a(paramQQAppInterface, paramContext, paramMessageForStructing, "more");
    }
  }
  
  private void d(ChatMessage paramChatMessage, String paramString, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    ChatActivityFacade.b(paramContext, paramQQAppInterface, paramChatMessage);
    if (AIOGallerySceneWithBusiness.a(paramString)) {
      ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(paramQQAppInterface, "3009", "2", "40053", AIOGallerySceneWithBusiness.b(paramString), new String[] { "5", "", AIOGallerySceneWithBusiness.a(paramString) });
    }
    if (paramMessageForStructing.structingMsg.mMsgServiceID == 81) {
      StoryReportor.a(paramQQAppInterface, paramContext, paramMessageForStructing, "delete");
    }
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    paramBaseHolder = this.a.a();
    Context localContext = this.a.a();
    SessionInfo localSessionInfo = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    MessageForStructing localMessageForStructing = (MessageForStructing)paramChatMessage;
    AbsStructMsg localAbsStructMsg = localMessageForStructing.structingMsg;
    if (localAbsStructMsg == null) {
      return paramQQCustomMenu;
    }
    boolean bool = false;
    if (a(paramQQCustomMenu, localMessageForStructing, localAbsStructMsg, paramBaseHolder)) {
      return paramQQCustomMenu;
    }
    if ((localAbsStructMsg instanceof StructMsgForImageShare))
    {
      if (a(localAbsStructMsg, localMessageForStructing, localContext))
      {
        BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.l, paramQQCustomMenu);
        return paramQQCustomMenu;
      }
      BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.o, paramQQCustomMenu);
    }
    if (localAbsStructMsg.fwFlag != 1)
    {
      a(paramQQCustomMenu, paramBaseHolder, localMessageForStructing, localAbsStructMsg);
      bool = b(localMessageForStructing, localAbsStructMsg);
    }
    else
    {
      BaseBubbleBuilderMenuHelper.b(localMessageForStructing, paramQQCustomMenu);
    }
    a(paramQQCustomMenu, localMessageForStructing, localAbsStructMsg, paramBaseHolder);
    if ((localSessionInfo.jdField_a_of_type_Int != 1008) || (paramQQCustomMenu.a() == 0)) {
      BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.e, paramQQCustomMenu);
    }
    if ((localAbsStructMsg.mMsgServiceID == 14) || (localAbsStructMsg.mMsgServiceID == 35) || (localAbsStructMsg.mMsgServiceID == 84)) {
      bool = true;
    }
    if (bool) {
      BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.h, paramQQCustomMenu);
    }
    BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.i, paramQQCustomMenu);
    if ((localAbsStructMsg.mMsgServiceID != 49) && (localAbsStructMsg.mMsgServiceID != 106) && (localAbsStructMsg.mMsgServiceID != 14)) {
      BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.d, paramQQCustomMenu);
    }
    if (localAbsStructMsg.mMsgServiceID == 81) {
      StoryReportor.a(paramBaseHolder, localContext, localMessageForStructing, "press");
    }
    BaseBubbleBuilderMenuHelper.a(BaseBubbleBuilderMenuHelper.l, paramQQCustomMenu);
    if (TroopEssenceUtil.a(paramChatMessage)) {
      BaseBubbleBuilderMenuHelper.d(localMessageForStructing, paramQQCustomMenu);
    }
    return paramQQCustomMenu;
  }
  
  public boolean a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    String str = AIOGallerySceneWithBusiness.a(paramChatMessage);
    MessageForStructing localMessageForStructing = (MessageForStructing)paramChatMessage;
    Object localObject = localMessageForStructing.structingMsg;
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    localObject = this.a.a();
    Context localContext = this.a.a();
    SessionInfo localSessionInfo = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (paramInt == 2131362241)
    {
      a(str, localMessageForStructing, (QQAppInterface)localObject, localContext);
    }
    else if (paramInt == 2131367180)
    {
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "structingMsgItem forward");
      }
      a(paramContext, str, localMessageForStructing, (QQAppInterface)localObject, localContext);
    }
    else if (paramInt == 2131365480)
    {
      d(paramChatMessage, str, localMessageForStructing, (QQAppInterface)localObject, localContext);
    }
    else if (paramInt == 2131371603)
    {
      c(paramChatMessage, str, localMessageForStructing, (QQAppInterface)localObject, localContext);
    }
    else if (paramInt == 2131366494)
    {
      b(paramChatMessage, str, localMessageForStructing, (QQAppInterface)localObject, localContext);
    }
    else if (paramInt == 2131365311)
    {
      a(localMessageForStructing, localContext);
    }
    else if (paramInt == 2131371592)
    {
      this.a.b(2131371603, localContext, paramChatMessage);
    }
    else if (paramInt == 2131367202)
    {
      a(paramContext, localMessageForStructing, (QQAppInterface)localObject, (Activity)localContext, localSessionInfo);
    }
    else if (paramInt == 2131371562)
    {
      a(paramChatMessage, str, localMessageForStructing, (QQAppInterface)localObject, localContext);
    }
    else
    {
      if (paramInt != 2131364271) {
        break label329;
      }
      paramContext = ((ITransFileController)((QQAppInterface)localObject).getRuntimeService(ITransFileController.class)).findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramContext != null) && ((paramContext instanceof BaseTransProcessor))) {
        ((BaseTransProcessor)paramContext).cancel();
      }
    }
    bool = true;
    label329:
    return bool;
  }
  
  protected boolean a(@NonNull MessageForStructing paramMessageForStructing, @NonNull AbsStructMsg paramAbsStructMsg)
  {
    int i = paramMessageForStructing.istroop;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i == 1)
    {
      if ((paramAbsStructMsg.mMsgServiceID != 23) && (paramAbsStructMsg.mMsgServiceID != 19) && (paramAbsStructMsg.mMsgServiceID != 60) && (!HardCodeUtil.a(2131714386).equals(paramAbsStructMsg.getSourceName())))
      {
        bool1 = bool2;
        if (paramAbsStructMsg.mMsgUrl == null) {
          break label104;
        }
        if (!paramAbsStructMsg.mMsgUrl.startsWith("http://qqweb.qq.com/m/qunactivity"))
        {
          bool1 = bool2;
          if (!paramAbsStructMsg.mMsgUrl.startsWith("https://qqweb.qq.com/m/qunactivity")) {
            break label104;
          }
        }
      }
      bool1 = false;
    }
    label104:
    bool1 = a(paramMessageForStructing, paramAbsStructMsg, bool1);
    if (paramAbsStructMsg.mMsgServiceID == 49) {
      bool1 = false;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilderMenuHelper
 * JD-Core Version:    0.7.0.1
 */