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

public class bibm
  extends bifz
{
  bbms jdField_a_of_type_Bbms;
  public bibn a;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  
  public bibm(@NonNull bigb parambigb)
  {
    super(parambigb);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Bigb.b())
    {
      if (this.jdField_a_of_type_Bigb.a()) {
        return 3;
      }
      return 4;
    }
    if (this.jdField_a_of_type_Bigb.a()) {
      return 1;
    }
    return 2;
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_Bihj.getActivity().getResources().getDisplayMetrics();
    int i = EditPicRawImage.a((BitmapFactory.Options)localObject, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    ((BitmapFactory.Options)localObject).inSampleSize = i;
    try
    {
      localObject = bacm.a(paramString, (BitmapFactory.Options)localObject);
      if (localObject == null)
      {
        QLog.e("EditJumpToPtu", 1, "decode" + null);
        this.jdField_a_of_type_Bihj.a(0, null, 2130772028, 0);
        return null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Bitmap localBitmap;
      for (;;)
      {
        urk.e("EditJumpToPtu", "decodeoom");
        localBitmap = null;
      }
      urk.b("EditJumpToPtu", "sampleSize" + i + " w " + localBitmap.getWidth() + " h " + localBitmap.getHeight());
      i = bacm.b(paramString);
      paramString = localBitmap;
      if (i != 0)
      {
        paramString = localBitmap;
        if (i % 90 == 0)
        {
          urk.b("EditJumpToPtu", "has exif rotate" + i);
          int j = localBitmap.getWidth();
          int k = localBitmap.getHeight();
          paramString = new Matrix();
          paramString.postRotate(i, j / 2.0F, k / 2.0F);
          paramString = Bitmap.createBitmap(localBitmap, 0, 0, j, k, paramString, true);
        }
      }
      this.jdField_a_of_type_Bibn.obtainMessage(2, paramString).sendToTarget();
    }
    return paramString;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Bibn = new bibn(this);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_Bigb.a(0);
    Activity localActivity;
    if (paramInt1 == 100)
    {
      if (paramInt2 != -1) {
        break label181;
      }
      localActivity = this.jdField_a_of_type_Bigb.a().getActivity();
      if (localActivity != null) {}
    }
    else
    {
      return;
    }
    ((bhgs)bhfm.a(5)).a[a()].c(localActivity);
    if (this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidOsBundle != null) {
      this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidOsBundle.clear();
    }
    for (;;)
    {
      try
      {
        paramIntent = ((Uri)paramIntent.getParcelableExtra("android.intent.extra.STREAM")).toString();
        urk.b("EditJumpToPtu", "onActivityResult PI_TU, new path " + paramIntent);
        if (!TextUtils.isEmpty(paramIntent)) {
          ThreadManager.excute(new EditJumpToPtu.2(this, paramIntent), 64, null, true);
        }
        if (this.jdField_a_of_type_JavaLangString == null) {
          break;
        }
        ew.a(new File(this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_JavaLangString = null;
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        continue;
      }
      label181:
      urk.b("EditJumpToPtu", "onActivityResult cancel ");
    }
  }
  
  public void a(int paramInt, @NonNull bitz parambitz)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      parambitz = parambitz.a;
      parambitz.a += 1;
    }
  }
  
  void a(String paramString)
  {
    if (this.jdField_a_of_type_Bbms == null) {
      this.jdField_a_of_type_Bbms = new bbms(a(), a().getDimensionPixelSize(2131167766));
    }
    this.jdField_a_of_type_Bbms.a(paramString);
    this.jdField_a_of_type_Bbms.setCancelable(false);
    this.jdField_a_of_type_Bbms.show();
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
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_Bigb.jdField_a_of_type_Bief.a();
    if (localDoodleLayout != null)
    {
      Bitmap localBitmap3 = localDoodleLayout.a(0, false);
      Bitmap localBitmap2 = this.jdField_a_of_type_Bigb.a();
      if (localBitmap2 == null) {
        return false;
      }
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap3 != null)
      {
        localBitmap1 = vlc.c(localBitmap2, localBitmap3);
        localDoodleLayout.a(localBitmap3);
      }
      return vlc.a(localBitmap1, paramString);
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
    urq.b("0X80080E2", urq.a);
    if (a(this.jdField_a_of_type_Bihj.a()))
    {
      ThreadManager.post(new EditJumpToPtu.1(this), 5, null, true);
      a(ajjy.a(2131637850));
      return;
    }
    urq.b("0X80080E4", urq.a);
    paramObject = new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserActivity");
    Intent localIntent = new Intent();
    localIntent.putExtra("url", "http://tu.qq.com/websites/guide/sticker.html");
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_editor");
    localIntent.setComponent(paramObject);
    this.jdField_a_of_type_Bihj.getActivity().startActivityForResult(localIntent, 101);
  }
  
  void c()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
      this.jdField_a_of_type_Bbms.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bibm
 * JD-Core Version:    0.7.0.1
 */