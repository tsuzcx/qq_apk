import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class aybc
  extends OGAbstractDao
{
  public aybc()
  {
    this.columnLen = 87;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (ExtensionInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.pendantId = paramCursor.getLong(paramCursor.getColumnIndex("pendantId"));
      paramEntity.pendantDiyId = paramCursor.getInt(paramCursor.getColumnIndex("pendantDiyId"));
      paramEntity.uVipFont = paramCursor.getLong(paramCursor.getColumnIndex("uVipFont"));
      paramEntity.vipFontType = paramCursor.getInt(paramCursor.getColumnIndex("vipFontType"));
      paramEntity.magicFont = paramCursor.getInt(paramCursor.getColumnIndex("magicFont"));
      paramEntity.lastUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("lastUpdateTime"));
      paramEntity.fontEffect = paramCursor.getInt(paramCursor.getColumnIndex("fontEffect"));
      paramEntity.fontEffectLastUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("fontEffectLastUpdateTime"));
      paramEntity.faceId = paramCursor.getInt(paramCursor.getColumnIndex("faceId"));
      paramEntity.faceIdUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("faceIdUpdateTime"));
      paramEntity.colorRingId = paramCursor.getLong(paramCursor.getColumnIndex("colorRingId"));
      paramEntity.commingRingId = paramCursor.getLong(paramCursor.getColumnIndex("commingRingId"));
      paramEntity.timestamp = paramCursor.getLong(paramCursor.getColumnIndex("timestamp"));
      paramEntity.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
      paramEntity.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
      paramEntity.feedType = paramCursor.getInt(paramCursor.getColumnIndex("feedType"));
      paramEntity.feedTime = paramCursor.getLong(paramCursor.getColumnIndex("feedTime"));
      paramEntity.feedContent = paramCursor.getString(paramCursor.getColumnIndex("feedContent"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("feedHasPhoto")))
      {
        paramBoolean = true;
        paramEntity.feedHasPhoto = paramBoolean;
        paramEntity.feedPhotoUrl = paramCursor.getString(paramCursor.getColumnIndex("feedPhotoUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isAdded2C2C"))) {
          break label1730;
        }
        paramBoolean = true;
        label421:
        paramEntity.isAdded2C2C = paramBoolean;
        paramEntity.chatInputType = paramCursor.getInt(paramCursor.getColumnIndex("chatInputType"));
        paramEntity.showC2CPanel = paramCursor.getInt(paramCursor.getColumnIndex("showC2CPanel"));
        paramEntity.pttChangeVoiceType = paramCursor.getInt(paramCursor.getColumnIndex("pttChangeVoiceType"));
        paramEntity.audioPanelType = paramCursor.getInt(paramCursor.getColumnIndex("audioPanelType"));
        paramEntity.openDoNotDisturbTime = paramCursor.getLong(paramCursor.getColumnIndex("openDoNotDisturbTime"));
        paramEntity.latestPLUpdateTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("latestPLUpdateTimestamp"));
        paramEntity.lastPullPLNewsTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastPullPLNewsTimestamp"));
        paramEntity.lastPLNewsTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastPLNewsTimestamp"));
        paramEntity.diyFontTimestampBytes = paramCursor.getBlob(paramCursor.getColumnIndex("diyFontTimestampBytes"));
        paramEntity.diyFontConfigBytes = paramCursor.getBlob(paramCursor.getColumnIndex("diyFontConfigBytes"));
        paramEntity.lastIceBreakCheckTs = paramCursor.getLong(paramCursor.getColumnIndex("lastIceBreakCheckTs"));
        paramEntity.lastIceBreakChatTs = paramCursor.getLong(paramCursor.getColumnIndex("lastIceBreakChatTs"));
        paramEntity.makeFrdsTs = paramCursor.getLong(paramCursor.getColumnIndex("makeFrdsTs"));
        paramEntity.topPositionTime = paramCursor.getLong(paramCursor.getColumnIndex("topPositionTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isListenTogetherOpen"))) {
          break label1735;
        }
        paramBoolean = true;
        label698:
        paramEntity.isListenTogetherOpen = paramBoolean;
        paramEntity.isSharingLocation = paramCursor.getInt(paramCursor.getColumnIndex("isSharingLocation"));
        paramEntity.lastShareLbsMsgUniseq = paramCursor.getLong(paramCursor.getColumnIndex("lastShareLbsMsgUniseq"));
        paramEntity.mTogetherBusinessFlag = paramCursor.getLong(paramCursor.getColumnIndex("mTogetherBusinessFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnablePreview"))) {
          break label1740;
        }
        paramBoolean = true;
        label777:
        paramEntity.messageEnablePreview = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnableSound"))) {
          break label1745;
        }
        paramBoolean = true;
        label802:
        paramEntity.messageEnableSound = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnableVibrate"))) {
          break label1750;
        }
        paramBoolean = true;
        label827:
        paramEntity.messageEnableVibrate = paramBoolean;
        paramEntity.friendRingId = paramCursor.getInt(paramCursor.getColumnIndex("friendRingId"));
        paramEntity.messageEnablePreviewNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnablePreviewNew"));
        paramEntity.messageEnableSoundNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnableSoundNew"));
        paramEntity.messageEnableVibrateNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnableVibrateNew"));
        paramEntity.hiddenChatSwitch = paramCursor.getInt(paramCursor.getColumnIndex("hiddenChatSwitch"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isAioShortcutBarOpen"))) {
          break label1755;
        }
        paramBoolean = true;
        label942:
        paramEntity.isAioShortcutBarOpen = paramBoolean;
        paramEntity.intimate_type = paramCursor.getInt(paramCursor.getColumnIndex("intimate_type"));
        paramEntity.intimate_level = paramCursor.getInt(paramCursor.getColumnIndex("intimate_level"));
        paramEntity.intimate_chatDays = paramCursor.getInt(paramCursor.getColumnIndex("intimate_chatDays"));
        paramEntity.last_intimate_chatTime = paramCursor.getLong(paramCursor.getColumnIndex("last_intimate_chatTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isExtinguish"))) {
          break label1760;
        }
        paramBoolean = true;
        label1041:
        paramEntity.isExtinguish = paramBoolean;
        paramEntity.friendshipLevel = paramCursor.getInt(paramCursor.getColumnIndex("friendshipLevel"));
        paramEntity.friendshipChatDays = paramCursor.getInt(paramCursor.getColumnIndex("friendshipChatDays"));
        paramEntity.lastFriendshipTime = paramCursor.getLong(paramCursor.getColumnIndex("lastFriendshipTime"));
        paramEntity.chatHotLevel = paramCursor.getInt(paramCursor.getColumnIndex("chatHotLevel"));
        paramEntity.chatDays = paramCursor.getInt(paramCursor.getColumnIndex("chatDays"));
        paramEntity.lastChatTime = paramCursor.getLong(paramCursor.getColumnIndex("lastChatTime"));
        paramEntity.praiseHotLevel = paramCursor.getInt(paramCursor.getColumnIndex("praiseHotLevel"));
        paramEntity.praiseDays = paramCursor.getInt(paramCursor.getColumnIndex("praiseDays"));
        paramEntity.lastpraiseTime = paramCursor.getLong(paramCursor.getColumnIndex("lastpraiseTime"));
        paramEntity.loverChatLevel = paramCursor.getInt(paramCursor.getColumnIndex("loverChatLevel"));
        paramEntity.loverChatDays = paramCursor.getInt(paramCursor.getColumnIndex("loverChatDays"));
        paramEntity.loverLastChatTime = paramCursor.getLong(paramCursor.getColumnIndex("loverLastChatTime"));
        paramEntity.loverFlag = paramCursor.getInt(paramCursor.getColumnIndex("loverFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("loverTransFlag"))) {
          break label1765;
        }
        paramBoolean = true;
        label1314:
        paramEntity.loverTransFlag = paramBoolean;
        paramEntity.qzoneVisitType = paramCursor.getInt(paramCursor.getColumnIndex("qzoneVisitType"));
        paramEntity.qzoneHotDays = paramCursor.getInt(paramCursor.getColumnIndex("qzoneHotDays"));
        paramEntity.lastQzoneVisitTime = paramCursor.getLong(paramCursor.getColumnIndex("lastQzoneVisitTime"));
        paramEntity.bestIntimacyType = paramCursor.getInt(paramCursor.getColumnIndex("bestIntimacyType"));
        paramEntity.bestIntimacyDays = paramCursor.getInt(paramCursor.getColumnIndex("bestIntimacyDays"));
        paramEntity.newBestIntimacyType = paramCursor.getInt(paramCursor.getColumnIndex("newBestIntimacyType"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindChat"))) {
          break label1770;
        }
        paramBoolean = true;
        label1454:
        paramEntity.hasRemindChat = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindLoverChat"))) {
          break label1775;
        }
        paramBoolean = true;
        label1480:
        paramEntity.hasRemindLoverChat = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindPraise"))) {
          break label1780;
        }
        paramBoolean = true;
        label1506:
        paramEntity.hasRemindPraise = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindQzoneVisit"))) {
          break label1785;
        }
        paramBoolean = true;
        label1532:
        paramEntity.hasRemindQzoneVisit = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindFrdship"))) {
          break label1790;
        }
        paramBoolean = true;
        label1558:
        paramEntity.hasRemindFrdship = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindIntimate"))) {
          break label1795;
        }
      }
      label1795:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.hasRemindIntimate = paramBoolean;
        paramEntity.localChatSendTs = paramCursor.getLong(paramCursor.getColumnIndex("localChatSendTs"));
        paramEntity.localChatRecTs = paramCursor.getLong(paramCursor.getColumnIndex("localChatRecTs"));
        paramEntity.lastHotReactiveReCheckInTs = paramCursor.getLong(paramCursor.getColumnIndex("lastHotReactiveReCheckInTs"));
        paramEntity.isGrayTipRemind = paramCursor.getInt(paramCursor.getColumnIndex("isGrayTipRemind"));
        paramEntity.isGrayTipMultiRemind = paramCursor.getInt(paramCursor.getColumnIndex("isGrayTipMultiRemind"));
        paramEntity.mutual_marks_store_json = paramCursor.getString(paramCursor.getColumnIndex("mutual_marks_store_json"));
        paramEntity.mutual_mark_version = paramCursor.getInt(paramCursor.getColumnIndex("mutual_mark_version"));
        return paramEntity;
        paramBoolean = false;
        break;
        label1730:
        paramBoolean = false;
        break label421;
        label1735:
        paramBoolean = false;
        break label698;
        label1740:
        paramBoolean = false;
        break label777;
        label1745:
        paramBoolean = false;
        break label802;
        label1750:
        paramBoolean = false;
        break label827;
        label1755:
        paramBoolean = false;
        break label942;
        label1760:
        paramBoolean = false;
        break label1041;
        label1765:
        paramBoolean = false;
        break label1314;
        label1770:
        paramBoolean = false;
        break label1454;
        label1775:
        paramBoolean = false;
        break label1480;
        label1780:
        paramBoolean = false;
        break label1506;
        label1785:
        paramBoolean = false;
        break label1532;
        label1790:
        paramBoolean = false;
        break label1558;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("pendantId");
      if (i != -1) {
        break label4932;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pendantId", Long.TYPE));
      label1870:
      i = paramCursor.getColumnIndex("pendantDiyId");
      if (i != -1) {
        break label4947;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pendantDiyId", Integer.TYPE));
      label1905:
      i = paramCursor.getColumnIndex("uVipFont");
      if (i != -1) {
        break label4962;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uVipFont", Long.TYPE));
      label1940:
      i = paramCursor.getColumnIndex("vipFontType");
      if (i != -1) {
        break label4977;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vipFontType", Integer.TYPE));
      label1975:
      i = paramCursor.getColumnIndex("magicFont");
      if (i != -1) {
        break label4992;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("magicFont", Integer.TYPE));
      label2010:
      i = paramCursor.getColumnIndex("lastUpdateTime");
      if (i != -1) {
        break label5007;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastUpdateTime", Long.TYPE));
      label2045:
      i = paramCursor.getColumnIndex("fontEffect");
      if (i != -1) {
        break label5022;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("fontEffect", Integer.TYPE));
      label2080:
      i = paramCursor.getColumnIndex("fontEffectLastUpdateTime");
      if (i != -1) {
        break label5037;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("fontEffectLastUpdateTime", Long.TYPE));
      label2115:
      i = paramCursor.getColumnIndex("faceId");
      if (i != -1) {
        break label5052;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceId", Integer.TYPE));
      label2150:
      i = paramCursor.getColumnIndex("faceIdUpdateTime");
      if (i != -1) {
        break label5067;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceIdUpdateTime", Long.TYPE));
      label2185:
      i = paramCursor.getColumnIndex("colorRingId");
      if (i != -1) {
        break label5082;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("colorRingId", Long.TYPE));
      label2220:
      i = paramCursor.getColumnIndex("commingRingId");
      if (i != -1) {
        break label5097;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("commingRingId", Long.TYPE));
      label2255:
      i = paramCursor.getColumnIndex("timestamp");
      if (i != -1) {
        break label5112;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("timestamp", Long.TYPE));
      label2290:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label5127;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("richTime", Long.TYPE));
      label2325:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label5142;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("richBuffer", [B.class));
      label2360:
      i = paramCursor.getColumnIndex("feedType");
      if (i != -1) {
        break label5157;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("feedType", Integer.TYPE));
      label2395:
      i = paramCursor.getColumnIndex("feedTime");
      if (i != -1) {
        break label5172;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("feedTime", Long.TYPE));
      label2430:
      i = paramCursor.getColumnIndex("feedContent");
      if (i != -1) {
        break label5187;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("feedContent", String.class));
      label2465:
      i = paramCursor.getColumnIndex("feedHasPhoto");
      if (i != -1) {
        break label5202;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("feedHasPhoto", Boolean.TYPE));
      i = paramCursor.getColumnIndex("feedPhotoUrl");
      if (i != -1) {
        break label5229;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("feedPhotoUrl", String.class));
      label2535:
      i = paramCursor.getColumnIndex("isAdded2C2C");
      if (i != -1) {
        break label5244;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isAdded2C2C", Boolean.TYPE));
      i = paramCursor.getColumnIndex("chatInputType");
      if (i != -1) {
        break label5271;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("chatInputType", Integer.TYPE));
      label2605:
      i = paramCursor.getColumnIndex("showC2CPanel");
      if (i != -1) {
        break label5286;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showC2CPanel", Integer.TYPE));
      label2640:
      i = paramCursor.getColumnIndex("pttChangeVoiceType");
      if (i != -1) {
        break label5301;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pttChangeVoiceType", Integer.TYPE));
      label2675:
      i = paramCursor.getColumnIndex("audioPanelType");
      if (i != -1) {
        break label5316;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("audioPanelType", Integer.TYPE));
      label2710:
      i = paramCursor.getColumnIndex("openDoNotDisturbTime");
      if (i != -1) {
        break label5331;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("openDoNotDisturbTime", Long.TYPE));
      label2745:
      i = paramCursor.getColumnIndex("latestPLUpdateTimestamp");
      if (i != -1) {
        break label5346;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("latestPLUpdateTimestamp", Long.TYPE));
      label2780:
      i = paramCursor.getColumnIndex("lastPullPLNewsTimestamp");
      if (i != -1) {
        break label5361;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastPullPLNewsTimestamp", Long.TYPE));
      label2815:
      i = paramCursor.getColumnIndex("lastPLNewsTimestamp");
      if (i != -1) {
        break label5376;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastPLNewsTimestamp", Long.TYPE));
      label2850:
      i = paramCursor.getColumnIndex("diyFontTimestampBytes");
      if (i != -1) {
        break label5391;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyFontTimestampBytes", [B.class));
      label2885:
      i = paramCursor.getColumnIndex("diyFontConfigBytes");
      if (i != -1) {
        break label5406;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyFontConfigBytes", [B.class));
      label2920:
      i = paramCursor.getColumnIndex("lastIceBreakCheckTs");
      if (i != -1) {
        break label5421;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastIceBreakCheckTs", Long.TYPE));
      label2955:
      i = paramCursor.getColumnIndex("lastIceBreakChatTs");
      if (i != -1) {
        break label5436;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastIceBreakChatTs", Long.TYPE));
      label2990:
      i = paramCursor.getColumnIndex("makeFrdsTs");
      if (i != -1) {
        break label5451;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("makeFrdsTs", Long.TYPE));
      label3025:
      i = paramCursor.getColumnIndex("topPositionTime");
      if (i != -1) {
        break label5466;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("topPositionTime", Long.TYPE));
      label3060:
      i = paramCursor.getColumnIndex("isListenTogetherOpen");
      if (i != -1) {
        break label5481;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isListenTogetherOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isSharingLocation");
      if (i != -1) {
        break label5508;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isSharingLocation", Integer.TYPE));
      label3130:
      i = paramCursor.getColumnIndex("lastShareLbsMsgUniseq");
      if (i != -1) {
        break label5523;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastShareLbsMsgUniseq", Long.TYPE));
      label3165:
      i = paramCursor.getColumnIndex("mTogetherBusinessFlag");
      if (i != -1) {
        break label5538;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTogetherBusinessFlag", Long.TYPE));
      label3200:
      i = paramCursor.getColumnIndex("messageEnablePreview");
      if (i != -1) {
        break label5553;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("messageEnablePreview", Boolean.TYPE));
      i = paramCursor.getColumnIndex("messageEnableSound");
      if (i != -1) {
        break label5580;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("messageEnableSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("messageEnableVibrate");
      if (i != -1) {
        break label5607;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("messageEnableVibrate", Boolean.TYPE));
      i = paramCursor.getColumnIndex("friendRingId");
      if (i != -1) {
        break label5634;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("friendRingId", Integer.TYPE));
      label3340:
      i = paramCursor.getColumnIndex("messageEnablePreviewNew");
      if (i != -1) {
        break label5649;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("messageEnablePreviewNew", Integer.TYPE));
      label3375:
      i = paramCursor.getColumnIndex("messageEnableSoundNew");
      if (i != -1) {
        break label5664;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("messageEnableSoundNew", Integer.TYPE));
      label3410:
      i = paramCursor.getColumnIndex("messageEnableVibrateNew");
      if (i != -1) {
        break label5679;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("messageEnableVibrateNew", Integer.TYPE));
      label3445:
      i = paramCursor.getColumnIndex("hiddenChatSwitch");
      if (i != -1) {
        break label5694;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hiddenChatSwitch", Integer.TYPE));
      label3480:
      i = paramCursor.getColumnIndex("isAioShortcutBarOpen");
      if (i != -1) {
        break label5709;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isAioShortcutBarOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("intimate_type");
      if (i != -1) {
        break label5736;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("intimate_type", Integer.TYPE));
      label3550:
      i = paramCursor.getColumnIndex("intimate_level");
      if (i != -1) {
        break label5751;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("intimate_level", Integer.TYPE));
      label3585:
      i = paramCursor.getColumnIndex("intimate_chatDays");
      if (i != -1) {
        break label5766;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("intimate_chatDays", Integer.TYPE));
      label3620:
      i = paramCursor.getColumnIndex("last_intimate_chatTime");
      if (i != -1) {
        break label5781;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("last_intimate_chatTime", Long.TYPE));
      label3657:
      i = paramCursor.getColumnIndex("isExtinguish");
      if (i != -1) {
        break label5796;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isExtinguish", Boolean.TYPE));
      i = paramCursor.getColumnIndex("friendshipLevel");
      if (i != -1) {
        break label5823;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("friendshipLevel", Integer.TYPE));
      label3731:
      i = paramCursor.getColumnIndex("friendshipChatDays");
      if (i != -1) {
        break label5838;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("friendshipChatDays", Integer.TYPE));
      label3768:
      i = paramCursor.getColumnIndex("lastFriendshipTime");
      if (i != -1) {
        break label5853;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastFriendshipTime", Long.TYPE));
      label3805:
      i = paramCursor.getColumnIndex("chatHotLevel");
      if (i != -1) {
        break label5868;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("chatHotLevel", Integer.TYPE));
      label3842:
      i = paramCursor.getColumnIndex("chatDays");
      if (i != -1) {
        break label5883;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("chatDays", Integer.TYPE));
      label3879:
      i = paramCursor.getColumnIndex("lastChatTime");
      if (i != -1) {
        break label5898;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastChatTime", Long.TYPE));
      label3916:
      i = paramCursor.getColumnIndex("praiseHotLevel");
      if (i != -1) {
        break label5913;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("praiseHotLevel", Integer.TYPE));
      label3953:
      i = paramCursor.getColumnIndex("praiseDays");
      if (i != -1) {
        break label5928;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("praiseDays", Integer.TYPE));
      label3990:
      i = paramCursor.getColumnIndex("lastpraiseTime");
      if (i != -1) {
        break label5943;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastpraiseTime", Long.TYPE));
      label4027:
      i = paramCursor.getColumnIndex("loverChatLevel");
      if (i != -1) {
        break label5958;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("loverChatLevel", Integer.TYPE));
      label4064:
      i = paramCursor.getColumnIndex("loverChatDays");
      if (i != -1) {
        break label5973;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("loverChatDays", Integer.TYPE));
      label4101:
      i = paramCursor.getColumnIndex("loverLastChatTime");
      if (i != -1) {
        break label5988;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("loverLastChatTime", Long.TYPE));
      label4138:
      i = paramCursor.getColumnIndex("loverFlag");
      if (i != -1) {
        break label6003;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("loverFlag", Integer.TYPE));
      label4175:
      i = paramCursor.getColumnIndex("loverTransFlag");
      if (i != -1) {
        break label6018;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("loverTransFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("qzoneVisitType");
      if (i != -1) {
        break label6045;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qzoneVisitType", Integer.TYPE));
      label4249:
      i = paramCursor.getColumnIndex("qzoneHotDays");
      if (i != -1) {
        break label6060;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qzoneHotDays", Integer.TYPE));
      label4286:
      i = paramCursor.getColumnIndex("lastQzoneVisitTime");
      if (i != -1) {
        break label6075;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastQzoneVisitTime", Long.TYPE));
      label4323:
      i = paramCursor.getColumnIndex("bestIntimacyType");
      if (i != -1) {
        break label6090;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bestIntimacyType", Integer.TYPE));
      label4360:
      i = paramCursor.getColumnIndex("bestIntimacyDays");
      if (i != -1) {
        break label6105;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bestIntimacyDays", Integer.TYPE));
      label4397:
      i = paramCursor.getColumnIndex("newBestIntimacyType");
      if (i != -1) {
        break label6120;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("newBestIntimacyType", Integer.TYPE));
      label4434:
      i = paramCursor.getColumnIndex("hasRemindChat");
      if (i != -1) {
        break label6135;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasRemindChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindLoverChat");
      if (i != -1) {
        break label6162;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasRemindLoverChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindPraise");
      if (i != -1) {
        break label6189;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasRemindPraise", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindQzoneVisit");
      if (i != -1) {
        break label6216;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasRemindQzoneVisit", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindFrdship");
      if (i != -1) {
        break label6243;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasRemindFrdship", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindIntimate");
      if (i != -1) {
        break label6270;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasRemindIntimate", Boolean.TYPE));
      i = paramCursor.getColumnIndex("localChatSendTs");
      if (i != -1) {
        break label6298;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("localChatSendTs", Long.TYPE));
      label4693:
      i = paramCursor.getColumnIndex("localChatRecTs");
      if (i != -1) {
        break label6313;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("localChatRecTs", Long.TYPE));
      label4730:
      i = paramCursor.getColumnIndex("lastHotReactiveReCheckInTs");
      if (i != -1) {
        break label6328;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastHotReactiveReCheckInTs", Long.TYPE));
      label4767:
      i = paramCursor.getColumnIndex("isGrayTipRemind");
      if (i != -1) {
        break label6343;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isGrayTipRemind", Integer.TYPE));
      label4804:
      i = paramCursor.getColumnIndex("isGrayTipMultiRemind");
      if (i != -1) {
        break label6358;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isGrayTipMultiRemind", Integer.TYPE));
      label4841:
      i = paramCursor.getColumnIndex("mutual_marks_store_json");
      if (i != -1) {
        break label6373;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mutual_marks_store_json", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("mutual_mark_version");
      if (i != -1) {
        break label6388;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mutual_mark_version", Integer.TYPE));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label4932:
      paramEntity.pendantId = paramCursor.getLong(i);
      break label1870;
      label4947:
      paramEntity.pendantDiyId = paramCursor.getInt(i);
      break label1905;
      label4962:
      paramEntity.uVipFont = paramCursor.getLong(i);
      break label1940;
      label4977:
      paramEntity.vipFontType = paramCursor.getInt(i);
      break label1975;
      label4992:
      paramEntity.magicFont = paramCursor.getInt(i);
      break label2010;
      label5007:
      paramEntity.lastUpdateTime = paramCursor.getLong(i);
      break label2045;
      label5022:
      paramEntity.fontEffect = paramCursor.getInt(i);
      break label2080;
      label5037:
      paramEntity.fontEffectLastUpdateTime = paramCursor.getLong(i);
      break label2115;
      label5052:
      paramEntity.faceId = paramCursor.getInt(i);
      break label2150;
      label5067:
      paramEntity.faceIdUpdateTime = paramCursor.getLong(i);
      break label2185;
      label5082:
      paramEntity.colorRingId = paramCursor.getLong(i);
      break label2220;
      label5097:
      paramEntity.commingRingId = paramCursor.getLong(i);
      break label2255;
      label5112:
      paramEntity.timestamp = paramCursor.getLong(i);
      break label2290;
      label5127:
      paramEntity.richTime = paramCursor.getLong(i);
      break label2325;
      label5142:
      paramEntity.richBuffer = paramCursor.getBlob(i);
      break label2360;
      label5157:
      paramEntity.feedType = paramCursor.getInt(i);
      break label2395;
      label5172:
      paramEntity.feedTime = paramCursor.getLong(i);
      break label2430;
      label5187:
      paramEntity.feedContent = paramCursor.getString(i);
      break label2465;
      label5202:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.feedHasPhoto = paramBoolean;
        break;
      }
      label5229:
      paramEntity.feedPhotoUrl = paramCursor.getString(i);
      break label2535;
      label5244:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isAdded2C2C = paramBoolean;
        break;
      }
      label5271:
      paramEntity.chatInputType = paramCursor.getInt(i);
      break label2605;
      label5286:
      paramEntity.showC2CPanel = paramCursor.getInt(i);
      break label2640;
      label5301:
      paramEntity.pttChangeVoiceType = paramCursor.getInt(i);
      break label2675;
      label5316:
      paramEntity.audioPanelType = paramCursor.getInt(i);
      break label2710;
      label5331:
      paramEntity.openDoNotDisturbTime = paramCursor.getLong(i);
      break label2745;
      label5346:
      paramEntity.latestPLUpdateTimestamp = paramCursor.getLong(i);
      break label2780;
      label5361:
      paramEntity.lastPullPLNewsTimestamp = paramCursor.getLong(i);
      break label2815;
      label5376:
      paramEntity.lastPLNewsTimestamp = paramCursor.getLong(i);
      break label2850;
      label5391:
      paramEntity.diyFontTimestampBytes = paramCursor.getBlob(i);
      break label2885;
      label5406:
      paramEntity.diyFontConfigBytes = paramCursor.getBlob(i);
      break label2920;
      label5421:
      paramEntity.lastIceBreakCheckTs = paramCursor.getLong(i);
      break label2955;
      label5436:
      paramEntity.lastIceBreakChatTs = paramCursor.getLong(i);
      break label2990;
      label5451:
      paramEntity.makeFrdsTs = paramCursor.getLong(i);
      break label3025;
      label5466:
      paramEntity.topPositionTime = paramCursor.getLong(i);
      break label3060;
      label5481:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isListenTogetherOpen = paramBoolean;
        break;
      }
      label5508:
      paramEntity.isSharingLocation = paramCursor.getInt(i);
      break label3130;
      label5523:
      paramEntity.lastShareLbsMsgUniseq = paramCursor.getLong(i);
      break label3165;
      label5538:
      paramEntity.mTogetherBusinessFlag = paramCursor.getLong(i);
      break label3200;
      label5553:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.messageEnablePreview = paramBoolean;
        break;
      }
      label5580:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.messageEnableSound = paramBoolean;
        break;
      }
      label5607:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.messageEnableVibrate = paramBoolean;
        break;
      }
      label5634:
      paramEntity.friendRingId = paramCursor.getInt(i);
      break label3340;
      label5649:
      paramEntity.messageEnablePreviewNew = paramCursor.getInt(i);
      break label3375;
      label5664:
      paramEntity.messageEnableSoundNew = paramCursor.getInt(i);
      break label3410;
      label5679:
      paramEntity.messageEnableVibrateNew = paramCursor.getInt(i);
      break label3445;
      label5694:
      paramEntity.hiddenChatSwitch = paramCursor.getInt(i);
      break label3480;
      label5709:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isAioShortcutBarOpen = paramBoolean;
        break;
      }
      label5736:
      paramEntity.intimate_type = paramCursor.getInt(i);
      break label3550;
      label5751:
      paramEntity.intimate_level = paramCursor.getInt(i);
      break label3585;
      label5766:
      paramEntity.intimate_chatDays = paramCursor.getInt(i);
      break label3620;
      label5781:
      paramEntity.last_intimate_chatTime = paramCursor.getLong(i);
      break label3657;
      label5796:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isExtinguish = paramBoolean;
        break;
      }
      label5823:
      paramEntity.friendshipLevel = paramCursor.getInt(i);
      break label3731;
      label5838:
      paramEntity.friendshipChatDays = paramCursor.getInt(i);
      break label3768;
      label5853:
      paramEntity.lastFriendshipTime = paramCursor.getLong(i);
      break label3805;
      label5868:
      paramEntity.chatHotLevel = paramCursor.getInt(i);
      break label3842;
      label5883:
      paramEntity.chatDays = paramCursor.getInt(i);
      break label3879;
      label5898:
      paramEntity.lastChatTime = paramCursor.getLong(i);
      break label3916;
      label5913:
      paramEntity.praiseHotLevel = paramCursor.getInt(i);
      break label3953;
      label5928:
      paramEntity.praiseDays = paramCursor.getInt(i);
      break label3990;
      label5943:
      paramEntity.lastpraiseTime = paramCursor.getLong(i);
      break label4027;
      label5958:
      paramEntity.loverChatLevel = paramCursor.getInt(i);
      break label4064;
      label5973:
      paramEntity.loverChatDays = paramCursor.getInt(i);
      break label4101;
      label5988:
      paramEntity.loverLastChatTime = paramCursor.getLong(i);
      break label4138;
      label6003:
      paramEntity.loverFlag = paramCursor.getInt(i);
      break label4175;
      label6018:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.loverTransFlag = paramBoolean;
        break;
      }
      label6045:
      paramEntity.qzoneVisitType = paramCursor.getInt(i);
      break label4249;
      label6060:
      paramEntity.qzoneHotDays = paramCursor.getInt(i);
      break label4286;
      label6075:
      paramEntity.lastQzoneVisitTime = paramCursor.getLong(i);
      break label4323;
      label6090:
      paramEntity.bestIntimacyType = paramCursor.getInt(i);
      break label4360;
      label6105:
      paramEntity.bestIntimacyDays = paramCursor.getInt(i);
      break label4397;
      label6120:
      paramEntity.newBestIntimacyType = paramCursor.getInt(i);
      break label4434;
      label6135:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasRemindChat = paramBoolean;
        break;
      }
      label6162:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasRemindLoverChat = paramBoolean;
        break;
      }
      label6189:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasRemindPraise = paramBoolean;
        break;
      }
      label6216:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasRemindQzoneVisit = paramBoolean;
        break;
      }
      label6243:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasRemindFrdship = paramBoolean;
        break;
      }
      label6270:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.hasRemindIntimate = paramBoolean;
        break;
      }
      label6298:
      paramEntity.localChatSendTs = paramCursor.getLong(i);
      break label4693;
      label6313:
      paramEntity.localChatRecTs = paramCursor.getLong(i);
      break label4730;
      label6328:
      paramEntity.lastHotReactiveReCheckInTs = paramCursor.getLong(i);
      break label4767;
      label6343:
      paramEntity.isGrayTipRemind = paramCursor.getInt(i);
      break label4804;
      label6358:
      paramEntity.isGrayTipMultiRemind = paramCursor.getInt(i);
      break label4841;
      label6373:
      paramEntity.mutual_marks_store_json = paramCursor.getString(i);
    }
    label6388:
    paramEntity.mutual_mark_version = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (ExtensionInfo)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("pendantId", Long.valueOf(paramEntity.pendantId));
    paramContentValues.put("pendantDiyId", Integer.valueOf(paramEntity.pendantDiyId));
    paramContentValues.put("uVipFont", Long.valueOf(paramEntity.uVipFont));
    paramContentValues.put("vipFontType", Integer.valueOf(paramEntity.vipFontType));
    paramContentValues.put("magicFont", Integer.valueOf(paramEntity.magicFont));
    paramContentValues.put("lastUpdateTime", Long.valueOf(paramEntity.lastUpdateTime));
    paramContentValues.put("fontEffect", Integer.valueOf(paramEntity.fontEffect));
    paramContentValues.put("fontEffectLastUpdateTime", Long.valueOf(paramEntity.fontEffectLastUpdateTime));
    paramContentValues.put("faceId", Integer.valueOf(paramEntity.faceId));
    paramContentValues.put("faceIdUpdateTime", Long.valueOf(paramEntity.faceIdUpdateTime));
    paramContentValues.put("colorRingId", Long.valueOf(paramEntity.colorRingId));
    paramContentValues.put("commingRingId", Long.valueOf(paramEntity.commingRingId));
    paramContentValues.put("timestamp", Long.valueOf(paramEntity.timestamp));
    paramContentValues.put("richTime", Long.valueOf(paramEntity.richTime));
    paramContentValues.put("richBuffer", paramEntity.richBuffer);
    paramContentValues.put("feedType", Integer.valueOf(paramEntity.feedType));
    paramContentValues.put("feedTime", Long.valueOf(paramEntity.feedTime));
    paramContentValues.put("feedContent", paramEntity.feedContent);
    paramContentValues.put("feedHasPhoto", Boolean.valueOf(paramEntity.feedHasPhoto));
    paramContentValues.put("feedPhotoUrl", paramEntity.feedPhotoUrl);
    paramContentValues.put("isAdded2C2C", Boolean.valueOf(paramEntity.isAdded2C2C));
    paramContentValues.put("chatInputType", Integer.valueOf(paramEntity.chatInputType));
    paramContentValues.put("showC2CPanel", Integer.valueOf(paramEntity.showC2CPanel));
    paramContentValues.put("pttChangeVoiceType", Integer.valueOf(paramEntity.pttChangeVoiceType));
    paramContentValues.put("audioPanelType", Integer.valueOf(paramEntity.audioPanelType));
    paramContentValues.put("openDoNotDisturbTime", Long.valueOf(paramEntity.openDoNotDisturbTime));
    paramContentValues.put("latestPLUpdateTimestamp", Long.valueOf(paramEntity.latestPLUpdateTimestamp));
    paramContentValues.put("lastPullPLNewsTimestamp", Long.valueOf(paramEntity.lastPullPLNewsTimestamp));
    paramContentValues.put("lastPLNewsTimestamp", Long.valueOf(paramEntity.lastPLNewsTimestamp));
    paramContentValues.put("diyFontTimestampBytes", paramEntity.diyFontTimestampBytes);
    paramContentValues.put("diyFontConfigBytes", paramEntity.diyFontConfigBytes);
    paramContentValues.put("lastIceBreakCheckTs", Long.valueOf(paramEntity.lastIceBreakCheckTs));
    paramContentValues.put("lastIceBreakChatTs", Long.valueOf(paramEntity.lastIceBreakChatTs));
    paramContentValues.put("makeFrdsTs", Long.valueOf(paramEntity.makeFrdsTs));
    paramContentValues.put("topPositionTime", Long.valueOf(paramEntity.topPositionTime));
    paramContentValues.put("isListenTogetherOpen", Boolean.valueOf(paramEntity.isListenTogetherOpen));
    paramContentValues.put("isSharingLocation", Integer.valueOf(paramEntity.isSharingLocation));
    paramContentValues.put("lastShareLbsMsgUniseq", Long.valueOf(paramEntity.lastShareLbsMsgUniseq));
    paramContentValues.put("mTogetherBusinessFlag", Long.valueOf(paramEntity.mTogetherBusinessFlag));
    paramContentValues.put("messageEnablePreview", Boolean.valueOf(paramEntity.messageEnablePreview));
    paramContentValues.put("messageEnableSound", Boolean.valueOf(paramEntity.messageEnableSound));
    paramContentValues.put("messageEnableVibrate", Boolean.valueOf(paramEntity.messageEnableVibrate));
    paramContentValues.put("friendRingId", Integer.valueOf(paramEntity.friendRingId));
    paramContentValues.put("messageEnablePreviewNew", Integer.valueOf(paramEntity.messageEnablePreviewNew));
    paramContentValues.put("messageEnableSoundNew", Integer.valueOf(paramEntity.messageEnableSoundNew));
    paramContentValues.put("messageEnableVibrateNew", Integer.valueOf(paramEntity.messageEnableVibrateNew));
    paramContentValues.put("hiddenChatSwitch", Integer.valueOf(paramEntity.hiddenChatSwitch));
    paramContentValues.put("isAioShortcutBarOpen", Boolean.valueOf(paramEntity.isAioShortcutBarOpen));
    paramContentValues.put("intimate_type", Integer.valueOf(paramEntity.intimate_type));
    paramContentValues.put("intimate_level", Integer.valueOf(paramEntity.intimate_level));
    paramContentValues.put("intimate_chatDays", Integer.valueOf(paramEntity.intimate_chatDays));
    paramContentValues.put("last_intimate_chatTime", Long.valueOf(paramEntity.last_intimate_chatTime));
    paramContentValues.put("isExtinguish", Boolean.valueOf(paramEntity.isExtinguish));
    paramContentValues.put("friendshipLevel", Integer.valueOf(paramEntity.friendshipLevel));
    paramContentValues.put("friendshipChatDays", Integer.valueOf(paramEntity.friendshipChatDays));
    paramContentValues.put("lastFriendshipTime", Long.valueOf(paramEntity.lastFriendshipTime));
    paramContentValues.put("chatHotLevel", Integer.valueOf(paramEntity.chatHotLevel));
    paramContentValues.put("chatDays", Integer.valueOf(paramEntity.chatDays));
    paramContentValues.put("lastChatTime", Long.valueOf(paramEntity.lastChatTime));
    paramContentValues.put("praiseHotLevel", Integer.valueOf(paramEntity.praiseHotLevel));
    paramContentValues.put("praiseDays", Integer.valueOf(paramEntity.praiseDays));
    paramContentValues.put("lastpraiseTime", Long.valueOf(paramEntity.lastpraiseTime));
    paramContentValues.put("loverChatLevel", Integer.valueOf(paramEntity.loverChatLevel));
    paramContentValues.put("loverChatDays", Integer.valueOf(paramEntity.loverChatDays));
    paramContentValues.put("loverLastChatTime", Long.valueOf(paramEntity.loverLastChatTime));
    paramContentValues.put("loverFlag", Integer.valueOf(paramEntity.loverFlag));
    paramContentValues.put("loverTransFlag", Boolean.valueOf(paramEntity.loverTransFlag));
    paramContentValues.put("qzoneVisitType", Integer.valueOf(paramEntity.qzoneVisitType));
    paramContentValues.put("qzoneHotDays", Integer.valueOf(paramEntity.qzoneHotDays));
    paramContentValues.put("lastQzoneVisitTime", Long.valueOf(paramEntity.lastQzoneVisitTime));
    paramContentValues.put("bestIntimacyType", Integer.valueOf(paramEntity.bestIntimacyType));
    paramContentValues.put("bestIntimacyDays", Integer.valueOf(paramEntity.bestIntimacyDays));
    paramContentValues.put("newBestIntimacyType", Integer.valueOf(paramEntity.newBestIntimacyType));
    paramContentValues.put("hasRemindChat", Boolean.valueOf(paramEntity.hasRemindChat));
    paramContentValues.put("hasRemindLoverChat", Boolean.valueOf(paramEntity.hasRemindLoverChat));
    paramContentValues.put("hasRemindPraise", Boolean.valueOf(paramEntity.hasRemindPraise));
    paramContentValues.put("hasRemindQzoneVisit", Boolean.valueOf(paramEntity.hasRemindQzoneVisit));
    paramContentValues.put("hasRemindFrdship", Boolean.valueOf(paramEntity.hasRemindFrdship));
    paramContentValues.put("hasRemindIntimate", Boolean.valueOf(paramEntity.hasRemindIntimate));
    paramContentValues.put("localChatSendTs", Long.valueOf(paramEntity.localChatSendTs));
    paramContentValues.put("localChatRecTs", Long.valueOf(paramEntity.localChatRecTs));
    paramContentValues.put("lastHotReactiveReCheckInTs", Long.valueOf(paramEntity.lastHotReactiveReCheckInTs));
    paramContentValues.put("isGrayTipRemind", Integer.valueOf(paramEntity.isGrayTipRemind));
    paramContentValues.put("isGrayTipMultiRemind", Integer.valueOf(paramEntity.isGrayTipMultiRemind));
    paramContentValues.put("mutual_marks_store_json", paramEntity.mutual_marks_store_json);
    paramContentValues.put("mutual_mark_version", Integer.valueOf(paramEntity.mutual_mark_version));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,pendantId INTEGER ,pendantDiyId INTEGER ,uVipFont INTEGER ,vipFontType INTEGER ,magicFont INTEGER ,lastUpdateTime INTEGER ,fontEffect INTEGER ,fontEffectLastUpdateTime INTEGER ,faceId INTEGER ,faceIdUpdateTime INTEGER ,colorRingId INTEGER ,commingRingId INTEGER ,timestamp INTEGER ,richTime INTEGER ,richBuffer BLOB ,feedType INTEGER ,feedTime INTEGER ,feedContent TEXT ,feedHasPhoto INTEGER ,feedPhotoUrl TEXT ,isAdded2C2C INTEGER ,chatInputType INTEGER ,showC2CPanel INTEGER ,pttChangeVoiceType INTEGER ,audioPanelType INTEGER ,openDoNotDisturbTime INTEGER ,latestPLUpdateTimestamp INTEGER ,lastPullPLNewsTimestamp INTEGER ,lastPLNewsTimestamp INTEGER ,diyFontTimestampBytes BLOB ,diyFontConfigBytes BLOB ,lastIceBreakCheckTs INTEGER ,lastIceBreakChatTs INTEGER ,makeFrdsTs INTEGER ,topPositionTime INTEGER ,isListenTogetherOpen INTEGER ,isSharingLocation INTEGER ,lastShareLbsMsgUniseq INTEGER ,mTogetherBusinessFlag INTEGER ,messageEnablePreview INTEGER ,messageEnableSound INTEGER ,messageEnableVibrate INTEGER ,friendRingId INTEGER ,messageEnablePreviewNew INTEGER ,messageEnableSoundNew INTEGER ,messageEnableVibrateNew INTEGER ,hiddenChatSwitch INTEGER ,isAioShortcutBarOpen INTEGER ,intimate_type INTEGER ,intimate_level INTEGER ,intimate_chatDays INTEGER ,last_intimate_chatTime INTEGER ,isExtinguish INTEGER ,friendshipLevel INTEGER ,friendshipChatDays INTEGER ,lastFriendshipTime INTEGER ,chatHotLevel INTEGER ,chatDays INTEGER ,lastChatTime INTEGER ,praiseHotLevel INTEGER ,praiseDays INTEGER ,lastpraiseTime INTEGER ,loverChatLevel INTEGER ,loverChatDays INTEGER ,loverLastChatTime INTEGER ,loverFlag INTEGER ,loverTransFlag INTEGER ,qzoneVisitType INTEGER ,qzoneHotDays INTEGER ,lastQzoneVisitTime INTEGER ,bestIntimacyType INTEGER ,bestIntimacyDays INTEGER ,newBestIntimacyType INTEGER ,hasRemindChat INTEGER ,hasRemindLoverChat INTEGER ,hasRemindPraise INTEGER ,hasRemindQzoneVisit INTEGER ,hasRemindFrdship INTEGER ,hasRemindIntimate INTEGER ,localChatSendTs INTEGER ,localChatRecTs INTEGER ,lastHotReactiveReCheckInTs INTEGER ,isGrayTipRemind INTEGER ,isGrayTipMultiRemind INTEGER ,mutual_marks_store_json TEXT ,mutual_mark_version INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aybc
 * JD-Core Version:    0.7.0.1
 */