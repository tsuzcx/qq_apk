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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1;
import dov.com.tencent.biz.qqstory.takevideo.EditJumpToPtu.2;
import dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.io.File;

public class bmiw
  extends bmnh
{
  bety jdField_a_of_type_Bety;
  public bmix a;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  
  public bmiw(@NonNull bmnj parambmnj)
  {
    super(parambmnj);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Bmnj.b())
    {
      if (this.jdField_a_of_type_Bmnj.a()) {
        return 3;
      }
      return 4;
    }
    if (this.jdField_a_of_type_Bmnj.a()) {
      return 1;
    }
    return 2;
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_Bmor.getActivity().getResources().getDisplayMetrics();
    int i = EditPicRawImage.a((BitmapFactory.Options)localObject, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    ((BitmapFactory.Options)localObject).inSampleSize = i;
    try
    {
      localObject = bdhj.a(paramString, (BitmapFactory.Options)localObject);
      if (localObject == null)
      {
        QLog.e("EditJumpToPtu", 1, "decode" + null);
        this.jdField_a_of_type_Bmor.a(0, null, 2130772028, 0);
        return null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Bitmap localBitmap;
      for (;;)
      {
        wxe.e("EditJumpToPtu", "decodeoom");
        localBitmap = null;
      }
      wxe.b("EditJumpToPtu", "sampleSize" + i + " w " + localBitmap.getWidth() + " h " + localBitmap.getHeight());
      i = bdhj.b(paramString);
      paramString = localBitmap;
      if (i != 0)
      {
        paramString = localBitmap;
        if (i % 90 == 0)
        {
          wxe.b("EditJumpToPtu", "has exif rotate" + i);
          int j = localBitmap.getWidth();
          int k = localBitmap.getHeight();
          paramString = new Matrix();
          paramString.postRotate(i, j / 2.0F, k / 2.0F);
          paramString = Bitmap.createBitmap(localBitmap, 0, 0, j, k, paramString, true);
        }
      }
      this.jdField_a_of_type_Bmix.obtainMessage(2, paramString).sendToTarget();
    }
    return paramString;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Bmix = new bmix(this);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_Bmnj.a(0);
    Activity localActivity;
    if (paramInt1 == 100)
    {
      if (paramInt2 != -1) {
        break label181;
      }
      localActivity = this.jdField_a_of_type_Bmnj.a().getActivity();
      if (localActivity != null) {}
    }
    else
    {
      return;
    }
    ((blrx)blqr.a(5)).a[a()].c(localActivity);
    if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_AndroidOsBundle != null) {
      this.jdField_a_of_type_Bmnj.jdField_a_of_type_AndroidOsBundle.clear();
    }
    for (;;)
    {
      try
      {
        paramIntent = ((Uri)paramIntent.getParcelableExtra("android.intent.extra.STREAM")).toString();
        wxe.b("EditJumpToPtu", "onActivityResult PI_TU, new path " + paramIntent);
        if (!TextUtils.isEmpty(paramIntent)) {
          ThreadManager.excute(new EditJumpToPtu.2(this, paramIntent), 64, null, true);
        }
        if (this.jdField_a_of_type_JavaLangString == null) {
          break;
        }
        ey.a(new File(this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_JavaLangString = null;
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        continue;
      }
      label181:
      wxe.b("EditJumpToPtu", "onActivityResult cancel ");
    }
  }
  
  public void a(int paramInt, @NonNull bnaz parambnaz)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      parambnaz = parambnaz.a;
      parambnaz.a += 1;
    }
  }
  
  void a(String paramString)
  {
    if (this.jdField_a_of_type_Bety == null) {
      this.jdField_a_of_type_Bety = new bety(a(), a().getDimensionPixelSize(2131298914));
    }
    this.jdField_a_of_type_Bety.a(paramString);
    this.jdField_a_of_type_Bety.setCancelable(false);
    this.jdField_a_of_type_Bety.show();
  }
  
  public boolean a(Context paramContext)
  {
    if (bhtl.a(paramContext, "com.tencent.ttpic")) {
      try
      {
        int i = bhtl.a(paramContext, "com.tencent.ttpic");
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
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmlp.a();
    if (localDoodleLayout != null)
    {
      Bitmap localBitmap3 = localDoodleLayout.a(0, false);
      Bitmap localBitmap2 = this.jdField_a_of_type_Bmnj.a();
      if (localBitmap2 == null) {
        return false;
      }
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap3 != null)
      {
        localBitmap1 = xqw.c(localBitmap2, localBitmap3);
        localDoodleLayout.a(localBitmap3);
      }
      return xqw.a(localBitmap1, paramString);
    }
    return false;
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    wxk.b("0X80080E2", wxk.a);
    if (a(this.jdField_a_of_type_Bmor.a()))
    {
      ThreadManager.post(new EditJumpToPtu.1(this), 5, null, true);
      a(alud.a(2131704030));
      return;
    }
    wxk.b("0X80080E4", wxk.a);
    paramObject = new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserActivity");
    Intent localIntent = new Intent();
    localIntent.putExtra("url", "http://tu.qq.com/websites/guide/sticker.html");
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_editor");
    localIntent.setComponent(paramObject);
    this.jdField_a_of_type_Bmor.getActivity().startActivityForResult(localIntent, 101);
  }
  
  void c()
  {
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
      this.jdField_a_of_type_Bety.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmiw
 * JD-Core Version:    0.7.0.1
 */