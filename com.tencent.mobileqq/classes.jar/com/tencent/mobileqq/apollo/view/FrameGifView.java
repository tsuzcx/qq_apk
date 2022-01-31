package com.tencent.mobileqq.apollo.view;

import alnr;
import alnu;
import alnz;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class FrameGifView
  extends ImageView
  implements alnz
{
  alnr jdField_a_of_type_Alnr;
  protected alnu a;
  private FrameGifView.DecoderRunnable jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView$DecoderRunnable = new FrameGifView.DecoderRunnable();
  
  public FrameGifView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Alnu = new alnu(this);
  }
  
  public FrameGifView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Alnu = new alnu(this);
  }
  
  public FrameGifView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Alnu = new alnu(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Alnr != null) {
      this.jdField_a_of_type_Alnr.a();
    }
  }
  
  public void a(int paramInt, Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Alnu != null) {
      return this.jdField_a_of_type_Alnu.a();
    }
    return 0;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Alnu != null) {
      this.jdField_a_of_type_Alnu.a();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Alnu != null) {
      this.jdField_a_of_type_Alnu.b();
    }
  }
  
  public void setAnimaListener(alnr paramalnr)
  {
    this.jdField_a_of_type_Alnr = paramalnr;
  }
  
  public void setGifData(int paramInt, Drawable paramDrawable, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (getDrawable() == null) {
      super.setImageDrawable(paramDrawable);
    }
    if (this.jdField_a_of_type_Alnu != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView$DecoderRunnable.a(this.jdField_a_of_type_Alnu, paramInt, paramString1, paramString2, paramBoolean);
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView$DecoderRunnable);
      ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView$DecoderRunnable);
    }
  }
  
  public void setPlayLoop(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Alnu != null) {
      this.jdField_a_of_type_Alnu.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.FrameGifView
 * JD-Core Version:    0.7.0.1
 */