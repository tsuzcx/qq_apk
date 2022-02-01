import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class azhw
  extends OGAbstractDao
{
  public azhw()
  {
    this.columnLen = 24;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (PublicAccountInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getLong(paramCursor.getColumnIndex("uin"));
      paramEntity.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramEntity.displayNumber = paramCursor.getString(paramCursor.getColumnIndex("displayNumber"));
      paramEntity.summary = paramCursor.getString(paramCursor.getColumnIndex("summary"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isRecvMsg")))
      {
        paramBoolean = true;
        paramEntity.isRecvMsg = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRecvPush"))) {
          break label498;
        }
        paramBoolean = true;
        label133:
        paramEntity.isRecvPush = paramBoolean;
        paramEntity.clickCount = paramCursor.getInt(paramCursor.getColumnIndex("clickCount"));
        paramEntity.certifiedGrade = paramCursor.getLong(paramCursor.getColumnIndex("certifiedGrade"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSyncLbs"))) {
          break label503;
        }
        paramBoolean = true;
        label194:
        paramEntity.isSyncLbs = paramBoolean;
        paramEntity.showFlag = paramCursor.getInt(paramCursor.getColumnIndex("showFlag"));
        paramEntity.mShowMsgFlag = paramCursor.getInt(paramCursor.getColumnIndex("mShowMsgFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mIsAgreeSyncLbs"))) {
          break label508;
        }
        paramBoolean = true;
        label255:
        paramEntity.mIsAgreeSyncLbs = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mIsSyncLbsSelected"))) {
          break label513;
        }
        paramBoolean = true;
        label280:
        paramEntity.mIsSyncLbsSelected = paramBoolean;
        paramEntity.dateTime = paramCursor.getLong(paramCursor.getColumnIndex("dateTime"));
        paramEntity.accountFlag = paramCursor.getInt(paramCursor.getColumnIndex("accountFlag"));
        paramEntity.accountFlag2 = paramCursor.getLong(paramCursor.getColumnIndex("accountFlag2"));
        paramEntity.eqqAccountFlag = paramCursor.getLong(paramCursor.getColumnIndex("eqqAccountFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShieldMsg"))) {
          break label518;
        }
      }
      label513:
      label518:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.isShieldMsg = paramBoolean;
        paramEntity.messageSettingFlag = paramCursor.getInt(paramCursor.getColumnIndex("messageSettingFlag"));
        paramEntity.extendType = paramCursor.getInt(paramCursor.getColumnIndex("extendType"));
        paramEntity.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramEntity.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramEntity.logo = paramCursor.getString(paramCursor.getColumnIndex("logo"));
        paramEntity.lastAIOReadTime = paramCursor.getLong(paramCursor.getColumnIndex("lastAIOReadTime"));
        return paramEntity;
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
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", Long.TYPE));
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label1375;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("name", String.class));
      label592:
      i = paramCursor.getColumnIndex("displayNumber");
      if (i != -1) {
        break label1390;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("displayNumber", String.class));
      label626:
      i = paramCursor.getColumnIndex("summary");
      if (i != -1) {
        break label1405;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("summary", String.class));
      label660:
      i = paramCursor.getColumnIndex("isRecvMsg");
      if (i != -1) {
        break label1420;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isRecvMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRecvPush");
      if (i != -1) {
        break label1447;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isRecvPush", Boolean.TYPE));
      i = paramCursor.getColumnIndex("clickCount");
      if (i != -1) {
        break label1474;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("clickCount", Integer.TYPE));
      label765:
      i = paramCursor.getColumnIndex("certifiedGrade");
      if (i != -1) {
        break label1489;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("certifiedGrade", Long.TYPE));
      label800:
      i = paramCursor.getColumnIndex("isSyncLbs");
      if (i != -1) {
        break label1504;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isSyncLbs", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showFlag");
      if (i != -1) {
        break label1531;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showFlag", Integer.TYPE));
      label870:
      i = paramCursor.getColumnIndex("mShowMsgFlag");
      if (i != -1) {
        break label1546;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mShowMsgFlag", Integer.TYPE));
      label905:
      i = paramCursor.getColumnIndex("mIsAgreeSyncLbs");
      if (i != -1) {
        break label1561;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mIsAgreeSyncLbs", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mIsSyncLbsSelected");
      if (i != -1) {
        break label1588;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mIsSyncLbsSelected", Boolean.TYPE));
      i = paramCursor.getColumnIndex("dateTime");
      if (i != -1) {
        break label1615;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dateTime", Long.TYPE));
      label1010:
      i = paramCursor.getColumnIndex("accountFlag");
      if (i != -1) {
        break label1630;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("accountFlag", Integer.TYPE));
      label1045:
      i = paramCursor.getColumnIndex("accountFlag2");
      if (i != -1) {
        break label1645;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("accountFlag2", Long.TYPE));
      label1080:
      i = paramCursor.getColumnIndex("eqqAccountFlag");
      if (i != -1) {
        break label1660;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("eqqAccountFlag", Long.TYPE));
      label1115:
      i = paramCursor.getColumnIndex("isShieldMsg");
      if (i != -1) {
        break label1675;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isShieldMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("messageSettingFlag");
      if (i != -1) {
        break label1703;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("messageSettingFlag", Integer.TYPE));
      label1185:
      i = paramCursor.getColumnIndex("extendType");
      if (i != -1) {
        break label1718;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extendType", Integer.TYPE));
      label1220:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label1733;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mComparePartInt", Integer.TYPE));
      label1255:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label1748;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mCompareSpell", String.class));
      label1289:
      i = paramCursor.getColumnIndex("logo");
      if (i != -1) {
        break label1763;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("logo", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("lastAIOReadTime");
      if (i != -1) {
        break label1778;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastAIOReadTime", Long.TYPE));
      return paramEntity;
      paramEntity.uin = paramCursor.getLong(i);
      break;
      label1375:
      paramEntity.name = paramCursor.getString(i);
      break label592;
      label1390:
      paramEntity.displayNumber = paramCursor.getString(i);
      break label626;
      label1405:
      paramEntity.summary = paramCursor.getString(i);
      break label660;
      label1420:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isRecvMsg = paramBoolean;
        break;
      }
      label1447:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isRecvPush = paramBoolean;
        break;
      }
      label1474:
      paramEntity.clickCount = paramCursor.getInt(i);
      break label765;
      label1489:
      paramEntity.certifiedGrade = paramCursor.getLong(i);
      break label800;
      label1504:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSyncLbs = paramBoolean;
        break;
      }
      label1531:
      paramEntity.showFlag = paramCursor.getInt(i);
      break label870;
      label1546:
      paramEntity.mShowMsgFlag = paramCursor.getInt(i);
      break label905;
      label1561:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.mIsAgreeSyncLbs = paramBoolean;
        break;
      }
      label1588:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.mIsSyncLbsSelected = paramBoolean;
        break;
      }
      label1615:
      paramEntity.dateTime = paramCursor.getLong(i);
      break label1010;
      label1630:
      paramEntity.accountFlag = paramCursor.getInt(i);
      break label1045;
      label1645:
      paramEntity.accountFlag2 = paramCursor.getLong(i);
      break label1080;
      label1660:
      paramEntity.eqqAccountFlag = paramCursor.getLong(i);
      break label1115;
      label1675:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.isShieldMsg = paramBoolean;
        break;
      }
      label1703:
      paramEntity.messageSettingFlag = paramCursor.getInt(i);
      break label1185;
      label1718:
      paramEntity.extendType = paramCursor.getInt(i);
      break label1220;
      label1733:
      paramEntity.mComparePartInt = paramCursor.getInt(i);
      break label1255;
      label1748:
      paramEntity.mCompareSpell = paramCursor.getString(i);
      break label1289;
      label1763:
      paramEntity.logo = paramCursor.getString(i);
    }
    label1778:
    paramEntity.lastAIOReadTime = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (PublicAccountInfo)paramEntity;
    paramContentValues.put("uin", Long.valueOf(paramEntity.uin));
    paramContentValues.put("name", paramEntity.name);
    paramContentValues.put("displayNumber", paramEntity.displayNumber);
    paramContentValues.put("summary", paramEntity.summary);
    paramContentValues.put("isRecvMsg", Boolean.valueOf(paramEntity.isRecvMsg));
    paramContentValues.put("isRecvPush", Boolean.valueOf(paramEntity.isRecvPush));
    paramContentValues.put("clickCount", Integer.valueOf(paramEntity.clickCount));
    paramContentValues.put("certifiedGrade", Long.valueOf(paramEntity.certifiedGrade));
    paramContentValues.put("isSyncLbs", Boolean.valueOf(paramEntity.isSyncLbs));
    paramContentValues.put("showFlag", Integer.valueOf(paramEntity.showFlag));
    paramContentValues.put("mShowMsgFlag", Integer.valueOf(paramEntity.mShowMsgFlag));
    paramContentValues.put("mIsAgreeSyncLbs", Boolean.valueOf(paramEntity.mIsAgreeSyncLbs));
    paramContentValues.put("mIsSyncLbsSelected", Boolean.valueOf(paramEntity.mIsSyncLbsSelected));
    paramContentValues.put("dateTime", Long.valueOf(paramEntity.dateTime));
    paramContentValues.put("accountFlag", Integer.valueOf(paramEntity.accountFlag));
    paramContentValues.put("accountFlag2", Long.valueOf(paramEntity.accountFlag2));
    paramContentValues.put("eqqAccountFlag", Long.valueOf(paramEntity.eqqAccountFlag));
    paramContentValues.put("isShieldMsg", Boolean.valueOf(paramEntity.isShieldMsg));
    paramContentValues.put("messageSettingFlag", Integer.valueOf(paramEntity.messageSettingFlag));
    paramContentValues.put("extendType", Integer.valueOf(paramEntity.extendType));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramEntity.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramEntity.mCompareSpell);
    paramContentValues.put("logo", paramEntity.logo);
    paramContentValues.put("lastAIOReadTime", Long.valueOf(paramEntity.lastAIOReadTime));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin INTEGER UNIQUE ,name TEXT ,displayNumber TEXT ,summary TEXT ,isRecvMsg INTEGER ,isRecvPush INTEGER ,clickCount INTEGER ,certifiedGrade INTEGER ,isSyncLbs INTEGER ,showFlag INTEGER ,mShowMsgFlag INTEGER ,mIsAgreeSyncLbs INTEGER ,mIsSyncLbsSelected INTEGER ,dateTime INTEGER ,accountFlag INTEGER ,accountFlag2 INTEGER ,eqqAccountFlag INTEGER ,isShieldMsg INTEGER ,messageSettingFlag INTEGER ,extendType INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,logo TEXT ,lastAIOReadTime INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azhw
 * JD-Core Version:    0.7.0.1
 */