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

class EditProviderPart$3$1$1
  implements AdapterView.OnItemClickListener
{
  EditProviderPart$3$1$1(EditProviderPart.3.1 param1, TransitionProviderGridAdapter paramTransitionProviderGridAdapter) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView != null)
    {
      if (this.b.a.a == null) {
        return;
      }
      if (paramInt >= this.b.a.a.size()) {
        return;
      }
      paramAdapterView = (TransitionCategoryItem)this.b.a.a.get(paramInt);
      if ((paramAdapterView != null) && (!paramAdapterView.equals(VideoFilterTools.a().c())))
      {
        VideoFilterTools.a().a(paramAdapterView);
        this.a.a();
        paramInt = Integer.parseInt(paramAdapterView.a);
        this.b.a.this$0.b(paramInt);
        StoryReportor.a("video_edit_transition", "clk_effects", EditVideoTransfer.b(this.b.a.this$0.t.I.a("extra_transiton_src_from", -1)), 0, new String[] { paramAdapterView.t, paramAdapterView.w, paramAdapterView.u, paramAdapterView.v });
      }
      paramView.postDelayed(new EditProviderPart.3.1.1.1(this), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart.3.1.1
 * JD-Core Version:    0.7.0.1
 */