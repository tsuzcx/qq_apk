package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.etrump.mixlayout.api.IETDecoration;
import com.etrump.mixlayout.api.IETEngine;
import com.etrump.mixlayout.api.IETFont;
import com.etrump.mixlayout.api.IETSegment;
import com.tencent.biz.qcircleshadow.lib.QCircleHostFontHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class ETTextLayout
{
  ArrayList<TextCellLayout.MeasuredLine> a;
  private Rect b = new Rect(1000, 1000, 0, 0);
  private Rect c = new Rect(1000, 1000, 0, 0);
  private int d;
  private int e;
  private int f;
  private int g;
  private String h;
  private Point i;
  private int j;
  private int k;
  private boolean l;
  private boolean m;
  private IETFont n;
  private Point[] o;
  private Object[] p;
  private int q = 0;
  
  private static int a(char paramChar1, char paramChar2)
  {
    return (paramChar1 << '\n') + paramChar2 - 56613888;
  }
  
  private void a(Rect paramRect1, Rect paramRect2)
  {
    if (paramRect2.left < paramRect1.left) {
      paramRect1.left = paramRect2.left;
    }
    if (paramRect2.top < paramRect1.top) {
      paramRect1.top = paramRect2.top;
    }
    if (paramRect2.right > paramRect1.right) {
      paramRect1.right = paramRect2.right;
    }
    if (paramRect2.bottom > paramRect1.bottom) {
      paramRect1.bottom = paramRect2.bottom;
    }
  }
  
  private IETSegment[] b(ArrayList<TextCellLayout.MeasuredLine> paramArrayList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    this.q = paramArrayList.size();
    paramArrayList = paramArrayList.iterator();
    int i1 = 0;
    int i5 = 0;
    int i4 = 0;
    int i2 = 0;
    while (paramArrayList.hasNext())
    {
      Object localObject1 = (TextCellLayout.MeasuredLine)paramArrayList.next();
      int i6 = ((TextCellLayout.MeasuredLine)localObject1).c();
      if (i6 != 0)
      {
        Rect localRect = new Rect(1000, 1000, 0, 0);
        int i7 = 0;
        int i8 = 0;
        int i3 = i1;
        while (i8 < i6)
        {
          Object localObject3 = ((TextCellLayout.MeasuredLine)localObject1).a(i8);
          Object localObject4 = ((TextCellLayout.MeasuredLine)localObject1).b(i8);
          if ((!this.m) && ((((TextCell)localObject3).type == 3) || (((TextCell)localObject3).type == 9)) && (((TextCell)localObject3).useDefaultFont)) {
            i1 = 0;
          } else {
            i1 = 1;
          }
          int i9 = ((Rect)localObject4).top - i5;
          if (i1 != 0)
          {
            a(localRect, (Rect)localObject4);
            localObject2 = QCircleHostFontHelper.createETSegment();
            ((IETSegment)localObject2).setType(0);
            ((IETSegment)localObject2).setCodePoint(-1);
            ((IETSegment)localObject2).setTextOffset(0);
            ((IETSegment)localObject2).setTextLength(0);
            ((IETSegment)localObject2).setLineNum(0);
            ((IETSegment)localObject2).setTextSize(0);
            ((IETSegment)localObject2).setX(0);
            ((IETSegment)localObject2).setY(0);
            if ((localObject3 instanceof EmoCell))
            {
              ((IETSegment)localObject2).setType(2);
              ((IETSegment)localObject2).setCodePoint(i3);
              ((IETSegment)localObject2).setY(i9 + i5);
              localObject4 = (EmoCell)localObject3;
              i1 = (int)((EmoCell)localObject4).getWidth(null);
              localArrayList2.add(QCircleHostFontHelper.createETImageSpan(((EmoCell)localObject4).getEmoDrawable()));
              i3 += 1;
            }
            else if ((localObject3 instanceof SystemEmoCell))
            {
              if (((TextCell)localObject3).getText().length() > 1) {
                ((IETSegment)localObject2).setCodePoint(a(((TextCell)localObject3).getText().charAt(0), ((TextCell)localObject3).getText().charAt(1)));
              } else {
                ((IETSegment)localObject2).setCodePoint(((TextCell)localObject3).getText().charAt(0));
              }
              ((IETSegment)localObject2).setType(1);
              ((IETSegment)localObject2).setY(i9 + i5);
              i1 = (int)((SystemEmoCell)localObject3).getWidth(null);
            }
            else
            {
              String str = ((TextCell)localObject3).getText();
              if (str != null)
              {
                ((IETSegment)localObject2).setTextLength(str.length());
                ((IETSegment)localObject2).setTextOffset(i2);
                ((IETSegment)localObject2).setType(0);
                i2 += str.length();
                ((IETSegment)localObject2).setY(i9 + i5 - 0);
                i1 = ((Rect)localObject4).width();
              }
              else
              {
                i1 = 0;
              }
            }
            ((IETSegment)localObject2).setX(i7);
            int i10 = (int)((TextCell)localObject3).fontSize;
            i9 = i10;
            if (((TextCell)localObject3).useSuperFont)
            {
              localObject3 = this.n;
              i9 = i10;
              if (localObject3 != null) {
                i9 = ((IETFont)localObject3).getSize();
              }
            }
            ((IETSegment)localObject2).setTextSize(i9);
            ((IETSegment)localObject2).setLineNum(i4);
            localArrayList3.add(localObject2);
          }
          else
          {
            if ((localObject3 instanceof EmoCell)) {}
            for (float f1 = ((EmoCell)localObject3).getWidth(null);; f1 = ((SystemEmoCell)localObject3).getWidth(null))
            {
              i1 = (int)f1;
              break label654;
              if (!(localObject3 instanceof SystemEmoCell)) {
                break;
              }
            }
            i1 = ((Rect)localObject4).width();
          }
          label654:
          i7 += i1;
          i8 += 1;
        }
        localObject1 = new Point(0, 0);
        Object localObject2 = new Point(0, 0);
        ((Point)localObject1).x = localRect.left;
        ((Point)localObject1).y = localRect.top;
        localArrayList1.add(localObject1);
        ((Point)localObject2).x = localRect.right;
        ((Point)localObject2).y = localRect.bottom;
        localArrayList1.add(localObject2);
        i5 += localRect.height();
        i4 += 1;
        i1 = i3;
      }
    }
    this.p = localArrayList2.toArray();
    this.o = ((Point[])localArrayList1.toArray(new Point[localArrayList1.size()]));
    return (IETSegment[])localArrayList3.toArray(new IETSegment[localArrayList3.size()]);
  }
  
  public IETDecoration a(IETEngine paramIETEngine, boolean paramBoolean)
  {
    IETSegment[] arrayOfIETSegment = b(this.a);
    return QCircleHostFontHelper.createDecorationSpace(paramIETEngine, this.h, this.d, this.e, this.i, this.j, this.o, this.q, arrayOfIETSegment, this.p, this.l, this.k, this.m, this.n, paramBoolean);
  }
  
  public IETFont a()
  {
    return this.n;
  }
  
  public String a(ArrayList<TextCellLayout.MeasuredLine> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i3 = paramArrayList.size();
      int i1 = 0;
      while (i1 < i3)
      {
        TextCellLayout.MeasuredLine localMeasuredLine = (TextCellLayout.MeasuredLine)paramArrayList.get(i1);
        int i4 = localMeasuredLine.c();
        int i2 = 0;
        while (i2 < i4)
        {
          localStringBuilder.append(localMeasuredLine.a(i2).getText());
          i2 += 1;
        }
        i1 += 1;
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public void a(IETEngine paramIETEngine, Bitmap paramBitmap, IETDecoration paramIETDecoration, boolean paramBoolean)
  {
    if (paramIETEngine != null)
    {
      if (paramBitmap == null) {
        return;
      }
      if (this.d > 0)
      {
        if (this.e <= 0) {
          return;
        }
        if (paramIETDecoration != null)
        {
          int i1 = 0;
          if (paramBoolean)
          {
            paramIETDecoration.drawSceneSpace(paramBitmap, 0, 0, this.n);
            return;
          }
          paramIETEngine = paramIETDecoration.getMargins();
          int i2;
          if (paramIETEngine != null)
          {
            i1 = paramIETEngine.left;
            i2 = 0 + paramIETEngine.top;
            i1 += 0;
          }
          else
          {
            i2 = 0;
          }
          paramIETDecoration.drawBackgroundSpace(paramBitmap, this.n, i1, i2);
        }
      }
    }
  }
  
  public boolean a(ArrayList<TextCellLayout.MeasuredLine> paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, IETFont paramIETFont)
  {
    Object localObject = this.a;
    if ((localObject != null) && (a((ArrayList)localObject).equals(a(paramArrayList))))
    {
      localObject = this.n;
      if ((localObject != null) && (((IETFont)localObject).equals(paramIETFont)) && (paramInt4 == this.k) && (paramInt3 == this.j) && (paramBoolean1 == this.l)) {
        return false;
      }
    }
    this.f = 0;
    this.g = 0;
    this.n = paramIETFont;
    this.d = paramInt1;
    this.e = paramInt2;
    this.k = paramInt4;
    this.l = paramBoolean1;
    this.m = paramBoolean2;
    this.j = paramInt3;
    paramIETFont = new StringBuilder();
    this.a = new ArrayList();
    TextCellLayout.MeasuredLine localMeasuredLine;
    TextCell localTextCell;
    Rect localRect;
    if (paramBoolean2)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (TextCellLayout.MeasuredLine)paramArrayList.next();
        localMeasuredLine = new TextCellLayout.MeasuredLine();
        paramInt2 = ((TextCellLayout.MeasuredLine)localObject).c();
        if (paramInt2 != 0)
        {
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            localTextCell = ((TextCellLayout.MeasuredLine)localObject).a(paramInt1);
            localRect = ((TextCellLayout.MeasuredLine)localObject).b(paramInt1);
            localMeasuredLine.a(localTextCell, localRect);
            a(this.b, localRect);
            if ((!(localTextCell instanceof EmoCell)) && (!(localTextCell instanceof SystemEmoCell))) {
              paramIETFont.append(localTextCell.getText());
            }
            paramInt1 += 1;
          }
          this.a.add(localMeasuredLine);
        }
      }
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject = (TextCellLayout.MeasuredLine)paramArrayList.next();
      localMeasuredLine = new TextCellLayout.MeasuredLine();
      paramInt2 = ((TextCellLayout.MeasuredLine)localObject).c();
      if (paramInt2 != 0)
      {
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          localTextCell = ((TextCellLayout.MeasuredLine)localObject).a(paramInt1);
          localRect = ((TextCellLayout.MeasuredLine)localObject).b(paramInt1);
          if (((localTextCell.type == 3) || (localTextCell.type == 9)) && (localTextCell.useDefaultFont))
          {
            a(this.c, localRect);
          }
          else
          {
            a(this.b, localRect);
            if ((!(localTextCell instanceof EmoCell)) && (!(localTextCell instanceof SystemEmoCell))) {
              paramIETFont.append(localTextCell.getText());
            }
          }
          localMeasuredLine.a(localTextCell, localRect);
          paramInt1 += 1;
        }
        this.a.add(localMeasuredLine);
      }
    }
    if (this.a.size() == 1)
    {
      this.f = this.c.right;
      this.d = this.b.width();
      if (this.e > this.b.height()) {
        paramInt1 = this.e;
      } else {
        paramInt1 = this.b.height();
      }
      this.e = paramInt1;
      this.j = this.d;
    }
    this.h = paramIETFont.toString();
    this.i = new Point(this.f, this.g);
    return true;
  }
  
  public Rect b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public int e()
  {
    return this.f;
  }
  
  public int f()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.ETTextLayout
 * JD-Core Version:    0.7.0.1
 */