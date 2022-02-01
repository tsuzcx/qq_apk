package com.tencent.mm.plugin.appbrand.appstorage;

public class FileStructStat
{
  public long st_atime;
  public long st_ctime;
  public int st_mode;
  public long st_mtime;
  public long st_size;
  
  public void fillAnother(FileStructStat paramFileStructStat)
  {
    if (paramFileStructStat == null) {
      return;
    }
    paramFileStructStat.st_mode = this.st_mode;
    paramFileStructStat.st_size = this.st_size;
    paramFileStructStat.st_atime = this.st_atime;
    paramFileStructStat.st_mtime = this.st_mtime;
    paramFileStructStat.st_ctime = this.st_ctime;
  }
  
  public boolean isDirectory()
  {
    return (this.st_mode & 0x4000) == 16384;
  }
  
  public boolean isSymLink()
  {
    return (this.st_mode & 0xF000) == 40960;
  }
  
  public void makeItIsDir()
  {
    this.st_mode |= 0x4000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.FileStructStat
 * JD-Core Version:    0.7.0.1
 */