package com.tencent.mm.vfs;

import java.util.Comparator;

final class ResolverState$1
  implements Comparator<ResolverState.MountPointEntry>
{
  public int compare(ResolverState.MountPointEntry paramMountPointEntry1, ResolverState.MountPointEntry paramMountPointEntry2)
  {
    return paramMountPointEntry1.basePath.compareTo(paramMountPointEntry2.basePath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.ResolverState.1
 * JD-Core Version:    0.7.0.1
 */