package com.tencent.aelight.camera.aeeditor.module.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.aelight.camera.aeeditor.module.filter.AdapterUtil;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class AEEditorColorSelectorView
  extends LinearLayout
  implements AEEditorColorAdapter.ColorClickListener
{
  public static final int a = Color.parseColor("#ff262626");
  private static final String[] b = { "#FFFFFFFF", "#FFF4675C", "#FFFFB143", "#FF79D397", "#FF9CC9FF", "#FF000000", "#FFFDA2B6", "#FFF8EB74", "#FF9AE3FF", "#FFD592FF" };
  private RecyclerView c;
  private AEEditorColorAdapter d;
  private final List<Integer> e = new ArrayList();
  private AEEditorColorAdapter.ColorClickListener f;
  
  public AEEditorColorSelectorView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEEditorColorSelectorView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEEditorColorSelectorView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(1);
    setGravity(16);
    a(LayoutInflater.from(paramContext).inflate(2064056507, this, true));
  }
  
  public static Drawable a(View paramView, boolean paramBoolean, int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    int i;
    if (paramBoolean) {
      i = 2063859820;
    } else {
      i = 2063859821;
    }
    int k = paramView.getResources().getDimensionPixelSize(2063859818);
    if (paramBoolean) {
      j = 0;
    } else {
      j = paramView.getResources().getDimensionPixelSize(2063859821);
    }
    int j = k - j;
    localGradientDrawable.setColor(paramInt);
    localGradientDrawable.setStroke(paramView.getResources().getDimensionPixelSize(i), -1);
    localGradientDrawable.setSize(j, j);
    localGradientDrawable.setShape(1);
    return localGradientDrawable;
  }
  
  private void a(View paramView)
  {
    String[] arrayOfString = b;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      this.e.add(Integer.valueOf(Color.parseColor(str)));
      i += 1;
    }
    this.c = ((RecyclerView)paramView.findViewById(2063990976));
    this.d = new AEEditorColorAdapter("adapter_fix", this.e, this);
    this.c.setAdapter(this.d);
    paramView = new LinearLayoutManager(getContext(), 0, false);
    this.c.setLayoutManager(paramView);
  }
  
  public void a(Integer paramInteger)
  {
    if (paramInteger != null)
    {
      i = 0;
      while (i < this.e.size())
      {
        if (paramInteger.equals(this.e.get(i)))
        {
          ThreadManager.getUIHandler().post(new AEEditorColorSelectorView.1(this, i));
          break label64;
        }
        i += 1;
      }
    }
    int i = -1;
    label64:
    this.d.a(i);
    this.d.notifyDataSetChanged();
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ("adapter_extract".equals(paramString1)) {
      this.d.a(-1);
    } else if (("adapter_fix".equals(paramString1)) && (paramInt2 >= 0)) {
      AdapterUtil.a(this.c, this.d.a(), paramInt2, true, true);
    }
    this.d.notifyDataSetChanged();
    AEEditorColorAdapter.ColorClickListener localColorClickListener = this.f;
    if (localColorClickListener != null) {
      localColorClickListener.a(paramString1, paramInt1, paramInt2, paramString2);
    }
  }
  
  public void setColorSelectedListener(AEEditorColorAdapter.ColorClickListener paramColorClickListener)
  {
    this.f = paramColorClickListener;
  }
  
  public void setMaterialId(String paramString)
  {
    AEEditorColorAdapter localAEEditorColorAdapter = this.d;
    if (localAEEditorColorAdapter != null) {
      localAEEditorColorAdapter.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorColorSelectorView
 * JD-Core Version:    0.7.0.1
 */