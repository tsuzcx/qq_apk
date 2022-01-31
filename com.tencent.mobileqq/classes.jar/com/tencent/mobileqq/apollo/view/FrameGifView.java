package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import ywl;

public class FrameGifView
  extends ImageView
  implements SimpleFrameZipDecoder.onFrameDecodeListener
{
  FrameGifView.AnimationListener jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView$AnimationListener;
  protected QQFrameZipDecoder a;
  private ywl jdField_a_of_type_Ywl = new ywl();
  
  public FrameGifView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder = new QQFrameZipDecoder(this);
  }
  
  public FrameGifView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder = new QQFrameZipDecoder(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView$AnimationListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView$AnimationListener.a();
    }
  }
  
  public void a(int paramInt, Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder != null) {
      return this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder.a();
    }
    return 0;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder.a();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder.b();
    }
  }
  
  public void setAnimaListener(FrameGifView.AnimationListener paramAnimationListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView$AnimationListener = paramAnimationListener;
  }
  
  public void setGifData(int paramInt, Drawable paramDrawable, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (getDrawable() == null) {
      super.setImageDrawable(paramDrawable);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder != null)
    {
      this.jdField_a_of_type_Ywl.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder, paramInt, paramString1, paramString2, paramBoolean);
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_Ywl);
      ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_Ywl);
    }
  }
  
  public void setPlayLoop(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.FrameGifView
 * JD-Core Version:    0.7.0.1
 */