package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.util.ArrayList;
import java.util.List;

public class AEEditorClipPanel
  extends FrameLayout
  implements View.OnClickListener
{
  private AEEditorClipContainer a;
  private ImageView b;
  private ImageView c;
  private AEEditorClipRatioButton d;
  private AEEditorClipRatioButton e;
  private AEEditorClipRatioButton f;
  private AEEditorClipRatioButton g;
  private AEEditorClipRatioButton h;
  private List<AEEditorImageInfo> i;
  private int j;
  private AEEditorClipPanel.CropChangeCallback k;
  private int l = 0;
  private int m = 0;
  
  public AEEditorClipPanel(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AEEditorClipPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AEEditorClipPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private float a(int paramInt1, int paramInt2, Rect paramRect)
  {
    float f1 = paramInt1;
    float f2 = paramInt2;
    if (f1 * 1.0F / f2 <= (paramRect.right - paramRect.left) * 1.0F / (paramRect.bottom - paramRect.top)) {
      return (paramRect.right - paramRect.left) * 1.0F / f1;
    }
    return (paramRect.bottom - paramRect.top) * 1.0F / f2;
  }
  
  public static CropConfig a(int paramInt1, int paramInt2)
  {
    float f4 = paramInt1;
    float f1 = 1.0F;
    float f5 = paramInt2;
    double d1 = f4 * 1.0F / f5;
    float f3 = 0.0F;
    float f2 = 0.0F;
    if (d1 <= 0.333333343267441D)
    {
      f4 /= 0.3333333F;
      f2 = (f5 - f4) * 1.0F / 2.0F / f5;
      f4 = f4 * 1.0F / f5;
    }
    else
    {
      if (d1 >= 1.777777791023254D)
      {
        f1 = f5 * 1.777778F;
        f2 = (f4 - f1) * 1.0F / 2.0F / f4;
        f1 = f1 * 1.0F / f4;
      }
      f4 = 1.0F;
      f5 = 0.0F;
      f3 = f2;
      f2 = f5;
    }
    return new CropConfig(f3, f2, f1, f4);
  }
  
  private void a(int paramInt)
  {
    c();
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return;
            }
            this.h.setChecked(true);
            return;
          }
          this.g.setChecked(true);
          return;
        }
        this.f.setChecked(true);
        return;
      }
      this.e.setChecked(true);
      return;
    }
    this.d.setChecked(true);
  }
  
  private void a(Context paramContext)
  {
    paramContext = View.inflate(paramContext, 2064056438, this);
    paramContext.setOnClickListener(this);
    this.a = ((AEEditorClipContainer)paramContext.findViewById(2063990864));
    this.b = ((ImageView)paramContext.findViewById(2063990990));
    this.b.setOnClickListener(this);
    this.c = ((ImageView)paramContext.findViewById(2063990991));
    this.c.setOnClickListener(this);
    this.d = ((AEEditorClipRatioButton)paramContext.findViewById(2063991046));
    this.d.setText(getResources().getString(2064187502));
    this.d.setOnClickListener(this);
    this.e = ((AEEditorClipRatioButton)paramContext.findViewById(2063991047));
    this.e.setText("1 : 1");
    this.e.setBackImg(2063925495);
    this.e.setOnClickListener(this);
    this.f = ((AEEditorClipRatioButton)paramContext.findViewById(2063991048));
    this.f.setText("3 : 4");
    this.f.setBackImg(2063925496);
    this.f.setOnClickListener(this);
    this.g = ((AEEditorClipRatioButton)paramContext.findViewById(2063991049));
    this.g.setText("4 : 3");
    this.g.setBackImg(2063925497);
    this.g.setOnClickListener(this);
    this.h = ((AEEditorClipRatioButton)paramContext.findViewById(2063991050));
    this.h.setText("16 : 9");
    this.h.setBackImg(2063925494);
    this.h.setOnClickListener(this);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    this.a.setImageBitmap(BitmapUtils.decodeSampledBitmapFromFileCheckExif(((AEEditorImageInfo)this.i.get(this.j)).a, 1440, 1440), (AEEditorImageInfo)this.i.get(this.j), paramInt1, paramInt2);
  }
  
  private void c()
  {
    this.d.setChecked(false);
    this.e.setChecked(false);
    this.f.setChecked(false);
    this.g.setChecked(false);
    this.h.setChecked(false);
  }
  
  public CropConfig a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if (paramInt3 == 0) {
        return a(paramInt1, paramInt2);
      }
      Rect localRect = this.a.c.getCropRect();
      if (localRect == null) {
        return a(paramInt1, paramInt2);
      }
      float f3 = a(paramInt1, paramInt2, localRect);
      float f1 = paramInt1 * f3;
      float f2 = (f1 - (localRect.right - localRect.left)) * 1.0F / 2.0F;
      f3 = paramInt2 * f3;
      float f4 = (f3 - (localRect.bottom - localRect.top)) * 1.0F / 2.0F;
      return new CropConfig(f2 / f1, f4 / f3, (localRect.right - localRect.left) * 1.0F / f1, (localRect.bottom - localRect.top) * 1.0F / f3);
    }
    return new CropConfig(0.0F, 0.0F, 1.0F, 1.0F);
  }
  
  public void a()
  {
    Object localObject1 = new float[9];
    this.a.b.getImageMatrix().getValues((float[])localObject1);
    Object localObject2 = new Matrix();
    ((Matrix)localObject2).setValues((float[])localObject1);
    ((AEEditorImageInfo)this.i.get(this.j)).a((Matrix)localObject2);
    ((AEEditorImageInfo)this.i.get(this.j)).a(this.m);
    ((AEEditorImageInfo)this.i.get(this.j)).a(this.a.getEditorPicInfo());
    localObject1 = this.k;
    if (localObject1 != null) {
      ((AEEditorClipPanel.CropChangeCallback)localObject1).a();
    }
    if (this.m != this.l)
    {
      localObject1 = new ArrayList();
      int n = 0;
      while (n < this.i.size())
      {
        if (n == this.j) {
          ((List)localObject1).add(((AEEditorImageInfo)this.i.get(n)).d);
        } else {
          ((List)localObject1).add(a(((AEEditorImageInfo)this.i.get(n)).b, ((AEEditorImageInfo)this.i.get(n)).c, this.m));
        }
        n += 1;
      }
      if (((List)localObject1).size() > 1)
      {
        localObject2 = this.k;
        if (localObject2 != null) {
          ((AEEditorClipPanel.CropChangeCallback)localObject2).a(this.m, (List)localObject1);
        }
      }
    }
  }
  
  public void a(List<AEEditorImageInfo> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a != null)
    {
      setVisibility(0);
      this.i = paramList;
      this.j = paramInt1;
      paramInt1 = ((AEEditorImageInfo)this.i.get(paramInt1)).b();
      this.l = paramInt1;
      this.m = paramInt1;
      a(this.l);
      b(paramInt2, paramInt3);
    }
  }
  
  public void b()
  {
    this.a.a();
  }
  
  public void onClick(View paramView)
  {
    int n = paramView.getId();
    switch (n)
    {
    default: 
      switch (n)
      {
      default: 
        return;
      case 2063991050: 
        this.m = 4;
        this.a.setRatioType(this.m);
        c();
        this.h.setChecked(true);
        AEReportUtils.b(1, AEEditorClipContainer.a(this.m));
        return;
      case 2063991049: 
        this.m = 3;
        this.a.setRatioType(this.m);
        c();
        this.g.setChecked(true);
        AEReportUtils.b(1, AEEditorClipContainer.a(this.m));
        return;
      case 2063991048: 
        this.m = 2;
        this.a.setRatioType(this.m);
        c();
        this.f.setChecked(true);
        AEReportUtils.b(1, AEEditorClipContainer.a(this.m));
        return;
      case 2063991047: 
        this.m = 1;
        this.a.setRatioType(this.m);
        c();
        this.e.setChecked(true);
        AEReportUtils.b(1, AEEditorClipContainer.a(this.m));
        return;
      }
      this.m = 0;
      this.a.setRatioType(this.m);
      c();
      this.d.setChecked(true);
      AEReportUtils.b(1, AEEditorClipContainer.a(this.m));
      return;
    case 2063990991: 
      a();
      AEReportUtils.b(3, AEEditorClipContainer.a(this.m));
      return;
    }
    paramView = this.k;
    if (paramView != null) {
      paramView.b();
    }
    AEReportUtils.b(2, AEEditorClipContainer.a(this.m));
  }
  
  public void setCropChangeCallBack(AEEditorClipPanel.CropChangeCallback paramCropChangeCallback)
  {
    this.k = paramCropChangeCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipPanel
 * JD-Core Version:    0.7.0.1
 */