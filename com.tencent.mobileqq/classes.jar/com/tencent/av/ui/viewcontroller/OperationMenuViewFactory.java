package com.tencent.av.ui.viewcontroller;

import android.content.res.Resources;

public final class OperationMenuViewFactory
{
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 2131893081: 
    default: 
      return 117;
    case 2131893088: 
      return 102;
    case 2131893087: 
      return 101;
    case 2131893086: 
      return 111;
    case 2131893085: 
      return 114;
    case 2131893084: 
      return 106;
    case 2131893083: 
      return 109;
    case 2131893082: 
      return 107;
    case 2131893080: 
      return 104;
    case 2131893079: 
      return 108;
    case 2131893078: 
      return 105;
    case 2131893077: 
      return 112;
    case 2131893076: 
      return 116;
    case 2131893075: 
      return 110;
    case 2131893074: 
      return 103;
    case 2131893073: 
      return 113;
    }
    return 115;
  }
  
  public static QavOperationMenuViewController a(Resources paramResources, int paramInt)
  {
    Object localObject1 = (int[][])null;
    switch (paramInt)
    {
    case 2131625781: 
    case 2131625782: 
    case 2131625784: 
    default: 
      return null;
    case 2131625787: 
      localObject1 = new int[7][];
      localObject1[0] = { 2131893085, 2130843224 };
      localObject1[1] = { 2131893073, 2130843210 };
      localObject1[2] = { 2131893087, 2130843226 };
      localObject1[3] = { 2131893077, 2130843213 };
      localObject1[4] = { 2131893082, 2130843015 };
      localObject1[5] = { 2131893078, 2130843214 };
      localObject1[6] = { 2131893075, 2130843211 };
      break;
    case 2131625786: 
      localObject1 = new int[9][];
      localObject1[0] = { 2131893073, 2130843210 };
      localObject1[1] = { 2131893080, 2130843013 };
      localObject1[2] = { 2131893072, 2130842976 };
      localObject1[3] = { 2131893085, 2130843224 };
      localObject1[4] = { 2131893074, 2130843298 };
      localObject1[5] = { 2131893086, 2130843225 };
      localObject1[6] = { 2131893082, 2130843015 };
      localObject1[7] = { 2131893078, 2130843214 };
      localObject1[8] = { 2131893075, 2130843211 };
      break;
    case 2131625785: 
      localObject1 = new int[11][];
      localObject1[0] = { 2131893073, 2130843210 };
      localObject1[1] = { 2131893087, 2130843226 };
      localObject1[2] = { 2131893077, 2130843213 };
      localObject1[3] = { 2131893080, 2130843013 };
      localObject1[4] = { 2131893072, 2130842976 };
      localObject1[5] = { 2131893085, 2130843224 };
      localObject1[6] = { 2131893074, 2130843298 };
      localObject1[7] = { 2131893086, 2130843225 };
      localObject1[8] = { 2131893082, 2130843015 };
      localObject1[9] = { 2131893078, 2130843214 };
      localObject1[10] = { 2131893075, 2130843211 };
      break;
    case 2131625783: 
      localObject1 = new int[3][];
      localObject1[0] = { 2131893073, 2130843210 };
      localObject1[1] = { 2131893080, 2130843013 };
      localObject1[2] = { 2131893082, 2130843015 };
      break;
    case 2131625780: 
      localObject1 = new int[12][];
      localObject1[0] = { 2131893073, 2130843210 };
      localObject1[1] = { 2131893080, 2130843013 };
      localObject1[2] = { 2131893088, 2130843021 };
      localObject1[3] = { 2131893072, 2130842976 };
      localObject1[4] = { 2131893074, 2130843298 };
      localObject1[5] = { 2131893086, 2130843225 };
      localObject1[6] = { 2131893076, 2130843212 };
      localObject1[7] = { 2131893083, 2130843310 };
      localObject1[8] = { 2131893082, 2130843015 };
      localObject1[9] = { 2131893079, 2130843215 };
      localObject1[10] = { 2131893078, 2130843214 };
      localObject1[11] = { 2131893084, 2130843222 };
      break;
    case 2131625779: 
      localObject1 = new int[14][];
      localObject1[0] = { 2131893073, 2130843210 };
      localObject1[1] = { 2131893087, 2130843226 };
      localObject1[2] = { 2131893077, 2130843213 };
      localObject1[3] = { 2131893080, 2130843013 };
      localObject1[4] = { 2131893088, 2130843021 };
      localObject1[5] = { 2131893072, 2130842976 };
      localObject1[6] = { 2131893074, 2130843298 };
      localObject1[7] = { 2131893086, 2130843225 };
      localObject1[8] = { 2131893076, 2130843212 };
      localObject1[9] = { 2131893083, 2130843310 };
      localObject1[10] = { 2131893082, 2130843015 };
      localObject1[11] = { 2131893079, 2130843215 };
      localObject1[12] = { 2131893078, 2130843214 };
      localObject1[13] = { 2131893084, 2130843222 };
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
    localQavOperationMenuViewController.c = paramInt;
    return localQavOperationMenuViewController;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.viewcontroller.OperationMenuViewFactory
 * JD-Core Version:    0.7.0.1
 */