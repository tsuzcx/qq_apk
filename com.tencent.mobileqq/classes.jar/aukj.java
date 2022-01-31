import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukj
  extends auky
{
  public aukj()
  {
    this.a = 24;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramaukm = (Emoticon)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.eId = paramCursor.getString(paramCursor.getColumnIndex("eId"));
      paramaukm.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      paramaukm.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramaukm.encryptKey = paramCursor.getString(paramCursor.getColumnIndex("encryptKey"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isSound")))
      {
        paramBoolean = true;
        paramaukm.isSound = paramBoolean;
        paramaukm.width = paramCursor.getInt(paramCursor.getColumnIndex("width"));
        paramaukm.height = paramCursor.getInt(paramCursor.getColumnIndex("height"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("value"))) {
          break label477;
        }
        paramBoolean = true;
        label169:
        paramaukm.value = paramBoolean;
        paramaukm.magicValue = paramCursor.getString(paramCursor.getColumnIndex("magicValue"));
        paramaukm.jobType = paramCursor.getInt(paramCursor.getColumnIndex("jobType"));
        paramaukm.keyword = paramCursor.getString(paramCursor.getColumnIndex("keyword"));
        paramaukm.keywords = paramCursor.getString(paramCursor.getColumnIndex("keywords"));
        paramaukm.character = paramCursor.getString(paramCursor.getColumnIndex("character"));
        paramaukm.extensionWidth = paramCursor.getInt(paramCursor.getColumnIndex("extensionWidth"));
        paramaukm.extensionHeight = paramCursor.getInt(paramCursor.getColumnIndex("extensionHeight"));
        paramaukm.businessExtra = paramCursor.getString(paramCursor.getColumnIndex("businessExtra"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isAPNG"))) {
          break label482;
        }
      }
      label477:
      label482:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramaukm.isAPNG = paramBoolean;
        paramaukm.ipsiteUrl = paramCursor.getString(paramCursor.getColumnIndex("ipsiteUrl"));
        paramaukm.ipsiteName = paramCursor.getString(paramCursor.getColumnIndex("ipsiteName"));
        paramaukm.exposeNum = paramCursor.getInt(paramCursor.getColumnIndex("exposeNum"));
        paramaukm.clickNum = paramCursor.getInt(paramCursor.getColumnIndex("clickNum"));
        paramaukm.voicePrint = paramCursor.getString(paramCursor.getColumnIndex("voicePrint"));
        paramaukm.backColor = paramCursor.getString(paramCursor.getColumnIndex("backColor"));
        paramaukm.volumeColor = paramCursor.getString(paramCursor.getColumnIndex("volumeColor"));
        return paramaukm;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label169;
      }
    }
    int i = paramCursor.getColumnIndex("eId");
    if (i == -1)
    {
      paramaukx.a(new NoColumnError("eId", String.class));
      i = paramCursor.getColumnIndex("epId");
      if (i != -1) {
        break label1330;
      }
      paramaukx.a(new NoColumnError("epId", String.class));
      label555:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label1345;
      }
      paramaukx.a(new NoColumnError("name", String.class));
      label589:
      i = paramCursor.getColumnIndex("encryptKey");
      if (i != -1) {
        break label1360;
      }
      paramaukx.a(new NoColumnError("encryptKey", String.class));
      label623:
      i = paramCursor.getColumnIndex("isSound");
      if (i != -1) {
        break label1375;
      }
      paramaukx.a(new NoColumnError("isSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("width");
      if (i != -1) {
        break label1402;
      }
      paramaukx.a(new NoColumnError("width", Integer.TYPE));
      label693:
      i = paramCursor.getColumnIndex("height");
      if (i != -1) {
        break label1417;
      }
      paramaukx.a(new NoColumnError("height", Integer.TYPE));
      label728:
      i = paramCursor.getColumnIndex("value");
      if (i != -1) {
        break label1432;
      }
      paramaukx.a(new NoColumnError("value", Boolean.TYPE));
      i = paramCursor.getColumnIndex("magicValue");
      if (i != -1) {
        break label1459;
      }
      paramaukx.a(new NoColumnError("magicValue", String.class));
      label797:
      i = paramCursor.getColumnIndex("jobType");
      if (i != -1) {
        break label1474;
      }
      paramaukx.a(new NoColumnError("jobType", Integer.TYPE));
      label832:
      i = paramCursor.getColumnIndex("keyword");
      if (i != -1) {
        break label1489;
      }
      paramaukx.a(new NoColumnError("keyword", String.class));
      label866:
      i = paramCursor.getColumnIndex("keywords");
      if (i != -1) {
        break label1504;
      }
      paramaukx.a(new NoColumnError("keywords", String.class));
      label900:
      i = paramCursor.getColumnIndex("character");
      if (i != -1) {
        break label1519;
      }
      paramaukx.a(new NoColumnError("character", String.class));
      label934:
      i = paramCursor.getColumnIndex("extensionWidth");
      if (i != -1) {
        break label1534;
      }
      paramaukx.a(new NoColumnError("extensionWidth", Integer.TYPE));
      label969:
      i = paramCursor.getColumnIndex("extensionHeight");
      if (i != -1) {
        break label1549;
      }
      paramaukx.a(new NoColumnError("extensionHeight", Integer.TYPE));
      label1004:
      i = paramCursor.getColumnIndex("businessExtra");
      if (i != -1) {
        break label1564;
      }
      paramaukx.a(new NoColumnError("businessExtra", String.class));
      label1038:
      i = paramCursor.getColumnIndex("isAPNG");
      if (i != -1) {
        break label1579;
      }
      paramaukx.a(new NoColumnError("isAPNG", Boolean.TYPE));
      i = paramCursor.getColumnIndex("ipsiteUrl");
      if (i != -1) {
        break label1607;
      }
      paramaukx.a(new NoColumnError("ipsiteUrl", String.class));
      label1107:
      i = paramCursor.getColumnIndex("ipsiteName");
      if (i != -1) {
        break label1622;
      }
      paramaukx.a(new NoColumnError("ipsiteName", String.class));
      label1141:
      i = paramCursor.getColumnIndex("exposeNum");
      if (i != -1) {
        break label1637;
      }
      paramaukx.a(new NoColumnError("exposeNum", Integer.TYPE));
      label1176:
      i = paramCursor.getColumnIndex("clickNum");
      if (i != -1) {
        break label1652;
      }
      paramaukx.a(new NoColumnError("clickNum", Integer.TYPE));
      label1211:
      i = paramCursor.getColumnIndex("voicePrint");
      if (i != -1) {
        break label1667;
      }
      paramaukx.a(new NoColumnError("voicePrint", String.class));
      label1245:
      i = paramCursor.getColumnIndex("backColor");
      if (i != -1) {
        break label1682;
      }
      paramaukx.a(new NoColumnError("backColor", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("volumeColor");
      if (i != -1) {
        break label1697;
      }
      paramaukx.a(new NoColumnError("volumeColor", String.class));
      return paramaukm;
      paramaukm.eId = paramCursor.getString(i);
      break;
      label1330:
      paramaukm.epId = paramCursor.getString(i);
      break label555;
      label1345:
      paramaukm.name = paramCursor.getString(i);
      break label589;
      label1360:
      paramaukm.encryptKey = paramCursor.getString(i);
      break label623;
      label1375:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isSound = paramBoolean;
        break;
      }
      label1402:
      paramaukm.width = paramCursor.getInt(i);
      break label693;
      label1417:
      paramaukm.height = paramCursor.getInt(i);
      break label728;
      label1432:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.value = paramBoolean;
        break;
      }
      label1459:
      paramaukm.magicValue = paramCursor.getString(i);
      break label797;
      label1474:
      paramaukm.jobType = paramCursor.getInt(i);
      break label832;
      label1489:
      paramaukm.keyword = paramCursor.getString(i);
      break label866;
      label1504:
      paramaukm.keywords = paramCursor.getString(i);
      break label900;
      label1519:
      paramaukm.character = paramCursor.getString(i);
      break label934;
      label1534:
      paramaukm.extensionWidth = paramCursor.getInt(i);
      break label969;
      label1549:
      paramaukm.extensionHeight = paramCursor.getInt(i);
      break label1004;
      label1564:
      paramaukm.businessExtra = paramCursor.getString(i);
      break label1038;
      label1579:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramaukm.isAPNG = paramBoolean;
        break;
      }
      label1607:
      paramaukm.ipsiteUrl = paramCursor.getString(i);
      break label1107;
      label1622:
      paramaukm.ipsiteName = paramCursor.getString(i);
      break label1141;
      label1637:
      paramaukm.exposeNum = paramCursor.getInt(i);
      break label1176;
      label1652:
      paramaukm.clickNum = paramCursor.getInt(i);
      break label1211;
      label1667:
      paramaukm.voicePrint = paramCursor.getString(i);
      break label1245;
      label1682:
      paramaukm.backColor = paramCursor.getString(i);
    }
    label1697:
    paramaukm.volumeColor = paramCursor.getString(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,eId TEXT ,epId TEXT ,name TEXT ,encryptKey TEXT ,isSound INTEGER ,width INTEGER ,height INTEGER ,value INTEGER ,magicValue TEXT ,jobType INTEGER ,keyword TEXT ,keywords TEXT ,character TEXT ,extensionWidth INTEGER ,extensionHeight INTEGER ,businessExtra TEXT ,isAPNG INTEGER ,ipsiteUrl TEXT ,ipsiteName TEXT ,exposeNum INTEGER ,clickNum INTEGER ,voicePrint TEXT ,backColor TEXT ,volumeColor TEXT,UNIQUE(eId,epId) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (Emoticon)paramaukm;
    paramContentValues.put("eId", paramaukm.eId);
    paramContentValues.put("epId", paramaukm.epId);
    paramContentValues.put("name", paramaukm.name);
    paramContentValues.put("encryptKey", paramaukm.encryptKey);
    paramContentValues.put("isSound", Boolean.valueOf(paramaukm.isSound));
    paramContentValues.put("width", Integer.valueOf(paramaukm.width));
    paramContentValues.put("height", Integer.valueOf(paramaukm.height));
    paramContentValues.put("value", Boolean.valueOf(paramaukm.value));
    paramContentValues.put("magicValue", paramaukm.magicValue);
    paramContentValues.put("jobType", Integer.valueOf(paramaukm.jobType));
    paramContentValues.put("keyword", paramaukm.keyword);
    paramContentValues.put("keywords", paramaukm.keywords);
    paramContentValues.put("character", paramaukm.character);
    paramContentValues.put("extensionWidth", Integer.valueOf(paramaukm.extensionWidth));
    paramContentValues.put("extensionHeight", Integer.valueOf(paramaukm.extensionHeight));
    paramContentValues.put("businessExtra", paramaukm.businessExtra);
    paramContentValues.put("isAPNG", Boolean.valueOf(paramaukm.isAPNG));
    paramContentValues.put("ipsiteUrl", paramaukm.ipsiteUrl);
    paramContentValues.put("ipsiteName", paramaukm.ipsiteName);
    paramContentValues.put("exposeNum", Integer.valueOf(paramaukm.exposeNum));
    paramContentValues.put("clickNum", Integer.valueOf(paramaukm.clickNum));
    paramContentValues.put("voicePrint", paramaukm.voicePrint);
    paramContentValues.put("backColor", paramaukm.backColor);
    paramContentValues.put("volumeColor", paramaukm.volumeColor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukj
 * JD-Core Version:    0.7.0.1
 */