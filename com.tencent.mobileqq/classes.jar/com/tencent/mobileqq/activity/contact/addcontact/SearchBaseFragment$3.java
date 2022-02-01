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
    if ((paramBitmap == null) || (paramInt2 == 201)) {}
    for (;;)
    {
      return;
      if ((this.a.e == 0) && (this.a.a != null))
      {
        int i = this.a.a.getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          paramBitmap = this.a.a.getChildAt(paramInt2).getTag();
          if ((paramBitmap != null) && ((paramBitmap instanceof SearchBaseFragment.ItemViewHolder)))
          {
            paramBitmap = (SearchBaseFragment.ItemViewHolder)paramBitmap;
            if (paramBitmap.jdField_a_of_type_Int == paramInt1) {
              this.a.a(paramBitmap, paramBitmap.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
            }
          }
          paramInt2 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment.3
 * JD-Core Version:    0.7.0.1
 */