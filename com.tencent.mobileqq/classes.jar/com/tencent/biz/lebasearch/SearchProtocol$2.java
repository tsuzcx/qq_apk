package com.tencent.biz.lebasearch;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResponseBody;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResultItem;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResultItemGroup;
import com.tencent.mobileqq.kandian.biz.search.entity.WordItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

final class SearchProtocol$2
  implements BusinessObserver
{
  SearchProtocol$2(Handler paramHandler) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        localObject = new mobileqq_dynamic_search.ResponseBody();
      }
    }
    for (;;)
    {
      try
      {
        ((mobileqq_dynamic_search.ResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((mobileqq_dynamic_search.ResponseBody)localObject).retcode.get();
        if (paramInt != 0)
        {
          if (!QLog.isColorLevel()) {
            break label482;
          }
          paramBundle = new StringBuilder();
          paramBundle.append("retcode:");
          paramBundle.append(paramInt);
          QLog.d("lebasearch.SearchProtocol", 2, paramBundle.toString());
          return;
        }
        if ((((mobileqq_dynamic_search.ResponseBody)localObject).item_groups.has()) && (((mobileqq_dynamic_search.ResultItemGroup)((mobileqq_dynamic_search.ResponseBody)localObject).item_groups.get(0)).result_items.has()))
        {
          paramBundle = ((mobileqq_dynamic_search.ResultItemGroup)((mobileqq_dynamic_search.ResponseBody)localObject).item_groups.get(0)).result_items.get();
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = paramBundle.iterator();
          if (localIterator.hasNext())
          {
            mobileqq_dynamic_search.ResultItem localResultItem = (mobileqq_dynamic_search.ResultItem)localIterator.next();
            WordItem localWordItem = new WordItem();
            if (!localResultItem.word.has()) {
              continue;
            }
            localWordItem.word = localResultItem.word.get().toStringUtf8();
            localWordItem.id = localResultItem.result_id.get().toStringUtf8();
            if (localResultItem.extension.has())
            {
              localObject = localResultItem.extension.get().toStringUtf8();
              if (QLog.isColorLevel())
              {
                paramBundle = new StringBuilder();
                paramBundle.append("extension info:");
                paramBundle.append((String)localObject);
                QLog.d("lebasearch.SearchProtocol", 2, paramBundle.toString());
              }
              paramBoolean = TextUtils.isEmpty((CharSequence)localObject);
              if (!paramBoolean)
              {
                paramBundle = null;
                try
                {
                  localObject = new JSONObject((String)localObject);
                  paramBundle = (Bundle)localObject;
                }
                catch (JSONException localJSONException)
                {
                  localJSONException.printStackTrace();
                }
                paramInt = paramBundle.optInt("type");
                if ((paramInt == 2) && (localResultItem.jmp_url.has()) && (!TextUtils.isEmpty(localResultItem.jmp_url.get().toStringUtf8())))
                {
                  localWordItem.type = paramInt;
                  localWordItem.jumpUrl = localResultItem.jmp_url.get().toStringUtf8();
                  paramInt = SearchProtocol.a(paramBundle.optString("color"));
                  if (paramInt == 0) {
                    break label492;
                  }
                  localWordItem.textColor = paramInt;
                  localWordItem.frameColor = SearchProtocol.a(paramBundle.optString("framecolor"));
                }
              }
            }
            localArrayList.add(localWordItem);
            continue;
          }
          paramBundle = this.a.obtainMessage();
          paramBundle.arg1 = 0;
          paramBundle.obj = localArrayList;
          this.a.sendMessage(paramBundle);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("lebasearch.SearchProtocol", 2, paramBundle.getMessage());
        }
      }
      return;
      label482:
      return;
      if (paramBundle == null)
      {
        paramInt = 0;
        continue;
        label492:
        paramInt = -16734752;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.lebasearch.SearchProtocol.2
 * JD-Core Version:    0.7.0.1
 */