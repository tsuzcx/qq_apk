package com.huawei.hms.common.data;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

public final class DataBufferUtils
{
  public static final int ARGS_BUNDLE = 4;
  public static final int ARGS_COLUMN = 1;
  public static final int ARGS_CURSOR = 2;
  public static final int ARGS_STATUS = 3;
  public static final int ARGS_VERSION = 1000;
  public static final String NEXT_PAGE = "next_page";
  public static final String PREV_PAGE = "prev_page";
  
  private static boolean containKey(Bundle paramBundle, String paramString)
  {
    boolean bool = false;
    if (paramBundle == null) {
      return false;
    }
    if (paramBundle.getString(paramString) != null) {
      bool = true;
    }
    return bool;
  }
  
  public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> paramDataBuffer)
  {
    ArrayList localArrayList = new ArrayList(paramDataBuffer.getCount());
    Iterator localIterator = paramDataBuffer.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Freezable)localIterator.next()).freeze());
    }
    paramDataBuffer.release();
    return localArrayList;
  }
  
  public static boolean hasData(DataBuffer<?> paramDataBuffer)
  {
    boolean bool = false;
    if (paramDataBuffer == null) {
      return false;
    }
    if (paramDataBuffer.getCount() > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean hasNextPage(DataBuffer<?> paramDataBuffer)
  {
    return containKey(paramDataBuffer.getMetadata(), "next_page");
  }
  
  public static boolean hasPrevPage(DataBuffer<?> paramDataBuffer)
  {
    return containKey(paramDataBuffer.getMetadata(), "prev_page");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.data.DataBufferUtils
 * JD-Core Version:    0.7.0.1
 */