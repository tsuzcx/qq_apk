import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awgt
  extends awgq
{
  public awgt()
  {
    this.a = 38;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawge = (PhoneContact)paramawge;
    if (paramawgp == null)
    {
      paramawge.mobileNo = paramCursor.getString(paramCursor.getColumnIndex("mobileNo"));
      paramawge.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawge.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramawge.bindingDate = paramCursor.getLong(paramCursor.getColumnIndex("bindingDate"));
      paramawge.isRecommend = paramCursor.getInt(paramCursor.getColumnIndex("isRecommend"));
      paramawge.nationCode = paramCursor.getString(paramCursor.getColumnIndex("nationCode"));
      paramawge.mobileCode = paramCursor.getString(paramCursor.getColumnIndex("mobileCode"));
      paramawge.unifiedCode = paramCursor.getString(paramCursor.getColumnIndex("unifiedCode"));
      paramawge.nickName = paramCursor.getString(paramCursor.getColumnIndex("nickName"));
      paramawge.originBinder = paramCursor.getLong(paramCursor.getColumnIndex("originBinder"));
      paramawge.ability = paramCursor.getInt(paramCursor.getColumnIndex("ability"));
      paramawge.contactID = paramCursor.getInt(paramCursor.getColumnIndex("contactID"));
      paramawge.faceUrl = paramCursor.getString(paramCursor.getColumnIndex("faceUrl"));
      paramawge.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramawge.pinyinAll = paramCursor.getString(paramCursor.getColumnIndex("pinyinAll"));
      paramawge.pinyinInitial = paramCursor.getString(paramCursor.getColumnIndex("pinyinInitial"));
      paramawge.lastScanTime = paramCursor.getLong(paramCursor.getColumnIndex("lastScanTime"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isUploaded")))
      {
        paramBoolean = true;
        paramawge.isUploaded = paramBoolean;
        paramawge.sortWeight = paramCursor.getInt(paramCursor.getColumnIndex("sortWeight"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSendAddReq"))) {
          break label737;
        }
        paramBoolean = true;
        label385:
        paramawge.hasSendAddReq = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isNewRecommend"))) {
          break label742;
        }
        paramBoolean = true;
        label410:
        paramawge.isNewRecommend = paramBoolean;
        paramawge.highLightTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("highLightTimeStamp"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isHiden"))) {
          break label747;
        }
      }
      label737:
      label742:
      label747:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramawge.isHiden = paramBoolean;
        paramawge.md5 = paramCursor.getString(paramCursor.getColumnIndex("md5"));
        paramawge.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
        paramawge.label = paramCursor.getString(paramCursor.getColumnIndex("label"));
        paramawge.detalStatusFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("detalStatusFlag")));
        paramawge.iTermType = paramCursor.getInt(paramCursor.getColumnIndex("iTermType"));
        paramawge.eNetworkType = paramCursor.getInt(paramCursor.getColumnIndex("eNetworkType"));
        paramawge.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
        paramawge.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
        paramawge.sex = paramCursor.getInt(paramCursor.getColumnIndex("sex"));
        paramawge.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
        paramawge.samFriend = paramCursor.getInt(paramCursor.getColumnIndex("samFriend"));
        paramawge.abilityBits = paramCursor.getLong(paramCursor.getColumnIndex("abilityBits"));
        paramawge.strTermDesc = paramCursor.getString(paramCursor.getColumnIndex("strTermDesc"));
        paramawge.netTypeIconIdIphoneOrWphoneNoWifi = paramCursor.getInt(paramCursor.getColumnIndex("netTypeIconIdIphoneOrWphoneNoWifi"));
        paramawge.netTypeIconId = paramCursor.getInt(paramCursor.getColumnIndex("netTypeIconId"));
        return paramawge;
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
      paramawgp.a(new NoColumnError("mobileNo", String.class));
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label2084;
      }
      paramawgp.a(new NoColumnError("uin", String.class));
      label820:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label2099;
      }
      paramawgp.a(new NoColumnError("name", String.class));
      label854:
      i = paramCursor.getColumnIndex("bindingDate");
      if (i != -1) {
        break label2114;
      }
      paramawgp.a(new NoColumnError("bindingDate", Long.TYPE));
      label889:
      i = paramCursor.getColumnIndex("isRecommend");
      if (i != -1) {
        break label2129;
      }
      paramawgp.a(new NoColumnError("isRecommend", Integer.TYPE));
      label924:
      i = paramCursor.getColumnIndex("nationCode");
      if (i != -1) {
        break label2144;
      }
      paramawgp.a(new NoColumnError("nationCode", String.class));
      label958:
      i = paramCursor.getColumnIndex("mobileCode");
      if (i != -1) {
        break label2159;
      }
      paramawgp.a(new NoColumnError("mobileCode", String.class));
      label992:
      i = paramCursor.getColumnIndex("unifiedCode");
      if (i != -1) {
        break label2174;
      }
      paramawgp.a(new NoColumnError("unifiedCode", String.class));
      label1026:
      i = paramCursor.getColumnIndex("nickName");
      if (i != -1) {
        break label2189;
      }
      paramawgp.a(new NoColumnError("nickName", String.class));
      label1060:
      i = paramCursor.getColumnIndex("originBinder");
      if (i != -1) {
        break label2204;
      }
      paramawgp.a(new NoColumnError("originBinder", Long.TYPE));
      label1095:
      i = paramCursor.getColumnIndex("ability");
      if (i != -1) {
        break label2219;
      }
      paramawgp.a(new NoColumnError("ability", Integer.TYPE));
      label1130:
      i = paramCursor.getColumnIndex("contactID");
      if (i != -1) {
        break label2234;
      }
      paramawgp.a(new NoColumnError("contactID", Integer.TYPE));
      label1165:
      i = paramCursor.getColumnIndex("faceUrl");
      if (i != -1) {
        break label2249;
      }
      paramawgp.a(new NoColumnError("faceUrl", String.class));
      label1199:
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label2264;
      }
      paramawgp.a(new NoColumnError("remark", String.class));
      label1233:
      i = paramCursor.getColumnIndex("pinyinAll");
      if (i != -1) {
        break label2279;
      }
      paramawgp.a(new NoColumnError("pinyinAll", String.class));
      label1267:
      i = paramCursor.getColumnIndex("pinyinInitial");
      if (i != -1) {
        break label2294;
      }
      paramawgp.a(new NoColumnError("pinyinInitial", String.class));
      label1301:
      i = paramCursor.getColumnIndex("lastScanTime");
      if (i != -1) {
        break label2309;
      }
      paramawgp.a(new NoColumnError("lastScanTime", Long.TYPE));
      label1336:
      i = paramCursor.getColumnIndex("isUploaded");
      if (i != -1) {
        break label2324;
      }
      paramawgp.a(new NoColumnError("isUploaded", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sortWeight");
      if (i != -1) {
        break label2351;
      }
      paramawgp.a(new NoColumnError("sortWeight", Integer.TYPE));
      label1406:
      i = paramCursor.getColumnIndex("hasSendAddReq");
      if (i != -1) {
        break label2366;
      }
      paramawgp.a(new NoColumnError("hasSendAddReq", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isNewRecommend");
      if (i != -1) {
        break label2393;
      }
      paramawgp.a(new NoColumnError("isNewRecommend", Boolean.TYPE));
      i = paramCursor.getColumnIndex("highLightTimeStamp");
      if (i != -1) {
        break label2420;
      }
      paramawgp.a(new NoColumnError("highLightTimeStamp", Long.TYPE));
      label1511:
      i = paramCursor.getColumnIndex("isHiden");
      if (i != -1) {
        break label2435;
      }
      paramawgp.a(new NoColumnError("isHiden", Boolean.TYPE));
      i = paramCursor.getColumnIndex("md5");
      if (i != -1) {
        break label2463;
      }
      paramawgp.a(new NoColumnError("md5", String.class));
      label1580:
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label2478;
      }
      paramawgp.a(new NoColumnError("type", Integer.TYPE));
      label1615:
      i = paramCursor.getColumnIndex("label");
      if (i != -1) {
        break label2493;
      }
      paramawgp.a(new NoColumnError("label", String.class));
      label1649:
      i = paramCursor.getColumnIndex("detalStatusFlag");
      if (i != -1) {
        break label2508;
      }
      paramawgp.a(new NoColumnError("detalStatusFlag", Byte.TYPE));
      label1684:
      i = paramCursor.getColumnIndex("iTermType");
      if (i != -1) {
        break label2524;
      }
      paramawgp.a(new NoColumnError("iTermType", Integer.TYPE));
      label1719:
      i = paramCursor.getColumnIndex("eNetworkType");
      if (i != -1) {
        break label2539;
      }
      paramawgp.a(new NoColumnError("eNetworkType", Integer.TYPE));
      label1754:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label2554;
      }
      paramawgp.a(new NoColumnError("richTime", Long.TYPE));
      label1789:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label2569;
      }
      paramawgp.a(new NoColumnError("richBuffer", [B.class));
      label1823:
      i = paramCursor.getColumnIndex("sex");
      if (i != -1) {
        break label2584;
      }
      paramawgp.a(new NoColumnError("sex", Integer.TYPE));
      label1858:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label2599;
      }
      paramawgp.a(new NoColumnError("age", Integer.TYPE));
      label1893:
      i = paramCursor.getColumnIndex("samFriend");
      if (i != -1) {
        break label2614;
      }
      paramawgp.a(new NoColumnError("samFriend", Integer.TYPE));
      label1928:
      i = paramCursor.getColumnIndex("abilityBits");
      if (i != -1) {
        break label2629;
      }
      paramawgp.a(new NoColumnError("abilityBits", Long.TYPE));
      label1963:
      i = paramCursor.getColumnIndex("strTermDesc");
      if (i != -1) {
        break label2644;
      }
      paramawgp.a(new NoColumnError("strTermDesc", String.class));
      label1997:
      i = paramCursor.getColumnIndex("netTypeIconIdIphoneOrWphoneNoWifi");
      if (i != -1) {
        break label2659;
      }
      paramawgp.a(new NoColumnError("netTypeIconIdIphoneOrWphoneNoWifi", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("netTypeIconId");
      if (i != -1) {
        break label2674;
      }
      paramawgp.a(new NoColumnError("netTypeIconId", Integer.TYPE));
      return paramawge;
      paramawge.mobileNo = paramCursor.getString(i);
      break;
      label2084:
      paramawge.uin = paramCursor.getString(i);
      break label820;
      label2099:
      paramawge.name = paramCursor.getString(i);
      break label854;
      label2114:
      paramawge.bindingDate = paramCursor.getLong(i);
      break label889;
      label2129:
      paramawge.isRecommend = paramCursor.getInt(i);
      break label924;
      label2144:
      paramawge.nationCode = paramCursor.getString(i);
      break label958;
      label2159:
      paramawge.mobileCode = paramCursor.getString(i);
      break label992;
      label2174:
      paramawge.unifiedCode = paramCursor.getString(i);
      break label1026;
      label2189:
      paramawge.nickName = paramCursor.getString(i);
      break label1060;
      label2204:
      paramawge.originBinder = paramCursor.getLong(i);
      break label1095;
      label2219:
      paramawge.ability = paramCursor.getInt(i);
      break label1130;
      label2234:
      paramawge.contactID = paramCursor.getInt(i);
      break label1165;
      label2249:
      paramawge.faceUrl = paramCursor.getString(i);
      break label1199;
      label2264:
      paramawge.remark = paramCursor.getString(i);
      break label1233;
      label2279:
      paramawge.pinyinAll = paramCursor.getString(i);
      break label1267;
      label2294:
      paramawge.pinyinInitial = paramCursor.getString(i);
      break label1301;
      label2309:
      paramawge.lastScanTime = paramCursor.getLong(i);
      break label1336;
      label2324:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isUploaded = paramBoolean;
        break;
      }
      label2351:
      paramawge.sortWeight = paramCursor.getInt(i);
      break label1406;
      label2366:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.hasSendAddReq = paramBoolean;
        break;
      }
      label2393:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isNewRecommend = paramBoolean;
        break;
      }
      label2420:
      paramawge.highLightTimeStamp = paramCursor.getLong(i);
      break label1511;
      label2435:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramawge.isHiden = paramBoolean;
        break;
      }
      label2463:
      paramawge.md5 = paramCursor.getString(i);
      break label1580;
      label2478:
      paramawge.type = paramCursor.getInt(i);
      break label1615;
      label2493:
      paramawge.label = paramCursor.getString(i);
      break label1649;
      label2508:
      paramawge.detalStatusFlag = ((byte)paramCursor.getShort(i));
      break label1684;
      label2524:
      paramawge.iTermType = paramCursor.getInt(i);
      break label1719;
      label2539:
      paramawge.eNetworkType = paramCursor.getInt(i);
      break label1754;
      label2554:
      paramawge.richTime = paramCursor.getLong(i);
      break label1789;
      label2569:
      paramawge.richBuffer = paramCursor.getBlob(i);
      break label1823;
      label2584:
      paramawge.sex = paramCursor.getInt(i);
      break label1858;
      label2599:
      paramawge.age = paramCursor.getInt(i);
      break label1893;
      label2614:
      paramawge.samFriend = paramCursor.getInt(i);
      break label1928;
      label2629:
      paramawge.abilityBits = paramCursor.getLong(i);
      break label1963;
      label2644:
      paramawge.strTermDesc = paramCursor.getString(i);
      break label1997;
      label2659:
      paramawge.netTypeIconIdIphoneOrWphoneNoWifi = paramCursor.getInt(i);
    }
    label2674:
    paramawge.netTypeIconId = paramCursor.getInt(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,mobileNo TEXT UNIQUE ,uin TEXT ,name TEXT ,bindingDate INTEGER ,isRecommend INTEGER ,nationCode TEXT ,mobileCode TEXT ,unifiedCode TEXT ,nickName TEXT ,originBinder INTEGER ,ability INTEGER ,contactID INTEGER ,faceUrl TEXT ,remark TEXT ,pinyinAll TEXT ,pinyinInitial TEXT ,lastScanTime INTEGER ,isUploaded INTEGER ,sortWeight INTEGER ,hasSendAddReq INTEGER ,isNewRecommend INTEGER ,highLightTimeStamp INTEGER ,isHiden INTEGER ,md5 TEXT ,type INTEGER ,label TEXT ,detalStatusFlag INTEGER ,iTermType INTEGER ,eNetworkType INTEGER ,richTime INTEGER ,richBuffer BLOB ,sex INTEGER ,age INTEGER ,samFriend INTEGER ,abilityBits INTEGER ,strTermDesc TEXT ,netTypeIconIdIphoneOrWphoneNoWifi INTEGER ,netTypeIconId INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (PhoneContact)paramawge;
    paramContentValues.put("mobileNo", paramawge.mobileNo);
    paramContentValues.put("uin", paramawge.uin);
    paramContentValues.put("name", paramawge.name);
    paramContentValues.put("bindingDate", Long.valueOf(paramawge.bindingDate));
    paramContentValues.put("isRecommend", Integer.valueOf(paramawge.isRecommend));
    paramContentValues.put("nationCode", paramawge.nationCode);
    paramContentValues.put("mobileCode", paramawge.mobileCode);
    paramContentValues.put("unifiedCode", paramawge.unifiedCode);
    paramContentValues.put("nickName", paramawge.nickName);
    paramContentValues.put("originBinder", Long.valueOf(paramawge.originBinder));
    paramContentValues.put("ability", Integer.valueOf(paramawge.ability));
    paramContentValues.put("contactID", Integer.valueOf(paramawge.contactID));
    paramContentValues.put("faceUrl", paramawge.faceUrl);
    paramContentValues.put("remark", paramawge.remark);
    paramContentValues.put("pinyinAll", paramawge.pinyinAll);
    paramContentValues.put("pinyinInitial", paramawge.pinyinInitial);
    paramContentValues.put("lastScanTime", Long.valueOf(paramawge.lastScanTime));
    paramContentValues.put("isUploaded", Boolean.valueOf(paramawge.isUploaded));
    paramContentValues.put("sortWeight", Integer.valueOf(paramawge.sortWeight));
    paramContentValues.put("hasSendAddReq", Boolean.valueOf(paramawge.hasSendAddReq));
    paramContentValues.put("isNewRecommend", Boolean.valueOf(paramawge.isNewRecommend));
    paramContentValues.put("highLightTimeStamp", Long.valueOf(paramawge.highLightTimeStamp));
    paramContentValues.put("isHiden", Boolean.valueOf(paramawge.isHiden));
    paramContentValues.put("md5", paramawge.md5);
    paramContentValues.put("type", Integer.valueOf(paramawge.type));
    paramContentValues.put("label", paramawge.label);
    paramContentValues.put("detalStatusFlag", Byte.valueOf(paramawge.detalStatusFlag));
    paramContentValues.put("iTermType", Integer.valueOf(paramawge.iTermType));
    paramContentValues.put("eNetworkType", Integer.valueOf(paramawge.eNetworkType));
    paramContentValues.put("richTime", Long.valueOf(paramawge.richTime));
    paramContentValues.put("richBuffer", paramawge.richBuffer);
    paramContentValues.put("sex", Integer.valueOf(paramawge.sex));
    paramContentValues.put("age", Integer.valueOf(paramawge.age));
    paramContentValues.put("samFriend", Integer.valueOf(paramawge.samFriend));
    paramContentValues.put("abilityBits", Long.valueOf(paramawge.abilityBits));
    paramContentValues.put("strTermDesc", paramawge.strTermDesc);
    paramContentValues.put("netTypeIconIdIphoneOrWphoneNoWifi", Integer.valueOf(paramawge.netTypeIconIdIphoneOrWphoneNoWifi));
    paramContentValues.put("netTypeIconId", Integer.valueOf(paramawge.netTypeIconId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awgt
 * JD-Core Version:    0.7.0.1
 */