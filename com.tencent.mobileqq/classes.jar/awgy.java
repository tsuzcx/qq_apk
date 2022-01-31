import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awgy
  extends awgq
{
  public awgy()
  {
    this.a = 23;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    paramawge = (ResourcePluginInfo)paramawge;
    if (paramawgp == null)
    {
      paramawge.strPkgName = paramCursor.getString(paramCursor.getColumnIndex("strPkgName"));
      paramawge.strResName = paramCursor.getString(paramCursor.getColumnIndex("strResName"));
      paramawge.strResURL = paramCursor.getString(paramCursor.getColumnIndex("strResURL"));
      paramawge.uiCurVer = paramCursor.getLong(paramCursor.getColumnIndex("uiCurVer"));
      paramawge.sLanType = paramCursor.getShort(paramCursor.getColumnIndex("sLanType"));
      paramawge.strGotoUrl = paramCursor.getString(paramCursor.getColumnIndex("strGotoUrl"));
      paramawge.sResSubType = paramCursor.getShort(paramCursor.getColumnIndex("sResSubType"));
      paramawge.sPriority = paramCursor.getShort(paramCursor.getColumnIndex("sPriority"));
      paramawge.strResDesc = paramCursor.getString(paramCursor.getColumnIndex("strResDesc"));
      paramawge.uiResId = paramCursor.getLong(paramCursor.getColumnIndex("uiResId"));
      paramawge.cDefaultState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cDefaultState")));
      paramawge.cCanChangeState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cCanChangeState")));
      paramawge.isNew = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isNew")));
      paramawge.cDataType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cDataType")));
      paramawge.cLocalState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cLocalState")));
      paramawge.iPluginType = paramCursor.getInt(paramCursor.getColumnIndex("iPluginType"));
      paramawge.timeStamp = paramCursor.getLong(paramCursor.getColumnIndex("timeStamp"));
      paramawge.strNewPluginDesc = paramCursor.getString(paramCursor.getColumnIndex("strNewPluginDesc"));
      paramawge.strNewPluginURL = paramCursor.getString(paramCursor.getColumnIndex("strNewPluginURL"));
      paramawge.lebaSearchResultType = paramCursor.getInt(paramCursor.getColumnIndex("lebaSearchResultType"));
      paramawge.pluginSetTips = paramCursor.getString(paramCursor.getColumnIndex("pluginSetTips"));
      paramawge.pluginBg = paramCursor.getString(paramCursor.getColumnIndex("pluginBg"));
      paramawge.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      return paramawge;
    }
    int i = paramCursor.getColumnIndex("strPkgName");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("strPkgName", String.class));
      i = paramCursor.getColumnIndex("strResName");
      if (i != -1) {
        break label1244;
      }
      paramawgp.a(new NoColumnError("strResName", String.class));
      label499:
      i = paramCursor.getColumnIndex("strResURL");
      if (i != -1) {
        break label1259;
      }
      paramawgp.a(new NoColumnError("strResURL", String.class));
      label533:
      i = paramCursor.getColumnIndex("uiCurVer");
      if (i != -1) {
        break label1274;
      }
      paramawgp.a(new NoColumnError("uiCurVer", Long.TYPE));
      label568:
      i = paramCursor.getColumnIndex("sLanType");
      if (i != -1) {
        break label1289;
      }
      paramawgp.a(new NoColumnError("sLanType", Short.TYPE));
      label603:
      i = paramCursor.getColumnIndex("strGotoUrl");
      if (i != -1) {
        break label1304;
      }
      paramawgp.a(new NoColumnError("strGotoUrl", String.class));
      label637:
      i = paramCursor.getColumnIndex("sResSubType");
      if (i != -1) {
        break label1319;
      }
      paramawgp.a(new NoColumnError("sResSubType", Short.TYPE));
      label672:
      i = paramCursor.getColumnIndex("sPriority");
      if (i != -1) {
        break label1334;
      }
      paramawgp.a(new NoColumnError("sPriority", Short.TYPE));
      label707:
      i = paramCursor.getColumnIndex("strResDesc");
      if (i != -1) {
        break label1349;
      }
      paramawgp.a(new NoColumnError("strResDesc", String.class));
      label741:
      i = paramCursor.getColumnIndex("uiResId");
      if (i != -1) {
        break label1364;
      }
      paramawgp.a(new NoColumnError("uiResId", Long.TYPE));
      label776:
      i = paramCursor.getColumnIndex("cDefaultState");
      if (i != -1) {
        break label1379;
      }
      paramawgp.a(new NoColumnError("cDefaultState", Byte.TYPE));
      label811:
      i = paramCursor.getColumnIndex("cCanChangeState");
      if (i != -1) {
        break label1395;
      }
      paramawgp.a(new NoColumnError("cCanChangeState", Byte.TYPE));
      label846:
      i = paramCursor.getColumnIndex("isNew");
      if (i != -1) {
        break label1411;
      }
      paramawgp.a(new NoColumnError("isNew", Byte.TYPE));
      label881:
      i = paramCursor.getColumnIndex("cDataType");
      if (i != -1) {
        break label1427;
      }
      paramawgp.a(new NoColumnError("cDataType", Byte.TYPE));
      label916:
      i = paramCursor.getColumnIndex("cLocalState");
      if (i != -1) {
        break label1443;
      }
      paramawgp.a(new NoColumnError("cLocalState", Byte.TYPE));
      label951:
      i = paramCursor.getColumnIndex("iPluginType");
      if (i != -1) {
        break label1459;
      }
      paramawgp.a(new NoColumnError("iPluginType", Integer.TYPE));
      label986:
      i = paramCursor.getColumnIndex("timeStamp");
      if (i != -1) {
        break label1474;
      }
      paramawgp.a(new NoColumnError("timeStamp", Long.TYPE));
      label1021:
      i = paramCursor.getColumnIndex("strNewPluginDesc");
      if (i != -1) {
        break label1489;
      }
      paramawgp.a(new NoColumnError("strNewPluginDesc", String.class));
      label1055:
      i = paramCursor.getColumnIndex("strNewPluginURL");
      if (i != -1) {
        break label1504;
      }
      paramawgp.a(new NoColumnError("strNewPluginURL", String.class));
      label1089:
      i = paramCursor.getColumnIndex("lebaSearchResultType");
      if (i != -1) {
        break label1519;
      }
      paramawgp.a(new NoColumnError("lebaSearchResultType", Integer.TYPE));
      label1124:
      i = paramCursor.getColumnIndex("pluginSetTips");
      if (i != -1) {
        break label1534;
      }
      paramawgp.a(new NoColumnError("pluginSetTips", String.class));
      label1158:
      i = paramCursor.getColumnIndex("pluginBg");
      if (i != -1) {
        break label1549;
      }
      paramawgp.a(new NoColumnError("pluginBg", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("flags");
      if (i != -1) {
        break label1564;
      }
      paramawgp.a(new NoColumnError("flags", Integer.TYPE));
      return paramawge;
      paramawge.strPkgName = paramCursor.getString(i);
      break;
      label1244:
      paramawge.strResName = paramCursor.getString(i);
      break label499;
      label1259:
      paramawge.strResURL = paramCursor.getString(i);
      break label533;
      label1274:
      paramawge.uiCurVer = paramCursor.getLong(i);
      break label568;
      label1289:
      paramawge.sLanType = paramCursor.getShort(i);
      break label603;
      label1304:
      paramawge.strGotoUrl = paramCursor.getString(i);
      break label637;
      label1319:
      paramawge.sResSubType = paramCursor.getShort(i);
      break label672;
      label1334:
      paramawge.sPriority = paramCursor.getShort(i);
      break label707;
      label1349:
      paramawge.strResDesc = paramCursor.getString(i);
      break label741;
      label1364:
      paramawge.uiResId = paramCursor.getLong(i);
      break label776;
      label1379:
      paramawge.cDefaultState = ((byte)paramCursor.getShort(i));
      break label811;
      label1395:
      paramawge.cCanChangeState = ((byte)paramCursor.getShort(i));
      break label846;
      label1411:
      paramawge.isNew = ((byte)paramCursor.getShort(i));
      break label881;
      label1427:
      paramawge.cDataType = ((byte)paramCursor.getShort(i));
      break label916;
      label1443:
      paramawge.cLocalState = ((byte)paramCursor.getShort(i));
      break label951;
      label1459:
      paramawge.iPluginType = paramCursor.getInt(i);
      break label986;
      label1474:
      paramawge.timeStamp = paramCursor.getLong(i);
      break label1021;
      label1489:
      paramawge.strNewPluginDesc = paramCursor.getString(i);
      break label1055;
      label1504:
      paramawge.strNewPluginURL = paramCursor.getString(i);
      break label1089;
      label1519:
      paramawge.lebaSearchResultType = paramCursor.getInt(i);
      break label1124;
      label1534:
      paramawge.pluginSetTips = paramCursor.getString(i);
      break label1158;
      label1549:
      paramawge.pluginBg = paramCursor.getString(i);
    }
    label1564:
    paramawge.flags = paramCursor.getInt(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,strPkgName TEXT UNIQUE ,strResName TEXT ,strResURL TEXT ,uiCurVer INTEGER ,sLanType INTEGER ,strGotoUrl TEXT ,sResSubType INTEGER ,sPriority INTEGER ,strResDesc TEXT ,uiResId INTEGER ,cDefaultState INTEGER ,cCanChangeState INTEGER ,isNew INTEGER ,cDataType INTEGER ,cLocalState INTEGER ,iPluginType INTEGER ,timeStamp INTEGER ,strNewPluginDesc TEXT ,strNewPluginURL TEXT ,lebaSearchResultType INTEGER ,pluginSetTips TEXT ,pluginBg TEXT ,flags INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (ResourcePluginInfo)paramawge;
    paramContentValues.put("strPkgName", paramawge.strPkgName);
    paramContentValues.put("strResName", paramawge.strResName);
    paramContentValues.put("strResURL", paramawge.strResURL);
    paramContentValues.put("uiCurVer", Long.valueOf(paramawge.uiCurVer));
    paramContentValues.put("sLanType", Short.valueOf(paramawge.sLanType));
    paramContentValues.put("strGotoUrl", paramawge.strGotoUrl);
    paramContentValues.put("sResSubType", Short.valueOf(paramawge.sResSubType));
    paramContentValues.put("sPriority", Short.valueOf(paramawge.sPriority));
    paramContentValues.put("strResDesc", paramawge.strResDesc);
    paramContentValues.put("uiResId", Long.valueOf(paramawge.uiResId));
    paramContentValues.put("cDefaultState", Byte.valueOf(paramawge.cDefaultState));
    paramContentValues.put("cCanChangeState", Byte.valueOf(paramawge.cCanChangeState));
    paramContentValues.put("isNew", Byte.valueOf(paramawge.isNew));
    paramContentValues.put("cDataType", Byte.valueOf(paramawge.cDataType));
    paramContentValues.put("cLocalState", Byte.valueOf(paramawge.cLocalState));
    paramContentValues.put("iPluginType", Integer.valueOf(paramawge.iPluginType));
    paramContentValues.put("timeStamp", Long.valueOf(paramawge.timeStamp));
    paramContentValues.put("strNewPluginDesc", paramawge.strNewPluginDesc);
    paramContentValues.put("strNewPluginURL", paramawge.strNewPluginURL);
    paramContentValues.put("lebaSearchResultType", Integer.valueOf(paramawge.lebaSearchResultType));
    paramContentValues.put("pluginSetTips", paramawge.pluginSetTips);
    paramContentValues.put("pluginBg", paramawge.pluginBg);
    paramContentValues.put("flags", Integer.valueOf(paramawge.flags));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awgy
 * JD-Core Version:    0.7.0.1
 */