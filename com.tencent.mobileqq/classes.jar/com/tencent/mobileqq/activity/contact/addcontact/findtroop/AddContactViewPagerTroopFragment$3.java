package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.RefreshDataListener;
import com.tencent.widget.XListView;

class AddContactViewPagerTroopFragment$3
  implements AddContactFindTroopRTLW.onRefreshCallback
{
  AddContactViewPagerTroopFragment$3(AddContactViewPagerTroopFragment paramAddContactViewPagerTroopFragment) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((this.a.v) && (AddContactViewPagerTroopFragment.a(this.a) != null)) {
      AddContactViewPagerTroopFragment.b(this.a).a(this.a.i(), paramBoolean, null);
    }
    if (paramBoolean)
    {
      if (paramInt > 0)
      {
        this.a.h.setVisibility(8);
        this.a.a.setVisibility(0);
        return;
      }
      this.a.h.setVisibility(0);
      this.a.a.setVisibility(8);
      Object localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20191206115411_QbbYvjs7gs.png", null);
      if ((localObject != null) && (1 != ((URLDrawable)localObject).getStatus())) {
        ((URLDrawable)localObject).restartDownload();
      }
      this.a.i.setImageDrawable((Drawable)localObject);
      this.a.j.setText(2131886271);
      this.a.k.setText(2131886275);
      this.a.l.setText(2131886272);
      this.a.l.setOnTouchListener(this.a.m);
      this.a.l.setOnClickListener(new AddContactViewPagerTroopFragment.3.1(this));
      localObject = this.a.h.getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).setBackgroundResource(2130839577);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment.3
 * JD-Core Version:    0.7.0.1
 */