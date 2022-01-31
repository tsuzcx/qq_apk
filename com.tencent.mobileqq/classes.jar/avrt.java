import android.text.TextUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.initializer.VoiceChangerInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.voicechanger.common.audio.VoiceChanger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public class avrt
{
  public static int a;
  public static int b;
  private avrs jdField_a_of_type_Avrs;
  protected VoiceChanger a;
  private RandomAccessFile jdField_a_of_type_JavaIoRandomAccessFile;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private String b;
  private int c;
  private int d;
  private int e;
  
  static
  {
    jdField_a_of_type_Int = com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat.SAMPLE_RATES[4];
    jdField_b_of_type_Int = (int)(jdField_a_of_type_Int * 0.02D * 1.0D * 4.0D);
  }
  
  public avrt(String paramString, int paramInt, avrs paramavrs)
  {
    this.jdField_b_of_type_JavaLangString = (FileUtils.genSeperateFileDir(paramString) + "audio_data_cache" + File.separator);
    this.jdField_a_of_type_Avrs = paramavrs;
  }
  
  private boolean b()
  {
    return (c()) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Avrs != null);
  }
  
  private boolean c()
  {
    try
    {
      File localFile = new File(this.jdField_b_of_type_JavaLangString);
      if (!localFile.exists()) {
        return localFile.mkdir();
      }
      if (localFile.isFile())
      {
        localFile.delete();
        boolean bool = localFile.mkdir();
        return bool;
      }
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public void a()
  {
    if (!b()) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + axlx.a() + ".pcm");
    this.jdField_a_of_type_ComTencentTtpicVoicechangerCommonAudioVoiceChanger = new VoiceChanger(this.jdField_a_of_type_JavaLangString, jdField_a_of_type_Int, this.c, this.d);
    try
    {
      this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_JavaLangString, "rw");
      if (this.jdField_a_of_type_ArrayOfByte == null) {
        this.jdField_a_of_type_ArrayOfByte = new byte[jdField_b_of_type_Int];
      }
      this.e = 0;
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        localFileNotFoundException.printStackTrace();
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((a()) && (b()))
    {
      paramInt1 = 0;
      if (paramInt2 < jdField_b_of_type_Int) {
        break label145;
      }
      System.arraycopy(paramArrayOfByte, paramInt1, this.jdField_a_of_type_ArrayOfByte, this.e, jdField_b_of_type_Int - this.e);
      localObject = new short[jdField_b_of_type_Int / 2];
      ByteBuffer.wrap(this.jdField_a_of_type_ArrayOfByte).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get((short[])localObject);
      localObject = this.jdField_a_of_type_ComTencentTtpicVoicechangerCommonAudioVoiceChanger.writeVoiceFrames((short[])localObject);
      if (localObject != null) {
        break label92;
      }
    }
    label92:
    while (paramInt2 <= 0) {
      for (;;)
      {
        Object localObject;
        return;
        try
        {
          this.jdField_a_of_type_JavaIoRandomAccessFile.write((byte[])localObject, 0, localObject.length);
          paramInt1 += jdField_b_of_type_Int - this.e;
          paramInt2 -= jdField_b_of_type_Int - this.e;
          this.e = 0;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
      }
    }
    label145:
    System.arraycopy(paramArrayOfByte, paramInt1, this.jdField_a_of_type_ArrayOfByte, this.e, paramInt2);
    this.e = paramInt2;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (FeatureManager.Features.VOICE_CHANGDER.isFunctionReady());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentTtpicVoicechangerCommonAudioVoiceChanger != null) {
      this.jdField_a_of_type_ComTencentTtpicVoicechangerCommonAudioVoiceChanger.release();
    }
    if (this.jdField_a_of_type_JavaIoRandomAccessFile != null) {}
    try
    {
      this.jdField_a_of_type_JavaIoRandomAccessFile.close();
      this.jdField_a_of_type_ArrayOfByte = null;
      this.jdField_a_of_type_Avrs.b(this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avrt
 * JD-Core Version:    0.7.0.1
 */