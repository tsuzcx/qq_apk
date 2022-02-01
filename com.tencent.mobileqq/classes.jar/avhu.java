import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForGrayTips.HighlightItem;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.StickerGrayTipLayout;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipItemBuilder.1;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class avhu
  extends afor
{
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray(5);
  private HashMap<Long, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private ConcurrentHashMap<Long, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  
  public avhu(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  public static void a(ChatMessage paramChatMessage, afos paramafos, View paramView)
  {
    if ((paramafos != null) && (paramView != null) && (paramChatMessage == null)) {}
  }
  
  private void a(String paramString, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if ((bfyd.a.contains(Long.valueOf(paramString))) && (!paramMessageForUniteGrayTip.troopLuckyCharacterTipsHasReport))
    {
      paramMessageForUniteGrayTip.troopLuckyCharacterTipsHasReport = true;
      int i = (int)(Long.valueOf(paramString).longValue() - 1069L);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "Grp_AIO_display", "Luckyword_tips_exp", 0, 0, "", "", "", "");
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "Grp_AIO_display", "Luckyword_tips_exp", i + 1, 0, "", "", "", "");
    }
  }
  
  private void b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "onDelBtnClick fail cause message is null");
      }
    }
    Object localObject;
    do
    {
      do
      {
        return;
      } while (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity));
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "revoke msg click handle del msg");
      }
      localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
    } while ((localObject == null) || (((ChatFragment)localObject).a() == null));
    for (;;)
    {
      try
      {
        if (!(paramChatMessage instanceof MessageForUniteGrayTip)) {
          continue;
        }
        localObject = (MessageForUniteGrayTip)paramChatMessage;
        if (((MessageForUniteGrayTip)localObject).istroop != 0) {
          continue;
        }
        if (!((MessageForUniteGrayTip)localObject).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          continue;
        }
        i = 1;
      }
      catch (RuntimeException localRuntimeException)
      {
        boolean bool1;
        boolean bool2;
        String str1;
        String str2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ChatItemBuilder", 1, "0X800A613", localRuntimeException);
        continue;
        int i = -1;
        continue;
        continue;
        i = 8;
        continue;
        i = 8;
        continue;
        i = 8;
        continue;
        i = 10;
        continue;
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A613", "0X800A613", 0, 0, i + "", "", "", "");
      admh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      i = 2;
      continue;
      if (((MessageForUniteGrayTip)localObject).istroop == 1)
      {
        bool1 = TroopUtils.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        bool2 = TroopUtils.isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        str1 = ((MessageForUniteGrayTip)localObject).tipParam.c;
        str2 = anvx.a(2131715261) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697450);
        if (bool1)
        {
          if (str1.startsWith(str2))
          {
            i = 3;
            continue;
          }
          if (!((MessageForUniteGrayTip)localObject).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
            continue;
          }
          i = 4;
          continue;
        }
        if (bool2)
        {
          if (str1.startsWith(str2))
          {
            i = 5;
            continue;
          }
          if (!((MessageForUniteGrayTip)localObject).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
            continue;
          }
          i = 6;
          continue;
        }
        if (!((MessageForUniteGrayTip)localObject).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          continue;
        }
        i = 7;
        continue;
      }
      if (((MessageForUniteGrayTip)localObject).istroop == 3000)
      {
        if (!((MessageForUniteGrayTip)localObject).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          continue;
        }
        i = 9;
      }
      else
      {
        bool1 = ((MessageForUniteGrayTip)localObject).tipParam.c.equals(anvx.a(2131715260) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694158));
        if (!bool1) {
          i = 11;
        } else {
          i = 12;
        }
      }
    }
  }
  
  private void b(MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    String str = paramMessageForUniteGrayTip.getExtInfoFromExtStr("uint64_busi_type");
    if (("1062".equals(paramMessageForUniteGrayTip.getExtInfoFromExtStr("uint64_busi_id"))) && ("12".equals(str)))
    {
      str = paramMessageForUniteGrayTip.getExtInfoFromExtStr("bytes_content");
      if (!TextUtils.isEmpty(str))
      {
        if (!str.contains("动作")) {
          break label116;
        }
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq)))
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq), Boolean.valueOf(true));
          bdla.b(null, "dc00898", "", "", "0X800B43D", "0X800B43D", 0, 0, "", "", "", "");
        }
      }
    }
    label116:
    while ((!str.contains("效果")) || (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq)))) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq), Boolean.valueOf(true));
    bdla.b(null, "dc00898", "", "", "0X800B43F", "0X800B43F", 0, 0, "", "", "", "");
  }
  
  protected afos a()
  {
    return new avhy(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    if (!(paramafos instanceof avhy)) {
      QLog.e("ChatItemBuilder", 1, "diffclashh =" + paramafos.getClass());
    }
    avhy localavhy = (avhy)paramafos;
    if (paramView == null)
    {
      paramafos = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558922, null);
      localavhy.b = ((TextView)paramafos.findViewById(2131367837));
      localavhy.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramafos.findViewById(2131376632));
      paramView = localavhy.b.getLayoutParams();
      localObject1 = paramafos;
      if ((paramView instanceof ViewGroup.MarginLayoutParams))
      {
        paramView = (ViewGroup.MarginLayoutParams)paramView;
        localObject1 = paramafos;
        if (paramView.rightMargin != BaseChatItemLayout.y) {
          paramView.rightMargin = BaseChatItemLayout.y;
        }
      }
    }
    for (Object localObject1 = paramafos;; localObject1 = paramView)
    {
      localavhy.b.setLineSpacing(0.0F, 1.0F);
      localavhy.b.setIncludeFontPadding(true);
      localavhy.b.setMovementMethod(null);
      localavhy.b.setTextColor(((View)localObject1).getResources().getColorStateList(2131167325));
      localavhy.b.setGravity(19);
      localavhy.b.setBackgroundResource(0);
      Object localObject2;
      int i1;
      awyr localawyr;
      List localList;
      int i;
      int j;
      int k;
      if ((localObject1 instanceof StickerGrayTipLayout))
      {
        bhhy.a(null, "AIO_Handle_Sticker_Cost");
        localObject2 = (StickerGrayTipLayout)localObject1;
        ((StickerGrayTipLayout)localObject2).removeAllStickers();
        paramafos = EmojiStickerManager.a().a(paramMessageRecord);
        i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
        if ((paramafos != null) && (paramafos.size() > 0))
        {
          localawyr = (awyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
          localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramafos);
          i = 0;
          j = 0;
          k = localList.size() - 1;
          if (k >= 0)
          {
            paramView = (MessageRecord)localList.get(k);
            if (paramView.extraflag != 32768) {}
          }
        }
      }
      for (;;)
      {
        k -= 1;
        break;
        EmojiStickerManager.StickerInfo localStickerInfo = EmojiStickerManager.a(paramView);
        if ((localStickerInfo != null) && (EmojiStickerManager.c(paramView)))
        {
          int m = i + 1;
          if (m > EmojiStickerManager.jdField_f_of_type_Int)
          {
            paramView.msgtype = -2006;
            i = m;
          }
          else
          {
            if ((paramView instanceof MessageForMarketFace)) {
              paramafos = localawyr.a(((MessageForMarketFace)paramView).mMarkFaceMessage);
            }
            for (;;)
            {
              label429:
              int i2 = (int)(localStickerInfo.x * i1);
              i = (int)(localStickerInfo.y * i1);
              int i3 = (int)(localStickerInfo.width * i1);
              int i4 = (int)(localStickerInfo.height * i1);
              int i5 = localStickerInfo.rotate;
              if (k == localList.size() - 1)
              {
                if (i >= 0) {
                  break label3002;
                }
                i = -i;
                j = 0;
              }
              for (;;)
              {
                label511:
                float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
                if ((paramafos instanceof PicEmoticonInfo))
                {
                  paramView = (PicEmoticonInfo)paramafos;
                  if (paramView.emoticon == null) {
                    break label2975;
                  }
                  if ((!EmojiStickerManager.jdField_f_of_type_Boolean) && (FileUtils.getAvailableInnernalMemorySize() > 1.048576E+008F))
                  {
                    n = 1;
                    label564:
                    if (n == 0) {
                      break label706;
                    }
                    paramafos = paramView.getLoadingDrawable("fromAIO", true, false, null, i3, i3);
                    label584:
                    paramView = paramView.emoticon.epId;
                  }
                }
                for (;;)
                {
                  if (paramafos != null) {
                    ((StickerGrayTipLayout)localObject2).addSticker(paramafos, i2, j, i3, i4, i5, paramView);
                  }
                  j = i;
                  i = m;
                  break;
                  if (!(paramView instanceof MessageForText)) {
                    break label3017;
                  }
                  paramafos = (MessageForText)paramView;
                  if (TextUtils.isEmpty(paramafos.msg)) {
                    break label3017;
                  }
                  paramafos = EmojiStickerManager.a().a(paramafos.msg);
                  break label429;
                  n = j + i;
                  if (n >= 0) {
                    break label2983;
                  }
                  n = -i;
                  i = -i;
                  ((StickerGrayTipLayout)localObject2).adjustStickersVerticalPosition(n - j);
                  j = 0;
                  break label511;
                  n = 0;
                  break label564;
                  label706:
                  paramafos = paramView.getDrawable(this.jdField_a_of_type_AndroidContentContext, f);
                  break label584;
                  if ((paramafos instanceof SystemAndEmojiEmoticonInfo))
                  {
                    paramafos = ((SystemAndEmojiEmoticonInfo)paramafos).getBigDrawable(this.jdField_a_of_type_AndroidContentContext, f);
                    paramView = "";
                  }
                  else if ((paramafos instanceof SmallEmoticonInfo))
                  {
                    paramafos = ((SmallEmoticonInfo)paramafos).getBigDrawable(this.jdField_a_of_type_AndroidContentContext, f);
                    paramView = "";
                  }
                  else
                  {
                    if ((paramView instanceof MessageForPic))
                    {
                      paramafos = ahcj.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)paramView);
                      ThreadManager.post(new UniteGrayTipItemBuilder.1(this, paramView), 5, null, true);
                      paramView = "";
                      continue;
                      ((StickerGrayTipLayout)localObject1).stickerDoubleClickListener = new avhv(this);
                      bhhy.a("AIO_Handle_Sticker_Cost", null);
                      if (!(paramMessageRecord instanceof MessageForUniteGrayTip))
                      {
                        localavhy.b.setText(paramMessageRecord.msg);
                        return localObject1;
                      }
                      paramView = (MessageForUniteGrayTip)paramMessageRecord;
                      if (!AIOUtils.isForbidHeadPendantFunForAIOOpen) {
                        avia.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                      }
                      if ((paramView.tipParam != null) && (paramView.tipParam.b == 655381))
                      {
                        paramafos = (MessageForGrayTips.HighlightItem)paramView.tipParam.a.get(paramView.tipParam.a.size() - 1);
                        if ((paramafos != null) && (paramafos.actionType == 38)) {
                          j = 0;
                        }
                      }
                      try
                      {
                        i = Integer.parseInt(paramafos.mMsgActionData);
                        if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i, true))
                        {
                          bdla.b(null, "dc00898", "", "", "0X8009979", "0X8009979", i, i, "", "", "", "");
                          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i, false);
                        }
                        if ((paramView.tipParam != null) && (paramView.tipParam.b == 655383))
                        {
                          j = 0;
                          if (paramView.tipParam.a != null) {
                            break label2580;
                          }
                          if (paramMessageRecord.istroop != 0) {
                            break label2572;
                          }
                          i = awtn.b;
                          label1046:
                          if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramView.uniseq)))
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d("ChatItemBuilder", 2, "Temp Report mark: grayTipsOnShow " + paramView.uniseq);
                            }
                            bdla.b(null, "dc00898", "", "", "0X8009ACF", "0X8009ACF", i, i, "", "", "", "");
                            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramView.uniseq), Boolean.valueOf(false));
                          }
                        }
                        if ((paramView.tipParam != null) && (paramView.tipParam.b == 655397))
                        {
                          avia.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
                          paramafos = paramView.getExtInfoFromExtStr("unite_gray_tips_align");
                          if ((!TextUtils.isEmpty(paramafos)) && (paramafos.equals("center"))) {
                            localavhy.b.setGravity(17);
                          }
                          localavhy.b.setLineSpacing(8.0F, 1.0F);
                          if ((!"null".equals(((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))) || ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isNowThemeIsNight(null, false, null)) && (!ThemeUtil.isNowThemeIsSimple(null, false, null))))
                          {
                            localavhy.b.setTextColor(((View)localObject1).getResources().getColorStateList(2131167226));
                            localavhy.b.setBackgroundResource(2130850811);
                          }
                          paramafos = paramView.getExtInfoFromExtStr("uint64_busi_id");
                          if (("1008".equals(paramafos)) && (!paramView.docTipHasReport))
                          {
                            paramView.docTipHasReport = true;
                            bdla.b(null, "dc00898", "", "", "0X800A638", "0X800A638", paramView.istroop, 0, "", "", "", "");
                          }
                          if ((Long.valueOf(paramafos).equals(Long.valueOf(1021L))) && (!paramView.dkTipHasReport))
                          {
                            paramView.dkTipHasReport = true;
                            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD82", "0X800AD82", 0, 0, "", "", "", "");
                          }
                          if ((Long.valueOf(paramafos).equals(Long.valueOf(1038L))) && (!paramView.troopMemberLevelTipHasReport))
                          {
                            paramView.troopMemberLevelTipHasReport = true;
                            localObject2 = paramView.getExtInfoFromExtStr("uint64_templ_id");
                            if (!TextUtils.isEmpty((CharSequence)localObject2))
                            {
                              if (!Long.valueOf((String)localObject2).equals(Long.valueOf(1111L))) {
                                break label2687;
                              }
                              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B1A2", "0X800B1A2", 0, 0, "", "", "", "");
                            }
                          }
                          label1512:
                          a(paramafos, paramView);
                          l1 = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("uint64_busi_type"));
                          l2 = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("uint64_busi_id"));
                          if ((l1 == 2L) && (l2 == 1024L) && (paramView.tipParam.a != null))
                          {
                            paramafos = (MessageForGrayTips.HighlightItem)paramView.tipParam.a.get(0);
                            if (paramafos != null) {
                              paramafos.actionType = 55;
                            }
                          }
                        }
                        if ((((MessageForUniteGrayTip)paramMessageRecord).editState == 1) && ((paramView.tipParam == null) || ((paramView.tipParam != null) && (paramView.tipParam.a == null))) && (QLog.isColorLevel()))
                        {
                          localObject2 = paramView.tipParam;
                          if (paramView.tipParam != null)
                          {
                            paramafos = paramView.tipParam.a;
                            label1655:
                            QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder edit param error grayMsg.tipParam = ", localObject2, " highlightItems=", paramafos });
                          }
                        }
                        else if ((paramView.tipParam != null) && (paramView.tipParam.b == 2))
                        {
                          localavhy.b.setGravity(17);
                        }
                      }
                      catch (NumberFormatException localNumberFormatException1)
                      {
                        try
                        {
                          long l1;
                          long l2;
                          if ((paramView.tipParam != null) && (paramView.tipParam.b == 1))
                          {
                            paramafos = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849584);
                            localavhy.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setImageDrawable(paramafos);
                            localavhy.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691445));
                            localavhy.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(0);
                            localavhy.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(new avhw(this, localavhy));
                            localavhy.b.setMaxWidth(ViewUtils.getScreenWidth() - ViewUtils.dpToPx(31.0F));
                            ((ViewGroup.MarginLayoutParams)localavhy.b.getLayoutParams()).rightMargin = 0;
                          }
                          for (;;)
                          {
                            for (;;)
                            {
                              if ((paramView.tipParam == null) || (paramView.tipParam.a == null)) {
                                break label2865;
                              }
                              l1 = paramView.uniseq;
                              l2 = localavhy.jdField_a_of_type_Int;
                              if (QLog.isColorLevel()) {
                                QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder msg uinseq=", Long.valueOf(l1), ",holder.mPosition=", Long.valueOf(l2) });
                              }
                              paramafos = paramView.tipParam.a;
                              boolean bool2 = false;
                              if ((paramView.tipParam.b == 2097155) || (paramView.tipParam.b == 2097153) || (paramView.tipParam.b == 2097154) || (paramView.tipParam.b == 655397))
                              {
                                boolean bool1 = true;
                                if ((afzb.a(paramView)) || (bfyd.a(paramView))) {
                                  bool1 = false;
                                }
                                bool2 = bool1;
                                if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramView.uniseq)))
                                {
                                  localObject2 = paramMessageRecord.getExtInfoFromExtStr("friendIconType");
                                  if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((((String)localObject2).equals("3")) || (((String)localObject2).equals("6"))))
                                  {
                                    if (!((String)localObject2).equals("3")) {
                                      break label2832;
                                    }
                                    LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "8", "1"));
                                    awpu.a("6", "1", "1", LpReportInfo_dc03950.getReportUserType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
                                  }
                                  this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramView.uniseq), Boolean.valueOf(false));
                                  bool2 = bool1;
                                }
                              }
                              paramLinearLayout = paramView.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), bool2, localavhy.b);
                              localavhy.b.setText(paramLinearLayout);
                              localavhy.b.setClickable(true);
                              localavhy.b.setFocusable(true);
                              localavhy.b.setMovementMethod(bimo.a());
                              if (AppSetting.c) {
                                localavhy.b.setAccessibilityDelegate(new avhx(this, l1, l2, paramafos, paramLinearLayout));
                              }
                              localavhy.b.setOnTouchListener(paramaftk);
                              localavhy.b.setOnLongClickListener(paramaftk);
                              if (!TextUtils.isEmpty(paramView.contentDescription)) {
                                localavhy.b.setContentDescription(paramView.contentDescription);
                              }
                              paramLinearLayout = localavhy.b.getLayoutParams();
                              if ((paramView == null) || (paramView.tipParam == null) || (paramView.tipParam.b != 3276801)) {
                                break label2907;
                              }
                              paramaftk = this.jdField_a_of_type_AndroidContentContext.getResources();
                              if (Build.VERSION.SDK_INT < 21) {
                                break label2895;
                              }
                              paramafos = paramaftk.getDrawable(2130850582, this.jdField_a_of_type_AndroidContentContext.getTheme());
                              if (paramafos != null) {
                                paramafos.setBounds(0, 0, paramafos.getIntrinsicWidth(), paramafos.getIntrinsicHeight());
                              }
                              localavhy.b.setCompoundDrawables(paramafos, null, null, null);
                              localavhy.b.setCompoundDrawablePadding(AIOUtils.dp2px(8.0F, paramaftk));
                              if ((paramLinearLayout instanceof LinearLayout.LayoutParams)) {
                                ((LinearLayout.LayoutParams)paramLinearLayout).gravity = 16;
                              }
                              if ((localObject1 instanceof StickerGrayTipLayout)) {
                                ((StickerGrayTipLayout)localObject1).setGravity(16);
                              }
                              if (AudioHelper.e()) {
                                QLog.w("ChatItemBuilder", 1, "TencentDocGrayTips, msg[" + paramView.msg + "], getText[" + localavhy.b.getText() + "], getLayoutParams[" + ((LinearLayout.LayoutParams)localavhy.b.getLayoutParams()).gravity + "], gravity[" + ((LinearLayout.LayoutParams)paramLinearLayout).gravity + "]");
                              }
                              a(paramView);
                              a((ChatMessage)paramMessageRecord, localavhy, (View)localObject1);
                              return localObject1;
                              localNumberFormatException1 = localNumberFormatException1;
                              i = j;
                              if (!QLog.isColorLevel()) {
                                break;
                              }
                              QLog.d("ChatItemBuilder", 2, "NumberFormatException: " + paramafos.mMsgActionData);
                              i = j;
                              break;
                              label2572:
                              i = awtn.c;
                              break label1046;
                              label2580:
                              paramafos = (MessageForGrayTips.HighlightItem)paramView.tipParam.a.get(paramView.tipParam.a.size() - 1);
                              i = j;
                              if (paramafos == null) {
                                break label1046;
                              }
                              i = j;
                              if (paramafos.actionType != 38) {
                                break label1046;
                              }
                              try
                              {
                                i = Integer.parseInt(paramafos.mMsgActionData);
                              }
                              catch (NumberFormatException localNumberFormatException2)
                              {
                                i = j;
                              }
                            }
                            if (!QLog.isColorLevel()) {
                              break label1046;
                            }
                            QLog.d("ChatItemBuilder", 2, "NumberFormatException: " + paramafos.mMsgActionData);
                            i = j;
                            break label1046;
                            label2687:
                            if (!Long.valueOf(localNumberFormatException2).equals(Long.valueOf(1112L))) {
                              break label1512;
                            }
                            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B1A4", "0X800AD82", 0, 0, "", "", "", "");
                            break label1512;
                            paramafos = null;
                            break label1655;
                            localavhy.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
                            paramafos = localavhy.b.getLayoutParams();
                            if ((paramafos instanceof ViewGroup.MarginLayoutParams))
                            {
                              paramafos = (ViewGroup.MarginLayoutParams)paramafos;
                              if (paramafos.rightMargin != BaseChatItemLayout.y) {
                                paramafos.rightMargin = BaseChatItemLayout.y;
                              }
                            }
                            localavhy.b.setMaxWidth(2147483647);
                            localavhy.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(null);
                          }
                        }
                        catch (RuntimeException paramafos)
                        {
                          for (;;)
                          {
                            if (QLog.isColorLevel())
                            {
                              QLog.d("ChatItemBuilder", 2, "deal revoke tips fail", paramafos);
                              continue;
                              label2832:
                              if (localNumberFormatException2.equals("6"))
                              {
                                LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "7", "1"));
                                continue;
                                label2865:
                                localavhy.b.setText(paramView.msg);
                                if (AppSetting.c)
                                {
                                  localavhy.b.setAccessibilityDelegate(null);
                                  continue;
                                  label2895:
                                  paramafos = paramaftk.getDrawable(2130850582);
                                  continue;
                                  label2907:
                                  localavhy.b.setCompoundDrawables(null, null, null, null);
                                  localavhy.b.setCompoundDrawablePadding(0);
                                  if ((paramLinearLayout instanceof LinearLayout.LayoutParams)) {
                                    ((LinearLayout.LayoutParams)paramLinearLayout).gravity = 17;
                                  }
                                  if ((localObject1 instanceof StickerGrayTipLayout)) {
                                    ((StickerGrayTipLayout)localObject1).setGravity(17);
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                    paramView = "";
                    paramafos = null;
                    continue;
                    label2975:
                    paramView = "";
                    paramafos = null;
                  }
                }
                label2983:
                i = n;
                int n = j;
                j = i;
                i = n;
                continue;
                label3002:
                n = j;
                j = i;
                i = n;
              }
              label3017:
              paramafos = null;
            }
          }
        }
      }
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    super.a(paramView, paramChatMessage, paramInt);
    if ((paramInt == 0) && ((paramChatMessage instanceof MessageForUniteGrayTip)))
    {
      MessageForUniteGrayTip localMessageForUniteGrayTip = (MessageForUniteGrayTip)paramChatMessage;
      paramView = (avhy)paramView.getTag();
      if (paramView != null)
      {
        paramView.b.setText(paramChatMessage.msg);
        if (!TextUtils.isEmpty(localMessageForUniteGrayTip.contentDescription)) {
          paramView.b.setContentDescription(localMessageForUniteGrayTip.contentDescription);
        }
      }
    }
  }
  
  protected void a(MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if ((paramMessageForUniteGrayTip != null) && (paramMessageForUniteGrayTip.tipParam != null)) {
      switch (paramMessageForUniteGrayTip.tipParam.b)
      {
      }
    }
    for (;;)
    {
      b(paramMessageForUniteGrayTip);
      return;
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMessageForUniteGrayTip.msgseq)))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMessageForUniteGrayTip.msgseq), Boolean.valueOf(true));
        TroopUtils.reportTroopRecommendGrayTipsExpose(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForUniteGrayTip);
        continue;
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq)))
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq), Boolean.valueOf(true));
          avhp.b(paramMessageForUniteGrayTip.istroop);
        }
      }
    }
  }
  
  public bhjs[] a(View paramView)
  {
    return new bhjq().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avhu
 * JD-Core Version:    0.7.0.1
 */