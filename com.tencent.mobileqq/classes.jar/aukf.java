import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukf
  extends aula
{
  public aukf()
  {
    this.a = 12;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    boolean bool = true;
    paramBoolean = true;
    paramauko = (ContactCard)paramauko;
    if (paramaukz == null)
    {
      paramauko.mobileNo = paramCursor.getString(paramCursor.getColumnIndex("mobileNo"));
      paramauko.nationCode = paramCursor.getString(paramCursor.getColumnIndex("nationCode"));
      paramauko.mobileCode = paramCursor.getString(paramCursor.getColumnIndex("mobileCode"));
      paramauko.strContactName = paramCursor.getString(paramCursor.getColumnIndex("strContactName"));
      paramauko.nickName = paramCursor.getString(paramCursor.getColumnIndex("nickName"));
      paramauko.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramauko.bSex = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSex")));
      paramauko.bAge = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bAge")));
      paramauko.strProvince = paramCursor.getString(paramCursor.getColumnIndex("strProvince"));
      paramauko.strCity = paramCursor.getString(paramCursor.getColumnIndex("strCity"));
      paramauko.strCountry = paramCursor.getString(paramCursor.getColumnIndex("strCountry"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("bindQQ"))) {}
      for (;;)
      {
        paramauko.bindQQ = paramBoolean;
        return paramauko;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("mobileNo");
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("mobileNo", String.class));
      i = paramCursor.getColumnIndex("nationCode");
      if (i != -1) {
        break label673;
      }
      paramaukz.a(new NoColumnError("nationCode", String.class));
      label313:
      i = paramCursor.getColumnIndex("mobileCode");
      if (i != -1) {
        break label688;
      }
      paramaukz.a(new NoColumnError("mobileCode", String.class));
      label347:
      i = paramCursor.getColumnIndex("strContactName");
      if (i != -1) {
        break label703;
      }
      paramaukz.a(new NoColumnError("strContactName", String.class));
      label381:
      i = paramCursor.getColumnIndex("nickName");
      if (i != -1) {
        break label718;
      }
      paramaukz.a(new NoColumnError("nickName", String.class));
      label415:
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label733;
      }
      paramaukz.a(new NoColumnError("uin", String.class));
      label449:
      i = paramCursor.getColumnIndex("bSex");
      if (i != -1) {
        break label748;
      }
      paramaukz.a(new NoColumnError("bSex", Byte.TYPE));
      label484:
      i = paramCursor.getColumnIndex("bAge");
      if (i != -1) {
        break label764;
      }
      paramaukz.a(new NoColumnError("bAge", Byte.TYPE));
      label519:
      i = paramCursor.getColumnIndex("strProvince");
      if (i != -1) {
        break label780;
      }
      paramaukz.a(new NoColumnError("strProvince", String.class));
      label553:
      i = paramCursor.getColumnIndex("strCity");
      if (i != -1) {
        break label795;
      }
      paramaukz.a(new NoColumnError("strCity", String.class));
      label587:
      i = paramCursor.getColumnIndex("strCountry");
      if (i != -1) {
        break label810;
      }
      paramaukz.a(new NoColumnError("strCountry", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("bindQQ");
      if (i != -1) {
        break label825;
      }
      paramaukz.a(new NoColumnError("bindQQ", Boolean.TYPE));
      return paramauko;
      paramauko.mobileNo = paramCursor.getString(i);
      break;
      label673:
      paramauko.nationCode = paramCursor.getString(i);
      break label313;
      label688:
      paramauko.mobileCode = paramCursor.getString(i);
      break label347;
      label703:
      paramauko.strContactName = paramCursor.getString(i);
      break label381;
      label718:
      paramauko.nickName = paramCursor.getString(i);
      break label415;
      label733:
      paramauko.uin = paramCursor.getString(i);
      break label449;
      label748:
      paramauko.bSex = ((byte)paramCursor.getShort(i));
      break label484;
      label764:
      paramauko.bAge = ((byte)paramCursor.getShort(i));
      break label519;
      label780:
      paramauko.strProvince = paramCursor.getString(i);
      break label553;
      label795:
      paramauko.strCity = paramCursor.getString(i);
      break label587;
      label810:
      paramauko.strCountry = paramCursor.getString(i);
    }
    label825:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramauko.bindQQ = paramBoolean;
      return paramauko;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,mobileNo TEXT UNIQUE ,nationCode TEXT ,mobileCode TEXT ,strContactName TEXT ,nickName TEXT ,uin TEXT ,bSex INTEGER ,bAge INTEGER ,strProvince TEXT ,strCity TEXT ,strCountry TEXT ,bindQQ INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (ContactCard)paramauko;
    paramContentValues.put("mobileNo", paramauko.mobileNo);
    paramContentValues.put("nationCode", paramauko.nationCode);
    paramContentValues.put("mobileCode", paramauko.mobileCode);
    paramContentValues.put("strContactName", paramauko.strContactName);
    paramContentValues.put("nickName", paramauko.nickName);
    paramContentValues.put("uin", paramauko.uin);
    paramContentValues.put("bSex", Byte.valueOf(paramauko.bSex));
    paramContentValues.put("bAge", Byte.valueOf(paramauko.bAge));
    paramContentValues.put("strProvince", paramauko.strProvince);
    paramContentValues.put("strCity", paramauko.strCity);
    paramContentValues.put("strCountry", paramauko.strCountry);
    paramContentValues.put("bindQQ", Boolean.valueOf(paramauko.bindQQ));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukf
 * JD-Core Version:    0.7.0.1
 */