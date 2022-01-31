import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;

public class blau
  implements blay, blbe
{
  private int jdField_a_of_type_Int = 0;
  private blbd jdField_a_of_type_Blbd = new blbd();
  private VideoSourceHelper jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper;
  private final String jdField_a_of_type_JavaLangString = "HwEncodeHelper";
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private long[] jdField_a_of_type_ArrayOfLong = new long[1];
  private blbd jdField_b_of_type_Blbd = new blbd();
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private String c;
  
  public blau(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper = new VideoSourceHelper(paramString1, paramString2);
  }
  
  private boolean a()
  {
    boolean bool = true;
    int[] arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.getBufferSize();
    if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (QLog.isColorLevel()) {
        QLog.d("HwEncodeHelper", 4, "initMediaBuffer videosize=" + arrayOfInt[0] + ", audiosize=" + arrayOfInt[1]);
      }
      try
      {
        if (this.jdField_a_of_type_ArrayOfByte == null) {
          this.jdField_a_of_type_ArrayOfByte = new byte[arrayOfInt[0]];
        }
        if (this.jdField_b_of_type_ArrayOfByte == null)
        {
          this.jdField_b_of_type_ArrayOfByte = new byte[arrayOfInt[1]];
          return true;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
    return false;
  }
  
  public int a()
  {
    int j = 2;
    if (!blav.a()) {
      return -1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.initHelperParam() != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HwEncodeHelper", 4, "initHelperParam error");
      }
      return -1;
    }
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("HwEncodeHelper", 4, "initMediaBuffer error");
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.closeHelper();
      return -1;
    }
    SVHwEncoder localSVHwEncoder = new SVHwEncoder();
    int i;
    if (axim.o == 16)
    {
      i = 1;
      if (axim.p != 2) {
        break label233;
      }
    }
    for (;;)
    {
      int k = axim.q;
      localSVHwEncoder.a(axim.q, i, k * i * j * 8, j);
      int[] arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.getSourceVideoParam();
      localSVHwEncoder.a(this.jdField_b_of_type_JavaLangString, arrayOfInt[0], arrayOfInt[1]);
      boolean bool = localSVHwEncoder.a(axim.z, axim.y, this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.mOrientationDegree);
      if (QLog.isColorLevel()) {
        QLog.d("HwEncodeHelper", 4, "startHwEncode mRecordFrames=" + axim.z + ", mRecordTime=" + axim.y + " successCode=" + bool);
      }
      if (bool) {
        break label238;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.closeHelper();
      return -1;
      i = 2;
      break;
      label233:
      j = 1;
    }
    label238:
    localSVHwEncoder.a(this, this, true);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.closeHelper();
    return this.jdField_a_of_type_Int;
  }
  
  public blbd a()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper != null) && (!this.jdField_a_of_type_Boolean))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.getNextAudioFrame(this.jdField_b_of_type_ArrayOfByte);
      this.jdField_b_of_type_Blbd.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
      this.jdField_b_of_type_Blbd.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Blbd.jdField_b_of_type_Int = i;
      this.jdField_b_of_type_Blbd.jdField_b_of_type_Boolean = false;
      blbd localblbd = this.jdField_b_of_type_Blbd;
      if (i > 0) {}
      for (;;)
      {
        localblbd.jdField_a_of_type_Boolean = bool;
        localblbd = this.jdField_b_of_type_Blbd;
        this.jdField_b_of_type_Blbd.c = -1;
        localblbd.jdField_a_of_type_Long = -1;
        this.jdField_b_of_type_Blbd.jdField_a_of_type_Float = -1.0F;
        if (QLog.isColorLevel()) {
          QLog.d("HwEncodeHelper", 4, "getAudioFrame() bufferSize=" + this.jdField_b_of_type_ArrayOfByte.length + ", readSize=" + i);
        }
        this.jdField_a_of_type_Boolean = this.jdField_b_of_type_Blbd.jdField_a_of_type_Boolean;
        return this.jdField_b_of_type_Blbd;
        bool = true;
      }
    }
    return null;
  }
  
  public blbd a(int paramInt)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper != null) && (!this.jdField_b_of_type_Boolean))
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.getNextVideoFrame(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ArrayOfLong, paramInt);
      this.jdField_a_of_type_Blbd.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      this.jdField_a_of_type_Blbd.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Blbd.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_Blbd.jdField_b_of_type_Boolean = true;
      blbd localblbd = this.jdField_a_of_type_Blbd;
      if (paramInt > 0) {
        bool = false;
      }
      localblbd.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Blbd.jdField_a_of_type_Long = this.jdField_a_of_type_ArrayOfLong[0];
      this.jdField_a_of_type_Blbd.c = -1;
      this.jdField_a_of_type_Blbd.jdField_a_of_type_Float = -1.0F;
      if (QLog.isColorLevel()) {
        QLog.d("HwEncodeHelper", 4, "getVideoFrame() bufferSize=" + this.jdField_a_of_type_ArrayOfByte.length + ", readSize=" + paramInt + ", frametime=" + this.jdField_a_of_type_ArrayOfLong[0]);
      }
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Blbd.jdField_a_of_type_Boolean;
      return this.jdField_a_of_type_Blbd;
    }
    return null;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HwEncodeHelper", 4, "svErrorOcured() code=" + paramInt1 + ", subcode=" + paramInt2);
    }
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HwEncodeHelper", 4, "svMergeOK() path=" + paramString + ", totalTime=" + paramInt + " mergetime=" + paramLong + " us");
    }
    this.c = paramString;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     blau
 * JD-Core Version:    0.7.0.1
 */