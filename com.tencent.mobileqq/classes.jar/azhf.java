import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class azhf
  extends OGAbstractDao
{
  public azhf()
  {
    this.columnLen = 12;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool = true;
    paramBoolean = true;
    paramEntity = (ContactCard)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.mobileNo = paramCursor.getString(paramCursor.getColumnIndex("mobileNo"));
      paramEntity.nationCode = paramCursor.getString(paramCursor.getColumnIndex("nationCode"));
      paramEntity.mobileCode = paramCursor.getString(paramCursor.getColumnIndex("mobileCode"));
      paramEntity.strContactName = paramCursor.getString(paramCursor.getColumnIndex("strContactName"));
      paramEntity.nickName = paramCursor.getString(paramCursor.getColumnIndex("nickName"));
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.bSex = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSex")));
      paramEntity.bAge = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bAge")));
      paramEntity.strProvince = paramCursor.getString(paramCursor.getColumnIndex("strProvince"));
      paramEntity.strCity = paramCursor.getString(paramCursor.getColumnIndex("strCity"));
      paramEntity.strCountry = paramCursor.getString(paramCursor.getColumnIndex("strCountry"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("bindQQ"))) {}
      for (;;)
      {
        paramEntity.bindQQ = paramBoolean;
        return paramEntity;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("mobileNo");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mobileNo", String.class));
      i = paramCursor.getColumnIndex("nationCode");
      if (i != -1) {
        break label673;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nationCode", String.class));
      label313:
      i = paramCursor.getColumnIndex("mobileCode");
      if (i != -1) {
        break label688;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mobileCode", String.class));
      label347:
      i = paramCursor.getColumnIndex("strContactName");
      if (i != -1) {
        break label703;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strContactName", String.class));
      label381:
      i = paramCursor.getColumnIndex("nickName");
      if (i != -1) {
        break label718;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nickName", String.class));
      label415:
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label733;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
      label449:
      i = paramCursor.getColumnIndex("bSex");
      if (i != -1) {
        break label748;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bSex", Byte.TYPE));
      label484:
      i = paramCursor.getColumnIndex("bAge");
      if (i != -1) {
        break label764;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bAge", Byte.TYPE));
      label519:
      i = paramCursor.getColumnIndex("strProvince");
      if (i != -1) {
        break label780;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strProvince", String.class));
      label553:
      i = paramCursor.getColumnIndex("strCity");
      if (i != -1) {
        break label795;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCity", String.class));
      label587:
      i = paramCursor.getColumnIndex("strCountry");
      if (i != -1) {
        break label810;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strCountry", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("bindQQ");
      if (i != -1) {
        break label825;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bindQQ", Boolean.TYPE));
      return paramEntity;
      paramEntity.mobileNo = paramCursor.getString(i);
      break;
      label673:
      paramEntity.nationCode = paramCursor.getString(i);
      break label313;
      label688:
      paramEntity.mobileCode = paramCursor.getString(i);
      break label347;
      label703:
      paramEntity.strContactName = paramCursor.getString(i);
      break label381;
      label718:
      paramEntity.nickName = paramCursor.getString(i);
      break label415;
      label733:
      paramEntity.uin = paramCursor.getString(i);
      break label449;
      label748:
      paramEntity.bSex = ((byte)paramCursor.getShort(i));
      break label484;
      label764:
      paramEntity.bAge = ((byte)paramCursor.getShort(i));
      break label519;
      label780:
      paramEntity.strProvince = paramCursor.getString(i);
      break label553;
      label795:
      paramEntity.strCity = paramCursor.getString(i);
      break label587;
      label810:
      paramEntity.strCountry = paramCursor.getString(i);
    }
    label825:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramEntity.bindQQ = paramBoolean;
      return paramEntity;
    }
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (ContactCard)paramEntity;
    paramContentValues.put("mobileNo", paramEntity.mobileNo);
    paramContentValues.put("nationCode", paramEntity.nationCode);
    paramContentValues.put("mobileCode", paramEntity.mobileCode);
    paramContentValues.put("strContactName", paramEntity.strContactName);
    paramContentValues.put("nickName", paramEntity.nickName);
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("bSex", Byte.valueOf(paramEntity.bSex));
    paramContentValues.put("bAge", Byte.valueOf(paramEntity.bAge));
    paramContentValues.put("strProvince", paramEntity.strProvince);
    paramContentValues.put("strCity", paramEntity.strCity);
    paramContentValues.put("strCountry", paramEntity.strCountry);
    paramContentValues.put("bindQQ", Boolean.valueOf(paramEntity.bindQQ));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,mobileNo TEXT UNIQUE ,nationCode TEXT ,mobileCode TEXT ,strContactName TEXT ,nickName TEXT ,uin TEXT ,bSex INTEGER ,bAge INTEGER ,strProvince TEXT ,strCity TEXT ,strCountry TEXT ,bindQQ INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azhf
 * JD-Core Version:    0.7.0.1
 */