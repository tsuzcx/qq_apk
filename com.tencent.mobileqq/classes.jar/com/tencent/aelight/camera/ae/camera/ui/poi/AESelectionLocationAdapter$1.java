package com.tencent.aelight.camera.ae.camera.ui.poi;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;

class AESelectionLocationAdapter$1
  implements View.OnClickListener
{
  AESelectionLocationAdapter$1(AESelectionLocationAdapter paramAESelectionLocationAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = this.b;
    AESelectionLocationAdapter.a(paramView, (AESelectionLocationAdapter.LocationData)paramView.a.get(this.a));
    if (AESelectionLocationAdapter.a(this.b) != null) {
      paramView = AESelectionLocationAdapter.a(this.b).a;
    } else {
      paramView = "";
    }
    if (AESelectionLocationAdapter.b(this.b) == null) {
      return;
    }
    AESelectionLocationAdapter.b(this.b).a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.poi.AESelectionLocationAdapter.1
 * JD-Core Version:    0.7.0.1
 */