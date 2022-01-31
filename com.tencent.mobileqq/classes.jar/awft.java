import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awft
  extends awgq
{
  public awft()
  {
    this.a = 248;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawge = (Card)paramawge;
    label1330:
    label2484:
    label2742:
    label4921:
    label4926:
    label5056:
    if (paramawgp == null)
    {
      paramawge.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawge.strNick = paramCursor.getString(paramCursor.getColumnIndex("strNick"));
      paramawge.shGender = paramCursor.getShort(paramCursor.getColumnIndex("shGender"));
      paramawge.shAge = paramCursor.getShort(paramCursor.getColumnIndex("shAge"));
      paramawge.nFaceID = paramCursor.getInt(paramCursor.getColumnIndex("nFaceID"));
      paramawge.strCertificationInfo = paramCursor.getString(paramCursor.getColumnIndex("strCertificationInfo"));
      paramawge.shType = paramCursor.getShort(paramCursor.getColumnIndex("shType"));
      paramawge.vContent = paramCursor.getBlob(paramCursor.getColumnIndex("vContent"));
      paramawge.strSign = paramCursor.getString(paramCursor.getColumnIndex("strSign"));
      paramawge.strCompany = paramCursor.getString(paramCursor.getColumnIndex("strCompany"));
      paramawge.strSchool = paramCursor.getString(paramCursor.getColumnIndex("strSchool"));
      paramawge.uFaceTimeStamp = paramCursor.getInt(paramCursor.getColumnIndex("uFaceTimeStamp"));
      paramawge.vQQFaceID = paramCursor.getBlob(paramCursor.getColumnIndex("vQQFaceID"));
      paramawge.strReMark = paramCursor.getString(paramCursor.getColumnIndex("strReMark"));
      paramawge.bWeiboInfo = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bWeiboInfo")));
      paramawge.bQzoneInfo = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bQzoneInfo")));
      paramawge.nSameFriendsNum = paramCursor.getInt(paramCursor.getColumnIndex("nSameFriendsNum"));
      paramawge.strCompanySame = paramCursor.getString(paramCursor.getColumnIndex("strCompanySame"));
      paramawge.strSchoolSame = paramCursor.getString(paramCursor.getColumnIndex("strSchoolSame"));
      paramawge.lCardShowNum = paramCursor.getLong(paramCursor.getColumnIndex("lCardShowNum"));
      paramawge.bSingle = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSingle")));
      paramawge.lVisitCount = paramCursor.getLong(paramCursor.getColumnIndex("lVisitCount"));
      paramawge.lVoteCount = paramCursor.getLong(paramCursor.getColumnIndex("lVoteCount"));
      paramawge.tagInfosByte = paramCursor.getBlob(paramCursor.getColumnIndex("tagInfosByte"));
      paramawge.eUserIdentityType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("eUserIdentityType")));
      paramawge.vBackground = paramCursor.getBlob(paramCursor.getColumnIndex("vBackground"));
      paramawge.labelInfoBytes = paramCursor.getBlob(paramCursor.getColumnIndex("labelInfoBytes"));
      paramawge.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramawge.constellation = paramCursor.getInt(paramCursor.getColumnIndex("constellation"));
      paramawge.pyFaceUrl = paramCursor.getString(paramCursor.getColumnIndex("pyFaceUrl"));
      paramawge.location = paramCursor.getString(paramCursor.getColumnIndex("location"));
      paramawge.bVoted = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bVoted")));
      paramawge.bFavorited = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bFavorited")));
      paramawge.iVoteIncrement = paramCursor.getInt(paramCursor.getColumnIndex("iVoteIncrement"));
      paramawge.strJoinHexAlbumFileKey = paramCursor.getString(paramCursor.getColumnIndex("strJoinHexAlbumFileKey"));
      paramawge.iFaceNum = paramCursor.getInt(paramCursor.getColumnIndex("iFaceNum"));
      paramawge.cSqqLevel = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSqqLevel")));
      paramawge.iQQLevel = paramCursor.getInt(paramCursor.getColumnIndex("iQQLevel"));
      paramawge.uCurMulType = paramCursor.getLong(paramCursor.getColumnIndex("uCurMulType"));
      paramawge.strProvince = paramCursor.getString(paramCursor.getColumnIndex("strProvince"));
      paramawge.strCity = paramCursor.getString(paramCursor.getColumnIndex("strCity"));
      paramawge.strCountry = paramCursor.getString(paramCursor.getColumnIndex("strCountry"));
      paramawge.lBirthday = paramCursor.getLong(paramCursor.getColumnIndex("lBirthday"));
      paramawge.strLocationCodes = paramCursor.getString(paramCursor.getColumnIndex("strLocationCodes"));
      paramawge.strLocationDesc = paramCursor.getString(paramCursor.getColumnIndex("strLocationDesc"));
      paramawge.strHometownCodes = paramCursor.getString(paramCursor.getColumnIndex("strHometownCodes"));
      paramawge.strHometownDesc = paramCursor.getString(paramCursor.getColumnIndex("strHometownDesc"));
      paramawge.strEmail = paramCursor.getString(paramCursor.getColumnIndex("strEmail"));
      paramawge.strPersonalNote = paramCursor.getString(paramCursor.getColumnIndex("strPersonalNote"));
      paramawge.iProfession = paramCursor.getInt(paramCursor.getColumnIndex("iProfession"));
      paramawge.bindPhoneInfo = paramCursor.getString(paramCursor.getColumnIndex("bindPhoneInfo"));
      paramawge.bCardInfo = paramCursor.getBlob(paramCursor.getColumnIndex("bCardInfo"));
      paramawge.strTroopName = paramCursor.getString(paramCursor.getColumnIndex("strTroopName"));
      paramawge.strTroopNick = paramCursor.getString(paramCursor.getColumnIndex("strTroopNick"));
      paramawge.strMobile = paramCursor.getString(paramCursor.getColumnIndex("strMobile"));
      paramawge.strContactName = paramCursor.getString(paramCursor.getColumnIndex("strContactName"));
      paramawge.ulShowControl = paramCursor.getInt(paramCursor.getColumnIndex("ulShowControl"));
      paramawge.feedPreviewTime = paramCursor.getLong(paramCursor.getColumnIndex("feedPreviewTime"));
      paramawge.strQzoneFeedsDesc = paramCursor.getString(paramCursor.getColumnIndex("strQzoneFeedsDesc"));
      paramawge.StrPresentDesc = paramCursor.getString(paramCursor.getColumnIndex("StrPresentDesc"));
      paramawge.strSpaceName = paramCursor.getString(paramCursor.getColumnIndex("strSpaceName"));
      paramawge.strQzoneHeader = paramCursor.getString(paramCursor.getColumnIndex("strQzoneHeader"));
      paramawge.vQzonePhotos = paramCursor.getBlob(paramCursor.getColumnIndex("vQzonePhotos"));
      paramawge.vQzoneCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vQzoneCoverInfo"));
      paramawge.enlargeQzonePic = paramCursor.getInt(paramCursor.getColumnIndex("enlargeQzonePic"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("showPublishButton")))
      {
        paramBoolean = true;
        paramawge.showPublishButton = paramBoolean;
        paramawge.strStatus = paramCursor.getString(paramCursor.getColumnIndex("strStatus"));
        paramawge.strAutoRemark = paramCursor.getString(paramCursor.getColumnIndex("strAutoRemark"));
        paramawge.vSeed = paramCursor.getBlob(paramCursor.getColumnIndex("vSeed"));
        paramawge.vCookies = paramCursor.getBlob(paramCursor.getColumnIndex("vCookies"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasFakeData"))) {
          break label4916;
        }
        paramBoolean = true;
        paramawge.hasFakeData = paramBoolean;
        paramawge.bQQVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bQQVipOpen")));
        paramawge.iQQVipType = paramCursor.getInt(paramCursor.getColumnIndex("iQQVipType"));
        paramawge.iQQVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iQQVipLevel"));
        paramawge.nameplateVipType = paramCursor.getInt(paramCursor.getColumnIndex("nameplateVipType"));
        paramawge.grayNameplateFlag = paramCursor.getInt(paramCursor.getColumnIndex("grayNameplateFlag"));
        paramawge.bSuperVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSuperVipOpen")));
        paramawge.iSuperVipType = paramCursor.getInt(paramCursor.getColumnIndex("iSuperVipType"));
        paramawge.iSuperVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iSuperVipLevel"));
        paramawge.bSuperQQOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSuperQQOpen")));
        paramawge.iSuperQQType = paramCursor.getInt(paramCursor.getColumnIndex("iSuperQQType"));
        paramawge.iSuperQQLevel = paramCursor.getInt(paramCursor.getColumnIndex("iSuperQQLevel"));
        paramawge.bHollywoodVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bHollywoodVipOpen")));
        paramawge.iHollywoodVipType = paramCursor.getInt(paramCursor.getColumnIndex("iHollywoodVipType"));
        paramawge.iHollywoodVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iHollywoodVipLevel"));
        paramawge.strShowName = paramCursor.getString(paramCursor.getColumnIndex("strShowName"));
        paramawge.strVoiceFilekey = paramCursor.getString(paramCursor.getColumnIndex("strVoiceFilekey"));
        paramawge.shDuration = paramCursor.getShort(paramCursor.getColumnIndex("shDuration"));
        paramawge.bRead = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bRead")));
        paramawge.strUrl = paramCursor.getString(paramCursor.getColumnIndex("strUrl"));
        paramawge.vRichSign = paramCursor.getBlob(paramCursor.getColumnIndex("vRichSign"));
        paramawge.lSignModifyTime = paramCursor.getLong(paramCursor.getColumnIndex("lSignModifyTime"));
        paramawge.vLongNickTopicInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vLongNickTopicInfo"));
        paramawge.nLastGameFlag = paramCursor.getInt(paramCursor.getColumnIndex("nLastGameFlag"));
        paramawge.strGameLogoUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_1"));
        paramawge.strGameLogoUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_2"));
        paramawge.strGameLogoUrl_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_3"));
        paramawge.strGameLogoUrl_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_4"));
        paramawge.strGameLogoKey_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_1"));
        paramawge.strGameLogoKey_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_2"));
        paramawge.strGameLogoKey_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_3"));
        paramawge.strGameLogoKey_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_4"));
        paramawge.strGameName_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_1"));
        paramawge.strGameName_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_2"));
        paramawge.strGameName_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_3"));
        paramawge.strGameName_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_4"));
        paramawge.strGameAppid_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_1"));
        paramawge.strGameAppid_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_2"));
        paramawge.strGameAppid_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_3"));
        paramawge.strGameAppid_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_4"));
        paramawge.strProfileUrl = paramCursor.getString(paramCursor.getColumnIndex("strProfileUrl"));
        paramawge.nStarFansFlag = paramCursor.getInt(paramCursor.getColumnIndex("nStarFansFlag"));
        paramawge.strStarPicUrl_0 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_0"));
        paramawge.strStarPicUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_1"));
        paramawge.strStarPicUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_2"));
        paramawge.strStarLvUrl_0 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_0"));
        paramawge.strStarLvUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_1"));
        paramawge.strStarLvUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_2"));
        paramawge.strStarLogoUrl = paramCursor.getString(paramCursor.getColumnIndex("strStarLogoUrl"));
        paramawge.starFansJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("starFansJumpUrl"));
        paramawge.lUserFlag = paramCursor.getLong(paramCursor.getColumnIndex("lUserFlag"));
        paramawge.lLoginDays = paramCursor.getLong(paramCursor.getColumnIndex("lLoginDays"));
        paramawge.strLoginDaysDesc = paramCursor.getString(paramCursor.getColumnIndex("strLoginDaysDesc"));
        paramawge.lQQMasterLogindays = paramCursor.getLong(paramCursor.getColumnIndex("lQQMasterLogindays"));
        paramawge.iXManScene1DelayTime = paramCursor.getInt(paramCursor.getColumnIndex("iXManScene1DelayTime"));
        paramawge.iXManScene2DelayTime = paramCursor.getInt(paramCursor.getColumnIndex("iXManScene2DelayTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowPeopleSee"))) {
          break label4921;
        }
        paramBoolean = true;
        label2406:
        paramawge.allowPeopleSee = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowCalInteractive"))) {
          break label4926;
        }
        paramBoolean = true;
        paramawge.allowCalInteractive = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showOnlineFriends"))) {
          break label4931;
        }
        paramBoolean = true;
        paramawge.showOnlineFriends = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowClick"))) {
          break label4936;
        }
        paramBoolean = true;
        paramawge.allowClick = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("babyQSwitch"))) {
          break label4941;
        }
        paramBoolean = true;
        label2510:
        paramawge.babyQSwitch = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showLightalk"))) {
          break label4946;
        }
        paramBoolean = true;
        label2536:
        paramawge.showLightalk = paramBoolean;
        paramawge.lightalkNick = paramCursor.getString(paramCursor.getColumnIndex("lightalkNick"));
        paramawge.lightalkId = paramCursor.getString(paramCursor.getColumnIndex("lightalkId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperRedDiamond"))) {
          break label4951;
        }
        paramBoolean = true;
        paramawge.isSuperRedDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRedDiamond"))) {
          break label4956;
        }
        paramBoolean = true;
        label2626:
        paramawge.isRedDiamond = paramBoolean;
        paramawge.redLevel = paramCursor.getInt(paramCursor.getColumnIndex("redLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperYellowDiamond"))) {
          break label4961;
        }
        paramBoolean = true;
        label2671:
        paramawge.isSuperYellowDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isYellowDiamond"))) {
          break label4966;
        }
        paramBoolean = true;
        paramawge.isYellowDiamond = paramBoolean;
        paramawge.yellowLevel = paramCursor.getInt(paramCursor.getColumnIndex("yellowLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperGreenDiamond"))) {
          break label4971;
        }
        paramBoolean = true;
        paramawge.isSuperGreenDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isGreenDiamond"))) {
          break label4976;
        }
        paramBoolean = true;
        label2768:
        paramawge.isGreenDiamond = paramBoolean;
        paramawge.greenLevel = paramCursor.getInt(paramCursor.getColumnIndex("greenLevel"));
        paramawge.uAccelerateMultiple = paramCursor.getLong(paramCursor.getColumnIndex("uAccelerateMultiple"));
        paramawge.strRespMusicInfo = paramCursor.getString(paramCursor.getColumnIndex("strRespMusicInfo"));
        paramawge.templateRet = paramCursor.getInt(paramCursor.getColumnIndex("templateRet"));
        paramawge.lCurrentStyleId = paramCursor.getLong(paramCursor.getColumnIndex("lCurrentStyleId"));
        paramawge.lCurrentBgId = paramCursor.getLong(paramCursor.getColumnIndex("lCurrentBgId"));
        paramawge.backgroundUrl = paramCursor.getString(paramCursor.getColumnIndex("backgroundUrl"));
        paramawge.backgroundColor = paramCursor.getLong(paramCursor.getColumnIndex("backgroundColor"));
        paramawge.dynamicCardFlag = paramCursor.getInt(paramCursor.getColumnIndex("dynamicCardFlag"));
        paramawge.strZipUrl = paramCursor.getString(paramCursor.getColumnIndex("strZipUrl"));
        paramawge.strActiveUrl = paramCursor.getString(paramCursor.getColumnIndex("strActiveUrl"));
        paramawge.strDrawerCardUrl = paramCursor.getString(paramCursor.getColumnIndex("strDrawerCardUrl"));
        paramawge.strWzryHeroUrl = paramCursor.getString(paramCursor.getColumnIndex("strWzryHeroUrl"));
        paramawge.wzryHonorInfo = paramCursor.getBlob(paramCursor.getColumnIndex("wzryHonorInfo"));
        paramawge.strExtInfo = paramCursor.getString(paramCursor.getColumnIndex("strExtInfo"));
        paramawge.strCurrentBgUrl = paramCursor.getString(paramCursor.getColumnIndex("strCurrentBgUrl"));
        paramawge.bgType = paramCursor.getBlob(paramCursor.getColumnIndex("bgType"));
        paramawge.encId = paramCursor.getString(paramCursor.getColumnIndex("encId"));
        paramawge.busiEntry = paramCursor.getString(paramCursor.getColumnIndex("busiEntry"));
        paramawge.favoriteSource = paramCursor.getInt(paramCursor.getColumnIndex("favoriteSource"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("visibleMusicPendant"))) {
          break label4981;
        }
        paramBoolean = true;
        label3174:
        paramawge.visibleMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("autoPlayMusicPendant"))) {
          break label4986;
        }
        paramBoolean = true;
        paramawge.autoPlayMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showRedPointMusicPendant"))) {
          break label4991;
        }
        paramBoolean = true;
        paramawge.showRedPointMusicPendant = paramBoolean;
        paramawge.privilegePromptStr = paramCursor.getString(paramCursor.getColumnIndex("privilegePromptStr"));
        paramawge.privilegeJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("privilegeJumpUrl"));
        paramawge.vOpenPriv = paramCursor.getBlob(paramCursor.getColumnIndex("vOpenPriv"));
        paramawge.vClosePriv = paramCursor.getBlob(paramCursor.getColumnIndex("vClosePriv"));
        paramawge.presentDesc = paramCursor.getString(paramCursor.getColumnIndex("presentDesc"));
        paramawge.presentCustourl = paramCursor.getString(paramCursor.getColumnIndex("presentCustourl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("presentSwitch"))) {
          break label4996;
        }
        paramBoolean = true;
        paramawge.presentSwitch = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showPresent"))) {
          break label5001;
        }
        paramBoolean = true;
        label3392:
        paramawge.showPresent = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showMusicBox"))) {
          break label5006;
        }
        paramBoolean = true;
        label3418:
        paramawge.showMusicBox = paramBoolean;
        paramawge.addSrcName = paramCursor.getString(paramCursor.getColumnIndex("addSrcName"));
        paramawge.addSrcId = paramCursor.getLong(paramCursor.getColumnIndex("addSrcId"));
        paramawge.addSubSrcId = paramCursor.getLong(paramCursor.getColumnIndex("addSubSrcId"));
        paramawge.strVoteLimitedNotice = paramCursor.getString(paramCursor.getColumnIndex("strVoteLimitedNotice"));
        paramawge.bHaveVotedCnt = paramCursor.getShort(paramCursor.getColumnIndex("bHaveVotedCnt"));
        paramawge.bAvailVoteCnt = paramCursor.getShort(paramCursor.getColumnIndex("bAvailVoteCnt"));
        paramawge.olympicTorch = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("olympicTorch")));
        paramawge.mNowShowFlag = paramCursor.getInt(paramCursor.getColumnIndex("mNowShowFlag"));
        paramawge.mNowShowIconUrl = paramCursor.getString(paramCursor.getColumnIndex("mNowShowIconUrl"));
        paramawge.mNowShowJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("mNowShowJumpUrl"));
        paramawge.vCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vCoverInfo"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("videoHeadFlag"))) {
          break label5011;
        }
        paramBoolean = true;
        label3654:
        paramawge.videoHeadFlag = paramBoolean;
        paramawge.videoHeadUrl = paramCursor.getString(paramCursor.getColumnIndex("videoHeadUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("medalSwitchDisable"))) {
          break label5016;
        }
        paramBoolean = true;
        label3699:
        paramawge.medalSwitchDisable = paramBoolean;
        paramawge.iMedalCount = paramCursor.getInt(paramCursor.getColumnIndex("iMedalCount"));
        paramawge.iNewCount = paramCursor.getInt(paramCursor.getColumnIndex("iNewCount"));
        paramawge.iUpgradeCount = paramCursor.getInt(paramCursor.getColumnIndex("iUpgradeCount"));
        paramawge.strPromptParams = paramCursor.getString(paramCursor.getColumnIndex("strPromptParams"));
        paramawge.hobbyEntry = paramCursor.getString(paramCursor.getColumnIndex("hobbyEntry"));
        paramawge.lastPraiseInfoList = paramCursor.getBlob(paramCursor.getColumnIndex("lastPraiseInfoList"));
        paramawge.tempChatSig = paramCursor.getBlob(paramCursor.getColumnIndex("tempChatSig"));
        paramawge.namePlateOfKingGameId = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingGameId"));
        paramawge.namePlateOfKingLoginTime = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingLoginTime"));
        paramawge.namePlateOfKingDan = paramCursor.getInt(paramCursor.getColumnIndex("namePlateOfKingDan"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch"))) {
          break label5021;
        }
        paramBoolean = true;
        label3915:
        paramawge.namePlateOfKingDanDisplatSwitch = paramBoolean;
        paramawge.vPersonalityLabelV2 = paramCursor.getBlob(paramCursor.getColumnIndex("vPersonalityLabelV2"));
        paramawge.cardType = paramCursor.getInt(paramCursor.getColumnIndex("cardType"));
        paramawge.diyText = paramCursor.getString(paramCursor.getColumnIndex("diyText"));
        paramawge.diyTextFontId = paramCursor.getInt(paramCursor.getColumnIndex("diyTextFontId"));
        paramawge.diyTextWidth = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextWidth"));
        paramawge.diyTextHeight = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextHeight"));
        paramawge.diyTextLocX = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextLocX"));
        paramawge.diyTextLocY = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextLocY"));
        paramawge.diyTextDegree = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextDegree"));
        paramawge.diyTextScale = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextScale"));
        paramawge.diyTextTransparency = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextTransparency"));
        paramawge.diyDefaultText = paramCursor.getString(paramCursor.getColumnIndex("diyDefaultText"));
        paramawge.popularity = paramCursor.getInt(paramCursor.getColumnIndex("popularity"));
        paramawge.declaration = paramCursor.getString(paramCursor.getColumnIndex("declaration"));
        paramawge.voiceUrl = paramCursor.getString(paramCursor.getColumnIndex("voiceUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShowCard"))) {
          break label5026;
        }
        paramBoolean = true;
        paramawge.isShowCard = paramBoolean;
        paramawge.updateTime = paramCursor.getLong(paramCursor.getColumnIndex("updateTime"));
        paramawge.extendFriendFlag = paramCursor.getInt(paramCursor.getColumnIndex("extendFriendFlag"));
        paramawge.extendFriendVoiceDuration = paramCursor.getInt(paramCursor.getColumnIndex("extendFriendVoiceDuration"));
        paramawge.extendFriendEntryContact = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendEntryContact"));
        paramawge.extendFriendEntryAddFriend = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendEntryAddFriend"));
        paramawge.extendFriendQuestion = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendQuestion"));
        paramawge.fontId = paramCursor.getInt(paramCursor.getColumnIndex("fontId"));
        paramawge.fontType = paramCursor.getInt(paramCursor.getColumnIndex("fontType"));
        paramawge.clothesId = paramCursor.getInt(paramCursor.getColumnIndex("clothesId"));
        paramawge.schoolId = paramCursor.getString(paramCursor.getColumnIndex("schoolId"));
        paramawge.schoolName = paramCursor.getString(paramCursor.getColumnIndex("schoolName"));
        paramawge.authState = paramCursor.getLong(paramCursor.getColumnIndex("authState"));
        paramawge.idx = paramCursor.getInt(paramCursor.getColumnIndex("idx"));
        paramawge.category = paramCursor.getInt(paramCursor.getColumnIndex("category"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShowMiniPlaying"))) {
          break label5031;
        }
        paramBoolean = true;
        paramawge.isShowMiniPlaying = paramBoolean;
        paramawge.tabJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("tabJumpUrl"));
        paramawge.guestJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("guestJumpUrl"));
        paramawge.guestAppTotal = paramCursor.getInt(paramCursor.getColumnIndex("guestAppTotal"));
        paramawge.defaultCardId = paramCursor.getInt(paramCursor.getColumnIndex("defaultCardId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("strangerVoteOpen"))) {
          break label5036;
        }
        paramBoolean = true;
        paramawge.strangerVoteOpen = paramBoolean;
        paramawge.lSuperVipTemplateId = paramCursor.getLong(paramCursor.getColumnIndex("lSuperVipTemplateId"));
        paramawge.bBigClubVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bBigClubVipOpen")));
        paramawge.iBigClubVipType = paramCursor.getInt(paramCursor.getColumnIndex("iBigClubVipType"));
        paramawge.iBigClubVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iBigClubVipLevel"));
        paramawge.lBigClubTemplateId = paramCursor.getLong(paramCursor.getColumnIndex("lBigClubTemplateId"));
        paramawge.diyComplicatedInfo = paramCursor.getString(paramCursor.getColumnIndex("diyComplicatedInfo"));
        paramawge.cardId = paramCursor.getLong(paramCursor.getColumnIndex("cardId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("strangerInviteMeGroupOpen"))) {
          break label5041;
        }
        paramBoolean = true;
        paramawge.strangerInviteMeGroupOpen = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isPrettyGroupOwner"))) {
          break label5046;
        }
        paramBoolean = true;
        label4806:
        paramawge.isPrettyGroupOwner = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isHidePrettyGroutIdentity"))) {
          break label5051;
        }
        paramBoolean = true;
        label4832:
        paramawge.isHidePrettyGroutIdentity = paramBoolean;
        paramawge.mQQLevelType = paramCursor.getInt(paramCursor.getColumnIndex("mQQLevelType"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("schoolVerifiedFlag"))) {
          break label5056;
        }
        paramBoolean = true;
        paramawge.schoolVerifiedFlag = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("troopHonorSwitch"))) {
          break label5061;
        }
      }
      label4931:
      label5061:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramawge.troopHonorSwitch = paramBoolean;
        return paramawge;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label1330;
        paramBoolean = false;
        break label2406;
        paramBoolean = false;
        break label2432;
        paramBoolean = false;
        break label2458;
        label4936:
        paramBoolean = false;
        break label2484;
        label4941:
        paramBoolean = false;
        break label2510;
        label4946:
        paramBoolean = false;
        break label2536;
        label4951:
        paramBoolean = false;
        break label2600;
        label4956:
        paramBoolean = false;
        break label2626;
        label4961:
        paramBoolean = false;
        break label2671;
        label4966:
        paramBoolean = false;
        break label2697;
        label4971:
        paramBoolean = false;
        break label2742;
        label4976:
        paramBoolean = false;
        break label2768;
        label4981:
        paramBoolean = false;
        break label3174;
        label4986:
        paramBoolean = false;
        break label3200;
        label4991:
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
        break label4518;
        paramBoolean = false;
        break label4620;
        paramBoolean = false;
        break label4780;
        paramBoolean = false;
        break label4806;
        paramBoolean = false;
        break label4832;
        paramBoolean = false;
        break label4877;
      }
    }
    label2432:
    label2458:
    label2600:
    label4780:
    label4916:
    label5046:
    label5051:
    int i = paramCursor.getColumnIndex("uin");
    label2697:
    label3226:
    label3366:
    label5031:
    label5036:
    label5041:
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("strNick");
      if (i != -1) {
        break label14155;
      }
      paramawgp.a(new NoColumnError("strNick", String.class));
      i = paramCursor.getColumnIndex("shGender");
      if (i != -1) {
        break label14170;
      }
      paramawgp.a(new NoColumnError("shGender", Short.TYPE));
      label5171:
      i = paramCursor.getColumnIndex("shAge");
      if (i != -1) {
        break label14185;
      }
      paramawgp.a(new NoColumnError("shAge", Short.TYPE));
      label5206:
      i = paramCursor.getColumnIndex("nFaceID");
      if (i != -1) {
        break label14200;
      }
      paramawgp.a(new NoColumnError("nFaceID", Integer.TYPE));
      label5241:
      i = paramCursor.getColumnIndex("strCertificationInfo");
      if (i != -1) {
        break label14215;
      }
      paramawgp.a(new NoColumnError("strCertificationInfo", String.class));
      i = paramCursor.getColumnIndex("shType");
      if (i != -1) {
        break label14230;
      }
      paramawgp.a(new NoColumnError("shType", Short.TYPE));
      label5311:
      i = paramCursor.getColumnIndex("vContent");
      if (i != -1) {
        break label14245;
      }
      paramawgp.a(new NoColumnError("vContent", [B.class));
      label5346:
      i = paramCursor.getColumnIndex("strSign");
      if (i != -1) {
        break label14260;
      }
      paramawgp.a(new NoColumnError("strSign", String.class));
      i = paramCursor.getColumnIndex("strCompany");
      if (i != -1) {
        break label14275;
      }
      paramawgp.a(new NoColumnError("strCompany", String.class));
      i = paramCursor.getColumnIndex("strSchool");
      if (i != -1) {
        break label14290;
      }
      paramawgp.a(new NoColumnError("strSchool", String.class));
      label5451:
      i = paramCursor.getColumnIndex("uFaceTimeStamp");
      if (i != -1) {
        break label14305;
      }
      paramawgp.a(new NoColumnError("uFaceTimeStamp", Integer.TYPE));
      label5486:
      i = paramCursor.getColumnIndex("vQQFaceID");
      if (i != -1) {
        break label14320;
      }
      paramawgp.a(new NoColumnError("vQQFaceID", [B.class));
      i = paramCursor.getColumnIndex("strReMark");
      if (i != -1) {
        break label14335;
      }
      paramawgp.a(new NoColumnError("strReMark", String.class));
      label5556:
      i = paramCursor.getColumnIndex("bWeiboInfo");
      if (i != -1) {
        break label14350;
      }
      paramawgp.a(new NoColumnError("bWeiboInfo", Byte.TYPE));
      label5591:
      i = paramCursor.getColumnIndex("bQzoneInfo");
      if (i != -1) {
        break label14366;
      }
      paramawgp.a(new NoColumnError("bQzoneInfo", Byte.TYPE));
      label5626:
      i = paramCursor.getColumnIndex("nSameFriendsNum");
      if (i != -1) {
        break label14382;
      }
      paramawgp.a(new NoColumnError("nSameFriendsNum", Integer.TYPE));
      i = paramCursor.getColumnIndex("strCompanySame");
      if (i != -1) {
        break label14397;
      }
      paramawgp.a(new NoColumnError("strCompanySame", String.class));
      label5696:
      i = paramCursor.getColumnIndex("strSchoolSame");
      if (i != -1) {
        break label14412;
      }
      paramawgp.a(new NoColumnError("strSchoolSame", String.class));
      label5731:
      i = paramCursor.getColumnIndex("lCardShowNum");
      if (i != -1) {
        break label14427;
      }
      paramawgp.a(new NoColumnError("lCardShowNum", Long.TYPE));
      i = paramCursor.getColumnIndex("bSingle");
      if (i != -1) {
        break label14442;
      }
      paramawgp.a(new NoColumnError("bSingle", Byte.TYPE));
      i = paramCursor.getColumnIndex("lVisitCount");
      if (i != -1) {
        break label14458;
      }
      paramawgp.a(new NoColumnError("lVisitCount", Long.TYPE));
      label5836:
      i = paramCursor.getColumnIndex("lVoteCount");
      if (i != -1) {
        break label14473;
      }
      paramawgp.a(new NoColumnError("lVoteCount", Long.TYPE));
      label5871:
      i = paramCursor.getColumnIndex("tagInfosByte");
      if (i != -1) {
        break label14488;
      }
      paramawgp.a(new NoColumnError("tagInfosByte", [B.class));
      i = paramCursor.getColumnIndex("eUserIdentityType");
      if (i != -1) {
        break label14503;
      }
      paramawgp.a(new NoColumnError("eUserIdentityType", Byte.TYPE));
      label5941:
      i = paramCursor.getColumnIndex("vBackground");
      if (i != -1) {
        break label14519;
      }
      paramawgp.a(new NoColumnError("vBackground", [B.class));
      label5976:
      i = paramCursor.getColumnIndex("labelInfoBytes");
      if (i != -1) {
        break label14534;
      }
      paramawgp.a(new NoColumnError("labelInfoBytes", [B.class));
      label6011:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label14549;
      }
      paramawgp.a(new NoColumnError("age", Byte.TYPE));
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label14565;
      }
      paramawgp.a(new NoColumnError("constellation", Integer.TYPE));
      label6081:
      i = paramCursor.getColumnIndex("pyFaceUrl");
      if (i != -1) {
        break label14580;
      }
      paramawgp.a(new NoColumnError("pyFaceUrl", String.class));
      label6116:
      i = paramCursor.getColumnIndex("location");
      if (i != -1) {
        break label14595;
      }
      paramawgp.a(new NoColumnError("location", String.class));
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label14610;
      }
      paramawgp.a(new NoColumnError("bVoted", Byte.TYPE));
      i = paramCursor.getColumnIndex("bFavorited");
      if (i != -1) {
        break label14626;
      }
      paramawgp.a(new NoColumnError("bFavorited", Byte.TYPE));
      label6221:
      i = paramCursor.getColumnIndex("iVoteIncrement");
      if (i != -1) {
        break label14642;
      }
      paramawgp.a(new NoColumnError("iVoteIncrement", Integer.TYPE));
      label6256:
      i = paramCursor.getColumnIndex("strJoinHexAlbumFileKey");
      if (i != -1) {
        break label14657;
      }
      paramawgp.a(new NoColumnError("strJoinHexAlbumFileKey", String.class));
      i = paramCursor.getColumnIndex("iFaceNum");
      if (i != -1) {
        break label14672;
      }
      paramawgp.a(new NoColumnError("iFaceNum", Integer.TYPE));
      label6326:
      i = paramCursor.getColumnIndex("cSqqLevel");
      if (i != -1) {
        break label14687;
      }
      paramawgp.a(new NoColumnError("cSqqLevel", Byte.TYPE));
      label6361:
      i = paramCursor.getColumnIndex("iQQLevel");
      if (i != -1) {
        break label14703;
      }
      paramawgp.a(new NoColumnError("iQQLevel", Integer.TYPE));
      label6396:
      i = paramCursor.getColumnIndex("uCurMulType");
      if (i != -1) {
        break label14718;
      }
      paramawgp.a(new NoColumnError("uCurMulType", Long.TYPE));
      i = paramCursor.getColumnIndex("strProvince");
      if (i != -1) {
        break label14733;
      }
      paramawgp.a(new NoColumnError("strProvince", String.class));
      label6466:
      i = paramCursor.getColumnIndex("strCity");
      if (i != -1) {
        break label14748;
      }
      paramawgp.a(new NoColumnError("strCity", String.class));
      label6501:
      i = paramCursor.getColumnIndex("strCountry");
      if (i != -1) {
        break label14763;
      }
      paramawgp.a(new NoColumnError("strCountry", String.class));
      i = paramCursor.getColumnIndex("lBirthday");
      if (i != -1) {
        break label14778;
      }
      paramawgp.a(new NoColumnError("lBirthday", Long.TYPE));
      i = paramCursor.getColumnIndex("strLocationCodes");
      if (i != -1) {
        break label14793;
      }
      paramawgp.a(new NoColumnError("strLocationCodes", String.class));
      label6606:
      i = paramCursor.getColumnIndex("strLocationDesc");
      if (i != -1) {
        break label14808;
      }
      paramawgp.a(new NoColumnError("strLocationDesc", String.class));
      label6641:
      i = paramCursor.getColumnIndex("strHometownCodes");
      if (i != -1) {
        break label14823;
      }
      paramawgp.a(new NoColumnError("strHometownCodes", String.class));
      i = paramCursor.getColumnIndex("strHometownDesc");
      if (i != -1) {
        break label14838;
      }
      paramawgp.a(new NoColumnError("strHometownDesc", String.class));
      label6711:
      i = paramCursor.getColumnIndex("strEmail");
      if (i != -1) {
        break label14853;
      }
      paramawgp.a(new NoColumnError("strEmail", String.class));
      label6746:
      i = paramCursor.getColumnIndex("strPersonalNote");
      if (i != -1) {
        break label14868;
      }
      paramawgp.a(new NoColumnError("strPersonalNote", String.class));
      label6781:
      i = paramCursor.getColumnIndex("iProfession");
      if (i != -1) {
        break label14883;
      }
      paramawgp.a(new NoColumnError("iProfession", Integer.TYPE));
      i = paramCursor.getColumnIndex("bindPhoneInfo");
      if (i != -1) {
        break label14898;
      }
      paramawgp.a(new NoColumnError("bindPhoneInfo", String.class));
      label6851:
      i = paramCursor.getColumnIndex("bCardInfo");
      if (i != -1) {
        break label14913;
      }
      paramawgp.a(new NoColumnError("bCardInfo", [B.class));
      label6886:
      i = paramCursor.getColumnIndex("strTroopName");
      if (i != -1) {
        break label14928;
      }
      paramawgp.a(new NoColumnError("strTroopName", String.class));
      i = paramCursor.getColumnIndex("strTroopNick");
      if (i != -1) {
        break label14943;
      }
      paramawgp.a(new NoColumnError("strTroopNick", String.class));
      i = paramCursor.getColumnIndex("strMobile");
      if (i != -1) {
        break label14958;
      }
      paramawgp.a(new NoColumnError("strMobile", String.class));
      label6997:
      i = paramCursor.getColumnIndex("strContactName");
      if (i != -1) {
        break label14973;
      }
      paramawgp.a(new NoColumnError("strContactName", String.class));
      label7034:
      i = paramCursor.getColumnIndex("ulShowControl");
      if (i != -1) {
        break label14988;
      }
      paramawgp.a(new NoColumnError("ulShowControl", Integer.TYPE));
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label15003;
      }
      paramawgp.a(new NoColumnError("feedPreviewTime", Long.TYPE));
      label7108:
      i = paramCursor.getColumnIndex("strQzoneFeedsDesc");
      if (i != -1) {
        break label15018;
      }
      paramawgp.a(new NoColumnError("strQzoneFeedsDesc", String.class));
      label7145:
      i = paramCursor.getColumnIndex("StrPresentDesc");
      if (i != -1) {
        break label15033;
      }
      paramawgp.a(new NoColumnError("StrPresentDesc", String.class));
      i = paramCursor.getColumnIndex("strSpaceName");
      if (i != -1) {
        break label15048;
      }
      paramawgp.a(new NoColumnError("strSpaceName", String.class));
      label7219:
      i = paramCursor.getColumnIndex("strQzoneHeader");
      if (i != -1) {
        break label15063;
      }
      paramawgp.a(new NoColumnError("strQzoneHeader", String.class));
      label7256:
      i = paramCursor.getColumnIndex("vQzonePhotos");
      if (i != -1) {
        break label15078;
      }
      paramawgp.a(new NoColumnError("vQzonePhotos", [B.class));
      label7293:
      i = paramCursor.getColumnIndex("vQzoneCoverInfo");
      if (i != -1) {
        break label15093;
      }
      paramawgp.a(new NoColumnError("vQzoneCoverInfo", [B.class));
      i = paramCursor.getColumnIndex("enlargeQzonePic");
      if (i != -1) {
        break label15108;
      }
      paramawgp.a(new NoColumnError("enlargeQzonePic", Integer.TYPE));
      label7367:
      i = paramCursor.getColumnIndex("showPublishButton");
      if (i != -1) {
        break label15123;
      }
      paramawgp.a(new NoColumnError("showPublishButton", Boolean.TYPE));
      i = paramCursor.getColumnIndex("strStatus");
      if (i != -1) {
        break label15150;
      }
      paramawgp.a(new NoColumnError("strStatus", String.class));
      i = paramCursor.getColumnIndex("strAutoRemark");
      if (i != -1) {
        break label15165;
      }
      paramawgp.a(new NoColumnError("strAutoRemark", String.class));
      label7478:
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label15180;
      }
      paramawgp.a(new NoColumnError("vSeed", [B.class));
      label7515:
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label15195;
      }
      paramawgp.a(new NoColumnError("vCookies", [B.class));
      i = paramCursor.getColumnIndex("hasFakeData");
      if (i != -1) {
        break label15210;
      }
      paramawgp.a(new NoColumnError("hasFakeData", Boolean.TYPE));
      i = paramCursor.getColumnIndex("bQQVipOpen");
      if (i != -1) {
        break label15237;
      }
      paramawgp.a(new NoColumnError("bQQVipOpen", Byte.TYPE));
      label7626:
      i = paramCursor.getColumnIndex("iQQVipType");
      if (i != -1) {
        break label15253;
      }
      paramawgp.a(new NoColumnError("iQQVipType", Integer.TYPE));
      label7663:
      i = paramCursor.getColumnIndex("iQQVipLevel");
      if (i != -1) {
        break label15268;
      }
      paramawgp.a(new NoColumnError("iQQVipLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("nameplateVipType");
      if (i != -1) {
        break label15283;
      }
      paramawgp.a(new NoColumnError("nameplateVipType", Integer.TYPE));
      label7737:
      i = paramCursor.getColumnIndex("grayNameplateFlag");
      if (i != -1) {
        break label15298;
      }
      paramawgp.a(new NoColumnError("grayNameplateFlag", Integer.TYPE));
      label7774:
      i = paramCursor.getColumnIndex("bSuperVipOpen");
      if (i != -1) {
        break label15313;
      }
      paramawgp.a(new NoColumnError("bSuperVipOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iSuperVipType");
      if (i != -1) {
        break label15329;
      }
      paramawgp.a(new NoColumnError("iSuperVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iSuperVipLevel");
      if (i != -1) {
        break label15344;
      }
      paramawgp.a(new NoColumnError("iSuperVipLevel", Integer.TYPE));
      label7885:
      i = paramCursor.getColumnIndex("bSuperQQOpen");
      if (i != -1) {
        break label15359;
      }
      paramawgp.a(new NoColumnError("bSuperQQOpen", Byte.TYPE));
      label7922:
      i = paramCursor.getColumnIndex("iSuperQQType");
      if (i != -1) {
        break label15375;
      }
      paramawgp.a(new NoColumnError("iSuperQQType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iSuperQQLevel");
      if (i != -1) {
        break label15390;
      }
      paramawgp.a(new NoColumnError("iSuperQQLevel", Integer.TYPE));
      label7996:
      i = paramCursor.getColumnIndex("bHollywoodVipOpen");
      if (i != -1) {
        break label15405;
      }
      paramawgp.a(new NoColumnError("bHollywoodVipOpen", Byte.TYPE));
      label8033:
      i = paramCursor.getColumnIndex("iHollywoodVipType");
      if (i != -1) {
        break label15421;
      }
      paramawgp.a(new NoColumnError("iHollywoodVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iHollywoodVipLevel");
      if (i != -1) {
        break label15436;
      }
      paramawgp.a(new NoColumnError("iHollywoodVipLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("strShowName");
      if (i != -1) {
        break label15451;
      }
      paramawgp.a(new NoColumnError("strShowName", String.class));
      label8144:
      i = paramCursor.getColumnIndex("strVoiceFilekey");
      if (i != -1) {
        break label15466;
      }
      paramawgp.a(new NoColumnError("strVoiceFilekey", String.class));
      label8181:
      i = paramCursor.getColumnIndex("shDuration");
      if (i != -1) {
        break label15481;
      }
      paramawgp.a(new NoColumnError("shDuration", Short.TYPE));
      i = paramCursor.getColumnIndex("bRead");
      if (i != -1) {
        break label15496;
      }
      paramawgp.a(new NoColumnError("bRead", Byte.TYPE));
      label8255:
      i = paramCursor.getColumnIndex("strUrl");
      if (i != -1) {
        break label15512;
      }
      paramawgp.a(new NoColumnError("strUrl", String.class));
      label8292:
      i = paramCursor.getColumnIndex("vRichSign");
      if (i != -1) {
        break label15527;
      }
      paramawgp.a(new NoColumnError("vRichSign", [B.class));
      i = paramCursor.getColumnIndex("lSignModifyTime");
      if (i != -1) {
        break label15542;
      }
      paramawgp.a(new NoColumnError("lSignModifyTime", Long.TYPE));
      i = paramCursor.getColumnIndex("vLongNickTopicInfo");
      if (i != -1) {
        break label15557;
      }
      paramawgp.a(new NoColumnError("vLongNickTopicInfo", [B.class));
      label8403:
      i = paramCursor.getColumnIndex("nLastGameFlag");
      if (i != -1) {
        break label15572;
      }
      paramawgp.a(new NoColumnError("nLastGameFlag", Integer.TYPE));
      label8440:
      i = paramCursor.getColumnIndex("strGameLogoUrl_1");
      if (i != -1) {
        break label15587;
      }
      paramawgp.a(new NoColumnError("strGameLogoUrl_1", String.class));
      i = paramCursor.getColumnIndex("strGameLogoUrl_2");
      if (i != -1) {
        break label15602;
      }
      paramawgp.a(new NoColumnError("strGameLogoUrl_2", String.class));
      label8514:
      i = paramCursor.getColumnIndex("strGameLogoUrl_3");
      if (i != -1) {
        break label15617;
      }
      paramawgp.a(new NoColumnError("strGameLogoUrl_3", String.class));
      label8551:
      i = paramCursor.getColumnIndex("strGameLogoUrl_4");
      if (i != -1) {
        break label15632;
      }
      paramawgp.a(new NoColumnError("strGameLogoUrl_4", String.class));
      i = paramCursor.getColumnIndex("strGameLogoKey_1");
      if (i != -1) {
        break label15647;
      }
      paramawgp.a(new NoColumnError("strGameLogoKey_1", String.class));
      label8625:
      i = paramCursor.getColumnIndex("strGameLogoKey_2");
      if (i != -1) {
        break label15662;
      }
      paramawgp.a(new NoColumnError("strGameLogoKey_2", String.class));
      label8662:
      i = paramCursor.getColumnIndex("strGameLogoKey_3");
      if (i != -1) {
        break label15677;
      }
      paramawgp.a(new NoColumnError("strGameLogoKey_3", String.class));
      label8699:
      i = paramCursor.getColumnIndex("strGameLogoKey_4");
      if (i != -1) {
        break label15692;
      }
      paramawgp.a(new NoColumnError("strGameLogoKey_4", String.class));
      i = paramCursor.getColumnIndex("strGameName_1");
      if (i != -1) {
        break label15707;
      }
      paramawgp.a(new NoColumnError("strGameName_1", String.class));
      label8773:
      i = paramCursor.getColumnIndex("strGameName_2");
      if (i != -1) {
        break label15722;
      }
      paramawgp.a(new NoColumnError("strGameName_2", String.class));
      label8810:
      i = paramCursor.getColumnIndex("strGameName_3");
      if (i != -1) {
        break label15737;
      }
      paramawgp.a(new NoColumnError("strGameName_3", String.class));
      i = paramCursor.getColumnIndex("strGameName_4");
      if (i != -1) {
        break label15752;
      }
      paramawgp.a(new NoColumnError("strGameName_4", String.class));
      label8884:
      i = paramCursor.getColumnIndex("strGameAppid_1");
      if (i != -1) {
        break label15767;
      }
      paramawgp.a(new NoColumnError("strGameAppid_1", String.class));
      label8921:
      i = paramCursor.getColumnIndex("strGameAppid_2");
      if (i != -1) {
        break label15782;
      }
      paramawgp.a(new NoColumnError("strGameAppid_2", String.class));
      label8958:
      i = paramCursor.getColumnIndex("strGameAppid_3");
      if (i != -1) {
        break label15797;
      }
      paramawgp.a(new NoColumnError("strGameAppid_3", String.class));
      i = paramCursor.getColumnIndex("strGameAppid_4");
      if (i != -1) {
        break label15812;
      }
      paramawgp.a(new NoColumnError("strGameAppid_4", String.class));
      label9032:
      i = paramCursor.getColumnIndex("strProfileUrl");
      if (i != -1) {
        break label15827;
      }
      paramawgp.a(new NoColumnError("strProfileUrl", String.class));
      label9069:
      i = paramCursor.getColumnIndex("nStarFansFlag");
      if (i != -1) {
        break label15842;
      }
      paramawgp.a(new NoColumnError("nStarFansFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("strStarPicUrl_0");
      if (i != -1) {
        break label15857;
      }
      paramawgp.a(new NoColumnError("strStarPicUrl_0", String.class));
      label9143:
      i = paramCursor.getColumnIndex("strStarPicUrl_1");
      if (i != -1) {
        break label15872;
      }
      paramawgp.a(new NoColumnError("strStarPicUrl_1", String.class));
      label9180:
      i = paramCursor.getColumnIndex("strStarPicUrl_2");
      if (i != -1) {
        break label15887;
      }
      paramawgp.a(new NoColumnError("strStarPicUrl_2", String.class));
      i = paramCursor.getColumnIndex("strStarLvUrl_0");
      if (i != -1) {
        break label15902;
      }
      paramawgp.a(new NoColumnError("strStarLvUrl_0", String.class));
      i = paramCursor.getColumnIndex("strStarLvUrl_1");
      if (i != -1) {
        break label15917;
      }
      paramawgp.a(new NoColumnError("strStarLvUrl_1", String.class));
      label9291:
      i = paramCursor.getColumnIndex("strStarLvUrl_2");
      if (i != -1) {
        break label15932;
      }
      paramawgp.a(new NoColumnError("strStarLvUrl_2", String.class));
      label9328:
      i = paramCursor.getColumnIndex("strStarLogoUrl");
      if (i != -1) {
        break label15947;
      }
      paramawgp.a(new NoColumnError("strStarLogoUrl", String.class));
      i = paramCursor.getColumnIndex("starFansJumpUrl");
      if (i != -1) {
        break label15962;
      }
      paramawgp.a(new NoColumnError("starFansJumpUrl", String.class));
      label9402:
      i = paramCursor.getColumnIndex("lUserFlag");
      if (i != -1) {
        break label15977;
      }
      paramawgp.a(new NoColumnError("lUserFlag", Long.TYPE));
      label9439:
      i = paramCursor.getColumnIndex("lLoginDays");
      if (i != -1) {
        break label15992;
      }
      paramawgp.a(new NoColumnError("lLoginDays", Long.TYPE));
      i = paramCursor.getColumnIndex("strLoginDaysDesc");
      if (i != -1) {
        break label16007;
      }
      paramawgp.a(new NoColumnError("strLoginDaysDesc", String.class));
      i = paramCursor.getColumnIndex("lQQMasterLogindays");
      if (i != -1) {
        break label16022;
      }
      paramawgp.a(new NoColumnError("lQQMasterLogindays", Long.TYPE));
      label9550:
      i = paramCursor.getColumnIndex("iXManScene1DelayTime");
      if (i != -1) {
        break label16037;
      }
      paramawgp.a(new NoColumnError("iXManScene1DelayTime", Integer.TYPE));
      label9587:
      i = paramCursor.getColumnIndex("iXManScene2DelayTime");
      if (i != -1) {
        break label16052;
      }
      paramawgp.a(new NoColumnError("iXManScene2DelayTime", Integer.TYPE));
      i = paramCursor.getColumnIndex("allowPeopleSee");
      if (i != -1) {
        break label16067;
      }
      paramawgp.a(new NoColumnError("allowPeopleSee", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowCalInteractive");
      if (i != -1) {
        break label16094;
      }
      paramawgp.a(new NoColumnError("allowCalInteractive", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showOnlineFriends");
      if (i != -1) {
        break label16121;
      }
      paramawgp.a(new NoColumnError("showOnlineFriends", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowClick");
      if (i != -1) {
        break label16148;
      }
      paramawgp.a(new NoColumnError("allowClick", Boolean.TYPE));
      i = paramCursor.getColumnIndex("babyQSwitch");
      if (i != -1) {
        break label16175;
      }
      paramawgp.a(new NoColumnError("babyQSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showLightalk");
      if (i != -1) {
        break label16202;
      }
      paramawgp.a(new NoColumnError("showLightalk", Boolean.TYPE));
      i = paramCursor.getColumnIndex("lightalkNick");
      if (i != -1) {
        break label16229;
      }
      paramawgp.a(new NoColumnError("lightalkNick", String.class));
      i = paramCursor.getColumnIndex("lightalkId");
      if (i != -1) {
        break label16244;
      }
      paramawgp.a(new NoColumnError("lightalkId", String.class));
      label9920:
      i = paramCursor.getColumnIndex("isSuperRedDiamond");
      if (i != -1) {
        break label16259;
      }
      paramawgp.a(new NoColumnError("isSuperRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRedDiamond");
      if (i != -1) {
        break label16286;
      }
      paramawgp.a(new NoColumnError("isRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("redLevel");
      if (i != -1) {
        break label16313;
      }
      paramawgp.a(new NoColumnError("redLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("isSuperYellowDiamond");
      if (i != -1) {
        break label16328;
      }
      paramawgp.a(new NoColumnError("isSuperYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isYellowDiamond");
      if (i != -1) {
        break label16355;
      }
      paramawgp.a(new NoColumnError("isYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("yellowLevel");
      if (i != -1) {
        break label16382;
      }
      paramawgp.a(new NoColumnError("yellowLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("isSuperGreenDiamond");
      if (i != -1) {
        break label16397;
      }
      paramawgp.a(new NoColumnError("isSuperGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isGreenDiamond");
      if (i != -1) {
        break label16424;
      }
      paramawgp.a(new NoColumnError("isGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("greenLevel");
      if (i != -1) {
        break label16451;
      }
      paramawgp.a(new NoColumnError("greenLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("uAccelerateMultiple");
      if (i != -1) {
        break label16466;
      }
      paramawgp.a(new NoColumnError("uAccelerateMultiple", Long.TYPE));
      label10290:
      i = paramCursor.getColumnIndex("strRespMusicInfo");
      if (i != -1) {
        break label16481;
      }
      paramawgp.a(new NoColumnError("strRespMusicInfo", String.class));
      label10327:
      i = paramCursor.getColumnIndex("templateRet");
      if (i != -1) {
        break label16496;
      }
      paramawgp.a(new NoColumnError("templateRet", Integer.TYPE));
      label10364:
      i = paramCursor.getColumnIndex("lCurrentStyleId");
      if (i != -1) {
        break label16511;
      }
      paramawgp.a(new NoColumnError("lCurrentStyleId", Long.TYPE));
      i = paramCursor.getColumnIndex("lCurrentBgId");
      if (i != -1) {
        break label16526;
      }
      paramawgp.a(new NoColumnError("lCurrentBgId", Long.TYPE));
      label10438:
      i = paramCursor.getColumnIndex("backgroundUrl");
      if (i != -1) {
        break label16541;
      }
      paramawgp.a(new NoColumnError("backgroundUrl", String.class));
      label10475:
      i = paramCursor.getColumnIndex("backgroundColor");
      if (i != -1) {
        break label16556;
      }
      paramawgp.a(new NoColumnError("backgroundColor", Long.TYPE));
      i = paramCursor.getColumnIndex("dynamicCardFlag");
      if (i != -1) {
        break label16571;
      }
      paramawgp.a(new NoColumnError("dynamicCardFlag", Integer.TYPE));
      label10549:
      i = paramCursor.getColumnIndex("strZipUrl");
      if (i != -1) {
        break label16586;
      }
      paramawgp.a(new NoColumnError("strZipUrl", String.class));
      label10586:
      i = paramCursor.getColumnIndex("strActiveUrl");
      if (i != -1) {
        break label16601;
      }
      paramawgp.a(new NoColumnError("strActiveUrl", String.class));
      label10623:
      i = paramCursor.getColumnIndex("strDrawerCardUrl");
      if (i != -1) {
        break label16616;
      }
      paramawgp.a(new NoColumnError("strDrawerCardUrl", String.class));
      i = paramCursor.getColumnIndex("strWzryHeroUrl");
      if (i != -1) {
        break label16631;
      }
      paramawgp.a(new NoColumnError("strWzryHeroUrl", String.class));
      label10697:
      i = paramCursor.getColumnIndex("wzryHonorInfo");
      if (i != -1) {
        break label16646;
      }
      paramawgp.a(new NoColumnError("wzryHonorInfo", [B.class));
      label10734:
      i = paramCursor.getColumnIndex("strExtInfo");
      if (i != -1) {
        break label16661;
      }
      paramawgp.a(new NoColumnError("strExtInfo", String.class));
      i = paramCursor.getColumnIndex("strCurrentBgUrl");
      if (i != -1) {
        break label16676;
      }
      paramawgp.a(new NoColumnError("strCurrentBgUrl", String.class));
      label10808:
      i = paramCursor.getColumnIndex("bgType");
      if (i != -1) {
        break label16691;
      }
      paramawgp.a(new NoColumnError("bgType", [B.class));
      label10845:
      i = paramCursor.getColumnIndex("encId");
      if (i != -1) {
        break label16706;
      }
      paramawgp.a(new NoColumnError("encId", String.class));
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label16721;
      }
      paramawgp.a(new NoColumnError("busiEntry", String.class));
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label16736;
      }
      paramawgp.a(new NoColumnError("favoriteSource", Integer.TYPE));
      label10956:
      i = paramCursor.getColumnIndex("visibleMusicPendant");
      if (i != -1) {
        break label16751;
      }
      paramawgp.a(new NoColumnError("visibleMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("autoPlayMusicPendant");
      if (i != -1) {
        break label16778;
      }
      paramawgp.a(new NoColumnError("autoPlayMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showRedPointMusicPendant");
      if (i != -1) {
        break label16805;
      }
      paramawgp.a(new NoColumnError("showRedPointMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("privilegePromptStr");
      if (i != -1) {
        break label16832;
      }
      paramawgp.a(new NoColumnError("privilegePromptStr", String.class));
      label11104:
      i = paramCursor.getColumnIndex("privilegeJumpUrl");
      if (i != -1) {
        break label16847;
      }
      paramawgp.a(new NoColumnError("privilegeJumpUrl", String.class));
      i = paramCursor.getColumnIndex("vOpenPriv");
      if (i != -1) {
        break label16862;
      }
      paramawgp.a(new NoColumnError("vOpenPriv", [B.class));
      i = paramCursor.getColumnIndex("vClosePriv");
      if (i != -1) {
        break label16877;
      }
      paramawgp.a(new NoColumnError("vClosePriv", [B.class));
      label11215:
      i = paramCursor.getColumnIndex("presentDesc");
      if (i != -1) {
        break label16892;
      }
      paramawgp.a(new NoColumnError("presentDesc", String.class));
      label11252:
      i = paramCursor.getColumnIndex("presentCustourl");
      if (i != -1) {
        break label16907;
      }
      paramawgp.a(new NoColumnError("presentCustourl", String.class));
      i = paramCursor.getColumnIndex("presentSwitch");
      if (i != -1) {
        break label16922;
      }
      paramawgp.a(new NoColumnError("presentSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showPresent");
      if (i != -1) {
        break label16949;
      }
      paramawgp.a(new NoColumnError("showPresent", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showMusicBox");
      if (i != -1) {
        break label16976;
      }
      paramawgp.a(new NoColumnError("showMusicBox", Boolean.TYPE));
      i = paramCursor.getColumnIndex("addSrcName");
      if (i != -1) {
        break label17003;
      }
      paramawgp.a(new NoColumnError("addSrcName", String.class));
      i = paramCursor.getColumnIndex("addSrcId");
      if (i != -1) {
        break label17018;
      }
      paramawgp.a(new NoColumnError("addSrcId", Long.TYPE));
      label11474:
      i = paramCursor.getColumnIndex("addSubSrcId");
      if (i != -1) {
        break label17033;
      }
      paramawgp.a(new NoColumnError("addSubSrcId", Long.TYPE));
      label11511:
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label17048;
      }
      paramawgp.a(new NoColumnError("strVoteLimitedNotice", String.class));
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label17063;
      }
      paramawgp.a(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      label11585:
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label17078;
      }
      paramawgp.a(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      label11622:
      i = paramCursor.getColumnIndex("olympicTorch");
      if (i != -1) {
        break label17093;
      }
      paramawgp.a(new NoColumnError("olympicTorch", Byte.TYPE));
      i = paramCursor.getColumnIndex("mNowShowFlag");
      if (i != -1) {
        break label17109;
      }
      paramawgp.a(new NoColumnError("mNowShowFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("mNowShowIconUrl");
      if (i != -1) {
        break label17124;
      }
      paramawgp.a(new NoColumnError("mNowShowIconUrl", String.class));
      label11733:
      i = paramCursor.getColumnIndex("mNowShowJumpUrl");
      if (i != -1) {
        break label17139;
      }
      paramawgp.a(new NoColumnError("mNowShowJumpUrl", String.class));
      label11770:
      i = paramCursor.getColumnIndex("vCoverInfo");
      if (i != -1) {
        break label17154;
      }
      paramawgp.a(new NoColumnError("vCoverInfo", [B.class));
      i = paramCursor.getColumnIndex("videoHeadFlag");
      if (i != -1) {
        break label17169;
      }
      paramawgp.a(new NoColumnError("videoHeadFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("videoHeadUrl");
      if (i != -1) {
        break label17196;
      }
      paramawgp.a(new NoColumnError("videoHeadUrl", String.class));
      label11881:
      i = paramCursor.getColumnIndex("medalSwitchDisable");
      if (i != -1) {
        break label17211;
      }
      paramawgp.a(new NoColumnError("medalSwitchDisable", Boolean.TYPE));
      i = paramCursor.getColumnIndex("iMedalCount");
      if (i != -1) {
        break label17238;
      }
      paramawgp.a(new NoColumnError("iMedalCount", Integer.TYPE));
      label11955:
      i = paramCursor.getColumnIndex("iNewCount");
      if (i != -1) {
        break label17253;
      }
      paramawgp.a(new NoColumnError("iNewCount", Integer.TYPE));
      label11992:
      i = paramCursor.getColumnIndex("iUpgradeCount");
      if (i != -1) {
        break label17268;
      }
      paramawgp.a(new NoColumnError("iUpgradeCount", Integer.TYPE));
      label12029:
      i = paramCursor.getColumnIndex("strPromptParams");
      if (i != -1) {
        break label17283;
      }
      paramawgp.a(new NoColumnError("strPromptParams", String.class));
      i = paramCursor.getColumnIndex("hobbyEntry");
      if (i != -1) {
        break label17298;
      }
      paramawgp.a(new NoColumnError("hobbyEntry", String.class));
      label12103:
      i = paramCursor.getColumnIndex("lastPraiseInfoList");
      if (i != -1) {
        break label17313;
      }
      paramawgp.a(new NoColumnError("lastPraiseInfoList", [B.class));
      label12140:
      i = paramCursor.getColumnIndex("tempChatSig");
      if (i != -1) {
        break label17328;
      }
      paramawgp.a(new NoColumnError("tempChatSig", [B.class));
      i = paramCursor.getColumnIndex("namePlateOfKingGameId");
      if (i != -1) {
        break label17343;
      }
      paramawgp.a(new NoColumnError("namePlateOfKingGameId", Long.TYPE));
      label12214:
      i = paramCursor.getColumnIndex("namePlateOfKingLoginTime");
      if (i != -1) {
        break label17358;
      }
      paramawgp.a(new NoColumnError("namePlateOfKingLoginTime", Long.TYPE));
      label12251:
      i = paramCursor.getColumnIndex("namePlateOfKingDan");
      if (i != -1) {
        break label17373;
      }
      paramawgp.a(new NoColumnError("namePlateOfKingDan", Integer.TYPE));
      i = paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch");
      if (i != -1) {
        break label17388;
      }
      paramawgp.a(new NoColumnError("namePlateOfKingDanDisplatSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("vPersonalityLabelV2");
      if (i != -1) {
        break label17415;
      }
      paramawgp.a(new NoColumnError("vPersonalityLabelV2", [B.class));
      label12362:
      i = paramCursor.getColumnIndex("cardType");
      if (i != -1) {
        break label17430;
      }
      paramawgp.a(new NoColumnError("cardType", Integer.TYPE));
      label12399:
      i = paramCursor.getColumnIndex("diyText");
      if (i != -1) {
        break label17445;
      }
      paramawgp.a(new NoColumnError("diyText", String.class));
      i = paramCursor.getColumnIndex("diyTextFontId");
      if (i != -1) {
        break label17460;
      }
      paramawgp.a(new NoColumnError("diyTextFontId", Integer.TYPE));
      label12473:
      i = paramCursor.getColumnIndex("diyTextWidth");
      if (i != -1) {
        break label17475;
      }
      paramawgp.a(new NoColumnError("diyTextWidth", Float.TYPE));
      label12510:
      i = paramCursor.getColumnIndex("diyTextHeight");
      if (i != -1) {
        break label17490;
      }
      paramawgp.a(new NoColumnError("diyTextHeight", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextLocX");
      if (i != -1) {
        break label17505;
      }
      paramawgp.a(new NoColumnError("diyTextLocX", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextLocY");
      if (i != -1) {
        break label17520;
      }
      paramawgp.a(new NoColumnError("diyTextLocY", Float.TYPE));
      label12621:
      i = paramCursor.getColumnIndex("diyTextDegree");
      if (i != -1) {
        break label17535;
      }
      paramawgp.a(new NoColumnError("diyTextDegree", Float.TYPE));
      label12658:
      i = paramCursor.getColumnIndex("diyTextScale");
      if (i != -1) {
        break label17550;
      }
      paramawgp.a(new NoColumnError("diyTextScale", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextTransparency");
      if (i != -1) {
        break label17565;
      }
      paramawgp.a(new NoColumnError("diyTextTransparency", Float.TYPE));
      label12732:
      i = paramCursor.getColumnIndex("diyDefaultText");
      if (i != -1) {
        break label17580;
      }
      paramawgp.a(new NoColumnError("diyDefaultText", String.class));
      label12769:
      i = paramCursor.getColumnIndex("popularity");
      if (i != -1) {
        break label17595;
      }
      paramawgp.a(new NoColumnError("popularity", Integer.TYPE));
      i = paramCursor.getColumnIndex("declaration");
      if (i != -1) {
        break label17610;
      }
      paramawgp.a(new NoColumnError("declaration", String.class));
      i = paramCursor.getColumnIndex("voiceUrl");
      if (i != -1) {
        break label17625;
      }
      paramawgp.a(new NoColumnError("voiceUrl", String.class));
      label12880:
      i = paramCursor.getColumnIndex("isShowCard");
      if (i != -1) {
        break label17640;
      }
      paramawgp.a(new NoColumnError("isShowCard", Boolean.TYPE));
      i = paramCursor.getColumnIndex("updateTime");
      if (i != -1) {
        break label17667;
      }
      paramawgp.a(new NoColumnError("updateTime", Long.TYPE));
      i = paramCursor.getColumnIndex("extendFriendFlag");
      if (i != -1) {
        break label17682;
      }
      paramawgp.a(new NoColumnError("extendFriendFlag", Integer.TYPE));
      label12991:
      i = paramCursor.getColumnIndex("extendFriendVoiceDuration");
      if (i != -1) {
        break label17697;
      }
      paramawgp.a(new NoColumnError("extendFriendVoiceDuration", Integer.TYPE));
      label13028:
      i = paramCursor.getColumnIndex("extendFriendEntryContact");
      if (i != -1) {
        break label17712;
      }
      paramawgp.a(new NoColumnError("extendFriendEntryContact", Short.TYPE));
      i = paramCursor.getColumnIndex("extendFriendEntryAddFriend");
      if (i != -1) {
        break label17727;
      }
      paramawgp.a(new NoColumnError("extendFriendEntryAddFriend", Short.TYPE));
      i = paramCursor.getColumnIndex("extendFriendQuestion");
      if (i != -1) {
        break label17742;
      }
      paramawgp.a(new NoColumnError("extendFriendQuestion", Short.TYPE));
      label13139:
      i = paramCursor.getColumnIndex("fontId");
      if (i != -1) {
        break label17757;
      }
      paramawgp.a(new NoColumnError("fontId", Integer.TYPE));
      label13176:
      i = paramCursor.getColumnIndex("fontType");
      if (i != -1) {
        break label17772;
      }
      paramawgp.a(new NoColumnError("fontType", Integer.TYPE));
      i = paramCursor.getColumnIndex("clothesId");
      if (i != -1) {
        break label17787;
      }
      paramawgp.a(new NoColumnError("clothesId", Integer.TYPE));
      label13250:
      i = paramCursor.getColumnIndex("schoolId");
      if (i != -1) {
        break label17802;
      }
      paramawgp.a(new NoColumnError("schoolId", String.class));
      label13287:
      i = paramCursor.getColumnIndex("schoolName");
      if (i != -1) {
        break label17817;
      }
      paramawgp.a(new NoColumnError("schoolName", String.class));
      i = paramCursor.getColumnIndex("authState");
      if (i != -1) {
        break label17832;
      }
      paramawgp.a(new NoColumnError("authState", Long.TYPE));
      label13361:
      i = paramCursor.getColumnIndex("idx");
      if (i != -1) {
        break label17847;
      }
      paramawgp.a(new NoColumnError("idx", Integer.TYPE));
      label13398:
      i = paramCursor.getColumnIndex("category");
      if (i != -1) {
        break label17862;
      }
      paramawgp.a(new NoColumnError("category", Integer.TYPE));
      label13435:
      i = paramCursor.getColumnIndex("isShowMiniPlaying");
      if (i != -1) {
        break label17877;
      }
      paramawgp.a(new NoColumnError("isShowMiniPlaying", Boolean.TYPE));
      i = paramCursor.getColumnIndex("tabJumpUrl");
      if (i != -1) {
        break label17904;
      }
      paramawgp.a(new NoColumnError("tabJumpUrl", String.class));
      label13509:
      i = paramCursor.getColumnIndex("guestJumpUrl");
      if (i != -1) {
        break label17919;
      }
      paramawgp.a(new NoColumnError("guestJumpUrl", String.class));
      label13546:
      i = paramCursor.getColumnIndex("guestAppTotal");
      if (i != -1) {
        break label17934;
      }
      paramawgp.a(new NoColumnError("guestAppTotal", Integer.TYPE));
      i = paramCursor.getColumnIndex("defaultCardId");
      if (i != -1) {
        break label17949;
      }
      paramawgp.a(new NoColumnError("defaultCardId", Integer.TYPE));
      label13620:
      i = paramCursor.getColumnIndex("strangerVoteOpen");
      if (i != -1) {
        break label17964;
      }
      paramawgp.a(new NoColumnError("strangerVoteOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("lSuperVipTemplateId");
      if (i != -1) {
        break label17991;
      }
      paramawgp.a(new NoColumnError("lSuperVipTemplateId", Long.TYPE));
      label13694:
      i = paramCursor.getColumnIndex("bBigClubVipOpen");
      if (i != -1) {
        break label18006;
      }
      paramawgp.a(new NoColumnError("bBigClubVipOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iBigClubVipType");
      if (i != -1) {
        break label18022;
      }
      paramawgp.a(new NoColumnError("iBigClubVipType", Integer.TYPE));
      label13768:
      i = paramCursor.getColumnIndex("iBigClubVipLevel");
      if (i != -1) {
        break label18037;
      }
      paramawgp.a(new NoColumnError("iBigClubVipLevel", Integer.TYPE));
      label13805:
      i = paramCursor.getColumnIndex("lBigClubTemplateId");
      if (i != -1) {
        break label18052;
      }
      paramawgp.a(new NoColumnError("lBigClubTemplateId", Long.TYPE));
      i = paramCursor.getColumnIndex("diyComplicatedInfo");
      if (i != -1) {
        break label18067;
      }
      paramawgp.a(new NoColumnError("diyComplicatedInfo", String.class));
      label13879:
      i = paramCursor.getColumnIndex("cardId");
      if (i != -1) {
        break label18082;
      }
      paramawgp.a(new NoColumnError("cardId", Long.TYPE));
      label13916:
      i = paramCursor.getColumnIndex("strangerInviteMeGroupOpen");
      if (i != -1) {
        break label18097;
      }
      paramawgp.a(new NoColumnError("strangerInviteMeGroupOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isPrettyGroupOwner");
      if (i != -1) {
        break label18124;
      }
      paramawgp.a(new NoColumnError("isPrettyGroupOwner", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isHidePrettyGroutIdentity");
      if (i != -1) {
        break label18151;
      }
      paramawgp.a(new NoColumnError("isHidePrettyGroutIdentity", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mQQLevelType");
      if (i != -1) {
        break label18178;
      }
      paramawgp.a(new NoColumnError("mQQLevelType", Integer.TYPE));
    }
    for (;;)
    {
      label3200:
      label4226:
      label4518:
      label5416:
      label5801:
      label6186:
      label6571:
      label6960:
      i = paramCursor.getColumnIndex("schoolVerifiedFlag");
      label4620:
      label4877:
      label5006:
      label5011:
      label5016:
      label5021:
      label5026:
      label7330:
      label7848:
      label8107:
      label8366:
      label10031:
      label11696:
      if (i != -1) {
        break label18193;
      }
      label4996:
      label5001:
      label5136:
      label5276:
      label5661:
      label6046:
      label6431:
      label6816:
      label8995:
      label9254:
      label9513:
      label11178:
      label11437:
      label13102:
      paramawgp.a(new NoColumnError("schoolVerifiedFlag", Boolean.TYPE));
      label5381:
      label5521:
      label5906:
      label6291:
      label6676:
      label7071:
      label8736:
      label10401:
      label10660:
      label10919:
      label12584:
      label12843:
      i = paramCursor.getColumnIndex("troopHonorSwitch");
      label5766:
      label6151:
      label6536:
      label6923:
      label7182:
      label7441:
      label7700:
      label7959:
      label8218:
      label8477:
      label10142:
      label11807:
      label12066:
      label13731:
      if (i != -1) {
        break label18220;
      }
      label7552:
      label7811:
      label8070:
      label8329:
      label8588:
      label8847:
      label9106:
      label9365:
      label9624:
      label9883:
      label11548:
      label13213:
      paramawgp.a(new NoColumnError("troopHonorSwitch", Boolean.TYPE));
      label9217:
      label9476:
      label10253:
      label10512:
      label10771:
      label11289:
      label12954:
      return paramawge;
      label10882:
      label11141:
      label11659:
      label12177:
      label12436:
      label12695:
      paramawge.uin = paramCursor.getString(i);
      label12288:
      label12547:
      label12806:
      label13065:
      label13324:
      label13583:
      label13842:
      break;
      label14155:
      paramawge.strNick = paramCursor.getString(i);
      break label5136;
      label14170:
      paramawge.shGender = paramCursor.getShort(i);
      break label5171;
      label14185:
      paramawge.shAge = paramCursor.getShort(i);
      break label5206;
      label14200:
      paramawge.nFaceID = paramCursor.getInt(i);
      break label5241;
      label14215:
      paramawge.strCertificationInfo = paramCursor.getString(i);
      break label5276;
      label14230:
      paramawge.shType = paramCursor.getShort(i);
      break label5311;
      label14245:
      paramawge.vContent = paramCursor.getBlob(i);
      break label5346;
      label14260:
      paramawge.strSign = paramCursor.getString(i);
      break label5381;
      label14275:
      paramawge.strCompany = paramCursor.getString(i);
      break label5416;
      label14290:
      paramawge.strSchool = paramCursor.getString(i);
      break label5451;
      label14305:
      paramawge.uFaceTimeStamp = paramCursor.getInt(i);
      break label5486;
      label14320:
      paramawge.vQQFaceID = paramCursor.getBlob(i);
      break label5521;
      label14335:
      paramawge.strReMark = paramCursor.getString(i);
      break label5556;
      label14350:
      paramawge.bWeiboInfo = ((byte)paramCursor.getShort(i));
      break label5591;
      label14366:
      paramawge.bQzoneInfo = ((byte)paramCursor.getShort(i));
      break label5626;
      label14382:
      paramawge.nSameFriendsNum = paramCursor.getInt(i);
      break label5661;
      label14397:
      paramawge.strCompanySame = paramCursor.getString(i);
      break label5696;
      label14412:
      paramawge.strSchoolSame = paramCursor.getString(i);
      break label5731;
      label14427:
      paramawge.lCardShowNum = paramCursor.getLong(i);
      break label5766;
      label14442:
      paramawge.bSingle = ((byte)paramCursor.getShort(i));
      break label5801;
      label14458:
      paramawge.lVisitCount = paramCursor.getLong(i);
      break label5836;
      label14473:
      paramawge.lVoteCount = paramCursor.getLong(i);
      break label5871;
      label14488:
      paramawge.tagInfosByte = paramCursor.getBlob(i);
      break label5906;
      label14503:
      paramawge.eUserIdentityType = ((byte)paramCursor.getShort(i));
      break label5941;
      label14519:
      paramawge.vBackground = paramCursor.getBlob(i);
      break label5976;
      label14534:
      paramawge.labelInfoBytes = paramCursor.getBlob(i);
      break label6011;
      label14549:
      paramawge.age = ((byte)paramCursor.getShort(i));
      break label6046;
      label14565:
      paramawge.constellation = paramCursor.getInt(i);
      break label6081;
      label14580:
      paramawge.pyFaceUrl = paramCursor.getString(i);
      break label6116;
      label14595:
      paramawge.location = paramCursor.getString(i);
      break label6151;
      label14610:
      paramawge.bVoted = ((byte)paramCursor.getShort(i));
      break label6186;
      label14626:
      paramawge.bFavorited = ((byte)paramCursor.getShort(i));
      break label6221;
      label14642:
      paramawge.iVoteIncrement = paramCursor.getInt(i);
      break label6256;
      label14657:
      paramawge.strJoinHexAlbumFileKey = paramCursor.getString(i);
      break label6291;
      label14672:
      paramawge.iFaceNum = paramCursor.getInt(i);
      break label6326;
      label14687:
      paramawge.cSqqLevel = ((byte)paramCursor.getShort(i));
      break label6361;
      label14703:
      paramawge.iQQLevel = paramCursor.getInt(i);
      break label6396;
      label14718:
      paramawge.uCurMulType = paramCursor.getLong(i);
      break label6431;
      label14733:
      paramawge.strProvince = paramCursor.getString(i);
      break label6466;
      label14748:
      paramawge.strCity = paramCursor.getString(i);
      break label6501;
      label14763:
      paramawge.strCountry = paramCursor.getString(i);
      break label6536;
      label14778:
      paramawge.lBirthday = paramCursor.getLong(i);
      break label6571;
      label14793:
      paramawge.strLocationCodes = paramCursor.getString(i);
      break label6606;
      label14808:
      paramawge.strLocationDesc = paramCursor.getString(i);
      break label6641;
      label14823:
      paramawge.strHometownCodes = paramCursor.getString(i);
      break label6676;
      label14838:
      paramawge.strHometownDesc = paramCursor.getString(i);
      break label6711;
      label14853:
      paramawge.strEmail = paramCursor.getString(i);
      break label6746;
      label14868:
      paramawge.strPersonalNote = paramCursor.getString(i);
      break label6781;
      label14883:
      paramawge.iProfession = paramCursor.getInt(i);
      break label6816;
      label14898:
      paramawge.bindPhoneInfo = paramCursor.getString(i);
      break label6851;
      label14913:
      paramawge.bCardInfo = paramCursor.getBlob(i);
      break label6886;
      label14928:
      paramawge.strTroopName = paramCursor.getString(i);
      break label6923;
      label14943:
      paramawge.strTroopNick = paramCursor.getString(i);
      break label6960;
      label14958:
      paramawge.strMobile = paramCursor.getString(i);
      break label6997;
      label14973:
      paramawge.strContactName = paramCursor.getString(i);
      break label7034;
      label14988:
      paramawge.ulShowControl = paramCursor.getInt(i);
      break label7071;
      label15003:
      paramawge.feedPreviewTime = paramCursor.getLong(i);
      break label7108;
      label15018:
      paramawge.strQzoneFeedsDesc = paramCursor.getString(i);
      break label7145;
      label15033:
      paramawge.StrPresentDesc = paramCursor.getString(i);
      break label7182;
      label15048:
      paramawge.strSpaceName = paramCursor.getString(i);
      break label7219;
      label15063:
      paramawge.strQzoneHeader = paramCursor.getString(i);
      break label7256;
      label15078:
      paramawge.vQzonePhotos = paramCursor.getBlob(i);
      break label7293;
      label15093:
      paramawge.vQzoneCoverInfo = paramCursor.getBlob(i);
      break label7330;
      label15108:
      paramawge.enlargeQzonePic = paramCursor.getInt(i);
      break label7367;
      label15123:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.showPublishButton = paramBoolean;
        break;
      }
      label15150:
      paramawge.strStatus = paramCursor.getString(i);
      break label7441;
      label15165:
      paramawge.strAutoRemark = paramCursor.getString(i);
      break label7478;
      label15180:
      paramawge.vSeed = paramCursor.getBlob(i);
      break label7515;
      label15195:
      paramawge.vCookies = paramCursor.getBlob(i);
      break label7552;
      label15210:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.hasFakeData = paramBoolean;
        break;
      }
      label15237:
      paramawge.bQQVipOpen = ((byte)paramCursor.getShort(i));
      break label7626;
      label15253:
      paramawge.iQQVipType = paramCursor.getInt(i);
      break label7663;
      label15268:
      paramawge.iQQVipLevel = paramCursor.getInt(i);
      break label7700;
      label15283:
      paramawge.nameplateVipType = paramCursor.getInt(i);
      break label7737;
      label15298:
      paramawge.grayNameplateFlag = paramCursor.getInt(i);
      break label7774;
      label15313:
      paramawge.bSuperVipOpen = ((byte)paramCursor.getShort(i));
      break label7811;
      label15329:
      paramawge.iSuperVipType = paramCursor.getInt(i);
      break label7848;
      label15344:
      paramawge.iSuperVipLevel = paramCursor.getInt(i);
      break label7885;
      label15359:
      paramawge.bSuperQQOpen = ((byte)paramCursor.getShort(i));
      break label7922;
      label15375:
      paramawge.iSuperQQType = paramCursor.getInt(i);
      break label7959;
      label15390:
      paramawge.iSuperQQLevel = paramCursor.getInt(i);
      break label7996;
      label15405:
      paramawge.bHollywoodVipOpen = ((byte)paramCursor.getShort(i));
      break label8033;
      label15421:
      paramawge.iHollywoodVipType = paramCursor.getInt(i);
      break label8070;
      label15436:
      paramawge.iHollywoodVipLevel = paramCursor.getInt(i);
      break label8107;
      label15451:
      paramawge.strShowName = paramCursor.getString(i);
      break label8144;
      label15466:
      paramawge.strVoiceFilekey = paramCursor.getString(i);
      break label8181;
      label15481:
      paramawge.shDuration = paramCursor.getShort(i);
      break label8218;
      label15496:
      paramawge.bRead = ((byte)paramCursor.getShort(i));
      break label8255;
      label15512:
      paramawge.strUrl = paramCursor.getString(i);
      break label8292;
      label15527:
      paramawge.vRichSign = paramCursor.getBlob(i);
      break label8329;
      label15542:
      paramawge.lSignModifyTime = paramCursor.getLong(i);
      break label8366;
      label15557:
      paramawge.vLongNickTopicInfo = paramCursor.getBlob(i);
      break label8403;
      label15572:
      paramawge.nLastGameFlag = paramCursor.getInt(i);
      break label8440;
      label15587:
      paramawge.strGameLogoUrl_1 = paramCursor.getString(i);
      break label8477;
      label15602:
      paramawge.strGameLogoUrl_2 = paramCursor.getString(i);
      break label8514;
      label15617:
      paramawge.strGameLogoUrl_3 = paramCursor.getString(i);
      break label8551;
      label15632:
      paramawge.strGameLogoUrl_4 = paramCursor.getString(i);
      break label8588;
      label15647:
      paramawge.strGameLogoKey_1 = paramCursor.getString(i);
      break label8625;
      label15662:
      paramawge.strGameLogoKey_2 = paramCursor.getString(i);
      break label8662;
      label15677:
      paramawge.strGameLogoKey_3 = paramCursor.getString(i);
      break label8699;
      label15692:
      paramawge.strGameLogoKey_4 = paramCursor.getString(i);
      break label8736;
      label15707:
      paramawge.strGameName_1 = paramCursor.getString(i);
      break label8773;
      label15722:
      paramawge.strGameName_2 = paramCursor.getString(i);
      break label8810;
      label15737:
      paramawge.strGameName_3 = paramCursor.getString(i);
      break label8847;
      label15752:
      paramawge.strGameName_4 = paramCursor.getString(i);
      break label8884;
      label15767:
      paramawge.strGameAppid_1 = paramCursor.getString(i);
      break label8921;
      label15782:
      paramawge.strGameAppid_2 = paramCursor.getString(i);
      break label8958;
      label15797:
      paramawge.strGameAppid_3 = paramCursor.getString(i);
      break label8995;
      label15812:
      paramawge.strGameAppid_4 = paramCursor.getString(i);
      break label9032;
      label15827:
      paramawge.strProfileUrl = paramCursor.getString(i);
      break label9069;
      label15842:
      paramawge.nStarFansFlag = paramCursor.getInt(i);
      break label9106;
      label15857:
      paramawge.strStarPicUrl_0 = paramCursor.getString(i);
      break label9143;
      label15872:
      paramawge.strStarPicUrl_1 = paramCursor.getString(i);
      break label9180;
      label15887:
      paramawge.strStarPicUrl_2 = paramCursor.getString(i);
      break label9217;
      label15902:
      paramawge.strStarLvUrl_0 = paramCursor.getString(i);
      break label9254;
      label15917:
      paramawge.strStarLvUrl_1 = paramCursor.getString(i);
      break label9291;
      label15932:
      paramawge.strStarLvUrl_2 = paramCursor.getString(i);
      break label9328;
      label15947:
      paramawge.strStarLogoUrl = paramCursor.getString(i);
      break label9365;
      label15962:
      paramawge.starFansJumpUrl = paramCursor.getString(i);
      break label9402;
      label15977:
      paramawge.lUserFlag = paramCursor.getLong(i);
      break label9439;
      label15992:
      paramawge.lLoginDays = paramCursor.getLong(i);
      break label9476;
      label16007:
      paramawge.strLoginDaysDesc = paramCursor.getString(i);
      break label9513;
      label16022:
      paramawge.lQQMasterLogindays = paramCursor.getLong(i);
      break label9550;
      label16037:
      paramawge.iXManScene1DelayTime = paramCursor.getInt(i);
      break label9587;
      label16052:
      paramawge.iXManScene2DelayTime = paramCursor.getInt(i);
      break label9624;
      label16067:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.allowPeopleSee = paramBoolean;
        break;
      }
      label16094:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.allowCalInteractive = paramBoolean;
        break;
      }
      label16121:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.showOnlineFriends = paramBoolean;
        break;
      }
      label16148:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.allowClick = paramBoolean;
        break;
      }
      label16175:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.babyQSwitch = paramBoolean;
        break;
      }
      label16202:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.showLightalk = paramBoolean;
        break;
      }
      label16229:
      paramawge.lightalkNick = paramCursor.getString(i);
      break label9883;
      label16244:
      paramawge.lightalkId = paramCursor.getString(i);
      break label9920;
      label16259:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isSuperRedDiamond = paramBoolean;
        break;
      }
      label16286:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isRedDiamond = paramBoolean;
        break;
      }
      label16313:
      paramawge.redLevel = paramCursor.getInt(i);
      break label10031;
      label16328:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isSuperYellowDiamond = paramBoolean;
        break;
      }
      label16355:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isYellowDiamond = paramBoolean;
        break;
      }
      label16382:
      paramawge.yellowLevel = paramCursor.getInt(i);
      break label10142;
      label16397:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isSuperGreenDiamond = paramBoolean;
        break;
      }
      label16424:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isGreenDiamond = paramBoolean;
        break;
      }
      label16451:
      paramawge.greenLevel = paramCursor.getInt(i);
      break label10253;
      label16466:
      paramawge.uAccelerateMultiple = paramCursor.getLong(i);
      break label10290;
      label16481:
      paramawge.strRespMusicInfo = paramCursor.getString(i);
      break label10327;
      label16496:
      paramawge.templateRet = paramCursor.getInt(i);
      break label10364;
      label16511:
      paramawge.lCurrentStyleId = paramCursor.getLong(i);
      break label10401;
      label16526:
      paramawge.lCurrentBgId = paramCursor.getLong(i);
      break label10438;
      label16541:
      paramawge.backgroundUrl = paramCursor.getString(i);
      break label10475;
      label16556:
      paramawge.backgroundColor = paramCursor.getLong(i);
      break label10512;
      label16571:
      paramawge.dynamicCardFlag = paramCursor.getInt(i);
      break label10549;
      label16586:
      paramawge.strZipUrl = paramCursor.getString(i);
      break label10586;
      label16601:
      paramawge.strActiveUrl = paramCursor.getString(i);
      break label10623;
      label16616:
      paramawge.strDrawerCardUrl = paramCursor.getString(i);
      break label10660;
      label16631:
      paramawge.strWzryHeroUrl = paramCursor.getString(i);
      break label10697;
      label16646:
      paramawge.wzryHonorInfo = paramCursor.getBlob(i);
      break label10734;
      label16661:
      paramawge.strExtInfo = paramCursor.getString(i);
      break label10771;
      label16676:
      paramawge.strCurrentBgUrl = paramCursor.getString(i);
      break label10808;
      label16691:
      paramawge.bgType = paramCursor.getBlob(i);
      break label10845;
      label16706:
      paramawge.encId = paramCursor.getString(i);
      break label10882;
      label16721:
      paramawge.busiEntry = paramCursor.getString(i);
      break label10919;
      label16736:
      paramawge.favoriteSource = paramCursor.getInt(i);
      break label10956;
      label16751:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.visibleMusicPendant = paramBoolean;
        break;
      }
      label16778:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.autoPlayMusicPendant = paramBoolean;
        break;
      }
      label16805:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.showRedPointMusicPendant = paramBoolean;
        break;
      }
      label16832:
      paramawge.privilegePromptStr = paramCursor.getString(i);
      break label11104;
      label16847:
      paramawge.privilegeJumpUrl = paramCursor.getString(i);
      break label11141;
      label16862:
      paramawge.vOpenPriv = paramCursor.getBlob(i);
      break label11178;
      label16877:
      paramawge.vClosePriv = paramCursor.getBlob(i);
      break label11215;
      label16892:
      paramawge.presentDesc = paramCursor.getString(i);
      break label11252;
      label16907:
      paramawge.presentCustourl = paramCursor.getString(i);
      break label11289;
      label16922:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.presentSwitch = paramBoolean;
        break;
      }
      label16949:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.showPresent = paramBoolean;
        break;
      }
      label16976:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.showMusicBox = paramBoolean;
        break;
      }
      label17003:
      paramawge.addSrcName = paramCursor.getString(i);
      break label11437;
      label17018:
      paramawge.addSrcId = paramCursor.getLong(i);
      break label11474;
      label17033:
      paramawge.addSubSrcId = paramCursor.getLong(i);
      break label11511;
      label17048:
      paramawge.strVoteLimitedNotice = paramCursor.getString(i);
      break label11548;
      label17063:
      paramawge.bHaveVotedCnt = paramCursor.getShort(i);
      break label11585;
      label17078:
      paramawge.bAvailVoteCnt = paramCursor.getShort(i);
      break label11622;
      label17093:
      paramawge.olympicTorch = ((byte)paramCursor.getShort(i));
      break label11659;
      label17109:
      paramawge.mNowShowFlag = paramCursor.getInt(i);
      break label11696;
      label17124:
      paramawge.mNowShowIconUrl = paramCursor.getString(i);
      break label11733;
      label17139:
      paramawge.mNowShowJumpUrl = paramCursor.getString(i);
      break label11770;
      label17154:
      paramawge.vCoverInfo = paramCursor.getBlob(i);
      break label11807;
      label17169:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.videoHeadFlag = paramBoolean;
        break;
      }
      label17196:
      paramawge.videoHeadUrl = paramCursor.getString(i);
      break label11881;
      label17211:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.medalSwitchDisable = paramBoolean;
        break;
      }
      label17238:
      paramawge.iMedalCount = paramCursor.getInt(i);
      break label11955;
      label17253:
      paramawge.iNewCount = paramCursor.getInt(i);
      break label11992;
      label17268:
      paramawge.iUpgradeCount = paramCursor.getInt(i);
      break label12029;
      label17283:
      paramawge.strPromptParams = paramCursor.getString(i);
      break label12066;
      label17298:
      paramawge.hobbyEntry = paramCursor.getString(i);
      break label12103;
      label17313:
      paramawge.lastPraiseInfoList = paramCursor.getBlob(i);
      break label12140;
      label17328:
      paramawge.tempChatSig = paramCursor.getBlob(i);
      break label12177;
      label17343:
      paramawge.namePlateOfKingGameId = paramCursor.getLong(i);
      break label12214;
      label17358:
      paramawge.namePlateOfKingLoginTime = paramCursor.getLong(i);
      break label12251;
      label17373:
      paramawge.namePlateOfKingDan = paramCursor.getInt(i);
      break label12288;
      label17388:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.namePlateOfKingDanDisplatSwitch = paramBoolean;
        break;
      }
      label17415:
      paramawge.vPersonalityLabelV2 = paramCursor.getBlob(i);
      break label12362;
      label17430:
      paramawge.cardType = paramCursor.getInt(i);
      break label12399;
      label17445:
      paramawge.diyText = paramCursor.getString(i);
      break label12436;
      label17460:
      paramawge.diyTextFontId = paramCursor.getInt(i);
      break label12473;
      label17475:
      paramawge.diyTextWidth = paramCursor.getFloat(i);
      break label12510;
      label17490:
      paramawge.diyTextHeight = paramCursor.getFloat(i);
      break label12547;
      label17505:
      paramawge.diyTextLocX = paramCursor.getFloat(i);
      break label12584;
      label17520:
      paramawge.diyTextLocY = paramCursor.getFloat(i);
      break label12621;
      label17535:
      paramawge.diyTextDegree = paramCursor.getFloat(i);
      break label12658;
      label17550:
      paramawge.diyTextScale = paramCursor.getFloat(i);
      break label12695;
      label17565:
      paramawge.diyTextTransparency = paramCursor.getFloat(i);
      break label12732;
      label17580:
      paramawge.diyDefaultText = paramCursor.getString(i);
      break label12769;
      label17595:
      paramawge.popularity = paramCursor.getInt(i);
      break label12806;
      label17610:
      paramawge.declaration = paramCursor.getString(i);
      break label12843;
      label17625:
      paramawge.voiceUrl = paramCursor.getString(i);
      break label12880;
      label17640:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isShowCard = paramBoolean;
        break;
      }
      label17667:
      paramawge.updateTime = paramCursor.getLong(i);
      break label12954;
      label17682:
      paramawge.extendFriendFlag = paramCursor.getInt(i);
      break label12991;
      label17697:
      paramawge.extendFriendVoiceDuration = paramCursor.getInt(i);
      break label13028;
      label17712:
      paramawge.extendFriendEntryContact = paramCursor.getShort(i);
      break label13065;
      label17727:
      paramawge.extendFriendEntryAddFriend = paramCursor.getShort(i);
      break label13102;
      label17742:
      paramawge.extendFriendQuestion = paramCursor.getShort(i);
      break label13139;
      label17757:
      paramawge.fontId = paramCursor.getInt(i);
      break label13176;
      label17772:
      paramawge.fontType = paramCursor.getInt(i);
      break label13213;
      label17787:
      paramawge.clothesId = paramCursor.getInt(i);
      break label13250;
      label17802:
      paramawge.schoolId = paramCursor.getString(i);
      break label13287;
      label17817:
      paramawge.schoolName = paramCursor.getString(i);
      break label13324;
      label17832:
      paramawge.authState = paramCursor.getLong(i);
      break label13361;
      label17847:
      paramawge.idx = paramCursor.getInt(i);
      break label13398;
      label17862:
      paramawge.category = paramCursor.getInt(i);
      break label13435;
      label17877:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isShowMiniPlaying = paramBoolean;
        break;
      }
      label17904:
      paramawge.tabJumpUrl = paramCursor.getString(i);
      break label13509;
      label17919:
      paramawge.guestJumpUrl = paramCursor.getString(i);
      break label13546;
      label17934:
      paramawge.guestAppTotal = paramCursor.getInt(i);
      break label13583;
      label17949:
      paramawge.defaultCardId = paramCursor.getInt(i);
      break label13620;
      label17964:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.strangerVoteOpen = paramBoolean;
        break;
      }
      label17991:
      paramawge.lSuperVipTemplateId = paramCursor.getLong(i);
      break label13694;
      label18006:
      paramawge.bBigClubVipOpen = ((byte)paramCursor.getShort(i));
      break label13731;
      label18022:
      paramawge.iBigClubVipType = paramCursor.getInt(i);
      break label13768;
      label18037:
      paramawge.iBigClubVipLevel = paramCursor.getInt(i);
      break label13805;
      label18052:
      paramawge.lBigClubTemplateId = paramCursor.getLong(i);
      break label13842;
      label18067:
      paramawge.diyComplicatedInfo = paramCursor.getString(i);
      break label13879;
      label18082:
      paramawge.cardId = paramCursor.getLong(i);
      break label13916;
      label18097:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.strangerInviteMeGroupOpen = paramBoolean;
        break;
      }
      label18124:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isPrettyGroupOwner = paramBoolean;
        break;
      }
      label18151:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isHidePrettyGroutIdentity = paramBoolean;
        break;
      }
      label18178:
      paramawge.mQQLevelType = paramCursor.getInt(i);
    }
    label18193:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramawge.schoolVerifiedFlag = paramBoolean;
      break;
    }
    label18220:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramawge.troopHonorSwitch = paramBoolean;
      return paramawge;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,strNick TEXT ,shGender INTEGER ,shAge INTEGER ,nFaceID INTEGER ,strCertificationInfo TEXT ,shType INTEGER ,vContent BLOB ,strSign TEXT ,strCompany TEXT ,strSchool TEXT ,uFaceTimeStamp INTEGER ,vQQFaceID BLOB ,strReMark TEXT ,bWeiboInfo INTEGER ,bQzoneInfo INTEGER ,nSameFriendsNum INTEGER ,strCompanySame TEXT ,strSchoolSame TEXT ,lCardShowNum INTEGER ,bSingle INTEGER ,lVisitCount INTEGER ,lVoteCount INTEGER ,tagInfosByte BLOB ,eUserIdentityType INTEGER ,vBackground BLOB ,labelInfoBytes BLOB ,age INTEGER ,constellation INTEGER ,pyFaceUrl TEXT ,location TEXT ,bVoted INTEGER ,bFavorited INTEGER ,iVoteIncrement INTEGER ,strJoinHexAlbumFileKey TEXT ,iFaceNum INTEGER ,cSqqLevel INTEGER ,iQQLevel INTEGER ,uCurMulType INTEGER ,strProvince TEXT ,strCity TEXT ,strCountry TEXT ,lBirthday INTEGER ,strLocationCodes TEXT ,strLocationDesc TEXT ,strHometownCodes TEXT ,strHometownDesc TEXT ,strEmail TEXT ,strPersonalNote TEXT ,iProfession INTEGER ,bindPhoneInfo TEXT ,bCardInfo BLOB ,strTroopName TEXT ,strTroopNick TEXT ,strMobile TEXT ,strContactName TEXT ,ulShowControl INTEGER ,feedPreviewTime INTEGER ,strQzoneFeedsDesc TEXT ,StrPresentDesc TEXT ,strSpaceName TEXT ,strQzoneHeader TEXT ,vQzonePhotos BLOB ,vQzoneCoverInfo BLOB ,enlargeQzonePic INTEGER ,showPublishButton INTEGER ,strStatus TEXT ,strAutoRemark TEXT ,vSeed BLOB ,vCookies BLOB ,hasFakeData INTEGER ,bQQVipOpen INTEGER ,iQQVipType INTEGER ,iQQVipLevel INTEGER ,nameplateVipType INTEGER ,grayNameplateFlag INTEGER ,bSuperVipOpen INTEGER ,iSuperVipType INTEGER ,iSuperVipLevel INTEGER ,bSuperQQOpen INTEGER ,iSuperQQType INTEGER ,iSuperQQLevel INTEGER ,bHollywoodVipOpen INTEGER ,iHollywoodVipType INTEGER ,iHollywoodVipLevel INTEGER ,strShowName TEXT ,strVoiceFilekey TEXT ,shDuration INTEGER ,bRead INTEGER ,strUrl TEXT ,vRichSign BLOB ,lSignModifyTime INTEGER ,vLongNickTopicInfo BLOB ,nLastGameFlag INTEGER ,strGameLogoUrl_1 TEXT ,strGameLogoUrl_2 TEXT ,strGameLogoUrl_3 TEXT ,strGameLogoUrl_4 TEXT ,strGameLogoKey_1 TEXT ,strGameLogoKey_2 TEXT ,strGameLogoKey_3 TEXT ,strGameLogoKey_4 TEXT ,strGameName_1 TEXT ,strGameName_2 TEXT ,strGameName_3 TEXT ,strGameName_4 TEXT ,strGameAppid_1 TEXT ,strGameAppid_2 TEXT ,strGameAppid_3 TEXT ,strGameAppid_4 TEXT ,strProfileUrl TEXT ,nStarFansFlag INTEGER ,strStarPicUrl_0 TEXT ,strStarPicUrl_1 TEXT ,strStarPicUrl_2 TEXT ,strStarLvUrl_0 TEXT ,strStarLvUrl_1 TEXT ,strStarLvUrl_2 TEXT ,strStarLogoUrl TEXT ,starFansJumpUrl TEXT ,lUserFlag INTEGER ,lLoginDays INTEGER ,strLoginDaysDesc TEXT ,lQQMasterLogindays INTEGER ,iXManScene1DelayTime INTEGER ,iXManScene2DelayTime INTEGER ,allowPeopleSee INTEGER ,allowCalInteractive INTEGER ,showOnlineFriends INTEGER ,allowClick INTEGER ,babyQSwitch INTEGER ,showLightalk INTEGER ,lightalkNick TEXT ,lightalkId TEXT ,isSuperRedDiamond INTEGER ,isRedDiamond INTEGER ,redLevel INTEGER ,isSuperYellowDiamond INTEGER ,isYellowDiamond INTEGER ,yellowLevel INTEGER ,isSuperGreenDiamond INTEGER ,isGreenDiamond INTEGER ,greenLevel INTEGER ,uAccelerateMultiple INTEGER ,strRespMusicInfo TEXT ,templateRet INTEGER ,lCurrentStyleId INTEGER ,lCurrentBgId INTEGER ,backgroundUrl TEXT ,backgroundColor INTEGER ,dynamicCardFlag INTEGER ,strZipUrl TEXT ,strActiveUrl TEXT ,strDrawerCardUrl TEXT ,strWzryHeroUrl TEXT ,wzryHonorInfo BLOB ,strExtInfo TEXT ,strCurrentBgUrl TEXT ,bgType BLOB ,encId TEXT ,busiEntry TEXT ,favoriteSource INTEGER ,visibleMusicPendant INTEGER ,autoPlayMusicPendant INTEGER ,showRedPointMusicPendant INTEGER ,privilegePromptStr TEXT ,privilegeJumpUrl TEXT ,vOpenPriv BLOB ,vClosePriv BLOB ,presentDesc TEXT ,presentCustourl TEXT ,presentSwitch INTEGER ,showPresent INTEGER ,showMusicBox INTEGER ,addSrcName TEXT ,addSrcId INTEGER ,addSubSrcId INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,olympicTorch INTEGER ,mNowShowFlag INTEGER ,mNowShowIconUrl TEXT ,mNowShowJumpUrl TEXT ,vCoverInfo BLOB ,videoHeadFlag INTEGER ,videoHeadUrl TEXT ,medalSwitchDisable INTEGER ,iMedalCount INTEGER ,iNewCount INTEGER ,iUpgradeCount INTEGER ,strPromptParams TEXT ,hobbyEntry TEXT ,lastPraiseInfoList BLOB ,tempChatSig BLOB ,namePlateOfKingGameId INTEGER ,namePlateOfKingLoginTime INTEGER ,namePlateOfKingDan INTEGER ,namePlateOfKingDanDisplatSwitch INTEGER ,vPersonalityLabelV2 BLOB ,cardType INTEGER ,diyText TEXT ,diyTextFontId INTEGER ,diyTextWidth REAL ,diyTextHeight REAL ,diyTextLocX REAL ,diyTextLocY REAL ,diyTextDegree REAL ,diyTextScale REAL ,diyTextTransparency REAL ,diyDefaultText TEXT ,popularity INTEGER ,declaration TEXT ,voiceUrl TEXT ,isShowCard INTEGER ,updateTime INTEGER ,extendFriendFlag INTEGER ,extendFriendVoiceDuration INTEGER ,extendFriendEntryContact INTEGER ,extendFriendEntryAddFriend INTEGER ,extendFriendQuestion INTEGER ,fontId INTEGER ,fontType INTEGER ,clothesId INTEGER ,schoolId TEXT ,schoolName TEXT ,authState INTEGER ,idx INTEGER ,category INTEGER ,isShowMiniPlaying INTEGER ,tabJumpUrl TEXT ,guestJumpUrl TEXT ,guestAppTotal INTEGER ,defaultCardId INTEGER ,strangerVoteOpen INTEGER ,lSuperVipTemplateId INTEGER ,bBigClubVipOpen INTEGER ,iBigClubVipType INTEGER ,iBigClubVipLevel INTEGER ,lBigClubTemplateId INTEGER ,diyComplicatedInfo TEXT ,cardId INTEGER ,strangerInviteMeGroupOpen INTEGER ,isPrettyGroupOwner INTEGER ,isHidePrettyGroutIdentity INTEGER ,mQQLevelType INTEGER ,schoolVerifiedFlag INTEGER ,troopHonorSwitch INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (Card)paramawge;
    paramContentValues.put("uin", paramawge.uin);
    paramContentValues.put("strNick", paramawge.strNick);
    paramContentValues.put("shGender", Short.valueOf(paramawge.shGender));
    paramContentValues.put("shAge", Short.valueOf(paramawge.shAge));
    paramContentValues.put("nFaceID", Integer.valueOf(paramawge.nFaceID));
    paramContentValues.put("strCertificationInfo", paramawge.strCertificationInfo);
    paramContentValues.put("shType", Short.valueOf(paramawge.shType));
    paramContentValues.put("vContent", paramawge.vContent);
    paramContentValues.put("strSign", paramawge.strSign);
    paramContentValues.put("strCompany", paramawge.strCompany);
    paramContentValues.put("strSchool", paramawge.strSchool);
    paramContentValues.put("uFaceTimeStamp", Integer.valueOf(paramawge.uFaceTimeStamp));
    paramContentValues.put("vQQFaceID", paramawge.vQQFaceID);
    paramContentValues.put("strReMark", paramawge.strReMark);
    paramContentValues.put("bWeiboInfo", Byte.valueOf(paramawge.bWeiboInfo));
    paramContentValues.put("bQzoneInfo", Byte.valueOf(paramawge.bQzoneInfo));
    paramContentValues.put("nSameFriendsNum", Integer.valueOf(paramawge.nSameFriendsNum));
    paramContentValues.put("strCompanySame", paramawge.strCompanySame);
    paramContentValues.put("strSchoolSame", paramawge.strSchoolSame);
    paramContentValues.put("lCardShowNum", Long.valueOf(paramawge.lCardShowNum));
    paramContentValues.put("bSingle", Byte.valueOf(paramawge.bSingle));
    paramContentValues.put("lVisitCount", Long.valueOf(paramawge.lVisitCount));
    paramContentValues.put("lVoteCount", Long.valueOf(paramawge.lVoteCount));
    paramContentValues.put("tagInfosByte", paramawge.tagInfosByte);
    paramContentValues.put("eUserIdentityType", Byte.valueOf(paramawge.eUserIdentityType));
    paramContentValues.put("vBackground", paramawge.vBackground);
    paramContentValues.put("labelInfoBytes", paramawge.labelInfoBytes);
    paramContentValues.put("age", Byte.valueOf(paramawge.age));
    paramContentValues.put("constellation", Integer.valueOf(paramawge.constellation));
    paramContentValues.put("pyFaceUrl", paramawge.pyFaceUrl);
    paramContentValues.put("location", paramawge.location);
    paramContentValues.put("bVoted", Byte.valueOf(paramawge.bVoted));
    paramContentValues.put("bFavorited", Byte.valueOf(paramawge.bFavorited));
    paramContentValues.put("iVoteIncrement", Integer.valueOf(paramawge.iVoteIncrement));
    paramContentValues.put("strJoinHexAlbumFileKey", paramawge.strJoinHexAlbumFileKey);
    paramContentValues.put("iFaceNum", Integer.valueOf(paramawge.iFaceNum));
    paramContentValues.put("cSqqLevel", Byte.valueOf(paramawge.cSqqLevel));
    paramContentValues.put("iQQLevel", Integer.valueOf(paramawge.iQQLevel));
    paramContentValues.put("uCurMulType", Long.valueOf(paramawge.uCurMulType));
    paramContentValues.put("strProvince", paramawge.strProvince);
    paramContentValues.put("strCity", paramawge.strCity);
    paramContentValues.put("strCountry", paramawge.strCountry);
    paramContentValues.put("lBirthday", Long.valueOf(paramawge.lBirthday));
    paramContentValues.put("strLocationCodes", paramawge.strLocationCodes);
    paramContentValues.put("strLocationDesc", paramawge.strLocationDesc);
    paramContentValues.put("strHometownCodes", paramawge.strHometownCodes);
    paramContentValues.put("strHometownDesc", paramawge.strHometownDesc);
    paramContentValues.put("strEmail", paramawge.strEmail);
    paramContentValues.put("strPersonalNote", paramawge.strPersonalNote);
    paramContentValues.put("iProfession", Integer.valueOf(paramawge.iProfession));
    paramContentValues.put("bindPhoneInfo", paramawge.bindPhoneInfo);
    paramContentValues.put("bCardInfo", paramawge.bCardInfo);
    paramContentValues.put("strTroopName", paramawge.strTroopName);
    paramContentValues.put("strTroopNick", paramawge.strTroopNick);
    paramContentValues.put("strMobile", paramawge.strMobile);
    paramContentValues.put("strContactName", paramawge.strContactName);
    paramContentValues.put("ulShowControl", Integer.valueOf(paramawge.ulShowControl));
    paramContentValues.put("feedPreviewTime", Long.valueOf(paramawge.feedPreviewTime));
    paramContentValues.put("strQzoneFeedsDesc", paramawge.strQzoneFeedsDesc);
    paramContentValues.put("StrPresentDesc", paramawge.StrPresentDesc);
    paramContentValues.put("strSpaceName", paramawge.strSpaceName);
    paramContentValues.put("strQzoneHeader", paramawge.strQzoneHeader);
    paramContentValues.put("vQzonePhotos", paramawge.vQzonePhotos);
    paramContentValues.put("vQzoneCoverInfo", paramawge.vQzoneCoverInfo);
    paramContentValues.put("enlargeQzonePic", Integer.valueOf(paramawge.enlargeQzonePic));
    paramContentValues.put("showPublishButton", Boolean.valueOf(paramawge.showPublishButton));
    paramContentValues.put("strStatus", paramawge.strStatus);
    paramContentValues.put("strAutoRemark", paramawge.strAutoRemark);
    paramContentValues.put("vSeed", paramawge.vSeed);
    paramContentValues.put("vCookies", paramawge.vCookies);
    paramContentValues.put("hasFakeData", Boolean.valueOf(paramawge.hasFakeData));
    paramContentValues.put("bQQVipOpen", Byte.valueOf(paramawge.bQQVipOpen));
    paramContentValues.put("iQQVipType", Integer.valueOf(paramawge.iQQVipType));
    paramContentValues.put("iQQVipLevel", Integer.valueOf(paramawge.iQQVipLevel));
    paramContentValues.put("nameplateVipType", Integer.valueOf(paramawge.nameplateVipType));
    paramContentValues.put("grayNameplateFlag", Integer.valueOf(paramawge.grayNameplateFlag));
    paramContentValues.put("bSuperVipOpen", Byte.valueOf(paramawge.bSuperVipOpen));
    paramContentValues.put("iSuperVipType", Integer.valueOf(paramawge.iSuperVipType));
    paramContentValues.put("iSuperVipLevel", Integer.valueOf(paramawge.iSuperVipLevel));
    paramContentValues.put("bSuperQQOpen", Byte.valueOf(paramawge.bSuperQQOpen));
    paramContentValues.put("iSuperQQType", Integer.valueOf(paramawge.iSuperQQType));
    paramContentValues.put("iSuperQQLevel", Integer.valueOf(paramawge.iSuperQQLevel));
    paramContentValues.put("bHollywoodVipOpen", Byte.valueOf(paramawge.bHollywoodVipOpen));
    paramContentValues.put("iHollywoodVipType", Integer.valueOf(paramawge.iHollywoodVipType));
    paramContentValues.put("iHollywoodVipLevel", Integer.valueOf(paramawge.iHollywoodVipLevel));
    paramContentValues.put("strShowName", paramawge.strShowName);
    paramContentValues.put("strVoiceFilekey", paramawge.strVoiceFilekey);
    paramContentValues.put("shDuration", Short.valueOf(paramawge.shDuration));
    paramContentValues.put("bRead", Byte.valueOf(paramawge.bRead));
    paramContentValues.put("strUrl", paramawge.strUrl);
    paramContentValues.put("vRichSign", paramawge.vRichSign);
    paramContentValues.put("lSignModifyTime", Long.valueOf(paramawge.lSignModifyTime));
    paramContentValues.put("vLongNickTopicInfo", paramawge.vLongNickTopicInfo);
    paramContentValues.put("nLastGameFlag", Integer.valueOf(paramawge.nLastGameFlag));
    paramContentValues.put("strGameLogoUrl_1", paramawge.strGameLogoUrl_1);
    paramContentValues.put("strGameLogoUrl_2", paramawge.strGameLogoUrl_2);
    paramContentValues.put("strGameLogoUrl_3", paramawge.strGameLogoUrl_3);
    paramContentValues.put("strGameLogoUrl_4", paramawge.strGameLogoUrl_4);
    paramContentValues.put("strGameLogoKey_1", paramawge.strGameLogoKey_1);
    paramContentValues.put("strGameLogoKey_2", paramawge.strGameLogoKey_2);
    paramContentValues.put("strGameLogoKey_3", paramawge.strGameLogoKey_3);
    paramContentValues.put("strGameLogoKey_4", paramawge.strGameLogoKey_4);
    paramContentValues.put("strGameName_1", paramawge.strGameName_1);
    paramContentValues.put("strGameName_2", paramawge.strGameName_2);
    paramContentValues.put("strGameName_3", paramawge.strGameName_3);
    paramContentValues.put("strGameName_4", paramawge.strGameName_4);
    paramContentValues.put("strGameAppid_1", paramawge.strGameAppid_1);
    paramContentValues.put("strGameAppid_2", paramawge.strGameAppid_2);
    paramContentValues.put("strGameAppid_3", paramawge.strGameAppid_3);
    paramContentValues.put("strGameAppid_4", paramawge.strGameAppid_4);
    paramContentValues.put("strProfileUrl", paramawge.strProfileUrl);
    paramContentValues.put("nStarFansFlag", Integer.valueOf(paramawge.nStarFansFlag));
    paramContentValues.put("strStarPicUrl_0", paramawge.strStarPicUrl_0);
    paramContentValues.put("strStarPicUrl_1", paramawge.strStarPicUrl_1);
    paramContentValues.put("strStarPicUrl_2", paramawge.strStarPicUrl_2);
    paramContentValues.put("strStarLvUrl_0", paramawge.strStarLvUrl_0);
    paramContentValues.put("strStarLvUrl_1", paramawge.strStarLvUrl_1);
    paramContentValues.put("strStarLvUrl_2", paramawge.strStarLvUrl_2);
    paramContentValues.put("strStarLogoUrl", paramawge.strStarLogoUrl);
    paramContentValues.put("starFansJumpUrl", paramawge.starFansJumpUrl);
    paramContentValues.put("lUserFlag", Long.valueOf(paramawge.lUserFlag));
    paramContentValues.put("lLoginDays", Long.valueOf(paramawge.lLoginDays));
    paramContentValues.put("strLoginDaysDesc", paramawge.strLoginDaysDesc);
    paramContentValues.put("lQQMasterLogindays", Long.valueOf(paramawge.lQQMasterLogindays));
    paramContentValues.put("iXManScene1DelayTime", Integer.valueOf(paramawge.iXManScene1DelayTime));
    paramContentValues.put("iXManScene2DelayTime", Integer.valueOf(paramawge.iXManScene2DelayTime));
    paramContentValues.put("allowPeopleSee", Boolean.valueOf(paramawge.allowPeopleSee));
    paramContentValues.put("allowCalInteractive", Boolean.valueOf(paramawge.allowCalInteractive));
    paramContentValues.put("showOnlineFriends", Boolean.valueOf(paramawge.showOnlineFriends));
    paramContentValues.put("allowClick", Boolean.valueOf(paramawge.allowClick));
    paramContentValues.put("babyQSwitch", Boolean.valueOf(paramawge.babyQSwitch));
    paramContentValues.put("showLightalk", Boolean.valueOf(paramawge.showLightalk));
    paramContentValues.put("lightalkNick", paramawge.lightalkNick);
    paramContentValues.put("lightalkId", paramawge.lightalkId);
    paramContentValues.put("isSuperRedDiamond", Boolean.valueOf(paramawge.isSuperRedDiamond));
    paramContentValues.put("isRedDiamond", Boolean.valueOf(paramawge.isRedDiamond));
    paramContentValues.put("redLevel", Integer.valueOf(paramawge.redLevel));
    paramContentValues.put("isSuperYellowDiamond", Boolean.valueOf(paramawge.isSuperYellowDiamond));
    paramContentValues.put("isYellowDiamond", Boolean.valueOf(paramawge.isYellowDiamond));
    paramContentValues.put("yellowLevel", Integer.valueOf(paramawge.yellowLevel));
    paramContentValues.put("isSuperGreenDiamond", Boolean.valueOf(paramawge.isSuperGreenDiamond));
    paramContentValues.put("isGreenDiamond", Boolean.valueOf(paramawge.isGreenDiamond));
    paramContentValues.put("greenLevel", Integer.valueOf(paramawge.greenLevel));
    paramContentValues.put("uAccelerateMultiple", Long.valueOf(paramawge.uAccelerateMultiple));
    paramContentValues.put("strRespMusicInfo", paramawge.strRespMusicInfo);
    paramContentValues.put("templateRet", Integer.valueOf(paramawge.templateRet));
    paramContentValues.put("lCurrentStyleId", Long.valueOf(paramawge.lCurrentStyleId));
    paramContentValues.put("lCurrentBgId", Long.valueOf(paramawge.lCurrentBgId));
    paramContentValues.put("backgroundUrl", paramawge.backgroundUrl);
    paramContentValues.put("backgroundColor", Long.valueOf(paramawge.backgroundColor));
    paramContentValues.put("dynamicCardFlag", Integer.valueOf(paramawge.dynamicCardFlag));
    paramContentValues.put("strZipUrl", paramawge.strZipUrl);
    paramContentValues.put("strActiveUrl", paramawge.strActiveUrl);
    paramContentValues.put("strDrawerCardUrl", paramawge.strDrawerCardUrl);
    paramContentValues.put("strWzryHeroUrl", paramawge.strWzryHeroUrl);
    paramContentValues.put("wzryHonorInfo", paramawge.wzryHonorInfo);
    paramContentValues.put("strExtInfo", paramawge.strExtInfo);
    paramContentValues.put("strCurrentBgUrl", paramawge.strCurrentBgUrl);
    paramContentValues.put("bgType", paramawge.bgType);
    paramContentValues.put("encId", paramawge.encId);
    paramContentValues.put("busiEntry", paramawge.busiEntry);
    paramContentValues.put("favoriteSource", Integer.valueOf(paramawge.favoriteSource));
    paramContentValues.put("visibleMusicPendant", Boolean.valueOf(paramawge.visibleMusicPendant));
    paramContentValues.put("autoPlayMusicPendant", Boolean.valueOf(paramawge.autoPlayMusicPendant));
    paramContentValues.put("showRedPointMusicPendant", Boolean.valueOf(paramawge.showRedPointMusicPendant));
    paramContentValues.put("privilegePromptStr", paramawge.privilegePromptStr);
    paramContentValues.put("privilegeJumpUrl", paramawge.privilegeJumpUrl);
    paramContentValues.put("vOpenPriv", paramawge.vOpenPriv);
    paramContentValues.put("vClosePriv", paramawge.vClosePriv);
    paramContentValues.put("presentDesc", paramawge.presentDesc);
    paramContentValues.put("presentCustourl", paramawge.presentCustourl);
    paramContentValues.put("presentSwitch", Boolean.valueOf(paramawge.presentSwitch));
    paramContentValues.put("showPresent", Boolean.valueOf(paramawge.showPresent));
    paramContentValues.put("showMusicBox", Boolean.valueOf(paramawge.showMusicBox));
    paramContentValues.put("addSrcName", paramawge.addSrcName);
    paramContentValues.put("addSrcId", Long.valueOf(paramawge.addSrcId));
    paramContentValues.put("addSubSrcId", Long.valueOf(paramawge.addSubSrcId));
    paramContentValues.put("strVoteLimitedNotice", paramawge.strVoteLimitedNotice);
    paramContentValues.put("bHaveVotedCnt", Short.valueOf(paramawge.bHaveVotedCnt));
    paramContentValues.put("bAvailVoteCnt", Short.valueOf(paramawge.bAvailVoteCnt));
    paramContentValues.put("olympicTorch", Byte.valueOf(paramawge.olympicTorch));
    paramContentValues.put("mNowShowFlag", Integer.valueOf(paramawge.mNowShowFlag));
    paramContentValues.put("mNowShowIconUrl", paramawge.mNowShowIconUrl);
    paramContentValues.put("mNowShowJumpUrl", paramawge.mNowShowJumpUrl);
    paramContentValues.put("vCoverInfo", paramawge.vCoverInfo);
    paramContentValues.put("videoHeadFlag", Boolean.valueOf(paramawge.videoHeadFlag));
    paramContentValues.put("videoHeadUrl", paramawge.videoHeadUrl);
    paramContentValues.put("medalSwitchDisable", Boolean.valueOf(paramawge.medalSwitchDisable));
    paramContentValues.put("iMedalCount", Integer.valueOf(paramawge.iMedalCount));
    paramContentValues.put("iNewCount", Integer.valueOf(paramawge.iNewCount));
    paramContentValues.put("iUpgradeCount", Integer.valueOf(paramawge.iUpgradeCount));
    paramContentValues.put("strPromptParams", paramawge.strPromptParams);
    paramContentValues.put("hobbyEntry", paramawge.hobbyEntry);
    paramContentValues.put("lastPraiseInfoList", paramawge.lastPraiseInfoList);
    paramContentValues.put("tempChatSig", paramawge.tempChatSig);
    paramContentValues.put("namePlateOfKingGameId", Long.valueOf(paramawge.namePlateOfKingGameId));
    paramContentValues.put("namePlateOfKingLoginTime", Long.valueOf(paramawge.namePlateOfKingLoginTime));
    paramContentValues.put("namePlateOfKingDan", Integer.valueOf(paramawge.namePlateOfKingDan));
    paramContentValues.put("namePlateOfKingDanDisplatSwitch", Boolean.valueOf(paramawge.namePlateOfKingDanDisplatSwitch));
    paramContentValues.put("vPersonalityLabelV2", paramawge.vPersonalityLabelV2);
    paramContentValues.put("cardType", Integer.valueOf(paramawge.cardType));
    paramContentValues.put("diyText", paramawge.diyText);
    paramContentValues.put("diyTextFontId", Integer.valueOf(paramawge.diyTextFontId));
    paramContentValues.put("diyTextWidth", Float.valueOf(paramawge.diyTextWidth));
    paramContentValues.put("diyTextHeight", Float.valueOf(paramawge.diyTextHeight));
    paramContentValues.put("diyTextLocX", Float.valueOf(paramawge.diyTextLocX));
    paramContentValues.put("diyTextLocY", Float.valueOf(paramawge.diyTextLocY));
    paramContentValues.put("diyTextDegree", Float.valueOf(paramawge.diyTextDegree));
    paramContentValues.put("diyTextScale", Float.valueOf(paramawge.diyTextScale));
    paramContentValues.put("diyTextTransparency", Float.valueOf(paramawge.diyTextTransparency));
    paramContentValues.put("diyDefaultText", paramawge.diyDefaultText);
    paramContentValues.put("popularity", Integer.valueOf(paramawge.popularity));
    paramContentValues.put("declaration", paramawge.declaration);
    paramContentValues.put("voiceUrl", paramawge.voiceUrl);
    paramContentValues.put("isShowCard", Boolean.valueOf(paramawge.isShowCard));
    paramContentValues.put("updateTime", Long.valueOf(paramawge.updateTime));
    paramContentValues.put("extendFriendFlag", Integer.valueOf(paramawge.extendFriendFlag));
    paramContentValues.put("extendFriendVoiceDuration", Integer.valueOf(paramawge.extendFriendVoiceDuration));
    paramContentValues.put("extendFriendEntryContact", Short.valueOf(paramawge.extendFriendEntryContact));
    paramContentValues.put("extendFriendEntryAddFriend", Short.valueOf(paramawge.extendFriendEntryAddFriend));
    paramContentValues.put("extendFriendQuestion", Short.valueOf(paramawge.extendFriendQuestion));
    paramContentValues.put("fontId", Integer.valueOf(paramawge.fontId));
    paramContentValues.put("fontType", Integer.valueOf(paramawge.fontType));
    paramContentValues.put("clothesId", Integer.valueOf(paramawge.clothesId));
    paramContentValues.put("schoolId", paramawge.schoolId);
    paramContentValues.put("schoolName", paramawge.schoolName);
    paramContentValues.put("authState", Long.valueOf(paramawge.authState));
    paramContentValues.put("idx", Integer.valueOf(paramawge.idx));
    paramContentValues.put("category", Integer.valueOf(paramawge.category));
    paramContentValues.put("isShowMiniPlaying", Boolean.valueOf(paramawge.isShowMiniPlaying));
    paramContentValues.put("tabJumpUrl", paramawge.tabJumpUrl);
    paramContentValues.put("guestJumpUrl", paramawge.guestJumpUrl);
    paramContentValues.put("guestAppTotal", Integer.valueOf(paramawge.guestAppTotal));
    paramContentValues.put("defaultCardId", Integer.valueOf(paramawge.defaultCardId));
    paramContentValues.put("strangerVoteOpen", Boolean.valueOf(paramawge.strangerVoteOpen));
    paramContentValues.put("lSuperVipTemplateId", Long.valueOf(paramawge.lSuperVipTemplateId));
    paramContentValues.put("bBigClubVipOpen", Byte.valueOf(paramawge.bBigClubVipOpen));
    paramContentValues.put("iBigClubVipType", Integer.valueOf(paramawge.iBigClubVipType));
    paramContentValues.put("iBigClubVipLevel", Integer.valueOf(paramawge.iBigClubVipLevel));
    paramContentValues.put("lBigClubTemplateId", Long.valueOf(paramawge.lBigClubTemplateId));
    paramContentValues.put("diyComplicatedInfo", paramawge.diyComplicatedInfo);
    paramContentValues.put("cardId", Long.valueOf(paramawge.cardId));
    paramContentValues.put("strangerInviteMeGroupOpen", Boolean.valueOf(paramawge.strangerInviteMeGroupOpen));
    paramContentValues.put("isPrettyGroupOwner", Boolean.valueOf(paramawge.isPrettyGroupOwner));
    paramContentValues.put("isHidePrettyGroutIdentity", Boolean.valueOf(paramawge.isHidePrettyGroutIdentity));
    paramContentValues.put("mQQLevelType", Integer.valueOf(paramawge.mQQLevelType));
    paramContentValues.put("schoolVerifiedFlag", Boolean.valueOf(paramawge.schoolVerifiedFlag));
    paramContentValues.put("troopHonorSwitch", Boolean.valueOf(paramawge.troopHonorSwitch));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awft
 * JD-Core Version:    0.7.0.1
 */