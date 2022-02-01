package com.tencent.mobileqq.activity.chathistory;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import java.util.List;

class TroopMemberHistoryFragment$3
  implements Handler.Callback
{
  TroopMemberHistoryFragment$3(TroopMemberHistoryFragment paramTroopMemberHistoryFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      switch (paramMessage.arg2)
      {
      default: 
        break;
      case 12: 
        if (paramMessage.arg1 == 20)
        {
          this.a.j.setText(2131895366);
          this.a.i.setVisibility(0);
        }
        break;
      case 11: 
        if (paramMessage.arg1 == 20)
        {
          this.a.j.setText(HardCodeUtil.a(2131912896));
          paramMessage = TroopMemberHistoryFragment.a(this.a).getContext().getResources();
          Object localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.b(320.0F, paramMessage);
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.b(177.5F, paramMessage);
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
          paramMessage = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171229/e4f73825907a4cdeb29db9c6688cd82c.png", (URLDrawable.URLDrawableOptions)localObject);
          localObject = (ImageView)this.a.i.findViewById(2131447324);
          ((ImageView)localObject).setImageDrawable(paramMessage);
          ((ImageView)localObject).setVisibility(0);
          this.a.i.setVisibility(0);
        }
        break;
      case 10: 
        if ((paramMessage.obj instanceof List))
        {
          this.a.k.a((List)paramMessage.obj);
          this.a.k.notifyDataSetChanged();
        }
        if (paramMessage.arg1 == 20) {
          this.a.i.setVisibility(8);
        }
        break;
      }
      this.a.c = false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment.3
 * JD-Core Version:    0.7.0.1
 */