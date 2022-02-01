import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class bkql
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 1;
  bkqn jdField_a_of_type_Bkqn = null;
  ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = null;
  List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  AppRuntime jdField_a_of_type_MqqAppAppRuntime = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = -1;
  List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public bkql(Activity paramActivity, bkqn parambkqn, int paramInt1, int paramInt2, AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Bkqn = parambkqn;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null)
    {
      parambkqn = new ShareActionSheetV2.Param();
      parambkqn.context = paramActivity;
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create(parambkqn);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle(paramActivity.getString(2131692584));
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new bkqm(this));
    }
    b();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bkqn != null) {
      b(this.jdField_a_of_type_Bkqn.a());
    }
  }
  
  private void b(int paramInt)
  {
    Object localObject1 = null;
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Bkqn != null)
    {
      localObject1 = this.jdField_a_of_type_Bkqn.a();
      if (localObject1 != null)
      {
        ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_qfav");
        ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_jc_shoucang");
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity((Intent)localObject1);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localObject1 != null)
    {
      paramInt = 0;
      if (localObject1 == null) {
        break label351;
      }
    }
    label351:
    for (int i = 0;; i = 8)
    {
      ((ShareActionSheet)localObject2).setRowVisibility(paramInt, i, 0);
      localObject1 = new ArrayList();
      bfyp.a(2, (ArrayList)localObject1);
      if ((this.jdField_a_of_type_Int & 0x200) != 0) {
        bfyp.a(26, (ArrayList)localObject1);
      }
      if ((this.jdField_a_of_type_Int & 0x4000) != 0) {
        bfyp.a(64, (ArrayList)localObject1);
      }
      localObject2 = new ArrayList();
      if ((this.jdField_a_of_type_Int & 0x80) != 0) {
        bfyp.a(70, (ArrayList)localObject2);
      }
      if ((this.jdField_a_of_type_Int & 0x100) != 0) {
        bfyp.a(82, (ArrayList)localObject2);
      }
      if ((this.jdField_a_of_type_Int & 0x8) != 0) {
        bfyp.a(39, (ArrayList)localObject2);
      }
      if ((this.jdField_a_of_type_Int & 0x400) != 0) {
        bfyp.a(130, (ArrayList)localObject2);
      }
      if ((this.jdField_a_of_type_Int & 0x8000) != 0) {
        bfyp.a(131, (ArrayList)localObject2);
      }
      if ((this.jdField_a_of_type_Int & 0x10) != 0) {
        bfyp.a(94, (ArrayList)localObject2);
      }
      if ((this.jdField_a_of_type_Int & 0x40) != 0) {
        bfyp.a(129, (ArrayList)localObject2);
      }
      if ((this.jdField_a_of_type_Int & 0x800) != 0) {
        bfyp.a(52, (ArrayList)localObject2);
      }
      if ((this.jdField_a_of_type_Int & 0x2000) != 0) {
        bfyp.a(55, (ArrayList)localObject2);
      }
      if ((this.jdField_a_of_type_Int & 0x1000) != 0) {
        bfyp.a(56, (ArrayList)localObject2);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems((List)localObject1, (List)localObject2);
      return;
      paramInt = 8;
      break;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing()) {
        break label48;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
      if (QLog.isDevelopLevel()) {
        QLog.d("qqfav.FavoriteActionSheet", 4, "dismiss|showing");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = null;
      return;
      label48:
      if (QLog.isDevelopLevel()) {
        QLog.d("qqfav.FavoriteActionSheet", 4, "dismiss|not showing");
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null)
    {
      b(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.refresh();
    }
  }
  
  protected void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
    case 73: 
      this.jdField_a_of_type_Bkqn.e();
      return;
    case 72: 
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_req", ForwardRecentActivity.f);
      localBundle.putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
      localBundle.putString("key_direct_show_uin", paramActionSheetItem.uin);
      this.jdField_a_of_type_Bkqn.a(localBundle);
      return;
    case 26: 
      this.jdField_a_of_type_Bkqn.g();
      return;
    case 39: 
      this.jdField_a_of_type_Bkqn.f();
      return;
    case 130: 
      this.jdField_a_of_type_Bkqn.h();
      return;
    case 131: 
      this.jdField_a_of_type_Bkqn.n();
      return;
    case 94: 
      this.jdField_a_of_type_Bkqn.a();
      return;
    case 129: 
      this.jdField_a_of_type_Bkqn.b();
      return;
    case 70: 
      this.jdField_a_of_type_Bkqn.c();
      return;
    case 82: 
      this.jdField_a_of_type_Bkqn.d();
      return;
    case 55: 
      this.jdField_a_of_type_Bkqn.j();
      return;
    case 52: 
      this.jdField_a_of_type_Bkqn.i();
      return;
    case 56: 
      this.jdField_a_of_type_Bkqn.k();
      return;
    }
    this.jdField_a_of_type_Bkqn.m();
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing()))
    {
      this.jdField_a_of_type_Boolean = false;
      b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.refresh();
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
      this.jdField_a_of_type_Bkqn.l();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkql
 * JD-Core Version:    0.7.0.1
 */