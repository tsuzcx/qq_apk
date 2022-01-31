import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.persistence.NoColumnError;

public class auku
  extends aula
{
  public auku()
  {
    this.a = 56;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramauko = (Friends)paramauko;
    if (paramaukz == null)
    {
      paramauko.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramauko.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramauko.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramauko.faceid = paramCursor.getShort(paramCursor.getColumnIndex("faceid"));
      paramauko.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("status")));
      paramauko.sqqtype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sqqtype")));
      paramauko.cSpecialFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSpecialFlag")));
      paramauko.groupid = paramCursor.getInt(paramCursor.getColumnIndex("groupid"));
      paramauko.memberLevel = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("memberLevel")));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isMqqOnLine")))
      {
        paramBoolean = true;
        paramauko.isMqqOnLine = paramBoolean;
        paramauko.sqqOnLineState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sqqOnLineState")));
        paramauko.detalStatusFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("detalStatusFlag")));
        paramauko.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
        paramauko.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
        paramauko.gathtertype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gathtertype")));
        paramauko.smartRemark = paramCursor.getString(paramCursor.getColumnIndex("smartRemark"));
        paramauko.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
        paramauko.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
        paramauko.recommReason = paramCursor.getString(paramCursor.getColumnIndex("recommReason"));
        paramauko.signature = paramCursor.getString(paramCursor.getColumnIndex("signature"));
        paramauko.isIphoneOnline = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isIphoneOnline")));
        paramauko.isRemark = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isRemark")));
        paramauko.iTermType = paramCursor.getInt(paramCursor.getColumnIndex("iTermType"));
        paramauko.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
        paramauko.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
        paramauko.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
        paramauko.hollywoodVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("hollywoodVipInfo"));
        paramauko.lastLoginType = paramCursor.getLong(paramCursor.getColumnIndex("lastLoginType"));
        paramauko.showLoginClient = paramCursor.getLong(paramCursor.getColumnIndex("showLoginClient"));
        paramauko.medalsInfo = paramCursor.getString(paramCursor.getColumnIndex("medalsInfo"));
        paramauko.nameplateCfgInfo = paramCursor.getString(paramCursor.getColumnIndex("nameplateCfgInfo"));
        paramauko.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
        paramauko.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
        paramauko.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramauko.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramauko.cNetwork = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cNetwork")));
        paramauko.eNetwork = paramCursor.getInt(paramCursor.getColumnIndex("eNetwork"));
        paramauko.namePlateOfKingGameId = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingGameId"));
        paramauko.namePlateOfKingLoginTime = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingLoginTime"));
        paramauko.namePlateOfKingDan = paramCursor.getInt(paramCursor.getColumnIndex("namePlateOfKingDan"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch"))) {
          break label1061;
        }
      }
      label1061:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramauko.namePlateOfKingDanDisplatSwitch = paramBoolean;
        paramauko.strMasterUin = paramCursor.getString(paramCursor.getColumnIndex("strMasterUin"));
        paramauko.multiFlags = paramCursor.getInt(paramCursor.getColumnIndex("multiFlags"));
        paramauko.friendType = paramCursor.getInt(paramCursor.getColumnIndex("friendType"));
        paramauko.abilityBits = paramCursor.getLong(paramCursor.getColumnIndex("abilityBits"));
        paramauko.bigClubInfo = paramCursor.getInt(paramCursor.getColumnIndex("bigClubInfo"));
        paramauko.superVipTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("superVipTemplateId"));
        paramauko.bigClubTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("bigClubTemplateId"));
        paramauko.nameplateVipType = paramCursor.getInt(paramCursor.getColumnIndex("nameplateVipType"));
        paramauko.grayNameplateFlag = paramCursor.getInt(paramCursor.getColumnIndex("grayNameplateFlag"));
        paramauko.isHideBigClub = paramCursor.getInt(paramCursor.getColumnIndex("isHideBigClub"));
        paramauko.cNewLoverDiamondFlag = paramCursor.getInt(paramCursor.getColumnIndex("cNewLoverDiamondFlag"));
        paramauko.relationIconFlag = paramCursor.getInt(paramCursor.getColumnIndex("relationIconFlag"));
        paramauko.uExtOnlineStatus = paramCursor.getLong(paramCursor.getColumnIndex("uExtOnlineStatus"));
        paramauko.iBatteryStatus = paramCursor.getInt(paramCursor.getColumnIndex("iBatteryStatus"));
        paramauko.customModel = paramCursor.getString(paramCursor.getColumnIndex("customModel"));
        return paramauko;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label3051;
      }
      paramaukz.a(new NoColumnError("remark", String.class));
      label1136:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label3066;
      }
      paramaukz.a(new NoColumnError("name", String.class));
      label1171:
      i = paramCursor.getColumnIndex("faceid");
      if (i != -1) {
        break label3081;
      }
      paramaukz.a(new NoColumnError("faceid", Short.TYPE));
      label1206:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label3096;
      }
      paramaukz.a(new NoColumnError("status", Byte.TYPE));
      label1241:
      i = paramCursor.getColumnIndex("sqqtype");
      if (i != -1) {
        break label3112;
      }
      paramaukz.a(new NoColumnError("sqqtype", Byte.TYPE));
      label1276:
      i = paramCursor.getColumnIndex("cSpecialFlag");
      if (i != -1) {
        break label3128;
      }
      paramaukz.a(new NoColumnError("cSpecialFlag", Byte.TYPE));
      label1311:
      i = paramCursor.getColumnIndex("groupid");
      if (i != -1) {
        break label3144;
      }
      paramaukz.a(new NoColumnError("groupid", Integer.TYPE));
      label1346:
      i = paramCursor.getColumnIndex("memberLevel");
      if (i != -1) {
        break label3159;
      }
      paramaukz.a(new NoColumnError("memberLevel", Byte.TYPE));
      label1381:
      i = paramCursor.getColumnIndex("isMqqOnLine");
      if (i != -1) {
        break label3175;
      }
      paramaukz.a(new NoColumnError("isMqqOnLine", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sqqOnLineState");
      if (i != -1) {
        break label3202;
      }
      paramaukz.a(new NoColumnError("sqqOnLineState", Byte.TYPE));
      label1451:
      i = paramCursor.getColumnIndex("detalStatusFlag");
      if (i != -1) {
        break label3218;
      }
      paramaukz.a(new NoColumnError("detalStatusFlag", Byte.TYPE));
      label1486:
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label3234;
      }
      paramaukz.a(new NoColumnError("datetime", Long.TYPE));
      label1521:
      i = paramCursor.getColumnIndex("alias");
      if (i != -1) {
        break label3249;
      }
      paramaukz.a(new NoColumnError("alias", String.class));
      label1556:
      i = paramCursor.getColumnIndex("gathtertype");
      if (i != -1) {
        break label3264;
      }
      paramaukz.a(new NoColumnError("gathtertype", Byte.TYPE));
      label1591:
      i = paramCursor.getColumnIndex("smartRemark");
      if (i != -1) {
        break label3280;
      }
      paramaukz.a(new NoColumnError("smartRemark", String.class));
      label1626:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label3295;
      }
      paramaukz.a(new NoColumnError("age", Integer.TYPE));
      label1661:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label3310;
      }
      paramaukz.a(new NoColumnError("gender", Byte.TYPE));
      label1696:
      i = paramCursor.getColumnIndex("recommReason");
      if (i != -1) {
        break label3326;
      }
      paramaukz.a(new NoColumnError("recommReason", String.class));
      label1731:
      i = paramCursor.getColumnIndex("signature");
      if (i != -1) {
        break label3341;
      }
      paramaukz.a(new NoColumnError("signature", String.class));
      label1766:
      i = paramCursor.getColumnIndex("isIphoneOnline");
      if (i != -1) {
        break label3356;
      }
      paramaukz.a(new NoColumnError("isIphoneOnline", Byte.TYPE));
      label1801:
      i = paramCursor.getColumnIndex("isRemark");
      if (i != -1) {
        break label3372;
      }
      paramaukz.a(new NoColumnError("isRemark", Byte.TYPE));
      label1836:
      i = paramCursor.getColumnIndex("iTermType");
      if (i != -1) {
        break label3388;
      }
      paramaukz.a(new NoColumnError("iTermType", Integer.TYPE));
      label1871:
      i = paramCursor.getColumnIndex("qqVipInfo");
      if (i != -1) {
        break label3403;
      }
      paramaukz.a(new NoColumnError("qqVipInfo", Integer.TYPE));
      label1906:
      i = paramCursor.getColumnIndex("superQqInfo");
      if (i != -1) {
        break label3418;
      }
      paramaukz.a(new NoColumnError("superQqInfo", Integer.TYPE));
      label1941:
      i = paramCursor.getColumnIndex("superVipInfo");
      if (i != -1) {
        break label3433;
      }
      paramaukz.a(new NoColumnError("superVipInfo", Integer.TYPE));
      label1976:
      i = paramCursor.getColumnIndex("hollywoodVipInfo");
      if (i != -1) {
        break label3448;
      }
      paramaukz.a(new NoColumnError("hollywoodVipInfo", Integer.TYPE));
      label2011:
      i = paramCursor.getColumnIndex("lastLoginType");
      if (i != -1) {
        break label3463;
      }
      paramaukz.a(new NoColumnError("lastLoginType", Long.TYPE));
      label2046:
      i = paramCursor.getColumnIndex("showLoginClient");
      if (i != -1) {
        break label3478;
      }
      paramaukz.a(new NoColumnError("showLoginClient", Long.TYPE));
      label2081:
      i = paramCursor.getColumnIndex("medalsInfo");
      if (i != -1) {
        break label3493;
      }
      paramaukz.a(new NoColumnError("medalsInfo", String.class));
      label2116:
      i = paramCursor.getColumnIndex("nameplateCfgInfo");
      if (i != -1) {
        break label3508;
      }
      paramaukz.a(new NoColumnError("nameplateCfgInfo", String.class));
      label2151:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label3523;
      }
      paramaukz.a(new NoColumnError("richTime", Long.TYPE));
      label2186:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label3538;
      }
      paramaukz.a(new NoColumnError("richBuffer", [B.class));
      label2221:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label3553;
      }
      paramaukz.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label2256:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label3568;
      }
      paramaukz.a(new NoColumnError("mCompareSpell", String.class));
      label2291:
      i = paramCursor.getColumnIndex("cNetwork");
      if (i != -1) {
        break label3583;
      }
      paramaukz.a(new NoColumnError("cNetwork", Byte.TYPE));
      label2326:
      i = paramCursor.getColumnIndex("eNetwork");
      if (i != -1) {
        break label3599;
      }
      paramaukz.a(new NoColumnError("eNetwork", Integer.TYPE));
      label2361:
      i = paramCursor.getColumnIndex("namePlateOfKingGameId");
      if (i != -1) {
        break label3614;
      }
      paramaukz.a(new NoColumnError("namePlateOfKingGameId", Long.TYPE));
      label2396:
      i = paramCursor.getColumnIndex("namePlateOfKingLoginTime");
      if (i != -1) {
        break label3629;
      }
      paramaukz.a(new NoColumnError("namePlateOfKingLoginTime", Long.TYPE));
      label2431:
      i = paramCursor.getColumnIndex("namePlateOfKingDan");
      if (i != -1) {
        break label3644;
      }
      paramaukz.a(new NoColumnError("namePlateOfKingDan", Integer.TYPE));
      label2466:
      i = paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch");
      if (i != -1) {
        break label3659;
      }
      paramaukz.a(new NoColumnError("namePlateOfKingDanDisplatSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("strMasterUin");
      if (i != -1) {
        break label3687;
      }
      paramaukz.a(new NoColumnError("strMasterUin", String.class));
      label2536:
      i = paramCursor.getColumnIndex("multiFlags");
      if (i != -1) {
        break label3702;
      }
      paramaukz.a(new NoColumnError("multiFlags", Integer.TYPE));
      label2571:
      i = paramCursor.getColumnIndex("friendType");
      if (i != -1) {
        break label3717;
      }
      paramaukz.a(new NoColumnError("friendType", Integer.TYPE));
      label2606:
      i = paramCursor.getColumnIndex("abilityBits");
      if (i != -1) {
        break label3732;
      }
      paramaukz.a(new NoColumnError("abilityBits", Long.TYPE));
      label2641:
      i = paramCursor.getColumnIndex("bigClubInfo");
      if (i != -1) {
        break label3747;
      }
      paramaukz.a(new NoColumnError("bigClubInfo", Integer.TYPE));
      label2676:
      i = paramCursor.getColumnIndex("superVipTemplateId");
      if (i != -1) {
        break label3762;
      }
      paramaukz.a(new NoColumnError("superVipTemplateId", Integer.TYPE));
      label2711:
      i = paramCursor.getColumnIndex("bigClubTemplateId");
      if (i != -1) {
        break label3777;
      }
      paramaukz.a(new NoColumnError("bigClubTemplateId", Integer.TYPE));
      label2746:
      i = paramCursor.getColumnIndex("nameplateVipType");
      if (i != -1) {
        break label3792;
      }
      paramaukz.a(new NoColumnError("nameplateVipType", Integer.TYPE));
      label2781:
      i = paramCursor.getColumnIndex("grayNameplateFlag");
      if (i != -1) {
        break label3807;
      }
      paramaukz.a(new NoColumnError("grayNameplateFlag", Integer.TYPE));
      label2816:
      i = paramCursor.getColumnIndex("isHideBigClub");
      if (i != -1) {
        break label3822;
      }
      paramaukz.a(new NoColumnError("isHideBigClub", Integer.TYPE));
      label2851:
      i = paramCursor.getColumnIndex("cNewLoverDiamondFlag");
      if (i != -1) {
        break label3837;
      }
      paramaukz.a(new NoColumnError("cNewLoverDiamondFlag", Integer.TYPE));
      label2886:
      i = paramCursor.getColumnIndex("relationIconFlag");
      if (i != -1) {
        break label3852;
      }
      paramaukz.a(new NoColumnError("relationIconFlag", Integer.TYPE));
      label2923:
      i = paramCursor.getColumnIndex("uExtOnlineStatus");
      if (i != -1) {
        break label3867;
      }
      paramaukz.a(new NoColumnError("uExtOnlineStatus", Long.TYPE));
      label2960:
      i = paramCursor.getColumnIndex("iBatteryStatus");
      if (i != -1) {
        break label3882;
      }
      paramaukz.a(new NoColumnError("iBatteryStatus", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("customModel");
      if (i != -1) {
        break label3897;
      }
      paramaukz.a(new NoColumnError("customModel", String.class));
      return paramauko;
      paramauko.uin = paramCursor.getString(i);
      break;
      label3051:
      paramauko.remark = paramCursor.getString(i);
      break label1136;
      label3066:
      paramauko.name = paramCursor.getString(i);
      break label1171;
      label3081:
      paramauko.faceid = paramCursor.getShort(i);
      break label1206;
      label3096:
      paramauko.status = ((byte)paramCursor.getShort(i));
      break label1241;
      label3112:
      paramauko.sqqtype = ((byte)paramCursor.getShort(i));
      break label1276;
      label3128:
      paramauko.cSpecialFlag = ((byte)paramCursor.getShort(i));
      break label1311;
      label3144:
      paramauko.groupid = paramCursor.getInt(i);
      break label1346;
      label3159:
      paramauko.memberLevel = ((byte)paramCursor.getShort(i));
      break label1381;
      label3175:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isMqqOnLine = paramBoolean;
        break;
      }
      label3202:
      paramauko.sqqOnLineState = ((byte)paramCursor.getShort(i));
      break label1451;
      label3218:
      paramauko.detalStatusFlag = ((byte)paramCursor.getShort(i));
      break label1486;
      label3234:
      paramauko.datetime = paramCursor.getLong(i);
      break label1521;
      label3249:
      paramauko.alias = paramCursor.getString(i);
      break label1556;
      label3264:
      paramauko.gathtertype = ((byte)paramCursor.getShort(i));
      break label1591;
      label3280:
      paramauko.smartRemark = paramCursor.getString(i);
      break label1626;
      label3295:
      paramauko.age = paramCursor.getInt(i);
      break label1661;
      label3310:
      paramauko.gender = ((byte)paramCursor.getShort(i));
      break label1696;
      label3326:
      paramauko.recommReason = paramCursor.getString(i);
      break label1731;
      label3341:
      paramauko.signature = paramCursor.getString(i);
      break label1766;
      label3356:
      paramauko.isIphoneOnline = ((byte)paramCursor.getShort(i));
      break label1801;
      label3372:
      paramauko.isRemark = ((byte)paramCursor.getShort(i));
      break label1836;
      label3388:
      paramauko.iTermType = paramCursor.getInt(i);
      break label1871;
      label3403:
      paramauko.qqVipInfo = paramCursor.getInt(i);
      break label1906;
      label3418:
      paramauko.superQqInfo = paramCursor.getInt(i);
      break label1941;
      label3433:
      paramauko.superVipInfo = paramCursor.getInt(i);
      break label1976;
      label3448:
      paramauko.hollywoodVipInfo = paramCursor.getInt(i);
      break label2011;
      label3463:
      paramauko.lastLoginType = paramCursor.getLong(i);
      break label2046;
      label3478:
      paramauko.showLoginClient = paramCursor.getLong(i);
      break label2081;
      label3493:
      paramauko.medalsInfo = paramCursor.getString(i);
      break label2116;
      label3508:
      paramauko.nameplateCfgInfo = paramCursor.getString(i);
      break label2151;
      label3523:
      paramauko.richTime = paramCursor.getLong(i);
      break label2186;
      label3538:
      paramauko.richBuffer = paramCursor.getBlob(i);
      break label2221;
      label3553:
      paramauko.mComparePartInt = paramCursor.getInt(i);
      break label2256;
      label3568:
      paramauko.mCompareSpell = paramCursor.getString(i);
      break label2291;
      label3583:
      paramauko.cNetwork = ((byte)paramCursor.getShort(i));
      break label2326;
      label3599:
      paramauko.eNetwork = paramCursor.getInt(i);
      break label2361;
      label3614:
      paramauko.namePlateOfKingGameId = paramCursor.getLong(i);
      break label2396;
      label3629:
      paramauko.namePlateOfKingLoginTime = paramCursor.getLong(i);
      break label2431;
      label3644:
      paramauko.namePlateOfKingDan = paramCursor.getInt(i);
      break label2466;
      label3659:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramauko.namePlateOfKingDanDisplatSwitch = paramBoolean;
        break;
      }
      label3687:
      paramauko.strMasterUin = paramCursor.getString(i);
      break label2536;
      label3702:
      paramauko.multiFlags = paramCursor.getInt(i);
      break label2571;
      label3717:
      paramauko.friendType = paramCursor.getInt(i);
      break label2606;
      label3732:
      paramauko.abilityBits = paramCursor.getLong(i);
      break label2641;
      label3747:
      paramauko.bigClubInfo = paramCursor.getInt(i);
      break label2676;
      label3762:
      paramauko.superVipTemplateId = paramCursor.getInt(i);
      break label2711;
      label3777:
      paramauko.bigClubTemplateId = paramCursor.getInt(i);
      break label2746;
      label3792:
      paramauko.nameplateVipType = paramCursor.getInt(i);
      break label2781;
      label3807:
      paramauko.grayNameplateFlag = paramCursor.getInt(i);
      break label2816;
      label3822:
      paramauko.isHideBigClub = paramCursor.getInt(i);
      break label2851;
      label3837:
      paramauko.cNewLoverDiamondFlag = paramCursor.getInt(i);
      break label2886;
      label3852:
      paramauko.relationIconFlag = paramCursor.getInt(i);
      break label2923;
      label3867:
      paramauko.uExtOnlineStatus = paramCursor.getLong(i);
      break label2960;
      label3882:
      paramauko.iBatteryStatus = paramCursor.getInt(i);
    }
    label3897:
    paramauko.customModel = paramCursor.getString(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,remark TEXT ,name TEXT ,faceid INTEGER ,status INTEGER ,sqqtype INTEGER ,cSpecialFlag INTEGER ,groupid INTEGER ,memberLevel INTEGER ,isMqqOnLine INTEGER ,sqqOnLineState INTEGER ,detalStatusFlag INTEGER ,datetime INTEGER ,alias TEXT ,gathtertype INTEGER ,smartRemark TEXT ,age INTEGER ,gender INTEGER ,recommReason TEXT ,signature TEXT ,isIphoneOnline INTEGER ,isRemark INTEGER ,iTermType INTEGER ,qqVipInfo INTEGER ,superQqInfo INTEGER ,superVipInfo INTEGER ,hollywoodVipInfo INTEGER ,lastLoginType INTEGER ,showLoginClient INTEGER ,medalsInfo TEXT ,nameplateCfgInfo TEXT ,richTime INTEGER ,richBuffer BLOB ,mComparePartInt INTEGER ,mCompareSpell TEXT ,cNetwork INTEGER ,eNetwork INTEGER ,namePlateOfKingGameId INTEGER ,namePlateOfKingLoginTime INTEGER ,namePlateOfKingDan INTEGER ,namePlateOfKingDanDisplatSwitch INTEGER ,strMasterUin TEXT ,multiFlags INTEGER ,friendType INTEGER ,abilityBits INTEGER ,bigClubInfo INTEGER ,superVipTemplateId INTEGER ,bigClubTemplateId INTEGER ,nameplateVipType INTEGER ,grayNameplateFlag INTEGER ,isHideBigClub INTEGER ,cNewLoverDiamondFlag INTEGER ,relationIconFlag INTEGER ,uExtOnlineStatus INTEGER ,iBatteryStatus INTEGER ,customModel TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (Friends)paramauko;
    paramContentValues.put("uin", paramauko.uin);
    paramContentValues.put("remark", paramauko.remark);
    paramContentValues.put("name", paramauko.name);
    paramContentValues.put("faceid", Short.valueOf(paramauko.faceid));
    paramContentValues.put("status", Byte.valueOf(paramauko.status));
    paramContentValues.put("sqqtype", Byte.valueOf(paramauko.sqqtype));
    paramContentValues.put("cSpecialFlag", Byte.valueOf(paramauko.cSpecialFlag));
    paramContentValues.put("groupid", Integer.valueOf(paramauko.groupid));
    paramContentValues.put("memberLevel", Byte.valueOf(paramauko.memberLevel));
    paramContentValues.put("isMqqOnLine", Boolean.valueOf(paramauko.isMqqOnLine));
    paramContentValues.put("sqqOnLineState", Byte.valueOf(paramauko.sqqOnLineState));
    paramContentValues.put("detalStatusFlag", Byte.valueOf(paramauko.detalStatusFlag));
    paramContentValues.put("datetime", Long.valueOf(paramauko.datetime));
    paramContentValues.put("alias", paramauko.alias);
    paramContentValues.put("gathtertype", Byte.valueOf(paramauko.gathtertype));
    paramContentValues.put("smartRemark", paramauko.smartRemark);
    paramContentValues.put("age", Integer.valueOf(paramauko.age));
    paramContentValues.put("gender", Byte.valueOf(paramauko.gender));
    paramContentValues.put("recommReason", paramauko.recommReason);
    paramContentValues.put("signature", paramauko.signature);
    paramContentValues.put("isIphoneOnline", Byte.valueOf(paramauko.isIphoneOnline));
    paramContentValues.put("isRemark", Byte.valueOf(paramauko.isRemark));
    paramContentValues.put("iTermType", Integer.valueOf(paramauko.iTermType));
    paramContentValues.put("qqVipInfo", Integer.valueOf(paramauko.qqVipInfo));
    paramContentValues.put("superQqInfo", Integer.valueOf(paramauko.superQqInfo));
    paramContentValues.put("superVipInfo", Integer.valueOf(paramauko.superVipInfo));
    paramContentValues.put("hollywoodVipInfo", Integer.valueOf(paramauko.hollywoodVipInfo));
    paramContentValues.put("lastLoginType", Long.valueOf(paramauko.lastLoginType));
    paramContentValues.put("showLoginClient", Long.valueOf(paramauko.showLoginClient));
    paramContentValues.put("medalsInfo", paramauko.medalsInfo);
    paramContentValues.put("nameplateCfgInfo", paramauko.nameplateCfgInfo);
    paramContentValues.put("richTime", Long.valueOf(paramauko.richTime));
    paramContentValues.put("richBuffer", paramauko.richBuffer);
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramauko.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramauko.mCompareSpell);
    paramContentValues.put("cNetwork", Byte.valueOf(paramauko.cNetwork));
    paramContentValues.put("eNetwork", Integer.valueOf(paramauko.eNetwork));
    paramContentValues.put("namePlateOfKingGameId", Long.valueOf(paramauko.namePlateOfKingGameId));
    paramContentValues.put("namePlateOfKingLoginTime", Long.valueOf(paramauko.namePlateOfKingLoginTime));
    paramContentValues.put("namePlateOfKingDan", Integer.valueOf(paramauko.namePlateOfKingDan));
    paramContentValues.put("namePlateOfKingDanDisplatSwitch", Boolean.valueOf(paramauko.namePlateOfKingDanDisplatSwitch));
    paramContentValues.put("strMasterUin", paramauko.strMasterUin);
    paramContentValues.put("multiFlags", Integer.valueOf(paramauko.multiFlags));
    paramContentValues.put("friendType", Integer.valueOf(paramauko.friendType));
    paramContentValues.put("abilityBits", Long.valueOf(paramauko.abilityBits));
    paramContentValues.put("bigClubInfo", Integer.valueOf(paramauko.bigClubInfo));
    paramContentValues.put("superVipTemplateId", Integer.valueOf(paramauko.superVipTemplateId));
    paramContentValues.put("bigClubTemplateId", Integer.valueOf(paramauko.bigClubTemplateId));
    paramContentValues.put("nameplateVipType", Integer.valueOf(paramauko.nameplateVipType));
    paramContentValues.put("grayNameplateFlag", Integer.valueOf(paramauko.grayNameplateFlag));
    paramContentValues.put("isHideBigClub", Integer.valueOf(paramauko.isHideBigClub));
    paramContentValues.put("cNewLoverDiamondFlag", Integer.valueOf(paramauko.cNewLoverDiamondFlag));
    paramContentValues.put("relationIconFlag", Integer.valueOf(paramauko.relationIconFlag));
    paramContentValues.put("uExtOnlineStatus", Long.valueOf(paramauko.uExtOnlineStatus));
    paramContentValues.put("iBatteryStatus", Integer.valueOf(paramauko.iBatteryStatus));
    paramContentValues.put("customModel", paramauko.customModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auku
 * JD-Core Version:    0.7.0.1
 */