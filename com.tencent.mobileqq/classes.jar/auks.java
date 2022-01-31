import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.persistence.NoColumnError;

public class auks
  extends auky
{
  public auks()
  {
    this.a = 56;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramaukm = (Friends)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramaukm.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramaukm.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramaukm.faceid = paramCursor.getShort(paramCursor.getColumnIndex("faceid"));
      paramaukm.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("status")));
      paramaukm.sqqtype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sqqtype")));
      paramaukm.cSpecialFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSpecialFlag")));
      paramaukm.groupid = paramCursor.getInt(paramCursor.getColumnIndex("groupid"));
      paramaukm.memberLevel = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("memberLevel")));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isMqqOnLine")))
      {
        paramBoolean = true;
        paramaukm.isMqqOnLine = paramBoolean;
        paramaukm.sqqOnLineState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sqqOnLineState")));
        paramaukm.detalStatusFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("detalStatusFlag")));
        paramaukm.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
        paramaukm.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
        paramaukm.gathtertype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gathtertype")));
        paramaukm.smartRemark = paramCursor.getString(paramCursor.getColumnIndex("smartRemark"));
        paramaukm.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
        paramaukm.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
        paramaukm.recommReason = paramCursor.getString(paramCursor.getColumnIndex("recommReason"));
        paramaukm.signature = paramCursor.getString(paramCursor.getColumnIndex("signature"));
        paramaukm.isIphoneOnline = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isIphoneOnline")));
        paramaukm.isRemark = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isRemark")));
        paramaukm.iTermType = paramCursor.getInt(paramCursor.getColumnIndex("iTermType"));
        paramaukm.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
        paramaukm.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
        paramaukm.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
        paramaukm.hollywoodVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("hollywoodVipInfo"));
        paramaukm.lastLoginType = paramCursor.getLong(paramCursor.getColumnIndex("lastLoginType"));
        paramaukm.showLoginClient = paramCursor.getLong(paramCursor.getColumnIndex("showLoginClient"));
        paramaukm.medalsInfo = paramCursor.getString(paramCursor.getColumnIndex("medalsInfo"));
        paramaukm.nameplateCfgInfo = paramCursor.getString(paramCursor.getColumnIndex("nameplateCfgInfo"));
        paramaukm.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
        paramaukm.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
        paramaukm.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramaukm.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramaukm.cNetwork = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cNetwork")));
        paramaukm.eNetwork = paramCursor.getInt(paramCursor.getColumnIndex("eNetwork"));
        paramaukm.namePlateOfKingGameId = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingGameId"));
        paramaukm.namePlateOfKingLoginTime = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingLoginTime"));
        paramaukm.namePlateOfKingDan = paramCursor.getInt(paramCursor.getColumnIndex("namePlateOfKingDan"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch"))) {
          break label1061;
        }
      }
      label1061:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramaukm.namePlateOfKingDanDisplatSwitch = paramBoolean;
        paramaukm.strMasterUin = paramCursor.getString(paramCursor.getColumnIndex("strMasterUin"));
        paramaukm.multiFlags = paramCursor.getInt(paramCursor.getColumnIndex("multiFlags"));
        paramaukm.friendType = paramCursor.getInt(paramCursor.getColumnIndex("friendType"));
        paramaukm.abilityBits = paramCursor.getLong(paramCursor.getColumnIndex("abilityBits"));
        paramaukm.bigClubInfo = paramCursor.getInt(paramCursor.getColumnIndex("bigClubInfo"));
        paramaukm.superVipTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("superVipTemplateId"));
        paramaukm.bigClubTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("bigClubTemplateId"));
        paramaukm.nameplateVipType = paramCursor.getInt(paramCursor.getColumnIndex("nameplateVipType"));
        paramaukm.grayNameplateFlag = paramCursor.getInt(paramCursor.getColumnIndex("grayNameplateFlag"));
        paramaukm.isHideBigClub = paramCursor.getInt(paramCursor.getColumnIndex("isHideBigClub"));
        paramaukm.cNewLoverDiamondFlag = paramCursor.getInt(paramCursor.getColumnIndex("cNewLoverDiamondFlag"));
        paramaukm.relationIconFlag = paramCursor.getInt(paramCursor.getColumnIndex("relationIconFlag"));
        paramaukm.uExtOnlineStatus = paramCursor.getLong(paramCursor.getColumnIndex("uExtOnlineStatus"));
        paramaukm.iBatteryStatus = paramCursor.getInt(paramCursor.getColumnIndex("iBatteryStatus"));
        paramaukm.customModel = paramCursor.getString(paramCursor.getColumnIndex("customModel"));
        return paramaukm;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramaukx.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label3051;
      }
      paramaukx.a(new NoColumnError("remark", String.class));
      label1136:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label3066;
      }
      paramaukx.a(new NoColumnError("name", String.class));
      label1171:
      i = paramCursor.getColumnIndex("faceid");
      if (i != -1) {
        break label3081;
      }
      paramaukx.a(new NoColumnError("faceid", Short.TYPE));
      label1206:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label3096;
      }
      paramaukx.a(new NoColumnError("status", Byte.TYPE));
      label1241:
      i = paramCursor.getColumnIndex("sqqtype");
      if (i != -1) {
        break label3112;
      }
      paramaukx.a(new NoColumnError("sqqtype", Byte.TYPE));
      label1276:
      i = paramCursor.getColumnIndex("cSpecialFlag");
      if (i != -1) {
        break label3128;
      }
      paramaukx.a(new NoColumnError("cSpecialFlag", Byte.TYPE));
      label1311:
      i = paramCursor.getColumnIndex("groupid");
      if (i != -1) {
        break label3144;
      }
      paramaukx.a(new NoColumnError("groupid", Integer.TYPE));
      label1346:
      i = paramCursor.getColumnIndex("memberLevel");
      if (i != -1) {
        break label3159;
      }
      paramaukx.a(new NoColumnError("memberLevel", Byte.TYPE));
      label1381:
      i = paramCursor.getColumnIndex("isMqqOnLine");
      if (i != -1) {
        break label3175;
      }
      paramaukx.a(new NoColumnError("isMqqOnLine", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sqqOnLineState");
      if (i != -1) {
        break label3202;
      }
      paramaukx.a(new NoColumnError("sqqOnLineState", Byte.TYPE));
      label1451:
      i = paramCursor.getColumnIndex("detalStatusFlag");
      if (i != -1) {
        break label3218;
      }
      paramaukx.a(new NoColumnError("detalStatusFlag", Byte.TYPE));
      label1486:
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label3234;
      }
      paramaukx.a(new NoColumnError("datetime", Long.TYPE));
      label1521:
      i = paramCursor.getColumnIndex("alias");
      if (i != -1) {
        break label3249;
      }
      paramaukx.a(new NoColumnError("alias", String.class));
      label1556:
      i = paramCursor.getColumnIndex("gathtertype");
      if (i != -1) {
        break label3264;
      }
      paramaukx.a(new NoColumnError("gathtertype", Byte.TYPE));
      label1591:
      i = paramCursor.getColumnIndex("smartRemark");
      if (i != -1) {
        break label3280;
      }
      paramaukx.a(new NoColumnError("smartRemark", String.class));
      label1626:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label3295;
      }
      paramaukx.a(new NoColumnError("age", Integer.TYPE));
      label1661:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label3310;
      }
      paramaukx.a(new NoColumnError("gender", Byte.TYPE));
      label1696:
      i = paramCursor.getColumnIndex("recommReason");
      if (i != -1) {
        break label3326;
      }
      paramaukx.a(new NoColumnError("recommReason", String.class));
      label1731:
      i = paramCursor.getColumnIndex("signature");
      if (i != -1) {
        break label3341;
      }
      paramaukx.a(new NoColumnError("signature", String.class));
      label1766:
      i = paramCursor.getColumnIndex("isIphoneOnline");
      if (i != -1) {
        break label3356;
      }
      paramaukx.a(new NoColumnError("isIphoneOnline", Byte.TYPE));
      label1801:
      i = paramCursor.getColumnIndex("isRemark");
      if (i != -1) {
        break label3372;
      }
      paramaukx.a(new NoColumnError("isRemark", Byte.TYPE));
      label1836:
      i = paramCursor.getColumnIndex("iTermType");
      if (i != -1) {
        break label3388;
      }
      paramaukx.a(new NoColumnError("iTermType", Integer.TYPE));
      label1871:
      i = paramCursor.getColumnIndex("qqVipInfo");
      if (i != -1) {
        break label3403;
      }
      paramaukx.a(new NoColumnError("qqVipInfo", Integer.TYPE));
      label1906:
      i = paramCursor.getColumnIndex("superQqInfo");
      if (i != -1) {
        break label3418;
      }
      paramaukx.a(new NoColumnError("superQqInfo", Integer.TYPE));
      label1941:
      i = paramCursor.getColumnIndex("superVipInfo");
      if (i != -1) {
        break label3433;
      }
      paramaukx.a(new NoColumnError("superVipInfo", Integer.TYPE));
      label1976:
      i = paramCursor.getColumnIndex("hollywoodVipInfo");
      if (i != -1) {
        break label3448;
      }
      paramaukx.a(new NoColumnError("hollywoodVipInfo", Integer.TYPE));
      label2011:
      i = paramCursor.getColumnIndex("lastLoginType");
      if (i != -1) {
        break label3463;
      }
      paramaukx.a(new NoColumnError("lastLoginType", Long.TYPE));
      label2046:
      i = paramCursor.getColumnIndex("showLoginClient");
      if (i != -1) {
        break label3478;
      }
      paramaukx.a(new NoColumnError("showLoginClient", Long.TYPE));
      label2081:
      i = paramCursor.getColumnIndex("medalsInfo");
      if (i != -1) {
        break label3493;
      }
      paramaukx.a(new NoColumnError("medalsInfo", String.class));
      label2116:
      i = paramCursor.getColumnIndex("nameplateCfgInfo");
      if (i != -1) {
        break label3508;
      }
      paramaukx.a(new NoColumnError("nameplateCfgInfo", String.class));
      label2151:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label3523;
      }
      paramaukx.a(new NoColumnError("richTime", Long.TYPE));
      label2186:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label3538;
      }
      paramaukx.a(new NoColumnError("richBuffer", [B.class));
      label2221:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label3553;
      }
      paramaukx.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label2256:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label3568;
      }
      paramaukx.a(new NoColumnError("mCompareSpell", String.class));
      label2291:
      i = paramCursor.getColumnIndex("cNetwork");
      if (i != -1) {
        break label3583;
      }
      paramaukx.a(new NoColumnError("cNetwork", Byte.TYPE));
      label2326:
      i = paramCursor.getColumnIndex("eNetwork");
      if (i != -1) {
        break label3599;
      }
      paramaukx.a(new NoColumnError("eNetwork", Integer.TYPE));
      label2361:
      i = paramCursor.getColumnIndex("namePlateOfKingGameId");
      if (i != -1) {
        break label3614;
      }
      paramaukx.a(new NoColumnError("namePlateOfKingGameId", Long.TYPE));
      label2396:
      i = paramCursor.getColumnIndex("namePlateOfKingLoginTime");
      if (i != -1) {
        break label3629;
      }
      paramaukx.a(new NoColumnError("namePlateOfKingLoginTime", Long.TYPE));
      label2431:
      i = paramCursor.getColumnIndex("namePlateOfKingDan");
      if (i != -1) {
        break label3644;
      }
      paramaukx.a(new NoColumnError("namePlateOfKingDan", Integer.TYPE));
      label2466:
      i = paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch");
      if (i != -1) {
        break label3659;
      }
      paramaukx.a(new NoColumnError("namePlateOfKingDanDisplatSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("strMasterUin");
      if (i != -1) {
        break label3687;
      }
      paramaukx.a(new NoColumnError("strMasterUin", String.class));
      label2536:
      i = paramCursor.getColumnIndex("multiFlags");
      if (i != -1) {
        break label3702;
      }
      paramaukx.a(new NoColumnError("multiFlags", Integer.TYPE));
      label2571:
      i = paramCursor.getColumnIndex("friendType");
      if (i != -1) {
        break label3717;
      }
      paramaukx.a(new NoColumnError("friendType", Integer.TYPE));
      label2606:
      i = paramCursor.getColumnIndex("abilityBits");
      if (i != -1) {
        break label3732;
      }
      paramaukx.a(new NoColumnError("abilityBits", Long.TYPE));
      label2641:
      i = paramCursor.getColumnIndex("bigClubInfo");
      if (i != -1) {
        break label3747;
      }
      paramaukx.a(new NoColumnError("bigClubInfo", Integer.TYPE));
      label2676:
      i = paramCursor.getColumnIndex("superVipTemplateId");
      if (i != -1) {
        break label3762;
      }
      paramaukx.a(new NoColumnError("superVipTemplateId", Integer.TYPE));
      label2711:
      i = paramCursor.getColumnIndex("bigClubTemplateId");
      if (i != -1) {
        break label3777;
      }
      paramaukx.a(new NoColumnError("bigClubTemplateId", Integer.TYPE));
      label2746:
      i = paramCursor.getColumnIndex("nameplateVipType");
      if (i != -1) {
        break label3792;
      }
      paramaukx.a(new NoColumnError("nameplateVipType", Integer.TYPE));
      label2781:
      i = paramCursor.getColumnIndex("grayNameplateFlag");
      if (i != -1) {
        break label3807;
      }
      paramaukx.a(new NoColumnError("grayNameplateFlag", Integer.TYPE));
      label2816:
      i = paramCursor.getColumnIndex("isHideBigClub");
      if (i != -1) {
        break label3822;
      }
      paramaukx.a(new NoColumnError("isHideBigClub", Integer.TYPE));
      label2851:
      i = paramCursor.getColumnIndex("cNewLoverDiamondFlag");
      if (i != -1) {
        break label3837;
      }
      paramaukx.a(new NoColumnError("cNewLoverDiamondFlag", Integer.TYPE));
      label2886:
      i = paramCursor.getColumnIndex("relationIconFlag");
      if (i != -1) {
        break label3852;
      }
      paramaukx.a(new NoColumnError("relationIconFlag", Integer.TYPE));
      label2923:
      i = paramCursor.getColumnIndex("uExtOnlineStatus");
      if (i != -1) {
        break label3867;
      }
      paramaukx.a(new NoColumnError("uExtOnlineStatus", Long.TYPE));
      label2960:
      i = paramCursor.getColumnIndex("iBatteryStatus");
      if (i != -1) {
        break label3882;
      }
      paramaukx.a(new NoColumnError("iBatteryStatus", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("customModel");
      if (i != -1) {
        break label3897;
      }
      paramaukx.a(new NoColumnError("customModel", String.class));
      return paramaukm;
      paramaukm.uin = paramCursor.getString(i);
      break;
      label3051:
      paramaukm.remark = paramCursor.getString(i);
      break label1136;
      label3066:
      paramaukm.name = paramCursor.getString(i);
      break label1171;
      label3081:
      paramaukm.faceid = paramCursor.getShort(i);
      break label1206;
      label3096:
      paramaukm.status = ((byte)paramCursor.getShort(i));
      break label1241;
      label3112:
      paramaukm.sqqtype = ((byte)paramCursor.getShort(i));
      break label1276;
      label3128:
      paramaukm.cSpecialFlag = ((byte)paramCursor.getShort(i));
      break label1311;
      label3144:
      paramaukm.groupid = paramCursor.getInt(i);
      break label1346;
      label3159:
      paramaukm.memberLevel = ((byte)paramCursor.getShort(i));
      break label1381;
      label3175:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isMqqOnLine = paramBoolean;
        break;
      }
      label3202:
      paramaukm.sqqOnLineState = ((byte)paramCursor.getShort(i));
      break label1451;
      label3218:
      paramaukm.detalStatusFlag = ((byte)paramCursor.getShort(i));
      break label1486;
      label3234:
      paramaukm.datetime = paramCursor.getLong(i);
      break label1521;
      label3249:
      paramaukm.alias = paramCursor.getString(i);
      break label1556;
      label3264:
      paramaukm.gathtertype = ((byte)paramCursor.getShort(i));
      break label1591;
      label3280:
      paramaukm.smartRemark = paramCursor.getString(i);
      break label1626;
      label3295:
      paramaukm.age = paramCursor.getInt(i);
      break label1661;
      label3310:
      paramaukm.gender = ((byte)paramCursor.getShort(i));
      break label1696;
      label3326:
      paramaukm.recommReason = paramCursor.getString(i);
      break label1731;
      label3341:
      paramaukm.signature = paramCursor.getString(i);
      break label1766;
      label3356:
      paramaukm.isIphoneOnline = ((byte)paramCursor.getShort(i));
      break label1801;
      label3372:
      paramaukm.isRemark = ((byte)paramCursor.getShort(i));
      break label1836;
      label3388:
      paramaukm.iTermType = paramCursor.getInt(i);
      break label1871;
      label3403:
      paramaukm.qqVipInfo = paramCursor.getInt(i);
      break label1906;
      label3418:
      paramaukm.superQqInfo = paramCursor.getInt(i);
      break label1941;
      label3433:
      paramaukm.superVipInfo = paramCursor.getInt(i);
      break label1976;
      label3448:
      paramaukm.hollywoodVipInfo = paramCursor.getInt(i);
      break label2011;
      label3463:
      paramaukm.lastLoginType = paramCursor.getLong(i);
      break label2046;
      label3478:
      paramaukm.showLoginClient = paramCursor.getLong(i);
      break label2081;
      label3493:
      paramaukm.medalsInfo = paramCursor.getString(i);
      break label2116;
      label3508:
      paramaukm.nameplateCfgInfo = paramCursor.getString(i);
      break label2151;
      label3523:
      paramaukm.richTime = paramCursor.getLong(i);
      break label2186;
      label3538:
      paramaukm.richBuffer = paramCursor.getBlob(i);
      break label2221;
      label3553:
      paramaukm.mComparePartInt = paramCursor.getInt(i);
      break label2256;
      label3568:
      paramaukm.mCompareSpell = paramCursor.getString(i);
      break label2291;
      label3583:
      paramaukm.cNetwork = ((byte)paramCursor.getShort(i));
      break label2326;
      label3599:
      paramaukm.eNetwork = paramCursor.getInt(i);
      break label2361;
      label3614:
      paramaukm.namePlateOfKingGameId = paramCursor.getLong(i);
      break label2396;
      label3629:
      paramaukm.namePlateOfKingLoginTime = paramCursor.getLong(i);
      break label2431;
      label3644:
      paramaukm.namePlateOfKingDan = paramCursor.getInt(i);
      break label2466;
      label3659:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramaukm.namePlateOfKingDanDisplatSwitch = paramBoolean;
        break;
      }
      label3687:
      paramaukm.strMasterUin = paramCursor.getString(i);
      break label2536;
      label3702:
      paramaukm.multiFlags = paramCursor.getInt(i);
      break label2571;
      label3717:
      paramaukm.friendType = paramCursor.getInt(i);
      break label2606;
      label3732:
      paramaukm.abilityBits = paramCursor.getLong(i);
      break label2641;
      label3747:
      paramaukm.bigClubInfo = paramCursor.getInt(i);
      break label2676;
      label3762:
      paramaukm.superVipTemplateId = paramCursor.getInt(i);
      break label2711;
      label3777:
      paramaukm.bigClubTemplateId = paramCursor.getInt(i);
      break label2746;
      label3792:
      paramaukm.nameplateVipType = paramCursor.getInt(i);
      break label2781;
      label3807:
      paramaukm.grayNameplateFlag = paramCursor.getInt(i);
      break label2816;
      label3822:
      paramaukm.isHideBigClub = paramCursor.getInt(i);
      break label2851;
      label3837:
      paramaukm.cNewLoverDiamondFlag = paramCursor.getInt(i);
      break label2886;
      label3852:
      paramaukm.relationIconFlag = paramCursor.getInt(i);
      break label2923;
      label3867:
      paramaukm.uExtOnlineStatus = paramCursor.getLong(i);
      break label2960;
      label3882:
      paramaukm.iBatteryStatus = paramCursor.getInt(i);
    }
    label3897:
    paramaukm.customModel = paramCursor.getString(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,remark TEXT ,name TEXT ,faceid INTEGER ,status INTEGER ,sqqtype INTEGER ,cSpecialFlag INTEGER ,groupid INTEGER ,memberLevel INTEGER ,isMqqOnLine INTEGER ,sqqOnLineState INTEGER ,detalStatusFlag INTEGER ,datetime INTEGER ,alias TEXT ,gathtertype INTEGER ,smartRemark TEXT ,age INTEGER ,gender INTEGER ,recommReason TEXT ,signature TEXT ,isIphoneOnline INTEGER ,isRemark INTEGER ,iTermType INTEGER ,qqVipInfo INTEGER ,superQqInfo INTEGER ,superVipInfo INTEGER ,hollywoodVipInfo INTEGER ,lastLoginType INTEGER ,showLoginClient INTEGER ,medalsInfo TEXT ,nameplateCfgInfo TEXT ,richTime INTEGER ,richBuffer BLOB ,mComparePartInt INTEGER ,mCompareSpell TEXT ,cNetwork INTEGER ,eNetwork INTEGER ,namePlateOfKingGameId INTEGER ,namePlateOfKingLoginTime INTEGER ,namePlateOfKingDan INTEGER ,namePlateOfKingDanDisplatSwitch INTEGER ,strMasterUin TEXT ,multiFlags INTEGER ,friendType INTEGER ,abilityBits INTEGER ,bigClubInfo INTEGER ,superVipTemplateId INTEGER ,bigClubTemplateId INTEGER ,nameplateVipType INTEGER ,grayNameplateFlag INTEGER ,isHideBigClub INTEGER ,cNewLoverDiamondFlag INTEGER ,relationIconFlag INTEGER ,uExtOnlineStatus INTEGER ,iBatteryStatus INTEGER ,customModel TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (Friends)paramaukm;
    paramContentValues.put("uin", paramaukm.uin);
    paramContentValues.put("remark", paramaukm.remark);
    paramContentValues.put("name", paramaukm.name);
    paramContentValues.put("faceid", Short.valueOf(paramaukm.faceid));
    paramContentValues.put("status", Byte.valueOf(paramaukm.status));
    paramContentValues.put("sqqtype", Byte.valueOf(paramaukm.sqqtype));
    paramContentValues.put("cSpecialFlag", Byte.valueOf(paramaukm.cSpecialFlag));
    paramContentValues.put("groupid", Integer.valueOf(paramaukm.groupid));
    paramContentValues.put("memberLevel", Byte.valueOf(paramaukm.memberLevel));
    paramContentValues.put("isMqqOnLine", Boolean.valueOf(paramaukm.isMqqOnLine));
    paramContentValues.put("sqqOnLineState", Byte.valueOf(paramaukm.sqqOnLineState));
    paramContentValues.put("detalStatusFlag", Byte.valueOf(paramaukm.detalStatusFlag));
    paramContentValues.put("datetime", Long.valueOf(paramaukm.datetime));
    paramContentValues.put("alias", paramaukm.alias);
    paramContentValues.put("gathtertype", Byte.valueOf(paramaukm.gathtertype));
    paramContentValues.put("smartRemark", paramaukm.smartRemark);
    paramContentValues.put("age", Integer.valueOf(paramaukm.age));
    paramContentValues.put("gender", Byte.valueOf(paramaukm.gender));
    paramContentValues.put("recommReason", paramaukm.recommReason);
    paramContentValues.put("signature", paramaukm.signature);
    paramContentValues.put("isIphoneOnline", Byte.valueOf(paramaukm.isIphoneOnline));
    paramContentValues.put("isRemark", Byte.valueOf(paramaukm.isRemark));
    paramContentValues.put("iTermType", Integer.valueOf(paramaukm.iTermType));
    paramContentValues.put("qqVipInfo", Integer.valueOf(paramaukm.qqVipInfo));
    paramContentValues.put("superQqInfo", Integer.valueOf(paramaukm.superQqInfo));
    paramContentValues.put("superVipInfo", Integer.valueOf(paramaukm.superVipInfo));
    paramContentValues.put("hollywoodVipInfo", Integer.valueOf(paramaukm.hollywoodVipInfo));
    paramContentValues.put("lastLoginType", Long.valueOf(paramaukm.lastLoginType));
    paramContentValues.put("showLoginClient", Long.valueOf(paramaukm.showLoginClient));
    paramContentValues.put("medalsInfo", paramaukm.medalsInfo);
    paramContentValues.put("nameplateCfgInfo", paramaukm.nameplateCfgInfo);
    paramContentValues.put("richTime", Long.valueOf(paramaukm.richTime));
    paramContentValues.put("richBuffer", paramaukm.richBuffer);
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramaukm.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramaukm.mCompareSpell);
    paramContentValues.put("cNetwork", Byte.valueOf(paramaukm.cNetwork));
    paramContentValues.put("eNetwork", Integer.valueOf(paramaukm.eNetwork));
    paramContentValues.put("namePlateOfKingGameId", Long.valueOf(paramaukm.namePlateOfKingGameId));
    paramContentValues.put("namePlateOfKingLoginTime", Long.valueOf(paramaukm.namePlateOfKingLoginTime));
    paramContentValues.put("namePlateOfKingDan", Integer.valueOf(paramaukm.namePlateOfKingDan));
    paramContentValues.put("namePlateOfKingDanDisplatSwitch", Boolean.valueOf(paramaukm.namePlateOfKingDanDisplatSwitch));
    paramContentValues.put("strMasterUin", paramaukm.strMasterUin);
    paramContentValues.put("multiFlags", Integer.valueOf(paramaukm.multiFlags));
    paramContentValues.put("friendType", Integer.valueOf(paramaukm.friendType));
    paramContentValues.put("abilityBits", Long.valueOf(paramaukm.abilityBits));
    paramContentValues.put("bigClubInfo", Integer.valueOf(paramaukm.bigClubInfo));
    paramContentValues.put("superVipTemplateId", Integer.valueOf(paramaukm.superVipTemplateId));
    paramContentValues.put("bigClubTemplateId", Integer.valueOf(paramaukm.bigClubTemplateId));
    paramContentValues.put("nameplateVipType", Integer.valueOf(paramaukm.nameplateVipType));
    paramContentValues.put("grayNameplateFlag", Integer.valueOf(paramaukm.grayNameplateFlag));
    paramContentValues.put("isHideBigClub", Integer.valueOf(paramaukm.isHideBigClub));
    paramContentValues.put("cNewLoverDiamondFlag", Integer.valueOf(paramaukm.cNewLoverDiamondFlag));
    paramContentValues.put("relationIconFlag", Integer.valueOf(paramaukm.relationIconFlag));
    paramContentValues.put("uExtOnlineStatus", Long.valueOf(paramaukm.uExtOnlineStatus));
    paramContentValues.put("iBatteryStatus", Integer.valueOf(paramaukm.iBatteryStatus));
    paramContentValues.put("customModel", paramaukm.customModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auks
 * JD-Core Version:    0.7.0.1
 */