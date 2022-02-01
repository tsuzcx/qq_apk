package com.tencent.aelight.camera.ae.camera.ui.poi;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class AESelectionLocationAdapter
  extends RecyclerView.Adapter<AESelectionLocationAdapter.AESelectionHolder>
{
  ArrayList<AESelectionLocationAdapter.LocationData> a = new ArrayList();
  private LayoutInflater b;
  private Context c;
  private AESelectionLocationAdapter.LocationData d;
  private AESelectionLocationAdapter.SelectListener e;
  
  public AESelectionLocationAdapter(Context paramContext)
  {
    this.b = LayoutInflater.from(paramContext);
    this.c = paramContext;
  }
  
  public AESelectionLocationAdapter.AESelectionHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AESelectionLocationAdapter.AESelectionHolder(this, this.b.inflate(2064056335, paramViewGroup, false), this.c);
  }
  
  public void a(AESelectionLocationAdapter.AESelectionHolder paramAESelectionHolder, int paramInt)
  {
    paramAESelectionHolder.a.setVisibility(0);
    paramAESelectionHolder.b.setVisibility(0);
    int i = ((AESelectionLocationAdapter.LocationData)this.a.get(paramInt)).b;
    paramAESelectionHolder.a.setText(((AESelectionLocationAdapter.LocationData)this.a.get(paramInt)).a);
    paramAESelectionHolder.c.setOnClickListener(new AESelectionLocationAdapter.1(this, paramInt));
  }
  
  public void a(AESelectionLocationAdapter.SelectListener paramSelectListener)
  {
    this.e = paramSelectListener;
  }
  
  public void a(List<AESelectionLocationAdapter.LocationData> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    ArrayList localArrayList = this.a;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return super.getItemId(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.poi.AESelectionLocationAdapter
 * JD-Core Version:    0.7.0.1
 */