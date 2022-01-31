import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atml
  extends atna
{
  public atml()
  {
    this.a = 24;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramatmo = (Emoticon)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.eId = paramCursor.getString(paramCursor.getColumnIndex("eId"));
      paramatmo.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      paramatmo.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramatmo.encryptKey = paramCursor.getString(paramCursor.getColumnIndex("encryptKey"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isSound")))
      {
        paramBoolean = true;
        paramatmo.isSound = paramBoolean;
        paramatmo.width = paramCursor.getInt(paramCursor.getColumnIndex("width"));
        paramatmo.height = paramCursor.getInt(paramCursor.getColumnIndex("height"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("value"))) {
          break label477;
        }
        paramBoolean = true;
        label169:
        paramatmo.value = paramBoolean;
        paramatmo.magicValue = paramCursor.getString(paramCursor.getColumnIndex("magicValue"));
        paramatmo.jobType = paramCursor.getInt(paramCursor.getColumnIndex("jobType"));
        paramatmo.keyword = paramCursor.getString(paramCursor.getColumnIndex("keyword"));
        paramatmo.keywords = paramCursor.getString(paramCursor.getColumnIndex("keywords"));
        paramatmo.character = paramCursor.getString(paramCursor.getColumnIndex("character"));
        paramatmo.extensionWidth = paramCursor.getInt(paramCursor.getColumnIndex("extensionWidth"));
        paramatmo.extensionHeight = paramCursor.getInt(paramCursor.getColumnIndex("extensionHeight"));
        paramatmo.businessExtra = paramCursor.getString(paramCursor.getColumnIndex("businessExtra"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isAPNG"))) {
          break label482;
        }
      }
      label477:
      label482:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramatmo.isAPNG = paramBoolean;
        paramatmo.ipsiteUrl = paramCursor.getString(paramCursor.getColumnIndex("ipsiteUrl"));
        paramatmo.ipsiteName = paramCursor.getString(paramCursor.getColumnIndex("ipsiteName"));
        paramatmo.exposeNum = paramCursor.getInt(paramCursor.getColumnIndex("exposeNum"));
        paramatmo.clickNum = paramCursor.getInt(paramCursor.getColumnIndex("clickNum"));
        paramatmo.voicePrint = paramCursor.getString(paramCursor.getColumnIndex("voicePrint"));
        paramatmo.backColor = paramCursor.getString(paramCursor.getColumnIndex("backColor"));
        paramatmo.volumeColor = paramCursor.getString(paramCursor.getColumnIndex("volumeColor"));
        return paramatmo;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label169;
      }
    }
    int i = paramCursor.getColumnIndex("eId");
    if (i == -1)
    {
      paramatmz.a(new NoColumnError("eId", String.class));
      i = paramCursor.getColumnIndex("epId");
      if (i != -1) {
        break label1330;
      }
      paramatmz.a(new NoColumnError("epId", String.class));
      label555:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label1345;
      }
      paramatmz.a(new NoColumnError("name", String.class));
      label589:
      i = paramCursor.getColumnIndex("encryptKey");
      if (i != -1) {
        break label1360;
      }
      paramatmz.a(new NoColumnError("encryptKey", String.class));
      label623:
      i = paramCursor.getColumnIndex("isSound");
      if (i != -1) {
        break label1375;
      }
      paramatmz.a(new NoColumnError("isSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("width");
      if (i != -1) {
        break label1402;
      }
      paramatmz.a(new NoColumnError("width", Integer.TYPE));
      label693:
      i = paramCursor.getColumnIndex("height");
      if (i != -1) {
        break label1417;
      }
      paramatmz.a(new NoColumnError("height", Integer.TYPE));
      label728:
      i = paramCursor.getColumnIndex("value");
      if (i != -1) {
        break label1432;
      }
      paramatmz.a(new NoColumnError("value", Boolean.TYPE));
      i = paramCursor.getColumnIndex("magicValue");
      if (i != -1) {
        break label1459;
      }
      paramatmz.a(new NoColumnError("magicValue", String.class));
      label797:
      i = paramCursor.getColumnIndex("jobType");
      if (i != -1) {
        break label1474;
      }
      paramatmz.a(new NoColumnError("jobType", Integer.TYPE));
      label832:
      i = paramCursor.getColumnIndex("keyword");
      if (i != -1) {
        break label1489;
      }
      paramatmz.a(new NoColumnError("keyword", String.class));
      label866:
      i = paramCursor.getColumnIndex("keywords");
      if (i != -1) {
        break label1504;
      }
      paramatmz.a(new NoColumnError("keywords", String.class));
      label900:
      i = paramCursor.getColumnIndex("character");
      if (i != -1) {
        break label1519;
      }
      paramatmz.a(new NoColumnError("character", String.class));
      label934:
      i = paramCursor.getColumnIndex("extensionWidth");
      if (i != -1) {
        break label1534;
      }
      paramatmz.a(new NoColumnError("extensionWidth", Integer.TYPE));
      label969:
      i = paramCursor.getColumnIndex("extensionHeight");
      if (i != -1) {
        break label1549;
      }
      paramatmz.a(new NoColumnError("extensionHeight", Integer.TYPE));
      label1004:
      i = paramCursor.getColumnIndex("businessExtra");
      if (i != -1) {
        break label1564;
      }
      paramatmz.a(new NoColumnError("businessExtra", String.class));
      label1038:
      i = paramCursor.getColumnIndex("isAPNG");
      if (i != -1) {
        break label1579;
      }
      paramatmz.a(new NoColumnError("isAPNG", Boolean.TYPE));
      i = paramCursor.getColumnIndex("ipsiteUrl");
      if (i != -1) {
        break label1607;
      }
      paramatmz.a(new NoColumnError("ipsiteUrl", String.class));
      label1107:
      i = paramCursor.getColumnIndex("ipsiteName");
      if (i != -1) {
        break label1622;
      }
      paramatmz.a(new NoColumnError("ipsiteName", String.class));
      label1141:
      i = paramCursor.getColumnIndex("exposeNum");
      if (i != -1) {
        break label1637;
      }
      paramatmz.a(new NoColumnError("exposeNum", Integer.TYPE));
      label1176:
      i = paramCursor.getColumnIndex("clickNum");
      if (i != -1) {
        break label1652;
      }
      paramatmz.a(new NoColumnError("clickNum", Integer.TYPE));
      label1211:
      i = paramCursor.getColumnIndex("voicePrint");
      if (i != -1) {
        break label1667;
      }
      paramatmz.a(new NoColumnError("voicePrint", String.class));
      label1245:
      i = paramCursor.getColumnIndex("backColor");
      if (i != -1) {
        break label1682;
      }
      paramatmz.a(new NoColumnError("backColor", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("volumeColor");
      if (i != -1) {
        break label1697;
      }
      paramatmz.a(new NoColumnError("volumeColor", String.class));
      return paramatmo;
      paramatmo.eId = paramCursor.getString(i);
      break;
      label1330:
      paramatmo.epId = paramCursor.getString(i);
      break label555;
      label1345:
      paramatmo.name = paramCursor.getString(i);
      break label589;
      label1360:
      paramatmo.encryptKey = paramCursor.getString(i);
      break label623;
      label1375:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isSound = paramBoolean;
        break;
      }
      label1402:
      paramatmo.width = paramCursor.getInt(i);
      break label693;
      label1417:
      paramatmo.height = paramCursor.getInt(i);
      break label728;
      label1432:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.value = paramBoolean;
        break;
      }
      label1459:
      paramatmo.magicValue = paramCursor.getString(i);
      break label797;
      label1474:
      paramatmo.jobType = paramCursor.getInt(i);
      break label832;
      label1489:
      paramatmo.keyword = paramCursor.getString(i);
      break label866;
      label1504:
      paramatmo.keywords = paramCursor.getString(i);
      break label900;
      label1519:
      paramatmo.character = paramCursor.getString(i);
      break label934;
      label1534:
      paramatmo.extensionWidth = paramCursor.getInt(i);
      break label969;
      label1549:
      paramatmo.extensionHeight = paramCursor.getInt(i);
      break label1004;
      label1564:
      paramatmo.businessExtra = paramCursor.getString(i);
      break label1038;
      label1579:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramatmo.isAPNG = paramBoolean;
        break;
      }
      label1607:
      paramatmo.ipsiteUrl = paramCursor.getString(i);
      break label1107;
      label1622:
      paramatmo.ipsiteName = paramCursor.getString(i);
      break label1141;
      label1637:
      paramatmo.exposeNum = paramCursor.getInt(i);
      break label1176;
      label1652:
      paramatmo.clickNum = paramCursor.getInt(i);
      break label1211;
      label1667:
      paramatmo.voicePrint = paramCursor.getString(i);
      break label1245;
      label1682:
      paramatmo.backColor = paramCursor.getString(i);
    }
    label1697:
    paramatmo.volumeColor = paramCursor.getString(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,eId TEXT ,epId TEXT ,name TEXT ,encryptKey TEXT ,isSound INTEGER ,width INTEGER ,height INTEGER ,value INTEGER ,magicValue TEXT ,jobType INTEGER ,keyword TEXT ,keywords TEXT ,character TEXT ,extensionWidth INTEGER ,extensionHeight INTEGER ,businessExtra TEXT ,isAPNG INTEGER ,ipsiteUrl TEXT ,ipsiteName TEXT ,exposeNum INTEGER ,clickNum INTEGER ,voicePrint TEXT ,backColor TEXT ,volumeColor TEXT,UNIQUE(eId,epId) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (Emoticon)paramatmo;
    paramContentValues.put("eId", paramatmo.eId);
    paramContentValues.put("epId", paramatmo.epId);
    paramContentValues.put("name", paramatmo.name);
    paramContentValues.put("encryptKey", paramatmo.encryptKey);
    paramContentValues.put("isSound", Boolean.valueOf(paramatmo.isSound));
    paramContentValues.put("width", Integer.valueOf(paramatmo.width));
    paramContentValues.put("height", Integer.valueOf(paramatmo.height));
    paramContentValues.put("value", Boolean.valueOf(paramatmo.value));
    paramContentValues.put("magicValue", paramatmo.magicValue);
    paramContentValues.put("jobType", Integer.valueOf(paramatmo.jobType));
    paramContentValues.put("keyword", paramatmo.keyword);
    paramContentValues.put("keywords", paramatmo.keywords);
    paramContentValues.put("character", paramatmo.character);
    paramContentValues.put("extensionWidth", Integer.valueOf(paramatmo.extensionWidth));
    paramContentValues.put("extensionHeight", Integer.valueOf(paramatmo.extensionHeight));
    paramContentValues.put("businessExtra", paramatmo.businessExtra);
    paramContentValues.put("isAPNG", Boolean.valueOf(paramatmo.isAPNG));
    paramContentValues.put("ipsiteUrl", paramatmo.ipsiteUrl);
    paramContentValues.put("ipsiteName", paramatmo.ipsiteName);
    paramContentValues.put("exposeNum", Integer.valueOf(paramatmo.exposeNum));
    paramContentValues.put("clickNum", Integer.valueOf(paramatmo.clickNum));
    paramContentValues.put("voicePrint", paramatmo.voicePrint);
    paramContentValues.put("backColor", paramatmo.backColor);
    paramContentValues.put("volumeColor", paramatmo.volumeColor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atml
 * JD-Core Version:    0.7.0.1
 */