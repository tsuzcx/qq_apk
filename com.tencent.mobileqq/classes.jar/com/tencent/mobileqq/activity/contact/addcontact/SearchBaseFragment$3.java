package com.tencent.mobileqq.activity.contact.addcontact;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.widget.XListView;

class SearchBaseFragment$3
  implements IIconListener
{
  SearchBaseFragment$3(SearchBaseFragment paramSearchBaseFragment) {}
  
  public void onGetIcon(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (paramInt2 == 201) {
        return;
      }
      if (this.a.n == 0)
      {
        if (this.a.k == null) {
          return;
        }
        int i = this.a.k.getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          paramBitmap = this.a.k.getChildAt(paramInt2).getTag();
          if ((paramBitmap != null) && ((paramBitmap instanceof SearchBaseFragment.ItemViewHolder)))
          {
            paramBitmap = (SearchBaseFragment.ItemViewHolder)paramBitmap;
            if (paramBitmap.i == paramInt1) {
              this.a.a(paramBitmap, paramBitmap.l);
            }
          }
          paramInt2 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment.3
 * JD-Core Version:    0.7.0.1
 */