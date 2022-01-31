import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukt
  extends aula
{
  public aukt()
  {
    this.a = 88;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramauko = (ExtensionInfo)paramauko;
    if (paramaukz == null)
    {
      paramauko.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramauko.pendantId = paramCursor.getLong(paramCursor.getColumnIndex("pendantId"));
      paramauko.pendantDiyId = paramCursor.getInt(paramCursor.getColumnIndex("pendantDiyId"));
      paramauko.uVipFont = paramCursor.getLong(paramCursor.getColumnIndex("uVipFont"));
      paramauko.vipFontType = paramCursor.getInt(paramCursor.getColumnIndex("vipFontType"));
      paramauko.magicFont = paramCursor.getInt(paramCursor.getColumnIndex("magicFont"));
      paramauko.lastUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("lastUpdateTime"));
      paramauko.fontEffect = paramCursor.getInt(paramCursor.getColumnIndex("fontEffect"));
      paramauko.fontEffectLastUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("fontEffectLastUpdateTime"));
      paramauko.faceId = paramCursor.getInt(paramCursor.getColumnIndex("faceId"));
      paramauko.faceIdUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("faceIdUpdateTime"));
      paramauko.colorRingId = paramCursor.getLong(paramCursor.getColumnIndex("colorRingId"));
      paramauko.commingRingId = paramCursor.getLong(paramCursor.getColumnIndex("commingRingId"));
      paramauko.timestamp = paramCursor.getLong(paramCursor.getColumnIndex("timestamp"));
      paramauko.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
      paramauko.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
      paramauko.feedType = paramCursor.getInt(paramCursor.getColumnIndex("feedType"));
      paramauko.feedTime = paramCursor.getLong(paramCursor.getColumnIndex("feedTime"));
      paramauko.feedContent = paramCursor.getString(paramCursor.getColumnIndex("feedContent"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("feedHasPhoto")))
      {
        paramBoolean = true;
        paramauko.feedHasPhoto = paramBoolean;
        paramauko.feedPhotoUrl = paramCursor.getString(paramCursor.getColumnIndex("feedPhotoUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isAdded2C2C"))) {
          break label1742;
        }
        paramBoolean = true;
        label421:
        paramauko.isAdded2C2C = paramBoolean;
        paramauko.chatInputType = paramCursor.getInt(paramCursor.getColumnIndex("chatInputType"));
        paramauko.showC2CPanel = paramCursor.getInt(paramCursor.getColumnIndex("showC2CPanel"));
        paramauko.pttChangeVoiceType = paramCursor.getInt(paramCursor.getColumnIndex("pttChangeVoiceType"));
        paramauko.audioPanelType = paramCursor.getInt(paramCursor.getColumnIndex("audioPanelType"));
        paramauko.openDoNotDisturbTime = paramCursor.getLong(paramCursor.getColumnIndex("openDoNotDisturbTime"));
        paramauko.latestPLUpdateTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("latestPLUpdateTimestamp"));
        paramauko.lastPullPLNewsTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastPullPLNewsTimestamp"));
        paramauko.lastPLNewsTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastPLNewsTimestamp"));
        paramauko.medalUpdateTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("medalUpdateTimestamp"));
        paramauko.lastMedalTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastMedalTimestamp"));
        paramauko.diyFontTimestampBytes = paramCursor.getBlob(paramCursor.getColumnIndex("diyFontTimestampBytes"));
        paramauko.diyFontConfigBytes = paramCursor.getBlob(paramCursor.getColumnIndex("diyFontConfigBytes"));
        paramauko.lastIceBreakCheckTs = paramCursor.getLong(paramCursor.getColumnIndex("lastIceBreakCheckTs"));
        paramauko.lastIceBreakChatTs = paramCursor.getLong(paramCursor.getColumnIndex("lastIceBreakChatTs"));
        paramauko.makeFrdsTs = paramCursor.getLong(paramCursor.getColumnIndex("makeFrdsTs"));
        paramauko.topPositionTime = paramCursor.getLong(paramCursor.getColumnIndex("topPositionTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isListenTogetherOpen"))) {
          break label1747;
        }
        paramBoolean = true;
        label734:
        paramauko.isListenTogetherOpen = paramBoolean;
        paramauko.isSharingLocation = paramCursor.getInt(paramCursor.getColumnIndex("isSharingLocation"));
        paramauko.lastShareLbsMsgUniseq = paramCursor.getLong(paramCursor.getColumnIndex("lastShareLbsMsgUniseq"));
        paramauko.mTogetherBusinessFlag = paramCursor.getLong(paramCursor.getColumnIndex("mTogetherBusinessFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnablePreview"))) {
          break label1752;
        }
        paramBoolean = true;
        label813:
        paramauko.messageEnablePreview = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnableSound"))) {
          break label1757;
        }
        paramBoolean = true;
        label838:
        paramauko.messageEnableSound = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnableVibrate"))) {
          break label1762;
        }
        paramBoolean = true;
        label863:
        paramauko.messageEnableVibrate = paramBoolean;
        paramauko.friendRingId = paramCursor.getInt(paramCursor.getColumnIndex("friendRingId"));
        paramauko.messageEnablePreviewNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnablePreviewNew"));
        paramauko.messageEnableSoundNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnableSoundNew"));
        paramauko.messageEnableVibrateNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnableVibrateNew"));
        paramauko.hiddenChatSwitch = paramCursor.getInt(paramCursor.getColumnIndex("hiddenChatSwitch"));
        paramauko.intimate_type = paramCursor.getInt(paramCursor.getColumnIndex("intimate_type"));
        paramauko.intimate_level = paramCursor.getInt(paramCursor.getColumnIndex("intimate_level"));
        paramauko.intimate_chatDays = paramCursor.getInt(paramCursor.getColumnIndex("intimate_chatDays"));
        paramauko.last_intimate_chatTime = paramCursor.getLong(paramCursor.getColumnIndex("last_intimate_chatTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isExtinguish"))) {
          break label1767;
        }
        paramBoolean = true;
        label1053:
        paramauko.isExtinguish = paramBoolean;
        paramauko.friendshipLevel = paramCursor.getInt(paramCursor.getColumnIndex("friendshipLevel"));
        paramauko.friendshipChatDays = paramCursor.getInt(paramCursor.getColumnIndex("friendshipChatDays"));
        paramauko.lastFriendshipTime = paramCursor.getLong(paramCursor.getColumnIndex("lastFriendshipTime"));
        paramauko.chatHotLevel = paramCursor.getInt(paramCursor.getColumnIndex("chatHotLevel"));
        paramauko.chatDays = paramCursor.getInt(paramCursor.getColumnIndex("chatDays"));
        paramauko.lastChatTime = paramCursor.getLong(paramCursor.getColumnIndex("lastChatTime"));
        paramauko.praiseHotLevel = paramCursor.getInt(paramCursor.getColumnIndex("praiseHotLevel"));
        paramauko.praiseDays = paramCursor.getInt(paramCursor.getColumnIndex("praiseDays"));
        paramauko.lastpraiseTime = paramCursor.getLong(paramCursor.getColumnIndex("lastpraiseTime"));
        paramauko.loverChatLevel = paramCursor.getInt(paramCursor.getColumnIndex("loverChatLevel"));
        paramauko.loverChatDays = paramCursor.getInt(paramCursor.getColumnIndex("loverChatDays"));
        paramauko.loverLastChatTime = paramCursor.getLong(paramCursor.getColumnIndex("loverLastChatTime"));
        paramauko.loverFlag = paramCursor.getInt(paramCursor.getColumnIndex("loverFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("loverTransFlag"))) {
          break label1772;
        }
        paramBoolean = true;
        label1326:
        paramauko.loverTransFlag = paramBoolean;
        paramauko.qzoneVisitType = paramCursor.getInt(paramCursor.getColumnIndex("qzoneVisitType"));
        paramauko.qzoneHotDays = paramCursor.getInt(paramCursor.getColumnIndex("qzoneHotDays"));
        paramauko.lastQzoneVisitTime = paramCursor.getLong(paramCursor.getColumnIndex("lastQzoneVisitTime"));
        paramauko.bestIntimacyType = paramCursor.getInt(paramCursor.getColumnIndex("bestIntimacyType"));
        paramauko.bestIntimacyDays = paramCursor.getInt(paramCursor.getColumnIndex("bestIntimacyDays"));
        paramauko.newBestIntimacyType = paramCursor.getInt(paramCursor.getColumnIndex("newBestIntimacyType"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindChat"))) {
          break label1777;
        }
        paramBoolean = true;
        label1466:
        paramauko.hasRemindChat = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindLoverChat"))) {
          break label1782;
        }
        paramBoolean = true;
        label1492:
        paramauko.hasRemindLoverChat = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindPraise"))) {
          break label1787;
        }
        paramBoolean = true;
        label1518:
        paramauko.hasRemindPraise = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindQzoneVisit"))) {
          break label1792;
        }
        paramBoolean = true;
        label1544:
        paramauko.hasRemindQzoneVisit = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindFrdship"))) {
          break label1797;
        }
        paramBoolean = true;
        label1570:
        paramauko.hasRemindFrdship = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindIntimate"))) {
          break label1802;
        }
      }
      label1792:
      label1797:
      label1802:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramauko.hasRemindIntimate = paramBoolean;
        paramauko.localChatSendTs = paramCursor.getLong(paramCursor.getColumnIndex("localChatSendTs"));
        paramauko.localChatRecTs = paramCursor.getLong(paramCursor.getColumnIndex("localChatRecTs"));
        paramauko.lastHotReactiveReCheckInTs = paramCursor.getLong(paramCursor.getColumnIndex("lastHotReactiveReCheckInTs"));
        paramauko.isGrayTipRemind = paramCursor.getInt(paramCursor.getColumnIndex("isGrayTipRemind"));
        paramauko.isGrayTipMultiRemind = paramCursor.getInt(paramCursor.getColumnIndex("isGrayTipMultiRemind"));
        paramauko.mutual_marks_store_json = paramCursor.getString(paramCursor.getColumnIndex("mutual_marks_store_json"));
        paramauko.mutual_mark_version = paramCursor.getInt(paramCursor.getColumnIndex("mutual_mark_version"));
        return paramauko;
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
      paramaukz.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("pendantId");
      if (i != -1) {
        break label4976;
      }
      paramaukz.a(new NoColumnError("pendantId", Long.TYPE));
      label1877:
      i = paramCursor.getColumnIndex("pendantDiyId");
      if (i != -1) {
        break label4991;
      }
      paramaukz.a(new NoColumnError("pendantDiyId", Integer.TYPE));
      label1912:
      i = paramCursor.getColumnIndex("uVipFont");
      if (i != -1) {
        break label5006;
      }
      paramaukz.a(new NoColumnError("uVipFont", Long.TYPE));
      label1947:
      i = paramCursor.getColumnIndex("vipFontType");
      if (i != -1) {
        break label5021;
      }
      paramaukz.a(new NoColumnError("vipFontType", Integer.TYPE));
      label1982:
      i = paramCursor.getColumnIndex("magicFont");
      if (i != -1) {
        break label5036;
      }
      paramaukz.a(new NoColumnError("magicFont", Integer.TYPE));
      label2017:
      i = paramCursor.getColumnIndex("lastUpdateTime");
      if (i != -1) {
        break label5051;
      }
      paramaukz.a(new NoColumnError("lastUpdateTime", Long.TYPE));
      label2052:
      i = paramCursor.getColumnIndex("fontEffect");
      if (i != -1) {
        break label5066;
      }
      paramaukz.a(new NoColumnError("fontEffect", Integer.TYPE));
      label2087:
      i = paramCursor.getColumnIndex("fontEffectLastUpdateTime");
      if (i != -1) {
        break label5081;
      }
      paramaukz.a(new NoColumnError("fontEffectLastUpdateTime", Long.TYPE));
      label2122:
      i = paramCursor.getColumnIndex("faceId");
      if (i != -1) {
        break label5096;
      }
      paramaukz.a(new NoColumnError("faceId", Integer.TYPE));
      label2157:
      i = paramCursor.getColumnIndex("faceIdUpdateTime");
      if (i != -1) {
        break label5111;
      }
      paramaukz.a(new NoColumnError("faceIdUpdateTime", Long.TYPE));
      label2192:
      i = paramCursor.getColumnIndex("colorRingId");
      if (i != -1) {
        break label5126;
      }
      paramaukz.a(new NoColumnError("colorRingId", Long.TYPE));
      label2227:
      i = paramCursor.getColumnIndex("commingRingId");
      if (i != -1) {
        break label5141;
      }
      paramaukz.a(new NoColumnError("commingRingId", Long.TYPE));
      label2262:
      i = paramCursor.getColumnIndex("timestamp");
      if (i != -1) {
        break label5156;
      }
      paramaukz.a(new NoColumnError("timestamp", Long.TYPE));
      label2297:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label5171;
      }
      paramaukz.a(new NoColumnError("richTime", Long.TYPE));
      label2332:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label5186;
      }
      paramaukz.a(new NoColumnError("richBuffer", [B.class));
      label2367:
      i = paramCursor.getColumnIndex("feedType");
      if (i != -1) {
        break label5201;
      }
      paramaukz.a(new NoColumnError("feedType", Integer.TYPE));
      label2402:
      i = paramCursor.getColumnIndex("feedTime");
      if (i != -1) {
        break label5216;
      }
      paramaukz.a(new NoColumnError("feedTime", Long.TYPE));
      label2437:
      i = paramCursor.getColumnIndex("feedContent");
      if (i != -1) {
        break label5231;
      }
      paramaukz.a(new NoColumnError("feedContent", String.class));
      label2472:
      i = paramCursor.getColumnIndex("feedHasPhoto");
      if (i != -1) {
        break label5246;
      }
      paramaukz.a(new NoColumnError("feedHasPhoto", Boolean.TYPE));
      i = paramCursor.getColumnIndex("feedPhotoUrl");
      if (i != -1) {
        break label5273;
      }
      paramaukz.a(new NoColumnError("feedPhotoUrl", String.class));
      label2542:
      i = paramCursor.getColumnIndex("isAdded2C2C");
      if (i != -1) {
        break label5288;
      }
      paramaukz.a(new NoColumnError("isAdded2C2C", Boolean.TYPE));
      i = paramCursor.getColumnIndex("chatInputType");
      if (i != -1) {
        break label5315;
      }
      paramaukz.a(new NoColumnError("chatInputType", Integer.TYPE));
      label2612:
      i = paramCursor.getColumnIndex("showC2CPanel");
      if (i != -1) {
        break label5330;
      }
      paramaukz.a(new NoColumnError("showC2CPanel", Integer.TYPE));
      label2647:
      i = paramCursor.getColumnIndex("pttChangeVoiceType");
      if (i != -1) {
        break label5345;
      }
      paramaukz.a(new NoColumnError("pttChangeVoiceType", Integer.TYPE));
      label2682:
      i = paramCursor.getColumnIndex("audioPanelType");
      if (i != -1) {
        break label5360;
      }
      paramaukz.a(new NoColumnError("audioPanelType", Integer.TYPE));
      label2717:
      i = paramCursor.getColumnIndex("openDoNotDisturbTime");
      if (i != -1) {
        break label5375;
      }
      paramaukz.a(new NoColumnError("openDoNotDisturbTime", Long.TYPE));
      label2752:
      i = paramCursor.getColumnIndex("latestPLUpdateTimestamp");
      if (i != -1) {
        break label5390;
      }
      paramaukz.a(new NoColumnError("latestPLUpdateTimestamp", Long.TYPE));
      label2787:
      i = paramCursor.getColumnIndex("lastPullPLNewsTimestamp");
      if (i != -1) {
        break label5405;
      }
      paramaukz.a(new NoColumnError("lastPullPLNewsTimestamp", Long.TYPE));
      label2822:
      i = paramCursor.getColumnIndex("lastPLNewsTimestamp");
      if (i != -1) {
        break label5420;
      }
      paramaukz.a(new NoColumnError("lastPLNewsTimestamp", Long.TYPE));
      label2857:
      i = paramCursor.getColumnIndex("medalUpdateTimestamp");
      if (i != -1) {
        break label5435;
      }
      paramaukz.a(new NoColumnError("medalUpdateTimestamp", Long.TYPE));
      label2892:
      i = paramCursor.getColumnIndex("lastMedalTimestamp");
      if (i != -1) {
        break label5450;
      }
      paramaukz.a(new NoColumnError("lastMedalTimestamp", Long.TYPE));
      label2927:
      i = paramCursor.getColumnIndex("diyFontTimestampBytes");
      if (i != -1) {
        break label5465;
      }
      paramaukz.a(new NoColumnError("diyFontTimestampBytes", [B.class));
      label2962:
      i = paramCursor.getColumnIndex("diyFontConfigBytes");
      if (i != -1) {
        break label5480;
      }
      paramaukz.a(new NoColumnError("diyFontConfigBytes", [B.class));
      label2997:
      i = paramCursor.getColumnIndex("lastIceBreakCheckTs");
      if (i != -1) {
        break label5495;
      }
      paramaukz.a(new NoColumnError("lastIceBreakCheckTs", Long.TYPE));
      label3032:
      i = paramCursor.getColumnIndex("lastIceBreakChatTs");
      if (i != -1) {
        break label5510;
      }
      paramaukz.a(new NoColumnError("lastIceBreakChatTs", Long.TYPE));
      label3067:
      i = paramCursor.getColumnIndex("makeFrdsTs");
      if (i != -1) {
        break label5525;
      }
      paramaukz.a(new NoColumnError("makeFrdsTs", Long.TYPE));
      label3102:
      i = paramCursor.getColumnIndex("topPositionTime");
      if (i != -1) {
        break label5540;
      }
      paramaukz.a(new NoColumnError("topPositionTime", Long.TYPE));
      label3137:
      i = paramCursor.getColumnIndex("isListenTogetherOpen");
      if (i != -1) {
        break label5555;
      }
      paramaukz.a(new NoColumnError("isListenTogetherOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isSharingLocation");
      if (i != -1) {
        break label5582;
      }
      paramaukz.a(new NoColumnError("isSharingLocation", Integer.TYPE));
      label3207:
      i = paramCursor.getColumnIndex("lastShareLbsMsgUniseq");
      if (i != -1) {
        break label5597;
      }
      paramaukz.a(new NoColumnError("lastShareLbsMsgUniseq", Long.TYPE));
      label3242:
      i = paramCursor.getColumnIndex("mTogetherBusinessFlag");
      if (i != -1) {
        break label5612;
      }
      paramaukz.a(new NoColumnError("mTogetherBusinessFlag", Long.TYPE));
      label3277:
      i = paramCursor.getColumnIndex("messageEnablePreview");
      if (i != -1) {
        break label5627;
      }
      paramaukz.a(new NoColumnError("messageEnablePreview", Boolean.TYPE));
      i = paramCursor.getColumnIndex("messageEnableSound");
      if (i != -1) {
        break label5654;
      }
      paramaukz.a(new NoColumnError("messageEnableSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("messageEnableVibrate");
      if (i != -1) {
        break label5681;
      }
      paramaukz.a(new NoColumnError("messageEnableVibrate", Boolean.TYPE));
      i = paramCursor.getColumnIndex("friendRingId");
      if (i != -1) {
        break label5708;
      }
      paramaukz.a(new NoColumnError("friendRingId", Integer.TYPE));
      label3417:
      i = paramCursor.getColumnIndex("messageEnablePreviewNew");
      if (i != -1) {
        break label5723;
      }
      paramaukz.a(new NoColumnError("messageEnablePreviewNew", Integer.TYPE));
      label3452:
      i = paramCursor.getColumnIndex("messageEnableSoundNew");
      if (i != -1) {
        break label5738;
      }
      paramaukz.a(new NoColumnError("messageEnableSoundNew", Integer.TYPE));
      label3487:
      i = paramCursor.getColumnIndex("messageEnableVibrateNew");
      if (i != -1) {
        break label5753;
      }
      paramaukz.a(new NoColumnError("messageEnableVibrateNew", Integer.TYPE));
      label3522:
      i = paramCursor.getColumnIndex("hiddenChatSwitch");
      if (i != -1) {
        break label5768;
      }
      paramaukz.a(new NoColumnError("hiddenChatSwitch", Integer.TYPE));
      label3557:
      i = paramCursor.getColumnIndex("intimate_type");
      if (i != -1) {
        break label5783;
      }
      paramaukz.a(new NoColumnError("intimate_type", Integer.TYPE));
      label3592:
      i = paramCursor.getColumnIndex("intimate_level");
      if (i != -1) {
        break label5798;
      }
      paramaukz.a(new NoColumnError("intimate_level", Integer.TYPE));
      label3627:
      i = paramCursor.getColumnIndex("intimate_chatDays");
      if (i != -1) {
        break label5813;
      }
      paramaukz.a(new NoColumnError("intimate_chatDays", Integer.TYPE));
      label3664:
      i = paramCursor.getColumnIndex("last_intimate_chatTime");
      if (i != -1) {
        break label5828;
      }
      paramaukz.a(new NoColumnError("last_intimate_chatTime", Long.TYPE));
      label3701:
      i = paramCursor.getColumnIndex("isExtinguish");
      if (i != -1) {
        break label5843;
      }
      paramaukz.a(new NoColumnError("isExtinguish", Boolean.TYPE));
      i = paramCursor.getColumnIndex("friendshipLevel");
      if (i != -1) {
        break label5870;
      }
      paramaukz.a(new NoColumnError("friendshipLevel", Integer.TYPE));
      label3775:
      i = paramCursor.getColumnIndex("friendshipChatDays");
      if (i != -1) {
        break label5885;
      }
      paramaukz.a(new NoColumnError("friendshipChatDays", Integer.TYPE));
      label3812:
      i = paramCursor.getColumnIndex("lastFriendshipTime");
      if (i != -1) {
        break label5900;
      }
      paramaukz.a(new NoColumnError("lastFriendshipTime", Long.TYPE));
      label3849:
      i = paramCursor.getColumnIndex("chatHotLevel");
      if (i != -1) {
        break label5915;
      }
      paramaukz.a(new NoColumnError("chatHotLevel", Integer.TYPE));
      label3886:
      i = paramCursor.getColumnIndex("chatDays");
      if (i != -1) {
        break label5930;
      }
      paramaukz.a(new NoColumnError("chatDays", Integer.TYPE));
      label3923:
      i = paramCursor.getColumnIndex("lastChatTime");
      if (i != -1) {
        break label5945;
      }
      paramaukz.a(new NoColumnError("lastChatTime", Long.TYPE));
      label3960:
      i = paramCursor.getColumnIndex("praiseHotLevel");
      if (i != -1) {
        break label5960;
      }
      paramaukz.a(new NoColumnError("praiseHotLevel", Integer.TYPE));
      label3997:
      i = paramCursor.getColumnIndex("praiseDays");
      if (i != -1) {
        break label5975;
      }
      paramaukz.a(new NoColumnError("praiseDays", Integer.TYPE));
      label4034:
      i = paramCursor.getColumnIndex("lastpraiseTime");
      if (i != -1) {
        break label5990;
      }
      paramaukz.a(new NoColumnError("lastpraiseTime", Long.TYPE));
      label4071:
      i = paramCursor.getColumnIndex("loverChatLevel");
      if (i != -1) {
        break label6005;
      }
      paramaukz.a(new NoColumnError("loverChatLevel", Integer.TYPE));
      label4108:
      i = paramCursor.getColumnIndex("loverChatDays");
      if (i != -1) {
        break label6020;
      }
      paramaukz.a(new NoColumnError("loverChatDays", Integer.TYPE));
      label4145:
      i = paramCursor.getColumnIndex("loverLastChatTime");
      if (i != -1) {
        break label6035;
      }
      paramaukz.a(new NoColumnError("loverLastChatTime", Long.TYPE));
      label4182:
      i = paramCursor.getColumnIndex("loverFlag");
      if (i != -1) {
        break label6050;
      }
      paramaukz.a(new NoColumnError("loverFlag", Integer.TYPE));
      label4219:
      i = paramCursor.getColumnIndex("loverTransFlag");
      if (i != -1) {
        break label6065;
      }
      paramaukz.a(new NoColumnError("loverTransFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("qzoneVisitType");
      if (i != -1) {
        break label6092;
      }
      paramaukz.a(new NoColumnError("qzoneVisitType", Integer.TYPE));
      label4293:
      i = paramCursor.getColumnIndex("qzoneHotDays");
      if (i != -1) {
        break label6107;
      }
      paramaukz.a(new NoColumnError("qzoneHotDays", Integer.TYPE));
      label4330:
      i = paramCursor.getColumnIndex("lastQzoneVisitTime");
      if (i != -1) {
        break label6122;
      }
      paramaukz.a(new NoColumnError("lastQzoneVisitTime", Long.TYPE));
      label4367:
      i = paramCursor.getColumnIndex("bestIntimacyType");
      if (i != -1) {
        break label6137;
      }
      paramaukz.a(new NoColumnError("bestIntimacyType", Integer.TYPE));
      label4404:
      i = paramCursor.getColumnIndex("bestIntimacyDays");
      if (i != -1) {
        break label6152;
      }
      paramaukz.a(new NoColumnError("bestIntimacyDays", Integer.TYPE));
      label4441:
      i = paramCursor.getColumnIndex("newBestIntimacyType");
      if (i != -1) {
        break label6167;
      }
      paramaukz.a(new NoColumnError("newBestIntimacyType", Integer.TYPE));
      label4478:
      i = paramCursor.getColumnIndex("hasRemindChat");
      if (i != -1) {
        break label6182;
      }
      paramaukz.a(new NoColumnError("hasRemindChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindLoverChat");
      if (i != -1) {
        break label6209;
      }
      paramaukz.a(new NoColumnError("hasRemindLoverChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindPraise");
      if (i != -1) {
        break label6236;
      }
      paramaukz.a(new NoColumnError("hasRemindPraise", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindQzoneVisit");
      if (i != -1) {
        break label6263;
      }
      paramaukz.a(new NoColumnError("hasRemindQzoneVisit", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindFrdship");
      if (i != -1) {
        break label6290;
      }
      paramaukz.a(new NoColumnError("hasRemindFrdship", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindIntimate");
      if (i != -1) {
        break label6317;
      }
      paramaukz.a(new NoColumnError("hasRemindIntimate", Boolean.TYPE));
      i = paramCursor.getColumnIndex("localChatSendTs");
      if (i != -1) {
        break label6345;
      }
      paramaukz.a(new NoColumnError("localChatSendTs", Long.TYPE));
      label4737:
      i = paramCursor.getColumnIndex("localChatRecTs");
      if (i != -1) {
        break label6360;
      }
      paramaukz.a(new NoColumnError("localChatRecTs", Long.TYPE));
      label4774:
      i = paramCursor.getColumnIndex("lastHotReactiveReCheckInTs");
      if (i != -1) {
        break label6375;
      }
      paramaukz.a(new NoColumnError("lastHotReactiveReCheckInTs", Long.TYPE));
      label4811:
      i = paramCursor.getColumnIndex("isGrayTipRemind");
      if (i != -1) {
        break label6390;
      }
      paramaukz.a(new NoColumnError("isGrayTipRemind", Integer.TYPE));
      label4848:
      i = paramCursor.getColumnIndex("isGrayTipMultiRemind");
      if (i != -1) {
        break label6405;
      }
      paramaukz.a(new NoColumnError("isGrayTipMultiRemind", Integer.TYPE));
      label4885:
      i = paramCursor.getColumnIndex("mutual_marks_store_json");
      if (i != -1) {
        break label6420;
      }
      paramaukz.a(new NoColumnError("mutual_marks_store_json", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("mutual_mark_version");
      if (i != -1) {
        break label6435;
      }
      paramaukz.a(new NoColumnError("mutual_mark_version", Integer.TYPE));
      return paramauko;
      paramauko.uin = paramCursor.getString(i);
      break;
      label4976:
      paramauko.pendantId = paramCursor.getLong(i);
      break label1877;
      label4991:
      paramauko.pendantDiyId = paramCursor.getInt(i);
      break label1912;
      label5006:
      paramauko.uVipFont = paramCursor.getLong(i);
      break label1947;
      label5021:
      paramauko.vipFontType = paramCursor.getInt(i);
      break label1982;
      label5036:
      paramauko.magicFont = paramCursor.getInt(i);
      break label2017;
      label5051:
      paramauko.lastUpdateTime = paramCursor.getLong(i);
      break label2052;
      label5066:
      paramauko.fontEffect = paramCursor.getInt(i);
      break label2087;
      label5081:
      paramauko.fontEffectLastUpdateTime = paramCursor.getLong(i);
      break label2122;
      label5096:
      paramauko.faceId = paramCursor.getInt(i);
      break label2157;
      label5111:
      paramauko.faceIdUpdateTime = paramCursor.getLong(i);
      break label2192;
      label5126:
      paramauko.colorRingId = paramCursor.getLong(i);
      break label2227;
      label5141:
      paramauko.commingRingId = paramCursor.getLong(i);
      break label2262;
      label5156:
      paramauko.timestamp = paramCursor.getLong(i);
      break label2297;
      label5171:
      paramauko.richTime = paramCursor.getLong(i);
      break label2332;
      label5186:
      paramauko.richBuffer = paramCursor.getBlob(i);
      break label2367;
      label5201:
      paramauko.feedType = paramCursor.getInt(i);
      break label2402;
      label5216:
      paramauko.feedTime = paramCursor.getLong(i);
      break label2437;
      label5231:
      paramauko.feedContent = paramCursor.getString(i);
      break label2472;
      label5246:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.feedHasPhoto = paramBoolean;
        break;
      }
      label5273:
      paramauko.feedPhotoUrl = paramCursor.getString(i);
      break label2542;
      label5288:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isAdded2C2C = paramBoolean;
        break;
      }
      label5315:
      paramauko.chatInputType = paramCursor.getInt(i);
      break label2612;
      label5330:
      paramauko.showC2CPanel = paramCursor.getInt(i);
      break label2647;
      label5345:
      paramauko.pttChangeVoiceType = paramCursor.getInt(i);
      break label2682;
      label5360:
      paramauko.audioPanelType = paramCursor.getInt(i);
      break label2717;
      label5375:
      paramauko.openDoNotDisturbTime = paramCursor.getLong(i);
      break label2752;
      label5390:
      paramauko.latestPLUpdateTimestamp = paramCursor.getLong(i);
      break label2787;
      label5405:
      paramauko.lastPullPLNewsTimestamp = paramCursor.getLong(i);
      break label2822;
      label5420:
      paramauko.lastPLNewsTimestamp = paramCursor.getLong(i);
      break label2857;
      label5435:
      paramauko.medalUpdateTimestamp = paramCursor.getLong(i);
      break label2892;
      label5450:
      paramauko.lastMedalTimestamp = paramCursor.getLong(i);
      break label2927;
      label5465:
      paramauko.diyFontTimestampBytes = paramCursor.getBlob(i);
      break label2962;
      label5480:
      paramauko.diyFontConfigBytes = paramCursor.getBlob(i);
      break label2997;
      label5495:
      paramauko.lastIceBreakCheckTs = paramCursor.getLong(i);
      break label3032;
      label5510:
      paramauko.lastIceBreakChatTs = paramCursor.getLong(i);
      break label3067;
      label5525:
      paramauko.makeFrdsTs = paramCursor.getLong(i);
      break label3102;
      label5540:
      paramauko.topPositionTime = paramCursor.getLong(i);
      break label3137;
      label5555:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isListenTogetherOpen = paramBoolean;
        break;
      }
      label5582:
      paramauko.isSharingLocation = paramCursor.getInt(i);
      break label3207;
      label5597:
      paramauko.lastShareLbsMsgUniseq = paramCursor.getLong(i);
      break label3242;
      label5612:
      paramauko.mTogetherBusinessFlag = paramCursor.getLong(i);
      break label3277;
      label5627:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.messageEnablePreview = paramBoolean;
        break;
      }
      label5654:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.messageEnableSound = paramBoolean;
        break;
      }
      label5681:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.messageEnableVibrate = paramBoolean;
        break;
      }
      label5708:
      paramauko.friendRingId = paramCursor.getInt(i);
      break label3417;
      label5723:
      paramauko.messageEnablePreviewNew = paramCursor.getInt(i);
      break label3452;
      label5738:
      paramauko.messageEnableSoundNew = paramCursor.getInt(i);
      break label3487;
      label5753:
      paramauko.messageEnableVibrateNew = paramCursor.getInt(i);
      break label3522;
      label5768:
      paramauko.hiddenChatSwitch = paramCursor.getInt(i);
      break label3557;
      label5783:
      paramauko.intimate_type = paramCursor.getInt(i);
      break label3592;
      label5798:
      paramauko.intimate_level = paramCursor.getInt(i);
      break label3627;
      label5813:
      paramauko.intimate_chatDays = paramCursor.getInt(i);
      break label3664;
      label5828:
      paramauko.last_intimate_chatTime = paramCursor.getLong(i);
      break label3701;
      label5843:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isExtinguish = paramBoolean;
        break;
      }
      label5870:
      paramauko.friendshipLevel = paramCursor.getInt(i);
      break label3775;
      label5885:
      paramauko.friendshipChatDays = paramCursor.getInt(i);
      break label3812;
      label5900:
      paramauko.lastFriendshipTime = paramCursor.getLong(i);
      break label3849;
      label5915:
      paramauko.chatHotLevel = paramCursor.getInt(i);
      break label3886;
      label5930:
      paramauko.chatDays = paramCursor.getInt(i);
      break label3923;
      label5945:
      paramauko.lastChatTime = paramCursor.getLong(i);
      break label3960;
      label5960:
      paramauko.praiseHotLevel = paramCursor.getInt(i);
      break label3997;
      label5975:
      paramauko.praiseDays = paramCursor.getInt(i);
      break label4034;
      label5990:
      paramauko.lastpraiseTime = paramCursor.getLong(i);
      break label4071;
      label6005:
      paramauko.loverChatLevel = paramCursor.getInt(i);
      break label4108;
      label6020:
      paramauko.loverChatDays = paramCursor.getInt(i);
      break label4145;
      label6035:
      paramauko.loverLastChatTime = paramCursor.getLong(i);
      break label4182;
      label6050:
      paramauko.loverFlag = paramCursor.getInt(i);
      break label4219;
      label6065:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.loverTransFlag = paramBoolean;
        break;
      }
      label6092:
      paramauko.qzoneVisitType = paramCursor.getInt(i);
      break label4293;
      label6107:
      paramauko.qzoneHotDays = paramCursor.getInt(i);
      break label4330;
      label6122:
      paramauko.lastQzoneVisitTime = paramCursor.getLong(i);
      break label4367;
      label6137:
      paramauko.bestIntimacyType = paramCursor.getInt(i);
      break label4404;
      label6152:
      paramauko.bestIntimacyDays = paramCursor.getInt(i);
      break label4441;
      label6167:
      paramauko.newBestIntimacyType = paramCursor.getInt(i);
      break label4478;
      label6182:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.hasRemindChat = paramBoolean;
        break;
      }
      label6209:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.hasRemindLoverChat = paramBoolean;
        break;
      }
      label6236:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.hasRemindPraise = paramBoolean;
        break;
      }
      label6263:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.hasRemindQzoneVisit = paramBoolean;
        break;
      }
      label6290:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.hasRemindFrdship = paramBoolean;
        break;
      }
      label6317:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramauko.hasRemindIntimate = paramBoolean;
        break;
      }
      label6345:
      paramauko.localChatSendTs = paramCursor.getLong(i);
      break label4737;
      label6360:
      paramauko.localChatRecTs = paramCursor.getLong(i);
      break label4774;
      label6375:
      paramauko.lastHotReactiveReCheckInTs = paramCursor.getLong(i);
      break label4811;
      label6390:
      paramauko.isGrayTipRemind = paramCursor.getInt(i);
      break label4848;
      label6405:
      paramauko.isGrayTipMultiRemind = paramCursor.getInt(i);
      break label4885;
      label6420:
      paramauko.mutual_marks_store_json = paramCursor.getString(i);
    }
    label6435:
    paramauko.mutual_mark_version = paramCursor.getInt(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,pendantId INTEGER ,pendantDiyId INTEGER ,uVipFont INTEGER ,vipFontType INTEGER ,magicFont INTEGER ,lastUpdateTime INTEGER ,fontEffect INTEGER ,fontEffectLastUpdateTime INTEGER ,faceId INTEGER ,faceIdUpdateTime INTEGER ,colorRingId INTEGER ,commingRingId INTEGER ,timestamp INTEGER ,richTime INTEGER ,richBuffer BLOB ,feedType INTEGER ,feedTime INTEGER ,feedContent TEXT ,feedHasPhoto INTEGER ,feedPhotoUrl TEXT ,isAdded2C2C INTEGER ,chatInputType INTEGER ,showC2CPanel INTEGER ,pttChangeVoiceType INTEGER ,audioPanelType INTEGER ,openDoNotDisturbTime INTEGER ,latestPLUpdateTimestamp INTEGER ,lastPullPLNewsTimestamp INTEGER ,lastPLNewsTimestamp INTEGER ,medalUpdateTimestamp INTEGER ,lastMedalTimestamp INTEGER ,diyFontTimestampBytes BLOB ,diyFontConfigBytes BLOB ,lastIceBreakCheckTs INTEGER ,lastIceBreakChatTs INTEGER ,makeFrdsTs INTEGER ,topPositionTime INTEGER ,isListenTogetherOpen INTEGER ,isSharingLocation INTEGER ,lastShareLbsMsgUniseq INTEGER ,mTogetherBusinessFlag INTEGER ,messageEnablePreview INTEGER ,messageEnableSound INTEGER ,messageEnableVibrate INTEGER ,friendRingId INTEGER ,messageEnablePreviewNew INTEGER ,messageEnableSoundNew INTEGER ,messageEnableVibrateNew INTEGER ,hiddenChatSwitch INTEGER ,intimate_type INTEGER ,intimate_level INTEGER ,intimate_chatDays INTEGER ,last_intimate_chatTime INTEGER ,isExtinguish INTEGER ,friendshipLevel INTEGER ,friendshipChatDays INTEGER ,lastFriendshipTime INTEGER ,chatHotLevel INTEGER ,chatDays INTEGER ,lastChatTime INTEGER ,praiseHotLevel INTEGER ,praiseDays INTEGER ,lastpraiseTime INTEGER ,loverChatLevel INTEGER ,loverChatDays INTEGER ,loverLastChatTime INTEGER ,loverFlag INTEGER ,loverTransFlag INTEGER ,qzoneVisitType INTEGER ,qzoneHotDays INTEGER ,lastQzoneVisitTime INTEGER ,bestIntimacyType INTEGER ,bestIntimacyDays INTEGER ,newBestIntimacyType INTEGER ,hasRemindChat INTEGER ,hasRemindLoverChat INTEGER ,hasRemindPraise INTEGER ,hasRemindQzoneVisit INTEGER ,hasRemindFrdship INTEGER ,hasRemindIntimate INTEGER ,localChatSendTs INTEGER ,localChatRecTs INTEGER ,lastHotReactiveReCheckInTs INTEGER ,isGrayTipRemind INTEGER ,isGrayTipMultiRemind INTEGER ,mutual_marks_store_json TEXT ,mutual_mark_version INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (ExtensionInfo)paramauko;
    paramContentValues.put("uin", paramauko.uin);
    paramContentValues.put("pendantId", Long.valueOf(paramauko.pendantId));
    paramContentValues.put("pendantDiyId", Integer.valueOf(paramauko.pendantDiyId));
    paramContentValues.put("uVipFont", Long.valueOf(paramauko.uVipFont));
    paramContentValues.put("vipFontType", Integer.valueOf(paramauko.vipFontType));
    paramContentValues.put("magicFont", Integer.valueOf(paramauko.magicFont));
    paramContentValues.put("lastUpdateTime", Long.valueOf(paramauko.lastUpdateTime));
    paramContentValues.put("fontEffect", Integer.valueOf(paramauko.fontEffect));
    paramContentValues.put("fontEffectLastUpdateTime", Long.valueOf(paramauko.fontEffectLastUpdateTime));
    paramContentValues.put("faceId", Integer.valueOf(paramauko.faceId));
    paramContentValues.put("faceIdUpdateTime", Long.valueOf(paramauko.faceIdUpdateTime));
    paramContentValues.put("colorRingId", Long.valueOf(paramauko.colorRingId));
    paramContentValues.put("commingRingId", Long.valueOf(paramauko.commingRingId));
    paramContentValues.put("timestamp", Long.valueOf(paramauko.timestamp));
    paramContentValues.put("richTime", Long.valueOf(paramauko.richTime));
    paramContentValues.put("richBuffer", paramauko.richBuffer);
    paramContentValues.put("feedType", Integer.valueOf(paramauko.feedType));
    paramContentValues.put("feedTime", Long.valueOf(paramauko.feedTime));
    paramContentValues.put("feedContent", paramauko.feedContent);
    paramContentValues.put("feedHasPhoto", Boolean.valueOf(paramauko.feedHasPhoto));
    paramContentValues.put("feedPhotoUrl", paramauko.feedPhotoUrl);
    paramContentValues.put("isAdded2C2C", Boolean.valueOf(paramauko.isAdded2C2C));
    paramContentValues.put("chatInputType", Integer.valueOf(paramauko.chatInputType));
    paramContentValues.put("showC2CPanel", Integer.valueOf(paramauko.showC2CPanel));
    paramContentValues.put("pttChangeVoiceType", Integer.valueOf(paramauko.pttChangeVoiceType));
    paramContentValues.put("audioPanelType", Integer.valueOf(paramauko.audioPanelType));
    paramContentValues.put("openDoNotDisturbTime", Long.valueOf(paramauko.openDoNotDisturbTime));
    paramContentValues.put("latestPLUpdateTimestamp", Long.valueOf(paramauko.latestPLUpdateTimestamp));
    paramContentValues.put("lastPullPLNewsTimestamp", Long.valueOf(paramauko.lastPullPLNewsTimestamp));
    paramContentValues.put("lastPLNewsTimestamp", Long.valueOf(paramauko.lastPLNewsTimestamp));
    paramContentValues.put("medalUpdateTimestamp", Long.valueOf(paramauko.medalUpdateTimestamp));
    paramContentValues.put("lastMedalTimestamp", Long.valueOf(paramauko.lastMedalTimestamp));
    paramContentValues.put("diyFontTimestampBytes", paramauko.diyFontTimestampBytes);
    paramContentValues.put("diyFontConfigBytes", paramauko.diyFontConfigBytes);
    paramContentValues.put("lastIceBreakCheckTs", Long.valueOf(paramauko.lastIceBreakCheckTs));
    paramContentValues.put("lastIceBreakChatTs", Long.valueOf(paramauko.lastIceBreakChatTs));
    paramContentValues.put("makeFrdsTs", Long.valueOf(paramauko.makeFrdsTs));
    paramContentValues.put("topPositionTime", Long.valueOf(paramauko.topPositionTime));
    paramContentValues.put("isListenTogetherOpen", Boolean.valueOf(paramauko.isListenTogetherOpen));
    paramContentValues.put("isSharingLocation", Integer.valueOf(paramauko.isSharingLocation));
    paramContentValues.put("lastShareLbsMsgUniseq", Long.valueOf(paramauko.lastShareLbsMsgUniseq));
    paramContentValues.put("mTogetherBusinessFlag", Long.valueOf(paramauko.mTogetherBusinessFlag));
    paramContentValues.put("messageEnablePreview", Boolean.valueOf(paramauko.messageEnablePreview));
    paramContentValues.put("messageEnableSound", Boolean.valueOf(paramauko.messageEnableSound));
    paramContentValues.put("messageEnableVibrate", Boolean.valueOf(paramauko.messageEnableVibrate));
    paramContentValues.put("friendRingId", Integer.valueOf(paramauko.friendRingId));
    paramContentValues.put("messageEnablePreviewNew", Integer.valueOf(paramauko.messageEnablePreviewNew));
    paramContentValues.put("messageEnableSoundNew", Integer.valueOf(paramauko.messageEnableSoundNew));
    paramContentValues.put("messageEnableVibrateNew", Integer.valueOf(paramauko.messageEnableVibrateNew));
    paramContentValues.put("hiddenChatSwitch", Integer.valueOf(paramauko.hiddenChatSwitch));
    paramContentValues.put("intimate_type", Integer.valueOf(paramauko.intimate_type));
    paramContentValues.put("intimate_level", Integer.valueOf(paramauko.intimate_level));
    paramContentValues.put("intimate_chatDays", Integer.valueOf(paramauko.intimate_chatDays));
    paramContentValues.put("last_intimate_chatTime", Long.valueOf(paramauko.last_intimate_chatTime));
    paramContentValues.put("isExtinguish", Boolean.valueOf(paramauko.isExtinguish));
    paramContentValues.put("friendshipLevel", Integer.valueOf(paramauko.friendshipLevel));
    paramContentValues.put("friendshipChatDays", Integer.valueOf(paramauko.friendshipChatDays));
    paramContentValues.put("lastFriendshipTime", Long.valueOf(paramauko.lastFriendshipTime));
    paramContentValues.put("chatHotLevel", Integer.valueOf(paramauko.chatHotLevel));
    paramContentValues.put("chatDays", Integer.valueOf(paramauko.chatDays));
    paramContentValues.put("lastChatTime", Long.valueOf(paramauko.lastChatTime));
    paramContentValues.put("praiseHotLevel", Integer.valueOf(paramauko.praiseHotLevel));
    paramContentValues.put("praiseDays", Integer.valueOf(paramauko.praiseDays));
    paramContentValues.put("lastpraiseTime", Long.valueOf(paramauko.lastpraiseTime));
    paramContentValues.put("loverChatLevel", Integer.valueOf(paramauko.loverChatLevel));
    paramContentValues.put("loverChatDays", Integer.valueOf(paramauko.loverChatDays));
    paramContentValues.put("loverLastChatTime", Long.valueOf(paramauko.loverLastChatTime));
    paramContentValues.put("loverFlag", Integer.valueOf(paramauko.loverFlag));
    paramContentValues.put("loverTransFlag", Boolean.valueOf(paramauko.loverTransFlag));
    paramContentValues.put("qzoneVisitType", Integer.valueOf(paramauko.qzoneVisitType));
    paramContentValues.put("qzoneHotDays", Integer.valueOf(paramauko.qzoneHotDays));
    paramContentValues.put("lastQzoneVisitTime", Long.valueOf(paramauko.lastQzoneVisitTime));
    paramContentValues.put("bestIntimacyType", Integer.valueOf(paramauko.bestIntimacyType));
    paramContentValues.put("bestIntimacyDays", Integer.valueOf(paramauko.bestIntimacyDays));
    paramContentValues.put("newBestIntimacyType", Integer.valueOf(paramauko.newBestIntimacyType));
    paramContentValues.put("hasRemindChat", Boolean.valueOf(paramauko.hasRemindChat));
    paramContentValues.put("hasRemindLoverChat", Boolean.valueOf(paramauko.hasRemindLoverChat));
    paramContentValues.put("hasRemindPraise", Boolean.valueOf(paramauko.hasRemindPraise));
    paramContentValues.put("hasRemindQzoneVisit", Boolean.valueOf(paramauko.hasRemindQzoneVisit));
    paramContentValues.put("hasRemindFrdship", Boolean.valueOf(paramauko.hasRemindFrdship));
    paramContentValues.put("hasRemindIntimate", Boolean.valueOf(paramauko.hasRemindIntimate));
    paramContentValues.put("localChatSendTs", Long.valueOf(paramauko.localChatSendTs));
    paramContentValues.put("localChatRecTs", Long.valueOf(paramauko.localChatRecTs));
    paramContentValues.put("lastHotReactiveReCheckInTs", Long.valueOf(paramauko.lastHotReactiveReCheckInTs));
    paramContentValues.put("isGrayTipRemind", Integer.valueOf(paramauko.isGrayTipRemind));
    paramContentValues.put("isGrayTipMultiRemind", Integer.valueOf(paramauko.isGrayTipMultiRemind));
    paramContentValues.put("mutual_marks_store_json", paramauko.mutual_marks_store_json);
    paramContentValues.put("mutual_mark_version", Integer.valueOf(paramauko.mutual_mark_version));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukt
 * JD-Core Version:    0.7.0.1
 */