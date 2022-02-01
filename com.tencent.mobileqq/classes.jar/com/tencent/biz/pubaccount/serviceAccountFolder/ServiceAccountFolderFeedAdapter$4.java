package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ServiceAccountFolderFeedAdapter$4
  implements ActionSheet.OnButtonClickListener
{
  ServiceAccountFolderFeedAdapter$4(ServiceAccountFolderFeedAdapter paramServiceAccountFolderFeedAdapter, ServiceAccountFolderFeed paramServiceAccountFolderFeed, int paramInt, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      ServiceAccountFolderFeedAdapter.a(this.d, this.a);
      paramInt = this.a.d;
      int i = this.a.c;
      if (this.a.c != 1) {
        paramInt = 0;
      }
      long l = ServiceAccountFolderManager.a().a(this.a);
      paramView = ServiceAccountFolderFeedAdapter.a(this.d);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(this.a.b);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(this.b + 1);
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(l);
      localObject3 = ((StringBuilder)localObject3).toString();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(i);
      localObject4 = ((StringBuilder)localObject4).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt);
      ReportController.b(paramView, "dc01160", "Pb_account_lifeservice", (String)localObject1, "0X80067F2", "0X80067F2", 0, 0, (String)localObject2, (String)localObject3, (String)localObject4, localStringBuilder.toString());
    }
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.4
 * JD-Core Version:    0.7.0.1
 */