package com.tencent.mobileqq.app.proxy.fts;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.fts.FTSNewTroopSync;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.fts.FTSOptSync;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FTSNewTroopOperator
  extends FTSTroopOperator
{
  public FTSNewTroopOperator(QQAppInterface paramQQAppInterface, FTSSyncHandler paramFTSSyncHandler)
  {
    super(paramQQAppInterface, paramFTSSyncHandler);
    this.d = true;
  }
  
  protected FTSOptSync a(int paramInt, long paramLong1, long paramLong2)
  {
    return new FTSNewTroopSync(paramInt, paramLong1, paramLong2);
  }
  
  protected String a()
  {
    return "NewTroopCursor";
  }
  
  protected List a(SQLiteDatabase paramSQLiteDatabase, EntityManager paramEntityManager)
  {
    Iterator localIterator = null;
    int i = 0;
    if (this.a > 0)
    {
      int j = paramSQLiteDatabase.a(FTSNewTroopSync.class.getSimpleName(), "_id<=?", new String[] { String.valueOf(this.a) });
      if ((QLog.isColorLevel()) && (j > 0)) {
        QLog.d("Q.fts.troop.operator.new", 2, "delete " + FTSNewTroopSync.class.getSimpleName() + " row=" + j);
      }
    }
    List localList = paramEntityManager.a(FTSNewTroopSync.class, FTSNewTroopSync.class.getSimpleName(), false, "_id>?", new String[] { String.valueOf(this.a) }, null, null, null, "300");
    paramSQLiteDatabase = localIterator;
    if (localList != null)
    {
      paramEntityManager = new ArrayList(localList.size());
      localIterator = localList.iterator();
      for (;;)
      {
        paramSQLiteDatabase = paramEntityManager;
        if (!localIterator.hasNext()) {
          break;
        }
        paramEntityManager.add(((FTSNewTroopSync)localIterator.next()).transTroopSync());
      }
    }
    if (QLog.isColorLevel())
    {
      paramEntityManager = new StringBuilder().append("getOptSyncList size:");
      if (paramSQLiteDatabase != null) {
        i = paramSQLiteDatabase.size();
      }
      QLog.d("Q.fts.troop.operator.new", 2, i);
    }
    return paramSQLiteDatabase;
  }
  
  protected boolean d()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.fts.FTSNewTroopOperator
 * JD-Core Version:    0.7.0.1
 */