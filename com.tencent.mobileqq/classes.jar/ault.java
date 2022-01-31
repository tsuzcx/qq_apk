import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class ault
  extends aula
{
  public ault()
  {
    this.a = 56;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramauko = (TroopMemberInfo)paramauko;
    if (paramaukz == null)
    {
      paramauko.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
      paramauko.memberuin = paramCursor.getString(paramCursor.getColumnIndex("memberuin"));
      paramauko.friendnick = paramCursor.getString(paramCursor.getColumnIndex("friendnick"));
      paramauko.pyAll_friendnick = paramCursor.getString(paramCursor.getColumnIndex("pyAll_friendnick"));
      paramauko.pyFirst_friendnick = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_friendnick"));
      paramauko.troopnick = paramCursor.getString(paramCursor.getColumnIndex("troopnick"));
      paramauko.troopColorNick = paramCursor.getString(paramCursor.getColumnIndex("troopColorNick"));
      paramauko.pyAll_troopnick = paramCursor.getString(paramCursor.getColumnIndex("pyAll_troopnick"));
      paramauko.pyFirst_troopnick = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_troopnick"));
      paramauko.autoremark = paramCursor.getString(paramCursor.getColumnIndex("autoremark"));
      paramauko.pyAll_autoremark = paramCursor.getString(paramCursor.getColumnIndex("pyAll_autoremark"));
      paramauko.pyFirst_autoremark = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_autoremark"));
      paramauko.troopremark = paramCursor.getString(paramCursor.getColumnIndex("troopremark"));
      paramauko.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
      paramauko.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
      paramauko.faceid = paramCursor.getShort(paramCursor.getColumnIndex("faceid"));
      paramauko.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramauko.sex = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sex")));
      paramauko.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("status")));
      paramauko.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
      paramauko.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
      paramauko.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
      paramauko.level = paramCursor.getInt(paramCursor.getColumnIndex("level"));
      paramauko.realLevel = paramCursor.getInt(paramCursor.getColumnIndex("realLevel"));
      paramauko.mGlamourLevel = paramCursor.getInt(paramCursor.getColumnIndex("mGlamourLevel"));
      paramauko.hotChatGlamourLevel = paramCursor.getInt(paramCursor.getColumnIndex("hotChatGlamourLevel"));
      paramauko.globalTroopLevel = paramCursor.getInt(paramCursor.getColumnIndex("globalTroopLevel"));
      paramauko.join_time = paramCursor.getLong(paramCursor.getColumnIndex("join_time"));
      paramauko.last_active_time = paramCursor.getLong(paramCursor.getColumnIndex("last_active_time"));
      paramauko.active_point = paramCursor.getLong(paramCursor.getColumnIndex("active_point"));
      paramauko.credit_level = paramCursor.getLong(paramCursor.getColumnIndex("credit_level"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isTroopFollowed")))
      {
        paramBoolean = true;
        paramauko.isTroopFollowed = paramBoolean;
        paramauko.distance = paramCursor.getInt(paramCursor.getColumnIndex("distance"));
        paramauko.msgseq = paramCursor.getLong(paramCursor.getColumnIndex("msgseq"));
        paramauko.gagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("gagTimeStamp"));
        paramauko.distanceToSelf = paramCursor.getDouble(paramCursor.getColumnIndex("distanceToSelf"));
        paramauko.distanceToSelfUpdateTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("distanceToSelfUpdateTimeStamp"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mIsShielded"))) {
          break label1053;
        }
      }
      label1053:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramauko.mIsShielded = paramBoolean;
        paramauko.mUniqueTitle = paramCursor.getString(paramCursor.getColumnIndex("mUniqueTitle"));
        paramauko.mUniqueTitleExpire = paramCursor.getInt(paramCursor.getColumnIndex("mUniqueTitleExpire"));
        paramauko.tribeLevel = paramCursor.getInt(paramCursor.getColumnIndex("tribeLevel"));
        paramauko.tribePoint = paramCursor.getInt(paramCursor.getColumnIndex("tribePoint"));
        paramauko.commonFrdCnt = paramCursor.getInt(paramCursor.getColumnIndex("commonFrdCnt"));
        paramauko.hwIdentity = paramCursor.getInt(paramCursor.getColumnIndex("hwIdentity"));
        paramauko.hwCourse = paramCursor.getString(paramCursor.getColumnIndex("hwCourse"));
        paramauko.hwName = paramCursor.getString(paramCursor.getColumnIndex("hwName"));
        paramauko.mVipType = paramCursor.getInt(paramCursor.getColumnIndex("mVipType"));
        paramauko.mVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("mVipLevel"));
        paramauko.mVipTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("mVipTemplateId"));
        paramauko.mBigClubVipType = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubVipType"));
        paramauko.mBigClubVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubVipLevel"));
        paramauko.mBigClubTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubTemplateId"));
        paramauko.recommendRemark = paramCursor.getString(paramCursor.getColumnIndex("recommendRemark"));
        paramauko.isShowQZone = paramCursor.getInt(paramCursor.getColumnIndex("isShowQZone"));
        paramauko.mIsHideBigClub = paramCursor.getInt(paramCursor.getColumnIndex("mIsHideBigClub"));
        paramauko.honorList = paramCursor.getString(paramCursor.getColumnIndex("honorList"));
        return paramauko;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("troopuin");
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("troopuin", String.class));
      i = paramCursor.getColumnIndex("memberuin");
      if (i != -1) {
        break label3043;
      }
      paramaukz.a(new NoColumnError("memberuin", String.class));
      label1128:
      i = paramCursor.getColumnIndex("friendnick");
      if (i != -1) {
        break label3058;
      }
      paramaukz.a(new NoColumnError("friendnick", String.class));
      label1163:
      i = paramCursor.getColumnIndex("pyAll_friendnick");
      if (i != -1) {
        break label3073;
      }
      paramaukz.a(new NoColumnError("pyAll_friendnick", String.class));
      label1198:
      i = paramCursor.getColumnIndex("pyFirst_friendnick");
      if (i != -1) {
        break label3088;
      }
      paramaukz.a(new NoColumnError("pyFirst_friendnick", String.class));
      label1233:
      i = paramCursor.getColumnIndex("troopnick");
      if (i != -1) {
        break label3103;
      }
      paramaukz.a(new NoColumnError("troopnick", String.class));
      label1268:
      i = paramCursor.getColumnIndex("troopColorNick");
      if (i != -1) {
        break label3118;
      }
      paramaukz.a(new NoColumnError("troopColorNick", String.class));
      label1303:
      i = paramCursor.getColumnIndex("pyAll_troopnick");
      if (i != -1) {
        break label3133;
      }
      paramaukz.a(new NoColumnError("pyAll_troopnick", String.class));
      label1338:
      i = paramCursor.getColumnIndex("pyFirst_troopnick");
      if (i != -1) {
        break label3148;
      }
      paramaukz.a(new NoColumnError("pyFirst_troopnick", String.class));
      label1373:
      i = paramCursor.getColumnIndex("autoremark");
      if (i != -1) {
        break label3163;
      }
      paramaukz.a(new NoColumnError("autoremark", String.class));
      label1408:
      i = paramCursor.getColumnIndex("pyAll_autoremark");
      if (i != -1) {
        break label3178;
      }
      paramaukz.a(new NoColumnError("pyAll_autoremark", String.class));
      label1443:
      i = paramCursor.getColumnIndex("pyFirst_autoremark");
      if (i != -1) {
        break label3193;
      }
      paramaukz.a(new NoColumnError("pyFirst_autoremark", String.class));
      label1478:
      i = paramCursor.getColumnIndex("troopremark");
      if (i != -1) {
        break label3208;
      }
      paramaukz.a(new NoColumnError("troopremark", String.class));
      label1513:
      i = paramCursor.getColumnIndex("alias");
      if (i != -1) {
        break label3223;
      }
      paramaukz.a(new NoColumnError("alias", String.class));
      label1548:
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label3238;
      }
      paramaukz.a(new NoColumnError("datetime", Long.TYPE));
      label1583:
      i = paramCursor.getColumnIndex("faceid");
      if (i != -1) {
        break label3253;
      }
      paramaukz.a(new NoColumnError("faceid", Short.TYPE));
      label1618:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label3268;
      }
      paramaukz.a(new NoColumnError("age", Byte.TYPE));
      label1653:
      i = paramCursor.getColumnIndex("sex");
      if (i != -1) {
        break label3284;
      }
      paramaukz.a(new NoColumnError("sex", Byte.TYPE));
      label1688:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label3300;
      }
      paramaukz.a(new NoColumnError("status", Byte.TYPE));
      label1723:
      i = paramCursor.getColumnIndex("qqVipInfo");
      if (i != -1) {
        break label3316;
      }
      paramaukz.a(new NoColumnError("qqVipInfo", Integer.TYPE));
      label1758:
      i = paramCursor.getColumnIndex("superQqInfo");
      if (i != -1) {
        break label3331;
      }
      paramaukz.a(new NoColumnError("superQqInfo", Integer.TYPE));
      label1793:
      i = paramCursor.getColumnIndex("superVipInfo");
      if (i != -1) {
        break label3346;
      }
      paramaukz.a(new NoColumnError("superVipInfo", Integer.TYPE));
      label1828:
      i = paramCursor.getColumnIndex("level");
      if (i != -1) {
        break label3361;
      }
      paramaukz.a(new NoColumnError("level", Integer.TYPE));
      label1863:
      i = paramCursor.getColumnIndex("realLevel");
      if (i != -1) {
        break label3376;
      }
      paramaukz.a(new NoColumnError("realLevel", Integer.TYPE));
      label1898:
      i = paramCursor.getColumnIndex("mGlamourLevel");
      if (i != -1) {
        break label3391;
      }
      paramaukz.a(new NoColumnError("mGlamourLevel", Integer.TYPE));
      label1933:
      i = paramCursor.getColumnIndex("hotChatGlamourLevel");
      if (i != -1) {
        break label3406;
      }
      paramaukz.a(new NoColumnError("hotChatGlamourLevel", Integer.TYPE));
      label1968:
      i = paramCursor.getColumnIndex("globalTroopLevel");
      if (i != -1) {
        break label3421;
      }
      paramaukz.a(new NoColumnError("globalTroopLevel", Integer.TYPE));
      label2003:
      i = paramCursor.getColumnIndex("join_time");
      if (i != -1) {
        break label3436;
      }
      paramaukz.a(new NoColumnError("join_time", Long.TYPE));
      label2038:
      i = paramCursor.getColumnIndex("last_active_time");
      if (i != -1) {
        break label3451;
      }
      paramaukz.a(new NoColumnError("last_active_time", Long.TYPE));
      label2073:
      i = paramCursor.getColumnIndex("active_point");
      if (i != -1) {
        break label3466;
      }
      paramaukz.a(new NoColumnError("active_point", Long.TYPE));
      label2108:
      i = paramCursor.getColumnIndex("credit_level");
      if (i != -1) {
        break label3481;
      }
      paramaukz.a(new NoColumnError("credit_level", Long.TYPE));
      label2143:
      i = paramCursor.getColumnIndex("isTroopFollowed");
      if (i != -1) {
        break label3496;
      }
      paramaukz.a(new NoColumnError("isTroopFollowed", Boolean.TYPE));
      i = paramCursor.getColumnIndex("distance");
      if (i != -1) {
        break label3523;
      }
      paramaukz.a(new NoColumnError("distance", Integer.TYPE));
      label2213:
      i = paramCursor.getColumnIndex("msgseq");
      if (i != -1) {
        break label3538;
      }
      paramaukz.a(new NoColumnError("msgseq", Long.TYPE));
      label2248:
      i = paramCursor.getColumnIndex("gagTimeStamp");
      if (i != -1) {
        break label3553;
      }
      paramaukz.a(new NoColumnError("gagTimeStamp", Long.TYPE));
      label2283:
      i = paramCursor.getColumnIndex("distanceToSelf");
      if (i != -1) {
        break label3568;
      }
      paramaukz.a(new NoColumnError("distanceToSelf", Double.TYPE));
      label2318:
      i = paramCursor.getColumnIndex("distanceToSelfUpdateTimeStamp");
      if (i != -1) {
        break label3583;
      }
      paramaukz.a(new NoColumnError("distanceToSelfUpdateTimeStamp", Long.TYPE));
      label2353:
      i = paramCursor.getColumnIndex("mIsShielded");
      if (i != -1) {
        break label3598;
      }
      paramaukz.a(new NoColumnError("mIsShielded", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mUniqueTitle");
      if (i != -1) {
        break label3626;
      }
      paramaukz.a(new NoColumnError("mUniqueTitle", String.class));
      label2423:
      i = paramCursor.getColumnIndex("mUniqueTitleExpire");
      if (i != -1) {
        break label3641;
      }
      paramaukz.a(new NoColumnError("mUniqueTitleExpire", Integer.TYPE));
      label2458:
      i = paramCursor.getColumnIndex("tribeLevel");
      if (i != -1) {
        break label3656;
      }
      paramaukz.a(new NoColumnError("tribeLevel", Integer.TYPE));
      label2493:
      i = paramCursor.getColumnIndex("tribePoint");
      if (i != -1) {
        break label3671;
      }
      paramaukz.a(new NoColumnError("tribePoint", Integer.TYPE));
      label2528:
      i = paramCursor.getColumnIndex("commonFrdCnt");
      if (i != -1) {
        break label3686;
      }
      paramaukz.a(new NoColumnError("commonFrdCnt", Integer.TYPE));
      label2563:
      i = paramCursor.getColumnIndex("hwIdentity");
      if (i != -1) {
        break label3701;
      }
      paramaukz.a(new NoColumnError("hwIdentity", Integer.TYPE));
      label2598:
      i = paramCursor.getColumnIndex("hwCourse");
      if (i != -1) {
        break label3716;
      }
      paramaukz.a(new NoColumnError("hwCourse", String.class));
      label2633:
      i = paramCursor.getColumnIndex("hwName");
      if (i != -1) {
        break label3731;
      }
      paramaukz.a(new NoColumnError("hwName", String.class));
      label2668:
      i = paramCursor.getColumnIndex("mVipType");
      if (i != -1) {
        break label3746;
      }
      paramaukz.a(new NoColumnError("mVipType", Integer.TYPE));
      label2703:
      i = paramCursor.getColumnIndex("mVipLevel");
      if (i != -1) {
        break label3761;
      }
      paramaukz.a(new NoColumnError("mVipLevel", Integer.TYPE));
      label2738:
      i = paramCursor.getColumnIndex("mVipTemplateId");
      if (i != -1) {
        break label3776;
      }
      paramaukz.a(new NoColumnError("mVipTemplateId", Integer.TYPE));
      label2773:
      i = paramCursor.getColumnIndex("mBigClubVipType");
      if (i != -1) {
        break label3791;
      }
      paramaukz.a(new NoColumnError("mBigClubVipType", Integer.TYPE));
      label2808:
      i = paramCursor.getColumnIndex("mBigClubVipLevel");
      if (i != -1) {
        break label3806;
      }
      paramaukz.a(new NoColumnError("mBigClubVipLevel", Integer.TYPE));
      label2843:
      i = paramCursor.getColumnIndex("mBigClubTemplateId");
      if (i != -1) {
        break label3821;
      }
      paramaukz.a(new NoColumnError("mBigClubTemplateId", Integer.TYPE));
      label2878:
      i = paramCursor.getColumnIndex("recommendRemark");
      if (i != -1) {
        break label3836;
      }
      paramaukz.a(new NoColumnError("recommendRemark", String.class));
      label2915:
      i = paramCursor.getColumnIndex("isShowQZone");
      if (i != -1) {
        break label3851;
      }
      paramaukz.a(new NoColumnError("isShowQZone", Integer.TYPE));
      label2952:
      i = paramCursor.getColumnIndex("mIsHideBigClub");
      if (i != -1) {
        break label3866;
      }
      paramaukz.a(new NoColumnError("mIsHideBigClub", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("honorList");
      if (i != -1) {
        break label3881;
      }
      paramaukz.a(new NoColumnError("honorList", String.class));
      return paramauko;
      paramauko.troopuin = paramCursor.getString(i);
      break;
      label3043:
      paramauko.memberuin = paramCursor.getString(i);
      break label1128;
      label3058:
      paramauko.friendnick = paramCursor.getString(i);
      break label1163;
      label3073:
      paramauko.pyAll_friendnick = paramCursor.getString(i);
      break label1198;
      label3088:
      paramauko.pyFirst_friendnick = paramCursor.getString(i);
      break label1233;
      label3103:
      paramauko.troopnick = paramCursor.getString(i);
      break label1268;
      label3118:
      paramauko.troopColorNick = paramCursor.getString(i);
      break label1303;
      label3133:
      paramauko.pyAll_troopnick = paramCursor.getString(i);
      break label1338;
      label3148:
      paramauko.pyFirst_troopnick = paramCursor.getString(i);
      break label1373;
      label3163:
      paramauko.autoremark = paramCursor.getString(i);
      break label1408;
      label3178:
      paramauko.pyAll_autoremark = paramCursor.getString(i);
      break label1443;
      label3193:
      paramauko.pyFirst_autoremark = paramCursor.getString(i);
      break label1478;
      label3208:
      paramauko.troopremark = paramCursor.getString(i);
      break label1513;
      label3223:
      paramauko.alias = paramCursor.getString(i);
      break label1548;
      label3238:
      paramauko.datetime = paramCursor.getLong(i);
      break label1583;
      label3253:
      paramauko.faceid = paramCursor.getShort(i);
      break label1618;
      label3268:
      paramauko.age = ((byte)paramCursor.getShort(i));
      break label1653;
      label3284:
      paramauko.sex = ((byte)paramCursor.getShort(i));
      break label1688;
      label3300:
      paramauko.status = ((byte)paramCursor.getShort(i));
      break label1723;
      label3316:
      paramauko.qqVipInfo = paramCursor.getInt(i);
      break label1758;
      label3331:
      paramauko.superQqInfo = paramCursor.getInt(i);
      break label1793;
      label3346:
      paramauko.superVipInfo = paramCursor.getInt(i);
      break label1828;
      label3361:
      paramauko.level = paramCursor.getInt(i);
      break label1863;
      label3376:
      paramauko.realLevel = paramCursor.getInt(i);
      break label1898;
      label3391:
      paramauko.mGlamourLevel = paramCursor.getInt(i);
      break label1933;
      label3406:
      paramauko.hotChatGlamourLevel = paramCursor.getInt(i);
      break label1968;
      label3421:
      paramauko.globalTroopLevel = paramCursor.getInt(i);
      break label2003;
      label3436:
      paramauko.join_time = paramCursor.getLong(i);
      break label2038;
      label3451:
      paramauko.last_active_time = paramCursor.getLong(i);
      break label2073;
      label3466:
      paramauko.active_point = paramCursor.getLong(i);
      break label2108;
      label3481:
      paramauko.credit_level = paramCursor.getLong(i);
      break label2143;
      label3496:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isTroopFollowed = paramBoolean;
        break;
      }
      label3523:
      paramauko.distance = paramCursor.getInt(i);
      break label2213;
      label3538:
      paramauko.msgseq = paramCursor.getLong(i);
      break label2248;
      label3553:
      paramauko.gagTimeStamp = paramCursor.getLong(i);
      break label2283;
      label3568:
      paramauko.distanceToSelf = paramCursor.getDouble(i);
      break label2318;
      label3583:
      paramauko.distanceToSelfUpdateTimeStamp = paramCursor.getLong(i);
      break label2353;
      label3598:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramauko.mIsShielded = paramBoolean;
        break;
      }
      label3626:
      paramauko.mUniqueTitle = paramCursor.getString(i);
      break label2423;
      label3641:
      paramauko.mUniqueTitleExpire = paramCursor.getInt(i);
      break label2458;
      label3656:
      paramauko.tribeLevel = paramCursor.getInt(i);
      break label2493;
      label3671:
      paramauko.tribePoint = paramCursor.getInt(i);
      break label2528;
      label3686:
      paramauko.commonFrdCnt = paramCursor.getInt(i);
      break label2563;
      label3701:
      paramauko.hwIdentity = paramCursor.getInt(i);
      break label2598;
      label3716:
      paramauko.hwCourse = paramCursor.getString(i);
      break label2633;
      label3731:
      paramauko.hwName = paramCursor.getString(i);
      break label2668;
      label3746:
      paramauko.mVipType = paramCursor.getInt(i);
      break label2703;
      label3761:
      paramauko.mVipLevel = paramCursor.getInt(i);
      break label2738;
      label3776:
      paramauko.mVipTemplateId = paramCursor.getInt(i);
      break label2773;
      label3791:
      paramauko.mBigClubVipType = paramCursor.getInt(i);
      break label2808;
      label3806:
      paramauko.mBigClubVipLevel = paramCursor.getInt(i);
      break label2843;
      label3821:
      paramauko.mBigClubTemplateId = paramCursor.getInt(i);
      break label2878;
      label3836:
      paramauko.recommendRemark = paramCursor.getString(i);
      break label2915;
      label3851:
      paramauko.isShowQZone = paramCursor.getInt(i);
      break label2952;
      label3866:
      paramauko.mIsHideBigClub = paramCursor.getInt(i);
    }
    label3881:
    paramauko.honorList = paramCursor.getString(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopuin TEXT ,memberuin TEXT ,friendnick TEXT ,pyAll_friendnick TEXT ,pyFirst_friendnick TEXT ,troopnick TEXT ,troopColorNick TEXT ,pyAll_troopnick TEXT ,pyFirst_troopnick TEXT ,autoremark TEXT ,pyAll_autoremark TEXT ,pyFirst_autoremark TEXT ,troopremark TEXT ,alias TEXT ,datetime INTEGER ,faceid INTEGER ,age INTEGER ,sex INTEGER ,status INTEGER ,qqVipInfo INTEGER ,superQqInfo INTEGER ,superVipInfo INTEGER ,level INTEGER ,realLevel INTEGER ,mGlamourLevel INTEGER ,hotChatGlamourLevel INTEGER ,globalTroopLevel INTEGER ,join_time INTEGER ,last_active_time INTEGER ,active_point INTEGER ,credit_level INTEGER ,isTroopFollowed INTEGER ,distance INTEGER ,msgseq INTEGER ,gagTimeStamp INTEGER ,distanceToSelf REAL ,distanceToSelfUpdateTimeStamp INTEGER ,mIsShielded INTEGER ,mUniqueTitle TEXT ,mUniqueTitleExpire INTEGER ,tribeLevel INTEGER ,tribePoint INTEGER ,commonFrdCnt INTEGER ,hwIdentity INTEGER ,hwCourse TEXT ,hwName TEXT ,mVipType INTEGER ,mVipLevel INTEGER ,mVipTemplateId INTEGER ,mBigClubVipType INTEGER ,mBigClubVipLevel INTEGER ,mBigClubTemplateId INTEGER ,recommendRemark TEXT ,isShowQZone INTEGER ,mIsHideBigClub INTEGER ,honorList TEXT,UNIQUE(troopuin,memberuin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (TroopMemberInfo)paramauko;
    paramContentValues.put("troopuin", paramauko.troopuin);
    paramContentValues.put("memberuin", paramauko.memberuin);
    paramContentValues.put("friendnick", paramauko.friendnick);
    paramContentValues.put("pyAll_friendnick", paramauko.pyAll_friendnick);
    paramContentValues.put("pyFirst_friendnick", paramauko.pyFirst_friendnick);
    paramContentValues.put("troopnick", paramauko.troopnick);
    paramContentValues.put("troopColorNick", paramauko.troopColorNick);
    paramContentValues.put("pyAll_troopnick", paramauko.pyAll_troopnick);
    paramContentValues.put("pyFirst_troopnick", paramauko.pyFirst_troopnick);
    paramContentValues.put("autoremark", paramauko.autoremark);
    paramContentValues.put("pyAll_autoremark", paramauko.pyAll_autoremark);
    paramContentValues.put("pyFirst_autoremark", paramauko.pyFirst_autoremark);
    paramContentValues.put("troopremark", paramauko.troopremark);
    paramContentValues.put("alias", paramauko.alias);
    paramContentValues.put("datetime", Long.valueOf(paramauko.datetime));
    paramContentValues.put("faceid", Short.valueOf(paramauko.faceid));
    paramContentValues.put("age", Byte.valueOf(paramauko.age));
    paramContentValues.put("sex", Byte.valueOf(paramauko.sex));
    paramContentValues.put("status", Byte.valueOf(paramauko.status));
    paramContentValues.put("qqVipInfo", Integer.valueOf(paramauko.qqVipInfo));
    paramContentValues.put("superQqInfo", Integer.valueOf(paramauko.superQqInfo));
    paramContentValues.put("superVipInfo", Integer.valueOf(paramauko.superVipInfo));
    paramContentValues.put("level", Integer.valueOf(paramauko.level));
    paramContentValues.put("realLevel", Integer.valueOf(paramauko.realLevel));
    paramContentValues.put("mGlamourLevel", Integer.valueOf(paramauko.mGlamourLevel));
    paramContentValues.put("hotChatGlamourLevel", Integer.valueOf(paramauko.hotChatGlamourLevel));
    paramContentValues.put("globalTroopLevel", Integer.valueOf(paramauko.globalTroopLevel));
    paramContentValues.put("join_time", Long.valueOf(paramauko.join_time));
    paramContentValues.put("last_active_time", Long.valueOf(paramauko.last_active_time));
    paramContentValues.put("active_point", Long.valueOf(paramauko.active_point));
    paramContentValues.put("credit_level", Long.valueOf(paramauko.credit_level));
    paramContentValues.put("isTroopFollowed", Boolean.valueOf(paramauko.isTroopFollowed));
    paramContentValues.put("distance", Integer.valueOf(paramauko.distance));
    paramContentValues.put("msgseq", Long.valueOf(paramauko.msgseq));
    paramContentValues.put("gagTimeStamp", Long.valueOf(paramauko.gagTimeStamp));
    paramContentValues.put("distanceToSelf", Double.valueOf(paramauko.distanceToSelf));
    paramContentValues.put("distanceToSelfUpdateTimeStamp", Long.valueOf(paramauko.distanceToSelfUpdateTimeStamp));
    paramContentValues.put("mIsShielded", Boolean.valueOf(paramauko.mIsShielded));
    paramContentValues.put("mUniqueTitle", paramauko.mUniqueTitle);
    paramContentValues.put("mUniqueTitleExpire", Integer.valueOf(paramauko.mUniqueTitleExpire));
    paramContentValues.put("tribeLevel", Integer.valueOf(paramauko.tribeLevel));
    paramContentValues.put("tribePoint", Integer.valueOf(paramauko.tribePoint));
    paramContentValues.put("commonFrdCnt", Integer.valueOf(paramauko.commonFrdCnt));
    paramContentValues.put("hwIdentity", Integer.valueOf(paramauko.hwIdentity));
    paramContentValues.put("hwCourse", paramauko.hwCourse);
    paramContentValues.put("hwName", paramauko.hwName);
    paramContentValues.put("mVipType", Integer.valueOf(paramauko.mVipType));
    paramContentValues.put("mVipLevel", Integer.valueOf(paramauko.mVipLevel));
    paramContentValues.put("mVipTemplateId", Integer.valueOf(paramauko.mVipTemplateId));
    paramContentValues.put("mBigClubVipType", Integer.valueOf(paramauko.mBigClubVipType));
    paramContentValues.put("mBigClubVipLevel", Integer.valueOf(paramauko.mBigClubVipLevel));
    paramContentValues.put("mBigClubTemplateId", Integer.valueOf(paramauko.mBigClubTemplateId));
    paramContentValues.put("recommendRemark", paramauko.recommendRemark);
    paramContentValues.put("isShowQZone", Integer.valueOf(paramauko.isShowQZone));
    paramContentValues.put("mIsHideBigClub", Integer.valueOf(paramauko.mIsHideBigClub));
    paramContentValues.put("honorList", paramauko.honorList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ault
 * JD-Core Version:    0.7.0.1
 */