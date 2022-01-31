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
import java.util.Iterator;
import java.util.List;

public class bjta
  extends bjxl
{
  bcqf jdField_a_of_type_Bcqf;
  public bjtb a;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  
  public bjta(@NonNull bjxn parambjxn)
  {
    super(parambjxn);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Bjxn.b())
    {
      if (this.jdField_a_of_type_Bjxn.a()) {
        return 3;
      }
      return 4;
    }
    if (this.jdField_a_of_type_Bjxn.a()) {
      return 1;
    }
    return 2;
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_Bjyv.getActivity().getResources().getDisplayMetrics();
    int i = EditPicRawImage.a((BitmapFactory.Options)localObject, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    ((BitmapFactory.Options)localObject).inSampleSize = i;
    try
    {
      localObject = bbef.a(paramString, (BitmapFactory.Options)localObject);
      if (localObject == null)
      {
        QLog.e("EditJumpToPtu", 1, "decode" + null);
        this.jdField_a_of_type_Bjyv.a(0, null, 2130772028, 0);
        return null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Bitmap localBitmap;
      for (;;)
      {
        ved.e("EditJumpToPtu", "decodeoom");
        localBitmap = null;
      }
      ved.b("EditJumpToPtu", "sampleSize" + i + " w " + localBitmap.getWidth() + " h " + localBitmap.getHeight());
      i = bbef.b(paramString);
      paramString = localBitmap;
      if (i != 0)
      {
        paramString = localBitmap;
        if (i % 90 == 0)
        {
          ved.b("EditJumpToPtu", "has exif rotate" + i);
          int j = localBitmap.getWidth();
          int k = localBitmap.getHeight();
          paramString = new Matrix();
          paramString.postRotate(i, j / 2.0F, k / 2.0F);
          paramString = Bitmap.createBitmap(localBitmap, 0, 0, j, k, paramString, true);
        }
      }
      this.jdField_a_of_type_Bjtb.obtainMessage(2, paramString).sendToTarget();
    }
    return paramString;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Bjtb = new bjtb(this);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_Bjxn.a(0);
    Activity localActivity;
    if (paramInt1 == 100)
    {
      if (paramInt2 != -1) {
        break label181;
      }
      localActivity = this.jdField_a_of_type_Bjxn.a().getActivity();
      if (localActivity != null) {}
    }
    else
    {
      return;
    }
    ((bjcb)bjav.a(5)).a[a()].c(localActivity);
    if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidOsBundle != null) {
      this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidOsBundle.clear();
    }
    for (;;)
    {
      try
      {
        paramIntent = ((Uri)paramIntent.getParcelableExtra("android.intent.extra.STREAM")).toString();
        ved.b("EditJumpToPtu", "onActivityResult PI_TU, new path " + paramIntent);
        if (!TextUtils.isEmpty(paramIntent)) {
          ThreadManager.excute(new EditJumpToPtu.2(this, paramIntent), 64, null, true);
        }
        if (this.jdField_a_of_type_JavaLangString == null) {
          break;
        }
        gp.a(new File(this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_JavaLangString = null;
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        continue;
      }
      label181:
      ved.b("EditJumpToPtu", "onActivityResult cancel ");
    }
  }
  
  public void a(int paramInt, @NonNull bkld parambkld)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      parambkld = parambkld.a;
      parambkld.a += 1;
    }
  }
  
  void a(String paramString)
  {
    if (this.jdField_a_of_type_Bcqf == null) {
      this.jdField_a_of_type_Bcqf = new bcqf(a(), a().getDimensionPixelSize(2131298865));
    }
    this.jdField_a_of_type_Bcqf.a(paramString);
    this.jdField_a_of_type_Bcqf.setCancelable(false);
    this.jdField_a_of_type_Bcqf.show();
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
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjvt.a();
    if (localDoodleLayout != null)
    {
      Bitmap localBitmap3 = localDoodleLayout.a(0, false);
      Bitmap localBitmap2 = this.jdField_a_of_type_Bjxn.a();
      if (localBitmap2 == null) {
        return false;
      }
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap3 != null)
      {
        localBitmap1 = vxv.c(localBitmap2, localBitmap3);
        localDoodleLayout.a(localBitmap3);
      }
      return vxv.a(localBitmap1, paramString);
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
    vej.b("0X80080E2", vej.a);
    if (a(this.jdField_a_of_type_Bjyv.a()))
    {
      ThreadManager.post(new EditJumpToPtu.1(this), 5, null, true);
      a(ajya.a(2131703646));
      return;
    }
    vej.b("0X80080E4", vej.a);
    paramObject = new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserActivity");
    Intent localIntent = new Intent();
    localIntent.putExtra("url", "http://tu.qq.com/websites/guide/sticker.html");
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_editor");
    localIntent.setComponent(paramObject);
    this.jdField_a_of_type_Bjyv.getActivity().startActivityForResult(localIntent, 101);
  }
  
  void c()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
      this.jdField_a_of_type_Bcqf.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjta
 * JD-Core Version:    0.7.0.1
 */