package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.dataline.util.file.FileUtil;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureRecord;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.pm.PackageUtil;
import java.io.File;

public class EditJumpToPtu
  extends EditVideoPart
{
  public EditJumpToPtu.UIHandler a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  
  public EditJumpToPtu(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.d())
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()) {
        return 3;
      }
      return 4;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()) {
      return 1;
    }
    return 2;
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
    Object localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getResources().getDisplayMetrics();
    int i = EditPicRawImage.a((BitmapFactory.Options)localObject1, ((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
    ((BitmapFactory.Options)localObject1).inSampleSize = i;
    try
    {
      localObject1 = ImageUtil.a(paramString, (BitmapFactory.Options)localObject1);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label78:
      int j;
      int k;
      break label78;
    }
    SLog.e("EditJumpToPtu", "decodeoom");
    localObject1 = null;
    if (localObject1 == null)
    {
      paramString = new StringBuilder();
      paramString.append("decode");
      paramString.append(null);
      QLog.e("EditJumpToPtu", 1, paramString.toString());
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.finish(0, null, 2130772056, 0);
      return null;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("sampleSize");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(" w ");
    ((StringBuilder)localObject2).append(((Bitmap)localObject1).getWidth());
    ((StringBuilder)localObject2).append(" h ");
    ((StringBuilder)localObject2).append(((Bitmap)localObject1).getHeight());
    SLog.b("EditJumpToPtu", ((StringBuilder)localObject2).toString());
    i = ImageUtil.c(paramString);
    paramString = (String)localObject1;
    if (i != 0)
    {
      paramString = (String)localObject1;
      if (i % 90 == 0)
      {
        paramString = new StringBuilder();
        paramString.append("has exif rotate");
        paramString.append(i);
        SLog.b("EditJumpToPtu", paramString.toString());
        j = ((Bitmap)localObject1).getWidth();
        k = ((Bitmap)localObject1).getHeight();
        paramString = new Matrix();
        paramString.postRotate(i, j / 2.0F, k / 2.0F);
        paramString = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, j, k, paramString, true);
      }
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditJumpToPtu$UIHandler.obtainMessage(2, paramString).sendToTarget();
    return paramString;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditJumpToPtu$UIHandler = new EditJumpToPtu.UIHandler(this);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager;
    if (!EditVideoPartManager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c, 65536)) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
    }
    if (paramInt1 == 100)
    {
      if (paramInt2 == -1)
      {
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().getActivity();
        if (localObject == null) {
          return;
        }
        ((com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager)com.tencent.aelight.camera.aioeditor.capture.QIMManager.a(5)).a[a()].c((Activity)localObject);
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle != null) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.clear();
        }
        try
        {
          paramIntent = ((Uri)paramIntent.getParcelableExtra("android.intent.extra.STREAM")).toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onActivityResult PI_TU, new path ");
          ((StringBuilder)localObject).append(paramIntent);
          SLog.b("EditJumpToPtu", ((StringBuilder)localObject).toString());
          if (TextUtils.isEmpty(paramIntent)) {
            break label199;
          }
          ThreadManager.excute(new EditJumpToPtu.2(this, paramIntent), 64, null, true);
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
        }
      }
      else
      {
        SLog.b("EditJumpToPtu", "onActivityResult cancel ");
      }
      label199:
      paramIntent = this.jdField_a_of_type_JavaLangString;
      if (paramIntent != null)
      {
        FileUtil.a(new File(paramIntent));
        this.jdField_a_of_type_JavaLangString = null;
      }
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramGenerateContext = paramGenerateContext.a;
      paramGenerateContext.a += 1;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 10) {
      return;
    }
    VideoEditReport.b("0X80080E2", VideoEditReport.a);
    if (a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext()))
    {
      ThreadManager.post(new EditJumpToPtu.1(this), 5, null, true);
      a(HardCodeUtil.a(2131703798));
      return;
    }
    VideoEditReport.b("0X80080E4", VideoEditReport.a);
    paramObject = new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserActivity");
    Intent localIntent = new Intent();
    localIntent.putExtra("url", "https://tu.qq.com/websites/guide/sticker.html");
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_editor");
    localIntent.setComponent(paramObject);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().startActivityForResult(localIntent, 101);
  }
  
  void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(a(), a().getDimensionPixelSize(2131299168));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public boolean a(Context paramContext)
  {
    if (PackageUtil.a(paramContext, "com.tencent.ttpic")) {
      try
      {
        int i = PackageUtil.a(paramContext, "com.tencent.ttpic");
        if (i >= 490) {
          return true;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a();
    if (localDoodleLayout != null)
    {
      Bitmap localBitmap3 = localDoodleLayout.a(0, false);
      Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a();
      if (localBitmap2 == null) {
        return false;
      }
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap3 != null)
      {
        localBitmap1 = BitmapUtils.c(localBitmap2, localBitmap3);
        localDoodleLayout.a(localBitmap3);
      }
      return BitmapUtils.a(localBitmap1, paramString);
    }
    return false;
  }
  
  void b()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditJumpToPtu
 * JD-Core Version:    0.7.0.1
 */