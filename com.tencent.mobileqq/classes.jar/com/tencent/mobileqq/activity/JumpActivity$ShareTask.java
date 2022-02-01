package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import com.tencent.mobileqq.app.parser.JumpActivityHelper;
import com.tencent.mobileqq.app.parser.tempapi.IQJumpApi;
import com.tencent.mobileqq.qroute.QRoute;

public class JumpActivity$ShareTask
  extends AsyncTask<Object, Void, Uri>
{
  private Intent b;
  
  public JumpActivity$ShareTask(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    this.b = paramIntent;
  }
  
  protected Uri a(Object... paramVarArgs)
  {
    return JumpActivityHelper.a(paramVarArgs);
  }
  
  protected void a(Uri paramUri)
  {
    this.b.setData(paramUri);
    ((IQJumpApi)QRoute.api(IQJumpApi.class)).startForwardActivity(this.a, this.b);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JumpActivity.ShareTask
 * JD-Core Version:    0.7.0.1
 */