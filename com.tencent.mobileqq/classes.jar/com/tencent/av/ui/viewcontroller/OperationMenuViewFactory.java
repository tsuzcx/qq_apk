package com.tencent.av.ui.viewcontroller;

import android.content.res.Resources;
import com.tencent.av.QavABTestUtils;

public final class OperationMenuViewFactory
{
  public static QavOperationMenuViewController a(Resources paramResources, int paramInt)
  {
    Object localObject1 = (int[][])null;
    switch (paramInt)
    {
    case 2131559864: 
    case 2131559865: 
    case 2131559867: 
    default: 
      return null;
    case 2131559863: 
      if (!QavABTestUtils.c())
      {
        localObject1 = new int[] { 2131695331, 2130842193 };
        localObject2 = new int[] { 2131695328, 2130842373 };
        localObject1 = new int[][] { { 2131695323, 2130842369 }, { 2131695336, 2130842384 }, { 2131695326, 2130842371 }, { 2131695335, 2130842383 }, localObject1, { 2131695337, 2130842197 }, { 2131695329, 2130842191 }, localObject2, { 2131695324, 2130842455 }, { 2131695327, 2130842372 }, { 2131695333, 2130842380 } };
      }
      break;
    }
    int[] arrayOfInt1;
    while (localObject1 == null)
    {
      return null;
      localObject1 = new int[][] { { 2131695323, 2130842369 }, { 2131695336, 2130842384 }, { 2131695326, 2130842371 }, { 2131695335, 2130842383 }, { 2131695331, 2130842193 }, { 2131695337, 2130842197 }, { 2131695329, 2130842191 }, { 2131695324, 2130842455 }, { 2131695327, 2130842372 }, { 2131695333, 2130842380 } };
      continue;
      localObject1 = new int[] { 2131695334, 2130842382 };
      localObject2 = new int[] { 2131695323, 2130842369 };
      arrayOfInt1 = new int[] { 2131695326, 2130842371 };
      int[] arrayOfInt2 = { 2131695331, 2130842193 };
      int[] arrayOfInt3 = { 2131695327, 2130842372 };
      localObject1 = new int[][] { localObject1, localObject2, { 2131695336, 2130842384 }, arrayOfInt1, arrayOfInt2, arrayOfInt3, { 2131695325, 2130842370 } };
      continue;
      localObject1 = new int[] { 2131695324, 2130842455 };
      localObject1 = new int[][] { { 2131695334, 2130842382 }, { 2131695323, 2130842369 }, { 2131695336, 2130842384 }, { 2131695326, 2130842371 }, { 2131695335, 2130842383 }, { 2131695331, 2130842193 }, { 2131695329, 2130842191 }, localObject1, { 2131695327, 2130842372 }, { 2131695325, 2130842370 } };
      continue;
      localObject1 = new int[][] { { 2131695323, 2130842369 }, { 2131695331, 2130842193 }, { 2131695329, 2130842191 } };
    }
    Object localObject2 = new QavOperationMenuViewController();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      arrayOfInt1 = localObject1[i];
      ((QavOperationMenuViewController)localObject2).a(new OperationBtnItem(arrayOfInt1[0], paramResources.getString(arrayOfInt1[0]), arrayOfInt1[1]));
      i += 1;
    }
    ((QavOperationMenuViewController)localObject2).a = paramInt;
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.viewcontroller.OperationMenuViewFactory
 * JD-Core Version:    0.7.0.1
 */