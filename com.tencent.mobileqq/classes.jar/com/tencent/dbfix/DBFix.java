package com.tencent.dbfix;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DBFix
{
  private static final String TAG = "DBFix";
  private static final DBFix sInstance = new DBFix();
  private DBFixCore mCore = null;
  
  public static DBFix getInstance()
  {
    return sInstance;
  }
  
  public boolean doBackupMaster(String paramString1, String paramString2)
  {
    if (!new File(paramString1).exists())
    {
      DBFixLog.d("DBFix", new Object[] { " doDBFixRepair file not exist:", paramString1 });
      return false;
    }
    return this.mCore.doBackupMaster(paramString1, paramString2);
  }
  
  public boolean doDBFixRepair(String paramString1, String paramString2, String paramString3, DBFixResult paramDBFixResult)
  {
    if (!new File(paramString1).exists())
    {
      DBFixLog.d("DBFix", new Object[] { " doDBFixRepair file not exist:", paramString1 });
      return false;
    }
    return this.mCore.doDBFixRepair(paramString1, paramString2, paramString3, paramDBFixResult);
  }
  
  public boolean doDumpRepair(String paramString1, String paramString2, DBFixResult paramDBFixResult)
  {
    if (!new File(paramString1).exists())
    {
      DBFixLog.d("DBFix", new Object[] { " doDumpRepair file not exist:", paramString1 });
      return false;
    }
    return this.mCore.doDumpRepair(paramString1, paramString2, paramDBFixResult);
  }
  
  public ArrayList<DBCheckResultItem> doIntegrityCheck(String paramString)
  {
    if (!new File(paramString).exists())
    {
      DBFixLog.d("DBFix", new Object[] { " doIntegrityCheck file not exist:", paramString });
      return new ArrayList();
    }
    return this.mCore.doIntegrityCheck(paramString);
  }
  
  public int doReindexRepair(String paramString, List<String> paramList)
  {
    if (!new File(paramString).exists())
    {
      DBFixLog.d("DBFix", new Object[] { " doIntegrityCheck file not exist:", paramString });
      return -1;
    }
    return this.mCore.doReindexRepair(paramString, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.dbfix.DBFix
 * JD-Core Version:    0.7.0.1
 */