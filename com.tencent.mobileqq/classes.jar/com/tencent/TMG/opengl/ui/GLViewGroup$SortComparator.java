package com.tencent.TMG.opengl.ui;

import java.util.Comparator;

class GLViewGroup$SortComparator
  implements Comparator<GLView>
{
  GLViewGroup$SortComparator(GLViewGroup paramGLViewGroup) {}
  
  public int compare(GLView paramGLView1, GLView paramGLView2)
  {
    if (paramGLView1.getZOrder() >= paramGLView2.getZOrder()) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.opengl.ui.GLViewGroup.SortComparator
 * JD-Core Version:    0.7.0.1
 */