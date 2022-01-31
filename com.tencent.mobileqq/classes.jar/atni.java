import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atni
  extends atna
{
  public atni()
  {
    this.a = 23;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    paramatmo = (ResourcePluginInfo)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.strPkgName = paramCursor.getString(paramCursor.getColumnIndex("strPkgName"));
      paramatmo.strResName = paramCursor.getString(paramCursor.getColumnIndex("strResName"));
      paramatmo.strResURL = paramCursor.getString(paramCursor.getColumnIndex("strResURL"));
      paramatmo.uiCurVer = paramCursor.getLong(paramCursor.getColumnIndex("uiCurVer"));
      paramatmo.sLanType = paramCursor.getShort(paramCursor.getColumnIndex("sLanType"));
      paramatmo.strGotoUrl = paramCursor.getString(paramCursor.getColumnIndex("strGotoUrl"));
      paramatmo.sResSubType = paramCursor.getShort(paramCursor.getColumnIndex("sResSubType"));
      paramatmo.sPriority = paramCursor.getShort(paramCursor.getColumnIndex("sPriority"));
      paramatmo.strResDesc = paramCursor.getString(paramCursor.getColumnIndex("strResDesc"));
      paramatmo.uiResId = paramCursor.getLong(paramCursor.getColumnIndex("uiResId"));
      paramatmo.cDefaultState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cDefaultState")));
      paramatmo.cCanChangeState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cCanChangeState")));
      paramatmo.isNew = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isNew")));
      paramatmo.cDataType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cDataType")));
      paramatmo.cLocalState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cLocalState")));
      paramatmo.iPluginType = paramCursor.getInt(paramCursor.getColumnIndex("iPluginType"));
      paramatmo.timeStamp = paramCursor.getLong(paramCursor.getColumnIndex("timeStamp"));
      paramatmo.strNewPluginDesc = paramCursor.getString(paramCursor.getColumnIndex("strNewPluginDesc"));
      paramatmo.strNewPluginURL = paramCursor.getString(paramCursor.getColumnIndex("strNewPluginURL"));
      paramatmo.lebaSearchResultType = paramCursor.getInt(paramCursor.getColumnIndex("lebaSearchResultType"));
      paramatmo.pluginSetTips = paramCursor.getString(paramCursor.getColumnIndex("pluginSetTips"));
      paramatmo.pluginBg = paramCursor.getString(paramCursor.getColumnIndex("pluginBg"));
      paramatmo.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      return paramatmo;
    }
    int i = paramCursor.getColumnIndex("strPkgName");
    if (i == -1)
    {
      paramatmz.a(new NoColumnError("strPkgName", String.class));
      i = paramCursor.getColumnIndex("strResName");
      if (i != -1) {
        break label1244;
      }
      paramatmz.a(new NoColumnError("strResName", String.class));
      label499:
      i = paramCursor.getColumnIndex("strResURL");
      if (i != -1) {
        break label1259;
      }
      paramatmz.a(new NoColumnError("strResURL", String.class));
      label533:
      i = paramCursor.getColumnIndex("uiCurVer");
      if (i != -1) {
        break label1274;
      }
      paramatmz.a(new NoColumnError("uiCurVer", Long.TYPE));
      label568:
      i = paramCursor.getColumnIndex("sLanType");
      if (i != -1) {
        break label1289;
      }
      paramatmz.a(new NoColumnError("sLanType", Short.TYPE));
      label603:
      i = paramCursor.getColumnIndex("strGotoUrl");
      if (i != -1) {
        break label1304;
      }
      paramatmz.a(new NoColumnError("strGotoUrl", String.class));
      label637:
      i = paramCursor.getColumnIndex("sResSubType");
      if (i != -1) {
        break label1319;
      }
      paramatmz.a(new NoColumnError("sResSubType", Short.TYPE));
      label672:
      i = paramCursor.getColumnIndex("sPriority");
      if (i != -1) {
        break label1334;
      }
      paramatmz.a(new NoColumnError("sPriority", Short.TYPE));
      label707:
      i = paramCursor.getColumnIndex("strResDesc");
      if (i != -1) {
        break label1349;
      }
      paramatmz.a(new NoColumnError("strResDesc", String.class));
      label741:
      i = paramCursor.getColumnIndex("uiResId");
      if (i != -1) {
        break label1364;
      }
      paramatmz.a(new NoColumnError("uiResId", Long.TYPE));
      label776:
      i = paramCursor.getColumnIndex("cDefaultState");
      if (i != -1) {
        break label1379;
      }
      paramatmz.a(new NoColumnError("cDefaultState", Byte.TYPE));
      label811:
      i = paramCursor.getColumnIndex("cCanChangeState");
      if (i != -1) {
        break label1395;
      }
      paramatmz.a(new NoColumnError("cCanChangeState", Byte.TYPE));
      label846:
      i = paramCursor.getColumnIndex("isNew");
      if (i != -1) {
        break label1411;
      }
      paramatmz.a(new NoColumnError("isNew", Byte.TYPE));
      label881:
      i = paramCursor.getColumnIndex("cDataType");
      if (i != -1) {
        break label1427;
      }
      paramatmz.a(new NoColumnError("cDataType", Byte.TYPE));
      label916:
      i = paramCursor.getColumnIndex("cLocalState");
      if (i != -1) {
        break label1443;
      }
      paramatmz.a(new NoColumnError("cLocalState", Byte.TYPE));
      label951:
      i = paramCursor.getColumnIndex("iPluginType");
      if (i != -1) {
        break label1459;
      }
      paramatmz.a(new NoColumnError("iPluginType", Integer.TYPE));
      label986:
      i = paramCursor.getColumnIndex("timeStamp");
      if (i != -1) {
        break label1474;
      }
      paramatmz.a(new NoColumnError("timeStamp", Long.TYPE));
      label1021:
      i = paramCursor.getColumnIndex("strNewPluginDesc");
      if (i != -1) {
        break label1489;
      }
      paramatmz.a(new NoColumnError("strNewPluginDesc", String.class));
      label1055:
      i = paramCursor.getColumnIndex("strNewPluginURL");
      if (i != -1) {
        break label1504;
      }
      paramatmz.a(new NoColumnError("strNewPluginURL", String.class));
      label1089:
      i = paramCursor.getColumnIndex("lebaSearchResultType");
      if (i != -1) {
        break label1519;
      }
      paramatmz.a(new NoColumnError("lebaSearchResultType", Integer.TYPE));
      label1124:
      i = paramCursor.getColumnIndex("pluginSetTips");
      if (i != -1) {
        break label1534;
      }
      paramatmz.a(new NoColumnError("pluginSetTips", String.class));
      label1158:
      i = paramCursor.getColumnIndex("pluginBg");
      if (i != -1) {
        break label1549;
      }
      paramatmz.a(new NoColumnError("pluginBg", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("flags");
      if (i != -1) {
        break label1564;
      }
      paramatmz.a(new NoColumnError("flags", Integer.TYPE));
      return paramatmo;
      paramatmo.strPkgName = paramCursor.getString(i);
      break;
      label1244:
      paramatmo.strResName = paramCursor.getString(i);
      break label499;
      label1259:
      paramatmo.strResURL = paramCursor.getString(i);
      break label533;
      label1274:
      paramatmo.uiCurVer = paramCursor.getLong(i);
      break label568;
      label1289:
      paramatmo.sLanType = paramCursor.getShort(i);
      break label603;
      label1304:
      paramatmo.strGotoUrl = paramCursor.getString(i);
      break label637;
      label1319:
      paramatmo.sResSubType = paramCursor.getShort(i);
      break label672;
      label1334:
      paramatmo.sPriority = paramCursor.getShort(i);
      break label707;
      label1349:
      paramatmo.strResDesc = paramCursor.getString(i);
      break label741;
      label1364:
      paramatmo.uiResId = paramCursor.getLong(i);
      break label776;
      label1379:
      paramatmo.cDefaultState = ((byte)paramCursor.getShort(i));
      break label811;
      label1395:
      paramatmo.cCanChangeState = ((byte)paramCursor.getShort(i));
      break label846;
      label1411:
      paramatmo.isNew = ((byte)paramCursor.getShort(i));
      break label881;
      label1427:
      paramatmo.cDataType = ((byte)paramCursor.getShort(i));
      break label916;
      label1443:
      paramatmo.cLocalState = ((byte)paramCursor.getShort(i));
      break label951;
      label1459:
      paramatmo.iPluginType = paramCursor.getInt(i);
      break label986;
      label1474:
      paramatmo.timeStamp = paramCursor.getLong(i);
      break label1021;
      label1489:
      paramatmo.strNewPluginDesc = paramCursor.getString(i);
      break label1055;
      label1504:
      paramatmo.strNewPluginURL = paramCursor.getString(i);
      break label1089;
      label1519:
      paramatmo.lebaSearchResultType = paramCursor.getInt(i);
      break label1124;
      label1534:
      paramatmo.pluginSetTips = paramCursor.getString(i);
      break label1158;
      label1549:
      paramatmo.pluginBg = paramCursor.getString(i);
    }
    label1564:
    paramatmo.flags = paramCursor.getInt(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,strPkgName TEXT UNIQUE ,strResName TEXT ,strResURL TEXT ,uiCurVer INTEGER ,sLanType INTEGER ,strGotoUrl TEXT ,sResSubType INTEGER ,sPriority INTEGER ,strResDesc TEXT ,uiResId INTEGER ,cDefaultState INTEGER ,cCanChangeState INTEGER ,isNew INTEGER ,cDataType INTEGER ,cLocalState INTEGER ,iPluginType INTEGER ,timeStamp INTEGER ,strNewPluginDesc TEXT ,strNewPluginURL TEXT ,lebaSearchResultType INTEGER ,pluginSetTips TEXT ,pluginBg TEXT ,flags INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (ResourcePluginInfo)paramatmo;
    paramContentValues.put("strPkgName", paramatmo.strPkgName);
    paramContentValues.put("strResName", paramatmo.strResName);
    paramContentValues.put("strResURL", paramatmo.strResURL);
    paramContentValues.put("uiCurVer", Long.valueOf(paramatmo.uiCurVer));
    paramContentValues.put("sLanType", Short.valueOf(paramatmo.sLanType));
    paramContentValues.put("strGotoUrl", paramatmo.strGotoUrl);
    paramContentValues.put("sResSubType", Short.valueOf(paramatmo.sResSubType));
    paramContentValues.put("sPriority", Short.valueOf(paramatmo.sPriority));
    paramContentValues.put("strResDesc", paramatmo.strResDesc);
    paramContentValues.put("uiResId", Long.valueOf(paramatmo.uiResId));
    paramContentValues.put("cDefaultState", Byte.valueOf(paramatmo.cDefaultState));
    paramContentValues.put("cCanChangeState", Byte.valueOf(paramatmo.cCanChangeState));
    paramContentValues.put("isNew", Byte.valueOf(paramatmo.isNew));
    paramContentValues.put("cDataType", Byte.valueOf(paramatmo.cDataType));
    paramContentValues.put("cLocalState", Byte.valueOf(paramatmo.cLocalState));
    paramContentValues.put("iPluginType", Integer.valueOf(paramatmo.iPluginType));
    paramContentValues.put("timeStamp", Long.valueOf(paramatmo.timeStamp));
    paramContentValues.put("strNewPluginDesc", paramatmo.strNewPluginDesc);
    paramContentValues.put("strNewPluginURL", paramatmo.strNewPluginURL);
    paramContentValues.put("lebaSearchResultType", Integer.valueOf(paramatmo.lebaSearchResultType));
    paramContentValues.put("pluginSetTips", paramatmo.pluginSetTips);
    paramContentValues.put("pluginBg", paramatmo.pluginBg);
    paramContentValues.put("flags", Integer.valueOf(paramatmo.flags));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atni
 * JD-Core Version:    0.7.0.1
 */