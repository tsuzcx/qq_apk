import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aulc
  extends auky
{
  public aulc()
  {
    this.a = 24;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramaukm = (PublicAccountInfo)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.uin = paramCursor.getLong(paramCursor.getColumnIndex("uin"));
      paramaukm.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramaukm.displayNumber = paramCursor.getString(paramCursor.getColumnIndex("displayNumber"));
      paramaukm.summary = paramCursor.getString(paramCursor.getColumnIndex("summary"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isRecvMsg")))
      {
        paramBoolean = true;
        paramaukm.isRecvMsg = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRecvPush"))) {
          break label498;
        }
        paramBoolean = true;
        label133:
        paramaukm.isRecvPush = paramBoolean;
        paramaukm.clickCount = paramCursor.getInt(paramCursor.getColumnIndex("clickCount"));
        paramaukm.certifiedGrade = paramCursor.getLong(paramCursor.getColumnIndex("certifiedGrade"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSyncLbs"))) {
          break label503;
        }
        paramBoolean = true;
        label194:
        paramaukm.isSyncLbs = paramBoolean;
        paramaukm.showFlag = paramCursor.getInt(paramCursor.getColumnIndex("showFlag"));
        paramaukm.mShowMsgFlag = paramCursor.getInt(paramCursor.getColumnIndex("mShowMsgFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mIsAgreeSyncLbs"))) {
          break label508;
        }
        paramBoolean = true;
        label255:
        paramaukm.mIsAgreeSyncLbs = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mIsSyncLbsSelected"))) {
          break label513;
        }
        paramBoolean = true;
        label280:
        paramaukm.mIsSyncLbsSelected = paramBoolean;
        paramaukm.dateTime = paramCursor.getLong(paramCursor.getColumnIndex("dateTime"));
        paramaukm.accountFlag = paramCursor.getInt(paramCursor.getColumnIndex("accountFlag"));
        paramaukm.accountFlag2 = paramCursor.getLong(paramCursor.getColumnIndex("accountFlag2"));
        paramaukm.eqqAccountFlag = paramCursor.getLong(paramCursor.getColumnIndex("eqqAccountFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShieldMsg"))) {
          break label518;
        }
      }
      label513:
      label518:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramaukm.isShieldMsg = paramBoolean;
        paramaukm.messageSettingFlag = paramCursor.getInt(paramCursor.getColumnIndex("messageSettingFlag"));
        paramaukm.extendType = paramCursor.getInt(paramCursor.getColumnIndex("extendType"));
        paramaukm.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramaukm.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramaukm.logo = paramCursor.getString(paramCursor.getColumnIndex("logo"));
        paramaukm.lastAIOReadTime = paramCursor.getLong(paramCursor.getColumnIndex("lastAIOReadTime"));
        return paramaukm;
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
      paramaukx.a(new NoColumnError("uin", Long.TYPE));
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label1375;
      }
      paramaukx.a(new NoColumnError("name", String.class));
      label592:
      i = paramCursor.getColumnIndex("displayNumber");
      if (i != -1) {
        break label1390;
      }
      paramaukx.a(new NoColumnError("displayNumber", String.class));
      label626:
      i = paramCursor.getColumnIndex("summary");
      if (i != -1) {
        break label1405;
      }
      paramaukx.a(new NoColumnError("summary", String.class));
      label660:
      i = paramCursor.getColumnIndex("isRecvMsg");
      if (i != -1) {
        break label1420;
      }
      paramaukx.a(new NoColumnError("isRecvMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRecvPush");
      if (i != -1) {
        break label1447;
      }
      paramaukx.a(new NoColumnError("isRecvPush", Boolean.TYPE));
      i = paramCursor.getColumnIndex("clickCount");
      if (i != -1) {
        break label1474;
      }
      paramaukx.a(new NoColumnError("clickCount", Integer.TYPE));
      label765:
      i = paramCursor.getColumnIndex("certifiedGrade");
      if (i != -1) {
        break label1489;
      }
      paramaukx.a(new NoColumnError("certifiedGrade", Long.TYPE));
      label800:
      i = paramCursor.getColumnIndex("isSyncLbs");
      if (i != -1) {
        break label1504;
      }
      paramaukx.a(new NoColumnError("isSyncLbs", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showFlag");
      if (i != -1) {
        break label1531;
      }
      paramaukx.a(new NoColumnError("showFlag", Integer.TYPE));
      label870:
      i = paramCursor.getColumnIndex("mShowMsgFlag");
      if (i != -1) {
        break label1546;
      }
      paramaukx.a(new NoColumnError("mShowMsgFlag", Integer.TYPE));
      label905:
      i = paramCursor.getColumnIndex("mIsAgreeSyncLbs");
      if (i != -1) {
        break label1561;
      }
      paramaukx.a(new NoColumnError("mIsAgreeSyncLbs", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mIsSyncLbsSelected");
      if (i != -1) {
        break label1588;
      }
      paramaukx.a(new NoColumnError("mIsSyncLbsSelected", Boolean.TYPE));
      i = paramCursor.getColumnIndex("dateTime");
      if (i != -1) {
        break label1615;
      }
      paramaukx.a(new NoColumnError("dateTime", Long.TYPE));
      label1010:
      i = paramCursor.getColumnIndex("accountFlag");
      if (i != -1) {
        break label1630;
      }
      paramaukx.a(new NoColumnError("accountFlag", Integer.TYPE));
      label1045:
      i = paramCursor.getColumnIndex("accountFlag2");
      if (i != -1) {
        break label1645;
      }
      paramaukx.a(new NoColumnError("accountFlag2", Long.TYPE));
      label1080:
      i = paramCursor.getColumnIndex("eqqAccountFlag");
      if (i != -1) {
        break label1660;
      }
      paramaukx.a(new NoColumnError("eqqAccountFlag", Long.TYPE));
      label1115:
      i = paramCursor.getColumnIndex("isShieldMsg");
      if (i != -1) {
        break label1675;
      }
      paramaukx.a(new NoColumnError("isShieldMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("messageSettingFlag");
      if (i != -1) {
        break label1703;
      }
      paramaukx.a(new NoColumnError("messageSettingFlag", Integer.TYPE));
      label1185:
      i = paramCursor.getColumnIndex("extendType");
      if (i != -1) {
        break label1718;
      }
      paramaukx.a(new NoColumnError("extendType", Integer.TYPE));
      label1220:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label1733;
      }
      paramaukx.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label1255:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label1748;
      }
      paramaukx.a(new NoColumnError("mCompareSpell", String.class));
      label1289:
      i = paramCursor.getColumnIndex("logo");
      if (i != -1) {
        break label1763;
      }
      paramaukx.a(new NoColumnError("logo", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("lastAIOReadTime");
      if (i != -1) {
        break label1778;
      }
      paramaukx.a(new NoColumnError("lastAIOReadTime", Long.TYPE));
      return paramaukm;
      paramaukm.uin = paramCursor.getLong(i);
      break;
      label1375:
      paramaukm.name = paramCursor.getString(i);
      break label592;
      label1390:
      paramaukm.displayNumber = paramCursor.getString(i);
      break label626;
      label1405:
      paramaukm.summary = paramCursor.getString(i);
      break label660;
      label1420:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isRecvMsg = paramBoolean;
        break;
      }
      label1447:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isRecvPush = paramBoolean;
        break;
      }
      label1474:
      paramaukm.clickCount = paramCursor.getInt(i);
      break label765;
      label1489:
      paramaukm.certifiedGrade = paramCursor.getLong(i);
      break label800;
      label1504:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isSyncLbs = paramBoolean;
        break;
      }
      label1531:
      paramaukm.showFlag = paramCursor.getInt(i);
      break label870;
      label1546:
      paramaukm.mShowMsgFlag = paramCursor.getInt(i);
      break label905;
      label1561:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.mIsAgreeSyncLbs = paramBoolean;
        break;
      }
      label1588:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.mIsSyncLbsSelected = paramBoolean;
        break;
      }
      label1615:
      paramaukm.dateTime = paramCursor.getLong(i);
      break label1010;
      label1630:
      paramaukm.accountFlag = paramCursor.getInt(i);
      break label1045;
      label1645:
      paramaukm.accountFlag2 = paramCursor.getLong(i);
      break label1080;
      label1660:
      paramaukm.eqqAccountFlag = paramCursor.getLong(i);
      break label1115;
      label1675:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramaukm.isShieldMsg = paramBoolean;
        break;
      }
      label1703:
      paramaukm.messageSettingFlag = paramCursor.getInt(i);
      break label1185;
      label1718:
      paramaukm.extendType = paramCursor.getInt(i);
      break label1220;
      label1733:
      paramaukm.mComparePartInt = paramCursor.getInt(i);
      break label1255;
      label1748:
      paramaukm.mCompareSpell = paramCursor.getString(i);
      break label1289;
      label1763:
      paramaukm.logo = paramCursor.getString(i);
    }
    label1778:
    paramaukm.lastAIOReadTime = paramCursor.getLong(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin INTEGER UNIQUE ,name TEXT ,displayNumber TEXT ,summary TEXT ,isRecvMsg INTEGER ,isRecvPush INTEGER ,clickCount INTEGER ,certifiedGrade INTEGER ,isSyncLbs INTEGER ,showFlag INTEGER ,mShowMsgFlag INTEGER ,mIsAgreeSyncLbs INTEGER ,mIsSyncLbsSelected INTEGER ,dateTime INTEGER ,accountFlag INTEGER ,accountFlag2 INTEGER ,eqqAccountFlag INTEGER ,isShieldMsg INTEGER ,messageSettingFlag INTEGER ,extendType INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,logo TEXT ,lastAIOReadTime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (PublicAccountInfo)paramaukm;
    paramContentValues.put("uin", Long.valueOf(paramaukm.uin));
    paramContentValues.put("name", paramaukm.name);
    paramContentValues.put("displayNumber", paramaukm.displayNumber);
    paramContentValues.put("summary", paramaukm.summary);
    paramContentValues.put("isRecvMsg", Boolean.valueOf(paramaukm.isRecvMsg));
    paramContentValues.put("isRecvPush", Boolean.valueOf(paramaukm.isRecvPush));
    paramContentValues.put("clickCount", Integer.valueOf(paramaukm.clickCount));
    paramContentValues.put("certifiedGrade", Long.valueOf(paramaukm.certifiedGrade));
    paramContentValues.put("isSyncLbs", Boolean.valueOf(paramaukm.isSyncLbs));
    paramContentValues.put("showFlag", Integer.valueOf(paramaukm.showFlag));
    paramContentValues.put("mShowMsgFlag", Integer.valueOf(paramaukm.mShowMsgFlag));
    paramContentValues.put("mIsAgreeSyncLbs", Boolean.valueOf(paramaukm.mIsAgreeSyncLbs));
    paramContentValues.put("mIsSyncLbsSelected", Boolean.valueOf(paramaukm.mIsSyncLbsSelected));
    paramContentValues.put("dateTime", Long.valueOf(paramaukm.dateTime));
    paramContentValues.put("accountFlag", Integer.valueOf(paramaukm.accountFlag));
    paramContentValues.put("accountFlag2", Long.valueOf(paramaukm.accountFlag2));
    paramContentValues.put("eqqAccountFlag", Long.valueOf(paramaukm.eqqAccountFlag));
    paramContentValues.put("isShieldMsg", Boolean.valueOf(paramaukm.isShieldMsg));
    paramContentValues.put("messageSettingFlag", Integer.valueOf(paramaukm.messageSettingFlag));
    paramContentValues.put("extendType", Integer.valueOf(paramaukm.extendType));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramaukm.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramaukm.mCompareSpell);
    paramContentValues.put("logo", paramaukm.logo);
    paramContentValues.put("lastAIOReadTime", Long.valueOf(paramaukm.lastAIOReadTime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulc
 * JD-Core Version:    0.7.0.1
 */