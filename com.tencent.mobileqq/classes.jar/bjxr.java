import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cooperation.readinjoy.content.ReadInJoyDataProvider;

public class bjxr
  extends SQLiteOpenHelper
{
  public String a;
  
  public bjxr(ReadInJoyDataProvider paramReadInJoyDataProvider, Context paramContext, String paramString)
  {
    super(paramContext, "readinjoy_main_" + paramString, null, 84);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    if ((paramString.equals("subscribe_msg_records")) || (paramString.equals("notify_msg_records"))) {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + paramString + "(" + "_id" + " INTEGER PRIMARY KEY AUTOINCREMENT, " + "msgID" + " INTEGER UNIQUE NOT NULL, " + "subscribeID" + " TEXT NOT NULL, " + "msgURL" + " TEXT NOT NULL, " + "msgContent" + " TEXT NOT NULL, " + "msgTime" + " INTEGER NOT NULL, " + "bindUin" + " INTEGER NOT NULL);");
    }
    while (!paramString.equals("feeds_msg_records")) {
      return;
    }
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + paramString + "(" + "_id" + " INTEGER PRIMARY KEY AUTOINCREMENT, " + "pushTime" + " INTEGER NOT NULL, " + "notifyType" + " INTEGER NOT NULL, " + "feedsOwner" + " INTEGER NOT NULL, " + "feedsID" + " INTEGER NOT NULL, " + "feedsSubject" + " TEXT DEFAULT '', " + "deleteUin" + " INTEGER NOT NULL, " + "publishFail" + " INTEGER NOT NULL, " + "likeUin" + " INTEGER NOT NULL, " + "commentUin" + " INTEGER NOT NULL, " + "commentID" + " VARCHAR(32) DEFAULT '', " + "replyUin" + " INTEGER NOT NULL, " + "replyID" + " VARCHAR(32) DEFAULT '', " + "commentInfo" + " TEXT DEFAULT '', " + "isDelete" + " INTEGER DEFAULT 0, " + "processSeq" + " INTEGER DEFAULT 0, " + "receiveTime" + " INTEGER NOT NULL);");
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    if ("common_records".equalsIgnoreCase(paramString)) {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + paramString + "(" + "_id" + " INTEGER PRIMARY KEY AUTOINCREMENT, " + "common_version" + " INTEGER NOT NULL, " + "common_key" + " TEXT DEFAULT '', " + "common_content" + " TEXT DEFAULT '');");
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase, "subscribe_msg_records");
    a(paramSQLiteDatabase, "notify_msg_records");
    a(paramSQLiteDatabase, "feeds_msg_records");
    b(paramSQLiteDatabase, "common_records");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 80)
    {
      paramSQLiteDatabase.execSQL(awcw.a("subscribe_msg_records"));
      paramSQLiteDatabase.execSQL(awcw.a("notify_msg_records"));
      a(paramSQLiteDatabase, "subscribe_msg_records");
      a(paramSQLiteDatabase, "notify_msg_records");
    }
    if (paramInt1 < 81) {
      a(paramSQLiteDatabase, "feeds_msg_records");
    }
    for (;;)
    {
      if (paramInt1 < 84) {
        b(paramSQLiteDatabase, "common_records");
      }
      return;
      if (paramInt1 < 82) {
        paramSQLiteDatabase.execSQL(String.format("ALTER TABLE %s ADD %s %s;", new Object[] { "feeds_msg_records", "isDelete", "INTEGER DEFAULT 0" }));
      }
      if (paramInt1 < 83) {
        paramSQLiteDatabase.execSQL(String.format("ALTER TABLE %s ADD %s %s;", new Object[] { "feeds_msg_records", "processSeq", "INTEGER DEFAULT 0" }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bjxr
 * JD-Core Version:    0.7.0.1
 */