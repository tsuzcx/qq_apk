import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atmw
  extends atna
{
  public atmw()
  {
    this.a = 38;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramatmo = (HotChatInfo)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramatmo.troopCode = paramCursor.getString(paramCursor.getColumnIndex("troopCode"));
      paramatmo.signature = paramCursor.getString(paramCursor.getColumnIndex("signature"));
      paramatmo.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramatmo.faceId = paramCursor.getInt(paramCursor.getColumnIndex("faceId"));
      paramatmo.memberCount = paramCursor.getInt(paramCursor.getColumnIndex("memberCount"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasJoined")))
      {
        paramBoolean = true;
        paramatmo.hasJoined = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isWifiHotChat"))) {
          break label764;
        }
        paramBoolean = true;
        label169:
        paramatmo.isWifiHotChat = paramBoolean;
        paramatmo.uuid = paramCursor.getString(paramCursor.getColumnIndex("uuid"));
        paramatmo.iconUrl = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
        paramatmo.hotThemeGroupFlag = paramCursor.getInt(paramCursor.getColumnIndex("hotThemeGroupFlag"));
        paramatmo.detail = paramCursor.getString(paramCursor.getColumnIndex("detail"));
        paramatmo.state = paramCursor.getInt(paramCursor.getColumnIndex("state"));
        paramatmo.leftTime = paramCursor.getLong(paramCursor.getColumnIndex("leftTime"));
        paramatmo.ruState = paramCursor.getInt(paramCursor.getColumnIndex("ruState"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("supportFlashPic"))) {
          break label769;
        }
        paramBoolean = true;
        label320:
        paramatmo.supportFlashPic = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("supportDemo"))) {
          break label774;
        }
        paramBoolean = true;
        label345:
        paramatmo.supportDemo = paramBoolean;
        paramatmo.adminLevel = paramCursor.getInt(paramCursor.getColumnIndex("adminLevel"));
        paramatmo.joinUrl = paramCursor.getString(paramCursor.getColumnIndex("joinUrl"));
        paramatmo.hotChatType = paramCursor.getInt(paramCursor.getColumnIndex("hotChatType"));
        paramatmo.memo = paramCursor.getString(paramCursor.getColumnIndex("memo"));
        paramatmo.memoUrl = paramCursor.getString(paramCursor.getColumnIndex("memoUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("memoShowed"))) {
          break label779;
        }
        paramBoolean = true;
        label460:
        paramatmo.memoShowed = paramBoolean;
        paramatmo.userCreate = paramCursor.getInt(paramCursor.getColumnIndex("userCreate"));
        paramatmo.strAdminUins = paramCursor.getString(paramCursor.getColumnIndex("strAdminUins"));
        paramatmo.ownerUin = paramCursor.getString(paramCursor.getColumnIndex("ownerUin"));
        paramatmo.pkFlag = paramCursor.getInt(paramCursor.getColumnIndex("pkFlag"));
        paramatmo.subType = paramCursor.getInt(paramCursor.getColumnIndex("subType"));
        paramatmo.lLastMsgSeq = paramCursor.getLong(paramCursor.getColumnIndex("lLastMsgSeq"));
        paramatmo.extra1 = paramCursor.getString(paramCursor.getColumnIndex("extra1"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isFavorite"))) {
          break label784;
        }
        paramBoolean = true;
        label611:
        paramatmo.isFavorite = paramBoolean;
        paramatmo.mFissionRoomNum = paramCursor.getInt(paramCursor.getColumnIndex("mFissionRoomNum"));
        paramatmo.praiseCount = paramCursor.getLong(paramCursor.getColumnIndex("praiseCount"));
        paramatmo.uint32_group_flag_ext2 = paramCursor.getInt(paramCursor.getColumnIndex("uint32_group_flag_ext2"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isGameRoom"))) {
          break label789;
        }
        paramBoolean = true;
        label690:
        paramatmo.isGameRoom = paramBoolean;
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
        paramatmo.isRobotHotChat = paramBoolean;
        paramatmo.robotUin = paramCursor.getLong(paramCursor.getColumnIndex("robotUin"));
        paramatmo.apolloGameId = paramCursor.getInt(paramCursor.getColumnIndex("apolloGameId"));
        return paramatmo;
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
      paramatmz.a(new NoColumnError("name", String.class));
      i = paramCursor.getColumnIndex("troopCode");
      if (i != -1) {
        break label2133;
      }
      paramatmz.a(new NoColumnError("troopCode", String.class));
      label867:
      i = paramCursor.getColumnIndex("signature");
      if (i != -1) {
        break label2148;
      }
      paramatmz.a(new NoColumnError("signature", String.class));
      label901:
      i = paramCursor.getColumnIndex("troopUin");
      if (i != -1) {
        break label2163;
      }
      paramatmz.a(new NoColumnError("troopUin", String.class));
      label935:
      i = paramCursor.getColumnIndex("faceId");
      if (i != -1) {
        break label2178;
      }
      paramatmz.a(new NoColumnError("faceId", Integer.TYPE));
      label970:
      i = paramCursor.getColumnIndex("memberCount");
      if (i != -1) {
        break label2193;
      }
      paramatmz.a(new NoColumnError("memberCount", Integer.TYPE));
      label1005:
      i = paramCursor.getColumnIndex("hasJoined");
      if (i != -1) {
        break label2208;
      }
      paramatmz.a(new NoColumnError("hasJoined", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isWifiHotChat");
      if (i != -1) {
        break label2235;
      }
      paramatmz.a(new NoColumnError("isWifiHotChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("uuid");
      if (i != -1) {
        break label2262;
      }
      paramatmz.a(new NoColumnError("uuid", String.class));
      label1109:
      i = paramCursor.getColumnIndex("iconUrl");
      if (i != -1) {
        break label2277;
      }
      paramatmz.a(new NoColumnError("iconUrl", String.class));
      label1143:
      i = paramCursor.getColumnIndex("hotThemeGroupFlag");
      if (i != -1) {
        break label2292;
      }
      paramatmz.a(new NoColumnError("hotThemeGroupFlag", Integer.TYPE));
      label1178:
      i = paramCursor.getColumnIndex("detail");
      if (i != -1) {
        break label2307;
      }
      paramatmz.a(new NoColumnError("detail", String.class));
      label1212:
      i = paramCursor.getColumnIndex("state");
      if (i != -1) {
        break label2322;
      }
      paramatmz.a(new NoColumnError("state", Integer.TYPE));
      label1247:
      i = paramCursor.getColumnIndex("leftTime");
      if (i != -1) {
        break label2337;
      }
      paramatmz.a(new NoColumnError("leftTime", Long.TYPE));
      label1282:
      i = paramCursor.getColumnIndex("ruState");
      if (i != -1) {
        break label2352;
      }
      paramatmz.a(new NoColumnError("ruState", Integer.TYPE));
      label1317:
      i = paramCursor.getColumnIndex("supportFlashPic");
      if (i != -1) {
        break label2367;
      }
      paramatmz.a(new NoColumnError("supportFlashPic", Boolean.TYPE));
      i = paramCursor.getColumnIndex("supportDemo");
      if (i != -1) {
        break label2394;
      }
      paramatmz.a(new NoColumnError("supportDemo", Boolean.TYPE));
      i = paramCursor.getColumnIndex("adminLevel");
      if (i != -1) {
        break label2421;
      }
      paramatmz.a(new NoColumnError("adminLevel", Integer.TYPE));
      label1422:
      i = paramCursor.getColumnIndex("joinUrl");
      if (i != -1) {
        break label2436;
      }
      paramatmz.a(new NoColumnError("joinUrl", String.class));
      label1456:
      i = paramCursor.getColumnIndex("hotChatType");
      if (i != -1) {
        break label2451;
      }
      paramatmz.a(new NoColumnError("hotChatType", Integer.TYPE));
      label1491:
      i = paramCursor.getColumnIndex("memo");
      if (i != -1) {
        break label2466;
      }
      paramatmz.a(new NoColumnError("memo", String.class));
      label1525:
      i = paramCursor.getColumnIndex("memoUrl");
      if (i != -1) {
        break label2481;
      }
      paramatmz.a(new NoColumnError("memoUrl", String.class));
      label1559:
      i = paramCursor.getColumnIndex("memoShowed");
      if (i != -1) {
        break label2496;
      }
      paramatmz.a(new NoColumnError("memoShowed", Boolean.TYPE));
      i = paramCursor.getColumnIndex("userCreate");
      if (i != -1) {
        break label2523;
      }
      paramatmz.a(new NoColumnError("userCreate", Integer.TYPE));
      label1629:
      i = paramCursor.getColumnIndex("strAdminUins");
      if (i != -1) {
        break label2538;
      }
      paramatmz.a(new NoColumnError("strAdminUins", String.class));
      label1663:
      i = paramCursor.getColumnIndex("ownerUin");
      if (i != -1) {
        break label2553;
      }
      paramatmz.a(new NoColumnError("ownerUin", String.class));
      label1697:
      i = paramCursor.getColumnIndex("pkFlag");
      if (i != -1) {
        break label2568;
      }
      paramatmz.a(new NoColumnError("pkFlag", Integer.TYPE));
      label1732:
      i = paramCursor.getColumnIndex("subType");
      if (i != -1) {
        break label2583;
      }
      paramatmz.a(new NoColumnError("subType", Integer.TYPE));
      label1767:
      i = paramCursor.getColumnIndex("lLastMsgSeq");
      if (i != -1) {
        break label2598;
      }
      paramatmz.a(new NoColumnError("lLastMsgSeq", Long.TYPE));
      label1802:
      i = paramCursor.getColumnIndex("extra1");
      if (i != -1) {
        break label2613;
      }
      paramatmz.a(new NoColumnError("extra1", String.class));
      label1836:
      i = paramCursor.getColumnIndex("isFavorite");
      if (i != -1) {
        break label2628;
      }
      paramatmz.a(new NoColumnError("isFavorite", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mFissionRoomNum");
      if (i != -1) {
        break label2655;
      }
      paramatmz.a(new NoColumnError("mFissionRoomNum", Integer.TYPE));
      label1906:
      i = paramCursor.getColumnIndex("praiseCount");
      if (i != -1) {
        break label2670;
      }
      paramatmz.a(new NoColumnError("praiseCount", Long.TYPE));
      label1941:
      i = paramCursor.getColumnIndex("uint32_group_flag_ext2");
      if (i != -1) {
        break label2685;
      }
      paramatmz.a(new NoColumnError("uint32_group_flag_ext2", Integer.TYPE));
      label1976:
      i = paramCursor.getColumnIndex("isGameRoom");
      if (i != -1) {
        break label2700;
      }
      paramatmz.a(new NoColumnError("isGameRoom", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRobotHotChat");
      if (i != -1) {
        break label2727;
      }
      paramatmz.a(new NoColumnError("isRobotHotChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("robotUin");
      if (i != -1) {
        break label2755;
      }
      paramatmz.a(new NoColumnError("robotUin", Long.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("apolloGameId");
      if (i != -1) {
        break label2770;
      }
      paramatmz.a(new NoColumnError("apolloGameId", Integer.TYPE));
      return paramatmo;
      paramatmo.name = paramCursor.getString(i);
      break;
      label2133:
      paramatmo.troopCode = paramCursor.getString(i);
      break label867;
      label2148:
      paramatmo.signature = paramCursor.getString(i);
      break label901;
      label2163:
      paramatmo.troopUin = paramCursor.getString(i);
      break label935;
      label2178:
      paramatmo.faceId = paramCursor.getInt(i);
      break label970;
      label2193:
      paramatmo.memberCount = paramCursor.getInt(i);
      break label1005;
      label2208:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.hasJoined = paramBoolean;
        break;
      }
      label2235:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isWifiHotChat = paramBoolean;
        break;
      }
      label2262:
      paramatmo.uuid = paramCursor.getString(i);
      break label1109;
      label2277:
      paramatmo.iconUrl = paramCursor.getString(i);
      break label1143;
      label2292:
      paramatmo.hotThemeGroupFlag = paramCursor.getInt(i);
      break label1178;
      label2307:
      paramatmo.detail = paramCursor.getString(i);
      break label1212;
      label2322:
      paramatmo.state = paramCursor.getInt(i);
      break label1247;
      label2337:
      paramatmo.leftTime = paramCursor.getLong(i);
      break label1282;
      label2352:
      paramatmo.ruState = paramCursor.getInt(i);
      break label1317;
      label2367:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.supportFlashPic = paramBoolean;
        break;
      }
      label2394:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.supportDemo = paramBoolean;
        break;
      }
      label2421:
      paramatmo.adminLevel = paramCursor.getInt(i);
      break label1422;
      label2436:
      paramatmo.joinUrl = paramCursor.getString(i);
      break label1456;
      label2451:
      paramatmo.hotChatType = paramCursor.getInt(i);
      break label1491;
      label2466:
      paramatmo.memo = paramCursor.getString(i);
      break label1525;
      label2481:
      paramatmo.memoUrl = paramCursor.getString(i);
      break label1559;
      label2496:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.memoShowed = paramBoolean;
        break;
      }
      label2523:
      paramatmo.userCreate = paramCursor.getInt(i);
      break label1629;
      label2538:
      paramatmo.strAdminUins = paramCursor.getString(i);
      break label1663;
      label2553:
      paramatmo.ownerUin = paramCursor.getString(i);
      break label1697;
      label2568:
      paramatmo.pkFlag = paramCursor.getInt(i);
      break label1732;
      label2583:
      paramatmo.subType = paramCursor.getInt(i);
      break label1767;
      label2598:
      paramatmo.lLastMsgSeq = paramCursor.getLong(i);
      break label1802;
      label2613:
      paramatmo.extra1 = paramCursor.getString(i);
      break label1836;
      label2628:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isFavorite = paramBoolean;
        break;
      }
      label2655:
      paramatmo.mFissionRoomNum = paramCursor.getInt(i);
      break label1906;
      label2670:
      paramatmo.praiseCount = paramCursor.getLong(i);
      break label1941;
      label2685:
      paramatmo.uint32_group_flag_ext2 = paramCursor.getInt(i);
      break label1976;
      label2700:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isGameRoom = paramBoolean;
        break;
      }
      label2727:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramatmo.isRobotHotChat = paramBoolean;
        break;
      }
      label2755:
      paramatmo.robotUin = paramCursor.getLong(i);
    }
    label2770:
    paramatmo.apolloGameId = paramCursor.getInt(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,name TEXT ,troopCode TEXT ,signature TEXT ,troopUin TEXT UNIQUE ,faceId INTEGER ,memberCount INTEGER ,hasJoined INTEGER ,isWifiHotChat INTEGER ,uuid TEXT ,iconUrl TEXT ,hotThemeGroupFlag INTEGER ,detail TEXT ,state INTEGER ,leftTime INTEGER ,ruState INTEGER ,supportFlashPic INTEGER ,supportDemo INTEGER ,adminLevel INTEGER ,joinUrl TEXT ,hotChatType INTEGER ,memo TEXT ,memoUrl TEXT ,memoShowed INTEGER ,userCreate INTEGER ,strAdminUins TEXT ,ownerUin TEXT ,pkFlag INTEGER ,subType INTEGER ,lLastMsgSeq INTEGER ,extra1 TEXT ,isFavorite INTEGER ,mFissionRoomNum INTEGER ,praiseCount INTEGER ,uint32_group_flag_ext2 INTEGER ,isGameRoom INTEGER ,isRobotHotChat INTEGER ,robotUin INTEGER ,apolloGameId INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (HotChatInfo)paramatmo;
    paramContentValues.put("name", paramatmo.name);
    paramContentValues.put("troopCode", paramatmo.troopCode);
    paramContentValues.put("signature", paramatmo.signature);
    paramContentValues.put("troopUin", paramatmo.troopUin);
    paramContentValues.put("faceId", Integer.valueOf(paramatmo.faceId));
    paramContentValues.put("memberCount", Integer.valueOf(paramatmo.memberCount));
    paramContentValues.put("hasJoined", Boolean.valueOf(paramatmo.hasJoined));
    paramContentValues.put("isWifiHotChat", Boolean.valueOf(paramatmo.isWifiHotChat));
    paramContentValues.put("uuid", paramatmo.uuid);
    paramContentValues.put("iconUrl", paramatmo.iconUrl);
    paramContentValues.put("hotThemeGroupFlag", Integer.valueOf(paramatmo.hotThemeGroupFlag));
    paramContentValues.put("detail", paramatmo.detail);
    paramContentValues.put("state", Integer.valueOf(paramatmo.state));
    paramContentValues.put("leftTime", Long.valueOf(paramatmo.leftTime));
    paramContentValues.put("ruState", Integer.valueOf(paramatmo.ruState));
    paramContentValues.put("supportFlashPic", Boolean.valueOf(paramatmo.supportFlashPic));
    paramContentValues.put("supportDemo", Boolean.valueOf(paramatmo.supportDemo));
    paramContentValues.put("adminLevel", Integer.valueOf(paramatmo.adminLevel));
    paramContentValues.put("joinUrl", paramatmo.joinUrl);
    paramContentValues.put("hotChatType", Integer.valueOf(paramatmo.hotChatType));
    paramContentValues.put("memo", paramatmo.memo);
    paramContentValues.put("memoUrl", paramatmo.memoUrl);
    paramContentValues.put("memoShowed", Boolean.valueOf(paramatmo.memoShowed));
    paramContentValues.put("userCreate", Integer.valueOf(paramatmo.userCreate));
    paramContentValues.put("strAdminUins", paramatmo.strAdminUins);
    paramContentValues.put("ownerUin", paramatmo.ownerUin);
    paramContentValues.put("pkFlag", Integer.valueOf(paramatmo.pkFlag));
    paramContentValues.put("subType", Integer.valueOf(paramatmo.subType));
    paramContentValues.put("lLastMsgSeq", Long.valueOf(paramatmo.lLastMsgSeq));
    paramContentValues.put("extra1", paramatmo.extra1);
    paramContentValues.put("isFavorite", Boolean.valueOf(paramatmo.isFavorite));
    paramContentValues.put("mFissionRoomNum", Integer.valueOf(paramatmo.mFissionRoomNum));
    paramContentValues.put("praiseCount", Long.valueOf(paramatmo.praiseCount));
    paramContentValues.put("uint32_group_flag_ext2", Integer.valueOf(paramatmo.uint32_group_flag_ext2));
    paramContentValues.put("isGameRoom", Boolean.valueOf(paramatmo.isGameRoom));
    paramContentValues.put("isRobotHotChat", Boolean.valueOf(paramatmo.isRobotHotChat));
    paramContentValues.put("robotUin", Long.valueOf(paramatmo.robotUin));
    paramContentValues.put("apolloGameId", Integer.valueOf(paramatmo.apolloGameId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atmw
 * JD-Core Version:    0.7.0.1
 */