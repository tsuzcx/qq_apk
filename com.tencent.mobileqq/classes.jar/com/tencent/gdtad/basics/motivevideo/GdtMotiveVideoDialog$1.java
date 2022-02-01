package com.tencent.gdtad.basics.motivevideo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.qphone.base.util.QLog;

class GdtMotiveVideoDialog$1
  implements GdtMvViewController.Listener
{
  GdtMotiveVideoDialog$1(GdtMotiveVideoDialog paramGdtMotiveVideoDialog) {}
  
  public void a(long paramLong)
  {
    QLog.i("GdtMotiveVideoDialog", 4, "[onClickChangeVideo]");
    if (GdtMotiveVideoDialog.a(this.a) == null)
    {
      QLog.e("GdtMotiveVideoDialog", 4, "[onClickChangeVideo] mSecondVideoData is null");
      return;
    }
    Object localObject = this.a.getWindow();
    if (localObject == null) {
      return;
    }
    localObject = (ViewGroup)((Window)localObject).getDecorView();
    GdtMotiveVideoDialog localGdtMotiveVideoDialog = this.a;
    GdtMotiveVideoDialog.a(localGdtMotiveVideoDialog, new GdtMotiveVideoModel(GdtMotiveVideoDialog.a(localGdtMotiveVideoDialog)));
    GdtMotiveVideoDialog.b(this.a);
    GdtMotiveVideoDialog.c(this.a).a(2);
    GdtMotiveVideoDialog.c(this.a).n();
    localObject = GdtMotiveVideoDialog.c(this.a).a(LayoutInflater.from(this.a.getContext()), (ViewGroup)localObject);
    if (localObject == null)
    {
      QLog.e("GdtMotiveVideoDialog", 4, "[onClickChangeVideo] innerView is null");
      return;
    }
    GdtMotiveVideoDialog.c(this.a).a(paramLong);
    this.a.setContentView((View)localObject);
    GdtMotiveVideoDialog.c(this.a).l();
    QLog.e("GdtMotiveVideoDialog", 4, "[onClickChangeVideo] innerView is added");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMotiveVideoDialog.1
 * JD-Core Version:    0.7.0.1
 */