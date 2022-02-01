package com.tencent.mm.ui.widget.edittext;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.List;

public class SelectableEditTextHelper$MyRecycleViewAdapter
  extends RecyclerView.Adapter<SelectableEditTextHelper.MyRecycleViewAdapter.MyHolder>
{
  private List<SelectableEditTextHelper.MenuItem> a;
  private SelectableEditTextHelper.SelectionInfo b;
  private SelectableEditTextHelper.OnMenuCallback c;
  
  SelectableEditTextHelper$MyRecycleViewAdapter(List<SelectableEditTextHelper.MenuItem> paramList, SelectableEditTextHelper.OnMenuCallback paramOnMenuCallback, SelectableEditTextHelper.SelectionInfo paramSelectionInfo)
  {
    this.a = paramList;
    this.c = paramOnMenuCallback;
    this.b = paramSelectionInfo;
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public void onBindViewHolder(SelectableEditTextHelper.MyRecycleViewAdapter.MyHolder paramMyHolder, int paramInt)
  {
    SelectableEditTextHelper.MenuItem localMenuItem = (SelectableEditTextHelper.MenuItem)this.a.get(paramInt);
    paramMyHolder.a.setText(localMenuItem.name);
    paramMyHolder.a.setTag(localMenuItem);
  }
  
  public SelectableEditTextHelper.MyRecycleViewAdapter.MyHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131625222, paramViewGroup, false);
    SelectableEditTextHelper.MyRecycleViewAdapter.MyHolder localMyHolder = new SelectableEditTextHelper.MyRecycleViewAdapter.MyHolder(this, paramViewGroup);
    paramViewGroup.setOnClickListener(new SelectableEditTextHelper.MyRecycleViewAdapter.1(this));
    return localMyHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper.MyRecycleViewAdapter
 * JD-Core Version:    0.7.0.1
 */