package com.tencent.aelight.camera.aeeditor.module.music;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AEEditorMusicPanel
  extends FrameLayout
  implements View.OnClickListener, AEEditorMusicAdapter.ClickCallback
{
  private final LinearLayout a;
  private final CheckedTextView b;
  private final TextView c;
  private final LinearLayout d;
  private final CheckedTextView e;
  private final TextView f;
  private final CheckedTextView g;
  private final CheckedTextView h;
  private RecyclerView i;
  private LinearLayoutManager j;
  private AEEditorMusicAdapter k;
  private float l = 0.8F;
  private int m = 1;
  private boolean n = true;
  private boolean o = true;
  private boolean p = true;
  private AEEditorMusicPanel.OperationCallback q;
  private boolean r;
  private boolean s = true;
  private boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private boolean x = true;
  
  public AEEditorMusicPanel(@NonNull Context paramContext)
  {
    super(paramContext);
    View localView = LayoutInflater.from(paramContext).inflate(2064056431, this);
    this.a = ((LinearLayout)localView.findViewById(2063991233));
    this.b = ((CheckedTextView)localView.findViewById(2063991000));
    this.c = ((TextView)localView.findViewById(2063991545));
    this.d = ((LinearLayout)localView.findViewById(2063991234));
    this.e = ((CheckedTextView)localView.findViewById(2063991001));
    this.f = ((TextView)localView.findViewById(2063991546));
    this.g = ((CheckedTextView)localView.findViewById(2063991004));
    this.h = ((CheckedTextView)localView.findViewById(2063991003));
    this.i = ((RecyclerView)localView.findViewById(2063991405));
    localView.findViewById(2063991235).setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.d.setOnClickListener(this);
    setMusicCutEnable(false);
    this.j = new LinearLayoutManager(paramContext, 0, false);
    this.k = new AEEditorMusicAdapter(paramContext, this);
    this.i.setLayoutManager(this.j);
    this.i.setAdapter(this.k);
    this.k.a(AEEditorMusicAdapter.AEEditorMusicInfo.a);
    f();
  }
  
  private void a(boolean paramBoolean)
  {
    List localList = this.k.a();
    if (paramBoolean)
    {
      if (!localList.contains(AEEditorMusicAdapter.AEEditorMusicInfo.b)) {
        localList.add(1, AEEditorMusicAdapter.AEEditorMusicInfo.b);
      }
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        ((AEEditorMusicAdapter.AEEditorMusicInfo)localIterator.next()).c = false;
      }
      AEEditorMusicAdapter.AEEditorMusicInfo.b.c = true;
    }
    else
    {
      localList.remove(AEEditorMusicAdapter.AEEditorMusicInfo.b);
    }
    this.k.a(localList);
    this.k.notifyDataSetChanged();
  }
  
  private int b(int paramInt)
  {
    int i1 = this.k.getItemCount();
    if (paramInt < 0) {
      return 0;
    }
    i1 -= 1;
    if (paramInt > i1) {
      return i1;
    }
    return paramInt;
  }
  
  private void f()
  {
    AEEditorMusicPanel.1 local1 = new AEEditorMusicPanel.1(this);
    this.g.setOnClickListener(local1);
    this.h.setOnClickListener(local1);
  }
  
  private void g()
  {
    setMusicLyricEnable(true);
    this.e.setChecked(true);
    AEEditorMusicPanel.OperationCallback localOperationCallback = this.q;
    if (localOperationCallback != null) {
      localOperationCallback.h(true);
    }
    this.n = false;
  }
  
  private void h()
  {
    setMusicLyricEnable(true);
    this.e.setChecked(false);
    AEEditorMusicPanel.OperationCallback localOperationCallback = this.q;
    if (localOperationCallback != null) {
      localOperationCallback.h(false);
    }
    this.n = true;
  }
  
  private void i()
  {
    setMusicLyricEnable(false);
    AEEditorMusicPanel.OperationCallback localOperationCallback = this.q;
    if (localOperationCallback != null) {
      localOperationCallback.h(false);
    }
  }
  
  private boolean j()
  {
    if (this.j != null)
    {
      AEEditorMusicAdapter localAEEditorMusicAdapter = this.k;
      if (localAEEditorMusicAdapter == null) {
        return false;
      }
      return localAEEditorMusicAdapter.getItemCount() != 0;
    }
    return false;
  }
  
  private void setMusicCutEnable(boolean paramBoolean)
  {
    this.a.setEnabled(paramBoolean);
    this.b.setEnabled(paramBoolean);
    this.c.setEnabled(paramBoolean);
  }
  
  private void setMusicLyricEnable(boolean paramBoolean)
  {
    this.d.setEnabled(paramBoolean);
    this.e.setEnabled(paramBoolean);
    this.f.setEnabled(paramBoolean);
  }
  
  public void a()
  {
    c();
  }
  
  public void a(float paramFloat)
  {
    if ((!this.g.isChecked()) && (paramFloat > 0.0F))
    {
      this.g.setChecked(true);
      this.h.setChecked(true);
      return;
    }
    if ((this.g.isChecked()) && (paramFloat == 0.0F))
    {
      this.g.setChecked(false);
      this.h.setChecked(false);
    }
  }
  
  public void a(int paramInt)
  {
    if (!j()) {
      return;
    }
    paramInt = b(paramInt);
    this.j.scrollToPosition(paramInt);
  }
  
  public void a(@NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo)
  {
    a(paramAEEditorMusicInfo, 1, true, 2);
  }
  
  public void a(@Nullable AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      paramAEEditorMusicInfo = this.q;
      if (paramAEEditorMusicInfo != null) {
        paramAEEditorMusicInfo.aa();
      }
      return;
    }
    if (!paramBoolean)
    {
      setEnableBgm(false);
      this.o = true;
      i();
      return;
    }
    this.v = true;
    AEEditorMusicPanel.OperationCallback localOperationCallback = this.q;
    if (localOperationCallback != null) {
      localOperationCallback.a(paramAEEditorMusicInfo, paramInt1);
    }
  }
  
  public void a(@NonNull List<AEEditorMusicAdapter.AEEditorMusicInfo> paramList)
  {
    AEEditorMusicAdapter localAEEditorMusicAdapter = this.k;
    if (localAEEditorMusicAdapter != null) {
      localAEEditorMusicAdapter.a(paramList);
    }
    if ((!CollectionUtils.isEmpty(paramList)) && (!this.u))
    {
      this.u = true;
      if (!this.s) {
        setEnableBgm(true);
      }
    }
  }
  
  public void b()
  {
    if (this.r) {
      return;
    }
    AEEditorMusicPanel.OperationCallback localOperationCallback = this.q;
    if (localOperationCallback != null) {
      localOperationCallback.ae();
    }
  }
  
  public void b(float paramFloat)
  {
    this.l = paramFloat;
  }
  
  public void c()
  {
    if (this.s)
    {
      this.s = false;
      if (this.u) {
        setEnableBgm(true);
      }
      if (!this.o)
      {
        int i1 = this.m;
        if (i1 == 1)
        {
          h();
          return;
        }
        if (i1 == 0)
        {
          h();
          g();
        }
      }
      else
      {
        i();
      }
    }
    else
    {
      AEEditorMusicAdapter localAEEditorMusicAdapter = this.k;
      if (localAEEditorMusicAdapter != null) {
        localAEEditorMusicAdapter.b();
      }
    }
  }
  
  public void d()
  {
    int i1 = this.m;
    if (i1 == 0)
    {
      this.m = 1;
      h();
      AEBaseReportParam.a().n().A = 0;
    }
    else if (i1 == 1)
    {
      this.m = 0;
      g();
      AEBaseReportParam.a().n().A = 1;
    }
    AEBaseDataReporter.a().v();
  }
  
  public void e()
  {
    AEEditorMusicAdapter localAEEditorMusicAdapter = this.k;
    if (localAEEditorMusicAdapter != null) {
      localAEEditorMusicAdapter.c();
    }
  }
  
  @NonNull
  public List<AEEditorMusicAdapter.AEEditorMusicInfo> getBackgroundMusicData()
  {
    AEEditorMusicAdapter localAEEditorMusicAdapter = this.k;
    if (localAEEditorMusicAdapter != null) {
      return localAEEditorMusicAdapter.a();
    }
    return new LinkedList();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2063991235)
    {
      paramView = this.q;
      if (paramView != null) {
        paramView.ad();
      }
      AEReportUtils.a(5);
      return;
    }
    if (i1 == 2063991234)
    {
      if (!this.o)
      {
        d();
        AEReportUtils.a(10);
      }
    }
    else if (i1 == 2063991233)
    {
      paramView = this.q;
      if (paramView != null) {
        paramView.g(this.w);
      }
      AEReportUtils.a(8);
    }
  }
  
  public void setAutoTemplate(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.g.setChecked(paramBoolean1 ^ true);
    this.h.setChecked(paramBoolean1 ^ true);
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      this.k.d();
      setMusicCutEnable(false);
      setMusicLyricEnable(false);
    }
    a(paramBoolean2);
  }
  
  public void setBgmPlayed(boolean paramBoolean, AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo)
  {
    this.w = paramBoolean;
    if (this.x) {
      this.x = false;
    }
    if ((paramBoolean) && ((paramAEEditorMusicInfo == null) || (paramAEEditorMusicInfo.f != 3)))
    {
      setMusicCutEnable(true);
      int i1 = this.m;
      if (i1 == 1)
      {
        h();
      }
      else if (i1 == 0)
      {
        h();
        g();
      }
      this.o = false;
      return;
    }
    setMusicCutEnable(false);
    this.o = true;
    i();
  }
  
  public void setEnableBgm(boolean paramBoolean)
  {
    this.v = paramBoolean;
    AEEditorMusicPanel.OperationCallback localOperationCallback = this.q;
    if (localOperationCallback != null) {
      localOperationCallback.e(this.v);
    }
  }
  
  public void setOperationCallback(@Nullable AEEditorMusicPanel.OperationCallback paramOperationCallback)
  {
    this.q = paramOperationCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicPanel
 * JD-Core Version:    0.7.0.1
 */