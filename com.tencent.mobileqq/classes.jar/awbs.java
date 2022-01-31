import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awbs
  extends awch
{
  public awbs()
  {
    this.a = 24;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawbv = (Emoticon)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.eId = paramCursor.getString(paramCursor.getColumnIndex("eId"));
      paramawbv.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      paramawbv.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramawbv.encryptKey = paramCursor.getString(paramCursor.getColumnIndex("encryptKey"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isSound")))
      {
        paramBoolean = true;
        paramawbv.isSound = paramBoolean;
        paramawbv.width = paramCursor.getInt(paramCursor.getColumnIndex("width"));
        paramawbv.height = paramCursor.getInt(paramCursor.getColumnIndex("height"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("value"))) {
          break label477;
        }
        paramBoolean = true;
        label169:
        paramawbv.value = paramBoolean;
        paramawbv.magicValue = paramCursor.getString(paramCursor.getColumnIndex("magicValue"));
        paramawbv.jobType = paramCursor.getInt(paramCursor.getColumnIndex("jobType"));
        paramawbv.keyword = paramCursor.getString(paramCursor.getColumnIndex("keyword"));
        paramawbv.keywords = paramCursor.getString(paramCursor.getColumnIndex("keywords"));
        paramawbv.character = paramCursor.getString(paramCursor.getColumnIndex("character"));
        paramawbv.extensionWidth = paramCursor.getInt(paramCursor.getColumnIndex("extensionWidth"));
        paramawbv.extensionHeight = paramCursor.getInt(paramCursor.getColumnIndex("extensionHeight"));
        paramawbv.businessExtra = paramCursor.getString(paramCursor.getColumnIndex("businessExtra"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isAPNG"))) {
          break label482;
        }
      }
      label477:
      label482:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramawbv.isAPNG = paramBoolean;
        paramawbv.ipsiteUrl = paramCursor.getString(paramCursor.getColumnIndex("ipsiteUrl"));
        paramawbv.ipsiteName = paramCursor.getString(paramCursor.getColumnIndex("ipsiteName"));
        paramawbv.exposeNum = paramCursor.getInt(paramCursor.getColumnIndex("exposeNum"));
        paramawbv.clickNum = paramCursor.getInt(paramCursor.getColumnIndex("clickNum"));
        paramawbv.voicePrint = paramCursor.getString(paramCursor.getColumnIndex("voicePrint"));
        paramawbv.backColor = paramCursor.getString(paramCursor.getColumnIndex("backColor"));
        paramawbv.volumeColor = paramCursor.getString(paramCursor.getColumnIndex("volumeColor"));
        return paramawbv;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label169;
      }
    }
    int i = paramCursor.getColumnIndex("eId");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("eId", String.class));
      i = paramCursor.getColumnIndex("epId");
      if (i != -1) {
        break label1330;
      }
      paramawcg.a(new NoColumnError("epId", String.class));
      label555:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label1345;
      }
      paramawcg.a(new NoColumnError("name", String.class));
      label589:
      i = paramCursor.getColumnIndex("encryptKey");
      if (i != -1) {
        break label1360;
      }
      paramawcg.a(new NoColumnError("encryptKey", String.class));
      label623:
      i = paramCursor.getColumnIndex("isSound");
      if (i != -1) {
        break label1375;
      }
      paramawcg.a(new NoColumnError("isSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("width");
      if (i != -1) {
        break label1402;
      }
      paramawcg.a(new NoColumnError("width", Integer.TYPE));
      label693:
      i = paramCursor.getColumnIndex("height");
      if (i != -1) {
        break label1417;
      }
      paramawcg.a(new NoColumnError("height", Integer.TYPE));
      label728:
      i = paramCursor.getColumnIndex("value");
      if (i != -1) {
        break label1432;
      }
      paramawcg.a(new NoColumnError("value", Boolean.TYPE));
      i = paramCursor.getColumnIndex("magicValue");
      if (i != -1) {
        break label1459;
      }
      paramawcg.a(new NoColumnError("magicValue", String.class));
      label797:
      i = paramCursor.getColumnIndex("jobType");
      if (i != -1) {
        break label1474;
      }
      paramawcg.a(new NoColumnError("jobType", Integer.TYPE));
      label832:
      i = paramCursor.getColumnIndex("keyword");
      if (i != -1) {
        break label1489;
      }
      paramawcg.a(new NoColumnError("keyword", String.class));
      label866:
      i = paramCursor.getColumnIndex("keywords");
      if (i != -1) {
        break label1504;
      }
      paramawcg.a(new NoColumnError("keywords", String.class));
      label900:
      i = paramCursor.getColumnIndex("character");
      if (i != -1) {
        break label1519;
      }
      paramawcg.a(new NoColumnError("character", String.class));
      label934:
      i = paramCursor.getColumnIndex("extensionWidth");
      if (i != -1) {
        break label1534;
      }
      paramawcg.a(new NoColumnError("extensionWidth", Integer.TYPE));
      label969:
      i = paramCursor.getColumnIndex("extensionHeight");
      if (i != -1) {
        break label1549;
      }
      paramawcg.a(new NoColumnError("extensionHeight", Integer.TYPE));
      label1004:
      i = paramCursor.getColumnIndex("businessExtra");
      if (i != -1) {
        break label1564;
      }
      paramawcg.a(new NoColumnError("businessExtra", String.class));
      label1038:
      i = paramCursor.getColumnIndex("isAPNG");
      if (i != -1) {
        break label1579;
      }
      paramawcg.a(new NoColumnError("isAPNG", Boolean.TYPE));
      i = paramCursor.getColumnIndex("ipsiteUrl");
      if (i != -1) {
        break label1607;
      }
      paramawcg.a(new NoColumnError("ipsiteUrl", String.class));
      label1107:
      i = paramCursor.getColumnIndex("ipsiteName");
      if (i != -1) {
        break label1622;
      }
      paramawcg.a(new NoColumnError("ipsiteName", String.class));
      label1141:
      i = paramCursor.getColumnIndex("exposeNum");
      if (i != -1) {
        break label1637;
      }
      paramawcg.a(new NoColumnError("exposeNum", Integer.TYPE));
      label1176:
      i = paramCursor.getColumnIndex("clickNum");
      if (i != -1) {
        break label1652;
      }
      paramawcg.a(new NoColumnError("clickNum", Integer.TYPE));
      label1211:
      i = paramCursor.getColumnIndex("voicePrint");
      if (i != -1) {
        break label1667;
      }
      paramawcg.a(new NoColumnError("voicePrint", String.class));
      label1245:
      i = paramCursor.getColumnIndex("backColor");
      if (i != -1) {
        break label1682;
      }
      paramawcg.a(new NoColumnError("backColor", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("volumeColor");
      if (i != -1) {
        break label1697;
      }
      paramawcg.a(new NoColumnError("volumeColor", String.class));
      return paramawbv;
      paramawbv.eId = paramCursor.getString(i);
      break;
      label1330:
      paramawbv.epId = paramCursor.getString(i);
      break label555;
      label1345:
      paramawbv.name = paramCursor.getString(i);
      break label589;
      label1360:
      paramawbv.encryptKey = paramCursor.getString(i);
      break label623;
      label1375:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isSound = paramBoolean;
        break;
      }
      label1402:
      paramawbv.width = paramCursor.getInt(i);
      break label693;
      label1417:
      paramawbv.height = paramCursor.getInt(i);
      break label728;
      label1432:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.value = paramBoolean;
        break;
      }
      label1459:
      paramawbv.magicValue = paramCursor.getString(i);
      break label797;
      label1474:
      paramawbv.jobType = paramCursor.getInt(i);
      break label832;
      label1489:
      paramawbv.keyword = paramCursor.getString(i);
      break label866;
      label1504:
      paramawbv.keywords = paramCursor.getString(i);
      break label900;
      label1519:
      paramawbv.character = paramCursor.getString(i);
      break label934;
      label1534:
      paramawbv.extensionWidth = paramCursor.getInt(i);
      break label969;
      label1549:
      paramawbv.extensionHeight = paramCursor.getInt(i);
      break label1004;
      label1564:
      paramawbv.businessExtra = paramCursor.getString(i);
      break label1038;
      label1579:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramawbv.isAPNG = paramBoolean;
        break;
      }
      label1607:
      paramawbv.ipsiteUrl = paramCursor.getString(i);
      break label1107;
      label1622:
      paramawbv.ipsiteName = paramCursor.getString(i);
      break label1141;
      label1637:
      paramawbv.exposeNum = paramCursor.getInt(i);
      break label1176;
      label1652:
      paramawbv.clickNum = paramCursor.getInt(i);
      break label1211;
      label1667:
      paramawbv.voicePrint = paramCursor.getString(i);
      break label1245;
      label1682:
      paramawbv.backColor = paramCursor.getString(i);
    }
    label1697:
    paramawbv.volumeColor = paramCursor.getString(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,eId TEXT ,epId TEXT ,name TEXT ,encryptKey TEXT ,isSound INTEGER ,width INTEGER ,height INTEGER ,value INTEGER ,magicValue TEXT ,jobType INTEGER ,keyword TEXT ,keywords TEXT ,character TEXT ,extensionWidth INTEGER ,extensionHeight INTEGER ,businessExtra TEXT ,isAPNG INTEGER ,ipsiteUrl TEXT ,ipsiteName TEXT ,exposeNum INTEGER ,clickNum INTEGER ,voicePrint TEXT ,backColor TEXT ,volumeColor TEXT,UNIQUE(eId,epId) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (Emoticon)paramawbv;
    paramContentValues.put("eId", paramawbv.eId);
    paramContentValues.put("epId", paramawbv.epId);
    paramContentValues.put("name", paramawbv.name);
    paramContentValues.put("encryptKey", paramawbv.encryptKey);
    paramContentValues.put("isSound", Boolean.valueOf(paramawbv.isSound));
    paramContentValues.put("width", Integer.valueOf(paramawbv.width));
    paramContentValues.put("height", Integer.valueOf(paramawbv.height));
    paramContentValues.put("value", Boolean.valueOf(paramawbv.value));
    paramContentValues.put("magicValue", paramawbv.magicValue);
    paramContentValues.put("jobType", Integer.valueOf(paramawbv.jobType));
    paramContentValues.put("keyword", paramawbv.keyword);
    paramContentValues.put("keywords", paramawbv.keywords);
    paramContentValues.put("character", paramawbv.character);
    paramContentValues.put("extensionWidth", Integer.valueOf(paramawbv.extensionWidth));
    paramContentValues.put("extensionHeight", Integer.valueOf(paramawbv.extensionHeight));
    paramContentValues.put("businessExtra", paramawbv.businessExtra);
    paramContentValues.put("isAPNG", Boolean.valueOf(paramawbv.isAPNG));
    paramContentValues.put("ipsiteUrl", paramawbv.ipsiteUrl);
    paramContentValues.put("ipsiteName", paramawbv.ipsiteName);
    paramContentValues.put("exposeNum", Integer.valueOf(paramawbv.exposeNum));
    paramContentValues.put("clickNum", Integer.valueOf(paramawbv.clickNum));
    paramContentValues.put("voicePrint", paramawbv.voicePrint);
    paramContentValues.put("backColor", paramawbv.backColor);
    paramContentValues.put("volumeColor", paramawbv.volumeColor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awbs
 * JD-Core Version:    0.7.0.1
 */