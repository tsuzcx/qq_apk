import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class azom
  extends OGAbstractDao
{
  public azom()
  {
    this.columnLen = 126;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (TroopInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
      paramEntity.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
      paramEntity.troopcode = paramCursor.getString(paramCursor.getColumnIndex("troopcode"));
      paramEntity.troopowneruin = paramCursor.getString(paramCursor.getColumnIndex("troopowneruin"));
      paramEntity.troopname = paramCursor.getString(paramCursor.getColumnIndex("troopname"));
      paramEntity.newTroopName = paramCursor.getString(paramCursor.getColumnIndex("newTroopName"));
      paramEntity.newTroopNameTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("newTroopNameTimeStamp"));
      paramEntity.troopface = paramCursor.getShort(paramCursor.getColumnIndex("troopface"));
      paramEntity.troopmemo = paramCursor.getString(paramCursor.getColumnIndex("troopmemo"));
      paramEntity.fingertroopmemo = paramCursor.getString(paramCursor.getColumnIndex("fingertroopmemo"));
      paramEntity.location = paramCursor.getString(paramCursor.getColumnIndex("location"));
      paramEntity.grade = paramCursor.getInt(paramCursor.getColumnIndex("grade"));
      paramEntity.school = paramCursor.getString(paramCursor.getColumnIndex("school"));
      paramEntity.mRichFingerMemo = paramCursor.getString(paramCursor.getColumnIndex("mRichFingerMemo"));
      paramEntity.troopmask = paramCursor.getInt(paramCursor.getColumnIndex("troopmask"));
      paramEntity.trooptype = paramCursor.getInt(paramCursor.getColumnIndex("trooptype"));
      paramEntity.troopCreateTime = paramCursor.getLong(paramCursor.getColumnIndex("troopCreateTime"));
      paramEntity.dwGroupFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlag"));
      paramEntity.cGroupOption = paramCursor.getShort(paramCursor.getColumnIndex("cGroupOption"));
      paramEntity.wMemberMax = paramCursor.getInt(paramCursor.getColumnIndex("wMemberMax"));
      paramEntity.maxAdminNum = paramCursor.getInt(paramCursor.getColumnIndex("maxAdminNum"));
      paramEntity.wSpecialClass = paramCursor.getInt(paramCursor.getColumnIndex("wSpecialClass"));
      paramEntity.cGroupLevel = paramCursor.getShort(paramCursor.getColumnIndex("cGroupLevel"));
      paramEntity.wMemberNum = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNum"));
      paramEntity.wMemberNumClient = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNumClient"));
      paramEntity.Administrator = paramCursor.getString(paramCursor.getColumnIndex("Administrator"));
      paramEntity.dwGroupClassExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupClassExt"));
      paramEntity.mGroupClassExtText = paramCursor.getString(paramCursor.getColumnIndex("mGroupClassExtText"));
      paramEntity.dwGroupFlagExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt"));
      paramEntity.dwAuthGroupType = paramCursor.getLong(paramCursor.getColumnIndex("dwAuthGroupType"));
      paramEntity.troopAuthenticateInfo = paramCursor.getString(paramCursor.getColumnIndex("troopAuthenticateInfo"));
      paramEntity.dwGroupInfoSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupInfoSeq"));
      paramEntity.mMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberNumSeq"));
      paramEntity.mOldMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberNumSeq"));
      paramEntity.mMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberCardSeq"));
      paramEntity.mOldMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberCardSeq"));
      paramEntity.dwGroupLevelSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupLevelSeq"));
      paramEntity.cGroupRankSysFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankSysFlag")));
      paramEntity.cGroupRankUserFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankUserFlag")));
      paramEntity.cNewGroupRankUserFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cNewGroupRankUserFlag")));
      paramEntity.troopLevelMap = paramCursor.getString(paramCursor.getColumnIndex("troopLevelMap"));
      paramEntity.newTroopLevelMap = paramCursor.getString(paramCursor.getColumnIndex("newTroopLevelMap"));
      paramEntity.joinTroopQuestion = paramCursor.getString(paramCursor.getColumnIndex("joinTroopQuestion"));
      paramEntity.joinTroopAnswer = paramCursor.getString(paramCursor.getColumnIndex("joinTroopAnswer"));
      paramEntity.cAlbumResult = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cAlbumResult")));
      paramEntity.dwTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwTimeStamp"));
      paramEntity.strQZonePhotoUrls = paramCursor.getString(paramCursor.getColumnIndex("strQZonePhotoUrls"));
      paramEntity.mQZonePhotoNum = paramCursor.getInt(paramCursor.getColumnIndex("mQZonePhotoNum"));
      paramEntity.strLocation = paramCursor.getString(paramCursor.getColumnIndex("strLocation"));
      paramEntity.troopLat = paramCursor.getInt(paramCursor.getColumnIndex("troopLat"));
      paramEntity.troopLon = paramCursor.getInt(paramCursor.getColumnIndex("troopLon"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("mMemberInvitingFlag")))
      {
        paramBoolean = true;
        paramEntity.mMemberInvitingFlag = paramBoolean;
        paramEntity.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramEntity.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramEntity.mSomeMemberUins = paramCursor.getString(paramCursor.getColumnIndex("mSomeMemberUins"));
        paramEntity.mHeaderUinsOld = paramCursor.getString(paramCursor.getColumnIndex("mHeaderUinsOld"));
        paramEntity.mHeaderUinsNew = paramCursor.getString(paramCursor.getColumnIndex("mHeaderUinsNew"));
        paramEntity.mTags = paramCursor.getString(paramCursor.getColumnIndex("mTags"));
        paramEntity.mTroopAvatarId = paramCursor.getInt(paramCursor.getColumnIndex("mTroopAvatarId"));
        paramEntity.mTroopPicListJson = paramCursor.getString(paramCursor.getColumnIndex("mTroopPicListJson"));
        paramEntity.nTroopGrade = paramCursor.getInt(paramCursor.getColumnIndex("nTroopGrade"));
        paramEntity.isShowInNearbyTroops = paramCursor.getInt(paramCursor.getColumnIndex("isShowInNearbyTroops"));
        paramEntity.dwGagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp"));
        paramEntity.dwGagTimeStamp_me = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp_me"));
        paramEntity.dwCmdUinUinFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwCmdUinUinFlag"));
        paramEntity.dwAdditionalFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAdditionalFlag"));
        paramEntity.troopTypeExt = paramCursor.getInt(paramCursor.getColumnIndex("troopTypeExt"));
        paramEntity.ownerNameShow = paramCursor.getString(paramCursor.getColumnIndex("ownerNameShow"));
        paramEntity.adminNameShow = paramCursor.getString(paramCursor.getColumnIndex("adminNameShow"));
        paramEntity.dwOfficeMode = paramCursor.getLong(paramCursor.getColumnIndex("dwOfficeMode"));
        paramEntity.dwGroupFlagExt3 = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt3"));
        paramEntity.dwGroupFlagExt4 = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt4"));
        paramEntity.cmdUinFlagEx2 = paramCursor.getLong(paramCursor.getColumnIndex("cmdUinFlagEx2"));
        paramEntity.udwCmdUinRingtoneID = paramCursor.getLong(paramCursor.getColumnIndex("udwCmdUinRingtoneID"));
        paramEntity.memberListToShow = paramCursor.getString(paramCursor.getColumnIndex("memberListToShow"));
        paramEntity.troopPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("troopPrivilegeFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isNewTroop"))) {
          break label2418;
        }
        paramBoolean = true;
        label1458:
        paramEntity.isNewTroop = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSetNewTroopHead"))) {
          break label2423;
        }
        paramBoolean = true;
        label1484:
        paramEntity.hasSetNewTroopHead = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSetNewTroopName"))) {
          break label2428;
        }
        paramBoolean = true;
        label1510:
        paramEntity.hasSetNewTroopName = paramBoolean;
        paramEntity.maxInviteMemNum = paramCursor.getInt(paramCursor.getColumnIndex("maxInviteMemNum"));
        paramEntity.lastMsgTime = paramCursor.getLong(paramCursor.getColumnIndex("lastMsgTime"));
        paramEntity.allowMemberModifTroopName = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberModifTroopName"));
        paramEntity.allowMemberKick = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberKick"));
        paramEntity.allowMemberAtAll = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberAtAll"));
        paramEntity.oldTroopName = paramCursor.getString(paramCursor.getColumnIndex("oldTroopName"));
        paramEntity.hlGuildAppid = paramCursor.getLong(paramCursor.getColumnIndex("hlGuildAppid"));
        paramEntity.hlGuildSubType = paramCursor.getLong(paramCursor.getColumnIndex("hlGuildSubType"));
        paramEntity.hlGuildOrgid = paramCursor.getInt(paramCursor.getColumnIndex("hlGuildOrgid"));
        paramEntity.hlGuildBinary = paramCursor.getInt(paramCursor.getColumnIndex("hlGuildBinary"));
        paramEntity.gameSwitchStatus = paramCursor.getInt(paramCursor.getColumnIndex("gameSwitchStatus"));
        paramEntity.showGameSwitchStatus = paramCursor.getInt(paramCursor.getColumnIndex("showGameSwitchStatus"));
        paramEntity.lastShareLbsMsgUniseq = paramCursor.getLong(paramCursor.getColumnIndex("lastShareLbsMsgUniseq"));
        paramEntity.mTroopNeedPayNumber = paramCursor.getFloat(paramCursor.getColumnIndex("mTroopNeedPayNumber"));
        paramEntity.troopCreditLevel = paramCursor.getLong(paramCursor.getColumnIndex("troopCreditLevel"));
        paramEntity.troopCreditLevelInfo = paramCursor.getLong(paramCursor.getColumnIndex("troopCreditLevelInfo"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isTroopBlocked"))) {
          break label2433;
        }
        paramBoolean = true;
        label1840:
        paramEntity.isTroopBlocked = paramBoolean;
        paramEntity.appealDeadline = paramCursor.getLong(paramCursor.getColumnIndex("appealDeadline"));
        paramEntity.dwAppPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAppPrivilegeFlag"));
        paramEntity.topicId = paramCursor.getString(paramCursor.getColumnIndex("topicId"));
        paramEntity.associatePubAccount = paramCursor.getLong(paramCursor.getColumnIndex("associatePubAccount"));
        paramEntity.mTroopFileVideoReqInterval = paramCursor.getLong(paramCursor.getColumnIndex("mTroopFileVideoReqInterval"));
        paramEntity.mTroopFileVideoIsWhite = paramCursor.getInt(paramCursor.getColumnIndex("mTroopFileVideoIsWhite"));
        paramEntity.mTribeStatus = paramCursor.getInt(paramCursor.getColumnIndex("mTribeStatus"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mCanSearchByKeywords"))) {
          break label2438;
        }
        paramBoolean = true;
        label1999:
        paramEntity.mCanSearchByKeywords = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mCanSearchByTroopUin"))) {
          break label2443;
        }
      }
      label2433:
      label2438:
      label2443:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.mCanSearchByTroopUin = paramBoolean;
        paramEntity.dwCmdUinJoinTime = paramCursor.getLong(paramCursor.getColumnIndex("dwCmdUinJoinTime"));
        paramEntity.dwLastInsertBAFTipTime = paramCursor.getLong(paramCursor.getColumnIndex("dwLastInsertBAFTipTime"));
        paramEntity.wInsertBAFTipCount = paramCursor.getInt(paramCursor.getColumnIndex("wInsertBAFTipCount"));
        paramEntity.wClickBAFTipCount = paramCursor.getInt(paramCursor.getColumnIndex("wClickBAFTipCount"));
        paramEntity.dwLastBAFTipMsgUniSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq"));
        paramEntity.dwLastBAFTipMsgUniSeq2 = paramCursor.getLong(paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq2"));
        paramEntity.dailyNewMemberUins = paramCursor.getString(paramCursor.getColumnIndex("dailyNewMemberUins"));
        paramEntity.exitTroopReason = paramCursor.getInt(paramCursor.getColumnIndex("exitTroopReason"));
        paramEntity.eliminated = paramCursor.getInt(paramCursor.getColumnIndex("eliminated"));
        paramEntity.mIsFreezed = paramCursor.getInt(paramCursor.getColumnIndex("mIsFreezed"));
        paramEntity.strLastAnnouncement = paramCursor.getString(paramCursor.getColumnIndex("strLastAnnouncement"));
        paramEntity.nMsgLimitFreq = paramCursor.getInt(paramCursor.getColumnIndex("nMsgLimitFreq"));
        paramEntity.mAtOrReplyMeUins = paramCursor.getString(paramCursor.getColumnIndex("mAtOrReplyMeUins"));
        paramEntity.groupFlagExt4 = paramCursor.getInt(paramCursor.getColumnIndex("groupFlagExt4"));
        paramEntity.groupFreezeReason = paramCursor.getInt(paramCursor.getColumnIndex("groupFreezeReason"));
        paramEntity.troopHonorGrayFlag = paramCursor.getInt(paramCursor.getColumnIndex("troopHonorGrayFlag"));
        paramEntity.isAllowHistoryMsgFlag = paramCursor.getInt(paramCursor.getColumnIndex("isAllowHistoryMsgFlag"));
        paramEntity.troopRepeatType = paramCursor.getInt(paramCursor.getColumnIndex("troopRepeatType"));
        paramEntity.feeds_id = paramCursor.getString(paramCursor.getColumnIndex("feeds_id"));
        paramEntity.myHonorList = paramCursor.getString(paramCursor.getColumnIndex("myHonorList"));
        return paramEntity;
        paramBoolean = false;
        break;
        label2418:
        paramBoolean = false;
        break label1458;
        label2423:
        paramBoolean = false;
        break label1484;
        label2428:
        paramBoolean = false;
        break label1510;
        paramBoolean = false;
        break label1840;
        paramBoolean = false;
        break label1999;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("timeSec");
      if (i != -1) {
        break label7021;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("timeSec", Long.TYPE));
      label2518:
      i = paramCursor.getColumnIndex("troopuin");
      if (i != -1) {
        break label7036;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopuin", String.class));
      label2553:
      i = paramCursor.getColumnIndex("troopcode");
      if (i != -1) {
        break label7051;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopcode", String.class));
      label2588:
      i = paramCursor.getColumnIndex("troopowneruin");
      if (i != -1) {
        break label7066;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopowneruin", String.class));
      label2623:
      i = paramCursor.getColumnIndex("troopname");
      if (i != -1) {
        break label7081;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopname", String.class));
      label2658:
      i = paramCursor.getColumnIndex("newTroopName");
      if (i != -1) {
        break label7096;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("newTroopName", String.class));
      label2693:
      i = paramCursor.getColumnIndex("newTroopNameTimeStamp");
      if (i != -1) {
        break label7111;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("newTroopNameTimeStamp", Long.TYPE));
      label2728:
      i = paramCursor.getColumnIndex("troopface");
      if (i != -1) {
        break label7126;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopface", Short.TYPE));
      label2763:
      i = paramCursor.getColumnIndex("troopmemo");
      if (i != -1) {
        break label7141;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopmemo", String.class));
      label2798:
      i = paramCursor.getColumnIndex("fingertroopmemo");
      if (i != -1) {
        break label7156;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("fingertroopmemo", String.class));
      label2833:
      i = paramCursor.getColumnIndex("location");
      if (i != -1) {
        break label7171;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("location", String.class));
      label2868:
      i = paramCursor.getColumnIndex("grade");
      if (i != -1) {
        break label7186;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("grade", Integer.TYPE));
      label2903:
      i = paramCursor.getColumnIndex("school");
      if (i != -1) {
        break label7201;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("school", String.class));
      label2938:
      i = paramCursor.getColumnIndex("mRichFingerMemo");
      if (i != -1) {
        break label7216;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mRichFingerMemo", String.class));
      label2973:
      i = paramCursor.getColumnIndex("troopmask");
      if (i != -1) {
        break label7231;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopmask", Integer.TYPE));
      label3008:
      i = paramCursor.getColumnIndex("trooptype");
      if (i != -1) {
        break label7246;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("trooptype", Integer.TYPE));
      label3043:
      i = paramCursor.getColumnIndex("troopCreateTime");
      if (i != -1) {
        break label7261;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopCreateTime", Long.TYPE));
      label3078:
      i = paramCursor.getColumnIndex("dwGroupFlag");
      if (i != -1) {
        break label7276;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGroupFlag", Long.TYPE));
      label3113:
      i = paramCursor.getColumnIndex("cGroupOption");
      if (i != -1) {
        break label7291;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cGroupOption", Short.TYPE));
      label3148:
      i = paramCursor.getColumnIndex("wMemberMax");
      if (i != -1) {
        break label7306;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wMemberMax", Integer.TYPE));
      label3183:
      i = paramCursor.getColumnIndex("maxAdminNum");
      if (i != -1) {
        break label7321;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("maxAdminNum", Integer.TYPE));
      label3218:
      i = paramCursor.getColumnIndex("wSpecialClass");
      if (i != -1) {
        break label7336;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wSpecialClass", Integer.TYPE));
      label3253:
      i = paramCursor.getColumnIndex("cGroupLevel");
      if (i != -1) {
        break label7351;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cGroupLevel", Short.TYPE));
      label3288:
      i = paramCursor.getColumnIndex("wMemberNum");
      if (i != -1) {
        break label7366;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wMemberNum", Integer.TYPE));
      label3323:
      i = paramCursor.getColumnIndex("wMemberNumClient");
      if (i != -1) {
        break label7381;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wMemberNumClient", Integer.TYPE));
      label3358:
      i = paramCursor.getColumnIndex("Administrator");
      if (i != -1) {
        break label7396;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("Administrator", String.class));
      label3393:
      i = paramCursor.getColumnIndex("dwGroupClassExt");
      if (i != -1) {
        break label7411;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGroupClassExt", Long.TYPE));
      label3428:
      i = paramCursor.getColumnIndex("mGroupClassExtText");
      if (i != -1) {
        break label7426;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mGroupClassExtText", String.class));
      label3463:
      i = paramCursor.getColumnIndex("dwGroupFlagExt");
      if (i != -1) {
        break label7441;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGroupFlagExt", Long.TYPE));
      label3498:
      i = paramCursor.getColumnIndex("dwAuthGroupType");
      if (i != -1) {
        break label7456;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwAuthGroupType", Long.TYPE));
      label3533:
      i = paramCursor.getColumnIndex("troopAuthenticateInfo");
      if (i != -1) {
        break label7471;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopAuthenticateInfo", String.class));
      label3568:
      i = paramCursor.getColumnIndex("dwGroupInfoSeq");
      if (i != -1) {
        break label7486;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGroupInfoSeq", Long.TYPE));
      label3603:
      i = paramCursor.getColumnIndex("mMemberNumSeq");
      if (i != -1) {
        break label7501;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mMemberNumSeq", Long.TYPE));
      label3638:
      i = paramCursor.getColumnIndex("mOldMemberNumSeq");
      if (i != -1) {
        break label7516;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mOldMemberNumSeq", Long.TYPE));
      label3673:
      i = paramCursor.getColumnIndex("mMemberCardSeq");
      if (i != -1) {
        break label7531;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mMemberCardSeq", Long.TYPE));
      label3708:
      i = paramCursor.getColumnIndex("mOldMemberCardSeq");
      if (i != -1) {
        break label7546;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mOldMemberCardSeq", Long.TYPE));
      label3743:
      i = paramCursor.getColumnIndex("dwGroupLevelSeq");
      if (i != -1) {
        break label7561;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGroupLevelSeq", Long.TYPE));
      label3778:
      i = paramCursor.getColumnIndex("cGroupRankSysFlag");
      if (i != -1) {
        break label7576;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cGroupRankSysFlag", Byte.TYPE));
      label3813:
      i = paramCursor.getColumnIndex("cGroupRankUserFlag");
      if (i != -1) {
        break label7592;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cGroupRankUserFlag", Byte.TYPE));
      label3848:
      i = paramCursor.getColumnIndex("cNewGroupRankUserFlag");
      if (i != -1) {
        break label7608;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cNewGroupRankUserFlag", Byte.TYPE));
      label3883:
      i = paramCursor.getColumnIndex("troopLevelMap");
      if (i != -1) {
        break label7624;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopLevelMap", String.class));
      label3918:
      i = paramCursor.getColumnIndex("newTroopLevelMap");
      if (i != -1) {
        break label7639;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("newTroopLevelMap", String.class));
      label3953:
      i = paramCursor.getColumnIndex("joinTroopQuestion");
      if (i != -1) {
        break label7654;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("joinTroopQuestion", String.class));
      label3988:
      i = paramCursor.getColumnIndex("joinTroopAnswer");
      if (i != -1) {
        break label7669;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("joinTroopAnswer", String.class));
      label4023:
      i = paramCursor.getColumnIndex("cAlbumResult");
      if (i != -1) {
        break label7684;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cAlbumResult", Byte.TYPE));
      label4058:
      i = paramCursor.getColumnIndex("dwTimeStamp");
      if (i != -1) {
        break label7700;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwTimeStamp", Long.TYPE));
      label4093:
      i = paramCursor.getColumnIndex("strQZonePhotoUrls");
      if (i != -1) {
        break label7715;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strQZonePhotoUrls", String.class));
      label4128:
      i = paramCursor.getColumnIndex("mQZonePhotoNum");
      if (i != -1) {
        break label7730;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mQZonePhotoNum", Integer.TYPE));
      label4163:
      i = paramCursor.getColumnIndex("strLocation");
      if (i != -1) {
        break label7745;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strLocation", String.class));
      label4198:
      i = paramCursor.getColumnIndex("troopLat");
      if (i != -1) {
        break label7760;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopLat", Integer.TYPE));
      label4233:
      i = paramCursor.getColumnIndex("troopLon");
      if (i != -1) {
        break label7775;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopLon", Integer.TYPE));
      label4268:
      i = paramCursor.getColumnIndex("mMemberInvitingFlag");
      if (i != -1) {
        break label7790;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mMemberInvitingFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label7817;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mComparePartInt", Integer.TYPE));
      label4340:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label7832;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mCompareSpell", String.class));
      label4377:
      i = paramCursor.getColumnIndex("mSomeMemberUins");
      if (i != -1) {
        break label7847;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mSomeMemberUins", String.class));
      label4414:
      i = paramCursor.getColumnIndex("mHeaderUinsOld");
      if (i != -1) {
        break label7862;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mHeaderUinsOld", String.class));
      label4451:
      i = paramCursor.getColumnIndex("mHeaderUinsNew");
      if (i != -1) {
        break label7877;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mHeaderUinsNew", String.class));
      label4488:
      i = paramCursor.getColumnIndex("mTags");
      if (i != -1) {
        break label7892;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTags", String.class));
      label4525:
      i = paramCursor.getColumnIndex("mTroopAvatarId");
      if (i != -1) {
        break label7907;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTroopAvatarId", Integer.TYPE));
      label4562:
      i = paramCursor.getColumnIndex("mTroopPicListJson");
      if (i != -1) {
        break label7922;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTroopPicListJson", String.class));
      label4599:
      i = paramCursor.getColumnIndex("nTroopGrade");
      if (i != -1) {
        break label7937;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nTroopGrade", Integer.TYPE));
      label4636:
      i = paramCursor.getColumnIndex("isShowInNearbyTroops");
      if (i != -1) {
        break label7952;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isShowInNearbyTroops", Integer.TYPE));
      label4673:
      i = paramCursor.getColumnIndex("dwGagTimeStamp");
      if (i != -1) {
        break label7967;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGagTimeStamp", Long.TYPE));
      label4710:
      i = paramCursor.getColumnIndex("dwGagTimeStamp_me");
      if (i != -1) {
        break label7982;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGagTimeStamp_me", Long.TYPE));
      label4747:
      i = paramCursor.getColumnIndex("dwCmdUinUinFlag");
      if (i != -1) {
        break label7997;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwCmdUinUinFlag", Long.TYPE));
      label4784:
      i = paramCursor.getColumnIndex("dwAdditionalFlag");
      if (i != -1) {
        break label8012;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwAdditionalFlag", Long.TYPE));
      label4821:
      i = paramCursor.getColumnIndex("troopTypeExt");
      if (i != -1) {
        break label8027;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopTypeExt", Integer.TYPE));
      label4858:
      i = paramCursor.getColumnIndex("ownerNameShow");
      if (i != -1) {
        break label8042;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ownerNameShow", String.class));
      label4895:
      i = paramCursor.getColumnIndex("adminNameShow");
      if (i != -1) {
        break label8057;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("adminNameShow", String.class));
      label4932:
      i = paramCursor.getColumnIndex("dwOfficeMode");
      if (i != -1) {
        break label8072;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwOfficeMode", Long.TYPE));
      label4969:
      i = paramCursor.getColumnIndex("dwGroupFlagExt3");
      if (i != -1) {
        break label8087;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGroupFlagExt3", Long.TYPE));
      label5006:
      i = paramCursor.getColumnIndex("dwGroupFlagExt4");
      if (i != -1) {
        break label8102;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGroupFlagExt4", Long.TYPE));
      label5043:
      i = paramCursor.getColumnIndex("cmdUinFlagEx2");
      if (i != -1) {
        break label8117;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cmdUinFlagEx2", Long.TYPE));
      label5080:
      i = paramCursor.getColumnIndex("udwCmdUinRingtoneID");
      if (i != -1) {
        break label8132;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("udwCmdUinRingtoneID", Long.TYPE));
      label5117:
      i = paramCursor.getColumnIndex("memberListToShow");
      if (i != -1) {
        break label8147;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("memberListToShow", String.class));
      label5154:
      i = paramCursor.getColumnIndex("troopPrivilegeFlag");
      if (i != -1) {
        break label8162;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopPrivilegeFlag", Long.TYPE));
      label5191:
      i = paramCursor.getColumnIndex("isNewTroop");
      if (i != -1) {
        break label8177;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isNewTroop", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasSetNewTroopHead");
      if (i != -1) {
        break label8204;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasSetNewTroopHead", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasSetNewTroopName");
      if (i != -1) {
        break label8231;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasSetNewTroopName", Boolean.TYPE));
      i = paramCursor.getColumnIndex("maxInviteMemNum");
      if (i != -1) {
        break label8258;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("maxInviteMemNum", Integer.TYPE));
      label5339:
      i = paramCursor.getColumnIndex("lastMsgTime");
      if (i != -1) {
        break label8273;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastMsgTime", Long.TYPE));
      label5376:
      i = paramCursor.getColumnIndex("allowMemberModifTroopName");
      if (i != -1) {
        break label8288;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowMemberModifTroopName", Integer.TYPE));
      label5413:
      i = paramCursor.getColumnIndex("allowMemberKick");
      if (i != -1) {
        break label8303;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowMemberKick", Integer.TYPE));
      label5450:
      i = paramCursor.getColumnIndex("allowMemberAtAll");
      if (i != -1) {
        break label8318;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowMemberAtAll", Integer.TYPE));
      label5487:
      i = paramCursor.getColumnIndex("oldTroopName");
      if (i != -1) {
        break label8333;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("oldTroopName", String.class));
      label5524:
      i = paramCursor.getColumnIndex("hlGuildAppid");
      if (i != -1) {
        break label8348;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hlGuildAppid", Long.TYPE));
      label5561:
      i = paramCursor.getColumnIndex("hlGuildSubType");
      if (i != -1) {
        break label8363;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hlGuildSubType", Long.TYPE));
      label5598:
      i = paramCursor.getColumnIndex("hlGuildOrgid");
      if (i != -1) {
        break label8378;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hlGuildOrgid", Integer.TYPE));
      label5635:
      i = paramCursor.getColumnIndex("hlGuildBinary");
      if (i != -1) {
        break label8393;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hlGuildBinary", Integer.TYPE));
      label5672:
      i = paramCursor.getColumnIndex("gameSwitchStatus");
      if (i != -1) {
        break label8408;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("gameSwitchStatus", Integer.TYPE));
      label5709:
      i = paramCursor.getColumnIndex("showGameSwitchStatus");
      if (i != -1) {
        break label8423;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showGameSwitchStatus", Integer.TYPE));
      label5746:
      i = paramCursor.getColumnIndex("lastShareLbsMsgUniseq");
      if (i != -1) {
        break label8438;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastShareLbsMsgUniseq", Long.TYPE));
      label5783:
      i = paramCursor.getColumnIndex("mTroopNeedPayNumber");
      if (i != -1) {
        break label8453;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTroopNeedPayNumber", Float.TYPE));
      label5820:
      i = paramCursor.getColumnIndex("troopCreditLevel");
      if (i != -1) {
        break label8468;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopCreditLevel", Long.TYPE));
      label5857:
      i = paramCursor.getColumnIndex("troopCreditLevelInfo");
      if (i != -1) {
        break label8483;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopCreditLevelInfo", Long.TYPE));
      label5894:
      i = paramCursor.getColumnIndex("isTroopBlocked");
      if (i != -1) {
        break label8498;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isTroopBlocked", Boolean.TYPE));
      i = paramCursor.getColumnIndex("appealDeadline");
      if (i != -1) {
        break label8525;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("appealDeadline", Long.TYPE));
      label5968:
      i = paramCursor.getColumnIndex("dwAppPrivilegeFlag");
      if (i != -1) {
        break label8540;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwAppPrivilegeFlag", Long.TYPE));
      label6005:
      i = paramCursor.getColumnIndex("topicId");
      if (i != -1) {
        break label8555;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("topicId", String.class));
      label6042:
      i = paramCursor.getColumnIndex("associatePubAccount");
      if (i != -1) {
        break label8570;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("associatePubAccount", Long.TYPE));
      label6079:
      i = paramCursor.getColumnIndex("mTroopFileVideoReqInterval");
      if (i != -1) {
        break label8585;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTroopFileVideoReqInterval", Long.TYPE));
      label6116:
      i = paramCursor.getColumnIndex("mTroopFileVideoIsWhite");
      if (i != -1) {
        break label8600;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTroopFileVideoIsWhite", Integer.TYPE));
      label6153:
      i = paramCursor.getColumnIndex("mTribeStatus");
      if (i != -1) {
        break label8615;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTribeStatus", Integer.TYPE));
      label6190:
      i = paramCursor.getColumnIndex("mCanSearchByKeywords");
      if (i != -1) {
        break label8630;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mCanSearchByKeywords", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mCanSearchByTroopUin");
      if (i != -1) {
        break label8657;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mCanSearchByTroopUin", Boolean.TYPE));
      i = paramCursor.getColumnIndex("dwCmdUinJoinTime");
      if (i != -1) {
        break label8685;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwCmdUinJoinTime", Long.TYPE));
      label6301:
      i = paramCursor.getColumnIndex("dwLastInsertBAFTipTime");
      if (i != -1) {
        break label8700;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwLastInsertBAFTipTime", Long.TYPE));
      label6338:
      i = paramCursor.getColumnIndex("wInsertBAFTipCount");
      if (i != -1) {
        break label8715;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wInsertBAFTipCount", Integer.TYPE));
      label6375:
      i = paramCursor.getColumnIndex("wClickBAFTipCount");
      if (i != -1) {
        break label8730;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wClickBAFTipCount", Integer.TYPE));
      label6412:
      i = paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq");
      if (i != -1) {
        break label8745;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwLastBAFTipMsgUniSeq", Long.TYPE));
      label6449:
      i = paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq2");
      if (i != -1) {
        break label8760;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwLastBAFTipMsgUniSeq2", Long.TYPE));
      label6486:
      i = paramCursor.getColumnIndex("dailyNewMemberUins");
      if (i != -1) {
        break label8775;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dailyNewMemberUins", String.class));
      label6523:
      i = paramCursor.getColumnIndex("exitTroopReason");
      if (i != -1) {
        break label8790;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("exitTroopReason", Integer.TYPE));
      label6560:
      i = paramCursor.getColumnIndex("eliminated");
      if (i != -1) {
        break label8805;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("eliminated", Integer.TYPE));
      label6597:
      i = paramCursor.getColumnIndex("mIsFreezed");
      if (i != -1) {
        break label8820;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mIsFreezed", Integer.TYPE));
      label6634:
      i = paramCursor.getColumnIndex("strLastAnnouncement");
      if (i != -1) {
        break label8835;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strLastAnnouncement", String.class));
      label6671:
      i = paramCursor.getColumnIndex("nMsgLimitFreq");
      if (i != -1) {
        break label8850;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nMsgLimitFreq", Integer.TYPE));
      label6708:
      i = paramCursor.getColumnIndex("mAtOrReplyMeUins");
      if (i != -1) {
        break label8865;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mAtOrReplyMeUins", String.class));
      label6745:
      i = paramCursor.getColumnIndex("groupFlagExt4");
      if (i != -1) {
        break label8880;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("groupFlagExt4", Integer.TYPE));
      label6782:
      i = paramCursor.getColumnIndex("groupFreezeReason");
      if (i != -1) {
        break label8895;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("groupFreezeReason", Integer.TYPE));
      label6819:
      i = paramCursor.getColumnIndex("troopHonorGrayFlag");
      if (i != -1) {
        break label8910;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopHonorGrayFlag", Integer.TYPE));
      label6856:
      i = paramCursor.getColumnIndex("isAllowHistoryMsgFlag");
      if (i != -1) {
        break label8925;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isAllowHistoryMsgFlag", Integer.TYPE));
      label6893:
      i = paramCursor.getColumnIndex("troopRepeatType");
      if (i != -1) {
        break label8940;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopRepeatType", Integer.TYPE));
      label6930:
      i = paramCursor.getColumnIndex("feeds_id");
      if (i != -1) {
        break label8955;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("feeds_id", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("myHonorList");
      if (i != -1) {
        break label8970;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("myHonorList", String.class));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label7021:
      paramEntity.timeSec = paramCursor.getLong(i);
      break label2518;
      label7036:
      paramEntity.troopuin = paramCursor.getString(i);
      break label2553;
      label7051:
      paramEntity.troopcode = paramCursor.getString(i);
      break label2588;
      label7066:
      paramEntity.troopowneruin = paramCursor.getString(i);
      break label2623;
      label7081:
      paramEntity.troopname = paramCursor.getString(i);
      break label2658;
      label7096:
      paramEntity.newTroopName = paramCursor.getString(i);
      break label2693;
      label7111:
      paramEntity.newTroopNameTimeStamp = paramCursor.getLong(i);
      break label2728;
      label7126:
      paramEntity.troopface = paramCursor.getShort(i);
      break label2763;
      label7141:
      paramEntity.troopmemo = paramCursor.getString(i);
      break label2798;
      label7156:
      paramEntity.fingertroopmemo = paramCursor.getString(i);
      break label2833;
      label7171:
      paramEntity.location = paramCursor.getString(i);
      break label2868;
      label7186:
      paramEntity.grade = paramCursor.getInt(i);
      break label2903;
      label7201:
      paramEntity.school = paramCursor.getString(i);
      break label2938;
      label7216:
      paramEntity.mRichFingerMemo = paramCursor.getString(i);
      break label2973;
      label7231:
      paramEntity.troopmask = paramCursor.getInt(i);
      break label3008;
      label7246:
      paramEntity.trooptype = paramCursor.getInt(i);
      break label3043;
      label7261:
      paramEntity.troopCreateTime = paramCursor.getLong(i);
      break label3078;
      label7276:
      paramEntity.dwGroupFlag = paramCursor.getLong(i);
      break label3113;
      label7291:
      paramEntity.cGroupOption = paramCursor.getShort(i);
      break label3148;
      label7306:
      paramEntity.wMemberMax = paramCursor.getInt(i);
      break label3183;
      label7321:
      paramEntity.maxAdminNum = paramCursor.getInt(i);
      break label3218;
      label7336:
      paramEntity.wSpecialClass = paramCursor.getInt(i);
      break label3253;
      label7351:
      paramEntity.cGroupLevel = paramCursor.getShort(i);
      break label3288;
      label7366:
      paramEntity.wMemberNum = paramCursor.getInt(i);
      break label3323;
      label7381:
      paramEntity.wMemberNumClient = paramCursor.getInt(i);
      break label3358;
      label7396:
      paramEntity.Administrator = paramCursor.getString(i);
      break label3393;
      label7411:
      paramEntity.dwGroupClassExt = paramCursor.getLong(i);
      break label3428;
      label7426:
      paramEntity.mGroupClassExtText = paramCursor.getString(i);
      break label3463;
      label7441:
      paramEntity.dwGroupFlagExt = paramCursor.getLong(i);
      break label3498;
      label7456:
      paramEntity.dwAuthGroupType = paramCursor.getLong(i);
      break label3533;
      label7471:
      paramEntity.troopAuthenticateInfo = paramCursor.getString(i);
      break label3568;
      label7486:
      paramEntity.dwGroupInfoSeq = paramCursor.getLong(i);
      break label3603;
      label7501:
      paramEntity.mMemberNumSeq = paramCursor.getLong(i);
      break label3638;
      label7516:
      paramEntity.mOldMemberNumSeq = paramCursor.getLong(i);
      break label3673;
      label7531:
      paramEntity.mMemberCardSeq = paramCursor.getLong(i);
      break label3708;
      label7546:
      paramEntity.mOldMemberCardSeq = paramCursor.getLong(i);
      break label3743;
      label7561:
      paramEntity.dwGroupLevelSeq = paramCursor.getLong(i);
      break label3778;
      label7576:
      paramEntity.cGroupRankSysFlag = ((byte)paramCursor.getShort(i));
      break label3813;
      label7592:
      paramEntity.cGroupRankUserFlag = ((byte)paramCursor.getShort(i));
      break label3848;
      label7608:
      paramEntity.cNewGroupRankUserFlag = ((byte)paramCursor.getShort(i));
      break label3883;
      label7624:
      paramEntity.troopLevelMap = paramCursor.getString(i);
      break label3918;
      label7639:
      paramEntity.newTroopLevelMap = paramCursor.getString(i);
      break label3953;
      label7654:
      paramEntity.joinTroopQuestion = paramCursor.getString(i);
      break label3988;
      label7669:
      paramEntity.joinTroopAnswer = paramCursor.getString(i);
      break label4023;
      label7684:
      paramEntity.cAlbumResult = ((byte)paramCursor.getShort(i));
      break label4058;
      label7700:
      paramEntity.dwTimeStamp = paramCursor.getLong(i);
      break label4093;
      label7715:
      paramEntity.strQZonePhotoUrls = paramCursor.getString(i);
      break label4128;
      label7730:
      paramEntity.mQZonePhotoNum = paramCursor.getInt(i);
      break label4163;
      label7745:
      paramEntity.strLocation = paramCursor.getString(i);
      break label4198;
      label7760:
      paramEntity.troopLat = paramCursor.getInt(i);
      break label4233;
      label7775:
      paramEntity.troopLon = paramCursor.getInt(i);
      break label4268;
      label7790:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.mMemberInvitingFlag = paramBoolean;
        break;
      }
      label7817:
      paramEntity.mComparePartInt = paramCursor.getInt(i);
      break label4340;
      label7832:
      paramEntity.mCompareSpell = paramCursor.getString(i);
      break label4377;
      label7847:
      paramEntity.mSomeMemberUins = paramCursor.getString(i);
      break label4414;
      label7862:
      paramEntity.mHeaderUinsOld = paramCursor.getString(i);
      break label4451;
      label7877:
      paramEntity.mHeaderUinsNew = paramCursor.getString(i);
      break label4488;
      label7892:
      paramEntity.mTags = paramCursor.getString(i);
      break label4525;
      label7907:
      paramEntity.mTroopAvatarId = paramCursor.getInt(i);
      break label4562;
      label7922:
      paramEntity.mTroopPicListJson = paramCursor.getString(i);
      break label4599;
      label7937:
      paramEntity.nTroopGrade = paramCursor.getInt(i);
      break label4636;
      label7952:
      paramEntity.isShowInNearbyTroops = paramCursor.getInt(i);
      break label4673;
      label7967:
      paramEntity.dwGagTimeStamp = paramCursor.getLong(i);
      break label4710;
      label7982:
      paramEntity.dwGagTimeStamp_me = paramCursor.getLong(i);
      break label4747;
      label7997:
      paramEntity.dwCmdUinUinFlag = paramCursor.getLong(i);
      break label4784;
      label8012:
      paramEntity.dwAdditionalFlag = paramCursor.getLong(i);
      break label4821;
      label8027:
      paramEntity.troopTypeExt = paramCursor.getInt(i);
      break label4858;
      label8042:
      paramEntity.ownerNameShow = paramCursor.getString(i);
      break label4895;
      label8057:
      paramEntity.adminNameShow = paramCursor.getString(i);
      break label4932;
      label8072:
      paramEntity.dwOfficeMode = paramCursor.getLong(i);
      break label4969;
      label8087:
      paramEntity.dwGroupFlagExt3 = paramCursor.getLong(i);
      break label5006;
      label8102:
      paramEntity.dwGroupFlagExt4 = paramCursor.getLong(i);
      break label5043;
      label8117:
      paramEntity.cmdUinFlagEx2 = paramCursor.getLong(i);
      break label5080;
      label8132:
      paramEntity.udwCmdUinRingtoneID = paramCursor.getLong(i);
      break label5117;
      label8147:
      paramEntity.memberListToShow = paramCursor.getString(i);
      break label5154;
      label8162:
      paramEntity.troopPrivilegeFlag = paramCursor.getLong(i);
      break label5191;
      label8177:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isNewTroop = paramBoolean;
        break;
      }
      label8204:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasSetNewTroopHead = paramBoolean;
        break;
      }
      label8231:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasSetNewTroopName = paramBoolean;
        break;
      }
      label8258:
      paramEntity.maxInviteMemNum = paramCursor.getInt(i);
      break label5339;
      label8273:
      paramEntity.lastMsgTime = paramCursor.getLong(i);
      break label5376;
      label8288:
      paramEntity.allowMemberModifTroopName = paramCursor.getInt(i);
      break label5413;
      label8303:
      paramEntity.allowMemberKick = paramCursor.getInt(i);
      break label5450;
      label8318:
      paramEntity.allowMemberAtAll = paramCursor.getInt(i);
      break label5487;
      label8333:
      paramEntity.oldTroopName = paramCursor.getString(i);
      break label5524;
      label8348:
      paramEntity.hlGuildAppid = paramCursor.getLong(i);
      break label5561;
      label8363:
      paramEntity.hlGuildSubType = paramCursor.getLong(i);
      break label5598;
      label8378:
      paramEntity.hlGuildOrgid = paramCursor.getInt(i);
      break label5635;
      label8393:
      paramEntity.hlGuildBinary = paramCursor.getInt(i);
      break label5672;
      label8408:
      paramEntity.gameSwitchStatus = paramCursor.getInt(i);
      break label5709;
      label8423:
      paramEntity.showGameSwitchStatus = paramCursor.getInt(i);
      break label5746;
      label8438:
      paramEntity.lastShareLbsMsgUniseq = paramCursor.getLong(i);
      break label5783;
      label8453:
      paramEntity.mTroopNeedPayNumber = paramCursor.getFloat(i);
      break label5820;
      label8468:
      paramEntity.troopCreditLevel = paramCursor.getLong(i);
      break label5857;
      label8483:
      paramEntity.troopCreditLevelInfo = paramCursor.getLong(i);
      break label5894;
      label8498:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isTroopBlocked = paramBoolean;
        break;
      }
      label8525:
      paramEntity.appealDeadline = paramCursor.getLong(i);
      break label5968;
      label8540:
      paramEntity.dwAppPrivilegeFlag = paramCursor.getLong(i);
      break label6005;
      label8555:
      paramEntity.topicId = paramCursor.getString(i);
      break label6042;
      label8570:
      paramEntity.associatePubAccount = paramCursor.getLong(i);
      break label6079;
      label8585:
      paramEntity.mTroopFileVideoReqInterval = paramCursor.getLong(i);
      break label6116;
      label8600:
      paramEntity.mTroopFileVideoIsWhite = paramCursor.getInt(i);
      break label6153;
      label8615:
      paramEntity.mTribeStatus = paramCursor.getInt(i);
      break label6190;
      label8630:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.mCanSearchByKeywords = paramBoolean;
        break;
      }
      label8657:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.mCanSearchByTroopUin = paramBoolean;
        break;
      }
      label8685:
      paramEntity.dwCmdUinJoinTime = paramCursor.getLong(i);
      break label6301;
      label8700:
      paramEntity.dwLastInsertBAFTipTime = paramCursor.getLong(i);
      break label6338;
      label8715:
      paramEntity.wInsertBAFTipCount = paramCursor.getInt(i);
      break label6375;
      label8730:
      paramEntity.wClickBAFTipCount = paramCursor.getInt(i);
      break label6412;
      label8745:
      paramEntity.dwLastBAFTipMsgUniSeq = paramCursor.getLong(i);
      break label6449;
      label8760:
      paramEntity.dwLastBAFTipMsgUniSeq2 = paramCursor.getLong(i);
      break label6486;
      label8775:
      paramEntity.dailyNewMemberUins = paramCursor.getString(i);
      break label6523;
      label8790:
      paramEntity.exitTroopReason = paramCursor.getInt(i);
      break label6560;
      label8805:
      paramEntity.eliminated = paramCursor.getInt(i);
      break label6597;
      label8820:
      paramEntity.mIsFreezed = paramCursor.getInt(i);
      break label6634;
      label8835:
      paramEntity.strLastAnnouncement = paramCursor.getString(i);
      break label6671;
      label8850:
      paramEntity.nMsgLimitFreq = paramCursor.getInt(i);
      break label6708;
      label8865:
      paramEntity.mAtOrReplyMeUins = paramCursor.getString(i);
      break label6745;
      label8880:
      paramEntity.groupFlagExt4 = paramCursor.getInt(i);
      break label6782;
      label8895:
      paramEntity.groupFreezeReason = paramCursor.getInt(i);
      break label6819;
      label8910:
      paramEntity.troopHonorGrayFlag = paramCursor.getInt(i);
      break label6856;
      label8925:
      paramEntity.isAllowHistoryMsgFlag = paramCursor.getInt(i);
      break label6893;
      label8940:
      paramEntity.troopRepeatType = paramCursor.getInt(i);
      break label6930;
      label8955:
      paramEntity.feeds_id = paramCursor.getString(i);
    }
    label8970:
    paramEntity.myHonorList = paramCursor.getString(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (TroopInfo)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("timeSec", Long.valueOf(paramEntity.timeSec));
    paramContentValues.put("troopuin", paramEntity.troopuin);
    paramContentValues.put("troopcode", paramEntity.troopcode);
    paramContentValues.put("troopowneruin", paramEntity.troopowneruin);
    paramContentValues.put("troopname", paramEntity.troopname);
    paramContentValues.put("newTroopName", paramEntity.newTroopName);
    paramContentValues.put("newTroopNameTimeStamp", Long.valueOf(paramEntity.newTroopNameTimeStamp));
    paramContentValues.put("troopface", Short.valueOf(paramEntity.troopface));
    paramContentValues.put("troopmemo", paramEntity.troopmemo);
    paramContentValues.put("fingertroopmemo", paramEntity.fingertroopmemo);
    paramContentValues.put("location", paramEntity.location);
    paramContentValues.put("grade", Integer.valueOf(paramEntity.grade));
    paramContentValues.put("school", paramEntity.school);
    paramContentValues.put("mRichFingerMemo", paramEntity.mRichFingerMemo);
    paramContentValues.put("troopmask", Integer.valueOf(paramEntity.troopmask));
    paramContentValues.put("trooptype", Integer.valueOf(paramEntity.trooptype));
    paramContentValues.put("troopCreateTime", Long.valueOf(paramEntity.troopCreateTime));
    paramContentValues.put("dwGroupFlag", Long.valueOf(paramEntity.dwGroupFlag));
    paramContentValues.put("cGroupOption", Short.valueOf(paramEntity.cGroupOption));
    paramContentValues.put("wMemberMax", Integer.valueOf(paramEntity.wMemberMax));
    paramContentValues.put("maxAdminNum", Integer.valueOf(paramEntity.maxAdminNum));
    paramContentValues.put("wSpecialClass", Integer.valueOf(paramEntity.wSpecialClass));
    paramContentValues.put("cGroupLevel", Short.valueOf(paramEntity.cGroupLevel));
    paramContentValues.put("wMemberNum", Integer.valueOf(paramEntity.wMemberNum));
    paramContentValues.put("wMemberNumClient", Integer.valueOf(paramEntity.wMemberNumClient));
    paramContentValues.put("Administrator", paramEntity.Administrator);
    paramContentValues.put("dwGroupClassExt", Long.valueOf(paramEntity.dwGroupClassExt));
    paramContentValues.put("mGroupClassExtText", paramEntity.mGroupClassExtText);
    paramContentValues.put("dwGroupFlagExt", Long.valueOf(paramEntity.dwGroupFlagExt));
    paramContentValues.put("dwAuthGroupType", Long.valueOf(paramEntity.dwAuthGroupType));
    paramContentValues.put("troopAuthenticateInfo", paramEntity.troopAuthenticateInfo);
    paramContentValues.put("dwGroupInfoSeq", Long.valueOf(paramEntity.dwGroupInfoSeq));
    paramContentValues.put("mMemberNumSeq", Long.valueOf(paramEntity.mMemberNumSeq));
    paramContentValues.put("mOldMemberNumSeq", Long.valueOf(paramEntity.mOldMemberNumSeq));
    paramContentValues.put("mMemberCardSeq", Long.valueOf(paramEntity.mMemberCardSeq));
    paramContentValues.put("mOldMemberCardSeq", Long.valueOf(paramEntity.mOldMemberCardSeq));
    paramContentValues.put("dwGroupLevelSeq", Long.valueOf(paramEntity.dwGroupLevelSeq));
    paramContentValues.put("cGroupRankSysFlag", Byte.valueOf(paramEntity.cGroupRankSysFlag));
    paramContentValues.put("cGroupRankUserFlag", Byte.valueOf(paramEntity.cGroupRankUserFlag));
    paramContentValues.put("cNewGroupRankUserFlag", Byte.valueOf(paramEntity.cNewGroupRankUserFlag));
    paramContentValues.put("troopLevelMap", paramEntity.troopLevelMap);
    paramContentValues.put("newTroopLevelMap", paramEntity.newTroopLevelMap);
    paramContentValues.put("joinTroopQuestion", paramEntity.joinTroopQuestion);
    paramContentValues.put("joinTroopAnswer", paramEntity.joinTroopAnswer);
    paramContentValues.put("cAlbumResult", Byte.valueOf(paramEntity.cAlbumResult));
    paramContentValues.put("dwTimeStamp", Long.valueOf(paramEntity.dwTimeStamp));
    paramContentValues.put("strQZonePhotoUrls", paramEntity.strQZonePhotoUrls);
    paramContentValues.put("mQZonePhotoNum", Integer.valueOf(paramEntity.mQZonePhotoNum));
    paramContentValues.put("strLocation", paramEntity.strLocation);
    paramContentValues.put("troopLat", Integer.valueOf(paramEntity.troopLat));
    paramContentValues.put("troopLon", Integer.valueOf(paramEntity.troopLon));
    paramContentValues.put("mMemberInvitingFlag", Boolean.valueOf(paramEntity.mMemberInvitingFlag));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramEntity.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramEntity.mCompareSpell);
    paramContentValues.put("mSomeMemberUins", paramEntity.mSomeMemberUins);
    paramContentValues.put("mHeaderUinsOld", paramEntity.mHeaderUinsOld);
    paramContentValues.put("mHeaderUinsNew", paramEntity.mHeaderUinsNew);
    paramContentValues.put("mTags", paramEntity.mTags);
    paramContentValues.put("mTroopAvatarId", Integer.valueOf(paramEntity.mTroopAvatarId));
    paramContentValues.put("mTroopPicListJson", paramEntity.mTroopPicListJson);
    paramContentValues.put("nTroopGrade", Integer.valueOf(paramEntity.nTroopGrade));
    paramContentValues.put("isShowInNearbyTroops", Integer.valueOf(paramEntity.isShowInNearbyTroops));
    paramContentValues.put("dwGagTimeStamp", Long.valueOf(paramEntity.dwGagTimeStamp));
    paramContentValues.put("dwGagTimeStamp_me", Long.valueOf(paramEntity.dwGagTimeStamp_me));
    paramContentValues.put("dwCmdUinUinFlag", Long.valueOf(paramEntity.dwCmdUinUinFlag));
    paramContentValues.put("dwAdditionalFlag", Long.valueOf(paramEntity.dwAdditionalFlag));
    paramContentValues.put("troopTypeExt", Integer.valueOf(paramEntity.troopTypeExt));
    paramContentValues.put("ownerNameShow", paramEntity.ownerNameShow);
    paramContentValues.put("adminNameShow", paramEntity.adminNameShow);
    paramContentValues.put("dwOfficeMode", Long.valueOf(paramEntity.dwOfficeMode));
    paramContentValues.put("dwGroupFlagExt3", Long.valueOf(paramEntity.dwGroupFlagExt3));
    paramContentValues.put("dwGroupFlagExt4", Long.valueOf(paramEntity.dwGroupFlagExt4));
    paramContentValues.put("cmdUinFlagEx2", Long.valueOf(paramEntity.cmdUinFlagEx2));
    paramContentValues.put("udwCmdUinRingtoneID", Long.valueOf(paramEntity.udwCmdUinRingtoneID));
    paramContentValues.put("memberListToShow", paramEntity.memberListToShow);
    paramContentValues.put("troopPrivilegeFlag", Long.valueOf(paramEntity.troopPrivilegeFlag));
    paramContentValues.put("isNewTroop", Boolean.valueOf(paramEntity.isNewTroop));
    paramContentValues.put("hasSetNewTroopHead", Boolean.valueOf(paramEntity.hasSetNewTroopHead));
    paramContentValues.put("hasSetNewTroopName", Boolean.valueOf(paramEntity.hasSetNewTroopName));
    paramContentValues.put("maxInviteMemNum", Integer.valueOf(paramEntity.maxInviteMemNum));
    paramContentValues.put("lastMsgTime", Long.valueOf(paramEntity.lastMsgTime));
    paramContentValues.put("allowMemberModifTroopName", Integer.valueOf(paramEntity.allowMemberModifTroopName));
    paramContentValues.put("allowMemberKick", Integer.valueOf(paramEntity.allowMemberKick));
    paramContentValues.put("allowMemberAtAll", Integer.valueOf(paramEntity.allowMemberAtAll));
    paramContentValues.put("oldTroopName", paramEntity.oldTroopName);
    paramContentValues.put("hlGuildAppid", Long.valueOf(paramEntity.hlGuildAppid));
    paramContentValues.put("hlGuildSubType", Long.valueOf(paramEntity.hlGuildSubType));
    paramContentValues.put("hlGuildOrgid", Integer.valueOf(paramEntity.hlGuildOrgid));
    paramContentValues.put("hlGuildBinary", Integer.valueOf(paramEntity.hlGuildBinary));
    paramContentValues.put("gameSwitchStatus", Integer.valueOf(paramEntity.gameSwitchStatus));
    paramContentValues.put("showGameSwitchStatus", Integer.valueOf(paramEntity.showGameSwitchStatus));
    paramContentValues.put("lastShareLbsMsgUniseq", Long.valueOf(paramEntity.lastShareLbsMsgUniseq));
    paramContentValues.put("mTroopNeedPayNumber", Float.valueOf(paramEntity.mTroopNeedPayNumber));
    paramContentValues.put("troopCreditLevel", Long.valueOf(paramEntity.troopCreditLevel));
    paramContentValues.put("troopCreditLevelInfo", Long.valueOf(paramEntity.troopCreditLevelInfo));
    paramContentValues.put("isTroopBlocked", Boolean.valueOf(paramEntity.isTroopBlocked));
    paramContentValues.put("appealDeadline", Long.valueOf(paramEntity.appealDeadline));
    paramContentValues.put("dwAppPrivilegeFlag", Long.valueOf(paramEntity.dwAppPrivilegeFlag));
    paramContentValues.put("topicId", paramEntity.topicId);
    paramContentValues.put("associatePubAccount", Long.valueOf(paramEntity.associatePubAccount));
    paramContentValues.put("mTroopFileVideoReqInterval", Long.valueOf(paramEntity.mTroopFileVideoReqInterval));
    paramContentValues.put("mTroopFileVideoIsWhite", Integer.valueOf(paramEntity.mTroopFileVideoIsWhite));
    paramContentValues.put("mTribeStatus", Integer.valueOf(paramEntity.mTribeStatus));
    paramContentValues.put("mCanSearchByKeywords", Boolean.valueOf(paramEntity.mCanSearchByKeywords));
    paramContentValues.put("mCanSearchByTroopUin", Boolean.valueOf(paramEntity.mCanSearchByTroopUin));
    paramContentValues.put("dwCmdUinJoinTime", Long.valueOf(paramEntity.dwCmdUinJoinTime));
    paramContentValues.put("dwLastInsertBAFTipTime", Long.valueOf(paramEntity.dwLastInsertBAFTipTime));
    paramContentValues.put("wInsertBAFTipCount", Integer.valueOf(paramEntity.wInsertBAFTipCount));
    paramContentValues.put("wClickBAFTipCount", Integer.valueOf(paramEntity.wClickBAFTipCount));
    paramContentValues.put("dwLastBAFTipMsgUniSeq", Long.valueOf(paramEntity.dwLastBAFTipMsgUniSeq));
    paramContentValues.put("dwLastBAFTipMsgUniSeq2", Long.valueOf(paramEntity.dwLastBAFTipMsgUniSeq2));
    paramContentValues.put("dailyNewMemberUins", paramEntity.dailyNewMemberUins);
    paramContentValues.put("exitTroopReason", Integer.valueOf(paramEntity.exitTroopReason));
    paramContentValues.put("eliminated", Integer.valueOf(paramEntity.eliminated));
    paramContentValues.put("mIsFreezed", Integer.valueOf(paramEntity.mIsFreezed));
    paramContentValues.put("strLastAnnouncement", paramEntity.strLastAnnouncement);
    paramContentValues.put("nMsgLimitFreq", Integer.valueOf(paramEntity.nMsgLimitFreq));
    paramContentValues.put("mAtOrReplyMeUins", paramEntity.mAtOrReplyMeUins);
    paramContentValues.put("groupFlagExt4", Integer.valueOf(paramEntity.groupFlagExt4));
    paramContentValues.put("groupFreezeReason", Integer.valueOf(paramEntity.groupFreezeReason));
    paramContentValues.put("troopHonorGrayFlag", Integer.valueOf(paramEntity.troopHonorGrayFlag));
    paramContentValues.put("isAllowHistoryMsgFlag", Integer.valueOf(paramEntity.isAllowHistoryMsgFlag));
    paramContentValues.put("troopRepeatType", Integer.valueOf(paramEntity.troopRepeatType));
    paramContentValues.put("feeds_id", paramEntity.feeds_id);
    paramContentValues.put("myHonorList", paramEntity.myHonorList);
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,timeSec INTEGER ,troopuin TEXT UNIQUE ,troopcode TEXT ,troopowneruin TEXT ,troopname TEXT ,newTroopName TEXT ,newTroopNameTimeStamp INTEGER ,troopface INTEGER ,troopmemo TEXT ,fingertroopmemo TEXT ,location TEXT ,grade INTEGER ,school TEXT ,mRichFingerMemo TEXT ,troopmask INTEGER ,trooptype INTEGER ,troopCreateTime INTEGER ,dwGroupFlag INTEGER ,cGroupOption INTEGER ,wMemberMax INTEGER ,maxAdminNum INTEGER ,wSpecialClass INTEGER ,cGroupLevel INTEGER ,wMemberNum INTEGER ,wMemberNumClient INTEGER ,Administrator TEXT ,dwGroupClassExt INTEGER ,mGroupClassExtText TEXT ,dwGroupFlagExt INTEGER ,dwAuthGroupType INTEGER ,troopAuthenticateInfo TEXT ,dwGroupInfoSeq INTEGER ,mMemberNumSeq INTEGER ,mOldMemberNumSeq INTEGER ,mMemberCardSeq INTEGER ,mOldMemberCardSeq INTEGER ,dwGroupLevelSeq INTEGER ,cGroupRankSysFlag INTEGER ,cGroupRankUserFlag INTEGER ,cNewGroupRankUserFlag INTEGER ,troopLevelMap TEXT ,newTroopLevelMap TEXT ,joinTroopQuestion TEXT ,joinTroopAnswer TEXT ,cAlbumResult INTEGER ,dwTimeStamp INTEGER ,strQZonePhotoUrls TEXT ,mQZonePhotoNum INTEGER ,strLocation TEXT ,troopLat INTEGER ,troopLon INTEGER ,mMemberInvitingFlag INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,mSomeMemberUins TEXT ,mHeaderUinsOld TEXT ,mHeaderUinsNew TEXT ,mTags TEXT ,mTroopAvatarId INTEGER ,mTroopPicListJson TEXT ,nTroopGrade INTEGER ,isShowInNearbyTroops INTEGER ,dwGagTimeStamp INTEGER ,dwGagTimeStamp_me INTEGER ,dwCmdUinUinFlag INTEGER ,dwAdditionalFlag INTEGER ,troopTypeExt INTEGER ,ownerNameShow TEXT ,adminNameShow TEXT ,dwOfficeMode INTEGER ,dwGroupFlagExt3 INTEGER ,dwGroupFlagExt4 INTEGER ,cmdUinFlagEx2 INTEGER ,udwCmdUinRingtoneID INTEGER ,memberListToShow TEXT ,troopPrivilegeFlag INTEGER ,isNewTroop INTEGER ,hasSetNewTroopHead INTEGER ,hasSetNewTroopName INTEGER ,maxInviteMemNum INTEGER ,lastMsgTime INTEGER ,allowMemberModifTroopName INTEGER ,allowMemberKick INTEGER ,allowMemberAtAll INTEGER ,oldTroopName TEXT ,hlGuildAppid INTEGER ,hlGuildSubType INTEGER ,hlGuildOrgid INTEGER ,hlGuildBinary INTEGER ,gameSwitchStatus INTEGER ,showGameSwitchStatus INTEGER ,lastShareLbsMsgUniseq INTEGER ,mTroopNeedPayNumber REAL ,troopCreditLevel INTEGER ,troopCreditLevelInfo INTEGER ,isTroopBlocked INTEGER ,appealDeadline INTEGER ,dwAppPrivilegeFlag INTEGER ,topicId TEXT ,associatePubAccount INTEGER ,mTroopFileVideoReqInterval INTEGER ,mTroopFileVideoIsWhite INTEGER ,mTribeStatus INTEGER ,mCanSearchByKeywords INTEGER ,mCanSearchByTroopUin INTEGER ,dwCmdUinJoinTime INTEGER ,dwLastInsertBAFTipTime INTEGER ,wInsertBAFTipCount INTEGER ,wClickBAFTipCount INTEGER ,dwLastBAFTipMsgUniSeq INTEGER ,dwLastBAFTipMsgUniSeq2 INTEGER ,dailyNewMemberUins TEXT ,exitTroopReason INTEGER ,eliminated INTEGER ,mIsFreezed INTEGER ,strLastAnnouncement TEXT ,nMsgLimitFreq INTEGER ,mAtOrReplyMeUins TEXT ,groupFlagExt4 INTEGER ,groupFreezeReason INTEGER ,troopHonorGrayFlag INTEGER ,isAllowHistoryMsgFlag INTEGER ,troopRepeatType INTEGER ,feeds_id TEXT ,myHonorList TEXT)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azom
 * JD-Core Version:    0.7.0.1
 */