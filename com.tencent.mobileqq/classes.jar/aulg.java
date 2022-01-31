import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aulg
  extends auky
{
  public aulg()
  {
    this.a = 23;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    paramaukm = (ResourcePluginInfo)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.strPkgName = paramCursor.getString(paramCursor.getColumnIndex("strPkgName"));
      paramaukm.strResName = paramCursor.getString(paramCursor.getColumnIndex("strResName"));
      paramaukm.strResURL = paramCursor.getString(paramCursor.getColumnIndex("strResURL"));
      paramaukm.uiCurVer = paramCursor.getLong(paramCursor.getColumnIndex("uiCurVer"));
      paramaukm.sLanType = paramCursor.getShort(paramCursor.getColumnIndex("sLanType"));
      paramaukm.strGotoUrl = paramCursor.getString(paramCursor.getColumnIndex("strGotoUrl"));
      paramaukm.sResSubType = paramCursor.getShort(paramCursor.getColumnIndex("sResSubType"));
      paramaukm.sPriority = paramCursor.getShort(paramCursor.getColumnIndex("sPriority"));
      paramaukm.strResDesc = paramCursor.getString(paramCursor.getColumnIndex("strResDesc"));
      paramaukm.uiResId = paramCursor.getLong(paramCursor.getColumnIndex("uiResId"));
      paramaukm.cDefaultState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cDefaultState")));
      paramaukm.cCanChangeState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cCanChangeState")));
      paramaukm.isNew = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isNew")));
      paramaukm.cDataType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cDataType")));
      paramaukm.cLocalState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cLocalState")));
      paramaukm.iPluginType = paramCursor.getInt(paramCursor.getColumnIndex("iPluginType"));
      paramaukm.timeStamp = paramCursor.getLong(paramCursor.getColumnIndex("timeStamp"));
      paramaukm.strNewPluginDesc = paramCursor.getString(paramCursor.getColumnIndex("strNewPluginDesc"));
      paramaukm.strNewPluginURL = paramCursor.getString(paramCursor.getColumnIndex("strNewPluginURL"));
      paramaukm.lebaSearchResultType = paramCursor.getInt(paramCursor.getColumnIndex("lebaSearchResultType"));
      paramaukm.pluginSetTips = paramCursor.getString(paramCursor.getColumnIndex("pluginSetTips"));
      paramaukm.pluginBg = paramCursor.getString(paramCursor.getColumnIndex("pluginBg"));
      paramaukm.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      return paramaukm;
    }
    int i = paramCursor.getColumnIndex("strPkgName");
    if (i == -1)
    {
      paramaukx.a(new NoColumnError("strPkgName", String.class));
      i = paramCursor.getColumnIndex("strResName");
      if (i != -1) {
        break label1244;
      }
      paramaukx.a(new NoColumnError("strResName", String.class));
      label499:
      i = paramCursor.getColumnIndex("strResURL");
      if (i != -1) {
        break label1259;
      }
      paramaukx.a(new NoColumnError("strResURL", String.class));
      label533:
      i = paramCursor.getColumnIndex("uiCurVer");
      if (i != -1) {
        break label1274;
      }
      paramaukx.a(new NoColumnError("uiCurVer", Long.TYPE));
      label568:
      i = paramCursor.getColumnIndex("sLanType");
      if (i != -1) {
        break label1289;
      }
      paramaukx.a(new NoColumnError("sLanType", Short.TYPE));
      label603:
      i = paramCursor.getColumnIndex("strGotoUrl");
      if (i != -1) {
        break label1304;
      }
      paramaukx.a(new NoColumnError("strGotoUrl", String.class));
      label637:
      i = paramCursor.getColumnIndex("sResSubType");
      if (i != -1) {
        break label1319;
      }
      paramaukx.a(new NoColumnError("sResSubType", Short.TYPE));
      label672:
      i = paramCursor.getColumnIndex("sPriority");
      if (i != -1) {
        break label1334;
      }
      paramaukx.a(new NoColumnError("sPriority", Short.TYPE));
      label707:
      i = paramCursor.getColumnIndex("strResDesc");
      if (i != -1) {
        break label1349;
      }
      paramaukx.a(new NoColumnError("strResDesc", String.class));
      label741:
      i = paramCursor.getColumnIndex("uiResId");
      if (i != -1) {
        break label1364;
      }
      paramaukx.a(new NoColumnError("uiResId", Long.TYPE));
      label776:
      i = paramCursor.getColumnIndex("cDefaultState");
      if (i != -1) {
        break label1379;
      }
      paramaukx.a(new NoColumnError("cDefaultState", Byte.TYPE));
      label811:
      i = paramCursor.getColumnIndex("cCanChangeState");
      if (i != -1) {
        break label1395;
      }
      paramaukx.a(new NoColumnError("cCanChangeState", Byte.TYPE));
      label846:
      i = paramCursor.getColumnIndex("isNew");
      if (i != -1) {
        break label1411;
      }
      paramaukx.a(new NoColumnError("isNew", Byte.TYPE));
      label881:
      i = paramCursor.getColumnIndex("cDataType");
      if (i != -1) {
        break label1427;
      }
      paramaukx.a(new NoColumnError("cDataType", Byte.TYPE));
      label916:
      i = paramCursor.getColumnIndex("cLocalState");
      if (i != -1) {
        break label1443;
      }
      paramaukx.a(new NoColumnError("cLocalState", Byte.TYPE));
      label951:
      i = paramCursor.getColumnIndex("iPluginType");
      if (i != -1) {
        break label1459;
      }
      paramaukx.a(new NoColumnError("iPluginType", Integer.TYPE));
      label986:
      i = paramCursor.getColumnIndex("timeStamp");
      if (i != -1) {
        break label1474;
      }
      paramaukx.a(new NoColumnError("timeStamp", Long.TYPE));
      label1021:
      i = paramCursor.getColumnIndex("strNewPluginDesc");
      if (i != -1) {
        break label1489;
      }
      paramaukx.a(new NoColumnError("strNewPluginDesc", String.class));
      label1055:
      i = paramCursor.getColumnIndex("strNewPluginURL");
      if (i != -1) {
        break label1504;
      }
      paramaukx.a(new NoColumnError("strNewPluginURL", String.class));
      label1089:
      i = paramCursor.getColumnIndex("lebaSearchResultType");
      if (i != -1) {
        break label1519;
      }
      paramaukx.a(new NoColumnError("lebaSearchResultType", Integer.TYPE));
      label1124:
      i = paramCursor.getColumnIndex("pluginSetTips");
      if (i != -1) {
        break label1534;
      }
      paramaukx.a(new NoColumnError("pluginSetTips", String.class));
      label1158:
      i = paramCursor.getColumnIndex("pluginBg");
      if (i != -1) {
        break label1549;
      }
      paramaukx.a(new NoColumnError("pluginBg", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("flags");
      if (i != -1) {
        break label1564;
      }
      paramaukx.a(new NoColumnError("flags", Integer.TYPE));
      return paramaukm;
      paramaukm.strPkgName = paramCursor.getString(i);
      break;
      label1244:
      paramaukm.strResName = paramCursor.getString(i);
      break label499;
      label1259:
      paramaukm.strResURL = paramCursor.getString(i);
      break label533;
      label1274:
      paramaukm.uiCurVer = paramCursor.getLong(i);
      break label568;
      label1289:
      paramaukm.sLanType = paramCursor.getShort(i);
      break label603;
      label1304:
      paramaukm.strGotoUrl = paramCursor.getString(i);
      break label637;
      label1319:
      paramaukm.sResSubType = paramCursor.getShort(i);
      break label672;
      label1334:
      paramaukm.sPriority = paramCursor.getShort(i);
      break label707;
      label1349:
      paramaukm.strResDesc = paramCursor.getString(i);
      break label741;
      label1364:
      paramaukm.uiResId = paramCursor.getLong(i);
      break label776;
      label1379:
      paramaukm.cDefaultState = ((byte)paramCursor.getShort(i));
      break label811;
      label1395:
      paramaukm.cCanChangeState = ((byte)paramCursor.getShort(i));
      break label846;
      label1411:
      paramaukm.isNew = ((byte)paramCursor.getShort(i));
      break label881;
      label1427:
      paramaukm.cDataType = ((byte)paramCursor.getShort(i));
      break label916;
      label1443:
      paramaukm.cLocalState = ((byte)paramCursor.getShort(i));
      break label951;
      label1459:
      paramaukm.iPluginType = paramCursor.getInt(i);
      break label986;
      label1474:
      paramaukm.timeStamp = paramCursor.getLong(i);
      break label1021;
      label1489:
      paramaukm.strNewPluginDesc = paramCursor.getString(i);
      break label1055;
      label1504:
      paramaukm.strNewPluginURL = paramCursor.getString(i);
      break label1089;
      label1519:
      paramaukm.lebaSearchResultType = paramCursor.getInt(i);
      break label1124;
      label1534:
      paramaukm.pluginSetTips = paramCursor.getString(i);
      break label1158;
      label1549:
      paramaukm.pluginBg = paramCursor.getString(i);
    }
    label1564:
    paramaukm.flags = paramCursor.getInt(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,strPkgName TEXT UNIQUE ,strResName TEXT ,strResURL TEXT ,uiCurVer INTEGER ,sLanType INTEGER ,strGotoUrl TEXT ,sResSubType INTEGER ,sPriority INTEGER ,strResDesc TEXT ,uiResId INTEGER ,cDefaultState INTEGER ,cCanChangeState INTEGER ,isNew INTEGER ,cDataType INTEGER ,cLocalState INTEGER ,iPluginType INTEGER ,timeStamp INTEGER ,strNewPluginDesc TEXT ,strNewPluginURL TEXT ,lebaSearchResultType INTEGER ,pluginSetTips TEXT ,pluginBg TEXT ,flags INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (ResourcePluginInfo)paramaukm;
    paramContentValues.put("strPkgName", paramaukm.strPkgName);
    paramContentValues.put("strResName", paramaukm.strResName);
    paramContentValues.put("strResURL", paramaukm.strResURL);
    paramContentValues.put("uiCurVer", Long.valueOf(paramaukm.uiCurVer));
    paramContentValues.put("sLanType", Short.valueOf(paramaukm.sLanType));
    paramContentValues.put("strGotoUrl", paramaukm.strGotoUrl);
    paramContentValues.put("sResSubType", Short.valueOf(paramaukm.sResSubType));
    paramContentValues.put("sPriority", Short.valueOf(paramaukm.sPriority));
    paramContentValues.put("strResDesc", paramaukm.strResDesc);
    paramContentValues.put("uiResId", Long.valueOf(paramaukm.uiResId));
    paramContentValues.put("cDefaultState", Byte.valueOf(paramaukm.cDefaultState));
    paramContentValues.put("cCanChangeState", Byte.valueOf(paramaukm.cCanChangeState));
    paramContentValues.put("isNew", Byte.valueOf(paramaukm.isNew));
    paramContentValues.put("cDataType", Byte.valueOf(paramaukm.cDataType));
    paramContentValues.put("cLocalState", Byte.valueOf(paramaukm.cLocalState));
    paramContentValues.put("iPluginType", Integer.valueOf(paramaukm.iPluginType));
    paramContentValues.put("timeStamp", Long.valueOf(paramaukm.timeStamp));
    paramContentValues.put("strNewPluginDesc", paramaukm.strNewPluginDesc);
    paramContentValues.put("strNewPluginURL", paramaukm.strNewPluginURL);
    paramContentValues.put("lebaSearchResultType", Integer.valueOf(paramaukm.lebaSearchResultType));
    paramContentValues.put("pluginSetTips", paramaukm.pluginSetTips);
    paramContentValues.put("pluginBg", paramaukm.pluginBg);
    paramContentValues.put("flags", Integer.valueOf(paramaukm.flags));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulg
 * JD-Core Version:    0.7.0.1
 */