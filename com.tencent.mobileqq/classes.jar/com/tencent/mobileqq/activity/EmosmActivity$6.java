package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.lang.ref.WeakReference;
import java.util.List;

class EmosmActivity$6
  implements AdapterView.OnItemClickListener
{
  EmosmActivity$6(EmosmActivity paramEmosmActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.mRedirect) {
      return;
    }
    if (this.a.progressDialog.isShowing()) {
      return;
    }
    int i = paramInt - this.a.mListView.getHeaderViewsCount();
    if (i < 0) {
      return;
    }
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.a.mAdapter.getItem(i);
    if (this.a.mIsEdited)
    {
      this.a.mAdapter.a(i);
      this.a.mAdapter.notifyDataSetChanged();
      paramAdapterView = this.a.mAdapter.a();
      if ((paramAdapterView != null) && (paramAdapterView.size() > 0)) {
        this.a.mDeleteButton.setEnabled(true);
      } else {
        this.a.mDeleteButton.setEnabled(false);
      }
      if (paramAdapterView != null) {
        paramInt = paramAdapterView.size();
      } else {
        paramInt = 0;
      }
      paramAdapterView = this.a;
      paramAdapterView.setTitle(String.format(paramAdapterView.getResources().getString(2131692128), new Object[] { Integer.valueOf(paramInt) }));
      if (this.a.mAdapter.a(i))
      {
        if (this.a.mLaunchMode == 1)
        {
          ReportController.b(this.a.app, "dc00898", "", "", "0X800AB11", "0X800AB11", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(this.a.app, "dc00898", "", "", "0X800AB17", "0X800AB17", 0, 0, "", "", "", "");
      }
      return;
    }
    if (!EmosmUtils.a(this.a)) {
      return;
    }
    this.a.mRedirect = true;
    paramAdapterView = localEmoticonPackage.epId;
    boolean bool1;
    if (localEmoticonPackage.jobType == 2)
    {
      paramAdapterView = localEmoticonPackage.kinId;
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    paramView = null;
    if (localEmoticonPackage.jobType == 4)
    {
      paramView = new Intent();
      paramView.putExtra("EXTRA_KEY_IS_SMALL_EMOTICON", true);
    }
    boolean bool2;
    if (localEmoticonPackage.jobType == 4) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (1 == this.a.getIntent().getExtras().getInt("emojimall_src", 3)) {
      ((IEmosmService)QRoute.api(IEmosmService.class)).openEmojiDetailPage((Activity)this.a.mActivity.get(), this.a.app.getAccount(), 8, paramAdapterView, bool1, paramView, bool2);
    } else {
      ((IEmosmService)QRoute.api(IEmosmService.class)).openEmojiDetailPage((Activity)this.a.mActivity.get(), this.a.app.getAccount(), 4, paramAdapterView, bool1, paramView, bool2);
    }
    ReportController.b(this.a.app, "CliOper", "", "", "ep_mall", "Clk_ep_mine_detail", 0, 0, localEmoticonPackage.epId, "", "", "");
    if (this.a.mLaunchMode == 1)
    {
      ReportController.b(this.a.app, "dc00898", "", "", "0X800AB0E", "0X800AB0E", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.a.app, "dc00898", "", "", "0X800AB13", "0X800AB13", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity.6
 * JD-Core Version:    0.7.0.1
 */