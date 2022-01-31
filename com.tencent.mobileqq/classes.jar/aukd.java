import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukd
  extends auky
{
  public aukd()
  {
    this.a = 12;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    boolean bool = true;
    paramBoolean = true;
    paramaukm = (ContactCard)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.mobileNo = paramCursor.getString(paramCursor.getColumnIndex("mobileNo"));
      paramaukm.nationCode = paramCursor.getString(paramCursor.getColumnIndex("nationCode"));
      paramaukm.mobileCode = paramCursor.getString(paramCursor.getColumnIndex("mobileCode"));
      paramaukm.strContactName = paramCursor.getString(paramCursor.getColumnIndex("strContactName"));
      paramaukm.nickName = paramCursor.getString(paramCursor.getColumnIndex("nickName"));
      paramaukm.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramaukm.bSex = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSex")));
      paramaukm.bAge = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bAge")));
      paramaukm.strProvince = paramCursor.getString(paramCursor.getColumnIndex("strProvince"));
      paramaukm.strCity = paramCursor.getString(paramCursor.getColumnIndex("strCity"));
      paramaukm.strCountry = paramCursor.getString(paramCursor.getColumnIndex("strCountry"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("bindQQ"))) {}
      for (;;)
      {
        paramaukm.bindQQ = paramBoolean;
        return paramaukm;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("mobileNo");
    if (i == -1)
    {
      paramaukx.a(new NoColumnError("mobileNo", String.class));
      i = paramCursor.getColumnIndex("nationCode");
      if (i != -1) {
        break label673;
      }
      paramaukx.a(new NoColumnError("nationCode", String.class));
      label313:
      i = paramCursor.getColumnIndex("mobileCode");
      if (i != -1) {
        break label688;
      }
      paramaukx.a(new NoColumnError("mobileCode", String.class));
      label347:
      i = paramCursor.getColumnIndex("strContactName");
      if (i != -1) {
        break label703;
      }
      paramaukx.a(new NoColumnError("strContactName", String.class));
      label381:
      i = paramCursor.getColumnIndex("nickName");
      if (i != -1) {
        break label718;
      }
      paramaukx.a(new NoColumnError("nickName", String.class));
      label415:
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label733;
      }
      paramaukx.a(new NoColumnError("uin", String.class));
      label449:
      i = paramCursor.getColumnIndex("bSex");
      if (i != -1) {
        break label748;
      }
      paramaukx.a(new NoColumnError("bSex", Byte.TYPE));
      label484:
      i = paramCursor.getColumnIndex("bAge");
      if (i != -1) {
        break label764;
      }
      paramaukx.a(new NoColumnError("bAge", Byte.TYPE));
      label519:
      i = paramCursor.getColumnIndex("strProvince");
      if (i != -1) {
        break label780;
      }
      paramaukx.a(new NoColumnError("strProvince", String.class));
      label553:
      i = paramCursor.getColumnIndex("strCity");
      if (i != -1) {
        break label795;
      }
      paramaukx.a(new NoColumnError("strCity", String.class));
      label587:
      i = paramCursor.getColumnIndex("strCountry");
      if (i != -1) {
        break label810;
      }
      paramaukx.a(new NoColumnError("strCountry", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("bindQQ");
      if (i != -1) {
        break label825;
      }
      paramaukx.a(new NoColumnError("bindQQ", Boolean.TYPE));
      return paramaukm;
      paramaukm.mobileNo = paramCursor.getString(i);
      break;
      label673:
      paramaukm.nationCode = paramCursor.getString(i);
      break label313;
      label688:
      paramaukm.mobileCode = paramCursor.getString(i);
      break label347;
      label703:
      paramaukm.strContactName = paramCursor.getString(i);
      break label381;
      label718:
      paramaukm.nickName = paramCursor.getString(i);
      break label415;
      label733:
      paramaukm.uin = paramCursor.getString(i);
      break label449;
      label748:
      paramaukm.bSex = ((byte)paramCursor.getShort(i));
      break label484;
      label764:
      paramaukm.bAge = ((byte)paramCursor.getShort(i));
      break label519;
      label780:
      paramaukm.strProvince = paramCursor.getString(i);
      break label553;
      label795:
      paramaukm.strCity = paramCursor.getString(i);
      break label587;
      label810:
      paramaukm.strCountry = paramCursor.getString(i);
    }
    label825:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramaukm.bindQQ = paramBoolean;
      return paramaukm;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,mobileNo TEXT UNIQUE ,nationCode TEXT ,mobileCode TEXT ,strContactName TEXT ,nickName TEXT ,uin TEXT ,bSex INTEGER ,bAge INTEGER ,strProvince TEXT ,strCity TEXT ,strCountry TEXT ,bindQQ INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (ContactCard)paramaukm;
    paramContentValues.put("mobileNo", paramaukm.mobileNo);
    paramContentValues.put("nationCode", paramaukm.nationCode);
    paramContentValues.put("mobileCode", paramaukm.mobileCode);
    paramContentValues.put("strContactName", paramaukm.strContactName);
    paramContentValues.put("nickName", paramaukm.nickName);
    paramContentValues.put("uin", paramaukm.uin);
    paramContentValues.put("bSex", Byte.valueOf(paramaukm.bSex));
    paramContentValues.put("bAge", Byte.valueOf(paramaukm.bAge));
    paramContentValues.put("strProvince", paramaukm.strProvince);
    paramContentValues.put("strCity", paramaukm.strCity);
    paramContentValues.put("strCountry", paramaukm.strCountry);
    paramContentValues.put("bindQQ", Boolean.valueOf(paramaukm.bindQQ));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukd
 * JD-Core Version:    0.7.0.1
 */