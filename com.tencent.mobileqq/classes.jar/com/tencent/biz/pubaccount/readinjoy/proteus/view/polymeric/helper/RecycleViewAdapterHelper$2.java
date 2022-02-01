package com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.PolymericContainerHelper;
import java.util.List;
import qeu;
import qfc;

public class RecycleViewAdapterHelper$2
  implements Runnable
{
  public RecycleViewAdapterHelper$2(qeu paramqeu) {}
  
  public void run()
  {
    this.this$0.a.childs.clear();
    this.this$0.notifyDataSetChanged();
    if (qeu.a(this.this$0) != null) {
      qeu.a(this.this$0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper.2
 * JD-Core Version:    0.7.0.1
 */