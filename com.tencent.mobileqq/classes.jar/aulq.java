import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aulq
  extends auky
{
  public aulq()
  {
    this.a = 117;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramaukm = (TroopInfo)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramaukm.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
      paramaukm.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
      paramaukm.troopcode = paramCursor.getString(paramCursor.getColumnIndex("troopcode"));
      paramaukm.troopowneruin = paramCursor.getString(paramCursor.getColumnIndex("troopowneruin"));
      paramaukm.troopname = paramCursor.getString(paramCursor.getColumnIndex("troopname"));
      paramaukm.newTroopName = paramCursor.getString(paramCursor.getColumnIndex("newTroopName"));
      paramaukm.newTroopNameTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("newTroopNameTimeStamp"));
      paramaukm.troopface = paramCursor.getShort(paramCursor.getColumnIndex("troopface"));
      paramaukm.troopmemo = paramCursor.getString(paramCursor.getColumnIndex("troopmemo"));
      paramaukm.fingertroopmemo = paramCursor.getString(paramCursor.getColumnIndex("fingertroopmemo"));
      paramaukm.mRichFingerMemo = paramCursor.getString(paramCursor.getColumnIndex("mRichFingerMemo"));
      paramaukm.troopmask = paramCursor.getInt(paramCursor.getColumnIndex("troopmask"));
      paramaukm.trooptype = paramCursor.getInt(paramCursor.getColumnIndex("trooptype"));
      paramaukm.troopCreateTime = paramCursor.getLong(paramCursor.getColumnIndex("troopCreateTime"));
      paramaukm.dwGroupFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlag"));
      paramaukm.cGroupOption = paramCursor.getShort(paramCursor.getColumnIndex("cGroupOption"));
      paramaukm.wMemberMax = paramCursor.getInt(paramCursor.getColumnIndex("wMemberMax"));
      paramaukm.maxAdminNum = paramCursor.getInt(paramCursor.getColumnIndex("maxAdminNum"));
      paramaukm.wSpecialClass = paramCursor.getInt(paramCursor.getColumnIndex("wSpecialClass"));
      paramaukm.cGroupLevel = paramCursor.getShort(paramCursor.getColumnIndex("cGroupLevel"));
      paramaukm.wMemberNum = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNum"));
      paramaukm.wMemberNumClient = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNumClient"));
      paramaukm.Administrator = paramCursor.getString(paramCursor.getColumnIndex("Administrator"));
      paramaukm.dwGroupClassExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupClassExt"));
      paramaukm.mGroupClassExtText = paramCursor.getString(paramCursor.getColumnIndex("mGroupClassExtText"));
      paramaukm.dwGroupFlagExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt"));
      paramaukm.dwAuthGroupType = paramCursor.getLong(paramCursor.getColumnIndex("dwAuthGroupType"));
      paramaukm.troopAuthenticateInfo = paramCursor.getString(paramCursor.getColumnIndex("troopAuthenticateInfo"));
      paramaukm.dwGroupInfoSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupInfoSeq"));
      paramaukm.mMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberNumSeq"));
      paramaukm.mOldMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberNumSeq"));
      paramaukm.mMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberCardSeq"));
      paramaukm.mOldMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberCardSeq"));
      paramaukm.dwGroupLevelSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupLevelSeq"));
      paramaukm.cGroupRankSysFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankSysFlag")));
      paramaukm.cGroupRankUserFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankUserFlag")));
      paramaukm.troopLevelMap = paramCursor.getString(paramCursor.getColumnIndex("troopLevelMap"));
      paramaukm.joinTroopQuestion = paramCursor.getString(paramCursor.getColumnIndex("joinTroopQuestion"));
      paramaukm.joinTroopAnswer = paramCursor.getString(paramCursor.getColumnIndex("joinTroopAnswer"));
      paramaukm.cAlbumResult = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cAlbumResult")));
      paramaukm.dwTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwTimeStamp"));
      paramaukm.strQZonePhotoUrls = paramCursor.getString(paramCursor.getColumnIndex("strQZonePhotoUrls"));
      paramaukm.mQZonePhotoNum = paramCursor.getInt(paramCursor.getColumnIndex("mQZonePhotoNum"));
      paramaukm.strLocation = paramCursor.getString(paramCursor.getColumnIndex("strLocation"));
      paramaukm.troopLat = paramCursor.getInt(paramCursor.getColumnIndex("troopLat"));
      paramaukm.troopLon = paramCursor.getInt(paramCursor.getColumnIndex("troopLon"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("mMemberInvitingFlag")))
      {
        paramBoolean = true;
        paramaukm.mMemberInvitingFlag = paramBoolean;
        paramaukm.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramaukm.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramaukm.mSomeMemberUins = paramCursor.getString(paramCursor.getColumnIndex("mSomeMemberUins"));
        paramaukm.mHeaderUinsOld = paramCursor.getString(paramCursor.getColumnIndex("mHeaderUinsOld"));
        paramaukm.mHeaderUinsNew = paramCursor.getString(paramCursor.getColumnIndex("mHeaderUinsNew"));
        paramaukm.mTags = paramCursor.getString(paramCursor.getColumnIndex("mTags"));
        paramaukm.mTroopAvatarId = paramCursor.getInt(paramCursor.getColumnIndex("mTroopAvatarId"));
        paramaukm.mTroopPicListJson = paramCursor.getString(paramCursor.getColumnIndex("mTroopPicListJson"));
        paramaukm.nTroopGrade = paramCursor.getInt(paramCursor.getColumnIndex("nTroopGrade"));
        paramaukm.isShowInNearbyTroops = paramCursor.getInt(paramCursor.getColumnIndex("isShowInNearbyTroops"));
        paramaukm.dwGagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp"));
        paramaukm.dwGagTimeStamp_me = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp_me"));
        paramaukm.dwCmdUinUinFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwCmdUinUinFlag"));
        paramaukm.dwAdditionalFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAdditionalFlag"));
        paramaukm.troopTypeExt = paramCursor.getInt(paramCursor.getColumnIndex("troopTypeExt"));
        paramaukm.ownerNameShow = paramCursor.getString(paramCursor.getColumnIndex("ownerNameShow"));
        paramaukm.adminNameShow = paramCursor.getString(paramCursor.getColumnIndex("adminNameShow"));
        paramaukm.dwOfficeMode = paramCursor.getLong(paramCursor.getColumnIndex("dwOfficeMode"));
        paramaukm.dwGroupFlagExt3 = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt3"));
        paramaukm.cmdUinFlagEx2 = paramCursor.getLong(paramCursor.getColumnIndex("cmdUinFlagEx2"));
        paramaukm.udwCmdUinRingtoneID = paramCursor.getLong(paramCursor.getColumnIndex("udwCmdUinRingtoneID"));
        paramaukm.memberListToShow = paramCursor.getString(paramCursor.getColumnIndex("memberListToShow"));
        paramaukm.troopPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("troopPrivilegeFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isNewTroop"))) {
          break label2239;
        }
        paramBoolean = true;
        label1343:
        paramaukm.isNewTroop = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSetNewTroopHead"))) {
          break label2244;
        }
        paramBoolean = true;
        label1369:
        paramaukm.hasSetNewTroopHead = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSetNewTroopName"))) {
          break label2249;
        }
        paramBoolean = true;
        label1395:
        paramaukm.hasSetNewTroopName = paramBoolean;
        paramaukm.maxInviteMemNum = paramCursor.getInt(paramCursor.getColumnIndex("maxInviteMemNum"));
        paramaukm.lastMsgTime = paramCursor.getLong(paramCursor.getColumnIndex("lastMsgTime"));
        paramaukm.allowMemberModifTroopName = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberModifTroopName"));
        paramaukm.allowMemberKick = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberKick"));
        paramaukm.allowMemberAtAll = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberAtAll"));
        paramaukm.oldTroopName = paramCursor.getString(paramCursor.getColumnIndex("oldTroopName"));
        paramaukm.hlGuildAppid = paramCursor.getLong(paramCursor.getColumnIndex("hlGuildAppid"));
        paramaukm.hlGuildSubType = paramCursor.getLong(paramCursor.getColumnIndex("hlGuildSubType"));
        paramaukm.hlGuildOrgid = paramCursor.getInt(paramCursor.getColumnIndex("hlGuildOrgid"));
        paramaukm.hlGuildBinary = paramCursor.getInt(paramCursor.getColumnIndex("hlGuildBinary"));
        paramaukm.gameSwitchStatus = paramCursor.getInt(paramCursor.getColumnIndex("gameSwitchStatus"));
        paramaukm.showGameSwitchStatus = paramCursor.getInt(paramCursor.getColumnIndex("showGameSwitchStatus"));
        paramaukm.lastShareLbsMsgUniseq = paramCursor.getLong(paramCursor.getColumnIndex("lastShareLbsMsgUniseq"));
        paramaukm.mTroopNeedPayNumber = paramCursor.getFloat(paramCursor.getColumnIndex("mTroopNeedPayNumber"));
        paramaukm.troopCreditLevel = paramCursor.getLong(paramCursor.getColumnIndex("troopCreditLevel"));
        paramaukm.troopCreditLevelInfo = paramCursor.getLong(paramCursor.getColumnIndex("troopCreditLevelInfo"));
        paramaukm.dwAppPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAppPrivilegeFlag"));
        paramaukm.topicId = paramCursor.getString(paramCursor.getColumnIndex("topicId"));
        paramaukm.associatePubAccount = paramCursor.getLong(paramCursor.getColumnIndex("associatePubAccount"));
        paramaukm.mTroopFileVideoReqInterval = paramCursor.getLong(paramCursor.getColumnIndex("mTroopFileVideoReqInterval"));
        paramaukm.mTroopFileVideoIsWhite = paramCursor.getInt(paramCursor.getColumnIndex("mTroopFileVideoIsWhite"));
        paramaukm.mTribeStatus = paramCursor.getInt(paramCursor.getColumnIndex("mTribeStatus"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mCanSearchByKeywords"))) {
          break label2254;
        }
        paramBoolean = true;
        label1839:
        paramaukm.mCanSearchByKeywords = paramBoolean;
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
        paramaukm.mCanSearchByTroopUin = paramBoolean;
        paramaukm.dwCmdUinJoinTime = paramCursor.getLong(paramCursor.getColumnIndex("dwCmdUinJoinTime"));
        paramaukm.dwLastInsertBAFTipTime = paramCursor.getLong(paramCursor.getColumnIndex("dwLastInsertBAFTipTime"));
        paramaukm.wInsertBAFTipCount = paramCursor.getInt(paramCursor.getColumnIndex("wInsertBAFTipCount"));
        paramaukm.wClickBAFTipCount = paramCursor.getInt(paramCursor.getColumnIndex("wClickBAFTipCount"));
        paramaukm.dwLastBAFTipMsgUniSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq"));
        paramaukm.dwLastBAFTipMsgUniSeq2 = paramCursor.getLong(paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq2"));
        paramaukm.dailyNewMemberUins = paramCursor.getString(paramCursor.getColumnIndex("dailyNewMemberUins"));
        paramaukm.exitTroopReason = paramCursor.getInt(paramCursor.getColumnIndex("exitTroopReason"));
        paramaukm.eliminated = paramCursor.getInt(paramCursor.getColumnIndex("eliminated"));
        paramaukm.mIsFreezed = paramCursor.getInt(paramCursor.getColumnIndex("mIsFreezed"));
        paramaukm.strLastAnnouncement = paramCursor.getString(paramCursor.getColumnIndex("strLastAnnouncement"));
        paramaukm.nMsgLimitFreq = paramCursor.getInt(paramCursor.getColumnIndex("nMsgLimitFreq"));
        paramaukm.mAtOrReplyMeUins = paramCursor.getString(paramCursor.getColumnIndex("mAtOrReplyMeUins"));
        paramaukm.groupFlagExt4 = paramCursor.getInt(paramCursor.getColumnIndex("groupFlagExt4"));
        paramaukm.groupFreezeReason = paramCursor.getInt(paramCursor.getColumnIndex("groupFreezeReason"));
        paramaukm.troopHonorGrayFlag = paramCursor.getInt(paramCursor.getColumnIndex("troopHonorGrayFlag"));
        paramaukm.isAllowHistoryMsgFlag = paramCursor.getInt(paramCursor.getColumnIndex("isAllowHistoryMsgFlag"));
        paramaukm.troopRepeatType = paramCursor.getInt(paramCursor.getColumnIndex("troopRepeatType"));
        paramaukm.feeds_id = paramCursor.getString(paramCursor.getColumnIndex("feeds_id"));
        return paramaukm;
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
      paramaukx.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("timeSec");
      if (i != -1) {
        break label6504;
      }
      paramaukx.a(new NoColumnError("timeSec", Long.TYPE));
      label2334:
      i = paramCursor.getColumnIndex("troopuin");
      if (i != -1) {
        break label6519;
      }
      paramaukx.a(new NoColumnError("troopuin", String.class));
      label2369:
      i = paramCursor.getColumnIndex("troopcode");
      if (i != -1) {
        break label6534;
      }
      paramaukx.a(new NoColumnError("troopcode", String.class));
      label2404:
      i = paramCursor.getColumnIndex("troopowneruin");
      if (i != -1) {
        break label6549;
      }
      paramaukx.a(new NoColumnError("troopowneruin", String.class));
      label2439:
      i = paramCursor.getColumnIndex("troopname");
      if (i != -1) {
        break label6564;
      }
      paramaukx.a(new NoColumnError("troopname", String.class));
      label2474:
      i = paramCursor.getColumnIndex("newTroopName");
      if (i != -1) {
        break label6579;
      }
      paramaukx.a(new NoColumnError("newTroopName", String.class));
      label2509:
      i = paramCursor.getColumnIndex("newTroopNameTimeStamp");
      if (i != -1) {
        break label6594;
      }
      paramaukx.a(new NoColumnError("newTroopNameTimeStamp", Long.TYPE));
      label2544:
      i = paramCursor.getColumnIndex("troopface");
      if (i != -1) {
        break label6609;
      }
      paramaukx.a(new NoColumnError("troopface", Short.TYPE));
      label2579:
      i = paramCursor.getColumnIndex("troopmemo");
      if (i != -1) {
        break label6624;
      }
      paramaukx.a(new NoColumnError("troopmemo", String.class));
      label2614:
      i = paramCursor.getColumnIndex("fingertroopmemo");
      if (i != -1) {
        break label6639;
      }
      paramaukx.a(new NoColumnError("fingertroopmemo", String.class));
      label2649:
      i = paramCursor.getColumnIndex("mRichFingerMemo");
      if (i != -1) {
        break label6654;
      }
      paramaukx.a(new NoColumnError("mRichFingerMemo", String.class));
      label2684:
      i = paramCursor.getColumnIndex("troopmask");
      if (i != -1) {
        break label6669;
      }
      paramaukx.a(new NoColumnError("troopmask", Integer.TYPE));
      label2719:
      i = paramCursor.getColumnIndex("trooptype");
      if (i != -1) {
        break label6684;
      }
      paramaukx.a(new NoColumnError("trooptype", Integer.TYPE));
      label2754:
      i = paramCursor.getColumnIndex("troopCreateTime");
      if (i != -1) {
        break label6699;
      }
      paramaukx.a(new NoColumnError("troopCreateTime", Long.TYPE));
      label2789:
      i = paramCursor.getColumnIndex("dwGroupFlag");
      if (i != -1) {
        break label6714;
      }
      paramaukx.a(new NoColumnError("dwGroupFlag", Long.TYPE));
      label2824:
      i = paramCursor.getColumnIndex("cGroupOption");
      if (i != -1) {
        break label6729;
      }
      paramaukx.a(new NoColumnError("cGroupOption", Short.TYPE));
      label2859:
      i = paramCursor.getColumnIndex("wMemberMax");
      if (i != -1) {
        break label6744;
      }
      paramaukx.a(new NoColumnError("wMemberMax", Integer.TYPE));
      label2894:
      i = paramCursor.getColumnIndex("maxAdminNum");
      if (i != -1) {
        break label6759;
      }
      paramaukx.a(new NoColumnError("maxAdminNum", Integer.TYPE));
      label2929:
      i = paramCursor.getColumnIndex("wSpecialClass");
      if (i != -1) {
        break label6774;
      }
      paramaukx.a(new NoColumnError("wSpecialClass", Integer.TYPE));
      label2964:
      i = paramCursor.getColumnIndex("cGroupLevel");
      if (i != -1) {
        break label6789;
      }
      paramaukx.a(new NoColumnError("cGroupLevel", Short.TYPE));
      label2999:
      i = paramCursor.getColumnIndex("wMemberNum");
      if (i != -1) {
        break label6804;
      }
      paramaukx.a(new NoColumnError("wMemberNum", Integer.TYPE));
      label3034:
      i = paramCursor.getColumnIndex("wMemberNumClient");
      if (i != -1) {
        break label6819;
      }
      paramaukx.a(new NoColumnError("wMemberNumClient", Integer.TYPE));
      label3069:
      i = paramCursor.getColumnIndex("Administrator");
      if (i != -1) {
        break label6834;
      }
      paramaukx.a(new NoColumnError("Administrator", String.class));
      label3104:
      i = paramCursor.getColumnIndex("dwGroupClassExt");
      if (i != -1) {
        break label6849;
      }
      paramaukx.a(new NoColumnError("dwGroupClassExt", Long.TYPE));
      label3139:
      i = paramCursor.getColumnIndex("mGroupClassExtText");
      if (i != -1) {
        break label6864;
      }
      paramaukx.a(new NoColumnError("mGroupClassExtText", String.class));
      label3174:
      i = paramCursor.getColumnIndex("dwGroupFlagExt");
      if (i != -1) {
        break label6879;
      }
      paramaukx.a(new NoColumnError("dwGroupFlagExt", Long.TYPE));
      label3209:
      i = paramCursor.getColumnIndex("dwAuthGroupType");
      if (i != -1) {
        break label6894;
      }
      paramaukx.a(new NoColumnError("dwAuthGroupType", Long.TYPE));
      label3244:
      i = paramCursor.getColumnIndex("troopAuthenticateInfo");
      if (i != -1) {
        break label6909;
      }
      paramaukx.a(new NoColumnError("troopAuthenticateInfo", String.class));
      label3279:
      i = paramCursor.getColumnIndex("dwGroupInfoSeq");
      if (i != -1) {
        break label6924;
      }
      paramaukx.a(new NoColumnError("dwGroupInfoSeq", Long.TYPE));
      label3314:
      i = paramCursor.getColumnIndex("mMemberNumSeq");
      if (i != -1) {
        break label6939;
      }
      paramaukx.a(new NoColumnError("mMemberNumSeq", Long.TYPE));
      label3349:
      i = paramCursor.getColumnIndex("mOldMemberNumSeq");
      if (i != -1) {
        break label6954;
      }
      paramaukx.a(new NoColumnError("mOldMemberNumSeq", Long.TYPE));
      label3384:
      i = paramCursor.getColumnIndex("mMemberCardSeq");
      if (i != -1) {
        break label6969;
      }
      paramaukx.a(new NoColumnError("mMemberCardSeq", Long.TYPE));
      label3419:
      i = paramCursor.getColumnIndex("mOldMemberCardSeq");
      if (i != -1) {
        break label6984;
      }
      paramaukx.a(new NoColumnError("mOldMemberCardSeq", Long.TYPE));
      label3454:
      i = paramCursor.getColumnIndex("dwGroupLevelSeq");
      if (i != -1) {
        break label6999;
      }
      paramaukx.a(new NoColumnError("dwGroupLevelSeq", Long.TYPE));
      label3489:
      i = paramCursor.getColumnIndex("cGroupRankSysFlag");
      if (i != -1) {
        break label7014;
      }
      paramaukx.a(new NoColumnError("cGroupRankSysFlag", Byte.TYPE));
      label3524:
      i = paramCursor.getColumnIndex("cGroupRankUserFlag");
      if (i != -1) {
        break label7030;
      }
      paramaukx.a(new NoColumnError("cGroupRankUserFlag", Byte.TYPE));
      label3559:
      i = paramCursor.getColumnIndex("troopLevelMap");
      if (i != -1) {
        break label7046;
      }
      paramaukx.a(new NoColumnError("troopLevelMap", String.class));
      label3594:
      i = paramCursor.getColumnIndex("joinTroopQuestion");
      if (i != -1) {
        break label7061;
      }
      paramaukx.a(new NoColumnError("joinTroopQuestion", String.class));
      label3629:
      i = paramCursor.getColumnIndex("joinTroopAnswer");
      if (i != -1) {
        break label7076;
      }
      paramaukx.a(new NoColumnError("joinTroopAnswer", String.class));
      label3664:
      i = paramCursor.getColumnIndex("cAlbumResult");
      if (i != -1) {
        break label7091;
      }
      paramaukx.a(new NoColumnError("cAlbumResult", Byte.TYPE));
      label3699:
      i = paramCursor.getColumnIndex("dwTimeStamp");
      if (i != -1) {
        break label7107;
      }
      paramaukx.a(new NoColumnError("dwTimeStamp", Long.TYPE));
      label3734:
      i = paramCursor.getColumnIndex("strQZonePhotoUrls");
      if (i != -1) {
        break label7122;
      }
      paramaukx.a(new NoColumnError("strQZonePhotoUrls", String.class));
      label3769:
      i = paramCursor.getColumnIndex("mQZonePhotoNum");
      if (i != -1) {
        break label7137;
      }
      paramaukx.a(new NoColumnError("mQZonePhotoNum", Integer.TYPE));
      label3804:
      i = paramCursor.getColumnIndex("strLocation");
      if (i != -1) {
        break label7152;
      }
      paramaukx.a(new NoColumnError("strLocation", String.class));
      label3839:
      i = paramCursor.getColumnIndex("troopLat");
      if (i != -1) {
        break label7167;
      }
      paramaukx.a(new NoColumnError("troopLat", Integer.TYPE));
      label3874:
      i = paramCursor.getColumnIndex("troopLon");
      if (i != -1) {
        break label7182;
      }
      paramaukx.a(new NoColumnError("troopLon", Integer.TYPE));
      label3909:
      i = paramCursor.getColumnIndex("mMemberInvitingFlag");
      if (i != -1) {
        break label7197;
      }
      paramaukx.a(new NoColumnError("mMemberInvitingFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label7224;
      }
      paramaukx.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label3979:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label7239;
      }
      paramaukx.a(new NoColumnError("mCompareSpell", String.class));
      label4014:
      i = paramCursor.getColumnIndex("mSomeMemberUins");
      if (i != -1) {
        break label7254;
      }
      paramaukx.a(new NoColumnError("mSomeMemberUins", String.class));
      label4049:
      i = paramCursor.getColumnIndex("mHeaderUinsOld");
      if (i != -1) {
        break label7269;
      }
      paramaukx.a(new NoColumnError("mHeaderUinsOld", String.class));
      label4084:
      i = paramCursor.getColumnIndex("mHeaderUinsNew");
      if (i != -1) {
        break label7284;
      }
      paramaukx.a(new NoColumnError("mHeaderUinsNew", String.class));
      label4119:
      i = paramCursor.getColumnIndex("mTags");
      if (i != -1) {
        break label7299;
      }
      paramaukx.a(new NoColumnError("mTags", String.class));
      label4156:
      i = paramCursor.getColumnIndex("mTroopAvatarId");
      if (i != -1) {
        break label7314;
      }
      paramaukx.a(new NoColumnError("mTroopAvatarId", Integer.TYPE));
      label4193:
      i = paramCursor.getColumnIndex("mTroopPicListJson");
      if (i != -1) {
        break label7329;
      }
      paramaukx.a(new NoColumnError("mTroopPicListJson", String.class));
      label4230:
      i = paramCursor.getColumnIndex("nTroopGrade");
      if (i != -1) {
        break label7344;
      }
      paramaukx.a(new NoColumnError("nTroopGrade", Integer.TYPE));
      label4267:
      i = paramCursor.getColumnIndex("isShowInNearbyTroops");
      if (i != -1) {
        break label7359;
      }
      paramaukx.a(new NoColumnError("isShowInNearbyTroops", Integer.TYPE));
      label4304:
      i = paramCursor.getColumnIndex("dwGagTimeStamp");
      if (i != -1) {
        break label7374;
      }
      paramaukx.a(new NoColumnError("dwGagTimeStamp", Long.TYPE));
      label4341:
      i = paramCursor.getColumnIndex("dwGagTimeStamp_me");
      if (i != -1) {
        break label7389;
      }
      paramaukx.a(new NoColumnError("dwGagTimeStamp_me", Long.TYPE));
      label4378:
      i = paramCursor.getColumnIndex("dwCmdUinUinFlag");
      if (i != -1) {
        break label7404;
      }
      paramaukx.a(new NoColumnError("dwCmdUinUinFlag", Long.TYPE));
      label4415:
      i = paramCursor.getColumnIndex("dwAdditionalFlag");
      if (i != -1) {
        break label7419;
      }
      paramaukx.a(new NoColumnError("dwAdditionalFlag", Long.TYPE));
      label4452:
      i = paramCursor.getColumnIndex("troopTypeExt");
      if (i != -1) {
        break label7434;
      }
      paramaukx.a(new NoColumnError("troopTypeExt", Integer.TYPE));
      label4489:
      i = paramCursor.getColumnIndex("ownerNameShow");
      if (i != -1) {
        break label7449;
      }
      paramaukx.a(new NoColumnError("ownerNameShow", String.class));
      label4526:
      i = paramCursor.getColumnIndex("adminNameShow");
      if (i != -1) {
        break label7464;
      }
      paramaukx.a(new NoColumnError("adminNameShow", String.class));
      label4563:
      i = paramCursor.getColumnIndex("dwOfficeMode");
      if (i != -1) {
        break label7479;
      }
      paramaukx.a(new NoColumnError("dwOfficeMode", Long.TYPE));
      label4600:
      i = paramCursor.getColumnIndex("dwGroupFlagExt3");
      if (i != -1) {
        break label7494;
      }
      paramaukx.a(new NoColumnError("dwGroupFlagExt3", Long.TYPE));
      label4637:
      i = paramCursor.getColumnIndex("cmdUinFlagEx2");
      if (i != -1) {
        break label7509;
      }
      paramaukx.a(new NoColumnError("cmdUinFlagEx2", Long.TYPE));
      label4674:
      i = paramCursor.getColumnIndex("udwCmdUinRingtoneID");
      if (i != -1) {
        break label7524;
      }
      paramaukx.a(new NoColumnError("udwCmdUinRingtoneID", Long.TYPE));
      label4711:
      i = paramCursor.getColumnIndex("memberListToShow");
      if (i != -1) {
        break label7539;
      }
      paramaukx.a(new NoColumnError("memberListToShow", String.class));
      label4748:
      i = paramCursor.getColumnIndex("troopPrivilegeFlag");
      if (i != -1) {
        break label7554;
      }
      paramaukx.a(new NoColumnError("troopPrivilegeFlag", Long.TYPE));
      label4785:
      i = paramCursor.getColumnIndex("isNewTroop");
      if (i != -1) {
        break label7569;
      }
      paramaukx.a(new NoColumnError("isNewTroop", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasSetNewTroopHead");
      if (i != -1) {
        break label7596;
      }
      paramaukx.a(new NoColumnError("hasSetNewTroopHead", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasSetNewTroopName");
      if (i != -1) {
        break label7623;
      }
      paramaukx.a(new NoColumnError("hasSetNewTroopName", Boolean.TYPE));
      i = paramCursor.getColumnIndex("maxInviteMemNum");
      if (i != -1) {
        break label7650;
      }
      paramaukx.a(new NoColumnError("maxInviteMemNum", Integer.TYPE));
      label4933:
      i = paramCursor.getColumnIndex("lastMsgTime");
      if (i != -1) {
        break label7665;
      }
      paramaukx.a(new NoColumnError("lastMsgTime", Long.TYPE));
      label4970:
      i = paramCursor.getColumnIndex("allowMemberModifTroopName");
      if (i != -1) {
        break label7680;
      }
      paramaukx.a(new NoColumnError("allowMemberModifTroopName", Integer.TYPE));
      label5007:
      i = paramCursor.getColumnIndex("allowMemberKick");
      if (i != -1) {
        break label7695;
      }
      paramaukx.a(new NoColumnError("allowMemberKick", Integer.TYPE));
      label5044:
      i = paramCursor.getColumnIndex("allowMemberAtAll");
      if (i != -1) {
        break label7710;
      }
      paramaukx.a(new NoColumnError("allowMemberAtAll", Integer.TYPE));
      label5081:
      i = paramCursor.getColumnIndex("oldTroopName");
      if (i != -1) {
        break label7725;
      }
      paramaukx.a(new NoColumnError("oldTroopName", String.class));
      label5118:
      i = paramCursor.getColumnIndex("hlGuildAppid");
      if (i != -1) {
        break label7740;
      }
      paramaukx.a(new NoColumnError("hlGuildAppid", Long.TYPE));
      label5155:
      i = paramCursor.getColumnIndex("hlGuildSubType");
      if (i != -1) {
        break label7755;
      }
      paramaukx.a(new NoColumnError("hlGuildSubType", Long.TYPE));
      label5192:
      i = paramCursor.getColumnIndex("hlGuildOrgid");
      if (i != -1) {
        break label7770;
      }
      paramaukx.a(new NoColumnError("hlGuildOrgid", Integer.TYPE));
      label5229:
      i = paramCursor.getColumnIndex("hlGuildBinary");
      if (i != -1) {
        break label7785;
      }
      paramaukx.a(new NoColumnError("hlGuildBinary", Integer.TYPE));
      label5266:
      i = paramCursor.getColumnIndex("gameSwitchStatus");
      if (i != -1) {
        break label7800;
      }
      paramaukx.a(new NoColumnError("gameSwitchStatus", Integer.TYPE));
      label5303:
      i = paramCursor.getColumnIndex("showGameSwitchStatus");
      if (i != -1) {
        break label7815;
      }
      paramaukx.a(new NoColumnError("showGameSwitchStatus", Integer.TYPE));
      label5340:
      i = paramCursor.getColumnIndex("lastShareLbsMsgUniseq");
      if (i != -1) {
        break label7830;
      }
      paramaukx.a(new NoColumnError("lastShareLbsMsgUniseq", Long.TYPE));
      label5377:
      i = paramCursor.getColumnIndex("mTroopNeedPayNumber");
      if (i != -1) {
        break label7845;
      }
      paramaukx.a(new NoColumnError("mTroopNeedPayNumber", Float.TYPE));
      label5414:
      i = paramCursor.getColumnIndex("troopCreditLevel");
      if (i != -1) {
        break label7860;
      }
      paramaukx.a(new NoColumnError("troopCreditLevel", Long.TYPE));
      label5451:
      i = paramCursor.getColumnIndex("troopCreditLevelInfo");
      if (i != -1) {
        break label7875;
      }
      paramaukx.a(new NoColumnError("troopCreditLevelInfo", Long.TYPE));
      label5488:
      i = paramCursor.getColumnIndex("dwAppPrivilegeFlag");
      if (i != -1) {
        break label7890;
      }
      paramaukx.a(new NoColumnError("dwAppPrivilegeFlag", Long.TYPE));
      label5525:
      i = paramCursor.getColumnIndex("topicId");
      if (i != -1) {
        break label7905;
      }
      paramaukx.a(new NoColumnError("topicId", String.class));
      label5562:
      i = paramCursor.getColumnIndex("associatePubAccount");
      if (i != -1) {
        break label7920;
      }
      paramaukx.a(new NoColumnError("associatePubAccount", Long.TYPE));
      label5599:
      i = paramCursor.getColumnIndex("mTroopFileVideoReqInterval");
      if (i != -1) {
        break label7935;
      }
      paramaukx.a(new NoColumnError("mTroopFileVideoReqInterval", Long.TYPE));
      label5636:
      i = paramCursor.getColumnIndex("mTroopFileVideoIsWhite");
      if (i != -1) {
        break label7950;
      }
      paramaukx.a(new NoColumnError("mTroopFileVideoIsWhite", Integer.TYPE));
      label5673:
      i = paramCursor.getColumnIndex("mTribeStatus");
      if (i != -1) {
        break label7965;
      }
      paramaukx.a(new NoColumnError("mTribeStatus", Integer.TYPE));
      label5710:
      i = paramCursor.getColumnIndex("mCanSearchByKeywords");
      if (i != -1) {
        break label7980;
      }
      paramaukx.a(new NoColumnError("mCanSearchByKeywords", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mCanSearchByTroopUin");
      if (i != -1) {
        break label8007;
      }
      paramaukx.a(new NoColumnError("mCanSearchByTroopUin", Boolean.TYPE));
      i = paramCursor.getColumnIndex("dwCmdUinJoinTime");
      if (i != -1) {
        break label8035;
      }
      paramaukx.a(new NoColumnError("dwCmdUinJoinTime", Long.TYPE));
      label5821:
      i = paramCursor.getColumnIndex("dwLastInsertBAFTipTime");
      if (i != -1) {
        break label8050;
      }
      paramaukx.a(new NoColumnError("dwLastInsertBAFTipTime", Long.TYPE));
      label5858:
      i = paramCursor.getColumnIndex("wInsertBAFTipCount");
      if (i != -1) {
        break label8065;
      }
      paramaukx.a(new NoColumnError("wInsertBAFTipCount", Integer.TYPE));
      label5895:
      i = paramCursor.getColumnIndex("wClickBAFTipCount");
      if (i != -1) {
        break label8080;
      }
      paramaukx.a(new NoColumnError("wClickBAFTipCount", Integer.TYPE));
      label5932:
      i = paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq");
      if (i != -1) {
        break label8095;
      }
      paramaukx.a(new NoColumnError("dwLastBAFTipMsgUniSeq", Long.TYPE));
      label5969:
      i = paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq2");
      if (i != -1) {
        break label8110;
      }
      paramaukx.a(new NoColumnError("dwLastBAFTipMsgUniSeq2", Long.TYPE));
      label6006:
      i = paramCursor.getColumnIndex("dailyNewMemberUins");
      if (i != -1) {
        break label8125;
      }
      paramaukx.a(new NoColumnError("dailyNewMemberUins", String.class));
      label6043:
      i = paramCursor.getColumnIndex("exitTroopReason");
      if (i != -1) {
        break label8140;
      }
      paramaukx.a(new NoColumnError("exitTroopReason", Integer.TYPE));
      label6080:
      i = paramCursor.getColumnIndex("eliminated");
      if (i != -1) {
        break label8155;
      }
      paramaukx.a(new NoColumnError("eliminated", Integer.TYPE));
      label6117:
      i = paramCursor.getColumnIndex("mIsFreezed");
      if (i != -1) {
        break label8170;
      }
      paramaukx.a(new NoColumnError("mIsFreezed", Integer.TYPE));
      label6154:
      i = paramCursor.getColumnIndex("strLastAnnouncement");
      if (i != -1) {
        break label8185;
      }
      paramaukx.a(new NoColumnError("strLastAnnouncement", String.class));
      label6191:
      i = paramCursor.getColumnIndex("nMsgLimitFreq");
      if (i != -1) {
        break label8200;
      }
      paramaukx.a(new NoColumnError("nMsgLimitFreq", Integer.TYPE));
      label6228:
      i = paramCursor.getColumnIndex("mAtOrReplyMeUins");
      if (i != -1) {
        break label8215;
      }
      paramaukx.a(new NoColumnError("mAtOrReplyMeUins", String.class));
      label6265:
      i = paramCursor.getColumnIndex("groupFlagExt4");
      if (i != -1) {
        break label8230;
      }
      paramaukx.a(new NoColumnError("groupFlagExt4", Integer.TYPE));
      label6302:
      i = paramCursor.getColumnIndex("groupFreezeReason");
      if (i != -1) {
        break label8245;
      }
      paramaukx.a(new NoColumnError("groupFreezeReason", Integer.TYPE));
      label6339:
      i = paramCursor.getColumnIndex("troopHonorGrayFlag");
      if (i != -1) {
        break label8260;
      }
      paramaukx.a(new NoColumnError("troopHonorGrayFlag", Integer.TYPE));
      label6376:
      i = paramCursor.getColumnIndex("isAllowHistoryMsgFlag");
      if (i != -1) {
        break label8275;
      }
      paramaukx.a(new NoColumnError("isAllowHistoryMsgFlag", Integer.TYPE));
      label6413:
      i = paramCursor.getColumnIndex("troopRepeatType");
      if (i != -1) {
        break label8290;
      }
      paramaukx.a(new NoColumnError("troopRepeatType", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("feeds_id");
      if (i != -1) {
        break label8305;
      }
      paramaukx.a(new NoColumnError("feeds_id", String.class));
      return paramaukm;
      paramaukm.uin = paramCursor.getString(i);
      break;
      label6504:
      paramaukm.timeSec = paramCursor.getLong(i);
      break label2334;
      label6519:
      paramaukm.troopuin = paramCursor.getString(i);
      break label2369;
      label6534:
      paramaukm.troopcode = paramCursor.getString(i);
      break label2404;
      label6549:
      paramaukm.troopowneruin = paramCursor.getString(i);
      break label2439;
      label6564:
      paramaukm.troopname = paramCursor.getString(i);
      break label2474;
      label6579:
      paramaukm.newTroopName = paramCursor.getString(i);
      break label2509;
      label6594:
      paramaukm.newTroopNameTimeStamp = paramCursor.getLong(i);
      break label2544;
      label6609:
      paramaukm.troopface = paramCursor.getShort(i);
      break label2579;
      label6624:
      paramaukm.troopmemo = paramCursor.getString(i);
      break label2614;
      label6639:
      paramaukm.fingertroopmemo = paramCursor.getString(i);
      break label2649;
      label6654:
      paramaukm.mRichFingerMemo = paramCursor.getString(i);
      break label2684;
      label6669:
      paramaukm.troopmask = paramCursor.getInt(i);
      break label2719;
      label6684:
      paramaukm.trooptype = paramCursor.getInt(i);
      break label2754;
      label6699:
      paramaukm.troopCreateTime = paramCursor.getLong(i);
      break label2789;
      label6714:
      paramaukm.dwGroupFlag = paramCursor.getLong(i);
      break label2824;
      label6729:
      paramaukm.cGroupOption = paramCursor.getShort(i);
      break label2859;
      label6744:
      paramaukm.wMemberMax = paramCursor.getInt(i);
      break label2894;
      label6759:
      paramaukm.maxAdminNum = paramCursor.getInt(i);
      break label2929;
      label6774:
      paramaukm.wSpecialClass = paramCursor.getInt(i);
      break label2964;
      label6789:
      paramaukm.cGroupLevel = paramCursor.getShort(i);
      break label2999;
      label6804:
      paramaukm.wMemberNum = paramCursor.getInt(i);
      break label3034;
      label6819:
      paramaukm.wMemberNumClient = paramCursor.getInt(i);
      break label3069;
      label6834:
      paramaukm.Administrator = paramCursor.getString(i);
      break label3104;
      label6849:
      paramaukm.dwGroupClassExt = paramCursor.getLong(i);
      break label3139;
      label6864:
      paramaukm.mGroupClassExtText = paramCursor.getString(i);
      break label3174;
      label6879:
      paramaukm.dwGroupFlagExt = paramCursor.getLong(i);
      break label3209;
      label6894:
      paramaukm.dwAuthGroupType = paramCursor.getLong(i);
      break label3244;
      label6909:
      paramaukm.troopAuthenticateInfo = paramCursor.getString(i);
      break label3279;
      label6924:
      paramaukm.dwGroupInfoSeq = paramCursor.getLong(i);
      break label3314;
      label6939:
      paramaukm.mMemberNumSeq = paramCursor.getLong(i);
      break label3349;
      label6954:
      paramaukm.mOldMemberNumSeq = paramCursor.getLong(i);
      break label3384;
      label6969:
      paramaukm.mMemberCardSeq = paramCursor.getLong(i);
      break label3419;
      label6984:
      paramaukm.mOldMemberCardSeq = paramCursor.getLong(i);
      break label3454;
      label6999:
      paramaukm.dwGroupLevelSeq = paramCursor.getLong(i);
      break label3489;
      label7014:
      paramaukm.cGroupRankSysFlag = ((byte)paramCursor.getShort(i));
      break label3524;
      label7030:
      paramaukm.cGroupRankUserFlag = ((byte)paramCursor.getShort(i));
      break label3559;
      label7046:
      paramaukm.troopLevelMap = paramCursor.getString(i);
      break label3594;
      label7061:
      paramaukm.joinTroopQuestion = paramCursor.getString(i);
      break label3629;
      label7076:
      paramaukm.joinTroopAnswer = paramCursor.getString(i);
      break label3664;
      label7091:
      paramaukm.cAlbumResult = ((byte)paramCursor.getShort(i));
      break label3699;
      label7107:
      paramaukm.dwTimeStamp = paramCursor.getLong(i);
      break label3734;
      label7122:
      paramaukm.strQZonePhotoUrls = paramCursor.getString(i);
      break label3769;
      label7137:
      paramaukm.mQZonePhotoNum = paramCursor.getInt(i);
      break label3804;
      label7152:
      paramaukm.strLocation = paramCursor.getString(i);
      break label3839;
      label7167:
      paramaukm.troopLat = paramCursor.getInt(i);
      break label3874;
      label7182:
      paramaukm.troopLon = paramCursor.getInt(i);
      break label3909;
      label7197:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.mMemberInvitingFlag = paramBoolean;
        break;
      }
      label7224:
      paramaukm.mComparePartInt = paramCursor.getInt(i);
      break label3979;
      label7239:
      paramaukm.mCompareSpell = paramCursor.getString(i);
      break label4014;
      label7254:
      paramaukm.mSomeMemberUins = paramCursor.getString(i);
      break label4049;
      label7269:
      paramaukm.mHeaderUinsOld = paramCursor.getString(i);
      break label4084;
      label7284:
      paramaukm.mHeaderUinsNew = paramCursor.getString(i);
      break label4119;
      label7299:
      paramaukm.mTags = paramCursor.getString(i);
      break label4156;
      label7314:
      paramaukm.mTroopAvatarId = paramCursor.getInt(i);
      break label4193;
      label7329:
      paramaukm.mTroopPicListJson = paramCursor.getString(i);
      break label4230;
      label7344:
      paramaukm.nTroopGrade = paramCursor.getInt(i);
      break label4267;
      label7359:
      paramaukm.isShowInNearbyTroops = paramCursor.getInt(i);
      break label4304;
      label7374:
      paramaukm.dwGagTimeStamp = paramCursor.getLong(i);
      break label4341;
      label7389:
      paramaukm.dwGagTimeStamp_me = paramCursor.getLong(i);
      break label4378;
      label7404:
      paramaukm.dwCmdUinUinFlag = paramCursor.getLong(i);
      break label4415;
      label7419:
      paramaukm.dwAdditionalFlag = paramCursor.getLong(i);
      break label4452;
      label7434:
      paramaukm.troopTypeExt = paramCursor.getInt(i);
      break label4489;
      label7449:
      paramaukm.ownerNameShow = paramCursor.getString(i);
      break label4526;
      label7464:
      paramaukm.adminNameShow = paramCursor.getString(i);
      break label4563;
      label7479:
      paramaukm.dwOfficeMode = paramCursor.getLong(i);
      break label4600;
      label7494:
      paramaukm.dwGroupFlagExt3 = paramCursor.getLong(i);
      break label4637;
      label7509:
      paramaukm.cmdUinFlagEx2 = paramCursor.getLong(i);
      break label4674;
      label7524:
      paramaukm.udwCmdUinRingtoneID = paramCursor.getLong(i);
      break label4711;
      label7539:
      paramaukm.memberListToShow = paramCursor.getString(i);
      break label4748;
      label7554:
      paramaukm.troopPrivilegeFlag = paramCursor.getLong(i);
      break label4785;
      label7569:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isNewTroop = paramBoolean;
        break;
      }
      label7596:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.hasSetNewTroopHead = paramBoolean;
        break;
      }
      label7623:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.hasSetNewTroopName = paramBoolean;
        break;
      }
      label7650:
      paramaukm.maxInviteMemNum = paramCursor.getInt(i);
      break label4933;
      label7665:
      paramaukm.lastMsgTime = paramCursor.getLong(i);
      break label4970;
      label7680:
      paramaukm.allowMemberModifTroopName = paramCursor.getInt(i);
      break label5007;
      label7695:
      paramaukm.allowMemberKick = paramCursor.getInt(i);
      break label5044;
      label7710:
      paramaukm.allowMemberAtAll = paramCursor.getInt(i);
      break label5081;
      label7725:
      paramaukm.oldTroopName = paramCursor.getString(i);
      break label5118;
      label7740:
      paramaukm.hlGuildAppid = paramCursor.getLong(i);
      break label5155;
      label7755:
      paramaukm.hlGuildSubType = paramCursor.getLong(i);
      break label5192;
      label7770:
      paramaukm.hlGuildOrgid = paramCursor.getInt(i);
      break label5229;
      label7785:
      paramaukm.hlGuildBinary = paramCursor.getInt(i);
      break label5266;
      label7800:
      paramaukm.gameSwitchStatus = paramCursor.getInt(i);
      break label5303;
      label7815:
      paramaukm.showGameSwitchStatus = paramCursor.getInt(i);
      break label5340;
      label7830:
      paramaukm.lastShareLbsMsgUniseq = paramCursor.getLong(i);
      break label5377;
      label7845:
      paramaukm.mTroopNeedPayNumber = paramCursor.getFloat(i);
      break label5414;
      label7860:
      paramaukm.troopCreditLevel = paramCursor.getLong(i);
      break label5451;
      label7875:
      paramaukm.troopCreditLevelInfo = paramCursor.getLong(i);
      break label5488;
      label7890:
      paramaukm.dwAppPrivilegeFlag = paramCursor.getLong(i);
      break label5525;
      label7905:
      paramaukm.topicId = paramCursor.getString(i);
      break label5562;
      label7920:
      paramaukm.associatePubAccount = paramCursor.getLong(i);
      break label5599;
      label7935:
      paramaukm.mTroopFileVideoReqInterval = paramCursor.getLong(i);
      break label5636;
      label7950:
      paramaukm.mTroopFileVideoIsWhite = paramCursor.getInt(i);
      break label5673;
      label7965:
      paramaukm.mTribeStatus = paramCursor.getInt(i);
      break label5710;
      label7980:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.mCanSearchByKeywords = paramBoolean;
        break;
      }
      label8007:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramaukm.mCanSearchByTroopUin = paramBoolean;
        break;
      }
      label8035:
      paramaukm.dwCmdUinJoinTime = paramCursor.getLong(i);
      break label5821;
      label8050:
      paramaukm.dwLastInsertBAFTipTime = paramCursor.getLong(i);
      break label5858;
      label8065:
      paramaukm.wInsertBAFTipCount = paramCursor.getInt(i);
      break label5895;
      label8080:
      paramaukm.wClickBAFTipCount = paramCursor.getInt(i);
      break label5932;
      label8095:
      paramaukm.dwLastBAFTipMsgUniSeq = paramCursor.getLong(i);
      break label5969;
      label8110:
      paramaukm.dwLastBAFTipMsgUniSeq2 = paramCursor.getLong(i);
      break label6006;
      label8125:
      paramaukm.dailyNewMemberUins = paramCursor.getString(i);
      break label6043;
      label8140:
      paramaukm.exitTroopReason = paramCursor.getInt(i);
      break label6080;
      label8155:
      paramaukm.eliminated = paramCursor.getInt(i);
      break label6117;
      label8170:
      paramaukm.mIsFreezed = paramCursor.getInt(i);
      break label6154;
      label8185:
      paramaukm.strLastAnnouncement = paramCursor.getString(i);
      break label6191;
      label8200:
      paramaukm.nMsgLimitFreq = paramCursor.getInt(i);
      break label6228;
      label8215:
      paramaukm.mAtOrReplyMeUins = paramCursor.getString(i);
      break label6265;
      label8230:
      paramaukm.groupFlagExt4 = paramCursor.getInt(i);
      break label6302;
      label8245:
      paramaukm.groupFreezeReason = paramCursor.getInt(i);
      break label6339;
      label8260:
      paramaukm.troopHonorGrayFlag = paramCursor.getInt(i);
      break label6376;
      label8275:
      paramaukm.isAllowHistoryMsgFlag = paramCursor.getInt(i);
      break label6413;
      label8290:
      paramaukm.troopRepeatType = paramCursor.getInt(i);
    }
    label8305:
    paramaukm.feeds_id = paramCursor.getString(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,timeSec INTEGER ,troopuin TEXT UNIQUE ,troopcode TEXT ,troopowneruin TEXT ,troopname TEXT ,newTroopName TEXT ,newTroopNameTimeStamp INTEGER ,troopface INTEGER ,troopmemo TEXT ,fingertroopmemo TEXT ,mRichFingerMemo TEXT ,troopmask INTEGER ,trooptype INTEGER ,troopCreateTime INTEGER ,dwGroupFlag INTEGER ,cGroupOption INTEGER ,wMemberMax INTEGER ,maxAdminNum INTEGER ,wSpecialClass INTEGER ,cGroupLevel INTEGER ,wMemberNum INTEGER ,wMemberNumClient INTEGER ,Administrator TEXT ,dwGroupClassExt INTEGER ,mGroupClassExtText TEXT ,dwGroupFlagExt INTEGER ,dwAuthGroupType INTEGER ,troopAuthenticateInfo TEXT ,dwGroupInfoSeq INTEGER ,mMemberNumSeq INTEGER ,mOldMemberNumSeq INTEGER ,mMemberCardSeq INTEGER ,mOldMemberCardSeq INTEGER ,dwGroupLevelSeq INTEGER ,cGroupRankSysFlag INTEGER ,cGroupRankUserFlag INTEGER ,troopLevelMap TEXT ,joinTroopQuestion TEXT ,joinTroopAnswer TEXT ,cAlbumResult INTEGER ,dwTimeStamp INTEGER ,strQZonePhotoUrls TEXT ,mQZonePhotoNum INTEGER ,strLocation TEXT ,troopLat INTEGER ,troopLon INTEGER ,mMemberInvitingFlag INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,mSomeMemberUins TEXT ,mHeaderUinsOld TEXT ,mHeaderUinsNew TEXT ,mTags TEXT ,mTroopAvatarId INTEGER ,mTroopPicListJson TEXT ,nTroopGrade INTEGER ,isShowInNearbyTroops INTEGER ,dwGagTimeStamp INTEGER ,dwGagTimeStamp_me INTEGER ,dwCmdUinUinFlag INTEGER ,dwAdditionalFlag INTEGER ,troopTypeExt INTEGER ,ownerNameShow TEXT ,adminNameShow TEXT ,dwOfficeMode INTEGER ,dwGroupFlagExt3 INTEGER ,cmdUinFlagEx2 INTEGER ,udwCmdUinRingtoneID INTEGER ,memberListToShow TEXT ,troopPrivilegeFlag INTEGER ,isNewTroop INTEGER ,hasSetNewTroopHead INTEGER ,hasSetNewTroopName INTEGER ,maxInviteMemNum INTEGER ,lastMsgTime INTEGER ,allowMemberModifTroopName INTEGER ,allowMemberKick INTEGER ,allowMemberAtAll INTEGER ,oldTroopName TEXT ,hlGuildAppid INTEGER ,hlGuildSubType INTEGER ,hlGuildOrgid INTEGER ,hlGuildBinary INTEGER ,gameSwitchStatus INTEGER ,showGameSwitchStatus INTEGER ,lastShareLbsMsgUniseq INTEGER ,mTroopNeedPayNumber REAL ,troopCreditLevel INTEGER ,troopCreditLevelInfo INTEGER ,dwAppPrivilegeFlag INTEGER ,topicId TEXT ,associatePubAccount INTEGER ,mTroopFileVideoReqInterval INTEGER ,mTroopFileVideoIsWhite INTEGER ,mTribeStatus INTEGER ,mCanSearchByKeywords INTEGER ,mCanSearchByTroopUin INTEGER ,dwCmdUinJoinTime INTEGER ,dwLastInsertBAFTipTime INTEGER ,wInsertBAFTipCount INTEGER ,wClickBAFTipCount INTEGER ,dwLastBAFTipMsgUniSeq INTEGER ,dwLastBAFTipMsgUniSeq2 INTEGER ,dailyNewMemberUins TEXT ,exitTroopReason INTEGER ,eliminated INTEGER ,mIsFreezed INTEGER ,strLastAnnouncement TEXT ,nMsgLimitFreq INTEGER ,mAtOrReplyMeUins TEXT ,groupFlagExt4 INTEGER ,groupFreezeReason INTEGER ,troopHonorGrayFlag INTEGER ,isAllowHistoryMsgFlag INTEGER ,troopRepeatType INTEGER ,feeds_id TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (TroopInfo)paramaukm;
    paramContentValues.put("uin", paramaukm.uin);
    paramContentValues.put("timeSec", Long.valueOf(paramaukm.timeSec));
    paramContentValues.put("troopuin", paramaukm.troopuin);
    paramContentValues.put("troopcode", paramaukm.troopcode);
    paramContentValues.put("troopowneruin", paramaukm.troopowneruin);
    paramContentValues.put("troopname", paramaukm.troopname);
    paramContentValues.put("newTroopName", paramaukm.newTroopName);
    paramContentValues.put("newTroopNameTimeStamp", Long.valueOf(paramaukm.newTroopNameTimeStamp));
    paramContentValues.put("troopface", Short.valueOf(paramaukm.troopface));
    paramContentValues.put("troopmemo", paramaukm.troopmemo);
    paramContentValues.put("fingertroopmemo", paramaukm.fingertroopmemo);
    paramContentValues.put("mRichFingerMemo", paramaukm.mRichFingerMemo);
    paramContentValues.put("troopmask", Integer.valueOf(paramaukm.troopmask));
    paramContentValues.put("trooptype", Integer.valueOf(paramaukm.trooptype));
    paramContentValues.put("troopCreateTime", Long.valueOf(paramaukm.troopCreateTime));
    paramContentValues.put("dwGroupFlag", Long.valueOf(paramaukm.dwGroupFlag));
    paramContentValues.put("cGroupOption", Short.valueOf(paramaukm.cGroupOption));
    paramContentValues.put("wMemberMax", Integer.valueOf(paramaukm.wMemberMax));
    paramContentValues.put("maxAdminNum", Integer.valueOf(paramaukm.maxAdminNum));
    paramContentValues.put("wSpecialClass", Integer.valueOf(paramaukm.wSpecialClass));
    paramContentValues.put("cGroupLevel", Short.valueOf(paramaukm.cGroupLevel));
    paramContentValues.put("wMemberNum", Integer.valueOf(paramaukm.wMemberNum));
    paramContentValues.put("wMemberNumClient", Integer.valueOf(paramaukm.wMemberNumClient));
    paramContentValues.put("Administrator", paramaukm.Administrator);
    paramContentValues.put("dwGroupClassExt", Long.valueOf(paramaukm.dwGroupClassExt));
    paramContentValues.put("mGroupClassExtText", paramaukm.mGroupClassExtText);
    paramContentValues.put("dwGroupFlagExt", Long.valueOf(paramaukm.dwGroupFlagExt));
    paramContentValues.put("dwAuthGroupType", Long.valueOf(paramaukm.dwAuthGroupType));
    paramContentValues.put("troopAuthenticateInfo", paramaukm.troopAuthenticateInfo);
    paramContentValues.put("dwGroupInfoSeq", Long.valueOf(paramaukm.dwGroupInfoSeq));
    paramContentValues.put("mMemberNumSeq", Long.valueOf(paramaukm.mMemberNumSeq));
    paramContentValues.put("mOldMemberNumSeq", Long.valueOf(paramaukm.mOldMemberNumSeq));
    paramContentValues.put("mMemberCardSeq", Long.valueOf(paramaukm.mMemberCardSeq));
    paramContentValues.put("mOldMemberCardSeq", Long.valueOf(paramaukm.mOldMemberCardSeq));
    paramContentValues.put("dwGroupLevelSeq", Long.valueOf(paramaukm.dwGroupLevelSeq));
    paramContentValues.put("cGroupRankSysFlag", Byte.valueOf(paramaukm.cGroupRankSysFlag));
    paramContentValues.put("cGroupRankUserFlag", Byte.valueOf(paramaukm.cGroupRankUserFlag));
    paramContentValues.put("troopLevelMap", paramaukm.troopLevelMap);
    paramContentValues.put("joinTroopQuestion", paramaukm.joinTroopQuestion);
    paramContentValues.put("joinTroopAnswer", paramaukm.joinTroopAnswer);
    paramContentValues.put("cAlbumResult", Byte.valueOf(paramaukm.cAlbumResult));
    paramContentValues.put("dwTimeStamp", Long.valueOf(paramaukm.dwTimeStamp));
    paramContentValues.put("strQZonePhotoUrls", paramaukm.strQZonePhotoUrls);
    paramContentValues.put("mQZonePhotoNum", Integer.valueOf(paramaukm.mQZonePhotoNum));
    paramContentValues.put("strLocation", paramaukm.strLocation);
    paramContentValues.put("troopLat", Integer.valueOf(paramaukm.troopLat));
    paramContentValues.put("troopLon", Integer.valueOf(paramaukm.troopLon));
    paramContentValues.put("mMemberInvitingFlag", Boolean.valueOf(paramaukm.mMemberInvitingFlag));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramaukm.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramaukm.mCompareSpell);
    paramContentValues.put("mSomeMemberUins", paramaukm.mSomeMemberUins);
    paramContentValues.put("mHeaderUinsOld", paramaukm.mHeaderUinsOld);
    paramContentValues.put("mHeaderUinsNew", paramaukm.mHeaderUinsNew);
    paramContentValues.put("mTags", paramaukm.mTags);
    paramContentValues.put("mTroopAvatarId", Integer.valueOf(paramaukm.mTroopAvatarId));
    paramContentValues.put("mTroopPicListJson", paramaukm.mTroopPicListJson);
    paramContentValues.put("nTroopGrade", Integer.valueOf(paramaukm.nTroopGrade));
    paramContentValues.put("isShowInNearbyTroops", Integer.valueOf(paramaukm.isShowInNearbyTroops));
    paramContentValues.put("dwGagTimeStamp", Long.valueOf(paramaukm.dwGagTimeStamp));
    paramContentValues.put("dwGagTimeStamp_me", Long.valueOf(paramaukm.dwGagTimeStamp_me));
    paramContentValues.put("dwCmdUinUinFlag", Long.valueOf(paramaukm.dwCmdUinUinFlag));
    paramContentValues.put("dwAdditionalFlag", Long.valueOf(paramaukm.dwAdditionalFlag));
    paramContentValues.put("troopTypeExt", Integer.valueOf(paramaukm.troopTypeExt));
    paramContentValues.put("ownerNameShow", paramaukm.ownerNameShow);
    paramContentValues.put("adminNameShow", paramaukm.adminNameShow);
    paramContentValues.put("dwOfficeMode", Long.valueOf(paramaukm.dwOfficeMode));
    paramContentValues.put("dwGroupFlagExt3", Long.valueOf(paramaukm.dwGroupFlagExt3));
    paramContentValues.put("cmdUinFlagEx2", Long.valueOf(paramaukm.cmdUinFlagEx2));
    paramContentValues.put("udwCmdUinRingtoneID", Long.valueOf(paramaukm.udwCmdUinRingtoneID));
    paramContentValues.put("memberListToShow", paramaukm.memberListToShow);
    paramContentValues.put("troopPrivilegeFlag", Long.valueOf(paramaukm.troopPrivilegeFlag));
    paramContentValues.put("isNewTroop", Boolean.valueOf(paramaukm.isNewTroop));
    paramContentValues.put("hasSetNewTroopHead", Boolean.valueOf(paramaukm.hasSetNewTroopHead));
    paramContentValues.put("hasSetNewTroopName", Boolean.valueOf(paramaukm.hasSetNewTroopName));
    paramContentValues.put("maxInviteMemNum", Integer.valueOf(paramaukm.maxInviteMemNum));
    paramContentValues.put("lastMsgTime", Long.valueOf(paramaukm.lastMsgTime));
    paramContentValues.put("allowMemberModifTroopName", Integer.valueOf(paramaukm.allowMemberModifTroopName));
    paramContentValues.put("allowMemberKick", Integer.valueOf(paramaukm.allowMemberKick));
    paramContentValues.put("allowMemberAtAll", Integer.valueOf(paramaukm.allowMemberAtAll));
    paramContentValues.put("oldTroopName", paramaukm.oldTroopName);
    paramContentValues.put("hlGuildAppid", Long.valueOf(paramaukm.hlGuildAppid));
    paramContentValues.put("hlGuildSubType", Long.valueOf(paramaukm.hlGuildSubType));
    paramContentValues.put("hlGuildOrgid", Integer.valueOf(paramaukm.hlGuildOrgid));
    paramContentValues.put("hlGuildBinary", Integer.valueOf(paramaukm.hlGuildBinary));
    paramContentValues.put("gameSwitchStatus", Integer.valueOf(paramaukm.gameSwitchStatus));
    paramContentValues.put("showGameSwitchStatus", Integer.valueOf(paramaukm.showGameSwitchStatus));
    paramContentValues.put("lastShareLbsMsgUniseq", Long.valueOf(paramaukm.lastShareLbsMsgUniseq));
    paramContentValues.put("mTroopNeedPayNumber", Float.valueOf(paramaukm.mTroopNeedPayNumber));
    paramContentValues.put("troopCreditLevel", Long.valueOf(paramaukm.troopCreditLevel));
    paramContentValues.put("troopCreditLevelInfo", Long.valueOf(paramaukm.troopCreditLevelInfo));
    paramContentValues.put("dwAppPrivilegeFlag", Long.valueOf(paramaukm.dwAppPrivilegeFlag));
    paramContentValues.put("topicId", paramaukm.topicId);
    paramContentValues.put("associatePubAccount", Long.valueOf(paramaukm.associatePubAccount));
    paramContentValues.put("mTroopFileVideoReqInterval", Long.valueOf(paramaukm.mTroopFileVideoReqInterval));
    paramContentValues.put("mTroopFileVideoIsWhite", Integer.valueOf(paramaukm.mTroopFileVideoIsWhite));
    paramContentValues.put("mTribeStatus", Integer.valueOf(paramaukm.mTribeStatus));
    paramContentValues.put("mCanSearchByKeywords", Boolean.valueOf(paramaukm.mCanSearchByKeywords));
    paramContentValues.put("mCanSearchByTroopUin", Boolean.valueOf(paramaukm.mCanSearchByTroopUin));
    paramContentValues.put("dwCmdUinJoinTime", Long.valueOf(paramaukm.dwCmdUinJoinTime));
    paramContentValues.put("dwLastInsertBAFTipTime", Long.valueOf(paramaukm.dwLastInsertBAFTipTime));
    paramContentValues.put("wInsertBAFTipCount", Integer.valueOf(paramaukm.wInsertBAFTipCount));
    paramContentValues.put("wClickBAFTipCount", Integer.valueOf(paramaukm.wClickBAFTipCount));
    paramContentValues.put("dwLastBAFTipMsgUniSeq", Long.valueOf(paramaukm.dwLastBAFTipMsgUniSeq));
    paramContentValues.put("dwLastBAFTipMsgUniSeq2", Long.valueOf(paramaukm.dwLastBAFTipMsgUniSeq2));
    paramContentValues.put("dailyNewMemberUins", paramaukm.dailyNewMemberUins);
    paramContentValues.put("exitTroopReason", Integer.valueOf(paramaukm.exitTroopReason));
    paramContentValues.put("eliminated", Integer.valueOf(paramaukm.eliminated));
    paramContentValues.put("mIsFreezed", Integer.valueOf(paramaukm.mIsFreezed));
    paramContentValues.put("strLastAnnouncement", paramaukm.strLastAnnouncement);
    paramContentValues.put("nMsgLimitFreq", Integer.valueOf(paramaukm.nMsgLimitFreq));
    paramContentValues.put("mAtOrReplyMeUins", paramaukm.mAtOrReplyMeUins);
    paramContentValues.put("groupFlagExt4", Integer.valueOf(paramaukm.groupFlagExt4));
    paramContentValues.put("groupFreezeReason", Integer.valueOf(paramaukm.groupFreezeReason));
    paramContentValues.put("troopHonorGrayFlag", Integer.valueOf(paramaukm.troopHonorGrayFlag));
    paramContentValues.put("isAllowHistoryMsgFlag", Integer.valueOf(paramaukm.isAllowHistoryMsgFlag));
    paramContentValues.put("troopRepeatType", Integer.valueOf(paramaukm.troopRepeatType));
    paramContentValues.put("feeds_id", paramaukm.feeds_id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulq
 * JD-Core Version:    0.7.0.1
 */