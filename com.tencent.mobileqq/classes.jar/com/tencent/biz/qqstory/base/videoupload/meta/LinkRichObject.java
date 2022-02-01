package com.tencent.biz.qqstory.base.videoupload.meta;

import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.io.IOException;
import java.net.URLEncoder;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONException;
import org.json.JSONObject;

public class LinkRichObject
  extends UploadObject
{
  public String a;
  public String b;
  public String c;
  public String d;
  public int e = -1;
  
  public LinkRichObject(String paramString)
  {
    this.a = paramString;
  }
  
  private ErrorMessage c()
  {
    Object localObject1 = String.format("https://cgi.connect.qq.com/qqconnectopen/get_urlinfoForQQV2?url=%2$s&uin=%1$s", new Object[] { QQStoryContext.a().g(), URLEncoder.encode(this.a) });
    long l = System.currentTimeMillis();
    localObject1 = HttpUtil.openRequest(QQStoryContext.a().c(), (String)localObject1, null, "GET", null, null, 5000, 5000);
    Object localObject2;
    if ((localObject1 != null) && (((HttpResponse)localObject1).getStatusLine().getStatusCode() == 200))
    {
      localObject1 = HttpUtil.readHttpResponse((HttpResponse)localObject1);
      SLog.a("Q.qqstory.publish.upload.LinkRichObject", "http resp %s", localObject1);
      localObject1 = new JSONObject((String)localObject1);
      this.e = Integer.parseInt(((JSONObject)localObject1).getString("ret"));
      if (this.e != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("server error code:");
        ((StringBuilder)localObject1).append(this.e);
        return new ErrorMessage(96000002, ((StringBuilder)localObject1).toString());
      }
      localObject2 = ((JSONObject)localObject1).getString("title");
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty(this.b))) {
        this.b = ((String)localObject2);
      }
      localObject2 = ((JSONObject)localObject1).getString("abstract");
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty(this.c))) {
        this.c = ((String)localObject2);
      }
      localObject1 = ((JSONObject)localObject1).getString("thumbUrl");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty(this.d))) {
        this.d = ((String)localObject1);
      }
      SLog.d("Q.qqstory.publish.upload.LinkRichObject", "request take time %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return new ErrorMessage();
    }
    SLog.d("Q.qqstory.publish.upload.LinkRichObject", "");
    if (localObject1 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("http code:");
      ((StringBuilder)localObject2).append(((HttpResponse)localObject1).getStatusLine());
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject1 = "response is null";
    }
    return new ErrorMessage(96000003, (String)localObject1);
  }
  
  protected void a()
  {
    try
    {
      if (c().isSuccess())
      {
        b();
        notifyResult(new ErrorMessage());
        return;
      }
    }
    catch (IOException localIOException)
    {
      SLog.c("Q.qqstory.publish.upload.LinkRichObject", "parse url ", localIOException);
      new ErrorMessage(96000000, localIOException.getMessage());
    }
    catch (JSONException localJSONException)
    {
      SLog.c("Q.qqstory.publish.upload.LinkRichObject", "parse url ", localJSONException);
      new ErrorMessage(96000001, localJSONException.getMessage());
    }
    b();
    notifyResult(new ErrorMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.meta.LinkRichObject
 * JD-Core Version:    0.7.0.1
 */