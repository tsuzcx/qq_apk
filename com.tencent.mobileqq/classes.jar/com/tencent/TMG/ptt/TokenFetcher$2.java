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
    paramObject = "";
    if ((paramInt != 0) || (TextUtils.isEmpty(paramString)))
    {
      Log.e("TokenFetcher", String.format("mDownloadTokenListener|http error code=%d", new Object[] { Integer.valueOf(0) }));
      paramInt = 12293;
      paramString = null;
      if (paramString != null) {
        break label254;
      }
    }
    label254:
    String str1;
    for (Object localObject = "";; str1 = paramString.token)
    {
      for (;;)
      {
        Log.d("TokenFetcher", String.format("mDownloadTokenListener|errCode=%d, errInfo=%s, token=%s", new Object[] { Integer.valueOf(paramInt), paramObject, localObject }));
        localGetDownloadTokenListener.onCompleted(paramInt, paramObject, paramString);
        return;
        try
        {
          localObject = new JSONObject(paramString);
          paramInt = ((JSONObject)localObject).getInt("ErrorCode");
          if (paramInt != 0)
          {
            paramObject = ((JSONObject)localObject).getString("ErrorInfo");
            Log.e("TokenFetcher", String.format("mDownloadTokenListener|errCode=%d, errInfo=%s", new Object[] { Integer.valueOf(paramInt), paramObject }));
            if (paramInt == 70001) {
              break label263;
            }
            if (paramInt != 70347) {
              break label272;
            }
            break label263;
          }
          String str2 = ((JSONObject)localObject).getString("download_token");
          localObject = new TokenFetcher.DownloadInfo(((JSONObject)localObject).getString("voice_url"), str2);
          paramString = (String)localObject;
        }
        catch (JSONException localJSONException)
        {
          paramInt = 12295;
          paramObject = "decode resp json fail.";
          Log.e("TokenFetcher", "mDownloadTokenListener|decode resp json fail. resp=" + paramString);
          localJSONException.printStackTrace();
          paramString = null;
        }
      }
      break;
    }
    label263:
    label272:
    for (paramInt = 12296;; paramInt = 12290)
    {
      paramString = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.ptt.TokenFetcher.2
 * JD-Core Version:    0.7.0.1
 */