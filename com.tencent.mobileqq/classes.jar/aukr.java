import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukr
  extends auky
{
  public aukr()
  {
    this.a = 88;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramaukm = (ExtensionInfo)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramaukm.pendantId = paramCursor.getLong(paramCursor.getColumnIndex("pendantId"));
      paramaukm.pendantDiyId = paramCursor.getInt(paramCursor.getColumnIndex("pendantDiyId"));
      paramaukm.uVipFont = paramCursor.getLong(paramCursor.getColumnIndex("uVipFont"));
      paramaukm.vipFontType = paramCursor.getInt(paramCursor.getColumnIndex("vipFontType"));
      paramaukm.magicFont = paramCursor.getInt(paramCursor.getColumnIndex("magicFont"));
      paramaukm.lastUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("lastUpdateTime"));
      paramaukm.fontEffect = paramCursor.getInt(paramCursor.getColumnIndex("fontEffect"));
      paramaukm.fontEffectLastUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("fontEffectLastUpdateTime"));
      paramaukm.faceId = paramCursor.getInt(paramCursor.getColumnIndex("faceId"));
      paramaukm.faceIdUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("faceIdUpdateTime"));
      paramaukm.colorRingId = paramCursor.getLong(paramCursor.getColumnIndex("colorRingId"));
      paramaukm.commingRingId = paramCursor.getLong(paramCursor.getColumnIndex("commingRingId"));
      paramaukm.timestamp = paramCursor.getLong(paramCursor.getColumnIndex("timestamp"));
      paramaukm.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
      paramaukm.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
      paramaukm.feedType = paramCursor.getInt(paramCursor.getColumnIndex("feedType"));
      paramaukm.feedTime = paramCursor.getLong(paramCursor.getColumnIndex("feedTime"));
      paramaukm.feedContent = paramCursor.getString(paramCursor.getColumnIndex("feedContent"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("feedHasPhoto")))
      {
        paramBoolean = true;
        paramaukm.feedHasPhoto = paramBoolean;
        paramaukm.feedPhotoUrl = paramCursor.getString(paramCursor.getColumnIndex("feedPhotoUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isAdded2C2C"))) {
          break label1742;
        }
        paramBoolean = true;
        label421:
        paramaukm.isAdded2C2C = paramBoolean;
        paramaukm.chatInputType = paramCursor.getInt(paramCursor.getColumnIndex("chatInputType"));
        paramaukm.showC2CPanel = paramCursor.getInt(paramCursor.getColumnIndex("showC2CPanel"));
        paramaukm.pttChangeVoiceType = paramCursor.getInt(paramCursor.getColumnIndex("pttChangeVoiceType"));
        paramaukm.audioPanelType = paramCursor.getInt(paramCursor.getColumnIndex("audioPanelType"));
        paramaukm.openDoNotDisturbTime = paramCursor.getLong(paramCursor.getColumnIndex("openDoNotDisturbTime"));
        paramaukm.latestPLUpdateTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("latestPLUpdateTimestamp"));
        paramaukm.lastPullPLNewsTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastPullPLNewsTimestamp"));
        paramaukm.lastPLNewsTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastPLNewsTimestamp"));
        paramaukm.medalUpdateTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("medalUpdateTimestamp"));
        paramaukm.lastMedalTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastMedalTimestamp"));
        paramaukm.diyFontTimestampBytes = paramCursor.getBlob(paramCursor.getColumnIndex("diyFontTimestampBytes"));
        paramaukm.diyFontConfigBytes = paramCursor.getBlob(paramCursor.getColumnIndex("diyFontConfigBytes"));
        paramaukm.lastIceBreakCheckTs = paramCursor.getLong(paramCursor.getColumnIndex("lastIceBreakCheckTs"));
        paramaukm.lastIceBreakChatTs = paramCursor.getLong(paramCursor.getColumnIndex("lastIceBreakChatTs"));
        paramaukm.makeFrdsTs = paramCursor.getLong(paramCursor.getColumnIndex("makeFrdsTs"));
        paramaukm.topPositionTime = paramCursor.getLong(paramCursor.getColumnIndex("topPositionTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isListenTogetherOpen"))) {
          break label1747;
        }
        paramBoolean = true;
        label734:
        paramaukm.isListenTogetherOpen = paramBoolean;
        paramaukm.isSharingLocation = paramCursor.getInt(paramCursor.getColumnIndex("isSharingLocation"));
        paramaukm.lastShareLbsMsgUniseq = paramCursor.getLong(paramCursor.getColumnIndex("lastShareLbsMsgUniseq"));
        paramaukm.mTogetherBusinessFlag = paramCursor.getLong(paramCursor.getColumnIndex("mTogetherBusinessFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnablePreview"))) {
          break label1752;
        }
        paramBoolean = true;
        label813:
        paramaukm.messageEnablePreview = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnableSound"))) {
          break label1757;
        }
        paramBoolean = true;
        label838:
        paramaukm.messageEnableSound = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnableVibrate"))) {
          break label1762;
        }
        paramBoolean = true;
        label863:
        paramaukm.messageEnableVibrate = paramBoolean;
        paramaukm.friendRingId = paramCursor.getInt(paramCursor.getColumnIndex("friendRingId"));
        paramaukm.messageEnablePreviewNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnablePreviewNew"));
        paramaukm.messageEnableSoundNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnableSoundNew"));
        paramaukm.messageEnableVibrateNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnableVibrateNew"));
        paramaukm.hiddenChatSwitch = paramCursor.getInt(paramCursor.getColumnIndex("hiddenChatSwitch"));
        paramaukm.intimate_type = paramCursor.getInt(paramCursor.getColumnIndex("intimate_type"));
        paramaukm.intimate_level = paramCursor.getInt(paramCursor.getColumnIndex("intimate_level"));
        paramaukm.intimate_chatDays = paramCursor.getInt(paramCursor.getColumnIndex("intimate_chatDays"));
        paramaukm.last_intimate_chatTime = paramCursor.getLong(paramCursor.getColumnIndex("last_intimate_chatTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isExtinguish"))) {
          break label1767;
        }
        paramBoolean = true;
        label1053:
        paramaukm.isExtinguish = paramBoolean;
        paramaukm.friendshipLevel = paramCursor.getInt(paramCursor.getColumnIndex("friendshipLevel"));
        paramaukm.friendshipChatDays = paramCursor.getInt(paramCursor.getColumnIndex("friendshipChatDays"));
        paramaukm.lastFriendshipTime = paramCursor.getLong(paramCursor.getColumnIndex("lastFriendshipTime"));
        paramaukm.chatHotLevel = paramCursor.getInt(paramCursor.getColumnIndex("chatHotLevel"));
        paramaukm.chatDays = paramCursor.getInt(paramCursor.getColumnIndex("chatDays"));
        paramaukm.lastChatTime = paramCursor.getLong(paramCursor.getColumnIndex("lastChatTime"));
        paramaukm.praiseHotLevel = paramCursor.getInt(paramCursor.getColumnIndex("praiseHotLevel"));
        paramaukm.praiseDays = paramCursor.getInt(paramCursor.getColumnIndex("praiseDays"));
        paramaukm.lastpraiseTime = paramCursor.getLong(paramCursor.getColumnIndex("lastpraiseTime"));
        paramaukm.loverChatLevel = paramCursor.getInt(paramCursor.getColumnIndex("loverChatLevel"));
        paramaukm.loverChatDays = paramCursor.getInt(paramCursor.getColumnIndex("loverChatDays"));
        paramaukm.loverLastChatTime = paramCursor.getLong(paramCursor.getColumnIndex("loverLastChatTime"));
        paramaukm.loverFlag = paramCursor.getInt(paramCursor.getColumnIndex("loverFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("loverTransFlag"))) {
          break label1772;
        }
        paramBoolean = true;
        label1326:
        paramaukm.loverTransFlag = paramBoolean;
        paramaukm.qzoneVisitType = paramCursor.getInt(paramCursor.getColumnIndex("qzoneVisitType"));
        paramaukm.qzoneHotDays = paramCursor.getInt(paramCursor.getColumnIndex("qzoneHotDays"));
        paramaukm.lastQzoneVisitTime = paramCursor.getLong(paramCursor.getColumnIndex("lastQzoneVisitTime"));
        paramaukm.bestIntimacyType = paramCursor.getInt(paramCursor.getColumnIndex("bestIntimacyType"));
        paramaukm.bestIntimacyDays = paramCursor.getInt(paramCursor.getColumnIndex("bestIntimacyDays"));
        paramaukm.newBestIntimacyType = paramCursor.getInt(paramCursor.getColumnIndex("newBestIntimacyType"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindChat"))) {
          break label1777;
        }
        paramBoolean = true;
        label1466:
        paramaukm.hasRemindChat = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindLoverChat"))) {
          break label1782;
        }
        paramBoolean = true;
        label1492:
        paramaukm.hasRemindLoverChat = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindPraise"))) {
          break label1787;
        }
        paramBoolean = true;
        label1518:
        paramaukm.hasRemindPraise = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindQzoneVisit"))) {
          break label1792;
        }
        paramBoolean = true;
        label1544:
        paramaukm.hasRemindQzoneVisit = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindFrdship"))) {
          break label1797;
        }
        paramBoolean = true;
        label1570:
        paramaukm.hasRemindFrdship = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindIntimate"))) {
          break label1802;
        }
      }
      label1792:
      label1797:
      label1802:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramaukm.hasRemindIntimate = paramBoolean;
        paramaukm.localChatSendTs = paramCursor.getLong(paramCursor.getColumnIndex("localChatSendTs"));
        paramaukm.localChatRecTs = paramCursor.getLong(paramCursor.getColumnIndex("localChatRecTs"));
        paramaukm.lastHotReactiveReCheckInTs = paramCursor.getLong(paramCursor.getColumnIndex("lastHotReactiveReCheckInTs"));
        paramaukm.isGrayTipRemind = paramCursor.getInt(paramCursor.getColumnIndex("isGrayTipRemind"));
        paramaukm.isGrayTipMultiRemind = paramCursor.getInt(paramCursor.getColumnIndex("isGrayTipMultiRemind"));
        paramaukm.mutual_marks_store_json = paramCursor.getString(paramCursor.getColumnIndex("mutual_marks_store_json"));
        paramaukm.mutual_mark_version = paramCursor.getInt(paramCursor.getColumnIndex("mutual_mark_version"));
        return paramaukm;
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
      paramaukx.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("pendantId");
      if (i != -1) {
        break label4976;
      }
      paramaukx.a(new NoColumnError("pendantId", Long.TYPE));
      label1877:
      i = paramCursor.getColumnIndex("pendantDiyId");
      if (i != -1) {
        break label4991;
      }
      paramaukx.a(new NoColumnError("pendantDiyId", Integer.TYPE));
      label1912:
      i = paramCursor.getColumnIndex("uVipFont");
      if (i != -1) {
        break label5006;
      }
      paramaukx.a(new NoColumnError("uVipFont", Long.TYPE));
      label1947:
      i = paramCursor.getColumnIndex("vipFontType");
      if (i != -1) {
        break label5021;
      }
      paramaukx.a(new NoColumnError("vipFontType", Integer.TYPE));
      label1982:
      i = paramCursor.getColumnIndex("magicFont");
      if (i != -1) {
        break label5036;
      }
      paramaukx.a(new NoColumnError("magicFont", Integer.TYPE));
      label2017:
      i = paramCursor.getColumnIndex("lastUpdateTime");
      if (i != -1) {
        break label5051;
      }
      paramaukx.a(new NoColumnError("lastUpdateTime", Long.TYPE));
      label2052:
      i = paramCursor.getColumnIndex("fontEffect");
      if (i != -1) {
        break label5066;
      }
      paramaukx.a(new NoColumnError("fontEffect", Integer.TYPE));
      label2087:
      i = paramCursor.getColumnIndex("fontEffectLastUpdateTime");
      if (i != -1) {
        break label5081;
      }
      paramaukx.a(new NoColumnError("fontEffectLastUpdateTime", Long.TYPE));
      label2122:
      i = paramCursor.getColumnIndex("faceId");
      if (i != -1) {
        break label5096;
      }
      paramaukx.a(new NoColumnError("faceId", Integer.TYPE));
      label2157:
      i = paramCursor.getColumnIndex("faceIdUpdateTime");
      if (i != -1) {
        break label5111;
      }
      paramaukx.a(new NoColumnError("faceIdUpdateTime", Long.TYPE));
      label2192:
      i = paramCursor.getColumnIndex("colorRingId");
      if (i != -1) {
        break label5126;
      }
      paramaukx.a(new NoColumnError("colorRingId", Long.TYPE));
      label2227:
      i = paramCursor.getColumnIndex("commingRingId");
      if (i != -1) {
        break label5141;
      }
      paramaukx.a(new NoColumnError("commingRingId", Long.TYPE));
      label2262:
      i = paramCursor.getColumnIndex("timestamp");
      if (i != -1) {
        break label5156;
      }
      paramaukx.a(new NoColumnError("timestamp", Long.TYPE));
      label2297:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label5171;
      }
      paramaukx.a(new NoColumnError("richTime", Long.TYPE));
      label2332:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label5186;
      }
      paramaukx.a(new NoColumnError("richBuffer", [B.class));
      label2367:
      i = paramCursor.getColumnIndex("feedType");
      if (i != -1) {
        break label5201;
      }
      paramaukx.a(new NoColumnError("feedType", Integer.TYPE));
      label2402:
      i = paramCursor.getColumnIndex("feedTime");
      if (i != -1) {
        break label5216;
      }
      paramaukx.a(new NoColumnError("feedTime", Long.TYPE));
      label2437:
      i = paramCursor.getColumnIndex("feedContent");
      if (i != -1) {
        break label5231;
      }
      paramaukx.a(new NoColumnError("feedContent", String.class));
      label2472:
      i = paramCursor.getColumnIndex("feedHasPhoto");
      if (i != -1) {
        break label5246;
      }
      paramaukx.a(new NoColumnError("feedHasPhoto", Boolean.TYPE));
      i = paramCursor.getColumnIndex("feedPhotoUrl");
      if (i != -1) {
        break label5273;
      }
      paramaukx.a(new NoColumnError("feedPhotoUrl", String.class));
      label2542:
      i = paramCursor.getColumnIndex("isAdded2C2C");
      if (i != -1) {
        break label5288;
      }
      paramaukx.a(new NoColumnError("isAdded2C2C", Boolean.TYPE));
      i = paramCursor.getColumnIndex("chatInputType");
      if (i != -1) {
        break label5315;
      }
      paramaukx.a(new NoColumnError("chatInputType", Integer.TYPE));
      label2612:
      i = paramCursor.getColumnIndex("showC2CPanel");
      if (i != -1) {
        break label5330;
      }
      paramaukx.a(new NoColumnError("showC2CPanel", Integer.TYPE));
      label2647:
      i = paramCursor.getColumnIndex("pttChangeVoiceType");
      if (i != -1) {
        break label5345;
      }
      paramaukx.a(new NoColumnError("pttChangeVoiceType", Integer.TYPE));
      label2682:
      i = paramCursor.getColumnIndex("audioPanelType");
      if (i != -1) {
        break label5360;
      }
      paramaukx.a(new NoColumnError("audioPanelType", Integer.TYPE));
      label2717:
      i = paramCursor.getColumnIndex("openDoNotDisturbTime");
      if (i != -1) {
        break label5375;
      }
      paramaukx.a(new NoColumnError("openDoNotDisturbTime", Long.TYPE));
      label2752:
      i = paramCursor.getColumnIndex("latestPLUpdateTimestamp");
      if (i != -1) {
        break label5390;
      }
      paramaukx.a(new NoColumnError("latestPLUpdateTimestamp", Long.TYPE));
      label2787:
      i = paramCursor.getColumnIndex("lastPullPLNewsTimestamp");
      if (i != -1) {
        break label5405;
      }
      paramaukx.a(new NoColumnError("lastPullPLNewsTimestamp", Long.TYPE));
      label2822:
      i = paramCursor.getColumnIndex("lastPLNewsTimestamp");
      if (i != -1) {
        break label5420;
      }
      paramaukx.a(new NoColumnError("lastPLNewsTimestamp", Long.TYPE));
      label2857:
      i = paramCursor.getColumnIndex("medalUpdateTimestamp");
      if (i != -1) {
        break label5435;
      }
      paramaukx.a(new NoColumnError("medalUpdateTimestamp", Long.TYPE));
      label2892:
      i = paramCursor.getColumnIndex("lastMedalTimestamp");
      if (i != -1) {
        break label5450;
      }
      paramaukx.a(new NoColumnError("lastMedalTimestamp", Long.TYPE));
      label2927:
      i = paramCursor.getColumnIndex("diyFontTimestampBytes");
      if (i != -1) {
        break label5465;
      }
      paramaukx.a(new NoColumnError("diyFontTimestampBytes", [B.class));
      label2962:
      i = paramCursor.getColumnIndex("diyFontConfigBytes");
      if (i != -1) {
        break label5480;
      }
      paramaukx.a(new NoColumnError("diyFontConfigBytes", [B.class));
      label2997:
      i = paramCursor.getColumnIndex("lastIceBreakCheckTs");
      if (i != -1) {
        break label5495;
      }
      paramaukx.a(new NoColumnError("lastIceBreakCheckTs", Long.TYPE));
      label3032:
      i = paramCursor.getColumnIndex("lastIceBreakChatTs");
      if (i != -1) {
        break label5510;
      }
      paramaukx.a(new NoColumnError("lastIceBreakChatTs", Long.TYPE));
      label3067:
      i = paramCursor.getColumnIndex("makeFrdsTs");
      if (i != -1) {
        break label5525;
      }
      paramaukx.a(new NoColumnError("makeFrdsTs", Long.TYPE));
      label3102:
      i = paramCursor.getColumnIndex("topPositionTime");
      if (i != -1) {
        break label5540;
      }
      paramaukx.a(new NoColumnError("topPositionTime", Long.TYPE));
      label3137:
      i = paramCursor.getColumnIndex("isListenTogetherOpen");
      if (i != -1) {
        break label5555;
      }
      paramaukx.a(new NoColumnError("isListenTogetherOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isSharingLocation");
      if (i != -1) {
        break label5582;
      }
      paramaukx.a(new NoColumnError("isSharingLocation", Integer.TYPE));
      label3207:
      i = paramCursor.getColumnIndex("lastShareLbsMsgUniseq");
      if (i != -1) {
        break label5597;
      }
      paramaukx.a(new NoColumnError("lastShareLbsMsgUniseq", Long.TYPE));
      label3242:
      i = paramCursor.getColumnIndex("mTogetherBusinessFlag");
      if (i != -1) {
        break label5612;
      }
      paramaukx.a(new NoColumnError("mTogetherBusinessFlag", Long.TYPE));
      label3277:
      i = paramCursor.getColumnIndex("messageEnablePreview");
      if (i != -1) {
        break label5627;
      }
      paramaukx.a(new NoColumnError("messageEnablePreview", Boolean.TYPE));
      i = paramCursor.getColumnIndex("messageEnableSound");
      if (i != -1) {
        break label5654;
      }
      paramaukx.a(new NoColumnError("messageEnableSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("messageEnableVibrate");
      if (i != -1) {
        break label5681;
      }
      paramaukx.a(new NoColumnError("messageEnableVibrate", Boolean.TYPE));
      i = paramCursor.getColumnIndex("friendRingId");
      if (i != -1) {
        break label5708;
      }
      paramaukx.a(new NoColumnError("friendRingId", Integer.TYPE));
      label3417:
      i = paramCursor.getColumnIndex("messageEnablePreviewNew");
      if (i != -1) {
        break label5723;
      }
      paramaukx.a(new NoColumnError("messageEnablePreviewNew", Integer.TYPE));
      label3452:
      i = paramCursor.getColumnIndex("messageEnableSoundNew");
      if (i != -1) {
        break label5738;
      }
      paramaukx.a(new NoColumnError("messageEnableSoundNew", Integer.TYPE));
      label3487:
      i = paramCursor.getColumnIndex("messageEnableVibrateNew");
      if (i != -1) {
        break label5753;
      }
      paramaukx.a(new NoColumnError("messageEnableVibrateNew", Integer.TYPE));
      label3522:
      i = paramCursor.getColumnIndex("hiddenChatSwitch");
      if (i != -1) {
        break label5768;
      }
      paramaukx.a(new NoColumnError("hiddenChatSwitch", Integer.TYPE));
      label3557:
      i = paramCursor.getColumnIndex("intimate_type");
      if (i != -1) {
        break label5783;
      }
      paramaukx.a(new NoColumnError("intimate_type", Integer.TYPE));
      label3592:
      i = paramCursor.getColumnIndex("intimate_level");
      if (i != -1) {
        break label5798;
      }
      paramaukx.a(new NoColumnError("intimate_level", Integer.TYPE));
      label3627:
      i = paramCursor.getColumnIndex("intimate_chatDays");
      if (i != -1) {
        break label5813;
      }
      paramaukx.a(new NoColumnError("intimate_chatDays", Integer.TYPE));
      label3664:
      i = paramCursor.getColumnIndex("last_intimate_chatTime");
      if (i != -1) {
        break label5828;
      }
      paramaukx.a(new NoColumnError("last_intimate_chatTime", Long.TYPE));
      label3701:
      i = paramCursor.getColumnIndex("isExtinguish");
      if (i != -1) {
        break label5843;
      }
      paramaukx.a(new NoColumnError("isExtinguish", Boolean.TYPE));
      i = paramCursor.getColumnIndex("friendshipLevel");
      if (i != -1) {
        break label5870;
      }
      paramaukx.a(new NoColumnError("friendshipLevel", Integer.TYPE));
      label3775:
      i = paramCursor.getColumnIndex("friendshipChatDays");
      if (i != -1) {
        break label5885;
      }
      paramaukx.a(new NoColumnError("friendshipChatDays", Integer.TYPE));
      label3812:
      i = paramCursor.getColumnIndex("lastFriendshipTime");
      if (i != -1) {
        break label5900;
      }
      paramaukx.a(new NoColumnError("lastFriendshipTime", Long.TYPE));
      label3849:
      i = paramCursor.getColumnIndex("chatHotLevel");
      if (i != -1) {
        break label5915;
      }
      paramaukx.a(new NoColumnError("chatHotLevel", Integer.TYPE));
      label3886:
      i = paramCursor.getColumnIndex("chatDays");
      if (i != -1) {
        break label5930;
      }
      paramaukx.a(new NoColumnError("chatDays", Integer.TYPE));
      label3923:
      i = paramCursor.getColumnIndex("lastChatTime");
      if (i != -1) {
        break label5945;
      }
      paramaukx.a(new NoColumnError("lastChatTime", Long.TYPE));
      label3960:
      i = paramCursor.getColumnIndex("praiseHotLevel");
      if (i != -1) {
        break label5960;
      }
      paramaukx.a(new NoColumnError("praiseHotLevel", Integer.TYPE));
      label3997:
      i = paramCursor.getColumnIndex("praiseDays");
      if (i != -1) {
        break label5975;
      }
      paramaukx.a(new NoColumnError("praiseDays", Integer.TYPE));
      label4034:
      i = paramCursor.getColumnIndex("lastpraiseTime");
      if (i != -1) {
        break label5990;
      }
      paramaukx.a(new NoColumnError("lastpraiseTime", Long.TYPE));
      label4071:
      i = paramCursor.getColumnIndex("loverChatLevel");
      if (i != -1) {
        break label6005;
      }
      paramaukx.a(new NoColumnError("loverChatLevel", Integer.TYPE));
      label4108:
      i = paramCursor.getColumnIndex("loverChatDays");
      if (i != -1) {
        break label6020;
      }
      paramaukx.a(new NoColumnError("loverChatDays", Integer.TYPE));
      label4145:
      i = paramCursor.getColumnIndex("loverLastChatTime");
      if (i != -1) {
        break label6035;
      }
      paramaukx.a(new NoColumnError("loverLastChatTime", Long.TYPE));
      label4182:
      i = paramCursor.getColumnIndex("loverFlag");
      if (i != -1) {
        break label6050;
      }
      paramaukx.a(new NoColumnError("loverFlag", Integer.TYPE));
      label4219:
      i = paramCursor.getColumnIndex("loverTransFlag");
      if (i != -1) {
        break label6065;
      }
      paramaukx.a(new NoColumnError("loverTransFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("qzoneVisitType");
      if (i != -1) {
        break label6092;
      }
      paramaukx.a(new NoColumnError("qzoneVisitType", Integer.TYPE));
      label4293:
      i = paramCursor.getColumnIndex("qzoneHotDays");
      if (i != -1) {
        break label6107;
      }
      paramaukx.a(new NoColumnError("qzoneHotDays", Integer.TYPE));
      label4330:
      i = paramCursor.getColumnIndex("lastQzoneVisitTime");
      if (i != -1) {
        break label6122;
      }
      paramaukx.a(new NoColumnError("lastQzoneVisitTime", Long.TYPE));
      label4367:
      i = paramCursor.getColumnIndex("bestIntimacyType");
      if (i != -1) {
        break label6137;
      }
      paramaukx.a(new NoColumnError("bestIntimacyType", Integer.TYPE));
      label4404:
      i = paramCursor.getColumnIndex("bestIntimacyDays");
      if (i != -1) {
        break label6152;
      }
      paramaukx.a(new NoColumnError("bestIntimacyDays", Integer.TYPE));
      label4441:
      i = paramCursor.getColumnIndex("newBestIntimacyType");
      if (i != -1) {
        break label6167;
      }
      paramaukx.a(new NoColumnError("newBestIntimacyType", Integer.TYPE));
      label4478:
      i = paramCursor.getColumnIndex("hasRemindChat");
      if (i != -1) {
        break label6182;
      }
      paramaukx.a(new NoColumnError("hasRemindChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindLoverChat");
      if (i != -1) {
        break label6209;
      }
      paramaukx.a(new NoColumnError("hasRemindLoverChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindPraise");
      if (i != -1) {
        break label6236;
      }
      paramaukx.a(new NoColumnError("hasRemindPraise", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindQzoneVisit");
      if (i != -1) {
        break label6263;
      }
      paramaukx.a(new NoColumnError("hasRemindQzoneVisit", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindFrdship");
      if (i != -1) {
        break label6290;
      }
      paramaukx.a(new NoColumnError("hasRemindFrdship", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindIntimate");
      if (i != -1) {
        break label6317;
      }
      paramaukx.a(new NoColumnError("hasRemindIntimate", Boolean.TYPE));
      i = paramCursor.getColumnIndex("localChatSendTs");
      if (i != -1) {
        break label6345;
      }
      paramaukx.a(new NoColumnError("localChatSendTs", Long.TYPE));
      label4737:
      i = paramCursor.getColumnIndex("localChatRecTs");
      if (i != -1) {
        break label6360;
      }
      paramaukx.a(new NoColumnError("localChatRecTs", Long.TYPE));
      label4774:
      i = paramCursor.getColumnIndex("lastHotReactiveReCheckInTs");
      if (i != -1) {
        break label6375;
      }
      paramaukx.a(new NoColumnError("lastHotReactiveReCheckInTs", Long.TYPE));
      label4811:
      i = paramCursor.getColumnIndex("isGrayTipRemind");
      if (i != -1) {
        break label6390;
      }
      paramaukx.a(new NoColumnError("isGrayTipRemind", Integer.TYPE));
      label4848:
      i = paramCursor.getColumnIndex("isGrayTipMultiRemind");
      if (i != -1) {
        break label6405;
      }
      paramaukx.a(new NoColumnError("isGrayTipMultiRemind", Integer.TYPE));
      label4885:
      i = paramCursor.getColumnIndex("mutual_marks_store_json");
      if (i != -1) {
        break label6420;
      }
      paramaukx.a(new NoColumnError("mutual_marks_store_json", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("mutual_mark_version");
      if (i != -1) {
        break label6435;
      }
      paramaukx.a(new NoColumnError("mutual_mark_version", Integer.TYPE));
      return paramaukm;
      paramaukm.uin = paramCursor.getString(i);
      break;
      label4976:
      paramaukm.pendantId = paramCursor.getLong(i);
      break label1877;
      label4991:
      paramaukm.pendantDiyId = paramCursor.getInt(i);
      break label1912;
      label5006:
      paramaukm.uVipFont = paramCursor.getLong(i);
      break label1947;
      label5021:
      paramaukm.vipFontType = paramCursor.getInt(i);
      break label1982;
      label5036:
      paramaukm.magicFont = paramCursor.getInt(i);
      break label2017;
      label5051:
      paramaukm.lastUpdateTime = paramCursor.getLong(i);
      break label2052;
      label5066:
      paramaukm.fontEffect = paramCursor.getInt(i);
      break label2087;
      label5081:
      paramaukm.fontEffectLastUpdateTime = paramCursor.getLong(i);
      break label2122;
      label5096:
      paramaukm.faceId = paramCursor.getInt(i);
      break label2157;
      label5111:
      paramaukm.faceIdUpdateTime = paramCursor.getLong(i);
      break label2192;
      label5126:
      paramaukm.colorRingId = paramCursor.getLong(i);
      break label2227;
      label5141:
      paramaukm.commingRingId = paramCursor.getLong(i);
      break label2262;
      label5156:
      paramaukm.timestamp = paramCursor.getLong(i);
      break label2297;
      label5171:
      paramaukm.richTime = paramCursor.getLong(i);
      break label2332;
      label5186:
      paramaukm.richBuffer = paramCursor.getBlob(i);
      break label2367;
      label5201:
      paramaukm.feedType = paramCursor.getInt(i);
      break label2402;
      label5216:
      paramaukm.feedTime = paramCursor.getLong(i);
      break label2437;
      label5231:
      paramaukm.feedContent = paramCursor.getString(i);
      break label2472;
      label5246:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.feedHasPhoto = paramBoolean;
        break;
      }
      label5273:
      paramaukm.feedPhotoUrl = paramCursor.getString(i);
      break label2542;
      label5288:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isAdded2C2C = paramBoolean;
        break;
      }
      label5315:
      paramaukm.chatInputType = paramCursor.getInt(i);
      break label2612;
      label5330:
      paramaukm.showC2CPanel = paramCursor.getInt(i);
      break label2647;
      label5345:
      paramaukm.pttChangeVoiceType = paramCursor.getInt(i);
      break label2682;
      label5360:
      paramaukm.audioPanelType = paramCursor.getInt(i);
      break label2717;
      label5375:
      paramaukm.openDoNotDisturbTime = paramCursor.getLong(i);
      break label2752;
      label5390:
      paramaukm.latestPLUpdateTimestamp = paramCursor.getLong(i);
      break label2787;
      label5405:
      paramaukm.lastPullPLNewsTimestamp = paramCursor.getLong(i);
      break label2822;
      label5420:
      paramaukm.lastPLNewsTimestamp = paramCursor.getLong(i);
      break label2857;
      label5435:
      paramaukm.medalUpdateTimestamp = paramCursor.getLong(i);
      break label2892;
      label5450:
      paramaukm.lastMedalTimestamp = paramCursor.getLong(i);
      break label2927;
      label5465:
      paramaukm.diyFontTimestampBytes = paramCursor.getBlob(i);
      break label2962;
      label5480:
      paramaukm.diyFontConfigBytes = paramCursor.getBlob(i);
      break label2997;
      label5495:
      paramaukm.lastIceBreakCheckTs = paramCursor.getLong(i);
      break label3032;
      label5510:
      paramaukm.lastIceBreakChatTs = paramCursor.getLong(i);
      break label3067;
      label5525:
      paramaukm.makeFrdsTs = paramCursor.getLong(i);
      break label3102;
      label5540:
      paramaukm.topPositionTime = paramCursor.getLong(i);
      break label3137;
      label5555:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isListenTogetherOpen = paramBoolean;
        break;
      }
      label5582:
      paramaukm.isSharingLocation = paramCursor.getInt(i);
      break label3207;
      label5597:
      paramaukm.lastShareLbsMsgUniseq = paramCursor.getLong(i);
      break label3242;
      label5612:
      paramaukm.mTogetherBusinessFlag = paramCursor.getLong(i);
      break label3277;
      label5627:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.messageEnablePreview = paramBoolean;
        break;
      }
      label5654:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.messageEnableSound = paramBoolean;
        break;
      }
      label5681:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.messageEnableVibrate = paramBoolean;
        break;
      }
      label5708:
      paramaukm.friendRingId = paramCursor.getInt(i);
      break label3417;
      label5723:
      paramaukm.messageEnablePreviewNew = paramCursor.getInt(i);
      break label3452;
      label5738:
      paramaukm.messageEnableSoundNew = paramCursor.getInt(i);
      break label3487;
      label5753:
      paramaukm.messageEnableVibrateNew = paramCursor.getInt(i);
      break label3522;
      label5768:
      paramaukm.hiddenChatSwitch = paramCursor.getInt(i);
      break label3557;
      label5783:
      paramaukm.intimate_type = paramCursor.getInt(i);
      break label3592;
      label5798:
      paramaukm.intimate_level = paramCursor.getInt(i);
      break label3627;
      label5813:
      paramaukm.intimate_chatDays = paramCursor.getInt(i);
      break label3664;
      label5828:
      paramaukm.last_intimate_chatTime = paramCursor.getLong(i);
      break label3701;
      label5843:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isExtinguish = paramBoolean;
        break;
      }
      label5870:
      paramaukm.friendshipLevel = paramCursor.getInt(i);
      break label3775;
      label5885:
      paramaukm.friendshipChatDays = paramCursor.getInt(i);
      break label3812;
      label5900:
      paramaukm.lastFriendshipTime = paramCursor.getLong(i);
      break label3849;
      label5915:
      paramaukm.chatHotLevel = paramCursor.getInt(i);
      break label3886;
      label5930:
      paramaukm.chatDays = paramCursor.getInt(i);
      break label3923;
      label5945:
      paramaukm.lastChatTime = paramCursor.getLong(i);
      break label3960;
      label5960:
      paramaukm.praiseHotLevel = paramCursor.getInt(i);
      break label3997;
      label5975:
      paramaukm.praiseDays = paramCursor.getInt(i);
      break label4034;
      label5990:
      paramaukm.lastpraiseTime = paramCursor.getLong(i);
      break label4071;
      label6005:
      paramaukm.loverChatLevel = paramCursor.getInt(i);
      break label4108;
      label6020:
      paramaukm.loverChatDays = paramCursor.getInt(i);
      break label4145;
      label6035:
      paramaukm.loverLastChatTime = paramCursor.getLong(i);
      break label4182;
      label6050:
      paramaukm.loverFlag = paramCursor.getInt(i);
      break label4219;
      label6065:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.loverTransFlag = paramBoolean;
        break;
      }
      label6092:
      paramaukm.qzoneVisitType = paramCursor.getInt(i);
      break label4293;
      label6107:
      paramaukm.qzoneHotDays = paramCursor.getInt(i);
      break label4330;
      label6122:
      paramaukm.lastQzoneVisitTime = paramCursor.getLong(i);
      break label4367;
      label6137:
      paramaukm.bestIntimacyType = paramCursor.getInt(i);
      break label4404;
      label6152:
      paramaukm.bestIntimacyDays = paramCursor.getInt(i);
      break label4441;
      label6167:
      paramaukm.newBestIntimacyType = paramCursor.getInt(i);
      break label4478;
      label6182:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.hasRemindChat = paramBoolean;
        break;
      }
      label6209:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.hasRemindLoverChat = paramBoolean;
        break;
      }
      label6236:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.hasRemindPraise = paramBoolean;
        break;
      }
      label6263:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.hasRemindQzoneVisit = paramBoolean;
        break;
      }
      label6290:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.hasRemindFrdship = paramBoolean;
        break;
      }
      label6317:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramaukm.hasRemindIntimate = paramBoolean;
        break;
      }
      label6345:
      paramaukm.localChatSendTs = paramCursor.getLong(i);
      break label4737;
      label6360:
      paramaukm.localChatRecTs = paramCursor.getLong(i);
      break label4774;
      label6375:
      paramaukm.lastHotReactiveReCheckInTs = paramCursor.getLong(i);
      break label4811;
      label6390:
      paramaukm.isGrayTipRemind = paramCursor.getInt(i);
      break label4848;
      label6405:
      paramaukm.isGrayTipMultiRemind = paramCursor.getInt(i);
      break label4885;
      label6420:
      paramaukm.mutual_marks_store_json = paramCursor.getString(i);
    }
    label6435:
    paramaukm.mutual_mark_version = paramCursor.getInt(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,pendantId INTEGER ,pendantDiyId INTEGER ,uVipFont INTEGER ,vipFontType INTEGER ,magicFont INTEGER ,lastUpdateTime INTEGER ,fontEffect INTEGER ,fontEffectLastUpdateTime INTEGER ,faceId INTEGER ,faceIdUpdateTime INTEGER ,colorRingId INTEGER ,commingRingId INTEGER ,timestamp INTEGER ,richTime INTEGER ,richBuffer BLOB ,feedType INTEGER ,feedTime INTEGER ,feedContent TEXT ,feedHasPhoto INTEGER ,feedPhotoUrl TEXT ,isAdded2C2C INTEGER ,chatInputType INTEGER ,showC2CPanel INTEGER ,pttChangeVoiceType INTEGER ,audioPanelType INTEGER ,openDoNotDisturbTime INTEGER ,latestPLUpdateTimestamp INTEGER ,lastPullPLNewsTimestamp INTEGER ,lastPLNewsTimestamp INTEGER ,medalUpdateTimestamp INTEGER ,lastMedalTimestamp INTEGER ,diyFontTimestampBytes BLOB ,diyFontConfigBytes BLOB ,lastIceBreakCheckTs INTEGER ,lastIceBreakChatTs INTEGER ,makeFrdsTs INTEGER ,topPositionTime INTEGER ,isListenTogetherOpen INTEGER ,isSharingLocation INTEGER ,lastShareLbsMsgUniseq INTEGER ,mTogetherBusinessFlag INTEGER ,messageEnablePreview INTEGER ,messageEnableSound INTEGER ,messageEnableVibrate INTEGER ,friendRingId INTEGER ,messageEnablePreviewNew INTEGER ,messageEnableSoundNew INTEGER ,messageEnableVibrateNew INTEGER ,hiddenChatSwitch INTEGER ,intimate_type INTEGER ,intimate_level INTEGER ,intimate_chatDays INTEGER ,last_intimate_chatTime INTEGER ,isExtinguish INTEGER ,friendshipLevel INTEGER ,friendshipChatDays INTEGER ,lastFriendshipTime INTEGER ,chatHotLevel INTEGER ,chatDays INTEGER ,lastChatTime INTEGER ,praiseHotLevel INTEGER ,praiseDays INTEGER ,lastpraiseTime INTEGER ,loverChatLevel INTEGER ,loverChatDays INTEGER ,loverLastChatTime INTEGER ,loverFlag INTEGER ,loverTransFlag INTEGER ,qzoneVisitType INTEGER ,qzoneHotDays INTEGER ,lastQzoneVisitTime INTEGER ,bestIntimacyType INTEGER ,bestIntimacyDays INTEGER ,newBestIntimacyType INTEGER ,hasRemindChat INTEGER ,hasRemindLoverChat INTEGER ,hasRemindPraise INTEGER ,hasRemindQzoneVisit INTEGER ,hasRemindFrdship INTEGER ,hasRemindIntimate INTEGER ,localChatSendTs INTEGER ,localChatRecTs INTEGER ,lastHotReactiveReCheckInTs INTEGER ,isGrayTipRemind INTEGER ,isGrayTipMultiRemind INTEGER ,mutual_marks_store_json TEXT ,mutual_mark_version INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (ExtensionInfo)paramaukm;
    paramContentValues.put("uin", paramaukm.uin);
    paramContentValues.put("pendantId", Long.valueOf(paramaukm.pendantId));
    paramContentValues.put("pendantDiyId", Integer.valueOf(paramaukm.pendantDiyId));
    paramContentValues.put("uVipFont", Long.valueOf(paramaukm.uVipFont));
    paramContentValues.put("vipFontType", Integer.valueOf(paramaukm.vipFontType));
    paramContentValues.put("magicFont", Integer.valueOf(paramaukm.magicFont));
    paramContentValues.put("lastUpdateTime", Long.valueOf(paramaukm.lastUpdateTime));
    paramContentValues.put("fontEffect", Integer.valueOf(paramaukm.fontEffect));
    paramContentValues.put("fontEffectLastUpdateTime", Long.valueOf(paramaukm.fontEffectLastUpdateTime));
    paramContentValues.put("faceId", Integer.valueOf(paramaukm.faceId));
    paramContentValues.put("faceIdUpdateTime", Long.valueOf(paramaukm.faceIdUpdateTime));
    paramContentValues.put("colorRingId", Long.valueOf(paramaukm.colorRingId));
    paramContentValues.put("commingRingId", Long.valueOf(paramaukm.commingRingId));
    paramContentValues.put("timestamp", Long.valueOf(paramaukm.timestamp));
    paramContentValues.put("richTime", Long.valueOf(paramaukm.richTime));
    paramContentValues.put("richBuffer", paramaukm.richBuffer);
    paramContentValues.put("feedType", Integer.valueOf(paramaukm.feedType));
    paramContentValues.put("feedTime", Long.valueOf(paramaukm.feedTime));
    paramContentValues.put("feedContent", paramaukm.feedContent);
    paramContentValues.put("feedHasPhoto", Boolean.valueOf(paramaukm.feedHasPhoto));
    paramContentValues.put("feedPhotoUrl", paramaukm.feedPhotoUrl);
    paramContentValues.put("isAdded2C2C", Boolean.valueOf(paramaukm.isAdded2C2C));
    paramContentValues.put("chatInputType", Integer.valueOf(paramaukm.chatInputType));
    paramContentValues.put("showC2CPanel", Integer.valueOf(paramaukm.showC2CPanel));
    paramContentValues.put("pttChangeVoiceType", Integer.valueOf(paramaukm.pttChangeVoiceType));
    paramContentValues.put("audioPanelType", Integer.valueOf(paramaukm.audioPanelType));
    paramContentValues.put("openDoNotDisturbTime", Long.valueOf(paramaukm.openDoNotDisturbTime));
    paramContentValues.put("latestPLUpdateTimestamp", Long.valueOf(paramaukm.latestPLUpdateTimestamp));
    paramContentValues.put("lastPullPLNewsTimestamp", Long.valueOf(paramaukm.lastPullPLNewsTimestamp));
    paramContentValues.put("lastPLNewsTimestamp", Long.valueOf(paramaukm.lastPLNewsTimestamp));
    paramContentValues.put("medalUpdateTimestamp", Long.valueOf(paramaukm.medalUpdateTimestamp));
    paramContentValues.put("lastMedalTimestamp", Long.valueOf(paramaukm.lastMedalTimestamp));
    paramContentValues.put("diyFontTimestampBytes", paramaukm.diyFontTimestampBytes);
    paramContentValues.put("diyFontConfigBytes", paramaukm.diyFontConfigBytes);
    paramContentValues.put("lastIceBreakCheckTs", Long.valueOf(paramaukm.lastIceBreakCheckTs));
    paramContentValues.put("lastIceBreakChatTs", Long.valueOf(paramaukm.lastIceBreakChatTs));
    paramContentValues.put("makeFrdsTs", Long.valueOf(paramaukm.makeFrdsTs));
    paramContentValues.put("topPositionTime", Long.valueOf(paramaukm.topPositionTime));
    paramContentValues.put("isListenTogetherOpen", Boolean.valueOf(paramaukm.isListenTogetherOpen));
    paramContentValues.put("isSharingLocation", Integer.valueOf(paramaukm.isSharingLocation));
    paramContentValues.put("lastShareLbsMsgUniseq", Long.valueOf(paramaukm.lastShareLbsMsgUniseq));
    paramContentValues.put("mTogetherBusinessFlag", Long.valueOf(paramaukm.mTogetherBusinessFlag));
    paramContentValues.put("messageEnablePreview", Boolean.valueOf(paramaukm.messageEnablePreview));
    paramContentValues.put("messageEnableSound", Boolean.valueOf(paramaukm.messageEnableSound));
    paramContentValues.put("messageEnableVibrate", Boolean.valueOf(paramaukm.messageEnableVibrate));
    paramContentValues.put("friendRingId", Integer.valueOf(paramaukm.friendRingId));
    paramContentValues.put("messageEnablePreviewNew", Integer.valueOf(paramaukm.messageEnablePreviewNew));
    paramContentValues.put("messageEnableSoundNew", Integer.valueOf(paramaukm.messageEnableSoundNew));
    paramContentValues.put("messageEnableVibrateNew", Integer.valueOf(paramaukm.messageEnableVibrateNew));
    paramContentValues.put("hiddenChatSwitch", Integer.valueOf(paramaukm.hiddenChatSwitch));
    paramContentValues.put("intimate_type", Integer.valueOf(paramaukm.intimate_type));
    paramContentValues.put("intimate_level", Integer.valueOf(paramaukm.intimate_level));
    paramContentValues.put("intimate_chatDays", Integer.valueOf(paramaukm.intimate_chatDays));
    paramContentValues.put("last_intimate_chatTime", Long.valueOf(paramaukm.last_intimate_chatTime));
    paramContentValues.put("isExtinguish", Boolean.valueOf(paramaukm.isExtinguish));
    paramContentValues.put("friendshipLevel", Integer.valueOf(paramaukm.friendshipLevel));
    paramContentValues.put("friendshipChatDays", Integer.valueOf(paramaukm.friendshipChatDays));
    paramContentValues.put("lastFriendshipTime", Long.valueOf(paramaukm.lastFriendshipTime));
    paramContentValues.put("chatHotLevel", Integer.valueOf(paramaukm.chatHotLevel));
    paramContentValues.put("chatDays", Integer.valueOf(paramaukm.chatDays));
    paramContentValues.put("lastChatTime", Long.valueOf(paramaukm.lastChatTime));
    paramContentValues.put("praiseHotLevel", Integer.valueOf(paramaukm.praiseHotLevel));
    paramContentValues.put("praiseDays", Integer.valueOf(paramaukm.praiseDays));
    paramContentValues.put("lastpraiseTime", Long.valueOf(paramaukm.lastpraiseTime));
    paramContentValues.put("loverChatLevel", Integer.valueOf(paramaukm.loverChatLevel));
    paramContentValues.put("loverChatDays", Integer.valueOf(paramaukm.loverChatDays));
    paramContentValues.put("loverLastChatTime", Long.valueOf(paramaukm.loverLastChatTime));
    paramContentValues.put("loverFlag", Integer.valueOf(paramaukm.loverFlag));
    paramContentValues.put("loverTransFlag", Boolean.valueOf(paramaukm.loverTransFlag));
    paramContentValues.put("qzoneVisitType", Integer.valueOf(paramaukm.qzoneVisitType));
    paramContentValues.put("qzoneHotDays", Integer.valueOf(paramaukm.qzoneHotDays));
    paramContentValues.put("lastQzoneVisitTime", Long.valueOf(paramaukm.lastQzoneVisitTime));
    paramContentValues.put("bestIntimacyType", Integer.valueOf(paramaukm.bestIntimacyType));
    paramContentValues.put("bestIntimacyDays", Integer.valueOf(paramaukm.bestIntimacyDays));
    paramContentValues.put("newBestIntimacyType", Integer.valueOf(paramaukm.newBestIntimacyType));
    paramContentValues.put("hasRemindChat", Boolean.valueOf(paramaukm.hasRemindChat));
    paramContentValues.put("hasRemindLoverChat", Boolean.valueOf(paramaukm.hasRemindLoverChat));
    paramContentValues.put("hasRemindPraise", Boolean.valueOf(paramaukm.hasRemindPraise));
    paramContentValues.put("hasRemindQzoneVisit", Boolean.valueOf(paramaukm.hasRemindQzoneVisit));
    paramContentValues.put("hasRemindFrdship", Boolean.valueOf(paramaukm.hasRemindFrdship));
    paramContentValues.put("hasRemindIntimate", Boolean.valueOf(paramaukm.hasRemindIntimate));
    paramContentValues.put("localChatSendTs", Long.valueOf(paramaukm.localChatSendTs));
    paramContentValues.put("localChatRecTs", Long.valueOf(paramaukm.localChatRecTs));
    paramContentValues.put("lastHotReactiveReCheckInTs", Long.valueOf(paramaukm.lastHotReactiveReCheckInTs));
    paramContentValues.put("isGrayTipRemind", Integer.valueOf(paramaukm.isGrayTipRemind));
    paramContentValues.put("isGrayTipMultiRemind", Integer.valueOf(paramaukm.isGrayTipMultiRemind));
    paramContentValues.put("mutual_marks_store_json", paramaukm.mutual_marks_store_json);
    paramContentValues.put("mutual_mark_version", Integer.valueOf(paramaukm.mutual_mark_version));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukr
 * JD-Core Version:    0.7.0.1
 */