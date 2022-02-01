package com.tencent.biz.expand.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandPluginLoadingFragment$updateLoadingStatus$1
  implements Runnable
{
  ExpandPluginLoadingFragment$updateLoadingStatus$1(ExpandPluginLoadingFragment paramExpandPluginLoadingFragment, LoadingStatus paramLoadingStatus, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    this.this$0.a(this.jdField_a_of_type_ComTencentBizExpandUiLoadingStatus);
    Object localObject = this.jdField_a_of_type_ComTencentBizExpandUiLoadingStatus;
    switch (ExpandPluginLoadingFragment.WhenMappings.a[localObject.ordinal()])
    {
    default: 
    case 1: 
      do
      {
        return;
        localObject = ExpandPluginLoadingFragment.a(this.this$0);
        if (localObject != null) {
          ((TextView)localObject).setText(2131698798);
        }
        localObject = ExpandPluginLoadingFragment.b(this.this$0);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(8);
        }
        localObject = ExpandPluginLoadingFragment.a(this.this$0);
        if (localObject != null) {
          ((URLImageView)localObject).setVisibility(0);
        }
        localObject = ExpandPluginLoadingFragment.a(this.this$0);
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(8);
        }
        localObject = ExpandPluginLoadingFragment.a(this.this$0);
        if (localObject != null) {
          ((ProgressBar)localObject).setVisibility(0);
        }
        localObject = ExpandPluginLoadingFragment.c(this.this$0);
      } while (localObject == null);
      ((TextView)localObject).setVisibility(8);
      return;
    case 2: 
      ExpandPluginLoadingFragment.a(this.this$0).setVisibility(0);
      localObject = ExpandPluginLoadingFragment.a(this.this$0);
      if (localObject != null) {
        ((TextView)localObject).setText(2131698799);
      }
      localObject = ExpandPluginLoadingFragment.b(this.this$0);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = ExpandPluginLoadingFragment.b(this.this$0);
      if (localObject != null) {
        ((TextView)localObject).setText(2131698801);
      }
      localObject = ExpandPluginLoadingFragment.a(this.this$0);
      if (localObject != null) {
        ((URLImageView)localObject).setVisibility(8);
      }
      localObject = ExpandPluginLoadingFragment.a(this.this$0);
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      localObject = ExpandPluginLoadingFragment.a(this.this$0);
      if (localObject != null) {
        ((ProgressBar)localObject).setVisibility(8);
      }
      localObject = ExpandPluginLoadingFragment.c(this.this$0);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = ExpandPluginLoadingFragment.d(this.this$0);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      ExpandReportUtils.a("expose#launch_network_error_page#view", true, -1L, -1L, null, true, true);
      return;
    case 3: 
      ExpandPluginLoadingFragment.a(this.this$0).setVisibility(0);
      localObject = this.this$0;
      if ((this.jdField_a_of_type_Int == 0) && (this.this$0.a() != 0)) {}
      for (int i = this.this$0.a();; i = this.jdField_a_of_type_Int)
      {
        ((ExpandPluginLoadingFragment)localObject).a(i);
        localObject = ExpandPluginLoadingFragment.a(this.this$0);
        if (localObject != null) {
          ((TextView)localObject).setText(2131698799);
        }
        localObject = ExpandPluginLoadingFragment.b(this.this$0);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        localObject = ExpandPluginLoadingFragment.b(this.this$0);
        if (localObject != null) {
          ((TextView)localObject).setText(2131698800);
        }
        localObject = ExpandPluginLoadingFragment.a(this.this$0);
        if (localObject != null) {
          ((URLImageView)localObject).setVisibility(8);
        }
        localObject = ExpandPluginLoadingFragment.a(this.this$0);
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(0);
        }
        localObject = ExpandPluginLoadingFragment.a(this.this$0);
        if (localObject != null) {
          ((ProgressBar)localObject).setVisibility(8);
        }
        localObject = ExpandPluginLoadingFragment.c(this.this$0);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        localObject = ExpandPluginLoadingFragment.d(this.this$0);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(8);
        }
        localObject = new HashMap();
        ((Map)localObject).put("load_error", String.valueOf(this.b));
        ((Map)localObject).put("error_reason", String.valueOf(this.jdField_a_of_type_Int));
        ExpandReportUtils.a("expose#launch_download_error_page#view", true, -1L, -1L, (Map)localObject, true, true);
        return;
      }
    }
    this.this$0.e(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandPluginLoadingFragment.updateLoadingStatus.1
 * JD-Core Version:    0.7.0.1
 */