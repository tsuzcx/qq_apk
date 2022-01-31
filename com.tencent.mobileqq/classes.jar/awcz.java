import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awcz
  extends awch
{
  public awcz()
  {
    this.a = 118;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawbv = (TroopInfo)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawbv.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
      paramawbv.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
      paramawbv.troopcode = paramCursor.getString(paramCursor.getColumnIndex("troopcode"));
      paramawbv.troopowneruin = paramCursor.getString(paramCursor.getColumnIndex("troopowneruin"));
      paramawbv.troopname = paramCursor.getString(paramCursor.getColumnIndex("troopname"));
      paramawbv.newTroopName = paramCursor.getString(paramCursor.getColumnIndex("newTroopName"));
      paramawbv.newTroopNameTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("newTroopNameTimeStamp"));
      paramawbv.troopface = paramCursor.getShort(paramCursor.getColumnIndex("troopface"));
      paramawbv.troopmemo = paramCursor.getString(paramCursor.getColumnIndex("troopmemo"));
      paramawbv.fingertroopmemo = paramCursor.getString(paramCursor.getColumnIndex("fingertroopmemo"));
      paramawbv.mRichFingerMemo = paramCursor.getString(paramCursor.getColumnIndex("mRichFingerMemo"));
      paramawbv.troopmask = paramCursor.getInt(paramCursor.getColumnIndex("troopmask"));
      paramawbv.trooptype = paramCursor.getInt(paramCursor.getColumnIndex("trooptype"));
      paramawbv.troopCreateTime = paramCursor.getLong(paramCursor.getColumnIndex("troopCreateTime"));
      paramawbv.dwGroupFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlag"));
      paramawbv.cGroupOption = paramCursor.getShort(paramCursor.getColumnIndex("cGroupOption"));
      paramawbv.wMemberMax = paramCursor.getInt(paramCursor.getColumnIndex("wMemberMax"));
      paramawbv.maxAdminNum = paramCursor.getInt(paramCursor.getColumnIndex("maxAdminNum"));
      paramawbv.wSpecialClass = paramCursor.getInt(paramCursor.getColumnIndex("wSpecialClass"));
      paramawbv.cGroupLevel = paramCursor.getShort(paramCursor.getColumnIndex("cGroupLevel"));
      paramawbv.wMemberNum = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNum"));
      paramawbv.wMemberNumClient = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNumClient"));
      paramawbv.Administrator = paramCursor.getString(paramCursor.getColumnIndex("Administrator"));
      paramawbv.dwGroupClassExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupClassExt"));
      paramawbv.mGroupClassExtText = paramCursor.getString(paramCursor.getColumnIndex("mGroupClassExtText"));
      paramawbv.dwGroupFlagExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt"));
      paramawbv.dwAuthGroupType = paramCursor.getLong(paramCursor.getColumnIndex("dwAuthGroupType"));
      paramawbv.troopAuthenticateInfo = paramCursor.getString(paramCursor.getColumnIndex("troopAuthenticateInfo"));
      paramawbv.dwGroupInfoSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupInfoSeq"));
      paramawbv.mMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberNumSeq"));
      paramawbv.mOldMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberNumSeq"));
      paramawbv.mMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberCardSeq"));
      paramawbv.mOldMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberCardSeq"));
      paramawbv.dwGroupLevelSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupLevelSeq"));
      paramawbv.cGroupRankSysFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankSysFlag")));
      paramawbv.cGroupRankUserFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankUserFlag")));
      paramawbv.troopLevelMap = paramCursor.getString(paramCursor.getColumnIndex("troopLevelMap"));
      paramawbv.joinTroopQuestion = paramCursor.getString(paramCursor.getColumnIndex("joinTroopQuestion"));
      paramawbv.joinTroopAnswer = paramCursor.getString(paramCursor.getColumnIndex("joinTroopAnswer"));
      paramawbv.cAlbumResult = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cAlbumResult")));
      paramawbv.dwTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwTimeStamp"));
      paramawbv.strQZonePhotoUrls = paramCursor.getString(paramCursor.getColumnIndex("strQZonePhotoUrls"));
      paramawbv.mQZonePhotoNum = paramCursor.getInt(paramCursor.getColumnIndex("mQZonePhotoNum"));
      paramawbv.strLocation = paramCursor.getString(paramCursor.getColumnIndex("strLocation"));
      paramawbv.troopLat = paramCursor.getInt(paramCursor.getColumnIndex("troopLat"));
      paramawbv.troopLon = paramCursor.getInt(paramCursor.getColumnIndex("troopLon"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("mMemberInvitingFlag")))
      {
        paramBoolean = true;
        paramawbv.mMemberInvitingFlag = paramBoolean;
        paramawbv.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramawbv.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramawbv.mSomeMemberUins = paramCursor.getString(paramCursor.getColumnIndex("mSomeMemberUins"));
        paramawbv.mHeaderUinsOld = paramCursor.getString(paramCursor.getColumnIndex("mHeaderUinsOld"));
        paramawbv.mHeaderUinsNew = paramCursor.getString(paramCursor.getColumnIndex("mHeaderUinsNew"));
        paramawbv.mTags = paramCursor.getString(paramCursor.getColumnIndex("mTags"));
        paramawbv.mTroopAvatarId = paramCursor.getInt(paramCursor.getColumnIndex("mTroopAvatarId"));
        paramawbv.mTroopPicListJson = paramCursor.getString(paramCursor.getColumnIndex("mTroopPicListJson"));
        paramawbv.nTroopGrade = paramCursor.getInt(paramCursor.getColumnIndex("nTroopGrade"));
        paramawbv.isShowInNearbyTroops = paramCursor.getInt(paramCursor.getColumnIndex("isShowInNearbyTroops"));
        paramawbv.dwGagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp"));
        paramawbv.dwGagTimeStamp_me = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp_me"));
        paramawbv.dwCmdUinUinFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwCmdUinUinFlag"));
        paramawbv.dwAdditionalFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAdditionalFlag"));
        paramawbv.troopTypeExt = paramCursor.getInt(paramCursor.getColumnIndex("troopTypeExt"));
        paramawbv.ownerNameShow = paramCursor.getString(paramCursor.getColumnIndex("ownerNameShow"));
        paramawbv.adminNameShow = paramCursor.getString(paramCursor.getColumnIndex("adminNameShow"));
        paramawbv.dwOfficeMode = paramCursor.getLong(paramCursor.getColumnIndex("dwOfficeMode"));
        paramawbv.dwGroupFlagExt3 = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt3"));
        paramawbv.cmdUinFlagEx2 = paramCursor.getLong(paramCursor.getColumnIndex("cmdUinFlagEx2"));
        paramawbv.udwCmdUinRingtoneID = paramCursor.getLong(paramCursor.getColumnIndex("udwCmdUinRingtoneID"));
        paramawbv.memberListToShow = paramCursor.getString(paramCursor.getColumnIndex("memberListToShow"));
        paramawbv.troopPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("troopPrivilegeFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isNewTroop"))) {
          break label2258;
        }
        paramBoolean = true;
        label1343:
        paramawbv.isNewTroop = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSetNewTroopHead"))) {
          break label2263;
        }
        paramBoolean = true;
        label1369:
        paramawbv.hasSetNewTroopHead = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSetNewTroopName"))) {
          break label2268;
        }
        paramBoolean = true;
        label1395:
        paramawbv.hasSetNewTroopName = paramBoolean;
        paramawbv.maxInviteMemNum = paramCursor.getInt(paramCursor.getColumnIndex("maxInviteMemNum"));
        paramawbv.lastMsgTime = paramCursor.getLong(paramCursor.getColumnIndex("lastMsgTime"));
        paramawbv.allowMemberModifTroopName = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberModifTroopName"));
        paramawbv.allowMemberKick = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberKick"));
        paramawbv.allowMemberAtAll = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberAtAll"));
        paramawbv.oldTroopName = paramCursor.getString(paramCursor.getColumnIndex("oldTroopName"));
        paramawbv.hlGuildAppid = paramCursor.getLong(paramCursor.getColumnIndex("hlGuildAppid"));
        paramawbv.hlGuildSubType = paramCursor.getLong(paramCursor.getColumnIndex("hlGuildSubType"));
        paramawbv.hlGuildOrgid = paramCursor.getInt(paramCursor.getColumnIndex("hlGuildOrgid"));
        paramawbv.hlGuildBinary = paramCursor.getInt(paramCursor.getColumnIndex("hlGuildBinary"));
        paramawbv.gameSwitchStatus = paramCursor.getInt(paramCursor.getColumnIndex("gameSwitchStatus"));
        paramawbv.showGameSwitchStatus = paramCursor.getInt(paramCursor.getColumnIndex("showGameSwitchStatus"));
        paramawbv.lastShareLbsMsgUniseq = paramCursor.getLong(paramCursor.getColumnIndex("lastShareLbsMsgUniseq"));
        paramawbv.mTroopNeedPayNumber = paramCursor.getFloat(paramCursor.getColumnIndex("mTroopNeedPayNumber"));
        paramawbv.troopCreditLevel = paramCursor.getLong(paramCursor.getColumnIndex("troopCreditLevel"));
        paramawbv.troopCreditLevelInfo = paramCursor.getLong(paramCursor.getColumnIndex("troopCreditLevelInfo"));
        paramawbv.dwAppPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAppPrivilegeFlag"));
        paramawbv.topicId = paramCursor.getString(paramCursor.getColumnIndex("topicId"));
        paramawbv.associatePubAccount = paramCursor.getLong(paramCursor.getColumnIndex("associatePubAccount"));
        paramawbv.mTroopFileVideoReqInterval = paramCursor.getLong(paramCursor.getColumnIndex("mTroopFileVideoReqInterval"));
        paramawbv.mTroopFileVideoIsWhite = paramCursor.getInt(paramCursor.getColumnIndex("mTroopFileVideoIsWhite"));
        paramawbv.mTribeStatus = paramCursor.getInt(paramCursor.getColumnIndex("mTribeStatus"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mCanSearchByKeywords"))) {
          break label2273;
        }
        paramBoolean = true;
        label1839:
        paramawbv.mCanSearchByKeywords = paramBoolean;
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
        paramawbv.mCanSearchByTroopUin = paramBoolean;
        paramawbv.dwCmdUinJoinTime = paramCursor.getLong(paramCursor.getColumnIndex("dwCmdUinJoinTime"));
        paramawbv.dwLastInsertBAFTipTime = paramCursor.getLong(paramCursor.getColumnIndex("dwLastInsertBAFTipTime"));
        paramawbv.wInsertBAFTipCount = paramCursor.getInt(paramCursor.getColumnIndex("wInsertBAFTipCount"));
        paramawbv.wClickBAFTipCount = paramCursor.getInt(paramCursor.getColumnIndex("wClickBAFTipCount"));
        paramawbv.dwLastBAFTipMsgUniSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq"));
        paramawbv.dwLastBAFTipMsgUniSeq2 = paramCursor.getLong(paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq2"));
        paramawbv.dailyNewMemberUins = paramCursor.getString(paramCursor.getColumnIndex("dailyNewMemberUins"));
        paramawbv.exitTroopReason = paramCursor.getInt(paramCursor.getColumnIndex("exitTroopReason"));
        paramawbv.eliminated = paramCursor.getInt(paramCursor.getColumnIndex("eliminated"));
        paramawbv.mIsFreezed = paramCursor.getInt(paramCursor.getColumnIndex("mIsFreezed"));
        paramawbv.strLastAnnouncement = paramCursor.getString(paramCursor.getColumnIndex("strLastAnnouncement"));
        paramawbv.nMsgLimitFreq = paramCursor.getInt(paramCursor.getColumnIndex("nMsgLimitFreq"));
        paramawbv.mAtOrReplyMeUins = paramCursor.getString(paramCursor.getColumnIndex("mAtOrReplyMeUins"));
        paramawbv.groupFlagExt4 = paramCursor.getInt(paramCursor.getColumnIndex("groupFlagExt4"));
        paramawbv.groupFreezeReason = paramCursor.getInt(paramCursor.getColumnIndex("groupFreezeReason"));
        paramawbv.troopHonorGrayFlag = paramCursor.getInt(paramCursor.getColumnIndex("troopHonorGrayFlag"));
        paramawbv.isAllowHistoryMsgFlag = paramCursor.getInt(paramCursor.getColumnIndex("isAllowHistoryMsgFlag"));
        paramawbv.troopRepeatType = paramCursor.getInt(paramCursor.getColumnIndex("troopRepeatType"));
        paramawbv.feeds_id = paramCursor.getString(paramCursor.getColumnIndex("feeds_id"));
        paramawbv.myHonorList = paramCursor.getString(paramCursor.getColumnIndex("myHonorList"));
        return paramawbv;
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
      paramawcg.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("timeSec");
      if (i != -1) {
        break label6560;
      }
      paramawcg.a(new NoColumnError("timeSec", Long.TYPE));
      label2353:
      i = paramCursor.getColumnIndex("troopuin");
      if (i != -1) {
        break label6575;
      }
      paramawcg.a(new NoColumnError("troopuin", String.class));
      label2388:
      i = paramCursor.getColumnIndex("troopcode");
      if (i != -1) {
        break label6590;
      }
      paramawcg.a(new NoColumnError("troopcode", String.class));
      label2423:
      i = paramCursor.getColumnIndex("troopowneruin");
      if (i != -1) {
        break label6605;
      }
      paramawcg.a(new NoColumnError("troopowneruin", String.class));
      label2458:
      i = paramCursor.getColumnIndex("troopname");
      if (i != -1) {
        break label6620;
      }
      paramawcg.a(new NoColumnError("troopname", String.class));
      label2493:
      i = paramCursor.getColumnIndex("newTroopName");
      if (i != -1) {
        break label6635;
      }
      paramawcg.a(new NoColumnError("newTroopName", String.class));
      label2528:
      i = paramCursor.getColumnIndex("newTroopNameTimeStamp");
      if (i != -1) {
        break label6650;
      }
      paramawcg.a(new NoColumnError("newTroopNameTimeStamp", Long.TYPE));
      label2563:
      i = paramCursor.getColumnIndex("troopface");
      if (i != -1) {
        break label6665;
      }
      paramawcg.a(new NoColumnError("troopface", Short.TYPE));
      label2598:
      i = paramCursor.getColumnIndex("troopmemo");
      if (i != -1) {
        break label6680;
      }
      paramawcg.a(new NoColumnError("troopmemo", String.class));
      label2633:
      i = paramCursor.getColumnIndex("fingertroopmemo");
      if (i != -1) {
        break label6695;
      }
      paramawcg.a(new NoColumnError("fingertroopmemo", String.class));
      label2668:
      i = paramCursor.getColumnIndex("mRichFingerMemo");
      if (i != -1) {
        break label6710;
      }
      paramawcg.a(new NoColumnError("mRichFingerMemo", String.class));
      label2703:
      i = paramCursor.getColumnIndex("troopmask");
      if (i != -1) {
        break label6725;
      }
      paramawcg.a(new NoColumnError("troopmask", Integer.TYPE));
      label2738:
      i = paramCursor.getColumnIndex("trooptype");
      if (i != -1) {
        break label6740;
      }
      paramawcg.a(new NoColumnError("trooptype", Integer.TYPE));
      label2773:
      i = paramCursor.getColumnIndex("troopCreateTime");
      if (i != -1) {
        break label6755;
      }
      paramawcg.a(new NoColumnError("troopCreateTime", Long.TYPE));
      label2808:
      i = paramCursor.getColumnIndex("dwGroupFlag");
      if (i != -1) {
        break label6770;
      }
      paramawcg.a(new NoColumnError("dwGroupFlag", Long.TYPE));
      label2843:
      i = paramCursor.getColumnIndex("cGroupOption");
      if (i != -1) {
        break label6785;
      }
      paramawcg.a(new NoColumnError("cGroupOption", Short.TYPE));
      label2878:
      i = paramCursor.getColumnIndex("wMemberMax");
      if (i != -1) {
        break label6800;
      }
      paramawcg.a(new NoColumnError("wMemberMax", Integer.TYPE));
      label2913:
      i = paramCursor.getColumnIndex("maxAdminNum");
      if (i != -1) {
        break label6815;
      }
      paramawcg.a(new NoColumnError("maxAdminNum", Integer.TYPE));
      label2948:
      i = paramCursor.getColumnIndex("wSpecialClass");
      if (i != -1) {
        break label6830;
      }
      paramawcg.a(new NoColumnError("wSpecialClass", Integer.TYPE));
      label2983:
      i = paramCursor.getColumnIndex("cGroupLevel");
      if (i != -1) {
        break label6845;
      }
      paramawcg.a(new NoColumnError("cGroupLevel", Short.TYPE));
      label3018:
      i = paramCursor.getColumnIndex("wMemberNum");
      if (i != -1) {
        break label6860;
      }
      paramawcg.a(new NoColumnError("wMemberNum", Integer.TYPE));
      label3053:
      i = paramCursor.getColumnIndex("wMemberNumClient");
      if (i != -1) {
        break label6875;
      }
      paramawcg.a(new NoColumnError("wMemberNumClient", Integer.TYPE));
      label3088:
      i = paramCursor.getColumnIndex("Administrator");
      if (i != -1) {
        break label6890;
      }
      paramawcg.a(new NoColumnError("Administrator", String.class));
      label3123:
      i = paramCursor.getColumnIndex("dwGroupClassExt");
      if (i != -1) {
        break label6905;
      }
      paramawcg.a(new NoColumnError("dwGroupClassExt", Long.TYPE));
      label3158:
      i = paramCursor.getColumnIndex("mGroupClassExtText");
      if (i != -1) {
        break label6920;
      }
      paramawcg.a(new NoColumnError("mGroupClassExtText", String.class));
      label3193:
      i = paramCursor.getColumnIndex("dwGroupFlagExt");
      if (i != -1) {
        break label6935;
      }
      paramawcg.a(new NoColumnError("dwGroupFlagExt", Long.TYPE));
      label3228:
      i = paramCursor.getColumnIndex("dwAuthGroupType");
      if (i != -1) {
        break label6950;
      }
      paramawcg.a(new NoColumnError("dwAuthGroupType", Long.TYPE));
      label3263:
      i = paramCursor.getColumnIndex("troopAuthenticateInfo");
      if (i != -1) {
        break label6965;
      }
      paramawcg.a(new NoColumnError("troopAuthenticateInfo", String.class));
      label3298:
      i = paramCursor.getColumnIndex("dwGroupInfoSeq");
      if (i != -1) {
        break label6980;
      }
      paramawcg.a(new NoColumnError("dwGroupInfoSeq", Long.TYPE));
      label3333:
      i = paramCursor.getColumnIndex("mMemberNumSeq");
      if (i != -1) {
        break label6995;
      }
      paramawcg.a(new NoColumnError("mMemberNumSeq", Long.TYPE));
      label3368:
      i = paramCursor.getColumnIndex("mOldMemberNumSeq");
      if (i != -1) {
        break label7010;
      }
      paramawcg.a(new NoColumnError("mOldMemberNumSeq", Long.TYPE));
      label3403:
      i = paramCursor.getColumnIndex("mMemberCardSeq");
      if (i != -1) {
        break label7025;
      }
      paramawcg.a(new NoColumnError("mMemberCardSeq", Long.TYPE));
      label3438:
      i = paramCursor.getColumnIndex("mOldMemberCardSeq");
      if (i != -1) {
        break label7040;
      }
      paramawcg.a(new NoColumnError("mOldMemberCardSeq", Long.TYPE));
      label3473:
      i = paramCursor.getColumnIndex("dwGroupLevelSeq");
      if (i != -1) {
        break label7055;
      }
      paramawcg.a(new NoColumnError("dwGroupLevelSeq", Long.TYPE));
      label3508:
      i = paramCursor.getColumnIndex("cGroupRankSysFlag");
      if (i != -1) {
        break label7070;
      }
      paramawcg.a(new NoColumnError("cGroupRankSysFlag", Byte.TYPE));
      label3543:
      i = paramCursor.getColumnIndex("cGroupRankUserFlag");
      if (i != -1) {
        break label7086;
      }
      paramawcg.a(new NoColumnError("cGroupRankUserFlag", Byte.TYPE));
      label3578:
      i = paramCursor.getColumnIndex("troopLevelMap");
      if (i != -1) {
        break label7102;
      }
      paramawcg.a(new NoColumnError("troopLevelMap", String.class));
      label3613:
      i = paramCursor.getColumnIndex("joinTroopQuestion");
      if (i != -1) {
        break label7117;
      }
      paramawcg.a(new NoColumnError("joinTroopQuestion", String.class));
      label3648:
      i = paramCursor.getColumnIndex("joinTroopAnswer");
      if (i != -1) {
        break label7132;
      }
      paramawcg.a(new NoColumnError("joinTroopAnswer", String.class));
      label3683:
      i = paramCursor.getColumnIndex("cAlbumResult");
      if (i != -1) {
        break label7147;
      }
      paramawcg.a(new NoColumnError("cAlbumResult", Byte.TYPE));
      label3718:
      i = paramCursor.getColumnIndex("dwTimeStamp");
      if (i != -1) {
        break label7163;
      }
      paramawcg.a(new NoColumnError("dwTimeStamp", Long.TYPE));
      label3753:
      i = paramCursor.getColumnIndex("strQZonePhotoUrls");
      if (i != -1) {
        break label7178;
      }
      paramawcg.a(new NoColumnError("strQZonePhotoUrls", String.class));
      label3788:
      i = paramCursor.getColumnIndex("mQZonePhotoNum");
      if (i != -1) {
        break label7193;
      }
      paramawcg.a(new NoColumnError("mQZonePhotoNum", Integer.TYPE));
      label3823:
      i = paramCursor.getColumnIndex("strLocation");
      if (i != -1) {
        break label7208;
      }
      paramawcg.a(new NoColumnError("strLocation", String.class));
      label3858:
      i = paramCursor.getColumnIndex("troopLat");
      if (i != -1) {
        break label7223;
      }
      paramawcg.a(new NoColumnError("troopLat", Integer.TYPE));
      label3893:
      i = paramCursor.getColumnIndex("troopLon");
      if (i != -1) {
        break label7238;
      }
      paramawcg.a(new NoColumnError("troopLon", Integer.TYPE));
      label3928:
      i = paramCursor.getColumnIndex("mMemberInvitingFlag");
      if (i != -1) {
        break label7253;
      }
      paramawcg.a(new NoColumnError("mMemberInvitingFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label7280;
      }
      paramawcg.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label3998:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label7295;
      }
      paramawcg.a(new NoColumnError("mCompareSpell", String.class));
      label4033:
      i = paramCursor.getColumnIndex("mSomeMemberUins");
      if (i != -1) {
        break label7310;
      }
      paramawcg.a(new NoColumnError("mSomeMemberUins", String.class));
      label4068:
      i = paramCursor.getColumnIndex("mHeaderUinsOld");
      if (i != -1) {
        break label7325;
      }
      paramawcg.a(new NoColumnError("mHeaderUinsOld", String.class));
      label4103:
      i = paramCursor.getColumnIndex("mHeaderUinsNew");
      if (i != -1) {
        break label7340;
      }
      paramawcg.a(new NoColumnError("mHeaderUinsNew", String.class));
      label4138:
      i = paramCursor.getColumnIndex("mTags");
      if (i != -1) {
        break label7355;
      }
      paramawcg.a(new NoColumnError("mTags", String.class));
      label4175:
      i = paramCursor.getColumnIndex("mTroopAvatarId");
      if (i != -1) {
        break label7370;
      }
      paramawcg.a(new NoColumnError("mTroopAvatarId", Integer.TYPE));
      label4212:
      i = paramCursor.getColumnIndex("mTroopPicListJson");
      if (i != -1) {
        break label7385;
      }
      paramawcg.a(new NoColumnError("mTroopPicListJson", String.class));
      label4249:
      i = paramCursor.getColumnIndex("nTroopGrade");
      if (i != -1) {
        break label7400;
      }
      paramawcg.a(new NoColumnError("nTroopGrade", Integer.TYPE));
      label4286:
      i = paramCursor.getColumnIndex("isShowInNearbyTroops");
      if (i != -1) {
        break label7415;
      }
      paramawcg.a(new NoColumnError("isShowInNearbyTroops", Integer.TYPE));
      label4323:
      i = paramCursor.getColumnIndex("dwGagTimeStamp");
      if (i != -1) {
        break label7430;
      }
      paramawcg.a(new NoColumnError("dwGagTimeStamp", Long.TYPE));
      label4360:
      i = paramCursor.getColumnIndex("dwGagTimeStamp_me");
      if (i != -1) {
        break label7445;
      }
      paramawcg.a(new NoColumnError("dwGagTimeStamp_me", Long.TYPE));
      label4397:
      i = paramCursor.getColumnIndex("dwCmdUinUinFlag");
      if (i != -1) {
        break label7460;
      }
      paramawcg.a(new NoColumnError("dwCmdUinUinFlag", Long.TYPE));
      label4434:
      i = paramCursor.getColumnIndex("dwAdditionalFlag");
      if (i != -1) {
        break label7475;
      }
      paramawcg.a(new NoColumnError("dwAdditionalFlag", Long.TYPE));
      label4471:
      i = paramCursor.getColumnIndex("troopTypeExt");
      if (i != -1) {
        break label7490;
      }
      paramawcg.a(new NoColumnError("troopTypeExt", Integer.TYPE));
      label4508:
      i = paramCursor.getColumnIndex("ownerNameShow");
      if (i != -1) {
        break label7505;
      }
      paramawcg.a(new NoColumnError("ownerNameShow", String.class));
      label4545:
      i = paramCursor.getColumnIndex("adminNameShow");
      if (i != -1) {
        break label7520;
      }
      paramawcg.a(new NoColumnError("adminNameShow", String.class));
      label4582:
      i = paramCursor.getColumnIndex("dwOfficeMode");
      if (i != -1) {
        break label7535;
      }
      paramawcg.a(new NoColumnError("dwOfficeMode", Long.TYPE));
      label4619:
      i = paramCursor.getColumnIndex("dwGroupFlagExt3");
      if (i != -1) {
        break label7550;
      }
      paramawcg.a(new NoColumnError("dwGroupFlagExt3", Long.TYPE));
      label4656:
      i = paramCursor.getColumnIndex("cmdUinFlagEx2");
      if (i != -1) {
        break label7565;
      }
      paramawcg.a(new NoColumnError("cmdUinFlagEx2", Long.TYPE));
      label4693:
      i = paramCursor.getColumnIndex("udwCmdUinRingtoneID");
      if (i != -1) {
        break label7580;
      }
      paramawcg.a(new NoColumnError("udwCmdUinRingtoneID", Long.TYPE));
      label4730:
      i = paramCursor.getColumnIndex("memberListToShow");
      if (i != -1) {
        break label7595;
      }
      paramawcg.a(new NoColumnError("memberListToShow", String.class));
      label4767:
      i = paramCursor.getColumnIndex("troopPrivilegeFlag");
      if (i != -1) {
        break label7610;
      }
      paramawcg.a(new NoColumnError("troopPrivilegeFlag", Long.TYPE));
      label4804:
      i = paramCursor.getColumnIndex("isNewTroop");
      if (i != -1) {
        break label7625;
      }
      paramawcg.a(new NoColumnError("isNewTroop", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasSetNewTroopHead");
      if (i != -1) {
        break label7652;
      }
      paramawcg.a(new NoColumnError("hasSetNewTroopHead", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasSetNewTroopName");
      if (i != -1) {
        break label7679;
      }
      paramawcg.a(new NoColumnError("hasSetNewTroopName", Boolean.TYPE));
      i = paramCursor.getColumnIndex("maxInviteMemNum");
      if (i != -1) {
        break label7706;
      }
      paramawcg.a(new NoColumnError("maxInviteMemNum", Integer.TYPE));
      label4952:
      i = paramCursor.getColumnIndex("lastMsgTime");
      if (i != -1) {
        break label7721;
      }
      paramawcg.a(new NoColumnError("lastMsgTime", Long.TYPE));
      label4989:
      i = paramCursor.getColumnIndex("allowMemberModifTroopName");
      if (i != -1) {
        break label7736;
      }
      paramawcg.a(new NoColumnError("allowMemberModifTroopName", Integer.TYPE));
      label5026:
      i = paramCursor.getColumnIndex("allowMemberKick");
      if (i != -1) {
        break label7751;
      }
      paramawcg.a(new NoColumnError("allowMemberKick", Integer.TYPE));
      label5063:
      i = paramCursor.getColumnIndex("allowMemberAtAll");
      if (i != -1) {
        break label7766;
      }
      paramawcg.a(new NoColumnError("allowMemberAtAll", Integer.TYPE));
      label5100:
      i = paramCursor.getColumnIndex("oldTroopName");
      if (i != -1) {
        break label7781;
      }
      paramawcg.a(new NoColumnError("oldTroopName", String.class));
      label5137:
      i = paramCursor.getColumnIndex("hlGuildAppid");
      if (i != -1) {
        break label7796;
      }
      paramawcg.a(new NoColumnError("hlGuildAppid", Long.TYPE));
      label5174:
      i = paramCursor.getColumnIndex("hlGuildSubType");
      if (i != -1) {
        break label7811;
      }
      paramawcg.a(new NoColumnError("hlGuildSubType", Long.TYPE));
      label5211:
      i = paramCursor.getColumnIndex("hlGuildOrgid");
      if (i != -1) {
        break label7826;
      }
      paramawcg.a(new NoColumnError("hlGuildOrgid", Integer.TYPE));
      label5248:
      i = paramCursor.getColumnIndex("hlGuildBinary");
      if (i != -1) {
        break label7841;
      }
      paramawcg.a(new NoColumnError("hlGuildBinary", Integer.TYPE));
      label5285:
      i = paramCursor.getColumnIndex("gameSwitchStatus");
      if (i != -1) {
        break label7856;
      }
      paramawcg.a(new NoColumnError("gameSwitchStatus", Integer.TYPE));
      label5322:
      i = paramCursor.getColumnIndex("showGameSwitchStatus");
      if (i != -1) {
        break label7871;
      }
      paramawcg.a(new NoColumnError("showGameSwitchStatus", Integer.TYPE));
      label5359:
      i = paramCursor.getColumnIndex("lastShareLbsMsgUniseq");
      if (i != -1) {
        break label7886;
      }
      paramawcg.a(new NoColumnError("lastShareLbsMsgUniseq", Long.TYPE));
      label5396:
      i = paramCursor.getColumnIndex("mTroopNeedPayNumber");
      if (i != -1) {
        break label7901;
      }
      paramawcg.a(new NoColumnError("mTroopNeedPayNumber", Float.TYPE));
      label5433:
      i = paramCursor.getColumnIndex("troopCreditLevel");
      if (i != -1) {
        break label7916;
      }
      paramawcg.a(new NoColumnError("troopCreditLevel", Long.TYPE));
      label5470:
      i = paramCursor.getColumnIndex("troopCreditLevelInfo");
      if (i != -1) {
        break label7931;
      }
      paramawcg.a(new NoColumnError("troopCreditLevelInfo", Long.TYPE));
      label5507:
      i = paramCursor.getColumnIndex("dwAppPrivilegeFlag");
      if (i != -1) {
        break label7946;
      }
      paramawcg.a(new NoColumnError("dwAppPrivilegeFlag", Long.TYPE));
      label5544:
      i = paramCursor.getColumnIndex("topicId");
      if (i != -1) {
        break label7961;
      }
      paramawcg.a(new NoColumnError("topicId", String.class));
      label5581:
      i = paramCursor.getColumnIndex("associatePubAccount");
      if (i != -1) {
        break label7976;
      }
      paramawcg.a(new NoColumnError("associatePubAccount", Long.TYPE));
      label5618:
      i = paramCursor.getColumnIndex("mTroopFileVideoReqInterval");
      if (i != -1) {
        break label7991;
      }
      paramawcg.a(new NoColumnError("mTroopFileVideoReqInterval", Long.TYPE));
      label5655:
      i = paramCursor.getColumnIndex("mTroopFileVideoIsWhite");
      if (i != -1) {
        break label8006;
      }
      paramawcg.a(new NoColumnError("mTroopFileVideoIsWhite", Integer.TYPE));
      label5692:
      i = paramCursor.getColumnIndex("mTribeStatus");
      if (i != -1) {
        break label8021;
      }
      paramawcg.a(new NoColumnError("mTribeStatus", Integer.TYPE));
      label5729:
      i = paramCursor.getColumnIndex("mCanSearchByKeywords");
      if (i != -1) {
        break label8036;
      }
      paramawcg.a(new NoColumnError("mCanSearchByKeywords", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mCanSearchByTroopUin");
      if (i != -1) {
        break label8063;
      }
      paramawcg.a(new NoColumnError("mCanSearchByTroopUin", Boolean.TYPE));
      i = paramCursor.getColumnIndex("dwCmdUinJoinTime");
      if (i != -1) {
        break label8091;
      }
      paramawcg.a(new NoColumnError("dwCmdUinJoinTime", Long.TYPE));
      label5840:
      i = paramCursor.getColumnIndex("dwLastInsertBAFTipTime");
      if (i != -1) {
        break label8106;
      }
      paramawcg.a(new NoColumnError("dwLastInsertBAFTipTime", Long.TYPE));
      label5877:
      i = paramCursor.getColumnIndex("wInsertBAFTipCount");
      if (i != -1) {
        break label8121;
      }
      paramawcg.a(new NoColumnError("wInsertBAFTipCount", Integer.TYPE));
      label5914:
      i = paramCursor.getColumnIndex("wClickBAFTipCount");
      if (i != -1) {
        break label8136;
      }
      paramawcg.a(new NoColumnError("wClickBAFTipCount", Integer.TYPE));
      label5951:
      i = paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq");
      if (i != -1) {
        break label8151;
      }
      paramawcg.a(new NoColumnError("dwLastBAFTipMsgUniSeq", Long.TYPE));
      label5988:
      i = paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq2");
      if (i != -1) {
        break label8166;
      }
      paramawcg.a(new NoColumnError("dwLastBAFTipMsgUniSeq2", Long.TYPE));
      label6025:
      i = paramCursor.getColumnIndex("dailyNewMemberUins");
      if (i != -1) {
        break label8181;
      }
      paramawcg.a(new NoColumnError("dailyNewMemberUins", String.class));
      label6062:
      i = paramCursor.getColumnIndex("exitTroopReason");
      if (i != -1) {
        break label8196;
      }
      paramawcg.a(new NoColumnError("exitTroopReason", Integer.TYPE));
      label6099:
      i = paramCursor.getColumnIndex("eliminated");
      if (i != -1) {
        break label8211;
      }
      paramawcg.a(new NoColumnError("eliminated", Integer.TYPE));
      label6136:
      i = paramCursor.getColumnIndex("mIsFreezed");
      if (i != -1) {
        break label8226;
      }
      paramawcg.a(new NoColumnError("mIsFreezed", Integer.TYPE));
      label6173:
      i = paramCursor.getColumnIndex("strLastAnnouncement");
      if (i != -1) {
        break label8241;
      }
      paramawcg.a(new NoColumnError("strLastAnnouncement", String.class));
      label6210:
      i = paramCursor.getColumnIndex("nMsgLimitFreq");
      if (i != -1) {
        break label8256;
      }
      paramawcg.a(new NoColumnError("nMsgLimitFreq", Integer.TYPE));
      label6247:
      i = paramCursor.getColumnIndex("mAtOrReplyMeUins");
      if (i != -1) {
        break label8271;
      }
      paramawcg.a(new NoColumnError("mAtOrReplyMeUins", String.class));
      label6284:
      i = paramCursor.getColumnIndex("groupFlagExt4");
      if (i != -1) {
        break label8286;
      }
      paramawcg.a(new NoColumnError("groupFlagExt4", Integer.TYPE));
      label6321:
      i = paramCursor.getColumnIndex("groupFreezeReason");
      if (i != -1) {
        break label8301;
      }
      paramawcg.a(new NoColumnError("groupFreezeReason", Integer.TYPE));
      label6358:
      i = paramCursor.getColumnIndex("troopHonorGrayFlag");
      if (i != -1) {
        break label8316;
      }
      paramawcg.a(new NoColumnError("troopHonorGrayFlag", Integer.TYPE));
      label6395:
      i = paramCursor.getColumnIndex("isAllowHistoryMsgFlag");
      if (i != -1) {
        break label8331;
      }
      paramawcg.a(new NoColumnError("isAllowHistoryMsgFlag", Integer.TYPE));
      label6432:
      i = paramCursor.getColumnIndex("troopRepeatType");
      if (i != -1) {
        break label8346;
      }
      paramawcg.a(new NoColumnError("troopRepeatType", Integer.TYPE));
      label6469:
      i = paramCursor.getColumnIndex("feeds_id");
      if (i != -1) {
        break label8361;
      }
      paramawcg.a(new NoColumnError("feeds_id", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("myHonorList");
      if (i != -1) {
        break label8376;
      }
      paramawcg.a(new NoColumnError("myHonorList", String.class));
      return paramawbv;
      paramawbv.uin = paramCursor.getString(i);
      break;
      label6560:
      paramawbv.timeSec = paramCursor.getLong(i);
      break label2353;
      label6575:
      paramawbv.troopuin = paramCursor.getString(i);
      break label2388;
      label6590:
      paramawbv.troopcode = paramCursor.getString(i);
      break label2423;
      label6605:
      paramawbv.troopowneruin = paramCursor.getString(i);
      break label2458;
      label6620:
      paramawbv.troopname = paramCursor.getString(i);
      break label2493;
      label6635:
      paramawbv.newTroopName = paramCursor.getString(i);
      break label2528;
      label6650:
      paramawbv.newTroopNameTimeStamp = paramCursor.getLong(i);
      break label2563;
      label6665:
      paramawbv.troopface = paramCursor.getShort(i);
      break label2598;
      label6680:
      paramawbv.troopmemo = paramCursor.getString(i);
      break label2633;
      label6695:
      paramawbv.fingertroopmemo = paramCursor.getString(i);
      break label2668;
      label6710:
      paramawbv.mRichFingerMemo = paramCursor.getString(i);
      break label2703;
      label6725:
      paramawbv.troopmask = paramCursor.getInt(i);
      break label2738;
      label6740:
      paramawbv.trooptype = paramCursor.getInt(i);
      break label2773;
      label6755:
      paramawbv.troopCreateTime = paramCursor.getLong(i);
      break label2808;
      label6770:
      paramawbv.dwGroupFlag = paramCursor.getLong(i);
      break label2843;
      label6785:
      paramawbv.cGroupOption = paramCursor.getShort(i);
      break label2878;
      label6800:
      paramawbv.wMemberMax = paramCursor.getInt(i);
      break label2913;
      label6815:
      paramawbv.maxAdminNum = paramCursor.getInt(i);
      break label2948;
      label6830:
      paramawbv.wSpecialClass = paramCursor.getInt(i);
      break label2983;
      label6845:
      paramawbv.cGroupLevel = paramCursor.getShort(i);
      break label3018;
      label6860:
      paramawbv.wMemberNum = paramCursor.getInt(i);
      break label3053;
      label6875:
      paramawbv.wMemberNumClient = paramCursor.getInt(i);
      break label3088;
      label6890:
      paramawbv.Administrator = paramCursor.getString(i);
      break label3123;
      label6905:
      paramawbv.dwGroupClassExt = paramCursor.getLong(i);
      break label3158;
      label6920:
      paramawbv.mGroupClassExtText = paramCursor.getString(i);
      break label3193;
      label6935:
      paramawbv.dwGroupFlagExt = paramCursor.getLong(i);
      break label3228;
      label6950:
      paramawbv.dwAuthGroupType = paramCursor.getLong(i);
      break label3263;
      label6965:
      paramawbv.troopAuthenticateInfo = paramCursor.getString(i);
      break label3298;
      label6980:
      paramawbv.dwGroupInfoSeq = paramCursor.getLong(i);
      break label3333;
      label6995:
      paramawbv.mMemberNumSeq = paramCursor.getLong(i);
      break label3368;
      label7010:
      paramawbv.mOldMemberNumSeq = paramCursor.getLong(i);
      break label3403;
      label7025:
      paramawbv.mMemberCardSeq = paramCursor.getLong(i);
      break label3438;
      label7040:
      paramawbv.mOldMemberCardSeq = paramCursor.getLong(i);
      break label3473;
      label7055:
      paramawbv.dwGroupLevelSeq = paramCursor.getLong(i);
      break label3508;
      label7070:
      paramawbv.cGroupRankSysFlag = ((byte)paramCursor.getShort(i));
      break label3543;
      label7086:
      paramawbv.cGroupRankUserFlag = ((byte)paramCursor.getShort(i));
      break label3578;
      label7102:
      paramawbv.troopLevelMap = paramCursor.getString(i);
      break label3613;
      label7117:
      paramawbv.joinTroopQuestion = paramCursor.getString(i);
      break label3648;
      label7132:
      paramawbv.joinTroopAnswer = paramCursor.getString(i);
      break label3683;
      label7147:
      paramawbv.cAlbumResult = ((byte)paramCursor.getShort(i));
      break label3718;
      label7163:
      paramawbv.dwTimeStamp = paramCursor.getLong(i);
      break label3753;
      label7178:
      paramawbv.strQZonePhotoUrls = paramCursor.getString(i);
      break label3788;
      label7193:
      paramawbv.mQZonePhotoNum = paramCursor.getInt(i);
      break label3823;
      label7208:
      paramawbv.strLocation = paramCursor.getString(i);
      break label3858;
      label7223:
      paramawbv.troopLat = paramCursor.getInt(i);
      break label3893;
      label7238:
      paramawbv.troopLon = paramCursor.getInt(i);
      break label3928;
      label7253:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.mMemberInvitingFlag = paramBoolean;
        break;
      }
      label7280:
      paramawbv.mComparePartInt = paramCursor.getInt(i);
      break label3998;
      label7295:
      paramawbv.mCompareSpell = paramCursor.getString(i);
      break label4033;
      label7310:
      paramawbv.mSomeMemberUins = paramCursor.getString(i);
      break label4068;
      label7325:
      paramawbv.mHeaderUinsOld = paramCursor.getString(i);
      break label4103;
      label7340:
      paramawbv.mHeaderUinsNew = paramCursor.getString(i);
      break label4138;
      label7355:
      paramawbv.mTags = paramCursor.getString(i);
      break label4175;
      label7370:
      paramawbv.mTroopAvatarId = paramCursor.getInt(i);
      break label4212;
      label7385:
      paramawbv.mTroopPicListJson = paramCursor.getString(i);
      break label4249;
      label7400:
      paramawbv.nTroopGrade = paramCursor.getInt(i);
      break label4286;
      label7415:
      paramawbv.isShowInNearbyTroops = paramCursor.getInt(i);
      break label4323;
      label7430:
      paramawbv.dwGagTimeStamp = paramCursor.getLong(i);
      break label4360;
      label7445:
      paramawbv.dwGagTimeStamp_me = paramCursor.getLong(i);
      break label4397;
      label7460:
      paramawbv.dwCmdUinUinFlag = paramCursor.getLong(i);
      break label4434;
      label7475:
      paramawbv.dwAdditionalFlag = paramCursor.getLong(i);
      break label4471;
      label7490:
      paramawbv.troopTypeExt = paramCursor.getInt(i);
      break label4508;
      label7505:
      paramawbv.ownerNameShow = paramCursor.getString(i);
      break label4545;
      label7520:
      paramawbv.adminNameShow = paramCursor.getString(i);
      break label4582;
      label7535:
      paramawbv.dwOfficeMode = paramCursor.getLong(i);
      break label4619;
      label7550:
      paramawbv.dwGroupFlagExt3 = paramCursor.getLong(i);
      break label4656;
      label7565:
      paramawbv.cmdUinFlagEx2 = paramCursor.getLong(i);
      break label4693;
      label7580:
      paramawbv.udwCmdUinRingtoneID = paramCursor.getLong(i);
      break label4730;
      label7595:
      paramawbv.memberListToShow = paramCursor.getString(i);
      break label4767;
      label7610:
      paramawbv.troopPrivilegeFlag = paramCursor.getLong(i);
      break label4804;
      label7625:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isNewTroop = paramBoolean;
        break;
      }
      label7652:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.hasSetNewTroopHead = paramBoolean;
        break;
      }
      label7679:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.hasSetNewTroopName = paramBoolean;
        break;
      }
      label7706:
      paramawbv.maxInviteMemNum = paramCursor.getInt(i);
      break label4952;
      label7721:
      paramawbv.lastMsgTime = paramCursor.getLong(i);
      break label4989;
      label7736:
      paramawbv.allowMemberModifTroopName = paramCursor.getInt(i);
      break label5026;
      label7751:
      paramawbv.allowMemberKick = paramCursor.getInt(i);
      break label5063;
      label7766:
      paramawbv.allowMemberAtAll = paramCursor.getInt(i);
      break label5100;
      label7781:
      paramawbv.oldTroopName = paramCursor.getString(i);
      break label5137;
      label7796:
      paramawbv.hlGuildAppid = paramCursor.getLong(i);
      break label5174;
      label7811:
      paramawbv.hlGuildSubType = paramCursor.getLong(i);
      break label5211;
      label7826:
      paramawbv.hlGuildOrgid = paramCursor.getInt(i);
      break label5248;
      label7841:
      paramawbv.hlGuildBinary = paramCursor.getInt(i);
      break label5285;
      label7856:
      paramawbv.gameSwitchStatus = paramCursor.getInt(i);
      break label5322;
      label7871:
      paramawbv.showGameSwitchStatus = paramCursor.getInt(i);
      break label5359;
      label7886:
      paramawbv.lastShareLbsMsgUniseq = paramCursor.getLong(i);
      break label5396;
      label7901:
      paramawbv.mTroopNeedPayNumber = paramCursor.getFloat(i);
      break label5433;
      label7916:
      paramawbv.troopCreditLevel = paramCursor.getLong(i);
      break label5470;
      label7931:
      paramawbv.troopCreditLevelInfo = paramCursor.getLong(i);
      break label5507;
      label7946:
      paramawbv.dwAppPrivilegeFlag = paramCursor.getLong(i);
      break label5544;
      label7961:
      paramawbv.topicId = paramCursor.getString(i);
      break label5581;
      label7976:
      paramawbv.associatePubAccount = paramCursor.getLong(i);
      break label5618;
      label7991:
      paramawbv.mTroopFileVideoReqInterval = paramCursor.getLong(i);
      break label5655;
      label8006:
      paramawbv.mTroopFileVideoIsWhite = paramCursor.getInt(i);
      break label5692;
      label8021:
      paramawbv.mTribeStatus = paramCursor.getInt(i);
      break label5729;
      label8036:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.mCanSearchByKeywords = paramBoolean;
        break;
      }
      label8063:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramawbv.mCanSearchByTroopUin = paramBoolean;
        break;
      }
      label8091:
      paramawbv.dwCmdUinJoinTime = paramCursor.getLong(i);
      break label5840;
      label8106:
      paramawbv.dwLastInsertBAFTipTime = paramCursor.getLong(i);
      break label5877;
      label8121:
      paramawbv.wInsertBAFTipCount = paramCursor.getInt(i);
      break label5914;
      label8136:
      paramawbv.wClickBAFTipCount = paramCursor.getInt(i);
      break label5951;
      label8151:
      paramawbv.dwLastBAFTipMsgUniSeq = paramCursor.getLong(i);
      break label5988;
      label8166:
      paramawbv.dwLastBAFTipMsgUniSeq2 = paramCursor.getLong(i);
      break label6025;
      label8181:
      paramawbv.dailyNewMemberUins = paramCursor.getString(i);
      break label6062;
      label8196:
      paramawbv.exitTroopReason = paramCursor.getInt(i);
      break label6099;
      label8211:
      paramawbv.eliminated = paramCursor.getInt(i);
      break label6136;
      label8226:
      paramawbv.mIsFreezed = paramCursor.getInt(i);
      break label6173;
      label8241:
      paramawbv.strLastAnnouncement = paramCursor.getString(i);
      break label6210;
      label8256:
      paramawbv.nMsgLimitFreq = paramCursor.getInt(i);
      break label6247;
      label8271:
      paramawbv.mAtOrReplyMeUins = paramCursor.getString(i);
      break label6284;
      label8286:
      paramawbv.groupFlagExt4 = paramCursor.getInt(i);
      break label6321;
      label8301:
      paramawbv.groupFreezeReason = paramCursor.getInt(i);
      break label6358;
      label8316:
      paramawbv.troopHonorGrayFlag = paramCursor.getInt(i);
      break label6395;
      label8331:
      paramawbv.isAllowHistoryMsgFlag = paramCursor.getInt(i);
      break label6432;
      label8346:
      paramawbv.troopRepeatType = paramCursor.getInt(i);
      break label6469;
      label8361:
      paramawbv.feeds_id = paramCursor.getString(i);
    }
    label8376:
    paramawbv.myHonorList = paramCursor.getString(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,timeSec INTEGER ,troopuin TEXT UNIQUE ,troopcode TEXT ,troopowneruin TEXT ,troopname TEXT ,newTroopName TEXT ,newTroopNameTimeStamp INTEGER ,troopface INTEGER ,troopmemo TEXT ,fingertroopmemo TEXT ,mRichFingerMemo TEXT ,troopmask INTEGER ,trooptype INTEGER ,troopCreateTime INTEGER ,dwGroupFlag INTEGER ,cGroupOption INTEGER ,wMemberMax INTEGER ,maxAdminNum INTEGER ,wSpecialClass INTEGER ,cGroupLevel INTEGER ,wMemberNum INTEGER ,wMemberNumClient INTEGER ,Administrator TEXT ,dwGroupClassExt INTEGER ,mGroupClassExtText TEXT ,dwGroupFlagExt INTEGER ,dwAuthGroupType INTEGER ,troopAuthenticateInfo TEXT ,dwGroupInfoSeq INTEGER ,mMemberNumSeq INTEGER ,mOldMemberNumSeq INTEGER ,mMemberCardSeq INTEGER ,mOldMemberCardSeq INTEGER ,dwGroupLevelSeq INTEGER ,cGroupRankSysFlag INTEGER ,cGroupRankUserFlag INTEGER ,troopLevelMap TEXT ,joinTroopQuestion TEXT ,joinTroopAnswer TEXT ,cAlbumResult INTEGER ,dwTimeStamp INTEGER ,strQZonePhotoUrls TEXT ,mQZonePhotoNum INTEGER ,strLocation TEXT ,troopLat INTEGER ,troopLon INTEGER ,mMemberInvitingFlag INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,mSomeMemberUins TEXT ,mHeaderUinsOld TEXT ,mHeaderUinsNew TEXT ,mTags TEXT ,mTroopAvatarId INTEGER ,mTroopPicListJson TEXT ,nTroopGrade INTEGER ,isShowInNearbyTroops INTEGER ,dwGagTimeStamp INTEGER ,dwGagTimeStamp_me INTEGER ,dwCmdUinUinFlag INTEGER ,dwAdditionalFlag INTEGER ,troopTypeExt INTEGER ,ownerNameShow TEXT ,adminNameShow TEXT ,dwOfficeMode INTEGER ,dwGroupFlagExt3 INTEGER ,cmdUinFlagEx2 INTEGER ,udwCmdUinRingtoneID INTEGER ,memberListToShow TEXT ,troopPrivilegeFlag INTEGER ,isNewTroop INTEGER ,hasSetNewTroopHead INTEGER ,hasSetNewTroopName INTEGER ,maxInviteMemNum INTEGER ,lastMsgTime INTEGER ,allowMemberModifTroopName INTEGER ,allowMemberKick INTEGER ,allowMemberAtAll INTEGER ,oldTroopName TEXT ,hlGuildAppid INTEGER ,hlGuildSubType INTEGER ,hlGuildOrgid INTEGER ,hlGuildBinary INTEGER ,gameSwitchStatus INTEGER ,showGameSwitchStatus INTEGER ,lastShareLbsMsgUniseq INTEGER ,mTroopNeedPayNumber REAL ,troopCreditLevel INTEGER ,troopCreditLevelInfo INTEGER ,dwAppPrivilegeFlag INTEGER ,topicId TEXT ,associatePubAccount INTEGER ,mTroopFileVideoReqInterval INTEGER ,mTroopFileVideoIsWhite INTEGER ,mTribeStatus INTEGER ,mCanSearchByKeywords INTEGER ,mCanSearchByTroopUin INTEGER ,dwCmdUinJoinTime INTEGER ,dwLastInsertBAFTipTime INTEGER ,wInsertBAFTipCount INTEGER ,wClickBAFTipCount INTEGER ,dwLastBAFTipMsgUniSeq INTEGER ,dwLastBAFTipMsgUniSeq2 INTEGER ,dailyNewMemberUins TEXT ,exitTroopReason INTEGER ,eliminated INTEGER ,mIsFreezed INTEGER ,strLastAnnouncement TEXT ,nMsgLimitFreq INTEGER ,mAtOrReplyMeUins TEXT ,groupFlagExt4 INTEGER ,groupFreezeReason INTEGER ,troopHonorGrayFlag INTEGER ,isAllowHistoryMsgFlag INTEGER ,troopRepeatType INTEGER ,feeds_id TEXT ,myHonorList TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (TroopInfo)paramawbv;
    paramContentValues.put("uin", paramawbv.uin);
    paramContentValues.put("timeSec", Long.valueOf(paramawbv.timeSec));
    paramContentValues.put("troopuin", paramawbv.troopuin);
    paramContentValues.put("troopcode", paramawbv.troopcode);
    paramContentValues.put("troopowneruin", paramawbv.troopowneruin);
    paramContentValues.put("troopname", paramawbv.troopname);
    paramContentValues.put("newTroopName", paramawbv.newTroopName);
    paramContentValues.put("newTroopNameTimeStamp", Long.valueOf(paramawbv.newTroopNameTimeStamp));
    paramContentValues.put("troopface", Short.valueOf(paramawbv.troopface));
    paramContentValues.put("troopmemo", paramawbv.troopmemo);
    paramContentValues.put("fingertroopmemo", paramawbv.fingertroopmemo);
    paramContentValues.put("mRichFingerMemo", paramawbv.mRichFingerMemo);
    paramContentValues.put("troopmask", Integer.valueOf(paramawbv.troopmask));
    paramContentValues.put("trooptype", Integer.valueOf(paramawbv.trooptype));
    paramContentValues.put("troopCreateTime", Long.valueOf(paramawbv.troopCreateTime));
    paramContentValues.put("dwGroupFlag", Long.valueOf(paramawbv.dwGroupFlag));
    paramContentValues.put("cGroupOption", Short.valueOf(paramawbv.cGroupOption));
    paramContentValues.put("wMemberMax", Integer.valueOf(paramawbv.wMemberMax));
    paramContentValues.put("maxAdminNum", Integer.valueOf(paramawbv.maxAdminNum));
    paramContentValues.put("wSpecialClass", Integer.valueOf(paramawbv.wSpecialClass));
    paramContentValues.put("cGroupLevel", Short.valueOf(paramawbv.cGroupLevel));
    paramContentValues.put("wMemberNum", Integer.valueOf(paramawbv.wMemberNum));
    paramContentValues.put("wMemberNumClient", Integer.valueOf(paramawbv.wMemberNumClient));
    paramContentValues.put("Administrator", paramawbv.Administrator);
    paramContentValues.put("dwGroupClassExt", Long.valueOf(paramawbv.dwGroupClassExt));
    paramContentValues.put("mGroupClassExtText", paramawbv.mGroupClassExtText);
    paramContentValues.put("dwGroupFlagExt", Long.valueOf(paramawbv.dwGroupFlagExt));
    paramContentValues.put("dwAuthGroupType", Long.valueOf(paramawbv.dwAuthGroupType));
    paramContentValues.put("troopAuthenticateInfo", paramawbv.troopAuthenticateInfo);
    paramContentValues.put("dwGroupInfoSeq", Long.valueOf(paramawbv.dwGroupInfoSeq));
    paramContentValues.put("mMemberNumSeq", Long.valueOf(paramawbv.mMemberNumSeq));
    paramContentValues.put("mOldMemberNumSeq", Long.valueOf(paramawbv.mOldMemberNumSeq));
    paramContentValues.put("mMemberCardSeq", Long.valueOf(paramawbv.mMemberCardSeq));
    paramContentValues.put("mOldMemberCardSeq", Long.valueOf(paramawbv.mOldMemberCardSeq));
    paramContentValues.put("dwGroupLevelSeq", Long.valueOf(paramawbv.dwGroupLevelSeq));
    paramContentValues.put("cGroupRankSysFlag", Byte.valueOf(paramawbv.cGroupRankSysFlag));
    paramContentValues.put("cGroupRankUserFlag", Byte.valueOf(paramawbv.cGroupRankUserFlag));
    paramContentValues.put("troopLevelMap", paramawbv.troopLevelMap);
    paramContentValues.put("joinTroopQuestion", paramawbv.joinTroopQuestion);
    paramContentValues.put("joinTroopAnswer", paramawbv.joinTroopAnswer);
    paramContentValues.put("cAlbumResult", Byte.valueOf(paramawbv.cAlbumResult));
    paramContentValues.put("dwTimeStamp", Long.valueOf(paramawbv.dwTimeStamp));
    paramContentValues.put("strQZonePhotoUrls", paramawbv.strQZonePhotoUrls);
    paramContentValues.put("mQZonePhotoNum", Integer.valueOf(paramawbv.mQZonePhotoNum));
    paramContentValues.put("strLocation", paramawbv.strLocation);
    paramContentValues.put("troopLat", Integer.valueOf(paramawbv.troopLat));
    paramContentValues.put("troopLon", Integer.valueOf(paramawbv.troopLon));
    paramContentValues.put("mMemberInvitingFlag", Boolean.valueOf(paramawbv.mMemberInvitingFlag));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramawbv.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramawbv.mCompareSpell);
    paramContentValues.put("mSomeMemberUins", paramawbv.mSomeMemberUins);
    paramContentValues.put("mHeaderUinsOld", paramawbv.mHeaderUinsOld);
    paramContentValues.put("mHeaderUinsNew", paramawbv.mHeaderUinsNew);
    paramContentValues.put("mTags", paramawbv.mTags);
    paramContentValues.put("mTroopAvatarId", Integer.valueOf(paramawbv.mTroopAvatarId));
    paramContentValues.put("mTroopPicListJson", paramawbv.mTroopPicListJson);
    paramContentValues.put("nTroopGrade", Integer.valueOf(paramawbv.nTroopGrade));
    paramContentValues.put("isShowInNearbyTroops", Integer.valueOf(paramawbv.isShowInNearbyTroops));
    paramContentValues.put("dwGagTimeStamp", Long.valueOf(paramawbv.dwGagTimeStamp));
    paramContentValues.put("dwGagTimeStamp_me", Long.valueOf(paramawbv.dwGagTimeStamp_me));
    paramContentValues.put("dwCmdUinUinFlag", Long.valueOf(paramawbv.dwCmdUinUinFlag));
    paramContentValues.put("dwAdditionalFlag", Long.valueOf(paramawbv.dwAdditionalFlag));
    paramContentValues.put("troopTypeExt", Integer.valueOf(paramawbv.troopTypeExt));
    paramContentValues.put("ownerNameShow", paramawbv.ownerNameShow);
    paramContentValues.put("adminNameShow", paramawbv.adminNameShow);
    paramContentValues.put("dwOfficeMode", Long.valueOf(paramawbv.dwOfficeMode));
    paramContentValues.put("dwGroupFlagExt3", Long.valueOf(paramawbv.dwGroupFlagExt3));
    paramContentValues.put("cmdUinFlagEx2", Long.valueOf(paramawbv.cmdUinFlagEx2));
    paramContentValues.put("udwCmdUinRingtoneID", Long.valueOf(paramawbv.udwCmdUinRingtoneID));
    paramContentValues.put("memberListToShow", paramawbv.memberListToShow);
    paramContentValues.put("troopPrivilegeFlag", Long.valueOf(paramawbv.troopPrivilegeFlag));
    paramContentValues.put("isNewTroop", Boolean.valueOf(paramawbv.isNewTroop));
    paramContentValues.put("hasSetNewTroopHead", Boolean.valueOf(paramawbv.hasSetNewTroopHead));
    paramContentValues.put("hasSetNewTroopName", Boolean.valueOf(paramawbv.hasSetNewTroopName));
    paramContentValues.put("maxInviteMemNum", Integer.valueOf(paramawbv.maxInviteMemNum));
    paramContentValues.put("lastMsgTime", Long.valueOf(paramawbv.lastMsgTime));
    paramContentValues.put("allowMemberModifTroopName", Integer.valueOf(paramawbv.allowMemberModifTroopName));
    paramContentValues.put("allowMemberKick", Integer.valueOf(paramawbv.allowMemberKick));
    paramContentValues.put("allowMemberAtAll", Integer.valueOf(paramawbv.allowMemberAtAll));
    paramContentValues.put("oldTroopName", paramawbv.oldTroopName);
    paramContentValues.put("hlGuildAppid", Long.valueOf(paramawbv.hlGuildAppid));
    paramContentValues.put("hlGuildSubType", Long.valueOf(paramawbv.hlGuildSubType));
    paramContentValues.put("hlGuildOrgid", Integer.valueOf(paramawbv.hlGuildOrgid));
    paramContentValues.put("hlGuildBinary", Integer.valueOf(paramawbv.hlGuildBinary));
    paramContentValues.put("gameSwitchStatus", Integer.valueOf(paramawbv.gameSwitchStatus));
    paramContentValues.put("showGameSwitchStatus", Integer.valueOf(paramawbv.showGameSwitchStatus));
    paramContentValues.put("lastShareLbsMsgUniseq", Long.valueOf(paramawbv.lastShareLbsMsgUniseq));
    paramContentValues.put("mTroopNeedPayNumber", Float.valueOf(paramawbv.mTroopNeedPayNumber));
    paramContentValues.put("troopCreditLevel", Long.valueOf(paramawbv.troopCreditLevel));
    paramContentValues.put("troopCreditLevelInfo", Long.valueOf(paramawbv.troopCreditLevelInfo));
    paramContentValues.put("dwAppPrivilegeFlag", Long.valueOf(paramawbv.dwAppPrivilegeFlag));
    paramContentValues.put("topicId", paramawbv.topicId);
    paramContentValues.put("associatePubAccount", Long.valueOf(paramawbv.associatePubAccount));
    paramContentValues.put("mTroopFileVideoReqInterval", Long.valueOf(paramawbv.mTroopFileVideoReqInterval));
    paramContentValues.put("mTroopFileVideoIsWhite", Integer.valueOf(paramawbv.mTroopFileVideoIsWhite));
    paramContentValues.put("mTribeStatus", Integer.valueOf(paramawbv.mTribeStatus));
    paramContentValues.put("mCanSearchByKeywords", Boolean.valueOf(paramawbv.mCanSearchByKeywords));
    paramContentValues.put("mCanSearchByTroopUin", Boolean.valueOf(paramawbv.mCanSearchByTroopUin));
    paramContentValues.put("dwCmdUinJoinTime", Long.valueOf(paramawbv.dwCmdUinJoinTime));
    paramContentValues.put("dwLastInsertBAFTipTime", Long.valueOf(paramawbv.dwLastInsertBAFTipTime));
    paramContentValues.put("wInsertBAFTipCount", Integer.valueOf(paramawbv.wInsertBAFTipCount));
    paramContentValues.put("wClickBAFTipCount", Integer.valueOf(paramawbv.wClickBAFTipCount));
    paramContentValues.put("dwLastBAFTipMsgUniSeq", Long.valueOf(paramawbv.dwLastBAFTipMsgUniSeq));
    paramContentValues.put("dwLastBAFTipMsgUniSeq2", Long.valueOf(paramawbv.dwLastBAFTipMsgUniSeq2));
    paramContentValues.put("dailyNewMemberUins", paramawbv.dailyNewMemberUins);
    paramContentValues.put("exitTroopReason", Integer.valueOf(paramawbv.exitTroopReason));
    paramContentValues.put("eliminated", Integer.valueOf(paramawbv.eliminated));
    paramContentValues.put("mIsFreezed", Integer.valueOf(paramawbv.mIsFreezed));
    paramContentValues.put("strLastAnnouncement", paramawbv.strLastAnnouncement);
    paramContentValues.put("nMsgLimitFreq", Integer.valueOf(paramawbv.nMsgLimitFreq));
    paramContentValues.put("mAtOrReplyMeUins", paramawbv.mAtOrReplyMeUins);
    paramContentValues.put("groupFlagExt4", Integer.valueOf(paramawbv.groupFlagExt4));
    paramContentValues.put("groupFreezeReason", Integer.valueOf(paramawbv.groupFreezeReason));
    paramContentValues.put("troopHonorGrayFlag", Integer.valueOf(paramawbv.troopHonorGrayFlag));
    paramContentValues.put("isAllowHistoryMsgFlag", Integer.valueOf(paramawbv.isAllowHistoryMsgFlag));
    paramContentValues.put("troopRepeatType", Integer.valueOf(paramawbv.troopRepeatType));
    paramContentValues.put("feeds_id", paramawbv.feeds_id);
    paramContentValues.put("myHonorList", paramawbv.myHonorList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awcz
 * JD-Core Version:    0.7.0.1
 */