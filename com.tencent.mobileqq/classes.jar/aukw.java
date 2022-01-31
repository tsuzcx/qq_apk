import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukw
  extends aula
{
  public aukw()
  {
    this.a = 38;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramauko = (HotChatInfo)paramauko;
    if (paramaukz == null)
    {
      paramauko.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramauko.troopCode = paramCursor.getString(paramCursor.getColumnIndex("troopCode"));
      paramauko.signature = paramCursor.getString(paramCursor.getColumnIndex("signature"));
      paramauko.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramauko.faceId = paramCursor.getInt(paramCursor.getColumnIndex("faceId"));
      paramauko.memberCount = paramCursor.getInt(paramCursor.getColumnIndex("memberCount"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasJoined")))
      {
        paramBoolean = true;
        paramauko.hasJoined = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isWifiHotChat"))) {
          break label764;
        }
        paramBoolean = true;
        label169:
        paramauko.isWifiHotChat = paramBoolean;
        paramauko.uuid = paramCursor.getString(paramCursor.getColumnIndex("uuid"));
        paramauko.iconUrl = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
        paramauko.hotThemeGroupFlag = paramCursor.getInt(paramCursor.getColumnIndex("hotThemeGroupFlag"));
        paramauko.detail = paramCursor.getString(paramCursor.getColumnIndex("detail"));
        paramauko.state = paramCursor.getInt(paramCursor.getColumnIndex("state"));
        paramauko.leftTime = paramCursor.getLong(paramCursor.getColumnIndex("leftTime"));
        paramauko.ruState = paramCursor.getInt(paramCursor.getColumnIndex("ruState"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("supportFlashPic"))) {
          break label769;
        }
        paramBoolean = true;
        label320:
        paramauko.supportFlashPic = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("supportDemo"))) {
          break label774;
        }
        paramBoolean = true;
        label345:
        paramauko.supportDemo = paramBoolean;
        paramauko.adminLevel = paramCursor.getInt(paramCursor.getColumnIndex("adminLevel"));
        paramauko.joinUrl = paramCursor.getString(paramCursor.getColumnIndex("joinUrl"));
        paramauko.hotChatType = paramCursor.getInt(paramCursor.getColumnIndex("hotChatType"));
        paramauko.memo = paramCursor.getString(paramCursor.getColumnIndex("memo"));
        paramauko.memoUrl = paramCursor.getString(paramCursor.getColumnIndex("memoUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("memoShowed"))) {
          break label779;
        }
        paramBoolean = true;
        label460:
        paramauko.memoShowed = paramBoolean;
        paramauko.userCreate = paramCursor.getInt(paramCursor.getColumnIndex("userCreate"));
        paramauko.strAdminUins = paramCursor.getString(paramCursor.getColumnIndex("strAdminUins"));
        paramauko.ownerUin = paramCursor.getString(paramCursor.getColumnIndex("ownerUin"));
        paramauko.pkFlag = paramCursor.getInt(paramCursor.getColumnIndex("pkFlag"));
        paramauko.subType = paramCursor.getInt(paramCursor.getColumnIndex("subType"));
        paramauko.lLastMsgSeq = paramCursor.getLong(paramCursor.getColumnIndex("lLastMsgSeq"));
        paramauko.extra1 = paramCursor.getString(paramCursor.getColumnIndex("extra1"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isFavorite"))) {
          break label784;
        }
        paramBoolean = true;
        label611:
        paramauko.isFavorite = paramBoolean;
        paramauko.mFissionRoomNum = paramCursor.getInt(paramCursor.getColumnIndex("mFissionRoomNum"));
        paramauko.praiseCount = paramCursor.getLong(paramCursor.getColumnIndex("praiseCount"));
        paramauko.uint32_group_flag_ext2 = paramCursor.getInt(paramCursor.getColumnIndex("uint32_group_flag_ext2"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isGameRoom"))) {
          break label789;
        }
        paramBoolean = true;
        label690:
        paramauko.isGameRoom = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRobotHotChat"))) {
          break label794;
        }
      }
      label769:
      label774:
      label779:
      label784:
      label789:
      label794:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramauko.isRobotHotChat = paramBoolean;
        paramauko.robotUin = paramCursor.getLong(paramCursor.getColumnIndex("robotUin"));
        paramauko.apolloGameId = paramCursor.getInt(paramCursor.getColumnIndex("apolloGameId"));
        return paramauko;
        paramBoolean = false;
        break;
        label764:
        paramBoolean = false;
        break label169;
        paramBoolean = false;
        break label320;
        paramBoolean = false;
        break label345;
        paramBoolean = false;
        break label460;
        paramBoolean = false;
        break label611;
        paramBoolean = false;
        break label690;
      }
    }
    int i = paramCursor.getColumnIndex("name");
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("name", String.class));
      i = paramCursor.getColumnIndex("troopCode");
      if (i != -1) {
        break label2133;
      }
      paramaukz.a(new NoColumnError("troopCode", String.class));
      label867:
      i = paramCursor.getColumnIndex("signature");
      if (i != -1) {
        break label2148;
      }
      paramaukz.a(new NoColumnError("signature", String.class));
      label901:
      i = paramCursor.getColumnIndex("troopUin");
      if (i != -1) {
        break label2163;
      }
      paramaukz.a(new NoColumnError("troopUin", String.class));
      label935:
      i = paramCursor.getColumnIndex("faceId");
      if (i != -1) {
        break label2178;
      }
      paramaukz.a(new NoColumnError("faceId", Integer.TYPE));
      label970:
      i = paramCursor.getColumnIndex("memberCount");
      if (i != -1) {
        break label2193;
      }
      paramaukz.a(new NoColumnError("memberCount", Integer.TYPE));
      label1005:
      i = paramCursor.getColumnIndex("hasJoined");
      if (i != -1) {
        break label2208;
      }
      paramaukz.a(new NoColumnError("hasJoined", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isWifiHotChat");
      if (i != -1) {
        break label2235;
      }
      paramaukz.a(new NoColumnError("isWifiHotChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("uuid");
      if (i != -1) {
        break label2262;
      }
      paramaukz.a(new NoColumnError("uuid", String.class));
      label1109:
      i = paramCursor.getColumnIndex("iconUrl");
      if (i != -1) {
        break label2277;
      }
      paramaukz.a(new NoColumnError("iconUrl", String.class));
      label1143:
      i = paramCursor.getColumnIndex("hotThemeGroupFlag");
      if (i != -1) {
        break label2292;
      }
      paramaukz.a(new NoColumnError("hotThemeGroupFlag", Integer.TYPE));
      label1178:
      i = paramCursor.getColumnIndex("detail");
      if (i != -1) {
        break label2307;
      }
      paramaukz.a(new NoColumnError("detail", String.class));
      label1212:
      i = paramCursor.getColumnIndex("state");
      if (i != -1) {
        break label2322;
      }
      paramaukz.a(new NoColumnError("state", Integer.TYPE));
      label1247:
      i = paramCursor.getColumnIndex("leftTime");
      if (i != -1) {
        break label2337;
      }
      paramaukz.a(new NoColumnError("leftTime", Long.TYPE));
      label1282:
      i = paramCursor.getColumnIndex("ruState");
      if (i != -1) {
        break label2352;
      }
      paramaukz.a(new NoColumnError("ruState", Integer.TYPE));
      label1317:
      i = paramCursor.getColumnIndex("supportFlashPic");
      if (i != -1) {
        break label2367;
      }
      paramaukz.a(new NoColumnError("supportFlashPic", Boolean.TYPE));
      i = paramCursor.getColumnIndex("supportDemo");
      if (i != -1) {
        break label2394;
      }
      paramaukz.a(new NoColumnError("supportDemo", Boolean.TYPE));
      i = paramCursor.getColumnIndex("adminLevel");
      if (i != -1) {
        break label2421;
      }
      paramaukz.a(new NoColumnError("adminLevel", Integer.TYPE));
      label1422:
      i = paramCursor.getColumnIndex("joinUrl");
      if (i != -1) {
        break label2436;
      }
      paramaukz.a(new NoColumnError("joinUrl", String.class));
      label1456:
      i = paramCursor.getColumnIndex("hotChatType");
      if (i != -1) {
        break label2451;
      }
      paramaukz.a(new NoColumnError("hotChatType", Integer.TYPE));
      label1491:
      i = paramCursor.getColumnIndex("memo");
      if (i != -1) {
        break label2466;
      }
      paramaukz.a(new NoColumnError("memo", String.class));
      label1525:
      i = paramCursor.getColumnIndex("memoUrl");
      if (i != -1) {
        break label2481;
      }
      paramaukz.a(new NoColumnError("memoUrl", String.class));
      label1559:
      i = paramCursor.getColumnIndex("memoShowed");
      if (i != -1) {
        break label2496;
      }
      paramaukz.a(new NoColumnError("memoShowed", Boolean.TYPE));
      i = paramCursor.getColumnIndex("userCreate");
      if (i != -1) {
        break label2523;
      }
      paramaukz.a(new NoColumnError("userCreate", Integer.TYPE));
      label1629:
      i = paramCursor.getColumnIndex("strAdminUins");
      if (i != -1) {
        break label2538;
      }
      paramaukz.a(new NoColumnError("strAdminUins", String.class));
      label1663:
      i = paramCursor.getColumnIndex("ownerUin");
      if (i != -1) {
        break label2553;
      }
      paramaukz.a(new NoColumnError("ownerUin", String.class));
      label1697:
      i = paramCursor.getColumnIndex("pkFlag");
      if (i != -1) {
        break label2568;
      }
      paramaukz.a(new NoColumnError("pkFlag", Integer.TYPE));
      label1732:
      i = paramCursor.getColumnIndex("subType");
      if (i != -1) {
        break label2583;
      }
      paramaukz.a(new NoColumnError("subType", Integer.TYPE));
      label1767:
      i = paramCursor.getColumnIndex("lLastMsgSeq");
      if (i != -1) {
        break label2598;
      }
      paramaukz.a(new NoColumnError("lLastMsgSeq", Long.TYPE));
      label1802:
      i = paramCursor.getColumnIndex("extra1");
      if (i != -1) {
        break label2613;
      }
      paramaukz.a(new NoColumnError("extra1", String.class));
      label1836:
      i = paramCursor.getColumnIndex("isFavorite");
      if (i != -1) {
        break label2628;
      }
      paramaukz.a(new NoColumnError("isFavorite", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mFissionRoomNum");
      if (i != -1) {
        break label2655;
      }
      paramaukz.a(new NoColumnError("mFissionRoomNum", Integer.TYPE));
      label1906:
      i = paramCursor.getColumnIndex("praiseCount");
      if (i != -1) {
        break label2670;
      }
      paramaukz.a(new NoColumnError("praiseCount", Long.TYPE));
      label1941:
      i = paramCursor.getColumnIndex("uint32_group_flag_ext2");
      if (i != -1) {
        break label2685;
      }
      paramaukz.a(new NoColumnError("uint32_group_flag_ext2", Integer.TYPE));
      label1976:
      i = paramCursor.getColumnIndex("isGameRoom");
      if (i != -1) {
        break label2700;
      }
      paramaukz.a(new NoColumnError("isGameRoom", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRobotHotChat");
      if (i != -1) {
        break label2727;
      }
      paramaukz.a(new NoColumnError("isRobotHotChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("robotUin");
      if (i != -1) {
        break label2755;
      }
      paramaukz.a(new NoColumnError("robotUin", Long.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("apolloGameId");
      if (i != -1) {
        break label2770;
      }
      paramaukz.a(new NoColumnError("apolloGameId", Integer.TYPE));
      return paramauko;
      paramauko.name = paramCursor.getString(i);
      break;
      label2133:
      paramauko.troopCode = paramCursor.getString(i);
      break label867;
      label2148:
      paramauko.signature = paramCursor.getString(i);
      break label901;
      label2163:
      paramauko.troopUin = paramCursor.getString(i);
      break label935;
      label2178:
      paramauko.faceId = paramCursor.getInt(i);
      break label970;
      label2193:
      paramauko.memberCount = paramCursor.getInt(i);
      break label1005;
      label2208:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.hasJoined = paramBoolean;
        break;
      }
      label2235:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isWifiHotChat = paramBoolean;
        break;
      }
      label2262:
      paramauko.uuid = paramCursor.getString(i);
      break label1109;
      label2277:
      paramauko.iconUrl = paramCursor.getString(i);
      break label1143;
      label2292:
      paramauko.hotThemeGroupFlag = paramCursor.getInt(i);
      break label1178;
      label2307:
      paramauko.detail = paramCursor.getString(i);
      break label1212;
      label2322:
      paramauko.state = paramCursor.getInt(i);
      break label1247;
      label2337:
      paramauko.leftTime = paramCursor.getLong(i);
      break label1282;
      label2352:
      paramauko.ruState = paramCursor.getInt(i);
      break label1317;
      label2367:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.supportFlashPic = paramBoolean;
        break;
      }
      label2394:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.supportDemo = paramBoolean;
        break;
      }
      label2421:
      paramauko.adminLevel = paramCursor.getInt(i);
      break label1422;
      label2436:
      paramauko.joinUrl = paramCursor.getString(i);
      break label1456;
      label2451:
      paramauko.hotChatType = paramCursor.getInt(i);
      break label1491;
      label2466:
      paramauko.memo = paramCursor.getString(i);
      break label1525;
      label2481:
      paramauko.memoUrl = paramCursor.getString(i);
      break label1559;
      label2496:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.memoShowed = paramBoolean;
        break;
      }
      label2523:
      paramauko.userCreate = paramCursor.getInt(i);
      break label1629;
      label2538:
      paramauko.strAdminUins = paramCursor.getString(i);
      break label1663;
      label2553:
      paramauko.ownerUin = paramCursor.getString(i);
      break label1697;
      label2568:
      paramauko.pkFlag = paramCursor.getInt(i);
      break label1732;
      label2583:
      paramauko.subType = paramCursor.getInt(i);
      break label1767;
      label2598:
      paramauko.lLastMsgSeq = paramCursor.getLong(i);
      break label1802;
      label2613:
      paramauko.extra1 = paramCursor.getString(i);
      break label1836;
      label2628:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isFavorite = paramBoolean;
        break;
      }
      label2655:
      paramauko.mFissionRoomNum = paramCursor.getInt(i);
      break label1906;
      label2670:
      paramauko.praiseCount = paramCursor.getLong(i);
      break label1941;
      label2685:
      paramauko.uint32_group_flag_ext2 = paramCursor.getInt(i);
      break label1976;
      label2700:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isGameRoom = paramBoolean;
        break;
      }
      label2727:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramauko.isRobotHotChat = paramBoolean;
        break;
      }
      label2755:
      paramauko.robotUin = paramCursor.getLong(i);
    }
    label2770:
    paramauko.apolloGameId = paramCursor.getInt(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,name TEXT ,troopCode TEXT ,signature TEXT ,troopUin TEXT UNIQUE ,faceId INTEGER ,memberCount INTEGER ,hasJoined INTEGER ,isWifiHotChat INTEGER ,uuid TEXT ,iconUrl TEXT ,hotThemeGroupFlag INTEGER ,detail TEXT ,state INTEGER ,leftTime INTEGER ,ruState INTEGER ,supportFlashPic INTEGER ,supportDemo INTEGER ,adminLevel INTEGER ,joinUrl TEXT ,hotChatType INTEGER ,memo TEXT ,memoUrl TEXT ,memoShowed INTEGER ,userCreate INTEGER ,strAdminUins TEXT ,ownerUin TEXT ,pkFlag INTEGER ,subType INTEGER ,lLastMsgSeq INTEGER ,extra1 TEXT ,isFavorite INTEGER ,mFissionRoomNum INTEGER ,praiseCount INTEGER ,uint32_group_flag_ext2 INTEGER ,isGameRoom INTEGER ,isRobotHotChat INTEGER ,robotUin INTEGER ,apolloGameId INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (HotChatInfo)paramauko;
    paramContentValues.put("name", paramauko.name);
    paramContentValues.put("troopCode", paramauko.troopCode);
    paramContentValues.put("signature", paramauko.signature);
    paramContentValues.put("troopUin", paramauko.troopUin);
    paramContentValues.put("faceId", Integer.valueOf(paramauko.faceId));
    paramContentValues.put("memberCount", Integer.valueOf(paramauko.memberCount));
    paramContentValues.put("hasJoined", Boolean.valueOf(paramauko.hasJoined));
    paramContentValues.put("isWifiHotChat", Boolean.valueOf(paramauko.isWifiHotChat));
    paramContentValues.put("uuid", paramauko.uuid);
    paramContentValues.put("iconUrl", paramauko.iconUrl);
    paramContentValues.put("hotThemeGroupFlag", Integer.valueOf(paramauko.hotThemeGroupFlag));
    paramContentValues.put("detail", paramauko.detail);
    paramContentValues.put("state", Integer.valueOf(paramauko.state));
    paramContentValues.put("leftTime", Long.valueOf(paramauko.leftTime));
    paramContentValues.put("ruState", Integer.valueOf(paramauko.ruState));
    paramContentValues.put("supportFlashPic", Boolean.valueOf(paramauko.supportFlashPic));
    paramContentValues.put("supportDemo", Boolean.valueOf(paramauko.supportDemo));
    paramContentValues.put("adminLevel", Integer.valueOf(paramauko.adminLevel));
    paramContentValues.put("joinUrl", paramauko.joinUrl);
    paramContentValues.put("hotChatType", Integer.valueOf(paramauko.hotChatType));
    paramContentValues.put("memo", paramauko.memo);
    paramContentValues.put("memoUrl", paramauko.memoUrl);
    paramContentValues.put("memoShowed", Boolean.valueOf(paramauko.memoShowed));
    paramContentValues.put("userCreate", Integer.valueOf(paramauko.userCreate));
    paramContentValues.put("strAdminUins", paramauko.strAdminUins);
    paramContentValues.put("ownerUin", paramauko.ownerUin);
    paramContentValues.put("pkFlag", Integer.valueOf(paramauko.pkFlag));
    paramContentValues.put("subType", Integer.valueOf(paramauko.subType));
    paramContentValues.put("lLastMsgSeq", Long.valueOf(paramauko.lLastMsgSeq));
    paramContentValues.put("extra1", paramauko.extra1);
    paramContentValues.put("isFavorite", Boolean.valueOf(paramauko.isFavorite));
    paramContentValues.put("mFissionRoomNum", Integer.valueOf(paramauko.mFissionRoomNum));
    paramContentValues.put("praiseCount", Long.valueOf(paramauko.praiseCount));
    paramContentValues.put("uint32_group_flag_ext2", Integer.valueOf(paramauko.uint32_group_flag_ext2));
    paramContentValues.put("isGameRoom", Boolean.valueOf(paramauko.isGameRoom));
    paramContentValues.put("isRobotHotChat", Boolean.valueOf(paramauko.isRobotHotChat));
    paramContentValues.put("robotUin", Long.valueOf(paramauko.robotUin));
    paramContentValues.put("apolloGameId", Integer.valueOf(paramauko.apolloGameId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukw
 * JD-Core Version:    0.7.0.1
 */