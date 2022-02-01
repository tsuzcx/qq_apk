package com.tencent.falco.base.libapi.database;

import com.tencent.falco.base.libapi.log.LogInterface;
import java.util.List;

public abstract interface DatabaseInterface$DatabaseServiceAdapter
{
  public abstract String getDBName();
  
  public abstract int getDBVersion();
  
  public abstract LogInterface getLog();
  
  public abstract List<Class> getTableClzList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.database.DatabaseInterface.DatabaseServiceAdapter
 * JD-Core Version:    0.7.0.1
 */