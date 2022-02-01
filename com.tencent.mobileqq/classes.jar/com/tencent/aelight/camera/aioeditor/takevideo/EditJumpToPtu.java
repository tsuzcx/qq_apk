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
  QQProgressDialog b;
  public boolean c = false;
  private String d;
  
  public EditJumpToPtu(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  public void a()
  {
    super.a();
    this.a = new EditJumpToPtu.UIHandler(this);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject = this.t;
    if (!EditVideoPartManager.a(this.t.I.c, 65536)) {
      this.t.d(0);
    }
    if (paramInt1 == 100)
    {
      if (paramInt2 == -1)
      {
        localObject = this.t.M().getActivity();
        if (localObject == null) {
          return;
        }
        ((com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager)com.tencent.aelight.camera.aioeditor.capture.QIMManager.a(5)).o[c()].c((Activity)localObject);
        if (this.t.ad != null) {
          this.t.ad.clear();
        }
        try
        {
          paramIntent = ((Uri)paramIntent.getParcelableExtra("android.intent.extra.STREAM")).toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onActivityResult PI_TU, new path ");
          ((StringBuilder)localObject).append(paramIntent);
          SLog.b("EditJumpToPtu", ((StringBuilder)localObject).toString());
          if (TextUtils.isEmpty(paramIntent)) {
            break label198;
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
      label198:
      paramIntent = this.d;
      if (paramIntent != null)
      {
        FileUtil.a(new File(paramIntent));
        this.d = null;
      }
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    if (this.c)
    {
      paramGenerateContext = paramGenerateContext.l;
      paramGenerateContext.f += 1;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 10) {
      return;
    }
    VideoEditReport.b("0X80080E2", VideoEditReport.c);
    if (a(this.u.getContext()))
    {
      ThreadManager.post(new EditJumpToPtu.1(this), 5, null, true);
      c(HardCodeUtil.a(2131901745));
      return;
    }
    VideoEditReport.b("0X80080E4", VideoEditReport.c);
    paramObject = new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserActivity");
    Intent localIntent = new Intent();
    localIntent.putExtra("url", "https://tu.qq.com/websites/guide/sticker.html");
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_editor");
    localIntent.setComponent(paramObject);
    this.u.getActivity().startActivityForResult(localIntent, 101);
  }
  
  public boolean a(Context paramContext)
  {
    if (PackageUtil.d(paramContext, "com.tencent.ttpic")) {
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
    DoodleLayout localDoodleLayout = this.t.O.b();
    if (localDoodleLayout != null)
    {
      Bitmap localBitmap3 = localDoodleLayout.a(0, false);
      Bitmap localBitmap2 = this.t.H();
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
  
  public Bitmap b(String paramString)
  {
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
    Object localObject2 = this.u.getActivity().getResources().getDisplayMetrics();
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
      this.u.finish(0, null, 2130772081, 0);
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
    i = ImageUtil.h(paramString);
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
    this.a.obtainMessage(2, paramString).sendToTarget();
    return paramString;
  }
  
  public int c()
  {
    if (this.t.k())
    {
      if (this.t.j()) {
        return 3;
      }
      return 4;
    }
    if (this.t.j()) {
      return 1;
    }
    return 2;
  }
  
  void c(String paramString)
  {
    if (this.b == null) {
      this.b = new QQProgressDialog(u(), s().getDimensionPixelSize(2131299920));
    }
    this.b.a(paramString);
    this.b.setCancelable(false);
    this.b.show();
  }
  
  void d()
  {
    QQProgressDialog localQQProgressDialog = this.b;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.b.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditJumpToPtu
 * JD-Core Version:    0.7.0.1
 */