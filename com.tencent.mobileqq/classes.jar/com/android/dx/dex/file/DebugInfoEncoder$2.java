package com.android.dx.dex.file;

import com.android.dx.dex.code.LocalList.Entry;
import java.util.Comparator;

class DebugInfoEncoder$2
  implements Comparator<LocalList.Entry>
{
  DebugInfoEncoder$2(DebugInfoEncoder paramDebugInfoEncoder) {}
  
  public int compare(LocalList.Entry paramEntry1, LocalList.Entry paramEntry2)
  {
    return paramEntry1.getRegister() - paramEntry2.getRegister();
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject == this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.DebugInfoEncoder.2
 * JD-Core Version:    0.7.0.1
 */