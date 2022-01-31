import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aule
  extends aula
{
  public aule()
  {
    this.a = 24;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramauko = (PublicAccountInfo)paramauko;
    if (paramaukz == null)
    {
      paramauko.uin = paramCursor.getLong(paramCursor.getColumnIndex("uin"));
      paramauko.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramauko.displayNumber = paramCursor.getString(paramCursor.getColumnIndex("displayNumber"));
      paramauko.summary = paramCursor.getString(paramCursor.getColumnIndex("summary"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isRecvMsg")))
      {
        paramBoolean = true;
        paramauko.isRecvMsg = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRecvPush"))) {
          break label498;
        }
        paramBoolean = true;
        label133:
        paramauko.isRecvPush = paramBoolean;
        paramauko.clickCount = paramCursor.getInt(paramCursor.getColumnIndex("clickCount"));
        paramauko.certifiedGrade = paramCursor.getLong(paramCursor.getColumnIndex("certifiedGrade"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSyncLbs"))) {
          break label503;
        }
        paramBoolean = true;
        label194:
        paramauko.isSyncLbs = paramBoolean;
        paramauko.showFlag = paramCursor.getInt(paramCursor.getColumnIndex("showFlag"));
        paramauko.mShowMsgFlag = paramCursor.getInt(paramCursor.getColumnIndex("mShowMsgFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mIsAgreeSyncLbs"))) {
          break label508;
        }
        paramBoolean = true;
        label255:
        paramauko.mIsAgreeSyncLbs = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mIsSyncLbsSelected"))) {
          break label513;
        }
        paramBoolean = true;
        label280:
        paramauko.mIsSyncLbsSelected = paramBoolean;
        paramauko.dateTime = paramCursor.getLong(paramCursor.getColumnIndex("dateTime"));
        paramauko.accountFlag = paramCursor.getInt(paramCursor.getColumnIndex("accountFlag"));
        paramauko.accountFlag2 = paramCursor.getLong(paramCursor.getColumnIndex("accountFlag2"));
        paramauko.eqqAccountFlag = paramCursor.getLong(paramCursor.getColumnIndex("eqqAccountFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShieldMsg"))) {
          break label518;
        }
      }
      label513:
      label518:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramauko.isShieldMsg = paramBoolean;
        paramauko.messageSettingFlag = paramCursor.getInt(paramCursor.getColumnIndex("messageSettingFlag"));
        paramauko.extendType = paramCursor.getInt(paramCursor.getColumnIndex("extendType"));
        paramauko.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramauko.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramauko.logo = paramCursor.getString(paramCursor.getColumnIndex("logo"));
        paramauko.lastAIOReadTime = paramCursor.getLong(paramCursor.getColumnIndex("lastAIOReadTime"));
        return paramauko;
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
      paramaukz.a(new NoColumnError("uin", Long.TYPE));
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label1375;
      }
      paramaukz.a(new NoColumnError("name", String.class));
      label592:
      i = paramCursor.getColumnIndex("displayNumber");
      if (i != -1) {
        break label1390;
      }
      paramaukz.a(new NoColumnError("displayNumber", String.class));
      label626:
      i = paramCursor.getColumnIndex("summary");
      if (i != -1) {
        break label1405;
      }
      paramaukz.a(new NoColumnError("summary", String.class));
      label660:
      i = paramCursor.getColumnIndex("isRecvMsg");
      if (i != -1) {
        break label1420;
      }
      paramaukz.a(new NoColumnError("isRecvMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRecvPush");
      if (i != -1) {
        break label1447;
      }
      paramaukz.a(new NoColumnError("isRecvPush", Boolean.TYPE));
      i = paramCursor.getColumnIndex("clickCount");
      if (i != -1) {
        break label1474;
      }
      paramaukz.a(new NoColumnError("clickCount", Integer.TYPE));
      label765:
      i = paramCursor.getColumnIndex("certifiedGrade");
      if (i != -1) {
        break label1489;
      }
      paramaukz.a(new NoColumnError("certifiedGrade", Long.TYPE));
      label800:
      i = paramCursor.getColumnIndex("isSyncLbs");
      if (i != -1) {
        break label1504;
      }
      paramaukz.a(new NoColumnError("isSyncLbs", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showFlag");
      if (i != -1) {
        break label1531;
      }
      paramaukz.a(new NoColumnError("showFlag", Integer.TYPE));
      label870:
      i = paramCursor.getColumnIndex("mShowMsgFlag");
      if (i != -1) {
        break label1546;
      }
      paramaukz.a(new NoColumnError("mShowMsgFlag", Integer.TYPE));
      label905:
      i = paramCursor.getColumnIndex("mIsAgreeSyncLbs");
      if (i != -1) {
        break label1561;
      }
      paramaukz.a(new NoColumnError("mIsAgreeSyncLbs", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mIsSyncLbsSelected");
      if (i != -1) {
        break label1588;
      }
      paramaukz.a(new NoColumnError("mIsSyncLbsSelected", Boolean.TYPE));
      i = paramCursor.getColumnIndex("dateTime");
      if (i != -1) {
        break label1615;
      }
      paramaukz.a(new NoColumnError("dateTime", Long.TYPE));
      label1010:
      i = paramCursor.getColumnIndex("accountFlag");
      if (i != -1) {
        break label1630;
      }
      paramaukz.a(new NoColumnError("accountFlag", Integer.TYPE));
      label1045:
      i = paramCursor.getColumnIndex("accountFlag2");
      if (i != -1) {
        break label1645;
      }
      paramaukz.a(new NoColumnError("accountFlag2", Long.TYPE));
      label1080:
      i = paramCursor.getColumnIndex("eqqAccountFlag");
      if (i != -1) {
        break label1660;
      }
      paramaukz.a(new NoColumnError("eqqAccountFlag", Long.TYPE));
      label1115:
      i = paramCursor.getColumnIndex("isShieldMsg");
      if (i != -1) {
        break label1675;
      }
      paramaukz.a(new NoColumnError("isShieldMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("messageSettingFlag");
      if (i != -1) {
        break label1703;
      }
      paramaukz.a(new NoColumnError("messageSettingFlag", Integer.TYPE));
      label1185:
      i = paramCursor.getColumnIndex("extendType");
      if (i != -1) {
        break label1718;
      }
      paramaukz.a(new NoColumnError("extendType", Integer.TYPE));
      label1220:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label1733;
      }
      paramaukz.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label1255:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label1748;
      }
      paramaukz.a(new NoColumnError("mCompareSpell", String.class));
      label1289:
      i = paramCursor.getColumnIndex("logo");
      if (i != -1) {
        break label1763;
      }
      paramaukz.a(new NoColumnError("logo", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("lastAIOReadTime");
      if (i != -1) {
        break label1778;
      }
      paramaukz.a(new NoColumnError("lastAIOReadTime", Long.TYPE));
      return paramauko;
      paramauko.uin = paramCursor.getLong(i);
      break;
      label1375:
      paramauko.name = paramCursor.getString(i);
      break label592;
      label1390:
      paramauko.displayNumber = paramCursor.getString(i);
      break label626;
      label1405:
      paramauko.summary = paramCursor.getString(i);
      break label660;
      label1420:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isRecvMsg = paramBoolean;
        break;
      }
      label1447:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isRecvPush = paramBoolean;
        break;
      }
      label1474:
      paramauko.clickCount = paramCursor.getInt(i);
      break label765;
      label1489:
      paramauko.certifiedGrade = paramCursor.getLong(i);
      break label800;
      label1504:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isSyncLbs = paramBoolean;
        break;
      }
      label1531:
      paramauko.showFlag = paramCursor.getInt(i);
      break label870;
      label1546:
      paramauko.mShowMsgFlag = paramCursor.getInt(i);
      break label905;
      label1561:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.mIsAgreeSyncLbs = paramBoolean;
        break;
      }
      label1588:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.mIsSyncLbsSelected = paramBoolean;
        break;
      }
      label1615:
      paramauko.dateTime = paramCursor.getLong(i);
      break label1010;
      label1630:
      paramauko.accountFlag = paramCursor.getInt(i);
      break label1045;
      label1645:
      paramauko.accountFlag2 = paramCursor.getLong(i);
      break label1080;
      label1660:
      paramauko.eqqAccountFlag = paramCursor.getLong(i);
      break label1115;
      label1675:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramauko.isShieldMsg = paramBoolean;
        break;
      }
      label1703:
      paramauko.messageSettingFlag = paramCursor.getInt(i);
      break label1185;
      label1718:
      paramauko.extendType = paramCursor.getInt(i);
      break label1220;
      label1733:
      paramauko.mComparePartInt = paramCursor.getInt(i);
      break label1255;
      label1748:
      paramauko.mCompareSpell = paramCursor.getString(i);
      break label1289;
      label1763:
      paramauko.logo = paramCursor.getString(i);
    }
    label1778:
    paramauko.lastAIOReadTime = paramCursor.getLong(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin INTEGER UNIQUE ,name TEXT ,displayNumber TEXT ,summary TEXT ,isRecvMsg INTEGER ,isRecvPush INTEGER ,clickCount INTEGER ,certifiedGrade INTEGER ,isSyncLbs INTEGER ,showFlag INTEGER ,mShowMsgFlag INTEGER ,mIsAgreeSyncLbs INTEGER ,mIsSyncLbsSelected INTEGER ,dateTime INTEGER ,accountFlag INTEGER ,accountFlag2 INTEGER ,eqqAccountFlag INTEGER ,isShieldMsg INTEGER ,messageSettingFlag INTEGER ,extendType INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,logo TEXT ,lastAIOReadTime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (PublicAccountInfo)paramauko;
    paramContentValues.put("uin", Long.valueOf(paramauko.uin));
    paramContentValues.put("name", paramauko.name);
    paramContentValues.put("displayNumber", paramauko.displayNumber);
    paramContentValues.put("summary", paramauko.summary);
    paramContentValues.put("isRecvMsg", Boolean.valueOf(paramauko.isRecvMsg));
    paramContentValues.put("isRecvPush", Boolean.valueOf(paramauko.isRecvPush));
    paramContentValues.put("clickCount", Integer.valueOf(paramauko.clickCount));
    paramContentValues.put("certifiedGrade", Long.valueOf(paramauko.certifiedGrade));
    paramContentValues.put("isSyncLbs", Boolean.valueOf(paramauko.isSyncLbs));
    paramContentValues.put("showFlag", Integer.valueOf(paramauko.showFlag));
    paramContentValues.put("mShowMsgFlag", Integer.valueOf(paramauko.mShowMsgFlag));
    paramContentValues.put("mIsAgreeSyncLbs", Boolean.valueOf(paramauko.mIsAgreeSyncLbs));
    paramContentValues.put("mIsSyncLbsSelected", Boolean.valueOf(paramauko.mIsSyncLbsSelected));
    paramContentValues.put("dateTime", Long.valueOf(paramauko.dateTime));
    paramContentValues.put("accountFlag", Integer.valueOf(paramauko.accountFlag));
    paramContentValues.put("accountFlag2", Long.valueOf(paramauko.accountFlag2));
    paramContentValues.put("eqqAccountFlag", Long.valueOf(paramauko.eqqAccountFlag));
    paramContentValues.put("isShieldMsg", Boolean.valueOf(paramauko.isShieldMsg));
    paramContentValues.put("messageSettingFlag", Integer.valueOf(paramauko.messageSettingFlag));
    paramContentValues.put("extendType", Integer.valueOf(paramauko.extendType));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramauko.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramauko.mCompareSpell);
    paramContentValues.put("logo", paramauko.logo);
    paramContentValues.put("lastAIOReadTime", Long.valueOf(paramauko.lastAIOReadTime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aule
 * JD-Core Version:    0.7.0.1
 */