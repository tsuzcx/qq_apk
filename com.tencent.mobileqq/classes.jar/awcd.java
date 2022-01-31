import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awcd
  extends awch
{
  public awcd()
  {
    this.a = 38;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawbv = (HotChatInfo)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramawbv.troopCode = paramCursor.getString(paramCursor.getColumnIndex("troopCode"));
      paramawbv.signature = paramCursor.getString(paramCursor.getColumnIndex("signature"));
      paramawbv.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramawbv.faceId = paramCursor.getInt(paramCursor.getColumnIndex("faceId"));
      paramawbv.memberCount = paramCursor.getInt(paramCursor.getColumnIndex("memberCount"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasJoined")))
      {
        paramBoolean = true;
        paramawbv.hasJoined = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isWifiHotChat"))) {
          break label764;
        }
        paramBoolean = true;
        label169:
        paramawbv.isWifiHotChat = paramBoolean;
        paramawbv.uuid = paramCursor.getString(paramCursor.getColumnIndex("uuid"));
        paramawbv.iconUrl = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
        paramawbv.hotThemeGroupFlag = paramCursor.getInt(paramCursor.getColumnIndex("hotThemeGroupFlag"));
        paramawbv.detail = paramCursor.getString(paramCursor.getColumnIndex("detail"));
        paramawbv.state = paramCursor.getInt(paramCursor.getColumnIndex("state"));
        paramawbv.leftTime = paramCursor.getLong(paramCursor.getColumnIndex("leftTime"));
        paramawbv.ruState = paramCursor.getInt(paramCursor.getColumnIndex("ruState"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("supportFlashPic"))) {
          break label769;
        }
        paramBoolean = true;
        label320:
        paramawbv.supportFlashPic = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("supportDemo"))) {
          break label774;
        }
        paramBoolean = true;
        label345:
        paramawbv.supportDemo = paramBoolean;
        paramawbv.adminLevel = paramCursor.getInt(paramCursor.getColumnIndex("adminLevel"));
        paramawbv.joinUrl = paramCursor.getString(paramCursor.getColumnIndex("joinUrl"));
        paramawbv.hotChatType = paramCursor.getInt(paramCursor.getColumnIndex("hotChatType"));
        paramawbv.memo = paramCursor.getString(paramCursor.getColumnIndex("memo"));
        paramawbv.memoUrl = paramCursor.getString(paramCursor.getColumnIndex("memoUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("memoShowed"))) {
          break label779;
        }
        paramBoolean = true;
        label460:
        paramawbv.memoShowed = paramBoolean;
        paramawbv.userCreate = paramCursor.getInt(paramCursor.getColumnIndex("userCreate"));
        paramawbv.strAdminUins = paramCursor.getString(paramCursor.getColumnIndex("strAdminUins"));
        paramawbv.ownerUin = paramCursor.getString(paramCursor.getColumnIndex("ownerUin"));
        paramawbv.pkFlag = paramCursor.getInt(paramCursor.getColumnIndex("pkFlag"));
        paramawbv.subType = paramCursor.getInt(paramCursor.getColumnIndex("subType"));
        paramawbv.lLastMsgSeq = paramCursor.getLong(paramCursor.getColumnIndex("lLastMsgSeq"));
        paramawbv.extra1 = paramCursor.getString(paramCursor.getColumnIndex("extra1"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isFavorite"))) {
          break label784;
        }
        paramBoolean = true;
        label611:
        paramawbv.isFavorite = paramBoolean;
        paramawbv.mFissionRoomNum = paramCursor.getInt(paramCursor.getColumnIndex("mFissionRoomNum"));
        paramawbv.praiseCount = paramCursor.getLong(paramCursor.getColumnIndex("praiseCount"));
        paramawbv.uint32_group_flag_ext2 = paramCursor.getInt(paramCursor.getColumnIndex("uint32_group_flag_ext2"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isGameRoom"))) {
          break label789;
        }
        paramBoolean = true;
        label690:
        paramawbv.isGameRoom = paramBoolean;
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
        paramawbv.isRobotHotChat = paramBoolean;
        paramawbv.robotUin = paramCursor.getLong(paramCursor.getColumnIndex("robotUin"));
        paramawbv.apolloGameId = paramCursor.getInt(paramCursor.getColumnIndex("apolloGameId"));
        return paramawbv;
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
      paramawcg.a(new NoColumnError("name", String.class));
      i = paramCursor.getColumnIndex("troopCode");
      if (i != -1) {
        break label2133;
      }
      paramawcg.a(new NoColumnError("troopCode", String.class));
      label867:
      i = paramCursor.getColumnIndex("signature");
      if (i != -1) {
        break label2148;
      }
      paramawcg.a(new NoColumnError("signature", String.class));
      label901:
      i = paramCursor.getColumnIndex("troopUin");
      if (i != -1) {
        break label2163;
      }
      paramawcg.a(new NoColumnError("troopUin", String.class));
      label935:
      i = paramCursor.getColumnIndex("faceId");
      if (i != -1) {
        break label2178;
      }
      paramawcg.a(new NoColumnError("faceId", Integer.TYPE));
      label970:
      i = paramCursor.getColumnIndex("memberCount");
      if (i != -1) {
        break label2193;
      }
      paramawcg.a(new NoColumnError("memberCount", Integer.TYPE));
      label1005:
      i = paramCursor.getColumnIndex("hasJoined");
      if (i != -1) {
        break label2208;
      }
      paramawcg.a(new NoColumnError("hasJoined", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isWifiHotChat");
      if (i != -1) {
        break label2235;
      }
      paramawcg.a(new NoColumnError("isWifiHotChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("uuid");
      if (i != -1) {
        break label2262;
      }
      paramawcg.a(new NoColumnError("uuid", String.class));
      label1109:
      i = paramCursor.getColumnIndex("iconUrl");
      if (i != -1) {
        break label2277;
      }
      paramawcg.a(new NoColumnError("iconUrl", String.class));
      label1143:
      i = paramCursor.getColumnIndex("hotThemeGroupFlag");
      if (i != -1) {
        break label2292;
      }
      paramawcg.a(new NoColumnError("hotThemeGroupFlag", Integer.TYPE));
      label1178:
      i = paramCursor.getColumnIndex("detail");
      if (i != -1) {
        break label2307;
      }
      paramawcg.a(new NoColumnError("detail", String.class));
      label1212:
      i = paramCursor.getColumnIndex("state");
      if (i != -1) {
        break label2322;
      }
      paramawcg.a(new NoColumnError("state", Integer.TYPE));
      label1247:
      i = paramCursor.getColumnIndex("leftTime");
      if (i != -1) {
        break label2337;
      }
      paramawcg.a(new NoColumnError("leftTime", Long.TYPE));
      label1282:
      i = paramCursor.getColumnIndex("ruState");
      if (i != -1) {
        break label2352;
      }
      paramawcg.a(new NoColumnError("ruState", Integer.TYPE));
      label1317:
      i = paramCursor.getColumnIndex("supportFlashPic");
      if (i != -1) {
        break label2367;
      }
      paramawcg.a(new NoColumnError("supportFlashPic", Boolean.TYPE));
      i = paramCursor.getColumnIndex("supportDemo");
      if (i != -1) {
        break label2394;
      }
      paramawcg.a(new NoColumnError("supportDemo", Boolean.TYPE));
      i = paramCursor.getColumnIndex("adminLevel");
      if (i != -1) {
        break label2421;
      }
      paramawcg.a(new NoColumnError("adminLevel", Integer.TYPE));
      label1422:
      i = paramCursor.getColumnIndex("joinUrl");
      if (i != -1) {
        break label2436;
      }
      paramawcg.a(new NoColumnError("joinUrl", String.class));
      label1456:
      i = paramCursor.getColumnIndex("hotChatType");
      if (i != -1) {
        break label2451;
      }
      paramawcg.a(new NoColumnError("hotChatType", Integer.TYPE));
      label1491:
      i = paramCursor.getColumnIndex("memo");
      if (i != -1) {
        break label2466;
      }
      paramawcg.a(new NoColumnError("memo", String.class));
      label1525:
      i = paramCursor.getColumnIndex("memoUrl");
      if (i != -1) {
        break label2481;
      }
      paramawcg.a(new NoColumnError("memoUrl", String.class));
      label1559:
      i = paramCursor.getColumnIndex("memoShowed");
      if (i != -1) {
        break label2496;
      }
      paramawcg.a(new NoColumnError("memoShowed", Boolean.TYPE));
      i = paramCursor.getColumnIndex("userCreate");
      if (i != -1) {
        break label2523;
      }
      paramawcg.a(new NoColumnError("userCreate", Integer.TYPE));
      label1629:
      i = paramCursor.getColumnIndex("strAdminUins");
      if (i != -1) {
        break label2538;
      }
      paramawcg.a(new NoColumnError("strAdminUins", String.class));
      label1663:
      i = paramCursor.getColumnIndex("ownerUin");
      if (i != -1) {
        break label2553;
      }
      paramawcg.a(new NoColumnError("ownerUin", String.class));
      label1697:
      i = paramCursor.getColumnIndex("pkFlag");
      if (i != -1) {
        break label2568;
      }
      paramawcg.a(new NoColumnError("pkFlag", Integer.TYPE));
      label1732:
      i = paramCursor.getColumnIndex("subType");
      if (i != -1) {
        break label2583;
      }
      paramawcg.a(new NoColumnError("subType", Integer.TYPE));
      label1767:
      i = paramCursor.getColumnIndex("lLastMsgSeq");
      if (i != -1) {
        break label2598;
      }
      paramawcg.a(new NoColumnError("lLastMsgSeq", Long.TYPE));
      label1802:
      i = paramCursor.getColumnIndex("extra1");
      if (i != -1) {
        break label2613;
      }
      paramawcg.a(new NoColumnError("extra1", String.class));
      label1836:
      i = paramCursor.getColumnIndex("isFavorite");
      if (i != -1) {
        break label2628;
      }
      paramawcg.a(new NoColumnError("isFavorite", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mFissionRoomNum");
      if (i != -1) {
        break label2655;
      }
      paramawcg.a(new NoColumnError("mFissionRoomNum", Integer.TYPE));
      label1906:
      i = paramCursor.getColumnIndex("praiseCount");
      if (i != -1) {
        break label2670;
      }
      paramawcg.a(new NoColumnError("praiseCount", Long.TYPE));
      label1941:
      i = paramCursor.getColumnIndex("uint32_group_flag_ext2");
      if (i != -1) {
        break label2685;
      }
      paramawcg.a(new NoColumnError("uint32_group_flag_ext2", Integer.TYPE));
      label1976:
      i = paramCursor.getColumnIndex("isGameRoom");
      if (i != -1) {
        break label2700;
      }
      paramawcg.a(new NoColumnError("isGameRoom", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRobotHotChat");
      if (i != -1) {
        break label2727;
      }
      paramawcg.a(new NoColumnError("isRobotHotChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("robotUin");
      if (i != -1) {
        break label2755;
      }
      paramawcg.a(new NoColumnError("robotUin", Long.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("apolloGameId");
      if (i != -1) {
        break label2770;
      }
      paramawcg.a(new NoColumnError("apolloGameId", Integer.TYPE));
      return paramawbv;
      paramawbv.name = paramCursor.getString(i);
      break;
      label2133:
      paramawbv.troopCode = paramCursor.getString(i);
      break label867;
      label2148:
      paramawbv.signature = paramCursor.getString(i);
      break label901;
      label2163:
      paramawbv.troopUin = paramCursor.getString(i);
      break label935;
      label2178:
      paramawbv.faceId = paramCursor.getInt(i);
      break label970;
      label2193:
      paramawbv.memberCount = paramCursor.getInt(i);
      break label1005;
      label2208:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.hasJoined = paramBoolean;
        break;
      }
      label2235:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isWifiHotChat = paramBoolean;
        break;
      }
      label2262:
      paramawbv.uuid = paramCursor.getString(i);
      break label1109;
      label2277:
      paramawbv.iconUrl = paramCursor.getString(i);
      break label1143;
      label2292:
      paramawbv.hotThemeGroupFlag = paramCursor.getInt(i);
      break label1178;
      label2307:
      paramawbv.detail = paramCursor.getString(i);
      break label1212;
      label2322:
      paramawbv.state = paramCursor.getInt(i);
      break label1247;
      label2337:
      paramawbv.leftTime = paramCursor.getLong(i);
      break label1282;
      label2352:
      paramawbv.ruState = paramCursor.getInt(i);
      break label1317;
      label2367:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.supportFlashPic = paramBoolean;
        break;
      }
      label2394:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.supportDemo = paramBoolean;
        break;
      }
      label2421:
      paramawbv.adminLevel = paramCursor.getInt(i);
      break label1422;
      label2436:
      paramawbv.joinUrl = paramCursor.getString(i);
      break label1456;
      label2451:
      paramawbv.hotChatType = paramCursor.getInt(i);
      break label1491;
      label2466:
      paramawbv.memo = paramCursor.getString(i);
      break label1525;
      label2481:
      paramawbv.memoUrl = paramCursor.getString(i);
      break label1559;
      label2496:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.memoShowed = paramBoolean;
        break;
      }
      label2523:
      paramawbv.userCreate = paramCursor.getInt(i);
      break label1629;
      label2538:
      paramawbv.strAdminUins = paramCursor.getString(i);
      break label1663;
      label2553:
      paramawbv.ownerUin = paramCursor.getString(i);
      break label1697;
      label2568:
      paramawbv.pkFlag = paramCursor.getInt(i);
      break label1732;
      label2583:
      paramawbv.subType = paramCursor.getInt(i);
      break label1767;
      label2598:
      paramawbv.lLastMsgSeq = paramCursor.getLong(i);
      break label1802;
      label2613:
      paramawbv.extra1 = paramCursor.getString(i);
      break label1836;
      label2628:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isFavorite = paramBoolean;
        break;
      }
      label2655:
      paramawbv.mFissionRoomNum = paramCursor.getInt(i);
      break label1906;
      label2670:
      paramawbv.praiseCount = paramCursor.getLong(i);
      break label1941;
      label2685:
      paramawbv.uint32_group_flag_ext2 = paramCursor.getInt(i);
      break label1976;
      label2700:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isGameRoom = paramBoolean;
        break;
      }
      label2727:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramawbv.isRobotHotChat = paramBoolean;
        break;
      }
      label2755:
      paramawbv.robotUin = paramCursor.getLong(i);
    }
    label2770:
    paramawbv.apolloGameId = paramCursor.getInt(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,name TEXT ,troopCode TEXT ,signature TEXT ,troopUin TEXT UNIQUE ,faceId INTEGER ,memberCount INTEGER ,hasJoined INTEGER ,isWifiHotChat INTEGER ,uuid TEXT ,iconUrl TEXT ,hotThemeGroupFlag INTEGER ,detail TEXT ,state INTEGER ,leftTime INTEGER ,ruState INTEGER ,supportFlashPic INTEGER ,supportDemo INTEGER ,adminLevel INTEGER ,joinUrl TEXT ,hotChatType INTEGER ,memo TEXT ,memoUrl TEXT ,memoShowed INTEGER ,userCreate INTEGER ,strAdminUins TEXT ,ownerUin TEXT ,pkFlag INTEGER ,subType INTEGER ,lLastMsgSeq INTEGER ,extra1 TEXT ,isFavorite INTEGER ,mFissionRoomNum INTEGER ,praiseCount INTEGER ,uint32_group_flag_ext2 INTEGER ,isGameRoom INTEGER ,isRobotHotChat INTEGER ,robotUin INTEGER ,apolloGameId INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (HotChatInfo)paramawbv;
    paramContentValues.put("name", paramawbv.name);
    paramContentValues.put("troopCode", paramawbv.troopCode);
    paramContentValues.put("signature", paramawbv.signature);
    paramContentValues.put("troopUin", paramawbv.troopUin);
    paramContentValues.put("faceId", Integer.valueOf(paramawbv.faceId));
    paramContentValues.put("memberCount", Integer.valueOf(paramawbv.memberCount));
    paramContentValues.put("hasJoined", Boolean.valueOf(paramawbv.hasJoined));
    paramContentValues.put("isWifiHotChat", Boolean.valueOf(paramawbv.isWifiHotChat));
    paramContentValues.put("uuid", paramawbv.uuid);
    paramContentValues.put("iconUrl", paramawbv.iconUrl);
    paramContentValues.put("hotThemeGroupFlag", Integer.valueOf(paramawbv.hotThemeGroupFlag));
    paramContentValues.put("detail", paramawbv.detail);
    paramContentValues.put("state", Integer.valueOf(paramawbv.state));
    paramContentValues.put("leftTime", Long.valueOf(paramawbv.leftTime));
    paramContentValues.put("ruState", Integer.valueOf(paramawbv.ruState));
    paramContentValues.put("supportFlashPic", Boolean.valueOf(paramawbv.supportFlashPic));
    paramContentValues.put("supportDemo", Boolean.valueOf(paramawbv.supportDemo));
    paramContentValues.put("adminLevel", Integer.valueOf(paramawbv.adminLevel));
    paramContentValues.put("joinUrl", paramawbv.joinUrl);
    paramContentValues.put("hotChatType", Integer.valueOf(paramawbv.hotChatType));
    paramContentValues.put("memo", paramawbv.memo);
    paramContentValues.put("memoUrl", paramawbv.memoUrl);
    paramContentValues.put("memoShowed", Boolean.valueOf(paramawbv.memoShowed));
    paramContentValues.put("userCreate", Integer.valueOf(paramawbv.userCreate));
    paramContentValues.put("strAdminUins", paramawbv.strAdminUins);
    paramContentValues.put("ownerUin", paramawbv.ownerUin);
    paramContentValues.put("pkFlag", Integer.valueOf(paramawbv.pkFlag));
    paramContentValues.put("subType", Integer.valueOf(paramawbv.subType));
    paramContentValues.put("lLastMsgSeq", Long.valueOf(paramawbv.lLastMsgSeq));
    paramContentValues.put("extra1", paramawbv.extra1);
    paramContentValues.put("isFavorite", Boolean.valueOf(paramawbv.isFavorite));
    paramContentValues.put("mFissionRoomNum", Integer.valueOf(paramawbv.mFissionRoomNum));
    paramContentValues.put("praiseCount", Long.valueOf(paramawbv.praiseCount));
    paramContentValues.put("uint32_group_flag_ext2", Integer.valueOf(paramawbv.uint32_group_flag_ext2));
    paramContentValues.put("isGameRoom", Boolean.valueOf(paramawbv.isGameRoom));
    paramContentValues.put("isRobotHotChat", Boolean.valueOf(paramawbv.isRobotHotChat));
    paramContentValues.put("robotUin", Long.valueOf(paramawbv.robotUin));
    paramContentValues.put("apolloGameId", Integer.valueOf(paramawbv.apolloGameId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awcd
 * JD-Core Version:    0.7.0.1
 */