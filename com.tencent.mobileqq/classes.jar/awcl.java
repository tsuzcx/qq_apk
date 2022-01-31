import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awcl
  extends awch
{
  public awcl()
  {
    this.a = 24;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawbv = (PublicAccountInfo)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.uin = paramCursor.getLong(paramCursor.getColumnIndex("uin"));
      paramawbv.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramawbv.displayNumber = paramCursor.getString(paramCursor.getColumnIndex("displayNumber"));
      paramawbv.summary = paramCursor.getString(paramCursor.getColumnIndex("summary"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isRecvMsg")))
      {
        paramBoolean = true;
        paramawbv.isRecvMsg = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRecvPush"))) {
          break label498;
        }
        paramBoolean = true;
        label133:
        paramawbv.isRecvPush = paramBoolean;
        paramawbv.clickCount = paramCursor.getInt(paramCursor.getColumnIndex("clickCount"));
        paramawbv.certifiedGrade = paramCursor.getLong(paramCursor.getColumnIndex("certifiedGrade"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSyncLbs"))) {
          break label503;
        }
        paramBoolean = true;
        label194:
        paramawbv.isSyncLbs = paramBoolean;
        paramawbv.showFlag = paramCursor.getInt(paramCursor.getColumnIndex("showFlag"));
        paramawbv.mShowMsgFlag = paramCursor.getInt(paramCursor.getColumnIndex("mShowMsgFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mIsAgreeSyncLbs"))) {
          break label508;
        }
        paramBoolean = true;
        label255:
        paramawbv.mIsAgreeSyncLbs = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mIsSyncLbsSelected"))) {
          break label513;
        }
        paramBoolean = true;
        label280:
        paramawbv.mIsSyncLbsSelected = paramBoolean;
        paramawbv.dateTime = paramCursor.getLong(paramCursor.getColumnIndex("dateTime"));
        paramawbv.accountFlag = paramCursor.getInt(paramCursor.getColumnIndex("accountFlag"));
        paramawbv.accountFlag2 = paramCursor.getLong(paramCursor.getColumnIndex("accountFlag2"));
        paramawbv.eqqAccountFlag = paramCursor.getLong(paramCursor.getColumnIndex("eqqAccountFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShieldMsg"))) {
          break label518;
        }
      }
      label513:
      label518:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramawbv.isShieldMsg = paramBoolean;
        paramawbv.messageSettingFlag = paramCursor.getInt(paramCursor.getColumnIndex("messageSettingFlag"));
        paramawbv.extendType = paramCursor.getInt(paramCursor.getColumnIndex("extendType"));
        paramawbv.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramawbv.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramawbv.logo = paramCursor.getString(paramCursor.getColumnIndex("logo"));
        paramawbv.lastAIOReadTime = paramCursor.getLong(paramCursor.getColumnIndex("lastAIOReadTime"));
        return paramawbv;
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
      paramawcg.a(new NoColumnError("uin", Long.TYPE));
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label1375;
      }
      paramawcg.a(new NoColumnError("name", String.class));
      label592:
      i = paramCursor.getColumnIndex("displayNumber");
      if (i != -1) {
        break label1390;
      }
      paramawcg.a(new NoColumnError("displayNumber", String.class));
      label626:
      i = paramCursor.getColumnIndex("summary");
      if (i != -1) {
        break label1405;
      }
      paramawcg.a(new NoColumnError("summary", String.class));
      label660:
      i = paramCursor.getColumnIndex("isRecvMsg");
      if (i != -1) {
        break label1420;
      }
      paramawcg.a(new NoColumnError("isRecvMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRecvPush");
      if (i != -1) {
        break label1447;
      }
      paramawcg.a(new NoColumnError("isRecvPush", Boolean.TYPE));
      i = paramCursor.getColumnIndex("clickCount");
      if (i != -1) {
        break label1474;
      }
      paramawcg.a(new NoColumnError("clickCount", Integer.TYPE));
      label765:
      i = paramCursor.getColumnIndex("certifiedGrade");
      if (i != -1) {
        break label1489;
      }
      paramawcg.a(new NoColumnError("certifiedGrade", Long.TYPE));
      label800:
      i = paramCursor.getColumnIndex("isSyncLbs");
      if (i != -1) {
        break label1504;
      }
      paramawcg.a(new NoColumnError("isSyncLbs", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showFlag");
      if (i != -1) {
        break label1531;
      }
      paramawcg.a(new NoColumnError("showFlag", Integer.TYPE));
      label870:
      i = paramCursor.getColumnIndex("mShowMsgFlag");
      if (i != -1) {
        break label1546;
      }
      paramawcg.a(new NoColumnError("mShowMsgFlag", Integer.TYPE));
      label905:
      i = paramCursor.getColumnIndex("mIsAgreeSyncLbs");
      if (i != -1) {
        break label1561;
      }
      paramawcg.a(new NoColumnError("mIsAgreeSyncLbs", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mIsSyncLbsSelected");
      if (i != -1) {
        break label1588;
      }
      paramawcg.a(new NoColumnError("mIsSyncLbsSelected", Boolean.TYPE));
      i = paramCursor.getColumnIndex("dateTime");
      if (i != -1) {
        break label1615;
      }
      paramawcg.a(new NoColumnError("dateTime", Long.TYPE));
      label1010:
      i = paramCursor.getColumnIndex("accountFlag");
      if (i != -1) {
        break label1630;
      }
      paramawcg.a(new NoColumnError("accountFlag", Integer.TYPE));
      label1045:
      i = paramCursor.getColumnIndex("accountFlag2");
      if (i != -1) {
        break label1645;
      }
      paramawcg.a(new NoColumnError("accountFlag2", Long.TYPE));
      label1080:
      i = paramCursor.getColumnIndex("eqqAccountFlag");
      if (i != -1) {
        break label1660;
      }
      paramawcg.a(new NoColumnError("eqqAccountFlag", Long.TYPE));
      label1115:
      i = paramCursor.getColumnIndex("isShieldMsg");
      if (i != -1) {
        break label1675;
      }
      paramawcg.a(new NoColumnError("isShieldMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("messageSettingFlag");
      if (i != -1) {
        break label1703;
      }
      paramawcg.a(new NoColumnError("messageSettingFlag", Integer.TYPE));
      label1185:
      i = paramCursor.getColumnIndex("extendType");
      if (i != -1) {
        break label1718;
      }
      paramawcg.a(new NoColumnError("extendType", Integer.TYPE));
      label1220:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label1733;
      }
      paramawcg.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label1255:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label1748;
      }
      paramawcg.a(new NoColumnError("mCompareSpell", String.class));
      label1289:
      i = paramCursor.getColumnIndex("logo");
      if (i != -1) {
        break label1763;
      }
      paramawcg.a(new NoColumnError("logo", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("lastAIOReadTime");
      if (i != -1) {
        break label1778;
      }
      paramawcg.a(new NoColumnError("lastAIOReadTime", Long.TYPE));
      return paramawbv;
      paramawbv.uin = paramCursor.getLong(i);
      break;
      label1375:
      paramawbv.name = paramCursor.getString(i);
      break label592;
      label1390:
      paramawbv.displayNumber = paramCursor.getString(i);
      break label626;
      label1405:
      paramawbv.summary = paramCursor.getString(i);
      break label660;
      label1420:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isRecvMsg = paramBoolean;
        break;
      }
      label1447:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isRecvPush = paramBoolean;
        break;
      }
      label1474:
      paramawbv.clickCount = paramCursor.getInt(i);
      break label765;
      label1489:
      paramawbv.certifiedGrade = paramCursor.getLong(i);
      break label800;
      label1504:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isSyncLbs = paramBoolean;
        break;
      }
      label1531:
      paramawbv.showFlag = paramCursor.getInt(i);
      break label870;
      label1546:
      paramawbv.mShowMsgFlag = paramCursor.getInt(i);
      break label905;
      label1561:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.mIsAgreeSyncLbs = paramBoolean;
        break;
      }
      label1588:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.mIsSyncLbsSelected = paramBoolean;
        break;
      }
      label1615:
      paramawbv.dateTime = paramCursor.getLong(i);
      break label1010;
      label1630:
      paramawbv.accountFlag = paramCursor.getInt(i);
      break label1045;
      label1645:
      paramawbv.accountFlag2 = paramCursor.getLong(i);
      break label1080;
      label1660:
      paramawbv.eqqAccountFlag = paramCursor.getLong(i);
      break label1115;
      label1675:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramawbv.isShieldMsg = paramBoolean;
        break;
      }
      label1703:
      paramawbv.messageSettingFlag = paramCursor.getInt(i);
      break label1185;
      label1718:
      paramawbv.extendType = paramCursor.getInt(i);
      break label1220;
      label1733:
      paramawbv.mComparePartInt = paramCursor.getInt(i);
      break label1255;
      label1748:
      paramawbv.mCompareSpell = paramCursor.getString(i);
      break label1289;
      label1763:
      paramawbv.logo = paramCursor.getString(i);
    }
    label1778:
    paramawbv.lastAIOReadTime = paramCursor.getLong(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin INTEGER UNIQUE ,name TEXT ,displayNumber TEXT ,summary TEXT ,isRecvMsg INTEGER ,isRecvPush INTEGER ,clickCount INTEGER ,certifiedGrade INTEGER ,isSyncLbs INTEGER ,showFlag INTEGER ,mShowMsgFlag INTEGER ,mIsAgreeSyncLbs INTEGER ,mIsSyncLbsSelected INTEGER ,dateTime INTEGER ,accountFlag INTEGER ,accountFlag2 INTEGER ,eqqAccountFlag INTEGER ,isShieldMsg INTEGER ,messageSettingFlag INTEGER ,extendType INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,logo TEXT ,lastAIOReadTime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (PublicAccountInfo)paramawbv;
    paramContentValues.put("uin", Long.valueOf(paramawbv.uin));
    paramContentValues.put("name", paramawbv.name);
    paramContentValues.put("displayNumber", paramawbv.displayNumber);
    paramContentValues.put("summary", paramawbv.summary);
    paramContentValues.put("isRecvMsg", Boolean.valueOf(paramawbv.isRecvMsg));
    paramContentValues.put("isRecvPush", Boolean.valueOf(paramawbv.isRecvPush));
    paramContentValues.put("clickCount", Integer.valueOf(paramawbv.clickCount));
    paramContentValues.put("certifiedGrade", Long.valueOf(paramawbv.certifiedGrade));
    paramContentValues.put("isSyncLbs", Boolean.valueOf(paramawbv.isSyncLbs));
    paramContentValues.put("showFlag", Integer.valueOf(paramawbv.showFlag));
    paramContentValues.put("mShowMsgFlag", Integer.valueOf(paramawbv.mShowMsgFlag));
    paramContentValues.put("mIsAgreeSyncLbs", Boolean.valueOf(paramawbv.mIsAgreeSyncLbs));
    paramContentValues.put("mIsSyncLbsSelected", Boolean.valueOf(paramawbv.mIsSyncLbsSelected));
    paramContentValues.put("dateTime", Long.valueOf(paramawbv.dateTime));
    paramContentValues.put("accountFlag", Integer.valueOf(paramawbv.accountFlag));
    paramContentValues.put("accountFlag2", Long.valueOf(paramawbv.accountFlag2));
    paramContentValues.put("eqqAccountFlag", Long.valueOf(paramawbv.eqqAccountFlag));
    paramContentValues.put("isShieldMsg", Boolean.valueOf(paramawbv.isShieldMsg));
    paramContentValues.put("messageSettingFlag", Integer.valueOf(paramawbv.messageSettingFlag));
    paramContentValues.put("extendType", Integer.valueOf(paramawbv.extendType));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramawbv.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramawbv.mCompareSpell);
    paramContentValues.put("logo", paramawbv.logo);
    paramContentValues.put("lastAIOReadTime", Long.valueOf(paramawbv.lastAIOReadTime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awcl
 * JD-Core Version:    0.7.0.1
 */