package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.dataline.util.file.FileUtil;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import obd;
import obe;

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
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditJumpToPtu$UIHandler = new EditJumpToPtu.UIHandler(this);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    if ((paramInt1 != 100) || (paramInt2 == -1)) {}
    for (;;)
    {
      try
      {
        paramIntent = ((Uri)paramIntent.getParcelableExtra("android.intent.extra.STREAM")).toString();
        SLog.b("EditJumpToPtu", "onActivityResult PI_TU, new path " + paramIntent);
        if (!TextUtils.isEmpty(paramIntent)) {
          ThreadManager.post(new obe(this, paramIntent), 5, null, true);
        }
        if (this.jdField_a_of_type_JavaLangString != null)
        {
          FileUtil.a(new File(this.jdField_a_of_type_JavaLangString));
          this.jdField_a_of_type_JavaLangString = null;
        }
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        continue;
      }
      SLog.b("EditJumpToPtu", "onActivityResult cancel ");
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
    switch (paramInt)
    {
    default: 
      return;
    }
    VideoEditReport.b("0X80080E2", VideoEditReport.a);
    if (a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a()))
    {
      ThreadManager.post(new obd(this), 5, null, true);
      b("请稍候");
      return;
    }
    VideoEditReport.b("0X80080E4", VideoEditReport.a);
    paramObject = new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserActivity");
    Intent localIntent = new Intent();
    localIntent.putExtra("url", "http://tu.qq.com/websites/guide/sticker.html");
    localIntent.setComponent(paramObject);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().startActivityForResult(localIntent, 101);
  }
  
  public void a(String paramString)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getResources().getDisplayMetrics();
    int i = EditPicRawImage.a((BitmapFactory.Options)localObject, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    ((BitmapFactory.Options)localObject).inSampleSize = i;
    try
    {
      localObject = ImageUtil.a(paramString, (BitmapFactory.Options)localObject);
      if (localObject == null)
      {
        QLog.e("EditJumpToPtu", 1, "decode" + null);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(0, null, 2131034158, 0);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Bitmap localBitmap;
      for (;;)
      {
        SLog.e("EditJumpToPtu", "decodeoom");
        localBitmap = null;
      }
      SLog.b("EditJumpToPtu", "sampleSize" + i + " w " + localBitmap.getWidth() + " h " + localBitmap.getHeight());
      i = ImageUtil.a(paramString);
      paramString = localBitmap;
      if (i != 0)
      {
        paramString = localBitmap;
        if (i % 90 == 0)
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.b = i;
          }
          SLog.b("EditJumpToPtu", "has exif rotate" + i);
          int j = localBitmap.getWidth();
          int k = localBitmap.getHeight();
          paramString = new Matrix();
          paramString.postRotate(i, j / 2.0F, k / 2.0F);
          paramString = Bitmap.createBitmap(localBitmap, 0, 0, j, k, paramString, true);
        }
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditJumpToPtu$UIHandler.obtainMessage(2, paramString).sendToTarget();
    }
  }
  
  public boolean a(Context paramContext)
  {
    paramContext = paramContext.getPackageManager().getInstalledPackages(0);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        PackageInfo localPackageInfo = (PackageInfo)paramContext.next();
        if ("com.tencent.ttpic".equals(localPackageInfo.packageName)) {
          if (localPackageInfo.versionCode >= 490) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle.a();
    Bitmap localBitmap3 = localDoodleLayout.b(0);
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a();
    boolean bool1;
    if (localBitmap2 == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        Bitmap localBitmap1 = localBitmap2;
        if (localBitmap3 != null) {
          localBitmap1 = BitmapUtils.b(localBitmap2, localBitmap3);
        }
        bool2 = BitmapUtils.a(localBitmap1, paramString);
        bool1 = bool2;
      } while (localDoodleLayout == null);
      bool1 = bool2;
    } while (localBitmap3 == null);
    localDoodleLayout.a(localBitmap3);
    return bool2;
  }
  
  void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(a(), a().getDimensionPixelSize(2131558448));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditJumpToPtu
 * JD-Core Version:    0.7.0.1
 */