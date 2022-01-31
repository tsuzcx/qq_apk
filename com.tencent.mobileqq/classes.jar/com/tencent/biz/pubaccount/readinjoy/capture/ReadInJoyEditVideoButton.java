package com.tencent.biz.pubaccount.readinjoy.capture;

import android.support.annotation.NonNull;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.qqstory.takevideo.EditVideoButton;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;

public class ReadInJoyEditVideoButton
  extends EditVideoButton
{
  public ReadInJoyEditVideoButton(@NonNull EditVideoPartManager paramEditVideoPartManager, int paramInt)
  {
    super(paramEditVideoPartManager, paramInt);
  }
  
  private void e()
  {
    ((ImageView)a(2131364452)).setVisibility(8);
    ((TextView)a(2131364477)).setText("下一步");
  }
  
  public void a()
  {
    super.a();
    e();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    switch (this.a.get(i))
    {
    default: 
      return;
    case 4: 
      PublicAccountReportUtils.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "3", "", "", "", false);
      return;
    case 8: 
      PublicAccountReportUtils.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "1", "", "", "", false);
      return;
    }
    PublicAccountReportUtils.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "2", "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyEditVideoButton
 * JD-Core Version:    0.7.0.1
 */