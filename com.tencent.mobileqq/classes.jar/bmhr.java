import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bmhr
{
  public static bmhr a;
  public int a;
  protected Object a;
  boolean a;
  public int b = 0;
  
  public bmhr()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static bmhr a()
  {
    if (jdField_a_of_type_Bmhr == null) {}
    try
    {
      if (jdField_a_of_type_Bmhr == null) {
        jdField_a_of_type_Bmhr = new bmhr();
      }
      return jdField_a_of_type_Bmhr;
    }
    finally {}
  }
  
  public static String a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      int i = paramString.lastIndexOf('.');
      if ((i > -1) && (i < paramString.length() - 1)) {
        return paramString.substring(0, i) + ".pcm";
      }
    }
    return null;
  }
  
  public void a(String paramString1, String paramString2)
  {
    byte[] arrayOfByte = bdhb.a(new File(paramString1));
    Object localObject = null;
    if (arrayOfByte == null)
    {
      QLog.e("StoryGameAudioMixManager", 1, "录音文件为空");
      return;
    }
    String str = a(paramString2);
    if (str != null)
    {
      localObject = new File(str);
      if (!((File)localObject).exists())
      {
        if (!bmho.a(new File(paramString2), new File(str))) {
          break label135;
        }
        this.jdField_a_of_type_Int = 2;
        if (QLog.isColorLevel()) {
          QLog.d("StoryGameAudioMixManager", 2, "convert mp3 in publish now");
        }
      }
      localObject = bdhb.a((File)localObject);
    }
    else
    {
      if (localObject != null) {
        break label144;
      }
      QLog.e("StoryGameAudioMixManager", 1, "bgm为空" + str);
      return;
    }
    label135:
    QLog.e("StoryGameAudioMixManager", 1, "bgm conver fail");
    return;
    label144:
    paramString2 = new byte[arrayOfByte.length];
    if (bmho.a(paramString2, (byte[])localObject, arrayOfByte, arrayOfByte.length, 0.0D))
    {
      if (!QLog.isColorLevel()) {
        break label185;
      }
      QLog.d("StoryGameAudioMixManager", 2, "mixAudioFileToPcmBytes succedd");
    }
    for (;;)
    {
      bdhb.a(paramString2, paramString1);
      return;
      label185:
      QLog.d("StoryGameAudioMixManager", 2, "mixAudioFileToPcmBytes fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhr
 * JD-Core Version:    0.7.0.1
 */