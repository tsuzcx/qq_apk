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

public class amjp
  extends amjr
{
  public amjp(QQAppInterface paramQQAppInterface, amjq paramamjq)
  {
    super(paramQQAppInterface, paramamjq);
    this.d = true;
  }
  
  protected FTSOptSync a(int paramInt, long paramLong1, long paramLong2)
  {
    return new FTSNewTroopSync(paramInt, paramLong1, paramLong2);
  }
  
  protected List<FTSOptSync> a(SQLiteDatabase paramSQLiteDatabase, awbw paramawbw)
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
      paramawbw = paramawbw.a(FTSNewTroopSync.class, FTSNewTroopSync.class.getSimpleName(), false, "_id>?", new String[] { String.valueOf(this.a) }, null, null, null, "300");
      if (paramawbw == null) {
        break label291;
      }
      paramSQLiteDatabase = new ArrayList(paramawbw.size());
      try
      {
        paramawbw = paramawbw.iterator();
        while (paramawbw.hasNext()) {
          paramSQLiteDatabase.add(((FTSNewTroopSync)paramawbw.next()).transTroopSync());
        }
        QLog.e("Q.fts.troop.operator.new", 1, paramawbw, new Object[0]);
      }
      catch (Throwable paramawbw) {}
    }
    catch (Throwable paramawbw)
    {
      for (;;)
      {
        int i;
        paramSQLiteDatabase = localObject;
        continue;
        paramSQLiteDatabase = null;
      }
    }
    paramawbw = new HashMap();
    paramawbw.put("type", "2");
    azmz.a(BaseApplicationImpl.getApplication().getApplicationContext()).a(null, "actGetOptFailed", true, 0L, 0L, paramawbw, null);
    paramawbw = paramSQLiteDatabase;
    label225:
    return paramawbw;
    paramawbw = paramSQLiteDatabase;
    for (;;)
    {
      try
      {
        if (!QLog.isColorLevel()) {
          break label225;
        }
        paramawbw = new StringBuilder().append("getOptSyncList size:");
        if (paramSQLiteDatabase == null) {
          break label279;
        }
        i = paramSQLiteDatabase.size();
        QLog.d("Q.fts.troop.operator.new", 2, i);
        return paramSQLiteDatabase;
      }
      catch (Throwable paramawbw) {}
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
 * Qualified Name:     amjp
 * JD-Core Version:    0.7.0.1
 */