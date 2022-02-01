package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.qphone.base.util.QLog;

public class SmallVideoAction
  extends JumpActionBase
{
  public SmallVideoAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = i();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("IdentifierWebJumpAction", 1, "doAction error: " + localException.getMessage());
      a("IdentifierWebJumpAction");
    }
    return false;
  }
  
  public boolean i()
  {
    SmallVideoFragment.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.SmallVideoAction
 * JD-Core Version:    0.7.0.1
 */