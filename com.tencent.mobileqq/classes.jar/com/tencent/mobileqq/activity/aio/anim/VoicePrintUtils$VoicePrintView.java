package com.tencent.mobileqq.activity.aio.anim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.vas.ui.VipPngPlayAnimationDrawable;

public class VoicePrintUtils$VoicePrintView
  extends ImageView
{
  public int a;
  BitmapFactory.Options jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
  private VoicePrintUtils.VoicePrintDrawable jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintDrawable;
  private BubbleInfo.CommonAttrs jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs;
  private VipPngPlayAnimationDrawable jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  public int c;
  public int d;
  
  public VoicePrintUtils$VoicePrintView(Context paramContext)
  {
    super(paramContext);
    paramContext = this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options;
    paramContext.inDensity = 320;
    paramContext.inTargetDensity = getResources().getDisplayMetrics().densityDpi;
  }
  
  private boolean a()
  {
    Object localObject = (Bitmap)GlobalImageCache.a.get(this.jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      if (localLayoutParams.height > ((Bitmap)localObject).getHeight())
      {
        localLayoutParams.height = ((Bitmap)localObject).getHeight();
        this.b = ((Bitmap)localObject).getHeight();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintDrawable.a((Bitmap)localObject, this.jdField_a_of_type_Int);
      localObject = this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable;
      ((VipPngPlayAnimationDrawable)localObject).f = this.jdField_a_of_type_Int;
      ((VipPngPlayAnimationDrawable)localObject).g = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintDrawable.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      localObject = this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable;
      ((VipPngPlayAnimationDrawable)localObject).i = this.jdField_a_of_type_Int;
      ((VipPngPlayAnimationDrawable)localObject).j = this.b;
      ((VipPngPlayAnimationDrawable)localObject).a(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.a, this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.c);
      localObject = this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable;
      ((VipPngPlayAnimationDrawable)localObject).h = -1;
      ((VipPngPlayAnimationDrawable)localObject).c = this.jdField_a_of_type_Boolean;
      return true;
    }
    return false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintDrawable);
      return;
    }
    setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable);
  }
  
  public void setBitmap(BubbleInfo.CommonAttrs paramCommonAttrs, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintDrawable = new VoicePrintUtils.VoicePrintDrawable();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintDrawable.jdField_a_of_type_Int = (paramInt1 + paramInt3 + paramInt4);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_JavaLangString = paramCommonAttrs.a[0];
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs = paramCommonAttrs;
    setPadding(paramInt3, 0, paramInt4, 0);
    this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable = new VipPngPlayAnimationDrawable(getResources());
    if (!a()) {
      new VoicePrintUtils.VoicePrintView.DecodePngTask(this).execute(new String[] { this.jdField_a_of_type_JavaLangString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintView
 * JD-Core Version:    0.7.0.1
 */