import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awfv
  extends awgq
{
  public awfv()
  {
    this.a = 12;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    boolean bool = true;
    paramBoolean = true;
    paramawge = (ContactCard)paramawge;
    if (paramawgp == null)
    {
      paramawge.mobileNo = paramCursor.getString(paramCursor.getColumnIndex("mobileNo"));
      paramawge.nationCode = paramCursor.getString(paramCursor.getColumnIndex("nationCode"));
      paramawge.mobileCode = paramCursor.getString(paramCursor.getColumnIndex("mobileCode"));
      paramawge.strContactName = paramCursor.getString(paramCursor.getColumnIndex("strContactName"));
      paramawge.nickName = paramCursor.getString(paramCursor.getColumnIndex("nickName"));
      paramawge.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawge.bSex = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSex")));
      paramawge.bAge = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bAge")));
      paramawge.strProvince = paramCursor.getString(paramCursor.getColumnIndex("strProvince"));
      paramawge.strCity = paramCursor.getString(paramCursor.getColumnIndex("strCity"));
      paramawge.strCountry = paramCursor.getString(paramCursor.getColumnIndex("strCountry"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("bindQQ"))) {}
      for (;;)
      {
        paramawge.bindQQ = paramBoolean;
        return paramawge;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("mobileNo");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("mobileNo", String.class));
      i = paramCursor.getColumnIndex("nationCode");
      if (i != -1) {
        break label673;
      }
      paramawgp.a(new NoColumnError("nationCode", String.class));
      label313:
      i = paramCursor.getColumnIndex("mobileCode");
      if (i != -1) {
        break label688;
      }
      paramawgp.a(new NoColumnError("mobileCode", String.class));
      label347:
      i = paramCursor.getColumnIndex("strContactName");
      if (i != -1) {
        break label703;
      }
      paramawgp.a(new NoColumnError("strContactName", String.class));
      label381:
      i = paramCursor.getColumnIndex("nickName");
      if (i != -1) {
        break label718;
      }
      paramawgp.a(new NoColumnError("nickName", String.class));
      label415:
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label733;
      }
      paramawgp.a(new NoColumnError("uin", String.class));
      label449:
      i = paramCursor.getColumnIndex("bSex");
      if (i != -1) {
        break label748;
      }
      paramawgp.a(new NoColumnError("bSex", Byte.TYPE));
      label484:
      i = paramCursor.getColumnIndex("bAge");
      if (i != -1) {
        break label764;
      }
      paramawgp.a(new NoColumnError("bAge", Byte.TYPE));
      label519:
      i = paramCursor.getColumnIndex("strProvince");
      if (i != -1) {
        break label780;
      }
      paramawgp.a(new NoColumnError("strProvince", String.class));
      label553:
      i = paramCursor.getColumnIndex("strCity");
      if (i != -1) {
        break label795;
      }
      paramawgp.a(new NoColumnError("strCity", String.class));
      label587:
      i = paramCursor.getColumnIndex("strCountry");
      if (i != -1) {
        break label810;
      }
      paramawgp.a(new NoColumnError("strCountry", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("bindQQ");
      if (i != -1) {
        break label825;
      }
      paramawgp.a(new NoColumnError("bindQQ", Boolean.TYPE));
      return paramawge;
      paramawge.mobileNo = paramCursor.getString(i);
      break;
      label673:
      paramawge.nationCode = paramCursor.getString(i);
      break label313;
      label688:
      paramawge.mobileCode = paramCursor.getString(i);
      break label347;
      label703:
      paramawge.strContactName = paramCursor.getString(i);
      break label381;
      label718:
      paramawge.nickName = paramCursor.getString(i);
      break label415;
      label733:
      paramawge.uin = paramCursor.getString(i);
      break label449;
      label748:
      paramawge.bSex = ((byte)paramCursor.getShort(i));
      break label484;
      label764:
      paramawge.bAge = ((byte)paramCursor.getShort(i));
      break label519;
      label780:
      paramawge.strProvince = paramCursor.getString(i);
      break label553;
      label795:
      paramawge.strCity = paramCursor.getString(i);
      break label587;
      label810:
      paramawge.strCountry = paramCursor.getString(i);
    }
    label825:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramawge.bindQQ = paramBoolean;
      return paramawge;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,mobileNo TEXT UNIQUE ,nationCode TEXT ,mobileCode TEXT ,strContactName TEXT ,nickName TEXT ,uin TEXT ,bSex INTEGER ,bAge INTEGER ,strProvince TEXT ,strCity TEXT ,strCountry TEXT ,bindQQ INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (ContactCard)paramawge;
    paramContentValues.put("mobileNo", paramawge.mobileNo);
    paramContentValues.put("nationCode", paramawge.nationCode);
    paramContentValues.put("mobileCode", paramawge.mobileCode);
    paramContentValues.put("strContactName", paramawge.strContactName);
    paramContentValues.put("nickName", paramawge.nickName);
    paramContentValues.put("uin", paramawge.uin);
    paramContentValues.put("bSex", Byte.valueOf(paramawge.bSex));
    paramContentValues.put("bAge", Byte.valueOf(paramawge.bAge));
    paramContentValues.put("strProvince", paramawge.strProvince);
    paramContentValues.put("strCity", paramawge.strCity);
    paramContentValues.put("strCountry", paramawge.strCountry);
    paramContentValues.put("bindQQ", Boolean.valueOf(paramawge.bindQQ));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awfv
 * JD-Core Version:    0.7.0.1
 */