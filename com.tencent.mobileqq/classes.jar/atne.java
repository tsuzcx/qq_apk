import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atne
  extends atna
{
  public atne()
  {
    this.a = 24;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramatmo = (PublicAccountInfo)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.uin = paramCursor.getLong(paramCursor.getColumnIndex("uin"));
      paramatmo.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramatmo.displayNumber = paramCursor.getString(paramCursor.getColumnIndex("displayNumber"));
      paramatmo.summary = paramCursor.getString(paramCursor.getColumnIndex("summary"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isRecvMsg")))
      {
        paramBoolean = true;
        paramatmo.isRecvMsg = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRecvPush"))) {
          break label498;
        }
        paramBoolean = true;
        label133:
        paramatmo.isRecvPush = paramBoolean;
        paramatmo.clickCount = paramCursor.getInt(paramCursor.getColumnIndex("clickCount"));
        paramatmo.certifiedGrade = paramCursor.getLong(paramCursor.getColumnIndex("certifiedGrade"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSyncLbs"))) {
          break label503;
        }
        paramBoolean = true;
        label194:
        paramatmo.isSyncLbs = paramBoolean;
        paramatmo.showFlag = paramCursor.getInt(paramCursor.getColumnIndex("showFlag"));
        paramatmo.mShowMsgFlag = paramCursor.getInt(paramCursor.getColumnIndex("mShowMsgFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mIsAgreeSyncLbs"))) {
          break label508;
        }
        paramBoolean = true;
        label255:
        paramatmo.mIsAgreeSyncLbs = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mIsSyncLbsSelected"))) {
          break label513;
        }
        paramBoolean = true;
        label280:
        paramatmo.mIsSyncLbsSelected = paramBoolean;
        paramatmo.dateTime = paramCursor.getLong(paramCursor.getColumnIndex("dateTime"));
        paramatmo.accountFlag = paramCursor.getInt(paramCursor.getColumnIndex("accountFlag"));
        paramatmo.accountFlag2 = paramCursor.getLong(paramCursor.getColumnIndex("accountFlag2"));
        paramatmo.eqqAccountFlag = paramCursor.getLong(paramCursor.getColumnIndex("eqqAccountFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShieldMsg"))) {
          break label518;
        }
      }
      label513:
      label518:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramatmo.isShieldMsg = paramBoolean;
        paramatmo.messageSettingFlag = paramCursor.getInt(paramCursor.getColumnIndex("messageSettingFlag"));
        paramatmo.extendType = paramCursor.getInt(paramCursor.getColumnIndex("extendType"));
        paramatmo.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramatmo.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramatmo.logo = paramCursor.getString(paramCursor.getColumnIndex("logo"));
        paramatmo.lastAIOReadTime = paramCursor.getLong(paramCursor.getColumnIndex("lastAIOReadTime"));
        return paramatmo;
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
      paramatmz.a(new NoColumnError("uin", Long.TYPE));
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label1375;
      }
      paramatmz.a(new NoColumnError("name", String.class));
      label592:
      i = paramCursor.getColumnIndex("displayNumber");
      if (i != -1) {
        break label1390;
      }
      paramatmz.a(new NoColumnError("displayNumber", String.class));
      label626:
      i = paramCursor.getColumnIndex("summary");
      if (i != -1) {
        break label1405;
      }
      paramatmz.a(new NoColumnError("summary", String.class));
      label660:
      i = paramCursor.getColumnIndex("isRecvMsg");
      if (i != -1) {
        break label1420;
      }
      paramatmz.a(new NoColumnError("isRecvMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRecvPush");
      if (i != -1) {
        break label1447;
      }
      paramatmz.a(new NoColumnError("isRecvPush", Boolean.TYPE));
      i = paramCursor.getColumnIndex("clickCount");
      if (i != -1) {
        break label1474;
      }
      paramatmz.a(new NoColumnError("clickCount", Integer.TYPE));
      label765:
      i = paramCursor.getColumnIndex("certifiedGrade");
      if (i != -1) {
        break label1489;
      }
      paramatmz.a(new NoColumnError("certifiedGrade", Long.TYPE));
      label800:
      i = paramCursor.getColumnIndex("isSyncLbs");
      if (i != -1) {
        break label1504;
      }
      paramatmz.a(new NoColumnError("isSyncLbs", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showFlag");
      if (i != -1) {
        break label1531;
      }
      paramatmz.a(new NoColumnError("showFlag", Integer.TYPE));
      label870:
      i = paramCursor.getColumnIndex("mShowMsgFlag");
      if (i != -1) {
        break label1546;
      }
      paramatmz.a(new NoColumnError("mShowMsgFlag", Integer.TYPE));
      label905:
      i = paramCursor.getColumnIndex("mIsAgreeSyncLbs");
      if (i != -1) {
        break label1561;
      }
      paramatmz.a(new NoColumnError("mIsAgreeSyncLbs", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mIsSyncLbsSelected");
      if (i != -1) {
        break label1588;
      }
      paramatmz.a(new NoColumnError("mIsSyncLbsSelected", Boolean.TYPE));
      i = paramCursor.getColumnIndex("dateTime");
      if (i != -1) {
        break label1615;
      }
      paramatmz.a(new NoColumnError("dateTime", Long.TYPE));
      label1010:
      i = paramCursor.getColumnIndex("accountFlag");
      if (i != -1) {
        break label1630;
      }
      paramatmz.a(new NoColumnError("accountFlag", Integer.TYPE));
      label1045:
      i = paramCursor.getColumnIndex("accountFlag2");
      if (i != -1) {
        break label1645;
      }
      paramatmz.a(new NoColumnError("accountFlag2", Long.TYPE));
      label1080:
      i = paramCursor.getColumnIndex("eqqAccountFlag");
      if (i != -1) {
        break label1660;
      }
      paramatmz.a(new NoColumnError("eqqAccountFlag", Long.TYPE));
      label1115:
      i = paramCursor.getColumnIndex("isShieldMsg");
      if (i != -1) {
        break label1675;
      }
      paramatmz.a(new NoColumnError("isShieldMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("messageSettingFlag");
      if (i != -1) {
        break label1703;
      }
      paramatmz.a(new NoColumnError("messageSettingFlag", Integer.TYPE));
      label1185:
      i = paramCursor.getColumnIndex("extendType");
      if (i != -1) {
        break label1718;
      }
      paramatmz.a(new NoColumnError("extendType", Integer.TYPE));
      label1220:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label1733;
      }
      paramatmz.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label1255:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label1748;
      }
      paramatmz.a(new NoColumnError("mCompareSpell", String.class));
      label1289:
      i = paramCursor.getColumnIndex("logo");
      if (i != -1) {
        break label1763;
      }
      paramatmz.a(new NoColumnError("logo", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("lastAIOReadTime");
      if (i != -1) {
        break label1778;
      }
      paramatmz.a(new NoColumnError("lastAIOReadTime", Long.TYPE));
      return paramatmo;
      paramatmo.uin = paramCursor.getLong(i);
      break;
      label1375:
      paramatmo.name = paramCursor.getString(i);
      break label592;
      label1390:
      paramatmo.displayNumber = paramCursor.getString(i);
      break label626;
      label1405:
      paramatmo.summary = paramCursor.getString(i);
      break label660;
      label1420:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isRecvMsg = paramBoolean;
        break;
      }
      label1447:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isRecvPush = paramBoolean;
        break;
      }
      label1474:
      paramatmo.clickCount = paramCursor.getInt(i);
      break label765;
      label1489:
      paramatmo.certifiedGrade = paramCursor.getLong(i);
      break label800;
      label1504:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isSyncLbs = paramBoolean;
        break;
      }
      label1531:
      paramatmo.showFlag = paramCursor.getInt(i);
      break label870;
      label1546:
      paramatmo.mShowMsgFlag = paramCursor.getInt(i);
      break label905;
      label1561:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.mIsAgreeSyncLbs = paramBoolean;
        break;
      }
      label1588:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.mIsSyncLbsSelected = paramBoolean;
        break;
      }
      label1615:
      paramatmo.dateTime = paramCursor.getLong(i);
      break label1010;
      label1630:
      paramatmo.accountFlag = paramCursor.getInt(i);
      break label1045;
      label1645:
      paramatmo.accountFlag2 = paramCursor.getLong(i);
      break label1080;
      label1660:
      paramatmo.eqqAccountFlag = paramCursor.getLong(i);
      break label1115;
      label1675:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramatmo.isShieldMsg = paramBoolean;
        break;
      }
      label1703:
      paramatmo.messageSettingFlag = paramCursor.getInt(i);
      break label1185;
      label1718:
      paramatmo.extendType = paramCursor.getInt(i);
      break label1220;
      label1733:
      paramatmo.mComparePartInt = paramCursor.getInt(i);
      break label1255;
      label1748:
      paramatmo.mCompareSpell = paramCursor.getString(i);
      break label1289;
      label1763:
      paramatmo.logo = paramCursor.getString(i);
    }
    label1778:
    paramatmo.lastAIOReadTime = paramCursor.getLong(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin INTEGER UNIQUE ,name TEXT ,displayNumber TEXT ,summary TEXT ,isRecvMsg INTEGER ,isRecvPush INTEGER ,clickCount INTEGER ,certifiedGrade INTEGER ,isSyncLbs INTEGER ,showFlag INTEGER ,mShowMsgFlag INTEGER ,mIsAgreeSyncLbs INTEGER ,mIsSyncLbsSelected INTEGER ,dateTime INTEGER ,accountFlag INTEGER ,accountFlag2 INTEGER ,eqqAccountFlag INTEGER ,isShieldMsg INTEGER ,messageSettingFlag INTEGER ,extendType INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,logo TEXT ,lastAIOReadTime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (PublicAccountInfo)paramatmo;
    paramContentValues.put("uin", Long.valueOf(paramatmo.uin));
    paramContentValues.put("name", paramatmo.name);
    paramContentValues.put("displayNumber", paramatmo.displayNumber);
    paramContentValues.put("summary", paramatmo.summary);
    paramContentValues.put("isRecvMsg", Boolean.valueOf(paramatmo.isRecvMsg));
    paramContentValues.put("isRecvPush", Boolean.valueOf(paramatmo.isRecvPush));
    paramContentValues.put("clickCount", Integer.valueOf(paramatmo.clickCount));
    paramContentValues.put("certifiedGrade", Long.valueOf(paramatmo.certifiedGrade));
    paramContentValues.put("isSyncLbs", Boolean.valueOf(paramatmo.isSyncLbs));
    paramContentValues.put("showFlag", Integer.valueOf(paramatmo.showFlag));
    paramContentValues.put("mShowMsgFlag", Integer.valueOf(paramatmo.mShowMsgFlag));
    paramContentValues.put("mIsAgreeSyncLbs", Boolean.valueOf(paramatmo.mIsAgreeSyncLbs));
    paramContentValues.put("mIsSyncLbsSelected", Boolean.valueOf(paramatmo.mIsSyncLbsSelected));
    paramContentValues.put("dateTime", Long.valueOf(paramatmo.dateTime));
    paramContentValues.put("accountFlag", Integer.valueOf(paramatmo.accountFlag));
    paramContentValues.put("accountFlag2", Long.valueOf(paramatmo.accountFlag2));
    paramContentValues.put("eqqAccountFlag", Long.valueOf(paramatmo.eqqAccountFlag));
    paramContentValues.put("isShieldMsg", Boolean.valueOf(paramatmo.isShieldMsg));
    paramContentValues.put("messageSettingFlag", Integer.valueOf(paramatmo.messageSettingFlag));
    paramContentValues.put("extendType", Integer.valueOf(paramatmo.extendType));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramatmo.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramatmo.mCompareSpell);
    paramContentValues.put("logo", paramatmo.logo);
    paramContentValues.put("lastAIOReadTime", Long.valueOf(paramatmo.lastAIOReadTime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atne
 * JD-Core Version:    0.7.0.1
 */