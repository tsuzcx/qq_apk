import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class azhd
  extends OGAbstractDao
{
  public azhd()
  {
    this.columnLen = 217;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (Card)paramEntity;
    label1873:
    label2003:
    label4311:
    label4441:
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
          break label4311;
        }
        paramBoolean = true;
        label1387:
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
          break label4316;
        }
        paramBoolean = true;
        paramEntity.allowPeopleSee = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowCalInteractive"))) {
          break label4321;
        }
        paramBoolean = true;
        label1899:
        paramEntity.allowCalInteractive = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showOnlineFriends"))) {
          break label4326;
        }
        paramBoolean = true;
        paramEntity.showOnlineFriends = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowClick"))) {
          break label4331;
        }
        paramBoolean = true;
        paramEntity.allowClick = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("babyQSwitch"))) {
          break label4336;
        }
        paramBoolean = true;
        paramEntity.babyQSwitch = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperRedDiamond"))) {
          break label4341;
        }
        paramBoolean = true;
        paramEntity.isSuperRedDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRedDiamond"))) {
          break label4346;
        }
        paramBoolean = true;
        label2029:
        paramEntity.isRedDiamond = paramBoolean;
        paramEntity.redLevel = paramCursor.getInt(paramCursor.getColumnIndex("redLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperYellowDiamond"))) {
          break label4351;
        }
        paramBoolean = true;
        paramEntity.isSuperYellowDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isYellowDiamond"))) {
          break label4356;
        }
        paramBoolean = true;
        paramEntity.isYellowDiamond = paramBoolean;
        paramEntity.yellowLevel = paramCursor.getInt(paramCursor.getColumnIndex("yellowLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperGreenDiamond"))) {
          break label4361;
        }
        paramBoolean = true;
        label2145:
        paramEntity.isSuperGreenDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isGreenDiamond"))) {
          break label4366;
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
          break label4371;
        }
        paramBoolean = true;
        label2539:
        paramEntity.visibleMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("autoPlayMusicPendant"))) {
          break label4376;
        }
        paramBoolean = true;
        paramEntity.autoPlayMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showRedPointMusicPendant"))) {
          break label4381;
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
          break label4386;
        }
        paramBoolean = true;
        paramEntity.presentSwitch = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showPresent"))) {
          break label4391;
        }
        paramBoolean = true;
        paramEntity.showPresent = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showMusicBox"))) {
          break label4396;
        }
        paramBoolean = true;
        label2783:
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
          break label4401;
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
          break label4406;
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
          break label4411;
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
          break label4416;
        }
        paramBoolean = true;
        label3818:
        paramEntity.isShowMiniPlaying = paramBoolean;
        paramEntity.tabJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("tabJumpUrl"));
        paramEntity.guestJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("guestJumpUrl"));
        paramEntity.guestAppTotal = paramCursor.getInt(paramCursor.getColumnIndex("guestAppTotal"));
        paramEntity.defaultCardId = paramCursor.getInt(paramCursor.getColumnIndex("defaultCardId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("strangerVoteOpen"))) {
          break label4421;
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
          break label4426;
        }
        paramBoolean = true;
        label4080:
        paramEntity.strangerInviteMeGroupOpen = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isPrettyGroupOwner"))) {
          break label4431;
        }
        paramBoolean = true;
        paramEntity.isPrettyGroupOwner = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isHidePrettyGroutIdentity"))) {
          break label4436;
        }
        paramBoolean = true;
        paramEntity.isHidePrettyGroutIdentity = paramBoolean;
        paramEntity.mQQLevelType = paramCursor.getInt(paramCursor.getColumnIndex("mQQLevelType"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("schoolVerifiedFlag"))) {
          break label4441;
        }
        paramBoolean = true;
        paramEntity.schoolVerifiedFlag = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("troopHonorSwitch"))) {
          break label4446;
        }
      }
      label4316:
      label4446:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.troopHonorSwitch = paramBoolean;
        paramEntity.lhLevel = paramCursor.getInt(paramCursor.getColumnIndex("lhLevel"));
        paramEntity.qid = paramCursor.getString(paramCursor.getColumnIndex("qid"));
        paramEntity.qidColor = paramCursor.getString(paramCursor.getColumnIndex("qidColor"));
        paramEntity.qidLogoUrl = paramCursor.getString(paramCursor.getColumnIndex("qidLogoUrl"));
        paramEntity.qidBgUrl = paramCursor.getString(paramCursor.getColumnIndex("qidBgUrl"));
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label1387;
        paramBoolean = false;
        break label1873;
        label4321:
        paramBoolean = false;
        break label1899;
        label4326:
        paramBoolean = false;
        break label1925;
        label4331:
        paramBoolean = false;
        break label1951;
        label4336:
        paramBoolean = false;
        break label1977;
        label4341:
        paramBoolean = false;
        break label2003;
        label4346:
        paramBoolean = false;
        break label2029;
        label4351:
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
    label1925:
    label1951:
    label1977:
    label2757:
    label3526:
    label3920:
    label4177:
    label4436:
    int i = paramCursor.getColumnIndex("uin");
    label2074:
    label2100:
    label2999:
    label4411:
    label4416:
    label4421:
    label4426:
    label4431:
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("strNick");
      if (i != -1) {
        break label12393;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strNick", String.class));
      i = paramCursor.getColumnIndex("shGender");
      if (i != -1) {
        break label12408;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("shGender", Short.TYPE));
      i = paramCursor.getColumnIndex("shAge");
      if (i != -1) {
        break label12423;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("shAge", Short.TYPE));
      label4591:
      i = paramCursor.getColumnIndex("nFaceID");
      if (i != -1) {
        break label12438;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nFaceID", Integer.TYPE));
      i = paramCursor.getColumnIndex("strCertificationInfo");
      if (i != -1) {
        break label12453;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCertificationInfo", String.class));
      i = paramCursor.getColumnIndex("shType");
      if (i != -1) {
        break label12468;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("shType", Short.TYPE));
      label4696:
      i = paramCursor.getColumnIndex("vContent");
      if (i != -1) {
        break label12483;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vContent", [B.class));
      label4731:
      i = paramCursor.getColumnIndex("strSign");
      if (i != -1) {
        break label12498;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strSign", String.class));
      i = paramCursor.getColumnIndex("strCompany");
      if (i != -1) {
        break label12513;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCompany", String.class));
      i = paramCursor.getColumnIndex("strSchool");
      if (i != -1) {
        break label12528;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strSchool", String.class));
      label4836:
      i = paramCursor.getColumnIndex("uFaceTimeStamp");
      if (i != -1) {
        break label12543;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uFaceTimeStamp", Integer.TYPE));
      i = paramCursor.getColumnIndex("vQQFaceID");
      if (i != -1) {
        break label12558;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vQQFaceID", [B.class));
      i = paramCursor.getColumnIndex("strReMark");
      if (i != -1) {
        break label12573;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strReMark", String.class));
      i = paramCursor.getColumnIndex("bWeiboInfo");
      if (i != -1) {
        break label12588;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bWeiboInfo", Byte.TYPE));
      label4976:
      i = paramCursor.getColumnIndex("bQzoneInfo");
      if (i != -1) {
        break label12604;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bQzoneInfo", Byte.TYPE));
      i = paramCursor.getColumnIndex("nSameFriendsNum");
      if (i != -1) {
        break label12620;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nSameFriendsNum", Integer.TYPE));
      i = paramCursor.getColumnIndex("strCompanySame");
      if (i != -1) {
        break label12635;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCompanySame", String.class));
      label5081:
      i = paramCursor.getColumnIndex("strSchoolSame");
      if (i != -1) {
        break label12650;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strSchoolSame", String.class));
      label5116:
      i = paramCursor.getColumnIndex("lCardShowNum");
      if (i != -1) {
        break label12665;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lCardShowNum", Long.TYPE));
      i = paramCursor.getColumnIndex("bSingle");
      if (i != -1) {
        break label12680;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bSingle", Byte.TYPE));
      i = paramCursor.getColumnIndex("lVisitCount");
      if (i != -1) {
        break label12696;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lVisitCount", Long.TYPE));
      label5221:
      i = paramCursor.getColumnIndex("lVoteCount");
      if (i != -1) {
        break label12711;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lVoteCount", Long.TYPE));
      i = paramCursor.getColumnIndex("tagInfosByte");
      if (i != -1) {
        break label12726;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tagInfosByte", [B.class));
      i = paramCursor.getColumnIndex("eUserIdentityType");
      if (i != -1) {
        break label12741;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("eUserIdentityType", Byte.TYPE));
      i = paramCursor.getColumnIndex("vBackground");
      if (i != -1) {
        break label12757;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vBackground", [B.class));
      label5361:
      i = paramCursor.getColumnIndex("labelInfoBytes");
      if (i != -1) {
        break label12772;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("labelInfoBytes", [B.class));
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label12787;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("age", Byte.TYPE));
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label12803;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("constellation", Integer.TYPE));
      label5466:
      i = paramCursor.getColumnIndex("pyFaceUrl");
      if (i != -1) {
        break label12818;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pyFaceUrl", String.class));
      label5501:
      i = paramCursor.getColumnIndex("location");
      if (i != -1) {
        break label12833;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("location", String.class));
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label12848;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bVoted", Byte.TYPE));
      i = paramCursor.getColumnIndex("bFavorited");
      if (i != -1) {
        break label12864;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bFavorited", Byte.TYPE));
      label5606:
      i = paramCursor.getColumnIndex("iVoteIncrement");
      if (i != -1) {
        break label12880;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iVoteIncrement", Integer.TYPE));
      i = paramCursor.getColumnIndex("strJoinHexAlbumFileKey");
      if (i != -1) {
        break label12895;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strJoinHexAlbumFileKey", String.class));
      i = paramCursor.getColumnIndex("iFaceNum");
      if (i != -1) {
        break label12910;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iFaceNum", Integer.TYPE));
      label5711:
      i = paramCursor.getColumnIndex("cSqqLevel");
      if (i != -1) {
        break label12925;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cSqqLevel", Byte.TYPE));
      label5746:
      i = paramCursor.getColumnIndex("iQQLevel");
      if (i != -1) {
        break label12941;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iQQLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("uCurMulType");
      if (i != -1) {
        break label12956;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uCurMulType", Long.TYPE));
      i = paramCursor.getColumnIndex("strProvince");
      if (i != -1) {
        break label12971;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strProvince", String.class));
      label5851:
      i = paramCursor.getColumnIndex("strCity");
      if (i != -1) {
        break label12986;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCity", String.class));
      label5886:
      i = paramCursor.getColumnIndex("strCountry");
      if (i != -1) {
        break label13001;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCountry", String.class));
      i = paramCursor.getColumnIndex("lBirthday");
      if (i != -1) {
        break label13016;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lBirthday", Long.TYPE));
      i = paramCursor.getColumnIndex("strLocationCodes");
      if (i != -1) {
        break label13031;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strLocationCodes", String.class));
      label5991:
      i = paramCursor.getColumnIndex("strLocationDesc");
      if (i != -1) {
        break label13046;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strLocationDesc", String.class));
      i = paramCursor.getColumnIndex("strHometownCodes");
      if (i != -1) {
        break label13061;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strHometownCodes", String.class));
      i = paramCursor.getColumnIndex("strHometownDesc");
      if (i != -1) {
        break label13076;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strHometownDesc", String.class));
      label6096:
      i = paramCursor.getColumnIndex("strHometownCountry");
      if (i != -1) {
        break label13091;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strHometownCountry", String.class));
      label6131:
      i = paramCursor.getColumnIndex("strHometownProvince");
      if (i != -1) {
        break label13106;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strHometownProvince", String.class));
      i = paramCursor.getColumnIndex("strHometownCity");
      if (i != -1) {
        break label13121;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strHometownCity", String.class));
      i = paramCursor.getColumnIndex("strEmail");
      if (i != -1) {
        break label13136;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strEmail", String.class));
      label6236:
      i = paramCursor.getColumnIndex("strPersonalNote");
      if (i != -1) {
        break label13151;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strPersonalNote", String.class));
      label6271:
      i = paramCursor.getColumnIndex("iProfession");
      if (i != -1) {
        break label13166;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iProfession", Integer.TYPE));
      i = paramCursor.getColumnIndex("bindPhoneInfo");
      if (i != -1) {
        break label13181;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bindPhoneInfo", String.class));
      i = paramCursor.getColumnIndex("bCardInfo");
      if (i != -1) {
        break label13196;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bCardInfo", [B.class));
      label6382:
      i = paramCursor.getColumnIndex("strTroopName");
      if (i != -1) {
        break label13211;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strTroopName", String.class));
      i = paramCursor.getColumnIndex("strTroopNick");
      if (i != -1) {
        break label13226;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strTroopNick", String.class));
      i = paramCursor.getColumnIndex("strMobile");
      if (i != -1) {
        break label13241;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strMobile", String.class));
      label6493:
      i = paramCursor.getColumnIndex("strContactName");
      if (i != -1) {
        break label13256;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strContactName", String.class));
      i = paramCursor.getColumnIndex("ulShowControl");
      if (i != -1) {
        break label13271;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ulShowControl", Integer.TYPE));
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label13286;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("feedPreviewTime", Long.TYPE));
      i = paramCursor.getColumnIndex("strQzoneFeedsDesc");
      if (i != -1) {
        break label13301;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strQzoneFeedsDesc", String.class));
      label6641:
      i = paramCursor.getColumnIndex("StrPresentDesc");
      if (i != -1) {
        break label13316;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("StrPresentDesc", String.class));
      i = paramCursor.getColumnIndex("strSpaceName");
      if (i != -1) {
        break label13331;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strSpaceName", String.class));
      i = paramCursor.getColumnIndex("strQzoneHeader");
      if (i != -1) {
        break label13346;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strQzoneHeader", String.class));
      label6752:
      i = paramCursor.getColumnIndex("vQzonePhotos");
      if (i != -1) {
        break label13361;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vQzonePhotos", [B.class));
      i = paramCursor.getColumnIndex("vQzoneCoverInfo");
      if (i != -1) {
        break label13376;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vQzoneCoverInfo", [B.class));
      i = paramCursor.getColumnIndex("enlargeQzonePic");
      if (i != -1) {
        break label13391;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("enlargeQzonePic", Integer.TYPE));
      label6863:
      i = paramCursor.getColumnIndex("showPublishButton");
      if (i != -1) {
        break label13406;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showPublishButton", Boolean.TYPE));
      i = paramCursor.getColumnIndex("strStatus");
      if (i != -1) {
        break label13433;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strStatus", String.class));
      i = paramCursor.getColumnIndex("strAutoRemark");
      if (i != -1) {
        break label13448;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strAutoRemark", String.class));
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label13463;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vSeed", [B.class));
      label7011:
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label13478;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vCookies", [B.class));
      i = paramCursor.getColumnIndex("hasFakeData");
      if (i != -1) {
        break label13493;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasFakeData", Boolean.TYPE));
      i = paramCursor.getColumnIndex("bQQVipOpen");
      if (i != -1) {
        break label13520;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bQQVipOpen", Byte.TYPE));
      label7122:
      i = paramCursor.getColumnIndex("iQQVipType");
      if (i != -1) {
        break label13536;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iQQVipType", Integer.TYPE));
      label7159:
      i = paramCursor.getColumnIndex("iQQVipLevel");
      if (i != -1) {
        break label13551;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iQQVipLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("nameplateVipType");
      if (i != -1) {
        break label13566;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nameplateVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("grayNameplateFlag");
      if (i != -1) {
        break label13581;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("grayNameplateFlag", Integer.TYPE));
      label7270:
      i = paramCursor.getColumnIndex("bSuperVipOpen");
      if (i != -1) {
        break label13596;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bSuperVipOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iSuperVipType");
      if (i != -1) {
        break label13612;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iSuperVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iSuperVipLevel");
      if (i != -1) {
        break label13627;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iSuperVipLevel", Integer.TYPE));
      label7381:
      i = paramCursor.getColumnIndex("bSuperQQOpen");
      if (i != -1) {
        break label13642;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bSuperQQOpen", Byte.TYPE));
      label7418:
      i = paramCursor.getColumnIndex("iSuperQQType");
      if (i != -1) {
        break label13658;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iSuperQQType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iSuperQQLevel");
      if (i != -1) {
        break label13673;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iSuperQQLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("bHollywoodVipOpen");
      if (i != -1) {
        break label13688;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bHollywoodVipOpen", Byte.TYPE));
      label7529:
      i = paramCursor.getColumnIndex("iHollywoodVipType");
      if (i != -1) {
        break label13704;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iHollywoodVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iHollywoodVipLevel");
      if (i != -1) {
        break label13719;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iHollywoodVipLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("strShowName");
      if (i != -1) {
        break label13734;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strShowName", String.class));
      label7640:
      i = paramCursor.getColumnIndex("vRichSign");
      if (i != -1) {
        break label13749;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vRichSign", [B.class));
      label7677:
      i = paramCursor.getColumnIndex("lSignModifyTime");
      if (i != -1) {
        break label13764;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lSignModifyTime", Long.TYPE));
      i = paramCursor.getColumnIndex("vLongNickTopicInfo");
      if (i != -1) {
        break label13779;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vLongNickTopicInfo", [B.class));
      i = paramCursor.getColumnIndex("lUserFlag");
      if (i != -1) {
        break label13794;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lUserFlag", Long.TYPE));
      label7788:
      i = paramCursor.getColumnIndex("lLoginDays");
      if (i != -1) {
        break label13809;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lLoginDays", Long.TYPE));
      i = paramCursor.getColumnIndex("strLoginDaysDesc");
      if (i != -1) {
        break label13824;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strLoginDaysDesc", String.class));
      i = paramCursor.getColumnIndex("lQQMasterLogindays");
      if (i != -1) {
        break label13839;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lQQMasterLogindays", Long.TYPE));
      label7899:
      i = paramCursor.getColumnIndex("iXManScene1DelayTime");
      if (i != -1) {
        break label13854;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iXManScene1DelayTime", Integer.TYPE));
      i = paramCursor.getColumnIndex("iXManScene2DelayTime");
      if (i != -1) {
        break label13869;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iXManScene2DelayTime", Integer.TYPE));
      i = paramCursor.getColumnIndex("allowPeopleSee");
      if (i != -1) {
        break label13884;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowPeopleSee", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowCalInteractive");
      if (i != -1) {
        break label13911;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowCalInteractive", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showOnlineFriends");
      if (i != -1) {
        break label13938;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showOnlineFriends", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowClick");
      if (i != -1) {
        break label13965;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowClick", Boolean.TYPE));
      i = paramCursor.getColumnIndex("babyQSwitch");
      if (i != -1) {
        break label13992;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("babyQSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isSuperRedDiamond");
      if (i != -1) {
        break label14019;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isSuperRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRedDiamond");
      if (i != -1) {
        break label14046;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("redLevel");
      if (i != -1) {
        break label14073;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("redLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("isSuperYellowDiamond");
      if (i != -1) {
        break label14088;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isSuperYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isYellowDiamond");
      if (i != -1) {
        break label14115;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("yellowLevel");
      if (i != -1) {
        break label14142;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("yellowLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("isSuperGreenDiamond");
      if (i != -1) {
        break label14157;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isSuperGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isGreenDiamond");
      if (i != -1) {
        break label14184;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("greenLevel");
      if (i != -1) {
        break label14211;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("greenLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("templateRet");
      if (i != -1) {
        break label14226;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("templateRet", Integer.TYPE));
      label8528:
      i = paramCursor.getColumnIndex("lCurrentStyleId");
      if (i != -1) {
        break label14241;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lCurrentStyleId", Long.TYPE));
      label8565:
      i = paramCursor.getColumnIndex("lCurrentBgId");
      if (i != -1) {
        break label14256;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lCurrentBgId", Long.TYPE));
      i = paramCursor.getColumnIndex("backgroundUrl");
      if (i != -1) {
        break label14271;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("backgroundUrl", String.class));
      i = paramCursor.getColumnIndex("backgroundColor");
      if (i != -1) {
        break label14286;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("backgroundColor", Long.TYPE));
      label8676:
      i = paramCursor.getColumnIndex("dynamicCardFlag");
      if (i != -1) {
        break label14301;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dynamicCardFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("strZipUrl");
      if (i != -1) {
        break label14316;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strZipUrl", String.class));
      i = paramCursor.getColumnIndex("strActiveUrl");
      if (i != -1) {
        break label14331;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strActiveUrl", String.class));
      label8787:
      i = paramCursor.getColumnIndex("strDrawerCardUrl");
      if (i != -1) {
        break label14346;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strDrawerCardUrl", String.class));
      label8824:
      i = paramCursor.getColumnIndex("strWzryHeroUrl");
      if (i != -1) {
        break label14361;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strWzryHeroUrl", String.class));
      i = paramCursor.getColumnIndex("wzryHonorInfo");
      if (i != -1) {
        break label14376;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wzryHonorInfo", [B.class));
      i = paramCursor.getColumnIndex("strExtInfo");
      if (i != -1) {
        break label14391;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strExtInfo", String.class));
      label8935:
      i = paramCursor.getColumnIndex("strCurrentBgUrl");
      if (i != -1) {
        break label14406;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCurrentBgUrl", String.class));
      i = paramCursor.getColumnIndex("bgType");
      if (i != -1) {
        break label14421;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bgType", [B.class));
      i = paramCursor.getColumnIndex("encId");
      if (i != -1) {
        break label14436;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("encId", String.class));
      label9046:
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label14451;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("busiEntry", String.class));
      label9083:
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label14466;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("favoriteSource", Integer.TYPE));
      i = paramCursor.getColumnIndex("visibleMusicPendant");
      if (i != -1) {
        break label14481;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("visibleMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("autoPlayMusicPendant");
      if (i != -1) {
        break label14508;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("autoPlayMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showRedPointMusicPendant");
      if (i != -1) {
        break label14535;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showRedPointMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("privilegePromptStr");
      if (i != -1) {
        break label14562;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("privilegePromptStr", String.class));
      i = paramCursor.getColumnIndex("privilegeJumpUrl");
      if (i != -1) {
        break label14577;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("privilegeJumpUrl", String.class));
      label9305:
      i = paramCursor.getColumnIndex("vOpenPriv");
      if (i != -1) {
        break label14592;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vOpenPriv", [B.class));
      label9342:
      i = paramCursor.getColumnIndex("vClosePriv");
      if (i != -1) {
        break label14607;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vClosePriv", [B.class));
      i = paramCursor.getColumnIndex("presentDesc");
      if (i != -1) {
        break label14622;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("presentDesc", String.class));
      i = paramCursor.getColumnIndex("presentCustourl");
      if (i != -1) {
        break label14637;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("presentCustourl", String.class));
      label9453:
      i = paramCursor.getColumnIndex("presentSwitch");
      if (i != -1) {
        break label14652;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("presentSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showPresent");
      if (i != -1) {
        break label14679;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showPresent", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showMusicBox");
      if (i != -1) {
        break label14706;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showMusicBox", Boolean.TYPE));
      i = paramCursor.getColumnIndex("addSrcName");
      if (i != -1) {
        break label14733;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("addSrcName", String.class));
      i = paramCursor.getColumnIndex("addSrcId");
      if (i != -1) {
        break label14748;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("addSrcId", Long.TYPE));
      i = paramCursor.getColumnIndex("addSubSrcId");
      if (i != -1) {
        break label14763;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("addSubSrcId", Long.TYPE));
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label14778;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strVoteLimitedNotice", String.class));
      label9712:
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label14793;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label14808;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      i = paramCursor.getColumnIndex("mNowShowFlag");
      if (i != -1) {
        break label14823;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mNowShowFlag", Integer.TYPE));
      label9823:
      i = paramCursor.getColumnIndex("mNowShowIconUrl");
      if (i != -1) {
        break label14838;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mNowShowIconUrl", String.class));
      i = paramCursor.getColumnIndex("mNowShowJumpUrl");
      if (i != -1) {
        break label14853;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mNowShowJumpUrl", String.class));
      i = paramCursor.getColumnIndex("vCoverInfo");
      if (i != -1) {
        break label14868;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vCoverInfo", [B.class));
      i = paramCursor.getColumnIndex("medalSwitchDisable");
      if (i != -1) {
        break label14883;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("medalSwitchDisable", Boolean.TYPE));
      i = paramCursor.getColumnIndex("iMedalCount");
      if (i != -1) {
        break label14910;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iMedalCount", Integer.TYPE));
      i = paramCursor.getColumnIndex("iNewCount");
      if (i != -1) {
        break label14925;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iNewCount", Integer.TYPE));
      i = paramCursor.getColumnIndex("iUpgradeCount");
      if (i != -1) {
        break label14940;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iUpgradeCount", Integer.TYPE));
      label10082:
      i = paramCursor.getColumnIndex("strPromptParams");
      if (i != -1) {
        break label14955;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strPromptParams", String.class));
      i = paramCursor.getColumnIndex("hobbyEntry");
      if (i != -1) {
        break label14970;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hobbyEntry", String.class));
      i = paramCursor.getColumnIndex("lastPraiseInfoList");
      if (i != -1) {
        break label14985;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastPraiseInfoList", [B.class));
      label10193:
      i = paramCursor.getColumnIndex("tempChatSig");
      if (i != -1) {
        break label15000;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tempChatSig", [B.class));
      label10230:
      i = paramCursor.getColumnIndex("namePlateOfKingGameId");
      if (i != -1) {
        break label15015;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingGameId", Long.TYPE));
      i = paramCursor.getColumnIndex("namePlateOfKingLoginTime");
      if (i != -1) {
        break label15030;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingLoginTime", Long.TYPE));
      i = paramCursor.getColumnIndex("namePlateOfKingDan");
      if (i != -1) {
        break label15045;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingDan", Integer.TYPE));
      label10341:
      i = paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch");
      if (i != -1) {
        break label15060;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingDanDisplatSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("vPersonalityLabelV2");
      if (i != -1) {
        break label15087;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vPersonalityLabelV2", [B.class));
      i = paramCursor.getColumnIndex("cardType");
      if (i != -1) {
        break label15102;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cardType", Integer.TYPE));
      label10452:
      i = paramCursor.getColumnIndex("diyText");
      if (i != -1) {
        break label15117;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyText", String.class));
      label10489:
      i = paramCursor.getColumnIndex("diyTextFontId");
      if (i != -1) {
        break label15132;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextFontId", Integer.TYPE));
      i = paramCursor.getColumnIndex("diyTextWidth");
      if (i != -1) {
        break label15147;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextWidth", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextHeight");
      if (i != -1) {
        break label15162;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextHeight", Float.TYPE));
      label10600:
      i = paramCursor.getColumnIndex("diyTextLocX");
      if (i != -1) {
        break label15177;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextLocX", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextLocY");
      if (i != -1) {
        break label15192;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextLocY", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextDegree");
      if (i != -1) {
        break label15207;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextDegree", Float.TYPE));
      label10711:
      i = paramCursor.getColumnIndex("diyTextScale");
      if (i != -1) {
        break label15222;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextScale", Float.TYPE));
      label10748:
      i = paramCursor.getColumnIndex("diyTextTransparency");
      if (i != -1) {
        break label15237;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextTransparency", Float.TYPE));
      i = paramCursor.getColumnIndex("diyDefaultText");
      if (i != -1) {
        break label15252;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyDefaultText", String.class));
      i = paramCursor.getColumnIndex("popularity");
      if (i != -1) {
        break label15267;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("popularity", Integer.TYPE));
      label10859:
      i = paramCursor.getColumnIndex("declaration");
      if (i != -1) {
        break label15282;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("declaration", String.class));
      i = paramCursor.getColumnIndex("voiceUrl");
      if (i != -1) {
        break label15297;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("voiceUrl", String.class));
      i = paramCursor.getColumnIndex("isShowCard");
      if (i != -1) {
        break label15312;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isShowCard", Boolean.TYPE));
      i = paramCursor.getColumnIndex("updateTime");
      if (i != -1) {
        break label15339;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("updateTime", Long.TYPE));
      label11007:
      i = paramCursor.getColumnIndex("extendFriendFlag");
      if (i != -1) {
        break label15354;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendFriendFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("extendFriendVoiceDuration");
      if (i != -1) {
        break label15369;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendFriendVoiceDuration", Integer.TYPE));
      i = paramCursor.getColumnIndex("extendFriendEntryContact");
      if (i != -1) {
        break label15384;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendFriendEntryContact", Short.TYPE));
      label11118:
      i = paramCursor.getColumnIndex("extendFriendEntryAddFriend");
      if (i != -1) {
        break label15399;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendFriendEntryAddFriend", Short.TYPE));
      i = paramCursor.getColumnIndex("extendFriendQuestion");
      if (i != -1) {
        break label15414;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendFriendQuestion", Short.TYPE));
      i = paramCursor.getColumnIndex("fontId");
      if (i != -1) {
        break label15429;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("fontId", Integer.TYPE));
      label11229:
      i = paramCursor.getColumnIndex("fontType");
      if (i != -1) {
        break label15444;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("fontType", Integer.TYPE));
      i = paramCursor.getColumnIndex("clothesId");
      if (i != -1) {
        break label15459;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("clothesId", Integer.TYPE));
      i = paramCursor.getColumnIndex("schoolId");
      if (i != -1) {
        break label15474;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("schoolId", String.class));
      i = paramCursor.getColumnIndex("schoolName");
      if (i != -1) {
        break label15489;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("schoolName", String.class));
      label11377:
      i = paramCursor.getColumnIndex("authState");
      if (i != -1) {
        break label15504;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("authState", Long.TYPE));
      i = paramCursor.getColumnIndex("idx");
      if (i != -1) {
        break label15519;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("idx", Integer.TYPE));
      i = paramCursor.getColumnIndex("category");
      if (i != -1) {
        break label15534;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("category", Integer.TYPE));
      label11488:
      i = paramCursor.getColumnIndex("isShowMiniPlaying");
      if (i != -1) {
        break label15549;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isShowMiniPlaying", Boolean.TYPE));
      i = paramCursor.getColumnIndex("tabJumpUrl");
      if (i != -1) {
        break label15576;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tabJumpUrl", String.class));
      i = paramCursor.getColumnIndex("guestJumpUrl");
      if (i != -1) {
        break label15591;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guestJumpUrl", String.class));
      label11599:
      i = paramCursor.getColumnIndex("guestAppTotal");
      if (i != -1) {
        break label15606;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guestAppTotal", Integer.TYPE));
      label11636:
      i = paramCursor.getColumnIndex("defaultCardId");
      if (i != -1) {
        break label15621;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("defaultCardId", Integer.TYPE));
      i = paramCursor.getColumnIndex("strangerVoteOpen");
      if (i != -1) {
        break label15636;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strangerVoteOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("lSuperVipTemplateId");
      if (i != -1) {
        break label15663;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lSuperVipTemplateId", Long.TYPE));
      label11747:
      i = paramCursor.getColumnIndex("bBigClubVipOpen");
      if (i != -1) {
        break label15678;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bBigClubVipOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iBigClubVipType");
      if (i != -1) {
        break label15694;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iBigClubVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iBigClubVipLevel");
      if (i != -1) {
        break label15709;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iBigClubVipLevel", Integer.TYPE));
      label11858:
      i = paramCursor.getColumnIndex("lBigClubTemplateId");
      if (i != -1) {
        break label15724;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lBigClubTemplateId", Long.TYPE));
      label11895:
      i = paramCursor.getColumnIndex("diyComplicatedInfo");
      if (i != -1) {
        break label15739;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyComplicatedInfo", String.class));
      i = paramCursor.getColumnIndex("cardId");
      if (i != -1) {
        break label15754;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cardId", Long.TYPE));
      i = paramCursor.getColumnIndex("strangerInviteMeGroupOpen");
      if (i != -1) {
        break label15769;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strangerInviteMeGroupOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isPrettyGroupOwner");
      if (i != -1) {
        break label15796;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isPrettyGroupOwner", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isHidePrettyGroutIdentity");
      if (i != -1) {
        break label15823;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isHidePrettyGroutIdentity", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mQQLevelType");
      if (i != -1) {
        break label15850;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mQQLevelType", Integer.TYPE));
      label12117:
      i = paramCursor.getColumnIndex("schoolVerifiedFlag");
      if (i != -1) {
        break label15865;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("schoolVerifiedFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("troopHonorSwitch");
      if (i != -1) {
        break label15892;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopHonorSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("lhLevel");
      if (i != -1) {
        break label15920;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lhLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("qid");
      if (i != -1) {
        break label15935;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qid", String.class));
      label12265:
      i = paramCursor.getColumnIndex("qidColor");
      if (i != -1) {
        break label15950;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qidColor", String.class));
      i = paramCursor.getColumnIndex("qidLogoUrl");
      if (i != -1) {
        break label15965;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qidLogoUrl", String.class));
    }
    for (;;)
    {
      label2565:
      label2591:
      label2731:
      label4396:
      label4401:
      label4406:
      label4556:
      label4941:
      label5326:
      i = paramCursor.getColumnIndex("qidBgUrl");
      label3215:
      label4132:
      label4391:
      label4521:
      label4661:
      label4801:
      label5186:
      label5571:
      label5956:
      label6345:
      label6604:
      label8269:
      label9934:
      if (i != -1) {
        break label15980;
      }
      label4106:
      label4366:
      label4371:
      label4376:
      label4381:
      label4386:
      label4906:
      label5046:
      label5431:
      label5816:
      label6201:
      label6715:
      label6974:
      label7233:
      label7492:
      label7751:
      label9416:
      label9675:
      label11340:
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qidBgUrl", String.class));
      label4356:
      label4361:
      label4626:
      label4766:
      label5151:
      label5291:
      label5676:
      label6061:
      label6456:
      label8380:
      label8639:
      label8898:
      label10563:
      label10822:
      label11081:
      return paramEntity;
      label4871:
      label5011:
      label5396:
      label5536:
      label5921:
      label6308:
      label6567:
      label6826:
      label7344:
      label7603:
      label7862:
      label9786:
      label10045:
      label10304:
      label11969:
      label12228:
      paramEntity.uin = paramCursor.getString(i);
      label5256:
      label5641:
      label5781:
      label6166:
      label6937:
      label7196:
      label7455:
      label7714:
      label7973:
      label8491:
      label8750:
      label9009:
      label9268:
      label10933:
      label11192:
      label11451:
      break;
      label6026:
      label6419:
      label6678:
      label8602:
      label8861:
      label9120:
      label9379:
      label9638:
      label9897:
      label10156:
      label10415:
      label10674:
      label12393:
      paramEntity.strNick = paramCursor.getString(i);
      label6530:
      label6789:
      label7048:
      label7307:
      label7566:
      label7825:
      label9749:
      label10008:
      label10267:
      label10526:
      label10785:
      label11044:
      label11303:
      label11562:
      label11821:
      break label4521;
      label7936:
      label8713:
      label8972:
      label10637:
      label10896:
      label11155:
      label11414:
      label11673:
      label11932:
      label12408:
      paramEntity.shGender = paramCursor.getShort(i);
      label9601:
      label9860:
      label10119:
      label11784:
      label12302:
      break label4556;
      label11266:
      label12423:
      paramEntity.shAge = paramCursor.getShort(i);
      break label4591;
      label12438:
      paramEntity.nFaceID = paramCursor.getInt(i);
      break label4626;
      label12453:
      paramEntity.strCertificationInfo = paramCursor.getString(i);
      break label4661;
      label12468:
      paramEntity.shType = paramCursor.getShort(i);
      break label4696;
      label12483:
      paramEntity.vContent = paramCursor.getBlob(i);
      break label4731;
      label12498:
      paramEntity.strSign = paramCursor.getString(i);
      break label4766;
      label12513:
      paramEntity.strCompany = paramCursor.getString(i);
      break label4801;
      label12528:
      paramEntity.strSchool = paramCursor.getString(i);
      break label4836;
      label12543:
      paramEntity.uFaceTimeStamp = paramCursor.getInt(i);
      break label4871;
      label12558:
      paramEntity.vQQFaceID = paramCursor.getBlob(i);
      break label4906;
      label12573:
      paramEntity.strReMark = paramCursor.getString(i);
      break label4941;
      label12588:
      paramEntity.bWeiboInfo = ((byte)paramCursor.getShort(i));
      break label4976;
      label12604:
      paramEntity.bQzoneInfo = ((byte)paramCursor.getShort(i));
      break label5011;
      label12620:
      paramEntity.nSameFriendsNum = paramCursor.getInt(i);
      break label5046;
      label12635:
      paramEntity.strCompanySame = paramCursor.getString(i);
      break label5081;
      label12650:
      paramEntity.strSchoolSame = paramCursor.getString(i);
      break label5116;
      label12665:
      paramEntity.lCardShowNum = paramCursor.getLong(i);
      break label5151;
      label12680:
      paramEntity.bSingle = ((byte)paramCursor.getShort(i));
      break label5186;
      label12696:
      paramEntity.lVisitCount = paramCursor.getLong(i);
      break label5221;
      label12711:
      paramEntity.lVoteCount = paramCursor.getLong(i);
      break label5256;
      label12726:
      paramEntity.tagInfosByte = paramCursor.getBlob(i);
      break label5291;
      label12741:
      paramEntity.eUserIdentityType = ((byte)paramCursor.getShort(i));
      break label5326;
      label12757:
      paramEntity.vBackground = paramCursor.getBlob(i);
      break label5361;
      label12772:
      paramEntity.labelInfoBytes = paramCursor.getBlob(i);
      break label5396;
      label12787:
      paramEntity.age = ((byte)paramCursor.getShort(i));
      break label5431;
      label12803:
      paramEntity.constellation = paramCursor.getInt(i);
      break label5466;
      label12818:
      paramEntity.pyFaceUrl = paramCursor.getString(i);
      break label5501;
      label12833:
      paramEntity.location = paramCursor.getString(i);
      break label5536;
      label12848:
      paramEntity.bVoted = ((byte)paramCursor.getShort(i));
      break label5571;
      label12864:
      paramEntity.bFavorited = ((byte)paramCursor.getShort(i));
      break label5606;
      label12880:
      paramEntity.iVoteIncrement = paramCursor.getInt(i);
      break label5641;
      label12895:
      paramEntity.strJoinHexAlbumFileKey = paramCursor.getString(i);
      break label5676;
      label12910:
      paramEntity.iFaceNum = paramCursor.getInt(i);
      break label5711;
      label12925:
      paramEntity.cSqqLevel = ((byte)paramCursor.getShort(i));
      break label5746;
      label12941:
      paramEntity.iQQLevel = paramCursor.getInt(i);
      break label5781;
      label12956:
      paramEntity.uCurMulType = paramCursor.getLong(i);
      break label5816;
      label12971:
      paramEntity.strProvince = paramCursor.getString(i);
      break label5851;
      label12986:
      paramEntity.strCity = paramCursor.getString(i);
      break label5886;
      label13001:
      paramEntity.strCountry = paramCursor.getString(i);
      break label5921;
      label13016:
      paramEntity.lBirthday = paramCursor.getLong(i);
      break label5956;
      label13031:
      paramEntity.strLocationCodes = paramCursor.getString(i);
      break label5991;
      label13046:
      paramEntity.strLocationDesc = paramCursor.getString(i);
      break label6026;
      label13061:
      paramEntity.strHometownCodes = paramCursor.getString(i);
      break label6061;
      label13076:
      paramEntity.strHometownDesc = paramCursor.getString(i);
      break label6096;
      label13091:
      paramEntity.strHometownCountry = paramCursor.getString(i);
      break label6131;
      label13106:
      paramEntity.strHometownProvince = paramCursor.getString(i);
      break label6166;
      label13121:
      paramEntity.strHometownCity = paramCursor.getString(i);
      break label6201;
      label13136:
      paramEntity.strEmail = paramCursor.getString(i);
      break label6236;
      label13151:
      paramEntity.strPersonalNote = paramCursor.getString(i);
      break label6271;
      label13166:
      paramEntity.iProfession = paramCursor.getInt(i);
      break label6308;
      label13181:
      paramEntity.bindPhoneInfo = paramCursor.getString(i);
      break label6345;
      label13196:
      paramEntity.bCardInfo = paramCursor.getBlob(i);
      break label6382;
      label13211:
      paramEntity.strTroopName = paramCursor.getString(i);
      break label6419;
      label13226:
      paramEntity.strTroopNick = paramCursor.getString(i);
      break label6456;
      label13241:
      paramEntity.strMobile = paramCursor.getString(i);
      break label6493;
      label13256:
      paramEntity.strContactName = paramCursor.getString(i);
      break label6530;
      label13271:
      paramEntity.ulShowControl = paramCursor.getInt(i);
      break label6567;
      label13286:
      paramEntity.feedPreviewTime = paramCursor.getLong(i);
      break label6604;
      label13301:
      paramEntity.strQzoneFeedsDesc = paramCursor.getString(i);
      break label6641;
      label13316:
      paramEntity.StrPresentDesc = paramCursor.getString(i);
      break label6678;
      label13331:
      paramEntity.strSpaceName = paramCursor.getString(i);
      break label6715;
      label13346:
      paramEntity.strQzoneHeader = paramCursor.getString(i);
      break label6752;
      label13361:
      paramEntity.vQzonePhotos = paramCursor.getBlob(i);
      break label6789;
      label13376:
      paramEntity.vQzoneCoverInfo = paramCursor.getBlob(i);
      break label6826;
      label13391:
      paramEntity.enlargeQzonePic = paramCursor.getInt(i);
      break label6863;
      label13406:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showPublishButton = paramBoolean;
        break;
      }
      label13433:
      paramEntity.strStatus = paramCursor.getString(i);
      break label6937;
      label13448:
      paramEntity.strAutoRemark = paramCursor.getString(i);
      break label6974;
      label13463:
      paramEntity.vSeed = paramCursor.getBlob(i);
      break label7011;
      label13478:
      paramEntity.vCookies = paramCursor.getBlob(i);
      break label7048;
      label13493:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasFakeData = paramBoolean;
        break;
      }
      label13520:
      paramEntity.bQQVipOpen = ((byte)paramCursor.getShort(i));
      break label7122;
      label13536:
      paramEntity.iQQVipType = paramCursor.getInt(i);
      break label7159;
      label13551:
      paramEntity.iQQVipLevel = paramCursor.getInt(i);
      break label7196;
      label13566:
      paramEntity.nameplateVipType = paramCursor.getInt(i);
      break label7233;
      label13581:
      paramEntity.grayNameplateFlag = paramCursor.getInt(i);
      break label7270;
      label13596:
      paramEntity.bSuperVipOpen = ((byte)paramCursor.getShort(i));
      break label7307;
      label13612:
      paramEntity.iSuperVipType = paramCursor.getInt(i);
      break label7344;
      label13627:
      paramEntity.iSuperVipLevel = paramCursor.getInt(i);
      break label7381;
      label13642:
      paramEntity.bSuperQQOpen = ((byte)paramCursor.getShort(i));
      break label7418;
      label13658:
      paramEntity.iSuperQQType = paramCursor.getInt(i);
      break label7455;
      label13673:
      paramEntity.iSuperQQLevel = paramCursor.getInt(i);
      break label7492;
      label13688:
      paramEntity.bHollywoodVipOpen = ((byte)paramCursor.getShort(i));
      break label7529;
      label13704:
      paramEntity.iHollywoodVipType = paramCursor.getInt(i);
      break label7566;
      label13719:
      paramEntity.iHollywoodVipLevel = paramCursor.getInt(i);
      break label7603;
      label13734:
      paramEntity.strShowName = paramCursor.getString(i);
      break label7640;
      label13749:
      paramEntity.vRichSign = paramCursor.getBlob(i);
      break label7677;
      label13764:
      paramEntity.lSignModifyTime = paramCursor.getLong(i);
      break label7714;
      label13779:
      paramEntity.vLongNickTopicInfo = paramCursor.getBlob(i);
      break label7751;
      label13794:
      paramEntity.lUserFlag = paramCursor.getLong(i);
      break label7788;
      label13809:
      paramEntity.lLoginDays = paramCursor.getLong(i);
      break label7825;
      label13824:
      paramEntity.strLoginDaysDesc = paramCursor.getString(i);
      break label7862;
      label13839:
      paramEntity.lQQMasterLogindays = paramCursor.getLong(i);
      break label7899;
      label13854:
      paramEntity.iXManScene1DelayTime = paramCursor.getInt(i);
      break label7936;
      label13869:
      paramEntity.iXManScene2DelayTime = paramCursor.getInt(i);
      break label7973;
      label13884:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowPeopleSee = paramBoolean;
        break;
      }
      label13911:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowCalInteractive = paramBoolean;
        break;
      }
      label13938:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showOnlineFriends = paramBoolean;
        break;
      }
      label13965:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowClick = paramBoolean;
        break;
      }
      label13992:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.babyQSwitch = paramBoolean;
        break;
      }
      label14019:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperRedDiamond = paramBoolean;
        break;
      }
      label14046:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isRedDiamond = paramBoolean;
        break;
      }
      label14073:
      paramEntity.redLevel = paramCursor.getInt(i);
      break label8269;
      label14088:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperYellowDiamond = paramBoolean;
        break;
      }
      label14115:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isYellowDiamond = paramBoolean;
        break;
      }
      label14142:
      paramEntity.yellowLevel = paramCursor.getInt(i);
      break label8380;
      label14157:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperGreenDiamond = paramBoolean;
        break;
      }
      label14184:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isGreenDiamond = paramBoolean;
        break;
      }
      label14211:
      paramEntity.greenLevel = paramCursor.getInt(i);
      break label8491;
      label14226:
      paramEntity.templateRet = paramCursor.getInt(i);
      break label8528;
      label14241:
      paramEntity.lCurrentStyleId = paramCursor.getLong(i);
      break label8565;
      label14256:
      paramEntity.lCurrentBgId = paramCursor.getLong(i);
      break label8602;
      label14271:
      paramEntity.backgroundUrl = paramCursor.getString(i);
      break label8639;
      label14286:
      paramEntity.backgroundColor = paramCursor.getLong(i);
      break label8676;
      label14301:
      paramEntity.dynamicCardFlag = paramCursor.getInt(i);
      break label8713;
      label14316:
      paramEntity.strZipUrl = paramCursor.getString(i);
      break label8750;
      label14331:
      paramEntity.strActiveUrl = paramCursor.getString(i);
      break label8787;
      label14346:
      paramEntity.strDrawerCardUrl = paramCursor.getString(i);
      break label8824;
      label14361:
      paramEntity.strWzryHeroUrl = paramCursor.getString(i);
      break label8861;
      label14376:
      paramEntity.wzryHonorInfo = paramCursor.getBlob(i);
      break label8898;
      label14391:
      paramEntity.strExtInfo = paramCursor.getString(i);
      break label8935;
      label14406:
      paramEntity.strCurrentBgUrl = paramCursor.getString(i);
      break label8972;
      label14421:
      paramEntity.bgType = paramCursor.getBlob(i);
      break label9009;
      label14436:
      paramEntity.encId = paramCursor.getString(i);
      break label9046;
      label14451:
      paramEntity.busiEntry = paramCursor.getString(i);
      break label9083;
      label14466:
      paramEntity.favoriteSource = paramCursor.getInt(i);
      break label9120;
      label14481:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.visibleMusicPendant = paramBoolean;
        break;
      }
      label14508:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.autoPlayMusicPendant = paramBoolean;
        break;
      }
      label14535:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showRedPointMusicPendant = paramBoolean;
        break;
      }
      label14562:
      paramEntity.privilegePromptStr = paramCursor.getString(i);
      break label9268;
      label14577:
      paramEntity.privilegeJumpUrl = paramCursor.getString(i);
      break label9305;
      label14592:
      paramEntity.vOpenPriv = paramCursor.getBlob(i);
      break label9342;
      label14607:
      paramEntity.vClosePriv = paramCursor.getBlob(i);
      break label9379;
      label14622:
      paramEntity.presentDesc = paramCursor.getString(i);
      break label9416;
      label14637:
      paramEntity.presentCustourl = paramCursor.getString(i);
      break label9453;
      label14652:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.presentSwitch = paramBoolean;
        break;
      }
      label14679:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showPresent = paramBoolean;
        break;
      }
      label14706:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showMusicBox = paramBoolean;
        break;
      }
      label14733:
      paramEntity.addSrcName = paramCursor.getString(i);
      break label9601;
      label14748:
      paramEntity.addSrcId = paramCursor.getLong(i);
      break label9638;
      label14763:
      paramEntity.addSubSrcId = paramCursor.getLong(i);
      break label9675;
      label14778:
      paramEntity.strVoteLimitedNotice = paramCursor.getString(i);
      break label9712;
      label14793:
      paramEntity.bHaveVotedCnt = paramCursor.getShort(i);
      break label9749;
      label14808:
      paramEntity.bAvailVoteCnt = paramCursor.getShort(i);
      break label9786;
      label14823:
      paramEntity.mNowShowFlag = paramCursor.getInt(i);
      break label9823;
      label14838:
      paramEntity.mNowShowIconUrl = paramCursor.getString(i);
      break label9860;
      label14853:
      paramEntity.mNowShowJumpUrl = paramCursor.getString(i);
      break label9897;
      label14868:
      paramEntity.vCoverInfo = paramCursor.getBlob(i);
      break label9934;
      label14883:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.medalSwitchDisable = paramBoolean;
        break;
      }
      label14910:
      paramEntity.iMedalCount = paramCursor.getInt(i);
      break label10008;
      label14925:
      paramEntity.iNewCount = paramCursor.getInt(i);
      break label10045;
      label14940:
      paramEntity.iUpgradeCount = paramCursor.getInt(i);
      break label10082;
      label14955:
      paramEntity.strPromptParams = paramCursor.getString(i);
      break label10119;
      label14970:
      paramEntity.hobbyEntry = paramCursor.getString(i);
      break label10156;
      label14985:
      paramEntity.lastPraiseInfoList = paramCursor.getBlob(i);
      break label10193;
      label15000:
      paramEntity.tempChatSig = paramCursor.getBlob(i);
      break label10230;
      label15015:
      paramEntity.namePlateOfKingGameId = paramCursor.getLong(i);
      break label10267;
      label15030:
      paramEntity.namePlateOfKingLoginTime = paramCursor.getLong(i);
      break label10304;
      label15045:
      paramEntity.namePlateOfKingDan = paramCursor.getInt(i);
      break label10341;
      label15060:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.namePlateOfKingDanDisplatSwitch = paramBoolean;
        break;
      }
      label15087:
      paramEntity.vPersonalityLabelV2 = paramCursor.getBlob(i);
      break label10415;
      label15102:
      paramEntity.cardType = paramCursor.getInt(i);
      break label10452;
      label15117:
      paramEntity.diyText = paramCursor.getString(i);
      break label10489;
      label15132:
      paramEntity.diyTextFontId = paramCursor.getInt(i);
      break label10526;
      label15147:
      paramEntity.diyTextWidth = paramCursor.getFloat(i);
      break label10563;
      label15162:
      paramEntity.diyTextHeight = paramCursor.getFloat(i);
      break label10600;
      label15177:
      paramEntity.diyTextLocX = paramCursor.getFloat(i);
      break label10637;
      label15192:
      paramEntity.diyTextLocY = paramCursor.getFloat(i);
      break label10674;
      label15207:
      paramEntity.diyTextDegree = paramCursor.getFloat(i);
      break label10711;
      label15222:
      paramEntity.diyTextScale = paramCursor.getFloat(i);
      break label10748;
      label15237:
      paramEntity.diyTextTransparency = paramCursor.getFloat(i);
      break label10785;
      label15252:
      paramEntity.diyDefaultText = paramCursor.getString(i);
      break label10822;
      label15267:
      paramEntity.popularity = paramCursor.getInt(i);
      break label10859;
      label15282:
      paramEntity.declaration = paramCursor.getString(i);
      break label10896;
      label15297:
      paramEntity.voiceUrl = paramCursor.getString(i);
      break label10933;
      label15312:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isShowCard = paramBoolean;
        break;
      }
      label15339:
      paramEntity.updateTime = paramCursor.getLong(i);
      break label11007;
      label15354:
      paramEntity.extendFriendFlag = paramCursor.getInt(i);
      break label11044;
      label15369:
      paramEntity.extendFriendVoiceDuration = paramCursor.getInt(i);
      break label11081;
      label15384:
      paramEntity.extendFriendEntryContact = paramCursor.getShort(i);
      break label11118;
      label15399:
      paramEntity.extendFriendEntryAddFriend = paramCursor.getShort(i);
      break label11155;
      label15414:
      paramEntity.extendFriendQuestion = paramCursor.getShort(i);
      break label11192;
      label15429:
      paramEntity.fontId = paramCursor.getInt(i);
      break label11229;
      label15444:
      paramEntity.fontType = paramCursor.getInt(i);
      break label11266;
      label15459:
      paramEntity.clothesId = paramCursor.getInt(i);
      break label11303;
      label15474:
      paramEntity.schoolId = paramCursor.getString(i);
      break label11340;
      label15489:
      paramEntity.schoolName = paramCursor.getString(i);
      break label11377;
      label15504:
      paramEntity.authState = paramCursor.getLong(i);
      break label11414;
      label15519:
      paramEntity.idx = paramCursor.getInt(i);
      break label11451;
      label15534:
      paramEntity.category = paramCursor.getInt(i);
      break label11488;
      label15549:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isShowMiniPlaying = paramBoolean;
        break;
      }
      label15576:
      paramEntity.tabJumpUrl = paramCursor.getString(i);
      break label11562;
      label15591:
      paramEntity.guestJumpUrl = paramCursor.getString(i);
      break label11599;
      label15606:
      paramEntity.guestAppTotal = paramCursor.getInt(i);
      break label11636;
      label15621:
      paramEntity.defaultCardId = paramCursor.getInt(i);
      break label11673;
      label15636:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.strangerVoteOpen = paramBoolean;
        break;
      }
      label15663:
      paramEntity.lSuperVipTemplateId = paramCursor.getLong(i);
      break label11747;
      label15678:
      paramEntity.bBigClubVipOpen = ((byte)paramCursor.getShort(i));
      break label11784;
      label15694:
      paramEntity.iBigClubVipType = paramCursor.getInt(i);
      break label11821;
      label15709:
      paramEntity.iBigClubVipLevel = paramCursor.getInt(i);
      break label11858;
      label15724:
      paramEntity.lBigClubTemplateId = paramCursor.getLong(i);
      break label11895;
      label15739:
      paramEntity.diyComplicatedInfo = paramCursor.getString(i);
      break label11932;
      label15754:
      paramEntity.cardId = paramCursor.getLong(i);
      break label11969;
      label15769:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.strangerInviteMeGroupOpen = paramBoolean;
        break;
      }
      label15796:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isPrettyGroupOwner = paramBoolean;
        break;
      }
      label15823:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isHidePrettyGroutIdentity = paramBoolean;
        break;
      }
      label15850:
      paramEntity.mQQLevelType = paramCursor.getInt(i);
      break label12117;
      label15865:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.schoolVerifiedFlag = paramBoolean;
        break;
      }
      label15892:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.troopHonorSwitch = paramBoolean;
        break;
      }
      label15920:
      paramEntity.lhLevel = paramCursor.getInt(i);
      break label12228;
      label15935:
      paramEntity.qid = paramCursor.getString(i);
      break label12265;
      label15950:
      paramEntity.qidColor = paramCursor.getString(i);
      break label12302;
      label15965:
      paramEntity.qidLogoUrl = paramCursor.getString(i);
    }
    label15980:
    paramEntity.qidBgUrl = paramCursor.getString(i);
    return paramEntity;
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
    paramContentValues.put("lhLevel", Integer.valueOf(paramEntity.lhLevel));
    paramContentValues.put("qid", paramEntity.qid);
    paramContentValues.put("qidColor", paramEntity.qidColor);
    paramContentValues.put("qidLogoUrl", paramEntity.qidLogoUrl);
    paramContentValues.put("qidBgUrl", paramEntity.qidBgUrl);
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,strNick TEXT ,shGender INTEGER ,shAge INTEGER ,nFaceID INTEGER ,strCertificationInfo TEXT ,shType INTEGER ,vContent BLOB ,strSign TEXT ,strCompany TEXT ,strSchool TEXT ,uFaceTimeStamp INTEGER ,vQQFaceID BLOB ,strReMark TEXT ,bWeiboInfo INTEGER ,bQzoneInfo INTEGER ,nSameFriendsNum INTEGER ,strCompanySame TEXT ,strSchoolSame TEXT ,lCardShowNum INTEGER ,bSingle INTEGER ,lVisitCount INTEGER ,lVoteCount INTEGER ,tagInfosByte BLOB ,eUserIdentityType INTEGER ,vBackground BLOB ,labelInfoBytes BLOB ,age INTEGER ,constellation INTEGER ,pyFaceUrl TEXT ,location TEXT ,bVoted INTEGER ,bFavorited INTEGER ,iVoteIncrement INTEGER ,strJoinHexAlbumFileKey TEXT ,iFaceNum INTEGER ,cSqqLevel INTEGER ,iQQLevel INTEGER ,uCurMulType INTEGER ,strProvince TEXT ,strCity TEXT ,strCountry TEXT ,lBirthday INTEGER ,strLocationCodes TEXT ,strLocationDesc TEXT ,strHometownCodes TEXT ,strHometownDesc TEXT ,strHometownCountry TEXT ,strHometownProvince TEXT ,strHometownCity TEXT ,strEmail TEXT ,strPersonalNote TEXT ,iProfession INTEGER ,bindPhoneInfo TEXT ,bCardInfo BLOB ,strTroopName TEXT ,strTroopNick TEXT ,strMobile TEXT ,strContactName TEXT ,ulShowControl INTEGER ,feedPreviewTime INTEGER ,strQzoneFeedsDesc TEXT ,StrPresentDesc TEXT ,strSpaceName TEXT ,strQzoneHeader TEXT ,vQzonePhotos BLOB ,vQzoneCoverInfo BLOB ,enlargeQzonePic INTEGER ,showPublishButton INTEGER ,strStatus TEXT ,strAutoRemark TEXT ,vSeed BLOB ,vCookies BLOB ,hasFakeData INTEGER ,bQQVipOpen INTEGER ,iQQVipType INTEGER ,iQQVipLevel INTEGER ,nameplateVipType INTEGER ,grayNameplateFlag INTEGER ,bSuperVipOpen INTEGER ,iSuperVipType INTEGER ,iSuperVipLevel INTEGER ,bSuperQQOpen INTEGER ,iSuperQQType INTEGER ,iSuperQQLevel INTEGER ,bHollywoodVipOpen INTEGER ,iHollywoodVipType INTEGER ,iHollywoodVipLevel INTEGER ,strShowName TEXT ,vRichSign BLOB ,lSignModifyTime INTEGER ,vLongNickTopicInfo BLOB ,lUserFlag INTEGER ,lLoginDays INTEGER ,strLoginDaysDesc TEXT ,lQQMasterLogindays INTEGER ,iXManScene1DelayTime INTEGER ,iXManScene2DelayTime INTEGER ,allowPeopleSee INTEGER ,allowCalInteractive INTEGER ,showOnlineFriends INTEGER ,allowClick INTEGER ,babyQSwitch INTEGER ,isSuperRedDiamond INTEGER ,isRedDiamond INTEGER ,redLevel INTEGER ,isSuperYellowDiamond INTEGER ,isYellowDiamond INTEGER ,yellowLevel INTEGER ,isSuperGreenDiamond INTEGER ,isGreenDiamond INTEGER ,greenLevel INTEGER ,templateRet INTEGER ,lCurrentStyleId INTEGER ,lCurrentBgId INTEGER ,backgroundUrl TEXT ,backgroundColor INTEGER ,dynamicCardFlag INTEGER ,strZipUrl TEXT ,strActiveUrl TEXT ,strDrawerCardUrl TEXT ,strWzryHeroUrl TEXT ,wzryHonorInfo BLOB ,strExtInfo TEXT ,strCurrentBgUrl TEXT ,bgType BLOB ,encId TEXT ,busiEntry TEXT ,favoriteSource INTEGER ,visibleMusicPendant INTEGER ,autoPlayMusicPendant INTEGER ,showRedPointMusicPendant INTEGER ,privilegePromptStr TEXT ,privilegeJumpUrl TEXT ,vOpenPriv BLOB ,vClosePriv BLOB ,presentDesc TEXT ,presentCustourl TEXT ,presentSwitch INTEGER ,showPresent INTEGER ,showMusicBox INTEGER ,addSrcName TEXT ,addSrcId INTEGER ,addSubSrcId INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,mNowShowFlag INTEGER ,mNowShowIconUrl TEXT ,mNowShowJumpUrl TEXT ,vCoverInfo BLOB ,medalSwitchDisable INTEGER ,iMedalCount INTEGER ,iNewCount INTEGER ,iUpgradeCount INTEGER ,strPromptParams TEXT ,hobbyEntry TEXT ,lastPraiseInfoList BLOB ,tempChatSig BLOB ,namePlateOfKingGameId INTEGER ,namePlateOfKingLoginTime INTEGER ,namePlateOfKingDan INTEGER ,namePlateOfKingDanDisplatSwitch INTEGER ,vPersonalityLabelV2 BLOB ,cardType INTEGER ,diyText TEXT ,diyTextFontId INTEGER ,diyTextWidth REAL ,diyTextHeight REAL ,diyTextLocX REAL ,diyTextLocY REAL ,diyTextDegree REAL ,diyTextScale REAL ,diyTextTransparency REAL ,diyDefaultText TEXT ,popularity INTEGER ,declaration TEXT ,voiceUrl TEXT ,isShowCard INTEGER ,updateTime INTEGER ,extendFriendFlag INTEGER ,extendFriendVoiceDuration INTEGER ,extendFriendEntryContact INTEGER ,extendFriendEntryAddFriend INTEGER ,extendFriendQuestion INTEGER ,fontId INTEGER ,fontType INTEGER ,clothesId INTEGER ,schoolId TEXT ,schoolName TEXT ,authState INTEGER ,idx INTEGER ,category INTEGER ,isShowMiniPlaying INTEGER ,tabJumpUrl TEXT ,guestJumpUrl TEXT ,guestAppTotal INTEGER ,defaultCardId INTEGER ,strangerVoteOpen INTEGER ,lSuperVipTemplateId INTEGER ,bBigClubVipOpen INTEGER ,iBigClubVipType INTEGER ,iBigClubVipLevel INTEGER ,lBigClubTemplateId INTEGER ,diyComplicatedInfo TEXT ,cardId INTEGER ,strangerInviteMeGroupOpen INTEGER ,isPrettyGroupOwner INTEGER ,isHidePrettyGroutIdentity INTEGER ,mQQLevelType INTEGER ,schoolVerifiedFlag INTEGER ,troopHonorSwitch INTEGER ,lhLevel INTEGER ,qid TEXT ,qidColor TEXT ,qidLogoUrl TEXT ,qidBgUrl TEXT)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azhd
 * JD-Core Version:    0.7.0.1
 */