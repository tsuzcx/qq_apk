import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awbk
  extends awch
{
  public awbk()
  {
    this.a = 248;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawbv = (Card)paramawbv;
    label1330:
    label2484:
    label2742:
    label4921:
    label4926:
    label5056:
    if (paramawcg == null)
    {
      paramawbv.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawbv.strNick = paramCursor.getString(paramCursor.getColumnIndex("strNick"));
      paramawbv.shGender = paramCursor.getShort(paramCursor.getColumnIndex("shGender"));
      paramawbv.shAge = paramCursor.getShort(paramCursor.getColumnIndex("shAge"));
      paramawbv.nFaceID = paramCursor.getInt(paramCursor.getColumnIndex("nFaceID"));
      paramawbv.strCertificationInfo = paramCursor.getString(paramCursor.getColumnIndex("strCertificationInfo"));
      paramawbv.shType = paramCursor.getShort(paramCursor.getColumnIndex("shType"));
      paramawbv.vContent = paramCursor.getBlob(paramCursor.getColumnIndex("vContent"));
      paramawbv.strSign = paramCursor.getString(paramCursor.getColumnIndex("strSign"));
      paramawbv.strCompany = paramCursor.getString(paramCursor.getColumnIndex("strCompany"));
      paramawbv.strSchool = paramCursor.getString(paramCursor.getColumnIndex("strSchool"));
      paramawbv.uFaceTimeStamp = paramCursor.getInt(paramCursor.getColumnIndex("uFaceTimeStamp"));
      paramawbv.vQQFaceID = paramCursor.getBlob(paramCursor.getColumnIndex("vQQFaceID"));
      paramawbv.strReMark = paramCursor.getString(paramCursor.getColumnIndex("strReMark"));
      paramawbv.bWeiboInfo = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bWeiboInfo")));
      paramawbv.bQzoneInfo = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bQzoneInfo")));
      paramawbv.nSameFriendsNum = paramCursor.getInt(paramCursor.getColumnIndex("nSameFriendsNum"));
      paramawbv.strCompanySame = paramCursor.getString(paramCursor.getColumnIndex("strCompanySame"));
      paramawbv.strSchoolSame = paramCursor.getString(paramCursor.getColumnIndex("strSchoolSame"));
      paramawbv.lCardShowNum = paramCursor.getLong(paramCursor.getColumnIndex("lCardShowNum"));
      paramawbv.bSingle = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSingle")));
      paramawbv.lVisitCount = paramCursor.getLong(paramCursor.getColumnIndex("lVisitCount"));
      paramawbv.lVoteCount = paramCursor.getLong(paramCursor.getColumnIndex("lVoteCount"));
      paramawbv.tagInfosByte = paramCursor.getBlob(paramCursor.getColumnIndex("tagInfosByte"));
      paramawbv.eUserIdentityType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("eUserIdentityType")));
      paramawbv.vBackground = paramCursor.getBlob(paramCursor.getColumnIndex("vBackground"));
      paramawbv.labelInfoBytes = paramCursor.getBlob(paramCursor.getColumnIndex("labelInfoBytes"));
      paramawbv.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramawbv.constellation = paramCursor.getInt(paramCursor.getColumnIndex("constellation"));
      paramawbv.pyFaceUrl = paramCursor.getString(paramCursor.getColumnIndex("pyFaceUrl"));
      paramawbv.location = paramCursor.getString(paramCursor.getColumnIndex("location"));
      paramawbv.bVoted = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bVoted")));
      paramawbv.bFavorited = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bFavorited")));
      paramawbv.iVoteIncrement = paramCursor.getInt(paramCursor.getColumnIndex("iVoteIncrement"));
      paramawbv.strJoinHexAlbumFileKey = paramCursor.getString(paramCursor.getColumnIndex("strJoinHexAlbumFileKey"));
      paramawbv.iFaceNum = paramCursor.getInt(paramCursor.getColumnIndex("iFaceNum"));
      paramawbv.cSqqLevel = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSqqLevel")));
      paramawbv.iQQLevel = paramCursor.getInt(paramCursor.getColumnIndex("iQQLevel"));
      paramawbv.uCurMulType = paramCursor.getLong(paramCursor.getColumnIndex("uCurMulType"));
      paramawbv.strProvince = paramCursor.getString(paramCursor.getColumnIndex("strProvince"));
      paramawbv.strCity = paramCursor.getString(paramCursor.getColumnIndex("strCity"));
      paramawbv.strCountry = paramCursor.getString(paramCursor.getColumnIndex("strCountry"));
      paramawbv.lBirthday = paramCursor.getLong(paramCursor.getColumnIndex("lBirthday"));
      paramawbv.strLocationCodes = paramCursor.getString(paramCursor.getColumnIndex("strLocationCodes"));
      paramawbv.strLocationDesc = paramCursor.getString(paramCursor.getColumnIndex("strLocationDesc"));
      paramawbv.strHometownCodes = paramCursor.getString(paramCursor.getColumnIndex("strHometownCodes"));
      paramawbv.strHometownDesc = paramCursor.getString(paramCursor.getColumnIndex("strHometownDesc"));
      paramawbv.strEmail = paramCursor.getString(paramCursor.getColumnIndex("strEmail"));
      paramawbv.strPersonalNote = paramCursor.getString(paramCursor.getColumnIndex("strPersonalNote"));
      paramawbv.iProfession = paramCursor.getInt(paramCursor.getColumnIndex("iProfession"));
      paramawbv.bindPhoneInfo = paramCursor.getString(paramCursor.getColumnIndex("bindPhoneInfo"));
      paramawbv.bCardInfo = paramCursor.getBlob(paramCursor.getColumnIndex("bCardInfo"));
      paramawbv.strTroopName = paramCursor.getString(paramCursor.getColumnIndex("strTroopName"));
      paramawbv.strTroopNick = paramCursor.getString(paramCursor.getColumnIndex("strTroopNick"));
      paramawbv.strMobile = paramCursor.getString(paramCursor.getColumnIndex("strMobile"));
      paramawbv.strContactName = paramCursor.getString(paramCursor.getColumnIndex("strContactName"));
      paramawbv.ulShowControl = paramCursor.getInt(paramCursor.getColumnIndex("ulShowControl"));
      paramawbv.feedPreviewTime = paramCursor.getLong(paramCursor.getColumnIndex("feedPreviewTime"));
      paramawbv.strQzoneFeedsDesc = paramCursor.getString(paramCursor.getColumnIndex("strQzoneFeedsDesc"));
      paramawbv.StrPresentDesc = paramCursor.getString(paramCursor.getColumnIndex("StrPresentDesc"));
      paramawbv.strSpaceName = paramCursor.getString(paramCursor.getColumnIndex("strSpaceName"));
      paramawbv.strQzoneHeader = paramCursor.getString(paramCursor.getColumnIndex("strQzoneHeader"));
      paramawbv.vQzonePhotos = paramCursor.getBlob(paramCursor.getColumnIndex("vQzonePhotos"));
      paramawbv.vQzoneCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vQzoneCoverInfo"));
      paramawbv.enlargeQzonePic = paramCursor.getInt(paramCursor.getColumnIndex("enlargeQzonePic"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("showPublishButton")))
      {
        paramBoolean = true;
        paramawbv.showPublishButton = paramBoolean;
        paramawbv.strStatus = paramCursor.getString(paramCursor.getColumnIndex("strStatus"));
        paramawbv.strAutoRemark = paramCursor.getString(paramCursor.getColumnIndex("strAutoRemark"));
        paramawbv.vSeed = paramCursor.getBlob(paramCursor.getColumnIndex("vSeed"));
        paramawbv.vCookies = paramCursor.getBlob(paramCursor.getColumnIndex("vCookies"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasFakeData"))) {
          break label4916;
        }
        paramBoolean = true;
        paramawbv.hasFakeData = paramBoolean;
        paramawbv.bQQVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bQQVipOpen")));
        paramawbv.iQQVipType = paramCursor.getInt(paramCursor.getColumnIndex("iQQVipType"));
        paramawbv.iQQVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iQQVipLevel"));
        paramawbv.nameplateVipType = paramCursor.getInt(paramCursor.getColumnIndex("nameplateVipType"));
        paramawbv.grayNameplateFlag = paramCursor.getInt(paramCursor.getColumnIndex("grayNameplateFlag"));
        paramawbv.bSuperVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSuperVipOpen")));
        paramawbv.iSuperVipType = paramCursor.getInt(paramCursor.getColumnIndex("iSuperVipType"));
        paramawbv.iSuperVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iSuperVipLevel"));
        paramawbv.bSuperQQOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSuperQQOpen")));
        paramawbv.iSuperQQType = paramCursor.getInt(paramCursor.getColumnIndex("iSuperQQType"));
        paramawbv.iSuperQQLevel = paramCursor.getInt(paramCursor.getColumnIndex("iSuperQQLevel"));
        paramawbv.bHollywoodVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bHollywoodVipOpen")));
        paramawbv.iHollywoodVipType = paramCursor.getInt(paramCursor.getColumnIndex("iHollywoodVipType"));
        paramawbv.iHollywoodVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iHollywoodVipLevel"));
        paramawbv.strShowName = paramCursor.getString(paramCursor.getColumnIndex("strShowName"));
        paramawbv.strVoiceFilekey = paramCursor.getString(paramCursor.getColumnIndex("strVoiceFilekey"));
        paramawbv.shDuration = paramCursor.getShort(paramCursor.getColumnIndex("shDuration"));
        paramawbv.bRead = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bRead")));
        paramawbv.strUrl = paramCursor.getString(paramCursor.getColumnIndex("strUrl"));
        paramawbv.vRichSign = paramCursor.getBlob(paramCursor.getColumnIndex("vRichSign"));
        paramawbv.lSignModifyTime = paramCursor.getLong(paramCursor.getColumnIndex("lSignModifyTime"));
        paramawbv.vLongNickTopicInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vLongNickTopicInfo"));
        paramawbv.nLastGameFlag = paramCursor.getInt(paramCursor.getColumnIndex("nLastGameFlag"));
        paramawbv.strGameLogoUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_1"));
        paramawbv.strGameLogoUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_2"));
        paramawbv.strGameLogoUrl_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_3"));
        paramawbv.strGameLogoUrl_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_4"));
        paramawbv.strGameLogoKey_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_1"));
        paramawbv.strGameLogoKey_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_2"));
        paramawbv.strGameLogoKey_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_3"));
        paramawbv.strGameLogoKey_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_4"));
        paramawbv.strGameName_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_1"));
        paramawbv.strGameName_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_2"));
        paramawbv.strGameName_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_3"));
        paramawbv.strGameName_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_4"));
        paramawbv.strGameAppid_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_1"));
        paramawbv.strGameAppid_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_2"));
        paramawbv.strGameAppid_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_3"));
        paramawbv.strGameAppid_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_4"));
        paramawbv.strProfileUrl = paramCursor.getString(paramCursor.getColumnIndex("strProfileUrl"));
        paramawbv.nStarFansFlag = paramCursor.getInt(paramCursor.getColumnIndex("nStarFansFlag"));
        paramawbv.strStarPicUrl_0 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_0"));
        paramawbv.strStarPicUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_1"));
        paramawbv.strStarPicUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_2"));
        paramawbv.strStarLvUrl_0 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_0"));
        paramawbv.strStarLvUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_1"));
        paramawbv.strStarLvUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_2"));
        paramawbv.strStarLogoUrl = paramCursor.getString(paramCursor.getColumnIndex("strStarLogoUrl"));
        paramawbv.starFansJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("starFansJumpUrl"));
        paramawbv.lUserFlag = paramCursor.getLong(paramCursor.getColumnIndex("lUserFlag"));
        paramawbv.lLoginDays = paramCursor.getLong(paramCursor.getColumnIndex("lLoginDays"));
        paramawbv.strLoginDaysDesc = paramCursor.getString(paramCursor.getColumnIndex("strLoginDaysDesc"));
        paramawbv.lQQMasterLogindays = paramCursor.getLong(paramCursor.getColumnIndex("lQQMasterLogindays"));
        paramawbv.iXManScene1DelayTime = paramCursor.getInt(paramCursor.getColumnIndex("iXManScene1DelayTime"));
        paramawbv.iXManScene2DelayTime = paramCursor.getInt(paramCursor.getColumnIndex("iXManScene2DelayTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowPeopleSee"))) {
          break label4921;
        }
        paramBoolean = true;
        label2406:
        paramawbv.allowPeopleSee = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowCalInteractive"))) {
          break label4926;
        }
        paramBoolean = true;
        paramawbv.allowCalInteractive = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showOnlineFriends"))) {
          break label4931;
        }
        paramBoolean = true;
        paramawbv.showOnlineFriends = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowClick"))) {
          break label4936;
        }
        paramBoolean = true;
        paramawbv.allowClick = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("babyQSwitch"))) {
          break label4941;
        }
        paramBoolean = true;
        label2510:
        paramawbv.babyQSwitch = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showLightalk"))) {
          break label4946;
        }
        paramBoolean = true;
        label2536:
        paramawbv.showLightalk = paramBoolean;
        paramawbv.lightalkNick = paramCursor.getString(paramCursor.getColumnIndex("lightalkNick"));
        paramawbv.lightalkId = paramCursor.getString(paramCursor.getColumnIndex("lightalkId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperRedDiamond"))) {
          break label4951;
        }
        paramBoolean = true;
        paramawbv.isSuperRedDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRedDiamond"))) {
          break label4956;
        }
        paramBoolean = true;
        label2626:
        paramawbv.isRedDiamond = paramBoolean;
        paramawbv.redLevel = paramCursor.getInt(paramCursor.getColumnIndex("redLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperYellowDiamond"))) {
          break label4961;
        }
        paramBoolean = true;
        label2671:
        paramawbv.isSuperYellowDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isYellowDiamond"))) {
          break label4966;
        }
        paramBoolean = true;
        paramawbv.isYellowDiamond = paramBoolean;
        paramawbv.yellowLevel = paramCursor.getInt(paramCursor.getColumnIndex("yellowLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperGreenDiamond"))) {
          break label4971;
        }
        paramBoolean = true;
        paramawbv.isSuperGreenDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isGreenDiamond"))) {
          break label4976;
        }
        paramBoolean = true;
        label2768:
        paramawbv.isGreenDiamond = paramBoolean;
        paramawbv.greenLevel = paramCursor.getInt(paramCursor.getColumnIndex("greenLevel"));
        paramawbv.uAccelerateMultiple = paramCursor.getLong(paramCursor.getColumnIndex("uAccelerateMultiple"));
        paramawbv.strRespMusicInfo = paramCursor.getString(paramCursor.getColumnIndex("strRespMusicInfo"));
        paramawbv.templateRet = paramCursor.getInt(paramCursor.getColumnIndex("templateRet"));
        paramawbv.lCurrentStyleId = paramCursor.getLong(paramCursor.getColumnIndex("lCurrentStyleId"));
        paramawbv.lCurrentBgId = paramCursor.getLong(paramCursor.getColumnIndex("lCurrentBgId"));
        paramawbv.backgroundUrl = paramCursor.getString(paramCursor.getColumnIndex("backgroundUrl"));
        paramawbv.backgroundColor = paramCursor.getLong(paramCursor.getColumnIndex("backgroundColor"));
        paramawbv.dynamicCardFlag = paramCursor.getInt(paramCursor.getColumnIndex("dynamicCardFlag"));
        paramawbv.strZipUrl = paramCursor.getString(paramCursor.getColumnIndex("strZipUrl"));
        paramawbv.strActiveUrl = paramCursor.getString(paramCursor.getColumnIndex("strActiveUrl"));
        paramawbv.strDrawerCardUrl = paramCursor.getString(paramCursor.getColumnIndex("strDrawerCardUrl"));
        paramawbv.strWzryHeroUrl = paramCursor.getString(paramCursor.getColumnIndex("strWzryHeroUrl"));
        paramawbv.wzryHonorInfo = paramCursor.getBlob(paramCursor.getColumnIndex("wzryHonorInfo"));
        paramawbv.strExtInfo = paramCursor.getString(paramCursor.getColumnIndex("strExtInfo"));
        paramawbv.strCurrentBgUrl = paramCursor.getString(paramCursor.getColumnIndex("strCurrentBgUrl"));
        paramawbv.bgType = paramCursor.getBlob(paramCursor.getColumnIndex("bgType"));
        paramawbv.encId = paramCursor.getString(paramCursor.getColumnIndex("encId"));
        paramawbv.busiEntry = paramCursor.getString(paramCursor.getColumnIndex("busiEntry"));
        paramawbv.favoriteSource = paramCursor.getInt(paramCursor.getColumnIndex("favoriteSource"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("visibleMusicPendant"))) {
          break label4981;
        }
        paramBoolean = true;
        label3174:
        paramawbv.visibleMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("autoPlayMusicPendant"))) {
          break label4986;
        }
        paramBoolean = true;
        paramawbv.autoPlayMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showRedPointMusicPendant"))) {
          break label4991;
        }
        paramBoolean = true;
        paramawbv.showRedPointMusicPendant = paramBoolean;
        paramawbv.privilegePromptStr = paramCursor.getString(paramCursor.getColumnIndex("privilegePromptStr"));
        paramawbv.privilegeJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("privilegeJumpUrl"));
        paramawbv.vOpenPriv = paramCursor.getBlob(paramCursor.getColumnIndex("vOpenPriv"));
        paramawbv.vClosePriv = paramCursor.getBlob(paramCursor.getColumnIndex("vClosePriv"));
        paramawbv.presentDesc = paramCursor.getString(paramCursor.getColumnIndex("presentDesc"));
        paramawbv.presentCustourl = paramCursor.getString(paramCursor.getColumnIndex("presentCustourl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("presentSwitch"))) {
          break label4996;
        }
        paramBoolean = true;
        paramawbv.presentSwitch = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showPresent"))) {
          break label5001;
        }
        paramBoolean = true;
        label3392:
        paramawbv.showPresent = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showMusicBox"))) {
          break label5006;
        }
        paramBoolean = true;
        label3418:
        paramawbv.showMusicBox = paramBoolean;
        paramawbv.addSrcName = paramCursor.getString(paramCursor.getColumnIndex("addSrcName"));
        paramawbv.addSrcId = paramCursor.getLong(paramCursor.getColumnIndex("addSrcId"));
        paramawbv.addSubSrcId = paramCursor.getLong(paramCursor.getColumnIndex("addSubSrcId"));
        paramawbv.strVoteLimitedNotice = paramCursor.getString(paramCursor.getColumnIndex("strVoteLimitedNotice"));
        paramawbv.bHaveVotedCnt = paramCursor.getShort(paramCursor.getColumnIndex("bHaveVotedCnt"));
        paramawbv.bAvailVoteCnt = paramCursor.getShort(paramCursor.getColumnIndex("bAvailVoteCnt"));
        paramawbv.olympicTorch = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("olympicTorch")));
        paramawbv.mNowShowFlag = paramCursor.getInt(paramCursor.getColumnIndex("mNowShowFlag"));
        paramawbv.mNowShowIconUrl = paramCursor.getString(paramCursor.getColumnIndex("mNowShowIconUrl"));
        paramawbv.mNowShowJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("mNowShowJumpUrl"));
        paramawbv.vCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vCoverInfo"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("videoHeadFlag"))) {
          break label5011;
        }
        paramBoolean = true;
        label3654:
        paramawbv.videoHeadFlag = paramBoolean;
        paramawbv.videoHeadUrl = paramCursor.getString(paramCursor.getColumnIndex("videoHeadUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("medalSwitchDisable"))) {
          break label5016;
        }
        paramBoolean = true;
        label3699:
        paramawbv.medalSwitchDisable = paramBoolean;
        paramawbv.iMedalCount = paramCursor.getInt(paramCursor.getColumnIndex("iMedalCount"));
        paramawbv.iNewCount = paramCursor.getInt(paramCursor.getColumnIndex("iNewCount"));
        paramawbv.iUpgradeCount = paramCursor.getInt(paramCursor.getColumnIndex("iUpgradeCount"));
        paramawbv.strPromptParams = paramCursor.getString(paramCursor.getColumnIndex("strPromptParams"));
        paramawbv.hobbyEntry = paramCursor.getString(paramCursor.getColumnIndex("hobbyEntry"));
        paramawbv.lastPraiseInfoList = paramCursor.getBlob(paramCursor.getColumnIndex("lastPraiseInfoList"));
        paramawbv.tempChatSig = paramCursor.getBlob(paramCursor.getColumnIndex("tempChatSig"));
        paramawbv.namePlateOfKingGameId = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingGameId"));
        paramawbv.namePlateOfKingLoginTime = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingLoginTime"));
        paramawbv.namePlateOfKingDan = paramCursor.getInt(paramCursor.getColumnIndex("namePlateOfKingDan"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch"))) {
          break label5021;
        }
        paramBoolean = true;
        label3915:
        paramawbv.namePlateOfKingDanDisplatSwitch = paramBoolean;
        paramawbv.vPersonalityLabelV2 = paramCursor.getBlob(paramCursor.getColumnIndex("vPersonalityLabelV2"));
        paramawbv.cardType = paramCursor.getInt(paramCursor.getColumnIndex("cardType"));
        paramawbv.diyText = paramCursor.getString(paramCursor.getColumnIndex("diyText"));
        paramawbv.diyTextFontId = paramCursor.getInt(paramCursor.getColumnIndex("diyTextFontId"));
        paramawbv.diyTextWidth = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextWidth"));
        paramawbv.diyTextHeight = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextHeight"));
        paramawbv.diyTextLocX = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextLocX"));
        paramawbv.diyTextLocY = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextLocY"));
        paramawbv.diyTextDegree = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextDegree"));
        paramawbv.diyTextScale = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextScale"));
        paramawbv.diyTextTransparency = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextTransparency"));
        paramawbv.diyDefaultText = paramCursor.getString(paramCursor.getColumnIndex("diyDefaultText"));
        paramawbv.popularity = paramCursor.getInt(paramCursor.getColumnIndex("popularity"));
        paramawbv.declaration = paramCursor.getString(paramCursor.getColumnIndex("declaration"));
        paramawbv.voiceUrl = paramCursor.getString(paramCursor.getColumnIndex("voiceUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShowCard"))) {
          break label5026;
        }
        paramBoolean = true;
        paramawbv.isShowCard = paramBoolean;
        paramawbv.updateTime = paramCursor.getLong(paramCursor.getColumnIndex("updateTime"));
        paramawbv.extendFriendFlag = paramCursor.getInt(paramCursor.getColumnIndex("extendFriendFlag"));
        paramawbv.extendFriendVoiceDuration = paramCursor.getInt(paramCursor.getColumnIndex("extendFriendVoiceDuration"));
        paramawbv.extendFriendEntryContact = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendEntryContact"));
        paramawbv.extendFriendEntryAddFriend = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendEntryAddFriend"));
        paramawbv.extendFriendQuestion = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendQuestion"));
        paramawbv.fontId = paramCursor.getInt(paramCursor.getColumnIndex("fontId"));
        paramawbv.fontType = paramCursor.getInt(paramCursor.getColumnIndex("fontType"));
        paramawbv.clothesId = paramCursor.getInt(paramCursor.getColumnIndex("clothesId"));
        paramawbv.schoolId = paramCursor.getString(paramCursor.getColumnIndex("schoolId"));
        paramawbv.schoolName = paramCursor.getString(paramCursor.getColumnIndex("schoolName"));
        paramawbv.authState = paramCursor.getLong(paramCursor.getColumnIndex("authState"));
        paramawbv.idx = paramCursor.getInt(paramCursor.getColumnIndex("idx"));
        paramawbv.category = paramCursor.getInt(paramCursor.getColumnIndex("category"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShowMiniPlaying"))) {
          break label5031;
        }
        paramBoolean = true;
        paramawbv.isShowMiniPlaying = paramBoolean;
        paramawbv.tabJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("tabJumpUrl"));
        paramawbv.guestJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("guestJumpUrl"));
        paramawbv.guestAppTotal = paramCursor.getInt(paramCursor.getColumnIndex("guestAppTotal"));
        paramawbv.defaultCardId = paramCursor.getInt(paramCursor.getColumnIndex("defaultCardId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("strangerVoteOpen"))) {
          break label5036;
        }
        paramBoolean = true;
        paramawbv.strangerVoteOpen = paramBoolean;
        paramawbv.lSuperVipTemplateId = paramCursor.getLong(paramCursor.getColumnIndex("lSuperVipTemplateId"));
        paramawbv.bBigClubVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bBigClubVipOpen")));
        paramawbv.iBigClubVipType = paramCursor.getInt(paramCursor.getColumnIndex("iBigClubVipType"));
        paramawbv.iBigClubVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iBigClubVipLevel"));
        paramawbv.lBigClubTemplateId = paramCursor.getLong(paramCursor.getColumnIndex("lBigClubTemplateId"));
        paramawbv.diyComplicatedInfo = paramCursor.getString(paramCursor.getColumnIndex("diyComplicatedInfo"));
        paramawbv.cardId = paramCursor.getLong(paramCursor.getColumnIndex("cardId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("strangerInviteMeGroupOpen"))) {
          break label5041;
        }
        paramBoolean = true;
        paramawbv.strangerInviteMeGroupOpen = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isPrettyGroupOwner"))) {
          break label5046;
        }
        paramBoolean = true;
        label4806:
        paramawbv.isPrettyGroupOwner = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isHidePrettyGroutIdentity"))) {
          break label5051;
        }
        paramBoolean = true;
        label4832:
        paramawbv.isHidePrettyGroutIdentity = paramBoolean;
        paramawbv.mQQLevelType = paramCursor.getInt(paramCursor.getColumnIndex("mQQLevelType"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("schoolVerifiedFlag"))) {
          break label5056;
        }
        paramBoolean = true;
        paramawbv.schoolVerifiedFlag = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("troopHonorSwitch"))) {
          break label5061;
        }
      }
      label4931:
      label5061:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramawbv.troopHonorSwitch = paramBoolean;
        return paramawbv;
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
      paramawcg.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("strNick");
      if (i != -1) {
        break label14155;
      }
      paramawcg.a(new NoColumnError("strNick", String.class));
      i = paramCursor.getColumnIndex("shGender");
      if (i != -1) {
        break label14170;
      }
      paramawcg.a(new NoColumnError("shGender", Short.TYPE));
      label5171:
      i = paramCursor.getColumnIndex("shAge");
      if (i != -1) {
        break label14185;
      }
      paramawcg.a(new NoColumnError("shAge", Short.TYPE));
      label5206:
      i = paramCursor.getColumnIndex("nFaceID");
      if (i != -1) {
        break label14200;
      }
      paramawcg.a(new NoColumnError("nFaceID", Integer.TYPE));
      label5241:
      i = paramCursor.getColumnIndex("strCertificationInfo");
      if (i != -1) {
        break label14215;
      }
      paramawcg.a(new NoColumnError("strCertificationInfo", String.class));
      i = paramCursor.getColumnIndex("shType");
      if (i != -1) {
        break label14230;
      }
      paramawcg.a(new NoColumnError("shType", Short.TYPE));
      label5311:
      i = paramCursor.getColumnIndex("vContent");
      if (i != -1) {
        break label14245;
      }
      paramawcg.a(new NoColumnError("vContent", [B.class));
      label5346:
      i = paramCursor.getColumnIndex("strSign");
      if (i != -1) {
        break label14260;
      }
      paramawcg.a(new NoColumnError("strSign", String.class));
      i = paramCursor.getColumnIndex("strCompany");
      if (i != -1) {
        break label14275;
      }
      paramawcg.a(new NoColumnError("strCompany", String.class));
      i = paramCursor.getColumnIndex("strSchool");
      if (i != -1) {
        break label14290;
      }
      paramawcg.a(new NoColumnError("strSchool", String.class));
      label5451:
      i = paramCursor.getColumnIndex("uFaceTimeStamp");
      if (i != -1) {
        break label14305;
      }
      paramawcg.a(new NoColumnError("uFaceTimeStamp", Integer.TYPE));
      label5486:
      i = paramCursor.getColumnIndex("vQQFaceID");
      if (i != -1) {
        break label14320;
      }
      paramawcg.a(new NoColumnError("vQQFaceID", [B.class));
      i = paramCursor.getColumnIndex("strReMark");
      if (i != -1) {
        break label14335;
      }
      paramawcg.a(new NoColumnError("strReMark", String.class));
      label5556:
      i = paramCursor.getColumnIndex("bWeiboInfo");
      if (i != -1) {
        break label14350;
      }
      paramawcg.a(new NoColumnError("bWeiboInfo", Byte.TYPE));
      label5591:
      i = paramCursor.getColumnIndex("bQzoneInfo");
      if (i != -1) {
        break label14366;
      }
      paramawcg.a(new NoColumnError("bQzoneInfo", Byte.TYPE));
      label5626:
      i = paramCursor.getColumnIndex("nSameFriendsNum");
      if (i != -1) {
        break label14382;
      }
      paramawcg.a(new NoColumnError("nSameFriendsNum", Integer.TYPE));
      i = paramCursor.getColumnIndex("strCompanySame");
      if (i != -1) {
        break label14397;
      }
      paramawcg.a(new NoColumnError("strCompanySame", String.class));
      label5696:
      i = paramCursor.getColumnIndex("strSchoolSame");
      if (i != -1) {
        break label14412;
      }
      paramawcg.a(new NoColumnError("strSchoolSame", String.class));
      label5731:
      i = paramCursor.getColumnIndex("lCardShowNum");
      if (i != -1) {
        break label14427;
      }
      paramawcg.a(new NoColumnError("lCardShowNum", Long.TYPE));
      i = paramCursor.getColumnIndex("bSingle");
      if (i != -1) {
        break label14442;
      }
      paramawcg.a(new NoColumnError("bSingle", Byte.TYPE));
      i = paramCursor.getColumnIndex("lVisitCount");
      if (i != -1) {
        break label14458;
      }
      paramawcg.a(new NoColumnError("lVisitCount", Long.TYPE));
      label5836:
      i = paramCursor.getColumnIndex("lVoteCount");
      if (i != -1) {
        break label14473;
      }
      paramawcg.a(new NoColumnError("lVoteCount", Long.TYPE));
      label5871:
      i = paramCursor.getColumnIndex("tagInfosByte");
      if (i != -1) {
        break label14488;
      }
      paramawcg.a(new NoColumnError("tagInfosByte", [B.class));
      i = paramCursor.getColumnIndex("eUserIdentityType");
      if (i != -1) {
        break label14503;
      }
      paramawcg.a(new NoColumnError("eUserIdentityType", Byte.TYPE));
      label5941:
      i = paramCursor.getColumnIndex("vBackground");
      if (i != -1) {
        break label14519;
      }
      paramawcg.a(new NoColumnError("vBackground", [B.class));
      label5976:
      i = paramCursor.getColumnIndex("labelInfoBytes");
      if (i != -1) {
        break label14534;
      }
      paramawcg.a(new NoColumnError("labelInfoBytes", [B.class));
      label6011:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label14549;
      }
      paramawcg.a(new NoColumnError("age", Byte.TYPE));
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label14565;
      }
      paramawcg.a(new NoColumnError("constellation", Integer.TYPE));
      label6081:
      i = paramCursor.getColumnIndex("pyFaceUrl");
      if (i != -1) {
        break label14580;
      }
      paramawcg.a(new NoColumnError("pyFaceUrl", String.class));
      label6116:
      i = paramCursor.getColumnIndex("location");
      if (i != -1) {
        break label14595;
      }
      paramawcg.a(new NoColumnError("location", String.class));
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label14610;
      }
      paramawcg.a(new NoColumnError("bVoted", Byte.TYPE));
      i = paramCursor.getColumnIndex("bFavorited");
      if (i != -1) {
        break label14626;
      }
      paramawcg.a(new NoColumnError("bFavorited", Byte.TYPE));
      label6221:
      i = paramCursor.getColumnIndex("iVoteIncrement");
      if (i != -1) {
        break label14642;
      }
      paramawcg.a(new NoColumnError("iVoteIncrement", Integer.TYPE));
      label6256:
      i = paramCursor.getColumnIndex("strJoinHexAlbumFileKey");
      if (i != -1) {
        break label14657;
      }
      paramawcg.a(new NoColumnError("strJoinHexAlbumFileKey", String.class));
      i = paramCursor.getColumnIndex("iFaceNum");
      if (i != -1) {
        break label14672;
      }
      paramawcg.a(new NoColumnError("iFaceNum", Integer.TYPE));
      label6326:
      i = paramCursor.getColumnIndex("cSqqLevel");
      if (i != -1) {
        break label14687;
      }
      paramawcg.a(new NoColumnError("cSqqLevel", Byte.TYPE));
      label6361:
      i = paramCursor.getColumnIndex("iQQLevel");
      if (i != -1) {
        break label14703;
      }
      paramawcg.a(new NoColumnError("iQQLevel", Integer.TYPE));
      label6396:
      i = paramCursor.getColumnIndex("uCurMulType");
      if (i != -1) {
        break label14718;
      }
      paramawcg.a(new NoColumnError("uCurMulType", Long.TYPE));
      i = paramCursor.getColumnIndex("strProvince");
      if (i != -1) {
        break label14733;
      }
      paramawcg.a(new NoColumnError("strProvince", String.class));
      label6466:
      i = paramCursor.getColumnIndex("strCity");
      if (i != -1) {
        break label14748;
      }
      paramawcg.a(new NoColumnError("strCity", String.class));
      label6501:
      i = paramCursor.getColumnIndex("strCountry");
      if (i != -1) {
        break label14763;
      }
      paramawcg.a(new NoColumnError("strCountry", String.class));
      i = paramCursor.getColumnIndex("lBirthday");
      if (i != -1) {
        break label14778;
      }
      paramawcg.a(new NoColumnError("lBirthday", Long.TYPE));
      i = paramCursor.getColumnIndex("strLocationCodes");
      if (i != -1) {
        break label14793;
      }
      paramawcg.a(new NoColumnError("strLocationCodes", String.class));
      label6606:
      i = paramCursor.getColumnIndex("strLocationDesc");
      if (i != -1) {
        break label14808;
      }
      paramawcg.a(new NoColumnError("strLocationDesc", String.class));
      label6641:
      i = paramCursor.getColumnIndex("strHometownCodes");
      if (i != -1) {
        break label14823;
      }
      paramawcg.a(new NoColumnError("strHometownCodes", String.class));
      i = paramCursor.getColumnIndex("strHometownDesc");
      if (i != -1) {
        break label14838;
      }
      paramawcg.a(new NoColumnError("strHometownDesc", String.class));
      label6711:
      i = paramCursor.getColumnIndex("strEmail");
      if (i != -1) {
        break label14853;
      }
      paramawcg.a(new NoColumnError("strEmail", String.class));
      label6746:
      i = paramCursor.getColumnIndex("strPersonalNote");
      if (i != -1) {
        break label14868;
      }
      paramawcg.a(new NoColumnError("strPersonalNote", String.class));
      label6781:
      i = paramCursor.getColumnIndex("iProfession");
      if (i != -1) {
        break label14883;
      }
      paramawcg.a(new NoColumnError("iProfession", Integer.TYPE));
      i = paramCursor.getColumnIndex("bindPhoneInfo");
      if (i != -1) {
        break label14898;
      }
      paramawcg.a(new NoColumnError("bindPhoneInfo", String.class));
      label6851:
      i = paramCursor.getColumnIndex("bCardInfo");
      if (i != -1) {
        break label14913;
      }
      paramawcg.a(new NoColumnError("bCardInfo", [B.class));
      label6886:
      i = paramCursor.getColumnIndex("strTroopName");
      if (i != -1) {
        break label14928;
      }
      paramawcg.a(new NoColumnError("strTroopName", String.class));
      i = paramCursor.getColumnIndex("strTroopNick");
      if (i != -1) {
        break label14943;
      }
      paramawcg.a(new NoColumnError("strTroopNick", String.class));
      i = paramCursor.getColumnIndex("strMobile");
      if (i != -1) {
        break label14958;
      }
      paramawcg.a(new NoColumnError("strMobile", String.class));
      label6997:
      i = paramCursor.getColumnIndex("strContactName");
      if (i != -1) {
        break label14973;
      }
      paramawcg.a(new NoColumnError("strContactName", String.class));
      label7034:
      i = paramCursor.getColumnIndex("ulShowControl");
      if (i != -1) {
        break label14988;
      }
      paramawcg.a(new NoColumnError("ulShowControl", Integer.TYPE));
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label15003;
      }
      paramawcg.a(new NoColumnError("feedPreviewTime", Long.TYPE));
      label7108:
      i = paramCursor.getColumnIndex("strQzoneFeedsDesc");
      if (i != -1) {
        break label15018;
      }
      paramawcg.a(new NoColumnError("strQzoneFeedsDesc", String.class));
      label7145:
      i = paramCursor.getColumnIndex("StrPresentDesc");
      if (i != -1) {
        break label15033;
      }
      paramawcg.a(new NoColumnError("StrPresentDesc", String.class));
      i = paramCursor.getColumnIndex("strSpaceName");
      if (i != -1) {
        break label15048;
      }
      paramawcg.a(new NoColumnError("strSpaceName", String.class));
      label7219:
      i = paramCursor.getColumnIndex("strQzoneHeader");
      if (i != -1) {
        break label15063;
      }
      paramawcg.a(new NoColumnError("strQzoneHeader", String.class));
      label7256:
      i = paramCursor.getColumnIndex("vQzonePhotos");
      if (i != -1) {
        break label15078;
      }
      paramawcg.a(new NoColumnError("vQzonePhotos", [B.class));
      label7293:
      i = paramCursor.getColumnIndex("vQzoneCoverInfo");
      if (i != -1) {
        break label15093;
      }
      paramawcg.a(new NoColumnError("vQzoneCoverInfo", [B.class));
      i = paramCursor.getColumnIndex("enlargeQzonePic");
      if (i != -1) {
        break label15108;
      }
      paramawcg.a(new NoColumnError("enlargeQzonePic", Integer.TYPE));
      label7367:
      i = paramCursor.getColumnIndex("showPublishButton");
      if (i != -1) {
        break label15123;
      }
      paramawcg.a(new NoColumnError("showPublishButton", Boolean.TYPE));
      i = paramCursor.getColumnIndex("strStatus");
      if (i != -1) {
        break label15150;
      }
      paramawcg.a(new NoColumnError("strStatus", String.class));
      i = paramCursor.getColumnIndex("strAutoRemark");
      if (i != -1) {
        break label15165;
      }
      paramawcg.a(new NoColumnError("strAutoRemark", String.class));
      label7478:
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label15180;
      }
      paramawcg.a(new NoColumnError("vSeed", [B.class));
      label7515:
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label15195;
      }
      paramawcg.a(new NoColumnError("vCookies", [B.class));
      i = paramCursor.getColumnIndex("hasFakeData");
      if (i != -1) {
        break label15210;
      }
      paramawcg.a(new NoColumnError("hasFakeData", Boolean.TYPE));
      i = paramCursor.getColumnIndex("bQQVipOpen");
      if (i != -1) {
        break label15237;
      }
      paramawcg.a(new NoColumnError("bQQVipOpen", Byte.TYPE));
      label7626:
      i = paramCursor.getColumnIndex("iQQVipType");
      if (i != -1) {
        break label15253;
      }
      paramawcg.a(new NoColumnError("iQQVipType", Integer.TYPE));
      label7663:
      i = paramCursor.getColumnIndex("iQQVipLevel");
      if (i != -1) {
        break label15268;
      }
      paramawcg.a(new NoColumnError("iQQVipLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("nameplateVipType");
      if (i != -1) {
        break label15283;
      }
      paramawcg.a(new NoColumnError("nameplateVipType", Integer.TYPE));
      label7737:
      i = paramCursor.getColumnIndex("grayNameplateFlag");
      if (i != -1) {
        break label15298;
      }
      paramawcg.a(new NoColumnError("grayNameplateFlag", Integer.TYPE));
      label7774:
      i = paramCursor.getColumnIndex("bSuperVipOpen");
      if (i != -1) {
        break label15313;
      }
      paramawcg.a(new NoColumnError("bSuperVipOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iSuperVipType");
      if (i != -1) {
        break label15329;
      }
      paramawcg.a(new NoColumnError("iSuperVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iSuperVipLevel");
      if (i != -1) {
        break label15344;
      }
      paramawcg.a(new NoColumnError("iSuperVipLevel", Integer.TYPE));
      label7885:
      i = paramCursor.getColumnIndex("bSuperQQOpen");
      if (i != -1) {
        break label15359;
      }
      paramawcg.a(new NoColumnError("bSuperQQOpen", Byte.TYPE));
      label7922:
      i = paramCursor.getColumnIndex("iSuperQQType");
      if (i != -1) {
        break label15375;
      }
      paramawcg.a(new NoColumnError("iSuperQQType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iSuperQQLevel");
      if (i != -1) {
        break label15390;
      }
      paramawcg.a(new NoColumnError("iSuperQQLevel", Integer.TYPE));
      label7996:
      i = paramCursor.getColumnIndex("bHollywoodVipOpen");
      if (i != -1) {
        break label15405;
      }
      paramawcg.a(new NoColumnError("bHollywoodVipOpen", Byte.TYPE));
      label8033:
      i = paramCursor.getColumnIndex("iHollywoodVipType");
      if (i != -1) {
        break label15421;
      }
      paramawcg.a(new NoColumnError("iHollywoodVipType", Integer.TYPE));
      i = paramCursor.getColumnIndex("iHollywoodVipLevel");
      if (i != -1) {
        break label15436;
      }
      paramawcg.a(new NoColumnError("iHollywoodVipLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("strShowName");
      if (i != -1) {
        break label15451;
      }
      paramawcg.a(new NoColumnError("strShowName", String.class));
      label8144:
      i = paramCursor.getColumnIndex("strVoiceFilekey");
      if (i != -1) {
        break label15466;
      }
      paramawcg.a(new NoColumnError("strVoiceFilekey", String.class));
      label8181:
      i = paramCursor.getColumnIndex("shDuration");
      if (i != -1) {
        break label15481;
      }
      paramawcg.a(new NoColumnError("shDuration", Short.TYPE));
      i = paramCursor.getColumnIndex("bRead");
      if (i != -1) {
        break label15496;
      }
      paramawcg.a(new NoColumnError("bRead", Byte.TYPE));
      label8255:
      i = paramCursor.getColumnIndex("strUrl");
      if (i != -1) {
        break label15512;
      }
      paramawcg.a(new NoColumnError("strUrl", String.class));
      label8292:
      i = paramCursor.getColumnIndex("vRichSign");
      if (i != -1) {
        break label15527;
      }
      paramawcg.a(new NoColumnError("vRichSign", [B.class));
      i = paramCursor.getColumnIndex("lSignModifyTime");
      if (i != -1) {
        break label15542;
      }
      paramawcg.a(new NoColumnError("lSignModifyTime", Long.TYPE));
      i = paramCursor.getColumnIndex("vLongNickTopicInfo");
      if (i != -1) {
        break label15557;
      }
      paramawcg.a(new NoColumnError("vLongNickTopicInfo", [B.class));
      label8403:
      i = paramCursor.getColumnIndex("nLastGameFlag");
      if (i != -1) {
        break label15572;
      }
      paramawcg.a(new NoColumnError("nLastGameFlag", Integer.TYPE));
      label8440:
      i = paramCursor.getColumnIndex("strGameLogoUrl_1");
      if (i != -1) {
        break label15587;
      }
      paramawcg.a(new NoColumnError("strGameLogoUrl_1", String.class));
      i = paramCursor.getColumnIndex("strGameLogoUrl_2");
      if (i != -1) {
        break label15602;
      }
      paramawcg.a(new NoColumnError("strGameLogoUrl_2", String.class));
      label8514:
      i = paramCursor.getColumnIndex("strGameLogoUrl_3");
      if (i != -1) {
        break label15617;
      }
      paramawcg.a(new NoColumnError("strGameLogoUrl_3", String.class));
      label8551:
      i = paramCursor.getColumnIndex("strGameLogoUrl_4");
      if (i != -1) {
        break label15632;
      }
      paramawcg.a(new NoColumnError("strGameLogoUrl_4", String.class));
      i = paramCursor.getColumnIndex("strGameLogoKey_1");
      if (i != -1) {
        break label15647;
      }
      paramawcg.a(new NoColumnError("strGameLogoKey_1", String.class));
      label8625:
      i = paramCursor.getColumnIndex("strGameLogoKey_2");
      if (i != -1) {
        break label15662;
      }
      paramawcg.a(new NoColumnError("strGameLogoKey_2", String.class));
      label8662:
      i = paramCursor.getColumnIndex("strGameLogoKey_3");
      if (i != -1) {
        break label15677;
      }
      paramawcg.a(new NoColumnError("strGameLogoKey_3", String.class));
      label8699:
      i = paramCursor.getColumnIndex("strGameLogoKey_4");
      if (i != -1) {
        break label15692;
      }
      paramawcg.a(new NoColumnError("strGameLogoKey_4", String.class));
      i = paramCursor.getColumnIndex("strGameName_1");
      if (i != -1) {
        break label15707;
      }
      paramawcg.a(new NoColumnError("strGameName_1", String.class));
      label8773:
      i = paramCursor.getColumnIndex("strGameName_2");
      if (i != -1) {
        break label15722;
      }
      paramawcg.a(new NoColumnError("strGameName_2", String.class));
      label8810:
      i = paramCursor.getColumnIndex("strGameName_3");
      if (i != -1) {
        break label15737;
      }
      paramawcg.a(new NoColumnError("strGameName_3", String.class));
      i = paramCursor.getColumnIndex("strGameName_4");
      if (i != -1) {
        break label15752;
      }
      paramawcg.a(new NoColumnError("strGameName_4", String.class));
      label8884:
      i = paramCursor.getColumnIndex("strGameAppid_1");
      if (i != -1) {
        break label15767;
      }
      paramawcg.a(new NoColumnError("strGameAppid_1", String.class));
      label8921:
      i = paramCursor.getColumnIndex("strGameAppid_2");
      if (i != -1) {
        break label15782;
      }
      paramawcg.a(new NoColumnError("strGameAppid_2", String.class));
      label8958:
      i = paramCursor.getColumnIndex("strGameAppid_3");
      if (i != -1) {
        break label15797;
      }
      paramawcg.a(new NoColumnError("strGameAppid_3", String.class));
      i = paramCursor.getColumnIndex("strGameAppid_4");
      if (i != -1) {
        break label15812;
      }
      paramawcg.a(new NoColumnError("strGameAppid_4", String.class));
      label9032:
      i = paramCursor.getColumnIndex("strProfileUrl");
      if (i != -1) {
        break label15827;
      }
      paramawcg.a(new NoColumnError("strProfileUrl", String.class));
      label9069:
      i = paramCursor.getColumnIndex("nStarFansFlag");
      if (i != -1) {
        break label15842;
      }
      paramawcg.a(new NoColumnError("nStarFansFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("strStarPicUrl_0");
      if (i != -1) {
        break label15857;
      }
      paramawcg.a(new NoColumnError("strStarPicUrl_0", String.class));
      label9143:
      i = paramCursor.getColumnIndex("strStarPicUrl_1");
      if (i != -1) {
        break label15872;
      }
      paramawcg.a(new NoColumnError("strStarPicUrl_1", String.class));
      label9180:
      i = paramCursor.getColumnIndex("strStarPicUrl_2");
      if (i != -1) {
        break label15887;
      }
      paramawcg.a(new NoColumnError("strStarPicUrl_2", String.class));
      i = paramCursor.getColumnIndex("strStarLvUrl_0");
      if (i != -1) {
        break label15902;
      }
      paramawcg.a(new NoColumnError("strStarLvUrl_0", String.class));
      i = paramCursor.getColumnIndex("strStarLvUrl_1");
      if (i != -1) {
        break label15917;
      }
      paramawcg.a(new NoColumnError("strStarLvUrl_1", String.class));
      label9291:
      i = paramCursor.getColumnIndex("strStarLvUrl_2");
      if (i != -1) {
        break label15932;
      }
      paramawcg.a(new NoColumnError("strStarLvUrl_2", String.class));
      label9328:
      i = paramCursor.getColumnIndex("strStarLogoUrl");
      if (i != -1) {
        break label15947;
      }
      paramawcg.a(new NoColumnError("strStarLogoUrl", String.class));
      i = paramCursor.getColumnIndex("starFansJumpUrl");
      if (i != -1) {
        break label15962;
      }
      paramawcg.a(new NoColumnError("starFansJumpUrl", String.class));
      label9402:
      i = paramCursor.getColumnIndex("lUserFlag");
      if (i != -1) {
        break label15977;
      }
      paramawcg.a(new NoColumnError("lUserFlag", Long.TYPE));
      label9439:
      i = paramCursor.getColumnIndex("lLoginDays");
      if (i != -1) {
        break label15992;
      }
      paramawcg.a(new NoColumnError("lLoginDays", Long.TYPE));
      i = paramCursor.getColumnIndex("strLoginDaysDesc");
      if (i != -1) {
        break label16007;
      }
      paramawcg.a(new NoColumnError("strLoginDaysDesc", String.class));
      i = paramCursor.getColumnIndex("lQQMasterLogindays");
      if (i != -1) {
        break label16022;
      }
      paramawcg.a(new NoColumnError("lQQMasterLogindays", Long.TYPE));
      label9550:
      i = paramCursor.getColumnIndex("iXManScene1DelayTime");
      if (i != -1) {
        break label16037;
      }
      paramawcg.a(new NoColumnError("iXManScene1DelayTime", Integer.TYPE));
      label9587:
      i = paramCursor.getColumnIndex("iXManScene2DelayTime");
      if (i != -1) {
        break label16052;
      }
      paramawcg.a(new NoColumnError("iXManScene2DelayTime", Integer.TYPE));
      i = paramCursor.getColumnIndex("allowPeopleSee");
      if (i != -1) {
        break label16067;
      }
      paramawcg.a(new NoColumnError("allowPeopleSee", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowCalInteractive");
      if (i != -1) {
        break label16094;
      }
      paramawcg.a(new NoColumnError("allowCalInteractive", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showOnlineFriends");
      if (i != -1) {
        break label16121;
      }
      paramawcg.a(new NoColumnError("showOnlineFriends", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowClick");
      if (i != -1) {
        break label16148;
      }
      paramawcg.a(new NoColumnError("allowClick", Boolean.TYPE));
      i = paramCursor.getColumnIndex("babyQSwitch");
      if (i != -1) {
        break label16175;
      }
      paramawcg.a(new NoColumnError("babyQSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showLightalk");
      if (i != -1) {
        break label16202;
      }
      paramawcg.a(new NoColumnError("showLightalk", Boolean.TYPE));
      i = paramCursor.getColumnIndex("lightalkNick");
      if (i != -1) {
        break label16229;
      }
      paramawcg.a(new NoColumnError("lightalkNick", String.class));
      i = paramCursor.getColumnIndex("lightalkId");
      if (i != -1) {
        break label16244;
      }
      paramawcg.a(new NoColumnError("lightalkId", String.class));
      label9920:
      i = paramCursor.getColumnIndex("isSuperRedDiamond");
      if (i != -1) {
        break label16259;
      }
      paramawcg.a(new NoColumnError("isSuperRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRedDiamond");
      if (i != -1) {
        break label16286;
      }
      paramawcg.a(new NoColumnError("isRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("redLevel");
      if (i != -1) {
        break label16313;
      }
      paramawcg.a(new NoColumnError("redLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("isSuperYellowDiamond");
      if (i != -1) {
        break label16328;
      }
      paramawcg.a(new NoColumnError("isSuperYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isYellowDiamond");
      if (i != -1) {
        break label16355;
      }
      paramawcg.a(new NoColumnError("isYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("yellowLevel");
      if (i != -1) {
        break label16382;
      }
      paramawcg.a(new NoColumnError("yellowLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("isSuperGreenDiamond");
      if (i != -1) {
        break label16397;
      }
      paramawcg.a(new NoColumnError("isSuperGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isGreenDiamond");
      if (i != -1) {
        break label16424;
      }
      paramawcg.a(new NoColumnError("isGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("greenLevel");
      if (i != -1) {
        break label16451;
      }
      paramawcg.a(new NoColumnError("greenLevel", Integer.TYPE));
      i = paramCursor.getColumnIndex("uAccelerateMultiple");
      if (i != -1) {
        break label16466;
      }
      paramawcg.a(new NoColumnError("uAccelerateMultiple", Long.TYPE));
      label10290:
      i = paramCursor.getColumnIndex("strRespMusicInfo");
      if (i != -1) {
        break label16481;
      }
      paramawcg.a(new NoColumnError("strRespMusicInfo", String.class));
      label10327:
      i = paramCursor.getColumnIndex("templateRet");
      if (i != -1) {
        break label16496;
      }
      paramawcg.a(new NoColumnError("templateRet", Integer.TYPE));
      label10364:
      i = paramCursor.getColumnIndex("lCurrentStyleId");
      if (i != -1) {
        break label16511;
      }
      paramawcg.a(new NoColumnError("lCurrentStyleId", Long.TYPE));
      i = paramCursor.getColumnIndex("lCurrentBgId");
      if (i != -1) {
        break label16526;
      }
      paramawcg.a(new NoColumnError("lCurrentBgId", Long.TYPE));
      label10438:
      i = paramCursor.getColumnIndex("backgroundUrl");
      if (i != -1) {
        break label16541;
      }
      paramawcg.a(new NoColumnError("backgroundUrl", String.class));
      label10475:
      i = paramCursor.getColumnIndex("backgroundColor");
      if (i != -1) {
        break label16556;
      }
      paramawcg.a(new NoColumnError("backgroundColor", Long.TYPE));
      i = paramCursor.getColumnIndex("dynamicCardFlag");
      if (i != -1) {
        break label16571;
      }
      paramawcg.a(new NoColumnError("dynamicCardFlag", Integer.TYPE));
      label10549:
      i = paramCursor.getColumnIndex("strZipUrl");
      if (i != -1) {
        break label16586;
      }
      paramawcg.a(new NoColumnError("strZipUrl", String.class));
      label10586:
      i = paramCursor.getColumnIndex("strActiveUrl");
      if (i != -1) {
        break label16601;
      }
      paramawcg.a(new NoColumnError("strActiveUrl", String.class));
      label10623:
      i = paramCursor.getColumnIndex("strDrawerCardUrl");
      if (i != -1) {
        break label16616;
      }
      paramawcg.a(new NoColumnError("strDrawerCardUrl", String.class));
      i = paramCursor.getColumnIndex("strWzryHeroUrl");
      if (i != -1) {
        break label16631;
      }
      paramawcg.a(new NoColumnError("strWzryHeroUrl", String.class));
      label10697:
      i = paramCursor.getColumnIndex("wzryHonorInfo");
      if (i != -1) {
        break label16646;
      }
      paramawcg.a(new NoColumnError("wzryHonorInfo", [B.class));
      label10734:
      i = paramCursor.getColumnIndex("strExtInfo");
      if (i != -1) {
        break label16661;
      }
      paramawcg.a(new NoColumnError("strExtInfo", String.class));
      i = paramCursor.getColumnIndex("strCurrentBgUrl");
      if (i != -1) {
        break label16676;
      }
      paramawcg.a(new NoColumnError("strCurrentBgUrl", String.class));
      label10808:
      i = paramCursor.getColumnIndex("bgType");
      if (i != -1) {
        break label16691;
      }
      paramawcg.a(new NoColumnError("bgType", [B.class));
      label10845:
      i = paramCursor.getColumnIndex("encId");
      if (i != -1) {
        break label16706;
      }
      paramawcg.a(new NoColumnError("encId", String.class));
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label16721;
      }
      paramawcg.a(new NoColumnError("busiEntry", String.class));
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label16736;
      }
      paramawcg.a(new NoColumnError("favoriteSource", Integer.TYPE));
      label10956:
      i = paramCursor.getColumnIndex("visibleMusicPendant");
      if (i != -1) {
        break label16751;
      }
      paramawcg.a(new NoColumnError("visibleMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("autoPlayMusicPendant");
      if (i != -1) {
        break label16778;
      }
      paramawcg.a(new NoColumnError("autoPlayMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showRedPointMusicPendant");
      if (i != -1) {
        break label16805;
      }
      paramawcg.a(new NoColumnError("showRedPointMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("privilegePromptStr");
      if (i != -1) {
        break label16832;
      }
      paramawcg.a(new NoColumnError("privilegePromptStr", String.class));
      label11104:
      i = paramCursor.getColumnIndex("privilegeJumpUrl");
      if (i != -1) {
        break label16847;
      }
      paramawcg.a(new NoColumnError("privilegeJumpUrl", String.class));
      i = paramCursor.getColumnIndex("vOpenPriv");
      if (i != -1) {
        break label16862;
      }
      paramawcg.a(new NoColumnError("vOpenPriv", [B.class));
      i = paramCursor.getColumnIndex("vClosePriv");
      if (i != -1) {
        break label16877;
      }
      paramawcg.a(new NoColumnError("vClosePriv", [B.class));
      label11215:
      i = paramCursor.getColumnIndex("presentDesc");
      if (i != -1) {
        break label16892;
      }
      paramawcg.a(new NoColumnError("presentDesc", String.class));
      label11252:
      i = paramCursor.getColumnIndex("presentCustourl");
      if (i != -1) {
        break label16907;
      }
      paramawcg.a(new NoColumnError("presentCustourl", String.class));
      i = paramCursor.getColumnIndex("presentSwitch");
      if (i != -1) {
        break label16922;
      }
      paramawcg.a(new NoColumnError("presentSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showPresent");
      if (i != -1) {
        break label16949;
      }
      paramawcg.a(new NoColumnError("showPresent", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showMusicBox");
      if (i != -1) {
        break label16976;
      }
      paramawcg.a(new NoColumnError("showMusicBox", Boolean.TYPE));
      i = paramCursor.getColumnIndex("addSrcName");
      if (i != -1) {
        break label17003;
      }
      paramawcg.a(new NoColumnError("addSrcName", String.class));
      i = paramCursor.getColumnIndex("addSrcId");
      if (i != -1) {
        break label17018;
      }
      paramawcg.a(new NoColumnError("addSrcId", Long.TYPE));
      label11474:
      i = paramCursor.getColumnIndex("addSubSrcId");
      if (i != -1) {
        break label17033;
      }
      paramawcg.a(new NoColumnError("addSubSrcId", Long.TYPE));
      label11511:
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label17048;
      }
      paramawcg.a(new NoColumnError("strVoteLimitedNotice", String.class));
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label17063;
      }
      paramawcg.a(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      label11585:
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label17078;
      }
      paramawcg.a(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      label11622:
      i = paramCursor.getColumnIndex("olympicTorch");
      if (i != -1) {
        break label17093;
      }
      paramawcg.a(new NoColumnError("olympicTorch", Byte.TYPE));
      i = paramCursor.getColumnIndex("mNowShowFlag");
      if (i != -1) {
        break label17109;
      }
      paramawcg.a(new NoColumnError("mNowShowFlag", Integer.TYPE));
      i = paramCursor.getColumnIndex("mNowShowIconUrl");
      if (i != -1) {
        break label17124;
      }
      paramawcg.a(new NoColumnError("mNowShowIconUrl", String.class));
      label11733:
      i = paramCursor.getColumnIndex("mNowShowJumpUrl");
      if (i != -1) {
        break label17139;
      }
      paramawcg.a(new NoColumnError("mNowShowJumpUrl", String.class));
      label11770:
      i = paramCursor.getColumnIndex("vCoverInfo");
      if (i != -1) {
        break label17154;
      }
      paramawcg.a(new NoColumnError("vCoverInfo", [B.class));
      i = paramCursor.getColumnIndex("videoHeadFlag");
      if (i != -1) {
        break label17169;
      }
      paramawcg.a(new NoColumnError("videoHeadFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("videoHeadUrl");
      if (i != -1) {
        break label17196;
      }
      paramawcg.a(new NoColumnError("videoHeadUrl", String.class));
      label11881:
      i = paramCursor.getColumnIndex("medalSwitchDisable");
      if (i != -1) {
        break label17211;
      }
      paramawcg.a(new NoColumnError("medalSwitchDisable", Boolean.TYPE));
      i = paramCursor.getColumnIndex("iMedalCount");
      if (i != -1) {
        break label17238;
      }
      paramawcg.a(new NoColumnError("iMedalCount", Integer.TYPE));
      label11955:
      i = paramCursor.getColumnIndex("iNewCount");
      if (i != -1) {
        break label17253;
      }
      paramawcg.a(new NoColumnError("iNewCount", Integer.TYPE));
      label11992:
      i = paramCursor.getColumnIndex("iUpgradeCount");
      if (i != -1) {
        break label17268;
      }
      paramawcg.a(new NoColumnError("iUpgradeCount", Integer.TYPE));
      label12029:
      i = paramCursor.getColumnIndex("strPromptParams");
      if (i != -1) {
        break label17283;
      }
      paramawcg.a(new NoColumnError("strPromptParams", String.class));
      i = paramCursor.getColumnIndex("hobbyEntry");
      if (i != -1) {
        break label17298;
      }
      paramawcg.a(new NoColumnError("hobbyEntry", String.class));
      label12103:
      i = paramCursor.getColumnIndex("lastPraiseInfoList");
      if (i != -1) {
        break label17313;
      }
      paramawcg.a(new NoColumnError("lastPraiseInfoList", [B.class));
      label12140:
      i = paramCursor.getColumnIndex("tempChatSig");
      if (i != -1) {
        break label17328;
      }
      paramawcg.a(new NoColumnError("tempChatSig", [B.class));
      i = paramCursor.getColumnIndex("namePlateOfKingGameId");
      if (i != -1) {
        break label17343;
      }
      paramawcg.a(new NoColumnError("namePlateOfKingGameId", Long.TYPE));
      label12214:
      i = paramCursor.getColumnIndex("namePlateOfKingLoginTime");
      if (i != -1) {
        break label17358;
      }
      paramawcg.a(new NoColumnError("namePlateOfKingLoginTime", Long.TYPE));
      label12251:
      i = paramCursor.getColumnIndex("namePlateOfKingDan");
      if (i != -1) {
        break label17373;
      }
      paramawcg.a(new NoColumnError("namePlateOfKingDan", Integer.TYPE));
      i = paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch");
      if (i != -1) {
        break label17388;
      }
      paramawcg.a(new NoColumnError("namePlateOfKingDanDisplatSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("vPersonalityLabelV2");
      if (i != -1) {
        break label17415;
      }
      paramawcg.a(new NoColumnError("vPersonalityLabelV2", [B.class));
      label12362:
      i = paramCursor.getColumnIndex("cardType");
      if (i != -1) {
        break label17430;
      }
      paramawcg.a(new NoColumnError("cardType", Integer.TYPE));
      label12399:
      i = paramCursor.getColumnIndex("diyText");
      if (i != -1) {
        break label17445;
      }
      paramawcg.a(new NoColumnError("diyText", String.class));
      i = paramCursor.getColumnIndex("diyTextFontId");
      if (i != -1) {
        break label17460;
      }
      paramawcg.a(new NoColumnError("diyTextFontId", Integer.TYPE));
      label12473:
      i = paramCursor.getColumnIndex("diyTextWidth");
      if (i != -1) {
        break label17475;
      }
      paramawcg.a(new NoColumnError("diyTextWidth", Float.TYPE));
      label12510:
      i = paramCursor.getColumnIndex("diyTextHeight");
      if (i != -1) {
        break label17490;
      }
      paramawcg.a(new NoColumnError("diyTextHeight", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextLocX");
      if (i != -1) {
        break label17505;
      }
      paramawcg.a(new NoColumnError("diyTextLocX", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextLocY");
      if (i != -1) {
        break label17520;
      }
      paramawcg.a(new NoColumnError("diyTextLocY", Float.TYPE));
      label12621:
      i = paramCursor.getColumnIndex("diyTextDegree");
      if (i != -1) {
        break label17535;
      }
      paramawcg.a(new NoColumnError("diyTextDegree", Float.TYPE));
      label12658:
      i = paramCursor.getColumnIndex("diyTextScale");
      if (i != -1) {
        break label17550;
      }
      paramawcg.a(new NoColumnError("diyTextScale", Float.TYPE));
      i = paramCursor.getColumnIndex("diyTextTransparency");
      if (i != -1) {
        break label17565;
      }
      paramawcg.a(new NoColumnError("diyTextTransparency", Float.TYPE));
      label12732:
      i = paramCursor.getColumnIndex("diyDefaultText");
      if (i != -1) {
        break label17580;
      }
      paramawcg.a(new NoColumnError("diyDefaultText", String.class));
      label12769:
      i = paramCursor.getColumnIndex("popularity");
      if (i != -1) {
        break label17595;
      }
      paramawcg.a(new NoColumnError("popularity", Integer.TYPE));
      i = paramCursor.getColumnIndex("declaration");
      if (i != -1) {
        break label17610;
      }
      paramawcg.a(new NoColumnError("declaration", String.class));
      i = paramCursor.getColumnIndex("voiceUrl");
      if (i != -1) {
        break label17625;
      }
      paramawcg.a(new NoColumnError("voiceUrl", String.class));
      label12880:
      i = paramCursor.getColumnIndex("isShowCard");
      if (i != -1) {
        break label17640;
      }
      paramawcg.a(new NoColumnError("isShowCard", Boolean.TYPE));
      i = paramCursor.getColumnIndex("updateTime");
      if (i != -1) {
        break label17667;
      }
      paramawcg.a(new NoColumnError("updateTime", Long.TYPE));
      i = paramCursor.getColumnIndex("extendFriendFlag");
      if (i != -1) {
        break label17682;
      }
      paramawcg.a(new NoColumnError("extendFriendFlag", Integer.TYPE));
      label12991:
      i = paramCursor.getColumnIndex("extendFriendVoiceDuration");
      if (i != -1) {
        break label17697;
      }
      paramawcg.a(new NoColumnError("extendFriendVoiceDuration", Integer.TYPE));
      label13028:
      i = paramCursor.getColumnIndex("extendFriendEntryContact");
      if (i != -1) {
        break label17712;
      }
      paramawcg.a(new NoColumnError("extendFriendEntryContact", Short.TYPE));
      i = paramCursor.getColumnIndex("extendFriendEntryAddFriend");
      if (i != -1) {
        break label17727;
      }
      paramawcg.a(new NoColumnError("extendFriendEntryAddFriend", Short.TYPE));
      i = paramCursor.getColumnIndex("extendFriendQuestion");
      if (i != -1) {
        break label17742;
      }
      paramawcg.a(new NoColumnError("extendFriendQuestion", Short.TYPE));
      label13139:
      i = paramCursor.getColumnIndex("fontId");
      if (i != -1) {
        break label17757;
      }
      paramawcg.a(new NoColumnError("fontId", Integer.TYPE));
      label13176:
      i = paramCursor.getColumnIndex("fontType");
      if (i != -1) {
        break label17772;
      }
      paramawcg.a(new NoColumnError("fontType", Integer.TYPE));
      i = paramCursor.getColumnIndex("clothesId");
      if (i != -1) {
        break label17787;
      }
      paramawcg.a(new NoColumnError("clothesId", Integer.TYPE));
      label13250:
      i = paramCursor.getColumnIndex("schoolId");
      if (i != -1) {
        break label17802;
      }
      paramawcg.a(new NoColumnError("schoolId", String.class));
      label13287:
      i = paramCursor.getColumnIndex("schoolName");
      if (i != -1) {
        break label17817;
      }
      paramawcg.a(new NoColumnError("schoolName", String.class));
      i = paramCursor.getColumnIndex("authState");
      if (i != -1) {
        break label17832;
      }
      paramawcg.a(new NoColumnError("authState", Long.TYPE));
      label13361:
      i = paramCursor.getColumnIndex("idx");
      if (i != -1) {
        break label17847;
      }
      paramawcg.a(new NoColumnError("idx", Integer.TYPE));
      label13398:
      i = paramCursor.getColumnIndex("category");
      if (i != -1) {
        break label17862;
      }
      paramawcg.a(new NoColumnError("category", Integer.TYPE));
      label13435:
      i = paramCursor.getColumnIndex("isShowMiniPlaying");
      if (i != -1) {
        break label17877;
      }
      paramawcg.a(new NoColumnError("isShowMiniPlaying", Boolean.TYPE));
      i = paramCursor.getColumnIndex("tabJumpUrl");
      if (i != -1) {
        break label17904;
      }
      paramawcg.a(new NoColumnError("tabJumpUrl", String.class));
      label13509:
      i = paramCursor.getColumnIndex("guestJumpUrl");
      if (i != -1) {
        break label17919;
      }
      paramawcg.a(new NoColumnError("guestJumpUrl", String.class));
      label13546:
      i = paramCursor.getColumnIndex("guestAppTotal");
      if (i != -1) {
        break label17934;
      }
      paramawcg.a(new NoColumnError("guestAppTotal", Integer.TYPE));
      i = paramCursor.getColumnIndex("defaultCardId");
      if (i != -1) {
        break label17949;
      }
      paramawcg.a(new NoColumnError("defaultCardId", Integer.TYPE));
      label13620:
      i = paramCursor.getColumnIndex("strangerVoteOpen");
      if (i != -1) {
        break label17964;
      }
      paramawcg.a(new NoColumnError("strangerVoteOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("lSuperVipTemplateId");
      if (i != -1) {
        break label17991;
      }
      paramawcg.a(new NoColumnError("lSuperVipTemplateId", Long.TYPE));
      label13694:
      i = paramCursor.getColumnIndex("bBigClubVipOpen");
      if (i != -1) {
        break label18006;
      }
      paramawcg.a(new NoColumnError("bBigClubVipOpen", Byte.TYPE));
      i = paramCursor.getColumnIndex("iBigClubVipType");
      if (i != -1) {
        break label18022;
      }
      paramawcg.a(new NoColumnError("iBigClubVipType", Integer.TYPE));
      label13768:
      i = paramCursor.getColumnIndex("iBigClubVipLevel");
      if (i != -1) {
        break label18037;
      }
      paramawcg.a(new NoColumnError("iBigClubVipLevel", Integer.TYPE));
      label13805:
      i = paramCursor.getColumnIndex("lBigClubTemplateId");
      if (i != -1) {
        break label18052;
      }
      paramawcg.a(new NoColumnError("lBigClubTemplateId", Long.TYPE));
      i = paramCursor.getColumnIndex("diyComplicatedInfo");
      if (i != -1) {
        break label18067;
      }
      paramawcg.a(new NoColumnError("diyComplicatedInfo", String.class));
      label13879:
      i = paramCursor.getColumnIndex("cardId");
      if (i != -1) {
        break label18082;
      }
      paramawcg.a(new NoColumnError("cardId", Long.TYPE));
      label13916:
      i = paramCursor.getColumnIndex("strangerInviteMeGroupOpen");
      if (i != -1) {
        break label18097;
      }
      paramawcg.a(new NoColumnError("strangerInviteMeGroupOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isPrettyGroupOwner");
      if (i != -1) {
        break label18124;
      }
      paramawcg.a(new NoColumnError("isPrettyGroupOwner", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isHidePrettyGroutIdentity");
      if (i != -1) {
        break label18151;
      }
      paramawcg.a(new NoColumnError("isHidePrettyGroutIdentity", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mQQLevelType");
      if (i != -1) {
        break label18178;
      }
      paramawcg.a(new NoColumnError("mQQLevelType", Integer.TYPE));
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
      paramawcg.a(new NoColumnError("schoolVerifiedFlag", Boolean.TYPE));
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
      paramawcg.a(new NoColumnError("troopHonorSwitch", Boolean.TYPE));
      label9217:
      label9476:
      label10253:
      label10512:
      label10771:
      label11289:
      label12954:
      return paramawbv;
      label10882:
      label11141:
      label11659:
      label12177:
      label12436:
      label12695:
      paramawbv.uin = paramCursor.getString(i);
      label12288:
      label12547:
      label12806:
      label13065:
      label13324:
      label13583:
      label13842:
      break;
      label14155:
      paramawbv.strNick = paramCursor.getString(i);
      break label5136;
      label14170:
      paramawbv.shGender = paramCursor.getShort(i);
      break label5171;
      label14185:
      paramawbv.shAge = paramCursor.getShort(i);
      break label5206;
      label14200:
      paramawbv.nFaceID = paramCursor.getInt(i);
      break label5241;
      label14215:
      paramawbv.strCertificationInfo = paramCursor.getString(i);
      break label5276;
      label14230:
      paramawbv.shType = paramCursor.getShort(i);
      break label5311;
      label14245:
      paramawbv.vContent = paramCursor.getBlob(i);
      break label5346;
      label14260:
      paramawbv.strSign = paramCursor.getString(i);
      break label5381;
      label14275:
      paramawbv.strCompany = paramCursor.getString(i);
      break label5416;
      label14290:
      paramawbv.strSchool = paramCursor.getString(i);
      break label5451;
      label14305:
      paramawbv.uFaceTimeStamp = paramCursor.getInt(i);
      break label5486;
      label14320:
      paramawbv.vQQFaceID = paramCursor.getBlob(i);
      break label5521;
      label14335:
      paramawbv.strReMark = paramCursor.getString(i);
      break label5556;
      label14350:
      paramawbv.bWeiboInfo = ((byte)paramCursor.getShort(i));
      break label5591;
      label14366:
      paramawbv.bQzoneInfo = ((byte)paramCursor.getShort(i));
      break label5626;
      label14382:
      paramawbv.nSameFriendsNum = paramCursor.getInt(i);
      break label5661;
      label14397:
      paramawbv.strCompanySame = paramCursor.getString(i);
      break label5696;
      label14412:
      paramawbv.strSchoolSame = paramCursor.getString(i);
      break label5731;
      label14427:
      paramawbv.lCardShowNum = paramCursor.getLong(i);
      break label5766;
      label14442:
      paramawbv.bSingle = ((byte)paramCursor.getShort(i));
      break label5801;
      label14458:
      paramawbv.lVisitCount = paramCursor.getLong(i);
      break label5836;
      label14473:
      paramawbv.lVoteCount = paramCursor.getLong(i);
      break label5871;
      label14488:
      paramawbv.tagInfosByte = paramCursor.getBlob(i);
      break label5906;
      label14503:
      paramawbv.eUserIdentityType = ((byte)paramCursor.getShort(i));
      break label5941;
      label14519:
      paramawbv.vBackground = paramCursor.getBlob(i);
      break label5976;
      label14534:
      paramawbv.labelInfoBytes = paramCursor.getBlob(i);
      break label6011;
      label14549:
      paramawbv.age = ((byte)paramCursor.getShort(i));
      break label6046;
      label14565:
      paramawbv.constellation = paramCursor.getInt(i);
      break label6081;
      label14580:
      paramawbv.pyFaceUrl = paramCursor.getString(i);
      break label6116;
      label14595:
      paramawbv.location = paramCursor.getString(i);
      break label6151;
      label14610:
      paramawbv.bVoted = ((byte)paramCursor.getShort(i));
      break label6186;
      label14626:
      paramawbv.bFavorited = ((byte)paramCursor.getShort(i));
      break label6221;
      label14642:
      paramawbv.iVoteIncrement = paramCursor.getInt(i);
      break label6256;
      label14657:
      paramawbv.strJoinHexAlbumFileKey = paramCursor.getString(i);
      break label6291;
      label14672:
      paramawbv.iFaceNum = paramCursor.getInt(i);
      break label6326;
      label14687:
      paramawbv.cSqqLevel = ((byte)paramCursor.getShort(i));
      break label6361;
      label14703:
      paramawbv.iQQLevel = paramCursor.getInt(i);
      break label6396;
      label14718:
      paramawbv.uCurMulType = paramCursor.getLong(i);
      break label6431;
      label14733:
      paramawbv.strProvince = paramCursor.getString(i);
      break label6466;
      label14748:
      paramawbv.strCity = paramCursor.getString(i);
      break label6501;
      label14763:
      paramawbv.strCountry = paramCursor.getString(i);
      break label6536;
      label14778:
      paramawbv.lBirthday = paramCursor.getLong(i);
      break label6571;
      label14793:
      paramawbv.strLocationCodes = paramCursor.getString(i);
      break label6606;
      label14808:
      paramawbv.strLocationDesc = paramCursor.getString(i);
      break label6641;
      label14823:
      paramawbv.strHometownCodes = paramCursor.getString(i);
      break label6676;
      label14838:
      paramawbv.strHometownDesc = paramCursor.getString(i);
      break label6711;
      label14853:
      paramawbv.strEmail = paramCursor.getString(i);
      break label6746;
      label14868:
      paramawbv.strPersonalNote = paramCursor.getString(i);
      break label6781;
      label14883:
      paramawbv.iProfession = paramCursor.getInt(i);
      break label6816;
      label14898:
      paramawbv.bindPhoneInfo = paramCursor.getString(i);
      break label6851;
      label14913:
      paramawbv.bCardInfo = paramCursor.getBlob(i);
      break label6886;
      label14928:
      paramawbv.strTroopName = paramCursor.getString(i);
      break label6923;
      label14943:
      paramawbv.strTroopNick = paramCursor.getString(i);
      break label6960;
      label14958:
      paramawbv.strMobile = paramCursor.getString(i);
      break label6997;
      label14973:
      paramawbv.strContactName = paramCursor.getString(i);
      break label7034;
      label14988:
      paramawbv.ulShowControl = paramCursor.getInt(i);
      break label7071;
      label15003:
      paramawbv.feedPreviewTime = paramCursor.getLong(i);
      break label7108;
      label15018:
      paramawbv.strQzoneFeedsDesc = paramCursor.getString(i);
      break label7145;
      label15033:
      paramawbv.StrPresentDesc = paramCursor.getString(i);
      break label7182;
      label15048:
      paramawbv.strSpaceName = paramCursor.getString(i);
      break label7219;
      label15063:
      paramawbv.strQzoneHeader = paramCursor.getString(i);
      break label7256;
      label15078:
      paramawbv.vQzonePhotos = paramCursor.getBlob(i);
      break label7293;
      label15093:
      paramawbv.vQzoneCoverInfo = paramCursor.getBlob(i);
      break label7330;
      label15108:
      paramawbv.enlargeQzonePic = paramCursor.getInt(i);
      break label7367;
      label15123:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.showPublishButton = paramBoolean;
        break;
      }
      label15150:
      paramawbv.strStatus = paramCursor.getString(i);
      break label7441;
      label15165:
      paramawbv.strAutoRemark = paramCursor.getString(i);
      break label7478;
      label15180:
      paramawbv.vSeed = paramCursor.getBlob(i);
      break label7515;
      label15195:
      paramawbv.vCookies = paramCursor.getBlob(i);
      break label7552;
      label15210:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.hasFakeData = paramBoolean;
        break;
      }
      label15237:
      paramawbv.bQQVipOpen = ((byte)paramCursor.getShort(i));
      break label7626;
      label15253:
      paramawbv.iQQVipType = paramCursor.getInt(i);
      break label7663;
      label15268:
      paramawbv.iQQVipLevel = paramCursor.getInt(i);
      break label7700;
      label15283:
      paramawbv.nameplateVipType = paramCursor.getInt(i);
      break label7737;
      label15298:
      paramawbv.grayNameplateFlag = paramCursor.getInt(i);
      break label7774;
      label15313:
      paramawbv.bSuperVipOpen = ((byte)paramCursor.getShort(i));
      break label7811;
      label15329:
      paramawbv.iSuperVipType = paramCursor.getInt(i);
      break label7848;
      label15344:
      paramawbv.iSuperVipLevel = paramCursor.getInt(i);
      break label7885;
      label15359:
      paramawbv.bSuperQQOpen = ((byte)paramCursor.getShort(i));
      break label7922;
      label15375:
      paramawbv.iSuperQQType = paramCursor.getInt(i);
      break label7959;
      label15390:
      paramawbv.iSuperQQLevel = paramCursor.getInt(i);
      break label7996;
      label15405:
      paramawbv.bHollywoodVipOpen = ((byte)paramCursor.getShort(i));
      break label8033;
      label15421:
      paramawbv.iHollywoodVipType = paramCursor.getInt(i);
      break label8070;
      label15436:
      paramawbv.iHollywoodVipLevel = paramCursor.getInt(i);
      break label8107;
      label15451:
      paramawbv.strShowName = paramCursor.getString(i);
      break label8144;
      label15466:
      paramawbv.strVoiceFilekey = paramCursor.getString(i);
      break label8181;
      label15481:
      paramawbv.shDuration = paramCursor.getShort(i);
      break label8218;
      label15496:
      paramawbv.bRead = ((byte)paramCursor.getShort(i));
      break label8255;
      label15512:
      paramawbv.strUrl = paramCursor.getString(i);
      break label8292;
      label15527:
      paramawbv.vRichSign = paramCursor.getBlob(i);
      break label8329;
      label15542:
      paramawbv.lSignModifyTime = paramCursor.getLong(i);
      break label8366;
      label15557:
      paramawbv.vLongNickTopicInfo = paramCursor.getBlob(i);
      break label8403;
      label15572:
      paramawbv.nLastGameFlag = paramCursor.getInt(i);
      break label8440;
      label15587:
      paramawbv.strGameLogoUrl_1 = paramCursor.getString(i);
      break label8477;
      label15602:
      paramawbv.strGameLogoUrl_2 = paramCursor.getString(i);
      break label8514;
      label15617:
      paramawbv.strGameLogoUrl_3 = paramCursor.getString(i);
      break label8551;
      label15632:
      paramawbv.strGameLogoUrl_4 = paramCursor.getString(i);
      break label8588;
      label15647:
      paramawbv.strGameLogoKey_1 = paramCursor.getString(i);
      break label8625;
      label15662:
      paramawbv.strGameLogoKey_2 = paramCursor.getString(i);
      break label8662;
      label15677:
      paramawbv.strGameLogoKey_3 = paramCursor.getString(i);
      break label8699;
      label15692:
      paramawbv.strGameLogoKey_4 = paramCursor.getString(i);
      break label8736;
      label15707:
      paramawbv.strGameName_1 = paramCursor.getString(i);
      break label8773;
      label15722:
      paramawbv.strGameName_2 = paramCursor.getString(i);
      break label8810;
      label15737:
      paramawbv.strGameName_3 = paramCursor.getString(i);
      break label8847;
      label15752:
      paramawbv.strGameName_4 = paramCursor.getString(i);
      break label8884;
      label15767:
      paramawbv.strGameAppid_1 = paramCursor.getString(i);
      break label8921;
      label15782:
      paramawbv.strGameAppid_2 = paramCursor.getString(i);
      break label8958;
      label15797:
      paramawbv.strGameAppid_3 = paramCursor.getString(i);
      break label8995;
      label15812:
      paramawbv.strGameAppid_4 = paramCursor.getString(i);
      break label9032;
      label15827:
      paramawbv.strProfileUrl = paramCursor.getString(i);
      break label9069;
      label15842:
      paramawbv.nStarFansFlag = paramCursor.getInt(i);
      break label9106;
      label15857:
      paramawbv.strStarPicUrl_0 = paramCursor.getString(i);
      break label9143;
      label15872:
      paramawbv.strStarPicUrl_1 = paramCursor.getString(i);
      break label9180;
      label15887:
      paramawbv.strStarPicUrl_2 = paramCursor.getString(i);
      break label9217;
      label15902:
      paramawbv.strStarLvUrl_0 = paramCursor.getString(i);
      break label9254;
      label15917:
      paramawbv.strStarLvUrl_1 = paramCursor.getString(i);
      break label9291;
      label15932:
      paramawbv.strStarLvUrl_2 = paramCursor.getString(i);
      break label9328;
      label15947:
      paramawbv.strStarLogoUrl = paramCursor.getString(i);
      break label9365;
      label15962:
      paramawbv.starFansJumpUrl = paramCursor.getString(i);
      break label9402;
      label15977:
      paramawbv.lUserFlag = paramCursor.getLong(i);
      break label9439;
      label15992:
      paramawbv.lLoginDays = paramCursor.getLong(i);
      break label9476;
      label16007:
      paramawbv.strLoginDaysDesc = paramCursor.getString(i);
      break label9513;
      label16022:
      paramawbv.lQQMasterLogindays = paramCursor.getLong(i);
      break label9550;
      label16037:
      paramawbv.iXManScene1DelayTime = paramCursor.getInt(i);
      break label9587;
      label16052:
      paramawbv.iXManScene2DelayTime = paramCursor.getInt(i);
      break label9624;
      label16067:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.allowPeopleSee = paramBoolean;
        break;
      }
      label16094:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.allowCalInteractive = paramBoolean;
        break;
      }
      label16121:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.showOnlineFriends = paramBoolean;
        break;
      }
      label16148:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.allowClick = paramBoolean;
        break;
      }
      label16175:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.babyQSwitch = paramBoolean;
        break;
      }
      label16202:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.showLightalk = paramBoolean;
        break;
      }
      label16229:
      paramawbv.lightalkNick = paramCursor.getString(i);
      break label9883;
      label16244:
      paramawbv.lightalkId = paramCursor.getString(i);
      break label9920;
      label16259:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isSuperRedDiamond = paramBoolean;
        break;
      }
      label16286:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isRedDiamond = paramBoolean;
        break;
      }
      label16313:
      paramawbv.redLevel = paramCursor.getInt(i);
      break label10031;
      label16328:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isSuperYellowDiamond = paramBoolean;
        break;
      }
      label16355:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isYellowDiamond = paramBoolean;
        break;
      }
      label16382:
      paramawbv.yellowLevel = paramCursor.getInt(i);
      break label10142;
      label16397:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isSuperGreenDiamond = paramBoolean;
        break;
      }
      label16424:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isGreenDiamond = paramBoolean;
        break;
      }
      label16451:
      paramawbv.greenLevel = paramCursor.getInt(i);
      break label10253;
      label16466:
      paramawbv.uAccelerateMultiple = paramCursor.getLong(i);
      break label10290;
      label16481:
      paramawbv.strRespMusicInfo = paramCursor.getString(i);
      break label10327;
      label16496:
      paramawbv.templateRet = paramCursor.getInt(i);
      break label10364;
      label16511:
      paramawbv.lCurrentStyleId = paramCursor.getLong(i);
      break label10401;
      label16526:
      paramawbv.lCurrentBgId = paramCursor.getLong(i);
      break label10438;
      label16541:
      paramawbv.backgroundUrl = paramCursor.getString(i);
      break label10475;
      label16556:
      paramawbv.backgroundColor = paramCursor.getLong(i);
      break label10512;
      label16571:
      paramawbv.dynamicCardFlag = paramCursor.getInt(i);
      break label10549;
      label16586:
      paramawbv.strZipUrl = paramCursor.getString(i);
      break label10586;
      label16601:
      paramawbv.strActiveUrl = paramCursor.getString(i);
      break label10623;
      label16616:
      paramawbv.strDrawerCardUrl = paramCursor.getString(i);
      break label10660;
      label16631:
      paramawbv.strWzryHeroUrl = paramCursor.getString(i);
      break label10697;
      label16646:
      paramawbv.wzryHonorInfo = paramCursor.getBlob(i);
      break label10734;
      label16661:
      paramawbv.strExtInfo = paramCursor.getString(i);
      break label10771;
      label16676:
      paramawbv.strCurrentBgUrl = paramCursor.getString(i);
      break label10808;
      label16691:
      paramawbv.bgType = paramCursor.getBlob(i);
      break label10845;
      label16706:
      paramawbv.encId = paramCursor.getString(i);
      break label10882;
      label16721:
      paramawbv.busiEntry = paramCursor.getString(i);
      break label10919;
      label16736:
      paramawbv.favoriteSource = paramCursor.getInt(i);
      break label10956;
      label16751:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.visibleMusicPendant = paramBoolean;
        break;
      }
      label16778:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.autoPlayMusicPendant = paramBoolean;
        break;
      }
      label16805:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.showRedPointMusicPendant = paramBoolean;
        break;
      }
      label16832:
      paramawbv.privilegePromptStr = paramCursor.getString(i);
      break label11104;
      label16847:
      paramawbv.privilegeJumpUrl = paramCursor.getString(i);
      break label11141;
      label16862:
      paramawbv.vOpenPriv = paramCursor.getBlob(i);
      break label11178;
      label16877:
      paramawbv.vClosePriv = paramCursor.getBlob(i);
      break label11215;
      label16892:
      paramawbv.presentDesc = paramCursor.getString(i);
      break label11252;
      label16907:
      paramawbv.presentCustourl = paramCursor.getString(i);
      break label11289;
      label16922:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.presentSwitch = paramBoolean;
        break;
      }
      label16949:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.showPresent = paramBoolean;
        break;
      }
      label16976:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.showMusicBox = paramBoolean;
        break;
      }
      label17003:
      paramawbv.addSrcName = paramCursor.getString(i);
      break label11437;
      label17018:
      paramawbv.addSrcId = paramCursor.getLong(i);
      break label11474;
      label17033:
      paramawbv.addSubSrcId = paramCursor.getLong(i);
      break label11511;
      label17048:
      paramawbv.strVoteLimitedNotice = paramCursor.getString(i);
      break label11548;
      label17063:
      paramawbv.bHaveVotedCnt = paramCursor.getShort(i);
      break label11585;
      label17078:
      paramawbv.bAvailVoteCnt = paramCursor.getShort(i);
      break label11622;
      label17093:
      paramawbv.olympicTorch = ((byte)paramCursor.getShort(i));
      break label11659;
      label17109:
      paramawbv.mNowShowFlag = paramCursor.getInt(i);
      break label11696;
      label17124:
      paramawbv.mNowShowIconUrl = paramCursor.getString(i);
      break label11733;
      label17139:
      paramawbv.mNowShowJumpUrl = paramCursor.getString(i);
      break label11770;
      label17154:
      paramawbv.vCoverInfo = paramCursor.getBlob(i);
      break label11807;
      label17169:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.videoHeadFlag = paramBoolean;
        break;
      }
      label17196:
      paramawbv.videoHeadUrl = paramCursor.getString(i);
      break label11881;
      label17211:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.medalSwitchDisable = paramBoolean;
        break;
      }
      label17238:
      paramawbv.iMedalCount = paramCursor.getInt(i);
      break label11955;
      label17253:
      paramawbv.iNewCount = paramCursor.getInt(i);
      break label11992;
      label17268:
      paramawbv.iUpgradeCount = paramCursor.getInt(i);
      break label12029;
      label17283:
      paramawbv.strPromptParams = paramCursor.getString(i);
      break label12066;
      label17298:
      paramawbv.hobbyEntry = paramCursor.getString(i);
      break label12103;
      label17313:
      paramawbv.lastPraiseInfoList = paramCursor.getBlob(i);
      break label12140;
      label17328:
      paramawbv.tempChatSig = paramCursor.getBlob(i);
      break label12177;
      label17343:
      paramawbv.namePlateOfKingGameId = paramCursor.getLong(i);
      break label12214;
      label17358:
      paramawbv.namePlateOfKingLoginTime = paramCursor.getLong(i);
      break label12251;
      label17373:
      paramawbv.namePlateOfKingDan = paramCursor.getInt(i);
      break label12288;
      label17388:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.namePlateOfKingDanDisplatSwitch = paramBoolean;
        break;
      }
      label17415:
      paramawbv.vPersonalityLabelV2 = paramCursor.getBlob(i);
      break label12362;
      label17430:
      paramawbv.cardType = paramCursor.getInt(i);
      break label12399;
      label17445:
      paramawbv.diyText = paramCursor.getString(i);
      break label12436;
      label17460:
      paramawbv.diyTextFontId = paramCursor.getInt(i);
      break label12473;
      label17475:
      paramawbv.diyTextWidth = paramCursor.getFloat(i);
      break label12510;
      label17490:
      paramawbv.diyTextHeight = paramCursor.getFloat(i);
      break label12547;
      label17505:
      paramawbv.diyTextLocX = paramCursor.getFloat(i);
      break label12584;
      label17520:
      paramawbv.diyTextLocY = paramCursor.getFloat(i);
      break label12621;
      label17535:
      paramawbv.diyTextDegree = paramCursor.getFloat(i);
      break label12658;
      label17550:
      paramawbv.diyTextScale = paramCursor.getFloat(i);
      break label12695;
      label17565:
      paramawbv.diyTextTransparency = paramCursor.getFloat(i);
      break label12732;
      label17580:
      paramawbv.diyDefaultText = paramCursor.getString(i);
      break label12769;
      label17595:
      paramawbv.popularity = paramCursor.getInt(i);
      break label12806;
      label17610:
      paramawbv.declaration = paramCursor.getString(i);
      break label12843;
      label17625:
      paramawbv.voiceUrl = paramCursor.getString(i);
      break label12880;
      label17640:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isShowCard = paramBoolean;
        break;
      }
      label17667:
      paramawbv.updateTime = paramCursor.getLong(i);
      break label12954;
      label17682:
      paramawbv.extendFriendFlag = paramCursor.getInt(i);
      break label12991;
      label17697:
      paramawbv.extendFriendVoiceDuration = paramCursor.getInt(i);
      break label13028;
      label17712:
      paramawbv.extendFriendEntryContact = paramCursor.getShort(i);
      break label13065;
      label17727:
      paramawbv.extendFriendEntryAddFriend = paramCursor.getShort(i);
      break label13102;
      label17742:
      paramawbv.extendFriendQuestion = paramCursor.getShort(i);
      break label13139;
      label17757:
      paramawbv.fontId = paramCursor.getInt(i);
      break label13176;
      label17772:
      paramawbv.fontType = paramCursor.getInt(i);
      break label13213;
      label17787:
      paramawbv.clothesId = paramCursor.getInt(i);
      break label13250;
      label17802:
      paramawbv.schoolId = paramCursor.getString(i);
      break label13287;
      label17817:
      paramawbv.schoolName = paramCursor.getString(i);
      break label13324;
      label17832:
      paramawbv.authState = paramCursor.getLong(i);
      break label13361;
      label17847:
      paramawbv.idx = paramCursor.getInt(i);
      break label13398;
      label17862:
      paramawbv.category = paramCursor.getInt(i);
      break label13435;
      label17877:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isShowMiniPlaying = paramBoolean;
        break;
      }
      label17904:
      paramawbv.tabJumpUrl = paramCursor.getString(i);
      break label13509;
      label17919:
      paramawbv.guestJumpUrl = paramCursor.getString(i);
      break label13546;
      label17934:
      paramawbv.guestAppTotal = paramCursor.getInt(i);
      break label13583;
      label17949:
      paramawbv.defaultCardId = paramCursor.getInt(i);
      break label13620;
      label17964:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.strangerVoteOpen = paramBoolean;
        break;
      }
      label17991:
      paramawbv.lSuperVipTemplateId = paramCursor.getLong(i);
      break label13694;
      label18006:
      paramawbv.bBigClubVipOpen = ((byte)paramCursor.getShort(i));
      break label13731;
      label18022:
      paramawbv.iBigClubVipType = paramCursor.getInt(i);
      break label13768;
      label18037:
      paramawbv.iBigClubVipLevel = paramCursor.getInt(i);
      break label13805;
      label18052:
      paramawbv.lBigClubTemplateId = paramCursor.getLong(i);
      break label13842;
      label18067:
      paramawbv.diyComplicatedInfo = paramCursor.getString(i);
      break label13879;
      label18082:
      paramawbv.cardId = paramCursor.getLong(i);
      break label13916;
      label18097:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.strangerInviteMeGroupOpen = paramBoolean;
        break;
      }
      label18124:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isPrettyGroupOwner = paramBoolean;
        break;
      }
      label18151:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isHidePrettyGroutIdentity = paramBoolean;
        break;
      }
      label18178:
      paramawbv.mQQLevelType = paramCursor.getInt(i);
    }
    label18193:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramawbv.schoolVerifiedFlag = paramBoolean;
      break;
    }
    label18220:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramawbv.troopHonorSwitch = paramBoolean;
      return paramawbv;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,strNick TEXT ,shGender INTEGER ,shAge INTEGER ,nFaceID INTEGER ,strCertificationInfo TEXT ,shType INTEGER ,vContent BLOB ,strSign TEXT ,strCompany TEXT ,strSchool TEXT ,uFaceTimeStamp INTEGER ,vQQFaceID BLOB ,strReMark TEXT ,bWeiboInfo INTEGER ,bQzoneInfo INTEGER ,nSameFriendsNum INTEGER ,strCompanySame TEXT ,strSchoolSame TEXT ,lCardShowNum INTEGER ,bSingle INTEGER ,lVisitCount INTEGER ,lVoteCount INTEGER ,tagInfosByte BLOB ,eUserIdentityType INTEGER ,vBackground BLOB ,labelInfoBytes BLOB ,age INTEGER ,constellation INTEGER ,pyFaceUrl TEXT ,location TEXT ,bVoted INTEGER ,bFavorited INTEGER ,iVoteIncrement INTEGER ,strJoinHexAlbumFileKey TEXT ,iFaceNum INTEGER ,cSqqLevel INTEGER ,iQQLevel INTEGER ,uCurMulType INTEGER ,strProvince TEXT ,strCity TEXT ,strCountry TEXT ,lBirthday INTEGER ,strLocationCodes TEXT ,strLocationDesc TEXT ,strHometownCodes TEXT ,strHometownDesc TEXT ,strEmail TEXT ,strPersonalNote TEXT ,iProfession INTEGER ,bindPhoneInfo TEXT ,bCardInfo BLOB ,strTroopName TEXT ,strTroopNick TEXT ,strMobile TEXT ,strContactName TEXT ,ulShowControl INTEGER ,feedPreviewTime INTEGER ,strQzoneFeedsDesc TEXT ,StrPresentDesc TEXT ,strSpaceName TEXT ,strQzoneHeader TEXT ,vQzonePhotos BLOB ,vQzoneCoverInfo BLOB ,enlargeQzonePic INTEGER ,showPublishButton INTEGER ,strStatus TEXT ,strAutoRemark TEXT ,vSeed BLOB ,vCookies BLOB ,hasFakeData INTEGER ,bQQVipOpen INTEGER ,iQQVipType INTEGER ,iQQVipLevel INTEGER ,nameplateVipType INTEGER ,grayNameplateFlag INTEGER ,bSuperVipOpen INTEGER ,iSuperVipType INTEGER ,iSuperVipLevel INTEGER ,bSuperQQOpen INTEGER ,iSuperQQType INTEGER ,iSuperQQLevel INTEGER ,bHollywoodVipOpen INTEGER ,iHollywoodVipType INTEGER ,iHollywoodVipLevel INTEGER ,strShowName TEXT ,strVoiceFilekey TEXT ,shDuration INTEGER ,bRead INTEGER ,strUrl TEXT ,vRichSign BLOB ,lSignModifyTime INTEGER ,vLongNickTopicInfo BLOB ,nLastGameFlag INTEGER ,strGameLogoUrl_1 TEXT ,strGameLogoUrl_2 TEXT ,strGameLogoUrl_3 TEXT ,strGameLogoUrl_4 TEXT ,strGameLogoKey_1 TEXT ,strGameLogoKey_2 TEXT ,strGameLogoKey_3 TEXT ,strGameLogoKey_4 TEXT ,strGameName_1 TEXT ,strGameName_2 TEXT ,strGameName_3 TEXT ,strGameName_4 TEXT ,strGameAppid_1 TEXT ,strGameAppid_2 TEXT ,strGameAppid_3 TEXT ,strGameAppid_4 TEXT ,strProfileUrl TEXT ,nStarFansFlag INTEGER ,strStarPicUrl_0 TEXT ,strStarPicUrl_1 TEXT ,strStarPicUrl_2 TEXT ,strStarLvUrl_0 TEXT ,strStarLvUrl_1 TEXT ,strStarLvUrl_2 TEXT ,strStarLogoUrl TEXT ,starFansJumpUrl TEXT ,lUserFlag INTEGER ,lLoginDays INTEGER ,strLoginDaysDesc TEXT ,lQQMasterLogindays INTEGER ,iXManScene1DelayTime INTEGER ,iXManScene2DelayTime INTEGER ,allowPeopleSee INTEGER ,allowCalInteractive INTEGER ,showOnlineFriends INTEGER ,allowClick INTEGER ,babyQSwitch INTEGER ,showLightalk INTEGER ,lightalkNick TEXT ,lightalkId TEXT ,isSuperRedDiamond INTEGER ,isRedDiamond INTEGER ,redLevel INTEGER ,isSuperYellowDiamond INTEGER ,isYellowDiamond INTEGER ,yellowLevel INTEGER ,isSuperGreenDiamond INTEGER ,isGreenDiamond INTEGER ,greenLevel INTEGER ,uAccelerateMultiple INTEGER ,strRespMusicInfo TEXT ,templateRet INTEGER ,lCurrentStyleId INTEGER ,lCurrentBgId INTEGER ,backgroundUrl TEXT ,backgroundColor INTEGER ,dynamicCardFlag INTEGER ,strZipUrl TEXT ,strActiveUrl TEXT ,strDrawerCardUrl TEXT ,strWzryHeroUrl TEXT ,wzryHonorInfo BLOB ,strExtInfo TEXT ,strCurrentBgUrl TEXT ,bgType BLOB ,encId TEXT ,busiEntry TEXT ,favoriteSource INTEGER ,visibleMusicPendant INTEGER ,autoPlayMusicPendant INTEGER ,showRedPointMusicPendant INTEGER ,privilegePromptStr TEXT ,privilegeJumpUrl TEXT ,vOpenPriv BLOB ,vClosePriv BLOB ,presentDesc TEXT ,presentCustourl TEXT ,presentSwitch INTEGER ,showPresent INTEGER ,showMusicBox INTEGER ,addSrcName TEXT ,addSrcId INTEGER ,addSubSrcId INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,olympicTorch INTEGER ,mNowShowFlag INTEGER ,mNowShowIconUrl TEXT ,mNowShowJumpUrl TEXT ,vCoverInfo BLOB ,videoHeadFlag INTEGER ,videoHeadUrl TEXT ,medalSwitchDisable INTEGER ,iMedalCount INTEGER ,iNewCount INTEGER ,iUpgradeCount INTEGER ,strPromptParams TEXT ,hobbyEntry TEXT ,lastPraiseInfoList BLOB ,tempChatSig BLOB ,namePlateOfKingGameId INTEGER ,namePlateOfKingLoginTime INTEGER ,namePlateOfKingDan INTEGER ,namePlateOfKingDanDisplatSwitch INTEGER ,vPersonalityLabelV2 BLOB ,cardType INTEGER ,diyText TEXT ,diyTextFontId INTEGER ,diyTextWidth REAL ,diyTextHeight REAL ,diyTextLocX REAL ,diyTextLocY REAL ,diyTextDegree REAL ,diyTextScale REAL ,diyTextTransparency REAL ,diyDefaultText TEXT ,popularity INTEGER ,declaration TEXT ,voiceUrl TEXT ,isShowCard INTEGER ,updateTime INTEGER ,extendFriendFlag INTEGER ,extendFriendVoiceDuration INTEGER ,extendFriendEntryContact INTEGER ,extendFriendEntryAddFriend INTEGER ,extendFriendQuestion INTEGER ,fontId INTEGER ,fontType INTEGER ,clothesId INTEGER ,schoolId TEXT ,schoolName TEXT ,authState INTEGER ,idx INTEGER ,category INTEGER ,isShowMiniPlaying INTEGER ,tabJumpUrl TEXT ,guestJumpUrl TEXT ,guestAppTotal INTEGER ,defaultCardId INTEGER ,strangerVoteOpen INTEGER ,lSuperVipTemplateId INTEGER ,bBigClubVipOpen INTEGER ,iBigClubVipType INTEGER ,iBigClubVipLevel INTEGER ,lBigClubTemplateId INTEGER ,diyComplicatedInfo TEXT ,cardId INTEGER ,strangerInviteMeGroupOpen INTEGER ,isPrettyGroupOwner INTEGER ,isHidePrettyGroutIdentity INTEGER ,mQQLevelType INTEGER ,schoolVerifiedFlag INTEGER ,troopHonorSwitch INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (Card)paramawbv;
    paramContentValues.put("uin", paramawbv.uin);
    paramContentValues.put("strNick", paramawbv.strNick);
    paramContentValues.put("shGender", Short.valueOf(paramawbv.shGender));
    paramContentValues.put("shAge", Short.valueOf(paramawbv.shAge));
    paramContentValues.put("nFaceID", Integer.valueOf(paramawbv.nFaceID));
    paramContentValues.put("strCertificationInfo", paramawbv.strCertificationInfo);
    paramContentValues.put("shType", Short.valueOf(paramawbv.shType));
    paramContentValues.put("vContent", paramawbv.vContent);
    paramContentValues.put("strSign", paramawbv.strSign);
    paramContentValues.put("strCompany", paramawbv.strCompany);
    paramContentValues.put("strSchool", paramawbv.strSchool);
    paramContentValues.put("uFaceTimeStamp", Integer.valueOf(paramawbv.uFaceTimeStamp));
    paramContentValues.put("vQQFaceID", paramawbv.vQQFaceID);
    paramContentValues.put("strReMark", paramawbv.strReMark);
    paramContentValues.put("bWeiboInfo", Byte.valueOf(paramawbv.bWeiboInfo));
    paramContentValues.put("bQzoneInfo", Byte.valueOf(paramawbv.bQzoneInfo));
    paramContentValues.put("nSameFriendsNum", Integer.valueOf(paramawbv.nSameFriendsNum));
    paramContentValues.put("strCompanySame", paramawbv.strCompanySame);
    paramContentValues.put("strSchoolSame", paramawbv.strSchoolSame);
    paramContentValues.put("lCardShowNum", Long.valueOf(paramawbv.lCardShowNum));
    paramContentValues.put("bSingle", Byte.valueOf(paramawbv.bSingle));
    paramContentValues.put("lVisitCount", Long.valueOf(paramawbv.lVisitCount));
    paramContentValues.put("lVoteCount", Long.valueOf(paramawbv.lVoteCount));
    paramContentValues.put("tagInfosByte", paramawbv.tagInfosByte);
    paramContentValues.put("eUserIdentityType", Byte.valueOf(paramawbv.eUserIdentityType));
    paramContentValues.put("vBackground", paramawbv.vBackground);
    paramContentValues.put("labelInfoBytes", paramawbv.labelInfoBytes);
    paramContentValues.put("age", Byte.valueOf(paramawbv.age));
    paramContentValues.put("constellation", Integer.valueOf(paramawbv.constellation));
    paramContentValues.put("pyFaceUrl", paramawbv.pyFaceUrl);
    paramContentValues.put("location", paramawbv.location);
    paramContentValues.put("bVoted", Byte.valueOf(paramawbv.bVoted));
    paramContentValues.put("bFavorited", Byte.valueOf(paramawbv.bFavorited));
    paramContentValues.put("iVoteIncrement", Integer.valueOf(paramawbv.iVoteIncrement));
    paramContentValues.put("strJoinHexAlbumFileKey", paramawbv.strJoinHexAlbumFileKey);
    paramContentValues.put("iFaceNum", Integer.valueOf(paramawbv.iFaceNum));
    paramContentValues.put("cSqqLevel", Byte.valueOf(paramawbv.cSqqLevel));
    paramContentValues.put("iQQLevel", Integer.valueOf(paramawbv.iQQLevel));
    paramContentValues.put("uCurMulType", Long.valueOf(paramawbv.uCurMulType));
    paramContentValues.put("strProvince", paramawbv.strProvince);
    paramContentValues.put("strCity", paramawbv.strCity);
    paramContentValues.put("strCountry", paramawbv.strCountry);
    paramContentValues.put("lBirthday", Long.valueOf(paramawbv.lBirthday));
    paramContentValues.put("strLocationCodes", paramawbv.strLocationCodes);
    paramContentValues.put("strLocationDesc", paramawbv.strLocationDesc);
    paramContentValues.put("strHometownCodes", paramawbv.strHometownCodes);
    paramContentValues.put("strHometownDesc", paramawbv.strHometownDesc);
    paramContentValues.put("strEmail", paramawbv.strEmail);
    paramContentValues.put("strPersonalNote", paramawbv.strPersonalNote);
    paramContentValues.put("iProfession", Integer.valueOf(paramawbv.iProfession));
    paramContentValues.put("bindPhoneInfo", paramawbv.bindPhoneInfo);
    paramContentValues.put("bCardInfo", paramawbv.bCardInfo);
    paramContentValues.put("strTroopName", paramawbv.strTroopName);
    paramContentValues.put("strTroopNick", paramawbv.strTroopNick);
    paramContentValues.put("strMobile", paramawbv.strMobile);
    paramContentValues.put("strContactName", paramawbv.strContactName);
    paramContentValues.put("ulShowControl", Integer.valueOf(paramawbv.ulShowControl));
    paramContentValues.put("feedPreviewTime", Long.valueOf(paramawbv.feedPreviewTime));
    paramContentValues.put("strQzoneFeedsDesc", paramawbv.strQzoneFeedsDesc);
    paramContentValues.put("StrPresentDesc", paramawbv.StrPresentDesc);
    paramContentValues.put("strSpaceName", paramawbv.strSpaceName);
    paramContentValues.put("strQzoneHeader", paramawbv.strQzoneHeader);
    paramContentValues.put("vQzonePhotos", paramawbv.vQzonePhotos);
    paramContentValues.put("vQzoneCoverInfo", paramawbv.vQzoneCoverInfo);
    paramContentValues.put("enlargeQzonePic", Integer.valueOf(paramawbv.enlargeQzonePic));
    paramContentValues.put("showPublishButton", Boolean.valueOf(paramawbv.showPublishButton));
    paramContentValues.put("strStatus", paramawbv.strStatus);
    paramContentValues.put("strAutoRemark", paramawbv.strAutoRemark);
    paramContentValues.put("vSeed", paramawbv.vSeed);
    paramContentValues.put("vCookies", paramawbv.vCookies);
    paramContentValues.put("hasFakeData", Boolean.valueOf(paramawbv.hasFakeData));
    paramContentValues.put("bQQVipOpen", Byte.valueOf(paramawbv.bQQVipOpen));
    paramContentValues.put("iQQVipType", Integer.valueOf(paramawbv.iQQVipType));
    paramContentValues.put("iQQVipLevel", Integer.valueOf(paramawbv.iQQVipLevel));
    paramContentValues.put("nameplateVipType", Integer.valueOf(paramawbv.nameplateVipType));
    paramContentValues.put("grayNameplateFlag", Integer.valueOf(paramawbv.grayNameplateFlag));
    paramContentValues.put("bSuperVipOpen", Byte.valueOf(paramawbv.bSuperVipOpen));
    paramContentValues.put("iSuperVipType", Integer.valueOf(paramawbv.iSuperVipType));
    paramContentValues.put("iSuperVipLevel", Integer.valueOf(paramawbv.iSuperVipLevel));
    paramContentValues.put("bSuperQQOpen", Byte.valueOf(paramawbv.bSuperQQOpen));
    paramContentValues.put("iSuperQQType", Integer.valueOf(paramawbv.iSuperQQType));
    paramContentValues.put("iSuperQQLevel", Integer.valueOf(paramawbv.iSuperQQLevel));
    paramContentValues.put("bHollywoodVipOpen", Byte.valueOf(paramawbv.bHollywoodVipOpen));
    paramContentValues.put("iHollywoodVipType", Integer.valueOf(paramawbv.iHollywoodVipType));
    paramContentValues.put("iHollywoodVipLevel", Integer.valueOf(paramawbv.iHollywoodVipLevel));
    paramContentValues.put("strShowName", paramawbv.strShowName);
    paramContentValues.put("strVoiceFilekey", paramawbv.strVoiceFilekey);
    paramContentValues.put("shDuration", Short.valueOf(paramawbv.shDuration));
    paramContentValues.put("bRead", Byte.valueOf(paramawbv.bRead));
    paramContentValues.put("strUrl", paramawbv.strUrl);
    paramContentValues.put("vRichSign", paramawbv.vRichSign);
    paramContentValues.put("lSignModifyTime", Long.valueOf(paramawbv.lSignModifyTime));
    paramContentValues.put("vLongNickTopicInfo", paramawbv.vLongNickTopicInfo);
    paramContentValues.put("nLastGameFlag", Integer.valueOf(paramawbv.nLastGameFlag));
    paramContentValues.put("strGameLogoUrl_1", paramawbv.strGameLogoUrl_1);
    paramContentValues.put("strGameLogoUrl_2", paramawbv.strGameLogoUrl_2);
    paramContentValues.put("strGameLogoUrl_3", paramawbv.strGameLogoUrl_3);
    paramContentValues.put("strGameLogoUrl_4", paramawbv.strGameLogoUrl_4);
    paramContentValues.put("strGameLogoKey_1", paramawbv.strGameLogoKey_1);
    paramContentValues.put("strGameLogoKey_2", paramawbv.strGameLogoKey_2);
    paramContentValues.put("strGameLogoKey_3", paramawbv.strGameLogoKey_3);
    paramContentValues.put("strGameLogoKey_4", paramawbv.strGameLogoKey_4);
    paramContentValues.put("strGameName_1", paramawbv.strGameName_1);
    paramContentValues.put("strGameName_2", paramawbv.strGameName_2);
    paramContentValues.put("strGameName_3", paramawbv.strGameName_3);
    paramContentValues.put("strGameName_4", paramawbv.strGameName_4);
    paramContentValues.put("strGameAppid_1", paramawbv.strGameAppid_1);
    paramContentValues.put("strGameAppid_2", paramawbv.strGameAppid_2);
    paramContentValues.put("strGameAppid_3", paramawbv.strGameAppid_3);
    paramContentValues.put("strGameAppid_4", paramawbv.strGameAppid_4);
    paramContentValues.put("strProfileUrl", paramawbv.strProfileUrl);
    paramContentValues.put("nStarFansFlag", Integer.valueOf(paramawbv.nStarFansFlag));
    paramContentValues.put("strStarPicUrl_0", paramawbv.strStarPicUrl_0);
    paramContentValues.put("strStarPicUrl_1", paramawbv.strStarPicUrl_1);
    paramContentValues.put("strStarPicUrl_2", paramawbv.strStarPicUrl_2);
    paramContentValues.put("strStarLvUrl_0", paramawbv.strStarLvUrl_0);
    paramContentValues.put("strStarLvUrl_1", paramawbv.strStarLvUrl_1);
    paramContentValues.put("strStarLvUrl_2", paramawbv.strStarLvUrl_2);
    paramContentValues.put("strStarLogoUrl", paramawbv.strStarLogoUrl);
    paramContentValues.put("starFansJumpUrl", paramawbv.starFansJumpUrl);
    paramContentValues.put("lUserFlag", Long.valueOf(paramawbv.lUserFlag));
    paramContentValues.put("lLoginDays", Long.valueOf(paramawbv.lLoginDays));
    paramContentValues.put("strLoginDaysDesc", paramawbv.strLoginDaysDesc);
    paramContentValues.put("lQQMasterLogindays", Long.valueOf(paramawbv.lQQMasterLogindays));
    paramContentValues.put("iXManScene1DelayTime", Integer.valueOf(paramawbv.iXManScene1DelayTime));
    paramContentValues.put("iXManScene2DelayTime", Integer.valueOf(paramawbv.iXManScene2DelayTime));
    paramContentValues.put("allowPeopleSee", Boolean.valueOf(paramawbv.allowPeopleSee));
    paramContentValues.put("allowCalInteractive", Boolean.valueOf(paramawbv.allowCalInteractive));
    paramContentValues.put("showOnlineFriends", Boolean.valueOf(paramawbv.showOnlineFriends));
    paramContentValues.put("allowClick", Boolean.valueOf(paramawbv.allowClick));
    paramContentValues.put("babyQSwitch", Boolean.valueOf(paramawbv.babyQSwitch));
    paramContentValues.put("showLightalk", Boolean.valueOf(paramawbv.showLightalk));
    paramContentValues.put("lightalkNick", paramawbv.lightalkNick);
    paramContentValues.put("lightalkId", paramawbv.lightalkId);
    paramContentValues.put("isSuperRedDiamond", Boolean.valueOf(paramawbv.isSuperRedDiamond));
    paramContentValues.put("isRedDiamond", Boolean.valueOf(paramawbv.isRedDiamond));
    paramContentValues.put("redLevel", Integer.valueOf(paramawbv.redLevel));
    paramContentValues.put("isSuperYellowDiamond", Boolean.valueOf(paramawbv.isSuperYellowDiamond));
    paramContentValues.put("isYellowDiamond", Boolean.valueOf(paramawbv.isYellowDiamond));
    paramContentValues.put("yellowLevel", Integer.valueOf(paramawbv.yellowLevel));
    paramContentValues.put("isSuperGreenDiamond", Boolean.valueOf(paramawbv.isSuperGreenDiamond));
    paramContentValues.put("isGreenDiamond", Boolean.valueOf(paramawbv.isGreenDiamond));
    paramContentValues.put("greenLevel", Integer.valueOf(paramawbv.greenLevel));
    paramContentValues.put("uAccelerateMultiple", Long.valueOf(paramawbv.uAccelerateMultiple));
    paramContentValues.put("strRespMusicInfo", paramawbv.strRespMusicInfo);
    paramContentValues.put("templateRet", Integer.valueOf(paramawbv.templateRet));
    paramContentValues.put("lCurrentStyleId", Long.valueOf(paramawbv.lCurrentStyleId));
    paramContentValues.put("lCurrentBgId", Long.valueOf(paramawbv.lCurrentBgId));
    paramContentValues.put("backgroundUrl", paramawbv.backgroundUrl);
    paramContentValues.put("backgroundColor", Long.valueOf(paramawbv.backgroundColor));
    paramContentValues.put("dynamicCardFlag", Integer.valueOf(paramawbv.dynamicCardFlag));
    paramContentValues.put("strZipUrl", paramawbv.strZipUrl);
    paramContentValues.put("strActiveUrl", paramawbv.strActiveUrl);
    paramContentValues.put("strDrawerCardUrl", paramawbv.strDrawerCardUrl);
    paramContentValues.put("strWzryHeroUrl", paramawbv.strWzryHeroUrl);
    paramContentValues.put("wzryHonorInfo", paramawbv.wzryHonorInfo);
    paramContentValues.put("strExtInfo", paramawbv.strExtInfo);
    paramContentValues.put("strCurrentBgUrl", paramawbv.strCurrentBgUrl);
    paramContentValues.put("bgType", paramawbv.bgType);
    paramContentValues.put("encId", paramawbv.encId);
    paramContentValues.put("busiEntry", paramawbv.busiEntry);
    paramContentValues.put("favoriteSource", Integer.valueOf(paramawbv.favoriteSource));
    paramContentValues.put("visibleMusicPendant", Boolean.valueOf(paramawbv.visibleMusicPendant));
    paramContentValues.put("autoPlayMusicPendant", Boolean.valueOf(paramawbv.autoPlayMusicPendant));
    paramContentValues.put("showRedPointMusicPendant", Boolean.valueOf(paramawbv.showRedPointMusicPendant));
    paramContentValues.put("privilegePromptStr", paramawbv.privilegePromptStr);
    paramContentValues.put("privilegeJumpUrl", paramawbv.privilegeJumpUrl);
    paramContentValues.put("vOpenPriv", paramawbv.vOpenPriv);
    paramContentValues.put("vClosePriv", paramawbv.vClosePriv);
    paramContentValues.put("presentDesc", paramawbv.presentDesc);
    paramContentValues.put("presentCustourl", paramawbv.presentCustourl);
    paramContentValues.put("presentSwitch", Boolean.valueOf(paramawbv.presentSwitch));
    paramContentValues.put("showPresent", Boolean.valueOf(paramawbv.showPresent));
    paramContentValues.put("showMusicBox", Boolean.valueOf(paramawbv.showMusicBox));
    paramContentValues.put("addSrcName", paramawbv.addSrcName);
    paramContentValues.put("addSrcId", Long.valueOf(paramawbv.addSrcId));
    paramContentValues.put("addSubSrcId", Long.valueOf(paramawbv.addSubSrcId));
    paramContentValues.put("strVoteLimitedNotice", paramawbv.strVoteLimitedNotice);
    paramContentValues.put("bHaveVotedCnt", Short.valueOf(paramawbv.bHaveVotedCnt));
    paramContentValues.put("bAvailVoteCnt", Short.valueOf(paramawbv.bAvailVoteCnt));
    paramContentValues.put("olympicTorch", Byte.valueOf(paramawbv.olympicTorch));
    paramContentValues.put("mNowShowFlag", Integer.valueOf(paramawbv.mNowShowFlag));
    paramContentValues.put("mNowShowIconUrl", paramawbv.mNowShowIconUrl);
    paramContentValues.put("mNowShowJumpUrl", paramawbv.mNowShowJumpUrl);
    paramContentValues.put("vCoverInfo", paramawbv.vCoverInfo);
    paramContentValues.put("videoHeadFlag", Boolean.valueOf(paramawbv.videoHeadFlag));
    paramContentValues.put("videoHeadUrl", paramawbv.videoHeadUrl);
    paramContentValues.put("medalSwitchDisable", Boolean.valueOf(paramawbv.medalSwitchDisable));
    paramContentValues.put("iMedalCount", Integer.valueOf(paramawbv.iMedalCount));
    paramContentValues.put("iNewCount", Integer.valueOf(paramawbv.iNewCount));
    paramContentValues.put("iUpgradeCount", Integer.valueOf(paramawbv.iUpgradeCount));
    paramContentValues.put("strPromptParams", paramawbv.strPromptParams);
    paramContentValues.put("hobbyEntry", paramawbv.hobbyEntry);
    paramContentValues.put("lastPraiseInfoList", paramawbv.lastPraiseInfoList);
    paramContentValues.put("tempChatSig", paramawbv.tempChatSig);
    paramContentValues.put("namePlateOfKingGameId", Long.valueOf(paramawbv.namePlateOfKingGameId));
    paramContentValues.put("namePlateOfKingLoginTime", Long.valueOf(paramawbv.namePlateOfKingLoginTime));
    paramContentValues.put("namePlateOfKingDan", Integer.valueOf(paramawbv.namePlateOfKingDan));
    paramContentValues.put("namePlateOfKingDanDisplatSwitch", Boolean.valueOf(paramawbv.namePlateOfKingDanDisplatSwitch));
    paramContentValues.put("vPersonalityLabelV2", paramawbv.vPersonalityLabelV2);
    paramContentValues.put("cardType", Integer.valueOf(paramawbv.cardType));
    paramContentValues.put("diyText", paramawbv.diyText);
    paramContentValues.put("diyTextFontId", Integer.valueOf(paramawbv.diyTextFontId));
    paramContentValues.put("diyTextWidth", Float.valueOf(paramawbv.diyTextWidth));
    paramContentValues.put("diyTextHeight", Float.valueOf(paramawbv.diyTextHeight));
    paramContentValues.put("diyTextLocX", Float.valueOf(paramawbv.diyTextLocX));
    paramContentValues.put("diyTextLocY", Float.valueOf(paramawbv.diyTextLocY));
    paramContentValues.put("diyTextDegree", Float.valueOf(paramawbv.diyTextDegree));
    paramContentValues.put("diyTextScale", Float.valueOf(paramawbv.diyTextScale));
    paramContentValues.put("diyTextTransparency", Float.valueOf(paramawbv.diyTextTransparency));
    paramContentValues.put("diyDefaultText", paramawbv.diyDefaultText);
    paramContentValues.put("popularity", Integer.valueOf(paramawbv.popularity));
    paramContentValues.put("declaration", paramawbv.declaration);
    paramContentValues.put("voiceUrl", paramawbv.voiceUrl);
    paramContentValues.put("isShowCard", Boolean.valueOf(paramawbv.isShowCard));
    paramContentValues.put("updateTime", Long.valueOf(paramawbv.updateTime));
    paramContentValues.put("extendFriendFlag", Integer.valueOf(paramawbv.extendFriendFlag));
    paramContentValues.put("extendFriendVoiceDuration", Integer.valueOf(paramawbv.extendFriendVoiceDuration));
    paramContentValues.put("extendFriendEntryContact", Short.valueOf(paramawbv.extendFriendEntryContact));
    paramContentValues.put("extendFriendEntryAddFriend", Short.valueOf(paramawbv.extendFriendEntryAddFriend));
    paramContentValues.put("extendFriendQuestion", Short.valueOf(paramawbv.extendFriendQuestion));
    paramContentValues.put("fontId", Integer.valueOf(paramawbv.fontId));
    paramContentValues.put("fontType", Integer.valueOf(paramawbv.fontType));
    paramContentValues.put("clothesId", Integer.valueOf(paramawbv.clothesId));
    paramContentValues.put("schoolId", paramawbv.schoolId);
    paramContentValues.put("schoolName", paramawbv.schoolName);
    paramContentValues.put("authState", Long.valueOf(paramawbv.authState));
    paramContentValues.put("idx", Integer.valueOf(paramawbv.idx));
    paramContentValues.put("category", Integer.valueOf(paramawbv.category));
    paramContentValues.put("isShowMiniPlaying", Boolean.valueOf(paramawbv.isShowMiniPlaying));
    paramContentValues.put("tabJumpUrl", paramawbv.tabJumpUrl);
    paramContentValues.put("guestJumpUrl", paramawbv.guestJumpUrl);
    paramContentValues.put("guestAppTotal", Integer.valueOf(paramawbv.guestAppTotal));
    paramContentValues.put("defaultCardId", Integer.valueOf(paramawbv.defaultCardId));
    paramContentValues.put("strangerVoteOpen", Boolean.valueOf(paramawbv.strangerVoteOpen));
    paramContentValues.put("lSuperVipTemplateId", Long.valueOf(paramawbv.lSuperVipTemplateId));
    paramContentValues.put("bBigClubVipOpen", Byte.valueOf(paramawbv.bBigClubVipOpen));
    paramContentValues.put("iBigClubVipType", Integer.valueOf(paramawbv.iBigClubVipType));
    paramContentValues.put("iBigClubVipLevel", Integer.valueOf(paramawbv.iBigClubVipLevel));
    paramContentValues.put("lBigClubTemplateId", Long.valueOf(paramawbv.lBigClubTemplateId));
    paramContentValues.put("diyComplicatedInfo", paramawbv.diyComplicatedInfo);
    paramContentValues.put("cardId", Long.valueOf(paramawbv.cardId));
    paramContentValues.put("strangerInviteMeGroupOpen", Boolean.valueOf(paramawbv.strangerInviteMeGroupOpen));
    paramContentValues.put("isPrettyGroupOwner", Boolean.valueOf(paramawbv.isPrettyGroupOwner));
    paramContentValues.put("isHidePrettyGroutIdentity", Boolean.valueOf(paramawbv.isHidePrettyGroutIdentity));
    paramContentValues.put("mQQLevelType", Integer.valueOf(paramawbv.mQQLevelType));
    paramContentValues.put("schoolVerifiedFlag", Boolean.valueOf(paramawbv.schoolVerifiedFlag));
    paramContentValues.put("troopHonorSwitch", Boolean.valueOf(paramawbv.troopHonorSwitch));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awbk
 * JD-Core Version:    0.7.0.1
 */