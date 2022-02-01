package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
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
    Object localObject1;
    if (this.a.jdField_a_of_type_Int == 105)
    {
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText();
      if (localObject1 != null)
      {
        localObject1 = localObject1.toString().trim();
        if (((String)localObject1).length() != 0) {
          break label78;
        }
        QQToast.a(this.a, this.a.getString(2131692011), 0).a();
        break label180;
      }
    }
    label180:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label78:
      if (EditActivity.a(this.a, (String)localObject1))
      {
        QQToast.a(this.a, this.a.getString(2131692012), 0).a();
      }
      else
      {
        Object localObject2 = (FavroamingDBManager)this.a.app.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
        FavroamingManager localFavroamingManager = (FavroamingManager)this.a.app.getManager(QQManagerFactory.FAV_ROAMING_MANAGER);
        localObject2 = ((FavroamingDBManager)localObject2).a();
        if ((EditActivity.a(this.a) != -1) && (localObject2 != null))
        {
          localObject2 = ((List)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject2).next();
            if (EditActivity.a(this.a) != localCustomEmotionData.emoId) {
              break;
            }
            EditActivity.c(this.a);
            localFavroamingManager.a(localCustomEmotionData, (String)localObject1);
            continue;
            EditActivity.b(this.a);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditActivity.4
 * JD-Core Version:    0.7.0.1
 */