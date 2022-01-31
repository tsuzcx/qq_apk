import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awgo
  extends awgq
{
  public awgo()
  {
    this.a = 111;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawge = (NearbyPeopleCard)paramawge;
    if (paramawgp == null)
    {
      paramawge.tinyId = paramCursor.getLong(paramCursor.getColumnIndex("tinyId"));
      paramawge.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawge.nowId = paramCursor.getLong(paramCursor.getColumnIndex("nowId"));
      paramawge.nowUserType = paramCursor.getInt(paramCursor.getColumnIndex("nowUserType"));
      paramawge.strRemark = paramCursor.getString(paramCursor.getColumnIndex("strRemark"));
      paramawge.nickname = paramCursor.getString(paramCursor.getColumnIndex("nickname"));
      paramawge.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
      paramawge.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
      paramawge.birthday = paramCursor.getInt(paramCursor.getColumnIndex("birthday"));
      paramawge.constellation = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("constellation")));
      paramawge.distance = paramCursor.getString(paramCursor.getColumnIndex("distance"));
      paramawge.timeDiff = paramCursor.getString(paramCursor.getColumnIndex("timeDiff"));
      paramawge.aioDistanceAndTime = paramCursor.getString(paramCursor.getColumnIndex("aioDistanceAndTime"));
      paramawge.likeCount = paramCursor.getInt(paramCursor.getColumnIndex("likeCount"));
      paramawge.likeCountInc = paramCursor.getInt(paramCursor.getColumnIndex("likeCountInc"));
      paramawge.oldPhotoCount = paramCursor.getInt(paramCursor.getColumnIndex("oldPhotoCount"));
      paramawge.dateInfo = paramCursor.getBlob(paramCursor.getColumnIndex("dateInfo"));
      paramawge.ulShowControl = paramCursor.getLong(paramCursor.getColumnIndex("ulShowControl"));
      paramawge.xuanYan = paramCursor.getBlob(paramCursor.getColumnIndex("xuanYan"));
      paramawge.maritalStatus = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("maritalStatus")));
      paramawge.job = paramCursor.getInt(paramCursor.getColumnIndex("job"));
      paramawge.company = paramCursor.getString(paramCursor.getColumnIndex("company"));
      paramawge.college = paramCursor.getString(paramCursor.getColumnIndex("college"));
      paramawge.hometownCountry = paramCursor.getString(paramCursor.getColumnIndex("hometownCountry"));
      paramawge.hometownProvice = paramCursor.getString(paramCursor.getColumnIndex("hometownProvice"));
      paramawge.hometownCity = paramCursor.getString(paramCursor.getColumnIndex("hometownCity"));
      paramawge.hometownDistrict = paramCursor.getString(paramCursor.getColumnIndex("hometownDistrict"));
      paramawge.vCookies = paramCursor.getBlob(paramCursor.getColumnIndex("vCookies"));
      paramawge.bVoted = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bVoted")));
      paramawge.feedPreviewTime = paramCursor.getLong(paramCursor.getColumnIndex("feedPreviewTime"));
      paramawge.qzoneFeed = paramCursor.getString(paramCursor.getColumnIndex("qzoneFeed"));
      paramawge.qzoneName = paramCursor.getString(paramCursor.getColumnIndex("qzoneName"));
      paramawge.qzonePicUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_1"));
      paramawge.qzonePicUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_2"));
      paramawge.qzonePicUrl_3 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_3"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isPhotoUseCache")))
      {
        paramBoolean = true;
        paramawge.isPhotoUseCache = paramBoolean;
        paramawge.vSeed = paramCursor.getBlob(paramCursor.getColumnIndex("vSeed"));
        paramawge.vTempChatSig = paramCursor.getBlob(paramCursor.getColumnIndex("vTempChatSig"));
        paramawge.vGroupList = paramCursor.getBlob(paramCursor.getColumnIndex("vGroupList"));
        paramawge.nearbyInfo = paramCursor.getBlob(paramCursor.getColumnIndex("nearbyInfo"));
        paramawge.vActivityList = paramCursor.getBlob(paramCursor.getColumnIndex("vActivityList"));
        paramawge.lUserFlag = paramCursor.getLong(paramCursor.getColumnIndex("lUserFlag"));
        paramawge.iIsGodFlag = paramCursor.getInt(paramCursor.getColumnIndex("iIsGodFlag"));
        paramawge.strGodJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("strGodJumpUrl"));
        paramawge.mHeartNum = paramCursor.getInt(paramCursor.getColumnIndex("mHeartNum"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("switchQzone"))) {
          break label2162;
        }
        paramBoolean = true;
        label857:
        paramawge.switchQzone = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("switchHobby"))) {
          break label2167;
        }
        paramBoolean = true;
        label882:
        paramawge.switchHobby = paramBoolean;
        paramawge.uiShowControl = paramCursor.getLong(paramCursor.getColumnIndex("uiShowControl"));
        paramawge.userFlag = paramCursor.getLong(paramCursor.getColumnIndex("userFlag"));
        paramawge.busiEntry = paramCursor.getString(paramCursor.getColumnIndex("busiEntry"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("godFlag"))) {
          break label2172;
        }
        paramBoolean = true;
        label961:
        paramawge.godFlag = paramBoolean;
        paramawge.nLastGameFlag = paramCursor.getInt(paramCursor.getColumnIndex("nLastGameFlag"));
        paramawge.strProfileUrl = paramCursor.getString(paramCursor.getColumnIndex("strProfileUrl"));
        paramawge.lastUpdateNickTime = paramCursor.getLong(paramCursor.getColumnIndex("lastUpdateNickTime"));
        paramawge.favoriteSource = paramCursor.getInt(paramCursor.getColumnIndex("favoriteSource"));
        paramawge.switchGiftVisible = paramCursor.getLong(paramCursor.getColumnIndex("switchGiftVisible"));
        paramawge.vGiftInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vGiftInfo"));
        paramawge.sayHelloFlag = paramCursor.getInt(paramCursor.getColumnIndex("sayHelloFlag"));
        paramawge.charm = paramCursor.getLong(paramCursor.getColumnIndex("charm"));
        paramawge.charmLevel = paramCursor.getInt(paramCursor.getColumnIndex("charmLevel"));
        paramawge.nextThreshold = paramCursor.getInt(paramCursor.getColumnIndex("nextThreshold"));
        paramawge.curThreshold = paramCursor.getInt(paramCursor.getColumnIndex("curThreshold"));
        paramawge.profPercent = paramCursor.getInt(paramCursor.getColumnIndex("profPercent"));
        paramawge.taskFinished = paramCursor.getInt(paramCursor.getColumnIndex("taskFinished"));
        paramawge.taskTotal = paramCursor.getInt(paramCursor.getColumnIndex("taskTotal"));
        paramawge.hiWanInfo = paramCursor.getString(paramCursor.getColumnIndex("hiWanInfo"));
        paramawge.commonLabelString = paramCursor.getString(paramCursor.getColumnIndex("commonLabelString"));
        paramawge.tagFlag = paramCursor.getLong(paramCursor.getColumnIndex("tagFlag"));
        paramawge.tagInfo = paramCursor.getString(paramCursor.getColumnIndex("tagInfo"));
        paramawge.picInfo = paramCursor.getString(paramCursor.getColumnIndex("picInfo"));
        paramawge.videoDetails = paramCursor.getString(paramCursor.getColumnIndex("videoDetails"));
        paramawge.strFreshNewsInfo = paramCursor.getString(paramCursor.getColumnIndex("strFreshNewsInfo"));
        paramawge.strHotChatInfo = paramCursor.getString(paramCursor.getColumnIndex("strHotChatInfo"));
        paramawge.uRoomid = paramCursor.getLong(paramCursor.getColumnIndex("uRoomid"));
        paramawge.strVoteLimitedNotice = paramCursor.getString(paramCursor.getColumnIndex("strVoteLimitedNotice"));
        paramawge.bHaveVotedCnt = paramCursor.getShort(paramCursor.getColumnIndex("bHaveVotedCnt"));
        paramawge.bAvailVoteCnt = paramCursor.getShort(paramCursor.getColumnIndex("bAvailVoteCnt"));
        paramawge.collegeId = paramCursor.getLong(paramCursor.getColumnIndex("collegeId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("videoHeadFlag"))) {
          break label2177;
        }
        paramBoolean = true;
        label1499:
        paramawge.videoHeadFlag = paramBoolean;
        paramawge.bVideoHeadUrl = paramCursor.getString(paramCursor.getColumnIndex("bVideoHeadUrl"));
        paramawge.faceScoreWordingColor = paramCursor.getInt(paramCursor.getColumnIndex("faceScoreWordingColor"));
        paramawge.faceScoreWording = paramCursor.getString(paramCursor.getColumnIndex("faceScoreWording"));
        paramawge.faceScoreTailWordingColor = paramCursor.getInt(paramCursor.getColumnIndex("faceScoreTailWordingColor"));
        paramawge.faceScoreTailWording = paramCursor.getString(paramCursor.getColumnIndex("faceScoreTailWording"));
        paramawge.faceScoreIconUrl = paramCursor.getString(paramCursor.getColumnIndex("faceScoreIconUrl"));
        paramawge.entryAbility = paramCursor.getInt(paramCursor.getColumnIndex("entryAbility"));
        paramawge.strLevelType = paramCursor.getString(paramCursor.getColumnIndex("strLevelType"));
        paramawge.maskMsgFlag = paramCursor.getInt(paramCursor.getColumnIndex("maskMsgFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendMsg"))) {
          break label2182;
        }
        paramBoolean = true;
        label1696:
        paramawge.isForbidSendMsg = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendGiftMsg"))) {
          break label2187;
        }
        paramBoolean = true;
        label1722:
        paramawge.isForbidSendGiftMsg = paramBoolean;
        paramawge.disableSendMsgBtnTips = paramCursor.getString(paramCursor.getColumnIndex("disableSendMsgBtnTips"));
        paramawge.disableSendGiftBtnTips = paramCursor.getString(paramCursor.getColumnIndex("disableSendGiftBtnTips"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendMsgForTribar"))) {
          break label2192;
        }
        paramBoolean = true;
        label1786:
        paramawge.isForbidSendMsgForTribar = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendGiftMsgForTribar"))) {
          break label2197;
        }
        paramBoolean = true;
        label1812:
        paramawge.isForbidSendGiftMsgForTribar = paramBoolean;
        paramawge.disableSendMsgBtnTipsForTribar = paramCursor.getString(paramCursor.getColumnIndex("disableSendMsgBtnTipsForTribar"));
        paramawge.disableSendGiftBtnTipsForTribar = paramCursor.getString(paramCursor.getColumnIndex("disableSendGiftBtnTipsForTribar"));
        paramawge.highScoreNum = paramCursor.getInt(paramCursor.getColumnIndex("highScoreNum"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mHasStory"))) {
          break label2202;
        }
        paramBoolean = true;
        label1895:
        paramawge.mHasStory = paramBoolean;
        paramawge.mQQStoryData = paramCursor.getBlob(paramCursor.getColumnIndex("mQQStoryData"));
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
        paramawge.isSendMsgBtnDownloadAppOpen = paramBoolean;
        paramawge.sendMsgBtnDownloadAppTips = paramCursor.getString(paramCursor.getColumnIndex("sendMsgBtnDownloadAppTips"));
        paramawge.addPicBtnDownloadAppTips = paramCursor.getString(paramCursor.getColumnIndex("addPicBtnDownloadAppTips"));
        paramawge.tribeAppDownloadPageUrl = paramCursor.getString(paramCursor.getColumnIndex("tribeAppDownloadPageUrl"));
        paramawge.nearbyNowDataBytes = paramCursor.getBlob(paramCursor.getColumnIndex("nearbyNowDataBytes"));
        paramawge.guideAppNowTip = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTip"));
        paramawge.guideAppNowTipLeftBtn = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTipLeftBtn"));
        paramawge.guideAppNowTipRightBtnInstalled = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTipRightBtnInstalled"));
        paramawge.guideAppNowTipRightBtnNotInstalled = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTipRightBtnNotInstalled"));
        paramawge.guideAppNowPackage = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowPackage"));
        paramawge.guideAppNowJumpUri = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowJumpUri"));
        paramawge.guideAppNowDownloadUrl = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowDownloadUrl"));
        return paramawge;
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
      paramawgp.a(new NoColumnError("tinyId", Long.TYPE));
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label6232;
      }
      paramawgp.a(new NoColumnError("uin", String.class));
      label2282:
      i = paramCursor.getColumnIndex("nowId");
      if (i != -1) {
        break label6247;
      }
      paramawgp.a(new NoColumnError("nowId", Long.TYPE));
      label2317:
      i = paramCursor.getColumnIndex("nowUserType");
      if (i != -1) {
        break label6262;
      }
      paramawgp.a(new NoColumnError("nowUserType", Integer.TYPE));
      label2352:
      i = paramCursor.getColumnIndex("strRemark");
      if (i != -1) {
        break label6277;
      }
      paramawgp.a(new NoColumnError("strRemark", String.class));
      label2387:
      i = paramCursor.getColumnIndex("nickname");
      if (i != -1) {
        break label6292;
      }
      paramawgp.a(new NoColumnError("nickname", String.class));
      label2422:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label6307;
      }
      paramawgp.a(new NoColumnError("gender", Byte.TYPE));
      label2457:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label6323;
      }
      paramawgp.a(new NoColumnError("age", Integer.TYPE));
      label2492:
      i = paramCursor.getColumnIndex("birthday");
      if (i != -1) {
        break label6338;
      }
      paramawgp.a(new NoColumnError("birthday", Integer.TYPE));
      label2527:
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label6353;
      }
      paramawgp.a(new NoColumnError("constellation", Byte.TYPE));
      label2562:
      i = paramCursor.getColumnIndex("distance");
      if (i != -1) {
        break label6369;
      }
      paramawgp.a(new NoColumnError("distance", String.class));
      label2597:
      i = paramCursor.getColumnIndex("timeDiff");
      if (i != -1) {
        break label6384;
      }
      paramawgp.a(new NoColumnError("timeDiff", String.class));
      label2632:
      i = paramCursor.getColumnIndex("aioDistanceAndTime");
      if (i != -1) {
        break label6399;
      }
      paramawgp.a(new NoColumnError("aioDistanceAndTime", String.class));
      label2667:
      i = paramCursor.getColumnIndex("likeCount");
      if (i != -1) {
        break label6414;
      }
      paramawgp.a(new NoColumnError("likeCount", Integer.TYPE));
      label2702:
      i = paramCursor.getColumnIndex("likeCountInc");
      if (i != -1) {
        break label6429;
      }
      paramawgp.a(new NoColumnError("likeCountInc", Integer.TYPE));
      label2737:
      i = paramCursor.getColumnIndex("oldPhotoCount");
      if (i != -1) {
        break label6444;
      }
      paramawgp.a(new NoColumnError("oldPhotoCount", Integer.TYPE));
      label2772:
      i = paramCursor.getColumnIndex("dateInfo");
      if (i != -1) {
        break label6459;
      }
      paramawgp.a(new NoColumnError("dateInfo", [B.class));
      label2807:
      i = paramCursor.getColumnIndex("ulShowControl");
      if (i != -1) {
        break label6474;
      }
      paramawgp.a(new NoColumnError("ulShowControl", Long.TYPE));
      label2842:
      i = paramCursor.getColumnIndex("xuanYan");
      if (i != -1) {
        break label6489;
      }
      paramawgp.a(new NoColumnError("xuanYan", [B.class));
      label2877:
      i = paramCursor.getColumnIndex("maritalStatus");
      if (i != -1) {
        break label6504;
      }
      paramawgp.a(new NoColumnError("maritalStatus", Byte.TYPE));
      label2912:
      i = paramCursor.getColumnIndex("job");
      if (i != -1) {
        break label6520;
      }
      paramawgp.a(new NoColumnError("job", Integer.TYPE));
      label2947:
      i = paramCursor.getColumnIndex("company");
      if (i != -1) {
        break label6535;
      }
      paramawgp.a(new NoColumnError("company", String.class));
      label2982:
      i = paramCursor.getColumnIndex("college");
      if (i != -1) {
        break label6550;
      }
      paramawgp.a(new NoColumnError("college", String.class));
      label3017:
      i = paramCursor.getColumnIndex("hometownCountry");
      if (i != -1) {
        break label6565;
      }
      paramawgp.a(new NoColumnError("hometownCountry", String.class));
      label3052:
      i = paramCursor.getColumnIndex("hometownProvice");
      if (i != -1) {
        break label6580;
      }
      paramawgp.a(new NoColumnError("hometownProvice", String.class));
      label3087:
      i = paramCursor.getColumnIndex("hometownCity");
      if (i != -1) {
        break label6595;
      }
      paramawgp.a(new NoColumnError("hometownCity", String.class));
      label3122:
      i = paramCursor.getColumnIndex("hometownDistrict");
      if (i != -1) {
        break label6610;
      }
      paramawgp.a(new NoColumnError("hometownDistrict", String.class));
      label3157:
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label6625;
      }
      paramawgp.a(new NoColumnError("vCookies", [B.class));
      label3192:
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label6640;
      }
      paramawgp.a(new NoColumnError("bVoted", Byte.TYPE));
      label3227:
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label6656;
      }
      paramawgp.a(new NoColumnError("feedPreviewTime", Long.TYPE));
      label3262:
      i = paramCursor.getColumnIndex("qzoneFeed");
      if (i != -1) {
        break label6671;
      }
      paramawgp.a(new NoColumnError("qzoneFeed", String.class));
      label3297:
      i = paramCursor.getColumnIndex("qzoneName");
      if (i != -1) {
        break label6686;
      }
      paramawgp.a(new NoColumnError("qzoneName", String.class));
      label3332:
      i = paramCursor.getColumnIndex("qzonePicUrl_1");
      if (i != -1) {
        break label6701;
      }
      paramawgp.a(new NoColumnError("qzonePicUrl_1", String.class));
      label3367:
      i = paramCursor.getColumnIndex("qzonePicUrl_2");
      if (i != -1) {
        break label6716;
      }
      paramawgp.a(new NoColumnError("qzonePicUrl_2", String.class));
      label3402:
      i = paramCursor.getColumnIndex("qzonePicUrl_3");
      if (i != -1) {
        break label6731;
      }
      paramawgp.a(new NoColumnError("qzonePicUrl_3", String.class));
      label3437:
      i = paramCursor.getColumnIndex("isPhotoUseCache");
      if (i != -1) {
        break label6746;
      }
      paramawgp.a(new NoColumnError("isPhotoUseCache", Boolean.TYPE));
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label6773;
      }
      paramawgp.a(new NoColumnError("vSeed", [B.class));
      label3507:
      i = paramCursor.getColumnIndex("vTempChatSig");
      if (i != -1) {
        break label6788;
      }
      paramawgp.a(new NoColumnError("vTempChatSig", [B.class));
      label3542:
      i = paramCursor.getColumnIndex("vGroupList");
      if (i != -1) {
        break label6803;
      }
      paramawgp.a(new NoColumnError("vGroupList", [B.class));
      label3577:
      i = paramCursor.getColumnIndex("nearbyInfo");
      if (i != -1) {
        break label6818;
      }
      paramawgp.a(new NoColumnError("nearbyInfo", [B.class));
      label3612:
      i = paramCursor.getColumnIndex("vActivityList");
      if (i != -1) {
        break label6833;
      }
      paramawgp.a(new NoColumnError("vActivityList", [B.class));
      label3647:
      i = paramCursor.getColumnIndex("lUserFlag");
      if (i != -1) {
        break label6848;
      }
      paramawgp.a(new NoColumnError("lUserFlag", Long.TYPE));
      label3682:
      i = paramCursor.getColumnIndex("iIsGodFlag");
      if (i != -1) {
        break label6863;
      }
      paramawgp.a(new NoColumnError("iIsGodFlag", Integer.TYPE));
      label3717:
      i = paramCursor.getColumnIndex("strGodJumpUrl");
      if (i != -1) {
        break label6878;
      }
      paramawgp.a(new NoColumnError("strGodJumpUrl", String.class));
      label3752:
      i = paramCursor.getColumnIndex("mHeartNum");
      if (i != -1) {
        break label6893;
      }
      paramawgp.a(new NoColumnError("mHeartNum", Integer.TYPE));
      label3787:
      i = paramCursor.getColumnIndex("switchQzone");
      if (i != -1) {
        break label6908;
      }
      paramawgp.a(new NoColumnError("switchQzone", Boolean.TYPE));
      i = paramCursor.getColumnIndex("switchHobby");
      if (i != -1) {
        break label6935;
      }
      paramawgp.a(new NoColumnError("switchHobby", Boolean.TYPE));
      i = paramCursor.getColumnIndex("uiShowControl");
      if (i != -1) {
        break label6962;
      }
      paramawgp.a(new NoColumnError("uiShowControl", Long.TYPE));
      label3892:
      i = paramCursor.getColumnIndex("userFlag");
      if (i != -1) {
        break label6977;
      }
      paramawgp.a(new NoColumnError("userFlag", Long.TYPE));
      label3927:
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label6992;
      }
      paramawgp.a(new NoColumnError("busiEntry", String.class));
      label3962:
      i = paramCursor.getColumnIndex("godFlag");
      if (i != -1) {
        break label7007;
      }
      paramawgp.a(new NoColumnError("godFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("nLastGameFlag");
      if (i != -1) {
        break label7034;
      }
      paramawgp.a(new NoColumnError("nLastGameFlag", Integer.TYPE));
      label4032:
      i = paramCursor.getColumnIndex("strProfileUrl");
      if (i != -1) {
        break label7049;
      }
      paramawgp.a(new NoColumnError("strProfileUrl", String.class));
      label4069:
      i = paramCursor.getColumnIndex("lastUpdateNickTime");
      if (i != -1) {
        break label7064;
      }
      paramawgp.a(new NoColumnError("lastUpdateNickTime", Long.TYPE));
      label4106:
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label7079;
      }
      paramawgp.a(new NoColumnError("favoriteSource", Integer.TYPE));
      label4143:
      i = paramCursor.getColumnIndex("switchGiftVisible");
      if (i != -1) {
        break label7094;
      }
      paramawgp.a(new NoColumnError("switchGiftVisible", Long.TYPE));
      label4180:
      i = paramCursor.getColumnIndex("vGiftInfo");
      if (i != -1) {
        break label7109;
      }
      paramawgp.a(new NoColumnError("vGiftInfo", [B.class));
      label4217:
      i = paramCursor.getColumnIndex("sayHelloFlag");
      if (i != -1) {
        break label7124;
      }
      paramawgp.a(new NoColumnError("sayHelloFlag", Integer.TYPE));
      label4254:
      i = paramCursor.getColumnIndex("charm");
      if (i != -1) {
        break label7139;
      }
      paramawgp.a(new NoColumnError("charm", Long.TYPE));
      label4291:
      i = paramCursor.getColumnIndex("charmLevel");
      if (i != -1) {
        break label7154;
      }
      paramawgp.a(new NoColumnError("charmLevel", Integer.TYPE));
      label4328:
      i = paramCursor.getColumnIndex("nextThreshold");
      if (i != -1) {
        break label7169;
      }
      paramawgp.a(new NoColumnError("nextThreshold", Integer.TYPE));
      label4365:
      i = paramCursor.getColumnIndex("curThreshold");
      if (i != -1) {
        break label7184;
      }
      paramawgp.a(new NoColumnError("curThreshold", Integer.TYPE));
      label4402:
      i = paramCursor.getColumnIndex("profPercent");
      if (i != -1) {
        break label7199;
      }
      paramawgp.a(new NoColumnError("profPercent", Integer.TYPE));
      label4439:
      i = paramCursor.getColumnIndex("taskFinished");
      if (i != -1) {
        break label7214;
      }
      paramawgp.a(new NoColumnError("taskFinished", Integer.TYPE));
      label4476:
      i = paramCursor.getColumnIndex("taskTotal");
      if (i != -1) {
        break label7229;
      }
      paramawgp.a(new NoColumnError("taskTotal", Integer.TYPE));
      label4513:
      i = paramCursor.getColumnIndex("hiWanInfo");
      if (i != -1) {
        break label7244;
      }
      paramawgp.a(new NoColumnError("hiWanInfo", String.class));
      label4550:
      i = paramCursor.getColumnIndex("commonLabelString");
      if (i != -1) {
        break label7259;
      }
      paramawgp.a(new NoColumnError("commonLabelString", String.class));
      label4587:
      i = paramCursor.getColumnIndex("tagFlag");
      if (i != -1) {
        break label7274;
      }
      paramawgp.a(new NoColumnError("tagFlag", Long.TYPE));
      label4624:
      i = paramCursor.getColumnIndex("tagInfo");
      if (i != -1) {
        break label7289;
      }
      paramawgp.a(new NoColumnError("tagInfo", String.class));
      label4661:
      i = paramCursor.getColumnIndex("picInfo");
      if (i != -1) {
        break label7304;
      }
      paramawgp.a(new NoColumnError("picInfo", String.class));
      label4698:
      i = paramCursor.getColumnIndex("videoDetails");
      if (i != -1) {
        break label7319;
      }
      paramawgp.a(new NoColumnError("videoDetails", String.class));
      label4735:
      i = paramCursor.getColumnIndex("strFreshNewsInfo");
      if (i != -1) {
        break label7334;
      }
      paramawgp.a(new NoColumnError("strFreshNewsInfo", String.class));
      label4772:
      i = paramCursor.getColumnIndex("strHotChatInfo");
      if (i != -1) {
        break label7349;
      }
      paramawgp.a(new NoColumnError("strHotChatInfo", String.class));
      label4809:
      i = paramCursor.getColumnIndex("uRoomid");
      if (i != -1) {
        break label7364;
      }
      paramawgp.a(new NoColumnError("uRoomid", Long.TYPE));
      label4846:
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label7379;
      }
      paramawgp.a(new NoColumnError("strVoteLimitedNotice", String.class));
      label4883:
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label7394;
      }
      paramawgp.a(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      label4920:
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label7409;
      }
      paramawgp.a(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      label4957:
      i = paramCursor.getColumnIndex("collegeId");
      if (i != -1) {
        break label7424;
      }
      paramawgp.a(new NoColumnError("collegeId", Long.TYPE));
      label4994:
      i = paramCursor.getColumnIndex("videoHeadFlag");
      if (i != -1) {
        break label7439;
      }
      paramawgp.a(new NoColumnError("videoHeadFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("bVideoHeadUrl");
      if (i != -1) {
        break label7466;
      }
      paramawgp.a(new NoColumnError("bVideoHeadUrl", String.class));
      label5068:
      i = paramCursor.getColumnIndex("faceScoreWordingColor");
      if (i != -1) {
        break label7481;
      }
      paramawgp.a(new NoColumnError("faceScoreWordingColor", Integer.TYPE));
      label5105:
      i = paramCursor.getColumnIndex("faceScoreWording");
      if (i != -1) {
        break label7496;
      }
      paramawgp.a(new NoColumnError("faceScoreWording", String.class));
      label5142:
      i = paramCursor.getColumnIndex("faceScoreTailWordingColor");
      if (i != -1) {
        break label7511;
      }
      paramawgp.a(new NoColumnError("faceScoreTailWordingColor", Integer.TYPE));
      label5179:
      i = paramCursor.getColumnIndex("faceScoreTailWording");
      if (i != -1) {
        break label7526;
      }
      paramawgp.a(new NoColumnError("faceScoreTailWording", String.class));
      label5216:
      i = paramCursor.getColumnIndex("faceScoreIconUrl");
      if (i != -1) {
        break label7541;
      }
      paramawgp.a(new NoColumnError("faceScoreIconUrl", String.class));
      label5253:
      i = paramCursor.getColumnIndex("entryAbility");
      if (i != -1) {
        break label7556;
      }
      paramawgp.a(new NoColumnError("entryAbility", Integer.TYPE));
      label5290:
      i = paramCursor.getColumnIndex("strLevelType");
      if (i != -1) {
        break label7571;
      }
      paramawgp.a(new NoColumnError("strLevelType", String.class));
      label5327:
      i = paramCursor.getColumnIndex("maskMsgFlag");
      if (i != -1) {
        break label7586;
      }
      paramawgp.a(new NoColumnError("maskMsgFlag", Integer.TYPE));
      label5364:
      i = paramCursor.getColumnIndex("isForbidSendMsg");
      if (i != -1) {
        break label7601;
      }
      paramawgp.a(new NoColumnError("isForbidSendMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isForbidSendGiftMsg");
      if (i != -1) {
        break label7628;
      }
      paramawgp.a(new NoColumnError("isForbidSendGiftMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("disableSendMsgBtnTips");
      if (i != -1) {
        break label7655;
      }
      paramawgp.a(new NoColumnError("disableSendMsgBtnTips", String.class));
      label5475:
      i = paramCursor.getColumnIndex("disableSendGiftBtnTips");
      if (i != -1) {
        break label7670;
      }
      paramawgp.a(new NoColumnError("disableSendGiftBtnTips", String.class));
      label5512:
      i = paramCursor.getColumnIndex("isForbidSendMsgForTribar");
      if (i != -1) {
        break label7685;
      }
      paramawgp.a(new NoColumnError("isForbidSendMsgForTribar", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isForbidSendGiftMsgForTribar");
      if (i != -1) {
        break label7712;
      }
      paramawgp.a(new NoColumnError("isForbidSendGiftMsgForTribar", Boolean.TYPE));
      i = paramCursor.getColumnIndex("disableSendMsgBtnTipsForTribar");
      if (i != -1) {
        break label7739;
      }
      paramawgp.a(new NoColumnError("disableSendMsgBtnTipsForTribar", String.class));
      label5623:
      i = paramCursor.getColumnIndex("disableSendGiftBtnTipsForTribar");
      if (i != -1) {
        break label7754;
      }
      paramawgp.a(new NoColumnError("disableSendGiftBtnTipsForTribar", String.class));
      label5660:
      i = paramCursor.getColumnIndex("highScoreNum");
      if (i != -1) {
        break label7769;
      }
      paramawgp.a(new NoColumnError("highScoreNum", Integer.TYPE));
      label5697:
      i = paramCursor.getColumnIndex("mHasStory");
      if (i != -1) {
        break label7784;
      }
      paramawgp.a(new NoColumnError("mHasStory", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mQQStoryData");
      if (i != -1) {
        break label7811;
      }
      paramawgp.a(new NoColumnError("mQQStoryData", [B.class));
      label5771:
      i = paramCursor.getColumnIndex("isSendMsgBtnDownloadAppOpen");
      if (i != -1) {
        break label7826;
      }
      paramawgp.a(new NoColumnError("isSendMsgBtnDownloadAppOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sendMsgBtnDownloadAppTips");
      if (i != -1) {
        break label7854;
      }
      paramawgp.a(new NoColumnError("sendMsgBtnDownloadAppTips", String.class));
      label5845:
      i = paramCursor.getColumnIndex("addPicBtnDownloadAppTips");
      if (i != -1) {
        break label7869;
      }
      paramawgp.a(new NoColumnError("addPicBtnDownloadAppTips", String.class));
      label5882:
      i = paramCursor.getColumnIndex("tribeAppDownloadPageUrl");
      if (i != -1) {
        break label7884;
      }
      paramawgp.a(new NoColumnError("tribeAppDownloadPageUrl", String.class));
      label5919:
      i = paramCursor.getColumnIndex("nearbyNowDataBytes");
      if (i != -1) {
        break label7899;
      }
      paramawgp.a(new NoColumnError("nearbyNowDataBytes", [B.class));
      label5956:
      i = paramCursor.getColumnIndex("guideAppNowTip");
      if (i != -1) {
        break label7914;
      }
      paramawgp.a(new NoColumnError("guideAppNowTip", String.class));
      label5993:
      i = paramCursor.getColumnIndex("guideAppNowTipLeftBtn");
      if (i != -1) {
        break label7929;
      }
      paramawgp.a(new NoColumnError("guideAppNowTipLeftBtn", String.class));
      label6030:
      i = paramCursor.getColumnIndex("guideAppNowTipRightBtnInstalled");
      if (i != -1) {
        break label7944;
      }
      paramawgp.a(new NoColumnError("guideAppNowTipRightBtnInstalled", String.class));
      label6067:
      i = paramCursor.getColumnIndex("guideAppNowTipRightBtnNotInstalled");
      if (i != -1) {
        break label7959;
      }
      paramawgp.a(new NoColumnError("guideAppNowTipRightBtnNotInstalled", String.class));
      label6104:
      i = paramCursor.getColumnIndex("guideAppNowPackage");
      if (i != -1) {
        break label7974;
      }
      paramawgp.a(new NoColumnError("guideAppNowPackage", String.class));
      label6141:
      i = paramCursor.getColumnIndex("guideAppNowJumpUri");
      if (i != -1) {
        break label7989;
      }
      paramawgp.a(new NoColumnError("guideAppNowJumpUri", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("guideAppNowDownloadUrl");
      if (i != -1) {
        break label8004;
      }
      paramawgp.a(new NoColumnError("guideAppNowDownloadUrl", String.class));
      return paramawge;
      paramawge.tinyId = paramCursor.getLong(i);
      break;
      label6232:
      paramawge.uin = paramCursor.getString(i);
      break label2282;
      label6247:
      paramawge.nowId = paramCursor.getLong(i);
      break label2317;
      label6262:
      paramawge.nowUserType = paramCursor.getInt(i);
      break label2352;
      label6277:
      paramawge.strRemark = paramCursor.getString(i);
      break label2387;
      label6292:
      paramawge.nickname = paramCursor.getString(i);
      break label2422;
      label6307:
      paramawge.gender = ((byte)paramCursor.getShort(i));
      break label2457;
      label6323:
      paramawge.age = paramCursor.getInt(i);
      break label2492;
      label6338:
      paramawge.birthday = paramCursor.getInt(i);
      break label2527;
      label6353:
      paramawge.constellation = ((byte)paramCursor.getShort(i));
      break label2562;
      label6369:
      paramawge.distance = paramCursor.getString(i);
      break label2597;
      label6384:
      paramawge.timeDiff = paramCursor.getString(i);
      break label2632;
      label6399:
      paramawge.aioDistanceAndTime = paramCursor.getString(i);
      break label2667;
      label6414:
      paramawge.likeCount = paramCursor.getInt(i);
      break label2702;
      label6429:
      paramawge.likeCountInc = paramCursor.getInt(i);
      break label2737;
      label6444:
      paramawge.oldPhotoCount = paramCursor.getInt(i);
      break label2772;
      label6459:
      paramawge.dateInfo = paramCursor.getBlob(i);
      break label2807;
      label6474:
      paramawge.ulShowControl = paramCursor.getLong(i);
      break label2842;
      label6489:
      paramawge.xuanYan = paramCursor.getBlob(i);
      break label2877;
      label6504:
      paramawge.maritalStatus = ((byte)paramCursor.getShort(i));
      break label2912;
      label6520:
      paramawge.job = paramCursor.getInt(i);
      break label2947;
      label6535:
      paramawge.company = paramCursor.getString(i);
      break label2982;
      label6550:
      paramawge.college = paramCursor.getString(i);
      break label3017;
      label6565:
      paramawge.hometownCountry = paramCursor.getString(i);
      break label3052;
      label6580:
      paramawge.hometownProvice = paramCursor.getString(i);
      break label3087;
      label6595:
      paramawge.hometownCity = paramCursor.getString(i);
      break label3122;
      label6610:
      paramawge.hometownDistrict = paramCursor.getString(i);
      break label3157;
      label6625:
      paramawge.vCookies = paramCursor.getBlob(i);
      break label3192;
      label6640:
      paramawge.bVoted = ((byte)paramCursor.getShort(i));
      break label3227;
      label6656:
      paramawge.feedPreviewTime = paramCursor.getLong(i);
      break label3262;
      label6671:
      paramawge.qzoneFeed = paramCursor.getString(i);
      break label3297;
      label6686:
      paramawge.qzoneName = paramCursor.getString(i);
      break label3332;
      label6701:
      paramawge.qzonePicUrl_1 = paramCursor.getString(i);
      break label3367;
      label6716:
      paramawge.qzonePicUrl_2 = paramCursor.getString(i);
      break label3402;
      label6731:
      paramawge.qzonePicUrl_3 = paramCursor.getString(i);
      break label3437;
      label6746:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isPhotoUseCache = paramBoolean;
        break;
      }
      label6773:
      paramawge.vSeed = paramCursor.getBlob(i);
      break label3507;
      label6788:
      paramawge.vTempChatSig = paramCursor.getBlob(i);
      break label3542;
      label6803:
      paramawge.vGroupList = paramCursor.getBlob(i);
      break label3577;
      label6818:
      paramawge.nearbyInfo = paramCursor.getBlob(i);
      break label3612;
      label6833:
      paramawge.vActivityList = paramCursor.getBlob(i);
      break label3647;
      label6848:
      paramawge.lUserFlag = paramCursor.getLong(i);
      break label3682;
      label6863:
      paramawge.iIsGodFlag = paramCursor.getInt(i);
      break label3717;
      label6878:
      paramawge.strGodJumpUrl = paramCursor.getString(i);
      break label3752;
      label6893:
      paramawge.mHeartNum = paramCursor.getInt(i);
      break label3787;
      label6908:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.switchQzone = paramBoolean;
        break;
      }
      label6935:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.switchHobby = paramBoolean;
        break;
      }
      label6962:
      paramawge.uiShowControl = paramCursor.getLong(i);
      break label3892;
      label6977:
      paramawge.userFlag = paramCursor.getLong(i);
      break label3927;
      label6992:
      paramawge.busiEntry = paramCursor.getString(i);
      break label3962;
      label7007:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.godFlag = paramBoolean;
        break;
      }
      label7034:
      paramawge.nLastGameFlag = paramCursor.getInt(i);
      break label4032;
      label7049:
      paramawge.strProfileUrl = paramCursor.getString(i);
      break label4069;
      label7064:
      paramawge.lastUpdateNickTime = paramCursor.getLong(i);
      break label4106;
      label7079:
      paramawge.favoriteSource = paramCursor.getInt(i);
      break label4143;
      label7094:
      paramawge.switchGiftVisible = paramCursor.getLong(i);
      break label4180;
      label7109:
      paramawge.vGiftInfo = paramCursor.getBlob(i);
      break label4217;
      label7124:
      paramawge.sayHelloFlag = paramCursor.getInt(i);
      break label4254;
      label7139:
      paramawge.charm = paramCursor.getLong(i);
      break label4291;
      label7154:
      paramawge.charmLevel = paramCursor.getInt(i);
      break label4328;
      label7169:
      paramawge.nextThreshold = paramCursor.getInt(i);
      break label4365;
      label7184:
      paramawge.curThreshold = paramCursor.getInt(i);
      break label4402;
      label7199:
      paramawge.profPercent = paramCursor.getInt(i);
      break label4439;
      label7214:
      paramawge.taskFinished = paramCursor.getInt(i);
      break label4476;
      label7229:
      paramawge.taskTotal = paramCursor.getInt(i);
      break label4513;
      label7244:
      paramawge.hiWanInfo = paramCursor.getString(i);
      break label4550;
      label7259:
      paramawge.commonLabelString = paramCursor.getString(i);
      break label4587;
      label7274:
      paramawge.tagFlag = paramCursor.getLong(i);
      break label4624;
      label7289:
      paramawge.tagInfo = paramCursor.getString(i);
      break label4661;
      label7304:
      paramawge.picInfo = paramCursor.getString(i);
      break label4698;
      label7319:
      paramawge.videoDetails = paramCursor.getString(i);
      break label4735;
      label7334:
      paramawge.strFreshNewsInfo = paramCursor.getString(i);
      break label4772;
      label7349:
      paramawge.strHotChatInfo = paramCursor.getString(i);
      break label4809;
      label7364:
      paramawge.uRoomid = paramCursor.getLong(i);
      break label4846;
      label7379:
      paramawge.strVoteLimitedNotice = paramCursor.getString(i);
      break label4883;
      label7394:
      paramawge.bHaveVotedCnt = paramCursor.getShort(i);
      break label4920;
      label7409:
      paramawge.bAvailVoteCnt = paramCursor.getShort(i);
      break label4957;
      label7424:
      paramawge.collegeId = paramCursor.getLong(i);
      break label4994;
      label7439:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.videoHeadFlag = paramBoolean;
        break;
      }
      label7466:
      paramawge.bVideoHeadUrl = paramCursor.getString(i);
      break label5068;
      label7481:
      paramawge.faceScoreWordingColor = paramCursor.getInt(i);
      break label5105;
      label7496:
      paramawge.faceScoreWording = paramCursor.getString(i);
      break label5142;
      label7511:
      paramawge.faceScoreTailWordingColor = paramCursor.getInt(i);
      break label5179;
      label7526:
      paramawge.faceScoreTailWording = paramCursor.getString(i);
      break label5216;
      label7541:
      paramawge.faceScoreIconUrl = paramCursor.getString(i);
      break label5253;
      label7556:
      paramawge.entryAbility = paramCursor.getInt(i);
      break label5290;
      label7571:
      paramawge.strLevelType = paramCursor.getString(i);
      break label5327;
      label7586:
      paramawge.maskMsgFlag = paramCursor.getInt(i);
      break label5364;
      label7601:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isForbidSendMsg = paramBoolean;
        break;
      }
      label7628:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isForbidSendGiftMsg = paramBoolean;
        break;
      }
      label7655:
      paramawge.disableSendMsgBtnTips = paramCursor.getString(i);
      break label5475;
      label7670:
      paramawge.disableSendGiftBtnTips = paramCursor.getString(i);
      break label5512;
      label7685:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isForbidSendMsgForTribar = paramBoolean;
        break;
      }
      label7712:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isForbidSendGiftMsgForTribar = paramBoolean;
        break;
      }
      label7739:
      paramawge.disableSendMsgBtnTipsForTribar = paramCursor.getString(i);
      break label5623;
      label7754:
      paramawge.disableSendGiftBtnTipsForTribar = paramCursor.getString(i);
      break label5660;
      label7769:
      paramawge.highScoreNum = paramCursor.getInt(i);
      break label5697;
      label7784:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.mHasStory = paramBoolean;
        break;
      }
      label7811:
      paramawge.mQQStoryData = paramCursor.getBlob(i);
      break label5771;
      label7826:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramawge.isSendMsgBtnDownloadAppOpen = paramBoolean;
        break;
      }
      label7854:
      paramawge.sendMsgBtnDownloadAppTips = paramCursor.getString(i);
      break label5845;
      label7869:
      paramawge.addPicBtnDownloadAppTips = paramCursor.getString(i);
      break label5882;
      label7884:
      paramawge.tribeAppDownloadPageUrl = paramCursor.getString(i);
      break label5919;
      label7899:
      paramawge.nearbyNowDataBytes = paramCursor.getBlob(i);
      break label5956;
      label7914:
      paramawge.guideAppNowTip = paramCursor.getString(i);
      break label5993;
      label7929:
      paramawge.guideAppNowTipLeftBtn = paramCursor.getString(i);
      break label6030;
      label7944:
      paramawge.guideAppNowTipRightBtnInstalled = paramCursor.getString(i);
      break label6067;
      label7959:
      paramawge.guideAppNowTipRightBtnNotInstalled = paramCursor.getString(i);
      break label6104;
      label7974:
      paramawge.guideAppNowPackage = paramCursor.getString(i);
      break label6141;
      label7989:
      paramawge.guideAppNowJumpUri = paramCursor.getString(i);
    }
    label8004:
    paramawge.guideAppNowDownloadUrl = paramCursor.getString(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,tinyId INTEGER ,uin TEXT ,nowId INTEGER ,nowUserType INTEGER ,strRemark TEXT ,nickname TEXT ,gender INTEGER ,age INTEGER ,birthday INTEGER ,constellation INTEGER ,distance TEXT ,timeDiff TEXT ,aioDistanceAndTime TEXT ,likeCount INTEGER ,likeCountInc INTEGER ,oldPhotoCount INTEGER ,dateInfo BLOB ,ulShowControl INTEGER ,xuanYan BLOB ,maritalStatus INTEGER ,job INTEGER ,company TEXT ,college TEXT ,hometownCountry TEXT ,hometownProvice TEXT ,hometownCity TEXT ,hometownDistrict TEXT ,vCookies BLOB ,bVoted INTEGER ,feedPreviewTime INTEGER ,qzoneFeed TEXT ,qzoneName TEXT ,qzonePicUrl_1 TEXT ,qzonePicUrl_2 TEXT ,qzonePicUrl_3 TEXT ,isPhotoUseCache INTEGER ,vSeed BLOB ,vTempChatSig BLOB ,vGroupList BLOB ,nearbyInfo BLOB ,vActivityList BLOB ,lUserFlag INTEGER ,iIsGodFlag INTEGER ,strGodJumpUrl TEXT ,mHeartNum INTEGER ,switchQzone INTEGER ,switchHobby INTEGER ,uiShowControl INTEGER ,userFlag INTEGER ,busiEntry TEXT ,godFlag INTEGER ,nLastGameFlag INTEGER ,strProfileUrl TEXT ,lastUpdateNickTime INTEGER ,favoriteSource INTEGER ,switchGiftVisible INTEGER ,vGiftInfo BLOB ,sayHelloFlag INTEGER ,charm INTEGER ,charmLevel INTEGER ,nextThreshold INTEGER ,curThreshold INTEGER ,profPercent INTEGER ,taskFinished INTEGER ,taskTotal INTEGER ,hiWanInfo TEXT ,commonLabelString TEXT ,tagFlag INTEGER ,tagInfo TEXT ,picInfo TEXT ,videoDetails TEXT ,strFreshNewsInfo TEXT ,strHotChatInfo TEXT ,uRoomid INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,collegeId INTEGER ,videoHeadFlag INTEGER ,bVideoHeadUrl TEXT ,faceScoreWordingColor INTEGER ,faceScoreWording TEXT ,faceScoreTailWordingColor INTEGER ,faceScoreTailWording TEXT ,faceScoreIconUrl TEXT ,entryAbility INTEGER ,strLevelType TEXT ,maskMsgFlag INTEGER ,isForbidSendMsg INTEGER ,isForbidSendGiftMsg INTEGER ,disableSendMsgBtnTips TEXT ,disableSendGiftBtnTips TEXT ,isForbidSendMsgForTribar INTEGER ,isForbidSendGiftMsgForTribar INTEGER ,disableSendMsgBtnTipsForTribar TEXT ,disableSendGiftBtnTipsForTribar TEXT ,highScoreNum INTEGER ,mHasStory INTEGER ,mQQStoryData BLOB ,isSendMsgBtnDownloadAppOpen INTEGER ,sendMsgBtnDownloadAppTips TEXT ,addPicBtnDownloadAppTips TEXT ,tribeAppDownloadPageUrl TEXT ,nearbyNowDataBytes BLOB ,guideAppNowTip TEXT ,guideAppNowTipLeftBtn TEXT ,guideAppNowTipRightBtnInstalled TEXT ,guideAppNowTipRightBtnNotInstalled TEXT ,guideAppNowPackage TEXT ,guideAppNowJumpUri TEXT ,guideAppNowDownloadUrl TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (NearbyPeopleCard)paramawge;
    paramContentValues.put("tinyId", Long.valueOf(paramawge.tinyId));
    paramContentValues.put("uin", paramawge.uin);
    paramContentValues.put("nowId", Long.valueOf(paramawge.nowId));
    paramContentValues.put("nowUserType", Integer.valueOf(paramawge.nowUserType));
    paramContentValues.put("strRemark", paramawge.strRemark);
    paramContentValues.put("nickname", paramawge.nickname);
    paramContentValues.put("gender", Byte.valueOf(paramawge.gender));
    paramContentValues.put("age", Integer.valueOf(paramawge.age));
    paramContentValues.put("birthday", Integer.valueOf(paramawge.birthday));
    paramContentValues.put("constellation", Byte.valueOf(paramawge.constellation));
    paramContentValues.put("distance", paramawge.distance);
    paramContentValues.put("timeDiff", paramawge.timeDiff);
    paramContentValues.put("aioDistanceAndTime", paramawge.aioDistanceAndTime);
    paramContentValues.put("likeCount", Integer.valueOf(paramawge.likeCount));
    paramContentValues.put("likeCountInc", Integer.valueOf(paramawge.likeCountInc));
    paramContentValues.put("oldPhotoCount", Integer.valueOf(paramawge.oldPhotoCount));
    paramContentValues.put("dateInfo", paramawge.dateInfo);
    paramContentValues.put("ulShowControl", Long.valueOf(paramawge.ulShowControl));
    paramContentValues.put("xuanYan", paramawge.xuanYan);
    paramContentValues.put("maritalStatus", Byte.valueOf(paramawge.maritalStatus));
    paramContentValues.put("job", Integer.valueOf(paramawge.job));
    paramContentValues.put("company", paramawge.company);
    paramContentValues.put("college", paramawge.college);
    paramContentValues.put("hometownCountry", paramawge.hometownCountry);
    paramContentValues.put("hometownProvice", paramawge.hometownProvice);
    paramContentValues.put("hometownCity", paramawge.hometownCity);
    paramContentValues.put("hometownDistrict", paramawge.hometownDistrict);
    paramContentValues.put("vCookies", paramawge.vCookies);
    paramContentValues.put("bVoted", Byte.valueOf(paramawge.bVoted));
    paramContentValues.put("feedPreviewTime", Long.valueOf(paramawge.feedPreviewTime));
    paramContentValues.put("qzoneFeed", paramawge.qzoneFeed);
    paramContentValues.put("qzoneName", paramawge.qzoneName);
    paramContentValues.put("qzonePicUrl_1", paramawge.qzonePicUrl_1);
    paramContentValues.put("qzonePicUrl_2", paramawge.qzonePicUrl_2);
    paramContentValues.put("qzonePicUrl_3", paramawge.qzonePicUrl_3);
    paramContentValues.put("isPhotoUseCache", Boolean.valueOf(paramawge.isPhotoUseCache));
    paramContentValues.put("vSeed", paramawge.vSeed);
    paramContentValues.put("vTempChatSig", paramawge.vTempChatSig);
    paramContentValues.put("vGroupList", paramawge.vGroupList);
    paramContentValues.put("nearbyInfo", paramawge.nearbyInfo);
    paramContentValues.put("vActivityList", paramawge.vActivityList);
    paramContentValues.put("lUserFlag", Long.valueOf(paramawge.lUserFlag));
    paramContentValues.put("iIsGodFlag", Integer.valueOf(paramawge.iIsGodFlag));
    paramContentValues.put("strGodJumpUrl", paramawge.strGodJumpUrl);
    paramContentValues.put("mHeartNum", Integer.valueOf(paramawge.mHeartNum));
    paramContentValues.put("switchQzone", Boolean.valueOf(paramawge.switchQzone));
    paramContentValues.put("switchHobby", Boolean.valueOf(paramawge.switchHobby));
    paramContentValues.put("uiShowControl", Long.valueOf(paramawge.uiShowControl));
    paramContentValues.put("userFlag", Long.valueOf(paramawge.userFlag));
    paramContentValues.put("busiEntry", paramawge.busiEntry);
    paramContentValues.put("godFlag", Boolean.valueOf(paramawge.godFlag));
    paramContentValues.put("nLastGameFlag", Integer.valueOf(paramawge.nLastGameFlag));
    paramContentValues.put("strProfileUrl", paramawge.strProfileUrl);
    paramContentValues.put("lastUpdateNickTime", Long.valueOf(paramawge.lastUpdateNickTime));
    paramContentValues.put("favoriteSource", Integer.valueOf(paramawge.favoriteSource));
    paramContentValues.put("switchGiftVisible", Long.valueOf(paramawge.switchGiftVisible));
    paramContentValues.put("vGiftInfo", paramawge.vGiftInfo);
    paramContentValues.put("sayHelloFlag", Integer.valueOf(paramawge.sayHelloFlag));
    paramContentValues.put("charm", Long.valueOf(paramawge.charm));
    paramContentValues.put("charmLevel", Integer.valueOf(paramawge.charmLevel));
    paramContentValues.put("nextThreshold", Integer.valueOf(paramawge.nextThreshold));
    paramContentValues.put("curThreshold", Integer.valueOf(paramawge.curThreshold));
    paramContentValues.put("profPercent", Integer.valueOf(paramawge.profPercent));
    paramContentValues.put("taskFinished", Integer.valueOf(paramawge.taskFinished));
    paramContentValues.put("taskTotal", Integer.valueOf(paramawge.taskTotal));
    paramContentValues.put("hiWanInfo", paramawge.hiWanInfo);
    paramContentValues.put("commonLabelString", paramawge.commonLabelString);
    paramContentValues.put("tagFlag", Long.valueOf(paramawge.tagFlag));
    paramContentValues.put("tagInfo", paramawge.tagInfo);
    paramContentValues.put("picInfo", paramawge.picInfo);
    paramContentValues.put("videoDetails", paramawge.videoDetails);
    paramContentValues.put("strFreshNewsInfo", paramawge.strFreshNewsInfo);
    paramContentValues.put("strHotChatInfo", paramawge.strHotChatInfo);
    paramContentValues.put("uRoomid", Long.valueOf(paramawge.uRoomid));
    paramContentValues.put("strVoteLimitedNotice", paramawge.strVoteLimitedNotice);
    paramContentValues.put("bHaveVotedCnt", Short.valueOf(paramawge.bHaveVotedCnt));
    paramContentValues.put("bAvailVoteCnt", Short.valueOf(paramawge.bAvailVoteCnt));
    paramContentValues.put("collegeId", Long.valueOf(paramawge.collegeId));
    paramContentValues.put("videoHeadFlag", Boolean.valueOf(paramawge.videoHeadFlag));
    paramContentValues.put("bVideoHeadUrl", paramawge.bVideoHeadUrl);
    paramContentValues.put("faceScoreWordingColor", Integer.valueOf(paramawge.faceScoreWordingColor));
    paramContentValues.put("faceScoreWording", paramawge.faceScoreWording);
    paramContentValues.put("faceScoreTailWordingColor", Integer.valueOf(paramawge.faceScoreTailWordingColor));
    paramContentValues.put("faceScoreTailWording", paramawge.faceScoreTailWording);
    paramContentValues.put("faceScoreIconUrl", paramawge.faceScoreIconUrl);
    paramContentValues.put("entryAbility", Integer.valueOf(paramawge.entryAbility));
    paramContentValues.put("strLevelType", paramawge.strLevelType);
    paramContentValues.put("maskMsgFlag", Integer.valueOf(paramawge.maskMsgFlag));
    paramContentValues.put("isForbidSendMsg", Boolean.valueOf(paramawge.isForbidSendMsg));
    paramContentValues.put("isForbidSendGiftMsg", Boolean.valueOf(paramawge.isForbidSendGiftMsg));
    paramContentValues.put("disableSendMsgBtnTips", paramawge.disableSendMsgBtnTips);
    paramContentValues.put("disableSendGiftBtnTips", paramawge.disableSendGiftBtnTips);
    paramContentValues.put("isForbidSendMsgForTribar", Boolean.valueOf(paramawge.isForbidSendMsgForTribar));
    paramContentValues.put("isForbidSendGiftMsgForTribar", Boolean.valueOf(paramawge.isForbidSendGiftMsgForTribar));
    paramContentValues.put("disableSendMsgBtnTipsForTribar", paramawge.disableSendMsgBtnTipsForTribar);
    paramContentValues.put("disableSendGiftBtnTipsForTribar", paramawge.disableSendGiftBtnTipsForTribar);
    paramContentValues.put("highScoreNum", Integer.valueOf(paramawge.highScoreNum));
    paramContentValues.put("mHasStory", Boolean.valueOf(paramawge.mHasStory));
    paramContentValues.put("mQQStoryData", paramawge.mQQStoryData);
    paramContentValues.put("isSendMsgBtnDownloadAppOpen", Boolean.valueOf(paramawge.isSendMsgBtnDownloadAppOpen));
    paramContentValues.put("sendMsgBtnDownloadAppTips", paramawge.sendMsgBtnDownloadAppTips);
    paramContentValues.put("addPicBtnDownloadAppTips", paramawge.addPicBtnDownloadAppTips);
    paramContentValues.put("tribeAppDownloadPageUrl", paramawge.tribeAppDownloadPageUrl);
    paramContentValues.put("nearbyNowDataBytes", paramawge.nearbyNowDataBytes);
    paramContentValues.put("guideAppNowTip", paramawge.guideAppNowTip);
    paramContentValues.put("guideAppNowTipLeftBtn", paramawge.guideAppNowTipLeftBtn);
    paramContentValues.put("guideAppNowTipRightBtnInstalled", paramawge.guideAppNowTipRightBtnInstalled);
    paramContentValues.put("guideAppNowTipRightBtnNotInstalled", paramawge.guideAppNowTipRightBtnNotInstalled);
    paramContentValues.put("guideAppNowPackage", paramawge.guideAppNowPackage);
    paramContentValues.put("guideAppNowJumpUri", paramawge.guideAppNowJumpUri);
    paramContentValues.put("guideAppNowDownloadUrl", paramawge.guideAppNowDownloadUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awgo
 * JD-Core Version:    0.7.0.1
 */