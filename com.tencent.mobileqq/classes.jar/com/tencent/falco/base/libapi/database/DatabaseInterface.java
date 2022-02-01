package com.tencent.falco.base.libapi.database;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import java.util.ArrayList;
import java.util.List;

public abstract interface DatabaseInterface
  extends ServiceBaseInterface
{
  public abstract <T> boolean add(T paramT);
  
  public abstract <T> boolean addAll(ArrayList<T> paramArrayList);
  
  public abstract <T> void delete(Class<T> paramClass, String paramString, String[] paramArrayOfString);
  
  public abstract <T> void deleteALL(Class<T> paramClass);
  
  public abstract void init(DatabaseInterface.DatabaseServiceAdapter paramDatabaseServiceAdapter);
  
  public abstract <T> List<T> queryALL(Class<T> paramClass, String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, String paramString4, String paramString5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.database.DatabaseInterface
 * JD-Core Version:    0.7.0.1
 */