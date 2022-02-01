import com.tencent.qphone.base.util.QLog;

class baeh
  implements bagj
{
  baeh(baeg parambaeg, int[] paramArrayOfInt) {}
  
  public void onEncodeError(int paramInt, Throwable arg2)
  {
    String str;
    if (??? != null) {
      str = ???.getMessage();
    }
    for (;;)
    {
      xwa.b("video_edit", "reEncodeResult", this.jdField_a_of_type_ArrayOfInt[0], 0, new String[] { "", str });
      xvv.e("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = " + ???);
      baeg.a(this.jdField_a_of_type_Baeg, paramInt);
      synchronized (baeg.a(this.jdField_a_of_type_Baeg))
      {
        baeg.a(this.jdField_a_of_type_Baeg, true);
        baeg.a(this.jdField_a_of_type_Baeg).notifyAll();
        return;
        str = "UNKNOWN ERROR";
      }
    }
  }
  
  public void onEncodeFinish(String arg1)
  {
    xwa.b("video_edit", "reEncodeResult", this.jdField_a_of_type_ArrayOfInt[0], 0, new String[] { ??? });
    synchronized (baeg.a(this.jdField_a_of_type_Baeg))
    {
      baeg.a(this.jdField_a_of_type_Baeg, true);
      baeg.a(this.jdField_a_of_type_Baeg).notifyAll();
      QLog.w("MergeEditVideo", 1, "mp4ReEncoder encode finish!");
      return;
    }
  }
  
  public void onEncodeFrame() {}
  
  public void onEncodeStart()
  {
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baeh
 * JD-Core Version:    0.7.0.1
 */