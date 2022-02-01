package com.android.dx.dex.file;

import com.android.dx.dex.code.PositionList.Entry;
import java.util.Comparator;

class DebugInfoEncoder$1
  implements Comparator<PositionList.Entry>
{
  DebugInfoEncoder$1(DebugInfoEncoder paramDebugInfoEncoder) {}
  
  public int compare(PositionList.Entry paramEntry1, PositionList.Entry paramEntry2)
  {
    return paramEntry1.getAddress() - paramEntry2.getAddress();
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject == this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.DebugInfoEncoder.1
 * JD-Core Version:    0.7.0.1
 */