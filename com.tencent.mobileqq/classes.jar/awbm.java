import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awbm
  extends awch
{
  public awbm()
  {
    this.a = 12;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    boolean bool = true;
    paramBoolean = true;
    paramawbv = (ContactCard)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.mobileNo = paramCursor.getString(paramCursor.getColumnIndex("mobileNo"));
      paramawbv.nationCode = paramCursor.getString(paramCursor.getColumnIndex("nationCode"));
      paramawbv.mobileCode = paramCursor.getString(paramCursor.getColumnIndex("mobileCode"));
      paramawbv.strContactName = paramCursor.getString(paramCursor.getColumnIndex("strContactName"));
      paramawbv.nickName = paramCursor.getString(paramCursor.getColumnIndex("nickName"));
      paramawbv.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawbv.bSex = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSex")));
      paramawbv.bAge = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bAge")));
      paramawbv.strProvince = paramCursor.getString(paramCursor.getColumnIndex("strProvince"));
      paramawbv.strCity = paramCursor.getString(paramCursor.getColumnIndex("strCity"));
      paramawbv.strCountry = paramCursor.getString(paramCursor.getColumnIndex("strCountry"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("bindQQ"))) {}
      for (;;)
      {
        paramawbv.bindQQ = paramBoolean;
        return paramawbv;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("mobileNo");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("mobileNo", String.class));
      i = paramCursor.getColumnIndex("nationCode");
      if (i != -1) {
        break label673;
      }
      paramawcg.a(new NoColumnError("nationCode", String.class));
      label313:
      i = paramCursor.getColumnIndex("mobileCode");
      if (i != -1) {
        break label688;
      }
      paramawcg.a(new NoColumnError("mobileCode", String.class));
      label347:
      i = paramCursor.getColumnIndex("strContactName");
      if (i != -1) {
        break label703;
      }
      paramawcg.a(new NoColumnError("strContactName", String.class));
      label381:
      i = paramCursor.getColumnIndex("nickName");
      if (i != -1) {
        break label718;
      }
      paramawcg.a(new NoColumnError("nickName", String.class));
      label415:
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label733;
      }
      paramawcg.a(new NoColumnError("uin", String.class));
      label449:
      i = paramCursor.getColumnIndex("bSex");
      if (i != -1) {
        break label748;
      }
      paramawcg.a(new NoColumnError("bSex", Byte.TYPE));
      label484:
      i = paramCursor.getColumnIndex("bAge");
      if (i != -1) {
        break label764;
      }
      paramawcg.a(new NoColumnError("bAge", Byte.TYPE));
      label519:
      i = paramCursor.getColumnIndex("strProvince");
      if (i != -1) {
        break label780;
      }
      paramawcg.a(new NoColumnError("strProvince", String.class));
      label553:
      i = paramCursor.getColumnIndex("strCity");
      if (i != -1) {
        break label795;
      }
      paramawcg.a(new NoColumnError("strCity", String.class));
      label587:
      i = paramCursor.getColumnIndex("strCountry");
      if (i != -1) {
        break label810;
      }
      paramawcg.a(new NoColumnError("strCountry", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("bindQQ");
      if (i != -1) {
        break label825;
      }
      paramawcg.a(new NoColumnError("bindQQ", Boolean.TYPE));
      return paramawbv;
      paramawbv.mobileNo = paramCursor.getString(i);
      break;
      label673:
      paramawbv.nationCode = paramCursor.getString(i);
      break label313;
      label688:
      paramawbv.mobileCode = paramCursor.getString(i);
      break label347;
      label703:
      paramawbv.strContactName = paramCursor.getString(i);
      break label381;
      label718:
      paramawbv.nickName = paramCursor.getString(i);
      break label415;
      label733:
      paramawbv.uin = paramCursor.getString(i);
      break label449;
      label748:
      paramawbv.bSex = ((byte)paramCursor.getShort(i));
      break label484;
      label764:
      paramawbv.bAge = ((byte)paramCursor.getShort(i));
      break label519;
      label780:
      paramawbv.strProvince = paramCursor.getString(i);
      break label553;
      label795:
      paramawbv.strCity = paramCursor.getString(i);
      break label587;
      label810:
      paramawbv.strCountry = paramCursor.getString(i);
    }
    label825:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramawbv.bindQQ = paramBoolean;
      return paramawbv;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,mobileNo TEXT UNIQUE ,nationCode TEXT ,mobileCode TEXT ,strContactName TEXT ,nickName TEXT ,uin TEXT ,bSex INTEGER ,bAge INTEGER ,strProvince TEXT ,strCity TEXT ,strCountry TEXT ,bindQQ INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (ContactCard)paramawbv;
    paramContentValues.put("mobileNo", paramawbv.mobileNo);
    paramContentValues.put("nationCode", paramawbv.nationCode);
    paramContentValues.put("mobileCode", paramawbv.mobileCode);
    paramContentValues.put("strContactName", paramawbv.strContactName);
    paramContentValues.put("nickName", paramawbv.nickName);
    paramContentValues.put("uin", paramawbv.uin);
    paramContentValues.put("bSex", Byte.valueOf(paramawbv.bSex));
    paramContentValues.put("bAge", Byte.valueOf(paramawbv.bAge));
    paramContentValues.put("strProvince", paramawbv.strProvince);
    paramContentValues.put("strCity", paramawbv.strCity);
    paramContentValues.put("strCountry", paramawbv.strCountry);
    paramContentValues.put("bindQQ", Boolean.valueOf(paramawbv.bindQQ));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awbm
 * JD-Core Version:    0.7.0.1
 */