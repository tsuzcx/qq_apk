import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atns
  extends atna
{
  public atns()
  {
    this.a = 115;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramatmo = (TroopInfo)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramatmo.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
      paramatmo.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
      paramatmo.troopcode = paramCursor.getString(paramCursor.getColumnIndex("troopcode"));
      paramatmo.troopowneruin = paramCursor.getString(paramCursor.getColumnIndex("troopowneruin"));
      paramatmo.troopname = paramCursor.getString(paramCursor.getColumnIndex("troopname"));
      paramatmo.newTroopName = paramCursor.getString(paramCursor.getColumnIndex("newTroopName"));
      paramatmo.newTroopNameTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("newTroopNameTimeStamp"));
      paramatmo.troopface = paramCursor.getShort(paramCursor.getColumnIndex("troopface"));
      paramatmo.troopmemo = paramCursor.getString(paramCursor.getColumnIndex("troopmemo"));
      paramatmo.fingertroopmemo = paramCursor.getString(paramCursor.getColumnIndex("fingertroopmemo"));
      paramatmo.mRichFingerMemo = paramCursor.getString(paramCursor.getColumnIndex("mRichFingerMemo"));
      paramatmo.troopmask = paramCursor.getInt(paramCursor.getColumnIndex("troopmask"));
      paramatmo.trooptype = paramCursor.getInt(paramCursor.getColumnIndex("trooptype"));
      paramatmo.troopCreateTime = paramCursor.getLong(paramCursor.getColumnIndex("troopCreateTime"));
      paramatmo.dwGroupFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlag"));
      paramatmo.cGroupOption = paramCursor.getShort(paramCursor.getColumnIndex("cGroupOption"));
      paramatmo.wMemberMax = paramCursor.getInt(paramCursor.getColumnIndex("wMemberMax"));
      paramatmo.maxAdminNum = paramCursor.getInt(paramCursor.getColumnIndex("maxAdminNum"));
      paramatmo.wSpecialClass = paramCursor.getInt(paramCursor.getColumnIndex("wSpecialClass"));
      paramatmo.cGroupLevel = paramCursor.getShort(paramCursor.getColumnIndex("cGroupLevel"));
      paramatmo.wMemberNum = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNum"));
      paramatmo.wMemberNumClient = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNumClient"));
      paramatmo.Administrator = paramCursor.getString(paramCursor.getColumnIndex("Administrator"));
      paramatmo.dwGroupClassExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupClassExt"));
      paramatmo.mGroupClassExtText = paramCursor.getString(paramCursor.getColumnIndex("mGroupClassExtText"));
      paramatmo.dwGroupFlagExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt"));
      paramatmo.dwAuthGroupType = paramCursor.getLong(paramCursor.getColumnIndex("dwAuthGroupType"));
      paramatmo.troopAuthenticateInfo = paramCursor.getString(paramCursor.getColumnIndex("troopAuthenticateInfo"));
      paramatmo.dwGroupInfoSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupInfoSeq"));
      paramatmo.mMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberNumSeq"));
      paramatmo.mOldMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberNumSeq"));
      paramatmo.mMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberCardSeq"));
      paramatmo.mOldMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberCardSeq"));
      paramatmo.dwGroupLevelSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupLevelSeq"));
      paramatmo.cGroupRankSysFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankSysFlag")));
      paramatmo.cGroupRankUserFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankUserFlag")));
      paramatmo.troopLevelMap = paramCursor.getString(paramCursor.getColumnIndex("troopLevelMap"));
      paramatmo.joinTroopQuestion = paramCursor.getString(paramCursor.getColumnIndex("joinTroopQuestion"));
      paramatmo.joinTroopAnswer = paramCursor.getString(paramCursor.getColumnIndex("joinTroopAnswer"));
      paramatmo.cAlbumResult = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cAlbumResult")));
      paramatmo.dwTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwTimeStamp"));
      paramatmo.strQZonePhotoUrls = paramCursor.getString(paramCursor.getColumnIndex("strQZonePhotoUrls"));
      paramatmo.mQZonePhotoNum = paramCursor.getInt(paramCursor.getColumnIndex("mQZonePhotoNum"));
      paramatmo.strLocation = paramCursor.getString(paramCursor.getColumnIndex("strLocation"));
      paramatmo.troopLat = paramCursor.getInt(paramCursor.getColumnIndex("troopLat"));
      paramatmo.troopLon = paramCursor.getInt(paramCursor.getColumnIndex("troopLon"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("mMemberInvitingFlag")))
      {
        paramBoolean = true;
        paramatmo.mMemberInvitingFlag = paramBoolean;
        paramatmo.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramatmo.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramatmo.mSomeMemberUins = paramCursor.getString(paramCursor.getColumnIndex("mSomeMemberUins"));
        paramatmo.mHeaderUinsOld = paramCursor.getString(paramCursor.getColumnIndex("mHeaderUinsOld"));
        paramatmo.mHeaderUinsNew = paramCursor.getString(paramCursor.getColumnIndex("mHeaderUinsNew"));
        paramatmo.mTags = paramCursor.getString(paramCursor.getColumnIndex("mTags"));
        paramatmo.mTroopAvatarId = paramCursor.getInt(paramCursor.getColumnIndex("mTroopAvatarId"));
        paramatmo.mTroopPicListJson = paramCursor.getString(paramCursor.getColumnIndex("mTroopPicListJson"));
        paramatmo.nTroopGrade = paramCursor.getInt(paramCursor.getColumnIndex("nTroopGrade"));
        paramatmo.isShowInNearbyTroops = paramCursor.getInt(paramCursor.getColumnIndex("isShowInNearbyTroops"));
        paramatmo.dwGagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp"));
        paramatmo.dwGagTimeStamp_me = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp_me"));
        paramatmo.dwCmdUinUinFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwCmdUinUinFlag"));
        paramatmo.dwAdditionalFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAdditionalFlag"));
        paramatmo.troopTypeExt = paramCursor.getInt(paramCursor.getColumnIndex("troopTypeExt"));
        paramatmo.ownerNameShow = paramCursor.getString(paramCursor.getColumnIndex("ownerNameShow"));
        paramatmo.adminNameShow = paramCursor.getString(paramCursor.getColumnIndex("adminNameShow"));
        paramatmo.dwOfficeMode = paramCursor.getLong(paramCursor.getColumnIndex("dwOfficeMode"));
        paramatmo.dwGroupFlagExt3 = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt3"));
        paramatmo.cmdUinFlagEx2 = paramCursor.getLong(paramCursor.getColumnIndex("cmdUinFlagEx2"));
        paramatmo.udwCmdUinRingtoneID = paramCursor.getLong(paramCursor.getColumnIndex("udwCmdUinRingtoneID"));
        paramatmo.memberListToShow = paramCursor.getString(paramCursor.getColumnIndex("memberListToShow"));
        paramatmo.troopPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("troopPrivilegeFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isNewTroop"))) {
          break label2201;
        }
        paramBoolean = true;
        label1343:
        paramatmo.isNewTroop = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSetNewTroopHead"))) {
          break label2206;
        }
        paramBoolean = true;
        label1369:
        paramatmo.hasSetNewTroopHead = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSetNewTroopName"))) {
          break label2211;
        }
        paramBoolean = true;
        label1395:
        paramatmo.hasSetNewTroopName = paramBoolean;
        paramatmo.maxInviteMemNum = paramCursor.getInt(paramCursor.getColumnIndex("maxInviteMemNum"));
        paramatmo.lastMsgTime = paramCursor.getLong(paramCursor.getColumnIndex("lastMsgTime"));
        paramatmo.allowMemberModifTroopName = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberModifTroopName"));
        paramatmo.allowMemberKick = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberKick"));
        paramatmo.allowMemberAtAll = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberAtAll"));
        paramatmo.oldTroopName = paramCursor.getString(paramCursor.getColumnIndex("oldTroopName"));
        paramatmo.hlGuildAppid = paramCursor.getLong(paramCursor.getColumnIndex("hlGuildAppid"));
        paramatmo.hlGuildSubType = paramCursor.getLong(paramCursor.getColumnIndex("hlGuildSubType"));
        paramatmo.hlGuildOrgid = paramCursor.getInt(paramCursor.getColumnIndex("hlGuildOrgid"));
        paramatmo.hlGuildBinary = paramCursor.getInt(paramCursor.getColumnIndex("hlGuildBinary"));
        paramatmo.gameSwitchStatus = paramCursor.getInt(paramCursor.getColumnIndex("gameSwitchStatus"));
        paramatmo.showGameSwitchStatus = paramCursor.getInt(paramCursor.getColumnIndex("showGameSwitchStatus"));
        paramatmo.lastShareLbsMsgUniseq = paramCursor.getLong(paramCursor.getColumnIndex("lastShareLbsMsgUniseq"));
        paramatmo.mTroopNeedPayNumber = paramCursor.getFloat(paramCursor.getColumnIndex("mTroopNeedPayNumber"));
        paramatmo.troopCreditLevel = paramCursor.getLong(paramCursor.getColumnIndex("troopCreditLevel"));
        paramatmo.troopCreditLevelInfo = paramCursor.getLong(paramCursor.getColumnIndex("troopCreditLevelInfo"));
        paramatmo.dwAppPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAppPrivilegeFlag"));
        paramatmo.topicId = paramCursor.getString(paramCursor.getColumnIndex("topicId"));
        paramatmo.associatePubAccount = paramCursor.getLong(paramCursor.getColumnIndex("associatePubAccount"));
        paramatmo.mTroopFileVideoReqInterval = paramCursor.getLong(paramCursor.getColumnIndex("mTroopFileVideoReqInterval"));
        paramatmo.mTroopFileVideoIsWhite = paramCursor.getInt(paramCursor.getColumnIndex("mTroopFileVideoIsWhite"));
        paramatmo.mTribeStatus = paramCursor.getInt(paramCursor.getColumnIndex("mTribeStatus"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mCanSearchByKeywords"))) {
          break label2216;
        }
        paramBoolean = true;
        label1839:
        paramatmo.mCanSearchByKeywords = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mCanSearchByTroopUin"))) {
          break label2221;
        }
      }
      label2201:
      label2206:
      label2211:
      label2216:
      label2221:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramatmo.mCanSearchByTroopUin = paramBoolean;
        paramatmo.dwCmdUinJoinTime = paramCursor.getLong(paramCursor.getColumnIndex("dwCmdUinJoinTime"));
        paramatmo.dwLastInsertBAFTipTime = paramCursor.getLong(paramCursor.getColumnIndex("dwLastInsertBAFTipTime"));
        paramatmo.wInsertBAFTipCount = paramCursor.getInt(paramCursor.getColumnIndex("wInsertBAFTipCount"));
        paramatmo.wClickBAFTipCount = paramCursor.getInt(paramCursor.getColumnIndex("wClickBAFTipCount"));
        paramatmo.dwLastBAFTipMsgUniSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq"));
        paramatmo.dwLastBAFTipMsgUniSeq2 = paramCursor.getLong(paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq2"));
        paramatmo.dailyNewMemberUins = paramCursor.getString(paramCursor.getColumnIndex("dailyNewMemberUins"));
        paramatmo.exitTroopReason = paramCursor.getInt(paramCursor.getColumnIndex("exitTroopReason"));
        paramatmo.eliminated = paramCursor.getInt(paramCursor.getColumnIndex("eliminated"));
        paramatmo.mIsFreezed = paramCursor.getInt(paramCursor.getColumnIndex("mIsFreezed"));
        paramatmo.strLastAnnouncement = paramCursor.getString(paramCursor.getColumnIndex("strLastAnnouncement"));
        paramatmo.nMsgLimitFreq = paramCursor.getInt(paramCursor.getColumnIndex("nMsgLimitFreq"));
        paramatmo.mAtOrReplyMeUins = paramCursor.getString(paramCursor.getColumnIndex("mAtOrReplyMeUins"));
        paramatmo.groupFlagExt4 = paramCursor.getInt(paramCursor.getColumnIndex("groupFlagExt4"));
        paramatmo.groupFreezeReason = paramCursor.getInt(paramCursor.getColumnIndex("groupFreezeReason"));
        paramatmo.troopHonorGrayFlag = paramCursor.getInt(paramCursor.getColumnIndex("troopHonorGrayFlag"));
        paramatmo.isAllowHistoryMsgFlag = paramCursor.getInt(paramCursor.getColumnIndex("isAllowHistoryMsgFlag"));
        return paramatmo;
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
      paramatmz.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("timeSec");
      if (i != -1) {
        break label6392;
      }
      paramatmz.a(new NoColumnError("timeSec", Long.TYPE));
      label2296:
      i = paramCursor.getColumnIndex("troopuin");
      if (i != -1) {
        break label6407;
      }
      paramatmz.a(new NoColumnError("troopuin", String.class));
      label2331:
      i = paramCursor.getColumnIndex("troopcode");
      if (i != -1) {
        break label6422;
      }
      paramatmz.a(new NoColumnError("troopcode", String.class));
      label2366:
      i = paramCursor.getColumnIndex("troopowneruin");
      if (i != -1) {
        break label6437;
      }
      paramatmz.a(new NoColumnError("troopowneruin", String.class));
      label2401:
      i = paramCursor.getColumnIndex("troopname");
      if (i != -1) {
        break label6452;
      }
      paramatmz.a(new NoColumnError("troopname", String.class));
      label2436:
      i = paramCursor.getColumnIndex("newTroopName");
      if (i != -1) {
        break label6467;
      }
      paramatmz.a(new NoColumnError("newTroopName", String.class));
      label2471:
      i = paramCursor.getColumnIndex("newTroopNameTimeStamp");
      if (i != -1) {
        break label6482;
      }
      paramatmz.a(new NoColumnError("newTroopNameTimeStamp", Long.TYPE));
      label2506:
      i = paramCursor.getColumnIndex("troopface");
      if (i != -1) {
        break label6497;
      }
      paramatmz.a(new NoColumnError("troopface", Short.TYPE));
      label2541:
      i = paramCursor.getColumnIndex("troopmemo");
      if (i != -1) {
        break label6512;
      }
      paramatmz.a(new NoColumnError("troopmemo", String.class));
      label2576:
      i = paramCursor.getColumnIndex("fingertroopmemo");
      if (i != -1) {
        break label6527;
      }
      paramatmz.a(new NoColumnError("fingertroopmemo", String.class));
      label2611:
      i = paramCursor.getColumnIndex("mRichFingerMemo");
      if (i != -1) {
        break label6542;
      }
      paramatmz.a(new NoColumnError("mRichFingerMemo", String.class));
      label2646:
      i = paramCursor.getColumnIndex("troopmask");
      if (i != -1) {
        break label6557;
      }
      paramatmz.a(new NoColumnError("troopmask", Integer.TYPE));
      label2681:
      i = paramCursor.getColumnIndex("trooptype");
      if (i != -1) {
        break label6572;
      }
      paramatmz.a(new NoColumnError("trooptype", Integer.TYPE));
      label2716:
      i = paramCursor.getColumnIndex("troopCreateTime");
      if (i != -1) {
        break label6587;
      }
      paramatmz.a(new NoColumnError("troopCreateTime", Long.TYPE));
      label2751:
      i = paramCursor.getColumnIndex("dwGroupFlag");
      if (i != -1) {
        break label6602;
      }
      paramatmz.a(new NoColumnError("dwGroupFlag", Long.TYPE));
      label2786:
      i = paramCursor.getColumnIndex("cGroupOption");
      if (i != -1) {
        break label6617;
      }
      paramatmz.a(new NoColumnError("cGroupOption", Short.TYPE));
      label2821:
      i = paramCursor.getColumnIndex("wMemberMax");
      if (i != -1) {
        break label6632;
      }
      paramatmz.a(new NoColumnError("wMemberMax", Integer.TYPE));
      label2856:
      i = paramCursor.getColumnIndex("maxAdminNum");
      if (i != -1) {
        break label6647;
      }
      paramatmz.a(new NoColumnError("maxAdminNum", Integer.TYPE));
      label2891:
      i = paramCursor.getColumnIndex("wSpecialClass");
      if (i != -1) {
        break label6662;
      }
      paramatmz.a(new NoColumnError("wSpecialClass", Integer.TYPE));
      label2926:
      i = paramCursor.getColumnIndex("cGroupLevel");
      if (i != -1) {
        break label6677;
      }
      paramatmz.a(new NoColumnError("cGroupLevel", Short.TYPE));
      label2961:
      i = paramCursor.getColumnIndex("wMemberNum");
      if (i != -1) {
        break label6692;
      }
      paramatmz.a(new NoColumnError("wMemberNum", Integer.TYPE));
      label2996:
      i = paramCursor.getColumnIndex("wMemberNumClient");
      if (i != -1) {
        break label6707;
      }
      paramatmz.a(new NoColumnError("wMemberNumClient", Integer.TYPE));
      label3031:
      i = paramCursor.getColumnIndex("Administrator");
      if (i != -1) {
        break label6722;
      }
      paramatmz.a(new NoColumnError("Administrator", String.class));
      label3066:
      i = paramCursor.getColumnIndex("dwGroupClassExt");
      if (i != -1) {
        break label6737;
      }
      paramatmz.a(new NoColumnError("dwGroupClassExt", Long.TYPE));
      label3101:
      i = paramCursor.getColumnIndex("mGroupClassExtText");
      if (i != -1) {
        break label6752;
      }
      paramatmz.a(new NoColumnError("mGroupClassExtText", String.class));
      label3136:
      i = paramCursor.getColumnIndex("dwGroupFlagExt");
      if (i != -1) {
        break label6767;
      }
      paramatmz.a(new NoColumnError("dwGroupFlagExt", Long.TYPE));
      label3171:
      i = paramCursor.getColumnIndex("dwAuthGroupType");
      if (i != -1) {
        break label6782;
      }
      paramatmz.a(new NoColumnError("dwAuthGroupType", Long.TYPE));
      label3206:
      i = paramCursor.getColumnIndex("troopAuthenticateInfo");
      if (i != -1) {
        break label6797;
      }
      paramatmz.a(new NoColumnError("troopAuthenticateInfo", String.class));
      label3241:
      i = paramCursor.getColumnIndex("dwGroupInfoSeq");
      if (i != -1) {
        break label6812;
      }
      paramatmz.a(new NoColumnError("dwGroupInfoSeq", Long.TYPE));
      label3276:
      i = paramCursor.getColumnIndex("mMemberNumSeq");
      if (i != -1) {
        break label6827;
      }
      paramatmz.a(new NoColumnError("mMemberNumSeq", Long.TYPE));
      label3311:
      i = paramCursor.getColumnIndex("mOldMemberNumSeq");
      if (i != -1) {
        break label6842;
      }
      paramatmz.a(new NoColumnError("mOldMemberNumSeq", Long.TYPE));
      label3346:
      i = paramCursor.getColumnIndex("mMemberCardSeq");
      if (i != -1) {
        break label6857;
      }
      paramatmz.a(new NoColumnError("mMemberCardSeq", Long.TYPE));
      label3381:
      i = paramCursor.getColumnIndex("mOldMemberCardSeq");
      if (i != -1) {
        break label6872;
      }
      paramatmz.a(new NoColumnError("mOldMemberCardSeq", Long.TYPE));
      label3416:
      i = paramCursor.getColumnIndex("dwGroupLevelSeq");
      if (i != -1) {
        break label6887;
      }
      paramatmz.a(new NoColumnError("dwGroupLevelSeq", Long.TYPE));
      label3451:
      i = paramCursor.getColumnIndex("cGroupRankSysFlag");
      if (i != -1) {
        break label6902;
      }
      paramatmz.a(new NoColumnError("cGroupRankSysFlag", Byte.TYPE));
      label3486:
      i = paramCursor.getColumnIndex("cGroupRankUserFlag");
      if (i != -1) {
        break label6918;
      }
      paramatmz.a(new NoColumnError("cGroupRankUserFlag", Byte.TYPE));
      label3521:
      i = paramCursor.getColumnIndex("troopLevelMap");
      if (i != -1) {
        break label6934;
      }
      paramatmz.a(new NoColumnError("troopLevelMap", String.class));
      label3556:
      i = paramCursor.getColumnIndex("joinTroopQuestion");
      if (i != -1) {
        break label6949;
      }
      paramatmz.a(new NoColumnError("joinTroopQuestion", String.class));
      label3591:
      i = paramCursor.getColumnIndex("joinTroopAnswer");
      if (i != -1) {
        break label6964;
      }
      paramatmz.a(new NoColumnError("joinTroopAnswer", String.class));
      label3626:
      i = paramCursor.getColumnIndex("cAlbumResult");
      if (i != -1) {
        break label6979;
      }
      paramatmz.a(new NoColumnError("cAlbumResult", Byte.TYPE));
      label3661:
      i = paramCursor.getColumnIndex("dwTimeStamp");
      if (i != -1) {
        break label6995;
      }
      paramatmz.a(new NoColumnError("dwTimeStamp", Long.TYPE));
      label3696:
      i = paramCursor.getColumnIndex("strQZonePhotoUrls");
      if (i != -1) {
        break label7010;
      }
      paramatmz.a(new NoColumnError("strQZonePhotoUrls", String.class));
      label3731:
      i = paramCursor.getColumnIndex("mQZonePhotoNum");
      if (i != -1) {
        break label7025;
      }
      paramatmz.a(new NoColumnError("mQZonePhotoNum", Integer.TYPE));
      label3766:
      i = paramCursor.getColumnIndex("strLocation");
      if (i != -1) {
        break label7040;
      }
      paramatmz.a(new NoColumnError("strLocation", String.class));
      label3801:
      i = paramCursor.getColumnIndex("troopLat");
      if (i != -1) {
        break label7055;
      }
      paramatmz.a(new NoColumnError("troopLat", Integer.TYPE));
      label3836:
      i = paramCursor.getColumnIndex("troopLon");
      if (i != -1) {
        break label7070;
      }
      paramatmz.a(new NoColumnError("troopLon", Integer.TYPE));
      label3871:
      i = paramCursor.getColumnIndex("mMemberInvitingFlag");
      if (i != -1) {
        break label7085;
      }
      paramatmz.a(new NoColumnError("mMemberInvitingFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label7112;
      }
      paramatmz.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label3941:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label7127;
      }
      paramatmz.a(new NoColumnError("mCompareSpell", String.class));
      label3976:
      i = paramCursor.getColumnIndex("mSomeMemberUins");
      if (i != -1) {
        break label7142;
      }
      paramatmz.a(new NoColumnError("mSomeMemberUins", String.class));
      label4011:
      i = paramCursor.getColumnIndex("mHeaderUinsOld");
      if (i != -1) {
        break label7157;
      }
      paramatmz.a(new NoColumnError("mHeaderUinsOld", String.class));
      label4046:
      i = paramCursor.getColumnIndex("mHeaderUinsNew");
      if (i != -1) {
        break label7172;
      }
      paramatmz.a(new NoColumnError("mHeaderUinsNew", String.class));
      label4081:
      i = paramCursor.getColumnIndex("mTags");
      if (i != -1) {
        break label7187;
      }
      paramatmz.a(new NoColumnError("mTags", String.class));
      label4118:
      i = paramCursor.getColumnIndex("mTroopAvatarId");
      if (i != -1) {
        break label7202;
      }
      paramatmz.a(new NoColumnError("mTroopAvatarId", Integer.TYPE));
      label4155:
      i = paramCursor.getColumnIndex("mTroopPicListJson");
      if (i != -1) {
        break label7217;
      }
      paramatmz.a(new NoColumnError("mTroopPicListJson", String.class));
      label4192:
      i = paramCursor.getColumnIndex("nTroopGrade");
      if (i != -1) {
        break label7232;
      }
      paramatmz.a(new NoColumnError("nTroopGrade", Integer.TYPE));
      label4229:
      i = paramCursor.getColumnIndex("isShowInNearbyTroops");
      if (i != -1) {
        break label7247;
      }
      paramatmz.a(new NoColumnError("isShowInNearbyTroops", Integer.TYPE));
      label4266:
      i = paramCursor.getColumnIndex("dwGagTimeStamp");
      if (i != -1) {
        break label7262;
      }
      paramatmz.a(new NoColumnError("dwGagTimeStamp", Long.TYPE));
      label4303:
      i = paramCursor.getColumnIndex("dwGagTimeStamp_me");
      if (i != -1) {
        break label7277;
      }
      paramatmz.a(new NoColumnError("dwGagTimeStamp_me", Long.TYPE));
      label4340:
      i = paramCursor.getColumnIndex("dwCmdUinUinFlag");
      if (i != -1) {
        break label7292;
      }
      paramatmz.a(new NoColumnError("dwCmdUinUinFlag", Long.TYPE));
      label4377:
      i = paramCursor.getColumnIndex("dwAdditionalFlag");
      if (i != -1) {
        break label7307;
      }
      paramatmz.a(new NoColumnError("dwAdditionalFlag", Long.TYPE));
      label4414:
      i = paramCursor.getColumnIndex("troopTypeExt");
      if (i != -1) {
        break label7322;
      }
      paramatmz.a(new NoColumnError("troopTypeExt", Integer.TYPE));
      label4451:
      i = paramCursor.getColumnIndex("ownerNameShow");
      if (i != -1) {
        break label7337;
      }
      paramatmz.a(new NoColumnError("ownerNameShow", String.class));
      label4488:
      i = paramCursor.getColumnIndex("adminNameShow");
      if (i != -1) {
        break label7352;
      }
      paramatmz.a(new NoColumnError("adminNameShow", String.class));
      label4525:
      i = paramCursor.getColumnIndex("dwOfficeMode");
      if (i != -1) {
        break label7367;
      }
      paramatmz.a(new NoColumnError("dwOfficeMode", Long.TYPE));
      label4562:
      i = paramCursor.getColumnIndex("dwGroupFlagExt3");
      if (i != -1) {
        break label7382;
      }
      paramatmz.a(new NoColumnError("dwGroupFlagExt3", Long.TYPE));
      label4599:
      i = paramCursor.getColumnIndex("cmdUinFlagEx2");
      if (i != -1) {
        break label7397;
      }
      paramatmz.a(new NoColumnError("cmdUinFlagEx2", Long.TYPE));
      label4636:
      i = paramCursor.getColumnIndex("udwCmdUinRingtoneID");
      if (i != -1) {
        break label7412;
      }
      paramatmz.a(new NoColumnError("udwCmdUinRingtoneID", Long.TYPE));
      label4673:
      i = paramCursor.getColumnIndex("memberListToShow");
      if (i != -1) {
        break label7427;
      }
      paramatmz.a(new NoColumnError("memberListToShow", String.class));
      label4710:
      i = paramCursor.getColumnIndex("troopPrivilegeFlag");
      if (i != -1) {
        break label7442;
      }
      paramatmz.a(new NoColumnError("troopPrivilegeFlag", Long.TYPE));
      label4747:
      i = paramCursor.getColumnIndex("isNewTroop");
      if (i != -1) {
        break label7457;
      }
      paramatmz.a(new NoColumnError("isNewTroop", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasSetNewTroopHead");
      if (i != -1) {
        break label7484;
      }
      paramatmz.a(new NoColumnError("hasSetNewTroopHead", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasSetNewTroopName");
      if (i != -1) {
        break label7511;
      }
      paramatmz.a(new NoColumnError("hasSetNewTroopName", Boolean.TYPE));
      i = paramCursor.getColumnIndex("maxInviteMemNum");
      if (i != -1) {
        break label7538;
      }
      paramatmz.a(new NoColumnError("maxInviteMemNum", Integer.TYPE));
      label4895:
      i = paramCursor.getColumnIndex("lastMsgTime");
      if (i != -1) {
        break label7553;
      }
      paramatmz.a(new NoColumnError("lastMsgTime", Long.TYPE));
      label4932:
      i = paramCursor.getColumnIndex("allowMemberModifTroopName");
      if (i != -1) {
        break label7568;
      }
      paramatmz.a(new NoColumnError("allowMemberModifTroopName", Integer.TYPE));
      label4969:
      i = paramCursor.getColumnIndex("allowMemberKick");
      if (i != -1) {
        break label7583;
      }
      paramatmz.a(new NoColumnError("allowMemberKick", Integer.TYPE));
      label5006:
      i = paramCursor.getColumnIndex("allowMemberAtAll");
      if (i != -1) {
        break label7598;
      }
      paramatmz.a(new NoColumnError("allowMemberAtAll", Integer.TYPE));
      label5043:
      i = paramCursor.getColumnIndex("oldTroopName");
      if (i != -1) {
        break label7613;
      }
      paramatmz.a(new NoColumnError("oldTroopName", String.class));
      label5080:
      i = paramCursor.getColumnIndex("hlGuildAppid");
      if (i != -1) {
        break label7628;
      }
      paramatmz.a(new NoColumnError("hlGuildAppid", Long.TYPE));
      label5117:
      i = paramCursor.getColumnIndex("hlGuildSubType");
      if (i != -1) {
        break label7643;
      }
      paramatmz.a(new NoColumnError("hlGuildSubType", Long.TYPE));
      label5154:
      i = paramCursor.getColumnIndex("hlGuildOrgid");
      if (i != -1) {
        break label7658;
      }
      paramatmz.a(new NoColumnError("hlGuildOrgid", Integer.TYPE));
      label5191:
      i = paramCursor.getColumnIndex("hlGuildBinary");
      if (i != -1) {
        break label7673;
      }
      paramatmz.a(new NoColumnError("hlGuildBinary", Integer.TYPE));
      label5228:
      i = paramCursor.getColumnIndex("gameSwitchStatus");
      if (i != -1) {
        break label7688;
      }
      paramatmz.a(new NoColumnError("gameSwitchStatus", Integer.TYPE));
      label5265:
      i = paramCursor.getColumnIndex("showGameSwitchStatus");
      if (i != -1) {
        break label7703;
      }
      paramatmz.a(new NoColumnError("showGameSwitchStatus", Integer.TYPE));
      label5302:
      i = paramCursor.getColumnIndex("lastShareLbsMsgUniseq");
      if (i != -1) {
        break label7718;
      }
      paramatmz.a(new NoColumnError("lastShareLbsMsgUniseq", Long.TYPE));
      label5339:
      i = paramCursor.getColumnIndex("mTroopNeedPayNumber");
      if (i != -1) {
        break label7733;
      }
      paramatmz.a(new NoColumnError("mTroopNeedPayNumber", Float.TYPE));
      label5376:
      i = paramCursor.getColumnIndex("troopCreditLevel");
      if (i != -1) {
        break label7748;
      }
      paramatmz.a(new NoColumnError("troopCreditLevel", Long.TYPE));
      label5413:
      i = paramCursor.getColumnIndex("troopCreditLevelInfo");
      if (i != -1) {
        break label7763;
      }
      paramatmz.a(new NoColumnError("troopCreditLevelInfo", Long.TYPE));
      label5450:
      i = paramCursor.getColumnIndex("dwAppPrivilegeFlag");
      if (i != -1) {
        break label7778;
      }
      paramatmz.a(new NoColumnError("dwAppPrivilegeFlag", Long.TYPE));
      label5487:
      i = paramCursor.getColumnIndex("topicId");
      if (i != -1) {
        break label7793;
      }
      paramatmz.a(new NoColumnError("topicId", String.class));
      label5524:
      i = paramCursor.getColumnIndex("associatePubAccount");
      if (i != -1) {
        break label7808;
      }
      paramatmz.a(new NoColumnError("associatePubAccount", Long.TYPE));
      label5561:
      i = paramCursor.getColumnIndex("mTroopFileVideoReqInterval");
      if (i != -1) {
        break label7823;
      }
      paramatmz.a(new NoColumnError("mTroopFileVideoReqInterval", Long.TYPE));
      label5598:
      i = paramCursor.getColumnIndex("mTroopFileVideoIsWhite");
      if (i != -1) {
        break label7838;
      }
      paramatmz.a(new NoColumnError("mTroopFileVideoIsWhite", Integer.TYPE));
      label5635:
      i = paramCursor.getColumnIndex("mTribeStatus");
      if (i != -1) {
        break label7853;
      }
      paramatmz.a(new NoColumnError("mTribeStatus", Integer.TYPE));
      label5672:
      i = paramCursor.getColumnIndex("mCanSearchByKeywords");
      if (i != -1) {
        break label7868;
      }
      paramatmz.a(new NoColumnError("mCanSearchByKeywords", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mCanSearchByTroopUin");
      if (i != -1) {
        break label7895;
      }
      paramatmz.a(new NoColumnError("mCanSearchByTroopUin", Boolean.TYPE));
      i = paramCursor.getColumnIndex("dwCmdUinJoinTime");
      if (i != -1) {
        break label7923;
      }
      paramatmz.a(new NoColumnError("dwCmdUinJoinTime", Long.TYPE));
      label5783:
      i = paramCursor.getColumnIndex("dwLastInsertBAFTipTime");
      if (i != -1) {
        break label7938;
      }
      paramatmz.a(new NoColumnError("dwLastInsertBAFTipTime", Long.TYPE));
      label5820:
      i = paramCursor.getColumnIndex("wInsertBAFTipCount");
      if (i != -1) {
        break label7953;
      }
      paramatmz.a(new NoColumnError("wInsertBAFTipCount", Integer.TYPE));
      label5857:
      i = paramCursor.getColumnIndex("wClickBAFTipCount");
      if (i != -1) {
        break label7968;
      }
      paramatmz.a(new NoColumnError("wClickBAFTipCount", Integer.TYPE));
      label5894:
      i = paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq");
      if (i != -1) {
        break label7983;
      }
      paramatmz.a(new NoColumnError("dwLastBAFTipMsgUniSeq", Long.TYPE));
      label5931:
      i = paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq2");
      if (i != -1) {
        break label7998;
      }
      paramatmz.a(new NoColumnError("dwLastBAFTipMsgUniSeq2", Long.TYPE));
      label5968:
      i = paramCursor.getColumnIndex("dailyNewMemberUins");
      if (i != -1) {
        break label8013;
      }
      paramatmz.a(new NoColumnError("dailyNewMemberUins", String.class));
      label6005:
      i = paramCursor.getColumnIndex("exitTroopReason");
      if (i != -1) {
        break label8028;
      }
      paramatmz.a(new NoColumnError("exitTroopReason", Integer.TYPE));
      label6042:
      i = paramCursor.getColumnIndex("eliminated");
      if (i != -1) {
        break label8043;
      }
      paramatmz.a(new NoColumnError("eliminated", Integer.TYPE));
      label6079:
      i = paramCursor.getColumnIndex("mIsFreezed");
      if (i != -1) {
        break label8058;
      }
      paramatmz.a(new NoColumnError("mIsFreezed", Integer.TYPE));
      label6116:
      i = paramCursor.getColumnIndex("strLastAnnouncement");
      if (i != -1) {
        break label8073;
      }
      paramatmz.a(new NoColumnError("strLastAnnouncement", String.class));
      label6153:
      i = paramCursor.getColumnIndex("nMsgLimitFreq");
      if (i != -1) {
        break label8088;
      }
      paramatmz.a(new NoColumnError("nMsgLimitFreq", Integer.TYPE));
      label6190:
      i = paramCursor.getColumnIndex("mAtOrReplyMeUins");
      if (i != -1) {
        break label8103;
      }
      paramatmz.a(new NoColumnError("mAtOrReplyMeUins", String.class));
      label6227:
      i = paramCursor.getColumnIndex("groupFlagExt4");
      if (i != -1) {
        break label8118;
      }
      paramatmz.a(new NoColumnError("groupFlagExt4", Integer.TYPE));
      label6264:
      i = paramCursor.getColumnIndex("groupFreezeReason");
      if (i != -1) {
        break label8133;
      }
      paramatmz.a(new NoColumnError("groupFreezeReason", Integer.TYPE));
      label6301:
      i = paramCursor.getColumnIndex("troopHonorGrayFlag");
      if (i != -1) {
        break label8148;
      }
      paramatmz.a(new NoColumnError("troopHonorGrayFlag", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("isAllowHistoryMsgFlag");
      if (i != -1) {
        break label8163;
      }
      paramatmz.a(new NoColumnError("isAllowHistoryMsgFlag", Integer.TYPE));
      return paramatmo;
      paramatmo.uin = paramCursor.getString(i);
      break;
      label6392:
      paramatmo.timeSec = paramCursor.getLong(i);
      break label2296;
      label6407:
      paramatmo.troopuin = paramCursor.getString(i);
      break label2331;
      label6422:
      paramatmo.troopcode = paramCursor.getString(i);
      break label2366;
      label6437:
      paramatmo.troopowneruin = paramCursor.getString(i);
      break label2401;
      label6452:
      paramatmo.troopname = paramCursor.getString(i);
      break label2436;
      label6467:
      paramatmo.newTroopName = paramCursor.getString(i);
      break label2471;
      label6482:
      paramatmo.newTroopNameTimeStamp = paramCursor.getLong(i);
      break label2506;
      label6497:
      paramatmo.troopface = paramCursor.getShort(i);
      break label2541;
      label6512:
      paramatmo.troopmemo = paramCursor.getString(i);
      break label2576;
      label6527:
      paramatmo.fingertroopmemo = paramCursor.getString(i);
      break label2611;
      label6542:
      paramatmo.mRichFingerMemo = paramCursor.getString(i);
      break label2646;
      label6557:
      paramatmo.troopmask = paramCursor.getInt(i);
      break label2681;
      label6572:
      paramatmo.trooptype = paramCursor.getInt(i);
      break label2716;
      label6587:
      paramatmo.troopCreateTime = paramCursor.getLong(i);
      break label2751;
      label6602:
      paramatmo.dwGroupFlag = paramCursor.getLong(i);
      break label2786;
      label6617:
      paramatmo.cGroupOption = paramCursor.getShort(i);
      break label2821;
      label6632:
      paramatmo.wMemberMax = paramCursor.getInt(i);
      break label2856;
      label6647:
      paramatmo.maxAdminNum = paramCursor.getInt(i);
      break label2891;
      label6662:
      paramatmo.wSpecialClass = paramCursor.getInt(i);
      break label2926;
      label6677:
      paramatmo.cGroupLevel = paramCursor.getShort(i);
      break label2961;
      label6692:
      paramatmo.wMemberNum = paramCursor.getInt(i);
      break label2996;
      label6707:
      paramatmo.wMemberNumClient = paramCursor.getInt(i);
      break label3031;
      label6722:
      paramatmo.Administrator = paramCursor.getString(i);
      break label3066;
      label6737:
      paramatmo.dwGroupClassExt = paramCursor.getLong(i);
      break label3101;
      label6752:
      paramatmo.mGroupClassExtText = paramCursor.getString(i);
      break label3136;
      label6767:
      paramatmo.dwGroupFlagExt = paramCursor.getLong(i);
      break label3171;
      label6782:
      paramatmo.dwAuthGroupType = paramCursor.getLong(i);
      break label3206;
      label6797:
      paramatmo.troopAuthenticateInfo = paramCursor.getString(i);
      break label3241;
      label6812:
      paramatmo.dwGroupInfoSeq = paramCursor.getLong(i);
      break label3276;
      label6827:
      paramatmo.mMemberNumSeq = paramCursor.getLong(i);
      break label3311;
      label6842:
      paramatmo.mOldMemberNumSeq = paramCursor.getLong(i);
      break label3346;
      label6857:
      paramatmo.mMemberCardSeq = paramCursor.getLong(i);
      break label3381;
      label6872:
      paramatmo.mOldMemberCardSeq = paramCursor.getLong(i);
      break label3416;
      label6887:
      paramatmo.dwGroupLevelSeq = paramCursor.getLong(i);
      break label3451;
      label6902:
      paramatmo.cGroupRankSysFlag = ((byte)paramCursor.getShort(i));
      break label3486;
      label6918:
      paramatmo.cGroupRankUserFlag = ((byte)paramCursor.getShort(i));
      break label3521;
      label6934:
      paramatmo.troopLevelMap = paramCursor.getString(i);
      break label3556;
      label6949:
      paramatmo.joinTroopQuestion = paramCursor.getString(i);
      break label3591;
      label6964:
      paramatmo.joinTroopAnswer = paramCursor.getString(i);
      break label3626;
      label6979:
      paramatmo.cAlbumResult = ((byte)paramCursor.getShort(i));
      break label3661;
      label6995:
      paramatmo.dwTimeStamp = paramCursor.getLong(i);
      break label3696;
      label7010:
      paramatmo.strQZonePhotoUrls = paramCursor.getString(i);
      break label3731;
      label7025:
      paramatmo.mQZonePhotoNum = paramCursor.getInt(i);
      break label3766;
      label7040:
      paramatmo.strLocation = paramCursor.getString(i);
      break label3801;
      label7055:
      paramatmo.troopLat = paramCursor.getInt(i);
      break label3836;
      label7070:
      paramatmo.troopLon = paramCursor.getInt(i);
      break label3871;
      label7085:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.mMemberInvitingFlag = paramBoolean;
        break;
      }
      label7112:
      paramatmo.mComparePartInt = paramCursor.getInt(i);
      break label3941;
      label7127:
      paramatmo.mCompareSpell = paramCursor.getString(i);
      break label3976;
      label7142:
      paramatmo.mSomeMemberUins = paramCursor.getString(i);
      break label4011;
      label7157:
      paramatmo.mHeaderUinsOld = paramCursor.getString(i);
      break label4046;
      label7172:
      paramatmo.mHeaderUinsNew = paramCursor.getString(i);
      break label4081;
      label7187:
      paramatmo.mTags = paramCursor.getString(i);
      break label4118;
      label7202:
      paramatmo.mTroopAvatarId = paramCursor.getInt(i);
      break label4155;
      label7217:
      paramatmo.mTroopPicListJson = paramCursor.getString(i);
      break label4192;
      label7232:
      paramatmo.nTroopGrade = paramCursor.getInt(i);
      break label4229;
      label7247:
      paramatmo.isShowInNearbyTroops = paramCursor.getInt(i);
      break label4266;
      label7262:
      paramatmo.dwGagTimeStamp = paramCursor.getLong(i);
      break label4303;
      label7277:
      paramatmo.dwGagTimeStamp_me = paramCursor.getLong(i);
      break label4340;
      label7292:
      paramatmo.dwCmdUinUinFlag = paramCursor.getLong(i);
      break label4377;
      label7307:
      paramatmo.dwAdditionalFlag = paramCursor.getLong(i);
      break label4414;
      label7322:
      paramatmo.troopTypeExt = paramCursor.getInt(i);
      break label4451;
      label7337:
      paramatmo.ownerNameShow = paramCursor.getString(i);
      break label4488;
      label7352:
      paramatmo.adminNameShow = paramCursor.getString(i);
      break label4525;
      label7367:
      paramatmo.dwOfficeMode = paramCursor.getLong(i);
      break label4562;
      label7382:
      paramatmo.dwGroupFlagExt3 = paramCursor.getLong(i);
      break label4599;
      label7397:
      paramatmo.cmdUinFlagEx2 = paramCursor.getLong(i);
      break label4636;
      label7412:
      paramatmo.udwCmdUinRingtoneID = paramCursor.getLong(i);
      break label4673;
      label7427:
      paramatmo.memberListToShow = paramCursor.getString(i);
      break label4710;
      label7442:
      paramatmo.troopPrivilegeFlag = paramCursor.getLong(i);
      break label4747;
      label7457:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isNewTroop = paramBoolean;
        break;
      }
      label7484:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.hasSetNewTroopHead = paramBoolean;
        break;
      }
      label7511:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.hasSetNewTroopName = paramBoolean;
        break;
      }
      label7538:
      paramatmo.maxInviteMemNum = paramCursor.getInt(i);
      break label4895;
      label7553:
      paramatmo.lastMsgTime = paramCursor.getLong(i);
      break label4932;
      label7568:
      paramatmo.allowMemberModifTroopName = paramCursor.getInt(i);
      break label4969;
      label7583:
      paramatmo.allowMemberKick = paramCursor.getInt(i);
      break label5006;
      label7598:
      paramatmo.allowMemberAtAll = paramCursor.getInt(i);
      break label5043;
      label7613:
      paramatmo.oldTroopName = paramCursor.getString(i);
      break label5080;
      label7628:
      paramatmo.hlGuildAppid = paramCursor.getLong(i);
      break label5117;
      label7643:
      paramatmo.hlGuildSubType = paramCursor.getLong(i);
      break label5154;
      label7658:
      paramatmo.hlGuildOrgid = paramCursor.getInt(i);
      break label5191;
      label7673:
      paramatmo.hlGuildBinary = paramCursor.getInt(i);
      break label5228;
      label7688:
      paramatmo.gameSwitchStatus = paramCursor.getInt(i);
      break label5265;
      label7703:
      paramatmo.showGameSwitchStatus = paramCursor.getInt(i);
      break label5302;
      label7718:
      paramatmo.lastShareLbsMsgUniseq = paramCursor.getLong(i);
      break label5339;
      label7733:
      paramatmo.mTroopNeedPayNumber = paramCursor.getFloat(i);
      break label5376;
      label7748:
      paramatmo.troopCreditLevel = paramCursor.getLong(i);
      break label5413;
      label7763:
      paramatmo.troopCreditLevelInfo = paramCursor.getLong(i);
      break label5450;
      label7778:
      paramatmo.dwAppPrivilegeFlag = paramCursor.getLong(i);
      break label5487;
      label7793:
      paramatmo.topicId = paramCursor.getString(i);
      break label5524;
      label7808:
      paramatmo.associatePubAccount = paramCursor.getLong(i);
      break label5561;
      label7823:
      paramatmo.mTroopFileVideoReqInterval = paramCursor.getLong(i);
      break label5598;
      label7838:
      paramatmo.mTroopFileVideoIsWhite = paramCursor.getInt(i);
      break label5635;
      label7853:
      paramatmo.mTribeStatus = paramCursor.getInt(i);
      break label5672;
      label7868:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.mCanSearchByKeywords = paramBoolean;
        break;
      }
      label7895:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramatmo.mCanSearchByTroopUin = paramBoolean;
        break;
      }
      label7923:
      paramatmo.dwCmdUinJoinTime = paramCursor.getLong(i);
      break label5783;
      label7938:
      paramatmo.dwLastInsertBAFTipTime = paramCursor.getLong(i);
      break label5820;
      label7953:
      paramatmo.wInsertBAFTipCount = paramCursor.getInt(i);
      break label5857;
      label7968:
      paramatmo.wClickBAFTipCount = paramCursor.getInt(i);
      break label5894;
      label7983:
      paramatmo.dwLastBAFTipMsgUniSeq = paramCursor.getLong(i);
      break label5931;
      label7998:
      paramatmo.dwLastBAFTipMsgUniSeq2 = paramCursor.getLong(i);
      break label5968;
      label8013:
      paramatmo.dailyNewMemberUins = paramCursor.getString(i);
      break label6005;
      label8028:
      paramatmo.exitTroopReason = paramCursor.getInt(i);
      break label6042;
      label8043:
      paramatmo.eliminated = paramCursor.getInt(i);
      break label6079;
      label8058:
      paramatmo.mIsFreezed = paramCursor.getInt(i);
      break label6116;
      label8073:
      paramatmo.strLastAnnouncement = paramCursor.getString(i);
      break label6153;
      label8088:
      paramatmo.nMsgLimitFreq = paramCursor.getInt(i);
      break label6190;
      label8103:
      paramatmo.mAtOrReplyMeUins = paramCursor.getString(i);
      break label6227;
      label8118:
      paramatmo.groupFlagExt4 = paramCursor.getInt(i);
      break label6264;
      label8133:
      paramatmo.groupFreezeReason = paramCursor.getInt(i);
      break label6301;
      label8148:
      paramatmo.troopHonorGrayFlag = paramCursor.getInt(i);
    }
    label8163:
    paramatmo.isAllowHistoryMsgFlag = paramCursor.getInt(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,timeSec INTEGER ,troopuin TEXT UNIQUE ,troopcode TEXT ,troopowneruin TEXT ,troopname TEXT ,newTroopName TEXT ,newTroopNameTimeStamp INTEGER ,troopface INTEGER ,troopmemo TEXT ,fingertroopmemo TEXT ,mRichFingerMemo TEXT ,troopmask INTEGER ,trooptype INTEGER ,troopCreateTime INTEGER ,dwGroupFlag INTEGER ,cGroupOption INTEGER ,wMemberMax INTEGER ,maxAdminNum INTEGER ,wSpecialClass INTEGER ,cGroupLevel INTEGER ,wMemberNum INTEGER ,wMemberNumClient INTEGER ,Administrator TEXT ,dwGroupClassExt INTEGER ,mGroupClassExtText TEXT ,dwGroupFlagExt INTEGER ,dwAuthGroupType INTEGER ,troopAuthenticateInfo TEXT ,dwGroupInfoSeq INTEGER ,mMemberNumSeq INTEGER ,mOldMemberNumSeq INTEGER ,mMemberCardSeq INTEGER ,mOldMemberCardSeq INTEGER ,dwGroupLevelSeq INTEGER ,cGroupRankSysFlag INTEGER ,cGroupRankUserFlag INTEGER ,troopLevelMap TEXT ,joinTroopQuestion TEXT ,joinTroopAnswer TEXT ,cAlbumResult INTEGER ,dwTimeStamp INTEGER ,strQZonePhotoUrls TEXT ,mQZonePhotoNum INTEGER ,strLocation TEXT ,troopLat INTEGER ,troopLon INTEGER ,mMemberInvitingFlag INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,mSomeMemberUins TEXT ,mHeaderUinsOld TEXT ,mHeaderUinsNew TEXT ,mTags TEXT ,mTroopAvatarId INTEGER ,mTroopPicListJson TEXT ,nTroopGrade INTEGER ,isShowInNearbyTroops INTEGER ,dwGagTimeStamp INTEGER ,dwGagTimeStamp_me INTEGER ,dwCmdUinUinFlag INTEGER ,dwAdditionalFlag INTEGER ,troopTypeExt INTEGER ,ownerNameShow TEXT ,adminNameShow TEXT ,dwOfficeMode INTEGER ,dwGroupFlagExt3 INTEGER ,cmdUinFlagEx2 INTEGER ,udwCmdUinRingtoneID INTEGER ,memberListToShow TEXT ,troopPrivilegeFlag INTEGER ,isNewTroop INTEGER ,hasSetNewTroopHead INTEGER ,hasSetNewTroopName INTEGER ,maxInviteMemNum INTEGER ,lastMsgTime INTEGER ,allowMemberModifTroopName INTEGER ,allowMemberKick INTEGER ,allowMemberAtAll INTEGER ,oldTroopName TEXT ,hlGuildAppid INTEGER ,hlGuildSubType INTEGER ,hlGuildOrgid INTEGER ,hlGuildBinary INTEGER ,gameSwitchStatus INTEGER ,showGameSwitchStatus INTEGER ,lastShareLbsMsgUniseq INTEGER ,mTroopNeedPayNumber REAL ,troopCreditLevel INTEGER ,troopCreditLevelInfo INTEGER ,dwAppPrivilegeFlag INTEGER ,topicId TEXT ,associatePubAccount INTEGER ,mTroopFileVideoReqInterval INTEGER ,mTroopFileVideoIsWhite INTEGER ,mTribeStatus INTEGER ,mCanSearchByKeywords INTEGER ,mCanSearchByTroopUin INTEGER ,dwCmdUinJoinTime INTEGER ,dwLastInsertBAFTipTime INTEGER ,wInsertBAFTipCount INTEGER ,wClickBAFTipCount INTEGER ,dwLastBAFTipMsgUniSeq INTEGER ,dwLastBAFTipMsgUniSeq2 INTEGER ,dailyNewMemberUins TEXT ,exitTroopReason INTEGER ,eliminated INTEGER ,mIsFreezed INTEGER ,strLastAnnouncement TEXT ,nMsgLimitFreq INTEGER ,mAtOrReplyMeUins TEXT ,groupFlagExt4 INTEGER ,groupFreezeReason INTEGER ,troopHonorGrayFlag INTEGER ,isAllowHistoryMsgFlag INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (TroopInfo)paramatmo;
    paramContentValues.put("uin", paramatmo.uin);
    paramContentValues.put("timeSec", Long.valueOf(paramatmo.timeSec));
    paramContentValues.put("troopuin", paramatmo.troopuin);
    paramContentValues.put("troopcode", paramatmo.troopcode);
    paramContentValues.put("troopowneruin", paramatmo.troopowneruin);
    paramContentValues.put("troopname", paramatmo.troopname);
    paramContentValues.put("newTroopName", paramatmo.newTroopName);
    paramContentValues.put("newTroopNameTimeStamp", Long.valueOf(paramatmo.newTroopNameTimeStamp));
    paramContentValues.put("troopface", Short.valueOf(paramatmo.troopface));
    paramContentValues.put("troopmemo", paramatmo.troopmemo);
    paramContentValues.put("fingertroopmemo", paramatmo.fingertroopmemo);
    paramContentValues.put("mRichFingerMemo", paramatmo.mRichFingerMemo);
    paramContentValues.put("troopmask", Integer.valueOf(paramatmo.troopmask));
    paramContentValues.put("trooptype", Integer.valueOf(paramatmo.trooptype));
    paramContentValues.put("troopCreateTime", Long.valueOf(paramatmo.troopCreateTime));
    paramContentValues.put("dwGroupFlag", Long.valueOf(paramatmo.dwGroupFlag));
    paramContentValues.put("cGroupOption", Short.valueOf(paramatmo.cGroupOption));
    paramContentValues.put("wMemberMax", Integer.valueOf(paramatmo.wMemberMax));
    paramContentValues.put("maxAdminNum", Integer.valueOf(paramatmo.maxAdminNum));
    paramContentValues.put("wSpecialClass", Integer.valueOf(paramatmo.wSpecialClass));
    paramContentValues.put("cGroupLevel", Short.valueOf(paramatmo.cGroupLevel));
    paramContentValues.put("wMemberNum", Integer.valueOf(paramatmo.wMemberNum));
    paramContentValues.put("wMemberNumClient", Integer.valueOf(paramatmo.wMemberNumClient));
    paramContentValues.put("Administrator", paramatmo.Administrator);
    paramContentValues.put("dwGroupClassExt", Long.valueOf(paramatmo.dwGroupClassExt));
    paramContentValues.put("mGroupClassExtText", paramatmo.mGroupClassExtText);
    paramContentValues.put("dwGroupFlagExt", Long.valueOf(paramatmo.dwGroupFlagExt));
    paramContentValues.put("dwAuthGroupType", Long.valueOf(paramatmo.dwAuthGroupType));
    paramContentValues.put("troopAuthenticateInfo", paramatmo.troopAuthenticateInfo);
    paramContentValues.put("dwGroupInfoSeq", Long.valueOf(paramatmo.dwGroupInfoSeq));
    paramContentValues.put("mMemberNumSeq", Long.valueOf(paramatmo.mMemberNumSeq));
    paramContentValues.put("mOldMemberNumSeq", Long.valueOf(paramatmo.mOldMemberNumSeq));
    paramContentValues.put("mMemberCardSeq", Long.valueOf(paramatmo.mMemberCardSeq));
    paramContentValues.put("mOldMemberCardSeq", Long.valueOf(paramatmo.mOldMemberCardSeq));
    paramContentValues.put("dwGroupLevelSeq", Long.valueOf(paramatmo.dwGroupLevelSeq));
    paramContentValues.put("cGroupRankSysFlag", Byte.valueOf(paramatmo.cGroupRankSysFlag));
    paramContentValues.put("cGroupRankUserFlag", Byte.valueOf(paramatmo.cGroupRankUserFlag));
    paramContentValues.put("troopLevelMap", paramatmo.troopLevelMap);
    paramContentValues.put("joinTroopQuestion", paramatmo.joinTroopQuestion);
    paramContentValues.put("joinTroopAnswer", paramatmo.joinTroopAnswer);
    paramContentValues.put("cAlbumResult", Byte.valueOf(paramatmo.cAlbumResult));
    paramContentValues.put("dwTimeStamp", Long.valueOf(paramatmo.dwTimeStamp));
    paramContentValues.put("strQZonePhotoUrls", paramatmo.strQZonePhotoUrls);
    paramContentValues.put("mQZonePhotoNum", Integer.valueOf(paramatmo.mQZonePhotoNum));
    paramContentValues.put("strLocation", paramatmo.strLocation);
    paramContentValues.put("troopLat", Integer.valueOf(paramatmo.troopLat));
    paramContentValues.put("troopLon", Integer.valueOf(paramatmo.troopLon));
    paramContentValues.put("mMemberInvitingFlag", Boolean.valueOf(paramatmo.mMemberInvitingFlag));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramatmo.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramatmo.mCompareSpell);
    paramContentValues.put("mSomeMemberUins", paramatmo.mSomeMemberUins);
    paramContentValues.put("mHeaderUinsOld", paramatmo.mHeaderUinsOld);
    paramContentValues.put("mHeaderUinsNew", paramatmo.mHeaderUinsNew);
    paramContentValues.put("mTags", paramatmo.mTags);
    paramContentValues.put("mTroopAvatarId", Integer.valueOf(paramatmo.mTroopAvatarId));
    paramContentValues.put("mTroopPicListJson", paramatmo.mTroopPicListJson);
    paramContentValues.put("nTroopGrade", Integer.valueOf(paramatmo.nTroopGrade));
    paramContentValues.put("isShowInNearbyTroops", Integer.valueOf(paramatmo.isShowInNearbyTroops));
    paramContentValues.put("dwGagTimeStamp", Long.valueOf(paramatmo.dwGagTimeStamp));
    paramContentValues.put("dwGagTimeStamp_me", Long.valueOf(paramatmo.dwGagTimeStamp_me));
    paramContentValues.put("dwCmdUinUinFlag", Long.valueOf(paramatmo.dwCmdUinUinFlag));
    paramContentValues.put("dwAdditionalFlag", Long.valueOf(paramatmo.dwAdditionalFlag));
    paramContentValues.put("troopTypeExt", Integer.valueOf(paramatmo.troopTypeExt));
    paramContentValues.put("ownerNameShow", paramatmo.ownerNameShow);
    paramContentValues.put("adminNameShow", paramatmo.adminNameShow);
    paramContentValues.put("dwOfficeMode", Long.valueOf(paramatmo.dwOfficeMode));
    paramContentValues.put("dwGroupFlagExt3", Long.valueOf(paramatmo.dwGroupFlagExt3));
    paramContentValues.put("cmdUinFlagEx2", Long.valueOf(paramatmo.cmdUinFlagEx2));
    paramContentValues.put("udwCmdUinRingtoneID", Long.valueOf(paramatmo.udwCmdUinRingtoneID));
    paramContentValues.put("memberListToShow", paramatmo.memberListToShow);
    paramContentValues.put("troopPrivilegeFlag", Long.valueOf(paramatmo.troopPrivilegeFlag));
    paramContentValues.put("isNewTroop", Boolean.valueOf(paramatmo.isNewTroop));
    paramContentValues.put("hasSetNewTroopHead", Boolean.valueOf(paramatmo.hasSetNewTroopHead));
    paramContentValues.put("hasSetNewTroopName", Boolean.valueOf(paramatmo.hasSetNewTroopName));
    paramContentValues.put("maxInviteMemNum", Integer.valueOf(paramatmo.maxInviteMemNum));
    paramContentValues.put("lastMsgTime", Long.valueOf(paramatmo.lastMsgTime));
    paramContentValues.put("allowMemberModifTroopName", Integer.valueOf(paramatmo.allowMemberModifTroopName));
    paramContentValues.put("allowMemberKick", Integer.valueOf(paramatmo.allowMemberKick));
    paramContentValues.put("allowMemberAtAll", Integer.valueOf(paramatmo.allowMemberAtAll));
    paramContentValues.put("oldTroopName", paramatmo.oldTroopName);
    paramContentValues.put("hlGuildAppid", Long.valueOf(paramatmo.hlGuildAppid));
    paramContentValues.put("hlGuildSubType", Long.valueOf(paramatmo.hlGuildSubType));
    paramContentValues.put("hlGuildOrgid", Integer.valueOf(paramatmo.hlGuildOrgid));
    paramContentValues.put("hlGuildBinary", Integer.valueOf(paramatmo.hlGuildBinary));
    paramContentValues.put("gameSwitchStatus", Integer.valueOf(paramatmo.gameSwitchStatus));
    paramContentValues.put("showGameSwitchStatus", Integer.valueOf(paramatmo.showGameSwitchStatus));
    paramContentValues.put("lastShareLbsMsgUniseq", Long.valueOf(paramatmo.lastShareLbsMsgUniseq));
    paramContentValues.put("mTroopNeedPayNumber", Float.valueOf(paramatmo.mTroopNeedPayNumber));
    paramContentValues.put("troopCreditLevel", Long.valueOf(paramatmo.troopCreditLevel));
    paramContentValues.put("troopCreditLevelInfo", Long.valueOf(paramatmo.troopCreditLevelInfo));
    paramContentValues.put("dwAppPrivilegeFlag", Long.valueOf(paramatmo.dwAppPrivilegeFlag));
    paramContentValues.put("topicId", paramatmo.topicId);
    paramContentValues.put("associatePubAccount", Long.valueOf(paramatmo.associatePubAccount));
    paramContentValues.put("mTroopFileVideoReqInterval", Long.valueOf(paramatmo.mTroopFileVideoReqInterval));
    paramContentValues.put("mTroopFileVideoIsWhite", Integer.valueOf(paramatmo.mTroopFileVideoIsWhite));
    paramContentValues.put("mTribeStatus", Integer.valueOf(paramatmo.mTribeStatus));
    paramContentValues.put("mCanSearchByKeywords", Boolean.valueOf(paramatmo.mCanSearchByKeywords));
    paramContentValues.put("mCanSearchByTroopUin", Boolean.valueOf(paramatmo.mCanSearchByTroopUin));
    paramContentValues.put("dwCmdUinJoinTime", Long.valueOf(paramatmo.dwCmdUinJoinTime));
    paramContentValues.put("dwLastInsertBAFTipTime", Long.valueOf(paramatmo.dwLastInsertBAFTipTime));
    paramContentValues.put("wInsertBAFTipCount", Integer.valueOf(paramatmo.wInsertBAFTipCount));
    paramContentValues.put("wClickBAFTipCount", Integer.valueOf(paramatmo.wClickBAFTipCount));
    paramContentValues.put("dwLastBAFTipMsgUniSeq", Long.valueOf(paramatmo.dwLastBAFTipMsgUniSeq));
    paramContentValues.put("dwLastBAFTipMsgUniSeq2", Long.valueOf(paramatmo.dwLastBAFTipMsgUniSeq2));
    paramContentValues.put("dailyNewMemberUins", paramatmo.dailyNewMemberUins);
    paramContentValues.put("exitTroopReason", Integer.valueOf(paramatmo.exitTroopReason));
    paramContentValues.put("eliminated", Integer.valueOf(paramatmo.eliminated));
    paramContentValues.put("mIsFreezed", Integer.valueOf(paramatmo.mIsFreezed));
    paramContentValues.put("strLastAnnouncement", paramatmo.strLastAnnouncement);
    paramContentValues.put("nMsgLimitFreq", Integer.valueOf(paramatmo.nMsgLimitFreq));
    paramContentValues.put("mAtOrReplyMeUins", paramatmo.mAtOrReplyMeUins);
    paramContentValues.put("groupFlagExt4", Integer.valueOf(paramatmo.groupFlagExt4));
    paramContentValues.put("groupFreezeReason", Integer.valueOf(paramatmo.groupFreezeReason));
    paramContentValues.put("troopHonorGrayFlag", Integer.valueOf(paramatmo.troopHonorGrayFlag));
    paramContentValues.put("isAllowHistoryMsgFlag", Integer.valueOf(paramatmo.isAllowHistoryMsgFlag));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atns
 * JD-Core Version:    0.7.0.1
 */