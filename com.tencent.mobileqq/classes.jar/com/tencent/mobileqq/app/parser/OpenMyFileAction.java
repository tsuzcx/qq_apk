package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;

public class OpenMyFileAction
  extends JumpAction
{
  protected OpenMyFileAction(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    super(paramBaseQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    if ((this.b instanceof Activity))
    {
      ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).openMyFileBySchema((Activity)this.b);
      return true;
    }
    QLog.e("OpenMyFileAction", 1, "jump mu file fail, content err");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.OpenMyFileAction
 * JD-Core Version:    0.7.0.1
 */