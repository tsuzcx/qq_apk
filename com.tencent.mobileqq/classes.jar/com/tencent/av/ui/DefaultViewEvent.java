package com.tencent.av.ui;

import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.av.utils.AVUtil;

public class DefaultViewEvent
  implements NormalMenuView.ViewEvent
{
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = false;
  
  public DefaultViewEvent(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(long paramLong, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Boolean = true;
      AVUtil.a(this.jdField_a_of_type_JavaLangString, 0);
    }
    if ((paramRelativeLayout instanceof QavMenuBaseView)) {
      ((QavMenuBaseView)paramRelativeLayout).a(paramLong, paramBoolean);
    }
  }
  
  public void b(long paramLong, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    if ((paramRelativeLayout instanceof QavMenuBaseView)) {
      ((QavMenuBaseView)paramRelativeLayout).c(paramLong, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DefaultViewEvent
 * JD-Core Version:    0.7.0.1
 */