import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class ayvz
  extends OGAbstractDao
{
  public ayvz()
  {
    this.columnLen = 120;
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
        paramEntity.cmdUinFlagEx2 = paramCursor.getLong(paramCursor.getColumnIndex("cmdUinFlagEx2"));
        paramEntity.udwCmdUinRingtoneID = paramCursor.getLong(paramCursor.getColumnIndex("udwCmdUinRingtoneID"));
        paramEntity.memberListToShow = paramCursor.getString(paramCursor.getColumnIndex("memberListToShow"));
        paramEntity.troopPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("troopPrivilegeFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isNewTroop"))) {
          break label2297;
        }
        paramBoolean = true;
        label1382:
        paramEntity.isNewTroop = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSetNewTroopHead"))) {
          break label2302;
        }
        paramBoolean = true;
        label1408:
        paramEntity.hasSetNewTroopHead = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSetNewTroopName"))) {
          break label2307;
        }
        paramBoolean = true;
        label1434:
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
        paramEntity.dwAppPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAppPrivilegeFlag"));
        paramEntity.topicId = paramCursor.getString(paramCursor.getColumnIndex("topicId"));
        paramEntity.associatePubAccount = paramCursor.getLong(paramCursor.getColumnIndex("associatePubAccount"));
        paramEntity.mTroopFileVideoReqInterval = paramCursor.getLong(paramCursor.getColumnIndex("mTroopFileVideoReqInterval"));
        paramEntity.mTroopFileVideoIsWhite = paramCursor.getInt(paramCursor.getColumnIndex("mTroopFileVideoIsWhite"));
        paramEntity.mTribeStatus = paramCursor.getInt(paramCursor.getColumnIndex("mTribeStatus"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mCanSearchByKeywords"))) {
          break label2312;
        }
        paramBoolean = true;
        label1878:
        paramEntity.mCanSearchByKeywords = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mCanSearchByTroopUin"))) {
          break label2317;
        }
      }
      label2307:
      label2312:
      label2317:
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
        label2297:
        paramBoolean = false;
        break label1382;
        label2302:
        paramBoolean = false;
        break label1408;
        paramBoolean = false;
        break label1434;
        paramBoolean = false;
        break label1878;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("timeSec");
      if (i != -1) {
        break label6673;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("timeSec", Long.TYPE));
      label2392:
      i = paramCursor.getColumnIndex("troopuin");
      if (i != -1) {
        break label6688;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopuin", String.class));
      label2427:
      i = paramCursor.getColumnIndex("troopcode");
      if (i != -1) {
        break label6703;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopcode", String.class));
      label2462:
      i = paramCursor.getColumnIndex("troopowneruin");
      if (i != -1) {
        break label6718;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopowneruin", String.class));
      label2497:
      i = paramCursor.getColumnIndex("troopname");
      if (i != -1) {
        break label6733;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopname", String.class));
      label2532:
      i = paramCursor.getColumnIndex("newTroopName");
      if (i != -1) {
        break label6748;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("newTroopName", String.class));
      label2567:
      i = paramCursor.getColumnIndex("newTroopNameTimeStamp");
      if (i != -1) {
        break label6763;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("newTroopNameTimeStamp", Long.TYPE));
      label2602:
      i = paramCursor.getColumnIndex("troopface");
      if (i != -1) {
        break label6778;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopface", Short.TYPE));
      label2637:
      i = paramCursor.getColumnIndex("troopmemo");
      if (i != -1) {
        break label6793;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopmemo", String.class));
      label2672:
      i = paramCursor.getColumnIndex("fingertroopmemo");
      if (i != -1) {
        break label6808;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("fingertroopmemo", String.class));
      label2707:
      i = paramCursor.getColumnIndex("mRichFingerMemo");
      if (i != -1) {
        break label6823;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mRichFingerMemo", String.class));
      label2742:
      i = paramCursor.getColumnIndex("troopmask");
      if (i != -1) {
        break label6838;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopmask", Integer.TYPE));
      label2777:
      i = paramCursor.getColumnIndex("trooptype");
      if (i != -1) {
        break label6853;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("trooptype", Integer.TYPE));
      label2812:
      i = paramCursor.getColumnIndex("troopCreateTime");
      if (i != -1) {
        break label6868;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopCreateTime", Long.TYPE));
      label2847:
      i = paramCursor.getColumnIndex("dwGroupFlag");
      if (i != -1) {
        break label6883;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGroupFlag", Long.TYPE));
      label2882:
      i = paramCursor.getColumnIndex("cGroupOption");
      if (i != -1) {
        break label6898;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cGroupOption", Short.TYPE));
      label2917:
      i = paramCursor.getColumnIndex("wMemberMax");
      if (i != -1) {
        break label6913;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wMemberMax", Integer.TYPE));
      label2952:
      i = paramCursor.getColumnIndex("maxAdminNum");
      if (i != -1) {
        break label6928;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("maxAdminNum", Integer.TYPE));
      label2987:
      i = paramCursor.getColumnIndex("wSpecialClass");
      if (i != -1) {
        break label6943;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wSpecialClass", Integer.TYPE));
      label3022:
      i = paramCursor.getColumnIndex("cGroupLevel");
      if (i != -1) {
        break label6958;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cGroupLevel", Short.TYPE));
      label3057:
      i = paramCursor.getColumnIndex("wMemberNum");
      if (i != -1) {
        break label6973;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wMemberNum", Integer.TYPE));
      label3092:
      i = paramCursor.getColumnIndex("wMemberNumClient");
      if (i != -1) {
        break label6988;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wMemberNumClient", Integer.TYPE));
      label3127:
      i = paramCursor.getColumnIndex("Administrator");
      if (i != -1) {
        break label7003;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("Administrator", String.class));
      label3162:
      i = paramCursor.getColumnIndex("dwGroupClassExt");
      if (i != -1) {
        break label7018;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGroupClassExt", Long.TYPE));
      label3197:
      i = paramCursor.getColumnIndex("mGroupClassExtText");
      if (i != -1) {
        break label7033;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mGroupClassExtText", String.class));
      label3232:
      i = paramCursor.getColumnIndex("dwGroupFlagExt");
      if (i != -1) {
        break label7048;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGroupFlagExt", Long.TYPE));
      label3267:
      i = paramCursor.getColumnIndex("dwAuthGroupType");
      if (i != -1) {
        break label7063;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwAuthGroupType", Long.TYPE));
      label3302:
      i = paramCursor.getColumnIndex("troopAuthenticateInfo");
      if (i != -1) {
        break label7078;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopAuthenticateInfo", String.class));
      label3337:
      i = paramCursor.getColumnIndex("dwGroupInfoSeq");
      if (i != -1) {
        break label7093;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGroupInfoSeq", Long.TYPE));
      label3372:
      i = paramCursor.getColumnIndex("mMemberNumSeq");
      if (i != -1) {
        break label7108;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mMemberNumSeq", Long.TYPE));
      label3407:
      i = paramCursor.getColumnIndex("mOldMemberNumSeq");
      if (i != -1) {
        break label7123;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mOldMemberNumSeq", Long.TYPE));
      label3442:
      i = paramCursor.getColumnIndex("mMemberCardSeq");
      if (i != -1) {
        break label7138;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mMemberCardSeq", Long.TYPE));
      label3477:
      i = paramCursor.getColumnIndex("mOldMemberCardSeq");
      if (i != -1) {
        break label7153;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mOldMemberCardSeq", Long.TYPE));
      label3512:
      i = paramCursor.getColumnIndex("dwGroupLevelSeq");
      if (i != -1) {
        break label7168;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGroupLevelSeq", Long.TYPE));
      label3547:
      i = paramCursor.getColumnIndex("cGroupRankSysFlag");
      if (i != -1) {
        break label7183;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cGroupRankSysFlag", Byte.TYPE));
      label3582:
      i = paramCursor.getColumnIndex("cGroupRankUserFlag");
      if (i != -1) {
        break label7199;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cGroupRankUserFlag", Byte.TYPE));
      label3617:
      i = paramCursor.getColumnIndex("cNewGroupRankUserFlag");
      if (i != -1) {
        break label7215;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cNewGroupRankUserFlag", Byte.TYPE));
      label3652:
      i = paramCursor.getColumnIndex("troopLevelMap");
      if (i != -1) {
        break label7231;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopLevelMap", String.class));
      label3687:
      i = paramCursor.getColumnIndex("newTroopLevelMap");
      if (i != -1) {
        break label7246;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("newTroopLevelMap", String.class));
      label3722:
      i = paramCursor.getColumnIndex("joinTroopQuestion");
      if (i != -1) {
        break label7261;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("joinTroopQuestion", String.class));
      label3757:
      i = paramCursor.getColumnIndex("joinTroopAnswer");
      if (i != -1) {
        break label7276;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("joinTroopAnswer", String.class));
      label3792:
      i = paramCursor.getColumnIndex("cAlbumResult");
      if (i != -1) {
        break label7291;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cAlbumResult", Byte.TYPE));
      label3827:
      i = paramCursor.getColumnIndex("dwTimeStamp");
      if (i != -1) {
        break label7307;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwTimeStamp", Long.TYPE));
      label3862:
      i = paramCursor.getColumnIndex("strQZonePhotoUrls");
      if (i != -1) {
        break label7322;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strQZonePhotoUrls", String.class));
      label3897:
      i = paramCursor.getColumnIndex("mQZonePhotoNum");
      if (i != -1) {
        break label7337;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mQZonePhotoNum", Integer.TYPE));
      label3932:
      i = paramCursor.getColumnIndex("strLocation");
      if (i != -1) {
        break label7352;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strLocation", String.class));
      label3967:
      i = paramCursor.getColumnIndex("troopLat");
      if (i != -1) {
        break label7367;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopLat", Integer.TYPE));
      label4002:
      i = paramCursor.getColumnIndex("troopLon");
      if (i != -1) {
        break label7382;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopLon", Integer.TYPE));
      label4037:
      i = paramCursor.getColumnIndex("mMemberInvitingFlag");
      if (i != -1) {
        break label7397;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mMemberInvitingFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label7424;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mComparePartInt", Integer.TYPE));
      label4107:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label7439;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mCompareSpell", String.class));
      label4142:
      i = paramCursor.getColumnIndex("mSomeMemberUins");
      if (i != -1) {
        break label7454;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mSomeMemberUins", String.class));
      label4177:
      i = paramCursor.getColumnIndex("mHeaderUinsOld");
      if (i != -1) {
        break label7469;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mHeaderUinsOld", String.class));
      label4214:
      i = paramCursor.getColumnIndex("mHeaderUinsNew");
      if (i != -1) {
        break label7484;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mHeaderUinsNew", String.class));
      label4251:
      i = paramCursor.getColumnIndex("mTags");
      if (i != -1) {
        break label7499;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTags", String.class));
      label4288:
      i = paramCursor.getColumnIndex("mTroopAvatarId");
      if (i != -1) {
        break label7514;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTroopAvatarId", Integer.TYPE));
      label4325:
      i = paramCursor.getColumnIndex("mTroopPicListJson");
      if (i != -1) {
        break label7529;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTroopPicListJson", String.class));
      label4362:
      i = paramCursor.getColumnIndex("nTroopGrade");
      if (i != -1) {
        break label7544;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nTroopGrade", Integer.TYPE));
      label4399:
      i = paramCursor.getColumnIndex("isShowInNearbyTroops");
      if (i != -1) {
        break label7559;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isShowInNearbyTroops", Integer.TYPE));
      label4436:
      i = paramCursor.getColumnIndex("dwGagTimeStamp");
      if (i != -1) {
        break label7574;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGagTimeStamp", Long.TYPE));
      label4473:
      i = paramCursor.getColumnIndex("dwGagTimeStamp_me");
      if (i != -1) {
        break label7589;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGagTimeStamp_me", Long.TYPE));
      label4510:
      i = paramCursor.getColumnIndex("dwCmdUinUinFlag");
      if (i != -1) {
        break label7604;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwCmdUinUinFlag", Long.TYPE));
      label4547:
      i = paramCursor.getColumnIndex("dwAdditionalFlag");
      if (i != -1) {
        break label7619;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwAdditionalFlag", Long.TYPE));
      label4584:
      i = paramCursor.getColumnIndex("troopTypeExt");
      if (i != -1) {
        break label7634;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopTypeExt", Integer.TYPE));
      label4621:
      i = paramCursor.getColumnIndex("ownerNameShow");
      if (i != -1) {
        break label7649;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ownerNameShow", String.class));
      label4658:
      i = paramCursor.getColumnIndex("adminNameShow");
      if (i != -1) {
        break label7664;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("adminNameShow", String.class));
      label4695:
      i = paramCursor.getColumnIndex("dwOfficeMode");
      if (i != -1) {
        break label7679;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwOfficeMode", Long.TYPE));
      label4732:
      i = paramCursor.getColumnIndex("dwGroupFlagExt3");
      if (i != -1) {
        break label7694;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwGroupFlagExt3", Long.TYPE));
      label4769:
      i = paramCursor.getColumnIndex("cmdUinFlagEx2");
      if (i != -1) {
        break label7709;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cmdUinFlagEx2", Long.TYPE));
      label4806:
      i = paramCursor.getColumnIndex("udwCmdUinRingtoneID");
      if (i != -1) {
        break label7724;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("udwCmdUinRingtoneID", Long.TYPE));
      label4843:
      i = paramCursor.getColumnIndex("memberListToShow");
      if (i != -1) {
        break label7739;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("memberListToShow", String.class));
      label4880:
      i = paramCursor.getColumnIndex("troopPrivilegeFlag");
      if (i != -1) {
        break label7754;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopPrivilegeFlag", Long.TYPE));
      label4917:
      i = paramCursor.getColumnIndex("isNewTroop");
      if (i != -1) {
        break label7769;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isNewTroop", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasSetNewTroopHead");
      if (i != -1) {
        break label7796;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasSetNewTroopHead", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasSetNewTroopName");
      if (i != -1) {
        break label7823;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasSetNewTroopName", Boolean.TYPE));
      i = paramCursor.getColumnIndex("maxInviteMemNum");
      if (i != -1) {
        break label7850;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("maxInviteMemNum", Integer.TYPE));
      label5065:
      i = paramCursor.getColumnIndex("lastMsgTime");
      if (i != -1) {
        break label7865;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastMsgTime", Long.TYPE));
      label5102:
      i = paramCursor.getColumnIndex("allowMemberModifTroopName");
      if (i != -1) {
        break label7880;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowMemberModifTroopName", Integer.TYPE));
      label5139:
      i = paramCursor.getColumnIndex("allowMemberKick");
      if (i != -1) {
        break label7895;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowMemberKick", Integer.TYPE));
      label5176:
      i = paramCursor.getColumnIndex("allowMemberAtAll");
      if (i != -1) {
        break label7910;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("allowMemberAtAll", Integer.TYPE));
      label5213:
      i = paramCursor.getColumnIndex("oldTroopName");
      if (i != -1) {
        break label7925;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("oldTroopName", String.class));
      label5250:
      i = paramCursor.getColumnIndex("hlGuildAppid");
      if (i != -1) {
        break label7940;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hlGuildAppid", Long.TYPE));
      label5287:
      i = paramCursor.getColumnIndex("hlGuildSubType");
      if (i != -1) {
        break label7955;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hlGuildSubType", Long.TYPE));
      label5324:
      i = paramCursor.getColumnIndex("hlGuildOrgid");
      if (i != -1) {
        break label7970;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hlGuildOrgid", Integer.TYPE));
      label5361:
      i = paramCursor.getColumnIndex("hlGuildBinary");
      if (i != -1) {
        break label7985;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hlGuildBinary", Integer.TYPE));
      label5398:
      i = paramCursor.getColumnIndex("gameSwitchStatus");
      if (i != -1) {
        break label8000;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("gameSwitchStatus", Integer.TYPE));
      label5435:
      i = paramCursor.getColumnIndex("showGameSwitchStatus");
      if (i != -1) {
        break label8015;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showGameSwitchStatus", Integer.TYPE));
      label5472:
      i = paramCursor.getColumnIndex("lastShareLbsMsgUniseq");
      if (i != -1) {
        break label8030;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastShareLbsMsgUniseq", Long.TYPE));
      label5509:
      i = paramCursor.getColumnIndex("mTroopNeedPayNumber");
      if (i != -1) {
        break label8045;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTroopNeedPayNumber", Float.TYPE));
      label5546:
      i = paramCursor.getColumnIndex("troopCreditLevel");
      if (i != -1) {
        break label8060;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopCreditLevel", Long.TYPE));
      label5583:
      i = paramCursor.getColumnIndex("troopCreditLevelInfo");
      if (i != -1) {
        break label8075;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopCreditLevelInfo", Long.TYPE));
      label5620:
      i = paramCursor.getColumnIndex("dwAppPrivilegeFlag");
      if (i != -1) {
        break label8090;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwAppPrivilegeFlag", Long.TYPE));
      label5657:
      i = paramCursor.getColumnIndex("topicId");
      if (i != -1) {
        break label8105;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("topicId", String.class));
      label5694:
      i = paramCursor.getColumnIndex("associatePubAccount");
      if (i != -1) {
        break label8120;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("associatePubAccount", Long.TYPE));
      label5731:
      i = paramCursor.getColumnIndex("mTroopFileVideoReqInterval");
      if (i != -1) {
        break label8135;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTroopFileVideoReqInterval", Long.TYPE));
      label5768:
      i = paramCursor.getColumnIndex("mTroopFileVideoIsWhite");
      if (i != -1) {
        break label8150;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTroopFileVideoIsWhite", Integer.TYPE));
      label5805:
      i = paramCursor.getColumnIndex("mTribeStatus");
      if (i != -1) {
        break label8165;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTribeStatus", Integer.TYPE));
      label5842:
      i = paramCursor.getColumnIndex("mCanSearchByKeywords");
      if (i != -1) {
        break label8180;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mCanSearchByKeywords", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mCanSearchByTroopUin");
      if (i != -1) {
        break label8207;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mCanSearchByTroopUin", Boolean.TYPE));
      i = paramCursor.getColumnIndex("dwCmdUinJoinTime");
      if (i != -1) {
        break label8235;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwCmdUinJoinTime", Long.TYPE));
      label5953:
      i = paramCursor.getColumnIndex("dwLastInsertBAFTipTime");
      if (i != -1) {
        break label8250;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwLastInsertBAFTipTime", Long.TYPE));
      label5990:
      i = paramCursor.getColumnIndex("wInsertBAFTipCount");
      if (i != -1) {
        break label8265;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wInsertBAFTipCount", Integer.TYPE));
      label6027:
      i = paramCursor.getColumnIndex("wClickBAFTipCount");
      if (i != -1) {
        break label8280;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wClickBAFTipCount", Integer.TYPE));
      label6064:
      i = paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq");
      if (i != -1) {
        break label8295;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwLastBAFTipMsgUniSeq", Long.TYPE));
      label6101:
      i = paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq2");
      if (i != -1) {
        break label8310;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dwLastBAFTipMsgUniSeq2", Long.TYPE));
      label6138:
      i = paramCursor.getColumnIndex("dailyNewMemberUins");
      if (i != -1) {
        break label8325;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dailyNewMemberUins", String.class));
      label6175:
      i = paramCursor.getColumnIndex("exitTroopReason");
      if (i != -1) {
        break label8340;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("exitTroopReason", Integer.TYPE));
      label6212:
      i = paramCursor.getColumnIndex("eliminated");
      if (i != -1) {
        break label8355;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("eliminated", Integer.TYPE));
      label6249:
      i = paramCursor.getColumnIndex("mIsFreezed");
      if (i != -1) {
        break label8370;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mIsFreezed", Integer.TYPE));
      label6286:
      i = paramCursor.getColumnIndex("strLastAnnouncement");
      if (i != -1) {
        break label8385;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strLastAnnouncement", String.class));
      label6323:
      i = paramCursor.getColumnIndex("nMsgLimitFreq");
      if (i != -1) {
        break label8400;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nMsgLimitFreq", Integer.TYPE));
      label6360:
      i = paramCursor.getColumnIndex("mAtOrReplyMeUins");
      if (i != -1) {
        break label8415;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mAtOrReplyMeUins", String.class));
      label6397:
      i = paramCursor.getColumnIndex("groupFlagExt4");
      if (i != -1) {
        break label8430;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("groupFlagExt4", Integer.TYPE));
      label6434:
      i = paramCursor.getColumnIndex("groupFreezeReason");
      if (i != -1) {
        break label8445;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("groupFreezeReason", Integer.TYPE));
      label6471:
      i = paramCursor.getColumnIndex("troopHonorGrayFlag");
      if (i != -1) {
        break label8460;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopHonorGrayFlag", Integer.TYPE));
      label6508:
      i = paramCursor.getColumnIndex("isAllowHistoryMsgFlag");
      if (i != -1) {
        break label8475;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isAllowHistoryMsgFlag", Integer.TYPE));
      label6545:
      i = paramCursor.getColumnIndex("troopRepeatType");
      if (i != -1) {
        break label8490;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopRepeatType", Integer.TYPE));
      label6582:
      i = paramCursor.getColumnIndex("feeds_id");
      if (i != -1) {
        break label8505;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("feeds_id", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("myHonorList");
      if (i != -1) {
        break label8520;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("myHonorList", String.class));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label6673:
      paramEntity.timeSec = paramCursor.getLong(i);
      break label2392;
      label6688:
      paramEntity.troopuin = paramCursor.getString(i);
      break label2427;
      label6703:
      paramEntity.troopcode = paramCursor.getString(i);
      break label2462;
      label6718:
      paramEntity.troopowneruin = paramCursor.getString(i);
      break label2497;
      label6733:
      paramEntity.troopname = paramCursor.getString(i);
      break label2532;
      label6748:
      paramEntity.newTroopName = paramCursor.getString(i);
      break label2567;
      label6763:
      paramEntity.newTroopNameTimeStamp = paramCursor.getLong(i);
      break label2602;
      label6778:
      paramEntity.troopface = paramCursor.getShort(i);
      break label2637;
      label6793:
      paramEntity.troopmemo = paramCursor.getString(i);
      break label2672;
      label6808:
      paramEntity.fingertroopmemo = paramCursor.getString(i);
      break label2707;
      label6823:
      paramEntity.mRichFingerMemo = paramCursor.getString(i);
      break label2742;
      label6838:
      paramEntity.troopmask = paramCursor.getInt(i);
      break label2777;
      label6853:
      paramEntity.trooptype = paramCursor.getInt(i);
      break label2812;
      label6868:
      paramEntity.troopCreateTime = paramCursor.getLong(i);
      break label2847;
      label6883:
      paramEntity.dwGroupFlag = paramCursor.getLong(i);
      break label2882;
      label6898:
      paramEntity.cGroupOption = paramCursor.getShort(i);
      break label2917;
      label6913:
      paramEntity.wMemberMax = paramCursor.getInt(i);
      break label2952;
      label6928:
      paramEntity.maxAdminNum = paramCursor.getInt(i);
      break label2987;
      label6943:
      paramEntity.wSpecialClass = paramCursor.getInt(i);
      break label3022;
      label6958:
      paramEntity.cGroupLevel = paramCursor.getShort(i);
      break label3057;
      label6973:
      paramEntity.wMemberNum = paramCursor.getInt(i);
      break label3092;
      label6988:
      paramEntity.wMemberNumClient = paramCursor.getInt(i);
      break label3127;
      label7003:
      paramEntity.Administrator = paramCursor.getString(i);
      break label3162;
      label7018:
      paramEntity.dwGroupClassExt = paramCursor.getLong(i);
      break label3197;
      label7033:
      paramEntity.mGroupClassExtText = paramCursor.getString(i);
      break label3232;
      label7048:
      paramEntity.dwGroupFlagExt = paramCursor.getLong(i);
      break label3267;
      label7063:
      paramEntity.dwAuthGroupType = paramCursor.getLong(i);
      break label3302;
      label7078:
      paramEntity.troopAuthenticateInfo = paramCursor.getString(i);
      break label3337;
      label7093:
      paramEntity.dwGroupInfoSeq = paramCursor.getLong(i);
      break label3372;
      label7108:
      paramEntity.mMemberNumSeq = paramCursor.getLong(i);
      break label3407;
      label7123:
      paramEntity.mOldMemberNumSeq = paramCursor.getLong(i);
      break label3442;
      label7138:
      paramEntity.mMemberCardSeq = paramCursor.getLong(i);
      break label3477;
      label7153:
      paramEntity.mOldMemberCardSeq = paramCursor.getLong(i);
      break label3512;
      label7168:
      paramEntity.dwGroupLevelSeq = paramCursor.getLong(i);
      break label3547;
      label7183:
      paramEntity.cGroupRankSysFlag = ((byte)paramCursor.getShort(i));
      break label3582;
      label7199:
      paramEntity.cGroupRankUserFlag = ((byte)paramCursor.getShort(i));
      break label3617;
      label7215:
      paramEntity.cNewGroupRankUserFlag = ((byte)paramCursor.getShort(i));
      break label3652;
      label7231:
      paramEntity.troopLevelMap = paramCursor.getString(i);
      break label3687;
      label7246:
      paramEntity.newTroopLevelMap = paramCursor.getString(i);
      break label3722;
      label7261:
      paramEntity.joinTroopQuestion = paramCursor.getString(i);
      break label3757;
      label7276:
      paramEntity.joinTroopAnswer = paramCursor.getString(i);
      break label3792;
      label7291:
      paramEntity.cAlbumResult = ((byte)paramCursor.getShort(i));
      break label3827;
      label7307:
      paramEntity.dwTimeStamp = paramCursor.getLong(i);
      break label3862;
      label7322:
      paramEntity.strQZonePhotoUrls = paramCursor.getString(i);
      break label3897;
      label7337:
      paramEntity.mQZonePhotoNum = paramCursor.getInt(i);
      break label3932;
      label7352:
      paramEntity.strLocation = paramCursor.getString(i);
      break label3967;
      label7367:
      paramEntity.troopLat = paramCursor.getInt(i);
      break label4002;
      label7382:
      paramEntity.troopLon = paramCursor.getInt(i);
      break label4037;
      label7397:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.mMemberInvitingFlag = paramBoolean;
        break;
      }
      label7424:
      paramEntity.mComparePartInt = paramCursor.getInt(i);
      break label4107;
      label7439:
      paramEntity.mCompareSpell = paramCursor.getString(i);
      break label4142;
      label7454:
      paramEntity.mSomeMemberUins = paramCursor.getString(i);
      break label4177;
      label7469:
      paramEntity.mHeaderUinsOld = paramCursor.getString(i);
      break label4214;
      label7484:
      paramEntity.mHeaderUinsNew = paramCursor.getString(i);
      break label4251;
      label7499:
      paramEntity.mTags = paramCursor.getString(i);
      break label4288;
      label7514:
      paramEntity.mTroopAvatarId = paramCursor.getInt(i);
      break label4325;
      label7529:
      paramEntity.mTroopPicListJson = paramCursor.getString(i);
      break label4362;
      label7544:
      paramEntity.nTroopGrade = paramCursor.getInt(i);
      break label4399;
      label7559:
      paramEntity.isShowInNearbyTroops = paramCursor.getInt(i);
      break label4436;
      label7574:
      paramEntity.dwGagTimeStamp = paramCursor.getLong(i);
      break label4473;
      label7589:
      paramEntity.dwGagTimeStamp_me = paramCursor.getLong(i);
      break label4510;
      label7604:
      paramEntity.dwCmdUinUinFlag = paramCursor.getLong(i);
      break label4547;
      label7619:
      paramEntity.dwAdditionalFlag = paramCursor.getLong(i);
      break label4584;
      label7634:
      paramEntity.troopTypeExt = paramCursor.getInt(i);
      break label4621;
      label7649:
      paramEntity.ownerNameShow = paramCursor.getString(i);
      break label4658;
      label7664:
      paramEntity.adminNameShow = paramCursor.getString(i);
      break label4695;
      label7679:
      paramEntity.dwOfficeMode = paramCursor.getLong(i);
      break label4732;
      label7694:
      paramEntity.dwGroupFlagExt3 = paramCursor.getLong(i);
      break label4769;
      label7709:
      paramEntity.cmdUinFlagEx2 = paramCursor.getLong(i);
      break label4806;
      label7724:
      paramEntity.udwCmdUinRingtoneID = paramCursor.getLong(i);
      break label4843;
      label7739:
      paramEntity.memberListToShow = paramCursor.getString(i);
      break label4880;
      label7754:
      paramEntity.troopPrivilegeFlag = paramCursor.getLong(i);
      break label4917;
      label7769:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isNewTroop = paramBoolean;
        break;
      }
      label7796:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasSetNewTroopHead = paramBoolean;
        break;
      }
      label7823:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasSetNewTroopName = paramBoolean;
        break;
      }
      label7850:
      paramEntity.maxInviteMemNum = paramCursor.getInt(i);
      break label5065;
      label7865:
      paramEntity.lastMsgTime = paramCursor.getLong(i);
      break label5102;
      label7880:
      paramEntity.allowMemberModifTroopName = paramCursor.getInt(i);
      break label5139;
      label7895:
      paramEntity.allowMemberKick = paramCursor.getInt(i);
      break label5176;
      label7910:
      paramEntity.allowMemberAtAll = paramCursor.getInt(i);
      break label5213;
      label7925:
      paramEntity.oldTroopName = paramCursor.getString(i);
      break label5250;
      label7940:
      paramEntity.hlGuildAppid = paramCursor.getLong(i);
      break label5287;
      label7955:
      paramEntity.hlGuildSubType = paramCursor.getLong(i);
      break label5324;
      label7970:
      paramEntity.hlGuildOrgid = paramCursor.getInt(i);
      break label5361;
      label7985:
      paramEntity.hlGuildBinary = paramCursor.getInt(i);
      break label5398;
      label8000:
      paramEntity.gameSwitchStatus = paramCursor.getInt(i);
      break label5435;
      label8015:
      paramEntity.showGameSwitchStatus = paramCursor.getInt(i);
      break label5472;
      label8030:
      paramEntity.lastShareLbsMsgUniseq = paramCursor.getLong(i);
      break label5509;
      label8045:
      paramEntity.mTroopNeedPayNumber = paramCursor.getFloat(i);
      break label5546;
      label8060:
      paramEntity.troopCreditLevel = paramCursor.getLong(i);
      break label5583;
      label8075:
      paramEntity.troopCreditLevelInfo = paramCursor.getLong(i);
      break label5620;
      label8090:
      paramEntity.dwAppPrivilegeFlag = paramCursor.getLong(i);
      break label5657;
      label8105:
      paramEntity.topicId = paramCursor.getString(i);
      break label5694;
      label8120:
      paramEntity.associatePubAccount = paramCursor.getLong(i);
      break label5731;
      label8135:
      paramEntity.mTroopFileVideoReqInterval = paramCursor.getLong(i);
      break label5768;
      label8150:
      paramEntity.mTroopFileVideoIsWhite = paramCursor.getInt(i);
      break label5805;
      label8165:
      paramEntity.mTribeStatus = paramCursor.getInt(i);
      break label5842;
      label8180:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.mCanSearchByKeywords = paramBoolean;
        break;
      }
      label8207:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.mCanSearchByTroopUin = paramBoolean;
        break;
      }
      label8235:
      paramEntity.dwCmdUinJoinTime = paramCursor.getLong(i);
      break label5953;
      label8250:
      paramEntity.dwLastInsertBAFTipTime = paramCursor.getLong(i);
      break label5990;
      label8265:
      paramEntity.wInsertBAFTipCount = paramCursor.getInt(i);
      break label6027;
      label8280:
      paramEntity.wClickBAFTipCount = paramCursor.getInt(i);
      break label6064;
      label8295:
      paramEntity.dwLastBAFTipMsgUniSeq = paramCursor.getLong(i);
      break label6101;
      label8310:
      paramEntity.dwLastBAFTipMsgUniSeq2 = paramCursor.getLong(i);
      break label6138;
      label8325:
      paramEntity.dailyNewMemberUins = paramCursor.getString(i);
      break label6175;
      label8340:
      paramEntity.exitTroopReason = paramCursor.getInt(i);
      break label6212;
      label8355:
      paramEntity.eliminated = paramCursor.getInt(i);
      break label6249;
      label8370:
      paramEntity.mIsFreezed = paramCursor.getInt(i);
      break label6286;
      label8385:
      paramEntity.strLastAnnouncement = paramCursor.getString(i);
      break label6323;
      label8400:
      paramEntity.nMsgLimitFreq = paramCursor.getInt(i);
      break label6360;
      label8415:
      paramEntity.mAtOrReplyMeUins = paramCursor.getString(i);
      break label6397;
      label8430:
      paramEntity.groupFlagExt4 = paramCursor.getInt(i);
      break label6434;
      label8445:
      paramEntity.groupFreezeReason = paramCursor.getInt(i);
      break label6471;
      label8460:
      paramEntity.troopHonorGrayFlag = paramCursor.getInt(i);
      break label6508;
      label8475:
      paramEntity.isAllowHistoryMsgFlag = paramCursor.getInt(i);
      break label6545;
      label8490:
      paramEntity.troopRepeatType = paramCursor.getInt(i);
      break label6582;
      label8505:
      paramEntity.feeds_id = paramCursor.getString(i);
    }
    label8520:
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
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,timeSec INTEGER ,troopuin TEXT UNIQUE ,troopcode TEXT ,troopowneruin TEXT ,troopname TEXT ,newTroopName TEXT ,newTroopNameTimeStamp INTEGER ,troopface INTEGER ,troopmemo TEXT ,fingertroopmemo TEXT ,mRichFingerMemo TEXT ,troopmask INTEGER ,trooptype INTEGER ,troopCreateTime INTEGER ,dwGroupFlag INTEGER ,cGroupOption INTEGER ,wMemberMax INTEGER ,maxAdminNum INTEGER ,wSpecialClass INTEGER ,cGroupLevel INTEGER ,wMemberNum INTEGER ,wMemberNumClient INTEGER ,Administrator TEXT ,dwGroupClassExt INTEGER ,mGroupClassExtText TEXT ,dwGroupFlagExt INTEGER ,dwAuthGroupType INTEGER ,troopAuthenticateInfo TEXT ,dwGroupInfoSeq INTEGER ,mMemberNumSeq INTEGER ,mOldMemberNumSeq INTEGER ,mMemberCardSeq INTEGER ,mOldMemberCardSeq INTEGER ,dwGroupLevelSeq INTEGER ,cGroupRankSysFlag INTEGER ,cGroupRankUserFlag INTEGER ,cNewGroupRankUserFlag INTEGER ,troopLevelMap TEXT ,newTroopLevelMap TEXT ,joinTroopQuestion TEXT ,joinTroopAnswer TEXT ,cAlbumResult INTEGER ,dwTimeStamp INTEGER ,strQZonePhotoUrls TEXT ,mQZonePhotoNum INTEGER ,strLocation TEXT ,troopLat INTEGER ,troopLon INTEGER ,mMemberInvitingFlag INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,mSomeMemberUins TEXT ,mHeaderUinsOld TEXT ,mHeaderUinsNew TEXT ,mTags TEXT ,mTroopAvatarId INTEGER ,mTroopPicListJson TEXT ,nTroopGrade INTEGER ,isShowInNearbyTroops INTEGER ,dwGagTimeStamp INTEGER ,dwGagTimeStamp_me INTEGER ,dwCmdUinUinFlag INTEGER ,dwAdditionalFlag INTEGER ,troopTypeExt INTEGER ,ownerNameShow TEXT ,adminNameShow TEXT ,dwOfficeMode INTEGER ,dwGroupFlagExt3 INTEGER ,cmdUinFlagEx2 INTEGER ,udwCmdUinRingtoneID INTEGER ,memberListToShow TEXT ,troopPrivilegeFlag INTEGER ,isNewTroop INTEGER ,hasSetNewTroopHead INTEGER ,hasSetNewTroopName INTEGER ,maxInviteMemNum INTEGER ,lastMsgTime INTEGER ,allowMemberModifTroopName INTEGER ,allowMemberKick INTEGER ,allowMemberAtAll INTEGER ,oldTroopName TEXT ,hlGuildAppid INTEGER ,hlGuildSubType INTEGER ,hlGuildOrgid INTEGER ,hlGuildBinary INTEGER ,gameSwitchStatus INTEGER ,showGameSwitchStatus INTEGER ,lastShareLbsMsgUniseq INTEGER ,mTroopNeedPayNumber REAL ,troopCreditLevel INTEGER ,troopCreditLevelInfo INTEGER ,dwAppPrivilegeFlag INTEGER ,topicId TEXT ,associatePubAccount INTEGER ,mTroopFileVideoReqInterval INTEGER ,mTroopFileVideoIsWhite INTEGER ,mTribeStatus INTEGER ,mCanSearchByKeywords INTEGER ,mCanSearchByTroopUin INTEGER ,dwCmdUinJoinTime INTEGER ,dwLastInsertBAFTipTime INTEGER ,wInsertBAFTipCount INTEGER ,wClickBAFTipCount INTEGER ,dwLastBAFTipMsgUniSeq INTEGER ,dwLastBAFTipMsgUniSeq2 INTEGER ,dailyNewMemberUins TEXT ,exitTroopReason INTEGER ,eliminated INTEGER ,mIsFreezed INTEGER ,strLastAnnouncement TEXT ,nMsgLimitFreq INTEGER ,mAtOrReplyMeUins TEXT ,groupFlagExt4 INTEGER ,groupFreezeReason INTEGER ,troopHonorGrayFlag INTEGER ,isAllowHistoryMsgFlag INTEGER ,troopRepeatType INTEGER ,feeds_id TEXT ,myHonorList TEXT)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayvz
 * JD-Core Version:    0.7.0.1
 */