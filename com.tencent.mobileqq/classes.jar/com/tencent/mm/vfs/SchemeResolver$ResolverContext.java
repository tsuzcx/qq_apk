package com.tencent.mm.vfs;

import java.util.Map;
import java.util.SortedMap;

public abstract interface SchemeResolver$ResolverContext
{
  public abstract SortedMap<String, FileSystem> activeMountPoints();
  
  public abstract Map<String, String> envVars();
  
  public abstract Map<String, FileSystem> fileSystems();
  
  public abstract FileSystem root();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.SchemeResolver.ResolverContext
 * JD-Core Version:    0.7.0.1
 */