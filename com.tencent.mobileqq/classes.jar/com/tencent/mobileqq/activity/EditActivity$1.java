package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.widget.QQToast;

class EditActivity$1
  extends FavEmoRoamingObserver
{
  EditActivity$1(EditActivity paramEditActivity) {}
  
  protected void onModifyFavData(boolean paramBoolean, Object paramObject)
  {
    EditActivity.a(this.a);
    if (paramBoolean)
    {
      paramObject = (CustomEmotionData)paramObject;
      if (paramObject != null)
      {
        ((IFavroamingManagerService)this.a.app.getRuntimeService(IFavroamingManagerService.class)).updateCustomEmotionDataOCR(paramObject);
        EditActivity.b(this.a);
      }
    }
    else if ((paramObject instanceof String))
    {
      QQToast.makeText(this.a, 1, (String)paramObject, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditActivity.1
 * JD-Core Version:    0.7.0.1
 */