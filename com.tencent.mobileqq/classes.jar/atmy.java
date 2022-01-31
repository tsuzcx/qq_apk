import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atmy
  extends atna
{
  public atmy()
  {
    this.a = 111;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramatmo = (NearbyPeopleCard)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.tinyId = paramCursor.getLong(paramCursor.getColumnIndex("tinyId"));
      paramatmo.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramatmo.nowId = paramCursor.getLong(paramCursor.getColumnIndex("nowId"));
      paramatmo.nowUserType = paramCursor.getInt(paramCursor.getColumnIndex("nowUserType"));
      paramatmo.strRemark = paramCursor.getString(paramCursor.getColumnIndex("strRemark"));
      paramatmo.nickname = paramCursor.getString(paramCursor.getColumnIndex("nickname"));
      paramatmo.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
      paramatmo.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
      paramatmo.birthday = paramCursor.getInt(paramCursor.getColumnIndex("birthday"));
      paramatmo.constellation = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("constellation")));
      paramatmo.distance = paramCursor.getString(paramCursor.getColumnIndex("distance"));
      paramatmo.timeDiff = paramCursor.getString(paramCursor.getColumnIndex("timeDiff"));
      paramatmo.aioDistanceAndTime = paramCursor.getString(paramCursor.getColumnIndex("aioDistanceAndTime"));
      paramatmo.likeCount = paramCursor.getInt(paramCursor.getColumnIndex("likeCount"));
      paramatmo.likeCountInc = paramCursor.getInt(paramCursor.getColumnIndex("likeCountInc"));
      paramatmo.oldPhotoCount = paramCursor.getInt(paramCursor.getColumnIndex("oldPhotoCount"));
      paramatmo.dateInfo = paramCursor.getBlob(paramCursor.getColumnIndex("dateInfo"));
      paramatmo.ulShowControl = paramCursor.getLong(paramCursor.getColumnIndex("ulShowControl"));
      paramatmo.xuanYan = paramCursor.getBlob(paramCursor.getColumnIndex("xuanYan"));
      paramatmo.maritalStatus = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("maritalStatus")));
      paramatmo.job = paramCursor.getInt(paramCursor.getColumnIndex("job"));
      paramatmo.company = paramCursor.getString(paramCursor.getColumnIndex("company"));
      paramatmo.college = paramCursor.getString(paramCursor.getColumnIndex("college"));
      paramatmo.hometownCountry = paramCursor.getString(paramCursor.getColumnIndex("hometownCountry"));
      paramatmo.hometownProvice = paramCursor.getString(paramCursor.getColumnIndex("hometownProvice"));
      paramatmo.hometownCity = paramCursor.getString(paramCursor.getColumnIndex("hometownCity"));
      paramatmo.hometownDistrict = paramCursor.getString(paramCursor.getColumnIndex("hometownDistrict"));
      paramatmo.vCookies = paramCursor.getBlob(paramCursor.getColumnIndex("vCookies"));
      paramatmo.bVoted = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bVoted")));
      paramatmo.feedPreviewTime = paramCursor.getLong(paramCursor.getColumnIndex("feedPreviewTime"));
      paramatmo.qzoneFeed = paramCursor.getString(paramCursor.getColumnIndex("qzoneFeed"));
      paramatmo.qzoneName = paramCursor.getString(paramCursor.getColumnIndex("qzoneName"));
      paramatmo.qzonePicUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_1"));
      paramatmo.qzonePicUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_2"));
      paramatmo.qzonePicUrl_3 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_3"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isPhotoUseCache")))
      {
        paramBoolean = true;
        paramatmo.isPhotoUseCache = paramBoolean;
        paramatmo.vSeed = paramCursor.getBlob(paramCursor.getColumnIndex("vSeed"));
        paramatmo.vTempChatSig = paramCursor.getBlob(paramCursor.getColumnIndex("vTempChatSig"));
        paramatmo.vGroupList = paramCursor.getBlob(paramCursor.getColumnIndex("vGroupList"));
        paramatmo.nearbyInfo = paramCursor.getBlob(paramCursor.getColumnIndex("nearbyInfo"));
        paramatmo.vActivityList = paramCursor.getBlob(paramCursor.getColumnIndex("vActivityList"));
        paramatmo.lUserFlag = paramCursor.getLong(paramCursor.getColumnIndex("lUserFlag"));
        paramatmo.iIsGodFlag = paramCursor.getInt(paramCursor.getColumnIndex("iIsGodFlag"));
        paramatmo.strGodJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("strGodJumpUrl"));
        paramatmo.mHeartNum = paramCursor.getInt(paramCursor.getColumnIndex("mHeartNum"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("switchQzone"))) {
          break label2162;
        }
        paramBoolean = true;
        label857:
        paramatmo.switchQzone = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("switchHobby"))) {
          break label2167;
        }
        paramBoolean = true;
        label882:
        paramatmo.switchHobby = paramBoolean;
        paramatmo.uiShowControl = paramCursor.getLong(paramCursor.getColumnIndex("uiShowControl"));
        paramatmo.userFlag = paramCursor.getLong(paramCursor.getColumnIndex("userFlag"));
        paramatmo.busiEntry = paramCursor.getString(paramCursor.getColumnIndex("busiEntry"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("godFlag"))) {
          break label2172;
        }
        paramBoolean = true;
        label961:
        paramatmo.godFlag = paramBoolean;
        paramatmo.nLastGameFlag = paramCursor.getInt(paramCursor.getColumnIndex("nLastGameFlag"));
        paramatmo.strProfileUrl = paramCursor.getString(paramCursor.getColumnIndex("strProfileUrl"));
        paramatmo.lastUpdateNickTime = paramCursor.getLong(paramCursor.getColumnIndex("lastUpdateNickTime"));
        paramatmo.favoriteSource = paramCursor.getInt(paramCursor.getColumnIndex("favoriteSource"));
        paramatmo.switchGiftVisible = paramCursor.getLong(paramCursor.getColumnIndex("switchGiftVisible"));
        paramatmo.vGiftInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vGiftInfo"));
        paramatmo.sayHelloFlag = paramCursor.getInt(paramCursor.getColumnIndex("sayHelloFlag"));
        paramatmo.charm = paramCursor.getLong(paramCursor.getColumnIndex("charm"));
        paramatmo.charmLevel = paramCursor.getInt(paramCursor.getColumnIndex("charmLevel"));
        paramatmo.nextThreshold = paramCursor.getInt(paramCursor.getColumnIndex("nextThreshold"));
        paramatmo.curThreshold = paramCursor.getInt(paramCursor.getColumnIndex("curThreshold"));
        paramatmo.profPercent = paramCursor.getInt(paramCursor.getColumnIndex("profPercent"));
        paramatmo.taskFinished = paramCursor.getInt(paramCursor.getColumnIndex("taskFinished"));
        paramatmo.taskTotal = paramCursor.getInt(paramCursor.getColumnIndex("taskTotal"));
        paramatmo.hiWanInfo = paramCursor.getString(paramCursor.getColumnIndex("hiWanInfo"));
        paramatmo.commonLabelString = paramCursor.getString(paramCursor.getColumnIndex("commonLabelString"));
        paramatmo.tagFlag = paramCursor.getLong(paramCursor.getColumnIndex("tagFlag"));
        paramatmo.tagInfo = paramCursor.getString(paramCursor.getColumnIndex("tagInfo"));
        paramatmo.picInfo = paramCursor.getString(paramCursor.getColumnIndex("picInfo"));
        paramatmo.videoDetails = paramCursor.getString(paramCursor.getColumnIndex("videoDetails"));
        paramatmo.strFreshNewsInfo = paramCursor.getString(paramCursor.getColumnIndex("strFreshNewsInfo"));
        paramatmo.strHotChatInfo = paramCursor.getString(paramCursor.getColumnIndex("strHotChatInfo"));
        paramatmo.uRoomid = paramCursor.getLong(paramCursor.getColumnIndex("uRoomid"));
        paramatmo.strVoteLimitedNotice = paramCursor.getString(paramCursor.getColumnIndex("strVoteLimitedNotice"));
        paramatmo.bHaveVotedCnt = paramCursor.getShort(paramCursor.getColumnIndex("bHaveVotedCnt"));
        paramatmo.bAvailVoteCnt = paramCursor.getShort(paramCursor.getColumnIndex("bAvailVoteCnt"));
        paramatmo.collegeId = paramCursor.getLong(paramCursor.getColumnIndex("collegeId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("videoHeadFlag"))) {
          break label2177;
        }
        paramBoolean = true;
        label1499:
        paramatmo.videoHeadFlag = paramBoolean;
        paramatmo.bVideoHeadUrl = paramCursor.getString(paramCursor.getColumnIndex("bVideoHeadUrl"));
        paramatmo.faceScoreWordingColor = paramCursor.getInt(paramCursor.getColumnIndex("faceScoreWordingColor"));
        paramatmo.faceScoreWording = paramCursor.getString(paramCursor.getColumnIndex("faceScoreWording"));
        paramatmo.faceScoreTailWordingColor = paramCursor.getInt(paramCursor.getColumnIndex("faceScoreTailWordingColor"));
        paramatmo.faceScoreTailWording = paramCursor.getString(paramCursor.getColumnIndex("faceScoreTailWording"));
        paramatmo.faceScoreIconUrl = paramCursor.getString(paramCursor.getColumnIndex("faceScoreIconUrl"));
        paramatmo.entryAbility = paramCursor.getInt(paramCursor.getColumnIndex("entryAbility"));
        paramatmo.strLevelType = paramCursor.getString(paramCursor.getColumnIndex("strLevelType"));
        paramatmo.maskMsgFlag = paramCursor.getInt(paramCursor.getColumnIndex("maskMsgFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendMsg"))) {
          break label2182;
        }
        paramBoolean = true;
        label1696:
        paramatmo.isForbidSendMsg = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendGiftMsg"))) {
          break label2187;
        }
        paramBoolean = true;
        label1722:
        paramatmo.isForbidSendGiftMsg = paramBoolean;
        paramatmo.disableSendMsgBtnTips = paramCursor.getString(paramCursor.getColumnIndex("disableSendMsgBtnTips"));
        paramatmo.disableSendGiftBtnTips = paramCursor.getString(paramCursor.getColumnIndex("disableSendGiftBtnTips"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendMsgForTribar"))) {
          break label2192;
        }
        paramBoolean = true;
        label1786:
        paramatmo.isForbidSendMsgForTribar = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendGiftMsgForTribar"))) {
          break label2197;
        }
        paramBoolean = true;
        label1812:
        paramatmo.isForbidSendGiftMsgForTribar = paramBoolean;
        paramatmo.disableSendMsgBtnTipsForTribar = paramCursor.getString(paramCursor.getColumnIndex("disableSendMsgBtnTipsForTribar"));
        paramatmo.disableSendGiftBtnTipsForTribar = paramCursor.getString(paramCursor.getColumnIndex("disableSendGiftBtnTipsForTribar"));
        paramatmo.highScoreNum = paramCursor.getInt(paramCursor.getColumnIndex("highScoreNum"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mHasStory"))) {
          break label2202;
        }
        paramBoolean = true;
        label1895:
        paramatmo.mHasStory = paramBoolean;
        paramatmo.mQQStoryData = paramCursor.getBlob(paramCursor.getColumnIndex("mQQStoryData"));
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
        paramatmo.isSendMsgBtnDownloadAppOpen = paramBoolean;
        paramatmo.sendMsgBtnDownloadAppTips = paramCursor.getString(paramCursor.getColumnIndex("sendMsgBtnDownloadAppTips"));
        paramatmo.addPicBtnDownloadAppTips = paramCursor.getString(paramCursor.getColumnIndex("addPicBtnDownloadAppTips"));
        paramatmo.tribeAppDownloadPageUrl = paramCursor.getString(paramCursor.getColumnIndex("tribeAppDownloadPageUrl"));
        paramatmo.nearbyNowDataBytes = paramCursor.getBlob(paramCursor.getColumnIndex("nearbyNowDataBytes"));
        paramatmo.guideAppNowTip = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTip"));
        paramatmo.guideAppNowTipLeftBtn = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTipLeftBtn"));
        paramatmo.guideAppNowTipRightBtnInstalled = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTipRightBtnInstalled"));
        paramatmo.guideAppNowTipRightBtnNotInstalled = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTipRightBtnNotInstalled"));
        paramatmo.guideAppNowPackage = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowPackage"));
        paramatmo.guideAppNowJumpUri = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowJumpUri"));
        paramatmo.guideAppNowDownloadUrl = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowDownloadUrl"));
        return paramatmo;
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
      paramatmz.a(new NoColumnError("tinyId", Long.TYPE));
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label6232;
      }
      paramatmz.a(new NoColumnError("uin", String.class));
      label2282:
      i = paramCursor.getColumnIndex("nowId");
      if (i != -1) {
        break label6247;
      }
      paramatmz.a(new NoColumnError("nowId", Long.TYPE));
      label2317:
      i = paramCursor.getColumnIndex("nowUserType");
      if (i != -1) {
        break label6262;
      }
      paramatmz.a(new NoColumnError("nowUserType", Integer.TYPE));
      label2352:
      i = paramCursor.getColumnIndex("strRemark");
      if (i != -1) {
        break label6277;
      }
      paramatmz.a(new NoColumnError("strRemark", String.class));
      label2387:
      i = paramCursor.getColumnIndex("nickname");
      if (i != -1) {
        break label6292;
      }
      paramatmz.a(new NoColumnError("nickname", String.class));
      label2422:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label6307;
      }
      paramatmz.a(new NoColumnError("gender", Byte.TYPE));
      label2457:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label6323;
      }
      paramatmz.a(new NoColumnError("age", Integer.TYPE));
      label2492:
      i = paramCursor.getColumnIndex("birthday");
      if (i != -1) {
        break label6338;
      }
      paramatmz.a(new NoColumnError("birthday", Integer.TYPE));
      label2527:
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label6353;
      }
      paramatmz.a(new NoColumnError("constellation", Byte.TYPE));
      label2562:
      i = paramCursor.getColumnIndex("distance");
      if (i != -1) {
        break label6369;
      }
      paramatmz.a(new NoColumnError("distance", String.class));
      label2597:
      i = paramCursor.getColumnIndex("timeDiff");
      if (i != -1) {
        break label6384;
      }
      paramatmz.a(new NoColumnError("timeDiff", String.class));
      label2632:
      i = paramCursor.getColumnIndex("aioDistanceAndTime");
      if (i != -1) {
        break label6399;
      }
      paramatmz.a(new NoColumnError("aioDistanceAndTime", String.class));
      label2667:
      i = paramCursor.getColumnIndex("likeCount");
      if (i != -1) {
        break label6414;
      }
      paramatmz.a(new NoColumnError("likeCount", Integer.TYPE));
      label2702:
      i = paramCursor.getColumnIndex("likeCountInc");
      if (i != -1) {
        break label6429;
      }
      paramatmz.a(new NoColumnError("likeCountInc", Integer.TYPE));
      label2737:
      i = paramCursor.getColumnIndex("oldPhotoCount");
      if (i != -1) {
        break label6444;
      }
      paramatmz.a(new NoColumnError("oldPhotoCount", Integer.TYPE));
      label2772:
      i = paramCursor.getColumnIndex("dateInfo");
      if (i != -1) {
        break label6459;
      }
      paramatmz.a(new NoColumnError("dateInfo", [B.class));
      label2807:
      i = paramCursor.getColumnIndex("ulShowControl");
      if (i != -1) {
        break label6474;
      }
      paramatmz.a(new NoColumnError("ulShowControl", Long.TYPE));
      label2842:
      i = paramCursor.getColumnIndex("xuanYan");
      if (i != -1) {
        break label6489;
      }
      paramatmz.a(new NoColumnError("xuanYan", [B.class));
      label2877:
      i = paramCursor.getColumnIndex("maritalStatus");
      if (i != -1) {
        break label6504;
      }
      paramatmz.a(new NoColumnError("maritalStatus", Byte.TYPE));
      label2912:
      i = paramCursor.getColumnIndex("job");
      if (i != -1) {
        break label6520;
      }
      paramatmz.a(new NoColumnError("job", Integer.TYPE));
      label2947:
      i = paramCursor.getColumnIndex("company");
      if (i != -1) {
        break label6535;
      }
      paramatmz.a(new NoColumnError("company", String.class));
      label2982:
      i = paramCursor.getColumnIndex("college");
      if (i != -1) {
        break label6550;
      }
      paramatmz.a(new NoColumnError("college", String.class));
      label3017:
      i = paramCursor.getColumnIndex("hometownCountry");
      if (i != -1) {
        break label6565;
      }
      paramatmz.a(new NoColumnError("hometownCountry", String.class));
      label3052:
      i = paramCursor.getColumnIndex("hometownProvice");
      if (i != -1) {
        break label6580;
      }
      paramatmz.a(new NoColumnError("hometownProvice", String.class));
      label3087:
      i = paramCursor.getColumnIndex("hometownCity");
      if (i != -1) {
        break label6595;
      }
      paramatmz.a(new NoColumnError("hometownCity", String.class));
      label3122:
      i = paramCursor.getColumnIndex("hometownDistrict");
      if (i != -1) {
        break label6610;
      }
      paramatmz.a(new NoColumnError("hometownDistrict", String.class));
      label3157:
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label6625;
      }
      paramatmz.a(new NoColumnError("vCookies", [B.class));
      label3192:
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label6640;
      }
      paramatmz.a(new NoColumnError("bVoted", Byte.TYPE));
      label3227:
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label6656;
      }
      paramatmz.a(new NoColumnError("feedPreviewTime", Long.TYPE));
      label3262:
      i = paramCursor.getColumnIndex("qzoneFeed");
      if (i != -1) {
        break label6671;
      }
      paramatmz.a(new NoColumnError("qzoneFeed", String.class));
      label3297:
      i = paramCursor.getColumnIndex("qzoneName");
      if (i != -1) {
        break label6686;
      }
      paramatmz.a(new NoColumnError("qzoneName", String.class));
      label3332:
      i = paramCursor.getColumnIndex("qzonePicUrl_1");
      if (i != -1) {
        break label6701;
      }
      paramatmz.a(new NoColumnError("qzonePicUrl_1", String.class));
      label3367:
      i = paramCursor.getColumnIndex("qzonePicUrl_2");
      if (i != -1) {
        break label6716;
      }
      paramatmz.a(new NoColumnError("qzonePicUrl_2", String.class));
      label3402:
      i = paramCursor.getColumnIndex("qzonePicUrl_3");
      if (i != -1) {
        break label6731;
      }
      paramatmz.a(new NoColumnError("qzonePicUrl_3", String.class));
      label3437:
      i = paramCursor.getColumnIndex("isPhotoUseCache");
      if (i != -1) {
        break label6746;
      }
      paramatmz.a(new NoColumnError("isPhotoUseCache", Boolean.TYPE));
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label6773;
      }
      paramatmz.a(new NoColumnError("vSeed", [B.class));
      label3507:
      i = paramCursor.getColumnIndex("vTempChatSig");
      if (i != -1) {
        break label6788;
      }
      paramatmz.a(new NoColumnError("vTempChatSig", [B.class));
      label3542:
      i = paramCursor.getColumnIndex("vGroupList");
      if (i != -1) {
        break label6803;
      }
      paramatmz.a(new NoColumnError("vGroupList", [B.class));
      label3577:
      i = paramCursor.getColumnIndex("nearbyInfo");
      if (i != -1) {
        break label6818;
      }
      paramatmz.a(new NoColumnError("nearbyInfo", [B.class));
      label3612:
      i = paramCursor.getColumnIndex("vActivityList");
      if (i != -1) {
        break label6833;
      }
      paramatmz.a(new NoColumnError("vActivityList", [B.class));
      label3647:
      i = paramCursor.getColumnIndex("lUserFlag");
      if (i != -1) {
        break label6848;
      }
      paramatmz.a(new NoColumnError("lUserFlag", Long.TYPE));
      label3682:
      i = paramCursor.getColumnIndex("iIsGodFlag");
      if (i != -1) {
        break label6863;
      }
      paramatmz.a(new NoColumnError("iIsGodFlag", Integer.TYPE));
      label3717:
      i = paramCursor.getColumnIndex("strGodJumpUrl");
      if (i != -1) {
        break label6878;
      }
      paramatmz.a(new NoColumnError("strGodJumpUrl", String.class));
      label3752:
      i = paramCursor.getColumnIndex("mHeartNum");
      if (i != -1) {
        break label6893;
      }
      paramatmz.a(new NoColumnError("mHeartNum", Integer.TYPE));
      label3787:
      i = paramCursor.getColumnIndex("switchQzone");
      if (i != -1) {
        break label6908;
      }
      paramatmz.a(new NoColumnError("switchQzone", Boolean.TYPE));
      i = paramCursor.getColumnIndex("switchHobby");
      if (i != -1) {
        break label6935;
      }
      paramatmz.a(new NoColumnError("switchHobby", Boolean.TYPE));
      i = paramCursor.getColumnIndex("uiShowControl");
      if (i != -1) {
        break label6962;
      }
      paramatmz.a(new NoColumnError("uiShowControl", Long.TYPE));
      label3892:
      i = paramCursor.getColumnIndex("userFlag");
      if (i != -1) {
        break label6977;
      }
      paramatmz.a(new NoColumnError("userFlag", Long.TYPE));
      label3927:
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label6992;
      }
      paramatmz.a(new NoColumnError("busiEntry", String.class));
      label3962:
      i = paramCursor.getColumnIndex("godFlag");
      if (i != -1) {
        break label7007;
      }
      paramatmz.a(new NoColumnError("godFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("nLastGameFlag");
      if (i != -1) {
        break label7034;
      }
      paramatmz.a(new NoColumnError("nLastGameFlag", Integer.TYPE));
      label4032:
      i = paramCursor.getColumnIndex("strProfileUrl");
      if (i != -1) {
        break label7049;
      }
      paramatmz.a(new NoColumnError("strProfileUrl", String.class));
      label4069:
      i = paramCursor.getColumnIndex("lastUpdateNickTime");
      if (i != -1) {
        break label7064;
      }
      paramatmz.a(new NoColumnError("lastUpdateNickTime", Long.TYPE));
      label4106:
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label7079;
      }
      paramatmz.a(new NoColumnError("favoriteSource", Integer.TYPE));
      label4143:
      i = paramCursor.getColumnIndex("switchGiftVisible");
      if (i != -1) {
        break label7094;
      }
      paramatmz.a(new NoColumnError("switchGiftVisible", Long.TYPE));
      label4180:
      i = paramCursor.getColumnIndex("vGiftInfo");
      if (i != -1) {
        break label7109;
      }
      paramatmz.a(new NoColumnError("vGiftInfo", [B.class));
      label4217:
      i = paramCursor.getColumnIndex("sayHelloFlag");
      if (i != -1) {
        break label7124;
      }
      paramatmz.a(new NoColumnError("sayHelloFlag", Integer.TYPE));
      label4254:
      i = paramCursor.getColumnIndex("charm");
      if (i != -1) {
        break label7139;
      }
      paramatmz.a(new NoColumnError("charm", Long.TYPE));
      label4291:
      i = paramCursor.getColumnIndex("charmLevel");
      if (i != -1) {
        break label7154;
      }
      paramatmz.a(new NoColumnError("charmLevel", Integer.TYPE));
      label4328:
      i = paramCursor.getColumnIndex("nextThreshold");
      if (i != -1) {
        break label7169;
      }
      paramatmz.a(new NoColumnError("nextThreshold", Integer.TYPE));
      label4365:
      i = paramCursor.getColumnIndex("curThreshold");
      if (i != -1) {
        break label7184;
      }
      paramatmz.a(new NoColumnError("curThreshold", Integer.TYPE));
      label4402:
      i = paramCursor.getColumnIndex("profPercent");
      if (i != -1) {
        break label7199;
      }
      paramatmz.a(new NoColumnError("profPercent", Integer.TYPE));
      label4439:
      i = paramCursor.getColumnIndex("taskFinished");
      if (i != -1) {
        break label7214;
      }
      paramatmz.a(new NoColumnError("taskFinished", Integer.TYPE));
      label4476:
      i = paramCursor.getColumnIndex("taskTotal");
      if (i != -1) {
        break label7229;
      }
      paramatmz.a(new NoColumnError("taskTotal", Integer.TYPE));
      label4513:
      i = paramCursor.getColumnIndex("hiWanInfo");
      if (i != -1) {
        break label7244;
      }
      paramatmz.a(new NoColumnError("hiWanInfo", String.class));
      label4550:
      i = paramCursor.getColumnIndex("commonLabelString");
      if (i != -1) {
        break label7259;
      }
      paramatmz.a(new NoColumnError("commonLabelString", String.class));
      label4587:
      i = paramCursor.getColumnIndex("tagFlag");
      if (i != -1) {
        break label7274;
      }
      paramatmz.a(new NoColumnError("tagFlag", Long.TYPE));
      label4624:
      i = paramCursor.getColumnIndex("tagInfo");
      if (i != -1) {
        break label7289;
      }
      paramatmz.a(new NoColumnError("tagInfo", String.class));
      label4661:
      i = paramCursor.getColumnIndex("picInfo");
      if (i != -1) {
        break label7304;
      }
      paramatmz.a(new NoColumnError("picInfo", String.class));
      label4698:
      i = paramCursor.getColumnIndex("videoDetails");
      if (i != -1) {
        break label7319;
      }
      paramatmz.a(new NoColumnError("videoDetails", String.class));
      label4735:
      i = paramCursor.getColumnIndex("strFreshNewsInfo");
      if (i != -1) {
        break label7334;
      }
      paramatmz.a(new NoColumnError("strFreshNewsInfo", String.class));
      label4772:
      i = paramCursor.getColumnIndex("strHotChatInfo");
      if (i != -1) {
        break label7349;
      }
      paramatmz.a(new NoColumnError("strHotChatInfo", String.class));
      label4809:
      i = paramCursor.getColumnIndex("uRoomid");
      if (i != -1) {
        break label7364;
      }
      paramatmz.a(new NoColumnError("uRoomid", Long.TYPE));
      label4846:
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label7379;
      }
      paramatmz.a(new NoColumnError("strVoteLimitedNotice", String.class));
      label4883:
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label7394;
      }
      paramatmz.a(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      label4920:
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label7409;
      }
      paramatmz.a(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      label4957:
      i = paramCursor.getColumnIndex("collegeId");
      if (i != -1) {
        break label7424;
      }
      paramatmz.a(new NoColumnError("collegeId", Long.TYPE));
      label4994:
      i = paramCursor.getColumnIndex("videoHeadFlag");
      if (i != -1) {
        break label7439;
      }
      paramatmz.a(new NoColumnError("videoHeadFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("bVideoHeadUrl");
      if (i != -1) {
        break label7466;
      }
      paramatmz.a(new NoColumnError("bVideoHeadUrl", String.class));
      label5068:
      i = paramCursor.getColumnIndex("faceScoreWordingColor");
      if (i != -1) {
        break label7481;
      }
      paramatmz.a(new NoColumnError("faceScoreWordingColor", Integer.TYPE));
      label5105:
      i = paramCursor.getColumnIndex("faceScoreWording");
      if (i != -1) {
        break label7496;
      }
      paramatmz.a(new NoColumnError("faceScoreWording", String.class));
      label5142:
      i = paramCursor.getColumnIndex("faceScoreTailWordingColor");
      if (i != -1) {
        break label7511;
      }
      paramatmz.a(new NoColumnError("faceScoreTailWordingColor", Integer.TYPE));
      label5179:
      i = paramCursor.getColumnIndex("faceScoreTailWording");
      if (i != -1) {
        break label7526;
      }
      paramatmz.a(new NoColumnError("faceScoreTailWording", String.class));
      label5216:
      i = paramCursor.getColumnIndex("faceScoreIconUrl");
      if (i != -1) {
        break label7541;
      }
      paramatmz.a(new NoColumnError("faceScoreIconUrl", String.class));
      label5253:
      i = paramCursor.getColumnIndex("entryAbility");
      if (i != -1) {
        break label7556;
      }
      paramatmz.a(new NoColumnError("entryAbility", Integer.TYPE));
      label5290:
      i = paramCursor.getColumnIndex("strLevelType");
      if (i != -1) {
        break label7571;
      }
      paramatmz.a(new NoColumnError("strLevelType", String.class));
      label5327:
      i = paramCursor.getColumnIndex("maskMsgFlag");
      if (i != -1) {
        break label7586;
      }
      paramatmz.a(new NoColumnError("maskMsgFlag", Integer.TYPE));
      label5364:
      i = paramCursor.getColumnIndex("isForbidSendMsg");
      if (i != -1) {
        break label7601;
      }
      paramatmz.a(new NoColumnError("isForbidSendMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isForbidSendGiftMsg");
      if (i != -1) {
        break label7628;
      }
      paramatmz.a(new NoColumnError("isForbidSendGiftMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("disableSendMsgBtnTips");
      if (i != -1) {
        break label7655;
      }
      paramatmz.a(new NoColumnError("disableSendMsgBtnTips", String.class));
      label5475:
      i = paramCursor.getColumnIndex("disableSendGiftBtnTips");
      if (i != -1) {
        break label7670;
      }
      paramatmz.a(new NoColumnError("disableSendGiftBtnTips", String.class));
      label5512:
      i = paramCursor.getColumnIndex("isForbidSendMsgForTribar");
      if (i != -1) {
        break label7685;
      }
      paramatmz.a(new NoColumnError("isForbidSendMsgForTribar", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isForbidSendGiftMsgForTribar");
      if (i != -1) {
        break label7712;
      }
      paramatmz.a(new NoColumnError("isForbidSendGiftMsgForTribar", Boolean.TYPE));
      i = paramCursor.getColumnIndex("disableSendMsgBtnTipsForTribar");
      if (i != -1) {
        break label7739;
      }
      paramatmz.a(new NoColumnError("disableSendMsgBtnTipsForTribar", String.class));
      label5623:
      i = paramCursor.getColumnIndex("disableSendGiftBtnTipsForTribar");
      if (i != -1) {
        break label7754;
      }
      paramatmz.a(new NoColumnError("disableSendGiftBtnTipsForTribar", String.class));
      label5660:
      i = paramCursor.getColumnIndex("highScoreNum");
      if (i != -1) {
        break label7769;
      }
      paramatmz.a(new NoColumnError("highScoreNum", Integer.TYPE));
      label5697:
      i = paramCursor.getColumnIndex("mHasStory");
      if (i != -1) {
        break label7784;
      }
      paramatmz.a(new NoColumnError("mHasStory", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mQQStoryData");
      if (i != -1) {
        break label7811;
      }
      paramatmz.a(new NoColumnError("mQQStoryData", [B.class));
      label5771:
      i = paramCursor.getColumnIndex("isSendMsgBtnDownloadAppOpen");
      if (i != -1) {
        break label7826;
      }
      paramatmz.a(new NoColumnError("isSendMsgBtnDownloadAppOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sendMsgBtnDownloadAppTips");
      if (i != -1) {
        break label7854;
      }
      paramatmz.a(new NoColumnError("sendMsgBtnDownloadAppTips", String.class));
      label5845:
      i = paramCursor.getColumnIndex("addPicBtnDownloadAppTips");
      if (i != -1) {
        break label7869;
      }
      paramatmz.a(new NoColumnError("addPicBtnDownloadAppTips", String.class));
      label5882:
      i = paramCursor.getColumnIndex("tribeAppDownloadPageUrl");
      if (i != -1) {
        break label7884;
      }
      paramatmz.a(new NoColumnError("tribeAppDownloadPageUrl", String.class));
      label5919:
      i = paramCursor.getColumnIndex("nearbyNowDataBytes");
      if (i != -1) {
        break label7899;
      }
      paramatmz.a(new NoColumnError("nearbyNowDataBytes", [B.class));
      label5956:
      i = paramCursor.getColumnIndex("guideAppNowTip");
      if (i != -1) {
        break label7914;
      }
      paramatmz.a(new NoColumnError("guideAppNowTip", String.class));
      label5993:
      i = paramCursor.getColumnIndex("guideAppNowTipLeftBtn");
      if (i != -1) {
        break label7929;
      }
      paramatmz.a(new NoColumnError("guideAppNowTipLeftBtn", String.class));
      label6030:
      i = paramCursor.getColumnIndex("guideAppNowTipRightBtnInstalled");
      if (i != -1) {
        break label7944;
      }
      paramatmz.a(new NoColumnError("guideAppNowTipRightBtnInstalled", String.class));
      label6067:
      i = paramCursor.getColumnIndex("guideAppNowTipRightBtnNotInstalled");
      if (i != -1) {
        break label7959;
      }
      paramatmz.a(new NoColumnError("guideAppNowTipRightBtnNotInstalled", String.class));
      label6104:
      i = paramCursor.getColumnIndex("guideAppNowPackage");
      if (i != -1) {
        break label7974;
      }
      paramatmz.a(new NoColumnError("guideAppNowPackage", String.class));
      label6141:
      i = paramCursor.getColumnIndex("guideAppNowJumpUri");
      if (i != -1) {
        break label7989;
      }
      paramatmz.a(new NoColumnError("guideAppNowJumpUri", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("guideAppNowDownloadUrl");
      if (i != -1) {
        break label8004;
      }
      paramatmz.a(new NoColumnError("guideAppNowDownloadUrl", String.class));
      return paramatmo;
      paramatmo.tinyId = paramCursor.getLong(i);
      break;
      label6232:
      paramatmo.uin = paramCursor.getString(i);
      break label2282;
      label6247:
      paramatmo.nowId = paramCursor.getLong(i);
      break label2317;
      label6262:
      paramatmo.nowUserType = paramCursor.getInt(i);
      break label2352;
      label6277:
      paramatmo.strRemark = paramCursor.getString(i);
      break label2387;
      label6292:
      paramatmo.nickname = paramCursor.getString(i);
      break label2422;
      label6307:
      paramatmo.gender = ((byte)paramCursor.getShort(i));
      break label2457;
      label6323:
      paramatmo.age = paramCursor.getInt(i);
      break label2492;
      label6338:
      paramatmo.birthday = paramCursor.getInt(i);
      break label2527;
      label6353:
      paramatmo.constellation = ((byte)paramCursor.getShort(i));
      break label2562;
      label6369:
      paramatmo.distance = paramCursor.getString(i);
      break label2597;
      label6384:
      paramatmo.timeDiff = paramCursor.getString(i);
      break label2632;
      label6399:
      paramatmo.aioDistanceAndTime = paramCursor.getString(i);
      break label2667;
      label6414:
      paramatmo.likeCount = paramCursor.getInt(i);
      break label2702;
      label6429:
      paramatmo.likeCountInc = paramCursor.getInt(i);
      break label2737;
      label6444:
      paramatmo.oldPhotoCount = paramCursor.getInt(i);
      break label2772;
      label6459:
      paramatmo.dateInfo = paramCursor.getBlob(i);
      break label2807;
      label6474:
      paramatmo.ulShowControl = paramCursor.getLong(i);
      break label2842;
      label6489:
      paramatmo.xuanYan = paramCursor.getBlob(i);
      break label2877;
      label6504:
      paramatmo.maritalStatus = ((byte)paramCursor.getShort(i));
      break label2912;
      label6520:
      paramatmo.job = paramCursor.getInt(i);
      break label2947;
      label6535:
      paramatmo.company = paramCursor.getString(i);
      break label2982;
      label6550:
      paramatmo.college = paramCursor.getString(i);
      break label3017;
      label6565:
      paramatmo.hometownCountry = paramCursor.getString(i);
      break label3052;
      label6580:
      paramatmo.hometownProvice = paramCursor.getString(i);
      break label3087;
      label6595:
      paramatmo.hometownCity = paramCursor.getString(i);
      break label3122;
      label6610:
      paramatmo.hometownDistrict = paramCursor.getString(i);
      break label3157;
      label6625:
      paramatmo.vCookies = paramCursor.getBlob(i);
      break label3192;
      label6640:
      paramatmo.bVoted = ((byte)paramCursor.getShort(i));
      break label3227;
      label6656:
      paramatmo.feedPreviewTime = paramCursor.getLong(i);
      break label3262;
      label6671:
      paramatmo.qzoneFeed = paramCursor.getString(i);
      break label3297;
      label6686:
      paramatmo.qzoneName = paramCursor.getString(i);
      break label3332;
      label6701:
      paramatmo.qzonePicUrl_1 = paramCursor.getString(i);
      break label3367;
      label6716:
      paramatmo.qzonePicUrl_2 = paramCursor.getString(i);
      break label3402;
      label6731:
      paramatmo.qzonePicUrl_3 = paramCursor.getString(i);
      break label3437;
      label6746:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isPhotoUseCache = paramBoolean;
        break;
      }
      label6773:
      paramatmo.vSeed = paramCursor.getBlob(i);
      break label3507;
      label6788:
      paramatmo.vTempChatSig = paramCursor.getBlob(i);
      break label3542;
      label6803:
      paramatmo.vGroupList = paramCursor.getBlob(i);
      break label3577;
      label6818:
      paramatmo.nearbyInfo = paramCursor.getBlob(i);
      break label3612;
      label6833:
      paramatmo.vActivityList = paramCursor.getBlob(i);
      break label3647;
      label6848:
      paramatmo.lUserFlag = paramCursor.getLong(i);
      break label3682;
      label6863:
      paramatmo.iIsGodFlag = paramCursor.getInt(i);
      break label3717;
      label6878:
      paramatmo.strGodJumpUrl = paramCursor.getString(i);
      break label3752;
      label6893:
      paramatmo.mHeartNum = paramCursor.getInt(i);
      break label3787;
      label6908:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.switchQzone = paramBoolean;
        break;
      }
      label6935:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.switchHobby = paramBoolean;
        break;
      }
      label6962:
      paramatmo.uiShowControl = paramCursor.getLong(i);
      break label3892;
      label6977:
      paramatmo.userFlag = paramCursor.getLong(i);
      break label3927;
      label6992:
      paramatmo.busiEntry = paramCursor.getString(i);
      break label3962;
      label7007:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.godFlag = paramBoolean;
        break;
      }
      label7034:
      paramatmo.nLastGameFlag = paramCursor.getInt(i);
      break label4032;
      label7049:
      paramatmo.strProfileUrl = paramCursor.getString(i);
      break label4069;
      label7064:
      paramatmo.lastUpdateNickTime = paramCursor.getLong(i);
      break label4106;
      label7079:
      paramatmo.favoriteSource = paramCursor.getInt(i);
      break label4143;
      label7094:
      paramatmo.switchGiftVisible = paramCursor.getLong(i);
      break label4180;
      label7109:
      paramatmo.vGiftInfo = paramCursor.getBlob(i);
      break label4217;
      label7124:
      paramatmo.sayHelloFlag = paramCursor.getInt(i);
      break label4254;
      label7139:
      paramatmo.charm = paramCursor.getLong(i);
      break label4291;
      label7154:
      paramatmo.charmLevel = paramCursor.getInt(i);
      break label4328;
      label7169:
      paramatmo.nextThreshold = paramCursor.getInt(i);
      break label4365;
      label7184:
      paramatmo.curThreshold = paramCursor.getInt(i);
      break label4402;
      label7199:
      paramatmo.profPercent = paramCursor.getInt(i);
      break label4439;
      label7214:
      paramatmo.taskFinished = paramCursor.getInt(i);
      break label4476;
      label7229:
      paramatmo.taskTotal = paramCursor.getInt(i);
      break label4513;
      label7244:
      paramatmo.hiWanInfo = paramCursor.getString(i);
      break label4550;
      label7259:
      paramatmo.commonLabelString = paramCursor.getString(i);
      break label4587;
      label7274:
      paramatmo.tagFlag = paramCursor.getLong(i);
      break label4624;
      label7289:
      paramatmo.tagInfo = paramCursor.getString(i);
      break label4661;
      label7304:
      paramatmo.picInfo = paramCursor.getString(i);
      break label4698;
      label7319:
      paramatmo.videoDetails = paramCursor.getString(i);
      break label4735;
      label7334:
      paramatmo.strFreshNewsInfo = paramCursor.getString(i);
      break label4772;
      label7349:
      paramatmo.strHotChatInfo = paramCursor.getString(i);
      break label4809;
      label7364:
      paramatmo.uRoomid = paramCursor.getLong(i);
      break label4846;
      label7379:
      paramatmo.strVoteLimitedNotice = paramCursor.getString(i);
      break label4883;
      label7394:
      paramatmo.bHaveVotedCnt = paramCursor.getShort(i);
      break label4920;
      label7409:
      paramatmo.bAvailVoteCnt = paramCursor.getShort(i);
      break label4957;
      label7424:
      paramatmo.collegeId = paramCursor.getLong(i);
      break label4994;
      label7439:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.videoHeadFlag = paramBoolean;
        break;
      }
      label7466:
      paramatmo.bVideoHeadUrl = paramCursor.getString(i);
      break label5068;
      label7481:
      paramatmo.faceScoreWordingColor = paramCursor.getInt(i);
      break label5105;
      label7496:
      paramatmo.faceScoreWording = paramCursor.getString(i);
      break label5142;
      label7511:
      paramatmo.faceScoreTailWordingColor = paramCursor.getInt(i);
      break label5179;
      label7526:
      paramatmo.faceScoreTailWording = paramCursor.getString(i);
      break label5216;
      label7541:
      paramatmo.faceScoreIconUrl = paramCursor.getString(i);
      break label5253;
      label7556:
      paramatmo.entryAbility = paramCursor.getInt(i);
      break label5290;
      label7571:
      paramatmo.strLevelType = paramCursor.getString(i);
      break label5327;
      label7586:
      paramatmo.maskMsgFlag = paramCursor.getInt(i);
      break label5364;
      label7601:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isForbidSendMsg = paramBoolean;
        break;
      }
      label7628:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isForbidSendGiftMsg = paramBoolean;
        break;
      }
      label7655:
      paramatmo.disableSendMsgBtnTips = paramCursor.getString(i);
      break label5475;
      label7670:
      paramatmo.disableSendGiftBtnTips = paramCursor.getString(i);
      break label5512;
      label7685:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isForbidSendMsgForTribar = paramBoolean;
        break;
      }
      label7712:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isForbidSendGiftMsgForTribar = paramBoolean;
        break;
      }
      label7739:
      paramatmo.disableSendMsgBtnTipsForTribar = paramCursor.getString(i);
      break label5623;
      label7754:
      paramatmo.disableSendGiftBtnTipsForTribar = paramCursor.getString(i);
      break label5660;
      label7769:
      paramatmo.highScoreNum = paramCursor.getInt(i);
      break label5697;
      label7784:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.mHasStory = paramBoolean;
        break;
      }
      label7811:
      paramatmo.mQQStoryData = paramCursor.getBlob(i);
      break label5771;
      label7826:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramatmo.isSendMsgBtnDownloadAppOpen = paramBoolean;
        break;
      }
      label7854:
      paramatmo.sendMsgBtnDownloadAppTips = paramCursor.getString(i);
      break label5845;
      label7869:
      paramatmo.addPicBtnDownloadAppTips = paramCursor.getString(i);
      break label5882;
      label7884:
      paramatmo.tribeAppDownloadPageUrl = paramCursor.getString(i);
      break label5919;
      label7899:
      paramatmo.nearbyNowDataBytes = paramCursor.getBlob(i);
      break label5956;
      label7914:
      paramatmo.guideAppNowTip = paramCursor.getString(i);
      break label5993;
      label7929:
      paramatmo.guideAppNowTipLeftBtn = paramCursor.getString(i);
      break label6030;
      label7944:
      paramatmo.guideAppNowTipRightBtnInstalled = paramCursor.getString(i);
      break label6067;
      label7959:
      paramatmo.guideAppNowTipRightBtnNotInstalled = paramCursor.getString(i);
      break label6104;
      label7974:
      paramatmo.guideAppNowPackage = paramCursor.getString(i);
      break label6141;
      label7989:
      paramatmo.guideAppNowJumpUri = paramCursor.getString(i);
    }
    label8004:
    paramatmo.guideAppNowDownloadUrl = paramCursor.getString(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,tinyId INTEGER ,uin TEXT ,nowId INTEGER ,nowUserType INTEGER ,strRemark TEXT ,nickname TEXT ,gender INTEGER ,age INTEGER ,birthday INTEGER ,constellation INTEGER ,distance TEXT ,timeDiff TEXT ,aioDistanceAndTime TEXT ,likeCount INTEGER ,likeCountInc INTEGER ,oldPhotoCount INTEGER ,dateInfo BLOB ,ulShowControl INTEGER ,xuanYan BLOB ,maritalStatus INTEGER ,job INTEGER ,company TEXT ,college TEXT ,hometownCountry TEXT ,hometownProvice TEXT ,hometownCity TEXT ,hometownDistrict TEXT ,vCookies BLOB ,bVoted INTEGER ,feedPreviewTime INTEGER ,qzoneFeed TEXT ,qzoneName TEXT ,qzonePicUrl_1 TEXT ,qzonePicUrl_2 TEXT ,qzonePicUrl_3 TEXT ,isPhotoUseCache INTEGER ,vSeed BLOB ,vTempChatSig BLOB ,vGroupList BLOB ,nearbyInfo BLOB ,vActivityList BLOB ,lUserFlag INTEGER ,iIsGodFlag INTEGER ,strGodJumpUrl TEXT ,mHeartNum INTEGER ,switchQzone INTEGER ,switchHobby INTEGER ,uiShowControl INTEGER ,userFlag INTEGER ,busiEntry TEXT ,godFlag INTEGER ,nLastGameFlag INTEGER ,strProfileUrl TEXT ,lastUpdateNickTime INTEGER ,favoriteSource INTEGER ,switchGiftVisible INTEGER ,vGiftInfo BLOB ,sayHelloFlag INTEGER ,charm INTEGER ,charmLevel INTEGER ,nextThreshold INTEGER ,curThreshold INTEGER ,profPercent INTEGER ,taskFinished INTEGER ,taskTotal INTEGER ,hiWanInfo TEXT ,commonLabelString TEXT ,tagFlag INTEGER ,tagInfo TEXT ,picInfo TEXT ,videoDetails TEXT ,strFreshNewsInfo TEXT ,strHotChatInfo TEXT ,uRoomid INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,collegeId INTEGER ,videoHeadFlag INTEGER ,bVideoHeadUrl TEXT ,faceScoreWordingColor INTEGER ,faceScoreWording TEXT ,faceScoreTailWordingColor INTEGER ,faceScoreTailWording TEXT ,faceScoreIconUrl TEXT ,entryAbility INTEGER ,strLevelType TEXT ,maskMsgFlag INTEGER ,isForbidSendMsg INTEGER ,isForbidSendGiftMsg INTEGER ,disableSendMsgBtnTips TEXT ,disableSendGiftBtnTips TEXT ,isForbidSendMsgForTribar INTEGER ,isForbidSendGiftMsgForTribar INTEGER ,disableSendMsgBtnTipsForTribar TEXT ,disableSendGiftBtnTipsForTribar TEXT ,highScoreNum INTEGER ,mHasStory INTEGER ,mQQStoryData BLOB ,isSendMsgBtnDownloadAppOpen INTEGER ,sendMsgBtnDownloadAppTips TEXT ,addPicBtnDownloadAppTips TEXT ,tribeAppDownloadPageUrl TEXT ,nearbyNowDataBytes BLOB ,guideAppNowTip TEXT ,guideAppNowTipLeftBtn TEXT ,guideAppNowTipRightBtnInstalled TEXT ,guideAppNowTipRightBtnNotInstalled TEXT ,guideAppNowPackage TEXT ,guideAppNowJumpUri TEXT ,guideAppNowDownloadUrl TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (NearbyPeopleCard)paramatmo;
    paramContentValues.put("tinyId", Long.valueOf(paramatmo.tinyId));
    paramContentValues.put("uin", paramatmo.uin);
    paramContentValues.put("nowId", Long.valueOf(paramatmo.nowId));
    paramContentValues.put("nowUserType", Integer.valueOf(paramatmo.nowUserType));
    paramContentValues.put("strRemark", paramatmo.strRemark);
    paramContentValues.put("nickname", paramatmo.nickname);
    paramContentValues.put("gender", Byte.valueOf(paramatmo.gender));
    paramContentValues.put("age", Integer.valueOf(paramatmo.age));
    paramContentValues.put("birthday", Integer.valueOf(paramatmo.birthday));
    paramContentValues.put("constellation", Byte.valueOf(paramatmo.constellation));
    paramContentValues.put("distance", paramatmo.distance);
    paramContentValues.put("timeDiff", paramatmo.timeDiff);
    paramContentValues.put("aioDistanceAndTime", paramatmo.aioDistanceAndTime);
    paramContentValues.put("likeCount", Integer.valueOf(paramatmo.likeCount));
    paramContentValues.put("likeCountInc", Integer.valueOf(paramatmo.likeCountInc));
    paramContentValues.put("oldPhotoCount", Integer.valueOf(paramatmo.oldPhotoCount));
    paramContentValues.put("dateInfo", paramatmo.dateInfo);
    paramContentValues.put("ulShowControl", Long.valueOf(paramatmo.ulShowControl));
    paramContentValues.put("xuanYan", paramatmo.xuanYan);
    paramContentValues.put("maritalStatus", Byte.valueOf(paramatmo.maritalStatus));
    paramContentValues.put("job", Integer.valueOf(paramatmo.job));
    paramContentValues.put("company", paramatmo.company);
    paramContentValues.put("college", paramatmo.college);
    paramContentValues.put("hometownCountry", paramatmo.hometownCountry);
    paramContentValues.put("hometownProvice", paramatmo.hometownProvice);
    paramContentValues.put("hometownCity", paramatmo.hometownCity);
    paramContentValues.put("hometownDistrict", paramatmo.hometownDistrict);
    paramContentValues.put("vCookies", paramatmo.vCookies);
    paramContentValues.put("bVoted", Byte.valueOf(paramatmo.bVoted));
    paramContentValues.put("feedPreviewTime", Long.valueOf(paramatmo.feedPreviewTime));
    paramContentValues.put("qzoneFeed", paramatmo.qzoneFeed);
    paramContentValues.put("qzoneName", paramatmo.qzoneName);
    paramContentValues.put("qzonePicUrl_1", paramatmo.qzonePicUrl_1);
    paramContentValues.put("qzonePicUrl_2", paramatmo.qzonePicUrl_2);
    paramContentValues.put("qzonePicUrl_3", paramatmo.qzonePicUrl_3);
    paramContentValues.put("isPhotoUseCache", Boolean.valueOf(paramatmo.isPhotoUseCache));
    paramContentValues.put("vSeed", paramatmo.vSeed);
    paramContentValues.put("vTempChatSig", paramatmo.vTempChatSig);
    paramContentValues.put("vGroupList", paramatmo.vGroupList);
    paramContentValues.put("nearbyInfo", paramatmo.nearbyInfo);
    paramContentValues.put("vActivityList", paramatmo.vActivityList);
    paramContentValues.put("lUserFlag", Long.valueOf(paramatmo.lUserFlag));
    paramContentValues.put("iIsGodFlag", Integer.valueOf(paramatmo.iIsGodFlag));
    paramContentValues.put("strGodJumpUrl", paramatmo.strGodJumpUrl);
    paramContentValues.put("mHeartNum", Integer.valueOf(paramatmo.mHeartNum));
    paramContentValues.put("switchQzone", Boolean.valueOf(paramatmo.switchQzone));
    paramContentValues.put("switchHobby", Boolean.valueOf(paramatmo.switchHobby));
    paramContentValues.put("uiShowControl", Long.valueOf(paramatmo.uiShowControl));
    paramContentValues.put("userFlag", Long.valueOf(paramatmo.userFlag));
    paramContentValues.put("busiEntry", paramatmo.busiEntry);
    paramContentValues.put("godFlag", Boolean.valueOf(paramatmo.godFlag));
    paramContentValues.put("nLastGameFlag", Integer.valueOf(paramatmo.nLastGameFlag));
    paramContentValues.put("strProfileUrl", paramatmo.strProfileUrl);
    paramContentValues.put("lastUpdateNickTime", Long.valueOf(paramatmo.lastUpdateNickTime));
    paramContentValues.put("favoriteSource", Integer.valueOf(paramatmo.favoriteSource));
    paramContentValues.put("switchGiftVisible", Long.valueOf(paramatmo.switchGiftVisible));
    paramContentValues.put("vGiftInfo", paramatmo.vGiftInfo);
    paramContentValues.put("sayHelloFlag", Integer.valueOf(paramatmo.sayHelloFlag));
    paramContentValues.put("charm", Long.valueOf(paramatmo.charm));
    paramContentValues.put("charmLevel", Integer.valueOf(paramatmo.charmLevel));
    paramContentValues.put("nextThreshold", Integer.valueOf(paramatmo.nextThreshold));
    paramContentValues.put("curThreshold", Integer.valueOf(paramatmo.curThreshold));
    paramContentValues.put("profPercent", Integer.valueOf(paramatmo.profPercent));
    paramContentValues.put("taskFinished", Integer.valueOf(paramatmo.taskFinished));
    paramContentValues.put("taskTotal", Integer.valueOf(paramatmo.taskTotal));
    paramContentValues.put("hiWanInfo", paramatmo.hiWanInfo);
    paramContentValues.put("commonLabelString", paramatmo.commonLabelString);
    paramContentValues.put("tagFlag", Long.valueOf(paramatmo.tagFlag));
    paramContentValues.put("tagInfo", paramatmo.tagInfo);
    paramContentValues.put("picInfo", paramatmo.picInfo);
    paramContentValues.put("videoDetails", paramatmo.videoDetails);
    paramContentValues.put("strFreshNewsInfo", paramatmo.strFreshNewsInfo);
    paramContentValues.put("strHotChatInfo", paramatmo.strHotChatInfo);
    paramContentValues.put("uRoomid", Long.valueOf(paramatmo.uRoomid));
    paramContentValues.put("strVoteLimitedNotice", paramatmo.strVoteLimitedNotice);
    paramContentValues.put("bHaveVotedCnt", Short.valueOf(paramatmo.bHaveVotedCnt));
    paramContentValues.put("bAvailVoteCnt", Short.valueOf(paramatmo.bAvailVoteCnt));
    paramContentValues.put("collegeId", Long.valueOf(paramatmo.collegeId));
    paramContentValues.put("videoHeadFlag", Boolean.valueOf(paramatmo.videoHeadFlag));
    paramContentValues.put("bVideoHeadUrl", paramatmo.bVideoHeadUrl);
    paramContentValues.put("faceScoreWordingColor", Integer.valueOf(paramatmo.faceScoreWordingColor));
    paramContentValues.put("faceScoreWording", paramatmo.faceScoreWording);
    paramContentValues.put("faceScoreTailWordingColor", Integer.valueOf(paramatmo.faceScoreTailWordingColor));
    paramContentValues.put("faceScoreTailWording", paramatmo.faceScoreTailWording);
    paramContentValues.put("faceScoreIconUrl", paramatmo.faceScoreIconUrl);
    paramContentValues.put("entryAbility", Integer.valueOf(paramatmo.entryAbility));
    paramContentValues.put("strLevelType", paramatmo.strLevelType);
    paramContentValues.put("maskMsgFlag", Integer.valueOf(paramatmo.maskMsgFlag));
    paramContentValues.put("isForbidSendMsg", Boolean.valueOf(paramatmo.isForbidSendMsg));
    paramContentValues.put("isForbidSendGiftMsg", Boolean.valueOf(paramatmo.isForbidSendGiftMsg));
    paramContentValues.put("disableSendMsgBtnTips", paramatmo.disableSendMsgBtnTips);
    paramContentValues.put("disableSendGiftBtnTips", paramatmo.disableSendGiftBtnTips);
    paramContentValues.put("isForbidSendMsgForTribar", Boolean.valueOf(paramatmo.isForbidSendMsgForTribar));
    paramContentValues.put("isForbidSendGiftMsgForTribar", Boolean.valueOf(paramatmo.isForbidSendGiftMsgForTribar));
    paramContentValues.put("disableSendMsgBtnTipsForTribar", paramatmo.disableSendMsgBtnTipsForTribar);
    paramContentValues.put("disableSendGiftBtnTipsForTribar", paramatmo.disableSendGiftBtnTipsForTribar);
    paramContentValues.put("highScoreNum", Integer.valueOf(paramatmo.highScoreNum));
    paramContentValues.put("mHasStory", Boolean.valueOf(paramatmo.mHasStory));
    paramContentValues.put("mQQStoryData", paramatmo.mQQStoryData);
    paramContentValues.put("isSendMsgBtnDownloadAppOpen", Boolean.valueOf(paramatmo.isSendMsgBtnDownloadAppOpen));
    paramContentValues.put("sendMsgBtnDownloadAppTips", paramatmo.sendMsgBtnDownloadAppTips);
    paramContentValues.put("addPicBtnDownloadAppTips", paramatmo.addPicBtnDownloadAppTips);
    paramContentValues.put("tribeAppDownloadPageUrl", paramatmo.tribeAppDownloadPageUrl);
    paramContentValues.put("nearbyNowDataBytes", paramatmo.nearbyNowDataBytes);
    paramContentValues.put("guideAppNowTip", paramatmo.guideAppNowTip);
    paramContentValues.put("guideAppNowTipLeftBtn", paramatmo.guideAppNowTipLeftBtn);
    paramContentValues.put("guideAppNowTipRightBtnInstalled", paramatmo.guideAppNowTipRightBtnInstalled);
    paramContentValues.put("guideAppNowTipRightBtnNotInstalled", paramatmo.guideAppNowTipRightBtnNotInstalled);
    paramContentValues.put("guideAppNowPackage", paramatmo.guideAppNowPackage);
    paramContentValues.put("guideAppNowJumpUri", paramatmo.guideAppNowJumpUri);
    paramContentValues.put("guideAppNowDownloadUrl", paramatmo.guideAppNowDownloadUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atmy
 * JD-Core Version:    0.7.0.1
 */