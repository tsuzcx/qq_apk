import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukb
  extends auky
{
  public aukb()
  {
    this.a = 238;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramaukm = (Card)paramaukm;
    label1330:
    label2406:
    label2536:
    label4842:
    if (paramaukx == null)
    {
      paramaukm.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramaukm.strNick = paramCursor.getString(paramCursor.getColumnIndex("strNick"));
      paramaukm.shGender = paramCursor.getShort(paramCursor.getColumnIndex("shGender"));
      paramaukm.shAge = paramCursor.getShort(paramCursor.getColumnIndex("shAge"));
      paramaukm.nFaceID = paramCursor.getInt(paramCursor.getColumnIndex("nFaceID"));
      paramaukm.strCertificationInfo = paramCursor.getString(paramCursor.getColumnIndex("strCertificationInfo"));
      paramaukm.shType = paramCursor.getShort(paramCursor.getColumnIndex("shType"));
      paramaukm.vContent = paramCursor.getBlob(paramCursor.getColumnIndex("vContent"));
      paramaukm.strSign = paramCursor.getString(paramCursor.getColumnIndex("strSign"));
      paramaukm.strCompany = paramCursor.getString(paramCursor.getColumnIndex("strCompany"));
      paramaukm.strSchool = paramCursor.getString(paramCursor.getColumnIndex("strSchool"));
      paramaukm.uFaceTimeStamp = paramCursor.getInt(paramCursor.getColumnIndex("uFaceTimeStamp"));
      paramaukm.vQQFaceID = paramCursor.getBlob(paramCursor.getColumnIndex("vQQFaceID"));
      paramaukm.strReMark = paramCursor.getString(paramCursor.getColumnIndex("strReMark"));
      paramaukm.bWeiboInfo = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bWeiboInfo")));
      paramaukm.bQzoneInfo = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bQzoneInfo")));
      paramaukm.nSameFriendsNum = paramCursor.getInt(paramCursor.getColumnIndex("nSameFriendsNum"));
      paramaukm.strCompanySame = paramCursor.getString(paramCursor.getColumnIndex("strCompanySame"));
      paramaukm.strSchoolSame = paramCursor.getString(paramCursor.getColumnIndex("strSchoolSame"));
      paramaukm.lCardShowNum = paramCursor.getLong(paramCursor.getColumnIndex("lCardShowNum"));
      paramaukm.bSingle = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSingle")));
      paramaukm.lVisitCount = paramCursor.getLong(paramCursor.getColumnIndex("lVisitCount"));
      paramaukm.lVoteCount = paramCursor.getLong(paramCursor.getColumnIndex("lVoteCount"));
      paramaukm.tagInfosByte = paramCursor.getBlob(paramCursor.getColumnIndex("tagInfosByte"));
      paramaukm.eUserIdentityType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("eUserIdentityType")));
      paramaukm.vBackground = paramCursor.getBlob(paramCursor.getColumnIndex("vBackground"));
      paramaukm.labelInfoBytes = paramCursor.getBlob(paramCursor.getColumnIndex("labelInfoBytes"));
      paramaukm.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramaukm.constellation = paramCursor.getInt(paramCursor.getColumnIndex("constellation"));
      paramaukm.pyFaceUrl = paramCursor.getString(paramCursor.getColumnIndex("pyFaceUrl"));
      paramaukm.location = paramCursor.getString(paramCursor.getColumnIndex("location"));
      paramaukm.bVoted = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bVoted")));
      paramaukm.bFavorited = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bFavorited")));
      paramaukm.iVoteIncrement = paramCursor.getInt(paramCursor.getColumnIndex("iVoteIncrement"));
      paramaukm.strJoinHexAlbumFileKey = paramCursor.getString(paramCursor.getColumnIndex("strJoinHexAlbumFileKey"));
      paramaukm.iFaceNum = paramCursor.getInt(paramCursor.getColumnIndex("iFaceNum"));
      paramaukm.cSqqLevel = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSqqLevel")));
      paramaukm.iQQLevel = paramCursor.getInt(paramCursor.getColumnIndex("iQQLevel"));
      paramaukm.uCurMulType = paramCursor.getLong(paramCursor.getColumnIndex("uCurMulType"));
      paramaukm.strProvince = paramCursor.getString(paramCursor.getColumnIndex("strProvince"));
      paramaukm.strCity = paramCursor.getString(paramCursor.getColumnIndex("strCity"));
      paramaukm.strCountry = paramCursor.getString(paramCursor.getColumnIndex("strCountry"));
      paramaukm.lBirthday = paramCursor.getLong(paramCursor.getColumnIndex("lBirthday"));
      paramaukm.strLocationCodes = paramCursor.getString(paramCursor.getColumnIndex("strLocationCodes"));
      paramaukm.strLocationDesc = paramCursor.getString(paramCursor.getColumnIndex("strLocationDesc"));
      paramaukm.strHometownCodes = paramCursor.getString(paramCursor.getColumnIndex("strHometownCodes"));
      paramaukm.strHometownDesc = paramCursor.getString(paramCursor.getColumnIndex("strHometownDesc"));
      paramaukm.strEmail = paramCursor.getString(paramCursor.getColumnIndex("strEmail"));
      paramaukm.strPersonalNote = paramCursor.getString(paramCursor.getColumnIndex("strPersonalNote"));
      paramaukm.iProfession = paramCursor.getInt(paramCursor.getColumnIndex("iProfession"));
      paramaukm.bindPhoneInfo = paramCursor.getString(paramCursor.getColumnIndex("bindPhoneInfo"));
      paramaukm.bCardInfo = paramCursor.getBlob(paramCursor.getColumnIndex("bCardInfo"));
      paramaukm.strTroopName = paramCursor.getString(paramCursor.getColumnIndex("strTroopName"));
      paramaukm.strTroopNick = paramCursor.getString(paramCursor.getColumnIndex("strTroopNick"));
      paramaukm.strMobile = paramCursor.getString(paramCursor.getColumnIndex("strMobile"));
      paramaukm.strContactName = paramCursor.getString(paramCursor.getColumnIndex("strContactName"));
      paramaukm.ulShowControl = paramCursor.getInt(paramCursor.getColumnIndex("ulShowControl"));
      paramaukm.feedPreviewTime = paramCursor.getLong(paramCursor.getColumnIndex("feedPreviewTime"));
      paramaukm.strQzoneFeedsDesc = paramCursor.getString(paramCursor.getColumnIndex("strQzoneFeedsDesc"));
      paramaukm.StrPresentDesc = paramCursor.getString(paramCursor.getColumnIndex("StrPresentDesc"));
      paramaukm.strSpaceName = paramCursor.getString(paramCursor.getColumnIndex("strSpaceName"));
      paramaukm.strQzoneHeader = paramCursor.getString(paramCursor.getColumnIndex("strQzoneHeader"));
      paramaukm.vQzonePhotos = paramCursor.getBlob(paramCursor.getColumnIndex("vQzonePhotos"));
      paramaukm.vQzoneCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vQzoneCoverInfo"));
      paramaukm.enlargeQzonePic = paramCursor.getInt(paramCursor.getColumnIndex("enlargeQzonePic"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("showPublishButton")))
      {
        paramBoolean = true;
        paramaukm.showPublishButton = paramBoolean;
        paramaukm.strStatus = paramCursor.getString(paramCursor.getColumnIndex("strStatus"));
        paramaukm.strAutoRemark = paramCursor.getString(paramCursor.getColumnIndex("strAutoRemark"));
        paramaukm.vSeed = paramCursor.getBlob(paramCursor.getColumnIndex("vSeed"));
        paramaukm.vCookies = paramCursor.getBlob(paramCursor.getColumnIndex("vCookies"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasFakeData"))) {
          break label4712;
        }
        paramBoolean = true;
        paramaukm.hasFakeData = paramBoolean;
        paramaukm.bQQVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bQQVipOpen")));
        paramaukm.iQQVipType = paramCursor.getInt(paramCursor.getColumnIndex("iQQVipType"));
        paramaukm.iQQVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iQQVipLevel"));
        paramaukm.nameplateVipType = paramCursor.getInt(paramCursor.getColumnIndex("nameplateVipType"));
        paramaukm.grayNameplateFlag = paramCursor.getInt(paramCursor.getColumnIndex("grayNameplateFlag"));
        paramaukm.bSuperVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSuperVipOpen")));
        paramaukm.iSuperVipType = paramCursor.getInt(paramCursor.getColumnIndex("iSuperVipType"));
        paramaukm.iSuperVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iSuperVipLevel"));
        paramaukm.bSuperQQOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSuperQQOpen")));
        paramaukm.iSuperQQType = paramCursor.getInt(paramCursor.getColumnIndex("iSuperQQType"));
        paramaukm.iSuperQQLevel = paramCursor.getInt(paramCursor.getColumnIndex("iSuperQQLevel"));
        paramaukm.bHollywoodVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bHollywoodVipOpen")));
        paramaukm.iHollywoodVipType = paramCursor.getInt(paramCursor.getColumnIndex("iHollywoodVipType"));
        paramaukm.iHollywoodVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iHollywoodVipLevel"));
        paramaukm.strShowName = paramCursor.getString(paramCursor.getColumnIndex("strShowName"));
        paramaukm.strVoiceFilekey = paramCursor.getString(paramCursor.getColumnIndex("strVoiceFilekey"));
        paramaukm.shDuration = paramCursor.getShort(paramCursor.getColumnIndex("shDuration"));
        paramaukm.bRead = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bRead")));
        paramaukm.strUrl = paramCursor.getString(paramCursor.getColumnIndex("strUrl"));
        paramaukm.vRichSign = paramCursor.getBlob(paramCursor.getColumnIndex("vRichSign"));
        paramaukm.lSignModifyTime = paramCursor.getLong(paramCursor.getColumnIndex("lSignModifyTime"));
        paramaukm.vLongNickTopicInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vLongNickTopicInfo"));
        paramaukm.nLastGameFlag = paramCursor.getInt(paramCursor.getColumnIndex("nLastGameFlag"));
        paramaukm.strGameLogoUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_1"));
        paramaukm.strGameLogoUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_2"));
        paramaukm.strGameLogoUrl_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_3"));
        paramaukm.strGameLogoUrl_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_4"));
        paramaukm.strGameLogoKey_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_1"));
        paramaukm.strGameLogoKey_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_2"));
        paramaukm.strGameLogoKey_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_3"));
        paramaukm.strGameLogoKey_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_4"));
        paramaukm.strGameName_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_1"));
        paramaukm.strGameName_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_2"));
        paramaukm.strGameName_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_3"));
        paramaukm.strGameName_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_4"));
        paramaukm.strGameAppid_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_1"));
        paramaukm.strGameAppid_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_2"));
        paramaukm.strGameAppid_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_3"));
        paramaukm.strGameAppid_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_4"));
        paramaukm.strProfileUrl = paramCursor.getString(paramCursor.getColumnIndex("strProfileUrl"));
        paramaukm.nStarFansFlag = paramCursor.getInt(paramCursor.getColumnIndex("nStarFansFlag"));
        paramaukm.strStarPicUrl_0 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_0"));
        paramaukm.strStarPicUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_1"));
        paramaukm.strStarPicUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_2"));
        paramaukm.strStarLvUrl_0 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_0"));
        paramaukm.strStarLvUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_1"));
        paramaukm.strStarLvUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_2"));
        paramaukm.strStarLogoUrl = paramCursor.getString(paramCursor.getColumnIndex("strStarLogoUrl"));
        paramaukm.starFansJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("starFansJumpUrl"));
        paramaukm.lUserFlag = paramCursor.getLong(paramCursor.getColumnIndex("lUserFlag"));
        paramaukm.lLoginDays = paramCursor.getLong(paramCursor.getColumnIndex("lLoginDays"));
        paramaukm.strLoginDaysDesc = paramCursor.getString(paramCursor.getColumnIndex("strLoginDaysDesc"));
        paramaukm.lQQMasterLogindays = paramCursor.getLong(paramCursor.getColumnIndex("lQQMasterLogindays"));
        paramaukm.iXManScene1DelayTime = paramCursor.getInt(paramCursor.getColumnIndex("iXManScene1DelayTime"));
        paramaukm.iXManScene2DelayTime = paramCursor.getInt(paramCursor.getColumnIndex("iXManScene2DelayTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowPeopleSee"))) {
          break label4717;
        }
        paramBoolean = true;
        paramaukm.allowPeopleSee = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowCalInteractive"))) {
          break label4722;
        }
        paramBoolean = true;
        paramaukm.allowCalInteractive = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showOnlineFriends"))) {
          break label4727;
        }
        paramBoolean = true;
        paramaukm.showOnlineFriends = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowClick"))) {
          break label4732;
        }
        paramBoolean = true;
        paramaukm.allowClick = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("babyQSwitch"))) {
          break label4737;
        }
        paramBoolean = true;
        paramaukm.babyQSwitch = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showLightalk"))) {
          break label4742;
        }
        paramBoolean = true;
        paramaukm.showLightalk = paramBoolean;
        paramaukm.lightalkNick = paramCursor.getString(paramCursor.getColumnIndex("lightalkNick"));
        paramaukm.lightalkId = paramCursor.getString(paramCursor.getColumnIndex("lightalkId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperRedDiamond"))) {
          break label4747;
        }
        paramBoolean = true;
        paramaukm.isSuperRedDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRedDiamond"))) {
          break label4752;
        }
        paramBoolean = true;
        paramaukm.isRedDiamond = paramBoolean;
        paramaukm.redLevel = paramCursor.getInt(paramCursor.getColumnIndex("redLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperYellowDiamond"))) {
          break label4757;
        }
        paramBoolean = true;
        label2671:
        paramaukm.isSuperYellowDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isYellowDiamond"))) {
          break label4762;
        }
        paramBoolean = true;
        paramaukm.isYellowDiamond = paramBoolean;
        paramaukm.yellowLevel = paramCursor.getInt(paramCursor.getColumnIndex("yellowLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperGreenDiamond"))) {
          break label4767;
        }
        paramBoolean = true;
        paramaukm.isSuperGreenDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isGreenDiamond"))) {
          break label4772;
        }
        paramBoolean = true;
        paramaukm.isGreenDiamond = paramBoolean;
        paramaukm.greenLevel = paramCursor.getInt(paramCursor.getColumnIndex("greenLevel"));
        paramaukm.uAccelerateMultiple = paramCursor.getLong(paramCursor.getColumnIndex("uAccelerateMultiple"));
        paramaukm.strRespMusicInfo = paramCursor.getString(paramCursor.getColumnIndex("strRespMusicInfo"));
        paramaukm.templateRet = paramCursor.getInt(paramCursor.getColumnIndex("templateRet"));
        paramaukm.lCurrentStyleId = paramCursor.getLong(paramCursor.getColumnIndex("lCurrentStyleId"));
        paramaukm.lCurrentBgId = paramCursor.getLong(paramCursor.getColumnIndex("lCurrentBgId"));
        paramaukm.backgroundUrl = paramCursor.getString(paramCursor.getColumnIndex("backgroundUrl"));
        paramaukm.backgroundColor = paramCursor.getLong(paramCursor.getColumnIndex("backgroundColor"));
        paramaukm.dynamicCardFlag = paramCursor.getInt(paramCursor.getColumnIndex("dynamicCardFlag"));
        paramaukm.strZipUrl = paramCursor.getString(paramCursor.getColumnIndex("strZipUrl"));
        paramaukm.strActiveUrl = paramCursor.getString(paramCursor.getColumnIndex("strActiveUrl"));
        paramaukm.strDrawerCardUrl = paramCursor.getString(paramCursor.getColumnIndex("strDrawerCardUrl"));
        paramaukm.strWzryHeroUrl = paramCursor.getString(paramCursor.getColumnIndex("strWzryHeroUrl"));
        paramaukm.wzryHonorInfo = paramCursor.getBlob(paramCursor.getColumnIndex("wzryHonorInfo"));
        paramaukm.strExtInfo = paramCursor.getString(paramCursor.getColumnIndex("strExtInfo"));
        paramaukm.strCurrentBgUrl = paramCursor.getString(paramCursor.getColumnIndex("strCurrentBgUrl"));
        paramaukm.bgType = paramCursor.getBlob(paramCursor.getColumnIndex("bgType"));
        paramaukm.encId = paramCursor.getString(paramCursor.getColumnIndex("encId"));
        paramaukm.busiEntry = paramCursor.getString(paramCursor.getColumnIndex("busiEntry"));
        paramaukm.favoriteSource = paramCursor.getInt(paramCursor.getColumnIndex("favoriteSource"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("visibleMusicPendant"))) {
          break label4777;
        }
        paramBoolean = true;
        paramaukm.visibleMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("autoPlayMusicPendant"))) {
          break label4782;
        }
        paramBoolean = true;
        paramaukm.autoPlayMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showRedPointMusicPendant"))) {
          break label4787;
        }
        paramBoolean = true;
        paramaukm.showRedPointMusicPendant = paramBoolean;
        paramaukm.privilegePromptStr = paramCursor.getString(paramCursor.getColumnIndex("privilegePromptStr"));
        paramaukm.privilegeJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("privilegeJumpUrl"));
        paramaukm.vOpenPriv = paramCursor.getBlob(paramCursor.getColumnIndex("vOpenPriv"));
        paramaukm.vClosePriv = paramCursor.getBlob(paramCursor.getColumnIndex("vClosePriv"));
        paramaukm.presentDesc = paramCursor.getString(paramCursor.getColumnIndex("presentDesc"));
        paramaukm.presentCustourl = paramCursor.getString(paramCursor.getColumnIndex("presentCustourl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("presentSwitch"))) {
          break label4792;
        }
        paramBoolean = true;
        paramaukm.presentSwitch = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showPresent"))) {
          break label4797;
        }
        paramBoolean = true;
        paramaukm.showPresent = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showMusicBox"))) {
          break label4802;
        }
        paramBoolean = true;
        paramaukm.showMusicBox = paramBoolean;
        paramaukm.addSrcName = paramCursor.getString(paramCursor.getColumnIndex("addSrcName"));
        paramaukm.addSrcId = paramCursor.getLong(paramCursor.getColumnIndex("addSrcId"));
        paramaukm.addSubSrcId = paramCursor.getLong(paramCursor.getColumnIndex("addSubSrcId"));
        paramaukm.strVoteLimitedNotice = paramCursor.getString(paramCursor.getColumnIndex("strVoteLimitedNotice"));
        paramaukm.bHaveVotedCnt = paramCursor.getShort(paramCursor.getColumnIndex("bHaveVotedCnt"));
        paramaukm.bAvailVoteCnt = paramCursor.getShort(paramCursor.getColumnIndex("bAvailVoteCnt"));
        paramaukm.olympicTorch = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("olympicTorch")));
        paramaukm.mNowShowFlag = paramCursor.getInt(paramCursor.getColumnIndex("mNowShowFlag"));
        paramaukm.mNowShowIconUrl = paramCursor.getString(paramCursor.getColumnIndex("mNowShowIconUrl"));
        paramaukm.mNowShowJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("mNowShowJumpUrl"));
        paramaukm.vCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vCoverInfo"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("videoHeadFlag"))) {
          break label4807;
        }
        paramBoolean = true;
        paramaukm.videoHeadFlag = paramBoolean;
        paramaukm.videoHeadUrl = paramCursor.getString(paramCursor.getColumnIndex("videoHeadUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("medalSwitchDisable"))) {
          break label4812;
        }
        paramBoolean = true;
        label3699:
        paramaukm.medalSwitchDisable = paramBoolean;
        paramaukm.iMedalCount = paramCursor.getInt(paramCursor.getColumnIndex("iMedalCount"));
        paramaukm.iNewCount = paramCursor.getInt(paramCursor.getColumnIndex("iNewCount"));
        paramaukm.iUpgradeCount = paramCursor.getInt(paramCursor.getColumnIndex("iUpgradeCount"));
        paramaukm.strPromptParams = paramCursor.getString(paramCursor.getColumnIndex("strPromptParams"));
        paramaukm.hobbyEntry = paramCursor.getString(paramCursor.getColumnIndex("hobbyEntry"));
        paramaukm.lastPraiseInfoList = paramCursor.getBlob(paramCursor.getColumnIndex("lastPraiseInfoList"));
        paramaukm.tempChatSig = paramCursor.getBlob(paramCursor.getColumnIndex("tempChatSig"));
        paramaukm.namePlateOfKingGameId = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingGameId"));
        paramaukm.namePlateOfKingLoginTime = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingLoginTime"));
        paramaukm.namePlateOfKingDan = paramCursor.getInt(paramCursor.getColumnIndex("namePlateOfKingDan"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch"))) {
          break label4817;
        }
        paramBoolean = true;
        paramaukm.namePlateOfKingDanDisplatSwitch = paramBoolean;
        paramaukm.vPersonalityLabelV2 = paramCursor.getBlob(paramCursor.getColumnIndex("vPersonalityLabelV2"));
        paramaukm.cardType = paramCursor.getInt(paramCursor.getColumnIndex("cardType"));
        paramaukm.diyText = paramCursor.getString(paramCursor.getColumnIndex("diyText"));
        paramaukm.diyTextFontId = paramCursor.getInt(paramCursor.getColumnIndex("diyTextFontId"));
        paramaukm.diyTextWidth = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextWidth"));
        paramaukm.diyTextHeight = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextHeight"));
        paramaukm.diyTextLocX = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextLocX"));
        paramaukm.diyTextLocY = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextLocY"));
        paramaukm.diyTextDegree = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextDegree"));
        paramaukm.diyTextScale = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextScale"));
        paramaukm.diyTextTransparency = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextTransparency"));
        paramaukm.diyDefaultText = paramCursor.getString(paramCursor.getColumnIndex("diyDefaultText"));
        paramaukm.popularity = paramCursor.getInt(paramCursor.getColumnIndex("popularity"));
        paramaukm.declaration = paramCursor.getString(paramCursor.getColumnIndex("declaration"));
        paramaukm.voiceUrl = paramCursor.getString(paramCursor.getColumnIndex("voiceUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShowCard"))) {
          break label4822;
        }
        paramBoolean = true;
        paramaukm.isShowCard = paramBoolean;
        paramaukm.updateTime = paramCursor.getLong(paramCursor.getColumnIndex("updateTime"));
        paramaukm.extendFriendFlag = paramCursor.getInt(paramCursor.getColumnIndex("extendFriendFlag"));
        paramaukm.extendFriendVoiceDuration = paramCursor.getInt(paramCursor.getColumnIndex("extendFriendVoiceDuration"));
        paramaukm.extendFriendEntryContact = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendEntryContact"));
        paramaukm.extendFriendEntryAddFriend = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendEntryAddFriend"));
        paramaukm.extendFriendQuestion = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendQuestion"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShowMiniPlaying"))) {
          break label4827;
        }
        paramBoolean = true;
        paramaukm.isShowMiniPlaying = paramBoolean;
        paramaukm.tabJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("tabJumpUrl"));
        paramaukm.guestJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("guestJumpUrl"));
        paramaukm.guestAppTotal = paramCursor.getInt(paramCursor.getColumnIndex("guestAppTotal"));
        paramaukm.defaultCardId = paramCursor.getInt(paramCursor.getColumnIndex("defaultCardId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("strangerVoteOpen"))) {
          break label4832;
        }
        paramBoolean = true;
        label4468:
        paramaukm.strangerVoteOpen = paramBoolean;
        paramaukm.lSuperVipTemplateId = paramCursor.getLong(paramCursor.getColumnIndex("lSuperVipTemplateId"));
        paramaukm.bBigClubVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bBigClubVipOpen")));
        paramaukm.iBigClubVipType = paramCursor.getInt(paramCursor.getColumnIndex("iBigClubVipType"));
        paramaukm.iBigClubVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iBigClubVipLevel"));
        paramaukm.lBigClubTemplateId = paramCursor.getLong(paramCursor.getColumnIndex("lBigClubTemplateId"));
        paramaukm.diyComplicatedInfo = paramCursor.getString(paramCursor.getColumnIndex("diyComplicatedInfo"));
        paramaukm.cardId = paramCursor.getLong(paramCursor.getColumnIndex("cardId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("strangerInviteMeGroupOpen"))) {
          break label4837;
        }
        paramBoolean = true;
        paramaukm.strangerInviteMeGroupOpen = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isPrettyGroupOwner"))) {
          break label4842;
        }
        paramBoolean = true;
        paramaukm.isPrettyGroupOwner = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isHidePrettyGroutIdentity"))) {
          break label4847;
        }
      }
      label4717:
      label4847:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramaukm.isHidePrettyGroutIdentity = paramBoolean;
        paramaukm.mQQLevelType = paramCursor.getInt(paramCursor.getColumnIndex("mQQLevelType"));
        return paramaukm;
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
      paramaukx.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("strNick");
      if (i != -1) {
        break label13571;
      }
      paramaukx.a(new NoColumnError("strNick", String.class));
      i = paramCursor.getColumnIndex("shGender");
      if (i != -1) {
        break label13586;
      }
      paramaukx.a(new NoColumnError("shGender", Short.TYPE));
      i = paramCursor.getColumnIndex("shAge");
      if (i != -1) {
        break label13601;
      }
      paramaukx.a(new NoColumnError("shAge", Short.TYPE));
      i = paramCursor.getColumnIndex("nFaceID");
      if (i != -1) {
        break label13616;
      }
      paramaukx.a(new NoColumnError("nFaceID", Integer.TYPE));
      i = paramCursor.getColumnIndex("strCertificationInfo");
      if (i != -1) {
        break label13631;
      }
      paramaukx.a(new NoColumnError("strCertificationInfo", String.class));
      i = paramCursor.getColumnIndex("shType");
      if (i != -1) {
        break label13646;
      }
      paramaukx.a(new NoColumnError("shType", Short.TYPE));
      label5097:
      i = paramCursor.getColumnIndex("vContent");
      if (i != -1) {
        break label13661;
      }
      paramaukx.a(new NoColumnError("vContent", [B.class));
      i = paramCursor.getColumnIndex("strSign");
      if (i != -1) {
        break label13676;
      }
      paramaukx.a(new NoColumnError("strSign", String.class));
      i = paramCursor.getColumnIndex("strCompany");
      if (i != -1) {
        break label13691;
      }
      paramaukx.a(new NoColumnError("strCompany", String.class));
      i = paramCursor.getColumnIndex("strSchool");
      if (i != -1) {
        break label13706;
      }
      paramaukx.a(new NoColumnError("strSchool", String.class));
      label5237:
      i = paramCursor.getColumnIndex("uFaceTimeStamp");
      if (i != -1) {
        break label13721;
      }
      paramaukx.a(new NoColumnError("uFaceTimeStamp", Integer.TYPE));
      i = paramCursor.getColumnIndex("vQQFaceID");
      if (i != -1) {
        break label13736;
      }
      paramaukx.a(new NoColumnError("vQQFaceID", [B.class));
      i = paramCursor.getColumnIndex("strReMark");
      if (i != -1) {
        break label13751;
      }
      paramaukx.a(new NoColumnError("strReMark", String.class));
      i = paramCursor.getColumnIndex("bWeiboInfo");
      if (i != -1) {
        break label13766;
      }
      paramaukx.a(new NoColumnError("bWeiboInfo", Byte.TYPE));
      i = paramCursor.getColumnIndex("bQzoneInfo");
      if (i != -1) {
        break label13782;
      }
      paramaukx.a(new NoColumnError("bQzoneInfo", Byte.TYPE));
      i = paramCursor.getColumnIndex("nSameFriendsNum");
      if (i != -1) {
        break label13798;
      }
      paramaukx.a(new NoColumnError("nSameFriendsNum", Integer.TYPE));
      i = paramCursor.getColumnIndex("strCompanySame");
      if (i != -1) {
        break label13813;
      }
      paramaukx.a(new NoColumnError("strCompanySame", String.class));
      label5482:
      i = paramCursor.getColumnIndex("strSchoolSame");
      if (i != -1) {
        break label13828;
      }
      paramaukx.a(new NoColumnError("strSchoolSame", String.class));
      i = paramCursor.getColumnIndex("lCardShowNum");
      if (i != -1) {
        break label13843;
      }
      paramaukx.a(new NoColumnError("lCardShowNum", Long.TYPE));
      i = paramCursor.getColumnIndex("bSingle");
      if (i != -1) {
        break label13858;
      }
      paramaukx.a(new NoColumnError("bSingle", Byte.TYPE));
      i = paramCursor.getColumnIndex("lVisitCount");
      if (i != -1) {
        break label13874;
      }
      paramaukx.a(new NoColumnError("lVisitCount", Long.TYPE));
      label5622:
      i = paramCursor.getColumnIndex("lVoteCount");
      if (i != -1) {
        break label13889;
      }
      paramaukx.a(new NoColumnError("lVoteCount", Long.TYPE));
      i = paramCursor.getColumnIndex("tagInfosByte");
      if (i != -1) {
        break label13904;
      }
      paramaukx.a(new NoColumnError("tagInfosByte", [B.class));
      i = paramCursor.getColumnIndex("eUserIdentityType");
      if (i != -1) {
        break label13919;
      }
      paramaukx.a(new NoColumnError("eUserIdentityType", Byte.TYPE));
      i = paramCursor.getColumnIndex("vBackground");
      if (i != -1) {
        break label13935;
      }
      paramaukx.a(new NoColumnError("vBackground", [B.class));
      i = paramCursor.getColumnIndex("labelInfoBytes");
      if (i != -1) {
        break label13950;
      }
      paramaukx.a(new NoColumnError("labelInfoBytes", [B.class));
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label13965;
      }
      paramaukx.a(new NoColumnError("age", Byte.TYPE));
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label13981;
      }
      paramaukx.a(new NoColumnError("constellation", Integer.TYPE));
      label5867:
      i = paramCursor.getColumnIndex("pyFaceUrl");
      if (i != -1) {
        break label13996;
      }
      paramaukx.a(new NoColumnError("pyFaceUrl", String.class));
      i = paramCursor.getColumnIndex("location");
      if (i != -1) {
        break label14011;
      }
      paramaukx.a(new NoColumnError("location", String.class));
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label14026;
      }
      paramaukx.a(new NoColumnError("bVoted", Byte.TYPE));
      i = paramCursor.getColumnIndex("bFavorited");
      if (i != -1) {
        break label14042;
      }
      paramaukx.a(new NoColumnError("bFavorited", Byte.TYPE));
      label6007:
      i = paramCursor.getColumnIndex("iVoteIncrement");
      if (i != -1) {
        break label14058;
      }
      paramaukx.a(new NoColumnError("iVoteIncrement", Integer.TYPE));
      i = paramCursor.getColumnIndex("strJoinHexAlbumFileKey");
      if (i != -1) {
        break label14073;
      }
      paramaukx.a(new NoColumnError("strJoinHexAlbumFileKey", String.class));
      i = paramCursor.getColumnIndex("iFaceNum");
      if (i != -1) {
        break label14088;
      }
      paramaukx.a(new NoColumnError("iFaceNum", Integer.TYPE));
      i = paramCursor.getColumnIndex("cSqqLevel");
      if (i != -1) {
        break label14103;
      }
      paramaukx.a(new NoColumnError("cSqqLevel", Byte.TYPE));
      i = paramCursor.getColumnIndex("iQQLevel");
      if (i != -1) {
        break label14119;
      }
      paramaukx.a(new NoColumnError("iQQLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("uCurMulType");
      if (i != -1) {
        break label14134;
      }
      paramaukx.a(new NoColumnError("uCurMulType", Long.TYPE));
      i = paramCursor.getColumnIndex("strProvince");
      if (i != -1) {
        break label14149;
      }
      paramaukx.a(new NoColumnError("strProvince", String.class));
      label6252:
      i = paramCursor.getColumnIndex("strCity");
      if (i != -1) {
        break label14164;
      }
      paramaukx.a(new NoColumnError("strCity", String.class));
      i = paramCursor.getColumnIndex("strCountry");
      if (i != -1) {
        break label14179;
      }
      paramaukx.a(new NoColumnError("strCountry", String.class));
      i = paramCursor.getColumnIndex("lBirthday");
      if (i != -1) {
        break label14194;
      }
      paramaukx.a(new NoColumnError("lBirthday", Long.TYPE));
      i = paramCursor.getColumnIndex("strLocationCodes");
      if (i != -1) {
        break label14209;
      }
      paramaukx.a(new NoColumnError("strLocationCodes", String.class));
      label6392:
      i = paramCursor.getColumnIndex("strLocationDesc");
      if (i != -1) {
        break label14224;
      }
      paramaukx.a(new NoColumnError("strLocationDesc", String.class));
      i = paramCursor.getColumnIndex("strHometownCodes");
      if (i != -1) {
        break label14239;
      }
      paramaukx.a(new NoColumnError("strHometownCodes", String.class));
      i = paramCursor.getColumnIndex("strHometownDesc");
      if (i != -1) {
        break label14254;
      }
      paramaukx.a(new NoColumnError("strHometownDesc", String.class));
      i = paramCursor.getColumnIndex("strEmail");
      if (i != -1) {
        break label14269;
      }
      paramaukx.a(new NoColumnError("strEmail", String.class));
      i = paramCursor.getColumnIndex("strPersonalNote");
      if (i != -1) {
        break label14284;
      }
      paramaukx.a(new NoColumnError("strPersonalNote", String.class));
      i = paramCursor.getColumnIndex("iProfession");
      if (i != -1) {
        break label14299;
      }
      paramaukx.a(new NoColumnError("iProfession", Integer.TYPE));
      i = paramCursor.getColumnIndex("bindPhoneInfo");
      if (i != -1) {
        break label14314;
      }
      paramaukx.a(new NoColumnError("bindPhoneInfo", String.class));
      label6637:
      i = paramCursor.getColumnIndex("bCardInfo");
      if (i != -1) {
        break label14329;
      }
      paramaukx.a(new NoColumnError("bCardInfo", [B.class));
      i = paramCursor.getColumnIndex("strTroopName");
      if (i != -1) {
        break label14344;
      }
      paramaukx.a(new NoColumnError("strTroopName", String.class));
      i = paramCursor.getColumnIndex("strTroopNick");
      if (i != -1) {
        break label14359;
      }
      paramaukx.a(new NoColumnError("strTroopNick", String.class));
      i = paramCursor.getColumnIndex("strMobile");
      if (i != -1) {
        break label14374;
      }
      paramaukx.a(new NoColumnError("strMobile", String.class));
      label6783:
      i = paramCursor.getColumnIndex("strContactName");
      if (i != -1) {
        break label14389;
      }
      paramaukx.a(new NoColumnError("strContactName", String.class));
      i = paramCursor.getColumnIndex("ulShowControl");
      if (i != -1) {
        break label14404;
      }
      paramaukx.a(new NoColumnError("ulShowControl", Integer.TYPE));
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label14419;
      }
      paramaukx.a(new NoColumnError("feedPreviewTime", Long.TYPE));
      label6894:
      i = paramCursor.getColumnIndex("strQzoneFeedsDesc");
      if (i != -1) {
        break label14434;
      }
      paramaukx.a(new NoColumnError("strQzoneFeedsDesc", String.class));
      i = paramCursor.getColumnIndex("StrPresentDesc");
      if (i != -1) {
        break label14449;
      }
      paramaukx.a(new NoColumnError("StrPresentDesc", String.class));
      i = paramCursor.getColumnIndex("strSpaceName");
      if (i != -1) {
        break label14464;
      }
      paramaukx.a(new NoColumnError("strSpaceName", String.class));
      i = paramCursor.getColumnIndex("strQzoneHeader");
      if (i != -1) {
        break label14479;
      }
      paramaukx.a(new NoColumnError("strQzoneHeader", String.class));
      i = paramCursor.getColumnIndex("vQzonePhotos");
      if (i != -1) {
        break label14494;
      }
      paramaukx.a(new NoColumnError("vQzonePhotos", [B.class));
      i = paramCursor.getColumnIndex("vQzoneCoverInfo");
      if (i != -1) {
        break label14509;
      }
      paramaukx.a(new NoColumnError("vQzoneCoverInfo", [B.class));
      i = paramCursor.getColumnIndex("enlargeQzonePic");
      if (i != -1) {
        break label14524;
      }
      paramaukx.a(new NoColumnError("enlargeQzonePic", Integer.TYPE));
      label7153:
      i = paramCursor.getColumnIndex("showPublishButton");
      if (i != -1) {
        break label14539;
      }
      paramaukx.a(new NoColumnError("showPublishButton", Boolean.TYPE));
      i = paramCursor.getColumnIndex("strStatus");
      if (i != -1) {
        break label14566;
      }
      paramaukx.a(new NoColumnError("strStatus", String.class));
      i = paramCursor.getColumnIndex("strAutoRemark");
      if (i != -1) {
        break label14581;
      }
      paramaukx.a(new NoColumnError("strAutoRemark", String.class));
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label14596;
      }
      paramaukx.a(new NoColumnError("vSeed", [B.class));
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label14611;
      }
      paramaukx.a(new NoColumnError("vCookies", [B.class));
      i = paramCursor.getColumnIndex("hasFakeData");
      if (i != -1) {
        break label14626;
      }
      paramaukx.a(new NoColumnError("hasFakeData", Boolean.TYPE));
      i = paramCursor.getColumnIndex("bQQVipOpen");
      if (i != -1) {
        break label14653;
      }
      paramaukx.a(new NoColumnError("bQQVipOpen", Byte.TYPE));
      label7412:
      i = paramCursor.getColumnIndex("iQQVipType");
      if (i != -1) {
        break label14669;
      }
      paramaukx.a(new NoColumnError("iQQVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iQQVipLevel");
      if (i != -1) {
        break label14684;
      }
      paramaukx.a(new NoColumnError("iQQVipLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("nameplateVipType");
      if (i != -1) {
        break label14699;
      }
      paramaukx.a(new NoColumnError("nameplateVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("grayNameplateFlag");
      if (i != -1) {
        break label14714;
      }
      paramaukx.a(new NoColumnError("grayNameplateFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("bSuperVipOpen");
      if (i != -1) {
        break label14729;
      }
      paramaukx.a(new NoColumnError("bSuperVipOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iSuperVipType");
      if (i != -1) {
        break label14745;
      }
      paramaukx.a(new NoColumnError("iSuperVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iSuperVipLevel");
      if (i != -1) {
        break label14760;
      }
      paramaukx.a(new NoColumnError("iSuperVipLevel", Integer.TYPE));
      label7671:
      i = paramCursor.getColumnIndex("bSuperQQOpen");
      if (i != -1) {
        break label14775;
      }
      paramaukx.a(new NoColumnError("bSuperQQOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iSuperQQType");
      if (i != -1) {
        break label14791;
      }
      paramaukx.a(new NoColumnError("iSuperQQType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iSuperQQLevel");
      if (i != -1) {
        break label14806;
      }
      paramaukx.a(new NoColumnError("iSuperQQLevel", Integer.TYPE));
      label7782:
      i = paramCursor.getColumnIndex("bHollywoodVipOpen");
      if (i != -1) {
        break label14821;
      }
      paramaukx.a(new NoColumnError("bHollywoodVipOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iHollywoodVipType");
      if (i != -1) {
        break label14837;
      }
      paramaukx.a(new NoColumnError("iHollywoodVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iHollywoodVipLevel");
      if (i != -1) {
        break label14852;
      }
      paramaukx.a(new NoColumnError("iHollywoodVipLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("strShowName");
      if (i != -1) {
        break label14867;
      }
      paramaukx.a(new NoColumnError("strShowName", String.class));
      label7930:
      i = paramCursor.getColumnIndex("strVoiceFilekey");
      if (i != -1) {
        break label14882;
      }
      paramaukx.a(new NoColumnError("strVoiceFilekey", String.class));
      i = paramCursor.getColumnIndex("shDuration");
      if (i != -1) {
        break label14897;
      }
      paramaukx.a(new NoColumnError("shDuration", Short.TYPE));
      i = paramCursor.getColumnIndex("bRead");
      if (i != -1) {
        break label14912;
      }
      paramaukx.a(new NoColumnError("bRead", Byte.TYPE));
      label8041:
      i = paramCursor.getColumnIndex("strUrl");
      if (i != -1) {
        break label14928;
      }
      paramaukx.a(new NoColumnError("strUrl", String.class));
      i = paramCursor.getColumnIndex("vRichSign");
      if (i != -1) {
        break label14943;
      }
      paramaukx.a(new NoColumnError("vRichSign", [B.class));
      i = paramCursor.getColumnIndex("lSignModifyTime");
      if (i != -1) {
        break label14958;
      }
      paramaukx.a(new NoColumnError("lSignModifyTime", Long.TYPE));
      i = paramCursor.getColumnIndex("vLongNickTopicInfo");
      if (i != -1) {
        break label14973;
      }
      paramaukx.a(new NoColumnError("vLongNickTopicInfo", [B.class));
      label8189:
      i = paramCursor.getColumnIndex("nLastGameFlag");
      if (i != -1) {
        break label14988;
      }
      paramaukx.a(new NoColumnError("nLastGameFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("strGameLogoUrl_1");
      if (i != -1) {
        break label15003;
      }
      paramaukx.a(new NoColumnError("strGameLogoUrl_1", String.class));
      i = paramCursor.getColumnIndex("strGameLogoUrl_2");
      if (i != -1) {
        break label15018;
      }
      paramaukx.a(new NoColumnError("strGameLogoUrl_2", String.class));
      label8300:
      i = paramCursor.getColumnIndex("strGameLogoUrl_3");
      if (i != -1) {
        break label15033;
      }
      paramaukx.a(new NoColumnError("strGameLogoUrl_3", String.class));
      i = paramCursor.getColumnIndex("strGameLogoUrl_4");
      if (i != -1) {
        break label15048;
      }
      paramaukx.a(new NoColumnError("strGameLogoUrl_4", String.class));
      i = paramCursor.getColumnIndex("strGameLogoKey_1");
      if (i != -1) {
        break label15063;
      }
      paramaukx.a(new NoColumnError("strGameLogoKey_1", String.class));
      i = paramCursor.getColumnIndex("strGameLogoKey_2");
      if (i != -1) {
        break label15078;
      }
      paramaukx.a(new NoColumnError("strGameLogoKey_2", String.class));
      i = paramCursor.getColumnIndex("strGameLogoKey_3");
      if (i != -1) {
        break label15093;
      }
      paramaukx.a(new NoColumnError("strGameLogoKey_3", String.class));
      i = paramCursor.getColumnIndex("strGameLogoKey_4");
      if (i != -1) {
        break label15108;
      }
      paramaukx.a(new NoColumnError("strGameLogoKey_4", String.class));
      i = paramCursor.getColumnIndex("strGameName_1");
      if (i != -1) {
        break label15123;
      }
      paramaukx.a(new NoColumnError("strGameName_1", String.class));
      label8559:
      i = paramCursor.getColumnIndex("strGameName_2");
      if (i != -1) {
        break label15138;
      }
      paramaukx.a(new NoColumnError("strGameName_2", String.class));
      i = paramCursor.getColumnIndex("strGameName_3");
      if (i != -1) {
        break label15153;
      }
      paramaukx.a(new NoColumnError("strGameName_3", String.class));
      i = paramCursor.getColumnIndex("strGameName_4");
      if (i != -1) {
        break label15168;
      }
      paramaukx.a(new NoColumnError("strGameName_4", String.class));
      i = paramCursor.getColumnIndex("strGameAppid_1");
      if (i != -1) {
        break label15183;
      }
      paramaukx.a(new NoColumnError("strGameAppid_1", String.class));
      i = paramCursor.getColumnIndex("strGameAppid_2");
      if (i != -1) {
        break label15198;
      }
      paramaukx.a(new NoColumnError("strGameAppid_2", String.class));
      i = paramCursor.getColumnIndex("strGameAppid_3");
      if (i != -1) {
        break label15213;
      }
      paramaukx.a(new NoColumnError("strGameAppid_3", String.class));
      i = paramCursor.getColumnIndex("strGameAppid_4");
      if (i != -1) {
        break label15228;
      }
      paramaukx.a(new NoColumnError("strGameAppid_4", String.class));
      label8818:
      i = paramCursor.getColumnIndex("strProfileUrl");
      if (i != -1) {
        break label15243;
      }
      paramaukx.a(new NoColumnError("strProfileUrl", String.class));
      i = paramCursor.getColumnIndex("nStarFansFlag");
      if (i != -1) {
        break label15258;
      }
      paramaukx.a(new NoColumnError("nStarFansFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("strStarPicUrl_0");
      if (i != -1) {
        break label15273;
      }
      paramaukx.a(new NoColumnError("strStarPicUrl_0", String.class));
      i = paramCursor.getColumnIndex("strStarPicUrl_1");
      if (i != -1) {
        break label15288;
      }
      paramaukx.a(new NoColumnError("strStarPicUrl_1", String.class));
      i = paramCursor.getColumnIndex("strStarPicUrl_2");
      if (i != -1) {
        break label15303;
      }
      paramaukx.a(new NoColumnError("strStarPicUrl_2", String.class));
      i = paramCursor.getColumnIndex("strStarLvUrl_0");
      if (i != -1) {
        break label15318;
      }
      paramaukx.a(new NoColumnError("strStarLvUrl_0", String.class));
      i = paramCursor.getColumnIndex("strStarLvUrl_1");
      if (i != -1) {
        break label15333;
      }
      paramaukx.a(new NoColumnError("strStarLvUrl_1", String.class));
      label9077:
      i = paramCursor.getColumnIndex("strStarLvUrl_2");
      if (i != -1) {
        break label15348;
      }
      paramaukx.a(new NoColumnError("strStarLvUrl_2", String.class));
      i = paramCursor.getColumnIndex("strStarLogoUrl");
      if (i != -1) {
        break label15363;
      }
      paramaukx.a(new NoColumnError("strStarLogoUrl", String.class));
      i = paramCursor.getColumnIndex("starFansJumpUrl");
      if (i != -1) {
        break label15378;
      }
      paramaukx.a(new NoColumnError("starFansJumpUrl", String.class));
      i = paramCursor.getColumnIndex("lUserFlag");
      if (i != -1) {
        break label15393;
      }
      paramaukx.a(new NoColumnError("lUserFlag", Long.TYPE));
      i = paramCursor.getColumnIndex("lLoginDays");
      if (i != -1) {
        break label15408;
      }
      paramaukx.a(new NoColumnError("lLoginDays", Long.TYPE));
      i = paramCursor.getColumnIndex("strLoginDaysDesc");
      if (i != -1) {
        break label15423;
      }
      paramaukx.a(new NoColumnError("strLoginDaysDesc", String.class));
      i = paramCursor.getColumnIndex("lQQMasterLogindays");
      if (i != -1) {
        break label15438;
      }
      paramaukx.a(new NoColumnError("lQQMasterLogindays", Long.TYPE));
      label9336:
      i = paramCursor.getColumnIndex("iXManScene1DelayTime");
      if (i != -1) {
        break label15453;
      }
      paramaukx.a(new NoColumnError("iXManScene1DelayTime", Integer.TYPE));
      i = paramCursor.getColumnIndex("iXManScene2DelayTime");
      if (i != -1) {
        break label15468;
      }
      paramaukx.a(new NoColumnError("iXManScene2DelayTime", Integer.TYPE));
      i = paramCursor.getColumnIndex("allowPeopleSee");
      if (i != -1) {
        break label15483;
      }
      paramaukx.a(new NoColumnError("allowPeopleSee", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowCalInteractive");
      if (i != -1) {
        break label15510;
      }
      paramaukx.a(new NoColumnError("allowCalInteractive", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showOnlineFriends");
      if (i != -1) {
        break label15537;
      }
      paramaukx.a(new NoColumnError("showOnlineFriends", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowClick");
      if (i != -1) {
        break label15564;
      }
      paramaukx.a(new NoColumnError("allowClick", Boolean.TYPE));
      i = paramCursor.getColumnIndex("babyQSwitch");
      if (i != -1) {
        break label15591;
      }
      paramaukx.a(new NoColumnError("babyQSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showLightalk");
      if (i != -1) {
        break label15618;
      }
      paramaukx.a(new NoColumnError("showLightalk", Boolean.TYPE));
      i = paramCursor.getColumnIndex("lightalkNick");
      if (i != -1) {
        break label15645;
      }
      paramaukx.a(new NoColumnError("lightalkNick", String.class));
      i = paramCursor.getColumnIndex("lightalkId");
      if (i != -1) {
        break label15660;
      }
      paramaukx.a(new NoColumnError("lightalkId", String.class));
      label9706:
      i = paramCursor.getColumnIndex("isSuperRedDiamond");
      if (i != -1) {
        break label15675;
      }
      paramaukx.a(new NoColumnError("isSuperRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRedDiamond");
      if (i != -1) {
        break label15702;
      }
      paramaukx.a(new NoColumnError("isRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("redLevel");
      if (i != -1) {
        break label15729;
      }
      paramaukx.a(new NoColumnError("redLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("isSuperYellowDiamond");
      if (i != -1) {
        break label15744;
      }
      paramaukx.a(new NoColumnError("isSuperYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isYellowDiamond");
      if (i != -1) {
        break label15771;
      }
      paramaukx.a(new NoColumnError("isYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("yellowLevel");
      if (i != -1) {
        break label15798;
      }
      paramaukx.a(new NoColumnError("yellowLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("isSuperGreenDiamond");
      if (i != -1) {
        break label15813;
      }
      paramaukx.a(new NoColumnError("isSuperGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isGreenDiamond");
      if (i != -1) {
        break label15840;
      }
      paramaukx.a(new NoColumnError("isGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("greenLevel");
      if (i != -1) {
        break label15867;
      }
      paramaukx.a(new NoColumnError("greenLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("uAccelerateMultiple");
      if (i != -1) {
        break label15882;
      }
      paramaukx.a(new NoColumnError("uAccelerateMultiple", Long.TYPE));
      i = paramCursor.getColumnIndex("strRespMusicInfo");
      if (i != -1) {
        break label15897;
      }
      paramaukx.a(new NoColumnError("strRespMusicInfo", String.class));
      i = paramCursor.getColumnIndex("templateRet");
      if (i != -1) {
        break label15912;
      }
      paramaukx.a(new NoColumnError("templateRet", Integer.TYPE));
      i = paramCursor.getColumnIndex("lCurrentStyleId");
      if (i != -1) {
        break label15927;
      }
      paramaukx.a(new NoColumnError("lCurrentStyleId", Long.TYPE));
      i = paramCursor.getColumnIndex("lCurrentBgId");
      if (i != -1) {
        break label15942;
      }
      paramaukx.a(new NoColumnError("lCurrentBgId", Long.TYPE));
      label10224:
      i = paramCursor.getColumnIndex("backgroundUrl");
      if (i != -1) {
        break label15957;
      }
      paramaukx.a(new NoColumnError("backgroundUrl", String.class));
      i = paramCursor.getColumnIndex("backgroundColor");
      if (i != -1) {
        break label15972;
      }
      paramaukx.a(new NoColumnError("backgroundColor", Long.TYPE));
      i = paramCursor.getColumnIndex("dynamicCardFlag");
      if (i != -1) {
        break label15987;
      }
      paramaukx.a(new NoColumnError("dynamicCardFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("strZipUrl");
      if (i != -1) {
        break label16002;
      }
      paramaukx.a(new NoColumnError("strZipUrl", String.class));
      i = paramCursor.getColumnIndex("strActiveUrl");
      if (i != -1) {
        break label16017;
      }
      paramaukx.a(new NoColumnError("strActiveUrl", String.class));
      i = paramCursor.getColumnIndex("strDrawerCardUrl");
      if (i != -1) {
        break label16032;
      }
      paramaukx.a(new NoColumnError("strDrawerCardUrl", String.class));
      i = paramCursor.getColumnIndex("strWzryHeroUrl");
      if (i != -1) {
        break label16047;
      }
      paramaukx.a(new NoColumnError("strWzryHeroUrl", String.class));
      label10483:
      i = paramCursor.getColumnIndex("wzryHonorInfo");
      if (i != -1) {
        break label16062;
      }
      paramaukx.a(new NoColumnError("wzryHonorInfo", [B.class));
      i = paramCursor.getColumnIndex("strExtInfo");
      if (i != -1) {
        break label16077;
      }
      paramaukx.a(new NoColumnError("strExtInfo", String.class));
      i = paramCursor.getColumnIndex("strCurrentBgUrl");
      if (i != -1) {
        break label16092;
      }
      paramaukx.a(new NoColumnError("strCurrentBgUrl", String.class));
      i = paramCursor.getColumnIndex("bgType");
      if (i != -1) {
        break label16107;
      }
      paramaukx.a(new NoColumnError("bgType", [B.class));
      i = paramCursor.getColumnIndex("encId");
      if (i != -1) {
        break label16122;
      }
      paramaukx.a(new NoColumnError("encId", String.class));
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label16137;
      }
      paramaukx.a(new NoColumnError("busiEntry", String.class));
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label16152;
      }
      paramaukx.a(new NoColumnError("favoriteSource", Integer.TYPE));
      label10742:
      i = paramCursor.getColumnIndex("visibleMusicPendant");
      if (i != -1) {
        break label16167;
      }
      paramaukx.a(new NoColumnError("visibleMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("autoPlayMusicPendant");
      if (i != -1) {
        break label16194;
      }
      paramaukx.a(new NoColumnError("autoPlayMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showRedPointMusicPendant");
      if (i != -1) {
        break label16221;
      }
      paramaukx.a(new NoColumnError("showRedPointMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("privilegePromptStr");
      if (i != -1) {
        break label16248;
      }
      paramaukx.a(new NoColumnError("privilegePromptStr", String.class));
      i = paramCursor.getColumnIndex("privilegeJumpUrl");
      if (i != -1) {
        break label16263;
      }
      paramaukx.a(new NoColumnError("privilegeJumpUrl", String.class));
      i = paramCursor.getColumnIndex("vOpenPriv");
      if (i != -1) {
        break label16278;
      }
      paramaukx.a(new NoColumnError("vOpenPriv", [B.class));
      i = paramCursor.getColumnIndex("vClosePriv");
      if (i != -1) {
        break label16293;
      }
      paramaukx.a(new NoColumnError("vClosePriv", [B.class));
      label11001:
      i = paramCursor.getColumnIndex("presentDesc");
      if (i != -1) {
        break label16308;
      }
      paramaukx.a(new NoColumnError("presentDesc", String.class));
      i = paramCursor.getColumnIndex("presentCustourl");
      if (i != -1) {
        break label16323;
      }
      paramaukx.a(new NoColumnError("presentCustourl", String.class));
      i = paramCursor.getColumnIndex("presentSwitch");
      if (i != -1) {
        break label16338;
      }
      paramaukx.a(new NoColumnError("presentSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showPresent");
      if (i != -1) {
        break label16365;
      }
      paramaukx.a(new NoColumnError("showPresent", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showMusicBox");
      if (i != -1) {
        break label16392;
      }
      paramaukx.a(new NoColumnError("showMusicBox", Boolean.TYPE));
      i = paramCursor.getColumnIndex("addSrcName");
      if (i != -1) {
        break label16419;
      }
      paramaukx.a(new NoColumnError("addSrcName", String.class));
      i = paramCursor.getColumnIndex("addSrcId");
      if (i != -1) {
        break label16434;
      }
      paramaukx.a(new NoColumnError("addSrcId", Long.TYPE));
      label11260:
      i = paramCursor.getColumnIndex("addSubSrcId");
      if (i != -1) {
        break label16449;
      }
      paramaukx.a(new NoColumnError("addSubSrcId", Long.TYPE));
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label16464;
      }
      paramaukx.a(new NoColumnError("strVoteLimitedNotice", String.class));
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label16479;
      }
      paramaukx.a(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      label11371:
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label16494;
      }
      paramaukx.a(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      i = paramCursor.getColumnIndex("olympicTorch");
      if (i != -1) {
        break label16509;
      }
      paramaukx.a(new NoColumnError("olympicTorch", Byte.TYPE));
      i = paramCursor.getColumnIndex("mNowShowFlag");
      if (i != -1) {
        break label16525;
      }
      paramaukx.a(new NoColumnError("mNowShowFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("mNowShowIconUrl");
      if (i != -1) {
        break label16540;
      }
      paramaukx.a(new NoColumnError("mNowShowIconUrl", String.class));
      label11519:
      i = paramCursor.getColumnIndex("mNowShowJumpUrl");
      if (i != -1) {
        break label16555;
      }
      paramaukx.a(new NoColumnError("mNowShowJumpUrl", String.class));
      i = paramCursor.getColumnIndex("vCoverInfo");
      if (i != -1) {
        break label16570;
      }
      paramaukx.a(new NoColumnError("vCoverInfo", [B.class));
      i = paramCursor.getColumnIndex("videoHeadFlag");
      if (i != -1) {
        break label16585;
      }
      paramaukx.a(new NoColumnError("videoHeadFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("videoHeadUrl");
      if (i != -1) {
        break label16612;
      }
      paramaukx.a(new NoColumnError("videoHeadUrl", String.class));
      i = paramCursor.getColumnIndex("medalSwitchDisable");
      if (i != -1) {
        break label16627;
      }
      paramaukx.a(new NoColumnError("medalSwitchDisable", Boolean.TYPE));
      i = paramCursor.getColumnIndex("iMedalCount");
      if (i != -1) {
        break label16654;
      }
      paramaukx.a(new NoColumnError("iMedalCount", Integer.TYPE));
      i = paramCursor.getColumnIndex("iNewCount");
      if (i != -1) {
        break label16669;
      }
      paramaukx.a(new NoColumnError("iNewCount", Integer.TYPE));
      i = paramCursor.getColumnIndex("iUpgradeCount");
      if (i != -1) {
        break label16684;
      }
      paramaukx.a(new NoColumnError("iUpgradeCount", Integer.TYPE));
      i = paramCursor.getColumnIndex("strPromptParams");
      if (i != -1) {
        break label16699;
      }
      paramaukx.a(new NoColumnError("strPromptParams", String.class));
      i = paramCursor.getColumnIndex("hobbyEntry");
      if (i != -1) {
        break label16714;
      }
      paramaukx.a(new NoColumnError("hobbyEntry", String.class));
      label11889:
      i = paramCursor.getColumnIndex("lastPraiseInfoList");
      if (i != -1) {
        break label16729;
      }
      paramaukx.a(new NoColumnError("lastPraiseInfoList", [B.class));
      i = paramCursor.getColumnIndex("tempChatSig");
      if (i != -1) {
        break label16744;
      }
      paramaukx.a(new NoColumnError("tempChatSig", [B.class));
      i = paramCursor.getColumnIndex("namePlateOfKingGameId");
      if (i != -1) {
        break label16759;
      }
      paramaukx.a(new NoColumnError("namePlateOfKingGameId", Long.TYPE));
      i = paramCursor.getColumnIndex("namePlateOfKingLoginTime");
      if (i != -1) {
        break label16774;
      }
      paramaukx.a(new NoColumnError("namePlateOfKingLoginTime", Long.TYPE));
      i = paramCursor.getColumnIndex("namePlateOfKingDan");
      if (i != -1) {
        break label16789;
      }
      paramaukx.a(new NoColumnError("namePlateOfKingDan", Integer.TYPE));
      i = paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch");
      if (i != -1) {
        break label16804;
      }
      paramaukx.a(new NoColumnError("namePlateOfKingDanDisplatSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("vPersonalityLabelV2");
      if (i != -1) {
        break label16831;
      }
      paramaukx.a(new NoColumnError("vPersonalityLabelV2", [B.class));
      label12148:
      i = paramCursor.getColumnIndex("cardType");
      if (i != -1) {
        break label16846;
      }
      paramaukx.a(new NoColumnError("cardType", Integer.TYPE));
      i = paramCursor.getColumnIndex("diyText");
      if (i != -1) {
        break label16861;
      }
      paramaukx.a(new NoColumnError("diyText", String.class));
      i = paramCursor.getColumnIndex("diyTextFontId");
      if (i != -1) {
        break label16876;
      }
      paramaukx.a(new NoColumnError("diyTextFontId", Integer.TYPE));
      i = paramCursor.getColumnIndex("diyTextWidth");
      if (i != -1) {
        break label16891;
      }
      paramaukx.a(new NoColumnError("diyTextWidth", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextHeight");
      if (i != -1) {
        break label16906;
      }
      paramaukx.a(new NoColumnError("diyTextHeight", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextLocX");
      if (i != -1) {
        break label16921;
      }
      paramaukx.a(new NoColumnError("diyTextLocX", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextLocY");
      if (i != -1) {
        break label16936;
      }
      paramaukx.a(new NoColumnError("diyTextLocY", Float.TYPE));
      label12407:
      i = paramCursor.getColumnIndex("diyTextDegree");
      if (i != -1) {
        break label16951;
      }
      paramaukx.a(new NoColumnError("diyTextDegree", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextScale");
      if (i != -1) {
        break label16966;
      }
      paramaukx.a(new NoColumnError("diyTextScale", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextTransparency");
      if (i != -1) {
        break label16981;
      }
      paramaukx.a(new NoColumnError("diyTextTransparency", Float.TYPE));
      label12518:
      i = paramCursor.getColumnIndex("diyDefaultText");
      if (i != -1) {
        break label16996;
      }
      paramaukx.a(new NoColumnError("diyDefaultText", String.class));
      i = paramCursor.getColumnIndex("popularity");
      if (i != -1) {
        break label17011;
      }
      paramaukx.a(new NoColumnError("popularity", Integer.TYPE));
      i = paramCursor.getColumnIndex("declaration");
      if (i != -1) {
        break label17026;
      }
      paramaukx.a(new NoColumnError("declaration", String.class));
      i = paramCursor.getColumnIndex("voiceUrl");
      if (i != -1) {
        break label17041;
      }
      paramaukx.a(new NoColumnError("voiceUrl", String.class));
      label12666:
      i = paramCursor.getColumnIndex("isShowCard");
      if (i != -1) {
        break label17056;
      }
      paramaukx.a(new NoColumnError("isShowCard", Boolean.TYPE));
      i = paramCursor.getColumnIndex("updateTime");
      if (i != -1) {
        break label17083;
      }
      paramaukx.a(new NoColumnError("updateTime", Long.TYPE));
      i = paramCursor.getColumnIndex("extendFriendFlag");
      if (i != -1) {
        break label17098;
      }
      paramaukx.a(new NoColumnError("extendFriendFlag", Integer.TYPE));
      label12777:
      i = paramCursor.getColumnIndex("extendFriendVoiceDuration");
      if (i != -1) {
        break label17113;
      }
      paramaukx.a(new NoColumnError("extendFriendVoiceDuration", Integer.TYPE));
      i = paramCursor.getColumnIndex("extendFriendEntryContact");
      if (i != -1) {
        break label17128;
      }
      paramaukx.a(new NoColumnError("extendFriendEntryContact", Short.TYPE));
      i = paramCursor.getColumnIndex("extendFriendEntryAddFriend");
      if (i != -1) {
        break label17143;
      }
      paramaukx.a(new NoColumnError("extendFriendEntryAddFriend", Short.TYPE));
      i = paramCursor.getColumnIndex("extendFriendQuestion");
      if (i != -1) {
        break label17158;
      }
      paramaukx.a(new NoColumnError("extendFriendQuestion", Short.TYPE));
      label12925:
      i = paramCursor.getColumnIndex("isShowMiniPlaying");
      if (i != -1) {
        break label17173;
      }
      paramaukx.a(new NoColumnError("isShowMiniPlaying", Boolean.TYPE));
      i = paramCursor.getColumnIndex("tabJumpUrl");
      if (i != -1) {
        break label17200;
      }
      paramaukx.a(new NoColumnError("tabJumpUrl", String.class));
      i = paramCursor.getColumnIndex("guestJumpUrl");
      if (i != -1) {
        break label17215;
      }
      paramaukx.a(new NoColumnError("guestJumpUrl", String.class));
      label13036:
      i = paramCursor.getColumnIndex("guestAppTotal");
      if (i != -1) {
        break label17230;
      }
      paramaukx.a(new NoColumnError("guestAppTotal", Integer.TYPE));
      i = paramCursor.getColumnIndex("defaultCardId");
      if (i != -1) {
        break label17245;
      }
      paramaukx.a(new NoColumnError("defaultCardId", Integer.TYPE));
      i = paramCursor.getColumnIndex("strangerVoteOpen");
      if (i != -1) {
        break label17260;
      }
      paramaukx.a(new NoColumnError("strangerVoteOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("lSuperVipTemplateId");
      if (i != -1) {
        break label17287;
      }
      paramaukx.a(new NoColumnError("lSuperVipTemplateId", Long.TYPE));
      i = paramCursor.getColumnIndex("bBigClubVipOpen");
      if (i != -1) {
        break label17302;
      }
      paramaukx.a(new NoColumnError("bBigClubVipOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iBigClubVipType");
      if (i != -1) {
        break label17318;
      }
      paramaukx.a(new NoColumnError("iBigClubVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iBigClubVipLevel");
      if (i != -1) {
        break label17333;
      }
      paramaukx.a(new NoColumnError("iBigClubVipLevel", Integer.TYPE));
      label13295:
      i = paramCursor.getColumnIndex("lBigClubTemplateId");
      if (i != -1) {
        break label17348;
      }
      paramaukx.a(new NoColumnError("lBigClubTemplateId", Long.TYPE));
      i = paramCursor.getColumnIndex("diyComplicatedInfo");
      if (i != -1) {
        break label17363;
      }
      paramaukx.a(new NoColumnError("diyComplicatedInfo", String.class));
      i = paramCursor.getColumnIndex("cardId");
      if (i != -1) {
        break label17378;
      }
      paramaukx.a(new NoColumnError("cardId", Long.TYPE));
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
      paramaukx.a(new NoColumnError("strangerInviteMeGroupOpen", Boolean.TYPE));
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
      paramaukx.a(new NoColumnError("isPrettyGroupOwner", Boolean.TYPE));
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
      paramaukx.a(new NoColumnError("isHidePrettyGroutIdentity", Boolean.TYPE));
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
      paramaukx.a(new NoColumnError("mQQLevelType", Integer.TYPE));
      label13184:
      return paramaukm;
      paramaukm.uin = paramCursor.getString(i);
      break;
      label13571:
      paramaukm.strNick = paramCursor.getString(i);
      break label4922;
      label13586:
      paramaukm.shGender = paramCursor.getShort(i);
      break label4957;
      label13601:
      paramaukm.shAge = paramCursor.getShort(i);
      break label4992;
      label13616:
      paramaukm.nFaceID = paramCursor.getInt(i);
      break label5027;
      label13631:
      paramaukm.strCertificationInfo = paramCursor.getString(i);
      break label5062;
      label13646:
      paramaukm.shType = paramCursor.getShort(i);
      break label5097;
      label13661:
      paramaukm.vContent = paramCursor.getBlob(i);
      break label5132;
      label13676:
      paramaukm.strSign = paramCursor.getString(i);
      break label5167;
      label13691:
      paramaukm.strCompany = paramCursor.getString(i);
      break label5202;
      label13706:
      paramaukm.strSchool = paramCursor.getString(i);
      break label5237;
      label13721:
      paramaukm.uFaceTimeStamp = paramCursor.getInt(i);
      break label5272;
      label13736:
      paramaukm.vQQFaceID = paramCursor.getBlob(i);
      break label5307;
      label13751:
      paramaukm.strReMark = paramCursor.getString(i);
      break label5342;
      label13766:
      paramaukm.bWeiboInfo = ((byte)paramCursor.getShort(i));
      break label5377;
      label13782:
      paramaukm.bQzoneInfo = ((byte)paramCursor.getShort(i));
      break label5412;
      label13798:
      paramaukm.nSameFriendsNum = paramCursor.getInt(i);
      break label5447;
      label13813:
      paramaukm.strCompanySame = paramCursor.getString(i);
      break label5482;
      label13828:
      paramaukm.strSchoolSame = paramCursor.getString(i);
      break label5517;
      label13843:
      paramaukm.lCardShowNum = paramCursor.getLong(i);
      break label5552;
      label13858:
      paramaukm.bSingle = ((byte)paramCursor.getShort(i));
      break label5587;
      label13874:
      paramaukm.lVisitCount = paramCursor.getLong(i);
      break label5622;
      label13889:
      paramaukm.lVoteCount = paramCursor.getLong(i);
      break label5657;
      label13904:
      paramaukm.tagInfosByte = paramCursor.getBlob(i);
      break label5692;
      label13919:
      paramaukm.eUserIdentityType = ((byte)paramCursor.getShort(i));
      break label5727;
      label13935:
      paramaukm.vBackground = paramCursor.getBlob(i);
      break label5762;
      label13950:
      paramaukm.labelInfoBytes = paramCursor.getBlob(i);
      break label5797;
      label13965:
      paramaukm.age = ((byte)paramCursor.getShort(i));
      break label5832;
      label13981:
      paramaukm.constellation = paramCursor.getInt(i);
      break label5867;
      label13996:
      paramaukm.pyFaceUrl = paramCursor.getString(i);
      break label5902;
      label14011:
      paramaukm.location = paramCursor.getString(i);
      break label5937;
      label14026:
      paramaukm.bVoted = ((byte)paramCursor.getShort(i));
      break label5972;
      label14042:
      paramaukm.bFavorited = ((byte)paramCursor.getShort(i));
      break label6007;
      label14058:
      paramaukm.iVoteIncrement = paramCursor.getInt(i);
      break label6042;
      label14073:
      paramaukm.strJoinHexAlbumFileKey = paramCursor.getString(i);
      break label6077;
      label14088:
      paramaukm.iFaceNum = paramCursor.getInt(i);
      break label6112;
      label14103:
      paramaukm.cSqqLevel = ((byte)paramCursor.getShort(i));
      break label6147;
      label14119:
      paramaukm.iQQLevel = paramCursor.getInt(i);
      break label6182;
      label14134:
      paramaukm.uCurMulType = paramCursor.getLong(i);
      break label6217;
      label14149:
      paramaukm.strProvince = paramCursor.getString(i);
      break label6252;
      label14164:
      paramaukm.strCity = paramCursor.getString(i);
      break label6287;
      label14179:
      paramaukm.strCountry = paramCursor.getString(i);
      break label6322;
      label14194:
      paramaukm.lBirthday = paramCursor.getLong(i);
      break label6357;
      label14209:
      paramaukm.strLocationCodes = paramCursor.getString(i);
      break label6392;
      label14224:
      paramaukm.strLocationDesc = paramCursor.getString(i);
      break label6427;
      label14239:
      paramaukm.strHometownCodes = paramCursor.getString(i);
      break label6462;
      label14254:
      paramaukm.strHometownDesc = paramCursor.getString(i);
      break label6497;
      label14269:
      paramaukm.strEmail = paramCursor.getString(i);
      break label6532;
      label14284:
      paramaukm.strPersonalNote = paramCursor.getString(i);
      break label6567;
      label14299:
      paramaukm.iProfession = paramCursor.getInt(i);
      break label6602;
      label14314:
      paramaukm.bindPhoneInfo = paramCursor.getString(i);
      break label6637;
      label14329:
      paramaukm.bCardInfo = paramCursor.getBlob(i);
      break label6672;
      label14344:
      paramaukm.strTroopName = paramCursor.getString(i);
      break label6709;
      label14359:
      paramaukm.strTroopNick = paramCursor.getString(i);
      break label6746;
      label14374:
      paramaukm.strMobile = paramCursor.getString(i);
      break label6783;
      label14389:
      paramaukm.strContactName = paramCursor.getString(i);
      break label6820;
      label14404:
      paramaukm.ulShowControl = paramCursor.getInt(i);
      break label6857;
      label14419:
      paramaukm.feedPreviewTime = paramCursor.getLong(i);
      break label6894;
      label14434:
      paramaukm.strQzoneFeedsDesc = paramCursor.getString(i);
      break label6931;
      label14449:
      paramaukm.StrPresentDesc = paramCursor.getString(i);
      break label6968;
      label14464:
      paramaukm.strSpaceName = paramCursor.getString(i);
      break label7005;
      label14479:
      paramaukm.strQzoneHeader = paramCursor.getString(i);
      break label7042;
      label14494:
      paramaukm.vQzonePhotos = paramCursor.getBlob(i);
      break label7079;
      label14509:
      paramaukm.vQzoneCoverInfo = paramCursor.getBlob(i);
      break label7116;
      label14524:
      paramaukm.enlargeQzonePic = paramCursor.getInt(i);
      break label7153;
      label14539:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.showPublishButton = paramBoolean;
        break;
      }
      label14566:
      paramaukm.strStatus = paramCursor.getString(i);
      break label7227;
      label14581:
      paramaukm.strAutoRemark = paramCursor.getString(i);
      break label7264;
      label14596:
      paramaukm.vSeed = paramCursor.getBlob(i);
      break label7301;
      label14611:
      paramaukm.vCookies = paramCursor.getBlob(i);
      break label7338;
      label14626:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.hasFakeData = paramBoolean;
        break;
      }
      label14653:
      paramaukm.bQQVipOpen = ((byte)paramCursor.getShort(i));
      break label7412;
      label14669:
      paramaukm.iQQVipType = paramCursor.getInt(i);
      break label7449;
      label14684:
      paramaukm.iQQVipLevel = paramCursor.getInt(i);
      break label7486;
      label14699:
      paramaukm.nameplateVipType = paramCursor.getInt(i);
      break label7523;
      label14714:
      paramaukm.grayNameplateFlag = paramCursor.getInt(i);
      break label7560;
      label14729:
      paramaukm.bSuperVipOpen = ((byte)paramCursor.getShort(i));
      break label7597;
      label14745:
      paramaukm.iSuperVipType = paramCursor.getInt(i);
      break label7634;
      label14760:
      paramaukm.iSuperVipLevel = paramCursor.getInt(i);
      break label7671;
      label14775:
      paramaukm.bSuperQQOpen = ((byte)paramCursor.getShort(i));
      break label7708;
      label14791:
      paramaukm.iSuperQQType = paramCursor.getInt(i);
      break label7745;
      label14806:
      paramaukm.iSuperQQLevel = paramCursor.getInt(i);
      break label7782;
      label14821:
      paramaukm.bHollywoodVipOpen = ((byte)paramCursor.getShort(i));
      break label7819;
      label14837:
      paramaukm.iHollywoodVipType = paramCursor.getInt(i);
      break label7856;
      label14852:
      paramaukm.iHollywoodVipLevel = paramCursor.getInt(i);
      break label7893;
      label14867:
      paramaukm.strShowName = paramCursor.getString(i);
      break label7930;
      label14882:
      paramaukm.strVoiceFilekey = paramCursor.getString(i);
      break label7967;
      label14897:
      paramaukm.shDuration = paramCursor.getShort(i);
      break label8004;
      label14912:
      paramaukm.bRead = ((byte)paramCursor.getShort(i));
      break label8041;
      label14928:
      paramaukm.strUrl = paramCursor.getString(i);
      break label8078;
      label14943:
      paramaukm.vRichSign = paramCursor.getBlob(i);
      break label8115;
      label14958:
      paramaukm.lSignModifyTime = paramCursor.getLong(i);
      break label8152;
      label14973:
      paramaukm.vLongNickTopicInfo = paramCursor.getBlob(i);
      break label8189;
      label14988:
      paramaukm.nLastGameFlag = paramCursor.getInt(i);
      break label8226;
      label15003:
      paramaukm.strGameLogoUrl_1 = paramCursor.getString(i);
      break label8263;
      label15018:
      paramaukm.strGameLogoUrl_2 = paramCursor.getString(i);
      break label8300;
      label15033:
      paramaukm.strGameLogoUrl_3 = paramCursor.getString(i);
      break label8337;
      label15048:
      paramaukm.strGameLogoUrl_4 = paramCursor.getString(i);
      break label8374;
      label15063:
      paramaukm.strGameLogoKey_1 = paramCursor.getString(i);
      break label8411;
      label15078:
      paramaukm.strGameLogoKey_2 = paramCursor.getString(i);
      break label8448;
      label15093:
      paramaukm.strGameLogoKey_3 = paramCursor.getString(i);
      break label8485;
      label15108:
      paramaukm.strGameLogoKey_4 = paramCursor.getString(i);
      break label8522;
      label15123:
      paramaukm.strGameName_1 = paramCursor.getString(i);
      break label8559;
      label15138:
      paramaukm.strGameName_2 = paramCursor.getString(i);
      break label8596;
      label15153:
      paramaukm.strGameName_3 = paramCursor.getString(i);
      break label8633;
      label15168:
      paramaukm.strGameName_4 = paramCursor.getString(i);
      break label8670;
      label15183:
      paramaukm.strGameAppid_1 = paramCursor.getString(i);
      break label8707;
      label15198:
      paramaukm.strGameAppid_2 = paramCursor.getString(i);
      break label8744;
      label15213:
      paramaukm.strGameAppid_3 = paramCursor.getString(i);
      break label8781;
      label15228:
      paramaukm.strGameAppid_4 = paramCursor.getString(i);
      break label8818;
      label15243:
      paramaukm.strProfileUrl = paramCursor.getString(i);
      break label8855;
      label15258:
      paramaukm.nStarFansFlag = paramCursor.getInt(i);
      break label8892;
      label15273:
      paramaukm.strStarPicUrl_0 = paramCursor.getString(i);
      break label8929;
      label15288:
      paramaukm.strStarPicUrl_1 = paramCursor.getString(i);
      break label8966;
      label15303:
      paramaukm.strStarPicUrl_2 = paramCursor.getString(i);
      break label9003;
      label15318:
      paramaukm.strStarLvUrl_0 = paramCursor.getString(i);
      break label9040;
      label15333:
      paramaukm.strStarLvUrl_1 = paramCursor.getString(i);
      break label9077;
      label15348:
      paramaukm.strStarLvUrl_2 = paramCursor.getString(i);
      break label9114;
      label15363:
      paramaukm.strStarLogoUrl = paramCursor.getString(i);
      break label9151;
      label15378:
      paramaukm.starFansJumpUrl = paramCursor.getString(i);
      break label9188;
      label15393:
      paramaukm.lUserFlag = paramCursor.getLong(i);
      break label9225;
      label15408:
      paramaukm.lLoginDays = paramCursor.getLong(i);
      break label9262;
      label15423:
      paramaukm.strLoginDaysDesc = paramCursor.getString(i);
      break label9299;
      label15438:
      paramaukm.lQQMasterLogindays = paramCursor.getLong(i);
      break label9336;
      label15453:
      paramaukm.iXManScene1DelayTime = paramCursor.getInt(i);
      break label9373;
      label15468:
      paramaukm.iXManScene2DelayTime = paramCursor.getInt(i);
      break label9410;
      label15483:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.allowPeopleSee = paramBoolean;
        break;
      }
      label15510:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.allowCalInteractive = paramBoolean;
        break;
      }
      label15537:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.showOnlineFriends = paramBoolean;
        break;
      }
      label15564:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.allowClick = paramBoolean;
        break;
      }
      label15591:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.babyQSwitch = paramBoolean;
        break;
      }
      label15618:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.showLightalk = paramBoolean;
        break;
      }
      label15645:
      paramaukm.lightalkNick = paramCursor.getString(i);
      break label9669;
      label15660:
      paramaukm.lightalkId = paramCursor.getString(i);
      break label9706;
      label15675:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isSuperRedDiamond = paramBoolean;
        break;
      }
      label15702:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isRedDiamond = paramBoolean;
        break;
      }
      label15729:
      paramaukm.redLevel = paramCursor.getInt(i);
      break label9817;
      label15744:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isSuperYellowDiamond = paramBoolean;
        break;
      }
      label15771:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isYellowDiamond = paramBoolean;
        break;
      }
      label15798:
      paramaukm.yellowLevel = paramCursor.getInt(i);
      break label9928;
      label15813:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isSuperGreenDiamond = paramBoolean;
        break;
      }
      label15840:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isGreenDiamond = paramBoolean;
        break;
      }
      label15867:
      paramaukm.greenLevel = paramCursor.getInt(i);
      break label10039;
      label15882:
      paramaukm.uAccelerateMultiple = paramCursor.getLong(i);
      break label10076;
      label15897:
      paramaukm.strRespMusicInfo = paramCursor.getString(i);
      break label10113;
      label15912:
      paramaukm.templateRet = paramCursor.getInt(i);
      break label10150;
      label15927:
      paramaukm.lCurrentStyleId = paramCursor.getLong(i);
      break label10187;
      label15942:
      paramaukm.lCurrentBgId = paramCursor.getLong(i);
      break label10224;
      label15957:
      paramaukm.backgroundUrl = paramCursor.getString(i);
      break label10261;
      label15972:
      paramaukm.backgroundColor = paramCursor.getLong(i);
      break label10298;
      label15987:
      paramaukm.dynamicCardFlag = paramCursor.getInt(i);
      break label10335;
      label16002:
      paramaukm.strZipUrl = paramCursor.getString(i);
      break label10372;
      label16017:
      paramaukm.strActiveUrl = paramCursor.getString(i);
      break label10409;
      label16032:
      paramaukm.strDrawerCardUrl = paramCursor.getString(i);
      break label10446;
      label16047:
      paramaukm.strWzryHeroUrl = paramCursor.getString(i);
      break label10483;
      label16062:
      paramaukm.wzryHonorInfo = paramCursor.getBlob(i);
      break label10520;
      label16077:
      paramaukm.strExtInfo = paramCursor.getString(i);
      break label10557;
      label16092:
      paramaukm.strCurrentBgUrl = paramCursor.getString(i);
      break label10594;
      label16107:
      paramaukm.bgType = paramCursor.getBlob(i);
      break label10631;
      label16122:
      paramaukm.encId = paramCursor.getString(i);
      break label10668;
      label16137:
      paramaukm.busiEntry = paramCursor.getString(i);
      break label10705;
      label16152:
      paramaukm.favoriteSource = paramCursor.getInt(i);
      break label10742;
      label16167:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.visibleMusicPendant = paramBoolean;
        break;
      }
      label16194:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.autoPlayMusicPendant = paramBoolean;
        break;
      }
      label16221:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.showRedPointMusicPendant = paramBoolean;
        break;
      }
      label16248:
      paramaukm.privilegePromptStr = paramCursor.getString(i);
      break label10890;
      label16263:
      paramaukm.privilegeJumpUrl = paramCursor.getString(i);
      break label10927;
      label16278:
      paramaukm.vOpenPriv = paramCursor.getBlob(i);
      break label10964;
      label16293:
      paramaukm.vClosePriv = paramCursor.getBlob(i);
      break label11001;
      label16308:
      paramaukm.presentDesc = paramCursor.getString(i);
      break label11038;
      label16323:
      paramaukm.presentCustourl = paramCursor.getString(i);
      break label11075;
      label16338:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.presentSwitch = paramBoolean;
        break;
      }
      label16365:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.showPresent = paramBoolean;
        break;
      }
      label16392:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.showMusicBox = paramBoolean;
        break;
      }
      label16419:
      paramaukm.addSrcName = paramCursor.getString(i);
      break label11223;
      label16434:
      paramaukm.addSrcId = paramCursor.getLong(i);
      break label11260;
      label16449:
      paramaukm.addSubSrcId = paramCursor.getLong(i);
      break label11297;
      label16464:
      paramaukm.strVoteLimitedNotice = paramCursor.getString(i);
      break label11334;
      label16479:
      paramaukm.bHaveVotedCnt = paramCursor.getShort(i);
      break label11371;
      label16494:
      paramaukm.bAvailVoteCnt = paramCursor.getShort(i);
      break label11408;
      label16509:
      paramaukm.olympicTorch = ((byte)paramCursor.getShort(i));
      break label11445;
      label16525:
      paramaukm.mNowShowFlag = paramCursor.getInt(i);
      break label11482;
      label16540:
      paramaukm.mNowShowIconUrl = paramCursor.getString(i);
      break label11519;
      label16555:
      paramaukm.mNowShowJumpUrl = paramCursor.getString(i);
      break label11556;
      label16570:
      paramaukm.vCoverInfo = paramCursor.getBlob(i);
      break label11593;
      label16585:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.videoHeadFlag = paramBoolean;
        break;
      }
      label16612:
      paramaukm.videoHeadUrl = paramCursor.getString(i);
      break label11667;
      label16627:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.medalSwitchDisable = paramBoolean;
        break;
      }
      label16654:
      paramaukm.iMedalCount = paramCursor.getInt(i);
      break label11741;
      label16669:
      paramaukm.iNewCount = paramCursor.getInt(i);
      break label11778;
      label16684:
      paramaukm.iUpgradeCount = paramCursor.getInt(i);
      break label11815;
      label16699:
      paramaukm.strPromptParams = paramCursor.getString(i);
      break label11852;
      label16714:
      paramaukm.hobbyEntry = paramCursor.getString(i);
      break label11889;
      label16729:
      paramaukm.lastPraiseInfoList = paramCursor.getBlob(i);
      break label11926;
      label16744:
      paramaukm.tempChatSig = paramCursor.getBlob(i);
      break label11963;
      label16759:
      paramaukm.namePlateOfKingGameId = paramCursor.getLong(i);
      break label12000;
      label16774:
      paramaukm.namePlateOfKingLoginTime = paramCursor.getLong(i);
      break label12037;
      label16789:
      paramaukm.namePlateOfKingDan = paramCursor.getInt(i);
      break label12074;
      label16804:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.namePlateOfKingDanDisplatSwitch = paramBoolean;
        break;
      }
      label16831:
      paramaukm.vPersonalityLabelV2 = paramCursor.getBlob(i);
      break label12148;
      label16846:
      paramaukm.cardType = paramCursor.getInt(i);
      break label12185;
      label16861:
      paramaukm.diyText = paramCursor.getString(i);
      break label12222;
      label16876:
      paramaukm.diyTextFontId = paramCursor.getInt(i);
      break label12259;
      label16891:
      paramaukm.diyTextWidth = paramCursor.getFloat(i);
      break label12296;
      label16906:
      paramaukm.diyTextHeight = paramCursor.getFloat(i);
      break label12333;
      label16921:
      paramaukm.diyTextLocX = paramCursor.getFloat(i);
      break label12370;
      label16936:
      paramaukm.diyTextLocY = paramCursor.getFloat(i);
      break label12407;
      label16951:
      paramaukm.diyTextDegree = paramCursor.getFloat(i);
      break label12444;
      label16966:
      paramaukm.diyTextScale = paramCursor.getFloat(i);
      break label12481;
      label16981:
      paramaukm.diyTextTransparency = paramCursor.getFloat(i);
      break label12518;
      label16996:
      paramaukm.diyDefaultText = paramCursor.getString(i);
      break label12555;
      label17011:
      paramaukm.popularity = paramCursor.getInt(i);
      break label12592;
      label17026:
      paramaukm.declaration = paramCursor.getString(i);
      break label12629;
      label17041:
      paramaukm.voiceUrl = paramCursor.getString(i);
      break label12666;
      label17056:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isShowCard = paramBoolean;
        break;
      }
      label17083:
      paramaukm.updateTime = paramCursor.getLong(i);
      break label12740;
      label17098:
      paramaukm.extendFriendFlag = paramCursor.getInt(i);
      break label12777;
      label17113:
      paramaukm.extendFriendVoiceDuration = paramCursor.getInt(i);
      break label12814;
      label17128:
      paramaukm.extendFriendEntryContact = paramCursor.getShort(i);
      break label12851;
      label17143:
      paramaukm.extendFriendEntryAddFriend = paramCursor.getShort(i);
      break label12888;
      label17158:
      paramaukm.extendFriendQuestion = paramCursor.getShort(i);
      break label12925;
      label17173:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isShowMiniPlaying = paramBoolean;
        break;
      }
      label17200:
      paramaukm.tabJumpUrl = paramCursor.getString(i);
      break label12999;
      label17215:
      paramaukm.guestJumpUrl = paramCursor.getString(i);
      break label13036;
      label17230:
      paramaukm.guestAppTotal = paramCursor.getInt(i);
      break label13073;
      label17245:
      paramaukm.defaultCardId = paramCursor.getInt(i);
      break label13110;
      label17260:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.strangerVoteOpen = paramBoolean;
        break;
      }
      label17287:
      paramaukm.lSuperVipTemplateId = paramCursor.getLong(i);
      break label13184;
      label17302:
      paramaukm.bBigClubVipOpen = ((byte)paramCursor.getShort(i));
      break label13221;
      label17318:
      paramaukm.iBigClubVipType = paramCursor.getInt(i);
      break label13258;
      label17333:
      paramaukm.iBigClubVipLevel = paramCursor.getInt(i);
      break label13295;
      label17348:
      paramaukm.lBigClubTemplateId = paramCursor.getLong(i);
      break label13332;
      label17363:
      paramaukm.diyComplicatedInfo = paramCursor.getString(i);
      break label13369;
      label17378:
      paramaukm.cardId = paramCursor.getLong(i);
    }
    label17393:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramaukm.strangerInviteMeGroupOpen = paramBoolean;
      break;
    }
    label17420:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramaukm.isPrettyGroupOwner = paramBoolean;
      break;
    }
    label17447:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramaukm.isHidePrettyGroutIdentity = paramBoolean;
      break;
    }
    label17475:
    paramaukm.mQQLevelType = paramCursor.getInt(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,strNick TEXT ,shGender INTEGER ,shAge INTEGER ,nFaceID INTEGER ,strCertificationInfo TEXT ,shType INTEGER ,vContent BLOB ,strSign TEXT ,strCompany TEXT ,strSchool TEXT ,uFaceTimeStamp INTEGER ,vQQFaceID BLOB ,strReMark TEXT ,bWeiboInfo INTEGER ,bQzoneInfo INTEGER ,nSameFriendsNum INTEGER ,strCompanySame TEXT ,strSchoolSame TEXT ,lCardShowNum INTEGER ,bSingle INTEGER ,lVisitCount INTEGER ,lVoteCount INTEGER ,tagInfosByte BLOB ,eUserIdentityType INTEGER ,vBackground BLOB ,labelInfoBytes BLOB ,age INTEGER ,constellation INTEGER ,pyFaceUrl TEXT ,location TEXT ,bVoted INTEGER ,bFavorited INTEGER ,iVoteIncrement INTEGER ,strJoinHexAlbumFileKey TEXT ,iFaceNum INTEGER ,cSqqLevel INTEGER ,iQQLevel INTEGER ,uCurMulType INTEGER ,strProvince TEXT ,strCity TEXT ,strCountry TEXT ,lBirthday INTEGER ,strLocationCodes TEXT ,strLocationDesc TEXT ,strHometownCodes TEXT ,strHometownDesc TEXT ,strEmail TEXT ,strPersonalNote TEXT ,iProfession INTEGER ,bindPhoneInfo TEXT ,bCardInfo BLOB ,strTroopName TEXT ,strTroopNick TEXT ,strMobile TEXT ,strContactName TEXT ,ulShowControl INTEGER ,feedPreviewTime INTEGER ,strQzoneFeedsDesc TEXT ,StrPresentDesc TEXT ,strSpaceName TEXT ,strQzoneHeader TEXT ,vQzonePhotos BLOB ,vQzoneCoverInfo BLOB ,enlargeQzonePic INTEGER ,showPublishButton INTEGER ,strStatus TEXT ,strAutoRemark TEXT ,vSeed BLOB ,vCookies BLOB ,hasFakeData INTEGER ,bQQVipOpen INTEGER ,iQQVipType INTEGER ,iQQVipLevel INTEGER ,nameplateVipType INTEGER ,grayNameplateFlag INTEGER ,bSuperVipOpen INTEGER ,iSuperVipType INTEGER ,iSuperVipLevel INTEGER ,bSuperQQOpen INTEGER ,iSuperQQType INTEGER ,iSuperQQLevel INTEGER ,bHollywoodVipOpen INTEGER ,iHollywoodVipType INTEGER ,iHollywoodVipLevel INTEGER ,strShowName TEXT ,strVoiceFilekey TEXT ,shDuration INTEGER ,bRead INTEGER ,strUrl TEXT ,vRichSign BLOB ,lSignModifyTime INTEGER ,vLongNickTopicInfo BLOB ,nLastGameFlag INTEGER ,strGameLogoUrl_1 TEXT ,strGameLogoUrl_2 TEXT ,strGameLogoUrl_3 TEXT ,strGameLogoUrl_4 TEXT ,strGameLogoKey_1 TEXT ,strGameLogoKey_2 TEXT ,strGameLogoKey_3 TEXT ,strGameLogoKey_4 TEXT ,strGameName_1 TEXT ,strGameName_2 TEXT ,strGameName_3 TEXT ,strGameName_4 TEXT ,strGameAppid_1 TEXT ,strGameAppid_2 TEXT ,strGameAppid_3 TEXT ,strGameAppid_4 TEXT ,strProfileUrl TEXT ,nStarFansFlag INTEGER ,strStarPicUrl_0 TEXT ,strStarPicUrl_1 TEXT ,strStarPicUrl_2 TEXT ,strStarLvUrl_0 TEXT ,strStarLvUrl_1 TEXT ,strStarLvUrl_2 TEXT ,strStarLogoUrl TEXT ,starFansJumpUrl TEXT ,lUserFlag INTEGER ,lLoginDays INTEGER ,strLoginDaysDesc TEXT ,lQQMasterLogindays INTEGER ,iXManScene1DelayTime INTEGER ,iXManScene2DelayTime INTEGER ,allowPeopleSee INTEGER ,allowCalInteractive INTEGER ,showOnlineFriends INTEGER ,allowClick INTEGER ,babyQSwitch INTEGER ,showLightalk INTEGER ,lightalkNick TEXT ,lightalkId TEXT ,isSuperRedDiamond INTEGER ,isRedDiamond INTEGER ,redLevel INTEGER ,isSuperYellowDiamond INTEGER ,isYellowDiamond INTEGER ,yellowLevel INTEGER ,isSuperGreenDiamond INTEGER ,isGreenDiamond INTEGER ,greenLevel INTEGER ,uAccelerateMultiple INTEGER ,strRespMusicInfo TEXT ,templateRet INTEGER ,lCurrentStyleId INTEGER ,lCurrentBgId INTEGER ,backgroundUrl TEXT ,backgroundColor INTEGER ,dynamicCardFlag INTEGER ,strZipUrl TEXT ,strActiveUrl TEXT ,strDrawerCardUrl TEXT ,strWzryHeroUrl TEXT ,wzryHonorInfo BLOB ,strExtInfo TEXT ,strCurrentBgUrl TEXT ,bgType BLOB ,encId TEXT ,busiEntry TEXT ,favoriteSource INTEGER ,visibleMusicPendant INTEGER ,autoPlayMusicPendant INTEGER ,showRedPointMusicPendant INTEGER ,privilegePromptStr TEXT ,privilegeJumpUrl TEXT ,vOpenPriv BLOB ,vClosePriv BLOB ,presentDesc TEXT ,presentCustourl TEXT ,presentSwitch INTEGER ,showPresent INTEGER ,showMusicBox INTEGER ,addSrcName TEXT ,addSrcId INTEGER ,addSubSrcId INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,olympicTorch INTEGER ,mNowShowFlag INTEGER ,mNowShowIconUrl TEXT ,mNowShowJumpUrl TEXT ,vCoverInfo BLOB ,videoHeadFlag INTEGER ,videoHeadUrl TEXT ,medalSwitchDisable INTEGER ,iMedalCount INTEGER ,iNewCount INTEGER ,iUpgradeCount INTEGER ,strPromptParams TEXT ,hobbyEntry TEXT ,lastPraiseInfoList BLOB ,tempChatSig BLOB ,namePlateOfKingGameId INTEGER ,namePlateOfKingLoginTime INTEGER ,namePlateOfKingDan INTEGER ,namePlateOfKingDanDisplatSwitch INTEGER ,vPersonalityLabelV2 BLOB ,cardType INTEGER ,diyText TEXT ,diyTextFontId INTEGER ,diyTextWidth REAL ,diyTextHeight REAL ,diyTextLocX REAL ,diyTextLocY REAL ,diyTextDegree REAL ,diyTextScale REAL ,diyTextTransparency REAL ,diyDefaultText TEXT ,popularity INTEGER ,declaration TEXT ,voiceUrl TEXT ,isShowCard INTEGER ,updateTime INTEGER ,extendFriendFlag INTEGER ,extendFriendVoiceDuration INTEGER ,extendFriendEntryContact INTEGER ,extendFriendEntryAddFriend INTEGER ,extendFriendQuestion INTEGER ,isShowMiniPlaying INTEGER ,tabJumpUrl TEXT ,guestJumpUrl TEXT ,guestAppTotal INTEGER ,defaultCardId INTEGER ,strangerVoteOpen INTEGER ,lSuperVipTemplateId INTEGER ,bBigClubVipOpen INTEGER ,iBigClubVipType INTEGER ,iBigClubVipLevel INTEGER ,lBigClubTemplateId INTEGER ,diyComplicatedInfo TEXT ,cardId INTEGER ,strangerInviteMeGroupOpen INTEGER ,isPrettyGroupOwner INTEGER ,isHidePrettyGroutIdentity INTEGER ,mQQLevelType INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (Card)paramaukm;
    paramContentValues.put("uin", paramaukm.uin);
    paramContentValues.put("strNick", paramaukm.strNick);
    paramContentValues.put("shGender", Short.valueOf(paramaukm.shGender));
    paramContentValues.put("shAge", Short.valueOf(paramaukm.shAge));
    paramContentValues.put("nFaceID", Integer.valueOf(paramaukm.nFaceID));
    paramContentValues.put("strCertificationInfo", paramaukm.strCertificationInfo);
    paramContentValues.put("shType", Short.valueOf(paramaukm.shType));
    paramContentValues.put("vContent", paramaukm.vContent);
    paramContentValues.put("strSign", paramaukm.strSign);
    paramContentValues.put("strCompany", paramaukm.strCompany);
    paramContentValues.put("strSchool", paramaukm.strSchool);
    paramContentValues.put("uFaceTimeStamp", Integer.valueOf(paramaukm.uFaceTimeStamp));
    paramContentValues.put("vQQFaceID", paramaukm.vQQFaceID);
    paramContentValues.put("strReMark", paramaukm.strReMark);
    paramContentValues.put("bWeiboInfo", Byte.valueOf(paramaukm.bWeiboInfo));
    paramContentValues.put("bQzoneInfo", Byte.valueOf(paramaukm.bQzoneInfo));
    paramContentValues.put("nSameFriendsNum", Integer.valueOf(paramaukm.nSameFriendsNum));
    paramContentValues.put("strCompanySame", paramaukm.strCompanySame);
    paramContentValues.put("strSchoolSame", paramaukm.strSchoolSame);
    paramContentValues.put("lCardShowNum", Long.valueOf(paramaukm.lCardShowNum));
    paramContentValues.put("bSingle", Byte.valueOf(paramaukm.bSingle));
    paramContentValues.put("lVisitCount", Long.valueOf(paramaukm.lVisitCount));
    paramContentValues.put("lVoteCount", Long.valueOf(paramaukm.lVoteCount));
    paramContentValues.put("tagInfosByte", paramaukm.tagInfosByte);
    paramContentValues.put("eUserIdentityType", Byte.valueOf(paramaukm.eUserIdentityType));
    paramContentValues.put("vBackground", paramaukm.vBackground);
    paramContentValues.put("labelInfoBytes", paramaukm.labelInfoBytes);
    paramContentValues.put("age", Byte.valueOf(paramaukm.age));
    paramContentValues.put("constellation", Integer.valueOf(paramaukm.constellation));
    paramContentValues.put("pyFaceUrl", paramaukm.pyFaceUrl);
    paramContentValues.put("location", paramaukm.location);
    paramContentValues.put("bVoted", Byte.valueOf(paramaukm.bVoted));
    paramContentValues.put("bFavorited", Byte.valueOf(paramaukm.bFavorited));
    paramContentValues.put("iVoteIncrement", Integer.valueOf(paramaukm.iVoteIncrement));
    paramContentValues.put("strJoinHexAlbumFileKey", paramaukm.strJoinHexAlbumFileKey);
    paramContentValues.put("iFaceNum", Integer.valueOf(paramaukm.iFaceNum));
    paramContentValues.put("cSqqLevel", Byte.valueOf(paramaukm.cSqqLevel));
    paramContentValues.put("iQQLevel", Integer.valueOf(paramaukm.iQQLevel));
    paramContentValues.put("uCurMulType", Long.valueOf(paramaukm.uCurMulType));
    paramContentValues.put("strProvince", paramaukm.strProvince);
    paramContentValues.put("strCity", paramaukm.strCity);
    paramContentValues.put("strCountry", paramaukm.strCountry);
    paramContentValues.put("lBirthday", Long.valueOf(paramaukm.lBirthday));
    paramContentValues.put("strLocationCodes", paramaukm.strLocationCodes);
    paramContentValues.put("strLocationDesc", paramaukm.strLocationDesc);
    paramContentValues.put("strHometownCodes", paramaukm.strHometownCodes);
    paramContentValues.put("strHometownDesc", paramaukm.strHometownDesc);
    paramContentValues.put("strEmail", paramaukm.strEmail);
    paramContentValues.put("strPersonalNote", paramaukm.strPersonalNote);
    paramContentValues.put("iProfession", Integer.valueOf(paramaukm.iProfession));
    paramContentValues.put("bindPhoneInfo", paramaukm.bindPhoneInfo);
    paramContentValues.put("bCardInfo", paramaukm.bCardInfo);
    paramContentValues.put("strTroopName", paramaukm.strTroopName);
    paramContentValues.put("strTroopNick", paramaukm.strTroopNick);
    paramContentValues.put("strMobile", paramaukm.strMobile);
    paramContentValues.put("strContactName", paramaukm.strContactName);
    paramContentValues.put("ulShowControl", Integer.valueOf(paramaukm.ulShowControl));
    paramContentValues.put("feedPreviewTime", Long.valueOf(paramaukm.feedPreviewTime));
    paramContentValues.put("strQzoneFeedsDesc", paramaukm.strQzoneFeedsDesc);
    paramContentValues.put("StrPresentDesc", paramaukm.StrPresentDesc);
    paramContentValues.put("strSpaceName", paramaukm.strSpaceName);
    paramContentValues.put("strQzoneHeader", paramaukm.strQzoneHeader);
    paramContentValues.put("vQzonePhotos", paramaukm.vQzonePhotos);
    paramContentValues.put("vQzoneCoverInfo", paramaukm.vQzoneCoverInfo);
    paramContentValues.put("enlargeQzonePic", Integer.valueOf(paramaukm.enlargeQzonePic));
    paramContentValues.put("showPublishButton", Boolean.valueOf(paramaukm.showPublishButton));
    paramContentValues.put("strStatus", paramaukm.strStatus);
    paramContentValues.put("strAutoRemark", paramaukm.strAutoRemark);
    paramContentValues.put("vSeed", paramaukm.vSeed);
    paramContentValues.put("vCookies", paramaukm.vCookies);
    paramContentValues.put("hasFakeData", Boolean.valueOf(paramaukm.hasFakeData));
    paramContentValues.put("bQQVipOpen", Byte.valueOf(paramaukm.bQQVipOpen));
    paramContentValues.put("iQQVipType", Integer.valueOf(paramaukm.iQQVipType));
    paramContentValues.put("iQQVipLevel", Integer.valueOf(paramaukm.iQQVipLevel));
    paramContentValues.put("nameplateVipType", Integer.valueOf(paramaukm.nameplateVipType));
    paramContentValues.put("grayNameplateFlag", Integer.valueOf(paramaukm.grayNameplateFlag));
    paramContentValues.put("bSuperVipOpen", Byte.valueOf(paramaukm.bSuperVipOpen));
    paramContentValues.put("iSuperVipType", Integer.valueOf(paramaukm.iSuperVipType));
    paramContentValues.put("iSuperVipLevel", Integer.valueOf(paramaukm.iSuperVipLevel));
    paramContentValues.put("bSuperQQOpen", Byte.valueOf(paramaukm.bSuperQQOpen));
    paramContentValues.put("iSuperQQType", Integer.valueOf(paramaukm.iSuperQQType));
    paramContentValues.put("iSuperQQLevel", Integer.valueOf(paramaukm.iSuperQQLevel));
    paramContentValues.put("bHollywoodVipOpen", Byte.valueOf(paramaukm.bHollywoodVipOpen));
    paramContentValues.put("iHollywoodVipType", Integer.valueOf(paramaukm.iHollywoodVipType));
    paramContentValues.put("iHollywoodVipLevel", Integer.valueOf(paramaukm.iHollywoodVipLevel));
    paramContentValues.put("strShowName", paramaukm.strShowName);
    paramContentValues.put("strVoiceFilekey", paramaukm.strVoiceFilekey);
    paramContentValues.put("shDuration", Short.valueOf(paramaukm.shDuration));
    paramContentValues.put("bRead", Byte.valueOf(paramaukm.bRead));
    paramContentValues.put("strUrl", paramaukm.strUrl);
    paramContentValues.put("vRichSign", paramaukm.vRichSign);
    paramContentValues.put("lSignModifyTime", Long.valueOf(paramaukm.lSignModifyTime));
    paramContentValues.put("vLongNickTopicInfo", paramaukm.vLongNickTopicInfo);
    paramContentValues.put("nLastGameFlag", Integer.valueOf(paramaukm.nLastGameFlag));
    paramContentValues.put("strGameLogoUrl_1", paramaukm.strGameLogoUrl_1);
    paramContentValues.put("strGameLogoUrl_2", paramaukm.strGameLogoUrl_2);
    paramContentValues.put("strGameLogoUrl_3", paramaukm.strGameLogoUrl_3);
    paramContentValues.put("strGameLogoUrl_4", paramaukm.strGameLogoUrl_4);
    paramContentValues.put("strGameLogoKey_1", paramaukm.strGameLogoKey_1);
    paramContentValues.put("strGameLogoKey_2", paramaukm.strGameLogoKey_2);
    paramContentValues.put("strGameLogoKey_3", paramaukm.strGameLogoKey_3);
    paramContentValues.put("strGameLogoKey_4", paramaukm.strGameLogoKey_4);
    paramContentValues.put("strGameName_1", paramaukm.strGameName_1);
    paramContentValues.put("strGameName_2", paramaukm.strGameName_2);
    paramContentValues.put("strGameName_3", paramaukm.strGameName_3);
    paramContentValues.put("strGameName_4", paramaukm.strGameName_4);
    paramContentValues.put("strGameAppid_1", paramaukm.strGameAppid_1);
    paramContentValues.put("strGameAppid_2", paramaukm.strGameAppid_2);
    paramContentValues.put("strGameAppid_3", paramaukm.strGameAppid_3);
    paramContentValues.put("strGameAppid_4", paramaukm.strGameAppid_4);
    paramContentValues.put("strProfileUrl", paramaukm.strProfileUrl);
    paramContentValues.put("nStarFansFlag", Integer.valueOf(paramaukm.nStarFansFlag));
    paramContentValues.put("strStarPicUrl_0", paramaukm.strStarPicUrl_0);
    paramContentValues.put("strStarPicUrl_1", paramaukm.strStarPicUrl_1);
    paramContentValues.put("strStarPicUrl_2", paramaukm.strStarPicUrl_2);
    paramContentValues.put("strStarLvUrl_0", paramaukm.strStarLvUrl_0);
    paramContentValues.put("strStarLvUrl_1", paramaukm.strStarLvUrl_1);
    paramContentValues.put("strStarLvUrl_2", paramaukm.strStarLvUrl_2);
    paramContentValues.put("strStarLogoUrl", paramaukm.strStarLogoUrl);
    paramContentValues.put("starFansJumpUrl", paramaukm.starFansJumpUrl);
    paramContentValues.put("lUserFlag", Long.valueOf(paramaukm.lUserFlag));
    paramContentValues.put("lLoginDays", Long.valueOf(paramaukm.lLoginDays));
    paramContentValues.put("strLoginDaysDesc", paramaukm.strLoginDaysDesc);
    paramContentValues.put("lQQMasterLogindays", Long.valueOf(paramaukm.lQQMasterLogindays));
    paramContentValues.put("iXManScene1DelayTime", Integer.valueOf(paramaukm.iXManScene1DelayTime));
    paramContentValues.put("iXManScene2DelayTime", Integer.valueOf(paramaukm.iXManScene2DelayTime));
    paramContentValues.put("allowPeopleSee", Boolean.valueOf(paramaukm.allowPeopleSee));
    paramContentValues.put("allowCalInteractive", Boolean.valueOf(paramaukm.allowCalInteractive));
    paramContentValues.put("showOnlineFriends", Boolean.valueOf(paramaukm.showOnlineFriends));
    paramContentValues.put("allowClick", Boolean.valueOf(paramaukm.allowClick));
    paramContentValues.put("babyQSwitch", Boolean.valueOf(paramaukm.babyQSwitch));
    paramContentValues.put("showLightalk", Boolean.valueOf(paramaukm.showLightalk));
    paramContentValues.put("lightalkNick", paramaukm.lightalkNick);
    paramContentValues.put("lightalkId", paramaukm.lightalkId);
    paramContentValues.put("isSuperRedDiamond", Boolean.valueOf(paramaukm.isSuperRedDiamond));
    paramContentValues.put("isRedDiamond", Boolean.valueOf(paramaukm.isRedDiamond));
    paramContentValues.put("redLevel", Integer.valueOf(paramaukm.redLevel));
    paramContentValues.put("isSuperYellowDiamond", Boolean.valueOf(paramaukm.isSuperYellowDiamond));
    paramContentValues.put("isYellowDiamond", Boolean.valueOf(paramaukm.isYellowDiamond));
    paramContentValues.put("yellowLevel", Integer.valueOf(paramaukm.yellowLevel));
    paramContentValues.put("isSuperGreenDiamond", Boolean.valueOf(paramaukm.isSuperGreenDiamond));
    paramContentValues.put("isGreenDiamond", Boolean.valueOf(paramaukm.isGreenDiamond));
    paramContentValues.put("greenLevel", Integer.valueOf(paramaukm.greenLevel));
    paramContentValues.put("uAccelerateMultiple", Long.valueOf(paramaukm.uAccelerateMultiple));
    paramContentValues.put("strRespMusicInfo", paramaukm.strRespMusicInfo);
    paramContentValues.put("templateRet", Integer.valueOf(paramaukm.templateRet));
    paramContentValues.put("lCurrentStyleId", Long.valueOf(paramaukm.lCurrentStyleId));
    paramContentValues.put("lCurrentBgId", Long.valueOf(paramaukm.lCurrentBgId));
    paramContentValues.put("backgroundUrl", paramaukm.backgroundUrl);
    paramContentValues.put("backgroundColor", Long.valueOf(paramaukm.backgroundColor));
    paramContentValues.put("dynamicCardFlag", Integer.valueOf(paramaukm.dynamicCardFlag));
    paramContentValues.put("strZipUrl", paramaukm.strZipUrl);
    paramContentValues.put("strActiveUrl", paramaukm.strActiveUrl);
    paramContentValues.put("strDrawerCardUrl", paramaukm.strDrawerCardUrl);
    paramContentValues.put("strWzryHeroUrl", paramaukm.strWzryHeroUrl);
    paramContentValues.put("wzryHonorInfo", paramaukm.wzryHonorInfo);
    paramContentValues.put("strExtInfo", paramaukm.strExtInfo);
    paramContentValues.put("strCurrentBgUrl", paramaukm.strCurrentBgUrl);
    paramContentValues.put("bgType", paramaukm.bgType);
    paramContentValues.put("encId", paramaukm.encId);
    paramContentValues.put("busiEntry", paramaukm.busiEntry);
    paramContentValues.put("favoriteSource", Integer.valueOf(paramaukm.favoriteSource));
    paramContentValues.put("visibleMusicPendant", Boolean.valueOf(paramaukm.visibleMusicPendant));
    paramContentValues.put("autoPlayMusicPendant", Boolean.valueOf(paramaukm.autoPlayMusicPendant));
    paramContentValues.put("showRedPointMusicPendant", Boolean.valueOf(paramaukm.showRedPointMusicPendant));
    paramContentValues.put("privilegePromptStr", paramaukm.privilegePromptStr);
    paramContentValues.put("privilegeJumpUrl", paramaukm.privilegeJumpUrl);
    paramContentValues.put("vOpenPriv", paramaukm.vOpenPriv);
    paramContentValues.put("vClosePriv", paramaukm.vClosePriv);
    paramContentValues.put("presentDesc", paramaukm.presentDesc);
    paramContentValues.put("presentCustourl", paramaukm.presentCustourl);
    paramContentValues.put("presentSwitch", Boolean.valueOf(paramaukm.presentSwitch));
    paramContentValues.put("showPresent", Boolean.valueOf(paramaukm.showPresent));
    paramContentValues.put("showMusicBox", Boolean.valueOf(paramaukm.showMusicBox));
    paramContentValues.put("addSrcName", paramaukm.addSrcName);
    paramContentValues.put("addSrcId", Long.valueOf(paramaukm.addSrcId));
    paramContentValues.put("addSubSrcId", Long.valueOf(paramaukm.addSubSrcId));
    paramContentValues.put("strVoteLimitedNotice", paramaukm.strVoteLimitedNotice);
    paramContentValues.put("bHaveVotedCnt", Short.valueOf(paramaukm.bHaveVotedCnt));
    paramContentValues.put("bAvailVoteCnt", Short.valueOf(paramaukm.bAvailVoteCnt));
    paramContentValues.put("olympicTorch", Byte.valueOf(paramaukm.olympicTorch));
    paramContentValues.put("mNowShowFlag", Integer.valueOf(paramaukm.mNowShowFlag));
    paramContentValues.put("mNowShowIconUrl", paramaukm.mNowShowIconUrl);
    paramContentValues.put("mNowShowJumpUrl", paramaukm.mNowShowJumpUrl);
    paramContentValues.put("vCoverInfo", paramaukm.vCoverInfo);
    paramContentValues.put("videoHeadFlag", Boolean.valueOf(paramaukm.videoHeadFlag));
    paramContentValues.put("videoHeadUrl", paramaukm.videoHeadUrl);
    paramContentValues.put("medalSwitchDisable", Boolean.valueOf(paramaukm.medalSwitchDisable));
    paramContentValues.put("iMedalCount", Integer.valueOf(paramaukm.iMedalCount));
    paramContentValues.put("iNewCount", Integer.valueOf(paramaukm.iNewCount));
    paramContentValues.put("iUpgradeCount", Integer.valueOf(paramaukm.iUpgradeCount));
    paramContentValues.put("strPromptParams", paramaukm.strPromptParams);
    paramContentValues.put("hobbyEntry", paramaukm.hobbyEntry);
    paramContentValues.put("lastPraiseInfoList", paramaukm.lastPraiseInfoList);
    paramContentValues.put("tempChatSig", paramaukm.tempChatSig);
    paramContentValues.put("namePlateOfKingGameId", Long.valueOf(paramaukm.namePlateOfKingGameId));
    paramContentValues.put("namePlateOfKingLoginTime", Long.valueOf(paramaukm.namePlateOfKingLoginTime));
    paramContentValues.put("namePlateOfKingDan", Integer.valueOf(paramaukm.namePlateOfKingDan));
    paramContentValues.put("namePlateOfKingDanDisplatSwitch", Boolean.valueOf(paramaukm.namePlateOfKingDanDisplatSwitch));
    paramContentValues.put("vPersonalityLabelV2", paramaukm.vPersonalityLabelV2);
    paramContentValues.put("cardType", Integer.valueOf(paramaukm.cardType));
    paramContentValues.put("diyText", paramaukm.diyText);
    paramContentValues.put("diyTextFontId", Integer.valueOf(paramaukm.diyTextFontId));
    paramContentValues.put("diyTextWidth", Float.valueOf(paramaukm.diyTextWidth));
    paramContentValues.put("diyTextHeight", Float.valueOf(paramaukm.diyTextHeight));
    paramContentValues.put("diyTextLocX", Float.valueOf(paramaukm.diyTextLocX));
    paramContentValues.put("diyTextLocY", Float.valueOf(paramaukm.diyTextLocY));
    paramContentValues.put("diyTextDegree", Float.valueOf(paramaukm.diyTextDegree));
    paramContentValues.put("diyTextScale", Float.valueOf(paramaukm.diyTextScale));
    paramContentValues.put("diyTextTransparency", Float.valueOf(paramaukm.diyTextTransparency));
    paramContentValues.put("diyDefaultText", paramaukm.diyDefaultText);
    paramContentValues.put("popularity", Integer.valueOf(paramaukm.popularity));
    paramContentValues.put("declaration", paramaukm.declaration);
    paramContentValues.put("voiceUrl", paramaukm.voiceUrl);
    paramContentValues.put("isShowCard", Boolean.valueOf(paramaukm.isShowCard));
    paramContentValues.put("updateTime", Long.valueOf(paramaukm.updateTime));
    paramContentValues.put("extendFriendFlag", Integer.valueOf(paramaukm.extendFriendFlag));
    paramContentValues.put("extendFriendVoiceDuration", Integer.valueOf(paramaukm.extendFriendVoiceDuration));
    paramContentValues.put("extendFriendEntryContact", Short.valueOf(paramaukm.extendFriendEntryContact));
    paramContentValues.put("extendFriendEntryAddFriend", Short.valueOf(paramaukm.extendFriendEntryAddFriend));
    paramContentValues.put("extendFriendQuestion", Short.valueOf(paramaukm.extendFriendQuestion));
    paramContentValues.put("isShowMiniPlaying", Boolean.valueOf(paramaukm.isShowMiniPlaying));
    paramContentValues.put("tabJumpUrl", paramaukm.tabJumpUrl);
    paramContentValues.put("guestJumpUrl", paramaukm.guestJumpUrl);
    paramContentValues.put("guestAppTotal", Integer.valueOf(paramaukm.guestAppTotal));
    paramContentValues.put("defaultCardId", Integer.valueOf(paramaukm.defaultCardId));
    paramContentValues.put("strangerVoteOpen", Boolean.valueOf(paramaukm.strangerVoteOpen));
    paramContentValues.put("lSuperVipTemplateId", Long.valueOf(paramaukm.lSuperVipTemplateId));
    paramContentValues.put("bBigClubVipOpen", Byte.valueOf(paramaukm.bBigClubVipOpen));
    paramContentValues.put("iBigClubVipType", Integer.valueOf(paramaukm.iBigClubVipType));
    paramContentValues.put("iBigClubVipLevel", Integer.valueOf(paramaukm.iBigClubVipLevel));
    paramContentValues.put("lBigClubTemplateId", Long.valueOf(paramaukm.lBigClubTemplateId));
    paramContentValues.put("diyComplicatedInfo", paramaukm.diyComplicatedInfo);
    paramContentValues.put("cardId", Long.valueOf(paramaukm.cardId));
    paramContentValues.put("strangerInviteMeGroupOpen", Boolean.valueOf(paramaukm.strangerInviteMeGroupOpen));
    paramContentValues.put("isPrettyGroupOwner", Boolean.valueOf(paramaukm.isPrettyGroupOwner));
    paramContentValues.put("isHidePrettyGroutIdentity", Boolean.valueOf(paramaukm.isHidePrettyGroutIdentity));
    paramContentValues.put("mQQLevelType", Integer.valueOf(paramaukm.mQQLevelType));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukb
 * JD-Core Version:    0.7.0.1
 */