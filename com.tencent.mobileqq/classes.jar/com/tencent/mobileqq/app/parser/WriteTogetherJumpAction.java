package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.helper.WriteTogetherHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class WriteTogetherJumpAction
  extends JumpActionBase
{
  public WriteTogetherJumpAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      if ((!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) || (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment() == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WriteTogetherJumpAction", 2, "not clicked inside aio");
        }
      }
      else
      {
        Object localObject = Uri.parse(this.jdField_a_of_type_JavaLangString);
        String str = ((Uri)localObject).getQueryParameter("docid");
        localObject = ((Uri)localObject).getQueryParameter("groupcode");
        WriteTogetherHelper.a(this.jdField_a_of_type_AndroidContentContext, str, (String)localObject, 7);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AF36", "0X800AF36", 0, 0, "", "", "", "");
        return true;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("WriteTogetherJumpAction", 1, localRuntimeException, new Object[0]);
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.WriteTogetherJumpAction
 * JD-Core Version:    0.7.0.1
 */