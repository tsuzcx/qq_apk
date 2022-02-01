package com.tencent.av.ui.viewcontroller;

import android.content.res.Resources;

public final class OperationMenuViewFactory
{
  public static QavOperationMenuViewController a(Resources paramResources, int paramInt)
  {
    Object localObject1 = (int[][])null;
    switch (paramInt)
    {
    case 2131559740: 
    case 2131559741: 
    case 2131559743: 
    default: 
      return null;
    case 2131559745: 
      localObject1 = new int[7][];
      localObject1[0] = { 2131695344, 2130842280 };
      localObject1[1] = { 2131695333, 2130842267 };
      localObject1[2] = { 2131695346, 2130842282 };
      localObject1[3] = { 2131695336, 2130842269 };
      localObject1[4] = { 2131695341, 2130842091 };
      localObject1[5] = { 2131695337, 2130842270 };
      localObject1[6] = { 2131695335, 2130842268 };
      break;
    case 2131559744: 
      localObject1 = new int[10][];
      localObject1[0] = { 2131695344, 2130842280 };
      localObject1[1] = { 2131695333, 2130842267 };
      localObject1[2] = { 2131695346, 2130842282 };
      localObject1[3] = { 2131695336, 2130842269 };
      localObject1[4] = { 2131695345, 2130842281 };
      localObject1[5] = { 2131695341, 2130842091 };
      localObject1[6] = { 2131695339, 2130842089 };
      localObject1[7] = { 2131695334, 2130842354 };
      localObject1[8] = { 2131695337, 2130842270 };
      localObject1[9] = { 2131695335, 2130842268 };
      break;
    case 2131559742: 
      localObject1 = new int[3][];
      localObject1[0] = { 2131695333, 2130842267 };
      localObject1[1] = { 2131695341, 2130842091 };
      localObject1[2] = { 2131695339, 2130842089 };
      break;
    case 2131559739: 
      localObject1 = new int[11][];
      localObject1[0] = { 2131695333, 2130842267 };
      localObject1[1] = { 2131695346, 2130842282 };
      localObject1[2] = { 2131695336, 2130842269 };
      localObject1[3] = { 2131695345, 2130842281 };
      localObject1[4] = { 2131695341, 2130842091 };
      localObject1[5] = { 2131695347, 2130842095 };
      localObject1[6] = { 2131695339, 2130842089 };
      localObject1[7] = { 2131695338, 2130842271 };
      localObject1[8] = { 2131695334, 2130842354 };
      localObject1[9] = { 2131695337, 2130842270 };
      localObject1[10] = { 2131695343, 2130842278 };
    }
    QavOperationMenuViewController localQavOperationMenuViewController = new QavOperationMenuViewController();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      localQavOperationMenuViewController.a(new OperationBtnItem(localObject2[0], paramResources.getString(localObject2[0]), localObject2[1]));
      i += 1;
    }
    localQavOperationMenuViewController.a = paramInt;
    return localQavOperationMenuViewController;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.viewcontroller.OperationMenuViewFactory
 * JD-Core Version:    0.7.0.1
 */