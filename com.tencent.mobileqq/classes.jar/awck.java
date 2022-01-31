import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awck
  extends awch
{
  public awck()
  {
    this.a = 38;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawbv = (PhoneContact)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.mobileNo = paramCursor.getString(paramCursor.getColumnIndex("mobileNo"));
      paramawbv.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawbv.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramawbv.bindingDate = paramCursor.getLong(paramCursor.getColumnIndex("bindingDate"));
      paramawbv.isRecommend = paramCursor.getInt(paramCursor.getColumnIndex("isRecommend"));
      paramawbv.nationCode = paramCursor.getString(paramCursor.getColumnIndex("nationCode"));
      paramawbv.mobileCode = paramCursor.getString(paramCursor.getColumnIndex("mobileCode"));
      paramawbv.unifiedCode = paramCursor.getString(paramCursor.getColumnIndex("unifiedCode"));
      paramawbv.nickName = paramCursor.getString(paramCursor.getColumnIndex("nickName"));
      paramawbv.originBinder = paramCursor.getLong(paramCursor.getColumnIndex("originBinder"));
      paramawbv.ability = paramCursor.getInt(paramCursor.getColumnIndex("ability"));
      paramawbv.contactID = paramCursor.getInt(paramCursor.getColumnIndex("contactID"));
      paramawbv.faceUrl = paramCursor.getString(paramCursor.getColumnIndex("faceUrl"));
      paramawbv.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramawbv.pinyinAll = paramCursor.getString(paramCursor.getColumnIndex("pinyinAll"));
      paramawbv.pinyinInitial = paramCursor.getString(paramCursor.getColumnIndex("pinyinInitial"));
      paramawbv.lastScanTime = paramCursor.getLong(paramCursor.getColumnIndex("lastScanTime"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isUploaded")))
      {
        paramBoolean = true;
        paramawbv.isUploaded = paramBoolean;
        paramawbv.sortWeight = paramCursor.getInt(paramCursor.getColumnIndex("sortWeight"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSendAddReq"))) {
          break label737;
        }
        paramBoolean = true;
        label385:
        paramawbv.hasSendAddReq = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isNewRecommend"))) {
          break label742;
        }
        paramBoolean = true;
        label410:
        paramawbv.isNewRecommend = paramBoolean;
        paramawbv.highLightTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("highLightTimeStamp"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isHiden"))) {
          break label747;
        }
      }
      label737:
      label742:
      label747:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramawbv.isHiden = paramBoolean;
        paramawbv.md5 = paramCursor.getString(paramCursor.getColumnIndex("md5"));
        paramawbv.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
        paramawbv.label = paramCursor.getString(paramCursor.getColumnIndex("label"));
        paramawbv.detalStatusFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("detalStatusFlag")));
        paramawbv.iTermType = paramCursor.getInt(paramCursor.getColumnIndex("iTermType"));
        paramawbv.eNetworkType = paramCursor.getInt(paramCursor.getColumnIndex("eNetworkType"));
        paramawbv.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
        paramawbv.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
        paramawbv.sex = paramCursor.getInt(paramCursor.getColumnIndex("sex"));
        paramawbv.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
        paramawbv.samFriend = paramCursor.getInt(paramCursor.getColumnIndex("samFriend"));
        paramawbv.abilityBits = paramCursor.getLong(paramCursor.getColumnIndex("abilityBits"));
        paramawbv.strTermDesc = paramCursor.getString(paramCursor.getColumnIndex("strTermDesc"));
        paramawbv.netTypeIconIdIphoneOrWphoneNoWifi = paramCursor.getInt(paramCursor.getColumnIndex("netTypeIconIdIphoneOrWphoneNoWifi"));
        paramawbv.netTypeIconId = paramCursor.getInt(paramCursor.getColumnIndex("netTypeIconId"));
        return paramawbv;
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
      paramawcg.a(new NoColumnError("mobileNo", String.class));
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label2084;
      }
      paramawcg.a(new NoColumnError("uin", String.class));
      label820:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label2099;
      }
      paramawcg.a(new NoColumnError("name", String.class));
      label854:
      i = paramCursor.getColumnIndex("bindingDate");
      if (i != -1) {
        break label2114;
      }
      paramawcg.a(new NoColumnError("bindingDate", Long.TYPE));
      label889:
      i = paramCursor.getColumnIndex("isRecommend");
      if (i != -1) {
        break label2129;
      }
      paramawcg.a(new NoColumnError("isRecommend", Integer.TYPE));
      label924:
      i = paramCursor.getColumnIndex("nationCode");
      if (i != -1) {
        break label2144;
      }
      paramawcg.a(new NoColumnError("nationCode", String.class));
      label958:
      i = paramCursor.getColumnIndex("mobileCode");
      if (i != -1) {
        break label2159;
      }
      paramawcg.a(new NoColumnError("mobileCode", String.class));
      label992:
      i = paramCursor.getColumnIndex("unifiedCode");
      if (i != -1) {
        break label2174;
      }
      paramawcg.a(new NoColumnError("unifiedCode", String.class));
      label1026:
      i = paramCursor.getColumnIndex("nickName");
      if (i != -1) {
        break label2189;
      }
      paramawcg.a(new NoColumnError("nickName", String.class));
      label1060:
      i = paramCursor.getColumnIndex("originBinder");
      if (i != -1) {
        break label2204;
      }
      paramawcg.a(new NoColumnError("originBinder", Long.TYPE));
      label1095:
      i = paramCursor.getColumnIndex("ability");
      if (i != -1) {
        break label2219;
      }
      paramawcg.a(new NoColumnError("ability", Integer.TYPE));
      label1130:
      i = paramCursor.getColumnIndex("contactID");
      if (i != -1) {
        break label2234;
      }
      paramawcg.a(new NoColumnError("contactID", Integer.TYPE));
      label1165:
      i = paramCursor.getColumnIndex("faceUrl");
      if (i != -1) {
        break label2249;
      }
      paramawcg.a(new NoColumnError("faceUrl", String.class));
      label1199:
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label2264;
      }
      paramawcg.a(new NoColumnError("remark", String.class));
      label1233:
      i = paramCursor.getColumnIndex("pinyinAll");
      if (i != -1) {
        break label2279;
      }
      paramawcg.a(new NoColumnError("pinyinAll", String.class));
      label1267:
      i = paramCursor.getColumnIndex("pinyinInitial");
      if (i != -1) {
        break label2294;
      }
      paramawcg.a(new NoColumnError("pinyinInitial", String.class));
      label1301:
      i = paramCursor.getColumnIndex("lastScanTime");
      if (i != -1) {
        break label2309;
      }
      paramawcg.a(new NoColumnError("lastScanTime", Long.TYPE));
      label1336:
      i = paramCursor.getColumnIndex("isUploaded");
      if (i != -1) {
        break label2324;
      }
      paramawcg.a(new NoColumnError("isUploaded", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sortWeight");
      if (i != -1) {
        break label2351;
      }
      paramawcg.a(new NoColumnError("sortWeight", Integer.TYPE));
      label1406:
      i = paramCursor.getColumnIndex("hasSendAddReq");
      if (i != -1) {
        break label2366;
      }
      paramawcg.a(new NoColumnError("hasSendAddReq", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isNewRecommend");
      if (i != -1) {
        break label2393;
      }
      paramawcg.a(new NoColumnError("isNewRecommend", Boolean.TYPE));
      i = paramCursor.getColumnIndex("highLightTimeStamp");
      if (i != -1) {
        break label2420;
      }
      paramawcg.a(new NoColumnError("highLightTimeStamp", Long.TYPE));
      label1511:
      i = paramCursor.getColumnIndex("isHiden");
      if (i != -1) {
        break label2435;
      }
      paramawcg.a(new NoColumnError("isHiden", Boolean.TYPE));
      i = paramCursor.getColumnIndex("md5");
      if (i != -1) {
        break label2463;
      }
      paramawcg.a(new NoColumnError("md5", String.class));
      label1580:
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label2478;
      }
      paramawcg.a(new NoColumnError("type", Integer.TYPE));
      label1615:
      i = paramCursor.getColumnIndex("label");
      if (i != -1) {
        break label2493;
      }
      paramawcg.a(new NoColumnError("label", String.class));
      label1649:
      i = paramCursor.getColumnIndex("detalStatusFlag");
      if (i != -1) {
        break label2508;
      }
      paramawcg.a(new NoColumnError("detalStatusFlag", Byte.TYPE));
      label1684:
      i = paramCursor.getColumnIndex("iTermType");
      if (i != -1) {
        break label2524;
      }
      paramawcg.a(new NoColumnError("iTermType", Integer.TYPE));
      label1719:
      i = paramCursor.getColumnIndex("eNetworkType");
      if (i != -1) {
        break label2539;
      }
      paramawcg.a(new NoColumnError("eNetworkType", Integer.TYPE));
      label1754:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label2554;
      }
      paramawcg.a(new NoColumnError("richTime", Long.TYPE));
      label1789:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label2569;
      }
      paramawcg.a(new NoColumnError("richBuffer", [B.class));
      label1823:
      i = paramCursor.getColumnIndex("sex");
      if (i != -1) {
        break label2584;
      }
      paramawcg.a(new NoColumnError("sex", Integer.TYPE));
      label1858:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label2599;
      }
      paramawcg.a(new NoColumnError("age", Integer.TYPE));
      label1893:
      i = paramCursor.getColumnIndex("samFriend");
      if (i != -1) {
        break label2614;
      }
      paramawcg.a(new NoColumnError("samFriend", Integer.TYPE));
      label1928:
      i = paramCursor.getColumnIndex("abilityBits");
      if (i != -1) {
        break label2629;
      }
      paramawcg.a(new NoColumnError("abilityBits", Long.TYPE));
      label1963:
      i = paramCursor.getColumnIndex("strTermDesc");
      if (i != -1) {
        break label2644;
      }
      paramawcg.a(new NoColumnError("strTermDesc", String.class));
      label1997:
      i = paramCursor.getColumnIndex("netTypeIconIdIphoneOrWphoneNoWifi");
      if (i != -1) {
        break label2659;
      }
      paramawcg.a(new NoColumnError("netTypeIconIdIphoneOrWphoneNoWifi", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("netTypeIconId");
      if (i != -1) {
        break label2674;
      }
      paramawcg.a(new NoColumnError("netTypeIconId", Integer.TYPE));
      return paramawbv;
      paramawbv.mobileNo = paramCursor.getString(i);
      break;
      label2084:
      paramawbv.uin = paramCursor.getString(i);
      break label820;
      label2099:
      paramawbv.name = paramCursor.getString(i);
      break label854;
      label2114:
      paramawbv.bindingDate = paramCursor.getLong(i);
      break label889;
      label2129:
      paramawbv.isRecommend = paramCursor.getInt(i);
      break label924;
      label2144:
      paramawbv.nationCode = paramCursor.getString(i);
      break label958;
      label2159:
      paramawbv.mobileCode = paramCursor.getString(i);
      break label992;
      label2174:
      paramawbv.unifiedCode = paramCursor.getString(i);
      break label1026;
      label2189:
      paramawbv.nickName = paramCursor.getString(i);
      break label1060;
      label2204:
      paramawbv.originBinder = paramCursor.getLong(i);
      break label1095;
      label2219:
      paramawbv.ability = paramCursor.getInt(i);
      break label1130;
      label2234:
      paramawbv.contactID = paramCursor.getInt(i);
      break label1165;
      label2249:
      paramawbv.faceUrl = paramCursor.getString(i);
      break label1199;
      label2264:
      paramawbv.remark = paramCursor.getString(i);
      break label1233;
      label2279:
      paramawbv.pinyinAll = paramCursor.getString(i);
      break label1267;
      label2294:
      paramawbv.pinyinInitial = paramCursor.getString(i);
      break label1301;
      label2309:
      paramawbv.lastScanTime = paramCursor.getLong(i);
      break label1336;
      label2324:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isUploaded = paramBoolean;
        break;
      }
      label2351:
      paramawbv.sortWeight = paramCursor.getInt(i);
      break label1406;
      label2366:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.hasSendAddReq = paramBoolean;
        break;
      }
      label2393:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isNewRecommend = paramBoolean;
        break;
      }
      label2420:
      paramawbv.highLightTimeStamp = paramCursor.getLong(i);
      break label1511;
      label2435:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramawbv.isHiden = paramBoolean;
        break;
      }
      label2463:
      paramawbv.md5 = paramCursor.getString(i);
      break label1580;
      label2478:
      paramawbv.type = paramCursor.getInt(i);
      break label1615;
      label2493:
      paramawbv.label = paramCursor.getString(i);
      break label1649;
      label2508:
      paramawbv.detalStatusFlag = ((byte)paramCursor.getShort(i));
      break label1684;
      label2524:
      paramawbv.iTermType = paramCursor.getInt(i);
      break label1719;
      label2539:
      paramawbv.eNetworkType = paramCursor.getInt(i);
      break label1754;
      label2554:
      paramawbv.richTime = paramCursor.getLong(i);
      break label1789;
      label2569:
      paramawbv.richBuffer = paramCursor.getBlob(i);
      break label1823;
      label2584:
      paramawbv.sex = paramCursor.getInt(i);
      break label1858;
      label2599:
      paramawbv.age = paramCursor.getInt(i);
      break label1893;
      label2614:
      paramawbv.samFriend = paramCursor.getInt(i);
      break label1928;
      label2629:
      paramawbv.abilityBits = paramCursor.getLong(i);
      break label1963;
      label2644:
      paramawbv.strTermDesc = paramCursor.getString(i);
      break label1997;
      label2659:
      paramawbv.netTypeIconIdIphoneOrWphoneNoWifi = paramCursor.getInt(i);
    }
    label2674:
    paramawbv.netTypeIconId = paramCursor.getInt(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,mobileNo TEXT UNIQUE ,uin TEXT ,name TEXT ,bindingDate INTEGER ,isRecommend INTEGER ,nationCode TEXT ,mobileCode TEXT ,unifiedCode TEXT ,nickName TEXT ,originBinder INTEGER ,ability INTEGER ,contactID INTEGER ,faceUrl TEXT ,remark TEXT ,pinyinAll TEXT ,pinyinInitial TEXT ,lastScanTime INTEGER ,isUploaded INTEGER ,sortWeight INTEGER ,hasSendAddReq INTEGER ,isNewRecommend INTEGER ,highLightTimeStamp INTEGER ,isHiden INTEGER ,md5 TEXT ,type INTEGER ,label TEXT ,detalStatusFlag INTEGER ,iTermType INTEGER ,eNetworkType INTEGER ,richTime INTEGER ,richBuffer BLOB ,sex INTEGER ,age INTEGER ,samFriend INTEGER ,abilityBits INTEGER ,strTermDesc TEXT ,netTypeIconIdIphoneOrWphoneNoWifi INTEGER ,netTypeIconId INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (PhoneContact)paramawbv;
    paramContentValues.put("mobileNo", paramawbv.mobileNo);
    paramContentValues.put("uin", paramawbv.uin);
    paramContentValues.put("name", paramawbv.name);
    paramContentValues.put("bindingDate", Long.valueOf(paramawbv.bindingDate));
    paramContentValues.put("isRecommend", Integer.valueOf(paramawbv.isRecommend));
    paramContentValues.put("nationCode", paramawbv.nationCode);
    paramContentValues.put("mobileCode", paramawbv.mobileCode);
    paramContentValues.put("unifiedCode", paramawbv.unifiedCode);
    paramContentValues.put("nickName", paramawbv.nickName);
    paramContentValues.put("originBinder", Long.valueOf(paramawbv.originBinder));
    paramContentValues.put("ability", Integer.valueOf(paramawbv.ability));
    paramContentValues.put("contactID", Integer.valueOf(paramawbv.contactID));
    paramContentValues.put("faceUrl", paramawbv.faceUrl);
    paramContentValues.put("remark", paramawbv.remark);
    paramContentValues.put("pinyinAll", paramawbv.pinyinAll);
    paramContentValues.put("pinyinInitial", paramawbv.pinyinInitial);
    paramContentValues.put("lastScanTime", Long.valueOf(paramawbv.lastScanTime));
    paramContentValues.put("isUploaded", Boolean.valueOf(paramawbv.isUploaded));
    paramContentValues.put("sortWeight", Integer.valueOf(paramawbv.sortWeight));
    paramContentValues.put("hasSendAddReq", Boolean.valueOf(paramawbv.hasSendAddReq));
    paramContentValues.put("isNewRecommend", Boolean.valueOf(paramawbv.isNewRecommend));
    paramContentValues.put("highLightTimeStamp", Long.valueOf(paramawbv.highLightTimeStamp));
    paramContentValues.put("isHiden", Boolean.valueOf(paramawbv.isHiden));
    paramContentValues.put("md5", paramawbv.md5);
    paramContentValues.put("type", Integer.valueOf(paramawbv.type));
    paramContentValues.put("label", paramawbv.label);
    paramContentValues.put("detalStatusFlag", Byte.valueOf(paramawbv.detalStatusFlag));
    paramContentValues.put("iTermType", Integer.valueOf(paramawbv.iTermType));
    paramContentValues.put("eNetworkType", Integer.valueOf(paramawbv.eNetworkType));
    paramContentValues.put("richTime", Long.valueOf(paramawbv.richTime));
    paramContentValues.put("richBuffer", paramawbv.richBuffer);
    paramContentValues.put("sex", Integer.valueOf(paramawbv.sex));
    paramContentValues.put("age", Integer.valueOf(paramawbv.age));
    paramContentValues.put("samFriend", Integer.valueOf(paramawbv.samFriend));
    paramContentValues.put("abilityBits", Long.valueOf(paramawbv.abilityBits));
    paramContentValues.put("strTermDesc", paramawbv.strTermDesc);
    paramContentValues.put("netTypeIconIdIphoneOrWphoneNoWifi", Integer.valueOf(paramawbv.netTypeIconIdIphoneOrWphoneNoWifi));
    paramContentValues.put("netTypeIconId", Integer.valueOf(paramawbv.netTypeIconId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awck
 * JD-Core Version:    0.7.0.1
 */