import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awcb
  extends awch
{
  public awcb()
  {
    this.a = 60;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawbv = (Friends)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawbv.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramawbv.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramawbv.faceid = paramCursor.getShort(paramCursor.getColumnIndex("faceid"));
      paramawbv.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("status")));
      paramawbv.sqqtype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sqqtype")));
      paramawbv.cSpecialFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSpecialFlag")));
      paramawbv.groupid = paramCursor.getInt(paramCursor.getColumnIndex("groupid"));
      paramawbv.memberLevel = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("memberLevel")));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isMqqOnLine")))
      {
        paramBoolean = true;
        paramawbv.isMqqOnLine = paramBoolean;
        paramawbv.sqqOnLineState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sqqOnLineState")));
        paramawbv.detalStatusFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("detalStatusFlag")));
        paramawbv.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
        paramawbv.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
        paramawbv.gathtertype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gathtertype")));
        paramawbv.smartRemark = paramCursor.getString(paramCursor.getColumnIndex("smartRemark"));
        paramawbv.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
        paramawbv.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
        paramawbv.recommReason = paramCursor.getString(paramCursor.getColumnIndex("recommReason"));
        paramawbv.signature = paramCursor.getString(paramCursor.getColumnIndex("signature"));
        paramawbv.isIphoneOnline = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isIphoneOnline")));
        paramawbv.isRemark = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isRemark")));
        paramawbv.iTermType = paramCursor.getInt(paramCursor.getColumnIndex("iTermType"));
        paramawbv.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
        paramawbv.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
        paramawbv.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
        paramawbv.hollywoodVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("hollywoodVipInfo"));
        paramawbv.lastLoginType = paramCursor.getLong(paramCursor.getColumnIndex("lastLoginType"));
        paramawbv.showLoginClient = paramCursor.getLong(paramCursor.getColumnIndex("showLoginClient"));
        paramawbv.medalsInfo = paramCursor.getString(paramCursor.getColumnIndex("medalsInfo"));
        paramawbv.nameplateCfgInfo = paramCursor.getString(paramCursor.getColumnIndex("nameplateCfgInfo"));
        paramawbv.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
        paramawbv.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
        paramawbv.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramawbv.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramawbv.cNetwork = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cNetwork")));
        paramawbv.eNetwork = paramCursor.getInt(paramCursor.getColumnIndex("eNetwork"));
        paramawbv.namePlateOfKingGameId = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingGameId"));
        paramawbv.namePlateOfKingLoginTime = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingLoginTime"));
        paramawbv.namePlateOfKingDan = paramCursor.getInt(paramCursor.getColumnIndex("namePlateOfKingDan"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch"))) {
          break label1137;
        }
      }
      label1137:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramawbv.namePlateOfKingDanDisplatSwitch = paramBoolean;
        paramawbv.strMasterUin = paramCursor.getString(paramCursor.getColumnIndex("strMasterUin"));
        paramawbv.multiFlags = paramCursor.getInt(paramCursor.getColumnIndex("multiFlags"));
        paramawbv.friendType = paramCursor.getInt(paramCursor.getColumnIndex("friendType"));
        paramawbv.abilityBits = paramCursor.getLong(paramCursor.getColumnIndex("abilityBits"));
        paramawbv.bigClubInfo = paramCursor.getInt(paramCursor.getColumnIndex("bigClubInfo"));
        paramawbv.superVipTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("superVipTemplateId"));
        paramawbv.bigClubTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("bigClubTemplateId"));
        paramawbv.nameplateVipType = paramCursor.getInt(paramCursor.getColumnIndex("nameplateVipType"));
        paramawbv.grayNameplateFlag = paramCursor.getInt(paramCursor.getColumnIndex("grayNameplateFlag"));
        paramawbv.cNewLoverDiamondFlag = paramCursor.getInt(paramCursor.getColumnIndex("cNewLoverDiamondFlag"));
        paramawbv.relationIconFlag = paramCursor.getInt(paramCursor.getColumnIndex("relationIconFlag"));
        paramawbv.uExtOnlineStatus = paramCursor.getLong(paramCursor.getColumnIndex("uExtOnlineStatus"));
        paramawbv.iBatteryStatus = paramCursor.getInt(paramCursor.getColumnIndex("iBatteryStatus"));
        paramawbv.customModel = paramCursor.getString(paramCursor.getColumnIndex("customModel"));
        paramawbv.songId = paramCursor.getString(paramCursor.getColumnIndex("songId"));
        paramawbv.songName = paramCursor.getString(paramCursor.getColumnIndex("songName"));
        paramawbv.singerName = paramCursor.getString(paramCursor.getColumnIndex("singerName"));
        paramawbv.songEndTime = paramCursor.getLong(paramCursor.getColumnIndex("songEndTime"));
        paramawbv.songSourceType = paramCursor.getInt(paramCursor.getColumnIndex("songSourceType"));
        return paramawbv;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label3275;
      }
      paramawcg.a(new NoColumnError("remark", String.class));
      label1212:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label3290;
      }
      paramawcg.a(new NoColumnError("name", String.class));
      label1247:
      i = paramCursor.getColumnIndex("faceid");
      if (i != -1) {
        break label3305;
      }
      paramawcg.a(new NoColumnError("faceid", Short.TYPE));
      label1282:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label3320;
      }
      paramawcg.a(new NoColumnError("status", Byte.TYPE));
      label1317:
      i = paramCursor.getColumnIndex("sqqtype");
      if (i != -1) {
        break label3336;
      }
      paramawcg.a(new NoColumnError("sqqtype", Byte.TYPE));
      label1352:
      i = paramCursor.getColumnIndex("cSpecialFlag");
      if (i != -1) {
        break label3352;
      }
      paramawcg.a(new NoColumnError("cSpecialFlag", Byte.TYPE));
      label1387:
      i = paramCursor.getColumnIndex("groupid");
      if (i != -1) {
        break label3368;
      }
      paramawcg.a(new NoColumnError("groupid", Integer.TYPE));
      label1422:
      i = paramCursor.getColumnIndex("memberLevel");
      if (i != -1) {
        break label3383;
      }
      paramawcg.a(new NoColumnError("memberLevel", Byte.TYPE));
      label1457:
      i = paramCursor.getColumnIndex("isMqqOnLine");
      if (i != -1) {
        break label3399;
      }
      paramawcg.a(new NoColumnError("isMqqOnLine", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sqqOnLineState");
      if (i != -1) {
        break label3426;
      }
      paramawcg.a(new NoColumnError("sqqOnLineState", Byte.TYPE));
      label1527:
      i = paramCursor.getColumnIndex("detalStatusFlag");
      if (i != -1) {
        break label3442;
      }
      paramawcg.a(new NoColumnError("detalStatusFlag", Byte.TYPE));
      label1562:
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label3458;
      }
      paramawcg.a(new NoColumnError("datetime", Long.TYPE));
      label1597:
      i = paramCursor.getColumnIndex("alias");
      if (i != -1) {
        break label3473;
      }
      paramawcg.a(new NoColumnError("alias", String.class));
      label1632:
      i = paramCursor.getColumnIndex("gathtertype");
      if (i != -1) {
        break label3488;
      }
      paramawcg.a(new NoColumnError("gathtertype", Byte.TYPE));
      label1667:
      i = paramCursor.getColumnIndex("smartRemark");
      if (i != -1) {
        break label3504;
      }
      paramawcg.a(new NoColumnError("smartRemark", String.class));
      label1702:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label3519;
      }
      paramawcg.a(new NoColumnError("age", Integer.TYPE));
      label1737:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label3534;
      }
      paramawcg.a(new NoColumnError("gender", Byte.TYPE));
      label1772:
      i = paramCursor.getColumnIndex("recommReason");
      if (i != -1) {
        break label3550;
      }
      paramawcg.a(new NoColumnError("recommReason", String.class));
      label1807:
      i = paramCursor.getColumnIndex("signature");
      if (i != -1) {
        break label3565;
      }
      paramawcg.a(new NoColumnError("signature", String.class));
      label1842:
      i = paramCursor.getColumnIndex("isIphoneOnline");
      if (i != -1) {
        break label3580;
      }
      paramawcg.a(new NoColumnError("isIphoneOnline", Byte.TYPE));
      label1877:
      i = paramCursor.getColumnIndex("isRemark");
      if (i != -1) {
        break label3596;
      }
      paramawcg.a(new NoColumnError("isRemark", Byte.TYPE));
      label1912:
      i = paramCursor.getColumnIndex("iTermType");
      if (i != -1) {
        break label3612;
      }
      paramawcg.a(new NoColumnError("iTermType", Integer.TYPE));
      label1947:
      i = paramCursor.getColumnIndex("qqVipInfo");
      if (i != -1) {
        break label3627;
      }
      paramawcg.a(new NoColumnError("qqVipInfo", Integer.TYPE));
      label1982:
      i = paramCursor.getColumnIndex("superQqInfo");
      if (i != -1) {
        break label3642;
      }
      paramawcg.a(new NoColumnError("superQqInfo", Integer.TYPE));
      label2017:
      i = paramCursor.getColumnIndex("superVipInfo");
      if (i != -1) {
        break label3657;
      }
      paramawcg.a(new NoColumnError("superVipInfo", Integer.TYPE));
      label2052:
      i = paramCursor.getColumnIndex("hollywoodVipInfo");
      if (i != -1) {
        break label3672;
      }
      paramawcg.a(new NoColumnError("hollywoodVipInfo", Integer.TYPE));
      label2087:
      i = paramCursor.getColumnIndex("lastLoginType");
      if (i != -1) {
        break label3687;
      }
      paramawcg.a(new NoColumnError("lastLoginType", Long.TYPE));
      label2122:
      i = paramCursor.getColumnIndex("showLoginClient");
      if (i != -1) {
        break label3702;
      }
      paramawcg.a(new NoColumnError("showLoginClient", Long.TYPE));
      label2157:
      i = paramCursor.getColumnIndex("medalsInfo");
      if (i != -1) {
        break label3717;
      }
      paramawcg.a(new NoColumnError("medalsInfo", String.class));
      label2192:
      i = paramCursor.getColumnIndex("nameplateCfgInfo");
      if (i != -1) {
        break label3732;
      }
      paramawcg.a(new NoColumnError("nameplateCfgInfo", String.class));
      label2227:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label3747;
      }
      paramawcg.a(new NoColumnError("richTime", Long.TYPE));
      label2262:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label3762;
      }
      paramawcg.a(new NoColumnError("richBuffer", [B.class));
      label2297:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label3777;
      }
      paramawcg.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label2332:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label3792;
      }
      paramawcg.a(new NoColumnError("mCompareSpell", String.class));
      label2367:
      i = paramCursor.getColumnIndex("cNetwork");
      if (i != -1) {
        break label3807;
      }
      paramawcg.a(new NoColumnError("cNetwork", Byte.TYPE));
      label2402:
      i = paramCursor.getColumnIndex("eNetwork");
      if (i != -1) {
        break label3823;
      }
      paramawcg.a(new NoColumnError("eNetwork", Integer.TYPE));
      label2437:
      i = paramCursor.getColumnIndex("namePlateOfKingGameId");
      if (i != -1) {
        break label3838;
      }
      paramawcg.a(new NoColumnError("namePlateOfKingGameId", Long.TYPE));
      label2472:
      i = paramCursor.getColumnIndex("namePlateOfKingLoginTime");
      if (i != -1) {
        break label3853;
      }
      paramawcg.a(new NoColumnError("namePlateOfKingLoginTime", Long.TYPE));
      label2507:
      i = paramCursor.getColumnIndex("namePlateOfKingDan");
      if (i != -1) {
        break label3868;
      }
      paramawcg.a(new NoColumnError("namePlateOfKingDan", Integer.TYPE));
      label2542:
      i = paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch");
      if (i != -1) {
        break label3883;
      }
      paramawcg.a(new NoColumnError("namePlateOfKingDanDisplatSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("strMasterUin");
      if (i != -1) {
        break label3911;
      }
      paramawcg.a(new NoColumnError("strMasterUin", String.class));
      label2612:
      i = paramCursor.getColumnIndex("multiFlags");
      if (i != -1) {
        break label3926;
      }
      paramawcg.a(new NoColumnError("multiFlags", Integer.TYPE));
      label2647:
      i = paramCursor.getColumnIndex("friendType");
      if (i != -1) {
        break label3941;
      }
      paramawcg.a(new NoColumnError("friendType", Integer.TYPE));
      label2682:
      i = paramCursor.getColumnIndex("abilityBits");
      if (i != -1) {
        break label3956;
      }
      paramawcg.a(new NoColumnError("abilityBits", Long.TYPE));
      label2717:
      i = paramCursor.getColumnIndex("bigClubInfo");
      if (i != -1) {
        break label3971;
      }
      paramawcg.a(new NoColumnError("bigClubInfo", Integer.TYPE));
      label2752:
      i = paramCursor.getColumnIndex("superVipTemplateId");
      if (i != -1) {
        break label3986;
      }
      paramawcg.a(new NoColumnError("superVipTemplateId", Integer.TYPE));
      label2787:
      i = paramCursor.getColumnIndex("bigClubTemplateId");
      if (i != -1) {
        break label4001;
      }
      paramawcg.a(new NoColumnError("bigClubTemplateId", Integer.TYPE));
      label2822:
      i = paramCursor.getColumnIndex("nameplateVipType");
      if (i != -1) {
        break label4016;
      }
      paramawcg.a(new NoColumnError("nameplateVipType", Integer.TYPE));
      label2857:
      i = paramCursor.getColumnIndex("grayNameplateFlag");
      if (i != -1) {
        break label4031;
      }
      paramawcg.a(new NoColumnError("grayNameplateFlag", Integer.TYPE));
      label2892:
      i = paramCursor.getColumnIndex("cNewLoverDiamondFlag");
      if (i != -1) {
        break label4046;
      }
      paramawcg.a(new NoColumnError("cNewLoverDiamondFlag", Integer.TYPE));
      label2927:
      i = paramCursor.getColumnIndex("relationIconFlag");
      if (i != -1) {
        break label4061;
      }
      paramawcg.a(new NoColumnError("relationIconFlag", Integer.TYPE));
      label2962:
      i = paramCursor.getColumnIndex("uExtOnlineStatus");
      if (i != -1) {
        break label4076;
      }
      paramawcg.a(new NoColumnError("uExtOnlineStatus", Long.TYPE));
      label2999:
      i = paramCursor.getColumnIndex("iBatteryStatus");
      if (i != -1) {
        break label4091;
      }
      paramawcg.a(new NoColumnError("iBatteryStatus", Integer.TYPE));
      label3036:
      i = paramCursor.getColumnIndex("customModel");
      if (i != -1) {
        break label4106;
      }
      paramawcg.a(new NoColumnError("customModel", String.class));
      label3073:
      i = paramCursor.getColumnIndex("songId");
      if (i != -1) {
        break label4121;
      }
      paramawcg.a(new NoColumnError("songId", String.class));
      label3110:
      i = paramCursor.getColumnIndex("songName");
      if (i != -1) {
        break label4136;
      }
      paramawcg.a(new NoColumnError("songName", String.class));
      label3147:
      i = paramCursor.getColumnIndex("singerName");
      if (i != -1) {
        break label4151;
      }
      paramawcg.a(new NoColumnError("singerName", String.class));
      label3184:
      i = paramCursor.getColumnIndex("songEndTime");
      if (i != -1) {
        break label4166;
      }
      paramawcg.a(new NoColumnError("songEndTime", Long.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("songSourceType");
      if (i != -1) {
        break label4181;
      }
      paramawcg.a(new NoColumnError("songSourceType", Integer.TYPE));
      return paramawbv;
      paramawbv.uin = paramCursor.getString(i);
      break;
      label3275:
      paramawbv.remark = paramCursor.getString(i);
      break label1212;
      label3290:
      paramawbv.name = paramCursor.getString(i);
      break label1247;
      label3305:
      paramawbv.faceid = paramCursor.getShort(i);
      break label1282;
      label3320:
      paramawbv.status = ((byte)paramCursor.getShort(i));
      break label1317;
      label3336:
      paramawbv.sqqtype = ((byte)paramCursor.getShort(i));
      break label1352;
      label3352:
      paramawbv.cSpecialFlag = ((byte)paramCursor.getShort(i));
      break label1387;
      label3368:
      paramawbv.groupid = paramCursor.getInt(i);
      break label1422;
      label3383:
      paramawbv.memberLevel = ((byte)paramCursor.getShort(i));
      break label1457;
      label3399:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isMqqOnLine = paramBoolean;
        break;
      }
      label3426:
      paramawbv.sqqOnLineState = ((byte)paramCursor.getShort(i));
      break label1527;
      label3442:
      paramawbv.detalStatusFlag = ((byte)paramCursor.getShort(i));
      break label1562;
      label3458:
      paramawbv.datetime = paramCursor.getLong(i);
      break label1597;
      label3473:
      paramawbv.alias = paramCursor.getString(i);
      break label1632;
      label3488:
      paramawbv.gathtertype = ((byte)paramCursor.getShort(i));
      break label1667;
      label3504:
      paramawbv.smartRemark = paramCursor.getString(i);
      break label1702;
      label3519:
      paramawbv.age = paramCursor.getInt(i);
      break label1737;
      label3534:
      paramawbv.gender = ((byte)paramCursor.getShort(i));
      break label1772;
      label3550:
      paramawbv.recommReason = paramCursor.getString(i);
      break label1807;
      label3565:
      paramawbv.signature = paramCursor.getString(i);
      break label1842;
      label3580:
      paramawbv.isIphoneOnline = ((byte)paramCursor.getShort(i));
      break label1877;
      label3596:
      paramawbv.isRemark = ((byte)paramCursor.getShort(i));
      break label1912;
      label3612:
      paramawbv.iTermType = paramCursor.getInt(i);
      break label1947;
      label3627:
      paramawbv.qqVipInfo = paramCursor.getInt(i);
      break label1982;
      label3642:
      paramawbv.superQqInfo = paramCursor.getInt(i);
      break label2017;
      label3657:
      paramawbv.superVipInfo = paramCursor.getInt(i);
      break label2052;
      label3672:
      paramawbv.hollywoodVipInfo = paramCursor.getInt(i);
      break label2087;
      label3687:
      paramawbv.lastLoginType = paramCursor.getLong(i);
      break label2122;
      label3702:
      paramawbv.showLoginClient = paramCursor.getLong(i);
      break label2157;
      label3717:
      paramawbv.medalsInfo = paramCursor.getString(i);
      break label2192;
      label3732:
      paramawbv.nameplateCfgInfo = paramCursor.getString(i);
      break label2227;
      label3747:
      paramawbv.richTime = paramCursor.getLong(i);
      break label2262;
      label3762:
      paramawbv.richBuffer = paramCursor.getBlob(i);
      break label2297;
      label3777:
      paramawbv.mComparePartInt = paramCursor.getInt(i);
      break label2332;
      label3792:
      paramawbv.mCompareSpell = paramCursor.getString(i);
      break label2367;
      label3807:
      paramawbv.cNetwork = ((byte)paramCursor.getShort(i));
      break label2402;
      label3823:
      paramawbv.eNetwork = paramCursor.getInt(i);
      break label2437;
      label3838:
      paramawbv.namePlateOfKingGameId = paramCursor.getLong(i);
      break label2472;
      label3853:
      paramawbv.namePlateOfKingLoginTime = paramCursor.getLong(i);
      break label2507;
      label3868:
      paramawbv.namePlateOfKingDan = paramCursor.getInt(i);
      break label2542;
      label3883:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramawbv.namePlateOfKingDanDisplatSwitch = paramBoolean;
        break;
      }
      label3911:
      paramawbv.strMasterUin = paramCursor.getString(i);
      break label2612;
      label3926:
      paramawbv.multiFlags = paramCursor.getInt(i);
      break label2647;
      label3941:
      paramawbv.friendType = paramCursor.getInt(i);
      break label2682;
      label3956:
      paramawbv.abilityBits = paramCursor.getLong(i);
      break label2717;
      label3971:
      paramawbv.bigClubInfo = paramCursor.getInt(i);
      break label2752;
      label3986:
      paramawbv.superVipTemplateId = paramCursor.getInt(i);
      break label2787;
      label4001:
      paramawbv.bigClubTemplateId = paramCursor.getInt(i);
      break label2822;
      label4016:
      paramawbv.nameplateVipType = paramCursor.getInt(i);
      break label2857;
      label4031:
      paramawbv.grayNameplateFlag = paramCursor.getInt(i);
      break label2892;
      label4046:
      paramawbv.cNewLoverDiamondFlag = paramCursor.getInt(i);
      break label2927;
      label4061:
      paramawbv.relationIconFlag = paramCursor.getInt(i);
      break label2962;
      label4076:
      paramawbv.uExtOnlineStatus = paramCursor.getLong(i);
      break label2999;
      label4091:
      paramawbv.iBatteryStatus = paramCursor.getInt(i);
      break label3036;
      label4106:
      paramawbv.customModel = paramCursor.getString(i);
      break label3073;
      label4121:
      paramawbv.songId = paramCursor.getString(i);
      break label3110;
      label4136:
      paramawbv.songName = paramCursor.getString(i);
      break label3147;
      label4151:
      paramawbv.singerName = paramCursor.getString(i);
      break label3184;
      label4166:
      paramawbv.songEndTime = paramCursor.getLong(i);
    }
    label4181:
    paramawbv.songSourceType = paramCursor.getInt(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,remark TEXT ,name TEXT ,faceid INTEGER ,status INTEGER ,sqqtype INTEGER ,cSpecialFlag INTEGER ,groupid INTEGER ,memberLevel INTEGER ,isMqqOnLine INTEGER ,sqqOnLineState INTEGER ,detalStatusFlag INTEGER ,datetime INTEGER ,alias TEXT ,gathtertype INTEGER ,smartRemark TEXT ,age INTEGER ,gender INTEGER ,recommReason TEXT ,signature TEXT ,isIphoneOnline INTEGER ,isRemark INTEGER ,iTermType INTEGER ,qqVipInfo INTEGER ,superQqInfo INTEGER ,superVipInfo INTEGER ,hollywoodVipInfo INTEGER ,lastLoginType INTEGER ,showLoginClient INTEGER ,medalsInfo TEXT ,nameplateCfgInfo TEXT ,richTime INTEGER ,richBuffer BLOB ,mComparePartInt INTEGER ,mCompareSpell TEXT ,cNetwork INTEGER ,eNetwork INTEGER ,namePlateOfKingGameId INTEGER ,namePlateOfKingLoginTime INTEGER ,namePlateOfKingDan INTEGER ,namePlateOfKingDanDisplatSwitch INTEGER ,strMasterUin TEXT ,multiFlags INTEGER ,friendType INTEGER ,abilityBits INTEGER ,bigClubInfo INTEGER ,superVipTemplateId INTEGER ,bigClubTemplateId INTEGER ,nameplateVipType INTEGER ,grayNameplateFlag INTEGER ,cNewLoverDiamondFlag INTEGER ,relationIconFlag INTEGER ,uExtOnlineStatus INTEGER ,iBatteryStatus INTEGER ,customModel TEXT ,songId TEXT ,songName TEXT ,singerName TEXT ,songEndTime INTEGER ,songSourceType INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (Friends)paramawbv;
    paramContentValues.put("uin", paramawbv.uin);
    paramContentValues.put("remark", paramawbv.remark);
    paramContentValues.put("name", paramawbv.name);
    paramContentValues.put("faceid", Short.valueOf(paramawbv.faceid));
    paramContentValues.put("status", Byte.valueOf(paramawbv.status));
    paramContentValues.put("sqqtype", Byte.valueOf(paramawbv.sqqtype));
    paramContentValues.put("cSpecialFlag", Byte.valueOf(paramawbv.cSpecialFlag));
    paramContentValues.put("groupid", Integer.valueOf(paramawbv.groupid));
    paramContentValues.put("memberLevel", Byte.valueOf(paramawbv.memberLevel));
    paramContentValues.put("isMqqOnLine", Boolean.valueOf(paramawbv.isMqqOnLine));
    paramContentValues.put("sqqOnLineState", Byte.valueOf(paramawbv.sqqOnLineState));
    paramContentValues.put("detalStatusFlag", Byte.valueOf(paramawbv.detalStatusFlag));
    paramContentValues.put("datetime", Long.valueOf(paramawbv.datetime));
    paramContentValues.put("alias", paramawbv.alias);
    paramContentValues.put("gathtertype", Byte.valueOf(paramawbv.gathtertype));
    paramContentValues.put("smartRemark", paramawbv.smartRemark);
    paramContentValues.put("age", Integer.valueOf(paramawbv.age));
    paramContentValues.put("gender", Byte.valueOf(paramawbv.gender));
    paramContentValues.put("recommReason", paramawbv.recommReason);
    paramContentValues.put("signature", paramawbv.signature);
    paramContentValues.put("isIphoneOnline", Byte.valueOf(paramawbv.isIphoneOnline));
    paramContentValues.put("isRemark", Byte.valueOf(paramawbv.isRemark));
    paramContentValues.put("iTermType", Integer.valueOf(paramawbv.iTermType));
    paramContentValues.put("qqVipInfo", Integer.valueOf(paramawbv.qqVipInfo));
    paramContentValues.put("superQqInfo", Integer.valueOf(paramawbv.superQqInfo));
    paramContentValues.put("superVipInfo", Integer.valueOf(paramawbv.superVipInfo));
    paramContentValues.put("hollywoodVipInfo", Integer.valueOf(paramawbv.hollywoodVipInfo));
    paramContentValues.put("lastLoginType", Long.valueOf(paramawbv.lastLoginType));
    paramContentValues.put("showLoginClient", Long.valueOf(paramawbv.showLoginClient));
    paramContentValues.put("medalsInfo", paramawbv.medalsInfo);
    paramContentValues.put("nameplateCfgInfo", paramawbv.nameplateCfgInfo);
    paramContentValues.put("richTime", Long.valueOf(paramawbv.richTime));
    paramContentValues.put("richBuffer", paramawbv.richBuffer);
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramawbv.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramawbv.mCompareSpell);
    paramContentValues.put("cNetwork", Byte.valueOf(paramawbv.cNetwork));
    paramContentValues.put("eNetwork", Integer.valueOf(paramawbv.eNetwork));
    paramContentValues.put("namePlateOfKingGameId", Long.valueOf(paramawbv.namePlateOfKingGameId));
    paramContentValues.put("namePlateOfKingLoginTime", Long.valueOf(paramawbv.namePlateOfKingLoginTime));
    paramContentValues.put("namePlateOfKingDan", Integer.valueOf(paramawbv.namePlateOfKingDan));
    paramContentValues.put("namePlateOfKingDanDisplatSwitch", Boolean.valueOf(paramawbv.namePlateOfKingDanDisplatSwitch));
    paramContentValues.put("strMasterUin", paramawbv.strMasterUin);
    paramContentValues.put("multiFlags", Integer.valueOf(paramawbv.multiFlags));
    paramContentValues.put("friendType", Integer.valueOf(paramawbv.friendType));
    paramContentValues.put("abilityBits", Long.valueOf(paramawbv.abilityBits));
    paramContentValues.put("bigClubInfo", Integer.valueOf(paramawbv.bigClubInfo));
    paramContentValues.put("superVipTemplateId", Integer.valueOf(paramawbv.superVipTemplateId));
    paramContentValues.put("bigClubTemplateId", Integer.valueOf(paramawbv.bigClubTemplateId));
    paramContentValues.put("nameplateVipType", Integer.valueOf(paramawbv.nameplateVipType));
    paramContentValues.put("grayNameplateFlag", Integer.valueOf(paramawbv.grayNameplateFlag));
    paramContentValues.put("cNewLoverDiamondFlag", Integer.valueOf(paramawbv.cNewLoverDiamondFlag));
    paramContentValues.put("relationIconFlag", Integer.valueOf(paramawbv.relationIconFlag));
    paramContentValues.put("uExtOnlineStatus", Long.valueOf(paramawbv.uExtOnlineStatus));
    paramContentValues.put("iBatteryStatus", Integer.valueOf(paramawbv.iBatteryStatus));
    paramContentValues.put("customModel", paramawbv.customModel);
    paramContentValues.put("songId", paramawbv.songId);
    paramContentValues.put("songName", paramawbv.songName);
    paramContentValues.put("singerName", paramawbv.singerName);
    paramContentValues.put("songEndTime", Long.valueOf(paramawbv.songEndTime));
    paramContentValues.put("songSourceType", Integer.valueOf(paramawbv.songSourceType));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awcb
 * JD-Core Version:    0.7.0.1
 */