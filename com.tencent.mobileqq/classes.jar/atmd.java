import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atmd
  extends atna
{
  public atmd()
  {
    this.a = 236;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramatmo = (Card)paramatmo;
    label1330:
    label2368:
    label2498:
    label4804:
    if (paramatmz == null)
    {
      paramatmo.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramatmo.strNick = paramCursor.getString(paramCursor.getColumnIndex("strNick"));
      paramatmo.shGender = paramCursor.getShort(paramCursor.getColumnIndex("shGender"));
      paramatmo.shAge = paramCursor.getShort(paramCursor.getColumnIndex("shAge"));
      paramatmo.nFaceID = paramCursor.getInt(paramCursor.getColumnIndex("nFaceID"));
      paramatmo.strCertificationInfo = paramCursor.getString(paramCursor.getColumnIndex("strCertificationInfo"));
      paramatmo.shType = paramCursor.getShort(paramCursor.getColumnIndex("shType"));
      paramatmo.vContent = paramCursor.getBlob(paramCursor.getColumnIndex("vContent"));
      paramatmo.strSign = paramCursor.getString(paramCursor.getColumnIndex("strSign"));
      paramatmo.strCompany = paramCursor.getString(paramCursor.getColumnIndex("strCompany"));
      paramatmo.strSchool = paramCursor.getString(paramCursor.getColumnIndex("strSchool"));
      paramatmo.uFaceTimeStamp = paramCursor.getInt(paramCursor.getColumnIndex("uFaceTimeStamp"));
      paramatmo.vQQFaceID = paramCursor.getBlob(paramCursor.getColumnIndex("vQQFaceID"));
      paramatmo.strReMark = paramCursor.getString(paramCursor.getColumnIndex("strReMark"));
      paramatmo.bWeiboInfo = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bWeiboInfo")));
      paramatmo.bQzoneInfo = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bQzoneInfo")));
      paramatmo.nSameFriendsNum = paramCursor.getInt(paramCursor.getColumnIndex("nSameFriendsNum"));
      paramatmo.strCompanySame = paramCursor.getString(paramCursor.getColumnIndex("strCompanySame"));
      paramatmo.strSchoolSame = paramCursor.getString(paramCursor.getColumnIndex("strSchoolSame"));
      paramatmo.lCardShowNum = paramCursor.getLong(paramCursor.getColumnIndex("lCardShowNum"));
      paramatmo.bSingle = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSingle")));
      paramatmo.lVisitCount = paramCursor.getLong(paramCursor.getColumnIndex("lVisitCount"));
      paramatmo.lVoteCount = paramCursor.getLong(paramCursor.getColumnIndex("lVoteCount"));
      paramatmo.tagInfosByte = paramCursor.getBlob(paramCursor.getColumnIndex("tagInfosByte"));
      paramatmo.eUserIdentityType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("eUserIdentityType")));
      paramatmo.vBackground = paramCursor.getBlob(paramCursor.getColumnIndex("vBackground"));
      paramatmo.labelInfoBytes = paramCursor.getBlob(paramCursor.getColumnIndex("labelInfoBytes"));
      paramatmo.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramatmo.constellation = paramCursor.getInt(paramCursor.getColumnIndex("constellation"));
      paramatmo.pyFaceUrl = paramCursor.getString(paramCursor.getColumnIndex("pyFaceUrl"));
      paramatmo.location = paramCursor.getString(paramCursor.getColumnIndex("location"));
      paramatmo.bVoted = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bVoted")));
      paramatmo.bFavorited = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bFavorited")));
      paramatmo.iVoteIncrement = paramCursor.getInt(paramCursor.getColumnIndex("iVoteIncrement"));
      paramatmo.strJoinHexAlbumFileKey = paramCursor.getString(paramCursor.getColumnIndex("strJoinHexAlbumFileKey"));
      paramatmo.iFaceNum = paramCursor.getInt(paramCursor.getColumnIndex("iFaceNum"));
      paramatmo.cSqqLevel = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSqqLevel")));
      paramatmo.iQQLevel = paramCursor.getInt(paramCursor.getColumnIndex("iQQLevel"));
      paramatmo.uCurMulType = paramCursor.getLong(paramCursor.getColumnIndex("uCurMulType"));
      paramatmo.strProvince = paramCursor.getString(paramCursor.getColumnIndex("strProvince"));
      paramatmo.strCity = paramCursor.getString(paramCursor.getColumnIndex("strCity"));
      paramatmo.strCountry = paramCursor.getString(paramCursor.getColumnIndex("strCountry"));
      paramatmo.lBirthday = paramCursor.getLong(paramCursor.getColumnIndex("lBirthday"));
      paramatmo.strLocationCodes = paramCursor.getString(paramCursor.getColumnIndex("strLocationCodes"));
      paramatmo.strLocationDesc = paramCursor.getString(paramCursor.getColumnIndex("strLocationDesc"));
      paramatmo.strHometownCodes = paramCursor.getString(paramCursor.getColumnIndex("strHometownCodes"));
      paramatmo.strHometownDesc = paramCursor.getString(paramCursor.getColumnIndex("strHometownDesc"));
      paramatmo.strEmail = paramCursor.getString(paramCursor.getColumnIndex("strEmail"));
      paramatmo.strPersonalNote = paramCursor.getString(paramCursor.getColumnIndex("strPersonalNote"));
      paramatmo.iProfession = paramCursor.getInt(paramCursor.getColumnIndex("iProfession"));
      paramatmo.bindPhoneInfo = paramCursor.getString(paramCursor.getColumnIndex("bindPhoneInfo"));
      paramatmo.bCardInfo = paramCursor.getBlob(paramCursor.getColumnIndex("bCardInfo"));
      paramatmo.strTroopName = paramCursor.getString(paramCursor.getColumnIndex("strTroopName"));
      paramatmo.strTroopNick = paramCursor.getString(paramCursor.getColumnIndex("strTroopNick"));
      paramatmo.strMobile = paramCursor.getString(paramCursor.getColumnIndex("strMobile"));
      paramatmo.strContactName = paramCursor.getString(paramCursor.getColumnIndex("strContactName"));
      paramatmo.ulShowControl = paramCursor.getInt(paramCursor.getColumnIndex("ulShowControl"));
      paramatmo.feedPreviewTime = paramCursor.getLong(paramCursor.getColumnIndex("feedPreviewTime"));
      paramatmo.strQzoneFeedsDesc = paramCursor.getString(paramCursor.getColumnIndex("strQzoneFeedsDesc"));
      paramatmo.StrPresentDesc = paramCursor.getString(paramCursor.getColumnIndex("StrPresentDesc"));
      paramatmo.strSpaceName = paramCursor.getString(paramCursor.getColumnIndex("strSpaceName"));
      paramatmo.strQzoneHeader = paramCursor.getString(paramCursor.getColumnIndex("strQzoneHeader"));
      paramatmo.vQzonePhotos = paramCursor.getBlob(paramCursor.getColumnIndex("vQzonePhotos"));
      paramatmo.vQzoneCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vQzoneCoverInfo"));
      paramatmo.enlargeQzonePic = paramCursor.getInt(paramCursor.getColumnIndex("enlargeQzonePic"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("showPublishButton")))
      {
        paramBoolean = true;
        paramatmo.showPublishButton = paramBoolean;
        paramatmo.strStatus = paramCursor.getString(paramCursor.getColumnIndex("strStatus"));
        paramatmo.strAutoRemark = paramCursor.getString(paramCursor.getColumnIndex("strAutoRemark"));
        paramatmo.vSeed = paramCursor.getBlob(paramCursor.getColumnIndex("vSeed"));
        paramatmo.vCookies = paramCursor.getBlob(paramCursor.getColumnIndex("vCookies"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasFakeData"))) {
          break label4674;
        }
        paramBoolean = true;
        paramatmo.hasFakeData = paramBoolean;
        paramatmo.bQQVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bQQVipOpen")));
        paramatmo.iQQVipType = paramCursor.getInt(paramCursor.getColumnIndex("iQQVipType"));
        paramatmo.iQQVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iQQVipLevel"));
        paramatmo.bSuperVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSuperVipOpen")));
        paramatmo.iSuperVipType = paramCursor.getInt(paramCursor.getColumnIndex("iSuperVipType"));
        paramatmo.iSuperVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iSuperVipLevel"));
        paramatmo.bSuperQQOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSuperQQOpen")));
        paramatmo.iSuperQQType = paramCursor.getInt(paramCursor.getColumnIndex("iSuperQQType"));
        paramatmo.iSuperQQLevel = paramCursor.getInt(paramCursor.getColumnIndex("iSuperQQLevel"));
        paramatmo.bHollywoodVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bHollywoodVipOpen")));
        paramatmo.iHollywoodVipType = paramCursor.getInt(paramCursor.getColumnIndex("iHollywoodVipType"));
        paramatmo.iHollywoodVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iHollywoodVipLevel"));
        paramatmo.strShowName = paramCursor.getString(paramCursor.getColumnIndex("strShowName"));
        paramatmo.strVoiceFilekey = paramCursor.getString(paramCursor.getColumnIndex("strVoiceFilekey"));
        paramatmo.shDuration = paramCursor.getShort(paramCursor.getColumnIndex("shDuration"));
        paramatmo.bRead = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bRead")));
        paramatmo.strUrl = paramCursor.getString(paramCursor.getColumnIndex("strUrl"));
        paramatmo.vRichSign = paramCursor.getBlob(paramCursor.getColumnIndex("vRichSign"));
        paramatmo.lSignModifyTime = paramCursor.getLong(paramCursor.getColumnIndex("lSignModifyTime"));
        paramatmo.vLongNickTopicInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vLongNickTopicInfo"));
        paramatmo.nLastGameFlag = paramCursor.getInt(paramCursor.getColumnIndex("nLastGameFlag"));
        paramatmo.strGameLogoUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_1"));
        paramatmo.strGameLogoUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_2"));
        paramatmo.strGameLogoUrl_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_3"));
        paramatmo.strGameLogoUrl_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_4"));
        paramatmo.strGameLogoKey_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_1"));
        paramatmo.strGameLogoKey_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_2"));
        paramatmo.strGameLogoKey_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_3"));
        paramatmo.strGameLogoKey_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_4"));
        paramatmo.strGameName_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_1"));
        paramatmo.strGameName_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_2"));
        paramatmo.strGameName_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_3"));
        paramatmo.strGameName_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_4"));
        paramatmo.strGameAppid_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_1"));
        paramatmo.strGameAppid_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_2"));
        paramatmo.strGameAppid_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_3"));
        paramatmo.strGameAppid_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_4"));
        paramatmo.strProfileUrl = paramCursor.getString(paramCursor.getColumnIndex("strProfileUrl"));
        paramatmo.nStarFansFlag = paramCursor.getInt(paramCursor.getColumnIndex("nStarFansFlag"));
        paramatmo.strStarPicUrl_0 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_0"));
        paramatmo.strStarPicUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_1"));
        paramatmo.strStarPicUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_2"));
        paramatmo.strStarLvUrl_0 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_0"));
        paramatmo.strStarLvUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_1"));
        paramatmo.strStarLvUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_2"));
        paramatmo.strStarLogoUrl = paramCursor.getString(paramCursor.getColumnIndex("strStarLogoUrl"));
        paramatmo.starFansJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("starFansJumpUrl"));
        paramatmo.lUserFlag = paramCursor.getLong(paramCursor.getColumnIndex("lUserFlag"));
        paramatmo.lLoginDays = paramCursor.getLong(paramCursor.getColumnIndex("lLoginDays"));
        paramatmo.strLoginDaysDesc = paramCursor.getString(paramCursor.getColumnIndex("strLoginDaysDesc"));
        paramatmo.lQQMasterLogindays = paramCursor.getLong(paramCursor.getColumnIndex("lQQMasterLogindays"));
        paramatmo.iXManScene1DelayTime = paramCursor.getInt(paramCursor.getColumnIndex("iXManScene1DelayTime"));
        paramatmo.iXManScene2DelayTime = paramCursor.getInt(paramCursor.getColumnIndex("iXManScene2DelayTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowPeopleSee"))) {
          break label4679;
        }
        paramBoolean = true;
        paramatmo.allowPeopleSee = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowCalInteractive"))) {
          break label4684;
        }
        paramBoolean = true;
        label2394:
        paramatmo.allowCalInteractive = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showOnlineFriends"))) {
          break label4689;
        }
        paramBoolean = true;
        label2420:
        paramatmo.showOnlineFriends = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowClick"))) {
          break label4694;
        }
        paramBoolean = true;
        paramatmo.allowClick = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("babyQSwitch"))) {
          break label4699;
        }
        paramBoolean = true;
        paramatmo.babyQSwitch = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showLightalk"))) {
          break label4704;
        }
        paramBoolean = true;
        paramatmo.showLightalk = paramBoolean;
        paramatmo.lightalkNick = paramCursor.getString(paramCursor.getColumnIndex("lightalkNick"));
        paramatmo.lightalkId = paramCursor.getString(paramCursor.getColumnIndex("lightalkId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperRedDiamond"))) {
          break label4709;
        }
        paramBoolean = true;
        paramatmo.isSuperRedDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRedDiamond"))) {
          break label4714;
        }
        paramBoolean = true;
        paramatmo.isRedDiamond = paramBoolean;
        paramatmo.redLevel = paramCursor.getInt(paramCursor.getColumnIndex("redLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperYellowDiamond"))) {
          break label4719;
        }
        paramBoolean = true;
        label2633:
        paramatmo.isSuperYellowDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isYellowDiamond"))) {
          break label4724;
        }
        paramBoolean = true;
        label2659:
        paramatmo.isYellowDiamond = paramBoolean;
        paramatmo.yellowLevel = paramCursor.getInt(paramCursor.getColumnIndex("yellowLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperGreenDiamond"))) {
          break label4729;
        }
        paramBoolean = true;
        paramatmo.isSuperGreenDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isGreenDiamond"))) {
          break label4734;
        }
        paramBoolean = true;
        paramatmo.isGreenDiamond = paramBoolean;
        paramatmo.greenLevel = paramCursor.getInt(paramCursor.getColumnIndex("greenLevel"));
        paramatmo.uAccelerateMultiple = paramCursor.getLong(paramCursor.getColumnIndex("uAccelerateMultiple"));
        paramatmo.strRespMusicInfo = paramCursor.getString(paramCursor.getColumnIndex("strRespMusicInfo"));
        paramatmo.templateRet = paramCursor.getInt(paramCursor.getColumnIndex("templateRet"));
        paramatmo.lCurrentStyleId = paramCursor.getLong(paramCursor.getColumnIndex("lCurrentStyleId"));
        paramatmo.lCurrentBgId = paramCursor.getLong(paramCursor.getColumnIndex("lCurrentBgId"));
        paramatmo.backgroundUrl = paramCursor.getString(paramCursor.getColumnIndex("backgroundUrl"));
        paramatmo.backgroundColor = paramCursor.getLong(paramCursor.getColumnIndex("backgroundColor"));
        paramatmo.dynamicCardFlag = paramCursor.getInt(paramCursor.getColumnIndex("dynamicCardFlag"));
        paramatmo.strZipUrl = paramCursor.getString(paramCursor.getColumnIndex("strZipUrl"));
        paramatmo.strActiveUrl = paramCursor.getString(paramCursor.getColumnIndex("strActiveUrl"));
        paramatmo.strDrawerCardUrl = paramCursor.getString(paramCursor.getColumnIndex("strDrawerCardUrl"));
        paramatmo.strWzryHeroUrl = paramCursor.getString(paramCursor.getColumnIndex("strWzryHeroUrl"));
        paramatmo.wzryHonorInfo = paramCursor.getBlob(paramCursor.getColumnIndex("wzryHonorInfo"));
        paramatmo.strExtInfo = paramCursor.getString(paramCursor.getColumnIndex("strExtInfo"));
        paramatmo.strCurrentBgUrl = paramCursor.getString(paramCursor.getColumnIndex("strCurrentBgUrl"));
        paramatmo.bgType = paramCursor.getBlob(paramCursor.getColumnIndex("bgType"));
        paramatmo.encId = paramCursor.getString(paramCursor.getColumnIndex("encId"));
        paramatmo.busiEntry = paramCursor.getString(paramCursor.getColumnIndex("busiEntry"));
        paramatmo.favoriteSource = paramCursor.getInt(paramCursor.getColumnIndex("favoriteSource"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("visibleMusicPendant"))) {
          break label4739;
        }
        paramBoolean = true;
        paramatmo.visibleMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("autoPlayMusicPendant"))) {
          break label4744;
        }
        paramBoolean = true;
        label3162:
        paramatmo.autoPlayMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showRedPointMusicPendant"))) {
          break label4749;
        }
        paramBoolean = true;
        label3188:
        paramatmo.showRedPointMusicPendant = paramBoolean;
        paramatmo.privilegePromptStr = paramCursor.getString(paramCursor.getColumnIndex("privilegePromptStr"));
        paramatmo.privilegeJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("privilegeJumpUrl"));
        paramatmo.vOpenPriv = paramCursor.getBlob(paramCursor.getColumnIndex("vOpenPriv"));
        paramatmo.vClosePriv = paramCursor.getBlob(paramCursor.getColumnIndex("vClosePriv"));
        paramatmo.presentDesc = paramCursor.getString(paramCursor.getColumnIndex("presentDesc"));
        paramatmo.presentCustourl = paramCursor.getString(paramCursor.getColumnIndex("presentCustourl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("presentSwitch"))) {
          break label4754;
        }
        paramBoolean = true;
        paramatmo.presentSwitch = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showPresent"))) {
          break label4759;
        }
        paramBoolean = true;
        paramatmo.showPresent = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showMusicBox"))) {
          break label4764;
        }
        paramBoolean = true;
        paramatmo.showMusicBox = paramBoolean;
        paramatmo.addSrcName = paramCursor.getString(paramCursor.getColumnIndex("addSrcName"));
        paramatmo.addSrcId = paramCursor.getLong(paramCursor.getColumnIndex("addSrcId"));
        paramatmo.addSubSrcId = paramCursor.getLong(paramCursor.getColumnIndex("addSubSrcId"));
        paramatmo.strVoteLimitedNotice = paramCursor.getString(paramCursor.getColumnIndex("strVoteLimitedNotice"));
        paramatmo.bHaveVotedCnt = paramCursor.getShort(paramCursor.getColumnIndex("bHaveVotedCnt"));
        paramatmo.bAvailVoteCnt = paramCursor.getShort(paramCursor.getColumnIndex("bAvailVoteCnt"));
        paramatmo.olympicTorch = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("olympicTorch")));
        paramatmo.mNowShowFlag = paramCursor.getInt(paramCursor.getColumnIndex("mNowShowFlag"));
        paramatmo.mNowShowIconUrl = paramCursor.getString(paramCursor.getColumnIndex("mNowShowIconUrl"));
        paramatmo.mNowShowJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("mNowShowJumpUrl"));
        paramatmo.vCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vCoverInfo"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("videoHeadFlag"))) {
          break label4769;
        }
        paramBoolean = true;
        paramatmo.videoHeadFlag = paramBoolean;
        paramatmo.videoHeadUrl = paramCursor.getString(paramCursor.getColumnIndex("videoHeadUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("medalSwitchDisable"))) {
          break label4774;
        }
        paramBoolean = true;
        label3661:
        paramatmo.medalSwitchDisable = paramBoolean;
        paramatmo.iMedalCount = paramCursor.getInt(paramCursor.getColumnIndex("iMedalCount"));
        paramatmo.iNewCount = paramCursor.getInt(paramCursor.getColumnIndex("iNewCount"));
        paramatmo.iUpgradeCount = paramCursor.getInt(paramCursor.getColumnIndex("iUpgradeCount"));
        paramatmo.strPromptParams = paramCursor.getString(paramCursor.getColumnIndex("strPromptParams"));
        paramatmo.hobbyEntry = paramCursor.getString(paramCursor.getColumnIndex("hobbyEntry"));
        paramatmo.lastPraiseInfoList = paramCursor.getBlob(paramCursor.getColumnIndex("lastPraiseInfoList"));
        paramatmo.tempChatSig = paramCursor.getBlob(paramCursor.getColumnIndex("tempChatSig"));
        paramatmo.namePlateOfKingGameId = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingGameId"));
        paramatmo.namePlateOfKingLoginTime = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingLoginTime"));
        paramatmo.namePlateOfKingDan = paramCursor.getInt(paramCursor.getColumnIndex("namePlateOfKingDan"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch"))) {
          break label4779;
        }
        paramBoolean = true;
        paramatmo.namePlateOfKingDanDisplatSwitch = paramBoolean;
        paramatmo.vPersonalityLabelV2 = paramCursor.getBlob(paramCursor.getColumnIndex("vPersonalityLabelV2"));
        paramatmo.cardType = paramCursor.getInt(paramCursor.getColumnIndex("cardType"));
        paramatmo.diyText = paramCursor.getString(paramCursor.getColumnIndex("diyText"));
        paramatmo.diyTextFontId = paramCursor.getInt(paramCursor.getColumnIndex("diyTextFontId"));
        paramatmo.diyTextWidth = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextWidth"));
        paramatmo.diyTextHeight = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextHeight"));
        paramatmo.diyTextLocX = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextLocX"));
        paramatmo.diyTextLocY = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextLocY"));
        paramatmo.diyTextDegree = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextDegree"));
        paramatmo.diyTextScale = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextScale"));
        paramatmo.diyTextTransparency = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextTransparency"));
        paramatmo.diyDefaultText = paramCursor.getString(paramCursor.getColumnIndex("diyDefaultText"));
        paramatmo.popularity = paramCursor.getInt(paramCursor.getColumnIndex("popularity"));
        paramatmo.declaration = paramCursor.getString(paramCursor.getColumnIndex("declaration"));
        paramatmo.voiceUrl = paramCursor.getString(paramCursor.getColumnIndex("voiceUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShowCard"))) {
          break label4784;
        }
        paramBoolean = true;
        label4188:
        paramatmo.isShowCard = paramBoolean;
        paramatmo.updateTime = paramCursor.getLong(paramCursor.getColumnIndex("updateTime"));
        paramatmo.extendFriendFlag = paramCursor.getInt(paramCursor.getColumnIndex("extendFriendFlag"));
        paramatmo.extendFriendVoiceDuration = paramCursor.getInt(paramCursor.getColumnIndex("extendFriendVoiceDuration"));
        paramatmo.extendFriendEntryContact = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendEntryContact"));
        paramatmo.extendFriendEntryAddFriend = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendEntryAddFriend"));
        paramatmo.extendFriendQuestion = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendQuestion"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShowMiniPlaying"))) {
          break label4789;
        }
        paramBoolean = true;
        label4328:
        paramatmo.isShowMiniPlaying = paramBoolean;
        paramatmo.tabJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("tabJumpUrl"));
        paramatmo.guestJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("guestJumpUrl"));
        paramatmo.guestAppTotal = paramCursor.getInt(paramCursor.getColumnIndex("guestAppTotal"));
        paramatmo.defaultCardId = paramCursor.getInt(paramCursor.getColumnIndex("defaultCardId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("strangerVoteOpen"))) {
          break label4794;
        }
        paramBoolean = true;
        label4430:
        paramatmo.strangerVoteOpen = paramBoolean;
        paramatmo.lSuperVipTemplateId = paramCursor.getLong(paramCursor.getColumnIndex("lSuperVipTemplateId"));
        paramatmo.bBigClubVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bBigClubVipOpen")));
        paramatmo.iBigClubVipType = paramCursor.getInt(paramCursor.getColumnIndex("iBigClubVipType"));
        paramatmo.iBigClubVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iBigClubVipLevel"));
        paramatmo.lBigClubTemplateId = paramCursor.getLong(paramCursor.getColumnIndex("lBigClubTemplateId"));
        paramatmo.diyComplicatedInfo = paramCursor.getString(paramCursor.getColumnIndex("diyComplicatedInfo"));
        paramatmo.cardId = paramCursor.getLong(paramCursor.getColumnIndex("cardId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("strangerInviteMeGroupOpen"))) {
          break label4799;
        }
        paramBoolean = true;
        label4590:
        paramatmo.strangerInviteMeGroupOpen = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isPrettyGroupOwner"))) {
          break label4804;
        }
        paramBoolean = true;
        paramatmo.isPrettyGroupOwner = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isHidePrettyGroutIdentity"))) {
          break label4809;
        }
      }
      label4679:
      label4809:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramatmo.isHidePrettyGroutIdentity = paramBoolean;
        paramatmo.mQQLevelType = paramCursor.getInt(paramCursor.getColumnIndex("mQQLevelType"));
        return paramatmo;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label1330;
        paramBoolean = false;
        break label2368;
        label4684:
        paramBoolean = false;
        break label2394;
        label4689:
        paramBoolean = false;
        break label2420;
        label4694:
        paramBoolean = false;
        break label2446;
        label4699:
        paramBoolean = false;
        break label2472;
        label4704:
        paramBoolean = false;
        break label2498;
        label4709:
        paramBoolean = false;
        break label2562;
        label4714:
        paramBoolean = false;
        break label2588;
        label4719:
        paramBoolean = false;
        break label2633;
        label4724:
        paramBoolean = false;
        break label2659;
        label4729:
        paramBoolean = false;
        break label2704;
        label4734:
        paramBoolean = false;
        break label2730;
        paramBoolean = false;
        break label3136;
        paramBoolean = false;
        break label3162;
        paramBoolean = false;
        break label3188;
        paramBoolean = false;
        break label3328;
        paramBoolean = false;
        break label3354;
        paramBoolean = false;
        break label3380;
        paramBoolean = false;
        break label3616;
        paramBoolean = false;
        break label3661;
        paramBoolean = false;
        break label3877;
        paramBoolean = false;
        break label4188;
        paramBoolean = false;
        break label4328;
        paramBoolean = false;
        break label4430;
        paramBoolean = false;
        break label4590;
        paramBoolean = false;
        break label4616;
      }
    }
    label2446:
    label2472:
    label2730:
    label3136:
    label4674:
    int i = paramCursor.getColumnIndex("uin");
    label2562:
    label2588:
    label3380:
    label4789:
    label4794:
    label4799:
    if (i == -1)
    {
      paramatmz.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("strNick");
      if (i != -1) {
        break label13459;
      }
      paramatmz.a(new NoColumnError("strNick", String.class));
      i = paramCursor.getColumnIndex("shGender");
      if (i != -1) {
        break label13474;
      }
      paramatmz.a(new NoColumnError("shGender", Short.TYPE));
      i = paramCursor.getColumnIndex("shAge");
      if (i != -1) {
        break label13489;
      }
      paramatmz.a(new NoColumnError("shAge", Short.TYPE));
      label4954:
      i = paramCursor.getColumnIndex("nFaceID");
      if (i != -1) {
        break label13504;
      }
      paramatmz.a(new NoColumnError("nFaceID", Integer.TYPE));
      label4989:
      i = paramCursor.getColumnIndex("strCertificationInfo");
      if (i != -1) {
        break label13519;
      }
      paramatmz.a(new NoColumnError("strCertificationInfo", String.class));
      i = paramCursor.getColumnIndex("shType");
      if (i != -1) {
        break label13534;
      }
      paramatmz.a(new NoColumnError("shType", Short.TYPE));
      label5059:
      i = paramCursor.getColumnIndex("vContent");
      if (i != -1) {
        break label13549;
      }
      paramatmz.a(new NoColumnError("vContent", [B.class));
      label5094:
      i = paramCursor.getColumnIndex("strSign");
      if (i != -1) {
        break label13564;
      }
      paramatmz.a(new NoColumnError("strSign", String.class));
      i = paramCursor.getColumnIndex("strCompany");
      if (i != -1) {
        break label13579;
      }
      paramatmz.a(new NoColumnError("strCompany", String.class));
      i = paramCursor.getColumnIndex("strSchool");
      if (i != -1) {
        break label13594;
      }
      paramatmz.a(new NoColumnError("strSchool", String.class));
      label5199:
      i = paramCursor.getColumnIndex("uFaceTimeStamp");
      if (i != -1) {
        break label13609;
      }
      paramatmz.a(new NoColumnError("uFaceTimeStamp", Integer.TYPE));
      label5234:
      i = paramCursor.getColumnIndex("vQQFaceID");
      if (i != -1) {
        break label13624;
      }
      paramatmz.a(new NoColumnError("vQQFaceID", [B.class));
      i = paramCursor.getColumnIndex("strReMark");
      if (i != -1) {
        break label13639;
      }
      paramatmz.a(new NoColumnError("strReMark", String.class));
      i = paramCursor.getColumnIndex("bWeiboInfo");
      if (i != -1) {
        break label13654;
      }
      paramatmz.a(new NoColumnError("bWeiboInfo", Byte.TYPE));
      label5339:
      i = paramCursor.getColumnIndex("bQzoneInfo");
      if (i != -1) {
        break label13670;
      }
      paramatmz.a(new NoColumnError("bQzoneInfo", Byte.TYPE));
      label5374:
      i = paramCursor.getColumnIndex("nSameFriendsNum");
      if (i != -1) {
        break label13686;
      }
      paramatmz.a(new NoColumnError("nSameFriendsNum", Integer.TYPE));
      i = paramCursor.getColumnIndex("strCompanySame");
      if (i != -1) {
        break label13701;
      }
      paramatmz.a(new NoColumnError("strCompanySame", String.class));
      label5444:
      i = paramCursor.getColumnIndex("strSchoolSame");
      if (i != -1) {
        break label13716;
      }
      paramatmz.a(new NoColumnError("strSchoolSame", String.class));
      label5479:
      i = paramCursor.getColumnIndex("lCardShowNum");
      if (i != -1) {
        break label13731;
      }
      paramatmz.a(new NoColumnError("lCardShowNum", Long.TYPE));
      i = paramCursor.getColumnIndex("bSingle");
      if (i != -1) {
        break label13746;
      }
      paramatmz.a(new NoColumnError("bSingle", Byte.TYPE));
      i = paramCursor.getColumnIndex("lVisitCount");
      if (i != -1) {
        break label13762;
      }
      paramatmz.a(new NoColumnError("lVisitCount", Long.TYPE));
      label5584:
      i = paramCursor.getColumnIndex("lVoteCount");
      if (i != -1) {
        break label13777;
      }
      paramatmz.a(new NoColumnError("lVoteCount", Long.TYPE));
      label5619:
      i = paramCursor.getColumnIndex("tagInfosByte");
      if (i != -1) {
        break label13792;
      }
      paramatmz.a(new NoColumnError("tagInfosByte", [B.class));
      i = paramCursor.getColumnIndex("eUserIdentityType");
      if (i != -1) {
        break label13807;
      }
      paramatmz.a(new NoColumnError("eUserIdentityType", Byte.TYPE));
      i = paramCursor.getColumnIndex("vBackground");
      if (i != -1) {
        break label13823;
      }
      paramatmz.a(new NoColumnError("vBackground", [B.class));
      label5724:
      i = paramCursor.getColumnIndex("labelInfoBytes");
      if (i != -1) {
        break label13838;
      }
      paramatmz.a(new NoColumnError("labelInfoBytes", [B.class));
      label5759:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label13853;
      }
      paramatmz.a(new NoColumnError("age", Byte.TYPE));
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label13869;
      }
      paramatmz.a(new NoColumnError("constellation", Integer.TYPE));
      label5829:
      i = paramCursor.getColumnIndex("pyFaceUrl");
      if (i != -1) {
        break label13884;
      }
      paramatmz.a(new NoColumnError("pyFaceUrl", String.class));
      label5864:
      i = paramCursor.getColumnIndex("location");
      if (i != -1) {
        break label13899;
      }
      paramatmz.a(new NoColumnError("location", String.class));
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label13914;
      }
      paramatmz.a(new NoColumnError("bVoted", Byte.TYPE));
      i = paramCursor.getColumnIndex("bFavorited");
      if (i != -1) {
        break label13930;
      }
      paramatmz.a(new NoColumnError("bFavorited", Byte.TYPE));
      label5969:
      i = paramCursor.getColumnIndex("iVoteIncrement");
      if (i != -1) {
        break label13946;
      }
      paramatmz.a(new NoColumnError("iVoteIncrement", Integer.TYPE));
      label6004:
      i = paramCursor.getColumnIndex("strJoinHexAlbumFileKey");
      if (i != -1) {
        break label13961;
      }
      paramatmz.a(new NoColumnError("strJoinHexAlbumFileKey", String.class));
      i = paramCursor.getColumnIndex("iFaceNum");
      if (i != -1) {
        break label13976;
      }
      paramatmz.a(new NoColumnError("iFaceNum", Integer.TYPE));
      i = paramCursor.getColumnIndex("cSqqLevel");
      if (i != -1) {
        break label13991;
      }
      paramatmz.a(new NoColumnError("cSqqLevel", Byte.TYPE));
      label6109:
      i = paramCursor.getColumnIndex("iQQLevel");
      if (i != -1) {
        break label14007;
      }
      paramatmz.a(new NoColumnError("iQQLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("uCurMulType");
      if (i != -1) {
        break label14022;
      }
      paramatmz.a(new NoColumnError("uCurMulType", Long.TYPE));
      i = paramCursor.getColumnIndex("strProvince");
      if (i != -1) {
        break label14037;
      }
      paramatmz.a(new NoColumnError("strProvince", String.class));
      label6214:
      i = paramCursor.getColumnIndex("strCity");
      if (i != -1) {
        break label14052;
      }
      paramatmz.a(new NoColumnError("strCity", String.class));
      label6249:
      i = paramCursor.getColumnIndex("strCountry");
      if (i != -1) {
        break label14067;
      }
      paramatmz.a(new NoColumnError("strCountry", String.class));
      i = paramCursor.getColumnIndex("lBirthday");
      if (i != -1) {
        break label14082;
      }
      paramatmz.a(new NoColumnError("lBirthday", Long.TYPE));
      i = paramCursor.getColumnIndex("strLocationCodes");
      if (i != -1) {
        break label14097;
      }
      paramatmz.a(new NoColumnError("strLocationCodes", String.class));
      label6354:
      i = paramCursor.getColumnIndex("strLocationDesc");
      if (i != -1) {
        break label14112;
      }
      paramatmz.a(new NoColumnError("strLocationDesc", String.class));
      label6389:
      i = paramCursor.getColumnIndex("strHometownCodes");
      if (i != -1) {
        break label14127;
      }
      paramatmz.a(new NoColumnError("strHometownCodes", String.class));
      i = paramCursor.getColumnIndex("strHometownDesc");
      if (i != -1) {
        break label14142;
      }
      paramatmz.a(new NoColumnError("strHometownDesc", String.class));
      i = paramCursor.getColumnIndex("strEmail");
      if (i != -1) {
        break label14157;
      }
      paramatmz.a(new NoColumnError("strEmail", String.class));
      label6494:
      i = paramCursor.getColumnIndex("strPersonalNote");
      if (i != -1) {
        break label14172;
      }
      paramatmz.a(new NoColumnError("strPersonalNote", String.class));
      i = paramCursor.getColumnIndex("iProfession");
      if (i != -1) {
        break label14187;
      }
      paramatmz.a(new NoColumnError("iProfession", Integer.TYPE));
      i = paramCursor.getColumnIndex("bindPhoneInfo");
      if (i != -1) {
        break label14202;
      }
      paramatmz.a(new NoColumnError("bindPhoneInfo", String.class));
      label6599:
      i = paramCursor.getColumnIndex("bCardInfo");
      if (i != -1) {
        break label14217;
      }
      paramatmz.a(new NoColumnError("bCardInfo", [B.class));
      label6634:
      i = paramCursor.getColumnIndex("strTroopName");
      if (i != -1) {
        break label14232;
      }
      paramatmz.a(new NoColumnError("strTroopName", String.class));
      i = paramCursor.getColumnIndex("strTroopNick");
      if (i != -1) {
        break label14247;
      }
      paramatmz.a(new NoColumnError("strTroopNick", String.class));
      i = paramCursor.getColumnIndex("strMobile");
      if (i != -1) {
        break label14262;
      }
      paramatmz.a(new NoColumnError("strMobile", String.class));
      label6745:
      i = paramCursor.getColumnIndex("strContactName");
      if (i != -1) {
        break label14277;
      }
      paramatmz.a(new NoColumnError("strContactName", String.class));
      label6782:
      i = paramCursor.getColumnIndex("ulShowControl");
      if (i != -1) {
        break label14292;
      }
      paramatmz.a(new NoColumnError("ulShowControl", Integer.TYPE));
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label14307;
      }
      paramatmz.a(new NoColumnError("feedPreviewTime", Long.TYPE));
      label6856:
      i = paramCursor.getColumnIndex("strQzoneFeedsDesc");
      if (i != -1) {
        break label14322;
      }
      paramatmz.a(new NoColumnError("strQzoneFeedsDesc", String.class));
      label6893:
      i = paramCursor.getColumnIndex("StrPresentDesc");
      if (i != -1) {
        break label14337;
      }
      paramatmz.a(new NoColumnError("StrPresentDesc", String.class));
      i = paramCursor.getColumnIndex("strSpaceName");
      if (i != -1) {
        break label14352;
      }
      paramatmz.a(new NoColumnError("strSpaceName", String.class));
      i = paramCursor.getColumnIndex("strQzoneHeader");
      if (i != -1) {
        break label14367;
      }
      paramatmz.a(new NoColumnError("strQzoneHeader", String.class));
      label7004:
      i = paramCursor.getColumnIndex("vQzonePhotos");
      if (i != -1) {
        break label14382;
      }
      paramatmz.a(new NoColumnError("vQzonePhotos", [B.class));
      i = paramCursor.getColumnIndex("vQzoneCoverInfo");
      if (i != -1) {
        break label14397;
      }
      paramatmz.a(new NoColumnError("vQzoneCoverInfo", [B.class));
      i = paramCursor.getColumnIndex("enlargeQzonePic");
      if (i != -1) {
        break label14412;
      }
      paramatmz.a(new NoColumnError("enlargeQzonePic", Integer.TYPE));
      label7115:
      i = paramCursor.getColumnIndex("showPublishButton");
      if (i != -1) {
        break label14427;
      }
      paramatmz.a(new NoColumnError("showPublishButton", Boolean.TYPE));
      i = paramCursor.getColumnIndex("strStatus");
      if (i != -1) {
        break label14454;
      }
      paramatmz.a(new NoColumnError("strStatus", String.class));
      i = paramCursor.getColumnIndex("strAutoRemark");
      if (i != -1) {
        break label14469;
      }
      paramatmz.a(new NoColumnError("strAutoRemark", String.class));
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label14484;
      }
      paramatmz.a(new NoColumnError("vSeed", [B.class));
      label7263:
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label14499;
      }
      paramatmz.a(new NoColumnError("vCookies", [B.class));
      i = paramCursor.getColumnIndex("hasFakeData");
      if (i != -1) {
        break label14514;
      }
      paramatmz.a(new NoColumnError("hasFakeData", Boolean.TYPE));
      i = paramCursor.getColumnIndex("bQQVipOpen");
      if (i != -1) {
        break label14541;
      }
      paramatmz.a(new NoColumnError("bQQVipOpen", Byte.TYPE));
      label7374:
      i = paramCursor.getColumnIndex("iQQVipType");
      if (i != -1) {
        break label14557;
      }
      paramatmz.a(new NoColumnError("iQQVipType", Integer.TYPE));
      label7411:
      i = paramCursor.getColumnIndex("iQQVipLevel");
      if (i != -1) {
        break label14572;
      }
      paramatmz.a(new NoColumnError("iQQVipLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("bSuperVipOpen");
      if (i != -1) {
        break label14587;
      }
      paramatmz.a(new NoColumnError("bSuperVipOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iSuperVipType");
      if (i != -1) {
        break label14603;
      }
      paramatmz.a(new NoColumnError("iSuperVipType", Integer.TYPE));
      label7522:
      i = paramCursor.getColumnIndex("iSuperVipLevel");
      if (i != -1) {
        break label14618;
      }
      paramatmz.a(new NoColumnError("iSuperVipLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("bSuperQQOpen");
      if (i != -1) {
        break label14633;
      }
      paramatmz.a(new NoColumnError("bSuperQQOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iSuperQQType");
      if (i != -1) {
        break label14649;
      }
      paramatmz.a(new NoColumnError("iSuperQQType", Integer.TYPE));
      label7633:
      i = paramCursor.getColumnIndex("iSuperQQLevel");
      if (i != -1) {
        break label14664;
      }
      paramatmz.a(new NoColumnError("iSuperQQLevel", Integer.TYPE));
      label7670:
      i = paramCursor.getColumnIndex("bHollywoodVipOpen");
      if (i != -1) {
        break label14679;
      }
      paramatmz.a(new NoColumnError("bHollywoodVipOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iHollywoodVipType");
      if (i != -1) {
        break label14695;
      }
      paramatmz.a(new NoColumnError("iHollywoodVipType", Integer.TYPE));
      label7744:
      i = paramCursor.getColumnIndex("iHollywoodVipLevel");
      if (i != -1) {
        break label14710;
      }
      paramatmz.a(new NoColumnError("iHollywoodVipLevel", Integer.TYPE));
      label7781:
      i = paramCursor.getColumnIndex("strShowName");
      if (i != -1) {
        break label14725;
      }
      paramatmz.a(new NoColumnError("strShowName", String.class));
      i = paramCursor.getColumnIndex("strVoiceFilekey");
      if (i != -1) {
        break label14740;
      }
      paramatmz.a(new NoColumnError("strVoiceFilekey", String.class));
      i = paramCursor.getColumnIndex("shDuration");
      if (i != -1) {
        break label14755;
      }
      paramatmz.a(new NoColumnError("shDuration", Short.TYPE));
      label7892:
      i = paramCursor.getColumnIndex("bRead");
      if (i != -1) {
        break label14770;
      }
      paramatmz.a(new NoColumnError("bRead", Byte.TYPE));
      label7929:
      i = paramCursor.getColumnIndex("strUrl");
      if (i != -1) {
        break label14786;
      }
      paramatmz.a(new NoColumnError("strUrl", String.class));
      i = paramCursor.getColumnIndex("vRichSign");
      if (i != -1) {
        break label14801;
      }
      paramatmz.a(new NoColumnError("vRichSign", [B.class));
      label8003:
      i = paramCursor.getColumnIndex("lSignModifyTime");
      if (i != -1) {
        break label14816;
      }
      paramatmz.a(new NoColumnError("lSignModifyTime", Long.TYPE));
      label8040:
      i = paramCursor.getColumnIndex("vLongNickTopicInfo");
      if (i != -1) {
        break label14831;
      }
      paramatmz.a(new NoColumnError("vLongNickTopicInfo", [B.class));
      i = paramCursor.getColumnIndex("nLastGameFlag");
      if (i != -1) {
        break label14846;
      }
      paramatmz.a(new NoColumnError("nLastGameFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("strGameLogoUrl_1");
      if (i != -1) {
        break label14861;
      }
      paramatmz.a(new NoColumnError("strGameLogoUrl_1", String.class));
      label8151:
      i = paramCursor.getColumnIndex("strGameLogoUrl_2");
      if (i != -1) {
        break label14876;
      }
      paramatmz.a(new NoColumnError("strGameLogoUrl_2", String.class));
      label8188:
      i = paramCursor.getColumnIndex("strGameLogoUrl_3");
      if (i != -1) {
        break label14891;
      }
      paramatmz.a(new NoColumnError("strGameLogoUrl_3", String.class));
      i = paramCursor.getColumnIndex("strGameLogoUrl_4");
      if (i != -1) {
        break label14906;
      }
      paramatmz.a(new NoColumnError("strGameLogoUrl_4", String.class));
      label8262:
      i = paramCursor.getColumnIndex("strGameLogoKey_1");
      if (i != -1) {
        break label14921;
      }
      paramatmz.a(new NoColumnError("strGameLogoKey_1", String.class));
      label8299:
      i = paramCursor.getColumnIndex("strGameLogoKey_2");
      if (i != -1) {
        break label14936;
      }
      paramatmz.a(new NoColumnError("strGameLogoKey_2", String.class));
      i = paramCursor.getColumnIndex("strGameLogoKey_3");
      if (i != -1) {
        break label14951;
      }
      paramatmz.a(new NoColumnError("strGameLogoKey_3", String.class));
      i = paramCursor.getColumnIndex("strGameLogoKey_4");
      if (i != -1) {
        break label14966;
      }
      paramatmz.a(new NoColumnError("strGameLogoKey_4", String.class));
      label8410:
      i = paramCursor.getColumnIndex("strGameName_1");
      if (i != -1) {
        break label14981;
      }
      paramatmz.a(new NoColumnError("strGameName_1", String.class));
      label8447:
      i = paramCursor.getColumnIndex("strGameName_2");
      if (i != -1) {
        break label14996;
      }
      paramatmz.a(new NoColumnError("strGameName_2", String.class));
      i = paramCursor.getColumnIndex("strGameName_3");
      if (i != -1) {
        break label15011;
      }
      paramatmz.a(new NoColumnError("strGameName_3", String.class));
      label8521:
      i = paramCursor.getColumnIndex("strGameName_4");
      if (i != -1) {
        break label15026;
      }
      paramatmz.a(new NoColumnError("strGameName_4", String.class));
      label8558:
      i = paramCursor.getColumnIndex("strGameAppid_1");
      if (i != -1) {
        break label15041;
      }
      paramatmz.a(new NoColumnError("strGameAppid_1", String.class));
      i = paramCursor.getColumnIndex("strGameAppid_2");
      if (i != -1) {
        break label15056;
      }
      paramatmz.a(new NoColumnError("strGameAppid_2", String.class));
      i = paramCursor.getColumnIndex("strGameAppid_3");
      if (i != -1) {
        break label15071;
      }
      paramatmz.a(new NoColumnError("strGameAppid_3", String.class));
      label8669:
      i = paramCursor.getColumnIndex("strGameAppid_4");
      if (i != -1) {
        break label15086;
      }
      paramatmz.a(new NoColumnError("strGameAppid_4", String.class));
      i = paramCursor.getColumnIndex("strProfileUrl");
      if (i != -1) {
        break label15101;
      }
      paramatmz.a(new NoColumnError("strProfileUrl", String.class));
      i = paramCursor.getColumnIndex("nStarFansFlag");
      if (i != -1) {
        break label15116;
      }
      paramatmz.a(new NoColumnError("nStarFansFlag", Integer.TYPE));
      label8780:
      i = paramCursor.getColumnIndex("strStarPicUrl_0");
      if (i != -1) {
        break label15131;
      }
      paramatmz.a(new NoColumnError("strStarPicUrl_0", String.class));
      label8817:
      i = paramCursor.getColumnIndex("strStarPicUrl_1");
      if (i != -1) {
        break label15146;
      }
      paramatmz.a(new NoColumnError("strStarPicUrl_1", String.class));
      i = paramCursor.getColumnIndex("strStarPicUrl_2");
      if (i != -1) {
        break label15161;
      }
      paramatmz.a(new NoColumnError("strStarPicUrl_2", String.class));
      i = paramCursor.getColumnIndex("strStarLvUrl_0");
      if (i != -1) {
        break label15176;
      }
      paramatmz.a(new NoColumnError("strStarLvUrl_0", String.class));
      label8928:
      i = paramCursor.getColumnIndex("strStarLvUrl_1");
      if (i != -1) {
        break label15191;
      }
      paramatmz.a(new NoColumnError("strStarLvUrl_1", String.class));
      i = paramCursor.getColumnIndex("strStarLvUrl_2");
      if (i != -1) {
        break label15206;
      }
      paramatmz.a(new NoColumnError("strStarLvUrl_2", String.class));
      i = paramCursor.getColumnIndex("strStarLogoUrl");
      if (i != -1) {
        break label15221;
      }
      paramatmz.a(new NoColumnError("strStarLogoUrl", String.class));
      label9039:
      i = paramCursor.getColumnIndex("starFansJumpUrl");
      if (i != -1) {
        break label15236;
      }
      paramatmz.a(new NoColumnError("starFansJumpUrl", String.class));
      label9076:
      i = paramCursor.getColumnIndex("lUserFlag");
      if (i != -1) {
        break label15251;
      }
      paramatmz.a(new NoColumnError("lUserFlag", Long.TYPE));
      i = paramCursor.getColumnIndex("lLoginDays");
      if (i != -1) {
        break label15266;
      }
      paramatmz.a(new NoColumnError("lLoginDays", Long.TYPE));
      i = paramCursor.getColumnIndex("strLoginDaysDesc");
      if (i != -1) {
        break label15281;
      }
      paramatmz.a(new NoColumnError("strLoginDaysDesc", String.class));
      label9187:
      i = paramCursor.getColumnIndex("lQQMasterLogindays");
      if (i != -1) {
        break label15296;
      }
      paramatmz.a(new NoColumnError("lQQMasterLogindays", Long.TYPE));
      i = paramCursor.getColumnIndex("iXManScene1DelayTime");
      if (i != -1) {
        break label15311;
      }
      paramatmz.a(new NoColumnError("iXManScene1DelayTime", Integer.TYPE));
      i = paramCursor.getColumnIndex("iXManScene2DelayTime");
      if (i != -1) {
        break label15326;
      }
      paramatmz.a(new NoColumnError("iXManScene2DelayTime", Integer.TYPE));
      label9298:
      i = paramCursor.getColumnIndex("allowPeopleSee");
      if (i != -1) {
        break label15341;
      }
      paramatmz.a(new NoColumnError("allowPeopleSee", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowCalInteractive");
      if (i != -1) {
        break label15368;
      }
      paramatmz.a(new NoColumnError("allowCalInteractive", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showOnlineFriends");
      if (i != -1) {
        break label15395;
      }
      paramatmz.a(new NoColumnError("showOnlineFriends", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowClick");
      if (i != -1) {
        break label15422;
      }
      paramatmz.a(new NoColumnError("allowClick", Boolean.TYPE));
      i = paramCursor.getColumnIndex("babyQSwitch");
      if (i != -1) {
        break label15449;
      }
      paramatmz.a(new NoColumnError("babyQSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showLightalk");
      if (i != -1) {
        break label15476;
      }
      paramatmz.a(new NoColumnError("showLightalk", Boolean.TYPE));
      i = paramCursor.getColumnIndex("lightalkNick");
      if (i != -1) {
        break label15503;
      }
      paramatmz.a(new NoColumnError("lightalkNick", String.class));
      label9557:
      i = paramCursor.getColumnIndex("lightalkId");
      if (i != -1) {
        break label15518;
      }
      paramatmz.a(new NoColumnError("lightalkId", String.class));
      label9594:
      i = paramCursor.getColumnIndex("isSuperRedDiamond");
      if (i != -1) {
        break label15533;
      }
      paramatmz.a(new NoColumnError("isSuperRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRedDiamond");
      if (i != -1) {
        break label15560;
      }
      paramatmz.a(new NoColumnError("isRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("redLevel");
      if (i != -1) {
        break label15587;
      }
      paramatmz.a(new NoColumnError("redLevel", Integer.TYPE));
      label9705:
      i = paramCursor.getColumnIndex("isSuperYellowDiamond");
      if (i != -1) {
        break label15602;
      }
      paramatmz.a(new NoColumnError("isSuperYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isYellowDiamond");
      if (i != -1) {
        break label15629;
      }
      paramatmz.a(new NoColumnError("isYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("yellowLevel");
      if (i != -1) {
        break label15656;
      }
      paramatmz.a(new NoColumnError("yellowLevel", Integer.TYPE));
      label9816:
      i = paramCursor.getColumnIndex("isSuperGreenDiamond");
      if (i != -1) {
        break label15671;
      }
      paramatmz.a(new NoColumnError("isSuperGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isGreenDiamond");
      if (i != -1) {
        break label15698;
      }
      paramatmz.a(new NoColumnError("isGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("greenLevel");
      if (i != -1) {
        break label15725;
      }
      paramatmz.a(new NoColumnError("greenLevel", Integer.TYPE));
      label9927:
      i = paramCursor.getColumnIndex("uAccelerateMultiple");
      if (i != -1) {
        break label15740;
      }
      paramatmz.a(new NoColumnError("uAccelerateMultiple", Long.TYPE));
      label9964:
      i = paramCursor.getColumnIndex("strRespMusicInfo");
      if (i != -1) {
        break label15755;
      }
      paramatmz.a(new NoColumnError("strRespMusicInfo", String.class));
      i = paramCursor.getColumnIndex("templateRet");
      if (i != -1) {
        break label15770;
      }
      paramatmz.a(new NoColumnError("templateRet", Integer.TYPE));
      i = paramCursor.getColumnIndex("lCurrentStyleId");
      if (i != -1) {
        break label15785;
      }
      paramatmz.a(new NoColumnError("lCurrentStyleId", Long.TYPE));
      label10075:
      i = paramCursor.getColumnIndex("lCurrentBgId");
      if (i != -1) {
        break label15800;
      }
      paramatmz.a(new NoColumnError("lCurrentBgId", Long.TYPE));
      i = paramCursor.getColumnIndex("backgroundUrl");
      if (i != -1) {
        break label15815;
      }
      paramatmz.a(new NoColumnError("backgroundUrl", String.class));
      i = paramCursor.getColumnIndex("backgroundColor");
      if (i != -1) {
        break label15830;
      }
      paramatmz.a(new NoColumnError("backgroundColor", Long.TYPE));
      label10186:
      i = paramCursor.getColumnIndex("dynamicCardFlag");
      if (i != -1) {
        break label15845;
      }
      paramatmz.a(new NoColumnError("dynamicCardFlag", Integer.TYPE));
      label10223:
      i = paramCursor.getColumnIndex("strZipUrl");
      if (i != -1) {
        break label15860;
      }
      paramatmz.a(new NoColumnError("strZipUrl", String.class));
      i = paramCursor.getColumnIndex("strActiveUrl");
      if (i != -1) {
        break label15875;
      }
      paramatmz.a(new NoColumnError("strActiveUrl", String.class));
      i = paramCursor.getColumnIndex("strDrawerCardUrl");
      if (i != -1) {
        break label15890;
      }
      paramatmz.a(new NoColumnError("strDrawerCardUrl", String.class));
      label10334:
      i = paramCursor.getColumnIndex("strWzryHeroUrl");
      if (i != -1) {
        break label15905;
      }
      paramatmz.a(new NoColumnError("strWzryHeroUrl", String.class));
      i = paramCursor.getColumnIndex("wzryHonorInfo");
      if (i != -1) {
        break label15920;
      }
      paramatmz.a(new NoColumnError("wzryHonorInfo", [B.class));
      i = paramCursor.getColumnIndex("strExtInfo");
      if (i != -1) {
        break label15935;
      }
      paramatmz.a(new NoColumnError("strExtInfo", String.class));
      label10445:
      i = paramCursor.getColumnIndex("strCurrentBgUrl");
      if (i != -1) {
        break label15950;
      }
      paramatmz.a(new NoColumnError("strCurrentBgUrl", String.class));
      label10482:
      i = paramCursor.getColumnIndex("bgType");
      if (i != -1) {
        break label15965;
      }
      paramatmz.a(new NoColumnError("bgType", [B.class));
      i = paramCursor.getColumnIndex("encId");
      if (i != -1) {
        break label15980;
      }
      paramatmz.a(new NoColumnError("encId", String.class));
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label15995;
      }
      paramatmz.a(new NoColumnError("busiEntry", String.class));
      label10593:
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label16010;
      }
      paramatmz.a(new NoColumnError("favoriteSource", Integer.TYPE));
      i = paramCursor.getColumnIndex("visibleMusicPendant");
      if (i != -1) {
        break label16025;
      }
      paramatmz.a(new NoColumnError("visibleMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("autoPlayMusicPendant");
      if (i != -1) {
        break label16052;
      }
      paramatmz.a(new NoColumnError("autoPlayMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showRedPointMusicPendant");
      if (i != -1) {
        break label16079;
      }
      paramatmz.a(new NoColumnError("showRedPointMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("privilegePromptStr");
      if (i != -1) {
        break label16106;
      }
      paramatmz.a(new NoColumnError("privilegePromptStr", String.class));
      i = paramCursor.getColumnIndex("privilegeJumpUrl");
      if (i != -1) {
        break label16121;
      }
      paramatmz.a(new NoColumnError("privilegeJumpUrl", String.class));
      label10815:
      i = paramCursor.getColumnIndex("vOpenPriv");
      if (i != -1) {
        break label16136;
      }
      paramatmz.a(new NoColumnError("vOpenPriv", [B.class));
      label10852:
      i = paramCursor.getColumnIndex("vClosePriv");
      if (i != -1) {
        break label16151;
      }
      paramatmz.a(new NoColumnError("vClosePriv", [B.class));
      i = paramCursor.getColumnIndex("presentDesc");
      if (i != -1) {
        break label16166;
      }
      paramatmz.a(new NoColumnError("presentDesc", String.class));
      i = paramCursor.getColumnIndex("presentCustourl");
      if (i != -1) {
        break label16181;
      }
      paramatmz.a(new NoColumnError("presentCustourl", String.class));
      label10963:
      i = paramCursor.getColumnIndex("presentSwitch");
      if (i != -1) {
        break label16196;
      }
      paramatmz.a(new NoColumnError("presentSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showPresent");
      if (i != -1) {
        break label16223;
      }
      paramatmz.a(new NoColumnError("showPresent", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showMusicBox");
      if (i != -1) {
        break label16250;
      }
      paramatmz.a(new NoColumnError("showMusicBox", Boolean.TYPE));
      i = paramCursor.getColumnIndex("addSrcName");
      if (i != -1) {
        break label16277;
      }
      paramatmz.a(new NoColumnError("addSrcName", String.class));
      label11111:
      i = paramCursor.getColumnIndex("addSrcId");
      if (i != -1) {
        break label16292;
      }
      paramatmz.a(new NoColumnError("addSrcId", Long.TYPE));
      i = paramCursor.getColumnIndex("addSubSrcId");
      if (i != -1) {
        break label16307;
      }
      paramatmz.a(new NoColumnError("addSubSrcId", Long.TYPE));
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label16322;
      }
      paramatmz.a(new NoColumnError("strVoteLimitedNotice", String.class));
      label11222:
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label16337;
      }
      paramatmz.a(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      label11259:
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label16352;
      }
      paramatmz.a(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      i = paramCursor.getColumnIndex("olympicTorch");
      if (i != -1) {
        break label16367;
      }
      paramatmz.a(new NoColumnError("olympicTorch", Byte.TYPE));
      label11333:
      i = paramCursor.getColumnIndex("mNowShowFlag");
      if (i != -1) {
        break label16383;
      }
      paramatmz.a(new NoColumnError("mNowShowFlag", Integer.TYPE));
      label11370:
      i = paramCursor.getColumnIndex("mNowShowIconUrl");
      if (i != -1) {
        break label16398;
      }
      paramatmz.a(new NoColumnError("mNowShowIconUrl", String.class));
      i = paramCursor.getColumnIndex("mNowShowJumpUrl");
      if (i != -1) {
        break label16413;
      }
      paramatmz.a(new NoColumnError("mNowShowJumpUrl", String.class));
      i = paramCursor.getColumnIndex("vCoverInfo");
      if (i != -1) {
        break label16428;
      }
      paramatmz.a(new NoColumnError("vCoverInfo", [B.class));
      label11481:
      i = paramCursor.getColumnIndex("videoHeadFlag");
      if (i != -1) {
        break label16443;
      }
      paramatmz.a(new NoColumnError("videoHeadFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("videoHeadUrl");
      if (i != -1) {
        break label16470;
      }
      paramatmz.a(new NoColumnError("videoHeadUrl", String.class));
      i = paramCursor.getColumnIndex("medalSwitchDisable");
      if (i != -1) {
        break label16485;
      }
      paramatmz.a(new NoColumnError("medalSwitchDisable", Boolean.TYPE));
      i = paramCursor.getColumnIndex("iMedalCount");
      if (i != -1) {
        break label16512;
      }
      paramatmz.a(new NoColumnError("iMedalCount", Integer.TYPE));
      label11629:
      i = paramCursor.getColumnIndex("iNewCount");
      if (i != -1) {
        break label16527;
      }
      paramatmz.a(new NoColumnError("iNewCount", Integer.TYPE));
      i = paramCursor.getColumnIndex("iUpgradeCount");
      if (i != -1) {
        break label16542;
      }
      paramatmz.a(new NoColumnError("iUpgradeCount", Integer.TYPE));
      i = paramCursor.getColumnIndex("strPromptParams");
      if (i != -1) {
        break label16557;
      }
      paramatmz.a(new NoColumnError("strPromptParams", String.class));
      label11740:
      i = paramCursor.getColumnIndex("hobbyEntry");
      if (i != -1) {
        break label16572;
      }
      paramatmz.a(new NoColumnError("hobbyEntry", String.class));
      i = paramCursor.getColumnIndex("lastPraiseInfoList");
      if (i != -1) {
        break label16587;
      }
      paramatmz.a(new NoColumnError("lastPraiseInfoList", [B.class));
      i = paramCursor.getColumnIndex("tempChatSig");
      if (i != -1) {
        break label16602;
      }
      paramatmz.a(new NoColumnError("tempChatSig", [B.class));
      label11851:
      i = paramCursor.getColumnIndex("namePlateOfKingGameId");
      if (i != -1) {
        break label16617;
      }
      paramatmz.a(new NoColumnError("namePlateOfKingGameId", Long.TYPE));
      label11888:
      i = paramCursor.getColumnIndex("namePlateOfKingLoginTime");
      if (i != -1) {
        break label16632;
      }
      paramatmz.a(new NoColumnError("namePlateOfKingLoginTime", Long.TYPE));
      i = paramCursor.getColumnIndex("namePlateOfKingDan");
      if (i != -1) {
        break label16647;
      }
      paramatmz.a(new NoColumnError("namePlateOfKingDan", Integer.TYPE));
      i = paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch");
      if (i != -1) {
        break label16662;
      }
      paramatmz.a(new NoColumnError("namePlateOfKingDanDisplatSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("vPersonalityLabelV2");
      if (i != -1) {
        break label16689;
      }
      paramatmz.a(new NoColumnError("vPersonalityLabelV2", [B.class));
      i = paramCursor.getColumnIndex("cardType");
      if (i != -1) {
        break label16704;
      }
      paramatmz.a(new NoColumnError("cardType", Integer.TYPE));
      i = paramCursor.getColumnIndex("diyText");
      if (i != -1) {
        break label16719;
      }
      paramatmz.a(new NoColumnError("diyText", String.class));
      label12110:
      i = paramCursor.getColumnIndex("diyTextFontId");
      if (i != -1) {
        break label16734;
      }
      paramatmz.a(new NoColumnError("diyTextFontId", Integer.TYPE));
      label12147:
      i = paramCursor.getColumnIndex("diyTextWidth");
      if (i != -1) {
        break label16749;
      }
      paramatmz.a(new NoColumnError("diyTextWidth", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextHeight");
      if (i != -1) {
        break label16764;
      }
      paramatmz.a(new NoColumnError("diyTextHeight", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextLocX");
      if (i != -1) {
        break label16779;
      }
      paramatmz.a(new NoColumnError("diyTextLocX", Float.TYPE));
      label12258:
      i = paramCursor.getColumnIndex("diyTextLocY");
      if (i != -1) {
        break label16794;
      }
      paramatmz.a(new NoColumnError("diyTextLocY", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextDegree");
      if (i != -1) {
        break label16809;
      }
      paramatmz.a(new NoColumnError("diyTextDegree", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextScale");
      if (i != -1) {
        break label16824;
      }
      paramatmz.a(new NoColumnError("diyTextScale", Float.TYPE));
      label12369:
      i = paramCursor.getColumnIndex("diyTextTransparency");
      if (i != -1) {
        break label16839;
      }
      paramatmz.a(new NoColumnError("diyTextTransparency", Float.TYPE));
      label12406:
      i = paramCursor.getColumnIndex("diyDefaultText");
      if (i != -1) {
        break label16854;
      }
      paramatmz.a(new NoColumnError("diyDefaultText", String.class));
      i = paramCursor.getColumnIndex("popularity");
      if (i != -1) {
        break label16869;
      }
      paramatmz.a(new NoColumnError("popularity", Integer.TYPE));
      label12480:
      i = paramCursor.getColumnIndex("declaration");
      if (i != -1) {
        break label16884;
      }
      paramatmz.a(new NoColumnError("declaration", String.class));
      label12517:
      i = paramCursor.getColumnIndex("voiceUrl");
      if (i != -1) {
        break label16899;
      }
      paramatmz.a(new NoColumnError("voiceUrl", String.class));
      i = paramCursor.getColumnIndex("isShowCard");
      if (i != -1) {
        break label16914;
      }
      paramatmz.a(new NoColumnError("isShowCard", Boolean.TYPE));
      i = paramCursor.getColumnIndex("updateTime");
      if (i != -1) {
        break label16941;
      }
      paramatmz.a(new NoColumnError("updateTime", Long.TYPE));
      label12628:
      i = paramCursor.getColumnIndex("extendFriendFlag");
      if (i != -1) {
        break label16956;
      }
      paramatmz.a(new NoColumnError("extendFriendFlag", Integer.TYPE));
      label12665:
      i = paramCursor.getColumnIndex("extendFriendVoiceDuration");
      if (i != -1) {
        break label16971;
      }
      paramatmz.a(new NoColumnError("extendFriendVoiceDuration", Integer.TYPE));
      i = paramCursor.getColumnIndex("extendFriendEntryContact");
      if (i != -1) {
        break label16986;
      }
      paramatmz.a(new NoColumnError("extendFriendEntryContact", Short.TYPE));
      label12739:
      i = paramCursor.getColumnIndex("extendFriendEntryAddFriend");
      if (i != -1) {
        break label17001;
      }
      paramatmz.a(new NoColumnError("extendFriendEntryAddFriend", Short.TYPE));
      label12776:
      i = paramCursor.getColumnIndex("extendFriendQuestion");
      if (i != -1) {
        break label17016;
      }
      paramatmz.a(new NoColumnError("extendFriendQuestion", Short.TYPE));
      i = paramCursor.getColumnIndex("isShowMiniPlaying");
      if (i != -1) {
        break label17031;
      }
      paramatmz.a(new NoColumnError("isShowMiniPlaying", Boolean.TYPE));
      i = paramCursor.getColumnIndex("tabJumpUrl");
      if (i != -1) {
        break label17058;
      }
      paramatmz.a(new NoColumnError("tabJumpUrl", String.class));
      label12887:
      i = paramCursor.getColumnIndex("guestJumpUrl");
      if (i != -1) {
        break label17073;
      }
      paramatmz.a(new NoColumnError("guestJumpUrl", String.class));
      label12924:
      i = paramCursor.getColumnIndex("guestAppTotal");
      if (i != -1) {
        break label17088;
      }
      paramatmz.a(new NoColumnError("guestAppTotal", Integer.TYPE));
      i = paramCursor.getColumnIndex("defaultCardId");
      if (i != -1) {
        break label17103;
      }
      paramatmz.a(new NoColumnError("defaultCardId", Integer.TYPE));
      label12998:
      i = paramCursor.getColumnIndex("strangerVoteOpen");
      if (i != -1) {
        break label17118;
      }
      paramatmz.a(new NoColumnError("strangerVoteOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("lSuperVipTemplateId");
      if (i != -1) {
        break label17145;
      }
      paramatmz.a(new NoColumnError("lSuperVipTemplateId", Long.TYPE));
      i = paramCursor.getColumnIndex("bBigClubVipOpen");
      if (i != -1) {
        break label17160;
      }
      paramatmz.a(new NoColumnError("bBigClubVipOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iBigClubVipType");
      if (i != -1) {
        break label17176;
      }
      paramatmz.a(new NoColumnError("iBigClubVipType", Integer.TYPE));
      label13146:
      i = paramCursor.getColumnIndex("iBigClubVipLevel");
      if (i != -1) {
        break label17191;
      }
      paramatmz.a(new NoColumnError("iBigClubVipLevel", Integer.TYPE));
      label13183:
      i = paramCursor.getColumnIndex("lBigClubTemplateId");
      if (i != -1) {
        break label17206;
      }
      paramatmz.a(new NoColumnError("lBigClubTemplateId", Long.TYPE));
      i = paramCursor.getColumnIndex("diyComplicatedInfo");
      if (i != -1) {
        break label17221;
      }
      paramatmz.a(new NoColumnError("diyComplicatedInfo", String.class));
      label13257:
      i = paramCursor.getColumnIndex("cardId");
      if (i != -1) {
        break label17236;
      }
      paramatmz.a(new NoColumnError("cardId", Long.TYPE));
    }
    for (;;)
    {
      label2704:
      label3354:
      label3616:
      label3877:
      label4774:
      label4779:
      label4784:
      label4919:
      label5304:
      label5689:
      label6074:
      label6459:
      label7485:
      label9150:
      i = paramCursor.getColumnIndex("strangerInviteMeGroupOpen");
      label3328:
      label4616:
      label4749:
      label4754:
      label4759:
      label4764:
      label4769:
      label5164:
      label5549:
      label5934:
      label6319:
      label6708:
      label6967:
      label7226:
      label8891:
      label10556:
      label12221:
      if (i != -1) {
        break label17251;
      }
      label4739:
      label4744:
      label4884:
      label5024:
      label5409:
      label5794:
      label6179:
      label6564:
      label7078:
      label7596:
      label7855:
      label8114:
      label8373:
      label8632:
      label10297:
      label11962:
      paramatmz.a(new NoColumnError("strangerInviteMeGroupOpen", Boolean.TYPE));
      label5129:
      label5269:
      label5654:
      label6039:
      label6424:
      label6819:
      label8484:
      label8743:
      label9002:
      label9261:
      label10038:
      label11703:
      i = paramCursor.getColumnIndex("isPrettyGroupOwner");
      label5514:
      label5899:
      label6284:
      label6671:
      label6930:
      label7189:
      label7448:
      label7707:
      label7966:
      label8225:
      label10149:
      label10408:
      label10926:
      label11185:
      label11444:
      label13109:
      if (i != -1) {
        break label17278;
      }
      label6144:
      label6529:
      label7300:
      label7559:
      label7818:
      label8077:
      label8336:
      label8595:
      label8854:
      label9113:
      label10778:
      label11296:
      label11555:
      label11814:
      label12073:
      label12332:
      paramatmz.a(new NoColumnError("isPrettyGroupOwner", Boolean.TYPE));
      label7041:
      label8706:
      label8965:
      label9224:
      label10001:
      label10260:
      label10519:
      label12184:
      label12443:
      label12702:
      label12961:
      label13220:
      i = paramCursor.getColumnIndex("isHidePrettyGroutIdentity");
      label10112:
      label10371:
      label10630:
      label10889:
      label11148:
      label11407:
      label11666:
      label11925:
      if (i != -1) {
        break label17305;
      }
      label11777:
      label12036:
      label12295:
      label12554:
      label12813:
      label13072:
      paramatmz.a(new NoColumnError("isHidePrettyGroutIdentity", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mQQLevelType");
      if (i != -1) {
        break label17333;
      }
      paramatmz.a(new NoColumnError("mQQLevelType", Integer.TYPE));
      return paramatmo;
      paramatmo.uin = paramCursor.getString(i);
      break;
      label13459:
      paramatmo.strNick = paramCursor.getString(i);
      break label4884;
      label13474:
      paramatmo.shGender = paramCursor.getShort(i);
      break label4919;
      label13489:
      paramatmo.shAge = paramCursor.getShort(i);
      break label4954;
      label13504:
      paramatmo.nFaceID = paramCursor.getInt(i);
      break label4989;
      label13519:
      paramatmo.strCertificationInfo = paramCursor.getString(i);
      break label5024;
      label13534:
      paramatmo.shType = paramCursor.getShort(i);
      break label5059;
      label13549:
      paramatmo.vContent = paramCursor.getBlob(i);
      break label5094;
      label13564:
      paramatmo.strSign = paramCursor.getString(i);
      break label5129;
      label13579:
      paramatmo.strCompany = paramCursor.getString(i);
      break label5164;
      label13594:
      paramatmo.strSchool = paramCursor.getString(i);
      break label5199;
      label13609:
      paramatmo.uFaceTimeStamp = paramCursor.getInt(i);
      break label5234;
      label13624:
      paramatmo.vQQFaceID = paramCursor.getBlob(i);
      break label5269;
      label13639:
      paramatmo.strReMark = paramCursor.getString(i);
      break label5304;
      label13654:
      paramatmo.bWeiboInfo = ((byte)paramCursor.getShort(i));
      break label5339;
      label13670:
      paramatmo.bQzoneInfo = ((byte)paramCursor.getShort(i));
      break label5374;
      label13686:
      paramatmo.nSameFriendsNum = paramCursor.getInt(i);
      break label5409;
      label13701:
      paramatmo.strCompanySame = paramCursor.getString(i);
      break label5444;
      label13716:
      paramatmo.strSchoolSame = paramCursor.getString(i);
      break label5479;
      label13731:
      paramatmo.lCardShowNum = paramCursor.getLong(i);
      break label5514;
      label13746:
      paramatmo.bSingle = ((byte)paramCursor.getShort(i));
      break label5549;
      label13762:
      paramatmo.lVisitCount = paramCursor.getLong(i);
      break label5584;
      label13777:
      paramatmo.lVoteCount = paramCursor.getLong(i);
      break label5619;
      label13792:
      paramatmo.tagInfosByte = paramCursor.getBlob(i);
      break label5654;
      label13807:
      paramatmo.eUserIdentityType = ((byte)paramCursor.getShort(i));
      break label5689;
      label13823:
      paramatmo.vBackground = paramCursor.getBlob(i);
      break label5724;
      label13838:
      paramatmo.labelInfoBytes = paramCursor.getBlob(i);
      break label5759;
      label13853:
      paramatmo.age = ((byte)paramCursor.getShort(i));
      break label5794;
      label13869:
      paramatmo.constellation = paramCursor.getInt(i);
      break label5829;
      label13884:
      paramatmo.pyFaceUrl = paramCursor.getString(i);
      break label5864;
      label13899:
      paramatmo.location = paramCursor.getString(i);
      break label5899;
      label13914:
      paramatmo.bVoted = ((byte)paramCursor.getShort(i));
      break label5934;
      label13930:
      paramatmo.bFavorited = ((byte)paramCursor.getShort(i));
      break label5969;
      label13946:
      paramatmo.iVoteIncrement = paramCursor.getInt(i);
      break label6004;
      label13961:
      paramatmo.strJoinHexAlbumFileKey = paramCursor.getString(i);
      break label6039;
      label13976:
      paramatmo.iFaceNum = paramCursor.getInt(i);
      break label6074;
      label13991:
      paramatmo.cSqqLevel = ((byte)paramCursor.getShort(i));
      break label6109;
      label14007:
      paramatmo.iQQLevel = paramCursor.getInt(i);
      break label6144;
      label14022:
      paramatmo.uCurMulType = paramCursor.getLong(i);
      break label6179;
      label14037:
      paramatmo.strProvince = paramCursor.getString(i);
      break label6214;
      label14052:
      paramatmo.strCity = paramCursor.getString(i);
      break label6249;
      label14067:
      paramatmo.strCountry = paramCursor.getString(i);
      break label6284;
      label14082:
      paramatmo.lBirthday = paramCursor.getLong(i);
      break label6319;
      label14097:
      paramatmo.strLocationCodes = paramCursor.getString(i);
      break label6354;
      label14112:
      paramatmo.strLocationDesc = paramCursor.getString(i);
      break label6389;
      label14127:
      paramatmo.strHometownCodes = paramCursor.getString(i);
      break label6424;
      label14142:
      paramatmo.strHometownDesc = paramCursor.getString(i);
      break label6459;
      label14157:
      paramatmo.strEmail = paramCursor.getString(i);
      break label6494;
      label14172:
      paramatmo.strPersonalNote = paramCursor.getString(i);
      break label6529;
      label14187:
      paramatmo.iProfession = paramCursor.getInt(i);
      break label6564;
      label14202:
      paramatmo.bindPhoneInfo = paramCursor.getString(i);
      break label6599;
      label14217:
      paramatmo.bCardInfo = paramCursor.getBlob(i);
      break label6634;
      label14232:
      paramatmo.strTroopName = paramCursor.getString(i);
      break label6671;
      label14247:
      paramatmo.strTroopNick = paramCursor.getString(i);
      break label6708;
      label14262:
      paramatmo.strMobile = paramCursor.getString(i);
      break label6745;
      label14277:
      paramatmo.strContactName = paramCursor.getString(i);
      break label6782;
      label14292:
      paramatmo.ulShowControl = paramCursor.getInt(i);
      break label6819;
      label14307:
      paramatmo.feedPreviewTime = paramCursor.getLong(i);
      break label6856;
      label14322:
      paramatmo.strQzoneFeedsDesc = paramCursor.getString(i);
      break label6893;
      label14337:
      paramatmo.StrPresentDesc = paramCursor.getString(i);
      break label6930;
      label14352:
      paramatmo.strSpaceName = paramCursor.getString(i);
      break label6967;
      label14367:
      paramatmo.strQzoneHeader = paramCursor.getString(i);
      break label7004;
      label14382:
      paramatmo.vQzonePhotos = paramCursor.getBlob(i);
      break label7041;
      label14397:
      paramatmo.vQzoneCoverInfo = paramCursor.getBlob(i);
      break label7078;
      label14412:
      paramatmo.enlargeQzonePic = paramCursor.getInt(i);
      break label7115;
      label14427:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.showPublishButton = paramBoolean;
        break;
      }
      label14454:
      paramatmo.strStatus = paramCursor.getString(i);
      break label7189;
      label14469:
      paramatmo.strAutoRemark = paramCursor.getString(i);
      break label7226;
      label14484:
      paramatmo.vSeed = paramCursor.getBlob(i);
      break label7263;
      label14499:
      paramatmo.vCookies = paramCursor.getBlob(i);
      break label7300;
      label14514:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.hasFakeData = paramBoolean;
        break;
      }
      label14541:
      paramatmo.bQQVipOpen = ((byte)paramCursor.getShort(i));
      break label7374;
      label14557:
      paramatmo.iQQVipType = paramCursor.getInt(i);
      break label7411;
      label14572:
      paramatmo.iQQVipLevel = paramCursor.getInt(i);
      break label7448;
      label14587:
      paramatmo.bSuperVipOpen = ((byte)paramCursor.getShort(i));
      break label7485;
      label14603:
      paramatmo.iSuperVipType = paramCursor.getInt(i);
      break label7522;
      label14618:
      paramatmo.iSuperVipLevel = paramCursor.getInt(i);
      break label7559;
      label14633:
      paramatmo.bSuperQQOpen = ((byte)paramCursor.getShort(i));
      break label7596;
      label14649:
      paramatmo.iSuperQQType = paramCursor.getInt(i);
      break label7633;
      label14664:
      paramatmo.iSuperQQLevel = paramCursor.getInt(i);
      break label7670;
      label14679:
      paramatmo.bHollywoodVipOpen = ((byte)paramCursor.getShort(i));
      break label7707;
      label14695:
      paramatmo.iHollywoodVipType = paramCursor.getInt(i);
      break label7744;
      label14710:
      paramatmo.iHollywoodVipLevel = paramCursor.getInt(i);
      break label7781;
      label14725:
      paramatmo.strShowName = paramCursor.getString(i);
      break label7818;
      label14740:
      paramatmo.strVoiceFilekey = paramCursor.getString(i);
      break label7855;
      label14755:
      paramatmo.shDuration = paramCursor.getShort(i);
      break label7892;
      label14770:
      paramatmo.bRead = ((byte)paramCursor.getShort(i));
      break label7929;
      label14786:
      paramatmo.strUrl = paramCursor.getString(i);
      break label7966;
      label14801:
      paramatmo.vRichSign = paramCursor.getBlob(i);
      break label8003;
      label14816:
      paramatmo.lSignModifyTime = paramCursor.getLong(i);
      break label8040;
      label14831:
      paramatmo.vLongNickTopicInfo = paramCursor.getBlob(i);
      break label8077;
      label14846:
      paramatmo.nLastGameFlag = paramCursor.getInt(i);
      break label8114;
      label14861:
      paramatmo.strGameLogoUrl_1 = paramCursor.getString(i);
      break label8151;
      label14876:
      paramatmo.strGameLogoUrl_2 = paramCursor.getString(i);
      break label8188;
      label14891:
      paramatmo.strGameLogoUrl_3 = paramCursor.getString(i);
      break label8225;
      label14906:
      paramatmo.strGameLogoUrl_4 = paramCursor.getString(i);
      break label8262;
      label14921:
      paramatmo.strGameLogoKey_1 = paramCursor.getString(i);
      break label8299;
      label14936:
      paramatmo.strGameLogoKey_2 = paramCursor.getString(i);
      break label8336;
      label14951:
      paramatmo.strGameLogoKey_3 = paramCursor.getString(i);
      break label8373;
      label14966:
      paramatmo.strGameLogoKey_4 = paramCursor.getString(i);
      break label8410;
      label14981:
      paramatmo.strGameName_1 = paramCursor.getString(i);
      break label8447;
      label14996:
      paramatmo.strGameName_2 = paramCursor.getString(i);
      break label8484;
      label15011:
      paramatmo.strGameName_3 = paramCursor.getString(i);
      break label8521;
      label15026:
      paramatmo.strGameName_4 = paramCursor.getString(i);
      break label8558;
      label15041:
      paramatmo.strGameAppid_1 = paramCursor.getString(i);
      break label8595;
      label15056:
      paramatmo.strGameAppid_2 = paramCursor.getString(i);
      break label8632;
      label15071:
      paramatmo.strGameAppid_3 = paramCursor.getString(i);
      break label8669;
      label15086:
      paramatmo.strGameAppid_4 = paramCursor.getString(i);
      break label8706;
      label15101:
      paramatmo.strProfileUrl = paramCursor.getString(i);
      break label8743;
      label15116:
      paramatmo.nStarFansFlag = paramCursor.getInt(i);
      break label8780;
      label15131:
      paramatmo.strStarPicUrl_0 = paramCursor.getString(i);
      break label8817;
      label15146:
      paramatmo.strStarPicUrl_1 = paramCursor.getString(i);
      break label8854;
      label15161:
      paramatmo.strStarPicUrl_2 = paramCursor.getString(i);
      break label8891;
      label15176:
      paramatmo.strStarLvUrl_0 = paramCursor.getString(i);
      break label8928;
      label15191:
      paramatmo.strStarLvUrl_1 = paramCursor.getString(i);
      break label8965;
      label15206:
      paramatmo.strStarLvUrl_2 = paramCursor.getString(i);
      break label9002;
      label15221:
      paramatmo.strStarLogoUrl = paramCursor.getString(i);
      break label9039;
      label15236:
      paramatmo.starFansJumpUrl = paramCursor.getString(i);
      break label9076;
      label15251:
      paramatmo.lUserFlag = paramCursor.getLong(i);
      break label9113;
      label15266:
      paramatmo.lLoginDays = paramCursor.getLong(i);
      break label9150;
      label15281:
      paramatmo.strLoginDaysDesc = paramCursor.getString(i);
      break label9187;
      label15296:
      paramatmo.lQQMasterLogindays = paramCursor.getLong(i);
      break label9224;
      label15311:
      paramatmo.iXManScene1DelayTime = paramCursor.getInt(i);
      break label9261;
      label15326:
      paramatmo.iXManScene2DelayTime = paramCursor.getInt(i);
      break label9298;
      label15341:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.allowPeopleSee = paramBoolean;
        break;
      }
      label15368:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.allowCalInteractive = paramBoolean;
        break;
      }
      label15395:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.showOnlineFriends = paramBoolean;
        break;
      }
      label15422:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.allowClick = paramBoolean;
        break;
      }
      label15449:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.babyQSwitch = paramBoolean;
        break;
      }
      label15476:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.showLightalk = paramBoolean;
        break;
      }
      label15503:
      paramatmo.lightalkNick = paramCursor.getString(i);
      break label9557;
      label15518:
      paramatmo.lightalkId = paramCursor.getString(i);
      break label9594;
      label15533:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isSuperRedDiamond = paramBoolean;
        break;
      }
      label15560:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isRedDiamond = paramBoolean;
        break;
      }
      label15587:
      paramatmo.redLevel = paramCursor.getInt(i);
      break label9705;
      label15602:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isSuperYellowDiamond = paramBoolean;
        break;
      }
      label15629:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isYellowDiamond = paramBoolean;
        break;
      }
      label15656:
      paramatmo.yellowLevel = paramCursor.getInt(i);
      break label9816;
      label15671:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isSuperGreenDiamond = paramBoolean;
        break;
      }
      label15698:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isGreenDiamond = paramBoolean;
        break;
      }
      label15725:
      paramatmo.greenLevel = paramCursor.getInt(i);
      break label9927;
      label15740:
      paramatmo.uAccelerateMultiple = paramCursor.getLong(i);
      break label9964;
      label15755:
      paramatmo.strRespMusicInfo = paramCursor.getString(i);
      break label10001;
      label15770:
      paramatmo.templateRet = paramCursor.getInt(i);
      break label10038;
      label15785:
      paramatmo.lCurrentStyleId = paramCursor.getLong(i);
      break label10075;
      label15800:
      paramatmo.lCurrentBgId = paramCursor.getLong(i);
      break label10112;
      label15815:
      paramatmo.backgroundUrl = paramCursor.getString(i);
      break label10149;
      label15830:
      paramatmo.backgroundColor = paramCursor.getLong(i);
      break label10186;
      label15845:
      paramatmo.dynamicCardFlag = paramCursor.getInt(i);
      break label10223;
      label15860:
      paramatmo.strZipUrl = paramCursor.getString(i);
      break label10260;
      label15875:
      paramatmo.strActiveUrl = paramCursor.getString(i);
      break label10297;
      label15890:
      paramatmo.strDrawerCardUrl = paramCursor.getString(i);
      break label10334;
      label15905:
      paramatmo.strWzryHeroUrl = paramCursor.getString(i);
      break label10371;
      label15920:
      paramatmo.wzryHonorInfo = paramCursor.getBlob(i);
      break label10408;
      label15935:
      paramatmo.strExtInfo = paramCursor.getString(i);
      break label10445;
      label15950:
      paramatmo.strCurrentBgUrl = paramCursor.getString(i);
      break label10482;
      label15965:
      paramatmo.bgType = paramCursor.getBlob(i);
      break label10519;
      label15980:
      paramatmo.encId = paramCursor.getString(i);
      break label10556;
      label15995:
      paramatmo.busiEntry = paramCursor.getString(i);
      break label10593;
      label16010:
      paramatmo.favoriteSource = paramCursor.getInt(i);
      break label10630;
      label16025:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.visibleMusicPendant = paramBoolean;
        break;
      }
      label16052:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.autoPlayMusicPendant = paramBoolean;
        break;
      }
      label16079:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.showRedPointMusicPendant = paramBoolean;
        break;
      }
      label16106:
      paramatmo.privilegePromptStr = paramCursor.getString(i);
      break label10778;
      label16121:
      paramatmo.privilegeJumpUrl = paramCursor.getString(i);
      break label10815;
      label16136:
      paramatmo.vOpenPriv = paramCursor.getBlob(i);
      break label10852;
      label16151:
      paramatmo.vClosePriv = paramCursor.getBlob(i);
      break label10889;
      label16166:
      paramatmo.presentDesc = paramCursor.getString(i);
      break label10926;
      label16181:
      paramatmo.presentCustourl = paramCursor.getString(i);
      break label10963;
      label16196:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.presentSwitch = paramBoolean;
        break;
      }
      label16223:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.showPresent = paramBoolean;
        break;
      }
      label16250:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.showMusicBox = paramBoolean;
        break;
      }
      label16277:
      paramatmo.addSrcName = paramCursor.getString(i);
      break label11111;
      label16292:
      paramatmo.addSrcId = paramCursor.getLong(i);
      break label11148;
      label16307:
      paramatmo.addSubSrcId = paramCursor.getLong(i);
      break label11185;
      label16322:
      paramatmo.strVoteLimitedNotice = paramCursor.getString(i);
      break label11222;
      label16337:
      paramatmo.bHaveVotedCnt = paramCursor.getShort(i);
      break label11259;
      label16352:
      paramatmo.bAvailVoteCnt = paramCursor.getShort(i);
      break label11296;
      label16367:
      paramatmo.olympicTorch = ((byte)paramCursor.getShort(i));
      break label11333;
      label16383:
      paramatmo.mNowShowFlag = paramCursor.getInt(i);
      break label11370;
      label16398:
      paramatmo.mNowShowIconUrl = paramCursor.getString(i);
      break label11407;
      label16413:
      paramatmo.mNowShowJumpUrl = paramCursor.getString(i);
      break label11444;
      label16428:
      paramatmo.vCoverInfo = paramCursor.getBlob(i);
      break label11481;
      label16443:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.videoHeadFlag = paramBoolean;
        break;
      }
      label16470:
      paramatmo.videoHeadUrl = paramCursor.getString(i);
      break label11555;
      label16485:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.medalSwitchDisable = paramBoolean;
        break;
      }
      label16512:
      paramatmo.iMedalCount = paramCursor.getInt(i);
      break label11629;
      label16527:
      paramatmo.iNewCount = paramCursor.getInt(i);
      break label11666;
      label16542:
      paramatmo.iUpgradeCount = paramCursor.getInt(i);
      break label11703;
      label16557:
      paramatmo.strPromptParams = paramCursor.getString(i);
      break label11740;
      label16572:
      paramatmo.hobbyEntry = paramCursor.getString(i);
      break label11777;
      label16587:
      paramatmo.lastPraiseInfoList = paramCursor.getBlob(i);
      break label11814;
      label16602:
      paramatmo.tempChatSig = paramCursor.getBlob(i);
      break label11851;
      label16617:
      paramatmo.namePlateOfKingGameId = paramCursor.getLong(i);
      break label11888;
      label16632:
      paramatmo.namePlateOfKingLoginTime = paramCursor.getLong(i);
      break label11925;
      label16647:
      paramatmo.namePlateOfKingDan = paramCursor.getInt(i);
      break label11962;
      label16662:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.namePlateOfKingDanDisplatSwitch = paramBoolean;
        break;
      }
      label16689:
      paramatmo.vPersonalityLabelV2 = paramCursor.getBlob(i);
      break label12036;
      label16704:
      paramatmo.cardType = paramCursor.getInt(i);
      break label12073;
      label16719:
      paramatmo.diyText = paramCursor.getString(i);
      break label12110;
      label16734:
      paramatmo.diyTextFontId = paramCursor.getInt(i);
      break label12147;
      label16749:
      paramatmo.diyTextWidth = paramCursor.getFloat(i);
      break label12184;
      label16764:
      paramatmo.diyTextHeight = paramCursor.getFloat(i);
      break label12221;
      label16779:
      paramatmo.diyTextLocX = paramCursor.getFloat(i);
      break label12258;
      label16794:
      paramatmo.diyTextLocY = paramCursor.getFloat(i);
      break label12295;
      label16809:
      paramatmo.diyTextDegree = paramCursor.getFloat(i);
      break label12332;
      label16824:
      paramatmo.diyTextScale = paramCursor.getFloat(i);
      break label12369;
      label16839:
      paramatmo.diyTextTransparency = paramCursor.getFloat(i);
      break label12406;
      label16854:
      paramatmo.diyDefaultText = paramCursor.getString(i);
      break label12443;
      label16869:
      paramatmo.popularity = paramCursor.getInt(i);
      break label12480;
      label16884:
      paramatmo.declaration = paramCursor.getString(i);
      break label12517;
      label16899:
      paramatmo.voiceUrl = paramCursor.getString(i);
      break label12554;
      label16914:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isShowCard = paramBoolean;
        break;
      }
      label16941:
      paramatmo.updateTime = paramCursor.getLong(i);
      break label12628;
      label16956:
      paramatmo.extendFriendFlag = paramCursor.getInt(i);
      break label12665;
      label16971:
      paramatmo.extendFriendVoiceDuration = paramCursor.getInt(i);
      break label12702;
      label16986:
      paramatmo.extendFriendEntryContact = paramCursor.getShort(i);
      break label12739;
      label17001:
      paramatmo.extendFriendEntryAddFriend = paramCursor.getShort(i);
      break label12776;
      label17016:
      paramatmo.extendFriendQuestion = paramCursor.getShort(i);
      break label12813;
      label17031:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isShowMiniPlaying = paramBoolean;
        break;
      }
      label17058:
      paramatmo.tabJumpUrl = paramCursor.getString(i);
      break label12887;
      label17073:
      paramatmo.guestJumpUrl = paramCursor.getString(i);
      break label12924;
      label17088:
      paramatmo.guestAppTotal = paramCursor.getInt(i);
      break label12961;
      label17103:
      paramatmo.defaultCardId = paramCursor.getInt(i);
      break label12998;
      label17118:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.strangerVoteOpen = paramBoolean;
        break;
      }
      label17145:
      paramatmo.lSuperVipTemplateId = paramCursor.getLong(i);
      break label13072;
      label17160:
      paramatmo.bBigClubVipOpen = ((byte)paramCursor.getShort(i));
      break label13109;
      label17176:
      paramatmo.iBigClubVipType = paramCursor.getInt(i);
      break label13146;
      label17191:
      paramatmo.iBigClubVipLevel = paramCursor.getInt(i);
      break label13183;
      label17206:
      paramatmo.lBigClubTemplateId = paramCursor.getLong(i);
      break label13220;
      label17221:
      paramatmo.diyComplicatedInfo = paramCursor.getString(i);
      break label13257;
      label17236:
      paramatmo.cardId = paramCursor.getLong(i);
    }
    label17251:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramatmo.strangerInviteMeGroupOpen = paramBoolean;
      break;
    }
    label17278:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramatmo.isPrettyGroupOwner = paramBoolean;
      break;
    }
    label17305:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramatmo.isHidePrettyGroutIdentity = paramBoolean;
      break;
    }
    label17333:
    paramatmo.mQQLevelType = paramCursor.getInt(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,strNick TEXT ,shGender INTEGER ,shAge INTEGER ,nFaceID INTEGER ,strCertificationInfo TEXT ,shType INTEGER ,vContent BLOB ,strSign TEXT ,strCompany TEXT ,strSchool TEXT ,uFaceTimeStamp INTEGER ,vQQFaceID BLOB ,strReMark TEXT ,bWeiboInfo INTEGER ,bQzoneInfo INTEGER ,nSameFriendsNum INTEGER ,strCompanySame TEXT ,strSchoolSame TEXT ,lCardShowNum INTEGER ,bSingle INTEGER ,lVisitCount INTEGER ,lVoteCount INTEGER ,tagInfosByte BLOB ,eUserIdentityType INTEGER ,vBackground BLOB ,labelInfoBytes BLOB ,age INTEGER ,constellation INTEGER ,pyFaceUrl TEXT ,location TEXT ,bVoted INTEGER ,bFavorited INTEGER ,iVoteIncrement INTEGER ,strJoinHexAlbumFileKey TEXT ,iFaceNum INTEGER ,cSqqLevel INTEGER ,iQQLevel INTEGER ,uCurMulType INTEGER ,strProvince TEXT ,strCity TEXT ,strCountry TEXT ,lBirthday INTEGER ,strLocationCodes TEXT ,strLocationDesc TEXT ,strHometownCodes TEXT ,strHometownDesc TEXT ,strEmail TEXT ,strPersonalNote TEXT ,iProfession INTEGER ,bindPhoneInfo TEXT ,bCardInfo BLOB ,strTroopName TEXT ,strTroopNick TEXT ,strMobile TEXT ,strContactName TEXT ,ulShowControl INTEGER ,feedPreviewTime INTEGER ,strQzoneFeedsDesc TEXT ,StrPresentDesc TEXT ,strSpaceName TEXT ,strQzoneHeader TEXT ,vQzonePhotos BLOB ,vQzoneCoverInfo BLOB ,enlargeQzonePic INTEGER ,showPublishButton INTEGER ,strStatus TEXT ,strAutoRemark TEXT ,vSeed BLOB ,vCookies BLOB ,hasFakeData INTEGER ,bQQVipOpen INTEGER ,iQQVipType INTEGER ,iQQVipLevel INTEGER ,bSuperVipOpen INTEGER ,iSuperVipType INTEGER ,iSuperVipLevel INTEGER ,bSuperQQOpen INTEGER ,iSuperQQType INTEGER ,iSuperQQLevel INTEGER ,bHollywoodVipOpen INTEGER ,iHollywoodVipType INTEGER ,iHollywoodVipLevel INTEGER ,strShowName TEXT ,strVoiceFilekey TEXT ,shDuration INTEGER ,bRead INTEGER ,strUrl TEXT ,vRichSign BLOB ,lSignModifyTime INTEGER ,vLongNickTopicInfo BLOB ,nLastGameFlag INTEGER ,strGameLogoUrl_1 TEXT ,strGameLogoUrl_2 TEXT ,strGameLogoUrl_3 TEXT ,strGameLogoUrl_4 TEXT ,strGameLogoKey_1 TEXT ,strGameLogoKey_2 TEXT ,strGameLogoKey_3 TEXT ,strGameLogoKey_4 TEXT ,strGameName_1 TEXT ,strGameName_2 TEXT ,strGameName_3 TEXT ,strGameName_4 TEXT ,strGameAppid_1 TEXT ,strGameAppid_2 TEXT ,strGameAppid_3 TEXT ,strGameAppid_4 TEXT ,strProfileUrl TEXT ,nStarFansFlag INTEGER ,strStarPicUrl_0 TEXT ,strStarPicUrl_1 TEXT ,strStarPicUrl_2 TEXT ,strStarLvUrl_0 TEXT ,strStarLvUrl_1 TEXT ,strStarLvUrl_2 TEXT ,strStarLogoUrl TEXT ,starFansJumpUrl TEXT ,lUserFlag INTEGER ,lLoginDays INTEGER ,strLoginDaysDesc TEXT ,lQQMasterLogindays INTEGER ,iXManScene1DelayTime INTEGER ,iXManScene2DelayTime INTEGER ,allowPeopleSee INTEGER ,allowCalInteractive INTEGER ,showOnlineFriends INTEGER ,allowClick INTEGER ,babyQSwitch INTEGER ,showLightalk INTEGER ,lightalkNick TEXT ,lightalkId TEXT ,isSuperRedDiamond INTEGER ,isRedDiamond INTEGER ,redLevel INTEGER ,isSuperYellowDiamond INTEGER ,isYellowDiamond INTEGER ,yellowLevel INTEGER ,isSuperGreenDiamond INTEGER ,isGreenDiamond INTEGER ,greenLevel INTEGER ,uAccelerateMultiple INTEGER ,strRespMusicInfo TEXT ,templateRet INTEGER ,lCurrentStyleId INTEGER ,lCurrentBgId INTEGER ,backgroundUrl TEXT ,backgroundColor INTEGER ,dynamicCardFlag INTEGER ,strZipUrl TEXT ,strActiveUrl TEXT ,strDrawerCardUrl TEXT ,strWzryHeroUrl TEXT ,wzryHonorInfo BLOB ,strExtInfo TEXT ,strCurrentBgUrl TEXT ,bgType BLOB ,encId TEXT ,busiEntry TEXT ,favoriteSource INTEGER ,visibleMusicPendant INTEGER ,autoPlayMusicPendant INTEGER ,showRedPointMusicPendant INTEGER ,privilegePromptStr TEXT ,privilegeJumpUrl TEXT ,vOpenPriv BLOB ,vClosePriv BLOB ,presentDesc TEXT ,presentCustourl TEXT ,presentSwitch INTEGER ,showPresent INTEGER ,showMusicBox INTEGER ,addSrcName TEXT ,addSrcId INTEGER ,addSubSrcId INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,olympicTorch INTEGER ,mNowShowFlag INTEGER ,mNowShowIconUrl TEXT ,mNowShowJumpUrl TEXT ,vCoverInfo BLOB ,videoHeadFlag INTEGER ,videoHeadUrl TEXT ,medalSwitchDisable INTEGER ,iMedalCount INTEGER ,iNewCount INTEGER ,iUpgradeCount INTEGER ,strPromptParams TEXT ,hobbyEntry TEXT ,lastPraiseInfoList BLOB ,tempChatSig BLOB ,namePlateOfKingGameId INTEGER ,namePlateOfKingLoginTime INTEGER ,namePlateOfKingDan INTEGER ,namePlateOfKingDanDisplatSwitch INTEGER ,vPersonalityLabelV2 BLOB ,cardType INTEGER ,diyText TEXT ,diyTextFontId INTEGER ,diyTextWidth REAL ,diyTextHeight REAL ,diyTextLocX REAL ,diyTextLocY REAL ,diyTextDegree REAL ,diyTextScale REAL ,diyTextTransparency REAL ,diyDefaultText TEXT ,popularity INTEGER ,declaration TEXT ,voiceUrl TEXT ,isShowCard INTEGER ,updateTime INTEGER ,extendFriendFlag INTEGER ,extendFriendVoiceDuration INTEGER ,extendFriendEntryContact INTEGER ,extendFriendEntryAddFriend INTEGER ,extendFriendQuestion INTEGER ,isShowMiniPlaying INTEGER ,tabJumpUrl TEXT ,guestJumpUrl TEXT ,guestAppTotal INTEGER ,defaultCardId INTEGER ,strangerVoteOpen INTEGER ,lSuperVipTemplateId INTEGER ,bBigClubVipOpen INTEGER ,iBigClubVipType INTEGER ,iBigClubVipLevel INTEGER ,lBigClubTemplateId INTEGER ,diyComplicatedInfo TEXT ,cardId INTEGER ,strangerInviteMeGroupOpen INTEGER ,isPrettyGroupOwner INTEGER ,isHidePrettyGroutIdentity INTEGER ,mQQLevelType INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (Card)paramatmo;
    paramContentValues.put("uin", paramatmo.uin);
    paramContentValues.put("strNick", paramatmo.strNick);
    paramContentValues.put("shGender", Short.valueOf(paramatmo.shGender));
    paramContentValues.put("shAge", Short.valueOf(paramatmo.shAge));
    paramContentValues.put("nFaceID", Integer.valueOf(paramatmo.nFaceID));
    paramContentValues.put("strCertificationInfo", paramatmo.strCertificationInfo);
    paramContentValues.put("shType", Short.valueOf(paramatmo.shType));
    paramContentValues.put("vContent", paramatmo.vContent);
    paramContentValues.put("strSign", paramatmo.strSign);
    paramContentValues.put("strCompany", paramatmo.strCompany);
    paramContentValues.put("strSchool", paramatmo.strSchool);
    paramContentValues.put("uFaceTimeStamp", Integer.valueOf(paramatmo.uFaceTimeStamp));
    paramContentValues.put("vQQFaceID", paramatmo.vQQFaceID);
    paramContentValues.put("strReMark", paramatmo.strReMark);
    paramContentValues.put("bWeiboInfo", Byte.valueOf(paramatmo.bWeiboInfo));
    paramContentValues.put("bQzoneInfo", Byte.valueOf(paramatmo.bQzoneInfo));
    paramContentValues.put("nSameFriendsNum", Integer.valueOf(paramatmo.nSameFriendsNum));
    paramContentValues.put("strCompanySame", paramatmo.strCompanySame);
    paramContentValues.put("strSchoolSame", paramatmo.strSchoolSame);
    paramContentValues.put("lCardShowNum", Long.valueOf(paramatmo.lCardShowNum));
    paramContentValues.put("bSingle", Byte.valueOf(paramatmo.bSingle));
    paramContentValues.put("lVisitCount", Long.valueOf(paramatmo.lVisitCount));
    paramContentValues.put("lVoteCount", Long.valueOf(paramatmo.lVoteCount));
    paramContentValues.put("tagInfosByte", paramatmo.tagInfosByte);
    paramContentValues.put("eUserIdentityType", Byte.valueOf(paramatmo.eUserIdentityType));
    paramContentValues.put("vBackground", paramatmo.vBackground);
    paramContentValues.put("labelInfoBytes", paramatmo.labelInfoBytes);
    paramContentValues.put("age", Byte.valueOf(paramatmo.age));
    paramContentValues.put("constellation", Integer.valueOf(paramatmo.constellation));
    paramContentValues.put("pyFaceUrl", paramatmo.pyFaceUrl);
    paramContentValues.put("location", paramatmo.location);
    paramContentValues.put("bVoted", Byte.valueOf(paramatmo.bVoted));
    paramContentValues.put("bFavorited", Byte.valueOf(paramatmo.bFavorited));
    paramContentValues.put("iVoteIncrement", Integer.valueOf(paramatmo.iVoteIncrement));
    paramContentValues.put("strJoinHexAlbumFileKey", paramatmo.strJoinHexAlbumFileKey);
    paramContentValues.put("iFaceNum", Integer.valueOf(paramatmo.iFaceNum));
    paramContentValues.put("cSqqLevel", Byte.valueOf(paramatmo.cSqqLevel));
    paramContentValues.put("iQQLevel", Integer.valueOf(paramatmo.iQQLevel));
    paramContentValues.put("uCurMulType", Long.valueOf(paramatmo.uCurMulType));
    paramContentValues.put("strProvince", paramatmo.strProvince);
    paramContentValues.put("strCity", paramatmo.strCity);
    paramContentValues.put("strCountry", paramatmo.strCountry);
    paramContentValues.put("lBirthday", Long.valueOf(paramatmo.lBirthday));
    paramContentValues.put("strLocationCodes", paramatmo.strLocationCodes);
    paramContentValues.put("strLocationDesc", paramatmo.strLocationDesc);
    paramContentValues.put("strHometownCodes", paramatmo.strHometownCodes);
    paramContentValues.put("strHometownDesc", paramatmo.strHometownDesc);
    paramContentValues.put("strEmail", paramatmo.strEmail);
    paramContentValues.put("strPersonalNote", paramatmo.strPersonalNote);
    paramContentValues.put("iProfession", Integer.valueOf(paramatmo.iProfession));
    paramContentValues.put("bindPhoneInfo", paramatmo.bindPhoneInfo);
    paramContentValues.put("bCardInfo", paramatmo.bCardInfo);
    paramContentValues.put("strTroopName", paramatmo.strTroopName);
    paramContentValues.put("strTroopNick", paramatmo.strTroopNick);
    paramContentValues.put("strMobile", paramatmo.strMobile);
    paramContentValues.put("strContactName", paramatmo.strContactName);
    paramContentValues.put("ulShowControl", Integer.valueOf(paramatmo.ulShowControl));
    paramContentValues.put("feedPreviewTime", Long.valueOf(paramatmo.feedPreviewTime));
    paramContentValues.put("strQzoneFeedsDesc", paramatmo.strQzoneFeedsDesc);
    paramContentValues.put("StrPresentDesc", paramatmo.StrPresentDesc);
    paramContentValues.put("strSpaceName", paramatmo.strSpaceName);
    paramContentValues.put("strQzoneHeader", paramatmo.strQzoneHeader);
    paramContentValues.put("vQzonePhotos", paramatmo.vQzonePhotos);
    paramContentValues.put("vQzoneCoverInfo", paramatmo.vQzoneCoverInfo);
    paramContentValues.put("enlargeQzonePic", Integer.valueOf(paramatmo.enlargeQzonePic));
    paramContentValues.put("showPublishButton", Boolean.valueOf(paramatmo.showPublishButton));
    paramContentValues.put("strStatus", paramatmo.strStatus);
    paramContentValues.put("strAutoRemark", paramatmo.strAutoRemark);
    paramContentValues.put("vSeed", paramatmo.vSeed);
    paramContentValues.put("vCookies", paramatmo.vCookies);
    paramContentValues.put("hasFakeData", Boolean.valueOf(paramatmo.hasFakeData));
    paramContentValues.put("bQQVipOpen", Byte.valueOf(paramatmo.bQQVipOpen));
    paramContentValues.put("iQQVipType", Integer.valueOf(paramatmo.iQQVipType));
    paramContentValues.put("iQQVipLevel", Integer.valueOf(paramatmo.iQQVipLevel));
    paramContentValues.put("bSuperVipOpen", Byte.valueOf(paramatmo.bSuperVipOpen));
    paramContentValues.put("iSuperVipType", Integer.valueOf(paramatmo.iSuperVipType));
    paramContentValues.put("iSuperVipLevel", Integer.valueOf(paramatmo.iSuperVipLevel));
    paramContentValues.put("bSuperQQOpen", Byte.valueOf(paramatmo.bSuperQQOpen));
    paramContentValues.put("iSuperQQType", Integer.valueOf(paramatmo.iSuperQQType));
    paramContentValues.put("iSuperQQLevel", Integer.valueOf(paramatmo.iSuperQQLevel));
    paramContentValues.put("bHollywoodVipOpen", Byte.valueOf(paramatmo.bHollywoodVipOpen));
    paramContentValues.put("iHollywoodVipType", Integer.valueOf(paramatmo.iHollywoodVipType));
    paramContentValues.put("iHollywoodVipLevel", Integer.valueOf(paramatmo.iHollywoodVipLevel));
    paramContentValues.put("strShowName", paramatmo.strShowName);
    paramContentValues.put("strVoiceFilekey", paramatmo.strVoiceFilekey);
    paramContentValues.put("shDuration", Short.valueOf(paramatmo.shDuration));
    paramContentValues.put("bRead", Byte.valueOf(paramatmo.bRead));
    paramContentValues.put("strUrl", paramatmo.strUrl);
    paramContentValues.put("vRichSign", paramatmo.vRichSign);
    paramContentValues.put("lSignModifyTime", Long.valueOf(paramatmo.lSignModifyTime));
    paramContentValues.put("vLongNickTopicInfo", paramatmo.vLongNickTopicInfo);
    paramContentValues.put("nLastGameFlag", Integer.valueOf(paramatmo.nLastGameFlag));
    paramContentValues.put("strGameLogoUrl_1", paramatmo.strGameLogoUrl_1);
    paramContentValues.put("strGameLogoUrl_2", paramatmo.strGameLogoUrl_2);
    paramContentValues.put("strGameLogoUrl_3", paramatmo.strGameLogoUrl_3);
    paramContentValues.put("strGameLogoUrl_4", paramatmo.strGameLogoUrl_4);
    paramContentValues.put("strGameLogoKey_1", paramatmo.strGameLogoKey_1);
    paramContentValues.put("strGameLogoKey_2", paramatmo.strGameLogoKey_2);
    paramContentValues.put("strGameLogoKey_3", paramatmo.strGameLogoKey_3);
    paramContentValues.put("strGameLogoKey_4", paramatmo.strGameLogoKey_4);
    paramContentValues.put("strGameName_1", paramatmo.strGameName_1);
    paramContentValues.put("strGameName_2", paramatmo.strGameName_2);
    paramContentValues.put("strGameName_3", paramatmo.strGameName_3);
    paramContentValues.put("strGameName_4", paramatmo.strGameName_4);
    paramContentValues.put("strGameAppid_1", paramatmo.strGameAppid_1);
    paramContentValues.put("strGameAppid_2", paramatmo.strGameAppid_2);
    paramContentValues.put("strGameAppid_3", paramatmo.strGameAppid_3);
    paramContentValues.put("strGameAppid_4", paramatmo.strGameAppid_4);
    paramContentValues.put("strProfileUrl", paramatmo.strProfileUrl);
    paramContentValues.put("nStarFansFlag", Integer.valueOf(paramatmo.nStarFansFlag));
    paramContentValues.put("strStarPicUrl_0", paramatmo.strStarPicUrl_0);
    paramContentValues.put("strStarPicUrl_1", paramatmo.strStarPicUrl_1);
    paramContentValues.put("strStarPicUrl_2", paramatmo.strStarPicUrl_2);
    paramContentValues.put("strStarLvUrl_0", paramatmo.strStarLvUrl_0);
    paramContentValues.put("strStarLvUrl_1", paramatmo.strStarLvUrl_1);
    paramContentValues.put("strStarLvUrl_2", paramatmo.strStarLvUrl_2);
    paramContentValues.put("strStarLogoUrl", paramatmo.strStarLogoUrl);
    paramContentValues.put("starFansJumpUrl", paramatmo.starFansJumpUrl);
    paramContentValues.put("lUserFlag", Long.valueOf(paramatmo.lUserFlag));
    paramContentValues.put("lLoginDays", Long.valueOf(paramatmo.lLoginDays));
    paramContentValues.put("strLoginDaysDesc", paramatmo.strLoginDaysDesc);
    paramContentValues.put("lQQMasterLogindays", Long.valueOf(paramatmo.lQQMasterLogindays));
    paramContentValues.put("iXManScene1DelayTime", Integer.valueOf(paramatmo.iXManScene1DelayTime));
    paramContentValues.put("iXManScene2DelayTime", Integer.valueOf(paramatmo.iXManScene2DelayTime));
    paramContentValues.put("allowPeopleSee", Boolean.valueOf(paramatmo.allowPeopleSee));
    paramContentValues.put("allowCalInteractive", Boolean.valueOf(paramatmo.allowCalInteractive));
    paramContentValues.put("showOnlineFriends", Boolean.valueOf(paramatmo.showOnlineFriends));
    paramContentValues.put("allowClick", Boolean.valueOf(paramatmo.allowClick));
    paramContentValues.put("babyQSwitch", Boolean.valueOf(paramatmo.babyQSwitch));
    paramContentValues.put("showLightalk", Boolean.valueOf(paramatmo.showLightalk));
    paramContentValues.put("lightalkNick", paramatmo.lightalkNick);
    paramContentValues.put("lightalkId", paramatmo.lightalkId);
    paramContentValues.put("isSuperRedDiamond", Boolean.valueOf(paramatmo.isSuperRedDiamond));
    paramContentValues.put("isRedDiamond", Boolean.valueOf(paramatmo.isRedDiamond));
    paramContentValues.put("redLevel", Integer.valueOf(paramatmo.redLevel));
    paramContentValues.put("isSuperYellowDiamond", Boolean.valueOf(paramatmo.isSuperYellowDiamond));
    paramContentValues.put("isYellowDiamond", Boolean.valueOf(paramatmo.isYellowDiamond));
    paramContentValues.put("yellowLevel", Integer.valueOf(paramatmo.yellowLevel));
    paramContentValues.put("isSuperGreenDiamond", Boolean.valueOf(paramatmo.isSuperGreenDiamond));
    paramContentValues.put("isGreenDiamond", Boolean.valueOf(paramatmo.isGreenDiamond));
    paramContentValues.put("greenLevel", Integer.valueOf(paramatmo.greenLevel));
    paramContentValues.put("uAccelerateMultiple", Long.valueOf(paramatmo.uAccelerateMultiple));
    paramContentValues.put("strRespMusicInfo", paramatmo.strRespMusicInfo);
    paramContentValues.put("templateRet", Integer.valueOf(paramatmo.templateRet));
    paramContentValues.put("lCurrentStyleId", Long.valueOf(paramatmo.lCurrentStyleId));
    paramContentValues.put("lCurrentBgId", Long.valueOf(paramatmo.lCurrentBgId));
    paramContentValues.put("backgroundUrl", paramatmo.backgroundUrl);
    paramContentValues.put("backgroundColor", Long.valueOf(paramatmo.backgroundColor));
    paramContentValues.put("dynamicCardFlag", Integer.valueOf(paramatmo.dynamicCardFlag));
    paramContentValues.put("strZipUrl", paramatmo.strZipUrl);
    paramContentValues.put("strActiveUrl", paramatmo.strActiveUrl);
    paramContentValues.put("strDrawerCardUrl", paramatmo.strDrawerCardUrl);
    paramContentValues.put("strWzryHeroUrl", paramatmo.strWzryHeroUrl);
    paramContentValues.put("wzryHonorInfo", paramatmo.wzryHonorInfo);
    paramContentValues.put("strExtInfo", paramatmo.strExtInfo);
    paramContentValues.put("strCurrentBgUrl", paramatmo.strCurrentBgUrl);
    paramContentValues.put("bgType", paramatmo.bgType);
    paramContentValues.put("encId", paramatmo.encId);
    paramContentValues.put("busiEntry", paramatmo.busiEntry);
    paramContentValues.put("favoriteSource", Integer.valueOf(paramatmo.favoriteSource));
    paramContentValues.put("visibleMusicPendant", Boolean.valueOf(paramatmo.visibleMusicPendant));
    paramContentValues.put("autoPlayMusicPendant", Boolean.valueOf(paramatmo.autoPlayMusicPendant));
    paramContentValues.put("showRedPointMusicPendant", Boolean.valueOf(paramatmo.showRedPointMusicPendant));
    paramContentValues.put("privilegePromptStr", paramatmo.privilegePromptStr);
    paramContentValues.put("privilegeJumpUrl", paramatmo.privilegeJumpUrl);
    paramContentValues.put("vOpenPriv", paramatmo.vOpenPriv);
    paramContentValues.put("vClosePriv", paramatmo.vClosePriv);
    paramContentValues.put("presentDesc", paramatmo.presentDesc);
    paramContentValues.put("presentCustourl", paramatmo.presentCustourl);
    paramContentValues.put("presentSwitch", Boolean.valueOf(paramatmo.presentSwitch));
    paramContentValues.put("showPresent", Boolean.valueOf(paramatmo.showPresent));
    paramContentValues.put("showMusicBox", Boolean.valueOf(paramatmo.showMusicBox));
    paramContentValues.put("addSrcName", paramatmo.addSrcName);
    paramContentValues.put("addSrcId", Long.valueOf(paramatmo.addSrcId));
    paramContentValues.put("addSubSrcId", Long.valueOf(paramatmo.addSubSrcId));
    paramContentValues.put("strVoteLimitedNotice", paramatmo.strVoteLimitedNotice);
    paramContentValues.put("bHaveVotedCnt", Short.valueOf(paramatmo.bHaveVotedCnt));
    paramContentValues.put("bAvailVoteCnt", Short.valueOf(paramatmo.bAvailVoteCnt));
    paramContentValues.put("olympicTorch", Byte.valueOf(paramatmo.olympicTorch));
    paramContentValues.put("mNowShowFlag", Integer.valueOf(paramatmo.mNowShowFlag));
    paramContentValues.put("mNowShowIconUrl", paramatmo.mNowShowIconUrl);
    paramContentValues.put("mNowShowJumpUrl", paramatmo.mNowShowJumpUrl);
    paramContentValues.put("vCoverInfo", paramatmo.vCoverInfo);
    paramContentValues.put("videoHeadFlag", Boolean.valueOf(paramatmo.videoHeadFlag));
    paramContentValues.put("videoHeadUrl", paramatmo.videoHeadUrl);
    paramContentValues.put("medalSwitchDisable", Boolean.valueOf(paramatmo.medalSwitchDisable));
    paramContentValues.put("iMedalCount", Integer.valueOf(paramatmo.iMedalCount));
    paramContentValues.put("iNewCount", Integer.valueOf(paramatmo.iNewCount));
    paramContentValues.put("iUpgradeCount", Integer.valueOf(paramatmo.iUpgradeCount));
    paramContentValues.put("strPromptParams", paramatmo.strPromptParams);
    paramContentValues.put("hobbyEntry", paramatmo.hobbyEntry);
    paramContentValues.put("lastPraiseInfoList", paramatmo.lastPraiseInfoList);
    paramContentValues.put("tempChatSig", paramatmo.tempChatSig);
    paramContentValues.put("namePlateOfKingGameId", Long.valueOf(paramatmo.namePlateOfKingGameId));
    paramContentValues.put("namePlateOfKingLoginTime", Long.valueOf(paramatmo.namePlateOfKingLoginTime));
    paramContentValues.put("namePlateOfKingDan", Integer.valueOf(paramatmo.namePlateOfKingDan));
    paramContentValues.put("namePlateOfKingDanDisplatSwitch", Boolean.valueOf(paramatmo.namePlateOfKingDanDisplatSwitch));
    paramContentValues.put("vPersonalityLabelV2", paramatmo.vPersonalityLabelV2);
    paramContentValues.put("cardType", Integer.valueOf(paramatmo.cardType));
    paramContentValues.put("diyText", paramatmo.diyText);
    paramContentValues.put("diyTextFontId", Integer.valueOf(paramatmo.diyTextFontId));
    paramContentValues.put("diyTextWidth", Float.valueOf(paramatmo.diyTextWidth));
    paramContentValues.put("diyTextHeight", Float.valueOf(paramatmo.diyTextHeight));
    paramContentValues.put("diyTextLocX", Float.valueOf(paramatmo.diyTextLocX));
    paramContentValues.put("diyTextLocY", Float.valueOf(paramatmo.diyTextLocY));
    paramContentValues.put("diyTextDegree", Float.valueOf(paramatmo.diyTextDegree));
    paramContentValues.put("diyTextScale", Float.valueOf(paramatmo.diyTextScale));
    paramContentValues.put("diyTextTransparency", Float.valueOf(paramatmo.diyTextTransparency));
    paramContentValues.put("diyDefaultText", paramatmo.diyDefaultText);
    paramContentValues.put("popularity", Integer.valueOf(paramatmo.popularity));
    paramContentValues.put("declaration", paramatmo.declaration);
    paramContentValues.put("voiceUrl", paramatmo.voiceUrl);
    paramContentValues.put("isShowCard", Boolean.valueOf(paramatmo.isShowCard));
    paramContentValues.put("updateTime", Long.valueOf(paramatmo.updateTime));
    paramContentValues.put("extendFriendFlag", Integer.valueOf(paramatmo.extendFriendFlag));
    paramContentValues.put("extendFriendVoiceDuration", Integer.valueOf(paramatmo.extendFriendVoiceDuration));
    paramContentValues.put("extendFriendEntryContact", Short.valueOf(paramatmo.extendFriendEntryContact));
    paramContentValues.put("extendFriendEntryAddFriend", Short.valueOf(paramatmo.extendFriendEntryAddFriend));
    paramContentValues.put("extendFriendQuestion", Short.valueOf(paramatmo.extendFriendQuestion));
    paramContentValues.put("isShowMiniPlaying", Boolean.valueOf(paramatmo.isShowMiniPlaying));
    paramContentValues.put("tabJumpUrl", paramatmo.tabJumpUrl);
    paramContentValues.put("guestJumpUrl", paramatmo.guestJumpUrl);
    paramContentValues.put("guestAppTotal", Integer.valueOf(paramatmo.guestAppTotal));
    paramContentValues.put("defaultCardId", Integer.valueOf(paramatmo.defaultCardId));
    paramContentValues.put("strangerVoteOpen", Boolean.valueOf(paramatmo.strangerVoteOpen));
    paramContentValues.put("lSuperVipTemplateId", Long.valueOf(paramatmo.lSuperVipTemplateId));
    paramContentValues.put("bBigClubVipOpen", Byte.valueOf(paramatmo.bBigClubVipOpen));
    paramContentValues.put("iBigClubVipType", Integer.valueOf(paramatmo.iBigClubVipType));
    paramContentValues.put("iBigClubVipLevel", Integer.valueOf(paramatmo.iBigClubVipLevel));
    paramContentValues.put("lBigClubTemplateId", Long.valueOf(paramatmo.lBigClubTemplateId));
    paramContentValues.put("diyComplicatedInfo", paramatmo.diyComplicatedInfo);
    paramContentValues.put("cardId", Long.valueOf(paramatmo.cardId));
    paramContentValues.put("strangerInviteMeGroupOpen", Boolean.valueOf(paramatmo.strangerInviteMeGroupOpen));
    paramContentValues.put("isPrettyGroupOwner", Boolean.valueOf(paramatmo.isPrettyGroupOwner));
    paramContentValues.put("isHidePrettyGroutIdentity", Boolean.valueOf(paramatmo.isHidePrettyGroutIdentity));
    paramContentValues.put("mQQLevelType", Integer.valueOf(paramatmo.mQQLevelType));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atmd
 * JD-Core Version:    0.7.0.1
 */