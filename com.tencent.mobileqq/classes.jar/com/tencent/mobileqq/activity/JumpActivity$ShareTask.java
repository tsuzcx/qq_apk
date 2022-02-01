package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import com.tencent.mobileqq.app.parser.JumpActivityHelper;
import com.tencent.mobileqq.forward.ForwardBaseOption;

public class JumpActivity$ShareTask
  extends AsyncTask<Object, Void, Uri>
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  
  public JumpActivity$ShareTask(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  protected Uri a(Object... paramVarArgs)
  {
    return JumpActivityHelper.a(paramVarArgs);
  }
  
  protected void a(Uri paramUri)
  {
    this.jdField_a_of_type_AndroidContentIntent.setData(paramUri);
    ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JumpActivity.ShareTask
 * JD-Core Version:    0.7.0.1
 */