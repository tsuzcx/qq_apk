import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.fts.FTSNewTroopSync;
import com.tencent.mobileqq.persistence.fts.FTSOptSync;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class amoe
  extends amog
{
  public amoe(QQAppInterface paramQQAppInterface, amof paramamof)
  {
    super(paramQQAppInterface, paramamof);
    this.d = true;
  }
  
  protected FTSOptSync a(int paramInt, long paramLong1, long paramLong2)
  {
    return new FTSNewTroopSync(paramInt, paramLong1, paramLong2);
  }
  
  protected List<FTSOptSync> a(SQLiteDatabase paramSQLiteDatabase, awgf paramawgf)
  {
    localObject = null;
    try
    {
      if (this.a > 0)
      {
        i = paramSQLiteDatabase.a(FTSNewTroopSync.class.getSimpleName(), "_id<=?", new String[] { String.valueOf(this.a) });
        if ((QLog.isColorLevel()) && (i > 0)) {
          QLog.d("Q.fts.troop.operator.new", 2, "delete " + FTSNewTroopSync.class.getSimpleName() + " row=" + i);
        }
      }
      paramawgf = paramawgf.a(FTSNewTroopSync.class, FTSNewTroopSync.class.getSimpleName(), false, "_id>?", new String[] { String.valueOf(this.a) }, null, null, null, "300");
      if (paramawgf == null) {
        break label291;
      }
      paramSQLiteDatabase = new ArrayList(paramawgf.size());
      try
      {
        paramawgf = paramawgf.iterator();
        while (paramawgf.hasNext()) {
          paramSQLiteDatabase.add(((FTSNewTroopSync)paramawgf.next()).transTroopSync());
        }
        QLog.e("Q.fts.troop.operator.new", 1, paramawgf, new Object[0]);
      }
      catch (Throwable paramawgf) {}
    }
    catch (Throwable paramawgf)
    {
      for (;;)
      {
        int i;
        paramSQLiteDatabase = localObject;
        continue;
        paramSQLiteDatabase = null;
      }
    }
    paramawgf = new HashMap();
    paramawgf.put("type", "2");
    azri.a(BaseApplicationImpl.getApplication().getApplicationContext()).a(null, "actGetOptFailed", true, 0L, 0L, paramawgf, null);
    paramawgf = paramSQLiteDatabase;
    label225:
    return paramawgf;
    paramawgf = paramSQLiteDatabase;
    for (;;)
    {
      try
      {
        if (!QLog.isColorLevel()) {
          break label225;
        }
        paramawgf = new StringBuilder().append("getOptSyncList size:");
        if (paramSQLiteDatabase == null) {
          break label279;
        }
        i = paramSQLiteDatabase.size();
        QLog.d("Q.fts.troop.operator.new", 2, i);
        return paramSQLiteDatabase;
      }
      catch (Throwable paramawgf) {}
      break;
      label279:
      i = 0;
    }
  }
  
  protected String b()
  {
    return "NewTroopCursor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amoe
 * JD-Core Version:    0.7.0.1
 */