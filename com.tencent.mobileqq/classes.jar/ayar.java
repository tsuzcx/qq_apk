import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class ayar
  extends OGAbstractDao
{
  public ayar()
  {
    this.columnLen = 213;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (Card)paramEntity;
    label1925:
    label4106:
    label4235:
    label4365:
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
          break label4235;
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
          break label4240;
        }
        paramBoolean = true;
        label1873:
        paramEntity.allowPeopleSee = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowCalInteractive"))) {
          break label4245;
        }
        paramBoolean = true;
        label1899:
        paramEntity.allowCalInteractive = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showOnlineFriends"))) {
          break label4250;
        }
        paramBoolean = true;
        paramEntity.showOnlineFriends = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowClick"))) {
          break label4255;
        }
        paramBoolean = true;
        label1951:
        paramEntity.allowClick = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("babyQSwitch"))) {
          break label4260;
        }
        paramBoolean = true;
        label1977:
        paramEntity.babyQSwitch = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperRedDiamond"))) {
          break label4265;
        }
        paramBoolean = true;
        label2003:
        paramEntity.isSuperRedDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRedDiamond"))) {
          break label4270;
        }
        paramBoolean = true;
        label2029:
        paramEntity.isRedDiamond = paramBoolean;
        paramEntity.redLevel = paramCursor.getInt(paramCursor.getColumnIndex("redLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperYellowDiamond"))) {
          break label4275;
        }
        paramBoolean = true;
        label2074:
        paramEntity.isSuperYellowDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isYellowDiamond"))) {
          break label4280;
        }
        paramBoolean = true;
        label2100:
        paramEntity.isYellowDiamond = paramBoolean;
        paramEntity.yellowLevel = paramCursor.getInt(paramCursor.getColumnIndex("yellowLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperGreenDiamond"))) {
          break label4285;
        }
        paramBoolean = true;
        label2145:
        paramEntity.isSuperGreenDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isGreenDiamond"))) {
          break label4290;
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
          break label4295;
        }
        paramBoolean = true;
        label2539:
        paramEntity.visibleMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("autoPlayMusicPendant"))) {
          break label4300;
        }
        paramBoolean = true;
        paramEntity.autoPlayMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showRedPointMusicPendant"))) {
          break label4305;
        }
        paramBoolean = true;
        label2591:
        paramEntity.showRedPointMusicPendant = paramBoolean;
        paramEntity.privilegePromptStr = paramCursor.getString(paramCursor.getColumnIndex("privilegePromptStr"));
        paramEntity.privilegeJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("privilegeJumpUrl"));
        paramEntity.vOpenPriv = paramCursor.getBlob(paramCursor.getColumnIndex("vOpenPriv"));
        paramEntity.vClosePriv = paramCursor.getBlob(paramCursor.getColumnIndex("vClosePriv"));
        paramEntity.presentDesc = paramCursor.getString(paramCursor.getColumnIndex("presentDesc"));
        paramEntity.presentCustourl = paramCursor.getString(paramCursor.getColumnIndex("presentCustourl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("presentSwitch"))) {
          break label4310;
        }
        paramBoolean = true;
        label2731:
        paramEntity.presentSwitch = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showPresent"))) {
          break label4315;
        }
        paramBoolean = true;
        label2757:
        paramEntity.showPresent = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showMusicBox"))) {
          break label4320;
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
          break label4325;
        }
        paramBoolean = true;
        label2999:
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
          break label4330;
        }
        paramBoolean = true;
        label3215:
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
          break label4335;
        }
        paramBoolean = true;
        label3526:
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
          break label4340;
        }
        paramBoolean = true;
        label3818:
        paramEntity.isShowMiniPlaying = paramBoolean;
        paramEntity.tabJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("tabJumpUrl"));
        paramEntity.guestJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("guestJumpUrl"));
        paramEntity.guestAppTotal = paramCursor.getInt(paramCursor.getColumnIndex("guestAppTotal"));
        paramEntity.defaultCardId = paramCursor.getInt(paramCursor.getColumnIndex("defaultCardId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("strangerVoteOpen"))) {
          break label4345;
        }
        paramBoolean = true;
        label3920:
        paramEntity.strangerVoteOpen = paramBoolean;
        paramEntity.lSuperVipTemplateId = paramCursor.getLong(paramCursor.getColumnIndex("lSuperVipTemplateId"));
        paramEntity.bBigClubVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bBigClubVipOpen")));
        paramEntity.iBigClubVipType = paramCursor.getInt(paramCursor.getColumnIndex("iBigClubVipType"));
        paramEntity.iBigClubVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iBigClubVipLevel"));
        paramEntity.lBigClubTemplateId = paramCursor.getLong(paramCursor.getColumnIndex("lBigClubTemplateId"));
        paramEntity.diyComplicatedInfo = paramCursor.getString(paramCursor.getColumnIndex("diyComplicatedInfo"));
        paramEntity.cardId = paramCursor.getLong(paramCursor.getColumnIndex("cardId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("strangerInviteMeGroupOpen"))) {
          break label4350;
        }
        paramBoolean = true;
        label4080:
        paramEntity.strangerInviteMeGroupOpen = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isPrettyGroupOwner"))) {
          break label4355;
        }
        paramBoolean = true;
        paramEntity.isPrettyGroupOwner = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isHidePrettyGroutIdentity"))) {
          break label4360;
        }
        paramBoolean = true;
        label4132:
        paramEntity.isHidePrettyGroutIdentity = paramBoolean;
        paramEntity.mQQLevelType = paramCursor.getInt(paramCursor.getColumnIndex("mQQLevelType"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("schoolVerifiedFlag"))) {
          break label4365;
        }
        paramBoolean = true;
        label4177:
        paramEntity.schoolVerifiedFlag = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("troopHonorSwitch"))) {
          break label4370;
        }
      }
      label4240:
      label4370:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.troopHonorSwitch = paramBoolean;
        paramEntity.lhLevel = paramCursor.getInt(paramCursor.getColumnIndex("lhLevel"));
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label1387;
        paramBoolean = false;
        break label1873;
        label4245:
        paramBoolean = false;
        break label1899;
        label4250:
        paramBoolean = false;
        break label1925;
        label4255:
        paramBoolean = false;
        break label1951;
        label4260:
        paramBoolean = false;
        break label1977;
        label4265:
        paramBoolean = false;
        break label2003;
        label4270:
        paramBoolean = false;
        break label2029;
        label4275:
        paramBoolean = false;
        break label2074;
        label4280:
        paramBoolean = false;
        break label2100;
        label4285:
        paramBoolean = false;
        break label2145;
        label4290:
        paramBoolean = false;
        break label2171;
        label4295:
        paramBoolean = false;
        break label2539;
        label4300:
        paramBoolean = false;
        break label2565;
        label4305:
        paramBoolean = false;
        break label2591;
        label4310:
        paramBoolean = false;
        break label2731;
        label4315:
        paramBoolean = false;
        break label2757;
        label4320:
        paramBoolean = false;
        break label2783;
        label4325:
        paramBoolean = false;
        break label2999;
        label4330:
        paramBoolean = false;
        break label3215;
        label4335:
        paramBoolean = false;
        break label3526;
        label4340:
        paramBoolean = false;
        break label3818;
        label4345:
        paramBoolean = false;
        break label3920;
        label4350:
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
    label2565:
    label4360:
    int i = paramCursor.getColumnIndex("uin");
    label4355:
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("strNick");
      if (i != -1) {
        break label12169;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strNick", String.class));
      label4445:
      i = paramCursor.getColumnIndex("shGender");
      if (i != -1) {
        break label12184;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("shGender", Short.TYPE));
      i = paramCursor.getColumnIndex("shAge");
      if (i != -1) {
        break label12199;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("shAge", Short.TYPE));
      label4515:
      i = paramCursor.getColumnIndex("nFaceID");
      if (i != -1) {
        break label12214;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nFaceID", Integer.TYPE));
      label4550:
      i = paramCursor.getColumnIndex("strCertificationInfo");
      if (i != -1) {
        break label12229;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCertificationInfo", String.class));
      label4585:
      i = paramCursor.getColumnIndex("shType");
      if (i != -1) {
        break label12244;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("shType", Short.TYPE));
      label4620:
      i = paramCursor.getColumnIndex("vContent");
      if (i != -1) {
        break label12259;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vContent", [B.class));
      label4655:
      i = paramCursor.getColumnIndex("strSign");
      if (i != -1) {
        break label12274;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strSign", String.class));
      label4690:
      i = paramCursor.getColumnIndex("strCompany");
      if (i != -1) {
        break label12289;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCompany", String.class));
      label4725:
      i = paramCursor.getColumnIndex("strSchool");
      if (i != -1) {
        break label12304;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strSchool", String.class));
      label4760:
      i = paramCursor.getColumnIndex("uFaceTimeStamp");
      if (i != -1) {
        break label12319;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uFaceTimeStamp", Integer.TYPE));
      label4795:
      i = paramCursor.getColumnIndex("vQQFaceID");
      if (i != -1) {
        break label12334;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vQQFaceID", [B.class));
      label4830:
      i = paramCursor.getColumnIndex("strReMark");
      if (i != -1) {
        break label12349;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strReMark", String.class));
      i = paramCursor.getColumnIndex("bWeiboInfo");
      if (i != -1) {
        break label12364;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bWeiboInfo", Byte.TYPE));
      label4900:
      i = paramCursor.getColumnIndex("bQzoneInfo");
      if (i != -1) {
        break label12380;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bQzoneInfo", Byte.TYPE));
      label4935:
      i = paramCursor.getColumnIndex("nSameFriendsNum");
      if (i != -1) {
        break label12396;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nSameFriendsNum", Integer.TYPE));
      label4970:
      i = paramCursor.getColumnIndex("strCompanySame");
      if (i != -1) {
        break label12411;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCompanySame", String.class));
      label5005:
      i = paramCursor.getColumnIndex("strSchoolSame");
      if (i != -1) {
        break label12426;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strSchoolSame", String.class));
      label5040:
      i = paramCursor.getColumnIndex("lCardShowNum");
      if (i != -1) {
        break label12441;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lCardShowNum", Long.TYPE));
      label5075:
      i = paramCursor.getColumnIndex("bSingle");
      if (i != -1) {
        break label12456;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bSingle", Byte.TYPE));
      label5110:
      i = paramCursor.getColumnIndex("lVisitCount");
      if (i != -1) {
        break label12472;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lVisitCount", Long.TYPE));
      label5145:
      i = paramCursor.getColumnIndex("lVoteCount");
      if (i != -1) {
        break label12487;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lVoteCount", Long.TYPE));
      label5180:
      i = paramCursor.getColumnIndex("tagInfosByte");
      if (i != -1) {
        break label12502;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tagInfosByte", [B.class));
      label5215:
      i = paramCursor.getColumnIndex("eUserIdentityType");
      if (i != -1) {
        break label12517;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("eUserIdentityType", Byte.TYPE));
      i = paramCursor.getColumnIndex("vBackground");
      if (i != -1) {
        break label12533;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vBackground", [B.class));
      label5285:
      i = paramCursor.getColumnIndex("labelInfoBytes");
      if (i != -1) {
        break label12548;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("labelInfoBytes", [B.class));
      label5320:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label12563;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("age", Byte.TYPE));
      label5355:
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label12579;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("constellation", Integer.TYPE));
      label5390:
      i = paramCursor.getColumnIndex("pyFaceUrl");
      if (i != -1) {
        break label12594;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pyFaceUrl", String.class));
      label5425:
      i = paramCursor.getColumnIndex("location");
      if (i != -1) {
        break label12609;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("location", String.class));
      label5460:
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label12624;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bVoted", Byte.TYPE));
      label5495:
      i = paramCursor.getColumnIndex("bFavorited");
      if (i != -1) {
        break label12640;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bFavorited", Byte.TYPE));
      label5530:
      i = paramCursor.getColumnIndex("iVoteIncrement");
      if (i != -1) {
        break label12656;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iVoteIncrement", Integer.TYPE));
      label5565:
      i = paramCursor.getColumnIndex("strJoinHexAlbumFileKey");
      if (i != -1) {
        break label12671;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strJoinHexAlbumFileKey", String.class));
      label5600:
      i = paramCursor.getColumnIndex("iFaceNum");
      if (i != -1) {
        break label12686;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iFaceNum", Integer.TYPE));
      label5635:
      i = paramCursor.getColumnIndex("cSqqLevel");
      if (i != -1) {
        break label12701;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cSqqLevel", Byte.TYPE));
      label5670:
      i = paramCursor.getColumnIndex("iQQLevel");
      if (i != -1) {
        break label12717;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iQQLevel", Integer.TYPE));
      label5705:
      i = paramCursor.getColumnIndex("uCurMulType");
      if (i != -1) {
        break label12732;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uCurMulType", Long.TYPE));
      label5740:
      i = paramCursor.getColumnIndex("strProvince");
      if (i != -1) {
        break label12747;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strProvince", String.class));
      label5775:
      i = paramCursor.getColumnIndex("strCity");
      if (i != -1) {
        break label12762;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCity", String.class));
      label5810:
      i = paramCursor.getColumnIndex("strCountry");
      if (i != -1) {
        break label12777;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCountry", String.class));
      label5845:
      i = paramCursor.getColumnIndex("lBirthday");
      if (i != -1) {
        break label12792;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lBirthday", Long.TYPE));
      label5880:
      i = paramCursor.getColumnIndex("strLocationCodes");
      if (i != -1) {
        break label12807;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strLocationCodes", String.class));
      label5915:
      i = paramCursor.getColumnIndex("strLocationDesc");
      if (i != -1) {
        break label12822;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strLocationDesc", String.class));
      label5950:
      i = paramCursor.getColumnIndex("strHometownCodes");
      if (i != -1) {
        break label12837;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strHometownCodes", String.class));
      label5985:
      i = paramCursor.getColumnIndex("strHometownDesc");
      if (i != -1) {
        break label12852;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strHometownDesc", String.class));
      label6020:
      i = paramCursor.getColumnIndex("strHometownCountry");
      if (i != -1) {
        break label12867;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strHometownCountry", String.class));
      label6055:
      i = paramCursor.getColumnIndex("strHometownProvince");
      if (i != -1) {
        break label12882;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strHometownProvince", String.class));
      label6090:
      i = paramCursor.getColumnIndex("strHometownCity");
      if (i != -1) {
        break label12897;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strHometownCity", String.class));
      label6125:
      i = paramCursor.getColumnIndex("strEmail");
      if (i != -1) {
        break label12912;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strEmail", String.class));
      label6160:
      i = paramCursor.getColumnIndex("strPersonalNote");
      if (i != -1) {
        break label12927;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strPersonalNote", String.class));
      label6195:
      i = paramCursor.getColumnIndex("iProfession");
      if (i != -1) {
        break label12942;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iProfession", Integer.TYPE));
      label6232:
      i = paramCursor.getColumnIndex("bindPhoneInfo");
      if (i != -1) {
        break label12957;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bindPhoneInfo", String.class));
      label6269:
      i = paramCursor.getColumnIndex("bCardInfo");
      if (i != -1) {
        break label12972;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bCardInfo", [B.class));
      label6306:
      i = paramCursor.getColumnIndex("strTroopName");
      if (i != -1) {
        break label12987;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strTroopName", String.class));
      label6343:
      i = paramCursor.getColumnIndex("strTroopNick");
      if (i != -1) {
        break label13002;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strTroopNick", String.class));
      label6380:
      i = paramCursor.getColumnIndex("strMobile");
      if (i != -1) {
        break label13017;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strMobile", String.class));
      label6417:
      i = paramCursor.getColumnIndex("strContactName");
      if (i != -1) {
        break label13032;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strContactName", String.class));
      label6454:
      i = paramCursor.getColumnIndex("ulShowControl");
      if (i != -1) {
        break label13047;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ulShowControl", Integer.TYPE));
      label6491:
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label13062;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("feedPreviewTime", Long.TYPE));
      i = paramCursor.getColumnIndex("strQzoneFeedsDesc");
      if (i != -1) {
        break label13077;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strQzoneFeedsDesc", String.class));
      label6565:
      i = paramCursor.getColumnIndex("StrPresentDesc");
      if (i != -1) {
        break label13092;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("StrPresentDesc", String.class));
      label6602:
      i = paramCursor.getColumnIndex("strSpaceName");
      if (i != -1) {
        break label13107;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strSpaceName", String.class));
      label6639:
      i = paramCursor.getColumnIndex("strQzoneHeader");
      if (i != -1) {
        break label13122;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strQzoneHeader", String.class));
      label6676:
      i = paramCursor.getColumnIndex("vQzonePhotos");
      if (i != -1) {
        break label13137;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vQzonePhotos", [B.class));
      label6713:
      i = paramCursor.getColumnIndex("vQzoneCoverInfo");
      if (i != -1) {
        break label13152;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vQzoneCoverInfo", [B.class));
      label6750:
      i = paramCursor.getColumnIndex("enlargeQzonePic");
      if (i != -1) {
        break label13167;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("enlargeQzonePic", Integer.TYPE));
      label6787:
      i = paramCursor.getColumnIndex("showPublishButton");
      if (i != -1) {
        break label13182;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showPublishButton", Boolean.TYPE));
      i = paramCursor.getColumnIndex("strStatus");
      if (i != -1) {
        break label13209;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strStatus", String.class));
      label6861:
      i = paramCursor.getColumnIndex("strAutoRemark");
      if (i != -1) {
        break label13224;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strAutoRemark", String.class));
      label6898:
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label13239;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vSeed", [B.class));
      label6935:
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label13254;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vCookies", [B.class));
      label6972:
      i = paramCursor.getColumnIndex("hasFakeData");
      if (i != -1) {
        break label13269;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasFakeData", Boolean.TYPE));
      i = paramCursor.getColumnIndex("bQQVipOpen");
      if (i != -1) {
        break label13296;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bQQVipOpen", Byte.TYPE));
      label7046:
      i = paramCursor.getColumnIndex("iQQVipType");
      if (i != -1) {
        break label13312;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iQQVipType", Integer.TYPE));
      label7083:
      i = paramCursor.getColumnIndex("iQQVipLevel");
      if (i != -1) {
        break label13327;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iQQVipLevel", Integer.TYPE));
      label7120:
      i = paramCursor.getColumnIndex("nameplateVipType");
      if (i != -1) {
        break label13342;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nameplateVipType", Integer.TYPE));
      label7157:
      i = paramCursor.getColumnIndex("grayNameplateFlag");
      if (i != -1) {
        break label13357;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("grayNameplateFlag", Integer.TYPE));
      label7194:
      i = paramCursor.getColumnIndex("bSuperVipOpen");
      if (i != -1) {
        break label13372;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bSuperVipOpen", Byte.TYPE));
      label7231:
      i = paramCursor.getColumnIndex("iSuperVipType");
      if (i != -1) {
        break label13388;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iSuperVipType", Integer.TYPE));
      label7268:
      i = paramCursor.getColumnIndex("iSuperVipLevel");
      if (i != -1) {
        break label13403;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iSuperVipLevel", Integer.TYPE));
      label7305:
      i = paramCursor.getColumnIndex("bSuperQQOpen");
      if (i != -1) {
        break label13418;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bSuperQQOpen", Byte.TYPE));
      label7342:
      i = paramCursor.getColumnIndex("iSuperQQType");
      if (i != -1) {
        break label13434;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iSuperQQType", Integer.TYPE));
      label7379:
      i = paramCursor.getColumnIndex("iSuperQQLevel");
      if (i != -1) {
        break label13449;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iSuperQQLevel", Integer.TYPE));
      label7416:
      i = paramCursor.getColumnIndex("bHollywoodVipOpen");
      if (i != -1) {
        break label13464;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bHollywoodVipOpen", Byte.TYPE));
      label7453:
      i = paramCursor.getColumnIndex("iHollywoodVipType");
      if (i != -1) {
        break label13480;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iHollywoodVipType", Integer.TYPE));
      label7490:
      i = paramCursor.getColumnIndex("iHollywoodVipLevel");
      if (i != -1) {
        break label13495;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iHollywoodVipLevel", Integer.TYPE));
      label7527:
      i = paramCursor.getColumnIndex("strShowName");
      if (i != -1) {
        break label13510;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strShowName", String.class));
      label7564:
      i = paramCursor.getColumnIndex("vRichSign");
      if (i != -1) {
        break label13525;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vRichSign", [B.class));
      label7601:
      i = paramCursor.getColumnIndex("lSignModifyTime");
      if (i != -1) {
        break label13540;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lSignModifyTime", Long.TYPE));
      label7638:
      i = paramCursor.getColumnIndex("vLongNickTopicInfo");
      if (i != -1) {
        break label13555;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vLongNickTopicInfo", [B.class));
      label7675:
      i = paramCursor.getColumnIndex("lUserFlag");
      if (i != -1) {
        break label13570;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lUserFlag", Long.TYPE));
      label7712:
      i = paramCursor.getColumnIndex("lLoginDays");
      if (i != -1) {
        break label13585;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lLoginDays", Long.TYPE));
      label7749:
      i = paramCursor.getColumnIndex("strLoginDaysDesc");
      if (i != -1) {
        break label13600;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strLoginDaysDesc", String.class));
      label7786:
      i = paramCursor.getColumnIndex("lQQMasterLogindays");
      if (i != -1) {
        break label13615;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lQQMasterLogindays", Long.TYPE));
      label7823:
      i = paramCursor.getColumnIndex("iXManScene1DelayTime");
      if (i != -1) {
        break label13630;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iXManScene1DelayTime", Integer.TYPE));
      label7860:
      i = paramCursor.getColumnIndex("iXManScene2DelayTime");
      if (i != -1) {
        break label13645;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iXManScene2DelayTime", Integer.TYPE));
      label7897:
      i = paramCursor.getColumnIndex("allowPeopleSee");
      if (i != -1) {
        break label13660;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowPeopleSee", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowCalInteractive");
      if (i != -1) {
        break label13687;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowCalInteractive", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showOnlineFriends");
      if (i != -1) {
        break label13714;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showOnlineFriends", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowClick");
      if (i != -1) {
        break label13741;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowClick", Boolean.TYPE));
      i = paramCursor.getColumnIndex("babyQSwitch");
      if (i != -1) {
        break label13768;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("babyQSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isSuperRedDiamond");
      if (i != -1) {
        break label13795;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isSuperRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRedDiamond");
      if (i != -1) {
        break label13822;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("redLevel");
      if (i != -1) {
        break label13849;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("redLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("isSuperYellowDiamond");
      if (i != -1) {
        break label13864;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isSuperYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isYellowDiamond");
      if (i != -1) {
        break label13891;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("yellowLevel");
      if (i != -1) {
        break label13918;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("yellowLevel", Integer.TYPE));
      label8304:
      i = paramCursor.getColumnIndex("isSuperGreenDiamond");
      if (i != -1) {
        break label13933;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isSuperGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isGreenDiamond");
      if (i != -1) {
        break label13960;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("greenLevel");
      if (i != -1) {
        break label13987;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("greenLevel", Integer.TYPE));
      label8415:
      i = paramCursor.getColumnIndex("templateRet");
      if (i != -1) {
        break label14002;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("templateRet", Integer.TYPE));
      label8452:
      i = paramCursor.getColumnIndex("lCurrentStyleId");
      if (i != -1) {
        break label14017;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lCurrentStyleId", Long.TYPE));
      label8489:
      i = paramCursor.getColumnIndex("lCurrentBgId");
      if (i != -1) {
        break label14032;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lCurrentBgId", Long.TYPE));
      label8526:
      i = paramCursor.getColumnIndex("backgroundUrl");
      if (i != -1) {
        break label14047;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("backgroundUrl", String.class));
      label8563:
      i = paramCursor.getColumnIndex("backgroundColor");
      if (i != -1) {
        break label14062;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("backgroundColor", Long.TYPE));
      label8600:
      i = paramCursor.getColumnIndex("dynamicCardFlag");
      if (i != -1) {
        break label14077;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dynamicCardFlag", Integer.TYPE));
      label8637:
      i = paramCursor.getColumnIndex("strZipUrl");
      if (i != -1) {
        break label14092;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strZipUrl", String.class));
      label8674:
      i = paramCursor.getColumnIndex("strActiveUrl");
      if (i != -1) {
        break label14107;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strActiveUrl", String.class));
      label8711:
      i = paramCursor.getColumnIndex("strDrawerCardUrl");
      if (i != -1) {
        break label14122;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strDrawerCardUrl", String.class));
      label8748:
      i = paramCursor.getColumnIndex("strWzryHeroUrl");
      if (i != -1) {
        break label14137;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strWzryHeroUrl", String.class));
      label8785:
      i = paramCursor.getColumnIndex("wzryHonorInfo");
      if (i != -1) {
        break label14152;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wzryHonorInfo", [B.class));
      label8822:
      i = paramCursor.getColumnIndex("strExtInfo");
      if (i != -1) {
        break label14167;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strExtInfo", String.class));
      label8859:
      i = paramCursor.getColumnIndex("strCurrentBgUrl");
      if (i != -1) {
        break label14182;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCurrentBgUrl", String.class));
      label8896:
      i = paramCursor.getColumnIndex("bgType");
      if (i != -1) {
        break label14197;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bgType", [B.class));
      label8933:
      i = paramCursor.getColumnIndex("encId");
      if (i != -1) {
        break label14212;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("encId", String.class));
      label8970:
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label14227;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("busiEntry", String.class));
      label9007:
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label14242;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("favoriteSource", Integer.TYPE));
      label9044:
      i = paramCursor.getColumnIndex("visibleMusicPendant");
      if (i != -1) {
        break label14257;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("visibleMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("autoPlayMusicPendant");
      if (i != -1) {
        break label14284;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("autoPlayMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showRedPointMusicPendant");
      if (i != -1) {
        break label14311;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showRedPointMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("privilegePromptStr");
      if (i != -1) {
        break label14338;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("privilegePromptStr", String.class));
      label9192:
      i = paramCursor.getColumnIndex("privilegeJumpUrl");
      if (i != -1) {
        break label14353;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("privilegeJumpUrl", String.class));
      label9229:
      i = paramCursor.getColumnIndex("vOpenPriv");
      if (i != -1) {
        break label14368;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vOpenPriv", [B.class));
      label9266:
      i = paramCursor.getColumnIndex("vClosePriv");
      if (i != -1) {
        break label14383;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vClosePriv", [B.class));
      label9303:
      i = paramCursor.getColumnIndex("presentDesc");
      if (i != -1) {
        break label14398;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("presentDesc", String.class));
      label9340:
      i = paramCursor.getColumnIndex("presentCustourl");
      if (i != -1) {
        break label14413;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("presentCustourl", String.class));
      label9377:
      i = paramCursor.getColumnIndex("presentSwitch");
      if (i != -1) {
        break label14428;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("presentSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showPresent");
      if (i != -1) {
        break label14455;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showPresent", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showMusicBox");
      if (i != -1) {
        break label14482;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showMusicBox", Boolean.TYPE));
      i = paramCursor.getColumnIndex("addSrcName");
      if (i != -1) {
        break label14509;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("addSrcName", String.class));
      label9525:
      i = paramCursor.getColumnIndex("addSrcId");
      if (i != -1) {
        break label14524;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("addSrcId", Long.TYPE));
      label9562:
      i = paramCursor.getColumnIndex("addSubSrcId");
      if (i != -1) {
        break label14539;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("addSubSrcId", Long.TYPE));
      label9599:
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label14554;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strVoteLimitedNotice", String.class));
      label9636:
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label14569;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      label9673:
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label14584;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      label9710:
      i = paramCursor.getColumnIndex("mNowShowFlag");
      if (i != -1) {
        break label14599;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mNowShowFlag", Integer.TYPE));
      label9747:
      i = paramCursor.getColumnIndex("mNowShowIconUrl");
      if (i != -1) {
        break label14614;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mNowShowIconUrl", String.class));
      label9784:
      i = paramCursor.getColumnIndex("mNowShowJumpUrl");
      if (i != -1) {
        break label14629;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mNowShowJumpUrl", String.class));
      label9821:
      i = paramCursor.getColumnIndex("vCoverInfo");
      if (i != -1) {
        break label14644;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vCoverInfo", [B.class));
      i = paramCursor.getColumnIndex("medalSwitchDisable");
      if (i != -1) {
        break label14659;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("medalSwitchDisable", Boolean.TYPE));
      i = paramCursor.getColumnIndex("iMedalCount");
      if (i != -1) {
        break label14686;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iMedalCount", Integer.TYPE));
      label9932:
      i = paramCursor.getColumnIndex("iNewCount");
      if (i != -1) {
        break label14701;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iNewCount", Integer.TYPE));
      label9969:
      i = paramCursor.getColumnIndex("iUpgradeCount");
      if (i != -1) {
        break label14716;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iUpgradeCount", Integer.TYPE));
      label10006:
      i = paramCursor.getColumnIndex("strPromptParams");
      if (i != -1) {
        break label14731;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strPromptParams", String.class));
      label10043:
      i = paramCursor.getColumnIndex("hobbyEntry");
      if (i != -1) {
        break label14746;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hobbyEntry", String.class));
      label10080:
      i = paramCursor.getColumnIndex("lastPraiseInfoList");
      if (i != -1) {
        break label14761;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastPraiseInfoList", [B.class));
      label10117:
      i = paramCursor.getColumnIndex("tempChatSig");
      if (i != -1) {
        break label14776;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tempChatSig", [B.class));
      label10154:
      i = paramCursor.getColumnIndex("namePlateOfKingGameId");
      if (i != -1) {
        break label14791;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingGameId", Long.TYPE));
      label10191:
      i = paramCursor.getColumnIndex("namePlateOfKingLoginTime");
      if (i != -1) {
        break label14806;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingLoginTime", Long.TYPE));
      label10228:
      i = paramCursor.getColumnIndex("namePlateOfKingDan");
      if (i != -1) {
        break label14821;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingDan", Integer.TYPE));
      label10265:
      i = paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch");
      if (i != -1) {
        break label14836;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingDanDisplatSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("vPersonalityLabelV2");
      if (i != -1) {
        break label14863;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vPersonalityLabelV2", [B.class));
      label10339:
      i = paramCursor.getColumnIndex("cardType");
      if (i != -1) {
        break label14878;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cardType", Integer.TYPE));
      label10376:
      i = paramCursor.getColumnIndex("diyText");
      if (i != -1) {
        break label14893;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyText", String.class));
      label10413:
      i = paramCursor.getColumnIndex("diyTextFontId");
      if (i != -1) {
        break label14908;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextFontId", Integer.TYPE));
      label10450:
      i = paramCursor.getColumnIndex("diyTextWidth");
      if (i != -1) {
        break label14923;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextWidth", Float.TYPE));
      label10487:
      i = paramCursor.getColumnIndex("diyTextHeight");
      if (i != -1) {
        break label14938;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextHeight", Float.TYPE));
      label10524:
      i = paramCursor.getColumnIndex("diyTextLocX");
      if (i != -1) {
        break label14953;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextLocX", Float.TYPE));
      label10561:
      i = paramCursor.getColumnIndex("diyTextLocY");
      if (i != -1) {
        break label14968;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextLocY", Float.TYPE));
      label10598:
      i = paramCursor.getColumnIndex("diyTextDegree");
      if (i != -1) {
        break label14983;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextDegree", Float.TYPE));
      label10635:
      i = paramCursor.getColumnIndex("diyTextScale");
      if (i != -1) {
        break label14998;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextScale", Float.TYPE));
      label10672:
      i = paramCursor.getColumnIndex("diyTextTransparency");
      if (i != -1) {
        break label15013;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyTextTransparency", Float.TYPE));
      label10709:
      i = paramCursor.getColumnIndex("diyDefaultText");
      if (i != -1) {
        break label15028;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyDefaultText", String.class));
      label10746:
      i = paramCursor.getColumnIndex("popularity");
      if (i != -1) {
        break label15043;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("popularity", Integer.TYPE));
      label10783:
      i = paramCursor.getColumnIndex("declaration");
      if (i != -1) {
        break label15058;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("declaration", String.class));
      label10820:
      i = paramCursor.getColumnIndex("voiceUrl");
      if (i != -1) {
        break label15073;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("voiceUrl", String.class));
      label10857:
      i = paramCursor.getColumnIndex("isShowCard");
      if (i != -1) {
        break label15088;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isShowCard", Boolean.TYPE));
      i = paramCursor.getColumnIndex("updateTime");
      if (i != -1) {
        break label15115;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("updateTime", Long.TYPE));
      label10931:
      i = paramCursor.getColumnIndex("extendFriendFlag");
      if (i != -1) {
        break label15130;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendFriendFlag", Integer.TYPE));
      label10968:
      i = paramCursor.getColumnIndex("extendFriendVoiceDuration");
      if (i != -1) {
        break label15145;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendFriendVoiceDuration", Integer.TYPE));
      label11005:
      i = paramCursor.getColumnIndex("extendFriendEntryContact");
      if (i != -1) {
        break label15160;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendFriendEntryContact", Short.TYPE));
      label11042:
      i = paramCursor.getColumnIndex("extendFriendEntryAddFriend");
      if (i != -1) {
        break label15175;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendFriendEntryAddFriend", Short.TYPE));
      label11079:
      i = paramCursor.getColumnIndex("extendFriendQuestion");
      if (i != -1) {
        break label15190;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendFriendQuestion", Short.TYPE));
      label11116:
      i = paramCursor.getColumnIndex("fontId");
      if (i != -1) {
        break label15205;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("fontId", Integer.TYPE));
      label11153:
      i = paramCursor.getColumnIndex("fontType");
      if (i != -1) {
        break label15220;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("fontType", Integer.TYPE));
      label11190:
      i = paramCursor.getColumnIndex("clothesId");
      if (i != -1) {
        break label15235;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("clothesId", Integer.TYPE));
      label11227:
      i = paramCursor.getColumnIndex("schoolId");
      if (i != -1) {
        break label15250;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("schoolId", String.class));
      i = paramCursor.getColumnIndex("schoolName");
      if (i != -1) {
        break label15265;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("schoolName", String.class));
      label11301:
      i = paramCursor.getColumnIndex("authState");
      if (i != -1) {
        break label15280;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("authState", Long.TYPE));
      label11338:
      i = paramCursor.getColumnIndex("idx");
      if (i != -1) {
        break label15295;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("idx", Integer.TYPE));
      label11375:
      i = paramCursor.getColumnIndex("category");
      if (i != -1) {
        break label15310;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("category", Integer.TYPE));
      label11412:
      i = paramCursor.getColumnIndex("isShowMiniPlaying");
      if (i != -1) {
        break label15325;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isShowMiniPlaying", Boolean.TYPE));
      i = paramCursor.getColumnIndex("tabJumpUrl");
      if (i != -1) {
        break label15352;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tabJumpUrl", String.class));
      label11486:
      i = paramCursor.getColumnIndex("guestJumpUrl");
      if (i != -1) {
        break label15367;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guestJumpUrl", String.class));
      label11523:
      i = paramCursor.getColumnIndex("guestAppTotal");
      if (i != -1) {
        break label15382;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guestAppTotal", Integer.TYPE));
      label11560:
      i = paramCursor.getColumnIndex("defaultCardId");
      if (i != -1) {
        break label15397;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("defaultCardId", Integer.TYPE));
      label11597:
      i = paramCursor.getColumnIndex("strangerVoteOpen");
      if (i != -1) {
        break label15412;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strangerVoteOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("lSuperVipTemplateId");
      if (i != -1) {
        break label15439;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lSuperVipTemplateId", Long.TYPE));
      label11671:
      i = paramCursor.getColumnIndex("bBigClubVipOpen");
      if (i != -1) {
        break label15454;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bBigClubVipOpen", Byte.TYPE));
      label11708:
      i = paramCursor.getColumnIndex("iBigClubVipType");
      if (i != -1) {
        break label15470;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iBigClubVipType", Integer.TYPE));
      label11745:
      i = paramCursor.getColumnIndex("iBigClubVipLevel");
      if (i != -1) {
        break label15485;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iBigClubVipLevel", Integer.TYPE));
      label11782:
      i = paramCursor.getColumnIndex("lBigClubTemplateId");
      if (i != -1) {
        break label15500;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lBigClubTemplateId", Long.TYPE));
      label11819:
      i = paramCursor.getColumnIndex("diyComplicatedInfo");
      if (i != -1) {
        break label15515;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyComplicatedInfo", String.class));
      label11856:
      i = paramCursor.getColumnIndex("cardId");
      if (i != -1) {
        break label15530;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cardId", Long.TYPE));
      label11893:
      i = paramCursor.getColumnIndex("strangerInviteMeGroupOpen");
      if (i != -1) {
        break label15545;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strangerInviteMeGroupOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isPrettyGroupOwner");
      if (i != -1) {
        break label15572;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isPrettyGroupOwner", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isHidePrettyGroutIdentity");
      if (i != -1) {
        break label15599;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isHidePrettyGroutIdentity", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mQQLevelType");
      if (i != -1) {
        break label15626;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mQQLevelType", Integer.TYPE));
    }
    for (;;)
    {
      label4480:
      label4865:
      label5250:
      i = paramCursor.getColumnIndex("schoolVerifiedFlag");
      label6528:
      label8193:
      label9858:
      if (i != -1) {
        break label15641;
      }
      label11264:
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("schoolVerifiedFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("troopHonorSwitch");
      if (i != -1) {
        break label15668;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopHonorSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("lhLevel");
      if (i != -1) {
        break label15696;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lhLevel", Integer.TYPE));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label12169:
      paramEntity.strNick = paramCursor.getString(i);
      break label4445;
      label12184:
      paramEntity.shGender = paramCursor.getShort(i);
      break label4480;
      label12199:
      paramEntity.shAge = paramCursor.getShort(i);
      break label4515;
      label12214:
      paramEntity.nFaceID = paramCursor.getInt(i);
      break label4550;
      label12229:
      paramEntity.strCertificationInfo = paramCursor.getString(i);
      break label4585;
      label12244:
      paramEntity.shType = paramCursor.getShort(i);
      break label4620;
      label12259:
      paramEntity.vContent = paramCursor.getBlob(i);
      break label4655;
      label12274:
      paramEntity.strSign = paramCursor.getString(i);
      break label4690;
      label12289:
      paramEntity.strCompany = paramCursor.getString(i);
      break label4725;
      label12304:
      paramEntity.strSchool = paramCursor.getString(i);
      break label4760;
      label12319:
      paramEntity.uFaceTimeStamp = paramCursor.getInt(i);
      break label4795;
      label12334:
      paramEntity.vQQFaceID = paramCursor.getBlob(i);
      break label4830;
      label12349:
      paramEntity.strReMark = paramCursor.getString(i);
      break label4865;
      label12364:
      paramEntity.bWeiboInfo = ((byte)paramCursor.getShort(i));
      break label4900;
      label12380:
      paramEntity.bQzoneInfo = ((byte)paramCursor.getShort(i));
      break label4935;
      label12396:
      paramEntity.nSameFriendsNum = paramCursor.getInt(i);
      break label4970;
      label12411:
      paramEntity.strCompanySame = paramCursor.getString(i);
      break label5005;
      label12426:
      paramEntity.strSchoolSame = paramCursor.getString(i);
      break label5040;
      label12441:
      paramEntity.lCardShowNum = paramCursor.getLong(i);
      break label5075;
      label12456:
      paramEntity.bSingle = ((byte)paramCursor.getShort(i));
      break label5110;
      label12472:
      paramEntity.lVisitCount = paramCursor.getLong(i);
      break label5145;
      label12487:
      paramEntity.lVoteCount = paramCursor.getLong(i);
      break label5180;
      label12502:
      paramEntity.tagInfosByte = paramCursor.getBlob(i);
      break label5215;
      label12517:
      paramEntity.eUserIdentityType = ((byte)paramCursor.getShort(i));
      break label5250;
      label12533:
      paramEntity.vBackground = paramCursor.getBlob(i);
      break label5285;
      label12548:
      paramEntity.labelInfoBytes = paramCursor.getBlob(i);
      break label5320;
      label12563:
      paramEntity.age = ((byte)paramCursor.getShort(i));
      break label5355;
      label12579:
      paramEntity.constellation = paramCursor.getInt(i);
      break label5390;
      label12594:
      paramEntity.pyFaceUrl = paramCursor.getString(i);
      break label5425;
      label12609:
      paramEntity.location = paramCursor.getString(i);
      break label5460;
      label12624:
      paramEntity.bVoted = ((byte)paramCursor.getShort(i));
      break label5495;
      label12640:
      paramEntity.bFavorited = ((byte)paramCursor.getShort(i));
      break label5530;
      label12656:
      paramEntity.iVoteIncrement = paramCursor.getInt(i);
      break label5565;
      label12671:
      paramEntity.strJoinHexAlbumFileKey = paramCursor.getString(i);
      break label5600;
      label12686:
      paramEntity.iFaceNum = paramCursor.getInt(i);
      break label5635;
      label12701:
      paramEntity.cSqqLevel = ((byte)paramCursor.getShort(i));
      break label5670;
      label12717:
      paramEntity.iQQLevel = paramCursor.getInt(i);
      break label5705;
      label12732:
      paramEntity.uCurMulType = paramCursor.getLong(i);
      break label5740;
      label12747:
      paramEntity.strProvince = paramCursor.getString(i);
      break label5775;
      label12762:
      paramEntity.strCity = paramCursor.getString(i);
      break label5810;
      label12777:
      paramEntity.strCountry = paramCursor.getString(i);
      break label5845;
      label12792:
      paramEntity.lBirthday = paramCursor.getLong(i);
      break label5880;
      label12807:
      paramEntity.strLocationCodes = paramCursor.getString(i);
      break label5915;
      label12822:
      paramEntity.strLocationDesc = paramCursor.getString(i);
      break label5950;
      label12837:
      paramEntity.strHometownCodes = paramCursor.getString(i);
      break label5985;
      label12852:
      paramEntity.strHometownDesc = paramCursor.getString(i);
      break label6020;
      label12867:
      paramEntity.strHometownCountry = paramCursor.getString(i);
      break label6055;
      label12882:
      paramEntity.strHometownProvince = paramCursor.getString(i);
      break label6090;
      label12897:
      paramEntity.strHometownCity = paramCursor.getString(i);
      break label6125;
      label12912:
      paramEntity.strEmail = paramCursor.getString(i);
      break label6160;
      label12927:
      paramEntity.strPersonalNote = paramCursor.getString(i);
      break label6195;
      label12942:
      paramEntity.iProfession = paramCursor.getInt(i);
      break label6232;
      label12957:
      paramEntity.bindPhoneInfo = paramCursor.getString(i);
      break label6269;
      label12972:
      paramEntity.bCardInfo = paramCursor.getBlob(i);
      break label6306;
      label12987:
      paramEntity.strTroopName = paramCursor.getString(i);
      break label6343;
      label13002:
      paramEntity.strTroopNick = paramCursor.getString(i);
      break label6380;
      label13017:
      paramEntity.strMobile = paramCursor.getString(i);
      break label6417;
      label13032:
      paramEntity.strContactName = paramCursor.getString(i);
      break label6454;
      label13047:
      paramEntity.ulShowControl = paramCursor.getInt(i);
      break label6491;
      label13062:
      paramEntity.feedPreviewTime = paramCursor.getLong(i);
      break label6528;
      label13077:
      paramEntity.strQzoneFeedsDesc = paramCursor.getString(i);
      break label6565;
      label13092:
      paramEntity.StrPresentDesc = paramCursor.getString(i);
      break label6602;
      label13107:
      paramEntity.strSpaceName = paramCursor.getString(i);
      break label6639;
      label13122:
      paramEntity.strQzoneHeader = paramCursor.getString(i);
      break label6676;
      label13137:
      paramEntity.vQzonePhotos = paramCursor.getBlob(i);
      break label6713;
      label13152:
      paramEntity.vQzoneCoverInfo = paramCursor.getBlob(i);
      break label6750;
      label13167:
      paramEntity.enlargeQzonePic = paramCursor.getInt(i);
      break label6787;
      label13182:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showPublishButton = paramBoolean;
        break;
      }
      label13209:
      paramEntity.strStatus = paramCursor.getString(i);
      break label6861;
      label13224:
      paramEntity.strAutoRemark = paramCursor.getString(i);
      break label6898;
      label13239:
      paramEntity.vSeed = paramCursor.getBlob(i);
      break label6935;
      label13254:
      paramEntity.vCookies = paramCursor.getBlob(i);
      break label6972;
      label13269:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasFakeData = paramBoolean;
        break;
      }
      label13296:
      paramEntity.bQQVipOpen = ((byte)paramCursor.getShort(i));
      break label7046;
      label13312:
      paramEntity.iQQVipType = paramCursor.getInt(i);
      break label7083;
      label13327:
      paramEntity.iQQVipLevel = paramCursor.getInt(i);
      break label7120;
      label13342:
      paramEntity.nameplateVipType = paramCursor.getInt(i);
      break label7157;
      label13357:
      paramEntity.grayNameplateFlag = paramCursor.getInt(i);
      break label7194;
      label13372:
      paramEntity.bSuperVipOpen = ((byte)paramCursor.getShort(i));
      break label7231;
      label13388:
      paramEntity.iSuperVipType = paramCursor.getInt(i);
      break label7268;
      label13403:
      paramEntity.iSuperVipLevel = paramCursor.getInt(i);
      break label7305;
      label13418:
      paramEntity.bSuperQQOpen = ((byte)paramCursor.getShort(i));
      break label7342;
      label13434:
      paramEntity.iSuperQQType = paramCursor.getInt(i);
      break label7379;
      label13449:
      paramEntity.iSuperQQLevel = paramCursor.getInt(i);
      break label7416;
      label13464:
      paramEntity.bHollywoodVipOpen = ((byte)paramCursor.getShort(i));
      break label7453;
      label13480:
      paramEntity.iHollywoodVipType = paramCursor.getInt(i);
      break label7490;
      label13495:
      paramEntity.iHollywoodVipLevel = paramCursor.getInt(i);
      break label7527;
      label13510:
      paramEntity.strShowName = paramCursor.getString(i);
      break label7564;
      label13525:
      paramEntity.vRichSign = paramCursor.getBlob(i);
      break label7601;
      label13540:
      paramEntity.lSignModifyTime = paramCursor.getLong(i);
      break label7638;
      label13555:
      paramEntity.vLongNickTopicInfo = paramCursor.getBlob(i);
      break label7675;
      label13570:
      paramEntity.lUserFlag = paramCursor.getLong(i);
      break label7712;
      label13585:
      paramEntity.lLoginDays = paramCursor.getLong(i);
      break label7749;
      label13600:
      paramEntity.strLoginDaysDesc = paramCursor.getString(i);
      break label7786;
      label13615:
      paramEntity.lQQMasterLogindays = paramCursor.getLong(i);
      break label7823;
      label13630:
      paramEntity.iXManScene1DelayTime = paramCursor.getInt(i);
      break label7860;
      label13645:
      paramEntity.iXManScene2DelayTime = paramCursor.getInt(i);
      break label7897;
      label13660:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowPeopleSee = paramBoolean;
        break;
      }
      label13687:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowCalInteractive = paramBoolean;
        break;
      }
      label13714:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showOnlineFriends = paramBoolean;
        break;
      }
      label13741:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowClick = paramBoolean;
        break;
      }
      label13768:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.babyQSwitch = paramBoolean;
        break;
      }
      label13795:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperRedDiamond = paramBoolean;
        break;
      }
      label13822:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isRedDiamond = paramBoolean;
        break;
      }
      label13849:
      paramEntity.redLevel = paramCursor.getInt(i);
      break label8193;
      label13864:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperYellowDiamond = paramBoolean;
        break;
      }
      label13891:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isYellowDiamond = paramBoolean;
        break;
      }
      label13918:
      paramEntity.yellowLevel = paramCursor.getInt(i);
      break label8304;
      label13933:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperGreenDiamond = paramBoolean;
        break;
      }
      label13960:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isGreenDiamond = paramBoolean;
        break;
      }
      label13987:
      paramEntity.greenLevel = paramCursor.getInt(i);
      break label8415;
      label14002:
      paramEntity.templateRet = paramCursor.getInt(i);
      break label8452;
      label14017:
      paramEntity.lCurrentStyleId = paramCursor.getLong(i);
      break label8489;
      label14032:
      paramEntity.lCurrentBgId = paramCursor.getLong(i);
      break label8526;
      label14047:
      paramEntity.backgroundUrl = paramCursor.getString(i);
      break label8563;
      label14062:
      paramEntity.backgroundColor = paramCursor.getLong(i);
      break label8600;
      label14077:
      paramEntity.dynamicCardFlag = paramCursor.getInt(i);
      break label8637;
      label14092:
      paramEntity.strZipUrl = paramCursor.getString(i);
      break label8674;
      label14107:
      paramEntity.strActiveUrl = paramCursor.getString(i);
      break label8711;
      label14122:
      paramEntity.strDrawerCardUrl = paramCursor.getString(i);
      break label8748;
      label14137:
      paramEntity.strWzryHeroUrl = paramCursor.getString(i);
      break label8785;
      label14152:
      paramEntity.wzryHonorInfo = paramCursor.getBlob(i);
      break label8822;
      label14167:
      paramEntity.strExtInfo = paramCursor.getString(i);
      break label8859;
      label14182:
      paramEntity.strCurrentBgUrl = paramCursor.getString(i);
      break label8896;
      label14197:
      paramEntity.bgType = paramCursor.getBlob(i);
      break label8933;
      label14212:
      paramEntity.encId = paramCursor.getString(i);
      break label8970;
      label14227:
      paramEntity.busiEntry = paramCursor.getString(i);
      break label9007;
      label14242:
      paramEntity.favoriteSource = paramCursor.getInt(i);
      break label9044;
      label14257:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.visibleMusicPendant = paramBoolean;
        break;
      }
      label14284:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.autoPlayMusicPendant = paramBoolean;
        break;
      }
      label14311:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showRedPointMusicPendant = paramBoolean;
        break;
      }
      label14338:
      paramEntity.privilegePromptStr = paramCursor.getString(i);
      break label9192;
      label14353:
      paramEntity.privilegeJumpUrl = paramCursor.getString(i);
      break label9229;
      label14368:
      paramEntity.vOpenPriv = paramCursor.getBlob(i);
      break label9266;
      label14383:
      paramEntity.vClosePriv = paramCursor.getBlob(i);
      break label9303;
      label14398:
      paramEntity.presentDesc = paramCursor.getString(i);
      break label9340;
      label14413:
      paramEntity.presentCustourl = paramCursor.getString(i);
      break label9377;
      label14428:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.presentSwitch = paramBoolean;
        break;
      }
      label14455:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showPresent = paramBoolean;
        break;
      }
      label14482:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showMusicBox = paramBoolean;
        break;
      }
      label14509:
      paramEntity.addSrcName = paramCursor.getString(i);
      break label9525;
      label14524:
      paramEntity.addSrcId = paramCursor.getLong(i);
      break label9562;
      label14539:
      paramEntity.addSubSrcId = paramCursor.getLong(i);
      break label9599;
      label14554:
      paramEntity.strVoteLimitedNotice = paramCursor.getString(i);
      break label9636;
      label14569:
      paramEntity.bHaveVotedCnt = paramCursor.getShort(i);
      break label9673;
      label14584:
      paramEntity.bAvailVoteCnt = paramCursor.getShort(i);
      break label9710;
      label14599:
      paramEntity.mNowShowFlag = paramCursor.getInt(i);
      break label9747;
      label14614:
      paramEntity.mNowShowIconUrl = paramCursor.getString(i);
      break label9784;
      label14629:
      paramEntity.mNowShowJumpUrl = paramCursor.getString(i);
      break label9821;
      label14644:
      paramEntity.vCoverInfo = paramCursor.getBlob(i);
      break label9858;
      label14659:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.medalSwitchDisable = paramBoolean;
        break;
      }
      label14686:
      paramEntity.iMedalCount = paramCursor.getInt(i);
      break label9932;
      label14701:
      paramEntity.iNewCount = paramCursor.getInt(i);
      break label9969;
      label14716:
      paramEntity.iUpgradeCount = paramCursor.getInt(i);
      break label10006;
      label14731:
      paramEntity.strPromptParams = paramCursor.getString(i);
      break label10043;
      label14746:
      paramEntity.hobbyEntry = paramCursor.getString(i);
      break label10080;
      label14761:
      paramEntity.lastPraiseInfoList = paramCursor.getBlob(i);
      break label10117;
      label14776:
      paramEntity.tempChatSig = paramCursor.getBlob(i);
      break label10154;
      label14791:
      paramEntity.namePlateOfKingGameId = paramCursor.getLong(i);
      break label10191;
      label14806:
      paramEntity.namePlateOfKingLoginTime = paramCursor.getLong(i);
      break label10228;
      label14821:
      paramEntity.namePlateOfKingDan = paramCursor.getInt(i);
      break label10265;
      label14836:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.namePlateOfKingDanDisplatSwitch = paramBoolean;
        break;
      }
      label14863:
      paramEntity.vPersonalityLabelV2 = paramCursor.getBlob(i);
      break label10339;
      label14878:
      paramEntity.cardType = paramCursor.getInt(i);
      break label10376;
      label14893:
      paramEntity.diyText = paramCursor.getString(i);
      break label10413;
      label14908:
      paramEntity.diyTextFontId = paramCursor.getInt(i);
      break label10450;
      label14923:
      paramEntity.diyTextWidth = paramCursor.getFloat(i);
      break label10487;
      label14938:
      paramEntity.diyTextHeight = paramCursor.getFloat(i);
      break label10524;
      label14953:
      paramEntity.diyTextLocX = paramCursor.getFloat(i);
      break label10561;
      label14968:
      paramEntity.diyTextLocY = paramCursor.getFloat(i);
      break label10598;
      label14983:
      paramEntity.diyTextDegree = paramCursor.getFloat(i);
      break label10635;
      label14998:
      paramEntity.diyTextScale = paramCursor.getFloat(i);
      break label10672;
      label15013:
      paramEntity.diyTextTransparency = paramCursor.getFloat(i);
      break label10709;
      label15028:
      paramEntity.diyDefaultText = paramCursor.getString(i);
      break label10746;
      label15043:
      paramEntity.popularity = paramCursor.getInt(i);
      break label10783;
      label15058:
      paramEntity.declaration = paramCursor.getString(i);
      break label10820;
      label15073:
      paramEntity.voiceUrl = paramCursor.getString(i);
      break label10857;
      label15088:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isShowCard = paramBoolean;
        break;
      }
      label15115:
      paramEntity.updateTime = paramCursor.getLong(i);
      break label10931;
      label15130:
      paramEntity.extendFriendFlag = paramCursor.getInt(i);
      break label10968;
      label15145:
      paramEntity.extendFriendVoiceDuration = paramCursor.getInt(i);
      break label11005;
      label15160:
      paramEntity.extendFriendEntryContact = paramCursor.getShort(i);
      break label11042;
      label15175:
      paramEntity.extendFriendEntryAddFriend = paramCursor.getShort(i);
      break label11079;
      label15190:
      paramEntity.extendFriendQuestion = paramCursor.getShort(i);
      break label11116;
      label15205:
      paramEntity.fontId = paramCursor.getInt(i);
      break label11153;
      label15220:
      paramEntity.fontType = paramCursor.getInt(i);
      break label11190;
      label15235:
      paramEntity.clothesId = paramCursor.getInt(i);
      break label11227;
      label15250:
      paramEntity.schoolId = paramCursor.getString(i);
      break label11264;
      label15265:
      paramEntity.schoolName = paramCursor.getString(i);
      break label11301;
      label15280:
      paramEntity.authState = paramCursor.getLong(i);
      break label11338;
      label15295:
      paramEntity.idx = paramCursor.getInt(i);
      break label11375;
      label15310:
      paramEntity.category = paramCursor.getInt(i);
      break label11412;
      label15325:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isShowMiniPlaying = paramBoolean;
        break;
      }
      label15352:
      paramEntity.tabJumpUrl = paramCursor.getString(i);
      break label11486;
      label15367:
      paramEntity.guestJumpUrl = paramCursor.getString(i);
      break label11523;
      label15382:
      paramEntity.guestAppTotal = paramCursor.getInt(i);
      break label11560;
      label15397:
      paramEntity.defaultCardId = paramCursor.getInt(i);
      break label11597;
      label15412:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.strangerVoteOpen = paramBoolean;
        break;
      }
      label15439:
      paramEntity.lSuperVipTemplateId = paramCursor.getLong(i);
      break label11671;
      label15454:
      paramEntity.bBigClubVipOpen = ((byte)paramCursor.getShort(i));
      break label11708;
      label15470:
      paramEntity.iBigClubVipType = paramCursor.getInt(i);
      break label11745;
      label15485:
      paramEntity.iBigClubVipLevel = paramCursor.getInt(i);
      break label11782;
      label15500:
      paramEntity.lBigClubTemplateId = paramCursor.getLong(i);
      break label11819;
      label15515:
      paramEntity.diyComplicatedInfo = paramCursor.getString(i);
      break label11856;
      label15530:
      paramEntity.cardId = paramCursor.getLong(i);
      break label11893;
      label15545:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.strangerInviteMeGroupOpen = paramBoolean;
        break;
      }
      label15572:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isPrettyGroupOwner = paramBoolean;
        break;
      }
      label15599:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isHidePrettyGroutIdentity = paramBoolean;
        break;
      }
      label15626:
      paramEntity.mQQLevelType = paramCursor.getInt(i);
    }
    label15641:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramEntity.schoolVerifiedFlag = paramBoolean;
      break;
    }
    label15668:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramEntity.troopHonorSwitch = paramBoolean;
      break;
    }
    label15696:
    paramEntity.lhLevel = paramCursor.getInt(i);
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
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,strNick TEXT ,shGender INTEGER ,shAge INTEGER ,nFaceID INTEGER ,strCertificationInfo TEXT ,shType INTEGER ,vContent BLOB ,strSign TEXT ,strCompany TEXT ,strSchool TEXT ,uFaceTimeStamp INTEGER ,vQQFaceID BLOB ,strReMark TEXT ,bWeiboInfo INTEGER ,bQzoneInfo INTEGER ,nSameFriendsNum INTEGER ,strCompanySame TEXT ,strSchoolSame TEXT ,lCardShowNum INTEGER ,bSingle INTEGER ,lVisitCount INTEGER ,lVoteCount INTEGER ,tagInfosByte BLOB ,eUserIdentityType INTEGER ,vBackground BLOB ,labelInfoBytes BLOB ,age INTEGER ,constellation INTEGER ,pyFaceUrl TEXT ,location TEXT ,bVoted INTEGER ,bFavorited INTEGER ,iVoteIncrement INTEGER ,strJoinHexAlbumFileKey TEXT ,iFaceNum INTEGER ,cSqqLevel INTEGER ,iQQLevel INTEGER ,uCurMulType INTEGER ,strProvince TEXT ,strCity TEXT ,strCountry TEXT ,lBirthday INTEGER ,strLocationCodes TEXT ,strLocationDesc TEXT ,strHometownCodes TEXT ,strHometownDesc TEXT ,strHometownCountry TEXT ,strHometownProvince TEXT ,strHometownCity TEXT ,strEmail TEXT ,strPersonalNote TEXT ,iProfession INTEGER ,bindPhoneInfo TEXT ,bCardInfo BLOB ,strTroopName TEXT ,strTroopNick TEXT ,strMobile TEXT ,strContactName TEXT ,ulShowControl INTEGER ,feedPreviewTime INTEGER ,strQzoneFeedsDesc TEXT ,StrPresentDesc TEXT ,strSpaceName TEXT ,strQzoneHeader TEXT ,vQzonePhotos BLOB ,vQzoneCoverInfo BLOB ,enlargeQzonePic INTEGER ,showPublishButton INTEGER ,strStatus TEXT ,strAutoRemark TEXT ,vSeed BLOB ,vCookies BLOB ,hasFakeData INTEGER ,bQQVipOpen INTEGER ,iQQVipType INTEGER ,iQQVipLevel INTEGER ,nameplateVipType INTEGER ,grayNameplateFlag INTEGER ,bSuperVipOpen INTEGER ,iSuperVipType INTEGER ,iSuperVipLevel INTEGER ,bSuperQQOpen INTEGER ,iSuperQQType INTEGER ,iSuperQQLevel INTEGER ,bHollywoodVipOpen INTEGER ,iHollywoodVipType INTEGER ,iHollywoodVipLevel INTEGER ,strShowName TEXT ,vRichSign BLOB ,lSignModifyTime INTEGER ,vLongNickTopicInfo BLOB ,lUserFlag INTEGER ,lLoginDays INTEGER ,strLoginDaysDesc TEXT ,lQQMasterLogindays INTEGER ,iXManScene1DelayTime INTEGER ,iXManScene2DelayTime INTEGER ,allowPeopleSee INTEGER ,allowCalInteractive INTEGER ,showOnlineFriends INTEGER ,allowClick INTEGER ,babyQSwitch INTEGER ,isSuperRedDiamond INTEGER ,isRedDiamond INTEGER ,redLevel INTEGER ,isSuperYellowDiamond INTEGER ,isYellowDiamond INTEGER ,yellowLevel INTEGER ,isSuperGreenDiamond INTEGER ,isGreenDiamond INTEGER ,greenLevel INTEGER ,templateRet INTEGER ,lCurrentStyleId INTEGER ,lCurrentBgId INTEGER ,backgroundUrl TEXT ,backgroundColor INTEGER ,dynamicCardFlag INTEGER ,strZipUrl TEXT ,strActiveUrl TEXT ,strDrawerCardUrl TEXT ,strWzryHeroUrl TEXT ,wzryHonorInfo BLOB ,strExtInfo TEXT ,strCurrentBgUrl TEXT ,bgType BLOB ,encId TEXT ,busiEntry TEXT ,favoriteSource INTEGER ,visibleMusicPendant INTEGER ,autoPlayMusicPendant INTEGER ,showRedPointMusicPendant INTEGER ,privilegePromptStr TEXT ,privilegeJumpUrl TEXT ,vOpenPriv BLOB ,vClosePriv BLOB ,presentDesc TEXT ,presentCustourl TEXT ,presentSwitch INTEGER ,showPresent INTEGER ,showMusicBox INTEGER ,addSrcName TEXT ,addSrcId INTEGER ,addSubSrcId INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,mNowShowFlag INTEGER ,mNowShowIconUrl TEXT ,mNowShowJumpUrl TEXT ,vCoverInfo BLOB ,medalSwitchDisable INTEGER ,iMedalCount INTEGER ,iNewCount INTEGER ,iUpgradeCount INTEGER ,strPromptParams TEXT ,hobbyEntry TEXT ,lastPraiseInfoList BLOB ,tempChatSig BLOB ,namePlateOfKingGameId INTEGER ,namePlateOfKingLoginTime INTEGER ,namePlateOfKingDan INTEGER ,namePlateOfKingDanDisplatSwitch INTEGER ,vPersonalityLabelV2 BLOB ,cardType INTEGER ,diyText TEXT ,diyTextFontId INTEGER ,diyTextWidth REAL ,diyTextHeight REAL ,diyTextLocX REAL ,diyTextLocY REAL ,diyTextDegree REAL ,diyTextScale REAL ,diyTextTransparency REAL ,diyDefaultText TEXT ,popularity INTEGER ,declaration TEXT ,voiceUrl TEXT ,isShowCard INTEGER ,updateTime INTEGER ,extendFriendFlag INTEGER ,extendFriendVoiceDuration INTEGER ,extendFriendEntryContact INTEGER ,extendFriendEntryAddFriend INTEGER ,extendFriendQuestion INTEGER ,fontId INTEGER ,fontType INTEGER ,clothesId INTEGER ,schoolId TEXT ,schoolName TEXT ,authState INTEGER ,idx INTEGER ,category INTEGER ,isShowMiniPlaying INTEGER ,tabJumpUrl TEXT ,guestJumpUrl TEXT ,guestAppTotal INTEGER ,defaultCardId INTEGER ,strangerVoteOpen INTEGER ,lSuperVipTemplateId INTEGER ,bBigClubVipOpen INTEGER ,iBigClubVipType INTEGER ,iBigClubVipLevel INTEGER ,lBigClubTemplateId INTEGER ,diyComplicatedInfo TEXT ,cardId INTEGER ,strangerInviteMeGroupOpen INTEGER ,isPrettyGroupOwner INTEGER ,isHidePrettyGroutIdentity INTEGER ,mQQLevelType INTEGER ,schoolVerifiedFlag INTEGER ,troopHonorSwitch INTEGER ,lhLevel INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayar
 * JD-Core Version:    0.7.0.1
 */