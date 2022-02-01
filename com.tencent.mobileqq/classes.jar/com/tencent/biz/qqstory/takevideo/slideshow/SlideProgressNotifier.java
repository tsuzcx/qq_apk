package com.tencent.biz.qqstory.takevideo.slideshow;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;

public class SlideProgressNotifier
  extends QQProgressNotifier
  implements DialogInterface.OnKeyListener, RefreshUICallBack
{
  Activity jdField_a_of_type_AndroidAppActivity;
  Handler jdField_a_of_type_AndroidOsHandler;
  private SlideProgressNotifier.OnCancelListener jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$OnCancelListener;
  SlideProgressNotifier.RefreshProgressThread jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread;
  
  public SlideProgressNotifier(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new SlideProgressNotifier.1(this, paramInt));
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread.a()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread.a();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread = null;
    }
    a(paramInt3);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread = new SlideProgressNotifier.RefreshProgressThread(paramInt1, paramInt2, paramInt3, this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread.start();
    if (QLog.isColorLevel()) {
      QLog.d("SlideProgressNotifier", 2, "beginMerge totalDuration=" + paramInt1 + " totalProgress = " + paramInt2 + " startProgress=" + paramInt3);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.a(paramInt1, this.jdField_a_of_type_AndroidAppActivity.getString(2131699267) + "0%", 0);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnKeyListener(this);
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread.a()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread.a();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread = null;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread = new SlideProgressNotifier.RefreshProgressThread(paramInt2, paramInt3, paramInt4, this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread.start();
    if (QLog.isColorLevel()) {
      QLog.d("SlideProgressNotifier", 2, " beginTask totalDuration=" + paramInt2 + " totalProgress = " + paramInt3 + " startProgress=" + paramInt4);
    }
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      SlideShowPhotoListManager.a().f();
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$OnCancelListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$OnCancelListener.a();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideProgressNotifier
 * JD-Core Version:    0.7.0.1
 */