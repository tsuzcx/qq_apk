import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awda
  extends awch
{
  public awda()
  {
    this.a = 56;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawbv = (TroopMemberInfo)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
      paramawbv.memberuin = paramCursor.getString(paramCursor.getColumnIndex("memberuin"));
      paramawbv.friendnick = paramCursor.getString(paramCursor.getColumnIndex("friendnick"));
      paramawbv.pyAll_friendnick = paramCursor.getString(paramCursor.getColumnIndex("pyAll_friendnick"));
      paramawbv.pyFirst_friendnick = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_friendnick"));
      paramawbv.troopnick = paramCursor.getString(paramCursor.getColumnIndex("troopnick"));
      paramawbv.troopColorNick = paramCursor.getString(paramCursor.getColumnIndex("troopColorNick"));
      paramawbv.pyAll_troopnick = paramCursor.getString(paramCursor.getColumnIndex("pyAll_troopnick"));
      paramawbv.pyFirst_troopnick = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_troopnick"));
      paramawbv.autoremark = paramCursor.getString(paramCursor.getColumnIndex("autoremark"));
      paramawbv.pyAll_autoremark = paramCursor.getString(paramCursor.getColumnIndex("pyAll_autoremark"));
      paramawbv.pyFirst_autoremark = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_autoremark"));
      paramawbv.troopremark = paramCursor.getString(paramCursor.getColumnIndex("troopremark"));
      paramawbv.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
      paramawbv.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
      paramawbv.faceid = paramCursor.getShort(paramCursor.getColumnIndex("faceid"));
      paramawbv.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramawbv.sex = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sex")));
      paramawbv.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("status")));
      paramawbv.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
      paramawbv.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
      paramawbv.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
      paramawbv.level = paramCursor.getInt(paramCursor.getColumnIndex("level"));
      paramawbv.realLevel = paramCursor.getInt(paramCursor.getColumnIndex("realLevel"));
      paramawbv.mGlamourLevel = paramCursor.getInt(paramCursor.getColumnIndex("mGlamourLevel"));
      paramawbv.hotChatGlamourLevel = paramCursor.getInt(paramCursor.getColumnIndex("hotChatGlamourLevel"));
      paramawbv.globalTroopLevel = paramCursor.getInt(paramCursor.getColumnIndex("globalTroopLevel"));
      paramawbv.join_time = paramCursor.getLong(paramCursor.getColumnIndex("join_time"));
      paramawbv.last_active_time = paramCursor.getLong(paramCursor.getColumnIndex("last_active_time"));
      paramawbv.active_point = paramCursor.getLong(paramCursor.getColumnIndex("active_point"));
      paramawbv.credit_level = paramCursor.getLong(paramCursor.getColumnIndex("credit_level"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isTroopFollowed")))
      {
        paramBoolean = true;
        paramawbv.isTroopFollowed = paramBoolean;
        paramawbv.distance = paramCursor.getInt(paramCursor.getColumnIndex("distance"));
        paramawbv.msgseq = paramCursor.getLong(paramCursor.getColumnIndex("msgseq"));
        paramawbv.gagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("gagTimeStamp"));
        paramawbv.distanceToSelf = paramCursor.getDouble(paramCursor.getColumnIndex("distanceToSelf"));
        paramawbv.distanceToSelfUpdateTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("distanceToSelfUpdateTimeStamp"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mIsShielded"))) {
          break label1053;
        }
      }
      label1053:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramawbv.mIsShielded = paramBoolean;
        paramawbv.mUniqueTitle = paramCursor.getString(paramCursor.getColumnIndex("mUniqueTitle"));
        paramawbv.mUniqueTitleExpire = paramCursor.getInt(paramCursor.getColumnIndex("mUniqueTitleExpire"));
        paramawbv.tribeLevel = paramCursor.getInt(paramCursor.getColumnIndex("tribeLevel"));
        paramawbv.tribePoint = paramCursor.getInt(paramCursor.getColumnIndex("tribePoint"));
        paramawbv.commonFrdCnt = paramCursor.getInt(paramCursor.getColumnIndex("commonFrdCnt"));
        paramawbv.hwIdentity = paramCursor.getInt(paramCursor.getColumnIndex("hwIdentity"));
        paramawbv.hwCourse = paramCursor.getString(paramCursor.getColumnIndex("hwCourse"));
        paramawbv.hwName = paramCursor.getString(paramCursor.getColumnIndex("hwName"));
        paramawbv.mVipType = paramCursor.getInt(paramCursor.getColumnIndex("mVipType"));
        paramawbv.mVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("mVipLevel"));
        paramawbv.mVipTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("mVipTemplateId"));
        paramawbv.mBigClubVipType = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubVipType"));
        paramawbv.mBigClubVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubVipLevel"));
        paramawbv.mBigClubTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("mBigClubTemplateId"));
        paramawbv.recommendRemark = paramCursor.getString(paramCursor.getColumnIndex("recommendRemark"));
        paramawbv.isShowQZone = paramCursor.getInt(paramCursor.getColumnIndex("isShowQZone"));
        paramawbv.mIsHideBigClub = paramCursor.getInt(paramCursor.getColumnIndex("mIsHideBigClub"));
        paramawbv.honorList = paramCursor.getString(paramCursor.getColumnIndex("honorList"));
        return paramawbv;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("troopuin");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("troopuin", String.class));
      i = paramCursor.getColumnIndex("memberuin");
      if (i != -1) {
        break label3043;
      }
      paramawcg.a(new NoColumnError("memberuin", String.class));
      label1128:
      i = paramCursor.getColumnIndex("friendnick");
      if (i != -1) {
        break label3058;
      }
      paramawcg.a(new NoColumnError("friendnick", String.class));
      label1163:
      i = paramCursor.getColumnIndex("pyAll_friendnick");
      if (i != -1) {
        break label3073;
      }
      paramawcg.a(new NoColumnError("pyAll_friendnick", String.class));
      label1198:
      i = paramCursor.getColumnIndex("pyFirst_friendnick");
      if (i != -1) {
        break label3088;
      }
      paramawcg.a(new NoColumnError("pyFirst_friendnick", String.class));
      label1233:
      i = paramCursor.getColumnIndex("troopnick");
      if (i != -1) {
        break label3103;
      }
      paramawcg.a(new NoColumnError("troopnick", String.class));
      label1268:
      i = paramCursor.getColumnIndex("troopColorNick");
      if (i != -1) {
        break label3118;
      }
      paramawcg.a(new NoColumnError("troopColorNick", String.class));
      label1303:
      i = paramCursor.getColumnIndex("pyAll_troopnick");
      if (i != -1) {
        break label3133;
      }
      paramawcg.a(new NoColumnError("pyAll_troopnick", String.class));
      label1338:
      i = paramCursor.getColumnIndex("pyFirst_troopnick");
      if (i != -1) {
        break label3148;
      }
      paramawcg.a(new NoColumnError("pyFirst_troopnick", String.class));
      label1373:
      i = paramCursor.getColumnIndex("autoremark");
      if (i != -1) {
        break label3163;
      }
      paramawcg.a(new NoColumnError("autoremark", String.class));
      label1408:
      i = paramCursor.getColumnIndex("pyAll_autoremark");
      if (i != -1) {
        break label3178;
      }
      paramawcg.a(new NoColumnError("pyAll_autoremark", String.class));
      label1443:
      i = paramCursor.getColumnIndex("pyFirst_autoremark");
      if (i != -1) {
        break label3193;
      }
      paramawcg.a(new NoColumnError("pyFirst_autoremark", String.class));
      label1478:
      i = paramCursor.getColumnIndex("troopremark");
      if (i != -1) {
        break label3208;
      }
      paramawcg.a(new NoColumnError("troopremark", String.class));
      label1513:
      i = paramCursor.getColumnIndex("alias");
      if (i != -1) {
        break label3223;
      }
      paramawcg.a(new NoColumnError("alias", String.class));
      label1548:
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label3238;
      }
      paramawcg.a(new NoColumnError("datetime", Long.TYPE));
      label1583:
      i = paramCursor.getColumnIndex("faceid");
      if (i != -1) {
        break label3253;
      }
      paramawcg.a(new NoColumnError("faceid", Short.TYPE));
      label1618:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label3268;
      }
      paramawcg.a(new NoColumnError("age", Byte.TYPE));
      label1653:
      i = paramCursor.getColumnIndex("sex");
      if (i != -1) {
        break label3284;
      }
      paramawcg.a(new NoColumnError("sex", Byte.TYPE));
      label1688:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label3300;
      }
      paramawcg.a(new NoColumnError("status", Byte.TYPE));
      label1723:
      i = paramCursor.getColumnIndex("qqVipInfo");
      if (i != -1) {
        break label3316;
      }
      paramawcg.a(new NoColumnError("qqVipInfo", Integer.TYPE));
      label1758:
      i = paramCursor.getColumnIndex("superQqInfo");
      if (i != -1) {
        break label3331;
      }
      paramawcg.a(new NoColumnError("superQqInfo", Integer.TYPE));
      label1793:
      i = paramCursor.getColumnIndex("superVipInfo");
      if (i != -1) {
        break label3346;
      }
      paramawcg.a(new NoColumnError("superVipInfo", Integer.TYPE));
      label1828:
      i = paramCursor.getColumnIndex("level");
      if (i != -1) {
        break label3361;
      }
      paramawcg.a(new NoColumnError("level", Integer.TYPE));
      label1863:
      i = paramCursor.getColumnIndex("realLevel");
      if (i != -1) {
        break label3376;
      }
      paramawcg.a(new NoColumnError("realLevel", Integer.TYPE));
      label1898:
      i = paramCursor.getColumnIndex("mGlamourLevel");
      if (i != -1) {
        break label3391;
      }
      paramawcg.a(new NoColumnError("mGlamourLevel", Integer.TYPE));
      label1933:
      i = paramCursor.getColumnIndex("hotChatGlamourLevel");
      if (i != -1) {
        break label3406;
      }
      paramawcg.a(new NoColumnError("hotChatGlamourLevel", Integer.TYPE));
      label1968:
      i = paramCursor.getColumnIndex("globalTroopLevel");
      if (i != -1) {
        break label3421;
      }
      paramawcg.a(new NoColumnError("globalTroopLevel", Integer.TYPE));
      label2003:
      i = paramCursor.getColumnIndex("join_time");
      if (i != -1) {
        break label3436;
      }
      paramawcg.a(new NoColumnError("join_time", Long.TYPE));
      label2038:
      i = paramCursor.getColumnIndex("last_active_time");
      if (i != -1) {
        break label3451;
      }
      paramawcg.a(new NoColumnError("last_active_time", Long.TYPE));
      label2073:
      i = paramCursor.getColumnIndex("active_point");
      if (i != -1) {
        break label3466;
      }
      paramawcg.a(new NoColumnError("active_point", Long.TYPE));
      label2108:
      i = paramCursor.getColumnIndex("credit_level");
      if (i != -1) {
        break label3481;
      }
      paramawcg.a(new NoColumnError("credit_level", Long.TYPE));
      label2143:
      i = paramCursor.getColumnIndex("isTroopFollowed");
      if (i != -1) {
        break label3496;
      }
      paramawcg.a(new NoColumnError("isTroopFollowed", Boolean.TYPE));
      i = paramCursor.getColumnIndex("distance");
      if (i != -1) {
        break label3523;
      }
      paramawcg.a(new NoColumnError("distance", Integer.TYPE));
      label2213:
      i = paramCursor.getColumnIndex("msgseq");
      if (i != -1) {
        break label3538;
      }
      paramawcg.a(new NoColumnError("msgseq", Long.TYPE));
      label2248:
      i = paramCursor.getColumnIndex("gagTimeStamp");
      if (i != -1) {
        break label3553;
      }
      paramawcg.a(new NoColumnError("gagTimeStamp", Long.TYPE));
      label2283:
      i = paramCursor.getColumnIndex("distanceToSelf");
      if (i != -1) {
        break label3568;
      }
      paramawcg.a(new NoColumnError("distanceToSelf", Double.TYPE));
      label2318:
      i = paramCursor.getColumnIndex("distanceToSelfUpdateTimeStamp");
      if (i != -1) {
        break label3583;
      }
      paramawcg.a(new NoColumnError("distanceToSelfUpdateTimeStamp", Long.TYPE));
      label2353:
      i = paramCursor.getColumnIndex("mIsShielded");
      if (i != -1) {
        break label3598;
      }
      paramawcg.a(new NoColumnError("mIsShielded", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mUniqueTitle");
      if (i != -1) {
        break label3626;
      }
      paramawcg.a(new NoColumnError("mUniqueTitle", String.class));
      label2423:
      i = paramCursor.getColumnIndex("mUniqueTitleExpire");
      if (i != -1) {
        break label3641;
      }
      paramawcg.a(new NoColumnError("mUniqueTitleExpire", Integer.TYPE));
      label2458:
      i = paramCursor.getColumnIndex("tribeLevel");
      if (i != -1) {
        break label3656;
      }
      paramawcg.a(new NoColumnError("tribeLevel", Integer.TYPE));
      label2493:
      i = paramCursor.getColumnIndex("tribePoint");
      if (i != -1) {
        break label3671;
      }
      paramawcg.a(new NoColumnError("tribePoint", Integer.TYPE));
      label2528:
      i = paramCursor.getColumnIndex("commonFrdCnt");
      if (i != -1) {
        break label3686;
      }
      paramawcg.a(new NoColumnError("commonFrdCnt", Integer.TYPE));
      label2563:
      i = paramCursor.getColumnIndex("hwIdentity");
      if (i != -1) {
        break label3701;
      }
      paramawcg.a(new NoColumnError("hwIdentity", Integer.TYPE));
      label2598:
      i = paramCursor.getColumnIndex("hwCourse");
      if (i != -1) {
        break label3716;
      }
      paramawcg.a(new NoColumnError("hwCourse", String.class));
      label2633:
      i = paramCursor.getColumnIndex("hwName");
      if (i != -1) {
        break label3731;
      }
      paramawcg.a(new NoColumnError("hwName", String.class));
      label2668:
      i = paramCursor.getColumnIndex("mVipType");
      if (i != -1) {
        break label3746;
      }
      paramawcg.a(new NoColumnError("mVipType", Integer.TYPE));
      label2703:
      i = paramCursor.getColumnIndex("mVipLevel");
      if (i != -1) {
        break label3761;
      }
      paramawcg.a(new NoColumnError("mVipLevel", Integer.TYPE));
      label2738:
      i = paramCursor.getColumnIndex("mVipTemplateId");
      if (i != -1) {
        break label3776;
      }
      paramawcg.a(new NoColumnError("mVipTemplateId", Integer.TYPE));
      label2773:
      i = paramCursor.getColumnIndex("mBigClubVipType");
      if (i != -1) {
        break label3791;
      }
      paramawcg.a(new NoColumnError("mBigClubVipType", Integer.TYPE));
      label2808:
      i = paramCursor.getColumnIndex("mBigClubVipLevel");
      if (i != -1) {
        break label3806;
      }
      paramawcg.a(new NoColumnError("mBigClubVipLevel", Integer.TYPE));
      label2843:
      i = paramCursor.getColumnIndex("mBigClubTemplateId");
      if (i != -1) {
        break label3821;
      }
      paramawcg.a(new NoColumnError("mBigClubTemplateId", Integer.TYPE));
      label2878:
      i = paramCursor.getColumnIndex("recommendRemark");
      if (i != -1) {
        break label3836;
      }
      paramawcg.a(new NoColumnError("recommendRemark", String.class));
      label2915:
      i = paramCursor.getColumnIndex("isShowQZone");
      if (i != -1) {
        break label3851;
      }
      paramawcg.a(new NoColumnError("isShowQZone", Integer.TYPE));
      label2952:
      i = paramCursor.getColumnIndex("mIsHideBigClub");
      if (i != -1) {
        break label3866;
      }
      paramawcg.a(new NoColumnError("mIsHideBigClub", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("honorList");
      if (i != -1) {
        break label3881;
      }
      paramawcg.a(new NoColumnError("honorList", String.class));
      return paramawbv;
      paramawbv.troopuin = paramCursor.getString(i);
      break;
      label3043:
      paramawbv.memberuin = paramCursor.getString(i);
      break label1128;
      label3058:
      paramawbv.friendnick = paramCursor.getString(i);
      break label1163;
      label3073:
      paramawbv.pyAll_friendnick = paramCursor.getString(i);
      break label1198;
      label3088:
      paramawbv.pyFirst_friendnick = paramCursor.getString(i);
      break label1233;
      label3103:
      paramawbv.troopnick = paramCursor.getString(i);
      break label1268;
      label3118:
      paramawbv.troopColorNick = paramCursor.getString(i);
      break label1303;
      label3133:
      paramawbv.pyAll_troopnick = paramCursor.getString(i);
      break label1338;
      label3148:
      paramawbv.pyFirst_troopnick = paramCursor.getString(i);
      break label1373;
      label3163:
      paramawbv.autoremark = paramCursor.getString(i);
      break label1408;
      label3178:
      paramawbv.pyAll_autoremark = paramCursor.getString(i);
      break label1443;
      label3193:
      paramawbv.pyFirst_autoremark = paramCursor.getString(i);
      break label1478;
      label3208:
      paramawbv.troopremark = paramCursor.getString(i);
      break label1513;
      label3223:
      paramawbv.alias = paramCursor.getString(i);
      break label1548;
      label3238:
      paramawbv.datetime = paramCursor.getLong(i);
      break label1583;
      label3253:
      paramawbv.faceid = paramCursor.getShort(i);
      break label1618;
      label3268:
      paramawbv.age = ((byte)paramCursor.getShort(i));
      break label1653;
      label3284:
      paramawbv.sex = ((byte)paramCursor.getShort(i));
      break label1688;
      label3300:
      paramawbv.status = ((byte)paramCursor.getShort(i));
      break label1723;
      label3316:
      paramawbv.qqVipInfo = paramCursor.getInt(i);
      break label1758;
      label3331:
      paramawbv.superQqInfo = paramCursor.getInt(i);
      break label1793;
      label3346:
      paramawbv.superVipInfo = paramCursor.getInt(i);
      break label1828;
      label3361:
      paramawbv.level = paramCursor.getInt(i);
      break label1863;
      label3376:
      paramawbv.realLevel = paramCursor.getInt(i);
      break label1898;
      label3391:
      paramawbv.mGlamourLevel = paramCursor.getInt(i);
      break label1933;
      label3406:
      paramawbv.hotChatGlamourLevel = paramCursor.getInt(i);
      break label1968;
      label3421:
      paramawbv.globalTroopLevel = paramCursor.getInt(i);
      break label2003;
      label3436:
      paramawbv.join_time = paramCursor.getLong(i);
      break label2038;
      label3451:
      paramawbv.last_active_time = paramCursor.getLong(i);
      break label2073;
      label3466:
      paramawbv.active_point = paramCursor.getLong(i);
      break label2108;
      label3481:
      paramawbv.credit_level = paramCursor.getLong(i);
      break label2143;
      label3496:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isTroopFollowed = paramBoolean;
        break;
      }
      label3523:
      paramawbv.distance = paramCursor.getInt(i);
      break label2213;
      label3538:
      paramawbv.msgseq = paramCursor.getLong(i);
      break label2248;
      label3553:
      paramawbv.gagTimeStamp = paramCursor.getLong(i);
      break label2283;
      label3568:
      paramawbv.distanceToSelf = paramCursor.getDouble(i);
      break label2318;
      label3583:
      paramawbv.distanceToSelfUpdateTimeStamp = paramCursor.getLong(i);
      break label2353;
      label3598:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramawbv.mIsShielded = paramBoolean;
        break;
      }
      label3626:
      paramawbv.mUniqueTitle = paramCursor.getString(i);
      break label2423;
      label3641:
      paramawbv.mUniqueTitleExpire = paramCursor.getInt(i);
      break label2458;
      label3656:
      paramawbv.tribeLevel = paramCursor.getInt(i);
      break label2493;
      label3671:
      paramawbv.tribePoint = paramCursor.getInt(i);
      break label2528;
      label3686:
      paramawbv.commonFrdCnt = paramCursor.getInt(i);
      break label2563;
      label3701:
      paramawbv.hwIdentity = paramCursor.getInt(i);
      break label2598;
      label3716:
      paramawbv.hwCourse = paramCursor.getString(i);
      break label2633;
      label3731:
      paramawbv.hwName = paramCursor.getString(i);
      break label2668;
      label3746:
      paramawbv.mVipType = paramCursor.getInt(i);
      break label2703;
      label3761:
      paramawbv.mVipLevel = paramCursor.getInt(i);
      break label2738;
      label3776:
      paramawbv.mVipTemplateId = paramCursor.getInt(i);
      break label2773;
      label3791:
      paramawbv.mBigClubVipType = paramCursor.getInt(i);
      break label2808;
      label3806:
      paramawbv.mBigClubVipLevel = paramCursor.getInt(i);
      break label2843;
      label3821:
      paramawbv.mBigClubTemplateId = paramCursor.getInt(i);
      break label2878;
      label3836:
      paramawbv.recommendRemark = paramCursor.getString(i);
      break label2915;
      label3851:
      paramawbv.isShowQZone = paramCursor.getInt(i);
      break label2952;
      label3866:
      paramawbv.mIsHideBigClub = paramCursor.getInt(i);
    }
    label3881:
    paramawbv.honorList = paramCursor.getString(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopuin TEXT ,memberuin TEXT ,friendnick TEXT ,pyAll_friendnick TEXT ,pyFirst_friendnick TEXT ,troopnick TEXT ,troopColorNick TEXT ,pyAll_troopnick TEXT ,pyFirst_troopnick TEXT ,autoremark TEXT ,pyAll_autoremark TEXT ,pyFirst_autoremark TEXT ,troopremark TEXT ,alias TEXT ,datetime INTEGER ,faceid INTEGER ,age INTEGER ,sex INTEGER ,status INTEGER ,qqVipInfo INTEGER ,superQqInfo INTEGER ,superVipInfo INTEGER ,level INTEGER ,realLevel INTEGER ,mGlamourLevel INTEGER ,hotChatGlamourLevel INTEGER ,globalTroopLevel INTEGER ,join_time INTEGER ,last_active_time INTEGER ,active_point INTEGER ,credit_level INTEGER ,isTroopFollowed INTEGER ,distance INTEGER ,msgseq INTEGER ,gagTimeStamp INTEGER ,distanceToSelf REAL ,distanceToSelfUpdateTimeStamp INTEGER ,mIsShielded INTEGER ,mUniqueTitle TEXT ,mUniqueTitleExpire INTEGER ,tribeLevel INTEGER ,tribePoint INTEGER ,commonFrdCnt INTEGER ,hwIdentity INTEGER ,hwCourse TEXT ,hwName TEXT ,mVipType INTEGER ,mVipLevel INTEGER ,mVipTemplateId INTEGER ,mBigClubVipType INTEGER ,mBigClubVipLevel INTEGER ,mBigClubTemplateId INTEGER ,recommendRemark TEXT ,isShowQZone INTEGER ,mIsHideBigClub INTEGER ,honorList TEXT,UNIQUE(troopuin,memberuin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (TroopMemberInfo)paramawbv;
    paramContentValues.put("troopuin", paramawbv.troopuin);
    paramContentValues.put("memberuin", paramawbv.memberuin);
    paramContentValues.put("friendnick", paramawbv.friendnick);
    paramContentValues.put("pyAll_friendnick", paramawbv.pyAll_friendnick);
    paramContentValues.put("pyFirst_friendnick", paramawbv.pyFirst_friendnick);
    paramContentValues.put("troopnick", paramawbv.troopnick);
    paramContentValues.put("troopColorNick", paramawbv.troopColorNick);
    paramContentValues.put("pyAll_troopnick", paramawbv.pyAll_troopnick);
    paramContentValues.put("pyFirst_troopnick", paramawbv.pyFirst_troopnick);
    paramContentValues.put("autoremark", paramawbv.autoremark);
    paramContentValues.put("pyAll_autoremark", paramawbv.pyAll_autoremark);
    paramContentValues.put("pyFirst_autoremark", paramawbv.pyFirst_autoremark);
    paramContentValues.put("troopremark", paramawbv.troopremark);
    paramContentValues.put("alias", paramawbv.alias);
    paramContentValues.put("datetime", Long.valueOf(paramawbv.datetime));
    paramContentValues.put("faceid", Short.valueOf(paramawbv.faceid));
    paramContentValues.put("age", Byte.valueOf(paramawbv.age));
    paramContentValues.put("sex", Byte.valueOf(paramawbv.sex));
    paramContentValues.put("status", Byte.valueOf(paramawbv.status));
    paramContentValues.put("qqVipInfo", Integer.valueOf(paramawbv.qqVipInfo));
    paramContentValues.put("superQqInfo", Integer.valueOf(paramawbv.superQqInfo));
    paramContentValues.put("superVipInfo", Integer.valueOf(paramawbv.superVipInfo));
    paramContentValues.put("level", Integer.valueOf(paramawbv.level));
    paramContentValues.put("realLevel", Integer.valueOf(paramawbv.realLevel));
    paramContentValues.put("mGlamourLevel", Integer.valueOf(paramawbv.mGlamourLevel));
    paramContentValues.put("hotChatGlamourLevel", Integer.valueOf(paramawbv.hotChatGlamourLevel));
    paramContentValues.put("globalTroopLevel", Integer.valueOf(paramawbv.globalTroopLevel));
    paramContentValues.put("join_time", Long.valueOf(paramawbv.join_time));
    paramContentValues.put("last_active_time", Long.valueOf(paramawbv.last_active_time));
    paramContentValues.put("active_point", Long.valueOf(paramawbv.active_point));
    paramContentValues.put("credit_level", Long.valueOf(paramawbv.credit_level));
    paramContentValues.put("isTroopFollowed", Boolean.valueOf(paramawbv.isTroopFollowed));
    paramContentValues.put("distance", Integer.valueOf(paramawbv.distance));
    paramContentValues.put("msgseq", Long.valueOf(paramawbv.msgseq));
    paramContentValues.put("gagTimeStamp", Long.valueOf(paramawbv.gagTimeStamp));
    paramContentValues.put("distanceToSelf", Double.valueOf(paramawbv.distanceToSelf));
    paramContentValues.put("distanceToSelfUpdateTimeStamp", Long.valueOf(paramawbv.distanceToSelfUpdateTimeStamp));
    paramContentValues.put("mIsShielded", Boolean.valueOf(paramawbv.mIsShielded));
    paramContentValues.put("mUniqueTitle", paramawbv.mUniqueTitle);
    paramContentValues.put("mUniqueTitleExpire", Integer.valueOf(paramawbv.mUniqueTitleExpire));
    paramContentValues.put("tribeLevel", Integer.valueOf(paramawbv.tribeLevel));
    paramContentValues.put("tribePoint", Integer.valueOf(paramawbv.tribePoint));
    paramContentValues.put("commonFrdCnt", Integer.valueOf(paramawbv.commonFrdCnt));
    paramContentValues.put("hwIdentity", Integer.valueOf(paramawbv.hwIdentity));
    paramContentValues.put("hwCourse", paramawbv.hwCourse);
    paramContentValues.put("hwName", paramawbv.hwName);
    paramContentValues.put("mVipType", Integer.valueOf(paramawbv.mVipType));
    paramContentValues.put("mVipLevel", Integer.valueOf(paramawbv.mVipLevel));
    paramContentValues.put("mVipTemplateId", Integer.valueOf(paramawbv.mVipTemplateId));
    paramContentValues.put("mBigClubVipType", Integer.valueOf(paramawbv.mBigClubVipType));
    paramContentValues.put("mBigClubVipLevel", Integer.valueOf(paramawbv.mBigClubVipLevel));
    paramContentValues.put("mBigClubTemplateId", Integer.valueOf(paramawbv.mBigClubTemplateId));
    paramContentValues.put("recommendRemark", paramawbv.recommendRemark);
    paramContentValues.put("isShowQZone", Integer.valueOf(paramawbv.isShowQZone));
    paramContentValues.put("mIsHideBigClub", Integer.valueOf(paramawbv.mIsHideBigClub));
    paramContentValues.put("honorList", paramawbv.honorList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awda
 * JD-Core Version:    0.7.0.1
 */