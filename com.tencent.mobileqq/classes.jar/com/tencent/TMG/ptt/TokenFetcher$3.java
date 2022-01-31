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
    paramObject = "";
    if ((paramInt != 0) || (TextUtils.isEmpty(paramString)))
    {
      Log.e("TokenFetcher", String.format("mVoiceToTextListener|http error code=%d", new Object[] { Integer.valueOf(0) }));
      paramInt = 32770;
      paramString = null;
      if (paramString != null) {
        break label248;
      }
    }
    label248:
    String str;
    for (Object localObject = "";; str = paramString.text)
    {
      for (;;)
      {
        Log.d("TokenFetcher", String.format("mVoiceToTextListener|errCode=%d, errInfo=%s, text=%s", new Object[] { Integer.valueOf(paramInt), paramObject, localObject }));
        localVoice2TextListener.onCompleted(paramInt, paramObject, paramString);
        return;
        try
        {
          localObject = new JSONObject(paramString);
          paramInt = ((JSONObject)localObject).getInt("ErrorCode");
          if (paramInt != 0)
          {
            paramObject = ((JSONObject)localObject).getString("ErrorInfo");
            Log.e("TokenFetcher", String.format("mVoiceToTextListener|errCode=%d, errInfo=%s", new Object[] { Integer.valueOf(paramInt), paramObject }));
            if (paramInt == 70001) {
              break label257;
            }
            if (paramInt != 70347) {
              break label265;
            }
            break label257;
          }
          localObject = new TokenFetcher.Voice2TextInfo(((JSONObject)localObject).getString("voice_url"), ((JSONObject)localObject).getString("text"));
          paramString = (String)localObject;
        }
        catch (JSONException localJSONException)
        {
          paramInt = 32772;
          paramObject = "decode resp json fail.";
          Log.e("TokenFetcher", "mVoiceToTextListener|decode resp json fail. resp=" + paramString);
          localJSONException.printStackTrace();
          paramString = null;
        }
      }
      break;
    }
    label257:
    label265:
    for (paramInt = 32773;; paramInt = 32769)
    {
      paramString = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.ptt.TokenFetcher.3
 * JD-Core Version:    0.7.0.1
 */