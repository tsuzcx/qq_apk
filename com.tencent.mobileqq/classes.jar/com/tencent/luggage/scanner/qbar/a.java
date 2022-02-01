package com.tencent.luggage.scanner.qbar;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.qbar.QBar;
import com.tencent.qbar.QBar.QBarResult;
import com.tencent.qbar.QBarImageUtil;
import com.tencent.qbar.QbarNative.QBarCodeDetectInfo;
import com.tencent.qbar.QbarNative.QBarPoint;
import com.tencent.qbar.QbarNative.QBarReportMsg;
import com.tencent.qbar.QbarNative.QBarZoomInfo;
import com.tencent.qbar.QbarNative.QbarAiModelParam;
import java.util.ArrayList;
import java.util.List;

public class a
{
  protected String a = "BaseQBarAIDecoder";
  protected QBar b = new QBar();
  protected boolean c;
  protected Object d = new Object();
  private List<QbarNative.QBarCodeDetectInfo> e = new ArrayList();
  
  public a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    this.a = localStringBuilder.toString();
  }
  
  private List<QBar.QBarResult> b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<QbarNative.QBarPoint> paramList, List<QbarNative.QBarReportMsg> paramList1)
  {
    long l = System.currentTimeMillis();
    paramInt1 = this.b.scanImage(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 < 0)
    {
      paramArrayOfByte = this.a;
      paramList = new StringBuilder();
      paramList.append("scanImage result ");
      paramList.append(paramInt1);
      o.b(paramArrayOfByte, paramList.toString());
      return null;
    }
    paramArrayOfByte = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    this.b.GetResults(3, paramArrayOfByte, null, paramList1);
    this.b.GetCodeDetectInfo(3, this.e, localArrayList);
    if (paramList != null) {
      paramList.addAll(localArrayList);
    }
    if (paramArrayOfByte.size() == 0) {
      o.b(this.a, String.format("get no results ,cost %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    }
    o.d(this.a, String.format("get %d results ,cost %dms", new Object[] { Integer.valueOf(paramArrayOfByte.size()), Long.valueOf(System.currentTimeMillis() - l) }));
    return paramArrayOfByte;
  }
  
  public int a(int[] paramArrayOfInt)
  {
    int j = 0;
    if (paramArrayOfInt != null)
    {
      int[] arrayOfInt2 = new int[paramArrayOfInt.length];
      int k = paramArrayOfInt.length;
      int i = 0;
      for (;;)
      {
        arrayOfInt1 = arrayOfInt2;
        if (j >= k) {
          break;
        }
        arrayOfInt2[i] = paramArrayOfInt[j];
        j += 1;
        i += 1;
      }
    }
    int[] arrayOfInt1 = new int[5];
    arrayOfInt1[0] = 2;
    arrayOfInt1[1] = 1;
    arrayOfInt1[2] = 4;
    arrayOfInt1[3] = 5;
    return this.b.setReaders(arrayOfInt1, arrayOfInt1.length);
  }
  
  public List<QBar.QBarResult> a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<QbarNative.QBarPoint> paramList, List<QbarNative.QBarReportMsg> paramList1)
  {
    synchronized (this.d)
    {
      paramArrayOfByte = b(paramArrayOfByte, paramInt1, paramInt2, paramList, paramList1);
      return paramArrayOfByte;
    }
  }
  
  public List<QBar.QBarResult> a(int[] paramArrayOfInt, Point paramPoint, List<QbarNative.QBarReportMsg> paramList)
  {
    o.d(this.a, String.format("decode, size %s", new Object[] { paramPoint.toString() }));
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      byte[] arrayOfByte = new byte[paramPoint.x * paramPoint.y];
      int i = QBarImageUtil.TransBytes(paramArrayOfInt, arrayOfByte, paramPoint.x, paramPoint.y);
      if (i != 0)
      {
        paramArrayOfInt = this.a;
        paramPoint = new StringBuilder();
        paramPoint.append("rotate result ");
        paramPoint.append(i);
        o.b(paramArrayOfInt, paramPoint.toString());
        return null;
      }
      return b(arrayOfByte, paramPoint.x, paramPoint.y, null, paramList);
    }
    o.c(this.a, "prepareGrayData , data is null");
    return null;
  }
  
  public void a(int paramInt, QbarNative.QbarAiModelParam paramQbarAiModelParam)
  {
    if (this.c) {
      return;
    }
    try
    {
      synchronized (this.d)
      {
        paramInt = this.b.init(1, paramInt, "ANY", "UTF-8", paramQbarAiModelParam);
        if (paramInt != 0)
        {
          paramQbarAiModelParam = this.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("init qbar error, ");
          localStringBuilder.append(paramInt);
          o.d(paramQbarAiModelParam, localStringBuilder.toString());
          return;
        }
        this.c = true;
        o.d(this.a, "init qbar success");
        return;
      }
      return;
    }
    catch (Exception paramQbarAiModelParam)
    {
      paramQbarAiModelParam.printStackTrace();
    }
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public byte[] a(byte[] paramArrayOfByte, Point paramPoint, int paramInt, Rect arg4, int[] paramArrayOfInt)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      o.d(this.a, String.format("cropGrayData, size %s, rect %s, rotation %d", new Object[] { paramPoint, ???, Integer.valueOf(paramInt) }));
      int i;
      if (??? != null) {
        i = ???.width();
      } else {
        i = paramPoint.x;
      }
      int j;
      if (??? != null) {
        j = ???.height();
      } else {
        j = paramPoint.y;
      }
      int k;
      if (??? != null) {
        k = ???.left;
      } else {
        k = 0;
      }
      int m;
      if (??? != null) {
        m = ???.top;
      } else {
        m = 0;
      }
      byte[] arrayOfByte = new byte[i * j * 3 / 2];
      synchronized (this.d)
      {
        paramInt = QBarImageUtil.gray_rotate_crop_sub(arrayOfByte, paramArrayOfInt, paramArrayOfByte, paramPoint.x, paramPoint.y, k, m, i, j, paramInt, 0);
        if (paramInt != 0)
        {
          paramArrayOfByte = this.a;
          paramPoint = new StringBuilder();
          paramPoint.append("rotate result ");
          paramPoint.append(paramInt);
          o.b(paramArrayOfByte, paramPoint.toString());
          return null;
        }
        return arrayOfByte;
      }
    }
    o.c(this.a, "prepareGrayData , data is null");
    return null;
  }
  
  public QbarNative.QBarZoomInfo b()
  {
    return this.b.GetZoomInfo();
  }
  
  public void c()
  {
    synchronized (this.d)
    {
      this.c = false;
      if (this.b != null) {
        this.b.release();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.qbar.a
 * JD-Core Version:    0.7.0.1
 */