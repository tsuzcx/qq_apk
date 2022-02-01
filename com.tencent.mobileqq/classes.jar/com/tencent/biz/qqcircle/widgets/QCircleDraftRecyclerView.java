package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import java.util.List;

public class QCircleDraftRecyclerView
{
  private RecyclerView a;
  private QCircleDraftRecyclerView.DraftAdapter b;
  
  public void a()
  {
    QCircleDraftRecyclerView.DraftAdapter localDraftAdapter = this.b;
    if (localDraftAdapter != null) {
      localDraftAdapter.a();
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    QCircleDraftRecyclerView.DraftAdapter localDraftAdapter = this.b;
    if (localDraftAdapter != null) {
      localDraftAdapter.a(paramOnClickListener);
    }
  }
  
  public void a(@NonNull View paramView)
  {
    this.a = ((RecyclerView)paramView.findViewById(2131441617));
    this.a.setLayoutManager(new GridLayoutManager(paramView.getContext(), 3));
    this.b = new QCircleDraftRecyclerView.DraftAdapter(null);
    this.a.setAdapter(this.b);
    this.a.setItemAnimator(new DefaultItemAnimator());
  }
  
  public void a(QCircleDraftRecyclerView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    QCircleDraftRecyclerView.DraftAdapter localDraftAdapter = this.b;
    if (localDraftAdapter != null) {
      localDraftAdapter.a(paramOnItemSelectedListener);
    }
  }
  
  public void a(String paramString)
  {
    QCircleDraftRecyclerView.DraftAdapter localDraftAdapter = this.b;
    if (localDraftAdapter != null) {
      localDraftAdapter.a(paramString);
    }
  }
  
  public void a(List<DraftBean> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      QCircleDraftRecyclerView.DraftAdapter localDraftAdapter = this.b;
      if (localDraftAdapter != null) {
        localDraftAdapter.a(paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean ^ true);
    QCircleDraftRecyclerView.DraftAdapter localDraftAdapter = this.b;
    if (localDraftAdapter != null) {
      localDraftAdapter.a(paramBoolean);
    }
  }
  
  public void b()
  {
    QCircleDraftRecyclerView.DraftAdapter localDraftAdapter = this.b;
    if (localDraftAdapter != null) {
      localDraftAdapter.b();
    }
  }
  
  public void b(View paramView)
  {
    QCircleDraftRecyclerView.DraftAdapter localDraftAdapter = this.b;
    if (localDraftAdapter != null) {
      localDraftAdapter.a(paramView);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    QCircleDraftRecyclerView.DraftAdapter localDraftAdapter = this.b;
    if (localDraftAdapter != null) {
      localDraftAdapter.b(paramBoolean);
    }
  }
  
  public void c()
  {
    QCircleDraftRecyclerView.DraftAdapter localDraftAdapter = this.b;
    if (localDraftAdapter != null) {
      localDraftAdapter.c();
    }
  }
  
  public void d()
  {
    QCircleDraftRecyclerView.DraftAdapter localDraftAdapter = this.b;
    if (localDraftAdapter != null)
    {
      localDraftAdapter.d();
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleDraftRecyclerView
 * JD-Core Version:    0.7.0.1
 */