package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import java.util.List;

public class AEBottomListAdapter$ViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AEBottomListScrollView jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView;
  public AEMaterialMetaData a;
  private boolean jdField_a_of_type_Boolean;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  
  public AEBottomListAdapter$ViewHolder(View paramView, AEBottomListScrollView paramAEBottomListScrollView, boolean paramBoolean)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122818));
    this.d = ((ImageView)paramView.findViewById(2064122825));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2064122831);
    this.b = ((ImageView)paramView.findViewById(2064122832));
    this.c = ((ImageView)paramView.findViewById(2064122827));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2064122834));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected String a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k.equals("0")) {
      return (String)AEBottomListAdapter.a().get(5);
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k.equals("call_material_id")) {
      return (String)AEBottomListAdapter.a().get(6);
    }
    if (AEBottomListAdapter.b())
    {
      if (paramInt == 1) {
        paramInt = 3;
      } else {
        paramInt = (paramInt - 1 - 1) % 4;
      }
    }
    else {
      paramInt = (paramInt - 1) % 4;
    }
    return (String)AEBottomListAdapter.a().get(paramInt);
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return;
            }
            localObject = this.c;
            if (localObject != null) {
              ((ImageView)localObject).setVisibility(4);
            }
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
            return;
          }
          localObject = this.c;
          if ((localObject != null) && (!this.jdField_a_of_type_Boolean)) {
            ((ImageView)localObject).setVisibility(0);
          }
          if ((this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Boolean) && (!"0".equals(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k)))
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            return;
          }
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
          return;
        }
        localObject = this.jdField_a_of_type_AndroidViewView;
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidViewView;
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData = paramAEMaterialMetaData;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      if ((!"0".equals(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k)) && (!"call_material_id".equals(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k)))
      {
        if ("stub_placeholder_material_id".equals(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.b.setVisibility(8);
          this.d.setVisibility(0);
          this.d.setImageResource(2064056680);
        }
        else if (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.a())
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.d.setVisibility(0);
          this.d.setTag(2131378314, this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.m);
          this.d.setTag(2131378280, Boolean.valueOf(false));
          UIUtils.a(this.d, this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.m, UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.a()), UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.a()), this.itemView.getContext().getResources().getDrawable(2064056680), null);
          this.d.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.b.setVisibility(0);
          this.b.setImageResource(2130846136);
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.d.setVisibility(0);
          this.d.setTag(2131378314, this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.m);
          this.d.setTag(2131378280, Boolean.valueOf(false));
          UIUtils.a(this.d, this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.m, UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.a()), UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.a()), this.itemView.getContext().getResources().getDrawable(2064056680), null);
          if (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.e) {
            a(2);
          } else if (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.f) {
            a(1);
          } else {
            a(0);
          }
          this.b.setVisibility(8);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.b.setVisibility(8);
        this.d.setVisibility(8);
        if (this.jdField_a_of_type_Boolean)
        {
          if ("0".equals(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          else
          {
            this.d.setVisibility(0);
            UIUtils.a(this.d, "https://downv6.qq.com/shadow_qqcamera/Android/image/material_more.png", UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.a()), UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.a()), this.itemView.getContext().getResources().getDrawable(2064056686), null);
          }
        }
        else {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.b())
      {
        this.b.setVisibility(0);
        this.b.setImageResource(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.a());
      }
      else if (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.a())
      {
        this.b.setVisibility(0);
        this.b.setImageResource(2130846136);
      }
      else
      {
        this.b.setVisibility(8);
      }
      this.itemView.setOnClickListener(this);
      paramAEMaterialMetaData = a(getAdapterPosition());
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131378314, paramAEMaterialMetaData);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131378280, Boolean.valueOf(false));
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(AEBottomListAdapter.c);
        return;
      }
      UIUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, paramAEMaterialMetaData, UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.b()), UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.b()), this.itemView.getContext().getResources().getDrawable(2064056686), null);
    }
  }
  
  public void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData = paramAEMaterialMetaData;
  }
  
  public void onClick(View paramView)
  {
    int i = getAdapterPosition();
    if ((this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView != null) && (i >= 0))
    {
      AEBottomListAdapter.a = AEBottomListAdapter.b;
      AEBottomListAdapter.b = i;
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.smoothScrollToPosition(i);
      if ((this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.getAdapter() instanceof AEBottomListAdapter)) {
        ((AEBottomListAdapter)this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.getAdapter()).a(true);
      }
    }
    paramView = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
    if ((paramView != null) && ("call_material_id".equals(paramView.k)))
    {
      AEBaseDataReporter.a().aa();
      return;
    }
    AEBaseReportParam.a().n("none");
    AEBaseReportParam.a().m("2");
    AEBaseReportParam.a().e(0);
    if (i == 0) {
      AEBaseReportParam.a().d(-1);
    } else {
      AEBaseReportParam.a().d(i);
    }
    Object localObject = AEBaseDataReporter.a();
    paramView = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
    String str = "";
    if (paramView == null) {
      paramView = "";
    } else {
      paramView = paramView.k;
    }
    ((AEBaseDataReporter)localObject).c(paramView);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("【Click】Item :");
    paramView = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
    if (paramView == null) {
      paramView = "";
    } else {
      paramView = paramView.k;
    }
    ((StringBuilder)localObject).append(paramView);
    AEQLog.b("AEBottomListAdapter", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("【Click】Usable :");
    paramView = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
    if (paramView == null) {
      paramView = str;
    } else {
      paramView = Boolean.valueOf(paramView.e);
    }
    ((StringBuilder)localObject).append(paramView);
    AEQLog.b("AEBottomListAdapter", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */