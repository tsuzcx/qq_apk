import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukl
  extends aula
{
  public aukl()
  {
    this.a = 24;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramauko = (Emoticon)paramauko;
    if (paramaukz == null)
    {
      paramauko.eId = paramCursor.getString(paramCursor.getColumnIndex("eId"));
      paramauko.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      paramauko.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramauko.encryptKey = paramCursor.getString(paramCursor.getColumnIndex("encryptKey"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isSound")))
      {
        paramBoolean = true;
        paramauko.isSound = paramBoolean;
        paramauko.width = paramCursor.getInt(paramCursor.getColumnIndex("width"));
        paramauko.height = paramCursor.getInt(paramCursor.getColumnIndex("height"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("value"))) {
          break label477;
        }
        paramBoolean = true;
        label169:
        paramauko.value = paramBoolean;
        paramauko.magicValue = paramCursor.getString(paramCursor.getColumnIndex("magicValue"));
        paramauko.jobType = paramCursor.getInt(paramCursor.getColumnIndex("jobType"));
        paramauko.keyword = paramCursor.getString(paramCursor.getColumnIndex("keyword"));
        paramauko.keywords = paramCursor.getString(paramCursor.getColumnIndex("keywords"));
        paramauko.character = paramCursor.getString(paramCursor.getColumnIndex("character"));
        paramauko.extensionWidth = paramCursor.getInt(paramCursor.getColumnIndex("extensionWidth"));
        paramauko.extensionHeight = paramCursor.getInt(paramCursor.getColumnIndex("extensionHeight"));
        paramauko.businessExtra = paramCursor.getString(paramCursor.getColumnIndex("businessExtra"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isAPNG"))) {
          break label482;
        }
      }
      label477:
      label482:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramauko.isAPNG = paramBoolean;
        paramauko.ipsiteUrl = paramCursor.getString(paramCursor.getColumnIndex("ipsiteUrl"));
        paramauko.ipsiteName = paramCursor.getString(paramCursor.getColumnIndex("ipsiteName"));
        paramauko.exposeNum = paramCursor.getInt(paramCursor.getColumnIndex("exposeNum"));
        paramauko.clickNum = paramCursor.getInt(paramCursor.getColumnIndex("clickNum"));
        paramauko.voicePrint = paramCursor.getString(paramCursor.getColumnIndex("voicePrint"));
        paramauko.backColor = paramCursor.getString(paramCursor.getColumnIndex("backColor"));
        paramauko.volumeColor = paramCursor.getString(paramCursor.getColumnIndex("volumeColor"));
        return paramauko;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label169;
      }
    }
    int i = paramCursor.getColumnIndex("eId");
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("eId", String.class));
      i = paramCursor.getColumnIndex("epId");
      if (i != -1) {
        break label1330;
      }
      paramaukz.a(new NoColumnError("epId", String.class));
      label555:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label1345;
      }
      paramaukz.a(new NoColumnError("name", String.class));
      label589:
      i = paramCursor.getColumnIndex("encryptKey");
      if (i != -1) {
        break label1360;
      }
      paramaukz.a(new NoColumnError("encryptKey", String.class));
      label623:
      i = paramCursor.getColumnIndex("isSound");
      if (i != -1) {
        break label1375;
      }
      paramaukz.a(new NoColumnError("isSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("width");
      if (i != -1) {
        break label1402;
      }
      paramaukz.a(new NoColumnError("width", Integer.TYPE));
      label693:
      i = paramCursor.getColumnIndex("height");
      if (i != -1) {
        break label1417;
      }
      paramaukz.a(new NoColumnError("height", Integer.TYPE));
      label728:
      i = paramCursor.getColumnIndex("value");
      if (i != -1) {
        break label1432;
      }
      paramaukz.a(new NoColumnError("value", Boolean.TYPE));
      i = paramCursor.getColumnIndex("magicValue");
      if (i != -1) {
        break label1459;
      }
      paramaukz.a(new NoColumnError("magicValue", String.class));
      label797:
      i = paramCursor.getColumnIndex("jobType");
      if (i != -1) {
        break label1474;
      }
      paramaukz.a(new NoColumnError("jobType", Integer.TYPE));
      label832:
      i = paramCursor.getColumnIndex("keyword");
      if (i != -1) {
        break label1489;
      }
      paramaukz.a(new NoColumnError("keyword", String.class));
      label866:
      i = paramCursor.getColumnIndex("keywords");
      if (i != -1) {
        break label1504;
      }
      paramaukz.a(new NoColumnError("keywords", String.class));
      label900:
      i = paramCursor.getColumnIndex("character");
      if (i != -1) {
        break label1519;
      }
      paramaukz.a(new NoColumnError("character", String.class));
      label934:
      i = paramCursor.getColumnIndex("extensionWidth");
      if (i != -1) {
        break label1534;
      }
      paramaukz.a(new NoColumnError("extensionWidth", Integer.TYPE));
      label969:
      i = paramCursor.getColumnIndex("extensionHeight");
      if (i != -1) {
        break label1549;
      }
      paramaukz.a(new NoColumnError("extensionHeight", Integer.TYPE));
      label1004:
      i = paramCursor.getColumnIndex("businessExtra");
      if (i != -1) {
        break label1564;
      }
      paramaukz.a(new NoColumnError("businessExtra", String.class));
      label1038:
      i = paramCursor.getColumnIndex("isAPNG");
      if (i != -1) {
        break label1579;
      }
      paramaukz.a(new NoColumnError("isAPNG", Boolean.TYPE));
      i = paramCursor.getColumnIndex("ipsiteUrl");
      if (i != -1) {
        break label1607;
      }
      paramaukz.a(new NoColumnError("ipsiteUrl", String.class));
      label1107:
      i = paramCursor.getColumnIndex("ipsiteName");
      if (i != -1) {
        break label1622;
      }
      paramaukz.a(new NoColumnError("ipsiteName", String.class));
      label1141:
      i = paramCursor.getColumnIndex("exposeNum");
      if (i != -1) {
        break label1637;
      }
      paramaukz.a(new NoColumnError("exposeNum", Integer.TYPE));
      label1176:
      i = paramCursor.getColumnIndex("clickNum");
      if (i != -1) {
        break label1652;
      }
      paramaukz.a(new NoColumnError("clickNum", Integer.TYPE));
      label1211:
      i = paramCursor.getColumnIndex("voicePrint");
      if (i != -1) {
        break label1667;
      }
      paramaukz.a(new NoColumnError("voicePrint", String.class));
      label1245:
      i = paramCursor.getColumnIndex("backColor");
      if (i != -1) {
        break label1682;
      }
      paramaukz.a(new NoColumnError("backColor", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("volumeColor");
      if (i != -1) {
        break label1697;
      }
      paramaukz.a(new NoColumnError("volumeColor", String.class));
      return paramauko;
      paramauko.eId = paramCursor.getString(i);
      break;
      label1330:
      paramauko.epId = paramCursor.getString(i);
      break label555;
      label1345:
      paramauko.name = paramCursor.getString(i);
      break label589;
      label1360:
      paramauko.encryptKey = paramCursor.getString(i);
      break label623;
      label1375:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isSound = paramBoolean;
        break;
      }
      label1402:
      paramauko.width = paramCursor.getInt(i);
      break label693;
      label1417:
      paramauko.height = paramCursor.getInt(i);
      break label728;
      label1432:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.value = paramBoolean;
        break;
      }
      label1459:
      paramauko.magicValue = paramCursor.getString(i);
      break label797;
      label1474:
      paramauko.jobType = paramCursor.getInt(i);
      break label832;
      label1489:
      paramauko.keyword = paramCursor.getString(i);
      break label866;
      label1504:
      paramauko.keywords = paramCursor.getString(i);
      break label900;
      label1519:
      paramauko.character = paramCursor.getString(i);
      break label934;
      label1534:
      paramauko.extensionWidth = paramCursor.getInt(i);
      break label969;
      label1549:
      paramauko.extensionHeight = paramCursor.getInt(i);
      break label1004;
      label1564:
      paramauko.businessExtra = paramCursor.getString(i);
      break label1038;
      label1579:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramauko.isAPNG = paramBoolean;
        break;
      }
      label1607:
      paramauko.ipsiteUrl = paramCursor.getString(i);
      break label1107;
      label1622:
      paramauko.ipsiteName = paramCursor.getString(i);
      break label1141;
      label1637:
      paramauko.exposeNum = paramCursor.getInt(i);
      break label1176;
      label1652:
      paramauko.clickNum = paramCursor.getInt(i);
      break label1211;
      label1667:
      paramauko.voicePrint = paramCursor.getString(i);
      break label1245;
      label1682:
      paramauko.backColor = paramCursor.getString(i);
    }
    label1697:
    paramauko.volumeColor = paramCursor.getString(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,eId TEXT ,epId TEXT ,name TEXT ,encryptKey TEXT ,isSound INTEGER ,width INTEGER ,height INTEGER ,value INTEGER ,magicValue TEXT ,jobType INTEGER ,keyword TEXT ,keywords TEXT ,character TEXT ,extensionWidth INTEGER ,extensionHeight INTEGER ,businessExtra TEXT ,isAPNG INTEGER ,ipsiteUrl TEXT ,ipsiteName TEXT ,exposeNum INTEGER ,clickNum INTEGER ,voicePrint TEXT ,backColor TEXT ,volumeColor TEXT,UNIQUE(eId,epId) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (Emoticon)paramauko;
    paramContentValues.put("eId", paramauko.eId);
    paramContentValues.put("epId", paramauko.epId);
    paramContentValues.put("name", paramauko.name);
    paramContentValues.put("encryptKey", paramauko.encryptKey);
    paramContentValues.put("isSound", Boolean.valueOf(paramauko.isSound));
    paramContentValues.put("width", Integer.valueOf(paramauko.width));
    paramContentValues.put("height", Integer.valueOf(paramauko.height));
    paramContentValues.put("value", Boolean.valueOf(paramauko.value));
    paramContentValues.put("magicValue", paramauko.magicValue);
    paramContentValues.put("jobType", Integer.valueOf(paramauko.jobType));
    paramContentValues.put("keyword", paramauko.keyword);
    paramContentValues.put("keywords", paramauko.keywords);
    paramContentValues.put("character", paramauko.character);
    paramContentValues.put("extensionWidth", Integer.valueOf(paramauko.extensionWidth));
    paramContentValues.put("extensionHeight", Integer.valueOf(paramauko.extensionHeight));
    paramContentValues.put("businessExtra", paramauko.businessExtra);
    paramContentValues.put("isAPNG", Boolean.valueOf(paramauko.isAPNG));
    paramContentValues.put("ipsiteUrl", paramauko.ipsiteUrl);
    paramContentValues.put("ipsiteName", paramauko.ipsiteName);
    paramContentValues.put("exposeNum", Integer.valueOf(paramauko.exposeNum));
    paramContentValues.put("clickNum", Integer.valueOf(paramauko.clickNum));
    paramContentValues.put("voicePrint", paramauko.voicePrint);
    paramContentValues.put("backColor", paramauko.backColor);
    paramContentValues.put("volumeColor", paramauko.volumeColor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukl
 * JD-Core Version:    0.7.0.1
 */