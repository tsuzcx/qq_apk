import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awgk
  extends awgq
{
  public awgk()
  {
    this.a = 60;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawge = (Friends)paramawge;
    if (paramawgp == null)
    {
      paramawge.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawge.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramawge.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramawge.faceid = paramCursor.getShort(paramCursor.getColumnIndex("faceid"));
      paramawge.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("status")));
      paramawge.sqqtype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sqqtype")));
      paramawge.cSpecialFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSpecialFlag")));
      paramawge.groupid = paramCursor.getInt(paramCursor.getColumnIndex("groupid"));
      paramawge.memberLevel = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("memberLevel")));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isMqqOnLine")))
      {
        paramBoolean = true;
        paramawge.isMqqOnLine = paramBoolean;
        paramawge.sqqOnLineState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sqqOnLineState")));
        paramawge.detalStatusFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("detalStatusFlag")));
        paramawge.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
        paramawge.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
        paramawge.gathtertype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gathtertype")));
        paramawge.smartRemark = paramCursor.getString(paramCursor.getColumnIndex("smartRemark"));
        paramawge.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
        paramawge.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
        paramawge.recommReason = paramCursor.getString(paramCursor.getColumnIndex("recommReason"));
        paramawge.signature = paramCursor.getString(paramCursor.getColumnIndex("signature"));
        paramawge.isIphoneOnline = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isIphoneOnline")));
        paramawge.isRemark = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isRemark")));
        paramawge.iTermType = paramCursor.getInt(paramCursor.getColumnIndex("iTermType"));
        paramawge.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
        paramawge.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
        paramawge.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
        paramawge.hollywoodVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("hollywoodVipInfo"));
        paramawge.lastLoginType = paramCursor.getLong(paramCursor.getColumnIndex("lastLoginType"));
        paramawge.showLoginClient = paramCursor.getLong(paramCursor.getColumnIndex("showLoginClient"));
        paramawge.medalsInfo = paramCursor.getString(paramCursor.getColumnIndex("medalsInfo"));
        paramawge.nameplateCfgInfo = paramCursor.getString(paramCursor.getColumnIndex("nameplateCfgInfo"));
        paramawge.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
        paramawge.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
        paramawge.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramawge.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramawge.cNetwork = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cNetwork")));
        paramawge.eNetwork = paramCursor.getInt(paramCursor.getColumnIndex("eNetwork"));
        paramawge.namePlateOfKingGameId = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingGameId"));
        paramawge.namePlateOfKingLoginTime = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingLoginTime"));
        paramawge.namePlateOfKingDan = paramCursor.getInt(paramCursor.getColumnIndex("namePlateOfKingDan"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch"))) {
          break label1137;
        }
      }
      label1137:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramawge.namePlateOfKingDanDisplatSwitch = paramBoolean;
        paramawge.strMasterUin = paramCursor.getString(paramCursor.getColumnIndex("strMasterUin"));
        paramawge.multiFlags = paramCursor.getInt(paramCursor.getColumnIndex("multiFlags"));
        paramawge.friendType = paramCursor.getInt(paramCursor.getColumnIndex("friendType"));
        paramawge.abilityBits = paramCursor.getLong(paramCursor.getColumnIndex("abilityBits"));
        paramawge.bigClubInfo = paramCursor.getInt(paramCursor.getColumnIndex("bigClubInfo"));
        paramawge.superVipTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("superVipTemplateId"));
        paramawge.bigClubTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("bigClubTemplateId"));
        paramawge.nameplateVipType = paramCursor.getInt(paramCursor.getColumnIndex("nameplateVipType"));
        paramawge.grayNameplateFlag = paramCursor.getInt(paramCursor.getColumnIndex("grayNameplateFlag"));
        paramawge.cNewLoverDiamondFlag = paramCursor.getInt(paramCursor.getColumnIndex("cNewLoverDiamondFlag"));
        paramawge.relationIconFlag = paramCursor.getInt(paramCursor.getColumnIndex("relationIconFlag"));
        paramawge.uExtOnlineStatus = paramCursor.getLong(paramCursor.getColumnIndex("uExtOnlineStatus"));
        paramawge.iBatteryStatus = paramCursor.getInt(paramCursor.getColumnIndex("iBatteryStatus"));
        paramawge.customModel = paramCursor.getString(paramCursor.getColumnIndex("customModel"));
        paramawge.songId = paramCursor.getString(paramCursor.getColumnIndex("songId"));
        paramawge.songName = paramCursor.getString(paramCursor.getColumnIndex("songName"));
        paramawge.singerName = paramCursor.getString(paramCursor.getColumnIndex("singerName"));
        paramawge.songEndTime = paramCursor.getLong(paramCursor.getColumnIndex("songEndTime"));
        paramawge.songSourceType = paramCursor.getInt(paramCursor.getColumnIndex("songSourceType"));
        return paramawge;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label3275;
      }
      paramawgp.a(new NoColumnError("remark", String.class));
      label1212:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label3290;
      }
      paramawgp.a(new NoColumnError("name", String.class));
      label1247:
      i = paramCursor.getColumnIndex("faceid");
      if (i != -1) {
        break label3305;
      }
      paramawgp.a(new NoColumnError("faceid", Short.TYPE));
      label1282:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label3320;
      }
      paramawgp.a(new NoColumnError("status", Byte.TYPE));
      label1317:
      i = paramCursor.getColumnIndex("sqqtype");
      if (i != -1) {
        break label3336;
      }
      paramawgp.a(new NoColumnError("sqqtype", Byte.TYPE));
      label1352:
      i = paramCursor.getColumnIndex("cSpecialFlag");
      if (i != -1) {
        break label3352;
      }
      paramawgp.a(new NoColumnError("cSpecialFlag", Byte.TYPE));
      label1387:
      i = paramCursor.getColumnIndex("groupid");
      if (i != -1) {
        break label3368;
      }
      paramawgp.a(new NoColumnError("groupid", Integer.TYPE));
      label1422:
      i = paramCursor.getColumnIndex("memberLevel");
      if (i != -1) {
        break label3383;
      }
      paramawgp.a(new NoColumnError("memberLevel", Byte.TYPE));
      label1457:
      i = paramCursor.getColumnIndex("isMqqOnLine");
      if (i != -1) {
        break label3399;
      }
      paramawgp.a(new NoColumnError("isMqqOnLine", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sqqOnLineState");
      if (i != -1) {
        break label3426;
      }
      paramawgp.a(new NoColumnError("sqqOnLineState", Byte.TYPE));
      label1527:
      i = paramCursor.getColumnIndex("detalStatusFlag");
      if (i != -1) {
        break label3442;
      }
      paramawgp.a(new NoColumnError("detalStatusFlag", Byte.TYPE));
      label1562:
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label3458;
      }
      paramawgp.a(new NoColumnError("datetime", Long.TYPE));
      label1597:
      i = paramCursor.getColumnIndex("alias");
      if (i != -1) {
        break label3473;
      }
      paramawgp.a(new NoColumnError("alias", String.class));
      label1632:
      i = paramCursor.getColumnIndex("gathtertype");
      if (i != -1) {
        break label3488;
      }
      paramawgp.a(new NoColumnError("gathtertype", Byte.TYPE));
      label1667:
      i = paramCursor.getColumnIndex("smartRemark");
      if (i != -1) {
        break label3504;
      }
      paramawgp.a(new NoColumnError("smartRemark", String.class));
      label1702:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label3519;
      }
      paramawgp.a(new NoColumnError("age", Integer.TYPE));
      label1737:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label3534;
      }
      paramawgp.a(new NoColumnError("gender", Byte.TYPE));
      label1772:
      i = paramCursor.getColumnIndex("recommReason");
      if (i != -1) {
        break label3550;
      }
      paramawgp.a(new NoColumnError("recommReason", String.class));
      label1807:
      i = paramCursor.getColumnIndex("signature");
      if (i != -1) {
        break label3565;
      }
      paramawgp.a(new NoColumnError("signature", String.class));
      label1842:
      i = paramCursor.getColumnIndex("isIphoneOnline");
      if (i != -1) {
        break label3580;
      }
      paramawgp.a(new NoColumnError("isIphoneOnline", Byte.TYPE));
      label1877:
      i = paramCursor.getColumnIndex("isRemark");
      if (i != -1) {
        break label3596;
      }
      paramawgp.a(new NoColumnError("isRemark", Byte.TYPE));
      label1912:
      i = paramCursor.getColumnIndex("iTermType");
      if (i != -1) {
        break label3612;
      }
      paramawgp.a(new NoColumnError("iTermType", Integer.TYPE));
      label1947:
      i = paramCursor.getColumnIndex("qqVipInfo");
      if (i != -1) {
        break label3627;
      }
      paramawgp.a(new NoColumnError("qqVipInfo", Integer.TYPE));
      label1982:
      i = paramCursor.getColumnIndex("superQqInfo");
      if (i != -1) {
        break label3642;
      }
      paramawgp.a(new NoColumnError("superQqInfo", Integer.TYPE));
      label2017:
      i = paramCursor.getColumnIndex("superVipInfo");
      if (i != -1) {
        break label3657;
      }
      paramawgp.a(new NoColumnError("superVipInfo", Integer.TYPE));
      label2052:
      i = paramCursor.getColumnIndex("hollywoodVipInfo");
      if (i != -1) {
        break label3672;
      }
      paramawgp.a(new NoColumnError("hollywoodVipInfo", Integer.TYPE));
      label2087:
      i = paramCursor.getColumnIndex("lastLoginType");
      if (i != -1) {
        break label3687;
      }
      paramawgp.a(new NoColumnError("lastLoginType", Long.TYPE));
      label2122:
      i = paramCursor.getColumnIndex("showLoginClient");
      if (i != -1) {
        break label3702;
      }
      paramawgp.a(new NoColumnError("showLoginClient", Long.TYPE));
      label2157:
      i = paramCursor.getColumnIndex("medalsInfo");
      if (i != -1) {
        break label3717;
      }
      paramawgp.a(new NoColumnError("medalsInfo", String.class));
      label2192:
      i = paramCursor.getColumnIndex("nameplateCfgInfo");
      if (i != -1) {
        break label3732;
      }
      paramawgp.a(new NoColumnError("nameplateCfgInfo", String.class));
      label2227:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label3747;
      }
      paramawgp.a(new NoColumnError("richTime", Long.TYPE));
      label2262:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label3762;
      }
      paramawgp.a(new NoColumnError("richBuffer", [B.class));
      label2297:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label3777;
      }
      paramawgp.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label2332:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label3792;
      }
      paramawgp.a(new NoColumnError("mCompareSpell", String.class));
      label2367:
      i = paramCursor.getColumnIndex("cNetwork");
      if (i != -1) {
        break label3807;
      }
      paramawgp.a(new NoColumnError("cNetwork", Byte.TYPE));
      label2402:
      i = paramCursor.getColumnIndex("eNetwork");
      if (i != -1) {
        break label3823;
      }
      paramawgp.a(new NoColumnError("eNetwork", Integer.TYPE));
      label2437:
      i = paramCursor.getColumnIndex("namePlateOfKingGameId");
      if (i != -1) {
        break label3838;
      }
      paramawgp.a(new NoColumnError("namePlateOfKingGameId", Long.TYPE));
      label2472:
      i = paramCursor.getColumnIndex("namePlateOfKingLoginTime");
      if (i != -1) {
        break label3853;
      }
      paramawgp.a(new NoColumnError("namePlateOfKingLoginTime", Long.TYPE));
      label2507:
      i = paramCursor.getColumnIndex("namePlateOfKingDan");
      if (i != -1) {
        break label3868;
      }
      paramawgp.a(new NoColumnError("namePlateOfKingDan", Integer.TYPE));
      label2542:
      i = paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch");
      if (i != -1) {
        break label3883;
      }
      paramawgp.a(new NoColumnError("namePlateOfKingDanDisplatSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("strMasterUin");
      if (i != -1) {
        break label3911;
      }
      paramawgp.a(new NoColumnError("strMasterUin", String.class));
      label2612:
      i = paramCursor.getColumnIndex("multiFlags");
      if (i != -1) {
        break label3926;
      }
      paramawgp.a(new NoColumnError("multiFlags", Integer.TYPE));
      label2647:
      i = paramCursor.getColumnIndex("friendType");
      if (i != -1) {
        break label3941;
      }
      paramawgp.a(new NoColumnError("friendType", Integer.TYPE));
      label2682:
      i = paramCursor.getColumnIndex("abilityBits");
      if (i != -1) {
        break label3956;
      }
      paramawgp.a(new NoColumnError("abilityBits", Long.TYPE));
      label2717:
      i = paramCursor.getColumnIndex("bigClubInfo");
      if (i != -1) {
        break label3971;
      }
      paramawgp.a(new NoColumnError("bigClubInfo", Integer.TYPE));
      label2752:
      i = paramCursor.getColumnIndex("superVipTemplateId");
      if (i != -1) {
        break label3986;
      }
      paramawgp.a(new NoColumnError("superVipTemplateId", Integer.TYPE));
      label2787:
      i = paramCursor.getColumnIndex("bigClubTemplateId");
      if (i != -1) {
        break label4001;
      }
      paramawgp.a(new NoColumnError("bigClubTemplateId", Integer.TYPE));
      label2822:
      i = paramCursor.getColumnIndex("nameplateVipType");
      if (i != -1) {
        break label4016;
      }
      paramawgp.a(new NoColumnError("nameplateVipType", Integer.TYPE));
      label2857:
      i = paramCursor.getColumnIndex("grayNameplateFlag");
      if (i != -1) {
        break label4031;
      }
      paramawgp.a(new NoColumnError("grayNameplateFlag", Integer.TYPE));
      label2892:
      i = paramCursor.getColumnIndex("cNewLoverDiamondFlag");
      if (i != -1) {
        break label4046;
      }
      paramawgp.a(new NoColumnError("cNewLoverDiamondFlag", Integer.TYPE));
      label2927:
      i = paramCursor.getColumnIndex("relationIconFlag");
      if (i != -1) {
        break label4061;
      }
      paramawgp.a(new NoColumnError("relationIconFlag", Integer.TYPE));
      label2962:
      i = paramCursor.getColumnIndex("uExtOnlineStatus");
      if (i != -1) {
        break label4076;
      }
      paramawgp.a(new NoColumnError("uExtOnlineStatus", Long.TYPE));
      label2999:
      i = paramCursor.getColumnIndex("iBatteryStatus");
      if (i != -1) {
        break label4091;
      }
      paramawgp.a(new NoColumnError("iBatteryStatus", Integer.TYPE));
      label3036:
      i = paramCursor.getColumnIndex("customModel");
      if (i != -1) {
        break label4106;
      }
      paramawgp.a(new NoColumnError("customModel", String.class));
      label3073:
      i = paramCursor.getColumnIndex("songId");
      if (i != -1) {
        break label4121;
      }
      paramawgp.a(new NoColumnError("songId", String.class));
      label3110:
      i = paramCursor.getColumnIndex("songName");
      if (i != -1) {
        break label4136;
      }
      paramawgp.a(new NoColumnError("songName", String.class));
      label3147:
      i = paramCursor.getColumnIndex("singerName");
      if (i != -1) {
        break label4151;
      }
      paramawgp.a(new NoColumnError("singerName", String.class));
      label3184:
      i = paramCursor.getColumnIndex("songEndTime");
      if (i != -1) {
        break label4166;
      }
      paramawgp.a(new NoColumnError("songEndTime", Long.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("songSourceType");
      if (i != -1) {
        break label4181;
      }
      paramawgp.a(new NoColumnError("songSourceType", Integer.TYPE));
      return paramawge;
      paramawge.uin = paramCursor.getString(i);
      break;
      label3275:
      paramawge.remark = paramCursor.getString(i);
      break label1212;
      label3290:
      paramawge.name = paramCursor.getString(i);
      break label1247;
      label3305:
      paramawge.faceid = paramCursor.getShort(i);
      break label1282;
      label3320:
      paramawge.status = ((byte)paramCursor.getShort(i));
      break label1317;
      label3336:
      paramawge.sqqtype = ((byte)paramCursor.getShort(i));
      break label1352;
      label3352:
      paramawge.cSpecialFlag = ((byte)paramCursor.getShort(i));
      break label1387;
      label3368:
      paramawge.groupid = paramCursor.getInt(i);
      break label1422;
      label3383:
      paramawge.memberLevel = ((byte)paramCursor.getShort(i));
      break label1457;
      label3399:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isMqqOnLine = paramBoolean;
        break;
      }
      label3426:
      paramawge.sqqOnLineState = ((byte)paramCursor.getShort(i));
      break label1527;
      label3442:
      paramawge.detalStatusFlag = ((byte)paramCursor.getShort(i));
      break label1562;
      label3458:
      paramawge.datetime = paramCursor.getLong(i);
      break label1597;
      label3473:
      paramawge.alias = paramCursor.getString(i);
      break label1632;
      label3488:
      paramawge.gathtertype = ((byte)paramCursor.getShort(i));
      break label1667;
      label3504:
      paramawge.smartRemark = paramCursor.getString(i);
      break label1702;
      label3519:
      paramawge.age = paramCursor.getInt(i);
      break label1737;
      label3534:
      paramawge.gender = ((byte)paramCursor.getShort(i));
      break label1772;
      label3550:
      paramawge.recommReason = paramCursor.getString(i);
      break label1807;
      label3565:
      paramawge.signature = paramCursor.getString(i);
      break label1842;
      label3580:
      paramawge.isIphoneOnline = ((byte)paramCursor.getShort(i));
      break label1877;
      label3596:
      paramawge.isRemark = ((byte)paramCursor.getShort(i));
      break label1912;
      label3612:
      paramawge.iTermType = paramCursor.getInt(i);
      break label1947;
      label3627:
      paramawge.qqVipInfo = paramCursor.getInt(i);
      break label1982;
      label3642:
      paramawge.superQqInfo = paramCursor.getInt(i);
      break label2017;
      label3657:
      paramawge.superVipInfo = paramCursor.getInt(i);
      break label2052;
      label3672:
      paramawge.hollywoodVipInfo = paramCursor.getInt(i);
      break label2087;
      label3687:
      paramawge.lastLoginType = paramCursor.getLong(i);
      break label2122;
      label3702:
      paramawge.showLoginClient = paramCursor.getLong(i);
      break label2157;
      label3717:
      paramawge.medalsInfo = paramCursor.getString(i);
      break label2192;
      label3732:
      paramawge.nameplateCfgInfo = paramCursor.getString(i);
      break label2227;
      label3747:
      paramawge.richTime = paramCursor.getLong(i);
      break label2262;
      label3762:
      paramawge.richBuffer = paramCursor.getBlob(i);
      break label2297;
      label3777:
      paramawge.mComparePartInt = paramCursor.getInt(i);
      break label2332;
      label3792:
      paramawge.mCompareSpell = paramCursor.getString(i);
      break label2367;
      label3807:
      paramawge.cNetwork = ((byte)paramCursor.getShort(i));
      break label2402;
      label3823:
      paramawge.eNetwork = paramCursor.getInt(i);
      break label2437;
      label3838:
      paramawge.namePlateOfKingGameId = paramCursor.getLong(i);
      break label2472;
      label3853:
      paramawge.namePlateOfKingLoginTime = paramCursor.getLong(i);
      break label2507;
      label3868:
      paramawge.namePlateOfKingDan = paramCursor.getInt(i);
      break label2542;
      label3883:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramawge.namePlateOfKingDanDisplatSwitch = paramBoolean;
        break;
      }
      label3911:
      paramawge.strMasterUin = paramCursor.getString(i);
      break label2612;
      label3926:
      paramawge.multiFlags = paramCursor.getInt(i);
      break label2647;
      label3941:
      paramawge.friendType = paramCursor.getInt(i);
      break label2682;
      label3956:
      paramawge.abilityBits = paramCursor.getLong(i);
      break label2717;
      label3971:
      paramawge.bigClubInfo = paramCursor.getInt(i);
      break label2752;
      label3986:
      paramawge.superVipTemplateId = paramCursor.getInt(i);
      break label2787;
      label4001:
      paramawge.bigClubTemplateId = paramCursor.getInt(i);
      break label2822;
      label4016:
      paramawge.nameplateVipType = paramCursor.getInt(i);
      break label2857;
      label4031:
      paramawge.grayNameplateFlag = paramCursor.getInt(i);
      break label2892;
      label4046:
      paramawge.cNewLoverDiamondFlag = paramCursor.getInt(i);
      break label2927;
      label4061:
      paramawge.relationIconFlag = paramCursor.getInt(i);
      break label2962;
      label4076:
      paramawge.uExtOnlineStatus = paramCursor.getLong(i);
      break label2999;
      label4091:
      paramawge.iBatteryStatus = paramCursor.getInt(i);
      break label3036;
      label4106:
      paramawge.customModel = paramCursor.getString(i);
      break label3073;
      label4121:
      paramawge.songId = paramCursor.getString(i);
      break label3110;
      label4136:
      paramawge.songName = paramCursor.getString(i);
      break label3147;
      label4151:
      paramawge.singerName = paramCursor.getString(i);
      break label3184;
      label4166:
      paramawge.songEndTime = paramCursor.getLong(i);
    }
    label4181:
    paramawge.songSourceType = paramCursor.getInt(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,remark TEXT ,name TEXT ,faceid INTEGER ,status INTEGER ,sqqtype INTEGER ,cSpecialFlag INTEGER ,groupid INTEGER ,memberLevel INTEGER ,isMqqOnLine INTEGER ,sqqOnLineState INTEGER ,detalStatusFlag INTEGER ,datetime INTEGER ,alias TEXT ,gathtertype INTEGER ,smartRemark TEXT ,age INTEGER ,gender INTEGER ,recommReason TEXT ,signature TEXT ,isIphoneOnline INTEGER ,isRemark INTEGER ,iTermType INTEGER ,qqVipInfo INTEGER ,superQqInfo INTEGER ,superVipInfo INTEGER ,hollywoodVipInfo INTEGER ,lastLoginType INTEGER ,showLoginClient INTEGER ,medalsInfo TEXT ,nameplateCfgInfo TEXT ,richTime INTEGER ,richBuffer BLOB ,mComparePartInt INTEGER ,mCompareSpell TEXT ,cNetwork INTEGER ,eNetwork INTEGER ,namePlateOfKingGameId INTEGER ,namePlateOfKingLoginTime INTEGER ,namePlateOfKingDan INTEGER ,namePlateOfKingDanDisplatSwitch INTEGER ,strMasterUin TEXT ,multiFlags INTEGER ,friendType INTEGER ,abilityBits INTEGER ,bigClubInfo INTEGER ,superVipTemplateId INTEGER ,bigClubTemplateId INTEGER ,nameplateVipType INTEGER ,grayNameplateFlag INTEGER ,cNewLoverDiamondFlag INTEGER ,relationIconFlag INTEGER ,uExtOnlineStatus INTEGER ,iBatteryStatus INTEGER ,customModel TEXT ,songId TEXT ,songName TEXT ,singerName TEXT ,songEndTime INTEGER ,songSourceType INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (Friends)paramawge;
    paramContentValues.put("uin", paramawge.uin);
    paramContentValues.put("remark", paramawge.remark);
    paramContentValues.put("name", paramawge.name);
    paramContentValues.put("faceid", Short.valueOf(paramawge.faceid));
    paramContentValues.put("status", Byte.valueOf(paramawge.status));
    paramContentValues.put("sqqtype", Byte.valueOf(paramawge.sqqtype));
    paramContentValues.put("cSpecialFlag", Byte.valueOf(paramawge.cSpecialFlag));
    paramContentValues.put("groupid", Integer.valueOf(paramawge.groupid));
    paramContentValues.put("memberLevel", Byte.valueOf(paramawge.memberLevel));
    paramContentValues.put("isMqqOnLine", Boolean.valueOf(paramawge.isMqqOnLine));
    paramContentValues.put("sqqOnLineState", Byte.valueOf(paramawge.sqqOnLineState));
    paramContentValues.put("detalStatusFlag", Byte.valueOf(paramawge.detalStatusFlag));
    paramContentValues.put("datetime", Long.valueOf(paramawge.datetime));
    paramContentValues.put("alias", paramawge.alias);
    paramContentValues.put("gathtertype", Byte.valueOf(paramawge.gathtertype));
    paramContentValues.put("smartRemark", paramawge.smartRemark);
    paramContentValues.put("age", Integer.valueOf(paramawge.age));
    paramContentValues.put("gender", Byte.valueOf(paramawge.gender));
    paramContentValues.put("recommReason", paramawge.recommReason);
    paramContentValues.put("signature", paramawge.signature);
    paramContentValues.put("isIphoneOnline", Byte.valueOf(paramawge.isIphoneOnline));
    paramContentValues.put("isRemark", Byte.valueOf(paramawge.isRemark));
    paramContentValues.put("iTermType", Integer.valueOf(paramawge.iTermType));
    paramContentValues.put("qqVipInfo", Integer.valueOf(paramawge.qqVipInfo));
    paramContentValues.put("superQqInfo", Integer.valueOf(paramawge.superQqInfo));
    paramContentValues.put("superVipInfo", Integer.valueOf(paramawge.superVipInfo));
    paramContentValues.put("hollywoodVipInfo", Integer.valueOf(paramawge.hollywoodVipInfo));
    paramContentValues.put("lastLoginType", Long.valueOf(paramawge.lastLoginType));
    paramContentValues.put("showLoginClient", Long.valueOf(paramawge.showLoginClient));
    paramContentValues.put("medalsInfo", paramawge.medalsInfo);
    paramContentValues.put("nameplateCfgInfo", paramawge.nameplateCfgInfo);
    paramContentValues.put("richTime", Long.valueOf(paramawge.richTime));
    paramContentValues.put("richBuffer", paramawge.richBuffer);
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramawge.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramawge.mCompareSpell);
    paramContentValues.put("cNetwork", Byte.valueOf(paramawge.cNetwork));
    paramContentValues.put("eNetwork", Integer.valueOf(paramawge.eNetwork));
    paramContentValues.put("namePlateOfKingGameId", Long.valueOf(paramawge.namePlateOfKingGameId));
    paramContentValues.put("namePlateOfKingLoginTime", Long.valueOf(paramawge.namePlateOfKingLoginTime));
    paramContentValues.put("namePlateOfKingDan", Integer.valueOf(paramawge.namePlateOfKingDan));
    paramContentValues.put("namePlateOfKingDanDisplatSwitch", Boolean.valueOf(paramawge.namePlateOfKingDanDisplatSwitch));
    paramContentValues.put("strMasterUin", paramawge.strMasterUin);
    paramContentValues.put("multiFlags", Integer.valueOf(paramawge.multiFlags));
    paramContentValues.put("friendType", Integer.valueOf(paramawge.friendType));
    paramContentValues.put("abilityBits", Long.valueOf(paramawge.abilityBits));
    paramContentValues.put("bigClubInfo", Integer.valueOf(paramawge.bigClubInfo));
    paramContentValues.put("superVipTemplateId", Integer.valueOf(paramawge.superVipTemplateId));
    paramContentValues.put("bigClubTemplateId", Integer.valueOf(paramawge.bigClubTemplateId));
    paramContentValues.put("nameplateVipType", Integer.valueOf(paramawge.nameplateVipType));
    paramContentValues.put("grayNameplateFlag", Integer.valueOf(paramawge.grayNameplateFlag));
    paramContentValues.put("cNewLoverDiamondFlag", Integer.valueOf(paramawge.cNewLoverDiamondFlag));
    paramContentValues.put("relationIconFlag", Integer.valueOf(paramawge.relationIconFlag));
    paramContentValues.put("uExtOnlineStatus", Long.valueOf(paramawge.uExtOnlineStatus));
    paramContentValues.put("iBatteryStatus", Integer.valueOf(paramawge.iBatteryStatus));
    paramContentValues.put("customModel", paramawge.customModel);
    paramContentValues.put("songId", paramawge.songId);
    paramContentValues.put("songName", paramawge.songName);
    paramContentValues.put("singerName", paramawge.singerName);
    paramContentValues.put("songEndTime", Long.valueOf(paramawge.songEndTime));
    paramContentValues.put("songSourceType", Integer.valueOf(paramawge.songSourceType));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awgk
 * JD-Core Version:    0.7.0.1
 */