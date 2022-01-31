import android.media.MediaFormat;
import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;
import com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class bhax
  implements bhav
{
  public bhax(WebAudioManager.5 param5, bhat parambhat) {}
  
  public void a(byte[] paramArrayOfByte, MediaFormat paramMediaFormat, boolean paramBoolean1, boolean paramBoolean2)
  {
    bhay localbhay;
    synchronized ()
    {
      if (bhaw.a(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.this$0) == null) {
        return;
      }
      if (!bhaw.a(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.this$0).containsKey(Integer.valueOf(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.jdField_a_of_type_Int))) {
        bhaw.a(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.this$0).put(Integer.valueOf(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.jdField_a_of_type_Int), new bhay(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.this$0));
      }
      localbhay = (bhay)bhaw.a(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.this$0).get(Integer.valueOf(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.jdField_a_of_type_Int));
      ArrayList localArrayList = (ArrayList)bhaw.b(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.this$0).get(Integer.valueOf(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.jdField_a_of_type_Int));
      paramMediaFormat = localArrayList;
      if (localArrayList == null) {
        paramMediaFormat = new ArrayList();
      }
      if (paramBoolean2)
      {
        bhay.a(localbhay, 3);
        return;
      }
    }
    int i = bhaw.a(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.this$0).loadRawData(paramArrayOfByte, this.jdField_a_of_type_Bhat.a(), this.jdField_a_of_type_Bhat.b(), this.jdField_a_of_type_Bhat.c());
    paramMediaFormat.add(Integer.valueOf(i));
    bhaw.b(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.this$0).put(Integer.valueOf(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.jdField_a_of_type_Int), paramMediaFormat);
    switch (bhay.a(localbhay))
    {
    }
    for (;;)
    {
      if (paramBoolean1) {
        paramArrayOfByte = new JSONObject();
      }
      try
      {
        paramArrayOfByte.put("decodeId", this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.jdField_a_of_type_Int);
        paramArrayOfByte.put("status", "ok");
        if (this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.jdField_a_of_type_Bgok != null) {
          this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.jdField_a_of_type_Bgok.a.a("onDecodeWebAudioDataDone", paramArrayOfByte.toString(), 0);
        }
        return;
        bhay.a(localbhay, 1);
        continue;
        paramArrayOfByte = bhay.a(localbhay);
        if ((paramArrayOfByte != null) && (!paramArrayOfByte.isEmpty()))
        {
          paramArrayOfByte = paramArrayOfByte.iterator();
          while (paramArrayOfByte.hasNext())
          {
            int j = ((Integer)paramArrayOfByte.next()).intValue();
            bhaw.a(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.this$0).setQueueBuffer(j, i);
          }
        }
      }
      catch (JSONException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhax
 * JD-Core Version:    0.7.0.1
 */