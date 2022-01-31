import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.persistence.NoColumnError;

public class auky
  extends aula
{
  public auky()
  {
    this.a = 111;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramauko = (NearbyPeopleCard)paramauko;
    if (paramaukz == null)
    {
      paramauko.tinyId = paramCursor.getLong(paramCursor.getColumnIndex("tinyId"));
      paramauko.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramauko.nowId = paramCursor.getLong(paramCursor.getColumnIndex("nowId"));
      paramauko.nowUserType = paramCursor.getInt(paramCursor.getColumnIndex("nowUserType"));
      paramauko.strRemark = paramCursor.getString(paramCursor.getColumnIndex("strRemark"));
      paramauko.nickname = paramCursor.getString(paramCursor.getColumnIndex("nickname"));
      paramauko.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
      paramauko.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
      paramauko.birthday = paramCursor.getInt(paramCursor.getColumnIndex("birthday"));
      paramauko.constellation = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("constellation")));
      paramauko.distance = paramCursor.getString(paramCursor.getColumnIndex("distance"));
      paramauko.timeDiff = paramCursor.getString(paramCursor.getColumnIndex("timeDiff"));
      paramauko.aioDistanceAndTime = paramCursor.getString(paramCursor.getColumnIndex("aioDistanceAndTime"));
      paramauko.likeCount = paramCursor.getInt(paramCursor.getColumnIndex("likeCount"));
      paramauko.likeCountInc = paramCursor.getInt(paramCursor.getColumnIndex("likeCountInc"));
      paramauko.oldPhotoCount = paramCursor.getInt(paramCursor.getColumnIndex("oldPhotoCount"));
      paramauko.dateInfo = paramCursor.getBlob(paramCursor.getColumnIndex("dateInfo"));
      paramauko.ulShowControl = paramCursor.getLong(paramCursor.getColumnIndex("ulShowControl"));
      paramauko.xuanYan = paramCursor.getBlob(paramCursor.getColumnIndex("xuanYan"));
      paramauko.maritalStatus = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("maritalStatus")));
      paramauko.job = paramCursor.getInt(paramCursor.getColumnIndex("job"));
      paramauko.company = paramCursor.getString(paramCursor.getColumnIndex("company"));
      paramauko.college = paramCursor.getString(paramCursor.getColumnIndex("college"));
      paramauko.hometownCountry = paramCursor.getString(paramCursor.getColumnIndex("hometownCountry"));
      paramauko.hometownProvice = paramCursor.getString(paramCursor.getColumnIndex("hometownProvice"));
      paramauko.hometownCity = paramCursor.getString(paramCursor.getColumnIndex("hometownCity"));
      paramauko.hometownDistrict = paramCursor.getString(paramCursor.getColumnIndex("hometownDistrict"));
      paramauko.vCookies = paramCursor.getBlob(paramCursor.getColumnIndex("vCookies"));
      paramauko.bVoted = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bVoted")));
      paramauko.feedPreviewTime = paramCursor.getLong(paramCursor.getColumnIndex("feedPreviewTime"));
      paramauko.qzoneFeed = paramCursor.getString(paramCursor.getColumnIndex("qzoneFeed"));
      paramauko.qzoneName = paramCursor.getString(paramCursor.getColumnIndex("qzoneName"));
      paramauko.qzonePicUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_1"));
      paramauko.qzonePicUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_2"));
      paramauko.qzonePicUrl_3 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_3"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isPhotoUseCache")))
      {
        paramBoolean = true;
        paramauko.isPhotoUseCache = paramBoolean;
        paramauko.vSeed = paramCursor.getBlob(paramCursor.getColumnIndex("vSeed"));
        paramauko.vTempChatSig = paramCursor.getBlob(paramCursor.getColumnIndex("vTempChatSig"));
        paramauko.vGroupList = paramCursor.getBlob(paramCursor.getColumnIndex("vGroupList"));
        paramauko.nearbyInfo = paramCursor.getBlob(paramCursor.getColumnIndex("nearbyInfo"));
        paramauko.vActivityList = paramCursor.getBlob(paramCursor.getColumnIndex("vActivityList"));
        paramauko.lUserFlag = paramCursor.getLong(paramCursor.getColumnIndex("lUserFlag"));
        paramauko.iIsGodFlag = paramCursor.getInt(paramCursor.getColumnIndex("iIsGodFlag"));
        paramauko.strGodJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("strGodJumpUrl"));
        paramauko.mHeartNum = paramCursor.getInt(paramCursor.getColumnIndex("mHeartNum"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("switchQzone"))) {
          break label2162;
        }
        paramBoolean = true;
        label857:
        paramauko.switchQzone = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("switchHobby"))) {
          break label2167;
        }
        paramBoolean = true;
        label882:
        paramauko.switchHobby = paramBoolean;
        paramauko.uiShowControl = paramCursor.getLong(paramCursor.getColumnIndex("uiShowControl"));
        paramauko.userFlag = paramCursor.getLong(paramCursor.getColumnIndex("userFlag"));
        paramauko.busiEntry = paramCursor.getString(paramCursor.getColumnIndex("busiEntry"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("godFlag"))) {
          break label2172;
        }
        paramBoolean = true;
        label961:
        paramauko.godFlag = paramBoolean;
        paramauko.nLastGameFlag = paramCursor.getInt(paramCursor.getColumnIndex("nLastGameFlag"));
        paramauko.strProfileUrl = paramCursor.getString(paramCursor.getColumnIndex("strProfileUrl"));
        paramauko.lastUpdateNickTime = paramCursor.getLong(paramCursor.getColumnIndex("lastUpdateNickTime"));
        paramauko.favoriteSource = paramCursor.getInt(paramCursor.getColumnIndex("favoriteSource"));
        paramauko.switchGiftVisible = paramCursor.getLong(paramCursor.getColumnIndex("switchGiftVisible"));
        paramauko.vGiftInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vGiftInfo"));
        paramauko.sayHelloFlag = paramCursor.getInt(paramCursor.getColumnIndex("sayHelloFlag"));
        paramauko.charm = paramCursor.getLong(paramCursor.getColumnIndex("charm"));
        paramauko.charmLevel = paramCursor.getInt(paramCursor.getColumnIndex("charmLevel"));
        paramauko.nextThreshold = paramCursor.getInt(paramCursor.getColumnIndex("nextThreshold"));
        paramauko.curThreshold = paramCursor.getInt(paramCursor.getColumnIndex("curThreshold"));
        paramauko.profPercent = paramCursor.getInt(paramCursor.getColumnIndex("profPercent"));
        paramauko.taskFinished = paramCursor.getInt(paramCursor.getColumnIndex("taskFinished"));
        paramauko.taskTotal = paramCursor.getInt(paramCursor.getColumnIndex("taskTotal"));
        paramauko.hiWanInfo = paramCursor.getString(paramCursor.getColumnIndex("hiWanInfo"));
        paramauko.commonLabelString = paramCursor.getString(paramCursor.getColumnIndex("commonLabelString"));
        paramauko.tagFlag = paramCursor.getLong(paramCursor.getColumnIndex("tagFlag"));
        paramauko.tagInfo = paramCursor.getString(paramCursor.getColumnIndex("tagInfo"));
        paramauko.picInfo = paramCursor.getString(paramCursor.getColumnIndex("picInfo"));
        paramauko.videoDetails = paramCursor.getString(paramCursor.getColumnIndex("videoDetails"));
        paramauko.strFreshNewsInfo = paramCursor.getString(paramCursor.getColumnIndex("strFreshNewsInfo"));
        paramauko.strHotChatInfo = paramCursor.getString(paramCursor.getColumnIndex("strHotChatInfo"));
        paramauko.uRoomid = paramCursor.getLong(paramCursor.getColumnIndex("uRoomid"));
        paramauko.strVoteLimitedNotice = paramCursor.getString(paramCursor.getColumnIndex("strVoteLimitedNotice"));
        paramauko.bHaveVotedCnt = paramCursor.getShort(paramCursor.getColumnIndex("bHaveVotedCnt"));
        paramauko.bAvailVoteCnt = paramCursor.getShort(paramCursor.getColumnIndex("bAvailVoteCnt"));
        paramauko.collegeId = paramCursor.getLong(paramCursor.getColumnIndex("collegeId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("videoHeadFlag"))) {
          break label2177;
        }
        paramBoolean = true;
        label1499:
        paramauko.videoHeadFlag = paramBoolean;
        paramauko.bVideoHeadUrl = paramCursor.getString(paramCursor.getColumnIndex("bVideoHeadUrl"));
        paramauko.faceScoreWordingColor = paramCursor.getInt(paramCursor.getColumnIndex("faceScoreWordingColor"));
        paramauko.faceScoreWording = paramCursor.getString(paramCursor.getColumnIndex("faceScoreWording"));
        paramauko.faceScoreTailWordingColor = paramCursor.getInt(paramCursor.getColumnIndex("faceScoreTailWordingColor"));
        paramauko.faceScoreTailWording = paramCursor.getString(paramCursor.getColumnIndex("faceScoreTailWording"));
        paramauko.faceScoreIconUrl = paramCursor.getString(paramCursor.getColumnIndex("faceScoreIconUrl"));
        paramauko.entryAbility = paramCursor.getInt(paramCursor.getColumnIndex("entryAbility"));
        paramauko.strLevelType = paramCursor.getString(paramCursor.getColumnIndex("strLevelType"));
        paramauko.maskMsgFlag = paramCursor.getInt(paramCursor.getColumnIndex("maskMsgFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendMsg"))) {
          break label2182;
        }
        paramBoolean = true;
        label1696:
        paramauko.isForbidSendMsg = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendGiftMsg"))) {
          break label2187;
        }
        paramBoolean = true;
        label1722:
        paramauko.isForbidSendGiftMsg = paramBoolean;
        paramauko.disableSendMsgBtnTips = paramCursor.getString(paramCursor.getColumnIndex("disableSendMsgBtnTips"));
        paramauko.disableSendGiftBtnTips = paramCursor.getString(paramCursor.getColumnIndex("disableSendGiftBtnTips"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendMsgForTribar"))) {
          break label2192;
        }
        paramBoolean = true;
        label1786:
        paramauko.isForbidSendMsgForTribar = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendGiftMsgForTribar"))) {
          break label2197;
        }
        paramBoolean = true;
        label1812:
        paramauko.isForbidSendGiftMsgForTribar = paramBoolean;
        paramauko.disableSendMsgBtnTipsForTribar = paramCursor.getString(paramCursor.getColumnIndex("disableSendMsgBtnTipsForTribar"));
        paramauko.disableSendGiftBtnTipsForTribar = paramCursor.getString(paramCursor.getColumnIndex("disableSendGiftBtnTipsForTribar"));
        paramauko.highScoreNum = paramCursor.getInt(paramCursor.getColumnIndex("highScoreNum"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mHasStory"))) {
          break label2202;
        }
        paramBoolean = true;
        label1895:
        paramauko.mHasStory = paramBoolean;
        paramauko.mQQStoryData = paramCursor.getBlob(paramCursor.getColumnIndex("mQQStoryData"));
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
        paramauko.isSendMsgBtnDownloadAppOpen = paramBoolean;
        paramauko.sendMsgBtnDownloadAppTips = paramCursor.getString(paramCursor.getColumnIndex("sendMsgBtnDownloadAppTips"));
        paramauko.addPicBtnDownloadAppTips = paramCursor.getString(paramCursor.getColumnIndex("addPicBtnDownloadAppTips"));
        paramauko.tribeAppDownloadPageUrl = paramCursor.getString(paramCursor.getColumnIndex("tribeAppDownloadPageUrl"));
        paramauko.nearbyNowDataBytes = paramCursor.getBlob(paramCursor.getColumnIndex("nearbyNowDataBytes"));
        paramauko.guideAppNowTip = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTip"));
        paramauko.guideAppNowTipLeftBtn = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTipLeftBtn"));
        paramauko.guideAppNowTipRightBtnInstalled = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTipRightBtnInstalled"));
        paramauko.guideAppNowTipRightBtnNotInstalled = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTipRightBtnNotInstalled"));
        paramauko.guideAppNowPackage = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowPackage"));
        paramauko.guideAppNowJumpUri = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowJumpUri"));
        paramauko.guideAppNowDownloadUrl = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowDownloadUrl"));
        return paramauko;
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
      paramaukz.a(new NoColumnError("tinyId", Long.TYPE));
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label6232;
      }
      paramaukz.a(new NoColumnError("uin", String.class));
      label2282:
      i = paramCursor.getColumnIndex("nowId");
      if (i != -1) {
        break label6247;
      }
      paramaukz.a(new NoColumnError("nowId", Long.TYPE));
      label2317:
      i = paramCursor.getColumnIndex("nowUserType");
      if (i != -1) {
        break label6262;
      }
      paramaukz.a(new NoColumnError("nowUserType", Integer.TYPE));
      label2352:
      i = paramCursor.getColumnIndex("strRemark");
      if (i != -1) {
        break label6277;
      }
      paramaukz.a(new NoColumnError("strRemark", String.class));
      label2387:
      i = paramCursor.getColumnIndex("nickname");
      if (i != -1) {
        break label6292;
      }
      paramaukz.a(new NoColumnError("nickname", String.class));
      label2422:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label6307;
      }
      paramaukz.a(new NoColumnError("gender", Byte.TYPE));
      label2457:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label6323;
      }
      paramaukz.a(new NoColumnError("age", Integer.TYPE));
      label2492:
      i = paramCursor.getColumnIndex("birthday");
      if (i != -1) {
        break label6338;
      }
      paramaukz.a(new NoColumnError("birthday", Integer.TYPE));
      label2527:
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label6353;
      }
      paramaukz.a(new NoColumnError("constellation", Byte.TYPE));
      label2562:
      i = paramCursor.getColumnIndex("distance");
      if (i != -1) {
        break label6369;
      }
      paramaukz.a(new NoColumnError("distance", String.class));
      label2597:
      i = paramCursor.getColumnIndex("timeDiff");
      if (i != -1) {
        break label6384;
      }
      paramaukz.a(new NoColumnError("timeDiff", String.class));
      label2632:
      i = paramCursor.getColumnIndex("aioDistanceAndTime");
      if (i != -1) {
        break label6399;
      }
      paramaukz.a(new NoColumnError("aioDistanceAndTime", String.class));
      label2667:
      i = paramCursor.getColumnIndex("likeCount");
      if (i != -1) {
        break label6414;
      }
      paramaukz.a(new NoColumnError("likeCount", Integer.TYPE));
      label2702:
      i = paramCursor.getColumnIndex("likeCountInc");
      if (i != -1) {
        break label6429;
      }
      paramaukz.a(new NoColumnError("likeCountInc", Integer.TYPE));
      label2737:
      i = paramCursor.getColumnIndex("oldPhotoCount");
      if (i != -1) {
        break label6444;
      }
      paramaukz.a(new NoColumnError("oldPhotoCount", Integer.TYPE));
      label2772:
      i = paramCursor.getColumnIndex("dateInfo");
      if (i != -1) {
        break label6459;
      }
      paramaukz.a(new NoColumnError("dateInfo", [B.class));
      label2807:
      i = paramCursor.getColumnIndex("ulShowControl");
      if (i != -1) {
        break label6474;
      }
      paramaukz.a(new NoColumnError("ulShowControl", Long.TYPE));
      label2842:
      i = paramCursor.getColumnIndex("xuanYan");
      if (i != -1) {
        break label6489;
      }
      paramaukz.a(new NoColumnError("xuanYan", [B.class));
      label2877:
      i = paramCursor.getColumnIndex("maritalStatus");
      if (i != -1) {
        break label6504;
      }
      paramaukz.a(new NoColumnError("maritalStatus", Byte.TYPE));
      label2912:
      i = paramCursor.getColumnIndex("job");
      if (i != -1) {
        break label6520;
      }
      paramaukz.a(new NoColumnError("job", Integer.TYPE));
      label2947:
      i = paramCursor.getColumnIndex("company");
      if (i != -1) {
        break label6535;
      }
      paramaukz.a(new NoColumnError("company", String.class));
      label2982:
      i = paramCursor.getColumnIndex("college");
      if (i != -1) {
        break label6550;
      }
      paramaukz.a(new NoColumnError("college", String.class));
      label3017:
      i = paramCursor.getColumnIndex("hometownCountry");
      if (i != -1) {
        break label6565;
      }
      paramaukz.a(new NoColumnError("hometownCountry", String.class));
      label3052:
      i = paramCursor.getColumnIndex("hometownProvice");
      if (i != -1) {
        break label6580;
      }
      paramaukz.a(new NoColumnError("hometownProvice", String.class));
      label3087:
      i = paramCursor.getColumnIndex("hometownCity");
      if (i != -1) {
        break label6595;
      }
      paramaukz.a(new NoColumnError("hometownCity", String.class));
      label3122:
      i = paramCursor.getColumnIndex("hometownDistrict");
      if (i != -1) {
        break label6610;
      }
      paramaukz.a(new NoColumnError("hometownDistrict", String.class));
      label3157:
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label6625;
      }
      paramaukz.a(new NoColumnError("vCookies", [B.class));
      label3192:
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label6640;
      }
      paramaukz.a(new NoColumnError("bVoted", Byte.TYPE));
      label3227:
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label6656;
      }
      paramaukz.a(new NoColumnError("feedPreviewTime", Long.TYPE));
      label3262:
      i = paramCursor.getColumnIndex("qzoneFeed");
      if (i != -1) {
        break label6671;
      }
      paramaukz.a(new NoColumnError("qzoneFeed", String.class));
      label3297:
      i = paramCursor.getColumnIndex("qzoneName");
      if (i != -1) {
        break label6686;
      }
      paramaukz.a(new NoColumnError("qzoneName", String.class));
      label3332:
      i = paramCursor.getColumnIndex("qzonePicUrl_1");
      if (i != -1) {
        break label6701;
      }
      paramaukz.a(new NoColumnError("qzonePicUrl_1", String.class));
      label3367:
      i = paramCursor.getColumnIndex("qzonePicUrl_2");
      if (i != -1) {
        break label6716;
      }
      paramaukz.a(new NoColumnError("qzonePicUrl_2", String.class));
      label3402:
      i = paramCursor.getColumnIndex("qzonePicUrl_3");
      if (i != -1) {
        break label6731;
      }
      paramaukz.a(new NoColumnError("qzonePicUrl_3", String.class));
      label3437:
      i = paramCursor.getColumnIndex("isPhotoUseCache");
      if (i != -1) {
        break label6746;
      }
      paramaukz.a(new NoColumnError("isPhotoUseCache", Boolean.TYPE));
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label6773;
      }
      paramaukz.a(new NoColumnError("vSeed", [B.class));
      label3507:
      i = paramCursor.getColumnIndex("vTempChatSig");
      if (i != -1) {
        break label6788;
      }
      paramaukz.a(new NoColumnError("vTempChatSig", [B.class));
      label3542:
      i = paramCursor.getColumnIndex("vGroupList");
      if (i != -1) {
        break label6803;
      }
      paramaukz.a(new NoColumnError("vGroupList", [B.class));
      label3577:
      i = paramCursor.getColumnIndex("nearbyInfo");
      if (i != -1) {
        break label6818;
      }
      paramaukz.a(new NoColumnError("nearbyInfo", [B.class));
      label3612:
      i = paramCursor.getColumnIndex("vActivityList");
      if (i != -1) {
        break label6833;
      }
      paramaukz.a(new NoColumnError("vActivityList", [B.class));
      label3647:
      i = paramCursor.getColumnIndex("lUserFlag");
      if (i != -1) {
        break label6848;
      }
      paramaukz.a(new NoColumnError("lUserFlag", Long.TYPE));
      label3682:
      i = paramCursor.getColumnIndex("iIsGodFlag");
      if (i != -1) {
        break label6863;
      }
      paramaukz.a(new NoColumnError("iIsGodFlag", Integer.TYPE));
      label3717:
      i = paramCursor.getColumnIndex("strGodJumpUrl");
      if (i != -1) {
        break label6878;
      }
      paramaukz.a(new NoColumnError("strGodJumpUrl", String.class));
      label3752:
      i = paramCursor.getColumnIndex("mHeartNum");
      if (i != -1) {
        break label6893;
      }
      paramaukz.a(new NoColumnError("mHeartNum", Integer.TYPE));
      label3787:
      i = paramCursor.getColumnIndex("switchQzone");
      if (i != -1) {
        break label6908;
      }
      paramaukz.a(new NoColumnError("switchQzone", Boolean.TYPE));
      i = paramCursor.getColumnIndex("switchHobby");
      if (i != -1) {
        break label6935;
      }
      paramaukz.a(new NoColumnError("switchHobby", Boolean.TYPE));
      i = paramCursor.getColumnIndex("uiShowControl");
      if (i != -1) {
        break label6962;
      }
      paramaukz.a(new NoColumnError("uiShowControl", Long.TYPE));
      label3892:
      i = paramCursor.getColumnIndex("userFlag");
      if (i != -1) {
        break label6977;
      }
      paramaukz.a(new NoColumnError("userFlag", Long.TYPE));
      label3927:
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label6992;
      }
      paramaukz.a(new NoColumnError("busiEntry", String.class));
      label3962:
      i = paramCursor.getColumnIndex("godFlag");
      if (i != -1) {
        break label7007;
      }
      paramaukz.a(new NoColumnError("godFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("nLastGameFlag");
      if (i != -1) {
        break label7034;
      }
      paramaukz.a(new NoColumnError("nLastGameFlag", Integer.TYPE));
      label4032:
      i = paramCursor.getColumnIndex("strProfileUrl");
      if (i != -1) {
        break label7049;
      }
      paramaukz.a(new NoColumnError("strProfileUrl", String.class));
      label4069:
      i = paramCursor.getColumnIndex("lastUpdateNickTime");
      if (i != -1) {
        break label7064;
      }
      paramaukz.a(new NoColumnError("lastUpdateNickTime", Long.TYPE));
      label4106:
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label7079;
      }
      paramaukz.a(new NoColumnError("favoriteSource", Integer.TYPE));
      label4143:
      i = paramCursor.getColumnIndex("switchGiftVisible");
      if (i != -1) {
        break label7094;
      }
      paramaukz.a(new NoColumnError("switchGiftVisible", Long.TYPE));
      label4180:
      i = paramCursor.getColumnIndex("vGiftInfo");
      if (i != -1) {
        break label7109;
      }
      paramaukz.a(new NoColumnError("vGiftInfo", [B.class));
      label4217:
      i = paramCursor.getColumnIndex("sayHelloFlag");
      if (i != -1) {
        break label7124;
      }
      paramaukz.a(new NoColumnError("sayHelloFlag", Integer.TYPE));
      label4254:
      i = paramCursor.getColumnIndex("charm");
      if (i != -1) {
        break label7139;
      }
      paramaukz.a(new NoColumnError("charm", Long.TYPE));
      label4291:
      i = paramCursor.getColumnIndex("charmLevel");
      if (i != -1) {
        break label7154;
      }
      paramaukz.a(new NoColumnError("charmLevel", Integer.TYPE));
      label4328:
      i = paramCursor.getColumnIndex("nextThreshold");
      if (i != -1) {
        break label7169;
      }
      paramaukz.a(new NoColumnError("nextThreshold", Integer.TYPE));
      label4365:
      i = paramCursor.getColumnIndex("curThreshold");
      if (i != -1) {
        break label7184;
      }
      paramaukz.a(new NoColumnError("curThreshold", Integer.TYPE));
      label4402:
      i = paramCursor.getColumnIndex("profPercent");
      if (i != -1) {
        break label7199;
      }
      paramaukz.a(new NoColumnError("profPercent", Integer.TYPE));
      label4439:
      i = paramCursor.getColumnIndex("taskFinished");
      if (i != -1) {
        break label7214;
      }
      paramaukz.a(new NoColumnError("taskFinished", Integer.TYPE));
      label4476:
      i = paramCursor.getColumnIndex("taskTotal");
      if (i != -1) {
        break label7229;
      }
      paramaukz.a(new NoColumnError("taskTotal", Integer.TYPE));
      label4513:
      i = paramCursor.getColumnIndex("hiWanInfo");
      if (i != -1) {
        break label7244;
      }
      paramaukz.a(new NoColumnError("hiWanInfo", String.class));
      label4550:
      i = paramCursor.getColumnIndex("commonLabelString");
      if (i != -1) {
        break label7259;
      }
      paramaukz.a(new NoColumnError("commonLabelString", String.class));
      label4587:
      i = paramCursor.getColumnIndex("tagFlag");
      if (i != -1) {
        break label7274;
      }
      paramaukz.a(new NoColumnError("tagFlag", Long.TYPE));
      label4624:
      i = paramCursor.getColumnIndex("tagInfo");
      if (i != -1) {
        break label7289;
      }
      paramaukz.a(new NoColumnError("tagInfo", String.class));
      label4661:
      i = paramCursor.getColumnIndex("picInfo");
      if (i != -1) {
        break label7304;
      }
      paramaukz.a(new NoColumnError("picInfo", String.class));
      label4698:
      i = paramCursor.getColumnIndex("videoDetails");
      if (i != -1) {
        break label7319;
      }
      paramaukz.a(new NoColumnError("videoDetails", String.class));
      label4735:
      i = paramCursor.getColumnIndex("strFreshNewsInfo");
      if (i != -1) {
        break label7334;
      }
      paramaukz.a(new NoColumnError("strFreshNewsInfo", String.class));
      label4772:
      i = paramCursor.getColumnIndex("strHotChatInfo");
      if (i != -1) {
        break label7349;
      }
      paramaukz.a(new NoColumnError("strHotChatInfo", String.class));
      label4809:
      i = paramCursor.getColumnIndex("uRoomid");
      if (i != -1) {
        break label7364;
      }
      paramaukz.a(new NoColumnError("uRoomid", Long.TYPE));
      label4846:
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label7379;
      }
      paramaukz.a(new NoColumnError("strVoteLimitedNotice", String.class));
      label4883:
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label7394;
      }
      paramaukz.a(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      label4920:
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label7409;
      }
      paramaukz.a(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      label4957:
      i = paramCursor.getColumnIndex("collegeId");
      if (i != -1) {
        break label7424;
      }
      paramaukz.a(new NoColumnError("collegeId", Long.TYPE));
      label4994:
      i = paramCursor.getColumnIndex("videoHeadFlag");
      if (i != -1) {
        break label7439;
      }
      paramaukz.a(new NoColumnError("videoHeadFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("bVideoHeadUrl");
      if (i != -1) {
        break label7466;
      }
      paramaukz.a(new NoColumnError("bVideoHeadUrl", String.class));
      label5068:
      i = paramCursor.getColumnIndex("faceScoreWordingColor");
      if (i != -1) {
        break label7481;
      }
      paramaukz.a(new NoColumnError("faceScoreWordingColor", Integer.TYPE));
      label5105:
      i = paramCursor.getColumnIndex("faceScoreWording");
      if (i != -1) {
        break label7496;
      }
      paramaukz.a(new NoColumnError("faceScoreWording", String.class));
      label5142:
      i = paramCursor.getColumnIndex("faceScoreTailWordingColor");
      if (i != -1) {
        break label7511;
      }
      paramaukz.a(new NoColumnError("faceScoreTailWordingColor", Integer.TYPE));
      label5179:
      i = paramCursor.getColumnIndex("faceScoreTailWording");
      if (i != -1) {
        break label7526;
      }
      paramaukz.a(new NoColumnError("faceScoreTailWording", String.class));
      label5216:
      i = paramCursor.getColumnIndex("faceScoreIconUrl");
      if (i != -1) {
        break label7541;
      }
      paramaukz.a(new NoColumnError("faceScoreIconUrl", String.class));
      label5253:
      i = paramCursor.getColumnIndex("entryAbility");
      if (i != -1) {
        break label7556;
      }
      paramaukz.a(new NoColumnError("entryAbility", Integer.TYPE));
      label5290:
      i = paramCursor.getColumnIndex("strLevelType");
      if (i != -1) {
        break label7571;
      }
      paramaukz.a(new NoColumnError("strLevelType", String.class));
      label5327:
      i = paramCursor.getColumnIndex("maskMsgFlag");
      if (i != -1) {
        break label7586;
      }
      paramaukz.a(new NoColumnError("maskMsgFlag", Integer.TYPE));
      label5364:
      i = paramCursor.getColumnIndex("isForbidSendMsg");
      if (i != -1) {
        break label7601;
      }
      paramaukz.a(new NoColumnError("isForbidSendMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isForbidSendGiftMsg");
      if (i != -1) {
        break label7628;
      }
      paramaukz.a(new NoColumnError("isForbidSendGiftMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("disableSendMsgBtnTips");
      if (i != -1) {
        break label7655;
      }
      paramaukz.a(new NoColumnError("disableSendMsgBtnTips", String.class));
      label5475:
      i = paramCursor.getColumnIndex("disableSendGiftBtnTips");
      if (i != -1) {
        break label7670;
      }
      paramaukz.a(new NoColumnError("disableSendGiftBtnTips", String.class));
      label5512:
      i = paramCursor.getColumnIndex("isForbidSendMsgForTribar");
      if (i != -1) {
        break label7685;
      }
      paramaukz.a(new NoColumnError("isForbidSendMsgForTribar", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isForbidSendGiftMsgForTribar");
      if (i != -1) {
        break label7712;
      }
      paramaukz.a(new NoColumnError("isForbidSendGiftMsgForTribar", Boolean.TYPE));
      i = paramCursor.getColumnIndex("disableSendMsgBtnTipsForTribar");
      if (i != -1) {
        break label7739;
      }
      paramaukz.a(new NoColumnError("disableSendMsgBtnTipsForTribar", String.class));
      label5623:
      i = paramCursor.getColumnIndex("disableSendGiftBtnTipsForTribar");
      if (i != -1) {
        break label7754;
      }
      paramaukz.a(new NoColumnError("disableSendGiftBtnTipsForTribar", String.class));
      label5660:
      i = paramCursor.getColumnIndex("highScoreNum");
      if (i != -1) {
        break label7769;
      }
      paramaukz.a(new NoColumnError("highScoreNum", Integer.TYPE));
      label5697:
      i = paramCursor.getColumnIndex("mHasStory");
      if (i != -1) {
        break label7784;
      }
      paramaukz.a(new NoColumnError("mHasStory", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mQQStoryData");
      if (i != -1) {
        break label7811;
      }
      paramaukz.a(new NoColumnError("mQQStoryData", [B.class));
      label5771:
      i = paramCursor.getColumnIndex("isSendMsgBtnDownloadAppOpen");
      if (i != -1) {
        break label7826;
      }
      paramaukz.a(new NoColumnError("isSendMsgBtnDownloadAppOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sendMsgBtnDownloadAppTips");
      if (i != -1) {
        break label7854;
      }
      paramaukz.a(new NoColumnError("sendMsgBtnDownloadAppTips", String.class));
      label5845:
      i = paramCursor.getColumnIndex("addPicBtnDownloadAppTips");
      if (i != -1) {
        break label7869;
      }
      paramaukz.a(new NoColumnError("addPicBtnDownloadAppTips", String.class));
      label5882:
      i = paramCursor.getColumnIndex("tribeAppDownloadPageUrl");
      if (i != -1) {
        break label7884;
      }
      paramaukz.a(new NoColumnError("tribeAppDownloadPageUrl", String.class));
      label5919:
      i = paramCursor.getColumnIndex("nearbyNowDataBytes");
      if (i != -1) {
        break label7899;
      }
      paramaukz.a(new NoColumnError("nearbyNowDataBytes", [B.class));
      label5956:
      i = paramCursor.getColumnIndex("guideAppNowTip");
      if (i != -1) {
        break label7914;
      }
      paramaukz.a(new NoColumnError("guideAppNowTip", String.class));
      label5993:
      i = paramCursor.getColumnIndex("guideAppNowTipLeftBtn");
      if (i != -1) {
        break label7929;
      }
      paramaukz.a(new NoColumnError("guideAppNowTipLeftBtn", String.class));
      label6030:
      i = paramCursor.getColumnIndex("guideAppNowTipRightBtnInstalled");
      if (i != -1) {
        break label7944;
      }
      paramaukz.a(new NoColumnError("guideAppNowTipRightBtnInstalled", String.class));
      label6067:
      i = paramCursor.getColumnIndex("guideAppNowTipRightBtnNotInstalled");
      if (i != -1) {
        break label7959;
      }
      paramaukz.a(new NoColumnError("guideAppNowTipRightBtnNotInstalled", String.class));
      label6104:
      i = paramCursor.getColumnIndex("guideAppNowPackage");
      if (i != -1) {
        break label7974;
      }
      paramaukz.a(new NoColumnError("guideAppNowPackage", String.class));
      label6141:
      i = paramCursor.getColumnIndex("guideAppNowJumpUri");
      if (i != -1) {
        break label7989;
      }
      paramaukz.a(new NoColumnError("guideAppNowJumpUri", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("guideAppNowDownloadUrl");
      if (i != -1) {
        break label8004;
      }
      paramaukz.a(new NoColumnError("guideAppNowDownloadUrl", String.class));
      return paramauko;
      paramauko.tinyId = paramCursor.getLong(i);
      break;
      label6232:
      paramauko.uin = paramCursor.getString(i);
      break label2282;
      label6247:
      paramauko.nowId = paramCursor.getLong(i);
      break label2317;
      label6262:
      paramauko.nowUserType = paramCursor.getInt(i);
      break label2352;
      label6277:
      paramauko.strRemark = paramCursor.getString(i);
      break label2387;
      label6292:
      paramauko.nickname = paramCursor.getString(i);
      break label2422;
      label6307:
      paramauko.gender = ((byte)paramCursor.getShort(i));
      break label2457;
      label6323:
      paramauko.age = paramCursor.getInt(i);
      break label2492;
      label6338:
      paramauko.birthday = paramCursor.getInt(i);
      break label2527;
      label6353:
      paramauko.constellation = ((byte)paramCursor.getShort(i));
      break label2562;
      label6369:
      paramauko.distance = paramCursor.getString(i);
      break label2597;
      label6384:
      paramauko.timeDiff = paramCursor.getString(i);
      break label2632;
      label6399:
      paramauko.aioDistanceAndTime = paramCursor.getString(i);
      break label2667;
      label6414:
      paramauko.likeCount = paramCursor.getInt(i);
      break label2702;
      label6429:
      paramauko.likeCountInc = paramCursor.getInt(i);
      break label2737;
      label6444:
      paramauko.oldPhotoCount = paramCursor.getInt(i);
      break label2772;
      label6459:
      paramauko.dateInfo = paramCursor.getBlob(i);
      break label2807;
      label6474:
      paramauko.ulShowControl = paramCursor.getLong(i);
      break label2842;
      label6489:
      paramauko.xuanYan = paramCursor.getBlob(i);
      break label2877;
      label6504:
      paramauko.maritalStatus = ((byte)paramCursor.getShort(i));
      break label2912;
      label6520:
      paramauko.job = paramCursor.getInt(i);
      break label2947;
      label6535:
      paramauko.company = paramCursor.getString(i);
      break label2982;
      label6550:
      paramauko.college = paramCursor.getString(i);
      break label3017;
      label6565:
      paramauko.hometownCountry = paramCursor.getString(i);
      break label3052;
      label6580:
      paramauko.hometownProvice = paramCursor.getString(i);
      break label3087;
      label6595:
      paramauko.hometownCity = paramCursor.getString(i);
      break label3122;
      label6610:
      paramauko.hometownDistrict = paramCursor.getString(i);
      break label3157;
      label6625:
      paramauko.vCookies = paramCursor.getBlob(i);
      break label3192;
      label6640:
      paramauko.bVoted = ((byte)paramCursor.getShort(i));
      break label3227;
      label6656:
      paramauko.feedPreviewTime = paramCursor.getLong(i);
      break label3262;
      label6671:
      paramauko.qzoneFeed = paramCursor.getString(i);
      break label3297;
      label6686:
      paramauko.qzoneName = paramCursor.getString(i);
      break label3332;
      label6701:
      paramauko.qzonePicUrl_1 = paramCursor.getString(i);
      break label3367;
      label6716:
      paramauko.qzonePicUrl_2 = paramCursor.getString(i);
      break label3402;
      label6731:
      paramauko.qzonePicUrl_3 = paramCursor.getString(i);
      break label3437;
      label6746:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isPhotoUseCache = paramBoolean;
        break;
      }
      label6773:
      paramauko.vSeed = paramCursor.getBlob(i);
      break label3507;
      label6788:
      paramauko.vTempChatSig = paramCursor.getBlob(i);
      break label3542;
      label6803:
      paramauko.vGroupList = paramCursor.getBlob(i);
      break label3577;
      label6818:
      paramauko.nearbyInfo = paramCursor.getBlob(i);
      break label3612;
      label6833:
      paramauko.vActivityList = paramCursor.getBlob(i);
      break label3647;
      label6848:
      paramauko.lUserFlag = paramCursor.getLong(i);
      break label3682;
      label6863:
      paramauko.iIsGodFlag = paramCursor.getInt(i);
      break label3717;
      label6878:
      paramauko.strGodJumpUrl = paramCursor.getString(i);
      break label3752;
      label6893:
      paramauko.mHeartNum = paramCursor.getInt(i);
      break label3787;
      label6908:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.switchQzone = paramBoolean;
        break;
      }
      label6935:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.switchHobby = paramBoolean;
        break;
      }
      label6962:
      paramauko.uiShowControl = paramCursor.getLong(i);
      break label3892;
      label6977:
      paramauko.userFlag = paramCursor.getLong(i);
      break label3927;
      label6992:
      paramauko.busiEntry = paramCursor.getString(i);
      break label3962;
      label7007:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.godFlag = paramBoolean;
        break;
      }
      label7034:
      paramauko.nLastGameFlag = paramCursor.getInt(i);
      break label4032;
      label7049:
      paramauko.strProfileUrl = paramCursor.getString(i);
      break label4069;
      label7064:
      paramauko.lastUpdateNickTime = paramCursor.getLong(i);
      break label4106;
      label7079:
      paramauko.favoriteSource = paramCursor.getInt(i);
      break label4143;
      label7094:
      paramauko.switchGiftVisible = paramCursor.getLong(i);
      break label4180;
      label7109:
      paramauko.vGiftInfo = paramCursor.getBlob(i);
      break label4217;
      label7124:
      paramauko.sayHelloFlag = paramCursor.getInt(i);
      break label4254;
      label7139:
      paramauko.charm = paramCursor.getLong(i);
      break label4291;
      label7154:
      paramauko.charmLevel = paramCursor.getInt(i);
      break label4328;
      label7169:
      paramauko.nextThreshold = paramCursor.getInt(i);
      break label4365;
      label7184:
      paramauko.curThreshold = paramCursor.getInt(i);
      break label4402;
      label7199:
      paramauko.profPercent = paramCursor.getInt(i);
      break label4439;
      label7214:
      paramauko.taskFinished = paramCursor.getInt(i);
      break label4476;
      label7229:
      paramauko.taskTotal = paramCursor.getInt(i);
      break label4513;
      label7244:
      paramauko.hiWanInfo = paramCursor.getString(i);
      break label4550;
      label7259:
      paramauko.commonLabelString = paramCursor.getString(i);
      break label4587;
      label7274:
      paramauko.tagFlag = paramCursor.getLong(i);
      break label4624;
      label7289:
      paramauko.tagInfo = paramCursor.getString(i);
      break label4661;
      label7304:
      paramauko.picInfo = paramCursor.getString(i);
      break label4698;
      label7319:
      paramauko.videoDetails = paramCursor.getString(i);
      break label4735;
      label7334:
      paramauko.strFreshNewsInfo = paramCursor.getString(i);
      break label4772;
      label7349:
      paramauko.strHotChatInfo = paramCursor.getString(i);
      break label4809;
      label7364:
      paramauko.uRoomid = paramCursor.getLong(i);
      break label4846;
      label7379:
      paramauko.strVoteLimitedNotice = paramCursor.getString(i);
      break label4883;
      label7394:
      paramauko.bHaveVotedCnt = paramCursor.getShort(i);
      break label4920;
      label7409:
      paramauko.bAvailVoteCnt = paramCursor.getShort(i);
      break label4957;
      label7424:
      paramauko.collegeId = paramCursor.getLong(i);
      break label4994;
      label7439:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.videoHeadFlag = paramBoolean;
        break;
      }
      label7466:
      paramauko.bVideoHeadUrl = paramCursor.getString(i);
      break label5068;
      label7481:
      paramauko.faceScoreWordingColor = paramCursor.getInt(i);
      break label5105;
      label7496:
      paramauko.faceScoreWording = paramCursor.getString(i);
      break label5142;
      label7511:
      paramauko.faceScoreTailWordingColor = paramCursor.getInt(i);
      break label5179;
      label7526:
      paramauko.faceScoreTailWording = paramCursor.getString(i);
      break label5216;
      label7541:
      paramauko.faceScoreIconUrl = paramCursor.getString(i);
      break label5253;
      label7556:
      paramauko.entryAbility = paramCursor.getInt(i);
      break label5290;
      label7571:
      paramauko.strLevelType = paramCursor.getString(i);
      break label5327;
      label7586:
      paramauko.maskMsgFlag = paramCursor.getInt(i);
      break label5364;
      label7601:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isForbidSendMsg = paramBoolean;
        break;
      }
      label7628:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isForbidSendGiftMsg = paramBoolean;
        break;
      }
      label7655:
      paramauko.disableSendMsgBtnTips = paramCursor.getString(i);
      break label5475;
      label7670:
      paramauko.disableSendGiftBtnTips = paramCursor.getString(i);
      break label5512;
      label7685:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isForbidSendMsgForTribar = paramBoolean;
        break;
      }
      label7712:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isForbidSendGiftMsgForTribar = paramBoolean;
        break;
      }
      label7739:
      paramauko.disableSendMsgBtnTipsForTribar = paramCursor.getString(i);
      break label5623;
      label7754:
      paramauko.disableSendGiftBtnTipsForTribar = paramCursor.getString(i);
      break label5660;
      label7769:
      paramauko.highScoreNum = paramCursor.getInt(i);
      break label5697;
      label7784:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.mHasStory = paramBoolean;
        break;
      }
      label7811:
      paramauko.mQQStoryData = paramCursor.getBlob(i);
      break label5771;
      label7826:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramauko.isSendMsgBtnDownloadAppOpen = paramBoolean;
        break;
      }
      label7854:
      paramauko.sendMsgBtnDownloadAppTips = paramCursor.getString(i);
      break label5845;
      label7869:
      paramauko.addPicBtnDownloadAppTips = paramCursor.getString(i);
      break label5882;
      label7884:
      paramauko.tribeAppDownloadPageUrl = paramCursor.getString(i);
      break label5919;
      label7899:
      paramauko.nearbyNowDataBytes = paramCursor.getBlob(i);
      break label5956;
      label7914:
      paramauko.guideAppNowTip = paramCursor.getString(i);
      break label5993;
      label7929:
      paramauko.guideAppNowTipLeftBtn = paramCursor.getString(i);
      break label6030;
      label7944:
      paramauko.guideAppNowTipRightBtnInstalled = paramCursor.getString(i);
      break label6067;
      label7959:
      paramauko.guideAppNowTipRightBtnNotInstalled = paramCursor.getString(i);
      break label6104;
      label7974:
      paramauko.guideAppNowPackage = paramCursor.getString(i);
      break label6141;
      label7989:
      paramauko.guideAppNowJumpUri = paramCursor.getString(i);
    }
    label8004:
    paramauko.guideAppNowDownloadUrl = paramCursor.getString(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,tinyId INTEGER ,uin TEXT ,nowId INTEGER ,nowUserType INTEGER ,strRemark TEXT ,nickname TEXT ,gender INTEGER ,age INTEGER ,birthday INTEGER ,constellation INTEGER ,distance TEXT ,timeDiff TEXT ,aioDistanceAndTime TEXT ,likeCount INTEGER ,likeCountInc INTEGER ,oldPhotoCount INTEGER ,dateInfo BLOB ,ulShowControl INTEGER ,xuanYan BLOB ,maritalStatus INTEGER ,job INTEGER ,company TEXT ,college TEXT ,hometownCountry TEXT ,hometownProvice TEXT ,hometownCity TEXT ,hometownDistrict TEXT ,vCookies BLOB ,bVoted INTEGER ,feedPreviewTime INTEGER ,qzoneFeed TEXT ,qzoneName TEXT ,qzonePicUrl_1 TEXT ,qzonePicUrl_2 TEXT ,qzonePicUrl_3 TEXT ,isPhotoUseCache INTEGER ,vSeed BLOB ,vTempChatSig BLOB ,vGroupList BLOB ,nearbyInfo BLOB ,vActivityList BLOB ,lUserFlag INTEGER ,iIsGodFlag INTEGER ,strGodJumpUrl TEXT ,mHeartNum INTEGER ,switchQzone INTEGER ,switchHobby INTEGER ,uiShowControl INTEGER ,userFlag INTEGER ,busiEntry TEXT ,godFlag INTEGER ,nLastGameFlag INTEGER ,strProfileUrl TEXT ,lastUpdateNickTime INTEGER ,favoriteSource INTEGER ,switchGiftVisible INTEGER ,vGiftInfo BLOB ,sayHelloFlag INTEGER ,charm INTEGER ,charmLevel INTEGER ,nextThreshold INTEGER ,curThreshold INTEGER ,profPercent INTEGER ,taskFinished INTEGER ,taskTotal INTEGER ,hiWanInfo TEXT ,commonLabelString TEXT ,tagFlag INTEGER ,tagInfo TEXT ,picInfo TEXT ,videoDetails TEXT ,strFreshNewsInfo TEXT ,strHotChatInfo TEXT ,uRoomid INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,collegeId INTEGER ,videoHeadFlag INTEGER ,bVideoHeadUrl TEXT ,faceScoreWordingColor INTEGER ,faceScoreWording TEXT ,faceScoreTailWordingColor INTEGER ,faceScoreTailWording TEXT ,faceScoreIconUrl TEXT ,entryAbility INTEGER ,strLevelType TEXT ,maskMsgFlag INTEGER ,isForbidSendMsg INTEGER ,isForbidSendGiftMsg INTEGER ,disableSendMsgBtnTips TEXT ,disableSendGiftBtnTips TEXT ,isForbidSendMsgForTribar INTEGER ,isForbidSendGiftMsgForTribar INTEGER ,disableSendMsgBtnTipsForTribar TEXT ,disableSendGiftBtnTipsForTribar TEXT ,highScoreNum INTEGER ,mHasStory INTEGER ,mQQStoryData BLOB ,isSendMsgBtnDownloadAppOpen INTEGER ,sendMsgBtnDownloadAppTips TEXT ,addPicBtnDownloadAppTips TEXT ,tribeAppDownloadPageUrl TEXT ,nearbyNowDataBytes BLOB ,guideAppNowTip TEXT ,guideAppNowTipLeftBtn TEXT ,guideAppNowTipRightBtnInstalled TEXT ,guideAppNowTipRightBtnNotInstalled TEXT ,guideAppNowPackage TEXT ,guideAppNowJumpUri TEXT ,guideAppNowDownloadUrl TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (NearbyPeopleCard)paramauko;
    paramContentValues.put("tinyId", Long.valueOf(paramauko.tinyId));
    paramContentValues.put("uin", paramauko.uin);
    paramContentValues.put("nowId", Long.valueOf(paramauko.nowId));
    paramContentValues.put("nowUserType", Integer.valueOf(paramauko.nowUserType));
    paramContentValues.put("strRemark", paramauko.strRemark);
    paramContentValues.put("nickname", paramauko.nickname);
    paramContentValues.put("gender", Byte.valueOf(paramauko.gender));
    paramContentValues.put("age", Integer.valueOf(paramauko.age));
    paramContentValues.put("birthday", Integer.valueOf(paramauko.birthday));
    paramContentValues.put("constellation", Byte.valueOf(paramauko.constellation));
    paramContentValues.put("distance", paramauko.distance);
    paramContentValues.put("timeDiff", paramauko.timeDiff);
    paramContentValues.put("aioDistanceAndTime", paramauko.aioDistanceAndTime);
    paramContentValues.put("likeCount", Integer.valueOf(paramauko.likeCount));
    paramContentValues.put("likeCountInc", Integer.valueOf(paramauko.likeCountInc));
    paramContentValues.put("oldPhotoCount", Integer.valueOf(paramauko.oldPhotoCount));
    paramContentValues.put("dateInfo", paramauko.dateInfo);
    paramContentValues.put("ulShowControl", Long.valueOf(paramauko.ulShowControl));
    paramContentValues.put("xuanYan", paramauko.xuanYan);
    paramContentValues.put("maritalStatus", Byte.valueOf(paramauko.maritalStatus));
    paramContentValues.put("job", Integer.valueOf(paramauko.job));
    paramContentValues.put("company", paramauko.company);
    paramContentValues.put("college", paramauko.college);
    paramContentValues.put("hometownCountry", paramauko.hometownCountry);
    paramContentValues.put("hometownProvice", paramauko.hometownProvice);
    paramContentValues.put("hometownCity", paramauko.hometownCity);
    paramContentValues.put("hometownDistrict", paramauko.hometownDistrict);
    paramContentValues.put("vCookies", paramauko.vCookies);
    paramContentValues.put("bVoted", Byte.valueOf(paramauko.bVoted));
    paramContentValues.put("feedPreviewTime", Long.valueOf(paramauko.feedPreviewTime));
    paramContentValues.put("qzoneFeed", paramauko.qzoneFeed);
    paramContentValues.put("qzoneName", paramauko.qzoneName);
    paramContentValues.put("qzonePicUrl_1", paramauko.qzonePicUrl_1);
    paramContentValues.put("qzonePicUrl_2", paramauko.qzonePicUrl_2);
    paramContentValues.put("qzonePicUrl_3", paramauko.qzonePicUrl_3);
    paramContentValues.put("isPhotoUseCache", Boolean.valueOf(paramauko.isPhotoUseCache));
    paramContentValues.put("vSeed", paramauko.vSeed);
    paramContentValues.put("vTempChatSig", paramauko.vTempChatSig);
    paramContentValues.put("vGroupList", paramauko.vGroupList);
    paramContentValues.put("nearbyInfo", paramauko.nearbyInfo);
    paramContentValues.put("vActivityList", paramauko.vActivityList);
    paramContentValues.put("lUserFlag", Long.valueOf(paramauko.lUserFlag));
    paramContentValues.put("iIsGodFlag", Integer.valueOf(paramauko.iIsGodFlag));
    paramContentValues.put("strGodJumpUrl", paramauko.strGodJumpUrl);
    paramContentValues.put("mHeartNum", Integer.valueOf(paramauko.mHeartNum));
    paramContentValues.put("switchQzone", Boolean.valueOf(paramauko.switchQzone));
    paramContentValues.put("switchHobby", Boolean.valueOf(paramauko.switchHobby));
    paramContentValues.put("uiShowControl", Long.valueOf(paramauko.uiShowControl));
    paramContentValues.put("userFlag", Long.valueOf(paramauko.userFlag));
    paramContentValues.put("busiEntry", paramauko.busiEntry);
    paramContentValues.put("godFlag", Boolean.valueOf(paramauko.godFlag));
    paramContentValues.put("nLastGameFlag", Integer.valueOf(paramauko.nLastGameFlag));
    paramContentValues.put("strProfileUrl", paramauko.strProfileUrl);
    paramContentValues.put("lastUpdateNickTime", Long.valueOf(paramauko.lastUpdateNickTime));
    paramContentValues.put("favoriteSource", Integer.valueOf(paramauko.favoriteSource));
    paramContentValues.put("switchGiftVisible", Long.valueOf(paramauko.switchGiftVisible));
    paramContentValues.put("vGiftInfo", paramauko.vGiftInfo);
    paramContentValues.put("sayHelloFlag", Integer.valueOf(paramauko.sayHelloFlag));
    paramContentValues.put("charm", Long.valueOf(paramauko.charm));
    paramContentValues.put("charmLevel", Integer.valueOf(paramauko.charmLevel));
    paramContentValues.put("nextThreshold", Integer.valueOf(paramauko.nextThreshold));
    paramContentValues.put("curThreshold", Integer.valueOf(paramauko.curThreshold));
    paramContentValues.put("profPercent", Integer.valueOf(paramauko.profPercent));
    paramContentValues.put("taskFinished", Integer.valueOf(paramauko.taskFinished));
    paramContentValues.put("taskTotal", Integer.valueOf(paramauko.taskTotal));
    paramContentValues.put("hiWanInfo", paramauko.hiWanInfo);
    paramContentValues.put("commonLabelString", paramauko.commonLabelString);
    paramContentValues.put("tagFlag", Long.valueOf(paramauko.tagFlag));
    paramContentValues.put("tagInfo", paramauko.tagInfo);
    paramContentValues.put("picInfo", paramauko.picInfo);
    paramContentValues.put("videoDetails", paramauko.videoDetails);
    paramContentValues.put("strFreshNewsInfo", paramauko.strFreshNewsInfo);
    paramContentValues.put("strHotChatInfo", paramauko.strHotChatInfo);
    paramContentValues.put("uRoomid", Long.valueOf(paramauko.uRoomid));
    paramContentValues.put("strVoteLimitedNotice", paramauko.strVoteLimitedNotice);
    paramContentValues.put("bHaveVotedCnt", Short.valueOf(paramauko.bHaveVotedCnt));
    paramContentValues.put("bAvailVoteCnt", Short.valueOf(paramauko.bAvailVoteCnt));
    paramContentValues.put("collegeId", Long.valueOf(paramauko.collegeId));
    paramContentValues.put("videoHeadFlag", Boolean.valueOf(paramauko.videoHeadFlag));
    paramContentValues.put("bVideoHeadUrl", paramauko.bVideoHeadUrl);
    paramContentValues.put("faceScoreWordingColor", Integer.valueOf(paramauko.faceScoreWordingColor));
    paramContentValues.put("faceScoreWording", paramauko.faceScoreWording);
    paramContentValues.put("faceScoreTailWordingColor", Integer.valueOf(paramauko.faceScoreTailWordingColor));
    paramContentValues.put("faceScoreTailWording", paramauko.faceScoreTailWording);
    paramContentValues.put("faceScoreIconUrl", paramauko.faceScoreIconUrl);
    paramContentValues.put("entryAbility", Integer.valueOf(paramauko.entryAbility));
    paramContentValues.put("strLevelType", paramauko.strLevelType);
    paramContentValues.put("maskMsgFlag", Integer.valueOf(paramauko.maskMsgFlag));
    paramContentValues.put("isForbidSendMsg", Boolean.valueOf(paramauko.isForbidSendMsg));
    paramContentValues.put("isForbidSendGiftMsg", Boolean.valueOf(paramauko.isForbidSendGiftMsg));
    paramContentValues.put("disableSendMsgBtnTips", paramauko.disableSendMsgBtnTips);
    paramContentValues.put("disableSendGiftBtnTips", paramauko.disableSendGiftBtnTips);
    paramContentValues.put("isForbidSendMsgForTribar", Boolean.valueOf(paramauko.isForbidSendMsgForTribar));
    paramContentValues.put("isForbidSendGiftMsgForTribar", Boolean.valueOf(paramauko.isForbidSendGiftMsgForTribar));
    paramContentValues.put("disableSendMsgBtnTipsForTribar", paramauko.disableSendMsgBtnTipsForTribar);
    paramContentValues.put("disableSendGiftBtnTipsForTribar", paramauko.disableSendGiftBtnTipsForTribar);
    paramContentValues.put("highScoreNum", Integer.valueOf(paramauko.highScoreNum));
    paramContentValues.put("mHasStory", Boolean.valueOf(paramauko.mHasStory));
    paramContentValues.put("mQQStoryData", paramauko.mQQStoryData);
    paramContentValues.put("isSendMsgBtnDownloadAppOpen", Boolean.valueOf(paramauko.isSendMsgBtnDownloadAppOpen));
    paramContentValues.put("sendMsgBtnDownloadAppTips", paramauko.sendMsgBtnDownloadAppTips);
    paramContentValues.put("addPicBtnDownloadAppTips", paramauko.addPicBtnDownloadAppTips);
    paramContentValues.put("tribeAppDownloadPageUrl", paramauko.tribeAppDownloadPageUrl);
    paramContentValues.put("nearbyNowDataBytes", paramauko.nearbyNowDataBytes);
    paramContentValues.put("guideAppNowTip", paramauko.guideAppNowTip);
    paramContentValues.put("guideAppNowTipLeftBtn", paramauko.guideAppNowTipLeftBtn);
    paramContentValues.put("guideAppNowTipRightBtnInstalled", paramauko.guideAppNowTipRightBtnInstalled);
    paramContentValues.put("guideAppNowTipRightBtnNotInstalled", paramauko.guideAppNowTipRightBtnNotInstalled);
    paramContentValues.put("guideAppNowPackage", paramauko.guideAppNowPackage);
    paramContentValues.put("guideAppNowJumpUri", paramauko.guideAppNowJumpUri);
    paramContentValues.put("guideAppNowDownloadUrl", paramauko.guideAppNowDownloadUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auky
 * JD-Core Version:    0.7.0.1
 */