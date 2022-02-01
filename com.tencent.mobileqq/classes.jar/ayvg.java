import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class ayvg
  extends OGAbstractDao
{
  public ayvg()
  {
    this.columnLen = 82;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (Friends)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramEntity.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramEntity.faceid = paramCursor.getShort(paramCursor.getColumnIndex("faceid"));
      paramEntity.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("status")));
      paramEntity.sqqtype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sqqtype")));
      paramEntity.cSpecialFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSpecialFlag")));
      paramEntity.groupid = paramCursor.getInt(paramCursor.getColumnIndex("groupid"));
      paramEntity.memberLevel = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("memberLevel")));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isMqqOnLine")))
      {
        paramBoolean = true;
        paramEntity.isMqqOnLine = paramBoolean;
        paramEntity.sqqOnLineState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sqqOnLineState")));
        paramEntity.detalStatusFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("detalStatusFlag")));
        paramEntity.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
        paramEntity.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
        paramEntity.gathtertype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gathtertype")));
        paramEntity.smartRemark = paramCursor.getString(paramCursor.getColumnIndex("smartRemark"));
        paramEntity.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
        paramEntity.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
        paramEntity.recommReason = paramCursor.getString(paramCursor.getColumnIndex("recommReason"));
        paramEntity.signature = paramCursor.getString(paramCursor.getColumnIndex("signature"));
        paramEntity.isIphoneOnline = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isIphoneOnline")));
        paramEntity.isRemark = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isRemark")));
        paramEntity.iTermType = paramCursor.getInt(paramCursor.getColumnIndex("iTermType"));
        paramEntity.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
        paramEntity.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
        paramEntity.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
        paramEntity.hollywoodVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("hollywoodVipInfo"));
        paramEntity.lastLoginType = paramCursor.getLong(paramCursor.getColumnIndex("lastLoginType"));
        paramEntity.showLoginClient = paramCursor.getLong(paramCursor.getColumnIndex("showLoginClient"));
        paramEntity.medalsInfo = paramCursor.getString(paramCursor.getColumnIndex("medalsInfo"));
        paramEntity.nameplateCfgInfo = paramCursor.getString(paramCursor.getColumnIndex("nameplateCfgInfo"));
        paramEntity.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
        paramEntity.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
        paramEntity.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramEntity.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramEntity.cNetwork = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cNetwork")));
        paramEntity.eNetwork = paramCursor.getInt(paramCursor.getColumnIndex("eNetwork"));
        paramEntity.namePlateOfKingGameId = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingGameId"));
        paramEntity.namePlateOfKingLoginTime = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingLoginTime"));
        paramEntity.namePlateOfKingDan = paramCursor.getInt(paramCursor.getColumnIndex("namePlateOfKingDan"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch"))) {
          break label1555;
        }
      }
      label1555:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.namePlateOfKingDanDisplatSwitch = paramBoolean;
        paramEntity.strMasterUin = paramCursor.getString(paramCursor.getColumnIndex("strMasterUin"));
        paramEntity.multiFlags = paramCursor.getInt(paramCursor.getColumnIndex("multiFlags"));
        paramEntity.friendType = paramCursor.getInt(paramCursor.getColumnIndex("friendType"));
        paramEntity.abilityBits = paramCursor.getLong(paramCursor.getColumnIndex("abilityBits"));
        paramEntity.bigClubInfo = paramCursor.getInt(paramCursor.getColumnIndex("bigClubInfo"));
        paramEntity.superVipTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("superVipTemplateId"));
        paramEntity.bigClubTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("bigClubTemplateId"));
        paramEntity.bigClubExtTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("bigClubExtTemplateId"));
        paramEntity.nameplateVipType = paramCursor.getInt(paramCursor.getColumnIndex("nameplateVipType"));
        paramEntity.grayNameplateFlag = paramCursor.getInt(paramCursor.getColumnIndex("grayNameplateFlag"));
        paramEntity.cNewLoverDiamondFlag = paramCursor.getInt(paramCursor.getColumnIndex("cNewLoverDiamondFlag"));
        paramEntity.relationIconFlag = paramCursor.getInt(paramCursor.getColumnIndex("relationIconFlag"));
        paramEntity.uExtOnlineStatus = paramCursor.getLong(paramCursor.getColumnIndex("uExtOnlineStatus"));
        paramEntity.iBatteryStatus = paramCursor.getInt(paramCursor.getColumnIndex("iBatteryStatus"));
        paramEntity.customModel = paramCursor.getString(paramCursor.getColumnIndex("customModel"));
        paramEntity.songId = paramCursor.getString(paramCursor.getColumnIndex("songId"));
        paramEntity.songName = paramCursor.getString(paramCursor.getColumnIndex("songName"));
        paramEntity.singerName = paramCursor.getString(paramCursor.getColumnIndex("singerName"));
        paramEntity.songEndTime = paramCursor.getLong(paramCursor.getColumnIndex("songEndTime"));
        paramEntity.songSourceType = paramCursor.getInt(paramCursor.getColumnIndex("songSourceType"));
        paramEntity.poiName = paramCursor.getString(paramCursor.getColumnIndex("poiName"));
        paramEntity.poiUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("poiUpdateTime"));
        paramEntity.latitude = paramCursor.getDouble(paramCursor.getColumnIndex("latitude"));
        paramEntity.longitude = paramCursor.getDouble(paramCursor.getColumnIndex("longitude"));
        paramEntity.poiFlag = paramCursor.getInt(paramCursor.getColumnIndex("poiFlag"));
        paramEntity.temper = paramCursor.getString(paramCursor.getColumnIndex("temper"));
        paramEntity.weatherType = paramCursor.getString(paramCursor.getColumnIndex("weatherType"));
        paramEntity.weatherTypeId = paramCursor.getString(paramCursor.getColumnIndex("weatherTypeId"));
        paramEntity.weatherTip = paramCursor.getString(paramCursor.getColumnIndex("weatherTip"));
        paramEntity.adCode = paramCursor.getString(paramCursor.getColumnIndex("adCode"));
        paramEntity.weatherUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("weatherUpdateTime"));
        paramEntity.city = paramCursor.getString(paramCursor.getColumnIndex("city"));
        paramEntity.weatherFlag = paramCursor.getInt(paramCursor.getColumnIndex("weatherFlag"));
        paramEntity.area = paramCursor.getString(paramCursor.getColumnIndex("area"));
        paramEntity.constellationTodayTrend = paramCursor.getString(paramCursor.getColumnIndex("constellationTodayTrend"));
        paramEntity.constellationTomorrowTrend = paramCursor.getString(paramCursor.getColumnIndex("constellationTomorrowTrend"));
        paramEntity.constellationBgImageUrl = paramCursor.getString(paramCursor.getColumnIndex("constellationBgImageUrl"));
        paramEntity.constellationIconUrl = paramCursor.getString(paramCursor.getColumnIndex("constellationIconUrl"));
        paramEntity.constellationJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("constellationJumpUrl"));
        paramEntity.constellationDateStr = paramCursor.getString(paramCursor.getColumnIndex("constellationDateStr"));
        paramEntity.autoStatusUpdateSecond = paramCursor.getLong(paramCursor.getColumnIndex("autoStatusUpdateSecond"));
        return paramEntity;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label4507;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("remark", String.class));
      label1630:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label4522;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("name", String.class));
      label1665:
      i = paramCursor.getColumnIndex("faceid");
      if (i != -1) {
        break label4537;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceid", Short.TYPE));
      label1700:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label4552;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("status", Byte.TYPE));
      label1735:
      i = paramCursor.getColumnIndex("sqqtype");
      if (i != -1) {
        break label4568;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sqqtype", Byte.TYPE));
      label1770:
      i = paramCursor.getColumnIndex("cSpecialFlag");
      if (i != -1) {
        break label4584;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cSpecialFlag", Byte.TYPE));
      label1805:
      i = paramCursor.getColumnIndex("groupid");
      if (i != -1) {
        break label4600;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("groupid", Integer.TYPE));
      label1840:
      i = paramCursor.getColumnIndex("memberLevel");
      if (i != -1) {
        break label4615;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("memberLevel", Byte.TYPE));
      label1875:
      i = paramCursor.getColumnIndex("isMqqOnLine");
      if (i != -1) {
        break label4631;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isMqqOnLine", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sqqOnLineState");
      if (i != -1) {
        break label4658;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sqqOnLineState", Byte.TYPE));
      label1945:
      i = paramCursor.getColumnIndex("detalStatusFlag");
      if (i != -1) {
        break label4674;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("detalStatusFlag", Byte.TYPE));
      label1980:
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label4690;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("datetime", Long.TYPE));
      label2015:
      i = paramCursor.getColumnIndex("alias");
      if (i != -1) {
        break label4705;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("alias", String.class));
      label2050:
      i = paramCursor.getColumnIndex("gathtertype");
      if (i != -1) {
        break label4720;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("gathtertype", Byte.TYPE));
      label2085:
      i = paramCursor.getColumnIndex("smartRemark");
      if (i != -1) {
        break label4736;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("smartRemark", String.class));
      label2120:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label4751;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("age", Integer.TYPE));
      label2155:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label4766;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("gender", Byte.TYPE));
      label2190:
      i = paramCursor.getColumnIndex("recommReason");
      if (i != -1) {
        break label4782;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("recommReason", String.class));
      label2225:
      i = paramCursor.getColumnIndex("signature");
      if (i != -1) {
        break label4797;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("signature", String.class));
      label2260:
      i = paramCursor.getColumnIndex("isIphoneOnline");
      if (i != -1) {
        break label4812;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isIphoneOnline", Byte.TYPE));
      label2295:
      i = paramCursor.getColumnIndex("isRemark");
      if (i != -1) {
        break label4828;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isRemark", Byte.TYPE));
      label2330:
      i = paramCursor.getColumnIndex("iTermType");
      if (i != -1) {
        break label4844;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iTermType", Integer.TYPE));
      label2365:
      i = paramCursor.getColumnIndex("qqVipInfo");
      if (i != -1) {
        break label4859;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qqVipInfo", Integer.TYPE));
      label2400:
      i = paramCursor.getColumnIndex("superQqInfo");
      if (i != -1) {
        break label4874;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("superQqInfo", Integer.TYPE));
      label2435:
      i = paramCursor.getColumnIndex("superVipInfo");
      if (i != -1) {
        break label4889;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("superVipInfo", Integer.TYPE));
      label2470:
      i = paramCursor.getColumnIndex("hollywoodVipInfo");
      if (i != -1) {
        break label4904;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hollywoodVipInfo", Integer.TYPE));
      label2505:
      i = paramCursor.getColumnIndex("lastLoginType");
      if (i != -1) {
        break label4919;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastLoginType", Long.TYPE));
      label2540:
      i = paramCursor.getColumnIndex("showLoginClient");
      if (i != -1) {
        break label4934;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showLoginClient", Long.TYPE));
      label2575:
      i = paramCursor.getColumnIndex("medalsInfo");
      if (i != -1) {
        break label4949;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("medalsInfo", String.class));
      label2610:
      i = paramCursor.getColumnIndex("nameplateCfgInfo");
      if (i != -1) {
        break label4964;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nameplateCfgInfo", String.class));
      label2645:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label4979;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("richTime", Long.TYPE));
      label2680:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label4994;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("richBuffer", [B.class));
      label2715:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label5009;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mComparePartInt", Integer.TYPE));
      label2750:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label5024;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mCompareSpell", String.class));
      label2785:
      i = paramCursor.getColumnIndex("cNetwork");
      if (i != -1) {
        break label5039;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cNetwork", Byte.TYPE));
      label2820:
      i = paramCursor.getColumnIndex("eNetwork");
      if (i != -1) {
        break label5055;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("eNetwork", Integer.TYPE));
      label2855:
      i = paramCursor.getColumnIndex("namePlateOfKingGameId");
      if (i != -1) {
        break label5070;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingGameId", Long.TYPE));
      label2890:
      i = paramCursor.getColumnIndex("namePlateOfKingLoginTime");
      if (i != -1) {
        break label5085;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingLoginTime", Long.TYPE));
      label2925:
      i = paramCursor.getColumnIndex("namePlateOfKingDan");
      if (i != -1) {
        break label5100;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingDan", Integer.TYPE));
      label2960:
      i = paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch");
      if (i != -1) {
        break label5115;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("namePlateOfKingDanDisplatSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("strMasterUin");
      if (i != -1) {
        break label5143;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strMasterUin", String.class));
      label3030:
      i = paramCursor.getColumnIndex("multiFlags");
      if (i != -1) {
        break label5158;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("multiFlags", Integer.TYPE));
      label3065:
      i = paramCursor.getColumnIndex("friendType");
      if (i != -1) {
        break label5173;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("friendType", Integer.TYPE));
      label3100:
      i = paramCursor.getColumnIndex("abilityBits");
      if (i != -1) {
        break label5188;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("abilityBits", Long.TYPE));
      label3135:
      i = paramCursor.getColumnIndex("bigClubInfo");
      if (i != -1) {
        break label5203;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bigClubInfo", Integer.TYPE));
      label3170:
      i = paramCursor.getColumnIndex("superVipTemplateId");
      if (i != -1) {
        break label5218;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("superVipTemplateId", Integer.TYPE));
      label3205:
      i = paramCursor.getColumnIndex("bigClubTemplateId");
      if (i != -1) {
        break label5233;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bigClubTemplateId", Integer.TYPE));
      label3240:
      i = paramCursor.getColumnIndex("bigClubExtTemplateId");
      if (i != -1) {
        break label5248;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bigClubExtTemplateId", Integer.TYPE));
      label3275:
      i = paramCursor.getColumnIndex("nameplateVipType");
      if (i != -1) {
        break label5263;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nameplateVipType", Integer.TYPE));
      label3310:
      i = paramCursor.getColumnIndex("grayNameplateFlag");
      if (i != -1) {
        break label5278;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("grayNameplateFlag", Integer.TYPE));
      label3345:
      i = paramCursor.getColumnIndex("cNewLoverDiamondFlag");
      if (i != -1) {
        break label5293;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cNewLoverDiamondFlag", Integer.TYPE));
      label3380:
      i = paramCursor.getColumnIndex("relationIconFlag");
      if (i != -1) {
        break label5308;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("relationIconFlag", Integer.TYPE));
      label3417:
      i = paramCursor.getColumnIndex("uExtOnlineStatus");
      if (i != -1) {
        break label5323;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uExtOnlineStatus", Long.TYPE));
      label3454:
      i = paramCursor.getColumnIndex("iBatteryStatus");
      if (i != -1) {
        break label5338;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iBatteryStatus", Integer.TYPE));
      label3491:
      i = paramCursor.getColumnIndex("customModel");
      if (i != -1) {
        break label5353;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("customModel", String.class));
      label3528:
      i = paramCursor.getColumnIndex("songId");
      if (i != -1) {
        break label5368;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("songId", String.class));
      label3565:
      i = paramCursor.getColumnIndex("songName");
      if (i != -1) {
        break label5383;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("songName", String.class));
      label3602:
      i = paramCursor.getColumnIndex("singerName");
      if (i != -1) {
        break label5398;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("singerName", String.class));
      label3639:
      i = paramCursor.getColumnIndex("songEndTime");
      if (i != -1) {
        break label5413;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("songEndTime", Long.TYPE));
      label3676:
      i = paramCursor.getColumnIndex("songSourceType");
      if (i != -1) {
        break label5428;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("songSourceType", Integer.TYPE));
      label3713:
      i = paramCursor.getColumnIndex("poiName");
      if (i != -1) {
        break label5443;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("poiName", String.class));
      label3750:
      i = paramCursor.getColumnIndex("poiUpdateTime");
      if (i != -1) {
        break label5458;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("poiUpdateTime", Long.TYPE));
      label3787:
      i = paramCursor.getColumnIndex("latitude");
      if (i != -1) {
        break label5473;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("latitude", Double.TYPE));
      label3824:
      i = paramCursor.getColumnIndex("longitude");
      if (i != -1) {
        break label5488;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("longitude", Double.TYPE));
      label3861:
      i = paramCursor.getColumnIndex("poiFlag");
      if (i != -1) {
        break label5503;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("poiFlag", Integer.TYPE));
      label3898:
      i = paramCursor.getColumnIndex("temper");
      if (i != -1) {
        break label5518;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("temper", String.class));
      label3935:
      i = paramCursor.getColumnIndex("weatherType");
      if (i != -1) {
        break label5533;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("weatherType", String.class));
      label3972:
      i = paramCursor.getColumnIndex("weatherTypeId");
      if (i != -1) {
        break label5548;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("weatherTypeId", String.class));
      label4009:
      i = paramCursor.getColumnIndex("weatherTip");
      if (i != -1) {
        break label5563;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("weatherTip", String.class));
      label4046:
      i = paramCursor.getColumnIndex("adCode");
      if (i != -1) {
        break label5578;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("adCode", String.class));
      label4083:
      i = paramCursor.getColumnIndex("weatherUpdateTime");
      if (i != -1) {
        break label5593;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("weatherUpdateTime", Long.TYPE));
      label4120:
      i = paramCursor.getColumnIndex("city");
      if (i != -1) {
        break label5608;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("city", String.class));
      label4157:
      i = paramCursor.getColumnIndex("weatherFlag");
      if (i != -1) {
        break label5623;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("weatherFlag", Integer.TYPE));
      label4194:
      i = paramCursor.getColumnIndex("area");
      if (i != -1) {
        break label5638;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("area", String.class));
      label4231:
      i = paramCursor.getColumnIndex("constellationTodayTrend");
      if (i != -1) {
        break label5653;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("constellationTodayTrend", String.class));
      label4268:
      i = paramCursor.getColumnIndex("constellationTomorrowTrend");
      if (i != -1) {
        break label5668;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("constellationTomorrowTrend", String.class));
      label4305:
      i = paramCursor.getColumnIndex("constellationBgImageUrl");
      if (i != -1) {
        break label5683;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("constellationBgImageUrl", String.class));
      label4342:
      i = paramCursor.getColumnIndex("constellationIconUrl");
      if (i != -1) {
        break label5698;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("constellationIconUrl", String.class));
      label4379:
      i = paramCursor.getColumnIndex("constellationJumpUrl");
      if (i != -1) {
        break label5713;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("constellationJumpUrl", String.class));
      label4416:
      i = paramCursor.getColumnIndex("constellationDateStr");
      if (i != -1) {
        break label5728;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("constellationDateStr", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("autoStatusUpdateSecond");
      if (i != -1) {
        break label5743;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("autoStatusUpdateSecond", Long.TYPE));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label4507:
      paramEntity.remark = paramCursor.getString(i);
      break label1630;
      label4522:
      paramEntity.name = paramCursor.getString(i);
      break label1665;
      label4537:
      paramEntity.faceid = paramCursor.getShort(i);
      break label1700;
      label4552:
      paramEntity.status = ((byte)paramCursor.getShort(i));
      break label1735;
      label4568:
      paramEntity.sqqtype = ((byte)paramCursor.getShort(i));
      break label1770;
      label4584:
      paramEntity.cSpecialFlag = ((byte)paramCursor.getShort(i));
      break label1805;
      label4600:
      paramEntity.groupid = paramCursor.getInt(i);
      break label1840;
      label4615:
      paramEntity.memberLevel = ((byte)paramCursor.getShort(i));
      break label1875;
      label4631:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isMqqOnLine = paramBoolean;
        break;
      }
      label4658:
      paramEntity.sqqOnLineState = ((byte)paramCursor.getShort(i));
      break label1945;
      label4674:
      paramEntity.detalStatusFlag = ((byte)paramCursor.getShort(i));
      break label1980;
      label4690:
      paramEntity.datetime = paramCursor.getLong(i);
      break label2015;
      label4705:
      paramEntity.alias = paramCursor.getString(i);
      break label2050;
      label4720:
      paramEntity.gathtertype = ((byte)paramCursor.getShort(i));
      break label2085;
      label4736:
      paramEntity.smartRemark = paramCursor.getString(i);
      break label2120;
      label4751:
      paramEntity.age = paramCursor.getInt(i);
      break label2155;
      label4766:
      paramEntity.gender = ((byte)paramCursor.getShort(i));
      break label2190;
      label4782:
      paramEntity.recommReason = paramCursor.getString(i);
      break label2225;
      label4797:
      paramEntity.signature = paramCursor.getString(i);
      break label2260;
      label4812:
      paramEntity.isIphoneOnline = ((byte)paramCursor.getShort(i));
      break label2295;
      label4828:
      paramEntity.isRemark = ((byte)paramCursor.getShort(i));
      break label2330;
      label4844:
      paramEntity.iTermType = paramCursor.getInt(i);
      break label2365;
      label4859:
      paramEntity.qqVipInfo = paramCursor.getInt(i);
      break label2400;
      label4874:
      paramEntity.superQqInfo = paramCursor.getInt(i);
      break label2435;
      label4889:
      paramEntity.superVipInfo = paramCursor.getInt(i);
      break label2470;
      label4904:
      paramEntity.hollywoodVipInfo = paramCursor.getInt(i);
      break label2505;
      label4919:
      paramEntity.lastLoginType = paramCursor.getLong(i);
      break label2540;
      label4934:
      paramEntity.showLoginClient = paramCursor.getLong(i);
      break label2575;
      label4949:
      paramEntity.medalsInfo = paramCursor.getString(i);
      break label2610;
      label4964:
      paramEntity.nameplateCfgInfo = paramCursor.getString(i);
      break label2645;
      label4979:
      paramEntity.richTime = paramCursor.getLong(i);
      break label2680;
      label4994:
      paramEntity.richBuffer = paramCursor.getBlob(i);
      break label2715;
      label5009:
      paramEntity.mComparePartInt = paramCursor.getInt(i);
      break label2750;
      label5024:
      paramEntity.mCompareSpell = paramCursor.getString(i);
      break label2785;
      label5039:
      paramEntity.cNetwork = ((byte)paramCursor.getShort(i));
      break label2820;
      label5055:
      paramEntity.eNetwork = paramCursor.getInt(i);
      break label2855;
      label5070:
      paramEntity.namePlateOfKingGameId = paramCursor.getLong(i);
      break label2890;
      label5085:
      paramEntity.namePlateOfKingLoginTime = paramCursor.getLong(i);
      break label2925;
      label5100:
      paramEntity.namePlateOfKingDan = paramCursor.getInt(i);
      break label2960;
      label5115:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.namePlateOfKingDanDisplatSwitch = paramBoolean;
        break;
      }
      label5143:
      paramEntity.strMasterUin = paramCursor.getString(i);
      break label3030;
      label5158:
      paramEntity.multiFlags = paramCursor.getInt(i);
      break label3065;
      label5173:
      paramEntity.friendType = paramCursor.getInt(i);
      break label3100;
      label5188:
      paramEntity.abilityBits = paramCursor.getLong(i);
      break label3135;
      label5203:
      paramEntity.bigClubInfo = paramCursor.getInt(i);
      break label3170;
      label5218:
      paramEntity.superVipTemplateId = paramCursor.getInt(i);
      break label3205;
      label5233:
      paramEntity.bigClubTemplateId = paramCursor.getInt(i);
      break label3240;
      label5248:
      paramEntity.bigClubExtTemplateId = paramCursor.getInt(i);
      break label3275;
      label5263:
      paramEntity.nameplateVipType = paramCursor.getInt(i);
      break label3310;
      label5278:
      paramEntity.grayNameplateFlag = paramCursor.getInt(i);
      break label3345;
      label5293:
      paramEntity.cNewLoverDiamondFlag = paramCursor.getInt(i);
      break label3380;
      label5308:
      paramEntity.relationIconFlag = paramCursor.getInt(i);
      break label3417;
      label5323:
      paramEntity.uExtOnlineStatus = paramCursor.getLong(i);
      break label3454;
      label5338:
      paramEntity.iBatteryStatus = paramCursor.getInt(i);
      break label3491;
      label5353:
      paramEntity.customModel = paramCursor.getString(i);
      break label3528;
      label5368:
      paramEntity.songId = paramCursor.getString(i);
      break label3565;
      label5383:
      paramEntity.songName = paramCursor.getString(i);
      break label3602;
      label5398:
      paramEntity.singerName = paramCursor.getString(i);
      break label3639;
      label5413:
      paramEntity.songEndTime = paramCursor.getLong(i);
      break label3676;
      label5428:
      paramEntity.songSourceType = paramCursor.getInt(i);
      break label3713;
      label5443:
      paramEntity.poiName = paramCursor.getString(i);
      break label3750;
      label5458:
      paramEntity.poiUpdateTime = paramCursor.getLong(i);
      break label3787;
      label5473:
      paramEntity.latitude = paramCursor.getDouble(i);
      break label3824;
      label5488:
      paramEntity.longitude = paramCursor.getDouble(i);
      break label3861;
      label5503:
      paramEntity.poiFlag = paramCursor.getInt(i);
      break label3898;
      label5518:
      paramEntity.temper = paramCursor.getString(i);
      break label3935;
      label5533:
      paramEntity.weatherType = paramCursor.getString(i);
      break label3972;
      label5548:
      paramEntity.weatherTypeId = paramCursor.getString(i);
      break label4009;
      label5563:
      paramEntity.weatherTip = paramCursor.getString(i);
      break label4046;
      label5578:
      paramEntity.adCode = paramCursor.getString(i);
      break label4083;
      label5593:
      paramEntity.weatherUpdateTime = paramCursor.getLong(i);
      break label4120;
      label5608:
      paramEntity.city = paramCursor.getString(i);
      break label4157;
      label5623:
      paramEntity.weatherFlag = paramCursor.getInt(i);
      break label4194;
      label5638:
      paramEntity.area = paramCursor.getString(i);
      break label4231;
      label5653:
      paramEntity.constellationTodayTrend = paramCursor.getString(i);
      break label4268;
      label5668:
      paramEntity.constellationTomorrowTrend = paramCursor.getString(i);
      break label4305;
      label5683:
      paramEntity.constellationBgImageUrl = paramCursor.getString(i);
      break label4342;
      label5698:
      paramEntity.constellationIconUrl = paramCursor.getString(i);
      break label4379;
      label5713:
      paramEntity.constellationJumpUrl = paramCursor.getString(i);
      break label4416;
      label5728:
      paramEntity.constellationDateStr = paramCursor.getString(i);
    }
    label5743:
    paramEntity.autoStatusUpdateSecond = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (Friends)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("remark", paramEntity.remark);
    paramContentValues.put("name", paramEntity.name);
    paramContentValues.put("faceid", Short.valueOf(paramEntity.faceid));
    paramContentValues.put("status", Byte.valueOf(paramEntity.status));
    paramContentValues.put("sqqtype", Byte.valueOf(paramEntity.sqqtype));
    paramContentValues.put("cSpecialFlag", Byte.valueOf(paramEntity.cSpecialFlag));
    paramContentValues.put("groupid", Integer.valueOf(paramEntity.groupid));
    paramContentValues.put("memberLevel", Byte.valueOf(paramEntity.memberLevel));
    paramContentValues.put("isMqqOnLine", Boolean.valueOf(paramEntity.isMqqOnLine));
    paramContentValues.put("sqqOnLineState", Byte.valueOf(paramEntity.sqqOnLineState));
    paramContentValues.put("detalStatusFlag", Byte.valueOf(paramEntity.detalStatusFlag));
    paramContentValues.put("datetime", Long.valueOf(paramEntity.datetime));
    paramContentValues.put("alias", paramEntity.alias);
    paramContentValues.put("gathtertype", Byte.valueOf(paramEntity.gathtertype));
    paramContentValues.put("smartRemark", paramEntity.smartRemark);
    paramContentValues.put("age", Integer.valueOf(paramEntity.age));
    paramContentValues.put("gender", Byte.valueOf(paramEntity.gender));
    paramContentValues.put("recommReason", paramEntity.recommReason);
    paramContentValues.put("signature", paramEntity.signature);
    paramContentValues.put("isIphoneOnline", Byte.valueOf(paramEntity.isIphoneOnline));
    paramContentValues.put("isRemark", Byte.valueOf(paramEntity.isRemark));
    paramContentValues.put("iTermType", Integer.valueOf(paramEntity.iTermType));
    paramContentValues.put("qqVipInfo", Integer.valueOf(paramEntity.qqVipInfo));
    paramContentValues.put("superQqInfo", Integer.valueOf(paramEntity.superQqInfo));
    paramContentValues.put("superVipInfo", Integer.valueOf(paramEntity.superVipInfo));
    paramContentValues.put("hollywoodVipInfo", Integer.valueOf(paramEntity.hollywoodVipInfo));
    paramContentValues.put("lastLoginType", Long.valueOf(paramEntity.lastLoginType));
    paramContentValues.put("showLoginClient", Long.valueOf(paramEntity.showLoginClient));
    paramContentValues.put("medalsInfo", paramEntity.medalsInfo);
    paramContentValues.put("nameplateCfgInfo", paramEntity.nameplateCfgInfo);
    paramContentValues.put("richTime", Long.valueOf(paramEntity.richTime));
    paramContentValues.put("richBuffer", paramEntity.richBuffer);
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramEntity.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramEntity.mCompareSpell);
    paramContentValues.put("cNetwork", Byte.valueOf(paramEntity.cNetwork));
    paramContentValues.put("eNetwork", Integer.valueOf(paramEntity.eNetwork));
    paramContentValues.put("namePlateOfKingGameId", Long.valueOf(paramEntity.namePlateOfKingGameId));
    paramContentValues.put("namePlateOfKingLoginTime", Long.valueOf(paramEntity.namePlateOfKingLoginTime));
    paramContentValues.put("namePlateOfKingDan", Integer.valueOf(paramEntity.namePlateOfKingDan));
    paramContentValues.put("namePlateOfKingDanDisplatSwitch", Boolean.valueOf(paramEntity.namePlateOfKingDanDisplatSwitch));
    paramContentValues.put("strMasterUin", paramEntity.strMasterUin);
    paramContentValues.put("multiFlags", Integer.valueOf(paramEntity.multiFlags));
    paramContentValues.put("friendType", Integer.valueOf(paramEntity.friendType));
    paramContentValues.put("abilityBits", Long.valueOf(paramEntity.abilityBits));
    paramContentValues.put("bigClubInfo", Integer.valueOf(paramEntity.bigClubInfo));
    paramContentValues.put("superVipTemplateId", Integer.valueOf(paramEntity.superVipTemplateId));
    paramContentValues.put("bigClubTemplateId", Integer.valueOf(paramEntity.bigClubTemplateId));
    paramContentValues.put("bigClubExtTemplateId", Integer.valueOf(paramEntity.bigClubExtTemplateId));
    paramContentValues.put("nameplateVipType", Integer.valueOf(paramEntity.nameplateVipType));
    paramContentValues.put("grayNameplateFlag", Integer.valueOf(paramEntity.grayNameplateFlag));
    paramContentValues.put("cNewLoverDiamondFlag", Integer.valueOf(paramEntity.cNewLoverDiamondFlag));
    paramContentValues.put("relationIconFlag", Integer.valueOf(paramEntity.relationIconFlag));
    paramContentValues.put("uExtOnlineStatus", Long.valueOf(paramEntity.uExtOnlineStatus));
    paramContentValues.put("iBatteryStatus", Integer.valueOf(paramEntity.iBatteryStatus));
    paramContentValues.put("customModel", paramEntity.customModel);
    paramContentValues.put("songId", paramEntity.songId);
    paramContentValues.put("songName", paramEntity.songName);
    paramContentValues.put("singerName", paramEntity.singerName);
    paramContentValues.put("songEndTime", Long.valueOf(paramEntity.songEndTime));
    paramContentValues.put("songSourceType", Integer.valueOf(paramEntity.songSourceType));
    paramContentValues.put("poiName", paramEntity.poiName);
    paramContentValues.put("poiUpdateTime", Long.valueOf(paramEntity.poiUpdateTime));
    paramContentValues.put("latitude", Double.valueOf(paramEntity.latitude));
    paramContentValues.put("longitude", Double.valueOf(paramEntity.longitude));
    paramContentValues.put("poiFlag", Integer.valueOf(paramEntity.poiFlag));
    paramContentValues.put("temper", paramEntity.temper);
    paramContentValues.put("weatherType", paramEntity.weatherType);
    paramContentValues.put("weatherTypeId", paramEntity.weatherTypeId);
    paramContentValues.put("weatherTip", paramEntity.weatherTip);
    paramContentValues.put("adCode", paramEntity.adCode);
    paramContentValues.put("weatherUpdateTime", Long.valueOf(paramEntity.weatherUpdateTime));
    paramContentValues.put("city", paramEntity.city);
    paramContentValues.put("weatherFlag", Integer.valueOf(paramEntity.weatherFlag));
    paramContentValues.put("area", paramEntity.area);
    paramContentValues.put("constellationTodayTrend", paramEntity.constellationTodayTrend);
    paramContentValues.put("constellationTomorrowTrend", paramEntity.constellationTomorrowTrend);
    paramContentValues.put("constellationBgImageUrl", paramEntity.constellationBgImageUrl);
    paramContentValues.put("constellationIconUrl", paramEntity.constellationIconUrl);
    paramContentValues.put("constellationJumpUrl", paramEntity.constellationJumpUrl);
    paramContentValues.put("constellationDateStr", paramEntity.constellationDateStr);
    paramContentValues.put("autoStatusUpdateSecond", Long.valueOf(paramEntity.autoStatusUpdateSecond));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,remark TEXT ,name TEXT ,faceid INTEGER ,status INTEGER ,sqqtype INTEGER ,cSpecialFlag INTEGER ,groupid INTEGER ,memberLevel INTEGER ,isMqqOnLine INTEGER ,sqqOnLineState INTEGER ,detalStatusFlag INTEGER ,datetime INTEGER ,alias TEXT ,gathtertype INTEGER ,smartRemark TEXT ,age INTEGER ,gender INTEGER ,recommReason TEXT ,signature TEXT ,isIphoneOnline INTEGER ,isRemark INTEGER ,iTermType INTEGER ,qqVipInfo INTEGER ,superQqInfo INTEGER ,superVipInfo INTEGER ,hollywoodVipInfo INTEGER ,lastLoginType INTEGER ,showLoginClient INTEGER ,medalsInfo TEXT ,nameplateCfgInfo TEXT ,richTime INTEGER ,richBuffer BLOB ,mComparePartInt INTEGER ,mCompareSpell TEXT ,cNetwork INTEGER ,eNetwork INTEGER ,namePlateOfKingGameId INTEGER ,namePlateOfKingLoginTime INTEGER ,namePlateOfKingDan INTEGER ,namePlateOfKingDanDisplatSwitch INTEGER ,strMasterUin TEXT ,multiFlags INTEGER ,friendType INTEGER ,abilityBits INTEGER ,bigClubInfo INTEGER ,superVipTemplateId INTEGER ,bigClubTemplateId INTEGER ,bigClubExtTemplateId INTEGER ,nameplateVipType INTEGER ,grayNameplateFlag INTEGER ,cNewLoverDiamondFlag INTEGER ,relationIconFlag INTEGER ,uExtOnlineStatus INTEGER ,iBatteryStatus INTEGER ,customModel TEXT ,songId TEXT ,songName TEXT ,singerName TEXT ,songEndTime INTEGER ,songSourceType INTEGER ,poiName TEXT ,poiUpdateTime INTEGER ,latitude REAL ,longitude REAL ,poiFlag INTEGER ,temper TEXT ,weatherType TEXT ,weatherTypeId TEXT ,weatherTip TEXT ,adCode TEXT ,weatherUpdateTime INTEGER ,city TEXT ,weatherFlag INTEGER ,area TEXT ,constellationTodayTrend TEXT ,constellationTomorrowTrend TEXT ,constellationBgImageUrl TEXT ,constellationIconUrl TEXT ,constellationJumpUrl TEXT ,constellationDateStr TEXT ,autoStatusUpdateSecond INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayvg
 * JD-Core Version:    0.7.0.1
 */