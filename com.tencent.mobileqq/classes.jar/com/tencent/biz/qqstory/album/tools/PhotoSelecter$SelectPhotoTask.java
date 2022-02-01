package com.tencent.biz.qqstory.album.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import vyn;
import vyo;
import vyp;
import ykq;

public class PhotoSelecter$SelectPhotoTask
  implements Runnable
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  List<vyo> jdField_a_of_type_JavaUtilList;
  vyn jdField_a_of_type_Vyn;
  long b;
  
  public void run()
  {
    Collections.sort(this.jdField_a_of_type_JavaUtilList);
    Object localObject2 = new ArrayList();
    int j = this.jdField_a_of_type_JavaUtilList.size() / this.jdField_a_of_type_Int;
    Object localObject1 = null;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (i % j == 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
      }
      ((ArrayList)localObject1).add(this.jdField_a_of_type_JavaUtilList.get(i));
      i += 1;
    }
    int[] arrayOfInt = new int[((ArrayList)localObject2).size()];
    i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = 0;
      i += 1;
    }
    j = 0;
    ArrayList localArrayList = new ArrayList();
    i = 1;
    int k;
    if (localArrayList.size() < this.jdField_a_of_type_Int)
    {
      int m = 0;
      k = 0;
      while (k < arrayOfInt.length)
      {
        m += arrayOfInt[k];
        k += 1;
      }
      if (m < arrayOfInt.length) {}
    }
    else
    {
      localObject1 = new ArrayList();
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(((vyo)((Iterator)localObject2).next()).jdField_a_of_type_Vxh);
      }
    }
    Object localObject3;
    if (j >= ((ArrayList)localObject2).size())
    {
      localObject1 = PhotoSelecter.a;
      localObject3 = new StringBuilder().append("round = ");
      k = i + 1;
      ykq.b((String)localObject1, i);
      j = 0;
      i = k;
    }
    for (;;)
    {
      localObject3 = ((ArrayList)((ArrayList)localObject2).get(j)).iterator();
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (vyo)((Iterator)localObject3).next();
      } while (((vyo)localObject1).jdField_a_of_type_Int != 1);
      for (;;)
      {
        if (localObject1 == null)
        {
          arrayOfInt[j] = 1;
          Log.d("stevcao", "abandon cursor = " + j);
          j += 1;
          break;
        }
        if (localArrayList.size() == 0)
        {
          ((vyo)localObject1).jdField_a_of_type_Int = 2;
          localArrayList.add(localObject1);
          label410:
          j += 1;
          break;
        }
        localObject3 = localArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Bitmap localBitmap1 = ((vyo)((Iterator)localObject3).next()).a(this.jdField_a_of_type_AndroidContentContext);
          Bitmap localBitmap2 = ((vyo)localObject1).a(this.jdField_a_of_type_AndroidContentContext);
          long l1 = System.currentTimeMillis();
          double d = vyp.a(localBitmap1, localBitmap2);
          long l2 = this.jdField_a_of_type_Long;
          this.jdField_a_of_type_Long = (System.currentTimeMillis() - l1 + l2);
          this.b += 1L;
          if (d >= 0.7D) {
            ((vyo)localObject1).jdField_a_of_type_Int = 3;
          }
        }
        for (k = 1;; k = 0)
        {
          if (k != 0)
          {
            j += 1;
            break;
          }
          ((vyo)localObject1).jdField_a_of_type_Int = 2;
          localArrayList.add(localObject1);
          break label410;
          ykq.b(PhotoSelecter.a, "compare total time = " + this.jdField_a_of_type_Long + " compareTimes = " + this.b);
          ykq.b(PhotoSelecter.a, "single compare time = " + this.jdField_a_of_type_Long / this.b);
          this.jdField_a_of_type_Vyn.a((ArrayList)localObject1);
          return;
        }
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.tools.PhotoSelecter.SelectPhotoTask
 * JD-Core Version:    0.7.0.1
 */