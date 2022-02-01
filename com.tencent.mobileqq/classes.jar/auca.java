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
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class auca
  extends aexf
{
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray(5);
  private HashMap<Long, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private ConcurrentHashMap<Long, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  
  public auca(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  public static void a(ChatMessage paramChatMessage, aexg paramaexg, View paramView)
  {
    if ((paramaexg != null) && (paramView != null) && (paramChatMessage == null)) {}
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
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A613", "0X800A613", 0, 0, i + "", "", "", "");
      acvv.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      i = 2;
      continue;
      if (((MessageForUniteGrayTip)localObject).istroop == 1)
      {
        bool1 = TroopUtils.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        bool2 = TroopUtils.isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        str1 = ((MessageForUniteGrayTip)localObject).tipParam.c;
        str2 = amtj.a(2131714913) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697173);
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
        bool1 = ((MessageForUniteGrayTip)localObject).tipParam.c.equals(amtj.a(2131714912) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693967));
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
          break label114;
        }
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq)))
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq), Boolean.valueOf(true));
          bcef.b(null, "dc00898", "", "", "0X800B43D", "0X800B43D", 0, 0, "", "", "", "");
        }
      }
    }
    label114:
    while ((!str.contains("效果")) || (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq)))) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq), Boolean.valueOf(true));
    bcef.b(null, "dc00898", "", "", "0X800B43F", "0X800B43F", 0, 0, "", "", "", "");
  }
  
  protected aexg a()
  {
    return new auce(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aexg paramaexg, View paramView, LinearLayout paramLinearLayout, afce paramafce)
  {
    if (!(paramaexg instanceof auce)) {
      QLog.e("ChatItemBuilder", 1, "diffclashh =" + paramaexg.getClass());
    }
    auce localauce = (auce)paramaexg;
    if (paramView == null)
    {
      paramaexg = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558895, null);
      localauce.b = ((TextView)paramaexg.findViewById(2131367701));
      localauce.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramaexg.findViewById(2131376377));
      paramView = localauce.b.getLayoutParams();
      localObject1 = paramaexg;
      if ((paramView instanceof ViewGroup.MarginLayoutParams))
      {
        paramView = (ViewGroup.MarginLayoutParams)paramView;
        localObject1 = paramaexg;
        if (paramView.rightMargin != BaseChatItemLayout.y) {
          paramView.rightMargin = BaseChatItemLayout.y;
        }
      }
    }
    for (Object localObject1 = paramaexg;; localObject1 = paramView)
    {
      localauce.b.setLineSpacing(0.0F, 1.0F);
      localauce.b.setIncludeFontPadding(true);
      localauce.b.setMovementMethod(null);
      localauce.b.setTextColor(((View)localObject1).getResources().getColorStateList(2131167305));
      localauce.b.setGravity(19);
      localauce.b.setBackgroundResource(0);
      Object localObject2;
      int i1;
      avsq localavsq;
      List localList;
      int i;
      int j;
      int k;
      if ((localObject1 instanceof StickerGrayTipLayout))
      {
        bfzg.a(null, "AIO_Handle_Sticker_Cost");
        localObject2 = (StickerGrayTipLayout)localObject1;
        ((StickerGrayTipLayout)localObject2).removeAllStickers();
        paramaexg = EmojiStickerManager.a().a(paramMessageRecord);
        i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
        if ((paramaexg != null) && (paramaexg.size() > 0))
        {
          localavsq = (avsq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
          localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramaexg);
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
              paramaexg = localavsq.a(((MessageForMarketFace)paramView).mMarkFaceMessage);
            }
            for (;;)
            {
              label427:
              int i2 = (int)(localStickerInfo.x * i1);
              i = (int)(localStickerInfo.y * i1);
              int i3 = (int)(localStickerInfo.width * i1);
              int i4 = (int)(localStickerInfo.height * i1);
              int i5 = localStickerInfo.rotate;
              if (k == localList.size() - 1)
              {
                if (i >= 0) {
                  break label2982;
                }
                i = -i;
                j = 0;
              }
              for (;;)
              {
                label509:
                float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
                if ((paramaexg instanceof PicEmoticonInfo))
                {
                  paramView = (PicEmoticonInfo)paramaexg;
                  if (paramView.emoticon == null) {
                    break label2955;
                  }
                  if ((!EmojiStickerManager.jdField_f_of_type_Boolean) && (FileUtils.getAvailableInnernalMemorySize() > 1.048576E+008F))
                  {
                    n = 1;
                    label562:
                    if (n == 0) {
                      break label704;
                    }
                    paramaexg = paramView.getLoadingDrawable("fromAIO", true, false, null, i3, i3);
                    label582:
                    paramView = paramView.emoticon.epId;
                  }
                }
                for (;;)
                {
                  if (paramaexg != null) {
                    ((StickerGrayTipLayout)localObject2).addSticker(paramaexg, i2, j, i3, i4, i5, paramView);
                  }
                  j = i;
                  i = m;
                  break;
                  if (!(paramView instanceof MessageForText)) {
                    break label2997;
                  }
                  paramaexg = (MessageForText)paramView;
                  if (TextUtils.isEmpty(paramaexg.msg)) {
                    break label2997;
                  }
                  paramaexg = EmojiStickerManager.a().a(paramaexg.msg);
                  break label427;
                  n = j + i;
                  if (n >= 0) {
                    break label2963;
                  }
                  n = -i;
                  i = -i;
                  ((StickerGrayTipLayout)localObject2).adjustStickersVerticalPosition(n - j);
                  j = 0;
                  break label509;
                  n = 0;
                  break label562;
                  label704:
                  paramaexg = paramView.getDrawable(this.jdField_a_of_type_AndroidContentContext, f);
                  break label582;
                  if ((paramaexg instanceof SystemAndEmojiEmoticonInfo))
                  {
                    paramaexg = ((SystemAndEmojiEmoticonInfo)paramaexg).getBigDrawable(this.jdField_a_of_type_AndroidContentContext, f);
                    paramView = "";
                  }
                  else if ((paramaexg instanceof SmallEmoticonInfo))
                  {
                    paramaexg = ((SmallEmoticonInfo)paramaexg).getBigDrawable(this.jdField_a_of_type_AndroidContentContext, f);
                    paramView = "";
                  }
                  else
                  {
                    if ((paramView instanceof MessageForPic))
                    {
                      paramaexg = agjt.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)paramView);
                      ThreadManager.post(new UniteGrayTipItemBuilder.1(this, paramView), 5, null, true);
                      paramView = "";
                      continue;
                      ((StickerGrayTipLayout)localObject1).stickerDoubleClickListener = new aucb(this);
                      bfzg.a("AIO_Handle_Sticker_Cost", null);
                      if (!(paramMessageRecord instanceof MessageForUniteGrayTip))
                      {
                        localauce.b.setText(paramMessageRecord.msg);
                        return localObject1;
                      }
                      paramView = (MessageForUniteGrayTip)paramMessageRecord;
                      if (!AIOUtils.isForbidHeadPendantFunForAIOOpen) {
                        aucg.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                      }
                      if ((paramView.tipParam != null) && (paramView.tipParam.b == 655381))
                      {
                        paramaexg = (MessageForGrayTips.HighlightItem)paramView.tipParam.a.get(paramView.tipParam.a.size() - 1);
                        if ((paramaexg != null) && (paramaexg.actionType == 38)) {
                          j = 0;
                        }
                      }
                      try
                      {
                        i = Integer.parseInt(paramaexg.mMsgActionData);
                        if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i, true))
                        {
                          bcef.b(null, "dc00898", "", "", "0X8009979", "0X8009979", i, i, "", "", "", "");
                          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i, false);
                        }
                        if ((paramView.tipParam != null) && (paramView.tipParam.b == 655383))
                        {
                          j = 0;
                          if (paramView.tipParam.a != null) {
                            break label2561;
                          }
                          if (paramMessageRecord.istroop != 0) {
                            break label2553;
                          }
                          i = avni.b;
                          label1044:
                          if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramView.uniseq)))
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d("ChatItemBuilder", 2, "Temp Report mark: grayTipsOnShow " + paramView.uniseq);
                            }
                            bcef.b(null, "dc00898", "", "", "0X8009ACF", "0X8009ACF", i, i, "", "", "", "");
                            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramView.uniseq), Boolean.valueOf(false));
                          }
                        }
                        if ((paramView.tipParam != null) && (paramView.tipParam.b == 655397))
                        {
                          aucg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
                          paramaexg = paramView.getExtInfoFromExtStr("unite_gray_tips_align");
                          if ((!TextUtils.isEmpty(paramaexg)) && (paramaexg.equals("center"))) {
                            localauce.b.setGravity(17);
                          }
                          localauce.b.setLineSpacing(8.0F, 1.0F);
                          if ((!"null".equals(((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))) || ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isNowThemeIsNight(null, false, null)) && (!ThemeUtil.isNowThemeIsSimple(null, false, null))))
                          {
                            localauce.b.setTextColor(((View)localObject1).getResources().getColorStateList(2131167212));
                            localauce.b.setBackgroundResource(2130850675);
                          }
                          paramaexg = paramView.getExtInfoFromExtStr("uint64_busi_id");
                          if (("1008".equals(paramaexg)) && (!paramView.docTipHasReport))
                          {
                            paramView.docTipHasReport = true;
                            bcef.b(null, "dc00898", "", "", "0X800A638", "0X800A638", paramView.istroop, 0, "", "", "", "");
                          }
                          if ((Long.valueOf(paramaexg).equals(Long.valueOf(1021L))) && (!paramView.dkTipHasReport))
                          {
                            paramView.dkTipHasReport = true;
                            bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD82", "0X800AD82", 0, 0, "", "", "", "");
                          }
                          if ((Long.valueOf(paramaexg).equals(Long.valueOf(1038L))) && (!paramView.troopMemberLevelTipHasReport))
                          {
                            paramView.troopMemberLevelTipHasReport = true;
                            paramaexg = paramView.getExtInfoFromExtStr("uint64_templ_id");
                            if (!TextUtils.isEmpty(paramaexg))
                            {
                              if (!Long.valueOf(paramaexg).equals(Long.valueOf(1111L))) {
                                break label2668;
                              }
                              bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B1A2", "0X800B1A2", 0, 0, "", "", "", "");
                            }
                          }
                          label1506:
                          l1 = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("uint64_busi_type"));
                          l2 = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("uint64_busi_id"));
                          if ((l1 == 2L) && (l2 == 1024L) && (paramView.tipParam.a != null))
                          {
                            paramaexg = (MessageForGrayTips.HighlightItem)paramView.tipParam.a.get(0);
                            if (paramaexg != null) {
                              paramaexg.actionType = 55;
                            }
                          }
                        }
                        if ((((MessageForUniteGrayTip)paramMessageRecord).editState == 1) && ((paramView.tipParam == null) || ((paramView.tipParam != null) && (paramView.tipParam.a == null))) && (QLog.isColorLevel()))
                        {
                          localObject2 = paramView.tipParam;
                          if (paramView.tipParam != null)
                          {
                            paramaexg = paramView.tipParam.a;
                            label1643:
                            QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder edit param error grayMsg.tipParam = ", localObject2, " highlightItems=", paramaexg });
                          }
                        }
                        else if ((paramView.tipParam != null) && (paramView.tipParam.b == 2))
                        {
                          localauce.b.setGravity(17);
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
                            paramaexg = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849491);
                            localauce.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setImageDrawable(paramaexg);
                            localauce.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691360));
                            localauce.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(0);
                            localauce.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(new aucc(this, localauce));
                            localauce.b.setMaxWidth(ViewUtils.getScreenWidth() - ViewUtils.dpToPx(31.0F));
                            ((ViewGroup.MarginLayoutParams)localauce.b.getLayoutParams()).rightMargin = 0;
                          }
                          for (;;)
                          {
                            for (;;)
                            {
                              if ((paramView.tipParam == null) || (paramView.tipParam.a == null)) {
                                break label2845;
                              }
                              l1 = paramView.uniseq;
                              l2 = localauce.jdField_a_of_type_Int;
                              if (QLog.isColorLevel()) {
                                QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder msg uinseq=", Long.valueOf(l1), ",holder.mPosition=", Long.valueOf(l2) });
                              }
                              paramaexg = paramView.tipParam.a;
                              boolean bool2 = false;
                              if ((paramView.tipParam.b == 2097155) || (paramView.tipParam.b == 2097153) || (paramView.tipParam.b == 2097154) || (paramView.tipParam.b == 655397))
                              {
                                boolean bool1 = true;
                                if (afhw.a(paramView)) {
                                  bool1 = false;
                                }
                                bool2 = bool1;
                                if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramView.uniseq)))
                                {
                                  localObject2 = paramMessageRecord.getExtInfoFromExtStr("friendIconType");
                                  if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((((String)localObject2).equals("3")) || (((String)localObject2).equals("6"))))
                                  {
                                    if (!((String)localObject2).equals("3")) {
                                      break label2812;
                                    }
                                    LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "8", "1"));
                                    avjp.a("6", "1", "1", LpReportInfo_dc03950.getReportUserType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
                                  }
                                  this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramView.uniseq), Boolean.valueOf(false));
                                  bool2 = bool1;
                                }
                              }
                              paramLinearLayout = paramView.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), bool2, localauce.b);
                              localauce.b.setText(paramLinearLayout);
                              localauce.b.setClickable(true);
                              localauce.b.setFocusable(true);
                              localauce.b.setMovementMethod(bhbw.a());
                              if (AppSetting.c) {
                                localauce.b.setAccessibilityDelegate(new aucd(this, l1, l2, paramaexg, paramLinearLayout));
                              }
                              localauce.b.setOnTouchListener(paramafce);
                              localauce.b.setOnLongClickListener(paramafce);
                              if (!TextUtils.isEmpty(paramView.contentDescription)) {
                                localauce.b.setContentDescription(paramView.contentDescription);
                              }
                              paramLinearLayout = localauce.b.getLayoutParams();
                              if ((paramView == null) || (paramView.tipParam == null) || (paramView.tipParam.b != 3276801)) {
                                break label2887;
                              }
                              paramafce = this.jdField_a_of_type_AndroidContentContext.getResources();
                              if (Build.VERSION.SDK_INT < 21) {
                                break label2875;
                              }
                              paramaexg = paramafce.getDrawable(2130850475, this.jdField_a_of_type_AndroidContentContext.getTheme());
                              if (paramaexg != null) {
                                paramaexg.setBounds(0, 0, paramaexg.getIntrinsicWidth(), paramaexg.getIntrinsicHeight());
                              }
                              localauce.b.setCompoundDrawables(paramaexg, null, null, null);
                              localauce.b.setCompoundDrawablePadding(AIOUtils.dp2px(8.0F, paramafce));
                              if ((paramLinearLayout instanceof LinearLayout.LayoutParams)) {
                                ((LinearLayout.LayoutParams)paramLinearLayout).gravity = 16;
                              }
                              if ((localObject1 instanceof StickerGrayTipLayout)) {
                                ((StickerGrayTipLayout)localObject1).setGravity(16);
                              }
                              if (AudioHelper.e()) {
                                QLog.w("ChatItemBuilder", 1, "TencentDocGrayTips, msg[" + paramView.msg + "], getText[" + localauce.b.getText() + "], getLayoutParams[" + ((LinearLayout.LayoutParams)localauce.b.getLayoutParams()).gravity + "], gravity[" + ((LinearLayout.LayoutParams)paramLinearLayout).gravity + "]");
                              }
                              a(paramView);
                              a((ChatMessage)paramMessageRecord, localauce, (View)localObject1);
                              return localObject1;
                              localNumberFormatException1 = localNumberFormatException1;
                              i = j;
                              if (!QLog.isColorLevel()) {
                                break;
                              }
                              QLog.d("ChatItemBuilder", 2, "NumberFormatException: " + paramaexg.mMsgActionData);
                              i = j;
                              break;
                              label2553:
                              i = avni.c;
                              break label1044;
                              label2561:
                              paramaexg = (MessageForGrayTips.HighlightItem)paramView.tipParam.a.get(paramView.tipParam.a.size() - 1);
                              i = j;
                              if (paramaexg == null) {
                                break label1044;
                              }
                              i = j;
                              if (paramaexg.actionType != 38) {
                                break label1044;
                              }
                              try
                              {
                                i = Integer.parseInt(paramaexg.mMsgActionData);
                              }
                              catch (NumberFormatException localNumberFormatException2)
                              {
                                i = j;
                              }
                            }
                            if (!QLog.isColorLevel()) {
                              break label1044;
                            }
                            QLog.d("ChatItemBuilder", 2, "NumberFormatException: " + paramaexg.mMsgActionData);
                            i = j;
                            break label1044;
                            label2668:
                            if (!Long.valueOf(paramaexg).equals(Long.valueOf(1112L))) {
                              break label1506;
                            }
                            bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B1A4", "0X800AD82", 0, 0, "", "", "", "");
                            break label1506;
                            paramaexg = null;
                            break label1643;
                            localauce.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
                            paramaexg = localauce.b.getLayoutParams();
                            if ((paramaexg instanceof ViewGroup.MarginLayoutParams))
                            {
                              paramaexg = (ViewGroup.MarginLayoutParams)paramaexg;
                              if (paramaexg.rightMargin != BaseChatItemLayout.y) {
                                paramaexg.rightMargin = BaseChatItemLayout.y;
                              }
                            }
                            localauce.b.setMaxWidth(2147483647);
                            localauce.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(null);
                          }
                        }
                        catch (RuntimeException paramaexg)
                        {
                          for (;;)
                          {
                            label2845:
                            label2875:
                            label2887:
                            if (QLog.isColorLevel())
                            {
                              QLog.d("ChatItemBuilder", 2, "deal revoke tips fail", paramaexg);
                              continue;
                              label2812:
                              if (localNumberFormatException2.equals("6"))
                              {
                                LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "7", "1"));
                                continue;
                                localauce.b.setText(paramView.msg);
                                if (AppSetting.c)
                                {
                                  localauce.b.setAccessibilityDelegate(null);
                                  continue;
                                  paramaexg = paramafce.getDrawable(2130850475);
                                  continue;
                                  localauce.b.setCompoundDrawables(null, null, null, null);
                                  localauce.b.setCompoundDrawablePadding(0);
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
                    paramaexg = null;
                    continue;
                    label2955:
                    paramView = "";
                    paramaexg = null;
                  }
                }
                label2963:
                i = n;
                int n = j;
                j = i;
                i = n;
                continue;
                label2982:
                n = j;
                j = i;
                i = n;
              }
              label2997:
              paramaexg = null;
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
      paramView = (auce)paramView.getTag();
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
          aubv.b(paramMessageForUniteGrayTip.istroop);
        }
      }
    }
  }
  
  public bgbb[] a(View paramView)
  {
    return new bgaz().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auca
 * JD-Core Version:    0.7.0.1
 */