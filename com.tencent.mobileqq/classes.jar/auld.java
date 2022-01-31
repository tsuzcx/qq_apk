import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.persistence.NoColumnError;

public class auld
  extends aula
{
  public auld()
  {
    this.a = 38;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramauko = (PhoneContact)paramauko;
    if (paramaukz == null)
    {
      paramauko.mobileNo = paramCursor.getString(paramCursor.getColumnIndex("mobileNo"));
      paramauko.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramauko.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramauko.bindingDate = paramCursor.getLong(paramCursor.getColumnIndex("bindingDate"));
      paramauko.isRecommend = paramCursor.getInt(paramCursor.getColumnIndex("isRecommend"));
      paramauko.nationCode = paramCursor.getString(paramCursor.getColumnIndex("nationCode"));
      paramauko.mobileCode = paramCursor.getString(paramCursor.getColumnIndex("mobileCode"));
      paramauko.unifiedCode = paramCursor.getString(paramCursor.getColumnIndex("unifiedCode"));
      paramauko.nickName = paramCursor.getString(paramCursor.getColumnIndex("nickName"));
      paramauko.originBinder = paramCursor.getLong(paramCursor.getColumnIndex("originBinder"));
      paramauko.ability = paramCursor.getInt(paramCursor.getColumnIndex("ability"));
      paramauko.contactID = paramCursor.getInt(paramCursor.getColumnIndex("contactID"));
      paramauko.faceUrl = paramCursor.getString(paramCursor.getColumnIndex("faceUrl"));
      paramauko.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramauko.pinyinAll = paramCursor.getString(paramCursor.getColumnIndex("pinyinAll"));
      paramauko.pinyinInitial = paramCursor.getString(paramCursor.getColumnIndex("pinyinInitial"));
      paramauko.lastScanTime = paramCursor.getLong(paramCursor.getColumnIndex("lastScanTime"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isUploaded")))
      {
        paramBoolean = true;
        paramauko.isUploaded = paramBoolean;
        paramauko.sortWeight = paramCursor.getInt(paramCursor.getColumnIndex("sortWeight"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSendAddReq"))) {
          break label737;
        }
        paramBoolean = true;
        label385:
        paramauko.hasSendAddReq = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isNewRecommend"))) {
          break label742;
        }
        paramBoolean = true;
        label410:
        paramauko.isNewRecommend = paramBoolean;
        paramauko.highLightTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("highLightTimeStamp"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isHiden"))) {
          break label747;
        }
      }
      label737:
      label742:
      label747:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramauko.isHiden = paramBoolean;
        paramauko.md5 = paramCursor.getString(paramCursor.getColumnIndex("md5"));
        paramauko.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
        paramauko.label = paramCursor.getString(paramCursor.getColumnIndex("label"));
        paramauko.detalStatusFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("detalStatusFlag")));
        paramauko.iTermType = paramCursor.getInt(paramCursor.getColumnIndex("iTermType"));
        paramauko.eNetworkType = paramCursor.getInt(paramCursor.getColumnIndex("eNetworkType"));
        paramauko.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
        paramauko.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
        paramauko.sex = paramCursor.getInt(paramCursor.getColumnIndex("sex"));
        paramauko.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
        paramauko.samFriend = paramCursor.getInt(paramCursor.getColumnIndex("samFriend"));
        paramauko.abilityBits = paramCursor.getLong(paramCursor.getColumnIndex("abilityBits"));
        paramauko.strTermDesc = paramCursor.getString(paramCursor.getColumnIndex("strTermDesc"));
        paramauko.netTypeIconIdIphoneOrWphoneNoWifi = paramCursor.getInt(paramCursor.getColumnIndex("netTypeIconIdIphoneOrWphoneNoWifi"));
        paramauko.netTypeIconId = paramCursor.getInt(paramCursor.getColumnIndex("netTypeIconId"));
        return paramauko;
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
      paramaukz.a(new NoColumnError("mobileNo", String.class));
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label2084;
      }
      paramaukz.a(new NoColumnError("uin", String.class));
      label820:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label2099;
      }
      paramaukz.a(new NoColumnError("name", String.class));
      label854:
      i = paramCursor.getColumnIndex("bindingDate");
      if (i != -1) {
        break label2114;
      }
      paramaukz.a(new NoColumnError("bindingDate", Long.TYPE));
      label889:
      i = paramCursor.getColumnIndex("isRecommend");
      if (i != -1) {
        break label2129;
      }
      paramaukz.a(new NoColumnError("isRecommend", Integer.TYPE));
      label924:
      i = paramCursor.getColumnIndex("nationCode");
      if (i != -1) {
        break label2144;
      }
      paramaukz.a(new NoColumnError("nationCode", String.class));
      label958:
      i = paramCursor.getColumnIndex("mobileCode");
      if (i != -1) {
        break label2159;
      }
      paramaukz.a(new NoColumnError("mobileCode", String.class));
      label992:
      i = paramCursor.getColumnIndex("unifiedCode");
      if (i != -1) {
        break label2174;
      }
      paramaukz.a(new NoColumnError("unifiedCode", String.class));
      label1026:
      i = paramCursor.getColumnIndex("nickName");
      if (i != -1) {
        break label2189;
      }
      paramaukz.a(new NoColumnError("nickName", String.class));
      label1060:
      i = paramCursor.getColumnIndex("originBinder");
      if (i != -1) {
        break label2204;
      }
      paramaukz.a(new NoColumnError("originBinder", Long.TYPE));
      label1095:
      i = paramCursor.getColumnIndex("ability");
      if (i != -1) {
        break label2219;
      }
      paramaukz.a(new NoColumnError("ability", Integer.TYPE));
      label1130:
      i = paramCursor.getColumnIndex("contactID");
      if (i != -1) {
        break label2234;
      }
      paramaukz.a(new NoColumnError("contactID", Integer.TYPE));
      label1165:
      i = paramCursor.getColumnIndex("faceUrl");
      if (i != -1) {
        break label2249;
      }
      paramaukz.a(new NoColumnError("faceUrl", String.class));
      label1199:
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label2264;
      }
      paramaukz.a(new NoColumnError("remark", String.class));
      label1233:
      i = paramCursor.getColumnIndex("pinyinAll");
      if (i != -1) {
        break label2279;
      }
      paramaukz.a(new NoColumnError("pinyinAll", String.class));
      label1267:
      i = paramCursor.getColumnIndex("pinyinInitial");
      if (i != -1) {
        break label2294;
      }
      paramaukz.a(new NoColumnError("pinyinInitial", String.class));
      label1301:
      i = paramCursor.getColumnIndex("lastScanTime");
      if (i != -1) {
        break label2309;
      }
      paramaukz.a(new NoColumnError("lastScanTime", Long.TYPE));
      label1336:
      i = paramCursor.getColumnIndex("isUploaded");
      if (i != -1) {
        break label2324;
      }
      paramaukz.a(new NoColumnError("isUploaded", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sortWeight");
      if (i != -1) {
        break label2351;
      }
      paramaukz.a(new NoColumnError("sortWeight", Integer.TYPE));
      label1406:
      i = paramCursor.getColumnIndex("hasSendAddReq");
      if (i != -1) {
        break label2366;
      }
      paramaukz.a(new NoColumnError("hasSendAddReq", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isNewRecommend");
      if (i != -1) {
        break label2393;
      }
      paramaukz.a(new NoColumnError("isNewRecommend", Boolean.TYPE));
      i = paramCursor.getColumnIndex("highLightTimeStamp");
      if (i != -1) {
        break label2420;
      }
      paramaukz.a(new NoColumnError("highLightTimeStamp", Long.TYPE));
      label1511:
      i = paramCursor.getColumnIndex("isHiden");
      if (i != -1) {
        break label2435;
      }
      paramaukz.a(new NoColumnError("isHiden", Boolean.TYPE));
      i = paramCursor.getColumnIndex("md5");
      if (i != -1) {
        break label2463;
      }
      paramaukz.a(new NoColumnError("md5", String.class));
      label1580:
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label2478;
      }
      paramaukz.a(new NoColumnError("type", Integer.TYPE));
      label1615:
      i = paramCursor.getColumnIndex("label");
      if (i != -1) {
        break label2493;
      }
      paramaukz.a(new NoColumnError("label", String.class));
      label1649:
      i = paramCursor.getColumnIndex("detalStatusFlag");
      if (i != -1) {
        break label2508;
      }
      paramaukz.a(new NoColumnError("detalStatusFlag", Byte.TYPE));
      label1684:
      i = paramCursor.getColumnIndex("iTermType");
      if (i != -1) {
        break label2524;
      }
      paramaukz.a(new NoColumnError("iTermType", Integer.TYPE));
      label1719:
      i = paramCursor.getColumnIndex("eNetworkType");
      if (i != -1) {
        break label2539;
      }
      paramaukz.a(new NoColumnError("eNetworkType", Integer.TYPE));
      label1754:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label2554;
      }
      paramaukz.a(new NoColumnError("richTime", Long.TYPE));
      label1789:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label2569;
      }
      paramaukz.a(new NoColumnError("richBuffer", [B.class));
      label1823:
      i = paramCursor.getColumnIndex("sex");
      if (i != -1) {
        break label2584;
      }
      paramaukz.a(new NoColumnError("sex", Integer.TYPE));
      label1858:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label2599;
      }
      paramaukz.a(new NoColumnError("age", Integer.TYPE));
      label1893:
      i = paramCursor.getColumnIndex("samFriend");
      if (i != -1) {
        break label2614;
      }
      paramaukz.a(new NoColumnError("samFriend", Integer.TYPE));
      label1928:
      i = paramCursor.getColumnIndex("abilityBits");
      if (i != -1) {
        break label2629;
      }
      paramaukz.a(new NoColumnError("abilityBits", Long.TYPE));
      label1963:
      i = paramCursor.getColumnIndex("strTermDesc");
      if (i != -1) {
        break label2644;
      }
      paramaukz.a(new NoColumnError("strTermDesc", String.class));
      label1997:
      i = paramCursor.getColumnIndex("netTypeIconIdIphoneOrWphoneNoWifi");
      if (i != -1) {
        break label2659;
      }
      paramaukz.a(new NoColumnError("netTypeIconIdIphoneOrWphoneNoWifi", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("netTypeIconId");
      if (i != -1) {
        break label2674;
      }
      paramaukz.a(new NoColumnError("netTypeIconId", Integer.TYPE));
      return paramauko;
      paramauko.mobileNo = paramCursor.getString(i);
      break;
      label2084:
      paramauko.uin = paramCursor.getString(i);
      break label820;
      label2099:
      paramauko.name = paramCursor.getString(i);
      break label854;
      label2114:
      paramauko.bindingDate = paramCursor.getLong(i);
      break label889;
      label2129:
      paramauko.isRecommend = paramCursor.getInt(i);
      break label924;
      label2144:
      paramauko.nationCode = paramCursor.getString(i);
      break label958;
      label2159:
      paramauko.mobileCode = paramCursor.getString(i);
      break label992;
      label2174:
      paramauko.unifiedCode = paramCursor.getString(i);
      break label1026;
      label2189:
      paramauko.nickName = paramCursor.getString(i);
      break label1060;
      label2204:
      paramauko.originBinder = paramCursor.getLong(i);
      break label1095;
      label2219:
      paramauko.ability = paramCursor.getInt(i);
      break label1130;
      label2234:
      paramauko.contactID = paramCursor.getInt(i);
      break label1165;
      label2249:
      paramauko.faceUrl = paramCursor.getString(i);
      break label1199;
      label2264:
      paramauko.remark = paramCursor.getString(i);
      break label1233;
      label2279:
      paramauko.pinyinAll = paramCursor.getString(i);
      break label1267;
      label2294:
      paramauko.pinyinInitial = paramCursor.getString(i);
      break label1301;
      label2309:
      paramauko.lastScanTime = paramCursor.getLong(i);
      break label1336;
      label2324:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isUploaded = paramBoolean;
        break;
      }
      label2351:
      paramauko.sortWeight = paramCursor.getInt(i);
      break label1406;
      label2366:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.hasSendAddReq = paramBoolean;
        break;
      }
      label2393:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isNewRecommend = paramBoolean;
        break;
      }
      label2420:
      paramauko.highLightTimeStamp = paramCursor.getLong(i);
      break label1511;
      label2435:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramauko.isHiden = paramBoolean;
        break;
      }
      label2463:
      paramauko.md5 = paramCursor.getString(i);
      break label1580;
      label2478:
      paramauko.type = paramCursor.getInt(i);
      break label1615;
      label2493:
      paramauko.label = paramCursor.getString(i);
      break label1649;
      label2508:
      paramauko.detalStatusFlag = ((byte)paramCursor.getShort(i));
      break label1684;
      label2524:
      paramauko.iTermType = paramCursor.getInt(i);
      break label1719;
      label2539:
      paramauko.eNetworkType = paramCursor.getInt(i);
      break label1754;
      label2554:
      paramauko.richTime = paramCursor.getLong(i);
      break label1789;
      label2569:
      paramauko.richBuffer = paramCursor.getBlob(i);
      break label1823;
      label2584:
      paramauko.sex = paramCursor.getInt(i);
      break label1858;
      label2599:
      paramauko.age = paramCursor.getInt(i);
      break label1893;
      label2614:
      paramauko.samFriend = paramCursor.getInt(i);
      break label1928;
      label2629:
      paramauko.abilityBits = paramCursor.getLong(i);
      break label1963;
      label2644:
      paramauko.strTermDesc = paramCursor.getString(i);
      break label1997;
      label2659:
      paramauko.netTypeIconIdIphoneOrWphoneNoWifi = paramCursor.getInt(i);
    }
    label2674:
    paramauko.netTypeIconId = paramCursor.getInt(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,mobileNo TEXT UNIQUE ,uin TEXT ,name TEXT ,bindingDate INTEGER ,isRecommend INTEGER ,nationCode TEXT ,mobileCode TEXT ,unifiedCode TEXT ,nickName TEXT ,originBinder INTEGER ,ability INTEGER ,contactID INTEGER ,faceUrl TEXT ,remark TEXT ,pinyinAll TEXT ,pinyinInitial TEXT ,lastScanTime INTEGER ,isUploaded INTEGER ,sortWeight INTEGER ,hasSendAddReq INTEGER ,isNewRecommend INTEGER ,highLightTimeStamp INTEGER ,isHiden INTEGER ,md5 TEXT ,type INTEGER ,label TEXT ,detalStatusFlag INTEGER ,iTermType INTEGER ,eNetworkType INTEGER ,richTime INTEGER ,richBuffer BLOB ,sex INTEGER ,age INTEGER ,samFriend INTEGER ,abilityBits INTEGER ,strTermDesc TEXT ,netTypeIconIdIphoneOrWphoneNoWifi INTEGER ,netTypeIconId INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (PhoneContact)paramauko;
    paramContentValues.put("mobileNo", paramauko.mobileNo);
    paramContentValues.put("uin", paramauko.uin);
    paramContentValues.put("name", paramauko.name);
    paramContentValues.put("bindingDate", Long.valueOf(paramauko.bindingDate));
    paramContentValues.put("isRecommend", Integer.valueOf(paramauko.isRecommend));
    paramContentValues.put("nationCode", paramauko.nationCode);
    paramContentValues.put("mobileCode", paramauko.mobileCode);
    paramContentValues.put("unifiedCode", paramauko.unifiedCode);
    paramContentValues.put("nickName", paramauko.nickName);
    paramContentValues.put("originBinder", Long.valueOf(paramauko.originBinder));
    paramContentValues.put("ability", Integer.valueOf(paramauko.ability));
    paramContentValues.put("contactID", Integer.valueOf(paramauko.contactID));
    paramContentValues.put("faceUrl", paramauko.faceUrl);
    paramContentValues.put("remark", paramauko.remark);
    paramContentValues.put("pinyinAll", paramauko.pinyinAll);
    paramContentValues.put("pinyinInitial", paramauko.pinyinInitial);
    paramContentValues.put("lastScanTime", Long.valueOf(paramauko.lastScanTime));
    paramContentValues.put("isUploaded", Boolean.valueOf(paramauko.isUploaded));
    paramContentValues.put("sortWeight", Integer.valueOf(paramauko.sortWeight));
    paramContentValues.put("hasSendAddReq", Boolean.valueOf(paramauko.hasSendAddReq));
    paramContentValues.put("isNewRecommend", Boolean.valueOf(paramauko.isNewRecommend));
    paramContentValues.put("highLightTimeStamp", Long.valueOf(paramauko.highLightTimeStamp));
    paramContentValues.put("isHiden", Boolean.valueOf(paramauko.isHiden));
    paramContentValues.put("md5", paramauko.md5);
    paramContentValues.put("type", Integer.valueOf(paramauko.type));
    paramContentValues.put("label", paramauko.label);
    paramContentValues.put("detalStatusFlag", Byte.valueOf(paramauko.detalStatusFlag));
    paramContentValues.put("iTermType", Integer.valueOf(paramauko.iTermType));
    paramContentValues.put("eNetworkType", Integer.valueOf(paramauko.eNetworkType));
    paramContentValues.put("richTime", Long.valueOf(paramauko.richTime));
    paramContentValues.put("richBuffer", paramauko.richBuffer);
    paramContentValues.put("sex", Integer.valueOf(paramauko.sex));
    paramContentValues.put("age", Integer.valueOf(paramauko.age));
    paramContentValues.put("samFriend", Integer.valueOf(paramauko.samFriend));
    paramContentValues.put("abilityBits", Long.valueOf(paramauko.abilityBits));
    paramContentValues.put("strTermDesc", paramauko.strTermDesc);
    paramContentValues.put("netTypeIconIdIphoneOrWphoneNoWifi", Integer.valueOf(paramauko.netTypeIconIdIphoneOrWphoneNoWifi));
    paramContentValues.put("netTypeIconId", Integer.valueOf(paramauko.netTypeIconId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auld
 * JD-Core Version:    0.7.0.1
 */