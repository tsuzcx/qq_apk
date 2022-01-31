import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awbu
  extends awch
{
  public awbu()
  {
    this.a = 3;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawbv = (EmoticonTab)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("aioHave")))
      {
        paramBoolean = true;
        paramawbv.aioHave = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("kandianHave"))) {
          break label92;
        }
      }
      label92:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramawbv.kandianHave = paramBoolean;
        return paramawbv;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("epId");
    if (i == -1) {
      paramawcg.a(new NoColumnError("epId", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("aioHave");
      if (i != -1) {
        break;
      }
      paramawcg.a(new NoColumnError("aioHave", Boolean.TYPE));
      i = paramCursor.getColumnIndex("kandianHave");
      if (i != -1) {
        break label245;
      }
      paramawcg.a(new NoColumnError("kandianHave", Boolean.TYPE));
      return paramawbv;
      paramawbv.epId = paramCursor.getString(i);
    }
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramawbv.aioHave = paramBoolean;
      break;
    }
    label245:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramawbv.kandianHave = paramBoolean;
      return paramawbv;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,epId TEXT UNIQUE ,aioHave INTEGER ,kandianHave INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (EmoticonTab)paramawbv;
    paramContentValues.put("epId", paramawbv.epId);
    paramContentValues.put("aioHave", Boolean.valueOf(paramawbv.aioHave));
    paramContentValues.put("kandianHave", Boolean.valueOf(paramawbv.kandianHave));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awbu
 * JD-Core Version:    0.7.0.1
 */