import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aulr
  extends auky
{
  public aulr()
  {
    this.a = 56;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramaukm = (TroopMemberInfo)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
      paramaukm.memberuin = paramCursor.getString(paramCursor.getColumnIndex("memberuin"));
      paramaukm.friendnick = paramCursor.getString(paramCursor.getColumnIndex("friendnick"));
      paramaukm.pyAll_friendnick = paramCursor.getString(paramCursor.getColumnIndex("pyAll_friendnick"));
      paramaukm.pyFirst_friendnick = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_friendnick"));
      paramaukm.troopnick = paramCursor.getString(paramCursor.getColumnIndex("troopnick"));
      paramaukm.troopColorNick = paramCursor.getString(paramCursor.getColumnIndex("troopColorNick"));
      paramaukm.pyAll_troopnick = paramCursor.getString(paramCursor.getColumnIndex("pyAll_troopnick"));
      paramaukm.pyFirst_troopnick = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_troopnick"));
      paramaukm.autoremark = paramCursor.getString(paramCursor.getColumnIndex("autoremark"));
      paramaukm.pyAll_autoremark = paramCursor.getString(paramCursor.getColumnIndex("pyAll_autoremark"));
      paramaukm.pyFirst_autoremark = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_autoremark"));
      paramaukm.troopremark = paramCursor.getString(paramCursor.getColumnIndex("troopremark"));
      paramaukm.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
      paramaukm.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
      paramaukm.faceid = paramCursor.getShort(paramCursor.getColumnIndex("faceid"));
      paramaukm.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramaukm.sex = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sex")));
      paramaukm.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("status")));
      paramaukm.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
      paramaukm.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
      paramaukm.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
      paramaukm.level = paramCursor.getInt(paramCursor.getColumnIndex("level"));
      paramaukm.realLevel = paramCursor.getInt(paramCursor.getColumnIndex("realLevel"));
      paramaukm.mGlamourLevel = paramCursor.getInt(paramCursor.getColumnIndex("mGlamourLevel"));
      paramaukm.hotChatGlamourLevel = paramCursor.getInt(paramCursor.getColumnIndex("hotChatGlamourLevel"));
      paramaukm.globalTroopLevel = paramCursor.getInt(paramCursor.getColumnIndex("globalTroopLevel"));
      paramaukm.join_time = paramCursor.getLong(paramCursor.getColumnIndex("join_time"));
      paramaukm.last_active_time = paramCursor.getLong(paramCursor.getColumnIndex("last_active_time"));
      paramaukm.active_point = paramCursor.getLong(paramCursor.getColumnIndex("active_point"));
      paramaukm.credit_level = paramCursor.getLong(paramCursor.getColumnIndex("credit_level"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isTroopFollowed")))
      {
        paramBoolean = true;
        paramaukm.isTroopFollowed = paramBoolean;
        paramaukm.distance = paramCursor.getInt(paramCursor.getColumnIndex("distance"));
        paramaukm.msgseq = paramCursor.getLong(paramCursor.getColumnIndex("msgseq"));
        paramaukm.gagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("gagTimeStamp"));
        paramaukm.distanceToSelf = paramCursor.getDouble(paramCursor.getColumnIndex("distanceToSelf"));
        paramaukm.distanceToSelfUpdateTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("distanceToSelfUpdateTimeStamp"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mIsShielded"))) {
          break label1053;
        }
      }
      label1053:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramaukm.mIsShielded = paramBoolean;
        paramaukm.mUniqueTitle = paramCursor.getString(paramCursor.getColumnIndex("mUniqueTitle"));
        paramaukm.mUniqueTitleExpire = paramCursor.getInt(paramCursor.getColumnIndex("mUniqueTitleExpire"));
        paramaukm.tribeLevel = paramCursor.getInt(paramCursor.getColumnIndex("tribeLevel"));
        paramaukm.tribePoint = paramCursor.getInt(paramCursor.getColumnIndex("tribePoint"));
        paramaukm.commonFrdCnt = paramCursor.getInt(paramCursor.getColumnIndex("commonFrdCnt"));
        paramaukm.hwIdentity = paramCursor.getInt(paramCursor.getColumnIndex("hwIdentity"));
        paramaukm.hwCourse = paramCursor.getString(paramCursor.getColumnIndex("hwCourse"));
        paramaukm.hwName = paramCursor.getString(paramCursor.getColumnIndex("hwName"));
        paramaukm.mVipType = paramCursor.getInt(paramCursor.getColumnIndex("mVipType"));
        paramaukm.mVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("mVipLevel"));
        paramaukm.mVipTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("mVipTemplateId"));
        paramaukm.mBigClubVipType = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubVipType"));
        paramaukm.mBigClubVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubVipLevel"));
        paramaukm.mBigClubTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubTemplateId"));
        paramaukm.recommendRemark = paramCursor.getString(paramCursor.getColumnIndex("recommendRemark"));
        paramaukm.isShowQZone = paramCursor.getInt(paramCursor.getColumnIndex("isShowQZone"));
        paramaukm.mIsHideBigClub = paramCursor.getInt(paramCursor.getColumnIndex("mIsHideBigClub"));
        paramaukm.honorList = paramCursor.getString(paramCursor.getColumnIndex("honorList"));
        return paramaukm;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("troopuin");
    if (i == -1)
    {
      paramaukx.a(new NoColumnError("troopuin", String.class));
      i = paramCursor.getColumnIndex("memberuin");
      if (i != -1) {
        break label3043;
      }
      paramaukx.a(new NoColumnError("memberuin", String.class));
      label1128:
      i = paramCursor.getColumnIndex("friendnick");
      if (i != -1) {
        break label3058;
      }
      paramaukx.a(new NoColumnError("friendnick", String.class));
      label1163:
      i = paramCursor.getColumnIndex("pyAll_friendnick");
      if (i != -1) {
        break label3073;
      }
      paramaukx.a(new NoColumnError("pyAll_friendnick", String.class));
      label1198:
      i = paramCursor.getColumnIndex("pyFirst_friendnick");
      if (i != -1) {
        break label3088;
      }
      paramaukx.a(new NoColumnError("pyFirst_friendnick", String.class));
      label1233:
      i = paramCursor.getColumnIndex("troopnick");
      if (i != -1) {
        break label3103;
      }
      paramaukx.a(new NoColumnError("troopnick", String.class));
      label1268:
      i = paramCursor.getColumnIndex("troopColorNick");
      if (i != -1) {
        break label3118;
      }
      paramaukx.a(new NoColumnError("troopColorNick", String.class));
      label1303:
      i = paramCursor.getColumnIndex("pyAll_troopnick");
      if (i != -1) {
        break label3133;
      }
      paramaukx.a(new NoColumnError("pyAll_troopnick", String.class));
      label1338:
      i = paramCursor.getColumnIndex("pyFirst_troopnick");
      if (i != -1) {
        break label3148;
      }
      paramaukx.a(new NoColumnError("pyFirst_troopnick", String.class));
      label1373:
      i = paramCursor.getColumnIndex("autoremark");
      if (i != -1) {
        break label3163;
      }
      paramaukx.a(new NoColumnError("autoremark", String.class));
      label1408:
      i = paramCursor.getColumnIndex("pyAll_autoremark");
      if (i != -1) {
        break label3178;
      }
      paramaukx.a(new NoColumnError("pyAll_autoremark", String.class));
      label1443:
      i = paramCursor.getColumnIndex("pyFirst_autoremark");
      if (i != -1) {
        break label3193;
      }
      paramaukx.a(new NoColumnError("pyFirst_autoremark", String.class));
      label1478:
      i = paramCursor.getColumnIndex("troopremark");
      if (i != -1) {
        break label3208;
      }
      paramaukx.a(new NoColumnError("troopremark", String.class));
      label1513:
      i = paramCursor.getColumnIndex("alias");
      if (i != -1) {
        break label3223;
      }
      paramaukx.a(new NoColumnError("alias", String.class));
      label1548:
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label3238;
      }
      paramaukx.a(new NoColumnError("datetime", Long.TYPE));
      label1583:
      i = paramCursor.getColumnIndex("faceid");
      if (i != -1) {
        break label3253;
      }
      paramaukx.a(new NoColumnError("faceid", Short.TYPE));
      label1618:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label3268;
      }
      paramaukx.a(new NoColumnError("age", Byte.TYPE));
      label1653:
      i = paramCursor.getColumnIndex("sex");
      if (i != -1) {
        break label3284;
      }
      paramaukx.a(new NoColumnError("sex", Byte.TYPE));
      label1688:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label3300;
      }
      paramaukx.a(new NoColumnError("status", Byte.TYPE));
      label1723:
      i = paramCursor.getColumnIndex("qqVipInfo");
      if (i != -1) {
        break label3316;
      }
      paramaukx.a(new NoColumnError("qqVipInfo", Integer.TYPE));
      label1758:
      i = paramCursor.getColumnIndex("superQqInfo");
      if (i != -1) {
        break label3331;
      }
      paramaukx.a(new NoColumnError("superQqInfo", Integer.TYPE));
      label1793:
      i = paramCursor.getColumnIndex("superVipInfo");
      if (i != -1) {
        break label3346;
      }
      paramaukx.a(new NoColumnError("superVipInfo", Integer.TYPE));
      label1828:
      i = paramCursor.getColumnIndex("level");
      if (i != -1) {
        break label3361;
      }
      paramaukx.a(new NoColumnError("level", Integer.TYPE));
      label1863:
      i = paramCursor.getColumnIndex("realLevel");
      if (i != -1) {
        break label3376;
      }
      paramaukx.a(new NoColumnError("realLevel", Integer.TYPE));
      label1898:
      i = paramCursor.getColumnIndex("mGlamourLevel");
      if (i != -1) {
        break label3391;
      }
      paramaukx.a(new NoColumnError("mGlamourLevel", Integer.TYPE));
      label1933:
      i = paramCursor.getColumnIndex("hotChatGlamourLevel");
      if (i != -1) {
        break label3406;
      }
      paramaukx.a(new NoColumnError("hotChatGlamourLevel", Integer.TYPE));
      label1968:
      i = paramCursor.getColumnIndex("globalTroopLevel");
      if (i != -1) {
        break label3421;
      }
      paramaukx.a(new NoColumnError("globalTroopLevel", Integer.TYPE));
      label2003:
      i = paramCursor.getColumnIndex("join_time");
      if (i != -1) {
        break label3436;
      }
      paramaukx.a(new NoColumnError("join_time", Long.TYPE));
      label2038:
      i = paramCursor.getColumnIndex("last_active_time");
      if (i != -1) {
        break label3451;
      }
      paramaukx.a(new NoColumnError("last_active_time", Long.TYPE));
      label2073:
      i = paramCursor.getColumnIndex("active_point");
      if (i != -1) {
        break label3466;
      }
      paramaukx.a(new NoColumnError("active_point", Long.TYPE));
      label2108:
      i = paramCursor.getColumnIndex("credit_level");
      if (i != -1) {
        break label3481;
      }
      paramaukx.a(new NoColumnError("credit_level", Long.TYPE));
      label2143:
      i = paramCursor.getColumnIndex("isTroopFollowed");
      if (i != -1) {
        break label3496;
      }
      paramaukx.a(new NoColumnError("isTroopFollowed", Boolean.TYPE));
      i = paramCursor.getColumnIndex("distance");
      if (i != -1) {
        break label3523;
      }
      paramaukx.a(new NoColumnError("distance", Integer.TYPE));
      label2213:
      i = paramCursor.getColumnIndex("msgseq");
      if (i != -1) {
        break label3538;
      }
      paramaukx.a(new NoColumnError("msgseq", Long.TYPE));
      label2248:
      i = paramCursor.getColumnIndex("gagTimeStamp");
      if (i != -1) {
        break label3553;
      }
      paramaukx.a(new NoColumnError("gagTimeStamp", Long.TYPE));
      label2283:
      i = paramCursor.getColumnIndex("distanceToSelf");
      if (i != -1) {
        break label3568;
      }
      paramaukx.a(new NoColumnError("distanceToSelf", Double.TYPE));
      label2318:
      i = paramCursor.getColumnIndex("distanceToSelfUpdateTimeStamp");
      if (i != -1) {
        break label3583;
      }
      paramaukx.a(new NoColumnError("distanceToSelfUpdateTimeStamp", Long.TYPE));
      label2353:
      i = paramCursor.getColumnIndex("mIsShielded");
      if (i != -1) {
        break label3598;
      }
      paramaukx.a(new NoColumnError("mIsShielded", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mUniqueTitle");
      if (i != -1) {
        break label3626;
      }
      paramaukx.a(new NoColumnError("mUniqueTitle", String.class));
      label2423:
      i = paramCursor.getColumnIndex("mUniqueTitleExpire");
      if (i != -1) {
        break label3641;
      }
      paramaukx.a(new NoColumnError("mUniqueTitleExpire", Integer.TYPE));
      label2458:
      i = paramCursor.getColumnIndex("tribeLevel");
      if (i != -1) {
        break label3656;
      }
      paramaukx.a(new NoColumnError("tribeLevel", Integer.TYPE));
      label2493:
      i = paramCursor.getColumnIndex("tribePoint");
      if (i != -1) {
        break label3671;
      }
      paramaukx.a(new NoColumnError("tribePoint", Integer.TYPE));
      label2528:
      i = paramCursor.getColumnIndex("commonFrdCnt");
      if (i != -1) {
        break label3686;
      }
      paramaukx.a(new NoColumnError("commonFrdCnt", Integer.TYPE));
      label2563:
      i = paramCursor.getColumnIndex("hwIdentity");
      if (i != -1) {
        break label3701;
      }
      paramaukx.a(new NoColumnError("hwIdentity", Integer.TYPE));
      label2598:
      i = paramCursor.getColumnIndex("hwCourse");
      if (i != -1) {
        break label3716;
      }
      paramaukx.a(new NoColumnError("hwCourse", String.class));
      label2633:
      i = paramCursor.getColumnIndex("hwName");
      if (i != -1) {
        break label3731;
      }
      paramaukx.a(new NoColumnError("hwName", String.class));
      label2668:
      i = paramCursor.getColumnIndex("mVipType");
      if (i != -1) {
        break label3746;
      }
      paramaukx.a(new NoColumnError("mVipType", Integer.TYPE));
      label2703:
      i = paramCursor.getColumnIndex("mVipLevel");
      if (i != -1) {
        break label3761;
      }
      paramaukx.a(new NoColumnError("mVipLevel", Integer.TYPE));
      label2738:
      i = paramCursor.getColumnIndex("mVipTemplateId");
      if (i != -1) {
        break label3776;
      }
      paramaukx.a(new NoColumnError("mVipTemplateId", Integer.TYPE));
      label2773:
      i = paramCursor.getColumnIndex("mBigClubVipType");
      if (i != -1) {
        break label3791;
      }
      paramaukx.a(new NoColumnError("mBigClubVipType", Integer.TYPE));
      label2808:
      i = paramCursor.getColumnIndex("mBigClubVipLevel");
      if (i != -1) {
        break label3806;
      }
      paramaukx.a(new NoColumnError("mBigClubVipLevel", Integer.TYPE));
      label2843:
      i = paramCursor.getColumnIndex("mBigClubTemplateId");
      if (i != -1) {
        break label3821;
      }
      paramaukx.a(new NoColumnError("mBigClubTemplateId", Integer.TYPE));
      label2878:
      i = paramCursor.getColumnIndex("recommendRemark");
      if (i != -1) {
        break label3836;
      }
      paramaukx.a(new NoColumnError("recommendRemark", String.class));
      label2915:
      i = paramCursor.getColumnIndex("isShowQZone");
      if (i != -1) {
        break label3851;
      }
      paramaukx.a(new NoColumnError("isShowQZone", Integer.TYPE));
      label2952:
      i = paramCursor.getColumnIndex("mIsHideBigClub");
      if (i != -1) {
        break label3866;
      }
      paramaukx.a(new NoColumnError("mIsHideBigClub", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("honorList");
      if (i != -1) {
        break label3881;
      }
      paramaukx.a(new NoColumnError("honorList", String.class));
      return paramaukm;
      paramaukm.troopuin = paramCursor.getString(i);
      break;
      label3043:
      paramaukm.memberuin = paramCursor.getString(i);
      break label1128;
      label3058:
      paramaukm.friendnick = paramCursor.getString(i);
      break label1163;
      label3073:
      paramaukm.pyAll_friendnick = paramCursor.getString(i);
      break label1198;
      label3088:
      paramaukm.pyFirst_friendnick = paramCursor.getString(i);
      break label1233;
      label3103:
      paramaukm.troopnick = paramCursor.getString(i);
      break label1268;
      label3118:
      paramaukm.troopColorNick = paramCursor.getString(i);
      break label1303;
      label3133:
      paramaukm.pyAll_troopnick = paramCursor.getString(i);
      break label1338;
      label3148:
      paramaukm.pyFirst_troopnick = paramCursor.getString(i);
      break label1373;
      label3163:
      paramaukm.autoremark = paramCursor.getString(i);
      break label1408;
      label3178:
      paramaukm.pyAll_autoremark = paramCursor.getString(i);
      break label1443;
      label3193:
      paramaukm.pyFirst_autoremark = paramCursor.getString(i);
      break label1478;
      label3208:
      paramaukm.troopremark = paramCursor.getString(i);
      break label1513;
      label3223:
      paramaukm.alias = paramCursor.getString(i);
      break label1548;
      label3238:
      paramaukm.datetime = paramCursor.getLong(i);
      break label1583;
      label3253:
      paramaukm.faceid = paramCursor.getShort(i);
      break label1618;
      label3268:
      paramaukm.age = ((byte)paramCursor.getShort(i));
      break label1653;
      label3284:
      paramaukm.sex = ((byte)paramCursor.getShort(i));
      break label1688;
      label3300:
      paramaukm.status = ((byte)paramCursor.getShort(i));
      break label1723;
      label3316:
      paramaukm.qqVipInfo = paramCursor.getInt(i);
      break label1758;
      label3331:
      paramaukm.superQqInfo = paramCursor.getInt(i);
      break label1793;
      label3346:
      paramaukm.superVipInfo = paramCursor.getInt(i);
      break label1828;
      label3361:
      paramaukm.level = paramCursor.getInt(i);
      break label1863;
      label3376:
      paramaukm.realLevel = paramCursor.getInt(i);
      break label1898;
      label3391:
      paramaukm.mGlamourLevel = paramCursor.getInt(i);
      break label1933;
      label3406:
      paramaukm.hotChatGlamourLevel = paramCursor.getInt(i);
      break label1968;
      label3421:
      paramaukm.globalTroopLevel = paramCursor.getInt(i);
      break label2003;
      label3436:
      paramaukm.join_time = paramCursor.getLong(i);
      break label2038;
      label3451:
      paramaukm.last_active_time = paramCursor.getLong(i);
      break label2073;
      label3466:
      paramaukm.active_point = paramCursor.getLong(i);
      break label2108;
      label3481:
      paramaukm.credit_level = paramCursor.getLong(i);
      break label2143;
      label3496:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isTroopFollowed = paramBoolean;
        break;
      }
      label3523:
      paramaukm.distance = paramCursor.getInt(i);
      break label2213;
      label3538:
      paramaukm.msgseq = paramCursor.getLong(i);
      break label2248;
      label3553:
      paramaukm.gagTimeStamp = paramCursor.getLong(i);
      break label2283;
      label3568:
      paramaukm.distanceToSelf = paramCursor.getDouble(i);
      break label2318;
      label3583:
      paramaukm.distanceToSelfUpdateTimeStamp = paramCursor.getLong(i);
      break label2353;
      label3598:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramaukm.mIsShielded = paramBoolean;
        break;
      }
      label3626:
      paramaukm.mUniqueTitle = paramCursor.getString(i);
      break label2423;
      label3641:
      paramaukm.mUniqueTitleExpire = paramCursor.getInt(i);
      break label2458;
      label3656:
      paramaukm.tribeLevel = paramCursor.getInt(i);
      break label2493;
      label3671:
      paramaukm.tribePoint = paramCursor.getInt(i);
      break label2528;
      label3686:
      paramaukm.commonFrdCnt = paramCursor.getInt(i);
      break label2563;
      label3701:
      paramaukm.hwIdentity = paramCursor.getInt(i);
      break label2598;
      label3716:
      paramaukm.hwCourse = paramCursor.getString(i);
      break label2633;
      label3731:
      paramaukm.hwName = paramCursor.getString(i);
      break label2668;
      label3746:
      paramaukm.mVipType = paramCursor.getInt(i);
      break label2703;
      label3761:
      paramaukm.mVipLevel = paramCursor.getInt(i);
      break label2738;
      label3776:
      paramaukm.mVipTemplateId = paramCursor.getInt(i);
      break label2773;
      label3791:
      paramaukm.mBigClubVipType = paramCursor.getInt(i);
      break label2808;
      label3806:
      paramaukm.mBigClubVipLevel = paramCursor.getInt(i);
      break label2843;
      label3821:
      paramaukm.mBigClubTemplateId = paramCursor.getInt(i);
      break label2878;
      label3836:
      paramaukm.recommendRemark = paramCursor.getString(i);
      break label2915;
      label3851:
      paramaukm.isShowQZone = paramCursor.getInt(i);
      break label2952;
      label3866:
      paramaukm.mIsHideBigClub = paramCursor.getInt(i);
    }
    label3881:
    paramaukm.honorList = paramCursor.getString(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopuin TEXT ,memberuin TEXT ,friendnick TEXT ,pyAll_friendnick TEXT ,pyFirst_friendnick TEXT ,troopnick TEXT ,troopColorNick TEXT ,pyAll_troopnick TEXT ,pyFirst_troopnick TEXT ,autoremark TEXT ,pyAll_autoremark TEXT ,pyFirst_autoremark TEXT ,troopremark TEXT ,alias TEXT ,datetime INTEGER ,faceid INTEGER ,age INTEGER ,sex INTEGER ,status INTEGER ,qqVipInfo INTEGER ,superQqInfo INTEGER ,superVipInfo INTEGER ,level INTEGER ,realLevel INTEGER ,mGlamourLevel INTEGER ,hotChatGlamourLevel INTEGER ,globalTroopLevel INTEGER ,join_time INTEGER ,last_active_time INTEGER ,active_point INTEGER ,credit_level INTEGER ,isTroopFollowed INTEGER ,distance INTEGER ,msgseq INTEGER ,gagTimeStamp INTEGER ,distanceToSelf REAL ,distanceToSelfUpdateTimeStamp INTEGER ,mIsShielded INTEGER ,mUniqueTitle TEXT ,mUniqueTitleExpire INTEGER ,tribeLevel INTEGER ,tribePoint INTEGER ,commonFrdCnt INTEGER ,hwIdentity INTEGER ,hwCourse TEXT ,hwName TEXT ,mVipType INTEGER ,mVipLevel INTEGER ,mVipTemplateId INTEGER ,mBigClubVipType INTEGER ,mBigClubVipLevel INTEGER ,mBigClubTemplateId INTEGER ,recommendRemark TEXT ,isShowQZone INTEGER ,mIsHideBigClub INTEGER ,honorList TEXT,UNIQUE(troopuin,memberuin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (TroopMemberInfo)paramaukm;
    paramContentValues.put("troopuin", paramaukm.troopuin);
    paramContentValues.put("memberuin", paramaukm.memberuin);
    paramContentValues.put("friendnick", paramaukm.friendnick);
    paramContentValues.put("pyAll_friendnick", paramaukm.pyAll_friendnick);
    paramContentValues.put("pyFirst_friendnick", paramaukm.pyFirst_friendnick);
    paramContentValues.put("troopnick", paramaukm.troopnick);
    paramContentValues.put("troopColorNick", paramaukm.troopColorNick);
    paramContentValues.put("pyAll_troopnick", paramaukm.pyAll_troopnick);
    paramContentValues.put("pyFirst_troopnick", paramaukm.pyFirst_troopnick);
    paramContentValues.put("autoremark", paramaukm.autoremark);
    paramContentValues.put("pyAll_autoremark", paramaukm.pyAll_autoremark);
    paramContentValues.put("pyFirst_autoremark", paramaukm.pyFirst_autoremark);
    paramContentValues.put("troopremark", paramaukm.troopremark);
    paramContentValues.put("alias", paramaukm.alias);
    paramContentValues.put("datetime", Long.valueOf(paramaukm.datetime));
    paramContentValues.put("faceid", Short.valueOf(paramaukm.faceid));
    paramContentValues.put("age", Byte.valueOf(paramaukm.age));
    paramContentValues.put("sex", Byte.valueOf(paramaukm.sex));
    paramContentValues.put("status", Byte.valueOf(paramaukm.status));
    paramContentValues.put("qqVipInfo", Integer.valueOf(paramaukm.qqVipInfo));
    paramContentValues.put("superQqInfo", Integer.valueOf(paramaukm.superQqInfo));
    paramContentValues.put("superVipInfo", Integer.valueOf(paramaukm.superVipInfo));
    paramContentValues.put("level", Integer.valueOf(paramaukm.level));
    paramContentValues.put("realLevel", Integer.valueOf(paramaukm.realLevel));
    paramContentValues.put("mGlamourLevel", Integer.valueOf(paramaukm.mGlamourLevel));
    paramContentValues.put("hotChatGlamourLevel", Integer.valueOf(paramaukm.hotChatGlamourLevel));
    paramContentValues.put("globalTroopLevel", Integer.valueOf(paramaukm.globalTroopLevel));
    paramContentValues.put("join_time", Long.valueOf(paramaukm.join_time));
    paramContentValues.put("last_active_time", Long.valueOf(paramaukm.last_active_time));
    paramContentValues.put("active_point", Long.valueOf(paramaukm.active_point));
    paramContentValues.put("credit_level", Long.valueOf(paramaukm.credit_level));
    paramContentValues.put("isTroopFollowed", Boolean.valueOf(paramaukm.isTroopFollowed));
    paramContentValues.put("distance", Integer.valueOf(paramaukm.distance));
    paramContentValues.put("msgseq", Long.valueOf(paramaukm.msgseq));
    paramContentValues.put("gagTimeStamp", Long.valueOf(paramaukm.gagTimeStamp));
    paramContentValues.put("distanceToSelf", Double.valueOf(paramaukm.distanceToSelf));
    paramContentValues.put("distanceToSelfUpdateTimeStamp", Long.valueOf(paramaukm.distanceToSelfUpdateTimeStamp));
    paramContentValues.put("mIsShielded", Boolean.valueOf(paramaukm.mIsShielded));
    paramContentValues.put("mUniqueTitle", paramaukm.mUniqueTitle);
    paramContentValues.put("mUniqueTitleExpire", Integer.valueOf(paramaukm.mUniqueTitleExpire));
    paramContentValues.put("tribeLevel", Integer.valueOf(paramaukm.tribeLevel));
    paramContentValues.put("tribePoint", Integer.valueOf(paramaukm.tribePoint));
    paramContentValues.put("commonFrdCnt", Integer.valueOf(paramaukm.commonFrdCnt));
    paramContentValues.put("hwIdentity", Integer.valueOf(paramaukm.hwIdentity));
    paramContentValues.put("hwCourse", paramaukm.hwCourse);
    paramContentValues.put("hwName", paramaukm.hwName);
    paramContentValues.put("mVipType", Integer.valueOf(paramaukm.mVipType));
    paramContentValues.put("mVipLevel", Integer.valueOf(paramaukm.mVipLevel));
    paramContentValues.put("mVipTemplateId", Integer.valueOf(paramaukm.mVipTemplateId));
    paramContentValues.put("mBigClubVipType", Integer.valueOf(paramaukm.mBigClubVipType));
    paramContentValues.put("mBigClubVipLevel", Integer.valueOf(paramaukm.mBigClubVipLevel));
    paramContentValues.put("mBigClubTemplateId", Integer.valueOf(paramaukm.mBigClubTemplateId));
    paramContentValues.put("recommendRemark", paramaukm.recommendRemark);
    paramContentValues.put("isShowQZone", Integer.valueOf(paramaukm.isShowQZone));
    paramContentValues.put("mIsHideBigClub", Integer.valueOf(paramaukm.mIsHideBigClub));
    paramContentValues.put("honorList", paramaukm.honorList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulr
 * JD-Core Version:    0.7.0.1
 */