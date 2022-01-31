import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukd
  extends aula
{
  public aukd()
  {
    this.a = 238;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramauko = (Card)paramauko;
    label1330:
    label2406:
    label2536:
    label4842:
    if (paramaukz == null)
    {
      paramauko.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramauko.strNick = paramCursor.getString(paramCursor.getColumnIndex("strNick"));
      paramauko.shGender = paramCursor.getShort(paramCursor.getColumnIndex("shGender"));
      paramauko.shAge = paramCursor.getShort(paramCursor.getColumnIndex("shAge"));
      paramauko.nFaceID = paramCursor.getInt(paramCursor.getColumnIndex("nFaceID"));
      paramauko.strCertificationInfo = paramCursor.getString(paramCursor.getColumnIndex("strCertificationInfo"));
      paramauko.shType = paramCursor.getShort(paramCursor.getColumnIndex("shType"));
      paramauko.vContent = paramCursor.getBlob(paramCursor.getColumnIndex("vContent"));
      paramauko.strSign = paramCursor.getString(paramCursor.getColumnIndex("strSign"));
      paramauko.strCompany = paramCursor.getString(paramCursor.getColumnIndex("strCompany"));
      paramauko.strSchool = paramCursor.getString(paramCursor.getColumnIndex("strSchool"));
      paramauko.uFaceTimeStamp = paramCursor.getInt(paramCursor.getColumnIndex("uFaceTimeStamp"));
      paramauko.vQQFaceID = paramCursor.getBlob(paramCursor.getColumnIndex("vQQFaceID"));
      paramauko.strReMark = paramCursor.getString(paramCursor.getColumnIndex("strReMark"));
      paramauko.bWeiboInfo = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bWeiboInfo")));
      paramauko.bQzoneInfo = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bQzoneInfo")));
      paramauko.nSameFriendsNum = paramCursor.getInt(paramCursor.getColumnIndex("nSameFriendsNum"));
      paramauko.strCompanySame = paramCursor.getString(paramCursor.getColumnIndex("strCompanySame"));
      paramauko.strSchoolSame = paramCursor.getString(paramCursor.getColumnIndex("strSchoolSame"));
      paramauko.lCardShowNum = paramCursor.getLong(paramCursor.getColumnIndex("lCardShowNum"));
      paramauko.bSingle = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSingle")));
      paramauko.lVisitCount = paramCursor.getLong(paramCursor.getColumnIndex("lVisitCount"));
      paramauko.lVoteCount = paramCursor.getLong(paramCursor.getColumnIndex("lVoteCount"));
      paramauko.tagInfosByte = paramCursor.getBlob(paramCursor.getColumnIndex("tagInfosByte"));
      paramauko.eUserIdentityType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("eUserIdentityType")));
      paramauko.vBackground = paramCursor.getBlob(paramCursor.getColumnIndex("vBackground"));
      paramauko.labelInfoBytes = paramCursor.getBlob(paramCursor.getColumnIndex("labelInfoBytes"));
      paramauko.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramauko.constellation = paramCursor.getInt(paramCursor.getColumnIndex("constellation"));
      paramauko.pyFaceUrl = paramCursor.getString(paramCursor.getColumnIndex("pyFaceUrl"));
      paramauko.location = paramCursor.getString(paramCursor.getColumnIndex("location"));
      paramauko.bVoted = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bVoted")));
      paramauko.bFavorited = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bFavorited")));
      paramauko.iVoteIncrement = paramCursor.getInt(paramCursor.getColumnIndex("iVoteIncrement"));
      paramauko.strJoinHexAlbumFileKey = paramCursor.getString(paramCursor.getColumnIndex("strJoinHexAlbumFileKey"));
      paramauko.iFaceNum = paramCursor.getInt(paramCursor.getColumnIndex("iFaceNum"));
      paramauko.cSqqLevel = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSqqLevel")));
      paramauko.iQQLevel = paramCursor.getInt(paramCursor.getColumnIndex("iQQLevel"));
      paramauko.uCurMulType = paramCursor.getLong(paramCursor.getColumnIndex("uCurMulType"));
      paramauko.strProvince = paramCursor.getString(paramCursor.getColumnIndex("strProvince"));
      paramauko.strCity = paramCursor.getString(paramCursor.getColumnIndex("strCity"));
      paramauko.strCountry = paramCursor.getString(paramCursor.getColumnIndex("strCountry"));
      paramauko.lBirthday = paramCursor.getLong(paramCursor.getColumnIndex("lBirthday"));
      paramauko.strLocationCodes = paramCursor.getString(paramCursor.getColumnIndex("strLocationCodes"));
      paramauko.strLocationDesc = paramCursor.getString(paramCursor.getColumnIndex("strLocationDesc"));
      paramauko.strHometownCodes = paramCursor.getString(paramCursor.getColumnIndex("strHometownCodes"));
      paramauko.strHometownDesc = paramCursor.getString(paramCursor.getColumnIndex("strHometownDesc"));
      paramauko.strEmail = paramCursor.getString(paramCursor.getColumnIndex("strEmail"));
      paramauko.strPersonalNote = paramCursor.getString(paramCursor.getColumnIndex("strPersonalNote"));
      paramauko.iProfession = paramCursor.getInt(paramCursor.getColumnIndex("iProfession"));
      paramauko.bindPhoneInfo = paramCursor.getString(paramCursor.getColumnIndex("bindPhoneInfo"));
      paramauko.bCardInfo = paramCursor.getBlob(paramCursor.getColumnIndex("bCardInfo"));
      paramauko.strTroopName = paramCursor.getString(paramCursor.getColumnIndex("strTroopName"));
      paramauko.strTroopNick = paramCursor.getString(paramCursor.getColumnIndex("strTroopNick"));
      paramauko.strMobile = paramCursor.getString(paramCursor.getColumnIndex("strMobile"));
      paramauko.strContactName = paramCursor.getString(paramCursor.getColumnIndex("strContactName"));
      paramauko.ulShowControl = paramCursor.getInt(paramCursor.getColumnIndex("ulShowControl"));
      paramauko.feedPreviewTime = paramCursor.getLong(paramCursor.getColumnIndex("feedPreviewTime"));
      paramauko.strQzoneFeedsDesc = paramCursor.getString(paramCursor.getColumnIndex("strQzoneFeedsDesc"));
      paramauko.StrPresentDesc = paramCursor.getString(paramCursor.getColumnIndex("StrPresentDesc"));
      paramauko.strSpaceName = paramCursor.getString(paramCursor.getColumnIndex("strSpaceName"));
      paramauko.strQzoneHeader = paramCursor.getString(paramCursor.getColumnIndex("strQzoneHeader"));
      paramauko.vQzonePhotos = paramCursor.getBlob(paramCursor.getColumnIndex("vQzonePhotos"));
      paramauko.vQzoneCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vQzoneCoverInfo"));
      paramauko.enlargeQzonePic = paramCursor.getInt(paramCursor.getColumnIndex("enlargeQzonePic"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("showPublishButton")))
      {
        paramBoolean = true;
        paramauko.showPublishButton = paramBoolean;
        paramauko.strStatus = paramCursor.getString(paramCursor.getColumnIndex("strStatus"));
        paramauko.strAutoRemark = paramCursor.getString(paramCursor.getColumnIndex("strAutoRemark"));
        paramauko.vSeed = paramCursor.getBlob(paramCursor.getColumnIndex("vSeed"));
        paramauko.vCookies = paramCursor.getBlob(paramCursor.getColumnIndex("vCookies"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasFakeData"))) {
          break label4712;
        }
        paramBoolean = true;
        paramauko.hasFakeData = paramBoolean;
        paramauko.bQQVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bQQVipOpen")));
        paramauko.iQQVipType = paramCursor.getInt(paramCursor.getColumnIndex("iQQVipType"));
        paramauko.iQQVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iQQVipLevel"));
        paramauko.nameplateVipType = paramCursor.getInt(paramCursor.getColumnIndex("nameplateVipType"));
        paramauko.grayNameplateFlag = paramCursor.getInt(paramCursor.getColumnIndex("grayNameplateFlag"));
        paramauko.bSuperVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSuperVipOpen")));
        paramauko.iSuperVipType = paramCursor.getInt(paramCursor.getColumnIndex("iSuperVipType"));
        paramauko.iSuperVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iSuperVipLevel"));
        paramauko.bSuperQQOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSuperQQOpen")));
        paramauko.iSuperQQType = paramCursor.getInt(paramCursor.getColumnIndex("iSuperQQType"));
        paramauko.iSuperQQLevel = paramCursor.getInt(paramCursor.getColumnIndex("iSuperQQLevel"));
        paramauko.bHollywoodVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bHollywoodVipOpen")));
        paramauko.iHollywoodVipType = paramCursor.getInt(paramCursor.getColumnIndex("iHollywoodVipType"));
        paramauko.iHollywoodVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iHollywoodVipLevel"));
        paramauko.strShowName = paramCursor.getString(paramCursor.getColumnIndex("strShowName"));
        paramauko.strVoiceFilekey = paramCursor.getString(paramCursor.getColumnIndex("strVoiceFilekey"));
        paramauko.shDuration = paramCursor.getShort(paramCursor.getColumnIndex("shDuration"));
        paramauko.bRead = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bRead")));
        paramauko.strUrl = paramCursor.getString(paramCursor.getColumnIndex("strUrl"));
        paramauko.vRichSign = paramCursor.getBlob(paramCursor.getColumnIndex("vRichSign"));
        paramauko.lSignModifyTime = paramCursor.getLong(paramCursor.getColumnIndex("lSignModifyTime"));
        paramauko.vLongNickTopicInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vLongNickTopicInfo"));
        paramauko.nLastGameFlag = paramCursor.getInt(paramCursor.getColumnIndex("nLastGameFlag"));
        paramauko.strGameLogoUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_1"));
        paramauko.strGameLogoUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_2"));
        paramauko.strGameLogoUrl_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_3"));
        paramauko.strGameLogoUrl_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_4"));
        paramauko.strGameLogoKey_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_1"));
        paramauko.strGameLogoKey_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_2"));
        paramauko.strGameLogoKey_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_3"));
        paramauko.strGameLogoKey_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_4"));
        paramauko.strGameName_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_1"));
        paramauko.strGameName_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_2"));
        paramauko.strGameName_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_3"));
        paramauko.strGameName_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_4"));
        paramauko.strGameAppid_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_1"));
        paramauko.strGameAppid_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_2"));
        paramauko.strGameAppid_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_3"));
        paramauko.strGameAppid_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_4"));
        paramauko.strProfileUrl = paramCursor.getString(paramCursor.getColumnIndex("strProfileUrl"));
        paramauko.nStarFansFlag = paramCursor.getInt(paramCursor.getColumnIndex("nStarFansFlag"));
        paramauko.strStarPicUrl_0 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_0"));
        paramauko.strStarPicUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_1"));
        paramauko.strStarPicUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_2"));
        paramauko.strStarLvUrl_0 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_0"));
        paramauko.strStarLvUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_1"));
        paramauko.strStarLvUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_2"));
        paramauko.strStarLogoUrl = paramCursor.getString(paramCursor.getColumnIndex("strStarLogoUrl"));
        paramauko.starFansJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("starFansJumpUrl"));
        paramauko.lUserFlag = paramCursor.getLong(paramCursor.getColumnIndex("lUserFlag"));
        paramauko.lLoginDays = paramCursor.getLong(paramCursor.getColumnIndex("lLoginDays"));
        paramauko.strLoginDaysDesc = paramCursor.getString(paramCursor.getColumnIndex("strLoginDaysDesc"));
        paramauko.lQQMasterLogindays = paramCursor.getLong(paramCursor.getColumnIndex("lQQMasterLogindays"));
        paramauko.iXManScene1DelayTime = paramCursor.getInt(paramCursor.getColumnIndex("iXManScene1DelayTime"));
        paramauko.iXManScene2DelayTime = paramCursor.getInt(paramCursor.getColumnIndex("iXManScene2DelayTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowPeopleSee"))) {
          break label4717;
        }
        paramBoolean = true;
        paramauko.allowPeopleSee = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowCalInteractive"))) {
          break label4722;
        }
        paramBoolean = true;
        paramauko.allowCalInteractive = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showOnlineFriends"))) {
          break label4727;
        }
        paramBoolean = true;
        paramauko.showOnlineFriends = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowClick"))) {
          break label4732;
        }
        paramBoolean = true;
        paramauko.allowClick = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("babyQSwitch"))) {
          break label4737;
        }
        paramBoolean = true;
        paramauko.babyQSwitch = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showLightalk"))) {
          break label4742;
        }
        paramBoolean = true;
        paramauko.showLightalk = paramBoolean;
        paramauko.lightalkNick = paramCursor.getString(paramCursor.getColumnIndex("lightalkNick"));
        paramauko.lightalkId = paramCursor.getString(paramCursor.getColumnIndex("lightalkId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperRedDiamond"))) {
          break label4747;
        }
        paramBoolean = true;
        paramauko.isSuperRedDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRedDiamond"))) {
          break label4752;
        }
        paramBoolean = true;
        paramauko.isRedDiamond = paramBoolean;
        paramauko.redLevel = paramCursor.getInt(paramCursor.getColumnIndex("redLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperYellowDiamond"))) {
          break label4757;
        }
        paramBoolean = true;
        label2671:
        paramauko.isSuperYellowDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isYellowDiamond"))) {
          break label4762;
        }
        paramBoolean = true;
        paramauko.isYellowDiamond = paramBoolean;
        paramauko.yellowLevel = paramCursor.getInt(paramCursor.getColumnIndex("yellowLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperGreenDiamond"))) {
          break label4767;
        }
        paramBoolean = true;
        paramauko.isSuperGreenDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isGreenDiamond"))) {
          break label4772;
        }
        paramBoolean = true;
        paramauko.isGreenDiamond = paramBoolean;
        paramauko.greenLevel = paramCursor.getInt(paramCursor.getColumnIndex("greenLevel"));
        paramauko.uAccelerateMultiple = paramCursor.getLong(paramCursor.getColumnIndex("uAccelerateMultiple"));
        paramauko.strRespMusicInfo = paramCursor.getString(paramCursor.getColumnIndex("strRespMusicInfo"));
        paramauko.templateRet = paramCursor.getInt(paramCursor.getColumnIndex("templateRet"));
        paramauko.lCurrentStyleId = paramCursor.getLong(paramCursor.getColumnIndex("lCurrentStyleId"));
        paramauko.lCurrentBgId = paramCursor.getLong(paramCursor.getColumnIndex("lCurrentBgId"));
        paramauko.backgroundUrl = paramCursor.getString(paramCursor.getColumnIndex("backgroundUrl"));
        paramauko.backgroundColor = paramCursor.getLong(paramCursor.getColumnIndex("backgroundColor"));
        paramauko.dynamicCardFlag = paramCursor.getInt(paramCursor.getColumnIndex("dynamicCardFlag"));
        paramauko.strZipUrl = paramCursor.getString(paramCursor.getColumnIndex("strZipUrl"));
        paramauko.strActiveUrl = paramCursor.getString(paramCursor.getColumnIndex("strActiveUrl"));
        paramauko.strDrawerCardUrl = paramCursor.getString(paramCursor.getColumnIndex("strDrawerCardUrl"));
        paramauko.strWzryHeroUrl = paramCursor.getString(paramCursor.getColumnIndex("strWzryHeroUrl"));
        paramauko.wzryHonorInfo = paramCursor.getBlob(paramCursor.getColumnIndex("wzryHonorInfo"));
        paramauko.strExtInfo = paramCursor.getString(paramCursor.getColumnIndex("strExtInfo"));
        paramauko.strCurrentBgUrl = paramCursor.getString(paramCursor.getColumnIndex("strCurrentBgUrl"));
        paramauko.bgType = paramCursor.getBlob(paramCursor.getColumnIndex("bgType"));
        paramauko.encId = paramCursor.getString(paramCursor.getColumnIndex("encId"));
        paramauko.busiEntry = paramCursor.getString(paramCursor.getColumnIndex("busiEntry"));
        paramauko.favoriteSource = paramCursor.getInt(paramCursor.getColumnIndex("favoriteSource"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("visibleMusicPendant"))) {
          break label4777;
        }
        paramBoolean = true;
        paramauko.visibleMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("autoPlayMusicPendant"))) {
          break label4782;
        }
        paramBoolean = true;
        paramauko.autoPlayMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showRedPointMusicPendant"))) {
          break label4787;
        }
        paramBoolean = true;
        paramauko.showRedPointMusicPendant = paramBoolean;
        paramauko.privilegePromptStr = paramCursor.getString(paramCursor.getColumnIndex("privilegePromptStr"));
        paramauko.privilegeJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("privilegeJumpUrl"));
        paramauko.vOpenPriv = paramCursor.getBlob(paramCursor.getColumnIndex("vOpenPriv"));
        paramauko.vClosePriv = paramCursor.getBlob(paramCursor.getColumnIndex("vClosePriv"));
        paramauko.presentDesc = paramCursor.getString(paramCursor.getColumnIndex("presentDesc"));
        paramauko.presentCustourl = paramCursor.getString(paramCursor.getColumnIndex("presentCustourl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("presentSwitch"))) {
          break label4792;
        }
        paramBoolean = true;
        paramauko.presentSwitch = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showPresent"))) {
          break label4797;
        }
        paramBoolean = true;
        paramauko.showPresent = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showMusicBox"))) {
          break label4802;
        }
        paramBoolean = true;
        paramauko.showMusicBox = paramBoolean;
        paramauko.addSrcName = paramCursor.getString(paramCursor.getColumnIndex("addSrcName"));
        paramauko.addSrcId = paramCursor.getLong(paramCursor.getColumnIndex("addSrcId"));
        paramauko.addSubSrcId = paramCursor.getLong(paramCursor.getColumnIndex("addSubSrcId"));
        paramauko.strVoteLimitedNotice = paramCursor.getString(paramCursor.getColumnIndex("strVoteLimitedNotice"));
        paramauko.bHaveVotedCnt = paramCursor.getShort(paramCursor.getColumnIndex("bHaveVotedCnt"));
        paramauko.bAvailVoteCnt = paramCursor.getShort(paramCursor.getColumnIndex("bAvailVoteCnt"));
        paramauko.olympicTorch = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("olympicTorch")));
        paramauko.mNowShowFlag = paramCursor.getInt(paramCursor.getColumnIndex("mNowShowFlag"));
        paramauko.mNowShowIconUrl = paramCursor.getString(paramCursor.getColumnIndex("mNowShowIconUrl"));
        paramauko.mNowShowJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("mNowShowJumpUrl"));
        paramauko.vCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vCoverInfo"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("videoHeadFlag"))) {
          break label4807;
        }
        paramBoolean = true;
        paramauko.videoHeadFlag = paramBoolean;
        paramauko.videoHeadUrl = paramCursor.getString(paramCursor.getColumnIndex("videoHeadUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("medalSwitchDisable"))) {
          break label4812;
        }
        paramBoolean = true;
        label3699:
        paramauko.medalSwitchDisable = paramBoolean;
        paramauko.iMedalCount = paramCursor.getInt(paramCursor.getColumnIndex("iMedalCount"));
        paramauko.iNewCount = paramCursor.getInt(paramCursor.getColumnIndex("iNewCount"));
        paramauko.iUpgradeCount = paramCursor.getInt(paramCursor.getColumnIndex("iUpgradeCount"));
        paramauko.strPromptParams = paramCursor.getString(paramCursor.getColumnIndex("strPromptParams"));
        paramauko.hobbyEntry = paramCursor.getString(paramCursor.getColumnIndex("hobbyEntry"));
        paramauko.lastPraiseInfoList = paramCursor.getBlob(paramCursor.getColumnIndex("lastPraiseInfoList"));
        paramauko.tempChatSig = paramCursor.getBlob(paramCursor.getColumnIndex("tempChatSig"));
        paramauko.namePlateOfKingGameId = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingGameId"));
        paramauko.namePlateOfKingLoginTime = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingLoginTime"));
        paramauko.namePlateOfKingDan = paramCursor.getInt(paramCursor.getColumnIndex("namePlateOfKingDan"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch"))) {
          break label4817;
        }
        paramBoolean = true;
        paramauko.namePlateOfKingDanDisplatSwitch = paramBoolean;
        paramauko.vPersonalityLabelV2 = paramCursor.getBlob(paramCursor.getColumnIndex("vPersonalityLabelV2"));
        paramauko.cardType = paramCursor.getInt(paramCursor.getColumnIndex("cardType"));
        paramauko.diyText = paramCursor.getString(paramCursor.getColumnIndex("diyText"));
        paramauko.diyTextFontId = paramCursor.getInt(paramCursor.getColumnIndex("diyTextFontId"));
        paramauko.diyTextWidth = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextWidth"));
        paramauko.diyTextHeight = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextHeight"));
        paramauko.diyTextLocX = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextLocX"));
        paramauko.diyTextLocY = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextLocY"));
        paramauko.diyTextDegree = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextDegree"));
        paramauko.diyTextScale = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextScale"));
        paramauko.diyTextTransparency = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextTransparency"));
        paramauko.diyDefaultText = paramCursor.getString(paramCursor.getColumnIndex("diyDefaultText"));
        paramauko.popularity = paramCursor.getInt(paramCursor.getColumnIndex("popularity"));
        paramauko.declaration = paramCursor.getString(paramCursor.getColumnIndex("declaration"));
        paramauko.voiceUrl = paramCursor.getString(paramCursor.getColumnIndex("voiceUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShowCard"))) {
          break label4822;
        }
        paramBoolean = true;
        paramauko.isShowCard = paramBoolean;
        paramauko.updateTime = paramCursor.getLong(paramCursor.getColumnIndex("updateTime"));
        paramauko.extendFriendFlag = paramCursor.getInt(paramCursor.getColumnIndex("extendFriendFlag"));
        paramauko.extendFriendVoiceDuration = paramCursor.getInt(paramCursor.getColumnIndex("extendFriendVoiceDuration"));
        paramauko.extendFriendEntryContact = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendEntryContact"));
        paramauko.extendFriendEntryAddFriend = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendEntryAddFriend"));
        paramauko.extendFriendQuestion = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendQuestion"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShowMiniPlaying"))) {
          break label4827;
        }
        paramBoolean = true;
        paramauko.isShowMiniPlaying = paramBoolean;
        paramauko.tabJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("tabJumpUrl"));
        paramauko.guestJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("guestJumpUrl"));
        paramauko.guestAppTotal = paramCursor.getInt(paramCursor.getColumnIndex("guestAppTotal"));
        paramauko.defaultCardId = paramCursor.getInt(paramCursor.getColumnIndex("defaultCardId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("strangerVoteOpen"))) {
          break label4832;
        }
        paramBoolean = true;
        label4468:
        paramauko.strangerVoteOpen = paramBoolean;
        paramauko.lSuperVipTemplateId = paramCursor.getLong(paramCursor.getColumnIndex("lSuperVipTemplateId"));
        paramauko.bBigClubVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bBigClubVipOpen")));
        paramauko.iBigClubVipType = paramCursor.getInt(paramCursor.getColumnIndex("iBigClubVipType"));
        paramauko.iBigClubVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iBigClubVipLevel"));
        paramauko.lBigClubTemplateId = paramCursor.getLong(paramCursor.getColumnIndex("lBigClubTemplateId"));
        paramauko.diyComplicatedInfo = paramCursor.getString(paramCursor.getColumnIndex("diyComplicatedInfo"));
        paramauko.cardId = paramCursor.getLong(paramCursor.getColumnIndex("cardId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("strangerInviteMeGroupOpen"))) {
          break label4837;
        }
        paramBoolean = true;
        paramauko.strangerInviteMeGroupOpen = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isPrettyGroupOwner"))) {
          break label4842;
        }
        paramBoolean = true;
        paramauko.isPrettyGroupOwner = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isHidePrettyGroutIdentity"))) {
          break label4847;
        }
      }
      label4717:
      label4847:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramauko.isHidePrettyGroutIdentity = paramBoolean;
        paramauko.mQQLevelType = paramCursor.getInt(paramCursor.getColumnIndex("mQQLevelType"));
        return paramauko;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label1330;
        paramBoolean = false;
        break label2406;
        label4722:
        paramBoolean = false;
        break label2432;
        label4727:
        paramBoolean = false;
        break label2458;
        label4732:
        paramBoolean = false;
        break label2484;
        paramBoolean = false;
        break label2510;
        paramBoolean = false;
        break label2536;
        paramBoolean = false;
        break label2600;
        paramBoolean = false;
        break label2626;
        paramBoolean = false;
        break label2671;
        paramBoolean = false;
        break label2697;
        paramBoolean = false;
        break label2742;
        paramBoolean = false;
        break label2768;
        paramBoolean = false;
        break label3174;
        paramBoolean = false;
        break label3200;
        paramBoolean = false;
        break label3226;
        paramBoolean = false;
        break label3366;
        paramBoolean = false;
        break label3392;
        paramBoolean = false;
        break label3418;
        paramBoolean = false;
        break label3654;
        paramBoolean = false;
        break label3699;
        paramBoolean = false;
        break label3915;
        paramBoolean = false;
        break label4226;
        paramBoolean = false;
        break label4366;
        paramBoolean = false;
        break label4468;
        paramBoolean = false;
        break label4628;
        paramBoolean = false;
        break label4654;
      }
    }
    label2432:
    label2458:
    label2484:
    label2510:
    label2768:
    label3174:
    label4712:
    int i = paramCursor.getColumnIndex("uin");
    label2600:
    label2626:
    label3418:
    label4827:
    label4832:
    label4837:
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("strNick");
      if (i != -1) {
        break label13571;
      }
      paramaukz.a(new NoColumnError("strNick", String.class));
      i = paramCursor.getColumnIndex("shGender");
      if (i != -1) {
        break label13586;
      }
      paramaukz.a(new NoColumnError("shGender", Short.TYPE));
      i = paramCursor.getColumnIndex("shAge");
      if (i != -1) {
        break label13601;
      }
      paramaukz.a(new NoColumnError("shAge", Short.TYPE));
      i = paramCursor.getColumnIndex("nFaceID");
      if (i != -1) {
        break label13616;
      }
      paramaukz.a(new NoColumnError("nFaceID", Integer.TYPE));
      i = paramCursor.getColumnIndex("strCertificationInfo");
      if (i != -1) {
        break label13631;
      }
      paramaukz.a(new NoColumnError("strCertificationInfo", String.class));
      i = paramCursor.getColumnIndex("shType");
      if (i != -1) {
        break label13646;
      }
      paramaukz.a(new NoColumnError("shType", Short.TYPE));
      label5097:
      i = paramCursor.getColumnIndex("vContent");
      if (i != -1) {
        break label13661;
      }
      paramaukz.a(new NoColumnError("vContent", [B.class));
      i = paramCursor.getColumnIndex("strSign");
      if (i != -1) {
        break label13676;
      }
      paramaukz.a(new NoColumnError("strSign", String.class));
      i = paramCursor.getColumnIndex("strCompany");
      if (i != -1) {
        break label13691;
      }
      paramaukz.a(new NoColumnError("strCompany", String.class));
      i = paramCursor.getColumnIndex("strSchool");
      if (i != -1) {
        break label13706;
      }
      paramaukz.a(new NoColumnError("strSchool", String.class));
      label5237:
      i = paramCursor.getColumnIndex("uFaceTimeStamp");
      if (i != -1) {
        break label13721;
      }
      paramaukz.a(new NoColumnError("uFaceTimeStamp", Integer.TYPE));
      i = paramCursor.getColumnIndex("vQQFaceID");
      if (i != -1) {
        break label13736;
      }
      paramaukz.a(new NoColumnError("vQQFaceID", [B.class));
      i = paramCursor.getColumnIndex("strReMark");
      if (i != -1) {
        break label13751;
      }
      paramaukz.a(new NoColumnError("strReMark", String.class));
      i = paramCursor.getColumnIndex("bWeiboInfo");
      if (i != -1) {
        break label13766;
      }
      paramaukz.a(new NoColumnError("bWeiboInfo", Byte.TYPE));
      i = paramCursor.getColumnIndex("bQzoneInfo");
      if (i != -1) {
        break label13782;
      }
      paramaukz.a(new NoColumnError("bQzoneInfo", Byte.TYPE));
      i = paramCursor.getColumnIndex("nSameFriendsNum");
      if (i != -1) {
        break label13798;
      }
      paramaukz.a(new NoColumnError("nSameFriendsNum", Integer.TYPE));
      i = paramCursor.getColumnIndex("strCompanySame");
      if (i != -1) {
        break label13813;
      }
      paramaukz.a(new NoColumnError("strCompanySame", String.class));
      label5482:
      i = paramCursor.getColumnIndex("strSchoolSame");
      if (i != -1) {
        break label13828;
      }
      paramaukz.a(new NoColumnError("strSchoolSame", String.class));
      i = paramCursor.getColumnIndex("lCardShowNum");
      if (i != -1) {
        break label13843;
      }
      paramaukz.a(new NoColumnError("lCardShowNum", Long.TYPE));
      i = paramCursor.getColumnIndex("bSingle");
      if (i != -1) {
        break label13858;
      }
      paramaukz.a(new NoColumnError("bSingle", Byte.TYPE));
      i = paramCursor.getColumnIndex("lVisitCount");
      if (i != -1) {
        break label13874;
      }
      paramaukz.a(new NoColumnError("lVisitCount", Long.TYPE));
      label5622:
      i = paramCursor.getColumnIndex("lVoteCount");
      if (i != -1) {
        break label13889;
      }
      paramaukz.a(new NoColumnError("lVoteCount", Long.TYPE));
      i = paramCursor.getColumnIndex("tagInfosByte");
      if (i != -1) {
        break label13904;
      }
      paramaukz.a(new NoColumnError("tagInfosByte", [B.class));
      i = paramCursor.getColumnIndex("eUserIdentityType");
      if (i != -1) {
        break label13919;
      }
      paramaukz.a(new NoColumnError("eUserIdentityType", Byte.TYPE));
      i = paramCursor.getColumnIndex("vBackground");
      if (i != -1) {
        break label13935;
      }
      paramaukz.a(new NoColumnError("vBackground", [B.class));
      i = paramCursor.getColumnIndex("labelInfoBytes");
      if (i != -1) {
        break label13950;
      }
      paramaukz.a(new NoColumnError("labelInfoBytes", [B.class));
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label13965;
      }
      paramaukz.a(new NoColumnError("age", Byte.TYPE));
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label13981;
      }
      paramaukz.a(new NoColumnError("constellation", Integer.TYPE));
      label5867:
      i = paramCursor.getColumnIndex("pyFaceUrl");
      if (i != -1) {
        break label13996;
      }
      paramaukz.a(new NoColumnError("pyFaceUrl", String.class));
      i = paramCursor.getColumnIndex("location");
      if (i != -1) {
        break label14011;
      }
      paramaukz.a(new NoColumnError("location", String.class));
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label14026;
      }
      paramaukz.a(new NoColumnError("bVoted", Byte.TYPE));
      i = paramCursor.getColumnIndex("bFavorited");
      if (i != -1) {
        break label14042;
      }
      paramaukz.a(new NoColumnError("bFavorited", Byte.TYPE));
      label6007:
      i = paramCursor.getColumnIndex("iVoteIncrement");
      if (i != -1) {
        break label14058;
      }
      paramaukz.a(new NoColumnError("iVoteIncrement", Integer.TYPE));
      i = paramCursor.getColumnIndex("strJoinHexAlbumFileKey");
      if (i != -1) {
        break label14073;
      }
      paramaukz.a(new NoColumnError("strJoinHexAlbumFileKey", String.class));
      i = paramCursor.getColumnIndex("iFaceNum");
      if (i != -1) {
        break label14088;
      }
      paramaukz.a(new NoColumnError("iFaceNum", Integer.TYPE));
      i = paramCursor.getColumnIndex("cSqqLevel");
      if (i != -1) {
        break label14103;
      }
      paramaukz.a(new NoColumnError("cSqqLevel", Byte.TYPE));
      i = paramCursor.getColumnIndex("iQQLevel");
      if (i != -1) {
        break label14119;
      }
      paramaukz.a(new NoColumnError("iQQLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("uCurMulType");
      if (i != -1) {
        break label14134;
      }
      paramaukz.a(new NoColumnError("uCurMulType", Long.TYPE));
      i = paramCursor.getColumnIndex("strProvince");
      if (i != -1) {
        break label14149;
      }
      paramaukz.a(new NoColumnError("strProvince", String.class));
      label6252:
      i = paramCursor.getColumnIndex("strCity");
      if (i != -1) {
        break label14164;
      }
      paramaukz.a(new NoColumnError("strCity", String.class));
      i = paramCursor.getColumnIndex("strCountry");
      if (i != -1) {
        break label14179;
      }
      paramaukz.a(new NoColumnError("strCountry", String.class));
      i = paramCursor.getColumnIndex("lBirthday");
      if (i != -1) {
        break label14194;
      }
      paramaukz.a(new NoColumnError("lBirthday", Long.TYPE));
      i = paramCursor.getColumnIndex("strLocationCodes");
      if (i != -1) {
        break label14209;
      }
      paramaukz.a(new NoColumnError("strLocationCodes", String.class));
      label6392:
      i = paramCursor.getColumnIndex("strLocationDesc");
      if (i != -1) {
        break label14224;
      }
      paramaukz.a(new NoColumnError("strLocationDesc", String.class));
      i = paramCursor.getColumnIndex("strHometownCodes");
      if (i != -1) {
        break label14239;
      }
      paramaukz.a(new NoColumnError("strHometownCodes", String.class));
      i = paramCursor.getColumnIndex("strHometownDesc");
      if (i != -1) {
        break label14254;
      }
      paramaukz.a(new NoColumnError("strHometownDesc", String.class));
      i = paramCursor.getColumnIndex("strEmail");
      if (i != -1) {
        break label14269;
      }
      paramaukz.a(new NoColumnError("strEmail", String.class));
      i = paramCursor.getColumnIndex("strPersonalNote");
      if (i != -1) {
        break label14284;
      }
      paramaukz.a(new NoColumnError("strPersonalNote", String.class));
      i = paramCursor.getColumnIndex("iProfession");
      if (i != -1) {
        break label14299;
      }
      paramaukz.a(new NoColumnError("iProfession", Integer.TYPE));
      i = paramCursor.getColumnIndex("bindPhoneInfo");
      if (i != -1) {
        break label14314;
      }
      paramaukz.a(new NoColumnError("bindPhoneInfo", String.class));
      label6637:
      i = paramCursor.getColumnIndex("bCardInfo");
      if (i != -1) {
        break label14329;
      }
      paramaukz.a(new NoColumnError("bCardInfo", [B.class));
      i = paramCursor.getColumnIndex("strTroopName");
      if (i != -1) {
        break label14344;
      }
      paramaukz.a(new NoColumnError("strTroopName", String.class));
      i = paramCursor.getColumnIndex("strTroopNick");
      if (i != -1) {
        break label14359;
      }
      paramaukz.a(new NoColumnError("strTroopNick", String.class));
      i = paramCursor.getColumnIndex("strMobile");
      if (i != -1) {
        break label14374;
      }
      paramaukz.a(new NoColumnError("strMobile", String.class));
      label6783:
      i = paramCursor.getColumnIndex("strContactName");
      if (i != -1) {
        break label14389;
      }
      paramaukz.a(new NoColumnError("strContactName", String.class));
      i = paramCursor.getColumnIndex("ulShowControl");
      if (i != -1) {
        break label14404;
      }
      paramaukz.a(new NoColumnError("ulShowControl", Integer.TYPE));
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label14419;
      }
      paramaukz.a(new NoColumnError("feedPreviewTime", Long.TYPE));
      label6894:
      i = paramCursor.getColumnIndex("strQzoneFeedsDesc");
      if (i != -1) {
        break label14434;
      }
      paramaukz.a(new NoColumnError("strQzoneFeedsDesc", String.class));
      i = paramCursor.getColumnIndex("StrPresentDesc");
      if (i != -1) {
        break label14449;
      }
      paramaukz.a(new NoColumnError("StrPresentDesc", String.class));
      i = paramCursor.getColumnIndex("strSpaceName");
      if (i != -1) {
        break label14464;
      }
      paramaukz.a(new NoColumnError("strSpaceName", String.class));
      i = paramCursor.getColumnIndex("strQzoneHeader");
      if (i != -1) {
        break label14479;
      }
      paramaukz.a(new NoColumnError("strQzoneHeader", String.class));
      i = paramCursor.getColumnIndex("vQzonePhotos");
      if (i != -1) {
        break label14494;
      }
      paramaukz.a(new NoColumnError("vQzonePhotos", [B.class));
      i = paramCursor.getColumnIndex("vQzoneCoverInfo");
      if (i != -1) {
        break label14509;
      }
      paramaukz.a(new NoColumnError("vQzoneCoverInfo", [B.class));
      i = paramCursor.getColumnIndex("enlargeQzonePic");
      if (i != -1) {
        break label14524;
      }
      paramaukz.a(new NoColumnError("enlargeQzonePic", Integer.TYPE));
      label7153:
      i = paramCursor.getColumnIndex("showPublishButton");
      if (i != -1) {
        break label14539;
      }
      paramaukz.a(new NoColumnError("showPublishButton", Boolean.TYPE));
      i = paramCursor.getColumnIndex("strStatus");
      if (i != -1) {
        break label14566;
      }
      paramaukz.a(new NoColumnError("strStatus", String.class));
      i = paramCursor.getColumnIndex("strAutoRemark");
      if (i != -1) {
        break label14581;
      }
      paramaukz.a(new NoColumnError("strAutoRemark", String.class));
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label14596;
      }
      paramaukz.a(new NoColumnError("vSeed", [B.class));
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label14611;
      }
      paramaukz.a(new NoColumnError("vCookies", [B.class));
      i = paramCursor.getColumnIndex("hasFakeData");
      if (i != -1) {
        break label14626;
      }
      paramaukz.a(new NoColumnError("hasFakeData", Boolean.TYPE));
      i = paramCursor.getColumnIndex("bQQVipOpen");
      if (i != -1) {
        break label14653;
      }
      paramaukz.a(new NoColumnError("bQQVipOpen", Byte.TYPE));
      label7412:
      i = paramCursor.getColumnIndex("iQQVipType");
      if (i != -1) {
        break label14669;
      }
      paramaukz.a(new NoColumnError("iQQVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iQQVipLevel");
      if (i != -1) {
        break label14684;
      }
      paramaukz.a(new NoColumnError("iQQVipLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("nameplateVipType");
      if (i != -1) {
        break label14699;
      }
      paramaukz.a(new NoColumnError("nameplateVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("grayNameplateFlag");
      if (i != -1) {
        break label14714;
      }
      paramaukz.a(new NoColumnError("grayNameplateFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("bSuperVipOpen");
      if (i != -1) {
        break label14729;
      }
      paramaukz.a(new NoColumnError("bSuperVipOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iSuperVipType");
      if (i != -1) {
        break label14745;
      }
      paramaukz.a(new NoColumnError("iSuperVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iSuperVipLevel");
      if (i != -1) {
        break label14760;
      }
      paramaukz.a(new NoColumnError("iSuperVipLevel", Integer.TYPE));
      label7671:
      i = paramCursor.getColumnIndex("bSuperQQOpen");
      if (i != -1) {
        break label14775;
      }
      paramaukz.a(new NoColumnError("bSuperQQOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iSuperQQType");
      if (i != -1) {
        break label14791;
      }
      paramaukz.a(new NoColumnError("iSuperQQType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iSuperQQLevel");
      if (i != -1) {
        break label14806;
      }
      paramaukz.a(new NoColumnError("iSuperQQLevel", Integer.TYPE));
      label7782:
      i = paramCursor.getColumnIndex("bHollywoodVipOpen");
      if (i != -1) {
        break label14821;
      }
      paramaukz.a(new NoColumnError("bHollywoodVipOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iHollywoodVipType");
      if (i != -1) {
        break label14837;
      }
      paramaukz.a(new NoColumnError("iHollywoodVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iHollywoodVipLevel");
      if (i != -1) {
        break label14852;
      }
      paramaukz.a(new NoColumnError("iHollywoodVipLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("strShowName");
      if (i != -1) {
        break label14867;
      }
      paramaukz.a(new NoColumnError("strShowName", String.class));
      label7930:
      i = paramCursor.getColumnIndex("strVoiceFilekey");
      if (i != -1) {
        break label14882;
      }
      paramaukz.a(new NoColumnError("strVoiceFilekey", String.class));
      i = paramCursor.getColumnIndex("shDuration");
      if (i != -1) {
        break label14897;
      }
      paramaukz.a(new NoColumnError("shDuration", Short.TYPE));
      i = paramCursor.getColumnIndex("bRead");
      if (i != -1) {
        break label14912;
      }
      paramaukz.a(new NoColumnError("bRead", Byte.TYPE));
      label8041:
      i = paramCursor.getColumnIndex("strUrl");
      if (i != -1) {
        break label14928;
      }
      paramaukz.a(new NoColumnError("strUrl", String.class));
      i = paramCursor.getColumnIndex("vRichSign");
      if (i != -1) {
        break label14943;
      }
      paramaukz.a(new NoColumnError("vRichSign", [B.class));
      i = paramCursor.getColumnIndex("lSignModifyTime");
      if (i != -1) {
        break label14958;
      }
      paramaukz.a(new NoColumnError("lSignModifyTime", Long.TYPE));
      i = paramCursor.getColumnIndex("vLongNickTopicInfo");
      if (i != -1) {
        break label14973;
      }
      paramaukz.a(new NoColumnError("vLongNickTopicInfo", [B.class));
      label8189:
      i = paramCursor.getColumnIndex("nLastGameFlag");
      if (i != -1) {
        break label14988;
      }
      paramaukz.a(new NoColumnError("nLastGameFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("strGameLogoUrl_1");
      if (i != -1) {
        break label15003;
      }
      paramaukz.a(new NoColumnError("strGameLogoUrl_1", String.class));
      i = paramCursor.getColumnIndex("strGameLogoUrl_2");
      if (i != -1) {
        break label15018;
      }
      paramaukz.a(new NoColumnError("strGameLogoUrl_2", String.class));
      label8300:
      i = paramCursor.getColumnIndex("strGameLogoUrl_3");
      if (i != -1) {
        break label15033;
      }
      paramaukz.a(new NoColumnError("strGameLogoUrl_3", String.class));
      i = paramCursor.getColumnIndex("strGameLogoUrl_4");
      if (i != -1) {
        break label15048;
      }
      paramaukz.a(new NoColumnError("strGameLogoUrl_4", String.class));
      i = paramCursor.getColumnIndex("strGameLogoKey_1");
      if (i != -1) {
        break label15063;
      }
      paramaukz.a(new NoColumnError("strGameLogoKey_1", String.class));
      i = paramCursor.getColumnIndex("strGameLogoKey_2");
      if (i != -1) {
        break label15078;
      }
      paramaukz.a(new NoColumnError("strGameLogoKey_2", String.class));
      i = paramCursor.getColumnIndex("strGameLogoKey_3");
      if (i != -1) {
        break label15093;
      }
      paramaukz.a(new NoColumnError("strGameLogoKey_3", String.class));
      i = paramCursor.getColumnIndex("strGameLogoKey_4");
      if (i != -1) {
        break label15108;
      }
      paramaukz.a(new NoColumnError("strGameLogoKey_4", String.class));
      i = paramCursor.getColumnIndex("strGameName_1");
      if (i != -1) {
        break label15123;
      }
      paramaukz.a(new NoColumnError("strGameName_1", String.class));
      label8559:
      i = paramCursor.getColumnIndex("strGameName_2");
      if (i != -1) {
        break label15138;
      }
      paramaukz.a(new NoColumnError("strGameName_2", String.class));
      i = paramCursor.getColumnIndex("strGameName_3");
      if (i != -1) {
        break label15153;
      }
      paramaukz.a(new NoColumnError("strGameName_3", String.class));
      i = paramCursor.getColumnIndex("strGameName_4");
      if (i != -1) {
        break label15168;
      }
      paramaukz.a(new NoColumnError("strGameName_4", String.class));
      i = paramCursor.getColumnIndex("strGameAppid_1");
      if (i != -1) {
        break label15183;
      }
      paramaukz.a(new NoColumnError("strGameAppid_1", String.class));
      i = paramCursor.getColumnIndex("strGameAppid_2");
      if (i != -1) {
        break label15198;
      }
      paramaukz.a(new NoColumnError("strGameAppid_2", String.class));
      i = paramCursor.getColumnIndex("strGameAppid_3");
      if (i != -1) {
        break label15213;
      }
      paramaukz.a(new NoColumnError("strGameAppid_3", String.class));
      i = paramCursor.getColumnIndex("strGameAppid_4");
      if (i != -1) {
        break label15228;
      }
      paramaukz.a(new NoColumnError("strGameAppid_4", String.class));
      label8818:
      i = paramCursor.getColumnIndex("strProfileUrl");
      if (i != -1) {
        break label15243;
      }
      paramaukz.a(new NoColumnError("strProfileUrl", String.class));
      i = paramCursor.getColumnIndex("nStarFansFlag");
      if (i != -1) {
        break label15258;
      }
      paramaukz.a(new NoColumnError("nStarFansFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("strStarPicUrl_0");
      if (i != -1) {
        break label15273;
      }
      paramaukz.a(new NoColumnError("strStarPicUrl_0", String.class));
      i = paramCursor.getColumnIndex("strStarPicUrl_1");
      if (i != -1) {
        break label15288;
      }
      paramaukz.a(new NoColumnError("strStarPicUrl_1", String.class));
      i = paramCursor.getColumnIndex("strStarPicUrl_2");
      if (i != -1) {
        break label15303;
      }
      paramaukz.a(new NoColumnError("strStarPicUrl_2", String.class));
      i = paramCursor.getColumnIndex("strStarLvUrl_0");
      if (i != -1) {
        break label15318;
      }
      paramaukz.a(new NoColumnError("strStarLvUrl_0", String.class));
      i = paramCursor.getColumnIndex("strStarLvUrl_1");
      if (i != -1) {
        break label15333;
      }
      paramaukz.a(new NoColumnError("strStarLvUrl_1", String.class));
      label9077:
      i = paramCursor.getColumnIndex("strStarLvUrl_2");
      if (i != -1) {
        break label15348;
      }
      paramaukz.a(new NoColumnError("strStarLvUrl_2", String.class));
      i = paramCursor.getColumnIndex("strStarLogoUrl");
      if (i != -1) {
        break label15363;
      }
      paramaukz.a(new NoColumnError("strStarLogoUrl", String.class));
      i = paramCursor.getColumnIndex("starFansJumpUrl");
      if (i != -1) {
        break label15378;
      }
      paramaukz.a(new NoColumnError("starFansJumpUrl", String.class));
      i = paramCursor.getColumnIndex("lUserFlag");
      if (i != -1) {
        break label15393;
      }
      paramaukz.a(new NoColumnError("lUserFlag", Long.TYPE));
      i = paramCursor.getColumnIndex("lLoginDays");
      if (i != -1) {
        break label15408;
      }
      paramaukz.a(new NoColumnError("lLoginDays", Long.TYPE));
      i = paramCursor.getColumnIndex("strLoginDaysDesc");
      if (i != -1) {
        break label15423;
      }
      paramaukz.a(new NoColumnError("strLoginDaysDesc", String.class));
      i = paramCursor.getColumnIndex("lQQMasterLogindays");
      if (i != -1) {
        break label15438;
      }
      paramaukz.a(new NoColumnError("lQQMasterLogindays", Long.TYPE));
      label9336:
      i = paramCursor.getColumnIndex("iXManScene1DelayTime");
      if (i != -1) {
        break label15453;
      }
      paramaukz.a(new NoColumnError("iXManScene1DelayTime", Integer.TYPE));
      i = paramCursor.getColumnIndex("iXManScene2DelayTime");
      if (i != -1) {
        break label15468;
      }
      paramaukz.a(new NoColumnError("iXManScene2DelayTime", Integer.TYPE));
      i = paramCursor.getColumnIndex("allowPeopleSee");
      if (i != -1) {
        break label15483;
      }
      paramaukz.a(new NoColumnError("allowPeopleSee", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowCalInteractive");
      if (i != -1) {
        break label15510;
      }
      paramaukz.a(new NoColumnError("allowCalInteractive", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showOnlineFriends");
      if (i != -1) {
        break label15537;
      }
      paramaukz.a(new NoColumnError("showOnlineFriends", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowClick");
      if (i != -1) {
        break label15564;
      }
      paramaukz.a(new NoColumnError("allowClick", Boolean.TYPE));
      i = paramCursor.getColumnIndex("babyQSwitch");
      if (i != -1) {
        break label15591;
      }
      paramaukz.a(new NoColumnError("babyQSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showLightalk");
      if (i != -1) {
        break label15618;
      }
      paramaukz.a(new NoColumnError("showLightalk", Boolean.TYPE));
      i = paramCursor.getColumnIndex("lightalkNick");
      if (i != -1) {
        break label15645;
      }
      paramaukz.a(new NoColumnError("lightalkNick", String.class));
      i = paramCursor.getColumnIndex("lightalkId");
      if (i != -1) {
        break label15660;
      }
      paramaukz.a(new NoColumnError("lightalkId", String.class));
      label9706:
      i = paramCursor.getColumnIndex("isSuperRedDiamond");
      if (i != -1) {
        break label15675;
      }
      paramaukz.a(new NoColumnError("isSuperRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRedDiamond");
      if (i != -1) {
        break label15702;
      }
      paramaukz.a(new NoColumnError("isRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("redLevel");
      if (i != -1) {
        break label15729;
      }
      paramaukz.a(new NoColumnError("redLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("isSuperYellowDiamond");
      if (i != -1) {
        break label15744;
      }
      paramaukz.a(new NoColumnError("isSuperYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isYellowDiamond");
      if (i != -1) {
        break label15771;
      }
      paramaukz.a(new NoColumnError("isYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("yellowLevel");
      if (i != -1) {
        break label15798;
      }
      paramaukz.a(new NoColumnError("yellowLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("isSuperGreenDiamond");
      if (i != -1) {
        break label15813;
      }
      paramaukz.a(new NoColumnError("isSuperGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isGreenDiamond");
      if (i != -1) {
        break label15840;
      }
      paramaukz.a(new NoColumnError("isGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("greenLevel");
      if (i != -1) {
        break label15867;
      }
      paramaukz.a(new NoColumnError("greenLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("uAccelerateMultiple");
      if (i != -1) {
        break label15882;
      }
      paramaukz.a(new NoColumnError("uAccelerateMultiple", Long.TYPE));
      i = paramCursor.getColumnIndex("strRespMusicInfo");
      if (i != -1) {
        break label15897;
      }
      paramaukz.a(new NoColumnError("strRespMusicInfo", String.class));
      i = paramCursor.getColumnIndex("templateRet");
      if (i != -1) {
        break label15912;
      }
      paramaukz.a(new NoColumnError("templateRet", Integer.TYPE));
      i = paramCursor.getColumnIndex("lCurrentStyleId");
      if (i != -1) {
        break label15927;
      }
      paramaukz.a(new NoColumnError("lCurrentStyleId", Long.TYPE));
      i = paramCursor.getColumnIndex("lCurrentBgId");
      if (i != -1) {
        break label15942;
      }
      paramaukz.a(new NoColumnError("lCurrentBgId", Long.TYPE));
      label10224:
      i = paramCursor.getColumnIndex("backgroundUrl");
      if (i != -1) {
        break label15957;
      }
      paramaukz.a(new NoColumnError("backgroundUrl", String.class));
      i = paramCursor.getColumnIndex("backgroundColor");
      if (i != -1) {
        break label15972;
      }
      paramaukz.a(new NoColumnError("backgroundColor", Long.TYPE));
      i = paramCursor.getColumnIndex("dynamicCardFlag");
      if (i != -1) {
        break label15987;
      }
      paramaukz.a(new NoColumnError("dynamicCardFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("strZipUrl");
      if (i != -1) {
        break label16002;
      }
      paramaukz.a(new NoColumnError("strZipUrl", String.class));
      i = paramCursor.getColumnIndex("strActiveUrl");
      if (i != -1) {
        break label16017;
      }
      paramaukz.a(new NoColumnError("strActiveUrl", String.class));
      i = paramCursor.getColumnIndex("strDrawerCardUrl");
      if (i != -1) {
        break label16032;
      }
      paramaukz.a(new NoColumnError("strDrawerCardUrl", String.class));
      i = paramCursor.getColumnIndex("strWzryHeroUrl");
      if (i != -1) {
        break label16047;
      }
      paramaukz.a(new NoColumnError("strWzryHeroUrl", String.class));
      label10483:
      i = paramCursor.getColumnIndex("wzryHonorInfo");
      if (i != -1) {
        break label16062;
      }
      paramaukz.a(new NoColumnError("wzryHonorInfo", [B.class));
      i = paramCursor.getColumnIndex("strExtInfo");
      if (i != -1) {
        break label16077;
      }
      paramaukz.a(new NoColumnError("strExtInfo", String.class));
      i = paramCursor.getColumnIndex("strCurrentBgUrl");
      if (i != -1) {
        break label16092;
      }
      paramaukz.a(new NoColumnError("strCurrentBgUrl", String.class));
      i = paramCursor.getColumnIndex("bgType");
      if (i != -1) {
        break label16107;
      }
      paramaukz.a(new NoColumnError("bgType", [B.class));
      i = paramCursor.getColumnIndex("encId");
      if (i != -1) {
        break label16122;
      }
      paramaukz.a(new NoColumnError("encId", String.class));
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label16137;
      }
      paramaukz.a(new NoColumnError("busiEntry", String.class));
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label16152;
      }
      paramaukz.a(new NoColumnError("favoriteSource", Integer.TYPE));
      label10742:
      i = paramCursor.getColumnIndex("visibleMusicPendant");
      if (i != -1) {
        break label16167;
      }
      paramaukz.a(new NoColumnError("visibleMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("autoPlayMusicPendant");
      if (i != -1) {
        break label16194;
      }
      paramaukz.a(new NoColumnError("autoPlayMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showRedPointMusicPendant");
      if (i != -1) {
        break label16221;
      }
      paramaukz.a(new NoColumnError("showRedPointMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("privilegePromptStr");
      if (i != -1) {
        break label16248;
      }
      paramaukz.a(new NoColumnError("privilegePromptStr", String.class));
      i = paramCursor.getColumnIndex("privilegeJumpUrl");
      if (i != -1) {
        break label16263;
      }
      paramaukz.a(new NoColumnError("privilegeJumpUrl", String.class));
      i = paramCursor.getColumnIndex("vOpenPriv");
      if (i != -1) {
        break label16278;
      }
      paramaukz.a(new NoColumnError("vOpenPriv", [B.class));
      i = paramCursor.getColumnIndex("vClosePriv");
      if (i != -1) {
        break label16293;
      }
      paramaukz.a(new NoColumnError("vClosePriv", [B.class));
      label11001:
      i = paramCursor.getColumnIndex("presentDesc");
      if (i != -1) {
        break label16308;
      }
      paramaukz.a(new NoColumnError("presentDesc", String.class));
      i = paramCursor.getColumnIndex("presentCustourl");
      if (i != -1) {
        break label16323;
      }
      paramaukz.a(new NoColumnError("presentCustourl", String.class));
      i = paramCursor.getColumnIndex("presentSwitch");
      if (i != -1) {
        break label16338;
      }
      paramaukz.a(new NoColumnError("presentSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showPresent");
      if (i != -1) {
        break label16365;
      }
      paramaukz.a(new NoColumnError("showPresent", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showMusicBox");
      if (i != -1) {
        break label16392;
      }
      paramaukz.a(new NoColumnError("showMusicBox", Boolean.TYPE));
      i = paramCursor.getColumnIndex("addSrcName");
      if (i != -1) {
        break label16419;
      }
      paramaukz.a(new NoColumnError("addSrcName", String.class));
      i = paramCursor.getColumnIndex("addSrcId");
      if (i != -1) {
        break label16434;
      }
      paramaukz.a(new NoColumnError("addSrcId", Long.TYPE));
      label11260:
      i = paramCursor.getColumnIndex("addSubSrcId");
      if (i != -1) {
        break label16449;
      }
      paramaukz.a(new NoColumnError("addSubSrcId", Long.TYPE));
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label16464;
      }
      paramaukz.a(new NoColumnError("strVoteLimitedNotice", String.class));
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label16479;
      }
      paramaukz.a(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      label11371:
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label16494;
      }
      paramaukz.a(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      i = paramCursor.getColumnIndex("olympicTorch");
      if (i != -1) {
        break label16509;
      }
      paramaukz.a(new NoColumnError("olympicTorch", Byte.TYPE));
      i = paramCursor.getColumnIndex("mNowShowFlag");
      if (i != -1) {
        break label16525;
      }
      paramaukz.a(new NoColumnError("mNowShowFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("mNowShowIconUrl");
      if (i != -1) {
        break label16540;
      }
      paramaukz.a(new NoColumnError("mNowShowIconUrl", String.class));
      label11519:
      i = paramCursor.getColumnIndex("mNowShowJumpUrl");
      if (i != -1) {
        break label16555;
      }
      paramaukz.a(new NoColumnError("mNowShowJumpUrl", String.class));
      i = paramCursor.getColumnIndex("vCoverInfo");
      if (i != -1) {
        break label16570;
      }
      paramaukz.a(new NoColumnError("vCoverInfo", [B.class));
      i = paramCursor.getColumnIndex("videoHeadFlag");
      if (i != -1) {
        break label16585;
      }
      paramaukz.a(new NoColumnError("videoHeadFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("videoHeadUrl");
      if (i != -1) {
        break label16612;
      }
      paramaukz.a(new NoColumnError("videoHeadUrl", String.class));
      i = paramCursor.getColumnIndex("medalSwitchDisable");
      if (i != -1) {
        break label16627;
      }
      paramaukz.a(new NoColumnError("medalSwitchDisable", Boolean.TYPE));
      i = paramCursor.getColumnIndex("iMedalCount");
      if (i != -1) {
        break label16654;
      }
      paramaukz.a(new NoColumnError("iMedalCount", Integer.TYPE));
      i = paramCursor.getColumnIndex("iNewCount");
      if (i != -1) {
        break label16669;
      }
      paramaukz.a(new NoColumnError("iNewCount", Integer.TYPE));
      i = paramCursor.getColumnIndex("iUpgradeCount");
      if (i != -1) {
        break label16684;
      }
      paramaukz.a(new NoColumnError("iUpgradeCount", Integer.TYPE));
      i = paramCursor.getColumnIndex("strPromptParams");
      if (i != -1) {
        break label16699;
      }
      paramaukz.a(new NoColumnError("strPromptParams", String.class));
      i = paramCursor.getColumnIndex("hobbyEntry");
      if (i != -1) {
        break label16714;
      }
      paramaukz.a(new NoColumnError("hobbyEntry", String.class));
      label11889:
      i = paramCursor.getColumnIndex("lastPraiseInfoList");
      if (i != -1) {
        break label16729;
      }
      paramaukz.a(new NoColumnError("lastPraiseInfoList", [B.class));
      i = paramCursor.getColumnIndex("tempChatSig");
      if (i != -1) {
        break label16744;
      }
      paramaukz.a(new NoColumnError("tempChatSig", [B.class));
      i = paramCursor.getColumnIndex("namePlateOfKingGameId");
      if (i != -1) {
        break label16759;
      }
      paramaukz.a(new NoColumnError("namePlateOfKingGameId", Long.TYPE));
      i = paramCursor.getColumnIndex("namePlateOfKingLoginTime");
      if (i != -1) {
        break label16774;
      }
      paramaukz.a(new NoColumnError("namePlateOfKingLoginTime", Long.TYPE));
      i = paramCursor.getColumnIndex("namePlateOfKingDan");
      if (i != -1) {
        break label16789;
      }
      paramaukz.a(new NoColumnError("namePlateOfKingDan", Integer.TYPE));
      i = paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch");
      if (i != -1) {
        break label16804;
      }
      paramaukz.a(new NoColumnError("namePlateOfKingDanDisplatSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("vPersonalityLabelV2");
      if (i != -1) {
        break label16831;
      }
      paramaukz.a(new NoColumnError("vPersonalityLabelV2", [B.class));
      label12148:
      i = paramCursor.getColumnIndex("cardType");
      if (i != -1) {
        break label16846;
      }
      paramaukz.a(new NoColumnError("cardType", Integer.TYPE));
      i = paramCursor.getColumnIndex("diyText");
      if (i != -1) {
        break label16861;
      }
      paramaukz.a(new NoColumnError("diyText", String.class));
      i = paramCursor.getColumnIndex("diyTextFontId");
      if (i != -1) {
        break label16876;
      }
      paramaukz.a(new NoColumnError("diyTextFontId", Integer.TYPE));
      i = paramCursor.getColumnIndex("diyTextWidth");
      if (i != -1) {
        break label16891;
      }
      paramaukz.a(new NoColumnError("diyTextWidth", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextHeight");
      if (i != -1) {
        break label16906;
      }
      paramaukz.a(new NoColumnError("diyTextHeight", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextLocX");
      if (i != -1) {
        break label16921;
      }
      paramaukz.a(new NoColumnError("diyTextLocX", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextLocY");
      if (i != -1) {
        break label16936;
      }
      paramaukz.a(new NoColumnError("diyTextLocY", Float.TYPE));
      label12407:
      i = paramCursor.getColumnIndex("diyTextDegree");
      if (i != -1) {
        break label16951;
      }
      paramaukz.a(new NoColumnError("diyTextDegree", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextScale");
      if (i != -1) {
        break label16966;
      }
      paramaukz.a(new NoColumnError("diyTextScale", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextTransparency");
      if (i != -1) {
        break label16981;
      }
      paramaukz.a(new NoColumnError("diyTextTransparency", Float.TYPE));
      label12518:
      i = paramCursor.getColumnIndex("diyDefaultText");
      if (i != -1) {
        break label16996;
      }
      paramaukz.a(new NoColumnError("diyDefaultText", String.class));
      i = paramCursor.getColumnIndex("popularity");
      if (i != -1) {
        break label17011;
      }
      paramaukz.a(new NoColumnError("popularity", Integer.TYPE));
      i = paramCursor.getColumnIndex("declaration");
      if (i != -1) {
        break label17026;
      }
      paramaukz.a(new NoColumnError("declaration", String.class));
      i = paramCursor.getColumnIndex("voiceUrl");
      if (i != -1) {
        break label17041;
      }
      paramaukz.a(new NoColumnError("voiceUrl", String.class));
      label12666:
      i = paramCursor.getColumnIndex("isShowCard");
      if (i != -1) {
        break label17056;
      }
      paramaukz.a(new NoColumnError("isShowCard", Boolean.TYPE));
      i = paramCursor.getColumnIndex("updateTime");
      if (i != -1) {
        break label17083;
      }
      paramaukz.a(new NoColumnError("updateTime", Long.TYPE));
      i = paramCursor.getColumnIndex("extendFriendFlag");
      if (i != -1) {
        break label17098;
      }
      paramaukz.a(new NoColumnError("extendFriendFlag", Integer.TYPE));
      label12777:
      i = paramCursor.getColumnIndex("extendFriendVoiceDuration");
      if (i != -1) {
        break label17113;
      }
      paramaukz.a(new NoColumnError("extendFriendVoiceDuration", Integer.TYPE));
      i = paramCursor.getColumnIndex("extendFriendEntryContact");
      if (i != -1) {
        break label17128;
      }
      paramaukz.a(new NoColumnError("extendFriendEntryContact", Short.TYPE));
      i = paramCursor.getColumnIndex("extendFriendEntryAddFriend");
      if (i != -1) {
        break label17143;
      }
      paramaukz.a(new NoColumnError("extendFriendEntryAddFriend", Short.TYPE));
      i = paramCursor.getColumnIndex("extendFriendQuestion");
      if (i != -1) {
        break label17158;
      }
      paramaukz.a(new NoColumnError("extendFriendQuestion", Short.TYPE));
      label12925:
      i = paramCursor.getColumnIndex("isShowMiniPlaying");
      if (i != -1) {
        break label17173;
      }
      paramaukz.a(new NoColumnError("isShowMiniPlaying", Boolean.TYPE));
      i = paramCursor.getColumnIndex("tabJumpUrl");
      if (i != -1) {
        break label17200;
      }
      paramaukz.a(new NoColumnError("tabJumpUrl", String.class));
      i = paramCursor.getColumnIndex("guestJumpUrl");
      if (i != -1) {
        break label17215;
      }
      paramaukz.a(new NoColumnError("guestJumpUrl", String.class));
      label13036:
      i = paramCursor.getColumnIndex("guestAppTotal");
      if (i != -1) {
        break label17230;
      }
      paramaukz.a(new NoColumnError("guestAppTotal", Integer.TYPE));
      i = paramCursor.getColumnIndex("defaultCardId");
      if (i != -1) {
        break label17245;
      }
      paramaukz.a(new NoColumnError("defaultCardId", Integer.TYPE));
      i = paramCursor.getColumnIndex("strangerVoteOpen");
      if (i != -1) {
        break label17260;
      }
      paramaukz.a(new NoColumnError("strangerVoteOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("lSuperVipTemplateId");
      if (i != -1) {
        break label17287;
      }
      paramaukz.a(new NoColumnError("lSuperVipTemplateId", Long.TYPE));
      i = paramCursor.getColumnIndex("bBigClubVipOpen");
      if (i != -1) {
        break label17302;
      }
      paramaukz.a(new NoColumnError("bBigClubVipOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iBigClubVipType");
      if (i != -1) {
        break label17318;
      }
      paramaukz.a(new NoColumnError("iBigClubVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iBigClubVipLevel");
      if (i != -1) {
        break label17333;
      }
      paramaukz.a(new NoColumnError("iBigClubVipLevel", Integer.TYPE));
      label13295:
      i = paramCursor.getColumnIndex("lBigClubTemplateId");
      if (i != -1) {
        break label17348;
      }
      paramaukz.a(new NoColumnError("lBigClubTemplateId", Long.TYPE));
      i = paramCursor.getColumnIndex("diyComplicatedInfo");
      if (i != -1) {
        break label17363;
      }
      paramaukz.a(new NoColumnError("diyComplicatedInfo", String.class));
      i = paramCursor.getColumnIndex("cardId");
      if (i != -1) {
        break label17378;
      }
      paramaukz.a(new NoColumnError("cardId", Long.TYPE));
    }
    for (;;)
    {
      label2697:
      label2742:
      label3392:
      label3654:
      label3915:
      label4812:
      label4817:
      label4822:
      label4957:
      label5342:
      label5727:
      label6112:
      label6497:
      label7523:
      label9188:
      i = paramCursor.getColumnIndex("strangerInviteMeGroupOpen");
      label3200:
      label3226:
      label3366:
      label4654:
      label4787:
      label4792:
      label4797:
      label4802:
      label4807:
      label5202:
      label5587:
      label5972:
      label6357:
      label6746:
      label7005:
      label7264:
      label8929:
      label10594:
      label12259:
      if (i != -1) {
        break label17393;
      }
      label4226:
      label4366:
      label4628:
      label4757:
      label4762:
      label4767:
      label4772:
      label4777:
      label4782:
      label4922:
      label5062:
      label5447:
      label5832:
      label6217:
      label6602:
      label7116:
      label7634:
      label7893:
      label8152:
      label8411:
      label8670:
      label10335:
      label12000:
      paramaukz.a(new NoColumnError("strangerInviteMeGroupOpen", Boolean.TYPE));
      label4737:
      label4742:
      label4747:
      label4752:
      label5027:
      label5167:
      label5307:
      label5692:
      label6077:
      label6462:
      label6857:
      label8522:
      label8781:
      label9040:
      label9299:
      label9817:
      label10076:
      label11741:
      i = paramCursor.getColumnIndex("isPrettyGroupOwner");
      label4992:
      label5132:
      label5272:
      label5412:
      label5552:
      label5937:
      label6322:
      label6709:
      label6968:
      label7227:
      label7486:
      label7745:
      label8004:
      label8263:
      label9928:
      label10187:
      label10446:
      label10705:
      label10964:
      label11223:
      label11482:
      if (i != -1) {
        break label17420;
      }
      label5377:
      label5517:
      label5657:
      label5797:
      label6182:
      label6567:
      label7338:
      label7597:
      label7856:
      label8115:
      label8374:
      label8633:
      label8892:
      label9151:
      label9410:
      label9669:
      label11334:
      label11593:
      label11852:
      label12370:
      label12629:
      label12888:
      paramaukz.a(new NoColumnError("isPrettyGroupOwner", Boolean.TYPE));
      label5762:
      label5902:
      label6042:
      label6427:
      label6820:
      label7079:
      label8744:
      label9003:
      label9262:
      label10039:
      label10298:
      label10557:
      label11075:
      label12740:
      label12999:
      label13258:
      i = paramCursor.getColumnIndex("isHidePrettyGroutIdentity");
      label6147:
      label6287:
      label6672:
      label6931:
      label7449:
      label7708:
      label7967:
      label8226:
      label8485:
      label10150:
      label10409:
      label10668:
      label10927:
      label11445:
      label11963:
      label12222:
      label12481:
      if (i != -1) {
        break label17447;
      }
      label6532:
      label7301:
      label7560:
      label7819:
      label8078:
      label8337:
      label8596:
      label8855:
      label9114:
      label9373:
      label11038:
      label11297:
      label11556:
      label11815:
      label12074:
      label12333:
      label12592:
      label12851:
      label13110:
      label13369:
      paramaukz.a(new NoColumnError("isHidePrettyGroutIdentity", Boolean.TYPE));
      label7042:
      label8707:
      label8966:
      label9225:
      label10261:
      label10520:
      label12185:
      label12444:
      label13221:
      i = paramCursor.getColumnIndex("mQQLevelType");
      label8448:
      label10113:
      label10372:
      label10631:
      label10890:
      label11408:
      label11667:
      label11926:
      if (i != -1) {
        break label17475;
      }
      label11778:
      label12037:
      label12296:
      label12555:
      label12814:
      label13073:
      label13332:
      paramaukz.a(new NoColumnError("mQQLevelType", Integer.TYPE));
      label13184:
      return paramauko;
      paramauko.uin = paramCursor.getString(i);
      break;
      label13571:
      paramauko.strNick = paramCursor.getString(i);
      break label4922;
      label13586:
      paramauko.shGender = paramCursor.getShort(i);
      break label4957;
      label13601:
      paramauko.shAge = paramCursor.getShort(i);
      break label4992;
      label13616:
      paramauko.nFaceID = paramCursor.getInt(i);
      break label5027;
      label13631:
      paramauko.strCertificationInfo = paramCursor.getString(i);
      break label5062;
      label13646:
      paramauko.shType = paramCursor.getShort(i);
      break label5097;
      label13661:
      paramauko.vContent = paramCursor.getBlob(i);
      break label5132;
      label13676:
      paramauko.strSign = paramCursor.getString(i);
      break label5167;
      label13691:
      paramauko.strCompany = paramCursor.getString(i);
      break label5202;
      label13706:
      paramauko.strSchool = paramCursor.getString(i);
      break label5237;
      label13721:
      paramauko.uFaceTimeStamp = paramCursor.getInt(i);
      break label5272;
      label13736:
      paramauko.vQQFaceID = paramCursor.getBlob(i);
      break label5307;
      label13751:
      paramauko.strReMark = paramCursor.getString(i);
      break label5342;
      label13766:
      paramauko.bWeiboInfo = ((byte)paramCursor.getShort(i));
      break label5377;
      label13782:
      paramauko.bQzoneInfo = ((byte)paramCursor.getShort(i));
      break label5412;
      label13798:
      paramauko.nSameFriendsNum = paramCursor.getInt(i);
      break label5447;
      label13813:
      paramauko.strCompanySame = paramCursor.getString(i);
      break label5482;
      label13828:
      paramauko.strSchoolSame = paramCursor.getString(i);
      break label5517;
      label13843:
      paramauko.lCardShowNum = paramCursor.getLong(i);
      break label5552;
      label13858:
      paramauko.bSingle = ((byte)paramCursor.getShort(i));
      break label5587;
      label13874:
      paramauko.lVisitCount = paramCursor.getLong(i);
      break label5622;
      label13889:
      paramauko.lVoteCount = paramCursor.getLong(i);
      break label5657;
      label13904:
      paramauko.tagInfosByte = paramCursor.getBlob(i);
      break label5692;
      label13919:
      paramauko.eUserIdentityType = ((byte)paramCursor.getShort(i));
      break label5727;
      label13935:
      paramauko.vBackground = paramCursor.getBlob(i);
      break label5762;
      label13950:
      paramauko.labelInfoBytes = paramCursor.getBlob(i);
      break label5797;
      label13965:
      paramauko.age = ((byte)paramCursor.getShort(i));
      break label5832;
      label13981:
      paramauko.constellation = paramCursor.getInt(i);
      break label5867;
      label13996:
      paramauko.pyFaceUrl = paramCursor.getString(i);
      break label5902;
      label14011:
      paramauko.location = paramCursor.getString(i);
      break label5937;
      label14026:
      paramauko.bVoted = ((byte)paramCursor.getShort(i));
      break label5972;
      label14042:
      paramauko.bFavorited = ((byte)paramCursor.getShort(i));
      break label6007;
      label14058:
      paramauko.iVoteIncrement = paramCursor.getInt(i);
      break label6042;
      label14073:
      paramauko.strJoinHexAlbumFileKey = paramCursor.getString(i);
      break label6077;
      label14088:
      paramauko.iFaceNum = paramCursor.getInt(i);
      break label6112;
      label14103:
      paramauko.cSqqLevel = ((byte)paramCursor.getShort(i));
      break label6147;
      label14119:
      paramauko.iQQLevel = paramCursor.getInt(i);
      break label6182;
      label14134:
      paramauko.uCurMulType = paramCursor.getLong(i);
      break label6217;
      label14149:
      paramauko.strProvince = paramCursor.getString(i);
      break label6252;
      label14164:
      paramauko.strCity = paramCursor.getString(i);
      break label6287;
      label14179:
      paramauko.strCountry = paramCursor.getString(i);
      break label6322;
      label14194:
      paramauko.lBirthday = paramCursor.getLong(i);
      break label6357;
      label14209:
      paramauko.strLocationCodes = paramCursor.getString(i);
      break label6392;
      label14224:
      paramauko.strLocationDesc = paramCursor.getString(i);
      break label6427;
      label14239:
      paramauko.strHometownCodes = paramCursor.getString(i);
      break label6462;
      label14254:
      paramauko.strHometownDesc = paramCursor.getString(i);
      break label6497;
      label14269:
      paramauko.strEmail = paramCursor.getString(i);
      break label6532;
      label14284:
      paramauko.strPersonalNote = paramCursor.getString(i);
      break label6567;
      label14299:
      paramauko.iProfession = paramCursor.getInt(i);
      break label6602;
      label14314:
      paramauko.bindPhoneInfo = paramCursor.getString(i);
      break label6637;
      label14329:
      paramauko.bCardInfo = paramCursor.getBlob(i);
      break label6672;
      label14344:
      paramauko.strTroopName = paramCursor.getString(i);
      break label6709;
      label14359:
      paramauko.strTroopNick = paramCursor.getString(i);
      break label6746;
      label14374:
      paramauko.strMobile = paramCursor.getString(i);
      break label6783;
      label14389:
      paramauko.strContactName = paramCursor.getString(i);
      break label6820;
      label14404:
      paramauko.ulShowControl = paramCursor.getInt(i);
      break label6857;
      label14419:
      paramauko.feedPreviewTime = paramCursor.getLong(i);
      break label6894;
      label14434:
      paramauko.strQzoneFeedsDesc = paramCursor.getString(i);
      break label6931;
      label14449:
      paramauko.StrPresentDesc = paramCursor.getString(i);
      break label6968;
      label14464:
      paramauko.strSpaceName = paramCursor.getString(i);
      break label7005;
      label14479:
      paramauko.strQzoneHeader = paramCursor.getString(i);
      break label7042;
      label14494:
      paramauko.vQzonePhotos = paramCursor.getBlob(i);
      break label7079;
      label14509:
      paramauko.vQzoneCoverInfo = paramCursor.getBlob(i);
      break label7116;
      label14524:
      paramauko.enlargeQzonePic = paramCursor.getInt(i);
      break label7153;
      label14539:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.showPublishButton = paramBoolean;
        break;
      }
      label14566:
      paramauko.strStatus = paramCursor.getString(i);
      break label7227;
      label14581:
      paramauko.strAutoRemark = paramCursor.getString(i);
      break label7264;
      label14596:
      paramauko.vSeed = paramCursor.getBlob(i);
      break label7301;
      label14611:
      paramauko.vCookies = paramCursor.getBlob(i);
      break label7338;
      label14626:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.hasFakeData = paramBoolean;
        break;
      }
      label14653:
      paramauko.bQQVipOpen = ((byte)paramCursor.getShort(i));
      break label7412;
      label14669:
      paramauko.iQQVipType = paramCursor.getInt(i);
      break label7449;
      label14684:
      paramauko.iQQVipLevel = paramCursor.getInt(i);
      break label7486;
      label14699:
      paramauko.nameplateVipType = paramCursor.getInt(i);
      break label7523;
      label14714:
      paramauko.grayNameplateFlag = paramCursor.getInt(i);
      break label7560;
      label14729:
      paramauko.bSuperVipOpen = ((byte)paramCursor.getShort(i));
      break label7597;
      label14745:
      paramauko.iSuperVipType = paramCursor.getInt(i);
      break label7634;
      label14760:
      paramauko.iSuperVipLevel = paramCursor.getInt(i);
      break label7671;
      label14775:
      paramauko.bSuperQQOpen = ((byte)paramCursor.getShort(i));
      break label7708;
      label14791:
      paramauko.iSuperQQType = paramCursor.getInt(i);
      break label7745;
      label14806:
      paramauko.iSuperQQLevel = paramCursor.getInt(i);
      break label7782;
      label14821:
      paramauko.bHollywoodVipOpen = ((byte)paramCursor.getShort(i));
      break label7819;
      label14837:
      paramauko.iHollywoodVipType = paramCursor.getInt(i);
      break label7856;
      label14852:
      paramauko.iHollywoodVipLevel = paramCursor.getInt(i);
      break label7893;
      label14867:
      paramauko.strShowName = paramCursor.getString(i);
      break label7930;
      label14882:
      paramauko.strVoiceFilekey = paramCursor.getString(i);
      break label7967;
      label14897:
      paramauko.shDuration = paramCursor.getShort(i);
      break label8004;
      label14912:
      paramauko.bRead = ((byte)paramCursor.getShort(i));
      break label8041;
      label14928:
      paramauko.strUrl = paramCursor.getString(i);
      break label8078;
      label14943:
      paramauko.vRichSign = paramCursor.getBlob(i);
      break label8115;
      label14958:
      paramauko.lSignModifyTime = paramCursor.getLong(i);
      break label8152;
      label14973:
      paramauko.vLongNickTopicInfo = paramCursor.getBlob(i);
      break label8189;
      label14988:
      paramauko.nLastGameFlag = paramCursor.getInt(i);
      break label8226;
      label15003:
      paramauko.strGameLogoUrl_1 = paramCursor.getString(i);
      break label8263;
      label15018:
      paramauko.strGameLogoUrl_2 = paramCursor.getString(i);
      break label8300;
      label15033:
      paramauko.strGameLogoUrl_3 = paramCursor.getString(i);
      break label8337;
      label15048:
      paramauko.strGameLogoUrl_4 = paramCursor.getString(i);
      break label8374;
      label15063:
      paramauko.strGameLogoKey_1 = paramCursor.getString(i);
      break label8411;
      label15078:
      paramauko.strGameLogoKey_2 = paramCursor.getString(i);
      break label8448;
      label15093:
      paramauko.strGameLogoKey_3 = paramCursor.getString(i);
      break label8485;
      label15108:
      paramauko.strGameLogoKey_4 = paramCursor.getString(i);
      break label8522;
      label15123:
      paramauko.strGameName_1 = paramCursor.getString(i);
      break label8559;
      label15138:
      paramauko.strGameName_2 = paramCursor.getString(i);
      break label8596;
      label15153:
      paramauko.strGameName_3 = paramCursor.getString(i);
      break label8633;
      label15168:
      paramauko.strGameName_4 = paramCursor.getString(i);
      break label8670;
      label15183:
      paramauko.strGameAppid_1 = paramCursor.getString(i);
      break label8707;
      label15198:
      paramauko.strGameAppid_2 = paramCursor.getString(i);
      break label8744;
      label15213:
      paramauko.strGameAppid_3 = paramCursor.getString(i);
      break label8781;
      label15228:
      paramauko.strGameAppid_4 = paramCursor.getString(i);
      break label8818;
      label15243:
      paramauko.strProfileUrl = paramCursor.getString(i);
      break label8855;
      label15258:
      paramauko.nStarFansFlag = paramCursor.getInt(i);
      break label8892;
      label15273:
      paramauko.strStarPicUrl_0 = paramCursor.getString(i);
      break label8929;
      label15288:
      paramauko.strStarPicUrl_1 = paramCursor.getString(i);
      break label8966;
      label15303:
      paramauko.strStarPicUrl_2 = paramCursor.getString(i);
      break label9003;
      label15318:
      paramauko.strStarLvUrl_0 = paramCursor.getString(i);
      break label9040;
      label15333:
      paramauko.strStarLvUrl_1 = paramCursor.getString(i);
      break label9077;
      label15348:
      paramauko.strStarLvUrl_2 = paramCursor.getString(i);
      break label9114;
      label15363:
      paramauko.strStarLogoUrl = paramCursor.getString(i);
      break label9151;
      label15378:
      paramauko.starFansJumpUrl = paramCursor.getString(i);
      break label9188;
      label15393:
      paramauko.lUserFlag = paramCursor.getLong(i);
      break label9225;
      label15408:
      paramauko.lLoginDays = paramCursor.getLong(i);
      break label9262;
      label15423:
      paramauko.strLoginDaysDesc = paramCursor.getString(i);
      break label9299;
      label15438:
      paramauko.lQQMasterLogindays = paramCursor.getLong(i);
      break label9336;
      label15453:
      paramauko.iXManScene1DelayTime = paramCursor.getInt(i);
      break label9373;
      label15468:
      paramauko.iXManScene2DelayTime = paramCursor.getInt(i);
      break label9410;
      label15483:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.allowPeopleSee = paramBoolean;
        break;
      }
      label15510:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.allowCalInteractive = paramBoolean;
        break;
      }
      label15537:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.showOnlineFriends = paramBoolean;
        break;
      }
      label15564:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.allowClick = paramBoolean;
        break;
      }
      label15591:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.babyQSwitch = paramBoolean;
        break;
      }
      label15618:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.showLightalk = paramBoolean;
        break;
      }
      label15645:
      paramauko.lightalkNick = paramCursor.getString(i);
      break label9669;
      label15660:
      paramauko.lightalkId = paramCursor.getString(i);
      break label9706;
      label15675:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isSuperRedDiamond = paramBoolean;
        break;
      }
      label15702:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isRedDiamond = paramBoolean;
        break;
      }
      label15729:
      paramauko.redLevel = paramCursor.getInt(i);
      break label9817;
      label15744:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isSuperYellowDiamond = paramBoolean;
        break;
      }
      label15771:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isYellowDiamond = paramBoolean;
        break;
      }
      label15798:
      paramauko.yellowLevel = paramCursor.getInt(i);
      break label9928;
      label15813:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isSuperGreenDiamond = paramBoolean;
        break;
      }
      label15840:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isGreenDiamond = paramBoolean;
        break;
      }
      label15867:
      paramauko.greenLevel = paramCursor.getInt(i);
      break label10039;
      label15882:
      paramauko.uAccelerateMultiple = paramCursor.getLong(i);
      break label10076;
      label15897:
      paramauko.strRespMusicInfo = paramCursor.getString(i);
      break label10113;
      label15912:
      paramauko.templateRet = paramCursor.getInt(i);
      break label10150;
      label15927:
      paramauko.lCurrentStyleId = paramCursor.getLong(i);
      break label10187;
      label15942:
      paramauko.lCurrentBgId = paramCursor.getLong(i);
      break label10224;
      label15957:
      paramauko.backgroundUrl = paramCursor.getString(i);
      break label10261;
      label15972:
      paramauko.backgroundColor = paramCursor.getLong(i);
      break label10298;
      label15987:
      paramauko.dynamicCardFlag = paramCursor.getInt(i);
      break label10335;
      label16002:
      paramauko.strZipUrl = paramCursor.getString(i);
      break label10372;
      label16017:
      paramauko.strActiveUrl = paramCursor.getString(i);
      break label10409;
      label16032:
      paramauko.strDrawerCardUrl = paramCursor.getString(i);
      break label10446;
      label16047:
      paramauko.strWzryHeroUrl = paramCursor.getString(i);
      break label10483;
      label16062:
      paramauko.wzryHonorInfo = paramCursor.getBlob(i);
      break label10520;
      label16077:
      paramauko.strExtInfo = paramCursor.getString(i);
      break label10557;
      label16092:
      paramauko.strCurrentBgUrl = paramCursor.getString(i);
      break label10594;
      label16107:
      paramauko.bgType = paramCursor.getBlob(i);
      break label10631;
      label16122:
      paramauko.encId = paramCursor.getString(i);
      break label10668;
      label16137:
      paramauko.busiEntry = paramCursor.getString(i);
      break label10705;
      label16152:
      paramauko.favoriteSource = paramCursor.getInt(i);
      break label10742;
      label16167:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.visibleMusicPendant = paramBoolean;
        break;
      }
      label16194:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.autoPlayMusicPendant = paramBoolean;
        break;
      }
      label16221:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.showRedPointMusicPendant = paramBoolean;
        break;
      }
      label16248:
      paramauko.privilegePromptStr = paramCursor.getString(i);
      break label10890;
      label16263:
      paramauko.privilegeJumpUrl = paramCursor.getString(i);
      break label10927;
      label16278:
      paramauko.vOpenPriv = paramCursor.getBlob(i);
      break label10964;
      label16293:
      paramauko.vClosePriv = paramCursor.getBlob(i);
      break label11001;
      label16308:
      paramauko.presentDesc = paramCursor.getString(i);
      break label11038;
      label16323:
      paramauko.presentCustourl = paramCursor.getString(i);
      break label11075;
      label16338:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.presentSwitch = paramBoolean;
        break;
      }
      label16365:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.showPresent = paramBoolean;
        break;
      }
      label16392:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.showMusicBox = paramBoolean;
        break;
      }
      label16419:
      paramauko.addSrcName = paramCursor.getString(i);
      break label11223;
      label16434:
      paramauko.addSrcId = paramCursor.getLong(i);
      break label11260;
      label16449:
      paramauko.addSubSrcId = paramCursor.getLong(i);
      break label11297;
      label16464:
      paramauko.strVoteLimitedNotice = paramCursor.getString(i);
      break label11334;
      label16479:
      paramauko.bHaveVotedCnt = paramCursor.getShort(i);
      break label11371;
      label16494:
      paramauko.bAvailVoteCnt = paramCursor.getShort(i);
      break label11408;
      label16509:
      paramauko.olympicTorch = ((byte)paramCursor.getShort(i));
      break label11445;
      label16525:
      paramauko.mNowShowFlag = paramCursor.getInt(i);
      break label11482;
      label16540:
      paramauko.mNowShowIconUrl = paramCursor.getString(i);
      break label11519;
      label16555:
      paramauko.mNowShowJumpUrl = paramCursor.getString(i);
      break label11556;
      label16570:
      paramauko.vCoverInfo = paramCursor.getBlob(i);
      break label11593;
      label16585:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.videoHeadFlag = paramBoolean;
        break;
      }
      label16612:
      paramauko.videoHeadUrl = paramCursor.getString(i);
      break label11667;
      label16627:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.medalSwitchDisable = paramBoolean;
        break;
      }
      label16654:
      paramauko.iMedalCount = paramCursor.getInt(i);
      break label11741;
      label16669:
      paramauko.iNewCount = paramCursor.getInt(i);
      break label11778;
      label16684:
      paramauko.iUpgradeCount = paramCursor.getInt(i);
      break label11815;
      label16699:
      paramauko.strPromptParams = paramCursor.getString(i);
      break label11852;
      label16714:
      paramauko.hobbyEntry = paramCursor.getString(i);
      break label11889;
      label16729:
      paramauko.lastPraiseInfoList = paramCursor.getBlob(i);
      break label11926;
      label16744:
      paramauko.tempChatSig = paramCursor.getBlob(i);
      break label11963;
      label16759:
      paramauko.namePlateOfKingGameId = paramCursor.getLong(i);
      break label12000;
      label16774:
      paramauko.namePlateOfKingLoginTime = paramCursor.getLong(i);
      break label12037;
      label16789:
      paramauko.namePlateOfKingDan = paramCursor.getInt(i);
      break label12074;
      label16804:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.namePlateOfKingDanDisplatSwitch = paramBoolean;
        break;
      }
      label16831:
      paramauko.vPersonalityLabelV2 = paramCursor.getBlob(i);
      break label12148;
      label16846:
      paramauko.cardType = paramCursor.getInt(i);
      break label12185;
      label16861:
      paramauko.diyText = paramCursor.getString(i);
      break label12222;
      label16876:
      paramauko.diyTextFontId = paramCursor.getInt(i);
      break label12259;
      label16891:
      paramauko.diyTextWidth = paramCursor.getFloat(i);
      break label12296;
      label16906:
      paramauko.diyTextHeight = paramCursor.getFloat(i);
      break label12333;
      label16921:
      paramauko.diyTextLocX = paramCursor.getFloat(i);
      break label12370;
      label16936:
      paramauko.diyTextLocY = paramCursor.getFloat(i);
      break label12407;
      label16951:
      paramauko.diyTextDegree = paramCursor.getFloat(i);
      break label12444;
      label16966:
      paramauko.diyTextScale = paramCursor.getFloat(i);
      break label12481;
      label16981:
      paramauko.diyTextTransparency = paramCursor.getFloat(i);
      break label12518;
      label16996:
      paramauko.diyDefaultText = paramCursor.getString(i);
      break label12555;
      label17011:
      paramauko.popularity = paramCursor.getInt(i);
      break label12592;
      label17026:
      paramauko.declaration = paramCursor.getString(i);
      break label12629;
      label17041:
      paramauko.voiceUrl = paramCursor.getString(i);
      break label12666;
      label17056:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isShowCard = paramBoolean;
        break;
      }
      label17083:
      paramauko.updateTime = paramCursor.getLong(i);
      break label12740;
      label17098:
      paramauko.extendFriendFlag = paramCursor.getInt(i);
      break label12777;
      label17113:
      paramauko.extendFriendVoiceDuration = paramCursor.getInt(i);
      break label12814;
      label17128:
      paramauko.extendFriendEntryContact = paramCursor.getShort(i);
      break label12851;
      label17143:
      paramauko.extendFriendEntryAddFriend = paramCursor.getShort(i);
      break label12888;
      label17158:
      paramauko.extendFriendQuestion = paramCursor.getShort(i);
      break label12925;
      label17173:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isShowMiniPlaying = paramBoolean;
        break;
      }
      label17200:
      paramauko.tabJumpUrl = paramCursor.getString(i);
      break label12999;
      label17215:
      paramauko.guestJumpUrl = paramCursor.getString(i);
      break label13036;
      label17230:
      paramauko.guestAppTotal = paramCursor.getInt(i);
      break label13073;
      label17245:
      paramauko.defaultCardId = paramCursor.getInt(i);
      break label13110;
      label17260:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.strangerVoteOpen = paramBoolean;
        break;
      }
      label17287:
      paramauko.lSuperVipTemplateId = paramCursor.getLong(i);
      break label13184;
      label17302:
      paramauko.bBigClubVipOpen = ((byte)paramCursor.getShort(i));
      break label13221;
      label17318:
      paramauko.iBigClubVipType = paramCursor.getInt(i);
      break label13258;
      label17333:
      paramauko.iBigClubVipLevel = paramCursor.getInt(i);
      break label13295;
      label17348:
      paramauko.lBigClubTemplateId = paramCursor.getLong(i);
      break label13332;
      label17363:
      paramauko.diyComplicatedInfo = paramCursor.getString(i);
      break label13369;
      label17378:
      paramauko.cardId = paramCursor.getLong(i);
    }
    label17393:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramauko.strangerInviteMeGroupOpen = paramBoolean;
      break;
    }
    label17420:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramauko.isPrettyGroupOwner = paramBoolean;
      break;
    }
    label17447:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramauko.isHidePrettyGroutIdentity = paramBoolean;
      break;
    }
    label17475:
    paramauko.mQQLevelType = paramCursor.getInt(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,strNick TEXT ,shGender INTEGER ,shAge INTEGER ,nFaceID INTEGER ,strCertificationInfo TEXT ,shType INTEGER ,vContent BLOB ,strSign TEXT ,strCompany TEXT ,strSchool TEXT ,uFaceTimeStamp INTEGER ,vQQFaceID BLOB ,strReMark TEXT ,bWeiboInfo INTEGER ,bQzoneInfo INTEGER ,nSameFriendsNum INTEGER ,strCompanySame TEXT ,strSchoolSame TEXT ,lCardShowNum INTEGER ,bSingle INTEGER ,lVisitCount INTEGER ,lVoteCount INTEGER ,tagInfosByte BLOB ,eUserIdentityType INTEGER ,vBackground BLOB ,labelInfoBytes BLOB ,age INTEGER ,constellation INTEGER ,pyFaceUrl TEXT ,location TEXT ,bVoted INTEGER ,bFavorited INTEGER ,iVoteIncrement INTEGER ,strJoinHexAlbumFileKey TEXT ,iFaceNum INTEGER ,cSqqLevel INTEGER ,iQQLevel INTEGER ,uCurMulType INTEGER ,strProvince TEXT ,strCity TEXT ,strCountry TEXT ,lBirthday INTEGER ,strLocationCodes TEXT ,strLocationDesc TEXT ,strHometownCodes TEXT ,strHometownDesc TEXT ,strEmail TEXT ,strPersonalNote TEXT ,iProfession INTEGER ,bindPhoneInfo TEXT ,bCardInfo BLOB ,strTroopName TEXT ,strTroopNick TEXT ,strMobile TEXT ,strContactName TEXT ,ulShowControl INTEGER ,feedPreviewTime INTEGER ,strQzoneFeedsDesc TEXT ,StrPresentDesc TEXT ,strSpaceName TEXT ,strQzoneHeader TEXT ,vQzonePhotos BLOB ,vQzoneCoverInfo BLOB ,enlargeQzonePic INTEGER ,showPublishButton INTEGER ,strStatus TEXT ,strAutoRemark TEXT ,vSeed BLOB ,vCookies BLOB ,hasFakeData INTEGER ,bQQVipOpen INTEGER ,iQQVipType INTEGER ,iQQVipLevel INTEGER ,nameplateVipType INTEGER ,grayNameplateFlag INTEGER ,bSuperVipOpen INTEGER ,iSuperVipType INTEGER ,iSuperVipLevel INTEGER ,bSuperQQOpen INTEGER ,iSuperQQType INTEGER ,iSuperQQLevel INTEGER ,bHollywoodVipOpen INTEGER ,iHollywoodVipType INTEGER ,iHollywoodVipLevel INTEGER ,strShowName TEXT ,strVoiceFilekey TEXT ,shDuration INTEGER ,bRead INTEGER ,strUrl TEXT ,vRichSign BLOB ,lSignModifyTime INTEGER ,vLongNickTopicInfo BLOB ,nLastGameFlag INTEGER ,strGameLogoUrl_1 TEXT ,strGameLogoUrl_2 TEXT ,strGameLogoUrl_3 TEXT ,strGameLogoUrl_4 TEXT ,strGameLogoKey_1 TEXT ,strGameLogoKey_2 TEXT ,strGameLogoKey_3 TEXT ,strGameLogoKey_4 TEXT ,strGameName_1 TEXT ,strGameName_2 TEXT ,strGameName_3 TEXT ,strGameName_4 TEXT ,strGameAppid_1 TEXT ,strGameAppid_2 TEXT ,strGameAppid_3 TEXT ,strGameAppid_4 TEXT ,strProfileUrl TEXT ,nStarFansFlag INTEGER ,strStarPicUrl_0 TEXT ,strStarPicUrl_1 TEXT ,strStarPicUrl_2 TEXT ,strStarLvUrl_0 TEXT ,strStarLvUrl_1 TEXT ,strStarLvUrl_2 TEXT ,strStarLogoUrl TEXT ,starFansJumpUrl TEXT ,lUserFlag INTEGER ,lLoginDays INTEGER ,strLoginDaysDesc TEXT ,lQQMasterLogindays INTEGER ,iXManScene1DelayTime INTEGER ,iXManScene2DelayTime INTEGER ,allowPeopleSee INTEGER ,allowCalInteractive INTEGER ,showOnlineFriends INTEGER ,allowClick INTEGER ,babyQSwitch INTEGER ,showLightalk INTEGER ,lightalkNick TEXT ,lightalkId TEXT ,isSuperRedDiamond INTEGER ,isRedDiamond INTEGER ,redLevel INTEGER ,isSuperYellowDiamond INTEGER ,isYellowDiamond INTEGER ,yellowLevel INTEGER ,isSuperGreenDiamond INTEGER ,isGreenDiamond INTEGER ,greenLevel INTEGER ,uAccelerateMultiple INTEGER ,strRespMusicInfo TEXT ,templateRet INTEGER ,lCurrentStyleId INTEGER ,lCurrentBgId INTEGER ,backgroundUrl TEXT ,backgroundColor INTEGER ,dynamicCardFlag INTEGER ,strZipUrl TEXT ,strActiveUrl TEXT ,strDrawerCardUrl TEXT ,strWzryHeroUrl TEXT ,wzryHonorInfo BLOB ,strExtInfo TEXT ,strCurrentBgUrl TEXT ,bgType BLOB ,encId TEXT ,busiEntry TEXT ,favoriteSource INTEGER ,visibleMusicPendant INTEGER ,autoPlayMusicPendant INTEGER ,showRedPointMusicPendant INTEGER ,privilegePromptStr TEXT ,privilegeJumpUrl TEXT ,vOpenPriv BLOB ,vClosePriv BLOB ,presentDesc TEXT ,presentCustourl TEXT ,presentSwitch INTEGER ,showPresent INTEGER ,showMusicBox INTEGER ,addSrcName TEXT ,addSrcId INTEGER ,addSubSrcId INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,olympicTorch INTEGER ,mNowShowFlag INTEGER ,mNowShowIconUrl TEXT ,mNowShowJumpUrl TEXT ,vCoverInfo BLOB ,videoHeadFlag INTEGER ,videoHeadUrl TEXT ,medalSwitchDisable INTEGER ,iMedalCount INTEGER ,iNewCount INTEGER ,iUpgradeCount INTEGER ,strPromptParams TEXT ,hobbyEntry TEXT ,lastPraiseInfoList BLOB ,tempChatSig BLOB ,namePlateOfKingGameId INTEGER ,namePlateOfKingLoginTime INTEGER ,namePlateOfKingDan INTEGER ,namePlateOfKingDanDisplatSwitch INTEGER ,vPersonalityLabelV2 BLOB ,cardType INTEGER ,diyText TEXT ,diyTextFontId INTEGER ,diyTextWidth REAL ,diyTextHeight REAL ,diyTextLocX REAL ,diyTextLocY REAL ,diyTextDegree REAL ,diyTextScale REAL ,diyTextTransparency REAL ,diyDefaultText TEXT ,popularity INTEGER ,declaration TEXT ,voiceUrl TEXT ,isShowCard INTEGER ,updateTime INTEGER ,extendFriendFlag INTEGER ,extendFriendVoiceDuration INTEGER ,extendFriendEntryContact INTEGER ,extendFriendEntryAddFriend INTEGER ,extendFriendQuestion INTEGER ,isShowMiniPlaying INTEGER ,tabJumpUrl TEXT ,guestJumpUrl TEXT ,guestAppTotal INTEGER ,defaultCardId INTEGER ,strangerVoteOpen INTEGER ,lSuperVipTemplateId INTEGER ,bBigClubVipOpen INTEGER ,iBigClubVipType INTEGER ,iBigClubVipLevel INTEGER ,lBigClubTemplateId INTEGER ,diyComplicatedInfo TEXT ,cardId INTEGER ,strangerInviteMeGroupOpen INTEGER ,isPrettyGroupOwner INTEGER ,isHidePrettyGroutIdentity INTEGER ,mQQLevelType INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (Card)paramauko;
    paramContentValues.put("uin", paramauko.uin);
    paramContentValues.put("strNick", paramauko.strNick);
    paramContentValues.put("shGender", Short.valueOf(paramauko.shGender));
    paramContentValues.put("shAge", Short.valueOf(paramauko.shAge));
    paramContentValues.put("nFaceID", Integer.valueOf(paramauko.nFaceID));
    paramContentValues.put("strCertificationInfo", paramauko.strCertificationInfo);
    paramContentValues.put("shType", Short.valueOf(paramauko.shType));
    paramContentValues.put("vContent", paramauko.vContent);
    paramContentValues.put("strSign", paramauko.strSign);
    paramContentValues.put("strCompany", paramauko.strCompany);
    paramContentValues.put("strSchool", paramauko.strSchool);
    paramContentValues.put("uFaceTimeStamp", Integer.valueOf(paramauko.uFaceTimeStamp));
    paramContentValues.put("vQQFaceID", paramauko.vQQFaceID);
    paramContentValues.put("strReMark", paramauko.strReMark);
    paramContentValues.put("bWeiboInfo", Byte.valueOf(paramauko.bWeiboInfo));
    paramContentValues.put("bQzoneInfo", Byte.valueOf(paramauko.bQzoneInfo));
    paramContentValues.put("nSameFriendsNum", Integer.valueOf(paramauko.nSameFriendsNum));
    paramContentValues.put("strCompanySame", paramauko.strCompanySame);
    paramContentValues.put("strSchoolSame", paramauko.strSchoolSame);
    paramContentValues.put("lCardShowNum", Long.valueOf(paramauko.lCardShowNum));
    paramContentValues.put("bSingle", Byte.valueOf(paramauko.bSingle));
    paramContentValues.put("lVisitCount", Long.valueOf(paramauko.lVisitCount));
    paramContentValues.put("lVoteCount", Long.valueOf(paramauko.lVoteCount));
    paramContentValues.put("tagInfosByte", paramauko.tagInfosByte);
    paramContentValues.put("eUserIdentityType", Byte.valueOf(paramauko.eUserIdentityType));
    paramContentValues.put("vBackground", paramauko.vBackground);
    paramContentValues.put("labelInfoBytes", paramauko.labelInfoBytes);
    paramContentValues.put("age", Byte.valueOf(paramauko.age));
    paramContentValues.put("constellation", Integer.valueOf(paramauko.constellation));
    paramContentValues.put("pyFaceUrl", paramauko.pyFaceUrl);
    paramContentValues.put("location", paramauko.location);
    paramContentValues.put("bVoted", Byte.valueOf(paramauko.bVoted));
    paramContentValues.put("bFavorited", Byte.valueOf(paramauko.bFavorited));
    paramContentValues.put("iVoteIncrement", Integer.valueOf(paramauko.iVoteIncrement));
    paramContentValues.put("strJoinHexAlbumFileKey", paramauko.strJoinHexAlbumFileKey);
    paramContentValues.put("iFaceNum", Integer.valueOf(paramauko.iFaceNum));
    paramContentValues.put("cSqqLevel", Byte.valueOf(paramauko.cSqqLevel));
    paramContentValues.put("iQQLevel", Integer.valueOf(paramauko.iQQLevel));
    paramContentValues.put("uCurMulType", Long.valueOf(paramauko.uCurMulType));
    paramContentValues.put("strProvince", paramauko.strProvince);
    paramContentValues.put("strCity", paramauko.strCity);
    paramContentValues.put("strCountry", paramauko.strCountry);
    paramContentValues.put("lBirthday", Long.valueOf(paramauko.lBirthday));
    paramContentValues.put("strLocationCodes", paramauko.strLocationCodes);
    paramContentValues.put("strLocationDesc", paramauko.strLocationDesc);
    paramContentValues.put("strHometownCodes", paramauko.strHometownCodes);
    paramContentValues.put("strHometownDesc", paramauko.strHometownDesc);
    paramContentValues.put("strEmail", paramauko.strEmail);
    paramContentValues.put("strPersonalNote", paramauko.strPersonalNote);
    paramContentValues.put("iProfession", Integer.valueOf(paramauko.iProfession));
    paramContentValues.put("bindPhoneInfo", paramauko.bindPhoneInfo);
    paramContentValues.put("bCardInfo", paramauko.bCardInfo);
    paramContentValues.put("strTroopName", paramauko.strTroopName);
    paramContentValues.put("strTroopNick", paramauko.strTroopNick);
    paramContentValues.put("strMobile", paramauko.strMobile);
    paramContentValues.put("strContactName", paramauko.strContactName);
    paramContentValues.put("ulShowControl", Integer.valueOf(paramauko.ulShowControl));
    paramContentValues.put("feedPreviewTime", Long.valueOf(paramauko.feedPreviewTime));
    paramContentValues.put("strQzoneFeedsDesc", paramauko.strQzoneFeedsDesc);
    paramContentValues.put("StrPresentDesc", paramauko.StrPresentDesc);
    paramContentValues.put("strSpaceName", paramauko.strSpaceName);
    paramContentValues.put("strQzoneHeader", paramauko.strQzoneHeader);
    paramContentValues.put("vQzonePhotos", paramauko.vQzonePhotos);
    paramContentValues.put("vQzoneCoverInfo", paramauko.vQzoneCoverInfo);
    paramContentValues.put("enlargeQzonePic", Integer.valueOf(paramauko.enlargeQzonePic));
    paramContentValues.put("showPublishButton", Boolean.valueOf(paramauko.showPublishButton));
    paramContentValues.put("strStatus", paramauko.strStatus);
    paramContentValues.put("strAutoRemark", paramauko.strAutoRemark);
    paramContentValues.put("vSeed", paramauko.vSeed);
    paramContentValues.put("vCookies", paramauko.vCookies);
    paramContentValues.put("hasFakeData", Boolean.valueOf(paramauko.hasFakeData));
    paramContentValues.put("bQQVipOpen", Byte.valueOf(paramauko.bQQVipOpen));
    paramContentValues.put("iQQVipType", Integer.valueOf(paramauko.iQQVipType));
    paramContentValues.put("iQQVipLevel", Integer.valueOf(paramauko.iQQVipLevel));
    paramContentValues.put("nameplateVipType", Integer.valueOf(paramauko.nameplateVipType));
    paramContentValues.put("grayNameplateFlag", Integer.valueOf(paramauko.grayNameplateFlag));
    paramContentValues.put("bSuperVipOpen", Byte.valueOf(paramauko.bSuperVipOpen));
    paramContentValues.put("iSuperVipType", Integer.valueOf(paramauko.iSuperVipType));
    paramContentValues.put("iSuperVipLevel", Integer.valueOf(paramauko.iSuperVipLevel));
    paramContentValues.put("bSuperQQOpen", Byte.valueOf(paramauko.bSuperQQOpen));
    paramContentValues.put("iSuperQQType", Integer.valueOf(paramauko.iSuperQQType));
    paramContentValues.put("iSuperQQLevel", Integer.valueOf(paramauko.iSuperQQLevel));
    paramContentValues.put("bHollywoodVipOpen", Byte.valueOf(paramauko.bHollywoodVipOpen));
    paramContentValues.put("iHollywoodVipType", Integer.valueOf(paramauko.iHollywoodVipType));
    paramContentValues.put("iHollywoodVipLevel", Integer.valueOf(paramauko.iHollywoodVipLevel));
    paramContentValues.put("strShowName", paramauko.strShowName);
    paramContentValues.put("strVoiceFilekey", paramauko.strVoiceFilekey);
    paramContentValues.put("shDuration", Short.valueOf(paramauko.shDuration));
    paramContentValues.put("bRead", Byte.valueOf(paramauko.bRead));
    paramContentValues.put("strUrl", paramauko.strUrl);
    paramContentValues.put("vRichSign", paramauko.vRichSign);
    paramContentValues.put("lSignModifyTime", Long.valueOf(paramauko.lSignModifyTime));
    paramContentValues.put("vLongNickTopicInfo", paramauko.vLongNickTopicInfo);
    paramContentValues.put("nLastGameFlag", Integer.valueOf(paramauko.nLastGameFlag));
    paramContentValues.put("strGameLogoUrl_1", paramauko.strGameLogoUrl_1);
    paramContentValues.put("strGameLogoUrl_2", paramauko.strGameLogoUrl_2);
    paramContentValues.put("strGameLogoUrl_3", paramauko.strGameLogoUrl_3);
    paramContentValues.put("strGameLogoUrl_4", paramauko.strGameLogoUrl_4);
    paramContentValues.put("strGameLogoKey_1", paramauko.strGameLogoKey_1);
    paramContentValues.put("strGameLogoKey_2", paramauko.strGameLogoKey_2);
    paramContentValues.put("strGameLogoKey_3", paramauko.strGameLogoKey_3);
    paramContentValues.put("strGameLogoKey_4", paramauko.strGameLogoKey_4);
    paramContentValues.put("strGameName_1", paramauko.strGameName_1);
    paramContentValues.put("strGameName_2", paramauko.strGameName_2);
    paramContentValues.put("strGameName_3", paramauko.strGameName_3);
    paramContentValues.put("strGameName_4", paramauko.strGameName_4);
    paramContentValues.put("strGameAppid_1", paramauko.strGameAppid_1);
    paramContentValues.put("strGameAppid_2", paramauko.strGameAppid_2);
    paramContentValues.put("strGameAppid_3", paramauko.strGameAppid_3);
    paramContentValues.put("strGameAppid_4", paramauko.strGameAppid_4);
    paramContentValues.put("strProfileUrl", paramauko.strProfileUrl);
    paramContentValues.put("nStarFansFlag", Integer.valueOf(paramauko.nStarFansFlag));
    paramContentValues.put("strStarPicUrl_0", paramauko.strStarPicUrl_0);
    paramContentValues.put("strStarPicUrl_1", paramauko.strStarPicUrl_1);
    paramContentValues.put("strStarPicUrl_2", paramauko.strStarPicUrl_2);
    paramContentValues.put("strStarLvUrl_0", paramauko.strStarLvUrl_0);
    paramContentValues.put("strStarLvUrl_1", paramauko.strStarLvUrl_1);
    paramContentValues.put("strStarLvUrl_2", paramauko.strStarLvUrl_2);
    paramContentValues.put("strStarLogoUrl", paramauko.strStarLogoUrl);
    paramContentValues.put("starFansJumpUrl", paramauko.starFansJumpUrl);
    paramContentValues.put("lUserFlag", Long.valueOf(paramauko.lUserFlag));
    paramContentValues.put("lLoginDays", Long.valueOf(paramauko.lLoginDays));
    paramContentValues.put("strLoginDaysDesc", paramauko.strLoginDaysDesc);
    paramContentValues.put("lQQMasterLogindays", Long.valueOf(paramauko.lQQMasterLogindays));
    paramContentValues.put("iXManScene1DelayTime", Integer.valueOf(paramauko.iXManScene1DelayTime));
    paramContentValues.put("iXManScene2DelayTime", Integer.valueOf(paramauko.iXManScene2DelayTime));
    paramContentValues.put("allowPeopleSee", Boolean.valueOf(paramauko.allowPeopleSee));
    paramContentValues.put("allowCalInteractive", Boolean.valueOf(paramauko.allowCalInteractive));
    paramContentValues.put("showOnlineFriends", Boolean.valueOf(paramauko.showOnlineFriends));
    paramContentValues.put("allowClick", Boolean.valueOf(paramauko.allowClick));
    paramContentValues.put("babyQSwitch", Boolean.valueOf(paramauko.babyQSwitch));
    paramContentValues.put("showLightalk", Boolean.valueOf(paramauko.showLightalk));
    paramContentValues.put("lightalkNick", paramauko.lightalkNick);
    paramContentValues.put("lightalkId", paramauko.lightalkId);
    paramContentValues.put("isSuperRedDiamond", Boolean.valueOf(paramauko.isSuperRedDiamond));
    paramContentValues.put("isRedDiamond", Boolean.valueOf(paramauko.isRedDiamond));
    paramContentValues.put("redLevel", Integer.valueOf(paramauko.redLevel));
    paramContentValues.put("isSuperYellowDiamond", Boolean.valueOf(paramauko.isSuperYellowDiamond));
    paramContentValues.put("isYellowDiamond", Boolean.valueOf(paramauko.isYellowDiamond));
    paramContentValues.put("yellowLevel", Integer.valueOf(paramauko.yellowLevel));
    paramContentValues.put("isSuperGreenDiamond", Boolean.valueOf(paramauko.isSuperGreenDiamond));
    paramContentValues.put("isGreenDiamond", Boolean.valueOf(paramauko.isGreenDiamond));
    paramContentValues.put("greenLevel", Integer.valueOf(paramauko.greenLevel));
    paramContentValues.put("uAccelerateMultiple", Long.valueOf(paramauko.uAccelerateMultiple));
    paramContentValues.put("strRespMusicInfo", paramauko.strRespMusicInfo);
    paramContentValues.put("templateRet", Integer.valueOf(paramauko.templateRet));
    paramContentValues.put("lCurrentStyleId", Long.valueOf(paramauko.lCurrentStyleId));
    paramContentValues.put("lCurrentBgId", Long.valueOf(paramauko.lCurrentBgId));
    paramContentValues.put("backgroundUrl", paramauko.backgroundUrl);
    paramContentValues.put("backgroundColor", Long.valueOf(paramauko.backgroundColor));
    paramContentValues.put("dynamicCardFlag", Integer.valueOf(paramauko.dynamicCardFlag));
    paramContentValues.put("strZipUrl", paramauko.strZipUrl);
    paramContentValues.put("strActiveUrl", paramauko.strActiveUrl);
    paramContentValues.put("strDrawerCardUrl", paramauko.strDrawerCardUrl);
    paramContentValues.put("strWzryHeroUrl", paramauko.strWzryHeroUrl);
    paramContentValues.put("wzryHonorInfo", paramauko.wzryHonorInfo);
    paramContentValues.put("strExtInfo", paramauko.strExtInfo);
    paramContentValues.put("strCurrentBgUrl", paramauko.strCurrentBgUrl);
    paramContentValues.put("bgType", paramauko.bgType);
    paramContentValues.put("encId", paramauko.encId);
    paramContentValues.put("busiEntry", paramauko.busiEntry);
    paramContentValues.put("favoriteSource", Integer.valueOf(paramauko.favoriteSource));
    paramContentValues.put("visibleMusicPendant", Boolean.valueOf(paramauko.visibleMusicPendant));
    paramContentValues.put("autoPlayMusicPendant", Boolean.valueOf(paramauko.autoPlayMusicPendant));
    paramContentValues.put("showRedPointMusicPendant", Boolean.valueOf(paramauko.showRedPointMusicPendant));
    paramContentValues.put("privilegePromptStr", paramauko.privilegePromptStr);
    paramContentValues.put("privilegeJumpUrl", paramauko.privilegeJumpUrl);
    paramContentValues.put("vOpenPriv", paramauko.vOpenPriv);
    paramContentValues.put("vClosePriv", paramauko.vClosePriv);
    paramContentValues.put("presentDesc", paramauko.presentDesc);
    paramContentValues.put("presentCustourl", paramauko.presentCustourl);
    paramContentValues.put("presentSwitch", Boolean.valueOf(paramauko.presentSwitch));
    paramContentValues.put("showPresent", Boolean.valueOf(paramauko.showPresent));
    paramContentValues.put("showMusicBox", Boolean.valueOf(paramauko.showMusicBox));
    paramContentValues.put("addSrcName", paramauko.addSrcName);
    paramContentValues.put("addSrcId", Long.valueOf(paramauko.addSrcId));
    paramContentValues.put("addSubSrcId", Long.valueOf(paramauko.addSubSrcId));
    paramContentValues.put("strVoteLimitedNotice", paramauko.strVoteLimitedNotice);
    paramContentValues.put("bHaveVotedCnt", Short.valueOf(paramauko.bHaveVotedCnt));
    paramContentValues.put("bAvailVoteCnt", Short.valueOf(paramauko.bAvailVoteCnt));
    paramContentValues.put("olympicTorch", Byte.valueOf(paramauko.olympicTorch));
    paramContentValues.put("mNowShowFlag", Integer.valueOf(paramauko.mNowShowFlag));
    paramContentValues.put("mNowShowIconUrl", paramauko.mNowShowIconUrl);
    paramContentValues.put("mNowShowJumpUrl", paramauko.mNowShowJumpUrl);
    paramContentValues.put("vCoverInfo", paramauko.vCoverInfo);
    paramContentValues.put("videoHeadFlag", Boolean.valueOf(paramauko.videoHeadFlag));
    paramContentValues.put("videoHeadUrl", paramauko.videoHeadUrl);
    paramContentValues.put("medalSwitchDisable", Boolean.valueOf(paramauko.medalSwitchDisable));
    paramContentValues.put("iMedalCount", Integer.valueOf(paramauko.iMedalCount));
    paramContentValues.put("iNewCount", Integer.valueOf(paramauko.iNewCount));
    paramContentValues.put("iUpgradeCount", Integer.valueOf(paramauko.iUpgradeCount));
    paramContentValues.put("strPromptParams", paramauko.strPromptParams);
    paramContentValues.put("hobbyEntry", paramauko.hobbyEntry);
    paramContentValues.put("lastPraiseInfoList", paramauko.lastPraiseInfoList);
    paramContentValues.put("tempChatSig", paramauko.tempChatSig);
    paramContentValues.put("namePlateOfKingGameId", Long.valueOf(paramauko.namePlateOfKingGameId));
    paramContentValues.put("namePlateOfKingLoginTime", Long.valueOf(paramauko.namePlateOfKingLoginTime));
    paramContentValues.put("namePlateOfKingDan", Integer.valueOf(paramauko.namePlateOfKingDan));
    paramContentValues.put("namePlateOfKingDanDisplatSwitch", Boolean.valueOf(paramauko.namePlateOfKingDanDisplatSwitch));
    paramContentValues.put("vPersonalityLabelV2", paramauko.vPersonalityLabelV2);
    paramContentValues.put("cardType", Integer.valueOf(paramauko.cardType));
    paramContentValues.put("diyText", paramauko.diyText);
    paramContentValues.put("diyTextFontId", Integer.valueOf(paramauko.diyTextFontId));
    paramContentValues.put("diyTextWidth", Float.valueOf(paramauko.diyTextWidth));
    paramContentValues.put("diyTextHeight", Float.valueOf(paramauko.diyTextHeight));
    paramContentValues.put("diyTextLocX", Float.valueOf(paramauko.diyTextLocX));
    paramContentValues.put("diyTextLocY", Float.valueOf(paramauko.diyTextLocY));
    paramContentValues.put("diyTextDegree", Float.valueOf(paramauko.diyTextDegree));
    paramContentValues.put("diyTextScale", Float.valueOf(paramauko.diyTextScale));
    paramContentValues.put("diyTextTransparency", Float.valueOf(paramauko.diyTextTransparency));
    paramContentValues.put("diyDefaultText", paramauko.diyDefaultText);
    paramContentValues.put("popularity", Integer.valueOf(paramauko.popularity));
    paramContentValues.put("declaration", paramauko.declaration);
    paramContentValues.put("voiceUrl", paramauko.voiceUrl);
    paramContentValues.put("isShowCard", Boolean.valueOf(paramauko.isShowCard));
    paramContentValues.put("updateTime", Long.valueOf(paramauko.updateTime));
    paramContentValues.put("extendFriendFlag", Integer.valueOf(paramauko.extendFriendFlag));
    paramContentValues.put("extendFriendVoiceDuration", Integer.valueOf(paramauko.extendFriendVoiceDuration));
    paramContentValues.put("extendFriendEntryContact", Short.valueOf(paramauko.extendFriendEntryContact));
    paramContentValues.put("extendFriendEntryAddFriend", Short.valueOf(paramauko.extendFriendEntryAddFriend));
    paramContentValues.put("extendFriendQuestion", Short.valueOf(paramauko.extendFriendQuestion));
    paramContentValues.put("isShowMiniPlaying", Boolean.valueOf(paramauko.isShowMiniPlaying));
    paramContentValues.put("tabJumpUrl", paramauko.tabJumpUrl);
    paramContentValues.put("guestJumpUrl", paramauko.guestJumpUrl);
    paramContentValues.put("guestAppTotal", Integer.valueOf(paramauko.guestAppTotal));
    paramContentValues.put("defaultCardId", Integer.valueOf(paramauko.defaultCardId));
    paramContentValues.put("strangerVoteOpen", Boolean.valueOf(paramauko.strangerVoteOpen));
    paramContentValues.put("lSuperVipTemplateId", Long.valueOf(paramauko.lSuperVipTemplateId));
    paramContentValues.put("bBigClubVipOpen", Byte.valueOf(paramauko.bBigClubVipOpen));
    paramContentValues.put("iBigClubVipType", Integer.valueOf(paramauko.iBigClubVipType));
    paramContentValues.put("iBigClubVipLevel", Integer.valueOf(paramauko.iBigClubVipLevel));
    paramContentValues.put("lBigClubTemplateId", Long.valueOf(paramauko.lBigClubTemplateId));
    paramContentValues.put("diyComplicatedInfo", paramauko.diyComplicatedInfo);
    paramContentValues.put("cardId", Long.valueOf(paramauko.cardId));
    paramContentValues.put("strangerInviteMeGroupOpen", Boolean.valueOf(paramauko.strangerInviteMeGroupOpen));
    paramContentValues.put("isPrettyGroupOwner", Boolean.valueOf(paramauko.isPrettyGroupOwner));
    paramContentValues.put("isHidePrettyGroutIdentity", Boolean.valueOf(paramauko.isHidePrettyGroutIdentity));
    paramContentValues.put("mQQLevelType", Integer.valueOf(paramauko.mQQLevelType));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukd
 * JD-Core Version:    0.7.0.1
 */