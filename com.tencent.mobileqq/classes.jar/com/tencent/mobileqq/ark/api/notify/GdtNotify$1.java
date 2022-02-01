package com.tencent.mobileqq.ark.api.notify;

import android.graphics.Rect;
import android.view.View;
import com.tencent.ark.ark;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.api.UIViewUtils;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class GdtNotify$1
  implements Runnable
{
  GdtNotify$1(GdtNotify paramGdtNotify, JSONObject paramJSONObject, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      localObject1 = BaseActivity.sTopActivity;
      if ((localObject1 == null) || (((BaseActivity)localObject1).getChatFragment() == null)) {
        break label479;
      }
      localObject2 = ((BaseActivity)localObject1).getChatFragment();
      if (((ChatFragment)localObject2).a == null) {
        break label420;
      }
      localObject1 = ((ChatFragment)localObject2).a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      localJSONArray1 = new JSONArray();
      this.jdField_a_of_type_OrgJsonJSONObject.put("results", localJSONArray1);
      localObject2 = ((ChatFragment)localObject2).a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
      localJSONArray2 = new JSONObject(this.jdField_a_of_type_JavaLangString).optJSONArray("traceids");
      i = 0;
    }
    catch (Exception localException)
    {
      label653:
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        JSONArray localJSONArray1;
        JSONArray localJSONArray2;
        int i;
        Object localObject3;
        Object localObject4;
        JSONObject localJSONObject2;
        JSONObject localJSONObject1;
        label420:
        label479:
        continue;
        label535:
        i += 1;
      }
    }
    if (i < localJSONArray2.length())
    {
      localObject3 = localJSONArray2.optString(i);
      localObject4 = GdtNotify.a((List)localObject2, (String)localObject3);
      if (localObject4 == null) {
        break label653;
      }
      localJSONObject2 = new JSONObject();
      localJSONArray1.put(localJSONObject2);
      localJSONObject1 = new JSONObject();
      localJSONObject2.put("traceid", localObject3);
      localJSONObject2.put("rect", localJSONObject1);
      localObject3 = UIViewUtils.a((ChatMessage)localObject4, (ChatXListView)localObject1);
      if (localObject3 != null)
      {
        localObject3 = (ArkAppView)((View)localObject3).findViewById(2131362947);
        if (localObject3 != null)
        {
          localObject4 = UIViewUtils.a((View)localObject3);
          if (localObject4 != null)
          {
            localJSONObject1.put("left", UIUtils.a(((ArkAppView)localObject3).getContext(), ((Rect)localObject4).left));
            localJSONObject1.put("top", UIUtils.a(((ArkAppView)localObject3).getContext(), ((Rect)localObject4).top));
            localJSONObject1.put("right", UIUtils.a(((ArkAppView)localObject3).getContext(), ((Rect)localObject4).right));
            localJSONObject1.put("bottom", UIUtils.a(((ArkAppView)localObject3).getContext(), ((Rect)localObject4).bottom));
            break label653;
          }
          localJSONObject1.put("left", 0);
          localJSONObject1.put("top", 0);
          localJSONObject1.put("right", 0);
          localJSONObject1.put("bottom", 0);
          break label653;
        }
        localJSONObject1.put("left", 0);
        localJSONObject1.put("top", 0);
        localJSONObject1.put("right", 0);
        localJSONObject1.put("bottom", 0);
        break label653;
      }
      localJSONObject1.put("left", 0);
      localJSONObject1.put("top", 0);
      localJSONObject1.put("right", 0);
      localJSONObject1.put("bottom", 0);
      break label653;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("resultJson 0: ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_OrgJsonJSONObject.toString());
      QLog.d("GdtNotify", 2, ((StringBuilder)localObject1).toString());
      ark.arkNotify(this.b, "ad_query_cell_rect_callback", this.jdField_a_of_type_OrgJsonJSONObject.toString(), "json");
      break label535;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("resultJson 1: ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_OrgJsonJSONObject.toString());
      QLog.d("GdtNotify", 2, ((StringBuilder)localObject1).toString());
      ark.arkNotify(this.b, "ad_query_cell_rect_callback", this.jdField_a_of_type_OrgJsonJSONObject.toString(), "json");
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("resultJson 2: ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_OrgJsonJSONObject.toString());
    QLog.d("GdtNotify", 2, ((StringBuilder)localObject1).toString());
    ark.arkNotify(this.b, "ad_query_cell_rect_callback", this.jdField_a_of_type_OrgJsonJSONObject.toString(), "json");
    return;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("resultJson 3: ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_OrgJsonJSONObject.toString());
    QLog.d("GdtNotify", 2, ((StringBuilder)localObject1).toString());
    ark.arkNotify(this.b, "ad_query_cell_rect_callback", this.jdField_a_of_type_OrgJsonJSONObject.toString(), "json");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.notify.GdtNotify.1
 * JD-Core Version:    0.7.0.1
 */