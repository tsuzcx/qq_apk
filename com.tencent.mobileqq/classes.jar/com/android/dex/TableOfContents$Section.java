package com.android.dex;

public class TableOfContents$Section
  implements Comparable<Section>
{
  public int byteCount = 0;
  public int off = -1;
  public int size = 0;
  public final short type;
  
  public TableOfContents$Section(int paramInt)
  {
    this.type = ((short)paramInt);
  }
  
  public int compareTo(Section paramSection)
  {
    if (this.off != paramSection.off)
    {
      if (this.off < paramSection.off) {
        return -1;
      }
      return 1;
    }
    return 0;
  }
  
  public boolean exists()
  {
    return this.size > 0;
  }
  
  public String toString()
  {
    return String.format("Section[type=%#x,off=%#x,size=%#x]", new Object[] { Short.valueOf(this.type), Integer.valueOf(this.off), Integer.valueOf(this.size) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.TableOfContents.Section
 * JD-Core Version:    0.7.0.1
 */