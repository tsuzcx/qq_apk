package com.android.multidex;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

class FolderPathElement
  implements ClassPathElement
{
  private File baseFolder;
  
  public FolderPathElement(File paramFile)
  {
    this.baseFolder = paramFile;
  }
  
  private void collect(File paramFile, String paramString, ArrayList<String> paramArrayList)
  {
    paramFile = paramFile.listFiles();
    int j = paramFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile = paramFile[i];
      if (localFile.isDirectory()) {
        collect(localFile, paramString + '/' + localFile.getName(), paramArrayList);
      }
      for (;;)
      {
        i += 1;
        break;
        paramArrayList.add(paramString + '/' + localFile.getName());
      }
    }
  }
  
  public void close() {}
  
  public Iterable<String> list()
  {
    ArrayList localArrayList = new ArrayList();
    collect(this.baseFolder, "", localArrayList);
    return localArrayList;
  }
  
  public InputStream open(String paramString)
  {
    return new FileInputStream(new File(this.baseFolder, paramString.replace('/', File.separatorChar)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.multidex.FolderPathElement
 * JD-Core Version:    0.7.0.1
 */