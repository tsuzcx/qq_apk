import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awhj
  extends awgq
{
  public awhj()
  {
    this.a = 56;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawge = (TroopMemberInfo)paramawge;
    if (paramawgp == null)
    {
      paramawge.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
      paramawge.memberuin = paramCursor.getString(paramCursor.getColumnIndex("memberuin"));
      paramawge.friendnick = paramCursor.getString(paramCursor.getColumnIndex("friendnick"));
      paramawge.pyAll_friendnick = paramCursor.getString(paramCursor.getColumnIndex("pyAll_friendnick"));
      paramawge.pyFirst_friendnick = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_friendnick"));
      paramawge.troopnick = paramCursor.getString(paramCursor.getColumnIndex("troopnick"));
      paramawge.troopColorNick = paramCursor.getString(paramCursor.getColumnIndex("troopColorNick"));
      paramawge.pyAll_troopnick = paramCursor.getString(paramCursor.getColumnIndex("pyAll_troopnick"));
      paramawge.pyFirst_troopnick = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_troopnick"));
      paramawge.autoremark = paramCursor.getString(paramCursor.getColumnIndex("autoremark"));
      paramawge.pyAll_autoremark = paramCursor.getString(paramCursor.getColumnIndex("pyAll_autoremark"));
      paramawge.pyFirst_autoremark = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_autoremark"));
      paramawge.troopremark = paramCursor.getString(paramCursor.getColumnIndex("troopremark"));
      paramawge.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
      paramawge.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
      paramawge.faceid = paramCursor.getShort(paramCursor.getColumnIndex("faceid"));
      paramawge.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramawge.sex = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sex")));
      paramawge.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("status")));
      paramawge.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
      paramawge.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
      paramawge.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
      paramawge.level = paramCursor.getInt(paramCursor.getColumnIndex("level"));
      paramawge.realLevel = paramCursor.getInt(paramCursor.getColumnIndex("realLevel"));
      paramawge.mGlamourLevel = paramCursor.getInt(paramCursor.getColumnIndex("mGlamourLevel"));
      paramawge.hotChatGlamourLevel = paramCursor.getInt(paramCursor.getColumnIndex("hotChatGlamourLevel"));
      paramawge.globalTroopLevel = paramCursor.getInt(paramCursor.getColumnIndex("globalTroopLevel"));
      paramawge.join_time = paramCursor.getLong(paramCursor.getColumnIndex("join_time"));
      paramawge.last_active_time = paramCursor.getLong(paramCursor.getColumnIndex("last_active_time"));
      paramawge.active_point = paramCursor.getLong(paramCursor.getColumnIndex("active_point"));
      paramawge.credit_level = paramCursor.getLong(paramCursor.getColumnIndex("credit_level"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isTroopFollowed")))
      {
        paramBoolean = true;
        paramawge.isTroopFollowed = paramBoolean;
        paramawge.distance = paramCursor.getInt(paramCursor.getColumnIndex("distance"));
        paramawge.msgseq = paramCursor.getLong(paramCursor.getColumnIndex("msgseq"));
        paramawge.gagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("gagTimeStamp"));
        paramawge.distanceToSelf = paramCursor.getDouble(paramCursor.getColumnIndex("distanceToSelf"));
        paramawge.distanceToSelfUpdateTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("distanceToSelfUpdateTimeStamp"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mIsShielded"))) {
          break label1053;
        }
      }
      label1053:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramawge.mIsShielded = paramBoolean;
        paramawge.mUniqueTitle = paramCursor.getString(paramCursor.getColumnIndex("mUniqueTitle"));
        paramawge.mUniqueTitleExpire = paramCursor.getInt(paramCursor.getColumnIndex("mUniqueTitleExpire"));
        paramawge.tribeLevel = paramCursor.getInt(paramCursor.getColumnIndex("tribeLevel"));
        paramawge.tribePoint = paramCursor.getInt(paramCursor.getColumnIndex("tribePoint"));
        paramawge.commonFrdCnt = paramCursor.getInt(paramCursor.getColumnIndex("commonFrdCnt"));
        paramawge.hwIdentity = paramCursor.getInt(paramCursor.getColumnIndex("hwIdentity"));
        paramawge.hwCourse = paramCursor.getString(paramCursor.getColumnIndex("hwCourse"));
        paramawge.hwName = paramCursor.getString(paramCursor.getColumnIndex("hwName"));
        paramawge.mVipType = paramCursor.getInt(paramCursor.getColumnIndex("mVipType"));
        paramawge.mVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("mVipLevel"));
        paramawge.mVipTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("mVipTemplateId"));
        paramawge.mBigClubVipType = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubVipType"));
        paramawge.mBigClubVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubVipLevel"));
        paramawge.mBigClubTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubTemplateId"));
        paramawge.recommendRemark = paramCursor.getString(paramCursor.getColumnIndex("recommendRemark"));
        paramawge.isShowQZone = paramCursor.getInt(paramCursor.getColumnIndex("isShowQZone"));
        paramawge.mIsHideBigClub = paramCursor.getInt(paramCursor.getColumnIndex("mIsHideBigClub"));
        paramawge.honorList = paramCursor.getString(paramCursor.getColumnIndex("honorList"));
        return paramawge;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("troopuin");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("troopuin", String.class));
      i = paramCursor.getColumnIndex("memberuin");
      if (i != -1) {
        break label3043;
      }
      paramawgp.a(new NoColumnError("memberuin", String.class));
      label1128:
      i = paramCursor.getColumnIndex("friendnick");
      if (i != -1) {
        break label3058;
      }
      paramawgp.a(new NoColumnError("friendnick", String.class));
      label1163:
      i = paramCursor.getColumnIndex("pyAll_friendnick");
      if (i != -1) {
        break label3073;
      }
      paramawgp.a(new NoColumnError("pyAll_friendnick", String.class));
      label1198:
      i = paramCursor.getColumnIndex("pyFirst_friendnick");
      if (i != -1) {
        break label3088;
      }
      paramawgp.a(new NoColumnError("pyFirst_friendnick", String.class));
      label1233:
      i = paramCursor.getColumnIndex("troopnick");
      if (i != -1) {
        break label3103;
      }
      paramawgp.a(new NoColumnError("troopnick", String.class));
      label1268:
      i = paramCursor.getColumnIndex("troopColorNick");
      if (i != -1) {
        break label3118;
      }
      paramawgp.a(new NoColumnError("troopColorNick", String.class));
      label1303:
      i = paramCursor.getColumnIndex("pyAll_troopnick");
      if (i != -1) {
        break label3133;
      }
      paramawgp.a(new NoColumnError("pyAll_troopnick", String.class));
      label1338:
      i = paramCursor.getColumnIndex("pyFirst_troopnick");
      if (i != -1) {
        break label3148;
      }
      paramawgp.a(new NoColumnError("pyFirst_troopnick", String.class));
      label1373:
      i = paramCursor.getColumnIndex("autoremark");
      if (i != -1) {
        break label3163;
      }
      paramawgp.a(new NoColumnError("autoremark", String.class));
      label1408:
      i = paramCursor.getColumnIndex("pyAll_autoremark");
      if (i != -1) {
        break label3178;
      }
      paramawgp.a(new NoColumnError("pyAll_autoremark", String.class));
      label1443:
      i = paramCursor.getColumnIndex("pyFirst_autoremark");
      if (i != -1) {
        break label3193;
      }
      paramawgp.a(new NoColumnError("pyFirst_autoremark", String.class));
      label1478:
      i = paramCursor.getColumnIndex("troopremark");
      if (i != -1) {
        break label3208;
      }
      paramawgp.a(new NoColumnError("troopremark", String.class));
      label1513:
      i = paramCursor.getColumnIndex("alias");
      if (i != -1) {
        break label3223;
      }
      paramawgp.a(new NoColumnError("alias", String.class));
      label1548:
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label3238;
      }
      paramawgp.a(new NoColumnError("datetime", Long.TYPE));
      label1583:
      i = paramCursor.getColumnIndex("faceid");
      if (i != -1) {
        break label3253;
      }
      paramawgp.a(new NoColumnError("faceid", Short.TYPE));
      label1618:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label3268;
      }
      paramawgp.a(new NoColumnError("age", Byte.TYPE));
      label1653:
      i = paramCursor.getColumnIndex("sex");
      if (i != -1) {
        break label3284;
      }
      paramawgp.a(new NoColumnError("sex", Byte.TYPE));
      label1688:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label3300;
      }
      paramawgp.a(new NoColumnError("status", Byte.TYPE));
      label1723:
      i = paramCursor.getColumnIndex("qqVipInfo");
      if (i != -1) {
        break label3316;
      }
      paramawgp.a(new NoColumnError("qqVipInfo", Integer.TYPE));
      label1758:
      i = paramCursor.getColumnIndex("superQqInfo");
      if (i != -1) {
        break label3331;
      }
      paramawgp.a(new NoColumnError("superQqInfo", Integer.TYPE));
      label1793:
      i = paramCursor.getColumnIndex("superVipInfo");
      if (i != -1) {
        break label3346;
      }
      paramawgp.a(new NoColumnError("superVipInfo", Integer.TYPE));
      label1828:
      i = paramCursor.getColumnIndex("level");
      if (i != -1) {
        break label3361;
      }
      paramawgp.a(new NoColumnError("level", Integer.TYPE));
      label1863:
      i = paramCursor.getColumnIndex("realLevel");
      if (i != -1) {
        break label3376;
      }
      paramawgp.a(new NoColumnError("realLevel", Integer.TYPE));
      label1898:
      i = paramCursor.getColumnIndex("mGlamourLevel");
      if (i != -1) {
        break label3391;
      }
      paramawgp.a(new NoColumnError("mGlamourLevel", Integer.TYPE));
      label1933:
      i = paramCursor.getColumnIndex("hotChatGlamourLevel");
      if (i != -1) {
        break label3406;
      }
      paramawgp.a(new NoColumnError("hotChatGlamourLevel", Integer.TYPE));
      label1968:
      i = paramCursor.getColumnIndex("globalTroopLevel");
      if (i != -1) {
        break label3421;
      }
      paramawgp.a(new NoColumnError("globalTroopLevel", Integer.TYPE));
      label2003:
      i = paramCursor.getColumnIndex("join_time");
      if (i != -1) {
        break label3436;
      }
      paramawgp.a(new NoColumnError("join_time", Long.TYPE));
      label2038:
      i = paramCursor.getColumnIndex("last_active_time");
      if (i != -1) {
        break label3451;
      }
      paramawgp.a(new NoColumnError("last_active_time", Long.TYPE));
      label2073:
      i = paramCursor.getColumnIndex("active_point");
      if (i != -1) {
        break label3466;
      }
      paramawgp.a(new NoColumnError("active_point", Long.TYPE));
      label2108:
      i = paramCursor.getColumnIndex("credit_level");
      if (i != -1) {
        break label3481;
      }
      paramawgp.a(new NoColumnError("credit_level", Long.TYPE));
      label2143:
      i = paramCursor.getColumnIndex("isTroopFollowed");
      if (i != -1) {
        break label3496;
      }
      paramawgp.a(new NoColumnError("isTroopFollowed", Boolean.TYPE));
      i = paramCursor.getColumnIndex("distance");
      if (i != -1) {
        break label3523;
      }
      paramawgp.a(new NoColumnError("distance", Integer.TYPE));
      label2213:
      i = paramCursor.getColumnIndex("msgseq");
      if (i != -1) {
        break label3538;
      }
      paramawgp.a(new NoColumnError("msgseq", Long.TYPE));
      label2248:
      i = paramCursor.getColumnIndex("gagTimeStamp");
      if (i != -1) {
        break label3553;
      }
      paramawgp.a(new NoColumnError("gagTimeStamp", Long.TYPE));
      label2283:
      i = paramCursor.getColumnIndex("distanceToSelf");
      if (i != -1) {
        break label3568;
      }
      paramawgp.a(new NoColumnError("distanceToSelf", Double.TYPE));
      label2318:
      i = paramCursor.getColumnIndex("distanceToSelfUpdateTimeStamp");
      if (i != -1) {
        break label3583;
      }
      paramawgp.a(new NoColumnError("distanceToSelfUpdateTimeStamp", Long.TYPE));
      label2353:
      i = paramCursor.getColumnIndex("mIsShielded");
      if (i != -1) {
        break label3598;
      }
      paramawgp.a(new NoColumnError("mIsShielded", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mUniqueTitle");
      if (i != -1) {
        break label3626;
      }
      paramawgp.a(new NoColumnError("mUniqueTitle", String.class));
      label2423:
      i = paramCursor.getColumnIndex("mUniqueTitleExpire");
      if (i != -1) {
        break label3641;
      }
      paramawgp.a(new NoColumnError("mUniqueTitleExpire", Integer.TYPE));
      label2458:
      i = paramCursor.getColumnIndex("tribeLevel");
      if (i != -1) {
        break label3656;
      }
      paramawgp.a(new NoColumnError("tribeLevel", Integer.TYPE));
      label2493:
      i = paramCursor.getColumnIndex("tribePoint");
      if (i != -1) {
        break label3671;
      }
      paramawgp.a(new NoColumnError("tribePoint", Integer.TYPE));
      label2528:
      i = paramCursor.getColumnIndex("commonFrdCnt");
      if (i != -1) {
        break label3686;
      }
      paramawgp.a(new NoColumnError("commonFrdCnt", Integer.TYPE));
      label2563:
      i = paramCursor.getColumnIndex("hwIdentity");
      if (i != -1) {
        break label3701;
      }
      paramawgp.a(new NoColumnError("hwIdentity", Integer.TYPE));
      label2598:
      i = paramCursor.getColumnIndex("hwCourse");
      if (i != -1) {
        break label3716;
      }
      paramawgp.a(new NoColumnError("hwCourse", String.class));
      label2633:
      i = paramCursor.getColumnIndex("hwName");
      if (i != -1) {
        break label3731;
      }
      paramawgp.a(new NoColumnError("hwName", String.class));
      label2668:
      i = paramCursor.getColumnIndex("mVipType");
      if (i != -1) {
        break label3746;
      }
      paramawgp.a(new NoColumnError("mVipType", Integer.TYPE));
      label2703:
      i = paramCursor.getColumnIndex("mVipLevel");
      if (i != -1) {
        break label3761;
      }
      paramawgp.a(new NoColumnError("mVipLevel", Integer.TYPE));
      label2738:
      i = paramCursor.getColumnIndex("mVipTemplateId");
      if (i != -1) {
        break label3776;
      }
      paramawgp.a(new NoColumnError("mVipTemplateId", Integer.TYPE));
      label2773:
      i = paramCursor.getColumnIndex("mBigClubVipType");
      if (i != -1) {
        break label3791;
      }
      paramawgp.a(new NoColumnError("mBigClubVipType", Integer.TYPE));
      label2808:
      i = paramCursor.getColumnIndex("mBigClubVipLevel");
      if (i != -1) {
        break label3806;
      }
      paramawgp.a(new NoColumnError("mBigClubVipLevel", Integer.TYPE));
      label2843:
      i = paramCursor.getColumnIndex("mBigClubTemplateId");
      if (i != -1) {
        break label3821;
      }
      paramawgp.a(new NoColumnError("mBigClubTemplateId", Integer.TYPE));
      label2878:
      i = paramCursor.getColumnIndex("recommendRemark");
      if (i != -1) {
        break label3836;
      }
      paramawgp.a(new NoColumnError("recommendRemark", String.class));
      label2915:
      i = paramCursor.getColumnIndex("isShowQZone");
      if (i != -1) {
        break label3851;
      }
      paramawgp.a(new NoColumnError("isShowQZone", Integer.TYPE));
      label2952:
      i = paramCursor.getColumnIndex("mIsHideBigClub");
      if (i != -1) {
        break label3866;
      }
      paramawgp.a(new NoColumnError("mIsHideBigClub", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("honorList");
      if (i != -1) {
        break label3881;
      }
      paramawgp.a(new NoColumnError("honorList", String.class));
      return paramawge;
      paramawge.troopuin = paramCursor.getString(i);
      break;
      label3043:
      paramawge.memberuin = paramCursor.getString(i);
      break label1128;
      label3058:
      paramawge.friendnick = paramCursor.getString(i);
      break label1163;
      label3073:
      paramawge.pyAll_friendnick = paramCursor.getString(i);
      break label1198;
      label3088:
      paramawge.pyFirst_friendnick = paramCursor.getString(i);
      break label1233;
      label3103:
      paramawge.troopnick = paramCursor.getString(i);
      break label1268;
      label3118:
      paramawge.troopColorNick = paramCursor.getString(i);
      break label1303;
      label3133:
      paramawge.pyAll_troopnick = paramCursor.getString(i);
      break label1338;
      label3148:
      paramawge.pyFirst_troopnick = paramCursor.getString(i);
      break label1373;
      label3163:
      paramawge.autoremark = paramCursor.getString(i);
      break label1408;
      label3178:
      paramawge.pyAll_autoremark = paramCursor.getString(i);
      break label1443;
      label3193:
      paramawge.pyFirst_autoremark = paramCursor.getString(i);
      break label1478;
      label3208:
      paramawge.troopremark = paramCursor.getString(i);
      break label1513;
      label3223:
      paramawge.alias = paramCursor.getString(i);
      break label1548;
      label3238:
      paramawge.datetime = paramCursor.getLong(i);
      break label1583;
      label3253:
      paramawge.faceid = paramCursor.getShort(i);
      break label1618;
      label3268:
      paramawge.age = ((byte)paramCursor.getShort(i));
      break label1653;
      label3284:
      paramawge.sex = ((byte)paramCursor.getShort(i));
      break label1688;
      label3300:
      paramawge.status = ((byte)paramCursor.getShort(i));
      break label1723;
      label3316:
      paramawge.qqVipInfo = paramCursor.getInt(i);
      break label1758;
      label3331:
      paramawge.superQqInfo = paramCursor.getInt(i);
      break label1793;
      label3346:
      paramawge.superVipInfo = paramCursor.getInt(i);
      break label1828;
      label3361:
      paramawge.level = paramCursor.getInt(i);
      break label1863;
      label3376:
      paramawge.realLevel = paramCursor.getInt(i);
      break label1898;
      label3391:
      paramawge.mGlamourLevel = paramCursor.getInt(i);
      break label1933;
      label3406:
      paramawge.hotChatGlamourLevel = paramCursor.getInt(i);
      break label1968;
      label3421:
      paramawge.globalTroopLevel = paramCursor.getInt(i);
      break label2003;
      label3436:
      paramawge.join_time = paramCursor.getLong(i);
      break label2038;
      label3451:
      paramawge.last_active_time = paramCursor.getLong(i);
      break label2073;
      label3466:
      paramawge.active_point = paramCursor.getLong(i);
      break label2108;
      label3481:
      paramawge.credit_level = paramCursor.getLong(i);
      break label2143;
      label3496:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isTroopFollowed = paramBoolean;
        break;
      }
      label3523:
      paramawge.distance = paramCursor.getInt(i);
      break label2213;
      label3538:
      paramawge.msgseq = paramCursor.getLong(i);
      break label2248;
      label3553:
      paramawge.gagTimeStamp = paramCursor.getLong(i);
      break label2283;
      label3568:
      paramawge.distanceToSelf = paramCursor.getDouble(i);
      break label2318;
      label3583:
      paramawge.distanceToSelfUpdateTimeStamp = paramCursor.getLong(i);
      break label2353;
      label3598:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramawge.mIsShielded = paramBoolean;
        break;
      }
      label3626:
      paramawge.mUniqueTitle = paramCursor.getString(i);
      break label2423;
      label3641:
      paramawge.mUniqueTitleExpire = paramCursor.getInt(i);
      break label2458;
      label3656:
      paramawge.tribeLevel = paramCursor.getInt(i);
      break label2493;
      label3671:
      paramawge.tribePoint = paramCursor.getInt(i);
      break label2528;
      label3686:
      paramawge.commonFrdCnt = paramCursor.getInt(i);
      break label2563;
      label3701:
      paramawge.hwIdentity = paramCursor.getInt(i);
      break label2598;
      label3716:
      paramawge.hwCourse = paramCursor.getString(i);
      break label2633;
      label3731:
      paramawge.hwName = paramCursor.getString(i);
      break label2668;
      label3746:
      paramawge.mVipType = paramCursor.getInt(i);
      break label2703;
      label3761:
      paramawge.mVipLevel = paramCursor.getInt(i);
      break label2738;
      label3776:
      paramawge.mVipTemplateId = paramCursor.getInt(i);
      break label2773;
      label3791:
      paramawge.mBigClubVipType = paramCursor.getInt(i);
      break label2808;
      label3806:
      paramawge.mBigClubVipLevel = paramCursor.getInt(i);
      break label2843;
      label3821:
      paramawge.mBigClubTemplateId = paramCursor.getInt(i);
      break label2878;
      label3836:
      paramawge.recommendRemark = paramCursor.getString(i);
      break label2915;
      label3851:
      paramawge.isShowQZone = paramCursor.getInt(i);
      break label2952;
      label3866:
      paramawge.mIsHideBigClub = paramCursor.getInt(i);
    }
    label3881:
    paramawge.honorList = paramCursor.getString(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopuin TEXT ,memberuin TEXT ,friendnick TEXT ,pyAll_friendnick TEXT ,pyFirst_friendnick TEXT ,troopnick TEXT ,troopColorNick TEXT ,pyAll_troopnick TEXT ,pyFirst_troopnick TEXT ,autoremark TEXT ,pyAll_autoremark TEXT ,pyFirst_autoremark TEXT ,troopremark TEXT ,alias TEXT ,datetime INTEGER ,faceid INTEGER ,age INTEGER ,sex INTEGER ,status INTEGER ,qqVipInfo INTEGER ,superQqInfo INTEGER ,superVipInfo INTEGER ,level INTEGER ,realLevel INTEGER ,mGlamourLevel INTEGER ,hotChatGlamourLevel INTEGER ,globalTroopLevel INTEGER ,join_time INTEGER ,last_active_time INTEGER ,active_point INTEGER ,credit_level INTEGER ,isTroopFollowed INTEGER ,distance INTEGER ,msgseq INTEGER ,gagTimeStamp INTEGER ,distanceToSelf REAL ,distanceToSelfUpdateTimeStamp INTEGER ,mIsShielded INTEGER ,mUniqueTitle TEXT ,mUniqueTitleExpire INTEGER ,tribeLevel INTEGER ,tribePoint INTEGER ,commonFrdCnt INTEGER ,hwIdentity INTEGER ,hwCourse TEXT ,hwName TEXT ,mVipType INTEGER ,mVipLevel INTEGER ,mVipTemplateId INTEGER ,mBigClubVipType INTEGER ,mBigClubVipLevel INTEGER ,mBigClubTemplateId INTEGER ,recommendRemark TEXT ,isShowQZone INTEGER ,mIsHideBigClub INTEGER ,honorList TEXT,UNIQUE(troopuin,memberuin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (TroopMemberInfo)paramawge;
    paramContentValues.put("troopuin", paramawge.troopuin);
    paramContentValues.put("memberuin", paramawge.memberuin);
    paramContentValues.put("friendnick", paramawge.friendnick);
    paramContentValues.put("pyAll_friendnick", paramawge.pyAll_friendnick);
    paramContentValues.put("pyFirst_friendnick", paramawge.pyFirst_friendnick);
    paramContentValues.put("troopnick", paramawge.troopnick);
    paramContentValues.put("troopColorNick", paramawge.troopColorNick);
    paramContentValues.put("pyAll_troopnick", paramawge.pyAll_troopnick);
    paramContentValues.put("pyFirst_troopnick", paramawge.pyFirst_troopnick);
    paramContentValues.put("autoremark", paramawge.autoremark);
    paramContentValues.put("pyAll_autoremark", paramawge.pyAll_autoremark);
    paramContentValues.put("pyFirst_autoremark", paramawge.pyFirst_autoremark);
    paramContentValues.put("troopremark", paramawge.troopremark);
    paramContentValues.put("alias", paramawge.alias);
    paramContentValues.put("datetime", Long.valueOf(paramawge.datetime));
    paramContentValues.put("faceid", Short.valueOf(paramawge.faceid));
    paramContentValues.put("age", Byte.valueOf(paramawge.age));
    paramContentValues.put("sex", Byte.valueOf(paramawge.sex));
    paramContentValues.put("status", Byte.valueOf(paramawge.status));
    paramContentValues.put("qqVipInfo", Integer.valueOf(paramawge.qqVipInfo));
    paramContentValues.put("superQqInfo", Integer.valueOf(paramawge.superQqInfo));
    paramContentValues.put("superVipInfo", Integer.valueOf(paramawge.superVipInfo));
    paramContentValues.put("level", Integer.valueOf(paramawge.level));
    paramContentValues.put("realLevel", Integer.valueOf(paramawge.realLevel));
    paramContentValues.put("mGlamourLevel", Integer.valueOf(paramawge.mGlamourLevel));
    paramContentValues.put("hotChatGlamourLevel", Integer.valueOf(paramawge.hotChatGlamourLevel));
    paramContentValues.put("globalTroopLevel", Integer.valueOf(paramawge.globalTroopLevel));
    paramContentValues.put("join_time", Long.valueOf(paramawge.join_time));
    paramContentValues.put("last_active_time", Long.valueOf(paramawge.last_active_time));
    paramContentValues.put("active_point", Long.valueOf(paramawge.active_point));
    paramContentValues.put("credit_level", Long.valueOf(paramawge.credit_level));
    paramContentValues.put("isTroopFollowed", Boolean.valueOf(paramawge.isTroopFollowed));
    paramContentValues.put("distance", Integer.valueOf(paramawge.distance));
    paramContentValues.put("msgseq", Long.valueOf(paramawge.msgseq));
    paramContentValues.put("gagTimeStamp", Long.valueOf(paramawge.gagTimeStamp));
    paramContentValues.put("distanceToSelf", Double.valueOf(paramawge.distanceToSelf));
    paramContentValues.put("distanceToSelfUpdateTimeStamp", Long.valueOf(paramawge.distanceToSelfUpdateTimeStamp));
    paramContentValues.put("mIsShielded", Boolean.valueOf(paramawge.mIsShielded));
    paramContentValues.put("mUniqueTitle", paramawge.mUniqueTitle);
    paramContentValues.put("mUniqueTitleExpire", Integer.valueOf(paramawge.mUniqueTitleExpire));
    paramContentValues.put("tribeLevel", Integer.valueOf(paramawge.tribeLevel));
    paramContentValues.put("tribePoint", Integer.valueOf(paramawge.tribePoint));
    paramContentValues.put("commonFrdCnt", Integer.valueOf(paramawge.commonFrdCnt));
    paramContentValues.put("hwIdentity", Integer.valueOf(paramawge.hwIdentity));
    paramContentValues.put("hwCourse", paramawge.hwCourse);
    paramContentValues.put("hwName", paramawge.hwName);
    paramContentValues.put("mVipType", Integer.valueOf(paramawge.mVipType));
    paramContentValues.put("mVipLevel", Integer.valueOf(paramawge.mVipLevel));
    paramContentValues.put("mVipTemplateId", Integer.valueOf(paramawge.mVipTemplateId));
    paramContentValues.put("mBigClubVipType", Integer.valueOf(paramawge.mBigClubVipType));
    paramContentValues.put("mBigClubVipLevel", Integer.valueOf(paramawge.mBigClubVipLevel));
    paramContentValues.put("mBigClubTemplateId", Integer.valueOf(paramawge.mBigClubTemplateId));
    paramContentValues.put("recommendRemark", paramawge.recommendRemark);
    paramContentValues.put("isShowQZone", Integer.valueOf(paramawge.isShowQZone));
    paramContentValues.put("mIsHideBigClub", Integer.valueOf(paramawge.mIsHideBigClub));
    paramContentValues.put("honorList", paramawge.honorList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awhj
 * JD-Core Version:    0.7.0.1
 */