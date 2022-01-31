import android.media.MediaFormat;
import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;
import com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class bgwq
  implements bgwo
{
  public bgwq(WebAudioManager.5 param5, bgwm parambgwm) {}
  
  public void a(byte[] paramArrayOfByte, MediaFormat paramMediaFormat, boolean paramBoolean1, boolean paramBoolean2)
  {
    bgwr localbgwr;
    synchronized ()
    {
      if (bgwp.a(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.this$0) == null) {
        return;
      }
      if (!bgwp.a(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.this$0).containsKey(Integer.valueOf(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.jdField_a_of_type_Int))) {
        bgwp.a(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.this$0).put(Integer.valueOf(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.jdField_a_of_type_Int), new bgwr(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.this$0));
      }
      localbgwr = (bgwr)bgwp.a(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.this$0).get(Integer.valueOf(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.jdField_a_of_type_Int));
      ArrayList localArrayList = (ArrayList)bgwp.b(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.this$0).get(Integer.valueOf(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.jdField_a_of_type_Int));
      paramMediaFormat = localArrayList;
      if (localArrayList == null) {
        paramMediaFormat = new ArrayList();
      }
      if (paramBoolean2)
      {
        bgwr.a(localbgwr, 3);
        return;
      }
    }
    int i = bgwp.a(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.this$0).loadRawData(paramArrayOfByte, this.jdField_a_of_type_Bgwm.a(), this.jdField_a_of_type_Bgwm.b(), this.jdField_a_of_type_Bgwm.c());
    paramMediaFormat.add(Integer.valueOf(i));
    bgwp.b(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.this$0).put(Integer.valueOf(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.jdField_a_of_type_Int), paramMediaFormat);
    switch (bgwr.a(localbgwr))
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
        if (this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.jdField_a_of_type_Bgkd != null) {
          this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.jdField_a_of_type_Bgkd.a.a("onDecodeWebAudioDataDone", paramArrayOfByte.toString(), 0);
        }
        return;
        bgwr.a(localbgwr, 1);
        continue;
        paramArrayOfByte = bgwr.a(localbgwr);
        if ((paramArrayOfByte != null) && (!paramArrayOfByte.isEmpty()))
        {
          paramArrayOfByte = paramArrayOfByte.iterator();
          while (paramArrayOfByte.hasNext())
          {
            int j = ((Integer)paramArrayOfByte.next()).intValue();
            bgwp.a(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWebaudioWebAudioManager$5.this$0).setQueueBuffer(j, i);
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
 * Qualified Name:     bgwq
 * JD-Core Version:    0.7.0.1
 */