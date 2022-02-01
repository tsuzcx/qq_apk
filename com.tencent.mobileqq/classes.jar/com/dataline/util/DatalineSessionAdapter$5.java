package com.dataline.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

class DatalineSessionAdapter$5
  implements QQFileManagerUtil.TipsClickedInterface
{
  DatalineSessionAdapter$5(DatalineSessionAdapter paramDatalineSessionAdapter, DataLineMsgRecord paramDataLineMsgRecord) {}
  
  public void onClick(View paramView)
  {
    if (this.b.d != null)
    {
      if (this.b.b == null) {
        return;
      }
      paramView = new WeakReference(this.b.b);
      if ((this.b.b instanceof Activity))
      {
        if (!NetworkUtil.isNetSupport(this.b.b))
        {
          QQToast.makeText(this.b.b, 2131889169, 0).show(this.b.b.getResources().getDimensionPixelSize(2131299920));
          return;
        }
        if ((this.a != null) && (paramView.get() != null))
        {
          String str = this.a.getExtInfoFromExtStr("key_team_work_ext_info_new_url");
          Boolean.parseBoolean(this.a.getExtInfoFromExtStr("team_work_is_message_convert"));
          if (!TextUtils.isEmpty(str))
          {
            Bundle localBundle = new Bundle();
            localBundle.putString("url", str);
            localBundle.putString("tdsourcetag", "s_qq_aio_grey");
            TeamWorkDocEditBrowserActivity.a((Context)paramView.get(), localBundle, false);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.DatalineSessionAdapter.5
 * JD-Core Version:    0.7.0.1
 */