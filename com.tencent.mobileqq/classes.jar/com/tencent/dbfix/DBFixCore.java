package com.tencent.dbfix;

import java.util.ArrayList;
import java.util.List;

class DBFixCore
{
  public native boolean doBackupMaster(String paramString1, String paramString2);
  
  public native boolean doDBFixRepair(String paramString1, String paramString2, String paramString3, DBFixResult paramDBFixResult);
  
  public native boolean doDumpRepair(String paramString1, String paramString2, DBFixResult paramDBFixResult);
  
  public native ArrayList<DBCheckResultItem> doIntegrityCheck(String paramString);
  
  public native int doReindexRepair(String paramString, List<String> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.dbfix.DBFixCore
 * JD-Core Version:    0.7.0.1
 */