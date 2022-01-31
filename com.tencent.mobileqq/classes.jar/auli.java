import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class auli
  extends aula
{
  public auli()
  {
    this.a = 23;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    paramauko = (ResourcePluginInfo)paramauko;
    if (paramaukz == null)
    {
      paramauko.strPkgName = paramCursor.getString(paramCursor.getColumnIndex("strPkgName"));
      paramauko.strResName = paramCursor.getString(paramCursor.getColumnIndex("strResName"));
      paramauko.strResURL = paramCursor.getString(paramCursor.getColumnIndex("strResURL"));
      paramauko.uiCurVer = paramCursor.getLong(paramCursor.getColumnIndex("uiCurVer"));
      paramauko.sLanType = paramCursor.getShort(paramCursor.getColumnIndex("sLanType"));
      paramauko.strGotoUrl = paramCursor.getString(paramCursor.getColumnIndex("strGotoUrl"));
      paramauko.sResSubType = paramCursor.getShort(paramCursor.getColumnIndex("sResSubType"));
      paramauko.sPriority = paramCursor.getShort(paramCursor.getColumnIndex("sPriority"));
      paramauko.strResDesc = paramCursor.getString(paramCursor.getColumnIndex("strResDesc"));
      paramauko.uiResId = paramCursor.getLong(paramCursor.getColumnIndex("uiResId"));
      paramauko.cDefaultState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cDefaultState")));
      paramauko.cCanChangeState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cCanChangeState")));
      paramauko.isNew = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isNew")));
      paramauko.cDataType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cDataType")));
      paramauko.cLocalState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cLocalState")));
      paramauko.iPluginType = paramCursor.getInt(paramCursor.getColumnIndex("iPluginType"));
      paramauko.timeStamp = paramCursor.getLong(paramCursor.getColumnIndex("timeStamp"));
      paramauko.strNewPluginDesc = paramCursor.getString(paramCursor.getColumnIndex("strNewPluginDesc"));
      paramauko.strNewPluginURL = paramCursor.getString(paramCursor.getColumnIndex("strNewPluginURL"));
      paramauko.lebaSearchResultType = paramCursor.getInt(paramCursor.getColumnIndex("lebaSearchResultType"));
      paramauko.pluginSetTips = paramCursor.getString(paramCursor.getColumnIndex("pluginSetTips"));
      paramauko.pluginBg = paramCursor.getString(paramCursor.getColumnIndex("pluginBg"));
      paramauko.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      return paramauko;
    }
    int i = paramCursor.getColumnIndex("strPkgName");
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("strPkgName", String.class));
      i = paramCursor.getColumnIndex("strResName");
      if (i != -1) {
        break label1244;
      }
      paramaukz.a(new NoColumnError("strResName", String.class));
      label499:
      i = paramCursor.getColumnIndex("strResURL");
      if (i != -1) {
        break label1259;
      }
      paramaukz.a(new NoColumnError("strResURL", String.class));
      label533:
      i = paramCursor.getColumnIndex("uiCurVer");
      if (i != -1) {
        break label1274;
      }
      paramaukz.a(new NoColumnError("uiCurVer", Long.TYPE));
      label568:
      i = paramCursor.getColumnIndex("sLanType");
      if (i != -1) {
        break label1289;
      }
      paramaukz.a(new NoColumnError("sLanType", Short.TYPE));
      label603:
      i = paramCursor.getColumnIndex("strGotoUrl");
      if (i != -1) {
        break label1304;
      }
      paramaukz.a(new NoColumnError("strGotoUrl", String.class));
      label637:
      i = paramCursor.getColumnIndex("sResSubType");
      if (i != -1) {
        break label1319;
      }
      paramaukz.a(new NoColumnError("sResSubType", Short.TYPE));
      label672:
      i = paramCursor.getColumnIndex("sPriority");
      if (i != -1) {
        break label1334;
      }
      paramaukz.a(new NoColumnError("sPriority", Short.TYPE));
      label707:
      i = paramCursor.getColumnIndex("strResDesc");
      if (i != -1) {
        break label1349;
      }
      paramaukz.a(new NoColumnError("strResDesc", String.class));
      label741:
      i = paramCursor.getColumnIndex("uiResId");
      if (i != -1) {
        break label1364;
      }
      paramaukz.a(new NoColumnError("uiResId", Long.TYPE));
      label776:
      i = paramCursor.getColumnIndex("cDefaultState");
      if (i != -1) {
        break label1379;
      }
      paramaukz.a(new NoColumnError("cDefaultState", Byte.TYPE));
      label811:
      i = paramCursor.getColumnIndex("cCanChangeState");
      if (i != -1) {
        break label1395;
      }
      paramaukz.a(new NoColumnError("cCanChangeState", Byte.TYPE));
      label846:
      i = paramCursor.getColumnIndex("isNew");
      if (i != -1) {
        break label1411;
      }
      paramaukz.a(new NoColumnError("isNew", Byte.TYPE));
      label881:
      i = paramCursor.getColumnIndex("cDataType");
      if (i != -1) {
        break label1427;
      }
      paramaukz.a(new NoColumnError("cDataType", Byte.TYPE));
      label916:
      i = paramCursor.getColumnIndex("cLocalState");
      if (i != -1) {
        break label1443;
      }
      paramaukz.a(new NoColumnError("cLocalState", Byte.TYPE));
      label951:
      i = paramCursor.getColumnIndex("iPluginType");
      if (i != -1) {
        break label1459;
      }
      paramaukz.a(new NoColumnError("iPluginType", Integer.TYPE));
      label986:
      i = paramCursor.getColumnIndex("timeStamp");
      if (i != -1) {
        break label1474;
      }
      paramaukz.a(new NoColumnError("timeStamp", Long.TYPE));
      label1021:
      i = paramCursor.getColumnIndex("strNewPluginDesc");
      if (i != -1) {
        break label1489;
      }
      paramaukz.a(new NoColumnError("strNewPluginDesc", String.class));
      label1055:
      i = paramCursor.getColumnIndex("strNewPluginURL");
      if (i != -1) {
        break label1504;
      }
      paramaukz.a(new NoColumnError("strNewPluginURL", String.class));
      label1089:
      i = paramCursor.getColumnIndex("lebaSearchResultType");
      if (i != -1) {
        break label1519;
      }
      paramaukz.a(new NoColumnError("lebaSearchResultType", Integer.TYPE));
      label1124:
      i = paramCursor.getColumnIndex("pluginSetTips");
      if (i != -1) {
        break label1534;
      }
      paramaukz.a(new NoColumnError("pluginSetTips", String.class));
      label1158:
      i = paramCursor.getColumnIndex("pluginBg");
      if (i != -1) {
        break label1549;
      }
      paramaukz.a(new NoColumnError("pluginBg", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("flags");
      if (i != -1) {
        break label1564;
      }
      paramaukz.a(new NoColumnError("flags", Integer.TYPE));
      return paramauko;
      paramauko.strPkgName = paramCursor.getString(i);
      break;
      label1244:
      paramauko.strResName = paramCursor.getString(i);
      break label499;
      label1259:
      paramauko.strResURL = paramCursor.getString(i);
      break label533;
      label1274:
      paramauko.uiCurVer = paramCursor.getLong(i);
      break label568;
      label1289:
      paramauko.sLanType = paramCursor.getShort(i);
      break label603;
      label1304:
      paramauko.strGotoUrl = paramCursor.getString(i);
      break label637;
      label1319:
      paramauko.sResSubType = paramCursor.getShort(i);
      break label672;
      label1334:
      paramauko.sPriority = paramCursor.getShort(i);
      break label707;
      label1349:
      paramauko.strResDesc = paramCursor.getString(i);
      break label741;
      label1364:
      paramauko.uiResId = paramCursor.getLong(i);
      break label776;
      label1379:
      paramauko.cDefaultState = ((byte)paramCursor.getShort(i));
      break label811;
      label1395:
      paramauko.cCanChangeState = ((byte)paramCursor.getShort(i));
      break label846;
      label1411:
      paramauko.isNew = ((byte)paramCursor.getShort(i));
      break label881;
      label1427:
      paramauko.cDataType = ((byte)paramCursor.getShort(i));
      break label916;
      label1443:
      paramauko.cLocalState = ((byte)paramCursor.getShort(i));
      break label951;
      label1459:
      paramauko.iPluginType = paramCursor.getInt(i);
      break label986;
      label1474:
      paramauko.timeStamp = paramCursor.getLong(i);
      break label1021;
      label1489:
      paramauko.strNewPluginDesc = paramCursor.getString(i);
      break label1055;
      label1504:
      paramauko.strNewPluginURL = paramCursor.getString(i);
      break label1089;
      label1519:
      paramauko.lebaSearchResultType = paramCursor.getInt(i);
      break label1124;
      label1534:
      paramauko.pluginSetTips = paramCursor.getString(i);
      break label1158;
      label1549:
      paramauko.pluginBg = paramCursor.getString(i);
    }
    label1564:
    paramauko.flags = paramCursor.getInt(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,strPkgName TEXT UNIQUE ,strResName TEXT ,strResURL TEXT ,uiCurVer INTEGER ,sLanType INTEGER ,strGotoUrl TEXT ,sResSubType INTEGER ,sPriority INTEGER ,strResDesc TEXT ,uiResId INTEGER ,cDefaultState INTEGER ,cCanChangeState INTEGER ,isNew INTEGER ,cDataType INTEGER ,cLocalState INTEGER ,iPluginType INTEGER ,timeStamp INTEGER ,strNewPluginDesc TEXT ,strNewPluginURL TEXT ,lebaSearchResultType INTEGER ,pluginSetTips TEXT ,pluginBg TEXT ,flags INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (ResourcePluginInfo)paramauko;
    paramContentValues.put("strPkgName", paramauko.strPkgName);
    paramContentValues.put("strResName", paramauko.strResName);
    paramContentValues.put("strResURL", paramauko.strResURL);
    paramContentValues.put("uiCurVer", Long.valueOf(paramauko.uiCurVer));
    paramContentValues.put("sLanType", Short.valueOf(paramauko.sLanType));
    paramContentValues.put("strGotoUrl", paramauko.strGotoUrl);
    paramContentValues.put("sResSubType", Short.valueOf(paramauko.sResSubType));
    paramContentValues.put("sPriority", Short.valueOf(paramauko.sPriority));
    paramContentValues.put("strResDesc", paramauko.strResDesc);
    paramContentValues.put("uiResId", Long.valueOf(paramauko.uiResId));
    paramContentValues.put("cDefaultState", Byte.valueOf(paramauko.cDefaultState));
    paramContentValues.put("cCanChangeState", Byte.valueOf(paramauko.cCanChangeState));
    paramContentValues.put("isNew", Byte.valueOf(paramauko.isNew));
    paramContentValues.put("cDataType", Byte.valueOf(paramauko.cDataType));
    paramContentValues.put("cLocalState", Byte.valueOf(paramauko.cLocalState));
    paramContentValues.put("iPluginType", Integer.valueOf(paramauko.iPluginType));
    paramContentValues.put("timeStamp", Long.valueOf(paramauko.timeStamp));
    paramContentValues.put("strNewPluginDesc", paramauko.strNewPluginDesc);
    paramContentValues.put("strNewPluginURL", paramauko.strNewPluginURL);
    paramContentValues.put("lebaSearchResultType", Integer.valueOf(paramauko.lebaSearchResultType));
    paramContentValues.put("pluginSetTips", paramauko.pluginSetTips);
    paramContentValues.put("pluginBg", paramauko.pluginBg);
    paramContentValues.put("flags", Integer.valueOf(paramauko.flags));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auli
 * JD-Core Version:    0.7.0.1
 */