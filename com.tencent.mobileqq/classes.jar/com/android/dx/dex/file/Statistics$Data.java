package com.android.dx.dex.file;

import com.android.dx.util.AnnotatedOutput;

class Statistics$Data
{
  private int count;
  private int largestSize;
  private final String name;
  private int smallestSize;
  private int totalSize;
  
  public Statistics$Data(Item paramItem, String paramString)
  {
    int i = paramItem.writeSize();
    this.name = paramString;
    this.count = 1;
    this.totalSize = i;
    this.largestSize = i;
    this.smallestSize = i;
  }
  
  public void add(Item paramItem)
  {
    int i = paramItem.writeSize();
    this.count += 1;
    this.totalSize += i;
    if (i > this.largestSize) {
      this.largestSize = i;
    }
    if (i < this.smallestSize) {
      this.smallestSize = i;
    }
  }
  
  public String toHuman()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder().append("  ").append(this.name).append(": ").append(this.count).append(" item");
    String str;
    if (this.count == 1)
    {
      str = "";
      localStringBuilder1.append(str + "; " + this.totalSize + " bytes total\n");
      if (this.smallestSize != this.largestSize) {
        break label142;
      }
      localStringBuilder1.append("    " + this.smallestSize + " bytes/item\n");
    }
    for (;;)
    {
      return localStringBuilder1.toString();
      str = "s";
      break;
      label142:
      int i = this.totalSize / this.count;
      localStringBuilder1.append("    " + this.smallestSize + ".." + this.largestSize + " bytes/item; average " + i + "\n");
    }
  }
  
  public void writeAnnotation(AnnotatedOutput paramAnnotatedOutput)
  {
    paramAnnotatedOutput.annotate(toHuman());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.Statistics.Data
 * JD-Core Version:    0.7.0.1
 */