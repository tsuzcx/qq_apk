package com.tencent.mobileqq.ar.view;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.education.request.api.IStudyRuntimeService;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class ScanEntryProviderViewBuilder
{
  public boolean a = true;
  public boolean b = true;
  public boolean c = true;
  public boolean d = true;
  private int e;
  private final int[] f = { 2131442818, 2131439514, 2131428685, 2131445410 };
  private final String[] g = { HardCodeUtil.a(2131910983), HardCodeUtil.a(2131915909), "AR", HardCodeUtil.a(2131888846) };
  private final int[] h = { 2130846310, 2130846311, 2130846312, 2130846313, 2130846314, 2130846315, 2130846316, 2130846317 };
  private final int[] i = { 2130846285, 2130846286, 2130846287, 2130846288, 2130846289, 2130846290, 2130846291, 2130846292 };
  private final int[] j = { 2130846302, 2130846303, 2130846304, 2130846305, 2130846306, 2130846307, 2130846308, 2130846309 };
  private final int[] k = { 2130852686, 2130852687, 2130852688, 2130852689, 2130852690, 2130852691, 2130852692, 2130852693 };
  private ArrayList<ScanEntryProviderViewBuilder.ScanEntryProviderViewItem> l = new ArrayList();
  private int m = 0;
  
  public ScanEntryProviderViewBuilder(int paramInt)
  {
    this.e = paramInt;
  }
  
  public ScanEntryProviderView a(int paramInt, Context paramContext, ScanEntryContainerViewListener paramScanEntryContainerViewListener)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return null;
          }
          return new ProblemScanEntryView(paramContext, paramScanEntryContainerViewListener);
        }
        return new ARScanEntryView(paramContext, paramScanEntryContainerViewListener);
      }
      return new OCRScanEntryView(paramContext, paramScanEntryContainerViewListener);
    }
    return new QRScanEntryView(paramContext, paramScanEntryContainerViewListener);
  }
  
  public void a()
  {
    if (this.e == 1)
    {
      if (this.a) {
        this.l.add(new ScanEntryProviderViewBuilder.ScanEntryProviderViewItem(1, HardCodeUtil.a(2131910984)));
      }
      if (this.c) {
        this.l.add(new ScanEntryProviderViewBuilder.ScanEntryProviderViewItem(2, "OCR"));
      }
      if (this.b) {
        this.l.add(new ScanEntryProviderViewBuilder.ScanEntryProviderViewItem(3, "AR"));
      }
      if ((this.d) && (this.m == 1) && (((IStudyRuntimeService)BaseApplicationImpl.sApplication.getRuntime().getRuntimeService(IStudyRuntimeService.class, "all")).getScanAnswerSearchSwitch())) {
        this.l.add(new ScanEntryProviderViewBuilder.ScanEntryProviderViewItem(4, HardCodeUtil.a(2131888846)));
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.m = paramInt;
  }
  
  public ScanEntryProviderViewBuilder.ScanEntryProviderViewItem b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < e())) {
      return (ScanEntryProviderViewBuilder.ScanEntryProviderViewItem)this.l.get(paramInt);
    }
    return null;
  }
  
  public int[] b()
  {
    return this.f;
  }
  
  public int[] c(int paramInt)
  {
    if (paramInt == 0) {
      return this.h;
    }
    if (paramInt == 1) {
      return this.j;
    }
    if (paramInt == 2) {
      return this.i;
    }
    if (paramInt == 3) {
      return this.k;
    }
    return null;
  }
  
  public String[] c()
  {
    return this.g;
  }
  
  public int d()
  {
    return this.h.length;
  }
  
  public int d(int paramInt)
  {
    if (paramInt == 1) {
      return 0;
    }
    if (paramInt == 2) {
      return 1;
    }
    if (paramInt == 3) {
      return 2;
    }
    return 3;
  }
  
  public int e()
  {
    return this.l.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderViewBuilder
 * JD-Core Version:    0.7.0.1
 */