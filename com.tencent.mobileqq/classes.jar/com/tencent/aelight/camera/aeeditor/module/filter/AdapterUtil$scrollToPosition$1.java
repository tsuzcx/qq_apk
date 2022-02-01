package com.tencent.aelight.camera.aeeditor.module.filter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AdapterUtil$scrollToPosition$1
  implements Runnable
{
  AdapterUtil$scrollToPosition$1(LinearSmoothScroller paramLinearSmoothScroller, int paramInt, RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager) {}
  
  public final void run()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearSmoothScroller.setTargetPosition(this.jdField_a_of_type_Int);
    AdapterUtil.a(AdapterUtil.a, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager, this.jdField_a_of_type_AndroidSupportV7WidgetLinearSmoothScroller, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.filter.AdapterUtil.scrollToPosition.1
 * JD-Core Version:    0.7.0.1
 */