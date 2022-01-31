package com.tencent.biz.pubaccount.readinjoy.comment;

import android.os.Bundle;
import bbmd;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import ndd;
import okh;
import org.json.JSONArray;
import org.json.JSONObject;

public final class NativeCommentServlet$3
  implements Runnable
{
  public void run()
  {
    String str2;
    Object localObject2;
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId;
            localObject3 = new HashMap();
            ((Map)localObject3).put("feeds_id", String.valueOf(l));
            ((Map)localObject3).put("comment", URLEncoder.encode(this.jdField_a_of_type_JavaLangString));
            if (this.jdField_a_of_type_JavaLangString != null)
            {
              i = this.jdField_a_of_type_JavaLangString.length();
              ((Map)localObject3).put("commentLength", String.valueOf(i));
              ((Map)localObject3).put("feedsType", String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType));
              String str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
              str2 = ((TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2)).getSkey(str1);
              ((Map)localObject3).put("g_tk", String.valueOf(bbmd.a(str2)));
              if (this.jdField_a_of_type_OrgJsonJSONArray != null) {
                ((Map)localObject3).put("comment_gif_urls", URLEncoder.encode(this.jdField_a_of_type_OrgJsonJSONArray.toString()));
              }
              localObject2 = new StringBuilder("http://kandian.qq.com/qz_kandian_social/kandian_ext/CommentOnFeedsV2?from=feeds");
              localObject3 = ((Map)localObject3).entrySet().iterator();
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
              ((StringBuilder)localObject2).append("&" + (String)localEntry.getKey() + "=" + (String)localEntry.getValue());
              continue;
            }
            i = 0;
          }
          catch (Exception localException)
          {
            ThreadManager.getUIHandler().post(new NativeCommentServlet.3.2(this));
            localException.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.d("NativeCommentServlet", 2, "createFeedsComment error info:" + localException.getLocalizedMessage());
            }
            return;
          }
        }
        QLog.d("NativeCommentServlet", 2, "feed_comment_request_url_with_params " + localObject2);
        Object localObject3 = new Bundle();
        ((Bundle)localObject3).putString("cookie", "uin=o" + localException + ";skey=" + str2);
        localObject1 = ndd.a(BaseApplicationImpl.getContext(), ((StringBuilder)localObject2).toString(), "GET", null, (Bundle)localObject3);
        if (localObject1 == null)
        {
          QLog.d("NativeCommentServlet", 2, "feed_comment_response byte is null");
          return;
        }
        localObject1 = new String((byte[])localObject1);
        QLog.d("NativeCommentServlet", 2, "feed_comment_response " + (String)localObject1);
        localObject1 = new JSONObject((String)localObject1);
      } while (localObject1 == null);
      i = ((JSONObject)localObject1).getInt("retcode");
      str2 = ((JSONObject)localObject1).getString("retmsg");
      if (i != 0)
      {
        this.jdField_a_of_type_Okh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.b, i, str2);
        return;
      }
      localObject1 = ((JSONObject)localObject1).getJSONObject("result");
    } while (localObject1 == null);
    int i = ((JSONObject)localObject1).getInt("retCode");
    Object localObject1 = ((JSONObject)localObject1).getJSONObject("retObj");
    if (localObject1 != null) {}
    for (localObject1 = ((JSONObject)localObject1).getString("feeds_id");; localObject1 = "")
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("ret", i);
      ((JSONObject)localObject2).put("retmsg", str2);
      ((JSONObject)localObject2).put("feeds_id", localObject1);
      ThreadManager.getUIHandler().post(new NativeCommentServlet.3.1(this, (JSONObject)localObject2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.NativeCommentServlet.3
 * JD-Core Version:    0.7.0.1
 */