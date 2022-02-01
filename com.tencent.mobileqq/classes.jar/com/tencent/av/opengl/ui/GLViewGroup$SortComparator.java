package com.tencent.av.opengl.ui;

import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;

class GLViewGroup$SortComparator
  implements Comparator<GLView>
{
  GLViewGroup$SortComparator(GLViewGroup paramGLViewGroup) {}
  
  public int a(GLView paramGLView1, GLView paramGLView2)
  {
    if ((paramGLView1 != null) && (paramGLView2 != null))
    {
      if (paramGLView1.j() >= paramGLView2.j()) {
        return 1;
      }
      return -1;
    }
    QLog.d("SortComparator", 1, "SortComparator has null element");
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.ui.GLViewGroup.SortComparator
 * JD-Core Version:    0.7.0.1
 */