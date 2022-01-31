import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class auls
  extends aula
{
  public auls()
  {
    this.a = 117;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramauko = (TroopInfo)paramauko;
    if (paramaukz == null)
    {
      paramauko.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramauko.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
      paramauko.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
      paramauko.troopcode = paramCursor.getString(paramCursor.getColumnIndex("troopcode"));
      paramauko.troopowneruin = paramCursor.getString(paramCursor.getColumnIndex("troopowneruin"));
      paramauko.troopname = paramCursor.getString(paramCursor.getColumnIndex("troopname"));
      paramauko.newTroopName = paramCursor.getString(paramCursor.getColumnIndex("newTroopName"));
      paramauko.newTroopNameTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("newTroopNameTimeStamp"));
      paramauko.troopface = paramCursor.getShort(paramCursor.getColumnIndex("troopface"));
      paramauko.troopmemo = paramCursor.getString(paramCursor.getColumnIndex("troopmemo"));
      paramauko.fingertroopmemo = paramCursor.getString(paramCursor.getColumnIndex("fingertroopmemo"));
      paramauko.mRichFingerMemo = paramCursor.getString(paramCursor.getColumnIndex("mRichFingerMemo"));
      paramauko.troopmask = paramCursor.getInt(paramCursor.getColumnIndex("troopmask"));
      paramauko.trooptype = paramCursor.getInt(paramCursor.getColumnIndex("trooptype"));
      paramauko.troopCreateTime = paramCursor.getLong(paramCursor.getColumnIndex("troopCreateTime"));
      paramauko.dwGroupFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlag"));
      paramauko.cGroupOption = paramCursor.getShort(paramCursor.getColumnIndex("cGroupOption"));
      paramauko.wMemberMax = paramCursor.getInt(paramCursor.getColumnIndex("wMemberMax"));
      paramauko.maxAdminNum = paramCursor.getInt(paramCursor.getColumnIndex("maxAdminNum"));
      paramauko.wSpecialClass = paramCursor.getInt(paramCursor.getColumnIndex("wSpecialClass"));
      paramauko.cGroupLevel = paramCursor.getShort(paramCursor.getColumnIndex("cGroupLevel"));
      paramauko.wMemberNum = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNum"));
      paramauko.wMemberNumClient = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNumClient"));
      paramauko.Administrator = paramCursor.getString(paramCursor.getColumnIndex("Administrator"));
      paramauko.dwGroupClassExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupClassExt"));
      paramauko.mGroupClassExtText = paramCursor.getString(paramCursor.getColumnIndex("mGroupClassExtText"));
      paramauko.dwGroupFlagExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt"));
      paramauko.dwAuthGroupType = paramCursor.getLong(paramCursor.getColumnIndex("dwAuthGroupType"));
      paramauko.troopAuthenticateInfo = paramCursor.getString(paramCursor.getColumnIndex("troopAuthenticateInfo"));
      paramauko.dwGroupInfoSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupInfoSeq"));
      paramauko.mMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberNumSeq"));
      paramauko.mOldMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberNumSeq"));
      paramauko.mMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberCardSeq"));
      paramauko.mOldMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberCardSeq"));
      paramauko.dwGroupLevelSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupLevelSeq"));
      paramauko.cGroupRankSysFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankSysFlag")));
      paramauko.cGroupRankUserFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankUserFlag")));
      paramauko.troopLevelMap = paramCursor.getString(paramCursor.getColumnIndex("troopLevelMap"));
      paramauko.joinTroopQuestion = paramCursor.getString(paramCursor.getColumnIndex("joinTroopQuestion"));
      paramauko.joinTroopAnswer = paramCursor.getString(paramCursor.getColumnIndex("joinTroopAnswer"));
      paramauko.cAlbumResult = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cAlbumResult")));
      paramauko.dwTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwTimeStamp"));
      paramauko.strQZonePhotoUrls = paramCursor.getString(paramCursor.getColumnIndex("strQZonePhotoUrls"));
      paramauko.mQZonePhotoNum = paramCursor.getInt(paramCursor.getColumnIndex("mQZonePhotoNum"));
      paramauko.strLocation = paramCursor.getString(paramCursor.getColumnIndex("strLocation"));
      paramauko.troopLat = paramCursor.getInt(paramCursor.getColumnIndex("troopLat"));
      paramauko.troopLon = paramCursor.getInt(paramCursor.getColumnIndex("troopLon"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("mMemberInvitingFlag")))
      {
        paramBoolean = true;
        paramauko.mMemberInvitingFlag = paramBoolean;
        paramauko.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramauko.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramauko.mSomeMemberUins = paramCursor.getString(paramCursor.getColumnIndex("mSomeMemberUins"));
        paramauko.mHeaderUinsOld = paramCursor.getString(paramCursor.getColumnIndex("mHeaderUinsOld"));
        paramauko.mHeaderUinsNew = paramCursor.getString(paramCursor.getColumnIndex("mHeaderUinsNew"));
        paramauko.mTags = paramCursor.getString(paramCursor.getColumnIndex("mTags"));
        paramauko.mTroopAvatarId = paramCursor.getInt(paramCursor.getColumnIndex("mTroopAvatarId"));
        paramauko.mTroopPicListJson = paramCursor.getString(paramCursor.getColumnIndex("mTroopPicListJson"));
        paramauko.nTroopGrade = paramCursor.getInt(paramCursor.getColumnIndex("nTroopGrade"));
        paramauko.isShowInNearbyTroops = paramCursor.getInt(paramCursor.getColumnIndex("isShowInNearbyTroops"));
        paramauko.dwGagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp"));
        paramauko.dwGagTimeStamp_me = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp_me"));
        paramauko.dwCmdUinUinFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwCmdUinUinFlag"));
        paramauko.dwAdditionalFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAdditionalFlag"));
        paramauko.troopTypeExt = paramCursor.getInt(paramCursor.getColumnIndex("troopTypeExt"));
        paramauko.ownerNameShow = paramCursor.getString(paramCursor.getColumnIndex("ownerNameShow"));
        paramauko.adminNameShow = paramCursor.getString(paramCursor.getColumnIndex("adminNameShow"));
        paramauko.dwOfficeMode = paramCursor.getLong(paramCursor.getColumnIndex("dwOfficeMode"));
        paramauko.dwGroupFlagExt3 = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt3"));
        paramauko.cmdUinFlagEx2 = paramCursor.getLong(paramCursor.getColumnIndex("cmdUinFlagEx2"));
        paramauko.udwCmdUinRingtoneID = paramCursor.getLong(paramCursor.getColumnIndex("udwCmdUinRingtoneID"));
        paramauko.memberListToShow = paramCursor.getString(paramCursor.getColumnIndex("memberListToShow"));
        paramauko.troopPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("troopPrivilegeFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isNewTroop"))) {
          break label2239;
        }
        paramBoolean = true;
        label1343:
        paramauko.isNewTroop = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSetNewTroopHead"))) {
          break label2244;
        }
        paramBoolean = true;
        label1369:
        paramauko.hasSetNewTroopHead = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSetNewTroopName"))) {
          break label2249;
        }
        paramBoolean = true;
        label1395:
        paramauko.hasSetNewTroopName = paramBoolean;
        paramauko.maxInviteMemNum = paramCursor.getInt(paramCursor.getColumnIndex("maxInviteMemNum"));
        paramauko.lastMsgTime = paramCursor.getLong(paramCursor.getColumnIndex("lastMsgTime"));
        paramauko.allowMemberModifTroopName = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberModifTroopName"));
        paramauko.allowMemberKick = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberKick"));
        paramauko.allowMemberAtAll = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberAtAll"));
        paramauko.oldTroopName = paramCursor.getString(paramCursor.getColumnIndex("oldTroopName"));
        paramauko.hlGuildAppid = paramCursor.getLong(paramCursor.getColumnIndex("hlGuildAppid"));
        paramauko.hlGuildSubType = paramCursor.getLong(paramCursor.getColumnIndex("hlGuildSubType"));
        paramauko.hlGuildOrgid = paramCursor.getInt(paramCursor.getColumnIndex("hlGuildOrgid"));
        paramauko.hlGuildBinary = paramCursor.getInt(paramCursor.getColumnIndex("hlGuildBinary"));
        paramauko.gameSwitchStatus = paramCursor.getInt(paramCursor.getColumnIndex("gameSwitchStatus"));
        paramauko.showGameSwitchStatus = paramCursor.getInt(paramCursor.getColumnIndex("showGameSwitchStatus"));
        paramauko.lastShareLbsMsgUniseq = paramCursor.getLong(paramCursor.getColumnIndex("lastShareLbsMsgUniseq"));
        paramauko.mTroopNeedPayNumber = paramCursor.getFloat(paramCursor.getColumnIndex("mTroopNeedPayNumber"));
        paramauko.troopCreditLevel = paramCursor.getLong(paramCursor.getColumnIndex("troopCreditLevel"));
        paramauko.troopCreditLevelInfo = paramCursor.getLong(paramCursor.getColumnIndex("troopCreditLevelInfo"));
        paramauko.dwAppPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAppPrivilegeFlag"));
        paramauko.topicId = paramCursor.getString(paramCursor.getColumnIndex("topicId"));
        paramauko.associatePubAccount = paramCursor.getLong(paramCursor.getColumnIndex("associatePubAccount"));
        paramauko.mTroopFileVideoReqInterval = paramCursor.getLong(paramCursor.getColumnIndex("mTroopFileVideoReqInterval"));
        paramauko.mTroopFileVideoIsWhite = paramCursor.getInt(paramCursor.getColumnIndex("mTroopFileVideoIsWhite"));
        paramauko.mTribeStatus = paramCursor.getInt(paramCursor.getColumnIndex("mTribeStatus"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mCanSearchByKeywords"))) {
          break label2254;
        }
        paramBoolean = true;
        label1839:
        paramauko.mCanSearchByKeywords = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mCanSearchByTroopUin"))) {
          break label2259;
        }
      }
      label2239:
      label2244:
      label2249:
      label2254:
      label2259:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramauko.mCanSearchByTroopUin = paramBoolean;
        paramauko.dwCmdUinJoinTime = paramCursor.getLong(paramCursor.getColumnIndex("dwCmdUinJoinTime"));
        paramauko.dwLastInsertBAFTipTime = paramCursor.getLong(paramCursor.getColumnIndex("dwLastInsertBAFTipTime"));
        paramauko.wInsertBAFTipCount = paramCursor.getInt(paramCursor.getColumnIndex("wInsertBAFTipCount"));
        paramauko.wClickBAFTipCount = paramCursor.getInt(paramCursor.getColumnIndex("wClickBAFTipCount"));
        paramauko.dwLastBAFTipMsgUniSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq"));
        paramauko.dwLastBAFTipMsgUniSeq2 = paramCursor.getLong(paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq2"));
        paramauko.dailyNewMemberUins = paramCursor.getString(paramCursor.getColumnIndex("dailyNewMemberUins"));
        paramauko.exitTroopReason = paramCursor.getInt(paramCursor.getColumnIndex("exitTroopReason"));
        paramauko.eliminated = paramCursor.getInt(paramCursor.getColumnIndex("eliminated"));
        paramauko.mIsFreezed = paramCursor.getInt(paramCursor.getColumnIndex("mIsFreezed"));
        paramauko.strLastAnnouncement = paramCursor.getString(paramCursor.getColumnIndex("strLastAnnouncement"));
        paramauko.nMsgLimitFreq = paramCursor.getInt(paramCursor.getColumnIndex("nMsgLimitFreq"));
        paramauko.mAtOrReplyMeUins = paramCursor.getString(paramCursor.getColumnIndex("mAtOrReplyMeUins"));
        paramauko.groupFlagExt4 = paramCursor.getInt(paramCursor.getColumnIndex("groupFlagExt4"));
        paramauko.groupFreezeReason = paramCursor.getInt(paramCursor.getColumnIndex("groupFreezeReason"));
        paramauko.troopHonorGrayFlag = paramCursor.getInt(paramCursor.getColumnIndex("troopHonorGrayFlag"));
        paramauko.isAllowHistoryMsgFlag = paramCursor.getInt(paramCursor.getColumnIndex("isAllowHistoryMsgFlag"));
        paramauko.troopRepeatType = paramCursor.getInt(paramCursor.getColumnIndex("troopRepeatType"));
        paramauko.feeds_id = paramCursor.getString(paramCursor.getColumnIndex("feeds_id"));
        return paramauko;
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
      paramaukz.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("timeSec");
      if (i != -1) {
        break label6504;
      }
      paramaukz.a(new NoColumnError("timeSec", Long.TYPE));
      label2334:
      i = paramCursor.getColumnIndex("troopuin");
      if (i != -1) {
        break label6519;
      }
      paramaukz.a(new NoColumnError("troopuin", String.class));
      label2369:
      i = paramCursor.getColumnIndex("troopcode");
      if (i != -1) {
        break label6534;
      }
      paramaukz.a(new NoColumnError("troopcode", String.class));
      label2404:
      i = paramCursor.getColumnIndex("troopowneruin");
      if (i != -1) {
        break label6549;
      }
      paramaukz.a(new NoColumnError("troopowneruin", String.class));
      label2439:
      i = paramCursor.getColumnIndex("troopname");
      if (i != -1) {
        break label6564;
      }
      paramaukz.a(new NoColumnError("troopname", String.class));
      label2474:
      i = paramCursor.getColumnIndex("newTroopName");
      if (i != -1) {
        break label6579;
      }
      paramaukz.a(new NoColumnError("newTroopName", String.class));
      label2509:
      i = paramCursor.getColumnIndex("newTroopNameTimeStamp");
      if (i != -1) {
        break label6594;
      }
      paramaukz.a(new NoColumnError("newTroopNameTimeStamp", Long.TYPE));
      label2544:
      i = paramCursor.getColumnIndex("troopface");
      if (i != -1) {
        break label6609;
      }
      paramaukz.a(new NoColumnError("troopface", Short.TYPE));
      label2579:
      i = paramCursor.getColumnIndex("troopmemo");
      if (i != -1) {
        break label6624;
      }
      paramaukz.a(new NoColumnError("troopmemo", String.class));
      label2614:
      i = paramCursor.getColumnIndex("fingertroopmemo");
      if (i != -1) {
        break label6639;
      }
      paramaukz.a(new NoColumnError("fingertroopmemo", String.class));
      label2649:
      i = paramCursor.getColumnIndex("mRichFingerMemo");
      if (i != -1) {
        break label6654;
      }
      paramaukz.a(new NoColumnError("mRichFingerMemo", String.class));
      label2684:
      i = paramCursor.getColumnIndex("troopmask");
      if (i != -1) {
        break label6669;
      }
      paramaukz.a(new NoColumnError("troopmask", Integer.TYPE));
      label2719:
      i = paramCursor.getColumnIndex("trooptype");
      if (i != -1) {
        break label6684;
      }
      paramaukz.a(new NoColumnError("trooptype", Integer.TYPE));
      label2754:
      i = paramCursor.getColumnIndex("troopCreateTime");
      if (i != -1) {
        break label6699;
      }
      paramaukz.a(new NoColumnError("troopCreateTime", Long.TYPE));
      label2789:
      i = paramCursor.getColumnIndex("dwGroupFlag");
      if (i != -1) {
        break label6714;
      }
      paramaukz.a(new NoColumnError("dwGroupFlag", Long.TYPE));
      label2824:
      i = paramCursor.getColumnIndex("cGroupOption");
      if (i != -1) {
        break label6729;
      }
      paramaukz.a(new NoColumnError("cGroupOption", Short.TYPE));
      label2859:
      i = paramCursor.getColumnIndex("wMemberMax");
      if (i != -1) {
        break label6744;
      }
      paramaukz.a(new NoColumnError("wMemberMax", Integer.TYPE));
      label2894:
      i = paramCursor.getColumnIndex("maxAdminNum");
      if (i != -1) {
        break label6759;
      }
      paramaukz.a(new NoColumnError("maxAdminNum", Integer.TYPE));
      label2929:
      i = paramCursor.getColumnIndex("wSpecialClass");
      if (i != -1) {
        break label6774;
      }
      paramaukz.a(new NoColumnError("wSpecialClass", Integer.TYPE));
      label2964:
      i = paramCursor.getColumnIndex("cGroupLevel");
      if (i != -1) {
        break label6789;
      }
      paramaukz.a(new NoColumnError("cGroupLevel", Short.TYPE));
      label2999:
      i = paramCursor.getColumnIndex("wMemberNum");
      if (i != -1) {
        break label6804;
      }
      paramaukz.a(new NoColumnError("wMemberNum", Integer.TYPE));
      label3034:
      i = paramCursor.getColumnIndex("wMemberNumClient");
      if (i != -1) {
        break label6819;
      }
      paramaukz.a(new NoColumnError("wMemberNumClient", Integer.TYPE));
      label3069:
      i = paramCursor.getColumnIndex("Administrator");
      if (i != -1) {
        break label6834;
      }
      paramaukz.a(new NoColumnError("Administrator", String.class));
      label3104:
      i = paramCursor.getColumnIndex("dwGroupClassExt");
      if (i != -1) {
        break label6849;
      }
      paramaukz.a(new NoColumnError("dwGroupClassExt", Long.TYPE));
      label3139:
      i = paramCursor.getColumnIndex("mGroupClassExtText");
      if (i != -1) {
        break label6864;
      }
      paramaukz.a(new NoColumnError("mGroupClassExtText", String.class));
      label3174:
      i = paramCursor.getColumnIndex("dwGroupFlagExt");
      if (i != -1) {
        break label6879;
      }
      paramaukz.a(new NoColumnError("dwGroupFlagExt", Long.TYPE));
      label3209:
      i = paramCursor.getColumnIndex("dwAuthGroupType");
      if (i != -1) {
        break label6894;
      }
      paramaukz.a(new NoColumnError("dwAuthGroupType", Long.TYPE));
      label3244:
      i = paramCursor.getColumnIndex("troopAuthenticateInfo");
      if (i != -1) {
        break label6909;
      }
      paramaukz.a(new NoColumnError("troopAuthenticateInfo", String.class));
      label3279:
      i = paramCursor.getColumnIndex("dwGroupInfoSeq");
      if (i != -1) {
        break label6924;
      }
      paramaukz.a(new NoColumnError("dwGroupInfoSeq", Long.TYPE));
      label3314:
      i = paramCursor.getColumnIndex("mMemberNumSeq");
      if (i != -1) {
        break label6939;
      }
      paramaukz.a(new NoColumnError("mMemberNumSeq", Long.TYPE));
      label3349:
      i = paramCursor.getColumnIndex("mOldMemberNumSeq");
      if (i != -1) {
        break label6954;
      }
      paramaukz.a(new NoColumnError("mOldMemberNumSeq", Long.TYPE));
      label3384:
      i = paramCursor.getColumnIndex("mMemberCardSeq");
      if (i != -1) {
        break label6969;
      }
      paramaukz.a(new NoColumnError("mMemberCardSeq", Long.TYPE));
      label3419:
      i = paramCursor.getColumnIndex("mOldMemberCardSeq");
      if (i != -1) {
        break label6984;
      }
      paramaukz.a(new NoColumnError("mOldMemberCardSeq", Long.TYPE));
      label3454:
      i = paramCursor.getColumnIndex("dwGroupLevelSeq");
      if (i != -1) {
        break label6999;
      }
      paramaukz.a(new NoColumnError("dwGroupLevelSeq", Long.TYPE));
      label3489:
      i = paramCursor.getColumnIndex("cGroupRankSysFlag");
      if (i != -1) {
        break label7014;
      }
      paramaukz.a(new NoColumnError("cGroupRankSysFlag", Byte.TYPE));
      label3524:
      i = paramCursor.getColumnIndex("cGroupRankUserFlag");
      if (i != -1) {
        break label7030;
      }
      paramaukz.a(new NoColumnError("cGroupRankUserFlag", Byte.TYPE));
      label3559:
      i = paramCursor.getColumnIndex("troopLevelMap");
      if (i != -1) {
        break label7046;
      }
      paramaukz.a(new NoColumnError("troopLevelMap", String.class));
      label3594:
      i = paramCursor.getColumnIndex("joinTroopQuestion");
      if (i != -1) {
        break label7061;
      }
      paramaukz.a(new NoColumnError("joinTroopQuestion", String.class));
      label3629:
      i = paramCursor.getColumnIndex("joinTroopAnswer");
      if (i != -1) {
        break label7076;
      }
      paramaukz.a(new NoColumnError("joinTroopAnswer", String.class));
      label3664:
      i = paramCursor.getColumnIndex("cAlbumResult");
      if (i != -1) {
        break label7091;
      }
      paramaukz.a(new NoColumnError("cAlbumResult", Byte.TYPE));
      label3699:
      i = paramCursor.getColumnIndex("dwTimeStamp");
      if (i != -1) {
        break label7107;
      }
      paramaukz.a(new NoColumnError("dwTimeStamp", Long.TYPE));
      label3734:
      i = paramCursor.getColumnIndex("strQZonePhotoUrls");
      if (i != -1) {
        break label7122;
      }
      paramaukz.a(new NoColumnError("strQZonePhotoUrls", String.class));
      label3769:
      i = paramCursor.getColumnIndex("mQZonePhotoNum");
      if (i != -1) {
        break label7137;
      }
      paramaukz.a(new NoColumnError("mQZonePhotoNum", Integer.TYPE));
      label3804:
      i = paramCursor.getColumnIndex("strLocation");
      if (i != -1) {
        break label7152;
      }
      paramaukz.a(new NoColumnError("strLocation", String.class));
      label3839:
      i = paramCursor.getColumnIndex("troopLat");
      if (i != -1) {
        break label7167;
      }
      paramaukz.a(new NoColumnError("troopLat", Integer.TYPE));
      label3874:
      i = paramCursor.getColumnIndex("troopLon");
      if (i != -1) {
        break label7182;
      }
      paramaukz.a(new NoColumnError("troopLon", Integer.TYPE));
      label3909:
      i = paramCursor.getColumnIndex("mMemberInvitingFlag");
      if (i != -1) {
        break label7197;
      }
      paramaukz.a(new NoColumnError("mMemberInvitingFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label7224;
      }
      paramaukz.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label3979:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label7239;
      }
      paramaukz.a(new NoColumnError("mCompareSpell", String.class));
      label4014:
      i = paramCursor.getColumnIndex("mSomeMemberUins");
      if (i != -1) {
        break label7254;
      }
      paramaukz.a(new NoColumnError("mSomeMemberUins", String.class));
      label4049:
      i = paramCursor.getColumnIndex("mHeaderUinsOld");
      if (i != -1) {
        break label7269;
      }
      paramaukz.a(new NoColumnError("mHeaderUinsOld", String.class));
      label4084:
      i = paramCursor.getColumnIndex("mHeaderUinsNew");
      if (i != -1) {
        break label7284;
      }
      paramaukz.a(new NoColumnError("mHeaderUinsNew", String.class));
      label4119:
      i = paramCursor.getColumnIndex("mTags");
      if (i != -1) {
        break label7299;
      }
      paramaukz.a(new NoColumnError("mTags", String.class));
      label4156:
      i = paramCursor.getColumnIndex("mTroopAvatarId");
      if (i != -1) {
        break label7314;
      }
      paramaukz.a(new NoColumnError("mTroopAvatarId", Integer.TYPE));
      label4193:
      i = paramCursor.getColumnIndex("mTroopPicListJson");
      if (i != -1) {
        break label7329;
      }
      paramaukz.a(new NoColumnError("mTroopPicListJson", String.class));
      label4230:
      i = paramCursor.getColumnIndex("nTroopGrade");
      if (i != -1) {
        break label7344;
      }
      paramaukz.a(new NoColumnError("nTroopGrade", Integer.TYPE));
      label4267:
      i = paramCursor.getColumnIndex("isShowInNearbyTroops");
      if (i != -1) {
        break label7359;
      }
      paramaukz.a(new NoColumnError("isShowInNearbyTroops", Integer.TYPE));
      label4304:
      i = paramCursor.getColumnIndex("dwGagTimeStamp");
      if (i != -1) {
        break label7374;
      }
      paramaukz.a(new NoColumnError("dwGagTimeStamp", Long.TYPE));
      label4341:
      i = paramCursor.getColumnIndex("dwGagTimeStamp_me");
      if (i != -1) {
        break label7389;
      }
      paramaukz.a(new NoColumnError("dwGagTimeStamp_me", Long.TYPE));
      label4378:
      i = paramCursor.getColumnIndex("dwCmdUinUinFlag");
      if (i != -1) {
        break label7404;
      }
      paramaukz.a(new NoColumnError("dwCmdUinUinFlag", Long.TYPE));
      label4415:
      i = paramCursor.getColumnIndex("dwAdditionalFlag");
      if (i != -1) {
        break label7419;
      }
      paramaukz.a(new NoColumnError("dwAdditionalFlag", Long.TYPE));
      label4452:
      i = paramCursor.getColumnIndex("troopTypeExt");
      if (i != -1) {
        break label7434;
      }
      paramaukz.a(new NoColumnError("troopTypeExt", Integer.TYPE));
      label4489:
      i = paramCursor.getColumnIndex("ownerNameShow");
      if (i != -1) {
        break label7449;
      }
      paramaukz.a(new NoColumnError("ownerNameShow", String.class));
      label4526:
      i = paramCursor.getColumnIndex("adminNameShow");
      if (i != -1) {
        break label7464;
      }
      paramaukz.a(new NoColumnError("adminNameShow", String.class));
      label4563:
      i = paramCursor.getColumnIndex("dwOfficeMode");
      if (i != -1) {
        break label7479;
      }
      paramaukz.a(new NoColumnError("dwOfficeMode", Long.TYPE));
      label4600:
      i = paramCursor.getColumnIndex("dwGroupFlagExt3");
      if (i != -1) {
        break label7494;
      }
      paramaukz.a(new NoColumnError("dwGroupFlagExt3", Long.TYPE));
      label4637:
      i = paramCursor.getColumnIndex("cmdUinFlagEx2");
      if (i != -1) {
        break label7509;
      }
      paramaukz.a(new NoColumnError("cmdUinFlagEx2", Long.TYPE));
      label4674:
      i = paramCursor.getColumnIndex("udwCmdUinRingtoneID");
      if (i != -1) {
        break label7524;
      }
      paramaukz.a(new NoColumnError("udwCmdUinRingtoneID", Long.TYPE));
      label4711:
      i = paramCursor.getColumnIndex("memberListToShow");
      if (i != -1) {
        break label7539;
      }
      paramaukz.a(new NoColumnError("memberListToShow", String.class));
      label4748:
      i = paramCursor.getColumnIndex("troopPrivilegeFlag");
      if (i != -1) {
        break label7554;
      }
      paramaukz.a(new NoColumnError("troopPrivilegeFlag", Long.TYPE));
      label4785:
      i = paramCursor.getColumnIndex("isNewTroop");
      if (i != -1) {
        break label7569;
      }
      paramaukz.a(new NoColumnError("isNewTroop", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasSetNewTroopHead");
      if (i != -1) {
        break label7596;
      }
      paramaukz.a(new NoColumnError("hasSetNewTroopHead", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasSetNewTroopName");
      if (i != -1) {
        break label7623;
      }
      paramaukz.a(new NoColumnError("hasSetNewTroopName", Boolean.TYPE));
      i = paramCursor.getColumnIndex("maxInviteMemNum");
      if (i != -1) {
        break label7650;
      }
      paramaukz.a(new NoColumnError("maxInviteMemNum", Integer.TYPE));
      label4933:
      i = paramCursor.getColumnIndex("lastMsgTime");
      if (i != -1) {
        break label7665;
      }
      paramaukz.a(new NoColumnError("lastMsgTime", Long.TYPE));
      label4970:
      i = paramCursor.getColumnIndex("allowMemberModifTroopName");
      if (i != -1) {
        break label7680;
      }
      paramaukz.a(new NoColumnError("allowMemberModifTroopName", Integer.TYPE));
      label5007:
      i = paramCursor.getColumnIndex("allowMemberKick");
      if (i != -1) {
        break label7695;
      }
      paramaukz.a(new NoColumnError("allowMemberKick", Integer.TYPE));
      label5044:
      i = paramCursor.getColumnIndex("allowMemberAtAll");
      if (i != -1) {
        break label7710;
      }
      paramaukz.a(new NoColumnError("allowMemberAtAll", Integer.TYPE));
      label5081:
      i = paramCursor.getColumnIndex("oldTroopName");
      if (i != -1) {
        break label7725;
      }
      paramaukz.a(new NoColumnError("oldTroopName", String.class));
      label5118:
      i = paramCursor.getColumnIndex("hlGuildAppid");
      if (i != -1) {
        break label7740;
      }
      paramaukz.a(new NoColumnError("hlGuildAppid", Long.TYPE));
      label5155:
      i = paramCursor.getColumnIndex("hlGuildSubType");
      if (i != -1) {
        break label7755;
      }
      paramaukz.a(new NoColumnError("hlGuildSubType", Long.TYPE));
      label5192:
      i = paramCursor.getColumnIndex("hlGuildOrgid");
      if (i != -1) {
        break label7770;
      }
      paramaukz.a(new NoColumnError("hlGuildOrgid", Integer.TYPE));
      label5229:
      i = paramCursor.getColumnIndex("hlGuildBinary");
      if (i != -1) {
        break label7785;
      }
      paramaukz.a(new NoColumnError("hlGuildBinary", Integer.TYPE));
      label5266:
      i = paramCursor.getColumnIndex("gameSwitchStatus");
      if (i != -1) {
        break label7800;
      }
      paramaukz.a(new NoColumnError("gameSwitchStatus", Integer.TYPE));
      label5303:
      i = paramCursor.getColumnIndex("showGameSwitchStatus");
      if (i != -1) {
        break label7815;
      }
      paramaukz.a(new NoColumnError("showGameSwitchStatus", Integer.TYPE));
      label5340:
      i = paramCursor.getColumnIndex("lastShareLbsMsgUniseq");
      if (i != -1) {
        break label7830;
      }
      paramaukz.a(new NoColumnError("lastShareLbsMsgUniseq", Long.TYPE));
      label5377:
      i = paramCursor.getColumnIndex("mTroopNeedPayNumber");
      if (i != -1) {
        break label7845;
      }
      paramaukz.a(new NoColumnError("mTroopNeedPayNumber", Float.TYPE));
      label5414:
      i = paramCursor.getColumnIndex("troopCreditLevel");
      if (i != -1) {
        break label7860;
      }
      paramaukz.a(new NoColumnError("troopCreditLevel", Long.TYPE));
      label5451:
      i = paramCursor.getColumnIndex("troopCreditLevelInfo");
      if (i != -1) {
        break label7875;
      }
      paramaukz.a(new NoColumnError("troopCreditLevelInfo", Long.TYPE));
      label5488:
      i = paramCursor.getColumnIndex("dwAppPrivilegeFlag");
      if (i != -1) {
        break label7890;
      }
      paramaukz.a(new NoColumnError("dwAppPrivilegeFlag", Long.TYPE));
      label5525:
      i = paramCursor.getColumnIndex("topicId");
      if (i != -1) {
        break label7905;
      }
      paramaukz.a(new NoColumnError("topicId", String.class));
      label5562:
      i = paramCursor.getColumnIndex("associatePubAccount");
      if (i != -1) {
        break label7920;
      }
      paramaukz.a(new NoColumnError("associatePubAccount", Long.TYPE));
      label5599:
      i = paramCursor.getColumnIndex("mTroopFileVideoReqInterval");
      if (i != -1) {
        break label7935;
      }
      paramaukz.a(new NoColumnError("mTroopFileVideoReqInterval", Long.TYPE));
      label5636:
      i = paramCursor.getColumnIndex("mTroopFileVideoIsWhite");
      if (i != -1) {
        break label7950;
      }
      paramaukz.a(new NoColumnError("mTroopFileVideoIsWhite", Integer.TYPE));
      label5673:
      i = paramCursor.getColumnIndex("mTribeStatus");
      if (i != -1) {
        break label7965;
      }
      paramaukz.a(new NoColumnError("mTribeStatus", Integer.TYPE));
      label5710:
      i = paramCursor.getColumnIndex("mCanSearchByKeywords");
      if (i != -1) {
        break label7980;
      }
      paramaukz.a(new NoColumnError("mCanSearchByKeywords", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mCanSearchByTroopUin");
      if (i != -1) {
        break label8007;
      }
      paramaukz.a(new NoColumnError("mCanSearchByTroopUin", Boolean.TYPE));
      i = paramCursor.getColumnIndex("dwCmdUinJoinTime");
      if (i != -1) {
        break label8035;
      }
      paramaukz.a(new NoColumnError("dwCmdUinJoinTime", Long.TYPE));
      label5821:
      i = paramCursor.getColumnIndex("dwLastInsertBAFTipTime");
      if (i != -1) {
        break label8050;
      }
      paramaukz.a(new NoColumnError("dwLastInsertBAFTipTime", Long.TYPE));
      label5858:
      i = paramCursor.getColumnIndex("wInsertBAFTipCount");
      if (i != -1) {
        break label8065;
      }
      paramaukz.a(new NoColumnError("wInsertBAFTipCount", Integer.TYPE));
      label5895:
      i = paramCursor.getColumnIndex("wClickBAFTipCount");
      if (i != -1) {
        break label8080;
      }
      paramaukz.a(new NoColumnError("wClickBAFTipCount", Integer.TYPE));
      label5932:
      i = paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq");
      if (i != -1) {
        break label8095;
      }
      paramaukz.a(new NoColumnError("dwLastBAFTipMsgUniSeq", Long.TYPE));
      label5969:
      i = paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq2");
      if (i != -1) {
        break label8110;
      }
      paramaukz.a(new NoColumnError("dwLastBAFTipMsgUniSeq2", Long.TYPE));
      label6006:
      i = paramCursor.getColumnIndex("dailyNewMemberUins");
      if (i != -1) {
        break label8125;
      }
      paramaukz.a(new NoColumnError("dailyNewMemberUins", String.class));
      label6043:
      i = paramCursor.getColumnIndex("exitTroopReason");
      if (i != -1) {
        break label8140;
      }
      paramaukz.a(new NoColumnError("exitTroopReason", Integer.TYPE));
      label6080:
      i = paramCursor.getColumnIndex("eliminated");
      if (i != -1) {
        break label8155;
      }
      paramaukz.a(new NoColumnError("eliminated", Integer.TYPE));
      label6117:
      i = paramCursor.getColumnIndex("mIsFreezed");
      if (i != -1) {
        break label8170;
      }
      paramaukz.a(new NoColumnError("mIsFreezed", Integer.TYPE));
      label6154:
      i = paramCursor.getColumnIndex("strLastAnnouncement");
      if (i != -1) {
        break label8185;
      }
      paramaukz.a(new NoColumnError("strLastAnnouncement", String.class));
      label6191:
      i = paramCursor.getColumnIndex("nMsgLimitFreq");
      if (i != -1) {
        break label8200;
      }
      paramaukz.a(new NoColumnError("nMsgLimitFreq", Integer.TYPE));
      label6228:
      i = paramCursor.getColumnIndex("mAtOrReplyMeUins");
      if (i != -1) {
        break label8215;
      }
      paramaukz.a(new NoColumnError("mAtOrReplyMeUins", String.class));
      label6265:
      i = paramCursor.getColumnIndex("groupFlagExt4");
      if (i != -1) {
        break label8230;
      }
      paramaukz.a(new NoColumnError("groupFlagExt4", Integer.TYPE));
      label6302:
      i = paramCursor.getColumnIndex("groupFreezeReason");
      if (i != -1) {
        break label8245;
      }
      paramaukz.a(new NoColumnError("groupFreezeReason", Integer.TYPE));
      label6339:
      i = paramCursor.getColumnIndex("troopHonorGrayFlag");
      if (i != -1) {
        break label8260;
      }
      paramaukz.a(new NoColumnError("troopHonorGrayFlag", Integer.TYPE));
      label6376:
      i = paramCursor.getColumnIndex("isAllowHistoryMsgFlag");
      if (i != -1) {
        break label8275;
      }
      paramaukz.a(new NoColumnError("isAllowHistoryMsgFlag", Integer.TYPE));
      label6413:
      i = paramCursor.getColumnIndex("troopRepeatType");
      if (i != -1) {
        break label8290;
      }
      paramaukz.a(new NoColumnError("troopRepeatType", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("feeds_id");
      if (i != -1) {
        break label8305;
      }
      paramaukz.a(new NoColumnError("feeds_id", String.class));
      return paramauko;
      paramauko.uin = paramCursor.getString(i);
      break;
      label6504:
      paramauko.timeSec = paramCursor.getLong(i);
      break label2334;
      label6519:
      paramauko.troopuin = paramCursor.getString(i);
      break label2369;
      label6534:
      paramauko.troopcode = paramCursor.getString(i);
      break label2404;
      label6549:
      paramauko.troopowneruin = paramCursor.getString(i);
      break label2439;
      label6564:
      paramauko.troopname = paramCursor.getString(i);
      break label2474;
      label6579:
      paramauko.newTroopName = paramCursor.getString(i);
      break label2509;
      label6594:
      paramauko.newTroopNameTimeStamp = paramCursor.getLong(i);
      break label2544;
      label6609:
      paramauko.troopface = paramCursor.getShort(i);
      break label2579;
      label6624:
      paramauko.troopmemo = paramCursor.getString(i);
      break label2614;
      label6639:
      paramauko.fingertroopmemo = paramCursor.getString(i);
      break label2649;
      label6654:
      paramauko.mRichFingerMemo = paramCursor.getString(i);
      break label2684;
      label6669:
      paramauko.troopmask = paramCursor.getInt(i);
      break label2719;
      label6684:
      paramauko.trooptype = paramCursor.getInt(i);
      break label2754;
      label6699:
      paramauko.troopCreateTime = paramCursor.getLong(i);
      break label2789;
      label6714:
      paramauko.dwGroupFlag = paramCursor.getLong(i);
      break label2824;
      label6729:
      paramauko.cGroupOption = paramCursor.getShort(i);
      break label2859;
      label6744:
      paramauko.wMemberMax = paramCursor.getInt(i);
      break label2894;
      label6759:
      paramauko.maxAdminNum = paramCursor.getInt(i);
      break label2929;
      label6774:
      paramauko.wSpecialClass = paramCursor.getInt(i);
      break label2964;
      label6789:
      paramauko.cGroupLevel = paramCursor.getShort(i);
      break label2999;
      label6804:
      paramauko.wMemberNum = paramCursor.getInt(i);
      break label3034;
      label6819:
      paramauko.wMemberNumClient = paramCursor.getInt(i);
      break label3069;
      label6834:
      paramauko.Administrator = paramCursor.getString(i);
      break label3104;
      label6849:
      paramauko.dwGroupClassExt = paramCursor.getLong(i);
      break label3139;
      label6864:
      paramauko.mGroupClassExtText = paramCursor.getString(i);
      break label3174;
      label6879:
      paramauko.dwGroupFlagExt = paramCursor.getLong(i);
      break label3209;
      label6894:
      paramauko.dwAuthGroupType = paramCursor.getLong(i);
      break label3244;
      label6909:
      paramauko.troopAuthenticateInfo = paramCursor.getString(i);
      break label3279;
      label6924:
      paramauko.dwGroupInfoSeq = paramCursor.getLong(i);
      break label3314;
      label6939:
      paramauko.mMemberNumSeq = paramCursor.getLong(i);
      break label3349;
      label6954:
      paramauko.mOldMemberNumSeq = paramCursor.getLong(i);
      break label3384;
      label6969:
      paramauko.mMemberCardSeq = paramCursor.getLong(i);
      break label3419;
      label6984:
      paramauko.mOldMemberCardSeq = paramCursor.getLong(i);
      break label3454;
      label6999:
      paramauko.dwGroupLevelSeq = paramCursor.getLong(i);
      break label3489;
      label7014:
      paramauko.cGroupRankSysFlag = ((byte)paramCursor.getShort(i));
      break label3524;
      label7030:
      paramauko.cGroupRankUserFlag = ((byte)paramCursor.getShort(i));
      break label3559;
      label7046:
      paramauko.troopLevelMap = paramCursor.getString(i);
      break label3594;
      label7061:
      paramauko.joinTroopQuestion = paramCursor.getString(i);
      break label3629;
      label7076:
      paramauko.joinTroopAnswer = paramCursor.getString(i);
      break label3664;
      label7091:
      paramauko.cAlbumResult = ((byte)paramCursor.getShort(i));
      break label3699;
      label7107:
      paramauko.dwTimeStamp = paramCursor.getLong(i);
      break label3734;
      label7122:
      paramauko.strQZonePhotoUrls = paramCursor.getString(i);
      break label3769;
      label7137:
      paramauko.mQZonePhotoNum = paramCursor.getInt(i);
      break label3804;
      label7152:
      paramauko.strLocation = paramCursor.getString(i);
      break label3839;
      label7167:
      paramauko.troopLat = paramCursor.getInt(i);
      break label3874;
      label7182:
      paramauko.troopLon = paramCursor.getInt(i);
      break label3909;
      label7197:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.mMemberInvitingFlag = paramBoolean;
        break;
      }
      label7224:
      paramauko.mComparePartInt = paramCursor.getInt(i);
      break label3979;
      label7239:
      paramauko.mCompareSpell = paramCursor.getString(i);
      break label4014;
      label7254:
      paramauko.mSomeMemberUins = paramCursor.getString(i);
      break label4049;
      label7269:
      paramauko.mHeaderUinsOld = paramCursor.getString(i);
      break label4084;
      label7284:
      paramauko.mHeaderUinsNew = paramCursor.getString(i);
      break label4119;
      label7299:
      paramauko.mTags = paramCursor.getString(i);
      break label4156;
      label7314:
      paramauko.mTroopAvatarId = paramCursor.getInt(i);
      break label4193;
      label7329:
      paramauko.mTroopPicListJson = paramCursor.getString(i);
      break label4230;
      label7344:
      paramauko.nTroopGrade = paramCursor.getInt(i);
      break label4267;
      label7359:
      paramauko.isShowInNearbyTroops = paramCursor.getInt(i);
      break label4304;
      label7374:
      paramauko.dwGagTimeStamp = paramCursor.getLong(i);
      break label4341;
      label7389:
      paramauko.dwGagTimeStamp_me = paramCursor.getLong(i);
      break label4378;
      label7404:
      paramauko.dwCmdUinUinFlag = paramCursor.getLong(i);
      break label4415;
      label7419:
      paramauko.dwAdditionalFlag = paramCursor.getLong(i);
      break label4452;
      label7434:
      paramauko.troopTypeExt = paramCursor.getInt(i);
      break label4489;
      label7449:
      paramauko.ownerNameShow = paramCursor.getString(i);
      break label4526;
      label7464:
      paramauko.adminNameShow = paramCursor.getString(i);
      break label4563;
      label7479:
      paramauko.dwOfficeMode = paramCursor.getLong(i);
      break label4600;
      label7494:
      paramauko.dwGroupFlagExt3 = paramCursor.getLong(i);
      break label4637;
      label7509:
      paramauko.cmdUinFlagEx2 = paramCursor.getLong(i);
      break label4674;
      label7524:
      paramauko.udwCmdUinRingtoneID = paramCursor.getLong(i);
      break label4711;
      label7539:
      paramauko.memberListToShow = paramCursor.getString(i);
      break label4748;
      label7554:
      paramauko.troopPrivilegeFlag = paramCursor.getLong(i);
      break label4785;
      label7569:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isNewTroop = paramBoolean;
        break;
      }
      label7596:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.hasSetNewTroopHead = paramBoolean;
        break;
      }
      label7623:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.hasSetNewTroopName = paramBoolean;
        break;
      }
      label7650:
      paramauko.maxInviteMemNum = paramCursor.getInt(i);
      break label4933;
      label7665:
      paramauko.lastMsgTime = paramCursor.getLong(i);
      break label4970;
      label7680:
      paramauko.allowMemberModifTroopName = paramCursor.getInt(i);
      break label5007;
      label7695:
      paramauko.allowMemberKick = paramCursor.getInt(i);
      break label5044;
      label7710:
      paramauko.allowMemberAtAll = paramCursor.getInt(i);
      break label5081;
      label7725:
      paramauko.oldTroopName = paramCursor.getString(i);
      break label5118;
      label7740:
      paramauko.hlGuildAppid = paramCursor.getLong(i);
      break label5155;
      label7755:
      paramauko.hlGuildSubType = paramCursor.getLong(i);
      break label5192;
      label7770:
      paramauko.hlGuildOrgid = paramCursor.getInt(i);
      break label5229;
      label7785:
      paramauko.hlGuildBinary = paramCursor.getInt(i);
      break label5266;
      label7800:
      paramauko.gameSwitchStatus = paramCursor.getInt(i);
      break label5303;
      label7815:
      paramauko.showGameSwitchStatus = paramCursor.getInt(i);
      break label5340;
      label7830:
      paramauko.lastShareLbsMsgUniseq = paramCursor.getLong(i);
      break label5377;
      label7845:
      paramauko.mTroopNeedPayNumber = paramCursor.getFloat(i);
      break label5414;
      label7860:
      paramauko.troopCreditLevel = paramCursor.getLong(i);
      break label5451;
      label7875:
      paramauko.troopCreditLevelInfo = paramCursor.getLong(i);
      break label5488;
      label7890:
      paramauko.dwAppPrivilegeFlag = paramCursor.getLong(i);
      break label5525;
      label7905:
      paramauko.topicId = paramCursor.getString(i);
      break label5562;
      label7920:
      paramauko.associatePubAccount = paramCursor.getLong(i);
      break label5599;
      label7935:
      paramauko.mTroopFileVideoReqInterval = paramCursor.getLong(i);
      break label5636;
      label7950:
      paramauko.mTroopFileVideoIsWhite = paramCursor.getInt(i);
      break label5673;
      label7965:
      paramauko.mTribeStatus = paramCursor.getInt(i);
      break label5710;
      label7980:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.mCanSearchByKeywords = paramBoolean;
        break;
      }
      label8007:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramauko.mCanSearchByTroopUin = paramBoolean;
        break;
      }
      label8035:
      paramauko.dwCmdUinJoinTime = paramCursor.getLong(i);
      break label5821;
      label8050:
      paramauko.dwLastInsertBAFTipTime = paramCursor.getLong(i);
      break label5858;
      label8065:
      paramauko.wInsertBAFTipCount = paramCursor.getInt(i);
      break label5895;
      label8080:
      paramauko.wClickBAFTipCount = paramCursor.getInt(i);
      break label5932;
      label8095:
      paramauko.dwLastBAFTipMsgUniSeq = paramCursor.getLong(i);
      break label5969;
      label8110:
      paramauko.dwLastBAFTipMsgUniSeq2 = paramCursor.getLong(i);
      break label6006;
      label8125:
      paramauko.dailyNewMemberUins = paramCursor.getString(i);
      break label6043;
      label8140:
      paramauko.exitTroopReason = paramCursor.getInt(i);
      break label6080;
      label8155:
      paramauko.eliminated = paramCursor.getInt(i);
      break label6117;
      label8170:
      paramauko.mIsFreezed = paramCursor.getInt(i);
      break label6154;
      label8185:
      paramauko.strLastAnnouncement = paramCursor.getString(i);
      break label6191;
      label8200:
      paramauko.nMsgLimitFreq = paramCursor.getInt(i);
      break label6228;
      label8215:
      paramauko.mAtOrReplyMeUins = paramCursor.getString(i);
      break label6265;
      label8230:
      paramauko.groupFlagExt4 = paramCursor.getInt(i);
      break label6302;
      label8245:
      paramauko.groupFreezeReason = paramCursor.getInt(i);
      break label6339;
      label8260:
      paramauko.troopHonorGrayFlag = paramCursor.getInt(i);
      break label6376;
      label8275:
      paramauko.isAllowHistoryMsgFlag = paramCursor.getInt(i);
      break label6413;
      label8290:
      paramauko.troopRepeatType = paramCursor.getInt(i);
    }
    label8305:
    paramauko.feeds_id = paramCursor.getString(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,timeSec INTEGER ,troopuin TEXT UNIQUE ,troopcode TEXT ,troopowneruin TEXT ,troopname TEXT ,newTroopName TEXT ,newTroopNameTimeStamp INTEGER ,troopface INTEGER ,troopmemo TEXT ,fingertroopmemo TEXT ,mRichFingerMemo TEXT ,troopmask INTEGER ,trooptype INTEGER ,troopCreateTime INTEGER ,dwGroupFlag INTEGER ,cGroupOption INTEGER ,wMemberMax INTEGER ,maxAdminNum INTEGER ,wSpecialClass INTEGER ,cGroupLevel INTEGER ,wMemberNum INTEGER ,wMemberNumClient INTEGER ,Administrator TEXT ,dwGroupClassExt INTEGER ,mGroupClassExtText TEXT ,dwGroupFlagExt INTEGER ,dwAuthGroupType INTEGER ,troopAuthenticateInfo TEXT ,dwGroupInfoSeq INTEGER ,mMemberNumSeq INTEGER ,mOldMemberNumSeq INTEGER ,mMemberCardSeq INTEGER ,mOldMemberCardSeq INTEGER ,dwGroupLevelSeq INTEGER ,cGroupRankSysFlag INTEGER ,cGroupRankUserFlag INTEGER ,troopLevelMap TEXT ,joinTroopQuestion TEXT ,joinTroopAnswer TEXT ,cAlbumResult INTEGER ,dwTimeStamp INTEGER ,strQZonePhotoUrls TEXT ,mQZonePhotoNum INTEGER ,strLocation TEXT ,troopLat INTEGER ,troopLon INTEGER ,mMemberInvitingFlag INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,mSomeMemberUins TEXT ,mHeaderUinsOld TEXT ,mHeaderUinsNew TEXT ,mTags TEXT ,mTroopAvatarId INTEGER ,mTroopPicListJson TEXT ,nTroopGrade INTEGER ,isShowInNearbyTroops INTEGER ,dwGagTimeStamp INTEGER ,dwGagTimeStamp_me INTEGER ,dwCmdUinUinFlag INTEGER ,dwAdditionalFlag INTEGER ,troopTypeExt INTEGER ,ownerNameShow TEXT ,adminNameShow TEXT ,dwOfficeMode INTEGER ,dwGroupFlagExt3 INTEGER ,cmdUinFlagEx2 INTEGER ,udwCmdUinRingtoneID INTEGER ,memberListToShow TEXT ,troopPrivilegeFlag INTEGER ,isNewTroop INTEGER ,hasSetNewTroopHead INTEGER ,hasSetNewTroopName INTEGER ,maxInviteMemNum INTEGER ,lastMsgTime INTEGER ,allowMemberModifTroopName INTEGER ,allowMemberKick INTEGER ,allowMemberAtAll INTEGER ,oldTroopName TEXT ,hlGuildAppid INTEGER ,hlGuildSubType INTEGER ,hlGuildOrgid INTEGER ,hlGuildBinary INTEGER ,gameSwitchStatus INTEGER ,showGameSwitchStatus INTEGER ,lastShareLbsMsgUniseq INTEGER ,mTroopNeedPayNumber REAL ,troopCreditLevel INTEGER ,troopCreditLevelInfo INTEGER ,dwAppPrivilegeFlag INTEGER ,topicId TEXT ,associatePubAccount INTEGER ,mTroopFileVideoReqInterval INTEGER ,mTroopFileVideoIsWhite INTEGER ,mTribeStatus INTEGER ,mCanSearchByKeywords INTEGER ,mCanSearchByTroopUin INTEGER ,dwCmdUinJoinTime INTEGER ,dwLastInsertBAFTipTime INTEGER ,wInsertBAFTipCount INTEGER ,wClickBAFTipCount INTEGER ,dwLastBAFTipMsgUniSeq INTEGER ,dwLastBAFTipMsgUniSeq2 INTEGER ,dailyNewMemberUins TEXT ,exitTroopReason INTEGER ,eliminated INTEGER ,mIsFreezed INTEGER ,strLastAnnouncement TEXT ,nMsgLimitFreq INTEGER ,mAtOrReplyMeUins TEXT ,groupFlagExt4 INTEGER ,groupFreezeReason INTEGER ,troopHonorGrayFlag INTEGER ,isAllowHistoryMsgFlag INTEGER ,troopRepeatType INTEGER ,feeds_id TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (TroopInfo)paramauko;
    paramContentValues.put("uin", paramauko.uin);
    paramContentValues.put("timeSec", Long.valueOf(paramauko.timeSec));
    paramContentValues.put("troopuin", paramauko.troopuin);
    paramContentValues.put("troopcode", paramauko.troopcode);
    paramContentValues.put("troopowneruin", paramauko.troopowneruin);
    paramContentValues.put("troopname", paramauko.troopname);
    paramContentValues.put("newTroopName", paramauko.newTroopName);
    paramContentValues.put("newTroopNameTimeStamp", Long.valueOf(paramauko.newTroopNameTimeStamp));
    paramContentValues.put("troopface", Short.valueOf(paramauko.troopface));
    paramContentValues.put("troopmemo", paramauko.troopmemo);
    paramContentValues.put("fingertroopmemo", paramauko.fingertroopmemo);
    paramContentValues.put("mRichFingerMemo", paramauko.mRichFingerMemo);
    paramContentValues.put("troopmask", Integer.valueOf(paramauko.troopmask));
    paramContentValues.put("trooptype", Integer.valueOf(paramauko.trooptype));
    paramContentValues.put("troopCreateTime", Long.valueOf(paramauko.troopCreateTime));
    paramContentValues.put("dwGroupFlag", Long.valueOf(paramauko.dwGroupFlag));
    paramContentValues.put("cGroupOption", Short.valueOf(paramauko.cGroupOption));
    paramContentValues.put("wMemberMax", Integer.valueOf(paramauko.wMemberMax));
    paramContentValues.put("maxAdminNum", Integer.valueOf(paramauko.maxAdminNum));
    paramContentValues.put("wSpecialClass", Integer.valueOf(paramauko.wSpecialClass));
    paramContentValues.put("cGroupLevel", Short.valueOf(paramauko.cGroupLevel));
    paramContentValues.put("wMemberNum", Integer.valueOf(paramauko.wMemberNum));
    paramContentValues.put("wMemberNumClient", Integer.valueOf(paramauko.wMemberNumClient));
    paramContentValues.put("Administrator", paramauko.Administrator);
    paramContentValues.put("dwGroupClassExt", Long.valueOf(paramauko.dwGroupClassExt));
    paramContentValues.put("mGroupClassExtText", paramauko.mGroupClassExtText);
    paramContentValues.put("dwGroupFlagExt", Long.valueOf(paramauko.dwGroupFlagExt));
    paramContentValues.put("dwAuthGroupType", Long.valueOf(paramauko.dwAuthGroupType));
    paramContentValues.put("troopAuthenticateInfo", paramauko.troopAuthenticateInfo);
    paramContentValues.put("dwGroupInfoSeq", Long.valueOf(paramauko.dwGroupInfoSeq));
    paramContentValues.put("mMemberNumSeq", Long.valueOf(paramauko.mMemberNumSeq));
    paramContentValues.put("mOldMemberNumSeq", Long.valueOf(paramauko.mOldMemberNumSeq));
    paramContentValues.put("mMemberCardSeq", Long.valueOf(paramauko.mMemberCardSeq));
    paramContentValues.put("mOldMemberCardSeq", Long.valueOf(paramauko.mOldMemberCardSeq));
    paramContentValues.put("dwGroupLevelSeq", Long.valueOf(paramauko.dwGroupLevelSeq));
    paramContentValues.put("cGroupRankSysFlag", Byte.valueOf(paramauko.cGroupRankSysFlag));
    paramContentValues.put("cGroupRankUserFlag", Byte.valueOf(paramauko.cGroupRankUserFlag));
    paramContentValues.put("troopLevelMap", paramauko.troopLevelMap);
    paramContentValues.put("joinTroopQuestion", paramauko.joinTroopQuestion);
    paramContentValues.put("joinTroopAnswer", paramauko.joinTroopAnswer);
    paramContentValues.put("cAlbumResult", Byte.valueOf(paramauko.cAlbumResult));
    paramContentValues.put("dwTimeStamp", Long.valueOf(paramauko.dwTimeStamp));
    paramContentValues.put("strQZonePhotoUrls", paramauko.strQZonePhotoUrls);
    paramContentValues.put("mQZonePhotoNum", Integer.valueOf(paramauko.mQZonePhotoNum));
    paramContentValues.put("strLocation", paramauko.strLocation);
    paramContentValues.put("troopLat", Integer.valueOf(paramauko.troopLat));
    paramContentValues.put("troopLon", Integer.valueOf(paramauko.troopLon));
    paramContentValues.put("mMemberInvitingFlag", Boolean.valueOf(paramauko.mMemberInvitingFlag));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramauko.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramauko.mCompareSpell);
    paramContentValues.put("mSomeMemberUins", paramauko.mSomeMemberUins);
    paramContentValues.put("mHeaderUinsOld", paramauko.mHeaderUinsOld);
    paramContentValues.put("mHeaderUinsNew", paramauko.mHeaderUinsNew);
    paramContentValues.put("mTags", paramauko.mTags);
    paramContentValues.put("mTroopAvatarId", Integer.valueOf(paramauko.mTroopAvatarId));
    paramContentValues.put("mTroopPicListJson", paramauko.mTroopPicListJson);
    paramContentValues.put("nTroopGrade", Integer.valueOf(paramauko.nTroopGrade));
    paramContentValues.put("isShowInNearbyTroops", Integer.valueOf(paramauko.isShowInNearbyTroops));
    paramContentValues.put("dwGagTimeStamp", Long.valueOf(paramauko.dwGagTimeStamp));
    paramContentValues.put("dwGagTimeStamp_me", Long.valueOf(paramauko.dwGagTimeStamp_me));
    paramContentValues.put("dwCmdUinUinFlag", Long.valueOf(paramauko.dwCmdUinUinFlag));
    paramContentValues.put("dwAdditionalFlag", Long.valueOf(paramauko.dwAdditionalFlag));
    paramContentValues.put("troopTypeExt", Integer.valueOf(paramauko.troopTypeExt));
    paramContentValues.put("ownerNameShow", paramauko.ownerNameShow);
    paramContentValues.put("adminNameShow", paramauko.adminNameShow);
    paramContentValues.put("dwOfficeMode", Long.valueOf(paramauko.dwOfficeMode));
    paramContentValues.put("dwGroupFlagExt3", Long.valueOf(paramauko.dwGroupFlagExt3));
    paramContentValues.put("cmdUinFlagEx2", Long.valueOf(paramauko.cmdUinFlagEx2));
    paramContentValues.put("udwCmdUinRingtoneID", Long.valueOf(paramauko.udwCmdUinRingtoneID));
    paramContentValues.put("memberListToShow", paramauko.memberListToShow);
    paramContentValues.put("troopPrivilegeFlag", Long.valueOf(paramauko.troopPrivilegeFlag));
    paramContentValues.put("isNewTroop", Boolean.valueOf(paramauko.isNewTroop));
    paramContentValues.put("hasSetNewTroopHead", Boolean.valueOf(paramauko.hasSetNewTroopHead));
    paramContentValues.put("hasSetNewTroopName", Boolean.valueOf(paramauko.hasSetNewTroopName));
    paramContentValues.put("maxInviteMemNum", Integer.valueOf(paramauko.maxInviteMemNum));
    paramContentValues.put("lastMsgTime", Long.valueOf(paramauko.lastMsgTime));
    paramContentValues.put("allowMemberModifTroopName", Integer.valueOf(paramauko.allowMemberModifTroopName));
    paramContentValues.put("allowMemberKick", Integer.valueOf(paramauko.allowMemberKick));
    paramContentValues.put("allowMemberAtAll", Integer.valueOf(paramauko.allowMemberAtAll));
    paramContentValues.put("oldTroopName", paramauko.oldTroopName);
    paramContentValues.put("hlGuildAppid", Long.valueOf(paramauko.hlGuildAppid));
    paramContentValues.put("hlGuildSubType", Long.valueOf(paramauko.hlGuildSubType));
    paramContentValues.put("hlGuildOrgid", Integer.valueOf(paramauko.hlGuildOrgid));
    paramContentValues.put("hlGuildBinary", Integer.valueOf(paramauko.hlGuildBinary));
    paramContentValues.put("gameSwitchStatus", Integer.valueOf(paramauko.gameSwitchStatus));
    paramContentValues.put("showGameSwitchStatus", Integer.valueOf(paramauko.showGameSwitchStatus));
    paramContentValues.put("lastShareLbsMsgUniseq", Long.valueOf(paramauko.lastShareLbsMsgUniseq));
    paramContentValues.put("mTroopNeedPayNumber", Float.valueOf(paramauko.mTroopNeedPayNumber));
    paramContentValues.put("troopCreditLevel", Long.valueOf(paramauko.troopCreditLevel));
    paramContentValues.put("troopCreditLevelInfo", Long.valueOf(paramauko.troopCreditLevelInfo));
    paramContentValues.put("dwAppPrivilegeFlag", Long.valueOf(paramauko.dwAppPrivilegeFlag));
    paramContentValues.put("topicId", paramauko.topicId);
    paramContentValues.put("associatePubAccount", Long.valueOf(paramauko.associatePubAccount));
    paramContentValues.put("mTroopFileVideoReqInterval", Long.valueOf(paramauko.mTroopFileVideoReqInterval));
    paramContentValues.put("mTroopFileVideoIsWhite", Integer.valueOf(paramauko.mTroopFileVideoIsWhite));
    paramContentValues.put("mTribeStatus", Integer.valueOf(paramauko.mTribeStatus));
    paramContentValues.put("mCanSearchByKeywords", Boolean.valueOf(paramauko.mCanSearchByKeywords));
    paramContentValues.put("mCanSearchByTroopUin", Boolean.valueOf(paramauko.mCanSearchByTroopUin));
    paramContentValues.put("dwCmdUinJoinTime", Long.valueOf(paramauko.dwCmdUinJoinTime));
    paramContentValues.put("dwLastInsertBAFTipTime", Long.valueOf(paramauko.dwLastInsertBAFTipTime));
    paramContentValues.put("wInsertBAFTipCount", Integer.valueOf(paramauko.wInsertBAFTipCount));
    paramContentValues.put("wClickBAFTipCount", Integer.valueOf(paramauko.wClickBAFTipCount));
    paramContentValues.put("dwLastBAFTipMsgUniSeq", Long.valueOf(paramauko.dwLastBAFTipMsgUniSeq));
    paramContentValues.put("dwLastBAFTipMsgUniSeq2", Long.valueOf(paramauko.dwLastBAFTipMsgUniSeq2));
    paramContentValues.put("dailyNewMemberUins", paramauko.dailyNewMemberUins);
    paramContentValues.put("exitTroopReason", Integer.valueOf(paramauko.exitTroopReason));
    paramContentValues.put("eliminated", Integer.valueOf(paramauko.eliminated));
    paramContentValues.put("mIsFreezed", Integer.valueOf(paramauko.mIsFreezed));
    paramContentValues.put("strLastAnnouncement", paramauko.strLastAnnouncement);
    paramContentValues.put("nMsgLimitFreq", Integer.valueOf(paramauko.nMsgLimitFreq));
    paramContentValues.put("mAtOrReplyMeUins", paramauko.mAtOrReplyMeUins);
    paramContentValues.put("groupFlagExt4", Integer.valueOf(paramauko.groupFlagExt4));
    paramContentValues.put("groupFreezeReason", Integer.valueOf(paramauko.groupFreezeReason));
    paramContentValues.put("troopHonorGrayFlag", Integer.valueOf(paramauko.troopHonorGrayFlag));
    paramContentValues.put("isAllowHistoryMsgFlag", Integer.valueOf(paramauko.isAllowHistoryMsgFlag));
    paramContentValues.put("troopRepeatType", Integer.valueOf(paramauko.troopRepeatType));
    paramContentValues.put("feeds_id", paramauko.feeds_id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auls
 * JD-Core Version:    0.7.0.1
 */