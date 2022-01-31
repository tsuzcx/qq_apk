import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awcp
  extends awch
{
  public awcp()
  {
    this.a = 23;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    paramawbv = (ResourcePluginInfo)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.strPkgName = paramCursor.getString(paramCursor.getColumnIndex("strPkgName"));
      paramawbv.strResName = paramCursor.getString(paramCursor.getColumnIndex("strResName"));
      paramawbv.strResURL = paramCursor.getString(paramCursor.getColumnIndex("strResURL"));
      paramawbv.uiCurVer = paramCursor.getLong(paramCursor.getColumnIndex("uiCurVer"));
      paramawbv.sLanType = paramCursor.getShort(paramCursor.getColumnIndex("sLanType"));
      paramawbv.strGotoUrl = paramCursor.getString(paramCursor.getColumnIndex("strGotoUrl"));
      paramawbv.sResSubType = paramCursor.getShort(paramCursor.getColumnIndex("sResSubType"));
      paramawbv.sPriority = paramCursor.getShort(paramCursor.getColumnIndex("sPriority"));
      paramawbv.strResDesc = paramCursor.getString(paramCursor.getColumnIndex("strResDesc"));
      paramawbv.uiResId = paramCursor.getLong(paramCursor.getColumnIndex("uiResId"));
      paramawbv.cDefaultState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cDefaultState")));
      paramawbv.cCanChangeState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cCanChangeState")));
      paramawbv.isNew = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isNew")));
      paramawbv.cDataType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cDataType")));
      paramawbv.cLocalState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cLocalState")));
      paramawbv.iPluginType = paramCursor.getInt(paramCursor.getColumnIndex("iPluginType"));
      paramawbv.timeStamp = paramCursor.getLong(paramCursor.getColumnIndex("timeStamp"));
      paramawbv.strNewPluginDesc = paramCursor.getString(paramCursor.getColumnIndex("strNewPluginDesc"));
      paramawbv.strNewPluginURL = paramCursor.getString(paramCursor.getColumnIndex("strNewPluginURL"));
      paramawbv.lebaSearchResultType = paramCursor.getInt(paramCursor.getColumnIndex("lebaSearchResultType"));
      paramawbv.pluginSetTips = paramCursor.getString(paramCursor.getColumnIndex("pluginSetTips"));
      paramawbv.pluginBg = paramCursor.getString(paramCursor.getColumnIndex("pluginBg"));
      paramawbv.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      return paramawbv;
    }
    int i = paramCursor.getColumnIndex("strPkgName");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("strPkgName", String.class));
      i = paramCursor.getColumnIndex("strResName");
      if (i != -1) {
        break label1244;
      }
      paramawcg.a(new NoColumnError("strResName", String.class));
      label499:
      i = paramCursor.getColumnIndex("strResURL");
      if (i != -1) {
        break label1259;
      }
      paramawcg.a(new NoColumnError("strResURL", String.class));
      label533:
      i = paramCursor.getColumnIndex("uiCurVer");
      if (i != -1) {
        break label1274;
      }
      paramawcg.a(new NoColumnError("uiCurVer", Long.TYPE));
      label568:
      i = paramCursor.getColumnIndex("sLanType");
      if (i != -1) {
        break label1289;
      }
      paramawcg.a(new NoColumnError("sLanType", Short.TYPE));
      label603:
      i = paramCursor.getColumnIndex("strGotoUrl");
      if (i != -1) {
        break label1304;
      }
      paramawcg.a(new NoColumnError("strGotoUrl", String.class));
      label637:
      i = paramCursor.getColumnIndex("sResSubType");
      if (i != -1) {
        break label1319;
      }
      paramawcg.a(new NoColumnError("sResSubType", Short.TYPE));
      label672:
      i = paramCursor.getColumnIndex("sPriority");
      if (i != -1) {
        break label1334;
      }
      paramawcg.a(new NoColumnError("sPriority", Short.TYPE));
      label707:
      i = paramCursor.getColumnIndex("strResDesc");
      if (i != -1) {
        break label1349;
      }
      paramawcg.a(new NoColumnError("strResDesc", String.class));
      label741:
      i = paramCursor.getColumnIndex("uiResId");
      if (i != -1) {
        break label1364;
      }
      paramawcg.a(new NoColumnError("uiResId", Long.TYPE));
      label776:
      i = paramCursor.getColumnIndex("cDefaultState");
      if (i != -1) {
        break label1379;
      }
      paramawcg.a(new NoColumnError("cDefaultState", Byte.TYPE));
      label811:
      i = paramCursor.getColumnIndex("cCanChangeState");
      if (i != -1) {
        break label1395;
      }
      paramawcg.a(new NoColumnError("cCanChangeState", Byte.TYPE));
      label846:
      i = paramCursor.getColumnIndex("isNew");
      if (i != -1) {
        break label1411;
      }
      paramawcg.a(new NoColumnError("isNew", Byte.TYPE));
      label881:
      i = paramCursor.getColumnIndex("cDataType");
      if (i != -1) {
        break label1427;
      }
      paramawcg.a(new NoColumnError("cDataType", Byte.TYPE));
      label916:
      i = paramCursor.getColumnIndex("cLocalState");
      if (i != -1) {
        break label1443;
      }
      paramawcg.a(new NoColumnError("cLocalState", Byte.TYPE));
      label951:
      i = paramCursor.getColumnIndex("iPluginType");
      if (i != -1) {
        break label1459;
      }
      paramawcg.a(new NoColumnError("iPluginType", Integer.TYPE));
      label986:
      i = paramCursor.getColumnIndex("timeStamp");
      if (i != -1) {
        break label1474;
      }
      paramawcg.a(new NoColumnError("timeStamp", Long.TYPE));
      label1021:
      i = paramCursor.getColumnIndex("strNewPluginDesc");
      if (i != -1) {
        break label1489;
      }
      paramawcg.a(new NoColumnError("strNewPluginDesc", String.class));
      label1055:
      i = paramCursor.getColumnIndex("strNewPluginURL");
      if (i != -1) {
        break label1504;
      }
      paramawcg.a(new NoColumnError("strNewPluginURL", String.class));
      label1089:
      i = paramCursor.getColumnIndex("lebaSearchResultType");
      if (i != -1) {
        break label1519;
      }
      paramawcg.a(new NoColumnError("lebaSearchResultType", Integer.TYPE));
      label1124:
      i = paramCursor.getColumnIndex("pluginSetTips");
      if (i != -1) {
        break label1534;
      }
      paramawcg.a(new NoColumnError("pluginSetTips", String.class));
      label1158:
      i = paramCursor.getColumnIndex("pluginBg");
      if (i != -1) {
        break label1549;
      }
      paramawcg.a(new NoColumnError("pluginBg", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("flags");
      if (i != -1) {
        break label1564;
      }
      paramawcg.a(new NoColumnError("flags", Integer.TYPE));
      return paramawbv;
      paramawbv.strPkgName = paramCursor.getString(i);
      break;
      label1244:
      paramawbv.strResName = paramCursor.getString(i);
      break label499;
      label1259:
      paramawbv.strResURL = paramCursor.getString(i);
      break label533;
      label1274:
      paramawbv.uiCurVer = paramCursor.getLong(i);
      break label568;
      label1289:
      paramawbv.sLanType = paramCursor.getShort(i);
      break label603;
      label1304:
      paramawbv.strGotoUrl = paramCursor.getString(i);
      break label637;
      label1319:
      paramawbv.sResSubType = paramCursor.getShort(i);
      break label672;
      label1334:
      paramawbv.sPriority = paramCursor.getShort(i);
      break label707;
      label1349:
      paramawbv.strResDesc = paramCursor.getString(i);
      break label741;
      label1364:
      paramawbv.uiResId = paramCursor.getLong(i);
      break label776;
      label1379:
      paramawbv.cDefaultState = ((byte)paramCursor.getShort(i));
      break label811;
      label1395:
      paramawbv.cCanChangeState = ((byte)paramCursor.getShort(i));
      break label846;
      label1411:
      paramawbv.isNew = ((byte)paramCursor.getShort(i));
      break label881;
      label1427:
      paramawbv.cDataType = ((byte)paramCursor.getShort(i));
      break label916;
      label1443:
      paramawbv.cLocalState = ((byte)paramCursor.getShort(i));
      break label951;
      label1459:
      paramawbv.iPluginType = paramCursor.getInt(i);
      break label986;
      label1474:
      paramawbv.timeStamp = paramCursor.getLong(i);
      break label1021;
      label1489:
      paramawbv.strNewPluginDesc = paramCursor.getString(i);
      break label1055;
      label1504:
      paramawbv.strNewPluginURL = paramCursor.getString(i);
      break label1089;
      label1519:
      paramawbv.lebaSearchResultType = paramCursor.getInt(i);
      break label1124;
      label1534:
      paramawbv.pluginSetTips = paramCursor.getString(i);
      break label1158;
      label1549:
      paramawbv.pluginBg = paramCursor.getString(i);
    }
    label1564:
    paramawbv.flags = paramCursor.getInt(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,strPkgName TEXT UNIQUE ,strResName TEXT ,strResURL TEXT ,uiCurVer INTEGER ,sLanType INTEGER ,strGotoUrl TEXT ,sResSubType INTEGER ,sPriority INTEGER ,strResDesc TEXT ,uiResId INTEGER ,cDefaultState INTEGER ,cCanChangeState INTEGER ,isNew INTEGER ,cDataType INTEGER ,cLocalState INTEGER ,iPluginType INTEGER ,timeStamp INTEGER ,strNewPluginDesc TEXT ,strNewPluginURL TEXT ,lebaSearchResultType INTEGER ,pluginSetTips TEXT ,pluginBg TEXT ,flags INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (ResourcePluginInfo)paramawbv;
    paramContentValues.put("strPkgName", paramawbv.strPkgName);
    paramContentValues.put("strResName", paramawbv.strResName);
    paramContentValues.put("strResURL", paramawbv.strResURL);
    paramContentValues.put("uiCurVer", Long.valueOf(paramawbv.uiCurVer));
    paramContentValues.put("sLanType", Short.valueOf(paramawbv.sLanType));
    paramContentValues.put("strGotoUrl", paramawbv.strGotoUrl);
    paramContentValues.put("sResSubType", Short.valueOf(paramawbv.sResSubType));
    paramContentValues.put("sPriority", Short.valueOf(paramawbv.sPriority));
    paramContentValues.put("strResDesc", paramawbv.strResDesc);
    paramContentValues.put("uiResId", Long.valueOf(paramawbv.uiResId));
    paramContentValues.put("cDefaultState", Byte.valueOf(paramawbv.cDefaultState));
    paramContentValues.put("cCanChangeState", Byte.valueOf(paramawbv.cCanChangeState));
    paramContentValues.put("isNew", Byte.valueOf(paramawbv.isNew));
    paramContentValues.put("cDataType", Byte.valueOf(paramawbv.cDataType));
    paramContentValues.put("cLocalState", Byte.valueOf(paramawbv.cLocalState));
    paramContentValues.put("iPluginType", Integer.valueOf(paramawbv.iPluginType));
    paramContentValues.put("timeStamp", Long.valueOf(paramawbv.timeStamp));
    paramContentValues.put("strNewPluginDesc", paramawbv.strNewPluginDesc);
    paramContentValues.put("strNewPluginURL", paramawbv.strNewPluginURL);
    paramContentValues.put("lebaSearchResultType", Integer.valueOf(paramawbv.lebaSearchResultType));
    paramContentValues.put("pluginSetTips", paramawbv.pluginSetTips);
    paramContentValues.put("pluginBg", paramawbv.pluginBg);
    paramContentValues.put("flags", Integer.valueOf(paramawbv.flags));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awcp
 * JD-Core Version:    0.7.0.1
 */