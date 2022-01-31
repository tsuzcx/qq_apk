import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awcf
  extends awch
{
  public awcf()
  {
    this.a = 111;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawbv = (NearbyPeopleCard)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.tinyId = paramCursor.getLong(paramCursor.getColumnIndex("tinyId"));
      paramawbv.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawbv.nowId = paramCursor.getLong(paramCursor.getColumnIndex("nowId"));
      paramawbv.nowUserType = paramCursor.getInt(paramCursor.getColumnIndex("nowUserType"));
      paramawbv.strRemark = paramCursor.getString(paramCursor.getColumnIndex("strRemark"));
      paramawbv.nickname = paramCursor.getString(paramCursor.getColumnIndex("nickname"));
      paramawbv.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
      paramawbv.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
      paramawbv.birthday = paramCursor.getInt(paramCursor.getColumnIndex("birthday"));
      paramawbv.constellation = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("constellation")));
      paramawbv.distance = paramCursor.getString(paramCursor.getColumnIndex("distance"));
      paramawbv.timeDiff = paramCursor.getString(paramCursor.getColumnIndex("timeDiff"));
      paramawbv.aioDistanceAndTime = paramCursor.getString(paramCursor.getColumnIndex("aioDistanceAndTime"));
      paramawbv.likeCount = paramCursor.getInt(paramCursor.getColumnIndex("likeCount"));
      paramawbv.likeCountInc = paramCursor.getInt(paramCursor.getColumnIndex("likeCountInc"));
      paramawbv.oldPhotoCount = paramCursor.getInt(paramCursor.getColumnIndex("oldPhotoCount"));
      paramawbv.dateInfo = paramCursor.getBlob(paramCursor.getColumnIndex("dateInfo"));
      paramawbv.ulShowControl = paramCursor.getLong(paramCursor.getColumnIndex("ulShowControl"));
      paramawbv.xuanYan = paramCursor.getBlob(paramCursor.getColumnIndex("xuanYan"));
      paramawbv.maritalStatus = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("maritalStatus")));
      paramawbv.job = paramCursor.getInt(paramCursor.getColumnIndex("job"));
      paramawbv.company = paramCursor.getString(paramCursor.getColumnIndex("company"));
      paramawbv.college = paramCursor.getString(paramCursor.getColumnIndex("college"));
      paramawbv.hometownCountry = paramCursor.getString(paramCursor.getColumnIndex("hometownCountry"));
      paramawbv.hometownProvice = paramCursor.getString(paramCursor.getColumnIndex("hometownProvice"));
      paramawbv.hometownCity = paramCursor.getString(paramCursor.getColumnIndex("hometownCity"));
      paramawbv.hometownDistrict = paramCursor.getString(paramCursor.getColumnIndex("hometownDistrict"));
      paramawbv.vCookies = paramCursor.getBlob(paramCursor.getColumnIndex("vCookies"));
      paramawbv.bVoted = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bVoted")));
      paramawbv.feedPreviewTime = paramCursor.getLong(paramCursor.getColumnIndex("feedPreviewTime"));
      paramawbv.qzoneFeed = paramCursor.getString(paramCursor.getColumnIndex("qzoneFeed"));
      paramawbv.qzoneName = paramCursor.getString(paramCursor.getColumnIndex("qzoneName"));
      paramawbv.qzonePicUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_1"));
      paramawbv.qzonePicUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_2"));
      paramawbv.qzonePicUrl_3 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_3"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isPhotoUseCache")))
      {
        paramBoolean = true;
        paramawbv.isPhotoUseCache = paramBoolean;
        paramawbv.vSeed = paramCursor.getBlob(paramCursor.getColumnIndex("vSeed"));
        paramawbv.vTempChatSig = paramCursor.getBlob(paramCursor.getColumnIndex("vTempChatSig"));
        paramawbv.vGroupList = paramCursor.getBlob(paramCursor.getColumnIndex("vGroupList"));
        paramawbv.nearbyInfo = paramCursor.getBlob(paramCursor.getColumnIndex("nearbyInfo"));
        paramawbv.vActivityList = paramCursor.getBlob(paramCursor.getColumnIndex("vActivityList"));
        paramawbv.lUserFlag = paramCursor.getLong(paramCursor.getColumnIndex("lUserFlag"));
        paramawbv.iIsGodFlag = paramCursor.getInt(paramCursor.getColumnIndex("iIsGodFlag"));
        paramawbv.strGodJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("strGodJumpUrl"));
        paramawbv.mHeartNum = paramCursor.getInt(paramCursor.getColumnIndex("mHeartNum"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("switchQzone"))) {
          break label2162;
        }
        paramBoolean = true;
        label857:
        paramawbv.switchQzone = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("switchHobby"))) {
          break label2167;
        }
        paramBoolean = true;
        label882:
        paramawbv.switchHobby = paramBoolean;
        paramawbv.uiShowControl = paramCursor.getLong(paramCursor.getColumnIndex("uiShowControl"));
        paramawbv.userFlag = paramCursor.getLong(paramCursor.getColumnIndex("userFlag"));
        paramawbv.busiEntry = paramCursor.getString(paramCursor.getColumnIndex("busiEntry"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("godFlag"))) {
          break label2172;
        }
        paramBoolean = true;
        label961:
        paramawbv.godFlag = paramBoolean;
        paramawbv.nLastGameFlag = paramCursor.getInt(paramCursor.getColumnIndex("nLastGameFlag"));
        paramawbv.strProfileUrl = paramCursor.getString(paramCursor.getColumnIndex("strProfileUrl"));
        paramawbv.lastUpdateNickTime = paramCursor.getLong(paramCursor.getColumnIndex("lastUpdateNickTime"));
        paramawbv.favoriteSource = paramCursor.getInt(paramCursor.getColumnIndex("favoriteSource"));
        paramawbv.switchGiftVisible = paramCursor.getLong(paramCursor.getColumnIndex("switchGiftVisible"));
        paramawbv.vGiftInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vGiftInfo"));
        paramawbv.sayHelloFlag = paramCursor.getInt(paramCursor.getColumnIndex("sayHelloFlag"));
        paramawbv.charm = paramCursor.getLong(paramCursor.getColumnIndex("charm"));
        paramawbv.charmLevel = paramCursor.getInt(paramCursor.getColumnIndex("charmLevel"));
        paramawbv.nextThreshold = paramCursor.getInt(paramCursor.getColumnIndex("nextThreshold"));
        paramawbv.curThreshold = paramCursor.getInt(paramCursor.getColumnIndex("curThreshold"));
        paramawbv.profPercent = paramCursor.getInt(paramCursor.getColumnIndex("profPercent"));
        paramawbv.taskFinished = paramCursor.getInt(paramCursor.getColumnIndex("taskFinished"));
        paramawbv.taskTotal = paramCursor.getInt(paramCursor.getColumnIndex("taskTotal"));
        paramawbv.hiWanInfo = paramCursor.getString(paramCursor.getColumnIndex("hiWanInfo"));
        paramawbv.commonLabelString = paramCursor.getString(paramCursor.getColumnIndex("commonLabelString"));
        paramawbv.tagFlag = paramCursor.getLong(paramCursor.getColumnIndex("tagFlag"));
        paramawbv.tagInfo = paramCursor.getString(paramCursor.getColumnIndex("tagInfo"));
        paramawbv.picInfo = paramCursor.getString(paramCursor.getColumnIndex("picInfo"));
        paramawbv.videoDetails = paramCursor.getString(paramCursor.getColumnIndex("videoDetails"));
        paramawbv.strFreshNewsInfo = paramCursor.getString(paramCursor.getColumnIndex("strFreshNewsInfo"));
        paramawbv.strHotChatInfo = paramCursor.getString(paramCursor.getColumnIndex("strHotChatInfo"));
        paramawbv.uRoomid = paramCursor.getLong(paramCursor.getColumnIndex("uRoomid"));
        paramawbv.strVoteLimitedNotice = paramCursor.getString(paramCursor.getColumnIndex("strVoteLimitedNotice"));
        paramawbv.bHaveVotedCnt = paramCursor.getShort(paramCursor.getColumnIndex("bHaveVotedCnt"));
        paramawbv.bAvailVoteCnt = paramCursor.getShort(paramCursor.getColumnIndex("bAvailVoteCnt"));
        paramawbv.collegeId = paramCursor.getLong(paramCursor.getColumnIndex("collegeId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("videoHeadFlag"))) {
          break label2177;
        }
        paramBoolean = true;
        label1499:
        paramawbv.videoHeadFlag = paramBoolean;
        paramawbv.bVideoHeadUrl = paramCursor.getString(paramCursor.getColumnIndex("bVideoHeadUrl"));
        paramawbv.faceScoreWordingColor = paramCursor.getInt(paramCursor.getColumnIndex("faceScoreWordingColor"));
        paramawbv.faceScoreWording = paramCursor.getString(paramCursor.getColumnIndex("faceScoreWording"));
        paramawbv.faceScoreTailWordingColor = paramCursor.getInt(paramCursor.getColumnIndex("faceScoreTailWordingColor"));
        paramawbv.faceScoreTailWording = paramCursor.getString(paramCursor.getColumnIndex("faceScoreTailWording"));
        paramawbv.faceScoreIconUrl = paramCursor.getString(paramCursor.getColumnIndex("faceScoreIconUrl"));
        paramawbv.entryAbility = paramCursor.getInt(paramCursor.getColumnIndex("entryAbility"));
        paramawbv.strLevelType = paramCursor.getString(paramCursor.getColumnIndex("strLevelType"));
        paramawbv.maskMsgFlag = paramCursor.getInt(paramCursor.getColumnIndex("maskMsgFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendMsg"))) {
          break label2182;
        }
        paramBoolean = true;
        label1696:
        paramawbv.isForbidSendMsg = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendGiftMsg"))) {
          break label2187;
        }
        paramBoolean = true;
        label1722:
        paramawbv.isForbidSendGiftMsg = paramBoolean;
        paramawbv.disableSendMsgBtnTips = paramCursor.getString(paramCursor.getColumnIndex("disableSendMsgBtnTips"));
        paramawbv.disableSendGiftBtnTips = paramCursor.getString(paramCursor.getColumnIndex("disableSendGiftBtnTips"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendMsgForTribar"))) {
          break label2192;
        }
        paramBoolean = true;
        label1786:
        paramawbv.isForbidSendMsgForTribar = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendGiftMsgForTribar"))) {
          break label2197;
        }
        paramBoolean = true;
        label1812:
        paramawbv.isForbidSendGiftMsgForTribar = paramBoolean;
        paramawbv.disableSendMsgBtnTipsForTribar = paramCursor.getString(paramCursor.getColumnIndex("disableSendMsgBtnTipsForTribar"));
        paramawbv.disableSendGiftBtnTipsForTribar = paramCursor.getString(paramCursor.getColumnIndex("disableSendGiftBtnTipsForTribar"));
        paramawbv.highScoreNum = paramCursor.getInt(paramCursor.getColumnIndex("highScoreNum"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mHasStory"))) {
          break label2202;
        }
        paramBoolean = true;
        label1895:
        paramawbv.mHasStory = paramBoolean;
        paramawbv.mQQStoryData = paramCursor.getBlob(paramCursor.getColumnIndex("mQQStoryData"));
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
        paramawbv.isSendMsgBtnDownloadAppOpen = paramBoolean;
        paramawbv.sendMsgBtnDownloadAppTips = paramCursor.getString(paramCursor.getColumnIndex("sendMsgBtnDownloadAppTips"));
        paramawbv.addPicBtnDownloadAppTips = paramCursor.getString(paramCursor.getColumnIndex("addPicBtnDownloadAppTips"));
        paramawbv.tribeAppDownloadPageUrl = paramCursor.getString(paramCursor.getColumnIndex("tribeAppDownloadPageUrl"));
        paramawbv.nearbyNowDataBytes = paramCursor.getBlob(paramCursor.getColumnIndex("nearbyNowDataBytes"));
        paramawbv.guideAppNowTip = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTip"));
        paramawbv.guideAppNowTipLeftBtn = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTipLeftBtn"));
        paramawbv.guideAppNowTipRightBtnInstalled = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTipRightBtnInstalled"));
        paramawbv.guideAppNowTipRightBtnNotInstalled = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTipRightBtnNotInstalled"));
        paramawbv.guideAppNowPackage = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowPackage"));
        paramawbv.guideAppNowJumpUri = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowJumpUri"));
        paramawbv.guideAppNowDownloadUrl = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowDownloadUrl"));
        return paramawbv;
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
      paramawcg.a(new NoColumnError("tinyId", Long.TYPE));
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label6232;
      }
      paramawcg.a(new NoColumnError("uin", String.class));
      label2282:
      i = paramCursor.getColumnIndex("nowId");
      if (i != -1) {
        break label6247;
      }
      paramawcg.a(new NoColumnError("nowId", Long.TYPE));
      label2317:
      i = paramCursor.getColumnIndex("nowUserType");
      if (i != -1) {
        break label6262;
      }
      paramawcg.a(new NoColumnError("nowUserType", Integer.TYPE));
      label2352:
      i = paramCursor.getColumnIndex("strRemark");
      if (i != -1) {
        break label6277;
      }
      paramawcg.a(new NoColumnError("strRemark", String.class));
      label2387:
      i = paramCursor.getColumnIndex("nickname");
      if (i != -1) {
        break label6292;
      }
      paramawcg.a(new NoColumnError("nickname", String.class));
      label2422:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label6307;
      }
      paramawcg.a(new NoColumnError("gender", Byte.TYPE));
      label2457:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label6323;
      }
      paramawcg.a(new NoColumnError("age", Integer.TYPE));
      label2492:
      i = paramCursor.getColumnIndex("birthday");
      if (i != -1) {
        break label6338;
      }
      paramawcg.a(new NoColumnError("birthday", Integer.TYPE));
      label2527:
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label6353;
      }
      paramawcg.a(new NoColumnError("constellation", Byte.TYPE));
      label2562:
      i = paramCursor.getColumnIndex("distance");
      if (i != -1) {
        break label6369;
      }
      paramawcg.a(new NoColumnError("distance", String.class));
      label2597:
      i = paramCursor.getColumnIndex("timeDiff");
      if (i != -1) {
        break label6384;
      }
      paramawcg.a(new NoColumnError("timeDiff", String.class));
      label2632:
      i = paramCursor.getColumnIndex("aioDistanceAndTime");
      if (i != -1) {
        break label6399;
      }
      paramawcg.a(new NoColumnError("aioDistanceAndTime", String.class));
      label2667:
      i = paramCursor.getColumnIndex("likeCount");
      if (i != -1) {
        break label6414;
      }
      paramawcg.a(new NoColumnError("likeCount", Integer.TYPE));
      label2702:
      i = paramCursor.getColumnIndex("likeCountInc");
      if (i != -1) {
        break label6429;
      }
      paramawcg.a(new NoColumnError("likeCountInc", Integer.TYPE));
      label2737:
      i = paramCursor.getColumnIndex("oldPhotoCount");
      if (i != -1) {
        break label6444;
      }
      paramawcg.a(new NoColumnError("oldPhotoCount", Integer.TYPE));
      label2772:
      i = paramCursor.getColumnIndex("dateInfo");
      if (i != -1) {
        break label6459;
      }
      paramawcg.a(new NoColumnError("dateInfo", [B.class));
      label2807:
      i = paramCursor.getColumnIndex("ulShowControl");
      if (i != -1) {
        break label6474;
      }
      paramawcg.a(new NoColumnError("ulShowControl", Long.TYPE));
      label2842:
      i = paramCursor.getColumnIndex("xuanYan");
      if (i != -1) {
        break label6489;
      }
      paramawcg.a(new NoColumnError("xuanYan", [B.class));
      label2877:
      i = paramCursor.getColumnIndex("maritalStatus");
      if (i != -1) {
        break label6504;
      }
      paramawcg.a(new NoColumnError("maritalStatus", Byte.TYPE));
      label2912:
      i = paramCursor.getColumnIndex("job");
      if (i != -1) {
        break label6520;
      }
      paramawcg.a(new NoColumnError("job", Integer.TYPE));
      label2947:
      i = paramCursor.getColumnIndex("company");
      if (i != -1) {
        break label6535;
      }
      paramawcg.a(new NoColumnError("company", String.class));
      label2982:
      i = paramCursor.getColumnIndex("college");
      if (i != -1) {
        break label6550;
      }
      paramawcg.a(new NoColumnError("college", String.class));
      label3017:
      i = paramCursor.getColumnIndex("hometownCountry");
      if (i != -1) {
        break label6565;
      }
      paramawcg.a(new NoColumnError("hometownCountry", String.class));
      label3052:
      i = paramCursor.getColumnIndex("hometownProvice");
      if (i != -1) {
        break label6580;
      }
      paramawcg.a(new NoColumnError("hometownProvice", String.class));
      label3087:
      i = paramCursor.getColumnIndex("hometownCity");
      if (i != -1) {
        break label6595;
      }
      paramawcg.a(new NoColumnError("hometownCity", String.class));
      label3122:
      i = paramCursor.getColumnIndex("hometownDistrict");
      if (i != -1) {
        break label6610;
      }
      paramawcg.a(new NoColumnError("hometownDistrict", String.class));
      label3157:
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label6625;
      }
      paramawcg.a(new NoColumnError("vCookies", [B.class));
      label3192:
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label6640;
      }
      paramawcg.a(new NoColumnError("bVoted", Byte.TYPE));
      label3227:
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label6656;
      }
      paramawcg.a(new NoColumnError("feedPreviewTime", Long.TYPE));
      label3262:
      i = paramCursor.getColumnIndex("qzoneFeed");
      if (i != -1) {
        break label6671;
      }
      paramawcg.a(new NoColumnError("qzoneFeed", String.class));
      label3297:
      i = paramCursor.getColumnIndex("qzoneName");
      if (i != -1) {
        break label6686;
      }
      paramawcg.a(new NoColumnError("qzoneName", String.class));
      label3332:
      i = paramCursor.getColumnIndex("qzonePicUrl_1");
      if (i != -1) {
        break label6701;
      }
      paramawcg.a(new NoColumnError("qzonePicUrl_1", String.class));
      label3367:
      i = paramCursor.getColumnIndex("qzonePicUrl_2");
      if (i != -1) {
        break label6716;
      }
      paramawcg.a(new NoColumnError("qzonePicUrl_2", String.class));
      label3402:
      i = paramCursor.getColumnIndex("qzonePicUrl_3");
      if (i != -1) {
        break label6731;
      }
      paramawcg.a(new NoColumnError("qzonePicUrl_3", String.class));
      label3437:
      i = paramCursor.getColumnIndex("isPhotoUseCache");
      if (i != -1) {
        break label6746;
      }
      paramawcg.a(new NoColumnError("isPhotoUseCache", Boolean.TYPE));
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label6773;
      }
      paramawcg.a(new NoColumnError("vSeed", [B.class));
      label3507:
      i = paramCursor.getColumnIndex("vTempChatSig");
      if (i != -1) {
        break label6788;
      }
      paramawcg.a(new NoColumnError("vTempChatSig", [B.class));
      label3542:
      i = paramCursor.getColumnIndex("vGroupList");
      if (i != -1) {
        break label6803;
      }
      paramawcg.a(new NoColumnError("vGroupList", [B.class));
      label3577:
      i = paramCursor.getColumnIndex("nearbyInfo");
      if (i != -1) {
        break label6818;
      }
      paramawcg.a(new NoColumnError("nearbyInfo", [B.class));
      label3612:
      i = paramCursor.getColumnIndex("vActivityList");
      if (i != -1) {
        break label6833;
      }
      paramawcg.a(new NoColumnError("vActivityList", [B.class));
      label3647:
      i = paramCursor.getColumnIndex("lUserFlag");
      if (i != -1) {
        break label6848;
      }
      paramawcg.a(new NoColumnError("lUserFlag", Long.TYPE));
      label3682:
      i = paramCursor.getColumnIndex("iIsGodFlag");
      if (i != -1) {
        break label6863;
      }
      paramawcg.a(new NoColumnError("iIsGodFlag", Integer.TYPE));
      label3717:
      i = paramCursor.getColumnIndex("strGodJumpUrl");
      if (i != -1) {
        break label6878;
      }
      paramawcg.a(new NoColumnError("strGodJumpUrl", String.class));
      label3752:
      i = paramCursor.getColumnIndex("mHeartNum");
      if (i != -1) {
        break label6893;
      }
      paramawcg.a(new NoColumnError("mHeartNum", Integer.TYPE));
      label3787:
      i = paramCursor.getColumnIndex("switchQzone");
      if (i != -1) {
        break label6908;
      }
      paramawcg.a(new NoColumnError("switchQzone", Boolean.TYPE));
      i = paramCursor.getColumnIndex("switchHobby");
      if (i != -1) {
        break label6935;
      }
      paramawcg.a(new NoColumnError("switchHobby", Boolean.TYPE));
      i = paramCursor.getColumnIndex("uiShowControl");
      if (i != -1) {
        break label6962;
      }
      paramawcg.a(new NoColumnError("uiShowControl", Long.TYPE));
      label3892:
      i = paramCursor.getColumnIndex("userFlag");
      if (i != -1) {
        break label6977;
      }
      paramawcg.a(new NoColumnError("userFlag", Long.TYPE));
      label3927:
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label6992;
      }
      paramawcg.a(new NoColumnError("busiEntry", String.class));
      label3962:
      i = paramCursor.getColumnIndex("godFlag");
      if (i != -1) {
        break label7007;
      }
      paramawcg.a(new NoColumnError("godFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("nLastGameFlag");
      if (i != -1) {
        break label7034;
      }
      paramawcg.a(new NoColumnError("nLastGameFlag", Integer.TYPE));
      label4032:
      i = paramCursor.getColumnIndex("strProfileUrl");
      if (i != -1) {
        break label7049;
      }
      paramawcg.a(new NoColumnError("strProfileUrl", String.class));
      label4069:
      i = paramCursor.getColumnIndex("lastUpdateNickTime");
      if (i != -1) {
        break label7064;
      }
      paramawcg.a(new NoColumnError("lastUpdateNickTime", Long.TYPE));
      label4106:
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label7079;
      }
      paramawcg.a(new NoColumnError("favoriteSource", Integer.TYPE));
      label4143:
      i = paramCursor.getColumnIndex("switchGiftVisible");
      if (i != -1) {
        break label7094;
      }
      paramawcg.a(new NoColumnError("switchGiftVisible", Long.TYPE));
      label4180:
      i = paramCursor.getColumnIndex("vGiftInfo");
      if (i != -1) {
        break label7109;
      }
      paramawcg.a(new NoColumnError("vGiftInfo", [B.class));
      label4217:
      i = paramCursor.getColumnIndex("sayHelloFlag");
      if (i != -1) {
        break label7124;
      }
      paramawcg.a(new NoColumnError("sayHelloFlag", Integer.TYPE));
      label4254:
      i = paramCursor.getColumnIndex("charm");
      if (i != -1) {
        break label7139;
      }
      paramawcg.a(new NoColumnError("charm", Long.TYPE));
      label4291:
      i = paramCursor.getColumnIndex("charmLevel");
      if (i != -1) {
        break label7154;
      }
      paramawcg.a(new NoColumnError("charmLevel", Integer.TYPE));
      label4328:
      i = paramCursor.getColumnIndex("nextThreshold");
      if (i != -1) {
        break label7169;
      }
      paramawcg.a(new NoColumnError("nextThreshold", Integer.TYPE));
      label4365:
      i = paramCursor.getColumnIndex("curThreshold");
      if (i != -1) {
        break label7184;
      }
      paramawcg.a(new NoColumnError("curThreshold", Integer.TYPE));
      label4402:
      i = paramCursor.getColumnIndex("profPercent");
      if (i != -1) {
        break label7199;
      }
      paramawcg.a(new NoColumnError("profPercent", Integer.TYPE));
      label4439:
      i = paramCursor.getColumnIndex("taskFinished");
      if (i != -1) {
        break label7214;
      }
      paramawcg.a(new NoColumnError("taskFinished", Integer.TYPE));
      label4476:
      i = paramCursor.getColumnIndex("taskTotal");
      if (i != -1) {
        break label7229;
      }
      paramawcg.a(new NoColumnError("taskTotal", Integer.TYPE));
      label4513:
      i = paramCursor.getColumnIndex("hiWanInfo");
      if (i != -1) {
        break label7244;
      }
      paramawcg.a(new NoColumnError("hiWanInfo", String.class));
      label4550:
      i = paramCursor.getColumnIndex("commonLabelString");
      if (i != -1) {
        break label7259;
      }
      paramawcg.a(new NoColumnError("commonLabelString", String.class));
      label4587:
      i = paramCursor.getColumnIndex("tagFlag");
      if (i != -1) {
        break label7274;
      }
      paramawcg.a(new NoColumnError("tagFlag", Long.TYPE));
      label4624:
      i = paramCursor.getColumnIndex("tagInfo");
      if (i != -1) {
        break label7289;
      }
      paramawcg.a(new NoColumnError("tagInfo", String.class));
      label4661:
      i = paramCursor.getColumnIndex("picInfo");
      if (i != -1) {
        break label7304;
      }
      paramawcg.a(new NoColumnError("picInfo", String.class));
      label4698:
      i = paramCursor.getColumnIndex("videoDetails");
      if (i != -1) {
        break label7319;
      }
      paramawcg.a(new NoColumnError("videoDetails", String.class));
      label4735:
      i = paramCursor.getColumnIndex("strFreshNewsInfo");
      if (i != -1) {
        break label7334;
      }
      paramawcg.a(new NoColumnError("strFreshNewsInfo", String.class));
      label4772:
      i = paramCursor.getColumnIndex("strHotChatInfo");
      if (i != -1) {
        break label7349;
      }
      paramawcg.a(new NoColumnError("strHotChatInfo", String.class));
      label4809:
      i = paramCursor.getColumnIndex("uRoomid");
      if (i != -1) {
        break label7364;
      }
      paramawcg.a(new NoColumnError("uRoomid", Long.TYPE));
      label4846:
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label7379;
      }
      paramawcg.a(new NoColumnError("strVoteLimitedNotice", String.class));
      label4883:
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label7394;
      }
      paramawcg.a(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      label4920:
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label7409;
      }
      paramawcg.a(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      label4957:
      i = paramCursor.getColumnIndex("collegeId");
      if (i != -1) {
        break label7424;
      }
      paramawcg.a(new NoColumnError("collegeId", Long.TYPE));
      label4994:
      i = paramCursor.getColumnIndex("videoHeadFlag");
      if (i != -1) {
        break label7439;
      }
      paramawcg.a(new NoColumnError("videoHeadFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("bVideoHeadUrl");
      if (i != -1) {
        break label7466;
      }
      paramawcg.a(new NoColumnError("bVideoHeadUrl", String.class));
      label5068:
      i = paramCursor.getColumnIndex("faceScoreWordingColor");
      if (i != -1) {
        break label7481;
      }
      paramawcg.a(new NoColumnError("faceScoreWordingColor", Integer.TYPE));
      label5105:
      i = paramCursor.getColumnIndex("faceScoreWording");
      if (i != -1) {
        break label7496;
      }
      paramawcg.a(new NoColumnError("faceScoreWording", String.class));
      label5142:
      i = paramCursor.getColumnIndex("faceScoreTailWordingColor");
      if (i != -1) {
        break label7511;
      }
      paramawcg.a(new NoColumnError("faceScoreTailWordingColor", Integer.TYPE));
      label5179:
      i = paramCursor.getColumnIndex("faceScoreTailWording");
      if (i != -1) {
        break label7526;
      }
      paramawcg.a(new NoColumnError("faceScoreTailWording", String.class));
      label5216:
      i = paramCursor.getColumnIndex("faceScoreIconUrl");
      if (i != -1) {
        break label7541;
      }
      paramawcg.a(new NoColumnError("faceScoreIconUrl", String.class));
      label5253:
      i = paramCursor.getColumnIndex("entryAbility");
      if (i != -1) {
        break label7556;
      }
      paramawcg.a(new NoColumnError("entryAbility", Integer.TYPE));
      label5290:
      i = paramCursor.getColumnIndex("strLevelType");
      if (i != -1) {
        break label7571;
      }
      paramawcg.a(new NoColumnError("strLevelType", String.class));
      label5327:
      i = paramCursor.getColumnIndex("maskMsgFlag");
      if (i != -1) {
        break label7586;
      }
      paramawcg.a(new NoColumnError("maskMsgFlag", Integer.TYPE));
      label5364:
      i = paramCursor.getColumnIndex("isForbidSendMsg");
      if (i != -1) {
        break label7601;
      }
      paramawcg.a(new NoColumnError("isForbidSendMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isForbidSendGiftMsg");
      if (i != -1) {
        break label7628;
      }
      paramawcg.a(new NoColumnError("isForbidSendGiftMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("disableSendMsgBtnTips");
      if (i != -1) {
        break label7655;
      }
      paramawcg.a(new NoColumnError("disableSendMsgBtnTips", String.class));
      label5475:
      i = paramCursor.getColumnIndex("disableSendGiftBtnTips");
      if (i != -1) {
        break label7670;
      }
      paramawcg.a(new NoColumnError("disableSendGiftBtnTips", String.class));
      label5512:
      i = paramCursor.getColumnIndex("isForbidSendMsgForTribar");
      if (i != -1) {
        break label7685;
      }
      paramawcg.a(new NoColumnError("isForbidSendMsgForTribar", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isForbidSendGiftMsgForTribar");
      if (i != -1) {
        break label7712;
      }
      paramawcg.a(new NoColumnError("isForbidSendGiftMsgForTribar", Boolean.TYPE));
      i = paramCursor.getColumnIndex("disableSendMsgBtnTipsForTribar");
      if (i != -1) {
        break label7739;
      }
      paramawcg.a(new NoColumnError("disableSendMsgBtnTipsForTribar", String.class));
      label5623:
      i = paramCursor.getColumnIndex("disableSendGiftBtnTipsForTribar");
      if (i != -1) {
        break label7754;
      }
      paramawcg.a(new NoColumnError("disableSendGiftBtnTipsForTribar", String.class));
      label5660:
      i = paramCursor.getColumnIndex("highScoreNum");
      if (i != -1) {
        break label7769;
      }
      paramawcg.a(new NoColumnError("highScoreNum", Integer.TYPE));
      label5697:
      i = paramCursor.getColumnIndex("mHasStory");
      if (i != -1) {
        break label7784;
      }
      paramawcg.a(new NoColumnError("mHasStory", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mQQStoryData");
      if (i != -1) {
        break label7811;
      }
      paramawcg.a(new NoColumnError("mQQStoryData", [B.class));
      label5771:
      i = paramCursor.getColumnIndex("isSendMsgBtnDownloadAppOpen");
      if (i != -1) {
        break label7826;
      }
      paramawcg.a(new NoColumnError("isSendMsgBtnDownloadAppOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sendMsgBtnDownloadAppTips");
      if (i != -1) {
        break label7854;
      }
      paramawcg.a(new NoColumnError("sendMsgBtnDownloadAppTips", String.class));
      label5845:
      i = paramCursor.getColumnIndex("addPicBtnDownloadAppTips");
      if (i != -1) {
        break label7869;
      }
      paramawcg.a(new NoColumnError("addPicBtnDownloadAppTips", String.class));
      label5882:
      i = paramCursor.getColumnIndex("tribeAppDownloadPageUrl");
      if (i != -1) {
        break label7884;
      }
      paramawcg.a(new NoColumnError("tribeAppDownloadPageUrl", String.class));
      label5919:
      i = paramCursor.getColumnIndex("nearbyNowDataBytes");
      if (i != -1) {
        break label7899;
      }
      paramawcg.a(new NoColumnError("nearbyNowDataBytes", [B.class));
      label5956:
      i = paramCursor.getColumnIndex("guideAppNowTip");
      if (i != -1) {
        break label7914;
      }
      paramawcg.a(new NoColumnError("guideAppNowTip", String.class));
      label5993:
      i = paramCursor.getColumnIndex("guideAppNowTipLeftBtn");
      if (i != -1) {
        break label7929;
      }
      paramawcg.a(new NoColumnError("guideAppNowTipLeftBtn", String.class));
      label6030:
      i = paramCursor.getColumnIndex("guideAppNowTipRightBtnInstalled");
      if (i != -1) {
        break label7944;
      }
      paramawcg.a(new NoColumnError("guideAppNowTipRightBtnInstalled", String.class));
      label6067:
      i = paramCursor.getColumnIndex("guideAppNowTipRightBtnNotInstalled");
      if (i != -1) {
        break label7959;
      }
      paramawcg.a(new NoColumnError("guideAppNowTipRightBtnNotInstalled", String.class));
      label6104:
      i = paramCursor.getColumnIndex("guideAppNowPackage");
      if (i != -1) {
        break label7974;
      }
      paramawcg.a(new NoColumnError("guideAppNowPackage", String.class));
      label6141:
      i = paramCursor.getColumnIndex("guideAppNowJumpUri");
      if (i != -1) {
        break label7989;
      }
      paramawcg.a(new NoColumnError("guideAppNowJumpUri", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("guideAppNowDownloadUrl");
      if (i != -1) {
        break label8004;
      }
      paramawcg.a(new NoColumnError("guideAppNowDownloadUrl", String.class));
      return paramawbv;
      paramawbv.tinyId = paramCursor.getLong(i);
      break;
      label6232:
      paramawbv.uin = paramCursor.getString(i);
      break label2282;
      label6247:
      paramawbv.nowId = paramCursor.getLong(i);
      break label2317;
      label6262:
      paramawbv.nowUserType = paramCursor.getInt(i);
      break label2352;
      label6277:
      paramawbv.strRemark = paramCursor.getString(i);
      break label2387;
      label6292:
      paramawbv.nickname = paramCursor.getString(i);
      break label2422;
      label6307:
      paramawbv.gender = ((byte)paramCursor.getShort(i));
      break label2457;
      label6323:
      paramawbv.age = paramCursor.getInt(i);
      break label2492;
      label6338:
      paramawbv.birthday = paramCursor.getInt(i);
      break label2527;
      label6353:
      paramawbv.constellation = ((byte)paramCursor.getShort(i));
      break label2562;
      label6369:
      paramawbv.distance = paramCursor.getString(i);
      break label2597;
      label6384:
      paramawbv.timeDiff = paramCursor.getString(i);
      break label2632;
      label6399:
      paramawbv.aioDistanceAndTime = paramCursor.getString(i);
      break label2667;
      label6414:
      paramawbv.likeCount = paramCursor.getInt(i);
      break label2702;
      label6429:
      paramawbv.likeCountInc = paramCursor.getInt(i);
      break label2737;
      label6444:
      paramawbv.oldPhotoCount = paramCursor.getInt(i);
      break label2772;
      label6459:
      paramawbv.dateInfo = paramCursor.getBlob(i);
      break label2807;
      label6474:
      paramawbv.ulShowControl = paramCursor.getLong(i);
      break label2842;
      label6489:
      paramawbv.xuanYan = paramCursor.getBlob(i);
      break label2877;
      label6504:
      paramawbv.maritalStatus = ((byte)paramCursor.getShort(i));
      break label2912;
      label6520:
      paramawbv.job = paramCursor.getInt(i);
      break label2947;
      label6535:
      paramawbv.company = paramCursor.getString(i);
      break label2982;
      label6550:
      paramawbv.college = paramCursor.getString(i);
      break label3017;
      label6565:
      paramawbv.hometownCountry = paramCursor.getString(i);
      break label3052;
      label6580:
      paramawbv.hometownProvice = paramCursor.getString(i);
      break label3087;
      label6595:
      paramawbv.hometownCity = paramCursor.getString(i);
      break label3122;
      label6610:
      paramawbv.hometownDistrict = paramCursor.getString(i);
      break label3157;
      label6625:
      paramawbv.vCookies = paramCursor.getBlob(i);
      break label3192;
      label6640:
      paramawbv.bVoted = ((byte)paramCursor.getShort(i));
      break label3227;
      label6656:
      paramawbv.feedPreviewTime = paramCursor.getLong(i);
      break label3262;
      label6671:
      paramawbv.qzoneFeed = paramCursor.getString(i);
      break label3297;
      label6686:
      paramawbv.qzoneName = paramCursor.getString(i);
      break label3332;
      label6701:
      paramawbv.qzonePicUrl_1 = paramCursor.getString(i);
      break label3367;
      label6716:
      paramawbv.qzonePicUrl_2 = paramCursor.getString(i);
      break label3402;
      label6731:
      paramawbv.qzonePicUrl_3 = paramCursor.getString(i);
      break label3437;
      label6746:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isPhotoUseCache = paramBoolean;
        break;
      }
      label6773:
      paramawbv.vSeed = paramCursor.getBlob(i);
      break label3507;
      label6788:
      paramawbv.vTempChatSig = paramCursor.getBlob(i);
      break label3542;
      label6803:
      paramawbv.vGroupList = paramCursor.getBlob(i);
      break label3577;
      label6818:
      paramawbv.nearbyInfo = paramCursor.getBlob(i);
      break label3612;
      label6833:
      paramawbv.vActivityList = paramCursor.getBlob(i);
      break label3647;
      label6848:
      paramawbv.lUserFlag = paramCursor.getLong(i);
      break label3682;
      label6863:
      paramawbv.iIsGodFlag = paramCursor.getInt(i);
      break label3717;
      label6878:
      paramawbv.strGodJumpUrl = paramCursor.getString(i);
      break label3752;
      label6893:
      paramawbv.mHeartNum = paramCursor.getInt(i);
      break label3787;
      label6908:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.switchQzone = paramBoolean;
        break;
      }
      label6935:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.switchHobby = paramBoolean;
        break;
      }
      label6962:
      paramawbv.uiShowControl = paramCursor.getLong(i);
      break label3892;
      label6977:
      paramawbv.userFlag = paramCursor.getLong(i);
      break label3927;
      label6992:
      paramawbv.busiEntry = paramCursor.getString(i);
      break label3962;
      label7007:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.godFlag = paramBoolean;
        break;
      }
      label7034:
      paramawbv.nLastGameFlag = paramCursor.getInt(i);
      break label4032;
      label7049:
      paramawbv.strProfileUrl = paramCursor.getString(i);
      break label4069;
      label7064:
      paramawbv.lastUpdateNickTime = paramCursor.getLong(i);
      break label4106;
      label7079:
      paramawbv.favoriteSource = paramCursor.getInt(i);
      break label4143;
      label7094:
      paramawbv.switchGiftVisible = paramCursor.getLong(i);
      break label4180;
      label7109:
      paramawbv.vGiftInfo = paramCursor.getBlob(i);
      break label4217;
      label7124:
      paramawbv.sayHelloFlag = paramCursor.getInt(i);
      break label4254;
      label7139:
      paramawbv.charm = paramCursor.getLong(i);
      break label4291;
      label7154:
      paramawbv.charmLevel = paramCursor.getInt(i);
      break label4328;
      label7169:
      paramawbv.nextThreshold = paramCursor.getInt(i);
      break label4365;
      label7184:
      paramawbv.curThreshold = paramCursor.getInt(i);
      break label4402;
      label7199:
      paramawbv.profPercent = paramCursor.getInt(i);
      break label4439;
      label7214:
      paramawbv.taskFinished = paramCursor.getInt(i);
      break label4476;
      label7229:
      paramawbv.taskTotal = paramCursor.getInt(i);
      break label4513;
      label7244:
      paramawbv.hiWanInfo = paramCursor.getString(i);
      break label4550;
      label7259:
      paramawbv.commonLabelString = paramCursor.getString(i);
      break label4587;
      label7274:
      paramawbv.tagFlag = paramCursor.getLong(i);
      break label4624;
      label7289:
      paramawbv.tagInfo = paramCursor.getString(i);
      break label4661;
      label7304:
      paramawbv.picInfo = paramCursor.getString(i);
      break label4698;
      label7319:
      paramawbv.videoDetails = paramCursor.getString(i);
      break label4735;
      label7334:
      paramawbv.strFreshNewsInfo = paramCursor.getString(i);
      break label4772;
      label7349:
      paramawbv.strHotChatInfo = paramCursor.getString(i);
      break label4809;
      label7364:
      paramawbv.uRoomid = paramCursor.getLong(i);
      break label4846;
      label7379:
      paramawbv.strVoteLimitedNotice = paramCursor.getString(i);
      break label4883;
      label7394:
      paramawbv.bHaveVotedCnt = paramCursor.getShort(i);
      break label4920;
      label7409:
      paramawbv.bAvailVoteCnt = paramCursor.getShort(i);
      break label4957;
      label7424:
      paramawbv.collegeId = paramCursor.getLong(i);
      break label4994;
      label7439:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.videoHeadFlag = paramBoolean;
        break;
      }
      label7466:
      paramawbv.bVideoHeadUrl = paramCursor.getString(i);
      break label5068;
      label7481:
      paramawbv.faceScoreWordingColor = paramCursor.getInt(i);
      break label5105;
      label7496:
      paramawbv.faceScoreWording = paramCursor.getString(i);
      break label5142;
      label7511:
      paramawbv.faceScoreTailWordingColor = paramCursor.getInt(i);
      break label5179;
      label7526:
      paramawbv.faceScoreTailWording = paramCursor.getString(i);
      break label5216;
      label7541:
      paramawbv.faceScoreIconUrl = paramCursor.getString(i);
      break label5253;
      label7556:
      paramawbv.entryAbility = paramCursor.getInt(i);
      break label5290;
      label7571:
      paramawbv.strLevelType = paramCursor.getString(i);
      break label5327;
      label7586:
      paramawbv.maskMsgFlag = paramCursor.getInt(i);
      break label5364;
      label7601:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isForbidSendMsg = paramBoolean;
        break;
      }
      label7628:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isForbidSendGiftMsg = paramBoolean;
        break;
      }
      label7655:
      paramawbv.disableSendMsgBtnTips = paramCursor.getString(i);
      break label5475;
      label7670:
      paramawbv.disableSendGiftBtnTips = paramCursor.getString(i);
      break label5512;
      label7685:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isForbidSendMsgForTribar = paramBoolean;
        break;
      }
      label7712:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isForbidSendGiftMsgForTribar = paramBoolean;
        break;
      }
      label7739:
      paramawbv.disableSendMsgBtnTipsForTribar = paramCursor.getString(i);
      break label5623;
      label7754:
      paramawbv.disableSendGiftBtnTipsForTribar = paramCursor.getString(i);
      break label5660;
      label7769:
      paramawbv.highScoreNum = paramCursor.getInt(i);
      break label5697;
      label7784:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.mHasStory = paramBoolean;
        break;
      }
      label7811:
      paramawbv.mQQStoryData = paramCursor.getBlob(i);
      break label5771;
      label7826:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramawbv.isSendMsgBtnDownloadAppOpen = paramBoolean;
        break;
      }
      label7854:
      paramawbv.sendMsgBtnDownloadAppTips = paramCursor.getString(i);
      break label5845;
      label7869:
      paramawbv.addPicBtnDownloadAppTips = paramCursor.getString(i);
      break label5882;
      label7884:
      paramawbv.tribeAppDownloadPageUrl = paramCursor.getString(i);
      break label5919;
      label7899:
      paramawbv.nearbyNowDataBytes = paramCursor.getBlob(i);
      break label5956;
      label7914:
      paramawbv.guideAppNowTip = paramCursor.getString(i);
      break label5993;
      label7929:
      paramawbv.guideAppNowTipLeftBtn = paramCursor.getString(i);
      break label6030;
      label7944:
      paramawbv.guideAppNowTipRightBtnInstalled = paramCursor.getString(i);
      break label6067;
      label7959:
      paramawbv.guideAppNowTipRightBtnNotInstalled = paramCursor.getString(i);
      break label6104;
      label7974:
      paramawbv.guideAppNowPackage = paramCursor.getString(i);
      break label6141;
      label7989:
      paramawbv.guideAppNowJumpUri = paramCursor.getString(i);
    }
    label8004:
    paramawbv.guideAppNowDownloadUrl = paramCursor.getString(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,tinyId INTEGER ,uin TEXT ,nowId INTEGER ,nowUserType INTEGER ,strRemark TEXT ,nickname TEXT ,gender INTEGER ,age INTEGER ,birthday INTEGER ,constellation INTEGER ,distance TEXT ,timeDiff TEXT ,aioDistanceAndTime TEXT ,likeCount INTEGER ,likeCountInc INTEGER ,oldPhotoCount INTEGER ,dateInfo BLOB ,ulShowControl INTEGER ,xuanYan BLOB ,maritalStatus INTEGER ,job INTEGER ,company TEXT ,college TEXT ,hometownCountry TEXT ,hometownProvice TEXT ,hometownCity TEXT ,hometownDistrict TEXT ,vCookies BLOB ,bVoted INTEGER ,feedPreviewTime INTEGER ,qzoneFeed TEXT ,qzoneName TEXT ,qzonePicUrl_1 TEXT ,qzonePicUrl_2 TEXT ,qzonePicUrl_3 TEXT ,isPhotoUseCache INTEGER ,vSeed BLOB ,vTempChatSig BLOB ,vGroupList BLOB ,nearbyInfo BLOB ,vActivityList BLOB ,lUserFlag INTEGER ,iIsGodFlag INTEGER ,strGodJumpUrl TEXT ,mHeartNum INTEGER ,switchQzone INTEGER ,switchHobby INTEGER ,uiShowControl INTEGER ,userFlag INTEGER ,busiEntry TEXT ,godFlag INTEGER ,nLastGameFlag INTEGER ,strProfileUrl TEXT ,lastUpdateNickTime INTEGER ,favoriteSource INTEGER ,switchGiftVisible INTEGER ,vGiftInfo BLOB ,sayHelloFlag INTEGER ,charm INTEGER ,charmLevel INTEGER ,nextThreshold INTEGER ,curThreshold INTEGER ,profPercent INTEGER ,taskFinished INTEGER ,taskTotal INTEGER ,hiWanInfo TEXT ,commonLabelString TEXT ,tagFlag INTEGER ,tagInfo TEXT ,picInfo TEXT ,videoDetails TEXT ,strFreshNewsInfo TEXT ,strHotChatInfo TEXT ,uRoomid INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,collegeId INTEGER ,videoHeadFlag INTEGER ,bVideoHeadUrl TEXT ,faceScoreWordingColor INTEGER ,faceScoreWording TEXT ,faceScoreTailWordingColor INTEGER ,faceScoreTailWording TEXT ,faceScoreIconUrl TEXT ,entryAbility INTEGER ,strLevelType TEXT ,maskMsgFlag INTEGER ,isForbidSendMsg INTEGER ,isForbidSendGiftMsg INTEGER ,disableSendMsgBtnTips TEXT ,disableSendGiftBtnTips TEXT ,isForbidSendMsgForTribar INTEGER ,isForbidSendGiftMsgForTribar INTEGER ,disableSendMsgBtnTipsForTribar TEXT ,disableSendGiftBtnTipsForTribar TEXT ,highScoreNum INTEGER ,mHasStory INTEGER ,mQQStoryData BLOB ,isSendMsgBtnDownloadAppOpen INTEGER ,sendMsgBtnDownloadAppTips TEXT ,addPicBtnDownloadAppTips TEXT ,tribeAppDownloadPageUrl TEXT ,nearbyNowDataBytes BLOB ,guideAppNowTip TEXT ,guideAppNowTipLeftBtn TEXT ,guideAppNowTipRightBtnInstalled TEXT ,guideAppNowTipRightBtnNotInstalled TEXT ,guideAppNowPackage TEXT ,guideAppNowJumpUri TEXT ,guideAppNowDownloadUrl TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (NearbyPeopleCard)paramawbv;
    paramContentValues.put("tinyId", Long.valueOf(paramawbv.tinyId));
    paramContentValues.put("uin", paramawbv.uin);
    paramContentValues.put("nowId", Long.valueOf(paramawbv.nowId));
    paramContentValues.put("nowUserType", Integer.valueOf(paramawbv.nowUserType));
    paramContentValues.put("strRemark", paramawbv.strRemark);
    paramContentValues.put("nickname", paramawbv.nickname);
    paramContentValues.put("gender", Byte.valueOf(paramawbv.gender));
    paramContentValues.put("age", Integer.valueOf(paramawbv.age));
    paramContentValues.put("birthday", Integer.valueOf(paramawbv.birthday));
    paramContentValues.put("constellation", Byte.valueOf(paramawbv.constellation));
    paramContentValues.put("distance", paramawbv.distance);
    paramContentValues.put("timeDiff", paramawbv.timeDiff);
    paramContentValues.put("aioDistanceAndTime", paramawbv.aioDistanceAndTime);
    paramContentValues.put("likeCount", Integer.valueOf(paramawbv.likeCount));
    paramContentValues.put("likeCountInc", Integer.valueOf(paramawbv.likeCountInc));
    paramContentValues.put("oldPhotoCount", Integer.valueOf(paramawbv.oldPhotoCount));
    paramContentValues.put("dateInfo", paramawbv.dateInfo);
    paramContentValues.put("ulShowControl", Long.valueOf(paramawbv.ulShowControl));
    paramContentValues.put("xuanYan", paramawbv.xuanYan);
    paramContentValues.put("maritalStatus", Byte.valueOf(paramawbv.maritalStatus));
    paramContentValues.put("job", Integer.valueOf(paramawbv.job));
    paramContentValues.put("company", paramawbv.company);
    paramContentValues.put("college", paramawbv.college);
    paramContentValues.put("hometownCountry", paramawbv.hometownCountry);
    paramContentValues.put("hometownProvice", paramawbv.hometownProvice);
    paramContentValues.put("hometownCity", paramawbv.hometownCity);
    paramContentValues.put("hometownDistrict", paramawbv.hometownDistrict);
    paramContentValues.put("vCookies", paramawbv.vCookies);
    paramContentValues.put("bVoted", Byte.valueOf(paramawbv.bVoted));
    paramContentValues.put("feedPreviewTime", Long.valueOf(paramawbv.feedPreviewTime));
    paramContentValues.put("qzoneFeed", paramawbv.qzoneFeed);
    paramContentValues.put("qzoneName", paramawbv.qzoneName);
    paramContentValues.put("qzonePicUrl_1", paramawbv.qzonePicUrl_1);
    paramContentValues.put("qzonePicUrl_2", paramawbv.qzonePicUrl_2);
    paramContentValues.put("qzonePicUrl_3", paramawbv.qzonePicUrl_3);
    paramContentValues.put("isPhotoUseCache", Boolean.valueOf(paramawbv.isPhotoUseCache));
    paramContentValues.put("vSeed", paramawbv.vSeed);
    paramContentValues.put("vTempChatSig", paramawbv.vTempChatSig);
    paramContentValues.put("vGroupList", paramawbv.vGroupList);
    paramContentValues.put("nearbyInfo", paramawbv.nearbyInfo);
    paramContentValues.put("vActivityList", paramawbv.vActivityList);
    paramContentValues.put("lUserFlag", Long.valueOf(paramawbv.lUserFlag));
    paramContentValues.put("iIsGodFlag", Integer.valueOf(paramawbv.iIsGodFlag));
    paramContentValues.put("strGodJumpUrl", paramawbv.strGodJumpUrl);
    paramContentValues.put("mHeartNum", Integer.valueOf(paramawbv.mHeartNum));
    paramContentValues.put("switchQzone", Boolean.valueOf(paramawbv.switchQzone));
    paramContentValues.put("switchHobby", Boolean.valueOf(paramawbv.switchHobby));
    paramContentValues.put("uiShowControl", Long.valueOf(paramawbv.uiShowControl));
    paramContentValues.put("userFlag", Long.valueOf(paramawbv.userFlag));
    paramContentValues.put("busiEntry", paramawbv.busiEntry);
    paramContentValues.put("godFlag", Boolean.valueOf(paramawbv.godFlag));
    paramContentValues.put("nLastGameFlag", Integer.valueOf(paramawbv.nLastGameFlag));
    paramContentValues.put("strProfileUrl", paramawbv.strProfileUrl);
    paramContentValues.put("lastUpdateNickTime", Long.valueOf(paramawbv.lastUpdateNickTime));
    paramContentValues.put("favoriteSource", Integer.valueOf(paramawbv.favoriteSource));
    paramContentValues.put("switchGiftVisible", Long.valueOf(paramawbv.switchGiftVisible));
    paramContentValues.put("vGiftInfo", paramawbv.vGiftInfo);
    paramContentValues.put("sayHelloFlag", Integer.valueOf(paramawbv.sayHelloFlag));
    paramContentValues.put("charm", Long.valueOf(paramawbv.charm));
    paramContentValues.put("charmLevel", Integer.valueOf(paramawbv.charmLevel));
    paramContentValues.put("nextThreshold", Integer.valueOf(paramawbv.nextThreshold));
    paramContentValues.put("curThreshold", Integer.valueOf(paramawbv.curThreshold));
    paramContentValues.put("profPercent", Integer.valueOf(paramawbv.profPercent));
    paramContentValues.put("taskFinished", Integer.valueOf(paramawbv.taskFinished));
    paramContentValues.put("taskTotal", Integer.valueOf(paramawbv.taskTotal));
    paramContentValues.put("hiWanInfo", paramawbv.hiWanInfo);
    paramContentValues.put("commonLabelString", paramawbv.commonLabelString);
    paramContentValues.put("tagFlag", Long.valueOf(paramawbv.tagFlag));
    paramContentValues.put("tagInfo", paramawbv.tagInfo);
    paramContentValues.put("picInfo", paramawbv.picInfo);
    paramContentValues.put("videoDetails", paramawbv.videoDetails);
    paramContentValues.put("strFreshNewsInfo", paramawbv.strFreshNewsInfo);
    paramContentValues.put("strHotChatInfo", paramawbv.strHotChatInfo);
    paramContentValues.put("uRoomid", Long.valueOf(paramawbv.uRoomid));
    paramContentValues.put("strVoteLimitedNotice", paramawbv.strVoteLimitedNotice);
    paramContentValues.put("bHaveVotedCnt", Short.valueOf(paramawbv.bHaveVotedCnt));
    paramContentValues.put("bAvailVoteCnt", Short.valueOf(paramawbv.bAvailVoteCnt));
    paramContentValues.put("collegeId", Long.valueOf(paramawbv.collegeId));
    paramContentValues.put("videoHeadFlag", Boolean.valueOf(paramawbv.videoHeadFlag));
    paramContentValues.put("bVideoHeadUrl", paramawbv.bVideoHeadUrl);
    paramContentValues.put("faceScoreWordingColor", Integer.valueOf(paramawbv.faceScoreWordingColor));
    paramContentValues.put("faceScoreWording", paramawbv.faceScoreWording);
    paramContentValues.put("faceScoreTailWordingColor", Integer.valueOf(paramawbv.faceScoreTailWordingColor));
    paramContentValues.put("faceScoreTailWording", paramawbv.faceScoreTailWording);
    paramContentValues.put("faceScoreIconUrl", paramawbv.faceScoreIconUrl);
    paramContentValues.put("entryAbility", Integer.valueOf(paramawbv.entryAbility));
    paramContentValues.put("strLevelType", paramawbv.strLevelType);
    paramContentValues.put("maskMsgFlag", Integer.valueOf(paramawbv.maskMsgFlag));
    paramContentValues.put("isForbidSendMsg", Boolean.valueOf(paramawbv.isForbidSendMsg));
    paramContentValues.put("isForbidSendGiftMsg", Boolean.valueOf(paramawbv.isForbidSendGiftMsg));
    paramContentValues.put("disableSendMsgBtnTips", paramawbv.disableSendMsgBtnTips);
    paramContentValues.put("disableSendGiftBtnTips", paramawbv.disableSendGiftBtnTips);
    paramContentValues.put("isForbidSendMsgForTribar", Boolean.valueOf(paramawbv.isForbidSendMsgForTribar));
    paramContentValues.put("isForbidSendGiftMsgForTribar", Boolean.valueOf(paramawbv.isForbidSendGiftMsgForTribar));
    paramContentValues.put("disableSendMsgBtnTipsForTribar", paramawbv.disableSendMsgBtnTipsForTribar);
    paramContentValues.put("disableSendGiftBtnTipsForTribar", paramawbv.disableSendGiftBtnTipsForTribar);
    paramContentValues.put("highScoreNum", Integer.valueOf(paramawbv.highScoreNum));
    paramContentValues.put("mHasStory", Boolean.valueOf(paramawbv.mHasStory));
    paramContentValues.put("mQQStoryData", paramawbv.mQQStoryData);
    paramContentValues.put("isSendMsgBtnDownloadAppOpen", Boolean.valueOf(paramawbv.isSendMsgBtnDownloadAppOpen));
    paramContentValues.put("sendMsgBtnDownloadAppTips", paramawbv.sendMsgBtnDownloadAppTips);
    paramContentValues.put("addPicBtnDownloadAppTips", paramawbv.addPicBtnDownloadAppTips);
    paramContentValues.put("tribeAppDownloadPageUrl", paramawbv.tribeAppDownloadPageUrl);
    paramContentValues.put("nearbyNowDataBytes", paramawbv.nearbyNowDataBytes);
    paramContentValues.put("guideAppNowTip", paramawbv.guideAppNowTip);
    paramContentValues.put("guideAppNowTipLeftBtn", paramawbv.guideAppNowTipLeftBtn);
    paramContentValues.put("guideAppNowTipRightBtnInstalled", paramawbv.guideAppNowTipRightBtnInstalled);
    paramContentValues.put("guideAppNowTipRightBtnNotInstalled", paramawbv.guideAppNowTipRightBtnNotInstalled);
    paramContentValues.put("guideAppNowPackage", paramawbv.guideAppNowPackage);
    paramContentValues.put("guideAppNowJumpUri", paramawbv.guideAppNowJumpUri);
    paramContentValues.put("guideAppNowDownloadUrl", paramawbv.guideAppNowDownloadUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awcf
 * JD-Core Version:    0.7.0.1
 */