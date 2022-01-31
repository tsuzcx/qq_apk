package com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleLayout;
import com.tencent.qphone.base.util.QLog;

public class EditVideoSubtitle
  extends EditVideoPart
  implements EditSubtitleExport
{
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  public SubtitleLayout a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public EditVideoSubtitle(@NonNull EditVideoPartManager paramEditVideoPartManager, byte[] paramArrayOfByte)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.getVisibility() == paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.setVisibility(paramInt);
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.getVisibility() == paramInt));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.setVisibility(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131371905));
    QQStoryContext.a();
    QQStoryContext.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout == null)
    {
      SLog.b("Q.qqstory.publish.edit.Subtitle", "makeSureInitLayout");
      ViewParent localViewParent = this.jdField_a_of_type_AndroidViewViewStub.getParent();
      if ((localViewParent == null) || (!(localViewParent instanceof ViewGroup))) {
        break label95;
      }
    }
    label95:
    for (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout = ((SubtitleLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());; this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout = ((SubtitleLayout)a(2131362436)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.a(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.a(this.jdField_a_of_type_ArrayOfByte);
      a(EditSubtitleExport.class, this);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    a(0);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout == null) || (this.jdField_a_of_type_ArrayOfByte == null)) {
      SLog.d("Q.qqstory.publish.edit.Subtitle", "editVideoPrePublish but subtitle layout is null");
    }
    for (;;)
    {
      return;
      try
      {
        String str = Base64.encodeToString(this.jdField_a_of_type_ArrayOfByte, 0);
        if (!TextUtils.isEmpty(str))
        {
          paramGenerateContext.a.putExtra("subtitleData", str);
          QLog.e("Q.qqstory.publish.edit.Subtitle", 2, "subtitle base64 encode :" + str.length());
          return;
        }
      }
      catch (Exception paramGenerateContext)
      {
        QLog.e("Q.qqstory.publish.edit.Subtitle", 2, "subtitle base64 encode exception:" + paramGenerateContext.toString());
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.setTimeStamp(paramLong);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.a(paramMessage);
    }
    a(0);
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.Subtitle", 2, "videoplayer start");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.b();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.e();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.f();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout = null;
    }
    this.jdField_a_of_type_ArrayOfByte = null;
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.d();
    }
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoSubtitle
 * JD-Core Version:    0.7.0.1
 */