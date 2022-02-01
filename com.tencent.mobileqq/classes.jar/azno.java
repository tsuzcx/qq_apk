import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class azno
  extends OGAbstractDao
{
  public azno()
  {
    this.columnLen = 24;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (Emoticon)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.eId = paramCursor.getString(paramCursor.getColumnIndex("eId"));
      paramEntity.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      paramEntity.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramEntity.encryptKey = paramCursor.getString(paramCursor.getColumnIndex("encryptKey"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isSound")))
      {
        paramBoolean = true;
        paramEntity.isSound = paramBoolean;
        paramEntity.width = paramCursor.getInt(paramCursor.getColumnIndex("width"));
        paramEntity.height = paramCursor.getInt(paramCursor.getColumnIndex("height"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("value"))) {
          break label477;
        }
        paramBoolean = true;
        label169:
        paramEntity.value = paramBoolean;
        paramEntity.magicValue = paramCursor.getString(paramCursor.getColumnIndex("magicValue"));
        paramEntity.jobType = paramCursor.getInt(paramCursor.getColumnIndex("jobType"));
        paramEntity.keyword = paramCursor.getString(paramCursor.getColumnIndex("keyword"));
        paramEntity.keywords = paramCursor.getString(paramCursor.getColumnIndex("keywords"));
        paramEntity.character = paramCursor.getString(paramCursor.getColumnIndex("character"));
        paramEntity.extensionWidth = paramCursor.getInt(paramCursor.getColumnIndex("extensionWidth"));
        paramEntity.extensionHeight = paramCursor.getInt(paramCursor.getColumnIndex("extensionHeight"));
        paramEntity.businessExtra = paramCursor.getString(paramCursor.getColumnIndex("businessExtra"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isAPNG"))) {
          break label482;
        }
      }
      label477:
      label482:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.isAPNG = paramBoolean;
        paramEntity.ipsiteUrl = paramCursor.getString(paramCursor.getColumnIndex("ipsiteUrl"));
        paramEntity.ipsiteName = paramCursor.getString(paramCursor.getColumnIndex("ipsiteName"));
        paramEntity.exposeNum = paramCursor.getInt(paramCursor.getColumnIndex("exposeNum"));
        paramEntity.clickNum = paramCursor.getInt(paramCursor.getColumnIndex("clickNum"));
        paramEntity.voicePrint = paramCursor.getString(paramCursor.getColumnIndex("voicePrint"));
        paramEntity.backColor = paramCursor.getString(paramCursor.getColumnIndex("backColor"));
        paramEntity.volumeColor = paramCursor.getString(paramCursor.getColumnIndex("volumeColor"));
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label169;
      }
    }
    int i = paramCursor.getColumnIndex("eId");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("eId", String.class));
      i = paramCursor.getColumnIndex("epId");
      if (i != -1) {
        break label1330;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("epId", String.class));
      label555:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label1345;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("name", String.class));
      label589:
      i = paramCursor.getColumnIndex("encryptKey");
      if (i != -1) {
        break label1360;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("encryptKey", String.class));
      label623:
      i = paramCursor.getColumnIndex("isSound");
      if (i != -1) {
        break label1375;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("width");
      if (i != -1) {
        break label1402;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("width", Integer.TYPE));
      label693:
      i = paramCursor.getColumnIndex("height");
      if (i != -1) {
        break label1417;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("height", Integer.TYPE));
      label728:
      i = paramCursor.getColumnIndex("value");
      if (i != -1) {
        break label1432;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("value", Boolean.TYPE));
      i = paramCursor.getColumnIndex("magicValue");
      if (i != -1) {
        break label1459;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("magicValue", String.class));
      label797:
      i = paramCursor.getColumnIndex("jobType");
      if (i != -1) {
        break label1474;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("jobType", Integer.TYPE));
      label832:
      i = paramCursor.getColumnIndex("keyword");
      if (i != -1) {
        break label1489;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("keyword", String.class));
      label866:
      i = paramCursor.getColumnIndex("keywords");
      if (i != -1) {
        break label1504;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("keywords", String.class));
      label900:
      i = paramCursor.getColumnIndex("character");
      if (i != -1) {
        break label1519;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("character", String.class));
      label934:
      i = paramCursor.getColumnIndex("extensionWidth");
      if (i != -1) {
        break label1534;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extensionWidth", Integer.TYPE));
      label969:
      i = paramCursor.getColumnIndex("extensionHeight");
      if (i != -1) {
        break label1549;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extensionHeight", Integer.TYPE));
      label1004:
      i = paramCursor.getColumnIndex("businessExtra");
      if (i != -1) {
        break label1564;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("businessExtra", String.class));
      label1038:
      i = paramCursor.getColumnIndex("isAPNG");
      if (i != -1) {
        break label1579;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isAPNG", Boolean.TYPE));
      i = paramCursor.getColumnIndex("ipsiteUrl");
      if (i != -1) {
        break label1607;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ipsiteUrl", String.class));
      label1107:
      i = paramCursor.getColumnIndex("ipsiteName");
      if (i != -1) {
        break label1622;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ipsiteName", String.class));
      label1141:
      i = paramCursor.getColumnIndex("exposeNum");
      if (i != -1) {
        break label1637;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("exposeNum", Integer.TYPE));
      label1176:
      i = paramCursor.getColumnIndex("clickNum");
      if (i != -1) {
        break label1652;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("clickNum", Integer.TYPE));
      label1211:
      i = paramCursor.getColumnIndex("voicePrint");
      if (i != -1) {
        break label1667;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("voicePrint", String.class));
      label1245:
      i = paramCursor.getColumnIndex("backColor");
      if (i != -1) {
        break label1682;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("backColor", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("volumeColor");
      if (i != -1) {
        break label1697;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("volumeColor", String.class));
      return paramEntity;
      paramEntity.eId = paramCursor.getString(i);
      break;
      label1330:
      paramEntity.epId = paramCursor.getString(i);
      break label555;
      label1345:
      paramEntity.name = paramCursor.getString(i);
      break label589;
      label1360:
      paramEntity.encryptKey = paramCursor.getString(i);
      break label623;
      label1375:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSound = paramBoolean;
        break;
      }
      label1402:
      paramEntity.width = paramCursor.getInt(i);
      break label693;
      label1417:
      paramEntity.height = paramCursor.getInt(i);
      break label728;
      label1432:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.value = paramBoolean;
        break;
      }
      label1459:
      paramEntity.magicValue = paramCursor.getString(i);
      break label797;
      label1474:
      paramEntity.jobType = paramCursor.getInt(i);
      break label832;
      label1489:
      paramEntity.keyword = paramCursor.getString(i);
      break label866;
      label1504:
      paramEntity.keywords = paramCursor.getString(i);
      break label900;
      label1519:
      paramEntity.character = paramCursor.getString(i);
      break label934;
      label1534:
      paramEntity.extensionWidth = paramCursor.getInt(i);
      break label969;
      label1549:
      paramEntity.extensionHeight = paramCursor.getInt(i);
      break label1004;
      label1564:
      paramEntity.businessExtra = paramCursor.getString(i);
      break label1038;
      label1579:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.isAPNG = paramBoolean;
        break;
      }
      label1607:
      paramEntity.ipsiteUrl = paramCursor.getString(i);
      break label1107;
      label1622:
      paramEntity.ipsiteName = paramCursor.getString(i);
      break label1141;
      label1637:
      paramEntity.exposeNum = paramCursor.getInt(i);
      break label1176;
      label1652:
      paramEntity.clickNum = paramCursor.getInt(i);
      break label1211;
      label1667:
      paramEntity.voicePrint = paramCursor.getString(i);
      break label1245;
      label1682:
      paramEntity.backColor = paramCursor.getString(i);
    }
    label1697:
    paramEntity.volumeColor = paramCursor.getString(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (Emoticon)paramEntity;
    paramContentValues.put("eId", paramEntity.eId);
    paramContentValues.put("epId", paramEntity.epId);
    paramContentValues.put("name", paramEntity.name);
    paramContentValues.put("encryptKey", paramEntity.encryptKey);
    paramContentValues.put("isSound", Boolean.valueOf(paramEntity.isSound));
    paramContentValues.put("width", Integer.valueOf(paramEntity.width));
    paramContentValues.put("height", Integer.valueOf(paramEntity.height));
    paramContentValues.put("value", Boolean.valueOf(paramEntity.value));
    paramContentValues.put("magicValue", paramEntity.magicValue);
    paramContentValues.put("jobType", Integer.valueOf(paramEntity.jobType));
    paramContentValues.put("keyword", paramEntity.keyword);
    paramContentValues.put("keywords", paramEntity.keywords);
    paramContentValues.put("character", paramEntity.character);
    paramContentValues.put("extensionWidth", Integer.valueOf(paramEntity.extensionWidth));
    paramContentValues.put("extensionHeight", Integer.valueOf(paramEntity.extensionHeight));
    paramContentValues.put("businessExtra", paramEntity.businessExtra);
    paramContentValues.put("isAPNG", Boolean.valueOf(paramEntity.isAPNG));
    paramContentValues.put("ipsiteUrl", paramEntity.ipsiteUrl);
    paramContentValues.put("ipsiteName", paramEntity.ipsiteName);
    paramContentValues.put("exposeNum", Integer.valueOf(paramEntity.exposeNum));
    paramContentValues.put("clickNum", Integer.valueOf(paramEntity.clickNum));
    paramContentValues.put("voicePrint", paramEntity.voicePrint);
    paramContentValues.put("backColor", paramEntity.backColor);
    paramContentValues.put("volumeColor", paramEntity.volumeColor);
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,eId TEXT ,epId TEXT ,name TEXT ,encryptKey TEXT ,isSound INTEGER ,width INTEGER ,height INTEGER ,value INTEGER ,magicValue TEXT ,jobType INTEGER ,keyword TEXT ,keywords TEXT ,character TEXT ,extensionWidth INTEGER ,extensionHeight INTEGER ,businessExtra TEXT ,isAPNG INTEGER ,ipsiteUrl TEXT ,ipsiteName TEXT ,exposeNum INTEGER ,clickNum INTEGER ,voicePrint TEXT ,backColor TEXT ,volumeColor TEXT,UNIQUE(eId,epId) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azno
 * JD-Core Version:    0.7.0.1
 */