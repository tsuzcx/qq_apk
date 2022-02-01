package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AlbumConstants;
import java.util.ArrayList;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$1
  implements Handler.Callback
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$1(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return true;
        }
        this.a.l();
        return true;
      }
      this.a.b(null);
      return true;
    }
    paramMessage = (Intent)paramMessage.obj;
    this.a.c = paramMessage.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    if ((55 == paramMessage.getIntExtra(AlbumConstants.h, -1)) && (paramMessage.getExtras().containsKey("PhotoConst.PHOTO_PATHS")))
    {
      ArrayList localArrayList = paramMessage.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        this.a.a(BaseApplicationImpl.getApplication(), localArrayList);
        return true;
      }
    }
    if (paramMessage.getBooleanExtra("IS_FROM_PREVIEW_ACTIVITY", false))
    {
      paramMessage = paramMessage.getStringArrayListExtra("key_photo_preview");
      if (paramMessage != null) {
        this.a.a(BaseApplicationImpl.getApplication(), paramMessage);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.1
 * JD-Core Version:    0.7.0.1
 */