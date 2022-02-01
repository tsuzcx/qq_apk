package com.tencent.biz.qqcircle.publish.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemAnimator;
import com.tencent.biz.qqcircle.publish.viewmodel.QCircleLabelViewModel.UpdateLabelInfoOnChange;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class QCircleLabelPart$9
  implements Observer<QCircleLabelViewModel.UpdateLabelInfoOnChange>
{
  QCircleLabelPart$9(QCircleLabelPart paramQCircleLabelPart) {}
  
  public void a(@NonNull QCircleLabelViewModel.UpdateLabelInfoOnChange paramUpdateLabelInfoOnChange)
  {
    Object localObject = paramUpdateLabelInfoOnChange.a;
    int i = paramUpdateLabelInfoOnChange.b;
    paramUpdateLabelInfoOnChange = new StringBuilder();
    paramUpdateLabelInfoOnChange.append("onChanged... updateSize:");
    paramUpdateLabelInfoOnChange.append(i);
    paramUpdateLabelInfoOnChange.append(" labelInfos:");
    QLog.d("[QcirclePublish]QCircleLabelPart", 1, new Object[] { paramUpdateLabelInfoOnChange.toString(), ((ArrayList)localObject).toString() });
    if (QCircleLabelPart.j(this.a) != null)
    {
      if (((ArrayList)localObject).size() > 0)
      {
        if (QCircleLabelPart.j(this.a).getVisibility() != 0)
        {
          QCircleLabelPart.b(this.a).notifyDataSetChanged();
          QCircleLabelPart.k(this.a).scrollToPosition(0);
          QCircleLabelPart.j(this.a).setVisibility(0);
          paramUpdateLabelInfoOnChange = ValueAnimator.ofFloat(new float[] { 0.0F, ViewUtils.a(19.0F) });
          paramUpdateLabelInfoOnChange.addUpdateListener(new QCircleLabelPart.9.1(this));
          localObject = ObjectAnimator.ofFloat(QCircleLabelPart.j(this.a), "translationY", new float[] { -ViewUtils.a(16.0F), 0.0F });
          AnimatorSet localAnimatorSet = new AnimatorSet();
          localAnimatorSet.setDuration(200L);
          localAnimatorSet.play(paramUpdateLabelInfoOnChange).with((Animator)localObject);
          localAnimatorSet.start();
          return;
        }
        if (i > 0)
        {
          if (i >= 2) {
            QCircleLabelPart.k(this.a).getItemAnimator().setAddDuration(400L);
          } else {
            QCircleLabelPart.k(this.a).getItemAnimator().setAddDuration(200L);
          }
          QCircleLabelPart.b(this.a).notifyItemRangeInserted(0, i);
          QCircleLabelPart.k(this.a).scrollToPosition(0);
          return;
        }
        QCircleLabelPart.b(this.a).notifyDataSetChanged();
        return;
      }
      if (QCircleLabelPart.j(this.a).getVisibility() != 8) {
        QCircleLabelPart.j(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLabelPart.9
 * JD-Core Version:    0.7.0.1
 */