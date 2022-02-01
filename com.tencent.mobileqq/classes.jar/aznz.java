import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class aznz
  extends OGAbstractDao
{
  public aznz()
  {
    this.columnLen = 38;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (PhoneContact)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.mobileNo = paramCursor.getString(paramCursor.getColumnIndex("mobileNo"));
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramEntity.bindingDate = paramCursor.getLong(paramCursor.getColumnIndex("bindingDate"));
      paramEntity.isRecommend = paramCursor.getInt(paramCursor.getColumnIndex("isRecommend"));
      paramEntity.nationCode = paramCursor.getString(paramCursor.getColumnIndex("nationCode"));
      paramEntity.mobileCode = paramCursor.getString(paramCursor.getColumnIndex("mobileCode"));
      paramEntity.unifiedCode = paramCursor.getString(paramCursor.getColumnIndex("unifiedCode"));
      paramEntity.nickName = paramCursor.getString(paramCursor.getColumnIndex("nickName"));
      paramEntity.originBinder = paramCursor.getLong(paramCursor.getColumnIndex("originBinder"));
      paramEntity.ability = paramCursor.getInt(paramCursor.getColumnIndex("ability"));
      paramEntity.contactID = paramCursor.getInt(paramCursor.getColumnIndex("contactID"));
      paramEntity.faceUrl = paramCursor.getString(paramCursor.getColumnIndex("faceUrl"));
      paramEntity.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramEntity.pinyinAll = paramCursor.getString(paramCursor.getColumnIndex("pinyinAll"));
      paramEntity.pinyinInitial = paramCursor.getString(paramCursor.getColumnIndex("pinyinInitial"));
      paramEntity.lastScanTime = paramCursor.getLong(paramCursor.getColumnIndex("lastScanTime"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isUploaded")))
      {
        paramBoolean = true;
        paramEntity.isUploaded = paramBoolean;
        paramEntity.sortWeight = paramCursor.getInt(paramCursor.getColumnIndex("sortWeight"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSendAddReq"))) {
          break label737;
        }
        paramBoolean = true;
        label385:
        paramEntity.hasSendAddReq = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isNewRecommend"))) {
          break label742;
        }
        paramBoolean = true;
        label410:
        paramEntity.isNewRecommend = paramBoolean;
        paramEntity.highLightTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("highLightTimeStamp"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isHiden"))) {
          break label747;
        }
      }
      label737:
      label742:
      label747:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.isHiden = paramBoolean;
        paramEntity.md5 = paramCursor.getString(paramCursor.getColumnIndex("md5"));
        paramEntity.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
        paramEntity.label = paramCursor.getString(paramCursor.getColumnIndex("label"));
        paramEntity.detalStatusFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("detalStatusFlag")));
        paramEntity.iTermType = paramCursor.getInt(paramCursor.getColumnIndex("iTermType"));
        paramEntity.eNetworkType = paramCursor.getInt(paramCursor.getColumnIndex("eNetworkType"));
        paramEntity.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
        paramEntity.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
        paramEntity.sex = paramCursor.getInt(paramCursor.getColumnIndex("sex"));
        paramEntity.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
        paramEntity.samFriend = paramCursor.getInt(paramCursor.getColumnIndex("samFriend"));
        paramEntity.abilityBits = paramCursor.getLong(paramCursor.getColumnIndex("abilityBits"));
        paramEntity.strTermDesc = paramCursor.getString(paramCursor.getColumnIndex("strTermDesc"));
        paramEntity.netTypeIconIdIphoneOrWphoneNoWifi = paramCursor.getInt(paramCursor.getColumnIndex("netTypeIconIdIphoneOrWphoneNoWifi"));
        paramEntity.netTypeIconId = paramCursor.getInt(paramCursor.getColumnIndex("netTypeIconId"));
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label385;
        paramBoolean = false;
        break label410;
      }
    }
    int i = paramCursor.getColumnIndex("mobileNo");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mobileNo", String.class));
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label2084;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
      label820:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label2099;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("name", String.class));
      label854:
      i = paramCursor.getColumnIndex("bindingDate");
      if (i != -1) {
        break label2114;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bindingDate", Long.TYPE));
      label889:
      i = paramCursor.getColumnIndex("isRecommend");
      if (i != -1) {
        break label2129;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isRecommend", Integer.TYPE));
      label924:
      i = paramCursor.getColumnIndex("nationCode");
      if (i != -1) {
        break label2144;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nationCode", String.class));
      label958:
      i = paramCursor.getColumnIndex("mobileCode");
      if (i != -1) {
        break label2159;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mobileCode", String.class));
      label992:
      i = paramCursor.getColumnIndex("unifiedCode");
      if (i != -1) {
        break label2174;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("unifiedCode", String.class));
      label1026:
      i = paramCursor.getColumnIndex("nickName");
      if (i != -1) {
        break label2189;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nickName", String.class));
      label1060:
      i = paramCursor.getColumnIndex("originBinder");
      if (i != -1) {
        break label2204;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("originBinder", Long.TYPE));
      label1095:
      i = paramCursor.getColumnIndex("ability");
      if (i != -1) {
        break label2219;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ability", Integer.TYPE));
      label1130:
      i = paramCursor.getColumnIndex("contactID");
      if (i != -1) {
        break label2234;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("contactID", Integer.TYPE));
      label1165:
      i = paramCursor.getColumnIndex("faceUrl");
      if (i != -1) {
        break label2249;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceUrl", String.class));
      label1199:
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label2264;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("remark", String.class));
      label1233:
      i = paramCursor.getColumnIndex("pinyinAll");
      if (i != -1) {
        break label2279;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pinyinAll", String.class));
      label1267:
      i = paramCursor.getColumnIndex("pinyinInitial");
      if (i != -1) {
        break label2294;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pinyinInitial", String.class));
      label1301:
      i = paramCursor.getColumnIndex("lastScanTime");
      if (i != -1) {
        break label2309;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastScanTime", Long.TYPE));
      label1336:
      i = paramCursor.getColumnIndex("isUploaded");
      if (i != -1) {
        break label2324;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isUploaded", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sortWeight");
      if (i != -1) {
        break label2351;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sortWeight", Integer.TYPE));
      label1406:
      i = paramCursor.getColumnIndex("hasSendAddReq");
      if (i != -1) {
        break label2366;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasSendAddReq", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isNewRecommend");
      if (i != -1) {
        break label2393;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isNewRecommend", Boolean.TYPE));
      i = paramCursor.getColumnIndex("highLightTimeStamp");
      if (i != -1) {
        break label2420;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("highLightTimeStamp", Long.TYPE));
      label1511:
      i = paramCursor.getColumnIndex("isHiden");
      if (i != -1) {
        break label2435;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isHiden", Boolean.TYPE));
      i = paramCursor.getColumnIndex("md5");
      if (i != -1) {
        break label2463;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("md5", String.class));
      label1580:
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label2478;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("type", Integer.TYPE));
      label1615:
      i = paramCursor.getColumnIndex("label");
      if (i != -1) {
        break label2493;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("label", String.class));
      label1649:
      i = paramCursor.getColumnIndex("detalStatusFlag");
      if (i != -1) {
        break label2508;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("detalStatusFlag", Byte.TYPE));
      label1684:
      i = paramCursor.getColumnIndex("iTermType");
      if (i != -1) {
        break label2524;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iTermType", Integer.TYPE));
      label1719:
      i = paramCursor.getColumnIndex("eNetworkType");
      if (i != -1) {
        break label2539;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("eNetworkType", Integer.TYPE));
      label1754:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label2554;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("richTime", Long.TYPE));
      label1789:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label2569;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("richBuffer", [B.class));
      label1823:
      i = paramCursor.getColumnIndex("sex");
      if (i != -1) {
        break label2584;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sex", Integer.TYPE));
      label1858:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label2599;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("age", Integer.TYPE));
      label1893:
      i = paramCursor.getColumnIndex("samFriend");
      if (i != -1) {
        break label2614;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("samFriend", Integer.TYPE));
      label1928:
      i = paramCursor.getColumnIndex("abilityBits");
      if (i != -1) {
        break label2629;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("abilityBits", Long.TYPE));
      label1963:
      i = paramCursor.getColumnIndex("strTermDesc");
      if (i != -1) {
        break label2644;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strTermDesc", String.class));
      label1997:
      i = paramCursor.getColumnIndex("netTypeIconIdIphoneOrWphoneNoWifi");
      if (i != -1) {
        break label2659;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("netTypeIconIdIphoneOrWphoneNoWifi", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("netTypeIconId");
      if (i != -1) {
        break label2674;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("netTypeIconId", Integer.TYPE));
      return paramEntity;
      paramEntity.mobileNo = paramCursor.getString(i);
      break;
      label2084:
      paramEntity.uin = paramCursor.getString(i);
      break label820;
      label2099:
      paramEntity.name = paramCursor.getString(i);
      break label854;
      label2114:
      paramEntity.bindingDate = paramCursor.getLong(i);
      break label889;
      label2129:
      paramEntity.isRecommend = paramCursor.getInt(i);
      break label924;
      label2144:
      paramEntity.nationCode = paramCursor.getString(i);
      break label958;
      label2159:
      paramEntity.mobileCode = paramCursor.getString(i);
      break label992;
      label2174:
      paramEntity.unifiedCode = paramCursor.getString(i);
      break label1026;
      label2189:
      paramEntity.nickName = paramCursor.getString(i);
      break label1060;
      label2204:
      paramEntity.originBinder = paramCursor.getLong(i);
      break label1095;
      label2219:
      paramEntity.ability = paramCursor.getInt(i);
      break label1130;
      label2234:
      paramEntity.contactID = paramCursor.getInt(i);
      break label1165;
      label2249:
      paramEntity.faceUrl = paramCursor.getString(i);
      break label1199;
      label2264:
      paramEntity.remark = paramCursor.getString(i);
      break label1233;
      label2279:
      paramEntity.pinyinAll = paramCursor.getString(i);
      break label1267;
      label2294:
      paramEntity.pinyinInitial = paramCursor.getString(i);
      break label1301;
      label2309:
      paramEntity.lastScanTime = paramCursor.getLong(i);
      break label1336;
      label2324:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isUploaded = paramBoolean;
        break;
      }
      label2351:
      paramEntity.sortWeight = paramCursor.getInt(i);
      break label1406;
      label2366:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasSendAddReq = paramBoolean;
        break;
      }
      label2393:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isNewRecommend = paramBoolean;
        break;
      }
      label2420:
      paramEntity.highLightTimeStamp = paramCursor.getLong(i);
      break label1511;
      label2435:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.isHiden = paramBoolean;
        break;
      }
      label2463:
      paramEntity.md5 = paramCursor.getString(i);
      break label1580;
      label2478:
      paramEntity.type = paramCursor.getInt(i);
      break label1615;
      label2493:
      paramEntity.label = paramCursor.getString(i);
      break label1649;
      label2508:
      paramEntity.detalStatusFlag = ((byte)paramCursor.getShort(i));
      break label1684;
      label2524:
      paramEntity.iTermType = paramCursor.getInt(i);
      break label1719;
      label2539:
      paramEntity.eNetworkType = paramCursor.getInt(i);
      break label1754;
      label2554:
      paramEntity.richTime = paramCursor.getLong(i);
      break label1789;
      label2569:
      paramEntity.richBuffer = paramCursor.getBlob(i);
      break label1823;
      label2584:
      paramEntity.sex = paramCursor.getInt(i);
      break label1858;
      label2599:
      paramEntity.age = paramCursor.getInt(i);
      break label1893;
      label2614:
      paramEntity.samFriend = paramCursor.getInt(i);
      break label1928;
      label2629:
      paramEntity.abilityBits = paramCursor.getLong(i);
      break label1963;
      label2644:
      paramEntity.strTermDesc = paramCursor.getString(i);
      break label1997;
      label2659:
      paramEntity.netTypeIconIdIphoneOrWphoneNoWifi = paramCursor.getInt(i);
    }
    label2674:
    paramEntity.netTypeIconId = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (PhoneContact)paramEntity;
    paramContentValues.put("mobileNo", paramEntity.mobileNo);
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("name", paramEntity.name);
    paramContentValues.put("bindingDate", Long.valueOf(paramEntity.bindingDate));
    paramContentValues.put("isRecommend", Integer.valueOf(paramEntity.isRecommend));
    paramContentValues.put("nationCode", paramEntity.nationCode);
    paramContentValues.put("mobileCode", paramEntity.mobileCode);
    paramContentValues.put("unifiedCode", paramEntity.unifiedCode);
    paramContentValues.put("nickName", paramEntity.nickName);
    paramContentValues.put("originBinder", Long.valueOf(paramEntity.originBinder));
    paramContentValues.put("ability", Integer.valueOf(paramEntity.ability));
    paramContentValues.put("contactID", Integer.valueOf(paramEntity.contactID));
    paramContentValues.put("faceUrl", paramEntity.faceUrl);
    paramContentValues.put("remark", paramEntity.remark);
    paramContentValues.put("pinyinAll", paramEntity.pinyinAll);
    paramContentValues.put("pinyinInitial", paramEntity.pinyinInitial);
    paramContentValues.put("lastScanTime", Long.valueOf(paramEntity.lastScanTime));
    paramContentValues.put("isUploaded", Boolean.valueOf(paramEntity.isUploaded));
    paramContentValues.put("sortWeight", Integer.valueOf(paramEntity.sortWeight));
    paramContentValues.put("hasSendAddReq", Boolean.valueOf(paramEntity.hasSendAddReq));
    paramContentValues.put("isNewRecommend", Boolean.valueOf(paramEntity.isNewRecommend));
    paramContentValues.put("highLightTimeStamp", Long.valueOf(paramEntity.highLightTimeStamp));
    paramContentValues.put("isHiden", Boolean.valueOf(paramEntity.isHiden));
    paramContentValues.put("md5", paramEntity.md5);
    paramContentValues.put("type", Integer.valueOf(paramEntity.type));
    paramContentValues.put("label", paramEntity.label);
    paramContentValues.put("detalStatusFlag", Byte.valueOf(paramEntity.detalStatusFlag));
    paramContentValues.put("iTermType", Integer.valueOf(paramEntity.iTermType));
    paramContentValues.put("eNetworkType", Integer.valueOf(paramEntity.eNetworkType));
    paramContentValues.put("richTime", Long.valueOf(paramEntity.richTime));
    paramContentValues.put("richBuffer", paramEntity.richBuffer);
    paramContentValues.put("sex", Integer.valueOf(paramEntity.sex));
    paramContentValues.put("age", Integer.valueOf(paramEntity.age));
    paramContentValues.put("samFriend", Integer.valueOf(paramEntity.samFriend));
    paramContentValues.put("abilityBits", Long.valueOf(paramEntity.abilityBits));
    paramContentValues.put("strTermDesc", paramEntity.strTermDesc);
    paramContentValues.put("netTypeIconIdIphoneOrWphoneNoWifi", Integer.valueOf(paramEntity.netTypeIconIdIphoneOrWphoneNoWifi));
    paramContentValues.put("netTypeIconId", Integer.valueOf(paramEntity.netTypeIconId));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,mobileNo TEXT UNIQUE ,uin TEXT ,name TEXT ,bindingDate INTEGER ,isRecommend INTEGER ,nationCode TEXT ,mobileCode TEXT ,unifiedCode TEXT ,nickName TEXT ,originBinder INTEGER ,ability INTEGER ,contactID INTEGER ,faceUrl TEXT ,remark TEXT ,pinyinAll TEXT ,pinyinInitial TEXT ,lastScanTime INTEGER ,isUploaded INTEGER ,sortWeight INTEGER ,hasSendAddReq INTEGER ,isNewRecommend INTEGER ,highLightTimeStamp INTEGER ,isHiden INTEGER ,md5 TEXT ,type INTEGER ,label TEXT ,detalStatusFlag INTEGER ,iTermType INTEGER ,eNetworkType INTEGER ,richTime INTEGER ,richBuffer BLOB ,sex INTEGER ,age INTEGER ,samFriend INTEGER ,abilityBits INTEGER ,strTermDesc TEXT ,netTypeIconIdIphoneOrWphoneNoWifi INTEGER ,netTypeIconId INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aznz
 * JD-Core Version:    0.7.0.1
 */