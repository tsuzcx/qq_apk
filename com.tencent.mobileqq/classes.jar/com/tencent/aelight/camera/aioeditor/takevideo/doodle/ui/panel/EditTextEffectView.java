package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.CaptureConfigUpdateObserver;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.flashchat.OnHolderItemClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.app.AppRuntime;

public class EditTextEffectView
  extends RecyclerView
  implements Handler.Callback
{
  public static final int a;
  public static final int b;
  public static final int c;
  public Handler a;
  LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  CaptureConfigUpdateObserver jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicCaptureConfigUpdateObserver = new EditTextEffectView.1(this);
  EditTextEffectView.EditTextAdapter jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter = null;
  OnHolderItemClickListener jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener;
  public Vector<DynamicTextConfigManager.DynamicTextConfigBean> a;
  public boolean a;
  int d = -1;
  private int e;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    b = AIOUtils.b(9.0F, localResources);
    jdField_a_of_type_Int = AIOUtils.b(13.0F, localResources);
    c = AIOUtils.b(3.0F, localResources);
  }
  
  public EditTextEffectView(Context paramContext, OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener = paramOnHolderItemClickListener;
    setClipToPadding(false);
    b();
    a();
    setClipChildren(false);
  }
  
  private List<DynamicTextConfigManager.DynamicTextConfigBean> a(List<DynamicTextConfigManager.DynamicTextConfigBean> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (((DynamicTextConfigManager.DynamicTextConfigBean)localIterator.next()).text_id >= 34) {
        localIterator.remove();
      }
    }
    while (paramList.size() > 34) {
      paramList.remove(paramList.size() - 1);
    }
    return paramList;
  }
  
  public int a(int paramInt)
  {
    EditTextEffectView.EditTextAdapter localEditTextAdapter = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter;
    if ((localEditTextAdapter != null) && (localEditTextAdapter.a != null))
    {
      int j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter.a.size();
      int i = 0;
      while (i < j)
      {
        if (((DynamicTextConfigManager.DynamicTextConfigBean)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter.a.get(i)).text_id == paramInt) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public DynamicTextConfigManager.DynamicTextConfigBean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter.a == null) {
      return null;
    }
    return (DynamicTextConfigManager.DynamicTextConfigBean)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter.a.get(paramInt);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditTextEffectView", 2, "loadData");
    }
    Object localObject = (DynamicTextConfigManager)QIMManager.a(7);
    if (!((DynamicTextConfigManager)localObject).a()) {
      ((DynamicTextConfigManager)localObject).c();
    }
    this.jdField_a_of_type_JavaUtilVector.clear();
    localObject = ((DynamicTextConfigManager)localObject).a();
    this.jdField_a_of_type_JavaUtilVector.addAll(a((List)localObject));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter.a(this.jdField_a_of_type_JavaUtilVector);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter.notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    int j;
    int i;
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter.a != null) && (paramInt < this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter.a.size()))
    {
      this.d = ((DynamicTextConfigManager.DynamicTextConfigBean)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter.a.get(paramInt)).text_id;
      j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getChildCount();
      i = 0;
    }
    while (i < j)
    {
      Object localObject = (EditTextEffectView.EditTextHolder)getChildViewHolder(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getChildAt(i));
      if (((EditTextEffectView.EditTextHolder)localObject).jdField_a_of_type_Int != paramInt)
      {
        ((EditTextEffectView.EditTextHolder)localObject).b(false);
      }
      else
      {
        ((EditTextEffectView.EditTextHolder)localObject).b(true);
        StoryReportor.a("video_edit_new", "text_element", this.e, 0, new String[] { "0", String.valueOf(this.d) });
      }
      i += 1;
      continue;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("select position = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" no item");
      QLog.e("EditTextEffectView", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  @TargetApi(9)
  public void b()
  {
    setOverScrollMode(2);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getContext());
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(0);
    setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter = new EditTextEffectView.EditTextAdapter(this, this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener);
    setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      a();
    }
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().waitAppRuntime(null);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicCaptureConfigUpdateObserver = new CaptureConfigUpdateObserver();
    localAppRuntime.registObserver(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicCaptureConfigUpdateObserver);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    BaseApplicationImpl.getApplication().waitAppRuntime(null).unRegistObserver(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicCaptureConfigUpdateObserver);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditTextEffectView", 2, "exittext panel visible");
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("EditTextEffectView", 2, "exittext panel gone");
    }
  }
  
  public void setEditPhoto(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOpIn(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextEffectView
 * JD-Core Version:    0.7.0.1
 */