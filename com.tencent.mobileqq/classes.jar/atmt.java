import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atmt
  extends atna
{
  public atmt()
  {
    this.a = 88;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramatmo = (ExtensionInfo)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramatmo.pendantId = paramCursor.getLong(paramCursor.getColumnIndex("pendantId"));
      paramatmo.pendantDiyId = paramCursor.getInt(paramCursor.getColumnIndex("pendantDiyId"));
      paramatmo.uVipFont = paramCursor.getLong(paramCursor.getColumnIndex("uVipFont"));
      paramatmo.vipFontType = paramCursor.getInt(paramCursor.getColumnIndex("vipFontType"));
      paramatmo.magicFont = paramCursor.getInt(paramCursor.getColumnIndex("magicFont"));
      paramatmo.lastUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("lastUpdateTime"));
      paramatmo.fontEffect = paramCursor.getInt(paramCursor.getColumnIndex("fontEffect"));
      paramatmo.fontEffectLastUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("fontEffectLastUpdateTime"));
      paramatmo.faceId = paramCursor.getInt(paramCursor.getColumnIndex("faceId"));
      paramatmo.faceIdUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("faceIdUpdateTime"));
      paramatmo.colorRingId = paramCursor.getLong(paramCursor.getColumnIndex("colorRingId"));
      paramatmo.commingRingId = paramCursor.getLong(paramCursor.getColumnIndex("commingRingId"));
      paramatmo.timestamp = paramCursor.getLong(paramCursor.getColumnIndex("timestamp"));
      paramatmo.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
      paramatmo.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
      paramatmo.feedType = paramCursor.getInt(paramCursor.getColumnIndex("feedType"));
      paramatmo.feedTime = paramCursor.getLong(paramCursor.getColumnIndex("feedTime"));
      paramatmo.feedContent = paramCursor.getString(paramCursor.getColumnIndex("feedContent"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("feedHasPhoto")))
      {
        paramBoolean = true;
        paramatmo.feedHasPhoto = paramBoolean;
        paramatmo.feedPhotoUrl = paramCursor.getString(paramCursor.getColumnIndex("feedPhotoUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isAdded2C2C"))) {
          break label1742;
        }
        paramBoolean = true;
        label421:
        paramatmo.isAdded2C2C = paramBoolean;
        paramatmo.chatInputType = paramCursor.getInt(paramCursor.getColumnIndex("chatInputType"));
        paramatmo.showC2CPanel = paramCursor.getInt(paramCursor.getColumnIndex("showC2CPanel"));
        paramatmo.pttChangeVoiceType = paramCursor.getInt(paramCursor.getColumnIndex("pttChangeVoiceType"));
        paramatmo.audioPanelType = paramCursor.getInt(paramCursor.getColumnIndex("audioPanelType"));
        paramatmo.openDoNotDisturbTime = paramCursor.getLong(paramCursor.getColumnIndex("openDoNotDisturbTime"));
        paramatmo.latestPLUpdateTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("latestPLUpdateTimestamp"));
        paramatmo.lastPullPLNewsTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastPullPLNewsTimestamp"));
        paramatmo.lastPLNewsTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastPLNewsTimestamp"));
        paramatmo.medalUpdateTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("medalUpdateTimestamp"));
        paramatmo.lastMedalTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastMedalTimestamp"));
        paramatmo.diyFontTimestampBytes = paramCursor.getBlob(paramCursor.getColumnIndex("diyFontTimestampBytes"));
        paramatmo.diyFontConfigBytes = paramCursor.getBlob(paramCursor.getColumnIndex("diyFontConfigBytes"));
        paramatmo.lastIceBreakCheckTs = paramCursor.getLong(paramCursor.getColumnIndex("lastIceBreakCheckTs"));
        paramatmo.lastIceBreakChatTs = paramCursor.getLong(paramCursor.getColumnIndex("lastIceBreakChatTs"));
        paramatmo.makeFrdsTs = paramCursor.getLong(paramCursor.getColumnIndex("makeFrdsTs"));
        paramatmo.topPositionTime = paramCursor.getLong(paramCursor.getColumnIndex("topPositionTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isListenTogetherOpen"))) {
          break label1747;
        }
        paramBoolean = true;
        label734:
        paramatmo.isListenTogetherOpen = paramBoolean;
        paramatmo.isSharingLocation = paramCursor.getInt(paramCursor.getColumnIndex("isSharingLocation"));
        paramatmo.lastShareLbsMsgUniseq = paramCursor.getLong(paramCursor.getColumnIndex("lastShareLbsMsgUniseq"));
        paramatmo.mTogetherBusinessFlag = paramCursor.getLong(paramCursor.getColumnIndex("mTogetherBusinessFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnablePreview"))) {
          break label1752;
        }
        paramBoolean = true;
        label813:
        paramatmo.messageEnablePreview = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnableSound"))) {
          break label1757;
        }
        paramBoolean = true;
        label838:
        paramatmo.messageEnableSound = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnableVibrate"))) {
          break label1762;
        }
        paramBoolean = true;
        label863:
        paramatmo.messageEnableVibrate = paramBoolean;
        paramatmo.friendRingId = paramCursor.getInt(paramCursor.getColumnIndex("friendRingId"));
        paramatmo.messageEnablePreviewNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnablePreviewNew"));
        paramatmo.messageEnableSoundNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnableSoundNew"));
        paramatmo.messageEnableVibrateNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnableVibrateNew"));
        paramatmo.hiddenChatSwitch = paramCursor.getInt(paramCursor.getColumnIndex("hiddenChatSwitch"));
        paramatmo.intimate_type = paramCursor.getInt(paramCursor.getColumnIndex("intimate_type"));
        paramatmo.intimate_level = paramCursor.getInt(paramCursor.getColumnIndex("intimate_level"));
        paramatmo.intimate_chatDays = paramCursor.getInt(paramCursor.getColumnIndex("intimate_chatDays"));
        paramatmo.last_intimate_chatTime = paramCursor.getLong(paramCursor.getColumnIndex("last_intimate_chatTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isExtinguish"))) {
          break label1767;
        }
        paramBoolean = true;
        label1053:
        paramatmo.isExtinguish = paramBoolean;
        paramatmo.friendshipLevel = paramCursor.getInt(paramCursor.getColumnIndex("friendshipLevel"));
        paramatmo.friendshipChatDays = paramCursor.getInt(paramCursor.getColumnIndex("friendshipChatDays"));
        paramatmo.lastFriendshipTime = paramCursor.getLong(paramCursor.getColumnIndex("lastFriendshipTime"));
        paramatmo.chatHotLevel = paramCursor.getInt(paramCursor.getColumnIndex("chatHotLevel"));
        paramatmo.chatDays = paramCursor.getInt(paramCursor.getColumnIndex("chatDays"));
        paramatmo.lastChatTime = paramCursor.getLong(paramCursor.getColumnIndex("lastChatTime"));
        paramatmo.praiseHotLevel = paramCursor.getInt(paramCursor.getColumnIndex("praiseHotLevel"));
        paramatmo.praiseDays = paramCursor.getInt(paramCursor.getColumnIndex("praiseDays"));
        paramatmo.lastpraiseTime = paramCursor.getLong(paramCursor.getColumnIndex("lastpraiseTime"));
        paramatmo.loverChatLevel = paramCursor.getInt(paramCursor.getColumnIndex("loverChatLevel"));
        paramatmo.loverChatDays = paramCursor.getInt(paramCursor.getColumnIndex("loverChatDays"));
        paramatmo.loverLastChatTime = paramCursor.getLong(paramCursor.getColumnIndex("loverLastChatTime"));
        paramatmo.loverFlag = paramCursor.getInt(paramCursor.getColumnIndex("loverFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("loverTransFlag"))) {
          break label1772;
        }
        paramBoolean = true;
        label1326:
        paramatmo.loverTransFlag = paramBoolean;
        paramatmo.qzoneVisitType = paramCursor.getInt(paramCursor.getColumnIndex("qzoneVisitType"));
        paramatmo.qzoneHotDays = paramCursor.getInt(paramCursor.getColumnIndex("qzoneHotDays"));
        paramatmo.lastQzoneVisitTime = paramCursor.getLong(paramCursor.getColumnIndex("lastQzoneVisitTime"));
        paramatmo.bestIntimacyType = paramCursor.getInt(paramCursor.getColumnIndex("bestIntimacyType"));
        paramatmo.bestIntimacyDays = paramCursor.getInt(paramCursor.getColumnIndex("bestIntimacyDays"));
        paramatmo.newBestIntimacyType = paramCursor.getInt(paramCursor.getColumnIndex("newBestIntimacyType"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindChat"))) {
          break label1777;
        }
        paramBoolean = true;
        label1466:
        paramatmo.hasRemindChat = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindLoverChat"))) {
          break label1782;
        }
        paramBoolean = true;
        label1492:
        paramatmo.hasRemindLoverChat = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindPraise"))) {
          break label1787;
        }
        paramBoolean = true;
        label1518:
        paramatmo.hasRemindPraise = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindQzoneVisit"))) {
          break label1792;
        }
        paramBoolean = true;
        label1544:
        paramatmo.hasRemindQzoneVisit = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindFrdship"))) {
          break label1797;
        }
        paramBoolean = true;
        label1570:
        paramatmo.hasRemindFrdship = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindIntimate"))) {
          break label1802;
        }
      }
      label1792:
      label1797:
      label1802:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramatmo.hasRemindIntimate = paramBoolean;
        paramatmo.localChatSendTs = paramCursor.getLong(paramCursor.getColumnIndex("localChatSendTs"));
        paramatmo.localChatRecTs = paramCursor.getLong(paramCursor.getColumnIndex("localChatRecTs"));
        paramatmo.lastHotReactiveReCheckInTs = paramCursor.getLong(paramCursor.getColumnIndex("lastHotReactiveReCheckInTs"));
        paramatmo.isGrayTipRemind = paramCursor.getInt(paramCursor.getColumnIndex("isGrayTipRemind"));
        paramatmo.isGrayTipMultiRemind = paramCursor.getInt(paramCursor.getColumnIndex("isGrayTipMultiRemind"));
        paramatmo.mutual_marks_store_json = paramCursor.getString(paramCursor.getColumnIndex("mutual_marks_store_json"));
        paramatmo.mutual_mark_version = paramCursor.getInt(paramCursor.getColumnIndex("mutual_mark_version"));
        return paramatmo;
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
      paramatmz.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("pendantId");
      if (i != -1) {
        break label4976;
      }
      paramatmz.a(new NoColumnError("pendantId", Long.TYPE));
      label1877:
      i = paramCursor.getColumnIndex("pendantDiyId");
      if (i != -1) {
        break label4991;
      }
      paramatmz.a(new NoColumnError("pendantDiyId", Integer.TYPE));
      label1912:
      i = paramCursor.getColumnIndex("uVipFont");
      if (i != -1) {
        break label5006;
      }
      paramatmz.a(new NoColumnError("uVipFont", Long.TYPE));
      label1947:
      i = paramCursor.getColumnIndex("vipFontType");
      if (i != -1) {
        break label5021;
      }
      paramatmz.a(new NoColumnError("vipFontType", Integer.TYPE));
      label1982:
      i = paramCursor.getColumnIndex("magicFont");
      if (i != -1) {
        break label5036;
      }
      paramatmz.a(new NoColumnError("magicFont", Integer.TYPE));
      label2017:
      i = paramCursor.getColumnIndex("lastUpdateTime");
      if (i != -1) {
        break label5051;
      }
      paramatmz.a(new NoColumnError("lastUpdateTime", Long.TYPE));
      label2052:
      i = paramCursor.getColumnIndex("fontEffect");
      if (i != -1) {
        break label5066;
      }
      paramatmz.a(new NoColumnError("fontEffect", Integer.TYPE));
      label2087:
      i = paramCursor.getColumnIndex("fontEffectLastUpdateTime");
      if (i != -1) {
        break label5081;
      }
      paramatmz.a(new NoColumnError("fontEffectLastUpdateTime", Long.TYPE));
      label2122:
      i = paramCursor.getColumnIndex("faceId");
      if (i != -1) {
        break label5096;
      }
      paramatmz.a(new NoColumnError("faceId", Integer.TYPE));
      label2157:
      i = paramCursor.getColumnIndex("faceIdUpdateTime");
      if (i != -1) {
        break label5111;
      }
      paramatmz.a(new NoColumnError("faceIdUpdateTime", Long.TYPE));
      label2192:
      i = paramCursor.getColumnIndex("colorRingId");
      if (i != -1) {
        break label5126;
      }
      paramatmz.a(new NoColumnError("colorRingId", Long.TYPE));
      label2227:
      i = paramCursor.getColumnIndex("commingRingId");
      if (i != -1) {
        break label5141;
      }
      paramatmz.a(new NoColumnError("commingRingId", Long.TYPE));
      label2262:
      i = paramCursor.getColumnIndex("timestamp");
      if (i != -1) {
        break label5156;
      }
      paramatmz.a(new NoColumnError("timestamp", Long.TYPE));
      label2297:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label5171;
      }
      paramatmz.a(new NoColumnError("richTime", Long.TYPE));
      label2332:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label5186;
      }
      paramatmz.a(new NoColumnError("richBuffer", [B.class));
      label2367:
      i = paramCursor.getColumnIndex("feedType");
      if (i != -1) {
        break label5201;
      }
      paramatmz.a(new NoColumnError("feedType", Integer.TYPE));
      label2402:
      i = paramCursor.getColumnIndex("feedTime");
      if (i != -1) {
        break label5216;
      }
      paramatmz.a(new NoColumnError("feedTime", Long.TYPE));
      label2437:
      i = paramCursor.getColumnIndex("feedContent");
      if (i != -1) {
        break label5231;
      }
      paramatmz.a(new NoColumnError("feedContent", String.class));
      label2472:
      i = paramCursor.getColumnIndex("feedHasPhoto");
      if (i != -1) {
        break label5246;
      }
      paramatmz.a(new NoColumnError("feedHasPhoto", Boolean.TYPE));
      i = paramCursor.getColumnIndex("feedPhotoUrl");
      if (i != -1) {
        break label5273;
      }
      paramatmz.a(new NoColumnError("feedPhotoUrl", String.class));
      label2542:
      i = paramCursor.getColumnIndex("isAdded2C2C");
      if (i != -1) {
        break label5288;
      }
      paramatmz.a(new NoColumnError("isAdded2C2C", Boolean.TYPE));
      i = paramCursor.getColumnIndex("chatInputType");
      if (i != -1) {
        break label5315;
      }
      paramatmz.a(new NoColumnError("chatInputType", Integer.TYPE));
      label2612:
      i = paramCursor.getColumnIndex("showC2CPanel");
      if (i != -1) {
        break label5330;
      }
      paramatmz.a(new NoColumnError("showC2CPanel", Integer.TYPE));
      label2647:
      i = paramCursor.getColumnIndex("pttChangeVoiceType");
      if (i != -1) {
        break label5345;
      }
      paramatmz.a(new NoColumnError("pttChangeVoiceType", Integer.TYPE));
      label2682:
      i = paramCursor.getColumnIndex("audioPanelType");
      if (i != -1) {
        break label5360;
      }
      paramatmz.a(new NoColumnError("audioPanelType", Integer.TYPE));
      label2717:
      i = paramCursor.getColumnIndex("openDoNotDisturbTime");
      if (i != -1) {
        break label5375;
      }
      paramatmz.a(new NoColumnError("openDoNotDisturbTime", Long.TYPE));
      label2752:
      i = paramCursor.getColumnIndex("latestPLUpdateTimestamp");
      if (i != -1) {
        break label5390;
      }
      paramatmz.a(new NoColumnError("latestPLUpdateTimestamp", Long.TYPE));
      label2787:
      i = paramCursor.getColumnIndex("lastPullPLNewsTimestamp");
      if (i != -1) {
        break label5405;
      }
      paramatmz.a(new NoColumnError("lastPullPLNewsTimestamp", Long.TYPE));
      label2822:
      i = paramCursor.getColumnIndex("lastPLNewsTimestamp");
      if (i != -1) {
        break label5420;
      }
      paramatmz.a(new NoColumnError("lastPLNewsTimestamp", Long.TYPE));
      label2857:
      i = paramCursor.getColumnIndex("medalUpdateTimestamp");
      if (i != -1) {
        break label5435;
      }
      paramatmz.a(new NoColumnError("medalUpdateTimestamp", Long.TYPE));
      label2892:
      i = paramCursor.getColumnIndex("lastMedalTimestamp");
      if (i != -1) {
        break label5450;
      }
      paramatmz.a(new NoColumnError("lastMedalTimestamp", Long.TYPE));
      label2927:
      i = paramCursor.getColumnIndex("diyFontTimestampBytes");
      if (i != -1) {
        break label5465;
      }
      paramatmz.a(new NoColumnError("diyFontTimestampBytes", [B.class));
      label2962:
      i = paramCursor.getColumnIndex("diyFontConfigBytes");
      if (i != -1) {
        break label5480;
      }
      paramatmz.a(new NoColumnError("diyFontConfigBytes", [B.class));
      label2997:
      i = paramCursor.getColumnIndex("lastIceBreakCheckTs");
      if (i != -1) {
        break label5495;
      }
      paramatmz.a(new NoColumnError("lastIceBreakCheckTs", Long.TYPE));
      label3032:
      i = paramCursor.getColumnIndex("lastIceBreakChatTs");
      if (i != -1) {
        break label5510;
      }
      paramatmz.a(new NoColumnError("lastIceBreakChatTs", Long.TYPE));
      label3067:
      i = paramCursor.getColumnIndex("makeFrdsTs");
      if (i != -1) {
        break label5525;
      }
      paramatmz.a(new NoColumnError("makeFrdsTs", Long.TYPE));
      label3102:
      i = paramCursor.getColumnIndex("topPositionTime");
      if (i != -1) {
        break label5540;
      }
      paramatmz.a(new NoColumnError("topPositionTime", Long.TYPE));
      label3137:
      i = paramCursor.getColumnIndex("isListenTogetherOpen");
      if (i != -1) {
        break label5555;
      }
      paramatmz.a(new NoColumnError("isListenTogetherOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isSharingLocation");
      if (i != -1) {
        break label5582;
      }
      paramatmz.a(new NoColumnError("isSharingLocation", Integer.TYPE));
      label3207:
      i = paramCursor.getColumnIndex("lastShareLbsMsgUniseq");
      if (i != -1) {
        break label5597;
      }
      paramatmz.a(new NoColumnError("lastShareLbsMsgUniseq", Long.TYPE));
      label3242:
      i = paramCursor.getColumnIndex("mTogetherBusinessFlag");
      if (i != -1) {
        break label5612;
      }
      paramatmz.a(new NoColumnError("mTogetherBusinessFlag", Long.TYPE));
      label3277:
      i = paramCursor.getColumnIndex("messageEnablePreview");
      if (i != -1) {
        break label5627;
      }
      paramatmz.a(new NoColumnError("messageEnablePreview", Boolean.TYPE));
      i = paramCursor.getColumnIndex("messageEnableSound");
      if (i != -1) {
        break label5654;
      }
      paramatmz.a(new NoColumnError("messageEnableSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("messageEnableVibrate");
      if (i != -1) {
        break label5681;
      }
      paramatmz.a(new NoColumnError("messageEnableVibrate", Boolean.TYPE));
      i = paramCursor.getColumnIndex("friendRingId");
      if (i != -1) {
        break label5708;
      }
      paramatmz.a(new NoColumnError("friendRingId", Integer.TYPE));
      label3417:
      i = paramCursor.getColumnIndex("messageEnablePreviewNew");
      if (i != -1) {
        break label5723;
      }
      paramatmz.a(new NoColumnError("messageEnablePreviewNew", Integer.TYPE));
      label3452:
      i = paramCursor.getColumnIndex("messageEnableSoundNew");
      if (i != -1) {
        break label5738;
      }
      paramatmz.a(new NoColumnError("messageEnableSoundNew", Integer.TYPE));
      label3487:
      i = paramCursor.getColumnIndex("messageEnableVibrateNew");
      if (i != -1) {
        break label5753;
      }
      paramatmz.a(new NoColumnError("messageEnableVibrateNew", Integer.TYPE));
      label3522:
      i = paramCursor.getColumnIndex("hiddenChatSwitch");
      if (i != -1) {
        break label5768;
      }
      paramatmz.a(new NoColumnError("hiddenChatSwitch", Integer.TYPE));
      label3557:
      i = paramCursor.getColumnIndex("intimate_type");
      if (i != -1) {
        break label5783;
      }
      paramatmz.a(new NoColumnError("intimate_type", Integer.TYPE));
      label3592:
      i = paramCursor.getColumnIndex("intimate_level");
      if (i != -1) {
        break label5798;
      }
      paramatmz.a(new NoColumnError("intimate_level", Integer.TYPE));
      label3627:
      i = paramCursor.getColumnIndex("intimate_chatDays");
      if (i != -1) {
        break label5813;
      }
      paramatmz.a(new NoColumnError("intimate_chatDays", Integer.TYPE));
      label3664:
      i = paramCursor.getColumnIndex("last_intimate_chatTime");
      if (i != -1) {
        break label5828;
      }
      paramatmz.a(new NoColumnError("last_intimate_chatTime", Long.TYPE));
      label3701:
      i = paramCursor.getColumnIndex("isExtinguish");
      if (i != -1) {
        break label5843;
      }
      paramatmz.a(new NoColumnError("isExtinguish", Boolean.TYPE));
      i = paramCursor.getColumnIndex("friendshipLevel");
      if (i != -1) {
        break label5870;
      }
      paramatmz.a(new NoColumnError("friendshipLevel", Integer.TYPE));
      label3775:
      i = paramCursor.getColumnIndex("friendshipChatDays");
      if (i != -1) {
        break label5885;
      }
      paramatmz.a(new NoColumnError("friendshipChatDays", Integer.TYPE));
      label3812:
      i = paramCursor.getColumnIndex("lastFriendshipTime");
      if (i != -1) {
        break label5900;
      }
      paramatmz.a(new NoColumnError("lastFriendshipTime", Long.TYPE));
      label3849:
      i = paramCursor.getColumnIndex("chatHotLevel");
      if (i != -1) {
        break label5915;
      }
      paramatmz.a(new NoColumnError("chatHotLevel", Integer.TYPE));
      label3886:
      i = paramCursor.getColumnIndex("chatDays");
      if (i != -1) {
        break label5930;
      }
      paramatmz.a(new NoColumnError("chatDays", Integer.TYPE));
      label3923:
      i = paramCursor.getColumnIndex("lastChatTime");
      if (i != -1) {
        break label5945;
      }
      paramatmz.a(new NoColumnError("lastChatTime", Long.TYPE));
      label3960:
      i = paramCursor.getColumnIndex("praiseHotLevel");
      if (i != -1) {
        break label5960;
      }
      paramatmz.a(new NoColumnError("praiseHotLevel", Integer.TYPE));
      label3997:
      i = paramCursor.getColumnIndex("praiseDays");
      if (i != -1) {
        break label5975;
      }
      paramatmz.a(new NoColumnError("praiseDays", Integer.TYPE));
      label4034:
      i = paramCursor.getColumnIndex("lastpraiseTime");
      if (i != -1) {
        break label5990;
      }
      paramatmz.a(new NoColumnError("lastpraiseTime", Long.TYPE));
      label4071:
      i = paramCursor.getColumnIndex("loverChatLevel");
      if (i != -1) {
        break label6005;
      }
      paramatmz.a(new NoColumnError("loverChatLevel", Integer.TYPE));
      label4108:
      i = paramCursor.getColumnIndex("loverChatDays");
      if (i != -1) {
        break label6020;
      }
      paramatmz.a(new NoColumnError("loverChatDays", Integer.TYPE));
      label4145:
      i = paramCursor.getColumnIndex("loverLastChatTime");
      if (i != -1) {
        break label6035;
      }
      paramatmz.a(new NoColumnError("loverLastChatTime", Long.TYPE));
      label4182:
      i = paramCursor.getColumnIndex("loverFlag");
      if (i != -1) {
        break label6050;
      }
      paramatmz.a(new NoColumnError("loverFlag", Integer.TYPE));
      label4219:
      i = paramCursor.getColumnIndex("loverTransFlag");
      if (i != -1) {
        break label6065;
      }
      paramatmz.a(new NoColumnError("loverTransFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("qzoneVisitType");
      if (i != -1) {
        break label6092;
      }
      paramatmz.a(new NoColumnError("qzoneVisitType", Integer.TYPE));
      label4293:
      i = paramCursor.getColumnIndex("qzoneHotDays");
      if (i != -1) {
        break label6107;
      }
      paramatmz.a(new NoColumnError("qzoneHotDays", Integer.TYPE));
      label4330:
      i = paramCursor.getColumnIndex("lastQzoneVisitTime");
      if (i != -1) {
        break label6122;
      }
      paramatmz.a(new NoColumnError("lastQzoneVisitTime", Long.TYPE));
      label4367:
      i = paramCursor.getColumnIndex("bestIntimacyType");
      if (i != -1) {
        break label6137;
      }
      paramatmz.a(new NoColumnError("bestIntimacyType", Integer.TYPE));
      label4404:
      i = paramCursor.getColumnIndex("bestIntimacyDays");
      if (i != -1) {
        break label6152;
      }
      paramatmz.a(new NoColumnError("bestIntimacyDays", Integer.TYPE));
      label4441:
      i = paramCursor.getColumnIndex("newBestIntimacyType");
      if (i != -1) {
        break label6167;
      }
      paramatmz.a(new NoColumnError("newBestIntimacyType", Integer.TYPE));
      label4478:
      i = paramCursor.getColumnIndex("hasRemindChat");
      if (i != -1) {
        break label6182;
      }
      paramatmz.a(new NoColumnError("hasRemindChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindLoverChat");
      if (i != -1) {
        break label6209;
      }
      paramatmz.a(new NoColumnError("hasRemindLoverChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindPraise");
      if (i != -1) {
        break label6236;
      }
      paramatmz.a(new NoColumnError("hasRemindPraise", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindQzoneVisit");
      if (i != -1) {
        break label6263;
      }
      paramatmz.a(new NoColumnError("hasRemindQzoneVisit", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindFrdship");
      if (i != -1) {
        break label6290;
      }
      paramatmz.a(new NoColumnError("hasRemindFrdship", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindIntimate");
      if (i != -1) {
        break label6317;
      }
      paramatmz.a(new NoColumnError("hasRemindIntimate", Boolean.TYPE));
      i = paramCursor.getColumnIndex("localChatSendTs");
      if (i != -1) {
        break label6345;
      }
      paramatmz.a(new NoColumnError("localChatSendTs", Long.TYPE));
      label4737:
      i = paramCursor.getColumnIndex("localChatRecTs");
      if (i != -1) {
        break label6360;
      }
      paramatmz.a(new NoColumnError("localChatRecTs", Long.TYPE));
      label4774:
      i = paramCursor.getColumnIndex("lastHotReactiveReCheckInTs");
      if (i != -1) {
        break label6375;
      }
      paramatmz.a(new NoColumnError("lastHotReactiveReCheckInTs", Long.TYPE));
      label4811:
      i = paramCursor.getColumnIndex("isGrayTipRemind");
      if (i != -1) {
        break label6390;
      }
      paramatmz.a(new NoColumnError("isGrayTipRemind", Integer.TYPE));
      label4848:
      i = paramCursor.getColumnIndex("isGrayTipMultiRemind");
      if (i != -1) {
        break label6405;
      }
      paramatmz.a(new NoColumnError("isGrayTipMultiRemind", Integer.TYPE));
      label4885:
      i = paramCursor.getColumnIndex("mutual_marks_store_json");
      if (i != -1) {
        break label6420;
      }
      paramatmz.a(new NoColumnError("mutual_marks_store_json", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("mutual_mark_version");
      if (i != -1) {
        break label6435;
      }
      paramatmz.a(new NoColumnError("mutual_mark_version", Integer.TYPE));
      return paramatmo;
      paramatmo.uin = paramCursor.getString(i);
      break;
      label4976:
      paramatmo.pendantId = paramCursor.getLong(i);
      break label1877;
      label4991:
      paramatmo.pendantDiyId = paramCursor.getInt(i);
      break label1912;
      label5006:
      paramatmo.uVipFont = paramCursor.getLong(i);
      break label1947;
      label5021:
      paramatmo.vipFontType = paramCursor.getInt(i);
      break label1982;
      label5036:
      paramatmo.magicFont = paramCursor.getInt(i);
      break label2017;
      label5051:
      paramatmo.lastUpdateTime = paramCursor.getLong(i);
      break label2052;
      label5066:
      paramatmo.fontEffect = paramCursor.getInt(i);
      break label2087;
      label5081:
      paramatmo.fontEffectLastUpdateTime = paramCursor.getLong(i);
      break label2122;
      label5096:
      paramatmo.faceId = paramCursor.getInt(i);
      break label2157;
      label5111:
      paramatmo.faceIdUpdateTime = paramCursor.getLong(i);
      break label2192;
      label5126:
      paramatmo.colorRingId = paramCursor.getLong(i);
      break label2227;
      label5141:
      paramatmo.commingRingId = paramCursor.getLong(i);
      break label2262;
      label5156:
      paramatmo.timestamp = paramCursor.getLong(i);
      break label2297;
      label5171:
      paramatmo.richTime = paramCursor.getLong(i);
      break label2332;
      label5186:
      paramatmo.richBuffer = paramCursor.getBlob(i);
      break label2367;
      label5201:
      paramatmo.feedType = paramCursor.getInt(i);
      break label2402;
      label5216:
      paramatmo.feedTime = paramCursor.getLong(i);
      break label2437;
      label5231:
      paramatmo.feedContent = paramCursor.getString(i);
      break label2472;
      label5246:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.feedHasPhoto = paramBoolean;
        break;
      }
      label5273:
      paramatmo.feedPhotoUrl = paramCursor.getString(i);
      break label2542;
      label5288:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isAdded2C2C = paramBoolean;
        break;
      }
      label5315:
      paramatmo.chatInputType = paramCursor.getInt(i);
      break label2612;
      label5330:
      paramatmo.showC2CPanel = paramCursor.getInt(i);
      break label2647;
      label5345:
      paramatmo.pttChangeVoiceType = paramCursor.getInt(i);
      break label2682;
      label5360:
      paramatmo.audioPanelType = paramCursor.getInt(i);
      break label2717;
      label5375:
      paramatmo.openDoNotDisturbTime = paramCursor.getLong(i);
      break label2752;
      label5390:
      paramatmo.latestPLUpdateTimestamp = paramCursor.getLong(i);
      break label2787;
      label5405:
      paramatmo.lastPullPLNewsTimestamp = paramCursor.getLong(i);
      break label2822;
      label5420:
      paramatmo.lastPLNewsTimestamp = paramCursor.getLong(i);
      break label2857;
      label5435:
      paramatmo.medalUpdateTimestamp = paramCursor.getLong(i);
      break label2892;
      label5450:
      paramatmo.lastMedalTimestamp = paramCursor.getLong(i);
      break label2927;
      label5465:
      paramatmo.diyFontTimestampBytes = paramCursor.getBlob(i);
      break label2962;
      label5480:
      paramatmo.diyFontConfigBytes = paramCursor.getBlob(i);
      break label2997;
      label5495:
      paramatmo.lastIceBreakCheckTs = paramCursor.getLong(i);
      break label3032;
      label5510:
      paramatmo.lastIceBreakChatTs = paramCursor.getLong(i);
      break label3067;
      label5525:
      paramatmo.makeFrdsTs = paramCursor.getLong(i);
      break label3102;
      label5540:
      paramatmo.topPositionTime = paramCursor.getLong(i);
      break label3137;
      label5555:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isListenTogetherOpen = paramBoolean;
        break;
      }
      label5582:
      paramatmo.isSharingLocation = paramCursor.getInt(i);
      break label3207;
      label5597:
      paramatmo.lastShareLbsMsgUniseq = paramCursor.getLong(i);
      break label3242;
      label5612:
      paramatmo.mTogetherBusinessFlag = paramCursor.getLong(i);
      break label3277;
      label5627:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.messageEnablePreview = paramBoolean;
        break;
      }
      label5654:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.messageEnableSound = paramBoolean;
        break;
      }
      label5681:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.messageEnableVibrate = paramBoolean;
        break;
      }
      label5708:
      paramatmo.friendRingId = paramCursor.getInt(i);
      break label3417;
      label5723:
      paramatmo.messageEnablePreviewNew = paramCursor.getInt(i);
      break label3452;
      label5738:
      paramatmo.messageEnableSoundNew = paramCursor.getInt(i);
      break label3487;
      label5753:
      paramatmo.messageEnableVibrateNew = paramCursor.getInt(i);
      break label3522;
      label5768:
      paramatmo.hiddenChatSwitch = paramCursor.getInt(i);
      break label3557;
      label5783:
      paramatmo.intimate_type = paramCursor.getInt(i);
      break label3592;
      label5798:
      paramatmo.intimate_level = paramCursor.getInt(i);
      break label3627;
      label5813:
      paramatmo.intimate_chatDays = paramCursor.getInt(i);
      break label3664;
      label5828:
      paramatmo.last_intimate_chatTime = paramCursor.getLong(i);
      break label3701;
      label5843:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isExtinguish = paramBoolean;
        break;
      }
      label5870:
      paramatmo.friendshipLevel = paramCursor.getInt(i);
      break label3775;
      label5885:
      paramatmo.friendshipChatDays = paramCursor.getInt(i);
      break label3812;
      label5900:
      paramatmo.lastFriendshipTime = paramCursor.getLong(i);
      break label3849;
      label5915:
      paramatmo.chatHotLevel = paramCursor.getInt(i);
      break label3886;
      label5930:
      paramatmo.chatDays = paramCursor.getInt(i);
      break label3923;
      label5945:
      paramatmo.lastChatTime = paramCursor.getLong(i);
      break label3960;
      label5960:
      paramatmo.praiseHotLevel = paramCursor.getInt(i);
      break label3997;
      label5975:
      paramatmo.praiseDays = paramCursor.getInt(i);
      break label4034;
      label5990:
      paramatmo.lastpraiseTime = paramCursor.getLong(i);
      break label4071;
      label6005:
      paramatmo.loverChatLevel = paramCursor.getInt(i);
      break label4108;
      label6020:
      paramatmo.loverChatDays = paramCursor.getInt(i);
      break label4145;
      label6035:
      paramatmo.loverLastChatTime = paramCursor.getLong(i);
      break label4182;
      label6050:
      paramatmo.loverFlag = paramCursor.getInt(i);
      break label4219;
      label6065:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.loverTransFlag = paramBoolean;
        break;
      }
      label6092:
      paramatmo.qzoneVisitType = paramCursor.getInt(i);
      break label4293;
      label6107:
      paramatmo.qzoneHotDays = paramCursor.getInt(i);
      break label4330;
      label6122:
      paramatmo.lastQzoneVisitTime = paramCursor.getLong(i);
      break label4367;
      label6137:
      paramatmo.bestIntimacyType = paramCursor.getInt(i);
      break label4404;
      label6152:
      paramatmo.bestIntimacyDays = paramCursor.getInt(i);
      break label4441;
      label6167:
      paramatmo.newBestIntimacyType = paramCursor.getInt(i);
      break label4478;
      label6182:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.hasRemindChat = paramBoolean;
        break;
      }
      label6209:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.hasRemindLoverChat = paramBoolean;
        break;
      }
      label6236:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.hasRemindPraise = paramBoolean;
        break;
      }
      label6263:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.hasRemindQzoneVisit = paramBoolean;
        break;
      }
      label6290:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.hasRemindFrdship = paramBoolean;
        break;
      }
      label6317:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramatmo.hasRemindIntimate = paramBoolean;
        break;
      }
      label6345:
      paramatmo.localChatSendTs = paramCursor.getLong(i);
      break label4737;
      label6360:
      paramatmo.localChatRecTs = paramCursor.getLong(i);
      break label4774;
      label6375:
      paramatmo.lastHotReactiveReCheckInTs = paramCursor.getLong(i);
      break label4811;
      label6390:
      paramatmo.isGrayTipRemind = paramCursor.getInt(i);
      break label4848;
      label6405:
      paramatmo.isGrayTipMultiRemind = paramCursor.getInt(i);
      break label4885;
      label6420:
      paramatmo.mutual_marks_store_json = paramCursor.getString(i);
    }
    label6435:
    paramatmo.mutual_mark_version = paramCursor.getInt(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,pendantId INTEGER ,pendantDiyId INTEGER ,uVipFont INTEGER ,vipFontType INTEGER ,magicFont INTEGER ,lastUpdateTime INTEGER ,fontEffect INTEGER ,fontEffectLastUpdateTime INTEGER ,faceId INTEGER ,faceIdUpdateTime INTEGER ,colorRingId INTEGER ,commingRingId INTEGER ,timestamp INTEGER ,richTime INTEGER ,richBuffer BLOB ,feedType INTEGER ,feedTime INTEGER ,feedContent TEXT ,feedHasPhoto INTEGER ,feedPhotoUrl TEXT ,isAdded2C2C INTEGER ,chatInputType INTEGER ,showC2CPanel INTEGER ,pttChangeVoiceType INTEGER ,audioPanelType INTEGER ,openDoNotDisturbTime INTEGER ,latestPLUpdateTimestamp INTEGER ,lastPullPLNewsTimestamp INTEGER ,lastPLNewsTimestamp INTEGER ,medalUpdateTimestamp INTEGER ,lastMedalTimestamp INTEGER ,diyFontTimestampBytes BLOB ,diyFontConfigBytes BLOB ,lastIceBreakCheckTs INTEGER ,lastIceBreakChatTs INTEGER ,makeFrdsTs INTEGER ,topPositionTime INTEGER ,isListenTogetherOpen INTEGER ,isSharingLocation INTEGER ,lastShareLbsMsgUniseq INTEGER ,mTogetherBusinessFlag INTEGER ,messageEnablePreview INTEGER ,messageEnableSound INTEGER ,messageEnableVibrate INTEGER ,friendRingId INTEGER ,messageEnablePreviewNew INTEGER ,messageEnableSoundNew INTEGER ,messageEnableVibrateNew INTEGER ,hiddenChatSwitch INTEGER ,intimate_type INTEGER ,intimate_level INTEGER ,intimate_chatDays INTEGER ,last_intimate_chatTime INTEGER ,isExtinguish INTEGER ,friendshipLevel INTEGER ,friendshipChatDays INTEGER ,lastFriendshipTime INTEGER ,chatHotLevel INTEGER ,chatDays INTEGER ,lastChatTime INTEGER ,praiseHotLevel INTEGER ,praiseDays INTEGER ,lastpraiseTime INTEGER ,loverChatLevel INTEGER ,loverChatDays INTEGER ,loverLastChatTime INTEGER ,loverFlag INTEGER ,loverTransFlag INTEGER ,qzoneVisitType INTEGER ,qzoneHotDays INTEGER ,lastQzoneVisitTime INTEGER ,bestIntimacyType INTEGER ,bestIntimacyDays INTEGER ,newBestIntimacyType INTEGER ,hasRemindChat INTEGER ,hasRemindLoverChat INTEGER ,hasRemindPraise INTEGER ,hasRemindQzoneVisit INTEGER ,hasRemindFrdship INTEGER ,hasRemindIntimate INTEGER ,localChatSendTs INTEGER ,localChatRecTs INTEGER ,lastHotReactiveReCheckInTs INTEGER ,isGrayTipRemind INTEGER ,isGrayTipMultiRemind INTEGER ,mutual_marks_store_json TEXT ,mutual_mark_version INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (ExtensionInfo)paramatmo;
    paramContentValues.put("uin", paramatmo.uin);
    paramContentValues.put("pendantId", Long.valueOf(paramatmo.pendantId));
    paramContentValues.put("pendantDiyId", Integer.valueOf(paramatmo.pendantDiyId));
    paramContentValues.put("uVipFont", Long.valueOf(paramatmo.uVipFont));
    paramContentValues.put("vipFontType", Integer.valueOf(paramatmo.vipFontType));
    paramContentValues.put("magicFont", Integer.valueOf(paramatmo.magicFont));
    paramContentValues.put("lastUpdateTime", Long.valueOf(paramatmo.lastUpdateTime));
    paramContentValues.put("fontEffect", Integer.valueOf(paramatmo.fontEffect));
    paramContentValues.put("fontEffectLastUpdateTime", Long.valueOf(paramatmo.fontEffectLastUpdateTime));
    paramContentValues.put("faceId", Integer.valueOf(paramatmo.faceId));
    paramContentValues.put("faceIdUpdateTime", Long.valueOf(paramatmo.faceIdUpdateTime));
    paramContentValues.put("colorRingId", Long.valueOf(paramatmo.colorRingId));
    paramContentValues.put("commingRingId", Long.valueOf(paramatmo.commingRingId));
    paramContentValues.put("timestamp", Long.valueOf(paramatmo.timestamp));
    paramContentValues.put("richTime", Long.valueOf(paramatmo.richTime));
    paramContentValues.put("richBuffer", paramatmo.richBuffer);
    paramContentValues.put("feedType", Integer.valueOf(paramatmo.feedType));
    paramContentValues.put("feedTime", Long.valueOf(paramatmo.feedTime));
    paramContentValues.put("feedContent", paramatmo.feedContent);
    paramContentValues.put("feedHasPhoto", Boolean.valueOf(paramatmo.feedHasPhoto));
    paramContentValues.put("feedPhotoUrl", paramatmo.feedPhotoUrl);
    paramContentValues.put("isAdded2C2C", Boolean.valueOf(paramatmo.isAdded2C2C));
    paramContentValues.put("chatInputType", Integer.valueOf(paramatmo.chatInputType));
    paramContentValues.put("showC2CPanel", Integer.valueOf(paramatmo.showC2CPanel));
    paramContentValues.put("pttChangeVoiceType", Integer.valueOf(paramatmo.pttChangeVoiceType));
    paramContentValues.put("audioPanelType", Integer.valueOf(paramatmo.audioPanelType));
    paramContentValues.put("openDoNotDisturbTime", Long.valueOf(paramatmo.openDoNotDisturbTime));
    paramContentValues.put("latestPLUpdateTimestamp", Long.valueOf(paramatmo.latestPLUpdateTimestamp));
    paramContentValues.put("lastPullPLNewsTimestamp", Long.valueOf(paramatmo.lastPullPLNewsTimestamp));
    paramContentValues.put("lastPLNewsTimestamp", Long.valueOf(paramatmo.lastPLNewsTimestamp));
    paramContentValues.put("medalUpdateTimestamp", Long.valueOf(paramatmo.medalUpdateTimestamp));
    paramContentValues.put("lastMedalTimestamp", Long.valueOf(paramatmo.lastMedalTimestamp));
    paramContentValues.put("diyFontTimestampBytes", paramatmo.diyFontTimestampBytes);
    paramContentValues.put("diyFontConfigBytes", paramatmo.diyFontConfigBytes);
    paramContentValues.put("lastIceBreakCheckTs", Long.valueOf(paramatmo.lastIceBreakCheckTs));
    paramContentValues.put("lastIceBreakChatTs", Long.valueOf(paramatmo.lastIceBreakChatTs));
    paramContentValues.put("makeFrdsTs", Long.valueOf(paramatmo.makeFrdsTs));
    paramContentValues.put("topPositionTime", Long.valueOf(paramatmo.topPositionTime));
    paramContentValues.put("isListenTogetherOpen", Boolean.valueOf(paramatmo.isListenTogetherOpen));
    paramContentValues.put("isSharingLocation", Integer.valueOf(paramatmo.isSharingLocation));
    paramContentValues.put("lastShareLbsMsgUniseq", Long.valueOf(paramatmo.lastShareLbsMsgUniseq));
    paramContentValues.put("mTogetherBusinessFlag", Long.valueOf(paramatmo.mTogetherBusinessFlag));
    paramContentValues.put("messageEnablePreview", Boolean.valueOf(paramatmo.messageEnablePreview));
    paramContentValues.put("messageEnableSound", Boolean.valueOf(paramatmo.messageEnableSound));
    paramContentValues.put("messageEnableVibrate", Boolean.valueOf(paramatmo.messageEnableVibrate));
    paramContentValues.put("friendRingId", Integer.valueOf(paramatmo.friendRingId));
    paramContentValues.put("messageEnablePreviewNew", Integer.valueOf(paramatmo.messageEnablePreviewNew));
    paramContentValues.put("messageEnableSoundNew", Integer.valueOf(paramatmo.messageEnableSoundNew));
    paramContentValues.put("messageEnableVibrateNew", Integer.valueOf(paramatmo.messageEnableVibrateNew));
    paramContentValues.put("hiddenChatSwitch", Integer.valueOf(paramatmo.hiddenChatSwitch));
    paramContentValues.put("intimate_type", Integer.valueOf(paramatmo.intimate_type));
    paramContentValues.put("intimate_level", Integer.valueOf(paramatmo.intimate_level));
    paramContentValues.put("intimate_chatDays", Integer.valueOf(paramatmo.intimate_chatDays));
    paramContentValues.put("last_intimate_chatTime", Long.valueOf(paramatmo.last_intimate_chatTime));
    paramContentValues.put("isExtinguish", Boolean.valueOf(paramatmo.isExtinguish));
    paramContentValues.put("friendshipLevel", Integer.valueOf(paramatmo.friendshipLevel));
    paramContentValues.put("friendshipChatDays", Integer.valueOf(paramatmo.friendshipChatDays));
    paramContentValues.put("lastFriendshipTime", Long.valueOf(paramatmo.lastFriendshipTime));
    paramContentValues.put("chatHotLevel", Integer.valueOf(paramatmo.chatHotLevel));
    paramContentValues.put("chatDays", Integer.valueOf(paramatmo.chatDays));
    paramContentValues.put("lastChatTime", Long.valueOf(paramatmo.lastChatTime));
    paramContentValues.put("praiseHotLevel", Integer.valueOf(paramatmo.praiseHotLevel));
    paramContentValues.put("praiseDays", Integer.valueOf(paramatmo.praiseDays));
    paramContentValues.put("lastpraiseTime", Long.valueOf(paramatmo.lastpraiseTime));
    paramContentValues.put("loverChatLevel", Integer.valueOf(paramatmo.loverChatLevel));
    paramContentValues.put("loverChatDays", Integer.valueOf(paramatmo.loverChatDays));
    paramContentValues.put("loverLastChatTime", Long.valueOf(paramatmo.loverLastChatTime));
    paramContentValues.put("loverFlag", Integer.valueOf(paramatmo.loverFlag));
    paramContentValues.put("loverTransFlag", Boolean.valueOf(paramatmo.loverTransFlag));
    paramContentValues.put("qzoneVisitType", Integer.valueOf(paramatmo.qzoneVisitType));
    paramContentValues.put("qzoneHotDays", Integer.valueOf(paramatmo.qzoneHotDays));
    paramContentValues.put("lastQzoneVisitTime", Long.valueOf(paramatmo.lastQzoneVisitTime));
    paramContentValues.put("bestIntimacyType", Integer.valueOf(paramatmo.bestIntimacyType));
    paramContentValues.put("bestIntimacyDays", Integer.valueOf(paramatmo.bestIntimacyDays));
    paramContentValues.put("newBestIntimacyType", Integer.valueOf(paramatmo.newBestIntimacyType));
    paramContentValues.put("hasRemindChat", Boolean.valueOf(paramatmo.hasRemindChat));
    paramContentValues.put("hasRemindLoverChat", Boolean.valueOf(paramatmo.hasRemindLoverChat));
    paramContentValues.put("hasRemindPraise", Boolean.valueOf(paramatmo.hasRemindPraise));
    paramContentValues.put("hasRemindQzoneVisit", Boolean.valueOf(paramatmo.hasRemindQzoneVisit));
    paramContentValues.put("hasRemindFrdship", Boolean.valueOf(paramatmo.hasRemindFrdship));
    paramContentValues.put("hasRemindIntimate", Boolean.valueOf(paramatmo.hasRemindIntimate));
    paramContentValues.put("localChatSendTs", Long.valueOf(paramatmo.localChatSendTs));
    paramContentValues.put("localChatRecTs", Long.valueOf(paramatmo.localChatRecTs));
    paramContentValues.put("lastHotReactiveReCheckInTs", Long.valueOf(paramatmo.lastHotReactiveReCheckInTs));
    paramContentValues.put("isGrayTipRemind", Integer.valueOf(paramatmo.isGrayTipRemind));
    paramContentValues.put("isGrayTipMultiRemind", Integer.valueOf(paramatmo.isGrayTipMultiRemind));
    paramContentValues.put("mutual_marks_store_json", paramatmo.mutual_marks_store_json);
    paramContentValues.put("mutual_mark_version", Integer.valueOf(paramatmo.mutual_mark_version));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atmt
 * JD-Core Version:    0.7.0.1
 */