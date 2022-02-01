package com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.strategy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.struct.editor.HorizontalStroke;
import java.util.ArrayList;

public class EditDialogStrokeStrategy
  implements StrokeStrategy
{
  public static final String[] a = { "#000000", "#FFFFFF", "#DF382C", "#F09A37", "#83D754", "#3478F6", "#7ED5F8", "#F7E368", "#E8519C" };
  public static final int[] b = { 2130848559, 2130848557, 2130848560, 2130848558, 2130848563, 2130848562, 2130848566, 2130848561, 2130848564 };
  
  public static int a(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = a[2];
    } else {
      str = a[1];
    }
    return Color.parseColor(str);
  }
  
  public void a(@NonNull ArrayList<HorizontalStroke> paramArrayList, @NonNull Context paramContext)
  {
    int i = 0;
    while (i < a.length)
    {
      paramArrayList.add(new HorizontalStroke(paramContext.getResources().getDrawable(b[i]), 0, a[i]));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.strategy.EditDialogStrokeStrategy
 * JD-Core Version:    0.7.0.1
 */