import com.music.voice.MusicWrapperJNI;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class bjec
{
  public static final String a;
  public static final String b;
  public static final String c = jdField_a_of_type_JavaLangString + File.separator + "audio_fingerprint.secret";
  public static final String d = jdField_a_of_type_JavaLangString + File.separator + "audio_fingerprint.txt";
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private MusicWrapperJNI jdField_a_of_type_ComMusicVoiceMusicWrapperJNI = new MusicWrapperJNI();
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = ahwa.jdField_a_of_type_JavaLangString + "/Tencent/qim/hum_recognition";
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + File.separator + "svm_snr15_random_noise";
  }
  
  private int a()
  {
    int[] arrayOfInt = new int[1];
    this.jdField_a_of_type_ComMusicVoiceMusicWrapperJNI.QAFPGetVersion(arrayOfInt);
    return arrayOfInt[0];
  }
  
  private String a()
  {
    long l = System.currentTimeMillis();
    int i = a();
    String str1 = bjdp.a("musicopi_12345683" + "a45a1b" + l);
    String str2 = String.format("%.3f,%d", new Object[] { Float.valueOf(10.0F), Integer.valueOf(this.jdField_b_of_type_Int) });
    float f = this.jdField_a_of_type_Float;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v=").append(i).append("&source=").append("musicopi_12345683").append("&time=").append(l).append("&veri_str=").append(str1).append("&cmd=").append("1").append("&info=").append(str2).append("&type=").append("0").append("&session_id=").append(l).append("feature_type=").append(this.jdField_a_of_type_Int).append("&confidence=").append(f * 100.0F).append("");
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    Object localObject = new int[1];
    float[] arrayOfFloat = new float[1];
    byte[] arrayOfByte = new byte[10240];
    int[] arrayOfInt = new int[1];
    this.jdField_a_of_type_ComMusicVoiceMusicWrapperJNI.GetFeature(10000.0F, (int[])localObject, arrayOfFloat, arrayOfByte, arrayOfInt);
    this.jdField_a_of_type_Int = (localObject[0] + 1);
    this.jdField_a_of_type_Float = arrayOfFloat[0];
    this.jdField_b_of_type_Int = arrayOfInt[0];
    this.jdField_a_of_type_ArrayOfByte = Arrays.copyOfRange(arrayOfByte, 0, this.jdField_b_of_type_Int);
    if (QLog.isColorLevel())
    {
      localObject = String.format("feature_type=%s prob=%s outputLength=%d", new Object[] { Integer.valueOf(localObject[0]), Float.valueOf(arrayOfFloat[0]), Integer.valueOf(arrayOfInt[0]) });
      QLog.i("AcousticFingerprint", 2, "getFeatureJni: invoked. info: fingerprintFeature = " + (String)localObject);
    }
  }
  
  private boolean a()
  {
    File localFile = new File(jdField_b_of_type_JavaLangString);
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AcousticFingerprint", 2, "isClassifierFileExists: invoked. info: not exist. classifierFile = " + localFile);
      }
      return false;
    }
    return true;
  }
  
  private boolean b()
  {
    int i = this.jdField_a_of_type_ComMusicVoiceMusicWrapperJNI.Init(jdField_b_of_type_JavaLangString);
    if (i == 0) {
      return true;
    }
    if (((i == -1) || (i == -2)) && (QLog.isColorLevel())) {
      QLog.i("AcousticFingerprint", 2, "initWrapperJni: invoked. info: initResult = " + i);
    }
    return false;
  }
  
  private byte[] b(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    if (i == 0) {
      if (QLog.isColorLevel()) {
        QLog.i("AcousticFingerprint", 2, "generateBytes: invoked. info: audioBytes.length = " + i);
      }
    }
    boolean bool;
    do
    {
      return null;
      if (a()) {
        break;
      }
      bool = bjdp.a();
      if (bool) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("AcousticFingerprint", 2, "generateBytes: invoked. info: Failed to copy classifier. OK = " + bool);
    return null;
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = b();
    }
    int j = this.jdField_a_of_type_ComMusicVoiceMusicWrapperJNI.Reset();
    if (((j == -4) || (j == -5)) && (QLog.isColorLevel())) {
      QLog.i("AcousticFingerprint", 2, "generateBytes: invoked. info: resetResult = " + j);
    }
    i = this.jdField_a_of_type_ComMusicVoiceMusicWrapperJNI.Process(paramArrayOfByte, i);
    if (((i == -4) || (i == -6)) && (QLog.isColorLevel())) {
      QLog.i("AcousticFingerprint", 2, "generateBytes: invoked. info: processResult = " + i);
    }
    a();
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  private byte[] c(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = b(paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AcousticFingerprint", 2, "body: invoked. info: fingerprintBytes = " + paramArrayOfByte);
      }
      return null;
    }
    Object localObject = a();
    if (QLog.isColorLevel()) {
      QLog.i("AcousticFingerprint", 2, "body: invoked. info: header = " + (String)localObject);
    }
    localObject = ((String)localObject).getBytes(Charset.forName("UTF-8"));
    byte[] arrayOfByte = new byte[localObject.length + paramArrayOfByte.length];
    System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, localObject.length, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  private byte[] d(byte[] paramArrayOfByte)
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec("spr_8a2cdeab7b81".getBytes(), "AES");
    Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    localCipher.init(1, localSecretKeySpec);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public bjec a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AcousticFingerprint", 2, "setTimeThreshold: invoked. info: timeMs = " + paramFloat);
    }
    if (paramFloat < 0.0F) {}
    int i;
    do
    {
      return this;
      i = this.jdField_a_of_type_ComMusicVoiceMusicWrapperJNI.SetTimeThreashold(paramFloat);
    } while ((i == 0) || (!QLog.isColorLevel()));
    QLog.i("AcousticFingerprint", 2, "setTimeThreasholdJni: invoked. info: Failed. retVal = " + i);
    return this;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = c(paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AcousticFingerprint", 2, "bytes: invoked. info: Failed to generate fingerprint body. body = " + paramArrayOfByte);
      }
      return null;
    }
    return d(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjec
 * JD-Core Version:    0.7.0.1
 */