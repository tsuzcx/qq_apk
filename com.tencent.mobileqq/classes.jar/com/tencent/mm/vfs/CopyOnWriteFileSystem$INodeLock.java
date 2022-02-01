package com.tencent.mm.vfs;

import java.util.HashSet;

final class CopyOnWriteFileSystem$INodeLock
{
  private static final HashSet<Long> inodeTable = new HashSet();
  
  static void lock(long paramLong)
  {
    for (;;)
    {
      synchronized (inodeTable)
      {
        boolean bool = inodeTable.add(Long.valueOf(paramLong));
        if (!bool) {}
        try
        {
          inodeTable.wait();
        }
        catch (InterruptedException localInterruptedException) {}
        return;
      }
    }
  }
  
  static void unlock(long paramLong)
  {
    synchronized (inodeTable)
    {
      if (inodeTable.remove(Long.valueOf(paramLong))) {
        inodeTable.notifyAll();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.CopyOnWriteFileSystem.INodeLock
 * JD-Core Version:    0.7.0.1
 */