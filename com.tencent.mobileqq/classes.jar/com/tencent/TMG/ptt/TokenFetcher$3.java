package com.tencent.TMG.ptt;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

class TokenFetcher$3
  implements TokenFetcher.HttpRequestListener
{
  TokenFetcher$3(TokenFetcher paramTokenFetcher) {}
  
  public void onCompleted(int paramInt, String paramString, Object paramObject)
  {
    if (!(paramObject instanceof TokenFetcher.Voice2TextListener)) {
      return;
    }
    TokenFetcher.Voice2TextListener localVoice2TextListener = (TokenFetcher.Voice2TextListener)paramObject;
    paramObject = null;
    String str = "";
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString)))
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        paramInt = ((JSONObject)localObject).getInt("ErrorCode");
        if (paramInt != 0)
        {
          localObject = ((JSONObject)localObject).getString("ErrorInfo");
          Log.e("TokenFetcher", String.format("mVoiceToTextListener|errCode=%d, errInfo=%s", new Object[] { Integer.valueOf(paramInt), localObject }));
          if (paramInt == 70001) {
            break label282;
          }
          if (paramInt != 70347) {
            break label273;
          }
          break label282;
        }
        localObject = new TokenFetcher.Voice2TextInfo(((JSONObject)localObject).getString("voice_url"), ((JSONObject)localObject).getString("text"));
        paramString = "";
        paramObject = localObject;
      }
      catch (JSONException localJSONException)
      {
        paramInt = 32772;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mVoiceToTextListener|decode resp json fail. resp=");
        localStringBuilder.append(paramString);
        Log.e("TokenFetcher", localStringBuilder.toString());
        localJSONException.printStackTrace();
        paramString = "decode resp json fail.";
      }
    }
    else
    {
      Log.e("TokenFetcher", String.format("mVoiceToTextListener|http error code=%d", new Object[] { Integer.valueOf(0) }));
      paramInt = 32770;
      paramString = "";
    }
    for (;;)
    {
      if (paramObject != null) {
        str = paramObject.text;
      }
      Log.d("TokenFetcher", String.format("mVoiceToTextListener|errCode=%d, errInfo=%s, text=%s", new Object[] { Integer.valueOf(paramInt), paramString, str }));
      localVoice2TextListener.onCompleted(paramInt, paramString, paramObject);
      return;
      label273:
      paramInt = 32769;
      paramString = localJSONException;
      continue;
      label282:
      paramInt = 32773;
      paramString = localJSONException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.ptt.TokenFetcher.3
 * JD-Core Version:    0.7.0.1
 */