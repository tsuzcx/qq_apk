import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class azon
  extends OGAbstractDao
{
  public azon()
  {
    this.columnLen = 57;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (TroopMemberInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
      paramEntity.memberuin = paramCursor.getString(paramCursor.getColumnIndex("memberuin"));
      paramEntity.friendnick = paramCursor.getString(paramCursor.getColumnIndex("friendnick"));
      paramEntity.pyAll_friendnick = paramCursor.getString(paramCursor.getColumnIndex("pyAll_friendnick"));
      paramEntity.pyFirst_friendnick = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_friendnick"));
      paramEntity.troopnick = paramCursor.getString(paramCursor.getColumnIndex("troopnick"));
      paramEntity.troopColorNick = paramCursor.getString(paramCursor.getColumnIndex("troopColorNick"));
      paramEntity.pyAll_troopnick = paramCursor.getString(paramCursor.getColumnIndex("pyAll_troopnick"));
      paramEntity.pyFirst_troopnick = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_troopnick"));
      paramEntity.autoremark = paramCursor.getString(paramCursor.getColumnIndex("autoremark"));
      paramEntity.pyAll_autoremark = paramCursor.getString(paramCursor.getColumnIndex("pyAll_autoremark"));
      paramEntity.pyFirst_autoremark = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_autoremark"));
      paramEntity.troopremark = paramCursor.getString(paramCursor.getColumnIndex("troopremark"));
      paramEntity.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
      paramEntity.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
      paramEntity.faceid = paramCursor.getShort(paramCursor.getColumnIndex("faceid"));
      paramEntity.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramEntity.sex = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sex")));
      paramEntity.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("status")));
      paramEntity.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
      paramEntity.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
      paramEntity.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
      paramEntity.level = paramCursor.getInt(paramCursor.getColumnIndex("level"));
      paramEntity.realLevel = paramCursor.getInt(paramCursor.getColumnIndex("realLevel"));
      paramEntity.newRealLevel = paramCursor.getInt(paramCursor.getColumnIndex("newRealLevel"));
      paramEntity.mGlamourLevel = paramCursor.getInt(paramCursor.getColumnIndex("mGlamourLevel"));
      paramEntity.hotChatGlamourLevel = paramCursor.getInt(paramCursor.getColumnIndex("hotChatGlamourLevel"));
      paramEntity.globalTroopLevel = paramCursor.getInt(paramCursor.getColumnIndex("globalTroopLevel"));
      paramEntity.join_time = paramCursor.getLong(paramCursor.getColumnIndex("join_time"));
      paramEntity.last_active_time = paramCursor.getLong(paramCursor.getColumnIndex("last_active_time"));
      paramEntity.active_point = paramCursor.getLong(paramCursor.getColumnIndex("active_point"));
      paramEntity.credit_level = paramCursor.getLong(paramCursor.getColumnIndex("credit_level"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isTroopFollowed")))
      {
        paramBoolean = true;
        paramEntity.isTroopFollowed = paramBoolean;
        paramEntity.distance = paramCursor.getInt(paramCursor.getColumnIndex("distance"));
        paramEntity.msgseq = paramCursor.getLong(paramCursor.getColumnIndex("msgseq"));
        paramEntity.gagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("gagTimeStamp"));
        paramEntity.distanceToSelf = paramCursor.getDouble(paramCursor.getColumnIndex("distanceToSelf"));
        paramEntity.distanceToSelfUpdateTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("distanceToSelfUpdateTimeStamp"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mIsShielded"))) {
          break label1072;
        }
      }
      label1072:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.mIsShielded = paramBoolean;
        paramEntity.mUniqueTitle = paramCursor.getString(paramCursor.getColumnIndex("mUniqueTitle"));
        paramEntity.mUniqueTitleExpire = paramCursor.getInt(paramCursor.getColumnIndex("mUniqueTitleExpire"));
        paramEntity.tribeLevel = paramCursor.getInt(paramCursor.getColumnIndex("tribeLevel"));
        paramEntity.tribePoint = paramCursor.getInt(paramCursor.getColumnIndex("tribePoint"));
        paramEntity.commonFrdCnt = paramCursor.getInt(paramCursor.getColumnIndex("commonFrdCnt"));
        paramEntity.hwIdentity = paramCursor.getInt(paramCursor.getColumnIndex("hwIdentity"));
        paramEntity.hwCourse = paramCursor.getString(paramCursor.getColumnIndex("hwCourse"));
        paramEntity.hwName = paramCursor.getString(paramCursor.getColumnIndex("hwName"));
        paramEntity.mVipType = paramCursor.getInt(paramCursor.getColumnIndex("mVipType"));
        paramEntity.mVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("mVipLevel"));
        paramEntity.mVipTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("mVipTemplateId"));
        paramEntity.mBigClubVipType = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubVipType"));
        paramEntity.mBigClubVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubVipLevel"));
        paramEntity.mBigClubTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubTemplateId"));
        paramEntity.recommendRemark = paramCursor.getString(paramCursor.getColumnIndex("recommendRemark"));
        paramEntity.isShowQZone = paramCursor.getInt(paramCursor.getColumnIndex("isShowQZone"));
        paramEntity.mIsHideBigClub = paramCursor.getInt(paramCursor.getColumnIndex("mIsHideBigClub"));
        paramEntity.honorList = paramCursor.getString(paramCursor.getColumnIndex("honorList"));
        return paramEntity;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("troopuin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopuin", String.class));
      i = paramCursor.getColumnIndex("memberuin");
      if (i != -1) {
        break label3099;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("memberuin", String.class));
      label1147:
      i = paramCursor.getColumnIndex("friendnick");
      if (i != -1) {
        break label3114;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("friendnick", String.class));
      label1182:
      i = paramCursor.getColumnIndex("pyAll_friendnick");
      if (i != -1) {
        break label3129;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pyAll_friendnick", String.class));
      label1217:
      i = paramCursor.getColumnIndex("pyFirst_friendnick");
      if (i != -1) {
        break label3144;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pyFirst_friendnick", String.class));
      label1252:
      i = paramCursor.getColumnIndex("troopnick");
      if (i != -1) {
        break label3159;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopnick", String.class));
      label1287:
      i = paramCursor.getColumnIndex("troopColorNick");
      if (i != -1) {
        break label3174;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopColorNick", String.class));
      label1322:
      i = paramCursor.getColumnIndex("pyAll_troopnick");
      if (i != -1) {
        break label3189;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pyAll_troopnick", String.class));
      label1357:
      i = paramCursor.getColumnIndex("pyFirst_troopnick");
      if (i != -1) {
        break label3204;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pyFirst_troopnick", String.class));
      label1392:
      i = paramCursor.getColumnIndex("autoremark");
      if (i != -1) {
        break label3219;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("autoremark", String.class));
      label1427:
      i = paramCursor.getColumnIndex("pyAll_autoremark");
      if (i != -1) {
        break label3234;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pyAll_autoremark", String.class));
      label1462:
      i = paramCursor.getColumnIndex("pyFirst_autoremark");
      if (i != -1) {
        break label3249;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pyFirst_autoremark", String.class));
      label1497:
      i = paramCursor.getColumnIndex("troopremark");
      if (i != -1) {
        break label3264;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopremark", String.class));
      label1532:
      i = paramCursor.getColumnIndex("alias");
      if (i != -1) {
        break label3279;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("alias", String.class));
      label1567:
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label3294;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("datetime", Long.TYPE));
      label1602:
      i = paramCursor.getColumnIndex("faceid");
      if (i != -1) {
        break label3309;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceid", Short.TYPE));
      label1637:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label3324;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("age", Byte.TYPE));
      label1672:
      i = paramCursor.getColumnIndex("sex");
      if (i != -1) {
        break label3340;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sex", Byte.TYPE));
      label1707:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label3356;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("status", Byte.TYPE));
      label1742:
      i = paramCursor.getColumnIndex("qqVipInfo");
      if (i != -1) {
        break label3372;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qqVipInfo", Integer.TYPE));
      label1777:
      i = paramCursor.getColumnIndex("superQqInfo");
      if (i != -1) {
        break label3387;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("superQqInfo", Integer.TYPE));
      label1812:
      i = paramCursor.getColumnIndex("superVipInfo");
      if (i != -1) {
        break label3402;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("superVipInfo", Integer.TYPE));
      label1847:
      i = paramCursor.getColumnIndex("level");
      if (i != -1) {
        break label3417;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("level", Integer.TYPE));
      label1882:
      i = paramCursor.getColumnIndex("realLevel");
      if (i != -1) {
        break label3432;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("realLevel", Integer.TYPE));
      label1917:
      i = paramCursor.getColumnIndex("newRealLevel");
      if (i != -1) {
        break label3447;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("newRealLevel", Integer.TYPE));
      label1952:
      i = paramCursor.getColumnIndex("mGlamourLevel");
      if (i != -1) {
        break label3462;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mGlamourLevel", Integer.TYPE));
      label1987:
      i = paramCursor.getColumnIndex("hotChatGlamourLevel");
      if (i != -1) {
        break label3477;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hotChatGlamourLevel", Integer.TYPE));
      label2022:
      i = paramCursor.getColumnIndex("globalTroopLevel");
      if (i != -1) {
        break label3492;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("globalTroopLevel", Integer.TYPE));
      label2057:
      i = paramCursor.getColumnIndex("join_time");
      if (i != -1) {
        break label3507;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("join_time", Long.TYPE));
      label2092:
      i = paramCursor.getColumnIndex("last_active_time");
      if (i != -1) {
        break label3522;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("last_active_time", Long.TYPE));
      label2127:
      i = paramCursor.getColumnIndex("active_point");
      if (i != -1) {
        break label3537;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("active_point", Long.TYPE));
      label2162:
      i = paramCursor.getColumnIndex("credit_level");
      if (i != -1) {
        break label3552;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("credit_level", Long.TYPE));
      label2197:
      i = paramCursor.getColumnIndex("isTroopFollowed");
      if (i != -1) {
        break label3567;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isTroopFollowed", Boolean.TYPE));
      i = paramCursor.getColumnIndex("distance");
      if (i != -1) {
        break label3594;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("distance", Integer.TYPE));
      label2267:
      i = paramCursor.getColumnIndex("msgseq");
      if (i != -1) {
        break label3609;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("msgseq", Long.TYPE));
      label2302:
      i = paramCursor.getColumnIndex("gagTimeStamp");
      if (i != -1) {
        break label3624;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("gagTimeStamp", Long.TYPE));
      label2337:
      i = paramCursor.getColumnIndex("distanceToSelf");
      if (i != -1) {
        break label3639;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("distanceToSelf", Double.TYPE));
      label2372:
      i = paramCursor.getColumnIndex("distanceToSelfUpdateTimeStamp");
      if (i != -1) {
        break label3654;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("distanceToSelfUpdateTimeStamp", Long.TYPE));
      label2407:
      i = paramCursor.getColumnIndex("mIsShielded");
      if (i != -1) {
        break label3669;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mIsShielded", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mUniqueTitle");
      if (i != -1) {
        break label3697;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mUniqueTitle", String.class));
      label2477:
      i = paramCursor.getColumnIndex("mUniqueTitleExpire");
      if (i != -1) {
        break label3712;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mUniqueTitleExpire", Integer.TYPE));
      label2512:
      i = paramCursor.getColumnIndex("tribeLevel");
      if (i != -1) {
        break label3727;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tribeLevel", Integer.TYPE));
      label2547:
      i = paramCursor.getColumnIndex("tribePoint");
      if (i != -1) {
        break label3742;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tribePoint", Integer.TYPE));
      label2582:
      i = paramCursor.getColumnIndex("commonFrdCnt");
      if (i != -1) {
        break label3757;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("commonFrdCnt", Integer.TYPE));
      label2617:
      i = paramCursor.getColumnIndex("hwIdentity");
      if (i != -1) {
        break label3772;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hwIdentity", Integer.TYPE));
      label2652:
      i = paramCursor.getColumnIndex("hwCourse");
      if (i != -1) {
        break label3787;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hwCourse", String.class));
      label2687:
      i = paramCursor.getColumnIndex("hwName");
      if (i != -1) {
        break label3802;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hwName", String.class));
      label2722:
      i = paramCursor.getColumnIndex("mVipType");
      if (i != -1) {
        break label3817;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mVipType", Integer.TYPE));
      label2757:
      i = paramCursor.getColumnIndex("mVipLevel");
      if (i != -1) {
        break label3832;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mVipLevel", Integer.TYPE));
      label2792:
      i = paramCursor.getColumnIndex("mVipTemplateId");
      if (i != -1) {
        break label3847;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mVipTemplateId", Integer.TYPE));
      label2827:
      i = paramCursor.getColumnIndex("mBigClubVipType");
      if (i != -1) {
        break label3862;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mBigClubVipType", Integer.TYPE));
      label2862:
      i = paramCursor.getColumnIndex("mBigClubVipLevel");
      if (i != -1) {
        break label3877;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mBigClubVipLevel", Integer.TYPE));
      label2897:
      i = paramCursor.getColumnIndex("mBigClubTemplateId");
      if (i != -1) {
        break label3892;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mBigClubTemplateId", Integer.TYPE));
      label2934:
      i = paramCursor.getColumnIndex("recommendRemark");
      if (i != -1) {
        break label3907;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("recommendRemark", String.class));
      label2971:
      i = paramCursor.getColumnIndex("isShowQZone");
      if (i != -1) {
        break label3922;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isShowQZone", Integer.TYPE));
      label3008:
      i = paramCursor.getColumnIndex("mIsHideBigClub");
      if (i != -1) {
        break label3937;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mIsHideBigClub", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("honorList");
      if (i != -1) {
        break label3952;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("honorList", String.class));
      return paramEntity;
      paramEntity.troopuin = paramCursor.getString(i);
      break;
      label3099:
      paramEntity.memberuin = paramCursor.getString(i);
      break label1147;
      label3114:
      paramEntity.friendnick = paramCursor.getString(i);
      break label1182;
      label3129:
      paramEntity.pyAll_friendnick = paramCursor.getString(i);
      break label1217;
      label3144:
      paramEntity.pyFirst_friendnick = paramCursor.getString(i);
      break label1252;
      label3159:
      paramEntity.troopnick = paramCursor.getString(i);
      break label1287;
      label3174:
      paramEntity.troopColorNick = paramCursor.getString(i);
      break label1322;
      label3189:
      paramEntity.pyAll_troopnick = paramCursor.getString(i);
      break label1357;
      label3204:
      paramEntity.pyFirst_troopnick = paramCursor.getString(i);
      break label1392;
      label3219:
      paramEntity.autoremark = paramCursor.getString(i);
      break label1427;
      label3234:
      paramEntity.pyAll_autoremark = paramCursor.getString(i);
      break label1462;
      label3249:
      paramEntity.pyFirst_autoremark = paramCursor.getString(i);
      break label1497;
      label3264:
      paramEntity.troopremark = paramCursor.getString(i);
      break label1532;
      label3279:
      paramEntity.alias = paramCursor.getString(i);
      break label1567;
      label3294:
      paramEntity.datetime = paramCursor.getLong(i);
      break label1602;
      label3309:
      paramEntity.faceid = paramCursor.getShort(i);
      break label1637;
      label3324:
      paramEntity.age = ((byte)paramCursor.getShort(i));
      break label1672;
      label3340:
      paramEntity.sex = ((byte)paramCursor.getShort(i));
      break label1707;
      label3356:
      paramEntity.status = ((byte)paramCursor.getShort(i));
      break label1742;
      label3372:
      paramEntity.qqVipInfo = paramCursor.getInt(i);
      break label1777;
      label3387:
      paramEntity.superQqInfo = paramCursor.getInt(i);
      break label1812;
      label3402:
      paramEntity.superVipInfo = paramCursor.getInt(i);
      break label1847;
      label3417:
      paramEntity.level = paramCursor.getInt(i);
      break label1882;
      label3432:
      paramEntity.realLevel = paramCursor.getInt(i);
      break label1917;
      label3447:
      paramEntity.newRealLevel = paramCursor.getInt(i);
      break label1952;
      label3462:
      paramEntity.mGlamourLevel = paramCursor.getInt(i);
      break label1987;
      label3477:
      paramEntity.hotChatGlamourLevel = paramCursor.getInt(i);
      break label2022;
      label3492:
      paramEntity.globalTroopLevel = paramCursor.getInt(i);
      break label2057;
      label3507:
      paramEntity.join_time = paramCursor.getLong(i);
      break label2092;
      label3522:
      paramEntity.last_active_time = paramCursor.getLong(i);
      break label2127;
      label3537:
      paramEntity.active_point = paramCursor.getLong(i);
      break label2162;
      label3552:
      paramEntity.credit_level = paramCursor.getLong(i);
      break label2197;
      label3567:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isTroopFollowed = paramBoolean;
        break;
      }
      label3594:
      paramEntity.distance = paramCursor.getInt(i);
      break label2267;
      label3609:
      paramEntity.msgseq = paramCursor.getLong(i);
      break label2302;
      label3624:
      paramEntity.gagTimeStamp = paramCursor.getLong(i);
      break label2337;
      label3639:
      paramEntity.distanceToSelf = paramCursor.getDouble(i);
      break label2372;
      label3654:
      paramEntity.distanceToSelfUpdateTimeStamp = paramCursor.getLong(i);
      break label2407;
      label3669:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.mIsShielded = paramBoolean;
        break;
      }
      label3697:
      paramEntity.mUniqueTitle = paramCursor.getString(i);
      break label2477;
      label3712:
      paramEntity.mUniqueTitleExpire = paramCursor.getInt(i);
      break label2512;
      label3727:
      paramEntity.tribeLevel = paramCursor.getInt(i);
      break label2547;
      label3742:
      paramEntity.tribePoint = paramCursor.getInt(i);
      break label2582;
      label3757:
      paramEntity.commonFrdCnt = paramCursor.getInt(i);
      break label2617;
      label3772:
      paramEntity.hwIdentity = paramCursor.getInt(i);
      break label2652;
      label3787:
      paramEntity.hwCourse = paramCursor.getString(i);
      break label2687;
      label3802:
      paramEntity.hwName = paramCursor.getString(i);
      break label2722;
      label3817:
      paramEntity.mVipType = paramCursor.getInt(i);
      break label2757;
      label3832:
      paramEntity.mVipLevel = paramCursor.getInt(i);
      break label2792;
      label3847:
      paramEntity.mVipTemplateId = paramCursor.getInt(i);
      break label2827;
      label3862:
      paramEntity.mBigClubVipType = paramCursor.getInt(i);
      break label2862;
      label3877:
      paramEntity.mBigClubVipLevel = paramCursor.getInt(i);
      break label2897;
      label3892:
      paramEntity.mBigClubTemplateId = paramCursor.getInt(i);
      break label2934;
      label3907:
      paramEntity.recommendRemark = paramCursor.getString(i);
      break label2971;
      label3922:
      paramEntity.isShowQZone = paramCursor.getInt(i);
      break label3008;
      label3937:
      paramEntity.mIsHideBigClub = paramCursor.getInt(i);
    }
    label3952:
    paramEntity.honorList = paramCursor.getString(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (TroopMemberInfo)paramEntity;
    paramContentValues.put("troopuin", paramEntity.troopuin);
    paramContentValues.put("memberuin", paramEntity.memberuin);
    paramContentValues.put("friendnick", paramEntity.friendnick);
    paramContentValues.put("pyAll_friendnick", paramEntity.pyAll_friendnick);
    paramContentValues.put("pyFirst_friendnick", paramEntity.pyFirst_friendnick);
    paramContentValues.put("troopnick", paramEntity.troopnick);
    paramContentValues.put("troopColorNick", paramEntity.troopColorNick);
    paramContentValues.put("pyAll_troopnick", paramEntity.pyAll_troopnick);
    paramContentValues.put("pyFirst_troopnick", paramEntity.pyFirst_troopnick);
    paramContentValues.put("autoremark", paramEntity.autoremark);
    paramContentValues.put("pyAll_autoremark", paramEntity.pyAll_autoremark);
    paramContentValues.put("pyFirst_autoremark", paramEntity.pyFirst_autoremark);
    paramContentValues.put("troopremark", paramEntity.troopremark);
    paramContentValues.put("alias", paramEntity.alias);
    paramContentValues.put("datetime", Long.valueOf(paramEntity.datetime));
    paramContentValues.put("faceid", Short.valueOf(paramEntity.faceid));
    paramContentValues.put("age", Byte.valueOf(paramEntity.age));
    paramContentValues.put("sex", Byte.valueOf(paramEntity.sex));
    paramContentValues.put("status", Byte.valueOf(paramEntity.status));
    paramContentValues.put("qqVipInfo", Integer.valueOf(paramEntity.qqVipInfo));
    paramContentValues.put("superQqInfo", Integer.valueOf(paramEntity.superQqInfo));
    paramContentValues.put("superVipInfo", Integer.valueOf(paramEntity.superVipInfo));
    paramContentValues.put("level", Integer.valueOf(paramEntity.level));
    paramContentValues.put("realLevel", Integer.valueOf(paramEntity.realLevel));
    paramContentValues.put("newRealLevel", Integer.valueOf(paramEntity.newRealLevel));
    paramContentValues.put("mGlamourLevel", Integer.valueOf(paramEntity.mGlamourLevel));
    paramContentValues.put("hotChatGlamourLevel", Integer.valueOf(paramEntity.hotChatGlamourLevel));
    paramContentValues.put("globalTroopLevel", Integer.valueOf(paramEntity.globalTroopLevel));
    paramContentValues.put("join_time", Long.valueOf(paramEntity.join_time));
    paramContentValues.put("last_active_time", Long.valueOf(paramEntity.last_active_time));
    paramContentValues.put("active_point", Long.valueOf(paramEntity.active_point));
    paramContentValues.put("credit_level", Long.valueOf(paramEntity.credit_level));
    paramContentValues.put("isTroopFollowed", Boolean.valueOf(paramEntity.isTroopFollowed));
    paramContentValues.put("distance", Integer.valueOf(paramEntity.distance));
    paramContentValues.put("msgseq", Long.valueOf(paramEntity.msgseq));
    paramContentValues.put("gagTimeStamp", Long.valueOf(paramEntity.gagTimeStamp));
    paramContentValues.put("distanceToSelf", Double.valueOf(paramEntity.distanceToSelf));
    paramContentValues.put("distanceToSelfUpdateTimeStamp", Long.valueOf(paramEntity.distanceToSelfUpdateTimeStamp));
    paramContentValues.put("mIsShielded", Boolean.valueOf(paramEntity.mIsShielded));
    paramContentValues.put("mUniqueTitle", paramEntity.mUniqueTitle);
    paramContentValues.put("mUniqueTitleExpire", Integer.valueOf(paramEntity.mUniqueTitleExpire));
    paramContentValues.put("tribeLevel", Integer.valueOf(paramEntity.tribeLevel));
    paramContentValues.put("tribePoint", Integer.valueOf(paramEntity.tribePoint));
    paramContentValues.put("commonFrdCnt", Integer.valueOf(paramEntity.commonFrdCnt));
    paramContentValues.put("hwIdentity", Integer.valueOf(paramEntity.hwIdentity));
    paramContentValues.put("hwCourse", paramEntity.hwCourse);
    paramContentValues.put("hwName", paramEntity.hwName);
    paramContentValues.put("mVipType", Integer.valueOf(paramEntity.mVipType));
    paramContentValues.put("mVipLevel", Integer.valueOf(paramEntity.mVipLevel));
    paramContentValues.put("mVipTemplateId", Integer.valueOf(paramEntity.mVipTemplateId));
    paramContentValues.put("mBigClubVipType", Integer.valueOf(paramEntity.mBigClubVipType));
    paramContentValues.put("mBigClubVipLevel", Integer.valueOf(paramEntity.mBigClubVipLevel));
    paramContentValues.put("mBigClubTemplateId", Integer.valueOf(paramEntity.mBigClubTemplateId));
    paramContentValues.put("recommendRemark", paramEntity.recommendRemark);
    paramContentValues.put("isShowQZone", Integer.valueOf(paramEntity.isShowQZone));
    paramContentValues.put("mIsHideBigClub", Integer.valueOf(paramEntity.mIsHideBigClub));
    paramContentValues.put("honorList", paramEntity.honorList);
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopuin TEXT ,memberuin TEXT ,friendnick TEXT ,pyAll_friendnick TEXT ,pyFirst_friendnick TEXT ,troopnick TEXT ,troopColorNick TEXT ,pyAll_troopnick TEXT ,pyFirst_troopnick TEXT ,autoremark TEXT ,pyAll_autoremark TEXT ,pyFirst_autoremark TEXT ,troopremark TEXT ,alias TEXT ,datetime INTEGER ,faceid INTEGER ,age INTEGER ,sex INTEGER ,status INTEGER ,qqVipInfo INTEGER ,superQqInfo INTEGER ,superVipInfo INTEGER ,level INTEGER ,realLevel INTEGER ,newRealLevel INTEGER ,mGlamourLevel INTEGER ,hotChatGlamourLevel INTEGER ,globalTroopLevel INTEGER ,join_time INTEGER ,last_active_time INTEGER ,active_point INTEGER ,credit_level INTEGER ,isTroopFollowed INTEGER ,distance INTEGER ,msgseq INTEGER ,gagTimeStamp INTEGER ,distanceToSelf REAL ,distanceToSelfUpdateTimeStamp INTEGER ,mIsShielded INTEGER ,mUniqueTitle TEXT ,mUniqueTitleExpire INTEGER ,tribeLevel INTEGER ,tribePoint INTEGER ,commonFrdCnt INTEGER ,hwIdentity INTEGER ,hwCourse TEXT ,hwName TEXT ,mVipType INTEGER ,mVipLevel INTEGER ,mVipTemplateId INTEGER ,mBigClubVipType INTEGER ,mBigClubVipLevel INTEGER ,mBigClubTemplateId INTEGER ,recommendRemark TEXT ,isShowQZone INTEGER ,mIsHideBigClub INTEGER ,honorList TEXT,UNIQUE(troopuin,memberuin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azon
 * JD-Core Version:    0.7.0.1
 */