import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awgj
  extends awgq
{
  public awgj()
  {
    this.a = 88;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawge = (ExtensionInfo)paramawge;
    if (paramawgp == null)
    {
      paramawge.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawge.pendantId = paramCursor.getLong(paramCursor.getColumnIndex("pendantId"));
      paramawge.pendantDiyId = paramCursor.getInt(paramCursor.getColumnIndex("pendantDiyId"));
      paramawge.uVipFont = paramCursor.getLong(paramCursor.getColumnIndex("uVipFont"));
      paramawge.vipFontType = paramCursor.getInt(paramCursor.getColumnIndex("vipFontType"));
      paramawge.magicFont = paramCursor.getInt(paramCursor.getColumnIndex("magicFont"));
      paramawge.lastUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("lastUpdateTime"));
      paramawge.fontEffect = paramCursor.getInt(paramCursor.getColumnIndex("fontEffect"));
      paramawge.fontEffectLastUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("fontEffectLastUpdateTime"));
      paramawge.faceId = paramCursor.getInt(paramCursor.getColumnIndex("faceId"));
      paramawge.faceIdUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("faceIdUpdateTime"));
      paramawge.colorRingId = paramCursor.getLong(paramCursor.getColumnIndex("colorRingId"));
      paramawge.commingRingId = paramCursor.getLong(paramCursor.getColumnIndex("commingRingId"));
      paramawge.timestamp = paramCursor.getLong(paramCursor.getColumnIndex("timestamp"));
      paramawge.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
      paramawge.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
      paramawge.feedType = paramCursor.getInt(paramCursor.getColumnIndex("feedType"));
      paramawge.feedTime = paramCursor.getLong(paramCursor.getColumnIndex("feedTime"));
      paramawge.feedContent = paramCursor.getString(paramCursor.getColumnIndex("feedContent"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("feedHasPhoto")))
      {
        paramBoolean = true;
        paramawge.feedHasPhoto = paramBoolean;
        paramawge.feedPhotoUrl = paramCursor.getString(paramCursor.getColumnIndex("feedPhotoUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isAdded2C2C"))) {
          break label1742;
        }
        paramBoolean = true;
        label421:
        paramawge.isAdded2C2C = paramBoolean;
        paramawge.chatInputType = paramCursor.getInt(paramCursor.getColumnIndex("chatInputType"));
        paramawge.showC2CPanel = paramCursor.getInt(paramCursor.getColumnIndex("showC2CPanel"));
        paramawge.pttChangeVoiceType = paramCursor.getInt(paramCursor.getColumnIndex("pttChangeVoiceType"));
        paramawge.audioPanelType = paramCursor.getInt(paramCursor.getColumnIndex("audioPanelType"));
        paramawge.openDoNotDisturbTime = paramCursor.getLong(paramCursor.getColumnIndex("openDoNotDisturbTime"));
        paramawge.latestPLUpdateTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("latestPLUpdateTimestamp"));
        paramawge.lastPullPLNewsTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastPullPLNewsTimestamp"));
        paramawge.lastPLNewsTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastPLNewsTimestamp"));
        paramawge.medalUpdateTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("medalUpdateTimestamp"));
        paramawge.lastMedalTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastMedalTimestamp"));
        paramawge.diyFontTimestampBytes = paramCursor.getBlob(paramCursor.getColumnIndex("diyFontTimestampBytes"));
        paramawge.diyFontConfigBytes = paramCursor.getBlob(paramCursor.getColumnIndex("diyFontConfigBytes"));
        paramawge.lastIceBreakCheckTs = paramCursor.getLong(paramCursor.getColumnIndex("lastIceBreakCheckTs"));
        paramawge.lastIceBreakChatTs = paramCursor.getLong(paramCursor.getColumnIndex("lastIceBreakChatTs"));
        paramawge.makeFrdsTs = paramCursor.getLong(paramCursor.getColumnIndex("makeFrdsTs"));
        paramawge.topPositionTime = paramCursor.getLong(paramCursor.getColumnIndex("topPositionTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isListenTogetherOpen"))) {
          break label1747;
        }
        paramBoolean = true;
        label734:
        paramawge.isListenTogetherOpen = paramBoolean;
        paramawge.isSharingLocation = paramCursor.getInt(paramCursor.getColumnIndex("isSharingLocation"));
        paramawge.lastShareLbsMsgUniseq = paramCursor.getLong(paramCursor.getColumnIndex("lastShareLbsMsgUniseq"));
        paramawge.mTogetherBusinessFlag = paramCursor.getLong(paramCursor.getColumnIndex("mTogetherBusinessFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnablePreview"))) {
          break label1752;
        }
        paramBoolean = true;
        label813:
        paramawge.messageEnablePreview = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnableSound"))) {
          break label1757;
        }
        paramBoolean = true;
        label838:
        paramawge.messageEnableSound = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnableVibrate"))) {
          break label1762;
        }
        paramBoolean = true;
        label863:
        paramawge.messageEnableVibrate = paramBoolean;
        paramawge.friendRingId = paramCursor.getInt(paramCursor.getColumnIndex("friendRingId"));
        paramawge.messageEnablePreviewNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnablePreviewNew"));
        paramawge.messageEnableSoundNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnableSoundNew"));
        paramawge.messageEnableVibrateNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnableVibrateNew"));
        paramawge.hiddenChatSwitch = paramCursor.getInt(paramCursor.getColumnIndex("hiddenChatSwitch"));
        paramawge.intimate_type = paramCursor.getInt(paramCursor.getColumnIndex("intimate_type"));
        paramawge.intimate_level = paramCursor.getInt(paramCursor.getColumnIndex("intimate_level"));
        paramawge.intimate_chatDays = paramCursor.getInt(paramCursor.getColumnIndex("intimate_chatDays"));
        paramawge.last_intimate_chatTime = paramCursor.getLong(paramCursor.getColumnIndex("last_intimate_chatTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isExtinguish"))) {
          break label1767;
        }
        paramBoolean = true;
        label1053:
        paramawge.isExtinguish = paramBoolean;
        paramawge.friendshipLevel = paramCursor.getInt(paramCursor.getColumnIndex("friendshipLevel"));
        paramawge.friendshipChatDays = paramCursor.getInt(paramCursor.getColumnIndex("friendshipChatDays"));
        paramawge.lastFriendshipTime = paramCursor.getLong(paramCursor.getColumnIndex("lastFriendshipTime"));
        paramawge.chatHotLevel = paramCursor.getInt(paramCursor.getColumnIndex("chatHotLevel"));
        paramawge.chatDays = paramCursor.getInt(paramCursor.getColumnIndex("chatDays"));
        paramawge.lastChatTime = paramCursor.getLong(paramCursor.getColumnIndex("lastChatTime"));
        paramawge.praiseHotLevel = paramCursor.getInt(paramCursor.getColumnIndex("praiseHotLevel"));
        paramawge.praiseDays = paramCursor.getInt(paramCursor.getColumnIndex("praiseDays"));
        paramawge.lastpraiseTime = paramCursor.getLong(paramCursor.getColumnIndex("lastpraiseTime"));
        paramawge.loverChatLevel = paramCursor.getInt(paramCursor.getColumnIndex("loverChatLevel"));
        paramawge.loverChatDays = paramCursor.getInt(paramCursor.getColumnIndex("loverChatDays"));
        paramawge.loverLastChatTime = paramCursor.getLong(paramCursor.getColumnIndex("loverLastChatTime"));
        paramawge.loverFlag = paramCursor.getInt(paramCursor.getColumnIndex("loverFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("loverTransFlag"))) {
          break label1772;
        }
        paramBoolean = true;
        label1326:
        paramawge.loverTransFlag = paramBoolean;
        paramawge.qzoneVisitType = paramCursor.getInt(paramCursor.getColumnIndex("qzoneVisitType"));
        paramawge.qzoneHotDays = paramCursor.getInt(paramCursor.getColumnIndex("qzoneHotDays"));
        paramawge.lastQzoneVisitTime = paramCursor.getLong(paramCursor.getColumnIndex("lastQzoneVisitTime"));
        paramawge.bestIntimacyType = paramCursor.getInt(paramCursor.getColumnIndex("bestIntimacyType"));
        paramawge.bestIntimacyDays = paramCursor.getInt(paramCursor.getColumnIndex("bestIntimacyDays"));
        paramawge.newBestIntimacyType = paramCursor.getInt(paramCursor.getColumnIndex("newBestIntimacyType"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindChat"))) {
          break label1777;
        }
        paramBoolean = true;
        label1466:
        paramawge.hasRemindChat = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindLoverChat"))) {
          break label1782;
        }
        paramBoolean = true;
        label1492:
        paramawge.hasRemindLoverChat = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindPraise"))) {
          break label1787;
        }
        paramBoolean = true;
        label1518:
        paramawge.hasRemindPraise = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindQzoneVisit"))) {
          break label1792;
        }
        paramBoolean = true;
        label1544:
        paramawge.hasRemindQzoneVisit = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindFrdship"))) {
          break label1797;
        }
        paramBoolean = true;
        label1570:
        paramawge.hasRemindFrdship = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindIntimate"))) {
          break label1802;
        }
      }
      label1792:
      label1797:
      label1802:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramawge.hasRemindIntimate = paramBoolean;
        paramawge.localChatSendTs = paramCursor.getLong(paramCursor.getColumnIndex("localChatSendTs"));
        paramawge.localChatRecTs = paramCursor.getLong(paramCursor.getColumnIndex("localChatRecTs"));
        paramawge.lastHotReactiveReCheckInTs = paramCursor.getLong(paramCursor.getColumnIndex("lastHotReactiveReCheckInTs"));
        paramawge.isGrayTipRemind = paramCursor.getInt(paramCursor.getColumnIndex("isGrayTipRemind"));
        paramawge.isGrayTipMultiRemind = paramCursor.getInt(paramCursor.getColumnIndex("isGrayTipMultiRemind"));
        paramawge.mutual_marks_store_json = paramCursor.getString(paramCursor.getColumnIndex("mutual_marks_store_json"));
        paramawge.mutual_mark_version = paramCursor.getInt(paramCursor.getColumnIndex("mutual_mark_version"));
        return paramawge;
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
      paramawgp.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("pendantId");
      if (i != -1) {
        break label4976;
      }
      paramawgp.a(new NoColumnError("pendantId", Long.TYPE));
      label1877:
      i = paramCursor.getColumnIndex("pendantDiyId");
      if (i != -1) {
        break label4991;
      }
      paramawgp.a(new NoColumnError("pendantDiyId", Integer.TYPE));
      label1912:
      i = paramCursor.getColumnIndex("uVipFont");
      if (i != -1) {
        break label5006;
      }
      paramawgp.a(new NoColumnError("uVipFont", Long.TYPE));
      label1947:
      i = paramCursor.getColumnIndex("vipFontType");
      if (i != -1) {
        break label5021;
      }
      paramawgp.a(new NoColumnError("vipFontType", Integer.TYPE));
      label1982:
      i = paramCursor.getColumnIndex("magicFont");
      if (i != -1) {
        break label5036;
      }
      paramawgp.a(new NoColumnError("magicFont", Integer.TYPE));
      label2017:
      i = paramCursor.getColumnIndex("lastUpdateTime");
      if (i != -1) {
        break label5051;
      }
      paramawgp.a(new NoColumnError("lastUpdateTime", Long.TYPE));
      label2052:
      i = paramCursor.getColumnIndex("fontEffect");
      if (i != -1) {
        break label5066;
      }
      paramawgp.a(new NoColumnError("fontEffect", Integer.TYPE));
      label2087:
      i = paramCursor.getColumnIndex("fontEffectLastUpdateTime");
      if (i != -1) {
        break label5081;
      }
      paramawgp.a(new NoColumnError("fontEffectLastUpdateTime", Long.TYPE));
      label2122:
      i = paramCursor.getColumnIndex("faceId");
      if (i != -1) {
        break label5096;
      }
      paramawgp.a(new NoColumnError("faceId", Integer.TYPE));
      label2157:
      i = paramCursor.getColumnIndex("faceIdUpdateTime");
      if (i != -1) {
        break label5111;
      }
      paramawgp.a(new NoColumnError("faceIdUpdateTime", Long.TYPE));
      label2192:
      i = paramCursor.getColumnIndex("colorRingId");
      if (i != -1) {
        break label5126;
      }
      paramawgp.a(new NoColumnError("colorRingId", Long.TYPE));
      label2227:
      i = paramCursor.getColumnIndex("commingRingId");
      if (i != -1) {
        break label5141;
      }
      paramawgp.a(new NoColumnError("commingRingId", Long.TYPE));
      label2262:
      i = paramCursor.getColumnIndex("timestamp");
      if (i != -1) {
        break label5156;
      }
      paramawgp.a(new NoColumnError("timestamp", Long.TYPE));
      label2297:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label5171;
      }
      paramawgp.a(new NoColumnError("richTime", Long.TYPE));
      label2332:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label5186;
      }
      paramawgp.a(new NoColumnError("richBuffer", [B.class));
      label2367:
      i = paramCursor.getColumnIndex("feedType");
      if (i != -1) {
        break label5201;
      }
      paramawgp.a(new NoColumnError("feedType", Integer.TYPE));
      label2402:
      i = paramCursor.getColumnIndex("feedTime");
      if (i != -1) {
        break label5216;
      }
      paramawgp.a(new NoColumnError("feedTime", Long.TYPE));
      label2437:
      i = paramCursor.getColumnIndex("feedContent");
      if (i != -1) {
        break label5231;
      }
      paramawgp.a(new NoColumnError("feedContent", String.class));
      label2472:
      i = paramCursor.getColumnIndex("feedHasPhoto");
      if (i != -1) {
        break label5246;
      }
      paramawgp.a(new NoColumnError("feedHasPhoto", Boolean.TYPE));
      i = paramCursor.getColumnIndex("feedPhotoUrl");
      if (i != -1) {
        break label5273;
      }
      paramawgp.a(new NoColumnError("feedPhotoUrl", String.class));
      label2542:
      i = paramCursor.getColumnIndex("isAdded2C2C");
      if (i != -1) {
        break label5288;
      }
      paramawgp.a(new NoColumnError("isAdded2C2C", Boolean.TYPE));
      i = paramCursor.getColumnIndex("chatInputType");
      if (i != -1) {
        break label5315;
      }
      paramawgp.a(new NoColumnError("chatInputType", Integer.TYPE));
      label2612:
      i = paramCursor.getColumnIndex("showC2CPanel");
      if (i != -1) {
        break label5330;
      }
      paramawgp.a(new NoColumnError("showC2CPanel", Integer.TYPE));
      label2647:
      i = paramCursor.getColumnIndex("pttChangeVoiceType");
      if (i != -1) {
        break label5345;
      }
      paramawgp.a(new NoColumnError("pttChangeVoiceType", Integer.TYPE));
      label2682:
      i = paramCursor.getColumnIndex("audioPanelType");
      if (i != -1) {
        break label5360;
      }
      paramawgp.a(new NoColumnError("audioPanelType", Integer.TYPE));
      label2717:
      i = paramCursor.getColumnIndex("openDoNotDisturbTime");
      if (i != -1) {
        break label5375;
      }
      paramawgp.a(new NoColumnError("openDoNotDisturbTime", Long.TYPE));
      label2752:
      i = paramCursor.getColumnIndex("latestPLUpdateTimestamp");
      if (i != -1) {
        break label5390;
      }
      paramawgp.a(new NoColumnError("latestPLUpdateTimestamp", Long.TYPE));
      label2787:
      i = paramCursor.getColumnIndex("lastPullPLNewsTimestamp");
      if (i != -1) {
        break label5405;
      }
      paramawgp.a(new NoColumnError("lastPullPLNewsTimestamp", Long.TYPE));
      label2822:
      i = paramCursor.getColumnIndex("lastPLNewsTimestamp");
      if (i != -1) {
        break label5420;
      }
      paramawgp.a(new NoColumnError("lastPLNewsTimestamp", Long.TYPE));
      label2857:
      i = paramCursor.getColumnIndex("medalUpdateTimestamp");
      if (i != -1) {
        break label5435;
      }
      paramawgp.a(new NoColumnError("medalUpdateTimestamp", Long.TYPE));
      label2892:
      i = paramCursor.getColumnIndex("lastMedalTimestamp");
      if (i != -1) {
        break label5450;
      }
      paramawgp.a(new NoColumnError("lastMedalTimestamp", Long.TYPE));
      label2927:
      i = paramCursor.getColumnIndex("diyFontTimestampBytes");
      if (i != -1) {
        break label5465;
      }
      paramawgp.a(new NoColumnError("diyFontTimestampBytes", [B.class));
      label2962:
      i = paramCursor.getColumnIndex("diyFontConfigBytes");
      if (i != -1) {
        break label5480;
      }
      paramawgp.a(new NoColumnError("diyFontConfigBytes", [B.class));
      label2997:
      i = paramCursor.getColumnIndex("lastIceBreakCheckTs");
      if (i != -1) {
        break label5495;
      }
      paramawgp.a(new NoColumnError("lastIceBreakCheckTs", Long.TYPE));
      label3032:
      i = paramCursor.getColumnIndex("lastIceBreakChatTs");
      if (i != -1) {
        break label5510;
      }
      paramawgp.a(new NoColumnError("lastIceBreakChatTs", Long.TYPE));
      label3067:
      i = paramCursor.getColumnIndex("makeFrdsTs");
      if (i != -1) {
        break label5525;
      }
      paramawgp.a(new NoColumnError("makeFrdsTs", Long.TYPE));
      label3102:
      i = paramCursor.getColumnIndex("topPositionTime");
      if (i != -1) {
        break label5540;
      }
      paramawgp.a(new NoColumnError("topPositionTime", Long.TYPE));
      label3137:
      i = paramCursor.getColumnIndex("isListenTogetherOpen");
      if (i != -1) {
        break label5555;
      }
      paramawgp.a(new NoColumnError("isListenTogetherOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isSharingLocation");
      if (i != -1) {
        break label5582;
      }
      paramawgp.a(new NoColumnError("isSharingLocation", Integer.TYPE));
      label3207:
      i = paramCursor.getColumnIndex("lastShareLbsMsgUniseq");
      if (i != -1) {
        break label5597;
      }
      paramawgp.a(new NoColumnError("lastShareLbsMsgUniseq", Long.TYPE));
      label3242:
      i = paramCursor.getColumnIndex("mTogetherBusinessFlag");
      if (i != -1) {
        break label5612;
      }
      paramawgp.a(new NoColumnError("mTogetherBusinessFlag", Long.TYPE));
      label3277:
      i = paramCursor.getColumnIndex("messageEnablePreview");
      if (i != -1) {
        break label5627;
      }
      paramawgp.a(new NoColumnError("messageEnablePreview", Boolean.TYPE));
      i = paramCursor.getColumnIndex("messageEnableSound");
      if (i != -1) {
        break label5654;
      }
      paramawgp.a(new NoColumnError("messageEnableSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("messageEnableVibrate");
      if (i != -1) {
        break label5681;
      }
      paramawgp.a(new NoColumnError("messageEnableVibrate", Boolean.TYPE));
      i = paramCursor.getColumnIndex("friendRingId");
      if (i != -1) {
        break label5708;
      }
      paramawgp.a(new NoColumnError("friendRingId", Integer.TYPE));
      label3417:
      i = paramCursor.getColumnIndex("messageEnablePreviewNew");
      if (i != -1) {
        break label5723;
      }
      paramawgp.a(new NoColumnError("messageEnablePreviewNew", Integer.TYPE));
      label3452:
      i = paramCursor.getColumnIndex("messageEnableSoundNew");
      if (i != -1) {
        break label5738;
      }
      paramawgp.a(new NoColumnError("messageEnableSoundNew", Integer.TYPE));
      label3487:
      i = paramCursor.getColumnIndex("messageEnableVibrateNew");
      if (i != -1) {
        break label5753;
      }
      paramawgp.a(new NoColumnError("messageEnableVibrateNew", Integer.TYPE));
      label3522:
      i = paramCursor.getColumnIndex("hiddenChatSwitch");
      if (i != -1) {
        break label5768;
      }
      paramawgp.a(new NoColumnError("hiddenChatSwitch", Integer.TYPE));
      label3557:
      i = paramCursor.getColumnIndex("intimate_type");
      if (i != -1) {
        break label5783;
      }
      paramawgp.a(new NoColumnError("intimate_type", Integer.TYPE));
      label3592:
      i = paramCursor.getColumnIndex("intimate_level");
      if (i != -1) {
        break label5798;
      }
      paramawgp.a(new NoColumnError("intimate_level", Integer.TYPE));
      label3627:
      i = paramCursor.getColumnIndex("intimate_chatDays");
      if (i != -1) {
        break label5813;
      }
      paramawgp.a(new NoColumnError("intimate_chatDays", Integer.TYPE));
      label3664:
      i = paramCursor.getColumnIndex("last_intimate_chatTime");
      if (i != -1) {
        break label5828;
      }
      paramawgp.a(new NoColumnError("last_intimate_chatTime", Long.TYPE));
      label3701:
      i = paramCursor.getColumnIndex("isExtinguish");
      if (i != -1) {
        break label5843;
      }
      paramawgp.a(new NoColumnError("isExtinguish", Boolean.TYPE));
      i = paramCursor.getColumnIndex("friendshipLevel");
      if (i != -1) {
        break label5870;
      }
      paramawgp.a(new NoColumnError("friendshipLevel", Integer.TYPE));
      label3775:
      i = paramCursor.getColumnIndex("friendshipChatDays");
      if (i != -1) {
        break label5885;
      }
      paramawgp.a(new NoColumnError("friendshipChatDays", Integer.TYPE));
      label3812:
      i = paramCursor.getColumnIndex("lastFriendshipTime");
      if (i != -1) {
        break label5900;
      }
      paramawgp.a(new NoColumnError("lastFriendshipTime", Long.TYPE));
      label3849:
      i = paramCursor.getColumnIndex("chatHotLevel");
      if (i != -1) {
        break label5915;
      }
      paramawgp.a(new NoColumnError("chatHotLevel", Integer.TYPE));
      label3886:
      i = paramCursor.getColumnIndex("chatDays");
      if (i != -1) {
        break label5930;
      }
      paramawgp.a(new NoColumnError("chatDays", Integer.TYPE));
      label3923:
      i = paramCursor.getColumnIndex("lastChatTime");
      if (i != -1) {
        break label5945;
      }
      paramawgp.a(new NoColumnError("lastChatTime", Long.TYPE));
      label3960:
      i = paramCursor.getColumnIndex("praiseHotLevel");
      if (i != -1) {
        break label5960;
      }
      paramawgp.a(new NoColumnError("praiseHotLevel", Integer.TYPE));
      label3997:
      i = paramCursor.getColumnIndex("praiseDays");
      if (i != -1) {
        break label5975;
      }
      paramawgp.a(new NoColumnError("praiseDays", Integer.TYPE));
      label4034:
      i = paramCursor.getColumnIndex("lastpraiseTime");
      if (i != -1) {
        break label5990;
      }
      paramawgp.a(new NoColumnError("lastpraiseTime", Long.TYPE));
      label4071:
      i = paramCursor.getColumnIndex("loverChatLevel");
      if (i != -1) {
        break label6005;
      }
      paramawgp.a(new NoColumnError("loverChatLevel", Integer.TYPE));
      label4108:
      i = paramCursor.getColumnIndex("loverChatDays");
      if (i != -1) {
        break label6020;
      }
      paramawgp.a(new NoColumnError("loverChatDays", Integer.TYPE));
      label4145:
      i = paramCursor.getColumnIndex("loverLastChatTime");
      if (i != -1) {
        break label6035;
      }
      paramawgp.a(new NoColumnError("loverLastChatTime", Long.TYPE));
      label4182:
      i = paramCursor.getColumnIndex("loverFlag");
      if (i != -1) {
        break label6050;
      }
      paramawgp.a(new NoColumnError("loverFlag", Integer.TYPE));
      label4219:
      i = paramCursor.getColumnIndex("loverTransFlag");
      if (i != -1) {
        break label6065;
      }
      paramawgp.a(new NoColumnError("loverTransFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("qzoneVisitType");
      if (i != -1) {
        break label6092;
      }
      paramawgp.a(new NoColumnError("qzoneVisitType", Integer.TYPE));
      label4293:
      i = paramCursor.getColumnIndex("qzoneHotDays");
      if (i != -1) {
        break label6107;
      }
      paramawgp.a(new NoColumnError("qzoneHotDays", Integer.TYPE));
      label4330:
      i = paramCursor.getColumnIndex("lastQzoneVisitTime");
      if (i != -1) {
        break label6122;
      }
      paramawgp.a(new NoColumnError("lastQzoneVisitTime", Long.TYPE));
      label4367:
      i = paramCursor.getColumnIndex("bestIntimacyType");
      if (i != -1) {
        break label6137;
      }
      paramawgp.a(new NoColumnError("bestIntimacyType", Integer.TYPE));
      label4404:
      i = paramCursor.getColumnIndex("bestIntimacyDays");
      if (i != -1) {
        break label6152;
      }
      paramawgp.a(new NoColumnError("bestIntimacyDays", Integer.TYPE));
      label4441:
      i = paramCursor.getColumnIndex("newBestIntimacyType");
      if (i != -1) {
        break label6167;
      }
      paramawgp.a(new NoColumnError("newBestIntimacyType", Integer.TYPE));
      label4478:
      i = paramCursor.getColumnIndex("hasRemindChat");
      if (i != -1) {
        break label6182;
      }
      paramawgp.a(new NoColumnError("hasRemindChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindLoverChat");
      if (i != -1) {
        break label6209;
      }
      paramawgp.a(new NoColumnError("hasRemindLoverChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindPraise");
      if (i != -1) {
        break label6236;
      }
      paramawgp.a(new NoColumnError("hasRemindPraise", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindQzoneVisit");
      if (i != -1) {
        break label6263;
      }
      paramawgp.a(new NoColumnError("hasRemindQzoneVisit", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindFrdship");
      if (i != -1) {
        break label6290;
      }
      paramawgp.a(new NoColumnError("hasRemindFrdship", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindIntimate");
      if (i != -1) {
        break label6317;
      }
      paramawgp.a(new NoColumnError("hasRemindIntimate", Boolean.TYPE));
      i = paramCursor.getColumnIndex("localChatSendTs");
      if (i != -1) {
        break label6345;
      }
      paramawgp.a(new NoColumnError("localChatSendTs", Long.TYPE));
      label4737:
      i = paramCursor.getColumnIndex("localChatRecTs");
      if (i != -1) {
        break label6360;
      }
      paramawgp.a(new NoColumnError("localChatRecTs", Long.TYPE));
      label4774:
      i = paramCursor.getColumnIndex("lastHotReactiveReCheckInTs");
      if (i != -1) {
        break label6375;
      }
      paramawgp.a(new NoColumnError("lastHotReactiveReCheckInTs", Long.TYPE));
      label4811:
      i = paramCursor.getColumnIndex("isGrayTipRemind");
      if (i != -1) {
        break label6390;
      }
      paramawgp.a(new NoColumnError("isGrayTipRemind", Integer.TYPE));
      label4848:
      i = paramCursor.getColumnIndex("isGrayTipMultiRemind");
      if (i != -1) {
        break label6405;
      }
      paramawgp.a(new NoColumnError("isGrayTipMultiRemind", Integer.TYPE));
      label4885:
      i = paramCursor.getColumnIndex("mutual_marks_store_json");
      if (i != -1) {
        break label6420;
      }
      paramawgp.a(new NoColumnError("mutual_marks_store_json", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("mutual_mark_version");
      if (i != -1) {
        break label6435;
      }
      paramawgp.a(new NoColumnError("mutual_mark_version", Integer.TYPE));
      return paramawge;
      paramawge.uin = paramCursor.getString(i);
      break;
      label4976:
      paramawge.pendantId = paramCursor.getLong(i);
      break label1877;
      label4991:
      paramawge.pendantDiyId = paramCursor.getInt(i);
      break label1912;
      label5006:
      paramawge.uVipFont = paramCursor.getLong(i);
      break label1947;
      label5021:
      paramawge.vipFontType = paramCursor.getInt(i);
      break label1982;
      label5036:
      paramawge.magicFont = paramCursor.getInt(i);
      break label2017;
      label5051:
      paramawge.lastUpdateTime = paramCursor.getLong(i);
      break label2052;
      label5066:
      paramawge.fontEffect = paramCursor.getInt(i);
      break label2087;
      label5081:
      paramawge.fontEffectLastUpdateTime = paramCursor.getLong(i);
      break label2122;
      label5096:
      paramawge.faceId = paramCursor.getInt(i);
      break label2157;
      label5111:
      paramawge.faceIdUpdateTime = paramCursor.getLong(i);
      break label2192;
      label5126:
      paramawge.colorRingId = paramCursor.getLong(i);
      break label2227;
      label5141:
      paramawge.commingRingId = paramCursor.getLong(i);
      break label2262;
      label5156:
      paramawge.timestamp = paramCursor.getLong(i);
      break label2297;
      label5171:
      paramawge.richTime = paramCursor.getLong(i);
      break label2332;
      label5186:
      paramawge.richBuffer = paramCursor.getBlob(i);
      break label2367;
      label5201:
      paramawge.feedType = paramCursor.getInt(i);
      break label2402;
      label5216:
      paramawge.feedTime = paramCursor.getLong(i);
      break label2437;
      label5231:
      paramawge.feedContent = paramCursor.getString(i);
      break label2472;
      label5246:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.feedHasPhoto = paramBoolean;
        break;
      }
      label5273:
      paramawge.feedPhotoUrl = paramCursor.getString(i);
      break label2542;
      label5288:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isAdded2C2C = paramBoolean;
        break;
      }
      label5315:
      paramawge.chatInputType = paramCursor.getInt(i);
      break label2612;
      label5330:
      paramawge.showC2CPanel = paramCursor.getInt(i);
      break label2647;
      label5345:
      paramawge.pttChangeVoiceType = paramCursor.getInt(i);
      break label2682;
      label5360:
      paramawge.audioPanelType = paramCursor.getInt(i);
      break label2717;
      label5375:
      paramawge.openDoNotDisturbTime = paramCursor.getLong(i);
      break label2752;
      label5390:
      paramawge.latestPLUpdateTimestamp = paramCursor.getLong(i);
      break label2787;
      label5405:
      paramawge.lastPullPLNewsTimestamp = paramCursor.getLong(i);
      break label2822;
      label5420:
      paramawge.lastPLNewsTimestamp = paramCursor.getLong(i);
      break label2857;
      label5435:
      paramawge.medalUpdateTimestamp = paramCursor.getLong(i);
      break label2892;
      label5450:
      paramawge.lastMedalTimestamp = paramCursor.getLong(i);
      break label2927;
      label5465:
      paramawge.diyFontTimestampBytes = paramCursor.getBlob(i);
      break label2962;
      label5480:
      paramawge.diyFontConfigBytes = paramCursor.getBlob(i);
      break label2997;
      label5495:
      paramawge.lastIceBreakCheckTs = paramCursor.getLong(i);
      break label3032;
      label5510:
      paramawge.lastIceBreakChatTs = paramCursor.getLong(i);
      break label3067;
      label5525:
      paramawge.makeFrdsTs = paramCursor.getLong(i);
      break label3102;
      label5540:
      paramawge.topPositionTime = paramCursor.getLong(i);
      break label3137;
      label5555:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isListenTogetherOpen = paramBoolean;
        break;
      }
      label5582:
      paramawge.isSharingLocation = paramCursor.getInt(i);
      break label3207;
      label5597:
      paramawge.lastShareLbsMsgUniseq = paramCursor.getLong(i);
      break label3242;
      label5612:
      paramawge.mTogetherBusinessFlag = paramCursor.getLong(i);
      break label3277;
      label5627:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.messageEnablePreview = paramBoolean;
        break;
      }
      label5654:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.messageEnableSound = paramBoolean;
        break;
      }
      label5681:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.messageEnableVibrate = paramBoolean;
        break;
      }
      label5708:
      paramawge.friendRingId = paramCursor.getInt(i);
      break label3417;
      label5723:
      paramawge.messageEnablePreviewNew = paramCursor.getInt(i);
      break label3452;
      label5738:
      paramawge.messageEnableSoundNew = paramCursor.getInt(i);
      break label3487;
      label5753:
      paramawge.messageEnableVibrateNew = paramCursor.getInt(i);
      break label3522;
      label5768:
      paramawge.hiddenChatSwitch = paramCursor.getInt(i);
      break label3557;
      label5783:
      paramawge.intimate_type = paramCursor.getInt(i);
      break label3592;
      label5798:
      paramawge.intimate_level = paramCursor.getInt(i);
      break label3627;
      label5813:
      paramawge.intimate_chatDays = paramCursor.getInt(i);
      break label3664;
      label5828:
      paramawge.last_intimate_chatTime = paramCursor.getLong(i);
      break label3701;
      label5843:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isExtinguish = paramBoolean;
        break;
      }
      label5870:
      paramawge.friendshipLevel = paramCursor.getInt(i);
      break label3775;
      label5885:
      paramawge.friendshipChatDays = paramCursor.getInt(i);
      break label3812;
      label5900:
      paramawge.lastFriendshipTime = paramCursor.getLong(i);
      break label3849;
      label5915:
      paramawge.chatHotLevel = paramCursor.getInt(i);
      break label3886;
      label5930:
      paramawge.chatDays = paramCursor.getInt(i);
      break label3923;
      label5945:
      paramawge.lastChatTime = paramCursor.getLong(i);
      break label3960;
      label5960:
      paramawge.praiseHotLevel = paramCursor.getInt(i);
      break label3997;
      label5975:
      paramawge.praiseDays = paramCursor.getInt(i);
      break label4034;
      label5990:
      paramawge.lastpraiseTime = paramCursor.getLong(i);
      break label4071;
      label6005:
      paramawge.loverChatLevel = paramCursor.getInt(i);
      break label4108;
      label6020:
      paramawge.loverChatDays = paramCursor.getInt(i);
      break label4145;
      label6035:
      paramawge.loverLastChatTime = paramCursor.getLong(i);
      break label4182;
      label6050:
      paramawge.loverFlag = paramCursor.getInt(i);
      break label4219;
      label6065:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.loverTransFlag = paramBoolean;
        break;
      }
      label6092:
      paramawge.qzoneVisitType = paramCursor.getInt(i);
      break label4293;
      label6107:
      paramawge.qzoneHotDays = paramCursor.getInt(i);
      break label4330;
      label6122:
      paramawge.lastQzoneVisitTime = paramCursor.getLong(i);
      break label4367;
      label6137:
      paramawge.bestIntimacyType = paramCursor.getInt(i);
      break label4404;
      label6152:
      paramawge.bestIntimacyDays = paramCursor.getInt(i);
      break label4441;
      label6167:
      paramawge.newBestIntimacyType = paramCursor.getInt(i);
      break label4478;
      label6182:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.hasRemindChat = paramBoolean;
        break;
      }
      label6209:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.hasRemindLoverChat = paramBoolean;
        break;
      }
      label6236:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.hasRemindPraise = paramBoolean;
        break;
      }
      label6263:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.hasRemindQzoneVisit = paramBoolean;
        break;
      }
      label6290:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.hasRemindFrdship = paramBoolean;
        break;
      }
      label6317:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramawge.hasRemindIntimate = paramBoolean;
        break;
      }
      label6345:
      paramawge.localChatSendTs = paramCursor.getLong(i);
      break label4737;
      label6360:
      paramawge.localChatRecTs = paramCursor.getLong(i);
      break label4774;
      label6375:
      paramawge.lastHotReactiveReCheckInTs = paramCursor.getLong(i);
      break label4811;
      label6390:
      paramawge.isGrayTipRemind = paramCursor.getInt(i);
      break label4848;
      label6405:
      paramawge.isGrayTipMultiRemind = paramCursor.getInt(i);
      break label4885;
      label6420:
      paramawge.mutual_marks_store_json = paramCursor.getString(i);
    }
    label6435:
    paramawge.mutual_mark_version = paramCursor.getInt(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,pendantId INTEGER ,pendantDiyId INTEGER ,uVipFont INTEGER ,vipFontType INTEGER ,magicFont INTEGER ,lastUpdateTime INTEGER ,fontEffect INTEGER ,fontEffectLastUpdateTime INTEGER ,faceId INTEGER ,faceIdUpdateTime INTEGER ,colorRingId INTEGER ,commingRingId INTEGER ,timestamp INTEGER ,richTime INTEGER ,richBuffer BLOB ,feedType INTEGER ,feedTime INTEGER ,feedContent TEXT ,feedHasPhoto INTEGER ,feedPhotoUrl TEXT ,isAdded2C2C INTEGER ,chatInputType INTEGER ,showC2CPanel INTEGER ,pttChangeVoiceType INTEGER ,audioPanelType INTEGER ,openDoNotDisturbTime INTEGER ,latestPLUpdateTimestamp INTEGER ,lastPullPLNewsTimestamp INTEGER ,lastPLNewsTimestamp INTEGER ,medalUpdateTimestamp INTEGER ,lastMedalTimestamp INTEGER ,diyFontTimestampBytes BLOB ,diyFontConfigBytes BLOB ,lastIceBreakCheckTs INTEGER ,lastIceBreakChatTs INTEGER ,makeFrdsTs INTEGER ,topPositionTime INTEGER ,isListenTogetherOpen INTEGER ,isSharingLocation INTEGER ,lastShareLbsMsgUniseq INTEGER ,mTogetherBusinessFlag INTEGER ,messageEnablePreview INTEGER ,messageEnableSound INTEGER ,messageEnableVibrate INTEGER ,friendRingId INTEGER ,messageEnablePreviewNew INTEGER ,messageEnableSoundNew INTEGER ,messageEnableVibrateNew INTEGER ,hiddenChatSwitch INTEGER ,intimate_type INTEGER ,intimate_level INTEGER ,intimate_chatDays INTEGER ,last_intimate_chatTime INTEGER ,isExtinguish INTEGER ,friendshipLevel INTEGER ,friendshipChatDays INTEGER ,lastFriendshipTime INTEGER ,chatHotLevel INTEGER ,chatDays INTEGER ,lastChatTime INTEGER ,praiseHotLevel INTEGER ,praiseDays INTEGER ,lastpraiseTime INTEGER ,loverChatLevel INTEGER ,loverChatDays INTEGER ,loverLastChatTime INTEGER ,loverFlag INTEGER ,loverTransFlag INTEGER ,qzoneVisitType INTEGER ,qzoneHotDays INTEGER ,lastQzoneVisitTime INTEGER ,bestIntimacyType INTEGER ,bestIntimacyDays INTEGER ,newBestIntimacyType INTEGER ,hasRemindChat INTEGER ,hasRemindLoverChat INTEGER ,hasRemindPraise INTEGER ,hasRemindQzoneVisit INTEGER ,hasRemindFrdship INTEGER ,hasRemindIntimate INTEGER ,localChatSendTs INTEGER ,localChatRecTs INTEGER ,lastHotReactiveReCheckInTs INTEGER ,isGrayTipRemind INTEGER ,isGrayTipMultiRemind INTEGER ,mutual_marks_store_json TEXT ,mutual_mark_version INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (ExtensionInfo)paramawge;
    paramContentValues.put("uin", paramawge.uin);
    paramContentValues.put("pendantId", Long.valueOf(paramawge.pendantId));
    paramContentValues.put("pendantDiyId", Integer.valueOf(paramawge.pendantDiyId));
    paramContentValues.put("uVipFont", Long.valueOf(paramawge.uVipFont));
    paramContentValues.put("vipFontType", Integer.valueOf(paramawge.vipFontType));
    paramContentValues.put("magicFont", Integer.valueOf(paramawge.magicFont));
    paramContentValues.put("lastUpdateTime", Long.valueOf(paramawge.lastUpdateTime));
    paramContentValues.put("fontEffect", Integer.valueOf(paramawge.fontEffect));
    paramContentValues.put("fontEffectLastUpdateTime", Long.valueOf(paramawge.fontEffectLastUpdateTime));
    paramContentValues.put("faceId", Integer.valueOf(paramawge.faceId));
    paramContentValues.put("faceIdUpdateTime", Long.valueOf(paramawge.faceIdUpdateTime));
    paramContentValues.put("colorRingId", Long.valueOf(paramawge.colorRingId));
    paramContentValues.put("commingRingId", Long.valueOf(paramawge.commingRingId));
    paramContentValues.put("timestamp", Long.valueOf(paramawge.timestamp));
    paramContentValues.put("richTime", Long.valueOf(paramawge.richTime));
    paramContentValues.put("richBuffer", paramawge.richBuffer);
    paramContentValues.put("feedType", Integer.valueOf(paramawge.feedType));
    paramContentValues.put("feedTime", Long.valueOf(paramawge.feedTime));
    paramContentValues.put("feedContent", paramawge.feedContent);
    paramContentValues.put("feedHasPhoto", Boolean.valueOf(paramawge.feedHasPhoto));
    paramContentValues.put("feedPhotoUrl", paramawge.feedPhotoUrl);
    paramContentValues.put("isAdded2C2C", Boolean.valueOf(paramawge.isAdded2C2C));
    paramContentValues.put("chatInputType", Integer.valueOf(paramawge.chatInputType));
    paramContentValues.put("showC2CPanel", Integer.valueOf(paramawge.showC2CPanel));
    paramContentValues.put("pttChangeVoiceType", Integer.valueOf(paramawge.pttChangeVoiceType));
    paramContentValues.put("audioPanelType", Integer.valueOf(paramawge.audioPanelType));
    paramContentValues.put("openDoNotDisturbTime", Long.valueOf(paramawge.openDoNotDisturbTime));
    paramContentValues.put("latestPLUpdateTimestamp", Long.valueOf(paramawge.latestPLUpdateTimestamp));
    paramContentValues.put("lastPullPLNewsTimestamp", Long.valueOf(paramawge.lastPullPLNewsTimestamp));
    paramContentValues.put("lastPLNewsTimestamp", Long.valueOf(paramawge.lastPLNewsTimestamp));
    paramContentValues.put("medalUpdateTimestamp", Long.valueOf(paramawge.medalUpdateTimestamp));
    paramContentValues.put("lastMedalTimestamp", Long.valueOf(paramawge.lastMedalTimestamp));
    paramContentValues.put("diyFontTimestampBytes", paramawge.diyFontTimestampBytes);
    paramContentValues.put("diyFontConfigBytes", paramawge.diyFontConfigBytes);
    paramContentValues.put("lastIceBreakCheckTs", Long.valueOf(paramawge.lastIceBreakCheckTs));
    paramContentValues.put("lastIceBreakChatTs", Long.valueOf(paramawge.lastIceBreakChatTs));
    paramContentValues.put("makeFrdsTs", Long.valueOf(paramawge.makeFrdsTs));
    paramContentValues.put("topPositionTime", Long.valueOf(paramawge.topPositionTime));
    paramContentValues.put("isListenTogetherOpen", Boolean.valueOf(paramawge.isListenTogetherOpen));
    paramContentValues.put("isSharingLocation", Integer.valueOf(paramawge.isSharingLocation));
    paramContentValues.put("lastShareLbsMsgUniseq", Long.valueOf(paramawge.lastShareLbsMsgUniseq));
    paramContentValues.put("mTogetherBusinessFlag", Long.valueOf(paramawge.mTogetherBusinessFlag));
    paramContentValues.put("messageEnablePreview", Boolean.valueOf(paramawge.messageEnablePreview));
    paramContentValues.put("messageEnableSound", Boolean.valueOf(paramawge.messageEnableSound));
    paramContentValues.put("messageEnableVibrate", Boolean.valueOf(paramawge.messageEnableVibrate));
    paramContentValues.put("friendRingId", Integer.valueOf(paramawge.friendRingId));
    paramContentValues.put("messageEnablePreviewNew", Integer.valueOf(paramawge.messageEnablePreviewNew));
    paramContentValues.put("messageEnableSoundNew", Integer.valueOf(paramawge.messageEnableSoundNew));
    paramContentValues.put("messageEnableVibrateNew", Integer.valueOf(paramawge.messageEnableVibrateNew));
    paramContentValues.put("hiddenChatSwitch", Integer.valueOf(paramawge.hiddenChatSwitch));
    paramContentValues.put("intimate_type", Integer.valueOf(paramawge.intimate_type));
    paramContentValues.put("intimate_level", Integer.valueOf(paramawge.intimate_level));
    paramContentValues.put("intimate_chatDays", Integer.valueOf(paramawge.intimate_chatDays));
    paramContentValues.put("last_intimate_chatTime", Long.valueOf(paramawge.last_intimate_chatTime));
    paramContentValues.put("isExtinguish", Boolean.valueOf(paramawge.isExtinguish));
    paramContentValues.put("friendshipLevel", Integer.valueOf(paramawge.friendshipLevel));
    paramContentValues.put("friendshipChatDays", Integer.valueOf(paramawge.friendshipChatDays));
    paramContentValues.put("lastFriendshipTime", Long.valueOf(paramawge.lastFriendshipTime));
    paramContentValues.put("chatHotLevel", Integer.valueOf(paramawge.chatHotLevel));
    paramContentValues.put("chatDays", Integer.valueOf(paramawge.chatDays));
    paramContentValues.put("lastChatTime", Long.valueOf(paramawge.lastChatTime));
    paramContentValues.put("praiseHotLevel", Integer.valueOf(paramawge.praiseHotLevel));
    paramContentValues.put("praiseDays", Integer.valueOf(paramawge.praiseDays));
    paramContentValues.put("lastpraiseTime", Long.valueOf(paramawge.lastpraiseTime));
    paramContentValues.put("loverChatLevel", Integer.valueOf(paramawge.loverChatLevel));
    paramContentValues.put("loverChatDays", Integer.valueOf(paramawge.loverChatDays));
    paramContentValues.put("loverLastChatTime", Long.valueOf(paramawge.loverLastChatTime));
    paramContentValues.put("loverFlag", Integer.valueOf(paramawge.loverFlag));
    paramContentValues.put("loverTransFlag", Boolean.valueOf(paramawge.loverTransFlag));
    paramContentValues.put("qzoneVisitType", Integer.valueOf(paramawge.qzoneVisitType));
    paramContentValues.put("qzoneHotDays", Integer.valueOf(paramawge.qzoneHotDays));
    paramContentValues.put("lastQzoneVisitTime", Long.valueOf(paramawge.lastQzoneVisitTime));
    paramContentValues.put("bestIntimacyType", Integer.valueOf(paramawge.bestIntimacyType));
    paramContentValues.put("bestIntimacyDays", Integer.valueOf(paramawge.bestIntimacyDays));
    paramContentValues.put("newBestIntimacyType", Integer.valueOf(paramawge.newBestIntimacyType));
    paramContentValues.put("hasRemindChat", Boolean.valueOf(paramawge.hasRemindChat));
    paramContentValues.put("hasRemindLoverChat", Boolean.valueOf(paramawge.hasRemindLoverChat));
    paramContentValues.put("hasRemindPraise", Boolean.valueOf(paramawge.hasRemindPraise));
    paramContentValues.put("hasRemindQzoneVisit", Boolean.valueOf(paramawge.hasRemindQzoneVisit));
    paramContentValues.put("hasRemindFrdship", Boolean.valueOf(paramawge.hasRemindFrdship));
    paramContentValues.put("hasRemindIntimate", Boolean.valueOf(paramawge.hasRemindIntimate));
    paramContentValues.put("localChatSendTs", Long.valueOf(paramawge.localChatSendTs));
    paramContentValues.put("localChatRecTs", Long.valueOf(paramawge.localChatRecTs));
    paramContentValues.put("lastHotReactiveReCheckInTs", Long.valueOf(paramawge.lastHotReactiveReCheckInTs));
    paramContentValues.put("isGrayTipRemind", Integer.valueOf(paramawge.isGrayTipRemind));
    paramContentValues.put("isGrayTipMultiRemind", Integer.valueOf(paramawge.isGrayTipMultiRemind));
    paramContentValues.put("mutual_marks_store_json", paramawge.mutual_marks_store_json);
    paramContentValues.put("mutual_mark_version", Integer.valueOf(paramawge.mutual_mark_version));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awgj
 * JD-Core Version:    0.7.0.1
 */