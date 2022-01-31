package com.tencent.mobileqq.activity.aio.anim;

import aerf;
import aerg;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import ansg;
import com.tencent.common.app.BaseApplicationImpl;

public class VoicePrintUtils$VoicePrintView
  extends ImageView
{
  public int a;
  private aerf jdField_a_of_type_Aerf;
  public BitmapFactory.Options a;
  private ansg jdField_a_of_type_Ansg;
  private VipPngPlayAnimationDrawable jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  public int c;
  public int d;
  
  public VoicePrintUtils$VoicePrintView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inDensity = 320;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inTargetDensity = getResources().getDisplayMetrics().densityDpi;
  }
  
  private boolean a()
  {
    Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(this.jdField_a_of_type_JavaLangString);
    if (localBitmap != null)
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      if (localLayoutParams.height > localBitmap.getHeight())
      {
        localLayoutParams.height = localBitmap.getHeight();
        this.b = localBitmap.getHeight();
      }
      this.jdField_a_of_type_Aerf.a(localBitmap, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.d = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.e = this.jdField_a_of_type_Aerf.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.g = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.h = this.b;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a(this.jdField_a_of_type_Ansg.a, this.jdField_a_of_type_Ansg.c);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.f = -1;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.c = this.jdField_a_of_type_Boolean;
      return true;
    }
    return false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setImageDrawable(this.jdField_a_of_type_Aerf);
      return;
    }
    setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable);
  }
  
  public void setBitmap(ansg paramansg, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Aerf = new aerf();
    this.jdField_a_of_type_Aerf.jdField_a_of_type_Int = (paramInt1 + paramInt3 + paramInt4);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_JavaLangString = paramansg.a[0];
    this.jdField_a_of_type_Ansg = paramansg;
    setPadding(paramInt3, 0, paramInt4, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable = new VipPngPlayAnimationDrawable(getResources());
    if (!a()) {
      new aerg(this).execute(new String[] { this.jdField_a_of_type_JavaLangString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintView
 * JD-Core Version:    0.7.0.1
 */