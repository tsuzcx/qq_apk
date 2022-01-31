package com.etrump.mixlayout;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ETDecoration
{
  private static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public int a;
  private long jdField_a_of_type_Long;
  private ETEngine jdField_a_of_type_ComEtrumpMixlayoutETEngine;
  private String jdField_a_of_type_JavaLangString;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int b;
  
  private ETDecoration()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public static ETDecoration a(ETEngine paramETEngine, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ETFont paramETFont)
  {
    if ((paramETEngine == null) || (paramString == null) || (paramETFont == null)) {}
    long l;
    do
    {
      do
      {
        return null;
      } while ((paramInt1 <= 0) || (paramInt2 <= 0) || (paramInt4 <= 0));
      l = paramETEngine.native_decorationCreateDescriptor(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramETFont);
    } while (l == 0L);
    paramInt2 = paramETEngine.native_decorationGetFrameNum(l);
    if (paramInt2 == 0)
    {
      paramETEngine.native_decorationDeleteDescriptor(l);
      return null;
    }
    paramETFont = new int[paramInt2];
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      paramETFont[paramInt1] = paramETEngine.native_decorationGetFrameDelay(l, paramInt1);
      paramInt1 += 1;
    }
    ETDecoration localETDecoration = new ETDecoration();
    localETDecoration.jdField_a_of_type_Long = l;
    localETDecoration.jdField_a_of_type_ArrayOfInt = paramETFont;
    localETDecoration.b = paramInt2;
    localETDecoration.jdField_a_of_type_JavaLangString = paramString;
    localETDecoration.jdField_a_of_type_ComEtrumpMixlayoutETEngine = paramETEngine;
    a(paramETEngine);
    jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), new WeakReference(localETDecoration));
    return localETDecoration;
  }
  
  private static void a(ETEngine paramETEngine)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (((WeakReference)localEntry.getValue()).get() == null) {
        ((ArrayList)localObject1).add(localEntry.getKey());
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      if (((Long)localObject2).longValue() != 0L) {
        paramETEngine.native_decorationDeleteDescriptor(((Long)localObject2).longValue());
      }
      jdField_a_of_type_JavaUtilHashMap.remove(localObject2);
    }
  }
  
  private int c()
  {
    int j = this.jdField_a_of_type_Int;
    int i;
    if (j >= 0)
    {
      i = j;
      if (j < this.b) {}
    }
    else
    {
      i = this.b - 1;
    }
    return i;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4, ETFont paramETFont)
  {
    int i = c();
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null) && (0L != this.jdField_a_of_type_Long) && (i >= 0) && (i < this.b)) {
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_decorationDrawText(this.jdField_a_of_type_Long, i, paramInt1, paramInt2, paramETFont, paramBitmap, paramInt3, paramInt4);
    }
  }
  
  public void a(Bitmap paramBitmap, ETFont paramETFont)
  {
    int i = c();
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null) && (0L != this.jdField_a_of_type_Long) && (i >= 0) && (i < this.b)) {
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_decorationDrawBackground(this.jdField_a_of_type_Long, i, paramETFont, paramBitmap);
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int >= this.b)
    {
      this.jdField_a_of_type_Int = -1;
      return false;
    }
    return true;
  }
  
  public int b()
  {
    int i = c();
    if ((this.jdField_a_of_type_ArrayOfInt != null) && (i >= 0) && (i < this.jdField_a_of_type_ArrayOfInt.length)) {
      return this.jdField_a_of_type_ArrayOfInt[i];
    }
    return 0;
  }
  
  public void b()
  {
    if (0L != this.jdField_a_of_type_Long)
    {
      jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(this.jdField_a_of_type_Long));
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_decorationDeleteDescriptor(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Long = 0L;
    }
  }
  
  public void b(Bitmap paramBitmap, ETFont paramETFont)
  {
    int i = c();
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null) && (0L != this.jdField_a_of_type_Long) && (i >= 0) && (i < this.b)) {
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_decorationDrawForeground(this.jdField_a_of_type_Long, i, paramETFont, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.etrump.mixlayout.ETDecoration
 * JD-Core Version:    0.7.0.1
 */