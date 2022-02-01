package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.base.ToastUtil;
import com.tencent.util.LiuHaiUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.widget.QzoneGuideBubbleHelper;

public class QzoneRightButton
  extends EditVideoPart
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private QzEditVideoPartManager jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  private View c;
  
  public QzoneRightButton(@NonNull QzEditVideoPartManager paramQzEditVideoPartManager, Activity paramActivity)
  {
    super(paramQzEditVideoPartManager);
    boolean bool = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager = paramQzEditVideoPartManager;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (SlideShowPhotoListManager.a().b() == 22) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
  }
  
  private void a(String paramString)
  {
    String str = a().getString(2131717526);
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    QZoneHelper.forwardOpenQzoneVip2(this.jdField_a_of_type_AndroidAppActivity, localUserInfo, paramString, QQStoryContext.a().a(), "", 1010, str, false);
  }
  
  private void b()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2064122153);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131562251, localRelativeLayout, false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, LiuHaiUtils.a, 0, 0);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131375364);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131375363);
    if (this.jdField_a_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.c.setVisibility(8);
    }
    else
    {
      this.b.setOnClickListener(new QzoneRightButton.1(this));
      this.c.setOnClickListener(new QzoneRightButton.2(this));
    }
    localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
  }
  
  private void g()
  {
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131717660).setPositiveButton(2131717174, new QzoneRightButton.4(this)).setNegativeButton(2131719062, new QzoneRightButton.3(this)).show();
  }
  
  private void h()
  {
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131717661).setPositiveButton(2131717174, new QzoneRightButton.6(this)).setNegativeButton(2131691064, new QzoneRightButton.5(this)).show();
  }
  
  public void a()
  {
    super.a();
    b();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1010) && (paramInt2 == -1))
    {
      ToastUtil.a().a(2131717396);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 0)
    {
      if (paramInt != 11)
      {
        if (paramInt == 4) {
          break label43;
        }
        if ((paramInt != 5) && (paramInt != 6)) {
          return;
        }
      }
      paramObject = this.jdField_a_of_type_AndroidViewView;
      if (paramObject == null) {
        return;
      }
      paramObject.setVisibility(8);
      return;
    }
    label43:
    paramObject = this.jdField_a_of_type_AndroidViewView;
    if (paramObject != null) {
      paramObject.setVisibility(0);
    }
  }
  
  public void e()
  {
    super.e();
    QzoneGuideBubbleHelper.getInstance().dismissGuideBubble();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneRightButton
 * JD-Core Version:    0.7.0.1
 */