package com.tencent.aelight.camera.aioeditor.takevideo;

import android.view.View;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.adapter.TransitionProviderGridAdapter;
import com.tencent.aelight.camera.aioeditor.capture.data.TransitionCategoryItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;

class EditProviderPart$2$1$1
  implements AdapterView.OnItemClickListener
{
  EditProviderPart$2$1$1(EditProviderPart.2.1 param1, TransitionProviderGridAdapter paramTransitionProviderGridAdapter) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView != null)
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditProviderPart$2$1.a.a == null) {
        return;
      }
      if (paramInt >= this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditProviderPart$2$1.a.a.size()) {
        return;
      }
      paramAdapterView = (TransitionCategoryItem)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditProviderPart$2$1.a.a.get(paramInt);
      if ((paramAdapterView != null) && (!paramAdapterView.equals(VideoFilterTools.a().a())))
      {
        VideoFilterTools.a().a(paramAdapterView);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterTransitionProviderGridAdapter.a();
        paramInt = Integer.parseInt(paramAdapterView.a);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditProviderPart$2$1.a.this$0.b(paramInt);
        StoryReportor.a("video_edit_transition", "clk_effects", EditVideoTransfer.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditProviderPart$2$1.a.this$0.a.a.a("extra_transiton_src_from", -1)), 0, new String[] { paramAdapterView.k, paramAdapterView.n, paramAdapterView.l, paramAdapterView.m });
      }
      paramView.postDelayed(new EditProviderPart.2.1.1.1(this), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart.2.1.1
 * JD-Core Version:    0.7.0.1
 */