import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atmf
  extends atna
{
  public atmf()
  {
    this.a = 12;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    boolean bool = true;
    paramBoolean = true;
    paramatmo = (ContactCard)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.mobileNo = paramCursor.getString(paramCursor.getColumnIndex("mobileNo"));
      paramatmo.nationCode = paramCursor.getString(paramCursor.getColumnIndex("nationCode"));
      paramatmo.mobileCode = paramCursor.getString(paramCursor.getColumnIndex("mobileCode"));
      paramatmo.strContactName = paramCursor.getString(paramCursor.getColumnIndex("strContactName"));
      paramatmo.nickName = paramCursor.getString(paramCursor.getColumnIndex("nickName"));
      paramatmo.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramatmo.bSex = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSex")));
      paramatmo.bAge = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bAge")));
      paramatmo.strProvince = paramCursor.getString(paramCursor.getColumnIndex("strProvince"));
      paramatmo.strCity = paramCursor.getString(paramCursor.getColumnIndex("strCity"));
      paramatmo.strCountry = paramCursor.getString(paramCursor.getColumnIndex("strCountry"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("bindQQ"))) {}
      for (;;)
      {
        paramatmo.bindQQ = paramBoolean;
        return paramatmo;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("mobileNo");
    if (i == -1)
    {
      paramatmz.a(new NoColumnError("mobileNo", String.class));
      i = paramCursor.getColumnIndex("nationCode");
      if (i != -1) {
        break label673;
      }
      paramatmz.a(new NoColumnError("nationCode", String.class));
      label313:
      i = paramCursor.getColumnIndex("mobileCode");
      if (i != -1) {
        break label688;
      }
      paramatmz.a(new NoColumnError("mobileCode", String.class));
      label347:
      i = paramCursor.getColumnIndex("strContactName");
      if (i != -1) {
        break label703;
      }
      paramatmz.a(new NoColumnError("strContactName", String.class));
      label381:
      i = paramCursor.getColumnIndex("nickName");
      if (i != -1) {
        break label718;
      }
      paramatmz.a(new NoColumnError("nickName", String.class));
      label415:
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label733;
      }
      paramatmz.a(new NoColumnError("uin", String.class));
      label449:
      i = paramCursor.getColumnIndex("bSex");
      if (i != -1) {
        break label748;
      }
      paramatmz.a(new NoColumnError("bSex", Byte.TYPE));
      label484:
      i = paramCursor.getColumnIndex("bAge");
      if (i != -1) {
        break label764;
      }
      paramatmz.a(new NoColumnError("bAge", Byte.TYPE));
      label519:
      i = paramCursor.getColumnIndex("strProvince");
      if (i != -1) {
        break label780;
      }
      paramatmz.a(new NoColumnError("strProvince", String.class));
      label553:
      i = paramCursor.getColumnIndex("strCity");
      if (i != -1) {
        break label795;
      }
      paramatmz.a(new NoColumnError("strCity", String.class));
      label587:
      i = paramCursor.getColumnIndex("strCountry");
      if (i != -1) {
        break label810;
      }
      paramatmz.a(new NoColumnError("strCountry", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("bindQQ");
      if (i != -1) {
        break label825;
      }
      paramatmz.a(new NoColumnError("bindQQ", Boolean.TYPE));
      return paramatmo;
      paramatmo.mobileNo = paramCursor.getString(i);
      break;
      label673:
      paramatmo.nationCode = paramCursor.getString(i);
      break label313;
      label688:
      paramatmo.mobileCode = paramCursor.getString(i);
      break label347;
      label703:
      paramatmo.strContactName = paramCursor.getString(i);
      break label381;
      label718:
      paramatmo.nickName = paramCursor.getString(i);
      break label415;
      label733:
      paramatmo.uin = paramCursor.getString(i);
      break label449;
      label748:
      paramatmo.bSex = ((byte)paramCursor.getShort(i));
      break label484;
      label764:
      paramatmo.bAge = ((byte)paramCursor.getShort(i));
      break label519;
      label780:
      paramatmo.strProvince = paramCursor.getString(i);
      break label553;
      label795:
      paramatmo.strCity = paramCursor.getString(i);
      break label587;
      label810:
      paramatmo.strCountry = paramCursor.getString(i);
    }
    label825:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramatmo.bindQQ = paramBoolean;
      return paramatmo;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,mobileNo TEXT UNIQUE ,nationCode TEXT ,mobileCode TEXT ,strContactName TEXT ,nickName TEXT ,uin TEXT ,bSex INTEGER ,bAge INTEGER ,strProvince TEXT ,strCity TEXT ,strCountry TEXT ,bindQQ INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (ContactCard)paramatmo;
    paramContentValues.put("mobileNo", paramatmo.mobileNo);
    paramContentValues.put("nationCode", paramatmo.nationCode);
    paramContentValues.put("mobileCode", paramatmo.mobileCode);
    paramContentValues.put("strContactName", paramatmo.strContactName);
    paramContentValues.put("nickName", paramatmo.nickName);
    paramContentValues.put("uin", paramatmo.uin);
    paramContentValues.put("bSex", Byte.valueOf(paramatmo.bSex));
    paramContentValues.put("bAge", Byte.valueOf(paramatmo.bAge));
    paramContentValues.put("strProvince", paramatmo.strProvince);
    paramContentValues.put("strCity", paramatmo.strCity);
    paramContentValues.put("strCountry", paramatmo.strCountry);
    paramContentValues.put("bindQQ", Boolean.valueOf(paramatmo.bindQQ));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atmf
 * JD-Core Version:    0.7.0.1
 */