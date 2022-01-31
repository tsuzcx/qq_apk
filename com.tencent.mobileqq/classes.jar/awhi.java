import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awhi
  extends awgq
{
  public awhi()
  {
    this.a = 118;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawge = (TroopInfo)paramawge;
    if (paramawgp == null)
    {
      paramawge.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawge.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
      paramawge.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
      paramawge.troopcode = paramCursor.getString(paramCursor.getColumnIndex("troopcode"));
      paramawge.troopowneruin = paramCursor.getString(paramCursor.getColumnIndex("troopowneruin"));
      paramawge.troopname = paramCursor.getString(paramCursor.getColumnIndex("troopname"));
      paramawge.newTroopName = paramCursor.getString(paramCursor.getColumnIndex("newTroopName"));
      paramawge.newTroopNameTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("newTroopNameTimeStamp"));
      paramawge.troopface = paramCursor.getShort(paramCursor.getColumnIndex("troopface"));
      paramawge.troopmemo = paramCursor.getString(paramCursor.getColumnIndex("troopmemo"));
      paramawge.fingertroopmemo = paramCursor.getString(paramCursor.getColumnIndex("fingertroopmemo"));
      paramawge.mRichFingerMemo = paramCursor.getString(paramCursor.getColumnIndex("mRichFingerMemo"));
      paramawge.troopmask = paramCursor.getInt(paramCursor.getColumnIndex("troopmask"));
      paramawge.trooptype = paramCursor.getInt(paramCursor.getColumnIndex("trooptype"));
      paramawge.troopCreateTime = paramCursor.getLong(paramCursor.getColumnIndex("troopCreateTime"));
      paramawge.dwGroupFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlag"));
      paramawge.cGroupOption = paramCursor.getShort(paramCursor.getColumnIndex("cGroupOption"));
      paramawge.wMemberMax = paramCursor.getInt(paramCursor.getColumnIndex("wMemberMax"));
      paramawge.maxAdminNum = paramCursor.getInt(paramCursor.getColumnIndex("maxAdminNum"));
      paramawge.wSpecialClass = paramCursor.getInt(paramCursor.getColumnIndex("wSpecialClass"));
      paramawge.cGroupLevel = paramCursor.getShort(paramCursor.getColumnIndex("cGroupLevel"));
      paramawge.wMemberNum = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNum"));
      paramawge.wMemberNumClient = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNumClient"));
      paramawge.Administrator = paramCursor.getString(paramCursor.getColumnIndex("Administrator"));
      paramawge.dwGroupClassExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupClassExt"));
      paramawge.mGroupClassExtText = paramCursor.getString(paramCursor.getColumnIndex("mGroupClassExtText"));
      paramawge.dwGroupFlagExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt"));
      paramawge.dwAuthGroupType = paramCursor.getLong(paramCursor.getColumnIndex("dwAuthGroupType"));
      paramawge.troopAuthenticateInfo = paramCursor.getString(paramCursor.getColumnIndex("troopAuthenticateInfo"));
      paramawge.dwGroupInfoSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupInfoSeq"));
      paramawge.mMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberNumSeq"));
      paramawge.mOldMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberNumSeq"));
      paramawge.mMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberCardSeq"));
      paramawge.mOldMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberCardSeq"));
      paramawge.dwGroupLevelSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupLevelSeq"));
      paramawge.cGroupRankSysFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankSysFlag")));
      paramawge.cGroupRankUserFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankUserFlag")));
      paramawge.troopLevelMap = paramCursor.getString(paramCursor.getColumnIndex("troopLevelMap"));
      paramawge.joinTroopQuestion = paramCursor.getString(paramCursor.getColumnIndex("joinTroopQuestion"));
      paramawge.joinTroopAnswer = paramCursor.getString(paramCursor.getColumnIndex("joinTroopAnswer"));
      paramawge.cAlbumResult = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cAlbumResult")));
      paramawge.dwTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwTimeStamp"));
      paramawge.strQZonePhotoUrls = paramCursor.getString(paramCursor.getColumnIndex("strQZonePhotoUrls"));
      paramawge.mQZonePhotoNum = paramCursor.getInt(paramCursor.getColumnIndex("mQZonePhotoNum"));
      paramawge.strLocation = paramCursor.getString(paramCursor.getColumnIndex("strLocation"));
      paramawge.troopLat = paramCursor.getInt(paramCursor.getColumnIndex("troopLat"));
      paramawge.troopLon = paramCursor.getInt(paramCursor.getColumnIndex("troopLon"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("mMemberInvitingFlag")))
      {
        paramBoolean = true;
        paramawge.mMemberInvitingFlag = paramBoolean;
        paramawge.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramawge.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramawge.mSomeMemberUins = paramCursor.getString(paramCursor.getColumnIndex("mSomeMemberUins"));
        paramawge.mHeaderUinsOld = paramCursor.getString(paramCursor.getColumnIndex("mHeaderUinsOld"));
        paramawge.mHeaderUinsNew = paramCursor.getString(paramCursor.getColumnIndex("mHeaderUinsNew"));
        paramawge.mTags = paramCursor.getString(paramCursor.getColumnIndex("mTags"));
        paramawge.mTroopAvatarId = paramCursor.getInt(paramCursor.getColumnIndex("mTroopAvatarId"));
        paramawge.mTroopPicListJson = paramCursor.getString(paramCursor.getColumnIndex("mTroopPicListJson"));
        paramawge.nTroopGrade = paramCursor.getInt(paramCursor.getColumnIndex("nTroopGrade"));
        paramawge.isShowInNearbyTroops = paramCursor.getInt(paramCursor.getColumnIndex("isShowInNearbyTroops"));
        paramawge.dwGagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp"));
        paramawge.dwGagTimeStamp_me = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp_me"));
        paramawge.dwCmdUinUinFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwCmdUinUinFlag"));
        paramawge.dwAdditionalFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAdditionalFlag"));
        paramawge.troopTypeExt = paramCursor.getInt(paramCursor.getColumnIndex("troopTypeExt"));
        paramawge.ownerNameShow = paramCursor.getString(paramCursor.getColumnIndex("ownerNameShow"));
        paramawge.adminNameShow = paramCursor.getString(paramCursor.getColumnIndex("adminNameShow"));
        paramawge.dwOfficeMode = paramCursor.getLong(paramCursor.getColumnIndex("dwOfficeMode"));
        paramawge.dwGroupFlagExt3 = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt3"));
        paramawge.cmdUinFlagEx2 = paramCursor.getLong(paramCursor.getColumnIndex("cmdUinFlagEx2"));
        paramawge.udwCmdUinRingtoneID = paramCursor.getLong(paramCursor.getColumnIndex("udwCmdUinRingtoneID"));
        paramawge.memberListToShow = paramCursor.getString(paramCursor.getColumnIndex("memberListToShow"));
        paramawge.troopPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("troopPrivilegeFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isNewTroop"))) {
          break label2258;
        }
        paramBoolean = true;
        label1343:
        paramawge.isNewTroop = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSetNewTroopHead"))) {
          break label2263;
        }
        paramBoolean = true;
        label1369:
        paramawge.hasSetNewTroopHead = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSetNewTroopName"))) {
          break label2268;
        }
        paramBoolean = true;
        label1395:
        paramawge.hasSetNewTroopName = paramBoolean;
        paramawge.maxInviteMemNum = paramCursor.getInt(paramCursor.getColumnIndex("maxInviteMemNum"));
        paramawge.lastMsgTime = paramCursor.getLong(paramCursor.getColumnIndex("lastMsgTime"));
        paramawge.allowMemberModifTroopName = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberModifTroopName"));
        paramawge.allowMemberKick = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberKick"));
        paramawge.allowMemberAtAll = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberAtAll"));
        paramawge.oldTroopName = paramCursor.getString(paramCursor.getColumnIndex("oldTroopName"));
        paramawge.hlGuildAppid = paramCursor.getLong(paramCursor.getColumnIndex("hlGuildAppid"));
        paramawge.hlGuildSubType = paramCursor.getLong(paramCursor.getColumnIndex("hlGuildSubType"));
        paramawge.hlGuildOrgid = paramCursor.getInt(paramCursor.getColumnIndex("hlGuildOrgid"));
        paramawge.hlGuildBinary = paramCursor.getInt(paramCursor.getColumnIndex("hlGuildBinary"));
        paramawge.gameSwitchStatus = paramCursor.getInt(paramCursor.getColumnIndex("gameSwitchStatus"));
        paramawge.showGameSwitchStatus = paramCursor.getInt(paramCursor.getColumnIndex("showGameSwitchStatus"));
        paramawge.lastShareLbsMsgUniseq = paramCursor.getLong(paramCursor.getColumnIndex("lastShareLbsMsgUniseq"));
        paramawge.mTroopNeedPayNumber = paramCursor.getFloat(paramCursor.getColumnIndex("mTroopNeedPayNumber"));
        paramawge.troopCreditLevel = paramCursor.getLong(paramCursor.getColumnIndex("troopCreditLevel"));
        paramawge.troopCreditLevelInfo = paramCursor.getLong(paramCursor.getColumnIndex("troopCreditLevelInfo"));
        paramawge.dwAppPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAppPrivilegeFlag"));
        paramawge.topicId = paramCursor.getString(paramCursor.getColumnIndex("topicId"));
        paramawge.associatePubAccount = paramCursor.getLong(paramCursor.getColumnIndex("associatePubAccount"));
        paramawge.mTroopFileVideoReqInterval = paramCursor.getLong(paramCursor.getColumnIndex("mTroopFileVideoReqInterval"));
        paramawge.mTroopFileVideoIsWhite = paramCursor.getInt(paramCursor.getColumnIndex("mTroopFileVideoIsWhite"));
        paramawge.mTribeStatus = paramCursor.getInt(paramCursor.getColumnIndex("mTribeStatus"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mCanSearchByKeywords"))) {
          break label2273;
        }
        paramBoolean = true;
        label1839:
        paramawge.mCanSearchByKeywords = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mCanSearchByTroopUin"))) {
          break label2278;
        }
      }
      label2258:
      label2263:
      label2268:
      label2273:
      label2278:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramawge.mCanSearchByTroopUin = paramBoolean;
        paramawge.dwCmdUinJoinTime = paramCursor.getLong(paramCursor.getColumnIndex("dwCmdUinJoinTime"));
        paramawge.dwLastInsertBAFTipTime = paramCursor.getLong(paramCursor.getColumnIndex("dwLastInsertBAFTipTime"));
        paramawge.wInsertBAFTipCount = paramCursor.getInt(paramCursor.getColumnIndex("wInsertBAFTipCount"));
        paramawge.wClickBAFTipCount = paramCursor.getInt(paramCursor.getColumnIndex("wClickBAFTipCount"));
        paramawge.dwLastBAFTipMsgUniSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq"));
        paramawge.dwLastBAFTipMsgUniSeq2 = paramCursor.getLong(paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq2"));
        paramawge.dailyNewMemberUins = paramCursor.getString(paramCursor.getColumnIndex("dailyNewMemberUins"));
        paramawge.exitTroopReason = paramCursor.getInt(paramCursor.getColumnIndex("exitTroopReason"));
        paramawge.eliminated = paramCursor.getInt(paramCursor.getColumnIndex("eliminated"));
        paramawge.mIsFreezed = paramCursor.getInt(paramCursor.getColumnIndex("mIsFreezed"));
        paramawge.strLastAnnouncement = paramCursor.getString(paramCursor.getColumnIndex("strLastAnnouncement"));
        paramawge.nMsgLimitFreq = paramCursor.getInt(paramCursor.getColumnIndex("nMsgLimitFreq"));
        paramawge.mAtOrReplyMeUins = paramCursor.getString(paramCursor.getColumnIndex("mAtOrReplyMeUins"));
        paramawge.groupFlagExt4 = paramCursor.getInt(paramCursor.getColumnIndex("groupFlagExt4"));
        paramawge.groupFreezeReason = paramCursor.getInt(paramCursor.getColumnIndex("groupFreezeReason"));
        paramawge.troopHonorGrayFlag = paramCursor.getInt(paramCursor.getColumnIndex("troopHonorGrayFlag"));
        paramawge.isAllowHistoryMsgFlag = paramCursor.getInt(paramCursor.getColumnIndex("isAllowHistoryMsgFlag"));
        paramawge.troopRepeatType = paramCursor.getInt(paramCursor.getColumnIndex("troopRepeatType"));
        paramawge.feeds_id = paramCursor.getString(paramCursor.getColumnIndex("feeds_id"));
        paramawge.myHonorList = paramCursor.getString(paramCursor.getColumnIndex("myHonorList"));
        return paramawge;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label1343;
        paramBoolean = false;
        break label1369;
        paramBoolean = false;
        break label1395;
        paramBoolean = false;
        break label1839;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("timeSec");
      if (i != -1) {
        break label6560;
      }
      paramawgp.a(new NoColumnError("timeSec", Long.TYPE));
      label2353:
      i = paramCursor.getColumnIndex("troopuin");
      if (i != -1) {
        break label6575;
      }
      paramawgp.a(new NoColumnError("troopuin", String.class));
      label2388:
      i = paramCursor.getColumnIndex("troopcode");
      if (i != -1) {
        break label6590;
      }
      paramawgp.a(new NoColumnError("troopcode", String.class));
      label2423:
      i = paramCursor.getColumnIndex("troopowneruin");
      if (i != -1) {
        break label6605;
      }
      paramawgp.a(new NoColumnError("troopowneruin", String.class));
      label2458:
      i = paramCursor.getColumnIndex("troopname");
      if (i != -1) {
        break label6620;
      }
      paramawgp.a(new NoColumnError("troopname", String.class));
      label2493:
      i = paramCursor.getColumnIndex("newTroopName");
      if (i != -1) {
        break label6635;
      }
      paramawgp.a(new NoColumnError("newTroopName", String.class));
      label2528:
      i = paramCursor.getColumnIndex("newTroopNameTimeStamp");
      if (i != -1) {
        break label6650;
      }
      paramawgp.a(new NoColumnError("newTroopNameTimeStamp", Long.TYPE));
      label2563:
      i = paramCursor.getColumnIndex("troopface");
      if (i != -1) {
        break label6665;
      }
      paramawgp.a(new NoColumnError("troopface", Short.TYPE));
      label2598:
      i = paramCursor.getColumnIndex("troopmemo");
      if (i != -1) {
        break label6680;
      }
      paramawgp.a(new NoColumnError("troopmemo", String.class));
      label2633:
      i = paramCursor.getColumnIndex("fingertroopmemo");
      if (i != -1) {
        break label6695;
      }
      paramawgp.a(new NoColumnError("fingertroopmemo", String.class));
      label2668:
      i = paramCursor.getColumnIndex("mRichFingerMemo");
      if (i != -1) {
        break label6710;
      }
      paramawgp.a(new NoColumnError("mRichFingerMemo", String.class));
      label2703:
      i = paramCursor.getColumnIndex("troopmask");
      if (i != -1) {
        break label6725;
      }
      paramawgp.a(new NoColumnError("troopmask", Integer.TYPE));
      label2738:
      i = paramCursor.getColumnIndex("trooptype");
      if (i != -1) {
        break label6740;
      }
      paramawgp.a(new NoColumnError("trooptype", Integer.TYPE));
      label2773:
      i = paramCursor.getColumnIndex("troopCreateTime");
      if (i != -1) {
        break label6755;
      }
      paramawgp.a(new NoColumnError("troopCreateTime", Long.TYPE));
      label2808:
      i = paramCursor.getColumnIndex("dwGroupFlag");
      if (i != -1) {
        break label6770;
      }
      paramawgp.a(new NoColumnError("dwGroupFlag", Long.TYPE));
      label2843:
      i = paramCursor.getColumnIndex("cGroupOption");
      if (i != -1) {
        break label6785;
      }
      paramawgp.a(new NoColumnError("cGroupOption", Short.TYPE));
      label2878:
      i = paramCursor.getColumnIndex("wMemberMax");
      if (i != -1) {
        break label6800;
      }
      paramawgp.a(new NoColumnError("wMemberMax", Integer.TYPE));
      label2913:
      i = paramCursor.getColumnIndex("maxAdminNum");
      if (i != -1) {
        break label6815;
      }
      paramawgp.a(new NoColumnError("maxAdminNum", Integer.TYPE));
      label2948:
      i = paramCursor.getColumnIndex("wSpecialClass");
      if (i != -1) {
        break label6830;
      }
      paramawgp.a(new NoColumnError("wSpecialClass", Integer.TYPE));
      label2983:
      i = paramCursor.getColumnIndex("cGroupLevel");
      if (i != -1) {
        break label6845;
      }
      paramawgp.a(new NoColumnError("cGroupLevel", Short.TYPE));
      label3018:
      i = paramCursor.getColumnIndex("wMemberNum");
      if (i != -1) {
        break label6860;
      }
      paramawgp.a(new NoColumnError("wMemberNum", Integer.TYPE));
      label3053:
      i = paramCursor.getColumnIndex("wMemberNumClient");
      if (i != -1) {
        break label6875;
      }
      paramawgp.a(new NoColumnError("wMemberNumClient", Integer.TYPE));
      label3088:
      i = paramCursor.getColumnIndex("Administrator");
      if (i != -1) {
        break label6890;
      }
      paramawgp.a(new NoColumnError("Administrator", String.class));
      label3123:
      i = paramCursor.getColumnIndex("dwGroupClassExt");
      if (i != -1) {
        break label6905;
      }
      paramawgp.a(new NoColumnError("dwGroupClassExt", Long.TYPE));
      label3158:
      i = paramCursor.getColumnIndex("mGroupClassExtText");
      if (i != -1) {
        break label6920;
      }
      paramawgp.a(new NoColumnError("mGroupClassExtText", String.class));
      label3193:
      i = paramCursor.getColumnIndex("dwGroupFlagExt");
      if (i != -1) {
        break label6935;
      }
      paramawgp.a(new NoColumnError("dwGroupFlagExt", Long.TYPE));
      label3228:
      i = paramCursor.getColumnIndex("dwAuthGroupType");
      if (i != -1) {
        break label6950;
      }
      paramawgp.a(new NoColumnError("dwAuthGroupType", Long.TYPE));
      label3263:
      i = paramCursor.getColumnIndex("troopAuthenticateInfo");
      if (i != -1) {
        break label6965;
      }
      paramawgp.a(new NoColumnError("troopAuthenticateInfo", String.class));
      label3298:
      i = paramCursor.getColumnIndex("dwGroupInfoSeq");
      if (i != -1) {
        break label6980;
      }
      paramawgp.a(new NoColumnError("dwGroupInfoSeq", Long.TYPE));
      label3333:
      i = paramCursor.getColumnIndex("mMemberNumSeq");
      if (i != -1) {
        break label6995;
      }
      paramawgp.a(new NoColumnError("mMemberNumSeq", Long.TYPE));
      label3368:
      i = paramCursor.getColumnIndex("mOldMemberNumSeq");
      if (i != -1) {
        break label7010;
      }
      paramawgp.a(new NoColumnError("mOldMemberNumSeq", Long.TYPE));
      label3403:
      i = paramCursor.getColumnIndex("mMemberCardSeq");
      if (i != -1) {
        break label7025;
      }
      paramawgp.a(new NoColumnError("mMemberCardSeq", Long.TYPE));
      label3438:
      i = paramCursor.getColumnIndex("mOldMemberCardSeq");
      if (i != -1) {
        break label7040;
      }
      paramawgp.a(new NoColumnError("mOldMemberCardSeq", Long.TYPE));
      label3473:
      i = paramCursor.getColumnIndex("dwGroupLevelSeq");
      if (i != -1) {
        break label7055;
      }
      paramawgp.a(new NoColumnError("dwGroupLevelSeq", Long.TYPE));
      label3508:
      i = paramCursor.getColumnIndex("cGroupRankSysFlag");
      if (i != -1) {
        break label7070;
      }
      paramawgp.a(new NoColumnError("cGroupRankSysFlag", Byte.TYPE));
      label3543:
      i = paramCursor.getColumnIndex("cGroupRankUserFlag");
      if (i != -1) {
        break label7086;
      }
      paramawgp.a(new NoColumnError("cGroupRankUserFlag", Byte.TYPE));
      label3578:
      i = paramCursor.getColumnIndex("troopLevelMap");
      if (i != -1) {
        break label7102;
      }
      paramawgp.a(new NoColumnError("troopLevelMap", String.class));
      label3613:
      i = paramCursor.getColumnIndex("joinTroopQuestion");
      if (i != -1) {
        break label7117;
      }
      paramawgp.a(new NoColumnError("joinTroopQuestion", String.class));
      label3648:
      i = paramCursor.getColumnIndex("joinTroopAnswer");
      if (i != -1) {
        break label7132;
      }
      paramawgp.a(new NoColumnError("joinTroopAnswer", String.class));
      label3683:
      i = paramCursor.getColumnIndex("cAlbumResult");
      if (i != -1) {
        break label7147;
      }
      paramawgp.a(new NoColumnError("cAlbumResult", Byte.TYPE));
      label3718:
      i = paramCursor.getColumnIndex("dwTimeStamp");
      if (i != -1) {
        break label7163;
      }
      paramawgp.a(new NoColumnError("dwTimeStamp", Long.TYPE));
      label3753:
      i = paramCursor.getColumnIndex("strQZonePhotoUrls");
      if (i != -1) {
        break label7178;
      }
      paramawgp.a(new NoColumnError("strQZonePhotoUrls", String.class));
      label3788:
      i = paramCursor.getColumnIndex("mQZonePhotoNum");
      if (i != -1) {
        break label7193;
      }
      paramawgp.a(new NoColumnError("mQZonePhotoNum", Integer.TYPE));
      label3823:
      i = paramCursor.getColumnIndex("strLocation");
      if (i != -1) {
        break label7208;
      }
      paramawgp.a(new NoColumnError("strLocation", String.class));
      label3858:
      i = paramCursor.getColumnIndex("troopLat");
      if (i != -1) {
        break label7223;
      }
      paramawgp.a(new NoColumnError("troopLat", Integer.TYPE));
      label3893:
      i = paramCursor.getColumnIndex("troopLon");
      if (i != -1) {
        break label7238;
      }
      paramawgp.a(new NoColumnError("troopLon", Integer.TYPE));
      label3928:
      i = paramCursor.getColumnIndex("mMemberInvitingFlag");
      if (i != -1) {
        break label7253;
      }
      paramawgp.a(new NoColumnError("mMemberInvitingFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label7280;
      }
      paramawgp.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label3998:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label7295;
      }
      paramawgp.a(new NoColumnError("mCompareSpell", String.class));
      label4033:
      i = paramCursor.getColumnIndex("mSomeMemberUins");
      if (i != -1) {
        break label7310;
      }
      paramawgp.a(new NoColumnError("mSomeMemberUins", String.class));
      label4068:
      i = paramCursor.getColumnIndex("mHeaderUinsOld");
      if (i != -1) {
        break label7325;
      }
      paramawgp.a(new NoColumnError("mHeaderUinsOld", String.class));
      label4103:
      i = paramCursor.getColumnIndex("mHeaderUinsNew");
      if (i != -1) {
        break label7340;
      }
      paramawgp.a(new NoColumnError("mHeaderUinsNew", String.class));
      label4138:
      i = paramCursor.getColumnIndex("mTags");
      if (i != -1) {
        break label7355;
      }
      paramawgp.a(new NoColumnError("mTags", String.class));
      label4175:
      i = paramCursor.getColumnIndex("mTroopAvatarId");
      if (i != -1) {
        break label7370;
      }
      paramawgp.a(new NoColumnError("mTroopAvatarId", Integer.TYPE));
      label4212:
      i = paramCursor.getColumnIndex("mTroopPicListJson");
      if (i != -1) {
        break label7385;
      }
      paramawgp.a(new NoColumnError("mTroopPicListJson", String.class));
      label4249:
      i = paramCursor.getColumnIndex("nTroopGrade");
      if (i != -1) {
        break label7400;
      }
      paramawgp.a(new NoColumnError("nTroopGrade", Integer.TYPE));
      label4286:
      i = paramCursor.getColumnIndex("isShowInNearbyTroops");
      if (i != -1) {
        break label7415;
      }
      paramawgp.a(new NoColumnError("isShowInNearbyTroops", Integer.TYPE));
      label4323:
      i = paramCursor.getColumnIndex("dwGagTimeStamp");
      if (i != -1) {
        break label7430;
      }
      paramawgp.a(new NoColumnError("dwGagTimeStamp", Long.TYPE));
      label4360:
      i = paramCursor.getColumnIndex("dwGagTimeStamp_me");
      if (i != -1) {
        break label7445;
      }
      paramawgp.a(new NoColumnError("dwGagTimeStamp_me", Long.TYPE));
      label4397:
      i = paramCursor.getColumnIndex("dwCmdUinUinFlag");
      if (i != -1) {
        break label7460;
      }
      paramawgp.a(new NoColumnError("dwCmdUinUinFlag", Long.TYPE));
      label4434:
      i = paramCursor.getColumnIndex("dwAdditionalFlag");
      if (i != -1) {
        break label7475;
      }
      paramawgp.a(new NoColumnError("dwAdditionalFlag", Long.TYPE));
      label4471:
      i = paramCursor.getColumnIndex("troopTypeExt");
      if (i != -1) {
        break label7490;
      }
      paramawgp.a(new NoColumnError("troopTypeExt", Integer.TYPE));
      label4508:
      i = paramCursor.getColumnIndex("ownerNameShow");
      if (i != -1) {
        break label7505;
      }
      paramawgp.a(new NoColumnError("ownerNameShow", String.class));
      label4545:
      i = paramCursor.getColumnIndex("adminNameShow");
      if (i != -1) {
        break label7520;
      }
      paramawgp.a(new NoColumnError("adminNameShow", String.class));
      label4582:
      i = paramCursor.getColumnIndex("dwOfficeMode");
      if (i != -1) {
        break label7535;
      }
      paramawgp.a(new NoColumnError("dwOfficeMode", Long.TYPE));
      label4619:
      i = paramCursor.getColumnIndex("dwGroupFlagExt3");
      if (i != -1) {
        break label7550;
      }
      paramawgp.a(new NoColumnError("dwGroupFlagExt3", Long.TYPE));
      label4656:
      i = paramCursor.getColumnIndex("cmdUinFlagEx2");
      if (i != -1) {
        break label7565;
      }
      paramawgp.a(new NoColumnError("cmdUinFlagEx2", Long.TYPE));
      label4693:
      i = paramCursor.getColumnIndex("udwCmdUinRingtoneID");
      if (i != -1) {
        break label7580;
      }
      paramawgp.a(new NoColumnError("udwCmdUinRingtoneID", Long.TYPE));
      label4730:
      i = paramCursor.getColumnIndex("memberListToShow");
      if (i != -1) {
        break label7595;
      }
      paramawgp.a(new NoColumnError("memberListToShow", String.class));
      label4767:
      i = paramCursor.getColumnIndex("troopPrivilegeFlag");
      if (i != -1) {
        break label7610;
      }
      paramawgp.a(new NoColumnError("troopPrivilegeFlag", Long.TYPE));
      label4804:
      i = paramCursor.getColumnIndex("isNewTroop");
      if (i != -1) {
        break label7625;
      }
      paramawgp.a(new NoColumnError("isNewTroop", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasSetNewTroopHead");
      if (i != -1) {
        break label7652;
      }
      paramawgp.a(new NoColumnError("hasSetNewTroopHead", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasSetNewTroopName");
      if (i != -1) {
        break label7679;
      }
      paramawgp.a(new NoColumnError("hasSetNewTroopName", Boolean.TYPE));
      i = paramCursor.getColumnIndex("maxInviteMemNum");
      if (i != -1) {
        break label7706;
      }
      paramawgp.a(new NoColumnError("maxInviteMemNum", Integer.TYPE));
      label4952:
      i = paramCursor.getColumnIndex("lastMsgTime");
      if (i != -1) {
        break label7721;
      }
      paramawgp.a(new NoColumnError("lastMsgTime", Long.TYPE));
      label4989:
      i = paramCursor.getColumnIndex("allowMemberModifTroopName");
      if (i != -1) {
        break label7736;
      }
      paramawgp.a(new NoColumnError("allowMemberModifTroopName", Integer.TYPE));
      label5026:
      i = paramCursor.getColumnIndex("allowMemberKick");
      if (i != -1) {
        break label7751;
      }
      paramawgp.a(new NoColumnError("allowMemberKick", Integer.TYPE));
      label5063:
      i = paramCursor.getColumnIndex("allowMemberAtAll");
      if (i != -1) {
        break label7766;
      }
      paramawgp.a(new NoColumnError("allowMemberAtAll", Integer.TYPE));
      label5100:
      i = paramCursor.getColumnIndex("oldTroopName");
      if (i != -1) {
        break label7781;
      }
      paramawgp.a(new NoColumnError("oldTroopName", String.class));
      label5137:
      i = paramCursor.getColumnIndex("hlGuildAppid");
      if (i != -1) {
        break label7796;
      }
      paramawgp.a(new NoColumnError("hlGuildAppid", Long.TYPE));
      label5174:
      i = paramCursor.getColumnIndex("hlGuildSubType");
      if (i != -1) {
        break label7811;
      }
      paramawgp.a(new NoColumnError("hlGuildSubType", Long.TYPE));
      label5211:
      i = paramCursor.getColumnIndex("hlGuildOrgid");
      if (i != -1) {
        break label7826;
      }
      paramawgp.a(new NoColumnError("hlGuildOrgid", Integer.TYPE));
      label5248:
      i = paramCursor.getColumnIndex("hlGuildBinary");
      if (i != -1) {
        break label7841;
      }
      paramawgp.a(new NoColumnError("hlGuildBinary", Integer.TYPE));
      label5285:
      i = paramCursor.getColumnIndex("gameSwitchStatus");
      if (i != -1) {
        break label7856;
      }
      paramawgp.a(new NoColumnError("gameSwitchStatus", Integer.TYPE));
      label5322:
      i = paramCursor.getColumnIndex("showGameSwitchStatus");
      if (i != -1) {
        break label7871;
      }
      paramawgp.a(new NoColumnError("showGameSwitchStatus", Integer.TYPE));
      label5359:
      i = paramCursor.getColumnIndex("lastShareLbsMsgUniseq");
      if (i != -1) {
        break label7886;
      }
      paramawgp.a(new NoColumnError("lastShareLbsMsgUniseq", Long.TYPE));
      label5396:
      i = paramCursor.getColumnIndex("mTroopNeedPayNumber");
      if (i != -1) {
        break label7901;
      }
      paramawgp.a(new NoColumnError("mTroopNeedPayNumber", Float.TYPE));
      label5433:
      i = paramCursor.getColumnIndex("troopCreditLevel");
      if (i != -1) {
        break label7916;
      }
      paramawgp.a(new NoColumnError("troopCreditLevel", Long.TYPE));
      label5470:
      i = paramCursor.getColumnIndex("troopCreditLevelInfo");
      if (i != -1) {
        break label7931;
      }
      paramawgp.a(new NoColumnError("troopCreditLevelInfo", Long.TYPE));
      label5507:
      i = paramCursor.getColumnIndex("dwAppPrivilegeFlag");
      if (i != -1) {
        break label7946;
      }
      paramawgp.a(new NoColumnError("dwAppPrivilegeFlag", Long.TYPE));
      label5544:
      i = paramCursor.getColumnIndex("topicId");
      if (i != -1) {
        break label7961;
      }
      paramawgp.a(new NoColumnError("topicId", String.class));
      label5581:
      i = paramCursor.getColumnIndex("associatePubAccount");
      if (i != -1) {
        break label7976;
      }
      paramawgp.a(new NoColumnError("associatePubAccount", Long.TYPE));
      label5618:
      i = paramCursor.getColumnIndex("mTroopFileVideoReqInterval");
      if (i != -1) {
        break label7991;
      }
      paramawgp.a(new NoColumnError("mTroopFileVideoReqInterval", Long.TYPE));
      label5655:
      i = paramCursor.getColumnIndex("mTroopFileVideoIsWhite");
      if (i != -1) {
        break label8006;
      }
      paramawgp.a(new NoColumnError("mTroopFileVideoIsWhite", Integer.TYPE));
      label5692:
      i = paramCursor.getColumnIndex("mTribeStatus");
      if (i != -1) {
        break label8021;
      }
      paramawgp.a(new NoColumnError("mTribeStatus", Integer.TYPE));
      label5729:
      i = paramCursor.getColumnIndex("mCanSearchByKeywords");
      if (i != -1) {
        break label8036;
      }
      paramawgp.a(new NoColumnError("mCanSearchByKeywords", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mCanSearchByTroopUin");
      if (i != -1) {
        break label8063;
      }
      paramawgp.a(new NoColumnError("mCanSearchByTroopUin", Boolean.TYPE));
      i = paramCursor.getColumnIndex("dwCmdUinJoinTime");
      if (i != -1) {
        break label8091;
      }
      paramawgp.a(new NoColumnError("dwCmdUinJoinTime", Long.TYPE));
      label5840:
      i = paramCursor.getColumnIndex("dwLastInsertBAFTipTime");
      if (i != -1) {
        break label8106;
      }
      paramawgp.a(new NoColumnError("dwLastInsertBAFTipTime", Long.TYPE));
      label5877:
      i = paramCursor.getColumnIndex("wInsertBAFTipCount");
      if (i != -1) {
        break label8121;
      }
      paramawgp.a(new NoColumnError("wInsertBAFTipCount", Integer.TYPE));
      label5914:
      i = paramCursor.getColumnIndex("wClickBAFTipCount");
      if (i != -1) {
        break label8136;
      }
      paramawgp.a(new NoColumnError("wClickBAFTipCount", Integer.TYPE));
      label5951:
      i = paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq");
      if (i != -1) {
        break label8151;
      }
      paramawgp.a(new NoColumnError("dwLastBAFTipMsgUniSeq", Long.TYPE));
      label5988:
      i = paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq2");
      if (i != -1) {
        break label8166;
      }
      paramawgp.a(new NoColumnError("dwLastBAFTipMsgUniSeq2", Long.TYPE));
      label6025:
      i = paramCursor.getColumnIndex("dailyNewMemberUins");
      if (i != -1) {
        break label8181;
      }
      paramawgp.a(new NoColumnError("dailyNewMemberUins", String.class));
      label6062:
      i = paramCursor.getColumnIndex("exitTroopReason");
      if (i != -1) {
        break label8196;
      }
      paramawgp.a(new NoColumnError("exitTroopReason", Integer.TYPE));
      label6099:
      i = paramCursor.getColumnIndex("eliminated");
      if (i != -1) {
        break label8211;
      }
      paramawgp.a(new NoColumnError("eliminated", Integer.TYPE));
      label6136:
      i = paramCursor.getColumnIndex("mIsFreezed");
      if (i != -1) {
        break label8226;
      }
      paramawgp.a(new NoColumnError("mIsFreezed", Integer.TYPE));
      label6173:
      i = paramCursor.getColumnIndex("strLastAnnouncement");
      if (i != -1) {
        break label8241;
      }
      paramawgp.a(new NoColumnError("strLastAnnouncement", String.class));
      label6210:
      i = paramCursor.getColumnIndex("nMsgLimitFreq");
      if (i != -1) {
        break label8256;
      }
      paramawgp.a(new NoColumnError("nMsgLimitFreq", Integer.TYPE));
      label6247:
      i = paramCursor.getColumnIndex("mAtOrReplyMeUins");
      if (i != -1) {
        break label8271;
      }
      paramawgp.a(new NoColumnError("mAtOrReplyMeUins", String.class));
      label6284:
      i = paramCursor.getColumnIndex("groupFlagExt4");
      if (i != -1) {
        break label8286;
      }
      paramawgp.a(new NoColumnError("groupFlagExt4", Integer.TYPE));
      label6321:
      i = paramCursor.getColumnIndex("groupFreezeReason");
      if (i != -1) {
        break label8301;
      }
      paramawgp.a(new NoColumnError("groupFreezeReason", Integer.TYPE));
      label6358:
      i = paramCursor.getColumnIndex("troopHonorGrayFlag");
      if (i != -1) {
        break label8316;
      }
      paramawgp.a(new NoColumnError("troopHonorGrayFlag", Integer.TYPE));
      label6395:
      i = paramCursor.getColumnIndex("isAllowHistoryMsgFlag");
      if (i != -1) {
        break label8331;
      }
      paramawgp.a(new NoColumnError("isAllowHistoryMsgFlag", Integer.TYPE));
      label6432:
      i = paramCursor.getColumnIndex("troopRepeatType");
      if (i != -1) {
        break label8346;
      }
      paramawgp.a(new NoColumnError("troopRepeatType", Integer.TYPE));
      label6469:
      i = paramCursor.getColumnIndex("feeds_id");
      if (i != -1) {
        break label8361;
      }
      paramawgp.a(new NoColumnError("feeds_id", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("myHonorList");
      if (i != -1) {
        break label8376;
      }
      paramawgp.a(new NoColumnError("myHonorList", String.class));
      return paramawge;
      paramawge.uin = paramCursor.getString(i);
      break;
      label6560:
      paramawge.timeSec = paramCursor.getLong(i);
      break label2353;
      label6575:
      paramawge.troopuin = paramCursor.getString(i);
      break label2388;
      label6590:
      paramawge.troopcode = paramCursor.getString(i);
      break label2423;
      label6605:
      paramawge.troopowneruin = paramCursor.getString(i);
      break label2458;
      label6620:
      paramawge.troopname = paramCursor.getString(i);
      break label2493;
      label6635:
      paramawge.newTroopName = paramCursor.getString(i);
      break label2528;
      label6650:
      paramawge.newTroopNameTimeStamp = paramCursor.getLong(i);
      break label2563;
      label6665:
      paramawge.troopface = paramCursor.getShort(i);
      break label2598;
      label6680:
      paramawge.troopmemo = paramCursor.getString(i);
      break label2633;
      label6695:
      paramawge.fingertroopmemo = paramCursor.getString(i);
      break label2668;
      label6710:
      paramawge.mRichFingerMemo = paramCursor.getString(i);
      break label2703;
      label6725:
      paramawge.troopmask = paramCursor.getInt(i);
      break label2738;
      label6740:
      paramawge.trooptype = paramCursor.getInt(i);
      break label2773;
      label6755:
      paramawge.troopCreateTime = paramCursor.getLong(i);
      break label2808;
      label6770:
      paramawge.dwGroupFlag = paramCursor.getLong(i);
      break label2843;
      label6785:
      paramawge.cGroupOption = paramCursor.getShort(i);
      break label2878;
      label6800:
      paramawge.wMemberMax = paramCursor.getInt(i);
      break label2913;
      label6815:
      paramawge.maxAdminNum = paramCursor.getInt(i);
      break label2948;
      label6830:
      paramawge.wSpecialClass = paramCursor.getInt(i);
      break label2983;
      label6845:
      paramawge.cGroupLevel = paramCursor.getShort(i);
      break label3018;
      label6860:
      paramawge.wMemberNum = paramCursor.getInt(i);
      break label3053;
      label6875:
      paramawge.wMemberNumClient = paramCursor.getInt(i);
      break label3088;
      label6890:
      paramawge.Administrator = paramCursor.getString(i);
      break label3123;
      label6905:
      paramawge.dwGroupClassExt = paramCursor.getLong(i);
      break label3158;
      label6920:
      paramawge.mGroupClassExtText = paramCursor.getString(i);
      break label3193;
      label6935:
      paramawge.dwGroupFlagExt = paramCursor.getLong(i);
      break label3228;
      label6950:
      paramawge.dwAuthGroupType = paramCursor.getLong(i);
      break label3263;
      label6965:
      paramawge.troopAuthenticateInfo = paramCursor.getString(i);
      break label3298;
      label6980:
      paramawge.dwGroupInfoSeq = paramCursor.getLong(i);
      break label3333;
      label6995:
      paramawge.mMemberNumSeq = paramCursor.getLong(i);
      break label3368;
      label7010:
      paramawge.mOldMemberNumSeq = paramCursor.getLong(i);
      break label3403;
      label7025:
      paramawge.mMemberCardSeq = paramCursor.getLong(i);
      break label3438;
      label7040:
      paramawge.mOldMemberCardSeq = paramCursor.getLong(i);
      break label3473;
      label7055:
      paramawge.dwGroupLevelSeq = paramCursor.getLong(i);
      break label3508;
      label7070:
      paramawge.cGroupRankSysFlag = ((byte)paramCursor.getShort(i));
      break label3543;
      label7086:
      paramawge.cGroupRankUserFlag = ((byte)paramCursor.getShort(i));
      break label3578;
      label7102:
      paramawge.troopLevelMap = paramCursor.getString(i);
      break label3613;
      label7117:
      paramawge.joinTroopQuestion = paramCursor.getString(i);
      break label3648;
      label7132:
      paramawge.joinTroopAnswer = paramCursor.getString(i);
      break label3683;
      label7147:
      paramawge.cAlbumResult = ((byte)paramCursor.getShort(i));
      break label3718;
      label7163:
      paramawge.dwTimeStamp = paramCursor.getLong(i);
      break label3753;
      label7178:
      paramawge.strQZonePhotoUrls = paramCursor.getString(i);
      break label3788;
      label7193:
      paramawge.mQZonePhotoNum = paramCursor.getInt(i);
      break label3823;
      label7208:
      paramawge.strLocation = paramCursor.getString(i);
      break label3858;
      label7223:
      paramawge.troopLat = paramCursor.getInt(i);
      break label3893;
      label7238:
      paramawge.troopLon = paramCursor.getInt(i);
      break label3928;
      label7253:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.mMemberInvitingFlag = paramBoolean;
        break;
      }
      label7280:
      paramawge.mComparePartInt = paramCursor.getInt(i);
      break label3998;
      label7295:
      paramawge.mCompareSpell = paramCursor.getString(i);
      break label4033;
      label7310:
      paramawge.mSomeMemberUins = paramCursor.getString(i);
      break label4068;
      label7325:
      paramawge.mHeaderUinsOld = paramCursor.getString(i);
      break label4103;
      label7340:
      paramawge.mHeaderUinsNew = paramCursor.getString(i);
      break label4138;
      label7355:
      paramawge.mTags = paramCursor.getString(i);
      break label4175;
      label7370:
      paramawge.mTroopAvatarId = paramCursor.getInt(i);
      break label4212;
      label7385:
      paramawge.mTroopPicListJson = paramCursor.getString(i);
      break label4249;
      label7400:
      paramawge.nTroopGrade = paramCursor.getInt(i);
      break label4286;
      label7415:
      paramawge.isShowInNearbyTroops = paramCursor.getInt(i);
      break label4323;
      label7430:
      paramawge.dwGagTimeStamp = paramCursor.getLong(i);
      break label4360;
      label7445:
      paramawge.dwGagTimeStamp_me = paramCursor.getLong(i);
      break label4397;
      label7460:
      paramawge.dwCmdUinUinFlag = paramCursor.getLong(i);
      break label4434;
      label7475:
      paramawge.dwAdditionalFlag = paramCursor.getLong(i);
      break label4471;
      label7490:
      paramawge.troopTypeExt = paramCursor.getInt(i);
      break label4508;
      label7505:
      paramawge.ownerNameShow = paramCursor.getString(i);
      break label4545;
      label7520:
      paramawge.adminNameShow = paramCursor.getString(i);
      break label4582;
      label7535:
      paramawge.dwOfficeMode = paramCursor.getLong(i);
      break label4619;
      label7550:
      paramawge.dwGroupFlagExt3 = paramCursor.getLong(i);
      break label4656;
      label7565:
      paramawge.cmdUinFlagEx2 = paramCursor.getLong(i);
      break label4693;
      label7580:
      paramawge.udwCmdUinRingtoneID = paramCursor.getLong(i);
      break label4730;
      label7595:
      paramawge.memberListToShow = paramCursor.getString(i);
      break label4767;
      label7610:
      paramawge.troopPrivilegeFlag = paramCursor.getLong(i);
      break label4804;
      label7625:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isNewTroop = paramBoolean;
        break;
      }
      label7652:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.hasSetNewTroopHead = paramBoolean;
        break;
      }
      label7679:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.hasSetNewTroopName = paramBoolean;
        break;
      }
      label7706:
      paramawge.maxInviteMemNum = paramCursor.getInt(i);
      break label4952;
      label7721:
      paramawge.lastMsgTime = paramCursor.getLong(i);
      break label4989;
      label7736:
      paramawge.allowMemberModifTroopName = paramCursor.getInt(i);
      break label5026;
      label7751:
      paramawge.allowMemberKick = paramCursor.getInt(i);
      break label5063;
      label7766:
      paramawge.allowMemberAtAll = paramCursor.getInt(i);
      break label5100;
      label7781:
      paramawge.oldTroopName = paramCursor.getString(i);
      break label5137;
      label7796:
      paramawge.hlGuildAppid = paramCursor.getLong(i);
      break label5174;
      label7811:
      paramawge.hlGuildSubType = paramCursor.getLong(i);
      break label5211;
      label7826:
      paramawge.hlGuildOrgid = paramCursor.getInt(i);
      break label5248;
      label7841:
      paramawge.hlGuildBinary = paramCursor.getInt(i);
      break label5285;
      label7856:
      paramawge.gameSwitchStatus = paramCursor.getInt(i);
      break label5322;
      label7871:
      paramawge.showGameSwitchStatus = paramCursor.getInt(i);
      break label5359;
      label7886:
      paramawge.lastShareLbsMsgUniseq = paramCursor.getLong(i);
      break label5396;
      label7901:
      paramawge.mTroopNeedPayNumber = paramCursor.getFloat(i);
      break label5433;
      label7916:
      paramawge.troopCreditLevel = paramCursor.getLong(i);
      break label5470;
      label7931:
      paramawge.troopCreditLevelInfo = paramCursor.getLong(i);
      break label5507;
      label7946:
      paramawge.dwAppPrivilegeFlag = paramCursor.getLong(i);
      break label5544;
      label7961:
      paramawge.topicId = paramCursor.getString(i);
      break label5581;
      label7976:
      paramawge.associatePubAccount = paramCursor.getLong(i);
      break label5618;
      label7991:
      paramawge.mTroopFileVideoReqInterval = paramCursor.getLong(i);
      break label5655;
      label8006:
      paramawge.mTroopFileVideoIsWhite = paramCursor.getInt(i);
      break label5692;
      label8021:
      paramawge.mTribeStatus = paramCursor.getInt(i);
      break label5729;
      label8036:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.mCanSearchByKeywords = paramBoolean;
        break;
      }
      label8063:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramawge.mCanSearchByTroopUin = paramBoolean;
        break;
      }
      label8091:
      paramawge.dwCmdUinJoinTime = paramCursor.getLong(i);
      break label5840;
      label8106:
      paramawge.dwLastInsertBAFTipTime = paramCursor.getLong(i);
      break label5877;
      label8121:
      paramawge.wInsertBAFTipCount = paramCursor.getInt(i);
      break label5914;
      label8136:
      paramawge.wClickBAFTipCount = paramCursor.getInt(i);
      break label5951;
      label8151:
      paramawge.dwLastBAFTipMsgUniSeq = paramCursor.getLong(i);
      break label5988;
      label8166:
      paramawge.dwLastBAFTipMsgUniSeq2 = paramCursor.getLong(i);
      break label6025;
      label8181:
      paramawge.dailyNewMemberUins = paramCursor.getString(i);
      break label6062;
      label8196:
      paramawge.exitTroopReason = paramCursor.getInt(i);
      break label6099;
      label8211:
      paramawge.eliminated = paramCursor.getInt(i);
      break label6136;
      label8226:
      paramawge.mIsFreezed = paramCursor.getInt(i);
      break label6173;
      label8241:
      paramawge.strLastAnnouncement = paramCursor.getString(i);
      break label6210;
      label8256:
      paramawge.nMsgLimitFreq = paramCursor.getInt(i);
      break label6247;
      label8271:
      paramawge.mAtOrReplyMeUins = paramCursor.getString(i);
      break label6284;
      label8286:
      paramawge.groupFlagExt4 = paramCursor.getInt(i);
      break label6321;
      label8301:
      paramawge.groupFreezeReason = paramCursor.getInt(i);
      break label6358;
      label8316:
      paramawge.troopHonorGrayFlag = paramCursor.getInt(i);
      break label6395;
      label8331:
      paramawge.isAllowHistoryMsgFlag = paramCursor.getInt(i);
      break label6432;
      label8346:
      paramawge.troopRepeatType = paramCursor.getInt(i);
      break label6469;
      label8361:
      paramawge.feeds_id = paramCursor.getString(i);
    }
    label8376:
    paramawge.myHonorList = paramCursor.getString(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,timeSec INTEGER ,troopuin TEXT UNIQUE ,troopcode TEXT ,troopowneruin TEXT ,troopname TEXT ,newTroopName TEXT ,newTroopNameTimeStamp INTEGER ,troopface INTEGER ,troopmemo TEXT ,fingertroopmemo TEXT ,mRichFingerMemo TEXT ,troopmask INTEGER ,trooptype INTEGER ,troopCreateTime INTEGER ,dwGroupFlag INTEGER ,cGroupOption INTEGER ,wMemberMax INTEGER ,maxAdminNum INTEGER ,wSpecialClass INTEGER ,cGroupLevel INTEGER ,wMemberNum INTEGER ,wMemberNumClient INTEGER ,Administrator TEXT ,dwGroupClassExt INTEGER ,mGroupClassExtText TEXT ,dwGroupFlagExt INTEGER ,dwAuthGroupType INTEGER ,troopAuthenticateInfo TEXT ,dwGroupInfoSeq INTEGER ,mMemberNumSeq INTEGER ,mOldMemberNumSeq INTEGER ,mMemberCardSeq INTEGER ,mOldMemberCardSeq INTEGER ,dwGroupLevelSeq INTEGER ,cGroupRankSysFlag INTEGER ,cGroupRankUserFlag INTEGER ,troopLevelMap TEXT ,joinTroopQuestion TEXT ,joinTroopAnswer TEXT ,cAlbumResult INTEGER ,dwTimeStamp INTEGER ,strQZonePhotoUrls TEXT ,mQZonePhotoNum INTEGER ,strLocation TEXT ,troopLat INTEGER ,troopLon INTEGER ,mMemberInvitingFlag INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,mSomeMemberUins TEXT ,mHeaderUinsOld TEXT ,mHeaderUinsNew TEXT ,mTags TEXT ,mTroopAvatarId INTEGER ,mTroopPicListJson TEXT ,nTroopGrade INTEGER ,isShowInNearbyTroops INTEGER ,dwGagTimeStamp INTEGER ,dwGagTimeStamp_me INTEGER ,dwCmdUinUinFlag INTEGER ,dwAdditionalFlag INTEGER ,troopTypeExt INTEGER ,ownerNameShow TEXT ,adminNameShow TEXT ,dwOfficeMode INTEGER ,dwGroupFlagExt3 INTEGER ,cmdUinFlagEx2 INTEGER ,udwCmdUinRingtoneID INTEGER ,memberListToShow TEXT ,troopPrivilegeFlag INTEGER ,isNewTroop INTEGER ,hasSetNewTroopHead INTEGER ,hasSetNewTroopName INTEGER ,maxInviteMemNum INTEGER ,lastMsgTime INTEGER ,allowMemberModifTroopName INTEGER ,allowMemberKick INTEGER ,allowMemberAtAll INTEGER ,oldTroopName TEXT ,hlGuildAppid INTEGER ,hlGuildSubType INTEGER ,hlGuildOrgid INTEGER ,hlGuildBinary INTEGER ,gameSwitchStatus INTEGER ,showGameSwitchStatus INTEGER ,lastShareLbsMsgUniseq INTEGER ,mTroopNeedPayNumber REAL ,troopCreditLevel INTEGER ,troopCreditLevelInfo INTEGER ,dwAppPrivilegeFlag INTEGER ,topicId TEXT ,associatePubAccount INTEGER ,mTroopFileVideoReqInterval INTEGER ,mTroopFileVideoIsWhite INTEGER ,mTribeStatus INTEGER ,mCanSearchByKeywords INTEGER ,mCanSearchByTroopUin INTEGER ,dwCmdUinJoinTime INTEGER ,dwLastInsertBAFTipTime INTEGER ,wInsertBAFTipCount INTEGER ,wClickBAFTipCount INTEGER ,dwLastBAFTipMsgUniSeq INTEGER ,dwLastBAFTipMsgUniSeq2 INTEGER ,dailyNewMemberUins TEXT ,exitTroopReason INTEGER ,eliminated INTEGER ,mIsFreezed INTEGER ,strLastAnnouncement TEXT ,nMsgLimitFreq INTEGER ,mAtOrReplyMeUins TEXT ,groupFlagExt4 INTEGER ,groupFreezeReason INTEGER ,troopHonorGrayFlag INTEGER ,isAllowHistoryMsgFlag INTEGER ,troopRepeatType INTEGER ,feeds_id TEXT ,myHonorList TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (TroopInfo)paramawge;
    paramContentValues.put("uin", paramawge.uin);
    paramContentValues.put("timeSec", Long.valueOf(paramawge.timeSec));
    paramContentValues.put("troopuin", paramawge.troopuin);
    paramContentValues.put("troopcode", paramawge.troopcode);
    paramContentValues.put("troopowneruin", paramawge.troopowneruin);
    paramContentValues.put("troopname", paramawge.troopname);
    paramContentValues.put("newTroopName", paramawge.newTroopName);
    paramContentValues.put("newTroopNameTimeStamp", Long.valueOf(paramawge.newTroopNameTimeStamp));
    paramContentValues.put("troopface", Short.valueOf(paramawge.troopface));
    paramContentValues.put("troopmemo", paramawge.troopmemo);
    paramContentValues.put("fingertroopmemo", paramawge.fingertroopmemo);
    paramContentValues.put("mRichFingerMemo", paramawge.mRichFingerMemo);
    paramContentValues.put("troopmask", Integer.valueOf(paramawge.troopmask));
    paramContentValues.put("trooptype", Integer.valueOf(paramawge.trooptype));
    paramContentValues.put("troopCreateTime", Long.valueOf(paramawge.troopCreateTime));
    paramContentValues.put("dwGroupFlag", Long.valueOf(paramawge.dwGroupFlag));
    paramContentValues.put("cGroupOption", Short.valueOf(paramawge.cGroupOption));
    paramContentValues.put("wMemberMax", Integer.valueOf(paramawge.wMemberMax));
    paramContentValues.put("maxAdminNum", Integer.valueOf(paramawge.maxAdminNum));
    paramContentValues.put("wSpecialClass", Integer.valueOf(paramawge.wSpecialClass));
    paramContentValues.put("cGroupLevel", Short.valueOf(paramawge.cGroupLevel));
    paramContentValues.put("wMemberNum", Integer.valueOf(paramawge.wMemberNum));
    paramContentValues.put("wMemberNumClient", Integer.valueOf(paramawge.wMemberNumClient));
    paramContentValues.put("Administrator", paramawge.Administrator);
    paramContentValues.put("dwGroupClassExt", Long.valueOf(paramawge.dwGroupClassExt));
    paramContentValues.put("mGroupClassExtText", paramawge.mGroupClassExtText);
    paramContentValues.put("dwGroupFlagExt", Long.valueOf(paramawge.dwGroupFlagExt));
    paramContentValues.put("dwAuthGroupType", Long.valueOf(paramawge.dwAuthGroupType));
    paramContentValues.put("troopAuthenticateInfo", paramawge.troopAuthenticateInfo);
    paramContentValues.put("dwGroupInfoSeq", Long.valueOf(paramawge.dwGroupInfoSeq));
    paramContentValues.put("mMemberNumSeq", Long.valueOf(paramawge.mMemberNumSeq));
    paramContentValues.put("mOldMemberNumSeq", Long.valueOf(paramawge.mOldMemberNumSeq));
    paramContentValues.put("mMemberCardSeq", Long.valueOf(paramawge.mMemberCardSeq));
    paramContentValues.put("mOldMemberCardSeq", Long.valueOf(paramawge.mOldMemberCardSeq));
    paramContentValues.put("dwGroupLevelSeq", Long.valueOf(paramawge.dwGroupLevelSeq));
    paramContentValues.put("cGroupRankSysFlag", Byte.valueOf(paramawge.cGroupRankSysFlag));
    paramContentValues.put("cGroupRankUserFlag", Byte.valueOf(paramawge.cGroupRankUserFlag));
    paramContentValues.put("troopLevelMap", paramawge.troopLevelMap);
    paramContentValues.put("joinTroopQuestion", paramawge.joinTroopQuestion);
    paramContentValues.put("joinTroopAnswer", paramawge.joinTroopAnswer);
    paramContentValues.put("cAlbumResult", Byte.valueOf(paramawge.cAlbumResult));
    paramContentValues.put("dwTimeStamp", Long.valueOf(paramawge.dwTimeStamp));
    paramContentValues.put("strQZonePhotoUrls", paramawge.strQZonePhotoUrls);
    paramContentValues.put("mQZonePhotoNum", Integer.valueOf(paramawge.mQZonePhotoNum));
    paramContentValues.put("strLocation", paramawge.strLocation);
    paramContentValues.put("troopLat", Integer.valueOf(paramawge.troopLat));
    paramContentValues.put("troopLon", Integer.valueOf(paramawge.troopLon));
    paramContentValues.put("mMemberInvitingFlag", Boolean.valueOf(paramawge.mMemberInvitingFlag));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramawge.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramawge.mCompareSpell);
    paramContentValues.put("mSomeMemberUins", paramawge.mSomeMemberUins);
    paramContentValues.put("mHeaderUinsOld", paramawge.mHeaderUinsOld);
    paramContentValues.put("mHeaderUinsNew", paramawge.mHeaderUinsNew);
    paramContentValues.put("mTags", paramawge.mTags);
    paramContentValues.put("mTroopAvatarId", Integer.valueOf(paramawge.mTroopAvatarId));
    paramContentValues.put("mTroopPicListJson", paramawge.mTroopPicListJson);
    paramContentValues.put("nTroopGrade", Integer.valueOf(paramawge.nTroopGrade));
    paramContentValues.put("isShowInNearbyTroops", Integer.valueOf(paramawge.isShowInNearbyTroops));
    paramContentValues.put("dwGagTimeStamp", Long.valueOf(paramawge.dwGagTimeStamp));
    paramContentValues.put("dwGagTimeStamp_me", Long.valueOf(paramawge.dwGagTimeStamp_me));
    paramContentValues.put("dwCmdUinUinFlag", Long.valueOf(paramawge.dwCmdUinUinFlag));
    paramContentValues.put("dwAdditionalFlag", Long.valueOf(paramawge.dwAdditionalFlag));
    paramContentValues.put("troopTypeExt", Integer.valueOf(paramawge.troopTypeExt));
    paramContentValues.put("ownerNameShow", paramawge.ownerNameShow);
    paramContentValues.put("adminNameShow", paramawge.adminNameShow);
    paramContentValues.put("dwOfficeMode", Long.valueOf(paramawge.dwOfficeMode));
    paramContentValues.put("dwGroupFlagExt3", Long.valueOf(paramawge.dwGroupFlagExt3));
    paramContentValues.put("cmdUinFlagEx2", Long.valueOf(paramawge.cmdUinFlagEx2));
    paramContentValues.put("udwCmdUinRingtoneID", Long.valueOf(paramawge.udwCmdUinRingtoneID));
    paramContentValues.put("memberListToShow", paramawge.memberListToShow);
    paramContentValues.put("troopPrivilegeFlag", Long.valueOf(paramawge.troopPrivilegeFlag));
    paramContentValues.put("isNewTroop", Boolean.valueOf(paramawge.isNewTroop));
    paramContentValues.put("hasSetNewTroopHead", Boolean.valueOf(paramawge.hasSetNewTroopHead));
    paramContentValues.put("hasSetNewTroopName", Boolean.valueOf(paramawge.hasSetNewTroopName));
    paramContentValues.put("maxInviteMemNum", Integer.valueOf(paramawge.maxInviteMemNum));
    paramContentValues.put("lastMsgTime", Long.valueOf(paramawge.lastMsgTime));
    paramContentValues.put("allowMemberModifTroopName", Integer.valueOf(paramawge.allowMemberModifTroopName));
    paramContentValues.put("allowMemberKick", Integer.valueOf(paramawge.allowMemberKick));
    paramContentValues.put("allowMemberAtAll", Integer.valueOf(paramawge.allowMemberAtAll));
    paramContentValues.put("oldTroopName", paramawge.oldTroopName);
    paramContentValues.put("hlGuildAppid", Long.valueOf(paramawge.hlGuildAppid));
    paramContentValues.put("hlGuildSubType", Long.valueOf(paramawge.hlGuildSubType));
    paramContentValues.put("hlGuildOrgid", Integer.valueOf(paramawge.hlGuildOrgid));
    paramContentValues.put("hlGuildBinary", Integer.valueOf(paramawge.hlGuildBinary));
    paramContentValues.put("gameSwitchStatus", Integer.valueOf(paramawge.gameSwitchStatus));
    paramContentValues.put("showGameSwitchStatus", Integer.valueOf(paramawge.showGameSwitchStatus));
    paramContentValues.put("lastShareLbsMsgUniseq", Long.valueOf(paramawge.lastShareLbsMsgUniseq));
    paramContentValues.put("mTroopNeedPayNumber", Float.valueOf(paramawge.mTroopNeedPayNumber));
    paramContentValues.put("troopCreditLevel", Long.valueOf(paramawge.troopCreditLevel));
    paramContentValues.put("troopCreditLevelInfo", Long.valueOf(paramawge.troopCreditLevelInfo));
    paramContentValues.put("dwAppPrivilegeFlag", Long.valueOf(paramawge.dwAppPrivilegeFlag));
    paramContentValues.put("topicId", paramawge.topicId);
    paramContentValues.put("associatePubAccount", Long.valueOf(paramawge.associatePubAccount));
    paramContentValues.put("mTroopFileVideoReqInterval", Long.valueOf(paramawge.mTroopFileVideoReqInterval));
    paramContentValues.put("mTroopFileVideoIsWhite", Integer.valueOf(paramawge.mTroopFileVideoIsWhite));
    paramContentValues.put("mTribeStatus", Integer.valueOf(paramawge.mTribeStatus));
    paramContentValues.put("mCanSearchByKeywords", Boolean.valueOf(paramawge.mCanSearchByKeywords));
    paramContentValues.put("mCanSearchByTroopUin", Boolean.valueOf(paramawge.mCanSearchByTroopUin));
    paramContentValues.put("dwCmdUinJoinTime", Long.valueOf(paramawge.dwCmdUinJoinTime));
    paramContentValues.put("dwLastInsertBAFTipTime", Long.valueOf(paramawge.dwLastInsertBAFTipTime));
    paramContentValues.put("wInsertBAFTipCount", Integer.valueOf(paramawge.wInsertBAFTipCount));
    paramContentValues.put("wClickBAFTipCount", Integer.valueOf(paramawge.wClickBAFTipCount));
    paramContentValues.put("dwLastBAFTipMsgUniSeq", Long.valueOf(paramawge.dwLastBAFTipMsgUniSeq));
    paramContentValues.put("dwLastBAFTipMsgUniSeq2", Long.valueOf(paramawge.dwLastBAFTipMsgUniSeq2));
    paramContentValues.put("dailyNewMemberUins", paramawge.dailyNewMemberUins);
    paramContentValues.put("exitTroopReason", Integer.valueOf(paramawge.exitTroopReason));
    paramContentValues.put("eliminated", Integer.valueOf(paramawge.eliminated));
    paramContentValues.put("mIsFreezed", Integer.valueOf(paramawge.mIsFreezed));
    paramContentValues.put("strLastAnnouncement", paramawge.strLastAnnouncement);
    paramContentValues.put("nMsgLimitFreq", Integer.valueOf(paramawge.nMsgLimitFreq));
    paramContentValues.put("mAtOrReplyMeUins", paramawge.mAtOrReplyMeUins);
    paramContentValues.put("groupFlagExt4", Integer.valueOf(paramawge.groupFlagExt4));
    paramContentValues.put("groupFreezeReason", Integer.valueOf(paramawge.groupFreezeReason));
    paramContentValues.put("troopHonorGrayFlag", Integer.valueOf(paramawge.troopHonorGrayFlag));
    paramContentValues.put("isAllowHistoryMsgFlag", Integer.valueOf(paramawge.isAllowHistoryMsgFlag));
    paramContentValues.put("troopRepeatType", Integer.valueOf(paramawge.troopRepeatType));
    paramContentValues.put("feeds_id", paramawge.feeds_id);
    paramContentValues.put("myHonorList", paramawge.myHonorList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awhi
 * JD-Core Version:    0.7.0.1
 */