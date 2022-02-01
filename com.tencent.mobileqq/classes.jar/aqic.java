import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class aqic
  extends aqgc<aqib>
{
  @NonNull
  public aqib a()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = ((QQAppInterface)localObject).getCurrentAccountUin();
    localObject = ((QQAppInterface)localObject).getApp().getSharedPreferences("sticker_pref", 0).edit();
    ((SharedPreferences.Editor)localObject).putInt("sticker_max_show_num_" + str, EmojiStickerManager.c);
    ((SharedPreferences.Editor)localObject).apply();
    ((SharedPreferences.Editor)localObject).putInt("sticker_max_send_num_" + str, EmojiStickerManager.c);
    ((SharedPreferences.Editor)localObject).commit();
    FlatBuffersParser.a(true);
    return new aqib();
  }
  
  @NonNull
  public aqib a(aptx[] paramArrayOfaptx)
  {
    int j = -1;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = localQQAppInterface.getCurrentAccountUin();
    int m = paramArrayOfaptx.length;
    int i = 0;
    if (i < m)
    {
      aptx localaptx = paramArrayOfaptx[i];
      int k = localaptx.jdField_a_of_type_Int;
      if (k < j) {
        xvv.e("QVipStickerProcessor", "received old task id " + k + ", latest task id: " + j);
      }
      for (;;)
      {
        i += 1;
        break;
        try
        {
          JSONObject localJSONObject = new JSONObject(new String(localaptx.jdField_a_of_type_JavaLangString.getBytes("utf-8")));
          SharedPreferences.Editor localEditor = localQQAppInterface.getApp().getSharedPreferences("sticker_pref", 0).edit();
          if (localJSONObject.has("emojiMaxShowNum"))
          {
            EmojiStickerManager.f = localJSONObject.optInt("emojiMaxShowNum");
            if (EmojiStickerManager.f <= 0) {
              EmojiStickerManager.f = EmojiStickerManager.c;
            }
            localEditor.putInt("sticker_max_show_num_" + str, EmojiStickerManager.f);
            localEditor.apply();
          }
          if (localJSONObject.has("emojiMaxStickNum"))
          {
            EmojiStickerManager.e = localJSONObject.optInt("emojiMaxStickNum");
            if (EmojiStickerManager.e <= 0) {
              EmojiStickerManager.e = EmojiStickerManager.c;
            }
            localEditor.putInt("sticker_max_send_num_" + str, EmojiStickerManager.e);
            localEditor.commit();
          }
          if (localJSONObject.has("flatBufferEnable")) {
            if (localJSONObject.optInt("flatBufferEnable") != 1) {
              break label311;
            }
          }
          label311:
          for (boolean bool = true;; bool = false)
          {
            FlatBuffersParser.a(bool);
            j = k;
            break;
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
          xvv.e("QVipStickerProcessor", "item.content=" + localaptx.jdField_a_of_type_JavaLangString + " e=" + localUnsupportedEncodingException);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          xvv.e("QVipStickerProcessor", "item.content=" + localaptx.jdField_a_of_type_JavaLangString + " e=" + localJSONException);
        }
      }
    }
    return new aqib();
  }
  
  @NonNull
  public aqib b()
  {
    return new aqib();
  }
  
  public Class<aqib> clazz()
  {
    return aqib.class;
  }
  
  public int type()
  {
    return 189;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqic
 * JD-Core Version:    0.7.0.1
 */