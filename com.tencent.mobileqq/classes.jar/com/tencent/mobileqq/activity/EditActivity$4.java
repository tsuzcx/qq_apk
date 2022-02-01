package com.tencent.mobileqq.activity;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

class EditActivity$4
  implements View.OnClickListener
{
  EditActivity$4(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    if (this.a.d == 105)
    {
      Object localObject1 = this.a.a.getText();
      if (localObject1 != null)
      {
        localObject1 = localObject1.toString().trim();
        if (((String)localObject1).length() == 0)
        {
          localObject1 = this.a;
          QQToast.makeText((Context)localObject1, ((EditActivity)localObject1).getString(2131888899), 0).show();
        }
        else if (EditActivity.a(this.a, (String)localObject1))
        {
          localObject1 = this.a;
          QQToast.makeText((Context)localObject1, ((EditActivity)localObject1).getString(2131888900), 0).show();
        }
        else
        {
          Object localObject2 = (IFavroamingDBManagerService)this.a.app.getRuntimeService(IFavroamingDBManagerService.class);
          IFavroamingManagerService localIFavroamingManagerService = (IFavroamingManagerService)this.a.app.getRuntimeService(IFavroamingManagerService.class);
          localObject2 = ((IFavroamingDBManagerService)localObject2).getEmoticonDataList();
          if ((EditActivity.f(this.a) != -1) && (localObject2 != null))
          {
            localObject2 = ((List)localObject2).iterator();
            CustomEmotionData localCustomEmotionData;
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localCustomEmotionData = (CustomEmotionData)((Iterator)localObject2).next();
            } while (EditActivity.f(this.a) != localCustomEmotionData.emoId);
            EditActivity.g(this.a);
            localIFavroamingManagerService.updateCustomEmotionDataOCRReq(localCustomEmotionData, (String)localObject1);
          }
        }
      }
    }
    else
    {
      EditActivity.b(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditActivity.4
 * JD-Core Version:    0.7.0.1
 */