package com.tencent.mobileqq.activity;

import ActionMsg.MsgBody;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MixedImageOnclickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForDingdongSchedule;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.lovelanguage.LoveLanguageManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.data.TroopRankConfig.TroopRankItem;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import com.tencent.mobileqq.widget.PatchedTextView;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.RichMsg.PttRec;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import rwp;
import rwr;
import rwt;
import rwu;
import rwv;
import rwx;
import rwy;
import rwz;
import rxa;

public class ChatHistory$ChatHistoryAdapter
  extends CursorAdapter
{
  protected int a;
  public Context a;
  protected LayoutInflater a;
  protected int b;
  public int c = -1;
  
  public ChatHistory$ChatHistoryAdapter(ChatHistory paramChatHistory, Context paramContext, Cursor paramCursor)
  {
    super(paramContext, paramCursor);
    this.jdField_a_of_type_Int = 1000;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramChatHistory.jdField_a_of_type_Float < 1.0F)
    {
      paramChatHistory.g = ((int)(100.0F * paramChatHistory.jdField_a_of_type_Float));
      paramChatHistory.f = ((int)(paramChatHistory.jdField_a_of_type_Float * 34.0F));
      paramChatHistory.h = ((int)(paramChatHistory.jdField_a_of_type_Float * 14.0F));
    }
    for (paramChatHistory.i = ((int)(paramChatHistory.jdField_a_of_type_Float * 15.0F));; paramChatHistory.i = ((int)(paramChatHistory.jdField_a_of_type_Float * 15.0F)))
    {
      paramChatHistory = paramContext.getResources().getDisplayMetrics();
      this.b = Math.min(paramChatHistory.widthPixels, paramChatHistory.heightPixels);
      return;
      paramChatHistory.g = ((int)(120.0F * paramChatHistory.jdField_a_of_type_Float));
      paramChatHistory.f = ((int)(paramChatHistory.jdField_a_of_type_Float * 34.0F));
      paramChatHistory.h = ((int)(paramChatHistory.jdField_a_of_type_Float * 14.0F));
    }
  }
  
  protected int a(int paramInt)
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.f;
    int i;
    if (paramInt >= 60) {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g;
    }
    do
    {
      do
      {
        return i;
        if ((paramInt > 45) && (paramInt < 60)) {
          return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * 15 / 16 + (paramInt - 45) * this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g / 15 / 16 + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.f;
        }
        if ((paramInt > 30) && (paramInt <= 45)) {
          return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * 13 / 16 + (paramInt - 30) * this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * 2 / 15 / 16 + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.f;
        }
        if ((paramInt > 15) && (paramInt <= 30)) {
          return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * 9 / 16 + (paramInt - 15) * this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * 4 / 15 / 16 + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.f;
        }
        i = j;
      } while (paramInt <= 0);
      i = j;
    } while (paramInt > 15);
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * paramInt * 9 / 16 / 15 + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.f;
  }
  
  protected String a(long paramLong)
  {
    Time localTime1 = new Time();
    Time localTime2 = new Time();
    localTime1.set(paramLong);
    localTime2.setToNow();
    if (localTime1.year != localTime2.year) {
      return localTime1.format("%Y-%m-%d %H:%M:%S");
    }
    if (localTime1.yearDay != localTime2.yearDay) {
      return localTime1.format("%m-%d %H:%M:%S");
    }
    return localTime1.format("%H:%M:%S");
  }
  
  public void a()
  {
    super.changeCursor(null);
  }
  
  public void a(Cursor paramCursor, TextView paramTextView1, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, TextView paramTextView2, ChatHistory.Holder paramHolder, ImageView paramImageView1, CharSequence paramCharSequence, ChatThumbView paramChatThumbView, View paramView1, View paramView2, ImageView paramImageView2, long paramLong)
  {
    Object localObject = paramCursor.getString(paramCursor.getColumnIndex("extStr"));
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new JSONObject((String)localObject);
      if (((JSONObject)localObject).has("Emoji_Sticker_Info"))
      {
        i = new JSONObject(((JSONObject)localObject).getString("Emoji_Sticker_Info")).getInt("msgType");
        if (i != -1000) {
          break label286;
        }
        i = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
        paramTextView1.setVisibility(0);
        if (!MessageUtils.a(paramInt1))
        {
          paramTextView1.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
          paramTextView1.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
        }
        if (!String.valueOf(AppConstants.F).equals(paramString1)) {
          break label184;
        }
        paramCursor = SystemMsg.decode(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, paramString2, paramString3, i);
        if (paramCursor != null)
        {
          paramTextView1.setText(paramCursor.message);
          if (paramInt2 == 32769) {
            paramTextView2.setText(paramCursor.troopCode);
          }
        }
      }
    }
    for (;;)
    {
      return;
      label184:
      if (-2008 == i)
      {
        paramTextView1.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131436145));
        return;
      }
      if (-1002 == i)
      {
        paramTextView1.setText(paramHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("sens_msg_original_text"));
        return;
      }
      paramInt1 = paramCursor.getInt(paramCursor.getColumnIndex("extraflag"));
      if ((paramImageView1 != null) && (paramInt1 == 32768)) {
        paramImageView1.setVisibility(0);
      }
      paramTextView1.setText(new QQText(paramCharSequence, 13, 32, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Int));
      return;
      label286:
      if (i == -2000)
      {
        if ((paramHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic))
        {
          if (FlashPicHelper.a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
          {
            paramTextView1.setVisibility(0);
            paramTextView1.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131435551));
            paramTextView1.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
            paramTextView1.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
            return;
          }
          paramCursor = (MessageForPic)paramHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          paramCursor.parse();
          paramTextView1 = new ImageViewParameter();
          paramChatThumbView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
          paramChatThumbView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
          paramTextView1.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramCursor;
          paramTextView1.jdField_a_of_type_ComTencentImageURLImageView = paramChatThumbView;
          if (QLog.isColorLevel()) {
            QLog.d("history", 2, "bindView pic.path:" + paramCursor.path + ",pic.uuid:" + paramCursor.uuid);
          }
          if ((paramTextView1.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramTextView1.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.path != null)) {
            a(paramTextView1);
          }
        }
        else if ((QLog.isColorLevel()) && (paramHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null))
        {
          QLog.d("history", 2, "holy shit,not messageforpicuniseq:" + paramHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ",dbid:" + paramHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getId() + "istroop:" + paramHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop + ",msgtype:" + paramHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype);
        }
      }
      else if (i == -2007)
      {
        paramCursor = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
        try
        {
          paramCursor = MessagePkgUtils.a(paramCursor);
          if ((paramCursor instanceof MarkFaceMessage))
          {
            paramChatThumbView.setVisibility(0);
            paramTextView1.setVisibility(8);
            paramImageView1.setVisibility(8);
            paramView1.setVisibility(8);
            paramView2.setVisibility(8);
            paramChatThumbView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
            paramChatThumbView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
            paramChatThumbView.setTag(paramString1 + paramLong);
            paramImageView2.setTag(null);
            a(paramChatThumbView, (MarkFaceMessage)paramCursor, paramImageView2);
            return;
          }
        }
        catch (Exception paramCursor)
        {
          QLog.e("ChatHistory", 1, "dealStikerMessage e = " + paramCursor);
        }
      }
    }
  }
  
  public void a(ImageView paramImageView, int paramInt, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if (paramPicEmoticonInfo == null) {
      paramImageView.setImageResource(2130837572);
    }
    do
    {
      do
      {
        return;
        if (paramInt != 2) {
          break label222;
        }
        if (paramPicEmoticonInfo.a()) {
          break;
        }
        paramPicEmoticonInfo = paramPicEmoticonInfo.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Float);
      } while (paramPicEmoticonInfo == null);
      paramImageView.setImageDrawable(paramPicEmoticonInfo);
      paramImageView.setOnClickListener(null);
      return;
    } while (paramPicEmoticonInfo.a("fromAIO", true) == null);
    paramImageView.setOnClickListener(new rwx(this, paramPicEmoticonInfo));
    Object localObject = (View)paramImageView.getParent();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.a(0, paramImageView.getTag())))
    {
      paramImageView = EmoticonUtils.o.replace("[epId]", paramPicEmoticonInfo.a.epId).replace("[eId]", paramPicEmoticonInfo.a.eId);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.a((View)localObject, paramImageView);
      if (localObject == null) {
        break label418;
      }
    }
    label418:
    for (paramImageView = (ImageView)((View)localObject).findViewById(2131363760);; paramImageView = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a(paramImageView);
      return;
      if (localObject != null) {}
      for (localObject = (ImageView)((View)localObject).findViewById(2131363760);; localObject = null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b((ImageView)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a(paramImageView, paramPicEmoticonInfo);
        return;
        label222:
        if (paramInt == 1)
        {
          paramPicEmoticonInfo = paramPicEmoticonInfo.a();
          if (paramPicEmoticonInfo == null) {
            break;
          }
          paramImageView.setImageDrawable(paramPicEmoticonInfo);
          return;
        }
        if (paramInt == 3)
        {
          MarketFaceItemBuilder.Holder localHolder = new MarketFaceItemBuilder.Holder();
          paramImageView.setOnClickListener(null);
          localHolder.e = paramImageView;
          localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = paramPicEmoticonInfo;
          PngFrameManager localPngFrameManager = (PngFrameManager)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.getManager(82);
          localHolder.jdField_a_of_type_Long = paramPicEmoticonInfo.a.getId();
          MessageForMarketFace localMessageForMarketFace = (MessageForMarketFace)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          localObject = "";
          paramImageView = (ImageView)localObject;
          if (localMessageForMarketFace != null)
          {
            paramImageView = (ImageView)localObject;
            if (localMessageForMarketFace.mMarkFaceMessage != null)
            {
              paramImageView = (ImageView)localObject;
              if (localMessageForMarketFace.mMarkFaceMessage.mobileparam != null)
              {
                paramImageView = (ImageView)localObject;
                if (localMessageForMarketFace.mMarkFaceMessage.mobileparam.length > 0) {
                  paramImageView = new String(localMessageForMarketFace.mMarkFaceMessage.mobileparam);
                }
              }
            }
          }
          localPngFrameManager.a(paramImageView, localHolder, paramPicEmoticonInfo.a.getId(), false, false, null);
          return;
        }
        if (paramInt != 0) {
          break;
        }
        paramImageView.setImageResource(2130837572);
        return;
      }
    }
  }
  
  protected void a(ImageView paramImageView1, MarkFaceMessage paramMarkFaceMessage, ImageView paramImageView2)
  {
    if (paramMarkFaceMessage == null)
    {
      a(paramImageView1, 0, null);
      return;
    }
    ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.getManager(13)).a(paramMarkFaceMessage, new rwy(this, paramImageView2, paramMarkFaceMessage, paramImageView1));
  }
  
  protected void a(ImageViewParameter paramImageViewParameter)
  {
    Object localObject = PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, paramImageViewParameter.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
    paramImageViewParameter.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    paramImageViewParameter.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    int i = paramImageViewParameter.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.msgtype;
    localObject = paramImageViewParameter.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.action;
    paramImageViewParameter.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new rwz(this, i, paramImageViewParameter, (String)localObject));
  }
  
  public void a(MixedMsgLinearLayout paramMixedMsgLinearLayout, MessageForMixedMsg paramMessageForMixedMsg)
  {
    paramMessageForMixedMsg.parse();
    int j = paramMessageForMixedMsg.msgElemList.size();
    int i = 0;
    while (i < j)
    {
      localObject1 = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(i);
      if (((localObject1 instanceof MessageForPic)) && (((MessageForPic)localObject1).time == 0L)) {
        MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject1, paramMessageForMixedMsg);
      }
      i += 1;
    }
    paramMixedMsgLinearLayout.a(paramMessageForMixedMsg.msgElemList);
    Object localObject1 = new MixedImageOnclickListener();
    ((MixedImageOnclickListener)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    j = paramMessageForMixedMsg.msgElemList.size();
    i = 0;
    if (i < j)
    {
      Object localObject2 = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(i);
      View localView = paramMixedMsgLinearLayout.getChildAt(i);
      Object localObject3;
      if ((localObject2 instanceof MessageForText))
      {
        localObject3 = (AnimationTextView)localView;
        ((AnimationTextView)localObject3).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getColor(2131494250));
        ((AnimationTextView)localObject3).setTextSize(0, AIOUtils.a(16.0F, paramMixedMsgLinearLayout.getContext().getResources()));
        if (TextUtils.isEmpty(((MessageForText)localObject2).sb2)) {
          ((AnimationTextView)localObject3).setText(((MessageForText)localObject2).sb);
        }
      }
      for (;;)
      {
        localView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
        localView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
        i += 1;
        break;
        ((AnimationTextView)localObject3).setText(((MessageForText)localObject2).sb2);
        continue;
        if ((localObject2 instanceof MessageForPic))
        {
          localObject2 = (MessageForPic)localObject2;
          localObject3 = (ChatThumbView)localView;
          URLDrawable localURLDrawable = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localObject2, (ChatThumbView)localObject3);
          ((ChatThumbView)localObject3).setTag(2131361894, localObject2);
          ((ChatThumbView)localObject3).setImageDrawable(localURLDrawable);
          ((ChatThumbView)localObject3).setOnClickListener((View.OnClickListener)localObject1);
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("ChatHistory", 2, "mixed type not support yet." + localObject2.getClass().getSimpleName());
        }
      }
    }
    paramMixedMsgLinearLayout.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
    paramMixedMsgLinearLayout.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    ThreadManager.getSubThreadHandler().post(new rxa(this, paramInt1, paramInt2, paramString));
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    ChatHistory.Holder localHolder = (ChatHistory.Holder)paramView.getTag();
    if (localHolder == null)
    {
      localHolder = new ChatHistory.Holder(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory);
      paramView.setTag(localHolder);
    }
    label696:
    label726:
    label1496:
    label1502:
    label1761:
    label5858:
    for (;;)
    {
      Object localObject1 = MessageRecord.getTableName(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Int);
      localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a().a(MessageRecord.class, (String)localObject1, paramCursor));
      if (localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
        if (QLog.isColorLevel()) {
          QLog.w("ChatHistory", 2, "bindView message is null !!");
        }
      }
      label99:
      TextView localTextView1;
      PatchedTextView localPatchedTextView;
      ImageView localImageView1;
      int j;
      do
      {
        do
        {
          return;
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.d) {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.a().a(localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          }
          long l3 = paramCursor.getLong(0);
          localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.setId(l3);
          LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131363752);
          TextView localTextView3 = (TextView)paramView.findViewById(2131363753);
          localTextView1 = (TextView)paramView.findViewById(2131363754);
          TextView localTextView4 = (TextView)paramView.findViewById(2131363755);
          localPatchedTextView = (PatchedTextView)paramView.findViewById(2131363757);
          localImageView1 = (ImageView)paramView.findViewById(2131363758);
          MixedMsgLinearLayout localMixedMsgLinearLayout = (MixedMsgLinearLayout)paramView.findViewById(2131363763);
          TextView localTextView2 = (TextView)paramView.findViewById(2131363756);
          localLinearLayout.setVisibility(0);
          localPatchedTextView.setVisibility(0);
          localTextView2.setVisibility(8);
          ChatThumbView localChatThumbView = (ChatThumbView)paramView.findViewById(2131363759);
          localChatThumbView.jdField_a_of_type_Boolean = false;
          ImageView localImageView3 = (ImageView)paramView.findViewById(2131363761);
          Button localButton = (Button)paramView.findViewById(2131363762);
          ImageView localImageView2 = (ImageView)paramView.findViewById(2131363760);
          localImageView2.setVisibility(8);
          localTextView3.setVisibility(8);
          localPatchedTextView.setMovementMethod(LinkMovementMethod.getInstance());
          String str1 = paramCursor.getString(paramCursor.getColumnIndex("frienduin"));
          String str2 = paramCursor.getString(paramCursor.getColumnIndex("senderuin"));
          i = paramCursor.getInt(paramCursor.getColumnIndex("istroop"));
          int k = paramCursor.getInt(paramCursor.getColumnIndex("issend"));
          j = paramCursor.getInt(paramCursor.getColumnIndex("time"));
          int m;
          Object localObject3;
          Object localObject6;
          Object localObject5;
          if ((paramCursor.getColumnIndex("versionCode") < 0) || (paramCursor.getInt(paramCursor.getColumnIndex("versionCode")) <= 0))
          {
            localObject1 = paramCursor.getString(paramCursor.getColumnIndex("msg"));
            m = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a(i, m, (String)localObject1, k).msg;
            localObject3 = TroopBusinessUtil.a(localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
            localObject6 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.getManager(51);
            localObject5 = ((TroopManager)localObject6).a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b);
            if ((localObject5 != null) && (((TroopInfo)localObject5).cGroupRankSysFlag == 1) && (((TroopInfo)localObject5).cGroupRankUserFlag == 1) && (localObject3 == null))
            {
              localObject6 = ((TroopManager)localObject6).b(str1, str2);
              localObject5 = TroopRankConfig.a().a((TroopMemberInfo)localObject6, (TroopInfo)localObject5);
              if (localObject5 != null)
              {
                localTextView3.setVisibility(0);
                localTextView3.setText(((TroopRankConfig.TroopRankItem)localObject5).jdField_a_of_type_JavaLangString);
                TroopRankConfig.a(localTextView3, ((TroopRankConfig.TroopRankItem)localObject5).b);
              }
            }
            if (localObject3 == null) {
              break label1296;
            }
            localTextView1.setText(((TroopBusinessUtil.TroopBusinessMessage)localObject3).c);
            localTextView3.setVisibility(0);
            localTextView3.setText(((TroopBusinessUtil.TroopBusinessMessage)localObject3).jdField_d_of_type_JavaLangString);
            localTextView3.setBackgroundDrawable(TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources(), ((TroopBusinessUtil.TroopBusinessMessage)localObject3).jdField_d_of_type_Int));
            if ((localObject3 == null) || (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, false, null))) {
              break label1475;
            }
            localTextView1.setTextColor(((TroopBusinessUtil.TroopBusinessMessage)localObject3).b);
            localTextView4.setText(a(j * 1000L));
            j = paramCursor.getInt(paramCursor.getColumnIndex("extraflag"));
            if (j != 32768) {
              break label1496;
            }
          }
          for (i = 1;; i = 0)
          {
            for (;;)
            {
              if (i != 0) {
                localPatchedTextView.setMaxWidth((int)(paramContext.getResources().getDisplayMetrics().widthPixels - 70.0F * this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Float));
              }
              localChatThumbView.setVisibility(8);
              localPatchedTextView.setVisibility(8);
              localImageView1.setVisibility(8);
              localImageView3.setVisibility(8);
              localButton.setVisibility(8);
              localMixedMsgLinearLayout.setVisibility(8);
              localPatchedTextView.setOnTouchListener(null);
              localPatchedTextView.setOnLongClickListener(null);
              localPatchedTextView.setOnClickListener(null);
              localButton.setOnClickListener(null);
              m = paramCursor.getInt(getCursor().getColumnIndex("msgtype"));
              if (m != -2007) {
                break label1502;
              }
              localChatThumbView.setVisibility(0);
              localPatchedTextView.setVisibility(8);
              localImageView1.setVisibility(8);
              localImageView3.setVisibility(8);
              localButton.setVisibility(8);
              localChatThumbView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
              localChatThumbView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
              paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
              localChatThumbView.setTag(str1 + l3);
              localImageView2.setTag(null);
              try
              {
                a(localChatThumbView, (MarkFaceMessage)MessagePkgUtils.a(paramView), localImageView2);
                return;
              }
              catch (Exception paramView)
              {
                paramView.printStackTrace();
                a(localChatThumbView, null, localImageView2);
                return;
              }
              if (((localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForFoldMsg)) || ((localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForUniteGrayTip)))
              {
                localObject1 = localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg;
                break;
              }
              try
              {
                localObject5 = new String(paramCursor.getBlob(paramCursor.getColumnIndex("msgData")), "UTF-8");
                for (;;)
                {
                  try
                  {
                    localObject1 = new StringBuilder((String)localObject5);
                    localObject3 = localObject1;
                    if ((localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForText))
                    {
                      localObject3 = localObject1;
                      if (localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 3000)
                      {
                        localObject6 = localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("disc_at_info_list");
                        bool = TextUtils.isEmpty((CharSequence)localObject6);
                        localObject3 = localObject1;
                        if (bool) {}
                      }
                    }
                    try
                    {
                      localObject3 = BaseApplicationImpl.sApplication.getRuntime();
                      if (!QQAppInterface.class.isInstance(localObject3)) {
                        continue;
                      }
                      localObject3 = AtTroopMemberSpan.a((QQAppInterface)localObject3, (StringBuilder)localObject1, (String)localObject6, str1, localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
                      localObject1 = localObject3;
                      localObject3 = localObject1;
                    }
                    catch (Exception localException2)
                    {
                      QLog.e("ChatHistory", 1, "replaceAtMsgByMarkName", localException2);
                      localObject4 = localObject1;
                      continue;
                    }
                    localObject1 = ((StringBuilder)localObject3).toString();
                  }
                  catch (Exception localException1)
                  {
                    localObject4 = localObject5;
                    localObject5 = localException1;
                    localObject2 = localObject4;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("ChatHistory", 2, "We get error AppRuntime");
                  }
                }
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  boolean bool;
                  Object localObject4;
                  long l2;
                  long l1;
                  Object localObject2 = "";
                  continue;
                }
              }
            }
            QLog.e("ChatHistory", 1, "cursor Error", (Throwable)localObject5);
            break;
            if (AnonymousChatHelper.a(localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
            {
              localTextView1.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getString(2131430270) + AnonymousChatHelper.a(localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).b);
              localTextView3.setVisibility(8);
              break label696;
            }
            if (TroopBindPublicAccountMgr.a(localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
            {
              localTextView1.setText(PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, BaseApplicationImpl.getContext()));
              break label696;
            }
            if ((!TextUtils.isEmpty(localHolder.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localHolder.b)) && (localHolder.b.equals(str2)))
            {
              localTextView1.setText(localHolder.jdField_a_of_type_JavaLangString);
              break label696;
            }
            localHolder.b = str2;
            ThreadManager.post(new rwp(this, k, str2, localHolder, localTextView1), 8, null, true);
            break label696;
            localTextView1.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getColor(2131494213));
            break label726;
          }
          if (m == -2058) {
            try
            {
              a(paramCursor, localPatchedTextView, m, str1, (String)localObject2, str2, j, localTextView1, localHolder, localImageView1, (CharSequence)localObject2, localChatThumbView, localImageView3, localButton, localImageView2, l3);
              return;
            }
            catch (Exception paramView)
            {
              paramView.printStackTrace();
              a(localChatThumbView, null, localImageView2);
              return;
            }
          }
          if (m == -2039)
          {
            paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
            paramContext = new MessageForApollo();
            paramContext.msgData = paramView;
            paramContext.parse();
            localPatchedTextView.setVisibility(0);
            if (!TextUtils.isEmpty(paramContext.msg))
            {
              localPatchedTextView.setText(paramContext.msg);
              return;
            }
            localPatchedTextView.setText("[动作消息]");
            return;
          }
          if (m == -2010)
          {
            localChatThumbView.setVisibility(8);
            localPatchedTextView.setVisibility(0);
            localImageView1.setVisibility(8);
            localImageView3.setVisibility(8);
            localButton.setVisibility(8);
            localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
            localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
            if ((localObject2 == null) || (((String)localObject2).length() <= 0) || (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b(((String)localObject2).toString()))) {
              break label5579;
            }
            paramContext = localObject2.split("\026")[1].split("\\|");
            paramCursor = paramContext[0];
            if (paramContext.length >= 2) {
              break label5053;
            }
            i = 1;
            if (paramContext.length >= 5) {
              localObject4 = paramContext[4];
            }
            if (paramContext.length >= 6) {
              TransfileUtile.a(((String)localObject2).toString());
            }
            l2 = 0L;
            l1 = l2;
            if (paramContext != null)
            {
              l1 = l2;
              if (paramContext.length > 1) {
                if (paramContext[1] != null) {
                  break label5067;
                }
              }
            }
          }
          for (paramContext = "0";; paramContext = paramContext[1])
          {
            l1 = Long.parseLong(paramContext);
            Uri.parse(paramCursor);
            switch (i)
            {
            default: 
              return;
            case 0: 
              localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131435064));
              localPatchedTextView.setVisibility(0);
              localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
              localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
              return;
              if ((m == -2011) || (m == -2051) || (m == -7002) || (m == -2054))
              {
                paramCursor = StructMsgFactory.a(paramCursor.getBlob(paramCursor.getColumnIndex("msgData")));
                paramView = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a(paramCursor);
                if ((localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForStructing))
                {
                  paramContext = (MessageForStructing)localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
                  if (((paramContext.istroop == 1024) && (!QidianManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, paramContext.frienduin))) || (CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, paramContext.frienduin, paramContext.istroop)))
                  {
                    paramContext = paramView;
                    if (TextUtils.isEmpty(paramView))
                    {
                      paramContext = paramView;
                      if (paramCursor != null)
                      {
                        paramContext = paramView;
                        if ((paramCursor instanceof AbsShareMsg))
                        {
                          paramContext = ((AbsShareMsg)paramCursor).getStructMsgItemLists().iterator();
                          while (paramContext.hasNext())
                          {
                            paramCursor = (AbsStructMsgElement)paramContext.next();
                            if (!(paramCursor instanceof AbsStructMsgItem)) {
                              break label5858;
                            }
                            paramCursor = ((AbsStructMsgItem)paramCursor).a.iterator();
                            do
                            {
                              if (!paramCursor.hasNext()) {
                                break;
                              }
                              localObject2 = (AbsStructMsgElement)paramCursor.next();
                            } while (!(localObject2 instanceof StructMsgItemTitle));
                            paramView = ((StructMsgItemTitle)localObject2).b();
                          }
                          paramContext = paramView;
                        }
                      }
                    }
                    if (TextUtils.isEmpty(paramContext)) {
                      break label99;
                    }
                    paramView = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.getApp().getString(2131430765), new Object[] { "公众号" });
                    localPatchedTextView.setText(paramView + paramContext);
                    localPatchedTextView.setVisibility(0);
                    localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                    localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                    return;
                  }
                }
                if (TextUtils.isEmpty(paramView)) {
                  break label99;
                }
                paramContext = paramView;
                if (TroopBindPublicAccountMgr.a(localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
                {
                  paramContext = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.getApp().getString(2131430765), new Object[] { PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, BaseApplicationImpl.getContext()) });
                  paramContext = paramContext + paramView;
                }
                localPatchedTextView.setText(paramContext);
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                return;
              }
              if (m == -3006)
              {
                paramView = MessageForPubAccount.getMsgSummary(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, true);
                if (TextUtils.isEmpty(paramView)) {
                  break label99;
                }
                localPatchedTextView.setText(paramView);
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                return;
              }
              if (m == -5008)
              {
                paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramContext = new ArkAppMessage();
                paramContext.fromBytes(paramView);
                paramView = paramContext.promptText;
                if (TextUtils.isEmpty(paramView)) {
                  break label99;
                }
                localPatchedTextView.setText(paramView);
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                return;
              }
              if (m == -5017)
              {
                paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramContext = new ArkAppMessage();
                paramContext.fromBytes(paramView);
                paramView = paramContext.promptText;
                if (TextUtils.isEmpty(paramView)) {
                  break label99;
                }
                localPatchedTextView.setText(paramView);
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                return;
              }
              if (m == -5016)
              {
                paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramContext = new MessageForArkBabyqReply();
                paramContext.fromBytes(paramView);
                paramView = paramContext.babyqReplyText;
                if (TextUtils.isEmpty(paramView)) {
                  break label99;
                }
                localPatchedTextView.setText(paramView);
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                return;
              }
              if (m == -5013)
              {
                paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramContext = new ArkFlashChatMessage();
                paramContext.fromBytes(paramView);
                paramView = paramContext.promptText;
                if (TextUtils.isEmpty(paramView)) {
                  break label99;
                }
                localPatchedTextView.setText(paramView);
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                return;
              }
              if ((m == -2000) || (m == -20000) || (m == -3004) || (m == -3005) || (m == -3000) || (m == -3001) || (m == -5015))
              {
                if ((localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)))
                {
                  if (FlashPicHelper.a(localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
                  {
                    localPatchedTextView.setVisibility(0);
                    localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131435551));
                    localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                    localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                    return;
                  }
                  paramView = (MessageForPic)localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
                  paramView.parse();
                  paramContext = new ImageViewParameter();
                  localChatThumbView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                  localChatThumbView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                  paramContext.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramView;
                  paramContext.jdField_a_of_type_ComTencentImageURLImageView = localChatThumbView;
                  if (QLog.isColorLevel()) {
                    QLog.d("history", 2, "bindView pic.path:" + paramView.path + ",pic.uuid:" + paramView.uuid);
                  }
                  if ((paramContext.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null) || (paramContext.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.path == null)) {
                    break label99;
                  }
                  a(paramContext);
                  return;
                }
                if (!QLog.isColorLevel()) {
                  break label99;
                }
                QLog.d("history", 2, "holy shit,not messageforpicuniseq:" + localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ",dbid:" + localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getId() + "istroop:" + localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop + ",msgtype:" + localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype);
                return;
              }
              if (m == -2002)
              {
                localObject4 = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramContext = new RichMsg.PttRec();
                try
                {
                  paramContext.mergeFrom((byte[])localObject4);
                  i = 1;
                }
                catch (Exception localException3)
                {
                  for (;;)
                  {
                    i = 0;
                    localException3.printStackTrace();
                    continue;
                    bool = false;
                    continue;
                    j = 0;
                  }
                  localButton.setText(String.valueOf(j) + "\"");
                  localButton.setPadding(k, 0, a(j), 0);
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo == null) {
                    break label3635;
                  }
                }
                if (i == 0) {
                  break label1703;
                }
                i = paramContext.voiceLength.get();
                if ((localHolder == null) || (localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (!(localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPtt))) {
                  break label5855;
                }
                if (((MessageForPtt)localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).voiceChangeFlag == 1)
                {
                  bool = true;
                  localHolder.jdField_a_of_type_Boolean = bool;
                  if (i > 0) {
                    break label5855;
                  }
                  i = QQRecorder.a(localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
                  bool = localHolder.jdField_a_of_type_Boolean;
                  if (!paramContext.voiceType.has()) {
                    break label3527;
                  }
                  j = paramContext.voiceType.get();
                  paramCursor = MessageForPtt.getLocalFilePath(j, paramContext.localPath.get());
                  l1 = paramContext.size.get();
                  k = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.h;
                  j = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.i;
                  localButton.setTag(paramCursor + str1 + l3);
                  localButton.setVisibility(0);
                  localButton.setText("");
                  localButton.setText(null);
                  localButton.setCompoundDrawables(null, null, null, null);
                  localButton.setPadding(k, 0, j, 0);
                  localButton.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                  localButton.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                  j = i;
                  if (i <= 0) {
                    j = QQRecorder.a(paramCursor);
                  }
                  if ((paramCursor.startsWith(AppConstants.aJ)) && (j > 0)) {
                    break label3533;
                  }
                  localButton.setCompoundDrawables(null, null, null, null);
                  localButton.setText("[" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131434471) + "]");
                  localButton.setOnClickListener(null);
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.a(0, localButton.getTag()))
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.a(paramView, paramCursor);
                  localButton.setOnClickListener(new rwr(this, j, paramCursor));
                  return;
                }
                if (bool) {}
                for (paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845637);; paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845636))
                {
                  paramView.setBounds(0, 0, paramView.getMinimumWidth(), paramView.getMinimumHeight());
                  localButton.setCompoundDrawables(paramView, null, null, null);
                  if (l1 > 0L) {
                    break;
                  }
                  localButton.setText("[" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131434472) + "]");
                  break;
                }
              }
              if (m == -1035)
              {
                localMixedMsgLinearLayout.setVisibility(0);
                a(localMixedMsgLinearLayout, (MessageForMixedMsg)localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
                return;
              }
              if (m == -7001)
              {
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131439041));
                return;
              }
              if (m == -2017)
              {
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(MsgUtils.a(null));
                return;
              }
              if (m == -2020)
              {
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setOnClickListener(new rwt(this, str1));
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                if (MsgUtils.a(k))
                {
                  localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.getApp().getString(2131433331, new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString }));
                  return;
                }
                localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.getApp().getString(2131433330));
                return;
              }
              if (m == -3008)
              {
                localPatchedTextView.setText(BaseApplicationImpl.getContext().getString(2131428259) + "\"" + (String)localObject2 + "\"");
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                return;
              }
              if (m == -2022)
              {
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131437338));
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                return;
              }
              if (m == -5002)
              {
                if ((localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForIncompatibleGrayTips)))
                {
                  paramView = (MessageForIncompatibleGrayTips)localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
                  paramView.parse();
                  localPatchedTextView.setText(paramView.msg);
                  localPatchedTextView.setVisibility(0);
                  paramCursor = paramView.url;
                  paramContext = new SpannableString(paramView.msg);
                  paramCursor = new rwu(this, paramCursor, str1);
                  paramContext.setSpan(new ForegroundColorSpan(2131492876), paramView.linkStart, paramView.linkEnd, 33);
                  paramContext.setSpan(paramCursor, paramView.linkStart, paramView.linkEnd, 33);
                  localPatchedTextView.setText(paramContext);
                  localPatchedTextView.setMovementMethod(LinkMovementMethod.getInstance());
                  localPatchedTextView.setHighlightColor(17170445);
                  localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                  localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                  return;
                }
                if (!QLog.isColorLevel()) {
                  break label99;
                }
                QLog.d("history", 2, "holy shit,not MessageForIncompatibleGrayTipsuniseq:" + localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ",dbid:" + localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getId() + "istroop:" + localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop + ",msgtype:" + localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype);
                return;
              }
              if (m == -2025)
              {
                paramView = new MessageForQQWalletMsg();
                paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramView.parse();
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(paramView.getMsgSummary());
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                return;
              }
              if (m == -2036)
              {
                paramView = new MessageForTroopFee();
                paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramView.parse();
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(paramView.getSummaryMsg());
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                return;
              }
              if (m == -2035)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(".troop.send_gift", 2, "ChatHistory decode MessageForDeliverGiftTips. seq:" + localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq + "msgtype:" + localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype + "msg:" + localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg);
                }
                paramView = (MessageForDeliverGiftTips)localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
                localLinearLayout.setVisibility(8);
                localPatchedTextView.setVisibility(8);
                localTextView2.setVisibility(0);
                localTextView2.setClickable(true);
                localTextView2.setFocusable(true);
                localTextView2.setMovementMethod(LinkMovementMethod.getInstance());
                localTextView2.setVisibility(0);
                localTextView2.setText(paramView.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, this.jdField_a_of_type_AndroidContentContext));
                return;
              }
              if (m == -2038)
              {
                paramView = new MessageForTroopGift();
                paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramView.parse();
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(paramView.summary);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                return;
              }
              if (m == -2048)
              {
                paramView = new MessageForTroopReward();
                paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramView.parse();
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(paramView.getSummaryMsg());
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                return;
              }
              if (m == -2044)
              {
                paramView = (MessageForTroopTopic)localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
                paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramView.parse();
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(paramView.msg);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                return;
              }
              if (m == -5010)
              {
                paramView = (MessageForDingdongSchedule)localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
                paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramView.parse();
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(paramView.msg);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
                return;
              }
              if ((m != -2052) && (m != -2057) && (m != -2059)) {
                break label1703;
              }
              localPatchedTextView.setVisibility(0);
              localPatchedTextView.setText(((ChatMessage)localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).getSummaryMsg());
              localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
              localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
              return;
              i = Integer.valueOf(paramContext[2]).intValue();
              break label1761;
            }
          }
          localChatThumbView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
          localChatThumbView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
          return;
          k = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.h;
          i = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.i;
          localButton.setTag(paramCursor + str1 + l3);
          localButton.setVisibility(0);
          localButton.setText("");
          localButton.setText(null);
          localButton.setCompoundDrawables(null, null, null, null);
          localButton.setPadding(k, 0, i, 0);
          localButton.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
          localButton.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
          j = 0;
          i = j;
          if (localHolder != null)
          {
            i = j;
            if (localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
            {
              i = j;
              if ((localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPtt)) {
                i = QQRecorder.a(localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
              }
            }
          }
          j = i;
          if (i <= 0) {
            j = QQRecorder.a(paramCursor);
          }
          if ((!paramCursor.startsWith(AppConstants.aJ)) || (j <= 0))
          {
            localButton.setCompoundDrawables(null, null, null, null);
            localButton.setText("[" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131434471) + "]");
            localButton.setOnClickListener(null);
            return;
          }
          localButton.setText(String.valueOf(j) + "\"");
          localButton.setPadding(k, 0, a(j), 0);
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.a(0, localButton.getTag()))) {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.a(paramView, paramCursor);
          }
          for (;;)
          {
            localButton.setOnClickListener(new rwv(this, j, paramCursor));
            return;
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845636);
            paramView.setBounds(0, 0, paramView.getMinimumWidth(), paramView.getMinimumHeight());
            localButton.setCompoundDrawables(paramView, null, null, null);
            if (l1 <= 0L) {
              localButton.setText("[" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131434472) + "]");
            }
          }
          localChatThumbView.setVisibility(0);
          localChatThumbView.setOnClickListener(null);
          localChatThumbView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
          localChatThumbView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
          localChatThumbView.setImageResource(2130838338);
          return;
          i = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
          localPatchedTextView.setVisibility(0);
          if (!MessageUtils.a(m))
          {
            localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
            localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$HistoryItemOnlongClickListener);
          }
          if (!String.valueOf(AppConstants.F).equals(str1)) {
            break;
          }
          paramView = SystemMsg.decode(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, (String)localObject2, str2, i);
        } while (paramView == null);
        localPatchedTextView.setText(paramView.message);
      } while (j != 32769);
      localTextView1.setText(paramView.troopCode);
      return;
      if (-2008 == i)
      {
        localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131436145));
        return;
      }
      if (-1002 == i)
      {
        localPatchedTextView.setText(localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("sens_msg_original_text"));
        return;
      }
      int i = paramCursor.getInt(paramCursor.getColumnIndex("extraflag"));
      if ((localImageView1 != null) && (i == 32768)) {
        localImageView1.setVisibility(0);
      }
      paramView = (View)localObject2;
      if (LoveLanguageManager.a(localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
      {
        paramView = (View)localObject2;
        if (((LoveLanguageManager)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.getManager(273)).b()) {
          paramView = LoveLanguageManager.a((String)localObject2);
        }
      }
      localPatchedTextView.setText(new QQText(paramView, 13, 32, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Int));
      return;
    }
  }
  
  public void changeCursor(Cursor paramCursor)
  {
    if (paramCursor != null)
    {
      if (getCursor() != null) {
        getCursor().deactivate();
      }
      super.changeCursor(paramCursor);
      notifyDataSetChanged();
    }
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968783, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter
 * JD-Core Version:    0.7.0.1
 */