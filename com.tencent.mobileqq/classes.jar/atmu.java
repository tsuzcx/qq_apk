import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atmu
  extends atna
{
  public atmu()
  {
    this.a = 54;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramatmo = (Friends)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramatmo.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramatmo.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramatmo.faceid = paramCursor.getShort(paramCursor.getColumnIndex("faceid"));
      paramatmo.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("status")));
      paramatmo.sqqtype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sqqtype")));
      paramatmo.cSpecialFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSpecialFlag")));
      paramatmo.groupid = paramCursor.getInt(paramCursor.getColumnIndex("groupid"));
      paramatmo.memberLevel = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("memberLevel")));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isMqqOnLine")))
      {
        paramBoolean = true;
        paramatmo.isMqqOnLine = paramBoolean;
        paramatmo.sqqOnLineState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sqqOnLineState")));
        paramatmo.detalStatusFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("detalStatusFlag")));
        paramatmo.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
        paramatmo.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
        paramatmo.gathtertype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gathtertype")));
        paramatmo.smartRemark = paramCursor.getString(paramCursor.getColumnIndex("smartRemark"));
        paramatmo.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
        paramatmo.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
        paramatmo.recommReason = paramCursor.getString(paramCursor.getColumnIndex("recommReason"));
        paramatmo.signature = paramCursor.getString(paramCursor.getColumnIndex("signature"));
        paramatmo.isIphoneOnline = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isIphoneOnline")));
        paramatmo.isRemark = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isRemark")));
        paramatmo.iTermType = paramCursor.getInt(paramCursor.getColumnIndex("iTermType"));
        paramatmo.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
        paramatmo.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
        paramatmo.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
        paramatmo.hollywoodVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("hollywoodVipInfo"));
        paramatmo.lastLoginType = paramCursor.getLong(paramCursor.getColumnIndex("lastLoginType"));
        paramatmo.showLoginClient = paramCursor.getLong(paramCursor.getColumnIndex("showLoginClient"));
        paramatmo.medalsInfo = paramCursor.getString(paramCursor.getColumnIndex("medalsInfo"));
        paramatmo.nameplateCfgInfo = paramCursor.getString(paramCursor.getColumnIndex("nameplateCfgInfo"));
        paramatmo.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
        paramatmo.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
        paramatmo.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramatmo.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramatmo.cNetwork = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cNetwork")));
        paramatmo.eNetwork = paramCursor.getInt(paramCursor.getColumnIndex("eNetwork"));
        paramatmo.namePlateOfKingGameId = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingGameId"));
        paramatmo.namePlateOfKingLoginTime = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingLoginTime"));
        paramatmo.namePlateOfKingDan = paramCursor.getInt(paramCursor.getColumnIndex("namePlateOfKingDan"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch"))) {
          break label1023;
        }
      }
      label1023:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramatmo.namePlateOfKingDanDisplatSwitch = paramBoolean;
        paramatmo.strMasterUin = paramCursor.getString(paramCursor.getColumnIndex("strMasterUin"));
        paramatmo.multiFlags = paramCursor.getInt(paramCursor.getColumnIndex("multiFlags"));
        paramatmo.friendType = paramCursor.getInt(paramCursor.getColumnIndex("friendType"));
        paramatmo.abilityBits = paramCursor.getLong(paramCursor.getColumnIndex("abilityBits"));
        paramatmo.bigClubInfo = paramCursor.getInt(paramCursor.getColumnIndex("bigClubInfo"));
        paramatmo.superVipTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("superVipTemplateId"));
        paramatmo.bigClubTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("bigClubTemplateId"));
        paramatmo.isHideBigClub = paramCursor.getInt(paramCursor.getColumnIndex("isHideBigClub"));
        paramatmo.cNewLoverDiamondFlag = paramCursor.getInt(paramCursor.getColumnIndex("cNewLoverDiamondFlag"));
        paramatmo.relationIconFlag = paramCursor.getInt(paramCursor.getColumnIndex("relationIconFlag"));
        paramatmo.uExtOnlineStatus = paramCursor.getLong(paramCursor.getColumnIndex("uExtOnlineStatus"));
        paramatmo.iBatteryStatus = paramCursor.getInt(paramCursor.getColumnIndex("iBatteryStatus"));
        paramatmo.customModel = paramCursor.getString(paramCursor.getColumnIndex("customModel"));
        return paramatmo;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramatmz.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label2939;
      }
      paramatmz.a(new NoColumnError("remark", String.class));
      label1098:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label2954;
      }
      paramatmz.a(new NoColumnError("name", String.class));
      label1133:
      i = paramCursor.getColumnIndex("faceid");
      if (i != -1) {
        break label2969;
      }
      paramatmz.a(new NoColumnError("faceid", Short.TYPE));
      label1168:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label2984;
      }
      paramatmz.a(new NoColumnError("status", Byte.TYPE));
      label1203:
      i = paramCursor.getColumnIndex("sqqtype");
      if (i != -1) {
        break label3000;
      }
      paramatmz.a(new NoColumnError("sqqtype", Byte.TYPE));
      label1238:
      i = paramCursor.getColumnIndex("cSpecialFlag");
      if (i != -1) {
        break label3016;
      }
      paramatmz.a(new NoColumnError("cSpecialFlag", Byte.TYPE));
      label1273:
      i = paramCursor.getColumnIndex("groupid");
      if (i != -1) {
        break label3032;
      }
      paramatmz.a(new NoColumnError("groupid", Integer.TYPE));
      label1308:
      i = paramCursor.getColumnIndex("memberLevel");
      if (i != -1) {
        break label3047;
      }
      paramatmz.a(new NoColumnError("memberLevel", Byte.TYPE));
      label1343:
      i = paramCursor.getColumnIndex("isMqqOnLine");
      if (i != -1) {
        break label3063;
      }
      paramatmz.a(new NoColumnError("isMqqOnLine", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sqqOnLineState");
      if (i != -1) {
        break label3090;
      }
      paramatmz.a(new NoColumnError("sqqOnLineState", Byte.TYPE));
      label1413:
      i = paramCursor.getColumnIndex("detalStatusFlag");
      if (i != -1) {
        break label3106;
      }
      paramatmz.a(new NoColumnError("detalStatusFlag", Byte.TYPE));
      label1448:
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label3122;
      }
      paramatmz.a(new NoColumnError("datetime", Long.TYPE));
      label1483:
      i = paramCursor.getColumnIndex("alias");
      if (i != -1) {
        break label3137;
      }
      paramatmz.a(new NoColumnError("alias", String.class));
      label1518:
      i = paramCursor.getColumnIndex("gathtertype");
      if (i != -1) {
        break label3152;
      }
      paramatmz.a(new NoColumnError("gathtertype", Byte.TYPE));
      label1553:
      i = paramCursor.getColumnIndex("smartRemark");
      if (i != -1) {
        break label3168;
      }
      paramatmz.a(new NoColumnError("smartRemark", String.class));
      label1588:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label3183;
      }
      paramatmz.a(new NoColumnError("age", Integer.TYPE));
      label1623:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label3198;
      }
      paramatmz.a(new NoColumnError("gender", Byte.TYPE));
      label1658:
      i = paramCursor.getColumnIndex("recommReason");
      if (i != -1) {
        break label3214;
      }
      paramatmz.a(new NoColumnError("recommReason", String.class));
      label1693:
      i = paramCursor.getColumnIndex("signature");
      if (i != -1) {
        break label3229;
      }
      paramatmz.a(new NoColumnError("signature", String.class));
      label1728:
      i = paramCursor.getColumnIndex("isIphoneOnline");
      if (i != -1) {
        break label3244;
      }
      paramatmz.a(new NoColumnError("isIphoneOnline", Byte.TYPE));
      label1763:
      i = paramCursor.getColumnIndex("isRemark");
      if (i != -1) {
        break label3260;
      }
      paramatmz.a(new NoColumnError("isRemark", Byte.TYPE));
      label1798:
      i = paramCursor.getColumnIndex("iTermType");
      if (i != -1) {
        break label3276;
      }
      paramatmz.a(new NoColumnError("iTermType", Integer.TYPE));
      label1833:
      i = paramCursor.getColumnIndex("qqVipInfo");
      if (i != -1) {
        break label3291;
      }
      paramatmz.a(new NoColumnError("qqVipInfo", Integer.TYPE));
      label1868:
      i = paramCursor.getColumnIndex("superQqInfo");
      if (i != -1) {
        break label3306;
      }
      paramatmz.a(new NoColumnError("superQqInfo", Integer.TYPE));
      label1903:
      i = paramCursor.getColumnIndex("superVipInfo");
      if (i != -1) {
        break label3321;
      }
      paramatmz.a(new NoColumnError("superVipInfo", Integer.TYPE));
      label1938:
      i = paramCursor.getColumnIndex("hollywoodVipInfo");
      if (i != -1) {
        break label3336;
      }
      paramatmz.a(new NoColumnError("hollywoodVipInfo", Integer.TYPE));
      label1973:
      i = paramCursor.getColumnIndex("lastLoginType");
      if (i != -1) {
        break label3351;
      }
      paramatmz.a(new NoColumnError("lastLoginType", Long.TYPE));
      label2008:
      i = paramCursor.getColumnIndex("showLoginClient");
      if (i != -1) {
        break label3366;
      }
      paramatmz.a(new NoColumnError("showLoginClient", Long.TYPE));
      label2043:
      i = paramCursor.getColumnIndex("medalsInfo");
      if (i != -1) {
        break label3381;
      }
      paramatmz.a(new NoColumnError("medalsInfo", String.class));
      label2078:
      i = paramCursor.getColumnIndex("nameplateCfgInfo");
      if (i != -1) {
        break label3396;
      }
      paramatmz.a(new NoColumnError("nameplateCfgInfo", String.class));
      label2113:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label3411;
      }
      paramatmz.a(new NoColumnError("richTime", Long.TYPE));
      label2148:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label3426;
      }
      paramatmz.a(new NoColumnError("richBuffer", [B.class));
      label2183:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label3441;
      }
      paramatmz.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label2218:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label3456;
      }
      paramatmz.a(new NoColumnError("mCompareSpell", String.class));
      label2253:
      i = paramCursor.getColumnIndex("cNetwork");
      if (i != -1) {
        break label3471;
      }
      paramatmz.a(new NoColumnError("cNetwork", Byte.TYPE));
      label2288:
      i = paramCursor.getColumnIndex("eNetwork");
      if (i != -1) {
        break label3487;
      }
      paramatmz.a(new NoColumnError("eNetwork", Integer.TYPE));
      label2323:
      i = paramCursor.getColumnIndex("namePlateOfKingGameId");
      if (i != -1) {
        break label3502;
      }
      paramatmz.a(new NoColumnError("namePlateOfKingGameId", Long.TYPE));
      label2358:
      i = paramCursor.getColumnIndex("namePlateOfKingLoginTime");
      if (i != -1) {
        break label3517;
      }
      paramatmz.a(new NoColumnError("namePlateOfKingLoginTime", Long.TYPE));
      label2393:
      i = paramCursor.getColumnIndex("namePlateOfKingDan");
      if (i != -1) {
        break label3532;
      }
      paramatmz.a(new NoColumnError("namePlateOfKingDan", Integer.TYPE));
      label2428:
      i = paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch");
      if (i != -1) {
        break label3547;
      }
      paramatmz.a(new NoColumnError("namePlateOfKingDanDisplatSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("strMasterUin");
      if (i != -1) {
        break label3575;
      }
      paramatmz.a(new NoColumnError("strMasterUin", String.class));
      label2498:
      i = paramCursor.getColumnIndex("multiFlags");
      if (i != -1) {
        break label3590;
      }
      paramatmz.a(new NoColumnError("multiFlags", Integer.TYPE));
      label2533:
      i = paramCursor.getColumnIndex("friendType");
      if (i != -1) {
        break label3605;
      }
      paramatmz.a(new NoColumnError("friendType", Integer.TYPE));
      label2568:
      i = paramCursor.getColumnIndex("abilityBits");
      if (i != -1) {
        break label3620;
      }
      paramatmz.a(new NoColumnError("abilityBits", Long.TYPE));
      label2603:
      i = paramCursor.getColumnIndex("bigClubInfo");
      if (i != -1) {
        break label3635;
      }
      paramatmz.a(new NoColumnError("bigClubInfo", Integer.TYPE));
      label2638:
      i = paramCursor.getColumnIndex("superVipTemplateId");
      if (i != -1) {
        break label3650;
      }
      paramatmz.a(new NoColumnError("superVipTemplateId", Integer.TYPE));
      label2673:
      i = paramCursor.getColumnIndex("bigClubTemplateId");
      if (i != -1) {
        break label3665;
      }
      paramatmz.a(new NoColumnError("bigClubTemplateId", Integer.TYPE));
      label2708:
      i = paramCursor.getColumnIndex("isHideBigClub");
      if (i != -1) {
        break label3680;
      }
      paramatmz.a(new NoColumnError("isHideBigClub", Integer.TYPE));
      label2743:
      i = paramCursor.getColumnIndex("cNewLoverDiamondFlag");
      if (i != -1) {
        break label3695;
      }
      paramatmz.a(new NoColumnError("cNewLoverDiamondFlag", Integer.TYPE));
      label2778:
      i = paramCursor.getColumnIndex("relationIconFlag");
      if (i != -1) {
        break label3710;
      }
      paramatmz.a(new NoColumnError("relationIconFlag", Integer.TYPE));
      label2813:
      i = paramCursor.getColumnIndex("uExtOnlineStatus");
      if (i != -1) {
        break label3725;
      }
      paramatmz.a(new NoColumnError("uExtOnlineStatus", Long.TYPE));
      label2848:
      i = paramCursor.getColumnIndex("iBatteryStatus");
      if (i != -1) {
        break label3740;
      }
      paramatmz.a(new NoColumnError("iBatteryStatus", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("customModel");
      if (i != -1) {
        break label3755;
      }
      paramatmz.a(new NoColumnError("customModel", String.class));
      return paramatmo;
      paramatmo.uin = paramCursor.getString(i);
      break;
      label2939:
      paramatmo.remark = paramCursor.getString(i);
      break label1098;
      label2954:
      paramatmo.name = paramCursor.getString(i);
      break label1133;
      label2969:
      paramatmo.faceid = paramCursor.getShort(i);
      break label1168;
      label2984:
      paramatmo.status = ((byte)paramCursor.getShort(i));
      break label1203;
      label3000:
      paramatmo.sqqtype = ((byte)paramCursor.getShort(i));
      break label1238;
      label3016:
      paramatmo.cSpecialFlag = ((byte)paramCursor.getShort(i));
      break label1273;
      label3032:
      paramatmo.groupid = paramCursor.getInt(i);
      break label1308;
      label3047:
      paramatmo.memberLevel = ((byte)paramCursor.getShort(i));
      break label1343;
      label3063:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isMqqOnLine = paramBoolean;
        break;
      }
      label3090:
      paramatmo.sqqOnLineState = ((byte)paramCursor.getShort(i));
      break label1413;
      label3106:
      paramatmo.detalStatusFlag = ((byte)paramCursor.getShort(i));
      break label1448;
      label3122:
      paramatmo.datetime = paramCursor.getLong(i);
      break label1483;
      label3137:
      paramatmo.alias = paramCursor.getString(i);
      break label1518;
      label3152:
      paramatmo.gathtertype = ((byte)paramCursor.getShort(i));
      break label1553;
      label3168:
      paramatmo.smartRemark = paramCursor.getString(i);
      break label1588;
      label3183:
      paramatmo.age = paramCursor.getInt(i);
      break label1623;
      label3198:
      paramatmo.gender = ((byte)paramCursor.getShort(i));
      break label1658;
      label3214:
      paramatmo.recommReason = paramCursor.getString(i);
      break label1693;
      label3229:
      paramatmo.signature = paramCursor.getString(i);
      break label1728;
      label3244:
      paramatmo.isIphoneOnline = ((byte)paramCursor.getShort(i));
      break label1763;
      label3260:
      paramatmo.isRemark = ((byte)paramCursor.getShort(i));
      break label1798;
      label3276:
      paramatmo.iTermType = paramCursor.getInt(i);
      break label1833;
      label3291:
      paramatmo.qqVipInfo = paramCursor.getInt(i);
      break label1868;
      label3306:
      paramatmo.superQqInfo = paramCursor.getInt(i);
      break label1903;
      label3321:
      paramatmo.superVipInfo = paramCursor.getInt(i);
      break label1938;
      label3336:
      paramatmo.hollywoodVipInfo = paramCursor.getInt(i);
      break label1973;
      label3351:
      paramatmo.lastLoginType = paramCursor.getLong(i);
      break label2008;
      label3366:
      paramatmo.showLoginClient = paramCursor.getLong(i);
      break label2043;
      label3381:
      paramatmo.medalsInfo = paramCursor.getString(i);
      break label2078;
      label3396:
      paramatmo.nameplateCfgInfo = paramCursor.getString(i);
      break label2113;
      label3411:
      paramatmo.richTime = paramCursor.getLong(i);
      break label2148;
      label3426:
      paramatmo.richBuffer = paramCursor.getBlob(i);
      break label2183;
      label3441:
      paramatmo.mComparePartInt = paramCursor.getInt(i);
      break label2218;
      label3456:
      paramatmo.mCompareSpell = paramCursor.getString(i);
      break label2253;
      label3471:
      paramatmo.cNetwork = ((byte)paramCursor.getShort(i));
      break label2288;
      label3487:
      paramatmo.eNetwork = paramCursor.getInt(i);
      break label2323;
      label3502:
      paramatmo.namePlateOfKingGameId = paramCursor.getLong(i);
      break label2358;
      label3517:
      paramatmo.namePlateOfKingLoginTime = paramCursor.getLong(i);
      break label2393;
      label3532:
      paramatmo.namePlateOfKingDan = paramCursor.getInt(i);
      break label2428;
      label3547:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramatmo.namePlateOfKingDanDisplatSwitch = paramBoolean;
        break;
      }
      label3575:
      paramatmo.strMasterUin = paramCursor.getString(i);
      break label2498;
      label3590:
      paramatmo.multiFlags = paramCursor.getInt(i);
      break label2533;
      label3605:
      paramatmo.friendType = paramCursor.getInt(i);
      break label2568;
      label3620:
      paramatmo.abilityBits = paramCursor.getLong(i);
      break label2603;
      label3635:
      paramatmo.bigClubInfo = paramCursor.getInt(i);
      break label2638;
      label3650:
      paramatmo.superVipTemplateId = paramCursor.getInt(i);
      break label2673;
      label3665:
      paramatmo.bigClubTemplateId = paramCursor.getInt(i);
      break label2708;
      label3680:
      paramatmo.isHideBigClub = paramCursor.getInt(i);
      break label2743;
      label3695:
      paramatmo.cNewLoverDiamondFlag = paramCursor.getInt(i);
      break label2778;
      label3710:
      paramatmo.relationIconFlag = paramCursor.getInt(i);
      break label2813;
      label3725:
      paramatmo.uExtOnlineStatus = paramCursor.getLong(i);
      break label2848;
      label3740:
      paramatmo.iBatteryStatus = paramCursor.getInt(i);
    }
    label3755:
    paramatmo.customModel = paramCursor.getString(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,remark TEXT ,name TEXT ,faceid INTEGER ,status INTEGER ,sqqtype INTEGER ,cSpecialFlag INTEGER ,groupid INTEGER ,memberLevel INTEGER ,isMqqOnLine INTEGER ,sqqOnLineState INTEGER ,detalStatusFlag INTEGER ,datetime INTEGER ,alias TEXT ,gathtertype INTEGER ,smartRemark TEXT ,age INTEGER ,gender INTEGER ,recommReason TEXT ,signature TEXT ,isIphoneOnline INTEGER ,isRemark INTEGER ,iTermType INTEGER ,qqVipInfo INTEGER ,superQqInfo INTEGER ,superVipInfo INTEGER ,hollywoodVipInfo INTEGER ,lastLoginType INTEGER ,showLoginClient INTEGER ,medalsInfo TEXT ,nameplateCfgInfo TEXT ,richTime INTEGER ,richBuffer BLOB ,mComparePartInt INTEGER ,mCompareSpell TEXT ,cNetwork INTEGER ,eNetwork INTEGER ,namePlateOfKingGameId INTEGER ,namePlateOfKingLoginTime INTEGER ,namePlateOfKingDan INTEGER ,namePlateOfKingDanDisplatSwitch INTEGER ,strMasterUin TEXT ,multiFlags INTEGER ,friendType INTEGER ,abilityBits INTEGER ,bigClubInfo INTEGER ,superVipTemplateId INTEGER ,bigClubTemplateId INTEGER ,isHideBigClub INTEGER ,cNewLoverDiamondFlag INTEGER ,relationIconFlag INTEGER ,uExtOnlineStatus INTEGER ,iBatteryStatus INTEGER ,customModel TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (Friends)paramatmo;
    paramContentValues.put("uin", paramatmo.uin);
    paramContentValues.put("remark", paramatmo.remark);
    paramContentValues.put("name", paramatmo.name);
    paramContentValues.put("faceid", Short.valueOf(paramatmo.faceid));
    paramContentValues.put("status", Byte.valueOf(paramatmo.status));
    paramContentValues.put("sqqtype", Byte.valueOf(paramatmo.sqqtype));
    paramContentValues.put("cSpecialFlag", Byte.valueOf(paramatmo.cSpecialFlag));
    paramContentValues.put("groupid", Integer.valueOf(paramatmo.groupid));
    paramContentValues.put("memberLevel", Byte.valueOf(paramatmo.memberLevel));
    paramContentValues.put("isMqqOnLine", Boolean.valueOf(paramatmo.isMqqOnLine));
    paramContentValues.put("sqqOnLineState", Byte.valueOf(paramatmo.sqqOnLineState));
    paramContentValues.put("detalStatusFlag", Byte.valueOf(paramatmo.detalStatusFlag));
    paramContentValues.put("datetime", Long.valueOf(paramatmo.datetime));
    paramContentValues.put("alias", paramatmo.alias);
    paramContentValues.put("gathtertype", Byte.valueOf(paramatmo.gathtertype));
    paramContentValues.put("smartRemark", paramatmo.smartRemark);
    paramContentValues.put("age", Integer.valueOf(paramatmo.age));
    paramContentValues.put("gender", Byte.valueOf(paramatmo.gender));
    paramContentValues.put("recommReason", paramatmo.recommReason);
    paramContentValues.put("signature", paramatmo.signature);
    paramContentValues.put("isIphoneOnline", Byte.valueOf(paramatmo.isIphoneOnline));
    paramContentValues.put("isRemark", Byte.valueOf(paramatmo.isRemark));
    paramContentValues.put("iTermType", Integer.valueOf(paramatmo.iTermType));
    paramContentValues.put("qqVipInfo", Integer.valueOf(paramatmo.qqVipInfo));
    paramContentValues.put("superQqInfo", Integer.valueOf(paramatmo.superQqInfo));
    paramContentValues.put("superVipInfo", Integer.valueOf(paramatmo.superVipInfo));
    paramContentValues.put("hollywoodVipInfo", Integer.valueOf(paramatmo.hollywoodVipInfo));
    paramContentValues.put("lastLoginType", Long.valueOf(paramatmo.lastLoginType));
    paramContentValues.put("showLoginClient", Long.valueOf(paramatmo.showLoginClient));
    paramContentValues.put("medalsInfo", paramatmo.medalsInfo);
    paramContentValues.put("nameplateCfgInfo", paramatmo.nameplateCfgInfo);
    paramContentValues.put("richTime", Long.valueOf(paramatmo.richTime));
    paramContentValues.put("richBuffer", paramatmo.richBuffer);
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramatmo.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramatmo.mCompareSpell);
    paramContentValues.put("cNetwork", Byte.valueOf(paramatmo.cNetwork));
    paramContentValues.put("eNetwork", Integer.valueOf(paramatmo.eNetwork));
    paramContentValues.put("namePlateOfKingGameId", Long.valueOf(paramatmo.namePlateOfKingGameId));
    paramContentValues.put("namePlateOfKingLoginTime", Long.valueOf(paramatmo.namePlateOfKingLoginTime));
    paramContentValues.put("namePlateOfKingDan", Integer.valueOf(paramatmo.namePlateOfKingDan));
    paramContentValues.put("namePlateOfKingDanDisplatSwitch", Boolean.valueOf(paramatmo.namePlateOfKingDanDisplatSwitch));
    paramContentValues.put("strMasterUin", paramatmo.strMasterUin);
    paramContentValues.put("multiFlags", Integer.valueOf(paramatmo.multiFlags));
    paramContentValues.put("friendType", Integer.valueOf(paramatmo.friendType));
    paramContentValues.put("abilityBits", Long.valueOf(paramatmo.abilityBits));
    paramContentValues.put("bigClubInfo", Integer.valueOf(paramatmo.bigClubInfo));
    paramContentValues.put("superVipTemplateId", Integer.valueOf(paramatmo.superVipTemplateId));
    paramContentValues.put("bigClubTemplateId", Integer.valueOf(paramatmo.bigClubTemplateId));
    paramContentValues.put("isHideBigClub", Integer.valueOf(paramatmo.isHideBigClub));
    paramContentValues.put("cNewLoverDiamondFlag", Integer.valueOf(paramatmo.cNewLoverDiamondFlag));
    paramContentValues.put("relationIconFlag", Integer.valueOf(paramatmo.relationIconFlag));
    paramContentValues.put("uExtOnlineStatus", Long.valueOf(paramatmo.uExtOnlineStatus));
    paramContentValues.put("iBatteryStatus", Integer.valueOf(paramatmo.iBatteryStatus));
    paramContentValues.put("customModel", paramatmo.customModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atmu
 * JD-Core Version:    0.7.0.1
 */