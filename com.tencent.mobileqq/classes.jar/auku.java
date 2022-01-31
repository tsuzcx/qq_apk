import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class auku
  extends auky
{
  public auku()
  {
    this.a = 38;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramaukm = (HotChatInfo)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramaukm.troopCode = paramCursor.getString(paramCursor.getColumnIndex("troopCode"));
      paramaukm.signature = paramCursor.getString(paramCursor.getColumnIndex("signature"));
      paramaukm.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramaukm.faceId = paramCursor.getInt(paramCursor.getColumnIndex("faceId"));
      paramaukm.memberCount = paramCursor.getInt(paramCursor.getColumnIndex("memberCount"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasJoined")))
      {
        paramBoolean = true;
        paramaukm.hasJoined = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isWifiHotChat"))) {
          break label764;
        }
        paramBoolean = true;
        label169:
        paramaukm.isWifiHotChat = paramBoolean;
        paramaukm.uuid = paramCursor.getString(paramCursor.getColumnIndex("uuid"));
        paramaukm.iconUrl = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
        paramaukm.hotThemeGroupFlag = paramCursor.getInt(paramCursor.getColumnIndex("hotThemeGroupFlag"));
        paramaukm.detail = paramCursor.getString(paramCursor.getColumnIndex("detail"));
        paramaukm.state = paramCursor.getInt(paramCursor.getColumnIndex("state"));
        paramaukm.leftTime = paramCursor.getLong(paramCursor.getColumnIndex("leftTime"));
        paramaukm.ruState = paramCursor.getInt(paramCursor.getColumnIndex("ruState"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("supportFlashPic"))) {
          break label769;
        }
        paramBoolean = true;
        label320:
        paramaukm.supportFlashPic = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("supportDemo"))) {
          break label774;
        }
        paramBoolean = true;
        label345:
        paramaukm.supportDemo = paramBoolean;
        paramaukm.adminLevel = paramCursor.getInt(paramCursor.getColumnIndex("adminLevel"));
        paramaukm.joinUrl = paramCursor.getString(paramCursor.getColumnIndex("joinUrl"));
        paramaukm.hotChatType = paramCursor.getInt(paramCursor.getColumnIndex("hotChatType"));
        paramaukm.memo = paramCursor.getString(paramCursor.getColumnIndex("memo"));
        paramaukm.memoUrl = paramCursor.getString(paramCursor.getColumnIndex("memoUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("memoShowed"))) {
          break label779;
        }
        paramBoolean = true;
        label460:
        paramaukm.memoShowed = paramBoolean;
        paramaukm.userCreate = paramCursor.getInt(paramCursor.getColumnIndex("userCreate"));
        paramaukm.strAdminUins = paramCursor.getString(paramCursor.getColumnIndex("strAdminUins"));
        paramaukm.ownerUin = paramCursor.getString(paramCursor.getColumnIndex("ownerUin"));
        paramaukm.pkFlag = paramCursor.getInt(paramCursor.getColumnIndex("pkFlag"));
        paramaukm.subType = paramCursor.getInt(paramCursor.getColumnIndex("subType"));
        paramaukm.lLastMsgSeq = paramCursor.getLong(paramCursor.getColumnIndex("lLastMsgSeq"));
        paramaukm.extra1 = paramCursor.getString(paramCursor.getColumnIndex("extra1"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isFavorite"))) {
          break label784;
        }
        paramBoolean = true;
        label611:
        paramaukm.isFavorite = paramBoolean;
        paramaukm.mFissionRoomNum = paramCursor.getInt(paramCursor.getColumnIndex("mFissionRoomNum"));
        paramaukm.praiseCount = paramCursor.getLong(paramCursor.getColumnIndex("praiseCount"));
        paramaukm.uint32_group_flag_ext2 = paramCursor.getInt(paramCursor.getColumnIndex("uint32_group_flag_ext2"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isGameRoom"))) {
          break label789;
        }
        paramBoolean = true;
        label690:
        paramaukm.isGameRoom = paramBoolean;
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
        paramaukm.isRobotHotChat = paramBoolean;
        paramaukm.robotUin = paramCursor.getLong(paramCursor.getColumnIndex("robotUin"));
        paramaukm.apolloGameId = paramCursor.getInt(paramCursor.getColumnIndex("apolloGameId"));
        return paramaukm;
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
      paramaukx.a(new NoColumnError("name", String.class));
      i = paramCursor.getColumnIndex("troopCode");
      if (i != -1) {
        break label2133;
      }
      paramaukx.a(new NoColumnError("troopCode", String.class));
      label867:
      i = paramCursor.getColumnIndex("signature");
      if (i != -1) {
        break label2148;
      }
      paramaukx.a(new NoColumnError("signature", String.class));
      label901:
      i = paramCursor.getColumnIndex("troopUin");
      if (i != -1) {
        break label2163;
      }
      paramaukx.a(new NoColumnError("troopUin", String.class));
      label935:
      i = paramCursor.getColumnIndex("faceId");
      if (i != -1) {
        break label2178;
      }
      paramaukx.a(new NoColumnError("faceId", Integer.TYPE));
      label970:
      i = paramCursor.getColumnIndex("memberCount");
      if (i != -1) {
        break label2193;
      }
      paramaukx.a(new NoColumnError("memberCount", Integer.TYPE));
      label1005:
      i = paramCursor.getColumnIndex("hasJoined");
      if (i != -1) {
        break label2208;
      }
      paramaukx.a(new NoColumnError("hasJoined", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isWifiHotChat");
      if (i != -1) {
        break label2235;
      }
      paramaukx.a(new NoColumnError("isWifiHotChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("uuid");
      if (i != -1) {
        break label2262;
      }
      paramaukx.a(new NoColumnError("uuid", String.class));
      label1109:
      i = paramCursor.getColumnIndex("iconUrl");
      if (i != -1) {
        break label2277;
      }
      paramaukx.a(new NoColumnError("iconUrl", String.class));
      label1143:
      i = paramCursor.getColumnIndex("hotThemeGroupFlag");
      if (i != -1) {
        break label2292;
      }
      paramaukx.a(new NoColumnError("hotThemeGroupFlag", Integer.TYPE));
      label1178:
      i = paramCursor.getColumnIndex("detail");
      if (i != -1) {
        break label2307;
      }
      paramaukx.a(new NoColumnError("detail", String.class));
      label1212:
      i = paramCursor.getColumnIndex("state");
      if (i != -1) {
        break label2322;
      }
      paramaukx.a(new NoColumnError("state", Integer.TYPE));
      label1247:
      i = paramCursor.getColumnIndex("leftTime");
      if (i != -1) {
        break label2337;
      }
      paramaukx.a(new NoColumnError("leftTime", Long.TYPE));
      label1282:
      i = paramCursor.getColumnIndex("ruState");
      if (i != -1) {
        break label2352;
      }
      paramaukx.a(new NoColumnError("ruState", Integer.TYPE));
      label1317:
      i = paramCursor.getColumnIndex("supportFlashPic");
      if (i != -1) {
        break label2367;
      }
      paramaukx.a(new NoColumnError("supportFlashPic", Boolean.TYPE));
      i = paramCursor.getColumnIndex("supportDemo");
      if (i != -1) {
        break label2394;
      }
      paramaukx.a(new NoColumnError("supportDemo", Boolean.TYPE));
      i = paramCursor.getColumnIndex("adminLevel");
      if (i != -1) {
        break label2421;
      }
      paramaukx.a(new NoColumnError("adminLevel", Integer.TYPE));
      label1422:
      i = paramCursor.getColumnIndex("joinUrl");
      if (i != -1) {
        break label2436;
      }
      paramaukx.a(new NoColumnError("joinUrl", String.class));
      label1456:
      i = paramCursor.getColumnIndex("hotChatType");
      if (i != -1) {
        break label2451;
      }
      paramaukx.a(new NoColumnError("hotChatType", Integer.TYPE));
      label1491:
      i = paramCursor.getColumnIndex("memo");
      if (i != -1) {
        break label2466;
      }
      paramaukx.a(new NoColumnError("memo", String.class));
      label1525:
      i = paramCursor.getColumnIndex("memoUrl");
      if (i != -1) {
        break label2481;
      }
      paramaukx.a(new NoColumnError("memoUrl", String.class));
      label1559:
      i = paramCursor.getColumnIndex("memoShowed");
      if (i != -1) {
        break label2496;
      }
      paramaukx.a(new NoColumnError("memoShowed", Boolean.TYPE));
      i = paramCursor.getColumnIndex("userCreate");
      if (i != -1) {
        break label2523;
      }
      paramaukx.a(new NoColumnError("userCreate", Integer.TYPE));
      label1629:
      i = paramCursor.getColumnIndex("strAdminUins");
      if (i != -1) {
        break label2538;
      }
      paramaukx.a(new NoColumnError("strAdminUins", String.class));
      label1663:
      i = paramCursor.getColumnIndex("ownerUin");
      if (i != -1) {
        break label2553;
      }
      paramaukx.a(new NoColumnError("ownerUin", String.class));
      label1697:
      i = paramCursor.getColumnIndex("pkFlag");
      if (i != -1) {
        break label2568;
      }
      paramaukx.a(new NoColumnError("pkFlag", Integer.TYPE));
      label1732:
      i = paramCursor.getColumnIndex("subType");
      if (i != -1) {
        break label2583;
      }
      paramaukx.a(new NoColumnError("subType", Integer.TYPE));
      label1767:
      i = paramCursor.getColumnIndex("lLastMsgSeq");
      if (i != -1) {
        break label2598;
      }
      paramaukx.a(new NoColumnError("lLastMsgSeq", Long.TYPE));
      label1802:
      i = paramCursor.getColumnIndex("extra1");
      if (i != -1) {
        break label2613;
      }
      paramaukx.a(new NoColumnError("extra1", String.class));
      label1836:
      i = paramCursor.getColumnIndex("isFavorite");
      if (i != -1) {
        break label2628;
      }
      paramaukx.a(new NoColumnError("isFavorite", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mFissionRoomNum");
      if (i != -1) {
        break label2655;
      }
      paramaukx.a(new NoColumnError("mFissionRoomNum", Integer.TYPE));
      label1906:
      i = paramCursor.getColumnIndex("praiseCount");
      if (i != -1) {
        break label2670;
      }
      paramaukx.a(new NoColumnError("praiseCount", Long.TYPE));
      label1941:
      i = paramCursor.getColumnIndex("uint32_group_flag_ext2");
      if (i != -1) {
        break label2685;
      }
      paramaukx.a(new NoColumnError("uint32_group_flag_ext2", Integer.TYPE));
      label1976:
      i = paramCursor.getColumnIndex("isGameRoom");
      if (i != -1) {
        break label2700;
      }
      paramaukx.a(new NoColumnError("isGameRoom", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRobotHotChat");
      if (i != -1) {
        break label2727;
      }
      paramaukx.a(new NoColumnError("isRobotHotChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("robotUin");
      if (i != -1) {
        break label2755;
      }
      paramaukx.a(new NoColumnError("robotUin", Long.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("apolloGameId");
      if (i != -1) {
        break label2770;
      }
      paramaukx.a(new NoColumnError("apolloGameId", Integer.TYPE));
      return paramaukm;
      paramaukm.name = paramCursor.getString(i);
      break;
      label2133:
      paramaukm.troopCode = paramCursor.getString(i);
      break label867;
      label2148:
      paramaukm.signature = paramCursor.getString(i);
      break label901;
      label2163:
      paramaukm.troopUin = paramCursor.getString(i);
      break label935;
      label2178:
      paramaukm.faceId = paramCursor.getInt(i);
      break label970;
      label2193:
      paramaukm.memberCount = paramCursor.getInt(i);
      break label1005;
      label2208:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.hasJoined = paramBoolean;
        break;
      }
      label2235:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isWifiHotChat = paramBoolean;
        break;
      }
      label2262:
      paramaukm.uuid = paramCursor.getString(i);
      break label1109;
      label2277:
      paramaukm.iconUrl = paramCursor.getString(i);
      break label1143;
      label2292:
      paramaukm.hotThemeGroupFlag = paramCursor.getInt(i);
      break label1178;
      label2307:
      paramaukm.detail = paramCursor.getString(i);
      break label1212;
      label2322:
      paramaukm.state = paramCursor.getInt(i);
      break label1247;
      label2337:
      paramaukm.leftTime = paramCursor.getLong(i);
      break label1282;
      label2352:
      paramaukm.ruState = paramCursor.getInt(i);
      break label1317;
      label2367:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.supportFlashPic = paramBoolean;
        break;
      }
      label2394:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.supportDemo = paramBoolean;
        break;
      }
      label2421:
      paramaukm.adminLevel = paramCursor.getInt(i);
      break label1422;
      label2436:
      paramaukm.joinUrl = paramCursor.getString(i);
      break label1456;
      label2451:
      paramaukm.hotChatType = paramCursor.getInt(i);
      break label1491;
      label2466:
      paramaukm.memo = paramCursor.getString(i);
      break label1525;
      label2481:
      paramaukm.memoUrl = paramCursor.getString(i);
      break label1559;
      label2496:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.memoShowed = paramBoolean;
        break;
      }
      label2523:
      paramaukm.userCreate = paramCursor.getInt(i);
      break label1629;
      label2538:
      paramaukm.strAdminUins = paramCursor.getString(i);
      break label1663;
      label2553:
      paramaukm.ownerUin = paramCursor.getString(i);
      break label1697;
      label2568:
      paramaukm.pkFlag = paramCursor.getInt(i);
      break label1732;
      label2583:
      paramaukm.subType = paramCursor.getInt(i);
      break label1767;
      label2598:
      paramaukm.lLastMsgSeq = paramCursor.getLong(i);
      break label1802;
      label2613:
      paramaukm.extra1 = paramCursor.getString(i);
      break label1836;
      label2628:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isFavorite = paramBoolean;
        break;
      }
      label2655:
      paramaukm.mFissionRoomNum = paramCursor.getInt(i);
      break label1906;
      label2670:
      paramaukm.praiseCount = paramCursor.getLong(i);
      break label1941;
      label2685:
      paramaukm.uint32_group_flag_ext2 = paramCursor.getInt(i);
      break label1976;
      label2700:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isGameRoom = paramBoolean;
        break;
      }
      label2727:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramaukm.isRobotHotChat = paramBoolean;
        break;
      }
      label2755:
      paramaukm.robotUin = paramCursor.getLong(i);
    }
    label2770:
    paramaukm.apolloGameId = paramCursor.getInt(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,name TEXT ,troopCode TEXT ,signature TEXT ,troopUin TEXT UNIQUE ,faceId INTEGER ,memberCount INTEGER ,hasJoined INTEGER ,isWifiHotChat INTEGER ,uuid TEXT ,iconUrl TEXT ,hotThemeGroupFlag INTEGER ,detail TEXT ,state INTEGER ,leftTime INTEGER ,ruState INTEGER ,supportFlashPic INTEGER ,supportDemo INTEGER ,adminLevel INTEGER ,joinUrl TEXT ,hotChatType INTEGER ,memo TEXT ,memoUrl TEXT ,memoShowed INTEGER ,userCreate INTEGER ,strAdminUins TEXT ,ownerUin TEXT ,pkFlag INTEGER ,subType INTEGER ,lLastMsgSeq INTEGER ,extra1 TEXT ,isFavorite INTEGER ,mFissionRoomNum INTEGER ,praiseCount INTEGER ,uint32_group_flag_ext2 INTEGER ,isGameRoom INTEGER ,isRobotHotChat INTEGER ,robotUin INTEGER ,apolloGameId INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (HotChatInfo)paramaukm;
    paramContentValues.put("name", paramaukm.name);
    paramContentValues.put("troopCode", paramaukm.troopCode);
    paramContentValues.put("signature", paramaukm.signature);
    paramContentValues.put("troopUin", paramaukm.troopUin);
    paramContentValues.put("faceId", Integer.valueOf(paramaukm.faceId));
    paramContentValues.put("memberCount", Integer.valueOf(paramaukm.memberCount));
    paramContentValues.put("hasJoined", Boolean.valueOf(paramaukm.hasJoined));
    paramContentValues.put("isWifiHotChat", Boolean.valueOf(paramaukm.isWifiHotChat));
    paramContentValues.put("uuid", paramaukm.uuid);
    paramContentValues.put("iconUrl", paramaukm.iconUrl);
    paramContentValues.put("hotThemeGroupFlag", Integer.valueOf(paramaukm.hotThemeGroupFlag));
    paramContentValues.put("detail", paramaukm.detail);
    paramContentValues.put("state", Integer.valueOf(paramaukm.state));
    paramContentValues.put("leftTime", Long.valueOf(paramaukm.leftTime));
    paramContentValues.put("ruState", Integer.valueOf(paramaukm.ruState));
    paramContentValues.put("supportFlashPic", Boolean.valueOf(paramaukm.supportFlashPic));
    paramContentValues.put("supportDemo", Boolean.valueOf(paramaukm.supportDemo));
    paramContentValues.put("adminLevel", Integer.valueOf(paramaukm.adminLevel));
    paramContentValues.put("joinUrl", paramaukm.joinUrl);
    paramContentValues.put("hotChatType", Integer.valueOf(paramaukm.hotChatType));
    paramContentValues.put("memo", paramaukm.memo);
    paramContentValues.put("memoUrl", paramaukm.memoUrl);
    paramContentValues.put("memoShowed", Boolean.valueOf(paramaukm.memoShowed));
    paramContentValues.put("userCreate", Integer.valueOf(paramaukm.userCreate));
    paramContentValues.put("strAdminUins", paramaukm.strAdminUins);
    paramContentValues.put("ownerUin", paramaukm.ownerUin);
    paramContentValues.put("pkFlag", Integer.valueOf(paramaukm.pkFlag));
    paramContentValues.put("subType", Integer.valueOf(paramaukm.subType));
    paramContentValues.put("lLastMsgSeq", Long.valueOf(paramaukm.lLastMsgSeq));
    paramContentValues.put("extra1", paramaukm.extra1);
    paramContentValues.put("isFavorite", Boolean.valueOf(paramaukm.isFavorite));
    paramContentValues.put("mFissionRoomNum", Integer.valueOf(paramaukm.mFissionRoomNum));
    paramContentValues.put("praiseCount", Long.valueOf(paramaukm.praiseCount));
    paramContentValues.put("uint32_group_flag_ext2", Integer.valueOf(paramaukm.uint32_group_flag_ext2));
    paramContentValues.put("isGameRoom", Boolean.valueOf(paramaukm.isGameRoom));
    paramContentValues.put("isRobotHotChat", Boolean.valueOf(paramaukm.isRobotHotChat));
    paramContentValues.put("robotUin", Long.valueOf(paramaukm.robotUin));
    paramContentValues.put("apolloGameId", Integer.valueOf(paramaukm.apolloGameId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auku
 * JD-Core Version:    0.7.0.1
 */