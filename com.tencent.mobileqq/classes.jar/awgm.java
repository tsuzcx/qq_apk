import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awgm
  extends awgq
{
  public awgm()
  {
    this.a = 38;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawge = (HotChatInfo)paramawge;
    if (paramawgp == null)
    {
      paramawge.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramawge.troopCode = paramCursor.getString(paramCursor.getColumnIndex("troopCode"));
      paramawge.signature = paramCursor.getString(paramCursor.getColumnIndex("signature"));
      paramawge.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramawge.faceId = paramCursor.getInt(paramCursor.getColumnIndex("faceId"));
      paramawge.memberCount = paramCursor.getInt(paramCursor.getColumnIndex("memberCount"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasJoined")))
      {
        paramBoolean = true;
        paramawge.hasJoined = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isWifiHotChat"))) {
          break label764;
        }
        paramBoolean = true;
        label169:
        paramawge.isWifiHotChat = paramBoolean;
        paramawge.uuid = paramCursor.getString(paramCursor.getColumnIndex("uuid"));
        paramawge.iconUrl = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
        paramawge.hotThemeGroupFlag = paramCursor.getInt(paramCursor.getColumnIndex("hotThemeGroupFlag"));
        paramawge.detail = paramCursor.getString(paramCursor.getColumnIndex("detail"));
        paramawge.state = paramCursor.getInt(paramCursor.getColumnIndex("state"));
        paramawge.leftTime = paramCursor.getLong(paramCursor.getColumnIndex("leftTime"));
        paramawge.ruState = paramCursor.getInt(paramCursor.getColumnIndex("ruState"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("supportFlashPic"))) {
          break label769;
        }
        paramBoolean = true;
        label320:
        paramawge.supportFlashPic = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("supportDemo"))) {
          break label774;
        }
        paramBoolean = true;
        label345:
        paramawge.supportDemo = paramBoolean;
        paramawge.adminLevel = paramCursor.getInt(paramCursor.getColumnIndex("adminLevel"));
        paramawge.joinUrl = paramCursor.getString(paramCursor.getColumnIndex("joinUrl"));
        paramawge.hotChatType = paramCursor.getInt(paramCursor.getColumnIndex("hotChatType"));
        paramawge.memo = paramCursor.getString(paramCursor.getColumnIndex("memo"));
        paramawge.memoUrl = paramCursor.getString(paramCursor.getColumnIndex("memoUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("memoShowed"))) {
          break label779;
        }
        paramBoolean = true;
        label460:
        paramawge.memoShowed = paramBoolean;
        paramawge.userCreate = paramCursor.getInt(paramCursor.getColumnIndex("userCreate"));
        paramawge.strAdminUins = paramCursor.getString(paramCursor.getColumnIndex("strAdminUins"));
        paramawge.ownerUin = paramCursor.getString(paramCursor.getColumnIndex("ownerUin"));
        paramawge.pkFlag = paramCursor.getInt(paramCursor.getColumnIndex("pkFlag"));
        paramawge.subType = paramCursor.getInt(paramCursor.getColumnIndex("subType"));
        paramawge.lLastMsgSeq = paramCursor.getLong(paramCursor.getColumnIndex("lLastMsgSeq"));
        paramawge.extra1 = paramCursor.getString(paramCursor.getColumnIndex("extra1"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isFavorite"))) {
          break label784;
        }
        paramBoolean = true;
        label611:
        paramawge.isFavorite = paramBoolean;
        paramawge.mFissionRoomNum = paramCursor.getInt(paramCursor.getColumnIndex("mFissionRoomNum"));
        paramawge.praiseCount = paramCursor.getLong(paramCursor.getColumnIndex("praiseCount"));
        paramawge.uint32_group_flag_ext2 = paramCursor.getInt(paramCursor.getColumnIndex("uint32_group_flag_ext2"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isGameRoom"))) {
          break label789;
        }
        paramBoolean = true;
        label690:
        paramawge.isGameRoom = paramBoolean;
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
        paramawge.isRobotHotChat = paramBoolean;
        paramawge.robotUin = paramCursor.getLong(paramCursor.getColumnIndex("robotUin"));
        paramawge.apolloGameId = paramCursor.getInt(paramCursor.getColumnIndex("apolloGameId"));
        return paramawge;
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
      paramawgp.a(new NoColumnError("name", String.class));
      i = paramCursor.getColumnIndex("troopCode");
      if (i != -1) {
        break label2133;
      }
      paramawgp.a(new NoColumnError("troopCode", String.class));
      label867:
      i = paramCursor.getColumnIndex("signature");
      if (i != -1) {
        break label2148;
      }
      paramawgp.a(new NoColumnError("signature", String.class));
      label901:
      i = paramCursor.getColumnIndex("troopUin");
      if (i != -1) {
        break label2163;
      }
      paramawgp.a(new NoColumnError("troopUin", String.class));
      label935:
      i = paramCursor.getColumnIndex("faceId");
      if (i != -1) {
        break label2178;
      }
      paramawgp.a(new NoColumnError("faceId", Integer.TYPE));
      label970:
      i = paramCursor.getColumnIndex("memberCount");
      if (i != -1) {
        break label2193;
      }
      paramawgp.a(new NoColumnError("memberCount", Integer.TYPE));
      label1005:
      i = paramCursor.getColumnIndex("hasJoined");
      if (i != -1) {
        break label2208;
      }
      paramawgp.a(new NoColumnError("hasJoined", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isWifiHotChat");
      if (i != -1) {
        break label2235;
      }
      paramawgp.a(new NoColumnError("isWifiHotChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("uuid");
      if (i != -1) {
        break label2262;
      }
      paramawgp.a(new NoColumnError("uuid", String.class));
      label1109:
      i = paramCursor.getColumnIndex("iconUrl");
      if (i != -1) {
        break label2277;
      }
      paramawgp.a(new NoColumnError("iconUrl", String.class));
      label1143:
      i = paramCursor.getColumnIndex("hotThemeGroupFlag");
      if (i != -1) {
        break label2292;
      }
      paramawgp.a(new NoColumnError("hotThemeGroupFlag", Integer.TYPE));
      label1178:
      i = paramCursor.getColumnIndex("detail");
      if (i != -1) {
        break label2307;
      }
      paramawgp.a(new NoColumnError("detail", String.class));
      label1212:
      i = paramCursor.getColumnIndex("state");
      if (i != -1) {
        break label2322;
      }
      paramawgp.a(new NoColumnError("state", Integer.TYPE));
      label1247:
      i = paramCursor.getColumnIndex("leftTime");
      if (i != -1) {
        break label2337;
      }
      paramawgp.a(new NoColumnError("leftTime", Long.TYPE));
      label1282:
      i = paramCursor.getColumnIndex("ruState");
      if (i != -1) {
        break label2352;
      }
      paramawgp.a(new NoColumnError("ruState", Integer.TYPE));
      label1317:
      i = paramCursor.getColumnIndex("supportFlashPic");
      if (i != -1) {
        break label2367;
      }
      paramawgp.a(new NoColumnError("supportFlashPic", Boolean.TYPE));
      i = paramCursor.getColumnIndex("supportDemo");
      if (i != -1) {
        break label2394;
      }
      paramawgp.a(new NoColumnError("supportDemo", Boolean.TYPE));
      i = paramCursor.getColumnIndex("adminLevel");
      if (i != -1) {
        break label2421;
      }
      paramawgp.a(new NoColumnError("adminLevel", Integer.TYPE));
      label1422:
      i = paramCursor.getColumnIndex("joinUrl");
      if (i != -1) {
        break label2436;
      }
      paramawgp.a(new NoColumnError("joinUrl", String.class));
      label1456:
      i = paramCursor.getColumnIndex("hotChatType");
      if (i != -1) {
        break label2451;
      }
      paramawgp.a(new NoColumnError("hotChatType", Integer.TYPE));
      label1491:
      i = paramCursor.getColumnIndex("memo");
      if (i != -1) {
        break label2466;
      }
      paramawgp.a(new NoColumnError("memo", String.class));
      label1525:
      i = paramCursor.getColumnIndex("memoUrl");
      if (i != -1) {
        break label2481;
      }
      paramawgp.a(new NoColumnError("memoUrl", String.class));
      label1559:
      i = paramCursor.getColumnIndex("memoShowed");
      if (i != -1) {
        break label2496;
      }
      paramawgp.a(new NoColumnError("memoShowed", Boolean.TYPE));
      i = paramCursor.getColumnIndex("userCreate");
      if (i != -1) {
        break label2523;
      }
      paramawgp.a(new NoColumnError("userCreate", Integer.TYPE));
      label1629:
      i = paramCursor.getColumnIndex("strAdminUins");
      if (i != -1) {
        break label2538;
      }
      paramawgp.a(new NoColumnError("strAdminUins", String.class));
      label1663:
      i = paramCursor.getColumnIndex("ownerUin");
      if (i != -1) {
        break label2553;
      }
      paramawgp.a(new NoColumnError("ownerUin", String.class));
      label1697:
      i = paramCursor.getColumnIndex("pkFlag");
      if (i != -1) {
        break label2568;
      }
      paramawgp.a(new NoColumnError("pkFlag", Integer.TYPE));
      label1732:
      i = paramCursor.getColumnIndex("subType");
      if (i != -1) {
        break label2583;
      }
      paramawgp.a(new NoColumnError("subType", Integer.TYPE));
      label1767:
      i = paramCursor.getColumnIndex("lLastMsgSeq");
      if (i != -1) {
        break label2598;
      }
      paramawgp.a(new NoColumnError("lLastMsgSeq", Long.TYPE));
      label1802:
      i = paramCursor.getColumnIndex("extra1");
      if (i != -1) {
        break label2613;
      }
      paramawgp.a(new NoColumnError("extra1", String.class));
      label1836:
      i = paramCursor.getColumnIndex("isFavorite");
      if (i != -1) {
        break label2628;
      }
      paramawgp.a(new NoColumnError("isFavorite", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mFissionRoomNum");
      if (i != -1) {
        break label2655;
      }
      paramawgp.a(new NoColumnError("mFissionRoomNum", Integer.TYPE));
      label1906:
      i = paramCursor.getColumnIndex("praiseCount");
      if (i != -1) {
        break label2670;
      }
      paramawgp.a(new NoColumnError("praiseCount", Long.TYPE));
      label1941:
      i = paramCursor.getColumnIndex("uint32_group_flag_ext2");
      if (i != -1) {
        break label2685;
      }
      paramawgp.a(new NoColumnError("uint32_group_flag_ext2", Integer.TYPE));
      label1976:
      i = paramCursor.getColumnIndex("isGameRoom");
      if (i != -1) {
        break label2700;
      }
      paramawgp.a(new NoColumnError("isGameRoom", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRobotHotChat");
      if (i != -1) {
        break label2727;
      }
      paramawgp.a(new NoColumnError("isRobotHotChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("robotUin");
      if (i != -1) {
        break label2755;
      }
      paramawgp.a(new NoColumnError("robotUin", Long.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("apolloGameId");
      if (i != -1) {
        break label2770;
      }
      paramawgp.a(new NoColumnError("apolloGameId", Integer.TYPE));
      return paramawge;
      paramawge.name = paramCursor.getString(i);
      break;
      label2133:
      paramawge.troopCode = paramCursor.getString(i);
      break label867;
      label2148:
      paramawge.signature = paramCursor.getString(i);
      break label901;
      label2163:
      paramawge.troopUin = paramCursor.getString(i);
      break label935;
      label2178:
      paramawge.faceId = paramCursor.getInt(i);
      break label970;
      label2193:
      paramawge.memberCount = paramCursor.getInt(i);
      break label1005;
      label2208:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.hasJoined = paramBoolean;
        break;
      }
      label2235:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isWifiHotChat = paramBoolean;
        break;
      }
      label2262:
      paramawge.uuid = paramCursor.getString(i);
      break label1109;
      label2277:
      paramawge.iconUrl = paramCursor.getString(i);
      break label1143;
      label2292:
      paramawge.hotThemeGroupFlag = paramCursor.getInt(i);
      break label1178;
      label2307:
      paramawge.detail = paramCursor.getString(i);
      break label1212;
      label2322:
      paramawge.state = paramCursor.getInt(i);
      break label1247;
      label2337:
      paramawge.leftTime = paramCursor.getLong(i);
      break label1282;
      label2352:
      paramawge.ruState = paramCursor.getInt(i);
      break label1317;
      label2367:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.supportFlashPic = paramBoolean;
        break;
      }
      label2394:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.supportDemo = paramBoolean;
        break;
      }
      label2421:
      paramawge.adminLevel = paramCursor.getInt(i);
      break label1422;
      label2436:
      paramawge.joinUrl = paramCursor.getString(i);
      break label1456;
      label2451:
      paramawge.hotChatType = paramCursor.getInt(i);
      break label1491;
      label2466:
      paramawge.memo = paramCursor.getString(i);
      break label1525;
      label2481:
      paramawge.memoUrl = paramCursor.getString(i);
      break label1559;
      label2496:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.memoShowed = paramBoolean;
        break;
      }
      label2523:
      paramawge.userCreate = paramCursor.getInt(i);
      break label1629;
      label2538:
      paramawge.strAdminUins = paramCursor.getString(i);
      break label1663;
      label2553:
      paramawge.ownerUin = paramCursor.getString(i);
      break label1697;
      label2568:
      paramawge.pkFlag = paramCursor.getInt(i);
      break label1732;
      label2583:
      paramawge.subType = paramCursor.getInt(i);
      break label1767;
      label2598:
      paramawge.lLastMsgSeq = paramCursor.getLong(i);
      break label1802;
      label2613:
      paramawge.extra1 = paramCursor.getString(i);
      break label1836;
      label2628:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isFavorite = paramBoolean;
        break;
      }
      label2655:
      paramawge.mFissionRoomNum = paramCursor.getInt(i);
      break label1906;
      label2670:
      paramawge.praiseCount = paramCursor.getLong(i);
      break label1941;
      label2685:
      paramawge.uint32_group_flag_ext2 = paramCursor.getInt(i);
      break label1976;
      label2700:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isGameRoom = paramBoolean;
        break;
      }
      label2727:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramawge.isRobotHotChat = paramBoolean;
        break;
      }
      label2755:
      paramawge.robotUin = paramCursor.getLong(i);
    }
    label2770:
    paramawge.apolloGameId = paramCursor.getInt(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,name TEXT ,troopCode TEXT ,signature TEXT ,troopUin TEXT UNIQUE ,faceId INTEGER ,memberCount INTEGER ,hasJoined INTEGER ,isWifiHotChat INTEGER ,uuid TEXT ,iconUrl TEXT ,hotThemeGroupFlag INTEGER ,detail TEXT ,state INTEGER ,leftTime INTEGER ,ruState INTEGER ,supportFlashPic INTEGER ,supportDemo INTEGER ,adminLevel INTEGER ,joinUrl TEXT ,hotChatType INTEGER ,memo TEXT ,memoUrl TEXT ,memoShowed INTEGER ,userCreate INTEGER ,strAdminUins TEXT ,ownerUin TEXT ,pkFlag INTEGER ,subType INTEGER ,lLastMsgSeq INTEGER ,extra1 TEXT ,isFavorite INTEGER ,mFissionRoomNum INTEGER ,praiseCount INTEGER ,uint32_group_flag_ext2 INTEGER ,isGameRoom INTEGER ,isRobotHotChat INTEGER ,robotUin INTEGER ,apolloGameId INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (HotChatInfo)paramawge;
    paramContentValues.put("name", paramawge.name);
    paramContentValues.put("troopCode", paramawge.troopCode);
    paramContentValues.put("signature", paramawge.signature);
    paramContentValues.put("troopUin", paramawge.troopUin);
    paramContentValues.put("faceId", Integer.valueOf(paramawge.faceId));
    paramContentValues.put("memberCount", Integer.valueOf(paramawge.memberCount));
    paramContentValues.put("hasJoined", Boolean.valueOf(paramawge.hasJoined));
    paramContentValues.put("isWifiHotChat", Boolean.valueOf(paramawge.isWifiHotChat));
    paramContentValues.put("uuid", paramawge.uuid);
    paramContentValues.put("iconUrl", paramawge.iconUrl);
    paramContentValues.put("hotThemeGroupFlag", Integer.valueOf(paramawge.hotThemeGroupFlag));
    paramContentValues.put("detail", paramawge.detail);
    paramContentValues.put("state", Integer.valueOf(paramawge.state));
    paramContentValues.put("leftTime", Long.valueOf(paramawge.leftTime));
    paramContentValues.put("ruState", Integer.valueOf(paramawge.ruState));
    paramContentValues.put("supportFlashPic", Boolean.valueOf(paramawge.supportFlashPic));
    paramContentValues.put("supportDemo", Boolean.valueOf(paramawge.supportDemo));
    paramContentValues.put("adminLevel", Integer.valueOf(paramawge.adminLevel));
    paramContentValues.put("joinUrl", paramawge.joinUrl);
    paramContentValues.put("hotChatType", Integer.valueOf(paramawge.hotChatType));
    paramContentValues.put("memo", paramawge.memo);
    paramContentValues.put("memoUrl", paramawge.memoUrl);
    paramContentValues.put("memoShowed", Boolean.valueOf(paramawge.memoShowed));
    paramContentValues.put("userCreate", Integer.valueOf(paramawge.userCreate));
    paramContentValues.put("strAdminUins", paramawge.strAdminUins);
    paramContentValues.put("ownerUin", paramawge.ownerUin);
    paramContentValues.put("pkFlag", Integer.valueOf(paramawge.pkFlag));
    paramContentValues.put("subType", Integer.valueOf(paramawge.subType));
    paramContentValues.put("lLastMsgSeq", Long.valueOf(paramawge.lLastMsgSeq));
    paramContentValues.put("extra1", paramawge.extra1);
    paramContentValues.put("isFavorite", Boolean.valueOf(paramawge.isFavorite));
    paramContentValues.put("mFissionRoomNum", Integer.valueOf(paramawge.mFissionRoomNum));
    paramContentValues.put("praiseCount", Long.valueOf(paramawge.praiseCount));
    paramContentValues.put("uint32_group_flag_ext2", Integer.valueOf(paramawge.uint32_group_flag_ext2));
    paramContentValues.put("isGameRoom", Boolean.valueOf(paramawge.isGameRoom));
    paramContentValues.put("isRobotHotChat", Boolean.valueOf(paramawge.isRobotHotChat));
    paramContentValues.put("robotUin", Long.valueOf(paramawge.robotUin));
    paramContentValues.put("apolloGameId", Integer.valueOf(paramawge.apolloGameId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awgm
 * JD-Core Version:    0.7.0.1
 */