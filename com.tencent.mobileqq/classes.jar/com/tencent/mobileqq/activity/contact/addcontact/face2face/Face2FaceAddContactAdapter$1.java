package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;

class Face2FaceAddContactAdapter$1
  implements DecodeTaskCompletionListener
{
  Face2FaceAddContactAdapter$1(Face2FaceAddContactAdapter paramFace2FaceAddContactAdapter) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramInt2 = Face2FaceAddContactAdapter.b(this.a).getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = Face2FaceAddContactAdapter.b(this.a).getChildViewHolder(Face2FaceAddContactAdapter.b(this.a).getChildAt(paramInt1));
        if ((localObject instanceof Face2FaceAddContactAdapter.AvatarViewHolder))
        {
          localObject = (Face2FaceAddContactAdapter.AvatarViewHolder)localObject;
          if (((Face2FaceAddContactAdapter.AvatarViewHolder)localObject).a.equals(paramString)) {
            ((Face2FaceAddContactAdapter.AvatarViewHolder)localObject).b.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactAdapter.1
 * JD-Core Version:    0.7.0.1
 */