package com.tencent.mobileqq.activity.aio.intimate.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.data.IntimateInfo.PrefetchMutualMarkInfo;
import com.tencent.widget.HorizontalListView;
import java.util.List;

class IntimateContentItemMutualMarkView$1$1
  implements Runnable
{
  IntimateContentItemMutualMarkView$1$1(IntimateContentItemMutualMarkView.1 param1, Bitmap paramBitmap1, Bitmap paramBitmap2) {}
  
  @RequiresApi(api=16)
  public void run()
  {
    if ((IntimateContentItemMutualMarkView.a(this.c.this$0) != null) && (IntimateContentItemMutualMarkView.FriendMaskAdapter.a(IntimateContentItemMutualMarkView.a(this.c.this$0)) != null))
    {
      int i = IntimateContentItemMutualMarkView.FriendMaskAdapter.a(IntimateContentItemMutualMarkView.a(this.c.this$0)).indexOf(this.c.a);
      RelativeLayout localRelativeLayout = (RelativeLayout)IntimateContentItemMutualMarkView.b(this.c.this$0).getChild(i);
      if (localRelativeLayout != null)
      {
        Object localObject = (ImageView)localRelativeLayout.findViewById(2131433795);
        if (this.c.a.type == 17) {
          ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
          ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        Bitmap localBitmap = this.a;
        if (localBitmap != null) {
          ((ImageView)localObject).setImageBitmap(localBitmap);
        }
        localObject = this.b;
        if (localObject != null) {
          localRelativeLayout.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemMutualMarkView.1.1
 * JD-Core Version:    0.7.0.1
 */