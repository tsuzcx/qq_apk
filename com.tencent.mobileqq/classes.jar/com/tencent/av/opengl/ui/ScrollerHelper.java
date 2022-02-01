package com.tencent.av.opengl.ui;

import android.content.Context;
import android.view.ViewConfiguration;
import com.tencent.av.opengl.utils.Utils;

public class ScrollerHelper
{
  private int jdField_a_of_type_Int;
  private OverScroller jdField_a_of_type_ComTencentAvOpenglUiOverScroller;
  private boolean jdField_a_of_type_Boolean;
  
  public ScrollerHelper(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller = new OverScroller(paramContext);
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledOverflingDistance();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller.a();
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller.a();
    if (this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller.a()) {}
    for (int i = j;; i = this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller.b())
    {
      paramInt2 = Utils.a(i + paramInt1, paramInt2, paramInt3);
      if (paramInt2 != j) {
        this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller.a(j, 0, paramInt2 - j, 0, 0);
      }
      return i + paramInt1 - paramInt2;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller.a(true);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = Math.max(paramInt, this.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = a();
    OverScroller localOverScroller = this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = this.jdField_a_of_type_Int;; i = 0)
    {
      localOverScroller.a(j, 0, paramInt1, 0, paramInt2, paramInt3, 0, 0, i, 0);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller.a();
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller.b();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller.a(paramInt, 0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentAvOpenglUiOverScroller.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.ui.ScrollerHelper
 * JD-Core Version:    0.7.0.1
 */