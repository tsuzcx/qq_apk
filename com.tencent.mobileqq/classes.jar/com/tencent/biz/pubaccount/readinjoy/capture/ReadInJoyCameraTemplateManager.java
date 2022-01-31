package com.tencent.biz.pubaccount.readinjoy.capture;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.capture.view.SplitEffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import lkl;

public class ReadInJoyCameraTemplateManager
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ReadInJoyCameraTemplateAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraTemplateAdapter;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private SplitEffectsCameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private lkl jdField_a_of_type_Lkl;
  private ViewGroup b;
  
  public ReadInJoyCameraTemplateManager(Activity paramActivity, AppInterface paramAppInterface, SplitEffectsCameraCaptureView paramSplitEffectsCameraCaptureView, int paramInt)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView = paramSplitEffectsCameraCaptureView;
    this.jdField_a_of_type_Int = paramInt;
    d();
  }
  
  private void d()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2130969555, null);
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidAppActivity, 2131624148);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(localRelativeLayout);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localRelativeLayout.findViewById(2131362845));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.b = ((ViewGroup)localRelativeLayout.findViewById(2131364682));
    this.b.setOnClickListener(null);
    if (this.jdField_a_of_type_Int == 2) {
      this.b.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#cd222324")));
    }
    Window localWindow = this.jdField_a_of_type_AndroidAppDialog.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.gravity = 80;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setWindowAnimations(2131624713);
    this.jdField_a_of_type_AndroidViewView = localRelativeLayout.findViewById(2131366113);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)localRelativeLayout.findViewById(2131366966));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraTemplateAdapter = new ReadInJoyCameraTemplateAdapter(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraTemplateAdapter);
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraTemplateAdapter.a().iterator();
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject1).next();
    } while ((((PtvTemplateManager.PtvTemplateInfo)localObject2).id.equals("0")) || (!((PtvTemplateManager.PtvTemplateInfo)localObject2).isSelected));
    for (int i = 1;; i = 0)
    {
      localObject2 = new HashSet();
      if (i == 0)
      {
        localObject1 = PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(true, false, 1);
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        try
        {
          while (localIterator.hasNext())
          {
            PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo2 = (PtvTemplateManager.PtvTemplateInfo)localIterator.next();
            if (((Set)localObject2).contains(localPtvTemplateInfo2.id)) {
              localIterator.remove();
            }
            ((Set)localObject2).add(localPtvTemplateInfo2.id);
          }
          PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo1;
          if (this.jdField_a_of_type_AndroidAppDialog == null) {
            break label194;
          }
        }
        catch (Exception localException)
        {
          localPtvTemplateInfo1 = new PtvTemplateManager.PtvTemplateInfo();
          localPtvTemplateInfo1.id = "0";
          localPtvTemplateInfo1.isSelected = true;
          localPtvTemplateInfo1.usable = true;
          ((ArrayList)localObject1).add(0, localPtvTemplateInfo1);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraTemplateAdapter.a((ArrayList)localObject1);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
      label194:
      return;
    }
  }
  
  public void a(lkl paramlkl)
  {
    this.jdField_a_of_type_Lkl = paramlkl;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void c()
  {
    PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    PtvTemplateManager.b();
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView = null;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    b();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Lkl != null) {
      this.jdField_a_of_type_Lkl.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraTemplateManager
 * JD-Core Version:    0.7.0.1
 */