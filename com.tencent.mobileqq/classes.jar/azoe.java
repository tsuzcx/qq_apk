import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class azoe
  extends OGAbstractDao
{
  public azoe()
  {
    this.columnLen = 23;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (ResourcePluginInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.strPkgName = paramCursor.getString(paramCursor.getColumnIndex("strPkgName"));
      paramEntity.strResName = paramCursor.getString(paramCursor.getColumnIndex("strResName"));
      paramEntity.strResURL = paramCursor.getString(paramCursor.getColumnIndex("strResURL"));
      paramEntity.uiCurVer = paramCursor.getLong(paramCursor.getColumnIndex("uiCurVer"));
      paramEntity.sLanType = paramCursor.getShort(paramCursor.getColumnIndex("sLanType"));
      paramEntity.strGotoUrl = paramCursor.getString(paramCursor.getColumnIndex("strGotoUrl"));
      paramEntity.sResSubType = paramCursor.getShort(paramCursor.getColumnIndex("sResSubType"));
      paramEntity.sPriority = paramCursor.getShort(paramCursor.getColumnIndex("sPriority"));
      paramEntity.strResDesc = paramCursor.getString(paramCursor.getColumnIndex("strResDesc"));
      paramEntity.uiResId = paramCursor.getLong(paramCursor.getColumnIndex("uiResId"));
      paramEntity.cDefaultState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cDefaultState")));
      paramEntity.cCanChangeState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cCanChangeState")));
      paramEntity.isNew = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isNew")));
      paramEntity.cDataType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cDataType")));
      paramEntity.cLocalState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cLocalState")));
      paramEntity.iPluginType = paramCursor.getInt(paramCursor.getColumnIndex("iPluginType"));
      paramEntity.timeStamp = paramCursor.getLong(paramCursor.getColumnIndex("timeStamp"));
      paramEntity.strNewPluginDesc = paramCursor.getString(paramCursor.getColumnIndex("strNewPluginDesc"));
      paramEntity.strNewPluginURL = paramCursor.getString(paramCursor.getColumnIndex("strNewPluginURL"));
      paramEntity.lebaSearchResultType = paramCursor.getInt(paramCursor.getColumnIndex("lebaSearchResultType"));
      paramEntity.pluginSetTips = paramCursor.getString(paramCursor.getColumnIndex("pluginSetTips"));
      paramEntity.pluginBg = paramCursor.getString(paramCursor.getColumnIndex("pluginBg"));
      paramEntity.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("strPkgName");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strPkgName", String.class));
      i = paramCursor.getColumnIndex("strResName");
      if (i != -1) {
        break label1244;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strResName", String.class));
      label499:
      i = paramCursor.getColumnIndex("strResURL");
      if (i != -1) {
        break label1259;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strResURL", String.class));
      label533:
      i = paramCursor.getColumnIndex("uiCurVer");
      if (i != -1) {
        break label1274;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uiCurVer", Long.TYPE));
      label568:
      i = paramCursor.getColumnIndex("sLanType");
      if (i != -1) {
        break label1289;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sLanType", Short.TYPE));
      label603:
      i = paramCursor.getColumnIndex("strGotoUrl");
      if (i != -1) {
        break label1304;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGotoUrl", String.class));
      label637:
      i = paramCursor.getColumnIndex("sResSubType");
      if (i != -1) {
        break label1319;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sResSubType", Short.TYPE));
      label672:
      i = paramCursor.getColumnIndex("sPriority");
      if (i != -1) {
        break label1334;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sPriority", Short.TYPE));
      label707:
      i = paramCursor.getColumnIndex("strResDesc");
      if (i != -1) {
        break label1349;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strResDesc", String.class));
      label741:
      i = paramCursor.getColumnIndex("uiResId");
      if (i != -1) {
        break label1364;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uiResId", Long.TYPE));
      label776:
      i = paramCursor.getColumnIndex("cDefaultState");
      if (i != -1) {
        break label1379;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cDefaultState", Byte.TYPE));
      label811:
      i = paramCursor.getColumnIndex("cCanChangeState");
      if (i != -1) {
        break label1395;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cCanChangeState", Byte.TYPE));
      label846:
      i = paramCursor.getColumnIndex("isNew");
      if (i != -1) {
        break label1411;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isNew", Byte.TYPE));
      label881:
      i = paramCursor.getColumnIndex("cDataType");
      if (i != -1) {
        break label1427;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cDataType", Byte.TYPE));
      label916:
      i = paramCursor.getColumnIndex("cLocalState");
      if (i != -1) {
        break label1443;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cLocalState", Byte.TYPE));
      label951:
      i = paramCursor.getColumnIndex("iPluginType");
      if (i != -1) {
        break label1459;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iPluginType", Integer.TYPE));
      label986:
      i = paramCursor.getColumnIndex("timeStamp");
      if (i != -1) {
        break label1474;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("timeStamp", Long.TYPE));
      label1021:
      i = paramCursor.getColumnIndex("strNewPluginDesc");
      if (i != -1) {
        break label1489;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strNewPluginDesc", String.class));
      label1055:
      i = paramCursor.getColumnIndex("strNewPluginURL");
      if (i != -1) {
        break label1504;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strNewPluginURL", String.class));
      label1089:
      i = paramCursor.getColumnIndex("lebaSearchResultType");
      if (i != -1) {
        break label1519;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lebaSearchResultType", Integer.TYPE));
      label1124:
      i = paramCursor.getColumnIndex("pluginSetTips");
      if (i != -1) {
        break label1534;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pluginSetTips", String.class));
      label1158:
      i = paramCursor.getColumnIndex("pluginBg");
      if (i != -1) {
        break label1549;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pluginBg", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("flags");
      if (i != -1) {
        break label1564;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("flags", Integer.TYPE));
      return paramEntity;
      paramEntity.strPkgName = paramCursor.getString(i);
      break;
      label1244:
      paramEntity.strResName = paramCursor.getString(i);
      break label499;
      label1259:
      paramEntity.strResURL = paramCursor.getString(i);
      break label533;
      label1274:
      paramEntity.uiCurVer = paramCursor.getLong(i);
      break label568;
      label1289:
      paramEntity.sLanType = paramCursor.getShort(i);
      break label603;
      label1304:
      paramEntity.strGotoUrl = paramCursor.getString(i);
      break label637;
      label1319:
      paramEntity.sResSubType = paramCursor.getShort(i);
      break label672;
      label1334:
      paramEntity.sPriority = paramCursor.getShort(i);
      break label707;
      label1349:
      paramEntity.strResDesc = paramCursor.getString(i);
      break label741;
      label1364:
      paramEntity.uiResId = paramCursor.getLong(i);
      break label776;
      label1379:
      paramEntity.cDefaultState = ((byte)paramCursor.getShort(i));
      break label811;
      label1395:
      paramEntity.cCanChangeState = ((byte)paramCursor.getShort(i));
      break label846;
      label1411:
      paramEntity.isNew = ((byte)paramCursor.getShort(i));
      break label881;
      label1427:
      paramEntity.cDataType = ((byte)paramCursor.getShort(i));
      break label916;
      label1443:
      paramEntity.cLocalState = ((byte)paramCursor.getShort(i));
      break label951;
      label1459:
      paramEntity.iPluginType = paramCursor.getInt(i);
      break label986;
      label1474:
      paramEntity.timeStamp = paramCursor.getLong(i);
      break label1021;
      label1489:
      paramEntity.strNewPluginDesc = paramCursor.getString(i);
      break label1055;
      label1504:
      paramEntity.strNewPluginURL = paramCursor.getString(i);
      break label1089;
      label1519:
      paramEntity.lebaSearchResultType = paramCursor.getInt(i);
      break label1124;
      label1534:
      paramEntity.pluginSetTips = paramCursor.getString(i);
      break label1158;
      label1549:
      paramEntity.pluginBg = paramCursor.getString(i);
    }
    label1564:
    paramEntity.flags = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (ResourcePluginInfo)paramEntity;
    paramContentValues.put("strPkgName", paramEntity.strPkgName);
    paramContentValues.put("strResName", paramEntity.strResName);
    paramContentValues.put("strResURL", paramEntity.strResURL);
    paramContentValues.put("uiCurVer", Long.valueOf(paramEntity.uiCurVer));
    paramContentValues.put("sLanType", Short.valueOf(paramEntity.sLanType));
    paramContentValues.put("strGotoUrl", paramEntity.strGotoUrl);
    paramContentValues.put("sResSubType", Short.valueOf(paramEntity.sResSubType));
    paramContentValues.put("sPriority", Short.valueOf(paramEntity.sPriority));
    paramContentValues.put("strResDesc", paramEntity.strResDesc);
    paramContentValues.put("uiResId", Long.valueOf(paramEntity.uiResId));
    paramContentValues.put("cDefaultState", Byte.valueOf(paramEntity.cDefaultState));
    paramContentValues.put("cCanChangeState", Byte.valueOf(paramEntity.cCanChangeState));
    paramContentValues.put("isNew", Byte.valueOf(paramEntity.isNew));
    paramContentValues.put("cDataType", Byte.valueOf(paramEntity.cDataType));
    paramContentValues.put("cLocalState", Byte.valueOf(paramEntity.cLocalState));
    paramContentValues.put("iPluginType", Integer.valueOf(paramEntity.iPluginType));
    paramContentValues.put("timeStamp", Long.valueOf(paramEntity.timeStamp));
    paramContentValues.put("strNewPluginDesc", paramEntity.strNewPluginDesc);
    paramContentValues.put("strNewPluginURL", paramEntity.strNewPluginURL);
    paramContentValues.put("lebaSearchResultType", Integer.valueOf(paramEntity.lebaSearchResultType));
    paramContentValues.put("pluginSetTips", paramEntity.pluginSetTips);
    paramContentValues.put("pluginBg", paramEntity.pluginBg);
    paramContentValues.put("flags", Integer.valueOf(paramEntity.flags));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,strPkgName TEXT UNIQUE ,strResName TEXT ,strResURL TEXT ,uiCurVer INTEGER ,sLanType INTEGER ,strGotoUrl TEXT ,sResSubType INTEGER ,sPriority INTEGER ,strResDesc TEXT ,uiResId INTEGER ,cDefaultState INTEGER ,cCanChangeState INTEGER ,isNew INTEGER ,cDataType INTEGER ,cLocalState INTEGER ,iPluginType INTEGER ,timeStamp INTEGER ,strNewPluginDesc TEXT ,strNewPluginURL TEXT ,lebaSearchResultType INTEGER ,pluginSetTips TEXT ,pluginBg TEXT ,flags INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azoe
 * JD-Core Version:    0.7.0.1
 */