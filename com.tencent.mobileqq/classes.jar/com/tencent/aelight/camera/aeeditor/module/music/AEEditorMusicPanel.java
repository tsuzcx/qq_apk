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
  private float jdField_a_of_type_Float = 0.8F;
  private int jdField_a_of_type_Int = 1;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private final CheckedTextView jdField_a_of_type_AndroidWidgetCheckedTextView;
  private final LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private AEEditorMusicAdapter jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter;
  private AEEditorMusicPanel.OperationCallback jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel$OperationCallback;
  private boolean jdField_a_of_type_Boolean = true;
  private final CheckedTextView jdField_b_of_type_AndroidWidgetCheckedTextView;
  private final LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = true;
  private final CheckedTextView jdField_c_of_type_AndroidWidgetCheckedTextView;
  private boolean jdField_c_of_type_Boolean = true;
  private final CheckedTextView jdField_d_of_type_AndroidWidgetCheckedTextView;
  private boolean jdField_d_of_type_Boolean;
  private boolean e = true;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = true;
  
  public AEEditorMusicPanel(@NonNull Context paramContext)
  {
    super(paramContext);
    View localView = LayoutInflater.from(paramContext).inflate(2064318559, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2064122360));
    this.jdField_a_of_type_AndroidWidgetCheckedTextView = ((CheckedTextView)localView.findViewById(2064122086));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2064122770));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2064122361));
    this.jdField_b_of_type_AndroidWidgetCheckedTextView = ((CheckedTextView)localView.findViewById(2064122087));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2064122771));
    this.jdField_c_of_type_AndroidWidgetCheckedTextView = ((CheckedTextView)localView.findViewById(2064122090));
    this.jdField_d_of_type_AndroidWidgetCheckedTextView = ((CheckedTextView)localView.findViewById(2064122089));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2064122588));
    localView.findViewById(2064122362).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    b(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(paramContext, 0, false);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter = new AEEditorMusicAdapter(paramContext, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter.a(AEEditorMusicAdapter.AEEditorMusicInfo.jdField_a_of_type_JavaUtilList);
    f();
  }
  
  private int a(int paramInt)
  {
    int k = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter.getItemCount();
    if (paramInt < 0) {
      return 0;
    }
    k -= 1;
    if (paramInt > k) {
      return k;
    }
    return paramInt;
  }
  
  private void a(boolean paramBoolean)
  {
    List localList = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter.a();
    if (paramBoolean)
    {
      if (!localList.contains(AEEditorMusicAdapter.AEEditorMusicInfo.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo)) {
        localList.add(1, AEEditorMusicAdapter.AEEditorMusicInfo.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
      }
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        ((AEEditorMusicAdapter.AEEditorMusicInfo)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
      AEEditorMusicAdapter.AEEditorMusicInfo.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.jdField_a_of_type_Boolean = true;
    }
    else
    {
      localList.remove(AEEditorMusicAdapter.AEEditorMusicInfo.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter.a(localList);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter.notifyDataSetChanged();
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null)
    {
      AEEditorMusicAdapter localAEEditorMusicAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter;
      if (localAEEditorMusicAdapter == null) {
        return false;
      }
      return localAEEditorMusicAdapter.getItemCount() != 0;
    }
    return false;
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetCheckedTextView.setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setEnabled(paramBoolean);
    this.jdField_b_of_type_AndroidWidgetCheckedTextView.setEnabled(paramBoolean);
    this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
  }
  
  private void f()
  {
    AEEditorMusicPanel.1 local1 = new AEEditorMusicPanel.1(this);
    this.jdField_c_of_type_AndroidWidgetCheckedTextView.setOnClickListener(local1);
    this.jdField_d_of_type_AndroidWidgetCheckedTextView.setOnClickListener(local1);
  }
  
  private void g()
  {
    c(true);
    this.jdField_b_of_type_AndroidWidgetCheckedTextView.setChecked(true);
    AEEditorMusicPanel.OperationCallback localOperationCallback = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel$OperationCallback;
    if (localOperationCallback != null) {
      localOperationCallback.h(true);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void h()
  {
    c(true);
    this.jdField_b_of_type_AndroidWidgetCheckedTextView.setChecked(false);
    AEEditorMusicPanel.OperationCallback localOperationCallback = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel$OperationCallback;
    if (localOperationCallback != null) {
      localOperationCallback.h(false);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void i()
  {
    c(false);
    AEEditorMusicPanel.OperationCallback localOperationCallback = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel$OperationCallback;
    if (localOperationCallback != null) {
      localOperationCallback.h(false);
    }
  }
  
  @NonNull
  public List<AEEditorMusicAdapter.AEEditorMusicInfo> a()
  {
    AEEditorMusicAdapter localAEEditorMusicAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter;
    if (localAEEditorMusicAdapter != null) {
      return localAEEditorMusicAdapter.a();
    }
    return new LinkedList();
  }
  
  public void a()
  {
    c();
  }
  
  public void a(float paramFloat)
  {
    if ((!this.jdField_c_of_type_AndroidWidgetCheckedTextView.isChecked()) && (paramFloat > 0.0F))
    {
      this.jdField_c_of_type_AndroidWidgetCheckedTextView.setChecked(true);
      this.jdField_d_of_type_AndroidWidgetCheckedTextView.setChecked(true);
      return;
    }
    if ((this.jdField_c_of_type_AndroidWidgetCheckedTextView.isChecked()) && (paramFloat == 0.0F))
    {
      this.jdField_c_of_type_AndroidWidgetCheckedTextView.setChecked(false);
      this.jdField_d_of_type_AndroidWidgetCheckedTextView.setChecked(false);
    }
  }
  
  public void a(int paramInt)
  {
    if (!a()) {
      return;
    }
    paramInt = a(paramInt);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.scrollToPosition(paramInt);
  }
  
  public void a(@NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo)
  {
    a(paramAEEditorMusicInfo, 1, true, 2);
  }
  
  public void a(@Nullable AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      paramAEEditorMusicInfo = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel$OperationCallback;
      if (paramAEEditorMusicInfo != null) {
        paramAEEditorMusicInfo.G();
      }
      return;
    }
    if (!paramBoolean)
    {
      setEnableBgm(false);
      this.jdField_b_of_type_Boolean = true;
      i();
      return;
    }
    this.h = true;
    AEEditorMusicPanel.OperationCallback localOperationCallback = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel$OperationCallback;
    if (localOperationCallback != null) {
      localOperationCallback.a(paramAEEditorMusicInfo, paramInt1);
    }
  }
  
  public void a(@NonNull List<AEEditorMusicAdapter.AEEditorMusicInfo> paramList)
  {
    AEEditorMusicAdapter localAEEditorMusicAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter;
    if (localAEEditorMusicAdapter != null) {
      localAEEditorMusicAdapter.a(paramList);
    }
    if ((!CollectionUtils.isEmpty(paramList)) && (!this.g))
    {
      this.g = true;
      if (!this.e) {
        setEnableBgm(true);
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    AEEditorMusicPanel.OperationCallback localOperationCallback = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel$OperationCallback;
    if (localOperationCallback != null) {
      localOperationCallback.K();
    }
  }
  
  public void b(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void c()
  {
    if (this.e)
    {
      this.e = false;
      if (this.g) {
        setEnableBgm(true);
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        int k = this.jdField_a_of_type_Int;
        if (k == 1)
        {
          h();
          return;
        }
        if (k == 0)
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
      AEEditorMusicAdapter localAEEditorMusicAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter;
      if (localAEEditorMusicAdapter != null) {
        localAEEditorMusicAdapter.a();
      }
    }
  }
  
  public void d()
  {
    int k = this.jdField_a_of_type_Int;
    if (k == 0)
    {
      this.jdField_a_of_type_Int = 1;
      h();
      AEBaseReportParam.a().a().g = 0;
    }
    else if (k == 1)
    {
      this.jdField_a_of_type_Int = 0;
      g();
      AEBaseReportParam.a().a().g = 1;
    }
    AEBaseDataReporter.a().u();
  }
  
  public void e()
  {
    AEEditorMusicAdapter localAEEditorMusicAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter;
    if (localAEEditorMusicAdapter != null) {
      localAEEditorMusicAdapter.b();
    }
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    if (k == 2064122362)
    {
      paramView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel$OperationCallback;
      if (paramView != null) {
        paramView.J();
      }
      AEReportUtils.b(5);
      return;
    }
    if (k == 2064122361)
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        d();
        AEReportUtils.b(10);
      }
    }
    else if (k == 2064122360)
    {
      paramView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel$OperationCallback;
      if (paramView != null) {
        paramView.g(this.i);
      }
      AEReportUtils.b(8);
    }
  }
  
  public void setAutoTemplate(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_c_of_type_AndroidWidgetCheckedTextView.setChecked(paramBoolean1 ^ true);
    this.jdField_d_of_type_AndroidWidgetCheckedTextView.setChecked(paramBoolean1 ^ true);
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter.c();
      b(false);
      c(false);
    }
    a(paramBoolean2);
  }
  
  public void setBgmPlayed(boolean paramBoolean, AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo)
  {
    this.i = paramBoolean;
    if (this.j) {
      this.j = false;
    }
    if ((paramBoolean) && ((paramAEEditorMusicInfo == null) || (paramAEEditorMusicInfo.c != 3)))
    {
      b(true);
      int k = this.jdField_a_of_type_Int;
      if (k == 1)
      {
        h();
      }
      else if (k == 0)
      {
        h();
        g();
      }
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    b(false);
    this.jdField_b_of_type_Boolean = true;
    i();
  }
  
  public void setEnableBgm(boolean paramBoolean)
  {
    this.h = paramBoolean;
    AEEditorMusicPanel.OperationCallback localOperationCallback = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel$OperationCallback;
    if (localOperationCallback != null) {
      localOperationCallback.e(this.h);
    }
  }
  
  public void setOperationCallback(@Nullable AEEditorMusicPanel.OperationCallback paramOperationCallback)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel$OperationCallback = paramOperationCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicPanel
 * JD-Core Version:    0.7.0.1
 */