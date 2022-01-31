import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awgb
  extends awgq
{
  public awgb()
  {
    this.a = 24;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawge = (Emoticon)paramawge;
    if (paramawgp == null)
    {
      paramawge.eId = paramCursor.getString(paramCursor.getColumnIndex("eId"));
      paramawge.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      paramawge.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramawge.encryptKey = paramCursor.getString(paramCursor.getColumnIndex("encryptKey"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isSound")))
      {
        paramBoolean = true;
        paramawge.isSound = paramBoolean;
        paramawge.width = paramCursor.getInt(paramCursor.getColumnIndex("width"));
        paramawge.height = paramCursor.getInt(paramCursor.getColumnIndex("height"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("value"))) {
          break label477;
        }
        paramBoolean = true;
        label169:
        paramawge.value = paramBoolean;
        paramawge.magicValue = paramCursor.getString(paramCursor.getColumnIndex("magicValue"));
        paramawge.jobType = paramCursor.getInt(paramCursor.getColumnIndex("jobType"));
        paramawge.keyword = paramCursor.getString(paramCursor.getColumnIndex("keyword"));
        paramawge.keywords = paramCursor.getString(paramCursor.getColumnIndex("keywords"));
        paramawge.character = paramCursor.getString(paramCursor.getColumnIndex("character"));
        paramawge.extensionWidth = paramCursor.getInt(paramCursor.getColumnIndex("extensionWidth"));
        paramawge.extensionHeight = paramCursor.getInt(paramCursor.getColumnIndex("extensionHeight"));
        paramawge.businessExtra = paramCursor.getString(paramCursor.getColumnIndex("businessExtra"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isAPNG"))) {
          break label482;
        }
      }
      label477:
      label482:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramawge.isAPNG = paramBoolean;
        paramawge.ipsiteUrl = paramCursor.getString(paramCursor.getColumnIndex("ipsiteUrl"));
        paramawge.ipsiteName = paramCursor.getString(paramCursor.getColumnIndex("ipsiteName"));
        paramawge.exposeNum = paramCursor.getInt(paramCursor.getColumnIndex("exposeNum"));
        paramawge.clickNum = paramCursor.getInt(paramCursor.getColumnIndex("clickNum"));
        paramawge.voicePrint = paramCursor.getString(paramCursor.getColumnIndex("voicePrint"));
        paramawge.backColor = paramCursor.getString(paramCursor.getColumnIndex("backColor"));
        paramawge.volumeColor = paramCursor.getString(paramCursor.getColumnIndex("volumeColor"));
        return paramawge;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label169;
      }
    }
    int i = paramCursor.getColumnIndex("eId");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("eId", String.class));
      i = paramCursor.getColumnIndex("epId");
      if (i != -1) {
        break label1330;
      }
      paramawgp.a(new NoColumnError("epId", String.class));
      label555:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label1345;
      }
      paramawgp.a(new NoColumnError("name", String.class));
      label589:
      i = paramCursor.getColumnIndex("encryptKey");
      if (i != -1) {
        break label1360;
      }
      paramawgp.a(new NoColumnError("encryptKey", String.class));
      label623:
      i = paramCursor.getColumnIndex("isSound");
      if (i != -1) {
        break label1375;
      }
      paramawgp.a(new NoColumnError("isSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("width");
      if (i != -1) {
        break label1402;
      }
      paramawgp.a(new NoColumnError("width", Integer.TYPE));
      label693:
      i = paramCursor.getColumnIndex("height");
      if (i != -1) {
        break label1417;
      }
      paramawgp.a(new NoColumnError("height", Integer.TYPE));
      label728:
      i = paramCursor.getColumnIndex("value");
      if (i != -1) {
        break label1432;
      }
      paramawgp.a(new NoColumnError("value", Boolean.TYPE));
      i = paramCursor.getColumnIndex("magicValue");
      if (i != -1) {
        break label1459;
      }
      paramawgp.a(new NoColumnError("magicValue", String.class));
      label797:
      i = paramCursor.getColumnIndex("jobType");
      if (i != -1) {
        break label1474;
      }
      paramawgp.a(new NoColumnError("jobType", Integer.TYPE));
      label832:
      i = paramCursor.getColumnIndex("keyword");
      if (i != -1) {
        break label1489;
      }
      paramawgp.a(new NoColumnError("keyword", String.class));
      label866:
      i = paramCursor.getColumnIndex("keywords");
      if (i != -1) {
        break label1504;
      }
      paramawgp.a(new NoColumnError("keywords", String.class));
      label900:
      i = paramCursor.getColumnIndex("character");
      if (i != -1) {
        break label1519;
      }
      paramawgp.a(new NoColumnError("character", String.class));
      label934:
      i = paramCursor.getColumnIndex("extensionWidth");
      if (i != -1) {
        break label1534;
      }
      paramawgp.a(new NoColumnError("extensionWidth", Integer.TYPE));
      label969:
      i = paramCursor.getColumnIndex("extensionHeight");
      if (i != -1) {
        break label1549;
      }
      paramawgp.a(new NoColumnError("extensionHeight", Integer.TYPE));
      label1004:
      i = paramCursor.getColumnIndex("businessExtra");
      if (i != -1) {
        break label1564;
      }
      paramawgp.a(new NoColumnError("businessExtra", String.class));
      label1038:
      i = paramCursor.getColumnIndex("isAPNG");
      if (i != -1) {
        break label1579;
      }
      paramawgp.a(new NoColumnError("isAPNG", Boolean.TYPE));
      i = paramCursor.getColumnIndex("ipsiteUrl");
      if (i != -1) {
        break label1607;
      }
      paramawgp.a(new NoColumnError("ipsiteUrl", String.class));
      label1107:
      i = paramCursor.getColumnIndex("ipsiteName");
      if (i != -1) {
        break label1622;
      }
      paramawgp.a(new NoColumnError("ipsiteName", String.class));
      label1141:
      i = paramCursor.getColumnIndex("exposeNum");
      if (i != -1) {
        break label1637;
      }
      paramawgp.a(new NoColumnError("exposeNum", Integer.TYPE));
      label1176:
      i = paramCursor.getColumnIndex("clickNum");
      if (i != -1) {
        break label1652;
      }
      paramawgp.a(new NoColumnError("clickNum", Integer.TYPE));
      label1211:
      i = paramCursor.getColumnIndex("voicePrint");
      if (i != -1) {
        break label1667;
      }
      paramawgp.a(new NoColumnError("voicePrint", String.class));
      label1245:
      i = paramCursor.getColumnIndex("backColor");
      if (i != -1) {
        break label1682;
      }
      paramawgp.a(new NoColumnError("backColor", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("volumeColor");
      if (i != -1) {
        break label1697;
      }
      paramawgp.a(new NoColumnError("volumeColor", String.class));
      return paramawge;
      paramawge.eId = paramCursor.getString(i);
      break;
      label1330:
      paramawge.epId = paramCursor.getString(i);
      break label555;
      label1345:
      paramawge.name = paramCursor.getString(i);
      break label589;
      label1360:
      paramawge.encryptKey = paramCursor.getString(i);
      break label623;
      label1375:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isSound = paramBoolean;
        break;
      }
      label1402:
      paramawge.width = paramCursor.getInt(i);
      break label693;
      label1417:
      paramawge.height = paramCursor.getInt(i);
      break label728;
      label1432:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.value = paramBoolean;
        break;
      }
      label1459:
      paramawge.magicValue = paramCursor.getString(i);
      break label797;
      label1474:
      paramawge.jobType = paramCursor.getInt(i);
      break label832;
      label1489:
      paramawge.keyword = paramCursor.getString(i);
      break label866;
      label1504:
      paramawge.keywords = paramCursor.getString(i);
      break label900;
      label1519:
      paramawge.character = paramCursor.getString(i);
      break label934;
      label1534:
      paramawge.extensionWidth = paramCursor.getInt(i);
      break label969;
      label1549:
      paramawge.extensionHeight = paramCursor.getInt(i);
      break label1004;
      label1564:
      paramawge.businessExtra = paramCursor.getString(i);
      break label1038;
      label1579:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramawge.isAPNG = paramBoolean;
        break;
      }
      label1607:
      paramawge.ipsiteUrl = paramCursor.getString(i);
      break label1107;
      label1622:
      paramawge.ipsiteName = paramCursor.getString(i);
      break label1141;
      label1637:
      paramawge.exposeNum = paramCursor.getInt(i);
      break label1176;
      label1652:
      paramawge.clickNum = paramCursor.getInt(i);
      break label1211;
      label1667:
      paramawge.voicePrint = paramCursor.getString(i);
      break label1245;
      label1682:
      paramawge.backColor = paramCursor.getString(i);
    }
    label1697:
    paramawge.volumeColor = paramCursor.getString(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,eId TEXT ,epId TEXT ,name TEXT ,encryptKey TEXT ,isSound INTEGER ,width INTEGER ,height INTEGER ,value INTEGER ,magicValue TEXT ,jobType INTEGER ,keyword TEXT ,keywords TEXT ,character TEXT ,extensionWidth INTEGER ,extensionHeight INTEGER ,businessExtra TEXT ,isAPNG INTEGER ,ipsiteUrl TEXT ,ipsiteName TEXT ,exposeNum INTEGER ,clickNum INTEGER ,voicePrint TEXT ,backColor TEXT ,volumeColor TEXT,UNIQUE(eId,epId) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (Emoticon)paramawge;
    paramContentValues.put("eId", paramawge.eId);
    paramContentValues.put("epId", paramawge.epId);
    paramContentValues.put("name", paramawge.name);
    paramContentValues.put("encryptKey", paramawge.encryptKey);
    paramContentValues.put("isSound", Boolean.valueOf(paramawge.isSound));
    paramContentValues.put("width", Integer.valueOf(paramawge.width));
    paramContentValues.put("height", Integer.valueOf(paramawge.height));
    paramContentValues.put("value", Boolean.valueOf(paramawge.value));
    paramContentValues.put("magicValue", paramawge.magicValue);
    paramContentValues.put("jobType", Integer.valueOf(paramawge.jobType));
    paramContentValues.put("keyword", paramawge.keyword);
    paramContentValues.put("keywords", paramawge.keywords);
    paramContentValues.put("character", paramawge.character);
    paramContentValues.put("extensionWidth", Integer.valueOf(paramawge.extensionWidth));
    paramContentValues.put("extensionHeight", Integer.valueOf(paramawge.extensionHeight));
    paramContentValues.put("businessExtra", paramawge.businessExtra);
    paramContentValues.put("isAPNG", Boolean.valueOf(paramawge.isAPNG));
    paramContentValues.put("ipsiteUrl", paramawge.ipsiteUrl);
    paramContentValues.put("ipsiteName", paramawge.ipsiteName);
    paramContentValues.put("exposeNum", Integer.valueOf(paramawge.exposeNum));
    paramContentValues.put("clickNum", Integer.valueOf(paramawge.clickNum));
    paramContentValues.put("voicePrint", paramawge.voicePrint);
    paramContentValues.put("backColor", paramawge.backColor);
    paramContentValues.put("volumeColor", paramawge.volumeColor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awgb
 * JD-Core Version:    0.7.0.1
 */