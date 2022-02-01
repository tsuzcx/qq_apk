package com.tencent.TMG.ptt;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

class TokenFetcher$1
  implements TokenFetcher.HttpRequestListener
{
  TokenFetcher$1(TokenFetcher paramTokenFetcher) {}
  
  public void onCompleted(int paramInt, String paramString, Object paramObject)
  {
    if (!(paramObject instanceof TokenFetcher.GetUploadTokenListener)) {
      return;
    }
    TokenFetcher.GetUploadTokenListener localGetUploadTokenListener = (TokenFetcher.GetUploadTokenListener)paramObject;
    paramObject = null;
    String str2 = "";
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString)))
    {
      try
      {
        Object localObject1 = new JSONObject(paramString);
        paramInt = ((JSONObject)localObject1).getInt("ErrorCode");
        if (paramInt != 0)
        {
          localObject1 = ((JSONObject)localObject1).getString("ErrorInfo");
          Log.e("TokenFetcher", String.format("mUploadTokenListener|errCode=%d, errInfo=%s", new Object[] { Integer.valueOf(paramInt), localObject1 }));
          if (paramInt == 70001) {
            break label311;
          }
          if (paramInt != 70347) {
            break label301;
          }
          break label311;
        }
        localObject2 = ((JSONObject)localObject1).getString("upload_token");
        localObject1 = new TokenFetcher.UploadInfo(((JSONObject)localObject1).getString("upload_url"), (String)localObject2);
        paramString = "";
        paramObject = localObject1;
      }
      catch (JSONException localJSONException)
      {
        paramInt = 8198;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mUploadTokenListener|decode resp json fail. resp=");
        ((StringBuilder)localObject2).append(paramString);
        Log.e("TokenFetcher", ((StringBuilder)localObject2).toString());
        localJSONException.printStackTrace();
        paramString = "decode resp json fail.";
      }
    }
    else
    {
      Log.e("TokenFetcher", String.format("mUploadTokenListener|http error code=%d", new Object[] { Integer.valueOf(0) }));
      paramInt = 8196;
      paramString = "";
    }
    for (;;)
    {
      String str1;
      if (paramObject == null) {
        str1 = "";
      } else {
        str1 = paramObject.token;
      }
      if (paramObject != null) {
        str2 = paramObject.upload_url;
      }
      Log.d("TokenFetcher", String.format("mUploadTokenListener|errCode=%d, errInfo=%s, token=%s, url=%s", new Object[] { Integer.valueOf(paramInt), paramString, str1, str2 }));
      localGetUploadTokenListener.onCompleted(paramInt, paramString, paramObject);
      return;
      label301:
      paramInt = 8194;
      paramString = str1;
      continue;
      label311:
      paramInt = 8199;
      paramString = str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.ptt.TokenFetcher.1
 * JD-Core Version:    0.7.0.1
 */