package com.tencent.biz.richframework.part.extendsblock;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter.BaseVH;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public abstract class SingleViewBlock
  extends MultiViewBlock
{
  private BaseWidgetView a;
  private boolean b = true;
  
  public SingleViewBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected abstract BaseWidgetView a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock);
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean == this.b) {
      return;
    }
    this.b = paramBoolean;
    if (getBlockMerger() != null)
    {
      if (paramBoolean) {
        getBlockMerger().notifyItemRangeInserted(getGlobalPosition(0), 1);
      } else {
        getBlockMerger().notifyItemRangeRemoved(getGlobalPosition(0), 1);
      }
      int i = getBlockMerger().getItemCount() - getGlobalPosition(0);
      getBlockMerger().notifyItemRangeChanged(getGlobalPosition(0), i);
      QLog.i("SingleViewBlock", 1, String.format("%s : isVisible:%b, globalPos:%d, notifyCount:%d", new Object[] { getClass().getSimpleName(), Boolean.valueOf(paramBoolean), Integer.valueOf(getGlobalPosition(0)), Integer.valueOf(i) }));
    }
  }
  
  public BaseWidgetView e()
  {
    return this.a;
  }
  
  public boolean f()
  {
    return this.b;
  }
  
  public int getItemCount()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public int getItemViewType(int paramInt)
  {
    return 1;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.a == null) {
      this.a = a(paramViewGroup, this);
    }
    return new BaseListViewAdapter.BaseVH(this, this.a);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
  }
  
  public void setDatas(List paramList)
  {
    this.mDataList.clear();
    notifyDataSetChanged();
    if (paramList == null) {
      return;
    }
    this.mDataList.addAll(paramList);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
 * JD-Core Version:    0.7.0.1
 */