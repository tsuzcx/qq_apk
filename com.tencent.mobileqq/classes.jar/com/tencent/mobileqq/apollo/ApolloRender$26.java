package com.tencent.mobileqq.apollo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

final class ApolloRender$26
  implements Runnable
{
  ApolloRender$26(int paramInt, Intent paramIntent, View paramView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e("sava_ApolloRender", 2, "imageselector selectimagecallback ");
    }
    if (this.jdField_a_of_type_Int == -1)
    {
      Object localObject = (Bitmap)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("data");
      ByteBuffer localByteBuffer = ByteBuffer.allocate(((Bitmap)localObject).getByteCount());
      int i = ((Bitmap)localObject).getWidth();
      int j = ((Bitmap)localObject).getHeight();
      ((Bitmap)localObject).copyPixelsToBuffer(localByteBuffer);
      localObject = localByteBuffer.array();
      QLog.e("sava_ApolloRender", 2, "imageselector selectimageallback textureView  " + this.jdField_a_of_type_Int + " data: ");
      ((ApolloSurfaceView)this.jdField_a_of_type_AndroidViewView).getRender().getSavaWrapper().a(ApolloRender.access$900(), 1, i, j, (byte[])localObject);
      return;
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      ((ApolloSurfaceView)this.jdField_a_of_type_AndroidViewView).getRender().getSavaWrapper().a(ApolloRender.access$900(), 3, 0, 0, null);
      return;
    }
    ((ApolloSurfaceView)this.jdField_a_of_type_AndroidViewView).getRender().getSavaWrapper().a(ApolloRender.access$900(), 2, 0, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.26
 * JD-Core Version:    0.7.0.1
 */