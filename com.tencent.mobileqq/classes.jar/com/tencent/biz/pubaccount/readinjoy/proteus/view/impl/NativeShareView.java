package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import ajya;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import bbjs;
import bbll;
import bfpt;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pnf;
import png;
import pnh;
import sij;

public class NativeShareView
  extends LinearLayout
  implements IView
{
  private Context jdField_a_of_type_AndroidContentContext;
  protected bfpt a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  public NativeShareView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Bfpt = new png(this);
    a(paramContext);
  }
  
  public NativeShareView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Bfpt = new png(this);
    a(paramContext);
  }
  
  public NativeShareView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Bfpt = new png(this);
    a(paramContext);
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > paramInt) {
        str = paramString.substring(0, paramInt) + "\n" + paramString.substring(paramInt);
      }
    }
    return str;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    Object localObject1 = inflate(getContext(), 2131559899, this);
    int j = bbll.b(44.0F);
    localObject1 = (GridView)((View)localObject1).findViewById(2131367168);
    List localList = a(paramContext)[0];
    Object localObject2 = new TextPaint();
    ((TextPaint)localObject2).setTextSize(paramContext.getResources().getDimensionPixelSize(2131298815));
    new StaticLayout(a(a(localList), 6), (TextPaint)localObject2, j, Layout.Alignment.ALIGN_CENTER, 1.0F, 0, true);
    localObject2 = localList.iterator();
    int i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      if (((bbjs)((Iterator)localObject2).next()).d != 0) {
        break label267;
      }
      i += 1;
    }
    label267:
    for (;;)
    {
      break;
      int k = bbll.b(14.0F);
      j = k + (k + j);
      ((GridView)localObject1).setColumnWidth(j);
      ((GridView)localObject1).setNumColumns(i);
      localObject2 = ((GridView)localObject1).getLayoutParams();
      ((GridView)localObject1).setPadding(16, ((GridView)localObject1).getPaddingTop(), 16, ((GridView)localObject1).getPaddingBottom());
      ((ViewGroup.LayoutParams)localObject2).width = (j * i + 0 + 0);
      ((GridView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((GridView)localObject1).setAdapter(new pnh(paramContext, localList));
      ((GridView)localObject1).setSelector(new ColorDrawable(0));
      ((GridView)localObject1).setOnItemClickListener(this.jdField_a_of_type_Bfpt);
      ((GridView)localObject1).setOnTouchListener(new pnf(this));
      sij.a();
      return;
    }
  }
  
  protected String a(List<bbjs> paramList)
  {
    Object localObject = "";
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((bbjs)paramList.get(i)).a;
      if (str.length() <= ((String)localObject).length()) {
        break label54;
      }
      localObject = str;
    }
    label54:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  public List<bbjs>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    bbjs localbbjs = new bbjs();
    localbbjs.a = ajya.a(2131707082);
    localbbjs.jdField_b_of_type_Int = 2130842268;
    localbbjs.jdField_b_of_type_Boolean = false;
    localbbjs.c = 47;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    localbbjs = new bbjs();
    localbbjs.a = paramContext.getString(2131696696);
    localbbjs.jdField_b_of_type_Int = 2130842270;
    localbbjs.jdField_b_of_type_Boolean = false;
    localbbjs.c = 2;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    localbbjs = new bbjs();
    localbbjs.a = paramContext.getString(2131696709);
    localbbjs.jdField_b_of_type_Int = 2130842271;
    localbbjs.jdField_b_of_type_Boolean = false;
    localbbjs.c = 3;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    localbbjs = new bbjs();
    localbbjs.a = paramContext.getString(2131696716);
    localbbjs.jdField_b_of_type_Int = 2130842272;
    localbbjs.jdField_b_of_type_Boolean = false;
    localbbjs.c = 9;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    localbbjs = new bbjs();
    localbbjs.a = paramContext.getString(2131696699);
    localbbjs.jdField_b_of_type_Int = 2130842269;
    localbbjs.jdField_b_of_type_Boolean = false;
    localbbjs.c = 10;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    sij.b();
  }
  
  public void setCurrentPath(String paramString)
  {
    sij.a(paramString);
  }
  
  public void setInitRunnable(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public void setScreenBitmap(Bitmap paramBitmap)
  {
    sij.a(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeShareView
 * JD-Core Version:    0.7.0.1
 */