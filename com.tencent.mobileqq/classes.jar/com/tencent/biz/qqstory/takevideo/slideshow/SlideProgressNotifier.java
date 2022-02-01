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
    SlideProgressNotifier.RefreshProgressThread localRefreshProgressThread = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread;
    if (localRefreshProgressThread != null) {
      localRefreshProgressThread.a();
    }
  }
  
  public void a(int paramInt)
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.post(new SlideProgressNotifier.1(this, paramInt));
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread;
    if ((localObject != null) && (!((SlideProgressNotifier.RefreshProgressThread)localObject).a()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread.a();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread = null;
    }
    a(paramInt3);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread = new SlideProgressNotifier.RefreshProgressThread(paramInt1, paramInt2, paramInt3, this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread.start();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("beginMerge totalDuration=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" totalProgress = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" startProgress=");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.d("SlideProgressNotifier", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidAppActivity.getString(2131699372));
    ((StringBuilder)localObject).append("0%");
    super.a(paramInt1, ((StringBuilder)localObject).toString(), 0);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnKeyListener(this);
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread;
    if ((localObject != null) && (!((SlideProgressNotifier.RefreshProgressThread)localObject).a()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread.a();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread = null;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread = new SlideProgressNotifier.RefreshProgressThread(paramInt2, paramInt3, paramInt4, this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$RefreshProgressThread.start();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" beginTask totalDuration=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" totalProgress = ");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(" startProgress=");
      ((StringBuilder)localObject).append(paramInt4);
      QLog.d("SlideProgressNotifier", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      SlideShowPhotoListManager.a().d();
      paramDialogInterface = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier$OnCancelListener;
      if (paramDialogInterface != null) {
        paramDialogInterface.a();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideProgressNotifier
 * JD-Core Version:    0.7.0.1
 */