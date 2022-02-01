import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.startup.step.MigrateSubscribeDB;

public class bdji
  extends SQLiteOpenHelper
{
  public bdji(MigrateSubscribeDB paramMigrateSubscribeDB, Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString, null, paramInt);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdji
 * JD-Core Version:    0.7.0.1
 */