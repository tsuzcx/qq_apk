package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.hotchat.api.IHotChatPostListAdapter;
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
  WeakReference<Context> a;
  WeakReference<IHotChatPostListAdapter> b;
  WeakReference<XListView> c;
  WeakReference<PullRefreshHeader> d;
  WeakReference<TextView> e;
  int f = 1;
  
  public HotChatPie$GetPostListCallBack(Context paramContext, XListView paramXListView, IHotChatPostListAdapter paramIHotChatPostListAdapter, PullRefreshHeader paramPullRefreshHeader, TextView paramTextView, int paramInt)
  {
    this.a = new WeakReference(paramContext);
    this.c = new WeakReference(paramXListView);
    this.b = new WeakReference(paramIHotChatPostListAdapter);
    this.d = new WeakReference(paramPullRefreshHeader);
    this.e = new WeakReference(paramTextView);
    this.f = paramInt;
  }
  
  public void a(Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat.aio_post_list_req", 2, paramException.getMessage());
    }
    paramException = (PullRefreshHeader)this.d.get();
    if ((paramException != null) && (paramException.getVisibility() == 0)) {
      paramException.a(1);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("result ");
      ((StringBuilder)localObject1).append(paramJSONObject);
      QLog.d("Q.hotchat.aio_post_list_req", 2, ((StringBuilder)localObject1).toString());
    }
    XListView localXListView = (XListView)this.c.get();
    if (localXListView == null) {
      return;
    }
    Object localObject2 = (TextView)this.e.get();
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = (IHotChatPostListAdapter)this.b.get();
    if (localObject1 == null) {
      return;
    }
    int i = 1;
    if ((paramJSONObject != null) && (paramJSONObject.optInt("retcode") == 0))
    {
      ((TextView)localObject2).setVisibility(8);
      localXListView.setVisibility(0);
      localObject2 = paramJSONObject.optJSONObject("result");
      if (this.f == 1)
      {
        ((IHotChatPostListAdapter)localObject1).setListItemsAndNotify(((JSONObject)localObject2).optJSONArray("posts"));
      }
      else
      {
        if (((JSONObject)localObject2).optInt("isend") != 0) {
          break label246;
        }
        ((IHotChatPostListAdapter)localObject1).joinListItemsAndNotify(((JSONObject)localObject2).optJSONArray("posts"));
        ((IHotChatPostListAdapter)localObject1).setPullUpEnded();
      }
      int j = paramJSONObject.optInt("retcode");
      paramJSONObject = (PullRefreshHeader)this.d.get();
      if ((paramJSONObject != null) && (paramJSONObject.getVisibility() == 0))
      {
        if (j == 0) {
          i = 0;
        }
        paramJSONObject.a(i);
        localXListView.springBackOverScrollHeaderView();
      }
      if (j == 0) {
        HotChatPie.cj = System.currentTimeMillis();
      }
      return;
      label246:
      paramJSONObject = (Context)this.a.get();
      if (paramJSONObject != null) {
        QQToast.makeText(paramJSONObject, 2, HardCodeUtil.a(2131903550), 0).show();
      }
      ((IHotChatPostListAdapter)localObject1).setPullUpEnded();
      return;
    }
    if (localXListView.getVisibility() == 8) {
      ((TextView)localObject2).setText(HardCodeUtil.a(2131903557));
    }
    paramJSONObject = (Context)this.a.get();
    if (paramJSONObject != null)
    {
      QQToast.makeText(paramJSONObject, 1, HardCodeUtil.a(2131903559), 0).show();
      ((IHotChatPostListAdapter)localObject1).setPullUpEnded();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.GetPostListCallBack
 * JD-Core Version:    0.7.0.1
 */