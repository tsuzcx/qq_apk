package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.EditText;
import ayki;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem.PicData;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem.ReadInJoyDraftboxContent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pbg;

class ReadInJoyDeliverUGCActivity$6
  implements Runnable
{
  ReadInJoyDeliverUGCActivity$6(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void run()
  {
    if (ReadInJoyDeliverUGCActivity.b(this.this$0) != null)
    {
      ReadInJoyDeliverUGCActivity.a(this.this$0, ReadInJoyDeliverUGCActivity.c(this.this$0).topicId);
      ReadInJoyDeliverUGCActivity.b(this.this$0, ReadInJoyDeliverUGCActivity.d(this.this$0).adTag);
      ReadInJoyDeliverUGCActivity.b(this.this$0, ReadInJoyDeliverUGCActivity.e(this.this$0).ugcEditCookie);
      ReadInJoyDeliverUGCActivity.a(this.this$0, ReadInJoyDeliverUGCActivity.f(this.this$0).multiBiuStruct);
      if ((ReadInJoyDeliverUGCActivity.g(this.this$0).adapterList != null) && (ReadInJoyDeliverUGCActivity.h(this.this$0).adapterList.size() > 0))
      {
        localObject = new ArrayList();
        Iterator localIterator = ReadInJoyDeliverUGCActivity.i(this.this$0).adapterList.iterator();
        while (localIterator.hasNext())
        {
          ReadInJoyDraftboxItem.PicData localPicData = (ReadInJoyDraftboxItem.PicData)localIterator.next();
          if (localPicData != null) {
            if (localPicData.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null) {
              ((List)localObject).add(localPicData.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData);
            } else if ((!TextUtils.isEmpty(localPicData.jdField_a_of_type_JavaLangString)) && (new File(localPicData.jdField_a_of_type_JavaLangString).exists())) {
              ((List)localObject).add(localPicData.jdField_a_of_type_JavaLangString);
            }
          }
        }
        if (((List)localObject).size() > 0) {
          ReadInJoyDeliverUGCActivity.a(this.this$0, (List)localObject);
        }
      }
      int i = this.this$0.getResources().getDisplayMetrics().widthPixels;
      int j = ReadInJoyDeliverUGCActivity.a(this.this$0).getPaddingLeft();
      int k = ReadInJoyDeliverUGCActivity.b(this.this$0).getPaddingRight();
      Object localObject = ReadInJoyDeliverUGCActivity.c(this.this$0).a(ReadInJoyDeliverUGCActivity.j(this.this$0).multiBiuStruct, this.this$0.getBaseContext(), ReadInJoyDeliverUGCActivity.c(this.this$0), i - j - k);
      if (localObject != null)
      {
        ReadInJoyDeliverUGCActivity.d(this.this$0).getEditableText().clear();
        ReadInJoyDeliverUGCActivity.e(this.this$0).getEditableText().insert(0, new ayki((CharSequence)localObject, 7));
      }
      if ((ReadInJoyDeliverUGCActivity.a(this.this$0) > 0) || (ReadInJoyDeliverUGCActivity.f(this.this$0).getText().toString().length() > 0)) {
        ReadInJoyDeliverUGCActivity.a(this.this$0, true);
      }
    }
    else
    {
      return;
    }
    ReadInJoyDeliverUGCActivity.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity.6
 * JD-Core Version:    0.7.0.1
 */