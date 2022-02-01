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
    if (this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.jdField_a_of_type_AndroidContentContext == null) {
        return;
      }
      paramView = new WeakReference(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.jdField_a_of_type_AndroidContentContext);
      if ((this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.jdField_a_of_type_AndroidContentContext, 2131692183, 0).b(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
          return;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord != null) && (paramView.get() != null))
        {
          String str = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.getExtInfoFromExtStr("key_team_work_ext_info_new_url");
          Boolean.parseBoolean(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.getExtInfoFromExtStr("team_work_is_message_convert"));
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