import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atnd
  extends atna
{
  public atnd()
  {
    this.a = 38;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramatmo = (PhoneContact)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.mobileNo = paramCursor.getString(paramCursor.getColumnIndex("mobileNo"));
      paramatmo.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramatmo.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramatmo.bindingDate = paramCursor.getLong(paramCursor.getColumnIndex("bindingDate"));
      paramatmo.isRecommend = paramCursor.getInt(paramCursor.getColumnIndex("isRecommend"));
      paramatmo.nationCode = paramCursor.getString(paramCursor.getColumnIndex("nationCode"));
      paramatmo.mobileCode = paramCursor.getString(paramCursor.getColumnIndex("mobileCode"));
      paramatmo.unifiedCode = paramCursor.getString(paramCursor.getColumnIndex("unifiedCode"));
      paramatmo.nickName = paramCursor.getString(paramCursor.getColumnIndex("nickName"));
      paramatmo.originBinder = paramCursor.getLong(paramCursor.getColumnIndex("originBinder"));
      paramatmo.ability = paramCursor.getInt(paramCursor.getColumnIndex("ability"));
      paramatmo.contactID = paramCursor.getInt(paramCursor.getColumnIndex("contactID"));
      paramatmo.faceUrl = paramCursor.getString(paramCursor.getColumnIndex("faceUrl"));
      paramatmo.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramatmo.pinyinAll = paramCursor.getString(paramCursor.getColumnIndex("pinyinAll"));
      paramatmo.pinyinInitial = paramCursor.getString(paramCursor.getColumnIndex("pinyinInitial"));
      paramatmo.lastScanTime = paramCursor.getLong(paramCursor.getColumnIndex("lastScanTime"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isUploaded")))
      {
        paramBoolean = true;
        paramatmo.isUploaded = paramBoolean;
        paramatmo.sortWeight = paramCursor.getInt(paramCursor.getColumnIndex("sortWeight"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSendAddReq"))) {
          break label737;
        }
        paramBoolean = true;
        label385:
        paramatmo.hasSendAddReq = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isNewRecommend"))) {
          break label742;
        }
        paramBoolean = true;
        label410:
        paramatmo.isNewRecommend = paramBoolean;
        paramatmo.highLightTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("highLightTimeStamp"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isHiden"))) {
          break label747;
        }
      }
      label737:
      label742:
      label747:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramatmo.isHiden = paramBoolean;
        paramatmo.md5 = paramCursor.getString(paramCursor.getColumnIndex("md5"));
        paramatmo.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
        paramatmo.label = paramCursor.getString(paramCursor.getColumnIndex("label"));
        paramatmo.detalStatusFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("detalStatusFlag")));
        paramatmo.iTermType = paramCursor.getInt(paramCursor.getColumnIndex("iTermType"));
        paramatmo.eNetworkType = paramCursor.getInt(paramCursor.getColumnIndex("eNetworkType"));
        paramatmo.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
        paramatmo.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
        paramatmo.sex = paramCursor.getInt(paramCursor.getColumnIndex("sex"));
        paramatmo.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
        paramatmo.samFriend = paramCursor.getInt(paramCursor.getColumnIndex("samFriend"));
        paramatmo.abilityBits = paramCursor.getLong(paramCursor.getColumnIndex("abilityBits"));
        paramatmo.strTermDesc = paramCursor.getString(paramCursor.getColumnIndex("strTermDesc"));
        paramatmo.netTypeIconIdIphoneOrWphoneNoWifi = paramCursor.getInt(paramCursor.getColumnIndex("netTypeIconIdIphoneOrWphoneNoWifi"));
        paramatmo.netTypeIconId = paramCursor.getInt(paramCursor.getColumnIndex("netTypeIconId"));
        return paramatmo;
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
      paramatmz.a(new NoColumnError("mobileNo", String.class));
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label2084;
      }
      paramatmz.a(new NoColumnError("uin", String.class));
      label820:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label2099;
      }
      paramatmz.a(new NoColumnError("name", String.class));
      label854:
      i = paramCursor.getColumnIndex("bindingDate");
      if (i != -1) {
        break label2114;
      }
      paramatmz.a(new NoColumnError("bindingDate", Long.TYPE));
      label889:
      i = paramCursor.getColumnIndex("isRecommend");
      if (i != -1) {
        break label2129;
      }
      paramatmz.a(new NoColumnError("isRecommend", Integer.TYPE));
      label924:
      i = paramCursor.getColumnIndex("nationCode");
      if (i != -1) {
        break label2144;
      }
      paramatmz.a(new NoColumnError("nationCode", String.class));
      label958:
      i = paramCursor.getColumnIndex("mobileCode");
      if (i != -1) {
        break label2159;
      }
      paramatmz.a(new NoColumnError("mobileCode", String.class));
      label992:
      i = paramCursor.getColumnIndex("unifiedCode");
      if (i != -1) {
        break label2174;
      }
      paramatmz.a(new NoColumnError("unifiedCode", String.class));
      label1026:
      i = paramCursor.getColumnIndex("nickName");
      if (i != -1) {
        break label2189;
      }
      paramatmz.a(new NoColumnError("nickName", String.class));
      label1060:
      i = paramCursor.getColumnIndex("originBinder");
      if (i != -1) {
        break label2204;
      }
      paramatmz.a(new NoColumnError("originBinder", Long.TYPE));
      label1095:
      i = paramCursor.getColumnIndex("ability");
      if (i != -1) {
        break label2219;
      }
      paramatmz.a(new NoColumnError("ability", Integer.TYPE));
      label1130:
      i = paramCursor.getColumnIndex("contactID");
      if (i != -1) {
        break label2234;
      }
      paramatmz.a(new NoColumnError("contactID", Integer.TYPE));
      label1165:
      i = paramCursor.getColumnIndex("faceUrl");
      if (i != -1) {
        break label2249;
      }
      paramatmz.a(new NoColumnError("faceUrl", String.class));
      label1199:
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label2264;
      }
      paramatmz.a(new NoColumnError("remark", String.class));
      label1233:
      i = paramCursor.getColumnIndex("pinyinAll");
      if (i != -1) {
        break label2279;
      }
      paramatmz.a(new NoColumnError("pinyinAll", String.class));
      label1267:
      i = paramCursor.getColumnIndex("pinyinInitial");
      if (i != -1) {
        break label2294;
      }
      paramatmz.a(new NoColumnError("pinyinInitial", String.class));
      label1301:
      i = paramCursor.getColumnIndex("lastScanTime");
      if (i != -1) {
        break label2309;
      }
      paramatmz.a(new NoColumnError("lastScanTime", Long.TYPE));
      label1336:
      i = paramCursor.getColumnIndex("isUploaded");
      if (i != -1) {
        break label2324;
      }
      paramatmz.a(new NoColumnError("isUploaded", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sortWeight");
      if (i != -1) {
        break label2351;
      }
      paramatmz.a(new NoColumnError("sortWeight", Integer.TYPE));
      label1406:
      i = paramCursor.getColumnIndex("hasSendAddReq");
      if (i != -1) {
        break label2366;
      }
      paramatmz.a(new NoColumnError("hasSendAddReq", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isNewRecommend");
      if (i != -1) {
        break label2393;
      }
      paramatmz.a(new NoColumnError("isNewRecommend", Boolean.TYPE));
      i = paramCursor.getColumnIndex("highLightTimeStamp");
      if (i != -1) {
        break label2420;
      }
      paramatmz.a(new NoColumnError("highLightTimeStamp", Long.TYPE));
      label1511:
      i = paramCursor.getColumnIndex("isHiden");
      if (i != -1) {
        break label2435;
      }
      paramatmz.a(new NoColumnError("isHiden", Boolean.TYPE));
      i = paramCursor.getColumnIndex("md5");
      if (i != -1) {
        break label2463;
      }
      paramatmz.a(new NoColumnError("md5", String.class));
      label1580:
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label2478;
      }
      paramatmz.a(new NoColumnError("type", Integer.TYPE));
      label1615:
      i = paramCursor.getColumnIndex("label");
      if (i != -1) {
        break label2493;
      }
      paramatmz.a(new NoColumnError("label", String.class));
      label1649:
      i = paramCursor.getColumnIndex("detalStatusFlag");
      if (i != -1) {
        break label2508;
      }
      paramatmz.a(new NoColumnError("detalStatusFlag", Byte.TYPE));
      label1684:
      i = paramCursor.getColumnIndex("iTermType");
      if (i != -1) {
        break label2524;
      }
      paramatmz.a(new NoColumnError("iTermType", Integer.TYPE));
      label1719:
      i = paramCursor.getColumnIndex("eNetworkType");
      if (i != -1) {
        break label2539;
      }
      paramatmz.a(new NoColumnError("eNetworkType", Integer.TYPE));
      label1754:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label2554;
      }
      paramatmz.a(new NoColumnError("richTime", Long.TYPE));
      label1789:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label2569;
      }
      paramatmz.a(new NoColumnError("richBuffer", [B.class));
      label1823:
      i = paramCursor.getColumnIndex("sex");
      if (i != -1) {
        break label2584;
      }
      paramatmz.a(new NoColumnError("sex", Integer.TYPE));
      label1858:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label2599;
      }
      paramatmz.a(new NoColumnError("age", Integer.TYPE));
      label1893:
      i = paramCursor.getColumnIndex("samFriend");
      if (i != -1) {
        break label2614;
      }
      paramatmz.a(new NoColumnError("samFriend", Integer.TYPE));
      label1928:
      i = paramCursor.getColumnIndex("abilityBits");
      if (i != -1) {
        break label2629;
      }
      paramatmz.a(new NoColumnError("abilityBits", Long.TYPE));
      label1963:
      i = paramCursor.getColumnIndex("strTermDesc");
      if (i != -1) {
        break label2644;
      }
      paramatmz.a(new NoColumnError("strTermDesc", String.class));
      label1997:
      i = paramCursor.getColumnIndex("netTypeIconIdIphoneOrWphoneNoWifi");
      if (i != -1) {
        break label2659;
      }
      paramatmz.a(new NoColumnError("netTypeIconIdIphoneOrWphoneNoWifi", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("netTypeIconId");
      if (i != -1) {
        break label2674;
      }
      paramatmz.a(new NoColumnError("netTypeIconId", Integer.TYPE));
      return paramatmo;
      paramatmo.mobileNo = paramCursor.getString(i);
      break;
      label2084:
      paramatmo.uin = paramCursor.getString(i);
      break label820;
      label2099:
      paramatmo.name = paramCursor.getString(i);
      break label854;
      label2114:
      paramatmo.bindingDate = paramCursor.getLong(i);
      break label889;
      label2129:
      paramatmo.isRecommend = paramCursor.getInt(i);
      break label924;
      label2144:
      paramatmo.nationCode = paramCursor.getString(i);
      break label958;
      label2159:
      paramatmo.mobileCode = paramCursor.getString(i);
      break label992;
      label2174:
      paramatmo.unifiedCode = paramCursor.getString(i);
      break label1026;
      label2189:
      paramatmo.nickName = paramCursor.getString(i);
      break label1060;
      label2204:
      paramatmo.originBinder = paramCursor.getLong(i);
      break label1095;
      label2219:
      paramatmo.ability = paramCursor.getInt(i);
      break label1130;
      label2234:
      paramatmo.contactID = paramCursor.getInt(i);
      break label1165;
      label2249:
      paramatmo.faceUrl = paramCursor.getString(i);
      break label1199;
      label2264:
      paramatmo.remark = paramCursor.getString(i);
      break label1233;
      label2279:
      paramatmo.pinyinAll = paramCursor.getString(i);
      break label1267;
      label2294:
      paramatmo.pinyinInitial = paramCursor.getString(i);
      break label1301;
      label2309:
      paramatmo.lastScanTime = paramCursor.getLong(i);
      break label1336;
      label2324:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isUploaded = paramBoolean;
        break;
      }
      label2351:
      paramatmo.sortWeight = paramCursor.getInt(i);
      break label1406;
      label2366:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.hasSendAddReq = paramBoolean;
        break;
      }
      label2393:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isNewRecommend = paramBoolean;
        break;
      }
      label2420:
      paramatmo.highLightTimeStamp = paramCursor.getLong(i);
      break label1511;
      label2435:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramatmo.isHiden = paramBoolean;
        break;
      }
      label2463:
      paramatmo.md5 = paramCursor.getString(i);
      break label1580;
      label2478:
      paramatmo.type = paramCursor.getInt(i);
      break label1615;
      label2493:
      paramatmo.label = paramCursor.getString(i);
      break label1649;
      label2508:
      paramatmo.detalStatusFlag = ((byte)paramCursor.getShort(i));
      break label1684;
      label2524:
      paramatmo.iTermType = paramCursor.getInt(i);
      break label1719;
      label2539:
      paramatmo.eNetworkType = paramCursor.getInt(i);
      break label1754;
      label2554:
      paramatmo.richTime = paramCursor.getLong(i);
      break label1789;
      label2569:
      paramatmo.richBuffer = paramCursor.getBlob(i);
      break label1823;
      label2584:
      paramatmo.sex = paramCursor.getInt(i);
      break label1858;
      label2599:
      paramatmo.age = paramCursor.getInt(i);
      break label1893;
      label2614:
      paramatmo.samFriend = paramCursor.getInt(i);
      break label1928;
      label2629:
      paramatmo.abilityBits = paramCursor.getLong(i);
      break label1963;
      label2644:
      paramatmo.strTermDesc = paramCursor.getString(i);
      break label1997;
      label2659:
      paramatmo.netTypeIconIdIphoneOrWphoneNoWifi = paramCursor.getInt(i);
    }
    label2674:
    paramatmo.netTypeIconId = paramCursor.getInt(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,mobileNo TEXT UNIQUE ,uin TEXT ,name TEXT ,bindingDate INTEGER ,isRecommend INTEGER ,nationCode TEXT ,mobileCode TEXT ,unifiedCode TEXT ,nickName TEXT ,originBinder INTEGER ,ability INTEGER ,contactID INTEGER ,faceUrl TEXT ,remark TEXT ,pinyinAll TEXT ,pinyinInitial TEXT ,lastScanTime INTEGER ,isUploaded INTEGER ,sortWeight INTEGER ,hasSendAddReq INTEGER ,isNewRecommend INTEGER ,highLightTimeStamp INTEGER ,isHiden INTEGER ,md5 TEXT ,type INTEGER ,label TEXT ,detalStatusFlag INTEGER ,iTermType INTEGER ,eNetworkType INTEGER ,richTime INTEGER ,richBuffer BLOB ,sex INTEGER ,age INTEGER ,samFriend INTEGER ,abilityBits INTEGER ,strTermDesc TEXT ,netTypeIconIdIphoneOrWphoneNoWifi INTEGER ,netTypeIconId INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (PhoneContact)paramatmo;
    paramContentValues.put("mobileNo", paramatmo.mobileNo);
    paramContentValues.put("uin", paramatmo.uin);
    paramContentValues.put("name", paramatmo.name);
    paramContentValues.put("bindingDate", Long.valueOf(paramatmo.bindingDate));
    paramContentValues.put("isRecommend", Integer.valueOf(paramatmo.isRecommend));
    paramContentValues.put("nationCode", paramatmo.nationCode);
    paramContentValues.put("mobileCode", paramatmo.mobileCode);
    paramContentValues.put("unifiedCode", paramatmo.unifiedCode);
    paramContentValues.put("nickName", paramatmo.nickName);
    paramContentValues.put("originBinder", Long.valueOf(paramatmo.originBinder));
    paramContentValues.put("ability", Integer.valueOf(paramatmo.ability));
    paramContentValues.put("contactID", Integer.valueOf(paramatmo.contactID));
    paramContentValues.put("faceUrl", paramatmo.faceUrl);
    paramContentValues.put("remark", paramatmo.remark);
    paramContentValues.put("pinyinAll", paramatmo.pinyinAll);
    paramContentValues.put("pinyinInitial", paramatmo.pinyinInitial);
    paramContentValues.put("lastScanTime", Long.valueOf(paramatmo.lastScanTime));
    paramContentValues.put("isUploaded", Boolean.valueOf(paramatmo.isUploaded));
    paramContentValues.put("sortWeight", Integer.valueOf(paramatmo.sortWeight));
    paramContentValues.put("hasSendAddReq", Boolean.valueOf(paramatmo.hasSendAddReq));
    paramContentValues.put("isNewRecommend", Boolean.valueOf(paramatmo.isNewRecommend));
    paramContentValues.put("highLightTimeStamp", Long.valueOf(paramatmo.highLightTimeStamp));
    paramContentValues.put("isHiden", Boolean.valueOf(paramatmo.isHiden));
    paramContentValues.put("md5", paramatmo.md5);
    paramContentValues.put("type", Integer.valueOf(paramatmo.type));
    paramContentValues.put("label", paramatmo.label);
    paramContentValues.put("detalStatusFlag", Byte.valueOf(paramatmo.detalStatusFlag));
    paramContentValues.put("iTermType", Integer.valueOf(paramatmo.iTermType));
    paramContentValues.put("eNetworkType", Integer.valueOf(paramatmo.eNetworkType));
    paramContentValues.put("richTime", Long.valueOf(paramatmo.richTime));
    paramContentValues.put("richBuffer", paramatmo.richBuffer);
    paramContentValues.put("sex", Integer.valueOf(paramatmo.sex));
    paramContentValues.put("age", Integer.valueOf(paramatmo.age));
    paramContentValues.put("samFriend", Integer.valueOf(paramatmo.samFriend));
    paramContentValues.put("abilityBits", Long.valueOf(paramatmo.abilityBits));
    paramContentValues.put("strTermDesc", paramatmo.strTermDesc);
    paramContentValues.put("netTypeIconIdIphoneOrWphoneNoWifi", Integer.valueOf(paramatmo.netTypeIconIdIphoneOrWphoneNoWifi));
    paramContentValues.put("netTypeIconId", Integer.valueOf(paramatmo.netTypeIconId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atnd
 * JD-Core Version:    0.7.0.1
 */