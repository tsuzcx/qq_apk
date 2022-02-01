package com.tencent.TMG.ptt;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

class TokenFetcher$2
  implements TokenFetcher.HttpRequestListener
{
  TokenFetcher$2(TokenFetcher paramTokenFetcher) {}
  
  public void onCompleted(int paramInt, String paramString, Object paramObject)
  {
    if (!(paramObject instanceof TokenFetcher.GetDownloadTokenListener)) {
      return;
    }
    TokenFetcher.GetDownloadTokenListener localGetDownloadTokenListener = (TokenFetcher.GetDownloadTokenListener)paramObject;
    paramObject = null;
    String str = "";
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString)))
    {
      try
      {
        Object localObject1 = new JSONObject(paramString);
        paramInt = ((JSONObject)localObject1).getInt("ErrorCode");
        if (paramInt != 0)
        {
          localObject1 = ((JSONObject)localObject1).getString("ErrorInfo");
          Log.e("TokenFetcher", String.format("mDownloadTokenListener|errCode=%d, errInfo=%s", new Object[] { Integer.valueOf(paramInt), localObject1 }));
          if (paramInt == 70001) {
            break label289;
          }
          if (paramInt != 70347) {
            break label279;
          }
          break label289;
        }
        localObject2 = ((JSONObject)localObject1).getString("download_token");
        localObject1 = new TokenFetcher.DownloadInfo(((JSONObject)localObject1).getString("voice_url"), (String)localObject2);
        paramString = "";
        paramObject = localObject1;
      }
      catch (JSONException localJSONException)
      {
        paramInt = 12295;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mDownloadTokenListener|decode resp json fail. resp=");
        ((StringBuilder)localObject2).append(paramString);
        Log.e("TokenFetcher", ((StringBuilder)localObject2).toString());
        localJSONException.printStackTrace();
        paramString = "decode resp json fail.";
      }
    }
    else
    {
      Log.e("TokenFetcher", String.format("mDownloadTokenListener|http error code=%d", new Object[] { Integer.valueOf(0) }));
      paramInt = 12293;
      paramString = "";
    }
    for (;;)
    {
      if (paramObject != null) {
        str = paramObject.token;
      }
      Log.d("TokenFetcher", String.format("mDownloadTokenListener|errCode=%d, errInfo=%s, token=%s", new Object[] { Integer.valueOf(paramInt), paramString, str }));
      localGetDownloadTokenListener.onCompleted(paramInt, paramString, paramObject);
      return;
      label279:
      paramInt = 12290;
      paramString = localJSONException;
      continue;
      label289:
      paramInt = 12296;
      paramString = localJSONException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.ptt.TokenFetcher.2
 * JD-Core Version:    0.7.0.1
 */