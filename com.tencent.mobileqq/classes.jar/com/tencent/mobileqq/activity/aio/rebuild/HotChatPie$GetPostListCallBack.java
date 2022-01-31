package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.HotChatPostListAdapter;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class HotChatPie$GetPostListCallBack
  implements HttpCgiAsyncTask.Callback
{
  int jdField_a_of_type_Int = 1;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference b;
  WeakReference c;
  WeakReference d;
  WeakReference e;
  
  public HotChatPie$GetPostListCallBack(Context paramContext, XListView paramXListView, HotChatPostListAdapter paramHotChatPostListAdapter, PullRefreshHeader paramPullRefreshHeader, TextView paramTextView, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.c = new WeakReference(paramXListView);
    this.b = new WeakReference(paramHotChatPostListAdapter);
    this.d = new WeakReference(paramPullRefreshHeader);
    this.e = new WeakReference(paramTextView);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPieQ.hotchat.aio_post_list_req", 2, paramException.getMessage());
    }
    paramException = (PullRefreshHeader)this.d.get();
    if ((paramException != null) && (paramException.getVisibility() == 0)) {
      paramException.a(1);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPieQ.hotchat.aio_post_list_req", 2, "result " + paramJSONObject);
    }
    XListView localXListView = (XListView)this.c.get();
    if (localXListView == null) {}
    HotChatPostListAdapter localHotChatPostListAdapter;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (TextView)this.e.get();
        } while (localObject == null);
        localHotChatPostListAdapter = (HotChatPostListAdapter)this.b.get();
      } while (localHotChatPostListAdapter == null);
      if ((paramJSONObject != null) && (paramJSONObject.optInt("retcode") == 0)) {
        break;
      }
      if (localXListView.getVisibility() == 8) {
        ((TextView)localObject).setText("网络繁忙，请稍后再试");
      }
      paramJSONObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (paramJSONObject == null);
    QQToast.a(paramJSONObject, 1, "网络繁忙，请稍后再试", 0).a();
    localHotChatPostListAdapter.a();
    return;
    ((TextView)localObject).setVisibility(8);
    localXListView.setVisibility(0);
    Object localObject = paramJSONObject.optJSONObject("result");
    label187:
    int j;
    if (this.jdField_a_of_type_Int == 1)
    {
      localHotChatPostListAdapter.b(((JSONObject)localObject).optJSONArray("posts"));
      j = paramJSONObject.optInt("retcode");
      paramJSONObject = (PullRefreshHeader)this.d.get();
      if ((paramJSONObject != null) && (paramJSONObject.getVisibility() == 0)) {
        if (j != 0) {
          break label306;
        }
      }
    }
    label306:
    for (int i = 0;; i = 1)
    {
      paramJSONObject.a(i);
      localXListView.springBackOverScrollHeaderView();
      if (j != 0) {
        break;
      }
      HotChatPie.j = System.currentTimeMillis();
      return;
      if (((JSONObject)localObject).optInt("isend") == 0)
      {
        localHotChatPostListAdapter.a(((JSONObject)localObject).optJSONArray("posts"));
        localHotChatPostListAdapter.a();
        break label187;
      }
      paramJSONObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramJSONObject != null) {
        QQToast.a(paramJSONObject, 2, "已加载完毕", 0).a();
      }
      localHotChatPostListAdapter.a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.GetPostListCallBack
 * JD-Core Version:    0.7.0.1
 */