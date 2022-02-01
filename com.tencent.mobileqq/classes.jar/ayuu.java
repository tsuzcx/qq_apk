import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class ayuu
  extends OGAbstractDao
{
  public ayuu()
  {
    this.columnLen = 212;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (Card)paramEntity;
    label1387:
    label2029:
    label4080:
    label4216:
    label4346:
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.strNick = paramCursor.getString(paramCursor.getColumnIndex("strNick"));
      paramEntity.shGender = paramCursor.getShort(paramCursor.getColumnIndex("shGender"));
      paramEntity.shAge = paramCursor.getShort(paramCursor.getColumnIndex("shAge"));
      paramEntity.nFaceID = paramCursor.getInt(paramCursor.getColumnIndex("nFaceID"));
      paramEntity.strCertificationInfo = paramCursor.getString(paramCursor.getColumnIndex("strCertificationInfo"));
      paramEntity.shType = paramCursor.getShort(paramCursor.getColumnIndex("shType"));
      paramEntity.vContent = paramCursor.getBlob(paramCursor.getColumnIndex("vContent"));
      paramEntity.strSign = paramCursor.getString(paramCursor.getColumnIndex("strSign"));
      paramEntity.strCompany = paramCursor.getString(paramCursor.getColumnIndex("strCompany"));
      paramEntity.strSchool = paramCursor.getString(paramCursor.getColumnIndex("strSchool"));
      paramEntity.uFaceTimeStamp = paramCursor.getInt(paramCursor.getColumnIndex("uFaceTimeStamp"));
      paramEntity.vQQFaceID = paramCursor.getBlob(paramCursor.getColumnIndex("vQQFaceID"));
      paramEntity.strReMark = paramCursor.getString(paramCursor.getColumnIndex("strReMark"));
      paramEntity.bWeiboInfo = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bWeiboInfo")));
      paramEntity.bQzoneInfo = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bQzoneInfo")));
      paramEntity.nSameFriendsNum = paramCursor.getInt(paramCursor.getColumnIndex("nSameFriendsNum"));
      paramEntity.strCompanySame = paramCursor.getString(paramCursor.getColumnIndex("strCompanySame"));
      paramEntity.strSchoolSame = paramCursor.getString(paramCursor.getColumnIndex("strSchoolSame"));
      paramEntity.lCardShowNum = paramCursor.getLong(paramCursor.getColumnIndex("lCardShowNum"));
      paramEntity.bSingle = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSingle")));
      paramEntity.lVisitCount = paramCursor.getLong(paramCursor.getColumnIndex("lVisitCount"));
      paramEntity.lVoteCount = paramCursor.getLong(paramCursor.getColumnIndex("lVoteCount"));
      paramEntity.tagInfosByte = paramCursor.getBlob(paramCursor.getColumnIndex("tagInfosByte"));
      paramEntity.eUserIdentityType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("eUserIdentityType")));
      paramEntity.vBackground = paramCursor.getBlob(paramCursor.getColumnIndex("vBackground"));
      paramEntity.labelInfoBytes = paramCursor.getBlob(paramCursor.getColumnIndex("labelInfoBytes"));
      paramEntity.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramEntity.constellation = paramCursor.getInt(paramCursor.getColumnIndex("constellation"));
      paramEntity.pyFaceUrl = paramCursor.getString(paramCursor.getColumnIndex("pyFaceUrl"));
      paramEntity.location = paramCursor.getString(paramCursor.getColumnIndex("location"));
      paramEntity.bVoted = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bVoted")));
      paramEntity.bFavorited = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bFavorited")));
      paramEntity.iVoteIncrement = paramCursor.getInt(paramCursor.getColumnIndex("iVoteIncrement"));
      paramEntity.strJoinHexAlbumFileKey = paramCursor.getString(paramCursor.getColumnIndex("strJoinHexAlbumFileKey"));
      paramEntity.iFaceNum = paramCursor.getInt(paramCursor.getColumnIndex("iFaceNum"));
      paramEntity.cSqqLevel = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSqqLevel")));
      paramEntity.iQQLevel = paramCursor.getInt(paramCursor.getColumnIndex("iQQLevel"));
      paramEntity.uCurMulType = paramCursor.getLong(paramCursor.getColumnIndex("uCurMulType"));
      paramEntity.strProvince = paramCursor.getString(paramCursor.getColumnIndex("strProvince"));
      paramEntity.strCity = paramCursor.getString(paramCursor.getColumnIndex("strCity"));
      paramEntity.strCountry = paramCursor.getString(paramCursor.getColumnIndex("strCountry"));
      paramEntity.lBirthday = paramCursor.getLong(paramCursor.getColumnIndex("lBirthday"));
      paramEntity.strLocationCodes = paramCursor.getString(paramCursor.getColumnIndex("strLocationCodes"));
      paramEntity.strLocationDesc = paramCursor.getString(paramCursor.getColumnIndex("strLocationDesc"));
      paramEntity.strHometownCodes = paramCursor.getString(paramCursor.getColumnIndex("strHometownCodes"));
      paramEntity.strHometownDesc = paramCursor.getString(paramCursor.getColumnIndex("strHometownDesc"));
      paramEntity.strHometownCountry = paramCursor.getString(paramCursor.getColumnIndex("strHometownCountry"));
      paramEntity.strHometownProvince = paramCursor.getString(paramCursor.getColumnIndex("strHometownProvince"));
      paramEntity.strHometownCity = paramCursor.getString(paramCursor.getColumnIndex("strHometownCity"));
      paramEntity.strEmail = paramCursor.getString(paramCursor.getColumnIndex("strEmail"));
      paramEntity.strPersonalNote = paramCursor.getString(paramCursor.getColumnIndex("strPersonalNote"));
      paramEntity.iProfession = paramCursor.getInt(paramCursor.getColumnIndex("iProfession"));
      paramEntity.bindPhoneInfo = paramCursor.getString(paramCursor.getColumnIndex("bindPhoneInfo"));
      paramEntity.bCardInfo = paramCursor.getBlob(paramCursor.getColumnIndex("bCardInfo"));
      paramEntity.strTroopName = paramCursor.getString(paramCursor.getColumnIndex("strTroopName"));
      paramEntity.strTroopNick = paramCursor.getString(paramCursor.getColumnIndex("strTroopNick"));
      paramEntity.strMobile = paramCursor.getString(paramCursor.getColumnIndex("strMobile"));
      paramEntity.strContactName = paramCursor.getString(paramCursor.getColumnIndex("strContactName"));
      paramEntity.ulShowControl = paramCursor.getInt(paramCursor.getColumnIndex("ulShowControl"));
      paramEntity.feedPreviewTime = paramCursor.getLong(paramCursor.getColumnIndex("feedPreviewTime"));
      paramEntity.strQzoneFeedsDesc = paramCursor.getString(paramCursor.getColumnIndex("strQzoneFeedsDesc"));
      paramEntity.StrPresentDesc = paramCursor.getString(paramCursor.getColumnIndex("StrPresentDesc"));
      paramEntity.strSpaceName = paramCursor.getString(paramCursor.getColumnIndex("strSpaceName"));
      paramEntity.strQzoneHeader = paramCursor.getString(paramCursor.getColumnIndex("strQzoneHeader"));
      paramEntity.vQzonePhotos = paramCursor.getBlob(paramCursor.getColumnIndex("vQzonePhotos"));
      paramEntity.vQzoneCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vQzoneCoverInfo"));
      paramEntity.enlargeQzonePic = paramCursor.getInt(paramCursor.getColumnIndex("enlargeQzonePic"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("showPublishButton")))
      {
        paramBoolean = true;
        paramEntity.showPublishButton = paramBoolean;
        paramEntity.strStatus = paramCursor.getString(paramCursor.getColumnIndex("strStatus"));
        paramEntity.strAutoRemark = paramCursor.getString(paramCursor.getColumnIndex("strAutoRemark"));
        paramEntity.vSeed = paramCursor.getBlob(paramCursor.getColumnIndex("vSeed"));
        paramEntity.vCookies = paramCursor.getBlob(paramCursor.getColumnIndex("vCookies"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasFakeData"))) {
          break label4216;
        }
        paramBoolean = true;
        paramEntity.hasFakeData = paramBoolean;
        paramEntity.bQQVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bQQVipOpen")));
        paramEntity.iQQVipType = paramCursor.getInt(paramCursor.getColumnIndex("iQQVipType"));
        paramEntity.iQQVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iQQVipLevel"));
        paramEntity.nameplateVipType = paramCursor.getInt(paramCursor.getColumnIndex("nameplateVipType"));
        paramEntity.grayNameplateFlag = paramCursor.getInt(paramCursor.getColumnIndex("grayNameplateFlag"));
        paramEntity.bSuperVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSuperVipOpen")));
        paramEntity.iSuperVipType = paramCursor.getInt(paramCursor.getColumnIndex("iSuperVipType"));
        paramEntity.iSuperVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iSuperVipLevel"));
        paramEntity.bSuperQQOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSuperQQOpen")));
        paramEntity.iSuperQQType = paramCursor.getInt(paramCursor.getColumnIndex("iSuperQQType"));
        paramEntity.iSuperQQLevel = paramCursor.getInt(paramCursor.getColumnIndex("iSuperQQLevel"));
        paramEntity.bHollywoodVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bHollywoodVipOpen")));
        paramEntity.iHollywoodVipType = paramCursor.getInt(paramCursor.getColumnIndex("iHollywoodVipType"));
        paramEntity.iHollywoodVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iHollywoodVipLevel"));
        paramEntity.strShowName = paramCursor.getString(paramCursor.getColumnIndex("strShowName"));
        paramEntity.vRichSign = paramCursor.getBlob(paramCursor.getColumnIndex("vRichSign"));
        paramEntity.lSignModifyTime = paramCursor.getLong(paramCursor.getColumnIndex("lSignModifyTime"));
        paramEntity.vLongNickTopicInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vLongNickTopicInfo"));
        paramEntity.lUserFlag = paramCursor.getLong(paramCursor.getColumnIndex("lUserFlag"));
        paramEntity.lLoginDays = paramCursor.getLong(paramCursor.getColumnIndex("lLoginDays"));
        paramEntity.strLoginDaysDesc = paramCursor.getString(paramCursor.getColumnIndex("strLoginDaysDesc"));
        paramEntity.lQQMasterLogindays = paramCursor.getLong(paramCursor.getColumnIndex("lQQMasterLogindays"));
        paramEntity.iXManScene1DelayTime = paramCursor.getInt(paramCursor.getColumnIndex("iXManScene1DelayTime"));
        paramEntity.iXManScene2DelayTime = paramCursor.getInt(paramCursor.getColumnIndex("iXManScene2DelayTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowPeopleSee"))) {
          break label4221;
        }
        paramBoolean = true;
        paramEntity.allowPeopleSee = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowCalInteractive"))) {
          break label4226;
        }
        paramBoolean = true;
        paramEntity.allowCalInteractive = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showOnlineFriends"))) {
          break label4231;
        }
        paramBoolean = true;
        paramEntity.showOnlineFriends = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowClick"))) {
          break label4236;
        }
        paramBoolean = true;
        paramEntity.allowClick = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("babyQSwitch"))) {
          break label4241;
        }
        paramBoolean = true;
        paramEntity.babyQSwitch = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperRedDiamond"))) {
          break label4246;
        }
        paramBoolean = true;
        paramEntity.isSuperRedDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRedDiamond"))) {
          break label4251;
        }
        paramBoolean = true;
        paramEntity.isRedDiamond = paramBoolean;
        paramEntity.redLevel = paramCursor.getInt(paramCursor.getColumnIndex("redLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperYellowDiamond"))) {
          break label4256;
        }
        paramBoolean = true;
        paramEntity.isSuperYellowDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isYellowDiamond"))) {
          break label4261;
        }
        paramBoolean = true;
        paramEntity.isYellowDiamond = paramBoolean;
        paramEntity.yellowLevel = paramCursor.getInt(paramCursor.getColumnIndex("yellowLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperGreenDiamond"))) {
          break label4266;
        }
        paramBoolean = true;
        paramEntity.isSuperGreenDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isGreenDiamond"))) {
          break label4271;
        }
        paramBoolean = true;
        label2171:
        paramEntity.isGreenDiamond = paramBoolean;
        paramEntity.greenLevel = paramCursor.getInt(paramCursor.getColumnIndex("greenLevel"));
        paramEntity.templateRet = paramCursor.getInt(paramCursor.getColumnIndex("templateRet"));
        paramEntity.lCurrentStyleId = paramCursor.getLong(paramCursor.getColumnIndex("lCurrentStyleId"));
        paramEntity.lCurrentBgId = paramCursor.getLong(paramCursor.getColumnIndex("lCurrentBgId"));
        paramEntity.backgroundUrl = paramCursor.getString(paramCursor.getColumnIndex("backgroundUrl"));
        paramEntity.backgroundColor = paramCursor.getLong(paramCursor.getColumnIndex("backgroundColor"));
        paramEntity.dynamicCardFlag = paramCursor.getInt(paramCursor.getColumnIndex("dynamicCardFlag"));
        paramEntity.strZipUrl = paramCursor.getString(paramCursor.getColumnIndex("strZipUrl"));
        paramEntity.strActiveUrl = paramCursor.getString(paramCursor.getColumnIndex("strActiveUrl"));
        paramEntity.strDrawerCardUrl = paramCursor.getString(paramCursor.getColumnIndex("strDrawerCardUrl"));
        paramEntity.strWzryHeroUrl = paramCursor.getString(paramCursor.getColumnIndex("strWzryHeroUrl"));
        paramEntity.wzryHonorInfo = paramCursor.getBlob(paramCursor.getColumnIndex("wzryHonorInfo"));
        paramEntity.strExtInfo = paramCursor.getString(paramCursor.getColumnIndex("strExtInfo"));
        paramEntity.strCurrentBgUrl = paramCursor.getString(paramCursor.getColumnIndex("strCurrentBgUrl"));
        paramEntity.bgType = paramCursor.getBlob(paramCursor.getColumnIndex("bgType"));
        paramEntity.encId = paramCursor.getString(paramCursor.getColumnIndex("encId"));
        paramEntity.busiEntry = paramCursor.getString(paramCursor.getColumnIndex("busiEntry"));
        paramEntity.favoriteSource = paramCursor.getInt(paramCursor.getColumnIndex("favoriteSource"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("visibleMusicPendant"))) {
          break label4276;
        }
        paramBoolean = true;
        paramEntity.visibleMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("autoPlayMusicPendant"))) {
          break label4281;
        }
        paramBoolean = true;
        paramEntity.autoPlayMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showRedPointMusicPendant"))) {
          break label4286;
        }
        paramBoolean = true;
        paramEntity.showRedPointMusicPendant = paramBoolean;
        paramEntity.privilegePromptStr = paramCursor.getString(paramCursor.getColumnIndex("privilegePromptStr"));
        paramEntity.privilegeJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("privilegeJumpUrl"));
        paramEntity.vOpenPriv = paramCursor.getBlob(paramCursor.getColumnIndex("vOpenPriv"));
        paramEntity.vClosePriv = paramCursor.getBlob(paramCursor.getColumnIndex("vClosePriv"));
        paramEntity.presentDesc = paramCursor.getString(paramCursor.getColumnIndex("presentDesc"));
        paramEntity.presentCustourl = paramCursor.getString(paramCursor.getColumnIndex("presentCustourl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("presentSwitch"))) {
          break label4291;
        }
        paramBoolean = true;
        paramEntity.presentSwitch = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showPresent"))) {
          break label4296;
        }
        paramBoolean = true;
        paramEntity.showPresent = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showMusicBox"))) {
          break label4301;
        }
        paramBoolean = true;
        paramEntity.showMusicBox = paramBoolean;
        paramEntity.addSrcName = paramCursor.getString(paramCursor.getColumnIndex("addSrcName"));
        paramEntity.addSrcId = paramCursor.getLong(paramCursor.getColumnIndex("addSrcId"));
        paramEntity.addSubSrcId = paramCursor.getLong(paramCursor.getColumnIndex("addSubSrcId"));
        paramEntity.strVoteLimitedNotice = paramCursor.getString(paramCursor.getColumnIndex("strVoteLimitedNotice"));
        paramEntity.bHaveVotedCnt = paramCursor.getShort(paramCursor.getColumnIndex("bHaveVotedCnt"));
        paramEntity.bAvailVoteCnt = paramCursor.getShort(paramCursor.getColumnIndex("bAvailVoteCnt"));
        paramEntity.mNowShowFlag = paramCursor.getInt(paramCursor.getColumnIndex("mNowShowFlag"));
        paramEntity.mNowShowIconUrl = paramCursor.getString(paramCursor.getColumnIndex("mNowShowIconUrl"));
        paramEntity.mNowShowJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("mNowShowJumpUrl"));
        paramEntity.vCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vCoverInfo"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("medalSwitchDisable"))) {
          break label4306;
        }
        paramBoolean = true;
        paramEntity.medalSwitchDisable = paramBoolean;
        paramEntity.iMedalCount = paramCursor.getInt(paramCursor.getColumnIndex("iMedalCount"));
        paramEntity.iNewCount = paramCursor.getInt(paramCursor.getColumnIndex("iNewCount"));
        paramEntity.iUpgradeCount = paramCursor.getInt(paramCursor.getColumnIndex("iUpgradeCount"));
        paramEntity.strPromptParams = paramCursor.getString(paramCursor.getColumnIndex("strPromptParams"));
        paramEntity.hobbyEntry = paramCursor.getString(paramCursor.getColumnIndex("hobbyEntry"));
        paramEntity.lastPraiseInfoList = paramCursor.getBlob(paramCursor.getColumnIndex("lastPraiseInfoList"));
        paramEntity.tempChatSig = paramCursor.getBlob(paramCursor.getColumnIndex("tempChatSig"));
        paramEntity.namePlateOfKingGameId = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingGameId"));
        paramEntity.namePlateOfKingLoginTime = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingLoginTime"));
        paramEntity.namePlateOfKingDan = paramCursor.getInt(paramCursor.getColumnIndex("namePlateOfKingDan"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch"))) {
          break label4311;
        }
        paramBoolean = true;
        paramEntity.namePlateOfKingDanDisplatSwitch = paramBoolean;
        paramEntity.vPersonalityLabelV2 = paramCursor.getBlob(paramCursor.getColumnIndex("vPersonalityLabelV2"));
        paramEntity.cardType = paramCursor.getInt(paramCursor.getColumnIndex("cardType"));
        paramEntity.diyText = paramCursor.getString(paramCursor.getColumnIndex("diyText"));
        paramEntity.diyTextFontId = paramCursor.getInt(paramCursor.getColumnIndex("diyTextFontId"));
        paramEntity.diyTextWidth = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextWidth"));
        paramEntity.diyTextHeight = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextHeight"));
        paramEntity.diyTextLocX = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextLocX"));
        paramEntity.diyTextLocY = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextLocY"));
        paramEntity.diyTextDegree = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextDegree"));
        paramEntity.diyTextScale = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextScale"));
        paramEntity.diyTextTransparency = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextTransparency"));
        paramEntity.diyDefaultText = paramCursor.getString(paramCursor.getColumnIndex("diyDefaultText"));
        paramEntity.popularity = paramCursor.getInt(paramCursor.getColumnIndex("popularity"));
        paramEntity.declaration = paramCursor.getString(paramCursor.getColumnIndex("declaration"));
        paramEntity.voiceUrl = paramCursor.getString(paramCursor.getColumnIndex("voiceUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShowCard"))) {
          break label4316;
        }
        paramBoolean = true;
        paramEntity.isShowCard = paramBoolean;
        paramEntity.updateTime = paramCursor.getLong(paramCursor.getColumnIndex("updateTime"));
        paramEntity.extendFriendFlag = paramCursor.getInt(paramCursor.getColumnIndex("extendFriendFlag"));
        paramEntity.extendFriendVoiceDuration = paramCursor.getInt(paramCursor.getColumnIndex("extendFriendVoiceDuration"));
        paramEntity.extendFriendEntryContact = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendEntryContact"));
        paramEntity.extendFriendEntryAddFriend = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendEntryAddFriend"));
        paramEntity.extendFriendQuestion = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendQuestion"));
        paramEntity.fontId = paramCursor.getInt(paramCursor.getColumnIndex("fontId"));
        paramEntity.fontType = paramCursor.getInt(paramCursor.getColumnIndex("fontType"));
        paramEntity.clothesId = paramCursor.getInt(paramCursor.getColumnIndex("clothesId"));
        paramEntity.schoolId = paramCursor.getString(paramCursor.getColumnIndex("schoolId"));
        paramEntity.schoolName = paramCursor.getString(paramCursor.getColumnIndex("schoolName"));
        paramEntity.authState = paramCursor.getLong(paramCursor.getColumnIndex("authState"));
        paramEntity.idx = paramCursor.getInt(paramCursor.getColumnIndex("idx"));
        paramEntity.category = paramCursor.getInt(paramCursor.getColumnIndex("category"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShowMiniPlaying"))) {
          break label4321;
        }
        paramBoolean = true;
        paramEntity.isShowMiniPlaying = paramBoolean;
        paramEntity.tabJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("tabJumpUrl"));
        paramEntity.guestJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("guestJumpUrl"));
        paramEntity.guestAppTotal = paramCursor.getInt(paramCursor.getColumnIndex("guestAppTotal"));
        paramEntity.defaultCardId = paramCursor.getInt(paramCursor.getColumnIndex("defaultCardId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("strangerVoteOpen"))) {
          break label4326;
        }
        paramBoolean = true;
        paramEntity.strangerVoteOpen = paramBoolean;
        paramEntity.lSuperVipTemplateId = paramCursor.getLong(paramCursor.getColumnIndex("lSuperVipTemplateId"));
        paramEntity.bBigClubVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bBigClubVipOpen")));
        paramEntity.iBigClubVipType = paramCursor.getInt(paramCursor.getColumnIndex("iBigClubVipType"));
        paramEntity.iBigClubVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iBigClubVipLevel"));
        paramEntity.lBigClubTemplateId = paramCursor.getLong(paramCursor.getColumnIndex("lBigClubTemplateId"));
        paramEntity.diyComplicatedInfo = paramCursor.getString(paramCursor.getColumnIndex("diyComplicatedInfo"));
        paramEntity.cardId = paramCursor.getLong(paramCursor.getColumnIndex("cardId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("strangerInviteMeGroupOpen"))) {
          break label4331;
        }
        paramBoolean = true;
        paramEntity.strangerInviteMeGroupOpen = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isPrettyGroupOwner"))) {
          break label4336;
        }
        paramBoolean = true;
        paramEntity.isPrettyGroupOwner = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isHidePrettyGroutIdentity"))) {
          break label4341;
        }
        paramBoolean = true;
        paramEntity.isHidePrettyGroutIdentity = paramBoolean;
        paramEntity.mQQLevelType = paramCursor.getInt(paramCursor.getColumnIndex("mQQLevelType"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("schoolVerifiedFlag"))) {
          break label4346;
        }
        paramBoolean = true;
        paramEntity.schoolVerifiedFlag = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("troopHonorSwitch"))) {
          break label4351;
        }
      }
      label4221:
      label4351:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.troopHonorSwitch = paramBoolean;
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label1387;
        paramBoolean = false;
        break label1873;
        paramBoolean = false;
        break label1899;
        paramBoolean = false;
        break label1925;
        paramBoolean = false;
        break label1951;
        paramBoolean = false;
        break label1977;
        paramBoolean = false;
        break label2003;
        paramBoolean = false;
        break label2029;
        paramBoolean = false;
        break label2074;
        paramBoolean = false;
        break label2100;
        paramBoolean = false;
        break label2145;
        paramBoolean = false;
        break label2171;
        paramBoolean = false;
        break label2539;
        paramBoolean = false;
        break label2565;
        paramBoolean = false;
        break label2591;
        paramBoolean = false;
        break label2731;
        paramBoolean = false;
        break label2757;
        paramBoolean = false;
        break label2783;
        paramBoolean = false;
        break label2999;
        paramBoolean = false;
        break label3215;
        paramBoolean = false;
        break label3526;
        paramBoolean = false;
        break label3818;
        paramBoolean = false;
        break label3920;
        paramBoolean = false;
        break label4080;
        paramBoolean = false;
        break label4106;
        paramBoolean = false;
        break label4132;
        paramBoolean = false;
        break label4177;
      }
    }
    label1873:
    label1899:
    label4336:
    label4341:
    int i = paramCursor.getColumnIndex("uin");
    label1925:
    label1951:
    label1977:
    label2003:
    label2145:
    label2539:
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("strNick");
      if (i != -1) {
        break label12113;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strNick", String.class));
      i = paramCursor.getColumnIndex("shGender");
      if (i != -1) {
        break label12128;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("shGender", Short.TYPE));
      label4461:
      i = paramCursor.getColumnIndex("shAge");
      if (i != -1) {
        break label12143;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("shAge", Short.TYPE));
      i = paramCursor.getColumnIndex("nFaceID");
      if (i != -1) {
        break label12158;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nFaceID", Integer.TYPE));
      i = paramCursor.getColumnIndex("strCertificationInfo");
      if (i != -1) {
        break label12173;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCertificationInfo", String.class));
      i = paramCursor.getColumnIndex("shType");
      if (i != -1) {
        break label12188;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("shType", Short.TYPE));
      label4601:
      i = paramCursor.getColumnIndex("vContent");
      if (i != -1) {
        break label12203;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vContent", [B.class));
      i = paramCursor.getColumnIndex("strSign");
      if (i != -1) {
        break label12218;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strSign", String.class));
      i = paramCursor.getColumnIndex("strCompany");
      if (i != -1) {
        break label12233;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCompany", String.class));
      i = paramCursor.getColumnIndex("strSchool");
      if (i != -1) {
        break label12248;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strSchool", String.class));
      i = paramCursor.getColumnIndex("uFaceTimeStamp");
      if (i != -1) {
        break label12263;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uFaceTimeStamp", Integer.TYPE));
      i = paramCursor.getColumnIndex("vQQFaceID");
      if (i != -1) {
        break label12278;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vQQFaceID", [B.class));
      i = paramCursor.getColumnIndex("strReMark");
      if (i != -1) {
        break label12293;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strReMark", String.class));
      label4846:
      i = paramCursor.getColumnIndex("bWeiboInfo");
      if (i != -1) {
        break label12308;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bWeiboInfo", Byte.TYPE));
      i = paramCursor.getColumnIndex("bQzoneInfo");
      if (i != -1) {
        break label12324;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bQzoneInfo", Byte.TYPE));
      i = paramCursor.getColumnIndex("nSameFriendsNum");
      if (i != -1) {
        break label12340;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nSameFriendsNum", Integer.TYPE));
      i = paramCursor.getColumnIndex("strCompanySame");
      if (i != -1) {
        break label12355;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCompanySame", String.class));
      label4986:
      i = paramCursor.getColumnIndex("strSchoolSame");
      if (i != -1) {
        break label12370;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strSchoolSame", String.class));
      i = paramCursor.getColumnIndex("lCardShowNum");
      if (i != -1) {
        break label12385;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lCardShowNum", Long.TYPE));
      i = paramCursor.getColumnIndex("bSingle");
      if (i != -1) {
        break label12400;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bSingle", Byte.TYPE));
      i = paramCursor.getColumnIndex("lVisitCount");
      if (i != -1) {
        break label12416;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lVisitCount", Long.TYPE));
      i = paramCursor.getColumnIndex("lVoteCount");
      if (i != -1) {
        break label12431;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lVoteCount", Long.TYPE));
      i = paramCursor.getColumnIndex("tagInfosByte");
      if (i != -1) {
        break label12446;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tagInfosByte", [B.class));
      i = paramCursor.getColumnIndex("eUserIdentityType");
      if (i != -1) {
        break label12461;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("eUserIdentityType", Byte.TYPE));
      label5231:
      i = paramCursor.getColumnIndex("vBackground");
      if (i != -1) {
        break label12477;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vBackground", [B.class));
      i = paramCursor.getColumnIndex("labelInfoBytes");
      if (i != -1) {
        break label12492;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("labelInfoBytes", [B.class));
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label12507;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("age", Byte.TYPE));
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label12523;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("constellation", Integer.TYPE));
      label5371:
      i = paramCursor.getColumnIndex("pyFaceUrl");
      if (i != -1) {
        break label12538;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pyFaceUrl", String.class));
      i = paramCursor.getColumnIndex("location");
      if (i != -1) {
        break label12553;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("location", String.class));
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label12568;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bVoted", Byte.TYPE));
      i = paramCursor.getColumnIndex("bFavorited");
      if (i != -1) {
        break label12584;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bFavorited", Byte.TYPE));
      i = paramCursor.getColumnIndex("iVoteIncrement");
      if (i != -1) {
        break label12600;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iVoteIncrement", Integer.TYPE));
      i = paramCursor.getColumnIndex("strJoinHexAlbumFileKey");
      if (i != -1) {
        break label12615;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strJoinHexAlbumFileKey", String.class));
      i = paramCursor.getColumnIndex("iFaceNum");
      if (i != -1) {
        break label12630;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iFaceNum", Integer.TYPE));
      label5616:
      i = paramCursor.getColumnIndex("cSqqLevel");
      if (i != -1) {
        break label12645;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cSqqLevel", Byte.TYPE));
      i = paramCursor.getColumnIndex("iQQLevel");
      if (i != -1) {
        break label12661;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iQQLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("uCurMulType");
      if (i != -1) {
        break label12676;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uCurMulType", Long.TYPE));
      i = paramCursor.getColumnIndex("strProvince");
      if (i != -1) {
        break label12691;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strProvince", String.class));
      label5756:
      i = paramCursor.getColumnIndex("strCity");
      if (i != -1) {
        break label12706;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCity", String.class));
      i = paramCursor.getColumnIndex("strCountry");
      if (i != -1) {
        break label12721;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCountry", String.class));
      i = paramCursor.getColumnIndex("lBirthday");
      if (i != -1) {
        break label12736;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lBirthday", Long.TYPE));
      i = paramCursor.getColumnIndex("strLocationCodes");
      if (i != -1) {
        break label12751;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strLocationCodes", String.class));
      i = paramCursor.getColumnIndex("strLocationDesc");
      if (i != -1) {
        break label12766;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strLocationDesc", String.class));
      i = paramCursor.getColumnIndex("strHometownCodes");
      if (i != -1) {
        break label12781;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strHometownCodes", String.class));
      i = paramCursor.getColumnIndex("strHometownDesc");
      if (i != -1) {
        break label12796;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strHometownDesc", String.class));
      label6001:
      i = paramCursor.getColumnIndex("strHometownCountry");
      if (i != -1) {
        break label12811;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strHometownCountry", String.class));
      i = paramCursor.getColumnIndex("strHometownProvince");
      if (i != -1) {
        break label12826;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strHometownProvince", String.class));
      i = paramCursor.getColumnIndex("strHometownCity");
      if (i != -1) {
        break label12841;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strHometownCity", String.class));
      i = paramCursor.getColumnIndex("strEmail");
      if (i != -1) {
        break label12856;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strEmail", String.class));
      label6141:
      i = paramCursor.getColumnIndex("strPersonalNote");
      if (i != -1) {
        break label12871;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strPersonalNote", String.class));
      i = paramCursor.getColumnIndex("iProfession");
      if (i != -1) {
        break label12886;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iProfession", Integer.TYPE));
      i = paramCursor.getColumnIndex("bindPhoneInfo");
      if (i != -1) {
        break label12901;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bindPhoneInfo", String.class));
      i = paramCursor.getColumnIndex("bCardInfo");
      if (i != -1) {
        break label12916;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bCardInfo", [B.class));
      i = paramCursor.getColumnIndex("strTroopName");
      if (i != -1) {
        break label12931;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strTroopName", String.class));
      i = paramCursor.getColumnIndex("strTroopNick");
      if (i != -1) {
        break label12946;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strTroopNick", String.class));
      i = paramCursor.getColumnIndex("strMobile");
      if (i != -1) {
        break label12961;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strMobile", String.class));
      label6398:
      i = paramCursor.getColumnIndex("strContactName");
      if (i != -1) {
        break label12976;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strContactName", String.class));
      i = paramCursor.getColumnIndex("ulShowControl");
      if (i != -1) {
        break label12991;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ulShowControl", Integer.TYPE));
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label13006;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("feedPreviewTime", Long.TYPE));
      label6509:
      i = paramCursor.getColumnIndex("strQzoneFeedsDesc");
      if (i != -1) {
        break label13021;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strQzoneFeedsDesc", String.class));
      i = paramCursor.getColumnIndex("StrPresentDesc");
      if (i != -1) {
        break label13036;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("StrPresentDesc", String.class));
      i = paramCursor.getColumnIndex("strSpaceName");
      if (i != -1) {
        break label13051;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strSpaceName", String.class));
      i = paramCursor.getColumnIndex("strQzoneHeader");
      if (i != -1) {
        break label13066;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strQzoneHeader", String.class));
      i = paramCursor.getColumnIndex("vQzonePhotos");
      if (i != -1) {
        break label13081;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vQzonePhotos", [B.class));
      i = paramCursor.getColumnIndex("vQzoneCoverInfo");
      if (i != -1) {
        break label13096;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vQzoneCoverInfo", [B.class));
      i = paramCursor.getColumnIndex("enlargeQzonePic");
      if (i != -1) {
        break label13111;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("enlargeQzonePic", Integer.TYPE));
      label6768:
      i = paramCursor.getColumnIndex("showPublishButton");
      if (i != -1) {
        break label13126;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showPublishButton", Boolean.TYPE));
      i = paramCursor.getColumnIndex("strStatus");
      if (i != -1) {
        break label13153;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strStatus", String.class));
      i = paramCursor.getColumnIndex("strAutoRemark");
      if (i != -1) {
        break label13168;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strAutoRemark", String.class));
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label13183;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vSeed", [B.class));
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label13198;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vCookies", [B.class));
      i = paramCursor.getColumnIndex("hasFakeData");
      if (i != -1) {
        break label13213;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasFakeData", Boolean.TYPE));
      i = paramCursor.getColumnIndex("bQQVipOpen");
      if (i != -1) {
        break label13240;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bQQVipOpen", Byte.TYPE));
      label7027:
      i = paramCursor.getColumnIndex("iQQVipType");
      if (i != -1) {
        break label13256;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iQQVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iQQVipLevel");
      if (i != -1) {
        break label13271;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iQQVipLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("nameplateVipType");
      if (i != -1) {
        break label13286;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nameplateVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("grayNameplateFlag");
      if (i != -1) {
        break label13301;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("grayNameplateFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("bSuperVipOpen");
      if (i != -1) {
        break label13316;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bSuperVipOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iSuperVipType");
      if (i != -1) {
        break label13332;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iSuperVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iSuperVipLevel");
      if (i != -1) {
        break label13347;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iSuperVipLevel", Integer.TYPE));
      label7286:
      i = paramCursor.getColumnIndex("bSuperQQOpen");
      if (i != -1) {
        break label13362;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bSuperQQOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iSuperQQType");
      if (i != -1) {
        break label13378;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iSuperQQType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iSuperQQLevel");
      if (i != -1) {
        break label13393;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iSuperQQLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("bHollywoodVipOpen");
      if (i != -1) {
        break label13408;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bHollywoodVipOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iHollywoodVipType");
      if (i != -1) {
        break label13424;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iHollywoodVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iHollywoodVipLevel");
      if (i != -1) {
        break label13439;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iHollywoodVipLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("strShowName");
      if (i != -1) {
        break label13454;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strShowName", String.class));
      label7545:
      i = paramCursor.getColumnIndex("vRichSign");
      if (i != -1) {
        break label13469;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vRichSign", [B.class));
      i = paramCursor.getColumnIndex("lSignModifyTime");
      if (i != -1) {
        break label13484;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lSignModifyTime", Long.TYPE));
      i = paramCursor.getColumnIndex("vLongNickTopicInfo");
      if (i != -1) {
        break label13499;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vLongNickTopicInfo", [B.class));
      i = paramCursor.getColumnIndex("lUserFlag");
      if (i != -1) {
        break label13514;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lUserFlag", Long.TYPE));
      i = paramCursor.getColumnIndex("lLoginDays");
      if (i != -1) {
        break label13529;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lLoginDays", Long.TYPE));
      i = paramCursor.getColumnIndex("strLoginDaysDesc");
      if (i != -1) {
        break label13544;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strLoginDaysDesc", String.class));
      i = paramCursor.getColumnIndex("lQQMasterLogindays");
      if (i != -1) {
        break label13559;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lQQMasterLogindays", Long.TYPE));
      label7804:
      i = paramCursor.getColumnIndex("iXManScene1DelayTime");
      if (i != -1) {
        break label13574;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iXManScene1DelayTime", Integer.TYPE));
      i = paramCursor.getColumnIndex("iXManScene2DelayTime");
      if (i != -1) {
        break label13589;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iXManScene2DelayTime", Integer.TYPE));
      i = paramCursor.getColumnIndex("allowPeopleSee");
      if (i != -1) {
        break label13604;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowPeopleSee", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowCalInteractive");
      if (i != -1) {
        break label13631;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowCalInteractive", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showOnlineFriends");
      if (i != -1) {
        break label13658;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showOnlineFriends", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowClick");
      if (i != -1) {
        break label13685;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowClick", Boolean.TYPE));
      i = paramCursor.getColumnIndex("babyQSwitch");
      if (i != -1) {
        break label13712;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("babyQSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isSuperRedDiamond");
      if (i != -1) {
        break label13739;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isSuperRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRedDiamond");
      if (i != -1) {
        break label13766;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("redLevel");
      if (i != -1) {
        break label13793;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("redLevel", Integer.TYPE));
      label8174:
      i = paramCursor.getColumnIndex("isSuperYellowDiamond");
      if (i != -1) {
        break label13808;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isSuperYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isYellowDiamond");
      if (i != -1) {
        break label13835;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("yellowLevel");
      if (i != -1) {
        break label13862;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("yellowLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("isSuperGreenDiamond");
      if (i != -1) {
        break label13877;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isSuperGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isGreenDiamond");
      if (i != -1) {
        break label13904;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("greenLevel");
      if (i != -1) {
        break label13931;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("greenLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("templateRet");
      if (i != -1) {
        break label13946;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("templateRet", Integer.TYPE));
      label8433:
      i = paramCursor.getColumnIndex("lCurrentStyleId");
      if (i != -1) {
        break label13961;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lCurrentStyleId", Long.TYPE));
      i = paramCursor.getColumnIndex("lCurrentBgId");
      if (i != -1) {
        break label13976;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lCurrentBgId", Long.TYPE));
      i = paramCursor.getColumnIndex("backgroundUrl");
      if (i != -1) {
        break label13991;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("backgroundUrl", String.class));
      i = paramCursor.getColumnIndex("backgroundColor");
      if (i != -1) {
        break label14006;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("backgroundColor", Long.TYPE));
      i = paramCursor.getColumnIndex("dynamicCardFlag");
      if (i != -1) {
        break label14021;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dynamicCardFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("strZipUrl");
      if (i != -1) {
        break label14036;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strZipUrl", String.class));
      i = paramCursor.getColumnIndex("strActiveUrl");
      if (i != -1) {
        break label14051;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strActiveUrl", String.class));
      label8692:
      i = paramCursor.getColumnIndex("strDrawerCardUrl");
      if (i != -1) {
        break label14066;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strDrawerCardUrl", String.class));
      i = paramCursor.getColumnIndex("strWzryHeroUrl");
      if (i != -1) {
        break label14081;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strWzryHeroUrl", String.class));
      i = paramCursor.getColumnIndex("wzryHonorInfo");
      if (i != -1) {
        break label14096;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wzryHonorInfo", [B.class));
      i = paramCursor.getColumnIndex("strExtInfo");
      if (i != -1) {
        break label14111;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strExtInfo", String.class));
      i = paramCursor.getColumnIndex("strCurrentBgUrl");
      if (i != -1) {
        break label14126;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCurrentBgUrl", String.class));
      i = paramCursor.getColumnIndex("bgType");
      if (i != -1) {
        break label14141;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bgType", [B.class));
      i = paramCursor.getColumnIndex("encId");
      if (i != -1) {
        break label14156;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("encId", String.class));
      label8951:
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label14171;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("busiEntry", String.class));
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label14186;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("favoriteSource", Integer.TYPE));
      i = paramCursor.getColumnIndex("visibleMusicPendant");
      if (i != -1) {
        break label14201;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("visibleMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("autoPlayMusicPendant");
      if (i != -1) {
        break label14228;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("autoPlayMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showRedPointMusicPendant");
      if (i != -1) {
        break label14255;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showRedPointMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("privilegePromptStr");
      if (i != -1) {
        break label14282;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("privilegePromptStr", String.class));
      i = paramCursor.getColumnIndex("privilegeJumpUrl");
      if (i != -1) {
        break label14297;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("privilegeJumpUrl", String.class));
      label9210:
      i = paramCursor.getColumnIndex("vOpenPriv");
      if (i != -1) {
        break label14312;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vOpenPriv", [B.class));
      i = paramCursor.getColumnIndex("vClosePriv");
      if (i != -1) {
        break label14327;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vClosePriv", [B.class));
      i = paramCursor.getColumnIndex("presentDesc");
      if (i != -1) {
        break label14342;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("presentDesc", String.class));
      i = paramCursor.getColumnIndex("presentCustourl");
      if (i != -1) {
        break label14357;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("presentCustourl", String.class));
      i = paramCursor.getColumnIndex("presentSwitch");
      if (i != -1) {
        break label14372;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("presentSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showPresent");
      if (i != -1) {
        break label14399;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showPresent", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showMusicBox");
      if (i != -1) {
        break label14426;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showMusicBox", Boolean.TYPE));
      i = paramCursor.getColumnIndex("addSrcName");
      if (i != -1) {
        break label14453;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("addSrcName", String.class));
      i = paramCursor.getColumnIndex("addSrcId");
      if (i != -1) {
        break label14468;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("addSrcId", Long.TYPE));
      i = paramCursor.getColumnIndex("addSubSrcId");
      if (i != -1) {
        break label14483;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("addSubSrcId", Long.TYPE));
      label9580:
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label14498;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strVoteLimitedNotice", String.class));
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label14513;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label14528;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      i = paramCursor.getColumnIndex("mNowShowFlag");
      if (i != -1) {
        break label14543;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mNowShowFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("mNowShowIconUrl");
      if (i != -1) {
        break label14558;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mNowShowIconUrl", String.class));
      i = paramCursor.getColumnIndex("mNowShowJumpUrl");
      if (i != -1) {
        break label14573;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mNowShowJumpUrl", String.class));
      i = paramCursor.getColumnIndex("vCoverInfo");
      if (i != -1) {
        break label14588;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vCoverInfo", [B.class));
      label9839:
      i = paramCursor.getColumnIndex("medalSwitchDisable");
      if (i != -1) {
        break label14603;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("medalSwitchDisable", Boolean.TYPE));
      i = paramCursor.getColumnIndex("iMedalCount");
      if (i != -1) {
        break label14630;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iMedalCount", Integer.TYPE));
      i = paramCursor.getColumnIndex("iNewCount");
      if (i != -1) {
        break label14645;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iNewCount", Integer.TYPE));
      i = paramCursor.getColumnIndex("iUpgradeCount");
      if (i != -1) {
        break label14660;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iUpgradeCount", Integer.TYPE));
      i = paramCursor.getColumnIndex("strPromptParams");
      if (i != -1) {
        break label14675;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strPromptParams", String.class));
      i = paramCursor.getColumnIndex("hobbyEntry");
      if (i != -1) {
        break label14690;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hobbyEntry", String.class));
      i = paramCursor.getColumnIndex("lastPraiseInfoList");
      if (i != -1) {
        break label14705;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastPraiseInfoList", [B.class));
      label10098:
      i = paramCursor.getColumnIndex("tempChatSig");
      if (i != -1) {
        break label14720;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tempChatSig", [B.class));
      i = paramCursor.getColumnIndex("namePlateOfKingGameId");
      if (i != -1) {
        break label14735;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingGameId", Long.TYPE));
      i = paramCursor.getColumnIndex("namePlateOfKingLoginTime");
      if (i != -1) {
        break label14750;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingLoginTime", Long.TYPE));
      i = paramCursor.getColumnIndex("namePlateOfKingDan");
      if (i != -1) {
        break label14765;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingDan", Integer.TYPE));
      i = paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch");
      if (i != -1) {
        break label14780;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingDanDisplatSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("vPersonalityLabelV2");
      if (i != -1) {
        break label14807;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vPersonalityLabelV2", [B.class));
      i = paramCursor.getColumnIndex("cardType");
      if (i != -1) {
        break label14822;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cardType", Integer.TYPE));
      label10357:
      i = paramCursor.getColumnIndex("diyText");
      if (i != -1) {
        break label14837;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyText", String.class));
      i = paramCursor.getColumnIndex("diyTextFontId");
      if (i != -1) {
        break label14852;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextFontId", Integer.TYPE));
      i = paramCursor.getColumnIndex("diyTextWidth");
      if (i != -1) {
        break label14867;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextWidth", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextHeight");
      if (i != -1) {
        break label14882;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextHeight", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextLocX");
      if (i != -1) {
        break label14897;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextLocX", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextLocY");
      if (i != -1) {
        break label14912;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextLocY", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextDegree");
      if (i != -1) {
        break label14927;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextDegree", Float.TYPE));
      label10616:
      i = paramCursor.getColumnIndex("diyTextScale");
      if (i != -1) {
        break label14942;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextScale", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextTransparency");
      if (i != -1) {
        break label14957;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextTransparency", Float.TYPE));
      i = paramCursor.getColumnIndex("diyDefaultText");
      if (i != -1) {
        break label14972;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyDefaultText", String.class));
      i = paramCursor.getColumnIndex("popularity");
      if (i != -1) {
        break label14987;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("popularity", Integer.TYPE));
      i = paramCursor.getColumnIndex("declaration");
      if (i != -1) {
        break label15002;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("declaration", String.class));
      i = paramCursor.getColumnIndex("voiceUrl");
      if (i != -1) {
        break label15017;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("voiceUrl", String.class));
      i = paramCursor.getColumnIndex("isShowCard");
      if (i != -1) {
        break label15032;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isShowCard", Boolean.TYPE));
      i = paramCursor.getColumnIndex("updateTime");
      if (i != -1) {
        break label15059;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("updateTime", Long.TYPE));
      i = paramCursor.getColumnIndex("extendFriendFlag");
      if (i != -1) {
        break label15074;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendFriendFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("extendFriendVoiceDuration");
      if (i != -1) {
        break label15089;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendFriendVoiceDuration", Integer.TYPE));
      i = paramCursor.getColumnIndex("extendFriendEntryContact");
      if (i != -1) {
        break label15104;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendFriendEntryContact", Short.TYPE));
      i = paramCursor.getColumnIndex("extendFriendEntryAddFriend");
      if (i != -1) {
        break label15119;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendFriendEntryAddFriend", Short.TYPE));
      i = paramCursor.getColumnIndex("extendFriendQuestion");
      if (i != -1) {
        break label15134;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendFriendQuestion", Short.TYPE));
      i = paramCursor.getColumnIndex("fontId");
      if (i != -1) {
        break label15149;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("fontId", Integer.TYPE));
      label11134:
      i = paramCursor.getColumnIndex("fontType");
      if (i != -1) {
        break label15164;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("fontType", Integer.TYPE));
      i = paramCursor.getColumnIndex("clothesId");
      if (i != -1) {
        break label15179;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("clothesId", Integer.TYPE));
      i = paramCursor.getColumnIndex("schoolId");
      if (i != -1) {
        break label15194;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("schoolId", String.class));
      label11245:
      i = paramCursor.getColumnIndex("schoolName");
      if (i != -1) {
        break label15209;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("schoolName", String.class));
      i = paramCursor.getColumnIndex("authState");
      if (i != -1) {
        break label15224;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("authState", Long.TYPE));
      i = paramCursor.getColumnIndex("idx");
      if (i != -1) {
        break label15239;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("idx", Integer.TYPE));
      i = paramCursor.getColumnIndex("category");
      if (i != -1) {
        break label15254;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("category", Integer.TYPE));
      i = paramCursor.getColumnIndex("isShowMiniPlaying");
      if (i != -1) {
        break label15269;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isShowMiniPlaying", Boolean.TYPE));
      i = paramCursor.getColumnIndex("tabJumpUrl");
      if (i != -1) {
        break label15296;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tabJumpUrl", String.class));
      i = paramCursor.getColumnIndex("guestJumpUrl");
      if (i != -1) {
        break label15311;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guestJumpUrl", String.class));
      label11504:
      i = paramCursor.getColumnIndex("guestAppTotal");
      if (i != -1) {
        break label15326;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guestAppTotal", Integer.TYPE));
      i = paramCursor.getColumnIndex("defaultCardId");
      if (i != -1) {
        break label15341;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("defaultCardId", Integer.TYPE));
      i = paramCursor.getColumnIndex("strangerVoteOpen");
      if (i != -1) {
        break label15356;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strangerVoteOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("lSuperVipTemplateId");
      if (i != -1) {
        break label15383;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lSuperVipTemplateId", Long.TYPE));
      i = paramCursor.getColumnIndex("bBigClubVipOpen");
      if (i != -1) {
        break label15398;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bBigClubVipOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iBigClubVipType");
      if (i != -1) {
        break label15414;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iBigClubVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iBigClubVipLevel");
      if (i != -1) {
        break label15429;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iBigClubVipLevel", Integer.TYPE));
      label11763:
      i = paramCursor.getColumnIndex("lBigClubTemplateId");
      if (i != -1) {
        break label15444;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lBigClubTemplateId", Long.TYPE));
      i = paramCursor.getColumnIndex("diyComplicatedInfo");
      if (i != -1) {
        break label15459;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyComplicatedInfo", String.class));
      i = paramCursor.getColumnIndex("cardId");
      if (i != -1) {
        break label15474;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cardId", Long.TYPE));
      i = paramCursor.getColumnIndex("strangerInviteMeGroupOpen");
      if (i != -1) {
        break label15489;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strangerInviteMeGroupOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isPrettyGroupOwner");
      if (i != -1) {
        break label15516;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isPrettyGroupOwner", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isHidePrettyGroutIdentity");
      if (i != -1) {
        break label15543;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isHidePrettyGroutIdentity", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mQQLevelType");
      if (i != -1) {
        break label15570;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mQQLevelType", Integer.TYPE));
    }
    for (;;)
    {
      label2074:
      label2100:
      label2757:
      label2783:
      label3818:
      label4331:
      i = paramCursor.getColumnIndex("schoolVerifiedFlag");
      label2565:
      label2591:
      label2731:
      label2999:
      label3526:
      label3920:
      label4177:
      label4306:
      label4311:
      label4316:
      label4321:
      label4326:
      label6250:
      if (i != -1) {
        break label15585;
      }
      label3215:
      label4132:
      label4261:
      label4266:
      label4271:
      label4276:
      label4281:
      label4286:
      label4291:
      label4296:
      label4301:
      label4566:
      label4706:
      label5091:
      label5476:
      label5861:
      label7656:
      label9321:
      label10986:
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("schoolVerifiedFlag", Boolean.TYPE));
      label4106:
      label4236:
      label4241:
      label4246:
      label4251:
      label4256:
      label4426:
      label4811:
      label4951:
      label5336:
      label5721:
      label6106:
      label6620:
      label6879:
      label7138:
      label7397:
      label10727:
      i = paramCursor.getColumnIndex("troopHonorSwitch");
      label4226:
      label4231:
      label4496:
      label4531:
      label4671:
      label5056:
      label5196:
      label5581:
      label5966:
      label6361:
      label8285:
      label8544:
      label8803:
      label10468:
      if (i != -1) {
        break label15612;
      }
      label4636:
      label4776:
      label4916:
      label5301:
      label5441:
      label5826:
      label6213:
      label6472:
      label6731:
      label7249:
      label7508:
      label7767:
      label9691:
      label9950:
      label10209:
      label11874:
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopHonorSwitch", Boolean.TYPE));
      label4741:
      label4881:
      label5021:
      label5161:
      label5546:
      label5686:
      label6071:
      label6842:
      label7101:
      label7360:
      label7619:
      label7878:
      label8396:
      label8655:
      label8914:
      label9173:
      label10838:
      label11097:
      label11356:
      return paramEntity;
      label5126:
      label5266:
      label5406:
      label5791:
      label5931:
      label6324:
      label6583:
      label8507:
      label8766:
      label9025:
      label9284:
      label9543:
      label9802:
      label10061:
      label10320:
      label10579:
      paramEntity.uin = paramCursor.getString(i);
      label5511:
      label5651:
      label6036:
      label6176:
      label6435:
      label6694:
      label6953:
      label7212:
      label7471:
      label7730:
      label9654:
      label9913:
      label10172:
      label10431:
      label10690:
      label10949:
      label11208:
      label11467:
      label11726:
      break;
      label5896:
      label6287:
      label6546:
      label7064:
      label7323:
      label7582:
      label7841:
      label8618:
      label8877:
      label10542:
      label10801:
      label11060:
      label11319:
      label11578:
      label11837:
      label12113:
      paramEntity.strNick = paramCursor.getString(i);
      label6657:
      label6916:
      label7175:
      label7434:
      label7693:
      label8470:
      label8729:
      label8988:
      label9247:
      label9506:
      label9765:
      label10024:
      label11689:
      break label4426;
      label8581:
      label8840:
      label9358:
      label9617:
      label10135:
      label10394:
      label10653:
      label10912:
      label11171:
      label12128:
      paramEntity.shGender = paramCursor.getShort(i);
      label9728:
      label9987:
      label10246:
      label10505:
      label10764:
      label11023:
      label11282:
      label11541:
      label11800:
      break label4461;
      label11393:
      label11652:
      label12143:
      paramEntity.shAge = paramCursor.getShort(i);
      break label4496;
      label12158:
      paramEntity.nFaceID = paramCursor.getInt(i);
      break label4531;
      label12173:
      paramEntity.strCertificationInfo = paramCursor.getString(i);
      break label4566;
      label12188:
      paramEntity.shType = paramCursor.getShort(i);
      break label4601;
      label12203:
      paramEntity.vContent = paramCursor.getBlob(i);
      break label4636;
      label12218:
      paramEntity.strSign = paramCursor.getString(i);
      break label4671;
      label12233:
      paramEntity.strCompany = paramCursor.getString(i);
      break label4706;
      label12248:
      paramEntity.strSchool = paramCursor.getString(i);
      break label4741;
      label12263:
      paramEntity.uFaceTimeStamp = paramCursor.getInt(i);
      break label4776;
      label12278:
      paramEntity.vQQFaceID = paramCursor.getBlob(i);
      break label4811;
      label12293:
      paramEntity.strReMark = paramCursor.getString(i);
      break label4846;
      label12308:
      paramEntity.bWeiboInfo = ((byte)paramCursor.getShort(i));
      break label4881;
      label12324:
      paramEntity.bQzoneInfo = ((byte)paramCursor.getShort(i));
      break label4916;
      label12340:
      paramEntity.nSameFriendsNum = paramCursor.getInt(i);
      break label4951;
      label12355:
      paramEntity.strCompanySame = paramCursor.getString(i);
      break label4986;
      label12370:
      paramEntity.strSchoolSame = paramCursor.getString(i);
      break label5021;
      label12385:
      paramEntity.lCardShowNum = paramCursor.getLong(i);
      break label5056;
      label12400:
      paramEntity.bSingle = ((byte)paramCursor.getShort(i));
      break label5091;
      label12416:
      paramEntity.lVisitCount = paramCursor.getLong(i);
      break label5126;
      label12431:
      paramEntity.lVoteCount = paramCursor.getLong(i);
      break label5161;
      label12446:
      paramEntity.tagInfosByte = paramCursor.getBlob(i);
      break label5196;
      label12461:
      paramEntity.eUserIdentityType = ((byte)paramCursor.getShort(i));
      break label5231;
      label12477:
      paramEntity.vBackground = paramCursor.getBlob(i);
      break label5266;
      label12492:
      paramEntity.labelInfoBytes = paramCursor.getBlob(i);
      break label5301;
      label12507:
      paramEntity.age = ((byte)paramCursor.getShort(i));
      break label5336;
      label12523:
      paramEntity.constellation = paramCursor.getInt(i);
      break label5371;
      label12538:
      paramEntity.pyFaceUrl = paramCursor.getString(i);
      break label5406;
      label12553:
      paramEntity.location = paramCursor.getString(i);
      break label5441;
      label12568:
      paramEntity.bVoted = ((byte)paramCursor.getShort(i));
      break label5476;
      label12584:
      paramEntity.bFavorited = ((byte)paramCursor.getShort(i));
      break label5511;
      label12600:
      paramEntity.iVoteIncrement = paramCursor.getInt(i);
      break label5546;
      label12615:
      paramEntity.strJoinHexAlbumFileKey = paramCursor.getString(i);
      break label5581;
      label12630:
      paramEntity.iFaceNum = paramCursor.getInt(i);
      break label5616;
      label12645:
      paramEntity.cSqqLevel = ((byte)paramCursor.getShort(i));
      break label5651;
      label12661:
      paramEntity.iQQLevel = paramCursor.getInt(i);
      break label5686;
      label12676:
      paramEntity.uCurMulType = paramCursor.getLong(i);
      break label5721;
      label12691:
      paramEntity.strProvince = paramCursor.getString(i);
      break label5756;
      label12706:
      paramEntity.strCity = paramCursor.getString(i);
      break label5791;
      label12721:
      paramEntity.strCountry = paramCursor.getString(i);
      break label5826;
      label12736:
      paramEntity.lBirthday = paramCursor.getLong(i);
      break label5861;
      label12751:
      paramEntity.strLocationCodes = paramCursor.getString(i);
      break label5896;
      label12766:
      paramEntity.strLocationDesc = paramCursor.getString(i);
      break label5931;
      label12781:
      paramEntity.strHometownCodes = paramCursor.getString(i);
      break label5966;
      label12796:
      paramEntity.strHometownDesc = paramCursor.getString(i);
      break label6001;
      label12811:
      paramEntity.strHometownCountry = paramCursor.getString(i);
      break label6036;
      label12826:
      paramEntity.strHometownProvince = paramCursor.getString(i);
      break label6071;
      label12841:
      paramEntity.strHometownCity = paramCursor.getString(i);
      break label6106;
      label12856:
      paramEntity.strEmail = paramCursor.getString(i);
      break label6141;
      label12871:
      paramEntity.strPersonalNote = paramCursor.getString(i);
      break label6176;
      label12886:
      paramEntity.iProfession = paramCursor.getInt(i);
      break label6213;
      label12901:
      paramEntity.bindPhoneInfo = paramCursor.getString(i);
      break label6250;
      label12916:
      paramEntity.bCardInfo = paramCursor.getBlob(i);
      break label6287;
      label12931:
      paramEntity.strTroopName = paramCursor.getString(i);
      break label6324;
      label12946:
      paramEntity.strTroopNick = paramCursor.getString(i);
      break label6361;
      label12961:
      paramEntity.strMobile = paramCursor.getString(i);
      break label6398;
      label12976:
      paramEntity.strContactName = paramCursor.getString(i);
      break label6435;
      label12991:
      paramEntity.ulShowControl = paramCursor.getInt(i);
      break label6472;
      label13006:
      paramEntity.feedPreviewTime = paramCursor.getLong(i);
      break label6509;
      label13021:
      paramEntity.strQzoneFeedsDesc = paramCursor.getString(i);
      break label6546;
      label13036:
      paramEntity.StrPresentDesc = paramCursor.getString(i);
      break label6583;
      label13051:
      paramEntity.strSpaceName = paramCursor.getString(i);
      break label6620;
      label13066:
      paramEntity.strQzoneHeader = paramCursor.getString(i);
      break label6657;
      label13081:
      paramEntity.vQzonePhotos = paramCursor.getBlob(i);
      break label6694;
      label13096:
      paramEntity.vQzoneCoverInfo = paramCursor.getBlob(i);
      break label6731;
      label13111:
      paramEntity.enlargeQzonePic = paramCursor.getInt(i);
      break label6768;
      label13126:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showPublishButton = paramBoolean;
        break;
      }
      label13153:
      paramEntity.strStatus = paramCursor.getString(i);
      break label6842;
      label13168:
      paramEntity.strAutoRemark = paramCursor.getString(i);
      break label6879;
      label13183:
      paramEntity.vSeed = paramCursor.getBlob(i);
      break label6916;
      label13198:
      paramEntity.vCookies = paramCursor.getBlob(i);
      break label6953;
      label13213:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasFakeData = paramBoolean;
        break;
      }
      label13240:
      paramEntity.bQQVipOpen = ((byte)paramCursor.getShort(i));
      break label7027;
      label13256:
      paramEntity.iQQVipType = paramCursor.getInt(i);
      break label7064;
      label13271:
      paramEntity.iQQVipLevel = paramCursor.getInt(i);
      break label7101;
      label13286:
      paramEntity.nameplateVipType = paramCursor.getInt(i);
      break label7138;
      label13301:
      paramEntity.grayNameplateFlag = paramCursor.getInt(i);
      break label7175;
      label13316:
      paramEntity.bSuperVipOpen = ((byte)paramCursor.getShort(i));
      break label7212;
      label13332:
      paramEntity.iSuperVipType = paramCursor.getInt(i);
      break label7249;
      label13347:
      paramEntity.iSuperVipLevel = paramCursor.getInt(i);
      break label7286;
      label13362:
      paramEntity.bSuperQQOpen = ((byte)paramCursor.getShort(i));
      break label7323;
      label13378:
      paramEntity.iSuperQQType = paramCursor.getInt(i);
      break label7360;
      label13393:
      paramEntity.iSuperQQLevel = paramCursor.getInt(i);
      break label7397;
      label13408:
      paramEntity.bHollywoodVipOpen = ((byte)paramCursor.getShort(i));
      break label7434;
      label13424:
      paramEntity.iHollywoodVipType = paramCursor.getInt(i);
      break label7471;
      label13439:
      paramEntity.iHollywoodVipLevel = paramCursor.getInt(i);
      break label7508;
      label13454:
      paramEntity.strShowName = paramCursor.getString(i);
      break label7545;
      label13469:
      paramEntity.vRichSign = paramCursor.getBlob(i);
      break label7582;
      label13484:
      paramEntity.lSignModifyTime = paramCursor.getLong(i);
      break label7619;
      label13499:
      paramEntity.vLongNickTopicInfo = paramCursor.getBlob(i);
      break label7656;
      label13514:
      paramEntity.lUserFlag = paramCursor.getLong(i);
      break label7693;
      label13529:
      paramEntity.lLoginDays = paramCursor.getLong(i);
      break label7730;
      label13544:
      paramEntity.strLoginDaysDesc = paramCursor.getString(i);
      break label7767;
      label13559:
      paramEntity.lQQMasterLogindays = paramCursor.getLong(i);
      break label7804;
      label13574:
      paramEntity.iXManScene1DelayTime = paramCursor.getInt(i);
      break label7841;
      label13589:
      paramEntity.iXManScene2DelayTime = paramCursor.getInt(i);
      break label7878;
      label13604:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowPeopleSee = paramBoolean;
        break;
      }
      label13631:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowCalInteractive = paramBoolean;
        break;
      }
      label13658:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showOnlineFriends = paramBoolean;
        break;
      }
      label13685:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowClick = paramBoolean;
        break;
      }
      label13712:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.babyQSwitch = paramBoolean;
        break;
      }
      label13739:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperRedDiamond = paramBoolean;
        break;
      }
      label13766:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isRedDiamond = paramBoolean;
        break;
      }
      label13793:
      paramEntity.redLevel = paramCursor.getInt(i);
      break label8174;
      label13808:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperYellowDiamond = paramBoolean;
        break;
      }
      label13835:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isYellowDiamond = paramBoolean;
        break;
      }
      label13862:
      paramEntity.yellowLevel = paramCursor.getInt(i);
      break label8285;
      label13877:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperGreenDiamond = paramBoolean;
        break;
      }
      label13904:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isGreenDiamond = paramBoolean;
        break;
      }
      label13931:
      paramEntity.greenLevel = paramCursor.getInt(i);
      break label8396;
      label13946:
      paramEntity.templateRet = paramCursor.getInt(i);
      break label8433;
      label13961:
      paramEntity.lCurrentStyleId = paramCursor.getLong(i);
      break label8470;
      label13976:
      paramEntity.lCurrentBgId = paramCursor.getLong(i);
      break label8507;
      label13991:
      paramEntity.backgroundUrl = paramCursor.getString(i);
      break label8544;
      label14006:
      paramEntity.backgroundColor = paramCursor.getLong(i);
      break label8581;
      label14021:
      paramEntity.dynamicCardFlag = paramCursor.getInt(i);
      break label8618;
      label14036:
      paramEntity.strZipUrl = paramCursor.getString(i);
      break label8655;
      label14051:
      paramEntity.strActiveUrl = paramCursor.getString(i);
      break label8692;
      label14066:
      paramEntity.strDrawerCardUrl = paramCursor.getString(i);
      break label8729;
      label14081:
      paramEntity.strWzryHeroUrl = paramCursor.getString(i);
      break label8766;
      label14096:
      paramEntity.wzryHonorInfo = paramCursor.getBlob(i);
      break label8803;
      label14111:
      paramEntity.strExtInfo = paramCursor.getString(i);
      break label8840;
      label14126:
      paramEntity.strCurrentBgUrl = paramCursor.getString(i);
      break label8877;
      label14141:
      paramEntity.bgType = paramCursor.getBlob(i);
      break label8914;
      label14156:
      paramEntity.encId = paramCursor.getString(i);
      break label8951;
      label14171:
      paramEntity.busiEntry = paramCursor.getString(i);
      break label8988;
      label14186:
      paramEntity.favoriteSource = paramCursor.getInt(i);
      break label9025;
      label14201:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.visibleMusicPendant = paramBoolean;
        break;
      }
      label14228:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.autoPlayMusicPendant = paramBoolean;
        break;
      }
      label14255:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showRedPointMusicPendant = paramBoolean;
        break;
      }
      label14282:
      paramEntity.privilegePromptStr = paramCursor.getString(i);
      break label9173;
      label14297:
      paramEntity.privilegeJumpUrl = paramCursor.getString(i);
      break label9210;
      label14312:
      paramEntity.vOpenPriv = paramCursor.getBlob(i);
      break label9247;
      label14327:
      paramEntity.vClosePriv = paramCursor.getBlob(i);
      break label9284;
      label14342:
      paramEntity.presentDesc = paramCursor.getString(i);
      break label9321;
      label14357:
      paramEntity.presentCustourl = paramCursor.getString(i);
      break label9358;
      label14372:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.presentSwitch = paramBoolean;
        break;
      }
      label14399:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showPresent = paramBoolean;
        break;
      }
      label14426:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showMusicBox = paramBoolean;
        break;
      }
      label14453:
      paramEntity.addSrcName = paramCursor.getString(i);
      break label9506;
      label14468:
      paramEntity.addSrcId = paramCursor.getLong(i);
      break label9543;
      label14483:
      paramEntity.addSubSrcId = paramCursor.getLong(i);
      break label9580;
      label14498:
      paramEntity.strVoteLimitedNotice = paramCursor.getString(i);
      break label9617;
      label14513:
      paramEntity.bHaveVotedCnt = paramCursor.getShort(i);
      break label9654;
      label14528:
      paramEntity.bAvailVoteCnt = paramCursor.getShort(i);
      break label9691;
      label14543:
      paramEntity.mNowShowFlag = paramCursor.getInt(i);
      break label9728;
      label14558:
      paramEntity.mNowShowIconUrl = paramCursor.getString(i);
      break label9765;
      label14573:
      paramEntity.mNowShowJumpUrl = paramCursor.getString(i);
      break label9802;
      label14588:
      paramEntity.vCoverInfo = paramCursor.getBlob(i);
      break label9839;
      label14603:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.medalSwitchDisable = paramBoolean;
        break;
      }
      label14630:
      paramEntity.iMedalCount = paramCursor.getInt(i);
      break label9913;
      label14645:
      paramEntity.iNewCount = paramCursor.getInt(i);
      break label9950;
      label14660:
      paramEntity.iUpgradeCount = paramCursor.getInt(i);
      break label9987;
      label14675:
      paramEntity.strPromptParams = paramCursor.getString(i);
      break label10024;
      label14690:
      paramEntity.hobbyEntry = paramCursor.getString(i);
      break label10061;
      label14705:
      paramEntity.lastPraiseInfoList = paramCursor.getBlob(i);
      break label10098;
      label14720:
      paramEntity.tempChatSig = paramCursor.getBlob(i);
      break label10135;
      label14735:
      paramEntity.namePlateOfKingGameId = paramCursor.getLong(i);
      break label10172;
      label14750:
      paramEntity.namePlateOfKingLoginTime = paramCursor.getLong(i);
      break label10209;
      label14765:
      paramEntity.namePlateOfKingDan = paramCursor.getInt(i);
      break label10246;
      label14780:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.namePlateOfKingDanDisplatSwitch = paramBoolean;
        break;
      }
      label14807:
      paramEntity.vPersonalityLabelV2 = paramCursor.getBlob(i);
      break label10320;
      label14822:
      paramEntity.cardType = paramCursor.getInt(i);
      break label10357;
      label14837:
      paramEntity.diyText = paramCursor.getString(i);
      break label10394;
      label14852:
      paramEntity.diyTextFontId = paramCursor.getInt(i);
      break label10431;
      label14867:
      paramEntity.diyTextWidth = paramCursor.getFloat(i);
      break label10468;
      label14882:
      paramEntity.diyTextHeight = paramCursor.getFloat(i);
      break label10505;
      label14897:
      paramEntity.diyTextLocX = paramCursor.getFloat(i);
      break label10542;
      label14912:
      paramEntity.diyTextLocY = paramCursor.getFloat(i);
      break label10579;
      label14927:
      paramEntity.diyTextDegree = paramCursor.getFloat(i);
      break label10616;
      label14942:
      paramEntity.diyTextScale = paramCursor.getFloat(i);
      break label10653;
      label14957:
      paramEntity.diyTextTransparency = paramCursor.getFloat(i);
      break label10690;
      label14972:
      paramEntity.diyDefaultText = paramCursor.getString(i);
      break label10727;
      label14987:
      paramEntity.popularity = paramCursor.getInt(i);
      break label10764;
      label15002:
      paramEntity.declaration = paramCursor.getString(i);
      break label10801;
      label15017:
      paramEntity.voiceUrl = paramCursor.getString(i);
      break label10838;
      label15032:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isShowCard = paramBoolean;
        break;
      }
      label15059:
      paramEntity.updateTime = paramCursor.getLong(i);
      break label10912;
      label15074:
      paramEntity.extendFriendFlag = paramCursor.getInt(i);
      break label10949;
      label15089:
      paramEntity.extendFriendVoiceDuration = paramCursor.getInt(i);
      break label10986;
      label15104:
      paramEntity.extendFriendEntryContact = paramCursor.getShort(i);
      break label11023;
      label15119:
      paramEntity.extendFriendEntryAddFriend = paramCursor.getShort(i);
      break label11060;
      label15134:
      paramEntity.extendFriendQuestion = paramCursor.getShort(i);
      break label11097;
      label15149:
      paramEntity.fontId = paramCursor.getInt(i);
      break label11134;
      label15164:
      paramEntity.fontType = paramCursor.getInt(i);
      break label11171;
      label15179:
      paramEntity.clothesId = paramCursor.getInt(i);
      break label11208;
      label15194:
      paramEntity.schoolId = paramCursor.getString(i);
      break label11245;
      label15209:
      paramEntity.schoolName = paramCursor.getString(i);
      break label11282;
      label15224:
      paramEntity.authState = paramCursor.getLong(i);
      break label11319;
      label15239:
      paramEntity.idx = paramCursor.getInt(i);
      break label11356;
      label15254:
      paramEntity.category = paramCursor.getInt(i);
      break label11393;
      label15269:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isShowMiniPlaying = paramBoolean;
        break;
      }
      label15296:
      paramEntity.tabJumpUrl = paramCursor.getString(i);
      break label11467;
      label15311:
      paramEntity.guestJumpUrl = paramCursor.getString(i);
      break label11504;
      label15326:
      paramEntity.guestAppTotal = paramCursor.getInt(i);
      break label11541;
      label15341:
      paramEntity.defaultCardId = paramCursor.getInt(i);
      break label11578;
      label15356:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.strangerVoteOpen = paramBoolean;
        break;
      }
      label15383:
      paramEntity.lSuperVipTemplateId = paramCursor.getLong(i);
      break label11652;
      label15398:
      paramEntity.bBigClubVipOpen = ((byte)paramCursor.getShort(i));
      break label11689;
      label15414:
      paramEntity.iBigClubVipType = paramCursor.getInt(i);
      break label11726;
      label15429:
      paramEntity.iBigClubVipLevel = paramCursor.getInt(i);
      break label11763;
      label15444:
      paramEntity.lBigClubTemplateId = paramCursor.getLong(i);
      break label11800;
      label15459:
      paramEntity.diyComplicatedInfo = paramCursor.getString(i);
      break label11837;
      label15474:
      paramEntity.cardId = paramCursor.getLong(i);
      break label11874;
      label15489:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.strangerInviteMeGroupOpen = paramBoolean;
        break;
      }
      label15516:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isPrettyGroupOwner = paramBoolean;
        break;
      }
      label15543:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isHidePrettyGroutIdentity = paramBoolean;
        break;
      }
      label15570:
      paramEntity.mQQLevelType = paramCursor.getInt(i);
    }
    label15585:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramEntity.schoolVerifiedFlag = paramBoolean;
      break;
    }
    label15612:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramEntity.troopHonorSwitch = paramBoolean;
      return paramEntity;
    }
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (Card)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("strNick", paramEntity.strNick);
    paramContentValues.put("shGender", Short.valueOf(paramEntity.shGender));
    paramContentValues.put("shAge", Short.valueOf(paramEntity.shAge));
    paramContentValues.put("nFaceID", Integer.valueOf(paramEntity.nFaceID));
    paramContentValues.put("strCertificationInfo", paramEntity.strCertificationInfo);
    paramContentValues.put("shType", Short.valueOf(paramEntity.shType));
    paramContentValues.put("vContent", paramEntity.vContent);
    paramContentValues.put("strSign", paramEntity.strSign);
    paramContentValues.put("strCompany", paramEntity.strCompany);
    paramContentValues.put("strSchool", paramEntity.strSchool);
    paramContentValues.put("uFaceTimeStamp", Integer.valueOf(paramEntity.uFaceTimeStamp));
    paramContentValues.put("vQQFaceID", paramEntity.vQQFaceID);
    paramContentValues.put("strReMark", paramEntity.strReMark);
    paramContentValues.put("bWeiboInfo", Byte.valueOf(paramEntity.bWeiboInfo));
    paramContentValues.put("bQzoneInfo", Byte.valueOf(paramEntity.bQzoneInfo));
    paramContentValues.put("nSameFriendsNum", Integer.valueOf(paramEntity.nSameFriendsNum));
    paramContentValues.put("strCompanySame", paramEntity.strCompanySame);
    paramContentValues.put("strSchoolSame", paramEntity.strSchoolSame);
    paramContentValues.put("lCardShowNum", Long.valueOf(paramEntity.lCardShowNum));
    paramContentValues.put("bSingle", Byte.valueOf(paramEntity.bSingle));
    paramContentValues.put("lVisitCount", Long.valueOf(paramEntity.lVisitCount));
    paramContentValues.put("lVoteCount", Long.valueOf(paramEntity.lVoteCount));
    paramContentValues.put("tagInfosByte", paramEntity.tagInfosByte);
    paramContentValues.put("eUserIdentityType", Byte.valueOf(paramEntity.eUserIdentityType));
    paramContentValues.put("vBackground", paramEntity.vBackground);
    paramContentValues.put("labelInfoBytes", paramEntity.labelInfoBytes);
    paramContentValues.put("age", Byte.valueOf(paramEntity.age));
    paramContentValues.put("constellation", Integer.valueOf(paramEntity.constellation));
    paramContentValues.put("pyFaceUrl", paramEntity.pyFaceUrl);
    paramContentValues.put("location", paramEntity.location);
    paramContentValues.put("bVoted", Byte.valueOf(paramEntity.bVoted));
    paramContentValues.put("bFavorited", Byte.valueOf(paramEntity.bFavorited));
    paramContentValues.put("iVoteIncrement", Integer.valueOf(paramEntity.iVoteIncrement));
    paramContentValues.put("strJoinHexAlbumFileKey", paramEntity.strJoinHexAlbumFileKey);
    paramContentValues.put("iFaceNum", Integer.valueOf(paramEntity.iFaceNum));
    paramContentValues.put("cSqqLevel", Byte.valueOf(paramEntity.cSqqLevel));
    paramContentValues.put("iQQLevel", Integer.valueOf(paramEntity.iQQLevel));
    paramContentValues.put("uCurMulType", Long.valueOf(paramEntity.uCurMulType));
    paramContentValues.put("strProvince", paramEntity.strProvince);
    paramContentValues.put("strCity", paramEntity.strCity);
    paramContentValues.put("strCountry", paramEntity.strCountry);
    paramContentValues.put("lBirthday", Long.valueOf(paramEntity.lBirthday));
    paramContentValues.put("strLocationCodes", paramEntity.strLocationCodes);
    paramContentValues.put("strLocationDesc", paramEntity.strLocationDesc);
    paramContentValues.put("strHometownCodes", paramEntity.strHometownCodes);
    paramContentValues.put("strHometownDesc", paramEntity.strHometownDesc);
    paramContentValues.put("strHometownCountry", paramEntity.strHometownCountry);
    paramContentValues.put("strHometownProvince", paramEntity.strHometownProvince);
    paramContentValues.put("strHometownCity", paramEntity.strHometownCity);
    paramContentValues.put("strEmail", paramEntity.strEmail);
    paramContentValues.put("strPersonalNote", paramEntity.strPersonalNote);
    paramContentValues.put("iProfession", Integer.valueOf(paramEntity.iProfession));
    paramContentValues.put("bindPhoneInfo", paramEntity.bindPhoneInfo);
    paramContentValues.put("bCardInfo", paramEntity.bCardInfo);
    paramContentValues.put("strTroopName", paramEntity.strTroopName);
    paramContentValues.put("strTroopNick", paramEntity.strTroopNick);
    paramContentValues.put("strMobile", paramEntity.strMobile);
    paramContentValues.put("strContactName", paramEntity.strContactName);
    paramContentValues.put("ulShowControl", Integer.valueOf(paramEntity.ulShowControl));
    paramContentValues.put("feedPreviewTime", Long.valueOf(paramEntity.feedPreviewTime));
    paramContentValues.put("strQzoneFeedsDesc", paramEntity.strQzoneFeedsDesc);
    paramContentValues.put("StrPresentDesc", paramEntity.StrPresentDesc);
    paramContentValues.put("strSpaceName", paramEntity.strSpaceName);
    paramContentValues.put("strQzoneHeader", paramEntity.strQzoneHeader);
    paramContentValues.put("vQzonePhotos", paramEntity.vQzonePhotos);
    paramContentValues.put("vQzoneCoverInfo", paramEntity.vQzoneCoverInfo);
    paramContentValues.put("enlargeQzonePic", Integer.valueOf(paramEntity.enlargeQzonePic));
    paramContentValues.put("showPublishButton", Boolean.valueOf(paramEntity.showPublishButton));
    paramContentValues.put("strStatus", paramEntity.strStatus);
    paramContentValues.put("strAutoRemark", paramEntity.strAutoRemark);
    paramContentValues.put("vSeed", paramEntity.vSeed);
    paramContentValues.put("vCookies", paramEntity.vCookies);
    paramContentValues.put("hasFakeData", Boolean.valueOf(paramEntity.hasFakeData));
    paramContentValues.put("bQQVipOpen", Byte.valueOf(paramEntity.bQQVipOpen));
    paramContentValues.put("iQQVipType", Integer.valueOf(paramEntity.iQQVipType));
    paramContentValues.put("iQQVipLevel", Integer.valueOf(paramEntity.iQQVipLevel));
    paramContentValues.put("nameplateVipType", Integer.valueOf(paramEntity.nameplateVipType));
    paramContentValues.put("grayNameplateFlag", Integer.valueOf(paramEntity.grayNameplateFlag));
    paramContentValues.put("bSuperVipOpen", Byte.valueOf(paramEntity.bSuperVipOpen));
    paramContentValues.put("iSuperVipType", Integer.valueOf(paramEntity.iSuperVipType));
    paramContentValues.put("iSuperVipLevel", Integer.valueOf(paramEntity.iSuperVipLevel));
    paramContentValues.put("bSuperQQOpen", Byte.valueOf(paramEntity.bSuperQQOpen));
    paramContentValues.put("iSuperQQType", Integer.valueOf(paramEntity.iSuperQQType));
    paramContentValues.put("iSuperQQLevel", Integer.valueOf(paramEntity.iSuperQQLevel));
    paramContentValues.put("bHollywoodVipOpen", Byte.valueOf(paramEntity.bHollywoodVipOpen));
    paramContentValues.put("iHollywoodVipType", Integer.valueOf(paramEntity.iHollywoodVipType));
    paramContentValues.put("iHollywoodVipLevel", Integer.valueOf(paramEntity.iHollywoodVipLevel));
    paramContentValues.put("strShowName", paramEntity.strShowName);
    paramContentValues.put("vRichSign", paramEntity.vRichSign);
    paramContentValues.put("lSignModifyTime", Long.valueOf(paramEntity.lSignModifyTime));
    paramContentValues.put("vLongNickTopicInfo", paramEntity.vLongNickTopicInfo);
    paramContentValues.put("lUserFlag", Long.valueOf(paramEntity.lUserFlag));
    paramContentValues.put("lLoginDays", Long.valueOf(paramEntity.lLoginDays));
    paramContentValues.put("strLoginDaysDesc", paramEntity.strLoginDaysDesc);
    paramContentValues.put("lQQMasterLogindays", Long.valueOf(paramEntity.lQQMasterLogindays));
    paramContentValues.put("iXManScene1DelayTime", Integer.valueOf(paramEntity.iXManScene1DelayTime));
    paramContentValues.put("iXManScene2DelayTime", Integer.valueOf(paramEntity.iXManScene2DelayTime));
    paramContentValues.put("allowPeopleSee", Boolean.valueOf(paramEntity.allowPeopleSee));
    paramContentValues.put("allowCalInteractive", Boolean.valueOf(paramEntity.allowCalInteractive));
    paramContentValues.put("showOnlineFriends", Boolean.valueOf(paramEntity.showOnlineFriends));
    paramContentValues.put("allowClick", Boolean.valueOf(paramEntity.allowClick));
    paramContentValues.put("babyQSwitch", Boolean.valueOf(paramEntity.babyQSwitch));
    paramContentValues.put("isSuperRedDiamond", Boolean.valueOf(paramEntity.isSuperRedDiamond));
    paramContentValues.put("isRedDiamond", Boolean.valueOf(paramEntity.isRedDiamond));
    paramContentValues.put("redLevel", Integer.valueOf(paramEntity.redLevel));
    paramContentValues.put("isSuperYellowDiamond", Boolean.valueOf(paramEntity.isSuperYellowDiamond));
    paramContentValues.put("isYellowDiamond", Boolean.valueOf(paramEntity.isYellowDiamond));
    paramContentValues.put("yellowLevel", Integer.valueOf(paramEntity.yellowLevel));
    paramContentValues.put("isSuperGreenDiamond", Boolean.valueOf(paramEntity.isSuperGreenDiamond));
    paramContentValues.put("isGreenDiamond", Boolean.valueOf(paramEntity.isGreenDiamond));
    paramContentValues.put("greenLevel", Integer.valueOf(paramEntity.greenLevel));
    paramContentValues.put("templateRet", Integer.valueOf(paramEntity.templateRet));
    paramContentValues.put("lCurrentStyleId", Long.valueOf(paramEntity.lCurrentStyleId));
    paramContentValues.put("lCurrentBgId", Long.valueOf(paramEntity.lCurrentBgId));
    paramContentValues.put("backgroundUrl", paramEntity.backgroundUrl);
    paramContentValues.put("backgroundColor", Long.valueOf(paramEntity.backgroundColor));
    paramContentValues.put("dynamicCardFlag", Integer.valueOf(paramEntity.dynamicCardFlag));
    paramContentValues.put("strZipUrl", paramEntity.strZipUrl);
    paramContentValues.put("strActiveUrl", paramEntity.strActiveUrl);
    paramContentValues.put("strDrawerCardUrl", paramEntity.strDrawerCardUrl);
    paramContentValues.put("strWzryHeroUrl", paramEntity.strWzryHeroUrl);
    paramContentValues.put("wzryHonorInfo", paramEntity.wzryHonorInfo);
    paramContentValues.put("strExtInfo", paramEntity.strExtInfo);
    paramContentValues.put("strCurrentBgUrl", paramEntity.strCurrentBgUrl);
    paramContentValues.put("bgType", paramEntity.bgType);
    paramContentValues.put("encId", paramEntity.encId);
    paramContentValues.put("busiEntry", paramEntity.busiEntry);
    paramContentValues.put("favoriteSource", Integer.valueOf(paramEntity.favoriteSource));
    paramContentValues.put("visibleMusicPendant", Boolean.valueOf(paramEntity.visibleMusicPendant));
    paramContentValues.put("autoPlayMusicPendant", Boolean.valueOf(paramEntity.autoPlayMusicPendant));
    paramContentValues.put("showRedPointMusicPendant", Boolean.valueOf(paramEntity.showRedPointMusicPendant));
    paramContentValues.put("privilegePromptStr", paramEntity.privilegePromptStr);
    paramContentValues.put("privilegeJumpUrl", paramEntity.privilegeJumpUrl);
    paramContentValues.put("vOpenPriv", paramEntity.vOpenPriv);
    paramContentValues.put("vClosePriv", paramEntity.vClosePriv);
    paramContentValues.put("presentDesc", paramEntity.presentDesc);
    paramContentValues.put("presentCustourl", paramEntity.presentCustourl);
    paramContentValues.put("presentSwitch", Boolean.valueOf(paramEntity.presentSwitch));
    paramContentValues.put("showPresent", Boolean.valueOf(paramEntity.showPresent));
    paramContentValues.put("showMusicBox", Boolean.valueOf(paramEntity.showMusicBox));
    paramContentValues.put("addSrcName", paramEntity.addSrcName);
    paramContentValues.put("addSrcId", Long.valueOf(paramEntity.addSrcId));
    paramContentValues.put("addSubSrcId", Long.valueOf(paramEntity.addSubSrcId));
    paramContentValues.put("strVoteLimitedNotice", paramEntity.strVoteLimitedNotice);
    paramContentValues.put("bHaveVotedCnt", Short.valueOf(paramEntity.bHaveVotedCnt));
    paramContentValues.put("bAvailVoteCnt", Short.valueOf(paramEntity.bAvailVoteCnt));
    paramContentValues.put("mNowShowFlag", Integer.valueOf(paramEntity.mNowShowFlag));
    paramContentValues.put("mNowShowIconUrl", paramEntity.mNowShowIconUrl);
    paramContentValues.put("mNowShowJumpUrl", paramEntity.mNowShowJumpUrl);
    paramContentValues.put("vCoverInfo", paramEntity.vCoverInfo);
    paramContentValues.put("medalSwitchDisable", Boolean.valueOf(paramEntity.medalSwitchDisable));
    paramContentValues.put("iMedalCount", Integer.valueOf(paramEntity.iMedalCount));
    paramContentValues.put("iNewCount", Integer.valueOf(paramEntity.iNewCount));
    paramContentValues.put("iUpgradeCount", Integer.valueOf(paramEntity.iUpgradeCount));
    paramContentValues.put("strPromptParams", paramEntity.strPromptParams);
    paramContentValues.put("hobbyEntry", paramEntity.hobbyEntry);
    paramContentValues.put("lastPraiseInfoList", paramEntity.lastPraiseInfoList);
    paramContentValues.put("tempChatSig", paramEntity.tempChatSig);
    paramContentValues.put("namePlateOfKingGameId", Long.valueOf(paramEntity.namePlateOfKingGameId));
    paramContentValues.put("namePlateOfKingLoginTime", Long.valueOf(paramEntity.namePlateOfKingLoginTime));
    paramContentValues.put("namePlateOfKingDan", Integer.valueOf(paramEntity.namePlateOfKingDan));
    paramContentValues.put("namePlateOfKingDanDisplatSwitch", Boolean.valueOf(paramEntity.namePlateOfKingDanDisplatSwitch));
    paramContentValues.put("vPersonalityLabelV2", paramEntity.vPersonalityLabelV2);
    paramContentValues.put("cardType", Integer.valueOf(paramEntity.cardType));
    paramContentValues.put("diyText", paramEntity.diyText);
    paramContentValues.put("diyTextFontId", Integer.valueOf(paramEntity.diyTextFontId));
    paramContentValues.put("diyTextWidth", Float.valueOf(paramEntity.diyTextWidth));
    paramContentValues.put("diyTextHeight", Float.valueOf(paramEntity.diyTextHeight));
    paramContentValues.put("diyTextLocX", Float.valueOf(paramEntity.diyTextLocX));
    paramContentValues.put("diyTextLocY", Float.valueOf(paramEntity.diyTextLocY));
    paramContentValues.put("diyTextDegree", Float.valueOf(paramEntity.diyTextDegree));
    paramContentValues.put("diyTextScale", Float.valueOf(paramEntity.diyTextScale));
    paramContentValues.put("diyTextTransparency", Float.valueOf(paramEntity.diyTextTransparency));
    paramContentValues.put("diyDefaultText", paramEntity.diyDefaultText);
    paramContentValues.put("popularity", Integer.valueOf(paramEntity.popularity));
    paramContentValues.put("declaration", paramEntity.declaration);
    paramContentValues.put("voiceUrl", paramEntity.voiceUrl);
    paramContentValues.put("isShowCard", Boolean.valueOf(paramEntity.isShowCard));
    paramContentValues.put("updateTime", Long.valueOf(paramEntity.updateTime));
    paramContentValues.put("extendFriendFlag", Integer.valueOf(paramEntity.extendFriendFlag));
    paramContentValues.put("extendFriendVoiceDuration", Integer.valueOf(paramEntity.extendFriendVoiceDuration));
    paramContentValues.put("extendFriendEntryContact", Short.valueOf(paramEntity.extendFriendEntryContact));
    paramContentValues.put("extendFriendEntryAddFriend", Short.valueOf(paramEntity.extendFriendEntryAddFriend));
    paramContentValues.put("extendFriendQuestion", Short.valueOf(paramEntity.extendFriendQuestion));
    paramContentValues.put("fontId", Integer.valueOf(paramEntity.fontId));
    paramContentValues.put("fontType", Integer.valueOf(paramEntity.fontType));
    paramContentValues.put("clothesId", Integer.valueOf(paramEntity.clothesId));
    paramContentValues.put("schoolId", paramEntity.schoolId);
    paramContentValues.put("schoolName", paramEntity.schoolName);
    paramContentValues.put("authState", Long.valueOf(paramEntity.authState));
    paramContentValues.put("idx", Integer.valueOf(paramEntity.idx));
    paramContentValues.put("category", Integer.valueOf(paramEntity.category));
    paramContentValues.put("isShowMiniPlaying", Boolean.valueOf(paramEntity.isShowMiniPlaying));
    paramContentValues.put("tabJumpUrl", paramEntity.tabJumpUrl);
    paramContentValues.put("guestJumpUrl", paramEntity.guestJumpUrl);
    paramContentValues.put("guestAppTotal", Integer.valueOf(paramEntity.guestAppTotal));
    paramContentValues.put("defaultCardId", Integer.valueOf(paramEntity.defaultCardId));
    paramContentValues.put("strangerVoteOpen", Boolean.valueOf(paramEntity.strangerVoteOpen));
    paramContentValues.put("lSuperVipTemplateId", Long.valueOf(paramEntity.lSuperVipTemplateId));
    paramContentValues.put("bBigClubVipOpen", Byte.valueOf(paramEntity.bBigClubVipOpen));
    paramContentValues.put("iBigClubVipType", Integer.valueOf(paramEntity.iBigClubVipType));
    paramContentValues.put("iBigClubVipLevel", Integer.valueOf(paramEntity.iBigClubVipLevel));
    paramContentValues.put("lBigClubTemplateId", Long.valueOf(paramEntity.lBigClubTemplateId));
    paramContentValues.put("diyComplicatedInfo", paramEntity.diyComplicatedInfo);
    paramContentValues.put("cardId", Long.valueOf(paramEntity.cardId));
    paramContentValues.put("strangerInviteMeGroupOpen", Boolean.valueOf(paramEntity.strangerInviteMeGroupOpen));
    paramContentValues.put("isPrettyGroupOwner", Boolean.valueOf(paramEntity.isPrettyGroupOwner));
    paramContentValues.put("isHidePrettyGroutIdentity", Boolean.valueOf(paramEntity.isHidePrettyGroutIdentity));
    paramContentValues.put("mQQLevelType", Integer.valueOf(paramEntity.mQQLevelType));
    paramContentValues.put("schoolVerifiedFlag", Boolean.valueOf(paramEntity.schoolVerifiedFlag));
    paramContentValues.put("troopHonorSwitch", Boolean.valueOf(paramEntity.troopHonorSwitch));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,strNick TEXT ,shGender INTEGER ,shAge INTEGER ,nFaceID INTEGER ,strCertificationInfo TEXT ,shType INTEGER ,vContent BLOB ,strSign TEXT ,strCompany TEXT ,strSchool TEXT ,uFaceTimeStamp INTEGER ,vQQFaceID BLOB ,strReMark TEXT ,bWeiboInfo INTEGER ,bQzoneInfo INTEGER ,nSameFriendsNum INTEGER ,strCompanySame TEXT ,strSchoolSame TEXT ,lCardShowNum INTEGER ,bSingle INTEGER ,lVisitCount INTEGER ,lVoteCount INTEGER ,tagInfosByte BLOB ,eUserIdentityType INTEGER ,vBackground BLOB ,labelInfoBytes BLOB ,age INTEGER ,constellation INTEGER ,pyFaceUrl TEXT ,location TEXT ,bVoted INTEGER ,bFavorited INTEGER ,iVoteIncrement INTEGER ,strJoinHexAlbumFileKey TEXT ,iFaceNum INTEGER ,cSqqLevel INTEGER ,iQQLevel INTEGER ,uCurMulType INTEGER ,strProvince TEXT ,strCity TEXT ,strCountry TEXT ,lBirthday INTEGER ,strLocationCodes TEXT ,strLocationDesc TEXT ,strHometownCodes TEXT ,strHometownDesc TEXT ,strHometownCountry TEXT ,strHometownProvince TEXT ,strHometownCity TEXT ,strEmail TEXT ,strPersonalNote TEXT ,iProfession INTEGER ,bindPhoneInfo TEXT ,bCardInfo BLOB ,strTroopName TEXT ,strTroopNick TEXT ,strMobile TEXT ,strContactName TEXT ,ulShowControl INTEGER ,feedPreviewTime INTEGER ,strQzoneFeedsDesc TEXT ,StrPresentDesc TEXT ,strSpaceName TEXT ,strQzoneHeader TEXT ,vQzonePhotos BLOB ,vQzoneCoverInfo BLOB ,enlargeQzonePic INTEGER ,showPublishButton INTEGER ,strStatus TEXT ,strAutoRemark TEXT ,vSeed BLOB ,vCookies BLOB ,hasFakeData INTEGER ,bQQVipOpen INTEGER ,iQQVipType INTEGER ,iQQVipLevel INTEGER ,nameplateVipType INTEGER ,grayNameplateFlag INTEGER ,bSuperVipOpen INTEGER ,iSuperVipType INTEGER ,iSuperVipLevel INTEGER ,bSuperQQOpen INTEGER ,iSuperQQType INTEGER ,iSuperQQLevel INTEGER ,bHollywoodVipOpen INTEGER ,iHollywoodVipType INTEGER ,iHollywoodVipLevel INTEGER ,strShowName TEXT ,vRichSign BLOB ,lSignModifyTime INTEGER ,vLongNickTopicInfo BLOB ,lUserFlag INTEGER ,lLoginDays INTEGER ,strLoginDaysDesc TEXT ,lQQMasterLogindays INTEGER ,iXManScene1DelayTime INTEGER ,iXManScene2DelayTime INTEGER ,allowPeopleSee INTEGER ,allowCalInteractive INTEGER ,showOnlineFriends INTEGER ,allowClick INTEGER ,babyQSwitch INTEGER ,isSuperRedDiamond INTEGER ,isRedDiamond INTEGER ,redLevel INTEGER ,isSuperYellowDiamond INTEGER ,isYellowDiamond INTEGER ,yellowLevel INTEGER ,isSuperGreenDiamond INTEGER ,isGreenDiamond INTEGER ,greenLevel INTEGER ,templateRet INTEGER ,lCurrentStyleId INTEGER ,lCurrentBgId INTEGER ,backgroundUrl TEXT ,backgroundColor INTEGER ,dynamicCardFlag INTEGER ,strZipUrl TEXT ,strActiveUrl TEXT ,strDrawerCardUrl TEXT ,strWzryHeroUrl TEXT ,wzryHonorInfo BLOB ,strExtInfo TEXT ,strCurrentBgUrl TEXT ,bgType BLOB ,encId TEXT ,busiEntry TEXT ,favoriteSource INTEGER ,visibleMusicPendant INTEGER ,autoPlayMusicPendant INTEGER ,showRedPointMusicPendant INTEGER ,privilegePromptStr TEXT ,privilegeJumpUrl TEXT ,vOpenPriv BLOB ,vClosePriv BLOB ,presentDesc TEXT ,presentCustourl TEXT ,presentSwitch INTEGER ,showPresent INTEGER ,showMusicBox INTEGER ,addSrcName TEXT ,addSrcId INTEGER ,addSubSrcId INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,mNowShowFlag INTEGER ,mNowShowIconUrl TEXT ,mNowShowJumpUrl TEXT ,vCoverInfo BLOB ,medalSwitchDisable INTEGER ,iMedalCount INTEGER ,iNewCount INTEGER ,iUpgradeCount INTEGER ,strPromptParams TEXT ,hobbyEntry TEXT ,lastPraiseInfoList BLOB ,tempChatSig BLOB ,namePlateOfKingGameId INTEGER ,namePlateOfKingLoginTime INTEGER ,namePlateOfKingDan INTEGER ,namePlateOfKingDanDisplatSwitch INTEGER ,vPersonalityLabelV2 BLOB ,cardType INTEGER ,diyText TEXT ,diyTextFontId INTEGER ,diyTextWidth REAL ,diyTextHeight REAL ,diyTextLocX REAL ,diyTextLocY REAL ,diyTextDegree REAL ,diyTextScale REAL ,diyTextTransparency REAL ,diyDefaultText TEXT ,popularity INTEGER ,declaration TEXT ,voiceUrl TEXT ,isShowCard INTEGER ,updateTime INTEGER ,extendFriendFlag INTEGER ,extendFriendVoiceDuration INTEGER ,extendFriendEntryContact INTEGER ,extendFriendEntryAddFriend INTEGER ,extendFriendQuestion INTEGER ,fontId INTEGER ,fontType INTEGER ,clothesId INTEGER ,schoolId TEXT ,schoolName TEXT ,authState INTEGER ,idx INTEGER ,category INTEGER ,isShowMiniPlaying INTEGER ,tabJumpUrl TEXT ,guestJumpUrl TEXT ,guestAppTotal INTEGER ,defaultCardId INTEGER ,strangerVoteOpen INTEGER ,lSuperVipTemplateId INTEGER ,bBigClubVipOpen INTEGER ,iBigClubVipType INTEGER ,iBigClubVipLevel INTEGER ,lBigClubTemplateId INTEGER ,diyComplicatedInfo TEXT ,cardId INTEGER ,strangerInviteMeGroupOpen INTEGER ,isPrettyGroupOwner INTEGER ,isHidePrettyGroutIdentity INTEGER ,mQQLevelType INTEGER ,schoolVerifiedFlag INTEGER ,troopHonorSwitch INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayuu
 * JD-Core Version:    0.7.0.1
 */