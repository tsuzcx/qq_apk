import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;
import java.util.ArrayList;
import java.util.Iterator;

public class bgwl
{
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  private IAudioNativeManager jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bgwl(IAudioNativeManager paramIAudioNativeManager)
  {
    if (paramIAudioNativeManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager = paramIAudioNativeManager;
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager.initAudioContext();
    }
  }
  
  public float a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager.getCurrentGain(paramInt);
    }
    return 0.0F;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager.createBufferSource();
      this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
      return i;
    }
    return -1;
  }
  
  public long a()
  {
    return System.currentTimeMillis() - this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager.stopSource(i);
      }
    }
  }
  
  public void a(int paramInt, double paramDouble)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager.setCurrentGain(paramInt, (float)paramDouble);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager.setBufferSourceLoop(paramInt, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgwl
 * JD-Core Version:    0.7.0.1
 */