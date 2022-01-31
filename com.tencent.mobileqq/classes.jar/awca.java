import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awca
  extends awch
{
  public awca()
  {
    this.a = 88;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawbv = (ExtensionInfo)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawbv.pendantId = paramCursor.getLong(paramCursor.getColumnIndex("pendantId"));
      paramawbv.pendantDiyId = paramCursor.getInt(paramCursor.getColumnIndex("pendantDiyId"));
      paramawbv.uVipFont = paramCursor.getLong(paramCursor.getColumnIndex("uVipFont"));
      paramawbv.vipFontType = paramCursor.getInt(paramCursor.getColumnIndex("vipFontType"));
      paramawbv.magicFont = paramCursor.getInt(paramCursor.getColumnIndex("magicFont"));
      paramawbv.lastUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("lastUpdateTime"));
      paramawbv.fontEffect = paramCursor.getInt(paramCursor.getColumnIndex("fontEffect"));
      paramawbv.fontEffectLastUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("fontEffectLastUpdateTime"));
      paramawbv.faceId = paramCursor.getInt(paramCursor.getColumnIndex("faceId"));
      paramawbv.faceIdUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("faceIdUpdateTime"));
      paramawbv.colorRingId = paramCursor.getLong(paramCursor.getColumnIndex("colorRingId"));
      paramawbv.commingRingId = paramCursor.getLong(paramCursor.getColumnIndex("commingRingId"));
      paramawbv.timestamp = paramCursor.getLong(paramCursor.getColumnIndex("timestamp"));
      paramawbv.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
      paramawbv.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
      paramawbv.feedType = paramCursor.getInt(paramCursor.getColumnIndex("feedType"));
      paramawbv.feedTime = paramCursor.getLong(paramCursor.getColumnIndex("feedTime"));
      paramawbv.feedContent = paramCursor.getString(paramCursor.getColumnIndex("feedContent"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("feedHasPhoto")))
      {
        paramBoolean = true;
        paramawbv.feedHasPhoto = paramBoolean;
        paramawbv.feedPhotoUrl = paramCursor.getString(paramCursor.getColumnIndex("feedPhotoUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isAdded2C2C"))) {
          break label1742;
        }
        paramBoolean = true;
        label421:
        paramawbv.isAdded2C2C = paramBoolean;
        paramawbv.chatInputType = paramCursor.getInt(paramCursor.getColumnIndex("chatInputType"));
        paramawbv.showC2CPanel = paramCursor.getInt(paramCursor.getColumnIndex("showC2CPanel"));
        paramawbv.pttChangeVoiceType = paramCursor.getInt(paramCursor.getColumnIndex("pttChangeVoiceType"));
        paramawbv.audioPanelType = paramCursor.getInt(paramCursor.getColumnIndex("audioPanelType"));
        paramawbv.openDoNotDisturbTime = paramCursor.getLong(paramCursor.getColumnIndex("openDoNotDisturbTime"));
        paramawbv.latestPLUpdateTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("latestPLUpdateTimestamp"));
        paramawbv.lastPullPLNewsTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastPullPLNewsTimestamp"));
        paramawbv.lastPLNewsTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastPLNewsTimestamp"));
        paramawbv.medalUpdateTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("medalUpdateTimestamp"));
        paramawbv.lastMedalTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastMedalTimestamp"));
        paramawbv.diyFontTimestampBytes = paramCursor.getBlob(paramCursor.getColumnIndex("diyFontTimestampBytes"));
        paramawbv.diyFontConfigBytes = paramCursor.getBlob(paramCursor.getColumnIndex("diyFontConfigBytes"));
        paramawbv.lastIceBreakCheckTs = paramCursor.getLong(paramCursor.getColumnIndex("lastIceBreakCheckTs"));
        paramawbv.lastIceBreakChatTs = paramCursor.getLong(paramCursor.getColumnIndex("lastIceBreakChatTs"));
        paramawbv.makeFrdsTs = paramCursor.getLong(paramCursor.getColumnIndex("makeFrdsTs"));
        paramawbv.topPositionTime = paramCursor.getLong(paramCursor.getColumnIndex("topPositionTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isListenTogetherOpen"))) {
          break label1747;
        }
        paramBoolean = true;
        label734:
        paramawbv.isListenTogetherOpen = paramBoolean;
        paramawbv.isSharingLocation = paramCursor.getInt(paramCursor.getColumnIndex("isSharingLocation"));
        paramawbv.lastShareLbsMsgUniseq = paramCursor.getLong(paramCursor.getColumnIndex("lastShareLbsMsgUniseq"));
        paramawbv.mTogetherBusinessFlag = paramCursor.getLong(paramCursor.getColumnIndex("mTogetherBusinessFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnablePreview"))) {
          break label1752;
        }
        paramBoolean = true;
        label813:
        paramawbv.messageEnablePreview = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnableSound"))) {
          break label1757;
        }
        paramBoolean = true;
        label838:
        paramawbv.messageEnableSound = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnableVibrate"))) {
          break label1762;
        }
        paramBoolean = true;
        label863:
        paramawbv.messageEnableVibrate = paramBoolean;
        paramawbv.friendRingId = paramCursor.getInt(paramCursor.getColumnIndex("friendRingId"));
        paramawbv.messageEnablePreviewNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnablePreviewNew"));
        paramawbv.messageEnableSoundNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnableSoundNew"));
        paramawbv.messageEnableVibrateNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnableVibrateNew"));
        paramawbv.hiddenChatSwitch = paramCursor.getInt(paramCursor.getColumnIndex("hiddenChatSwitch"));
        paramawbv.intimate_type = paramCursor.getInt(paramCursor.getColumnIndex("intimate_type"));
        paramawbv.intimate_level = paramCursor.getInt(paramCursor.getColumnIndex("intimate_level"));
        paramawbv.intimate_chatDays = paramCursor.getInt(paramCursor.getColumnIndex("intimate_chatDays"));
        paramawbv.last_intimate_chatTime = paramCursor.getLong(paramCursor.getColumnIndex("last_intimate_chatTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isExtinguish"))) {
          break label1767;
        }
        paramBoolean = true;
        label1053:
        paramawbv.isExtinguish = paramBoolean;
        paramawbv.friendshipLevel = paramCursor.getInt(paramCursor.getColumnIndex("friendshipLevel"));
        paramawbv.friendshipChatDays = paramCursor.getInt(paramCursor.getColumnIndex("friendshipChatDays"));
        paramawbv.lastFriendshipTime = paramCursor.getLong(paramCursor.getColumnIndex("lastFriendshipTime"));
        paramawbv.chatHotLevel = paramCursor.getInt(paramCursor.getColumnIndex("chatHotLevel"));
        paramawbv.chatDays = paramCursor.getInt(paramCursor.getColumnIndex("chatDays"));
        paramawbv.lastChatTime = paramCursor.getLong(paramCursor.getColumnIndex("lastChatTime"));
        paramawbv.praiseHotLevel = paramCursor.getInt(paramCursor.getColumnIndex("praiseHotLevel"));
        paramawbv.praiseDays = paramCursor.getInt(paramCursor.getColumnIndex("praiseDays"));
        paramawbv.lastpraiseTime = paramCursor.getLong(paramCursor.getColumnIndex("lastpraiseTime"));
        paramawbv.loverChatLevel = paramCursor.getInt(paramCursor.getColumnIndex("loverChatLevel"));
        paramawbv.loverChatDays = paramCursor.getInt(paramCursor.getColumnIndex("loverChatDays"));
        paramawbv.loverLastChatTime = paramCursor.getLong(paramCursor.getColumnIndex("loverLastChatTime"));
        paramawbv.loverFlag = paramCursor.getInt(paramCursor.getColumnIndex("loverFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("loverTransFlag"))) {
          break label1772;
        }
        paramBoolean = true;
        label1326:
        paramawbv.loverTransFlag = paramBoolean;
        paramawbv.qzoneVisitType = paramCursor.getInt(paramCursor.getColumnIndex("qzoneVisitType"));
        paramawbv.qzoneHotDays = paramCursor.getInt(paramCursor.getColumnIndex("qzoneHotDays"));
        paramawbv.lastQzoneVisitTime = paramCursor.getLong(paramCursor.getColumnIndex("lastQzoneVisitTime"));
        paramawbv.bestIntimacyType = paramCursor.getInt(paramCursor.getColumnIndex("bestIntimacyType"));
        paramawbv.bestIntimacyDays = paramCursor.getInt(paramCursor.getColumnIndex("bestIntimacyDays"));
        paramawbv.newBestIntimacyType = paramCursor.getInt(paramCursor.getColumnIndex("newBestIntimacyType"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindChat"))) {
          break label1777;
        }
        paramBoolean = true;
        label1466:
        paramawbv.hasRemindChat = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindLoverChat"))) {
          break label1782;
        }
        paramBoolean = true;
        label1492:
        paramawbv.hasRemindLoverChat = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindPraise"))) {
          break label1787;
        }
        paramBoolean = true;
        label1518:
        paramawbv.hasRemindPraise = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindQzoneVisit"))) {
          break label1792;
        }
        paramBoolean = true;
        label1544:
        paramawbv.hasRemindQzoneVisit = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindFrdship"))) {
          break label1797;
        }
        paramBoolean = true;
        label1570:
        paramawbv.hasRemindFrdship = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindIntimate"))) {
          break label1802;
        }
      }
      label1792:
      label1797:
      label1802:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramawbv.hasRemindIntimate = paramBoolean;
        paramawbv.localChatSendTs = paramCursor.getLong(paramCursor.getColumnIndex("localChatSendTs"));
        paramawbv.localChatRecTs = paramCursor.getLong(paramCursor.getColumnIndex("localChatRecTs"));
        paramawbv.lastHotReactiveReCheckInTs = paramCursor.getLong(paramCursor.getColumnIndex("lastHotReactiveReCheckInTs"));
        paramawbv.isGrayTipRemind = paramCursor.getInt(paramCursor.getColumnIndex("isGrayTipRemind"));
        paramawbv.isGrayTipMultiRemind = paramCursor.getInt(paramCursor.getColumnIndex("isGrayTipMultiRemind"));
        paramawbv.mutual_marks_store_json = paramCursor.getString(paramCursor.getColumnIndex("mutual_marks_store_json"));
        paramawbv.mutual_mark_version = paramCursor.getInt(paramCursor.getColumnIndex("mutual_mark_version"));
        return paramawbv;
        paramBoolean = false;
        break;
        label1742:
        paramBoolean = false;
        break label421;
        label1747:
        paramBoolean = false;
        break label734;
        label1752:
        paramBoolean = false;
        break label813;
        label1757:
        paramBoolean = false;
        break label838;
        label1762:
        paramBoolean = false;
        break label863;
        label1767:
        paramBoolean = false;
        break label1053;
        label1772:
        paramBoolean = false;
        break label1326;
        label1777:
        paramBoolean = false;
        break label1466;
        label1782:
        paramBoolean = false;
        break label1492;
        label1787:
        paramBoolean = false;
        break label1518;
        paramBoolean = false;
        break label1544;
        paramBoolean = false;
        break label1570;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("pendantId");
      if (i != -1) {
        break label4976;
      }
      paramawcg.a(new NoColumnError("pendantId", Long.TYPE));
      label1877:
      i = paramCursor.getColumnIndex("pendantDiyId");
      if (i != -1) {
        break label4991;
      }
      paramawcg.a(new NoColumnError("pendantDiyId", Integer.TYPE));
      label1912:
      i = paramCursor.getColumnIndex("uVipFont");
      if (i != -1) {
        break label5006;
      }
      paramawcg.a(new NoColumnError("uVipFont", Long.TYPE));
      label1947:
      i = paramCursor.getColumnIndex("vipFontType");
      if (i != -1) {
        break label5021;
      }
      paramawcg.a(new NoColumnError("vipFontType", Integer.TYPE));
      label1982:
      i = paramCursor.getColumnIndex("magicFont");
      if (i != -1) {
        break label5036;
      }
      paramawcg.a(new NoColumnError("magicFont", Integer.TYPE));
      label2017:
      i = paramCursor.getColumnIndex("lastUpdateTime");
      if (i != -1) {
        break label5051;
      }
      paramawcg.a(new NoColumnError("lastUpdateTime", Long.TYPE));
      label2052:
      i = paramCursor.getColumnIndex("fontEffect");
      if (i != -1) {
        break label5066;
      }
      paramawcg.a(new NoColumnError("fontEffect", Integer.TYPE));
      label2087:
      i = paramCursor.getColumnIndex("fontEffectLastUpdateTime");
      if (i != -1) {
        break label5081;
      }
      paramawcg.a(new NoColumnError("fontEffectLastUpdateTime", Long.TYPE));
      label2122:
      i = paramCursor.getColumnIndex("faceId");
      if (i != -1) {
        break label5096;
      }
      paramawcg.a(new NoColumnError("faceId", Integer.TYPE));
      label2157:
      i = paramCursor.getColumnIndex("faceIdUpdateTime");
      if (i != -1) {
        break label5111;
      }
      paramawcg.a(new NoColumnError("faceIdUpdateTime", Long.TYPE));
      label2192:
      i = paramCursor.getColumnIndex("colorRingId");
      if (i != -1) {
        break label5126;
      }
      paramawcg.a(new NoColumnError("colorRingId", Long.TYPE));
      label2227:
      i = paramCursor.getColumnIndex("commingRingId");
      if (i != -1) {
        break label5141;
      }
      paramawcg.a(new NoColumnError("commingRingId", Long.TYPE));
      label2262:
      i = paramCursor.getColumnIndex("timestamp");
      if (i != -1) {
        break label5156;
      }
      paramawcg.a(new NoColumnError("timestamp", Long.TYPE));
      label2297:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label5171;
      }
      paramawcg.a(new NoColumnError("richTime", Long.TYPE));
      label2332:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label5186;
      }
      paramawcg.a(new NoColumnError("richBuffer", [B.class));
      label2367:
      i = paramCursor.getColumnIndex("feedType");
      if (i != -1) {
        break label5201;
      }
      paramawcg.a(new NoColumnError("feedType", Integer.TYPE));
      label2402:
      i = paramCursor.getColumnIndex("feedTime");
      if (i != -1) {
        break label5216;
      }
      paramawcg.a(new NoColumnError("feedTime", Long.TYPE));
      label2437:
      i = paramCursor.getColumnIndex("feedContent");
      if (i != -1) {
        break label5231;
      }
      paramawcg.a(new NoColumnError("feedContent", String.class));
      label2472:
      i = paramCursor.getColumnIndex("feedHasPhoto");
      if (i != -1) {
        break label5246;
      }
      paramawcg.a(new NoColumnError("feedHasPhoto", Boolean.TYPE));
      i = paramCursor.getColumnIndex("feedPhotoUrl");
      if (i != -1) {
        break label5273;
      }
      paramawcg.a(new NoColumnError("feedPhotoUrl", String.class));
      label2542:
      i = paramCursor.getColumnIndex("isAdded2C2C");
      if (i != -1) {
        break label5288;
      }
      paramawcg.a(new NoColumnError("isAdded2C2C", Boolean.TYPE));
      i = paramCursor.getColumnIndex("chatInputType");
      if (i != -1) {
        break label5315;
      }
      paramawcg.a(new NoColumnError("chatInputType", Integer.TYPE));
      label2612:
      i = paramCursor.getColumnIndex("showC2CPanel");
      if (i != -1) {
        break label5330;
      }
      paramawcg.a(new NoColumnError("showC2CPanel", Integer.TYPE));
      label2647:
      i = paramCursor.getColumnIndex("pttChangeVoiceType");
      if (i != -1) {
        break label5345;
      }
      paramawcg.a(new NoColumnError("pttChangeVoiceType", Integer.TYPE));
      label2682:
      i = paramCursor.getColumnIndex("audioPanelType");
      if (i != -1) {
        break label5360;
      }
      paramawcg.a(new NoColumnError("audioPanelType", Integer.TYPE));
      label2717:
      i = paramCursor.getColumnIndex("openDoNotDisturbTime");
      if (i != -1) {
        break label5375;
      }
      paramawcg.a(new NoColumnError("openDoNotDisturbTime", Long.TYPE));
      label2752:
      i = paramCursor.getColumnIndex("latestPLUpdateTimestamp");
      if (i != -1) {
        break label5390;
      }
      paramawcg.a(new NoColumnError("latestPLUpdateTimestamp", Long.TYPE));
      label2787:
      i = paramCursor.getColumnIndex("lastPullPLNewsTimestamp");
      if (i != -1) {
        break label5405;
      }
      paramawcg.a(new NoColumnError("lastPullPLNewsTimestamp", Long.TYPE));
      label2822:
      i = paramCursor.getColumnIndex("lastPLNewsTimestamp");
      if (i != -1) {
        break label5420;
      }
      paramawcg.a(new NoColumnError("lastPLNewsTimestamp", Long.TYPE));
      label2857:
      i = paramCursor.getColumnIndex("medalUpdateTimestamp");
      if (i != -1) {
        break label5435;
      }
      paramawcg.a(new NoColumnError("medalUpdateTimestamp", Long.TYPE));
      label2892:
      i = paramCursor.getColumnIndex("lastMedalTimestamp");
      if (i != -1) {
        break label5450;
      }
      paramawcg.a(new NoColumnError("lastMedalTimestamp", Long.TYPE));
      label2927:
      i = paramCursor.getColumnIndex("diyFontTimestampBytes");
      if (i != -1) {
        break label5465;
      }
      paramawcg.a(new NoColumnError("diyFontTimestampBytes", [B.class));
      label2962:
      i = paramCursor.getColumnIndex("diyFontConfigBytes");
      if (i != -1) {
        break label5480;
      }
      paramawcg.a(new NoColumnError("diyFontConfigBytes", [B.class));
      label2997:
      i = paramCursor.getColumnIndex("lastIceBreakCheckTs");
      if (i != -1) {
        break label5495;
      }
      paramawcg.a(new NoColumnError("lastIceBreakCheckTs", Long.TYPE));
      label3032:
      i = paramCursor.getColumnIndex("lastIceBreakChatTs");
      if (i != -1) {
        break label5510;
      }
      paramawcg.a(new NoColumnError("lastIceBreakChatTs", Long.TYPE));
      label3067:
      i = paramCursor.getColumnIndex("makeFrdsTs");
      if (i != -1) {
        break label5525;
      }
      paramawcg.a(new NoColumnError("makeFrdsTs", Long.TYPE));
      label3102:
      i = paramCursor.getColumnIndex("topPositionTime");
      if (i != -1) {
        break label5540;
      }
      paramawcg.a(new NoColumnError("topPositionTime", Long.TYPE));
      label3137:
      i = paramCursor.getColumnIndex("isListenTogetherOpen");
      if (i != -1) {
        break label5555;
      }
      paramawcg.a(new NoColumnError("isListenTogetherOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isSharingLocation");
      if (i != -1) {
        break label5582;
      }
      paramawcg.a(new NoColumnError("isSharingLocation", Integer.TYPE));
      label3207:
      i = paramCursor.getColumnIndex("lastShareLbsMsgUniseq");
      if (i != -1) {
        break label5597;
      }
      paramawcg.a(new NoColumnError("lastShareLbsMsgUniseq", Long.TYPE));
      label3242:
      i = paramCursor.getColumnIndex("mTogetherBusinessFlag");
      if (i != -1) {
        break label5612;
      }
      paramawcg.a(new NoColumnError("mTogetherBusinessFlag", Long.TYPE));
      label3277:
      i = paramCursor.getColumnIndex("messageEnablePreview");
      if (i != -1) {
        break label5627;
      }
      paramawcg.a(new NoColumnError("messageEnablePreview", Boolean.TYPE));
      i = paramCursor.getColumnIndex("messageEnableSound");
      if (i != -1) {
        break label5654;
      }
      paramawcg.a(new NoColumnError("messageEnableSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("messageEnableVibrate");
      if (i != -1) {
        break label5681;
      }
      paramawcg.a(new NoColumnError("messageEnableVibrate", Boolean.TYPE));
      i = paramCursor.getColumnIndex("friendRingId");
      if (i != -1) {
        break label5708;
      }
      paramawcg.a(new NoColumnError("friendRingId", Integer.TYPE));
      label3417:
      i = paramCursor.getColumnIndex("messageEnablePreviewNew");
      if (i != -1) {
        break label5723;
      }
      paramawcg.a(new NoColumnError("messageEnablePreviewNew", Integer.TYPE));
      label3452:
      i = paramCursor.getColumnIndex("messageEnableSoundNew");
      if (i != -1) {
        break label5738;
      }
      paramawcg.a(new NoColumnError("messageEnableSoundNew", Integer.TYPE));
      label3487:
      i = paramCursor.getColumnIndex("messageEnableVibrateNew");
      if (i != -1) {
        break label5753;
      }
      paramawcg.a(new NoColumnError("messageEnableVibrateNew", Integer.TYPE));
      label3522:
      i = paramCursor.getColumnIndex("hiddenChatSwitch");
      if (i != -1) {
        break label5768;
      }
      paramawcg.a(new NoColumnError("hiddenChatSwitch", Integer.TYPE));
      label3557:
      i = paramCursor.getColumnIndex("intimate_type");
      if (i != -1) {
        break label5783;
      }
      paramawcg.a(new NoColumnError("intimate_type", Integer.TYPE));
      label3592:
      i = paramCursor.getColumnIndex("intimate_level");
      if (i != -1) {
        break label5798;
      }
      paramawcg.a(new NoColumnError("intimate_level", Integer.TYPE));
      label3627:
      i = paramCursor.getColumnIndex("intimate_chatDays");
      if (i != -1) {
        break label5813;
      }
      paramawcg.a(new NoColumnError("intimate_chatDays", Integer.TYPE));
      label3664:
      i = paramCursor.getColumnIndex("last_intimate_chatTime");
      if (i != -1) {
        break label5828;
      }
      paramawcg.a(new NoColumnError("last_intimate_chatTime", Long.TYPE));
      label3701:
      i = paramCursor.getColumnIndex("isExtinguish");
      if (i != -1) {
        break label5843;
      }
      paramawcg.a(new NoColumnError("isExtinguish", Boolean.TYPE));
      i = paramCursor.getColumnIndex("friendshipLevel");
      if (i != -1) {
        break label5870;
      }
      paramawcg.a(new NoColumnError("friendshipLevel", Integer.TYPE));
      label3775:
      i = paramCursor.getColumnIndex("friendshipChatDays");
      if (i != -1) {
        break label5885;
      }
      paramawcg.a(new NoColumnError("friendshipChatDays", Integer.TYPE));
      label3812:
      i = paramCursor.getColumnIndex("lastFriendshipTime");
      if (i != -1) {
        break label5900;
      }
      paramawcg.a(new NoColumnError("lastFriendshipTime", Long.TYPE));
      label3849:
      i = paramCursor.getColumnIndex("chatHotLevel");
      if (i != -1) {
        break label5915;
      }
      paramawcg.a(new NoColumnError("chatHotLevel", Integer.TYPE));
      label3886:
      i = paramCursor.getColumnIndex("chatDays");
      if (i != -1) {
        break label5930;
      }
      paramawcg.a(new NoColumnError("chatDays", Integer.TYPE));
      label3923:
      i = paramCursor.getColumnIndex("lastChatTime");
      if (i != -1) {
        break label5945;
      }
      paramawcg.a(new NoColumnError("lastChatTime", Long.TYPE));
      label3960:
      i = paramCursor.getColumnIndex("praiseHotLevel");
      if (i != -1) {
        break label5960;
      }
      paramawcg.a(new NoColumnError("praiseHotLevel", Integer.TYPE));
      label3997:
      i = paramCursor.getColumnIndex("praiseDays");
      if (i != -1) {
        break label5975;
      }
      paramawcg.a(new NoColumnError("praiseDays", Integer.TYPE));
      label4034:
      i = paramCursor.getColumnIndex("lastpraiseTime");
      if (i != -1) {
        break label5990;
      }
      paramawcg.a(new NoColumnError("lastpraiseTime", Long.TYPE));
      label4071:
      i = paramCursor.getColumnIndex("loverChatLevel");
      if (i != -1) {
        break label6005;
      }
      paramawcg.a(new NoColumnError("loverChatLevel", Integer.TYPE));
      label4108:
      i = paramCursor.getColumnIndex("loverChatDays");
      if (i != -1) {
        break label6020;
      }
      paramawcg.a(new NoColumnError("loverChatDays", Integer.TYPE));
      label4145:
      i = paramCursor.getColumnIndex("loverLastChatTime");
      if (i != -1) {
        break label6035;
      }
      paramawcg.a(new NoColumnError("loverLastChatTime", Long.TYPE));
      label4182:
      i = paramCursor.getColumnIndex("loverFlag");
      if (i != -1) {
        break label6050;
      }
      paramawcg.a(new NoColumnError("loverFlag", Integer.TYPE));
      label4219:
      i = paramCursor.getColumnIndex("loverTransFlag");
      if (i != -1) {
        break label6065;
      }
      paramawcg.a(new NoColumnError("loverTransFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("qzoneVisitType");
      if (i != -1) {
        break label6092;
      }
      paramawcg.a(new NoColumnError("qzoneVisitType", Integer.TYPE));
      label4293:
      i = paramCursor.getColumnIndex("qzoneHotDays");
      if (i != -1) {
        break label6107;
      }
      paramawcg.a(new NoColumnError("qzoneHotDays", Integer.TYPE));
      label4330:
      i = paramCursor.getColumnIndex("lastQzoneVisitTime");
      if (i != -1) {
        break label6122;
      }
      paramawcg.a(new NoColumnError("lastQzoneVisitTime", Long.TYPE));
      label4367:
      i = paramCursor.getColumnIndex("bestIntimacyType");
      if (i != -1) {
        break label6137;
      }
      paramawcg.a(new NoColumnError("bestIntimacyType", Integer.TYPE));
      label4404:
      i = paramCursor.getColumnIndex("bestIntimacyDays");
      if (i != -1) {
        break label6152;
      }
      paramawcg.a(new NoColumnError("bestIntimacyDays", Integer.TYPE));
      label4441:
      i = paramCursor.getColumnIndex("newBestIntimacyType");
      if (i != -1) {
        break label6167;
      }
      paramawcg.a(new NoColumnError("newBestIntimacyType", Integer.TYPE));
      label4478:
      i = paramCursor.getColumnIndex("hasRemindChat");
      if (i != -1) {
        break label6182;
      }
      paramawcg.a(new NoColumnError("hasRemindChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindLoverChat");
      if (i != -1) {
        break label6209;
      }
      paramawcg.a(new NoColumnError("hasRemindLoverChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindPraise");
      if (i != -1) {
        break label6236;
      }
      paramawcg.a(new NoColumnError("hasRemindPraise", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindQzoneVisit");
      if (i != -1) {
        break label6263;
      }
      paramawcg.a(new NoColumnError("hasRemindQzoneVisit", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindFrdship");
      if (i != -1) {
        break label6290;
      }
      paramawcg.a(new NoColumnError("hasRemindFrdship", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindIntimate");
      if (i != -1) {
        break label6317;
      }
      paramawcg.a(new NoColumnError("hasRemindIntimate", Boolean.TYPE));
      i = paramCursor.getColumnIndex("localChatSendTs");
      if (i != -1) {
        break label6345;
      }
      paramawcg.a(new NoColumnError("localChatSendTs", Long.TYPE));
      label4737:
      i = paramCursor.getColumnIndex("localChatRecTs");
      if (i != -1) {
        break label6360;
      }
      paramawcg.a(new NoColumnError("localChatRecTs", Long.TYPE));
      label4774:
      i = paramCursor.getColumnIndex("lastHotReactiveReCheckInTs");
      if (i != -1) {
        break label6375;
      }
      paramawcg.a(new NoColumnError("lastHotReactiveReCheckInTs", Long.TYPE));
      label4811:
      i = paramCursor.getColumnIndex("isGrayTipRemind");
      if (i != -1) {
        break label6390;
      }
      paramawcg.a(new NoColumnError("isGrayTipRemind", Integer.TYPE));
      label4848:
      i = paramCursor.getColumnIndex("isGrayTipMultiRemind");
      if (i != -1) {
        break label6405;
      }
      paramawcg.a(new NoColumnError("isGrayTipMultiRemind", Integer.TYPE));
      label4885:
      i = paramCursor.getColumnIndex("mutual_marks_store_json");
      if (i != -1) {
        break label6420;
      }
      paramawcg.a(new NoColumnError("mutual_marks_store_json", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("mutual_mark_version");
      if (i != -1) {
        break label6435;
      }
      paramawcg.a(new NoColumnError("mutual_mark_version", Integer.TYPE));
      return paramawbv;
      paramawbv.uin = paramCursor.getString(i);
      break;
      label4976:
      paramawbv.pendantId = paramCursor.getLong(i);
      break label1877;
      label4991:
      paramawbv.pendantDiyId = paramCursor.getInt(i);
      break label1912;
      label5006:
      paramawbv.uVipFont = paramCursor.getLong(i);
      break label1947;
      label5021:
      paramawbv.vipFontType = paramCursor.getInt(i);
      break label1982;
      label5036:
      paramawbv.magicFont = paramCursor.getInt(i);
      break label2017;
      label5051:
      paramawbv.lastUpdateTime = paramCursor.getLong(i);
      break label2052;
      label5066:
      paramawbv.fontEffect = paramCursor.getInt(i);
      break label2087;
      label5081:
      paramawbv.fontEffectLastUpdateTime = paramCursor.getLong(i);
      break label2122;
      label5096:
      paramawbv.faceId = paramCursor.getInt(i);
      break label2157;
      label5111:
      paramawbv.faceIdUpdateTime = paramCursor.getLong(i);
      break label2192;
      label5126:
      paramawbv.colorRingId = paramCursor.getLong(i);
      break label2227;
      label5141:
      paramawbv.commingRingId = paramCursor.getLong(i);
      break label2262;
      label5156:
      paramawbv.timestamp = paramCursor.getLong(i);
      break label2297;
      label5171:
      paramawbv.richTime = paramCursor.getLong(i);
      break label2332;
      label5186:
      paramawbv.richBuffer = paramCursor.getBlob(i);
      break label2367;
      label5201:
      paramawbv.feedType = paramCursor.getInt(i);
      break label2402;
      label5216:
      paramawbv.feedTime = paramCursor.getLong(i);
      break label2437;
      label5231:
      paramawbv.feedContent = paramCursor.getString(i);
      break label2472;
      label5246:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.feedHasPhoto = paramBoolean;
        break;
      }
      label5273:
      paramawbv.feedPhotoUrl = paramCursor.getString(i);
      break label2542;
      label5288:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isAdded2C2C = paramBoolean;
        break;
      }
      label5315:
      paramawbv.chatInputType = paramCursor.getInt(i);
      break label2612;
      label5330:
      paramawbv.showC2CPanel = paramCursor.getInt(i);
      break label2647;
      label5345:
      paramawbv.pttChangeVoiceType = paramCursor.getInt(i);
      break label2682;
      label5360:
      paramawbv.audioPanelType = paramCursor.getInt(i);
      break label2717;
      label5375:
      paramawbv.openDoNotDisturbTime = paramCursor.getLong(i);
      break label2752;
      label5390:
      paramawbv.latestPLUpdateTimestamp = paramCursor.getLong(i);
      break label2787;
      label5405:
      paramawbv.lastPullPLNewsTimestamp = paramCursor.getLong(i);
      break label2822;
      label5420:
      paramawbv.lastPLNewsTimestamp = paramCursor.getLong(i);
      break label2857;
      label5435:
      paramawbv.medalUpdateTimestamp = paramCursor.getLong(i);
      break label2892;
      label5450:
      paramawbv.lastMedalTimestamp = paramCursor.getLong(i);
      break label2927;
      label5465:
      paramawbv.diyFontTimestampBytes = paramCursor.getBlob(i);
      break label2962;
      label5480:
      paramawbv.diyFontConfigBytes = paramCursor.getBlob(i);
      break label2997;
      label5495:
      paramawbv.lastIceBreakCheckTs = paramCursor.getLong(i);
      break label3032;
      label5510:
      paramawbv.lastIceBreakChatTs = paramCursor.getLong(i);
      break label3067;
      label5525:
      paramawbv.makeFrdsTs = paramCursor.getLong(i);
      break label3102;
      label5540:
      paramawbv.topPositionTime = paramCursor.getLong(i);
      break label3137;
      label5555:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isListenTogetherOpen = paramBoolean;
        break;
      }
      label5582:
      paramawbv.isSharingLocation = paramCursor.getInt(i);
      break label3207;
      label5597:
      paramawbv.lastShareLbsMsgUniseq = paramCursor.getLong(i);
      break label3242;
      label5612:
      paramawbv.mTogetherBusinessFlag = paramCursor.getLong(i);
      break label3277;
      label5627:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.messageEnablePreview = paramBoolean;
        break;
      }
      label5654:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.messageEnableSound = paramBoolean;
        break;
      }
      label5681:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.messageEnableVibrate = paramBoolean;
        break;
      }
      label5708:
      paramawbv.friendRingId = paramCursor.getInt(i);
      break label3417;
      label5723:
      paramawbv.messageEnablePreviewNew = paramCursor.getInt(i);
      break label3452;
      label5738:
      paramawbv.messageEnableSoundNew = paramCursor.getInt(i);
      break label3487;
      label5753:
      paramawbv.messageEnableVibrateNew = paramCursor.getInt(i);
      break label3522;
      label5768:
      paramawbv.hiddenChatSwitch = paramCursor.getInt(i);
      break label3557;
      label5783:
      paramawbv.intimate_type = paramCursor.getInt(i);
      break label3592;
      label5798:
      paramawbv.intimate_level = paramCursor.getInt(i);
      break label3627;
      label5813:
      paramawbv.intimate_chatDays = paramCursor.getInt(i);
      break label3664;
      label5828:
      paramawbv.last_intimate_chatTime = paramCursor.getLong(i);
      break label3701;
      label5843:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isExtinguish = paramBoolean;
        break;
      }
      label5870:
      paramawbv.friendshipLevel = paramCursor.getInt(i);
      break label3775;
      label5885:
      paramawbv.friendshipChatDays = paramCursor.getInt(i);
      break label3812;
      label5900:
      paramawbv.lastFriendshipTime = paramCursor.getLong(i);
      break label3849;
      label5915:
      paramawbv.chatHotLevel = paramCursor.getInt(i);
      break label3886;
      label5930:
      paramawbv.chatDays = paramCursor.getInt(i);
      break label3923;
      label5945:
      paramawbv.lastChatTime = paramCursor.getLong(i);
      break label3960;
      label5960:
      paramawbv.praiseHotLevel = paramCursor.getInt(i);
      break label3997;
      label5975:
      paramawbv.praiseDays = paramCursor.getInt(i);
      break label4034;
      label5990:
      paramawbv.lastpraiseTime = paramCursor.getLong(i);
      break label4071;
      label6005:
      paramawbv.loverChatLevel = paramCursor.getInt(i);
      break label4108;
      label6020:
      paramawbv.loverChatDays = paramCursor.getInt(i);
      break label4145;
      label6035:
      paramawbv.loverLastChatTime = paramCursor.getLong(i);
      break label4182;
      label6050:
      paramawbv.loverFlag = paramCursor.getInt(i);
      break label4219;
      label6065:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.loverTransFlag = paramBoolean;
        break;
      }
      label6092:
      paramawbv.qzoneVisitType = paramCursor.getInt(i);
      break label4293;
      label6107:
      paramawbv.qzoneHotDays = paramCursor.getInt(i);
      break label4330;
      label6122:
      paramawbv.lastQzoneVisitTime = paramCursor.getLong(i);
      break label4367;
      label6137:
      paramawbv.bestIntimacyType = paramCursor.getInt(i);
      break label4404;
      label6152:
      paramawbv.bestIntimacyDays = paramCursor.getInt(i);
      break label4441;
      label6167:
      paramawbv.newBestIntimacyType = paramCursor.getInt(i);
      break label4478;
      label6182:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.hasRemindChat = paramBoolean;
        break;
      }
      label6209:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.hasRemindLoverChat = paramBoolean;
        break;
      }
      label6236:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.hasRemindPraise = paramBoolean;
        break;
      }
      label6263:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.hasRemindQzoneVisit = paramBoolean;
        break;
      }
      label6290:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.hasRemindFrdship = paramBoolean;
        break;
      }
      label6317:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramawbv.hasRemindIntimate = paramBoolean;
        break;
      }
      label6345:
      paramawbv.localChatSendTs = paramCursor.getLong(i);
      break label4737;
      label6360:
      paramawbv.localChatRecTs = paramCursor.getLong(i);
      break label4774;
      label6375:
      paramawbv.lastHotReactiveReCheckInTs = paramCursor.getLong(i);
      break label4811;
      label6390:
      paramawbv.isGrayTipRemind = paramCursor.getInt(i);
      break label4848;
      label6405:
      paramawbv.isGrayTipMultiRemind = paramCursor.getInt(i);
      break label4885;
      label6420:
      paramawbv.mutual_marks_store_json = paramCursor.getString(i);
    }
    label6435:
    paramawbv.mutual_mark_version = paramCursor.getInt(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,pendantId INTEGER ,pendantDiyId INTEGER ,uVipFont INTEGER ,vipFontType INTEGER ,magicFont INTEGER ,lastUpdateTime INTEGER ,fontEffect INTEGER ,fontEffectLastUpdateTime INTEGER ,faceId INTEGER ,faceIdUpdateTime INTEGER ,colorRingId INTEGER ,commingRingId INTEGER ,timestamp INTEGER ,richTime INTEGER ,richBuffer BLOB ,feedType INTEGER ,feedTime INTEGER ,feedContent TEXT ,feedHasPhoto INTEGER ,feedPhotoUrl TEXT ,isAdded2C2C INTEGER ,chatInputType INTEGER ,showC2CPanel INTEGER ,pttChangeVoiceType INTEGER ,audioPanelType INTEGER ,openDoNotDisturbTime INTEGER ,latestPLUpdateTimestamp INTEGER ,lastPullPLNewsTimestamp INTEGER ,lastPLNewsTimestamp INTEGER ,medalUpdateTimestamp INTEGER ,lastMedalTimestamp INTEGER ,diyFontTimestampBytes BLOB ,diyFontConfigBytes BLOB ,lastIceBreakCheckTs INTEGER ,lastIceBreakChatTs INTEGER ,makeFrdsTs INTEGER ,topPositionTime INTEGER ,isListenTogetherOpen INTEGER ,isSharingLocation INTEGER ,lastShareLbsMsgUniseq INTEGER ,mTogetherBusinessFlag INTEGER ,messageEnablePreview INTEGER ,messageEnableSound INTEGER ,messageEnableVibrate INTEGER ,friendRingId INTEGER ,messageEnablePreviewNew INTEGER ,messageEnableSoundNew INTEGER ,messageEnableVibrateNew INTEGER ,hiddenChatSwitch INTEGER ,intimate_type INTEGER ,intimate_level INTEGER ,intimate_chatDays INTEGER ,last_intimate_chatTime INTEGER ,isExtinguish INTEGER ,friendshipLevel INTEGER ,friendshipChatDays INTEGER ,lastFriendshipTime INTEGER ,chatHotLevel INTEGER ,chatDays INTEGER ,lastChatTime INTEGER ,praiseHotLevel INTEGER ,praiseDays INTEGER ,lastpraiseTime INTEGER ,loverChatLevel INTEGER ,loverChatDays INTEGER ,loverLastChatTime INTEGER ,loverFlag INTEGER ,loverTransFlag INTEGER ,qzoneVisitType INTEGER ,qzoneHotDays INTEGER ,lastQzoneVisitTime INTEGER ,bestIntimacyType INTEGER ,bestIntimacyDays INTEGER ,newBestIntimacyType INTEGER ,hasRemindChat INTEGER ,hasRemindLoverChat INTEGER ,hasRemindPraise INTEGER ,hasRemindQzoneVisit INTEGER ,hasRemindFrdship INTEGER ,hasRemindIntimate INTEGER ,localChatSendTs INTEGER ,localChatRecTs INTEGER ,lastHotReactiveReCheckInTs INTEGER ,isGrayTipRemind INTEGER ,isGrayTipMultiRemind INTEGER ,mutual_marks_store_json TEXT ,mutual_mark_version INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (ExtensionInfo)paramawbv;
    paramContentValues.put("uin", paramawbv.uin);
    paramContentValues.put("pendantId", Long.valueOf(paramawbv.pendantId));
    paramContentValues.put("pendantDiyId", Integer.valueOf(paramawbv.pendantDiyId));
    paramContentValues.put("uVipFont", Long.valueOf(paramawbv.uVipFont));
    paramContentValues.put("vipFontType", Integer.valueOf(paramawbv.vipFontType));
    paramContentValues.put("magicFont", Integer.valueOf(paramawbv.magicFont));
    paramContentValues.put("lastUpdateTime", Long.valueOf(paramawbv.lastUpdateTime));
    paramContentValues.put("fontEffect", Integer.valueOf(paramawbv.fontEffect));
    paramContentValues.put("fontEffectLastUpdateTime", Long.valueOf(paramawbv.fontEffectLastUpdateTime));
    paramContentValues.put("faceId", Integer.valueOf(paramawbv.faceId));
    paramContentValues.put("faceIdUpdateTime", Long.valueOf(paramawbv.faceIdUpdateTime));
    paramContentValues.put("colorRingId", Long.valueOf(paramawbv.colorRingId));
    paramContentValues.put("commingRingId", Long.valueOf(paramawbv.commingRingId));
    paramContentValues.put("timestamp", Long.valueOf(paramawbv.timestamp));
    paramContentValues.put("richTime", Long.valueOf(paramawbv.richTime));
    paramContentValues.put("richBuffer", paramawbv.richBuffer);
    paramContentValues.put("feedType", Integer.valueOf(paramawbv.feedType));
    paramContentValues.put("feedTime", Long.valueOf(paramawbv.feedTime));
    paramContentValues.put("feedContent", paramawbv.feedContent);
    paramContentValues.put("feedHasPhoto", Boolean.valueOf(paramawbv.feedHasPhoto));
    paramContentValues.put("feedPhotoUrl", paramawbv.feedPhotoUrl);
    paramContentValues.put("isAdded2C2C", Boolean.valueOf(paramawbv.isAdded2C2C));
    paramContentValues.put("chatInputType", Integer.valueOf(paramawbv.chatInputType));
    paramContentValues.put("showC2CPanel", Integer.valueOf(paramawbv.showC2CPanel));
    paramContentValues.put("pttChangeVoiceType", Integer.valueOf(paramawbv.pttChangeVoiceType));
    paramContentValues.put("audioPanelType", Integer.valueOf(paramawbv.audioPanelType));
    paramContentValues.put("openDoNotDisturbTime", Long.valueOf(paramawbv.openDoNotDisturbTime));
    paramContentValues.put("latestPLUpdateTimestamp", Long.valueOf(paramawbv.latestPLUpdateTimestamp));
    paramContentValues.put("lastPullPLNewsTimestamp", Long.valueOf(paramawbv.lastPullPLNewsTimestamp));
    paramContentValues.put("lastPLNewsTimestamp", Long.valueOf(paramawbv.lastPLNewsTimestamp));
    paramContentValues.put("medalUpdateTimestamp", Long.valueOf(paramawbv.medalUpdateTimestamp));
    paramContentValues.put("lastMedalTimestamp", Long.valueOf(paramawbv.lastMedalTimestamp));
    paramContentValues.put("diyFontTimestampBytes", paramawbv.diyFontTimestampBytes);
    paramContentValues.put("diyFontConfigBytes", paramawbv.diyFontConfigBytes);
    paramContentValues.put("lastIceBreakCheckTs", Long.valueOf(paramawbv.lastIceBreakCheckTs));
    paramContentValues.put("lastIceBreakChatTs", Long.valueOf(paramawbv.lastIceBreakChatTs));
    paramContentValues.put("makeFrdsTs", Long.valueOf(paramawbv.makeFrdsTs));
    paramContentValues.put("topPositionTime", Long.valueOf(paramawbv.topPositionTime));
    paramContentValues.put("isListenTogetherOpen", Boolean.valueOf(paramawbv.isListenTogetherOpen));
    paramContentValues.put("isSharingLocation", Integer.valueOf(paramawbv.isSharingLocation));
    paramContentValues.put("lastShareLbsMsgUniseq", Long.valueOf(paramawbv.lastShareLbsMsgUniseq));
    paramContentValues.put("mTogetherBusinessFlag", Long.valueOf(paramawbv.mTogetherBusinessFlag));
    paramContentValues.put("messageEnablePreview", Boolean.valueOf(paramawbv.messageEnablePreview));
    paramContentValues.put("messageEnableSound", Boolean.valueOf(paramawbv.messageEnableSound));
    paramContentValues.put("messageEnableVibrate", Boolean.valueOf(paramawbv.messageEnableVibrate));
    paramContentValues.put("friendRingId", Integer.valueOf(paramawbv.friendRingId));
    paramContentValues.put("messageEnablePreviewNew", Integer.valueOf(paramawbv.messageEnablePreviewNew));
    paramContentValues.put("messageEnableSoundNew", Integer.valueOf(paramawbv.messageEnableSoundNew));
    paramContentValues.put("messageEnableVibrateNew", Integer.valueOf(paramawbv.messageEnableVibrateNew));
    paramContentValues.put("hiddenChatSwitch", Integer.valueOf(paramawbv.hiddenChatSwitch));
    paramContentValues.put("intimate_type", Integer.valueOf(paramawbv.intimate_type));
    paramContentValues.put("intimate_level", Integer.valueOf(paramawbv.intimate_level));
    paramContentValues.put("intimate_chatDays", Integer.valueOf(paramawbv.intimate_chatDays));
    paramContentValues.put("last_intimate_chatTime", Long.valueOf(paramawbv.last_intimate_chatTime));
    paramContentValues.put("isExtinguish", Boolean.valueOf(paramawbv.isExtinguish));
    paramContentValues.put("friendshipLevel", Integer.valueOf(paramawbv.friendshipLevel));
    paramContentValues.put("friendshipChatDays", Integer.valueOf(paramawbv.friendshipChatDays));
    paramContentValues.put("lastFriendshipTime", Long.valueOf(paramawbv.lastFriendshipTime));
    paramContentValues.put("chatHotLevel", Integer.valueOf(paramawbv.chatHotLevel));
    paramContentValues.put("chatDays", Integer.valueOf(paramawbv.chatDays));
    paramContentValues.put("lastChatTime", Long.valueOf(paramawbv.lastChatTime));
    paramContentValues.put("praiseHotLevel", Integer.valueOf(paramawbv.praiseHotLevel));
    paramContentValues.put("praiseDays", Integer.valueOf(paramawbv.praiseDays));
    paramContentValues.put("lastpraiseTime", Long.valueOf(paramawbv.lastpraiseTime));
    paramContentValues.put("loverChatLevel", Integer.valueOf(paramawbv.loverChatLevel));
    paramContentValues.put("loverChatDays", Integer.valueOf(paramawbv.loverChatDays));
    paramContentValues.put("loverLastChatTime", Long.valueOf(paramawbv.loverLastChatTime));
    paramContentValues.put("loverFlag", Integer.valueOf(paramawbv.loverFlag));
    paramContentValues.put("loverTransFlag", Boolean.valueOf(paramawbv.loverTransFlag));
    paramContentValues.put("qzoneVisitType", Integer.valueOf(paramawbv.qzoneVisitType));
    paramContentValues.put("qzoneHotDays", Integer.valueOf(paramawbv.qzoneHotDays));
    paramContentValues.put("lastQzoneVisitTime", Long.valueOf(paramawbv.lastQzoneVisitTime));
    paramContentValues.put("bestIntimacyType", Integer.valueOf(paramawbv.bestIntimacyType));
    paramContentValues.put("bestIntimacyDays", Integer.valueOf(paramawbv.bestIntimacyDays));
    paramContentValues.put("newBestIntimacyType", Integer.valueOf(paramawbv.newBestIntimacyType));
    paramContentValues.put("hasRemindChat", Boolean.valueOf(paramawbv.hasRemindChat));
    paramContentValues.put("hasRemindLoverChat", Boolean.valueOf(paramawbv.hasRemindLoverChat));
    paramContentValues.put("hasRemindPraise", Boolean.valueOf(paramawbv.hasRemindPraise));
    paramContentValues.put("hasRemindQzoneVisit", Boolean.valueOf(paramawbv.hasRemindQzoneVisit));
    paramContentValues.put("hasRemindFrdship", Boolean.valueOf(paramawbv.hasRemindFrdship));
    paramContentValues.put("hasRemindIntimate", Boolean.valueOf(paramawbv.hasRemindIntimate));
    paramContentValues.put("localChatSendTs", Long.valueOf(paramawbv.localChatSendTs));
    paramContentValues.put("localChatRecTs", Long.valueOf(paramawbv.localChatRecTs));
    paramContentValues.put("lastHotReactiveReCheckInTs", Long.valueOf(paramawbv.lastHotReactiveReCheckInTs));
    paramContentValues.put("isGrayTipRemind", Integer.valueOf(paramawbv.isGrayTipRemind));
    paramContentValues.put("isGrayTipMultiRemind", Integer.valueOf(paramawbv.isGrayTipMultiRemind));
    paramContentValues.put("mutual_marks_store_json", paramawbv.mutual_marks_store_json);
    paramContentValues.put("mutual_mark_version", Integer.valueOf(paramawbv.mutual_mark_version));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awca
 * JD-Core Version:    0.7.0.1
 */