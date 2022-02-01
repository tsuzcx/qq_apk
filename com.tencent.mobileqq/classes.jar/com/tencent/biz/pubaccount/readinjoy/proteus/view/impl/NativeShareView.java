package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

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
import anzj;
import bhtq;
import bljm;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qeb;
import qec;
import qed;
import ubv;

public class NativeShareView
  extends LinearLayout
  implements IView
{
  private Context jdField_a_of_type_AndroidContentContext;
  protected bljm a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  public NativeShareView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Bljm = new qec(this);
    a(paramContext);
  }
  
  public NativeShareView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Bljm = new qec(this);
    a(paramContext);
  }
  
  public NativeShareView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Bljm = new qec(this);
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
    Object localObject1 = inflate(getContext(), 2131560152, this);
    int j = bhtq.b(44.0F);
    localObject1 = (GridView)((View)localObject1).findViewById(2131367683);
    List localList = a(paramContext)[0];
    Object localObject2 = new TextPaint();
    ((TextPaint)localObject2).setTextSize(paramContext.getResources().getDimensionPixelSize(2131298939));
    new StaticLayout(a(a(localList), 6), (TextPaint)localObject2, j, Layout.Alignment.ALIGN_CENTER, 1.0F, 0, true);
    localObject2 = localList.iterator();
    int i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject2).next()).visibility != 0) {
        break label267;
      }
      i += 1;
    }
    label267:
    for (;;)
    {
      break;
      int k = bhtq.b(14.0F);
      j = k + (k + j);
      ((GridView)localObject1).setColumnWidth(j);
      ((GridView)localObject1).setNumColumns(i);
      localObject2 = ((GridView)localObject1).getLayoutParams();
      ((GridView)localObject1).setPadding(16, ((GridView)localObject1).getPaddingTop(), 16, ((GridView)localObject1).getPaddingBottom());
      ((ViewGroup.LayoutParams)localObject2).width = (j * i + 0 + 0);
      ((GridView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((GridView)localObject1).setAdapter(new qed(paramContext, localList));
      ((GridView)localObject1).setSelector(new ColorDrawable(0));
      ((GridView)localObject1).setOnItemClickListener(this.jdField_a_of_type_Bljm);
      ((GridView)localObject1).setOnTouchListener(new qeb(this));
      ubv.a();
      return;
    }
  }
  
  protected String a(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    Object localObject = "";
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((ShareActionSheetBuilder.ActionSheetItem)paramList.get(i)).label;
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
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = anzj.a(2131705964);
    localActionSheetItem.icon = 2130842787;
    localActionSheetItem.iconNeedBg = false;
    localActionSheetItem.action = 47;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131695738);
    localActionSheetItem.icon = 2130842789;
    localActionSheetItem.iconNeedBg = false;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131695751);
    localActionSheetItem.icon = 2130842790;
    localActionSheetItem.iconNeedBg = false;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131695758);
    localActionSheetItem.icon = 2130842791;
    localActionSheetItem.iconNeedBg = false;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131695741);
    localActionSheetItem.icon = 2130842788;
    localActionSheetItem.iconNeedBg = false;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
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
    ubv.b();
  }
  
  public void setCurrentPath(String paramString)
  {
    ubv.a(paramString);
  }
  
  public void setInitRunnable(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public void setScreenBitmap(Bitmap paramBitmap)
  {
    ubv.a(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeShareView
 * JD-Core Version:    0.7.0.1
 */