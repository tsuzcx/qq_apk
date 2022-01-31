import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awgu
  extends awgq
{
  public awgu()
  {
    this.a = 24;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawge = (PublicAccountInfo)paramawge;
    if (paramawgp == null)
    {
      paramawge.uin = paramCursor.getLong(paramCursor.getColumnIndex("uin"));
      paramawge.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramawge.displayNumber = paramCursor.getString(paramCursor.getColumnIndex("displayNumber"));
      paramawge.summary = paramCursor.getString(paramCursor.getColumnIndex("summary"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isRecvMsg")))
      {
        paramBoolean = true;
        paramawge.isRecvMsg = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRecvPush"))) {
          break label498;
        }
        paramBoolean = true;
        label133:
        paramawge.isRecvPush = paramBoolean;
        paramawge.clickCount = paramCursor.getInt(paramCursor.getColumnIndex("clickCount"));
        paramawge.certifiedGrade = paramCursor.getLong(paramCursor.getColumnIndex("certifiedGrade"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSyncLbs"))) {
          break label503;
        }
        paramBoolean = true;
        label194:
        paramawge.isSyncLbs = paramBoolean;
        paramawge.showFlag = paramCursor.getInt(paramCursor.getColumnIndex("showFlag"));
        paramawge.mShowMsgFlag = paramCursor.getInt(paramCursor.getColumnIndex("mShowMsgFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mIsAgreeSyncLbs"))) {
          break label508;
        }
        paramBoolean = true;
        label255:
        paramawge.mIsAgreeSyncLbs = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mIsSyncLbsSelected"))) {
          break label513;
        }
        paramBoolean = true;
        label280:
        paramawge.mIsSyncLbsSelected = paramBoolean;
        paramawge.dateTime = paramCursor.getLong(paramCursor.getColumnIndex("dateTime"));
        paramawge.accountFlag = paramCursor.getInt(paramCursor.getColumnIndex("accountFlag"));
        paramawge.accountFlag2 = paramCursor.getLong(paramCursor.getColumnIndex("accountFlag2"));
        paramawge.eqqAccountFlag = paramCursor.getLong(paramCursor.getColumnIndex("eqqAccountFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShieldMsg"))) {
          break label518;
        }
      }
      label513:
      label518:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramawge.isShieldMsg = paramBoolean;
        paramawge.messageSettingFlag = paramCursor.getInt(paramCursor.getColumnIndex("messageSettingFlag"));
        paramawge.extendType = paramCursor.getInt(paramCursor.getColumnIndex("extendType"));
        paramawge.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramawge.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramawge.logo = paramCursor.getString(paramCursor.getColumnIndex("logo"));
        paramawge.lastAIOReadTime = paramCursor.getLong(paramCursor.getColumnIndex("lastAIOReadTime"));
        return paramawge;
        paramBoolean = false;
        break;
        label498:
        paramBoolean = false;
        break label133;
        label503:
        paramBoolean = false;
        break label194;
        label508:
        paramBoolean = false;
        break label255;
        paramBoolean = false;
        break label280;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("uin", Long.TYPE));
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label1375;
      }
      paramawgp.a(new NoColumnError("name", String.class));
      label592:
      i = paramCursor.getColumnIndex("displayNumber");
      if (i != -1) {
        break label1390;
      }
      paramawgp.a(new NoColumnError("displayNumber", String.class));
      label626:
      i = paramCursor.getColumnIndex("summary");
      if (i != -1) {
        break label1405;
      }
      paramawgp.a(new NoColumnError("summary", String.class));
      label660:
      i = paramCursor.getColumnIndex("isRecvMsg");
      if (i != -1) {
        break label1420;
      }
      paramawgp.a(new NoColumnError("isRecvMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRecvPush");
      if (i != -1) {
        break label1447;
      }
      paramawgp.a(new NoColumnError("isRecvPush", Boolean.TYPE));
      i = paramCursor.getColumnIndex("clickCount");
      if (i != -1) {
        break label1474;
      }
      paramawgp.a(new NoColumnError("clickCount", Integer.TYPE));
      label765:
      i = paramCursor.getColumnIndex("certifiedGrade");
      if (i != -1) {
        break label1489;
      }
      paramawgp.a(new NoColumnError("certifiedGrade", Long.TYPE));
      label800:
      i = paramCursor.getColumnIndex("isSyncLbs");
      if (i != -1) {
        break label1504;
      }
      paramawgp.a(new NoColumnError("isSyncLbs", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showFlag");
      if (i != -1) {
        break label1531;
      }
      paramawgp.a(new NoColumnError("showFlag", Integer.TYPE));
      label870:
      i = paramCursor.getColumnIndex("mShowMsgFlag");
      if (i != -1) {
        break label1546;
      }
      paramawgp.a(new NoColumnError("mShowMsgFlag", Integer.TYPE));
      label905:
      i = paramCursor.getColumnIndex("mIsAgreeSyncLbs");
      if (i != -1) {
        break label1561;
      }
      paramawgp.a(new NoColumnError("mIsAgreeSyncLbs", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mIsSyncLbsSelected");
      if (i != -1) {
        break label1588;
      }
      paramawgp.a(new NoColumnError("mIsSyncLbsSelected", Boolean.TYPE));
      i = paramCursor.getColumnIndex("dateTime");
      if (i != -1) {
        break label1615;
      }
      paramawgp.a(new NoColumnError("dateTime", Long.TYPE));
      label1010:
      i = paramCursor.getColumnIndex("accountFlag");
      if (i != -1) {
        break label1630;
      }
      paramawgp.a(new NoColumnError("accountFlag", Integer.TYPE));
      label1045:
      i = paramCursor.getColumnIndex("accountFlag2");
      if (i != -1) {
        break label1645;
      }
      paramawgp.a(new NoColumnError("accountFlag2", Long.TYPE));
      label1080:
      i = paramCursor.getColumnIndex("eqqAccountFlag");
      if (i != -1) {
        break label1660;
      }
      paramawgp.a(new NoColumnError("eqqAccountFlag", Long.TYPE));
      label1115:
      i = paramCursor.getColumnIndex("isShieldMsg");
      if (i != -1) {
        break label1675;
      }
      paramawgp.a(new NoColumnError("isShieldMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("messageSettingFlag");
      if (i != -1) {
        break label1703;
      }
      paramawgp.a(new NoColumnError("messageSettingFlag", Integer.TYPE));
      label1185:
      i = paramCursor.getColumnIndex("extendType");
      if (i != -1) {
        break label1718;
      }
      paramawgp.a(new NoColumnError("extendType", Integer.TYPE));
      label1220:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label1733;
      }
      paramawgp.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label1255:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label1748;
      }
      paramawgp.a(new NoColumnError("mCompareSpell", String.class));
      label1289:
      i = paramCursor.getColumnIndex("logo");
      if (i != -1) {
        break label1763;
      }
      paramawgp.a(new NoColumnError("logo", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("lastAIOReadTime");
      if (i != -1) {
        break label1778;
      }
      paramawgp.a(new NoColumnError("lastAIOReadTime", Long.TYPE));
      return paramawge;
      paramawge.uin = paramCursor.getLong(i);
      break;
      label1375:
      paramawge.name = paramCursor.getString(i);
      break label592;
      label1390:
      paramawge.displayNumber = paramCursor.getString(i);
      break label626;
      label1405:
      paramawge.summary = paramCursor.getString(i);
      break label660;
      label1420:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isRecvMsg = paramBoolean;
        break;
      }
      label1447:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isRecvPush = paramBoolean;
        break;
      }
      label1474:
      paramawge.clickCount = paramCursor.getInt(i);
      break label765;
      label1489:
      paramawge.certifiedGrade = paramCursor.getLong(i);
      break label800;
      label1504:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isSyncLbs = paramBoolean;
        break;
      }
      label1531:
      paramawge.showFlag = paramCursor.getInt(i);
      break label870;
      label1546:
      paramawge.mShowMsgFlag = paramCursor.getInt(i);
      break label905;
      label1561:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.mIsAgreeSyncLbs = paramBoolean;
        break;
      }
      label1588:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.mIsSyncLbsSelected = paramBoolean;
        break;
      }
      label1615:
      paramawge.dateTime = paramCursor.getLong(i);
      break label1010;
      label1630:
      paramawge.accountFlag = paramCursor.getInt(i);
      break label1045;
      label1645:
      paramawge.accountFlag2 = paramCursor.getLong(i);
      break label1080;
      label1660:
      paramawge.eqqAccountFlag = paramCursor.getLong(i);
      break label1115;
      label1675:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramawge.isShieldMsg = paramBoolean;
        break;
      }
      label1703:
      paramawge.messageSettingFlag = paramCursor.getInt(i);
      break label1185;
      label1718:
      paramawge.extendType = paramCursor.getInt(i);
      break label1220;
      label1733:
      paramawge.mComparePartInt = paramCursor.getInt(i);
      break label1255;
      label1748:
      paramawge.mCompareSpell = paramCursor.getString(i);
      break label1289;
      label1763:
      paramawge.logo = paramCursor.getString(i);
    }
    label1778:
    paramawge.lastAIOReadTime = paramCursor.getLong(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin INTEGER UNIQUE ,name TEXT ,displayNumber TEXT ,summary TEXT ,isRecvMsg INTEGER ,isRecvPush INTEGER ,clickCount INTEGER ,certifiedGrade INTEGER ,isSyncLbs INTEGER ,showFlag INTEGER ,mShowMsgFlag INTEGER ,mIsAgreeSyncLbs INTEGER ,mIsSyncLbsSelected INTEGER ,dateTime INTEGER ,accountFlag INTEGER ,accountFlag2 INTEGER ,eqqAccountFlag INTEGER ,isShieldMsg INTEGER ,messageSettingFlag INTEGER ,extendType INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,logo TEXT ,lastAIOReadTime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (PublicAccountInfo)paramawge;
    paramContentValues.put("uin", Long.valueOf(paramawge.uin));
    paramContentValues.put("name", paramawge.name);
    paramContentValues.put("displayNumber", paramawge.displayNumber);
    paramContentValues.put("summary", paramawge.summary);
    paramContentValues.put("isRecvMsg", Boolean.valueOf(paramawge.isRecvMsg));
    paramContentValues.put("isRecvPush", Boolean.valueOf(paramawge.isRecvPush));
    paramContentValues.put("clickCount", Integer.valueOf(paramawge.clickCount));
    paramContentValues.put("certifiedGrade", Long.valueOf(paramawge.certifiedGrade));
    paramContentValues.put("isSyncLbs", Boolean.valueOf(paramawge.isSyncLbs));
    paramContentValues.put("showFlag", Integer.valueOf(paramawge.showFlag));
    paramContentValues.put("mShowMsgFlag", Integer.valueOf(paramawge.mShowMsgFlag));
    paramContentValues.put("mIsAgreeSyncLbs", Boolean.valueOf(paramawge.mIsAgreeSyncLbs));
    paramContentValues.put("mIsSyncLbsSelected", Boolean.valueOf(paramawge.mIsSyncLbsSelected));
    paramContentValues.put("dateTime", Long.valueOf(paramawge.dateTime));
    paramContentValues.put("accountFlag", Integer.valueOf(paramawge.accountFlag));
    paramContentValues.put("accountFlag2", Long.valueOf(paramawge.accountFlag2));
    paramContentValues.put("eqqAccountFlag", Long.valueOf(paramawge.eqqAccountFlag));
    paramContentValues.put("isShieldMsg", Boolean.valueOf(paramawge.isShieldMsg));
    paramContentValues.put("messageSettingFlag", Integer.valueOf(paramawge.messageSettingFlag));
    paramContentValues.put("extendType", Integer.valueOf(paramawge.extendType));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramawge.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramawge.mCompareSpell);
    paramContentValues.put("logo", paramawge.logo);
    paramContentValues.put("lastAIOReadTime", Long.valueOf(paramawge.lastAIOReadTime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awgu
 * JD-Core Version:    0.7.0.1
 */