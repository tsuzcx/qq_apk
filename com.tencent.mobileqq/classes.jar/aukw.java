import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukw
  extends auky
{
  public aukw()
  {
    this.a = 111;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramaukm = (NearbyPeopleCard)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.tinyId = paramCursor.getLong(paramCursor.getColumnIndex("tinyId"));
      paramaukm.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramaukm.nowId = paramCursor.getLong(paramCursor.getColumnIndex("nowId"));
      paramaukm.nowUserType = paramCursor.getInt(paramCursor.getColumnIndex("nowUserType"));
      paramaukm.strRemark = paramCursor.getString(paramCursor.getColumnIndex("strRemark"));
      paramaukm.nickname = paramCursor.getString(paramCursor.getColumnIndex("nickname"));
      paramaukm.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
      paramaukm.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
      paramaukm.birthday = paramCursor.getInt(paramCursor.getColumnIndex("birthday"));
      paramaukm.constellation = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("constellation")));
      paramaukm.distance = paramCursor.getString(paramCursor.getColumnIndex("distance"));
      paramaukm.timeDiff = paramCursor.getString(paramCursor.getColumnIndex("timeDiff"));
      paramaukm.aioDistanceAndTime = paramCursor.getString(paramCursor.getColumnIndex("aioDistanceAndTime"));
      paramaukm.likeCount = paramCursor.getInt(paramCursor.getColumnIndex("likeCount"));
      paramaukm.likeCountInc = paramCursor.getInt(paramCursor.getColumnIndex("likeCountInc"));
      paramaukm.oldPhotoCount = paramCursor.getInt(paramCursor.getColumnIndex("oldPhotoCount"));
      paramaukm.dateInfo = paramCursor.getBlob(paramCursor.getColumnIndex("dateInfo"));
      paramaukm.ulShowControl = paramCursor.getLong(paramCursor.getColumnIndex("ulShowControl"));
      paramaukm.xuanYan = paramCursor.getBlob(paramCursor.getColumnIndex("xuanYan"));
      paramaukm.maritalStatus = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("maritalStatus")));
      paramaukm.job = paramCursor.getInt(paramCursor.getColumnIndex("job"));
      paramaukm.company = paramCursor.getString(paramCursor.getColumnIndex("company"));
      paramaukm.college = paramCursor.getString(paramCursor.getColumnIndex("college"));
      paramaukm.hometownCountry = paramCursor.getString(paramCursor.getColumnIndex("hometownCountry"));
      paramaukm.hometownProvice = paramCursor.getString(paramCursor.getColumnIndex("hometownProvice"));
      paramaukm.hometownCity = paramCursor.getString(paramCursor.getColumnIndex("hometownCity"));
      paramaukm.hometownDistrict = paramCursor.getString(paramCursor.getColumnIndex("hometownDistrict"));
      paramaukm.vCookies = paramCursor.getBlob(paramCursor.getColumnIndex("vCookies"));
      paramaukm.bVoted = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bVoted")));
      paramaukm.feedPreviewTime = paramCursor.getLong(paramCursor.getColumnIndex("feedPreviewTime"));
      paramaukm.qzoneFeed = paramCursor.getString(paramCursor.getColumnIndex("qzoneFeed"));
      paramaukm.qzoneName = paramCursor.getString(paramCursor.getColumnIndex("qzoneName"));
      paramaukm.qzonePicUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_1"));
      paramaukm.qzonePicUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_2"));
      paramaukm.qzonePicUrl_3 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_3"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isPhotoUseCache")))
      {
        paramBoolean = true;
        paramaukm.isPhotoUseCache = paramBoolean;
        paramaukm.vSeed = paramCursor.getBlob(paramCursor.getColumnIndex("vSeed"));
        paramaukm.vTempChatSig = paramCursor.getBlob(paramCursor.getColumnIndex("vTempChatSig"));
        paramaukm.vGroupList = paramCursor.getBlob(paramCursor.getColumnIndex("vGroupList"));
        paramaukm.nearbyInfo = paramCursor.getBlob(paramCursor.getColumnIndex("nearbyInfo"));
        paramaukm.vActivityList = paramCursor.getBlob(paramCursor.getColumnIndex("vActivityList"));
        paramaukm.lUserFlag = paramCursor.getLong(paramCursor.getColumnIndex("lUserFlag"));
        paramaukm.iIsGodFlag = paramCursor.getInt(paramCursor.getColumnIndex("iIsGodFlag"));
        paramaukm.strGodJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("strGodJumpUrl"));
        paramaukm.mHeartNum = paramCursor.getInt(paramCursor.getColumnIndex("mHeartNum"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("switchQzone"))) {
          break label2162;
        }
        paramBoolean = true;
        label857:
        paramaukm.switchQzone = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("switchHobby"))) {
          break label2167;
        }
        paramBoolean = true;
        label882:
        paramaukm.switchHobby = paramBoolean;
        paramaukm.uiShowControl = paramCursor.getLong(paramCursor.getColumnIndex("uiShowControl"));
        paramaukm.userFlag = paramCursor.getLong(paramCursor.getColumnIndex("userFlag"));
        paramaukm.busiEntry = paramCursor.getString(paramCursor.getColumnIndex("busiEntry"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("godFlag"))) {
          break label2172;
        }
        paramBoolean = true;
        label961:
        paramaukm.godFlag = paramBoolean;
        paramaukm.nLastGameFlag = paramCursor.getInt(paramCursor.getColumnIndex("nLastGameFlag"));
        paramaukm.strProfileUrl = paramCursor.getString(paramCursor.getColumnIndex("strProfileUrl"));
        paramaukm.lastUpdateNickTime = paramCursor.getLong(paramCursor.getColumnIndex("lastUpdateNickTime"));
        paramaukm.favoriteSource = paramCursor.getInt(paramCursor.getColumnIndex("favoriteSource"));
        paramaukm.switchGiftVisible = paramCursor.getLong(paramCursor.getColumnIndex("switchGiftVisible"));
        paramaukm.vGiftInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vGiftInfo"));
        paramaukm.sayHelloFlag = paramCursor.getInt(paramCursor.getColumnIndex("sayHelloFlag"));
        paramaukm.charm = paramCursor.getLong(paramCursor.getColumnIndex("charm"));
        paramaukm.charmLevel = paramCursor.getInt(paramCursor.getColumnIndex("charmLevel"));
        paramaukm.nextThreshold = paramCursor.getInt(paramCursor.getColumnIndex("nextThreshold"));
        paramaukm.curThreshold = paramCursor.getInt(paramCursor.getColumnIndex("curThreshold"));
        paramaukm.profPercent = paramCursor.getInt(paramCursor.getColumnIndex("profPercent"));
        paramaukm.taskFinished = paramCursor.getInt(paramCursor.getColumnIndex("taskFinished"));
        paramaukm.taskTotal = paramCursor.getInt(paramCursor.getColumnIndex("taskTotal"));
        paramaukm.hiWanInfo = paramCursor.getString(paramCursor.getColumnIndex("hiWanInfo"));
        paramaukm.commonLabelString = paramCursor.getString(paramCursor.getColumnIndex("commonLabelString"));
        paramaukm.tagFlag = paramCursor.getLong(paramCursor.getColumnIndex("tagFlag"));
        paramaukm.tagInfo = paramCursor.getString(paramCursor.getColumnIndex("tagInfo"));
        paramaukm.picInfo = paramCursor.getString(paramCursor.getColumnIndex("picInfo"));
        paramaukm.videoDetails = paramCursor.getString(paramCursor.getColumnIndex("videoDetails"));
        paramaukm.strFreshNewsInfo = paramCursor.getString(paramCursor.getColumnIndex("strFreshNewsInfo"));
        paramaukm.strHotChatInfo = paramCursor.getString(paramCursor.getColumnIndex("strHotChatInfo"));
        paramaukm.uRoomid = paramCursor.getLong(paramCursor.getColumnIndex("uRoomid"));
        paramaukm.strVoteLimitedNotice = paramCursor.getString(paramCursor.getColumnIndex("strVoteLimitedNotice"));
        paramaukm.bHaveVotedCnt = paramCursor.getShort(paramCursor.getColumnIndex("bHaveVotedCnt"));
        paramaukm.bAvailVoteCnt = paramCursor.getShort(paramCursor.getColumnIndex("bAvailVoteCnt"));
        paramaukm.collegeId = paramCursor.getLong(paramCursor.getColumnIndex("collegeId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("videoHeadFlag"))) {
          break label2177;
        }
        paramBoolean = true;
        label1499:
        paramaukm.videoHeadFlag = paramBoolean;
        paramaukm.bVideoHeadUrl = paramCursor.getString(paramCursor.getColumnIndex("bVideoHeadUrl"));
        paramaukm.faceScoreWordingColor = paramCursor.getInt(paramCursor.getColumnIndex("faceScoreWordingColor"));
        paramaukm.faceScoreWording = paramCursor.getString(paramCursor.getColumnIndex("faceScoreWording"));
        paramaukm.faceScoreTailWordingColor = paramCursor.getInt(paramCursor.getColumnIndex("faceScoreTailWordingColor"));
        paramaukm.faceScoreTailWording = paramCursor.getString(paramCursor.getColumnIndex("faceScoreTailWording"));
        paramaukm.faceScoreIconUrl = paramCursor.getString(paramCursor.getColumnIndex("faceScoreIconUrl"));
        paramaukm.entryAbility = paramCursor.getInt(paramCursor.getColumnIndex("entryAbility"));
        paramaukm.strLevelType = paramCursor.getString(paramCursor.getColumnIndex("strLevelType"));
        paramaukm.maskMsgFlag = paramCursor.getInt(paramCursor.getColumnIndex("maskMsgFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendMsg"))) {
          break label2182;
        }
        paramBoolean = true;
        label1696:
        paramaukm.isForbidSendMsg = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendGiftMsg"))) {
          break label2187;
        }
        paramBoolean = true;
        label1722:
        paramaukm.isForbidSendGiftMsg = paramBoolean;
        paramaukm.disableSendMsgBtnTips = paramCursor.getString(paramCursor.getColumnIndex("disableSendMsgBtnTips"));
        paramaukm.disableSendGiftBtnTips = paramCursor.getString(paramCursor.getColumnIndex("disableSendGiftBtnTips"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendMsgForTribar"))) {
          break label2192;
        }
        paramBoolean = true;
        label1786:
        paramaukm.isForbidSendMsgForTribar = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendGiftMsgForTribar"))) {
          break label2197;
        }
        paramBoolean = true;
        label1812:
        paramaukm.isForbidSendGiftMsgForTribar = paramBoolean;
        paramaukm.disableSendMsgBtnTipsForTribar = paramCursor.getString(paramCursor.getColumnIndex("disableSendMsgBtnTipsForTribar"));
        paramaukm.disableSendGiftBtnTipsForTribar = paramCursor.getString(paramCursor.getColumnIndex("disableSendGiftBtnTipsForTribar"));
        paramaukm.highScoreNum = paramCursor.getInt(paramCursor.getColumnIndex("highScoreNum"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mHasStory"))) {
          break label2202;
        }
        paramBoolean = true;
        label1895:
        paramaukm.mHasStory = paramBoolean;
        paramaukm.mQQStoryData = paramCursor.getBlob(paramCursor.getColumnIndex("mQQStoryData"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSendMsgBtnDownloadAppOpen"))) {
          break label2207;
        }
      }
      label2177:
      label2182:
      label2187:
      label2192:
      label2197:
      label2202:
      label2207:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramaukm.isSendMsgBtnDownloadAppOpen = paramBoolean;
        paramaukm.sendMsgBtnDownloadAppTips = paramCursor.getString(paramCursor.getColumnIndex("sendMsgBtnDownloadAppTips"));
        paramaukm.addPicBtnDownloadAppTips = paramCursor.getString(paramCursor.getColumnIndex("addPicBtnDownloadAppTips"));
        paramaukm.tribeAppDownloadPageUrl = paramCursor.getString(paramCursor.getColumnIndex("tribeAppDownloadPageUrl"));
        paramaukm.nearbyNowDataBytes = paramCursor.getBlob(paramCursor.getColumnIndex("nearbyNowDataBytes"));
        paramaukm.guideAppNowTip = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTip"));
        paramaukm.guideAppNowTipLeftBtn = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTipLeftBtn"));
        paramaukm.guideAppNowTipRightBtnInstalled = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTipRightBtnInstalled"));
        paramaukm.guideAppNowTipRightBtnNotInstalled = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTipRightBtnNotInstalled"));
        paramaukm.guideAppNowPackage = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowPackage"));
        paramaukm.guideAppNowJumpUri = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowJumpUri"));
        paramaukm.guideAppNowDownloadUrl = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowDownloadUrl"));
        return paramaukm;
        paramBoolean = false;
        break;
        label2162:
        paramBoolean = false;
        break label857;
        label2167:
        paramBoolean = false;
        break label882;
        label2172:
        paramBoolean = false;
        break label961;
        paramBoolean = false;
        break label1499;
        paramBoolean = false;
        break label1696;
        paramBoolean = false;
        break label1722;
        paramBoolean = false;
        break label1786;
        paramBoolean = false;
        break label1812;
        paramBoolean = false;
        break label1895;
      }
    }
    int i = paramCursor.getColumnIndex("tinyId");
    if (i == -1)
    {
      paramaukx.a(new NoColumnError("tinyId", Long.TYPE));
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label6232;
      }
      paramaukx.a(new NoColumnError("uin", String.class));
      label2282:
      i = paramCursor.getColumnIndex("nowId");
      if (i != -1) {
        break label6247;
      }
      paramaukx.a(new NoColumnError("nowId", Long.TYPE));
      label2317:
      i = paramCursor.getColumnIndex("nowUserType");
      if (i != -1) {
        break label6262;
      }
      paramaukx.a(new NoColumnError("nowUserType", Integer.TYPE));
      label2352:
      i = paramCursor.getColumnIndex("strRemark");
      if (i != -1) {
        break label6277;
      }
      paramaukx.a(new NoColumnError("strRemark", String.class));
      label2387:
      i = paramCursor.getColumnIndex("nickname");
      if (i != -1) {
        break label6292;
      }
      paramaukx.a(new NoColumnError("nickname", String.class));
      label2422:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label6307;
      }
      paramaukx.a(new NoColumnError("gender", Byte.TYPE));
      label2457:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label6323;
      }
      paramaukx.a(new NoColumnError("age", Integer.TYPE));
      label2492:
      i = paramCursor.getColumnIndex("birthday");
      if (i != -1) {
        break label6338;
      }
      paramaukx.a(new NoColumnError("birthday", Integer.TYPE));
      label2527:
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label6353;
      }
      paramaukx.a(new NoColumnError("constellation", Byte.TYPE));
      label2562:
      i = paramCursor.getColumnIndex("distance");
      if (i != -1) {
        break label6369;
      }
      paramaukx.a(new NoColumnError("distance", String.class));
      label2597:
      i = paramCursor.getColumnIndex("timeDiff");
      if (i != -1) {
        break label6384;
      }
      paramaukx.a(new NoColumnError("timeDiff", String.class));
      label2632:
      i = paramCursor.getColumnIndex("aioDistanceAndTime");
      if (i != -1) {
        break label6399;
      }
      paramaukx.a(new NoColumnError("aioDistanceAndTime", String.class));
      label2667:
      i = paramCursor.getColumnIndex("likeCount");
      if (i != -1) {
        break label6414;
      }
      paramaukx.a(new NoColumnError("likeCount", Integer.TYPE));
      label2702:
      i = paramCursor.getColumnIndex("likeCountInc");
      if (i != -1) {
        break label6429;
      }
      paramaukx.a(new NoColumnError("likeCountInc", Integer.TYPE));
      label2737:
      i = paramCursor.getColumnIndex("oldPhotoCount");
      if (i != -1) {
        break label6444;
      }
      paramaukx.a(new NoColumnError("oldPhotoCount", Integer.TYPE));
      label2772:
      i = paramCursor.getColumnIndex("dateInfo");
      if (i != -1) {
        break label6459;
      }
      paramaukx.a(new NoColumnError("dateInfo", [B.class));
      label2807:
      i = paramCursor.getColumnIndex("ulShowControl");
      if (i != -1) {
        break label6474;
      }
      paramaukx.a(new NoColumnError("ulShowControl", Long.TYPE));
      label2842:
      i = paramCursor.getColumnIndex("xuanYan");
      if (i != -1) {
        break label6489;
      }
      paramaukx.a(new NoColumnError("xuanYan", [B.class));
      label2877:
      i = paramCursor.getColumnIndex("maritalStatus");
      if (i != -1) {
        break label6504;
      }
      paramaukx.a(new NoColumnError("maritalStatus", Byte.TYPE));
      label2912:
      i = paramCursor.getColumnIndex("job");
      if (i != -1) {
        break label6520;
      }
      paramaukx.a(new NoColumnError("job", Integer.TYPE));
      label2947:
      i = paramCursor.getColumnIndex("company");
      if (i != -1) {
        break label6535;
      }
      paramaukx.a(new NoColumnError("company", String.class));
      label2982:
      i = paramCursor.getColumnIndex("college");
      if (i != -1) {
        break label6550;
      }
      paramaukx.a(new NoColumnError("college", String.class));
      label3017:
      i = paramCursor.getColumnIndex("hometownCountry");
      if (i != -1) {
        break label6565;
      }
      paramaukx.a(new NoColumnError("hometownCountry", String.class));
      label3052:
      i = paramCursor.getColumnIndex("hometownProvice");
      if (i != -1) {
        break label6580;
      }
      paramaukx.a(new NoColumnError("hometownProvice", String.class));
      label3087:
      i = paramCursor.getColumnIndex("hometownCity");
      if (i != -1) {
        break label6595;
      }
      paramaukx.a(new NoColumnError("hometownCity", String.class));
      label3122:
      i = paramCursor.getColumnIndex("hometownDistrict");
      if (i != -1) {
        break label6610;
      }
      paramaukx.a(new NoColumnError("hometownDistrict", String.class));
      label3157:
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label6625;
      }
      paramaukx.a(new NoColumnError("vCookies", [B.class));
      label3192:
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label6640;
      }
      paramaukx.a(new NoColumnError("bVoted", Byte.TYPE));
      label3227:
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label6656;
      }
      paramaukx.a(new NoColumnError("feedPreviewTime", Long.TYPE));
      label3262:
      i = paramCursor.getColumnIndex("qzoneFeed");
      if (i != -1) {
        break label6671;
      }
      paramaukx.a(new NoColumnError("qzoneFeed", String.class));
      label3297:
      i = paramCursor.getColumnIndex("qzoneName");
      if (i != -1) {
        break label6686;
      }
      paramaukx.a(new NoColumnError("qzoneName", String.class));
      label3332:
      i = paramCursor.getColumnIndex("qzonePicUrl_1");
      if (i != -1) {
        break label6701;
      }
      paramaukx.a(new NoColumnError("qzonePicUrl_1", String.class));
      label3367:
      i = paramCursor.getColumnIndex("qzonePicUrl_2");
      if (i != -1) {
        break label6716;
      }
      paramaukx.a(new NoColumnError("qzonePicUrl_2", String.class));
      label3402:
      i = paramCursor.getColumnIndex("qzonePicUrl_3");
      if (i != -1) {
        break label6731;
      }
      paramaukx.a(new NoColumnError("qzonePicUrl_3", String.class));
      label3437:
      i = paramCursor.getColumnIndex("isPhotoUseCache");
      if (i != -1) {
        break label6746;
      }
      paramaukx.a(new NoColumnError("isPhotoUseCache", Boolean.TYPE));
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label6773;
      }
      paramaukx.a(new NoColumnError("vSeed", [B.class));
      label3507:
      i = paramCursor.getColumnIndex("vTempChatSig");
      if (i != -1) {
        break label6788;
      }
      paramaukx.a(new NoColumnError("vTempChatSig", [B.class));
      label3542:
      i = paramCursor.getColumnIndex("vGroupList");
      if (i != -1) {
        break label6803;
      }
      paramaukx.a(new NoColumnError("vGroupList", [B.class));
      label3577:
      i = paramCursor.getColumnIndex("nearbyInfo");
      if (i != -1) {
        break label6818;
      }
      paramaukx.a(new NoColumnError("nearbyInfo", [B.class));
      label3612:
      i = paramCursor.getColumnIndex("vActivityList");
      if (i != -1) {
        break label6833;
      }
      paramaukx.a(new NoColumnError("vActivityList", [B.class));
      label3647:
      i = paramCursor.getColumnIndex("lUserFlag");
      if (i != -1) {
        break label6848;
      }
      paramaukx.a(new NoColumnError("lUserFlag", Long.TYPE));
      label3682:
      i = paramCursor.getColumnIndex("iIsGodFlag");
      if (i != -1) {
        break label6863;
      }
      paramaukx.a(new NoColumnError("iIsGodFlag", Integer.TYPE));
      label3717:
      i = paramCursor.getColumnIndex("strGodJumpUrl");
      if (i != -1) {
        break label6878;
      }
      paramaukx.a(new NoColumnError("strGodJumpUrl", String.class));
      label3752:
      i = paramCursor.getColumnIndex("mHeartNum");
      if (i != -1) {
        break label6893;
      }
      paramaukx.a(new NoColumnError("mHeartNum", Integer.TYPE));
      label3787:
      i = paramCursor.getColumnIndex("switchQzone");
      if (i != -1) {
        break label6908;
      }
      paramaukx.a(new NoColumnError("switchQzone", Boolean.TYPE));
      i = paramCursor.getColumnIndex("switchHobby");
      if (i != -1) {
        break label6935;
      }
      paramaukx.a(new NoColumnError("switchHobby", Boolean.TYPE));
      i = paramCursor.getColumnIndex("uiShowControl");
      if (i != -1) {
        break label6962;
      }
      paramaukx.a(new NoColumnError("uiShowControl", Long.TYPE));
      label3892:
      i = paramCursor.getColumnIndex("userFlag");
      if (i != -1) {
        break label6977;
      }
      paramaukx.a(new NoColumnError("userFlag", Long.TYPE));
      label3927:
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label6992;
      }
      paramaukx.a(new NoColumnError("busiEntry", String.class));
      label3962:
      i = paramCursor.getColumnIndex("godFlag");
      if (i != -1) {
        break label7007;
      }
      paramaukx.a(new NoColumnError("godFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("nLastGameFlag");
      if (i != -1) {
        break label7034;
      }
      paramaukx.a(new NoColumnError("nLastGameFlag", Integer.TYPE));
      label4032:
      i = paramCursor.getColumnIndex("strProfileUrl");
      if (i != -1) {
        break label7049;
      }
      paramaukx.a(new NoColumnError("strProfileUrl", String.class));
      label4069:
      i = paramCursor.getColumnIndex("lastUpdateNickTime");
      if (i != -1) {
        break label7064;
      }
      paramaukx.a(new NoColumnError("lastUpdateNickTime", Long.TYPE));
      label4106:
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label7079;
      }
      paramaukx.a(new NoColumnError("favoriteSource", Integer.TYPE));
      label4143:
      i = paramCursor.getColumnIndex("switchGiftVisible");
      if (i != -1) {
        break label7094;
      }
      paramaukx.a(new NoColumnError("switchGiftVisible", Long.TYPE));
      label4180:
      i = paramCursor.getColumnIndex("vGiftInfo");
      if (i != -1) {
        break label7109;
      }
      paramaukx.a(new NoColumnError("vGiftInfo", [B.class));
      label4217:
      i = paramCursor.getColumnIndex("sayHelloFlag");
      if (i != -1) {
        break label7124;
      }
      paramaukx.a(new NoColumnError("sayHelloFlag", Integer.TYPE));
      label4254:
      i = paramCursor.getColumnIndex("charm");
      if (i != -1) {
        break label7139;
      }
      paramaukx.a(new NoColumnError("charm", Long.TYPE));
      label4291:
      i = paramCursor.getColumnIndex("charmLevel");
      if (i != -1) {
        break label7154;
      }
      paramaukx.a(new NoColumnError("charmLevel", Integer.TYPE));
      label4328:
      i = paramCursor.getColumnIndex("nextThreshold");
      if (i != -1) {
        break label7169;
      }
      paramaukx.a(new NoColumnError("nextThreshold", Integer.TYPE));
      label4365:
      i = paramCursor.getColumnIndex("curThreshold");
      if (i != -1) {
        break label7184;
      }
      paramaukx.a(new NoColumnError("curThreshold", Integer.TYPE));
      label4402:
      i = paramCursor.getColumnIndex("profPercent");
      if (i != -1) {
        break label7199;
      }
      paramaukx.a(new NoColumnError("profPercent", Integer.TYPE));
      label4439:
      i = paramCursor.getColumnIndex("taskFinished");
      if (i != -1) {
        break label7214;
      }
      paramaukx.a(new NoColumnError("taskFinished", Integer.TYPE));
      label4476:
      i = paramCursor.getColumnIndex("taskTotal");
      if (i != -1) {
        break label7229;
      }
      paramaukx.a(new NoColumnError("taskTotal", Integer.TYPE));
      label4513:
      i = paramCursor.getColumnIndex("hiWanInfo");
      if (i != -1) {
        break label7244;
      }
      paramaukx.a(new NoColumnError("hiWanInfo", String.class));
      label4550:
      i = paramCursor.getColumnIndex("commonLabelString");
      if (i != -1) {
        break label7259;
      }
      paramaukx.a(new NoColumnError("commonLabelString", String.class));
      label4587:
      i = paramCursor.getColumnIndex("tagFlag");
      if (i != -1) {
        break label7274;
      }
      paramaukx.a(new NoColumnError("tagFlag", Long.TYPE));
      label4624:
      i = paramCursor.getColumnIndex("tagInfo");
      if (i != -1) {
        break label7289;
      }
      paramaukx.a(new NoColumnError("tagInfo", String.class));
      label4661:
      i = paramCursor.getColumnIndex("picInfo");
      if (i != -1) {
        break label7304;
      }
      paramaukx.a(new NoColumnError("picInfo", String.class));
      label4698:
      i = paramCursor.getColumnIndex("videoDetails");
      if (i != -1) {
        break label7319;
      }
      paramaukx.a(new NoColumnError("videoDetails", String.class));
      label4735:
      i = paramCursor.getColumnIndex("strFreshNewsInfo");
      if (i != -1) {
        break label7334;
      }
      paramaukx.a(new NoColumnError("strFreshNewsInfo", String.class));
      label4772:
      i = paramCursor.getColumnIndex("strHotChatInfo");
      if (i != -1) {
        break label7349;
      }
      paramaukx.a(new NoColumnError("strHotChatInfo", String.class));
      label4809:
      i = paramCursor.getColumnIndex("uRoomid");
      if (i != -1) {
        break label7364;
      }
      paramaukx.a(new NoColumnError("uRoomid", Long.TYPE));
      label4846:
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label7379;
      }
      paramaukx.a(new NoColumnError("strVoteLimitedNotice", String.class));
      label4883:
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label7394;
      }
      paramaukx.a(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      label4920:
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label7409;
      }
      paramaukx.a(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      label4957:
      i = paramCursor.getColumnIndex("collegeId");
      if (i != -1) {
        break label7424;
      }
      paramaukx.a(new NoColumnError("collegeId", Long.TYPE));
      label4994:
      i = paramCursor.getColumnIndex("videoHeadFlag");
      if (i != -1) {
        break label7439;
      }
      paramaukx.a(new NoColumnError("videoHeadFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("bVideoHeadUrl");
      if (i != -1) {
        break label7466;
      }
      paramaukx.a(new NoColumnError("bVideoHeadUrl", String.class));
      label5068:
      i = paramCursor.getColumnIndex("faceScoreWordingColor");
      if (i != -1) {
        break label7481;
      }
      paramaukx.a(new NoColumnError("faceScoreWordingColor", Integer.TYPE));
      label5105:
      i = paramCursor.getColumnIndex("faceScoreWording");
      if (i != -1) {
        break label7496;
      }
      paramaukx.a(new NoColumnError("faceScoreWording", String.class));
      label5142:
      i = paramCursor.getColumnIndex("faceScoreTailWordingColor");
      if (i != -1) {
        break label7511;
      }
      paramaukx.a(new NoColumnError("faceScoreTailWordingColor", Integer.TYPE));
      label5179:
      i = paramCursor.getColumnIndex("faceScoreTailWording");
      if (i != -1) {
        break label7526;
      }
      paramaukx.a(new NoColumnError("faceScoreTailWording", String.class));
      label5216:
      i = paramCursor.getColumnIndex("faceScoreIconUrl");
      if (i != -1) {
        break label7541;
      }
      paramaukx.a(new NoColumnError("faceScoreIconUrl", String.class));
      label5253:
      i = paramCursor.getColumnIndex("entryAbility");
      if (i != -1) {
        break label7556;
      }
      paramaukx.a(new NoColumnError("entryAbility", Integer.TYPE));
      label5290:
      i = paramCursor.getColumnIndex("strLevelType");
      if (i != -1) {
        break label7571;
      }
      paramaukx.a(new NoColumnError("strLevelType", String.class));
      label5327:
      i = paramCursor.getColumnIndex("maskMsgFlag");
      if (i != -1) {
        break label7586;
      }
      paramaukx.a(new NoColumnError("maskMsgFlag", Integer.TYPE));
      label5364:
      i = paramCursor.getColumnIndex("isForbidSendMsg");
      if (i != -1) {
        break label7601;
      }
      paramaukx.a(new NoColumnError("isForbidSendMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isForbidSendGiftMsg");
      if (i != -1) {
        break label7628;
      }
      paramaukx.a(new NoColumnError("isForbidSendGiftMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("disableSendMsgBtnTips");
      if (i != -1) {
        break label7655;
      }
      paramaukx.a(new NoColumnError("disableSendMsgBtnTips", String.class));
      label5475:
      i = paramCursor.getColumnIndex("disableSendGiftBtnTips");
      if (i != -1) {
        break label7670;
      }
      paramaukx.a(new NoColumnError("disableSendGiftBtnTips", String.class));
      label5512:
      i = paramCursor.getColumnIndex("isForbidSendMsgForTribar");
      if (i != -1) {
        break label7685;
      }
      paramaukx.a(new NoColumnError("isForbidSendMsgForTribar", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isForbidSendGiftMsgForTribar");
      if (i != -1) {
        break label7712;
      }
      paramaukx.a(new NoColumnError("isForbidSendGiftMsgForTribar", Boolean.TYPE));
      i = paramCursor.getColumnIndex("disableSendMsgBtnTipsForTribar");
      if (i != -1) {
        break label7739;
      }
      paramaukx.a(new NoColumnError("disableSendMsgBtnTipsForTribar", String.class));
      label5623:
      i = paramCursor.getColumnIndex("disableSendGiftBtnTipsForTribar");
      if (i != -1) {
        break label7754;
      }
      paramaukx.a(new NoColumnError("disableSendGiftBtnTipsForTribar", String.class));
      label5660:
      i = paramCursor.getColumnIndex("highScoreNum");
      if (i != -1) {
        break label7769;
      }
      paramaukx.a(new NoColumnError("highScoreNum", Integer.TYPE));
      label5697:
      i = paramCursor.getColumnIndex("mHasStory");
      if (i != -1) {
        break label7784;
      }
      paramaukx.a(new NoColumnError("mHasStory", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mQQStoryData");
      if (i != -1) {
        break label7811;
      }
      paramaukx.a(new NoColumnError("mQQStoryData", [B.class));
      label5771:
      i = paramCursor.getColumnIndex("isSendMsgBtnDownloadAppOpen");
      if (i != -1) {
        break label7826;
      }
      paramaukx.a(new NoColumnError("isSendMsgBtnDownloadAppOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sendMsgBtnDownloadAppTips");
      if (i != -1) {
        break label7854;
      }
      paramaukx.a(new NoColumnError("sendMsgBtnDownloadAppTips", String.class));
      label5845:
      i = paramCursor.getColumnIndex("addPicBtnDownloadAppTips");
      if (i != -1) {
        break label7869;
      }
      paramaukx.a(new NoColumnError("addPicBtnDownloadAppTips", String.class));
      label5882:
      i = paramCursor.getColumnIndex("tribeAppDownloadPageUrl");
      if (i != -1) {
        break label7884;
      }
      paramaukx.a(new NoColumnError("tribeAppDownloadPageUrl", String.class));
      label5919:
      i = paramCursor.getColumnIndex("nearbyNowDataBytes");
      if (i != -1) {
        break label7899;
      }
      paramaukx.a(new NoColumnError("nearbyNowDataBytes", [B.class));
      label5956:
      i = paramCursor.getColumnIndex("guideAppNowTip");
      if (i != -1) {
        break label7914;
      }
      paramaukx.a(new NoColumnError("guideAppNowTip", String.class));
      label5993:
      i = paramCursor.getColumnIndex("guideAppNowTipLeftBtn");
      if (i != -1) {
        break label7929;
      }
      paramaukx.a(new NoColumnError("guideAppNowTipLeftBtn", String.class));
      label6030:
      i = paramCursor.getColumnIndex("guideAppNowTipRightBtnInstalled");
      if (i != -1) {
        break label7944;
      }
      paramaukx.a(new NoColumnError("guideAppNowTipRightBtnInstalled", String.class));
      label6067:
      i = paramCursor.getColumnIndex("guideAppNowTipRightBtnNotInstalled");
      if (i != -1) {
        break label7959;
      }
      paramaukx.a(new NoColumnError("guideAppNowTipRightBtnNotInstalled", String.class));
      label6104:
      i = paramCursor.getColumnIndex("guideAppNowPackage");
      if (i != -1) {
        break label7974;
      }
      paramaukx.a(new NoColumnError("guideAppNowPackage", String.class));
      label6141:
      i = paramCursor.getColumnIndex("guideAppNowJumpUri");
      if (i != -1) {
        break label7989;
      }
      paramaukx.a(new NoColumnError("guideAppNowJumpUri", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("guideAppNowDownloadUrl");
      if (i != -1) {
        break label8004;
      }
      paramaukx.a(new NoColumnError("guideAppNowDownloadUrl", String.class));
      return paramaukm;
      paramaukm.tinyId = paramCursor.getLong(i);
      break;
      label6232:
      paramaukm.uin = paramCursor.getString(i);
      break label2282;
      label6247:
      paramaukm.nowId = paramCursor.getLong(i);
      break label2317;
      label6262:
      paramaukm.nowUserType = paramCursor.getInt(i);
      break label2352;
      label6277:
      paramaukm.strRemark = paramCursor.getString(i);
      break label2387;
      label6292:
      paramaukm.nickname = paramCursor.getString(i);
      break label2422;
      label6307:
      paramaukm.gender = ((byte)paramCursor.getShort(i));
      break label2457;
      label6323:
      paramaukm.age = paramCursor.getInt(i);
      break label2492;
      label6338:
      paramaukm.birthday = paramCursor.getInt(i);
      break label2527;
      label6353:
      paramaukm.constellation = ((byte)paramCursor.getShort(i));
      break label2562;
      label6369:
      paramaukm.distance = paramCursor.getString(i);
      break label2597;
      label6384:
      paramaukm.timeDiff = paramCursor.getString(i);
      break label2632;
      label6399:
      paramaukm.aioDistanceAndTime = paramCursor.getString(i);
      break label2667;
      label6414:
      paramaukm.likeCount = paramCursor.getInt(i);
      break label2702;
      label6429:
      paramaukm.likeCountInc = paramCursor.getInt(i);
      break label2737;
      label6444:
      paramaukm.oldPhotoCount = paramCursor.getInt(i);
      break label2772;
      label6459:
      paramaukm.dateInfo = paramCursor.getBlob(i);
      break label2807;
      label6474:
      paramaukm.ulShowControl = paramCursor.getLong(i);
      break label2842;
      label6489:
      paramaukm.xuanYan = paramCursor.getBlob(i);
      break label2877;
      label6504:
      paramaukm.maritalStatus = ((byte)paramCursor.getShort(i));
      break label2912;
      label6520:
      paramaukm.job = paramCursor.getInt(i);
      break label2947;
      label6535:
      paramaukm.company = paramCursor.getString(i);
      break label2982;
      label6550:
      paramaukm.college = paramCursor.getString(i);
      break label3017;
      label6565:
      paramaukm.hometownCountry = paramCursor.getString(i);
      break label3052;
      label6580:
      paramaukm.hometownProvice = paramCursor.getString(i);
      break label3087;
      label6595:
      paramaukm.hometownCity = paramCursor.getString(i);
      break label3122;
      label6610:
      paramaukm.hometownDistrict = paramCursor.getString(i);
      break label3157;
      label6625:
      paramaukm.vCookies = paramCursor.getBlob(i);
      break label3192;
      label6640:
      paramaukm.bVoted = ((byte)paramCursor.getShort(i));
      break label3227;
      label6656:
      paramaukm.feedPreviewTime = paramCursor.getLong(i);
      break label3262;
      label6671:
      paramaukm.qzoneFeed = paramCursor.getString(i);
      break label3297;
      label6686:
      paramaukm.qzoneName = paramCursor.getString(i);
      break label3332;
      label6701:
      paramaukm.qzonePicUrl_1 = paramCursor.getString(i);
      break label3367;
      label6716:
      paramaukm.qzonePicUrl_2 = paramCursor.getString(i);
      break label3402;
      label6731:
      paramaukm.qzonePicUrl_3 = paramCursor.getString(i);
      break label3437;
      label6746:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isPhotoUseCache = paramBoolean;
        break;
      }
      label6773:
      paramaukm.vSeed = paramCursor.getBlob(i);
      break label3507;
      label6788:
      paramaukm.vTempChatSig = paramCursor.getBlob(i);
      break label3542;
      label6803:
      paramaukm.vGroupList = paramCursor.getBlob(i);
      break label3577;
      label6818:
      paramaukm.nearbyInfo = paramCursor.getBlob(i);
      break label3612;
      label6833:
      paramaukm.vActivityList = paramCursor.getBlob(i);
      break label3647;
      label6848:
      paramaukm.lUserFlag = paramCursor.getLong(i);
      break label3682;
      label6863:
      paramaukm.iIsGodFlag = paramCursor.getInt(i);
      break label3717;
      label6878:
      paramaukm.strGodJumpUrl = paramCursor.getString(i);
      break label3752;
      label6893:
      paramaukm.mHeartNum = paramCursor.getInt(i);
      break label3787;
      label6908:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.switchQzone = paramBoolean;
        break;
      }
      label6935:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.switchHobby = paramBoolean;
        break;
      }
      label6962:
      paramaukm.uiShowControl = paramCursor.getLong(i);
      break label3892;
      label6977:
      paramaukm.userFlag = paramCursor.getLong(i);
      break label3927;
      label6992:
      paramaukm.busiEntry = paramCursor.getString(i);
      break label3962;
      label7007:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.godFlag = paramBoolean;
        break;
      }
      label7034:
      paramaukm.nLastGameFlag = paramCursor.getInt(i);
      break label4032;
      label7049:
      paramaukm.strProfileUrl = paramCursor.getString(i);
      break label4069;
      label7064:
      paramaukm.lastUpdateNickTime = paramCursor.getLong(i);
      break label4106;
      label7079:
      paramaukm.favoriteSource = paramCursor.getInt(i);
      break label4143;
      label7094:
      paramaukm.switchGiftVisible = paramCursor.getLong(i);
      break label4180;
      label7109:
      paramaukm.vGiftInfo = paramCursor.getBlob(i);
      break label4217;
      label7124:
      paramaukm.sayHelloFlag = paramCursor.getInt(i);
      break label4254;
      label7139:
      paramaukm.charm = paramCursor.getLong(i);
      break label4291;
      label7154:
      paramaukm.charmLevel = paramCursor.getInt(i);
      break label4328;
      label7169:
      paramaukm.nextThreshold = paramCursor.getInt(i);
      break label4365;
      label7184:
      paramaukm.curThreshold = paramCursor.getInt(i);
      break label4402;
      label7199:
      paramaukm.profPercent = paramCursor.getInt(i);
      break label4439;
      label7214:
      paramaukm.taskFinished = paramCursor.getInt(i);
      break label4476;
      label7229:
      paramaukm.taskTotal = paramCursor.getInt(i);
      break label4513;
      label7244:
      paramaukm.hiWanInfo = paramCursor.getString(i);
      break label4550;
      label7259:
      paramaukm.commonLabelString = paramCursor.getString(i);
      break label4587;
      label7274:
      paramaukm.tagFlag = paramCursor.getLong(i);
      break label4624;
      label7289:
      paramaukm.tagInfo = paramCursor.getString(i);
      break label4661;
      label7304:
      paramaukm.picInfo = paramCursor.getString(i);
      break label4698;
      label7319:
      paramaukm.videoDetails = paramCursor.getString(i);
      break label4735;
      label7334:
      paramaukm.strFreshNewsInfo = paramCursor.getString(i);
      break label4772;
      label7349:
      paramaukm.strHotChatInfo = paramCursor.getString(i);
      break label4809;
      label7364:
      paramaukm.uRoomid = paramCursor.getLong(i);
      break label4846;
      label7379:
      paramaukm.strVoteLimitedNotice = paramCursor.getString(i);
      break label4883;
      label7394:
      paramaukm.bHaveVotedCnt = paramCursor.getShort(i);
      break label4920;
      label7409:
      paramaukm.bAvailVoteCnt = paramCursor.getShort(i);
      break label4957;
      label7424:
      paramaukm.collegeId = paramCursor.getLong(i);
      break label4994;
      label7439:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.videoHeadFlag = paramBoolean;
        break;
      }
      label7466:
      paramaukm.bVideoHeadUrl = paramCursor.getString(i);
      break label5068;
      label7481:
      paramaukm.faceScoreWordingColor = paramCursor.getInt(i);
      break label5105;
      label7496:
      paramaukm.faceScoreWording = paramCursor.getString(i);
      break label5142;
      label7511:
      paramaukm.faceScoreTailWordingColor = paramCursor.getInt(i);
      break label5179;
      label7526:
      paramaukm.faceScoreTailWording = paramCursor.getString(i);
      break label5216;
      label7541:
      paramaukm.faceScoreIconUrl = paramCursor.getString(i);
      break label5253;
      label7556:
      paramaukm.entryAbility = paramCursor.getInt(i);
      break label5290;
      label7571:
      paramaukm.strLevelType = paramCursor.getString(i);
      break label5327;
      label7586:
      paramaukm.maskMsgFlag = paramCursor.getInt(i);
      break label5364;
      label7601:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isForbidSendMsg = paramBoolean;
        break;
      }
      label7628:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isForbidSendGiftMsg = paramBoolean;
        break;
      }
      label7655:
      paramaukm.disableSendMsgBtnTips = paramCursor.getString(i);
      break label5475;
      label7670:
      paramaukm.disableSendGiftBtnTips = paramCursor.getString(i);
      break label5512;
      label7685:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isForbidSendMsgForTribar = paramBoolean;
        break;
      }
      label7712:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isForbidSendGiftMsgForTribar = paramBoolean;
        break;
      }
      label7739:
      paramaukm.disableSendMsgBtnTipsForTribar = paramCursor.getString(i);
      break label5623;
      label7754:
      paramaukm.disableSendGiftBtnTipsForTribar = paramCursor.getString(i);
      break label5660;
      label7769:
      paramaukm.highScoreNum = paramCursor.getInt(i);
      break label5697;
      label7784:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.mHasStory = paramBoolean;
        break;
      }
      label7811:
      paramaukm.mQQStoryData = paramCursor.getBlob(i);
      break label5771;
      label7826:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramaukm.isSendMsgBtnDownloadAppOpen = paramBoolean;
        break;
      }
      label7854:
      paramaukm.sendMsgBtnDownloadAppTips = paramCursor.getString(i);
      break label5845;
      label7869:
      paramaukm.addPicBtnDownloadAppTips = paramCursor.getString(i);
      break label5882;
      label7884:
      paramaukm.tribeAppDownloadPageUrl = paramCursor.getString(i);
      break label5919;
      label7899:
      paramaukm.nearbyNowDataBytes = paramCursor.getBlob(i);
      break label5956;
      label7914:
      paramaukm.guideAppNowTip = paramCursor.getString(i);
      break label5993;
      label7929:
      paramaukm.guideAppNowTipLeftBtn = paramCursor.getString(i);
      break label6030;
      label7944:
      paramaukm.guideAppNowTipRightBtnInstalled = paramCursor.getString(i);
      break label6067;
      label7959:
      paramaukm.guideAppNowTipRightBtnNotInstalled = paramCursor.getString(i);
      break label6104;
      label7974:
      paramaukm.guideAppNowPackage = paramCursor.getString(i);
      break label6141;
      label7989:
      paramaukm.guideAppNowJumpUri = paramCursor.getString(i);
    }
    label8004:
    paramaukm.guideAppNowDownloadUrl = paramCursor.getString(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,tinyId INTEGER ,uin TEXT ,nowId INTEGER ,nowUserType INTEGER ,strRemark TEXT ,nickname TEXT ,gender INTEGER ,age INTEGER ,birthday INTEGER ,constellation INTEGER ,distance TEXT ,timeDiff TEXT ,aioDistanceAndTime TEXT ,likeCount INTEGER ,likeCountInc INTEGER ,oldPhotoCount INTEGER ,dateInfo BLOB ,ulShowControl INTEGER ,xuanYan BLOB ,maritalStatus INTEGER ,job INTEGER ,company TEXT ,college TEXT ,hometownCountry TEXT ,hometownProvice TEXT ,hometownCity TEXT ,hometownDistrict TEXT ,vCookies BLOB ,bVoted INTEGER ,feedPreviewTime INTEGER ,qzoneFeed TEXT ,qzoneName TEXT ,qzonePicUrl_1 TEXT ,qzonePicUrl_2 TEXT ,qzonePicUrl_3 TEXT ,isPhotoUseCache INTEGER ,vSeed BLOB ,vTempChatSig BLOB ,vGroupList BLOB ,nearbyInfo BLOB ,vActivityList BLOB ,lUserFlag INTEGER ,iIsGodFlag INTEGER ,strGodJumpUrl TEXT ,mHeartNum INTEGER ,switchQzone INTEGER ,switchHobby INTEGER ,uiShowControl INTEGER ,userFlag INTEGER ,busiEntry TEXT ,godFlag INTEGER ,nLastGameFlag INTEGER ,strProfileUrl TEXT ,lastUpdateNickTime INTEGER ,favoriteSource INTEGER ,switchGiftVisible INTEGER ,vGiftInfo BLOB ,sayHelloFlag INTEGER ,charm INTEGER ,charmLevel INTEGER ,nextThreshold INTEGER ,curThreshold INTEGER ,profPercent INTEGER ,taskFinished INTEGER ,taskTotal INTEGER ,hiWanInfo TEXT ,commonLabelString TEXT ,tagFlag INTEGER ,tagInfo TEXT ,picInfo TEXT ,videoDetails TEXT ,strFreshNewsInfo TEXT ,strHotChatInfo TEXT ,uRoomid INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,collegeId INTEGER ,videoHeadFlag INTEGER ,bVideoHeadUrl TEXT ,faceScoreWordingColor INTEGER ,faceScoreWording TEXT ,faceScoreTailWordingColor INTEGER ,faceScoreTailWording TEXT ,faceScoreIconUrl TEXT ,entryAbility INTEGER ,strLevelType TEXT ,maskMsgFlag INTEGER ,isForbidSendMsg INTEGER ,isForbidSendGiftMsg INTEGER ,disableSendMsgBtnTips TEXT ,disableSendGiftBtnTips TEXT ,isForbidSendMsgForTribar INTEGER ,isForbidSendGiftMsgForTribar INTEGER ,disableSendMsgBtnTipsForTribar TEXT ,disableSendGiftBtnTipsForTribar TEXT ,highScoreNum INTEGER ,mHasStory INTEGER ,mQQStoryData BLOB ,isSendMsgBtnDownloadAppOpen INTEGER ,sendMsgBtnDownloadAppTips TEXT ,addPicBtnDownloadAppTips TEXT ,tribeAppDownloadPageUrl TEXT ,nearbyNowDataBytes BLOB ,guideAppNowTip TEXT ,guideAppNowTipLeftBtn TEXT ,guideAppNowTipRightBtnInstalled TEXT ,guideAppNowTipRightBtnNotInstalled TEXT ,guideAppNowPackage TEXT ,guideAppNowJumpUri TEXT ,guideAppNowDownloadUrl TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (NearbyPeopleCard)paramaukm;
    paramContentValues.put("tinyId", Long.valueOf(paramaukm.tinyId));
    paramContentValues.put("uin", paramaukm.uin);
    paramContentValues.put("nowId", Long.valueOf(paramaukm.nowId));
    paramContentValues.put("nowUserType", Integer.valueOf(paramaukm.nowUserType));
    paramContentValues.put("strRemark", paramaukm.strRemark);
    paramContentValues.put("nickname", paramaukm.nickname);
    paramContentValues.put("gender", Byte.valueOf(paramaukm.gender));
    paramContentValues.put("age", Integer.valueOf(paramaukm.age));
    paramContentValues.put("birthday", Integer.valueOf(paramaukm.birthday));
    paramContentValues.put("constellation", Byte.valueOf(paramaukm.constellation));
    paramContentValues.put("distance", paramaukm.distance);
    paramContentValues.put("timeDiff", paramaukm.timeDiff);
    paramContentValues.put("aioDistanceAndTime", paramaukm.aioDistanceAndTime);
    paramContentValues.put("likeCount", Integer.valueOf(paramaukm.likeCount));
    paramContentValues.put("likeCountInc", Integer.valueOf(paramaukm.likeCountInc));
    paramContentValues.put("oldPhotoCount", Integer.valueOf(paramaukm.oldPhotoCount));
    paramContentValues.put("dateInfo", paramaukm.dateInfo);
    paramContentValues.put("ulShowControl", Long.valueOf(paramaukm.ulShowControl));
    paramContentValues.put("xuanYan", paramaukm.xuanYan);
    paramContentValues.put("maritalStatus", Byte.valueOf(paramaukm.maritalStatus));
    paramContentValues.put("job", Integer.valueOf(paramaukm.job));
    paramContentValues.put("company", paramaukm.company);
    paramContentValues.put("college", paramaukm.college);
    paramContentValues.put("hometownCountry", paramaukm.hometownCountry);
    paramContentValues.put("hometownProvice", paramaukm.hometownProvice);
    paramContentValues.put("hometownCity", paramaukm.hometownCity);
    paramContentValues.put("hometownDistrict", paramaukm.hometownDistrict);
    paramContentValues.put("vCookies", paramaukm.vCookies);
    paramContentValues.put("bVoted", Byte.valueOf(paramaukm.bVoted));
    paramContentValues.put("feedPreviewTime", Long.valueOf(paramaukm.feedPreviewTime));
    paramContentValues.put("qzoneFeed", paramaukm.qzoneFeed);
    paramContentValues.put("qzoneName", paramaukm.qzoneName);
    paramContentValues.put("qzonePicUrl_1", paramaukm.qzonePicUrl_1);
    paramContentValues.put("qzonePicUrl_2", paramaukm.qzonePicUrl_2);
    paramContentValues.put("qzonePicUrl_3", paramaukm.qzonePicUrl_3);
    paramContentValues.put("isPhotoUseCache", Boolean.valueOf(paramaukm.isPhotoUseCache));
    paramContentValues.put("vSeed", paramaukm.vSeed);
    paramContentValues.put("vTempChatSig", paramaukm.vTempChatSig);
    paramContentValues.put("vGroupList", paramaukm.vGroupList);
    paramContentValues.put("nearbyInfo", paramaukm.nearbyInfo);
    paramContentValues.put("vActivityList", paramaukm.vActivityList);
    paramContentValues.put("lUserFlag", Long.valueOf(paramaukm.lUserFlag));
    paramContentValues.put("iIsGodFlag", Integer.valueOf(paramaukm.iIsGodFlag));
    paramContentValues.put("strGodJumpUrl", paramaukm.strGodJumpUrl);
    paramContentValues.put("mHeartNum", Integer.valueOf(paramaukm.mHeartNum));
    paramContentValues.put("switchQzone", Boolean.valueOf(paramaukm.switchQzone));
    paramContentValues.put("switchHobby", Boolean.valueOf(paramaukm.switchHobby));
    paramContentValues.put("uiShowControl", Long.valueOf(paramaukm.uiShowControl));
    paramContentValues.put("userFlag", Long.valueOf(paramaukm.userFlag));
    paramContentValues.put("busiEntry", paramaukm.busiEntry);
    paramContentValues.put("godFlag", Boolean.valueOf(paramaukm.godFlag));
    paramContentValues.put("nLastGameFlag", Integer.valueOf(paramaukm.nLastGameFlag));
    paramContentValues.put("strProfileUrl", paramaukm.strProfileUrl);
    paramContentValues.put("lastUpdateNickTime", Long.valueOf(paramaukm.lastUpdateNickTime));
    paramContentValues.put("favoriteSource", Integer.valueOf(paramaukm.favoriteSource));
    paramContentValues.put("switchGiftVisible", Long.valueOf(paramaukm.switchGiftVisible));
    paramContentValues.put("vGiftInfo", paramaukm.vGiftInfo);
    paramContentValues.put("sayHelloFlag", Integer.valueOf(paramaukm.sayHelloFlag));
    paramContentValues.put("charm", Long.valueOf(paramaukm.charm));
    paramContentValues.put("charmLevel", Integer.valueOf(paramaukm.charmLevel));
    paramContentValues.put("nextThreshold", Integer.valueOf(paramaukm.nextThreshold));
    paramContentValues.put("curThreshold", Integer.valueOf(paramaukm.curThreshold));
    paramContentValues.put("profPercent", Integer.valueOf(paramaukm.profPercent));
    paramContentValues.put("taskFinished", Integer.valueOf(paramaukm.taskFinished));
    paramContentValues.put("taskTotal", Integer.valueOf(paramaukm.taskTotal));
    paramContentValues.put("hiWanInfo", paramaukm.hiWanInfo);
    paramContentValues.put("commonLabelString", paramaukm.commonLabelString);
    paramContentValues.put("tagFlag", Long.valueOf(paramaukm.tagFlag));
    paramContentValues.put("tagInfo", paramaukm.tagInfo);
    paramContentValues.put("picInfo", paramaukm.picInfo);
    paramContentValues.put("videoDetails", paramaukm.videoDetails);
    paramContentValues.put("strFreshNewsInfo", paramaukm.strFreshNewsInfo);
    paramContentValues.put("strHotChatInfo", paramaukm.strHotChatInfo);
    paramContentValues.put("uRoomid", Long.valueOf(paramaukm.uRoomid));
    paramContentValues.put("strVoteLimitedNotice", paramaukm.strVoteLimitedNotice);
    paramContentValues.put("bHaveVotedCnt", Short.valueOf(paramaukm.bHaveVotedCnt));
    paramContentValues.put("bAvailVoteCnt", Short.valueOf(paramaukm.bAvailVoteCnt));
    paramContentValues.put("collegeId", Long.valueOf(paramaukm.collegeId));
    paramContentValues.put("videoHeadFlag", Boolean.valueOf(paramaukm.videoHeadFlag));
    paramContentValues.put("bVideoHeadUrl", paramaukm.bVideoHeadUrl);
    paramContentValues.put("faceScoreWordingColor", Integer.valueOf(paramaukm.faceScoreWordingColor));
    paramContentValues.put("faceScoreWording", paramaukm.faceScoreWording);
    paramContentValues.put("faceScoreTailWordingColor", Integer.valueOf(paramaukm.faceScoreTailWordingColor));
    paramContentValues.put("faceScoreTailWording", paramaukm.faceScoreTailWording);
    paramContentValues.put("faceScoreIconUrl", paramaukm.faceScoreIconUrl);
    paramContentValues.put("entryAbility", Integer.valueOf(paramaukm.entryAbility));
    paramContentValues.put("strLevelType", paramaukm.strLevelType);
    paramContentValues.put("maskMsgFlag", Integer.valueOf(paramaukm.maskMsgFlag));
    paramContentValues.put("isForbidSendMsg", Boolean.valueOf(paramaukm.isForbidSendMsg));
    paramContentValues.put("isForbidSendGiftMsg", Boolean.valueOf(paramaukm.isForbidSendGiftMsg));
    paramContentValues.put("disableSendMsgBtnTips", paramaukm.disableSendMsgBtnTips);
    paramContentValues.put("disableSendGiftBtnTips", paramaukm.disableSendGiftBtnTips);
    paramContentValues.put("isForbidSendMsgForTribar", Boolean.valueOf(paramaukm.isForbidSendMsgForTribar));
    paramContentValues.put("isForbidSendGiftMsgForTribar", Boolean.valueOf(paramaukm.isForbidSendGiftMsgForTribar));
    paramContentValues.put("disableSendMsgBtnTipsForTribar", paramaukm.disableSendMsgBtnTipsForTribar);
    paramContentValues.put("disableSendGiftBtnTipsForTribar", paramaukm.disableSendGiftBtnTipsForTribar);
    paramContentValues.put("highScoreNum", Integer.valueOf(paramaukm.highScoreNum));
    paramContentValues.put("mHasStory", Boolean.valueOf(paramaukm.mHasStory));
    paramContentValues.put("mQQStoryData", paramaukm.mQQStoryData);
    paramContentValues.put("isSendMsgBtnDownloadAppOpen", Boolean.valueOf(paramaukm.isSendMsgBtnDownloadAppOpen));
    paramContentValues.put("sendMsgBtnDownloadAppTips", paramaukm.sendMsgBtnDownloadAppTips);
    paramContentValues.put("addPicBtnDownloadAppTips", paramaukm.addPicBtnDownloadAppTips);
    paramContentValues.put("tribeAppDownloadPageUrl", paramaukm.tribeAppDownloadPageUrl);
    paramContentValues.put("nearbyNowDataBytes", paramaukm.nearbyNowDataBytes);
    paramContentValues.put("guideAppNowTip", paramaukm.guideAppNowTip);
    paramContentValues.put("guideAppNowTipLeftBtn", paramaukm.guideAppNowTipLeftBtn);
    paramContentValues.put("guideAppNowTipRightBtnInstalled", paramaukm.guideAppNowTipRightBtnInstalled);
    paramContentValues.put("guideAppNowTipRightBtnNotInstalled", paramaukm.guideAppNowTipRightBtnNotInstalled);
    paramContentValues.put("guideAppNowPackage", paramaukm.guideAppNowPackage);
    paramContentValues.put("guideAppNowJumpUri", paramaukm.guideAppNowJumpUri);
    paramContentValues.put("guideAppNowDownloadUrl", paramaukm.guideAppNowDownloadUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukw
 * JD-Core Version:    0.7.0.1
 */