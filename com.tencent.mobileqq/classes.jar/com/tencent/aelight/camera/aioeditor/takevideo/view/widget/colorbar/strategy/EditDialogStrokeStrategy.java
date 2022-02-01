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
  public static final int[] a;
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "#000000", "#FFFFFF", "#DF382C", "#F09A37", "#83D754", "#3478F6", "#7ED5F8", "#F7E368", "#E8519C" };
    jdField_a_of_type_ArrayOfInt = new int[] { 2130847007, 2130847005, 2130847008, 2130847006, 2130847011, 2130847010, 2130847014, 2130847009, 2130847012 };
  }
  
  public static int a(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = jdField_a_of_type_ArrayOfJavaLangString[2];
    } else {
      str = jdField_a_of_type_ArrayOfJavaLangString[1];
    }
    return Color.parseColor(str);
  }
  
  public void a(@NonNull ArrayList<HorizontalStroke> paramArrayList, @NonNull Context paramContext)
  {
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      paramArrayList.add(new HorizontalStroke(paramContext.getResources().getDrawable(jdField_a_of_type_ArrayOfInt[i]), 0, jdField_a_of_type_ArrayOfJavaLangString[i]));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.strategy.EditDialogStrokeStrategy
 * JD-Core Version:    0.7.0.1
 */