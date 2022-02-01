package com.tencent.component.network.module.cache.file;

import java.util.Comparator;

final class FileCacheService$2
  implements Comparator<FileCacheService.FileEntry>
{
  public int compare(FileCacheService.FileEntry paramFileEntry1, FileCacheService.FileEntry paramFileEntry2)
  {
    if (paramFileEntry1.lastModified < paramFileEntry2.lastModified) {
      return -1;
    }
    if (paramFileEntry1.lastModified == paramFileEntry2.lastModified) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.module.cache.file.FileCacheService.2
 * JD-Core Version:    0.7.0.1
 */