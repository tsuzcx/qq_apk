import android.media.MediaCodec.BufferInfo;
import java.util.ArrayList;

public class axxm
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<Integer> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  
  public axxm(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "segment" + paramInt + ".mp4");
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(0)).longValue();
    }
    return 0L;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(axvl paramaxvl)
  {
    paramaxvl = paramaxvl.a;
    this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramaxvl.presentationTimeUs));
    this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(paramaxvl.flags));
  }
  
  public String toString()
  {
    return "SegmentInfo{mSegmentPath='" + this.jdField_b_of_type_JavaLangString + '\'' + ", mFrames=" + this.jdField_a_of_type_JavaUtilArrayList + ", mFlags=" + this.jdField_b_of_type_JavaUtilArrayList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axxm
 * JD-Core Version:    0.7.0.1
 */